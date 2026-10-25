package com.mysql.jdbc.exceptions;

/* JADX INFO: loaded from: classes.dex */
public class MySQLIntegrityConstraintViolationException extends MySQLNonTransientException {
    public static final long serialVersionUID = -5528363270635808904L;

    public MySQLIntegrityConstraintViolationException() {
    }

    public MySQLIntegrityConstraintViolationException(String str, String str2, int i) {
        super(str, str2, i);
    }

    public MySQLIntegrityConstraintViolationException(String str, String str2) {
        super(str, str2);
    }

    public MySQLIntegrityConstraintViolationException(String str) {
        super(str);
    }
}
