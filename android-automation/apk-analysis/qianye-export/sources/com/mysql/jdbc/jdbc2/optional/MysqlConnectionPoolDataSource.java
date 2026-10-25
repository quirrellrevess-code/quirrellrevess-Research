package com.mysql.jdbc.jdbc2.optional;

import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import javax.sql.ConnectionPoolDataSource;
import javax.sql.PooledConnection;

/* JADX INFO: loaded from: classes.dex */
public class MysqlConnectionPoolDataSource extends MysqlDataSource implements ConnectionPoolDataSource {
    public static final long serialVersionUID = -7767325445592304961L;

    @Override // javax.sql.ConnectionPoolDataSource
    public synchronized PooledConnection getPooledConnection() throws SQLException {
        return MysqlPooledConnection.getInstance((Connection) getConnection());
    }

    @Override // javax.sql.ConnectionPoolDataSource
    public synchronized PooledConnection getPooledConnection(String str, String str2) throws SQLException {
        return MysqlPooledConnection.getInstance((Connection) getConnection(str, str2));
    }
}
