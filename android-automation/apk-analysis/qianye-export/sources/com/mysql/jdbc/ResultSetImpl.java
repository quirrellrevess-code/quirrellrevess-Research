package com.mysql.jdbc;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.log.LogUtils;
import com.mysql.jdbc.profiler.ProfilerEvent;
import com.mysql.jdbc.profiler.ProfilerEventHandler;
import com.tencent.smtt.export.external.interfaces.ISelectionInterface;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Array;
import java.sql.Date;
import java.sql.Ref;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.TreeMap;
import okhttp3.internal.http2.Settings;

/* JADX INFO: loaded from: classes.dex */
public class ResultSetImpl implements ResultSetInternalMethods {
    public static final char[] EMPTY_SPACE;
    private static final Constructor<?> JDBC_4_RS_4_ARG_CTOR;
    private static final Constructor<?> JDBC_4_RS_5_ARG_CTOR;
    private static final Constructor<?> JDBC_4_UPD_RS_5_ARG_CTOR;
    public static final double MAX_DIFF_PREC;
    public static final double MIN_DIFF_PREC;
    public static int resultCounter;
    public String catalog;
    public Map<String, Integer> columnLabelToIndex;
    public Map<String, Integer> columnNameToIndex;
    public Map<String, Integer> columnToIndexCache;
    public boolean[] columnUsed;
    public volatile MySQLConnection connection;
    public long connectionId;
    public int currentRow;
    public boolean doingUpdates;
    public ProfilerEventHandler eventSink;
    private ExceptionInterceptor exceptionInterceptor;
    public Calendar fastClientCal;
    public Calendar fastDefaultCal;
    public int fetchDirection;
    public int fetchSize;
    public Field[] fields;
    public char firstCharOfQuery;
    public Map<String, Integer> fullColumnNameToIndex;
    public Calendar gmtCalendar;
    public boolean hasBuiltIndexMapping;
    private String invalidRowReason;
    public boolean isBinaryEncoded;
    public boolean isClosed;
    private boolean jdbcCompliantTruncationForReads;
    public ResultSetInternalMethods nextResultSet;
    public boolean onInsertRow;
    private boolean onValidRow;
    public StatementImpl owningStatement;
    private boolean padCharsWithSpace;
    public String pointOfOrigin;
    public boolean profileSql;
    public boolean reallyResult;
    public int resultId;
    public int resultSetConcurrency;
    public int resultSetType;
    public boolean retainOwningStatement;
    public RowData rowData;
    public String serverInfo;
    private TimeZone serverTimeZoneTz;
    public PreparedStatement statementUsedForFetchingRows;
    public ResultSetRow thisRow;
    public long updateCount;
    public long updateId;
    private boolean useColumnNamesInFindColumn;
    public boolean useFastDateParsing;
    private boolean useFastIntParsing;
    public boolean useLegacyDatetimeCode;
    private boolean useStrictFloatingPoint;
    public boolean useUsageAdvisor;
    public SQLWarning warningChain;
    public boolean wasNullFlag;
    public java.sql.Statement wrapperStatement;

    static {
        int i = 0;
        if (Util.isJdbc4()) {
            try {
                String str = Util.isJdbc42() ? "com.mysql.jdbc.JDBC42ResultSet" : "com.mysql.jdbc.JDBC4ResultSet";
                Class<?> cls = Class.forName(str);
                Class<?> cls2 = Long.TYPE;
                JDBC_4_RS_4_ARG_CTOR = cls.getConstructor(cls2, cls2, MySQLConnection.class, StatementImpl.class);
                JDBC_4_RS_5_ARG_CTOR = Class.forName(str).getConstructor(String.class, Field[].class, RowData.class, MySQLConnection.class, StatementImpl.class);
                JDBC_4_UPD_RS_5_ARG_CTOR = Class.forName(Util.isJdbc42() ? "com.mysql.jdbc.JDBC42UpdatableResultSet" : "com.mysql.jdbc.JDBC4UpdatableResultSet").getConstructor(String.class, Field[].class, RowData.class, MySQLConnection.class, StatementImpl.class);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException(e2);
            } catch (SecurityException e3) {
                throw new RuntimeException(e3);
            }
        } else {
            JDBC_4_RS_4_ARG_CTOR = null;
            JDBC_4_RS_5_ARG_CTOR = null;
            JDBC_4_UPD_RS_5_ARG_CTOR = null;
        }
        MIN_DIFF_PREC = ((double) Float.parseFloat(Float.toString(Float.MIN_VALUE))) - Double.parseDouble(Float.toString(Float.MIN_VALUE));
        MAX_DIFF_PREC = ((double) Float.parseFloat(Float.toString(Float.MAX_VALUE))) - Double.parseDouble(Float.toString(Float.MAX_VALUE));
        resultCounter = 1;
        EMPTY_SPACE = new char[255];
        while (true) {
            char[] cArr = EMPTY_SPACE;
            if (i >= cArr.length) {
                return;
            }
            cArr[i] = ' ';
            i++;
        }
    }

    public ResultSetImpl(long j, long j2, MySQLConnection mySQLConnection, StatementImpl statementImpl) {
        this.catalog = null;
        this.columnLabelToIndex = null;
        this.columnToIndexCache = null;
        this.columnUsed = null;
        this.connectionId = 0L;
        this.currentRow = -1;
        this.doingUpdates = false;
        this.eventSink = null;
        this.fastDefaultCal = null;
        this.fastClientCal = null;
        this.fetchDirection = 1000;
        this.fetchSize = 0;
        this.fullColumnNameToIndex = null;
        this.columnNameToIndex = null;
        this.hasBuiltIndexMapping = false;
        this.isBinaryEncoded = false;
        this.isClosed = false;
        this.nextResultSet = null;
        this.onInsertRow = false;
        this.profileSql = false;
        this.reallyResult = false;
        this.resultSetConcurrency = 0;
        this.resultSetType = 0;
        this.serverInfo = null;
        this.thisRow = null;
        this.updateId = -1L;
        this.useStrictFloatingPoint = false;
        this.useUsageAdvisor = false;
        this.warningChain = null;
        this.wasNullFlag = false;
        this.gmtCalendar = null;
        this.useFastDateParsing = false;
        this.padCharsWithSpace = false;
        this.useFastIntParsing = true;
        this.onValidRow = false;
        this.invalidRowReason = null;
        this.updateCount = j;
        this.updateId = j2;
        this.reallyResult = false;
        this.fields = new Field[0];
        this.connection = mySQLConnection;
        this.owningStatement = statementImpl;
        this.retainOwningStatement = false;
        if (this.connection != null) {
            this.exceptionInterceptor = this.connection.getExceptionInterceptor();
            this.retainOwningStatement = this.connection.getRetainStatementAfterResultSetClose();
            this.connectionId = this.connection.getId();
            this.serverTimeZoneTz = this.connection.getServerTimezoneTZ();
            this.padCharsWithSpace = this.connection.getPadCharsWithSpace();
            this.useLegacyDatetimeCode = this.connection.getUseLegacyDatetimeCode();
        }
    }

