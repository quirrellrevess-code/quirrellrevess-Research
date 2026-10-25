package com.mysql.jdbc.exceptions.jdbc4;

import com.mysql.jdbc.Messages;
import com.mysql.jdbc.MySQLConnection;
import com.mysql.jdbc.SQLError;
import com.mysql.jdbc.StreamingNotifiable;
import java.sql.SQLRecoverableException;

/* JADX INFO: loaded from: classes.dex */
public class CommunicationsException extends SQLRecoverableException implements StreamingNotifiable {
    public static final long serialVersionUID = 4317904269797988677L;
    private String exceptionMessage;

    public CommunicationsException(MySQLConnection mySQLConnection, long j, long j2, Exception exc) {
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
