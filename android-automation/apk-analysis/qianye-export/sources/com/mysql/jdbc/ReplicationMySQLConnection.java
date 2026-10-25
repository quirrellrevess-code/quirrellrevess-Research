package com.mysql.jdbc;

import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class ReplicationMySQLConnection extends MultiHostMySQLConnection implements ReplicationConnection {
    public ReplicationMySQLConnection(MultiHostConnectionProxy multiHostConnectionProxy) {
        super(multiHostConnectionProxy);
    }

    private Connection getValidatedMasterConnection() {
        LoadBalancedConnection loadBalancedConnection = getThisAsProxy().masterConnection;
        if (loadBalancedConnection != null) {
            try {
                if (!loadBalancedConnection.isClosed()) {
                    return loadBalancedConnection;
                }
            } catch (SQLException unused) {
                return null;
            }
        }
        return null;
    }

    private Connection getValidatedSlavesConnection() {
        LoadBalancedConnection loadBalancedConnection = getThisAsProxy().slavesConnection;
        if (loadBalancedConnection != null) {
            try {
                if (!loadBalancedConnection.isClosed()) {
                    return loadBalancedConnection;
                }
            } catch (SQLException unused) {
                return null;
            }
        }
        return null;
    }

    @Override // com.mysql.jdbc.MultiHostMySQLConnection, com.mysql.jdbc.Connection
    public void abort(Executor executor) throws SQLException {
        getThisAsProxy().doAbort(executor);
    }

    @Override // com.mysql.jdbc.MultiHostMySQLConnection, com.mysql.jdbc.Connection
    public void abortInternal() throws SQLException {
        getThisAsProxy().doAbortInternal();
    }

    @Override // com.mysql.jdbc.ReplicationConnection
    public void addSlaveHost(String str) throws SQLException {
        getThisAsProxy().addSlaveHost(str);
    }

    @Override // com.mysql.jdbc.MultiHostMySQLConnection, com.mysql.jdbc.Connection
    public synchronized void changeUser(String str, String str2) throws SQLException {
        Connection validatedMasterConnection = getValidatedMasterConnection();
        if (validatedMasterConnection != null) {
            validatedMasterConnection.changeUser(str, str2);
        }
        Connection validatedSlavesConnection = getValidatedSlavesConnection();
        if (validatedSlavesConnection != null) {
            validatedSlavesConnection.changeUser(str, str2);
        }
    }

    @Override // com.mysql.jdbc.MultiHostMySQLConnection, com.mysql.jdbc.MySQLConnection
    public MySQLConnection getActiveMySQLConnection() {
        return (MySQLConnection) getCurrentConnection();
    }

    @Override // com.mysql.jdbc.MultiHostMySQLConnection, com.mysql.jdbc.ConnectionProperties
    public boolean getAllowMasterDownConnections() {
        return getThisAsProxy().allowMasterDownConnections;
    }

    @Override // com.mysql.jdbc.ReplicationConnection
    public long getConnectionGroupId() {
        return getThisAsProxy().getConnectionGroupId();
    }

    @Override // com.mysql.jdbc.ReplicationConnection
    public synchronized Connection getCurrentConnection() {
        return getThisAsProxy().getCurrentConnection();
    }

    @Override // com.mysql.jdbc.ReplicationConnection
    public synchronized Connection getMasterConnection() {
        return getThisAsProxy().getMasterConnection();
    }

    @Override // com.mysql.jdbc.MultiHostMySQLConnection, com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public Properties getProperties() {
        Properties properties = new Properties();
        Connection validatedMasterConnection = getValidatedMasterConnection();
        if (validatedMasterConnection != null) {
            properties.putAll(validatedMasterConnection.getProperties());
        }
        Connection validatedSlavesConnection = getValidatedSlavesConnection();
        if (validatedSlavesConnection != null) {
            properties.putAll(validatedSlavesConnection.getProperties());
        }
        return properties;
    }

    @Override // com.mysql.jdbc.MultiHostMySQLConnection, com.mysql.jdbc.ConnectionProperties
    public boolean getReplicationEnableJMX() {
        return getThisAsProxy().enableJMX;
    }

    @Override // com.mysql.jdbc.ReplicationConnection
    public synchronized Connection getSlavesConnection() {
        return getThisAsProxy().getSlavesConnection();
    }

    @Override // com.mysql.jdbc.MultiHostMySQLConnection, com.mysql.jdbc.Connection
    public boolean hasSameProperties(Connection connection) {
        Connection validatedMasterConnection = getValidatedMasterConnection();
        Connection validatedSlavesConnection = getValidatedSlavesConnection();
        if (validatedMasterConnection == null && validatedSlavesConnection == null) {
            return false;
        }
        if (validatedMasterConnection == null || validatedMasterConnection.hasSameProperties(connection)) {
            return validatedSlavesConnection == null || validatedSlavesConnection.hasSameProperties(connection);
        }
        return false;
    }

    @Override // com.mysql.jdbc.ReplicationConnection
    public boolean isHostMaster(String str) {
        return getThisAsProxy().isHostMaster(str);
    }

    @Override // com.mysql.jdbc.ReplicationConnection
    public boolean isHostSlave(String str) {
        return getThisAsProxy().isHostSlave(str);
    }

    @Override // com.mysql.jdbc.MultiHostMySQLConnection, com.mysql.jdbc.MySQLConnection, java.sql.Connection
    public boolean isReadOnly() throws SQLException {
        return getThisAsProxy().isReadOnly();
    }

    /* JADX WARN: Code duplicated, block: B:14:0x001a A[Catch: all -> 0x000b, SQLException -> 0x001e, TRY_LEAVE, TryCatch #0 {SQLException -> 0x001e, blocks: (B:12:0x0014, B:14:0x001a), top: B:25:0x0014, outer: #2 }] */
    @Override // com.mysql.jdbc.MultiHostMySQLConnection, com.mysql.jdbc.Connection
    public synchronized void ping() throws SQLException {
        Connection validatedSlavesConnection;
        try {
            Connection validatedMasterConnection = getValidatedMasterConnection();
            if (validatedMasterConnection != null) {
                validatedMasterConnection.ping();
                try {
                    validatedSlavesConnection = getValidatedSlavesConnection();
                    if (validatedSlavesConnection != null) {
                        validatedSlavesConnection.ping();
                    }
                } catch (SQLException e) {
                    if (!isMasterConnection()) {
                        throw e;
                    }
                }
            } else {
                validatedSlavesConnection = getValidatedSlavesConnection();
                if (validatedSlavesConnection != null) {
                    validatedSlavesConnection.ping();
                }
            }
        } catch (SQLException e2) {
            if (isMasterConnection()) {
                throw e2;
            }
        }
        throw th;
    }

    @Override // com.mysql.jdbc.ReplicationConnection
    public void promoteSlaveToMaster(String str) throws SQLException {
        getThisAsProxy().promoteSlaveToMaster(str);
    }

    @Override // com.mysql.jdbc.ReplicationConnection
    public void removeMasterHost(String str) throws SQLException {
        getThisAsProxy().removeMasterHost(str);
    }

    @Override // com.mysql.jdbc.ReplicationConnection
    public void removeSlave(String str) throws SQLException {
        getThisAsProxy().removeSlave(str);
    }

    @Override // com.mysql.jdbc.MultiHostMySQLConnection, com.mysql.jdbc.ConnectionProperties
    public void setAllowMasterDownConnections(boolean z) {
        getThisAsProxy().allowMasterDownConnections = z;
    }

    @Override // com.mysql.jdbc.MultiHostMySQLConnection, com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public void setProxy(MySQLConnection mySQLConnection) {
        getThisAsProxy().setProxy(mySQLConnection);
    }

    @Override // com.mysql.jdbc.MultiHostMySQLConnection, java.sql.Connection
    public void setReadOnly(boolean z) throws SQLException {
        getThisAsProxy().setReadOnly(z);
    }

    @Override // com.mysql.jdbc.MultiHostMySQLConnection, com.mysql.jdbc.ConnectionProperties
    public void setReplicationEnableJMX(boolean z) {
        getThisAsProxy().enableJMX = z;
    }

    @Override // com.mysql.jdbc.MultiHostMySQLConnection, com.mysql.jdbc.Connection
    public synchronized void setStatementComment(String str) {
        Connection validatedMasterConnection = getValidatedMasterConnection();
        if (validatedMasterConnection != null) {
            validatedMasterConnection.setStatementComment(str);
        }
        Connection validatedSlavesConnection = getValidatedSlavesConnection();
        if (validatedSlavesConnection != null) {
            validatedSlavesConnection.setStatementComment(str);
        }
    }

    @Override // com.mysql.jdbc.MultiHostMySQLConnection
    public ReplicationConnectionProxy getThisAsProxy() {
        return (ReplicationConnectionProxy) super.getThisAsProxy();
    }

    @Override // com.mysql.jdbc.ReplicationConnection
    public void removeMasterHost(String str, boolean z) throws SQLException {
        getThisAsProxy().removeMasterHost(str, z);
    }

    @Override // com.mysql.jdbc.ReplicationConnection
    public void removeSlave(String str, boolean z) throws SQLException {
        getThisAsProxy().removeSlave(str, z);
    }
}
