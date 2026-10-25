package com.mysql.jdbc.exceptions.jdbc4;

import com.mysql.jdbc.exceptions.DeadlockTimeoutRollbackMarker;
import java.sql.SQLTransactionRollbackException;

/* JADX INFO: loaded from: classes.dex */
public class MySQLTransactionRollbackException extends SQLTransactionRollbackException implements DeadlockTimeoutRollbackMarker {
    public static final long serialVersionUID = 6034999468737801730L;

    public MySQLTransactionRollbackException(String str, String str2, int i) {
        super(str, str2, i);
    }

    public MySQLTransactionRollbackException(String str, String str2) {
        super(str, str2);
    }

    public MySQLTransactionRollbackException(String str) {
        super(str);
    }

    public MySQLTransactionRollbackException() {
    }
}
