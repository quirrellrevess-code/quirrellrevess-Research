package com.mysql.jdbc;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.format.DateTimeParseException;

/* JADX INFO: loaded from: classes.dex */
public class JDBC42ResultSet extends JDBC4ResultSet {
    public JDBC42ResultSet(long j, long j2, MySQLConnection mySQLConnection, StatementImpl statementImpl) {
        super(j, j2, mySQLConnection, statementImpl);
    }

    @Override // com.mysql.jdbc.JDBC4ResultSet, com.mysql.jdbc.ResultSetImpl
    public <T> T getObject(int i, Class<T> cls) throws SQLException {
        if (cls == null) {
            throw SQLError.createSQLException("Type parameter can not be null", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
        if (cls.equals(LocalDate.class)) {
            Date date = getDate(i);
            if (date == null) {
                return null;
            }
            return cls.cast(date.toLocalDate());
        }
        if (cls.equals(LocalDateTime.class)) {
            Timestamp timestamp = getTimestamp(i);
            if (timestamp == null) {
                return null;
            }
            return cls.cast(timestamp.toLocalDateTime());
        }
        if (cls.equals(LocalTime.class)) {
            Time time = getTime(i);
            if (time == null) {
                return null;
            }
            return cls.cast(time.toLocalTime());
        }
        try {
            if (cls.equals(OffsetDateTime.class)) {
                String string = getString(i);
                if (string == null) {
                    return null;
                }
                return cls.cast(OffsetDateTime.parse(string));
            }
            if (cls.equals(OffsetTime.class)) {
                String string2 = getString(i);
                if (string2 == null) {
                    return null;
                }
                return cls.cast(OffsetTime.parse(string2));
            }
            return (T) super.getObject(i, cls);
        } catch (DateTimeParseException unused) {
        }
    }

    public void updateObject(int i, Object obj, SQLType sQLType) throws SQLException {
        throw new NotUpdatable();
    }

    public JDBC42ResultSet(String str, Field[] fieldArr, RowData rowData, MySQLConnection mySQLConnection, StatementImpl statementImpl) throws SQLException {
        super(str, fieldArr, rowData, mySQLConnection, statementImpl);
    }

    public void updateObject(int i, Object obj, SQLType sQLType, int i2) throws SQLException {
        throw new NotUpdatable();
    }

    public void updateObject(String str, Object obj, SQLType sQLType) throws SQLException {
        throw new NotUpdatable();
    }

    public void updateObject(String str, Object obj, SQLType sQLType, int i) throws SQLException {
        throw new NotUpdatable();
    }
}
