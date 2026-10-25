package com.mysql.jdbc.jdbc2.optional;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.XAConnection;
import javax.sql.XADataSource;

/* JADX INFO: loaded from: classes.dex */
public class MysqlXADataSource extends MysqlDataSource implements XADataSource {
    public static final long serialVersionUID = 7911390333152247455L;

    private XAConnection wrapConnection(Connection connection) throws SQLException {
        if (!getPinGlobalTxToPhysicalConnection()) {
            com.mysql.jdbc.Connection connection2 = (com.mysql.jdbc.Connection) connection;
            if (!connection2.getPinGlobalTxToPhysicalConnection()) {
                return MysqlXAConnection.getInstance(connection2, getLogXaCommands());
            }
        }
        return SuspendableXAConnection.getInstance((com.mysql.jdbc.Connection) connection);
    }

    public XAConnection getXAConnection() throws SQLException {
        return wrapConnection(getConnection());
    }

    public XAConnection getXAConnection(String str, String str2) throws SQLException {
        return wrapConnection(getConnection(str, str2));
    }
}
