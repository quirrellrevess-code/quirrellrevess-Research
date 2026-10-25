package com.mysql.jdbc;

import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public abstract class ResultSetRow {
    public ExceptionInterceptor exceptionInterceptor;
    public Field[] metadata;

    public ResultSetRow(ExceptionInterceptor exceptionInterceptor) {
        this.exceptionInterceptor = exceptionInterceptor;
    }

    public abstract void closeOpenStreams();

    public abstract InputStream getBinaryInputStream(int i) throws SQLException;

    public abstract int getBytesSize();

    public abstract byte[] getColumnValue(int i) throws SQLException;

    public abstract Date getDateFast(int i, MySQLConnection mySQLConnection, ResultSetImpl resultSetImpl, Calendar calendar) throws SQLException;

    public final Date getDateFast(int i, byte[] bArr, int i2, int i3, MySQLConnection mySQLConnection, ResultSetImpl resultSetImpl, Calendar calendar) throws SQLException {
        boolean z;
        Exception e;
        boolean z2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = i3;
        if (bArr == null) {
            return null;
        }
        int i9 = 0;
        while (true) {
            if (i9 >= i8) {
                z = false;
                break;
            }
            try {
                try {
                    if (bArr[i2 + i9] == 58) {
                        z = true;
                        break;
                    }
                    i9++;
                } catch (Exception e2) {
                    e = e2;
                    i8 = 2;
                    Object[] objArr = new Object[i8];
                    objArr[0] = StringUtils.toString(bArr);
                    objArr[1] = Integer.valueOf(i + 1);
                    SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(Messages.getString("ResultSet.Bad_format_for_Date", objArr), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
                    sQLExceptionCreateSQLException.initCause(e);
                    throw sQLExceptionCreateSQLException;
                }
            } catch (SQLException e3) {
                throw e3;
            }
        }
        int i10 = 0;
        while (true) {
            if (i10 < i8) {
                byte b = bArr[i2 + i10];
                if (b == 32 || b == 45 || b == 47) {
                    z = false;
                }
                if (b != 48 && b != 32 && b != 58 && b != 45 && b != 47 && b != 46) {
                    z2 = false;
                    break;
                }
                i10++;
            } else {
                z2 = true;
                break;
            }
        }
        int i11 = 0;
        while (true) {
            if (i11 >= i8) {
                i11 = -1;
                break;
            }
            if (bArr[i2 + i11] == 46) {
                break;
            }
            i11++;
        }
        if (i11 > -1) {
            i8 = i11;
        }
        if (!z && z2) {
            if (ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_CONVERT_TO_NULL.equals(mySQLConnection.getZeroDateTimeBehavior())) {
                return null;
            }
            if (!ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_EXCEPTION.equals(mySQLConnection.getZeroDateTimeBehavior())) {
                return resultSetImpl.fastDateCreate(calendar, 1, 1, 1);
            }
            throw SQLError.createSQLException("Value '" + StringUtils.toString(bArr) + "' can not be represented as java.sql.Date", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        }
        try {
            if (this.metadata[i].getMysqlType() != 7) {
                if (this.metadata[i].getMysqlType() == 13) {
                    if (i8 == 2 || i8 == 1) {
                        int i12 = StringUtils.getInt(bArr, i2, i8 + i2);
                        if (i12 <= 69) {
                            i12 += 100;
                        }
                        i7 = i12 + 1900;
                    } else {
                        i7 = StringUtils.getInt(bArr, i2 + 0, i2 + 4);
                    }
                    return resultSetImpl.fastDateCreate(calendar, i7, 1, 1);
                }
                if (this.metadata[i].getMysqlType() == 11) {
                    return resultSetImpl.fastDateCreate(calendar, 1970, 1, 1);
                }
                if (i8 < 10) {
                    if (i8 == 8) {
                        return resultSetImpl.fastDateCreate(calendar, 1970, 1, 1);
                    }
                    Object[] objArr2 = new Object[2];
                    objArr2[0] = StringUtils.toString(bArr);
                    objArr2[1] = Integer.valueOf(i + 1);
                    throw SQLError.createSQLException(Messages.getString("ResultSet.Bad_format_for_Date", objArr2), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
                }
                if (i8 != 18) {
                    i4 = StringUtils.getInt(bArr, i2 + 0, i2 + 4);
                    i5 = StringUtils.getInt(bArr, i2 + 5, i2 + 7);
                    i6 = StringUtils.getInt(bArr, i2 + 8, i2 + 10);
                } else {
                    StringTokenizer stringTokenizer = new StringTokenizer(StringUtils.toString(bArr, i2, i8, "ISO8859_1"), "- ");
                    i4 = Integer.parseInt(stringTokenizer.nextToken());
                    int i13 = Integer.parseInt(stringTokenizer.nextToken());
                    int i14 = Integer.parseInt(stringTokenizer.nextToken());
                    i5 = i13;
                    i6 = i14;
                }
                return resultSetImpl.fastDateCreate(calendar, i4, i5, i6);
            }
            if (i8 == 2) {
                int i15 = StringUtils.getInt(bArr, i2 + 0, i2 + 2);
                if (i15 <= 69) {
                    i15 += 100;
                }
                return resultSetImpl.fastDateCreate(calendar, i15 + 1900, 1, 1);
            }
            if (i8 == 4) {
                int i16 = i2 + 4;
                int i17 = StringUtils.getInt(bArr, i2 + 0, i16);
                if (i17 <= 69) {
                    i17 += 100;
                }
                return resultSetImpl.fastDateCreate(calendar, i17 + 1900, StringUtils.getInt(bArr, i2 + 2, i16), 1);
            }
            if (i8 != 6) {
                if (i8 != 8) {
                    if (i8 != 10 && i8 != 12) {
                        if (i8 != 14) {
                            if (i8 == 19 || i8 == 21 || i8 == 29) {
                                return resultSetImpl.fastDateCreate(calendar, StringUtils.getInt(bArr, i2 + 0, i2 + 4), StringUtils.getInt(bArr, i2 + 5, i2 + 7), StringUtils.getInt(bArr, i2 + 8, i2 + 10));
                            }
                            Object[] objArr3 = new Object[2];
                            objArr3[0] = StringUtils.toString(bArr);
                            objArr3[1] = Integer.valueOf(i + 1);
                            throw SQLError.createSQLException(Messages.getString("ResultSet.Bad_format_for_Date", objArr3), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
                        }
                    }
                }
                int i18 = i2 + 4;
                int i19 = i2 + 6;
                return resultSetImpl.fastDateCreate(calendar, StringUtils.getInt(bArr, i2 + 0, i18), StringUtils.getInt(bArr, i18, i19), StringUtils.getInt(bArr, i19, i2 + 8));
            }
            int i20 = i2 + 2;
            int i21 = StringUtils.getInt(bArr, i2 + 0, i20);
            if (i21 <= 69) {
                i21 += 100;
            }
            int i22 = i2 + 4;
            return resultSetImpl.fastDateCreate(calendar, i21 + 1900, StringUtils.getInt(bArr, i20, i22), StringUtils.getInt(bArr, i22, i2 + 6));
        } catch (Exception e4) {
            e = e4;
            Object[] objArr4 = new Object[i8];
            objArr4[0] = StringUtils.toString(bArr);
            objArr4[1] = Integer.valueOf(i + 1);
            SQLException sQLExceptionCreateSQLException2 = SQLError.createSQLException(Messages.getString("ResultSet.Bad_format_for_Date", objArr4), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
            sQLExceptionCreateSQLException2.initCause(e);
            throw sQLExceptionCreateSQLException2;
        }
    }

    public abstract int getInt(int i) throws SQLException;

    public abstract long getLong(int i) throws SQLException;

    public abstract Date getNativeDate(int i, MySQLConnection mySQLConnection, ResultSetImpl resultSetImpl, Calendar calendar) throws SQLException;

    public Date getNativeDate(int i, byte[] bArr, int i2, int i3, MySQLConnection mySQLConnection, ResultSetImpl resultSetImpl, Calendar calendar) throws SQLException {
        int i4;
        int i5;
        int i6 = 0;
        if (i3 != 0) {
            i6 = (bArr[i2 + 0] & 255) | ((bArr[i2 + 1] & 255) << 8);
            i5 = bArr[i2 + 2];
            i4 = bArr[i2 + 3];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (i3 == 0 || (i6 == 0 && i5 == 0 && i4 == 0)) {
            if (ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_CONVERT_TO_NULL.equals(mySQLConnection.getZeroDateTimeBehavior())) {
                return null;
            }
            if (ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_EXCEPTION.equals(mySQLConnection.getZeroDateTimeBehavior())) {
                throw SQLError.createSQLException("Value '0000-00-00' can not be represented as java.sql.Date", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
            }
            i6 = 1;
            i4 = 1;
            i5 = 1;
        }
        if (!resultSetImpl.useLegacyDatetimeCode) {
            return TimeUtil.fastDateCreate(i6, i5, i4, calendar);
        }
        if (calendar == null) {
            calendar = resultSetImpl.getCalendarInstanceForSessionOrNew();
        }
        return resultSetImpl.fastDateCreate(calendar, i6, i5, i4);
    }

    public abstract Object getNativeDateTimeValue(int i, Calendar calendar, int i2, int i3, TimeZone timeZone, boolean z, MySQLConnection mySQLConnection, ResultSetImpl resultSetImpl) throws SQLException;

    /* JADX WARN: Code duplicated, block: B:19:0x006e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x0070  */
    /* JADX WARN: Code duplicated, block: B:22:0x008a  */
    /* JADX WARN: Code duplicated, block: B:23:0x0097  */
    /* JADX WARN: Code duplicated, block: B:25:0x009c  */
    /* JADX WARN: Code duplicated, block: B:26:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:27:0x00c5  */
    public Object getNativeDateTimeValue(int i, byte[] bArr, int i2, int i3, Calendar calendar, int i4, int i5, TimeZone timeZone, boolean z, MySQLConnection mySQLConnection, ResultSetImpl resultSetImpl) throws SQLException {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        if (bArr == null) {
            return null;
        }
        Calendar utcCalendar = mySQLConnection.getUseJDBCCompliantTimezoneShift() ? mySQLConnection.getUtcCalendar() : resultSetImpl.getCalendarInstanceForSessionOrNew();
        boolean z2 = false;
        if (i5 != 7) {
            switch (i5) {
                case 10:
                    if (i3 == 0) {
                        i6 = 0;
                        z2 = true;
                        i7 = 0;
                        i8 = 0;
                        i9 = 0;
                        i10 = 0;
                        i11 = 0;
                        i12 = 0;
                    } else {
                        int i18 = (bArr[i2 + 0] & 255) | ((bArr[i2 + 1] & 255) << 8);
                        i7 = bArr[i2 + 2];
                        i8 = bArr[i2 + 3];
                        z2 = true;
                        i9 = 0;
                        i10 = 0;
                        i11 = 0;
                        i12 = 0;
                        i6 = i18;
                    }
                    break;
                case 11:
                    if (i3 != 0) {
                        i15 = bArr[i2 + 5];
                        i16 = bArr[i2 + 6];
                        i17 = bArr[i2 + 7];
                    } else {
                        i15 = 0;
                        i16 = 0;
                        i17 = 0;
                    }
                    i9 = i15;
                    i10 = i16;
                    i11 = i17;
                    i6 = 1970;
                    z2 = true;
                    i7 = 1;
                    i8 = 1;
                    i12 = 0;
                    break;
                case 12:
                    if (i3 == 0) {
                        i6 = 0;
                        z2 = true;
                        i7 = 0;
                        i8 = 0;
                        i9 = 0;
                        i10 = 0;
                        i11 = 0;
                        i12 = 0;
                    } else {
                        i6 = (bArr[i2 + 0] & 255) | ((bArr[i2 + 1] & 255) << 8);
                        i7 = bArr[i2 + 2];
                        i8 = bArr[i2 + 3];
                        if (i3 > 4) {
                            i9 = bArr[i2 + 4];
                            i10 = bArr[i2 + 5];
                            i11 = bArr[i2 + 6];
                        } else {
                            i9 = 0;
                            i10 = 0;
                            i11 = 0;
                        }
                        if (i3 <= 7) {
                            z2 = true;
                            i12 = 0;
                        } else {
                            i12 = ((bArr[i2 + 7] & 255) | ((bArr[i2 + 8] & 255) << 8) | ((bArr[i2 + 9] & 255) << 16) | ((bArr[i2 + 10] & 255) << 24)) * 1000;
                            z2 = true;
                        }
                    }
                    break;
                default:
                    i6 = 0;
                    i7 = 0;
                    i8 = 0;
                    i9 = 0;
                    i10 = 0;
                    i11 = 0;
                    i12 = 0;
                    break;
            }
        } else if (i3 == 0) {
            i6 = (bArr[i2 + 0] & 255) | ((bArr[i2 + 1] & 255) << 8);
            i7 = bArr[i2 + 2];
            i8 = bArr[i2 + 3];
            if (i3 > 4) {
                i9 = bArr[i2 + 4];
                i10 = bArr[i2 + 5];
                i11 = bArr[i2 + 6];
            } else {
                i9 = 0;
                i10 = 0;
                i11 = 0;
            }
            if (i3 <= 7) {
                i12 = ((bArr[i2 + 7] & 255) | ((bArr[i2 + 8] & 255) << 8) | ((bArr[i2 + 9] & 255) << 16) | ((bArr[i2 + 10] & 255) << 24)) * 1000;
                z2 = true;
            } else {
                z2 = true;
                i12 = 0;
            }
        } else {
            i6 = 0;
            z2 = true;
            i7 = 0;
            i8 = 0;
            i9 = 0;
            i10 = 0;
            i11 = 0;
            i12 = 0;
        }
        switch (i4) {
            case 91:
                if (!z2) {
                    return resultSetImpl.getNativeDateViaParseConversion(i + 1);
                }
                if (i6 == 0 && i7 == 0 && i8 == 0) {
                    if (ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_CONVERT_TO_NULL.equals(mySQLConnection.getZeroDateTimeBehavior())) {
                        return null;
                    }
                    if (ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_EXCEPTION.equals(mySQLConnection.getZeroDateTimeBehavior())) {
                        throw new SQLException("Value '0000-00-00' can not be represented as java.sql.Date", SQLError.SQL_STATE_ILLEGAL_ARGUMENT);
                    }
                    i13 = 1;
                    i7 = 1;
                    i8 = 1;
                } else {
                    i13 = i6;
                }
                return !resultSetImpl.useLegacyDatetimeCode ? TimeUtil.fastDateCreate(i13, i7, i8, calendar) : resultSetImpl.fastDateCreate(resultSetImpl.getCalendarInstanceForSessionOrNew(), i13, i7, i8);
            case 92:
                if (z2) {
                    return !resultSetImpl.useLegacyDatetimeCode ? TimeUtil.fastTimeCreate(i9, i10, i11, calendar, this.exceptionInterceptor) : TimeUtil.changeTimezone(mySQLConnection, utcCalendar, calendar, TimeUtil.fastTimeCreate(resultSetImpl.getCalendarInstanceForSessionOrNew(), i9, i10, i11, this.exceptionInterceptor), mySQLConnection.getServerTimezoneTZ(), timeZone, z);
                }
                return resultSetImpl.getNativeTimeViaParseConversion(i + 1, calendar, timeZone, z);
            case 93:
                if (!z2) {
                    return resultSetImpl.getNativeTimestampViaParseConversion(i + 1, calendar, timeZone, z);
                }
                if (i6 == 0 && i7 == 0 && i8 == 0) {
                    if (ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_CONVERT_TO_NULL.equals(mySQLConnection.getZeroDateTimeBehavior())) {
                        return null;
                    }
                    if (ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_EXCEPTION.equals(mySQLConnection.getZeroDateTimeBehavior())) {
                        throw new SQLException("Value '0000-00-00' can not be represented as java.sql.Timestamp", SQLError.SQL_STATE_ILLEGAL_ARGUMENT);
                    }
                    i14 = 1;
                    i7 = 1;
                    i8 = 1;
                } else {
                    i14 = i6;
                }
                if (resultSetImpl.useLegacyDatetimeCode) {
                    return TimeUtil.changeTimezone(mySQLConnection, utcCalendar, calendar, resultSetImpl.fastTimestampCreate(resultSetImpl.getCalendarInstanceForSessionOrNew(), i14, i7, i8, i9, i10, i11, i12, mySQLConnection.getUseGmtMillisForDatetimes()), mySQLConnection.getServerTimezoneTZ(), timeZone, z);
                }
                return TimeUtil.fastTimestampCreate(timeZone, i14, i7, i8, i9, i10, i11, i12);
            default:
                throw new SQLException("Internal error - conversion method doesn't support this type", SQLError.SQL_STATE_GENERAL_ERROR);
        }
    }

    public abstract double getNativeDouble(int i) throws SQLException;

    public double getNativeDouble(byte[] bArr, int i) {
        return Double.longBitsToDouble((((long) (bArr[i + 7] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 56) | ((long) (bArr[i + 0] & StatementImpl.USES_VARIABLES_UNKNOWN)) | (((long) (bArr[i + 1] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 8) | (((long) (bArr[i + 2] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 16) | (((long) (bArr[i + 3] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 24) | (((long) (bArr[i + 4] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 32) | (((long) (bArr[i + 5] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 40) | (((long) (bArr[i + 6] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 48));
    }

    public abstract float getNativeFloat(int i) throws SQLException;

    public float getNativeFloat(byte[] bArr, int i) {
        return Float.intBitsToFloat(((bArr[i + 3] & StatementImpl.USES_VARIABLES_UNKNOWN) << 24) | (bArr[i + 0] & StatementImpl.USES_VARIABLES_UNKNOWN) | ((bArr[i + 1] & StatementImpl.USES_VARIABLES_UNKNOWN) << 8) | ((bArr[i + 2] & StatementImpl.USES_VARIABLES_UNKNOWN) << 16));
    }

    public abstract int getNativeInt(int i) throws SQLException;

    public int getNativeInt(byte[] bArr, int i) {
        return ((bArr[i + 3] & StatementImpl.USES_VARIABLES_UNKNOWN) << 24) | (bArr[i + 0] & StatementImpl.USES_VARIABLES_UNKNOWN) | ((bArr[i + 1] & StatementImpl.USES_VARIABLES_UNKNOWN) << 8) | ((bArr[i + 2] & StatementImpl.USES_VARIABLES_UNKNOWN) << 16);
    }

    public abstract long getNativeLong(int i) throws SQLException;

    public long getNativeLong(byte[] bArr, int i) {
        return (((long) (bArr[i + 7] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 56) | ((long) (bArr[i + 0] & StatementImpl.USES_VARIABLES_UNKNOWN)) | (((long) (bArr[i + 1] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 8) | (((long) (bArr[i + 2] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 16) | (((long) (bArr[i + 3] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 24) | (((long) (bArr[i + 4] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 32) | (((long) (bArr[i + 5] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 40) | (((long) (bArr[i + 6] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 48);
    }

    public abstract short getNativeShort(int i) throws SQLException;

    public short getNativeShort(byte[] bArr, int i) {
        return (short) (((bArr[i + 1] & StatementImpl.USES_VARIABLES_UNKNOWN) << 8) | (bArr[i + 0] & StatementImpl.USES_VARIABLES_UNKNOWN));
    }

    public abstract Time getNativeTime(int i, Calendar calendar, TimeZone timeZone, boolean z, MySQLConnection mySQLConnection, ResultSetImpl resultSetImpl) throws SQLException;

    public Time getNativeTime(int i, byte[] bArr, int i2, int i3, Calendar calendar, TimeZone timeZone, boolean z, MySQLConnection mySQLConnection, ResultSetImpl resultSetImpl) throws SQLException {
        byte b;
        byte b2;
        byte b3 = 0;
        if (i3 != 0) {
            b3 = bArr[i2 + 5];
            b = bArr[i2 + 6];
            b2 = bArr[i2 + 7];
        } else {
            b = 0;
            b2 = 0;
        }
        if (!resultSetImpl.useLegacyDatetimeCode) {
            return TimeUtil.fastTimeCreate(b3, b, b2, calendar, this.exceptionInterceptor);
        }
        Calendar calendarInstanceForSessionOrNew = resultSetImpl.getCalendarInstanceForSessionOrNew();
        return TimeUtil.changeTimezone(mySQLConnection, calendarInstanceForSessionOrNew, calendar, TimeUtil.fastTimeCreate(calendarInstanceForSessionOrNew, b3, b, b2, this.exceptionInterceptor), mySQLConnection.getServerTimezoneTZ(), timeZone, z);
    }

    public abstract Timestamp getNativeTimestamp(int i, Calendar calendar, TimeZone timeZone, boolean z, MySQLConnection mySQLConnection, ResultSetImpl resultSetImpl) throws SQLException;

    /* JADX WARN: Code duplicated, block: B:21:0x0076  */
    /* JADX WARN: Code duplicated, block: B:23:0x0082 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x0084  */
    /* JADX WARN: Code duplicated, block: B:27:0x0090  */
    /* JADX WARN: Code duplicated, block: B:30:0x0099  */
    /* JADX WARN: Code duplicated, block: B:32:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:35:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:38:0x00dc  */
    public Timestamp getNativeTimestamp(byte[] bArr, int i, int i2, Calendar calendar, TimeZone timeZone, boolean z, MySQLConnection mySQLConnection, ResultSetImpl resultSetImpl) throws SQLException {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Calendar calendarInstanceForSessionOrNew;
        int i12;
        int i13;
        int i14;
        int i15 = 0;
        if (i2 != 0) {
            int i16 = (bArr[i + 0] & 255) | ((bArr[i + 1] & 255) << 8);
            i3 = bArr[i + 2];
            i4 = bArr[i + 3];
            if (i2 > 4) {
                i12 = bArr[i + 4];
                i13 = bArr[i + 5];
                i14 = bArr[i + 6];
            } else {
                i12 = 0;
                i13 = 0;
                i14 = 0;
            }
            if (i2 > 7) {
                i8 = ((bArr[i + 7] & 255) | ((bArr[i + 8] & 255) << 8) | ((bArr[i + 9] & 255) << 16) | ((bArr[i + 10] & 255) << 24)) * 1000;
                i15 = i16;
                i5 = i12;
                i6 = i13;
                i7 = i14;
            } else {
                i15 = i16;
                i5 = i12;
                i6 = i13;
                i7 = i14;
            }
            if (i2 == 0 && (i15 != 0 || i3 != 0 || i4 != 0)) {
                i9 = i15;
                i10 = i3;
                i11 = i4;
            } else {
                if (ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_CONVERT_TO_NULL.equals(mySQLConnection.getZeroDateTimeBehavior())) {
                    return null;
                }
                if (ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_EXCEPTION.equals(mySQLConnection.getZeroDateTimeBehavior())) {
                    throw SQLError.createSQLException("Value '0000-00-00' can not be represented as java.sql.Timestamp", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
                }
                i9 = 1;
                i10 = 1;
                i11 = 1;
            }
            if (!resultSetImpl.useLegacyDatetimeCode) {
                return TimeUtil.fastTimestampCreate(timeZone, i9, i10, i11, i5, i6, i7, i8);
            }
            boolean useGmtMillisForDatetimes = mySQLConnection.getUseGmtMillisForDatetimes();
            if (mySQLConnection.getUseJDBCCompliantTimezoneShift()) {
                calendarInstanceForSessionOrNew = mySQLConnection.getUtcCalendar();
            } else {
                calendarInstanceForSessionOrNew = resultSetImpl.getCalendarInstanceForSessionOrNew();
            }
            Calendar calendar2 = calendarInstanceForSessionOrNew;
            return TimeUtil.changeTimezone(mySQLConnection, calendar2, calendar, resultSetImpl.fastTimestampCreate(calendar2, i9, i10, i11, i5, i6, i7, i8, useGmtMillisForDatetimes), mySQLConnection.getServerTimezoneTZ(), timeZone, z);
        }
        i3 = 0;
        i4 = 0;
        i5 = 0;
        i6 = 0;
        i7 = 0;
        i8 = 0;
        if (i2 == 0) {
            if (ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_CONVERT_TO_NULL.equals(mySQLConnection.getZeroDateTimeBehavior())) {
                return null;
            }
            if (ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_EXCEPTION.equals(mySQLConnection.getZeroDateTimeBehavior())) {
                throw SQLError.createSQLException("Value '0000-00-00' can not be represented as java.sql.Timestamp", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
            }
            i9 = 1;
            i10 = 1;
            i11 = 1;
        } else {
            if (ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_CONVERT_TO_NULL.equals(mySQLConnection.getZeroDateTimeBehavior())) {
                return null;
            }
            if (ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_EXCEPTION.equals(mySQLConnection.getZeroDateTimeBehavior())) {
                throw SQLError.createSQLException("Value '0000-00-00' can not be represented as java.sql.Timestamp", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
            }
            i9 = 1;
            i10 = 1;
            i11 = 1;
        }
        if (!resultSetImpl.useLegacyDatetimeCode) {
            return TimeUtil.fastTimestampCreate(timeZone, i9, i10, i11, i5, i6, i7, i8);
        }
        boolean useGmtMillisForDatetimes2 = mySQLConnection.getUseGmtMillisForDatetimes();
        if (mySQLConnection.getUseJDBCCompliantTimezoneShift()) {
            calendarInstanceForSessionOrNew = mySQLConnection.getUtcCalendar();
        } else {
            calendarInstanceForSessionOrNew = resultSetImpl.getCalendarInstanceForSessionOrNew();
        }
        Calendar calendar3 = calendarInstanceForSessionOrNew;
        return TimeUtil.changeTimezone(mySQLConnection, calendar3, calendar, resultSetImpl.fastTimestampCreate(calendar3, i9, i10, i11, i5, i6, i7, i8, useGmtMillisForDatetimes2), mySQLConnection.getServerTimezoneTZ(), timeZone, z);
    }

    public abstract Reader getReader(int i) throws SQLException;

    public abstract String getString(int i, String str, MySQLConnection mySQLConnection) throws SQLException;

    public String getString(String str, MySQLConnection mySQLConnection, byte[] bArr, int i, int i2) throws SQLException {
        if (mySQLConnection == null || !mySQLConnection.getUseUnicode()) {
            return StringUtils.toAsciiString(bArr, i, i2);
        }
        try {
            if (str == null) {
                str = StringUtils.toString(bArr);
            } else {
                SingleByteCharsetConverter charsetConverter = mySQLConnection.getCharsetConverter(str);
                str = charsetConverter != null ? charsetConverter.toString(bArr, i, i2) : StringUtils.toString(bArr, i, i2, str);
            }
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw SQLError.createSQLException(Messages.getString("ResultSet.Unsupported_character_encoding____101") + str + "'.", "0S100", this.exceptionInterceptor);
        }
    }

    public abstract Time getTimeFast(int i, Calendar calendar, TimeZone timeZone, boolean z, MySQLConnection mySQLConnection, ResultSetImpl resultSetImpl) throws SQLException;

    public Time getTimeFast(int i, byte[] bArr, int i2, int i3, Calendar calendar, TimeZone timeZone, boolean z, MySQLConnection mySQLConnection, ResultSetImpl resultSetImpl) throws SQLException {
        boolean z2;
        boolean z3;
        int i4;
        int i5;
        int i6;
        if (bArr == null) {
            return null;
        }
        int i7 = 0;
        while (true) {
            if (i7 >= i3) {
                z2 = false;
                break;
            }
            try {
                if (bArr[i2 + i7] == 58) {
                    z2 = true;
                    break;
                }
                i7++;
            } catch (RuntimeException e) {
                SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(e.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
                sQLExceptionCreateSQLException.initCause(e);
                throw sQLExceptionCreateSQLException;
            }
        }
        int i8 = 0;
        while (true) {
            if (i8 >= i3) {
                i8 = -1;
                break;
            }
            if (bArr[i2 + i8] == 46) {
                break;
            }
            i8++;
        }
        int i9 = 0;
        while (true) {
            if (i9 >= i3) {
                z3 = true;
                break;
            }
            byte b = bArr[i2 + i9];
            if (b == 32 || b == 45 || b == 47) {
                z2 = false;
            }
            if (b != 48 && b != 32 && b != 58 && b != 45 && b != 47) {
                if (b != 46) {
                    z3 = false;
                    break;
                }
            }
            i9++;
        }
        if (!z2 && z3) {
            if (ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_CONVERT_TO_NULL.equals(mySQLConnection.getZeroDateTimeBehavior())) {
                return null;
            }
            if (!ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_EXCEPTION.equals(mySQLConnection.getZeroDateTimeBehavior())) {
                return resultSetImpl.fastTimeCreate(calendar, 0, 0, 0);
            }
            throw SQLError.createSQLException("Value '" + StringUtils.toString(bArr) + "' can not be represented as java.sql.Time", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        }
        Field field = this.metadata[i];
        if (i8 == -1) {
            i8 = i3;
        } else {
            if (i8 + 2 > i3) {
                throw new IllegalArgumentException();
            }
            StringUtils.getInt(bArr, i2 + i8 + 1, i2 + i3);
            int i10 = i3 - (i8 + 1);
            if (i10 < 9) {
                Math.pow(10.0d, 9 - i10);
            }
        }
        if (field.getMysqlType() == 7) {
            if (i8 == 10) {
                int i11 = i2 + 8;
                int i12 = StringUtils.getInt(bArr, i2 + 6, i11);
                i4 = StringUtils.getInt(bArr, i11, i2 + 10);
                i6 = i12;
                i5 = 0;
            } else if (i8 == 12 || i8 == 14) {
                int i13 = i2 + i8;
                int i14 = i13 - 4;
                i6 = StringUtils.getInt(bArr, i13 - 6, i14);
                int i15 = i13 - 2;
                i4 = StringUtils.getInt(bArr, i14, i15);
                i5 = StringUtils.getInt(bArr, i15, i13);
            } else {
                if (i8 != 19) {
                    throw SQLError.createSQLException(Messages.getString("ResultSet.Timestamp_too_small_to_convert_to_Time_value_in_column__257") + (i + 1) + "(" + field + ").", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
                }
                int i16 = i2 + i8;
                i6 = StringUtils.getInt(bArr, i16 - 8, i16 - 6);
                i4 = StringUtils.getInt(bArr, i16 - 5, i16 - 3);
                i5 = StringUtils.getInt(bArr, i16 - 2, i16);
            }
            new SQLWarning(Messages.getString("ResultSet.Precision_lost_converting_TIMESTAMP_to_Time_with_getTime()_on_column__261") + i + "(" + field + ").");
        } else if (field.getMysqlType() == 12) {
            i6 = StringUtils.getInt(bArr, i2 + 11, i2 + 13);
            int i17 = StringUtils.getInt(bArr, i2 + 14, i2 + 16);
            i5 = StringUtils.getInt(bArr, i2 + 17, i2 + 19);
            new SQLWarning(Messages.getString("ResultSet.Precision_lost_converting_DATETIME_to_Time_with_getTime()_on_column__264") + (i + 1) + "(" + field + ").");
            i4 = i17;
        } else {
            if (field.getMysqlType() == 10) {
                return resultSetImpl.fastTimeCreate(null, 0, 0, 0);
            }
            if (i8 != 5 && i8 != 8) {
                throw SQLError.createSQLException(Messages.getString("ResultSet.Bad_format_for_Time____267") + StringUtils.toString(bArr) + Messages.getString("ResultSet.___in_column__268") + (i + 1), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
            }
            int i18 = StringUtils.getInt(bArr, i2 + 0, i2 + 2);
            i4 = StringUtils.getInt(bArr, i2 + 3, i2 + 5);
            i5 = i8 == 5 ? 0 : StringUtils.getInt(bArr, i2 + 6, i2 + 8);
            i6 = i18;
        }
        Calendar calendarInstanceForSessionOrNew = resultSetImpl.getCalendarInstanceForSessionOrNew();
        if (resultSetImpl.useLegacyDatetimeCode) {
            return TimeUtil.changeTimezone(mySQLConnection, calendarInstanceForSessionOrNew, calendar, resultSetImpl.fastTimeCreate(calendarInstanceForSessionOrNew, i6, i4, i5), mySQLConnection.getServerTimezoneTZ(), timeZone, z);
        }
        return resultSetImpl.fastTimeCreate(calendar == null ? Calendar.getInstance(timeZone, Locale.US) : calendar, i6, i4, i5);
    }

    public abstract Timestamp getTimestampFast(int i, Calendar calendar, TimeZone timeZone, boolean z, MySQLConnection mySQLConnection, ResultSetImpl resultSetImpl, boolean z2, boolean z3) throws SQLException;

    /* JADX WARN: Code duplicated, block: B:101:0x0218 A[Catch: RuntimeException -> 0x0382, TryCatch #0 {RuntimeException -> 0x0382, blocks: (B:4:0x0010, B:6:0x0019, B:9:0x0024, B:17:0x0035, B:35:0x005e, B:39:0x006c, B:41:0x0078, B:43:0x007c, B:45:0x008a, B:47:0x009c, B:48:0x00bc, B:49:0x00bd, B:51:0x00ca, B:53:0x00ce, B:55:0x00e5, B:60:0x010f, B:65:0x011c, B:67:0x0122, B:93:0x0170, B:94:0x0173, B:95:0x019c, B:96:0x019d, B:145:0x034e, B:147:0x0352, B:149:0x0359, B:97:0x01db, B:99:0x020e, B:101:0x0218, B:102:0x021a, B:105:0x0245, B:110:0x0251, B:114:0x025e, B:116:0x0268, B:117:0x026a, B:118:0x028f, B:108:0x024d, B:121:0x02aa, B:127:0x02ba, B:128:0x02e1, B:124:0x02b4, B:130:0x02ff, B:132:0x0309, B:133:0x030b, B:134:0x031f, B:136:0x0329, B:137:0x032b, B:138:0x0335, B:140:0x033e, B:141:0x0340, B:69:0x0127, B:71:0x012b, B:73:0x013a, B:75:0x014a, B:76:0x014f, B:63:0x0118, B:31:0x0056, B:12:0x002c, B:5:0x0015), top: B:154:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:103:0x0242  */
    /* JADX WARN: Code duplicated, block: B:105:0x0245 A[Catch: RuntimeException -> 0x0382, TryCatch #0 {RuntimeException -> 0x0382, blocks: (B:4:0x0010, B:6:0x0019, B:9:0x0024, B:17:0x0035, B:35:0x005e, B:39:0x006c, B:41:0x0078, B:43:0x007c, B:45:0x008a, B:47:0x009c, B:48:0x00bc, B:49:0x00bd, B:51:0x00ca, B:53:0x00ce, B:55:0x00e5, B:60:0x010f, B:65:0x011c, B:67:0x0122, B:93:0x0170, B:94:0x0173, B:95:0x019c, B:96:0x019d, B:145:0x034e, B:147:0x0352, B:149:0x0359, B:97:0x01db, B:99:0x020e, B:101:0x0218, B:102:0x021a, B:105:0x0245, B:110:0x0251, B:114:0x025e, B:116:0x0268, B:117:0x026a, B:118:0x028f, B:108:0x024d, B:121:0x02aa, B:127:0x02ba, B:128:0x02e1, B:124:0x02b4, B:130:0x02ff, B:132:0x0309, B:133:0x030b, B:134:0x031f, B:136:0x0329, B:137:0x032b, B:138:0x0335, B:140:0x033e, B:141:0x0340, B:69:0x0127, B:71:0x012b, B:73:0x013a, B:75:0x014a, B:76:0x014f, B:63:0x0118, B:31:0x0056, B:12:0x002c, B:5:0x0015), top: B:154:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:108:0x024d A[Catch: RuntimeException -> 0x0382, LOOP:3: B:104:0x0243->B:108:0x024d, LOOP_END, TryCatch #0 {RuntimeException -> 0x0382, blocks: (B:4:0x0010, B:6:0x0019, B:9:0x0024, B:17:0x0035, B:35:0x005e, B:39:0x006c, B:41:0x0078, B:43:0x007c, B:45:0x008a, B:47:0x009c, B:48:0x00bc, B:49:0x00bd, B:51:0x00ca, B:53:0x00ce, B:55:0x00e5, B:60:0x010f, B:65:0x011c, B:67:0x0122, B:93:0x0170, B:94:0x0173, B:95:0x019c, B:96:0x019d, B:145:0x034e, B:147:0x0352, B:149:0x0359, B:97:0x01db, B:99:0x020e, B:101:0x0218, B:102:0x021a, B:105:0x0245, B:110:0x0251, B:114:0x025e, B:116:0x0268, B:117:0x026a, B:118:0x028f, B:108:0x024d, B:121:0x02aa, B:127:0x02ba, B:128:0x02e1, B:124:0x02b4, B:130:0x02ff, B:132:0x0309, B:133:0x030b, B:134:0x031f, B:136:0x0329, B:137:0x032b, B:138:0x0335, B:140:0x033e, B:141:0x0340, B:69:0x0127, B:71:0x012b, B:73:0x013a, B:75:0x014a, B:76:0x014f, B:63:0x0118, B:31:0x0056, B:12:0x002c, B:5:0x0015), top: B:154:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:119:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:121:0x02aa A[Catch: RuntimeException -> 0x0382, TryCatch #0 {RuntimeException -> 0x0382, blocks: (B:4:0x0010, B:6:0x0019, B:9:0x0024, B:17:0x0035, B:35:0x005e, B:39:0x006c, B:41:0x0078, B:43:0x007c, B:45:0x008a, B:47:0x009c, B:48:0x00bc, B:49:0x00bd, B:51:0x00ca, B:53:0x00ce, B:55:0x00e5, B:60:0x010f, B:65:0x011c, B:67:0x0122, B:93:0x0170, B:94:0x0173, B:95:0x019c, B:96:0x019d, B:145:0x034e, B:147:0x0352, B:149:0x0359, B:97:0x01db, B:99:0x020e, B:101:0x0218, B:102:0x021a, B:105:0x0245, B:110:0x0251, B:114:0x025e, B:116:0x0268, B:117:0x026a, B:118:0x028f, B:108:0x024d, B:121:0x02aa, B:127:0x02ba, B:128:0x02e1, B:124:0x02b4, B:130:0x02ff, B:132:0x0309, B:133:0x030b, B:134:0x031f, B:136:0x0329, B:137:0x032b, B:138:0x0335, B:140:0x033e, B:141:0x0340, B:69:0x0127, B:71:0x012b, B:73:0x013a, B:75:0x014a, B:76:0x014f, B:63:0x0118, B:31:0x0056, B:12:0x002c, B:5:0x0015), top: B:154:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:124:0x02b4 A[Catch: RuntimeException -> 0x0382, LOOP:4: B:120:0x02a8->B:124:0x02b4, LOOP_END, TryCatch #0 {RuntimeException -> 0x0382, blocks: (B:4:0x0010, B:6:0x0019, B:9:0x0024, B:17:0x0035, B:35:0x005e, B:39:0x006c, B:41:0x0078, B:43:0x007c, B:45:0x008a, B:47:0x009c, B:48:0x00bc, B:49:0x00bd, B:51:0x00ca, B:53:0x00ce, B:55:0x00e5, B:60:0x010f, B:65:0x011c, B:67:0x0122, B:93:0x0170, B:94:0x0173, B:95:0x019c, B:96:0x019d, B:145:0x034e, B:147:0x0352, B:149:0x0359, B:97:0x01db, B:99:0x020e, B:101:0x0218, B:102:0x021a, B:105:0x0245, B:110:0x0251, B:114:0x025e, B:116:0x0268, B:117:0x026a, B:118:0x028f, B:108:0x024d, B:121:0x02aa, B:127:0x02ba, B:128:0x02e1, B:124:0x02b4, B:130:0x02ff, B:132:0x0309, B:133:0x030b, B:134:0x031f, B:136:0x0329, B:137:0x032b, B:138:0x0335, B:140:0x033e, B:141:0x0340, B:69:0x0127, B:71:0x012b, B:73:0x013a, B:75:0x014a, B:76:0x014f, B:63:0x0118, B:31:0x0056, B:12:0x002c, B:5:0x0015), top: B:154:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:127:0x02ba A[Catch: RuntimeException -> 0x0382, TryCatch #0 {RuntimeException -> 0x0382, blocks: (B:4:0x0010, B:6:0x0019, B:9:0x0024, B:17:0x0035, B:35:0x005e, B:39:0x006c, B:41:0x0078, B:43:0x007c, B:45:0x008a, B:47:0x009c, B:48:0x00bc, B:49:0x00bd, B:51:0x00ca, B:53:0x00ce, B:55:0x00e5, B:60:0x010f, B:65:0x011c, B:67:0x0122, B:93:0x0170, B:94:0x0173, B:95:0x019c, B:96:0x019d, B:145:0x034e, B:147:0x0352, B:149:0x0359, B:97:0x01db, B:99:0x020e, B:101:0x0218, B:102:0x021a, B:105:0x0245, B:110:0x0251, B:114:0x025e, B:116:0x0268, B:117:0x026a, B:118:0x028f, B:108:0x024d, B:121:0x02aa, B:127:0x02ba, B:128:0x02e1, B:124:0x02b4, B:130:0x02ff, B:132:0x0309, B:133:0x030b, B:134:0x031f, B:136:0x0329, B:137:0x032b, B:138:0x0335, B:140:0x033e, B:141:0x0340, B:69:0x0127, B:71:0x012b, B:73:0x013a, B:75:0x014a, B:76:0x014f, B:63:0x0118, B:31:0x0056, B:12:0x002c, B:5:0x0015), top: B:154:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:128:0x02e1 A[Catch: RuntimeException -> 0x0382, TryCatch #0 {RuntimeException -> 0x0382, blocks: (B:4:0x0010, B:6:0x0019, B:9:0x0024, B:17:0x0035, B:35:0x005e, B:39:0x006c, B:41:0x0078, B:43:0x007c, B:45:0x008a, B:47:0x009c, B:48:0x00bc, B:49:0x00bd, B:51:0x00ca, B:53:0x00ce, B:55:0x00e5, B:60:0x010f, B:65:0x011c, B:67:0x0122, B:93:0x0170, B:94:0x0173, B:95:0x019c, B:96:0x019d, B:145:0x034e, B:147:0x0352, B:149:0x0359, B:97:0x01db, B:99:0x020e, B:101:0x0218, B:102:0x021a, B:105:0x0245, B:110:0x0251, B:114:0x025e, B:116:0x0268, B:117:0x026a, B:118:0x028f, B:108:0x024d, B:121:0x02aa, B:127:0x02ba, B:128:0x02e1, B:124:0x02b4, B:130:0x02ff, B:132:0x0309, B:133:0x030b, B:134:0x031f, B:136:0x0329, B:137:0x032b, B:138:0x0335, B:140:0x033e, B:141:0x0340, B:69:0x0127, B:71:0x012b, B:73:0x013a, B:75:0x014a, B:76:0x014f, B:63:0x0118, B:31:0x0056, B:12:0x002c, B:5:0x0015), top: B:154:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:130:0x02ff A[Catch: RuntimeException -> 0x0382, TryCatch #0 {RuntimeException -> 0x0382, blocks: (B:4:0x0010, B:6:0x0019, B:9:0x0024, B:17:0x0035, B:35:0x005e, B:39:0x006c, B:41:0x0078, B:43:0x007c, B:45:0x008a, B:47:0x009c, B:48:0x00bc, B:49:0x00bd, B:51:0x00ca, B:53:0x00ce, B:55:0x00e5, B:60:0x010f, B:65:0x011c, B:67:0x0122, B:93:0x0170, B:94:0x0173, B:95:0x019c, B:96:0x019d, B:145:0x034e, B:147:0x0352, B:149:0x0359, B:97:0x01db, B:99:0x020e, B:101:0x0218, B:102:0x021a, B:105:0x0245, B:110:0x0251, B:114:0x025e, B:116:0x0268, B:117:0x026a, B:118:0x028f, B:108:0x024d, B:121:0x02aa, B:127:0x02ba, B:128:0x02e1, B:124:0x02b4, B:130:0x02ff, B:132:0x0309, B:133:0x030b, B:134:0x031f, B:136:0x0329, B:137:0x032b, B:138:0x0335, B:140:0x033e, B:141:0x0340, B:69:0x0127, B:71:0x012b, B:73:0x013a, B:75:0x014a, B:76:0x014f, B:63:0x0118, B:31:0x0056, B:12:0x002c, B:5:0x0015), top: B:154:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:132:0x0309 A[Catch: RuntimeException -> 0x0382, TryCatch #0 {RuntimeException -> 0x0382, blocks: (B:4:0x0010, B:6:0x0019, B:9:0x0024, B:17:0x0035, B:35:0x005e, B:39:0x006c, B:41:0x0078, B:43:0x007c, B:45:0x008a, B:47:0x009c, B:48:0x00bc, B:49:0x00bd, B:51:0x00ca, B:53:0x00ce, B:55:0x00e5, B:60:0x010f, B:65:0x011c, B:67:0x0122, B:93:0x0170, B:94:0x0173, B:95:0x019c, B:96:0x019d, B:145:0x034e, B:147:0x0352, B:149:0x0359, B:97:0x01db, B:99:0x020e, B:101:0x0218, B:102:0x021a, B:105:0x0245, B:110:0x0251, B:114:0x025e, B:116:0x0268, B:117:0x026a, B:118:0x028f, B:108:0x024d, B:121:0x02aa, B:127:0x02ba, B:128:0x02e1, B:124:0x02b4, B:130:0x02ff, B:132:0x0309, B:133:0x030b, B:134:0x031f, B:136:0x0329, B:137:0x032b, B:138:0x0335, B:140:0x033e, B:141:0x0340, B:69:0x0127, B:71:0x012b, B:73:0x013a, B:75:0x014a, B:76:0x014f, B:63:0x0118, B:31:0x0056, B:12:0x002c, B:5:0x0015), top: B:154:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:134:0x031f A[Catch: RuntimeException -> 0x0382, TryCatch #0 {RuntimeException -> 0x0382, blocks: (B:4:0x0010, B:6:0x0019, B:9:0x0024, B:17:0x0035, B:35:0x005e, B:39:0x006c, B:41:0x0078, B:43:0x007c, B:45:0x008a, B:47:0x009c, B:48:0x00bc, B:49:0x00bd, B:51:0x00ca, B:53:0x00ce, B:55:0x00e5, B:60:0x010f, B:65:0x011c, B:67:0x0122, B:93:0x0170, B:94:0x0173, B:95:0x019c, B:96:0x019d, B:145:0x034e, B:147:0x0352, B:149:0x0359, B:97:0x01db, B:99:0x020e, B:101:0x0218, B:102:0x021a, B:105:0x0245, B:110:0x0251, B:114:0x025e, B:116:0x0268, B:117:0x026a, B:118:0x028f, B:108:0x024d, B:121:0x02aa, B:127:0x02ba, B:128:0x02e1, B:124:0x02b4, B:130:0x02ff, B:132:0x0309, B:133:0x030b, B:134:0x031f, B:136:0x0329, B:137:0x032b, B:138:0x0335, B:140:0x033e, B:141:0x0340, B:69:0x0127, B:71:0x012b, B:73:0x013a, B:75:0x014a, B:76:0x014f, B:63:0x0118, B:31:0x0056, B:12:0x002c, B:5:0x0015), top: B:154:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:136:0x0329 A[Catch: RuntimeException -> 0x0382, TryCatch #0 {RuntimeException -> 0x0382, blocks: (B:4:0x0010, B:6:0x0019, B:9:0x0024, B:17:0x0035, B:35:0x005e, B:39:0x006c, B:41:0x0078, B:43:0x007c, B:45:0x008a, B:47:0x009c, B:48:0x00bc, B:49:0x00bd, B:51:0x00ca, B:53:0x00ce, B:55:0x00e5, B:60:0x010f, B:65:0x011c, B:67:0x0122, B:93:0x0170, B:94:0x0173, B:95:0x019c, B:96:0x019d, B:145:0x034e, B:147:0x0352, B:149:0x0359, B:97:0x01db, B:99:0x020e, B:101:0x0218, B:102:0x021a, B:105:0x0245, B:110:0x0251, B:114:0x025e, B:116:0x0268, B:117:0x026a, B:118:0x028f, B:108:0x024d, B:121:0x02aa, B:127:0x02ba, B:128:0x02e1, B:124:0x02b4, B:130:0x02ff, B:132:0x0309, B:133:0x030b, B:134:0x031f, B:136:0x0329, B:137:0x032b, B:138:0x0335, B:140:0x033e, B:141:0x0340, B:69:0x0127, B:71:0x012b, B:73:0x013a, B:75:0x014a, B:76:0x014f, B:63:0x0118, B:31:0x0056, B:12:0x002c, B:5:0x0015), top: B:154:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:138:0x0335 A[Catch: RuntimeException -> 0x0382, TryCatch #0 {RuntimeException -> 0x0382, blocks: (B:4:0x0010, B:6:0x0019, B:9:0x0024, B:17:0x0035, B:35:0x005e, B:39:0x006c, B:41:0x0078, B:43:0x007c, B:45:0x008a, B:47:0x009c, B:48:0x00bc, B:49:0x00bd, B:51:0x00ca, B:53:0x00ce, B:55:0x00e5, B:60:0x010f, B:65:0x011c, B:67:0x0122, B:93:0x0170, B:94:0x0173, B:95:0x019c, B:96:0x019d, B:145:0x034e, B:147:0x0352, B:149:0x0359, B:97:0x01db, B:99:0x020e, B:101:0x0218, B:102:0x021a, B:105:0x0245, B:110:0x0251, B:114:0x025e, B:116:0x0268, B:117:0x026a, B:118:0x028f, B:108:0x024d, B:121:0x02aa, B:127:0x02ba, B:128:0x02e1, B:124:0x02b4, B:130:0x02ff, B:132:0x0309, B:133:0x030b, B:134:0x031f, B:136:0x0329, B:137:0x032b, B:138:0x0335, B:140:0x033e, B:141:0x0340, B:69:0x0127, B:71:0x012b, B:73:0x013a, B:75:0x014a, B:76:0x014f, B:63:0x0118, B:31:0x0056, B:12:0x002c, B:5:0x0015), top: B:154:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:140:0x033e A[Catch: RuntimeException -> 0x0382, TryCatch #0 {RuntimeException -> 0x0382, blocks: (B:4:0x0010, B:6:0x0019, B:9:0x0024, B:17:0x0035, B:35:0x005e, B:39:0x006c, B:41:0x0078, B:43:0x007c, B:45:0x008a, B:47:0x009c, B:48:0x00bc, B:49:0x00bd, B:51:0x00ca, B:53:0x00ce, B:55:0x00e5, B:60:0x010f, B:65:0x011c, B:67:0x0122, B:93:0x0170, B:94:0x0173, B:95:0x019c, B:96:0x019d, B:145:0x034e, B:147:0x0352, B:149:0x0359, B:97:0x01db, B:99:0x020e, B:101:0x0218, B:102:0x021a, B:105:0x0245, B:110:0x0251, B:114:0x025e, B:116:0x0268, B:117:0x026a, B:118:0x028f, B:108:0x024d, B:121:0x02aa, B:127:0x02ba, B:128:0x02e1, B:124:0x02b4, B:130:0x02ff, B:132:0x0309, B:133:0x030b, B:134:0x031f, B:136:0x0329, B:137:0x032b, B:138:0x0335, B:140:0x033e, B:141:0x0340, B:69:0x0127, B:71:0x012b, B:73:0x013a, B:75:0x014a, B:76:0x014f, B:63:0x0118, B:31:0x0056, B:12:0x002c, B:5:0x0015), top: B:154:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:147:0x0352 A[Catch: RuntimeException -> 0x0382, TryCatch #0 {RuntimeException -> 0x0382, blocks: (B:4:0x0010, B:6:0x0019, B:9:0x0024, B:17:0x0035, B:35:0x005e, B:39:0x006c, B:41:0x0078, B:43:0x007c, B:45:0x008a, B:47:0x009c, B:48:0x00bc, B:49:0x00bd, B:51:0x00ca, B:53:0x00ce, B:55:0x00e5, B:60:0x010f, B:65:0x011c, B:67:0x0122, B:93:0x0170, B:94:0x0173, B:95:0x019c, B:96:0x019d, B:145:0x034e, B:147:0x0352, B:149:0x0359, B:97:0x01db, B:99:0x020e, B:101:0x0218, B:102:0x021a, B:105:0x0245, B:110:0x0251, B:114:0x025e, B:116:0x0268, B:117:0x026a, B:118:0x028f, B:108:0x024d, B:121:0x02aa, B:127:0x02ba, B:128:0x02e1, B:124:0x02b4, B:130:0x02ff, B:132:0x0309, B:133:0x030b, B:134:0x031f, B:136:0x0329, B:137:0x032b, B:138:0x0335, B:140:0x033e, B:141:0x0340, B:69:0x0127, B:71:0x012b, B:73:0x013a, B:75:0x014a, B:76:0x014f, B:63:0x0118, B:31:0x0056, B:12:0x002c, B:5:0x0015), top: B:154:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:149:0x0359 A[Catch: RuntimeException -> 0x0382, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x0382, blocks: (B:4:0x0010, B:6:0x0019, B:9:0x0024, B:17:0x0035, B:35:0x005e, B:39:0x006c, B:41:0x0078, B:43:0x007c, B:45:0x008a, B:47:0x009c, B:48:0x00bc, B:49:0x00bd, B:51:0x00ca, B:53:0x00ce, B:55:0x00e5, B:60:0x010f, B:65:0x011c, B:67:0x0122, B:93:0x0170, B:94:0x0173, B:95:0x019c, B:96:0x019d, B:145:0x034e, B:147:0x0352, B:149:0x0359, B:97:0x01db, B:99:0x020e, B:101:0x0218, B:102:0x021a, B:105:0x0245, B:110:0x0251, B:114:0x025e, B:116:0x0268, B:117:0x026a, B:118:0x028f, B:108:0x024d, B:121:0x02aa, B:127:0x02ba, B:128:0x02e1, B:124:0x02b4, B:130:0x02ff, B:132:0x0309, B:133:0x030b, B:134:0x031f, B:136:0x0329, B:137:0x032b, B:138:0x0335, B:140:0x033e, B:141:0x0340, B:69:0x0127, B:71:0x012b, B:73:0x013a, B:75:0x014a, B:76:0x014f, B:63:0x0118, B:31:0x0056, B:12:0x002c, B:5:0x0015), top: B:154:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:167:0x0250 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:168:0x024b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:0x02b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:170:0x02b2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x0157 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x0159  */
    /* JADX WARN: Code duplicated, block: B:83:0x015c  */
    /* JADX WARN: Code duplicated, block: B:85:0x0160  */
    /* JADX WARN: Code duplicated, block: B:87:0x0164  */
    /* JADX WARN: Code duplicated, block: B:89:0x0168  */
    /* JADX WARN: Code duplicated, block: B:91:0x016c  */
    /* JADX WARN: Code duplicated, block: B:93:0x0170 A[Catch: RuntimeException -> 0x0382, TryCatch #0 {RuntimeException -> 0x0382, blocks: (B:4:0x0010, B:6:0x0019, B:9:0x0024, B:17:0x0035, B:35:0x005e, B:39:0x006c, B:41:0x0078, B:43:0x007c, B:45:0x008a, B:47:0x009c, B:48:0x00bc, B:49:0x00bd, B:51:0x00ca, B:53:0x00ce, B:55:0x00e5, B:60:0x010f, B:65:0x011c, B:67:0x0122, B:93:0x0170, B:94:0x0173, B:95:0x019c, B:96:0x019d, B:145:0x034e, B:147:0x0352, B:149:0x0359, B:97:0x01db, B:99:0x020e, B:101:0x0218, B:102:0x021a, B:105:0x0245, B:110:0x0251, B:114:0x025e, B:116:0x0268, B:117:0x026a, B:118:0x028f, B:108:0x024d, B:121:0x02aa, B:127:0x02ba, B:128:0x02e1, B:124:0x02b4, B:130:0x02ff, B:132:0x0309, B:133:0x030b, B:134:0x031f, B:136:0x0329, B:137:0x032b, B:138:0x0335, B:140:0x033e, B:141:0x0340, B:69:0x0127, B:71:0x012b, B:73:0x013a, B:75:0x014a, B:76:0x014f, B:63:0x0118, B:31:0x0056, B:12:0x002c, B:5:0x0015), top: B:154:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0173 A[Catch: RuntimeException -> 0x0382, TryCatch #0 {RuntimeException -> 0x0382, blocks: (B:4:0x0010, B:6:0x0019, B:9:0x0024, B:17:0x0035, B:35:0x005e, B:39:0x006c, B:41:0x0078, B:43:0x007c, B:45:0x008a, B:47:0x009c, B:48:0x00bc, B:49:0x00bd, B:51:0x00ca, B:53:0x00ce, B:55:0x00e5, B:60:0x010f, B:65:0x011c, B:67:0x0122, B:93:0x0170, B:94:0x0173, B:95:0x019c, B:96:0x019d, B:145:0x034e, B:147:0x0352, B:149:0x0359, B:97:0x01db, B:99:0x020e, B:101:0x0218, B:102:0x021a, B:105:0x0245, B:110:0x0251, B:114:0x025e, B:116:0x0268, B:117:0x026a, B:118:0x028f, B:108:0x024d, B:121:0x02aa, B:127:0x02ba, B:128:0x02e1, B:124:0x02b4, B:130:0x02ff, B:132:0x0309, B:133:0x030b, B:134:0x031f, B:136:0x0329, B:137:0x032b, B:138:0x0335, B:140:0x033e, B:141:0x0340, B:69:0x0127, B:71:0x012b, B:73:0x013a, B:75:0x014a, B:76:0x014f, B:63:0x0118, B:31:0x0056, B:12:0x002c, B:5:0x0015), top: B:154:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:97:0x01db A[Catch: RuntimeException -> 0x0382, TryCatch #0 {RuntimeException -> 0x0382, blocks: (B:4:0x0010, B:6:0x0019, B:9:0x0024, B:17:0x0035, B:35:0x005e, B:39:0x006c, B:41:0x0078, B:43:0x007c, B:45:0x008a, B:47:0x009c, B:48:0x00bc, B:49:0x00bd, B:51:0x00ca, B:53:0x00ce, B:55:0x00e5, B:60:0x010f, B:65:0x011c, B:67:0x0122, B:93:0x0170, B:94:0x0173, B:95:0x019c, B:96:0x019d, B:145:0x034e, B:147:0x0352, B:149:0x0359, B:97:0x01db, B:99:0x020e, B:101:0x0218, B:102:0x021a, B:105:0x0245, B:110:0x0251, B:114:0x025e, B:116:0x0268, B:117:0x026a, B:118:0x028f, B:108:0x024d, B:121:0x02aa, B:127:0x02ba, B:128:0x02e1, B:124:0x02b4, B:130:0x02ff, B:132:0x0309, B:133:0x030b, B:134:0x031f, B:136:0x0329, B:137:0x032b, B:138:0x0335, B:140:0x033e, B:141:0x0340, B:69:0x0127, B:71:0x012b, B:73:0x013a, B:75:0x014a, B:76:0x014f, B:63:0x0118, B:31:0x0056, B:12:0x002c, B:5:0x0015), top: B:154:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:99:0x020e A[Catch: RuntimeException -> 0x0382, TryCatch #0 {RuntimeException -> 0x0382, blocks: (B:4:0x0010, B:6:0x0019, B:9:0x0024, B:17:0x0035, B:35:0x005e, B:39:0x006c, B:41:0x0078, B:43:0x007c, B:45:0x008a, B:47:0x009c, B:48:0x00bc, B:49:0x00bd, B:51:0x00ca, B:53:0x00ce, B:55:0x00e5, B:60:0x010f, B:65:0x011c, B:67:0x0122, B:93:0x0170, B:94:0x0173, B:95:0x019c, B:96:0x019d, B:145:0x034e, B:147:0x0352, B:149:0x0359, B:97:0x01db, B:99:0x020e, B:101:0x0218, B:102:0x021a, B:105:0x0245, B:110:0x0251, B:114:0x025e, B:116:0x0268, B:117:0x026a, B:118:0x028f, B:108:0x024d, B:121:0x02aa, B:127:0x02ba, B:128:0x02e1, B:124:0x02b4, B:130:0x02ff, B:132:0x0309, B:133:0x030b, B:134:0x031f, B:136:0x0329, B:137:0x032b, B:138:0x0335, B:140:0x033e, B:141:0x0340, B:69:0x0127, B:71:0x012b, B:73:0x013a, B:75:0x014a, B:76:0x014f, B:63:0x0118, B:31:0x0056, B:12:0x002c, B:5:0x0015), top: B:154:0x000e }] */
    /* JADX WARN: Instruction removed from duplicated block: B:94:0x0173, please report this as an issue */
    public Timestamp getTimestampFast(int i, byte[] bArr, int i2, int i3, Calendar calendar, TimeZone timeZone, boolean z, MySQLConnection mySQLConnection, ResultSetImpl resultSetImpl, boolean z2, boolean z3) throws SQLException {
        boolean z4;
        boolean z5;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z6;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z7;
        int i19;
        int i20;
        int i21;
        int i22 = i3;
        try {
            Calendar prolepticIfNeeded = TimeUtil.setProlepticIfNeeded(z3 ? mySQLConnection.getUtcCalendar() : resultSetImpl.getCalendarInstanceForSessionOrNew(), calendar);
            int i23 = 0;
            while (true) {
                if (i23 >= i22) {
                    z4 = false;
                    break;
                }
                if (bArr[i2 + i23] == 58) {
                    z4 = true;
                    break;
                }
                i23++;
            }
            int i24 = 0;
            while (true) {
                if (i24 >= i22) {
                    z5 = true;
                    break;
                }
                byte b = bArr[i2 + i24];
                if (b == 32 || b == 45 || b == 47) {
                    z4 = false;
                }
                if (b != 48 && b != 32 && b != 58 && b != 45 && b != 47 && b != 46) {
                    z5 = false;
                    break;
                }
                i24++;
            }
            if (!z4 && z5) {
                if (ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_CONVERT_TO_NULL.equals(mySQLConnection.getZeroDateTimeBehavior())) {
                    return null;
                }
                if (!ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_EXCEPTION.equals(mySQLConnection.getZeroDateTimeBehavior())) {
                    return !resultSetImpl.useLegacyDatetimeCode ? TimeUtil.fastTimestampCreate(timeZone, 1, 1, 1, 0, 0, 0, 0) : resultSetImpl.fastTimestampCreate(null, 1, 1, 1, 0, 0, 0, 0, z2);
                }
                throw SQLError.createSQLException("Value '" + StringUtils.toString(bArr) + "' can not be represented as java.sql.Timestamp", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
            }
            if (this.metadata[i].getMysqlType() == 13) {
                return !resultSetImpl.useLegacyDatetimeCode ? TimeUtil.fastTimestampCreate(timeZone, StringUtils.getInt(bArr, i2, 4), 1, 1, 0, 0, 0, 0) : TimeUtil.changeTimezone(mySQLConnection, prolepticIfNeeded, calendar, resultSetImpl.fastTimestampCreate(prolepticIfNeeded, StringUtils.getInt(bArr, i2, 4), 1, 1, 0, 0, 0, 0, z2), mySQLConnection.getServerTimezoneTZ(), timeZone, z);
            }
            int i25 = 0;
            while (true) {
                if (i25 >= i22) {
                    i25 = -1;
                    break;
                }
                if (bArr[i2 + i25] == 46) {
                    break;
                }
                i25++;
            }
            int i26 = i2 + i22;
            if (i25 != i26 - 1) {
                if (i25 != -1) {
                    if (i25 + 2 > i22) {
                        throw new IllegalArgumentException();
                    }
                    int iPow = StringUtils.getInt(bArr, i2 + i25 + 1, i26);
                    int i27 = i22 - (i25 + 1);
                    if (i27 < 9) {
                        iPow *= (int) Math.pow(10.0d, 9 - i27);
                    }
                    i22 = i25;
                    i4 = iPow;
                }
                if (i22 != 2) {
                    if (i22 != 4) {
                        if (i22 != 6) {
                            int i28 = i2 + 2;
                            i13 = StringUtils.getInt(bArr, i2 + 0, i28);
                            if (i13 <= 69) {
                                i13 += 100;
                            }
                            int i29 = i2 + 4;
                            int i30 = StringUtils.getInt(bArr, i28, i29);
                            i8 = StringUtils.getInt(bArr, i29, i2 + 6);
                            i6 = i13 + 1900;
                            i7 = i30;
                        } else if (i22 != 8) {
                            i14 = 0;
                            while (true) {
                                if (i14 < i22) {
                                    z6 = false;
                                    break;
                                }
                                if (bArr[i2 + i14] == 58) {
                                    z6 = true;
                                    break;
                                }
                                i14++;
                            }
                            if (z6) {
                                int i31 = StringUtils.getInt(bArr, i2 + 0, i2 + 2);
                                int i32 = StringUtils.getInt(bArr, i2 + 3, i2 + 5);
                                i11 = StringUtils.getInt(bArr, i2 + 6, i2 + 8);
                                i9 = i31;
                                i10 = i32;
                                i6 = 1970;
                                i7 = 1;
                                i8 = 1;
                            } else {
                                int i33 = i2 + 4;
                                int i34 = StringUtils.getInt(bArr, i2 + 0, i33);
                                int i35 = i2 + 6;
                                int i36 = StringUtils.getInt(bArr, i33, i35);
                                i15 = StringUtils.getInt(bArr, i35, i2 + 8);
                                i16 = i34 - 1900;
                                i17 = i36 - 1;
                                i8 = i15;
                                i6 = i16;
                                i7 = i17;
                            }
                        } else if (i22 != 10) {
                            if (i22 != 12) {
                                int i37 = i2 + 2;
                                i19 = StringUtils.getInt(bArr, i2 + 0, i37);
                                if (i19 <= 69) {
                                    i19 += 100;
                                }
                                int i38 = i2 + 4;
                                int i39 = StringUtils.getInt(bArr, i37, i38);
                                int i40 = i2 + 6;
                                int i41 = StringUtils.getInt(bArr, i38, i40);
                                int i42 = i2 + 8;
                                i20 = StringUtils.getInt(bArr, i40, i42);
                                int i43 = i2 + 10;
                                i21 = StringUtils.getInt(bArr, i42, i43);
                                i11 = StringUtils.getInt(bArr, i43, i2 + 12);
                                i6 = i19 + 1900;
                                i8 = i41;
                                i7 = i39;
                            } else if (i22 != 14) {
                                if (i22 != 29) {
                                    switch (i22) {
                                        case 19:
                                        case 20:
                                        case 21:
                                        case 22:
                                        case 23:
                                        case 24:
                                        case 25:
                                        case 26:
                                            break;
                                        default:
                                            throw new SQLException("Bad format for Timestamp '" + StringUtils.toString(bArr) + "' in column " + (i + 1) + ".", SQLError.SQL_STATE_ILLEGAL_ARGUMENT);
                                    }
                                }
                                int i44 = StringUtils.getInt(bArr, i2 + 0, i2 + 4);
                                int i45 = StringUtils.getInt(bArr, i2 + 5, i2 + 7);
                                int i46 = StringUtils.getInt(bArr, i2 + 8, i2 + 10);
                                int i47 = StringUtils.getInt(bArr, i2 + 11, i2 + 13);
                                int i48 = StringUtils.getInt(bArr, i2 + 14, i2 + 16);
                                i11 = StringUtils.getInt(bArr, i2 + 17, i2 + 19);
                                i6 = i44;
                                i7 = i45;
                                i8 = i46;
                                i9 = i47;
                                i10 = i48;
                            } else {
                                int i49 = i2 + 4;
                                int i50 = StringUtils.getInt(bArr, i2 + 0, i49);
                                int i51 = i2 + 6;
                                int i52 = StringUtils.getInt(bArr, i49, i51);
                                int i53 = i2 + 8;
                                int i54 = StringUtils.getInt(bArr, i51, i53);
                                int i55 = i2 + 10;
                                i20 = StringUtils.getInt(bArr, i53, i55);
                                int i56 = i2 + 12;
                                i21 = StringUtils.getInt(bArr, i55, i56);
                                i11 = StringUtils.getInt(bArr, i56, i2 + 14);
                                i6 = i50;
                                i7 = i52;
                                i8 = i54;
                            }
                            i9 = i20;
                            i10 = i21;
                        } else {
                            i18 = 0;
                            while (true) {
                                if (i18 < i22) {
                                    z7 = false;
                                    break;
                                }
                                if (bArr[i2 + i18] == 45) {
                                    z7 = true;
                                    break;
                                }
                                i18++;
                            }
                            if (this.metadata[i].getMysqlType() != 10 || z7) {
                                i16 = StringUtils.getInt(bArr, i2 + 0, i2 + 4);
                                i17 = StringUtils.getInt(bArr, i2 + 5, i2 + 7);
                                i15 = StringUtils.getInt(bArr, i2 + 8, i2 + 10);
                                i8 = i15;
                                i6 = i16;
                                i7 = i17;
                            } else {
                                int i57 = i2 + 2;
                                int i58 = StringUtils.getInt(bArr, i2 + 0, i57);
                                if (i58 <= 69) {
                                    i58 += 100;
                                }
                                int i59 = i2 + 4;
                                int i60 = StringUtils.getInt(bArr, i57, i59);
                                int i61 = i2 + 6;
                                int i62 = StringUtils.getInt(bArr, i59, i61);
                                int i63 = i2 + 8;
                                int i64 = StringUtils.getInt(bArr, i61, i63);
                                i10 = StringUtils.getInt(bArr, i63, i2 + 10);
                                i6 = i58 + 1900;
                                i8 = i62;
                                i7 = i60;
                                i9 = i64;
                            }
                            i11 = 0;
                        }
                        i9 = 0;
                        i10 = 0;
                        i11 = 0;
                    } else {
                        int i65 = i2 + 2;
                        i12 = StringUtils.getInt(bArr, i2 + 0, i65);
                        if (i12 <= 69) {
                            i12 += 100;
                        }
                        i7 = StringUtils.getInt(bArr, i65, i2 + 4);
                        i6 = i12;
                    }
                    return !resultSetImpl.useLegacyDatetimeCode ? TimeUtil.fastTimestampCreate(timeZone, i6, i7, i8, i9, i10, i11, i4) : TimeUtil.changeTimezone(mySQLConnection, prolepticIfNeeded, calendar, resultSetImpl.fastTimestampCreate(prolepticIfNeeded, i6, i7, i8, i9, i10, i11, i4, z2), mySQLConnection.getServerTimezoneTZ(), timeZone, z);
                }
                i5 = StringUtils.getInt(bArr, i2 + 0, i2 + 2);
                if (i5 <= 69) {
                    i5 += 100;
                }
                i6 = i5 + 1900;
                i7 = 1;
                i8 = 1;
                i9 = 0;
                i10 = 0;
                i11 = 0;
                if (!resultSetImpl.useLegacyDatetimeCode) {
                }
            }
            i22--;
            i4 = 0;
            if (i22 != 2) {
                if (i22 != 4) {
                    if (i22 != 6) {
                        int i210 = i2 + 2;
                        i13 = StringUtils.getInt(bArr, i2 + 0, i210);
                        if (i13 <= 69) {
                            i13 += 100;
                        }
                        int i211 = i2 + 4;
                        int i310 = StringUtils.getInt(bArr, i210, i211);
                        i8 = StringUtils.getInt(bArr, i211, i2 + 6);
                        i6 = i13 + 1900;
                        i7 = i310;
                    } else if (i22 != 8) {
                        i14 = 0;
                        while (true) {
                            if (i14 < i22) {
                                z6 = false;
                                break;
                            }
                            if (bArr[i2 + i14] == 58) {
                                z6 = true;
                                break;
                            }
                            i14++;
                        }
                        if (z6) {
                            int i311 = StringUtils.getInt(bArr, i2 + 0, i2 + 2);
                            int i312 = StringUtils.getInt(bArr, i2 + 3, i2 + 5);
                            i11 = StringUtils.getInt(bArr, i2 + 6, i2 + 8);
                            i9 = i311;
                            i10 = i312;
                            i6 = 1970;
                            i7 = 1;
                            i8 = 1;
                        } else {
                            int i313 = i2 + 4;
                            int i314 = StringUtils.getInt(bArr, i2 + 0, i313);
                            int i315 = i2 + 6;
                            int i316 = StringUtils.getInt(bArr, i313, i315);
                            i15 = StringUtils.getInt(bArr, i315, i2 + 8);
                            i16 = i314 - 1900;
                            i17 = i316 - 1;
                            i8 = i15;
                            i6 = i16;
                            i7 = i17;
                        }
                    } else if (i22 != 10) {
                        if (i22 != 12) {
                            int i317 = i2 + 2;
                            i19 = StringUtils.getInt(bArr, i2 + 0, i317);
                            if (i19 <= 69) {
                                i19 += 100;
                            }
                            int i318 = i2 + 4;
                            int i319 = StringUtils.getInt(bArr, i317, i318);
                            int i410 = i2 + 6;
                            int i411 = StringUtils.getInt(bArr, i318, i410);
                            int i412 = i2 + 8;
                            i20 = StringUtils.getInt(bArr, i410, i412);
                            int i413 = i2 + 10;
                            i21 = StringUtils.getInt(bArr, i412, i413);
                            i11 = StringUtils.getInt(bArr, i413, i2 + 12);
                            i6 = i19 + 1900;
                            i8 = i411;
                            i7 = i319;
                        } else if (i22 != 14) {
                            if (i22 != 29) {
                                switch (i22) {
                                    case 19:
                                    case 20:
                                    case 21:
                                    case 22:
                                    case 23:
                                    case 24:
                                    case 25:
                                    case 26:
                                        break;
                                    default:
                                        throw new SQLException("Bad format for Timestamp '" + StringUtils.toString(bArr) + "' in column " + (i + 1) + ".", SQLError.SQL_STATE_ILLEGAL_ARGUMENT);
                                }
                            }
                            int i414 = StringUtils.getInt(bArr, i2 + 0, i2 + 4);
                            int i415 = StringUtils.getInt(bArr, i2 + 5, i2 + 7);
                            int i416 = StringUtils.getInt(bArr, i2 + 8, i2 + 10);
                            int i417 = StringUtils.getInt(bArr, i2 + 11, i2 + 13);
                            int i418 = StringUtils.getInt(bArr, i2 + 14, i2 + 16);
                            i11 = StringUtils.getInt(bArr, i2 + 17, i2 + 19);
                            i6 = i414;
                            i7 = i415;
                            i8 = i416;
                            i9 = i417;
                            i10 = i418;
                        } else {
                            int i419 = i2 + 4;
                            int i510 = StringUtils.getInt(bArr, i2 + 0, i419);
                            int i511 = i2 + 6;
                            int i512 = StringUtils.getInt(bArr, i419, i511);
                            int i513 = i2 + 8;
                            int i514 = StringUtils.getInt(bArr, i511, i513);
                            int i515 = i2 + 10;
                            i20 = StringUtils.getInt(bArr, i513, i515);
                            int i516 = i2 + 12;
                            i21 = StringUtils.getInt(bArr, i515, i516);
                            i11 = StringUtils.getInt(bArr, i516, i2 + 14);
                            i6 = i510;
                            i7 = i512;
                            i8 = i514;
                        }
                        i9 = i20;
                        i10 = i21;
                    } else {
                        i18 = 0;
                        while (true) {
                            if (i18 < i22) {
                                z7 = false;
                                break;
                            }
                            if (bArr[i2 + i18] == 45) {
                                z7 = true;
                                break;
                            }
                            i18++;
                        }
                        if (this.metadata[i].getMysqlType() != 10) {
                        }
                        i16 = StringUtils.getInt(bArr, i2 + 0, i2 + 4);
                        i17 = StringUtils.getInt(bArr, i2 + 5, i2 + 7);
                        i15 = StringUtils.getInt(bArr, i2 + 8, i2 + 10);
                        i8 = i15;
                        i6 = i16;
                        i7 = i17;
                    }
                    i9 = 0;
                    i10 = 0;
                    i11 = 0;
                } else {
                    int i66 = i2 + 2;
                    i12 = StringUtils.getInt(bArr, i2 + 0, i66);
                    if (i12 <= 69) {
                        i12 += 100;
                    }
                    i7 = StringUtils.getInt(bArr, i66, i2 + 4);
                    i6 = i12;
                }
                if (!resultSetImpl.useLegacyDatetimeCode) {
                }
            }
            i5 = StringUtils.getInt(bArr, i2 + 0, i2 + 2);
            if (i5 <= 69) {
                i5 += 100;
            }
            i6 = i5 + 1900;
            i7 = 1;
            i8 = 1;
            i9 = 0;
            i10 = 0;
            i11 = 0;
            if (!resultSetImpl.useLegacyDatetimeCode) {
            }
        } catch (RuntimeException e) {
            SQLException sQLExceptionCreateSQLException = SQLError.createSQLException("Cannot convert value '" + getString(i, "ISO8859_1", mySQLConnection) + "' from column " + (i + 1) + " to TIMESTAMP.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
            sQLExceptionCreateSQLException.initCause(e);
            throw sQLExceptionCreateSQLException;
        }
    }

    public abstract boolean isFloatingPointNumber(int i) throws SQLException;

    public abstract boolean isNull(int i) throws SQLException;

    public abstract long length(int i) throws SQLException;

    public abstract void setColumnValue(int i, byte[] bArr) throws SQLException;

    public ResultSetRow setMetadata(Field[] fieldArr) throws SQLException {
        this.metadata = fieldArr;
        return this;
    }
}
