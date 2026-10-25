package com.mysql.jdbc.exceptions;

import java.sql.SQLException;

/* JADX INFO: loaded from: classes.dex */
public class MySQLNonTransientException extends SQLException {
    public static final long serialVersionUID = -8714521137552613517L;

    public MySQLNonTransientException() {
    }

    public MySQLNonTransientException(String str, String str2, int i) {
        super(str, str2, i);
    }

    public MySQLNonTransientException(String str, String str2) {
        super(str, str2);
    }

    public MySQLNonTransientException(String str) {
        super(str);
    }
}
