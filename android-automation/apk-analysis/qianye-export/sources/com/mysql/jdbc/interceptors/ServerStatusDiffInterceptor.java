package com.mysql.jdbc.interceptors;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetInternalMethods;
import com.mysql.jdbc.StatementInterceptor;
import com.mysql.jdbc.Util;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class ServerStatusDiffInterceptor implements StatementInterceptor {
    private Map<String, String> preExecuteValues = new HashMap();
    private Map<String, String> postExecuteValues = new HashMap();

    private void populateMapWithSessionStatusValues(Connection connection, Map<String, String> map) throws Throwable {
        Statement statementCreateStatement;
        ResultSet resultSetExecuteQuery = null;
        try {
            map.clear();
            statementCreateStatement = connection.createStatement();
            try {
                resultSetExecuteQuery = statementCreateStatement.executeQuery("SHOW SESSION STATUS");
                Util.resultSetToMap(map, resultSetExecuteQuery);
                if (resultSetExecuteQuery != null) {
                    resultSetExecuteQuery.close();
                }
                if (statementCreateStatement != null) {
                    statementCreateStatement.close();
                }
            } catch (Throwable th) {
                th = th;
                if (resultSetExecuteQuery != null) {
                    resultSetExecuteQuery.close();
                }
                if (statementCreateStatement != null) {
                    statementCreateStatement.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            statementCreateStatement = null;
        }
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
    public ResultSetInternalMethods postProcess(String str, com.mysql.jdbc.Statement statement, ResultSetInternalMethods resultSetInternalMethods, Connection connection) throws Throwable {
        if (!connection.versionMeetsMinimum(5, 0, 2)) {
            return null;
        }
        populateMapWithSessionStatusValues(connection, this.postExecuteValues);
        connection.getLog().logInfo("Server status change for statement:\n" + Util.calculateDifferences(this.preExecuteValues, this.postExecuteValues));
        return null;
    }

    @Override // com.mysql.jdbc.StatementInterceptor
    public ResultSetInternalMethods preProcess(String str, com.mysql.jdbc.Statement statement, Connection connection) throws Throwable {
        if (!connection.versionMeetsMinimum(5, 0, 2)) {
            return null;
        }
        populateMapWithSessionStatusValues(connection, this.preExecuteValues);
        return null;
    }
}
