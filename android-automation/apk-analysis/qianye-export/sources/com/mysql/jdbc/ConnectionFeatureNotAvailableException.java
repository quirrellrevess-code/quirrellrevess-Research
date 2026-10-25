package com.mysql.jdbc;

/* JADX INFO: loaded from: classes.dex */
public class ConnectionFeatureNotAvailableException extends CommunicationsException {
    public static final long serialVersionUID = -5065030488729238287L;

    public ConnectionFeatureNotAvailableException(MySQLConnection mySQLConnection, long j, Exception exc) {
        super(mySQLConnection, j, 0L, exc);
    }

    @Override // com.mysql.jdbc.CommunicationsException, java.lang.Throwable
    public String getMessage() {
        return "Feature not available in this distribution of Connector/J";
    }

    @Override // com.mysql.jdbc.CommunicationsException, java.sql.SQLException
    public String getSQLState() {
        return SQLError.SQL_STATE_INVALID_CONNECTION_ATTRIBUTE;
    }
}
