package com.mysql.jdbc.jdbc2.optional;

import com.mysql.jdbc.SQLError;
import java.lang.reflect.Proxy;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class JDBC4StatementWrapper extends StatementWrapper {
    public JDBC4StatementWrapper(ConnectionWrapper connectionWrapper, MysqlPooledConnection mysqlPooledConnection, Statement statement) {
        super(connectionWrapper, mysqlPooledConnection, statement);
    }

    @Override // com.mysql.jdbc.jdbc2.optional.StatementWrapper, java.sql.Statement, java.lang.AutoCloseable
    public void close() throws SQLException {
        try {
            super.close();
        } finally {
            this.unwrappedInterfaces = null;
        }
    }

    @Override // java.sql.Statement
    public boolean isClosed() throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return statement.isClosed();
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return false;
        }
    }

    @Override // java.sql.Statement
    public boolean isPoolable() throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement != null) {
                return statement.isPoolable();
            }
            throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return false;
        }
    }

    @Override // java.sql.Wrapper
    public boolean isWrapperFor(Class<?> cls) throws SQLException {
        if (cls.isInstance(this)) {
            return true;
        }
        String name = cls.getName();
        return name.equals("com.mysql.jdbc.Statement") || name.equals("java.sql.Statement") || name.equals("java.sql.Wrapper");
    }

    @Override // java.sql.Statement
    public void setPoolable(boolean z) throws SQLException {
        try {
            Statement statement = this.wrappedStmt;
            if (statement == null) {
                throw SQLError.createSQLException("Statement already closed", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
            }
            statement.setPoolable(z);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    @Override // java.sql.Wrapper
    public synchronized <T> T unwrap(Class<T> cls) throws SQLException {
        try {
            if (!"java.sql.Statement".equals(cls.getName()) && !"java.sql.Wrapper.class".equals(cls.getName())) {
                if (this.unwrappedInterfaces == null) {
                    this.unwrappedInterfaces = new HashMap();
                }
                Object objNewProxyInstance = this.unwrappedInterfaces.get(cls);
                if (objNewProxyInstance == null) {
                    objNewProxyInstance = Proxy.newProxyInstance(this.wrappedStmt.getClass().getClassLoader(), new Class[]{cls}, new WrapperBase.ConnectionErrorFiringInvocationHandler(this.wrappedStmt));
                    this.unwrappedInterfaces.put(cls, objNewProxyInstance);
                }
                return cls.cast(objNewProxyInstance);
            }
            return cls.cast(this);
        } catch (ClassCastException unused) {
            throw SQLError.createSQLException("Unable to unwrap to " + cls.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        }
    }
}
