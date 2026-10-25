package com.mysql.jdbc;

import java.sql.SQLException;
import java.sql.SQLType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.format.DateTimeParseException;

/* JADX INFO: loaded from: classes.dex */
public class JDBC42UpdatableResultSet extends JDBC4UpdatableResultSet {
    public JDBC42UpdatableResultSet(String str, Field[] fieldArr, RowData rowData, MySQLConnection mySQLConnection, StatementImpl statementImpl) throws SQLException {
        super(str, fieldArr, rowData, mySQLConnection, statementImpl);
    }

    private int translateAndCheckSqlType(SQLType sQLType) throws SQLException {
        return JDBC42Helper.translateAndCheckSqlType(sQLType, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ResultSetImpl
    public <T> T getObject(int i, Class<T> cls) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            try {
                if (cls == null) {
                    throw SQLError.createSQLException("Type parameter can not be null", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                }
                if (cls.equals(LocalDate.class)) {
                    return cls.cast(getDate(i).toLocalDate());
                }
                if (cls.equals(LocalDateTime.class)) {
                    return cls.cast(getTimestamp(i).toLocalDateTime());
                }
                if (cls.equals(LocalTime.class)) {
                    return cls.cast(getTime(i).toLocalTime());
                }
                try {
                    if (cls.equals(OffsetDateTime.class)) {
                        return cls.cast(OffsetDateTime.parse(getString(i)));
                    }
                    if (cls.equals(OffsetTime.class)) {
                        return cls.cast(OffsetTime.parse(getString(i)));
                    }
                    return (T) super.getObject(i, cls);
                } catch (DateTimeParseException unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.mysql.jdbc.UpdatableResultSet, com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateObject(int i, Object obj) throws SQLException {
        super.updateObject(i, JDBC42Helper.convertJavaTimeToJavaSql(obj));
    }

    @Override // com.mysql.jdbc.UpdatableResultSet, com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateObject(int i, Object obj, int i2) throws SQLException {
        super.updateObject(i, JDBC42Helper.convertJavaTimeToJavaSql(obj), i2);
    }

    @Override // com.mysql.jdbc.UpdatableResultSet, com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateObject(String str, Object obj) throws SQLException {
        super.updateObject(str, JDBC42Helper.convertJavaTimeToJavaSql(obj));
    }

    @Override // com.mysql.jdbc.UpdatableResultSet, com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateObject(String str, Object obj, int i) throws SQLException {
        super.updateObject(str, JDBC42Helper.convertJavaTimeToJavaSql(obj), i);
    }

    public void updateObject(int i, Object obj, SQLType sQLType) throws SQLException {
        super.updateObjectInternal(i, JDBC42Helper.convertJavaTimeToJavaSql(obj), Integer.valueOf(translateAndCheckSqlType(sQLType)), 0);
    }

    public void updateObject(int i, Object obj, SQLType sQLType, int i2) throws SQLException {
        super.updateObjectInternal(i, JDBC42Helper.convertJavaTimeToJavaSql(obj), Integer.valueOf(translateAndCheckSqlType(sQLType)), i2);
    }

    public void updateObject(String str, Object obj, SQLType sQLType) throws SQLException {
        super.updateObjectInternal(findColumn(str), JDBC42Helper.convertJavaTimeToJavaSql(obj), Integer.valueOf(translateAndCheckSqlType(sQLType)), 0);
    }

    public void updateObject(String str, Object obj, SQLType sQLType, int i) throws SQLException {
        super.updateObjectInternal(findColumn(str), JDBC42Helper.convertJavaTimeToJavaSql(obj), Integer.valueOf(translateAndCheckSqlType(sQLType)), i);
    }
}
