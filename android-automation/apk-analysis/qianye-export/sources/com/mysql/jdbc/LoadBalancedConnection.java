package com.mysql.jdbc;

import java.sql.SQLException;

/* JADX INFO: loaded from: classes.dex */
public interface LoadBalancedConnection extends MySQLConnection {
    boolean addHost(String str) throws SQLException;

    void ping(boolean z) throws SQLException;

    void removeHost(String str) throws SQLException;

    void removeHostWhenNotInUse(String str) throws SQLException;
}
