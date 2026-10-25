package com.mysql.jdbc;

import java.sql.SQLException;

/* JADX INFO: loaded from: classes.dex */
public class NdbLoadBalanceExceptionChecker extends StandardLoadBalanceExceptionChecker {
    private boolean checkNdbException(SQLException sQLException) {
        return sQLException.getMessage().startsWith("Lock wait timeout exceeded") || (sQLException.getMessage().startsWith("Got temporary error") && sQLException.getMessage().endsWith("from NDB"));
    }

    @Override // com.mysql.jdbc.StandardLoadBalanceExceptionChecker, com.mysql.jdbc.LoadBalanceExceptionChecker
    public boolean shouldExceptionTriggerFailover(SQLException sQLException) {
        return super.shouldExceptionTriggerFailover(sQLException) || checkNdbException(sQLException);
    }
}
