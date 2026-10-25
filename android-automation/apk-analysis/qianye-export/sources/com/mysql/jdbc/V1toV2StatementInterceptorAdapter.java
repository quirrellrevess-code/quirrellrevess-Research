package com.mysql.jdbc;

import java.sql.SQLException;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class V1toV2StatementInterceptorAdapter implements StatementInterceptorV2 {
    private final StatementInterceptor toProxy;

    public V1toV2StatementInterceptorAdapter(StatementInterceptor statementInterceptor) {
        this.toProxy = statementInterceptor;
    }

    @Override // com.mysql.jdbc.StatementInterceptorV2, com.mysql.jdbc.Extension
    public void destroy() {
        this.toProxy.destroy();
    }

    @Override // com.mysql.jdbc.StatementInterceptorV2
    public boolean executeTopLevelOnly() {
        return this.toProxy.executeTopLevelOnly();
    }

    @Override // com.mysql.jdbc.StatementInterceptorV2, com.mysql.jdbc.Extension
    public void init(Connection connection, Properties properties) throws SQLException {
        this.toProxy.init(connection, properties);
    }

    @Override // com.mysql.jdbc.StatementInterceptorV2
    public ResultSetInternalMethods postProcess(String str, Statement statement, ResultSetInternalMethods resultSetInternalMethods, Connection connection, int i, boolean z, boolean z2, SQLException sQLException) throws SQLException {
        return this.toProxy.postProcess(str, statement, resultSetInternalMethods, connection);
    }

    @Override // com.mysql.jdbc.StatementInterceptorV2
    public ResultSetInternalMethods preProcess(String str, Statement statement, Connection connection) throws SQLException {
        return this.toProxy.preProcess(str, statement, connection);
    }
}
