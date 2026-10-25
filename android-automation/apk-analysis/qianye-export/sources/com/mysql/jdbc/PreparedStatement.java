package com.mysql.jdbc;

import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.exceptions.MySQLStatementCancelledException;
import com.mysql.jdbc.exceptions.MySQLTimeoutException;
import com.mysql.jdbc.profiler.ProfilerEvent;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.sql.Array;
import java.sql.Date;
import java.sql.ParameterMetaData;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.TimerTask;
import okhttp3.internal.cache.DiskLruCache;

/* JADX INFO: loaded from: classes.dex */
public class PreparedStatement extends StatementImpl implements java.sql.PreparedStatement {
    private static final byte[] HEX_DIGITS;
    private static final Constructor<?> JDBC_4_PSTMT_2_ARG_CTOR;
    private static final Constructor<?> JDBC_4_PSTMT_3_ARG_CTOR;
    private static final Constructor<?> JDBC_4_PSTMT_4_ARG_CTOR;
    public int batchCommandIndex;
    public boolean batchHasPlainStatements;
    public String batchedValuesClause;
    private CharsetEncoder charsetEncoder;
    private boolean compensateForOnDuplicateKeyUpdate;
    private java.sql.DatabaseMetaData dbmd;
    private SimpleDateFormat ddf;
    private boolean doPingInstead;
    public char firstCharOfStmt;
    public boolean isLoadDataQuery;
    public boolean[] isNull;
    private boolean[] isStream;
    public int numberOfExecutions;
    public String originalSql;
    public int parameterCount;
    public MysqlParameterMetadata parameterMetaData;
    private InputStream[] parameterStreams;
    public int[] parameterTypes;
    private byte[][] parameterValues;
    public ParseInfo parseInfo;
    private java.sql.ResultSetMetaData pstmtResultMetaData;
    public int rewrittenBatchSize;
    public boolean serverSupportsFracSecs;
    private byte[][] staticSqlStrings;
    private byte[] streamConvertBuf;
    private int[] streamLengths;
    private SimpleDateFormat tdf;
    private SimpleDateFormat tsdf;
    public boolean useTrueBoolean;
    public boolean usingAnsiMode;

    public static class AppendingBatchVisitor implements BatchVisitor {
        public LinkedList<byte[]> statementComponents = new LinkedList<>();

        @Override // com.mysql.jdbc.PreparedStatement.BatchVisitor
        public BatchVisitor append(byte[] bArr) {
            this.statementComponents.addLast(bArr);
            return this;
        }

        @Override // com.mysql.jdbc.PreparedStatement.BatchVisitor
        public BatchVisitor decrement() {
            this.statementComponents.removeLast();
            return this;
        }

        public byte[][] getStaticSqlStrings() {
            byte[][] bArr = new byte[this.statementComponents.size()][];
            this.statementComponents.toArray(bArr);
            return bArr;
        }

        @Override // com.mysql.jdbc.PreparedStatement.BatchVisitor
        public BatchVisitor increment() {
            return this;
        }

        @Override // com.mysql.jdbc.PreparedStatement.BatchVisitor
        public BatchVisitor merge(byte[] bArr, byte[] bArr2) {
            byte[] bArr3 = new byte[bArr.length + bArr2.length];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
            this.statementComponents.addLast(bArr3);
            return this;
        }

        @Override // com.mysql.jdbc.PreparedStatement.BatchVisitor
        public BatchVisitor mergeWithLast(byte[] bArr) {
            return this.statementComponents.isEmpty() ? append(bArr) : merge(this.statementComponents.removeLast(), bArr);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator<byte[]> it = this.statementComponents.iterator();
            while (it.hasNext()) {
                sb.append(StringUtils.toString(it.next()));
            }
            return sb.toString();
        }
    }

    public class BatchParams {
        public boolean[] isNull;
        public boolean[] isStream;
        public InputStream[] parameterStreams;
        public byte[][] parameterStrings;
        public int[] streamLengths;

        public BatchParams(byte[][] bArr, InputStream[] inputStreamArr, boolean[] zArr, int[] iArr, boolean[] zArr2) {
            this.isNull = null;
            this.isStream = null;
            this.parameterStreams = null;
            this.parameterStrings = null;
            this.streamLengths = null;
            byte[][] bArr2 = new byte[bArr.length][];
            this.parameterStrings = bArr2;
            this.parameterStreams = new InputStream[inputStreamArr.length];
            this.isStream = new boolean[zArr.length];
            this.streamLengths = new int[iArr.length];
            this.isNull = new boolean[zArr2.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            System.arraycopy(inputStreamArr, 0, this.parameterStreams, 0, inputStreamArr.length);
            System.arraycopy(zArr, 0, this.isStream, 0, zArr.length);
            System.arraycopy(iArr, 0, this.streamLengths, 0, iArr.length);
            System.arraycopy(zArr2, 0, this.isNull, 0, zArr2.length);
        }
    }

    public interface BatchVisitor {
        BatchVisitor append(byte[] bArr);

        BatchVisitor decrement();

        BatchVisitor increment();

        BatchVisitor merge(byte[] bArr, byte[] bArr2);

        BatchVisitor mergeWithLast(byte[] bArr);
    }

    public class EmulatedPreparedStatementBindings implements ParameterBindings {
        private ResultSetImpl bindingsAsRs;
        private boolean[] parameterIsNull;

