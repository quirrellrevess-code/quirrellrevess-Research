package com.mysql.jdbc;

import java.rmi.server.UID;
import java.sql.SQLException;
import java.sql.Savepoint;

/* JADX INFO: loaded from: classes.dex */
public class MysqlSavepoint implements Savepoint {
    private ExceptionInterceptor exceptionInterceptor;
    private String savepointName;

    public MysqlSavepoint(ExceptionInterceptor exceptionInterceptor) throws SQLException {
        this(getUniqueId(), exceptionInterceptor);
    }

    private static String getUniqueId() {
        String string = new UID().toString();
        int length = string.length();
        StringBuilder sb = new StringBuilder(length + 1);
        sb.append(StringUtils.WILDCARD_ONE);
        for (int i = 0; i < length; i++) {
            char cCharAt = string.charAt(i);
            if (Character.isLetter(cCharAt) || Character.isDigit(cCharAt)) {
                sb.append(cCharAt);
            } else {
                sb.append(StringUtils.WILDCARD_ONE);
            }
        }
        return sb.toString();
    }

    @Override // java.sql.Savepoint
    public int getSavepointId() throws SQLException {
        throw SQLError.createSQLException("Only named savepoints are supported.", SQLError.SQL_STATE_DRIVER_NOT_CAPABLE, this.exceptionInterceptor);
    }

    @Override // java.sql.Savepoint
    public String getSavepointName() throws SQLException {
        return this.savepointName;
    }

    public MysqlSavepoint(String str, ExceptionInterceptor exceptionInterceptor) throws SQLException {
        if (str == null || str.length() == 0) {
            throw SQLError.createSQLException("Savepoint name can not be NULL or empty", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
        }
        this.savepointName = str;
        this.exceptionInterceptor = exceptionInterceptor;
    }
}
