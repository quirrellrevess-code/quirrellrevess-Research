package com.mysql.jdbc;

import java.sql.Array;
import java.sql.NClob;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Struct;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public interface JDBC4MySQLConnection extends MySQLConnection {
    Array createArrayOf(String str, Object[] objArr) throws SQLException;

    java.sql.Blob createBlob();

    java.sql.Clob createClob();

    NClob createNClob();

    SQLXML createSQLXML() throws SQLException;

    Struct createStruct(String str, Object[] objArr) throws SQLException;

    String getClientInfo(String str) throws SQLException;

    Properties getClientInfo() throws SQLException;

    JDBC4ClientInfoProvider getClientInfoProviderImpl() throws SQLException;

    boolean isValid(int i) throws SQLException;

    boolean isWrapperFor(Class<?> cls) throws SQLException;

    void setClientInfo(String str, String str2) throws SQLClientInfoException;

    void setClientInfo(Properties properties) throws SQLClientInfoException;

    <T> T unwrap(Class<T> cls) throws SQLException;
}
