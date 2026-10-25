package com.mysql.jdbc;

import com.p000nx.assist.lua.LuaNative;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Properties;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class TimeUtil {
    private static final String TIME_ZONE_MAPPINGS_RESOURCE = "/com/mysql/jdbc/TimeZoneMapping.properties";
    public static final Method systemNanoTimeMethod;
    public static final TimeZone GMT_TIMEZONE = TimeZone.getTimeZone("GMT");
    private static final TimeZone DEFAULT_TIMEZONE = TimeZone.getDefault();
    private static Properties timeZoneMappings = null;

    static {
        Method method = null;
        try {
            method = System.class.getMethod("nanoTime", null);
        } catch (NoSuchMethodException | SecurityException unused) {
        }
        systemNanoTimeMethod = method;
    }

    public static Timestamp adjustTimestampNanosPrecision(Timestamp timestamp, int i, boolean z) throws SQLException {
        int iRound;
        if (i < 0 || i > 6) {
            throw SQLError.createSQLException("fsp value must be in 0 to 6 range.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
        }
        Timestamp timestamp2 = (Timestamp) timestamp.clone();
        int nanos = timestamp2.getNanos();
        double dPow = Math.pow(10.0d, 9 - i);
        if (z) {
            iRound = ((int) Math.round(((double) nanos) / dPow)) * ((int) dPow);
            if (iRound > 999999999) {
                iRound %= 1000000000;
                timestamp2.setTime(timestamp2.getTime() + 1000);
            }
        } else {
            iRound = ((int) dPow) * ((int) (((double) nanos) / dPow));
        }
        timestamp2.setNanos(iRound);
        return timestamp2;
    }

    public static Time changeTimezone(MySQLConnection mySQLConnection, Calendar calendar, Calendar calendar2, Time time, TimeZone timeZone, TimeZone timeZone2, boolean z) {
        if (mySQLConnection != null) {
            if (mySQLConnection.getUseTimezone() && !mySQLConnection.getNoTimezoneConversionForTimeType()) {
                Calendar calendar3 = Calendar.getInstance(timeZone);
                calendar3.setTime(time);
                int i = calendar3.get(15) + calendar3.get(16);
                Calendar calendar4 = Calendar.getInstance(timeZone2);
                calendar4.setTime(time);
                int i2 = i - (calendar4.get(15) + calendar4.get(16));
                long time2 = calendar4.getTime().getTime();
                return new Time(z ? time2 + ((long) i2) : time2 - ((long) i2));
            }
            if (mySQLConnection.getUseJDBCCompliantTimezoneShift() && calendar2 != null) {
                return new Time(jdbcCompliantZoneShift(calendar, calendar2, time));
            }
        }
        return time;
    }

    public static final Date fastDateCreate(boolean z, Calendar calendar, Calendar calendar2, int i, int i2, int i3) {
        Date date;
        if (z) {
            if (calendar == null) {
                calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
            }
            calendar2 = calendar;
        }
        synchronized (calendar2) {
            java.util.Date time = calendar2.getTime();
            try {
                calendar2.clear();
                calendar2.set(14, 0);
                calendar2.set(i, i2 - 1, i3, 0, 0, 0);
                date = new Date(calendar2.getTimeInMillis());
                calendar2.setTime(time);
            } catch (Throwable th) {
                calendar2.setTime(time);
                throw th;
            }
        }
        return date;
    }

    public static final Time fastTimeCreate(Calendar calendar, int i, int i2, int i3, ExceptionInterceptor exceptionInterceptor) throws SQLException {
        Time time;
        if (i < 0 || i > 24) {
            throw SQLError.createSQLException("Illegal hour value '" + i + "' for java.sql.Time type in value '" + timeFormattedString(i, i2, i3) + ".", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
        }
        if (i2 < 0 || i2 > 59) {
            throw SQLError.createSQLException("Illegal minute value '" + i2 + "' for java.sql.Time type in value '" + timeFormattedString(i, i2, i3) + ".", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
        }
        if (i3 < 0 || i3 > 59) {
            throw SQLError.createSQLException("Illegal minute value '" + i3 + "' for java.sql.Time type in value '" + timeFormattedString(i, i2, i3) + ".", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
        }
        synchronized (calendar) {
            java.util.Date time2 = calendar.getTime();
            try {
                calendar.clear();
                calendar.set(1970, 0, 1, i, i2, i3);
                time = new Time(calendar.getTimeInMillis());
                calendar.setTime(time2);
            } catch (Throwable th) {
                calendar.setTime(time2);
                throw th;
            }
        }
        return time;
    }

    public static final Timestamp fastTimestampCreate(boolean z, Calendar calendar, Calendar calendar2, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        Timestamp timestamp;
        synchronized (calendar2) {
            java.util.Date time = calendar2.getTime();
            try {
                calendar2.clear();
                calendar2.set(i, i2 - 1, i3, i4, i5, i6);
                int i8 = 0;
                if (z) {
                    int i9 = calendar2.get(15) + calendar2.get(16);
                    Calendar calendar3 = calendar == null ? Calendar.getInstance(TimeZone.getTimeZone("GMT")) : calendar;
                    calendar3.clear();
                    calendar3.setTimeInMillis(calendar2.getTimeInMillis());
                    i8 = i9 - (calendar3.get(15) + calendar3.get(16));
                }
                if (i7 != 0) {
                    calendar2.set(14, i7 / LuaNative.LUAI_MAXSTACK);
                }
                timestamp = new Timestamp(calendar2.getTimeInMillis() + ((long) i8));
                timestamp.setNanos(i7);
                calendar2.setTime(time);
            } catch (Throwable th) {
                calendar2.setTime(time);
                throw th;
            }
        }
        return timestamp;
    }

    public static String formatNanos(int i, boolean z, int i2) throws SQLException {
        int iPow;
        if (i < 0 || i > 999999999) {
            throw SQLError.createSQLException("nanos value must be in 0 to 999999999 range but was " + i, SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
        }
        if (i2 < 0 || i2 > 6) {
            throw SQLError.createSQLException("fsp value must be in 0 to 6 range but was " + i2, SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
        }
        if (!z || i2 == 0 || i == 0 || (iPow = (int) (((double) i) / Math.pow(10.0d, 9 - i2))) == 0) {
            return "0";
        }
        String string = Integer.toString(iPow);
        String str = "000000000".substring(0, i2 - string.length()) + string;
        do {
            i2--;
        } while (str.charAt(i2) == '0');
        return str.substring(0, i2 + 1);
    }

    public static String getCanonicalTimezone(String str, ExceptionInterceptor exceptionInterceptor) throws SQLException {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.length() > 2 && ((strTrim.charAt(0) == '+' || strTrim.charAt(0) == '-') && Character.isDigit(strTrim.charAt(1)))) {
            return "GMT" + strTrim;
        }
        synchronized (TimeUtil.class) {
            if (timeZoneMappings == null) {
                loadTimeZoneMappings(exceptionInterceptor);
            }
        }
        String property = timeZoneMappings.getProperty(strTrim);
        if (property != null) {
            return property;
        }
        throw SQLError.createSQLException(Messages.getString("TimeUtil.UnrecognizedTimezoneId", new Object[]{strTrim}), SQLError.SQL_STATE_INVALID_CONNECTION_ATTRIBUTE, exceptionInterceptor);
    }

    public static long getCurrentTimeNanosOrMillis() {
        Method method = systemNanoTimeMethod;
        if (method != null) {
            try {
                return ((Long) method.invoke(null, null)).longValue();
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
        return System.currentTimeMillis();
    }

    public static final TimeZone getDefaultTimeZone(boolean z) {
        return (TimeZone) (z ? DEFAULT_TIMEZONE : TimeZone.getDefault()).clone();
    }

    public static SimpleDateFormat getSimpleDateFormat(SimpleDateFormat simpleDateFormat, String str, Calendar calendar, TimeZone timeZone) {
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        }
        if (calendar != null) {
            simpleDateFormat.setCalendar((Calendar) calendar.clone());
        }
        if (timeZone != null) {
            simpleDateFormat.setTimeZone(timeZone);
        }
        return simpleDateFormat;
    }

    private static long jdbcCompliantZoneShift(Calendar calendar, Calendar calendar2, java.util.Date date) {
        long time;
        if (calendar == null) {
            calendar = new GregorianCalendar();
        }
        synchronized (calendar) {
            java.util.Date time2 = calendar2.getTime();
            java.util.Date time3 = calendar.getTime();
            try {
                calendar.setTime(date);
                calendar2.set(1, calendar.get(1));
                calendar2.set(2, calendar.get(2));
                calendar2.set(5, calendar.get(5));
                calendar2.set(11, calendar.get(11));
                calendar2.set(12, calendar.get(12));
                calendar2.set(13, calendar.get(13));
                calendar2.set(14, calendar.get(14));
                time = calendar2.getTime().getTime();
                calendar.setTime(time3);
                calendar2.setTime(time2);
            } catch (Throwable th) {
                calendar.setTime(time3);
                calendar2.setTime(time2);
                throw th;
            }
        }
        return time;
    }

    private static void loadTimeZoneMappings(ExceptionInterceptor exceptionInterceptor) throws SQLException {
        Properties properties = new Properties();
        timeZoneMappings = properties;
        try {
            properties.load(TimeUtil.class.getResourceAsStream(TIME_ZONE_MAPPINGS_RESOURCE));
            for (String str : TimeZone.getAvailableIDs()) {
                if (!timeZoneMappings.containsKey(str)) {
                    timeZoneMappings.put(str, str);
                }
            }
        } catch (IOException unused) {
            throw SQLError.createSQLException(Messages.getString("TimeUtil.LoadTimeZoneMappingError"), SQLError.SQL_STATE_INVALID_CONNECTION_ATTRIBUTE, exceptionInterceptor);
        }
    }

    public static boolean nanoTimeAvailable() {
        return systemNanoTimeMethod != null;
    }

    public static Calendar setProlepticIfNeeded(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null || !(calendar instanceof GregorianCalendar) || !(calendar2 instanceof GregorianCalendar) || ((GregorianCalendar) calendar2).getGregorianChange().getTime() != Long.MIN_VALUE) {
            return calendar;
        }
        GregorianCalendar gregorianCalendar = (GregorianCalendar) calendar.clone();
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        gregorianCalendar.clear();
        return gregorianCalendar;
    }

    private static String timeFormattedString(int i, int i2, int i3) {
        StringBuilder sb = new StringBuilder(8);
        if (i < 10) {
            sb.append("0");
        }
        sb.append(i);
        sb.append(":");
        if (i2 < 10) {
            sb.append("0");
        }
        sb.append(i2);
        sb.append(":");
        if (i3 < 10) {
            sb.append("0");
        }
        sb.append(i3);
        return sb.toString();
    }

    public static Timestamp truncateFractionalSeconds(Timestamp timestamp) {
        Timestamp timestamp2 = new Timestamp(timestamp.getTime());
        timestamp2.setNanos(0);
        return timestamp2;
    }

    public static Timestamp changeTimezone(MySQLConnection mySQLConnection, Calendar calendar, Calendar calendar2, Timestamp timestamp, TimeZone timeZone, TimeZone timeZone2, boolean z) {
        if (mySQLConnection != null) {
            if (mySQLConnection.getUseTimezone()) {
                Calendar calendar3 = Calendar.getInstance(timeZone);
                calendar3.setTime(timestamp);
                int i = calendar3.get(15) + calendar3.get(16);
                Calendar calendar4 = Calendar.getInstance(timeZone2);
                calendar4.setTime(timestamp);
                int i2 = i - (calendar4.get(15) + calendar4.get(16));
                long time = calendar4.getTime().getTime();
                return new Timestamp(z ? time + ((long) i2) : time - ((long) i2));
            }
            if (mySQLConnection.getUseJDBCCompliantTimezoneShift() && calendar2 != null) {
                Timestamp timestamp2 = new Timestamp(jdbcCompliantZoneShift(calendar, calendar2, timestamp));
                timestamp2.setNanos(timestamp.getNanos());
                return timestamp2;
            }
        }
        return timestamp;
    }

    public static final Date fastDateCreate(int i, int i2, int i3, Calendar calendar) {
        Date date;
        if (calendar == null) {
            calendar = new GregorianCalendar();
        }
        synchronized (calendar) {
            java.util.Date time = calendar.getTime();
            try {
                calendar.clear();
                calendar.set(i, i2 - 1, i3, 0, 0, 0);
                calendar.set(14, 0);
                date = new Date(calendar.getTimeInMillis());
                calendar.setTime(time);
            } catch (Throwable th) {
                calendar.setTime(time);
                throw th;
            }
        }
        return date;
    }

    public static final Time fastTimeCreate(int i, int i2, int i3, Calendar calendar, ExceptionInterceptor exceptionInterceptor) throws SQLException {
        Time time;
        if (i < 0 || i > 23) {
            throw SQLError.createSQLException("Illegal hour value '" + i + "' for java.sql.Time type in value '" + timeFormattedString(i, i2, i3) + ".", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
        }
        if (i2 < 0 || i2 > 59) {
            throw SQLError.createSQLException("Illegal minute value '" + i2 + "' for java.sql.Time type in value '" + timeFormattedString(i, i2, i3) + ".", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
        }
        if (i3 >= 0 && i3 <= 59) {
            if (calendar == null) {
                calendar = new GregorianCalendar();
            }
            synchronized (calendar) {
                java.util.Date time2 = calendar.getTime();
                try {
                    calendar.clear();
                    calendar.set(1970, 0, 1, i, i2, i3);
                    time = new Time(calendar.getTimeInMillis());
                    calendar.setTime(time2);
                } catch (Throwable th) {
                    calendar.setTime(time2);
                    throw th;
                }
            }
            return time;
        }
        throw SQLError.createSQLException("Illegal minute value '" + i3 + "' for java.sql.Time type in value '" + timeFormattedString(i, i2, i3) + ".", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
    }

    public static final Timestamp fastTimestampCreate(TimeZone timeZone, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        GregorianCalendar gregorianCalendar = timeZone == null ? new GregorianCalendar() : new GregorianCalendar(timeZone);
        gregorianCalendar.clear();
        gregorianCalendar.set(i, i2 - 1, i3, i4, i5, i6);
        Timestamp timestamp = new Timestamp(gregorianCalendar.getTimeInMillis());
        timestamp.setNanos(i7);
        return timestamp;
    }
}