        public EmulatedPreparedStatementBindings() throws SQLException {
            int collationIndexForJavaEncoding;
            ArrayList arrayList = new ArrayList();
            int i = PreparedStatement.this.parameterCount;
            boolean[] zArr = new boolean[i];
            this.parameterIsNull = zArr;
            int i2 = 0;
            System.arraycopy(PreparedStatement.this.isNull, 0, zArr, 0, i);
            int i3 = PreparedStatement.this.parameterCount;
            byte[][] bArr = new byte[i3][];
            Field[] fieldArr = new Field[i3];
            while (i2 < PreparedStatement.this.parameterCount) {
                int i4 = PreparedStatement.this.batchCommandIndex;
                if (i4 == -1) {
                    bArr[i2] = PreparedStatement.this.getBytesRepresentation(i2);
                } else {
                    bArr[i2] = PreparedStatement.this.getBytesRepresentationForBatch(i2, i4);
                }
                int[] iArr = PreparedStatement.this.parameterTypes;
                if (iArr[i2] == -2 || iArr[i2] == 2004) {
                    collationIndexForJavaEncoding = 63;
                } else {
                    try {
                        collationIndexForJavaEncoding = CharsetMapping.getCollationIndexForJavaEncoding(PreparedStatement.this.connection.getEncoding(), PreparedStatement.this.connection);
                    } catch (RuntimeException e) {
                        SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(e.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
                        sQLExceptionCreateSQLException.initCause(e);
                        throw sQLExceptionCreateSQLException;
                    } catch (SQLException e2) {
                        throw e2;
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append("parameter_");
                int i5 = i2 + 1;
                sb.append(i5);
                Field field = new Field(null, sb.toString(), collationIndexForJavaEncoding, PreparedStatement.this.parameterTypes[i2], bArr[i2].length);
                field.setConnection(PreparedStatement.this.connection);
                fieldArr[i2] = field;
                i2 = i5;
            }
            arrayList.add(new ByteArrayRow(bArr, PreparedStatement.this.getExceptionInterceptor()));
            ResultSetImpl resultSetImpl = new ResultSetImpl(PreparedStatement.this.connection.getCatalog(), fieldArr, new RowDataStatic(arrayList), PreparedStatement.this.connection, null);
            this.bindingsAsRs = resultSetImpl;
            resultSetImpl.next();
        }

        @Override // com.mysql.jdbc.ParameterBindings
        public Array getArray(int i) throws SQLException {
            return this.bindingsAsRs.getArray(i);
        }

        @Override // com.mysql.jdbc.ParameterBindings
        public InputStream getAsciiStream(int i) throws SQLException {
            return this.bindingsAsRs.getAsciiStream(i);
        }

        @Override // com.mysql.jdbc.ParameterBindings
        public BigDecimal getBigDecimal(int i) throws SQLException {
            return this.bindingsAsRs.getBigDecimal(i);
        }

        @Override // com.mysql.jdbc.ParameterBindings
        public InputStream getBinaryStream(int i) throws SQLException {
            return this.bindingsAsRs.getBinaryStream(i);
        }

        @Override // com.mysql.jdbc.ParameterBindings
        public java.sql.Blob getBlob(int i) throws SQLException {
            return this.bindingsAsRs.getBlob(i);
        }

        @Override // com.mysql.jdbc.ParameterBindings
        public boolean getBoolean(int i) throws SQLException {
            return this.bindingsAsRs.getBoolean(i);
        }

        @Override // com.mysql.jdbc.ParameterBindings
        public byte getByte(int i) throws SQLException {
            return this.bindingsAsRs.getByte(i);
        }

        @Override // com.mysql.jdbc.ParameterBindings
        public byte[] getBytes(int i) throws SQLException {
            return this.bindingsAsRs.getBytes(i);
        }

        @Override // com.mysql.jdbc.ParameterBindings
        public Reader getCharacterStream(int i) throws SQLException {
            return this.bindingsAsRs.getCharacterStream(i);
        }

        @Override // com.mysql.jdbc.ParameterBindings
        public java.sql.Clob getClob(int i) throws SQLException {
            return this.bindingsAsRs.getClob(i);
        }

        @Override // com.mysql.jdbc.ParameterBindings
        public Date getDate(int i) throws SQLException {
            return this.bindingsAsRs.getDate(i);
        }

        @Override // com.mysql.jdbc.ParameterBindings
        public double getDouble(int i) throws SQLException {
            return this.bindingsAsRs.getDouble(i);
        }

        @Override // com.mysql.jdbc.ParameterBindings
        public float getFloat(int i) throws SQLException {
            return this.bindingsAsRs.getFloat(i);
        }

        @Override // com.mysql.jdbc.ParameterBindings
        public int getInt(int i) throws SQLException {
            return this.bindingsAsRs.getInt(i);
        }

        @Override // com.mysql.jdbc.ParameterBindings
        public long getLong(int i) throws SQLException {
            return this.bindingsAsRs.getLong(i);
        }

        @Override // com.mysql.jdbc.ParameterBindings
        public Reader getNCharacterStream(int i) throws SQLException {
            return this.bindingsAsRs.getCharacterStream(i);
        }

        @Override // com.mysql.jdbc.ParameterBindings
        public Reader getNClob(int i) throws SQLException {
            return this.bindingsAsRs.getCharacterStream(i);
        }

        @Override // com.mysql.jdbc.ParameterBindings
        public Object getObject(int i) throws SQLException {
            PreparedStatement.this.checkBounds(i, 0);
            int i2 = i - 1;
            if (this.parameterIsNull[i2]) {
                return null;
            }
            int i3 = PreparedStatement.this.parameterTypes[i2];
            if (i3 == -6) {
                return Byte.valueOf(getByte(i));
            }
            if (i3 == -5) {
                return Long.valueOf(getLong(i));
            }
            if (i3 == 4) {
                return Integer.valueOf(getInt(i));
            }
            if (i3 == 5) {
                return Short.valueOf(getShort(i));
            }
            if (i3 != 6) {
                return i3 != 8 ? this.bindingsAsRs.getObject(i) : Double.valueOf(getDouble(i));
            }
            return Float.valueOf(getFloat(i));
        }

        @Override // com.mysql.jdbc.ParameterBindings
        public Ref getRef(int i) throws SQLException {
            return this.bindingsAsRs.getRef(i);
        }

        @Override // com.mysql.jdbc.ParameterBindings
        public short getShort(int i) throws SQLException {
            return this.bindingsAsRs.getShort(i);
        }

        @Override // com.mysql.jdbc.ParameterBindings
        public String getString(int i) throws SQLException {
            return this.bindingsAsRs.getString(i);
        }

        @Override // com.mysql.jdbc.ParameterBindings
        public Time getTime(int i) throws SQLException {
            return this.bindingsAsRs.getTime(i);
        }

        @Override // com.mysql.jdbc.ParameterBindings
        public Timestamp getTimestamp(int i) throws SQLException {
            return this.bindingsAsRs.getTimestamp(i);
        }

        @Override // com.mysql.jdbc.ParameterBindings
        public URL getURL(int i) throws SQLException {
            return this.bindingsAsRs.getURL(i);
        }

        @Override // com.mysql.jdbc.ParameterBindings
        public boolean isNull(int i) throws SQLException {
            PreparedStatement.this.checkBounds(i, 0);
            return this.parameterIsNull[i - 1];
        }
    }

    public class EndPoint {
        public int begin;
        public int end;

        public EndPoint(int i, int i2) {
            this.begin = i;
            this.end = i2;
        }
    }

    public static final class ParseInfo {
        private ParseInfo batchHead;
        private ParseInfo batchODKUClause;
        private ParseInfo batchValues;
        public boolean canRewriteAsMultiValueInsert;
        public String charEncoding;
        public char firstStmtChar;
        public boolean foundLoadData;
        public boolean hasPlaceholders;
        public boolean isOnDuplicateKeyUpdate;
        public long lastUsed;
        public int locationOfOnDuplicateKeyUpdate;
        public int numberOfQueries;
        public boolean parametersInDuplicateKeyClause;
        public int statementLength;
        public int statementStartPos;
        public byte[][] staticSql;
        public String valuesClause;

        public ParseInfo(String str, MySQLConnection mySQLConnection, java.sql.DatabaseMetaData databaseMetaData, String str2, SingleByteCharsetConverter singleByteCharsetConverter) throws SQLException {
            this(str, mySQLConnection, databaseMetaData, str2, singleByteCharsetConverter, true);
        }

        private void buildInfoForBatch(int i, BatchVisitor batchVisitor) {
            if (!this.hasPlaceholders) {
                if (i == 1) {
                    batchVisitor.append(this.staticSql[0]);
                    return;
                }
                batchVisitor.append(this.batchHead.staticSql[0]).increment();
                int i2 = i - 1;
                if (this.batchODKUClause != null) {
                    i2--;
                }
                byte[] bArr = this.batchValues.staticSql[0];
                for (int i3 = 0; i3 < i2; i3++) {
                    batchVisitor.mergeWithLast(bArr).increment();
                }
                ParseInfo parseInfo = this.batchODKUClause;
                if (parseInfo != null) {
                    batchVisitor.mergeWithLast(parseInfo.staticSql[0]).increment();
                    return;
                }
                return;
            }
            byte[][] bArr2 = this.batchHead.staticSql;
            int length = bArr2.length - 1;
            byte[] bArr3 = bArr2[length];
            for (int i4 = 0; i4 < length; i4++) {
                batchVisitor.append(bArr2[i4]).increment();
            }
            int i5 = i - 1;
            if (this.batchODKUClause != null) {
                i5--;
            }
            byte[][] bArr4 = this.batchValues.staticSql;
            int length2 = bArr4.length;
            byte[] bArr5 = bArr4[0];
            int i6 = length2 - 1;
            byte[] bArr6 = bArr4[i6];
            for (int i7 = 0; i7 < i5; i7++) {
                batchVisitor.merge(bArr6, bArr5).increment();
                for (int i8 = 1; i8 < i6; i8++) {
                    batchVisitor.append(bArr4[i8]).increment();
                }
            }
            ParseInfo parseInfo2 = this.batchODKUClause;
            if (parseInfo2 == null) {
                batchVisitor.append(bArr3);
                return;
            }
            byte[][] bArr7 = parseInfo2.staticSql;
            int length3 = bArr7.length;
            byte[] bArr8 = bArr7[0];
            byte[] bArr9 = bArr7[length3 - 1];
            if (i <= 1) {
                batchVisitor.append(bArr9).increment();
                return;
            }
            if (i5 > 0) {
                bArr3 = bArr6;
            }
            batchVisitor.merge(bArr3, bArr8).increment();
            for (int i9 = 1; i9 < length3; i9++) {
                batchVisitor.append(bArr7[i9]).increment();
            }
        }

        private void buildRewriteBatchedParams(String str, MySQLConnection mySQLConnection, java.sql.DatabaseMetaData databaseMetaData, String str2, SingleByteCharsetConverter singleByteCharsetConverter) throws SQLException {
            String strSubstring = str;
            this.valuesClause = extractValuesClause(strSubstring, mySQLConnection.getMetaData().getIdentifierQuoteString());
            String strSubstring2 = this.isOnDuplicateKeyUpdate ? strSubstring.substring(this.locationOfOnDuplicateKeyUpdate) : null;
            if (this.isOnDuplicateKeyUpdate) {
                strSubstring = strSubstring.substring(0, this.locationOfOnDuplicateKeyUpdate);
            }
            this.batchHead = new ParseInfo(strSubstring, mySQLConnection, databaseMetaData, str2, singleByteCharsetConverter, false);
            this.batchValues = new ParseInfo("," + this.valuesClause, mySQLConnection, databaseMetaData, str2, singleByteCharsetConverter, false);
            this.batchODKUClause = null;
            if (strSubstring2 == null || strSubstring2.length() <= 0) {
                return;
            }
            this.batchODKUClause = new ParseInfo("," + this.valuesClause + " " + strSubstring2, mySQLConnection, databaseMetaData, str2, singleByteCharsetConverter, false);
        }

        private String extractValuesClause(String str, String str2) throws SQLException {
            int iIndexOfIgnoreCase;
            int iIndexOf;
            int i = this.statementStartPos;
            loop0: while (true) {
                iIndexOfIgnoreCase = -1;
                while (true) {
                    if (iIndexOfIgnoreCase == -1) {
                        iIndexOfIgnoreCase = str2.length() > 0 ? StringUtils.indexOfIgnoreCase(i, str, "VALUES", str2, str2, StringUtils.SEARCH_MODE__MRK_COM_WS) : StringUtils.indexOfIgnoreCase(i, str, "VALUES");
                        if (iIndexOfIgnoreCase <= 0) {
                            break loop0;
                        }
                        char cCharAt = str.charAt(iIndexOfIgnoreCase - 1);
                        if (!Character.isWhitespace(cCharAt) && cCharAt != ')' && cCharAt != '`') {
                            i = iIndexOfIgnoreCase + 6;
                            break;
                        }
                        int i2 = iIndexOfIgnoreCase + 6;
                        char cCharAt2 = str.charAt(i2);
                        if (!Character.isWhitespace(cCharAt2) && cCharAt2 != '(') {
                            i = i2;
                            break;
                        }
                    } else {
                        break loop0;
                    }
                }
            }
            if (iIndexOfIgnoreCase == -1 || (iIndexOf = str.indexOf(40, iIndexOfIgnoreCase + 6)) == -1) {
                return null;
            }
            return str.substring(iIndexOf, this.isOnDuplicateKeyUpdate ? this.locationOfOnDuplicateKeyUpdate : str.length());
        }

        public synchronized ParseInfo getParseInfoForBatch(int i) {
            AppendingBatchVisitor appendingBatchVisitor;
            appendingBatchVisitor = new AppendingBatchVisitor();
            buildInfoForBatch(i, appendingBatchVisitor);
            return new ParseInfo(appendingBatchVisitor.getStaticSqlStrings(), this.firstStmtChar, this.foundLoadData, this.isOnDuplicateKeyUpdate, this.locationOfOnDuplicateKeyUpdate, this.statementLength, this.statementStartPos);
        }

        public String getSqlForBatch(int i) throws UnsupportedEncodingException {
            return getSqlForBatch(getParseInfoForBatch(i));
        }

        public ParseInfo(String str, MySQLConnection mySQLConnection, java.sql.DatabaseMetaData databaseMetaData, String str2, SingleByteCharsetConverter singleByteCharsetConverter, boolean z) throws SQLException {
            char c;
            int i;
            int i2;
            int i3;
            int i4;
            this.firstStmtChar = (char) 0;
            this.foundLoadData = false;
            this.lastUsed = 0L;
            this.statementLength = 0;
            this.statementStartPos = 0;
            this.canRewriteAsMultiValueInsert = false;
            this.staticSql = null;
            this.hasPlaceholders = false;
            this.numberOfQueries = 1;
            this.isOnDuplicateKeyUpdate = false;
            int i5 = -1;
            this.locationOfOnDuplicateKeyUpdate = -1;
            this.parametersInDuplicateKeyClause = false;
            try {
                if (str == null) {
                    throw SQLError.createSQLException(Messages.getString("PreparedStatement.61"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, mySQLConnection.getExceptionInterceptor());
                }
                this.charEncoding = str2;
                this.lastUsed = System.currentTimeMillis();
                String identifierQuoteString = databaseMetaData.getIdentifierQuoteString();
                char cCharAt = (identifierQuoteString == null || identifierQuoteString.equals(" ") || identifierQuoteString.length() <= 0) ? (char) 0 : identifierQuoteString.charAt(0);
                this.statementLength = str.length();
                ArrayList arrayList = new ArrayList();
                boolean zIsNoBackslashEscapesSet = mySQLConnection.isNoBackslashEscapesSet();
                int iFindStartOfStatement = StatementImpl.findStartOfStatement(str);
                this.statementStartPos = iFindStartOfStatement;
                int i6 = 0;
                boolean z2 = false;
                char c2 = 0;
                boolean z3 = false;
                while (iFindStartOfStatement < this.statementLength) {
                    char cCharAt2 = str.charAt(iFindStartOfStatement);
                    if (this.firstStmtChar == 0 && Character.isLetter(cCharAt2)) {
                        char upperCase = Character.toUpperCase(cCharAt2);
                        this.firstStmtChar = upperCase;
                        if (upperCase == 'I') {
                            int onDuplicateKeyLocation = StatementImpl.getOnDuplicateKeyLocation(str, mySQLConnection.getDontCheckOnDuplicateKeyUpdateInSQL(), mySQLConnection.getRewriteBatchedStatements(), mySQLConnection.isNoBackslashEscapesSet());
                            this.locationOfOnDuplicateKeyUpdate = onDuplicateKeyLocation;
                            this.isOnDuplicateKeyUpdate = onDuplicateKeyLocation != i5;
                        }
                    }
                    if (zIsNoBackslashEscapesSet || cCharAt2 != '\\' || iFindStartOfStatement >= this.statementLength - 1) {
                        if (!z2 && cCharAt != 0 && cCharAt2 == cCharAt) {
                            z3 = !z3;
                        } else if (!z3) {
                            if (z2) {
                                if ((cCharAt2 == '\'' || cCharAt2 == '\"') && cCharAt2 == c2) {
                                    if (iFindStartOfStatement < this.statementLength - 1) {
                                        int i7 = iFindStartOfStatement + 1;
                                        if (str.charAt(i7) == c2) {
                                            iFindStartOfStatement = i7;
                                        }
                                    }
                                } else if ((cCharAt2 == '\'' || cCharAt2 == '\"') && cCharAt2 == c2) {
                                }
                                z2 = !z2;
                                c2 = 0;
                            } else if (cCharAt2 == '#' || (cCharAt2 == '-' && (i3 = iFindStartOfStatement + 1) < this.statementLength && str.charAt(i3) == '-')) {
                                int i8 = this.statementLength - 1;
                                while (iFindStartOfStatement < i8) {
                                    char cCharAt3 = str.charAt(iFindStartOfStatement);
                                    if (cCharAt3 == '\r' || cCharAt3 == '\n') {
                                        break;
                                        break;
                                    }
                                    iFindStartOfStatement++;
                                }
                            } else if (cCharAt2 == '/' && (i = iFindStartOfStatement + 1) < this.statementLength) {
                                char c3 = '*';
                                if (str.charAt(i) == '*') {
                                    int i9 = iFindStartOfStatement + 2;
                                    int i10 = i9;
                                    while (i9 < this.statementLength) {
                                        i10++;
                                        if (str.charAt(i9) == c3 && (i2 = i9 + 1) < this.statementLength && str.charAt(i2) == '/') {
                                            i10++;
                                            if (i10 >= this.statementLength) {
                                                break;
                                            }
                                            cCharAt2 = str.charAt(i10);
                                            break;
                                        }
                                        i9++;
                                        c3 = '*';
                                    }
                                    iFindStartOfStatement = i10;
                                }
                            } else if (cCharAt2 == '\'' || cCharAt2 == '\"') {
                                c2 = cCharAt2;
                                z2 = true;
                            }
                        }
                        if (!z2 && !z3) {
                            if (cCharAt2 == '?') {
                                arrayList.add(new int[]{i6, iFindStartOfStatement});
                                i6 = iFindStartOfStatement + 1;
                                if (this.isOnDuplicateKeyUpdate && iFindStartOfStatement > this.locationOfOnDuplicateKeyUpdate) {
                                    this.parametersInDuplicateKeyClause = true;
                                }
                            } else if (cCharAt2 == ';' && (i4 = iFindStartOfStatement + 1) < this.statementLength) {
                                while (i4 < this.statementLength && Character.isWhitespace(str.charAt(i4))) {
                                    i4++;
                                }
                                if (i4 < this.statementLength) {
                                    this.numberOfQueries++;
                                }
                                iFindStartOfStatement = i4 - 1;
                            }
                        }
                    } else {
                        iFindStartOfStatement++;
                    }
                    iFindStartOfStatement++;
                    i5 = -1;
                }
                if (this.firstStmtChar == 'L' && StringUtils.startsWithIgnoreCaseAndWs(str, "LOAD DATA")) {
                    this.foundLoadData = true;
                    c = 0;
                } else {
                    c = 0;
                    this.foundLoadData = false;
                }
                int[] iArr = new int[2];
                iArr[c] = i6;
                iArr[1] = this.statementLength;
                arrayList.add(iArr);
                byte[][] bArr = new byte[arrayList.size()][];
                this.staticSql = bArr;
                this.hasPlaceholders = bArr.length > 1;
                for (int i11 = 0; i11 < this.staticSql.length; i11++) {
                    int[] iArr2 = (int[]) arrayList.get(i11);
                    int i12 = iArr2[1];
                    int i13 = iArr2[0];
                    int i14 = i12 - i13;
                    if (this.foundLoadData) {
                        this.staticSql[i11] = StringUtils.getBytes(str, i13, i14);
                    } else if (str2 == null) {
                        byte[] bArr2 = new byte[i14];
                        for (int i15 = 0; i15 < i14; i15++) {
                            bArr2[i15] = (byte) str.charAt(i13 + i15);
                        }
                        this.staticSql[i11] = bArr2;
                    } else if (singleByteCharsetConverter != null) {
                        this.staticSql[i11] = StringUtils.getBytes(str, singleByteCharsetConverter, str2, mySQLConnection.getServerCharset(), i13, i14, mySQLConnection.parserKnowsUnicode(), mySQLConnection.getExceptionInterceptor());
                    } else {
                        this.staticSql[i11] = StringUtils.getBytes(str, str2, mySQLConnection.getServerCharset(), i13, i14, mySQLConnection.parserKnowsUnicode(), mySQLConnection, mySQLConnection.getExceptionInterceptor());
                    }
                }
                if (z) {
                    boolean z4 = this.numberOfQueries == 1 && !this.parametersInDuplicateKeyClause && PreparedStatement.canRewrite(str, this.isOnDuplicateKeyUpdate, this.locationOfOnDuplicateKeyUpdate, this.statementStartPos);
                    this.canRewriteAsMultiValueInsert = z4;
                    if (z4 && mySQLConnection.getRewriteBatchedStatements()) {
                        buildRewriteBatchedParams(str, mySQLConnection, databaseMetaData, str2, singleByteCharsetConverter);
                    }
                }
            } catch (StringIndexOutOfBoundsException e) {
                SQLException sQLException = new SQLException("Parse error for " + str);
                sQLException.initCause(e);
                throw sQLException;
            }
        }

        public String getSqlForBatch(ParseInfo parseInfo) throws UnsupportedEncodingException {
            byte[][] bArr = parseInfo.staticSql;
            int length = bArr.length;
            int i = 0;
            int length2 = 0;
            for (byte[] bArr2 : bArr) {
                length2 = length2 + bArr2.length + 1;
            }
            StringBuilder sb = new StringBuilder(length2);
            while (true) {
                int i2 = length - 1;
                if (i < i2) {
                    sb.append(StringUtils.toString(bArr[i], this.charEncoding));
                    sb.append("?");
                    i++;
                } else {
                    sb.append(StringUtils.toString(bArr[i2]));
                    return sb.toString();
                }
            }
        }

        private ParseInfo(byte[][] bArr, char c, boolean z, boolean z2, int i, int i2, int i3) {
            this.firstStmtChar = (char) 0;
            this.foundLoadData = false;
            this.lastUsed = 0L;
            this.statementLength = 0;
            this.statementStartPos = 0;
            this.canRewriteAsMultiValueInsert = false;
            this.staticSql = null;
            this.hasPlaceholders = false;
            this.numberOfQueries = 1;
            this.isOnDuplicateKeyUpdate = false;
            this.locationOfOnDuplicateKeyUpdate = -1;
            this.parametersInDuplicateKeyClause = false;
            this.firstStmtChar = c;
            this.foundLoadData = z;
            this.isOnDuplicateKeyUpdate = z2;
            this.locationOfOnDuplicateKeyUpdate = i;
            this.statementLength = i2;
            this.statementStartPos = i3;
            this.staticSql = bArr;
        }
    }

    static {
        if (Util.isJdbc4()) {
            try {
                String str = Util.isJdbc42() ? "com.mysql.jdbc.JDBC42PreparedStatement" : "com.mysql.jdbc.JDBC4PreparedStatement";
                JDBC_4_PSTMT_2_ARG_CTOR = Class.forName(str).getConstructor(MySQLConnection.class, String.class);
                JDBC_4_PSTMT_3_ARG_CTOR = Class.forName(str).getConstructor(MySQLConnection.class, String.class, String.class);
                JDBC_4_PSTMT_4_ARG_CTOR = Class.forName(str).getConstructor(MySQLConnection.class, String.class, String.class, ParseInfo.class);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException(e2);
            } catch (SecurityException e3) {
                throw new RuntimeException(e3);
            }
        } else {
            JDBC_4_PSTMT_2_ARG_CTOR = null;
            JDBC_4_PSTMT_3_ARG_CTOR = null;
            JDBC_4_PSTMT_4_ARG_CTOR = null;
        }
        HEX_DIGITS = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
    }

    public PreparedStatement(MySQLConnection mySQLConnection, String str) throws SQLException {
        super(mySQLConnection, str);
        this.batchHasPlainStatements = false;
        this.dbmd = null;
        this.firstCharOfStmt = (char) 0;
        this.isLoadDataQuery = false;
        this.isNull = null;
        this.isStream = null;
        this.numberOfExecutions = 0;
        this.originalSql = null;
        this.parameterStreams = null;
        this.parameterValues = null;
        this.parameterTypes = null;
        this.staticSqlStrings = null;
        this.streamConvertBuf = null;
        this.streamLengths = null;
        this.tsdf = null;
        this.useTrueBoolean = false;
        this.compensateForOnDuplicateKeyUpdate = false;
        this.batchCommandIndex = -1;
        this.rewrittenBatchSize = 0;
        detectFractionalSecondsSupport();
        this.compensateForOnDuplicateKeyUpdate = this.connection.getCompensateOnDuplicateKeyUpdateCounts();
    }

    public static boolean canRewrite(String str, boolean z, int i, int i2) {
        int iIndexOfIgnoreCase;
        if (!StringUtils.startsWithIgnoreCaseAndWs(str, "INSERT", i2)) {
            return StringUtils.startsWithIgnoreCaseAndWs(str, "REPLACE", i2) && StringUtils.indexOfIgnoreCase(i2, str, "SELECT", "\"'`", "\"'`", StringUtils.SEARCH_MODE__MRK_COM_WS) == -1;
        }
        Set<StringUtils.SearchMode> set = StringUtils.SEARCH_MODE__MRK_COM_WS;
        if (StringUtils.indexOfIgnoreCase(i2, str, "SELECT", "\"'`", "\"'`", set) != -1) {
            return false;
        }
        return !z || (iIndexOfIgnoreCase = StringUtils.indexOfIgnoreCase(i, str, " UPDATE ")) == -1 || StringUtils.indexOfIgnoreCase(iIndexOfIgnoreCase, str, "LAST_INSERT_ID", "\"'`", "\"'`", set) == -1;
    }

    private void checkAllParametersSet(byte[] bArr, InputStream inputStream, int i) throws SQLException {
        if (bArr == null && inputStream == null) {
            throw SQLError.createSQLException(Messages.getString("PreparedStatement.40") + (i + 1), SQLError.SQL_STATE_WRONG_NO_OF_PARAMETERS, getExceptionInterceptor());
        }
    }

    private void doSSPSCompatibleTimezoneShift(int i, Timestamp timestamp, int i2, Calendar calendar) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            Calendar prolepticIfNeeded = TimeUtil.setProlepticIfNeeded(this.connection.getUseJDBCCompliantTimezoneShift() ? this.connection.getUtcCalendar() : getCalendarInstanceForSessionOrNew(), calendar);
            synchronized (prolepticIfNeeded) {
                java.util.Date time = prolepticIfNeeded.getTime();
                try {
                    prolepticIfNeeded.setTime(timestamp);
                    int i3 = prolepticIfNeeded.get(1);
                    int i4 = prolepticIfNeeded.get(2) + 1;
                    int i5 = prolepticIfNeeded.get(5);
                    int i6 = prolepticIfNeeded.get(11);
                    int i7 = prolepticIfNeeded.get(12);
                    int i8 = prolepticIfNeeded.get(13);
                    StringBuilder sb = new StringBuilder();
                    sb.append('\'');
                    sb.append(i3);
                    sb.append("-");
                    if (i4 < 10) {
                        sb.append('0');
                    }
                    sb.append(i4);
                    sb.append('-');
                    if (i5 < 10) {
                        sb.append('0');
                    }
                    sb.append(i5);
                    sb.append(' ');
                    if (i6 < 10) {
                        sb.append('0');
                    }
                    sb.append(i6);
                    sb.append(':');
                    if (i7 < 10) {
                        sb.append('0');
                    }
                    sb.append(i7);
                    sb.append(':');
                    if (i8 < 10) {
                        sb.append('0');
                    }
                    sb.append(i8);
                    sb.append('.');
                    sb.append(TimeUtil.formatNanos(timestamp.getNanos(), this.serverSupportsFracSecs, i2));
                    sb.append('\'');
                    setInternal(i, sb.toString());
                    prolepticIfNeeded.setTime(time);
                } catch (Throwable th) {
                    prolepticIfNeeded.setTime(time);
                    throw th;
                }
            }
        }
    }

    private final void escapeblockFast(byte[] bArr, Buffer buffer, int i) throws SQLException {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            byte b = bArr[i3];
            if (b == 0) {
                if (i3 > i2) {
                    buffer.writeBytesNoNull(bArr, i2, i3 - i2);
                }
                buffer.writeByte((byte) 92);
                buffer.writeByte((byte) 48);
                i2 = i3 + 1;
            } else if (b == 92 || b == 39 || (!this.usingAnsiMode && b == 34)) {
                if (i3 > i2) {
                    buffer.writeBytesNoNull(bArr, i2, i3 - i2);
                }
                buffer.writeByte((byte) 92);
                i2 = i3;
            }
        }
        if (i2 < i) {
            buffer.writeBytesNoNull(bArr, i2, i - i2);
        }
    }

