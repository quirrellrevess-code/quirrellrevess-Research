package com.mysql.jdbc;

import com.google.android.flexbox.BuildConfig;
import java.sql.SQLException;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class LoadBalancedAutoCommitInterceptor implements StatementInterceptorV2 {
    private ConnectionImpl conn;
    private String matchingAfterStatementRegex;
    private int matchingAfterStatementCount = 0;
    private int matchingAfterStatementThreshold = 0;
    private LoadBalancedConnectionProxy proxy = null;
    private boolean countStatements = false;

    @Override // com.mysql.jdbc.StatementInterceptorV2, com.mysql.jdbc.Extension
    public void destroy() {
    }

    @Override // com.mysql.jdbc.StatementInterceptorV2
    public boolean executeTopLevelOnly() {
        return false;
    }

    @Override // com.mysql.jdbc.StatementInterceptorV2, com.mysql.jdbc.Extension
    public void init(Connection connection, Properties properties) throws SQLException {
        this.conn = (ConnectionImpl) connection;
        try {
            this.matchingAfterStatementThreshold = Integer.parseInt(properties.getProperty("loadBalanceAutoCommitStatementThreshold", "0"));
        } catch (NumberFormatException unused) {
        }
        String property = properties.getProperty("loadBalanceAutoCommitStatementRegex", BuildConfig.FLAVOR);
        if (BuildConfig.FLAVOR.equals(property)) {
            return;
        }
        this.matchingAfterStatementRegex = property;
    }

    public void pauseCounters() {
        this.countStatements = false;
    }

    @Override // com.mysql.jdbc.StatementInterceptorV2
    public ResultSetInternalMethods postProcess(String str, Statement statement, ResultSetInternalMethods resultSetInternalMethods, Connection connection, int i, boolean z, boolean z2, SQLException sQLException) throws SQLException {
        if (this.countStatements && !StringUtils.startsWithIgnoreCase(str, "SET") && !StringUtils.startsWithIgnoreCase(str, "SHOW")) {
            if (!this.conn.getAutoCommit()) {
                this.matchingAfterStatementCount = 0;
                return resultSetInternalMethods;
            }
            if (this.proxy == null && this.conn.isProxySet()) {
                MySQLConnection multiHostSafeProxy = this.conn.getMultiHostSafeProxy();
                while (multiHostSafeProxy != null && !(multiHostSafeProxy instanceof LoadBalancedMySQLConnection)) {
                    multiHostSafeProxy = multiHostSafeProxy.getMultiHostSafeProxy();
                }
                if (multiHostSafeProxy != null) {
                    this.proxy = ((LoadBalancedMySQLConnection) multiHostSafeProxy).getThisAsProxy();
                }
            }
            if (this.proxy == null) {
                return resultSetInternalMethods;
            }
            String str2 = this.matchingAfterStatementRegex;
            if (str2 == null || str.matches(str2)) {
                this.matchingAfterStatementCount++;
            }
            if (this.matchingAfterStatementCount >= this.matchingAfterStatementThreshold) {
                this.matchingAfterStatementCount = 0;
                try {
                    this.proxy.pickNewConnection();
                } catch (SQLException unused) {
                }
            }
        }
        return resultSetInternalMethods;
    }

    @Override // com.mysql.jdbc.StatementInterceptorV2
    public ResultSetInternalMethods preProcess(String str, Statement statement, Connection connection) throws SQLException {
        return null;
    }

    public void resumeCounters() {
        this.countStatements = true;
    }
}
