package com.mysql.jdbc.jdbc2.optional;

import com.mysql.jdbc.MysqlErrorNumbers;
import com.mysql.jdbc.ResultSetInternalMethods;
import com.mysql.jdbc.SQLError;
import com.mysql.jdbc.StatementImpl;
import com.mysql.jdbc.Util;
import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

/* JADX INFO: loaded from: classes.dex */
public class StatementWrapper extends WrapperBase implements Statement {
    private static final Constructor<?> JDBC_4_STATEMENT_WRAPPER_CTOR;
    public ConnectionWrapper wrappedConn;
    public Statement wrappedStmt;

    static {
        if (!Util.isJdbc4()) {
            JDBC_4_STATEMENT_WRAPPER_CTOR = null;
            return;
        }
        try {
            JDBC_4_STATEMENT_WRAPPER_CTOR = Class.forName("com.mysql.jdbc.jdbc2.optional.JDBC4StatementWrapper").getConstructor(ConnectionWrapper.class, MysqlPooledConnection.class, Statement.class);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        } catch (SecurityException e3) {
            throw new RuntimeException(e3);
        }
    }

    public StatementWrapper(ConnectionWrapper connectionWrapper, MysqlPooledConnection mysqlPooledConnection, Statement statement) {
        super(mysqlPooledConnection);
        this.wrappedStmt = statement;
        this.wrappedConn = connectionWrapper;
    }

    public static StatementWrapper getInstance(ConnectionWrapper connectionWrapper, MysqlPooledConnection mysqlPooledConnection, Statement statement) throws SQLException {
        return !Util.isJdbc4() ? new StatementWrapper(connectionWrapper, mysqlPooledConnection, statement) : (StatementWrapper) Util.handleNewInstance(JDBC_4_STATEMENT_WRAPPER_CTOR, new Object[]{connectionWrapper, mysqlPooledConnection, statement}, mysqlPooledConnection.getExceptionInterceptor());
    }

