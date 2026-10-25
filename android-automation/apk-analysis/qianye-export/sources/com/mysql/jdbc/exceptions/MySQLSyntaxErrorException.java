package com.mysql.jdbc.exceptions;

/* JADX INFO: loaded from: classes.dex */
public class MySQLSyntaxErrorException extends MySQLNonTransientException {
    public static final long serialVersionUID = 6919059513432113764L;

    public MySQLSyntaxErrorException() {
    }

    public MySQLSyntaxErrorException(String str, String str2, int i) {
        super(str, str2, i);
    }

    public MySQLSyntaxErrorException(String str, String str2) {
        super(str, str2);
    }

    public MySQLSyntaxErrorException(String str) {
        super(str);
    }
}
