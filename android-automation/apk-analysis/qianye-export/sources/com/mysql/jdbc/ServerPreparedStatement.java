package com.mysql.jdbc;

import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.exceptions.MySQLStatementCancelledException;
import com.mysql.jdbc.exceptions.MySQLTimeoutException;
import com.mysql.jdbc.log.LogUtils;
import com.mysql.jdbc.profiler.ProfilerEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.ParameterMetaData;
import java.sql.Ref;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class ServerPreparedStatement extends PreparedStatement {
    public static final int BLOB_STREAM_READ_BUF_SIZE = 8192;
    private static final Constructor<?> JDBC_4_SPS_CTOR;
    private boolean canRewrite;
    private Calendar defaultTzCalendar;
    private boolean detectedLongParameterSwitch;
    private int fieldCount;
    private boolean hasCheckedRewrite;
    private boolean hasOnDuplicateKeyUpdate;
    private boolean invalid;
    private SQLException invalidationException;
    public boolean isCached;
    private int locationOfOnDuplicateKeyUpdate;
    private Buffer outByteBuffer;
    private BindValue[] parameterBindings;
    private Field[] parameterFields;
    private Field[] resultFields;
    private boolean sendTypesToServer;
    private boolean serverNeedsResetBeforeEachExecution;
    private long serverStatementId;
    private Calendar serverTzCalendar;
    private int stringTypeCode;
    private boolean useAutoSlowLog;

    public static class BatchedBindValues {
        public BindValue[] batchedParameterValues;

        public BatchedBindValues(BindValue[] bindValueArr) {
            int length = bindValueArr.length;
            this.batchedParameterValues = new BindValue[length];
            for (int i = 0; i < length; i++) {
                this.batchedParameterValues[i] = new BindValue(bindValueArr[i]);
            }
        }
    }

    public static class BindValue {
        public long bindLength;
        public long boundBeforeExecutionNum;
        public int bufferType;
        public Calendar calendar;
        public double doubleBinding;
        public float floatBinding;
        public boolean isLongData;
        public boolean isNull;
        public boolean isSet;
        public long longBinding;
        public Object value;

        public BindValue() {
            this.boundBeforeExecutionNum = 0L;
            this.isSet = false;
        }

        public long getBoundLength() {
            if (this.isNull) {
                return 0L;
            }
            if (this.isLongData) {
                return this.bindLength;
            }
            int i = this.bufferType;
            if (i != 0) {
                if (i == 1) {
                    return 1L;
                }
                if (i == 2) {
                    return 2L;
                }
                long j = 4;
                if (i != 3 && i != 4) {
                    j = 8;
                    if (i != 5) {
                        if (i == 7) {
                            return 11L;
                        }
                        if (i == 8) {
                            return 8L;
                        }
                        if (i != 15 && i != 246 && i != 253 && i != 254) {
                            switch (i) {
                                case 10:
                                    return 7L;
                                case 11:
                                    return 9L;
                                case 12:
                                    return 11L;
                                default:
                                    return 0L;
                            }
                        }
                    }
                }
                return j;
            }
            Object obj = this.value;
            return obj instanceof byte[] ? ((byte[]) obj).length : ((String) obj).length();
        }

        public void reset() {
            this.isNull = false;
            this.isSet = false;
            this.value = null;
            this.isLongData = false;
            this.longBinding = 0L;
            this.floatBinding = 0.0f;
            this.doubleBinding = 0.0d;
            this.calendar = null;
        }

        public String toString() {
            return toString(false);
        }

        public String toString(boolean z) {
            if (this.isLongData) {
                return "' STREAM DATA '";
            }
            if (this.isNull) {
                return "NULL";
            }
            int i = this.bufferType;
            if (i != 1 && i != 2 && i != 3) {
                if (i == 4) {
                    return String.valueOf(this.floatBinding);
                }
                if (i == 5) {
                    return String.valueOf(this.doubleBinding);
                }
                if (i != 7) {
                    if (i != 8) {
                        if (i != 15 && i != 253 && i != 254) {
                            switch (i) {
                                case 10:
                                case 11:
                                case 12:
                                    break;
                                default:
                                    Object obj = this.value;
                                    if (obj instanceof byte[]) {
                                        return "byte data";
                                    }
                                    if (!z) {
                                        return String.valueOf(obj);
                                    }
                                    return "'" + String.valueOf(this.value) + "'";
                            }
                        }
                    }
                }
                if (!z) {
                    return String.valueOf(this.value);
                }
                return "'" + String.valueOf(this.value) + "'";
            }
            return String.valueOf(this.longBinding);
        }

        public BindValue(BindValue bindValue) {
            this.boundBeforeExecutionNum = 0L;
            this.isSet = false;
            this.value = bindValue.value;
            this.isSet = bindValue.isSet;
            this.isLongData = bindValue.isLongData;
            this.isNull = bindValue.isNull;
            this.bufferType = bindValue.bufferType;
            this.bindLength = bindValue.bindLength;
            this.longBinding = bindValue.longBinding;
            this.floatBinding = bindValue.floatBinding;
            this.doubleBinding = bindValue.doubleBinding;
            this.calendar = bindValue.calendar;
        }
    }

    static {
        if (!Util.isJdbc4()) {
            JDBC_4_SPS_CTOR = null;
            return;
        }
        try {
            Class<?> cls = Class.forName(Util.isJdbc42() ? "com.mysql.jdbc.JDBC42ServerPreparedStatement" : "com.mysql.jdbc.JDBC4ServerPreparedStatement");
            Class<?> cls2 = Integer.TYPE;
            JDBC_4_SPS_CTOR = cls.getConstructor(MySQLConnection.class, String.class, String.class, cls2, cls2);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        } catch (SecurityException e3) {
            throw new RuntimeException(e3);
        }
    }

    public ServerPreparedStatement(MySQLConnection mySQLConnection, String str, String str2, int i, int i2) throws SQLException {
        String str3;
        super(mySQLConnection, str2);
        this.hasOnDuplicateKeyUpdate = false;
        this.detectedLongParameterSwitch = false;
        this.invalid = false;
        this.sendTypesToServer = false;
        this.stringTypeCode = MysqlDefs.FIELD_TYPE_STRING;
        this.isCached = false;
        this.hasCheckedRewrite = false;
        this.canRewrite = false;
        this.locationOfOnDuplicateKeyUpdate = -2;
        checkNullOrEmptyQuery(str);
        char cFirstAlphaCharUc = StringUtils.firstAlphaCharUc(str, StatementImpl.findStartOfStatement(str));
        this.firstCharOfStmt = cFirstAlphaCharUc;
        this.hasOnDuplicateKeyUpdate = cFirstAlphaCharUc == 'I' && containsOnDuplicateKeyInString(str);
        if (this.connection.versionMeetsMinimum(5, 0, 0)) {
            this.serverNeedsResetBeforeEachExecution = !this.connection.versionMeetsMinimum(5, 0, 3);
        } else {
            this.serverNeedsResetBeforeEachExecution = !this.connection.versionMeetsMinimum(4, 1, 10);
        }
        this.useAutoSlowLog = this.connection.getAutoSlowLog();
        this.useTrueBoolean = this.connection.versionMeetsMinimum(3, 21, 23);
        String statementComment = this.connection.getStatementComment();
        if (statementComment == null) {
            str3 = str;
        } else {
            str3 = "/* " + statementComment + " */ " + str;
        }
        this.originalSql = str3;
        if (this.connection.versionMeetsMinimum(4, 1, 2)) {
            this.stringTypeCode = MysqlDefs.FIELD_TYPE_VAR_STRING;
        } else {
            this.stringTypeCode = MysqlDefs.FIELD_TYPE_STRING;
        }
        try {
            serverPrepare(str);
            setResultSetType(i);
            setResultSetConcurrency(i2);
            this.parameterTypes = new int[this.parameterCount];
        } catch (SQLException e) {
            realClose(false, true);
            throw e;
        } catch (Exception e2) {
            realClose(false, true);
            SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(e2.toString(), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
            sQLExceptionCreateSQLException.initCause(e2);
            throw sQLExceptionCreateSQLException;
        }
    }

    private void clearParametersInternal(boolean z) throws SQLException {
        boolean z2;
        if (this.parameterBindings != null) {
            z2 = false;
            for (int i = 0; i < this.parameterCount; i++) {
                BindValue[] bindValueArr = this.parameterBindings;
                if (bindValueArr[i] != null && bindValueArr[i].isLongData) {
                    z2 = true;
                }
                bindValueArr[i].reset();
            }
        } else {
            z2 = false;
        }
        if (z && z2) {
            serverResetStatement();
            this.detectedLongParameterSwitch = false;
        }
    }

    private void dumpCloseForTestcase() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            StringBuilder sb = new StringBuilder();
            this.connection.generateConnectionCommentBlock(sb);
            sb.append("DEALLOCATE PREPARE debug_stmt_");
            sb.append(this.statementId);
            sb.append(";\n");
            this.connection.dumpTestcaseQuery(sb.toString());
        }
    }

    private void dumpExecuteForTestcase() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.parameterCount; i++) {
                this.connection.generateConnectionCommentBlock(sb);
                sb.append("SET @debug_stmt_param");
                sb.append(this.statementId);
                sb.append("_");
                sb.append(i);
                sb.append("=");
                BindValue[] bindValueArr = this.parameterBindings;
                if (bindValueArr[i].isNull) {
                    sb.append("NULL");
                } else {
                    sb.append(bindValueArr[i].toString(true));
                }
                sb.append(";\n");
            }
            this.connection.generateConnectionCommentBlock(sb);
            sb.append("EXECUTE debug_stmt_");
            sb.append(this.statementId);
            if (this.parameterCount > 0) {
                sb.append(" USING ");
                for (int i2 = 0; i2 < this.parameterCount; i2++) {
                    if (i2 > 0) {
                        sb.append(", ");
                    }
                    sb.append("@debug_stmt_param");
                    sb.append(this.statementId);
                    sb.append("_");
                    sb.append(i2);
                }
            }
            sb.append(";\n");
            this.connection.dumpTestcaseQuery(sb.toString());
        }
    }

    private void dumpPrepareForTestcase() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            StringBuilder sb = new StringBuilder(this.originalSql.length() + 64);
            this.connection.generateConnectionCommentBlock(sb);
            sb.append("PREPARE debug_stmt_");
            sb.append(this.statementId);
            sb.append(" FROM \"");
            sb.append(this.originalSql);
            sb.append("\";\n");
            this.connection.dumpTestcaseQuery(sb.toString());
        }
    }

    private Calendar getDefaultTzCalendar() throws SQLException {
        Calendar calendar;
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.defaultTzCalendar == null) {
                this.defaultTzCalendar = new GregorianCalendar(TimeZone.getDefault());
            }
            calendar = this.defaultTzCalendar;
        }
        return calendar;
    }

    public static ServerPreparedStatement getInstance(MySQLConnection mySQLConnection, String str, String str2, int i, int i2) throws SQLException {
        if (!Util.isJdbc4()) {
            return new ServerPreparedStatement(mySQLConnection, str, str2, i, i2);
        }
        try {
            return (ServerPreparedStatement) JDBC_4_SPS_CTOR.newInstance(mySQLConnection, str, str2, Integer.valueOf(i), Integer.valueOf(i2));
        } catch (IllegalAccessException e) {
            throw new SQLException(e.toString(), SQLError.SQL_STATE_GENERAL_ERROR);
        } catch (IllegalArgumentException e2) {
            throw new SQLException(e2.toString(), SQLError.SQL_STATE_GENERAL_ERROR);
        } catch (InstantiationException e3) {
            throw new SQLException(e3.toString(), SQLError.SQL_STATE_GENERAL_ERROR);
        } catch (InvocationTargetException e4) {
            Throwable targetException = e4.getTargetException();
            if (targetException instanceof SQLException) {
                throw ((SQLException) targetException);
            }
            throw new SQLException(targetException.toString(), SQLError.SQL_STATE_GENERAL_ERROR);
        }
    }

    private Calendar getServerTzCalendar() throws SQLException {
        Calendar calendar;
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.serverTzCalendar == null) {
                this.serverTzCalendar = new GregorianCalendar(this.connection.getServerTimezoneTZ());
            }
            calendar = this.serverTzCalendar;
        }
        return calendar;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x03e1 */
    /* JADX WARN: Code duplicated, block: B:115:0x01f6 A[Catch: all -> 0x03e3, SQLException -> 0x03e5, TRY_ENTER, TRY_LEAVE, TryCatch #15 {SQLException -> 0x03e5, all -> 0x03e3, blocks: (B:104:0x01dc, B:115:0x01f6), top: B:220:0x01dc }] */
    /* JADX WARN: Code duplicated, block: B:118:0x01fe A[Catch: all -> 0x01ec, SQLException -> 0x01f1, TRY_ENTER, TryCatch #13 {SQLException -> 0x01f1, all -> 0x01ec, blocks: (B:107:0x01e4, B:118:0x01fe, B:121:0x020f), top: B:224:0x01e4 }] */
    /* JADX WARN: Code duplicated, block: B:120:0x020e  */
    /* JADX WARN: Code duplicated, block: B:121:0x020f A[Catch: all -> 0x01ec, SQLException -> 0x01f1, TRY_LEAVE, TryCatch #13 {SQLException -> 0x01f1, all -> 0x01ec, blocks: (B:107:0x01e4, B:118:0x01fe, B:121:0x020f), top: B:224:0x01e4 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x0210  */
    /* JADX WARN: Code duplicated, block: B:127:0x0219 A[Catch: all -> 0x03db, TryCatch #11 {all -> 0x03db, blocks: (B:125:0x0215, B:127:0x0219, B:129:0x021d, B:131:0x0228, B:132:0x022b, B:130:0x0223, B:133:0x022c), top: B:218:0x0215 }] */
    /* JADX WARN: Code duplicated, block: B:129:0x021d A[Catch: all -> 0x03db, TryCatch #11 {all -> 0x03db, blocks: (B:125:0x0215, B:127:0x0219, B:129:0x021d, B:131:0x0228, B:132:0x022b, B:130:0x0223, B:133:0x022c), top: B:218:0x0215 }] */
    /* JADX WARN: Code duplicated, block: B:130:0x0223 A[Catch: all -> 0x03db, TryCatch #11 {all -> 0x03db, blocks: (B:125:0x0215, B:127:0x0219, B:129:0x021d, B:131:0x0228, B:132:0x022b, B:130:0x0223, B:133:0x022c), top: B:218:0x0215 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x022c A[Catch: all -> 0x03db, DONT_GENERATE, TRY_LEAVE, TryCatch #11 {all -> 0x03db, blocks: (B:125:0x0215, B:127:0x0219, B:129:0x021d, B:131:0x0228, B:132:0x022b, B:130:0x0223, B:133:0x022c), top: B:218:0x0215 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x0235  */
    /* JADX WARN: Code duplicated, block: B:140:0x0239 A[Catch: all -> 0x03f3, SQLException -> 0x03f6, TRY_ENTER, TryCatch #12 {SQLException -> 0x03f6, all -> 0x03f3, blocks: (B:83:0x0187, B:88:0x0195, B:90:0x019e, B:92:0x01a2, B:94:0x01ab, B:123:0x0212, B:124:0x0214, B:152:0x02de, B:154:0x02e7, B:155:0x0328, B:157:0x034e, B:160:0x035d, B:162:0x0361, B:164:0x039e, B:166:0x03a6, B:168:0x03b1, B:170:0x03b5, B:140:0x0239, B:142:0x023d, B:148:0x0259, B:150:0x02d8, B:145:0x024a, B:87:0x0191), top: B:216:0x0187 }] */
    /* JADX WARN: Code duplicated, block: B:142:0x023d A[Catch: all -> 0x03f3, SQLException -> 0x03f6, TryCatch #12 {SQLException -> 0x03f6, all -> 0x03f3, blocks: (B:83:0x0187, B:88:0x0195, B:90:0x019e, B:92:0x01a2, B:94:0x01ab, B:123:0x0212, B:124:0x0214, B:152:0x02de, B:154:0x02e7, B:155:0x0328, B:157:0x034e, B:160:0x035d, B:162:0x0361, B:164:0x039e, B:166:0x03a6, B:168:0x03b1, B:170:0x03b5, B:140:0x0239, B:142:0x023d, B:148:0x0259, B:150:0x02d8, B:145:0x024a, B:87:0x0191), top: B:216:0x0187 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x0248  */
    /* JADX WARN: Code duplicated, block: B:145:0x024a A[Catch: all -> 0x03f3, SQLException -> 0x03f6, TryCatch #12 {SQLException -> 0x03f6, all -> 0x03f3, blocks: (B:83:0x0187, B:88:0x0195, B:90:0x019e, B:92:0x01a2, B:94:0x01ab, B:123:0x0212, B:124:0x0214, B:152:0x02de, B:154:0x02e7, B:155:0x0328, B:157:0x034e, B:160:0x035d, B:162:0x0361, B:164:0x039e, B:166:0x03a6, B:168:0x03b1, B:170:0x03b5, B:140:0x0239, B:142:0x023d, B:148:0x0259, B:150:0x02d8, B:145:0x024a, B:87:0x0191), top: B:216:0x0187 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x0256  */
    /* JADX WARN: Code duplicated, block: B:148:0x0259 A[Catch: all -> 0x03f3, SQLException -> 0x03f6, TryCatch #12 {SQLException -> 0x03f6, all -> 0x03f3, blocks: (B:83:0x0187, B:88:0x0195, B:90:0x019e, B:92:0x01a2, B:94:0x01ab, B:123:0x0212, B:124:0x0214, B:152:0x02de, B:154:0x02e7, B:155:0x0328, B:157:0x034e, B:160:0x035d, B:162:0x0361, B:164:0x039e, B:166:0x03a6, B:168:0x03b1, B:170:0x03b5, B:140:0x0239, B:142:0x023d, B:148:0x0259, B:150:0x02d8, B:145:0x024a, B:87:0x0191), top: B:216:0x0187 }] */
    /* JADX WARN: Code duplicated, block: B:150:0x02d8 A[Catch: all -> 0x03f3, SQLException -> 0x03f6, TryCatch #12 {SQLException -> 0x03f6, all -> 0x03f3, blocks: (B:83:0x0187, B:88:0x0195, B:90:0x019e, B:92:0x01a2, B:94:0x01ab, B:123:0x0212, B:124:0x0214, B:152:0x02de, B:154:0x02e7, B:155:0x0328, B:157:0x034e, B:160:0x035d, B:162:0x0361, B:164:0x039e, B:166:0x03a6, B:168:0x03b1, B:170:0x03b5, B:140:0x0239, B:142:0x023d, B:148:0x0259, B:150:0x02d8, B:145:0x024a, B:87:0x0191), top: B:216:0x0187 }] */
    /* JADX WARN: Code duplicated, block: B:154:0x02e7 A[Catch: all -> 0x03f3, SQLException -> 0x03f6, TryCatch #12 {SQLException -> 0x03f6, all -> 0x03f3, blocks: (B:83:0x0187, B:88:0x0195, B:90:0x019e, B:92:0x01a2, B:94:0x01ab, B:123:0x0212, B:124:0x0214, B:152:0x02de, B:154:0x02e7, B:155:0x0328, B:157:0x034e, B:160:0x035d, B:162:0x0361, B:164:0x039e, B:166:0x03a6, B:168:0x03b1, B:170:0x03b5, B:140:0x0239, B:142:0x023d, B:148:0x0259, B:150:0x02d8, B:145:0x024a, B:87:0x0191), top: B:216:0x0187 }] */
    /* JADX WARN: Code duplicated, block: B:162:0x0361 A[Catch: all -> 0x03f3, SQLException -> 0x03f6, TryCatch #12 {SQLException -> 0x03f6, all -> 0x03f3, blocks: (B:83:0x0187, B:88:0x0195, B:90:0x019e, B:92:0x01a2, B:94:0x01ab, B:123:0x0212, B:124:0x0214, B:152:0x02de, B:154:0x02e7, B:155:0x0328, B:157:0x034e, B:160:0x035d, B:162:0x0361, B:164:0x039e, B:166:0x03a6, B:168:0x03b1, B:170:0x03b5, B:140:0x0239, B:142:0x023d, B:148:0x0259, B:150:0x02d8, B:145:0x024a, B:87:0x0191), top: B:216:0x0187 }] */
    /* JADX WARN: Code duplicated, block: B:174:0x03c3 A[Catch: SQLException -> 0x03df, all -> 0x040a, TRY_LEAVE, TryCatch #5 {all -> 0x040a, blocks: (B:172:0x03b9, B:174:0x03c3, B:202:0x03f8, B:204:0x03fe, B:205:0x0409, B:183:0x03de), top: B:216:0x0187 }] */
    /* JADX WARN: Code duplicated, block: B:177:0x03cd A[Catch: all -> 0x041f, TryCatch #14 {, blocks: (B:4:0x000b, B:6:0x0018, B:8:0x0020, B:10:0x0022, B:13:0x002b, B:15:0x0030, B:18:0x003a, B:21:0x0043, B:22:0x0068, B:23:0x0069, B:24:0x006e, B:25:0x0071, B:27:0x0075, B:29:0x0079, B:31:0x0081, B:32:0x0084, B:33:0x00ad, B:35:0x00af, B:37:0x00b3, B:39:0x00bb, B:40:0x00c0, B:41:0x00c3, B:43:0x00cb, B:44:0x00ce, B:46:0x00e9, B:48:0x00ef, B:50:0x00f6, B:49:0x00f3, B:51:0x00fb, B:53:0x0108, B:54:0x010e, B:58:0x0117, B:61:0x011f, B:63:0x0123, B:65:0x0130, B:67:0x0134, B:69:0x013c, B:71:0x0142, B:72:0x0148, B:73:0x0154, B:74:0x0157, B:81:0x0182, B:175:0x03c6, B:177:0x03cd, B:178:0x03d9, B:207:0x040b, B:209:0x0412, B:210:0x041e, B:80:0x017c), top: B:219:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:209:0x0412 A[Catch: all -> 0x041f, TryCatch #14 {, blocks: (B:4:0x000b, B:6:0x0018, B:8:0x0020, B:10:0x0022, B:13:0x002b, B:15:0x0030, B:18:0x003a, B:21:0x0043, B:22:0x0068, B:23:0x0069, B:24:0x006e, B:25:0x0071, B:27:0x0075, B:29:0x0079, B:31:0x0081, B:32:0x0084, B:33:0x00ad, B:35:0x00af, B:37:0x00b3, B:39:0x00bb, B:40:0x00c0, B:41:0x00c3, B:43:0x00cb, B:44:0x00ce, B:46:0x00e9, B:48:0x00ef, B:50:0x00f6, B:49:0x00f3, B:51:0x00fb, B:53:0x0108, B:54:0x010e, B:58:0x0117, B:61:0x011f, B:63:0x0123, B:65:0x0130, B:67:0x0134, B:69:0x013c, B:71:0x0142, B:72:0x0148, B:73:0x0154, B:74:0x0157, B:81:0x0182, B:175:0x03c6, B:177:0x03cd, B:178:0x03d9, B:207:0x040b, B:209:0x0412, B:210:0x041e, B:80:0x017c), top: B:219:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:218:0x0215 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.mysql.jdbc.ResultSetInternalMethods serverExecute(int r40, boolean r41, com.mysql.jdbc.Field[] r42) throws java.sql.SQLException {
        /*
            Method dump skipped, instruction units count: 1058
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mysql.jdbc.ServerPreparedStatement.serverExecute(int, boolean, com.mysql.jdbc.Field[]):com.mysql.jdbc.ResultSetInternalMethods");
    }

    private void serverLongData(int i, BindValue bindValue) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            MysqlIO io = this.connection.getIO();
            Buffer sharedSendPacket = io.getSharedSendPacket();
            Object obj = bindValue.value;
            if (obj instanceof byte[]) {
                sharedSendPacket.clear();
                sharedSendPacket.writeByte((byte) 24);
                sharedSendPacket.writeLong(this.serverStatementId);
                sharedSendPacket.writeInt(i);
                sharedSendPacket.writeBytesNoNull((byte[]) bindValue.value);
                io.sendCommand(24, null, sharedSendPacket, true, null, 0);
            } else if (obj instanceof InputStream) {
                storeStream(io, i, sharedSendPacket, (InputStream) obj);
            } else if (obj instanceof java.sql.Blob) {
                storeStream(io, i, sharedSendPacket, ((java.sql.Blob) obj).getBinaryStream());
            } else {
                if (!(obj instanceof Reader)) {
                    throw SQLError.createSQLException(Messages.getString("ServerPreparedStatement.18") + obj.getClass().getName() + "'", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                }
                storeReader(io, i, sharedSendPacket, (Reader) obj);
            }
        }
    }

    private void serverPrepare(String str) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            MysqlIO io = this.connection.getIO();
            if (this.connection.getAutoGenerateTestcaseScript()) {
                dumpPrepareForTestcase();
            }
            try {
                try {
                    if (StringUtils.startsWithIgnoreCaseAndWs(str, "LOAD DATA")) {
                        this.isLoadDataQuery = true;
                    } else {
                        this.isLoadDataQuery = false;
                    }
                    long jCurrentTimeMillis = this.connection.getProfileSql() ? System.currentTimeMillis() : 0L;
                    String encoding = this.connection.getEncoding();
                    Buffer bufferSendCommand = io.sendCommand(22, str, null, false, (this.isLoadDataQuery || !this.connection.getUseUnicode() || encoding == null) ? null : encoding, 0);
                    if (this.connection.versionMeetsMinimum(4, 1, 1)) {
                        bufferSendCommand.setPosition(1);
                    } else {
                        bufferSendCommand.setPosition(0);
                    }
                    this.serverStatementId = bufferSendCommand.readLong();
                    this.fieldCount = bufferSendCommand.readInt();
                    int i = bufferSendCommand.readInt();
                    this.parameterCount = i;
                    this.parameterBindings = new BindValue[i];
                    for (int i2 = 0; i2 < this.parameterCount; i2++) {
                        this.parameterBindings[i2] = new BindValue();
                    }
                    this.connection.incrementNumberOfPrepares();
                    if (this.profileSQL) {
                        this.eventSink.consumeEvent(new ProfilerEvent((byte) 2, BuildConfig.FLAVOR, this.currentCatalog, this.connectionId, this.statementId, -1, System.currentTimeMillis(), io.getCurrentTimeNanosOrMillis() - jCurrentTimeMillis, io.getQueryTimingUnits(), null, LogUtils.findCallingClassAndMethod(new Throwable()), truncateQueryToLog(str)));
                    }
                    boolean z = !io.isEOFDeprecated();
                    if (this.parameterCount > 0 && this.connection.versionMeetsMinimum(4, 1, 2) && !io.isVersion(5, 0, 0)) {
                        this.parameterFields = new Field[this.parameterCount];
                        for (int i3 = 0; i3 < this.parameterCount; i3++) {
                            this.parameterFields[i3] = io.unpackField(io.readPacket(), false);
                        }
                        if (z) {
                            io.readPacket();
                        }
                    }
                    int i4 = this.fieldCount;
                    if (i4 > 0) {
                        this.resultFields = new Field[i4];
                        for (int i5 = 0; i5 < this.fieldCount; i5++) {
                            this.resultFields[i5] = io.unpackField(io.readPacket(), false);
                        }
                        if (z) {
                            io.readPacket();
                        }
                    }
                    this.connection.getIO().clearInputStream();
                } catch (SQLException e) {
                    if (!this.connection.getDumpQueriesOnException()) {
                        throw e;
                    }
                    StringBuilder sb = new StringBuilder(this.originalSql.length() + 32);
                    sb.append("\n\nQuery being prepared when exception was thrown:\n\n");
                    sb.append(this.originalSql);
                    throw ConnectionImpl.appendMessageToException(e, sb.toString(), getExceptionInterceptor());
                }
            } catch (Throwable th) {
                this.connection.getIO().clearInputStream();
                throw th;
            }
        }
    }

    private void serverResetStatement() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            MysqlIO io = this.connection.getIO();
            Buffer sharedSendPacket = io.getSharedSendPacket();
            sharedSendPacket.clear();
            sharedSendPacket.writeByte((byte) 26);
            sharedSendPacket.writeLong(this.serverStatementId);
            try {
                try {
                    io.sendCommand(26, null, sharedSendPacket, !this.connection.versionMeetsMinimum(4, 1, 2), null, 0);
                    io.clearInputStream();
                } catch (SQLException e) {
                    throw e;
                } catch (Exception e2) {
                    SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(e2.toString(), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
                    sQLExceptionCreateSQLException.initCause(e2);
                    throw sQLExceptionCreateSQLException;
                }
            } catch (Throwable th) {
                io.clearInputStream();
                throw th;
            }
        }
    }

    private void setTimeInternal(int i, Time time, Calendar calendar, TimeZone timeZone, boolean z) throws SQLException {
        if (time == null) {
            setNull(i, 92);
            return;
        }
        BindValue binding = getBinding(i, false);
        resetToType(binding, 11);
        if (this.useLegacyDatetimeCode) {
            binding.value = TimeUtil.changeTimezone(this.connection, getCalendarInstanceForSessionOrNew(), calendar, time, timeZone, this.connection.getServerTimezoneTZ(), z);
        } else {
            binding.value = time;
            if (calendar != null) {
                binding.calendar = (Calendar) calendar.clone();
            }
        }
    }

    private void setTimestampInternal(int i, Timestamp timestamp, Calendar calendar, TimeZone timeZone, boolean z) throws SQLException {
        if (timestamp == null) {
            setNull(i, 93);
            return;
        }
        BindValue binding = getBinding(i, false);
        resetToType(binding, 12);
        if (!this.sendFractionalSeconds) {
            timestamp = TimeUtil.truncateFractionalSeconds(timestamp);
        }
        Timestamp timestamp2 = timestamp;
        if (this.useLegacyDatetimeCode) {
            binding.value = TimeUtil.changeTimezone(this.connection, TimeUtil.setProlepticIfNeeded(this.connection.getUseJDBCCompliantTimezoneShift() ? this.connection.getUtcCalendar() : getCalendarInstanceForSessionOrNew(), calendar), calendar, timestamp2, timeZone, this.connection.getServerTimezoneTZ(), z);
        } else {
            binding.value = timestamp2;
        }
        if (calendar != null) {
            binding.calendar = (Calendar) calendar.clone();
        }
    }

    private void storeBinding(Buffer buffer, BindValue bindValue, MysqlIO mysqlIO) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            try {
                try {
                    Object obj = bindValue.value;
                    int i = bindValue.bufferType;
                    if (i != 0) {
                        if (i == 1) {
                            buffer.writeByte((byte) bindValue.longBinding);
                            return;
                        }
                        if (i == 2) {
                            buffer.ensureCapacity(2);
                            buffer.writeInt((int) bindValue.longBinding);
                            return;
                        }
                        if (i == 3) {
                            buffer.ensureCapacity(4);
                            buffer.writeLong((int) bindValue.longBinding);
                            return;
                        }
                        if (i == 4) {
                            buffer.ensureCapacity(4);
                            buffer.writeFloat(bindValue.floatBinding);
                            return;
                        }
                        if (i == 5) {
                            buffer.ensureCapacity(8);
                            buffer.writeDouble(bindValue.doubleBinding);
                            return;
                        }
                        if (i != 7) {
                            if (i == 8) {
                                buffer.ensureCapacity(8);
                                buffer.writeLongLong(bindValue.longBinding);
                                return;
                            } else if (i != 15 && i != 246 && i != 253 && i != 254) {
                                switch (i) {
                                    case 10:
                                    case 12:
                                        break;
                                    case 11:
                                        storeTime(buffer, (Time) obj);
                                        return;
                                    default:
                                        return;
                                }
                            }
                        }
                        storeDateTime(buffer, (Date) obj, mysqlIO, i, bindValue.calendar);
                        return;
                    }
                    if (obj instanceof byte[]) {
                        buffer.writeLenBytes((byte[]) obj);
                    } else if (this.isLoadDataQuery) {
                        buffer.writeLenBytes(StringUtils.getBytes((String) obj));
                    } else {
                        buffer.writeLenString((String) obj, this.charEncoding, this.connection.getServerCharset(), this.charConverter, this.connection.parserKnowsUnicode(), this.connection);
                    }
                } catch (UnsupportedEncodingException unused) {
                    throw SQLError.createSQLException(Messages.getString("ServerPreparedStatement.22") + this.connection.getEncoding() + "'", SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void storeDateTime(Buffer buffer, Date date, MysqlIO mysqlIO, int i, Calendar calendar) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.connection.versionMeetsMinimum(4, 1, 3)) {
                storeDateTime413AndNewer(buffer, date, i, calendar);
            } else {
                storeDateTime412AndOlder(buffer, date, i);
            }
        }
    }

    private void storeDateTime412AndOlder(Buffer buffer, Date date, int i) throws SQLException {
        Calendar utcCalendar;
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.useLegacyDatetimeCode) {
                utcCalendar = ((date instanceof Timestamp) && this.connection.getUseJDBCCompliantTimezoneShift()) ? this.connection.getUtcCalendar() : getCalendarInstanceForSessionOrNew();
            } else {
                utcCalendar = i == 10 ? getDefaultTzCalendar() : getServerTzCalendar();
            }
            Date time = utcCalendar.getTime();
            try {
                buffer.ensureCapacity(8);
                buffer.writeByte((byte) 7);
                utcCalendar.setTime(date);
                int i2 = utcCalendar.get(1);
                int i3 = utcCalendar.get(2) + 1;
                int i4 = utcCalendar.get(5);
                buffer.writeInt(i2);
                buffer.writeByte((byte) i3);
                buffer.writeByte((byte) i4);
                if (date instanceof java.sql.Date) {
                    buffer.writeByte((byte) 0);
                    buffer.writeByte((byte) 0);
                    buffer.writeByte((byte) 0);
                } else {
                    buffer.writeByte((byte) utcCalendar.get(11));
                    buffer.writeByte((byte) utcCalendar.get(12));
                    buffer.writeByte((byte) utcCalendar.get(13));
                }
                utcCalendar.setTime(time);
            } catch (Throwable th) {
                utcCalendar.setTime(time);
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0047 A[Catch: all -> 0x00b1, TryCatch #0 {all -> 0x00b1, blocks: (B:19:0x0039, B:21:0x0047, B:22:0x0050, B:25:0x0057, B:27:0x007c, B:30:0x00a0, B:28:0x0086), top: B:40:0x0039, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0055  */
    /* JADX WARN: Code duplicated, block: B:27:0x007c A[Catch: all -> 0x00b1, TryCatch #0 {all -> 0x00b1, blocks: (B:19:0x0039, B:21:0x0047, B:22:0x0050, B:25:0x0057, B:27:0x007c, B:30:0x00a0, B:28:0x0086), top: B:40:0x0039, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0086 A[Catch: all -> 0x00b1, TryCatch #0 {all -> 0x00b1, blocks: (B:19:0x0039, B:21:0x0047, B:22:0x0050, B:25:0x0057, B:27:0x007c, B:30:0x00a0, B:28:0x0086), top: B:40:0x0039, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x00a0 A[Catch: all -> 0x00b1, TRY_LEAVE, TryCatch #0 {all -> 0x00b1, blocks: (B:19:0x0039, B:21:0x0047, B:22:0x0050, B:25:0x0057, B:27:0x007c, B:30:0x00a0, B:28:0x0086), top: B:40:0x0039, outer: #1 }] */
    private void storeDateTime413AndNewer(Buffer buffer, Date date, int i, Calendar calendar) throws SQLException {
        Date time;
        byte b;
        synchronized (checkClosed().getConnectionMutex()) {
            if (calendar == null) {
                if (this.useLegacyDatetimeCode) {
                    calendar = ((date instanceof Timestamp) && this.connection.getUseJDBCCompliantTimezoneShift()) ? this.connection.getUtcCalendar() : getCalendarInstanceForSessionOrNew();
                } else {
                    calendar = i == 10 ? getDefaultTzCalendar() : getServerTzCalendar();
                }
                time = calendar.getTime();
                try {
                    calendar.setTime(date);
                    if (date instanceof java.sql.Date) {
                        calendar.set(11, 0);
                        calendar.set(12, 0);
                        calendar.set(13, 0);
                    }
                    b = date instanceof Timestamp ? (byte) 11 : (byte) 7;
                    buffer.ensureCapacity(b);
                    buffer.writeByte(b);
                    int i2 = calendar.get(1);
                    int i3 = calendar.get(2) + 1;
                    int i4 = calendar.get(5);
                    buffer.writeInt(i2);
                    buffer.writeByte((byte) i3);
                    buffer.writeByte((byte) i4);
                    if (date instanceof java.sql.Date) {
                        buffer.writeByte((byte) 0);
                        buffer.writeByte((byte) 0);
                        buffer.writeByte((byte) 0);
                    } else {
                        buffer.writeByte((byte) calendar.get(11));
                        buffer.writeByte((byte) calendar.get(12));
                        buffer.writeByte((byte) calendar.get(13));
                    }
                    if (b == 11) {
                        buffer.writeLong(((Timestamp) date).getNanos() / 1000);
                    }
                    calendar.setTime(time);
                } catch (Throwable th) {
                    calendar.setTime(time);
                    throw th;
                }
            } else {
                time = calendar.getTime();
                calendar.setTime(date);
                if (date instanceof java.sql.Date) {
                    calendar.set(11, 0);
                    calendar.set(12, 0);
                    calendar.set(13, 0);
                }
                if (date instanceof Timestamp) {
                }
                buffer.ensureCapacity(b);
                buffer.writeByte(b);
                int i5 = calendar.get(1);
                int i6 = calendar.get(2) + 1;
                int i7 = calendar.get(5);
                buffer.writeInt(i5);
                buffer.writeByte((byte) i6);
                buffer.writeByte((byte) i7);
                if (date instanceof java.sql.Date) {
                    buffer.writeByte((byte) 0);
                    buffer.writeByte((byte) 0);
                    buffer.writeByte((byte) 0);
                } else {
                    buffer.writeByte((byte) calendar.get(11));
                    buffer.writeByte((byte) calendar.get(12));
                    buffer.writeByte((byte) calendar.get(13));
                }
                if (b == 11) {
                    buffer.writeLong(((Timestamp) date).getNanos() / 1000);
                }
                calendar.setTime(time);
            }
            throw th;
        }
    }

    private void storeReader(MysqlIO mysqlIO, int i, Buffer buffer, Reader reader) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            String clobCharacterEncoding = this.connection.getClobCharacterEncoding();
            if (clobCharacterEncoding == null) {
                clobCharacterEncoding = this.connection.getEncoding();
            }
            String str = clobCharacterEncoding;
            int i2 = 2;
            if (str != null) {
                if (str.equals("UTF-16")) {
                    i2 = 4;
                } else {
                    int maxBytesPerChar = this.connection.getMaxBytesPerChar(str);
                    if (maxBytesPerChar != 1) {
                        i2 = maxBytesPerChar;
                    }
                }
            }
            char[] cArr = new char[8192 / i2];
            int blobSendChunkSize = this.connection.getBlobSendChunkSize();
            try {
                try {
                    buffer.clear();
                    buffer.writeByte((byte) 24);
                    buffer.writeLong(this.serverStatementId);
                    buffer.writeInt(i);
                    int i3 = 0;
                    int i4 = 0;
                    boolean z = false;
                    int i5 = 0;
                    int i6 = 0;
                    while (true) {
                        int i7 = reader.read(cArr);
                        if (i7 == -1) {
                            break;
                        }
                        int i8 = i5;
                        byte[] bytes = StringUtils.getBytes(cArr, (SingleByteCharsetConverter) null, str, this.connection.getServerCharset(), 0, i7, this.connection.parserKnowsUnicode(), getExceptionInterceptor());
                        buffer.writeBytesNoNull(bytes, i3, bytes.length);
                        int length = i6 + bytes.length;
                        int length2 = bytes.length + i4;
                        if (length >= blobSendChunkSize) {
                            mysqlIO.sendCommand(24, null, buffer, true, null, 0);
                            buffer.clear();
                            buffer.writeByte((byte) 24);
                            buffer.writeLong(this.serverStatementId);
                            buffer.writeInt(i);
                            i8 = length2;
                            i6 = 0;
                        } else {
                            i6 = length;
                        }
                        i4 = length2;
                        str = str;
                        blobSendChunkSize = blobSendChunkSize;
                        cArr = cArr;
                        i3 = 0;
                        z = true;
                        i5 = i8;
                    }
                    if (i4 != i5) {
                        mysqlIO.sendCommand(24, null, buffer, true, null, 0);
                    }
                    if (!z) {
                        mysqlIO.sendCommand(24, null, buffer, true, null, 0);
                    }
                    if (this.connection.getAutoClosePStmtStreams() && reader != null) {
                        try {
                            reader.close();
                        } catch (IOException unused) {
                        }
                    }
                } catch (IOException e) {
                    SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(Messages.getString("ServerPreparedStatement.24") + e.toString(), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
                    sQLExceptionCreateSQLException.initCause(e);
                    throw sQLExceptionCreateSQLException;
                }
            } catch (Throwable th) {
                if (this.connection.getAutoClosePStmtStreams() && reader != null) {
                    try {
                        reader.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        }
    }

    private void storeStream(MysqlIO mysqlIO, int i, Buffer buffer, InputStream inputStream) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            byte[] bArr = new byte[8192];
            try {
                try {
                    int blobSendChunkSize = this.connection.getBlobSendChunkSize();
                    buffer.clear();
                    buffer.writeByte((byte) 24);
                    buffer.writeLong(this.serverStatementId);
                    buffer.writeInt(i);
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    boolean z = false;
                    while (true) {
                        int i5 = inputStream.read(bArr);
                        if (i5 == -1) {
                            break;
                        }
                        z = true;
                        buffer.writeBytesNoNull(bArr, 0, i5);
                        i4 += i5;
                        int i6 = i2 + i5;
                        if (i4 >= blobSendChunkSize) {
                            mysqlIO.sendCommand(24, null, buffer, true, null, 0);
                            buffer.clear();
                            buffer.writeByte((byte) 24);
                            buffer.writeLong(this.serverStatementId);
                            buffer.writeInt(i);
                            i2 = i6;
                            i3 = i2;
                            i4 = 0;
                        } else {
                            i2 = i6;
                        }
                    }
                    if (i2 != i3) {
                        mysqlIO.sendCommand(24, null, buffer, true, null, 0);
                    }
                    if (!z) {
                        mysqlIO.sendCommand(24, null, buffer, true, null, 0);
                    }
                    if (this.connection.getAutoClosePStmtStreams() && inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                } catch (IOException e) {
                    SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(Messages.getString("ServerPreparedStatement.25") + e.toString(), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
                    sQLExceptionCreateSQLException.initCause(e);
                    throw sQLExceptionCreateSQLException;
                }
            } catch (Throwable th) {
                if (this.connection.getAutoClosePStmtStreams() && inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        }
    }

    private void storeTime(Buffer buffer, Time time) throws SQLException {
        buffer.ensureCapacity(9);
        buffer.writeByte((byte) 8);
        buffer.writeByte((byte) 0);
        buffer.writeLong(0L);
        Calendar calendarInstanceForSessionOrNew = getCalendarInstanceForSessionOrNew();
        synchronized (calendarInstanceForSessionOrNew) {
            Date time2 = calendarInstanceForSessionOrNew.getTime();
            try {
                calendarInstanceForSessionOrNew.setTime(time);
                buffer.writeByte((byte) calendarInstanceForSessionOrNew.get(11));
                buffer.writeByte((byte) calendarInstanceForSessionOrNew.get(12));
                buffer.writeByte((byte) calendarInstanceForSessionOrNew.get(13));
                calendarInstanceForSessionOrNew.setTime(time2);
            } catch (Throwable th) {
                calendarInstanceForSessionOrNew.setTime(time2);
                throw th;
            }
        }
    }

    private String truncateQueryToLog(String str) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (str.length() > this.connection.getMaxQuerySizeToLog()) {
                StringBuilder sb = new StringBuilder(this.connection.getMaxQuerySizeToLog() + 12);
                sb.append(str.substring(0, this.connection.getMaxQuerySizeToLog()));
                sb.append(Messages.getString("MysqlIO.25"));
                str = sb.toString();
            }
        }
        return str;
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void addBatch() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.batchedArgs == null) {
                this.batchedArgs = new ArrayList();
            }
            this.batchedArgs.add(new BatchedBindValues(this.parameterBindings));
        }
    }

    @Override // com.mysql.jdbc.PreparedStatement
    public String asSql(boolean z) throws SQLException {
        String strAsSql;
        synchronized (checkClosed().getConnectionMutex()) {
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = PreparedStatement.getInstance(this.connection, this.originalSql, this.currentCatalog);
                int i = preparedStatement.parameterCount;
                int i2 = this.parameterCount;
                for (int i3 = 0; i3 < i && i3 < i2; i3++) {
                    BindValue[] bindValueArr = this.parameterBindings;
                    if (bindValueArr[i3] != null) {
                        if (bindValueArr[i3].isNull) {
                            preparedStatement.setNull(i3 + 1, 0);
                        } else {
                            BindValue bindValue = bindValueArr[i3];
                            int i4 = bindValue.bufferType;
                            if (i4 == 1) {
                                preparedStatement.setByte(i3 + 1, (byte) bindValue.longBinding);
                            } else if (i4 == 2) {
                                preparedStatement.setShort(i3 + 1, (short) bindValue.longBinding);
                            } else if (i4 == 3) {
                                preparedStatement.setInt(i3 + 1, (int) bindValue.longBinding);
                            } else if (i4 == 4) {
                                preparedStatement.setFloat(i3 + 1, bindValue.floatBinding);
                            } else if (i4 == 5) {
                                preparedStatement.setDouble(i3 + 1, bindValue.doubleBinding);
                            } else if (i4 != 8) {
                                preparedStatement.setObject(i3 + 1, bindValueArr[i3].value);
                            } else {
                                preparedStatement.setLong(i3 + 1, bindValue.longBinding);
                            }
                        }
                    }
                }
                strAsSql = preparedStatement.asSql(z);
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException unused) {
                    }
                }
            } catch (Throwable th) {
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException unused2) {
                    }
                }
                throw th;
            }
        }
        return strAsSql;
    }

    @Override // com.mysql.jdbc.PreparedStatement
    public boolean canRewriteAsMultiValueInsertAtSqlLevel() throws SQLException {
        boolean z;
        synchronized (checkClosed().getConnectionMutex()) {
            if (!this.hasCheckedRewrite) {
                this.hasCheckedRewrite = true;
                this.canRewrite = PreparedStatement.canRewrite(this.originalSql, isOnDuplicateKeyUpdate(), getLocationOfOnDuplicateKeyUpdate(), 0);
                this.parseInfo = new PreparedStatement.ParseInfo(this.originalSql, this.connection, this.connection.getMetaData(), this.charEncoding, this.charConverter);
            }
            z = this.canRewrite;
        }
        return z;
    }

    @Override // com.mysql.jdbc.StatementImpl
    public MySQLConnection checkClosed() throws SQLException {
        if (this.invalid) {
            throw this.invalidationException;
        }
        return super.checkClosed();
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void clearParameters() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            clearParametersInternal(true);
        }
    }

    @Override // com.mysql.jdbc.StatementImpl, java.sql.Statement, java.lang.AutoCloseable
    public void close() throws SQLException {
        MySQLConnection mySQLConnection = this.connection;
        if (mySQLConnection == null) {
            return;
        }
        synchronized (mySQLConnection.getConnectionMutex()) {
            if (!this.isCached || !isPoolable() || this.isClosed) {
                this.isClosed = false;
                realClose(true, true);
            } else {
                clearParameters();
                this.isClosed = true;
                this.connection.recachePreparedStatement(this);
            }
        }
    }

    @Override // com.mysql.jdbc.PreparedStatement
    public long[] computeMaxParameterSetSizeAndBatchSize(int i) throws SQLException {
        long[] jArr;
        synchronized (checkClosed().getConnectionMutex()) {
            long j = 10;
            long j2 = 0;
            long j3 = 0;
            int i2 = 0;
            while (i2 < i) {
                BindValue[] bindValueArr = ((BatchedBindValues) this.batchedArgs.get(i2)).batchedParameterValues;
                int i3 = this.parameterCount;
                long j4 = ((long) ((i3 + 7) / 8)) + j2 + ((long) (i3 * 2));
                for (int i4 = 0; i4 < this.parameterBindings.length; i4++) {
                    if (!bindValueArr[i4].isNull) {
                        long boundLength = bindValueArr[i4].getBoundLength();
                        if (!bindValueArr[i4].isLongData || boundLength != -1) {
                            j4 += boundLength;
                        }
                    }
                }
                j += j4;
                if (j4 > j3) {
                    j3 = j4;
                }
                i2++;
                j2 = 0;
            }
            jArr = new long[]{j3, j};
        }
        return jArr;
    }

    @Override // com.mysql.jdbc.PreparedStatement
    public boolean containsOnDuplicateKeyUpdateInSQL() {
        return this.hasOnDuplicateKeyUpdate;
    }

    @Override // com.mysql.jdbc.PreparedStatement
    public long[] executeBatchSerially(int i) throws SQLException {
        long[] jArr;
        long j;
        StatementImpl.CancelTask cancelTask;
        synchronized (checkClosed().getConnectionMutex()) {
            MySQLConnection mySQLConnection = this.connection;
            if (mySQLConnection.isReadOnly()) {
                throw SQLError.createSQLException(Messages.getString("ServerPreparedStatement.2") + Messages.getString("ServerPreparedStatement.3"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            clearWarnings();
            BindValue[] bindValueArr = this.parameterBindings;
            try {
                List<Object> list = this.batchedArgs;
                jArr = null;
                SQLException sQLException = null;
                StatementImpl.CancelTask cancelTask2 = null;
                if (list != null) {
                    int size = list.size();
                    long[] jArr2 = new long[size];
                    if (this.retrieveGeneratedKeys) {
                        this.batchedGeneratedKeys = new ArrayList<>(size);
                    }
                    int i2 = 0;
                    while (true) {
                        j = -3;
                        if (i2 < size) {
                            jArr2[i2] = -3;
                            i2++;
                        } else {
                            try {
                                break;
                            } catch (Throwable th) {
                                th = th;
                            }
                        }
                    }
                    if (mySQLConnection.getEnableQueryTimeouts() && i != 0 && mySQLConnection.versionMeetsMinimum(5, 0, 0)) {
                        cancelTask = new StatementImpl.CancelTask(this);
                        try {
                            mySQLConnection.getCancelTimer().schedule(cancelTask, i);
                        } catch (Throwable th2) {
                            th = th2;
                            cancelTask2 = cancelTask;
                            if (cancelTask2 != null) {
                                cancelTask2.cancel();
                                mySQLConnection.getCancelTimer().purge();
                            }
                            resetCancelledState();
                            throw th;
                        }
                    } else {
                        cancelTask = null;
                    }
                    BindValue[] bindValueArr2 = null;
                    for (int i3 = 0; i3 < size; i3++) {
                        Object obj = this.batchedArgs.get(i3);
                        try {
                            if (obj instanceof String) {
                                try {
                                    jArr2[i3] = executeUpdateInternal((String) obj, true, this.retrieveGeneratedKeys);
                                    getBatchedGeneratedKeys((this.results.getFirstCharOfQuery() == 'I' && containsOnDuplicateKeyInString((String) obj)) ? 1 : 0);
                                } catch (SQLException e) {
                                    e = e;
                                    j = -3;
                                    jArr2[i3] = j;
                                    if (!this.continueBatchOnError || (e instanceof MySQLTimeoutException) || (e instanceof MySQLStatementCancelledException) || hasDeadlockOrTimeoutRolledBackTx(e)) {
                                        long[] jArr3 = new long[i3];
                                        System.arraycopy(jArr2, 0, jArr3, 0, i3);
                                        throw SQLError.createBatchUpdateException(e, jArr3, getExceptionInterceptor());
                                    }
                                    sQLException = e;
                                }
                            } else {
                                this.parameterBindings = ((BatchedBindValues) obj).batchedParameterValues;
                                if (bindValueArr2 == null) {
                                    break;
                                }
                                int i4 = 0;
                                while (true) {
                                    BindValue[] bindValueArr3 = this.parameterBindings;
                                    if (i4 >= bindValueArr3.length) {
                                        break;
                                    }
                                    if (bindValueArr3[i4].bufferType != bindValueArr2[i4].bufferType) {
                                        this.sendTypesToServer = true;
                                        break;
                                    }
                                    i4++;
                                }
                                try {
                                    jArr2[i3] = executeUpdateInternal(false, true);
                                    bindValueArr2 = this.parameterBindings;
                                    getBatchedGeneratedKeys(containsOnDuplicateKeyUpdateInSQL() ? 1 : 0);
                                } catch (Throwable th3) {
                                    bindValueArr2 = this.parameterBindings;
                                    throw th3;
                                }
                            }
                            j = -3;
                        } catch (SQLException e2) {
                            e = e2;
                        }
                    }
                    if (cancelTask != null) {
                        cancelTask.cancel();
                        mySQLConnection.getCancelTimer().purge();
                    }
                    resetCancelledState();
                    if (sQLException != null) {
                        throw SQLError.createBatchUpdateException(sQLException, jArr2, getExceptionInterceptor());
                    }
                    jArr = jArr2;
                }
                if (jArr == null) {
                    jArr = new long[0];
                }
                this.parameterBindings = bindValueArr;
                this.sendTypesToServer = true;
                clearBatch();
            } catch (Throwable th4) {
                this.parameterBindings = bindValueArr;
                this.sendTypesToServer = true;
                clearBatch();
                throw th4;
            }
        }
        return jArr;
    }

    @Override // com.mysql.jdbc.PreparedStatement
    public ResultSetInternalMethods executeInternal(int i, Buffer buffer, boolean z, boolean z2, Field[] fieldArr, boolean z3) throws SQLException {
        ResultSetInternalMethods resultSetInternalMethodsServerExecute;
        synchronized (checkClosed().getConnectionMutex()) {
            this.numberOfExecutions++;
            try {
                resultSetInternalMethodsServerExecute = serverExecute(i, z, fieldArr);
            } catch (SQLException e) {
                if (this.connection.getEnablePacketDebug()) {
                    this.connection.getIO().dumpPacketRingBuffer();
                }
                if (!this.connection.getDumpQueriesOnException()) {
                    throw e;
                }
                String string = toString();
                StringBuilder sb = new StringBuilder(string.length() + 32);
                sb.append("\n\nQuery being executed when exception was thrown:\n");
                sb.append(string);
                sb.append("\n\n");
                throw ConnectionImpl.appendMessageToException(e, sb.toString(), getExceptionInterceptor());
            } catch (Exception e2) {
                if (this.connection.getEnablePacketDebug()) {
                    this.connection.getIO().dumpPacketRingBuffer();
                }
                SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(e2.toString(), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
                if (this.connection.getDumpQueriesOnException()) {
                    String string2 = toString();
                    StringBuilder sb2 = new StringBuilder(string2.length() + 32);
                    sb2.append("\n\nQuery being executed when exception was thrown:\n");
                    sb2.append(string2);
                    sb2.append("\n\n");
                    sQLExceptionCreateSQLException = ConnectionImpl.appendMessageToException(sQLExceptionCreateSQLException, sb2.toString(), getExceptionInterceptor());
                }
                sQLExceptionCreateSQLException.initCause(e2);
                throw sQLExceptionCreateSQLException;
            }
        }
        return resultSetInternalMethodsServerExecute;
    }

    @Override // com.mysql.jdbc.PreparedStatement
    public Buffer fillSendPacket() throws SQLException {
        return null;
    }

    @Override // com.mysql.jdbc.PreparedStatement
    public Buffer fillSendPacket(byte[][] bArr, InputStream[] inputStreamArr, boolean[] zArr, int[] iArr) throws SQLException {
        return null;
    }

    public BindValue getBinding(int i, boolean z) throws SQLException {
        BindValue bindValue;
        synchronized (checkClosed().getConnectionMutex()) {
            BindValue[] bindValueArr = this.parameterBindings;
            if (bindValueArr.length == 0) {
                throw SQLError.createSQLException(Messages.getString("ServerPreparedStatement.8"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            int i2 = i - 1;
            if (i2 < 0 || i2 >= bindValueArr.length) {
                throw SQLError.createSQLException(Messages.getString("ServerPreparedStatement.9") + (i2 + 1) + Messages.getString("ServerPreparedStatement.10") + this.parameterBindings.length, SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            if (bindValueArr[i2] == null) {
                bindValueArr[i2] = new BindValue();
            } else if (bindValueArr[i2].isLongData && !z) {
                this.detectedLongParameterSwitch = true;
            }
            bindValue = this.parameterBindings[i2];
        }
        return bindValue;
    }

    public byte[] getBytes(int i) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            BindValue binding = getBinding(i, false);
            if (binding.isNull) {
                return null;
            }
            if (binding.isLongData) {
                throw SQLError.createSQLFeatureNotSupportedException();
            }
            if (this.outByteBuffer == null) {
                this.outByteBuffer = new Buffer(this.connection.getNetBufferLength());
            }
            this.outByteBuffer.clear();
            int position = this.outByteBuffer.getPosition();
            storeBinding(this.outByteBuffer, binding, this.connection.getIO());
            int position2 = this.outByteBuffer.getPosition() - position;
            byte[] bArr = new byte[position2];
            System.arraycopy(this.outByteBuffer.getByteBuffer(), position, bArr, 0, position2);
            return bArr;
        }
    }

    @Override // com.mysql.jdbc.PreparedStatement
    public int getLocationOfOnDuplicateKeyUpdate() throws SQLException {
        int i;
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.locationOfOnDuplicateKeyUpdate == -2) {
                this.locationOfOnDuplicateKeyUpdate = StatementImpl.getOnDuplicateKeyLocation(this.originalSql, this.connection.getDontCheckOnDuplicateKeyUpdateInSQL(), this.connection.getRewriteBatchedStatements(), this.connection.isNoBackslashEscapesSet());
            }
            i = this.locationOfOnDuplicateKeyUpdate;
        }
        return i;
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public java.sql.ResultSetMetaData getMetaData() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            Field[] fieldArr = this.resultFields;
            if (fieldArr == null) {
                return null;
            }
            return new ResultSetMetaData(fieldArr, this.connection.getUseOldAliasMetadataBehavior(), this.connection.getYearIsDateType(), getExceptionInterceptor());
        }
    }

    public BindValue[] getParameterBindValues() {
        return this.parameterBindings;
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public ParameterMetaData getParameterMetaData() throws SQLException {
        MysqlParameterMetadata mysqlParameterMetadata;
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.parameterMetaData == null) {
                this.parameterMetaData = new MysqlParameterMetadata(this.parameterFields, this.parameterCount, getExceptionInterceptor());
            }
            mysqlParameterMetadata = this.parameterMetaData;
        }
        return mysqlParameterMetadata;
    }

    public long getServerStatementId() {
        return this.serverStatementId;
    }

    @Override // com.mysql.jdbc.StatementImpl
    public boolean isCursorRequired() throws SQLException {
        return this.resultFields != null && this.connection.isCursorFetchEnabled() && getResultSetType() == 1003 && getResultSetConcurrency() == 1007 && getFetchSize() > 0;
    }

    @Override // com.mysql.jdbc.PreparedStatement
    public boolean isNull(int i) {
        throw new IllegalArgumentException(Messages.getString("ServerPreparedStatement.7"));
    }

    public boolean isOnDuplicateKeyUpdate() throws SQLException {
        boolean z;
        synchronized (checkClosed().getConnectionMutex()) {
            z = getLocationOfOnDuplicateKeyUpdate() != -1;
        }
        return z;
    }

    @Override // com.mysql.jdbc.PreparedStatement
    public PreparedStatement prepareBatchedInsertSQL(MySQLConnection mySQLConnection, int i) throws SQLException {
        PreparedStatement preparedStatement;
        synchronized (checkClosed().getConnectionMutex()) {
            try {
                try {
                    preparedStatement = (PreparedStatement) ((Wrapper) mySQLConnection.prepareStatement(this.parseInfo.getSqlForBatch(i), this.resultSetType, this.resultSetConcurrency)).unwrap(PreparedStatement.class);
                    preparedStatement.setRetrieveGeneratedKeys(this.retrieveGeneratedKeys);
                } catch (UnsupportedEncodingException e) {
                    SQLException sQLExceptionCreateSQLException = SQLError.createSQLException("Unable to prepare batch statement", SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
                    sQLExceptionCreateSQLException.initCause(e);
                    throw sQLExceptionCreateSQLException;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return preparedStatement;
    }

    public void rePrepare() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            this.invalidationException = null;
            try {
                try {
                    serverPrepare(this.originalSql);
                } catch (Exception e) {
                    SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(e.toString(), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
                    this.invalidationException = sQLExceptionCreateSQLException;
                    sQLExceptionCreateSQLException.initCause(e);
                }
            } catch (SQLException e2) {
                this.invalidationException = e2;
            }
            if (this.invalidationException != null) {
                this.invalid = true;
                this.parameterBindings = null;
                this.parameterFields = null;
                this.resultFields = null;
                ResultSetInternalMethods resultSetInternalMethods = this.results;
                if (resultSetInternalMethods != null) {
                    try {
                        resultSetInternalMethods.close();
                    } catch (Exception unused) {
                    }
                }
                ResultSetInternalMethods resultSetInternalMethods2 = this.generatedKeysResults;
                if (resultSetInternalMethods2 != null) {
                    try {
                        resultSetInternalMethods2.close();
                    } catch (Exception unused2) {
                    }
                }
                try {
                    closeAllOpenResults();
                } catch (Exception unused3) {
                }
                if (this.connection != null && !this.connection.getDontTrackOpenResources()) {
                    this.connection.unregisterStatement(this);
                }
            }
        }
    }

    @Override // com.mysql.jdbc.PreparedStatement, com.mysql.jdbc.StatementImpl
    public void realClose(boolean z, boolean z2) throws SQLException {
        SQLException e;
        MySQLConnection mySQLConnection = this.connection;
        if (mySQLConnection == null) {
            return;
        }
        synchronized (mySQLConnection.getConnectionMutex()) {
            if (this.connection != null) {
                if (this.connection.getAutoGenerateTestcaseScript()) {
                    dumpCloseForTestcase();
                }
                if (!z || this.connection.isClosed()) {
                    e = null;
                } else {
                    synchronized (this.connection.getConnectionMutex()) {
                        try {
                            MysqlIO io = this.connection.getIO();
                            Buffer sharedSendPacket = io.getSharedSendPacket();
                            sharedSendPacket.writeByte((byte) 25);
                            sharedSendPacket.writeLong(this.serverStatementId);
                            io.sendCommand(25, null, sharedSendPacket, true, null, 0);
                            e = null;
                        } catch (SQLException e2) {
                            e = e2;
                        }
                    }
                }
                if (this.isCached) {
                    this.connection.decachePreparedStatement(this);
                    this.isCached = false;
                }
                super.realClose(z, z2);
                clearParametersInternal(false);
                this.parameterBindings = null;
                this.parameterFields = null;
                this.resultFields = null;
                if (e != null) {
                    throw e;
                }
            }
        }
    }

    public void resetToType(BindValue bindValue, int i) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            bindValue.reset();
            if ((i != 6 || bindValue.bufferType == 0) && bindValue.bufferType != i) {
                this.sendTypesToServer = true;
                bindValue.bufferType = i;
            }
            bindValue.isSet = true;
            bindValue.boundBeforeExecutionNum = this.numberOfExecutions;
        }
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setArray(int i, Array array) throws SQLException {
        throw SQLError.createSQLFeatureNotSupportedException();
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setAsciiStream(int i, InputStream inputStream, int i2) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            try {
                if (inputStream == null) {
                    setNull(i, -2);
                } else {
                    BindValue binding = getBinding(i, true);
                    resetToType(binding, MysqlDefs.FIELD_TYPE_BLOB);
                    binding.value = inputStream;
                    binding.isLongData = true;
                    if (this.connection.getUseStreamLengthsInPrepStmts()) {
                        binding.bindLength = i2;
                    } else {
                        binding.bindLength = -1L;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setBigDecimal(int i, BigDecimal bigDecimal) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            try {
                if (bigDecimal == null) {
                    setNull(i, 3);
                } else {
                    BindValue binding = getBinding(i, false);
                    if (this.connection.versionMeetsMinimum(5, 0, 3)) {
                        resetToType(binding, MysqlDefs.FIELD_TYPE_NEW_DECIMAL);
                    } else {
                        resetToType(binding, this.stringTypeCode);
                    }
                    binding.value = StringUtils.fixDecimalExponent(StringUtils.consistentToString(bigDecimal));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setBinaryStream(int i, InputStream inputStream, int i2) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            try {
                if (inputStream == null) {
                    setNull(i, -2);
                } else {
                    BindValue binding = getBinding(i, true);
                    resetToType(binding, MysqlDefs.FIELD_TYPE_BLOB);
                    binding.value = inputStream;
                    binding.isLongData = true;
                    if (this.connection.getUseStreamLengthsInPrepStmts()) {
                        binding.bindLength = i2;
                    } else {
                        binding.bindLength = -1L;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setBlob(int i, java.sql.Blob blob) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            try {
                if (blob == null) {
                    setNull(i, -2);
                } else {
                    BindValue binding = getBinding(i, true);
                    resetToType(binding, MysqlDefs.FIELD_TYPE_BLOB);
                    binding.value = blob;
                    binding.isLongData = true;
                    if (this.connection.getUseStreamLengthsInPrepStmts()) {
                        binding.bindLength = blob.length();
                    } else {
                        binding.bindLength = -1L;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setBoolean(int i, boolean z) throws SQLException {
        setByte(i, z ? (byte) 1 : (byte) 0);
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setByte(int i, byte b) throws SQLException {
        checkClosed();
        BindValue binding = getBinding(i, false);
        resetToType(binding, 1);
        binding.longBinding = b;
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setBytes(int i, byte[] bArr) throws SQLException {
        checkClosed();
        if (bArr == null) {
            setNull(i, -2);
            return;
        }
        BindValue binding = getBinding(i, false);
        resetToType(binding, MysqlDefs.FIELD_TYPE_VAR_STRING);
        binding.value = bArr;
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setCharacterStream(int i, Reader reader, int i2) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            try {
                if (reader == null) {
                    setNull(i, -2);
                } else {
                    BindValue binding = getBinding(i, true);
                    resetToType(binding, MysqlDefs.FIELD_TYPE_BLOB);
                    binding.value = reader;
                    binding.isLongData = true;
                    if (this.connection.getUseStreamLengthsInPrepStmts()) {
                        binding.bindLength = i2;
                    } else {
                        binding.bindLength = -1L;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setClob(int i, java.sql.Clob clob) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            try {
                if (clob == null) {
                    setNull(i, -2);
                } else {
                    BindValue binding = getBinding(i, true);
                    resetToType(binding, MysqlDefs.FIELD_TYPE_BLOB);
                    binding.value = clob.getCharacterStream();
                    binding.isLongData = true;
                    if (this.connection.getUseStreamLengthsInPrepStmts()) {
                        binding.bindLength = clob.length();
                    } else {
                        binding.bindLength = -1L;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setClosed(boolean z) {
        this.isClosed = z;
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setDate(int i, java.sql.Date date) throws SQLException {
        setDate(i, date, null);
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setDouble(int i, double d) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (!this.connection.getAllowNanAndInf() && (d == Double.POSITIVE_INFINITY || d == Double.NEGATIVE_INFINITY || Double.isNaN(d))) {
                throw SQLError.createSQLException("'" + d + "' is not a valid numeric or approximate numeric value", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            BindValue binding = getBinding(i, false);
            resetToType(binding, 5);
            binding.doubleBinding = d;
        }
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setFloat(int i, float f) throws SQLException {
        checkClosed();
        BindValue binding = getBinding(i, false);
        resetToType(binding, 4);
        binding.floatBinding = f;
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setInt(int i, int i2) throws SQLException {
        checkClosed();
        BindValue binding = getBinding(i, false);
        resetToType(binding, 3);
        binding.longBinding = i2;
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setLong(int i, long j) throws SQLException {
        checkClosed();
        BindValue binding = getBinding(i, false);
        resetToType(binding, 8);
        binding.longBinding = j;
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setNull(int i, int i2) throws SQLException {
        checkClosed();
        BindValue binding = getBinding(i, false);
        resetToType(binding, 6);
        binding.isNull = true;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00ab  */
    @Override // com.mysql.jdbc.PreparedStatement
    public int setOneBatchedParameterSet(java.sql.PreparedStatement preparedStatement, int i, Object obj) throws SQLException {
        int i2;
        int i3;
        BindValue[] bindValueArr = ((BatchedBindValues) obj).batchedParameterValues;
        for (int i4 = 0; i4 < bindValueArr.length; i4++) {
            if (bindValueArr[i4].isNull) {
                i2 = i + 1;
                preparedStatement.setNull(i, 0);
            } else {
                if (bindValueArr[i4].isLongData) {
                    Object obj2 = bindValueArr[i4].value;
                    if (obj2 instanceof InputStream) {
                        i3 = i + 1;
                        preparedStatement.setBinaryStream(i, (InputStream) obj2, (int) bindValueArr[i4].bindLength);
                    } else {
                        i3 = i + 1;
                        preparedStatement.setCharacterStream(i, (Reader) obj2, (int) bindValueArr[i4].bindLength);
                    }
                    i = i3;
                } else {
                    int i5 = bindValueArr[i4].bufferType;
                    if (i5 != 0) {
                        if (i5 == 1) {
                            i2 = i + 1;
                            preparedStatement.setByte(i, (byte) bindValueArr[i4].longBinding);
                        } else if (i5 == 2) {
                            i2 = i + 1;
                            preparedStatement.setShort(i, (short) bindValueArr[i4].longBinding);
                        } else if (i5 == 3) {
                            i2 = i + 1;
                            preparedStatement.setInt(i, (int) bindValueArr[i4].longBinding);
                        } else if (i5 == 4) {
                            i2 = i + 1;
                            preparedStatement.setFloat(i, bindValueArr[i4].floatBinding);
                        } else if (i5 == 5) {
                            i2 = i + 1;
                            preparedStatement.setDouble(i, bindValueArr[i4].doubleBinding);
                        } else if (i5 == 7) {
                            i2 = i + 1;
                            preparedStatement.setTimestamp(i, (Timestamp) bindValueArr[i4].value);
                        } else if (i5 == 8) {
                            i2 = i + 1;
                            preparedStatement.setLong(i, bindValueArr[i4].longBinding);
                        } else if (i5 != 15 && i5 != 246 && i5 != 253 && i5 != 254) {
                            switch (i5) {
                                case 10:
                                    i2 = i + 1;
                                    preparedStatement.setDate(i, (java.sql.Date) bindValueArr[i4].value);
                                    break;
                                case 11:
                                    i2 = i + 1;
                                    preparedStatement.setTime(i, (Time) bindValueArr[i4].value);
                                    break;
                                case 12:
                                    i2 = i + 1;
                                    preparedStatement.setTimestamp(i, (Timestamp) bindValueArr[i4].value);
                                    break;
                                default:
                                    throw new IllegalArgumentException("Unknown type when re-binding parameter into batched statement for parameter index " + i);
                            }
                        }
                    }
                    Object obj3 = bindValueArr[i4].value;
                    if (obj3 instanceof byte[]) {
                        preparedStatement.setBytes(i, (byte[]) obj3);
                    } else {
                        preparedStatement.setString(i, (String) obj3);
                    }
                    if (preparedStatement instanceof ServerPreparedStatement) {
                        ((ServerPreparedStatement) preparedStatement).getBinding(i, false).bufferType = bindValueArr[i4].bufferType;
                    }
                    i++;
                }
            }
            i = i2;
        }
        return i;
    }

    @Override // com.mysql.jdbc.StatementImpl, java.sql.Statement
    public void setPoolable(boolean z) throws SQLException {
        if (!z) {
            this.connection.decachePreparedStatement(this);
        }
        super.setPoolable(z);
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setRef(int i, Ref ref) throws SQLException {
        throw SQLError.createSQLFeatureNotSupportedException();
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setShort(int i, short s) throws SQLException {
        checkClosed();
        BindValue binding = getBinding(i, false);
        resetToType(binding, 2);
        binding.longBinding = s;
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setString(int i, String str) throws SQLException {
        checkClosed();
        if (str == null) {
            setNull(i, 1);
            return;
        }
        BindValue binding = getBinding(i, false);
        resetToType(binding, this.stringTypeCode);
        binding.value = str;
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setTime(int i, Time time) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            setTimeInternal(i, time, null, this.connection.getDefaultTimeZone(), false);
        }
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setTimestamp(int i, Timestamp timestamp) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            setTimestampInternal(i, timestamp, null, this.connection.getDefaultTimeZone(), false);
        }
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setURL(int i, URL url) throws SQLException {
        checkClosed();
        setString(i, url.toString());
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    @Deprecated
    public void setUnicodeStream(int i, InputStream inputStream, int i2) throws SQLException {
        checkClosed();
        throw SQLError.createSQLFeatureNotSupportedException();
    }

    @Override // com.mysql.jdbc.PreparedStatement
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("com.mysql.jdbc.ServerPreparedStatement[");
        sb.append(this.serverStatementId);
        sb.append("] - ");
        try {
            sb.append(asSql());
        } catch (SQLException e) {
            sb.append(Messages.getString("ServerPreparedStatement.6"));
            sb.append(e);
        }
        return sb.toString();
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setDate(int i, java.sql.Date date, Calendar calendar) throws SQLException {
        if (date == null) {
            setNull(i, 91);
            return;
        }
        BindValue binding = getBinding(i, false);
        resetToType(binding, 10);
        binding.value = date;
        if (calendar != null) {
            binding.calendar = (Calendar) calendar.clone();
        }
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setTime(int i, Time time, Calendar calendar) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            setTimeInternal(i, time, calendar, calendar.getTimeZone(), true);
        }
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setTimestamp(int i, Timestamp timestamp, Calendar calendar) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            setTimestampInternal(i, timestamp, calendar, calendar.getTimeZone(), true);
        }
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setNull(int i, int i2, String str) throws SQLException {
        checkClosed();
        BindValue binding = getBinding(i, false);
        resetToType(binding, 6);
        binding.isNull = true;
    }
}