    @Override // java.sql.Statement
    public void addBatch(String str) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                statement.addBatch(str);
            }
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    @Override // java.sql.Statement
    public void cancel() throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                statement.cancel();
            }
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    @Override // java.sql.Statement
    public void clearBatch() throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                statement.clearBatch();
            }
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    @Override // java.sql.Statement
    public void clearWarnings() throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                statement.clearWarnings();
            }
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    public void close() throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                statement.close();
            }
            this.wrappedStmt = null;
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            this.wrappedStmt = null;
        } finally {
            this.wrappedStmt = null;
            this.pooledConnection = null;
        }
    }

    public void enableStreamingResults() throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement == null) {
                throw SQLError.createSQLException("No operations allowed after statement closed", SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
            }
            ((com.mysql.jdbc.Statement) statement).enableStreamingResults();
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    @Override // java.sql.Statement
    public boolean execute(String str, int i) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return statement.execute(str, i);
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return false;
        }
    }

    @Override // java.sql.Statement
    public int[] executeBatch() throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return statement.executeBatch();
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    public long[] executeLargeBatch() throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return ((StatementImpl) statement).executeLargeBatch();
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    public long executeLargeUpdate(String str) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return ((StatementImpl) statement).executeLargeUpdate(str);
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return -1L;
        }
    }

    @Override // java.sql.Statement
    public ResultSet executeQuery(String str) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement == null) {
                throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
            }
            ResultSet resultSetExecuteQuery = statement.executeQuery(str);
            ((ResultSetInternalMethods) resultSetExecuteQuery).setWrapperStatement(this);
            return resultSetExecuteQuery;
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // java.sql.Statement
    public int executeUpdate(String str, int i) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return statement.executeUpdate(str, i);
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return -1;
        }
    }

    @Override // java.sql.Statement
    public Connection getConnection() throws SQLException {
        try {
            if (this.wrappedStmt != null) {
                return this.wrappedConn;
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // java.sql.Statement
    public int getFetchDirection() throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return statement.getFetchDirection();
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return 1000;
        }
    }

    @Override // java.sql.Statement
    public int getFetchSize() throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return statement.getFetchSize();
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return 0;
        }
    }

    @Override // java.sql.Statement
    public ResultSet getGeneratedKeys() throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return statement.getGeneratedKeys();
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    public long getLargeMaxRows() throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return ((StatementImpl) statement).getLargeMaxRows();
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return 0L;
        }
    }

    public long getLargeUpdateCount() throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return ((StatementImpl) statement).getLargeUpdateCount();
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return -1L;
        }
    }

    @Override // java.sql.Statement
    public int getMaxFieldSize() throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return statement.getMaxFieldSize();
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return 0;
        }
    }

    @Override // java.sql.Statement
    public int getMaxRows() throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return statement.getMaxRows();
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return 0;
        }
    }

    @Override // java.sql.Statement
    public boolean getMoreResults() throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return statement.getMoreResults();
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return false;
        }
    }

    @Override // java.sql.Statement
    public int getQueryTimeout() throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return statement.getQueryTimeout();
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return 0;
        }
    }

    @Override // java.sql.Statement
    public ResultSet getResultSet() throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement == null) {
                throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
            }
            ResultSet resultSet = statement.getResultSet();
            if (resultSet != null) {
                ((ResultSetInternalMethods) resultSet).setWrapperStatement(this);
            }
            return resultSet;
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // java.sql.Statement
    public int getResultSetConcurrency() throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return statement.getResultSetConcurrency();
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return 0;
        }
    }

    @Override // java.sql.Statement
    public int getResultSetHoldability() throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return statement.getResultSetHoldability();
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return 1;
        }
    }

    @Override // java.sql.Statement
    public int getResultSetType() throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return statement.getResultSetType();
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return MysqlErrorNumbers.ER_YES;
        }
    }

    @Override // java.sql.Statement
    public int getUpdateCount() throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return statement.getUpdateCount();
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return -1;
        }
    }

    @Override // java.sql.Statement
    public SQLWarning getWarnings() throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return statement.getWarnings();
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // java.sql.Statement
    public void setCursorName(String str) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement == null) {
                throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
            }
            statement.setCursorName(str);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    @Override // java.sql.Statement
    public void setEscapeProcessing(boolean z) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement == null) {
                throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
            }
            statement.setEscapeProcessing(z);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    @Override // java.sql.Statement
    public void setFetchDirection(int i) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement == null) {
                throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
            }
            statement.setFetchDirection(i);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    @Override // java.sql.Statement
    public void setFetchSize(int i) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement == null) {
                throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
            }
            statement.setFetchSize(i);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    public void setLargeMaxRows(long j) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement == null) {
                throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
            }
            ((StatementImpl) statement).setLargeMaxRows(j);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    @Override // java.sql.Statement
    public void setMaxFieldSize(int i) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement == null) {
                throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
            }
            statement.setMaxFieldSize(i);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    @Override // java.sql.Statement
    public void setMaxRows(int i) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement == null) {
                throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
            }
            statement.setMaxRows(i);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    @Override // java.sql.Statement
    public void setQueryTimeout(int i) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement == null) {
                throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
            }
            statement.setQueryTimeout(i);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    @Override // java.sql.Statement
    public boolean execute(String str, int[] iArr) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return statement.execute(str, iArr);
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return false;
        }
    }

    public long executeLargeUpdate(String str, int i) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return ((StatementImpl) statement).executeLargeUpdate(str, i);
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return -1L;
        }
    }

    @Override // java.sql.Statement
    public int executeUpdate(String str, int[] iArr) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return statement.executeUpdate(str, iArr);
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return -1;
        }
    }

    @Override // java.sql.Statement
    public boolean getMoreResults(int i) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return statement.getMoreResults(i);
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return false;
        }
    }

    @Override // java.sql.Statement
    public boolean execute(String str, String[] strArr) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return statement.execute(str, strArr);
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return false;
        }
    }

    public long executeLargeUpdate(String str, int[] iArr) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return ((StatementImpl) statement).executeLargeUpdate(str, iArr);
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return -1L;
        }
    }

    @Override // java.sql.Statement
    public int executeUpdate(String str, String[] strArr) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return statement.executeUpdate(str, strArr);
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return -1;
        }
    }

    @Override // java.sql.Statement
    public boolean execute(String str) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return statement.execute(str);
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return false;
        }
    }

    public long executeLargeUpdate(String str, String[] strArr) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return ((StatementImpl) statement).executeLargeUpdate(str, strArr);
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return -1L;
        }
    }

    @Override // java.sql.Statement
    public int executeUpdate(String str) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return statement.executeUpdate(str);
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return -1;
        }
    }
}
