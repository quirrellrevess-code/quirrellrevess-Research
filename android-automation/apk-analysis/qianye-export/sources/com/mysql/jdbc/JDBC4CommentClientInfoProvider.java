package com.mysql.jdbc;

import com.google.android.flexbox.BuildConfig;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class JDBC4CommentClientInfoProvider implements JDBC4ClientInfoProvider {
    private Properties clientInfo;

    private synchronized void setComment(java.sql.Connection connection) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : this.clientInfo.entrySet()) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(BuildConfig.FLAVOR + entry.getKey());
            sb.append("=");
            sb.append(BuildConfig.FLAVOR + entry.getValue());
        }
        ((Connection) connection).setStatementComment(sb.toString());
    }

    @Override // com.mysql.jdbc.JDBC4ClientInfoProvider
    public synchronized void destroy() throws SQLException {
        this.clientInfo = null;
    }

    @Override // com.mysql.jdbc.JDBC4ClientInfoProvider
    public synchronized Properties getClientInfo(java.sql.Connection connection) throws SQLException {
        return this.clientInfo;
    }

    @Override // com.mysql.jdbc.JDBC4ClientInfoProvider
    public synchronized void initialize(java.sql.Connection connection, Properties properties) throws SQLException {
        this.clientInfo = new Properties();
    }

    @Override // com.mysql.jdbc.JDBC4ClientInfoProvider
    public synchronized void setClientInfo(java.sql.Connection connection, Properties properties) throws SQLClientInfoException {
        this.clientInfo = new Properties();
        Enumeration<?> enumerationPropertyNames = properties.propertyNames();
        while (enumerationPropertyNames.hasMoreElements()) {
            String str = (String) enumerationPropertyNames.nextElement();
            this.clientInfo.put(str, properties.getProperty(str));
        }
        setComment(connection);
    }

    @Override // com.mysql.jdbc.JDBC4ClientInfoProvider
    public synchronized String getClientInfo(java.sql.Connection connection, String str) throws SQLException {
        return this.clientInfo.getProperty(str);
    }

    @Override // com.mysql.jdbc.JDBC4ClientInfoProvider
    public synchronized void setClientInfo(java.sql.Connection connection, String str, String str2) throws SQLClientInfoException {
        this.clientInfo.setProperty(str, str2);
        setComment(connection);
    }
}
