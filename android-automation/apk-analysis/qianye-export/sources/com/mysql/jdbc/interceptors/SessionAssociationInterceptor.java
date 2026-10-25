package com.mysql.jdbc.interceptors;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetInternalMethods;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.StatementInterceptor;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class SessionAssociationInterceptor implements StatementInterceptor {
    public static final ThreadLocal<String> sessionLocal = new ThreadLocal<>();
    public String currentSessionKey;

    public static final String getSessionKey() {
        return sessionLocal.get();
    }

    public static final void resetSessionKey() {
        sessionLocal.set(null);
    }

    public static final void setSessionKey(String str) {
        sessionLocal.set(str);
    }

    @Override // com.mysql.jdbc.StatementInterceptor, com.mysql.jdbc.Extension
    public void destroy() {
    }

    @Override // com.mysql.jdbc.StatementInterceptor
    public boolean executeTopLevelOnly() {
        return true;
    }

    @Override // com.mysql.jdbc.StatementInterceptor, com.mysql.jdbc.Extension
    public void init(Connection connection, Properties properties) throws SQLException {
    }

    @Override // com.mysql.jdbc.StatementInterceptor
    public ResultSetInternalMethods postProcess(String str, Statement statement, ResultSetInternalMethods resultSetInternalMethods, Connection connection) throws SQLException {
        return null;
    }

    @Override // com.mysql.jdbc.StatementInterceptor
    public ResultSetInternalMethods preProcess(String str, Statement statement, Connection connection) throws SQLException {
        String sessionKey = getSessionKey();
        if (sessionKey == null || sessionKey.equals(this.currentSessionKey)) {
            return null;
        }
        PreparedStatement preparedStatementClientPrepareStatement = connection.clientPrepareStatement("SET @mysql_proxy_session=?");
        try {
            preparedStatementClientPrepareStatement.setString(1, sessionKey);
            preparedStatementClientPrepareStatement.execute();
            preparedStatementClientPrepareStatement.close();
            this.currentSessionKey = sessionKey;
            return null;
        } catch (Throwable th) {
            preparedStatementClientPrepareStatement.close();
            throw th;
        }
    }
}
