package com.mysql.jdbc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class ReplicationConnectionProxy extends MultiHostConnectionProxy implements PingTarget {
    private static Class<?>[] INTERFACES_TO_PROXY;
    private static Constructor<?> JDBC_4_REPL_CONNECTION_CTOR;
    public boolean allowMasterDownConnections;
    public boolean allowSlaveDownConnections;
    public ReplicationConnectionGroup connectionGroup;
    private long connectionGroupID;
    private NonRegisteringDriver driver;
    public boolean enableJMX;
    public LoadBalancedConnection masterConnection;
    private List<String> masterHosts;
    private Properties masterProperties;
    public boolean readFromMasterWhenNoSlavesOriginal;
    public boolean readOnly;
    private List<String> slaveHosts;
    private Properties slaveProperties;
    public LoadBalancedConnection slavesConnection;
    public boolean readFromMasterWhenNoSlaves = false;
    private ReplicationConnection thisAsReplicationConnection = (ReplicationConnection) this.thisAsConnection;

    static {
        if (!Util.isJdbc4()) {
            INTERFACES_TO_PROXY = new Class[]{ReplicationConnection.class};
            return;
        }
        try {
            JDBC_4_REPL_CONNECTION_CTOR = Class.forName("com.mysql.jdbc.JDBC4ReplicationMySQLConnection").getConstructor(ReplicationConnectionProxy.class);
            INTERFACES_TO_PROXY = new Class[]{ReplicationConnection.class, Class.forName("com.mysql.jdbc.JDBC4MySQLConnection")};
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        } catch (SecurityException e3) {
            throw new RuntimeException(e3);
        }
    }

    private ReplicationConnectionProxy(List<String> list, Properties properties, List<String> list2, Properties properties2) throws SQLException {
        LoadBalancedConnection loadBalancedConnection;
        this.enableJMX = false;
        this.allowMasterDownConnections = false;
        this.allowSlaveDownConnections = false;
        this.readFromMasterWhenNoSlavesOriginal = false;
        this.readOnly = false;
        this.connectionGroupID = -1L;
        String property = properties.getProperty("replicationEnableJMX", "false");
        try {
            this.enableJMX = Boolean.parseBoolean(property);
            String property2 = properties.getProperty("allowMasterDownConnections", "false");
            try {
                this.allowMasterDownConnections = Boolean.parseBoolean(property2);
                String property3 = properties.getProperty("allowSlaveDownConnections", "false");
                try {
                    this.allowSlaveDownConnections = Boolean.parseBoolean(property3);
                    String property4 = properties.getProperty("readFromMasterWhenNoSlaves");
                    try {
                        this.readFromMasterWhenNoSlavesOriginal = Boolean.parseBoolean(property4);
                        String property5 = properties.getProperty("replicationConnectionGroup", null);
                        if (property5 != null) {
                            this.connectionGroup = ReplicationConnectionGroupManager.getConnectionGroupInstance(property5);
                            if (this.enableJMX) {
                                ReplicationConnectionGroupManager.registerJmx();
                            }
                            this.connectionGroupID = this.connectionGroup.registerReplicationConnection(this.thisAsReplicationConnection, list, list2);
                            this.slaveHosts = new ArrayList(this.connectionGroup.getSlaveHosts());
                            this.masterHosts = new ArrayList(this.connectionGroup.getMasterHosts());
                        } else {
                            this.slaveHosts = new ArrayList(list2);
                            this.masterHosts = new ArrayList(list);
                        }
                        this.driver = new NonRegisteringDriver();
                        this.slaveProperties = properties2;
                        this.masterProperties = properties;
                        resetReadFromMasterWhenNoSlaves();
                        try {
                            initializeSlavesConnection();
                        } catch (SQLException e) {
                            if (!this.allowSlaveDownConnections) {
                                ReplicationConnectionGroup replicationConnectionGroup = this.connectionGroup;
                                if (replicationConnectionGroup != null) {
                                    replicationConnectionGroup.handleCloseConnection(this.thisAsReplicationConnection);
                                }
                                throw e;
                            }
                        }
                        try {
                            this.currentConnection = initializeMasterConnection();
                            e = null;
                        } catch (SQLException e2) {
                            e = e2;
                        }
                        if (this.currentConnection == null) {
                            if (this.allowMasterDownConnections && (loadBalancedConnection = this.slavesConnection) != null) {
                                this.readOnly = true;
                                this.currentConnection = loadBalancedConnection;
                                return;
                            }
                            ReplicationConnectionGroup replicationConnectionGroup2 = this.connectionGroup;
                            if (replicationConnectionGroup2 != null) {
                                replicationConnectionGroup2.handleCloseConnection(this.thisAsReplicationConnection);
                            }
                            if (e == null) {
                                throw SQLError.createSQLException(Messages.getString("ReplicationConnectionProxy.initializationWithEmptyHostsLists"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
                            }
                            throw e;
                        }
                    } catch (Exception unused) {
                        throw SQLError.createSQLException(Messages.getString("ReplicationConnectionProxy.badValueForReadFromMasterWhenNoSlaves", new Object[]{property4}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
                    }
                } catch (Exception unused2) {
                    throw SQLError.createSQLException(Messages.getString("ReplicationConnectionProxy.badValueForAllowSlaveDownConnections", new Object[]{property3}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
                }
            } catch (Exception unused3) {
                throw SQLError.createSQLException(Messages.getString("ReplicationConnectionProxy.badValueForAllowMasterDownConnections", new Object[]{property2}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
            }
        } catch (Exception unused4) {
            throw SQLError.createSQLException(Messages.getString("ReplicationConnectionProxy.badValueForReplicationEnableJMX", new Object[]{property}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
        }
    }

    private String buildURL(List<String> list, Properties properties) {
        StringBuilder sb = new StringBuilder(NonRegisteringDriver.LOADBALANCE_URL_PREFIX);
        boolean z = true;
        for (String str : list) {
            if (!z) {
                sb.append(',');
            }
            sb.append(str);
            z = false;
        }
        sb.append("/");
        String property = properties.getProperty(NonRegisteringDriver.DBNAME_PROPERTY_KEY);
        if (property != null) {
            sb.append(property);
        }
        return sb.toString();
    }

    private void checkConnectionCapabilityForMethod(Method method) throws Throwable {
        if (this.masterHosts.isEmpty() && this.slaveHosts.isEmpty() && !ReplicationConnection.class.isAssignableFrom(method.getDeclaringClass())) {
            throw SQLError.createSQLException(Messages.getString("ReplicationConnectionProxy.noHostsInconsistentState"), SQLError.SQL_STATE_INVALID_TRANSACTION_STATE, MysqlErrorNumbers.ERROR_CODE_REPLICATION_CONNECTION_WITH_NO_HOSTS, true, (ExceptionInterceptor) null);
        }
    }

    public static ReplicationConnection createProxyInstance(List<String> list, Properties properties, List<String> list2, Properties properties2) throws SQLException {
        return (ReplicationConnection) Proxy.newProxyInstance(ReplicationConnection.class.getClassLoader(), INTERFACES_TO_PROXY, new ReplicationConnectionProxy(list, properties, list2, properties2));
    }

    private MySQLConnection initializeMasterConnection() throws SQLException {
        this.masterConnection = null;
        if (this.masterHosts.size() == 0) {
            return null;
        }
        LoadBalancedConnection loadBalancedConnection = (LoadBalancedConnection) this.driver.connect(buildURL(this.masterHosts, this.masterProperties), this.masterProperties);
        loadBalancedConnection.setProxy(getProxy());
        this.masterConnection = loadBalancedConnection;
        return loadBalancedConnection;
    }

    private MySQLConnection initializeSlavesConnection() throws SQLException {
        this.slavesConnection = null;
        if (this.slaveHosts.size() == 0) {
            return null;
        }
        LoadBalancedConnection loadBalancedConnection = (LoadBalancedConnection) this.driver.connect(buildURL(this.slaveHosts, this.slaveProperties), this.slaveProperties);
        loadBalancedConnection.setProxy(getProxy());
        loadBalancedConnection.setReadOnly(true);
        this.slavesConnection = loadBalancedConnection;
        return loadBalancedConnection;
    }

    private void resetReadFromMasterWhenNoSlaves() {
        this.readFromMasterWhenNoSlaves = this.slaveHosts.isEmpty() || this.readFromMasterWhenNoSlavesOriginal;
    }

    private synchronized boolean switchToMasterConnection() throws SQLException {
        LoadBalancedConnection loadBalancedConnection;
        LoadBalancedConnection loadBalancedConnection2 = this.masterConnection;
        if (loadBalancedConnection2 == null || loadBalancedConnection2.isClosed()) {
            try {
                if (initializeMasterConnection() == null) {
                    return false;
                }
            } catch (SQLException e) {
                this.currentConnection = null;
                throw e;
            }
        }
        if (!isMasterConnection() && (loadBalancedConnection = this.masterConnection) != null) {
            syncSessionState(this.currentConnection, loadBalancedConnection, false);
            this.currentConnection = this.masterConnection;
        }
        return true;
    }

    private synchronized boolean switchToSlavesConnection() throws SQLException {
        LoadBalancedConnection loadBalancedConnection;
        LoadBalancedConnection loadBalancedConnection2 = this.slavesConnection;
        if (loadBalancedConnection2 == null || loadBalancedConnection2.isClosed()) {
            try {
                if (initializeSlavesConnection() == null) {
                    return false;
                }
            } catch (SQLException e) {
                this.currentConnection = null;
                throw e;
            }
        }
        if (!isSlavesConnection() && (loadBalancedConnection = this.slavesConnection) != null) {
            syncSessionState(this.currentConnection, loadBalancedConnection, true);
            this.currentConnection = this.slavesConnection;
        }
        return true;
    }

    private boolean switchToSlavesConnectionIfNecessary() throws SQLException {
        if (this.currentConnection == null || ((isMasterConnection() && (this.readOnly || (this.masterHosts.isEmpty() && this.currentConnection.isClosed()))) || (!isMasterConnection() && this.currentConnection.isClosed()))) {
            return switchToSlavesConnection();
        }
        return false;
    }

    public synchronized void addSlaveHost(String str) throws SQLException {
        if (isHostSlave(str)) {
            return;
        }
        this.slaveHosts.add(str);
        resetReadFromMasterWhenNoSlaves();
        LoadBalancedConnection loadBalancedConnection = this.slavesConnection;
        if (loadBalancedConnection == null) {
            initializeSlavesConnection();
            switchToSlavesConnectionIfNecessary();
        } else {
            loadBalancedConnection.addHost(str);
        }
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public void doAbort(Executor executor) throws SQLException {
        this.masterConnection.abort(executor);
        this.slavesConnection.abort(executor);
        ReplicationConnectionGroup replicationConnectionGroup = this.connectionGroup;
        if (replicationConnectionGroup != null) {
            replicationConnectionGroup.handleCloseConnection(this.thisAsReplicationConnection);
        }
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public void doAbortInternal() throws SQLException {
        this.masterConnection.abortInternal();
        this.slavesConnection.abortInternal();
        ReplicationConnectionGroup replicationConnectionGroup = this.connectionGroup;
        if (replicationConnectionGroup != null) {
            replicationConnectionGroup.handleCloseConnection(this.thisAsReplicationConnection);
        }
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public void doClose() throws SQLException {
        LoadBalancedConnection loadBalancedConnection = this.masterConnection;
        if (loadBalancedConnection != null) {
            loadBalancedConnection.close();
        }
        LoadBalancedConnection loadBalancedConnection2 = this.slavesConnection;
        if (loadBalancedConnection2 != null) {
            loadBalancedConnection2.close();
        }
        ReplicationConnectionGroup replicationConnectionGroup = this.connectionGroup;
        if (replicationConnectionGroup != null) {
            replicationConnectionGroup.handleCloseConnection(this.thisAsReplicationConnection);
        }
    }

    @Override // com.mysql.jdbc.PingTarget
    public void doPing() throws SQLException {
        SQLException e;
        boolean zIsMasterConnection = isMasterConnection();
        LoadBalancedConnection loadBalancedConnection = this.masterConnection;
        if (loadBalancedConnection != null) {
            try {
                loadBalancedConnection.ping();
            } catch (SQLException e2) {
                e = e2;
            }
        } else {
            initializeMasterConnection();
        }
        e = null;
        LoadBalancedConnection loadBalancedConnection2 = this.slavesConnection;
        if (loadBalancedConnection2 != null) {
            try {
                loadBalancedConnection2.ping();
            } catch (SQLException e3) {
                e = e3;
            }
        } else {
            try {
                initializeSlavesConnection();
                if (switchToSlavesConnectionIfNecessary()) {
                    zIsMasterConnection = false;
                }
            } catch (SQLException e4) {
                if (this.masterConnection == null || !this.readFromMasterWhenNoSlaves) {
                    throw e4;
                }
            }
        }
        e = null;
        if (zIsMasterConnection && e != null) {
            LoadBalancedConnection loadBalancedConnection3 = this.slavesConnection;
            if (loadBalancedConnection3 == null || e != null) {
                throw e;
            }
            this.masterConnection = null;
            this.currentConnection = loadBalancedConnection3;
            this.readOnly = true;
            throw e;
        }
        if (zIsMasterConnection) {
            return;
        }
        if (e != null || this.slavesConnection == null) {
            LoadBalancedConnection loadBalancedConnection4 = this.masterConnection;
            if (loadBalancedConnection4 != null && this.readFromMasterWhenNoSlaves && e == null) {
                this.slavesConnection = null;
                this.currentConnection = loadBalancedConnection4;
                this.readOnly = true;
                loadBalancedConnection4.setReadOnly(true);
            }
            if (e != null) {
                throw e;
            }
        }
    }

    public long getConnectionGroupId() {
        return this.connectionGroupID;
    }

    public synchronized Connection getCurrentConnection() {
        Connection nullLoadBalancedConnectionInstance;
        nullLoadBalancedConnectionInstance = this.currentConnection;
        if (nullLoadBalancedConnectionInstance == null) {
            nullLoadBalancedConnectionInstance = LoadBalancedConnectionProxy.getNullLoadBalancedConnectionInstance();
        }
        return nullLoadBalancedConnectionInstance;
    }

    public synchronized Connection getMasterConnection() {
        return this.masterConnection;
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public MySQLConnection getNewWrapperForThisAsConnection() throws SQLException {
        return (Util.isJdbc4() || JDBC_4_REPL_CONNECTION_CTOR != null) ? (MySQLConnection) Util.handleNewInstance(JDBC_4_REPL_CONNECTION_CTOR, new Object[]{this}, null) : new ReplicationMySQLConnection(this);
    }

    public synchronized Connection getSlavesConnection() {
        return this.slavesConnection;
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public Object invokeMore(Object obj, Method method, Object[] objArr) throws Throwable {
        checkConnectionCapabilityForMethod(method);
        boolean z = false;
        do {
            try {
                Object objInvoke = method.invoke(this.thisAsConnection, objArr);
                if (objInvoke != null && (objInvoke instanceof Statement)) {
                    ((Statement) objInvoke).setPingTarget(this);
                }
                return objInvoke;
            } catch (InvocationTargetException e) {
                if (z) {
                    z = false;
                } else if (e.getCause() != null && (e.getCause() instanceof SQLException) && ((SQLException) e.getCause()).getSQLState() == SQLError.SQL_STATE_INVALID_TRANSACTION_STATE && ((SQLException) e.getCause()).getErrorCode() == 1000001) {
                    try {
                        setReadOnly(this.readOnly);
                        z = true;
                    } catch (SQLException unused) {
                    }
                }
            }
        } while (z);
        throw e;
    }

    public boolean isHostMaster(String str) {
        if (str == null) {
            return false;
        }
        Iterator<String> it = this.masterHosts.iterator();
        while (it.hasNext()) {
            if (it.next().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean isHostSlave(String str) {
        if (str == null) {
            return false;
        }
        Iterator<String> it = this.slaveHosts.iterator();
        while (it.hasNext()) {
            if (it.next().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public boolean isMasterConnection() {
        MySQLConnection mySQLConnection = this.currentConnection;
        return mySQLConnection != null && mySQLConnection == this.masterConnection;
    }

    public boolean isReadOnly() throws SQLException {
        return !isMasterConnection() || this.readOnly;
    }

    public boolean isSlavesConnection() {
        MySQLConnection mySQLConnection = this.currentConnection;
        return mySQLConnection != null && mySQLConnection == this.slavesConnection;
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public void pickNewConnection() throws SQLException {
    }

    public synchronized void promoteSlaveToMaster(String str) throws SQLException {
        this.masterHosts.add(str);
        removeSlave(str);
        LoadBalancedConnection loadBalancedConnection = this.masterConnection;
        if (loadBalancedConnection != null) {
            loadBalancedConnection.addHost(str);
        }
        if (!this.readOnly && !isMasterConnection()) {
            switchToMasterConnection();
        }
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public void propagateProxyDown(MySQLConnection mySQLConnection) {
        LoadBalancedConnection loadBalancedConnection = this.masterConnection;
        if (loadBalancedConnection != null) {
            loadBalancedConnection.setProxy(mySQLConnection);
        }
        LoadBalancedConnection loadBalancedConnection2 = this.slavesConnection;
        if (loadBalancedConnection2 != null) {
            loadBalancedConnection2.setProxy(mySQLConnection);
        }
    }

    public synchronized void removeMasterHost(String str) throws SQLException {
        removeMasterHost(str, true);
    }

    public synchronized void removeSlave(String str) throws SQLException {
        removeSlave(str, true);
    }

    public synchronized void setReadOnly(boolean z) throws SQLException {
        boolean zSwitchToMasterConnection = false;
        SQLException sQLException = null;
        try {
            if (z) {
                if (!isSlavesConnection() || this.currentConnection.isClosed()) {
                    try {
                        zSwitchToMasterConnection = switchToSlavesConnection();
                        e = null;
                    } catch (SQLException e) {
                        e = e;
                    }
                    if (zSwitchToMasterConnection || !this.readFromMasterWhenNoSlaves || !switchToMasterConnection()) {
                        sQLException = e;
                    }
                    if (sQLException != null) {
                        throw sQLException;
                    }
                }
            } else if (!isMasterConnection() || this.currentConnection.isClosed()) {
                try {
                    zSwitchToMasterConnection = switchToMasterConnection();
                    e = null;
                } catch (SQLException e2) {
                    e = e2;
                }
                if (zSwitchToMasterConnection || !switchToSlavesConnectionIfNecessary()) {
                    sQLException = e;
                }
                if (sQLException != null) {
                    throw sQLException;
                }
            }
            this.readOnly = z;
            if (this.readFromMasterWhenNoSlaves && isMasterConnection()) {
                this.currentConnection.setReadOnly(this.readOnly);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public boolean shouldExceptionTriggerConnectionSwitch(Throwable th) {
        return false;
    }

    @Override // com.mysql.jdbc.MultiHostConnectionProxy
    public void syncSessionState(Connection connection, Connection connection2, boolean z) throws SQLException {
        try {
            try {
                super.syncSessionState(connection, connection2, z);
            } catch (SQLException unused) {
            }
        } catch (SQLException unused2) {
            super.syncSessionState(connection, connection2, z);
        }
    }

    public synchronized void removeMasterHost(String str, boolean z) throws SQLException {
        removeMasterHost(str, z, false);
    }

    public synchronized void removeSlave(String str, boolean z) throws SQLException {
        this.slaveHosts.remove(str);
        resetReadFromMasterWhenNoSlaves();
        LoadBalancedConnection loadBalancedConnection = this.slavesConnection;
        if (loadBalancedConnection != null && !loadBalancedConnection.isClosed()) {
            if (z) {
                this.slavesConnection.removeHostWhenNotInUse(str);
            } else {
                this.slavesConnection.removeHost(str);
            }
            if (this.slaveHosts.isEmpty()) {
                this.slavesConnection.close();
                this.slavesConnection = null;
                switchToMasterConnection();
                if (isMasterConnection()) {
                    this.currentConnection.setReadOnly(this.readOnly);
                }
            }
            return;
        }
        this.slavesConnection = null;
    }

    public synchronized void removeMasterHost(String str, boolean z, boolean z2) throws SQLException {
        if (z2) {
            this.slaveHosts.add(str);
            resetReadFromMasterWhenNoSlaves();
        }
        this.masterHosts.remove(str);
        LoadBalancedConnection loadBalancedConnection = this.masterConnection;
        if (loadBalancedConnection != null && !loadBalancedConnection.isClosed()) {
            if (z) {
                this.masterConnection.removeHostWhenNotInUse(str);
            } else {
                this.masterConnection.removeHost(str);
            }
            if (this.masterHosts.isEmpty()) {
                this.masterConnection.close();
                this.masterConnection = null;
                switchToSlavesConnectionIfNecessary();
            }
            return;
        }
        this.masterConnection = null;
    }
}
