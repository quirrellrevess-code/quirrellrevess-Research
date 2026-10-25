package com.mysql.jdbc;

import java.sql.SQLException;

/* JADX INFO: loaded from: classes.dex */
public interface ExceptionInterceptor extends Extension {
    SQLException interceptException(SQLException sQLException, Connection connection);
}
