package com.mysql.jdbc.jdbc2.optional;

import com.mysql.jdbc.SQLError;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Statement;

/* JADX INFO: loaded from: classes.dex */
public class JDBC42PreparedStatementWrapper extends JDBC4PreparedStatementWrapper {
    public JDBC42PreparedStatementWrapper(ConnectionWrapper connectionWrapper, MysqlPooledConnection mysqlPooledConnection, PreparedStatement preparedStatement) {
        super(connectionWrapper, mysqlPooledConnection, preparedStatement);
    }

    public void setObject(int i, Object obj, SQLType sQLType) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement == null) {
                throw SQLError.createSQLException("No operations allowed after statement closed", SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
            }
            ((PreparedStatement) statement).setObject(i, obj, sQLType);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    public void setObject(int i, Object obj, SQLType sQLType, int i2) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                ((PreparedStatement) statement).setObject(i, obj, sQLType, i2);
                return;
            }
            throw SQLError.createSQLException("No operations allowed after statement closed", SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }
}
