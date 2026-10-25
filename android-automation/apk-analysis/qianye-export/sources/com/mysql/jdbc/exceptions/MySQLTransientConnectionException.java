package com.mysql.jdbc.exceptions;

/* JADX INFO: loaded from: classes.dex */
public class MySQLTransientConnectionException extends MySQLTransientException {
    public static final long serialVersionUID = 8699144578759941201L;

    public MySQLTransientConnectionException(String str, String str2, int i) {
        super(str, str2, i);
    }

    public MySQLTransientConnectionException(String str, String str2) {
        super(str, str2);
    }

    public MySQLTransientConnectionException(String str) {
        super(str);
    }

    public MySQLTransientConnectionException() {
    }
}
