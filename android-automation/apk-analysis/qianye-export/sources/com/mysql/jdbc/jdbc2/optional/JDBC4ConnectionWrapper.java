package com.mysql.jdbc.jdbc2.optional;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.SQLError;
import java.lang.reflect.Proxy;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.NClob;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Struct;
import java.util.HashMap;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class JDBC4ConnectionWrapper extends ConnectionWrapper {
    public JDBC4ConnectionWrapper(MysqlPooledConnection mysqlPooledConnection, Connection connection, boolean z) throws SQLException {
        super(mysqlPooledConnection, connection, z);
    }

    @Override // com.mysql.jdbc.jdbc2.optional.ConnectionWrapper, java.sql.Connection, java.lang.AutoCloseable
    public void close() throws SQLException {
        try {
            super.close();
        } finally {
            this.unwrappedInterfaces = null;
        }
    }

    @Override // java.sql.Connection
    public Array createArrayOf(String str, Object[] objArr) throws SQLException {
        checkClosed();
        try {
            return this.f85mc.createArrayOf(str, objArr);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // java.sql.Connection
    public Blob createBlob() throws SQLException {
        checkClosed();
        try {
            return this.f85mc.createBlob();
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // java.sql.Connection
    public Clob createClob() throws SQLException {
        checkClosed();
        try {
            return this.f85mc.createClob();
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // java.sql.Connection
    public NClob createNClob() throws SQLException {
        checkClosed();
        try {
            return this.f85mc.createNClob();
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // java.sql.Connection
    public SQLXML createSQLXML() throws SQLException {
        checkClosed();
        try {
            return this.f85mc.createSQLXML();
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // java.sql.Connection
    public Struct createStruct(String str, Object[] objArr) throws SQLException {
        checkClosed();
        try {
            return this.f85mc.createStruct(str, objArr);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // java.sql.Connection
    public Properties getClientInfo() throws SQLException {
        checkClosed();
        try {
            return this.f85mc.getClientInfo();
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // java.sql.Connection
    public synchronized boolean isValid(int i) throws SQLException {
        try {
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return false;
        }
        return this.f85mc.isValid(i);
    }

    @Override // java.sql.Wrapper
    public boolean isWrapperFor(Class<?> cls) throws SQLException {
        checkClosed();
        return cls.isInstance(this) || cls.getName().equals("com.mysql.jdbc.Connection") || cls.getName().equals("com.mysql.jdbc.ConnectionProperties");
    }

    @Override // java.sql.Connection
    public void setClientInfo(Properties properties) throws SQLClientInfoException {
        try {
            checkClosed();
            this.f85mc.setClientInfo(properties);
        } catch (SQLException e) {
            try {
                checkAndFireConnectionError(e);
            } catch (SQLException e2) {
                SQLClientInfoException sQLClientInfoException = new SQLClientInfoException();
                sQLClientInfoException.initCause(e2);
                throw sQLClientInfoException;
            }
        }
    }

    @Override // java.sql.Wrapper
    public synchronized <T> T unwrap(Class<T> cls) throws SQLException {
        try {
            if (!"java.sql.Connection".equals(cls.getName()) && !"java.sql.Wrapper.class".equals(cls.getName())) {
                if (this.unwrappedInterfaces == null) {
                    this.unwrappedInterfaces = new HashMap();
                }
                Object objNewProxyInstance = this.unwrappedInterfaces.get(cls);
                if (objNewProxyInstance == null) {
                    objNewProxyInstance = Proxy.newProxyInstance(this.f85mc.getClass().getClassLoader(), new Class[]{cls}, new WrapperBase.ConnectionErrorFiringInvocationHandler(this.f85mc));
                    this.unwrappedInterfaces.put(cls, objNewProxyInstance);
                }
                return cls.cast(objNewProxyInstance);
            }
            return cls.cast(this);
        } catch (ClassCastException unused) {
            throw SQLError.createSQLException("Unable to unwrap to " + cls.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        }
    }

    @Override // java.sql.Connection
    public String getClientInfo(String str) throws SQLException {
        checkClosed();
        try {
            return this.f85mc.getClientInfo(str);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // java.sql.Connection
    public void setClientInfo(String str, String str2) throws SQLClientInfoException {
        try {
            checkClosed();
            this.f85mc.setClientInfo(str, str2);
        } catch (SQLException e) {
            try {
                checkAndFireConnectionError(e);
            } catch (SQLException e2) {
                SQLClientInfoException sQLClientInfoException = new SQLClientInfoException();
                sQLClientInfoException.initCause(e2);
                throw sQLClientInfoException;
            }
        }
    }
}
