package com.mysql.jdbc;

import java.sql.SQLException;

/* JADX INFO: loaded from: classes.dex */
public class CommunicationsException extends SQLException implements StreamingNotifiable {
    public static final long serialVersionUID = 3193864990663398317L;
    private String exceptionMessage;

    public CommunicationsException(MySQLConnection mySQLConnection, long j, long j2, Exception exc) {
        this.exceptionMessage = null;
        this.exceptionMessage = SQLError.createLinkFailureMessageBasedOnHeuristics(mySQLConnection, j, j2, exc);
        if (exc != null) {
            initCause(exc);
        }
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.exceptionMessage;
    }

    @Override // java.sql.SQLException
    public String getSQLState() {
        return SQLError.SQL_STATE_COMMUNICATION_LINK_FAILURE;
    }

    @Override // com.mysql.jdbc.StreamingNotifiable
    public void setWasStreamingResults() {
        this.exceptionMessage = Messages.getString("CommunicationsException.ClientWasStreaming");
    }
}
