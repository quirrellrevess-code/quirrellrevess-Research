package com.mysql.jdbc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executor;
import okhttp3.internal.cache.DiskLruCache;

/* JADX INFO: loaded from: classes.dex */
public abstract class MultiHostConnectionProxy implements InvocationHandler {
    private static Constructor<?> JDBC_4_MS_CONNECTION_CTOR = null;
    private static final String METHOD_ABORT = "abort";
    private static final String METHOD_ABORT_INTERNAL = "abortInternal";
    private static final String METHOD_CLOSE = "close";
    private static final String METHOD_EQUALS = "equals";
    private static final String METHOD_GET_AUTO_COMMIT = "getAutoCommit";
    private static final String METHOD_GET_CATALOG = "getCatalog";
    private static final String METHOD_GET_MULTI_HOST_SAFE_PROXY = "getMultiHostSafeProxy";
    private static final String METHOD_GET_SESSION_MAX_ROWS = "getSessionMaxRows";
    private static final String METHOD_GET_TRANSACTION_ISOLATION = "getTransactionIsolation";
    private static final String METHOD_HASH_CODE = "hashCode";
    private static final String METHOD_IS_CLOSED = "isClosed";
    public boolean autoReconnect;
    public boolean closedExplicitly;
    public String closedReason;
    public MySQLConnection currentConnection;
    public List<String> hostList;
    public boolean isClosed;
    public Throwable lastExceptionDealtWith;
    public Properties localProps;
    public MySQLConnection proxyConnection;
    public MySQLConnection thisAsConnection;

    public class JdbcInterfaceProxy implements InvocationHandler {
        public Object invokeOn;

        public JdbcInterfaceProxy(Object obj) {
            this.invokeOn = null;
            this.invokeOn = obj;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Object objProxyIfReturnTypeIsJdbcInterface;
            if (MultiHostConnectionProxy.METHOD_EQUALS.equals(method.getName())) {
                return Boolean.valueOf(objArr[0].equals(this));
            }
            synchronized (MultiHostConnectionProxy.this) {
                Object objInvoke = null;
                try {
                    objInvoke = method.invoke(this.invokeOn, objArr);
                    objProxyIfReturnTypeIsJdbcInterface = MultiHostConnectionProxy.this.proxyIfReturnTypeIsJdbcInterface(method.getReturnType(), objInvoke);
                } catch (InvocationTargetException e) {
                    MultiHostConnectionProxy.this.dealWithInvocationException(e);
                    objProxyIfReturnTypeIsJdbcInterface = objInvoke;
                }
            }
            return objProxyIfReturnTypeIsJdbcInterface;
        }
    }

    static {
        if (Util.isJdbc4()) {
            try {
                JDBC_4_MS_CONNECTION_CTOR = Class.forName("com.mysql.jdbc.JDBC4MultiHostMySQLConnection").getConstructor(MultiHostConnectionProxy.class);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException(e2);
            } catch (SecurityException e3) {
                throw new RuntimeException(e3);
            }
        }
    }

    public MultiHostConnectionProxy() throws SQLException {
        this.autoReconnect = false;
        this.thisAsConnection = null;
        this.proxyConnection = null;
        this.currentConnection = null;
        this.isClosed = false;
        this.closedExplicitly = false;
        this.closedReason = null;
        this.lastExceptionDealtWith = null;
        this.thisAsConnection = getNewWrapperForThisAsConnection();
    }

    public boolean allowedOnClosedConnection(Method method) {
        String name = method.getName();
        return name.equals(METHOD_GET_AUTO_COMMIT) || name.equals(METHOD_GET_CATALOG) || name.equals(METHOD_GET_TRANSACTION_ISOLATION) || name.equals(METHOD_GET_SESSION_MAX_ROWS);
    }

