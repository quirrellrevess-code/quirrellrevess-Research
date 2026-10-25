package com.mysql.jdbc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class FailoverConnectionProxy extends MultiHostConnectionProxy {
    private static final int DEFAULT_PRIMARY_HOST_INDEX = 0;
    private static Class<?>[] INTERFACES_TO_PROXY = null;
    private static final String METHOD_COMMIT = "commit";
    private static final String METHOD_ROLLBACK = "rollback";
    private static final String METHOD_SET_AUTO_COMMIT = "setAutoCommit";
    private static final String METHOD_SET_READ_ONLY = "setReadOnly";
    private static final int NO_CONNECTION_INDEX = -1;
    private int currentHostIndex;
    private boolean enableFallBackToPrimaryHost;
    private boolean explicitlyAutoCommit;
    private Boolean explicitlyReadOnly;
    private boolean failoverReadOnly;
    private long primaryHostFailTimeMillis;
    private int primaryHostIndex;
    private long queriesBeforeRetryPrimaryHost;
    private long queriesIssuedSinceFailover;
    private int retriesAllDown;
    private int secondsBeforeRetryPrimaryHost;

    public class FailoverJdbcInterfaceProxy extends MultiHostConnectionProxy.JdbcInterfaceProxy {
        public FailoverJdbcInterfaceProxy(Object obj) {
            super(obj);
        }

        @Override // com.mysql.jdbc.MultiHostConnectionProxy.JdbcInterfaceProxy, java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            boolean zStartsWith = method.getName().startsWith("execute");
            if (FailoverConnectionProxy.this.connectedToSecondaryHost() && zStartsWith) {
                FailoverConnectionProxy.this.incrementQueriesIssuedSinceFailover();
            }
            Object objInvoke = super.invoke(obj, method, objArr);
            if (FailoverConnectionProxy.this.explicitlyAutoCommit && zStartsWith && FailoverConnectionProxy.this.readyToFallBackToPrimaryHost()) {
                FailoverConnectionProxy.this.fallBackToPrimaryIfAvailable();
            }
            return objInvoke;
        }
    }

    static {
        if (!Util.isJdbc4()) {
            INTERFACES_TO_PROXY = new Class[]{MySQLConnection.class};
            return;
        }
        try {
            INTERFACES_TO_PROXY = new Class[]{Class.forName("com.mysql.jdbc.JDBC4MySQLConnection")};
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private FailoverConnectionProxy(List<String> list, Properties properties) throws SQLException {
        super(list, properties);
        this.currentHostIndex = -1;
        this.primaryHostIndex = 0;
        this.explicitlyReadOnly = null;
        this.explicitlyAutoCommit = true;
        this.enableFallBackToPrimaryHost = true;
        this.primaryHostFailTimeMillis = 0L;
        this.queriesIssuedSinceFailover = 0L;
        ConnectionPropertiesImpl connectionPropertiesImpl = new ConnectionPropertiesImpl();
        connectionPropertiesImpl.initializeProperties(properties);
        this.secondsBeforeRetryPrimaryHost = connectionPropertiesImpl.getSecondsBeforeRetryMaster();
        this.queriesBeforeRetryPrimaryHost = connectionPropertiesImpl.getQueriesBeforeRetryMaster();
        this.failoverReadOnly = connectionPropertiesImpl.getFailOverReadOnly();
        this.retriesAllDown = connectionPropertiesImpl.getRetriesAllDown();
        this.enableFallBackToPrimaryHost = this.secondsBeforeRetryPrimaryHost > 0 || this.queriesBeforeRetryPrimaryHost > 0;
        pickNewConnection();
        this.explicitlyAutoCommit = this.currentConnection.getAutoCommit();
    }

    private synchronized void connectTo(int i) throws SQLException {
        try {
            switchCurrentConnectionTo(i, createConnectionForHostIndex(i));
        } catch (SQLException e) {
            if (this.currentConnection != null) {
                StringBuilder sb = new StringBuilder("Connection to ");
                sb.append(isPrimaryHostIndex(i) ? "primary" : "secondary");
                sb.append(" host '");
                sb.append(this.hostList.get(i));
                sb.append("' failed");
                this.currentConnection.getLog().logWarn(sb.toString(), e);
            }
            throw e;
        }
    }

    public static Connection createProxyInstance(List<String> list, Properties properties) throws SQLException {
        return (Connection) Proxy.newProxyInstance(Connection.class.getClassLoader(), INTERFACES_TO_PROXY, new FailoverConnectionProxy(list, properties));
    }

    private synchronized void failOver() throws SQLException {
        failOver(this.currentHostIndex);
    }

    private int nextHost(int i, boolean z) {
        int size = (i + 1) % this.hostList.size();
        return (isPrimaryHostIndex(size) && isConnected() && !z && this.enableFallBackToPrimaryHost && !readyToFallBackToPrimaryHost()) ? nextHost(size, z) : size;
    }

    private synchronized boolean queriesBeforeRetryPrimaryHostIsMet() {
        long j;
        j = this.queriesBeforeRetryPrimaryHost;
        return j > 0 && this.queriesIssuedSinceFailover >= j;
    }

    private synchronized void resetAutoFallBackCounters() {
        this.primaryHostFailTimeMillis = System.currentTimeMillis();
        this.queriesIssuedSinceFailover = 0L;
    }

    private synchronized boolean secondsBeforeRetryPrimaryHostIsMet() {
        return this.secondsBeforeRetryPrimaryHost > 0 && Util.secondsSinceMillis(this.primaryHostFailTimeMillis) >= ((long) this.secondsBeforeRetryPrimaryHost);
    }

    private synchronized void switchCurrentConnectionTo(int i, MySQLConnection mySQLConnection) throws SQLException {
        invalidateCurrentConnection();
        boolean zIsReadOnly = false;
        if (isPrimaryHostIndex(i)) {
            Boolean bool = this.explicitlyReadOnly;
            if (bool != null) {
                zIsReadOnly = bool.booleanValue();
            }
        } else if (this.failoverReadOnly) {
            zIsReadOnly = true;
        } else {
            Boolean bool2 = this.explicitlyReadOnly;
            if (bool2 != null) {
                zIsReadOnly = bool2.booleanValue();
            } else {
                MySQLConnection mySQLConnection2 = this.currentConnection;
                if (mySQLConnection2 != null) {
                    zIsReadOnly = mySQLConnection2.isReadOnly();
                }
            }
        }
        syncSessionState(this.currentConnection, mySQLConnection, zIsReadOnly);
        this.currentConnection = mySQLConnection;
        this.currentHostIndex = i;
    }

    public synchronized boolean connectedToPrimaryHost() {
        return isPrimaryHostIndex(this.currentHostIndex);
    }

    public synchronized boolean connectedToSecondaryHost() {
        int i;
        i = this.currentHostIndex;
        return i >= 0 && !isPrimaryHostIndex(i);
    }

    public synchronized ConnectionImpl createConnectionForHostIndex(int i) throws SQLException {
        return createConnectionForHost(this.hostList.get(i));
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public synchronized void doAbort(Executor executor) throws SQLException {
        this.currentConnection.abort(executor);
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public synchronized void doAbortInternal() throws SQLException {
        this.currentConnection.abortInternal();
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public synchronized void doClose() throws SQLException {
        this.currentConnection.close();
    }

    public synchronized void fallBackToPrimaryIfAvailable() {
        ConnectionImpl connectionImplCreateConnectionForHostIndex = null;
        try {
            connectionImplCreateConnectionForHostIndex = createConnectionForHostIndex(this.primaryHostIndex);
            switchCurrentConnectionTo(this.primaryHostIndex, connectionImplCreateConnectionForHostIndex);
        } catch (SQLException unused) {
            if (connectionImplCreateConnectionForHostIndex != null) {
                try {
                    connectionImplCreateConnectionForHostIndex.close();
                } catch (SQLException unused2) {
                }
            }
            resetAutoFallBackCounters();
        }
    }

    public synchronized void incrementQueriesIssuedSinceFailover() {
        this.queriesIssuedSinceFailover++;
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public synchronized Object invokeMore(Object obj, Method method, Object[] objArr) throws Throwable {
        Object objProxyIfReturnTypeIsJdbcInterface;
        String name = method.getName();
        Object objInvoke = null;
        if (METHOD_SET_READ_ONLY.equals(name)) {
            this.explicitlyReadOnly = (Boolean) objArr[0];
            if (this.failoverReadOnly && connectedToSecondaryHost()) {
                return null;
            }
        }
        if (this.isClosed && !allowedOnClosedConnection(method)) {
            if (!this.autoReconnect || this.closedExplicitly) {
                String str = "No operations allowed after connection closed.";
                if (this.closedReason != null) {
                    str = "No operations allowed after connection closed.  " + this.closedReason;
                }
                throw SQLError.createSQLException(str, SQLError.SQL_STATE_CONNECTION_NOT_OPEN, (ExceptionInterceptor) null);
            }
            this.currentHostIndex = -1;
            pickNewConnection();
            this.isClosed = false;
            this.closedReason = null;
        }
        try {
            objInvoke = method.invoke(this.thisAsConnection, objArr);
            objProxyIfReturnTypeIsJdbcInterface = proxyIfReturnTypeIsJdbcInterface(method.getReturnType(), objInvoke);
        } catch (InvocationTargetException e) {
            dealWithInvocationException(e);
            objProxyIfReturnTypeIsJdbcInterface = objInvoke;
        }
        if (METHOD_SET_AUTO_COMMIT.equals(name)) {
            this.explicitlyAutoCommit = ((Boolean) objArr[0]).booleanValue();
        }
        if ((this.explicitlyAutoCommit || METHOD_COMMIT.equals(name) || METHOD_ROLLBACK.equals(name)) && readyToFallBackToPrimaryHost()) {
            fallBackToPrimaryIfAvailable();
        }
        return objProxyIfReturnTypeIsJdbcInterface;
    }

    public synchronized boolean isConnected() {
        return this.currentHostIndex != -1;
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public boolean isMasterConnection() {
        return connectedToPrimaryHost();
    }

    public synchronized boolean isPrimaryHostIndex(int i) {
        return i == this.primaryHostIndex;
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public synchronized void pickNewConnection() throws SQLException {
        if (this.isClosed && this.closedExplicitly) {
            return;
        }
        if (!isConnected() || readyToFallBackToPrimaryHost()) {
            try {
                connectTo(this.primaryHostIndex);
            } catch (SQLException unused) {
                resetAutoFallBackCounters();
                failOver(this.primaryHostIndex);
            }
        } else {
            failOver();
        }
    }

    public synchronized boolean readyToFallBackToPrimaryHost() {
        return this.enableFallBackToPrimaryHost && connectedToSecondaryHost() && (secondsBeforeRetryPrimaryHostIsMet() || queriesBeforeRetryPrimaryHostIsMet());
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public boolean shouldExceptionTriggerConnectionSwitch(Throwable th) {
        if (!(th instanceof SQLException)) {
            return false;
        }
        String sQLState = ((SQLException) th).getSQLState();
        return (sQLState != null && sQLState.startsWith("08")) || (th instanceof CommunicationsException);
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public MultiHostConnectionProxy.JdbcInterfaceProxy getNewJdbcInterfaceProxy(Object obj) {
        return new FailoverJdbcInterfaceProxy(obj);
    }

    private synchronized void failOver(int i) throws SQLException {
        int i2 = this.currentHostIndex;
        int iNextHost = nextHost(i, false);
        SQLException e = null;
        boolean zIsPrimaryHostIndex = i2 == -1 || isPrimaryHostIndex(i2);
        int iNextHost2 = iNextHost;
        int i3 = 0;
        boolean z = false;
        do {
            if (!zIsPrimaryHostIndex) {
                try {
                    zIsPrimaryHostIndex = isPrimaryHostIndex(iNextHost2);
                    zIsPrimaryHostIndex = zIsPrimaryHostIndex;
                } catch (SQLException e2) {
                    e = e2;
                    if (shouldExceptionTriggerConnectionSwitch(e)) {
                        int iNextHost3 = nextHost(iNextHost2, i3 > 0);
                        if (iNextHost3 == iNextHost) {
                            iNextHost2 = nextHost(iNextHost2, true);
                            if (iNextHost3 == iNextHost2) {
                                i3++;
                                try {
                                    Thread.sleep(250L);
                                } catch (InterruptedException unused) {
                                }
                            }
                        } else {
                            iNextHost2 = iNextHost3;
                        }
                    } else {
                        throw e;
                    }
                }
            }
            connectTo(iNextHost2);
            if (zIsPrimaryHostIndex && connectedToSecondaryHost()) {
                resetAutoFallBackCounters();
            }
            z = true;
            if (i3 >= this.retriesAllDown) {
                break;
            }
        } while (!z);
        if (!z) {
            throw e;
        }
    }
}
