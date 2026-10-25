package com.mysql.jdbc.jdbc2.optional;

import com.mysql.jdbc.SQLError;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Statement;

/* JADX INFO: loaded from: classes.dex */
public class JDBC42CallableStatementWrapper extends JDBC4CallableStatementWrapper {
    public JDBC42CallableStatementWrapper(ConnectionWrapper connectionWrapper, MysqlPooledConnection mysqlPooledConnection, CallableStatement callableStatement) {
        super(connectionWrapper, mysqlPooledConnection, callableStatement);
    }

    public void registerOutParameter(int i, SQLType sQLType) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement == null) {
                throw SQLError.createSQLException("No operations allowed after statement closed", SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
            }
            ((CallableStatement) statement).registerOutParameter(i, sQLType);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    public void setObject(int i, Object obj, SQLType sQLType) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement == null) {
                throw SQLError.createSQLException("No operations allowed after statement closed", SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
            }
            ((CallableStatement) statement).setObject(i, obj, sQLType);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    public void registerOutParameter(int i, SQLType sQLType, int i2) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                ((CallableStatement) statement).registerOutParameter(i, sQLType, i2);
                return;
            }
            throw SQLError.createSQLException("No operations allowed after statement closed", SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    public void setObject(int i, Object obj, SQLType sQLType, int i2) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                ((CallableStatement) statement).setObject(i, obj, sQLType, i2);
                return;
            }
            throw SQLError.createSQLException("No operations allowed after statement closed", SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    public void registerOutParameter(int i, SQLType sQLType, String str) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                ((CallableStatement) statement).registerOutParameter(i, sQLType, str);
                return;
            }
            throw SQLError.createSQLException("No operations allowed after statement closed", SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    public void setObject(String str, Object obj, SQLType sQLType) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                ((CallableStatement) statement).setObject(str, obj, sQLType);
                return;
            }
            throw SQLError.createSQLException("No operations allowed after statement closed", SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    public void registerOutParameter(String str, SQLType sQLType) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                ((CallableStatement) statement).registerOutParameter(str, sQLType);
                return;
            }
            throw SQLError.createSQLException("No operations allowed after statement closed", SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    public void setObject(String str, Object obj, SQLType sQLType, int i) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                ((CallableStatement) statement).setObject(str, obj, sQLType, i);
                return;
            }
            throw SQLError.createSQLException("No operations allowed after statement closed", SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    public void registerOutParameter(String str, SQLType sQLType, int i) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                ((CallableStatement) statement).registerOutParameter(str, sQLType, i);
                return;
            }
            throw SQLError.createSQLException("No operations allowed after statement closed", SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    public void registerOutParameter(String str, SQLType sQLType, String str2) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                ((CallableStatement) statement).registerOutParameter(str, sQLType, str2);
                return;
            }
            throw SQLError.createSQLException("No operations allowed after statement closed", SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }
}
