package com.mysql.jdbc;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.log.Log;
import com.mysql.jdbc.log.LogFactory;
import com.mysql.jdbc.log.LogUtils;
import com.mysql.jdbc.log.NullLogger;
import com.mysql.jdbc.profiler.ProfilerEvent;
import com.mysql.jdbc.profiler.ProfilerEventHandler;
import com.mysql.jdbc.util.LRUCache;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.UnsupportedCharsetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLPermission;
import java.sql.SQLWarning;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Stack;
import java.util.TimeZone;
import java.util.Timer;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.http2.Settings;

/* JADX INFO: loaded from: classes.dex */
public class ConnectionImpl extends ConnectionPropertiesImpl implements MySQLConnection {
    public static final String DEFAULT_LOGGER_CLASS = "com.mysql.jdbc.log.StandardLogger";
    private static final int DEFAULT_RESULT_SET_CONCURRENCY = 1007;
    private static final int DEFAULT_RESULT_SET_TYPE = 1003;
    private static final int HISTOGRAM_BUCKETS = 20;
    private static final Constructor<?> JDBC_4_CONNECTION_CTOR;
    public static final String JDBC_LOCAL_CHARACTER_SET_RESULTS = "jdbc.local.character_set_results";
    private static final String SERVER_VERSION_STRING_VAR_NAME = "server_version_string";
    public static Map<?, ?> charsetMap = null;
    private static Map<String, Integer> mapTransIsolationNameToValue = null;
    private static final Random random;
    public static Map<?, ?> roundRobinStatsMap = null;
    private static final long serialVersionUID = 2877471301981509474L;
    private boolean autoCommit;
    private int autoIncrementIncrement;
    private CacheAdapter<String, PreparedStatement.ParseInfo> cachedPreparedStatementParams;
    private transient Timer cancelTimer;
    private String characterSetMetadata;
    private String characterSetResultsOnServer;
    private final Map<String, Object> charsetConverterMap;
    private long connectionCreationTimeMillis;
    private long connectionId;
    private List<Extension> connectionLifecycleInterceptors;
    private String database;
    private java.sql.DatabaseMetaData dbmd;
    private TimeZone defaultTimeZone;
    private String errorMessageEncoding;
    private ProfilerEventHandler eventSink;
    private ExceptionInterceptor exceptionInterceptor;
    private Throwable forceClosedReason;
    private boolean hasIsolationLevels;
    private boolean hasQuotedIdentifiers;
    private boolean hasTriedMasterFlag;
    private String host;
    private String hostPortPair;
    public Map<Integer, String> indexToCustomMysqlCharset;

    /* JADX INFO: renamed from: io */
    private transient MysqlIO f79io;
    private boolean isClientTzUTC;
    private boolean isClosed;
    private boolean isInGlobalTx;
    private boolean isRunningOnJDK13;
    private boolean isServerTzUTC;
    private int isolationLevel;
    private long lastQueryFinishedTime;
    private transient Log log;
    private long longestQueryTimeMs;
    private boolean lowerCaseTableNames;
    private long maximumNumberTablesAccessed;
    private long metricsLastReportedMs;
    private long minimumNumberTablesAccessed;
    private String myURL;
    private Map<String, Integer> mysqlCharsetToCustomMblen;
    private boolean needsPing;
    private int netBufferLength;
    private boolean noBackslashEscapes;
    private long[] numTablesMetricsHistBreakpoints;
    private int[] numTablesMetricsHistCounts;
    private long numberOfPreparedExecutes;
    private long numberOfPrepares;
    private long numberOfQueriesIssued;
    private long numberOfResultSetsCreated;
    private long[] oldHistBreakpoints;
    private int[] oldHistCounts;
    private final CopyOnWriteArrayList<Statement> openStatements;
    private String origDatabaseToConnectTo;
    private String origHostToConnectTo;
    private int origPortToConnectTo;
    private LRUCache<CompoundCacheKey, CallableStatement.CallableStatementParamInfo> parsedCallableStatementCache;
    private boolean parserKnowsUnicode;
    private String password;
    private long[] perfMetricsHistBreakpoints;
    private int[] perfMetricsHistCounts;
    private String pointOfOrigin;
    private int port;
    public Properties props;
    private MySQLConnection proxy;
    private long queryTimeCount;
    private double queryTimeMean;
    private double queryTimeSum;
    private double queryTimeSumSquares;
    private boolean readInfoMsg;
    private boolean readOnly;
    private InvocationHandler realProxy;
    private boolean requiresEscapingEncoder;
    public LRUCache<String, CachedResultSetMetaData> resultSetMetadataCache;
    private CacheAdapter<String, Map<String, String>> serverConfigCache;
    private LRUCache<CompoundCacheKey, ServerPreparedStatement> serverSideStatementCache;
    private LRUCache<String, Boolean> serverSideStatementCheckCache;
    private TimeZone serverTimezoneTZ;
    private boolean serverTruncatesFracSecs;
    private Map<String, String> serverVariables;
    private Calendar sessionCalendar;
    private int sessionMaxRows;
    private long shortestQueryTimeMs;
    private String statementComment;
    private List<StatementInterceptorV2> statementInterceptors;
    private boolean storesLowerCaseTableName;
    private double totalQueryTimeMs;
    private boolean transactionsSupported;
    private Map<String, Class<?>> typeMap;
    private boolean useAnsiQuotes;
    private boolean usePlatformCharsetConverters;
    private boolean useServerPreparedStmts;
    private String user;
    private Calendar utcCalendar;
    private static final SQLPermission SET_NETWORK_TIMEOUT_PERM = new SQLPermission("setNetworkTimeout");
    private static final SQLPermission ABORT_PERM = new SQLPermission("abort");
    private static final Object CHARSET_CONVERTER_NOT_AVAILABLE_MARKER = new Object();
    private static final String LOGGER_INSTANCE_NAME = "MySQL";
    private static final Log NULL_LOGGER = new NullLogger(LOGGER_INSTANCE_NAME);
    private static final Map<String, Map<Integer, String>> customIndexToCharsetMapByUrl = new HashMap();
    private static final Map<String, Map<String, Integer>> customCharsetToMblenMapByUrl = new HashMap();

    public static class CompoundCacheKey {
        public final String componentOne;
        public final String componentTwo;
        public final int hashCode;

        public CompoundCacheKey(String str, String str2) {
            this.componentOne = str;
            this.componentTwo = str2;
            this.hashCode = ((527 + (str != null ? str.hashCode() : 0)) * 31) + (str2 != null ? str2.hashCode() : 0);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && CompoundCacheKey.class.isAssignableFrom(obj.getClass())) {
                CompoundCacheKey compoundCacheKey = (CompoundCacheKey) obj;
                String str = this.componentOne;
                if (str != null ? str.equals(compoundCacheKey.componentOne) : compoundCacheKey.componentOne == null) {
                    String str2 = this.componentTwo;
                    String str3 = compoundCacheKey.componentTwo;
                    if (str2 == null) {
                        return str3 == null;
                    }
                    return str2.equals(str3);
                }
            }
            return false;
        }

