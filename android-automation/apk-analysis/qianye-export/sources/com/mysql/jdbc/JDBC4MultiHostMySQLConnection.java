package com.mysql.jdbc;

import java.sql.Array;
import java.sql.NClob;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Struct;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class JDBC4MultiHostMySQLConnection extends MultiHostMySQLConnection implements JDBC4MySQLConnection {
    public JDBC4MultiHostMySQLConnection(MultiHostConnectionProxy multiHostConnectionProxy) throws SQLException {
        super(multiHostConnectionProxy);
    }

    private JDBC4Connection getJDBC4Connection() {
        return (JDBC4Connection) getThisAsProxy().currentConnection;
    }

    @Override // java.sql.Connection, com.mysql.jdbc.JDBC4MySQLConnection
    public Array createArrayOf(String str, Object[] objArr) throws SQLException {
        return getJDBC4Connection().createArrayOf(str, objArr);
    }

    @Override // java.sql.Connection, com.mysql.jdbc.JDBC4MySQLConnection
    public java.sql.Blob createBlob() {
        return getJDBC4Connection().createBlob();
    }

    @Override // java.sql.Connection, com.mysql.jdbc.JDBC4MySQLConnection
    public java.sql.Clob createClob() {
        return getJDBC4Connection().createClob();
    }

    @Override // java.sql.Connection, com.mysql.jdbc.JDBC4MySQLConnection
    public NClob createNClob() {
        return getJDBC4Connection().createNClob();
    }

    @Override // java.sql.Connection, com.mysql.jdbc.JDBC4MySQLConnection
    public SQLXML createSQLXML() throws SQLException {
        return getJDBC4Connection().createSQLXML();
    }

    @Override // java.sql.Connection, com.mysql.jdbc.JDBC4MySQLConnection
    public Struct createStruct(String str, Object[] objArr) throws SQLException {
        return getJDBC4Connection().createStruct(str, objArr);
    }

    @Override // java.sql.Connection, com.mysql.jdbc.JDBC4MySQLConnection
    public Properties getClientInfo() throws SQLException {
        return getJDBC4Connection().getClientInfo();
    }

    @Override // com.mysql.jdbc.JDBC4MySQLConnection
    public JDBC4ClientInfoProvider getClientInfoProviderImpl() throws SQLException {
        JDBC4ClientInfoProvider clientInfoProviderImpl;
        synchronized (getThisAsProxy()) {
            clientInfoProviderImpl = getJDBC4Connection().getClientInfoProviderImpl();
        }
        return clientInfoProviderImpl;
    }

    @Override // java.sql.Connection, com.mysql.jdbc.JDBC4MySQLConnection
    public boolean isValid(int i) throws SQLException {
        boolean zIsValid;
        synchronized (getThisAsProxy()) {
            zIsValid = getJDBC4Connection().isValid(i);
        }
        return zIsValid;
    }

    @Override // java.sql.Wrapper, com.mysql.jdbc.JDBC4MySQLConnection
    public boolean isWrapperFor(Class<?> cls) throws SQLException {
        checkClosed();
        return cls.isInstance(this);
    }

    @Override // java.sql.Connection, com.mysql.jdbc.JDBC4MySQLConnection
    public void setClientInfo(Properties properties) throws SQLClientInfoException {
        getJDBC4Connection().setClientInfo(properties);
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
        return getJDBC4Connection().getClientInfo(str);
    }

    @Override // java.sql.Connection, com.mysql.jdbc.JDBC4MySQLConnection
    public void setClientInfo(String str, String str2) throws SQLClientInfoException {
        getJDBC4Connection().setClientInfo(str, str2);
    }
}
