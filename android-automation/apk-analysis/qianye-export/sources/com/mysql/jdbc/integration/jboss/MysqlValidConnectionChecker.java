package com.mysql.jdbc.integration.jboss;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.jboss.resource.adapter.jdbc.ValidConnectionChecker;

/* JADX INFO: loaded from: classes.dex */
public final class MysqlValidConnectionChecker implements ValidConnectionChecker, Serializable {
    private static final long serialVersionUID = 8909421133577519177L;

    public SQLException isValidConnection(Connection connection) throws Throwable {
        Throwable th;
        Statement statementCreateStatement;
        SQLException e;
        try {
            statementCreateStatement = connection.createStatement();
            try {
                statementCreateStatement.executeQuery("/* ping */ SELECT 1").close();
                if (statementCreateStatement != null) {
                    try {
                        statementCreateStatement.close();
                    } catch (SQLException unused) {
                    }
                }
                return null;
            } catch (SQLException e2) {
                e = e2;
                if (statementCreateStatement != null) {
                    try {
                        statementCreateStatement.close();
                    } catch (SQLException unused2) {
                    }
                }
                return e;
            } catch (Throwable th2) {
                th = th2;
                if (statementCreateStatement != null) {
                    try {
                        statementCreateStatement.close();
                    } catch (SQLException unused3) {
                    }
                }
                throw th;
            }
        } catch (SQLException e3) {
            e = e3;
            statementCreateStatement = null;
        } catch (Throwable th3) {
            th = th3;
            statementCreateStatement = null;
        }
    }
}
