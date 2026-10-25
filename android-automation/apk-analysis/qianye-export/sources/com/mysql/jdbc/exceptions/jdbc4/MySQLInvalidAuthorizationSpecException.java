package com.mysql.jdbc.exceptions.jdbc4;

import java.sql.SQLInvalidAuthorizationSpecException;

/* JADX INFO: loaded from: classes.dex */
public class MySQLInvalidAuthorizationSpecException extends SQLInvalidAuthorizationSpecException {
    public static final long serialVersionUID = 6878889837492500030L;

    public MySQLInvalidAuthorizationSpecException() {
    }

    public MySQLInvalidAuthorizationSpecException(String str, String str2, int i) {
        super(str, str2, i);
    }

    public MySQLInvalidAuthorizationSpecException(String str, String str2) {
        super(str, str2);
    }

    public MySQLInvalidAuthorizationSpecException(String str) {
        super(str);
    }
}
