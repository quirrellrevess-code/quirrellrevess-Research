package com.mysql.jdbc.exceptions.jdbc4;

import java.sql.SQLTimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class MySQLTimeoutException extends SQLTimeoutException {
    public static final long serialVersionUID = -789621240523230339L;

    public MySQLTimeoutException(String str, String str2, int i) {
        super(str, str2, i);
    }

    @Override // java.sql.SQLException
    public int getErrorCode() {
        return super.getErrorCode();
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
