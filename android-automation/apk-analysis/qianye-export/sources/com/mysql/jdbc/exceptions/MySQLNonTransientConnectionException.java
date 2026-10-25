package com.mysql.jdbc.exceptions;

/* JADX INFO: loaded from: classes.dex */
public class MySQLNonTransientConnectionException extends MySQLNonTransientException {
    public static final long serialVersionUID = -3050543822763367670L;

    public MySQLNonTransientConnectionException() {
    }

    public MySQLNonTransientConnectionException(String str, String str2, int i) {
        super(str, str2, i);
    }

    public MySQLNonTransientConnectionException(String str, String str2) {
        super(str, str2);
    }

    public MySQLNonTransientConnectionException(String str) {
        super(str);
    }
}