        public int hashCode() {
            return this.hashCode;
        }
    }

    public class ExceptionInterceptorChain implements ExceptionInterceptor {
        private List<Extension> interceptors;

        public ExceptionInterceptorChain(String str) throws SQLException {
            this.interceptors = Util.loadExtensions(ConnectionImpl.this, ConnectionImpl.this.props, str, "Connection.BadExceptionInterceptor", this);
        }

        public void addRingZero(ExceptionInterceptor exceptionInterceptor) throws SQLException {
            this.interceptors.add(0, exceptionInterceptor);
        }

        @Override // com.mysql.jdbc.Extension
        public void destroy() {
            List<Extension> list = this.interceptors;
            if (list != null) {
                Iterator<Extension> it = list.iterator();
                while (it.hasNext()) {
                    ((ExceptionInterceptor) it.next()).destroy();
                }
            }
        }

        public List<Extension> getInterceptors() {
            return this.interceptors;
        }

        @Override // com.mysql.jdbc.Extension
        public void init(Connection connection, Properties properties) throws SQLException {
            List<Extension> list = this.interceptors;
            if (list != null) {
                Iterator<Extension> it = list.iterator();
                while (it.hasNext()) {
                    ((ExceptionInterceptor) it.next()).init(connection, properties);
                }
            }
        }

        @Override // com.mysql.jdbc.ExceptionInterceptor
        public SQLException interceptException(SQLException sQLException, Connection connection) {
            List<Extension> list = this.interceptors;
            if (list != null) {
                Iterator<Extension> it = list.iterator();
                while (it.hasNext()) {
                    sQLException = ((ExceptionInterceptor) it.next()).interceptException(sQLException, ConnectionImpl.this);
                }
            }
            return sQLException;
        }
    }

    public static class NetworkTimeoutSetter implements Runnable {
        private final WeakReference<ConnectionImpl> connImplRef;
        private final int milliseconds;
        private final WeakReference<MysqlIO> mysqlIoRef;

        public NetworkTimeoutSetter(ConnectionImpl connectionImpl, MysqlIO mysqlIO, int i) {
            this.connImplRef = new WeakReference<>(connectionImpl);
            this.mysqlIoRef = new WeakReference<>(mysqlIO);
            this.milliseconds = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ConnectionImpl connectionImpl = this.connImplRef.get();
                if (connectionImpl != null) {
                    synchronized (connectionImpl.getConnectionMutex()) {
                        try {
                            connectionImpl.setSocketTimeout(this.milliseconds);
                            MysqlIO mysqlIO = this.mysqlIoRef.get();
                            if (mysqlIO != null) {
                                mysqlIO.setSocketTimeout(this.milliseconds);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static {
        mapTransIsolationNameToValue = null;
        HashMap map = new HashMap(8);
        mapTransIsolationNameToValue = map;
        map.put("READ-UNCOMMITED", 1);
        mapTransIsolationNameToValue.put("READ-UNCOMMITTED", 1);
        mapTransIsolationNameToValue.put("READ-COMMITTED", 2);
        mapTransIsolationNameToValue.put("REPEATABLE-READ", 4);
        mapTransIsolationNameToValue.put("SERIALIZABLE", 8);
        if (Util.isJdbc4()) {
            try {
                JDBC_4_CONNECTION_CTOR = Class.forName("com.mysql.jdbc.JDBC4Connection").getConstructor(String.class, Integer.TYPE, Properties.class, String.class, String.class);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException(e2);
            } catch (SecurityException e3) {
                throw new RuntimeException(e3);
            }
        } else {
            JDBC_4_CONNECTION_CTOR = null;
        }
        random = new Random();
    }

    public ConnectionImpl() {
        this.proxy = null;
        this.realProxy = null;
        this.autoCommit = true;
        this.characterSetMetadata = null;
        this.characterSetResultsOnServer = null;
        this.charsetConverterMap = new HashMap(CharsetMapping.getNumberOfCharsetsConfigured());
        this.connectionCreationTimeMillis = 0L;
        this.database = null;
        this.dbmd = null;
        this.hasIsolationLevels = false;
        this.hasQuotedIdentifiers = false;
        this.host = null;
        this.indexToCustomMysqlCharset = null;
        this.mysqlCharsetToCustomMblen = null;
        this.f79io = null;
        this.isClientTzUTC = false;
        this.isClosed = true;
        this.isInGlobalTx = false;
        this.isRunningOnJDK13 = false;
        this.isolationLevel = 2;
        this.isServerTzUTC = false;
        this.lastQueryFinishedTime = 0L;
        this.log = NULL_LOGGER;
        this.longestQueryTimeMs = 0L;
        this.lowerCaseTableNames = false;
        this.maximumNumberTablesAccessed = 0L;
        this.sessionMaxRows = -1;
        this.minimumNumberTablesAccessed = RecyclerView.FOREVER_NS;
        this.myURL = null;
        this.needsPing = false;
        this.netBufferLength = 16384;
        this.noBackslashEscapes = false;
        this.serverTruncatesFracSecs = false;
        this.numberOfPreparedExecutes = 0L;
        this.numberOfPrepares = 0L;
        this.numberOfQueriesIssued = 0L;
        this.numberOfResultSetsCreated = 0L;
        this.oldHistBreakpoints = null;
        this.oldHistCounts = null;
        this.openStatements = new CopyOnWriteArrayList<>();
        this.parserKnowsUnicode = false;
        this.password = null;
        this.port = 3306;
        this.props = null;
        this.readInfoMsg = false;
        this.readOnly = false;
        this.serverTimezoneTZ = null;
        this.serverVariables = null;
        this.shortestQueryTimeMs = RecyclerView.FOREVER_NS;
        this.totalQueryTimeMs = 0.0d;
        this.transactionsSupported = false;
        this.useAnsiQuotes = false;
        this.user = null;
        this.useServerPreparedStmts = false;
        this.errorMessageEncoding = "Cp1252";
        this.hasTriedMasterFlag = false;
        this.statementComment = null;
        this.autoIncrementIncrement = 0;
    }

    private void addToHistogram(int[] iArr, long[] jArr, long j, int i, long j2, long j3) {
        if (iArr == null) {
            createInitialHistogram(jArr, j2, j3);
            return;
        }
        for (int i2 = 0; i2 < 20; i2++) {
            if (jArr[i2] >= j) {
                iArr[i2] = iArr[i2] + i;
                return;
            }
        }
    }

    private void addToPerformanceHistogram(long j, int i) {
        checkAndCreatePerformanceHistogram();
        int[] iArr = this.perfMetricsHistCounts;
        long[] jArr = this.perfMetricsHistBreakpoints;
        long j2 = this.shortestQueryTimeMs;
        if (j2 == RecyclerView.FOREVER_NS) {
            j2 = 0;
        }
        addToHistogram(iArr, jArr, j, i, j2, this.longestQueryTimeMs);
    }

    private void addToTablesAccessedHistogram(long j, int i) {
        checkAndCreateTablesAccessedHistogram();
        int[] iArr = this.numTablesMetricsHistCounts;
        long[] jArr = this.numTablesMetricsHistBreakpoints;
        long j2 = this.minimumNumberTablesAccessed;
        if (j2 == RecyclerView.FOREVER_NS) {
            j2 = 0;
        }
        addToHistogram(iArr, jArr, j, i, j2, this.maximumNumberTablesAccessed);
    }

    public static SQLException appendMessageToException(SQLException sQLException, String str, ExceptionInterceptor exceptionInterceptor) {
        String message = sQLException.getMessage();
        String sQLState = sQLException.getSQLState();
        int errorCode = sQLException.getErrorCode();
        StringBuilder sb = new StringBuilder(message.length() + str.length());
        sb.append(message);
        sb.append(str);
        SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(sb.toString(), sQLState, errorCode, exceptionInterceptor);
        try {
            Class<?> cls = Array.newInstance(Class.forName("java.lang.StackTraceElement"), 0).getClass();
            Method method = Throwable.class.getMethod("getStackTrace", new Class[0]);
            Method method2 = Throwable.class.getMethod("setStackTrace", cls);
            if (method != null && method2 != null) {
                method2.invoke(sQLExceptionCreateSQLException, method.invoke(sQLException, new Object[0]));
            }
        } catch (Throwable unused) {
        }
        return sQLExceptionCreateSQLException;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.sql.Statement] */
    /* JADX WARN: Type inference failed for: r0v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.sql.Statement] */
    /* JADX WARN: Type inference failed for: r0v8 */
    private void buildCollationMapping() throws Throwable {
        Map<Integer, String> map;
        Map<String, Integer> map2;
        ResultSet resultSetExecuteQuery;
        if (getCacheServerConfiguration()) {
            Map<String, Map<Integer, String>> map3 = customIndexToCharsetMapByUrl;
            synchronized (map3) {
                map = map3.get(getURL());
                map2 = customCharsetToMblenMapByUrl.get(getURL());
            }
        } else {
            map = null;
            map2 = null;
        }
        if (map == null && getDetectCustomCollations()) {
            ResultSet resultSet = null;
            ?? VersionMeetsMinimum = versionMeetsMinimum(4, 1, 0);
            try {
                if (VersionMeetsMinimum != 0) {
                    try {
                        map = new HashMap<>();
                        map2 = new HashMap<>();
                        VersionMeetsMinimum = getMetadataSafeStatement();
                        try {
                            try {
                                resultSetExecuteQuery = VersionMeetsMinimum.executeQuery("SHOW COLLATION");
                                while (resultSetExecuteQuery.next()) {
                                    try {
                                        int iIntValue = ((Number) resultSetExecuteQuery.getObject(3)).intValue();
                                        String string = resultSetExecuteQuery.getString(2);
                                        if (iIntValue >= 2048 || !string.equals(CharsetMapping.getMysqlCharsetNameForCollationIndex(Integer.valueOf(iIntValue)))) {
                                            map.put(Integer.valueOf(iIntValue), string);
                                        }
                                        if (!CharsetMapping.CHARSET_NAME_TO_CHARSET.containsKey(string)) {
                                            map2.put(string, null);
                                        }
                                    } catch (SQLException e) {
                                        e = e;
                                        try {
                                            if (e.getErrorCode() != 1820 || getDisconnectOnExpiredPasswords()) {
                                                throw e;
                                            }
                                        } catch (SQLException e2) {
                                            throw e2;
                                        }
                                    }
                                }
                            } catch (RuntimeException e3) {
                                e = e3;
                                SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(e.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
                                sQLExceptionCreateSQLException.initCause(e);
                                throw sQLExceptionCreateSQLException;
                            } catch (SQLException e4) {
                                e = e4;
                                resultSetExecuteQuery = null;
                            } catch (Throwable th) {
                                resultSet = null;
                                th = th;
                                if (resultSet != null) {
                                    try {
                                        resultSet.close();
                                    } catch (SQLException unused) {
                                    }
                                }
                                if (VersionMeetsMinimum == 0) {
                                    throw th;
                                }
                                try {
                                    VersionMeetsMinimum.close();
                                    throw th;
                                } catch (SQLException unused2) {
                                    throw th;
                                }
                            }
                            if (map2.size() > 0) {
                                try {
                                    resultSetExecuteQuery = VersionMeetsMinimum.executeQuery("SHOW CHARACTER SET");
                                    while (resultSetExecuteQuery.next()) {
                                        String string2 = resultSetExecuteQuery.getString("Charset");
                                        if (map2.containsKey(string2)) {
                                            map2.put(string2, Integer.valueOf(resultSetExecuteQuery.getInt("Maxlen")));
                                        }
                                    }
                                } catch (SQLException e5) {
                                    if (e5.getErrorCode() != 1820 || getDisconnectOnExpiredPasswords()) {
                                        throw e5;
                                    }
                                }
                            }
                            if (getCacheServerConfiguration()) {
                                Map<String, Map<Integer, String>> map4 = customIndexToCharsetMapByUrl;
                                synchronized (map4) {
                                    map4.put(getURL(), map);
                                    customCharsetToMblenMapByUrl.put(getURL(), map2);
                                }
                            }
                            if (resultSetExecuteQuery != null) {
                                try {
                                    resultSetExecuteQuery.close();
                                } catch (SQLException unused3) {
                                }
                            }
                            if (VersionMeetsMinimum != 0) {
                                try {
                                    VersionMeetsMinimum.close();
                                } catch (SQLException unused4) {
                                }
                            }
                        } catch (RuntimeException e6) {
                            e = e6;
                            SQLException sQLExceptionCreateSQLException2 = SQLError.createSQLException(e.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
                            sQLExceptionCreateSQLException2.initCause(e);
                            throw sQLExceptionCreateSQLException2;
                        }
                    } catch (RuntimeException e7) {
                        e = e7;
                    } catch (SQLException e8) {
                        throw e8;
                    } catch (Throwable th2) {
                        resultSet = null;
                        th = th2;
                        VersionMeetsMinimum = 0;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        if (map != null) {
            this.indexToCustomMysqlCharset = Collections.unmodifiableMap(map);
        }
        if (map2 != null) {
            this.mysqlCharsetToCustomMblen = Collections.unmodifiableMap(map2);
        }
    }

    private boolean canHandleAsServerPreparedStatement(String str) throws SQLException {
        if (str == null || str.length() == 0) {
            return true;
        }
        if (!this.useServerPreparedStmts) {
            return false;
        }
        if (!getCachePreparedStatements()) {
            return canHandleAsServerPreparedStatementNoCache(str);
        }
        synchronized (this.serverSideStatementCheckCache) {
            Boolean bool = this.serverSideStatementCheckCache.get(str);
            if (bool != null) {
                return bool.booleanValue();
            }
            boolean zCanHandleAsServerPreparedStatementNoCache = canHandleAsServerPreparedStatementNoCache(str);
            if (str.length() < getPreparedStatementCacheSqlLimit()) {
                this.serverSideStatementCheckCache.put(str, zCanHandleAsServerPreparedStatementNoCache ? Boolean.TRUE : Boolean.FALSE);
            }
            return zCanHandleAsServerPreparedStatementNoCache;
        }
    }

    private boolean canHandleAsServerPreparedStatementNoCache(String str) throws SQLException {
        boolean z = false;
        if (StringUtils.startsWithIgnoreCaseAndNonAlphaNumeric(str, "CALL")) {
            return false;
        }
        boolean z2 = !this.noBackslashEscapes;
        String str2 = this.useAnsiQuotes ? "\"" : "'";
        if (getAllowMultiQueries()) {
            if (StringUtils.indexOfIgnoreCase(0, str, ";", str2, str2, z2 ? StringUtils.SEARCH_MODE__ALL : StringUtils.SEARCH_MODE__MRK_COM_WS) != -1) {
                return false;
            }
        } else {
            if (!versionMeetsMinimum(5, 0, 7) && (StringUtils.startsWithIgnoreCaseAndNonAlphaNumeric(str, "SELECT") || StringUtils.startsWithIgnoreCaseAndNonAlphaNumeric(str, "DELETE") || StringUtils.startsWithIgnoreCaseAndNonAlphaNumeric(str, "INSERT") || StringUtils.startsWithIgnoreCaseAndNonAlphaNumeric(str, "UPDATE") || StringUtils.startsWithIgnoreCaseAndNonAlphaNumeric(str, "REPLACE"))) {
                int length = str.length();
                int i = length - 7;
                int i2 = 0;
                while (i2 < i) {
                    int iIndexOfIgnoreCase = StringUtils.indexOfIgnoreCase(i2, str, "LIMIT ", str2, str2, z2 ? StringUtils.SEARCH_MODE__ALL : StringUtils.SEARCH_MODE__MRK_COM_WS);
                    if (iIndexOfIgnoreCase != -1) {
                        i2 = iIndexOfIgnoreCase + 7;
                        while (i2 < length) {
                            char cCharAt = str.charAt(i2);
                            if (!Character.isDigit(cCharAt) && !Character.isWhitespace(cCharAt) && cCharAt != ',' && cCharAt != '?') {
                                break;
                            }
                            if (cCharAt == '?') {
                                z = true;
                                break;
                            }
                            i2++;
                        }
                    } else {
                        break;
                    }
                }
                return !z;
            }
            if (StringUtils.startsWithIgnoreCaseAndWs(str, "XA ") || StringUtils.startsWithIgnoreCaseAndWs(str, "CREATE TABLE") || StringUtils.startsWithIgnoreCaseAndWs(str, "DO") || StringUtils.startsWithIgnoreCaseAndWs(str, "SET")) {
                return false;
            }
            if ((StringUtils.startsWithIgnoreCaseAndWs(str, "SHOW WARNINGS") && versionMeetsMinimum(5, 7, 2)) || str.startsWith(StatementImpl.PING_MARKER)) {
                return false;
            }
        }
        return true;
    }

    private boolean characterSetNamesMatches(String str) {
        return str != null && str.equalsIgnoreCase(this.serverVariables.get("character_set_client")) && str.equalsIgnoreCase(this.serverVariables.get("character_set_connection"));
    }

    private void checkAndCreatePerformanceHistogram() {
        if (this.perfMetricsHistCounts == null) {
            this.perfMetricsHistCounts = new int[20];
        }
        if (this.perfMetricsHistBreakpoints == null) {
            this.perfMetricsHistBreakpoints = new long[20];
        }
    }

    private void checkAndCreateTablesAccessedHistogram() {
        if (this.numTablesMetricsHistCounts == null) {
            this.numTablesMetricsHistCounts = new int[20];
        }
        if (this.numTablesMetricsHistBreakpoints == null) {
            this.numTablesMetricsHistBreakpoints = new long[20];
        }
    }

    private void checkServerEncoding() throws SQLException {
        if (!getUseUnicode() || getEncoding() == null) {
            String str = this.serverVariables.get("character_set");
            if (str == null) {
                str = this.serverVariables.get("character_set_server");
            }
            String javaEncodingForMysqlCharset = null;
            if (str != null) {
                try {
                    javaEncodingForMysqlCharset = CharsetMapping.getJavaEncodingForMysqlCharset(str);
                } catch (RuntimeException e) {
                    SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(e.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
                    sQLExceptionCreateSQLException.initCause(e);
                    throw sQLExceptionCreateSQLException;
                }
            }
            if (!getUseUnicode() && javaEncodingForMysqlCharset != null && getCharsetConverter(javaEncodingForMysqlCharset) != null) {
                setUseUnicode(true);
                setEncoding(javaEncodingForMysqlCharset);
                return;
            }
            if (str != null) {
                if (javaEncodingForMysqlCharset == null && Character.isLowerCase(str.charAt(0))) {
                    char[] charArray = str.toCharArray();
                    charArray[0] = Character.toUpperCase(str.charAt(0));
                    setEncoding(new String(charArray));
                }
                if (javaEncodingForMysqlCharset == null) {
                    throw SQLError.createSQLException("Unknown character encoding on server '" + str + "', use 'characterEncoding=' property  to provide correct mapping", SQLError.SQL_STATE_INVALID_CONNECTION_ATTRIBUTE, getExceptionInterceptor());
                }
                try {
                    StringUtils.getBytes("abc", javaEncodingForMysqlCharset);
                    setEncoding(javaEncodingForMysqlCharset);
                    setUseUnicode(true);
                } catch (UnsupportedEncodingException unused) {
                    throw SQLError.createSQLException("The driver can not map the character encoding '" + getEncoding() + "' that your server is using to a character encoding your JVM understands. You can specify this mapping manually by adding \"useUnicode=true\" as well as \"characterEncoding=[an_encoding_your_jvm_understands]\" to your JDBC URL.", "0S100", getExceptionInterceptor());
                }
            }
        }
    }

    private void checkTransactionIsolationLevel() throws SQLException {
        Integer num;
        String str = this.serverVariables.get("transaction_isolation");
        if (str == null) {
            str = this.serverVariables.get("tx_isolation");
        }
        if (str == null || (num = mapTransIsolationNameToValue.get(str)) == null) {
            return;
        }
        this.isolationLevel = num.intValue();
    }

    private void cleanup(Throwable th) {
        try {
            if (this.f79io != null) {
                if (isClosed()) {
                    this.f79io.forceClose();
                } else {
                    realClose(false, false, false, th);
                }
            }
        } catch (SQLException unused) {
        }
        this.isClosed = true;
    }

    private void closeAllOpenStatements() throws SQLException {
        Iterator<Statement> it = this.openStatements.iterator();
        SQLException e = null;
        while (it.hasNext()) {
            try {
                ((StatementImpl) it.next()).realClose(false, true);
            } catch (SQLException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    private void closeStatement(java.sql.Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException unused) {
            }
        }
    }

    private void configureCharsetProperties() throws SQLException {
        if (getEncoding() != null) {
            try {
                StringUtils.getBytes("abc", getEncoding());
            } catch (UnsupportedEncodingException unused) {
                String encoding = getEncoding();
                try {
                    setEncoding(CharsetMapping.getJavaEncodingForMysqlCharset(encoding));
                    if (getEncoding() == null) {
                        throw SQLError.createSQLException("Java does not support the MySQL character encoding '" + encoding + "'.", SQLError.SQL_STATE_INVALID_CONNECTION_ATTRIBUTE, getExceptionInterceptor());
                    }
                    try {
                        StringUtils.getBytes("abc", getEncoding());
                    } catch (UnsupportedEncodingException unused2) {
                        throw SQLError.createSQLException("Unsupported character encoding '" + getEncoding() + "'.", SQLError.SQL_STATE_INVALID_CONNECTION_ATTRIBUTE, getExceptionInterceptor());
                    }
                } catch (RuntimeException e) {
                    SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(e.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
                    sQLExceptionCreateSQLException.initCause(e);
                    throw sQLExceptionCreateSQLException;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0219  */
    /* JADX WARN: Code duplicated, block: B:107:0x0235 A[PHI: r5
  0x0235: PHI (r5v20 java.lang.String) = (r5v4 java.lang.String), (r5v16 java.lang.String) binds: [B:106:0x0233, B:109:0x0239] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:108:0x0237 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:109:0x0239  */
    /* JADX WARN: Code duplicated, block: B:113:0x023e  */
    /* JADX WARN: Code duplicated, block: B:116:0x0246  */
    /* JADX WARN: Code duplicated, block: B:118:0x024a A[Catch: all -> 0x023c, TRY_ENTER, TryCatch #8 {all -> 0x023c, blocks: (B:99:0x0201, B:118:0x024a, B:121:0x0252, B:123:0x025a, B:125:0x0260), top: B:335:0x014a }] */
    /* JADX WARN: Code duplicated, block: B:129:0x0282  */
    /* JADX WARN: Code duplicated, block: B:139:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:148:0x0317  */
    /* JADX WARN: Code duplicated, block: B:151:0x0331 A[Catch: all -> 0x0577, TryCatch #6 {all -> 0x0577, blocks: (B:64:0x0123, B:67:0x012c, B:149:0x032b, B:151:0x0331, B:158:0x0344, B:180:0x0388, B:168:0x0368, B:154:0x0338, B:157:0x0340, B:63:0x0120), top: B:331:0x0120 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x0337  */
    /* JADX WARN: Code duplicated, block: B:154:0x0338 A[Catch: all -> 0x0577, TryCatch #6 {all -> 0x0577, blocks: (B:64:0x0123, B:67:0x012c, B:149:0x032b, B:151:0x0331, B:158:0x0344, B:180:0x0388, B:168:0x0368, B:154:0x0338, B:157:0x0340, B:63:0x0120), top: B:331:0x0120 }] */
    /* JADX WARN: Code duplicated, block: B:156:0x033e  */
    /* JADX WARN: Code duplicated, block: B:157:0x0340 A[Catch: all -> 0x0577, TryCatch #6 {all -> 0x0577, blocks: (B:64:0x0123, B:67:0x012c, B:149:0x032b, B:151:0x0331, B:158:0x0344, B:180:0x0388, B:168:0x0368, B:154:0x0338, B:157:0x0340, B:63:0x0120), top: B:331:0x0120 }] */
    /* JADX WARN: Code duplicated, block: B:168:0x0368 A[Catch: all -> 0x0577, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x0577, blocks: (B:64:0x0123, B:67:0x012c, B:149:0x032b, B:151:0x0331, B:158:0x0344, B:180:0x0388, B:168:0x0368, B:154:0x0338, B:157:0x0340, B:63:0x0120), top: B:331:0x0120 }] */
    /* JADX WARN: Code duplicated, block: B:170:0x036e A[Catch: all -> 0x0109, TRY_ENTER, TryCatch #14 {all -> 0x0109, blocks: (B:22:0x007a, B:24:0x007e, B:26:0x0084, B:27:0x0092, B:29:0x00a0, B:36:0x00b1, B:38:0x00b7, B:41:0x00bf, B:43:0x00c7, B:45:0x00cf, B:47:0x00d7, B:50:0x00e0, B:66:0x0129, B:72:0x0146, B:83:0x016b, B:142:0x0309, B:160:0x034c, B:162:0x0354, B:164:0x035c, B:173:0x0376, B:170:0x036e, B:34:0x00ad, B:51:0x00e4, B:52:0x0106, B:57:0x010e, B:58:0x0119, B:60:0x011b), top: B:343:0x007a, inners: #28 }] */
    /* JADX WARN: Code duplicated, block: B:179:0x0387  */
    /* JADX WARN: Code duplicated, block: B:196:0x03eb  */
    /* JADX WARN: Code duplicated, block: B:199:0x0408 A[Catch: all -> 0x05a2, TryCatch #0 {all -> 0x05a2, blocks: (B:197:0x0404, B:199:0x0408, B:201:0x0413, B:203:0x041b, B:210:0x042a, B:215:0x0435, B:217:0x0449, B:227:0x045f, B:223:0x0453, B:225:0x0459, B:228:0x0466, B:229:0x0467, B:231:0x0470, B:234:0x0477, B:236:0x0491, B:250:0x04bc, B:252:0x04c8, B:255:0x04d1, B:262:0x04ec, B:264:0x04fc, B:266:0x0511, B:273:0x0533, B:275:0x0542, B:269:0x0527, B:271:0x052d, B:276:0x0545, B:277:0x0546, B:279:0x0556, B:280:0x0576, B:259:0x04dd, B:242:0x04a6, B:244:0x04ae, B:247:0x04b5, B:192:0x03db, B:182:0x03b5, B:188:0x03cd, B:190:0x03d5, B:193:0x03e2, B:283:0x057b, B:284:0x05a1), top: B:322:0x007a, inners: #26 }] */
    /* JADX WARN: Code duplicated, block: B:207:0x0424  */
    /* JADX WARN: Code duplicated, block: B:209:0x0428  */
    /* JADX WARN: Code duplicated, block: B:213:0x0432 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:214:0x0434  */
    /* JADX WARN: Code duplicated, block: B:229:0x0467 A[Catch: all -> 0x05a2, TryCatch #0 {all -> 0x05a2, blocks: (B:197:0x0404, B:199:0x0408, B:201:0x0413, B:203:0x041b, B:210:0x042a, B:215:0x0435, B:217:0x0449, B:227:0x045f, B:223:0x0453, B:225:0x0459, B:228:0x0466, B:229:0x0467, B:231:0x0470, B:234:0x0477, B:236:0x0491, B:250:0x04bc, B:252:0x04c8, B:255:0x04d1, B:262:0x04ec, B:264:0x04fc, B:266:0x0511, B:273:0x0533, B:275:0x0542, B:269:0x0527, B:271:0x052d, B:276:0x0545, B:277:0x0546, B:279:0x0556, B:280:0x0576, B:259:0x04dd, B:242:0x04a6, B:244:0x04ae, B:247:0x04b5, B:192:0x03db, B:182:0x03b5, B:188:0x03cd, B:190:0x03d5, B:193:0x03e2, B:283:0x057b, B:284:0x05a1), top: B:322:0x007a, inners: #26 }] */
    /* JADX WARN: Code duplicated, block: B:231:0x0470 A[Catch: all -> 0x05a2, TRY_LEAVE, TryCatch #0 {all -> 0x05a2, blocks: (B:197:0x0404, B:199:0x0408, B:201:0x0413, B:203:0x041b, B:210:0x042a, B:215:0x0435, B:217:0x0449, B:227:0x045f, B:223:0x0453, B:225:0x0459, B:228:0x0466, B:229:0x0467, B:231:0x0470, B:234:0x0477, B:236:0x0491, B:250:0x04bc, B:252:0x04c8, B:255:0x04d1, B:262:0x04ec, B:264:0x04fc, B:266:0x0511, B:273:0x0533, B:275:0x0542, B:269:0x0527, B:271:0x052d, B:276:0x0545, B:277:0x0546, B:279:0x0556, B:280:0x0576, B:259:0x04dd, B:242:0x04a6, B:244:0x04ae, B:247:0x04b5, B:192:0x03db, B:182:0x03b5, B:188:0x03cd, B:190:0x03d5, B:193:0x03e2, B:283:0x057b, B:284:0x05a1), top: B:322:0x007a, inners: #26 }] */
    /* JADX WARN: Code duplicated, block: B:233:0x0476  */
    /* JADX WARN: Code duplicated, block: B:248:0x04b6  */
    /* JADX WARN: Code duplicated, block: B:260:0x04e8  */
    /* JADX WARN: Code duplicated, block: B:262:0x04ec A[Catch: all -> 0x05a2, TryCatch #0 {all -> 0x05a2, blocks: (B:197:0x0404, B:199:0x0408, B:201:0x0413, B:203:0x041b, B:210:0x042a, B:215:0x0435, B:217:0x0449, B:227:0x045f, B:223:0x0453, B:225:0x0459, B:228:0x0466, B:229:0x0467, B:231:0x0470, B:234:0x0477, B:236:0x0491, B:250:0x04bc, B:252:0x04c8, B:255:0x04d1, B:262:0x04ec, B:264:0x04fc, B:266:0x0511, B:273:0x0533, B:275:0x0542, B:269:0x0527, B:271:0x052d, B:276:0x0545, B:277:0x0546, B:279:0x0556, B:280:0x0576, B:259:0x04dd, B:242:0x04a6, B:244:0x04ae, B:247:0x04b5, B:192:0x03db, B:182:0x03b5, B:188:0x03cd, B:190:0x03d5, B:193:0x03e2, B:283:0x057b, B:284:0x05a1), top: B:322:0x007a, inners: #26 }] */
    /* JADX WARN: Code duplicated, block: B:264:0x04fc A[Catch: all -> 0x05a2, TRY_LEAVE, TryCatch #0 {all -> 0x05a2, blocks: (B:197:0x0404, B:199:0x0408, B:201:0x0413, B:203:0x041b, B:210:0x042a, B:215:0x0435, B:217:0x0449, B:227:0x045f, B:223:0x0453, B:225:0x0459, B:228:0x0466, B:229:0x0467, B:231:0x0470, B:234:0x0477, B:236:0x0491, B:250:0x04bc, B:252:0x04c8, B:255:0x04d1, B:262:0x04ec, B:264:0x04fc, B:266:0x0511, B:273:0x0533, B:275:0x0542, B:269:0x0527, B:271:0x052d, B:276:0x0545, B:277:0x0546, B:279:0x0556, B:280:0x0576, B:259:0x04dd, B:242:0x04a6, B:244:0x04ae, B:247:0x04b5, B:192:0x03db, B:182:0x03b5, B:188:0x03cd, B:190:0x03d5, B:193:0x03e2, B:283:0x057b, B:284:0x05a1), top: B:322:0x007a, inners: #26 }] */
    /* JADX WARN: Code duplicated, block: B:275:0x0542 A[Catch: all -> 0x05a2, TryCatch #0 {all -> 0x05a2, blocks: (B:197:0x0404, B:199:0x0408, B:201:0x0413, B:203:0x041b, B:210:0x042a, B:215:0x0435, B:217:0x0449, B:227:0x045f, B:223:0x0453, B:225:0x0459, B:228:0x0466, B:229:0x0467, B:231:0x0470, B:234:0x0477, B:236:0x0491, B:250:0x04bc, B:252:0x04c8, B:255:0x04d1, B:262:0x04ec, B:264:0x04fc, B:266:0x0511, B:273:0x0533, B:275:0x0542, B:269:0x0527, B:271:0x052d, B:276:0x0545, B:277:0x0546, B:279:0x0556, B:280:0x0576, B:259:0x04dd, B:242:0x04a6, B:244:0x04ae, B:247:0x04b5, B:192:0x03db, B:182:0x03b5, B:188:0x03cd, B:190:0x03d5, B:193:0x03e2, B:283:0x057b, B:284:0x05a1), top: B:322:0x007a, inners: #26 }] */
    /* JADX WARN: Code duplicated, block: B:277:0x0546 A[Catch: all -> 0x05a2, TryCatch #0 {all -> 0x05a2, blocks: (B:197:0x0404, B:199:0x0408, B:201:0x0413, B:203:0x041b, B:210:0x042a, B:215:0x0435, B:217:0x0449, B:227:0x045f, B:223:0x0453, B:225:0x0459, B:228:0x0466, B:229:0x0467, B:231:0x0470, B:234:0x0477, B:236:0x0491, B:250:0x04bc, B:252:0x04c8, B:255:0x04d1, B:262:0x04ec, B:264:0x04fc, B:266:0x0511, B:273:0x0533, B:275:0x0542, B:269:0x0527, B:271:0x052d, B:276:0x0545, B:277:0x0546, B:279:0x0556, B:280:0x0576, B:259:0x04dd, B:242:0x04a6, B:244:0x04ae, B:247:0x04b5, B:192:0x03db, B:182:0x03b5, B:188:0x03cd, B:190:0x03d5, B:193:0x03e2, B:283:0x057b, B:284:0x05a1), top: B:322:0x007a, inners: #26 }] */
    /* JADX WARN: Code duplicated, block: B:279:0x0556 A[Catch: all -> 0x05a2, TryCatch #0 {all -> 0x05a2, blocks: (B:197:0x0404, B:199:0x0408, B:201:0x0413, B:203:0x041b, B:210:0x042a, B:215:0x0435, B:217:0x0449, B:227:0x045f, B:223:0x0453, B:225:0x0459, B:228:0x0466, B:229:0x0467, B:231:0x0470, B:234:0x0477, B:236:0x0491, B:250:0x04bc, B:252:0x04c8, B:255:0x04d1, B:262:0x04ec, B:264:0x04fc, B:266:0x0511, B:273:0x0533, B:275:0x0542, B:269:0x0527, B:271:0x052d, B:276:0x0545, B:277:0x0546, B:279:0x0556, B:280:0x0576, B:259:0x04dd, B:242:0x04a6, B:244:0x04ae, B:247:0x04b5, B:192:0x03db, B:182:0x03b5, B:188:0x03cd, B:190:0x03d5, B:193:0x03e2, B:283:0x057b, B:284:0x05a1), top: B:322:0x007a, inners: #26 }] */
    /* JADX WARN: Code duplicated, block: B:283:0x057b A[Catch: all -> 0x05a2, TryCatch #0 {all -> 0x05a2, blocks: (B:197:0x0404, B:199:0x0408, B:201:0x0413, B:203:0x041b, B:210:0x042a, B:215:0x0435, B:217:0x0449, B:227:0x045f, B:223:0x0453, B:225:0x0459, B:228:0x0466, B:229:0x0467, B:231:0x0470, B:234:0x0477, B:236:0x0491, B:250:0x04bc, B:252:0x04c8, B:255:0x04d1, B:262:0x04ec, B:264:0x04fc, B:266:0x0511, B:273:0x0533, B:275:0x0542, B:269:0x0527, B:271:0x052d, B:276:0x0545, B:277:0x0546, B:279:0x0556, B:280:0x0576, B:259:0x04dd, B:242:0x04a6, B:244:0x04ae, B:247:0x04b5, B:192:0x03db, B:182:0x03b5, B:188:0x03cd, B:190:0x03d5, B:193:0x03e2, B:283:0x057b, B:284:0x05a1), top: B:322:0x007a, inners: #26 }] */
    /* JADX WARN: Code duplicated, block: B:331:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:352:0x014c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x0129 A[Catch: all -> 0x0109, TRY_ENTER, TRY_LEAVE, TryCatch #14 {all -> 0x0109, blocks: (B:22:0x007a, B:24:0x007e, B:26:0x0084, B:27:0x0092, B:29:0x00a0, B:36:0x00b1, B:38:0x00b7, B:41:0x00bf, B:43:0x00c7, B:45:0x00cf, B:47:0x00d7, B:50:0x00e0, B:66:0x0129, B:72:0x0146, B:83:0x016b, B:142:0x0309, B:160:0x034c, B:162:0x0354, B:164:0x035c, B:173:0x0376, B:170:0x036e, B:34:0x00ad, B:51:0x00e4, B:52:0x0106, B:57:0x010e, B:58:0x0119, B:60:0x011b), top: B:343:0x007a, inners: #28 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0142  */
    /* JADX WARN: Code duplicated, block: B:72:0x0146 A[Catch: all -> 0x0109, TRY_ENTER, TRY_LEAVE, TryCatch #14 {all -> 0x0109, blocks: (B:22:0x007a, B:24:0x007e, B:26:0x0084, B:27:0x0092, B:29:0x00a0, B:36:0x00b1, B:38:0x00b7, B:41:0x00bf, B:43:0x00c7, B:45:0x00cf, B:47:0x00d7, B:50:0x00e0, B:66:0x0129, B:72:0x0146, B:83:0x016b, B:142:0x0309, B:160:0x034c, B:162:0x0354, B:164:0x035c, B:173:0x0376, B:170:0x036e, B:34:0x00ad, B:51:0x00e4, B:52:0x0106, B:57:0x010e, B:58:0x0119, B:60:0x011b), top: B:343:0x007a, inners: #28 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x0154  */
    /* JADX WARN: Code duplicated, block: B:77:0x0156 A[Catch: all -> 0x0214, TryCatch #20 {all -> 0x0214, blocks: (B:74:0x014c, B:77:0x0156, B:80:0x015d), top: B:352:0x014c }] */
    /* JADX WARN: Code duplicated, block: B:79:0x015c  */
    /* JADX WARN: Code duplicated, block: B:80:0x015d A[Catch: all -> 0x0214, TRY_LEAVE, TryCatch #20 {all -> 0x0214, blocks: (B:74:0x014c, B:77:0x0156, B:80:0x015d), top: B:352:0x014c }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0169  */
    /* JADX WARN: Code duplicated, block: B:97:0x01ee  */
    /* JADX WARN: Instruction removed from duplicated block: B:279:0x0556, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:283:0x057b, please report this as an issue */
    private boolean configureClientCharacterSet(boolean z) throws Throwable {
        String str;
        int i;
        int i2;
        String encoding;
        boolean z2;
        String str2;
        boolean z3;
        String str3;
        String serverCharset;
        String encoding2;
        boolean useUnicode;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        Map<String, String> map;
        boolean z4;
        String str12;
        String str13;
        String str14;
        int i3;
        String characterSetResults;
        String mysqlCharsetForJavaEncoding;
        String str15;
        int i4;
        String str16;
        boolean z5;
        String str17;
        String str18;
        String str19;
        boolean z6;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        boolean zVersionMeetsMinimum;
        String str25;
        String str26;
        String str27 = "₩";
        String str28 = SQLError.SQL_STATE_ILLEGAL_ARGUMENT;
        String str29 = "¥";
        String str30 = "UTF-8";
        String encoding3 = getEncoding();
        try {
            if (versionMeetsMinimum(4, 1, 0)) {
                setUseUnicode(true);
                configureCharsetProperties();
                String encoding4 = getEncoding();
                boolean useOldUTF8Behavior = getUseOldUTF8Behavior();
                String str31 = BuildConfig.FLAVOR;
                if (useOldUTF8Behavior || StringUtils.isNullOrEmpty(getConnectionCollation())) {
                    str3 = encoding4;
                    serverCharset = BuildConfig.FLAVOR;
                } else {
                    serverCharset = BuildConfig.FLAVOR;
                    int i5 = 1;
                    while (true) {
                        String[] strArr = CharsetMapping.COLLATION_INDEX_TO_COLLATION_NAME;
                        if (i5 >= strArr.length) {
                            break;
                        }
                        if (strArr[i5].equals(getConnectionCollation())) {
                            String str32 = " COLLATE " + strArr[i5];
                            serverCharset = CharsetMapping.COLLATION_INDEX_TO_CHARSET[i5].charsetName;
                            encoding4 = CharsetMapping.getJavaEncodingForCollationIndex(Integer.valueOf(i5));
                            str31 = str32;
                        }
                        i5++;
                    }
                    str3 = encoding4;
                }
                String str33 = null;
                try {
                    try {
                        try {
                            try {
                                Properties properties = this.props;
                                if (properties != null && properties.getProperty("com.mysql.jdbc.faultInjection.serverCharsetIndex") != null) {
                                    this.f79io.serverCharsetIndex = Integer.parseInt(this.props.getProperty("com.mysql.jdbc.faultInjection.serverCharsetIndex"));
                                }
                                String javaEncodingForCollationIndex = CharsetMapping.getJavaEncodingForCollationIndex(Integer.valueOf(this.f79io.serverCharsetIndex));
                                try {
                                    if (javaEncodingForCollationIndex == null || javaEncodingForCollationIndex.length() == 0) {
                                        if (str3 == null) {
                                            throw SQLError.createSQLException("Unknown initial character set index '" + this.f79io.serverCharsetIndex + "' received from server. Initial client character set can be forced via the 'characterEncoding' property.", SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
                                        }
                                        setEncoding(str3);
                                        if (str3 != null) {
                                            throw SQLError.createSQLException("Unknown initial character set index '" + this.f79io.serverCharsetIndex + "' received from server. Initial client character set can be forced via the 'characterEncoding' property.", SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
                                        }
                                        try {
                                            setEncoding(str3);
                                            if (getEncoding() == null) {
                                                setEncoding("ISO8859_1");
                                            }
                                            useUnicode = getUseUnicode();
                                            str4 = "utf8";
                                            str5 = SQLError.SQL_STATE_GENERAL_ERROR;
                                            str6 = CharsetMapping.NOT_USED;
                                            if (useUnicode) {
                                                if (str3 == null) {
                                                    try {
                                                        if (!str3.equalsIgnoreCase("UTF-8")) {
                                                            try {
                                                                if (str3.equalsIgnoreCase("UTF8")) {
                                                                    str24 = str3;
                                                                    str5 = str5;
                                                                    i2 = 1;
                                                                    str27 = "₩";
                                                                    str17 = "UTF-8";
                                                                    try {
                                                                        zVersionMeetsMinimum = versionMeetsMinimum(5, 5, 2);
                                                                        if (str31.length() <= 0) {
                                                                            str25 = serverCharset;
                                                                        } else if (zVersionMeetsMinimum) {
                                                                            serverCharset = "utf8mb4";
                                                                            str25 = serverCharset;
                                                                        } else {
                                                                            str25 = "utf8";
                                                                        }
                                                                        if (!getUseOldUTF8Behavior()) {
                                                                            str7 = "utf8";
                                                                            str11 = "character_set_client";
                                                                            try {
                                                                                str9 = "character_set_connection";
                                                                                execSQL(null, "SET NAMES latin1", -1, null, 1003, 1007, false, this.database, null, false);
                                                                                Map<String, String> map2 = this.serverVariables;
                                                                                str18 = CharsetMapping.NOT_USED;
                                                                                map2.put(str11, str18);
                                                                                this.serverVariables.put(str9, str18);
                                                                                str3 = str24;
                                                                            } catch (Throwable th) {
                                                                                th = th;
                                                                                str3 = str24;
                                                                                encoding3 = str3;
                                                                                setEncoding(encoding3);
                                                                                throw th;
                                                                            }
                                                                        } else if (z && characterSetNamesMatches("utf8") && ((!zVersionMeetsMinimum || characterSetNamesMatches("utf8mb4")) && (str31.length() <= 0 || getConnectionCollation().equalsIgnoreCase(this.serverVariables.get("collation_server"))))) {
                                                                            str7 = "utf8";
                                                                            str9 = "character_set_connection";
                                                                            str11 = "character_set_client";
                                                                            str18 = CharsetMapping.NOT_USED;
                                                                            str3 = str24;
                                                                        } else {
                                                                            try {
                                                                                str7 = "utf8";
                                                                                String str34 = str25;
                                                                                str26 = str24;
                                                                                str11 = "character_set_client";
                                                                                try {
                                                                                    execSQL(null, "SET NAMES " + str25 + str31, -1, null, 1003, 1007, false, this.database, null, false);
                                                                                    this.serverVariables.put(str11, str34);
                                                                                    this.serverVariables.put("character_set_connection", str34);
                                                                                    str3 = str26;
                                                                                    str9 = "character_set_connection";
                                                                                    str18 = CharsetMapping.NOT_USED;
                                                                                } catch (Throwable th2) {
                                                                                    th = th2;
                                                                                    encoding3 = str26;
                                                                                    setEncoding(encoding3);
                                                                                    throw th;
                                                                                }
                                                                            } catch (Throwable th3) {
                                                                                th = th3;
                                                                                str26 = str24;
                                                                            }
                                                                        }
                                                                        setEncoding(str3);
                                                                    } catch (Throwable th4) {
                                                                        th = th4;
                                                                        str3 = str24;
                                                                    }
                                                                } else {
                                                                    if (str31.length() > 0) {
                                                                        serverCharset = CharsetMapping.getMysqlCharsetForJavaEncoding(str3.toUpperCase(Locale.ENGLISH), this);
                                                                    }
                                                                    if (serverCharset != null) {
                                                                        if (z && characterSetNamesMatches(serverCharset)) {
                                                                            str4 = "utf8";
                                                                            str6 = CharsetMapping.NOT_USED;
                                                                            str23 = str3;
                                                                            str5 = str5;
                                                                            str21 = "character_set_connection";
                                                                            i2 = 1;
                                                                            str27 = "₩";
                                                                            str30 = "UTF-8";
                                                                            str22 = "character_set_client";
                                                                        } else {
                                                                            try {
                                                                                String str35 = serverCharset;
                                                                                i2 = 1;
                                                                                str20 = str3;
                                                                                try {
                                                                                    execSQL(null, "SET NAMES " + serverCharset + str31, -1, null, 1003, 1007, false, this.database, null, false);
                                                                                    str22 = "character_set_client";
                                                                                    this.serverVariables.put(str22, str35);
                                                                                    str21 = "character_set_connection";
                                                                                    this.serverVariables.put(str21, str35);
                                                                                } catch (Throwable th5) {
                                                                                    th = th5;
                                                                                    encoding3 = str20;
                                                                                    setEncoding(encoding3);
                                                                                    throw th;
                                                                                }
                                                                            } catch (Throwable th6) {
                                                                                th = th6;
                                                                                str20 = str3;
                                                                            }
                                                                        }
                                                                        setEncoding(str23);
                                                                        encoding2 = str23;
                                                                        str8 = str30;
                                                                        str28 = SQLError.SQL_STATE_ILLEGAL_ARGUMENT;
                                                                        str29 = "¥";
                                                                        str7 = str4;
                                                                        str10 = str6;
                                                                        str9 = str21;
                                                                        str11 = str22;
                                                                    } else {
                                                                        str20 = str3;
                                                                        str21 = "character_set_connection";
                                                                        i2 = 1;
                                                                        str22 = "character_set_client";
                                                                    }
                                                                    str23 = str20;
                                                                    setEncoding(str23);
                                                                    encoding2 = str23;
                                                                    str8 = str30;
                                                                    str28 = SQLError.SQL_STATE_ILLEGAL_ARGUMENT;
                                                                    str29 = "¥";
                                                                    str7 = str4;
                                                                    str10 = str6;
                                                                    str9 = str21;
                                                                    str11 = str22;
                                                                }
                                                            } catch (Throwable th7) {
                                                                th = th7;
                                                                str33 = str3;
                                                                encoding3 = str33;
                                                            }
                                                            setEncoding(encoding3);
                                                            throw th;
                                                        }
                                                        str24 = str3;
                                                        str5 = str5;
                                                        i2 = 1;
                                                        str27 = "₩";
                                                        str17 = "UTF-8";
                                                        zVersionMeetsMinimum = versionMeetsMinimum(5, 5, 2);
                                                        if (str31.length() <= 0) {
                                                            str25 = serverCharset;
                                                        } else if (zVersionMeetsMinimum) {
                                                            serverCharset = "utf8mb4";
                                                            str25 = serverCharset;
                                                        } else {
                                                            str25 = "utf8";
                                                        }
                                                        if (!getUseOldUTF8Behavior()) {
                                                            str7 = "utf8";
                                                            str11 = "character_set_client";
                                                            str9 = "character_set_connection";
                                                            execSQL(null, "SET NAMES latin1", -1, null, 1003, 1007, false, this.database, null, false);
                                                            Map<String, String> map3 = this.serverVariables;
                                                            str18 = CharsetMapping.NOT_USED;
                                                            map3.put(str11, str18);
                                                            this.serverVariables.put(str9, str18);
                                                            str3 = str24;
                                                        } else if (z) {
                                                            str7 = "utf8";
                                                            String str36 = str25;
                                                            str26 = str24;
                                                            str11 = "character_set_client";
                                                            execSQL(null, "SET NAMES " + str25 + str31, -1, null, 1003, 1007, false, this.database, null, false);
                                                            this.serverVariables.put(str11, str36);
                                                            this.serverVariables.put("character_set_connection", str36);
                                                            str3 = str26;
                                                            str9 = "character_set_connection";
                                                            str18 = CharsetMapping.NOT_USED;
                                                        } else {
                                                            str7 = "utf8";
                                                            String str37 = str25;
                                                            str26 = str24;
                                                            str11 = "character_set_client";
                                                            execSQL(null, "SET NAMES " + str25 + str31, -1, null, 1003, 1007, false, this.database, null, false);
                                                            this.serverVariables.put(str11, str37);
                                                            this.serverVariables.put("character_set_connection", str37);
                                                            str3 = str26;
                                                            str9 = "character_set_connection";
                                                            str18 = CharsetMapping.NOT_USED;
                                                        }
                                                        setEncoding(str3);
                                                    } catch (Throwable th8) {
                                                        th = th8;
                                                    }
                                                } else {
                                                    str7 = "utf8";
                                                    str28 = SQLError.SQL_STATE_ILLEGAL_ARGUMENT;
                                                    str5 = str5;
                                                    str9 = "character_set_connection";
                                                    i2 = 1;
                                                    str27 = "₩";
                                                    str17 = "UTF-8";
                                                    str18 = CharsetMapping.NOT_USED;
                                                    str29 = "¥";
                                                    str11 = "character_set_client";
                                                    if (getEncoding() != null) {
                                                        if (str31.length() <= 0) {
                                                            if (getUseOldUTF8Behavior()) {
                                                                serverCharset = str18;
                                                            } else {
                                                                serverCharset = getServerCharset();
                                                            }
                                                        }
                                                        if (!"ucs2".equalsIgnoreCase(serverCharset) || "utf16".equalsIgnoreCase(serverCharset) || "utf16le".equalsIgnoreCase(serverCharset) || "utf32".equalsIgnoreCase(serverCharset)) {
                                                            if (getCharacterSetResults() == null) {
                                                                setCharacterSetResults(str17);
                                                            }
                                                            str19 = str7;
                                                            z6 = true;
                                                        } else {
                                                            str19 = serverCharset;
                                                            z6 = false;
                                                        }
                                                        if (z && characterSetNamesMatches(str19) && !z6) {
                                                            str8 = str17;
                                                            str10 = str18;
                                                        } else {
                                                            try {
                                                                String str38 = str19;
                                                                str8 = str17;
                                                                str10 = str18;
                                                                try {
                                                                    execSQL(null, "SET NAMES " + str19 + str31, -1, null, 1003, 1007, false, this.database, null, false);
                                                                    this.serverVariables.put(str11, str38);
                                                                    this.serverVariables.put(str9, str38);
                                                                } catch (SQLException e) {
                                                                    e = e;
                                                                    if (e.getErrorCode() != 1820 || getDisconnectOnExpiredPasswords()) {
                                                                        throw e;
                                                                    }
                                                                }
                                                            } catch (SQLException e2) {
                                                                e = e2;
                                                                str8 = str17;
                                                                str10 = str18;
                                                            }
                                                        }
                                                        encoding2 = getEncoding();
                                                    }
                                                }
                                                encoding2 = str3;
                                                str8 = str17;
                                                str10 = str18;
                                            } else {
                                                str7 = "utf8";
                                                encoding2 = str3;
                                                str8 = "UTF-8";
                                                str28 = SQLError.SQL_STATE_ILLEGAL_ARGUMENT;
                                                str5 = str5;
                                                str9 = "character_set_connection";
                                                i2 = 1;
                                                str27 = "₩";
                                                str10 = CharsetMapping.NOT_USED;
                                                str29 = "¥";
                                                str11 = "character_set_client";
                                            }
                                            map = this.serverVariables;
                                            if (map != null) {
                                                str16 = map.get("character_set_results");
                                                if (str16 != null || "NULL".equalsIgnoreCase(str16) || str16.length() == 0) {
                                                    z5 = true;
                                                } else {
                                                    z5 = false;
                                                }
                                                z4 = z5;
                                                str12 = str16;
                                            } else {
                                                z4 = false;
                                                str12 = null;
                                            }
                                            if (getCharacterSetResults() == null) {
                                                if (getUseOldUTF8Behavior()) {
                                                    try {
                                                        String str39 = this.database;
                                                        str13 = JDBC_LOCAL_CHARACTER_SET_RESULTS;
                                                        str14 = str12;
                                                        try {
                                                            execSQL(null, "SET NAMES latin1", -1, null, 1003, 1007, false, str39, null, false);
                                                            this.serverVariables.put(str11, str10);
                                                            this.serverVariables.put(str9, str10);
                                                        } catch (SQLException e3) {
                                                            e = e3;
                                                            int errorCode = e.getErrorCode();
                                                            i3 = MysqlErrorNumbers.ER_MUST_CHANGE_PASSWORD;
                                                            if (errorCode != 1820 || getDisconnectOnExpiredPasswords()) {
                                                                throw e;
                                                            }
                                                        }
                                                    } catch (SQLException e4) {
                                                        e = e4;
                                                        str13 = JDBC_LOCAL_CHARACTER_SET_RESULTS;
                                                        str14 = str12;
                                                    }
                                                } else {
                                                    str13 = JDBC_LOCAL_CHARACTER_SET_RESULTS;
                                                    str14 = str12;
                                                }
                                                i3 = MysqlErrorNumbers.ER_MUST_CHANGE_PASSWORD;
                                                characterSetResults = getCharacterSetResults();
                                                if (!str8.equalsIgnoreCase(characterSetResults) || "UTF8".equalsIgnoreCase(characterSetResults)) {
                                                    mysqlCharsetForJavaEncoding = str7;
                                                } else {
                                                    mysqlCharsetForJavaEncoding = "null".equalsIgnoreCase(characterSetResults) ? "NULL" : CharsetMapping.getMysqlCharsetForJavaEncoding(characterSetResults.toUpperCase(Locale.ENGLISH), this);
                                                }
                                                if (mysqlCharsetForJavaEncoding != null) {
                                                    throw SQLError.createSQLException("Can't map " + characterSetResults + " given for characterSetResults to a supported MySQL encoding.", str28, getExceptionInterceptor());
                                                }
                                                if (mysqlCharsetForJavaEncoding.equalsIgnoreCase(this.serverVariables.get("character_set_results"))) {
                                                    i = 0;
                                                    this.serverVariables.put(str13, str14);
                                                } else {
                                                    StringBuilder sb = new StringBuilder(28 + mysqlCharsetForJavaEncoding.length());
                                                    sb.append("SET character_set_results = ");
                                                    sb.append(mysqlCharsetForJavaEncoding);
                                                    try {
                                                        execSQL(null, sb.toString(), -1, null, 1003, 1007, false, this.database, null, false);
                                                    } catch (SQLException e5) {
                                                        if (e5.getErrorCode() != i3 || getDisconnectOnExpiredPasswords()) {
                                                            throw e5;
                                                        }
                                                    }
                                                    this.serverVariables.put(str13, mysqlCharsetForJavaEncoding);
                                                    i = 0;
                                                    if (versionMeetsMinimum(5, 5, 0)) {
                                                        this.errorMessageEncoding = characterSetResults;
                                                    }
                                                }
                                                setEncoding(encoding3);
                                                throw th;
                                            }
                                            if (z4) {
                                                this.serverVariables.put(JDBC_LOCAL_CHARACTER_SET_RESULTS, str12);
                                            } else {
                                                try {
                                                    String str40 = this.database;
                                                    str15 = JDBC_LOCAL_CHARACTER_SET_RESULTS;
                                                    i4 = MysqlErrorNumbers.ER_MUST_CHANGE_PASSWORD;
                                                    try {
                                                        execSQL(null, "SET character_set_results = NULL", -1, null, 1003, 1007, false, str40, null, false);
                                                    } catch (SQLException e6) {
                                                        e = e6;
                                                        if (e.getErrorCode() != i4 || getDisconnectOnExpiredPasswords()) {
                                                            throw e;
                                                        }
                                                    }
                                                } catch (SQLException e7) {
                                                    e = e7;
                                                    str15 = JDBC_LOCAL_CHARACTER_SET_RESULTS;
                                                    i4 = MysqlErrorNumbers.ER_MUST_CHANGE_PASSWORD;
                                                }
                                                this.serverVariables.put(str15, null);
                                            }
                                            i = 0;
                                            encoding = encoding2;
                                            str = str5;
                                            z2 = true;
                                        } catch (Throwable th9) {
                                            th = th9;
                                            encoding2 = str3;
                                            encoding3 = encoding2;
                                        }
                                    }
                                    if (versionMeetsMinimum(4, 1, 0) && "ISO8859_1".equalsIgnoreCase(javaEncodingForCollationIndex)) {
                                        javaEncodingForCollationIndex = "Cp1252";
                                    }
                                    if ("UnicodeBig".equalsIgnoreCase(javaEncodingForCollationIndex) || "UTF-16".equalsIgnoreCase(javaEncodingForCollationIndex) || "UTF-16LE".equalsIgnoreCase(javaEncodingForCollationIndex) || "UTF-32".equalsIgnoreCase(javaEncodingForCollationIndex)) {
                                        javaEncodingForCollationIndex = "UTF-8";
                                    }
                                    setEncoding(javaEncodingForCollationIndex);
                                } catch (ArrayIndexOutOfBoundsException unused) {
                                    if (str3 != null) {
                                        throw SQLError.createSQLException("Unknown initial character set index '" + this.f79io.serverCharsetIndex + "' received from server. Initial client character set can be forced via the 'characterEncoding' property.", SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
                                    }
                                    setEncoding(str3);
                                }
                            } catch (RuntimeException e8) {
                                SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(e8.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
                                sQLExceptionCreateSQLException.initCause(e8);
                                throw sQLExceptionCreateSQLException;
                            } catch (SQLException e9) {
                                throw e9;
                            }
                        } catch (ArrayIndexOutOfBoundsException unused2) {
                        }
                        if (getEncoding() == null) {
                            setEncoding("ISO8859_1");
                        }
                        useUnicode = getUseUnicode();
                        str4 = "utf8";
                        str5 = SQLError.SQL_STATE_GENERAL_ERROR;
                        str6 = CharsetMapping.NOT_USED;
                        if (useUnicode) {
                            if (str3 == null) {
                                str7 = "utf8";
                                str28 = SQLError.SQL_STATE_ILLEGAL_ARGUMENT;
                                str5 = str5;
                                str9 = "character_set_connection";
                                i2 = 1;
                                str27 = "₩";
                                str17 = "UTF-8";
                                str18 = CharsetMapping.NOT_USED;
                                str29 = "¥";
                                str11 = "character_set_client";
                                if (getEncoding() != null) {
                                    if (str31.length() <= 0) {
                                        if (getUseOldUTF8Behavior()) {
                                            serverCharset = str18;
                                        } else {
                                            serverCharset = getServerCharset();
                                        }
                                    }
                                    if ("ucs2".equalsIgnoreCase(serverCharset)) {
                                        if (getCharacterSetResults() == null) {
                                            setCharacterSetResults(str17);
                                        }
                                        str19 = str7;
                                        z6 = true;
                                    } else {
                                        if (getCharacterSetResults() == null) {
                                            setCharacterSetResults(str17);
                                        }
                                        str19 = str7;
                                        z6 = true;
                                    }
                                    if (z) {
                                        String str310 = str19;
                                        str8 = str17;
                                        str10 = str18;
                                        execSQL(null, "SET NAMES " + str19 + str31, -1, null, 1003, 1007, false, this.database, null, false);
                                        this.serverVariables.put(str11, str310);
                                        this.serverVariables.put(str9, str310);
                                    } else {
                                        String str311 = str19;
                                        str8 = str17;
                                        str10 = str18;
                                        execSQL(null, "SET NAMES " + str19 + str31, -1, null, 1003, 1007, false, this.database, null, false);
                                        this.serverVariables.put(str11, str311);
                                        this.serverVariables.put(str9, str311);
                                    }
                                    encoding2 = getEncoding();
                                }
                            } else {
                                if (!str3.equalsIgnoreCase("UTF-8")) {
                                    if (str3.equalsIgnoreCase("UTF8")) {
                                        str24 = str3;
                                        str5 = str5;
                                        i2 = 1;
                                        str27 = "₩";
                                        str17 = "UTF-8";
                                        zVersionMeetsMinimum = versionMeetsMinimum(5, 5, 2);
                                        if (str31.length() <= 0) {
                                            str25 = serverCharset;
                                        } else if (zVersionMeetsMinimum) {
                                            serverCharset = "utf8mb4";
                                            str25 = serverCharset;
                                        } else {
                                            str25 = "utf8";
                                        }
                                        if (!getUseOldUTF8Behavior()) {
                                            str7 = "utf8";
                                            str11 = "character_set_client";
                                            str9 = "character_set_connection";
                                            execSQL(null, "SET NAMES latin1", -1, null, 1003, 1007, false, this.database, null, false);
                                            Map<String, String> map4 = this.serverVariables;
                                            str18 = CharsetMapping.NOT_USED;
                                            map4.put(str11, str18);
                                            this.serverVariables.put(str9, str18);
                                            str3 = str24;
                                        } else if (z) {
                                            str7 = "utf8";
                                            String str312 = str25;
                                            str26 = str24;
                                            str11 = "character_set_client";
                                            execSQL(null, "SET NAMES " + str25 + str31, -1, null, 1003, 1007, false, this.database, null, false);
                                            this.serverVariables.put(str11, str312);
                                            this.serverVariables.put("character_set_connection", str312);
                                            str3 = str26;
                                            str9 = "character_set_connection";
                                            str18 = CharsetMapping.NOT_USED;
                                        } else {
                                            str7 = "utf8";
                                            String str313 = str25;
                                            str26 = str24;
                                            str11 = "character_set_client";
                                            execSQL(null, "SET NAMES " + str25 + str31, -1, null, 1003, 1007, false, this.database, null, false);
                                            this.serverVariables.put(str11, str313);
                                            this.serverVariables.put("character_set_connection", str313);
                                            str3 = str26;
                                            str9 = "character_set_connection";
                                            str18 = CharsetMapping.NOT_USED;
                                        }
                                        setEncoding(str3);
                                    } else {
                                        if (str31.length() > 0) {
                                            serverCharset = CharsetMapping.getMysqlCharsetForJavaEncoding(str3.toUpperCase(Locale.ENGLISH), this);
                                        }
                                        if (serverCharset != null) {
                                            if (z) {
                                            }
                                            String str314 = serverCharset;
                                            i2 = 1;
                                            str20 = str3;
                                            execSQL(null, "SET NAMES " + serverCharset + str31, -1, null, 1003, 1007, false, this.database, null, false);
                                            str22 = "character_set_client";
                                            this.serverVariables.put(str22, str314);
                                            str21 = "character_set_connection";
                                            this.serverVariables.put(str21, str314);
                                        } else {
                                            str20 = str3;
                                            str21 = "character_set_connection";
                                            i2 = 1;
                                            str22 = "character_set_client";
                                        }
                                        str23 = str20;
                                        setEncoding(str23);
                                        encoding2 = str23;
                                        str8 = str30;
                                        str28 = SQLError.SQL_STATE_ILLEGAL_ARGUMENT;
                                        str29 = "¥";
                                        str7 = str4;
                                        str10 = str6;
                                        str9 = str21;
                                        str11 = str22;
                                    }
                                    setEncoding(encoding3);
                                    throw th;
                                }
                                str24 = str3;
                                str5 = str5;
                                i2 = 1;
                                str27 = "₩";
                                str17 = "UTF-8";
                                zVersionMeetsMinimum = versionMeetsMinimum(5, 5, 2);
                                if (str31.length() <= 0) {
                                    str25 = serverCharset;
                                } else if (zVersionMeetsMinimum) {
                                    serverCharset = "utf8mb4";
                                    str25 = serverCharset;
                                } else {
                                    str25 = "utf8";
                                }
                                if (!getUseOldUTF8Behavior()) {
                                    str7 = "utf8";
                                    str11 = "character_set_client";
                                    str9 = "character_set_connection";
                                    execSQL(null, "SET NAMES latin1", -1, null, 1003, 1007, false, this.database, null, false);
                                    Map<String, String> map5 = this.serverVariables;
                                    str18 = CharsetMapping.NOT_USED;
                                    map5.put(str11, str18);
                                    this.serverVariables.put(str9, str18);
                                    str3 = str24;
                                } else if (z) {
                                    str7 = "utf8";
                                    String str315 = str25;
                                    str26 = str24;
                                    str11 = "character_set_client";
                                    execSQL(null, "SET NAMES " + str25 + str31, -1, null, 1003, 1007, false, this.database, null, false);
                                    this.serverVariables.put(str11, str315);
                                    this.serverVariables.put("character_set_connection", str315);
                                    str3 = str26;
                                    str9 = "character_set_connection";
                                    str18 = CharsetMapping.NOT_USED;
                                } else {
                                    str7 = "utf8";
                                    String str316 = str25;
                                    str26 = str24;
                                    str11 = "character_set_client";
                                    execSQL(null, "SET NAMES " + str25 + str31, -1, null, 1003, 1007, false, this.database, null, false);
                                    this.serverVariables.put(str11, str316);
                                    this.serverVariables.put("character_set_connection", str316);
                                    str3 = str26;
                                    str9 = "character_set_connection";
                                    str18 = CharsetMapping.NOT_USED;
                                }
                                setEncoding(str3);
                            }
                            encoding2 = str3;
                            str8 = str17;
                            str10 = str18;
                        } else {
                            str7 = "utf8";
                            encoding2 = str3;
                            str8 = "UTF-8";
                            str28 = SQLError.SQL_STATE_ILLEGAL_ARGUMENT;
                            str5 = str5;
                            str9 = "character_set_connection";
                            i2 = 1;
                            str27 = "₩";
                            str10 = CharsetMapping.NOT_USED;
                            str29 = "¥";
                            str11 = "character_set_client";
                        }
                        map = this.serverVariables;
                        if (map != null) {
                            str16 = map.get("character_set_results");
                            if (str16 != null) {
                                z5 = true;
                            } else {
                                z5 = true;
                            }
                            z4 = z5;
                            str12 = str16;
                        } else {
                            z4 = false;
                            str12 = null;
                        }
                        if (getCharacterSetResults() == null) {
                            if (getUseOldUTF8Behavior()) {
                                String str317 = this.database;
                                str13 = JDBC_LOCAL_CHARACTER_SET_RESULTS;
                                str14 = str12;
                                execSQL(null, "SET NAMES latin1", -1, null, 1003, 1007, false, str317, null, false);
                                this.serverVariables.put(str11, str10);
                                this.serverVariables.put(str9, str10);
                            } else {
                                str13 = JDBC_LOCAL_CHARACTER_SET_RESULTS;
                                str14 = str12;
                            }
                            i3 = MysqlErrorNumbers.ER_MUST_CHANGE_PASSWORD;
                            characterSetResults = getCharacterSetResults();
                            if (str8.equalsIgnoreCase(characterSetResults)) {
                                mysqlCharsetForJavaEncoding = str7;
                            } else {
                                mysqlCharsetForJavaEncoding = str7;
                            }
                            if (mysqlCharsetForJavaEncoding != null) {
                                throw SQLError.createSQLException("Can't map " + characterSetResults + " given for characterSetResults to a supported MySQL encoding.", str28, getExceptionInterceptor());
                            }
                            if (mysqlCharsetForJavaEncoding.equalsIgnoreCase(this.serverVariables.get("character_set_results"))) {
                                StringBuilder sb2 = new StringBuilder(28 + mysqlCharsetForJavaEncoding.length());
                                sb2.append("SET character_set_results = ");
                                sb2.append(mysqlCharsetForJavaEncoding);
                                execSQL(null, sb2.toString(), -1, null, 1003, 1007, false, this.database, null, false);
                                this.serverVariables.put(str13, mysqlCharsetForJavaEncoding);
                                i = 0;
                                if (versionMeetsMinimum(5, 5, 0)) {
                                    this.errorMessageEncoding = characterSetResults;
                                }
                            } else {
                                i = 0;
                                this.serverVariables.put(str13, str14);
                            }
                            setEncoding(encoding3);
                            throw th;
                        }
                        if (z4) {
                            String str41 = this.database;
                            str15 = JDBC_LOCAL_CHARACTER_SET_RESULTS;
                            i4 = MysqlErrorNumbers.ER_MUST_CHANGE_PASSWORD;
                            execSQL(null, "SET character_set_results = NULL", -1, null, 1003, 1007, false, str41, null, false);
                            this.serverVariables.put(str15, null);
                        } else {
                            this.serverVariables.put(JDBC_LOCAL_CHARACTER_SET_RESULTS, str12);
                        }
                        i = 0;
                        encoding = encoding2;
                        str = str5;
                        z2 = true;
                    } catch (Throwable th10) {
                        th = th10;
                        encoding3 = encoding2;
                    }
                } catch (Throwable th11) {
                    th = th11;
                }
            } else {
                str = SQLError.SQL_STATE_GENERAL_ERROR;
                str27 = "₩";
                str29 = "¥";
                i = 0;
                i2 = 1;
                encoding = getEncoding();
                z2 = false;
            }
            setEncoding(encoding);
            try {
                CharsetEncoder charsetEncoderNewEncoder = Charset.forName(getEncoding()).newEncoder();
                CharBuffer charBufferAllocate = CharBuffer.allocate(i2);
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i2);
                str2 = str29;
                try {
                    charBufferAllocate.put(str2);
                    charBufferAllocate.position(i);
                    z3 = true;
                    try {
                        charsetEncoderNewEncoder.encode(charBufferAllocate, byteBufferAllocate, true);
                        if (byteBufferAllocate.get(i) == 92) {
                            this.requiresEscapingEncoder = true;
                        } else {
                            charBufferAllocate.clear();
                            byteBufferAllocate.clear();
                            str27 = str27;
                            try {
                                charBufferAllocate.put(str27);
                                charBufferAllocate.position(i);
                                charsetEncoderNewEncoder.encode(charBufferAllocate, byteBufferAllocate, true);
                                if (byteBufferAllocate.get(i) == 92) {
                                    this.requiresEscapingEncoder = true;
                                }
                            } catch (UnsupportedCharsetException unused3) {
                                try {
                                    if (StringUtils.getBytes(str2, getEncoding())[i] != 92) {
                                        this.requiresEscapingEncoder = z3;
                                    } else {
                                        this.requiresEscapingEncoder = z3;
                                    }
                                } catch (UnsupportedEncodingException e10) {
                                    throw SQLError.createSQLException("Unable to use encoding: " + getEncoding(), str, e10, getExceptionInterceptor());
                                }
                            }
                        }
                    } catch (UnsupportedCharsetException unused4) {
                        str27 = str27;
                    }
                } catch (UnsupportedCharsetException unused5) {
                    z3 = true;
                    if (StringUtils.getBytes(str2, getEncoding())[i] != 92 || StringUtils.getBytes(str27, getEncoding())[i] == 92) {
                        this.requiresEscapingEncoder = z3;
                    }
                    return z2;
                }
            } catch (UnsupportedCharsetException unused6) {
                str2 = str29;
            }
            return z2;
        } catch (Throwable th12) {
            th = th12;
        }
    }

    private void configureTimezone() throws SQLException {
        String str = this.serverVariables.get("timezone");
        if (str == null) {
            str = this.serverVariables.get("time_zone");
            if ("SYSTEM".equalsIgnoreCase(str)) {
                str = this.serverVariables.get("system_time_zone");
            }
        }
        String serverTimezone = getServerTimezone();
        if ((getUseTimezone() || !getUseLegacyDatetimeCode()) && str != null && (serverTimezone == null || StringUtils.isEmptyOrWhitespaceOnly(serverTimezone))) {
            try {
                serverTimezone = TimeUtil.getCanonicalTimezone(str, getExceptionInterceptor());
            } catch (IllegalArgumentException e) {
                throw SQLError.createSQLException(e.getMessage(), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
            }
        }
        if (serverTimezone == null || serverTimezone.length() <= 0) {
            return;
        }
        this.serverTimezoneTZ = TimeZone.getTimeZone(serverTimezone);
        if (serverTimezone.equalsIgnoreCase("GMT") || !this.serverTimezoneTZ.getID().equals("GMT")) {
            this.isServerTzUTC = !this.serverTimezoneTZ.useDaylightTime() && this.serverTimezoneTZ.getRawOffset() == 0;
            return;
        }
        throw SQLError.createSQLException("No timezone mapping entry for '" + serverTimezone + "'", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
    }

    private void connectOneTryOnly(boolean z, Properties properties) throws Throwable {
        try {
            coreConnect(properties);
            this.connectionId = this.f79io.getThreadId();
            this.isClosed = false;
            boolean autoCommit = getAutoCommit();
            int i = this.isolationLevel;
            boolean zIsReadOnly = isReadOnly(false);
            String catalog = getCatalog();
            this.f79io.setStatementInterceptors(this.statementInterceptors);
            initializePropsFromServer();
            if (z) {
                setAutoCommit(autoCommit);
                if (this.hasIsolationLevels) {
                    setTransactionIsolation(i);
                }
                setCatalog(catalog);
                setReadOnly(zIsReadOnly);
            }
        } catch (Exception e) {
            boolean z2 = e instanceof SQLException;
            if (z2 && ((SQLException) e).getErrorCode() == 1820 && !getDisconnectOnExpiredPasswords()) {
                return;
            }
            MysqlIO mysqlIO = this.f79io;
            if (mysqlIO != null) {
                mysqlIO.forceClose();
            }
            if (z2) {
                throw ((SQLException) e);
            }
            SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(Messages.getString("Connection.UnableToConnect"), SQLError.SQL_STATE_UNABLE_TO_CONNECT_TO_DATASOURCE, getExceptionInterceptor());
            sQLExceptionCreateSQLException.initCause(e);
            throw sQLExceptionCreateSQLException;
        }
    }

    private void connectWithRetries(boolean z, Properties properties) throws Throwable {
        boolean z2;
        boolean autoCommit;
        int i;
        boolean zIsReadOnly;
        String catalog;
        double initialTimeout = getInitialTimeout();
        Stack stack = null;
        Exception e = null;
        int i2 = 0;
        while (true) {
            if (i2 >= getMaxReconnects()) {
                z2 = false;
                break;
            }
            try {
                MysqlIO mysqlIO = this.f79io;
                if (mysqlIO != null) {
                    mysqlIO.forceClose();
                }
                try {
                    coreConnect(properties);
                    pingInternal(false, 0);
                    synchronized (getConnectionMutex()) {
                        this.connectionId = this.f79io.getThreadId();
                        this.isClosed = false;
                        autoCommit = getAutoCommit();
                        i = this.isolationLevel;
                        zIsReadOnly = isReadOnly(false);
                        catalog = getCatalog();
                        this.f79io.setStatementInterceptors(this.statementInterceptors);
                    }
                    initializePropsFromServer();
                    if (z) {
                        setAutoCommit(autoCommit);
                        if (this.hasIsolationLevels) {
                            setTransactionIsolation(i);
                        }
                        setCatalog(catalog);
                        setReadOnly(zIsReadOnly);
                    }
                    z2 = true;
                    break;
                } catch (Exception e2) {
                    e = e2;
                    if (i2 > 0) {
                        try {
                            Thread.sleep(((long) initialTimeout) * 1000);
                        } catch (InterruptedException unused) {
                        }
                    }
                    i2++;
                }
            } catch (Exception e3) {
                e = e3;
            }
            i2++;
        }
        if (!z2) {
            SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(Messages.getString("Connection.UnableToConnectWithRetries", new Object[]{Integer.valueOf(getMaxReconnects())}), SQLError.SQL_STATE_UNABLE_TO_CONNECT_TO_DATASOURCE, getExceptionInterceptor());
            sQLExceptionCreateSQLException.initCause(e);
            throw sQLExceptionCreateSQLException;
        }
        if (getParanoid() && !getHighAvailability()) {
            this.password = null;
            this.user = null;
        }
        if (z) {
            for (Statement statement : this.openStatements) {
                if (statement instanceof ServerPreparedStatement) {
                    if (stack == null) {
                        stack = new Stack();
                    }
                    stack.add(statement);
                }
            }
            if (stack != null) {
                while (!stack.isEmpty()) {
                    ((ServerPreparedStatement) stack.pop()).rePrepare();
                }
            }
        }
    }

    private void coreConnect(Properties properties) throws SQLException, IOException {
        String str;
        int portNumber;
        String property = properties.getProperty(NonRegisteringDriver.PROTOCOL_PROPERTY_KEY);
        if (property == null) {
            String[] hostPortPair = NonRegisteringDriver.parseHostPortPair(this.hostPortPair);
            String strNormalizeHost = normalizeHost(hostPortPair[0]);
            if (hostPortPair[1] != null) {
                portNumber = parsePortNumber(hostPortPair[1]);
                str = strNormalizeHost;
            } else {
                str = strNormalizeHost;
                portNumber = 3306;
            }
        } else if (!"tcp".equalsIgnoreCase(property) && "pipe".equalsIgnoreCase(property)) {
            setSocketFactoryClassName(NamedPipeSocketFactory.class.getName());
            String property2 = properties.getProperty(NonRegisteringDriver.PATH_PROPERTY_KEY);
            if (property2 != null) {
                properties.setProperty(NamedPipeSocketFactory.NAMED_PIPE_PROP_NAME, property2);
            }
            str = "localhost";
            portNumber = 3306;
        } else {
            String strNormalizeHost2 = normalizeHost(properties.getProperty(NonRegisteringDriver.HOST_PROPERTY_KEY));
            int portNumber2 = parsePortNumber(properties.getProperty(NonRegisteringDriver.PORT_PROPERTY_KEY, "3306"));
            str = strNormalizeHost2;
            portNumber = portNumber2;
        }
        this.port = portNumber;
        this.host = str;
        this.sessionMaxRows = -1;
        HashMap map = new HashMap();
        this.serverVariables = map;
        map.put("character_set_server", "utf8");
        MysqlIO mysqlIO = new MysqlIO(str, portNumber, properties, getSocketFactoryClassName(), getProxy(), getSocketTimeout(), this.largeRowSizeThreshold.getValueAsInt());
        this.f79io = mysqlIO;
        mysqlIO.doHandshake(this.user, this.password, this.database);
        if (versionMeetsMinimum(5, 5, 0)) {
            this.errorMessageEncoding = this.f79io.getEncodingForHandshake();
        }
    }

    private void createConfigCacheIfNeeded() throws SQLException {
        synchronized (getConnectionMutex()) {
            if (this.serverConfigCache != null) {
                return;
            }
            try {
                this.serverConfigCache = ((CacheAdapterFactory) Class.forName(getServerConfigCacheFactory()).newInstance()).getInstance(this, this.myURL, Integer.MAX_VALUE, Integer.MAX_VALUE, this.props);
                ExceptionInterceptor exceptionInterceptor = new ExceptionInterceptor() { // from class: com.mysql.jdbc.ConnectionImpl.4
                    @Override // com.mysql.jdbc.Extension
                    public void destroy() {
                    }

                    @Override // com.mysql.jdbc.Extension
                    public void init(Connection connection, Properties properties) throws SQLException {
                    }

                    @Override // com.mysql.jdbc.ExceptionInterceptor
                    public SQLException interceptException(SQLException sQLException, Connection connection) {
                        if (sQLException.getSQLState() == null || !sQLException.getSQLState().startsWith("08")) {
                            return null;
                        }
                        ConnectionImpl.this.serverConfigCache.invalidate(ConnectionImpl.this.getURL());
                        return null;
                    }
                };
                ExceptionInterceptor exceptionInterceptor2 = this.exceptionInterceptor;
                if (exceptionInterceptor2 == null) {
                    this.exceptionInterceptor = exceptionInterceptor;
                } else {
                    ((ExceptionInterceptorChain) exceptionInterceptor2).addRingZero(exceptionInterceptor);
                }
            } catch (ClassNotFoundException e) {
                SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(Messages.getString("Connection.CantFindCacheFactory", new Object[]{getParseInfoCacheFactory(), "parseInfoCacheFactory"}), getExceptionInterceptor());
                sQLExceptionCreateSQLException.initCause(e);
                throw sQLExceptionCreateSQLException;
            } catch (IllegalAccessException e2) {
                SQLException sQLExceptionCreateSQLException2 = SQLError.createSQLException(Messages.getString("Connection.CantLoadCacheFactory", new Object[]{getParseInfoCacheFactory(), "parseInfoCacheFactory"}), getExceptionInterceptor());
                sQLExceptionCreateSQLException2.initCause(e2);
                throw sQLExceptionCreateSQLException2;
            } catch (InstantiationException e3) {
                SQLException sQLExceptionCreateSQLException3 = SQLError.createSQLException(Messages.getString("Connection.CantLoadCacheFactory", new Object[]{getParseInfoCacheFactory(), "parseInfoCacheFactory"}), getExceptionInterceptor());
                sQLExceptionCreateSQLException3.initCause(e3);
                throw sQLExceptionCreateSQLException3;
            }
        }
    }

    private void createInitialHistogram(long[] jArr, long j, long j2) {
        double d = ((j2 - j) / 20.0d) * 1.25d;
        if (d < 1.0d) {
            d = 1.0d;
        }
        for (int i = 0; i < 20; i++) {
            jArr[i] = j;
            j = (long) (j + d);
        }
    }

    private void createPreparedStatementCaches() throws SQLException {
        synchronized (getConnectionMutex()) {
            int preparedStatementCacheSize = getPreparedStatementCacheSize();
            try {
                try {
                    this.cachedPreparedStatementParams = ((CacheAdapterFactory) Class.forName(getParseInfoCacheFactory()).newInstance()).getInstance(this, this.myURL, getPreparedStatementCacheSize(), getPreparedStatementCacheSqlLimit(), this.props);
                    if (getUseServerPreparedStmts()) {
                        this.serverSideStatementCheckCache = new LRUCache<>(preparedStatementCacheSize);
                        this.serverSideStatementCache = new LRUCache<CompoundCacheKey, ServerPreparedStatement>(preparedStatementCacheSize) { // from class: com.mysql.jdbc.ConnectionImpl.3
                            private static final long serialVersionUID = 7692318650375988114L;

                            @Override // com.mysql.jdbc.util.LRUCache, java.util.LinkedHashMap
                            public boolean removeEldestEntry(Map.Entry<CompoundCacheKey, ServerPreparedStatement> entry) {
                                if (this.maxElements <= 1) {
                                    return false;
                                }
                                boolean zRemoveEldestEntry = super.removeEldestEntry(entry);
                                if (zRemoveEldestEntry) {
                                    ServerPreparedStatement value = entry.getValue();
                                    value.isCached = false;
                                    value.setClosed(false);
                                    try {
                                        value.close();
                                    } catch (SQLException unused) {
                                    }
                                }
                                return zRemoveEldestEntry;
                            }
                        };
                    }
                } catch (ClassNotFoundException e) {
                    SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(Messages.getString("Connection.CantFindCacheFactory", new Object[]{getParseInfoCacheFactory(), "parseInfoCacheFactory"}), getExceptionInterceptor());
                    sQLExceptionCreateSQLException.initCause(e);
                    throw sQLExceptionCreateSQLException;
                } catch (IllegalAccessException e2) {
                    SQLException sQLExceptionCreateSQLException2 = SQLError.createSQLException(Messages.getString("Connection.CantLoadCacheFactory", new Object[]{getParseInfoCacheFactory(), "parseInfoCacheFactory"}), getExceptionInterceptor());
                    sQLExceptionCreateSQLException2.initCause(e2);
                    throw sQLExceptionCreateSQLException2;
                }
            } catch (InstantiationException e3) {
                SQLException sQLExceptionCreateSQLException3 = SQLError.createSQLException(Messages.getString("Connection.CantLoadCacheFactory", new Object[]{getParseInfoCacheFactory(), "parseInfoCacheFactory"}), getExceptionInterceptor());
                sQLExceptionCreateSQLException3.initCause(e3);
                throw sQLExceptionCreateSQLException3;
            }
        }
    }

    public static Connection getInstance(String str, int i, Properties properties, String str2, String str3) throws SQLException {
        return !Util.isJdbc4() ? new ConnectionImpl(str, i, properties, str2, str3) : (Connection) Util.handleNewInstance(JDBC_4_CONNECTION_CTOR, new Object[]{str, Integer.valueOf(i), properties, str2, str3}, null);
    }

    public static synchronized int getNextRoundRobinHostIndex(String str, List<?> list) {
        return random.nextInt(list.size());
    }

    private MySQLConnection getProxy() {
        MySQLConnection mySQLConnection = this.proxy;
        return mySQLConnection != null ? mySQLConnection : this;
    }

    private int getServerVariableAsInt(String str, int i) throws SQLException {
        try {
            return Integer.parseInt(this.serverVariables.get(str));
        } catch (NumberFormatException unused) {
            getLog().logWarn(Messages.getString("Connection.BadValueInServerVariables", new Object[]{str, this.serverVariables.get(str), Integer.valueOf(i)}));
            return i;
        }
    }

    private void handleAutoCommitDefaults() throws Throwable {
        java.sql.Statement metadataSafeStatement;
        boolean z = false;
        if (!getElideSetAutoCommits()) {
            String str = this.serverVariables.get("init_connect");
            if (!versionMeetsMinimum(4, 1, 2) || str == null || str.length() <= 0) {
                z = true;
            } else {
                ResultSet resultSetExecuteQuery = null;
                try {
                    metadataSafeStatement = getMetadataSafeStatement();
                    try {
                        resultSetExecuteQuery = metadataSafeStatement.executeQuery("SELECT @@session.autocommit");
                        if (resultSetExecuteQuery.next()) {
                            boolean z2 = resultSetExecuteQuery.getBoolean(1);
                            this.autoCommit = z2;
                            z = !z2;
                        }
                        if (resultSetExecuteQuery != null) {
                            try {
                                resultSetExecuteQuery.close();
                            } catch (SQLException unused) {
                            }
                        }
                        if (metadataSafeStatement != null) {
                            try {
                                metadataSafeStatement.close();
                            } catch (SQLException unused2) {
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (resultSetExecuteQuery != null) {
                            try {
                                resultSetExecuteQuery.close();
                            } catch (SQLException unused3) {
                            }
                        }
                        if (metadataSafeStatement == null) {
                            throw th;
                        }
                        try {
                            metadataSafeStatement.close();
                            throw th;
                        } catch (SQLException unused4) {
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    metadataSafeStatement = null;
                }
            }
        } else if (getIO().isSetNeededForAutoCommitMode(true)) {
            this.autoCommit = false;
            z = true;
        }
        if (z) {
            try {
                setAutoCommit(true);
            } catch (SQLException e) {
                if (e.getErrorCode() != 1820 || getDisconnectOnExpiredPasswords()) {
                    throw e;
                }
            }
        }
    }

    private void initializeDriverProperties(Properties properties) throws SQLException {
        initializeProperties(properties);
        String exceptionInterceptors = getExceptionInterceptors();
        if (exceptionInterceptors != null && !BuildConfig.FLAVOR.equals(exceptionInterceptors)) {
            this.exceptionInterceptor = new ExceptionInterceptorChain(exceptionInterceptors);
        }
        this.usePlatformCharsetConverters = getUseJvmCharsetConverters();
        this.log = LogFactory.getLogger(getLogger(), LOGGER_INSTANCE_NAME, getExceptionInterceptor());
        if (getProfileSql() || getUseUsageAdvisor()) {
            this.eventSink = ProfilerEventHandlerFactory.getInstance(getMultiHostSafeProxy());
        }
        if (getCachePreparedStatements()) {
            createPreparedStatementCaches();
        }
        if (getNoDatetimeStringSync() && getUseTimezone()) {
            throw SQLError.createSQLException("Can't enable noDatetimeStringSync and useTimezone configuration properties at the same time", SQLError.SQL_STATE_INVALID_CONNECTION_ATTRIBUTE, getExceptionInterceptor());
        }
        if (getCacheCallableStatements()) {
            this.parsedCallableStatementCache = new LRUCache<>(getCallableStatementCacheSize());
        }
        if (getAllowMultiQueries()) {
            setCacheResultSetMetadata(false);
        }
        if (getCacheResultSetMetadata()) {
            this.resultSetMetadataCache = new LRUCache<>(getMetadataCacheSize());
        }
        if (getSocksProxyHost() != null) {
            setSocketFactoryClassName("com.mysql.jdbc.SocksProxySocketFactory");
        }
    }

    private void initializePropsFromServer() throws Throwable {
        String connectionLifecycleInterceptors = getConnectionLifecycleInterceptors();
        this.connectionLifecycleInterceptors = null;
        if (connectionLifecycleInterceptors != null) {
            this.connectionLifecycleInterceptors = Util.loadExtensions(this, this.props, connectionLifecycleInterceptors, "Connection.badLifecycleInterceptor", getExceptionInterceptor());
        }
        setSessionVariables();
        if (!versionMeetsMinimum(4, 1, 0)) {
            setTransformedBitIsBoolean(false);
        }
        this.parserKnowsUnicode = versionMeetsMinimum(4, 1, 0);
        if (getUseServerPreparedStmts() && versionMeetsMinimum(4, 1, 0)) {
            this.useServerPreparedStmts = true;
            if (versionMeetsMinimum(5, 0, 0) && !versionMeetsMinimum(5, 0, 3)) {
                this.useServerPreparedStmts = false;
            }
        }
        if (versionMeetsMinimum(3, 21, 22)) {
            loadServerVariables();
            if (versionMeetsMinimum(5, 0, 2)) {
                this.autoIncrementIncrement = getServerVariableAsInt("auto_increment_increment", 1);
            } else {
                this.autoIncrementIncrement = 1;
            }
            buildCollationMapping();
            if (this.f79io.serverCharsetIndex == 0) {
                String str = this.serverVariables.get("collation_server");
                if (str != null) {
                    int i = 1;
                    while (true) {
                        String[] strArr = CharsetMapping.COLLATION_INDEX_TO_COLLATION_NAME;
                        if (i >= strArr.length) {
                            break;
                        }
                        if (strArr[i].equals(str)) {
                            this.f79io.serverCharsetIndex = i;
                            break;
                        }
                        i++;
                    }
                } else {
                    this.f79io.serverCharsetIndex = 45;
                }
            }
            LicenseConfiguration.checkLicenseType(this.serverVariables);
            String str2 = this.serverVariables.get("lower_case_table_names");
            this.lowerCaseTableNames = "on".equalsIgnoreCase(str2) || DiskLruCache.VERSION_1.equalsIgnoreCase(str2) || "2".equalsIgnoreCase(str2);
            this.storesLowerCaseTableName = DiskLruCache.VERSION_1.equalsIgnoreCase(str2) || "on".equalsIgnoreCase(str2);
            configureTimezone();
            if (this.serverVariables.containsKey("max_allowed_packet")) {
                int serverVariableAsInt = getServerVariableAsInt("max_allowed_packet", -1);
                if (serverVariableAsInt != -1 && (serverVariableAsInt < getMaxAllowedPacket() || getMaxAllowedPacket() <= 0)) {
                    setMaxAllowedPacket(serverVariableAsInt);
                } else if (serverVariableAsInt == -1 && getMaxAllowedPacket() == -1) {
                    setMaxAllowedPacket(Settings.DEFAULT_INITIAL_WINDOW_SIZE);
                }
                if (getUseServerPrepStmts()) {
                    int iMin = Math.min(getBlobSendChunkSize(), getMaxAllowedPacket()) - 8203;
                    if (iMin <= 0) {
                        throw SQLError.createSQLException("Connection setting too low for 'maxAllowedPacket'. When 'useServerPrepStmts=true', 'maxAllowedPacket' must be higher than 8203. Check also 'max_allowed_packet' in MySQL configuration files.", SQLError.SQL_STATE_INVALID_CONNECTION_ATTRIBUTE, getExceptionInterceptor());
                    }
                    setBlobSendChunkSize(String.valueOf(iMin));
                }
            }
            if (this.serverVariables.containsKey("net_buffer_length")) {
                this.netBufferLength = getServerVariableAsInt("net_buffer_length", 16384);
            }
            checkTransactionIsolationLevel();
            if (!versionMeetsMinimum(4, 1, 0)) {
                checkServerEncoding();
            }
            this.f79io.checkForCharsetMismatch();
            if (this.serverVariables.containsKey("sql_mode")) {
                String str3 = this.serverVariables.get("sql_mode");
                if (StringUtils.isStrictlyNumeric(str3)) {
                    this.useAnsiQuotes = (Integer.parseInt(str3) & 4) > 0;
                } else if (str3 != null) {
                    this.useAnsiQuotes = str3.indexOf("ANSI_QUOTES") != -1;
                    this.noBackslashEscapes = str3.indexOf("NO_BACKSLASH_ESCAPES") != -1;
                    this.serverTruncatesFracSecs = str3.indexOf("TIME_TRUNCATE_FRACTIONAL") != -1;
                }
            }
        }
        configureClientCharacterSet(false);
        try {
            this.errorMessageEncoding = CharsetMapping.getCharacterEncodingForErrorMessages(this);
            if (versionMeetsMinimum(3, 23, 15)) {
                this.transactionsSupported = true;
                handleAutoCommitDefaults();
            } else {
                this.transactionsSupported = false;
            }
            if (versionMeetsMinimum(3, 23, 36)) {
                this.hasIsolationLevels = true;
            } else {
                this.hasIsolationLevels = false;
            }
            this.hasQuotedIdentifiers = versionMeetsMinimum(3, 23, 6);
            this.f79io.resetMaxBuf();
            if (this.f79io.versionMeetsMinimum(4, 1, 0)) {
                String str4 = this.serverVariables.get(JDBC_LOCAL_CHARACTER_SET_RESULTS);
                if (str4 == null || StringUtils.startsWithIgnoreCaseAndWs(str4, "NULL") || str4.length() == 0) {
                    String str5 = this.serverVariables.get("character_set_system");
                    this.characterSetMetadata = str5 != null ? CharsetMapping.getJavaEncodingForMysqlCharset(str5) : "UTF-8";
                } else {
                    String javaEncodingForMysqlCharset = CharsetMapping.getJavaEncodingForMysqlCharset(str4);
                    this.characterSetResultsOnServer = javaEncodingForMysqlCharset;
                    this.characterSetMetadata = javaEncodingForMysqlCharset;
                }
            } else {
                this.characterSetMetadata = getEncoding();
            }
            if (versionMeetsMinimum(4, 1, 0) && !versionMeetsMinimum(4, 1, 10) && getAllowMultiQueries() && isQueryCacheEnabled()) {
                setAllowMultiQueries(false);
            }
            if (versionMeetsMinimum(5, 0, 0) && ((getUseLocalTransactionState() || getElideSetAutoCommits()) && isQueryCacheEnabled() && !versionMeetsMinimum(5, 1, 32))) {
                setUseLocalTransactionState(false);
                setElideSetAutoCommits(false);
            }
            setupServerForTruncationChecks();
        } catch (RuntimeException e) {
            SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(e.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
            sQLExceptionCreateSQLException.initCause(e);
            throw sQLExceptionCreateSQLException;
        } catch (SQLException e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:115:0x0219 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:120:0x0212 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.sql.ResultSet] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.sql.ResultSet] */
    /* JADX WARN: Type inference failed for: r3v16, types: [java.sql.ResultSet] */
    /* JADX WARN: Type inference failed for: r3v38, types: [java.sql.ResultSet] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.StringBuilder] */
    private void loadServerVariables() throws Throwable {
        java.sql.Statement metadataSafeStatement;
        SQLException sQLException;
        if (getCacheServerConfiguration()) {
            createConfigCacheIfNeeded();
            Map<String, String> map = this.serverConfigCache.get(getURL());
            if (map != null) {
                String str = map.get(SERVER_VERSION_STRING_VAR_NAME);
                if (str != null && this.f79io.getServerVersion() != null && str.equals(this.f79io.getServerVersion())) {
                    this.serverVariables = map;
                    return;
                }
                this.serverConfigCache.invalidate(getURL());
            }
        }
        ResultSet resultSet = null;
        ?? r0 = 0;
        ?? r1 = 0;
        resultSet = null;
        java.sql.Statement statement = null;
        try {
            metadataSafeStatement = getMetadataSafeStatement();
            try {
                String driverVersion = this.dbmd.getDriverVersion();
                if (driverVersion != null && driverVersion.indexOf(42) != -1) {
                    StringBuilder sb = new StringBuilder(driverVersion.length() + 10);
                    for (int i = 0; i < driverVersion.length(); i++) {
                        char cCharAt = driverVersion.charAt(i);
                        if (cCharAt == '*') {
                            sb.append("[star]");
                        } else {
                            sb.append(cCharAt);
                        }
                    }
                    driverVersion = sb.toString();
                }
                ?? ExecuteQuery = (getParanoid() || driverVersion == null) ? BuildConfig.FLAVOR : "/* " + driverVersion + " */";
                this.serverVariables = new HashMap();
                boolean jdbcCompliantTruncation = getJdbcCompliantTruncation();
                setJdbcCompliantTruncation(false);
                try {
                    try {
                        try {
                            if (versionMeetsMinimum(5, 1, 0)) {
                                StringBuilder sb2 = new StringBuilder((String) ExecuteQuery);
                                sb2.append("SELECT");
                                sb2.append("  @@session.auto_increment_increment AS auto_increment_increment");
                                sb2.append(", @@character_set_client AS character_set_client");
                                sb2.append(", @@character_set_connection AS character_set_connection");
                                sb2.append(", @@character_set_results AS character_set_results");
                                sb2.append(", @@character_set_server AS character_set_server");
                                sb2.append(", @@collation_server AS collation_server");
                                sb2.append(", @@collation_connection AS collation_connection");
                                sb2.append(", @@init_connect AS init_connect");
                                sb2.append(", @@interactive_timeout AS interactive_timeout");
                                if (!versionMeetsMinimum(5, 5, 0)) {
                                    sb2.append(", @@language AS language");
                                }
                                sb2.append(", @@license AS license");
                                sb2.append(", @@lower_case_table_names AS lower_case_table_names");
                                sb2.append(", @@max_allowed_packet AS max_allowed_packet");
                                sb2.append(", @@net_buffer_length AS net_buffer_length");
                                sb2.append(", @@net_write_timeout AS net_write_timeout");
                                if (!versionMeetsMinimum(8, 0, 3)) {
                                    sb2.append(", @@query_cache_size AS query_cache_size");
                                    sb2.append(", @@query_cache_type AS query_cache_type");
                                }
                                sb2.append(", @@sql_mode AS sql_mode");
                                sb2.append(", @@system_time_zone AS system_time_zone");
                                sb2.append(", @@time_zone AS time_zone");
                                if (versionMeetsMinimum(8, 0, 3) || (versionMeetsMinimum(5, 7, 20) && !versionMeetsMinimum(8, 0, 0))) {
                                    sb2.append(", @@transaction_isolation AS transaction_isolation");
                                } else {
                                    sb2.append(", @@tx_isolation AS transaction_isolation");
                                }
                                sb2.append(", @@wait_timeout AS wait_timeout");
                                ExecuteQuery = metadataSafeStatement.executeQuery(sb2.toString());
                                if (ExecuteQuery.next()) {
                                    java.sql.ResultSetMetaData metaData = ExecuteQuery.getMetaData();
                                    for (int i2 = 1; i2 <= metaData.getColumnCount(); i2++) {
                                        this.serverVariables.put(metaData.getColumnLabel(i2), ExecuteQuery.getString(i2));
                                    }
                                }
                            } else {
                                ExecuteQuery = metadataSafeStatement.executeQuery(ExecuteQuery + "SHOW VARIABLES");
                                while (ExecuteQuery.next()) {
                                    this.serverVariables.put(ExecuteQuery.getString(1), ExecuteQuery.getString(2));
                                }
                            }
                            ExecuteQuery.close();
                        } catch (SQLException e) {
                            ?? r11 = ExecuteQuery;
                            e = e;
                            r1 = r11;
                            if (e.getErrorCode() != 1820 || getDisconnectOnExpiredPasswords()) {
                                r0 = r1;
                                throw e;
                            }
                        } catch (Throwable th) {
                            th = th;
                            setJdbcCompliantTruncation(jdbcCompliantTruncation);
                            throw th;
                        }
                    } catch (SQLException e2) {
                        e = e2;
                    }
                    r0 = r1;
                    setJdbcCompliantTruncation(jdbcCompliantTruncation);
                    if (getCacheServerConfiguration()) {
                        this.serverVariables.put(SERVER_VERSION_STRING_VAR_NAME, this.f79io.getServerVersion());
                        this.serverConfigCache.put(getURL(), this.serverVariables);
                    }
                    if (r0 != 0) {
                        try {
                            r0.close();
                        } catch (SQLException unused) {
                        }
                    }
                    if (metadataSafeStatement != null) {
                        try {
                            metadataSafeStatement.close();
                        } catch (SQLException unused2) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (SQLException e3) {
                statement = metadataSafeStatement;
                sQLException = e3;
                try {
                    throw sQLException;
                } catch (Throwable th3) {
                    metadataSafeStatement = statement;
                    resultSet = null;
                    th = th3;
                    if (resultSet != null) {
                        try {
                            resultSet.close();
                        } catch (SQLException unused3) {
                        }
                    }
                    if (metadataSafeStatement != null) {
                        throw th;
                    }
                    try {
                        metadataSafeStatement.close();
                        throw th;
                    } catch (SQLException unused4) {
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                if (resultSet != null) {
                    resultSet.close();
                }
                if (metadataSafeStatement != null) {
                    throw th;
                }
                metadataSafeStatement.close();
                throw th;
            }
        } catch (SQLException e4) {
            sQLException = e4;
        } catch (Throwable th5) {
            th = th5;
            metadataSafeStatement = null;
        }
    }

    private String normalizeHost(String str) {
        return (str == null || StringUtils.isEmptyOrWhitespaceOnly(str)) ? "localhost" : str;
    }

    private static boolean nullSafeCompare(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        return (str != null || str2 == null) && str != null && str.equals(str2);
    }

    private CallableStatement parseCallableStatement(String str) throws SQLException {
        String str2;
        boolean z;
        Object objEscapeSQL = EscapeProcessor.escapeSQL(str, serverSupportsConvertFn(), getMultiHostSafeProxy());
        if (objEscapeSQL instanceof EscapeProcessorResult) {
            EscapeProcessorResult escapeProcessorResult = (EscapeProcessorResult) objEscapeSQL;
            str2 = escapeProcessorResult.escapedSql;
            z = escapeProcessorResult.callingStoredFunction;
        } else {
            str2 = (String) objEscapeSQL;
            z = false;
        }
        return CallableStatement.getInstance(getMultiHostSafeProxy(), str2, this.database, z);
    }

    private int parsePortNumber(String str) throws SQLException {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            throw SQLError.createSQLException("Illegal connection port value '" + str + "'", SQLError.SQL_STATE_INVALID_CONNECTION_ATTRIBUTE, getExceptionInterceptor());
        }
    }

    private void repartitionHistogram(int[] iArr, long[] jArr, long j, long j2) {
        if (this.oldHistCounts == null) {
            this.oldHistCounts = new int[iArr.length];
            this.oldHistBreakpoints = new long[jArr.length];
        }
        System.arraycopy(iArr, 0, this.oldHistCounts, 0, iArr.length);
        System.arraycopy(jArr, 0, this.oldHistBreakpoints, 0, jArr.length);
        createInitialHistogram(jArr, j, j2);
        for (int i = 0; i < 20; i++) {
            addToHistogram(iArr, jArr, this.oldHistBreakpoints[i], this.oldHistCounts[i], j, j2);
        }
    }

    private void repartitionPerformanceHistogram() {
        checkAndCreatePerformanceHistogram();
        int[] iArr = this.perfMetricsHistCounts;
        long[] jArr = this.perfMetricsHistBreakpoints;
        long j = this.shortestQueryTimeMs;
        if (j == RecyclerView.FOREVER_NS) {
            j = 0;
        }
        repartitionHistogram(iArr, jArr, j, this.longestQueryTimeMs);
    }

    private void repartitionTablesAccessedHistogram() {
        checkAndCreateTablesAccessedHistogram();
        int[] iArr = this.numTablesMetricsHistCounts;
        long[] jArr = this.numTablesMetricsHistBreakpoints;
        long j = this.minimumNumberTablesAccessed;
        if (j == RecyclerView.FOREVER_NS) {
            j = 0;
        }
        repartitionHistogram(iArr, jArr, j, this.maximumNumberTablesAccessed);
    }

    private void reportMetrics() {
        String str;
        if (getGatherPerformanceMetrics()) {
            StringBuilder sb = new StringBuilder(256);
            sb.append("** Performance Metrics Report **\n");
            sb.append("\nLongest reported query: " + this.longestQueryTimeMs + " ms");
            sb.append("\nShortest reported query: " + this.shortestQueryTimeMs + " ms");
            sb.append("\nAverage query execution time: " + (this.totalQueryTimeMs / ((double) this.numberOfQueriesIssued)) + " ms");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\nNumber of statements executed: ");
            sb2.append(this.numberOfQueriesIssued);
            sb.append(sb2.toString());
            sb.append("\nNumber of result sets created: " + this.numberOfResultSetsCreated);
            sb.append("\nNumber of statements prepared: " + this.numberOfPrepares);
            sb.append("\nNumber of prepared statement executions: " + this.numberOfPreparedExecutes);
            String str2 = "\t";
            String str3 = "\n\tbetween ";
            int i = 19;
            if (this.perfMetricsHistBreakpoints != null) {
                sb.append("\n\n\tTiming Histogram:\n");
                int i2 = Integer.MIN_VALUE;
                for (int i3 = 0; i3 < 20; i3++) {
                    int[] iArr = this.perfMetricsHistCounts;
                    if (iArr[i3] > i2) {
                        i2 = iArr[i3];
                    }
                }
                if (i2 == 0) {
                    i2 = 1;
                }
                int i4 = 0;
                while (true) {
                    if (i4 >= i) {
                        str = str2;
                        str3 = str3;
                        break;
                    }
                    if (i4 == 0) {
                        sb.append("\n\tless than " + this.perfMetricsHistBreakpoints[i4 + 1] + " ms: \t" + this.perfMetricsHistCounts[i4]);
                    } else {
                        sb.append(str3 + this.perfMetricsHistBreakpoints[i4] + " and " + this.perfMetricsHistBreakpoints[i4 + 1] + " ms: \t" + this.perfMetricsHistCounts[i4]);
                    }
                    sb.append(str2);
                    str = str2;
                    int i5 = (int) (((double) 20) * (((double) this.perfMetricsHistCounts[i4]) / ((double) i2)));
                    for (int i6 = 0; i6 < i5; i6++) {
                        sb.append("*");
                    }
                    i4++;
                    if (this.longestQueryTimeMs < this.perfMetricsHistCounts[i4]) {
                        break;
                    }
                    str3 = str3;
                    str2 = str;
                    i = 19;
                }
                if (this.perfMetricsHistBreakpoints[18] < this.longestQueryTimeMs) {
                    sb.append(str3);
                    sb.append(this.perfMetricsHistBreakpoints[18]);
                    sb.append(" and ");
                    sb.append(this.perfMetricsHistBreakpoints[19]);
                    sb.append(" ms: \t");
                    sb.append(this.perfMetricsHistCounts[19]);
                }
            } else {
                str = "\t";
                str3 = "\n\tbetween ";
            }
            if (this.numTablesMetricsHistBreakpoints != null) {
                sb.append("\n\n\tTable Join Histogram:\n");
                int i7 = Integer.MIN_VALUE;
                for (int i8 = 0; i8 < 20; i8++) {
                    int[] iArr2 = this.numTablesMetricsHistCounts;
                    if (iArr2[i8] > i7) {
                        i7 = iArr2[i8];
                    }
                }
                if (i7 == 0) {
                    i7 = 1;
                }
                int i9 = 0;
                while (i9 < 19) {
                    if (i9 == 0) {
                        sb.append("\n\t" + this.numTablesMetricsHistBreakpoints[i9 + 1] + " tables or less: \t\t" + this.numTablesMetricsHistCounts[i9]);
                    } else {
                        sb.append(str3 + this.numTablesMetricsHistBreakpoints[i9] + " and " + this.numTablesMetricsHistBreakpoints[i9 + 1] + " tables: \t" + this.numTablesMetricsHistCounts[i9]);
                    }
                    String str4 = str;
                    sb.append(str4);
                    int i10 = (int) (((double) 20) * (((double) this.numTablesMetricsHistCounts[i9]) / ((double) i7)));
                    for (int i11 = 0; i11 < i10; i11++) {
                        sb.append("*");
                    }
                    i9++;
                    if (this.maximumNumberTablesAccessed < this.numTablesMetricsHistBreakpoints[i9]) {
                        break;
                    } else {
                        str = str4;
                    }
                }
                if (this.numTablesMetricsHistBreakpoints[18] < this.maximumNumberTablesAccessed) {
                    sb.append(str3);
                    sb.append(this.numTablesMetricsHistBreakpoints[18]);
                    sb.append(" and ");
                    sb.append(this.numTablesMetricsHistBreakpoints[19]);
                    sb.append(" tables: ");
                    sb.append(this.numTablesMetricsHistCounts[19]);
                }
            }
            this.log.logInfo(sb);
            this.metricsLastReportedMs = System.currentTimeMillis();
        }
    }

    private void rollbackNoChecks() throws SQLException {
        if (getUseLocalTransactionState() && versionMeetsMinimum(5, 0, 0) && !this.f79io.inTransactionOnServer()) {
            return;
        }
        execSQL(null, "rollback", -1, null, 1003, 1007, false, this.database, null, false);
    }

    private void setSessionVariables() throws SQLException {
        if (!versionMeetsMinimum(4, 0, 0) || getSessionVariables() == null) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList();
        Iterator<String> it = StringUtils.split(getSessionVariables(), ",", "\"'(", "\"')", "\"'", true).iterator();
        while (it.hasNext()) {
            arrayList.addAll(StringUtils.split(it.next(), ";", "\"'(", "\"')", "\"'", true));
        }
        if (arrayList.isEmpty()) {
            return;
        }
        java.sql.Statement metadataSafeStatement = null;
        try {
            metadataSafeStatement = getMetadataSafeStatement();
            StringBuilder sb = new StringBuilder("SET ");
            String str = BuildConfig.FLAVOR;
            for (String str2 : arrayList) {
                if (str2.length() > 0) {
                    sb.append(str);
                    if (!str2.startsWith("@")) {
                        sb.append("SESSION ");
                    }
                    sb.append(str2);
                    str = ",";
                }
            }
            metadataSafeStatement.executeUpdate(sb.toString());
        } finally {
            if (metadataSafeStatement != null) {
                metadataSafeStatement.close();
            }
        }
    }

    private void setupServerForTruncationChecks() throws SQLException {
        if (getJdbcCompliantTruncation() && versionMeetsMinimum(5, 0, 2)) {
            String str = this.serverVariables.get("sql_mode");
            boolean z = StringUtils.indexOfIgnoreCase(str, "STRICT_TRANS_TABLES") != -1;
            if (str != null && str.length() != 0 && z) {
                if (z) {
                    setJdbcCompliantTruncation(false);
                    return;
                }
                return;
            }
            StringBuilder sb = new StringBuilder("SET sql_mode='");
            if (str != null && str.length() > 0) {
                sb.append(str);
                sb.append(",");
            }
            sb.append("STRICT_TRANS_TABLES'");
            execSQL(null, sb.toString(), -1, null, 1003, 1007, false, this.database, null, false);
            setJdbcCompliantTruncation(false);
        }
    }

    @Override // com.mysql.jdbc.Connection
    public void abort(Executor executor) throws SQLException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(ABORT_PERM);
        }
        if (executor == null) {
            throw SQLError.createSQLException("Executor can not be null", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
        executor.execute(new Runnable() { // from class: com.mysql.jdbc.ConnectionImpl.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ConnectionImpl.this.abortInternal();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @Override // com.mysql.jdbc.Connection
    public void abortInternal() throws SQLException {
        MysqlIO mysqlIO = this.f79io;
        if (mysqlIO != null) {
            try {
                mysqlIO.forceClose();
                this.f79io.releaseResources();
            } catch (Throwable unused) {
            }
            this.f79io = null;
        }
        this.isClosed = true;
    }

    @Override // com.mysql.jdbc.Connection
    public void changeUser(String str, String str2) throws SQLException {
        synchronized (getConnectionMutex()) {
            checkClosed();
            if (str == null || str.equals(BuildConfig.FLAVOR)) {
                str = BuildConfig.FLAVOR;
            }
            if (str2 == null) {
                str2 = BuildConfig.FLAVOR;
            }
            this.sessionMaxRows = -1;
            try {
                this.f79io.changeUser(str, str2, this.database);
                this.user = str;
                this.password = str2;
                if (versionMeetsMinimum(4, 1, 0)) {
                    configureClientCharacterSet(true);
                }
                setSessionVariables();
                setupServerForTruncationChecks();
            } catch (SQLException e) {
                if (versionMeetsMinimum(5, 6, 13) && SQLError.SQL_STATE_INVALID_AUTH_SPEC.equals(e.getSQLState())) {
                    cleanup(e);
                }
                throw e;
            }
        }
    }

    @Override // com.mysql.jdbc.Connection
    public void checkClosed() throws SQLException {
        if (this.isClosed) {
            throwConnectionClosedException();
        }
    }

    @Override // com.mysql.jdbc.Connection
    @Deprecated
    public void clearHasTriedMaster() {
        this.hasTriedMasterFlag = false;
    }

    @Override // java.sql.Connection
    public void clearWarnings() throws SQLException {
    }

    @Override // com.mysql.jdbc.Connection
    public java.sql.PreparedStatement clientPrepareStatement(String str) throws SQLException {
        return clientPrepareStatement(str, 1003, 1007);
    }

    @Override // java.sql.Connection, java.lang.AutoCloseable
    public void close() throws SQLException {
        synchronized (getConnectionMutex()) {
            List<Extension> list = this.connectionLifecycleInterceptors;
            if (list != null) {
                new IterateBlock<Extension>(list.iterator()) { // from class: com.mysql.jdbc.ConnectionImpl.1
                    @Override // com.mysql.jdbc.IterateBlock
                    public void forEach(Extension extension) throws SQLException {
                        ((ConnectionLifecycleInterceptor) extension).close();
                    }
                }.doForAll();
            }
            realClose(true, true, false, null);
        }
    }

    @Override // java.sql.Connection
    public void commit() throws SQLException {
        synchronized (getConnectionMutex()) {
            checkClosed();
            try {
                try {
                    List<Extension> list = this.connectionLifecycleInterceptors;
                    if (list != null) {
                        IterateBlock<Extension> iterateBlock = new IterateBlock<Extension>(list.iterator()) { // from class: com.mysql.jdbc.ConnectionImpl.2
                            @Override // com.mysql.jdbc.IterateBlock
                            public void forEach(Extension extension) throws SQLException {
                                if (((ConnectionLifecycleInterceptor) extension).commit()) {
                                    return;
                                }
                                this.stopIterating = true;
                            }
                        };
                        iterateBlock.doForAll();
                        if (!iterateBlock.fullIteration()) {
                            this.needsPing = getReconnectAtTxEnd();
                            return;
                        }
                    }
                    if (this.autoCommit && !getRelaxAutoCommit()) {
                        throw SQLError.createSQLException("Can't call commit when autocommit=true", getExceptionInterceptor());
                    }
                    if (this.transactionsSupported) {
                        if (getUseLocalTransactionState() && versionMeetsMinimum(5, 0, 0) && !this.f79io.inTransactionOnServer()) {
                            this.needsPing = getReconnectAtTxEnd();
                            return;
                        }
                        execSQL(null, "commit", -1, null, 1003, 1007, false, this.database, null, false);
                    }
                    this.needsPing = getReconnectAtTxEnd();
                } catch (SQLException e) {
                    if (!SQLError.SQL_STATE_COMMUNICATION_LINK_FAILURE.equals(e.getSQLState())) {
                        throw e;
                    }
                    throw SQLError.createSQLException("Communications link failure during commit(). Transaction resolution unknown.", SQLError.SQL_STATE_TRANSACTION_RESOLUTION_UNKNOWN, getExceptionInterceptor());
                }
            } catch (Throwable th) {
                this.needsPing = getReconnectAtTxEnd();
                throw th;
            }
        }
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void createNewIO(boolean z) throws SQLException {
        synchronized (getConnectionMutex()) {
            Properties propertiesExposeAsProperties = exposeAsProperties(this.props);
            if (getHighAvailability()) {
                connectWithRetries(z, propertiesExposeAsProperties);
            } else {
                connectOneTryOnly(z, propertiesExposeAsProperties);
            }
        }
    }

    @Override // java.sql.Connection
    public java.sql.Statement createStatement() throws SQLException {
        return createStatement(1003, 1007);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void decachePreparedStatement(ServerPreparedStatement serverPreparedStatement) throws SQLException {
        synchronized (getConnectionMutex()) {
            if (getCachePreparedStatements() && serverPreparedStatement.isPoolable()) {
                synchronized (this.serverSideStatementCache) {
                    this.serverSideStatementCache.remove(new CompoundCacheKey(serverPreparedStatement.currentCatalog, serverPreparedStatement.originalSql));
                }
            }
        }
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void dumpTestcaseQuery(String str) {
        System.err.println(str);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public Connection duplicate() throws SQLException {
        return new ConnectionImpl(this.origHostToConnectTo, this.origPortToConnectTo, this.props, this.origDatabaseToConnectTo, this.myURL);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public ResultSetInternalMethods execSQL(StatementImpl statementImpl, String str, int i, Buffer buffer, int i2, int i3, boolean z, String str2, Field[] fieldArr) throws SQLException {
        return execSQL(statementImpl, str, i, buffer, i2, i3, z, str2, fieldArr, false);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public String extractSqlFromPacket(String str, Buffer buffer, int i) throws SQLException {
        boolean z = false;
        if (str == null) {
            str = null;
        } else if (str.length() > getMaxQuerySizeToLog()) {
            str = str.substring(0, getMaxQuerySizeToLog()) + Messages.getString("MysqlIO.25");
        }
        if (str != null) {
            return str;
        }
        if (i > getMaxQuerySizeToLog()) {
            i = getMaxQuerySizeToLog();
            z = true;
        }
        String string = StringUtils.toString(buffer.getByteBuffer(), 5, i - 5);
        if (!z) {
            return string;
        }
        return string + Messages.getString("MysqlIO.25");
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public StringBuilder generateConnectionCommentBlock(StringBuilder sb) {
        sb.append("/* conn id ");
        sb.append(getId());
        sb.append(" clock: ");
        sb.append(System.currentTimeMillis());
        sb.append(" */ ");
        return sb;
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public MySQLConnection getActiveMySQLConnection() {
        return this;
    }

    @Override // com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public int getActiveStatementCount() {
        return this.openStatements.size();
    }

    @Override // java.sql.Connection
    public boolean getAutoCommit() throws SQLException {
        boolean z;
        synchronized (getConnectionMutex()) {
            z = this.autoCommit;
        }
        return z;
    }

    @Override // com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public int getAutoIncrementIncrement() {
        return this.autoIncrementIncrement;
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public CachedResultSetMetaData getCachedMetaData(String str) {
        CachedResultSetMetaData cachedResultSetMetaData;
        LRUCache<String, CachedResultSetMetaData> lRUCache = this.resultSetMetadataCache;
        if (lRUCache == null) {
            return null;
        }
        synchronized (lRUCache) {
            cachedResultSetMetaData = this.resultSetMetadataCache.get(str);
        }
        return cachedResultSetMetaData;
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public Calendar getCalendarInstanceForSessionOrNew() {
        return getDynamicCalendars() ? Calendar.getInstance() : getSessionLockedCalendar();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public Timer getCancelTimer() {
        Timer timer;
        synchronized (getConnectionMutex()) {
            if (this.cancelTimer == null) {
                this.cancelTimer = new Timer("MySQL Statement Cancellation Timer", true);
            }
            timer = this.cancelTimer;
        }
        return timer;
    }

    @Override // java.sql.Connection
    public String getCatalog() throws SQLException {
        String str;
        synchronized (getConnectionMutex()) {
            str = this.database;
        }
        return str;
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public String getCharacterSetMetadata() {
        String str;
        synchronized (getConnectionMutex()) {
            str = this.characterSetMetadata;
        }
        return str;
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public SingleByteCharsetConverter getCharsetConverter(String str) throws SQLException {
        SingleByteCharsetConverter singleByteCharsetConverter = null;
        if (str == null || this.usePlatformCharsetConverters) {
            return null;
        }
        synchronized (this.charsetConverterMap) {
            Object obj = this.charsetConverterMap.get(str);
            Object obj2 = CHARSET_CONVERTER_NOT_AVAILABLE_MARKER;
            if (obj == obj2) {
                return null;
            }
            SingleByteCharsetConverter singleByteCharsetConverter2 = (SingleByteCharsetConverter) obj;
            if (singleByteCharsetConverter2 == null) {
                try {
                    singleByteCharsetConverter2 = SingleByteCharsetConverter.getInstance(str, this);
                    if (singleByteCharsetConverter2 == null) {
                        this.charsetConverterMap.put(str, obj2);
                    } else {
                        this.charsetConverterMap.put(str, singleByteCharsetConverter2);
                    }
                } catch (UnsupportedEncodingException unused) {
                    this.charsetConverterMap.put(str, CHARSET_CONVERTER_NOT_AVAILABLE_MARKER);
                }
            }
            singleByteCharsetConverter = singleByteCharsetConverter2;
            return singleByteCharsetConverter;
        }
    }

    @Override // com.mysql.jdbc.MySQLConnection
    @Deprecated
    public String getCharsetNameForIndex(int i) throws SQLException {
        return getEncodingForIndex(i);
    }

    @Override // com.mysql.jdbc.Connection
    public Object getConnectionMutex() {
        InvocationHandler invocationHandler = this.realProxy;
        return invocationHandler != null ? invocationHandler : getProxy();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public TimeZone getDefaultTimeZone() {
        return getCacheDefaultTimezone() ? this.defaultTimeZone : TimeUtil.getDefaultTimeZone(false);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public String getEncodingForIndex(int i) throws SQLException {
        String str;
        if (getUseOldUTF8Behavior()) {
            return getEncoding();
        }
        if (i == -1) {
            return getEncoding();
        }
        try {
            Map<Integer, String> map = this.indexToCustomMysqlCharset;
            String javaEncodingForMysqlCharset = (map == null || (str = map.get(Integer.valueOf(i))) == null) ? null : CharsetMapping.getJavaEncodingForMysqlCharset(str, getEncoding());
            if (javaEncodingForMysqlCharset == null) {
                javaEncodingForMysqlCharset = CharsetMapping.getJavaEncodingForCollationIndex(Integer.valueOf(i), getEncoding());
            }
            return javaEncodingForMysqlCharset == null ? getEncoding() : javaEncodingForMysqlCharset;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw SQLError.createSQLException("Unknown character set index for field '" + i + "' received from server.", SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
        } catch (RuntimeException e) {
            SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(e.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
            sQLExceptionCreateSQLException.initCause(e);
            throw sQLExceptionCreateSQLException;
        }
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public String getErrorMessageEncoding() {
        return this.errorMessageEncoding;
    }

    @Override // com.mysql.jdbc.ConnectionPropertiesImpl, com.mysql.jdbc.ConnectionProperties, com.mysql.jdbc.MySQLConnection
    public ExceptionInterceptor getExceptionInterceptor() {
        return this.exceptionInterceptor;
    }

    @Override // java.sql.Connection
    public int getHoldability() throws SQLException {
        return 2;
    }

    @Override // com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public String getHost() {
        return this.host;
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public String getHostPortPair() {
        String str = this.hostPortPair;
        if (str != null) {
            return str;
        }
        return this.host + ":" + this.port;
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public MysqlIO getIO() throws SQLException {
        MysqlIO mysqlIO = this.f79io;
        if (mysqlIO == null || this.isClosed) {
            throw SQLError.createSQLException("Operation not allowed on closed connection", SQLError.SQL_STATE_CONNECTION_NOT_OPEN, getExceptionInterceptor());
        }
        return mysqlIO;
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public long getId() {
        return this.connectionId;
    }

    @Override // com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public long getIdleFor() {
        synchronized (getConnectionMutex()) {
            if (this.lastQueryFinishedTime == 0) {
                return 0L;
            }
            return System.currentTimeMillis() - this.lastQueryFinishedTime;
        }
    }

    @Override // com.mysql.jdbc.MySQLConnection
    @Deprecated
    public MySQLConnection getLoadBalanceSafeProxy() {
        return getMultiHostSafeProxy();
    }

    @Override // com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public Log getLog() throws SQLException {
        return this.log;
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public int getMaxBytesPerChar(String str) throws SQLException {
        return getMaxBytesPerChar(null, str);
    }

    @Override // java.sql.Connection
    public java.sql.DatabaseMetaData getMetaData() throws SQLException {
        return getMetaData(true, true);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public java.sql.Statement getMetadataSafeStatement() throws SQLException {
        return getMetadataSafeStatement(0);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public MySQLConnection getMultiHostSafeProxy() {
        return getProxy();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public int getNetBufferLength() {
        return this.netBufferLength;
    }

    @Override // com.mysql.jdbc.Connection
    public int getNetworkTimeout() throws SQLException {
        int socketTimeout;
        synchronized (getConnectionMutex()) {
            checkClosed();
            socketTimeout = getSocketTimeout();
        }
        return socketTimeout;
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public ProfilerEventHandler getProfilerEventHandlerInstance() {
        return this.eventSink;
    }

    @Override // com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public Properties getProperties() {
        return this.props;
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public boolean getRequiresEscapingEncoder() {
        return this.requiresEscapingEncoder;
    }

    @Override // com.mysql.jdbc.Connection
    public String getSchema() throws SQLException {
        synchronized (getConnectionMutex()) {
            checkClosed();
        }
        return null;
    }

    @Override // com.mysql.jdbc.Connection
    @Deprecated
    public String getServerCharacterEncoding() {
        return getServerCharset();
    }

    @Override // com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public String getServerCharset() {
        if (!this.f79io.versionMeetsMinimum(4, 1, 0)) {
            return this.serverVariables.get("character_set");
        }
        Map<Integer, String> map = this.indexToCustomMysqlCharset;
        String mysqlCharsetNameForCollationIndex = map != null ? map.get(Integer.valueOf(this.f79io.serverCharsetIndex)) : null;
        if (mysqlCharsetNameForCollationIndex == null) {
            mysqlCharsetNameForCollationIndex = CharsetMapping.getMysqlCharsetNameForCollationIndex(Integer.valueOf(this.f79io.serverCharsetIndex));
        }
        return mysqlCharsetNameForCollationIndex != null ? mysqlCharsetNameForCollationIndex : this.serverVariables.get("character_set_server");
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public int getServerMajorVersion() {
        return this.f79io.getServerMajorVersion();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public int getServerMinorVersion() {
        return this.f79io.getServerMinorVersion();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public int getServerSubMinorVersion() {
        return this.f79io.getServerSubMinorVersion();
    }

    @Override // com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public TimeZone getServerTimezoneTZ() {
        return this.serverTimezoneTZ;
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public String getServerVariable(String str) {
        Map<String, String> map = this.serverVariables;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public String getServerVersion() {
        return this.f79io.getServerVersion();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public Calendar getSessionLockedCalendar() {
        return this.sessionCalendar;
    }

    @Override // com.mysql.jdbc.Connection
    public int getSessionMaxRows() {
        int i;
        synchronized (getConnectionMutex()) {
            i = this.sessionMaxRows;
        }
        return i;
    }

    @Override // com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public String getStatementComment() {
        return this.statementComment;
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public List<StatementInterceptorV2> getStatementInterceptorsInstances() {
        return this.statementInterceptors;
    }

    @Override // java.sql.Connection
    public int getTransactionIsolation() throws SQLException {
        java.sql.Statement metadataSafeStatement;
        Integer num;
        synchronized (getConnectionMutex()) {
            if (!this.hasIsolationLevels || getUseLocalSessionState()) {
                return this.isolationLevel;
            }
            ResultSet resultSet = null;
            try {
                metadataSafeStatement = getMetadataSafeStatement(this.sessionMaxRows);
                try {
                    ResultSet resultSetExecuteQuery = metadataSafeStatement.executeQuery((versionMeetsMinimum(8, 0, 3) || (versionMeetsMinimum(5, 7, 20) && !versionMeetsMinimum(8, 0, 0))) ? "SELECT @@session.transaction_isolation" : "SELECT @@session.tx_isolation");
                    if (!resultSetExecuteQuery.next()) {
                        throw SQLError.createSQLException("Could not retrieve transaction isolation level from server", SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
                    }
                    String string = resultSetExecuteQuery.getString(1);
                    if (string == null || (num = mapTransIsolationNameToValue.get(string)) == null) {
                        throw SQLError.createSQLException("Could not map transaction isolation '" + string + " to a valid JDBC level.", SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
                    }
                    int iIntValue = num.intValue();
                    this.isolationLevel = iIntValue;
                    if (resultSetExecuteQuery != null) {
                        try {
                            resultSetExecuteQuery.close();
                        } catch (Exception unused) {
                        }
                    }
                    if (metadataSafeStatement != null) {
                        try {
                            metadataSafeStatement.close();
                        } catch (Exception unused2) {
                        }
                    }
                    return iIntValue;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            resultSet.close();
                        } catch (Exception unused3) {
                        }
                    }
                    if (metadataSafeStatement == null) {
                        throw th;
                    }
                    try {
                        metadataSafeStatement.close();
                        throw th;
                    } catch (Exception unused4) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                metadataSafeStatement = null;
            }
        }
    }

    @Override // java.sql.Connection
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        Map<String, Class<?>> map;
        synchronized (getConnectionMutex()) {
            if (this.typeMap == null) {
                this.typeMap = new HashMap();
            }
            map = this.typeMap;
        }
        return map;
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public String getURL() {
        return this.myURL;
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public String getUser() {
        return this.user;
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public Calendar getUtcCalendar() {
        return this.utcCalendar;
    }

    @Override // java.sql.Connection
    public SQLWarning getWarnings() throws SQLException {
        return null;
    }

    @Override // com.mysql.jdbc.Connection
    public boolean hasSameProperties(Connection connection) {
        return this.props.equals(connection.getProperties());
    }

    @Override // com.mysql.jdbc.Connection
    @Deprecated
    public boolean hasTriedMaster() {
        return this.hasTriedMasterFlag;
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void incrementNumberOfPreparedExecutes() {
        if (getGatherPerformanceMetrics()) {
            this.numberOfPreparedExecutes++;
            this.numberOfQueriesIssued++;
        }
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void incrementNumberOfPrepares() {
        if (getGatherPerformanceMetrics()) {
            this.numberOfPrepares++;
        }
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void incrementNumberOfResultSetsCreated() {
        if (getGatherPerformanceMetrics()) {
            this.numberOfResultSetsCreated++;
        }
    }

    @Override // com.mysql.jdbc.Connection
    public void initializeExtension(Extension extension) throws SQLException {
        extension.init(this, this.props);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void initializeResultsMetadataFromCache(String str, CachedResultSetMetaData cachedResultSetMetaData, ResultSetInternalMethods resultSetInternalMethods) throws SQLException {
        if (cachedResultSetMetaData != null) {
            resultSetInternalMethods.initializeFromCachedMetaData(cachedResultSetMetaData);
            resultSetInternalMethods.initializeWithMetadata();
            if (resultSetInternalMethods instanceof UpdatableResultSet) {
                ((UpdatableResultSet) resultSetInternalMethods).checkUpdatability();
                return;
            }
            return;
        }
        CachedResultSetMetaData cachedResultSetMetaData2 = new CachedResultSetMetaData();
        resultSetInternalMethods.buildIndexMapping();
        resultSetInternalMethods.initializeWithMetadata();
        if (resultSetInternalMethods instanceof UpdatableResultSet) {
            ((UpdatableResultSet) resultSetInternalMethods).checkUpdatability();
        }
        resultSetInternalMethods.populateCachedMetaData(cachedResultSetMetaData2);
        this.resultSetMetadataCache.put(str, cachedResultSetMetaData2);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void initializeSafeStatementInterceptors() throws SQLException {
        this.isClosed = false;
        List<Extension> listLoadExtensions = Util.loadExtensions(this, this.props, getStatementInterceptors(), "MysqlIo.BadStatementInterceptor", getExceptionInterceptor());
        this.statementInterceptors = new ArrayList(listLoadExtensions.size());
        for (int i = 0; i < listLoadExtensions.size(); i++) {
            Extension extension = listLoadExtensions.get(i);
            if (!(extension instanceof StatementInterceptor)) {
                this.statementInterceptors.add(new NoSubInterceptorWrapper((StatementInterceptorV2) extension));
            } else if (ReflectiveStatementInterceptorAdapter.getV2PostProcessMethod(extension.getClass()) != null) {
                this.statementInterceptors.add(new NoSubInterceptorWrapper(new ReflectiveStatementInterceptorAdapter((StatementInterceptor) extension)));
            } else {
                this.statementInterceptors.add(new NoSubInterceptorWrapper(new V1toV2StatementInterceptorAdapter((StatementInterceptor) extension)));
            }
        }
    }

    @Override // com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public boolean isAbonormallyLongQuery(long j) {
        synchronized (getConnectionMutex()) {
            long j2 = this.queryTimeCount;
            if (j2 < 15) {
                return false;
            }
            double d = this.queryTimeSumSquares;
            double d2 = this.queryTimeSum;
            return ((double) j) > this.queryTimeMean + (Math.sqrt((d - ((d2 * d2) / ((double) j2))) / ((double) (j2 - 1))) * 5.0d);
        }
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public boolean isClientTzUTC() {
        return this.isClientTzUTC;
    }

    @Override // java.sql.Connection
    public boolean isClosed() {
        return this.isClosed;
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public boolean isCursorFetchEnabled() throws SQLException {
        return versionMeetsMinimum(5, 0, 2) && getUseCursorFetch();
    }

    @Override // com.mysql.jdbc.Connection
    public boolean isInGlobalTx() {
        return this.isInGlobalTx;
    }

    @Override // com.mysql.jdbc.Connection
    public boolean isMasterConnection() {
        return false;
    }

    @Override // com.mysql.jdbc.Connection
    public boolean isNoBackslashEscapesSet() {
        return this.noBackslashEscapes;
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public boolean isProxySet() {
        return this.proxy != null;
    }

    public boolean isQueryCacheEnabled() {
        return "ON".equalsIgnoreCase(this.serverVariables.get("query_cache_type")) && !"0".equalsIgnoreCase(this.serverVariables.get("query_cache_size"));
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public boolean isReadInfoMsgEnabled() {
        return this.readInfoMsg;
    }

    @Override // com.mysql.jdbc.MySQLConnection, java.sql.Connection
    public boolean isReadOnly() throws SQLException {
        return isReadOnly(true);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public boolean isRunningOnJDK13() {
        return this.isRunningOnJDK13;
    }

    @Override // com.mysql.jdbc.Connection
    public boolean isSameResource(Connection connection) {
        synchronized (getConnectionMutex()) {
            try {
                if (connection == null) {
                    return false;
                }
                String str = ((ConnectionImpl) connection).origHostToConnectTo;
                String str2 = ((ConnectionImpl) connection).origDatabaseToConnectTo;
                String str3 = ((ConnectionImpl) connection).database;
                boolean z = nullSafeCompare(str, this.origHostToConnectTo) && (str == null || str.indexOf(44) != -1 || str.indexOf(58) != -1 || ((ConnectionImpl) connection).origPortToConnectTo == this.origPortToConnectTo);
                if (z && (!nullSafeCompare(str2, this.origDatabaseToConnectTo) || !nullSafeCompare(str3, this.database))) {
                    z = false;
                }
                if (z) {
                    return true;
                }
                String resourceId = ((ConnectionImpl) connection).getResourceId();
                String resourceId2 = getResourceId();
                return !(resourceId == null && resourceId2 == null) && nullSafeCompare(resourceId, resourceId2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.mysql.jdbc.Connection
    public boolean isServerLocal() throws SQLException {
        synchronized (getConnectionMutex()) {
            SocketFactory socketFactory = getIO().socketFactory;
            if (socketFactory instanceof SocketMetadata) {
                return ((SocketMetadata) socketFactory).isLocallyConnected(this);
            }
            getLog().logWarn(Messages.getString("Connection.NoMetadataOnSocketFactory"));
            return false;
        }
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public boolean isServerTruncatesFracSecs() {
        return this.serverTruncatesFracSecs;
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public boolean isServerTzUTC() {
        return this.isServerTzUTC;
    }

    @Override // com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public boolean lowerCaseTableNames() {
        return this.lowerCaseTableNames;
    }

    @Override // java.sql.Connection
    public String nativeSQL(String str) throws SQLException {
        if (str == null) {
            return null;
        }
        Object objEscapeSQL = EscapeProcessor.escapeSQL(str, serverSupportsConvertFn(), getMultiHostSafeProxy());
        return objEscapeSQL instanceof String ? (String) objEscapeSQL : ((EscapeProcessorResult) objEscapeSQL).escapedSql;
    }

    @Override // com.mysql.jdbc.Connection
    public boolean parserKnowsUnicode() {
        return this.parserKnowsUnicode;
    }

    @Override // com.mysql.jdbc.Connection
    public void ping() throws SQLException {
        pingInternal(true, 0);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void pingInternal(boolean z, int i) throws SQLException {
        if (z) {
            checkClosed();
        }
        long selfDestructOnPingSecondsLifetime = getSelfDestructOnPingSecondsLifetime();
        int selfDestructOnPingMaxOperations = getSelfDestructOnPingMaxOperations();
        if ((selfDestructOnPingSecondsLifetime <= 0 || System.currentTimeMillis() - this.connectionCreationTimeMillis <= selfDestructOnPingSecondsLifetime) && (selfDestructOnPingMaxOperations <= 0 || selfDestructOnPingMaxOperations > this.f79io.getCommandCount())) {
            this.f79io.sendCommand(14, null, null, false, null, i);
        } else {
            close();
            throw SQLError.createSQLException(Messages.getString("Connection.exceededConnectionLifetime"), SQLError.SQL_STATE_COMMUNICATION_LINK_FAILURE, getExceptionInterceptor());
        }
    }

    @Override // java.sql.Connection
    public java.sql.CallableStatement prepareCall(String str) throws SQLException {
        return prepareCall(str, 1003, 1007);
    }

    @Override // java.sql.Connection
    public java.sql.PreparedStatement prepareStatement(String str) throws SQLException {
        return prepareStatement(str, 1003, 1007);
    }

    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [com.mysql.jdbc.ExceptionInterceptor, java.util.List<com.mysql.jdbc.StatementInterceptorV2>] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.mysql.jdbc.ExceptionInterceptor, java.util.List<com.mysql.jdbc.StatementInterceptorV2>] */
    /* JADX WARN: Type inference failed for: r2v6 */
    @Override // com.mysql.jdbc.MySQLConnection
    public void realClose(boolean z, boolean z2, boolean z3, Throwable th) throws SQLException {
        ?? r2;
        SQLException e;
        ?? r3;
        if (isClosed()) {
            return;
        }
        this.forceClosedReason = th;
        try {
            if (z3) {
                this.f79io.forceClose();
                e = null;
            } else {
                if (!getAutoCommit() && z2) {
                    try {
                        rollback();
                    } catch (SQLException e2) {
                        e = e2;
                    }
                }
                e = null;
                reportMetrics();
                if (getUseUsageAdvisor()) {
                    if (!z) {
                        this.eventSink.consumeEvent(new ProfilerEvent((byte) 0, BuildConfig.FLAVOR, getCatalog(), getId(), -1, -1, System.currentTimeMillis(), 0L, Constants.MILLIS_I18N, null, this.pointOfOrigin, "Connection implicitly closed by Driver. You should call Connection.close() from your code to free resources more efficiently and avoid resource leaks."));
                    }
                    if (System.currentTimeMillis() - this.connectionCreationTimeMillis < 500) {
                        this.eventSink.consumeEvent(new ProfilerEvent((byte) 0, BuildConfig.FLAVOR, getCatalog(), getId(), -1, -1, System.currentTimeMillis(), 0L, Constants.MILLIS_I18N, null, this.pointOfOrigin, "Connection lifetime of < .5 seconds. You might be un-necessarily creating short-lived connections and should investigate connection pooling to be more efficient."));
                    }
                }
                try {
                    closeAllOpenStatements();
                } catch (SQLException e3) {
                    e = e3;
                }
                MysqlIO mysqlIO = this.f79io;
                if (mysqlIO != null) {
                    try {
                        mysqlIO.quit();
                    } catch (Exception unused) {
                    }
                }
            }
            if (this.statementInterceptors != null) {
                for (int i = 0; i < this.statementInterceptors.size(); i++) {
                    this.statementInterceptors.get(i).destroy();
                }
            }
            ExceptionInterceptor exceptionInterceptor = this.exceptionInterceptor;
            if (exceptionInterceptor != null) {
                exceptionInterceptor.destroy();
            }
            this.openStatements.clear();
            MysqlIO mysqlIO2 = this.f79io;
            if (mysqlIO2 != null) {
                mysqlIO2.releaseResources();
                r3 = 0;
                this.f79io = null;
            } else {
                r3 = 0;
            }
            this.statementInterceptors = r3;
            this.exceptionInterceptor = r3;
            ProfilerEventHandlerFactory.removeInstance(this);
            synchronized (getConnectionMutex()) {
                Timer timer = this.cancelTimer;
                if (timer != null) {
                    timer.cancel();
                }
            }
            this.isClosed = true;
            if (e != null) {
                throw e;
            }
        } catch (Throwable th2) {
            this.openStatements.clear();
            MysqlIO mysqlIO3 = this.f79io;
            if (mysqlIO3 != null) {
                mysqlIO3.releaseResources();
                r2 = 0;
                this.f79io = null;
            } else {
                r2 = 0;
            }
            this.statementInterceptors = r2;
            this.exceptionInterceptor = r2;
            ProfilerEventHandlerFactory.removeInstance(this);
            synchronized (getConnectionMutex()) {
                Timer timer2 = this.cancelTimer;
                if (timer2 != null) {
                    timer2.cancel();
                }
                this.isClosed = true;
                throw th2;
            }
        }
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void recachePreparedStatement(ServerPreparedStatement serverPreparedStatement) throws SQLException {
        synchronized (getConnectionMutex()) {
            if (getCachePreparedStatements() && serverPreparedStatement.isPoolable()) {
                synchronized (this.serverSideStatementCache) {
                    ServerPreparedStatement serverPreparedStatementPut = this.serverSideStatementCache.put(new CompoundCacheKey(serverPreparedStatement.currentCatalog, serverPreparedStatement.originalSql), serverPreparedStatement);
                    if (serverPreparedStatementPut != null && serverPreparedStatementPut != serverPreparedStatement) {
                        serverPreparedStatementPut.isCached = false;
                        serverPreparedStatementPut.setClosed(false);
                        serverPreparedStatementPut.realClose(true, true);
                    }
                }
            }
        }
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void registerQueryExecutionTime(long j) {
        if (j > this.longestQueryTimeMs) {
            this.longestQueryTimeMs = j;
            repartitionPerformanceHistogram();
        }
        addToPerformanceHistogram(j, 1);
        if (j < this.shortestQueryTimeMs) {
            this.shortestQueryTimeMs = j == 0 ? 1L : j;
        }
        this.numberOfQueriesIssued++;
        this.totalQueryTimeMs += j;
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void registerStatement(Statement statement) {
        this.openStatements.addIfAbsent(statement);
    }

    @Override // java.sql.Connection
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
    }

    public void reportMetricsIfNeeded() {
        if (!getGatherPerformanceMetrics() || System.currentTimeMillis() - this.metricsLastReportedMs <= getReportMetricsIntervalMillis()) {
            return;
        }
        reportMetrics();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void reportNumberOfTablesAccessed(int i) {
        long j = i;
        if (j < this.minimumNumberTablesAccessed) {
            this.minimumNumberTablesAccessed = j;
        }
        if (j > this.maximumNumberTablesAccessed) {
            this.maximumNumberTablesAccessed = j;
            repartitionTablesAccessedHistogram();
        }
        addToTablesAccessedHistogram(j, 1);
    }

    @Override // com.mysql.jdbc.Connection
    public void reportQueryTime(long j) {
        synchronized (getConnectionMutex()) {
            long j2 = this.queryTimeCount + 1;
            this.queryTimeCount = j2;
            double d = j;
            this.queryTimeSum += d;
            this.queryTimeSumSquares += j * j;
            this.queryTimeMean = ((this.queryTimeMean * (j2 - 1)) + d) / j2;
        }
    }

    @Override // com.mysql.jdbc.Connection
    public void resetServerState() throws SQLException {
        if (getParanoid() || this.f79io == null || !versionMeetsMinimum(4, 0, 6)) {
            return;
        }
        changeUser(this.user, this.password);
    }

    @Override // java.sql.Connection
    public void rollback() throws SQLException {
        synchronized (getConnectionMutex()) {
            checkClosed();
            try {
                try {
                    List<Extension> list = this.connectionLifecycleInterceptors;
                    if (list != null) {
                        IterateBlock<Extension> iterateBlock = new IterateBlock<Extension>(list.iterator()) { // from class: com.mysql.jdbc.ConnectionImpl.5
                            @Override // com.mysql.jdbc.IterateBlock
                            public void forEach(Extension extension) throws SQLException {
                                if (((ConnectionLifecycleInterceptor) extension).rollback()) {
                                    return;
                                }
                                this.stopIterating = true;
                            }
                        };
                        iterateBlock.doForAll();
                        if (!iterateBlock.fullIteration()) {
                            this.needsPing = getReconnectAtTxEnd();
                            return;
                        }
                    }
                    if (this.autoCommit && !getRelaxAutoCommit()) {
                        throw SQLError.createSQLException("Can't call rollback when autocommit=true", SQLError.SQL_STATE_CONNECTION_NOT_OPEN, getExceptionInterceptor());
                    }
                    if (this.transactionsSupported) {
                        try {
                            rollbackNoChecks();
                        } catch (SQLException e) {
                            if (!getIgnoreNonTxTables() || e.getErrorCode() != 1196) {
                                throw e;
                            }
                            this.needsPing = getReconnectAtTxEnd();
                            return;
                        }
                    }
                    this.needsPing = getReconnectAtTxEnd();
                } catch (SQLException e2) {
                    if (!SQLError.SQL_STATE_COMMUNICATION_LINK_FAILURE.equals(e2.getSQLState())) {
                        throw e2;
                    }
                    throw SQLError.createSQLException("Communications link failure during rollback(). Transaction resolution unknown.", SQLError.SQL_STATE_TRANSACTION_RESOLUTION_UNKNOWN, getExceptionInterceptor());
                }
            } catch (Throwable th) {
                this.needsPing = getReconnectAtTxEnd();
                throw th;
            }
        }
    }

    @Override // com.mysql.jdbc.Connection
    public java.sql.PreparedStatement serverPrepareStatement(String str) throws SQLException {
        if (getProcessEscapeCodesForPrepStmts()) {
            str = nativeSQL(str);
        }
        return ServerPreparedStatement.getInstance(getMultiHostSafeProxy(), str, getCatalog(), 1003, 1007);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public boolean serverSupportsConvertFn() throws SQLException {
        return versionMeetsMinimum(4, 0, 2);
    }

    @Override // java.sql.Connection
    public void setAutoCommit(final boolean z) throws SQLException {
        synchronized (getConnectionMutex()) {
            checkClosed();
            List<Extension> list = this.connectionLifecycleInterceptors;
            if (list != null) {
                IterateBlock<Extension> iterateBlock = new IterateBlock<Extension>(list.iterator()) { // from class: com.mysql.jdbc.ConnectionImpl.7
                    @Override // com.mysql.jdbc.IterateBlock
                    public void forEach(Extension extension) throws SQLException {
                        if (((ConnectionLifecycleInterceptor) extension).setAutoCommit(z)) {
                            return;
                        }
                        this.stopIterating = true;
                    }
                };
                iterateBlock.doForAll();
                if (!iterateBlock.fullIteration()) {
                    return;
                }
            }
            boolean zIsSetNeededForAutoCommitMode = true;
            if (getAutoReconnectForPools()) {
                setHighAvailability(true);
            }
            try {
                if (this.transactionsSupported) {
                    if (getUseLocalSessionState() && this.autoCommit == z) {
                        zIsSetNeededForAutoCommitMode = false;
                    } else if (!getHighAvailability()) {
                        zIsSetNeededForAutoCommitMode = getIO().isSetNeededForAutoCommitMode(z);
                    }
                    this.autoCommit = z;
                    if (zIsSetNeededForAutoCommitMode) {
                        execSQL(null, z ? "SET autocommit=1" : "SET autocommit=0", -1, null, 1003, 1007, false, this.database, null, false);
                    }
                } else {
                    if (!z && !getRelaxAutoCommit()) {
                        throw SQLError.createSQLException("MySQL Versions Older than 3.23.15 do not support transactions", SQLError.SQL_STATE_CONNECTION_NOT_OPEN, getExceptionInterceptor());
                    }
                    this.autoCommit = z;
                }
                if (getAutoReconnectForPools()) {
                    setHighAvailability(false);
                }
            } catch (Throwable th) {
                if (getAutoReconnectForPools()) {
                    setHighAvailability(false);
                }
                throw th;
            }
        }
    }

    @Override // java.sql.Connection
    public void setCatalog(final String str) throws SQLException {
        synchronized (getConnectionMutex()) {
            checkClosed();
            if (str == null) {
                throw SQLError.createSQLException("Catalog can not be null", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            List<Extension> list = this.connectionLifecycleInterceptors;
            if (list != null) {
                IterateBlock<Extension> iterateBlock = new IterateBlock<Extension>(list.iterator()) { // from class: com.mysql.jdbc.ConnectionImpl.8
                    @Override // com.mysql.jdbc.IterateBlock
                    public void forEach(Extension extension) throws SQLException {
                        if (((ConnectionLifecycleInterceptor) extension).setCatalog(str)) {
                            return;
                        }
                        this.stopIterating = true;
                    }
                };
                iterateBlock.doForAll();
                if (!iterateBlock.fullIteration()) {
                    return;
                }
            }
            if (getUseLocalSessionState()) {
                if (this.lowerCaseTableNames) {
                    if (this.database.equalsIgnoreCase(str)) {
                        return;
                    }
                } else if (this.database.equals(str)) {
                    return;
                }
            }
            String identifierQuoteString = this.dbmd.getIdentifierQuoteString();
            if (identifierQuoteString == null || identifierQuoteString.equals(" ")) {
                identifierQuoteString = BuildConfig.FLAVOR;
            }
            execSQL(null, "USE " + StringUtils.quoteIdentifier(str, identifierQuoteString, getPedantic()), -1, null, 1003, 1007, false, this.database, null, false);
            this.database = str;
        }
    }

    @Override // com.mysql.jdbc.Connection
    public void setFailedOver(boolean z) {
    }

    @Override // java.sql.Connection
    public void setHoldability(int i) throws SQLException {
    }

    @Override // com.mysql.jdbc.Connection
    public void setInGlobalTx(boolean z) {
        this.isInGlobalTx = z;
    }

    @Override // com.mysql.jdbc.Connection
    public void setNetworkTimeout(Executor executor, int i) throws SQLException {
        synchronized (getConnectionMutex()) {
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkPermission(SET_NETWORK_TIMEOUT_PERM);
            }
            if (executor == null) {
                throw SQLError.createSQLException("Executor can not be null", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            checkClosed();
            executor.execute(new NetworkTimeoutSetter(this, this.f79io, i));
        }
    }

    @Override // com.mysql.jdbc.Connection
    @Deprecated
    public void setPreferSlaveDuringFailover(boolean z) {
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void setProfilerEventHandlerInstance(ProfilerEventHandler profilerEventHandler) {
        this.eventSink = profilerEventHandler;
    }

    @Override // com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public void setProxy(MySQLConnection mySQLConnection) {
        this.proxy = mySQLConnection;
        this.realProxy = mySQLConnection instanceof MultiHostMySQLConnection ? ((MultiHostMySQLConnection) mySQLConnection).getThisAsProxy() : null;
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void setReadInfoMsgEnabled(boolean z) {
        this.readInfoMsg = z;
    }

    @Override // java.sql.Connection
    public void setReadOnly(boolean z) throws SQLException {
        checkClosed();
        setReadOnlyInternal(z);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void setReadOnlyInternal(boolean z) throws SQLException {
        if (getReadOnlyPropagatesToServer() && versionMeetsMinimum(5, 6, 5) && (!getUseLocalSessionState() || z != this.readOnly)) {
            StringBuilder sb = new StringBuilder();
            sb.append("set session transaction ");
            sb.append(z ? "read only" : "read write");
            execSQL(null, sb.toString(), -1, null, 1003, 1007, false, this.database, null, false);
        }
        this.readOnly = z;
    }

    @Override // java.sql.Connection
    public Savepoint setSavepoint() throws SQLException {
        MysqlSavepoint mysqlSavepoint = new MysqlSavepoint(getExceptionInterceptor());
        setSavepoint(mysqlSavepoint);
        return mysqlSavepoint;
    }

    @Override // com.mysql.jdbc.Connection
    public void setSchema(String str) throws SQLException {
        synchronized (getConnectionMutex()) {
            checkClosed();
        }
    }

    @Override // com.mysql.jdbc.Connection
    public void setSessionMaxRows(int i) throws SQLException {
        synchronized (getConnectionMutex()) {
            if (this.sessionMaxRows != i) {
                this.sessionMaxRows = i;
                StringBuilder sb = new StringBuilder();
                sb.append("SET SQL_SELECT_LIMIT=");
                int i2 = this.sessionMaxRows;
                sb.append(i2 == -1 ? "DEFAULT" : Integer.valueOf(i2));
                execSQL(null, sb.toString(), -1, null, 1003, 1007, false, this.database, null, false);
            }
        }
    }

    @Override // com.mysql.jdbc.Connection
    public void setStatementComment(String str) {
        this.statementComment = str;
    }

    @Override // java.sql.Connection
    public void setTransactionIsolation(int i) throws SQLException {
        String str;
        synchronized (getConnectionMutex()) {
            checkClosed();
            if (!this.hasIsolationLevels) {
                throw SQLError.createSQLException("Transaction Isolation Levels are not supported on MySQL versions older than 3.23.36.", SQLError.SQL_STATE_DRIVER_NOT_CAPABLE, getExceptionInterceptor());
            }
            boolean z = getAlwaysSendSetIsolation() || i != this.isolationLevel;
            if (getUseLocalSessionState()) {
                z = this.isolationLevel != i;
            }
            if (z) {
                if (i == 0) {
                    throw SQLError.createSQLException("Transaction isolation level NONE not supported by MySQL", getExceptionInterceptor());
                }
                if (i == 1) {
                    str = "SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED";
                } else if (i == 2) {
                    str = "SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED";
                } else if (i == 4) {
                    str = "SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ";
                } else {
                    if (i != 8) {
                        throw SQLError.createSQLException("Unsupported transaction isolation level '" + i + "'", SQLError.SQL_STATE_DRIVER_NOT_CAPABLE, getExceptionInterceptor());
                    }
                    str = "SET SESSION TRANSACTION ISOLATION LEVEL SERIALIZABLE";
                }
                execSQL(null, str, -1, null, 1003, 1007, false, this.database, null, false);
                this.isolationLevel = i;
            }
        }
    }

    @Override // java.sql.Connection
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        synchronized (getConnectionMutex()) {
            this.typeMap = map;
        }
    }

    @Override // com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public void shutdownServer() throws SQLException {
        try {
            if (versionMeetsMinimum(5, 7, 9)) {
                execSQL(null, "SHUTDOWN", -1, null, 1003, 1007, false, this.database, null, false);
            } else {
                this.f79io.sendCommand(8, null, null, false, null, 0);
            }
        } catch (Exception e) {
            SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(Messages.getString("Connection.UnhandledExceptionDuringShutdown"), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
            sQLExceptionCreateSQLException.initCause(e);
            throw sQLExceptionCreateSQLException;
        }
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public boolean storesLowerCaseTableName() {
        return this.storesLowerCaseTableName;
    }

    @Override // com.mysql.jdbc.Connection
    public boolean supportsIsolationLevel() {
        return this.hasIsolationLevels;
    }

    @Override // com.mysql.jdbc.Connection
    public boolean supportsQuotedIdentifiers() {
        return this.hasQuotedIdentifiers;
    }

    @Override // com.mysql.jdbc.Connection
    public boolean supportsTransactions() {
        return this.transactionsSupported;
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void throwConnectionClosedException() throws SQLException {
        SQLException sQLExceptionCreateSQLException = SQLError.createSQLException("No operations allowed after connection closed.", SQLError.SQL_STATE_CONNECTION_NOT_OPEN, getExceptionInterceptor());
        Throwable th = this.forceClosedReason;
        if (th == null) {
            throw sQLExceptionCreateSQLException;
        }
        sQLExceptionCreateSQLException.initCause(th);
        throw sQLExceptionCreateSQLException;
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void transactionBegun() throws SQLException {
        synchronized (getConnectionMutex()) {
            List<Extension> list = this.connectionLifecycleInterceptors;
            if (list != null) {
                new IterateBlock<Extension>(list.iterator()) { // from class: com.mysql.jdbc.ConnectionImpl.9
                    @Override // com.mysql.jdbc.IterateBlock
                    public void forEach(Extension extension) throws SQLException {
                        ((ConnectionLifecycleInterceptor) extension).transactionBegun();
                    }
                }.doForAll();
            }
        }
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void transactionCompleted() throws SQLException {
        synchronized (getConnectionMutex()) {
            List<Extension> list = this.connectionLifecycleInterceptors;
            if (list != null) {
                new IterateBlock<Extension>(list.iterator()) { // from class: com.mysql.jdbc.ConnectionImpl.10
                    @Override // com.mysql.jdbc.IterateBlock
                    public void forEach(Extension extension) throws SQLException {
                        ((ConnectionLifecycleInterceptor) extension).transactionCompleted();
                    }
                }.doForAll();
            }
        }
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void unSafeStatementInterceptors() throws SQLException {
        ArrayList arrayList = new ArrayList(this.statementInterceptors.size());
        for (int i = 0; i < this.statementInterceptors.size(); i++) {
            arrayList.add(((NoSubInterceptorWrapper) this.statementInterceptors.get(i)).getUnderlyingInterceptor());
        }
        this.statementInterceptors = arrayList;
        MysqlIO mysqlIO = this.f79io;
        if (mysqlIO != null) {
            mysqlIO.setStatementInterceptors(arrayList);
        }
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void unregisterStatement(Statement statement) {
        this.openStatements.remove(statement);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public boolean useAnsiQuotedIdentifiers() {
        boolean z;
        synchronized (getConnectionMutex()) {
            z = this.useAnsiQuotes;
        }
        return z;
    }

    @Override // com.mysql.jdbc.Connection
    public boolean versionMeetsMinimum(int i, int i2, int i3) throws SQLException {
        checkClosed();
        return this.f79io.versionMeetsMinimum(i, i2, i3);
    }

    private java.sql.DatabaseMetaData getMetaData(boolean z, boolean z2) throws SQLException {
        if (z) {
            checkClosed();
        }
        return DatabaseMetaData.getInstance(getMultiHostSafeProxy(), this.database, z2);
    }

    @Override // com.mysql.jdbc.Connection
    public java.sql.PreparedStatement clientPrepareStatement(String str, int i) throws SQLException {
        java.sql.PreparedStatement preparedStatementClientPrepareStatement = clientPrepareStatement(str);
        ((PreparedStatement) preparedStatementClientPrepareStatement).setRetrieveGeneratedKeys(i == 1);
        return preparedStatementClientPrepareStatement;
    }

    @Override // java.sql.Connection
    public java.sql.Statement createStatement(int i, int i2) throws SQLException {
        checkClosed();
        StatementImpl statementImpl = new StatementImpl(getMultiHostSafeProxy(), this.database);
        statementImpl.setResultSetType(i);
        statementImpl.setResultSetConcurrency(i2);
        return statementImpl;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    /* JADX WARN: Code duplicated, block: B:28:0x004f A[Catch: all -> 0x00c6, Exception -> 0x00c9, SQLException -> 0x00f8, TryCatch #1 {all -> 0x00c6, blocks: (B:26:0x0049, B:28:0x004f, B:29:0x0053, B:57:0x00cb, B:59:0x00d1, B:61:0x00d5, B:62:0x00da, B:66:0x00e4, B:67:0x00f7, B:63:0x00dd, B:65:0x00e1, B:70:0x00fa, B:72:0x0100, B:74:0x012f, B:76:0x0135, B:78:0x0141, B:79:0x0146, B:83:0x0158, B:80:0x0149, B:82:0x0155, B:38:0x008c, B:40:0x00a1), top: B:95:0x0046, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0075 A[Catch: all -> 0x0175, TryCatch #0 {, blocks: (B:6:0x000c, B:8:0x0013, B:10:0x001b, B:12:0x0024, B:14:0x002d, B:16:0x0031, B:18:0x0037, B:21:0x003d, B:23:0x0043, B:30:0x006f, B:32:0x0075, B:33:0x007b, B:35:0x0081, B:36:0x008a, B:84:0x0159, B:86:0x015f, B:87:0x0165, B:89:0x016b, B:90:0x0174, B:41:0x00a5, B:43:0x00ab, B:44:0x00b1, B:46:0x00b7, B:47:0x00c0, B:26:0x0049, B:28:0x004f, B:29:0x0053, B:57:0x00cb, B:59:0x00d1, B:61:0x00d5, B:62:0x00da, B:66:0x00e4, B:67:0x00f7, B:63:0x00dd, B:65:0x00e1, B:70:0x00fa, B:72:0x0100, B:74:0x012f, B:76:0x0135, B:78:0x0141, B:79:0x0146, B:83:0x0158, B:80:0x0149, B:82:0x0155, B:38:0x008c, B:40:0x00a1), top: B:94:0x000c, inners: #1, #5 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0081 A[Catch: all -> 0x0175, TryCatch #0 {, blocks: (B:6:0x000c, B:8:0x0013, B:10:0x001b, B:12:0x0024, B:14:0x002d, B:16:0x0031, B:18:0x0037, B:21:0x003d, B:23:0x0043, B:30:0x006f, B:32:0x0075, B:33:0x007b, B:35:0x0081, B:36:0x008a, B:84:0x0159, B:86:0x015f, B:87:0x0165, B:89:0x016b, B:90:0x0174, B:41:0x00a5, B:43:0x00ab, B:44:0x00b1, B:46:0x00b7, B:47:0x00c0, B:26:0x0049, B:28:0x004f, B:29:0x0053, B:57:0x00cb, B:59:0x00d1, B:61:0x00d5, B:62:0x00da, B:66:0x00e4, B:67:0x00f7, B:63:0x00dd, B:65:0x00e1, B:70:0x00fa, B:72:0x0100, B:74:0x012f, B:76:0x0135, B:78:0x0141, B:79:0x0146, B:83:0x0158, B:80:0x0149, B:82:0x0155, B:38:0x008c, B:40:0x00a1), top: B:94:0x000c, inners: #1, #5 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x008c A[Catch: all -> 0x00c6, Exception -> 0x00c9, SQLException -> 0x00f8, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00c6, blocks: (B:26:0x0049, B:28:0x004f, B:29:0x0053, B:57:0x00cb, B:59:0x00d1, B:61:0x00d5, B:62:0x00da, B:66:0x00e4, B:67:0x00f7, B:63:0x00dd, B:65:0x00e1, B:70:0x00fa, B:72:0x0100, B:74:0x012f, B:76:0x0135, B:78:0x0141, B:79:0x0146, B:83:0x0158, B:80:0x0149, B:82:0x0155, B:38:0x008c, B:40:0x00a1), top: B:95:0x0046, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00ab A[Catch: all -> 0x0175, TryCatch #0 {, blocks: (B:6:0x000c, B:8:0x0013, B:10:0x001b, B:12:0x0024, B:14:0x002d, B:16:0x0031, B:18:0x0037, B:21:0x003d, B:23:0x0043, B:30:0x006f, B:32:0x0075, B:33:0x007b, B:35:0x0081, B:36:0x008a, B:84:0x0159, B:86:0x015f, B:87:0x0165, B:89:0x016b, B:90:0x0174, B:41:0x00a5, B:43:0x00ab, B:44:0x00b1, B:46:0x00b7, B:47:0x00c0, B:26:0x0049, B:28:0x004f, B:29:0x0053, B:57:0x00cb, B:59:0x00d1, B:61:0x00d5, B:62:0x00da, B:66:0x00e4, B:67:0x00f7, B:63:0x00dd, B:65:0x00e1, B:70:0x00fa, B:72:0x0100, B:74:0x012f, B:76:0x0135, B:78:0x0141, B:79:0x0146, B:83:0x0158, B:80:0x0149, B:82:0x0155, B:38:0x008c, B:40:0x00a1), top: B:94:0x000c, inners: #1, #5 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00b7 A[Catch: all -> 0x0175, TryCatch #0 {, blocks: (B:6:0x000c, B:8:0x0013, B:10:0x001b, B:12:0x0024, B:14:0x002d, B:16:0x0031, B:18:0x0037, B:21:0x003d, B:23:0x0043, B:30:0x006f, B:32:0x0075, B:33:0x007b, B:35:0x0081, B:36:0x008a, B:84:0x0159, B:86:0x015f, B:87:0x0165, B:89:0x016b, B:90:0x0174, B:41:0x00a5, B:43:0x00ab, B:44:0x00b1, B:46:0x00b7, B:47:0x00c0, B:26:0x0049, B:28:0x004f, B:29:0x0053, B:57:0x00cb, B:59:0x00d1, B:61:0x00d5, B:62:0x00da, B:66:0x00e4, B:67:0x00f7, B:63:0x00dd, B:65:0x00e1, B:70:0x00fa, B:72:0x0100, B:74:0x012f, B:76:0x0135, B:78:0x0141, B:79:0x0146, B:83:0x0158, B:80:0x0149, B:82:0x0155, B:38:0x008c, B:40:0x00a1), top: B:94:0x000c, inners: #1, #5 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:25:0x0048, please report this as an issue */
    @Override // com.mysql.jdbc.MySQLConnection
    public ResultSetInternalMethods execSQL(StatementImpl statementImpl, String str, int i, Buffer buffer, int i2, int i3, boolean z, String str2, Field[] fieldArr, boolean z2) throws SQLException {
        boolean z3;
        boolean z4;
        synchronized (getConnectionMutex()) {
            int position = buffer != null ? buffer.getPosition() : 0;
            long jCurrentTimeMillis = getGatherPerformanceMetrics() ? System.currentTimeMillis() : 0L;
            this.lastQueryFinishedTime = 0L;
            if (getHighAvailability() && ((this.autoCommit || getAutoReconnectForPools()) && this.needsPing && !z2)) {
                try {
                    pingInternal(false, 0);
                    this.needsPing = false;
                } catch (Exception unused) {
                    createNewIO(true);
                }
                if (buffer == null) {
                    ResultSetInternalMethods resultSetInternalMethodsSqlQueryDirect = this.f79io.sqlQueryDirect(statementImpl, str, getUseUnicode() ? getEncoding() : null, null, i, i2, i3, z, str2, fieldArr);
                    if (getMaintainTimeStats()) {
                        this.lastQueryFinishedTime = System.currentTimeMillis();
                    }
                    if (getGatherPerformanceMetrics()) {
                        registerQueryExecutionTime(System.currentTimeMillis() - jCurrentTimeMillis);
                    }
                    return resultSetInternalMethodsSqlQueryDirect;
                }
                z3 = true;
                ResultSetInternalMethods resultSetInternalMethodsSqlQueryDirect2 = this.f79io.sqlQueryDirect(statementImpl, null, null, buffer, i, i2, i3, z, str2, fieldArr);
                if (getMaintainTimeStats()) {
                    this.lastQueryFinishedTime = System.currentTimeMillis();
                }
                if (getGatherPerformanceMetrics()) {
                    registerQueryExecutionTime(System.currentTimeMillis() - jCurrentTimeMillis);
                }
                return resultSetInternalMethodsSqlQueryDirect2;
            }
            try {
                try {
                    if (buffer == null) {
                        ResultSetInternalMethods resultSetInternalMethodsSqlQueryDirect3 = this.f79io.sqlQueryDirect(statementImpl, str, getUseUnicode() ? getEncoding() : null, null, i, i2, i3, z, str2, fieldArr);
                        if (getMaintainTimeStats()) {
                            this.lastQueryFinishedTime = System.currentTimeMillis();
                        }
                        if (getGatherPerformanceMetrics()) {
                            registerQueryExecutionTime(System.currentTimeMillis() - jCurrentTimeMillis);
                        }
                        return resultSetInternalMethodsSqlQueryDirect3;
                    }
                    z3 = true;
                    try {
                        ResultSetInternalMethods resultSetInternalMethodsSqlQueryDirect4 = this.f79io.sqlQueryDirect(statementImpl, null, null, buffer, i, i2, i3, z, str2, fieldArr);
                        if (getMaintainTimeStats()) {
                            this.lastQueryFinishedTime = System.currentTimeMillis();
                        }
                        if (getGatherPerformanceMetrics()) {
                            registerQueryExecutionTime(System.currentTimeMillis() - jCurrentTimeMillis);
                        }
                        return resultSetInternalMethodsSqlQueryDirect4;
                    } catch (SQLException e) {
                        e = e;
                        if (getDumpQueriesOnException()) {
                            z4 = true;
                            String strExtractSqlFromPacket = extractSqlFromPacket(str, buffer, position);
                            StringBuilder sb = new StringBuilder(strExtractSqlFromPacket.length() + 32);
                            sb.append("\n\nQuery being executed when exception was thrown:\n");
                            sb.append(strExtractSqlFromPacket);
                            sb.append("\n\n");
                            e = appendMessageToException(e, sb.toString(), getExceptionInterceptor());
                        } else {
                            z4 = true;
                        }
                        if (getHighAvailability()) {
                            if (SQLError.SQL_STATE_COMMUNICATION_LINK_FAILURE.equals(e.getSQLState())) {
                                this.f79io.forceClose();
                            }
                            this.needsPing = z4;
                        } else if (SQLError.SQL_STATE_COMMUNICATION_LINK_FAILURE.equals(e.getSQLState())) {
                            cleanup(e);
                        }
                        throw e;
                    } catch (Exception e2) {
                        e = e2;
                        if (getHighAvailability()) {
                            if (e instanceof IOException) {
                                this.f79io.forceClose();
                            }
                            this.needsPing = z3;
                        } else if (e instanceof IOException) {
                            cleanup(e);
                        }
                        SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(Messages.getString("Connection.UnexpectedException"), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
                        sQLExceptionCreateSQLException.initCause(e);
                        throw sQLExceptionCreateSQLException;
                    }
                } catch (SQLException e3) {
                    e = e3;
                } catch (Exception e4) {
                    e = e4;
                    z3 = true;
                }
            } catch (Throwable th) {
                if (getMaintainTimeStats()) {
                    this.lastQueryFinishedTime = System.currentTimeMillis();
                }
                if (getGatherPerformanceMetrics()) {
                    registerQueryExecutionTime(System.currentTimeMillis() - jCurrentTimeMillis);
                }
                throw th;
            }
            throw th;
        }
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public int getMaxBytesPerChar(Integer num, String str) throws SQLException {
        try {
            Map<Integer, String> map = this.indexToCustomMysqlCharset;
            String mysqlCharsetForJavaEncoding = map != null ? map.get(num) : null;
            if (mysqlCharsetForJavaEncoding == null) {
                mysqlCharsetForJavaEncoding = CharsetMapping.getMysqlCharsetNameForCollationIndex(num);
            }
            if (mysqlCharsetForJavaEncoding == null) {
                mysqlCharsetForJavaEncoding = CharsetMapping.getMysqlCharsetForJavaEncoding(str, this);
            }
            Map<String, Integer> map2 = this.mysqlCharsetToCustomMblen;
            Integer numValueOf = map2 != null ? map2.get(mysqlCharsetForJavaEncoding) : null;
            if (numValueOf == null) {
                numValueOf = Integer.valueOf(CharsetMapping.getMblen(mysqlCharsetForJavaEncoding));
            }
            if (numValueOf != null) {
                return numValueOf.intValue();
            }
            return 1;
        } catch (RuntimeException e) {
            SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(e.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
            sQLExceptionCreateSQLException.initCause(e);
            throw sQLExceptionCreateSQLException;
        } catch (SQLException e2) {
            throw e2;
        }
    }

    public java.sql.Statement getMetadataSafeStatement(int i) throws SQLException {
        java.sql.Statement statementCreateStatement = createStatement();
        if (i == -1) {
            i = 0;
        }
        statementCreateStatement.setMaxRows(i);
        statementCreateStatement.setEscapeProcessing(false);
        if (statementCreateStatement.getFetchSize() != 0) {
            statementCreateStatement.setFetchSize(0);
        }
        return statementCreateStatement;
    }

    /* JADX WARN: Code duplicated, block: B:71:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:? A[SYNTHETIC] */
    @Override // com.mysql.jdbc.MySQLConnection
    public boolean isReadOnly(boolean z) throws Throwable {
        java.sql.Statement metadataSafeStatement;
        if (z && !this.isClosed && versionMeetsMinimum(5, 6, 5) && !getUseLocalSessionState() && getReadOnlyPropagatesToServer()) {
            ResultSet resultSetExecuteQuery = null;
            try {
                metadataSafeStatement = getMetadataSafeStatement(this.sessionMaxRows);
                try {
                    try {
                        resultSetExecuteQuery = metadataSafeStatement.executeQuery((versionMeetsMinimum(8, 0, 3) || (versionMeetsMinimum(5, 7, 20) && !versionMeetsMinimum(8, 0, 0))) ? "select @@session.transaction_read_only" : "select @@session.tx_read_only");
                        if (resultSetExecuteQuery.next()) {
                            boolean z2 = resultSetExecuteQuery.getInt(1) != 0;
                            if (resultSetExecuteQuery != null) {
                                try {
                                    resultSetExecuteQuery.close();
                                } catch (Exception unused) {
                                }
                            }
                            if (metadataSafeStatement != null) {
                                try {
                                    metadataSafeStatement.close();
                                } catch (Exception unused2) {
                                }
                            }
                            return z2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (resultSetExecuteQuery != null) {
                            try {
                                resultSetExecuteQuery.close();
                            } catch (Exception unused3) {
                            }
                        }
                        if (metadataSafeStatement != null) {
                            throw th;
                        }
                        try {
                            metadataSafeStatement.close();
                            throw th;
                        } catch (Exception unused4) {
                            throw th;
                        }
                    }
                } catch (SQLException e) {
                    e = e;
                    if (e.getErrorCode() != 1820 || getDisconnectOnExpiredPasswords()) {
                        throw SQLError.createSQLException("Could not retrieve transaction read-only status from server", SQLError.SQL_STATE_GENERAL_ERROR, e, getExceptionInterceptor());
                    }
                }
            } catch (SQLException e2) {
                e = e2;
                metadataSafeStatement = null;
            } catch (Throwable th2) {
                th = th2;
                metadataSafeStatement = null;
                if (resultSetExecuteQuery != null) {
                    resultSetExecuteQuery.close();
                }
                if (metadataSafeStatement != null) {
                    throw th;
                }
                metadataSafeStatement.close();
                throw th;
            }
            if (resultSetExecuteQuery != null) {
                try {
                    resultSetExecuteQuery.close();
                } catch (Exception unused5) {
                }
            }
            if (metadataSafeStatement != null) {
                try {
                    metadataSafeStatement.close();
                } catch (Exception unused6) {
                }
            }
        }
        return this.readOnly;
    }

    @Override // java.sql.Connection
    public java.sql.CallableStatement prepareCall(String str, int i, int i2) throws SQLException {
        CallableStatement callableStatement;
        CallableStatement.CallableStatementParamInfo callableStatementParamInfo;
        if (!versionMeetsMinimum(5, 0, 0)) {
            throw SQLError.createSQLException("Callable statements not supported.", SQLError.SQL_STATE_DRIVER_NOT_CAPABLE, getExceptionInterceptor());
        }
        if (getCacheCallableStatements()) {
            synchronized (this.parsedCallableStatementCache) {
                CompoundCacheKey compoundCacheKey = new CompoundCacheKey(getCatalog(), str);
                CallableStatement.CallableStatementParamInfo callableStatementParamInfo2 = this.parsedCallableStatementCache.get(compoundCacheKey);
                if (callableStatementParamInfo2 != null) {
                    callableStatement = CallableStatement.getInstance(getMultiHostSafeProxy(), callableStatementParamInfo2);
                } else {
                    callableStatement = parseCallableStatement(str);
                    synchronized (callableStatement) {
                        callableStatementParamInfo = callableStatement.paramInfo;
                    }
                    this.parsedCallableStatementCache.put(compoundCacheKey, callableStatementParamInfo);
                }
            }
        } else {
            callableStatement = parseCallableStatement(str);
        }
        callableStatement.setResultSetType(i);
        callableStatement.setResultSetConcurrency(i2);
        return callableStatement;
    }

    @Override // java.sql.Connection
    public java.sql.PreparedStatement prepareStatement(String str, int i) throws SQLException {
        java.sql.PreparedStatement preparedStatementPrepareStatement = prepareStatement(str);
        ((PreparedStatement) preparedStatementPrepareStatement).setRetrieveGeneratedKeys(i == 1);
        return preparedStatementPrepareStatement;
    }

    private void setSavepoint(MysqlSavepoint mysqlSavepoint) throws SQLException {
        synchronized (getConnectionMutex()) {
            if (!versionMeetsMinimum(4, 0, 14) && !versionMeetsMinimum(4, 1, 1)) {
                throw SQLError.createSQLFeatureNotSupportedException();
            }
            checkClosed();
            java.sql.Statement metadataSafeStatement = null;
            try {
                metadataSafeStatement = getMetadataSafeStatement();
                metadataSafeStatement.executeUpdate("SAVEPOINT `" + mysqlSavepoint.getSavepointName() + '`');
                closeStatement(metadataSafeStatement);
            } catch (Throwable th) {
                closeStatement(metadataSafeStatement);
                throw th;
            }
        }
    }

    @Override // com.mysql.jdbc.Connection
    public java.sql.PreparedStatement serverPrepareStatement(String str, int i) throws SQLException {
        if (getProcessEscapeCodesForPrepStmts()) {
            str = nativeSQL(str);
        }
        ServerPreparedStatement serverPreparedStatement = ServerPreparedStatement.getInstance(getMultiHostSafeProxy(), str, getCatalog(), 1003, 1007);
        serverPreparedStatement.setRetrieveGeneratedKeys(i == 1);
        return serverPreparedStatement;
    }

    @Override // com.mysql.jdbc.Connection
    public java.sql.PreparedStatement clientPrepareStatement(String str, int i, int i2) throws SQLException {
        return clientPrepareStatement(str, i, i2, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v12, types: [com.mysql.jdbc.PreparedStatement] */
    /* JADX WARN: Type inference failed for: r4v14, types: [com.mysql.jdbc.ServerPreparedStatement, com.mysql.jdbc.StatementImpl] */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.sql.PreparedStatement] */
    /* JADX WARN: Type inference failed for: r4v9, types: [com.mysql.jdbc.PreparedStatement] */
    @Override // java.sql.Connection
    public java.sql.PreparedStatement prepareStatement(String str, int i, int i2) throws SQLException {
        ?? r4;
        ServerPreparedStatement serverPreparedStatementRemove;
        synchronized (getConnectionMutex()) {
            checkClosed();
            String strNativeSQL = getProcessEscapeCodesForPrepStmts() ? nativeSQL(str) : str;
            boolean zCanHandleAsServerPreparedStatement = (this.useServerPreparedStmts && getEmulateUnsupportedPstmts()) ? canHandleAsServerPreparedStatement(strNativeSQL) : true;
            if (this.useServerPreparedStmts && zCanHandleAsServerPreparedStatement) {
                if (getCachePreparedStatements()) {
                    synchronized (this.serverSideStatementCache) {
                        serverPreparedStatementRemove = this.serverSideStatementCache.remove(new CompoundCacheKey(this.database, str));
                        if (serverPreparedStatementRemove != 0) {
                            serverPreparedStatementRemove.setClosed(false);
                            serverPreparedStatementRemove.clearParameters();
                        }
                        if (serverPreparedStatementRemove == 0) {
                            try {
                                serverPreparedStatementRemove = ServerPreparedStatement.getInstance(getMultiHostSafeProxy(), strNativeSQL, this.database, i, i2);
                                if (str.length() < getPreparedStatementCacheSqlLimit()) {
                                    serverPreparedStatementRemove.isCached = true;
                                }
                                serverPreparedStatementRemove.setResultSetType(i);
                                serverPreparedStatementRemove.setResultSetConcurrency(i2);
                            } catch (SQLException e) {
                                if (getEmulateUnsupportedPstmts()) {
                                    serverPreparedStatementRemove = (PreparedStatement) clientPrepareStatement(strNativeSQL, i, i2, false);
                                    if (str.length() < getPreparedStatementCacheSqlLimit()) {
                                        this.serverSideStatementCheckCache.put(str, Boolean.FALSE);
                                    }
                                } else {
                                    throw e;
                                }
                            }
                        }
                    }
                    r4 = serverPreparedStatementRemove;
                } else {
                    try {
                        ServerPreparedStatement serverPreparedStatement = ServerPreparedStatement.getInstance(getMultiHostSafeProxy(), strNativeSQL, this.database, i, i2);
                        serverPreparedStatement.setResultSetType(i);
                        serverPreparedStatement.setResultSetConcurrency(i2);
                        r4 = serverPreparedStatement;
                    } catch (SQLException e2) {
                        if (getEmulateUnsupportedPstmts()) {
                            r4 = (PreparedStatement) clientPrepareStatement(strNativeSQL, i, i2, false);
                        } else {
                            throw e2;
                        }
                    }
                }
            } else {
                r4 = (PreparedStatement) clientPrepareStatement(strNativeSQL, i, i2, false);
            }
        }
        return r4;
    }

    public java.sql.PreparedStatement clientPrepareStatement(String str, int i, int i2, boolean z) throws SQLException {
        PreparedStatement preparedStatement;
        checkClosed();
        if (z && getProcessEscapeCodesForPrepStmts()) {
            str = nativeSQL(str);
        }
        if (getCachePreparedStatements()) {
            PreparedStatement.ParseInfo parseInfo = this.cachedPreparedStatementParams.get(str);
            if (parseInfo == null) {
                preparedStatement = PreparedStatement.getInstance(getMultiHostSafeProxy(), str, this.database);
                this.cachedPreparedStatementParams.put(str, preparedStatement.getParseInfo());
            } else {
                preparedStatement = PreparedStatement.getInstance(getMultiHostSafeProxy(), str, this.database, parseInfo);
            }
        } else {
            preparedStatement = PreparedStatement.getInstance(getMultiHostSafeProxy(), str, this.database);
        }
        preparedStatement.setResultSetType(i);
        preparedStatement.setResultSetConcurrency(i2);
        return preparedStatement;
    }

    @Override // java.sql.Connection
    public java.sql.Statement createStatement(int i, int i2, int i3) throws SQLException {
        if (getPedantic() && i3 != 1) {
            throw SQLError.createSQLException("HOLD_CUSRORS_OVER_COMMIT is only supported holdability level", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
        return createStatement(i, i2);
    }

    @Override // com.mysql.jdbc.Connection
    public java.sql.PreparedStatement serverPrepareStatement(String str, int i, int i2) throws SQLException {
        if (getProcessEscapeCodesForPrepStmts()) {
            str = nativeSQL(str);
        }
        return ServerPreparedStatement.getInstance(getMultiHostSafeProxy(), str, getCatalog(), i, i2);
    }

    @Override // com.mysql.jdbc.Connection
    public java.sql.PreparedStatement serverPrepareStatement(String str, int i, int i2, int i3) throws SQLException {
        if (getPedantic() && i3 != 1) {
            throw SQLError.createSQLException("HOLD_CUSRORS_OVER_COMMIT is only supported holdability level", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
        return serverPrepareStatement(str, i, i2);
    }

    @Override // com.mysql.jdbc.Connection
    public java.sql.PreparedStatement serverPrepareStatement(String str, int[] iArr) throws SQLException {
        PreparedStatement preparedStatement = (PreparedStatement) serverPrepareStatement(str);
        preparedStatement.setRetrieveGeneratedKeys(iArr != null && iArr.length > 0);
        return preparedStatement;
    }

    @Override // com.mysql.jdbc.Connection
    public java.sql.PreparedStatement serverPrepareStatement(String str, String[] strArr) throws SQLException {
        PreparedStatement preparedStatement = (PreparedStatement) serverPrepareStatement(str);
        preparedStatement.setRetrieveGeneratedKeys(strArr != null && strArr.length > 0);
        return preparedStatement;
    }

    @Override // com.mysql.jdbc.Connection
    public java.sql.PreparedStatement clientPrepareStatement(String str, int[] iArr) throws SQLException {
        PreparedStatement preparedStatement = (PreparedStatement) clientPrepareStatement(str);
        preparedStatement.setRetrieveGeneratedKeys(iArr != null && iArr.length > 0);
        return preparedStatement;
    }

    @Override // com.mysql.jdbc.Connection
    public java.sql.PreparedStatement clientPrepareStatement(String str, String[] strArr) throws SQLException {
        PreparedStatement preparedStatement = (PreparedStatement) clientPrepareStatement(str);
        preparedStatement.setRetrieveGeneratedKeys(strArr != null && strArr.length > 0);
        return preparedStatement;
    }

    @Override // java.sql.Connection
    public Savepoint setSavepoint(String str) throws SQLException {
        MysqlSavepoint mysqlSavepoint;
        synchronized (getConnectionMutex()) {
            mysqlSavepoint = new MysqlSavepoint(str, getExceptionInterceptor());
            setSavepoint(mysqlSavepoint);
        }
        return mysqlSavepoint;
    }

    @Override // com.mysql.jdbc.Connection
    public java.sql.PreparedStatement clientPrepareStatement(String str, int i, int i2, int i3) throws SQLException {
        return clientPrepareStatement(str, i, i2, true);
    }

    @Override // java.sql.Connection
    public java.sql.CallableStatement prepareCall(String str, int i, int i2, int i3) throws SQLException {
        if (getPedantic() && i3 != 1) {
            throw SQLError.createSQLException("HOLD_CUSRORS_OVER_COMMIT is only supported holdability level", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
        return (CallableStatement) prepareCall(str, i, i2);
    }

    @Override // java.sql.Connection
    public void rollback(final Savepoint savepoint) throws SQLException {
        String message;
        synchronized (getConnectionMutex()) {
            if (!versionMeetsMinimum(4, 0, 14) && !versionMeetsMinimum(4, 1, 1)) {
                throw SQLError.createSQLFeatureNotSupportedException();
            }
            checkClosed();
            try {
                List<Extension> list = this.connectionLifecycleInterceptors;
                if (list != null) {
                    IterateBlock<Extension> iterateBlock = new IterateBlock<Extension>(list.iterator()) { // from class: com.mysql.jdbc.ConnectionImpl.6
                        @Override // com.mysql.jdbc.IterateBlock
                        public void forEach(Extension extension) throws SQLException {
                            if (((ConnectionLifecycleInterceptor) extension).rollback(savepoint)) {
                                return;
                            }
                            this.stopIterating = true;
                        }
                    };
                    iterateBlock.doForAll();
                    if (!iterateBlock.fullIteration()) {
                        this.needsPing = getReconnectAtTxEnd();
                        return;
                    }
                }
                java.sql.Statement metadataSafeStatement = null;
                try {
                    try {
                        metadataSafeStatement = getMetadataSafeStatement();
                        metadataSafeStatement.executeUpdate("ROLLBACK TO SAVEPOINT `" + savepoint.getSavepointName() + '`');
                        closeStatement(metadataSafeStatement);
                        this.needsPing = getReconnectAtTxEnd();
                    } catch (Throwable th) {
                        closeStatement(metadataSafeStatement);
                        throw th;
                    }
                } catch (SQLException e) {
                    int errorCode = e.getErrorCode();
                    if (errorCode == 1181 && (message = e.getMessage()) != null && message.indexOf("153") != -1) {
                        throw SQLError.createSQLException("Savepoint '" + savepoint.getSavepointName() + "' does not exist", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, errorCode, getExceptionInterceptor());
                    }
                    if (getIgnoreNonTxTables() && e.getErrorCode() != 1196) {
                        throw e;
                    }
                    if (SQLError.SQL_STATE_COMMUNICATION_LINK_FAILURE.equals(e.getSQLState())) {
                        throw SQLError.createSQLException("Communications link failure during rollback(). Transaction resolution unknown.", SQLError.SQL_STATE_TRANSACTION_RESOLUTION_UNKNOWN, getExceptionInterceptor());
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                this.needsPing = getReconnectAtTxEnd();
                throw th2;
            }
        }
    }

    @Override // java.sql.Connection
    public java.sql.PreparedStatement prepareStatement(String str, int i, int i2, int i3) throws SQLException {
        if (getPedantic() && i3 != 1) {
            throw SQLError.createSQLException("HOLD_CUSRORS_OVER_COMMIT is only supported holdability level", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
        return prepareStatement(str, i, i2);
    }

    @Override // java.sql.Connection
    public java.sql.PreparedStatement prepareStatement(String str, int[] iArr) throws SQLException {
        java.sql.PreparedStatement preparedStatementPrepareStatement = prepareStatement(str);
        ((PreparedStatement) preparedStatementPrepareStatement).setRetrieveGeneratedKeys(iArr != null && iArr.length > 0);
        return preparedStatementPrepareStatement;
    }

    @Override // java.sql.Connection
    public java.sql.PreparedStatement prepareStatement(String str, String[] strArr) throws SQLException {
        java.sql.PreparedStatement preparedStatementPrepareStatement = prepareStatement(str);
        ((PreparedStatement) preparedStatementPrepareStatement).setRetrieveGeneratedKeys(strArr != null && strArr.length > 0);
        return preparedStatementPrepareStatement;
    }

    public ConnectionImpl(String str, int i, Properties properties, String str2, String str3) throws SQLException {
        this.proxy = null;
        this.realProxy = null;
        this.autoCommit = true;
        this.characterSetMetadata = null;
        this.characterSetResultsOnServer = null;
        this.charsetConverterMap = new HashMap(CharsetMapping.getNumberOfCharsetsConfigured());
        this.connectionCreationTimeMillis = 0L;
        this.database = null;
        this.dbmd = null;
        this.hasIsolationLevels = false;
        this.hasQuotedIdentifiers = false;
        this.host = null;
        this.indexToCustomMysqlCharset = null;
        this.mysqlCharsetToCustomMblen = null;
        this.f79io = null;
        this.isClientTzUTC = false;
        this.isClosed = true;
        this.isInGlobalTx = false;
        this.isRunningOnJDK13 = false;
        this.isolationLevel = 2;
        this.isServerTzUTC = false;
        this.lastQueryFinishedTime = 0L;
        this.log = NULL_LOGGER;
        this.longestQueryTimeMs = 0L;
        this.lowerCaseTableNames = false;
        this.maximumNumberTablesAccessed = 0L;
        this.sessionMaxRows = -1;
        this.minimumNumberTablesAccessed = RecyclerView.FOREVER_NS;
        this.myURL = null;
        this.needsPing = false;
        this.netBufferLength = 16384;
        this.noBackslashEscapes = false;
        this.serverTruncatesFracSecs = false;
        this.numberOfPreparedExecutes = 0L;
        this.numberOfPrepares = 0L;
        this.numberOfQueriesIssued = 0L;
        this.numberOfResultSetsCreated = 0L;
        this.oldHistBreakpoints = null;
        this.oldHistCounts = null;
        this.openStatements = new CopyOnWriteArrayList<>();
        this.parserKnowsUnicode = false;
        this.password = null;
        this.port = 3306;
        this.props = null;
        this.readInfoMsg = false;
        this.readOnly = false;
        this.serverTimezoneTZ = null;
        this.serverVariables = null;
        this.shortestQueryTimeMs = RecyclerView.FOREVER_NS;
        this.totalQueryTimeMs = 0.0d;
        this.transactionsSupported = false;
        this.useAnsiQuotes = false;
        this.user = null;
        this.useServerPreparedStmts = false;
        this.errorMessageEncoding = "Cp1252";
        this.hasTriedMasterFlag = false;
        this.statementComment = null;
        this.autoIncrementIncrement = 0;
        this.connectionCreationTimeMillis = System.currentTimeMillis();
        str2 = str2 == null ? BuildConfig.FLAVOR : str2;
        this.origHostToConnectTo = str;
        this.origPortToConnectTo = i;
        this.origDatabaseToConnectTo = str2;
        try {
            java.sql.Blob.class.getMethod("truncate", Long.TYPE);
            this.isRunningOnJDK13 = false;
        } catch (NoSuchMethodException unused) {
            this.isRunningOnJDK13 = true;
        }
        this.sessionCalendar = new GregorianCalendar();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        this.utcCalendar = gregorianCalendar;
        gregorianCalendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        this.log = LogFactory.getLogger(getLogger(), LOGGER_INSTANCE_NAME, getExceptionInterceptor());
        if (NonRegisteringDriver.isHostPropertiesList(str)) {
            Properties propertiesExpandHostKeyValues = NonRegisteringDriver.expandHostKeyValues(str);
            Enumeration<?> enumerationPropertyNames = propertiesExpandHostKeyValues.propertyNames();
            while (enumerationPropertyNames.hasMoreElements()) {
                String string = enumerationPropertyNames.nextElement().toString();
                properties.setProperty(string, propertiesExpandHostKeyValues.getProperty(string));
            }
        } else if (str == null) {
            this.host = "localhost";
            this.hostPortPair = this.host + ":" + i;
        } else {
            this.host = str;
            if (str.indexOf(":") == -1) {
                this.hostPortPair = this.host + ":" + i;
            } else {
                this.hostPortPair = this.host;
            }
        }
        this.port = i;
        this.database = str2;
        this.myURL = str3;
        this.user = properties.getProperty(NonRegisteringDriver.USER_PROPERTY_KEY);
        this.password = properties.getProperty(NonRegisteringDriver.PASSWORD_PROPERTY_KEY);
        String str4 = this.user;
        if (str4 == null || str4.equals(BuildConfig.FLAVOR)) {
            this.user = BuildConfig.FLAVOR;
        }
        if (this.password == null) {
            this.password = BuildConfig.FLAVOR;
        }
        this.props = properties;
        initializeDriverProperties(properties);
        TimeZone defaultTimeZone = TimeUtil.getDefaultTimeZone(getCacheDefaultTimezone());
        this.defaultTimeZone = defaultTimeZone;
        this.isClientTzUTC = !defaultTimeZone.useDaylightTime() && this.defaultTimeZone.getRawOffset() == 0;
        if (getUseUsageAdvisor()) {
            this.pointOfOrigin = LogUtils.findCallingClassAndMethod(new Throwable());
        } else {
            this.pointOfOrigin = BuildConfig.FLAVOR;
        }
        try {
            this.dbmd = getMetaData(false, false);
            initializeSafeStatementInterceptors();
            createNewIO(false);
            unSafeStatementInterceptors();
            NonRegisteringDriver.trackConnection(this);
        } catch (SQLException e) {
            cleanup(e);
            throw e;
        } catch (Exception e2) {
            cleanup(e2);
            StringBuilder sb = new StringBuilder(128);
            if (!getParanoid()) {
                sb.append("Cannot connect to MySQL server on ");
                sb.append(this.host);
                sb.append(":");
                sb.append(this.port);
                sb.append(".\n\n");
                sb.append("Make sure that there is a MySQL server ");
                sb.append("running on the machine/port you are trying ");
                sb.append("to connect to and that the machine this software is running on ");
                sb.append("is able to connect to this host/port (i.e. not firewalled). ");
                sb.append("Also make sure that the server has not been started with the --skip-networking ");
                sb.append("flag.\n\n");
            } else {
                sb.append("Unable to connect to database.");
            }
            SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(sb.toString(), SQLError.SQL_STATE_COMMUNICATION_LINK_FAILURE, getExceptionInterceptor());
            sQLExceptionCreateSQLException.initCause(e2);
            throw sQLExceptionCreateSQLException;
        }
    }
}
