package com.mysql.jdbc.exceptions;

import java.sql.SQLException;

/* JADX INFO: loaded from: classes.dex */
public class MySQLTransientException extends SQLException {
    public static final long serialVersionUID = -1885878228558607563L;

    public MySQLTransientException(String str, String str2, int i) {
        super(str, str2, i);
    }

    public MySQLTransientException(String str, String str2) {
        super(str, str2);
    }

    public MySQLTransientException(String str) {
        super(str);
    }

    public MySQLTransientException() {
    }
}
