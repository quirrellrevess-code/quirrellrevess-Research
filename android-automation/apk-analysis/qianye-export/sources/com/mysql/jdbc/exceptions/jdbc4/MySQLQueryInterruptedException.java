package com.mysql.jdbc.exceptions.jdbc4;

/* JADX INFO: loaded from: classes.dex */
public class MySQLQueryInterruptedException extends MySQLNonTransientException {
    private static final long serialVersionUID = -8714521137662613517L;

    public MySQLQueryInterruptedException() {
    }

    public MySQLQueryInterruptedException(String str, String str2, int i) {
        super(str, str2, i);
    }

    public MySQLQueryInterruptedException(String str, String str2) {
        super(str, str2);
    }

    public MySQLQueryInterruptedException(String str) {
        super(str);
    }
}
