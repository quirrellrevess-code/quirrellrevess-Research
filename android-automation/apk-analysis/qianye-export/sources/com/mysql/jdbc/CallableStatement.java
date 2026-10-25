package com.mysql.jdbc;

import com.google.android.flexbox.BuildConfig;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Date;
import java.sql.ParameterMetaData;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.internal.http2.Settings;

/* JADX INFO: loaded from: classes.dex */
public class CallableStatement extends PreparedStatement implements java.sql.CallableStatement {
    public static final Constructor<?> JDBC_4_CSTMT_2_ARGS_CTOR;
    public static final Constructor<?> JDBC_4_CSTMT_4_ARGS_CTOR;
    private static final int NOT_OUTPUT_PARAMETER_INDICATOR = Integer.MIN_VALUE;
    private static final String PARAMETER_NAMESPACE_PREFIX = "@com_mysql_jdbc_outparam_";
    private boolean callingStoredFunction;
    private ResultSetInternalMethods functionReturnValueResults;
    private boolean hasOutputParams;
    public boolean outputParamWasNull;
    private ResultSetInternalMethods outputParameterResults;
    public CallableStatementParamInfo paramInfo;
    private int[] parameterIndexToRsIndex;
    private int[] placeholderToParameterIndexMap;
    private CallableStatementParam returnValueParam;

    public static class CallableStatementParam {
        public int desiredJdbcType;
        public int inOutModifier;
        public int index;
        public boolean isIn;
        public boolean isOut;
        public int jdbcType;
        public short nullability;
        public String paramName;
        public int precision;
        public int scale;
        public String typeName;

        public CallableStatementParam(String str, int i, boolean z, boolean z2, int i2, String str2, int i3, int i4, short s, int i5) {
            this.paramName = str;
            this.isIn = z;
            this.isOut = z2;
            this.index = i;
            this.jdbcType = i2;
            this.typeName = str2;
            this.precision = i3;
            this.scale = i4;
            this.nullability = s;
            this.inOutModifier = i5;
        }

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public class CallableStatementParamInfo implements ParameterMetaData {
        public String catalogInUse;
        public boolean isFunctionCall;
        public boolean isReadOnlySafeChecked;
        public boolean isReadOnlySafeProcedure;
        public String nativeSql;
        public int numParameters;
        public List<CallableStatementParam> parameterList;
        public Map<String, CallableStatementParam> parameterMap;

        public CallableStatementParamInfo(CallableStatementParamInfo callableStatementParamInfo) {
            this.isReadOnlySafeProcedure = false;
            this.isReadOnlySafeChecked = false;
            this.nativeSql = CallableStatement.this.originalSql;
            this.catalogInUse = CallableStatement.this.currentCatalog;
            this.isFunctionCall = callableStatementParamInfo.isFunctionCall;
            int[] iArr = CallableStatement.this.placeholderToParameterIndexMap;
            int length = iArr.length;
            this.isReadOnlySafeProcedure = callableStatementParamInfo.isReadOnlySafeProcedure;
            this.isReadOnlySafeChecked = callableStatementParamInfo.isReadOnlySafeChecked;
            this.parameterList = new ArrayList(callableStatementParamInfo.numParameters);
            this.parameterMap = new HashMap(callableStatementParamInfo.numParameters);
            if (this.isFunctionCall) {
                this.parameterList.add(callableStatementParamInfo.parameterList.get(0));
            }
            boolean z = this.isFunctionCall;
            for (int i = 0; i < length; i++) {
                if (iArr[i] != 0) {
                    CallableStatementParam callableStatementParam = callableStatementParamInfo.parameterList.get(iArr[i] + (z ? 1 : 0));
                    this.parameterList.add(callableStatementParam);
                    this.parameterMap.put(callableStatementParam.paramName, callableStatementParam);
                }
            }
            this.numParameters = this.parameterList.size();
        }

        private void addParametersFromDBMD(ResultSet resultSet) throws SQLException {
            int i;
            boolean z;
            boolean z2;
            int i2 = 0;
            while (resultSet.next()) {
                String string = resultSet.getString(4);
                int i3 = resultSet.getInt(5);
                if (i3 == 1) {
                    i = 1;
                } else if (i3 != 2) {
                    i = (i3 == 4 || i3 == 5) ? 4 : 0;
                } else {
                    i = 2;
                }
                if (i2 == 0 && this.isFunctionCall) {
                    z = false;
                    z2 = true;
                } else if (i == 2) {
                    z = true;
                    z2 = true;
                } else {
                    if (i != 1) {
                        z = i == 4;
                        z = false;
                        z2 = true;
                    }
                    z2 = false;
                }
                CallableStatementParam callableStatementParam = new CallableStatementParam(string, i2, z, z2, resultSet.getInt(6), resultSet.getString(7), resultSet.getInt(8), resultSet.getInt(10), resultSet.getShort(12), i);
                this.parameterList.add(callableStatementParam);
                this.parameterMap.put(string, callableStatementParam);
                i2++;
            }
        }

        public void checkBounds(int i) throws SQLException {
            int i2 = i - 1;
            if (i < 0 || i2 >= this.numParameters) {
                throw SQLError.createSQLException(Messages.getString("CallableStatement.11") + i + Messages.getString("CallableStatement.12") + this.numParameters + Messages.getString("CallableStatement.13"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, CallableStatement.this.getExceptionInterceptor());
            }
        }

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public CallableStatementParam getParameter(int i) {
            return this.parameterList.get(i);
        }

        @Override // java.sql.ParameterMetaData
        public String getParameterClassName(int i) throws SQLException {
            String parameterTypeName = getParameterTypeName(i);
            return ResultSetMetaData.getClassNameForJavaType(getParameterType(i), StringUtils.indexOfIgnoreCase(parameterTypeName, "UNSIGNED") != -1, StringUtils.startsWithIgnoreCase(parameterTypeName, "MEDIUMINT") ? 9 : 0, (StringUtils.indexOfIgnoreCase(parameterTypeName, "BLOB") == -1 && StringUtils.indexOfIgnoreCase(parameterTypeName, "BINARY") == -1) ? false : true, false, CallableStatement.this.connection.getYearIsDateType());
        }

        @Override // java.sql.ParameterMetaData
        public int getParameterCount() throws SQLException {
            List<CallableStatementParam> list = this.parameterList;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // java.sql.ParameterMetaData
        public int getParameterMode(int i) throws SQLException {
            checkBounds(i);
            return getParameter(i - 1).inOutModifier;
        }

        @Override // java.sql.ParameterMetaData
        public int getParameterType(int i) throws SQLException {
            checkBounds(i);
            return getParameter(i - 1).jdbcType;
        }

        @Override // java.sql.ParameterMetaData
        public String getParameterTypeName(int i) throws SQLException {
            checkBounds(i);
            return getParameter(i - 1).typeName;
        }

        @Override // java.sql.ParameterMetaData
        public int getPrecision(int i) throws SQLException {
            checkBounds(i);
            return getParameter(i - 1).precision;
        }

        @Override // java.sql.ParameterMetaData
        public int getScale(int i) throws SQLException {
            checkBounds(i);
            return getParameter(i - 1).scale;
        }

        @Override // java.sql.ParameterMetaData
        public int isNullable(int i) throws SQLException {
            checkBounds(i);
            return getParameter(i - 1).nullability;
        }

        @Override // java.sql.ParameterMetaData
        public boolean isSigned(int i) throws SQLException {
            checkBounds(i);
            return false;
        }

        @Override // java.sql.Wrapper
        public boolean isWrapperFor(Class<?> cls) throws SQLException {
            CallableStatement.this.checkClosed();
            return cls.isInstance(this);
        }

        public Iterator<CallableStatementParam> iterator() {
            return this.parameterList.iterator();
        }

        public int numberOfParameters() {
            return this.numParameters;
        }

        @Override // java.sql.Wrapper
        public <T> T unwrap(Class<T> cls) throws SQLException {
            try {
                return cls.cast(this);
            } catch (ClassCastException unused) {
                throw SQLError.createSQLException("Unable to unwrap to " + cls.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, CallableStatement.this.getExceptionInterceptor());
            }
        }

        public CallableStatementParam getParameter(String str) {
            return this.parameterMap.get(str);
        }

        public CallableStatementParamInfo(ResultSet resultSet) throws SQLException {
            this.isReadOnlySafeProcedure = false;
            this.isReadOnlySafeChecked = false;
            boolean zLast = resultSet.last();
            this.nativeSql = CallableStatement.this.originalSql;
            this.catalogInUse = CallableStatement.this.currentCatalog;
            this.isFunctionCall = CallableStatement.this.callingStoredFunction;
            if (zLast) {
                this.numParameters = resultSet.getRow();
                this.parameterList = new ArrayList(this.numParameters);
                this.parameterMap = new HashMap(this.numParameters);
                resultSet.beforeFirst();
                addParametersFromDBMD(resultSet);
            } else {
                this.numParameters = 0;
            }
            if (this.isFunctionCall) {
                this.numParameters++;
            }
        }
    }

    static {
        if (!Util.isJdbc4()) {
            JDBC_4_CSTMT_4_ARGS_CTOR = null;
            JDBC_4_CSTMT_2_ARGS_CTOR = null;
            return;
        }
        try {
            String str = Util.isJdbc42() ? "com.mysql.jdbc.JDBC42CallableStatement" : "com.mysql.jdbc.JDBC4CallableStatement";
            JDBC_4_CSTMT_2_ARGS_CTOR = Class.forName(str).getConstructor(MySQLConnection.class, CallableStatementParamInfo.class);
            JDBC_4_CSTMT_4_ARGS_CTOR = Class.forName(str).getConstructor(MySQLConnection.class, String.class, String.class, Boolean.TYPE);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        } catch (SecurityException e3) {
            throw new RuntimeException(e3);
        }
    }

    public CallableStatement(MySQLConnection mySQLConnection, CallableStatementParamInfo callableStatementParamInfo) throws SQLException {
        super(mySQLConnection, callableStatementParamInfo.nativeSql, callableStatementParamInfo.catalogInUse);
        this.callingStoredFunction = false;
        this.hasOutputParams = false;
        this.outputParamWasNull = false;
        this.paramInfo = callableStatementParamInfo;
        boolean z = callableStatementParamInfo.isFunctionCall;
        this.callingStoredFunction = z;
        if (z) {
            this.parameterCount++;
        }
        this.retrieveGeneratedKeys = true;
    }

    private CallableStatementParam checkIsOutputParam(int i) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.callingStoredFunction) {
                if (i == 1) {
                    if (this.returnValueParam == null) {
                        this.returnValueParam = new CallableStatementParam(BuildConfig.FLAVOR, 0, false, true, 12, "VARCHAR", 0, 0, (short) 2, 5);
                    }
                    return this.returnValueParam;
                }
                i--;
            }
            checkParameterIndexBounds(i);
            int i2 = i - 1;
            int[] iArr = this.placeholderToParameterIndexMap;
            if (iArr != null) {
                i2 = iArr[i2];
            }
            CallableStatementParam parameter = this.paramInfo.getParameter(i2);
            if (this.connection.getNoAccessToProcedureBodies()) {
                parameter.isOut = true;
                parameter.isIn = true;
                parameter.inOutModifier = 2;
            } else if (!parameter.isOut) {
                throw SQLError.createSQLException(Messages.getString("CallableStatement.9") + i + Messages.getString("CallableStatement.10"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            this.hasOutputParams = true;
            return parameter;
        }
    }

    private void checkParameterIndexBounds(int i) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            this.paramInfo.checkBounds(i);
        }
    }

