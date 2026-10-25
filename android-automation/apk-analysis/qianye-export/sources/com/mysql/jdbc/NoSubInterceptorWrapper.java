package com.mysql.jdbc;

import java.sql.SQLException;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class NoSubInterceptorWrapper implements StatementInterceptorV2 {
    private final StatementInterceptorV2 underlyingInterceptor;

    public NoSubInterceptorWrapper(StatementInterceptorV2 statementInterceptorV2) {
        if (statementInterceptorV2 == null) {
            throw new RuntimeException("Interceptor to be wrapped can not be NULL");
        }
        this.underlyingInterceptor = statementInterceptorV2;
    }

    @Override // com.mysql.jdbc.StatementInterceptorV2, com.mysql.jdbc.Extension
    public void destroy() {
        this.underlyingInterceptor.destroy();
    }

    @Override // com.mysql.jdbc.StatementInterceptorV2
    public boolean executeTopLevelOnly() {
        return this.underlyingInterceptor.executeTopLevelOnly();
    }

    public StatementInterceptorV2 getUnderlyingInterceptor() {
        return this.underlyingInterceptor;
    }

    @Override // com.mysql.jdbc.StatementInterceptorV2, com.mysql.jdbc.Extension
    public void init(Connection connection, Properties properties) throws SQLException {
        this.underlyingInterceptor.init(connection, properties);
    }

    @Override // com.mysql.jdbc.StatementInterceptorV2
    public ResultSetInternalMethods postProcess(String str, Statement statement, ResultSetInternalMethods resultSetInternalMethods, Connection connection, int i, boolean z, boolean z2, SQLException sQLException) throws SQLException {
        this.underlyingInterceptor.postProcess(str, statement, resultSetInternalMethods, connection, i, z, z2, sQLException);
        return null;
    }

    @Override // com.mysql.jdbc.StatementInterceptorV2
    public ResultSetInternalMethods preProcess(String str, Statement statement, Connection connection) throws SQLException {
        this.underlyingInterceptor.preProcess(str, statement, connection);
        return null;
    }
}
