package com.mysql.jdbc;

import com.google.android.flexbox.BuildConfig;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class LoadBalancedConnectionProxy extends MultiHostConnectionProxy implements PingTarget {
    public static final String BLACKLIST_TIMEOUT_PROPERTY_KEY = "loadBalanceBlacklistTimeout";
    public static final String HOST_REMOVAL_GRACE_PERIOD_PROPERTY_KEY = "loadBalanceHostRemovalGracePeriod";
    private static Class<?>[] INTERFACES_TO_PROXY;
    private static Constructor<?> JDBC_4_LB_CONNECTION_CTOR;
    private static Map<String, Long> globalBlacklist = new HashMap();
    private static LoadBalancedConnection nullLBConnectionInstance;
    private int autoCommitSwapThreshold;
    private BalanceStrategy balancer;
    private ConnectionGroup connectionGroup;
    private long connectionGroupProxyID;
    private Map<ConnectionImpl, String> connectionsToHostsMap;
    private LoadBalanceExceptionChecker exceptionChecker;
    private int globalBlacklistTimeout;
    private int hostRemovalGracePeriod;
    private Map<String, Integer> hostsToListIndexMap;
    public Map<String, ConnectionImpl> liveConnections;
    private long[] responseTimes;
    private int retriesAllDown;
    private long totalPhysicalConnections = 0;
    private Set<String> hostsToRemove = new HashSet();
    private boolean inTransaction = false;
    private long transactionStartTime = 0;
    private long transactionCount = 0;

    public static class NullLoadBalancedConnectionProxy implements InvocationHandler {
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(Messages.getString("LoadBalancedConnectionProxy.unusableConnection"), SQLError.SQL_STATE_INVALID_TRANSACTION_STATE, MysqlErrorNumbers.ERROR_CODE_NULL_LOAD_BALANCED_CONNECTION, true, (ExceptionInterceptor) null);
            for (Class<?> cls : method.getExceptionTypes()) {
                if (cls.isAssignableFrom(sQLExceptionCreateSQLException.getClass())) {
                    throw sQLExceptionCreateSQLException;
                }
            }
            throw new IllegalStateException(sQLExceptionCreateSQLException.getMessage(), sQLExceptionCreateSQLException);
        }
    }

    static {
        if (Util.isJdbc4()) {
            try {
                JDBC_4_LB_CONNECTION_CTOR = Class.forName("com.mysql.jdbc.JDBC4LoadBalancedMySQLConnection").getConstructor(LoadBalancedConnectionProxy.class);
                INTERFACES_TO_PROXY = new Class[]{LoadBalancedConnection.class, Class.forName("com.mysql.jdbc.JDBC4MySQLConnection")};
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException(e2);
            } catch (SecurityException e3) {
                throw new RuntimeException(e3);
            }
        } else {
            INTERFACES_TO_PROXY = new Class[]{LoadBalancedConnection.class};
        }
        nullLBConnectionInstance = null;
    }

    private LoadBalancedConnectionProxy(List<String> list, Properties properties) throws SQLException {
        this.connectionGroup = null;
        this.connectionGroupProxyID = 0L;
        this.autoCommitSwapThreshold = 0;
        this.globalBlacklistTimeout = 0;
        this.hostRemovalGracePeriod = 0;
        String property = properties.getProperty("loadBalanceConnectionGroup", null);
        String property2 = properties.getProperty("loadBalanceEnableJMX", "false");
        try {
            boolean z = Boolean.parseBoolean(property2);
            if (property != null) {
                this.connectionGroup = ConnectionGroupManager.getConnectionGroupInstance(property);
                if (z) {
                    ConnectionGroupManager.registerJmx();
                }
                this.connectionGroupProxyID = this.connectionGroup.registerConnectionProxy(this, list);
                list = new ArrayList<>(this.connectionGroup.getInitialHosts());
            }
            int iInitializeHostsSpecs = initializeHostsSpecs(list, properties);
            this.liveConnections = new HashMap(iInitializeHostsSpecs);
            this.hostsToListIndexMap = new HashMap(iInitializeHostsSpecs);
            for (int i = 0; i < iInitializeHostsSpecs; i++) {
                this.hostsToListIndexMap.put(this.hostList.get(i), Integer.valueOf(i));
            }
            this.connectionsToHostsMap = new HashMap(iInitializeHostsSpecs);
            this.responseTimes = new long[iInitializeHostsSpecs];
            String property3 = this.localProps.getProperty("retriesAllDown", "120");
            try {
                this.retriesAllDown = Integer.parseInt(property3);
                String property4 = this.localProps.getProperty(BLACKLIST_TIMEOUT_PROPERTY_KEY, "0");
                try {
                    this.globalBlacklistTimeout = Integer.parseInt(property4);
                    String property5 = this.localProps.getProperty(HOST_REMOVAL_GRACE_PERIOD_PROPERTY_KEY, "15000");
                    try {
                        this.hostRemovalGracePeriod = Integer.parseInt(property5);
                        String property6 = this.localProps.getProperty("loadBalanceStrategy", "random");
                        if ("random".equals(property6)) {
                            this.balancer = (BalanceStrategy) Util.loadExtensions(null, properties, RandomBalanceStrategy.class.getName(), "InvalidLoadBalanceStrategy", null).get(0);
                        } else if ("bestResponseTime".equals(property6)) {
                            this.balancer = (BalanceStrategy) Util.loadExtensions(null, properties, BestResponseTimeBalanceStrategy.class.getName(), "InvalidLoadBalanceStrategy", null).get(0);
                        } else if ("serverAffinity".equals(property6)) {
                            this.balancer = (BalanceStrategy) Util.loadExtensions(null, properties, ServerAffinityStrategy.class.getName(), "InvalidLoadBalanceStrategy", null).get(0);
                        } else {
                            this.balancer = (BalanceStrategy) Util.loadExtensions(null, properties, property6, "InvalidLoadBalanceStrategy", null).get(0);
                        }
                        String property7 = properties.getProperty("loadBalanceAutoCommitStatementThreshold", "0");
                        try {
                            this.autoCommitSwapThreshold = Integer.parseInt(property7);
                            String property8 = properties.getProperty("loadBalanceAutoCommitStatementRegex", BuildConfig.FLAVOR);
                            if (!BuildConfig.FLAVOR.equals(property8)) {
                                try {
                                    BuildConfig.FLAVOR.matches(property8);
                                } catch (Exception unused) {
                                    throw SQLError.createSQLException(Messages.getString("LoadBalancedConnectionProxy.badValueForLoadBalanceAutoCommitStatementRegex", new Object[]{property8}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
                                }
                            }
                            if (this.autoCommitSwapThreshold > 0) {
                                String property9 = this.localProps.getProperty("statementInterceptors");
                                if (property9 == null) {
                                    this.localProps.setProperty("statementInterceptors", "com.mysql.jdbc.LoadBalancedAutoCommitInterceptor");
                                } else if (property9.length() > 0) {
                                    this.localProps.setProperty("statementInterceptors", property9 + ",com.mysql.jdbc.LoadBalancedAutoCommitInterceptor");
                                }
                                properties.setProperty("statementInterceptors", this.localProps.getProperty("statementInterceptors"));
                            }
                            this.balancer.init(null, properties);
                            this.exceptionChecker = (LoadBalanceExceptionChecker) Util.loadExtensions(null, properties, this.localProps.getProperty("loadBalanceExceptionChecker", "com.mysql.jdbc.StandardLoadBalanceExceptionChecker"), "InvalidLoadBalanceExceptionChecker", null).get(0);
                            pickNewConnection();
                        } catch (NumberFormatException unused2) {
                            throw SQLError.createSQLException(Messages.getString("LoadBalancedConnectionProxy.badValueForLoadBalanceAutoCommitStatementThreshold", new Object[]{property7}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
                        }
                    } catch (NumberFormatException unused3) {
                        throw SQLError.createSQLException(Messages.getString("LoadBalancedConnectionProxy.badValueForLoadBalanceHostRemovalGracePeriod", new Object[]{property5}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
                    }
                } catch (NumberFormatException unused4) {
                    throw SQLError.createSQLException(Messages.getString("LoadBalancedConnectionProxy.badValueForLoadBalanceBlacklistTimeout", new Object[]{property4}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
                }
            } catch (NumberFormatException unused5) {
                throw SQLError.createSQLException(Messages.getString("LoadBalancedConnectionProxy.badValueForRetriesAllDown", new Object[]{property3}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
            }
        } catch (Exception unused6) {
            throw SQLError.createSQLException(Messages.getString("LoadBalancedConnectionProxy.badValueForLoadBalanceEnableJMX", new Object[]{property2}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
        }
    }

    private synchronized void closeAllConnections() {
        Iterator<ConnectionImpl> it = this.liveConnections.values().iterator();
        while (it.hasNext()) {
            try {
                it.next().close();
            } catch (SQLException unused) {
            }
        }
        if (!this.isClosed) {
            this.balancer.destroy();
            ConnectionGroup connectionGroup = this.connectionGroup;
            if (connectionGroup != null) {
                connectionGroup.closeConnectionProxy(this);
            }
        }
        this.liveConnections.clear();
        this.connectionsToHostsMap.clear();
    }

    public static LoadBalancedConnection createProxyInstance(List<String> list, Properties properties) throws SQLException {
        return (LoadBalancedConnection) Proxy.newProxyInstance(LoadBalancedConnection.class.getClassLoader(), INTERFACES_TO_PROXY, new LoadBalancedConnectionProxy(list, properties));
    }

    public static synchronized LoadBalancedConnection getNullLoadBalancedConnectionInstance() {
        if (nullLBConnectionInstance == null) {
            nullLBConnectionInstance = (LoadBalancedConnection) Proxy.newProxyInstance(LoadBalancedConnection.class.getClassLoader(), INTERFACES_TO_PROXY, new NullLoadBalancedConnectionProxy());
        }
        return nullLBConnectionInstance;
    }

    public synchronized boolean addHost(String str) {
        if (this.hostsToListIndexMap.containsKey(str)) {
            return false;
        }
        long[] jArr = this.responseTimes;
        long[] jArr2 = new long[jArr.length + 1];
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        this.responseTimes = jArr2;
        if (!this.hostList.contains(str)) {
            this.hostList.add(str);
        }
        this.hostsToListIndexMap.put(str, Integer.valueOf(this.responseTimes.length - 1));
        this.hostsToRemove.remove(str);
        return true;
    }

    public void addToGlobalBlacklist(String str, long j) {
        if (isGlobalBlacklistEnabled()) {
            synchronized (globalBlacklist) {
                globalBlacklist.put(str, Long.valueOf(j));
            }
        }
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public synchronized ConnectionImpl createConnectionForHost(String str) throws SQLException {
        ConnectionImpl connectionImplCreateConnectionForHost;
        connectionImplCreateConnectionForHost = super.createConnectionForHost(str);
        this.liveConnections.put(str, connectionImplCreateConnectionForHost);
        this.connectionsToHostsMap.put(connectionImplCreateConnectionForHost, str);
        this.totalPhysicalConnections++;
        for (StatementInterceptorV2 statementInterceptorV2 : connectionImplCreateConnectionForHost.getStatementInterceptorsInstances()) {
            if (statementInterceptorV2 instanceof LoadBalancedAutoCommitInterceptor) {
                ((LoadBalancedAutoCommitInterceptor) statementInterceptorV2).resumeCounters();
                break;
            }
        }
        return connectionImplCreateConnectionForHost;
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public synchronized void doAbort(Executor executor) {
        Iterator<ConnectionImpl> it = this.liveConnections.values().iterator();
        while (it.hasNext()) {
            try {
                it.next().abort(executor);
            } catch (SQLException unused) {
            }
        }
        if (!this.isClosed) {
            this.balancer.destroy();
            ConnectionGroup connectionGroup = this.connectionGroup;
            if (connectionGroup != null) {
                connectionGroup.closeConnectionProxy(this);
            }
        }
        this.liveConnections.clear();
        this.connectionsToHostsMap.clear();
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public synchronized void doAbortInternal() {
        Iterator<ConnectionImpl> it = this.liveConnections.values().iterator();
        while (it.hasNext()) {
            try {
                it.next().abortInternal();
            } catch (SQLException unused) {
            }
        }
        if (!this.isClosed) {
            this.balancer.destroy();
            ConnectionGroup connectionGroup = this.connectionGroup;
            if (connectionGroup != null) {
                connectionGroup.closeConnectionProxy(this);
            }
        }
        this.liveConnections.clear();
        this.connectionsToHostsMap.clear();
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public synchronized void doClose() {
        closeAllConnections();
    }

    @Override // com.mysql.jdbc.PingTarget
    public synchronized void doPing() throws SQLException {
        SQLException sQLException = null;
        boolean z = false;
        int loadBalancePingTimeout = this.currentConnection.getLoadBalancePingTimeout();
        for (String str : this.hostList) {
            ConnectionImpl connectionImpl = this.liveConnections.get(str);
            if (connectionImpl != null) {
                if (loadBalancePingTimeout == 0) {
                    try {
                        connectionImpl.ping();
                    } catch (SQLException e) {
                        if (str.equals(this.connectionsToHostsMap.get(this.currentConnection))) {
                            closeAllConnections();
                            this.isClosed = true;
                            this.closedReason = "Connection closed because ping of current connection failed.";
                            throw e;
                        }
                        if (e.getMessage().equals(Messages.getString("Connection.exceededConnectionLifetime"))) {
                            if (sQLException == null) {
                            }
                            this.liveConnections.remove(this.connectionsToHostsMap.get(connectionImpl));
                        } else if (isGlobalBlacklistEnabled()) {
                            addToGlobalBlacklist(str);
                        }
                        sQLException = e;
                        this.liveConnections.remove(this.connectionsToHostsMap.get(connectionImpl));
                    }
                } else {
                    connectionImpl.pingInternal(true, loadBalancePingTimeout);
                }
                z = true;
            }
        }
        if (!z) {
            closeAllConnections();
            this.isClosed = true;
            this.closedReason = "Connection closed due to inability to ping any active connections.";
            if (sQLException != null) {
                throw sQLException;
            }
            ((ConnectionImpl) this.currentConnection).throwConnectionClosedException();
        }
    }

    public synchronized long getActivePhysicalConnectionCount() {
        return this.liveConnections.size();
    }

    public synchronized long getConnectionGroupProxyID() {
        return this.connectionGroupProxyID;
    }

    public synchronized String getCurrentActiveHost() {
        String str;
        MySQLConnection mySQLConnection = this.currentConnection;
        if (mySQLConnection == null || (str = this.connectionsToHostsMap.get(mySQLConnection)) == null) {
            return null;
        }
        return str.toString();
    }

    public synchronized long getCurrentTransactionDuration() {
        if (!this.inTransaction || this.transactionStartTime <= 0) {
            return 0L;
        }
        return System.nanoTime() - this.transactionStartTime;
    }

    public synchronized Map<String, Long> getGlobalBlacklist() {
        if (!isGlobalBlacklistEnabled()) {
            if (this.hostsToRemove.isEmpty()) {
                return new HashMap(1);
            }
            HashMap map = new HashMap();
            Iterator<String> it = this.hostsToRemove.iterator();
            while (it.hasNext()) {
                map.put(it.next(), Long.valueOf(System.currentTimeMillis() + 5000));
            }
            return map;
        }
        HashMap map2 = new HashMap(globalBlacklist.size());
        synchronized (globalBlacklist) {
            map2.putAll(globalBlacklist);
        }
        Set setKeySet = map2.keySet();
        setKeySet.retainAll(this.hostList);
        Iterator it2 = setKeySet.iterator();
        while (it2.hasNext()) {
            String str = (String) it2.next();
            Long l = globalBlacklist.get(str);
            if (l != null && l.longValue() < System.currentTimeMillis()) {
                synchronized (globalBlacklist) {
                    globalBlacklist.remove(str);
                }
                it2.remove();
            }
        }
        if (setKeySet.size() != this.hostList.size()) {
            return map2;
        }
        return new HashMap(1);
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public MySQLConnection getNewWrapperForThisAsConnection() throws SQLException {
        return (Util.isJdbc4() || JDBC_4_LB_CONNECTION_CTOR != null) ? (MySQLConnection) Util.handleNewInstance(JDBC_4_LB_CONNECTION_CTOR, new Object[]{this}, null) : new LoadBalancedMySQLConnection(this);
    }

    public synchronized long getTotalPhysicalConnectionCount() {
        return this.totalPhysicalConnections;
    }

    public synchronized long getTransactionCount() {
        return this.transactionCount;
    }

    public synchronized boolean inTransaction() {
        return this.inTransaction;
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public synchronized void invalidateConnection(MySQLConnection mySQLConnection) throws SQLException {
        super.invalidateConnection(mySQLConnection);
        if (isGlobalBlacklistEnabled()) {
            addToGlobalBlacklist(this.connectionsToHostsMap.get(mySQLConnection));
        }
        this.liveConnections.remove(this.connectionsToHostsMap.get(mySQLConnection));
        String strRemove = this.connectionsToHostsMap.remove(mySQLConnection);
        if (strRemove != null && this.hostsToListIndexMap.containsKey(strRemove)) {
            int iIntValue = this.hostsToListIndexMap.get(strRemove).intValue();
            synchronized (this.responseTimes) {
                this.responseTimes[iIntValue] = 0;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x0099 A[Catch: all -> 0x015d, TryCatch #3 {, blocks: (B:3:0x0001, B:5:0x000b, B:7:0x0011, B:9:0x0018, B:11:0x001c, B:13:0x0020, B:14:0x002a, B:16:0x0030, B:17:0x0046, B:18:0x004c, B:19:0x004d, B:21:0x0051, B:28:0x007b, B:30:0x0083, B:32:0x008b, B:34:0x0099, B:35:0x009b, B:45:0x00c0, B:46:0x00c1, B:72:0x0113, B:74:0x011b, B:91:0x015c, B:76:0x0123, B:78:0x0131, B:79:0x0133, B:89:0x0158, B:90:0x0159, B:52:0x00cb, B:54:0x00d3, B:56:0x00db, B:58:0x00e9, B:59:0x00eb, B:69:0x0110, B:22:0x0061, B:24:0x0069, B:26:0x006d, B:27:0x0073, B:51:0x00c8, B:80:0x0134, B:82:0x013e, B:84:0x0147, B:85:0x0154, B:60:0x00ec, B:62:0x00f6, B:64:0x00ff, B:65:0x010c, B:36:0x009c, B:38:0x00a6, B:40:0x00af, B:41:0x00bc), top: B:99:0x0001, inners: #0, #1, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00a6 A[Catch: all -> 0x00be, TryCatch #5 {, blocks: (B:36:0x009c, B:38:0x00a6, B:40:0x00af, B:41:0x00bc), top: B:102:0x009c, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00af A[Catch: all -> 0x00be, TryCatch #5 {, blocks: (B:36:0x009c, B:38:0x00a6, B:40:0x00af, B:41:0x00bc), top: B:102:0x009c, outer: #3 }] */
    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public synchronized Object invokeMore(Object obj, Method method, Object[] objArr) throws Throwable {
        Object objInvoke;
        String str;
        Integer num;
        int iIntValue;
        long[] jArr;
        String name = method.getName();
        objInvoke = null;
        if (this.isClosed && !allowedOnClosedConnection(method) && method.getExceptionTypes().length > 0) {
            if (!this.autoReconnect || this.closedExplicitly) {
                String str2 = "No operations allowed after connection closed.";
                if (this.closedReason != null) {
                    str2 = "No operations allowed after connection closed. " + this.closedReason;
                }
                throw SQLError.createSQLException(str2, SQLError.SQL_STATE_CONNECTION_NOT_OPEN, (ExceptionInterceptor) null);
            }
            this.currentConnection = null;
            pickNewConnection();
            this.isClosed = false;
            this.closedReason = null;
        }
        if (!this.inTransaction) {
            this.inTransaction = true;
            this.transactionStartTime = System.nanoTime();
            this.transactionCount++;
        }
        try {
            try {
                objInvoke = method.invoke(this.thisAsConnection, objArr);
                if (objInvoke != null) {
                    if (objInvoke instanceof Statement) {
                        ((Statement) objInvoke).setPingTarget(this);
                    }
                    objInvoke = proxyIfReturnTypeIsJdbcInterface(method.getReturnType(), objInvoke);
                    if (!"commit".equals(name)) {
                    }
                    this.inTransaction = false;
                    str = this.connectionsToHostsMap.get(this.currentConnection);
                    if (str != null) {
                        synchronized (this.responseTimes) {
                            num = this.hostsToListIndexMap.get(str);
                            if (num != null) {
                                iIntValue = num.intValue();
                                jArr = this.responseTimes;
                                if (iIntValue < jArr.length) {
                                    jArr[num.intValue()] = System.nanoTime() - this.transactionStartTime;
                                }
                            }
                        }
                    }
                    pickNewConnection();
                } else if (!"commit".equals(name) || "rollback".equals(name)) {
                    this.inTransaction = false;
                    str = this.connectionsToHostsMap.get(this.currentConnection);
                    if (str != null) {
                        synchronized (this.responseTimes) {
                            num = this.hostsToListIndexMap.get(str);
                            if (num != null) {
                                iIntValue = num.intValue();
                                jArr = this.responseTimes;
                                if (iIntValue < jArr.length) {
                                    jArr[num.intValue()] = System.nanoTime() - this.transactionStartTime;
                                }
                            }
                        }
                    }
                    pickNewConnection();
                }
            } catch (InvocationTargetException e) {
                dealWithInvocationException(e);
                if ("commit".equals(name) || "rollback".equals(name)) {
                    this.inTransaction = false;
                    String str3 = this.connectionsToHostsMap.get(this.currentConnection);
                    if (str3 != null) {
                        synchronized (this.responseTimes) {
                            Integer num2 = this.hostsToListIndexMap.get(str3);
                            if (num2 != null) {
                                int iIntValue2 = num2.intValue();
                                long[] jArr2 = this.responseTimes;
                                if (iIntValue2 < jArr2.length) {
                                    jArr2[num2.intValue()] = System.nanoTime() - this.transactionStartTime;
                                }
                            }
                        }
                    }
                    pickNewConnection();
                }
            }
        } catch (Throwable th) {
            if ("commit".equals(name) || "rollback".equals(name)) {
                this.inTransaction = false;
                String str4 = this.connectionsToHostsMap.get(this.currentConnection);
                if (str4 != null) {
                    synchronized (this.responseTimes) {
                        Integer num3 = this.hostsToListIndexMap.get(str4);
                        if (num3 != null) {
                            int iIntValue3 = num3.intValue();
                            long[] jArr3 = this.responseTimes;
                            if (iIntValue3 < jArr3.length) {
                                jArr3[num3.intValue()] = System.nanoTime() - this.transactionStartTime;
                            }
                        }
                    }
                }
                pickNewConnection();
            }
            throw th;
        }
        return objInvoke;
    }

    public boolean isGlobalBlacklistEnabled() {
        return this.globalBlacklistTimeout > 0;
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public boolean isMasterConnection() {
        return true;
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public synchronized void pickNewConnection() throws SQLException {
        if (this.isClosed && this.closedExplicitly) {
            return;
        }
        MySQLConnection mySQLConnection = this.currentConnection;
        if (mySQLConnection == null) {
            this.currentConnection = this.balancer.pickConnection(this, Collections.unmodifiableList(this.hostList), Collections.unmodifiableMap(this.liveConnections), (long[]) this.responseTimes.clone(), this.retriesAllDown);
            return;
        }
        if (mySQLConnection.isClosed()) {
            invalidateCurrentConnection();
        }
        int loadBalancePingTimeout = this.currentConnection.getLoadBalancePingTimeout();
        boolean loadBalanceValidateConnectionOnSwapServer = this.currentConnection.getLoadBalanceValidateConnectionOnSwapServer();
        int size = this.hostList.size();
        for (int i = 0; i < size; i++) {
            ConnectionImpl connectionImplPickConnection = null;
            try {
                connectionImplPickConnection = this.balancer.pickConnection(this, Collections.unmodifiableList(this.hostList), Collections.unmodifiableMap(this.liveConnections), (long[]) this.responseTimes.clone(), this.retriesAllDown);
                if (this.currentConnection != null) {
                    if (loadBalanceValidateConnectionOnSwapServer) {
                        if (loadBalancePingTimeout == 0) {
                            connectionImplPickConnection.ping();
                        } else {
                            connectionImplPickConnection.pingInternal(true, loadBalancePingTimeout);
                        }
                    }
                    syncSessionState(this.currentConnection, connectionImplPickConnection);
                }
                this.currentConnection = connectionImplPickConnection;
                return;
            } catch (SQLException e) {
                if (shouldExceptionTriggerConnectionSwitch(e) && connectionImplPickConnection != null) {
                    invalidateConnection(connectionImplPickConnection);
                }
            }
        }
        this.isClosed = true;
        this.closedReason = "Connection closed after inability to pick valid new connection during load-balance.";
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public void propagateProxyDown(MySQLConnection mySQLConnection) {
        Iterator<ConnectionImpl> it = this.liveConnections.values().iterator();
        while (it.hasNext()) {
            it.next().setProxy(mySQLConnection);
        }
    }

    public synchronized void removeHost(String str) throws SQLException {
        ConnectionGroup connectionGroup = this.connectionGroup;
        if (connectionGroup != null && connectionGroup.getInitialHosts().size() == 1 && this.connectionGroup.getInitialHosts().contains(str)) {
            throw SQLError.createSQLException("Cannot remove only configured host.", null);
        }
        this.hostsToRemove.add(str);
        this.connectionsToHostsMap.remove(this.liveConnections.remove(str));
        if (this.hostsToListIndexMap.remove(str) != null) {
            long[] jArr = new long[this.responseTimes.length - 1];
            int i = 0;
            for (String str2 : this.hostList) {
                if (!this.hostsToRemove.contains(str2)) {
                    Integer num = this.hostsToListIndexMap.get(str2);
                    if (num != null) {
                        int iIntValue = num.intValue();
                        long[] jArr2 = this.responseTimes;
                        if (iIntValue < jArr2.length) {
                            jArr[i] = jArr2[num.intValue()];
                        }
                    }
                    this.hostsToListIndexMap.put(str2, Integer.valueOf(i));
                    i++;
                }
            }
            this.responseTimes = jArr;
        }
        if (str.equals(this.currentConnection.getHostPortPair())) {
            invalidateConnection(this.currentConnection);
            pickNewConnection();
        }
    }

    public void removeHostWhenNotInUse(String str) throws SQLException {
        int i = this.hostRemovalGracePeriod;
        if (i <= 0) {
            removeHost(str);
            return;
        }
        if (i > 1000) {
            i = 1000;
        }
        synchronized (this) {
            long j = i;
            addToGlobalBlacklist(str, System.currentTimeMillis() + ((long) this.hostRemovalGracePeriod) + j);
            long jCurrentTimeMillis = System.currentTimeMillis();
            while (System.currentTimeMillis() < ((long) this.hostRemovalGracePeriod) + jCurrentTimeMillis) {
                this.hostsToRemove.add(str);
                if (!str.equals(this.currentConnection.getHostPortPair())) {
                    removeHost(str);
                    return;
                }
                try {
                    Thread.sleep(j);
                } catch (InterruptedException unused) {
                }
            }
            removeHost(str);
        }
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public boolean shouldExceptionTriggerConnectionSwitch(Throwable th) {
        return (th instanceof SQLException) && this.exceptionChecker.shouldExceptionTriggerFailover((SQLException) th);
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public void syncSessionState(Connection connection, Connection connection2, boolean z) throws SQLException {
        LoadBalancedAutoCommitInterceptor loadBalancedAutoCommitInterceptor;
        Iterator<StatementInterceptorV2> it = ((MySQLConnection) connection2).getStatementInterceptorsInstances().iterator();
        while (true) {
            if (!it.hasNext()) {
                loadBalancedAutoCommitInterceptor = null;
                break;
            }
            StatementInterceptorV2 next = it.next();
            if (next instanceof LoadBalancedAutoCommitInterceptor) {
                loadBalancedAutoCommitInterceptor = (LoadBalancedAutoCommitInterceptor) next;
                loadBalancedAutoCommitInterceptor.pauseCounters();
                break;
            }
        }
        super.syncSessionState(connection, connection2, z);
        if (loadBalancedAutoCommitInterceptor != null) {
            loadBalancedAutoCommitInterceptor.resumeCounters();
        }
    }

    public void addToGlobalBlacklist(String str) {
        addToGlobalBlacklist(str, System.currentTimeMillis() + ((long) this.globalBlacklistTimeout));
    }
}
