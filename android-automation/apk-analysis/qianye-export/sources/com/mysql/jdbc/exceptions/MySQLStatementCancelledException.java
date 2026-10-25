package com.mysql.jdbc.exceptions;

/* JADX INFO: loaded from: classes.dex */
public class MySQLStatementCancelledException extends MySQLNonTransientException {
    public static final long serialVersionUID = -8762717748377197378L;

    public MySQLStatementCancelledException(String str, String str2, int i) {
        super(str, str2, i);
    }

    public MySQLStatementCancelledException(String str, String str2) {
        super(str, str2);
    }

    public MySQLStatementCancelledException(String str) {
        super(str);
    }

    public MySQLStatementCancelledException() {
        super("Statement cancelled due to client request");
    }
}
