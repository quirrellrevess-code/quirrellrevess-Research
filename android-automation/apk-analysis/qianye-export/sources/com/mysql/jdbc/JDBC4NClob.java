package com.mysql.jdbc;

import java.sql.NClob;

/* JADX INFO: loaded from: classes.dex */
public class JDBC4NClob extends Clob implements NClob {
    public JDBC4NClob(ExceptionInterceptor exceptionInterceptor) {
        super(exceptionInterceptor);
    }

    public JDBC4NClob(String str, ExceptionInterceptor exceptionInterceptor) {
        super(str, exceptionInterceptor);
    }
}