    public static boolean arraysEqual(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2 == null;
        }
        if (bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean byteArrayToBoolean(int i) throws SQLException {
        byte[] columnValue = this.thisRow.getColumnValue(i);
        if (columnValue == null) {
            this.wasNullFlag = true;
            return false;
        }
        this.wasNullFlag = false;
        if (columnValue.length == 0) {
            return false;
        }
        byte b = columnValue[0];
        if (b == 49) {
            return true;
        }
        if (b == 48) {
            return false;
        }
        return b == -1 || b > 0;
    }

    private void checkForIntegerTruncation(int i, byte[] bArr, int i2) throws SQLException {
        if (this.jdbcCompliantTruncationForReads) {
            if (i2 == Integer.MIN_VALUE || i2 == Integer.MAX_VALUE) {
                String string = bArr == null ? this.thisRow.getString(i, this.fields[i].getEncoding(), this.connection) : null;
                long j = Long.parseLong(string == null ? StringUtils.toString(bArr) : string);
                if (j < -2147483648L || j > 2147483647L) {
                    if (string == null) {
                        string = StringUtils.toString(bArr);
                    }
                    throwRangeException(string, i + 1, 4);
                }
            }
        }
    }

    private void checkForLongTruncation(int i, byte[] bArr, long j) throws SQLException {
        if (j == Long.MIN_VALUE || j == RecyclerView.FOREVER_NS) {
            String string = bArr == null ? this.thisRow.getString(i, this.fields[i].getEncoding(), this.connection) : null;
            double d = Double.parseDouble(string == null ? StringUtils.toString(bArr) : string);
            if (d < -9.223372036854776E18d || d > 9.223372036854776E18d) {
                if (string == null) {
                    string = StringUtils.toString(bArr);
                }
                throwRangeException(string, i + 1, -5);
            }
        }
    }

    public static BigInteger convertLongToUlong(long j) {
        return new BigInteger(1, new byte[]{(byte) (j >>> 56), (byte) (j >>> 48), (byte) (j >>> 40), (byte) (j >>> 32), (byte) (j >>> 24), (byte) (j >>> 16), (byte) (j >>> 8), (byte) (255 & j)});
    }

    private String convertToZeroLiteralStringWithEmptyCheck() throws SQLException {
        if (this.connection.getEmptyStringsConvertToZero()) {
            return "0";
        }
        throw SQLError.createSQLException("Can't convert empty string ('') to numeric", SQLError.SQL_STATE_INVALID_CHARACTER_VALUE_FOR_CAST, getExceptionInterceptor());
    }

    private int convertToZeroWithEmptyCheck() throws SQLException {
        if (this.connection.getEmptyStringsConvertToZero()) {
            return 0;
        }
        throw SQLError.createSQLException("Can't convert empty string ('') to numeric", SQLError.SQL_STATE_INVALID_CHARACTER_VALUE_FOR_CAST, getExceptionInterceptor());
    }

    private String extractStringFromNativeColumn(int i, int i2) throws SQLException {
        int i3 = i - 1;
        this.wasNullFlag = false;
        if (this.thisRow.isNull(i3)) {
            this.wasNullFlag = true;
            return null;
        }
        this.wasNullFlag = false;
        return this.thisRow.getString(i3, this.fields[i3].getEncoding(), this.connection);
    }

    private final BigDecimal getBigDecimalFromString(String str, int i, int i2) throws SQLException {
        if (str == null) {
            return null;
        }
        try {
            if (str.length() != 0) {
                try {
                    try {
                        return new BigDecimal(str).setScale(i2);
                    } catch (ArithmeticException unused) {
                        throw new SQLException(Messages.getString("ResultSet.Bad_format_for_BigDecimal", new Object[]{str, Integer.valueOf(i)}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT);
                    }
                } catch (ArithmeticException unused2) {
                    return new BigDecimal(str).setScale(i2, 4);
                }
            }
            BigDecimal bigDecimal = new BigDecimal(convertToZeroLiteralStringWithEmptyCheck());
            try {
                try {
                    return bigDecimal.setScale(i2);
                } catch (ArithmeticException unused3) {
                    return bigDecimal.setScale(i2, 4);
                }
            } catch (ArithmeticException unused4) {
                throw new SQLException(Messages.getString("ResultSet.Bad_format_for_BigDecimal", new Object[]{str, Integer.valueOf(i)}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT);
            }
        } catch (NumberFormatException unused5) {
            int i3 = i - 1;
            if (this.fields[i3].getMysqlType() == 16) {
                long numericRepresentationOfSQLBitType = getNumericRepresentationOfSQLBitType(i);
                try {
                    try {
                        return new BigDecimal(numericRepresentationOfSQLBitType).setScale(i2);
                    } catch (ArithmeticException unused6) {
                        return new BigDecimal(numericRepresentationOfSQLBitType).setScale(i2, 4);
                    }
                } catch (ArithmeticException unused7) {
                    throw new SQLException(Messages.getString("ResultSet.Bad_format_for_BigDecimal", new Object[]{str, Integer.valueOf(i)}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT);
                }
            }
            if (this.fields[i3].getMysqlType() == 1 && this.connection.getTinyInt1isBit() && this.fields[i3].getLength() == 1) {
                return new BigDecimal(str.equalsIgnoreCase("true") ? 1 : 0).setScale(i2);
            }
            throw new SQLException(Messages.getString("ResultSet.Bad_format_for_BigDecimal", new Object[]{str, Integer.valueOf(i)}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT);
        }
    }

    private final boolean getBooleanFromString(String str) throws SQLException {
        if (str == null || str.length() <= 0) {
            return false;
        }
        char lowerCase = Character.toLowerCase(str.charAt(0));
        return lowerCase == 't' || lowerCase == 'y' || lowerCase == '1' || str.equals("-1");
    }

    private final byte getByteFromString(String str, int i) throws SQLException {
        int iConvertToZeroWithEmptyCheck;
        if (str != null && str.length() == 0) {
            iConvertToZeroWithEmptyCheck = convertToZeroWithEmptyCheck();
        } else {
            if (str == null) {
                return (byte) 0;
            }
            String strTrim = str.trim();
            try {
                if (strTrim.indexOf(".") != -1) {
                    double d = Double.parseDouble(strTrim);
                    if (this.jdbcCompliantTruncationForReads && (d < -128.0d || d > 127.0d)) {
                        throwRangeException(strTrim, i, -6);
                    }
                    iConvertToZeroWithEmptyCheck = (int) d;
                } else {
                    long j = Long.parseLong(strTrim);
                    if (this.jdbcCompliantTruncationForReads && (j < -128 || j > 127)) {
                        throwRangeException(String.valueOf(j), i, -6);
                    }
                    iConvertToZeroWithEmptyCheck = (int) j;
                }
            } catch (NumberFormatException unused) {
                throw SQLError.createSQLException(Messages.getString("ResultSet.Value____173") + strTrim + Messages.getString("ResultSet.___is_out_of_range_[-127,127]_174"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
        }
        return (byte) iConvertToZeroWithEmptyCheck;
    }

    private final byte[] getBytesFromString(String str) throws SQLException {
        if (str != null) {
            return StringUtils.getBytes(str, this.connection.getEncoding(), this.connection.getServerCharset(), this.connection.parserKnowsUnicode(), this.connection, getExceptionInterceptor());
        }
        return null;
    }

    private final Reader getCharacterStreamFromString(String str) throws SQLException {
        if (str != null) {
            return new StringReader(str);
        }
        return null;
    }

    private final java.sql.Clob getClobFromString(String str) throws SQLException {
        return new Clob(str, getExceptionInterceptor());
    }

    private final Date getDateFromString(String str, int i, Calendar calendar) throws SQLException {
        String strTrim;
        int i2;
        int i3;
        int i4;
        int i5;
        try {
            try {
                this.wasNullFlag = false;
                if (str == null) {
                    this.wasNullFlag = true;
                    return null;
                }
                strTrim = str.trim();
                try {
                    int iIndexOf = strTrim.indexOf(".");
                    if (iIndexOf > -1) {
                        strTrim = strTrim.substring(0, iIndexOf);
                    }
                    if (!strTrim.equals("0") && !strTrim.equals(MysqlIO.ZERO_DATE_VALUE_MARKER) && !strTrim.equals(MysqlIO.ZERO_DATETIME_VALUE_MARKER) && !strTrim.equals("00000000000000") && !strTrim.equals("0")) {
                        int i6 = i - 1;
                        if (this.fields[i6].getMysqlType() == 7) {
                            int length = strTrim.length();
                            if (length == 2) {
                                int i7 = Integer.parseInt(strTrim.substring(0, 2));
                                if (i7 <= 69) {
                                    i7 += 100;
                                }
                                return fastDateCreate(calendar, i7 + 1900, 1, 1);
                            }
                            if (length == 4) {
                                int i8 = Integer.parseInt(strTrim.substring(0, 4));
                                if (i8 <= 69) {
                                    i8 += 100;
                                }
                                return fastDateCreate(calendar, i8 + 1900, Integer.parseInt(strTrim.substring(2, 4)), 1);
                            }
                            if (length != 6) {
                                if (length != 8) {
                                    if (length != 10 && length != 12) {
                                        if (length != 14) {
                                            if (length != 19 && length != 21) {
                                                throw SQLError.createSQLException(Messages.getString("ResultSet.Bad_format_for_Date", new Object[]{strTrim, Integer.valueOf(i)}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                                            }
                                            return fastDateCreate(calendar, Integer.parseInt(strTrim.substring(0, 4)), Integer.parseInt(strTrim.substring(5, 7)), Integer.parseInt(strTrim.substring(8, 10)));
                                        }
                                    }
                                }
                                return fastDateCreate(calendar, Integer.parseInt(strTrim.substring(0, 4)), Integer.parseInt(strTrim.substring(4, 6)), Integer.parseInt(strTrim.substring(6, 8)));
                            }
                            int i9 = Integer.parseInt(strTrim.substring(0, 2));
                            if (i9 <= 69) {
                                i9 += 100;
                            }
                            return fastDateCreate(calendar, i9 + 1900, Integer.parseInt(strTrim.substring(2, 4)), Integer.parseInt(strTrim.substring(4, 6)));
                        }
                        if (this.fields[i6].getMysqlType() == 13) {
                            if (strTrim.length() == 2 || strTrim.length() == 1) {
                                int i10 = Integer.parseInt(strTrim);
                                if (i10 <= 69) {
                                    i10 += 100;
                                }
                                i5 = i10 + 1900;
                            } else {
                                i5 = Integer.parseInt(strTrim.substring(0, 4));
                            }
                            return fastDateCreate(calendar, i5, 1, 1);
                        }
                        if (this.fields[i6].getMysqlType() == 11) {
                            return fastDateCreate(calendar, 1970, 1, 1);
                        }
                        if (strTrim.length() < 10) {
                            if (strTrim.length() == 8) {
                                return fastDateCreate(calendar, 1970, 1, 1);
                            }
                            throw SQLError.createSQLException(Messages.getString("ResultSet.Bad_format_for_Date", new Object[]{strTrim, Integer.valueOf(i)}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                        }
                        if (strTrim.length() != 18) {
                            i3 = Integer.parseInt(strTrim.substring(0, 4));
                            i4 = Integer.parseInt(strTrim.substring(5, 7));
                            i2 = Integer.parseInt(strTrim.substring(8, 10));
                        } else {
                            StringTokenizer stringTokenizer = new StringTokenizer(strTrim, "- ");
                            int i11 = Integer.parseInt(stringTokenizer.nextToken());
                            int i12 = Integer.parseInt(stringTokenizer.nextToken());
                            i2 = Integer.parseInt(stringTokenizer.nextToken());
                            i3 = i11;
                            i4 = i12;
                        }
                        return fastDateCreate(calendar, i3, i4, i2);
                    }
                    if (ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_CONVERT_TO_NULL.equals(this.connection.getZeroDateTimeBehavior())) {
                        this.wasNullFlag = true;
                        return null;
                    }
                    if (!ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_EXCEPTION.equals(this.connection.getZeroDateTimeBehavior())) {
                        return fastDateCreate(calendar, 1, 1, 1);
                    }
                    throw SQLError.createSQLException("Value '" + strTrim + "' can not be represented as java.sql.Date", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                } catch (Exception e) {
                    e = e;
                    SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(Messages.getString("ResultSet.Bad_format_for_Date", new Object[]{strTrim, Integer.valueOf(i)}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                    sQLExceptionCreateSQLException.initCause(e);
                    throw sQLExceptionCreateSQLException;
                }
            } catch (Exception e2) {
                e = e2;
                strTrim = str;
            }
        } catch (SQLException e3) {
            throw e3;
        }
    }

    private TimeZone getDefaultTimeZone() {
        return this.useLegacyDatetimeCode ? this.connection.getDefaultTimeZone() : this.serverTimeZoneTz;
    }

    private final double getDoubleFromString(String str, int i) throws SQLException {
        return getDoubleInternal(str, i);
    }

    private synchronized Calendar getFastClientCalendar() {
        if (this.fastClientCal == null) {
            this.fastClientCal = new GregorianCalendar(Locale.US);
        }
        return this.fastClientCal;
    }

    private synchronized Calendar getFastDefaultCalendar() {
        if (this.fastDefaultCal == null) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(Locale.US);
            this.fastDefaultCal = gregorianCalendar;
            gregorianCalendar.setTimeZone(getDefaultTimeZone());
        }
        return this.fastDefaultCal;
    }

    private final float getFloatFromString(String str, int i) throws SQLException {
        if (str == null) {
            return 0.0f;
        }
        try {
            try {
                if (str.length() == 0) {
                    return convertToZeroWithEmptyCheck();
                }
                float f = Float.parseFloat(str);
                if (this.jdbcCompliantTruncationForReads && (f == Float.MIN_VALUE || f == Float.MAX_VALUE)) {
                    double d = Double.parseDouble(str);
                    if (d < 1.401298464324817E-45d - MIN_DIFF_PREC || d > 3.4028234663852886E38d - MAX_DIFF_PREC) {
                        throwRangeException(String.valueOf(d), i, 6);
                    }
                }
                return f;
            } catch (NumberFormatException unused) {
                Double d2 = new Double(str);
                float fFloatValue = d2.floatValue();
                boolean z = this.jdbcCompliantTruncationForReads;
                if (z && ((z && fFloatValue == Float.NEGATIVE_INFINITY) || fFloatValue == Float.POSITIVE_INFINITY)) {
                    throwRangeException(d2.toString(), i, 6);
                }
                return fFloatValue;
            }
        } catch (NumberFormatException unused2) {
            throw SQLError.createSQLException(Messages.getString("ResultSet.Invalid_value_for_getFloat()_-____200") + str + Messages.getString("ResultSet.___in_column__201") + i, SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
    }

    public static ResultSetImpl getInstance(long j, long j2, MySQLConnection mySQLConnection, StatementImpl statementImpl) throws SQLException {
        return !Util.isJdbc4() ? new ResultSetImpl(j, j2, mySQLConnection, statementImpl) : (ResultSetImpl) Util.handleNewInstance(JDBC_4_RS_4_ARG_CTOR, new Object[]{Long.valueOf(j), Long.valueOf(j2), mySQLConnection, statementImpl}, mySQLConnection.getExceptionInterceptor());
    }

    private final int getIntFromString(String str, int i) throws SQLException {
        if (str == null) {
            return 0;
        }
        try {
            try {
                if (str.length() == 0) {
                    return convertToZeroWithEmptyCheck();
                }
                if (str.indexOf("e") != -1 || str.indexOf("E") != -1 || str.indexOf(".") != -1) {
                    double d = Double.parseDouble(str);
                    if (this.jdbcCompliantTruncationForReads && (d < -2.147483648E9d || d > 2.147483647E9d)) {
                        throwRangeException(String.valueOf(d), i, 4);
                    }
                    return (int) d;
                }
                String strTrim = str.trim();
                int i2 = Integer.parseInt(strTrim);
                if (this.jdbcCompliantTruncationForReads && (i2 == Integer.MIN_VALUE || i2 == Integer.MAX_VALUE)) {
                    long j = Long.parseLong(strTrim);
                    if (j < -2147483648L || j > 2147483647L) {
                        throwRangeException(String.valueOf(j), i, 4);
                    }
                }
                return i2;
            } catch (NumberFormatException unused) {
                throw SQLError.createSQLException(Messages.getString("ResultSet.Invalid_value_for_getInt()_-____206") + str + Messages.getString("ResultSet.___in_column__207") + i, SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
        } catch (NumberFormatException unused2) {
            double d2 = Double.parseDouble(str);
            if (this.jdbcCompliantTruncationForReads && (d2 < -2.147483648E9d || d2 > 2.147483647E9d)) {
                throwRangeException(String.valueOf(d2), i, 4);
            }
            return (int) d2;
        }
    }

    private int getIntWithOverflowCheck(int i) throws SQLException {
        int i2 = this.thisRow.getInt(i);
        checkForIntegerTruncation(i, null, i2);
        return i2;
    }

    private final long getLongFromString(String str, int i) throws SQLException {
        if (str == null) {
            return 0L;
        }
        try {
            try {
                if (str.length() == 0) {
                    return convertToZeroWithEmptyCheck();
                }
                return (str.indexOf("e") == -1 && str.indexOf("E") == -1) ? parseLongWithOverflowCheck(i, null, str, true) : parseLongAsDouble(i, str);
            } catch (NumberFormatException unused) {
                return parseLongAsDouble(i, str);
            }
        } catch (NumberFormatException unused2) {
            throw SQLError.createSQLException(Messages.getString("ResultSet.Invalid_value_for_getLong()_-____211") + str + Messages.getString("ResultSet.___in_column__212") + (i + 1), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
    }

    private long getLongWithOverflowCheck(int i, boolean z) throws SQLException {
        long j = this.thisRow.getLong(i);
        if (z) {
            checkForLongTruncation(i, null, j);
        }
        return j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String getNativeConvertToString(int i, Field field) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            int sQLType = field.getSQLType();
            int mysqlType = field.getMysqlType();
            if (sQLType != 12) {
                if (sQLType == 16) {
                    boolean z = getBoolean(i);
                    if (this.wasNullFlag) {
                        return null;
                    }
                    return String.valueOf(z);
                }
                switch (sQLType) {
                    case -7:
                        return String.valueOf(getNumericRepresentationOfSQLBitType(i));
                    case -6:
                        byte nativeByte = getNativeByte(i, false);
                        if (this.wasNullFlag) {
                            return null;
                        }
                        if (field.isUnsigned() && nativeByte < 0) {
                            return String.valueOf((int) ((short) (nativeByte & StatementImpl.USES_VARIABLES_UNKNOWN)));
                        }
                        return String.valueOf((int) nativeByte);
                    case -5:
                        if (field.isUnsigned()) {
                            long nativeLong = getNativeLong(i, false, false);
                            if (this.wasNullFlag) {
                                return null;
                            }
                            return String.valueOf(convertLongToUlong(nativeLong));
                        }
                        long nativeLong2 = getNativeLong(i, false, true);
                        if (this.wasNullFlag) {
                            return null;
                        }
                        return String.valueOf(nativeLong2);
                    case -4:
                    case -3:
                    case -2:
                        if (!field.isBlob()) {
                            return extractStringFromNativeColumn(i, mysqlType);
                        }
                        if (!field.isBinary()) {
                            return extractStringFromNativeColumn(i, mysqlType);
                        }
                        byte[] bytes = getBytes(i);
                        if (!this.connection.getAutoDeserialize() || bytes == 0 || bytes.length < 2) {
                            return extractStringFromNativeColumn(i, mysqlType);
                        }
                        if (bytes[0] == -84 && bytes[1] == -19) {
                            try {
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
                                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                                Object object = objectInputStream.readObject();
                                objectInputStream.close();
                                byteArrayInputStream.close();
                                bytes = object;
                            } catch (IOException unused) {
                            } catch (ClassNotFoundException e) {
                                throw SQLError.createSQLException(Messages.getString("ResultSet.Class_not_found___91") + e.toString() + Messages.getString("ResultSet._while_reading_serialized_object_92"), getExceptionInterceptor());
                            }
                        }
                        return bytes.toString();
                    default:
                        switch (sQLType) {
                            case 1:
                                break;
                            case 2:
                            case 3:
                                String asciiString = StringUtils.toAsciiString(this.thisRow.getColumnValue(i - 1));
                                if (asciiString == null) {
                                    this.wasNullFlag = true;
                                    return null;
                                }
                                this.wasNullFlag = false;
                                if (asciiString.length() == 0) {
                                    return new BigDecimal(0).toString();
                                }
                                try {
                                    return new BigDecimal(asciiString).toString();
                                } catch (NumberFormatException unused2) {
                                    throw SQLError.createSQLException(Messages.getString("ResultSet.Bad_format_for_BigDecimal", new Object[]{asciiString, Integer.valueOf(i)}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                                }
                            case 4:
                                int nativeInt = getNativeInt(i, false);
                                if (this.wasNullFlag) {
                                    return null;
                                }
                                if (field.isUnsigned() && nativeInt < 0 && field.getMysqlType() != 9) {
                                    return String.valueOf(((long) nativeInt) & MysqlDefs.LENGTH_LONGBLOB);
                                }
                                return String.valueOf(nativeInt);
                            case 5:
                                int nativeInt2 = getNativeInt(i, false);
                                if (this.wasNullFlag) {
                                    return null;
                                }
                                if (field.isUnsigned() && nativeInt2 < 0) {
                                    return String.valueOf(nativeInt2 & Settings.DEFAULT_INITIAL_WINDOW_SIZE);
                                }
                                return String.valueOf(nativeInt2);
                            case 6:
                            case 8:
                                double nativeDouble = getNativeDouble(i);
                                if (this.wasNullFlag) {
                                    return null;
                                }
                                return String.valueOf(nativeDouble);
                            case 7:
                                float nativeFloat = getNativeFloat(i);
                                if (this.wasNullFlag) {
                                    return null;
                                }
                                return String.valueOf(nativeFloat);
                            default:
                                switch (sQLType) {
                                    case 91:
                                        if (mysqlType == 13) {
                                            short nativeShort = getNativeShort(i);
                                            if (!this.connection.getYearIsDateType()) {
                                                if (this.wasNullFlag) {
                                                    return null;
                                                }
                                                return String.valueOf((int) nativeShort);
                                            }
                                            if (field.getLength() == 2) {
                                                if (nativeShort <= 69) {
                                                    nativeShort = (short) (nativeShort + 100);
                                                }
                                                nativeShort = (short) (nativeShort + 1900);
                                            }
                                            return fastDateCreate(null, nativeShort, 1, 1).toString();
                                        }
                                        if (this.connection.getNoDatetimeStringSync()) {
                                            byte[] nativeBytes = getNativeBytes(i, true);
                                            if (nativeBytes == null) {
                                                return null;
                                            }
                                            if (nativeBytes.length == 0) {
                                                return MysqlIO.ZERO_DATE_VALUE_MARKER;
                                            }
                                            int i2 = (nativeBytes[0] & StatementImpl.USES_VARIABLES_UNKNOWN) | ((nativeBytes[1] & StatementImpl.USES_VARIABLES_UNKNOWN) << 8);
                                            byte b = nativeBytes[2];
                                            byte b2 = nativeBytes[3];
                                            if (i2 == 0 && b == 0 && b2 == 0) {
                                                return MysqlIO.ZERO_DATE_VALUE_MARKER;
                                            }
                                        }
                                        Date nativeDate = getNativeDate(i);
                                        if (nativeDate == null) {
                                            return null;
                                        }
                                        return String.valueOf(nativeDate);
                                    case 92:
                                        Time nativeTime = getNativeTime(i, null, this.connection.getDefaultTimeZone(), false);
                                        if (nativeTime == null) {
                                            return null;
                                        }
                                        return String.valueOf(nativeTime);
                                    case 93:
                                        if (this.connection.getNoDatetimeStringSync()) {
                                            byte[] nativeBytes2 = getNativeBytes(i, true);
                                            if (nativeBytes2 == null) {
                                                return null;
                                            }
                                            if (nativeBytes2.length == 0) {
                                                return MysqlIO.ZERO_DATETIME_VALUE_MARKER;
                                            }
                                            int i3 = (nativeBytes2[0] & StatementImpl.USES_VARIABLES_UNKNOWN) | ((nativeBytes2[1] & StatementImpl.USES_VARIABLES_UNKNOWN) << 8);
                                            byte b3 = nativeBytes2[2];
                                            byte b4 = nativeBytes2[3];
                                            if (i3 == 0 && b3 == 0 && b4 == 0) {
                                                return MysqlIO.ZERO_DATETIME_VALUE_MARKER;
                                            }
                                        }
                                        Timestamp nativeTimestamp = getNativeTimestamp(i, null, this.connection.getDefaultTimeZone(), false);
                                        if (nativeTimestamp == null) {
                                            return null;
                                        }
                                        String strValueOf = String.valueOf(nativeTimestamp);
                                        if (!this.connection.getNoDatetimeStringSync()) {
                                            return strValueOf;
                                        }
                                        if (strValueOf.endsWith(".0")) {
                                            return strValueOf.substring(0, strValueOf.length() - 2);
                                        }
                                        return extractStringFromNativeColumn(i, mysqlType);
                                    default:
                                        return extractStringFromNativeColumn(i, mysqlType);
                                }
                        }
                        throw th;
                    case -1:
                        return extractStringFromNativeColumn(i, mysqlType);
                }
            }
            return extractStringFromNativeColumn(i, mysqlType);
        }
    }

    private Time getNativeTime(int i, Calendar calendar, TimeZone timeZone, boolean z) throws SQLException {
        checkRowPos();
        checkColumnBounds(i);
        int i2 = i - 1;
        int mysqlType = this.fields[i2].getMysqlType();
        Time nativeTime = mysqlType == 11 ? this.thisRow.getNativeTime(i2, calendar, timeZone, z, this.connection, this) : (Time) this.thisRow.getNativeDateTimeValue(i2, null, 92, mysqlType, timeZone, z, this.connection, this);
        if (nativeTime == null) {
            this.wasNullFlag = true;
            return null;
        }
        this.wasNullFlag = false;
        return nativeTime;
    }

    private Timestamp getNativeTimestamp(int i, Calendar calendar, TimeZone timeZone, boolean z) throws SQLException {
        checkRowPos();
        checkColumnBounds(i);
        int i2 = i - 1;
        int mysqlType = this.fields[i2].getMysqlType();
        Timestamp nativeTimestamp = (mysqlType == 7 || mysqlType == 12) ? this.thisRow.getNativeTimestamp(i2, calendar, timeZone, z, this.connection, this) : (Timestamp) this.thisRow.getNativeDateTimeValue(i2, null, 93, mysqlType, timeZone, z, this.connection, this);
        if (nativeTimestamp == null) {
            this.wasNullFlag = true;
            return null;
        }
        this.wasNullFlag = false;
        return nativeTimestamp;
    }

    private long getNumericRepresentationOfSQLBitType(int i) throws SQLException {
        int i2 = i - 1;
        byte[] columnValue = this.thisRow.getColumnValue(i2);
        if (this.fields[i2].isSingleBit() || columnValue.length == 1) {
            return columnValue[0];
        }
        long[] jArr = new long[columnValue.length];
        int i3 = 0;
        for (int length = columnValue.length - 1; length >= 0; length--) {
            jArr[length] = ((long) (columnValue[length] & StatementImpl.USES_VARIABLES_UNKNOWN)) << i3;
            i3 += 8;
        }
        long j = 0;
        for (int i4 = 0; i4 < columnValue.length; i4++) {
            j |= jArr[i4];
        }
        return j;
    }

    private Object getObjectDeserializingIfNeeded(int i) throws SQLException {
        Field field = this.fields[i - 1];
        if (!field.isBinary() && !field.isBlob()) {
            return getBytes(i);
        }
        byte[] bytes = getBytes(i);
        if (!this.connection.getAutoDeserialize() || bytes == null || bytes.length < 2) {
            return bytes;
        }
        if (bytes[0] != -84 || bytes[1] != -19) {
            return getString(i);
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object object = objectInputStream.readObject();
            objectInputStream.close();
            byteArrayInputStream.close();
            return object;
        } catch (IOException unused) {
            return bytes;
        } catch (ClassNotFoundException e) {
            throw SQLError.createSQLException(Messages.getString("ResultSet.Class_not_found___91") + e.toString() + Messages.getString("ResultSet._while_reading_serialized_object_92"), getExceptionInterceptor());
        }
    }

    private final short getShortFromString(String str, int i) throws SQLException {
        if (str == null) {
            return (short) 0;
        }
        try {
            try {
                if (str.length() == 0) {
                    return (short) convertToZeroWithEmptyCheck();
                }
                return (str.indexOf("e") == -1 && str.indexOf("E") == -1 && str.indexOf(".") == -1) ? parseShortWithOverflowCheck(i, null, str) : parseShortAsDouble(i, str);
            } catch (NumberFormatException unused) {
                return parseShortAsDouble(i, str);
            }
        } catch (NumberFormatException unused2) {
            throw SQLError.createSQLException(Messages.getString("ResultSet.Invalid_value_for_getShort()_-____217") + str + Messages.getString("ResultSet.___in_column__218") + i, SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
    }

    private String getStringForClob(int i) throws SQLException {
        String clobCharacterEncoding = this.connection.getClobCharacterEncoding();
        if (clobCharacterEncoding == null) {
            return !this.isBinaryEncoded ? getString(i) : getNativeString(i);
        }
        try {
            byte[] bytes = !this.isBinaryEncoded ? getBytes(i) : getNativeBytes(i, true);
            if (bytes != null) {
                return StringUtils.toString(bytes, clobCharacterEncoding);
            }
            return null;
        } catch (UnsupportedEncodingException unused) {
            throw SQLError.createSQLException("Unsupported character encoding " + clobCharacterEncoding, SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
    }

    private Time getTimeFromString(String str, Calendar calendar, int i, TimeZone timeZone, boolean z) throws SQLException {
        int i2;
        int i3;
        synchronized (checkClosed().getConnectionMutex()) {
            try {
                if (str == null) {
                    this.wasNullFlag = true;
                    return null;
                }
                String strTrim = str.trim();
                int iIndexOf = strTrim.indexOf(".");
                int i4 = 0;
                if (iIndexOf > -1) {
                    strTrim = strTrim.substring(0, iIndexOf);
                }
                if (!strTrim.equals("0") && !strTrim.equals(MysqlIO.ZERO_DATE_VALUE_MARKER) && !strTrim.equals(MysqlIO.ZERO_DATETIME_VALUE_MARKER) && !strTrim.equals("00000000000000")) {
                    this.wasNullFlag = false;
                    int i5 = i - 1;
                    Field field = this.fields[i5];
                    if (field.getMysqlType() == 7) {
                        int length = strTrim.length();
                        if (length == 10) {
                            i2 = Integer.parseInt(strTrim.substring(6, 8));
                            i3 = Integer.parseInt(strTrim.substring(8, 10));
                        } else if (length == 12 || length == 14) {
                            int i6 = length - 4;
                            i2 = Integer.parseInt(strTrim.substring(length - 6, i6));
                            int i7 = length - 2;
                            i3 = Integer.parseInt(strTrim.substring(i6, i7));
                            i4 = Integer.parseInt(strTrim.substring(i7, length));
                        } else {
                            if (length != 19) {
                                throw SQLError.createSQLException(Messages.getString("ResultSet.Timestamp_too_small_to_convert_to_Time_value_in_column__257") + i + "(" + this.fields[i5] + ").", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                            }
                            i2 = Integer.parseInt(strTrim.substring(length - 8, length - 6));
                            i3 = Integer.parseInt(strTrim.substring(length - 5, length - 3));
                            i4 = Integer.parseInt(strTrim.substring(length - 2, length));
                        }
                        SQLWarning sQLWarning = new SQLWarning(Messages.getString("ResultSet.Precision_lost_converting_TIMESTAMP_to_Time_with_getTime()_on_column__261") + i + "(" + this.fields[i5] + ").");
                        SQLWarning sQLWarning2 = this.warningChain;
                        if (sQLWarning2 == null) {
                            this.warningChain = sQLWarning;
                        } else {
                            sQLWarning2.setNextWarning(sQLWarning);
                        }
                    } else if (field.getMysqlType() == 12) {
                        i2 = Integer.parseInt(strTrim.substring(11, 13));
                        i3 = Integer.parseInt(strTrim.substring(14, 16));
                        i4 = Integer.parseInt(strTrim.substring(17, 19));
                        SQLWarning sQLWarning3 = new SQLWarning(Messages.getString("ResultSet.Precision_lost_converting_DATETIME_to_Time_with_getTime()_on_column__264") + i + "(" + this.fields[i5] + ").");
                        SQLWarning sQLWarning4 = this.warningChain;
                        if (sQLWarning4 == null) {
                            this.warningChain = sQLWarning3;
                        } else {
                            sQLWarning4.setNextWarning(sQLWarning3);
                        }
                    } else {
                        if (field.getMysqlType() == 10) {
                            return fastTimeCreate(calendar, 0, 0, 0);
                        }
                        if (strTrim.length() != 5 && strTrim.length() != 8) {
                            throw SQLError.createSQLException(Messages.getString("ResultSet.Bad_format_for_Time____267") + strTrim + Messages.getString("ResultSet.___in_column__268") + i, SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                        }
                        i2 = Integer.parseInt(strTrim.substring(0, 2));
                        i3 = Integer.parseInt(strTrim.substring(3, 5));
                        if (strTrim.length() != 5) {
                            i4 = Integer.parseInt(strTrim.substring(6));
                        }
                    }
                    Calendar calendarInstanceForSessionOrNew = getCalendarInstanceForSessionOrNew();
                    return TimeUtil.changeTimezone(this.connection, calendarInstanceForSessionOrNew, calendar, fastTimeCreate(calendarInstanceForSessionOrNew, i2, i3, i4), this.connection.getServerTimezoneTZ(), timeZone, z);
                }
                if (ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_CONVERT_TO_NULL.equals(this.connection.getZeroDateTimeBehavior())) {
                    this.wasNullFlag = true;
                    return null;
                }
                if (!ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_EXCEPTION.equals(this.connection.getZeroDateTimeBehavior())) {
                    return fastTimeCreate(calendar, 0, 0, 0);
                }
                throw SQLError.createSQLException("Value '" + strTrim + "' can not be represented as java.sql.Time", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            } catch (RuntimeException e) {
                SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(e.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                sQLExceptionCreateSQLException.initCause(e);
                throw sQLExceptionCreateSQLException;
            }
        }
    }

    private Time getTimeInternal(int i, Calendar calendar, TimeZone timeZone, boolean z) throws SQLException {
        checkRowPos();
        if (this.isBinaryEncoded) {
            return getNativeTime(i, calendar, timeZone, z);
        }
        if (!this.useFastDateParsing) {
            return getTimeFromString(getStringInternal(i, false), calendar, i, timeZone, z);
        }
        checkColumnBounds(i);
        int i2 = i - 1;
        if (this.thisRow.isNull(i2)) {
            this.wasNullFlag = true;
            return null;
        }
        this.wasNullFlag = false;
        return this.thisRow.getTimeFast(i2, calendar, timeZone, z, this.connection, this);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0348 A[Catch: RuntimeException -> 0x039a, TryCatch #0 {RuntimeException -> 0x039a, blocks: (B:8:0x0016, B:10:0x0022, B:12:0x002d, B:14:0x0037, B:16:0x003f, B:18:0x0047, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006d, B:28:0x0070, B:30:0x007e, B:32:0x008d, B:33:0x00ab, B:34:0x00ac, B:36:0x00bb, B:38:0x00bf, B:40:0x00d4, B:42:0x00fd, B:44:0x0106, B:69:0x0156, B:70:0x0159, B:71:0x017a, B:72:0x017b, B:108:0x0364, B:110:0x0368, B:112:0x036f, B:73:0x01c1, B:74:0x01ff, B:76:0x020b, B:77:0x020d, B:78:0x0245, B:80:0x024f, B:83:0x0259, B:85:0x0265, B:86:0x0267, B:87:0x0295, B:88:0x02b5, B:90:0x02be, B:91:0x02e7, B:92:0x0304, B:94:0x0310, B:95:0x0312, B:97:0x032b, B:99:0x0337, B:100:0x0339, B:101:0x0348, B:103:0x0354, B:104:0x0356, B:46:0x010b, B:48:0x010f, B:50:0x011e, B:53:0x0132, B:54:0x0137, B:11:0x0029), top: B:120:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:103:0x0354 A[Catch: RuntimeException -> 0x039a, TryCatch #0 {RuntimeException -> 0x039a, blocks: (B:8:0x0016, B:10:0x0022, B:12:0x002d, B:14:0x0037, B:16:0x003f, B:18:0x0047, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006d, B:28:0x0070, B:30:0x007e, B:32:0x008d, B:33:0x00ab, B:34:0x00ac, B:36:0x00bb, B:38:0x00bf, B:40:0x00d4, B:42:0x00fd, B:44:0x0106, B:69:0x0156, B:70:0x0159, B:71:0x017a, B:72:0x017b, B:108:0x0364, B:110:0x0368, B:112:0x036f, B:73:0x01c1, B:74:0x01ff, B:76:0x020b, B:77:0x020d, B:78:0x0245, B:80:0x024f, B:83:0x0259, B:85:0x0265, B:86:0x0267, B:87:0x0295, B:88:0x02b5, B:90:0x02be, B:91:0x02e7, B:92:0x0304, B:94:0x0310, B:95:0x0312, B:97:0x032b, B:99:0x0337, B:100:0x0339, B:101:0x0348, B:103:0x0354, B:104:0x0356, B:46:0x010b, B:48:0x010f, B:50:0x011e, B:53:0x0132, B:54:0x0137, B:11:0x0029), top: B:120:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x0368 A[Catch: RuntimeException -> 0x039a, TryCatch #0 {RuntimeException -> 0x039a, blocks: (B:8:0x0016, B:10:0x0022, B:12:0x002d, B:14:0x0037, B:16:0x003f, B:18:0x0047, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006d, B:28:0x0070, B:30:0x007e, B:32:0x008d, B:33:0x00ab, B:34:0x00ac, B:36:0x00bb, B:38:0x00bf, B:40:0x00d4, B:42:0x00fd, B:44:0x0106, B:69:0x0156, B:70:0x0159, B:71:0x017a, B:72:0x017b, B:108:0x0364, B:110:0x0368, B:112:0x036f, B:73:0x01c1, B:74:0x01ff, B:76:0x020b, B:77:0x020d, B:78:0x0245, B:80:0x024f, B:83:0x0259, B:85:0x0265, B:86:0x0267, B:87:0x0295, B:88:0x02b5, B:90:0x02be, B:91:0x02e7, B:92:0x0304, B:94:0x0310, B:95:0x0312, B:97:0x032b, B:99:0x0337, B:100:0x0339, B:101:0x0348, B:103:0x0354, B:104:0x0356, B:46:0x010b, B:48:0x010f, B:50:0x011e, B:53:0x0132, B:54:0x0137, B:11:0x0029), top: B:120:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x036f A[Catch: RuntimeException -> 0x039a, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x039a, blocks: (B:8:0x0016, B:10:0x0022, B:12:0x002d, B:14:0x0037, B:16:0x003f, B:18:0x0047, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006d, B:28:0x0070, B:30:0x007e, B:32:0x008d, B:33:0x00ab, B:34:0x00ac, B:36:0x00bb, B:38:0x00bf, B:40:0x00d4, B:42:0x00fd, B:44:0x0106, B:69:0x0156, B:70:0x0159, B:71:0x017a, B:72:0x017b, B:108:0x0364, B:110:0x0368, B:112:0x036f, B:73:0x01c1, B:74:0x01ff, B:76:0x020b, B:77:0x020d, B:78:0x0245, B:80:0x024f, B:83:0x0259, B:85:0x0265, B:86:0x0267, B:87:0x0295, B:88:0x02b5, B:90:0x02be, B:91:0x02e7, B:92:0x0304, B:94:0x0310, B:95:0x0312, B:97:0x032b, B:99:0x0337, B:100:0x0339, B:101:0x0348, B:103:0x0354, B:104:0x0356, B:46:0x010b, B:48:0x010f, B:50:0x011e, B:53:0x0132, B:54:0x0137, B:11:0x0029), top: B:120:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x013f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x0141  */
    /* JADX WARN: Code duplicated, block: B:61:0x0144  */
    /* JADX WARN: Code duplicated, block: B:63:0x0149  */
    /* JADX WARN: Code duplicated, block: B:65:0x014e  */
    /* JADX WARN: Code duplicated, block: B:67:0x0152  */
    /* JADX WARN: Code duplicated, block: B:69:0x0156 A[Catch: RuntimeException -> 0x039a, TryCatch #0 {RuntimeException -> 0x039a, blocks: (B:8:0x0016, B:10:0x0022, B:12:0x002d, B:14:0x0037, B:16:0x003f, B:18:0x0047, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006d, B:28:0x0070, B:30:0x007e, B:32:0x008d, B:33:0x00ab, B:34:0x00ac, B:36:0x00bb, B:38:0x00bf, B:40:0x00d4, B:42:0x00fd, B:44:0x0106, B:69:0x0156, B:70:0x0159, B:71:0x017a, B:72:0x017b, B:108:0x0364, B:110:0x0368, B:112:0x036f, B:73:0x01c1, B:74:0x01ff, B:76:0x020b, B:77:0x020d, B:78:0x0245, B:80:0x024f, B:83:0x0259, B:85:0x0265, B:86:0x0267, B:87:0x0295, B:88:0x02b5, B:90:0x02be, B:91:0x02e7, B:92:0x0304, B:94:0x0310, B:95:0x0312, B:97:0x032b, B:99:0x0337, B:100:0x0339, B:101:0x0348, B:103:0x0354, B:104:0x0356, B:46:0x010b, B:48:0x010f, B:50:0x011e, B:53:0x0132, B:54:0x0137, B:11:0x0029), top: B:120:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0159 A[Catch: RuntimeException -> 0x039a, TryCatch #0 {RuntimeException -> 0x039a, blocks: (B:8:0x0016, B:10:0x0022, B:12:0x002d, B:14:0x0037, B:16:0x003f, B:18:0x0047, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006d, B:28:0x0070, B:30:0x007e, B:32:0x008d, B:33:0x00ab, B:34:0x00ac, B:36:0x00bb, B:38:0x00bf, B:40:0x00d4, B:42:0x00fd, B:44:0x0106, B:69:0x0156, B:70:0x0159, B:71:0x017a, B:72:0x017b, B:108:0x0364, B:110:0x0368, B:112:0x036f, B:73:0x01c1, B:74:0x01ff, B:76:0x020b, B:77:0x020d, B:78:0x0245, B:80:0x024f, B:83:0x0259, B:85:0x0265, B:86:0x0267, B:87:0x0295, B:88:0x02b5, B:90:0x02be, B:91:0x02e7, B:92:0x0304, B:94:0x0310, B:95:0x0312, B:97:0x032b, B:99:0x0337, B:100:0x0339, B:101:0x0348, B:103:0x0354, B:104:0x0356, B:46:0x010b, B:48:0x010f, B:50:0x011e, B:53:0x0132, B:54:0x0137, B:11:0x0029), top: B:120:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x017b A[Catch: RuntimeException -> 0x039a, TryCatch #0 {RuntimeException -> 0x039a, blocks: (B:8:0x0016, B:10:0x0022, B:12:0x002d, B:14:0x0037, B:16:0x003f, B:18:0x0047, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006d, B:28:0x0070, B:30:0x007e, B:32:0x008d, B:33:0x00ab, B:34:0x00ac, B:36:0x00bb, B:38:0x00bf, B:40:0x00d4, B:42:0x00fd, B:44:0x0106, B:69:0x0156, B:70:0x0159, B:71:0x017a, B:72:0x017b, B:108:0x0364, B:110:0x0368, B:112:0x036f, B:73:0x01c1, B:74:0x01ff, B:76:0x020b, B:77:0x020d, B:78:0x0245, B:80:0x024f, B:83:0x0259, B:85:0x0265, B:86:0x0267, B:87:0x0295, B:88:0x02b5, B:90:0x02be, B:91:0x02e7, B:92:0x0304, B:94:0x0310, B:95:0x0312, B:97:0x032b, B:99:0x0337, B:100:0x0339, B:101:0x0348, B:103:0x0354, B:104:0x0356, B:46:0x010b, B:48:0x010f, B:50:0x011e, B:53:0x0132, B:54:0x0137, B:11:0x0029), top: B:120:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x01c1 A[Catch: RuntimeException -> 0x039a, TryCatch #0 {RuntimeException -> 0x039a, blocks: (B:8:0x0016, B:10:0x0022, B:12:0x002d, B:14:0x0037, B:16:0x003f, B:18:0x0047, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006d, B:28:0x0070, B:30:0x007e, B:32:0x008d, B:33:0x00ab, B:34:0x00ac, B:36:0x00bb, B:38:0x00bf, B:40:0x00d4, B:42:0x00fd, B:44:0x0106, B:69:0x0156, B:70:0x0159, B:71:0x017a, B:72:0x017b, B:108:0x0364, B:110:0x0368, B:112:0x036f, B:73:0x01c1, B:74:0x01ff, B:76:0x020b, B:77:0x020d, B:78:0x0245, B:80:0x024f, B:83:0x0259, B:85:0x0265, B:86:0x0267, B:87:0x0295, B:88:0x02b5, B:90:0x02be, B:91:0x02e7, B:92:0x0304, B:94:0x0310, B:95:0x0312, B:97:0x032b, B:99:0x0337, B:100:0x0339, B:101:0x0348, B:103:0x0354, B:104:0x0356, B:46:0x010b, B:48:0x010f, B:50:0x011e, B:53:0x0132, B:54:0x0137, B:11:0x0029), top: B:120:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x01ff A[Catch: RuntimeException -> 0x039a, TryCatch #0 {RuntimeException -> 0x039a, blocks: (B:8:0x0016, B:10:0x0022, B:12:0x002d, B:14:0x0037, B:16:0x003f, B:18:0x0047, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006d, B:28:0x0070, B:30:0x007e, B:32:0x008d, B:33:0x00ab, B:34:0x00ac, B:36:0x00bb, B:38:0x00bf, B:40:0x00d4, B:42:0x00fd, B:44:0x0106, B:69:0x0156, B:70:0x0159, B:71:0x017a, B:72:0x017b, B:108:0x0364, B:110:0x0368, B:112:0x036f, B:73:0x01c1, B:74:0x01ff, B:76:0x020b, B:77:0x020d, B:78:0x0245, B:80:0x024f, B:83:0x0259, B:85:0x0265, B:86:0x0267, B:87:0x0295, B:88:0x02b5, B:90:0x02be, B:91:0x02e7, B:92:0x0304, B:94:0x0310, B:95:0x0312, B:97:0x032b, B:99:0x0337, B:100:0x0339, B:101:0x0348, B:103:0x0354, B:104:0x0356, B:46:0x010b, B:48:0x010f, B:50:0x011e, B:53:0x0132, B:54:0x0137, B:11:0x0029), top: B:120:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x020b A[Catch: RuntimeException -> 0x039a, TryCatch #0 {RuntimeException -> 0x039a, blocks: (B:8:0x0016, B:10:0x0022, B:12:0x002d, B:14:0x0037, B:16:0x003f, B:18:0x0047, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006d, B:28:0x0070, B:30:0x007e, B:32:0x008d, B:33:0x00ab, B:34:0x00ac, B:36:0x00bb, B:38:0x00bf, B:40:0x00d4, B:42:0x00fd, B:44:0x0106, B:69:0x0156, B:70:0x0159, B:71:0x017a, B:72:0x017b, B:108:0x0364, B:110:0x0368, B:112:0x036f, B:73:0x01c1, B:74:0x01ff, B:76:0x020b, B:77:0x020d, B:78:0x0245, B:80:0x024f, B:83:0x0259, B:85:0x0265, B:86:0x0267, B:87:0x0295, B:88:0x02b5, B:90:0x02be, B:91:0x02e7, B:92:0x0304, B:94:0x0310, B:95:0x0312, B:97:0x032b, B:99:0x0337, B:100:0x0339, B:101:0x0348, B:103:0x0354, B:104:0x0356, B:46:0x010b, B:48:0x010f, B:50:0x011e, B:53:0x0132, B:54:0x0137, B:11:0x0029), top: B:120:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0245 A[Catch: RuntimeException -> 0x039a, TryCatch #0 {RuntimeException -> 0x039a, blocks: (B:8:0x0016, B:10:0x0022, B:12:0x002d, B:14:0x0037, B:16:0x003f, B:18:0x0047, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006d, B:28:0x0070, B:30:0x007e, B:32:0x008d, B:33:0x00ab, B:34:0x00ac, B:36:0x00bb, B:38:0x00bf, B:40:0x00d4, B:42:0x00fd, B:44:0x0106, B:69:0x0156, B:70:0x0159, B:71:0x017a, B:72:0x017b, B:108:0x0364, B:110:0x0368, B:112:0x036f, B:73:0x01c1, B:74:0x01ff, B:76:0x020b, B:77:0x020d, B:78:0x0245, B:80:0x024f, B:83:0x0259, B:85:0x0265, B:86:0x0267, B:87:0x0295, B:88:0x02b5, B:90:0x02be, B:91:0x02e7, B:92:0x0304, B:94:0x0310, B:95:0x0312, B:97:0x032b, B:99:0x0337, B:100:0x0339, B:101:0x0348, B:103:0x0354, B:104:0x0356, B:46:0x010b, B:48:0x010f, B:50:0x011e, B:53:0x0132, B:54:0x0137, B:11:0x0029), top: B:120:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x02b5 A[Catch: RuntimeException -> 0x039a, TryCatch #0 {RuntimeException -> 0x039a, blocks: (B:8:0x0016, B:10:0x0022, B:12:0x002d, B:14:0x0037, B:16:0x003f, B:18:0x0047, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006d, B:28:0x0070, B:30:0x007e, B:32:0x008d, B:33:0x00ab, B:34:0x00ac, B:36:0x00bb, B:38:0x00bf, B:40:0x00d4, B:42:0x00fd, B:44:0x0106, B:69:0x0156, B:70:0x0159, B:71:0x017a, B:72:0x017b, B:108:0x0364, B:110:0x0368, B:112:0x036f, B:73:0x01c1, B:74:0x01ff, B:76:0x020b, B:77:0x020d, B:78:0x0245, B:80:0x024f, B:83:0x0259, B:85:0x0265, B:86:0x0267, B:87:0x0295, B:88:0x02b5, B:90:0x02be, B:91:0x02e7, B:92:0x0304, B:94:0x0310, B:95:0x0312, B:97:0x032b, B:99:0x0337, B:100:0x0339, B:101:0x0348, B:103:0x0354, B:104:0x0356, B:46:0x010b, B:48:0x010f, B:50:0x011e, B:53:0x0132, B:54:0x0137, B:11:0x0029), top: B:120:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x02be A[Catch: RuntimeException -> 0x039a, TryCatch #0 {RuntimeException -> 0x039a, blocks: (B:8:0x0016, B:10:0x0022, B:12:0x002d, B:14:0x0037, B:16:0x003f, B:18:0x0047, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006d, B:28:0x0070, B:30:0x007e, B:32:0x008d, B:33:0x00ab, B:34:0x00ac, B:36:0x00bb, B:38:0x00bf, B:40:0x00d4, B:42:0x00fd, B:44:0x0106, B:69:0x0156, B:70:0x0159, B:71:0x017a, B:72:0x017b, B:108:0x0364, B:110:0x0368, B:112:0x036f, B:73:0x01c1, B:74:0x01ff, B:76:0x020b, B:77:0x020d, B:78:0x0245, B:80:0x024f, B:83:0x0259, B:85:0x0265, B:86:0x0267, B:87:0x0295, B:88:0x02b5, B:90:0x02be, B:91:0x02e7, B:92:0x0304, B:94:0x0310, B:95:0x0312, B:97:0x032b, B:99:0x0337, B:100:0x0339, B:101:0x0348, B:103:0x0354, B:104:0x0356, B:46:0x010b, B:48:0x010f, B:50:0x011e, B:53:0x0132, B:54:0x0137, B:11:0x0029), top: B:120:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x02e7 A[Catch: RuntimeException -> 0x039a, TryCatch #0 {RuntimeException -> 0x039a, blocks: (B:8:0x0016, B:10:0x0022, B:12:0x002d, B:14:0x0037, B:16:0x003f, B:18:0x0047, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006d, B:28:0x0070, B:30:0x007e, B:32:0x008d, B:33:0x00ab, B:34:0x00ac, B:36:0x00bb, B:38:0x00bf, B:40:0x00d4, B:42:0x00fd, B:44:0x0106, B:69:0x0156, B:70:0x0159, B:71:0x017a, B:72:0x017b, B:108:0x0364, B:110:0x0368, B:112:0x036f, B:73:0x01c1, B:74:0x01ff, B:76:0x020b, B:77:0x020d, B:78:0x0245, B:80:0x024f, B:83:0x0259, B:85:0x0265, B:86:0x0267, B:87:0x0295, B:88:0x02b5, B:90:0x02be, B:91:0x02e7, B:92:0x0304, B:94:0x0310, B:95:0x0312, B:97:0x032b, B:99:0x0337, B:100:0x0339, B:101:0x0348, B:103:0x0354, B:104:0x0356, B:46:0x010b, B:48:0x010f, B:50:0x011e, B:53:0x0132, B:54:0x0137, B:11:0x0029), top: B:120:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x0304 A[Catch: RuntimeException -> 0x039a, TryCatch #0 {RuntimeException -> 0x039a, blocks: (B:8:0x0016, B:10:0x0022, B:12:0x002d, B:14:0x0037, B:16:0x003f, B:18:0x0047, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006d, B:28:0x0070, B:30:0x007e, B:32:0x008d, B:33:0x00ab, B:34:0x00ac, B:36:0x00bb, B:38:0x00bf, B:40:0x00d4, B:42:0x00fd, B:44:0x0106, B:69:0x0156, B:70:0x0159, B:71:0x017a, B:72:0x017b, B:108:0x0364, B:110:0x0368, B:112:0x036f, B:73:0x01c1, B:74:0x01ff, B:76:0x020b, B:77:0x020d, B:78:0x0245, B:80:0x024f, B:83:0x0259, B:85:0x0265, B:86:0x0267, B:87:0x0295, B:88:0x02b5, B:90:0x02be, B:91:0x02e7, B:92:0x0304, B:94:0x0310, B:95:0x0312, B:97:0x032b, B:99:0x0337, B:100:0x0339, B:101:0x0348, B:103:0x0354, B:104:0x0356, B:46:0x010b, B:48:0x010f, B:50:0x011e, B:53:0x0132, B:54:0x0137, B:11:0x0029), top: B:120:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0310 A[Catch: RuntimeException -> 0x039a, TryCatch #0 {RuntimeException -> 0x039a, blocks: (B:8:0x0016, B:10:0x0022, B:12:0x002d, B:14:0x0037, B:16:0x003f, B:18:0x0047, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006d, B:28:0x0070, B:30:0x007e, B:32:0x008d, B:33:0x00ab, B:34:0x00ac, B:36:0x00bb, B:38:0x00bf, B:40:0x00d4, B:42:0x00fd, B:44:0x0106, B:69:0x0156, B:70:0x0159, B:71:0x017a, B:72:0x017b, B:108:0x0364, B:110:0x0368, B:112:0x036f, B:73:0x01c1, B:74:0x01ff, B:76:0x020b, B:77:0x020d, B:78:0x0245, B:80:0x024f, B:83:0x0259, B:85:0x0265, B:86:0x0267, B:87:0x0295, B:88:0x02b5, B:90:0x02be, B:91:0x02e7, B:92:0x0304, B:94:0x0310, B:95:0x0312, B:97:0x032b, B:99:0x0337, B:100:0x0339, B:101:0x0348, B:103:0x0354, B:104:0x0356, B:46:0x010b, B:48:0x010f, B:50:0x011e, B:53:0x0132, B:54:0x0137, B:11:0x0029), top: B:120:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x032b A[Catch: RuntimeException -> 0x039a, TryCatch #0 {RuntimeException -> 0x039a, blocks: (B:8:0x0016, B:10:0x0022, B:12:0x002d, B:14:0x0037, B:16:0x003f, B:18:0x0047, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006d, B:28:0x0070, B:30:0x007e, B:32:0x008d, B:33:0x00ab, B:34:0x00ac, B:36:0x00bb, B:38:0x00bf, B:40:0x00d4, B:42:0x00fd, B:44:0x0106, B:69:0x0156, B:70:0x0159, B:71:0x017a, B:72:0x017b, B:108:0x0364, B:110:0x0368, B:112:0x036f, B:73:0x01c1, B:74:0x01ff, B:76:0x020b, B:77:0x020d, B:78:0x0245, B:80:0x024f, B:83:0x0259, B:85:0x0265, B:86:0x0267, B:87:0x0295, B:88:0x02b5, B:90:0x02be, B:91:0x02e7, B:92:0x0304, B:94:0x0310, B:95:0x0312, B:97:0x032b, B:99:0x0337, B:100:0x0339, B:101:0x0348, B:103:0x0354, B:104:0x0356, B:46:0x010b, B:48:0x010f, B:50:0x011e, B:53:0x0132, B:54:0x0137, B:11:0x0029), top: B:120:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x0337 A[Catch: RuntimeException -> 0x039a, TryCatch #0 {RuntimeException -> 0x039a, blocks: (B:8:0x0016, B:10:0x0022, B:12:0x002d, B:14:0x0037, B:16:0x003f, B:18:0x0047, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006d, B:28:0x0070, B:30:0x007e, B:32:0x008d, B:33:0x00ab, B:34:0x00ac, B:36:0x00bb, B:38:0x00bf, B:40:0x00d4, B:42:0x00fd, B:44:0x0106, B:69:0x0156, B:70:0x0159, B:71:0x017a, B:72:0x017b, B:108:0x0364, B:110:0x0368, B:112:0x036f, B:73:0x01c1, B:74:0x01ff, B:76:0x020b, B:77:0x020d, B:78:0x0245, B:80:0x024f, B:83:0x0259, B:85:0x0265, B:86:0x0267, B:87:0x0295, B:88:0x02b5, B:90:0x02be, B:91:0x02e7, B:92:0x0304, B:94:0x0310, B:95:0x0312, B:97:0x032b, B:99:0x0337, B:100:0x0339, B:101:0x0348, B:103:0x0354, B:104:0x0356, B:46:0x010b, B:48:0x010f, B:50:0x011e, B:53:0x0132, B:54:0x0137, B:11:0x0029), top: B:120:0x0016 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:70:0x0159, please report this as an issue */
    private Timestamp getTimestampFromString(int i, Calendar calendar, String str, TimeZone timeZone, boolean z) throws SQLException {
        String strTrim;
        int i2;
        int i3;
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
        int i15;
        try {
            this.wasNullFlag = false;
            if (str == null) {
                this.wasNullFlag = true;
                return null;
            }
            strTrim = str.trim();
            try {
                int length = strTrim.length();
                Calendar utcCalendar = this.connection.getUseJDBCCompliantTimezoneShift() ? this.connection.getUtcCalendar() : getCalendarInstanceForSessionOrNew();
                boolean useGmtMillisForDatetimes = this.connection.getUseGmtMillisForDatetimes();
                if (length > 0 && strTrim.charAt(0) == '0' && (strTrim.equals(MysqlIO.ZERO_DATE_VALUE_MARKER) || strTrim.equals(MysqlIO.ZERO_DATETIME_VALUE_MARKER) || strTrim.equals("00000000000000") || strTrim.equals("0"))) {
                    if (ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_CONVERT_TO_NULL.equals(this.connection.getZeroDateTimeBehavior())) {
                        this.wasNullFlag = true;
                        return null;
                    }
                    if (!ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_EXCEPTION.equals(this.connection.getZeroDateTimeBehavior())) {
                        return fastTimestampCreate(null, 1, 1, 1, 0, 0, 0, 0, useGmtMillisForDatetimes);
                    }
                    throw SQLError.createSQLException("Value '" + strTrim + "' can not be represented as java.sql.Timestamp", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                }
                int i16 = i - 1;
                if (this.fields[i16].getMysqlType() == 13) {
                    return !this.useLegacyDatetimeCode ? TimeUtil.fastTimestampCreate(timeZone, Integer.parseInt(strTrim.substring(0, 4)), 1, 1, 0, 0, 0, 0) : TimeUtil.changeTimezone(this.connection, utcCalendar, calendar, fastTimestampCreate(utcCalendar, Integer.parseInt(strTrim.substring(0, 4)), 1, 1, 0, 0, 0, 0, useGmtMillisForDatetimes), this.connection.getServerTimezoneTZ(), timeZone, z);
                }
                int iIndexOf = strTrim.indexOf(".");
                if (iIndexOf != length - 1) {
                    if (iIndexOf != -1) {
                        if (iIndexOf + 2 > length) {
                            throw new IllegalArgumentException();
                        }
                        int i17 = iIndexOf + 1;
                        int iPow = Integer.parseInt(strTrim.substring(i17));
                        int i18 = length - i17;
                        if (i18 < 9) {
                            iPow *= (int) Math.pow(10.0d, 9 - i18);
                        }
                        length = iIndexOf;
                        i2 = iPow;
                    }
                    if (length != 2) {
                        if (length != 4) {
                            if (length != 6) {
                                i11 = Integer.parseInt(strTrim.substring(0, 2));
                                if (i11 <= 69) {
                                    i11 += 100;
                                }
                                i12 = i11 + 1900;
                                i13 = Integer.parseInt(strTrim.substring(2, 4));
                                i14 = Integer.parseInt(strTrim.substring(4, 6));
                            } else if (length != 8) {
                                if (length != 10) {
                                    if (this.fields[i16].getMysqlType() == 10 && strTrim.indexOf("-") == -1) {
                                        int i19 = Integer.parseInt(strTrim.substring(0, 2));
                                        if (i19 <= 69) {
                                            i19 += 100;
                                        }
                                        int i20 = Integer.parseInt(strTrim.substring(2, 4));
                                        int i21 = Integer.parseInt(strTrim.substring(4, 6));
                                        int i22 = Integer.parseInt(strTrim.substring(6, 8));
                                        i4 = i19 + 1900;
                                        i8 = Integer.parseInt(strTrim.substring(8, 10));
                                        i5 = i20;
                                        i6 = i21;
                                        i7 = i22;
                                    } else {
                                        int i23 = Integer.parseInt(strTrim.substring(0, 4));
                                        int i24 = Integer.parseInt(strTrim.substring(5, 7));
                                        i4 = i23;
                                        i6 = Integer.parseInt(strTrim.substring(8, 10));
                                        i5 = i24;
                                        i7 = 0;
                                        i8 = 0;
                                    }
                                    i9 = 0;
                                } else if (length != 12) {
                                    i15 = Integer.parseInt(strTrim.substring(0, 2));
                                    if (i15 <= 69) {
                                        i15 += 100;
                                    }
                                    int i25 = Integer.parseInt(strTrim.substring(2, 4));
                                    int i26 = Integer.parseInt(strTrim.substring(4, 6));
                                    int i27 = Integer.parseInt(strTrim.substring(6, 8));
                                    int i28 = Integer.parseInt(strTrim.substring(8, 10));
                                    i4 = i15 + 1900;
                                    i5 = i25;
                                    i9 = Integer.parseInt(strTrim.substring(10, 12));
                                    i6 = i26;
                                    i7 = i27;
                                    i8 = i28;
                                } else if (length != 14) {
                                    switch (length) {
                                        case 19:
                                        case 20:
                                        case 21:
                                        case 22:
                                        case 23:
                                        case 24:
                                        case 25:
                                        case 26:
                                            int i29 = Integer.parseInt(strTrim.substring(0, 4));
                                            int i30 = Integer.parseInt(strTrim.substring(5, 7));
                                            int i31 = Integer.parseInt(strTrim.substring(8, 10));
                                            int i32 = Integer.parseInt(strTrim.substring(11, 13));
                                            i4 = i29;
                                            i5 = i30;
                                            i6 = i31;
                                            i8 = Integer.parseInt(strTrim.substring(14, 16));
                                            i7 = i32;
                                            i9 = Integer.parseInt(strTrim.substring(17, 19));
                                            break;
                                        default:
                                            throw new SQLException("Bad format for Timestamp '" + strTrim + "' in column " + i + ".", SQLError.SQL_STATE_ILLEGAL_ARGUMENT);
                                    }
                                } else {
                                    int i33 = Integer.parseInt(strTrim.substring(0, 4));
                                    int i34 = Integer.parseInt(strTrim.substring(4, 6));
                                    int i35 = Integer.parseInt(strTrim.substring(6, 8));
                                    int i36 = Integer.parseInt(strTrim.substring(8, 10));
                                    i4 = i33;
                                    i5 = i34;
                                    i8 = Integer.parseInt(strTrim.substring(10, 12));
                                    i9 = Integer.parseInt(strTrim.substring(12, 14));
                                    i6 = i35;
                                    i7 = i36;
                                }
                            } else if (strTrim.indexOf(":") != -1) {
                                i7 = Integer.parseInt(strTrim.substring(0, 2));
                                i8 = Integer.parseInt(strTrim.substring(3, 5));
                                i9 = Integer.parseInt(strTrim.substring(6, 8));
                                i4 = 1970;
                                i5 = 1;
                                i6 = 1;
                            } else {
                                int i37 = Integer.parseInt(strTrim.substring(0, 4));
                                int i38 = Integer.parseInt(strTrim.substring(4, 6));
                                i14 = Integer.parseInt(strTrim.substring(6, 8));
                                i12 = i37 - 1900;
                                i13 = i38 - 1;
                            }
                            i4 = i12;
                            i5 = i13;
                            i6 = i14;
                            i7 = 0;
                            i8 = 0;
                            i9 = 0;
                        } else {
                            i10 = Integer.parseInt(strTrim.substring(0, 2));
                            if (i10 <= 69) {
                                i10 += 100;
                            }
                            i4 = i10 + 1900;
                            i5 = Integer.parseInt(strTrim.substring(2, 4));
                        }
                        return !this.useLegacyDatetimeCode ? TimeUtil.fastTimestampCreate(timeZone, i4, i5, i6, i7, i8, i9, i2) : TimeUtil.changeTimezone(this.connection, utcCalendar, calendar, fastTimestampCreate(utcCalendar, i4, i5, i6, i7, i8, i9, i2, useGmtMillisForDatetimes), this.connection.getServerTimezoneTZ(), timeZone, z);
                    }
                    i3 = Integer.parseInt(strTrim.substring(0, 2));
                    if (i3 <= 69) {
                        i3 += 100;
                    }
                    i4 = i3 + 1900;
                    i5 = 1;
                    i6 = 1;
                    i7 = 0;
                    i8 = 0;
                    i9 = 0;
                    if (!this.useLegacyDatetimeCode) {
                    }
                }
                length--;
                useGmtMillisForDatetimes = useGmtMillisForDatetimes;
                i2 = 0;
                if (length != 2) {
                    if (length != 4) {
                        if (length != 6) {
                            i11 = Integer.parseInt(strTrim.substring(0, 2));
                            if (i11 <= 69) {
                                i11 += 100;
                            }
                            i12 = i11 + 1900;
                            i13 = Integer.parseInt(strTrim.substring(2, 4));
                            i14 = Integer.parseInt(strTrim.substring(4, 6));
                        } else if (length != 8) {
                            if (length != 10) {
                                if (this.fields[i16].getMysqlType() == 10) {
                                }
                                int i210 = Integer.parseInt(strTrim.substring(0, 4));
                                int i211 = Integer.parseInt(strTrim.substring(5, 7));
                                i4 = i210;
                                i6 = Integer.parseInt(strTrim.substring(8, 10));
                                i5 = i211;
                                i7 = 0;
                                i8 = 0;
                                i9 = 0;
                            } else if (length != 12) {
                                i15 = Integer.parseInt(strTrim.substring(0, 2));
                                if (i15 <= 69) {
                                    i15 += 100;
                                }
                                int i212 = Integer.parseInt(strTrim.substring(2, 4));
                                int i213 = Integer.parseInt(strTrim.substring(4, 6));
                                int i214 = Integer.parseInt(strTrim.substring(6, 8));
                                int i215 = Integer.parseInt(strTrim.substring(8, 10));
                                i4 = i15 + 1900;
                                i5 = i212;
                                i9 = Integer.parseInt(strTrim.substring(10, 12));
                                i6 = i213;
                                i7 = i214;
                                i8 = i215;
                            } else if (length != 14) {
                                switch (length) {
                                    case 19:
                                    case 20:
                                    case 21:
                                    case 22:
                                    case 23:
                                    case 24:
                                    case 25:
                                    case 26:
                                        int i216 = Integer.parseInt(strTrim.substring(0, 4));
                                        int i39 = Integer.parseInt(strTrim.substring(5, 7));
                                        int i310 = Integer.parseInt(strTrim.substring(8, 10));
                                        int i311 = Integer.parseInt(strTrim.substring(11, 13));
                                        i4 = i216;
                                        i5 = i39;
                                        i6 = i310;
                                        i8 = Integer.parseInt(strTrim.substring(14, 16));
                                        i7 = i311;
                                        i9 = Integer.parseInt(strTrim.substring(17, 19));
                                        break;
                                    default:
                                        throw new SQLException("Bad format for Timestamp '" + strTrim + "' in column " + i + ".", SQLError.SQL_STATE_ILLEGAL_ARGUMENT);
                                }
                            } else {
                                int i312 = Integer.parseInt(strTrim.substring(0, 4));
                                int i313 = Integer.parseInt(strTrim.substring(4, 6));
                                int i314 = Integer.parseInt(strTrim.substring(6, 8));
                                int i315 = Integer.parseInt(strTrim.substring(8, 10));
                                i4 = i312;
                                i5 = i313;
                                i8 = Integer.parseInt(strTrim.substring(10, 12));
                                i9 = Integer.parseInt(strTrim.substring(12, 14));
                                i6 = i314;
                                i7 = i315;
                            }
                        } else if (strTrim.indexOf(":") != -1) {
                            i7 = Integer.parseInt(strTrim.substring(0, 2));
                            i8 = Integer.parseInt(strTrim.substring(3, 5));
                            i9 = Integer.parseInt(strTrim.substring(6, 8));
                            i4 = 1970;
                            i5 = 1;
                            i6 = 1;
                        } else {
                            int i316 = Integer.parseInt(strTrim.substring(0, 4));
                            int i317 = Integer.parseInt(strTrim.substring(4, 6));
                            i14 = Integer.parseInt(strTrim.substring(6, 8));
                            i12 = i316 - 1900;
                            i13 = i317 - 1;
                        }
                        i4 = i12;
                        i5 = i13;
                        i6 = i14;
                        i7 = 0;
                        i8 = 0;
                        i9 = 0;
                    } else {
                        i10 = Integer.parseInt(strTrim.substring(0, 2));
                        if (i10 <= 69) {
                            i10 += 100;
                        }
                        i4 = i10 + 1900;
                        i5 = Integer.parseInt(strTrim.substring(2, 4));
                    }
                    if (!this.useLegacyDatetimeCode) {
                    }
                }
                i3 = Integer.parseInt(strTrim.substring(0, 2));
                if (i3 <= 69) {
                    i3 += 100;
                }
                i4 = i3 + 1900;
                i5 = 1;
                i6 = 1;
                i7 = 0;
                i8 = 0;
                i9 = 0;
                if (!this.useLegacyDatetimeCode) {
                }
            } catch (RuntimeException e) {
                e = e;
                SQLException sQLExceptionCreateSQLException = SQLError.createSQLException("Cannot convert value '" + strTrim + "' from column " + i + " to TIMESTAMP.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                sQLExceptionCreateSQLException.initCause(e);
                throw sQLExceptionCreateSQLException;
            }
        } catch (RuntimeException e2) {
            e = e2;
            strTrim = str;
        }
    }

    private Timestamp getTimestampInternal(int i, Calendar calendar, TimeZone timeZone, boolean z) throws SQLException {
        Timestamp timestampFast;
        if (this.isBinaryEncoded) {
            return getNativeTimestamp(i, calendar, timeZone, z);
        }
        if (this.useFastDateParsing) {
            checkClosed();
            checkRowPos();
            checkColumnBounds(i);
            timestampFast = this.thisRow.getTimestampFast(i - 1, calendar, timeZone, z, this.connection, this, this.connection.getUseGmtMillisForDatetimes(), this.connection.getUseJDBCCompliantTimezoneShift());
        } else {
            timestampFast = getTimestampFromString(i, calendar, getStringInternal(i, false), timeZone, z);
        }
        if (timestampFast == null) {
            this.wasNullFlag = true;
        } else {
            this.wasNullFlag = false;
        }
        return timestampFast;
    }

    private void issueConversionViaParsingWarning(String str, int i, Object obj, Field field, int[] iArr) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            StringBuilder sb = new StringBuilder();
            StatementImpl statementImpl = this.owningStatement;
            if (statementImpl == null || !(statementImpl instanceof PreparedStatement)) {
                sb.append(".");
            } else {
                sb.append(Messages.getString("ResultSet.CostlyConversionCreatedFromQuery"));
                sb.append(((PreparedStatement) this.owningStatement).originalSql);
                sb.append("\n\n");
            }
            StringBuilder sb2 = new StringBuilder();
            for (int i2 : iArr) {
                sb2.append(MysqlDefs.typeToName(i2));
                sb2.append("\n");
            }
            Object[] objArr = new Object[8];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(i + 1);
            objArr[2] = field.getOriginalName();
            objArr[3] = field.getOriginalTableName();
            objArr[4] = sb.toString();
            objArr[5] = obj != null ? obj.getClass().getName() : ResultSetMetaData.getClassNameForJavaType(field.getSQLType(), field.isUnsigned(), field.getMysqlType(), field.isBinary() || field.isBlob(), field.isOpaqueBinary(), this.connection.getYearIsDateType());
            objArr[6] = MysqlDefs.typeToName(field.getMysqlType());
            objArr[7] = sb2.toString();
            String string = Messages.getString("ResultSet.CostlyConversion", objArr);
            ProfilerEventHandler profilerEventHandler = this.eventSink;
            StatementImpl statementImpl2 = this.owningStatement;
            profilerEventHandler.consumeEvent(new ProfilerEvent((byte) 0, BuildConfig.FLAVOR, statementImpl2 == null ? "N/A" : statementImpl2.currentCatalog, this.connectionId, statementImpl2 == null ? -1 : statementImpl2.getId(), this.resultId, System.currentTimeMillis(), 0L, Constants.MILLIS_I18N, null, this.pointOfOrigin, string));
        }
    }

    private int parseIntAsDouble(int i, String str) throws SQLException, NumberFormatException {
        if (str == null) {
            return 0;
        }
        double d = Double.parseDouble(str);
        if (this.jdbcCompliantTruncationForReads && (d < -2.147483648E9d || d > 2.147483647E9d)) {
            throwRangeException(String.valueOf(d), i, 4);
        }
        return (int) d;
    }

    private long parseLongAsDouble(int i, String str) throws SQLException, NumberFormatException {
        if (str == null) {
            return 0L;
        }
        double d = Double.parseDouble(str);
        if (this.jdbcCompliantTruncationForReads && (d < -9.223372036854776E18d || d > 9.223372036854776E18d)) {
            throwRangeException(str, i + 1, -5);
        }
        return (long) d;
    }

    private long parseLongWithOverflowCheck(int i, byte[] bArr, String str, boolean z) throws SQLException, NumberFormatException {
        if (bArr == null && str == null) {
            return 0L;
        }
        long j = bArr != null ? StringUtils.getLong(bArr) : Long.parseLong(str.trim());
        if (z && this.jdbcCompliantTruncationForReads) {
            checkForLongTruncation(i, bArr, j);
        }
        return j;
    }

    private short parseShortAsDouble(int i, String str) throws SQLException, NumberFormatException {
        if (str == null) {
            return (short) 0;
        }
        double d = Double.parseDouble(str);
        if (this.jdbcCompliantTruncationForReads && (d < -32768.0d || d > 32767.0d)) {
            throwRangeException(String.valueOf(d), i, 5);
        }
        return (short) d;
    }

    private short parseShortWithOverflowCheck(int i, byte[] bArr, String str) throws SQLException, NumberFormatException {
        short s;
        if (bArr == null && str == null) {
            return (short) 0;
        }
        if (bArr != null) {
            s = StringUtils.getShort(bArr);
        } else {
            str = str.trim();
            s = Short.parseShort(str);
        }
        if (this.jdbcCompliantTruncationForReads && (s == Short.MIN_VALUE || s == Short.MAX_VALUE)) {
            long j = Long.parseLong(str == null ? StringUtils.toString(bArr) : str);
            if (j < -32768 || j > 32767) {
                if (str == null) {
                    str = StringUtils.toString(bArr);
                }
                throwRangeException(str, i, 5);
            }
        }
        return s;
    }

    private void setRowPositionValidity() throws SQLException {
        if (!this.rowData.isDynamic() && this.rowData.size() == 0) {
            this.invalidRowReason = Messages.getString("ResultSet.Illegal_operation_on_empty_result_set");
            this.onValidRow = false;
        } else if (this.rowData.isBeforeFirst()) {
            this.invalidRowReason = Messages.getString("ResultSet.Before_start_of_result_set_146");
            this.onValidRow = false;
        } else if (this.rowData.isAfterLast()) {
            this.invalidRowReason = Messages.getString("ResultSet.After_end_of_result_set_148");
            this.onValidRow = false;
        } else {
            this.onValidRow = true;
            this.invalidRowReason = null;
        }
    }

    private void throwRangeException(String str, int i, int i2) throws SQLException {
        String str2;
        if (i2 == -6) {
            str2 = "TINYINT";
        } else if (i2 != -5) {
            switch (i2) {
                case 3:
                    str2 = "DECIMAL";
                    break;
                case 4:
                    str2 = "INTEGER";
                    break;
                case 5:
                    str2 = "SMALLINT";
                    break;
                case 6:
                    str2 = "FLOAT";
                    break;
                case 7:
                    str2 = "REAL";
                    break;
                case 8:
                    str2 = "DOUBLE";
                    break;
                default:
                    str2 = " (JDBC type '" + i2 + "')";
                    break;
            }
        } else {
            str2 = "BIGINT";
        }
        throw SQLError.createSQLException("'" + str + "' in column '" + i + "' is outside valid range for the datatype " + str2 + ".", SQLError.SQL_STATE_NUMERIC_VALUE_OUT_OF_RANGE, getExceptionInterceptor());
    }

    @Override // java.sql.ResultSet
    public boolean absolute(int i) throws SQLException {
        boolean zAbsolute;
        synchronized (checkClosed().getConnectionMutex()) {
            zAbsolute = true;
            if (this.rowData.size() != 0) {
                if (this.onInsertRow) {
                    this.onInsertRow = false;
                }
                if (this.doingUpdates) {
                    this.doingUpdates = false;
                }
                ResultSetRow resultSetRow = this.thisRow;
                if (resultSetRow != null) {
                    resultSetRow.closeOpenStreams();
                }
                if (i == 0) {
                    beforeFirst();
                } else if (i == 1) {
                    zAbsolute = first();
                } else if (i == -1) {
                    zAbsolute = last();
                } else if (i > this.rowData.size()) {
                    afterLast();
                } else if (i < 0) {
                    int size = this.rowData.size() + i + 1;
                    if (size <= 0) {
                        beforeFirst();
                    } else {
                        zAbsolute = absolute(size);
                    }
                } else {
                    int i2 = i - 1;
                    this.rowData.setCurrentRow(i2);
                    this.thisRow = this.rowData.getAt(i2);
                }
                zAbsolute = false;
            } else {
                zAbsolute = false;
            }
            setRowPositionValidity();
        }
        return zAbsolute;
    }

    @Override // java.sql.ResultSet
    public void afterLast() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.onInsertRow) {
                this.onInsertRow = false;
            }
            if (this.doingUpdates) {
                this.doingUpdates = false;
            }
            ResultSetRow resultSetRow = this.thisRow;
            if (resultSetRow != null) {
                resultSetRow.closeOpenStreams();
            }
            if (this.rowData.size() != 0) {
                this.rowData.afterLast();
                this.thisRow = null;
            }
            setRowPositionValidity();
        }
    }

    @Override // java.sql.ResultSet
    public void beforeFirst() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.onInsertRow) {
                this.onInsertRow = false;
            }
            if (this.doingUpdates) {
                this.doingUpdates = false;
            }
            if (this.rowData.size() == 0) {
                return;
            }
            ResultSetRow resultSetRow = this.thisRow;
            if (resultSetRow != null) {
                resultSetRow.closeOpenStreams();
            }
            this.rowData.beforeFirst();
            this.thisRow = null;
            setRowPositionValidity();
        }
    }

    @Override // com.mysql.jdbc.ResultSetInternalMethods
    public void buildIndexMapping() throws SQLException {
        int length = this.fields.length;
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        this.columnLabelToIndex = new TreeMap(comparator);
        this.fullColumnNameToIndex = new TreeMap(comparator);
        this.columnNameToIndex = new TreeMap(comparator);
        for (int i = length - 1; i >= 0; i--) {
            Integer numValueOf = Integer.valueOf(i);
            String originalName = this.fields[i].getOriginalName();
            String name = this.fields[i].getName();
            String fullName = this.fields[i].getFullName();
            if (name != null) {
                this.columnLabelToIndex.put(name, numValueOf);
            }
            if (fullName != null) {
                this.fullColumnNameToIndex.put(fullName, numValueOf);
            }
            if (originalName != null) {
                this.columnNameToIndex.put(originalName, numValueOf);
            }
        }
        this.hasBuiltIndexMapping = true;
    }

    @Override // java.sql.ResultSet
    public void cancelRowUpdates() throws SQLException {
        throw new NotUpdatable();
    }

    public final MySQLConnection checkClosed() throws SQLException {
        MySQLConnection mySQLConnection = this.connection;
        if (mySQLConnection != null) {
            return mySQLConnection;
        }
        throw SQLError.createSQLException(Messages.getString("ResultSet.Operation_not_allowed_after_ResultSet_closed_144"), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
    }

    public final void checkColumnBounds(int i) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            try {
                if (i < 1) {
                    throw SQLError.createSQLException(Messages.getString("ResultSet.Column_Index_out_of_range_low", new Object[]{Integer.valueOf(i), Integer.valueOf(this.fields.length)}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                }
                if (i > this.fields.length) {
                    throw SQLError.createSQLException(Messages.getString("ResultSet.Column_Index_out_of_range_high", new Object[]{Integer.valueOf(i), Integer.valueOf(this.fields.length)}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                }
                if (this.profileSql || this.useUsageAdvisor) {
                    this.columnUsed[i - 1] = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void checkRowPos() throws SQLException {
        checkClosed();
        if (!this.onValidRow) {
            throw SQLError.createSQLException(this.invalidRowReason, SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
        }
    }

    @Override // com.mysql.jdbc.ResultSetInternalMethods
    public synchronized void clearNextResult() {
        this.nextResultSet = null;
    }

    @Override // java.sql.ResultSet
    public void clearWarnings() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            this.warningChain = null;
        }
    }

    @Override // java.sql.ResultSet, java.lang.AutoCloseable
    public void close() throws SQLException {
        realClose(true);
    }

    @Override // com.mysql.jdbc.ResultSetInternalMethods
    public ResultSetInternalMethods copy() throws SQLException {
        ResultSetImpl resultSetImpl;
        synchronized (checkClosed().getConnectionMutex()) {
            resultSetImpl = getInstance(this.catalog, this.fields, this.rowData, this.connection, this.owningStatement, false);
            if (this.isBinaryEncoded) {
                resultSetImpl.setBinaryEncoded();
            }
        }
        return resultSetImpl;
    }

    @Override // java.sql.ResultSet
    public void deleteRow() throws SQLException {
        throw new NotUpdatable();
    }

    public Date fastDateCreate(Calendar calendar, int i, int i2, int i3) throws SQLException {
        Calendar fastClientCalendar;
        synchronized (checkClosed().getConnectionMutex()) {
            if (calendar == null) {
                fastClientCalendar = this.connection.getNoTimezoneConversionForDateType() ? getFastClientCalendar() : getFastDefaultCalendar();
            } else {
                fastClientCalendar = calendar;
            }
            if (!this.useLegacyDatetimeCode) {
                return TimeUtil.fastDateCreate(i, i2, i3, fastClientCalendar);
            }
            boolean z = calendar == null && !this.connection.getNoTimezoneConversionForDateType() && this.connection.getUseGmtMillisForDatetimes();
            return TimeUtil.fastDateCreate(z, z ? getGmtCalendar() : fastClientCalendar, fastClientCalendar, i, i2, i3);
        }
    }

    public Time fastTimeCreate(Calendar calendar, int i, int i2, int i3) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (!this.useLegacyDatetimeCode) {
                return TimeUtil.fastTimeCreate(i, i2, i3, calendar, getExceptionInterceptor());
            }
            if (calendar == null) {
                calendar = getFastDefaultCalendar();
            }
            return TimeUtil.fastTimeCreate(calendar, i, i2, i3, getExceptionInterceptor());
        }
    }

    public Timestamp fastTimestampCreate(Calendar calendar, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (!this.useLegacyDatetimeCode) {
                return TimeUtil.fastTimestampCreate(calendar.getTimeZone(), i, i2, i3, i4, i5, i6, i7);
            }
            return TimeUtil.fastTimestampCreate(z, z ? getGmtCalendar() : null, calendar == null ? getFastDefaultCalendar() : calendar, i, i2, i3, i4, i5, i6, i7);
        }
    }

    @Override // java.sql.ResultSet
    public int findColumn(String str) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (!this.hasBuiltIndexMapping) {
                buildIndexMapping();
            }
            Integer num = this.columnToIndexCache.get(str);
            if (num != null) {
                return num.intValue() + 1;
            }
            Integer num2 = this.columnLabelToIndex.get(str);
            if (num2 == null && this.useColumnNamesInFindColumn) {
                num2 = this.columnNameToIndex.get(str);
            }
            if (num2 == null) {
                num2 = this.fullColumnNameToIndex.get(str);
            }
            if (num2 != null) {
                this.columnToIndexCache.put(str, num2);
                return num2.intValue() + 1;
            }
            int i = 0;
            while (true) {
                Field[] fieldArr = this.fields;
                if (i >= fieldArr.length) {
                    throw SQLError.createSQLException(Messages.getString("ResultSet.Column____112") + str + Messages.getString("ResultSet.___not_found._113"), SQLError.SQL_STATE_COLUMN_NOT_FOUND, getExceptionInterceptor());
                }
                if (fieldArr[i].getName().equalsIgnoreCase(str)) {
                    return i + 1;
                }
                if (this.fields[i].getFullName().equalsIgnoreCase(str)) {
                    return i + 1;
                }
                i++;
            }
        }
    }

    @Override // java.sql.ResultSet
    public boolean first() throws SQLException {
        boolean z;
        synchronized (checkClosed().getConnectionMutex()) {
            z = true;
            if (this.rowData.isEmpty()) {
                z = false;
            } else {
                if (this.onInsertRow) {
                    this.onInsertRow = false;
                }
                if (this.doingUpdates) {
                    this.doingUpdates = false;
                }
                this.rowData.beforeFirst();
                this.thisRow = this.rowData.next();
            }
            setRowPositionValidity();
        }
        return z;
    }

    @Override // java.sql.ResultSet
    public Array getArray(int i) throws SQLException {
        checkColumnBounds(i);
        throw SQLError.createSQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public InputStream getAsciiStream(int i) throws SQLException {
        checkRowPos();
        return !this.isBinaryEncoded ? getBinaryStream(i) : getNativeBinaryStream(i);
    }

    @Override // java.sql.ResultSet
    public BigDecimal getBigDecimal(int i) throws SQLException {
        if (this.isBinaryEncoded) {
            return getNativeBigDecimal(i);
        }
        String string = getString(i);
        if (string == null) {
            return null;
        }
        if (string.length() == 0) {
            return new BigDecimal(convertToZeroLiteralStringWithEmptyCheck());
        }
        try {
            return new BigDecimal(string);
        } catch (NumberFormatException unused) {
            throw SQLError.createSQLException(Messages.getString("ResultSet.Bad_format_for_BigDecimal", new Object[]{string, Integer.valueOf(i)}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
    }

    @Override // java.sql.ResultSet
    public InputStream getBinaryStream(int i) throws SQLException {
        checkRowPos();
        if (this.isBinaryEncoded) {
            return getNativeBinaryStream(i);
        }
        checkColumnBounds(i);
        int i2 = i - 1;
        if (this.thisRow.isNull(i2)) {
            this.wasNullFlag = true;
            return null;
        }
        this.wasNullFlag = false;
        return this.thisRow.getBinaryInputStream(i2);
    }

    @Override // java.sql.ResultSet
    public java.sql.Blob getBlob(int i) throws SQLException {
        if (this.isBinaryEncoded) {
            return getNativeBlob(i);
        }
        checkRowPos();
        checkColumnBounds(i);
        int i2 = i - 1;
        if (this.thisRow.isNull(i2)) {
            this.wasNullFlag = true;
        } else {
            this.wasNullFlag = false;
        }
        if (this.wasNullFlag) {
            return null;
        }
        return !this.connection.getEmulateLocators() ? new Blob(this.thisRow.getColumnValue(i2), getExceptionInterceptor()) : new BlobFromLocator(this, i, getExceptionInterceptor());
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:419)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:399)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:31)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:21)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    @Override // java.sql.ResultSet
    public boolean getBoolean(int r12) throws java.sql.SQLException {
        /*
            Method dump skipped, instruction units count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mysql.jdbc.ResultSetImpl.getBoolean(int):boolean");
    }

    @Override // java.sql.ResultSet
    public byte getByte(int i) throws SQLException {
        if (this.isBinaryEncoded) {
            return getNativeByte(i);
        }
        String string = getString(i);
        if (this.wasNullFlag || string == null) {
            return (byte) 0;
        }
        return getByteFromString(string, i);
    }

    @Override // java.sql.ResultSet
    public byte[] getBytes(int i) throws SQLException {
        return getBytes(i, false);
    }

    @Override // com.mysql.jdbc.ResultSetInternalMethods
    public int getBytesSize() throws SQLException {
        RowData rowData = this.rowData;
        checkClosed();
        if (!(rowData instanceof RowDataStatic)) {
            return -1;
        }
        int size = rowData.size();
        int bytesSize = 0;
        for (int i = 0; i < size; i++) {
            bytesSize += rowData.getAt(i).getBytesSize();
        }
        return bytesSize;
    }

    public Calendar getCalendarInstanceForSessionOrNew() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.connection != null) {
                return this.connection.getCalendarInstanceForSessionOrNew();
            }
            return new GregorianCalendar();
        }
    }

    @Override // java.sql.ResultSet
    public Reader getCharacterStream(int i) throws SQLException {
        if (this.isBinaryEncoded) {
            return getNativeCharacterStream(i);
        }
        checkColumnBounds(i);
        int i2 = i - 1;
        if (this.thisRow.isNull(i2)) {
            this.wasNullFlag = true;
            return null;
        }
        this.wasNullFlag = false;
        return this.thisRow.getReader(i2);
    }

    @Override // java.sql.ResultSet
    public java.sql.Clob getClob(int i) throws SQLException {
        if (this.isBinaryEncoded) {
            return getNativeClob(i);
        }
        String stringForClob = getStringForClob(i);
        if (stringForClob == null) {
            return null;
        }
        return new Clob(stringForClob, getExceptionInterceptor());
    }

    @Override // java.sql.ResultSet
    public int getConcurrency() throws SQLException {
        return MysqlErrorNumbers.ER_DB_CREATE_EXISTS;
    }

    @Override // java.sql.ResultSet
    public String getCursorName() throws SQLException {
        throw SQLError.createSQLException(Messages.getString("ResultSet.Positioned_Update_not_supported"), SQLError.SQL_STATE_DRIVER_NOT_CAPABLE, getExceptionInterceptor());
    }

    @Override // java.sql.ResultSet
    public Date getDate(int i) throws SQLException {
        return getDate(i, (Calendar) null);
    }

    @Override // java.sql.ResultSet
    public double getDouble(int i) throws SQLException {
        return !this.isBinaryEncoded ? getDoubleInternal(i) : getNativeDouble(i);
    }

    public double getDoubleInternal(int i) throws SQLException {
        return getDoubleInternal(getString(i), i);
    }

    public ExceptionInterceptor getExceptionInterceptor() {
        return this.exceptionInterceptor;
    }

    @Override // java.sql.ResultSet
    public int getFetchDirection() throws SQLException {
        int i;
        synchronized (checkClosed().getConnectionMutex()) {
            i = this.fetchDirection;
        }
        return i;
    }

    @Override // java.sql.ResultSet
    public int getFetchSize() throws SQLException {
        int i;
        synchronized (checkClosed().getConnectionMutex()) {
            i = this.fetchSize;
        }
        return i;
    }

    @Override // com.mysql.jdbc.ResultSetInternalMethods
    public char getFirstCharOfQuery() {
        char c;
        try {
            synchronized (checkClosed().getConnectionMutex()) {
                c = this.firstCharOfQuery;
            }
            return c;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.sql.ResultSet
    public float getFloat(int i) throws SQLException {
        return !this.isBinaryEncoded ? getFloatFromString(getString(i), i) : getNativeFloat(i);
    }

    public Calendar getGmtCalendar() {
        if (this.gmtCalendar == null) {
            this.gmtCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        }
        return this.gmtCalendar;
    }

    @Override // java.sql.ResultSet
    public int getInt(int i) throws SQLException {
        checkRowPos();
        checkColumnBounds(i);
        if (this.isBinaryEncoded) {
            return getNativeInt(i);
        }
        int i2 = i - 1;
        if (this.thisRow.isNull(i2)) {
            this.wasNullFlag = true;
            return 0;
        }
        this.wasNullFlag = false;
        if (this.fields[i2].getMysqlType() == 16) {
            long numericRepresentationOfSQLBitType = getNumericRepresentationOfSQLBitType(i);
            if (this.jdbcCompliantTruncationForReads && (numericRepresentationOfSQLBitType < -2147483648L || numericRepresentationOfSQLBitType > 2147483647L)) {
                throwRangeException(String.valueOf(numericRepresentationOfSQLBitType), i, 4);
            }
            return (int) numericRepresentationOfSQLBitType;
        }
        if (this.useFastIntParsing) {
            if (this.thisRow.length(i2) == 0) {
                return convertToZeroWithEmptyCheck();
            }
            if (!this.thisRow.isFloatingPointNumber(i2)) {
                try {
                    try {
                        return getIntWithOverflowCheck(i2);
                    } catch (NumberFormatException unused) {
                        return parseIntAsDouble(i, this.thisRow.getString(i2, this.fields[i2].getEncoding(), this.connection));
                    }
                } catch (NumberFormatException unused2) {
                    throw SQLError.createSQLException(Messages.getString("ResultSet.Invalid_value_for_getInt()_-____74") + this.thisRow.getString(i2, this.fields[i2].getEncoding(), this.connection) + "'", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                }
            }
        }
        String str = null;
        try {
            String string = getString(i);
            if (string == null) {
                return 0;
            }
            try {
                if (string.length() == 0) {
                    return convertToZeroWithEmptyCheck();
                }
                if (string.indexOf("e") == -1 && string.indexOf("E") == -1 && string.indexOf(".") == -1) {
                    int i3 = Integer.parseInt(string);
                    checkForIntegerTruncation(i2, null, i3);
                    return i3;
                }
                int intAsDouble = parseIntAsDouble(i, string);
                checkForIntegerTruncation(i, null, intAsDouble);
                return intAsDouble;
            } catch (NumberFormatException unused3) {
                str = string;
                try {
                    return parseIntAsDouble(i, str);
                } catch (NumberFormatException unused4) {
                    throw SQLError.createSQLException(Messages.getString("ResultSet.Invalid_value_for_getInt()_-____74") + str + "'", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                }
            }
        } catch (NumberFormatException unused5) {
        }
    }

    @Override // java.sql.ResultSet
    public long getLong(int i) throws SQLException {
        return getLong(i, true);
    }

    @Override // java.sql.ResultSet
    public java.sql.ResultSetMetaData getMetaData() throws SQLException {
        checkClosed();
        return new ResultSetMetaData(this.fields, this.connection.getUseOldAliasMetadataBehavior(), this.connection.getYearIsDateType(), getExceptionInterceptor());
    }

    public Array getNativeArray(int i) throws SQLException {
        throw SQLError.createSQLFeatureNotSupportedException();
    }

    public InputStream getNativeAsciiStream(int i) throws SQLException {
        checkRowPos();
        return getNativeBinaryStream(i);
    }

    public BigDecimal getNativeBigDecimal(int i) throws SQLException {
        checkColumnBounds(i);
        return getNativeBigDecimal(i, this.fields[i - 1].getDecimals());
    }

    public InputStream getNativeBinaryStream(int i) throws SQLException {
        checkRowPos();
        int i2 = i - 1;
        if (this.thisRow.isNull(i2)) {
            this.wasNullFlag = true;
            return null;
        }
        this.wasNullFlag = false;
        int sQLType = this.fields[i2].getSQLType();
        if (sQLType == -7 || sQLType == 2004 || sQLType == -4 || sQLType == -3 || sQLType == -2) {
            return this.thisRow.getBinaryInputStream(i2);
        }
        byte[] nativeBytes = getNativeBytes(i, false);
        if (nativeBytes != null) {
            return new ByteArrayInputStream(nativeBytes);
        }
        return null;
    }

    public java.sql.Blob getNativeBlob(int i) throws SQLException {
        checkRowPos();
        checkColumnBounds(i);
        int i2 = i - 1;
        byte[] columnValue = this.thisRow.getColumnValue(i2);
        if (columnValue == null) {
            this.wasNullFlag = true;
        } else {
            this.wasNullFlag = false;
        }
        if (this.wasNullFlag) {
            return null;
        }
        switch (this.fields[i2].getMysqlType()) {
            case MysqlDefs.FIELD_TYPE_TINY_BLOB /* 249 */:
            case 250:
            case MysqlDefs.FIELD_TYPE_LONG_BLOB /* 251 */:
            case MysqlDefs.FIELD_TYPE_BLOB /* 252 */:
                break;
            default:
                columnValue = getNativeBytes(i, false);
                break;
        }
        return !this.connection.getEmulateLocators() ? new Blob(columnValue, getExceptionInterceptor()) : new BlobFromLocator(this, i, getExceptionInterceptor());
    }

    public byte getNativeByte(int i) throws SQLException {
        return getNativeByte(i, true);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0036  */
    /* JADX WARN: Code duplicated, block: B:22:0x003a A[RETURN] */
    public byte[] getNativeBytes(int i, boolean z) throws SQLException {
        checkRowPos();
        checkColumnBounds(i);
        int i2 = i - 1;
        byte[] columnValue = this.thisRow.getColumnValue(i2);
        if (columnValue == null) {
            this.wasNullFlag = true;
        } else {
            this.wasNullFlag = false;
        }
        if (this.wasNullFlag) {
            return null;
        }
        Field field = this.fields[i2];
        int mysqlType = field.getMysqlType();
        if (z) {
            mysqlType = MysqlDefs.FIELD_TYPE_BLOB;
        }
        if (mysqlType != 15) {
            if (mysqlType != 16) {
                switch (mysqlType) {
                    case MysqlDefs.FIELD_TYPE_VAR_STRING /* 253 */:
                    case MysqlDefs.FIELD_TYPE_STRING /* 254 */:
                        if (columnValue instanceof byte[]) {
                            return columnValue;
                        }
                        break;
                }
            }
            return columnValue;
        }
        if (columnValue instanceof byte[]) {
            return columnValue;
        }
        int sQLType = field.getSQLType();
        return (sQLType == -3 || sQLType == -2) ? columnValue : getBytesFromString(getNativeString(i));
    }

    public Reader getNativeCharacterStream(int i) throws SQLException {
        int i2 = i - 1;
        int sQLType = this.fields[i2].getSQLType();
        if (sQLType != -1 && sQLType != 1 && sQLType != 12 && sQLType != 2005) {
            String stringForClob = getStringForClob(i);
            if (stringForClob == null) {
                return null;
            }
            return getCharacterStreamFromString(stringForClob);
        }
        if (this.thisRow.isNull(i2)) {
            this.wasNullFlag = true;
            return null;
        }
        this.wasNullFlag = false;
        return this.thisRow.getReader(i2);
    }

    public java.sql.Clob getNativeClob(int i) throws SQLException {
        String stringForClob = getStringForClob(i);
        if (stringForClob == null) {
            return null;
        }
        return getClobFromString(stringForClob);
    }

    public Date getNativeDate(int i) throws SQLException {
        return getNativeDate(i, null);
    }

    public Date getNativeDateViaParseConversion(int i) throws SQLException {
        if (this.useUsageAdvisor) {
            int i2 = i - 1;
            issueConversionViaParsingWarning("getDate()", i, this.thisRow.getColumnValue(i2), this.fields[i2], new int[]{10});
        }
        return getDateFromString(getNativeString(i), i, null);
    }

    public double getNativeDouble(int i) throws SQLException {
        checkRowPos();
        checkColumnBounds(i);
        int i2 = i - 1;
        if (this.thisRow.isNull(i2)) {
            this.wasNullFlag = true;
            return 0.0d;
        }
        this.wasNullFlag = false;
        Field field = this.fields[i2];
        int mysqlType = field.getMysqlType();
        if (mysqlType == 1) {
            return !field.isUnsigned() ? getNativeByte(i2 + 1) : getNativeShort(i2 + 1);
        }
        if (mysqlType != 2) {
            if (mysqlType != 3) {
                if (mysqlType == 4) {
                    return getNativeFloat(i2 + 1);
                }
                if (mysqlType == 5) {
                    return this.thisRow.getNativeDouble(i2);
                }
                if (mysqlType == 8) {
                    long nativeLong = getNativeLong(i2 + 1);
                    return !field.isUnsigned() ? nativeLong : convertLongToUlong(nativeLong).doubleValue();
                }
                if (mysqlType != 9) {
                    if (mysqlType != 13) {
                        if (mysqlType == 16) {
                            return getNumericRepresentationOfSQLBitType(i2 + 1);
                        }
                        int i3 = i2 + 1;
                        String nativeString = getNativeString(i3);
                        if (this.useUsageAdvisor) {
                            issueConversionViaParsingWarning("getDouble()", i2, nativeString, this.fields[i2], new int[]{5, 1, 2, 3, 8, 4});
                        }
                        return getDoubleFromString(nativeString, i3);
                    }
                }
            }
            return !field.isUnsigned() ? getNativeInt(i2 + 1) : getNativeLong(i2 + 1);
        }
        return !field.isUnsigned() ? getNativeShort(i2 + 1) : getNativeInt(i2 + 1);
    }

    public float getNativeFloat(int i) throws SQLException {
        checkRowPos();
        checkColumnBounds(i);
        int i2 = i - 1;
        if (this.thisRow.isNull(i2)) {
            this.wasNullFlag = true;
            return 0.0f;
        }
        this.wasNullFlag = false;
        Field field = this.fields[i2];
        int mysqlType = field.getMysqlType();
        if (mysqlType == 1) {
            return !field.isUnsigned() ? getNativeByte(i2 + 1) : getNativeShort(i2 + 1);
        }
        if (mysqlType != 2) {
            if (mysqlType != 3) {
                if (mysqlType == 4) {
                    return this.thisRow.getNativeFloat(i2);
                }
                if (mysqlType == 5) {
                    int i3 = i2 + 1;
                    Double d = new Double(getNativeDouble(i3));
                    float fFloatValue = d.floatValue();
                    if ((this.jdbcCompliantTruncationForReads && fFloatValue == Float.NEGATIVE_INFINITY) || fFloatValue == Float.POSITIVE_INFINITY) {
                        throwRangeException(d.toString(), i3, 6);
                    }
                    return (float) getNativeDouble(i3);
                }
                if (mysqlType == 8) {
                    long nativeLong = getNativeLong(i2 + 1);
                    return !field.isUnsigned() ? nativeLong : convertLongToUlong(nativeLong).floatValue();
                }
                if (mysqlType != 9) {
                    if (mysqlType != 13) {
                        if (mysqlType == 16) {
                            return getNumericRepresentationOfSQLBitType(i2 + 1);
                        }
                        int i4 = i2 + 1;
                        String nativeString = getNativeString(i4);
                        if (this.useUsageAdvisor) {
                            issueConversionViaParsingWarning("getFloat()", i2, nativeString, this.fields[i2], new int[]{5, 1, 2, 3, 8, 4});
                        }
                        return getFloatFromString(nativeString, i4);
                    }
                }
            }
            return !field.isUnsigned() ? getNativeInt(i2 + 1) : getNativeLong(i2 + 1);
        }
        return !field.isUnsigned() ? getNativeShort(i2 + 1) : getNativeInt(i2 + 1);
    }

    public int getNativeInt(int i) throws SQLException {
        return getNativeInt(i, true);
    }

    public long getNativeLong(int i) throws SQLException {
        return getNativeLong(i, true, true);
    }

    public Ref getNativeRef(int i) throws SQLException {
        throw SQLError.createSQLFeatureNotSupportedException();
    }

    public short getNativeShort(int i) throws SQLException {
        return getNativeShort(i, true);
    }

    public String getNativeString(int i) throws SQLException {
        checkRowPos();
        checkColumnBounds(i);
        if (this.fields == null) {
            throw SQLError.createSQLException(Messages.getString("ResultSet.Query_generated_no_fields_for_ResultSet_133"), SQLError.SQL_STATE_INVALID_COLUMN_NUMBER, getExceptionInterceptor());
        }
        int i2 = i - 1;
        if (this.thisRow.isNull(i2)) {
            this.wasNullFlag = true;
            return null;
        }
        this.wasNullFlag = false;
        Field field = this.fields[i2];
        String nativeConvertToString = getNativeConvertToString(i, field);
        int mysqlType = field.getMysqlType();
        if (mysqlType == 7 || mysqlType == 10 || !field.isZeroFill() || nativeConvertToString == null) {
            return nativeConvertToString;
        }
        int length = nativeConvertToString.length();
        StringBuilder sb = new StringBuilder(length);
        long length2 = field.getLength() - ((long) length);
        for (long j = 0; j < length2; j++) {
            sb.append('0');
        }
        sb.append(nativeConvertToString);
        return sb.toString();
    }

    public Time getNativeTimeViaParseConversion(int i, Calendar calendar, TimeZone timeZone, boolean z) throws SQLException {
        if (this.useUsageAdvisor) {
            int i2 = i - 1;
            issueConversionViaParsingWarning("getTime()", i, this.thisRow.getColumnValue(i2), this.fields[i2], new int[]{11});
        }
        return getTimeFromString(getNativeString(i), calendar, i, timeZone, z);
    }

    public Timestamp getNativeTimestampViaParseConversion(int i, Calendar calendar, TimeZone timeZone, boolean z) throws SQLException {
        if (this.useUsageAdvisor) {
            int i2 = i - 1;
            issueConversionViaParsingWarning("getTimestamp()", i, this.thisRow.getColumnValue(i2), this.fields[i2], new int[]{7, 12});
        }
        return getTimestampFromString(i, calendar, getNativeString(i), timeZone, z);
    }

    public URL getNativeURL(int i) throws SQLException {
        String string = getString(i);
        if (string == null) {
            return null;
        }
        try {
            return new URL(string);
        } catch (MalformedURLException unused) {
            throw SQLError.createSQLException(Messages.getString("ResultSet.Malformed_URL____141") + string + "'", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
    }

    public InputStream getNativeUnicodeStream(int i) throws SQLException {
        checkRowPos();
        return getBinaryStream(i);
    }

    @Override // com.mysql.jdbc.ResultSetInternalMethods
    public synchronized ResultSetInternalMethods getNextResultSet() {
        return this.nextResultSet;
    }

    @Override // java.sql.ResultSet
    public Object getObject(int i) throws SQLException {
        checkRowPos();
        checkColumnBounds(i);
        int i2 = i - 1;
        if (this.thisRow.isNull(i2)) {
            this.wasNullFlag = true;
            return null;
        }
        this.wasNullFlag = false;
        Field field = this.fields[i2];
        int sQLType = field.getSQLType();
        if (sQLType != 12) {
            if (sQLType == 16) {
                return Boolean.valueOf(getBoolean(i));
            }
            switch (sQLType) {
                case -7:
                    return (field.getMysqlType() != 16 || field.isSingleBit()) ? Boolean.valueOf(getBoolean(i)) : getObjectDeserializingIfNeeded(i);
                case -6:
                    return !field.isUnsigned() ? Integer.valueOf(getByte(i)) : Integer.valueOf(getInt(i));
                case -5:
                    if (!field.isUnsigned()) {
                        return Long.valueOf(getLong(i));
                    }
                    String string = getString(i);
                    if (string == null) {
                        return null;
                    }
                    try {
                        return new BigInteger(string);
                    } catch (NumberFormatException unused) {
                        throw SQLError.createSQLException(Messages.getString("ResultSet.Bad_format_for_BigInteger", new Object[]{Integer.valueOf(i), string}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                    }
                case -4:
                case -3:
                case -2:
                    return field.getMysqlType() == 255 ? getBytes(i) : getObjectDeserializingIfNeeded(i);
                case -1:
                    return !field.isOpaqueBinary() ? getStringForClob(i) : getBytes(i);
                default:
                    switch (sQLType) {
                        case 1:
                            break;
                        case 2:
                        case 3:
                            String string2 = getString(i);
                            if (string2 == null) {
                                return null;
                            }
                            if (string2.length() == 0) {
                                return new BigDecimal(0);
                            }
                            try {
                                return new BigDecimal(string2);
                            } catch (NumberFormatException unused2) {
                                throw SQLError.createSQLException(Messages.getString("ResultSet.Bad_format_for_BigDecimal", new Object[]{string2, Integer.valueOf(i)}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                            }
                        case 4:
                            return (!field.isUnsigned() || field.getMysqlType() == 9) ? Integer.valueOf(getInt(i)) : Long.valueOf(getLong(i));
                        case 5:
                            return Integer.valueOf(getInt(i));
                        case 6:
                        case 8:
                            return new Double(getDouble(i));
                        case 7:
                            return new Float(getFloat(i));
                        default:
                            switch (sQLType) {
                                case 91:
                                    return (field.getMysqlType() != 13 || this.connection.getYearIsDateType()) ? getDate(i) : Short.valueOf(getShort(i));
                                case 92:
                                    return getTime(i);
                                case 93:
                                    return getTimestamp(i);
                                default:
                                    return getString(i);
                            }
                    }
                    break;
            }
        }
        return !field.isOpaqueBinary() ? getString(i) : getBytes(i);
    }

    @Override // com.mysql.jdbc.ResultSetInternalMethods
    public Object getObjectStoredProc(int i, int i2) throws SQLException {
        checkRowPos();
        checkColumnBounds(i);
        int i3 = i - 1;
        if (this.thisRow.getColumnValue(i3) == null) {
            this.wasNullFlag = true;
            return null;
        }
        this.wasNullFlag = false;
        Field field = this.fields[i3];
        if (i2 != 12) {
            if (i2 != 16) {
                switch (i2) {
                    case -7:
                        break;
                    case -6:
                        return Integer.valueOf(getInt(i));
                    case -5:
                        return field.isUnsigned() ? getBigDecimal(i) : Long.valueOf(getLong(i));
                    case -4:
                    case -3:
                    case -2:
                        return getBytes(i);
                    case -1:
                        return getStringForClob(i);
                    default:
                        switch (i2) {
                            case 1:
                                break;
                            case 2:
                            case 3:
                                String string = getString(i);
                                if (string == null) {
                                    return null;
                                }
                                if (string.length() == 0) {
                                    return new BigDecimal(0);
                                }
                                try {
                                    return new BigDecimal(string);
                                } catch (NumberFormatException unused) {
                                    throw SQLError.createSQLException(Messages.getString("ResultSet.Bad_format_for_BigDecimal", new Object[]{string, Integer.valueOf(i)}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                                }
                            case 4:
                                return (!field.isUnsigned() || field.getMysqlType() == 9) ? Integer.valueOf(getInt(i)) : Long.valueOf(getLong(i));
                            case 5:
                                return Integer.valueOf(getInt(i));
                            case 6:
                                return !this.connection.getRunningCTS13() ? new Double(getFloat(i)) : new Float(getFloat(i));
                            case 7:
                                return new Float(getFloat(i));
                            case 8:
                                return new Double(getDouble(i));
                            default:
                                switch (i2) {
                                    case 91:
                                        return (field.getMysqlType() != 13 || this.connection.getYearIsDateType()) ? getDate(i) : Short.valueOf(getShort(i));
                                    case 92:
                                        return getTime(i);
                                    case 93:
                                        return getTimestamp(i);
                                    default:
                                        return getString(i);
                                }
                        }
                        break;
                }
            }
            return Boolean.valueOf(getBoolean(i));
        }
        return getString(i);
    }

    @Override // java.sql.ResultSet
    public Ref getRef(int i) throws SQLException {
        checkColumnBounds(i);
        throw SQLError.createSQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public int getRow() throws SQLException {
        checkClosed();
        int currentRowNumber = this.rowData.getCurrentRowNumber();
        if (this.rowData.isDynamic() || !(currentRowNumber < 0 || this.rowData.isAfterLast() || this.rowData.isEmpty())) {
            return currentRowNumber + 1;
        }
        return 0;
    }

    @Override // com.mysql.jdbc.ResultSetInternalMethods
    public String getServerInfo() {
        String str;
        try {
            synchronized (checkClosed().getConnectionMutex()) {
                str = this.serverInfo;
            }
            return str;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.sql.ResultSet
    public short getShort(int i) throws SQLException {
        int iConvertToZeroWithEmptyCheck;
        checkRowPos();
        checkColumnBounds(i);
        if (this.isBinaryEncoded) {
            return getNativeShort(i);
        }
        int i2 = i - 1;
        boolean z = true;
        if (this.thisRow.isNull(i2)) {
            this.wasNullFlag = true;
            return (short) 0;
        }
        this.wasNullFlag = false;
        if (this.fields[i2].getMysqlType() == 16) {
            long numericRepresentationOfSQLBitType = getNumericRepresentationOfSQLBitType(i);
            if (this.jdbcCompliantTruncationForReads && (numericRepresentationOfSQLBitType < -32768 || numericRepresentationOfSQLBitType > 32767)) {
                throwRangeException(String.valueOf(numericRepresentationOfSQLBitType), i, 5);
            }
            iConvertToZeroWithEmptyCheck = (int) numericRepresentationOfSQLBitType;
        } else {
            String str = null;
            if (this.useFastIntParsing) {
                byte[] columnValue = this.thisRow.getColumnValue(i2);
                if (columnValue.length == 0) {
                    iConvertToZeroWithEmptyCheck = convertToZeroWithEmptyCheck();
                } else {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= columnValue.length) {
                            z = false;
                            break;
                        }
                        if (((char) columnValue[i3]) == 'e' || ((char) columnValue[i3]) == 'E') {
                            break;
                        }
                        i3++;
                    }
                    if (!z) {
                        try {
                            try {
                                return parseShortWithOverflowCheck(i, columnValue, null);
                            } catch (NumberFormatException unused) {
                                return parseShortAsDouble(i, StringUtils.toString(columnValue));
                            }
                        } catch (NumberFormatException unused2) {
                            throw SQLError.createSQLException(Messages.getString("ResultSet.Invalid_value_for_getShort()_-____96") + StringUtils.toString(columnValue) + "'", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                        }
                    }
                }
            }
            try {
                String string = getString(i);
                if (string == null) {
                    return (short) 0;
                }
                try {
                    if (string.length() == 0) {
                        return (short) convertToZeroWithEmptyCheck();
                    }
                    return (string.indexOf("e") == -1 && string.indexOf("E") == -1 && string.indexOf(".") == -1) ? parseShortWithOverflowCheck(i, null, string) : parseShortAsDouble(i, string);
                } catch (NumberFormatException unused3) {
                    str = string;
                    try {
                        return parseShortAsDouble(i, str);
                    } catch (NumberFormatException unused4) {
                        throw SQLError.createSQLException(Messages.getString("ResultSet.Invalid_value_for_getShort()_-____96") + str + "'", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                    }
                }
            } catch (NumberFormatException unused5) {
            }
        }
        return (short) iConvertToZeroWithEmptyCheck;
    }

    @Override // java.sql.ResultSet
    public java.sql.Statement getStatement() throws SQLException {
        try {
            synchronized (checkClosed().getConnectionMutex()) {
                java.sql.Statement statement = this.wrapperStatement;
                if (statement != null) {
                    return statement;
                }
                return this.owningStatement;
            }
        } catch (SQLException unused) {
            if (!this.retainOwningStatement) {
                throw SQLError.createSQLException("Operation not allowed on closed ResultSet. Statements can be retained over result set closure by setting the connection property \"retainStatementAfterResultSetClose\" to \"true\".", SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
            }
            java.sql.Statement statement2 = this.wrapperStatement;
            return statement2 != null ? statement2 : this.owningStatement;
        }
    }

    @Override // java.sql.ResultSet
    public String getString(int i) throws SQLException {
        int length;
        int length2;
        String stringInternal = getStringInternal(i, true);
        if (!this.padCharsWithSpace || stringInternal == null) {
            return stringInternal;
        }
        Field field = this.fields[i - 1];
        if (field.getMysqlType() != 254 || (length2 = stringInternal.length()) >= (length = ((int) field.getLength()) / field.getMaxBytesPerCharacter())) {
            return stringInternal;
        }
        StringBuilder sb = new StringBuilder(length);
        sb.append(stringInternal);
        sb.append(EMPTY_SPACE, 0, length - length2);
        return sb.toString();
    }

    public String getStringInternal(int i, boolean z) throws SQLException {
        if (this.isBinaryEncoded) {
            return getNativeString(i);
        }
        checkRowPos();
        checkColumnBounds(i);
        if (this.fields == null) {
            throw SQLError.createSQLException(Messages.getString("ResultSet.Query_generated_no_fields_for_ResultSet_99"), SQLError.SQL_STATE_INVALID_COLUMN_NUMBER, getExceptionInterceptor());
        }
        int i2 = i - 1;
        if (this.thisRow.isNull(i2)) {
            this.wasNullFlag = true;
            return null;
        }
        this.wasNullFlag = false;
        Field field = this.fields[i2];
        if (field.getMysqlType() == 16) {
            if (!field.isSingleBit()) {
                return String.valueOf(getNumericRepresentationOfSQLBitType(i));
            }
            byte[] columnValue = this.thisRow.getColumnValue(i2);
            return columnValue.length == 0 ? String.valueOf(convertToZeroWithEmptyCheck()) : String.valueOf((int) columnValue[0]);
        }
        String string = this.thisRow.getString(i2, field.getEncoding(), this.connection);
        if (field.getMysqlType() == 13) {
            if (!this.connection.getYearIsDateType()) {
                return string;
            }
            Date dateFromString = getDateFromString(string, i, null);
            if (dateFromString == null) {
                this.wasNullFlag = true;
                return null;
            }
            this.wasNullFlag = false;
            return dateFromString.toString();
        }
        if (z && !this.connection.getNoDatetimeStringSync()) {
            switch (field.getSQLType()) {
                case 91:
                    Date dateFromString2 = getDateFromString(string, i, null);
                    if (dateFromString2 == null) {
                        this.wasNullFlag = true;
                        return null;
                    }
                    this.wasNullFlag = false;
                    return dateFromString2.toString();
                case 92:
                    Time timeFromString = getTimeFromString(string, null, i, getDefaultTimeZone(), false);
                    if (timeFromString == null) {
                        this.wasNullFlag = true;
                        return null;
                    }
                    this.wasNullFlag = false;
                    return timeFromString.toString();
                case 93:
                    Timestamp timestampFromString = getTimestampFromString(i, null, string, getDefaultTimeZone(), false);
                    if (timestampFromString == null) {
                        this.wasNullFlag = true;
                        return null;
                    }
                    this.wasNullFlag = false;
                    return timestampFromString.toString();
            }
        }
        return string;
    }

    @Override // java.sql.ResultSet
    public Time getTime(int i) throws SQLException {
        return getTimeInternal(i, null, getDefaultTimeZone(), false);
    }

    @Override // java.sql.ResultSet
    public Timestamp getTimestamp(int i) throws SQLException {
        return getTimestampInternal(i, null, getDefaultTimeZone(), false);
    }

    @Override // java.sql.ResultSet
    public int getType() throws SQLException {
        return this.resultSetType;
    }

    @Override // java.sql.ResultSet
    public URL getURL(int i) throws SQLException {
        String string = getString(i);
        if (string == null) {
            return null;
        }
        try {
            return new URL(string);
        } catch (MalformedURLException unused) {
            throw SQLError.createSQLException(Messages.getString("ResultSet.Malformed_URL____104") + string + "'", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
    }

    @Override // java.sql.ResultSet
    @Deprecated
    public InputStream getUnicodeStream(int i) throws SQLException {
        if (this.isBinaryEncoded) {
            return getNativeBinaryStream(i);
        }
        checkRowPos();
        return getBinaryStream(i);
    }

    @Override // com.mysql.jdbc.ResultSetInternalMethods
    public long getUpdateCount() {
        return this.updateCount;
    }

    @Override // com.mysql.jdbc.ResultSetInternalMethods
    public long getUpdateID() {
        return this.updateId;
    }

    @Override // java.sql.ResultSet
    public SQLWarning getWarnings() throws SQLException {
        SQLWarning sQLWarning;
        synchronized (checkClosed().getConnectionMutex()) {
            sQLWarning = this.warningChain;
        }
        return sQLWarning;
    }

    @Override // com.mysql.jdbc.ResultSetInternalMethods
    public void initializeFromCachedMetaData(CachedResultSetMetaData cachedResultSetMetaData) {
        this.fields = cachedResultSetMetaData.fields;
        this.columnLabelToIndex = cachedResultSetMetaData.columnNameToIndex;
        this.fullColumnNameToIndex = cachedResultSetMetaData.fullColumnNameToIndex;
        this.hasBuiltIndexMapping = true;
    }

    @Override // com.mysql.jdbc.ResultSetInternalMethods
    public void initializeWithMetadata() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            this.rowData.setMetadata(this.fields);
            this.columnToIndexCache = new HashMap();
            if (this.profileSql || this.connection.getUseUsageAdvisor()) {
                this.columnUsed = new boolean[this.fields.length];
                this.pointOfOrigin = LogUtils.findCallingClassAndMethod(new Throwable());
                int i = resultCounter;
                resultCounter = i + 1;
                this.resultId = i;
                this.useUsageAdvisor = this.connection.getUseUsageAdvisor();
                this.eventSink = ProfilerEventHandlerFactory.getInstance(this.connection);
            }
            if (this.connection.getGatherPerformanceMetrics()) {
                this.connection.incrementNumberOfResultSetsCreated();
                HashSet hashSet = new HashSet();
                int i2 = 0;
                while (true) {
                    Field[] fieldArr = this.fields;
                    if (i2 >= fieldArr.length) {
                        break;
                    }
                    Field field = fieldArr[i2];
                    String originalTableName = field.getOriginalTableName();
                    if (originalTableName == null) {
                        originalTableName = field.getTableName();
                    }
                    if (originalTableName != null) {
                        if (this.connection.lowerCaseTableNames()) {
                            originalTableName = originalTableName.toLowerCase();
                        }
                        hashSet.add(originalTableName);
                    }
                    i2++;
                }
                this.connection.reportNumberOfTablesAccessed(hashSet.size());
            }
        }
    }

    @Override // java.sql.ResultSet
    public void insertRow() throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public boolean isAfterLast() throws SQLException {
        boolean zIsAfterLast;
        synchronized (checkClosed().getConnectionMutex()) {
            zIsAfterLast = this.rowData.isAfterLast();
        }
        return zIsAfterLast;
    }

    @Override // java.sql.ResultSet
    public boolean isBeforeFirst() throws SQLException {
        boolean zIsBeforeFirst;
        synchronized (checkClosed().getConnectionMutex()) {
            zIsBeforeFirst = this.rowData.isBeforeFirst();
        }
        return zIsBeforeFirst;
    }

    @Override // com.mysql.jdbc.ResultSetInternalMethods, java.sql.ResultSet
    public boolean isClosed() throws SQLException {
        return this.isClosed;
    }

    @Override // java.sql.ResultSet
    public boolean isFirst() throws SQLException {
        boolean zIsFirst;
        synchronized (checkClosed().getConnectionMutex()) {
            zIsFirst = this.rowData.isFirst();
        }
        return zIsFirst;
    }

    @Override // java.sql.ResultSet
    public boolean isLast() throws SQLException {
        boolean zIsLast;
        synchronized (checkClosed().getConnectionMutex()) {
            zIsLast = this.rowData.isLast();
        }
        return zIsLast;
    }

    @Override // java.sql.ResultSet
    public boolean last() throws SQLException {
        boolean z;
        synchronized (checkClosed().getConnectionMutex()) {
            z = true;
            if (this.rowData.size() == 0) {
                z = false;
            } else {
                if (this.onInsertRow) {
                    this.onInsertRow = false;
                }
                if (this.doingUpdates) {
                    this.doingUpdates = false;
                }
                ResultSetRow resultSetRow = this.thisRow;
                if (resultSetRow != null) {
                    resultSetRow.closeOpenStreams();
                }
                this.rowData.beforeLast();
                this.thisRow = this.rowData.next();
            }
            setRowPositionValidity();
        }
        return z;
    }

    @Override // java.sql.ResultSet
    public void moveToCurrentRow() throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void moveToInsertRow() throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public boolean next() throws SQLException {
        boolean z;
        synchronized (checkClosed().getConnectionMutex()) {
            z = false;
            if (this.onInsertRow) {
                this.onInsertRow = false;
            }
            if (this.doingUpdates) {
                this.doingUpdates = false;
            }
            if (!reallyResult()) {
                throw SQLError.createSQLException(Messages.getString("ResultSet.ResultSet_is_from_UPDATE._No_Data_115"), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
            }
            ResultSetRow resultSetRow = this.thisRow;
            if (resultSetRow != null) {
                resultSetRow.closeOpenStreams();
            }
            if (this.rowData.size() != 0) {
                ResultSetRow next = this.rowData.next();
                this.thisRow = next;
                if (next != null) {
                    clearWarnings();
                    z = true;
                }
            }
            setRowPositionValidity();
        }
        return z;
    }

    @Override // com.mysql.jdbc.ResultSetInternalMethods
    public void populateCachedMetaData(CachedResultSetMetaData cachedResultSetMetaData) throws SQLException {
        cachedResultSetMetaData.fields = this.fields;
        cachedResultSetMetaData.columnNameToIndex = this.columnLabelToIndex;
        cachedResultSetMetaData.fullColumnNameToIndex = this.fullColumnNameToIndex;
        cachedResultSetMetaData.metadata = getMetaData();
    }

    public boolean prev() throws SQLException {
        boolean z;
        synchronized (checkClosed().getConnectionMutex()) {
            int currentRowNumber = this.rowData.getCurrentRowNumber();
            ResultSetRow resultSetRow = this.thisRow;
            if (resultSetRow != null) {
                resultSetRow.closeOpenStreams();
            }
            int i = currentRowNumber - 1;
            z = false;
            if (i >= 0) {
                int i2 = currentRowNumber - 1;
                this.rowData.setCurrentRow(i2);
                this.thisRow = this.rowData.getAt(i2);
                z = true;
            } else if (i == -1) {
                this.rowData.setCurrentRow(currentRowNumber - 1);
                this.thisRow = null;
            }
            setRowPositionValidity();
        }
        return z;
    }

    @Override // java.sql.ResultSet
    public boolean previous() throws SQLException {
        boolean zPrev;
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.onInsertRow) {
                this.onInsertRow = false;
            }
            if (this.doingUpdates) {
                this.doingUpdates = false;
            }
            zPrev = prev();
        }
        return zPrev;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x020f A[Catch: all -> 0x0264, DONT_GENERATE, TryCatch #2 {, blocks: (B:7:0x000c, B:9:0x0010, B:76:0x01c1, B:79:0x01c7, B:80:0x01ca, B:82:0x01ce, B:87:0x01d6, B:90:0x01dc, B:95:0x01e4, B:97:0x01e9, B:99:0x01fc, B:100:0x01fe, B:102:0x020f, B:104:0x0211, B:106:0x0213, B:109:0x021a, B:110:0x021d, B:112:0x0221, B:117:0x0229, B:120:0x022f, B:125:0x0237, B:127:0x023c, B:129:0x024f, B:130:0x0251, B:132:0x0262, B:133:0x0263, B:12:0x0014, B:15:0x001a, B:19:0x002a, B:23:0x0035, B:22:0x0030, B:18:0x0028, B:24:0x005d, B:26:0x0063, B:28:0x0070, B:30:0x007a, B:32:0x0083, B:36:0x0091, B:35:0x008c, B:31:0x0081, B:37:0x00cb, B:39:0x00d1, B:41:0x00d7, B:43:0x00df, B:45:0x00e9, B:47:0x00f2, B:51:0x0100, B:50:0x00fb, B:46:0x00f0, B:52:0x0146, B:54:0x014b, B:56:0x0153, B:57:0x0160, B:59:0x0165, B:64:0x0172, B:63:0x016d, B:65:0x017d, B:67:0x0182, B:71:0x0192, B:75:0x019d, B:74:0x0198, B:70:0x0190), top: B:141:0x000c, inners: #0, #1, #4 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x0211 A[Catch: all -> 0x0264, TryCatch #2 {, blocks: (B:7:0x000c, B:9:0x0010, B:76:0x01c1, B:79:0x01c7, B:80:0x01ca, B:82:0x01ce, B:87:0x01d6, B:90:0x01dc, B:95:0x01e4, B:97:0x01e9, B:99:0x01fc, B:100:0x01fe, B:102:0x020f, B:104:0x0211, B:106:0x0213, B:109:0x021a, B:110:0x021d, B:112:0x0221, B:117:0x0229, B:120:0x022f, B:125:0x0237, B:127:0x023c, B:129:0x024f, B:130:0x0251, B:132:0x0262, B:133:0x0263, B:12:0x0014, B:15:0x001a, B:19:0x002a, B:23:0x0035, B:22:0x0030, B:18:0x0028, B:24:0x005d, B:26:0x0063, B:28:0x0070, B:30:0x007a, B:32:0x0083, B:36:0x0091, B:35:0x008c, B:31:0x0081, B:37:0x00cb, B:39:0x00d1, B:41:0x00d7, B:43:0x00df, B:45:0x00e9, B:47:0x00f2, B:51:0x0100, B:50:0x00fb, B:46:0x00f0, B:52:0x0146, B:54:0x014b, B:56:0x0153, B:57:0x0160, B:59:0x0165, B:64:0x0172, B:63:0x016d, B:65:0x017d, B:67:0x0182, B:71:0x0192, B:75:0x019d, B:74:0x0198, B:70:0x0190), top: B:141:0x000c, inners: #0, #1, #4 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x022d  */
    /* JADX WARN: Code duplicated, block: B:129:0x024f A[Catch: all -> 0x0264, TryCatch #2 {, blocks: (B:7:0x000c, B:9:0x0010, B:76:0x01c1, B:79:0x01c7, B:80:0x01ca, B:82:0x01ce, B:87:0x01d6, B:90:0x01dc, B:95:0x01e4, B:97:0x01e9, B:99:0x01fc, B:100:0x01fe, B:102:0x020f, B:104:0x0211, B:106:0x0213, B:109:0x021a, B:110:0x021d, B:112:0x0221, B:117:0x0229, B:120:0x022f, B:125:0x0237, B:127:0x023c, B:129:0x024f, B:130:0x0251, B:132:0x0262, B:133:0x0263, B:12:0x0014, B:15:0x001a, B:19:0x002a, B:23:0x0035, B:22:0x0030, B:18:0x0028, B:24:0x005d, B:26:0x0063, B:28:0x0070, B:30:0x007a, B:32:0x0083, B:36:0x0091, B:35:0x008c, B:31:0x0081, B:37:0x00cb, B:39:0x00d1, B:41:0x00d7, B:43:0x00df, B:45:0x00e9, B:47:0x00f2, B:51:0x0100, B:50:0x00fb, B:46:0x00f0, B:52:0x0146, B:54:0x014b, B:56:0x0153, B:57:0x0160, B:59:0x0165, B:64:0x0172, B:63:0x016d, B:65:0x017d, B:67:0x0182, B:71:0x0192, B:75:0x019d, B:74:0x0198, B:70:0x0190), top: B:141:0x000c, inners: #0, #1, #4 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x0262 A[Catch: all -> 0x0264, TryCatch #2 {, blocks: (B:7:0x000c, B:9:0x0010, B:76:0x01c1, B:79:0x01c7, B:80:0x01ca, B:82:0x01ce, B:87:0x01d6, B:90:0x01dc, B:95:0x01e4, B:97:0x01e9, B:99:0x01fc, B:100:0x01fe, B:102:0x020f, B:104:0x0211, B:106:0x0213, B:109:0x021a, B:110:0x021d, B:112:0x0221, B:117:0x0229, B:120:0x022f, B:125:0x0237, B:127:0x023c, B:129:0x024f, B:130:0x0251, B:132:0x0262, B:133:0x0263, B:12:0x0014, B:15:0x001a, B:19:0x002a, B:23:0x0035, B:22:0x0030, B:18:0x0028, B:24:0x005d, B:26:0x0063, B:28:0x0070, B:30:0x007a, B:32:0x0083, B:36:0x0091, B:35:0x008c, B:31:0x0081, B:37:0x00cb, B:39:0x00d1, B:41:0x00d7, B:43:0x00df, B:45:0x00e9, B:47:0x00f2, B:51:0x0100, B:50:0x00fb, B:46:0x00f0, B:52:0x0146, B:54:0x014b, B:56:0x0153, B:57:0x0160, B:59:0x0165, B:64:0x0172, B:63:0x016d, B:65:0x017d, B:67:0x0182, B:71:0x0192, B:75:0x019d, B:74:0x0198, B:70:0x0190), top: B:141:0x000c, inners: #0, #1, #4 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x0263 A[Catch: all -> 0x0264, TryCatch #2 {, blocks: (B:7:0x000c, B:9:0x0010, B:76:0x01c1, B:79:0x01c7, B:80:0x01ca, B:82:0x01ce, B:87:0x01d6, B:90:0x01dc, B:95:0x01e4, B:97:0x01e9, B:99:0x01fc, B:100:0x01fe, B:102:0x020f, B:104:0x0211, B:106:0x0213, B:109:0x021a, B:110:0x021d, B:112:0x0221, B:117:0x0229, B:120:0x022f, B:125:0x0237, B:127:0x023c, B:129:0x024f, B:130:0x0251, B:132:0x0262, B:133:0x0263, B:12:0x0014, B:15:0x001a, B:19:0x002a, B:23:0x0035, B:22:0x0030, B:18:0x0028, B:24:0x005d, B:26:0x0063, B:28:0x0070, B:30:0x007a, B:32:0x0083, B:36:0x0091, B:35:0x008c, B:31:0x0081, B:37:0x00cb, B:39:0x00d1, B:41:0x00d7, B:43:0x00df, B:45:0x00e9, B:47:0x00f2, B:51:0x0100, B:50:0x00fb, B:46:0x00f0, B:52:0x0146, B:54:0x014b, B:56:0x0153, B:57:0x0160, B:59:0x0165, B:64:0x0172, B:63:0x016d, B:65:0x017d, B:67:0x0182, B:71:0x0192, B:75:0x019d, B:74:0x0198, B:70:0x0190), top: B:141:0x000c, inners: #0, #1, #4 }] */
    /* JADX WARN: Code duplicated, block: B:142:0x01ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x01c1 A[Catch: all -> 0x0264, TRY_ENTER, TryCatch #2 {, blocks: (B:7:0x000c, B:9:0x0010, B:76:0x01c1, B:79:0x01c7, B:80:0x01ca, B:82:0x01ce, B:87:0x01d6, B:90:0x01dc, B:95:0x01e4, B:97:0x01e9, B:99:0x01fc, B:100:0x01fe, B:102:0x020f, B:104:0x0211, B:106:0x0213, B:109:0x021a, B:110:0x021d, B:112:0x0221, B:117:0x0229, B:120:0x022f, B:125:0x0237, B:127:0x023c, B:129:0x024f, B:130:0x0251, B:132:0x0262, B:133:0x0263, B:12:0x0014, B:15:0x001a, B:19:0x002a, B:23:0x0035, B:22:0x0030, B:18:0x0028, B:24:0x005d, B:26:0x0063, B:28:0x0070, B:30:0x007a, B:32:0x0083, B:36:0x0091, B:35:0x008c, B:31:0x0081, B:37:0x00cb, B:39:0x00d1, B:41:0x00d7, B:43:0x00df, B:45:0x00e9, B:47:0x00f2, B:51:0x0100, B:50:0x00fb, B:46:0x00f0, B:52:0x0146, B:54:0x014b, B:56:0x0153, B:57:0x0160, B:59:0x0165, B:64:0x0172, B:63:0x016d, B:65:0x017d, B:67:0x0182, B:71:0x0192, B:75:0x019d, B:74:0x0198, B:70:0x0190), top: B:141:0x000c, inners: #0, #1, #4 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x01c5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:89:0x01da  */
    /* JADX WARN: Code duplicated, block: B:99:0x01fc A[Catch: all -> 0x0264, TryCatch #2 {, blocks: (B:7:0x000c, B:9:0x0010, B:76:0x01c1, B:79:0x01c7, B:80:0x01ca, B:82:0x01ce, B:87:0x01d6, B:90:0x01dc, B:95:0x01e4, B:97:0x01e9, B:99:0x01fc, B:100:0x01fe, B:102:0x020f, B:104:0x0211, B:106:0x0213, B:109:0x021a, B:110:0x021d, B:112:0x0221, B:117:0x0229, B:120:0x022f, B:125:0x0237, B:127:0x023c, B:129:0x024f, B:130:0x0251, B:132:0x0262, B:133:0x0263, B:12:0x0014, B:15:0x001a, B:19:0x002a, B:23:0x0035, B:22:0x0030, B:18:0x0028, B:24:0x005d, B:26:0x0063, B:28:0x0070, B:30:0x007a, B:32:0x0083, B:36:0x0091, B:35:0x008c, B:31:0x0081, B:37:0x00cb, B:39:0x00d1, B:41:0x00d7, B:43:0x00df, B:45:0x00e9, B:47:0x00f2, B:51:0x0100, B:50:0x00fb, B:46:0x00f0, B:52:0x0146, B:54:0x014b, B:56:0x0153, B:57:0x0160, B:59:0x0165, B:64:0x0172, B:63:0x016d, B:65:0x017d, B:67:0x0182, B:71:0x0192, B:75:0x019d, B:74:0x0198, B:70:0x0190), top: B:141:0x000c, inners: #0, #1, #4 }] */
    @Override // com.mysql.jdbc.ResultSetInternalMethods
    public void realClose(boolean z) throws SQLException {
        SQLException sQLException;
        PreparedStatement preparedStatement;
        StatementImpl statementImpl;
        RowData rowData;
        SQLException sQLException2;
        PreparedStatement preparedStatement2;
        MySQLConnection mySQLConnection = this.connection;
        if (mySQLConnection == null) {
            return;
        }
        synchronized (mySQLConnection.getConnectionMutex()) {
            if (this.isClosed) {
                return;
            }
            try {
                if (!this.useUsageAdvisor) {
                    statementImpl = this.owningStatement;
                    if (statementImpl != null && z) {
                        statementImpl.removeOpenResultSet(this);
                    }
                    rowData = this.rowData;
                    if (rowData != null) {
                        try {
                            rowData.close();
                        } catch (SQLException e) {
                            sQLException2 = e;
                        }
                    }
                    sQLException2 = null;
                    preparedStatement2 = this.statementUsedForFetchingRows;
                    if (preparedStatement2 != null) {
                        try {
                            preparedStatement2.realClose(true, false);
                        } catch (SQLException e2) {
                            if (sQLException2 != null) {
                                sQLException2.setNextException(e2);
                            } else {
                                sQLException2 = e2;
                            }
                        }
                    }
                    this.rowData = null;
                    this.fields = null;
                    this.columnLabelToIndex = null;
                    this.fullColumnNameToIndex = null;
                    this.columnToIndexCache = null;
                    this.eventSink = null;
                    this.warningChain = null;
                    if (!this.retainOwningStatement) {
                        this.owningStatement = null;
                    }
                    this.catalog = null;
                    this.serverInfo = null;
                    this.thisRow = null;
                    this.fastDefaultCal = null;
                    this.fastClientCal = null;
                    this.connection = null;
                    this.isClosed = true;
                    if (sQLException2 == null) {
                        throw sQLException2;
                    }
                    return;
                }
                if (!z) {
                    ProfilerEventHandler profilerEventHandler = this.eventSink;
                    StatementImpl statementImpl2 = this.owningStatement;
                    profilerEventHandler.consumeEvent(new ProfilerEvent((byte) 0, BuildConfig.FLAVOR, statementImpl2 == null ? "N/A" : statementImpl2.currentCatalog, this.connectionId, statementImpl2 == null ? -1 : statementImpl2.getId(), this.resultId, System.currentTimeMillis(), 0L, Constants.MILLIS_I18N, null, this.pointOfOrigin, Messages.getString("ResultSet.ResultSet_implicitly_closed_by_driver")));
                }
                RowData rowData2 = this.rowData;
                if (rowData2 instanceof RowDataStatic) {
                    if (rowData2.size() > this.connection.getResultSetSizeThreshold()) {
                        ProfilerEventHandler profilerEventHandler2 = this.eventSink;
                        StatementImpl statementImpl3 = this.owningStatement;
                        String string = statementImpl3 == null ? Messages.getString("ResultSet.N/A_159") : statementImpl3.currentCatalog;
                        long j = this.connectionId;
                        StatementImpl statementImpl4 = this.owningStatement;
                        profilerEventHandler2.consumeEvent(new ProfilerEvent((byte) 0, BuildConfig.FLAVOR, string, j, statementImpl4 == null ? -1 : statementImpl4.getId(), this.resultId, System.currentTimeMillis(), 0L, Constants.MILLIS_I18N, null, this.pointOfOrigin, Messages.getString("ResultSet.Too_Large_Result_Set", new Object[]{Integer.valueOf(this.rowData.size()), Integer.valueOf(this.connection.getResultSetSizeThreshold())})));
                    }
                    if (!isLast() && !isAfterLast() && this.rowData.size() != 0) {
                        ProfilerEventHandler profilerEventHandler3 = this.eventSink;
                        StatementImpl statementImpl5 = this.owningStatement;
                        String string2 = statementImpl5 == null ? Messages.getString("ResultSet.N/A_159") : statementImpl5.currentCatalog;
                        long j2 = this.connectionId;
                        StatementImpl statementImpl6 = this.owningStatement;
                        profilerEventHandler3.consumeEvent(new ProfilerEvent((byte) 0, BuildConfig.FLAVOR, string2, j2, statementImpl6 == null ? -1 : statementImpl6.getId(), this.resultId, System.currentTimeMillis(), 0L, Constants.MILLIS_I18N, null, this.pointOfOrigin, Messages.getString("ResultSet.Possible_incomplete_traversal_of_result_set", new Object[]{Integer.valueOf(getRow()), Integer.valueOf(this.rowData.size())})));
                    }
                }
                if (this.columnUsed.length <= 0 || this.rowData.wasEmpty()) {
                    statementImpl = this.owningStatement;
                    if (statementImpl != null) {
                        statementImpl.removeOpenResultSet(this);
                    }
                    rowData = this.rowData;
                    if (rowData != null) {
                        rowData.close();
                    }
                    sQLException2 = null;
                    preparedStatement2 = this.statementUsedForFetchingRows;
                    if (preparedStatement2 != null) {
                        preparedStatement2.realClose(true, false);
                    }
                    this.rowData = null;
                    this.fields = null;
                    this.columnLabelToIndex = null;
                    this.fullColumnNameToIndex = null;
                    this.columnToIndexCache = null;
                    this.eventSink = null;
                    this.warningChain = null;
                    if (!this.retainOwningStatement) {
                        this.owningStatement = null;
                    }
                    this.catalog = null;
                    this.serverInfo = null;
                    this.thisRow = null;
                    this.fastDefaultCal = null;
                    this.fastClientCal = null;
                    this.connection = null;
                    this.isClosed = true;
                    if (sQLException2 == null) {
                        throw sQLException2;
                    }
                    return;
                }
                StringBuilder sb = new StringBuilder(Messages.getString("ResultSet.The_following_columns_were_never_referenced"));
                boolean z2 = false;
                int i = 0;
                while (true) {
                    boolean[] zArr = this.columnUsed;
                    if (i >= zArr.length) {
                        break;
                    }
                    if (!zArr[i]) {
                        if (z2) {
                            sb.append(", ");
                        } else {
                            z2 = true;
                        }
                        sb.append(this.fields[i].getFullName());
                    }
                    i++;
                }
                if (!z2) {
                    statementImpl = this.owningStatement;
                    if (statementImpl != null) {
                        statementImpl.removeOpenResultSet(this);
                    }
                    rowData = this.rowData;
                    if (rowData != null) {
                        rowData.close();
                    }
                    sQLException2 = null;
                    preparedStatement2 = this.statementUsedForFetchingRows;
                    if (preparedStatement2 != null) {
                        preparedStatement2.realClose(true, false);
                    }
                    this.rowData = null;
                    this.fields = null;
                    this.columnLabelToIndex = null;
                    this.fullColumnNameToIndex = null;
                    this.columnToIndexCache = null;
                    this.eventSink = null;
                    this.warningChain = null;
                    if (!this.retainOwningStatement) {
                        this.owningStatement = null;
                    }
                    this.catalog = null;
                    this.serverInfo = null;
                    this.thisRow = null;
                    this.fastDefaultCal = null;
                    this.fastClientCal = null;
                    this.connection = null;
                    this.isClosed = true;
                    if (sQLException2 == null) {
                        throw sQLException2;
                    }
                    return;
                }
                ProfilerEventHandler profilerEventHandler4 = this.eventSink;
                StatementImpl statementImpl7 = this.owningStatement;
                profilerEventHandler4.consumeEvent(new ProfilerEvent((byte) 0, BuildConfig.FLAVOR, statementImpl7 == null ? "N/A" : statementImpl7.currentCatalog, this.connectionId, statementImpl7 == null ? -1 : statementImpl7.getId(), 0, System.currentTimeMillis(), 0L, Constants.MILLIS_I18N, null, this.pointOfOrigin, sb.toString()));
                statementImpl = this.owningStatement;
                if (statementImpl != null) {
                    statementImpl.removeOpenResultSet(this);
                }
                rowData = this.rowData;
                if (rowData != null) {
                    rowData.close();
                }
                sQLException2 = null;
                preparedStatement2 = this.statementUsedForFetchingRows;
                if (preparedStatement2 != null) {
                    preparedStatement2.realClose(true, false);
                }
                this.rowData = null;
                this.fields = null;
                this.columnLabelToIndex = null;
                this.fullColumnNameToIndex = null;
                this.columnToIndexCache = null;
                this.eventSink = null;
                this.warningChain = null;
                if (!this.retainOwningStatement) {
                    this.owningStatement = null;
                }
                this.catalog = null;
                this.serverInfo = null;
                this.thisRow = null;
                this.fastDefaultCal = null;
                this.fastClientCal = null;
                this.connection = null;
                this.isClosed = true;
                if (sQLException2 == null) {
                    throw sQLException2;
                }
                return;
            } catch (Throwable th) {
                StatementImpl statementImpl8 = this.owningStatement;
                if (statementImpl8 != null && z) {
                    statementImpl8.removeOpenResultSet(this);
                }
                RowData rowData3 = this.rowData;
                if (rowData3 != null) {
                    try {
                        rowData3.close();
                    } catch (SQLException e3) {
                        sQLException = e3;
                        preparedStatement = this.statementUsedForFetchingRows;
                        if (preparedStatement != null) {
                            try {
                                preparedStatement.realClose(true, false);
                            } catch (SQLException e4) {
                                if (sQLException != null) {
                                    sQLException.setNextException(e4);
                                } else {
                                    sQLException = e4;
                                }
                            }
                        }
                        this.rowData = null;
                        this.fields = null;
                        this.columnLabelToIndex = null;
                        this.fullColumnNameToIndex = null;
                        this.columnToIndexCache = null;
                        this.eventSink = null;
                        this.warningChain = null;
                        if (!this.retainOwningStatement) {
                            this.owningStatement = null;
                        }
                        this.catalog = null;
                        this.serverInfo = null;
                        this.thisRow = null;
                        this.fastDefaultCal = null;
                        this.fastClientCal = null;
                        this.connection = null;
                        this.isClosed = true;
                        if (sQLException != null) {
                            throw th;
                        }
                        throw sQLException;
                    }
                }
                sQLException = null;
                preparedStatement = this.statementUsedForFetchingRows;
                if (preparedStatement != null) {
                    preparedStatement.realClose(true, false);
                }
                this.rowData = null;
                this.fields = null;
                this.columnLabelToIndex = null;
                this.fullColumnNameToIndex = null;
                this.columnToIndexCache = null;
                this.eventSink = null;
                this.warningChain = null;
                if (!this.retainOwningStatement) {
                    this.owningStatement = null;
                }
                this.catalog = null;
                this.serverInfo = null;
                this.thisRow = null;
                this.fastDefaultCal = null;
                this.fastClientCal = null;
                this.connection = null;
                this.isClosed = true;
                if (sQLException != null) {
                    throw th;
                }
                throw sQLException;
            }
            throw th;
        }
    }

    @Override // com.mysql.jdbc.ResultSetInternalMethods
    public boolean reallyResult() {
        if (this.rowData != null) {
            return true;
        }
        return this.reallyResult;
    }

    @Override // com.mysql.jdbc.ResultSetInternalMethods
    public void redefineFieldsForDBMD(Field[] fieldArr) {
        this.fields = fieldArr;
        int i = 0;
        while (true) {
            Field[] fieldArr2 = this.fields;
            if (i >= fieldArr2.length) {
                return;
            }
            fieldArr2[i].setUseOldNameMetadata(true);
            this.fields[i].setConnection(this.connection);
            i++;
        }
    }

    @Override // java.sql.ResultSet
    public void refreshRow() throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public boolean relative(int i) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            boolean z = false;
            if (this.rowData.size() == 0) {
                setRowPositionValidity();
                return false;
            }
            ResultSetRow resultSetRow = this.thisRow;
            if (resultSetRow != null) {
                resultSetRow.closeOpenStreams();
            }
            this.rowData.moveRowRelative(i);
            RowData rowData = this.rowData;
            this.thisRow = rowData.getAt(rowData.getCurrentRowNumber());
            setRowPositionValidity();
            if (!this.rowData.isAfterLast() && !this.rowData.isBeforeFirst()) {
                z = true;
            }
            return z;
        }
    }

    @Override // java.sql.ResultSet
    public boolean rowDeleted() throws SQLException {
        throw SQLError.createSQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public boolean rowInserted() throws SQLException {
        throw SQLError.createSQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public boolean rowUpdated() throws SQLException {
        throw SQLError.createSQLFeatureNotSupportedException();
    }

    public void setBinaryEncoded() {
        this.isBinaryEncoded = true;
    }

    @Override // java.sql.ResultSet
    public void setFetchDirection(int i) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            try {
                if (i != 1000 && i != 1001 && i != 1002) {
                    throw SQLError.createSQLException(Messages.getString("ResultSet.Illegal_value_for_fetch_direction_64"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                }
                this.fetchDirection = i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.sql.ResultSet
    public void setFetchSize(int i) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            try {
                if (i < 0) {
                    throw SQLError.createSQLException(Messages.getString("ResultSet.Value_must_be_between_0_and_getMaxRows()_66"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                }
                this.fetchSize = i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.mysql.jdbc.ResultSetInternalMethods
    public void setFirstCharOfQuery(char c) {
        try {
            synchronized (checkClosed().getConnectionMutex()) {
                this.firstCharOfQuery = c;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void setNextResultSet(ResultSetInternalMethods resultSetInternalMethods) {
        this.nextResultSet = resultSetInternalMethods;
    }

    @Override // com.mysql.jdbc.ResultSetInternalMethods
    public void setOwningStatement(StatementImpl statementImpl) {
        try {
            synchronized (checkClosed().getConnectionMutex()) {
                this.owningStatement = statementImpl;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void setResultSetConcurrency(int i) {
        try {
            synchronized (checkClosed().getConnectionMutex()) {
                this.resultSetConcurrency = i;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void setResultSetType(int i) {
        try {
            synchronized (checkClosed().getConnectionMutex()) {
                this.resultSetType = i;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setServerInfo(String str) {
        try {
            synchronized (checkClosed().getConnectionMutex()) {
                this.serverInfo = str;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.mysql.jdbc.ResultSetInternalMethods
    public synchronized void setStatementUsedForFetchingRows(PreparedStatement preparedStatement) {
        try {
            synchronized (checkClosed().getConnectionMutex()) {
                this.statementUsedForFetchingRows = preparedStatement;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.mysql.jdbc.ResultSetInternalMethods
    public synchronized void setWrapperStatement(java.sql.Statement statement) {
        try {
            synchronized (checkClosed().getConnectionMutex()) {
                this.wrapperStatement = statement;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        if (this.reallyResult) {
            return super.toString();
        }
        return "Result set representing update count of " + this.updateCount;
    }

    @Override // java.sql.ResultSet
    public void updateArray(int i, Array array) throws SQLException {
        throw SQLError.createSQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public void updateAsciiStream(int i, InputStream inputStream, int i2) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateBigDecimal(int i, BigDecimal bigDecimal) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateBinaryStream(int i, InputStream inputStream, int i2) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateBlob(int i, java.sql.Blob blob) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateBoolean(int i, boolean z) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateByte(int i, byte b) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateBytes(int i, byte[] bArr) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateCharacterStream(int i, Reader reader, int i2) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateClob(int i, java.sql.Clob clob) throws SQLException {
        throw SQLError.createSQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public void updateDate(int i, Date date) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateDouble(int i, double d) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateFloat(int i, float f) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateInt(int i, int i2) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateLong(int i, long j) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateNull(int i) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateObject(int i, Object obj) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateRef(int i, Ref ref) throws SQLException {
        throw SQLError.createSQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public void updateRow() throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateShort(int i, short s) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateString(int i, String str) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateTime(int i, Time time) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateTimestamp(int i, Timestamp timestamp) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public boolean wasNull() throws SQLException {
        return this.wasNullFlag;
    }

    private long getLong(int i, boolean z) throws SQLException {
        checkRowPos();
        checkColumnBounds(i);
        if (this.isBinaryEncoded) {
            return getNativeLong(i, z, true);
        }
        int i2 = i - 1;
        if (this.thisRow.isNull(i2)) {
            this.wasNullFlag = true;
            return 0L;
        }
        this.wasNullFlag = false;
        if (this.fields[i2].getMysqlType() == 16) {
            return getNumericRepresentationOfSQLBitType(i);
        }
        if (this.useFastIntParsing) {
            if (this.thisRow.length(i2) == 0) {
                return convertToZeroWithEmptyCheck();
            }
            if (!this.thisRow.isFloatingPointNumber(i2)) {
                try {
                    try {
                        return getLongWithOverflowCheck(i2, z);
                    } catch (NumberFormatException unused) {
                        throw SQLError.createSQLException(Messages.getString("ResultSet.Invalid_value_for_getLong()_-____79") + this.thisRow.getString(i2, this.fields[i2].getEncoding(), this.connection) + "'", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                    }
                } catch (NumberFormatException unused2) {
                    return parseLongAsDouble(i2, this.thisRow.getString(i2, this.fields[i2].getEncoding(), this.connection));
                }
            }
        }
        String str = null;
        try {
            String string = getString(i);
            if (string == null) {
                return 0L;
            }
            try {
                if (string.length() == 0) {
                    return convertToZeroWithEmptyCheck();
                }
                return (string.indexOf("e") == -1 && string.indexOf("E") == -1) ? parseLongWithOverflowCheck(i2, null, string, z) : parseLongAsDouble(i2, string);
            } catch (NumberFormatException unused3) {
                str = string;
                try {
                    return parseLongAsDouble(i2, str);
                } catch (NumberFormatException unused4) {
                    throw SQLError.createSQLException(Messages.getString("ResultSet.Invalid_value_for_getLong()_-____79") + str + "'", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                }
            }
        } catch (NumberFormatException unused5) {
        }
    }

    public byte[] getBytes(int i, boolean z) throws SQLException {
        if (this.isBinaryEncoded) {
            return getNativeBytes(i, z);
        }
        checkRowPos();
        checkColumnBounds(i);
        int i2 = i - 1;
        if (this.thisRow.isNull(i2)) {
            this.wasNullFlag = true;
        } else {
            this.wasNullFlag = false;
        }
        if (this.wasNullFlag) {
            return null;
        }
        return this.thisRow.getColumnValue(i2);
    }

    @Override // java.sql.ResultSet
    public Date getDate(int i, Calendar calendar) throws SQLException {
        if (this.isBinaryEncoded) {
            return getNativeDate(i, calendar);
        }
        if (!this.useFastDateParsing) {
            String stringInternal = getStringInternal(i, false);
            if (stringInternal == null) {
                return null;
            }
            return getDateFromString(stringInternal, i, calendar);
        }
        checkColumnBounds(i);
        int i2 = i - 1;
        Date dateFast = this.thisRow.getDateFast(i2, this.connection, this, calendar);
        if (this.thisRow.isNull(i2) || dateFast == null) {
            this.wasNullFlag = true;
            return null;
        }
        this.wasNullFlag = false;
        return dateFast;
    }

    public double getDoubleInternal(String str, int i) throws SQLException {
        if (str == null) {
            return 0.0d;
        }
        try {
            if (str.length() == 0) {
                return convertToZeroWithEmptyCheck();
            }
            double d = Double.parseDouble(str);
            if (!this.useStrictFloatingPoint) {
                return d;
            }
            if (d == 2.147483648E9d) {
                return 2.147483647E9d;
            }
            if (d == 1.0000000036275E-15d) {
                return 1.0E-15d;
            }
            if (d == 9.999999869911E14d) {
                return 9.99999999999999E14d;
            }
            if (d == 1.4012984643248E-45d || d == 1.4013E-45d) {
                return 1.4E-45d;
            }
            if (d != 3.4028234663853E37d) {
                if (d == -2.14748E9d) {
                    return -2.147483648E9d;
                }
                if (d != 3.40282E37d) {
                    return d;
                }
            }
            return 3.4028235E37d;
        } catch (NumberFormatException unused) {
            if (this.fields[i - 1].getMysqlType() == 16) {
                return getNumericRepresentationOfSQLBitType(i);
            }
            throw SQLError.createSQLException(Messages.getString("ResultSet.Bad_format_for_number", new Object[]{str, Integer.valueOf(i)}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
    }

    public byte getNativeByte(int i, boolean z) throws SQLException {
        int i2;
        checkRowPos();
        checkColumnBounds(i);
        byte[] columnValue = this.thisRow.getColumnValue(i - 1);
        if (columnValue == null) {
            this.wasNullFlag = true;
            return (byte) 0;
        }
        this.wasNullFlag = false;
        int i3 = i - 1;
        Field field = this.fields[i3];
        int mysqlType = field.getMysqlType();
        if (mysqlType == 1) {
            byte b = columnValue[0];
            if (!field.isUnsigned()) {
                i2 = b;
                return b;
            }
            if (b < 0) {
                i2 = b + 256;
            }
            short s = (short) i2;
            if (z && this.jdbcCompliantTruncationForReads && s > 127) {
                throwRangeException(String.valueOf((int) s), i3 + 1, -6);
            }
            return (byte) s;
        }
        if (mysqlType != 2) {
            if (mysqlType != 3) {
                if (mysqlType == 4) {
                    int i4 = i3 + 1;
                    float nativeFloat = getNativeFloat(i4);
                    if (z && this.jdbcCompliantTruncationForReads && (nativeFloat < -128.0f || nativeFloat > 127.0f)) {
                        throwRangeException(String.valueOf(nativeFloat), i4, -6);
                    }
                    return (byte) nativeFloat;
                }
                if (mysqlType == 5) {
                    int i5 = i3 + 1;
                    double nativeDouble = getNativeDouble(i5);
                    if (z && this.jdbcCompliantTruncationForReads && (nativeDouble < -128.0d || nativeDouble > 127.0d)) {
                        throwRangeException(String.valueOf(nativeDouble), i5, -6);
                    }
                    return (byte) nativeDouble;
                }
                if (mysqlType == 8) {
                    int i6 = i3 + 1;
                    long nativeLong = getNativeLong(i6, false, true);
                    if (z && this.jdbcCompliantTruncationForReads && (nativeLong < -128 || nativeLong > 127)) {
                        throwRangeException(String.valueOf(nativeLong), i6, -6);
                    }
                    return (byte) nativeLong;
                }
                if (mysqlType != 9) {
                    if (mysqlType != 13) {
                        if (mysqlType != 16) {
                            if (this.useUsageAdvisor) {
                                issueConversionViaParsingWarning("getByte()", i3, this.thisRow.getColumnValue(i3 - 1), this.fields[i3], new int[]{5, 1, 2, 3, 8, 4});
                            }
                            int i7 = i3 + 1;
                            return getByteFromString(getNativeString(i7), i7);
                        }
                        int i8 = i3 + 1;
                        long numericRepresentationOfSQLBitType = getNumericRepresentationOfSQLBitType(i8);
                        if (z && this.jdbcCompliantTruncationForReads && (numericRepresentationOfSQLBitType < -128 || numericRepresentationOfSQLBitType > 127)) {
                            throwRangeException(String.valueOf(numericRepresentationOfSQLBitType), i8, -6);
                        }
                        return (byte) numericRepresentationOfSQLBitType;
                    }
                }
            }
            int i9 = i3 + 1;
            int nativeInt = getNativeInt(i9, false);
            if (z && this.jdbcCompliantTruncationForReads && (nativeInt < -128 || nativeInt > 127)) {
                throwRangeException(String.valueOf(nativeInt), i9, -6);
            }
            return (byte) nativeInt;
        }
        int i10 = i3 + 1;
        short nativeShort = getNativeShort(i10);
        if (z && this.jdbcCompliantTruncationForReads && (nativeShort < -128 || nativeShort > 127)) {
            throwRangeException(String.valueOf((int) nativeShort), i10, -6);
        }
        return (byte) nativeShort;
    }

    public Date getNativeDate(int i, Calendar calendar) throws SQLException {
        Date nativeDate;
        checkRowPos();
        checkColumnBounds(i);
        int i2 = i - 1;
        int mysqlType = this.fields[i2].getMysqlType();
        if (mysqlType == 10) {
            nativeDate = this.thisRow.getNativeDate(i2, this.connection, this, calendar);
        } else {
            TimeZone timeZone = calendar != null ? calendar.getTimeZone() : getDefaultTimeZone();
            nativeDate = (Date) this.thisRow.getNativeDateTimeValue(i2, null, 91, mysqlType, timeZone, (timeZone == null || timeZone.equals(getDefaultTimeZone())) ? false : true, this.connection, this);
        }
        if (nativeDate == null) {
            this.wasNullFlag = true;
            return null;
        }
        this.wasNullFlag = false;
        return nativeDate;
    }

    public int getNativeInt(int i, boolean z) throws SQLException {
        checkRowPos();
        checkColumnBounds(i);
        int i2 = i - 1;
        if (this.thisRow.isNull(i2)) {
            this.wasNullFlag = true;
            return 0;
        }
        this.wasNullFlag = false;
        Field field = this.fields[i2];
        int mysqlType = field.getMysqlType();
        if (mysqlType == 1) {
            byte nativeByte = getNativeByte(i2 + 1, false);
            return (!field.isUnsigned() || nativeByte >= 0) ? nativeByte : nativeByte + 256;
        }
        if (mysqlType != 2) {
            if (mysqlType != 3) {
                if (mysqlType == 4) {
                    int i3 = i2 + 1;
                    double nativeFloat = getNativeFloat(i3);
                    if (z && this.jdbcCompliantTruncationForReads && (nativeFloat < -2.147483648E9d || nativeFloat > 2.147483647E9d)) {
                        throwRangeException(String.valueOf(nativeFloat), i3, 4);
                    }
                    return (int) nativeFloat;
                }
                if (mysqlType == 5) {
                    int i4 = i2 + 1;
                    double nativeDouble = getNativeDouble(i4);
                    if (z && this.jdbcCompliantTruncationForReads && (nativeDouble < -2.147483648E9d || nativeDouble > 2.147483647E9d)) {
                        throwRangeException(String.valueOf(nativeDouble), i4, 4);
                    }
                    return (int) nativeDouble;
                }
                if (mysqlType == 8) {
                    int i5 = i2 + 1;
                    long nativeLong = getNativeLong(i5, false, true);
                    if (z && this.jdbcCompliantTruncationForReads && (nativeLong < -2147483648L || nativeLong > 2147483647L)) {
                        throwRangeException(String.valueOf(nativeLong), i5, 4);
                    }
                    return (int) nativeLong;
                }
                if (mysqlType != 9) {
                    if (mysqlType != 13) {
                        if (mysqlType != 16) {
                            int i6 = i2 + 1;
                            String nativeString = getNativeString(i6);
                            if (this.useUsageAdvisor) {
                                issueConversionViaParsingWarning("getInt()", i2, nativeString, this.fields[i2], new int[]{5, 1, 2, 3, 8, 4});
                            }
                            return getIntFromString(nativeString, i6);
                        }
                        int i7 = i2 + 1;
                        long numericRepresentationOfSQLBitType = getNumericRepresentationOfSQLBitType(i7);
                        if (z && this.jdbcCompliantTruncationForReads && (numericRepresentationOfSQLBitType < -2147483648L || numericRepresentationOfSQLBitType > 2147483647L)) {
                            throwRangeException(String.valueOf(numericRepresentationOfSQLBitType), i7, 4);
                        }
                        return (int) numericRepresentationOfSQLBitType;
                    }
                }
            }
            int nativeInt = this.thisRow.getNativeInt(i2);
            if (!field.isUnsigned()) {
                return nativeInt;
            }
            long j = nativeInt;
            if (nativeInt < 0) {
                j += 4294967296L;
            }
            if (z && this.jdbcCompliantTruncationForReads && j > 2147483647L) {
                throwRangeException(String.valueOf(j), i2 + 1, 4);
            }
            return (int) j;
        }
        short nativeShort = getNativeShort(i2 + 1, false);
        return (!field.isUnsigned() || nativeShort >= 0) ? nativeShort : nativeShort + ISelectionInterface.HELD_FIRST_WIDGET;
    }

    public long getNativeLong(int i, boolean z, boolean z2) throws SQLException {
        checkRowPos();
        checkColumnBounds(i);
        int i2 = i - 1;
        if (this.thisRow.isNull(i2)) {
            this.wasNullFlag = true;
            return 0L;
        }
        this.wasNullFlag = false;
        Field field = this.fields[i2];
        int mysqlType = field.getMysqlType();
        if (mysqlType == 1) {
            return !field.isUnsigned() ? getNativeByte(i2 + 1) : getNativeInt(i2 + 1);
        }
        if (mysqlType == 2) {
            return !field.isUnsigned() ? getNativeShort(i2 + 1) : getNativeInt(i2 + 1, false);
        }
        if (mysqlType != 3) {
            if (mysqlType == 4) {
                int i3 = i2 + 1;
                double nativeFloat = getNativeFloat(i3);
                if (z && this.jdbcCompliantTruncationForReads && (nativeFloat < -9.223372036854776E18d || nativeFloat > 9.223372036854776E18d)) {
                    throwRangeException(String.valueOf(nativeFloat), i3, -5);
                }
                return (long) nativeFloat;
            }
            if (mysqlType == 5) {
                int i4 = i2 + 1;
                double nativeDouble = getNativeDouble(i4);
                if (z && this.jdbcCompliantTruncationForReads && (nativeDouble < -9.223372036854776E18d || nativeDouble > 9.223372036854776E18d)) {
                    throwRangeException(String.valueOf(nativeDouble), i4, -5);
                }
                return (long) nativeDouble;
            }
            if (mysqlType == 8) {
                long nativeLong = this.thisRow.getNativeLong(i2);
                if (!field.isUnsigned() || !z2) {
                    return nativeLong;
                }
                BigInteger bigIntegerConvertLongToUlong = convertLongToUlong(nativeLong);
                if (z && this.jdbcCompliantTruncationForReads && (bigIntegerConvertLongToUlong.compareTo(new BigInteger(String.valueOf(RecyclerView.FOREVER_NS))) > 0 || bigIntegerConvertLongToUlong.compareTo(new BigInteger(String.valueOf(Long.MIN_VALUE))) < 0)) {
                    throwRangeException(bigIntegerConvertLongToUlong.toString(), i2 + 1, -5);
                }
                return getLongFromString(bigIntegerConvertLongToUlong.toString(), i2);
            }
            if (mysqlType != 9) {
                if (mysqlType == 13) {
                    return getNativeShort(i2 + 1);
                }
                if (mysqlType == 16) {
                    return getNumericRepresentationOfSQLBitType(i2 + 1);
                }
                int i5 = i2 + 1;
                String nativeString = getNativeString(i5);
                if (this.useUsageAdvisor) {
                    issueConversionViaParsingWarning("getLong()", i2, nativeString, this.fields[i2], new int[]{5, 1, 2, 3, 8, 4});
                }
                return getLongFromString(nativeString, i5);
            }
        }
        int nativeInt = getNativeInt(i2 + 1, false);
        return (!field.isUnsigned() || nativeInt >= 0) ? nativeInt : ((long) nativeInt) + 4294967296L;
    }

    public short getNativeShort(int i, boolean z) throws SQLException {
        checkRowPos();
        checkColumnBounds(i);
        int i2 = i - 1;
        if (this.thisRow.isNull(i2)) {
            this.wasNullFlag = true;
            return (short) 0;
        }
        this.wasNullFlag = false;
        Field field = this.fields[i2];
        int mysqlType = field.getMysqlType();
        if (mysqlType == 1) {
            byte nativeByte = getNativeByte(i2 + 1, false);
            return (!field.isUnsigned() || nativeByte >= 0) ? nativeByte : (short) (nativeByte + 256);
        }
        if (mysqlType != 2) {
            if (mysqlType != 3) {
                if (mysqlType == 4) {
                    int i3 = i2 + 1;
                    float nativeFloat = getNativeFloat(i3);
                    if (z && this.jdbcCompliantTruncationForReads && (nativeFloat < -32768.0f || nativeFloat > 32767.0f)) {
                        throwRangeException(String.valueOf(nativeFloat), i3, 5);
                    }
                    return (short) nativeFloat;
                }
                if (mysqlType == 5) {
                    int i4 = i2 + 1;
                    double nativeDouble = getNativeDouble(i4);
                    if (z && this.jdbcCompliantTruncationForReads && (nativeDouble < -32768.0d || nativeDouble > 32767.0d)) {
                        throwRangeException(String.valueOf(nativeDouble), i4, 5);
                    }
                    return (short) nativeDouble;
                }
                if (mysqlType == 8) {
                    int i5 = i2 + 1;
                    long nativeLong = getNativeLong(i5, false, false);
                    if (!field.isUnsigned()) {
                        if (z && this.jdbcCompliantTruncationForReads && (nativeLong < -32768 || nativeLong > 32767)) {
                            throwRangeException(String.valueOf(nativeLong), i5, 5);
                        }
                        return (short) nativeLong;
                    }
                    BigInteger bigIntegerConvertLongToUlong = convertLongToUlong(nativeLong);
                    if (z && this.jdbcCompliantTruncationForReads && (bigIntegerConvertLongToUlong.compareTo(new BigInteger(String.valueOf(32767))) > 0 || bigIntegerConvertLongToUlong.compareTo(new BigInteger(String.valueOf(-32768))) < 0)) {
                        throwRangeException(bigIntegerConvertLongToUlong.toString(), i5, 5);
                    }
                    return (short) getIntFromString(bigIntegerConvertLongToUlong.toString(), i5);
                }
                if (mysqlType != 9) {
                    if (mysqlType != 13) {
                        if (mysqlType != 16) {
                            int i6 = i2 + 1;
                            String nativeString = getNativeString(i6);
                            if (this.useUsageAdvisor) {
                                issueConversionViaParsingWarning("getShort()", i2, nativeString, this.fields[i2], new int[]{5, 1, 2, 3, 8, 4});
                            }
                            return getShortFromString(nativeString, i6);
                        }
                        int i7 = i2 + 1;
                        long numericRepresentationOfSQLBitType = getNumericRepresentationOfSQLBitType(i7);
                        if (z && this.jdbcCompliantTruncationForReads && (numericRepresentationOfSQLBitType < -32768 || numericRepresentationOfSQLBitType > 32767)) {
                            throwRangeException(String.valueOf(numericRepresentationOfSQLBitType), i7, 5);
                        }
                        return (short) numericRepresentationOfSQLBitType;
                    }
                }
            }
            if (field.isUnsigned()) {
                int i8 = i2 + 1;
                long nativeLong2 = getNativeLong(i8, false, true);
                if (z && this.jdbcCompliantTruncationForReads && nativeLong2 > 32767) {
                    throwRangeException(String.valueOf(nativeLong2), i8, 5);
                }
                return (short) nativeLong2;
            }
            int i9 = i2 + 1;
            int nativeInt = getNativeInt(i9, false);
            if ((z && this.jdbcCompliantTruncationForReads && nativeInt > 32767) || nativeInt < -32768) {
                throwRangeException(String.valueOf(nativeInt), i9, 5);
            }
            return (short) nativeInt;
        }
        short nativeShort = this.thisRow.getNativeShort(i2);
        if (!field.isUnsigned()) {
            return nativeShort;
        }
        int i10 = 65535 & nativeShort;
        if (z && this.jdbcCompliantTruncationForReads && i10 > 32767) {
            throwRangeException(String.valueOf(i10), i2 + 1, 5);
        }
        return (short) i10;
    }

    @Override // java.sql.ResultSet
    public Time getTime(int i, Calendar calendar) throws SQLException {
        return getTimeInternal(i, calendar, calendar != null ? calendar.getTimeZone() : getDefaultTimeZone(), true);
    }

    @Override // java.sql.ResultSet
    public Timestamp getTimestamp(int i, Calendar calendar) throws SQLException {
        return getTimestampInternal(i, calendar, calendar != null ? calendar.getTimeZone() : getDefaultTimeZone(), true);
    }

    @Override // java.sql.ResultSet
    public void updateArray(String str, Array array) throws SQLException {
        throw SQLError.createSQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public void updateAsciiStream(String str, InputStream inputStream, int i) throws SQLException {
        updateAsciiStream(findColumn(str), inputStream, i);
    }

    @Override // java.sql.ResultSet
    public void updateBigDecimal(String str, BigDecimal bigDecimal) throws SQLException {
        updateBigDecimal(findColumn(str), bigDecimal);
    }

    @Override // java.sql.ResultSet
    public void updateBinaryStream(String str, InputStream inputStream, int i) throws SQLException {
        updateBinaryStream(findColumn(str), inputStream, i);
    }

    @Override // java.sql.ResultSet
    public void updateBlob(String str, java.sql.Blob blob) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateBoolean(String str, boolean z) throws SQLException {
        updateBoolean(findColumn(str), z);
    }

    @Override // java.sql.ResultSet
    public void updateByte(String str, byte b) throws SQLException {
        updateByte(findColumn(str), b);
    }

    @Override // java.sql.ResultSet
    public void updateBytes(String str, byte[] bArr) throws SQLException {
        updateBytes(findColumn(str), bArr);
    }

    @Override // java.sql.ResultSet
    public void updateCharacterStream(String str, Reader reader, int i) throws SQLException {
        updateCharacterStream(findColumn(str), reader, i);
    }

    @Override // java.sql.ResultSet
    public void updateClob(String str, java.sql.Clob clob) throws SQLException {
        updateClob(findColumn(str), clob);
    }

    @Override // java.sql.ResultSet
    public void updateDate(String str, Date date) throws SQLException {
        updateDate(findColumn(str), date);
    }

    @Override // java.sql.ResultSet
    public void updateDouble(String str, double d) throws SQLException {
        updateDouble(findColumn(str), d);
    }

    @Override // java.sql.ResultSet
    public void updateFloat(String str, float f) throws SQLException {
        updateFloat(findColumn(str), f);
    }

    @Override // java.sql.ResultSet
    public void updateInt(String str, int i) throws SQLException {
        updateInt(findColumn(str), i);
    }

    @Override // java.sql.ResultSet
    public void updateLong(String str, long j) throws SQLException {
        updateLong(findColumn(str), j);
    }

    @Override // java.sql.ResultSet
    public void updateNull(String str) throws SQLException {
        updateNull(findColumn(str));
    }

    @Override // java.sql.ResultSet
    public void updateObject(int i, Object obj, int i2) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateRef(String str, Ref ref) throws SQLException {
        throw SQLError.createSQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public void updateShort(String str, short s) throws SQLException {
        updateShort(findColumn(str), s);
    }

    @Override // java.sql.ResultSet
    public void updateString(String str, String str2) throws SQLException {
        updateString(findColumn(str), str2);
    }

    @Override // java.sql.ResultSet
    public void updateTime(String str, Time time) throws SQLException {
        updateTime(findColumn(str), time);
    }

    @Override // java.sql.ResultSet
    public void updateTimestamp(String str, Timestamp timestamp) throws SQLException {
        updateTimestamp(findColumn(str), timestamp);
    }

    @Override // java.sql.ResultSet
    public Array getArray(String str) throws SQLException {
        return getArray(findColumn(str));
    }

    @Override // java.sql.ResultSet
    public Ref getRef(String str) throws SQLException {
        return getRef(findColumn(str));
    }

    @Override // java.sql.ResultSet
    public Time getTime(String str) throws SQLException {
        return getTime(findColumn(str));
    }

    @Override // java.sql.ResultSet
    public Timestamp getTimestamp(String str) throws SQLException {
        return getTimestamp(findColumn(str));
    }

    @Override // java.sql.ResultSet
    public void updateObject(String str, Object obj) throws SQLException {
        updateObject(findColumn(str), obj);
    }

    public static ResultSetImpl getInstance(String str, Field[] fieldArr, RowData rowData, MySQLConnection mySQLConnection, StatementImpl statementImpl, boolean z) throws SQLException {
        if (Util.isJdbc4()) {
            return !z ? (ResultSetImpl) Util.handleNewInstance(JDBC_4_RS_5_ARG_CTOR, new Object[]{str, fieldArr, rowData, mySQLConnection, statementImpl}, mySQLConnection.getExceptionInterceptor()) : (ResultSetImpl) Util.handleNewInstance(JDBC_4_UPD_RS_5_ARG_CTOR, new Object[]{str, fieldArr, rowData, mySQLConnection, statementImpl}, mySQLConnection.getExceptionInterceptor());
        }
        if (!z) {
            return new ResultSetImpl(str, fieldArr, rowData, mySQLConnection, statementImpl);
        }
        return new UpdatableResultSet(str, fieldArr, rowData, mySQLConnection, statementImpl);
    }

    @Override // java.sql.ResultSet
    public double getDouble(String str) throws SQLException {
        return getDouble(findColumn(str));
    }

    public BigDecimal getNativeBigDecimal(int i, int i2) throws SQLException {
        String asciiString;
        checkColumnBounds(i);
        int i3 = i - 1;
        Field field = this.fields[i3];
        byte[] columnValue = this.thisRow.getColumnValue(i3);
        if (columnValue == null) {
            this.wasNullFlag = true;
            return null;
        }
        this.wasNullFlag = false;
        int sQLType = field.getSQLType();
        if (sQLType != 2 && sQLType != 3) {
            asciiString = getNativeString(i);
        } else {
            asciiString = StringUtils.toAsciiString(columnValue);
        }
        return getBigDecimalFromString(asciiString, i, i2);
    }

    @Override // java.sql.ResultSet
    public Time getTime(String str, Calendar calendar) throws SQLException {
        return getTime(findColumn(str), calendar);
    }

    @Override // java.sql.ResultSet
    public Timestamp getTimestamp(String str, Calendar calendar) throws SQLException {
        return getTimestamp(findColumn(str), calendar);
    }

    @Override // java.sql.ResultSet
    public URL getURL(String str) throws SQLException {
        String string = getString(str);
        if (string == null) {
            return null;
        }
        try {
            return new URL(string);
        } catch (MalformedURLException unused) {
            throw SQLError.createSQLException(Messages.getString("ResultSet.Malformed_URL____107") + string + "'", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
    }

    @Override // java.sql.ResultSet
    public void updateObject(String str, Object obj, int i) throws SQLException {
        updateObject(findColumn(str), obj);
    }

    @Override // java.sql.ResultSet
    public InputStream getAsciiStream(String str) throws SQLException {
        return getAsciiStream(findColumn(str));
    }

    @Override // java.sql.ResultSet
    public java.sql.Clob getClob(String str) throws SQLException {
        return getClob(findColumn(str));
    }

    @Override // java.sql.ResultSet
    public float getFloat(String str) throws SQLException {
        return getFloat(findColumn(str));
    }

    @Override // java.sql.ResultSet
    @Deprecated
    public InputStream getUnicodeStream(String str) throws SQLException {
        return getUnicodeStream(findColumn(str));
    }

    @Override // java.sql.ResultSet
    public byte getByte(String str) throws SQLException {
        return getByte(findColumn(str));
    }

    @Override // java.sql.ResultSet
    @Deprecated
    public BigDecimal getBigDecimal(int i, int i2) throws SQLException {
        BigDecimal bigDecimal;
        if (!this.isBinaryEncoded) {
            String string = getString(i);
            if (string == null) {
                return null;
            }
            if (string.length() == 0) {
                BigDecimal bigDecimal2 = new BigDecimal(convertToZeroLiteralStringWithEmptyCheck());
                try {
                    try {
                        return bigDecimal2.setScale(i2);
                    } catch (ArithmeticException unused) {
                        throw SQLError.createSQLException(Messages.getString("ResultSet.Bad_format_for_BigDecimal", new Object[]{string, Integer.valueOf(i)}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                    }
                } catch (ArithmeticException unused2) {
                    return bigDecimal2.setScale(i2, 4);
                }
            }
            try {
                bigDecimal = new BigDecimal(string);
            } catch (NumberFormatException unused3) {
                if (this.fields[i - 1].getMysqlType() != 16) {
                    throw SQLError.createSQLException(Messages.getString("ResultSet.Bad_format_for_BigDecimal", new Object[]{Integer.valueOf(i), string}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                }
                bigDecimal = new BigDecimal(getNumericRepresentationOfSQLBitType(i));
            }
            try {
                try {
                    return bigDecimal.setScale(i2);
                } catch (ArithmeticException unused4) {
                    throw SQLError.createSQLException(Messages.getString("ResultSet.Bad_format_for_BigDecimal", new Object[]{Integer.valueOf(i), string}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                }
            } catch (ArithmeticException unused5) {
                return bigDecimal.setScale(i2, 4);
            }
        }
        return getNativeBigDecimal(i, i2);
    }

    @Override // java.sql.ResultSet
    public Reader getCharacterStream(String str) throws SQLException {
        return getCharacterStream(findColumn(str));
    }

    @Override // java.sql.ResultSet
    public InputStream getBinaryStream(String str) throws SQLException {
        return getBinaryStream(findColumn(str));
    }

    @Override // java.sql.ResultSet
    public byte[] getBytes(String str) throws SQLException {
        return getBytes(findColumn(str));
    }

    @Override // java.sql.ResultSet
    public String getString(String str) throws SQLException {
        return getString(findColumn(str));
    }

    @Override // java.sql.ResultSet
    public java.sql.Blob getBlob(String str) throws SQLException {
        return getBlob(findColumn(str));
    }

    @Override // java.sql.ResultSet
    public Date getDate(String str) throws SQLException {
        return getDate(findColumn(str));
    }

    @Override // java.sql.ResultSet
    public Date getDate(String str, Calendar calendar) throws SQLException {
        return getDate(findColumn(str), calendar);
    }

    @Override // java.sql.ResultSet
    public boolean getBoolean(String str) throws SQLException {
        return getBoolean(findColumn(str));
    }

    @Override // java.sql.ResultSet
    public BigDecimal getBigDecimal(String str) throws SQLException {
        return getBigDecimal(findColumn(str));
    }

    @Override // java.sql.ResultSet
    @Deprecated
    public BigDecimal getBigDecimal(String str, int i) throws SQLException {
        return getBigDecimal(findColumn(str), i);
    }

    @Override // java.sql.ResultSet
    public long getLong(String str) throws SQLException {
        return getLong(findColumn(str));
    }

    @Override // java.sql.ResultSet
    public int getInt(String str) throws SQLException {
        return getInt(findColumn(str));
    }

    @Override // java.sql.ResultSet
    public short getShort(String str) throws SQLException {
        return getShort(findColumn(str));
    }

    @Override // com.mysql.jdbc.ResultSetInternalMethods
    public Object getObjectStoredProc(int i, Map<Object, Object> map, int i2) throws SQLException {
        return getObjectStoredProc(i, i2);
    }

    @Override // com.mysql.jdbc.ResultSetInternalMethods
    public Object getObjectStoredProc(String str, int i) throws SQLException {
        return getObjectStoredProc(findColumn(str), i);
    }

    @Override // com.mysql.jdbc.ResultSetInternalMethods
    public Object getObjectStoredProc(String str, Map<Object, Object> map, int i) throws SQLException {
        return getObjectStoredProc(findColumn(str), map, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T getObject(int i, Class<T> cls) throws SQLException {
        if (cls != null) {
            if (cls.equals(String.class)) {
                return (T) getString(i);
            }
            if (cls.equals(BigDecimal.class)) {
                return (T) getBigDecimal(i);
            }
            if (!cls.equals(Boolean.class) && !cls.equals(Boolean.TYPE)) {
                if (!cls.equals(Integer.class) && !cls.equals(Integer.TYPE)) {
                    if (!cls.equals(Long.class) && !cls.equals(Long.TYPE)) {
                        if (!cls.equals(Float.class) && !cls.equals(Float.TYPE)) {
                            if (!cls.equals(Double.class) && !cls.equals(Double.TYPE)) {
                                if (cls.equals(byte[].class)) {
                                    return (T) getBytes(i);
                                }
                                if (cls.equals(Date.class)) {
                                    return (T) getDate(i);
                                }
                                if (cls.equals(Time.class)) {
                                    return (T) getTime(i);
                                }
                                if (cls.equals(Timestamp.class)) {
                                    return (T) getTimestamp(i);
                                }
                                if (cls.equals(Clob.class)) {
                                    return (T) getClob(i);
                                }
                                if (cls.equals(Blob.class)) {
                                    return (T) getBlob(i);
                                }
                                if (cls.equals(Array.class)) {
                                    return (T) getArray(i);
                                }
                                if (cls.equals(Ref.class)) {
                                    return (T) getRef(i);
                                }
                                if (cls.equals(URL.class)) {
                                    return (T) getURL(i);
                                }
                                if (this.connection.getAutoDeserialize()) {
                                    try {
                                        return cls.cast(getObject(i));
                                    } catch (ClassCastException e) {
                                        SQLException sQLExceptionCreateSQLException = SQLError.createSQLException("Conversion not supported for type " + cls.getName(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                                        sQLExceptionCreateSQLException.initCause(e);
                                        throw sQLExceptionCreateSQLException;
                                    }
                                }
                                throw SQLError.createSQLException("Conversion not supported for type " + cls.getName(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                            }
                            return (T) Double.valueOf(getDouble(i));
                        }
                        return (T) Float.valueOf(getFloat(i));
                    }
                    return (T) Long.valueOf(getLong(i));
                }
                return (T) Integer.valueOf(getInt(i));
            }
            return (T) Boolean.valueOf(getBoolean(i));
        }
        throw SQLError.createSQLException("Type parameter can not be null", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
    }

    public ResultSetImpl(String str, Field[] fieldArr, RowData rowData, MySQLConnection mySQLConnection, StatementImpl statementImpl) throws SQLException {
        this.catalog = null;
        this.columnLabelToIndex = null;
        this.columnToIndexCache = null;
        this.columnUsed = null;
        this.connectionId = 0L;
        this.currentRow = -1;
        this.doingUpdates = false;
        this.eventSink = null;
        this.fastDefaultCal = null;
        this.fastClientCal = null;
        this.fetchDirection = 1000;
        this.fetchSize = 0;
        this.fullColumnNameToIndex = null;
        this.columnNameToIndex = null;
        this.hasBuiltIndexMapping = false;
        this.isBinaryEncoded = false;
        this.isClosed = false;
        this.nextResultSet = null;
        this.onInsertRow = false;
        this.profileSql = false;
        this.reallyResult = false;
        this.resultSetConcurrency = 0;
        this.resultSetType = 0;
        this.serverInfo = null;
        this.thisRow = null;
        this.updateId = -1L;
        this.useStrictFloatingPoint = false;
        this.useUsageAdvisor = false;
        this.warningChain = null;
        this.wasNullFlag = false;
        this.gmtCalendar = null;
        this.useFastDateParsing = false;
        this.padCharsWithSpace = false;
        this.useFastIntParsing = true;
        this.onValidRow = false;
        this.invalidRowReason = null;
        this.connection = mySQLConnection;
        this.retainOwningStatement = false;
        if (this.connection != null) {
            this.exceptionInterceptor = this.connection.getExceptionInterceptor();
            this.useStrictFloatingPoint = this.connection.getStrictFloatingPoint();
            this.connectionId = this.connection.getId();
            this.useFastDateParsing = this.connection.getUseFastDateParsing();
            this.profileSql = this.connection.getProfileSql();
            this.retainOwningStatement = this.connection.getRetainStatementAfterResultSetClose();
            this.jdbcCompliantTruncationForReads = this.connection.getJdbcCompliantTruncationForReads();
            this.useFastIntParsing = this.connection.getUseFastIntParsing();
            this.serverTimeZoneTz = this.connection.getServerTimezoneTZ();
            this.padCharsWithSpace = this.connection.getPadCharsWithSpace();
        }
        this.owningStatement = statementImpl;
        this.catalog = str;
        this.fields = fieldArr;
        this.rowData = rowData;
        this.updateCount = rowData.size();
        this.reallyResult = true;
        if (this.rowData.size() > 0) {
            if (this.updateCount == 1 && this.thisRow == null) {
                this.rowData.close();
                this.updateCount = -1L;
            }
        } else {
            this.thisRow = null;
        }
        this.rowData.setOwner(this);
        if (this.fields != null) {
            initializeWithMetadata();
        }
        this.useLegacyDatetimeCode = this.connection.getUseLegacyDatetimeCode();
        this.useColumnNamesInFindColumn = this.connection.getUseColumnNamesInFindColumn();
        setRowPositionValidity();
    }

    public <T> T getObject(String str, Class<T> cls) throws SQLException {
        return (T) getObject(findColumn(str), cls);
    }

    @Override // java.sql.ResultSet
    public Object getObject(int i, Map<String, Class<?>> map) throws SQLException {
        return getObject(i);
    }

    @Override // java.sql.ResultSet
    public Object getObject(String str) throws SQLException {
        return getObject(findColumn(str));
    }

    @Override // java.sql.ResultSet
    public Object getObject(String str, Map<String, Class<?>> map) throws SQLException {
        return getObject(findColumn(str), map);
    }
}