    private boolean checkReadOnlyProcedure() throws SQLException {
        java.sql.PreparedStatement preparedStatementPrepareStatement;
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.connection.getNoAccessToProcedureBodies()) {
                return false;
            }
            CallableStatementParamInfo callableStatementParamInfo = this.paramInfo;
            if (callableStatementParamInfo.isReadOnlySafeChecked) {
                return callableStatementParamInfo.isReadOnlySafeProcedure;
            }
            ResultSet resultSetExecuteQuery = null;
            try {
                String strExtractProcedureName = extractProcedureName();
                String strSubstring = this.currentCatalog;
                if (strExtractProcedureName.indexOf(".") != -1) {
                    strSubstring = strExtractProcedureName.substring(0, strExtractProcedureName.indexOf("."));
                    if (StringUtils.startsWithIgnoreCaseAndWs(strSubstring, "`") && strSubstring.trim().endsWith("`")) {
                        strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
                    }
                    strExtractProcedureName = StringUtils.toString(StringUtils.stripEnclosure(StringUtils.getBytes(strExtractProcedureName.substring(strExtractProcedureName.indexOf(".") + 1)), "`", "`"));
                }
                preparedStatementPrepareStatement = this.connection.prepareStatement("SELECT SQL_DATA_ACCESS FROM information_schema.routines WHERE routine_schema = ? AND routine_name = ?");
                try {
                    preparedStatementPrepareStatement.setMaxRows(0);
                    preparedStatementPrepareStatement.setFetchSize(0);
                    preparedStatementPrepareStatement.setString(1, strSubstring);
                    preparedStatementPrepareStatement.setString(2, strExtractProcedureName);
                    resultSetExecuteQuery = preparedStatementPrepareStatement.executeQuery();
                    if (resultSetExecuteQuery.next()) {
                        String string = resultSetExecuteQuery.getString(1);
                        if ("READS SQL DATA".equalsIgnoreCase(string) || "NO SQL".equalsIgnoreCase(string)) {
                            synchronized (this.paramInfo) {
                                CallableStatementParamInfo callableStatementParamInfo2 = this.paramInfo;
                                callableStatementParamInfo2.isReadOnlySafeChecked = true;
                                callableStatementParamInfo2.isReadOnlySafeProcedure = true;
                            }
                            if (resultSetExecuteQuery != null) {
                                resultSetExecuteQuery.close();
                            }
                            if (preparedStatementPrepareStatement != null) {
                                preparedStatementPrepareStatement.close();
                            }
                            return true;
                        }
                    }
                    if (resultSetExecuteQuery != null) {
                        resultSetExecuteQuery.close();
                    }
                    if (preparedStatementPrepareStatement != null) {
                        preparedStatementPrepareStatement.close();
                    }
                } catch (SQLException unused) {
                    if (resultSetExecuteQuery != null) {
                        resultSetExecuteQuery.close();
                    }
                    if (preparedStatementPrepareStatement != null) {
                        preparedStatementPrepareStatement.close();
                    }
                    CallableStatementParamInfo callableStatementParamInfo3 = this.paramInfo;
                    callableStatementParamInfo3.isReadOnlySafeChecked = false;
                    callableStatementParamInfo3.isReadOnlySafeProcedure = false;
                    return false;
                } catch (Throwable th) {
                    th = th;
                    if (resultSetExecuteQuery != null) {
                        resultSetExecuteQuery.close();
                    }
                    if (preparedStatementPrepareStatement != null) {
                        preparedStatementPrepareStatement.close();
                    }
                    throw th;
                }
            } catch (SQLException unused2) {
                preparedStatementPrepareStatement = null;
            } catch (Throwable th2) {
                th = th2;
                preparedStatementPrepareStatement = null;
            }
            CallableStatementParamInfo callableStatementParamInfo4 = this.paramInfo;
            callableStatementParamInfo4.isReadOnlySafeChecked = false;
            callableStatementParamInfo4.isReadOnlySafeProcedure = false;
            return false;
        }
    }

    private void checkStreamability() throws SQLException {
        if (this.hasOutputParams && createStreamingResultSet()) {
            throw SQLError.createSQLException(Messages.getString("CallableStatement.14"), SQLError.SQL_STATE_DRIVER_NOT_CAPABLE, getExceptionInterceptor());
        }
    }

    private void convertGetProcedureColumnsToInternalDescriptors(ResultSet resultSet) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            this.paramInfo = new CallableStatementParamInfo(resultSet);
        }
    }

    private void determineParameterTypes() throws SQLException {
        ResultSet resultSet;
        synchronized (checkClosed().getConnectionMutex()) {
            SQLException e = null;
            try {
                try {
                    String strExtractProcedureName = extractProcedureName();
                    String identifierQuoteString = BuildConfig.FLAVOR;
                    try {
                        if (this.connection.supportsQuotedIdentifiers()) {
                            identifierQuoteString = this.connection.getMetaData().getIdentifierQuoteString();
                        } else {
                            identifierQuoteString = BuildConfig.FLAVOR;
                        }
                    } catch (SQLException e2) {
                        AssertionFailedException.shouldNotHappen(e2);
                    }
                    List<String> listSplitDBdotName = StringUtils.splitDBdotName(strExtractProcedureName, BuildConfig.FLAVOR, identifierQuoteString, this.connection.isNoBackslashEscapesSet());
                    String str = BuildConfig.FLAVOR;
                    boolean z = false;
                    if (listSplitDBdotName.size() == 2) {
                        str = listSplitDBdotName.get(0);
                        strExtractProcedureName = listSplitDBdotName.get(1);
                    }
                    java.sql.DatabaseMetaData metaData = this.connection.getMetaData();
                    boolean z2 = str.length() <= 0;
                    if (this.connection.versionMeetsMinimum(5, 0, 2) && z2) {
                        str = this.currentCatalog;
                    }
                    ResultSet procedureColumns = metaData.getProcedureColumns(str, null, strExtractProcedureName, "%");
                    try {
                        try {
                            if (procedureColumns.next()) {
                                procedureColumns.previous();
                                z = true;
                            }
                        } catch (Throwable th) {
                            resultSet = procedureColumns;
                            th = th;
                            if (resultSet != null) {
                                try {
                                    resultSet.close();
                                } catch (SQLException e3) {
                                    e = e3;
                                }
                            }
                            if (e == null) {
                                throw th;
                            }
                            throw e;
                        }
                    } catch (Exception unused) {
                    }
                    if (z) {
                        convertGetProcedureColumnsToInternalDescriptors(procedureColumns);
                    } else {
                        fakeParameterTypes(true);
                    }
                    if (procedureColumns != null) {
                        try {
                            procedureColumns.close();
                        } catch (SQLException e4) {
                            e = e4;
                        }
                    }
                    if (e != null) {
                        throw e;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    resultSet = null;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    private String extractProcedureName() throws SQLException {
        int i;
        String strStripComments = StringUtils.stripComments(this.originalSql, "`\"'", "`\"'", true, false, true, true);
        int iIndexOfIgnoreCase = StringUtils.indexOfIgnoreCase(strStripComments, "CALL ");
        if (iIndexOfIgnoreCase == -1) {
            iIndexOfIgnoreCase = StringUtils.indexOfIgnoreCase(strStripComments, "SELECT ");
            i = 7;
        } else {
            i = 5;
        }
        if (iIndexOfIgnoreCase == -1) {
            throw SQLError.createSQLException(Messages.getString("CallableStatement.1"), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
        }
        StringBuilder sb = new StringBuilder();
        String strTrim = strStripComments.substring(iIndexOfIgnoreCase + i).trim();
        int length = strTrim.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = strTrim.charAt(i2);
            if (Character.isWhitespace(cCharAt) || cCharAt == '(' || cCharAt == '?') {
                break;
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    private void fakeParameterTypes(boolean z) throws SQLException {
        byte[] bArrS2b;
        synchronized (checkClosed().getConnectionMutex()) {
            int i = 13;
            char c = 3;
            Field[] fieldArr = {new Field(BuildConfig.FLAVOR, "PROCEDURE_CAT", 1, 0), new Field(BuildConfig.FLAVOR, "PROCEDURE_SCHEM", 1, 0), new Field(BuildConfig.FLAVOR, "PROCEDURE_NAME", 1, 0), new Field(BuildConfig.FLAVOR, "COLUMN_NAME", 1, 0), new Field(BuildConfig.FLAVOR, "COLUMN_TYPE", 1, 0), new Field(BuildConfig.FLAVOR, "DATA_TYPE", 5, 0), new Field(BuildConfig.FLAVOR, "TYPE_NAME", 1, 0), new Field(BuildConfig.FLAVOR, "PRECISION", 4, 0), new Field(BuildConfig.FLAVOR, "LENGTH", 4, 0), new Field(BuildConfig.FLAVOR, "SCALE", 5, 0), new Field(BuildConfig.FLAVOR, "RADIX", 5, 0), new Field(BuildConfig.FLAVOR, "NULLABLE", 5, 0), new Field(BuildConfig.FLAVOR, "REMARKS", 1, 0)};
            byte[] bArr = null;
            String strExtractProcedureName = z ? extractProcedureName() : null;
            if (strExtractProcedureName == null) {
                bArrS2b = null;
            } else {
                try {
                    bArrS2b = StringUtils.getBytes(strExtractProcedureName, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                    bArrS2b = StringUtils.s2b(strExtractProcedureName, this.connection);
                }
            }
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < this.parameterCount) {
                byte[][] bArr2 = new byte[i][];
                bArr2[0] = bArr;
                bArr2[1] = bArr;
                bArr2[2] = bArrS2b;
                bArr2[c] = StringUtils.s2b(String.valueOf(i2), this.connection);
                bArr2[4] = StringUtils.s2b(String.valueOf(1), this.connection);
                bArr2[5] = StringUtils.s2b(String.valueOf(12), this.connection);
                bArr2[6] = StringUtils.s2b("VARCHAR", this.connection);
                bArr2[7] = StringUtils.s2b(Integer.toString(Settings.DEFAULT_INITIAL_WINDOW_SIZE), this.connection);
                bArr2[8] = StringUtils.s2b(Integer.toString(Settings.DEFAULT_INITIAL_WINDOW_SIZE), this.connection);
                bArr2[9] = StringUtils.s2b(Integer.toString(0), this.connection);
                bArr2[10] = StringUtils.s2b(Integer.toString(10), this.connection);
                bArr2[11] = StringUtils.s2b(Integer.toString(2), this.connection);
                bArr2[12] = null;
                arrayList.add(new ByteArrayRow(bArr2, getExceptionInterceptor()));
                i2++;
                i = 13;
                bArr = null;
                c = 3;
            }
            convertGetProcedureColumnsToInternalDescriptors(DatabaseMetaData.buildResultSet(fieldArr, arrayList, this.connection));
        }
    }

    private void generateParameterMap() throws SQLException {
        int i;
        String str;
        String str2;
        int iIndexOf;
        int iIndexOfIgnoreCase;
        synchronized (checkClosed().getConnectionMutex()) {
            CallableStatementParamInfo callableStatementParamInfo = this.paramInfo;
            if (callableStatementParamInfo == null) {
                return;
            }
            int parameterCount = callableStatementParamInfo.getParameterCount();
            boolean z = this.callingStoredFunction;
            if (z) {
                parameterCount--;
            }
            if (this.paramInfo != null && (i = this.parameterCount) != parameterCount) {
                this.placeholderToParameterIndexMap = new int[i];
                if (z) {
                    str = this.originalSql;
                    str2 = "SELECT";
                } else {
                    str = this.originalSql;
                    str2 = "CALL";
                }
                int iIndexOfIgnoreCase2 = StringUtils.indexOfIgnoreCase(str, str2);
                if (iIndexOfIgnoreCase2 != -1 && (iIndexOf = this.originalSql.indexOf(40, iIndexOfIgnoreCase2 + 4)) != -1 && (iIndexOfIgnoreCase = StringUtils.indexOfIgnoreCase(iIndexOf, this.originalSql, ")", "'", "'", StringUtils.SEARCH_MODE__ALL)) != -1) {
                    List<String> listSplit = StringUtils.split(this.originalSql.substring(iIndexOf + 1, iIndexOfIgnoreCase), ",", "'\"", "'\"", true);
                    int size = listSplit.size();
                    int i2 = 0;
                    for (int i3 = 0; i3 < size; i3++) {
                        if (listSplit.get(i3).equals("?")) {
                            this.placeholderToParameterIndexMap[i2] = i3;
                            i2++;
                        }
                    }
                }
            }
        }
    }

    public static CallableStatement getInstance(MySQLConnection mySQLConnection, String str, String str2, boolean z) throws SQLException {
        return !Util.isJdbc4() ? new CallableStatement(mySQLConnection, str, str2, z) : (CallableStatement) Util.handleNewInstance(JDBC_4_CSTMT_4_ARGS_CTOR, new Object[]{mySQLConnection, str, str2, Boolean.valueOf(z)}, mySQLConnection.getExceptionInterceptor());
    }

    private boolean hasParametersView() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            try {
                try {
                    if (!this.connection.versionMeetsMinimum(5, 5, 0)) {
                        return false;
                    }
                    return new DatabaseMetaDataUsingInfoSchema(this.connection, this.connection.getCatalog()).gethasParametersView();
                } catch (SQLException unused) {
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static String mangleParameterName(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        if (str.length() > 0 && str.charAt(0) == '@') {
            i = 1;
        }
        StringBuilder sb = new StringBuilder(25 + str.length());
        sb.append(PARAMETER_NAMESPACE_PREFIX);
        sb.append(str.substring(i));
        return sb.toString();
    }

    private void retrieveOutParams() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            int iNumberOfParameters = this.paramInfo.numberOfParameters();
            this.parameterIndexToRsIndex = new int[iNumberOfParameters];
            for (int i = 0; i < iNumberOfParameters; i++) {
                this.parameterIndexToRsIndex[i] = Integer.MIN_VALUE;
            }
            java.sql.Statement statement = null;
            if (iNumberOfParameters > 0) {
                StringBuilder sb = new StringBuilder("SELECT ");
                boolean z = false;
                int i2 = 0;
                boolean z2 = true;
                for (CallableStatementParam callableStatementParam : this.paramInfo) {
                    if (callableStatementParam.isOut) {
                        int i3 = i2 + 1;
                        this.parameterIndexToRsIndex[callableStatementParam.index] = i2;
                        if (callableStatementParam.paramName == null && hasParametersView()) {
                            callableStatementParam.paramName = "nullnp" + callableStatementParam.index;
                        }
                        String strMangleParameterName = mangleParameterName(callableStatementParam.paramName);
                        if (z2) {
                            z2 = false;
                        } else {
                            sb.append(",");
                        }
                        if (!strMangleParameterName.startsWith("@")) {
                            sb.append('@');
                        }
                        sb.append(strMangleParameterName);
                        i2 = i3;
                        z = true;
                    }
                }
                if (z) {
                    try {
                        java.sql.Statement statementCreateStatement = this.connection.createStatement();
                        try {
                            ResultSetInternalMethods resultSetInternalMethodsCopy = ((ResultSetInternalMethods) statementCreateStatement.executeQuery(sb.toString())).copy();
                            this.outputParameterResults = resultSetInternalMethodsCopy;
                            if (!resultSetInternalMethodsCopy.next()) {
                                this.outputParameterResults.close();
                                this.outputParameterResults = null;
                            }
                            if (statementCreateStatement != null) {
                                statementCreateStatement.close();
                            }
                        } catch (Throwable th) {
                            th = th;
                            statement = statementCreateStatement;
                            if (statement != null) {
                                statement.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    this.outputParameterResults = null;
                }
            } else {
                this.outputParameterResults = null;
            }
        }
    }

    private void setInOutParamsOnServer() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            CallableStatementParamInfo callableStatementParamInfo = this.paramInfo;
            if (callableStatementParamInfo.numParameters > 0) {
                for (CallableStatementParam callableStatementParam : callableStatementParamInfo) {
                    if (callableStatementParam.isOut && callableStatementParam.isIn) {
                        if (callableStatementParam.paramName == null && hasParametersView()) {
                            callableStatementParam.paramName = "nullnp" + callableStatementParam.index;
                        }
                        String strMangleParameterName = mangleParameterName(callableStatementParam.paramName);
                        StringBuilder sb = new StringBuilder(strMangleParameterName.length() + 4 + 1 + 1);
                        sb.append("SET ");
                        sb.append(strMangleParameterName);
                        sb.append("=?");
                        PreparedStatement preparedStatement = null;
                        try {
                            PreparedStatement preparedStatement2 = (PreparedStatement) ((Wrapper) this.connection.clientPrepareStatement(sb.toString())).unwrap(PreparedStatement.class);
                            try {
                                boolean[] zArr = this.isNull;
                                int i = callableStatementParam.index;
                                if (zArr[i]) {
                                    preparedStatement2.setBytesNoEscapeNoQuotes(1, "NULL".getBytes());
                                } else {
                                    byte[] bytesRepresentation = getBytesRepresentation(i);
                                    if (bytesRepresentation == null) {
                                        preparedStatement2.setNull(1, 0);
                                    } else if (bytesRepresentation.length > 8 && bytesRepresentation[0] == 95 && bytesRepresentation[1] == 98 && bytesRepresentation[2] == 105 && bytesRepresentation[3] == 110 && bytesRepresentation[4] == 97 && bytesRepresentation[5] == 114 && bytesRepresentation[6] == 121 && bytesRepresentation[7] == 39) {
                                        preparedStatement2.setBytesNoEscapeNoQuotes(1, bytesRepresentation);
                                    } else {
                                        int i2 = callableStatementParam.desiredJdbcType;
                                        if (i2 == -7 || i2 == 2000 || i2 == 2004 || i2 == -4 || i2 == -3 || i2 == -2) {
                                            preparedStatement2.setBytes(1, bytesRepresentation);
                                        } else {
                                            preparedStatement2.setBytesNoEscape(1, bytesRepresentation);
                                        }
                                    }
                                }
                                preparedStatement2.executeUpdate();
                                if (preparedStatement2 != null) {
                                    preparedStatement2.close();
                                }
                            } catch (Throwable th) {
                                th = th;
                                preparedStatement = preparedStatement2;
                                if (preparedStatement != null) {
                                    preparedStatement.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                }
            }
        }
    }

    private void setOutParams() throws SQLException {
        int i;
        synchronized (checkClosed().getConnectionMutex()) {
            CallableStatementParamInfo callableStatementParamInfo = this.paramInfo;
            if (callableStatementParamInfo.numParameters > 0) {
                for (CallableStatementParam callableStatementParam : callableStatementParamInfo) {
                    if (!this.callingStoredFunction && callableStatementParam.isOut) {
                        if (callableStatementParam.paramName == null && hasParametersView()) {
                            callableStatementParam.paramName = "nullnp" + callableStatementParam.index;
                        }
                        String strMangleParameterName = mangleParameterName(callableStatementParam.paramName);
                        boolean z = true;
                        if (this.placeholderToParameterIndexMap == null) {
                            i = callableStatementParam.index + 1;
                        } else {
                            int i2 = 0;
                            int i3 = 0;
                            while (true) {
                                int[] iArr = this.placeholderToParameterIndexMap;
                                if (i3 >= iArr.length) {
                                    z = false;
                                    break;
                                } else {
                                    if (iArr[i3] == callableStatementParam.index) {
                                        i2 = i3 + 1;
                                        break;
                                    }
                                    i3++;
                                }
                            }
                            if (!z) {
                                throw SQLError.createSQLException(Messages.getString("CallableStatement.21") + callableStatementParam.paramName + Messages.getString("CallableStatement.22"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                            }
                            i = i2;
                        }
                        setBytesNoEscapeNoQuotes(i, StringUtils.getBytes(strMangleParameterName, this.charConverter, this.charEncoding, this.connection.getServerCharset(), this.connection.parserKnowsUnicode(), getExceptionInterceptor()));
                    }
                }
            }
        }
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void addBatch() throws SQLException {
        setOutParams();
        super.addBatch();
    }

    @Override // com.mysql.jdbc.PreparedStatement
    public boolean checkReadOnlySafeStatement() throws SQLException {
        return super.checkReadOnlySafeStatement() || checkReadOnlyProcedure();
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void clearParameters() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            super.clearParameters();
            try {
                ResultSetInternalMethods resultSetInternalMethods = this.outputParameterResults;
                if (resultSetInternalMethods != null) {
                    resultSetInternalMethods.close();
                }
                this.outputParameterResults = null;
            } catch (Throwable th) {
                this.outputParameterResults = null;
                throw th;
            }
        }
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public boolean execute() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            checkStreamability();
            setInOutParamsOnServer();
            setOutParams();
            boolean zExecute = super.execute();
            if (this.callingStoredFunction) {
                ResultSetInternalMethods resultSetInternalMethods = this.results;
                this.functionReturnValueResults = resultSetInternalMethods;
                resultSetInternalMethods.next();
                this.results = null;
            }
            retrieveOutParams();
            if (this.callingStoredFunction) {
                return false;
            }
            return zExecute;
        }
    }

    @Override // com.mysql.jdbc.StatementImpl, java.sql.Statement
    public int[] executeBatch() throws SQLException {
        return Util.truncateAndConvertToInt(executeLargeBatch());
    }

    @Override // com.mysql.jdbc.StatementImpl
    public long[] executeLargeBatch() throws SQLException {
        if (this.hasOutputParams) {
            throw SQLError.createSQLException("Can't call executeBatch() on CallableStatement with OUTPUT parameters", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
        return super.executeLargeBatch();
    }

    @Override // com.mysql.jdbc.PreparedStatement
    public long executeLargeUpdate() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            checkStreamability();
            if (this.callingStoredFunction) {
                execute();
                return -1L;
            }
            setInOutParamsOnServer();
            setOutParams();
            long jExecuteLargeUpdate = super.executeLargeUpdate();
            retrieveOutParams();
            return jExecuteLargeUpdate;
        }
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public ResultSet executeQuery() throws SQLException {
        ResultSet resultSetExecuteQuery;
        synchronized (checkClosed().getConnectionMutex()) {
            checkStreamability();
            setInOutParamsOnServer();
            setOutParams();
            resultSetExecuteQuery = super.executeQuery();
            retrieveOutParams();
        }
        return resultSetExecuteQuery;
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public int executeUpdate() throws SQLException {
        return Util.truncateAndConvertToInt(executeLargeUpdate());
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002e  */
    /* JADX WARN: Code duplicated, block: B:13:0x0035  */
    /* JADX WARN: Code duplicated, block: B:7:0x0011 A[Catch: all -> 0x0068, TryCatch #0 {, blocks: (B:5:0x000b, B:17:0x0045, B:20:0x004d, B:22:0x0055, B:23:0x0059, B:25:0x005b, B:26:0x0067, B:7:0x0011, B:9:0x0017, B:12:0x0030, B:14:0x0038, B:15:0x0042), top: B:30:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:9:0x0017 A[Catch: all -> 0x0068, TryCatch #0 {, blocks: (B:5:0x000b, B:17:0x0045, B:20:0x004d, B:22:0x0055, B:23:0x0059, B:25:0x005b, B:26:0x0067, B:7:0x0011, B:9:0x0017, B:12:0x0030, B:14:0x0038, B:15:0x0042), top: B:30:0x000b }] */
    /* JADX WARN: Instruction removed from duplicated block: B:9:0x0017, please report this as an issue */
    public String fixParameterName(String str) throws SQLException {
        String strMangleParameterName;
        String str2;
        synchronized (checkClosed().getConnectionMutex()) {
            if (str != null) {
                if (str.length() == 0) {
                    if (!hasParametersView()) {
                        if ((Messages.getString("CallableStatement.0") + str) == null) {
                            str2 = "CallableStatement.15";
                        } else {
                            str2 = "CallableStatement.16";
                        }
                        throw SQLError.createSQLException(Messages.getString(str2), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                    }
                }
            } else if (!hasParametersView()) {
                if ((Messages.getString("CallableStatement.0") + str) == null) {
                    str2 = "CallableStatement.15";
                } else {
                    str2 = "CallableStatement.16";
                }
                throw SQLError.createSQLException(Messages.getString(str2), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            if (str == null && hasParametersView()) {
                str = "nullpn";
            }
            if (this.connection.getNoAccessToProcedureBodies()) {
                throw SQLError.createSQLException("No access to parameters by name when connection has been configured not to access procedure bodies", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            strMangleParameterName = mangleParameterName(str);
        }
        return strMangleParameterName;
    }

    @Override // java.sql.CallableStatement
    public Array getArray(int i) throws SQLException {
        Array array;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(i);
            array = outputParameters.getArray(mapOutputParameterIndexToRsIndex(i));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return array;
    }

    @Override // java.sql.CallableStatement
    public BigDecimal getBigDecimal(int i) throws SQLException {
        BigDecimal bigDecimal;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(i);
            bigDecimal = outputParameters.getBigDecimal(mapOutputParameterIndexToRsIndex(i));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return bigDecimal;
    }

    @Override // java.sql.CallableStatement
    public java.sql.Blob getBlob(int i) throws SQLException {
        java.sql.Blob blob;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(i);
            blob = outputParameters.getBlob(mapOutputParameterIndexToRsIndex(i));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return blob;
    }

    @Override // java.sql.CallableStatement
    public boolean getBoolean(int i) throws SQLException {
        boolean z;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(i);
            z = outputParameters.getBoolean(mapOutputParameterIndexToRsIndex(i));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return z;
    }

    @Override // java.sql.CallableStatement
    public byte getByte(int i) throws SQLException {
        byte b;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(i);
            b = outputParameters.getByte(mapOutputParameterIndexToRsIndex(i));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return b;
    }

    @Override // java.sql.CallableStatement
    public byte[] getBytes(int i) throws SQLException {
        byte[] bytes;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(i);
            bytes = outputParameters.getBytes(mapOutputParameterIndexToRsIndex(i));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return bytes;
    }

    @Override // java.sql.CallableStatement
    public java.sql.Clob getClob(int i) throws SQLException {
        java.sql.Clob clob;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(i);
            clob = outputParameters.getClob(mapOutputParameterIndexToRsIndex(i));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return clob;
    }

    @Override // java.sql.CallableStatement
    public Date getDate(int i) throws SQLException {
        Date date;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(i);
            date = outputParameters.getDate(mapOutputParameterIndexToRsIndex(i));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return date;
    }

    @Override // java.sql.CallableStatement
    public double getDouble(int i) throws SQLException {
        double d;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(i);
            d = outputParameters.getDouble(mapOutputParameterIndexToRsIndex(i));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return d;
    }

    @Override // java.sql.CallableStatement
    public float getFloat(int i) throws SQLException {
        float f;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(i);
            f = outputParameters.getFloat(mapOutputParameterIndexToRsIndex(i));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return f;
    }

    @Override // java.sql.CallableStatement
    public int getInt(int i) throws SQLException {
        int i2;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(i);
            i2 = outputParameters.getInt(mapOutputParameterIndexToRsIndex(i));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return i2;
    }

    @Override // java.sql.CallableStatement
    public long getLong(int i) throws SQLException {
        long j;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(i);
            j = outputParameters.getLong(mapOutputParameterIndexToRsIndex(i));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return j;
    }

    public int getNamedParamIndex(String str, boolean z) throws SQLException {
        CallableStatementParam parameter;
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.connection.getNoAccessToProcedureBodies()) {
                throw SQLError.createSQLException("No access to parameters by name when connection has been configured not to access procedure bodies", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            if (str == null || str.length() == 0) {
                throw SQLError.createSQLException(Messages.getString("CallableStatement.2"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            CallableStatementParamInfo callableStatementParamInfo = this.paramInfo;
            if (callableStatementParamInfo == null || (parameter = callableStatementParamInfo.getParameter(str)) == null) {
                throw SQLError.createSQLException(Messages.getString("CallableStatement.3") + str + Messages.getString("CallableStatement.4"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            if (z && !parameter.isOut) {
                throw SQLError.createSQLException(Messages.getString("CallableStatement.5") + str + Messages.getString("CallableStatement.6"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            if (this.placeholderToParameterIndexMap == null) {
                return parameter.index + 1;
            }
            int i = 0;
            while (true) {
                int[] iArr = this.placeholderToParameterIndexMap;
                if (i >= iArr.length) {
                    throw SQLError.createSQLException("Can't find local placeholder mapping for parameter named \"" + str + "\".", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                }
                if (iArr[i] == parameter.index) {
                    return i + 1;
                }
                i++;
            }
        }
    }

    @Override // java.sql.CallableStatement
    public Object getObject(int i) throws SQLException {
        Object objectStoredProc;
        synchronized (checkClosed().getConnectionMutex()) {
            CallableStatementParam callableStatementParamCheckIsOutputParam = checkIsOutputParam(i);
            ResultSetInternalMethods outputParameters = getOutputParameters(i);
            objectStoredProc = outputParameters.getObjectStoredProc(mapOutputParameterIndexToRsIndex(i), callableStatementParamCheckIsOutputParam.desiredJdbcType);
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return objectStoredProc;
    }

    public ResultSetInternalMethods getOutputParameters(int i) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            this.outputParamWasNull = false;
            if (i == 1 && this.callingStoredFunction && this.returnValueParam != null) {
                return this.functionReturnValueResults;
            }
            ResultSetInternalMethods resultSetInternalMethods = this.outputParameterResults;
            if (resultSetInternalMethods != null) {
                return resultSetInternalMethods;
            }
            if (this.paramInfo.numberOfParameters() == 0) {
                throw SQLError.createSQLException(Messages.getString("CallableStatement.7"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            throw SQLError.createSQLException(Messages.getString("CallableStatement.8"), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
        }
    }

    @Override // com.mysql.jdbc.PreparedStatement
    public int getParameterIndexOffset() {
        if (this.callingStoredFunction) {
            return -1;
        }
        return super.getParameterIndexOffset();
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public ParameterMetaData getParameterMetaData() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.placeholderToParameterIndexMap == null) {
                return this.paramInfo;
            }
            return new CallableStatementParamInfo(this.paramInfo);
        }
    }

    @Override // java.sql.CallableStatement
    public Ref getRef(int i) throws SQLException {
        Ref ref;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(i);
            ref = outputParameters.getRef(mapOutputParameterIndexToRsIndex(i));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return ref;
    }

    @Override // java.sql.CallableStatement
    public short getShort(int i) throws SQLException {
        short s;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(i);
            s = outputParameters.getShort(mapOutputParameterIndexToRsIndex(i));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return s;
    }

    @Override // java.sql.CallableStatement
    public String getString(int i) throws SQLException {
        String string;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(i);
            string = outputParameters.getString(mapOutputParameterIndexToRsIndex(i));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return string;
    }

    @Override // java.sql.CallableStatement
    public Time getTime(int i) throws SQLException {
        Time time;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(i);
            time = outputParameters.getTime(mapOutputParameterIndexToRsIndex(i));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return time;
    }

    @Override // java.sql.CallableStatement
    public Timestamp getTimestamp(int i) throws SQLException {
        Timestamp timestamp;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(i);
            timestamp = outputParameters.getTimestamp(mapOutputParameterIndexToRsIndex(i));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return timestamp;
    }

    @Override // java.sql.CallableStatement
    public URL getURL(int i) throws SQLException {
        URL url;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(i);
            url = outputParameters.getURL(mapOutputParameterIndexToRsIndex(i));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return url;
    }

    public int mapOutputParameterIndexToRsIndex(int i) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.returnValueParam != null && i == 1) {
                return 1;
            }
            checkParameterIndexBounds(i);
            int i2 = i - 1;
            int[] iArr = this.placeholderToParameterIndexMap;
            if (iArr != null) {
                i2 = iArr[i2];
            }
            int i3 = this.parameterIndexToRsIndex[i2];
            if (i3 != Integer.MIN_VALUE) {
                return i3 + 1;
            }
            throw SQLError.createSQLException(Messages.getString("CallableStatement.21") + i + Messages.getString("CallableStatement.22"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
    }

    @Override // java.sql.CallableStatement
    public void registerOutParameter(int i, int i2) throws SQLException {
        checkIsOutputParam(i).desiredJdbcType = i2;
    }

    @Override // java.sql.CallableStatement
    public void setAsciiStream(String str, InputStream inputStream, int i) throws SQLException {
        setAsciiStream(getNamedParamIndex(str, false), inputStream, i);
    }

    @Override // java.sql.CallableStatement
    public void setBigDecimal(String str, BigDecimal bigDecimal) throws SQLException {
        setBigDecimal(getNamedParamIndex(str, false), bigDecimal);
    }

    @Override // java.sql.CallableStatement
    public void setBinaryStream(String str, InputStream inputStream, int i) throws SQLException {
        setBinaryStream(getNamedParamIndex(str, false), inputStream, i);
    }

    @Override // java.sql.CallableStatement
    public void setBlob(String str, java.sql.Blob blob) throws SQLException {
        setBlob(getNamedParamIndex(str, false), blob);
    }

    @Override // java.sql.CallableStatement
    public void setBoolean(String str, boolean z) throws SQLException {
        setBoolean(getNamedParamIndex(str, false), z);
    }

    @Override // java.sql.CallableStatement
    public void setByte(String str, byte b) throws SQLException {
        setByte(getNamedParamIndex(str, false), b);
    }

    @Override // java.sql.CallableStatement
    public void setBytes(String str, byte[] bArr) throws SQLException {
        setBytes(getNamedParamIndex(str, false), bArr);
    }

    @Override // java.sql.CallableStatement
    public void setCharacterStream(String str, Reader reader, int i) throws SQLException {
        setCharacterStream(getNamedParamIndex(str, false), reader, i);
    }

    @Override // java.sql.CallableStatement
    public void setClob(String str, java.sql.Clob clob) throws SQLException {
        setClob(getNamedParamIndex(str, false), clob);
    }

    @Override // java.sql.CallableStatement
    public void setDate(String str, Date date) throws SQLException {
        setDate(getNamedParamIndex(str, false), date);
    }

    @Override // java.sql.CallableStatement
    public void setDouble(String str, double d) throws SQLException {
        setDouble(getNamedParamIndex(str, false), d);
    }

    @Override // java.sql.CallableStatement
    public void setFloat(String str, float f) throws SQLException {
        setFloat(getNamedParamIndex(str, false), f);
    }

    @Override // java.sql.CallableStatement
    public void setInt(String str, int i) throws SQLException {
        setInt(getNamedParamIndex(str, false), i);
    }

    @Override // java.sql.CallableStatement
    public void setLong(String str, long j) throws SQLException {
        setLong(getNamedParamIndex(str, false), j);
    }

    @Override // java.sql.CallableStatement
    public void setNCharacterStream(String str, Reader reader) throws SQLException {
        setNCharacterStream(getNamedParamIndex(str, false), reader);
    }

    @Override // java.sql.CallableStatement
    public void setNull(String str, int i) throws SQLException {
        setNull(getNamedParamIndex(str, false), i);
    }

    @Override // java.sql.CallableStatement
    public void setObject(String str, Object obj) throws SQLException {
        setObject(getNamedParamIndex(str, false), obj);
    }

    @Override // java.sql.CallableStatement
    public void setObject(String str, Object obj, int i, int i2) throws SQLException {
    }

    @Override // java.sql.CallableStatement
    public void setShort(String str, short s) throws SQLException {
        setShort(getNamedParamIndex(str, false), s);
    }

    @Override // java.sql.CallableStatement
    public void setString(String str, String str2) throws SQLException {
        setString(getNamedParamIndex(str, false), str2);
    }

    @Override // java.sql.CallableStatement
    public void setTime(String str, Time time) throws SQLException {
        setTime(getNamedParamIndex(str, false), time);
    }

    @Override // java.sql.CallableStatement
    public void setTimestamp(String str, Timestamp timestamp) throws SQLException {
        setTimestamp(getNamedParamIndex(str, false), timestamp);
    }

    @Override // java.sql.CallableStatement
    public void setURL(String str, URL url) throws SQLException {
        setURL(getNamedParamIndex(str, false), url);
    }

    @Override // java.sql.CallableStatement
    public boolean wasNull() throws SQLException {
        boolean z;
        synchronized (checkClosed().getConnectionMutex()) {
            z = this.outputParamWasNull;
        }
        return z;
    }

    @Override // java.sql.CallableStatement
    public void setAsciiStream(String str, InputStream inputStream) throws SQLException {
        setAsciiStream(getNamedParamIndex(str, false), inputStream);
    }

    @Override // java.sql.CallableStatement
    public void setBinaryStream(String str, InputStream inputStream) throws SQLException {
        setBinaryStream(getNamedParamIndex(str, false), inputStream);
    }

    @Override // java.sql.CallableStatement
    public void setBlob(String str, InputStream inputStream) throws SQLException {
        setBlob(getNamedParamIndex(str, false), inputStream);
    }

    @Override // java.sql.CallableStatement
    public void setCharacterStream(String str, Reader reader) throws SQLException {
        setCharacterStream(getNamedParamIndex(str, false), reader);
    }

    @Override // java.sql.CallableStatement
    public void setClob(String str, Reader reader) throws SQLException {
        setClob(getNamedParamIndex(str, false), reader);
    }

    @Override // java.sql.CallableStatement
    public void setDate(String str, Date date, Calendar calendar) throws SQLException {
        setDate(getNamedParamIndex(str, false), date, calendar);
    }

    @Override // java.sql.CallableStatement
    public void setNCharacterStream(String str, Reader reader, long j) throws SQLException {
        setNCharacterStream(getNamedParamIndex(str, false), reader, j);
    }

    @Override // java.sql.CallableStatement
    public void setNull(String str, int i, String str2) throws SQLException {
        setNull(getNamedParamIndex(str, false), i, str2);
    }

    @Override // java.sql.CallableStatement
    public void setObject(String str, Object obj, int i) throws SQLException {
        setObject(getNamedParamIndex(str, false), obj, i);
    }

    @Override // java.sql.CallableStatement
    public void setTime(String str, Time time, Calendar calendar) throws SQLException {
        setTime(getNamedParamIndex(str, false), time, calendar);
    }

    @Override // java.sql.CallableStatement
    public void setTimestamp(String str, Timestamp timestamp, Calendar calendar) throws SQLException {
        setTimestamp(getNamedParamIndex(str, false), timestamp, calendar);
    }

    @Override // java.sql.CallableStatement
    public void registerOutParameter(int i, int i2, int i3) throws SQLException {
        registerOutParameter(i, i2);
    }

    @Override // java.sql.CallableStatement
    public void setAsciiStream(String str, InputStream inputStream, long j) throws SQLException {
        setAsciiStream(getNamedParamIndex(str, false), inputStream, j);
    }

    @Override // java.sql.CallableStatement
    public void setBinaryStream(String str, InputStream inputStream, long j) throws SQLException {
        setBinaryStream(getNamedParamIndex(str, false), inputStream, j);
    }

    @Override // java.sql.CallableStatement
    public void setBlob(String str, InputStream inputStream, long j) throws SQLException {
        setBlob(getNamedParamIndex(str, false), inputStream, j);
    }

    @Override // java.sql.CallableStatement
    public void setCharacterStream(String str, Reader reader, long j) throws SQLException {
        setCharacterStream(getNamedParamIndex(str, false), reader, j);
    }

    @Override // java.sql.CallableStatement
    public void setClob(String str, Reader reader, long j) throws SQLException {
        setClob(getNamedParamIndex(str, false), reader, j);
    }

    public static CallableStatement getInstance(MySQLConnection mySQLConnection, CallableStatementParamInfo callableStatementParamInfo) throws SQLException {
        return !Util.isJdbc4() ? new CallableStatement(mySQLConnection, callableStatementParamInfo) : (CallableStatement) Util.handleNewInstance(JDBC_4_CSTMT_2_ARGS_CTOR, new Object[]{mySQLConnection, callableStatementParamInfo}, mySQLConnection.getExceptionInterceptor());
    }

    @Override // java.sql.CallableStatement
    public void registerOutParameter(int i, int i2, String str) throws SQLException {
        checkIsOutputParam(i);
    }

    @Override // java.sql.CallableStatement
    public void registerOutParameter(String str, int i) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            registerOutParameter(getNamedParamIndex(str, true), i);
        }
    }

    @Override // java.sql.CallableStatement
    public Array getArray(String str) throws SQLException {
        Array array;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(0);
            array = outputParameters.getArray(fixParameterName(str));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return array;
    }

    @Override // java.sql.CallableStatement
    @Deprecated
    public BigDecimal getBigDecimal(int i, int i2) throws SQLException {
        BigDecimal bigDecimal;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(i);
            bigDecimal = outputParameters.getBigDecimal(mapOutputParameterIndexToRsIndex(i), i2);
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return bigDecimal;
    }

    @Override // java.sql.CallableStatement
    public java.sql.Blob getBlob(String str) throws SQLException {
        java.sql.Blob blob;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(0);
            blob = outputParameters.getBlob(fixParameterName(str));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return blob;
    }

    @Override // java.sql.CallableStatement
    public boolean getBoolean(String str) throws SQLException {
        boolean z;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(0);
            z = outputParameters.getBoolean(fixParameterName(str));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return z;
    }

    @Override // java.sql.CallableStatement
    public byte getByte(String str) throws SQLException {
        byte b;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(0);
            b = outputParameters.getByte(fixParameterName(str));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return b;
    }

    @Override // java.sql.CallableStatement
    public byte[] getBytes(String str) throws SQLException {
        byte[] bytes;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(0);
            bytes = outputParameters.getBytes(fixParameterName(str));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return bytes;
    }

    @Override // java.sql.CallableStatement
    public java.sql.Clob getClob(String str) throws SQLException {
        java.sql.Clob clob;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(0);
            clob = outputParameters.getClob(fixParameterName(str));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return clob;
    }

    @Override // java.sql.CallableStatement
    public Date getDate(int i, Calendar calendar) throws SQLException {
        Date date;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(i);
            date = outputParameters.getDate(mapOutputParameterIndexToRsIndex(i), calendar);
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return date;
    }

    @Override // java.sql.CallableStatement
    public double getDouble(String str) throws SQLException {
        double d;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(0);
            d = outputParameters.getDouble(fixParameterName(str));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return d;
    }

    @Override // java.sql.CallableStatement
    public float getFloat(String str) throws SQLException {
        float f;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(0);
            f = outputParameters.getFloat(fixParameterName(str));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return f;
    }

    @Override // java.sql.CallableStatement
    public int getInt(String str) throws SQLException {
        int i;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(0);
            i = outputParameters.getInt(fixParameterName(str));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return i;
    }

    @Override // java.sql.CallableStatement
    public long getLong(String str) throws SQLException {
        long j;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(0);
            j = outputParameters.getLong(fixParameterName(str));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return j;
    }

    @Override // java.sql.CallableStatement
    public Ref getRef(String str) throws SQLException {
        Ref ref;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(0);
            ref = outputParameters.getRef(fixParameterName(str));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return ref;
    }

    @Override // java.sql.CallableStatement
    public short getShort(String str) throws SQLException {
        short s;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(0);
            s = outputParameters.getShort(fixParameterName(str));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return s;
    }

    @Override // java.sql.CallableStatement
    public String getString(String str) throws SQLException {
        String string;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(0);
            string = outputParameters.getString(fixParameterName(str));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return string;
    }

    @Override // java.sql.CallableStatement
    public Time getTime(int i, Calendar calendar) throws SQLException {
        Time time;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(i);
            time = outputParameters.getTime(mapOutputParameterIndexToRsIndex(i), calendar);
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return time;
    }

    @Override // java.sql.CallableStatement
    public Timestamp getTimestamp(int i, Calendar calendar) throws SQLException {
        Timestamp timestamp;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(i);
            timestamp = outputParameters.getTimestamp(mapOutputParameterIndexToRsIndex(i), calendar);
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return timestamp;
    }

    @Override // java.sql.CallableStatement
    public URL getURL(String str) throws SQLException {
        URL url;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(0);
            url = outputParameters.getURL(fixParameterName(str));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return url;
    }

    @Override // java.sql.CallableStatement
    public Object getObject(int i, Map<String, Class<?>> map) throws SQLException {
        Object object;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(i);
            object = outputParameters.getObject(mapOutputParameterIndexToRsIndex(i), map);
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return object;
    }

    @Override // java.sql.CallableStatement
    public void registerOutParameter(String str, int i, int i2) throws SQLException {
        registerOutParameter(getNamedParamIndex(str, true), i);
    }

    public CallableStatement(MySQLConnection mySQLConnection, String str, String str2, boolean z) throws SQLException {
        super(mySQLConnection, str, str2);
        this.callingStoredFunction = false;
        this.hasOutputParams = false;
        this.outputParamWasNull = false;
        this.callingStoredFunction = z;
        if (!z) {
            if (!StringUtils.startsWithIgnoreCaseAndWs(str, "CALL")) {
                fakeParameterTypes(false);
            } else {
                determineParameterTypes();
            }
            generateParameterMap();
        } else {
            determineParameterTypes();
            generateParameterMap();
            this.parameterCount++;
        }
        this.retrieveGeneratedKeys = true;
    }

    @Override // java.sql.CallableStatement
    public void registerOutParameter(String str, int i, String str2) throws SQLException {
        registerOutParameter(getNamedParamIndex(str, true), i, str2);
    }

    @Override // java.sql.CallableStatement
    public BigDecimal getBigDecimal(String str) throws SQLException {
        BigDecimal bigDecimal;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(0);
            bigDecimal = outputParameters.getBigDecimal(fixParameterName(str));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return bigDecimal;
    }

    @Override // java.sql.CallableStatement
    public Date getDate(String str) throws SQLException {
        Date date;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(0);
            date = outputParameters.getDate(fixParameterName(str));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return date;
    }

    @Override // java.sql.CallableStatement
    public Time getTime(String str) throws SQLException {
        Time time;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(0);
            time = outputParameters.getTime(fixParameterName(str));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return time;
    }

    @Override // java.sql.CallableStatement
    public Timestamp getTimestamp(String str) throws SQLException {
        Timestamp timestamp;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(0);
            timestamp = outputParameters.getTimestamp(fixParameterName(str));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return timestamp;
    }

    @Override // java.sql.CallableStatement
    public Object getObject(String str) throws SQLException {
        Object object;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(0);
            object = outputParameters.getObject(fixParameterName(str));
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return object;
    }

    @Override // java.sql.CallableStatement
    public Date getDate(String str, Calendar calendar) throws SQLException {
        Date date;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(0);
            date = outputParameters.getDate(fixParameterName(str), calendar);
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return date;
    }

    @Override // java.sql.CallableStatement
    public Time getTime(String str, Calendar calendar) throws SQLException {
        Time time;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(0);
            time = outputParameters.getTime(fixParameterName(str), calendar);
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return time;
    }

    @Override // java.sql.CallableStatement
    public Timestamp getTimestamp(String str, Calendar calendar) throws SQLException {
        Timestamp timestamp;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(0);
            timestamp = outputParameters.getTimestamp(fixParameterName(str), calendar);
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return timestamp;
    }

    @Override // java.sql.CallableStatement
    public Object getObject(String str, Map<String, Class<?>> map) throws SQLException {
        Object object;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(0);
            object = outputParameters.getObject(fixParameterName(str), map);
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return object;
    }

    public <T> T getObject(int i, Class<T> cls) throws SQLException {
        T t;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(i);
            t = (T) ((ResultSetImpl) outputParameters).getObject(mapOutputParameterIndexToRsIndex(i), cls);
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return t;
    }

    public <T> T getObject(String str, Class<T> cls) throws SQLException {
        T t;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods outputParameters = getOutputParameters(0);
            t = (T) ((ResultSetImpl) outputParameters).getObject(fixParameterName(str), cls);
            this.outputParamWasNull = outputParameters.wasNull();
        }
        return t;
    }
}
