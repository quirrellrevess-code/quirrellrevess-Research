package com.mysql.jdbc.integration.c3p0;

import com.mchange.v2.c3p0.C3P0ProxyConnection;
import com.mchange.v2.c3p0.QueryConnectionTester;
import com.mysql.jdbc.CommunicationsException;
import com.mysql.jdbc.Connection;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.sql.Statement;

/* JADX INFO: loaded from: classes.dex */
public final class MysqlConnectionTester implements QueryConnectionTester {
    private static final Object[] NO_ARGS_ARRAY = new Object[0];
    private static final long serialVersionUID = 3256444690067896368L;
    private transient Method pingMethod;

    public MysqlConnectionTester() {
        try {
            this.pingMethod = Connection.class.getMethod("ping", null);
        } catch (Exception unused) {
        }
    }

    public int activeCheckConnection(java.sql.Connection connection) {
        try {
            Method method = this.pingMethod;
            if (method != null) {
                if (connection instanceof Connection) {
                    ((Connection) connection).ping();
                    return 0;
                }
                ((C3P0ProxyConnection) connection).rawConnectionOperation(method, C3P0ProxyConnection.RAW_CONNECTION, NO_ARGS_ARRAY);
                return 0;
            }
            Statement statementCreateStatement = null;
            try {
                statementCreateStatement = connection.createStatement();
                statementCreateStatement.executeQuery("SELECT 1").close();
            } finally {
                if (statementCreateStatement != null) {
                    statementCreateStatement.close();
                }
            }
        } catch (Exception unused) {
            return -1;
        }
    }

    public int activeCheckConnection(java.sql.Connection connection, String str) {
        return 0;
    }

    public int statusOnException(java.sql.Connection connection, Throwable th) {
        if ((th instanceof CommunicationsException) || "com.mysql.jdbc.exceptions.jdbc4.CommunicationsException".equals(th.getClass().getName()) || !(th instanceof SQLException)) {
            return -1;
        }
        String sQLState = ((SQLException) th).getSQLState();
        return (sQLState == null || !sQLState.startsWith("08")) ? 0 : -1;
    }
}