    public synchronized ConnectionImpl createConnectionForHost(String str) throws SQLException {
        ConnectionImpl connectionImpl;
        Properties properties = (Properties) this.localProps.clone();
        String[] hostPortPair = NonRegisteringDriver.parseHostPortPair(str);
        String str2 = hostPortPair[0];
        String str3 = hostPortPair[1];
        String property = properties.getProperty(NonRegisteringDriver.DBNAME_PROPERTY_KEY);
        if (str2 == null) {
            throw new SQLException("Could not find a hostname to start a connection to");
        }
        if (str3 == null) {
            str3 = "3306";
        }
        properties.setProperty(NonRegisteringDriver.HOST_PROPERTY_KEY, str2);
        properties.setProperty(NonRegisteringDriver.PORT_PROPERTY_KEY, str3);
        properties.setProperty("HOST.1", str2);
        properties.setProperty("PORT.1", str3);
        properties.setProperty(NonRegisteringDriver.NUM_HOSTS_PROPERTY_KEY, DiskLruCache.VERSION_1);
        properties.setProperty("roundRobinLoadBalance", "false");
        connectionImpl = (ConnectionImpl) ConnectionImpl.getInstance(str2, Integer.parseInt(str3), properties, property, "jdbc:mysql://" + str2 + ":" + str3 + "/");
        connectionImpl.setProxy(getProxy());
        return connectionImpl;
    }

    public void dealWithInvocationException(InvocationTargetException invocationTargetException) throws Throwable {
        Throwable targetException = invocationTargetException.getTargetException();
        if (targetException == null) {
            throw invocationTargetException;
        }
        if (this.lastExceptionDealtWith == targetException || !shouldExceptionTriggerConnectionSwitch(targetException)) {
            throw targetException;
        }
        invalidateCurrentConnection();
        pickNewConnection();
        this.lastExceptionDealtWith = targetException;
        throw targetException;
    }

    public abstract void doAbort(Executor executor) throws SQLException;

    public abstract void doAbortInternal() throws SQLException;

    public abstract void doClose() throws SQLException;

    public InvocationHandler getNewJdbcInterfaceProxy(Object obj) {
        return new JdbcInterfaceProxy(obj);
    }

    public MySQLConnection getNewWrapperForThisAsConnection() throws SQLException {
        return (Util.isJdbc4() || JDBC_4_MS_CONNECTION_CTOR != null) ? (MySQLConnection) Util.handleNewInstance(JDBC_4_MS_CONNECTION_CTOR, new Object[]{this}, null) : new MultiHostMySQLConnection(this);
    }

    public MySQLConnection getProxy() {
        MySQLConnection mySQLConnection = this.proxyConnection;
        return mySQLConnection != null ? mySQLConnection : this.thisAsConnection;
    }

    public int initializeHostsSpecs(List<String> list, Properties properties) {
        int i = 0;
        this.autoReconnect = "true".equalsIgnoreCase(properties.getProperty("autoReconnect")) || "true".equalsIgnoreCase(properties.getProperty("autoReconnectForPools"));
        this.hostList = list;
        int size = list.size();
        Properties properties2 = (Properties) properties.clone();
        this.localProps = properties2;
        properties2.remove(NonRegisteringDriver.HOST_PROPERTY_KEY);
        this.localProps.remove(NonRegisteringDriver.PORT_PROPERTY_KEY);
        while (i < size) {
            Properties properties3 = this.localProps;
            StringBuilder sb = new StringBuilder();
            sb.append("HOST.");
            i++;
            sb.append(i);
            properties3.remove(sb.toString());
            this.localProps.remove("PORT." + i);
        }
        this.localProps.remove(NonRegisteringDriver.NUM_HOSTS_PROPERTY_KEY);
        return size;
    }

    public synchronized void invalidateConnection(MySQLConnection mySQLConnection) throws SQLException {
        if (mySQLConnection != null) {
            try {
                if (!mySQLConnection.isClosed()) {
                    mySQLConnection.realClose(true, !mySQLConnection.getAutoCommit(), true, null);
                }
            } catch (SQLException unused) {
            }
        }
    }

    public synchronized void invalidateCurrentConnection() throws SQLException {
        invalidateConnection(this.currentConnection);
    }

