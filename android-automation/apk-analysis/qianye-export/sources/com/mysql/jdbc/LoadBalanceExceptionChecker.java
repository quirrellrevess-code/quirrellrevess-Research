package com.mysql.jdbc;

import java.sql.SQLException;

/* JADX INFO: loaded from: classes.dex */
public interface LoadBalanceExceptionChecker extends Extension {
    boolean shouldExceptionTriggerFailover(SQLException sQLException);
}
