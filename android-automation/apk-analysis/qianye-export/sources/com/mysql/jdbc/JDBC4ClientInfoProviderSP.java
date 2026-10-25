package com.mysql.jdbc;

import com.google.android.flexbox.BuildConfig;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class JDBC4ClientInfoProviderSP implements JDBC4ClientInfoProvider {
    public java.sql.PreparedStatement getClientInfoBulkSp;
    public java.sql.PreparedStatement getClientInfoSp;
    public java.sql.PreparedStatement setClientInfoSp;

    @Override // com.mysql.jdbc.JDBC4ClientInfoProvider
    public synchronized void destroy() throws SQLException {
        java.sql.PreparedStatement preparedStatement = this.setClientInfoSp;
        if (preparedStatement != null) {
            preparedStatement.close();
            this.setClientInfoSp = null;
        }
        java.sql.PreparedStatement preparedStatement2 = this.getClientInfoSp;
        if (preparedStatement2 != null) {
            preparedStatement2.close();
            this.getClientInfoSp = null;
        }
        java.sql.PreparedStatement preparedStatement3 = this.getClientInfoBulkSp;
        if (preparedStatement3 != null) {
            preparedStatement3.close();
            this.getClientInfoBulkSp = null;
        }
    }

    @Override // com.mysql.jdbc.JDBC4ClientInfoProvider
    public synchronized Properties getClientInfo(java.sql.Connection connection) throws SQLException {
        Properties properties;
        ResultSet resultSet = null;
        properties = new Properties();
        try {
            this.getClientInfoBulkSp.execute();
            resultSet = this.getClientInfoBulkSp.getResultSet();
            while (resultSet.next()) {
                properties.setProperty(resultSet.getString(1), resultSet.getString(2));
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (Throwable th) {
            if (resultSet != null) {
                resultSet.close();
            }
            throw th;
        }
        return properties;
    }

    @Override // com.mysql.jdbc.JDBC4ClientInfoProvider
    public synchronized void initialize(java.sql.Connection connection, Properties properties) throws SQLException {
        String identifierQuoteString = connection.getMetaData().getIdentifierQuoteString();
        String property = properties.getProperty("clientInfoSetSPName", "setClientInfo");
        String property2 = properties.getProperty("clientInfoGetSPName", "getClientInfo");
        String property3 = properties.getProperty("clientInfoGetBulkSPName", "getClientInfoBulk");
        String property4 = properties.getProperty("clientInfoCatalog", BuildConfig.FLAVOR);
        if (BuildConfig.FLAVOR.equals(property4)) {
            property4 = connection.getCatalog();
        }
        this.setClientInfoSp = ((Connection) connection).clientPrepareStatement("CALL " + identifierQuoteString + property4 + identifierQuoteString + "." + identifierQuoteString + property + identifierQuoteString + "(?, ?)");
        this.getClientInfoSp = ((Connection) connection).clientPrepareStatement("CALL" + identifierQuoteString + property4 + identifierQuoteString + "." + identifierQuoteString + property2 + identifierQuoteString + "(?)");
        this.getClientInfoBulkSp = ((Connection) connection).clientPrepareStatement("CALL " + identifierQuoteString + property4 + identifierQuoteString + "." + identifierQuoteString + property3 + identifierQuoteString + "()");
    }

    @Override // com.mysql.jdbc.JDBC4ClientInfoProvider
    public synchronized void setClientInfo(java.sql.Connection connection, Properties properties) throws SQLClientInfoException {
        try {
            Enumeration<?> enumerationPropertyNames = properties.propertyNames();
            while (enumerationPropertyNames.hasMoreElements()) {
                String str = (String) enumerationPropertyNames.nextElement();
                setClientInfo(connection, str, properties.getProperty(str));
            }
        } catch (SQLException e) {
            SQLClientInfoException sQLClientInfoException = new SQLClientInfoException();
            sQLClientInfoException.initCause(e);
            throw sQLClientInfoException;
        }
    }

    @Override // com.mysql.jdbc.JDBC4ClientInfoProvider
    public synchronized String getClientInfo(java.sql.Connection connection, String str) throws SQLException {
        ResultSet resultSet;
        Throwable th;
        String string;
        try {
            try {
                this.getClientInfoSp.setString(1, str);
                this.getClientInfoSp.execute();
                resultSet = this.getClientInfoSp.getResultSet();
                try {
                    string = resultSet.next() ? resultSet.getString(1) : null;
                    if (resultSet != null) {
                        resultSet.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                resultSet = null;
                th = th3;
            }
        } catch (Throwable th4) {
            throw th4;
        }
        return string;
    }

    @Override // com.mysql.jdbc.JDBC4ClientInfoProvider
    public synchronized void setClientInfo(java.sql.Connection connection, String str, String str2) throws SQLClientInfoException {
        try {
            this.setClientInfoSp.setString(1, str);
            this.setClientInfoSp.setString(2, str2);
            this.setClientInfoSp.execute();
        } catch (SQLException e) {
            SQLClientInfoException sQLClientInfoException = new SQLClientInfoException();
            sQLClientInfoException.initCause(e);
            throw sQLClientInfoException;
        }
    }
}