    @Override // java.lang.reflect.InvocationHandler
    public synchronized Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        String name = method.getName();
        if (METHOD_GET_MULTI_HOST_SAFE_PROXY.equals(name)) {
            return this.thisAsConnection;
        }
        if (METHOD_EQUALS.equals(name)) {
            return Boolean.valueOf(objArr[0].equals(this));
        }
        if (METHOD_HASH_CODE.equals(name)) {
            return Integer.valueOf(hashCode());
        }
        if (METHOD_CLOSE.equals(name)) {
            doClose();
            this.isClosed = true;
            this.closedReason = "Connection explicitly closed.";
            this.closedExplicitly = true;
            return null;
        }
        if (METHOD_ABORT_INTERNAL.equals(name)) {
            doAbortInternal();
            this.currentConnection.abortInternal();
            this.isClosed = true;
            this.closedReason = "Connection explicitly closed.";
            return null;
        }
        if (METHOD_ABORT.equals(name) && objArr.length == 1) {
            doAbort((Executor) objArr[0]);
            this.isClosed = true;
            this.closedReason = "Connection explicitly closed.";
            return null;
        }
        if (METHOD_IS_CLOSED.equals(name)) {
            return Boolean.valueOf(this.isClosed);
        }
        try {
            try {
                return invokeMore(obj, method, objArr);
            } catch (InvocationTargetException e) {
                if (e.getCause() != null) {
                    throw e.getCause();
                }
                throw e;
            }
        } catch (Exception e2) {
            for (Class<?> cls : method.getExceptionTypes()) {
                if (cls.isAssignableFrom(e2.getClass())) {
                    throw e2;
                }
            }
            throw new IllegalStateException(e2.getMessage(), e2);
        }
    }

    public abstract Object invokeMore(Object obj, Method method, Object[] objArr) throws Throwable;

    public abstract boolean isMasterConnection();

    public abstract void pickNewConnection() throws SQLException;

    public void propagateProxyDown(MySQLConnection mySQLConnection) {
        this.currentConnection.setProxy(mySQLConnection);
    }

    public Object proxyIfReturnTypeIsJdbcInterface(Class<?> cls, Object obj) {
        if (obj == null || !Util.isJdbcInterface(cls)) {
            return obj;
        }
        Class<?> cls2 = obj.getClass();
        return Proxy.newProxyInstance(cls2.getClassLoader(), Util.getImplementedInterfaces(cls2), getNewJdbcInterfaceProxy(obj));
    }

    public final void setProxy(MySQLConnection mySQLConnection) {
        this.proxyConnection = mySQLConnection;
        propagateProxyDown(mySQLConnection);
    }

    public abstract boolean shouldExceptionTriggerConnectionSwitch(Throwable th);

    public void syncSessionState(Connection connection, Connection connection2) throws SQLException {
        if (connection == null || connection2 == null) {
            return;
        }
        boolean useLocalSessionState = connection.getUseLocalSessionState();
        connection.setUseLocalSessionState(true);
        boolean zIsReadOnly = connection.isReadOnly();
        connection.setUseLocalSessionState(useLocalSessionState);
        syncSessionState(connection, connection2, zIsReadOnly);
    }

    public void syncSessionState(Connection connection, Connection connection2, boolean z) throws SQLException {
        if (connection2 != null) {
            connection2.setReadOnly(z);
        }
        if (connection == null || connection2 == null) {
            return;
        }
        boolean useLocalSessionState = connection.getUseLocalSessionState();
        connection.setUseLocalSessionState(true);
        connection2.setAutoCommit(connection.getAutoCommit());
        connection2.setCatalog(connection.getCatalog());
        connection2.setTransactionIsolation(connection.getTransactionIsolation());
        connection2.setSessionMaxRows(connection.getSessionMaxRows());
        connection.setUseLocalSessionState(useLocalSessionState);
    }

    public MultiHostConnectionProxy(List<String> list, Properties properties) throws SQLException {
        this();
        initializeHostsSpecs(list, properties);
    }
}
