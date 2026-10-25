package com.mysql.jdbc.exceptions;

/* JADX INFO: loaded from: classes.dex */
public class MySQLTimeoutException extends MySQLTransientException {
    public static final long serialVersionUID = -789621240523230339L;

    public MySQLTimeoutException(String str, String str2, int i) {
        super(str, str2, i);
    }

    public MySQLTimeoutException(String str, String str2) {
        super(str, str2);
    }

    public MySQLTimeoutException(String str) {
        super(str);
    }

    public MySQLTimeoutException() {
        super("Statement cancelled due to timeout or client request");
    }
}