    private String generateMultiStatementForBatch(int i) throws SQLException {
        String string;
        synchronized (checkClosed().getConnectionMutex()) {
            StringBuilder sb = new StringBuilder((this.originalSql.length() + 1) * i);
            sb.append(this.originalSql);
            for (int i2 = 0; i2 < i - 1; i2++) {
                sb.append(';');
                sb.append(this.originalSql);
            }
            string = sb.toString();
        }
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:86:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:96:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:97:0x0200  */
    private final String getDateTimePattern(String str, boolean z) throws Exception {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int length = str != null ? str.length() : 0;
        if (length >= 8 && length <= 10) {
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= length) {
                    z5 = true;
                    break;
                }
                char cCharAt = str.charAt(i);
                if (!Character.isDigit(cCharAt) && cCharAt != '-') {
                    z5 = false;
                    break;
                }
                if (cCharAt == '-') {
                    i2++;
                }
                i++;
            }
            if (z5 && i2 == 2) {
                return "yyyy-MM-dd";
            }
        }
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                z2 = true;
                break;
            }
            char cCharAt2 = str.charAt(i3);
            if (!Character.isDigit(cCharAt2) && cCharAt2 != ':') {
                z2 = false;
                break;
            }
            i3++;
        }
        if (z2) {
            return "HH:mm:ss";
        }
        StringReader stringReader = new StringReader(str + " ");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i4 = 3;
        arrayList.add(new Object[]{'y', new StringBuilder(), 0});
        if (z) {
            arrayList.add(new Object[]{'h', new StringBuilder(), 0});
        }
        while (true) {
            int i5 = stringReader.read();
            if (i5 == -1) {
                break;
            }
            char c = (char) i5;
            int size = arrayList.size();
            int i6 = 0;
            while (i6 < size) {
                Object[] objArr = (Object[]) arrayList.get(i6);
                int iIntValue = ((Integer) objArr[2]).intValue();
                char successor = getSuccessor(((Character) objArr[0]).charValue(), iIntValue);
                if (Character.isLetterOrDigit(c)) {
                    if (successor == 'X') {
                        Object[] objArr2 = new Object[i4];
                        StringBuilder sb = new StringBuilder(((StringBuilder) objArr[1]).toString());
                        sb.append('M');
                        objArr2[1] = sb;
                        objArr2[0] = 'M';
                        objArr2[2] = 1;
                        arrayList.add(objArr2);
                        successor = 'y';
                    } else if (successor == 'Y') {
                        StringBuilder sb2 = new StringBuilder(((StringBuilder) objArr[1]).toString());
                        sb2.append('d');
                        arrayList.add(new Object[]{'d', sb2, 1});
                        successor = 'M';
                    }
                    ((StringBuilder) objArr[1]).append(successor);
                    if (successor == ((Character) objArr[0]).charValue()) {
                        objArr[2] = Integer.valueOf(iIntValue + 1);
                    } else {
                        objArr[0] = Character.valueOf(successor);
                        objArr[2] = 1;
                    }
                } else if (successor != ((Character) objArr[0]).charValue() || successor == 'S') {
                    ((StringBuilder) objArr[1]).append(c);
                    if (successor == 'X' || successor == 'Y') {
                        objArr[2] = 4;
                    }
                } else {
                    arrayList2.add(objArr);
                }
                i6++;
                i4 = 3;
            }
            int size2 = arrayList2.size();
            for (int i7 = 0; i7 < size2; i7++) {
                arrayList.remove((Object[]) arrayList2.get(i7));
            }
            arrayList2.clear();
            i4 = 3;
        }
        int size3 = arrayList.size();
        for (int i8 = 0; i8 < size3; i8++) {
            Object[] objArr3 = (Object[]) arrayList.get(i8);
            char cCharValue = ((Character) objArr3[0]).charValue();
            boolean z6 = getSuccessor(cCharValue, ((Integer) objArr3[2]).intValue()) != cCharValue;
            if (cCharValue != 's' && cCharValue != 'm') {
                z3 = cCharValue == 'h' && z;
                boolean z7 = (z6 || cCharValue != 'd' || z) ? false : true;
                if (((StringBuilder) objArr3[1]).toString().indexOf(87) != -1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if ((z3 && !z7) || z4) {
                    arrayList2.add(objArr3);
                }
            }
            if (z6) {
            }
            if (z6) {
            }
            if (((StringBuilder) objArr3[1]).toString().indexOf(87) != -1) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z3) {
            }
        }
        int size4 = arrayList2.size();
        for (int i9 = 0; i9 < size4; i9++) {
            arrayList.remove(arrayList2.get(i9));
        }
        arrayList2.clear();
        StringBuilder sb3 = (StringBuilder) ((Object[]) arrayList.get(0))[1];
        sb3.setLength(sb3.length() - 1);
        return sb3.toString();
    }

    public static PreparedStatement getInstance(MySQLConnection mySQLConnection, String str) throws SQLException {
        return !Util.isJdbc4() ? new PreparedStatement(mySQLConnection, str) : (PreparedStatement) Util.handleNewInstance(JDBC_4_PSTMT_2_ARG_CTOR, new Object[]{mySQLConnection, str}, mySQLConnection.getExceptionInterceptor());
    }

    private final char getSuccessor(char c, int i) {
        if (c == 'y' && i == 2) {
            return 'X';
        }
        if (c == 'y' && i < 4) {
            return 'y';
        }
        if (c != 'y') {
            if (c == 'M' && i == 2) {
                return 'Y';
            }
            if (c != 'M' || i >= 3) {
                if (c == 'M' || (c == 'd' && i < 2)) {
                    return 'd';
                }
                if (c == 'd' || (c == 'H' && i < 2)) {
                    return 'H';
                }
                if (c == 'H' || (c == 'm' && i < 2)) {
                    return 'm';
                }
                if (c == 'm') {
                    return 's';
                }
                return (c != 's' || i >= 2) ? 'W' : 's';
            }
        }
        return 'M';
    }

    private final void hexEscapeBlock(byte[] bArr, Buffer buffer, int i) throws SQLException {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = bArr[i2] & StatementImpl.USES_VARIABLES_UNKNOWN;
            byte[] bArr2 = HEX_DIGITS;
            buffer.writeByte(bArr2[i3 / 16]);
            buffer.writeByte(bArr2[i3 % 16]);
        }
    }

    private void initializeFromParseInfo() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            ParseInfo parseInfo = this.parseInfo;
            byte[][] bArr = parseInfo.staticSql;
            this.staticSqlStrings = bArr;
            this.isLoadDataQuery = parseInfo.foundLoadData;
            this.firstCharOfStmt = parseInfo.firstStmtChar;
            int length = bArr.length - 1;
            this.parameterCount = length;
            this.parameterValues = new byte[length][];
            this.parameterStreams = new InputStream[length];
            this.isStream = new boolean[length];
            this.streamLengths = new int[length];
            this.isNull = new boolean[length];
            this.parameterTypes = new int[length];
            clearParameters();
            for (int i = 0; i < this.parameterCount; i++) {
                this.isStream[i] = false;
            }
        }
    }

    private boolean isEscapeNeededForString(String str, int i) {
        boolean z = false;
        for (int i2 = 0; i2 < i; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == 0 || cCharAt == '\n' || cCharAt == '\r' || cCharAt == 26 || cCharAt == '\"' || cCharAt == '\'' || cCharAt == '\\') {
                z = true;
            }
            if (z) {
                break;
            }
        }
        return z;
    }

    private void newSetDateInternal(int i, Date date, Calendar calendar) throws SQLException {
        TimeZone defaultTimeZone;
        synchronized (checkClosed().getConnectionMutex()) {
            SimpleDateFormat simpleDateFormat = this.ddf;
            if (calendar != null) {
                defaultTimeZone = null;
            } else {
                defaultTimeZone = this.connection.getNoTimezoneConversionForDateType() ? this.connection.getDefaultTimeZone() : this.connection.getServerTimezoneTZ();
            }
            SimpleDateFormat simpleDateFormat2 = TimeUtil.getSimpleDateFormat(simpleDateFormat, "''yyyy-MM-dd''", calendar, defaultTimeZone);
            this.ddf = simpleDateFormat2;
            setInternal(i, simpleDateFormat2.format((java.util.Date) date));
        }
    }

    private void newSetTimeInternal(int i, Time time, Calendar calendar) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            SimpleDateFormat simpleDateFormat = TimeUtil.getSimpleDateFormat(this.tdf, "''HH:mm:ss''", calendar, calendar != null ? null : this.connection.getServerTimezoneTZ());
            this.tdf = simpleDateFormat;
            setInternal(i, simpleDateFormat.format((java.util.Date) time));
        }
    }

    private void newSetTimestampInternal(int i, Timestamp timestamp, Calendar calendar) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            this.tsdf = TimeUtil.getSimpleDateFormat(this.tsdf, "''yyyy-MM-dd HH:mm:ss", calendar, calendar != null ? null : this.connection.getServerTimezoneTZ());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.tsdf.format((java.util.Date) timestamp));
            stringBuffer.append('.');
            stringBuffer.append(TimeUtil.formatNanos(timestamp.getNanos(), this.serverSupportsFracSecs, 6));
            stringBuffer.append('\'');
            setInternal(i, stringBuffer.toString());
        }
    }

    public static int readFully(Reader reader, char[] cArr, int i) throws IOException {
        int i2 = 0;
        while (i2 < i) {
            int i3 = reader.read(cArr, i2, i - i2);
            if (i3 < 0) {
                break;
            }
            i2 += i3;
        }
        return i2;
    }

    private final int readblock(InputStream inputStream, byte[] bArr) throws SQLException {
        try {
            return inputStream.read(bArr);
        } catch (Throwable th) {
            SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(Messages.getString("PreparedStatement.56") + th.getClass().getName(), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
            sQLExceptionCreateSQLException.initCause(th);
            throw sQLExceptionCreateSQLException;
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0046  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    private void setNumericObject(int i, Object obj, int i2, int i3) throws SQLException {
        BigDecimal scale;
        Number numberValueOf = 1;
        if (obj instanceof Boolean) {
            if (!((Boolean) obj).booleanValue()) {
                numberValueOf = 0;
            }
        } else if (!(obj instanceof String)) {
            numberValueOf = (Number) obj;
        } else if (i2 != -7) {
            if (i2 == -6) {
                numberValueOf = Integer.valueOf((String) obj);
            } else if (i2 != -5) {
                switch (i2) {
                    case 4:
                    case 5:
                        numberValueOf = Integer.valueOf((String) obj);
                        break;
                    case 6:
                    case 8:
                        numberValueOf = Double.valueOf((String) obj);
                        break;
                    case 7:
                        numberValueOf = Float.valueOf((String) obj);
                        break;
                    default:
                        numberValueOf = new BigDecimal((String) obj);
                        break;
                }
            } else {
                numberValueOf = Long.valueOf((String) obj);
            }
        } else if (DiskLruCache.VERSION_1.equals(obj) || "0".equals(obj)) {
            numberValueOf = Integer.valueOf((String) obj);
        } else if (!"true".equalsIgnoreCase((String) obj)) {
            numberValueOf = 0;
        }
        if (i2 != -7 && i2 != -6) {
            if (i2 == -5) {
                setLong(i, numberValueOf.longValue());
                return;
            }
            switch (i2) {
                case 2:
                case 3:
                    if (!(numberValueOf instanceof BigDecimal)) {
                        if (numberValueOf instanceof BigInteger) {
                            setBigDecimal(i, new BigDecimal((BigInteger) numberValueOf, i3));
                            return;
                        } else {
                            setBigDecimal(i, new BigDecimal(numberValueOf.doubleValue()));
                            return;
                        }
                    }
                    try {
                        try {
                            scale = ((BigDecimal) numberValueOf).setScale(i3);
                            break;
                        } catch (ArithmeticException unused) {
                            scale = ((BigDecimal) numberValueOf).setScale(i3, 4);
                            break;
                        }
                        setBigDecimal(i, scale);
                        return;
                    } catch (ArithmeticException unused2) {
                        throw SQLError.createSQLException("Can't set scale of '" + i3 + "' for DECIMAL argument '" + numberValueOf + "'", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                    }
                case 4:
                case 5:
                    break;
                case 6:
                case 8:
                    setDouble(i, numberValueOf.doubleValue());
                    return;
                case 7:
                    setFloat(i, numberValueOf.floatValue());
                    return;
                default:
                    return;
            }
        }
        setInt(i, numberValueOf.intValue());
    }

    private final void setSerializableObject(int i, Object obj) throws SQLException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            objectOutputStream.close();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            setBinaryStream(i, (InputStream) new ByteArrayInputStream(byteArray), byteArray.length);
            this.parameterTypes[(i - 1) + getParameterIndexOffset()] = -2;
        } catch (Exception e) {
            SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(Messages.getString("PreparedStatement.54") + e.getClass().getName(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            sQLExceptionCreateSQLException.initCause(e);
            throw sQLExceptionCreateSQLException;
        }
    }

    private void setTimeInternal(int i, Time time, Calendar calendar, TimeZone timeZone, boolean z) throws SQLException {
        if (time == null) {
            setNull(i, 92);
            return;
        }
        checkClosed();
        if (this.useLegacyDatetimeCode) {
            setInternal(i, "'" + TimeUtil.changeTimezone(this.connection, getCalendarInstanceForSessionOrNew(), calendar, time, timeZone, this.connection.getServerTimezoneTZ(), z).toString() + "'");
        } else {
            newSetTimeInternal(i, time, calendar);
        }
        this.parameterTypes[(i - 1) + getParameterIndexOffset()] = 92;
    }

    private final void streamToBytes(Buffer buffer, InputStream inputStream, boolean z, int i, boolean z2) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            try {
                if (this.streamConvertBuf == null) {
                    this.streamConvertBuf = new byte[4096];
                }
                String encoding = this.connection.getEncoding();
                try {
                    boolean z3 = this.connection.isNoBackslashEscapesSet() || (this.connection.getUseUnicode() && encoding != null && CharsetMapping.isMultibyteCharset(encoding) && !this.connection.parserKnowsUnicode());
                    if (i == -1) {
                        z2 = false;
                    }
                    int i2 = z2 ? readblock(inputStream, this.streamConvertBuf, i) : readblock(inputStream, this.streamConvertBuf);
                    int i3 = i - i2;
                    if (z3) {
                        buffer.writeStringNoNull("x");
                    } else if (this.connection.getIO().versionMeetsMinimum(4, 1, 0)) {
                        buffer.writeStringNoNull("_binary");
                    }
                    if (z) {
                        buffer.writeByte((byte) 39);
                    }
                    while (i2 > 0) {
                        if (z3) {
                            hexEscapeBlock(this.streamConvertBuf, buffer, i2);
                        } else if (z) {
                            escapeblockFast(this.streamConvertBuf, buffer, i2);
                        } else {
                            buffer.writeBytesNoNull(this.streamConvertBuf, 0, i2);
                        }
                        if (z2) {
                            i2 = readblock(inputStream, this.streamConvertBuf, i3);
                            if (i2 > 0) {
                                i3 -= i2;
                            }
                        } else {
                            i2 = readblock(inputStream, this.streamConvertBuf);
                        }
                    }
                    if (z) {
                        buffer.writeByte((byte) 39);
                    }
                    if (this.connection.getAutoClosePStmtStreams()) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                } catch (RuntimeException e) {
                    SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(e.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
                    sQLExceptionCreateSQLException.initCause(e);
                    throw sQLExceptionCreateSQLException;
                }
            } catch (Throwable th) {
                if (this.connection.getAutoClosePStmtStreams()) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        }
    }

    public void addBatch() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.batchedArgs == null) {
                this.batchedArgs = new ArrayList();
            }
            int i = 0;
            while (true) {
                byte[][] bArr = this.parameterValues;
                if (i < bArr.length) {
                    checkAllParametersSet(bArr[i], this.parameterStreams[i], i);
                    i++;
                } else {
                    this.batchedArgs.add(new BatchParams(bArr, this.parameterStreams, this.isStream, this.streamLengths, this.isNull));
                }
            }
        }
    }

    public String asSql() throws SQLException {
        return asSql(false);
    }

    public boolean canRewriteAsMultiValueInsertAtSqlLevel() throws SQLException {
        return this.parseInfo.canRewriteAsMultiValueInsert;
    }

    public void checkBounds(int i, int i2) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            try {
                if (i < 1) {
                    throw SQLError.createSQLException(Messages.getString("PreparedStatement.49") + i + Messages.getString("PreparedStatement.50"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                }
                if (i > this.parameterCount) {
                    throw SQLError.createSQLException(Messages.getString("PreparedStatement.51") + i + Messages.getString("PreparedStatement.52") + this.parameterValues.length + Messages.getString("PreparedStatement.53"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                }
                if (i2 == -1 && i == 1) {
                    throw SQLError.createSQLException("Can't set IN parameter for return value of stored function call.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean checkReadOnlySafeStatement() throws SQLException {
        boolean z;
        synchronized (checkClosed().getConnectionMutex()) {
            z = this.firstCharOfStmt == 'S' || !this.connection.isReadOnly();
        }
        return z;
    }

    @Override // com.mysql.jdbc.StatementImpl, java.sql.Statement
    public void clearBatch() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            this.batchHasPlainStatements = false;
            super.clearBatch();
        }
    }

    public void clearParameters() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            int i = 0;
            while (true) {
                byte[][] bArr = this.parameterValues;
                if (i < bArr.length) {
                    bArr[i] = null;
                    this.parameterStreams[i] = null;
                    this.isStream[i] = false;
                    this.isNull[i] = false;
                    this.parameterTypes[i] = 0;
                    i++;
                }
            }
        }
    }

    public int computeBatchSize(int i) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            long[] jArrComputeMaxParameterSetSizeAndBatchSize = computeMaxParameterSetSizeAndBatchSize(i);
            long j = jArrComputeMaxParameterSetSizeAndBatchSize[0];
            long j2 = jArrComputeMaxParameterSetSizeAndBatchSize[1];
            int maxAllowedPacket = this.connection.getMaxAllowedPacket();
            if (j2 < maxAllowedPacket - this.originalSql.length()) {
                return i;
            }
            return (int) Math.max(1L, ((long) (maxAllowedPacket - this.originalSql.length())) / j);
        }
    }

    public long[] computeMaxParameterSetSizeAndBatchSize(int i) throws SQLException {
        long[] jArr;
        long j;
        int i2;
        synchronized (checkClosed().getConnectionMutex()) {
            long j2 = 0;
            long j3 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                BatchParams batchParams = (BatchParams) this.batchedArgs.get(i3);
                boolean[] zArr = batchParams.isNull;
                boolean[] zArr2 = batchParams.isStream;
                int i4 = 0;
                long j4 = 0;
                while (i4 < zArr.length) {
                    if (zArr[i4]) {
                        j = 4;
                    } else {
                        int length = (!zArr2[i4] || (i2 = batchParams.streamLengths[i4]) == -1) ? batchParams.parameterStrings[i4].length : i2 * 2;
                        j = length;
                    }
                    j4 += j;
                    i4++;
                }
                long length2 = j4 + ((long) ((getValuesClause() != null ? getValuesClause().length() : this.originalSql.length()) + 1));
                j3 += length2;
                if (length2 > j2) {
                    j2 = length2;
                }
            }
            jArr = new long[]{j2, j3};
        }
        return jArr;
    }

    public boolean containsOnDuplicateKeyUpdateInSQL() {
        return this.parseInfo.isOnDuplicateKeyUpdate;
    }

    public void detectFractionalSecondsSupport() throws SQLException {
        this.serverSupportsFracSecs = this.connection != null && this.connection.versionMeetsMinimum(5, 6, 4);
    }

    public boolean execute() throws SQLException {
        String str;
        boolean z;
        synchronized (checkClosed().getConnectionMutex()) {
            MySQLConnection mySQLConnection = this.connection;
            if (!this.doPingInstead && !checkReadOnlySafeStatement()) {
                throw SQLError.createSQLException(Messages.getString("PreparedStatement.20") + Messages.getString("PreparedStatement.21"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            boolean z2 = false;
            this.lastQueryIsOnDupKeyUpdate = false;
            if (this.retrieveGeneratedKeys) {
                this.lastQueryIsOnDupKeyUpdate = containsOnDuplicateKeyUpdateInSQL();
            }
            this.batchedGeneratedKeys = null;
            resetCancelledState();
            implicitlyCloseAllOpenResults();
            clearWarnings();
            if (this.doPingInstead) {
                doPingInstead();
                return true;
            }
            setupStreamingTimeout(mySQLConnection);
            Buffer bufferFillSendPacket = fillSendPacket();
            if (mySQLConnection.getCatalog().equals(this.currentCatalog)) {
                str = null;
            } else {
                String catalog = mySQLConnection.getCatalog();
                mySQLConnection.setCatalog(this.currentCatalog);
                str = catalog;
            }
            CachedResultSetMetaData cachedMetaData = mySQLConnection.getCacheResultSetMetadata() ? mySQLConnection.getCachedMetaData(this.originalSql) : null;
            Field[] fieldArr = cachedMetaData != null ? cachedMetaData.fields : null;
            if (this.retrieveGeneratedKeys) {
                boolean zIsReadInfoMsgEnabled = mySQLConnection.isReadInfoMsgEnabled();
                mySQLConnection.setReadInfoMsgEnabled(true);
                z = zIsReadInfoMsgEnabled;
            } else {
                z = false;
            }
            mySQLConnection.setSessionMaxRows(this.firstCharOfStmt == 'S' ? this.maxRows : -1);
            ResultSetInternalMethods resultSetInternalMethodsExecuteInternal = executeInternal(this.maxRows, bufferFillSendPacket, createStreamingResultSet(), this.firstCharOfStmt == 'S', fieldArr, false);
            if (cachedMetaData != null) {
                mySQLConnection.initializeResultsMetadataFromCache(this.originalSql, cachedMetaData, resultSetInternalMethodsExecuteInternal);
            } else if (resultSetInternalMethodsExecuteInternal.reallyResult() && mySQLConnection.getCacheResultSetMetadata()) {
                mySQLConnection.initializeResultsMetadataFromCache(this.originalSql, null, resultSetInternalMethodsExecuteInternal);
            }
            if (this.retrieveGeneratedKeys) {
                mySQLConnection.setReadInfoMsgEnabled(z);
                resultSetInternalMethodsExecuteInternal.setFirstCharOfQuery(this.firstCharOfStmt);
            }
            if (str != null) {
                mySQLConnection.setCatalog(str);
            }
            if (resultSetInternalMethodsExecuteInternal != null) {
                this.lastInsertId = resultSetInternalMethodsExecuteInternal.getUpdateID();
                this.results = resultSetInternalMethodsExecuteInternal;
            }
            if (resultSetInternalMethodsExecuteInternal != null && resultSetInternalMethodsExecuteInternal.reallyResult()) {
                z2 = true;
            }
            return z2;
        }
    }

    @Override // com.mysql.jdbc.StatementImpl
    public long[] executeBatchInternal() throws SQLException {
        List<Object> list;
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.connection.isReadOnly()) {
                throw new SQLException(Messages.getString("PreparedStatement.25") + Messages.getString("PreparedStatement.26"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT);
            }
            List<Object> list2 = this.batchedArgs;
            if (list2 != null && list2.size() != 0) {
                int i = this.timeoutInMillis;
                this.timeoutInMillis = 0;
                resetCancelledState();
                try {
                    statementBegins();
                    clearWarnings();
                    if (!this.batchHasPlainStatements && this.connection.getRewriteBatchedStatements()) {
                        if (canRewriteAsMultiValueInsertAtSqlLevel()) {
                            long[] jArrExecuteBatchedInserts = executeBatchedInserts(i);
                            this.statementExecuting.set(false);
                            clearBatch();
                            return jArrExecuteBatchedInserts;
                        }
                        if (this.connection.versionMeetsMinimum(4, 1, 0) && !this.batchHasPlainStatements && (list = this.batchedArgs) != null && list.size() > 3) {
                            long[] jArrExecutePreparedBatchAsMultiStatement = executePreparedBatchAsMultiStatement(i);
                            this.statementExecuting.set(false);
                            clearBatch();
                            return jArrExecutePreparedBatchAsMultiStatement;
                        }
                    }
                    long[] jArrExecuteBatchSerially = executeBatchSerially(i);
                    this.statementExecuting.set(false);
                    clearBatch();
                    return jArrExecuteBatchSerially;
                } catch (Throwable th) {
                    this.statementExecuting.set(false);
                    clearBatch();
                    throw th;
                }
            }
            return new long[0];
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x015d A[Catch: all -> 0x0172, TryCatch #9 {, blocks: (B:4:0x000d, B:6:0x0011, B:7:0x0014, B:9:0x001a, B:12:0x0025, B:75:0x010b, B:77:0x010f, B:78:0x0119, B:104:0x0159, B:106:0x015d, B:107:0x0167, B:108:0x016a, B:112:0x0170, B:111:0x016e), top: B:121:0x000d }] */
    public long[] executeBatchSerially(int i) throws SQLException {
        long[] jArr;
        int i2;
        StatementImpl.CancelTask cancelTask;
        synchronized (checkClosed().getConnectionMutex()) {
            MySQLConnection mySQLConnection = this.connection;
            if (mySQLConnection == null) {
                checkClosed();
            }
            List<Object> list = this.batchedArgs;
            jArr = null;
            cancelTask = null;
            StatementImpl.CancelTask cancelTask2 = null;
            if (list != null) {
                int size = list.size();
                long[] jArr2 = new long[size];
                for (int i3 = 0; i3 < size; i3++) {
                    jArr2[i3] = -3;
                }
                try {
                    if (mySQLConnection.getEnableQueryTimeouts() && i != 0 && mySQLConnection.versionMeetsMinimum(5, 0, 0)) {
                        StatementImpl.CancelTask cancelTask3 = new StatementImpl.CancelTask(this);
                        try {
                            mySQLConnection.getCancelTimer().schedule(cancelTask3, i);
                            cancelTask = cancelTask3;
                        } catch (NullPointerException e) {
                            e = e;
                            cancelTask2 = cancelTask3;
                            i2 = -1;
                            try {
                                try {
                                    checkClosed();
                                    throw e;
                                } catch (SQLException e2) {
                                    jArr2[this.batchCommandIndex] = -3;
                                    long[] jArr3 = new long[this.batchCommandIndex];
                                    System.arraycopy(jArr2, 0, jArr3, 0, this.batchCommandIndex);
                                    throw SQLError.createBatchUpdateException(e2, jArr3, getExceptionInterceptor());
                                }
                            } catch (Throwable th) {
                                th = th;
                                this.batchCommandIndex = i2;
                                if (cancelTask2 != null) {
                                    cancelTask2.cancel();
                                    mySQLConnection.getCancelTimer().purge();
                                }
                                resetCancelledState();
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            cancelTask2 = cancelTask3;
                            i2 = -1;
                            this.batchCommandIndex = i2;
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
                    try {
                        if (this.retrieveGeneratedKeys) {
                            try {
                                this.batchedGeneratedKeys = new ArrayList<>(size);
                            } catch (NullPointerException e3) {
                                e = e3;
                                cancelTask2 = cancelTask;
                                i2 = -1;
                                checkClosed();
                                throw e;
                            } catch (Throwable th3) {
                                th = th3;
                                cancelTask2 = cancelTask;
                                i2 = -1;
                                this.batchCommandIndex = i2;
                                if (cancelTask2 != null) {
                                    cancelTask2.cancel();
                                    mySQLConnection.getCancelTimer().purge();
                                }
                                resetCancelledState();
                                throw th;
                            }
                        }
                        this.batchCommandIndex = 0;
                        SQLException e4 = null;
                        while (true) {
                            int i4 = this.batchCommandIndex;
                            if (i4 >= size) {
                                if (e4 == null) {
                                    this.batchCommandIndex = -1;
                                    if (cancelTask != null) {
                                        cancelTask.cancel();
                                        mySQLConnection.getCancelTimer().purge();
                                    }
                                    resetCancelledState();
                                    jArr = jArr2;
                                    break;
                                }
                                i2 = -1;
                                try {
                                    throw SQLError.createBatchUpdateException(e4, jArr2, getExceptionInterceptor());
                                } catch (NullPointerException e5) {
                                    e = e5;
                                    cancelTask2 = cancelTask;
                                    checkClosed();
                                    throw e;
                                } catch (Throwable th4) {
                                    th = th4;
                                    cancelTask2 = cancelTask;
                                    this.batchCommandIndex = i2;
                                    if (cancelTask2 != null) {
                                        cancelTask2.cancel();
                                        mySQLConnection.getCancelTimer().purge();
                                    }
                                    resetCancelledState();
                                    throw th;
                                }
                            }
                            Object obj = this.batchedArgs.get(i4);
                            try {
                                if (obj instanceof String) {
                                    jArr2[this.batchCommandIndex] = executeUpdateInternal((String) obj, true, this.retrieveGeneratedKeys);
                                    getBatchedGeneratedKeys((this.results.getFirstCharOfQuery() == 'I' && containsOnDuplicateKeyInString((String) obj)) ? 1 : 0);
                                } else {
                                    BatchParams batchParams = (BatchParams) obj;
                                    try {
                                        jArr2[this.batchCommandIndex] = executeUpdateInternal(batchParams.parameterStrings, batchParams.parameterStreams, batchParams.isStream, batchParams.streamLengths, batchParams.isNull, true);
                                        getBatchedGeneratedKeys(containsOnDuplicateKeyUpdateInSQL() ? 1 : 0);
                                    } catch (SQLException e6) {
                                        e4 = e6;
                                        jArr2[this.batchCommandIndex] = -3;
                                        if (!this.continueBatchOnError || (e4 instanceof MySQLTimeoutException) || (e4 instanceof MySQLStatementCancelledException) || hasDeadlockOrTimeoutRolledBackTx(e4)) {
                                            int i5 = this.batchCommandIndex;
                                            long[] jArr4 = new long[i5];
                                            System.arraycopy(jArr2, 0, jArr4, 0, i5);
                                            throw SQLError.createBatchUpdateException(e4, jArr4, getExceptionInterceptor());
                                        }
                                    }
                                }
                            } catch (SQLException e7) {
                                e4 = e7;
                            }
                            this.batchCommandIndex++;
                        }
                    } catch (NullPointerException e8) {
                        e = e8;
                        i2 = -1;
                    } catch (Throwable th5) {
                        th = th5;
                        i2 = -1;
                    }
                } catch (NullPointerException e9) {
                    e = e9;
                } catch (Throwable th6) {
                    th = th6;
                }
            }
            if (jArr == null) {
                jArr = new long[0];
            }
        }
        return jArr;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0135 A[Catch: all -> 0x0139, TryCatch #4 {all -> 0x0139, blocks: (B:49:0x00b0, B:91:0x0126, B:92:0x0129, B:82:0x0107, B:101:0x0135, B:104:0x013b), top: B:120:0x0033, outer: #7 }] */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x013c: IF  (r9 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:107:0x0148, block:B:105:0x013c */
    public long[] executeBatchedInserts(int i) throws SQLException {
        TimerTask timerTask;
        PreparedStatement preparedStatement;
        StatementImpl.CancelTask cancelTask;
        PreparedStatement preparedStatement2;
        synchronized (checkClosed().getConnectionMutex()) {
            String valuesClause = getValuesClause();
            MySQLConnection mySQLConnection = this.connection;
            if (valuesClause == null) {
                return executeBatchSerially(i);
            }
            int size = this.batchedArgs.size();
            if (this.retrieveGeneratedKeys) {
                this.batchedGeneratedKeys = new ArrayList<>(size);
            }
            int iComputeBatchSize = computeBatchSize(size);
            if (size < iComputeBatchSize) {
                iComputeBatchSize = size;
            }
            try {
                long[] jArr = new long[size];
                try {
                    PreparedStatement preparedStatementPrepareBatchedInsertSQL = prepareBatchedInsertSQL(mySQLConnection, iComputeBatchSize);
                    try {
                        if (mySQLConnection.getEnableQueryTimeouts() && i != 0 && mySQLConnection.versionMeetsMinimum(5, 0, 0)) {
                            cancelTask = new StatementImpl.CancelTask(preparedStatementPrepareBatchedInsertSQL);
                            try {
                                mySQLConnection.getCancelTimer().schedule(cancelTask, i);
                            } catch (Throwable th) {
                                th = th;
                                preparedStatement = preparedStatementPrepareBatchedInsertSQL;
                                if (preparedStatement != null) {
                                    preparedStatement.close();
                                }
                                throw th;
                            }
                        } else {
                            cancelTask = null;
                        }
                        int i2 = (size < iComputeBatchSize ? size : size / iComputeBatchSize) * iComputeBatchSize;
                        long jExecuteLargeUpdate = 0;
                        int oneBatchedParameterSet = 1;
                        int i3 = 0;
                        int i4 = 0;
                        SQLException sQLExceptionHandleExceptionForBatch = null;
                        while (i4 < i2) {
                            if (i4 != 0 && i4 % iComputeBatchSize == 0) {
                                try {
                                    jExecuteLargeUpdate += preparedStatementPrepareBatchedInsertSQL.executeLargeUpdate();
                                } catch (SQLException e) {
                                    sQLExceptionHandleExceptionForBatch = handleExceptionForBatch(i3 - 1, iComputeBatchSize, jArr, e);
                                }
                                getBatchedGeneratedKeys(preparedStatementPrepareBatchedInsertSQL);
                                preparedStatementPrepareBatchedInsertSQL.clearParameters();
                                oneBatchedParameterSet = 1;
                            }
                            int i5 = i3 + 1;
                            oneBatchedParameterSet = setOneBatchedParameterSet(preparedStatementPrepareBatchedInsertSQL, oneBatchedParameterSet, this.batchedArgs.get(i3));
                            i4++;
                            i3 = i5;
                        }
                        try {
                            jExecuteLargeUpdate += preparedStatementPrepareBatchedInsertSQL.executeLargeUpdate();
                        } catch (SQLException e2) {
                            sQLExceptionHandleExceptionForBatch = handleExceptionForBatch(i3 - 1, iComputeBatchSize, jArr, e2);
                        }
                        getBatchedGeneratedKeys(preparedStatementPrepareBatchedInsertSQL);
                        int i6 = size - i3;
                        if (preparedStatementPrepareBatchedInsertSQL != null) {
                            preparedStatementPrepareBatchedInsertSQL.close();
                            preparedStatement2 = null;
                        } else {
                            preparedStatement2 = preparedStatementPrepareBatchedInsertSQL;
                        }
                        if (i6 > 0) {
                            try {
                                PreparedStatement preparedStatementPrepareBatchedInsertSQL2 = prepareBatchedInsertSQL(mySQLConnection, i6);
                                if (cancelTask != null) {
                                    try {
                                        cancelTask.toCancel = preparedStatementPrepareBatchedInsertSQL2;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        preparedStatement2 = preparedStatementPrepareBatchedInsertSQL2;
                                        if (preparedStatement2 != null) {
                                            preparedStatement2.close();
                                        }
                                        throw th;
                                    }
                                }
                                int oneBatchedParameterSet2 = 1;
                                while (i3 < size) {
                                    int i7 = i3 + 1;
                                    oneBatchedParameterSet2 = setOneBatchedParameterSet(preparedStatementPrepareBatchedInsertSQL2, oneBatchedParameterSet2, this.batchedArgs.get(i3));
                                    i3 = i7;
                                }
                                try {
                                    jExecuteLargeUpdate += preparedStatementPrepareBatchedInsertSQL2.executeLargeUpdate();
                                } catch (SQLException e3) {
                                    sQLExceptionHandleExceptionForBatch = handleExceptionForBatch(i3 - 1, i6, jArr, e3);
                                }
                                getBatchedGeneratedKeys(preparedStatementPrepareBatchedInsertSQL2);
                                preparedStatement2 = preparedStatementPrepareBatchedInsertSQL2;
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                        SQLException sQLException = sQLExceptionHandleExceptionForBatch;
                        if (sQLException != null) {
                            throw SQLError.createBatchUpdateException(sQLException, jArr, getExceptionInterceptor());
                        }
                        if (size > 1) {
                            long j = jExecuteLargeUpdate > 0 ? -2L : 0L;
                            for (int i8 = 0; i8 < size; i8++) {
                                jArr[i8] = j;
                            }
                        } else {
                            jArr[0] = jExecuteLargeUpdate;
                        }
                        if (preparedStatement2 != null) {
                            preparedStatement2.close();
                        }
                        if (cancelTask != null) {
                            cancelTask.cancel();
                            mySQLConnection.getCancelTimer().purge();
                        }
                        resetCancelledState();
                        return jArr;
                    } catch (Throwable th4) {
                        th = th4;
                        preparedStatement = preparedStatementPrepareBatchedInsertSQL;
                        if (preparedStatement != null) {
                            preparedStatement.close();
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    preparedStatement = null;
                }
            } catch (Throwable th6) {
                if (timerTask != null) {
                    timerTask.cancel();
                    mySQLConnection.getCancelTimer().purge();
                }
                resetCancelledState();
                throw th6;
            }
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x00a3 */
    /* JADX WARN: Code duplicated, block: B:61:0x00b0 A[Catch: all -> 0x00c2, NullPointerException -> 0x00c4, TRY_ENTER, TryCatch #6 {NullPointerException -> 0x00c4, blocks: (B:4:0x000b, B:40:0x0089, B:42:0x0091, B:61:0x00b0, B:63:0x00b7, B:64:0x00c1), top: B:74:0x000b, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x00b7 A[Catch: all -> 0x00c2, NullPointerException -> 0x00c4, TryCatch #6 {NullPointerException -> 0x00c4, blocks: (B:4:0x000b, B:40:0x0089, B:42:0x0091, B:61:0x00b0, B:63:0x00b7, B:64:0x00c1), top: B:74:0x000b, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.mysql.jdbc.ResultSetInternalMethods executeInternal(int r17, com.mysql.jdbc.Buffer r18, boolean r19, boolean r20, com.mysql.jdbc.Field[] r21, boolean r22) throws java.sql.SQLException {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mysql.jdbc.PreparedStatement.executeInternal(int, com.mysql.jdbc.Buffer, boolean, boolean, com.mysql.jdbc.Field[], boolean):com.mysql.jdbc.ResultSetInternalMethods");
    }

    public long executeLargeUpdate() throws SQLException {
        return executeUpdateInternal(true, false);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x018f A[Catch: all -> 0x0164, TRY_ENTER, TryCatch #4 {all -> 0x0164, blocks: (B:84:0x0160, B:100:0x018f, B:101:0x0192), top: B:132:0x00fe }] */
    /* JADX WARN: Code duplicated, block: B:110:0x019e A[Catch: all -> 0x01a2, TRY_ENTER, TryCatch #0 {all -> 0x01a2, blocks: (B:53:0x00fa, B:110:0x019e, B:113:0x01a5), top: B:126:0x004f }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x01a3: MOVE (r5 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:112:0x01a3 */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.mysql.jdbc.PreparedStatement, com.mysql.jdbc.StatementImpl] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.TimerTask] */
    /* JADX WARN: Type inference failed for: r5v10, types: [int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.sql.PreparedStatement] */
    /* JADX WARN: Type inference failed for: r9v11, types: [java.sql.PreparedStatement] */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.sql.PreparedStatement] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public long[] executePreparedBatchAsMultiStatement(int i) throws SQLException {
        ?? ProcessMultiCountsAndKeys;
        long[] jArr;
        Object obj;
        java.sql.PreparedStatement preparedStatement;
        java.sql.PreparedStatement preparedStatement2;
        StatementImpl.CancelTask cancelTask;
        StatementImpl.CancelTask cancelTask2;
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.batchedValuesClause == null) {
                this.batchedValuesClause = this.originalSql + ";";
            }
            MySQLConnection mySQLConnection = this.connection;
            boolean allowMultiQueries = mySQLConnection.getAllowMultiQueries();
            try {
                clearWarnings();
                int size = this.batchedArgs.size();
                if (this.retrieveGeneratedKeys) {
                    this.batchedGeneratedKeys = new ArrayList<>(size);
                }
                int iComputeBatchSize = computeBatchSize(size);
                if (size < iComputeBatchSize) {
                    iComputeBatchSize = size;
                }
                jArr = new long[this.parseInfo.numberOfQueries * size];
                try {
                    if (!allowMultiQueries) {
                        try {
                            mySQLConnection.getIO().enableMultiQueries();
                        } catch (Throwable th) {
                            th = th;
                            preparedStatement = null;
                            preparedStatement2 = preparedStatement;
                            if (preparedStatement2 != null) {
                                preparedStatement2.close();
                            }
                            throw th;
                        }
                    }
                    java.sql.PreparedStatement preparedStatement3 = this.retrieveGeneratedKeys ? (java.sql.PreparedStatement) ((Wrapper) mySQLConnection.prepareStatement(generateMultiStatementForBatch(iComputeBatchSize), 1)).unwrap(java.sql.PreparedStatement.class) : (java.sql.PreparedStatement) ((Wrapper) mySQLConnection.prepareStatement(generateMultiStatementForBatch(iComputeBatchSize))).unwrap(java.sql.PreparedStatement.class);
                    try {
                        int i2 = 0;
                        if (mySQLConnection.getEnableQueryTimeouts() && i != 0 && mySQLConnection.versionMeetsMinimum(5, 0, 0)) {
                            cancelTask = new StatementImpl.CancelTask((StatementImpl) preparedStatement3);
                            try {
                                mySQLConnection.getCancelTimer().schedule(cancelTask, i);
                            } catch (Throwable th2) {
                                th = th2;
                                preparedStatement2 = preparedStatement3;
                                if (preparedStatement2 != null) {
                                    preparedStatement2.close();
                                }
                                throw th;
                            }
                        } else {
                            cancelTask = null;
                        }
                        int i3 = (size < iComputeBatchSize ? size : size / iComputeBatchSize) * iComputeBatchSize;
                        int oneBatchedParameterSet = 1;
                        int i4 = 0;
                        int i5 = 0;
                        SQLException sQLExceptionHandleExceptionForBatch = null;
                        while (i2 < i3) {
                            if (i2 != 0 && i2 % iComputeBatchSize == 0) {
                                try {
                                    preparedStatement3.execute();
                                } catch (SQLException e) {
                                    sQLExceptionHandleExceptionForBatch = handleExceptionForBatch(i4, iComputeBatchSize, jArr, e);
                                }
                                int iProcessMultiCountsAndKeys = processMultiCountsAndKeys((StatementImpl) preparedStatement3, i5, jArr);
                                preparedStatement3.clearParameters();
                                i5 = iProcessMultiCountsAndKeys;
                                oneBatchedParameterSet = 1;
                            }
                            int i6 = i4 + 1;
                            oneBatchedParameterSet = setOneBatchedParameterSet(preparedStatement3, oneBatchedParameterSet, this.batchedArgs.get(i4));
                            i2++;
                            i4 = i6;
                        }
                        try {
                            preparedStatement3.execute();
                        } catch (SQLException e2) {
                            sQLExceptionHandleExceptionForBatch = handleExceptionForBatch(i4 - 1, iComputeBatchSize, jArr, e2);
                        }
                        ProcessMultiCountsAndKeys = processMultiCountsAndKeys((StatementImpl) preparedStatement3, i5, jArr);
                        preparedStatement3.clearParameters();
                        int i7 = size - i4;
                        ?? PrepareStatement = preparedStatement3;
                        if (preparedStatement3 != null) {
                            preparedStatement3.close();
                            PrepareStatement = 0;
                        }
                        try {
                            if (i7 > 0) {
                                try {
                                    PrepareStatement = this.retrieveGeneratedKeys ? mySQLConnection.prepareStatement(generateMultiStatementForBatch(i7), 1) : mySQLConnection.prepareStatement(generateMultiStatementForBatch(i7));
                                    if (cancelTask != null) {
                                        cancelTask.toCancel = (StatementImpl) PrepareStatement;
                                    }
                                    int oneBatchedParameterSet2 = 1;
                                    while (i4 < size) {
                                        int i8 = i4 + 1;
                                        oneBatchedParameterSet2 = setOneBatchedParameterSet(PrepareStatement, oneBatchedParameterSet2, this.batchedArgs.get(i4));
                                        i4 = i8;
                                    }
                                    try {
                                        PrepareStatement.execute();
                                    } catch (SQLException e3) {
                                        sQLExceptionHandleExceptionForBatch = handleExceptionForBatch(i4 - 1, i7, jArr, e3);
                                    }
                                    processMultiCountsAndKeys((StatementImpl) PrepareStatement, ProcessMultiCountsAndKeys, jArr);
                                    PrepareStatement.clearParameters();
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (PrepareStatement != 0) {
                                        PrepareStatement.close();
                                    }
                                    throw th;
                                }
                            }
                            SQLException sQLException = sQLExceptionHandleExceptionForBatch;
                            if (cancelTask != null) {
                                SQLException sQLException2 = cancelTask.caughtWhileCancelling;
                                if (sQLException2 != null) {
                                    throw sQLException2;
                                }
                                cancelTask.cancel();
                                mySQLConnection.getCancelTimer().purge();
                                cancelTask2 = null;
                            } else {
                                cancelTask2 = cancelTask;
                            }
                            if (sQLException != null) {
                                try {
                                    throw SQLError.createBatchUpdateException(sQLException, jArr, getExceptionInterceptor());
                                } catch (Throwable th4) {
                                    th = th4;
                                    if (PrepareStatement != 0) {
                                        PrepareStatement.close();
                                    }
                                    throw th;
                                }
                            }
                            if (PrepareStatement != 0) {
                                PrepareStatement.close();
                            }
                            if (cancelTask2 != null) {
                                cancelTask2.cancel();
                                mySQLConnection.getCancelTimer().purge();
                            }
                            resetCancelledState();
                            if (!allowMultiQueries) {
                                mySQLConnection.getIO().disableMultiQueries();
                            }
                            clearBatch();
                        } catch (Throwable th5) {
                            th = th5;
                            if (ProcessMultiCountsAndKeys != 0) {
                                ProcessMultiCountsAndKeys.cancel();
                                mySQLConnection.getCancelTimer().purge();
                            }
                            resetCancelledState();
                            if (!allowMultiQueries) {
                                mySQLConnection.getIO().disableMultiQueries();
                            }
                            clearBatch();
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        preparedStatement = preparedStatement3;
                        preparedStatement2 = preparedStatement;
                        if (preparedStatement2 != null) {
                            preparedStatement2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    ProcessMultiCountsAndKeys = obj;
                }
            } catch (Throwable th8) {
                th = th8;
                ProcessMultiCountsAndKeys = 0;
            }
        }
        return jArr;
    }

    public ResultSet executeQuery() throws SQLException {
        String str;
        synchronized (checkClosed().getConnectionMutex()) {
            MySQLConnection mySQLConnection = this.connection;
            checkForDml(this.originalSql, this.firstCharOfStmt);
            this.batchedGeneratedKeys = null;
            resetCancelledState();
            implicitlyCloseAllOpenResults();
            clearWarnings();
            if (this.doPingInstead) {
                doPingInstead();
                return this.results;
            }
            setupStreamingTimeout(mySQLConnection);
            Buffer bufferFillSendPacket = fillSendPacket();
            if (mySQLConnection.getCatalog().equals(this.currentCatalog)) {
                str = null;
            } else {
                String catalog = mySQLConnection.getCatalog();
                mySQLConnection.setCatalog(this.currentCatalog);
                str = catalog;
            }
            CachedResultSetMetaData cachedMetaData = mySQLConnection.getCacheResultSetMetadata() ? mySQLConnection.getCachedMetaData(this.originalSql) : null;
            Field[] fieldArr = cachedMetaData != null ? cachedMetaData.fields : null;
            mySQLConnection.setSessionMaxRows(this.maxRows);
            this.results = executeInternal(this.maxRows, bufferFillSendPacket, createStreamingResultSet(), true, fieldArr, false);
            if (str != null) {
                mySQLConnection.setCatalog(str);
            }
            if (cachedMetaData != null) {
                mySQLConnection.initializeResultsMetadataFromCache(this.originalSql, cachedMetaData, this.results);
            } else if (mySQLConnection.getCacheResultSetMetadata()) {
                mySQLConnection.initializeResultsMetadataFromCache(this.originalSql, null, this.results);
            }
            this.lastInsertId = this.results.getUpdateID();
            return this.results;
        }
    }

    public int executeUpdate() throws SQLException {
        return Util.truncateAndConvertToInt(executeLargeUpdate());
    }

    public long executeUpdateInternal(boolean z, boolean z2) throws SQLException {
        long jExecuteUpdateInternal;
        synchronized (checkClosed().getConnectionMutex()) {
            if (z) {
                clearWarnings();
                this.batchedGeneratedKeys = null;
                jExecuteUpdateInternal = executeUpdateInternal(this.parameterValues, this.parameterStreams, this.isStream, this.streamLengths, this.isNull, z2);
            } else {
                jExecuteUpdateInternal = executeUpdateInternal(this.parameterValues, this.parameterStreams, this.isStream, this.streamLengths, this.isNull, z2);
            }
            throw th;
        }
        return jExecuteUpdateInternal;
    }

    public Buffer fillSendPacket() throws SQLException {
        Buffer bufferFillSendPacket;
        synchronized (checkClosed().getConnectionMutex()) {
            bufferFillSendPacket = fillSendPacket(this.parameterValues, this.parameterStreams, this.isStream, this.streamLengths);
        }
        return bufferFillSendPacket;
    }

    public byte[] getBytesRepresentation(int i) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.isStream[i]) {
                return streamToBytes(this.parameterStreams[i], false, this.streamLengths[i], this.connection.getUseStreamLengthsInPrepStmts());
            }
            byte[] bArr = this.parameterValues[i];
            if (bArr == null) {
                return null;
            }
            if (bArr[0] != 39 || bArr[bArr.length - 1] != 39) {
                return bArr;
            }
            byte[] bArr2 = new byte[bArr.length - 2];
            System.arraycopy(bArr, 1, bArr2, 0, bArr.length - 2);
            return bArr2;
        }
    }

    public byte[] getBytesRepresentationForBatch(int i, int i2) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            Object obj = this.batchedArgs.get(i2);
            if (obj instanceof String) {
                try {
                    return StringUtils.getBytes((String) obj, this.charEncoding);
                } catch (UnsupportedEncodingException unused) {
                    throw new RuntimeException(Messages.getString("PreparedStatement.32") + this.charEncoding + Messages.getString("PreparedStatement.33"));
                }
            }
            BatchParams batchParams = (BatchParams) obj;
            if (batchParams.isStream[i]) {
                return streamToBytes(batchParams.parameterStreams[i], false, batchParams.streamLengths[i], this.connection.getUseStreamLengthsInPrepStmts());
            }
            byte[] bArr = batchParams.parameterStrings[i];
            if (bArr == null) {
                return null;
            }
            if (bArr[0] != 39 || bArr[bArr.length - 1] != 39) {
                return bArr;
            }
            byte[] bArr2 = new byte[bArr.length - 2];
            System.arraycopy(bArr, 1, bArr2, 0, bArr.length - 2);
            return bArr2;
        }
    }

    public String getDateTime(String str) {
        return TimeUtil.getSimpleDateFormat(null, str, null, null).format(new java.util.Date());
    }

    public int getLocationOfOnDuplicateKeyUpdate() throws SQLException {
        return this.parseInfo.locationOfOnDuplicateKeyUpdate;
    }

    @Override // java.sql.PreparedStatement
    public java.sql.ResultSetMetaData getMetaData() throws SQLException {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ResultSet resultSet2;
        synchronized (checkClosed().getConnectionMutex()) {
            SQLException e = null;
            if (!isSelectQuery()) {
                return null;
            }
            if (this.pstmtResultMetaData == null) {
                try {
                    preparedStatement = new PreparedStatement(this.connection, this.originalSql, this.currentCatalog, this.parseInfo);
                    try {
                        preparedStatement.setMaxRows(1);
                        int length = this.parameterValues.length;
                        for (int i = 1; i <= length; i++) {
                            preparedStatement.setString(i, BuildConfig.FLAVOR);
                        }
                        if (preparedStatement.execute()) {
                            resultSet2 = preparedStatement.getResultSet();
                            try {
                                this.pstmtResultMetaData = resultSet2.getMetaData();
                            } catch (Throwable th) {
                                resultSet = resultSet2;
                                th = th;
                                if (resultSet != null) {
                                    try {
                                        resultSet.close();
                                    } catch (SQLException e2) {
                                        e = e2;
                                    }
                                }
                                if (preparedStatement != null) {
                                    try {
                                        preparedStatement.close();
                                    } catch (SQLException e3) {
                                        e = e3;
                                    }
                                }
                                if (e != null) {
                                    throw e;
                                }
                                throw th;
                            }
                        } else {
                            this.pstmtResultMetaData = new ResultSetMetaData(new Field[0], this.connection.getUseOldAliasMetadataBehavior(), this.connection.getYearIsDateType(), getExceptionInterceptor());
                            resultSet2 = null;
                        }
                        if (resultSet2 != null) {
                            try {
                                resultSet2.close();
                            } catch (SQLException e4) {
                                e = e4;
                            }
                        }
                        try {
                            preparedStatement.close();
                        } catch (SQLException e5) {
                            e = e5;
                        }
                        if (e != null) {
                            throw e;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        resultSet = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    preparedStatement = null;
                    resultSet = null;
                }
            }
            return this.pstmtResultMetaData;
        }
    }

    public String getNonRewrittenSql() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            int iIndexOf = this.originalSql.indexOf(" of: ");
            if (iIndexOf != -1) {
                return this.originalSql.substring(iIndexOf + 5);
            }
            return this.originalSql;
        }
    }

    public ParameterBindings getParameterBindings() throws SQLException {
        EmulatedPreparedStatementBindings emulatedPreparedStatementBindings;
        synchronized (checkClosed().getConnectionMutex()) {
            emulatedPreparedStatementBindings = new EmulatedPreparedStatementBindings();
        }
        return emulatedPreparedStatementBindings;
    }

    public int getParameterIndexOffset() {
        return 0;
    }

    public ParameterMetaData getParameterMetaData() throws SQLException {
        MysqlParameterMetadata mysqlParameterMetadata;
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.parameterMetaData == null) {
                if (this.connection.getGenerateSimpleParameterMetadata()) {
                    this.parameterMetaData = new MysqlParameterMetadata(this.parameterCount);
                } else {
                    this.parameterMetaData = new MysqlParameterMetadata(null, this.parameterCount, getExceptionInterceptor());
                }
            }
            mysqlParameterMetadata = this.parameterMetaData;
        }
        return mysqlParameterMetadata;
    }

    public ParseInfo getParseInfo() {
        return this.parseInfo;
    }

    public String getPreparedSql() {
        try {
            synchronized (checkClosed().getConnectionMutex()) {
                if (this.rewrittenBatchSize == 0) {
                    return this.originalSql;
                }
                try {
                    ParseInfo parseInfo = this.parseInfo;
                    return parseInfo.getSqlForBatch(parseInfo);
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SQLException e2) {
            throw new RuntimeException(e2);
        }
    }

    public int getRewrittenBatchSize() {
        return this.rewrittenBatchSize;
    }

    @Override // com.mysql.jdbc.StatementImpl, java.sql.Statement
    public int getUpdateCount() throws SQLException {
        int updateCount = super.getUpdateCount();
        if (!containsOnDuplicateKeyUpdateInSQL() || !this.compensateForOnDuplicateKeyUpdate) {
            return updateCount;
        }
        if (updateCount == 2 || updateCount == 0) {
            return 1;
        }
        return updateCount;
    }

    public String getValuesClause() throws SQLException {
        return this.parseInfo.valuesClause;
    }

    public boolean isNull(int i) throws SQLException {
        boolean z;
        synchronized (checkClosed().getConnectionMutex()) {
            z = this.isNull[i];
        }
        return z;
    }

    public boolean isSelectQuery() throws SQLException {
        boolean zStartsWithIgnoreCaseAndWs;
        synchronized (checkClosed().getConnectionMutex()) {
            zStartsWithIgnoreCaseAndWs = StringUtils.startsWithIgnoreCaseAndWs(StringUtils.stripComments(this.originalSql, "'\"", "'\"", true, false, true, true), "SELECT");
        }
        return zStartsWithIgnoreCaseAndWs;
    }

    public PreparedStatement prepareBatchedInsertSQL(MySQLConnection mySQLConnection, int i) throws SQLException {
        PreparedStatement preparedStatement;
        synchronized (checkClosed().getConnectionMutex()) {
            preparedStatement = new PreparedStatement(mySQLConnection, "Rewritten batch of: " + this.originalSql, this.currentCatalog, this.parseInfo.getParseInfoForBatch(i));
            preparedStatement.setRetrieveGeneratedKeys(this.retrieveGeneratedKeys);
            preparedStatement.rewrittenBatchSize = i;
        }
        return preparedStatement;
    }

    @Override // com.mysql.jdbc.StatementImpl
    public void realClose(boolean z, boolean z2) throws SQLException {
        MySQLConnection mySQLConnection = this.connection;
        if (mySQLConnection == null) {
            return;
        }
        synchronized (mySQLConnection.getConnectionMutex()) {
            if (this.isClosed) {
                return;
            }
            if (this.useUsageAdvisor && this.numberOfExecutions <= 1) {
                this.eventSink.consumeEvent(new ProfilerEvent((byte) 0, BuildConfig.FLAVOR, this.currentCatalog, this.connectionId, getId(), -1, System.currentTimeMillis(), 0L, Constants.MILLIS_I18N, null, this.pointOfOrigin, Messages.getString("PreparedStatement.43")));
            }
            super.realClose(z, z2);
            this.dbmd = null;
            this.originalSql = null;
            this.staticSqlStrings = null;
            this.parameterValues = null;
            this.parameterStreams = null;
            this.isStream = null;
            this.streamLengths = null;
            this.isNull = null;
            this.streamConvertBuf = null;
            this.parameterTypes = null;
        }
    }

    @Override // java.sql.PreparedStatement
    public void setArray(int i, Array array) throws SQLException {
        throw SQLError.createSQLFeatureNotSupportedException();
    }

    @Override // java.sql.PreparedStatement
    public void setAsciiStream(int i, InputStream inputStream, int i2) throws SQLException {
        if (inputStream == null) {
            setNull(i, 12);
        } else {
            setBinaryStream(i, inputStream, i2);
        }
    }

    @Override // java.sql.PreparedStatement
    public void setBigDecimal(int i, BigDecimal bigDecimal) throws SQLException {
        if (bigDecimal == null) {
            setNull(i, 3);
        } else {
            setInternal(i, StringUtils.fixDecimalExponent(StringUtils.consistentToString(bigDecimal)));
            this.parameterTypes[(i - 1) + getParameterIndexOffset()] = 3;
        }
    }

    @Override // java.sql.PreparedStatement
    public void setBinaryStream(int i, InputStream inputStream, int i2) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            try {
                if (inputStream == null) {
                    setNull(i, -2);
                } else {
                    int parameterIndexOffset = getParameterIndexOffset();
                    if (i < 1 || i > this.staticSqlStrings.length) {
                        throw SQLError.createSQLException(Messages.getString("PreparedStatement.2") + i + Messages.getString("PreparedStatement.3") + this.staticSqlStrings.length + Messages.getString("PreparedStatement.4"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                    }
                    if (parameterIndexOffset == -1 && i == 1) {
                        throw SQLError.createSQLException("Can't set IN parameter for return value of stored function call.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                    }
                    int i3 = i - 1;
                    int i4 = parameterIndexOffset + i3;
                    this.parameterStreams[i4] = inputStream;
                    this.isStream[i4] = true;
                    this.streamLengths[i4] = i2;
                    this.isNull[i4] = false;
                    this.parameterTypes[i3 + getParameterIndexOffset()] = 2004;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.sql.PreparedStatement
    public void setBlob(int i, InputStream inputStream, long j) throws SQLException {
        setBinaryStream(i, inputStream, (int) j);
    }

    @Override // java.sql.PreparedStatement
    public void setBoolean(int i, boolean z) throws SQLException {
        if (this.useTrueBoolean) {
            setInternal(i, z ? DiskLruCache.VERSION_1 : "0");
        } else {
            setInternal(i, z ? "'t'" : "'f'");
            this.parameterTypes[(i - 1) + getParameterIndexOffset()] = 16;
        }
    }

    @Override // java.sql.PreparedStatement
    public void setByte(int i, byte b) throws SQLException {
        setInternal(i, String.valueOf((int) b));
        this.parameterTypes[(i - 1) + getParameterIndexOffset()] = -6;
    }

    @Override // java.sql.PreparedStatement
    public void setBytes(int i, byte[] bArr) throws SQLException {
        setBytes(i, bArr, true, true);
        if (bArr != null) {
            this.parameterTypes[(i - 1) + getParameterIndexOffset()] = -2;
        }
    }

    public void setBytesNoEscape(int i, byte[] bArr) throws SQLException {
        byte[] bArr2 = new byte[bArr.length + 2];
        bArr2[0] = 39;
        System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
        bArr2[bArr.length + 1] = 39;
        setInternal(i, bArr2);
    }

    public void setBytesNoEscapeNoQuotes(int i, byte[] bArr) throws SQLException {
        setInternal(i, bArr);
    }

    @Override // java.sql.PreparedStatement
    public void setCharacterStream(int i, Reader reader, int i2) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            try {
                if (reader == null) {
                    setNull(i, -1);
                } else {
                    boolean useStreamLengthsInPrepStmts = this.connection.getUseStreamLengthsInPrepStmts();
                    String clobCharacterEncoding = this.connection.getClobCharacterEncoding();
                    if (!useStreamLengthsInPrepStmts || i2 == -1) {
                        char[] cArr = new char[4096];
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            int i3 = reader.read(cArr);
                            if (i3 == -1) {
                                break;
                            } else {
                                sb.append(cArr, 0, i3);
                            }
                        }
                        if (clobCharacterEncoding == null) {
                            setString(i, sb.toString());
                        } else {
                            try {
                                setBytes(i, StringUtils.getBytes(sb.toString(), clobCharacterEncoding));
                            } catch (UnsupportedEncodingException unused) {
                                throw SQLError.createSQLException("Unsupported character encoding " + clobCharacterEncoding, SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                            }
                        }
                    } else {
                        char[] cArr2 = new char[i2];
                        int fully = readFully(reader, cArr2, i2);
                        if (clobCharacterEncoding == null) {
                            setString(i, new String(cArr2, 0, fully));
                        } else {
                            try {
                                setBytes(i, StringUtils.getBytes(new String(cArr2, 0, fully), clobCharacterEncoding));
                            } catch (UnsupportedEncodingException unused2) {
                                throw SQLError.createSQLException("Unsupported character encoding " + clobCharacterEncoding, SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                            }
                        }
                    }
                    this.parameterTypes[(i - 1) + getParameterIndexOffset()] = 2005;
                }
            } catch (IOException e) {
                throw SQLError.createSQLException(e.toString(), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
            }
        }
    }

    @Override // java.sql.PreparedStatement
    public void setClob(int i, java.sql.Clob clob) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (clob == null) {
                setNull(i, 2005);
            } else {
                String clobCharacterEncoding = this.connection.getClobCharacterEncoding();
                if (clobCharacterEncoding == null) {
                    setString(i, clob.getSubString(1L, (int) clob.length()));
                } else {
                    try {
                        setBytes(i, StringUtils.getBytes(clob.getSubString(1L, (int) clob.length()), clobCharacterEncoding));
                    } catch (UnsupportedEncodingException unused) {
                        throw SQLError.createSQLException("Unsupported character encoding " + clobCharacterEncoding, SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                    }
                }
                this.parameterTypes[(i - 1) + getParameterIndexOffset()] = 2005;
            }
        }
    }

    @Override // java.sql.PreparedStatement
    public void setDate(int i, Date date) throws SQLException {
        setDate(i, date, null);
    }

    @Override // java.sql.PreparedStatement
    public void setDouble(int i, double d) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (!this.connection.getAllowNanAndInf() && (d == Double.POSITIVE_INFINITY || d == Double.NEGATIVE_INFINITY || Double.isNaN(d))) {
                throw SQLError.createSQLException("'" + d + "' is not a valid numeric or approximate numeric value", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            setInternal(i, StringUtils.fixDecimalExponent(String.valueOf(d)));
            this.parameterTypes[(i - 1) + getParameterIndexOffset()] = 8;
        }
    }

    @Override // java.sql.PreparedStatement
    public void setFloat(int i, float f) throws SQLException {
        setInternal(i, StringUtils.fixDecimalExponent(String.valueOf(f)));
        this.parameterTypes[(i - 1) + getParameterIndexOffset()] = 6;
    }

    @Override // java.sql.PreparedStatement
    public void setInt(int i, int i2) throws SQLException {
        setInternal(i, String.valueOf(i2));
        this.parameterTypes[(i - 1) + getParameterIndexOffset()] = 4;
    }

    public final void setInternal(int i, byte[] bArr) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            int parameterIndexOffset = getParameterIndexOffset();
            checkBounds(i, parameterIndexOffset);
            int i2 = (i - 1) + parameterIndexOffset;
            this.isStream[i2] = false;
            this.isNull[i2] = false;
            this.parameterStreams[i2] = null;
            this.parameterValues[i2] = bArr;
        }
    }

    @Override // java.sql.PreparedStatement
    public void setLong(int i, long j) throws SQLException {
        setInternal(i, String.valueOf(j));
        this.parameterTypes[(i - 1) + getParameterIndexOffset()] = -5;
    }

    @Override // java.sql.PreparedStatement
    public void setNCharacterStream(int i, Reader reader) throws SQLException {
        setNCharacterStream(i, reader, -1L);
    }

    @Override // java.sql.PreparedStatement
    public void setNClob(int i, Reader reader) throws SQLException {
        setNCharacterStream(i, reader);
    }

    public void setNString(int i, String str) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (!this.charEncoding.equalsIgnoreCase("UTF-8") && !this.charEncoding.equalsIgnoreCase("utf8")) {
                if (str == null) {
                    setNull(i, 1);
                } else {
                    int length = str.length();
                    StringBuilder sb = new StringBuilder((int) ((((double) str.length()) * 1.1d) + 4.0d));
                    sb.append("_utf8");
                    sb.append('\'');
                    for (int i2 = 0; i2 < length; i2++) {
                        char cCharAt = str.charAt(i2);
                        if (cCharAt == 0) {
                            sb.append(StringUtils.WILDCARD_ESCAPE);
                            sb.append('0');
                        } else if (cCharAt == '\n') {
                            sb.append(StringUtils.WILDCARD_ESCAPE);
                            sb.append('n');
                        } else if (cCharAt == '\r') {
                            sb.append(StringUtils.WILDCARD_ESCAPE);
                            sb.append('r');
                        } else if (cCharAt == 26) {
                            sb.append(StringUtils.WILDCARD_ESCAPE);
                            sb.append('Z');
                        } else if (cCharAt == '\"') {
                            if (this.usingAnsiMode) {
                                sb.append(StringUtils.WILDCARD_ESCAPE);
                            }
                            sb.append('\"');
                        } else if (cCharAt == '\'') {
                            sb.append(StringUtils.WILDCARD_ESCAPE);
                            sb.append('\'');
                        } else if (cCharAt != '\\') {
                            sb.append(cCharAt);
                        } else {
                            sb.append(StringUtils.WILDCARD_ESCAPE);
                            sb.append(StringUtils.WILDCARD_ESCAPE);
                        }
                    }
                    sb.append('\'');
                    String string = sb.toString();
                    setInternal(i, !this.isLoadDataQuery ? StringUtils.getBytes(string, this.connection.getCharsetConverter("UTF-8"), "UTF-8", this.connection.getServerCharset(), this.connection.parserKnowsUnicode(), getExceptionInterceptor()) : StringUtils.getBytes(string));
                    this.parameterTypes[(i - 1) + getParameterIndexOffset()] = -9;
                }
                return;
            }
            setString(i, str);
        }
    }

    @Override // java.sql.PreparedStatement
    public void setNull(int i, int i2) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            setInternal(i, "null");
            int i3 = i - 1;
            this.isNull[getParameterIndexOffset() + i3] = true;
            this.parameterTypes[i3 + getParameterIndexOffset()] = 0;
        }
    }

    public void setObject(int i, Object obj) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            try {
                if (obj == null) {
                    setNull(i, MysqlErrorNumbers.ER_INVALID_GROUP_FUNC_USE);
                } else if (obj instanceof Byte) {
                    setInt(i, ((Byte) obj).intValue());
                } else if (obj instanceof String) {
                    setString(i, (String) obj);
                } else if (obj instanceof BigDecimal) {
                    setBigDecimal(i, (BigDecimal) obj);
                } else if (obj instanceof Short) {
                    setShort(i, ((Short) obj).shortValue());
                } else if (obj instanceof Integer) {
                    setInt(i, ((Integer) obj).intValue());
                } else if (obj instanceof Long) {
                    setLong(i, ((Long) obj).longValue());
                } else if (obj instanceof Float) {
                    setFloat(i, ((Float) obj).floatValue());
                } else if (obj instanceof Double) {
                    setDouble(i, ((Double) obj).doubleValue());
                } else if (obj instanceof byte[]) {
                    setBytes(i, (byte[]) obj);
                } else if (obj instanceof Date) {
                    setDate(i, (Date) obj);
                } else if (obj instanceof Time) {
                    setTime(i, (Time) obj);
                } else if (obj instanceof Timestamp) {
                    setTimestamp(i, (Timestamp) obj);
                } else if (obj instanceof Boolean) {
                    setBoolean(i, ((Boolean) obj).booleanValue());
                } else if (obj instanceof InputStream) {
                    setBinaryStream(i, (InputStream) obj, -1);
                } else if (obj instanceof java.sql.Blob) {
                    setBlob(i, (java.sql.Blob) obj);
                } else if (obj instanceof java.sql.Clob) {
                    setClob(i, (java.sql.Clob) obj);
                } else if (this.connection.getTreatUtilDateAsTimestamp() && (obj instanceof java.util.Date)) {
                    setTimestamp(i, new Timestamp(((java.util.Date) obj).getTime()));
                } else if (obj instanceof BigInteger) {
                    setString(i, obj.toString());
                } else {
                    setSerializableObject(i, obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int setOneBatchedParameterSet(java.sql.PreparedStatement preparedStatement, int i, Object obj) throws SQLException {
        int i2;
        BatchParams batchParams = (BatchParams) obj;
        boolean[] zArr = batchParams.isNull;
        boolean[] zArr2 = batchParams.isStream;
        for (int i3 = 0; i3 < zArr.length; i3++) {
            if (zArr[i3]) {
                i2 = i + 1;
                preparedStatement.setNull(i, 0);
            } else {
                if (zArr2[i3]) {
                    i2 = i + 1;
                    preparedStatement.setBinaryStream(i, batchParams.parameterStreams[i3], batchParams.streamLengths[i3]);
                } else {
                    ((PreparedStatement) preparedStatement).setBytesNoEscapeNoQuotes(i, batchParams.parameterStrings[i3]);
                    i++;
                }
            }
            i = i2;
        }
        return i;
    }

    @Override // java.sql.PreparedStatement
    public void setRef(int i, Ref ref) throws SQLException {
        throw SQLError.createSQLFeatureNotSupportedException();
    }

    public void setRetrieveGeneratedKeys(boolean z) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            this.retrieveGeneratedKeys = z;
        }
    }

    @Override // java.sql.PreparedStatement
    public void setShort(int i, short s) throws SQLException {
        setInternal(i, String.valueOf((int) s));
        this.parameterTypes[(i - 1) + getParameterIndexOffset()] = 5;
    }

    @Override // java.sql.PreparedStatement
    public void setString(int i, String str) throws SQLException {
        String string;
        synchronized (checkClosed().getConnectionMutex()) {
            try {
                if (str == null) {
                    setNull(i, 1);
                } else {
                    checkClosed();
                    int length = str.length();
                    if (this.connection.isNoBackslashEscapesSet()) {
                        if (isEscapeNeededForString(str, length)) {
                            setBytes(i, !this.isLoadDataQuery ? StringUtils.getBytes(str, this.charConverter, this.charEncoding, this.connection.getServerCharset(), this.connection.parserKnowsUnicode(), getExceptionInterceptor()) : StringUtils.getBytes(str));
                        } else {
                            StringBuilder sb = new StringBuilder(str.length() + 2);
                            sb.append('\'');
                            sb.append(str);
                            sb.append('\'');
                            setInternal(i, !this.isLoadDataQuery ? StringUtils.getBytes(sb.toString(), this.charConverter, this.charEncoding, this.connection.getServerCharset(), this.connection.parserKnowsUnicode(), getExceptionInterceptor()) : StringUtils.getBytes(sb.toString()));
                        }
                        return;
                    }
                    boolean z = false;
                    if (this.isLoadDataQuery || isEscapeNeededForString(str, length)) {
                        StringBuilder sb2 = new StringBuilder((int) (((double) str.length()) * 1.1d));
                        sb2.append('\'');
                        for (int i2 = 0; i2 < length; i2++) {
                            char cCharAt = str.charAt(i2);
                            if (cCharAt == 0) {
                                sb2.append(StringUtils.WILDCARD_ESCAPE);
                                sb2.append('0');
                            } else if (cCharAt == '\n') {
                                sb2.append(StringUtils.WILDCARD_ESCAPE);
                                sb2.append('n');
                            } else if (cCharAt == '\r') {
                                sb2.append(StringUtils.WILDCARD_ESCAPE);
                                sb2.append('r');
                            } else if (cCharAt == 26) {
                                sb2.append(StringUtils.WILDCARD_ESCAPE);
                                sb2.append('Z');
                            } else if (cCharAt == '\"') {
                                if (this.usingAnsiMode) {
                                    sb2.append(StringUtils.WILDCARD_ESCAPE);
                                }
                                sb2.append('\"');
                            } else if (cCharAt == '\'') {
                                sb2.append(StringUtils.WILDCARD_ESCAPE);
                                sb2.append('\'');
                            } else if (cCharAt == '\\') {
                                sb2.append(StringUtils.WILDCARD_ESCAPE);
                                sb2.append(StringUtils.WILDCARD_ESCAPE);
                            } else if (cCharAt == 165 || cCharAt == 8361) {
                                if (this.charsetEncoder != null) {
                                    CharBuffer charBufferAllocate = CharBuffer.allocate(1);
                                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(1);
                                    charBufferAllocate.put(cCharAt);
                                    charBufferAllocate.position(0);
                                    this.charsetEncoder.encode(charBufferAllocate, byteBufferAllocate, true);
                                    if (byteBufferAllocate.get(0) == 92) {
                                        sb2.append(StringUtils.WILDCARD_ESCAPE);
                                    }
                                }
                                sb2.append(cCharAt);
                            } else {
                                sb2.append(cCharAt);
                            }
                        }
                        sb2.append('\'');
                        string = sb2.toString();
                    } else {
                        string = str;
                        z = true;
                    }
                    setInternal(i, this.isLoadDataQuery ? StringUtils.getBytes(string) : z ? StringUtils.getBytesWrapped(string, '\'', '\'', this.charConverter, this.charEncoding, this.connection.getServerCharset(), this.connection.parserKnowsUnicode(), getExceptionInterceptor()) : StringUtils.getBytes(string, this.charConverter, this.charEncoding, this.connection.getServerCharset(), this.connection.parserKnowsUnicode(), getExceptionInterceptor()));
                    this.parameterTypes[(i - 1) + getParameterIndexOffset()] = 12;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.sql.PreparedStatement
    public void setTime(int i, Time time, Calendar calendar) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            setTimeInternal(i, time, calendar, calendar.getTimeZone(), true);
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0038  */
    @Override // java.sql.PreparedStatement
    public void setTimestamp(int i, Timestamp timestamp, Calendar calendar) throws SQLException {
        int decimals;
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.sendFractionalSeconds && this.serverSupportsFracSecs) {
                MysqlParameterMetadata mysqlParameterMetadata = this.parameterMetaData;
                if (mysqlParameterMetadata != null) {
                    ResultSetMetaData resultSetMetaData = mysqlParameterMetadata.metadata;
                    if (i > resultSetMetaData.fields.length || i < 0 || resultSetMetaData.getField(i).getDecimals() <= 0) {
                        decimals = -1;
                    } else {
                        decimals = this.parameterMetaData.metadata.getField(i).getDecimals();
                    }
                } else {
                    decimals = -1;
                }
            } else {
                decimals = 0;
            }
            setTimestampInternal(i, timestamp, calendar, calendar.getTimeZone(), true, decimals, this.connection.getUseSSPSCompatibleTimezoneShift());
        }
    }

    public void setTimestampInternal(int i, Timestamp timestamp, Calendar calendar, TimeZone timeZone, boolean z, int i2, boolean z2) throws SQLException {
        int nanos;
        if (timestamp == null) {
            setNull(i, 93);
            return;
        }
        checkClosed();
        Timestamp timestampTruncateFractionalSeconds = (Timestamp) timestamp.clone();
        if (!this.serverSupportsFracSecs || (!this.sendFractionalSeconds && i2 == 0)) {
            timestampTruncateFractionalSeconds = TimeUtil.truncateFractionalSeconds(timestampTruncateFractionalSeconds);
        }
        int i3 = i2 < 0 ? 6 : i2;
        Timestamp timestampAdjustTimestampNanosPrecision = TimeUtil.adjustTimestampNanosPrecision(timestampTruncateFractionalSeconds, i3, !this.connection.isServerTruncatesFracSecs());
        if (this.useLegacyDatetimeCode) {
            Timestamp timestampChangeTimezone = TimeUtil.changeTimezone(this.connection, TimeUtil.setProlepticIfNeeded(this.connection.getUseJDBCCompliantTimezoneShift() ? this.connection.getUtcCalendar() : getCalendarInstanceForSessionOrNew(), calendar), calendar, timestampAdjustTimestampNanosPrecision, timeZone, this.connection.getServerTimezoneTZ(), z);
            if (z2) {
                doSSPSCompatibleTimezoneShift(i, timestampChangeTimezone, i3, calendar);
            } else {
                synchronized (this) {
                    SimpleDateFormat simpleDateFormat = TimeUtil.getSimpleDateFormat(this.tsdf, "''yyyy-MM-dd HH:mm:ss", null, null);
                    this.tsdf = simpleDateFormat;
                    Calendar prolepticIfNeeded = TimeUtil.setProlepticIfNeeded(simpleDateFormat.getCalendar(), calendar);
                    if (this.tsdf.getCalendar() != prolepticIfNeeded) {
                        this.tsdf.setCalendar(prolepticIfNeeded);
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(this.tsdf.format((java.util.Date) timestampChangeTimezone));
                    if (i3 > 0 && (nanos = timestampChangeTimezone.getNanos()) != 0) {
                        stringBuffer.append('.');
                        stringBuffer.append(TimeUtil.formatNanos(nanos, this.serverSupportsFracSecs, i3));
                    }
                    stringBuffer.append('\'');
                    setInternal(i, stringBuffer.toString());
                }
            }
        } else {
            newSetTimestampInternal(i, timestampAdjustTimestampNanosPrecision, calendar);
        }
        this.parameterTypes[(i - 1) + getParameterIndexOffset()] = 93;
    }

    @Override // java.sql.PreparedStatement
    public void setURL(int i, URL url) throws SQLException {
        if (url == null) {
            setNull(i, 1);
        } else {
            setString(i, url.toString());
            this.parameterTypes[(i - 1) + getParameterIndexOffset()] = 70;
        }
    }

    @Override // java.sql.PreparedStatement
    @Deprecated
    public void setUnicodeStream(int i, InputStream inputStream, int i2) throws SQLException {
        if (inputStream == null) {
            setNull(i, 12);
        } else {
            setBinaryStream(i, inputStream, i2);
            this.parameterTypes[(i - 1) + getParameterIndexOffset()] = 2005;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(": ");
        try {
            sb.append(asSql());
        } catch (SQLException e) {
            sb.append("EXCEPTION: " + e.toString());
        }
        return sb.toString();
    }

    public String asSql(boolean z) throws SQLException {
        String string;
        synchronized (checkClosed().getConnectionMutex()) {
            StringBuilder sb = new StringBuilder();
            try {
                int parameterIndexOffset = this.parameterCount + getParameterIndexOffset();
                int i = this.batchCommandIndex;
                Object obj = i != -1 ? this.batchedArgs.get(i) : null;
                for (int i2 = 0; i2 < parameterIndexOffset; i2++) {
                    String str = this.charEncoding;
                    if (str != null) {
                        sb.append(StringUtils.toString(this.staticSqlStrings[i2], str));
                    } else {
                        sb.append(StringUtils.toString(this.staticSqlStrings[i2]));
                    }
                    if (obj == null || !(obj instanceof String)) {
                        int i3 = this.batchCommandIndex;
                        byte[] bArr = i3 == -1 ? this.parameterValues[i2] : ((BatchParams) obj).parameterStrings[i2];
                        boolean z2 = i3 == -1 ? this.isStream[i2] : ((BatchParams) obj).isStream[i2];
                        if (bArr == null && !z2) {
                            if (z) {
                                sb.append("'");
                            }
                            sb.append("** NOT SPECIFIED **");
                            if (z) {
                                sb.append("'");
                            }
                        } else if (z2) {
                            if (z) {
                                sb.append("'");
                            }
                            sb.append("** STREAM DATA **");
                            if (z) {
                                sb.append("'");
                            }
                        } else {
                            SingleByteCharsetConverter singleByteCharsetConverter = this.charConverter;
                            if (singleByteCharsetConverter != null) {
                                sb.append(singleByteCharsetConverter.toString(bArr));
                            } else if (this.charEncoding != null) {
                                sb.append(new String(bArr, this.charEncoding));
                            } else {
                                sb.append(StringUtils.toAsciiString(bArr));
                            }
                        }
                    } else {
                        sb.append((String) obj);
                    }
                }
                if (this.charEncoding != null) {
                    sb.append(StringUtils.toString(this.staticSqlStrings[this.parameterCount + getParameterIndexOffset()], this.charEncoding));
                } else {
                    sb.append(StringUtils.toAsciiString(this.staticSqlStrings[this.parameterCount + getParameterIndexOffset()]));
                }
                string = sb.toString();
            } catch (UnsupportedEncodingException unused) {
                throw new RuntimeException(Messages.getString("PreparedStatement.32") + this.charEncoding + Messages.getString("PreparedStatement.33"));
            }
        }
        return string;
    }

    @Override // java.sql.PreparedStatement
    public void setBlob(int i, java.sql.Blob blob) throws SQLException {
        if (blob == null) {
            setNull(i, 2004);
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(39);
        escapeblockFast(blob.getBytes(1L, (int) blob.length()), byteArrayOutputStream, (int) blob.length());
        byteArrayOutputStream.write(39);
        setInternal(i, byteArrayOutputStream.toByteArray());
        this.parameterTypes[(i - 1) + getParameterIndexOffset()] = 2004;
    }

    @Override // java.sql.PreparedStatement
    public void setDate(int i, Date date, Calendar calendar) throws SQLException {
        if (date == null) {
            setNull(i, 91);
            return;
        }
        if (!this.useLegacyDatetimeCode) {
            newSetDateInternal(i, date, calendar);
            return;
        }
        synchronized (checkClosed().getConnectionMutex()) {
            SimpleDateFormat simpleDateFormat = TimeUtil.getSimpleDateFormat(this.ddf, "''yyyy-MM-dd''", calendar, null);
            this.ddf = simpleDateFormat;
            setInternal(i, simpleDateFormat.format((java.util.Date) date));
            this.parameterTypes[(i - 1) + getParameterIndexOffset()] = 91;
        }
    }

    public void setNCharacterStream(int i, Reader reader, long j) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            try {
                try {
                    if (reader == null) {
                        setNull(i, -1);
                    } else {
                        if (!this.connection.getUseStreamLengthsInPrepStmts() || j == -1) {
                            char[] cArr = new char[4096];
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                int i2 = reader.read(cArr);
                                if (i2 == -1) {
                                    break;
                                } else {
                                    sb.append(cArr, 0, i2);
                                }
                            }
                            setNString(i, sb.toString());
                        } else {
                            int i3 = (int) j;
                            char[] cArr2 = new char[i3];
                            setNString(i, new String(cArr2, 0, readFully(reader, cArr2, i3)));
                        }
                        this.parameterTypes[(i - 1) + getParameterIndexOffset()] = 2011;
                    }
                } catch (IOException e) {
                    throw SQLError.createSQLException(e.toString(), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setNClob(int i, Reader reader, long j) throws SQLException {
        if (reader == null) {
            setNull(i, -1);
        } else {
            setNCharacterStream(i, reader, j);
        }
    }

    @Override // java.sql.PreparedStatement
    public void setAsciiStream(int i, InputStream inputStream) throws SQLException {
        setAsciiStream(i, inputStream, -1);
    }

    public void setBytes(int i, byte[] bArr, boolean z, boolean z2) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (bArr == null) {
                setNull(i, -2);
            } else {
                String encoding = this.connection.getEncoding();
                try {
                    int i2 = 0;
                    if (!this.connection.isNoBackslashEscapesSet() && (!z2 || !this.connection.getUseUnicode() || encoding == null || !CharsetMapping.isMultibyteCharset(encoding))) {
                        int length = bArr.length;
                        boolean z3 = true;
                        if (!z || !this.connection.versionMeetsMinimum(4, 1, 0)) {
                            z3 = false;
                        }
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((z3 ? 9 : 2) + length);
                        if (z3) {
                            byteArrayOutputStream.write(95);
                            byteArrayOutputStream.write(98);
                            byteArrayOutputStream.write(105);
                            byteArrayOutputStream.write(110);
                            byteArrayOutputStream.write(97);
                            byteArrayOutputStream.write(114);
                            byteArrayOutputStream.write(121);
                        }
                        byteArrayOutputStream.write(39);
                        while (i2 < length) {
                            byte b = bArr[i2];
                            if (b == 0) {
                                byteArrayOutputStream.write(92);
                                byteArrayOutputStream.write(48);
                            } else if (b == 10) {
                                byteArrayOutputStream.write(92);
                                byteArrayOutputStream.write(110);
                            } else if (b == 13) {
                                byteArrayOutputStream.write(92);
                                byteArrayOutputStream.write(114);
                            } else if (b == 26) {
                                byteArrayOutputStream.write(92);
                                byteArrayOutputStream.write(90);
                            } else if (b == 34) {
                                byteArrayOutputStream.write(92);
                                byteArrayOutputStream.write(34);
                            } else if (b == 39) {
                                byteArrayOutputStream.write(92);
                                byteArrayOutputStream.write(39);
                            } else if (b != 92) {
                                byteArrayOutputStream.write(b);
                            } else {
                                byteArrayOutputStream.write(92);
                                byteArrayOutputStream.write(92);
                            }
                            i2++;
                        }
                        byteArrayOutputStream.write(39);
                        setInternal(i, byteArrayOutputStream.toByteArray());
                    } else {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream((bArr.length * 2) + 3);
                        byteArrayOutputStream2.write(120);
                        byteArrayOutputStream2.write(39);
                        while (i2 < bArr.length) {
                            int i3 = (bArr[i2] & StatementImpl.USES_VARIABLES_UNKNOWN) / 16;
                            int i4 = (bArr[i2] & StatementImpl.USES_VARIABLES_UNKNOWN) % 16;
                            byte[] bArr2 = HEX_DIGITS;
                            byteArrayOutputStream2.write(bArr2[i3]);
                            byteArrayOutputStream2.write(bArr2[i4]);
                            i2++;
                        }
                        byteArrayOutputStream2.write(39);
                        setInternal(i, byteArrayOutputStream2.toByteArray());
                    }
                } catch (RuntimeException e) {
                    SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(e.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
                    sQLExceptionCreateSQLException.initCause(e);
                    throw sQLExceptionCreateSQLException;
                } catch (SQLException e2) {
                    throw e2;
                }
            }
        }
    }

    public static PreparedStatement getInstance(MySQLConnection mySQLConnection, String str, String str2) throws SQLException {
        return !Util.isJdbc4() ? new PreparedStatement(mySQLConnection, str, str2) : (PreparedStatement) Util.handleNewInstance(JDBC_4_PSTMT_3_ARG_CTOR, new Object[]{mySQLConnection, str, str2}, mySQLConnection.getExceptionInterceptor());
    }

    public Buffer fillSendPacket(byte[][] bArr, InputStream[] inputStreamArr, boolean[] zArr, int[] iArr) throws SQLException {
        Buffer sharedSendPacket;
        int length;
        synchronized (checkClosed().getConnectionMutex()) {
            sharedSendPacket = this.connection.getIO().getSharedSendPacket();
            sharedSendPacket.clear();
            sharedSendPacket.writeByte((byte) 3);
            boolean useStreamLengthsInPrepStmts = this.connection.getUseStreamLengthsInPrepStmts();
            String statementComment = this.connection.getStatementComment();
            byte[] bytes = null;
            if (statementComment != null) {
                SingleByteCharsetConverter singleByteCharsetConverter = this.charConverter;
                if (singleByteCharsetConverter != null) {
                    bytes = singleByteCharsetConverter.toBytes(statementComment);
                } else {
                    bytes = StringUtils.getBytes(statementComment, singleByteCharsetConverter, this.charEncoding, this.connection.getServerCharset(), this.connection.parserKnowsUnicode(), getExceptionInterceptor());
                }
                length = bytes.length + 0 + 6;
            } else {
                length = 0;
            }
            for (int i = 0; i < bArr.length; i++) {
                if (zArr[i] && useStreamLengthsInPrepStmts) {
                    length += iArr[i];
                }
            }
            if (length != 0) {
                sharedSendPacket.ensureCapacity(length);
            }
            if (bytes != null) {
                sharedSendPacket.writeBytesNoNull(Constants.SLASH_STAR_SPACE_AS_BYTES);
                sharedSendPacket.writeBytesNoNull(bytes);
                sharedSendPacket.writeBytesNoNull(Constants.SPACE_STAR_SLASH_SPACE_AS_BYTES);
            }
            for (int i2 = 0; i2 < bArr.length; i2++) {
                checkAllParametersSet(bArr[i2], inputStreamArr[i2], i2);
                sharedSendPacket.writeBytesNoNull(this.staticSqlStrings[i2]);
                if (zArr[i2]) {
                    streamToBytes(sharedSendPacket, inputStreamArr[i2], true, iArr[i2], useStreamLengthsInPrepStmts);
                } else {
                    sharedSendPacket.writeBytesNoNull(bArr[i2]);
                }
            }
            sharedSendPacket.writeBytesNoNull(this.staticSqlStrings[bArr.length]);
        }
        return sharedSendPacket;
    }

    @Override // java.sql.PreparedStatement
    public void setAsciiStream(int i, InputStream inputStream, long j) throws SQLException {
        setAsciiStream(i, inputStream, (int) j);
        this.parameterTypes[(i - 1) + getParameterIndexOffset()] = 2005;
    }

    @Override // java.sql.PreparedStatement
    public void setTime(int i, Time time) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            setTimeInternal(i, time, null, this.connection.getDefaultTimeZone(), false);
        }
    }

    private final int readblock(InputStream inputStream, byte[] bArr, int i) throws SQLException {
        try {
            if (i > bArr.length) {
                i = bArr.length;
            }
            return inputStream.read(bArr, 0, i);
        } catch (Throwable th) {
            SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(Messages.getString("PreparedStatement.56") + th.getClass().getName(), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
            sQLExceptionCreateSQLException.initCause(th);
            throw sQLExceptionCreateSQLException;
        }
    }

    public long executeUpdateInternal(byte[][] bArr, InputStream[] inputStreamArr, boolean[] zArr, int[] iArr, boolean[] zArr2, boolean z) throws SQLException {
        boolean z2;
        long j;
        synchronized (checkClosed().getConnectionMutex()) {
            MySQLConnection mySQLConnection = this.connection;
            if (!mySQLConnection.isReadOnly(false)) {
                if (this.firstCharOfStmt == 'S' && isSelectQuery()) {
                    throw SQLError.createSQLException(Messages.getString("PreparedStatement.37"), SQLError.SQL_STATE_NO_ROWS_UPDATED_OR_DELETED, getExceptionInterceptor());
                }
                resetCancelledState();
                implicitlyCloseAllOpenResults();
                Buffer bufferFillSendPacket = fillSendPacket(bArr, inputStreamArr, zArr, iArr);
                String catalog = null;
                if (!mySQLConnection.getCatalog().equals(this.currentCatalog)) {
                    catalog = mySQLConnection.getCatalog();
                    mySQLConnection.setCatalog(this.currentCatalog);
                }
                mySQLConnection.setSessionMaxRows(-1);
                if (this.retrieveGeneratedKeys) {
                    boolean zIsReadInfoMsgEnabled = mySQLConnection.isReadInfoMsgEnabled();
                    mySQLConnection.setReadInfoMsgEnabled(true);
                    z2 = zIsReadInfoMsgEnabled;
                } else {
                    z2 = false;
                }
                ResultSetInternalMethods resultSetInternalMethodsExecuteInternal = executeInternal(-1, bufferFillSendPacket, false, false, null, z);
                if (this.retrieveGeneratedKeys) {
                    mySQLConnection.setReadInfoMsgEnabled(z2);
                    resultSetInternalMethodsExecuteInternal.setFirstCharOfQuery(this.firstCharOfStmt);
                }
                if (catalog != null) {
                    mySQLConnection.setCatalog(catalog);
                }
                this.results = resultSetInternalMethodsExecuteInternal;
                this.updateCount = resultSetInternalMethodsExecuteInternal.getUpdateCount();
                if (containsOnDuplicateKeyUpdateInSQL() && this.compensateForOnDuplicateKeyUpdate) {
                    long j2 = this.updateCount;
                    if (j2 == 2 || j2 == 0) {
                        this.updateCount = 1L;
                    }
                }
                this.lastInsertId = resultSetInternalMethodsExecuteInternal.getUpdateID();
                j = this.updateCount;
            } else {
                throw SQLError.createSQLException(Messages.getString("PreparedStatement.34") + Messages.getString("PreparedStatement.35"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
        }
        return j;
    }

    @Override // java.sql.PreparedStatement
    public void setNull(int i, int i2, String str) throws SQLException {
        setNull(i, i2);
        this.parameterTypes[(i - 1) + getParameterIndexOffset()] = 0;
    }

    public static PreparedStatement getInstance(MySQLConnection mySQLConnection, String str, String str2, ParseInfo parseInfo) throws SQLException {
        return !Util.isJdbc4() ? new PreparedStatement(mySQLConnection, str, str2, parseInfo) : (PreparedStatement) Util.handleNewInstance(JDBC_4_PSTMT_4_ARG_CTOR, new Object[]{mySQLConnection, str, str2, parseInfo}, mySQLConnection.getExceptionInterceptor());
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002a  */
    @Override // java.sql.PreparedStatement
    public void setTimestamp(int i, Timestamp timestamp) throws SQLException {
        int decimals;
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.sendFractionalSeconds && this.serverSupportsFracSecs) {
                MysqlParameterMetadata mysqlParameterMetadata = this.parameterMetaData;
                if (mysqlParameterMetadata != null) {
                    ResultSetMetaData resultSetMetaData = mysqlParameterMetadata.metadata;
                    if (i > resultSetMetaData.fields.length || i < 0) {
                        decimals = -1;
                    } else {
                        decimals = resultSetMetaData.getField(i).getDecimals();
                    }
                } else {
                    decimals = -1;
                }
            } else {
                decimals = 0;
            }
            setTimestampInternal(i, timestamp, null, this.connection.getDefaultTimeZone(), false, decimals, this.connection.getUseSSPSCompatibleTimezoneShift());
        }
    }

    @Override // com.mysql.jdbc.StatementImpl, java.sql.Statement
    public void addBatch(String str) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            this.batchHasPlainStatements = true;
            super.addBatch(str);
        }
    }

    private final void escapeblockFast(byte[] bArr, ByteArrayOutputStream byteArrayOutputStream, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            byte b = bArr[i3];
            if (b == 0) {
                if (i3 > i2) {
                    byteArrayOutputStream.write(bArr, i2, i3 - i2);
                }
                byteArrayOutputStream.write(92);
                byteArrayOutputStream.write(48);
                i2 = i3 + 1;
            } else if (b == 92 || b == 39 || (!this.usingAnsiMode && b == 34)) {
                if (i3 > i2) {
                    byteArrayOutputStream.write(bArr, i2, i3 - i2);
                }
                byteArrayOutputStream.write(92);
                i2 = i3;
            }
        }
        if (i2 < i) {
            byteArrayOutputStream.write(bArr, i2, i - i2);
        }
    }

    @Override // java.sql.PreparedStatement
    public void setBlob(int i, InputStream inputStream) throws SQLException {
        setBinaryStream(i, inputStream);
    }

    public final void setInternal(int i, String str) throws SQLException {
        byte[] bytes;
        synchronized (checkClosed().getConnectionMutex()) {
            SingleByteCharsetConverter singleByteCharsetConverter = this.charConverter;
            if (singleByteCharsetConverter != null) {
                bytes = singleByteCharsetConverter.toBytes(str);
            } else {
                bytes = StringUtils.getBytes(str, singleByteCharsetConverter, this.charEncoding, this.connection.getServerCharset(), this.connection.parserKnowsUnicode(), getExceptionInterceptor());
            }
            setInternal(i, bytes);
        }
    }

    @Override // java.sql.PreparedStatement
    public void setClob(int i, Reader reader) throws SQLException {
        setCharacterStream(i, reader);
    }

    @Override // java.sql.PreparedStatement
    public void setClob(int i, Reader reader, long j) throws SQLException {
        setCharacterStream(i, reader, j);
    }

    @Override // java.sql.PreparedStatement
    public void setBinaryStream(int i, InputStream inputStream) throws SQLException {
        setBinaryStream(i, inputStream, -1);
    }

    @Override // java.sql.PreparedStatement
    public void setBinaryStream(int i, InputStream inputStream, long j) throws SQLException {
        setBinaryStream(i, inputStream, (int) j);
    }

    @Override // java.sql.PreparedStatement
    public void setCharacterStream(int i, Reader reader) throws SQLException {
        setCharacterStream(i, reader, -1);
    }

    @Override // java.sql.PreparedStatement
    public void setCharacterStream(int i, Reader reader, long j) throws SQLException {
        setCharacterStream(i, reader, (int) j);
    }

    public PreparedStatement(MySQLConnection mySQLConnection, String str, String str2) throws SQLException {
        super(mySQLConnection, str2);
        this.batchHasPlainStatements = false;
        this.dbmd = null;
        this.firstCharOfStmt = (char) 0;
        this.isLoadDataQuery = false;
        this.isNull = null;
        this.isStream = null;
        this.numberOfExecutions = 0;
        this.originalSql = null;
        this.parameterStreams = null;
        this.parameterValues = null;
        this.parameterTypes = null;
        this.staticSqlStrings = null;
        this.streamConvertBuf = null;
        this.streamLengths = null;
        this.tsdf = null;
        this.useTrueBoolean = false;
        this.compensateForOnDuplicateKeyUpdate = false;
        this.batchCommandIndex = -1;
        this.rewrittenBatchSize = 0;
        if (str != null) {
            detectFractionalSecondsSupport();
            this.originalSql = str;
            this.doPingInstead = str.startsWith(StatementImpl.PING_MARKER);
            this.dbmd = this.connection.getMetaData();
            this.useTrueBoolean = this.connection.versionMeetsMinimum(3, 21, 23);
            this.parseInfo = new ParseInfo(str, this.connection, this.dbmd, this.charEncoding, this.charConverter);
            initializeFromParseInfo();
            this.compensateForOnDuplicateKeyUpdate = this.connection.getCompensateOnDuplicateKeyUpdateCounts();
            if (mySQLConnection.getRequiresEscapingEncoder()) {
                this.charsetEncoder = Charset.forName(mySQLConnection.getEncoding()).newEncoder();
                return;
            }
            return;
        }
        throw SQLError.createSQLException(Messages.getString("PreparedStatement.0"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
    }

    private final byte[] streamToBytes(InputStream inputStream, boolean z, int i, boolean z2) throws SQLException {
        int i2;
        byte[] byteArray;
        synchronized (checkClosed().getConnectionMutex()) {
            inputStream.mark(Integer.MAX_VALUE);
            try {
                if (this.streamConvertBuf == null) {
                    this.streamConvertBuf = new byte[4096];
                }
                if (i == -1) {
                    z2 = false;
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (z2) {
                    i2 = readblock(inputStream, this.streamConvertBuf, i);
                } else {
                    i2 = readblock(inputStream, this.streamConvertBuf);
                }
                int i3 = i - i2;
                if (z) {
                    if (this.connection.versionMeetsMinimum(4, 1, 0)) {
                        byteArrayOutputStream.write(95);
                        byteArrayOutputStream.write(98);
                        byteArrayOutputStream.write(105);
                        byteArrayOutputStream.write(110);
                        byteArrayOutputStream.write(97);
                        byteArrayOutputStream.write(114);
                        byteArrayOutputStream.write(121);
                    }
                    byteArrayOutputStream.write(39);
                }
                while (i2 > 0) {
                    if (z) {
                        escapeblockFast(this.streamConvertBuf, byteArrayOutputStream, i2);
                    } else {
                        byteArrayOutputStream.write(this.streamConvertBuf, 0, i2);
                    }
                    if (z2) {
                        i2 = readblock(inputStream, this.streamConvertBuf, i3);
                        if (i2 > 0) {
                            i3 -= i2;
                        }
                    } else {
                        i2 = readblock(inputStream, this.streamConvertBuf);
                    }
                }
                if (z) {
                    byteArrayOutputStream.write(39);
                }
                byteArray = byteArrayOutputStream.toByteArray();
                try {
                    inputStream.reset();
                } catch (IOException unused) {
                }
                if (this.connection.getAutoClosePStmtStreams()) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
            } catch (Throwable th) {
                try {
                    inputStream.reset();
                } catch (IOException unused3) {
                }
                if (this.connection.getAutoClosePStmtStreams()) {
                    try {
                        inputStream.close();
                        throw th;
                    } catch (IOException unused4) {
                        throw th;
                    }
                }
                throw th;
            }
        }
        return byteArray;
    }

    public void setObject(int i, Object obj, int i2) throws SQLException {
        if (!(obj instanceof BigDecimal)) {
            setObject(i, obj, i2, 0);
        } else {
            setObject(i, obj, i2, ((BigDecimal) obj).scale());
        }
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00e0 A[Catch: all -> 0x0012, Exception -> 0x00e5, TryCatch #1 {Exception -> 0x00e5, blocks: (B:23:0x0033, B:24:0x0043, B:25:0x0044, B:27:0x0048, B:28:0x0068, B:30:0x006c, B:31:0x007d, B:32:0x0085, B:34:0x0089, B:41:0x00ae, B:43:0x00b2, B:44:0x00b9, B:45:0x00c7, B:47:0x00cb, B:48:0x00d2, B:35:0x00a1, B:49:0x00e0, B:52:0x00e8, B:54:0x00ec, B:55:0x00f4, B:56:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0115, B:63:0x0136, B:64:0x013b, B:66:0x013f, B:67:0x014b, B:69:0x014f, B:71:0x015a, B:75:0x0167, B:76:0x016b, B:78:0x016f, B:82:0x017a, B:83:0x017e, B:84:0x01a6, B:85:0x01a7, B:87:0x01ab, B:88:0x01ba), top: B:100:0x0017, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00fd A[Catch: all -> 0x0012, Exception -> 0x00e5, TryCatch #1 {Exception -> 0x00e5, blocks: (B:23:0x0033, B:24:0x0043, B:25:0x0044, B:27:0x0048, B:28:0x0068, B:30:0x006c, B:31:0x007d, B:32:0x0085, B:34:0x0089, B:41:0x00ae, B:43:0x00b2, B:44:0x00b9, B:45:0x00c7, B:47:0x00cb, B:48:0x00d2, B:35:0x00a1, B:49:0x00e0, B:52:0x00e8, B:54:0x00ec, B:55:0x00f4, B:56:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0115, B:63:0x0136, B:64:0x013b, B:66:0x013f, B:67:0x014b, B:69:0x014f, B:71:0x015a, B:75:0x0167, B:76:0x016b, B:78:0x016f, B:82:0x017a, B:83:0x017e, B:84:0x01a6, B:85:0x01a7, B:87:0x01ab, B:88:0x01ba), top: B:100:0x0017, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0101 A[Catch: all -> 0x0012, Exception -> 0x00e5, TryCatch #1 {Exception -> 0x00e5, blocks: (B:23:0x0033, B:24:0x0043, B:25:0x0044, B:27:0x0048, B:28:0x0068, B:30:0x006c, B:31:0x007d, B:32:0x0085, B:34:0x0089, B:41:0x00ae, B:43:0x00b2, B:44:0x00b9, B:45:0x00c7, B:47:0x00cb, B:48:0x00d2, B:35:0x00a1, B:49:0x00e0, B:52:0x00e8, B:54:0x00ec, B:55:0x00f4, B:56:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0115, B:63:0x0136, B:64:0x013b, B:66:0x013f, B:67:0x014b, B:69:0x014f, B:71:0x015a, B:75:0x0167, B:76:0x016b, B:78:0x016f, B:82:0x017a, B:83:0x017e, B:84:0x01a6, B:85:0x01a7, B:87:0x01ab, B:88:0x01ba), top: B:100:0x0017, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0109 A[Catch: all -> 0x0012, Exception -> 0x00e5, TryCatch #1 {Exception -> 0x00e5, blocks: (B:23:0x0033, B:24:0x0043, B:25:0x0044, B:27:0x0048, B:28:0x0068, B:30:0x006c, B:31:0x007d, B:32:0x0085, B:34:0x0089, B:41:0x00ae, B:43:0x00b2, B:44:0x00b9, B:45:0x00c7, B:47:0x00cb, B:48:0x00d2, B:35:0x00a1, B:49:0x00e0, B:52:0x00e8, B:54:0x00ec, B:55:0x00f4, B:56:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0115, B:63:0x0136, B:64:0x013b, B:66:0x013f, B:67:0x014b, B:69:0x014f, B:71:0x015a, B:75:0x0167, B:76:0x016b, B:78:0x016f, B:82:0x017a, B:83:0x017e, B:84:0x01a6, B:85:0x01a7, B:87:0x01ab, B:88:0x01ba), top: B:100:0x0017, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x010d A[Catch: all -> 0x0012, Exception -> 0x00e5, TryCatch #1 {Exception -> 0x00e5, blocks: (B:23:0x0033, B:24:0x0043, B:25:0x0044, B:27:0x0048, B:28:0x0068, B:30:0x006c, B:31:0x007d, B:32:0x0085, B:34:0x0089, B:41:0x00ae, B:43:0x00b2, B:44:0x00b9, B:45:0x00c7, B:47:0x00cb, B:48:0x00d2, B:35:0x00a1, B:49:0x00e0, B:52:0x00e8, B:54:0x00ec, B:55:0x00f4, B:56:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0115, B:63:0x0136, B:64:0x013b, B:66:0x013f, B:67:0x014b, B:69:0x014f, B:71:0x015a, B:75:0x0167, B:76:0x016b, B:78:0x016f, B:82:0x017a, B:83:0x017e, B:84:0x01a6, B:85:0x01a7, B:87:0x01ab, B:88:0x01ba), top: B:100:0x0017, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0115 A[Catch: all -> 0x0012, Exception -> 0x00e5, TryCatch #1 {Exception -> 0x00e5, blocks: (B:23:0x0033, B:24:0x0043, B:25:0x0044, B:27:0x0048, B:28:0x0068, B:30:0x006c, B:31:0x007d, B:32:0x0085, B:34:0x0089, B:41:0x00ae, B:43:0x00b2, B:44:0x00b9, B:45:0x00c7, B:47:0x00cb, B:48:0x00d2, B:35:0x00a1, B:49:0x00e0, B:52:0x00e8, B:54:0x00ec, B:55:0x00f4, B:56:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0115, B:63:0x0136, B:64:0x013b, B:66:0x013f, B:67:0x014b, B:69:0x014f, B:71:0x015a, B:75:0x0167, B:76:0x016b, B:78:0x016f, B:82:0x017a, B:83:0x017e, B:84:0x01a6, B:85:0x01a7, B:87:0x01ab, B:88:0x01ba), top: B:100:0x0017, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x01a7 A[Catch: all -> 0x0012, Exception -> 0x00e5, TryCatch #1 {Exception -> 0x00e5, blocks: (B:23:0x0033, B:24:0x0043, B:25:0x0044, B:27:0x0048, B:28:0x0068, B:30:0x006c, B:31:0x007d, B:32:0x0085, B:34:0x0089, B:41:0x00ae, B:43:0x00b2, B:44:0x00b9, B:45:0x00c7, B:47:0x00cb, B:48:0x00d2, B:35:0x00a1, B:49:0x00e0, B:52:0x00e8, B:54:0x00ec, B:55:0x00f4, B:56:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0115, B:63:0x0136, B:64:0x013b, B:66:0x013f, B:67:0x014b, B:69:0x014f, B:71:0x015a, B:75:0x0167, B:76:0x016b, B:78:0x016f, B:82:0x017a, B:83:0x017e, B:84:0x01a6, B:85:0x01a7, B:87:0x01ab, B:88:0x01ba), top: B:100:0x0017, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x01ab A[Catch: all -> 0x0012, Exception -> 0x00e5, TryCatch #1 {Exception -> 0x00e5, blocks: (B:23:0x0033, B:24:0x0043, B:25:0x0044, B:27:0x0048, B:28:0x0068, B:30:0x006c, B:31:0x007d, B:32:0x0085, B:34:0x0089, B:41:0x00ae, B:43:0x00b2, B:44:0x00b9, B:45:0x00c7, B:47:0x00cb, B:48:0x00d2, B:35:0x00a1, B:49:0x00e0, B:52:0x00e8, B:54:0x00ec, B:55:0x00f4, B:56:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0115, B:63:0x0136, B:64:0x013b, B:66:0x013f, B:67:0x014b, B:69:0x014f, B:71:0x015a, B:75:0x0167, B:76:0x016b, B:78:0x016f, B:82:0x017a, B:83:0x017e, B:84:0x01a6, B:85:0x01a7, B:87:0x01ab, B:88:0x01ba), top: B:100:0x0017, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x01ba A[Catch: all -> 0x0012, Exception -> 0x00e5, TRY_LEAVE, TryCatch #1 {Exception -> 0x00e5, blocks: (B:23:0x0033, B:24:0x0043, B:25:0x0044, B:27:0x0048, B:28:0x0068, B:30:0x006c, B:31:0x007d, B:32:0x0085, B:34:0x0089, B:41:0x00ae, B:43:0x00b2, B:44:0x00b9, B:45:0x00c7, B:47:0x00cb, B:48:0x00d2, B:35:0x00a1, B:49:0x00e0, B:52:0x00e8, B:54:0x00ec, B:55:0x00f4, B:56:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0115, B:63:0x0136, B:64:0x013b, B:66:0x013f, B:67:0x014b, B:69:0x014f, B:71:0x015a, B:75:0x0167, B:76:0x016b, B:78:0x016f, B:82:0x017a, B:83:0x017e, B:84:0x01a6, B:85:0x01a7, B:87:0x01ab, B:88:0x01ba), top: B:100:0x0017, outer: #0 }] */
    public void setObject(int i, Object obj, int i2, int i3) throws SQLException {
        java.util.Date date;
        synchronized (checkClosed().getConnectionMutex()) {
            if (obj == null) {
                setNull(i, MysqlErrorNumbers.ER_INVALID_GROUP_FUNC_USE);
            } else {
                try {
                    if (i2 != 12) {
                        boolean z = true;
                        if (i2 != 16) {
                            if (i2 == 1111) {
                                setSerializableObject(i, obj);
                            } else if (i2 == 2004) {
                                if (obj instanceof byte[]) {
                                    setBytes(i, (byte[]) obj);
                                } else if (obj instanceof java.sql.Blob) {
                                    setBlob(i, (java.sql.Blob) obj);
                                } else {
                                    setBytes(i, StringUtils.getBytes(obj.toString(), this.charConverter, this.charEncoding, this.connection.getServerCharset(), this.connection.parserKnowsUnicode(), getExceptionInterceptor()));
                                }
                            } else if (i2 != 2005) {
                                switch (i2) {
                                    case -7:
                                    case -6:
                                    case -5:
                                        setNumericObject(i, obj, i2, i3);
                                        break;
                                    case -4:
                                    case -3:
                                    case -2:
                                        if (obj instanceof byte[]) {
                                            setBytes(i, (byte[]) obj);
                                        } else if (obj instanceof java.sql.Blob) {
                                            setBlob(i, (java.sql.Blob) obj);
                                        } else {
                                            setBytes(i, StringUtils.getBytes(obj.toString(), this.charConverter, this.charEncoding, this.connection.getServerCharset(), this.connection.parserKnowsUnicode(), getExceptionInterceptor()));
                                        }
                                        break;
                                    case -1:
                                        if (obj instanceof BigDecimal) {
                                            setString(i, StringUtils.fixDecimalExponent(StringUtils.consistentToString((BigDecimal) obj)));
                                        } else {
                                            setString(i, obj.toString());
                                        }
                                        break;
                                    default:
                                        switch (i2) {
                                            case 1:
                                                if (obj instanceof BigDecimal) {
                                                    setString(i, StringUtils.fixDecimalExponent(StringUtils.consistentToString((BigDecimal) obj)));
                                                } else {
                                                    setString(i, obj.toString());
                                                }
                                                break;
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 6:
                                            case 7:
                                            case 8:
                                                setNumericObject(i, obj, i2, i3);
                                                break;
                                            default:
                                                switch (i2) {
                                                    case 91:
                                                    case 93:
                                                        if (obj instanceof String) {
                                                            date = TimeUtil.getSimpleDateFormat(null, getDateTimePattern((String) obj, false), null, null).parse((String) obj, new ParsePosition(0));
                                                        } else {
                                                            date = (java.util.Date) obj;
                                                        }
                                                        if (i2 == 91) {
                                                            if (date instanceof Date) {
                                                                setDate(i, (Date) date);
                                                            } else {
                                                                setDate(i, new Date(date.getTime()));
                                                            }
                                                        } else if (i2 == 93) {
                                                            if (date instanceof Timestamp) {
                                                                setTimestamp(i, (Timestamp) date);
                                                            } else {
                                                                setTimestamp(i, new Timestamp(date.getTime()));
                                                            }
                                                        }
                                                        break;
                                                    case 92:
                                                        if (obj instanceof String) {
                                                            setTime(i, new Time(TimeUtil.getSimpleDateFormat(null, getDateTimePattern((String) obj, true), null, null).parse((String) obj).getTime()));
                                                        } else if (obj instanceof Timestamp) {
                                                            setTime(i, new Time(((Timestamp) obj).getTime()));
                                                        } else {
                                                            setTime(i, (Time) obj);
                                                        }
                                                        break;
                                                    default:
                                                        throw SQLError.createSQLException(Messages.getString("PreparedStatement.16"), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
                                                }
                                                break;
                                        }
                                        break;
                                }
                            } else if (obj instanceof java.sql.Clob) {
                                setClob(i, (java.sql.Clob) obj);
                            } else {
                                setString(i, obj.toString());
                            }
                        } else if (obj instanceof Boolean) {
                            setBoolean(i, ((Boolean) obj).booleanValue());
                        } else if (obj instanceof String) {
                            if (!"true".equalsIgnoreCase((String) obj) && "0".equalsIgnoreCase((String) obj)) {
                                z = false;
                            }
                            setBoolean(i, z);
                        } else {
                            if (!(obj instanceof Number)) {
                                throw SQLError.createSQLException("No conversion from " + obj.getClass().getName() + " to Types.BOOLEAN possible.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                            }
                            if (((Number) obj).intValue() == 0) {
                                z = false;
                            }
                            setBoolean(i, z);
                        }
                    } else if (obj instanceof BigDecimal) {
                        setString(i, StringUtils.fixDecimalExponent(StringUtils.consistentToString((BigDecimal) obj)));
                    } else {
                        setString(i, obj.toString());
                    }
                } catch (Exception e) {
                    if (e instanceof SQLException) {
                        throw ((SQLException) e);
                    }
                    SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(Messages.getString("PreparedStatement.17") + obj.getClass().toString() + Messages.getString("PreparedStatement.18") + e.getClass().getName() + Messages.getString("PreparedStatement.19") + e.getMessage(), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
                    sQLExceptionCreateSQLException.initCause(e);
                    throw sQLExceptionCreateSQLException;
                }
            }
        }
    }

    public PreparedStatement(MySQLConnection mySQLConnection, String str, String str2, ParseInfo parseInfo) throws SQLException {
        super(mySQLConnection, str2);
        this.batchHasPlainStatements = false;
        this.dbmd = null;
        this.firstCharOfStmt = (char) 0;
        this.isLoadDataQuery = false;
        this.isNull = null;
        this.isStream = null;
        this.numberOfExecutions = 0;
        this.originalSql = null;
        this.parameterStreams = null;
        this.parameterValues = null;
        this.parameterTypes = null;
        this.staticSqlStrings = null;
        this.streamConvertBuf = null;
        this.streamLengths = null;
        this.tsdf = null;
        this.useTrueBoolean = false;
        this.compensateForOnDuplicateKeyUpdate = false;
        this.batchCommandIndex = -1;
        this.rewrittenBatchSize = 0;
        if (str != null) {
            detectFractionalSecondsSupport();
            this.originalSql = str;
            this.dbmd = this.connection.getMetaData();
            this.useTrueBoolean = this.connection.versionMeetsMinimum(3, 21, 23);
            this.parseInfo = parseInfo;
            this.usingAnsiMode = !this.connection.useAnsiQuotedIdentifiers();
            initializeFromParseInfo();
            this.compensateForOnDuplicateKeyUpdate = this.connection.getCompensateOnDuplicateKeyUpdateCounts();
            if (mySQLConnection.getRequiresEscapingEncoder()) {
                this.charsetEncoder = Charset.forName(mySQLConnection.getEncoding()).newEncoder();
                return;
            }
            return;
        }
        throw SQLError.createSQLException(Messages.getString("PreparedStatement.1"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
    }
}
