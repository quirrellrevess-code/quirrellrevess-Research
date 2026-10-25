package com.mysql.jdbc;

import java.sql.SQLException;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class MiniAdmin {
    private Connection conn;

    public MiniAdmin(java.sql.Connection connection) throws SQLException {
        if (connection == null) {
            throw SQLError.createSQLException(Messages.getString("MiniAdmin.0"), SQLError.SQL_STATE_GENERAL_ERROR, (ExceptionInterceptor) null);
        }
        if (!(connection instanceof Connection)) {
            throw SQLError.createSQLException(Messages.getString("MiniAdmin.1"), SQLError.SQL_STATE_GENERAL_ERROR, ((ConnectionImpl) connection).getExceptionInterceptor());
        }
        this.conn = (Connection) connection;
    }

    public void shutdown() throws SQLException {
        this.conn.shutdownServer();
    }

    public MiniAdmin(String str) throws SQLException {
        this(str, new Properties());
    }

    public MiniAdmin(String str, Properties properties) throws SQLException {
        this.conn = (Connection) new Driver().connect(str, properties);
    }
}
