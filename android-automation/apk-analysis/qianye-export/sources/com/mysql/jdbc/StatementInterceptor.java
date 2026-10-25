package com.mysql.jdbc;

import java.sql.SQLException;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public interface StatementInterceptor extends Extension {
    @Override // com.mysql.jdbc.Extension
    void destroy();

    boolean executeTopLevelOnly();

    @Override // com.mysql.jdbc.Extension
    void init(Connection connection, Properties properties) throws SQLException;

    ResultSetInternalMethods postProcess(String str, Statement statement, ResultSetInternalMethods resultSetInternalMethods, Connection connection) throws SQLException;

    ResultSetInternalMethods preProcess(String str, Statement statement, Connection connection) throws SQLException;
}
