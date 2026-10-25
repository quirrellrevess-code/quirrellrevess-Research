package com.mysql.jdbc.exceptions.jdbc4;

import java.sql.SQLDataException;

/* JADX INFO: loaded from: classes.dex */
public class MySQLDataException extends SQLDataException {
    public static final long serialVersionUID = 4317904269797988676L;

    public MySQLDataException() {
    }

    public MySQLDataException(String str, String str2, int i) {
        super(str, str2, i);
    }

    public MySQLDataException(String str, String str2) {
        super(str, str2);
    }

    public MySQLDataException(String str) {
        super(str);
    }
}
