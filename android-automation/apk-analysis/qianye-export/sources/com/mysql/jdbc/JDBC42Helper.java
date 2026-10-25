package com.mysql.jdbc;

import java.sql.Date;
import java.sql.JDBCType;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/* JADX INFO: loaded from: classes.dex */
public class JDBC42Helper {
    public static int checkSqlType(int i, ExceptionInterceptor exceptionInterceptor) throws SQLException {
        if (isSqlTypeSupported(i)) {
            return i;
        }
        throw SQLError.createSQLFeatureNotSupportedException(Messages.getString("UnsupportedSQLType.0") + JDBCType.valueOf(i), SQLError.SQL_STATE_DRIVER_NOT_CAPABLE, exceptionInterceptor);
    }

    public static Object convertJavaTimeToJavaSql(Object obj) {
        if (obj instanceof LocalDate) {
            return Date.valueOf((LocalDate) obj);
        }
        if (obj instanceof LocalDateTime) {
            return Timestamp.valueOf((LocalDateTime) obj);
        }
        return obj instanceof LocalTime ? Time.valueOf((LocalTime) obj) : obj;
    }

    public static boolean isSqlTypeSupported(int i) {
        return (i == 2012 || i == 2013 || i == 2014) ? false : true;
    }

    public static int translateAndCheckSqlType(SQLType sQLType, ExceptionInterceptor exceptionInterceptor) throws SQLException {
        return checkSqlType(sQLType.getVendorTypeNumber().intValue(), exceptionInterceptor);
    }
}
