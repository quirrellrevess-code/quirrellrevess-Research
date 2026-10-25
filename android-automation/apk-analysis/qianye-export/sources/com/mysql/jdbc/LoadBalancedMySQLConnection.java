package com.mysql.jdbc;

import java.sql.SQLException;

/* JADX INFO: loaded from: classes.dex */
public class LoadBalancedMySQLConnection extends MultiHostMySQLConnection implements LoadBalancedConnection {
    public LoadBalancedMySQLConnection(LoadBalancedConnectionProxy loadBalancedConnectionProxy) {
        super(loadBalancedConnectionProxy);
    }

    @Override // com.mysql.jdbc.LoadBalancedConnection
    public boolean addHost(String str) throws SQLException {
        return getThisAsProxy().addHost(str);
    }

    @Override // com.mysql.jdbc.MultiHostMySQLConnection, java.sql.Connection, java.lang.AutoCloseable
    public void close() throws SQLException {
        getThisAsProxy().doClose();
    }

    @Override // com.mysql.jdbc.MultiHostMySQLConnection, com.mysql.jdbc.Connection
    public void ping() throws SQLException {
        ping(true);
    }

    @Override // com.mysql.jdbc.LoadBalancedConnection
    public void removeHost(String str) throws SQLException {
        getThisAsProxy().removeHost(str);
    }

    @Override // com.mysql.jdbc.LoadBalancedConnection
    public void removeHostWhenNotInUse(String str) throws SQLException {
        getThisAsProxy().removeHostWhenNotInUse(str);
    }

    @Override // com.mysql.jdbc.MultiHostMySQLConnection
    public LoadBalancedConnectionProxy getThisAsProxy() {
        return (LoadBalancedConnectionProxy) super.getThisAsProxy();
    }

    @Override // com.mysql.jdbc.LoadBalancedConnection
    public void ping(boolean z) throws SQLException {
        if (z) {
            getThisAsProxy().doPing();
        } else {
            getActiveMySQLConnection().ping();
        }
    }
}
