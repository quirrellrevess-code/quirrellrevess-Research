package com.mysql.jdbc;

import com.google.android.flexbox.BuildConfig;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class EscapeProcessor {
    private static Map<String, String> JDBC_CONVERT_TO_MYSQL_TYPE_MAP;
    private static Map<String, String> JDBC_NO_CONVERT_TO_MYSQL_EXPRESSION_MAP;

    static {
        HashMap map = new HashMap();
        map.put("BIGINT", "0 + ?");
        map.put("BINARY", "BINARY");
        map.put("BIT", "0 + ?");
        map.put("CHAR", "CHAR");
        map.put("DATE", "DATE");
        map.put("DECIMAL", "0.0 + ?");
        map.put("DOUBLE", "0.0 + ?");
        map.put("FLOAT", "0.0 + ?");
        map.put("INTEGER", "0 + ?");
        map.put("LONGVARBINARY", "BINARY");
        map.put("LONGVARCHAR", "CONCAT(?)");
        map.put("REAL", "0.0 + ?");
        map.put("SMALLINT", "CONCAT(?)");
        map.put("TIME", "TIME");
        map.put("TIMESTAMP", "DATETIME");
        map.put("TINYINT", "CONCAT(?)");
        map.put("VARBINARY", "BINARY");
        map.put("VARCHAR", "CONCAT(?)");
        JDBC_CONVERT_TO_MYSQL_TYPE_MAP = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap(JDBC_CONVERT_TO_MYSQL_TYPE_MAP);
        map2.put("BINARY", "CONCAT(?)");
        map2.put("CHAR", "CONCAT(?)");
        map2.remove("DATE");
        map2.put("LONGVARBINARY", "CONCAT(?)");
        map2.remove("TIME");
        map2.remove("TIMESTAMP");
        map2.put("VARBINARY", "CONCAT(?)");
        JDBC_NO_CONVERT_TO_MYSQL_EXPRESSION_MAP = Collections.unmodifiableMap(map2);
    }

    public static final Object escapeSQL(String str, boolean z, MySQLConnection mySQLConnection) throws SQLException {
        String str2;
        String strNextToken = null;
        if (str == null) {
            return null;
        }
        char c = '{';
        int iIndexOf = str.indexOf(123);
        if ((iIndexOf == -1 ? -1 : str.indexOf(125, iIndexOf)) == -1) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        EscapeTokenizer escapeTokenizer = new EscapeTokenizer(str);
        int i = 0;
        boolean z2 = false;
        byte b = 0;
        boolean z3 = false;
        while (true) {
            boolean z4 = true;
            if (!escapeTokenizer.hasMoreTokens()) {
                String string = sb.toString();
                if (z2) {
                    while (string.indexOf(strNextToken) != -1) {
                        int iIndexOf2 = string.indexOf(strNextToken);
                        string = string.substring(0, iIndexOf2) + "\\" + string.substring(iIndexOf2 + 1, string.length());
                    }
                }
                EscapeProcessorResult escapeProcessorResult = new EscapeProcessorResult();
                escapeProcessorResult.escapedSql = string;
                escapeProcessorResult.callingStoredFunction = z3;
                if (b != 1) {
                    if (escapeTokenizer.sawVariableUse()) {
                        escapeProcessorResult.usesVariables = (byte) 1;
                    } else {
                        escapeProcessorResult.usesVariables = (byte) 0;
                    }
                }
                return escapeProcessorResult;
            }
            String strNextToken2 = escapeTokenizer.nextToken();
            if (strNextToken2.length() != 0) {
                if (strNextToken2.charAt(i) != c) {
                    sb.append(strNextToken2);
                } else {
                    if (!strNextToken2.endsWith("}")) {
                        throw SQLError.createSQLException("Not a valid escape sequence: " + strNextToken2, mySQLConnection.getExceptionInterceptor());
                    }
                    if (strNextToken2.length() > 2 && strNextToken2.indexOf(c, 2) != -1) {
                        StringBuilder sb2 = new StringBuilder(strNextToken2.substring(0, 1));
                        Object objEscapeSQL = escapeSQL(strNextToken2.substring(1, strNextToken2.length() - 1), z, mySQLConnection);
                        if (objEscapeSQL instanceof String) {
                            str2 = (String) objEscapeSQL;
                        } else {
                            EscapeProcessorResult escapeProcessorResult2 = (EscapeProcessorResult) objEscapeSQL;
                            String str3 = escapeProcessorResult2.escapedSql;
                            if (b != 1) {
                                b = escapeProcessorResult2.usesVariables;
                            }
                            str2 = str3;
                        }
                        sb2.append(str2);
                        sb2.append('}');
                        strNextToken2 = sb2.toString();
                    }
                    String strRemoveWhitespace = removeWhitespace(strNextToken2);
                    if (StringUtils.startsWithIgnoreCase(strRemoveWhitespace, "{escape")) {
                        try {
                            StringTokenizer stringTokenizer = new StringTokenizer(strNextToken2, " '");
                            stringTokenizer.nextToken();
                            strNextToken = stringTokenizer.nextToken();
                            if (strNextToken.length() < 3) {
                                sb.append(strNextToken2);
                            } else {
                                strNextToken = strNextToken.substring(1, strNextToken.length() - 1);
                                z2 = true;
                            }
                        } catch (NoSuchElementException unused) {
                            sb.append(strNextToken2);
                        }
                    } else if (StringUtils.startsWithIgnoreCase(strRemoveWhitespace, "{fn")) {
                        String strSubstring = strNextToken2.substring(strNextToken2.toLowerCase().indexOf("fn ") + 3, strNextToken2.length() - 1);
                        if (StringUtils.startsWithIgnoreCaseAndWs(strSubstring, "convert")) {
                            sb.append(processConvertToken(strSubstring, z, mySQLConnection));
                        } else {
                            sb.append(strSubstring);
                        }
                    } else if (StringUtils.startsWithIgnoreCase(strRemoveWhitespace, "{d")) {
                        int iIndexOf3 = strNextToken2.indexOf(39) + 1;
                        int iLastIndexOf = strNextToken2.lastIndexOf(39);
                        if (iIndexOf3 == -1 || iLastIndexOf == -1) {
                            sb.append(strNextToken2);
                        } else {
                            String strSubstring2 = strNextToken2.substring(iIndexOf3, iLastIndexOf);
                            try {
                                StringTokenizer stringTokenizer2 = new StringTokenizer(strSubstring2, " -");
                                sb.append("'" + stringTokenizer2.nextToken() + "-" + stringTokenizer2.nextToken() + "-" + stringTokenizer2.nextToken() + "'");
                            } catch (NoSuchElementException unused2) {
                                throw SQLError.createSQLException("Syntax error for DATE escape sequence '" + strSubstring2 + "'", SQLError.SQL_STATE_SYNTAX_ERROR, mySQLConnection.getExceptionInterceptor());
                            }
                        }
                    } else if (StringUtils.startsWithIgnoreCase(strRemoveWhitespace, "{ts")) {
                        processTimestampToken(mySQLConnection, sb, strNextToken2);
                    } else if (StringUtils.startsWithIgnoreCase(strRemoveWhitespace, "{t")) {
                        processTimeToken(mySQLConnection, sb, strNextToken2);
                    } else if (StringUtils.startsWithIgnoreCase(strRemoveWhitespace, "{call") || StringUtils.startsWithIgnoreCase(strRemoveWhitespace, "{?=call")) {
                        int iIndexOfIgnoreCase = StringUtils.indexOfIgnoreCase(strNextToken2, "CALL") + 5;
                        int length = strNextToken2.length() - 1;
                        if (StringUtils.startsWithIgnoreCase(strRemoveWhitespace, "{?=call")) {
                            sb.append("SELECT ");
                            sb.append(strNextToken2.substring(iIndexOfIgnoreCase, length));
                        } else {
                            sb.append("CALL ");
                            sb.append(strNextToken2.substring(iIndexOfIgnoreCase, length));
                            z4 = false;
                        }
                        for (int i2 = length - 1; i2 >= iIndexOfIgnoreCase; i2--) {
                            char cCharAt = strNextToken2.charAt(i2);
                            if (!Character.isWhitespace(cCharAt)) {
                                if (cCharAt == ')') {
                                    break;
                                }
                                sb.append("()");
                                break;
                            }
                        }
                        z3 = z4;
                    } else if (StringUtils.startsWithIgnoreCase(strRemoveWhitespace, "{oj")) {
                        sb.append(strNextToken2);
                    } else {
                        sb.append(strNextToken2);
                    }
                }
            }
            i = 0;
            c = '{';
        }
    }

    private static String processConvertToken(String str, boolean z, MySQLConnection mySQLConnection) throws SQLException {
        String str2;
        int iIndexOf = str.indexOf("(");
        if (iIndexOf == -1) {
            throw SQLError.createSQLException("Syntax error while processing {fn convert (... , ...)} token, missing opening parenthesis in token '" + str + "'.", SQLError.SQL_STATE_SYNTAX_ERROR, mySQLConnection.getExceptionInterceptor());
        }
        int iLastIndexOf = str.lastIndexOf(",");
        if (iLastIndexOf == -1) {
            throw SQLError.createSQLException("Syntax error while processing {fn convert (... , ...)} token, missing comma in token '" + str + "'.", SQLError.SQL_STATE_SYNTAX_ERROR, mySQLConnection.getExceptionInterceptor());
        }
        int iIndexOf2 = str.indexOf(41, iLastIndexOf);
        if (iIndexOf2 == -1) {
            throw SQLError.createSQLException("Syntax error while processing {fn convert (... , ...)} token, missing closing parenthesis in token '" + str + "'.", SQLError.SQL_STATE_SYNTAX_ERROR, mySQLConnection.getExceptionInterceptor());
        }
        String strSubstring = str.substring(iIndexOf + 1, iLastIndexOf);
        String strSubstring2 = str.substring(iLastIndexOf + 1, iIndexOf2);
        String strTrim = strSubstring2.trim();
        if (StringUtils.startsWithIgnoreCase(strTrim, "SQL_")) {
            strTrim = strTrim.substring(4, strTrim.length());
        }
        if (z) {
            str2 = JDBC_CONVERT_TO_MYSQL_TYPE_MAP.get(strTrim.toUpperCase(Locale.ENGLISH));
        } else {
            str2 = JDBC_NO_CONVERT_TO_MYSQL_EXPRESSION_MAP.get(strTrim.toUpperCase(Locale.ENGLISH));
            if (str2 == null) {
                throw SQLError.createSQLException("Can't find conversion re-write for type '" + strSubstring2 + "' that is applicable for this server version while processing escape tokens.", SQLError.SQL_STATE_GENERAL_ERROR, mySQLConnection.getExceptionInterceptor());
            }
        }
        if (str2 == null) {
            throw SQLError.createSQLException("Unsupported conversion type '" + strSubstring2.trim() + "' found while processing escape token.", SQLError.SQL_STATE_GENERAL_ERROR, mySQLConnection.getExceptionInterceptor());
        }
        int iIndexOf3 = str2.indexOf("?");
        if (iIndexOf3 != -1) {
            return str2.substring(0, iIndexOf3) + strSubstring + str2.substring(iIndexOf3 + 1, str2.length());
        }
        return "CAST(" + strSubstring + " AS " + str2 + ")";
    }

    private static void processTimeToken(MySQLConnection mySQLConnection, StringBuilder sb, String str) throws SQLException {
        boolean z = true;
        int iIndexOf = str.indexOf(39) + 1;
        int iLastIndexOf = str.lastIndexOf(39);
        if (iIndexOf == -1 || iLastIndexOf == -1) {
            sb.append(str);
            return;
        }
        String strSubstring = str.substring(iIndexOf, iLastIndexOf);
        try {
            StringTokenizer stringTokenizer = new StringTokenizer(strSubstring, " :.");
            String strNextToken = stringTokenizer.nextToken();
            String strNextToken2 = stringTokenizer.nextToken();
            String strNextToken3 = stringTokenizer.nextToken();
            String str2 = BuildConfig.FLAVOR;
            if (stringTokenizer.hasMoreTokens() && mySQLConnection.versionMeetsMinimum(5, 6, 4)) {
                str2 = "." + stringTokenizer.nextToken();
            } else {
                z = false;
            }
            if (mySQLConnection.getUseTimezone() && mySQLConnection.getUseLegacyDatetimeCode()) {
                Calendar calendarInstanceForSessionOrNew = mySQLConnection.getCalendarInstanceForSessionOrNew();
                try {
                    Time timeChangeTimezone = TimeUtil.changeTimezone(mySQLConnection, calendarInstanceForSessionOrNew, (Calendar) null, TimeUtil.fastTimeCreate(calendarInstanceForSessionOrNew, Integer.parseInt(strNextToken), Integer.parseInt(strNextToken2), Integer.parseInt(strNextToken3), mySQLConnection.getExceptionInterceptor()), calendarInstanceForSessionOrNew.getTimeZone(), mySQLConnection.getServerTimezoneTZ(), false);
                    sb.append("'");
                    sb.append(timeChangeTimezone.toString());
                    if (z) {
                        sb.append(str2);
                    }
                    sb.append("'");
                    return;
                } catch (NumberFormatException unused) {
                    throw SQLError.createSQLException("Syntax error in TIMESTAMP escape sequence '" + str + "'.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, mySQLConnection.getExceptionInterceptor());
                }
            }
            sb.append("'");
            sb.append(strNextToken);
            sb.append(":");
            sb.append(strNextToken2);
            sb.append(":");
            sb.append(strNextToken3);
            sb.append(str2);
            sb.append("'");
        } catch (NoSuchElementException unused2) {
            throw SQLError.createSQLException("Syntax error for escape sequence '" + strSubstring + "'", SQLError.SQL_STATE_SYNTAX_ERROR, mySQLConnection.getExceptionInterceptor());
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0128 A[Catch: NumberFormatException -> 0x016f, NoSuchElementException -> 0x0198, IllegalArgumentException -> 0x01bf, TryCatch #0 {IllegalArgumentException -> 0x01bf, blocks: (B:24:0x00a6, B:26:0x00ac, B:29:0x00cc, B:31:0x00d2, B:33:0x00d8, B:34:0x0106, B:35:0x010a, B:37:0x0128, B:39:0x0137, B:41:0x015d, B:42:0x0162, B:44:0x0167, B:45:0x016a, B:47:0x016f, B:48:0x0191, B:50:0x0198), top: B:75:0x0074 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0135  */
    /* JADX WARN: Code duplicated, block: B:41:0x015d A[Catch: NumberFormatException -> 0x016f, NoSuchElementException -> 0x0198, IllegalArgumentException -> 0x01bf, TryCatch #0 {IllegalArgumentException -> 0x01bf, blocks: (B:24:0x00a6, B:26:0x00ac, B:29:0x00cc, B:31:0x00d2, B:33:0x00d8, B:34:0x0106, B:35:0x010a, B:37:0x0128, B:39:0x0137, B:41:0x015d, B:42:0x0162, B:44:0x0167, B:45:0x016a, B:47:0x016f, B:48:0x0191, B:50:0x0198), top: B:75:0x0074 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0167 A[Catch: NumberFormatException -> 0x016f, NoSuchElementException -> 0x0198, IllegalArgumentException -> 0x01bf, TryCatch #0 {IllegalArgumentException -> 0x01bf, blocks: (B:24:0x00a6, B:26:0x00ac, B:29:0x00cc, B:31:0x00d2, B:33:0x00d8, B:34:0x0106, B:35:0x010a, B:37:0x0128, B:39:0x0137, B:41:0x015d, B:42:0x0162, B:44:0x0167, B:45:0x016a, B:47:0x016f, B:48:0x0191, B:50:0x0198), top: B:75:0x0074 }] */
    /* JADX WARN: Not initialized variable reg: 17, insn: 0x01c0: MOVE (r1 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]), block:B:65:0x01c0 */
    private static void processTimestampToken(MySQLConnection mySQLConnection, StringBuilder sb, String str) throws SQLException {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        boolean z;
        boolean useGmtMillisForDatetimes;
        Calendar calendar;
        String string;
        int iIndexOf;
        int iIndexOf2 = str.indexOf(39) + 1;
        int iLastIndexOf = str.lastIndexOf(39);
        if (iIndexOf2 == -1 || iLastIndexOf == -1) {
            sb.append(str);
            return;
        }
        String strSubstring = str.substring(iIndexOf2, iLastIndexOf);
        try {
            if (!mySQLConnection.getUseLegacyDatetimeCode()) {
                Timestamp timestampAdjustTimestampNanosPrecision = TimeUtil.adjustTimestampNanosPrecision(Timestamp.valueOf(strSubstring), 6, !mySQLConnection.isServerTruncatesFracSecs());
                sb.append(TimeUtil.getSimpleDateFormat(null, "''yyyy-MM-dd HH:mm:ss", null, mySQLConnection.getServerTimezoneTZ()).format((Date) timestampAdjustTimestampNanosPrecision));
                if (timestampAdjustTimestampNanosPrecision.getNanos() > 0 && mySQLConnection.versionMeetsMinimum(5, 6, 4)) {
                    sb.append('.');
                    sb.append(TimeUtil.formatNanos(timestampAdjustTimestampNanosPrecision.getNanos(), true, 6));
                }
                sb.append('\'');
                return;
            }
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(strSubstring, " .-:");
                try {
                    String strNextToken = stringTokenizer.nextToken();
                    String strNextToken2 = stringTokenizer.nextToken();
                    String strNextToken3 = stringTokenizer.nextToken();
                    String strNextToken4 = stringTokenizer.nextToken();
                    String strNextToken5 = stringTokenizer.nextToken();
                    String strNextToken6 = stringTokenizer.nextToken();
                    try {
                        if (stringTokenizer.hasMoreTokens()) {
                            try {
                                if (mySQLConnection.versionMeetsMinimum(5, 6, 4)) {
                                    str6 = "." + stringTokenizer.nextToken();
                                    z = true;
                                }
                                if (mySQLConnection.getUseTimezone() && !mySQLConnection.getUseJDBCCompliantTimezoneShift()) {
                                    sb.append("'");
                                    sb.append(strNextToken);
                                    sb.append("-");
                                    sb.append(strNextToken2);
                                    sb.append("-");
                                    sb.append(strNextToken3);
                                    sb.append(" ");
                                    sb.append(strNextToken4);
                                    sb.append(":");
                                    sb.append(strNextToken5);
                                    sb.append(":");
                                    sb.append(strNextToken6);
                                    sb.append(str6);
                                    sb.append("'");
                                    return;
                                }
                                Calendar calendarInstanceForSessionOrNew = mySQLConnection.getCalendarInstanceForSessionOrNew();
                                int i = Integer.parseInt(strNextToken);
                                int i2 = Integer.parseInt(strNextToken2);
                                int i3 = Integer.parseInt(strNextToken3);
                                int i4 = Integer.parseInt(strNextToken4);
                                int i5 = Integer.parseInt(strNextToken5);
                                int i6 = Integer.parseInt(strNextToken6);
                                useGmtMillisForDatetimes = mySQLConnection.getUseGmtMillisForDatetimes();
                                if (useGmtMillisForDatetimes) {
                                    calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
                                } else {
                                    calendar = null;
                                }
                                Timestamp timestampChangeTimezone = TimeUtil.changeTimezone(mySQLConnection, calendarInstanceForSessionOrNew, (Calendar) null, TimeUtil.fastTimestampCreate(useGmtMillisForDatetimes, calendar, calendarInstanceForSessionOrNew, i, i2, i3, i4, i5, i6, 0), calendarInstanceForSessionOrNew.getTimeZone(), mySQLConnection.getServerTimezoneTZ(), false);
                                sb.append("'");
                                string = timestampChangeTimezone.toString();
                                iIndexOf = string.indexOf(".");
                                if (iIndexOf != -1) {
                                    string = string.substring(0, iIndexOf);
                                }
                                sb.append(string);
                                if (z) {
                                    sb.append(str6);
                                }
                                sb.append("'");
                                return;
                            } catch (NoSuchElementException unused) {
                                StringBuilder sb2 = new StringBuilder();
                                str3 = "Syntax error for TIMESTAMP escape sequence '";
                                try {
                                    sb2.append(str3);
                                    str4 = strSubstring;
                                    try {
                                        sb2.append(str4);
                                        sb2.append("'");
                                        str2 = r10;
                                        try {
                                            throw SQLError.createSQLException(sb2.toString(), str2, mySQLConnection.getExceptionInterceptor());
                                        } catch (IllegalArgumentException e) {
                                            e = e;
                                            SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(str3 + str4 + "'", str2, mySQLConnection.getExceptionInterceptor());
                                            sQLExceptionCreateSQLException.initCause(e);
                                            throw sQLExceptionCreateSQLException;
                                        }
                                    } catch (IllegalArgumentException e2) {
                                        e = e2;
                                        str2 = r10;
                                        SQLException sQLExceptionCreateSQLException2 = SQLError.createSQLException(str3 + str4 + "'", str2, mySQLConnection.getExceptionInterceptor());
                                        sQLExceptionCreateSQLException2.initCause(e);
                                        throw sQLExceptionCreateSQLException2;
                                    }
                                } catch (IllegalArgumentException e3) {
                                    e = e3;
                                    str4 = strSubstring;
                                    str2 = r10;
                                    SQLException sQLExceptionCreateSQLException3 = SQLError.createSQLException(str3 + str4 + "'", str2, mySQLConnection.getExceptionInterceptor());
                                    sQLExceptionCreateSQLException3.initCause(e);
                                    throw sQLExceptionCreateSQLException3;
                                }
                            }
                        }
                        int i7 = Integer.parseInt(strNextToken);
                        int i8 = Integer.parseInt(strNextToken2);
                        int i9 = Integer.parseInt(strNextToken3);
                        int i10 = Integer.parseInt(strNextToken4);
                        int i11 = Integer.parseInt(strNextToken5);
                        int i12 = Integer.parseInt(strNextToken6);
                        useGmtMillisForDatetimes = mySQLConnection.getUseGmtMillisForDatetimes();
                        if (useGmtMillisForDatetimes) {
                            calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
                        } else {
                            calendar = null;
                        }
                        Timestamp timestampChangeTimezone2 = TimeUtil.changeTimezone(mySQLConnection, calendarInstanceForSessionOrNew, (Calendar) null, TimeUtil.fastTimestampCreate(useGmtMillisForDatetimes, calendar, calendarInstanceForSessionOrNew, i7, i8, i9, i10, i11, i12, 0), calendarInstanceForSessionOrNew.getTimeZone(), mySQLConnection.getServerTimezoneTZ(), false);
                        sb.append("'");
                        string = timestampChangeTimezone2.toString();
                        iIndexOf = string.indexOf(".");
                        if (iIndexOf != -1) {
                            string = string.substring(0, iIndexOf);
                        }
                        sb.append(string);
                        if (z) {
                            sb.append(str6);
                        }
                        sb.append("'");
                        return;
                    } catch (NumberFormatException unused2) {
                        throw SQLError.createSQLException("Syntax error in TIMESTAMP escape sequence '" + str + "'.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, mySQLConnection.getExceptionInterceptor());
                    }
                    str6 = BuildConfig.FLAVOR;
                    z = false;
                    if (mySQLConnection.getUseTimezone()) {
                    }
                    Calendar calendarInstanceForSessionOrNew2 = mySQLConnection.getCalendarInstanceForSessionOrNew();
                } catch (NoSuchElementException unused3) {
                }
            } catch (IllegalArgumentException e4) {
                e = e4;
                str3 = str5;
            }
        } catch (IllegalArgumentException e5) {
            e = e5;
            str2 = SQLError.SQL_STATE_SYNTAX_ERROR;
            str3 = "Syntax error for TIMESTAMP escape sequence '";
            str4 = strSubstring;
        }
    }

    private static String removeWhitespace(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (!Character.isWhitespace(cCharAt)) {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }
}
