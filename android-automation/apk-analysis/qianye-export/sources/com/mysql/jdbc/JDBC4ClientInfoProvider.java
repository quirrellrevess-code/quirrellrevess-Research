package com.mysql.jdbc;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public interface JDBC4ClientInfoProvider {
    void destroy() throws SQLException;

    String getClientInfo(java.sql.Connection connection, String str) throws SQLException;

    Properties getClientInfo(java.sql.Connection connection) throws SQLException;

    void initialize(java.sql.Connection connection, Properties properties) throws SQLException;

    void setClientInfo(java.sql.Connection connection, String str, String str2) throws SQLClientInfoException;

    void setClientInfo(java.sql.Connection connection, Properties properties) throws SQLClientInfoException;
}
