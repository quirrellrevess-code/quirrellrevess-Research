package com.mysql.jdbc;

import java.sql.Array;
import java.sql.NClob;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Struct;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class JDBC4Connection extends ConnectionImpl implements JDBC4MySQLConnection {
    private static final long serialVersionUID = 2877471301981509475L;
    private JDBC4ClientInfoProvider infoProvider;

    public JDBC4Connection(String str, int i, Properties properties, String str2, String str3) throws SQLException {
        super(str, i, properties, str2, str3);
    }

    @Override // java.sql.Connection, com.mysql.jdbc.JDBC4MySQLConnection
    public Array createArrayOf(String str, Object[] objArr) throws SQLException {
        throw SQLError.createSQLFeatureNotSupportedException();
    }

    @Override // java.sql.Connection, com.mysql.jdbc.JDBC4MySQLConnection
    public java.sql.Blob createBlob() {
        return new Blob(getExceptionInterceptor());
    }

    @Override // java.sql.Connection, com.mysql.jdbc.JDBC4MySQLConnection
    public java.sql.Clob createClob() {
        return new Clob(getExceptionInterceptor());
    }

    @Override // java.sql.Connection, com.mysql.jdbc.JDBC4MySQLConnection
    public NClob createNClob() {
        return new JDBC4NClob(getExceptionInterceptor());
    }

    @Override // java.sql.Connection, com.mysql.jdbc.JDBC4MySQLConnection
    public SQLXML createSQLXML() throws SQLException {
        return new JDBC4MysqlSQLXML(getExceptionInterceptor());
    }

    @Override // java.sql.Connection, com.mysql.jdbc.JDBC4MySQLConnection
    public Struct createStruct(String str, Object[] objArr) throws SQLException {
        throw SQLError.createSQLFeatureNotSupportedException();
    }

    @Override // java.sql.Connection, com.mysql.jdbc.JDBC4MySQLConnection
    public Properties getClientInfo() throws SQLException {
        return getClientInfoProviderImpl().getClientInfo(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.mysql.jdbc.JDBC4ClientInfoProvider] */
    @Override // com.mysql.jdbc.JDBC4MySQLConnection
    public JDBC4ClientInfoProvider getClientInfoProviderImpl() throws SQLException {
        JDBC4ClientInfoProvider jDBC4ClientInfoProvider;
        synchronized (getConnectionMutex()) {
            if (this.infoProvider == null) {
                ?? r1 = 0;
                try {
                    try {
                        this.infoProvider = (JDBC4ClientInfoProvider) Util.getInstance(getClientInfoProvider(), new Class[0], new Object[0], getExceptionInterceptor());
                    } catch (SQLException e) {
                        if (e.getCause() instanceof ClassCastException) {
                            this.infoProvider = (JDBC4ClientInfoProvider) Util.getInstance("com.mysql.jdbc." + getClientInfoProvider(), new Class[0], new Object[0], getExceptionInterceptor());
                        }
                    }
                    r1 = this.infoProvider;
                    r1.initialize(this, this.props);
                } catch (ClassCastException unused) {
                    Object[] objArr = new Object[1];
                    objArr[r1] = getClientInfoProvider();
                    throw SQLError.createSQLException(Messages.getString("JDBC4Connection.ClientInfoNotImplemented", objArr), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                }
            }
            jDBC4ClientInfoProvider = this.infoProvider;
        }
        return jDBC4ClientInfoProvider;
    }

    @Override // java.sql.Connection, com.mysql.jdbc.JDBC4MySQLConnection
    public boolean isValid(int i) throws SQLException {
        synchronized (getConnectionMutex()) {
            if (isClosed()) {
                return false;
            }
            try {
                try {
                    pingInternal(false, i * 1000);
                    return true;
                } catch (Throwable unused) {
                    return false;
                }
            } catch (Throwable unused2) {
                abortInternal();
                return false;
            }
        }
    }

    @Override // java.sql.Wrapper, com.mysql.jdbc.JDBC4MySQLConnection
    public boolean isWrapperFor(Class<?> cls) throws SQLException {
        checkClosed();
        return cls.isInstance(this);
    }

    @Override // java.sql.Connection, com.mysql.jdbc.JDBC4MySQLConnection
    public void setClientInfo(Properties properties) throws SQLClientInfoException {
        try {
            getClientInfoProviderImpl().setClientInfo(this, properties);
        } catch (SQLClientInfoException e) {
            throw e;
        } catch (SQLException e2) {
            SQLClientInfoException sQLClientInfoException = new SQLClientInfoException();
            sQLClientInfoException.initCause(e2);
            throw sQLClientInfoException;
        }
    }

    @Override // java.sql.Wrapper, com.mysql.jdbc.JDBC4MySQLConnection
    public <T> T unwrap(Class<T> cls) throws SQLException {
        try {
            return cls.cast(this);
        } catch (ClassCastException unused) {
            throw SQLError.createSQLException("Unable to unwrap to " + cls.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
    }

    @Override // java.sql.Connection, com.mysql.jdbc.JDBC4MySQLConnection
    public String getClientInfo(String str) throws SQLException {
        return getClientInfoProviderImpl().getClientInfo(this, str);
    }

    @Override // java.sql.Connection, com.mysql.jdbc.JDBC4MySQLConnection
    public void setClientInfo(String str, String str2) throws SQLClientInfoException {
        try {
            getClientInfoProviderImpl().setClientInfo(this, str, str2);
        } catch (SQLClientInfoException e) {
            throw e;
        } catch (SQLException e2) {
            SQLClientInfoException sQLClientInfoException = new SQLClientInfoException();
            sQLClientInfoException.initCause(e2);
            throw sQLClientInfoException;
        }
    }
}
