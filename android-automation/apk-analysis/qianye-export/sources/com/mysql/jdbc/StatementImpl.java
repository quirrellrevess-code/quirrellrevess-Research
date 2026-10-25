package com.mysql.jdbc;

import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.exceptions.MySQLStatementCancelledException;
import com.mysql.jdbc.exceptions.MySQLTimeoutException;
import com.mysql.jdbc.log.LogUtils;
import com.mysql.jdbc.profiler.ProfilerEvent;
import com.mysql.jdbc.profiler.ProfilerEventHandler;
import java.io.InputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.cache.DiskLruCache;

/* JADX INFO: loaded from: classes.dex */
public class StatementImpl implements Statement {
    public static final String[] ON_DUPLICATE_KEY_UPDATE_CLAUSE = {"ON", "DUPLICATE", "KEY", "UPDATE"};
    public static final String PING_MARKER = "/* ping */";
    public static final byte USES_VARIABLES_FALSE = 0;
    public static final byte USES_VARIABLES_TRUE = 1;
    public static final byte USES_VARIABLES_UNKNOWN = -1;
    public static int statementCounter = 1;
    public List<Object> batchedArgs;
    public SingleByteCharsetConverter charConverter;
    public String charEncoding;
    public volatile MySQLConnection connection;
    public long connectionId;
    public boolean continueBatchOnError;
    public String currentCatalog;
    public boolean doEscapeProcessing;
    public ProfilerEventHandler eventSink;
    private ExceptionInterceptor exceptionInterceptor;
    public boolean holdResultsOpenOverClose;
    private InputStream localInfileInputStream;
    public int maxFieldSize;
    public boolean pedantic;
    public String pointOfOrigin;
    public boolean profileSQL;
    public boolean sendFractionalSeconds;
    public int statementId;
    public boolean useLegacyDatetimeCode;
    public boolean useUsageAdvisor;
    public final boolean version5013OrNewer;
    public Object cancelTimeoutMutex = new Object();
    public boolean wasCancelled = false;
    public boolean wasCancelledByTimeout = false;
    public Reference<MySQLConnection> physicalConnection = null;
    private int fetchSize = 0;
    public boolean isClosed = false;
    public long lastInsertId = -1;
    public int maxRows = -1;
    public Set<ResultSetInternalMethods> openResults = new HashSet();
    public ResultSetInternalMethods results = null;
    public ResultSetInternalMethods generatedKeysResults = null;
    public int resultSetConcurrency = 0;
    public int resultSetType = 0;
    public int timeoutInMillis = 0;
    public long updateCount = -1;
    public SQLWarning warningChain = null;
    public boolean clearWarningsCalled = false;
    public ArrayList<ResultSetRow> batchedGeneratedKeys = null;
    public boolean retrieveGeneratedKeys = false;
    public PingTarget pingTarget = null;
    public boolean lastQueryIsOnDupKeyUpdate = false;
    public final AtomicBoolean statementExecuting = new AtomicBoolean(false);
    private boolean isImplicitlyClosingResults = false;
    private int originalResultSetType = 0;
    private int originalFetchSize = 0;
    private boolean isPoolable = true;
    private boolean closeOnCompletion = false;

    public class CancelTask extends TimerTask {
        public SQLException caughtWhileCancelling = null;
        public long origConnId;
        public Properties origConnProps;
        public String origConnURL;
        public StatementImpl toCancel;

        public CancelTask(StatementImpl statementImpl) throws SQLException {
            this.origConnProps = null;
            this.origConnURL = BuildConfig.FLAVOR;
            this.origConnId = 0L;
            this.toCancel = statementImpl;
            this.origConnProps = new Properties();
            Properties properties = StatementImpl.this.connection.getProperties();
            Enumeration<?> enumerationPropertyNames = properties.propertyNames();
            while (enumerationPropertyNames.hasMoreElements()) {
                String string = enumerationPropertyNames.nextElement().toString();
                this.origConnProps.setProperty(string, properties.getProperty(string));
            }
            this.origConnURL = StatementImpl.this.connection.getURL();
            this.origConnId = StatementImpl.this.connection.getId();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            new Thread() { // from class: com.mysql.jdbc.StatementImpl.CancelTask.1
                /* JADX WARN: Code duplicated, block: B:100:0x012b A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:115:0x013c A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r4v1 */
                /* JADX WARN: Type inference failed for: r4v12, types: [boolean] */
                /* JADX WARN: Type inference failed for: r4v13 */
                /* JADX WARN: Type inference failed for: r4v14 */
                /* JADX WARN: Type inference failed for: r4v17, types: [com.mysql.jdbc.Connection, java.sql.Connection] */
                /* JADX WARN: Type inference failed for: r4v18 */
                /* JADX WARN: Type inference failed for: r4v19 */
                /* JADX WARN: Type inference failed for: r4v2 */
                /* JADX WARN: Type inference failed for: r4v23 */
                /* JADX WARN: Type inference failed for: r4v24 */
                /* JADX WARN: Type inference failed for: r4v25 */
                /* JADX WARN: Type inference failed for: r4v26 */
                /* JADX WARN: Type inference failed for: r4v4, types: [java.sql.Connection] */
                /* JADX WARN: Type inference failed for: r4v5, types: [java.sql.Connection] */
                /* JADX WARN: Type inference failed for: r4v6 */
                /* JADX WARN: Type inference failed for: r4v7, types: [java.sql.Connection] */
                /* JADX WARN: Type inference failed for: r4v8 */
                /* JADX WARN: Type inference failed for: r4v9 */
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() throws Throwable {
                    ?? r4;
                    java.sql.Statement statement;
                    ?? r5;
                    java.sql.Statement statementCreateStatement;
                    java.sql.Connection connection = null;
                    boolean z = false;
                    try {
                        try {
                            MySQLConnection mySQLConnection = StatementImpl.this.physicalConnection.get();
                            if (mySQLConnection == null) {
                                r5 = 0;
                                statementCreateStatement = null;
                            } else if (mySQLConnection.getQueryTimeoutKillsConnection()) {
                                StatementImpl statementImpl = CancelTask.this.toCancel;
                                statementImpl.wasCancelled = true;
                                statementImpl.wasCancelledByTimeout = true;
                                mySQLConnection.realClose(false, false, true, new MySQLStatementCancelledException(Messages.getString("Statement.ConnectionKilledDueToTimeout")));
                                r5 = 0;
                                statementCreateStatement = null;
                            } else {
                                try {
                                    synchronized (StatementImpl.this.cancelTimeoutMutex) {
                                        try {
                                            ?? Equals = CancelTask.this.origConnURL.equals(mySQLConnection.getURL());
                                            try {
                                                if (Equals != 0) {
                                                    Connection connectionDuplicate = mySQLConnection.duplicate();
                                                    statementCreateStatement = connectionDuplicate.createStatement();
                                                    statementCreateStatement.execute("KILL QUERY " + mySQLConnection.getId());
                                                    Equals = connectionDuplicate;
                                                } else {
                                                    try {
                                                        CancelTask cancelTask = CancelTask.this;
                                                        Equals = (Connection) DriverManager.getConnection(cancelTask.origConnURL, cancelTask.origConnProps);
                                                        try {
                                                            statementCreateStatement = Equals.createStatement();
                                                            try {
                                                                statementCreateStatement.execute("KILL QUERY " + CancelTask.this.origConnId);
                                                                Equals = Equals;
                                                            } catch (NullPointerException unused) {
                                                            }
                                                        } catch (NullPointerException unused2) {
                                                            statementCreateStatement = null;
                                                        }
                                                    } catch (NullPointerException unused3) {
                                                        Equals = 0;
                                                        statementCreateStatement = null;
                                                    }
                                                }
                                                StatementImpl statementImpl2 = CancelTask.this.toCancel;
                                                statementImpl2.wasCancelled = true;
                                                statementImpl2.wasCancelledByTimeout = true;
                                                r5 = Equals;
                                            } catch (Throwable th) {
                                                th = th;
                                                statement = null;
                                                r4 = Equals;
                                                try {
                                                    throw th;
                                                } catch (NullPointerException unused4) {
                                                    if (statement != null) {
                                                        try {
                                                            statement.close();
                                                        } catch (SQLException e) {
                                                            throw new RuntimeException(e.toString());
                                                        }
                                                    }
                                                    if (r4 != 0) {
                                                        try {
                                                            r4.close();
                                                        } catch (SQLException e2) {
                                                            throw new RuntimeException(e2.toString());
                                                        }
                                                    }
                                                    CancelTask cancelTask2 = CancelTask.this;
                                                    cancelTask2.toCancel = null;
                                                    cancelTask2.origConnProps = null;
                                                    cancelTask2.origConnURL = null;
                                                } catch (SQLException e3) {
                                                    e = e3;
                                                    CancelTask.this.caughtWhileCancelling = e;
                                                    if (statement != null) {
                                                        try {
                                                            statement.close();
                                                        } catch (SQLException e4) {
                                                            throw new RuntimeException(e4.toString());
                                                        }
                                                    }
                                                    if (r4 != 0) {
                                                        try {
                                                            r4.close();
                                                        } catch (SQLException e5) {
                                                            throw new RuntimeException(e5.toString());
                                                        }
                                                    }
                                                    CancelTask cancelTask3 = CancelTask.this;
                                                    cancelTask3.toCancel = null;
                                                    cancelTask3.origConnProps = null;
                                                    cancelTask3.origConnURL = null;
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            r4 = 0;
                                            statement = null;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            }
                            if (statementCreateStatement != null) {
                                try {
                                    statementCreateStatement.close();
                                } catch (SQLException e6) {
                                    throw new RuntimeException(e6.toString());
                                }
                            }
                            if (r5 != 0) {
                                try {
                                    r5.close();
                                } catch (SQLException e7) {
                                    throw new RuntimeException(e7.toString());
                                }
                            }
                        } catch (NullPointerException unused5) {
                            r4 = 0;
                            statement = null;
                        } catch (SQLException e8) {
                            e = e8;
                            r4 = 0;
                            statement = null;
                        } catch (Throwable th4) {
                            th = th4;
                            if (0 != 0) {
                                try {
                                    (z ? 1 : 0).close();
                                } catch (SQLException e9) {
                                    throw new RuntimeException(e9.toString());
                                }
                            }
                            if (0 != 0) {
                                try {
                                    connection.close();
                                } catch (SQLException e10) {
                                    throw new RuntimeException(e10.toString());
                                }
                            }
                            CancelTask cancelTask4 = CancelTask.this;
                            cancelTask4.toCancel = null;
                            cancelTask4.origConnProps = null;
                            cancelTask4.origConnURL = null;
                            throw th;
                        }
                        CancelTask cancelTask5 = CancelTask.this;
                        cancelTask5.toCancel = null;
                        cancelTask5.origConnProps = null;
                        cancelTask5.origConnURL = null;
                    } catch (Throwable th5) {
                        th = th5;
                        if (0 != 0) {
                            (z ? 1 : 0).close();
                        }
                        if (0 != 0) {
                            connection.close();
                        }
                        CancelTask cancelTask6 = CancelTask.this;
                        cancelTask6.toCancel = null;
                        cancelTask6.origConnProps = null;
                        cancelTask6.origConnURL = null;
                        throw th;
                    }
                }
            }.start();
        }
    }

    public StatementImpl(MySQLConnection mySQLConnection, String str) throws SQLException {
        this.charConverter = null;
        this.charEncoding = null;
        this.connection = null;
        this.connectionId = 0L;
        this.currentCatalog = null;
        boolean z = true;
        this.doEscapeProcessing = true;
        this.eventSink = null;
        this.maxFieldSize = MysqlIO.getMaxBuf();
        this.pedantic = false;
        this.profileSQL = false;
        this.useUsageAdvisor = false;
        this.holdResultsOpenOverClose = false;
        this.continueBatchOnError = false;
        if (mySQLConnection == null || mySQLConnection.isClosed()) {
            throw SQLError.createSQLException(Messages.getString("Statement.0"), SQLError.SQL_STATE_CONNECTION_NOT_OPEN, (ExceptionInterceptor) null);
        }
        this.connection = mySQLConnection;
        this.connectionId = this.connection.getId();
        this.exceptionInterceptor = this.connection.getExceptionInterceptor();
        this.currentCatalog = str;
        this.pedantic = this.connection.getPedantic();
        this.continueBatchOnError = this.connection.getContinueBatchOnError();
        this.useLegacyDatetimeCode = this.connection.getUseLegacyDatetimeCode();
        this.sendFractionalSeconds = this.connection.getSendFractionalSeconds();
        this.doEscapeProcessing = this.connection.getEnableEscapeProcessing();
        if (!this.connection.getDontTrackOpenResources()) {
            this.connection.registerStatement(this);
        }
        this.maxFieldSize = this.connection.getMaxAllowedPacket();
        int defaultFetchSize = this.connection.getDefaultFetchSize();
        if (defaultFetchSize != 0) {
            setFetchSize(defaultFetchSize);
        }
        if (this.connection.getUseUnicode()) {
            this.charEncoding = this.connection.getEncoding();
            this.charConverter = this.connection.getCharsetConverter(this.charEncoding);
        }
        if (!this.connection.getProfileSql() && !this.connection.getUseUsageAdvisor() && !this.connection.getLogSlowQueries()) {
            z = false;
        }
        if (this.connection.getAutoGenerateTestcaseScript() || z) {
            int i = statementCounter;
            statementCounter = i + 1;
            this.statementId = i;
        }
        if (z) {
            this.pointOfOrigin = LogUtils.findCallingClassAndMethod(new Throwable());
            this.profileSQL = this.connection.getProfileSql();
            this.useUsageAdvisor = this.connection.getUseUsageAdvisor();
            this.eventSink = ProfilerEventHandlerFactory.getInstance(this.connection);
        }
        int maxRows = this.connection.getMaxRows();
        if (maxRows != -1) {
            setMaxRows(maxRows);
        }
        this.holdResultsOpenOverClose = this.connection.getHoldResultsOpenOverStatementClose();
        this.version5013OrNewer = this.connection.versionMeetsMinimum(5, 0, 13);
    }

    private void checkAndPerformCloseOnCompletionAction() {
        ResultSetInternalMethods resultSetInternalMethods;
        ResultSetInternalMethods resultSetInternalMethods2;
        try {
            synchronized (checkClosed().getConnectionMutex()) {
                try {
                    if (isCloseOnCompletion() && !this.connection.getDontTrackOpenResources() && getOpenResultSetCount() == 0 && (((resultSetInternalMethods = this.results) == null || !resultSetInternalMethods.reallyResult() || this.results.isClosed()) && ((resultSetInternalMethods2 = this.generatedKeysResults) == null || !resultSetInternalMethods2.reallyResult() || this.generatedKeysResults.isClosed()))) {
                        realClose(false, false);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (SQLException unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ResultSetInternalMethods createResultSetUsingServerFetch(String str) throws SQLException {
        ResultSetInternalMethods resultSetInternal;
        synchronized (checkClosed().getConnectionMutex()) {
            java.sql.PreparedStatement preparedStatementPrepareStatement = this.connection.prepareStatement(str, this.resultSetType, this.resultSetConcurrency);
            preparedStatementPrepareStatement.setFetchSize(this.fetchSize);
            int i = this.maxRows;
            if (i > -1) {
                preparedStatementPrepareStatement.setMaxRows(i);
            }
            statementBegins();
            preparedStatementPrepareStatement.execute();
            resultSetInternal = ((StatementImpl) preparedStatementPrepareStatement).getResultSetInternal();
            resultSetInternal.setStatementUsedForFetchingRows((PreparedStatement) preparedStatementPrepareStatement);
            this.results = resultSetInternal;
        }
        return resultSetInternal;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0171 A[Catch: all -> 0x0019, DONT_GENERATE, TryCatch #6 {, blocks: (B:5:0x0011, B:65:0x0110, B:66:0x011a, B:76:0x0131, B:77:0x0138, B:73:0x0127, B:74:0x012e, B:90:0x0150, B:91:0x015a, B:101:0x0171, B:102:0x0178, B:98:0x0167, B:99:0x016e, B:93:0x015f, B:68:0x011f), top: B:116:0x0011, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:105:0x015f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:0x013a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x011f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:11:0x0022 A[Catch: all -> 0x014b, LOOP:0: B:10:0x0020->B:11:0x0022, LOOP_END, TryCatch #8 {all -> 0x014b, blocks: (B:9:0x001c, B:11:0x0022, B:12:0x0029), top: B:119:0x001c }] */
    /* JADX WARN: Code duplicated, block: B:121:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:20:0x0052  */
    /* JADX WARN: Code duplicated, block: B:23:0x0061  */
    /* JADX WARN: Code duplicated, block: B:24:0x0064 A[Catch: all -> 0x0145, TryCatch #4 {all -> 0x0145, blocks: (B:19:0x0049, B:21:0x0053, B:28:0x006d, B:34:0x007e, B:36:0x00a4, B:40:0x00b4, B:42:0x00c4, B:39:0x00b0, B:43:0x00d3, B:45:0x00db, B:47:0x00e0, B:55:0x00ef, B:58:0x00fa, B:60:0x00fe, B:61:0x010a, B:54:0x00eb, B:24:0x0064), top: B:113:0x0049, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x006a  */
    /* JADX WARN: Code duplicated, block: B:27:0x006c  */
    /* JADX WARN: Code duplicated, block: B:30:0x0076  */
    /* JADX WARN: Code duplicated, block: B:31:0x0077  */
    /* JADX WARN: Code duplicated, block: B:34:0x007e A[Catch: all -> 0x0145, TRY_LEAVE, TryCatch #4 {all -> 0x0145, blocks: (B:19:0x0049, B:21:0x0053, B:28:0x006d, B:34:0x007e, B:36:0x00a4, B:40:0x00b4, B:42:0x00c4, B:39:0x00b0, B:43:0x00d3, B:45:0x00db, B:47:0x00e0, B:55:0x00ef, B:58:0x00fa, B:60:0x00fe, B:61:0x010a, B:54:0x00eb, B:24:0x0064), top: B:113:0x0049, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:56:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:58:0x00fa A[Catch: all -> 0x0145, TryCatch #4 {all -> 0x0145, blocks: (B:19:0x0049, B:21:0x0053, B:28:0x006d, B:34:0x007e, B:36:0x00a4, B:40:0x00b4, B:42:0x00c4, B:39:0x00b0, B:43:0x00d3, B:45:0x00db, B:47:0x00e0, B:55:0x00ef, B:58:0x00fa, B:60:0x00fe, B:61:0x010a, B:54:0x00eb, B:24:0x0064), top: B:113:0x0049, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x00fe A[Catch: all -> 0x0145, TryCatch #4 {all -> 0x0145, blocks: (B:19:0x0049, B:21:0x0053, B:28:0x006d, B:34:0x007e, B:36:0x00a4, B:40:0x00b4, B:42:0x00c4, B:39:0x00b0, B:43:0x00d3, B:45:0x00db, B:47:0x00e0, B:55:0x00ef, B:58:0x00fa, B:60:0x00fe, B:61:0x010a, B:54:0x00eb, B:24:0x0064), top: B:113:0x0049, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x010a A[Catch: all -> 0x0145, TRY_LEAVE, TryCatch #4 {all -> 0x0145, blocks: (B:19:0x0049, B:21:0x0053, B:28:0x006d, B:34:0x007e, B:36:0x00a4, B:40:0x00b4, B:42:0x00c4, B:39:0x00b0, B:43:0x00d3, B:45:0x00db, B:47:0x00e0, B:55:0x00ef, B:58:0x00fa, B:60:0x00fe, B:61:0x010a, B:54:0x00eb, B:24:0x0064), top: B:113:0x0049, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x010b  */
    /* JADX WARN: Code duplicated, block: B:64:0x010e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x0110 A[Catch: all -> 0x0019, TRY_ENTER, TryCatch #6 {, blocks: (B:5:0x0011, B:65:0x0110, B:66:0x011a, B:76:0x0131, B:77:0x0138, B:73:0x0127, B:74:0x012e, B:90:0x0150, B:91:0x015a, B:101:0x0171, B:102:0x0178, B:98:0x0167, B:99:0x016e, B:93:0x015f, B:68:0x011f), top: B:116:0x0011, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x0131 A[Catch: all -> 0x0019, TryCatch #6 {, blocks: (B:5:0x0011, B:65:0x0110, B:66:0x011a, B:76:0x0131, B:77:0x0138, B:73:0x0127, B:74:0x012e, B:90:0x0150, B:91:0x015a, B:101:0x0171, B:102:0x0178, B:98:0x0167, B:99:0x016e, B:93:0x015f, B:68:0x011f), top: B:116:0x0011, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x0150 A[Catch: all -> 0x0019, TRY_ENTER, TryCatch #6 {, blocks: (B:5:0x0011, B:65:0x0110, B:66:0x011a, B:76:0x0131, B:77:0x0138, B:73:0x0127, B:74:0x012e, B:90:0x0150, B:91:0x015a, B:101:0x0171, B:102:0x0178, B:98:0x0167, B:99:0x016e, B:93:0x015f, B:68:0x011f), top: B:116:0x0011, inners: #0, #2 }] */
    private long[] executeBatchUsingMultiQueries(boolean z, int i, int i2) throws SQLException {
        CancelTask cancelTask;
        java.sql.Statement statementCreateStatement;
        long[] jArr;
        int i3;
        StringBuilder sb;
        CancelTask cancelTask2;
        String encoding;
        int i4;
        int i5;
        SQLException sQLExceptionHandleExceptionForBatch;
        int iProcessMultiCountsAndKeys;
        int i6;
        int i7;
        SQLException sQLException;
        int i8;
        SQLException sQLExceptionHandleExceptionForBatch2;
        SQLException sQLException2;
        String str;
        SQLException sQLException3;
        MySQLConnection mySQLConnectionCheckClosed = checkClosed();
        synchronized (mySQLConnectionCheckClosed.getConnectionMutex()) {
            if (z) {
                jArr = new long[i];
                for (i3 = 0; i3 < i; i3++) {
                    jArr[i3] = -3;
                }
                sb = new StringBuilder();
                statementCreateStatement = mySQLConnectionCheckClosed.createStatement();
                if (mySQLConnectionCheckClosed.getEnableQueryTimeouts()) {
                    cancelTask2 = null;
                    encoding = mySQLConnectionCheckClosed.getEncoding();
                    i4 = 2;
                    if (StringUtils.startsWithIgnoreCase(encoding, "utf")) {
                        i5 = 3;
                    } else if (CharsetMapping.isMultibyteCharset(encoding)) {
                        i5 = 2;
                    } else {
                        i5 = 1;
                    }
                    statementCreateStatement.setEscapeProcessing(this.doEscapeProcessing);
                    if (!this.doEscapeProcessing) {
                        i4 = 1;
                    }
                    sQLExceptionHandleExceptionForBatch = null;
                    iProcessMultiCountsAndKeys = 0;
                    i6 = 0;
                    i7 = 0;
                    while (i6 < i) {
                        str = (String) this.batchedArgs.get(i6);
                        sQLException3 = sQLExceptionHandleExceptionForBatch;
                        if (((((sb.length() + str.length()) * i5) + 1 + 4) * i4) + 32 > this.connection.getMaxAllowedPacket()) {
                            statementCreateStatement.execute(sb.toString(), 1);
                            sQLExceptionHandleExceptionForBatch = sQLException3;
                            iProcessMultiCountsAndKeys = processMultiCountsAndKeys((StatementImpl) statementCreateStatement, iProcessMultiCountsAndKeys, jArr);
                            sb = new StringBuilder();
                            i7 = 0;
                        } else {
                            sQLExceptionHandleExceptionForBatch = sQLException3;
                        }
                        sb.append(str);
                        sb.append(";");
                        i7++;
                        i6++;
                    }
                    sQLException = sQLExceptionHandleExceptionForBatch;
                    if (sb.length() > 0) {
                        i8 = 1;
                        statementCreateStatement.execute(sb.toString(), 1);
                        sQLExceptionHandleExceptionForBatch2 = sQLException;
                        processMultiCountsAndKeys((StatementImpl) statementCreateStatement, iProcessMultiCountsAndKeys, jArr);
                    } else {
                        sQLExceptionHandleExceptionForBatch2 = sQLException;
                    }
                    if (cancelTask2 != null) {
                        sQLException2 = cancelTask2.caughtWhileCancelling;
                        if (sQLException2 != null) {
                            throw sQLException2;
                        }
                        cancelTask2.cancel();
                        mySQLConnectionCheckClosed.getCancelTimer().purge();
                        cancelTask = null;
                    } else {
                        cancelTask = cancelTask2;
                    }
                    if (sQLExceptionHandleExceptionForBatch2 != null) {
                        throw SQLError.createBatchUpdateException(sQLExceptionHandleExceptionForBatch2, jArr, getExceptionInterceptor());
                    }
                    if (cancelTask != null) {
                        cancelTask.cancel();
                        mySQLConnectionCheckClosed.getCancelTimer().purge();
                    }
                    resetCancelledState();
                    if (statementCreateStatement != null) {
                        statementCreateStatement.close();
                    }
                    if (!z) {
                        mySQLConnectionCheckClosed.getIO().disableMultiQueries();
                    }
                } else {
                    cancelTask2 = null;
                    encoding = mySQLConnectionCheckClosed.getEncoding();
                    i4 = 2;
                    if (StringUtils.startsWithIgnoreCase(encoding, "utf")) {
                        i5 = 3;
                    } else if (CharsetMapping.isMultibyteCharset(encoding)) {
                        i5 = 2;
                    } else {
                        i5 = 1;
                    }
                    statementCreateStatement.setEscapeProcessing(this.doEscapeProcessing);
                    if (!this.doEscapeProcessing) {
                        i4 = 1;
                    }
                    sQLExceptionHandleExceptionForBatch = null;
                    iProcessMultiCountsAndKeys = 0;
                    i6 = 0;
                    i7 = 0;
                    while (i6 < i) {
                        str = (String) this.batchedArgs.get(i6);
                        sQLException3 = sQLExceptionHandleExceptionForBatch;
                        if (((((sb.length() + str.length()) * i5) + 1 + 4) * i4) + 32 > this.connection.getMaxAllowedPacket()) {
                            statementCreateStatement.execute(sb.toString(), 1);
                            sQLExceptionHandleExceptionForBatch = sQLException3;
                            iProcessMultiCountsAndKeys = processMultiCountsAndKeys((StatementImpl) statementCreateStatement, iProcessMultiCountsAndKeys, jArr);
                            sb = new StringBuilder();
                            i7 = 0;
                        } else {
                            sQLExceptionHandleExceptionForBatch = sQLException3;
                        }
                        sb.append(str);
                        sb.append(";");
                        i7++;
                        i6++;
                    }
                    sQLException = sQLExceptionHandleExceptionForBatch;
                    if (sb.length() > 0) {
                        i8 = 1;
                        statementCreateStatement.execute(sb.toString(), 1);
                        sQLExceptionHandleExceptionForBatch2 = sQLException;
                        processMultiCountsAndKeys((StatementImpl) statementCreateStatement, iProcessMultiCountsAndKeys, jArr);
                    } else {
                        sQLExceptionHandleExceptionForBatch2 = sQLException;
                    }
                    if (cancelTask2 != null) {
                        sQLException2 = cancelTask2.caughtWhileCancelling;
                        if (sQLException2 != null) {
                            throw sQLException2;
                        }
                        cancelTask2.cancel();
                        mySQLConnectionCheckClosed.getCancelTimer().purge();
                        cancelTask = null;
                    } else {
                        cancelTask = cancelTask2;
                    }
                    if (sQLExceptionHandleExceptionForBatch2 != null) {
                        throw SQLError.createBatchUpdateException(sQLExceptionHandleExceptionForBatch2, jArr, getExceptionInterceptor());
                    }
                    if (cancelTask != null) {
                        cancelTask.cancel();
                        mySQLConnectionCheckClosed.getCancelTimer().purge();
                    }
                    resetCancelledState();
                    if (statementCreateStatement != null) {
                        statementCreateStatement.close();
                    }
                    if (!z) {
                        mySQLConnectionCheckClosed.getIO().disableMultiQueries();
                    }
                }
            } else {
                mySQLConnectionCheckClosed.getIO().enableMultiQueries();
                try {
                    jArr = new long[i];
                    while (i3 < i) {
                        jArr[i3] = -3;
                    }
                    sb = new StringBuilder();
                    statementCreateStatement = mySQLConnectionCheckClosed.createStatement();
                    try {
                        if (mySQLConnectionCheckClosed.getEnableQueryTimeouts() || i2 == 0 || !mySQLConnectionCheckClosed.versionMeetsMinimum(5, 0, 0)) {
                            cancelTask2 = null;
                        } else {
                            cancelTask2 = new CancelTask((StatementImpl) statementCreateStatement);
                            try {
                                mySQLConnectionCheckClosed.getCancelTimer().schedule(cancelTask2, i2);
                            } catch (Throwable th) {
                                th = th;
                                cancelTask = cancelTask2;
                                if (cancelTask != null) {
                                    cancelTask.cancel();
                                    mySQLConnectionCheckClosed.getCancelTimer().purge();
                                }
                                resetCancelledState();
                                if (statementCreateStatement != null) {
                                    try {
                                        statementCreateStatement.close();
                                    } finally {
                                        if (!z) {
                                            mySQLConnectionCheckClosed.getIO().disableMultiQueries();
                                        }
                                    }
                                }
                                throw th;
                            }
                        }
                        encoding = mySQLConnectionCheckClosed.getEncoding();
                        i4 = 2;
                        if (StringUtils.startsWithIgnoreCase(encoding, "utf")) {
                            i5 = 3;
                        } else if (CharsetMapping.isMultibyteCharset(encoding)) {
                            i5 = 2;
                        } else {
                            i5 = 1;
                        }
                        statementCreateStatement.setEscapeProcessing(this.doEscapeProcessing);
                        if (!this.doEscapeProcessing) {
                            i4 = 1;
                        }
                        sQLExceptionHandleExceptionForBatch = null;
                        iProcessMultiCountsAndKeys = 0;
                        i6 = 0;
                        i7 = 0;
                        while (i6 < i) {
                            str = (String) this.batchedArgs.get(i6);
                            sQLException3 = sQLExceptionHandleExceptionForBatch;
                            if (((((sb.length() + str.length()) * i5) + 1 + 4) * i4) + 32 > this.connection.getMaxAllowedPacket()) {
                                try {
                                    statementCreateStatement.execute(sb.toString(), 1);
                                    sQLExceptionHandleExceptionForBatch = sQLException3;
                                } catch (SQLException e) {
                                    sQLExceptionHandleExceptionForBatch = handleExceptionForBatch(i6, i7, jArr, e);
                                }
                                iProcessMultiCountsAndKeys = processMultiCountsAndKeys((StatementImpl) statementCreateStatement, iProcessMultiCountsAndKeys, jArr);
                                sb = new StringBuilder();
                                i7 = 0;
                            } else {
                                sQLExceptionHandleExceptionForBatch = sQLException3;
                            }
                            sb.append(str);
                            sb.append(";");
                            i7++;
                            i6++;
                        }
                        sQLException = sQLExceptionHandleExceptionForBatch;
                        if (sb.length() > 0) {
                            try {
                                i8 = 1;
                                try {
                                    statementCreateStatement.execute(sb.toString(), 1);
                                    sQLExceptionHandleExceptionForBatch2 = sQLException;
                                } catch (SQLException e2) {
                                    e = e2;
                                    sQLExceptionHandleExceptionForBatch2 = handleExceptionForBatch(i6 - i8, i7, jArr, e);
                                }
                            } catch (SQLException e3) {
                                e = e3;
                                i8 = 1;
                            }
                            processMultiCountsAndKeys((StatementImpl) statementCreateStatement, iProcessMultiCountsAndKeys, jArr);
                        } else {
                            sQLExceptionHandleExceptionForBatch2 = sQLException;
                        }
                        if (cancelTask2 != null) {
                            sQLException2 = cancelTask2.caughtWhileCancelling;
                            if (sQLException2 != null) {
                                throw sQLException2;
                            }
                            cancelTask2.cancel();
                            mySQLConnectionCheckClosed.getCancelTimer().purge();
                            cancelTask = null;
                        } else {
                            cancelTask = cancelTask2;
                        }
                        if (sQLExceptionHandleExceptionForBatch2 != null) {
                            try {
                                throw SQLError.createBatchUpdateException(sQLExceptionHandleExceptionForBatch2, jArr, getExceptionInterceptor());
                            } catch (Throwable th2) {
                                th = th2;
                                if (cancelTask != null) {
                                    cancelTask.cancel();
                                    mySQLConnectionCheckClosed.getCancelTimer().purge();
                                }
                                resetCancelledState();
                                if (statementCreateStatement != null) {
                                    statementCreateStatement.close();
                                }
                                throw th;
                            }
                        }
                        if (cancelTask != null) {
                            cancelTask.cancel();
                            mySQLConnectionCheckClosed.getCancelTimer().purge();
                        }
                        resetCancelledState();
                        if (statementCreateStatement != null) {
                            try {
                                statementCreateStatement.close();
                            } catch (Throwable th3) {
                                if (z) {
                                    throw th3;
                                }
                                mySQLConnectionCheckClosed.getIO().disableMultiQueries();
                                throw th3;
                            }
                        }
                        if (!z) {
                            mySQLConnectionCheckClosed.getIO().disableMultiQueries();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        cancelTask = null;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    cancelTask = null;
                    statementCreateStatement = null;
                }
            }
            throw th;
        }
        return jArr;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x01f4 */
    /* JADX WARN: Code duplicated, block: B:101:0x017f A[Catch: all -> 0x01ed, TryCatch #8 {all -> 0x01ed, blocks: (B:97:0x0177, B:99:0x017b, B:101:0x017f, B:103:0x018a, B:104:0x018d, B:102:0x0185, B:105:0x018e), top: B:179:0x0177 }] */
    /* JADX WARN: Code duplicated, block: B:102:0x0185 A[Catch: all -> 0x01ed, TryCatch #8 {all -> 0x01ed, blocks: (B:97:0x0177, B:99:0x017b, B:101:0x017f, B:103:0x018a, B:104:0x018d, B:102:0x0185, B:105:0x018e), top: B:179:0x0177 }] */
    /* JADX WARN: Code duplicated, block: B:105:0x018e A[Catch: all -> 0x01ed, DONT_GENERATE, TRY_LEAVE, TryCatch #8 {all -> 0x01ed, blocks: (B:97:0x0177, B:99:0x017b, B:101:0x017f, B:103:0x018a, B:104:0x018d, B:102:0x0185, B:105:0x018e), top: B:179:0x0177 }] */
    /* JADX WARN: Code duplicated, block: B:109:0x019d A[Catch: all -> 0x01d0, TryCatch #11 {all -> 0x01d0, blocks: (B:112:0x01a4, B:115:0x01b7, B:116:0x01bf, B:118:0x01c9, B:122:0x01d7, B:107:0x0191, B:109:0x019d), top: B:182:0x0191 }] */
    /* JADX WARN: Code duplicated, block: B:154:0x021f A[Catch: all -> 0x021b, TryCatch #16 {all -> 0x021b, blocks: (B:150:0x0210, B:154:0x021f, B:155:0x0222), top: B:192:0x0210 }] */
    /* JADX WARN: Code duplicated, block: B:171:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:175:0x00f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:179:0x0177 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:180:0x0165 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:182:0x0191 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:192:0x0210 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:70:0x010b  */
    /* JADX WARN: Code duplicated, block: B:75:0x0118 A[Catch: all -> 0x0124, TryCatch #4 {all -> 0x0124, blocks: (B:73:0x0112, B:75:0x0118, B:81:0x012d), top: B:171:0x0112 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x011f  */
    /* JADX WARN: Code duplicated, block: B:79:0x0127  */
    /* JADX WARN: Code duplicated, block: B:81:0x012d A[Catch: all -> 0x0124, TRY_LEAVE, TryCatch #4 {all -> 0x0124, blocks: (B:73:0x0112, B:75:0x0118, B:81:0x012d), top: B:171:0x0112 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x0130  */
    /* JADX WARN: Code duplicated, block: B:90:0x0169 A[Catch: all -> 0x016f, TryCatch #9 {all -> 0x016f, blocks: (B:88:0x0165, B:90:0x0169, B:91:0x016e), top: B:180:0x0165 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x016e A[Catch: all -> 0x016f, TRY_LEAVE, TryCatch #9 {all -> 0x016f, blocks: (B:88:0x0165, B:90:0x0169, B:91:0x016e), top: B:180:0x0165 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0173  */
    /* JADX WARN: Code duplicated, block: B:99:0x017b A[Catch: all -> 0x01ed, TryCatch #8 {all -> 0x01ed, blocks: (B:97:0x0177, B:99:0x017b, B:101:0x017f, B:103:0x018a, B:104:0x018d, B:102:0x0185, B:105:0x018e), top: B:179:0x0177 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean executeInternal(java.lang.String r24, boolean r25) throws java.sql.SQLException {
        /*
            Method dump skipped, instruction units count: 562
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mysql.jdbc.StatementImpl.executeInternal(java.lang.String, boolean):boolean");
    }

    public static int findStartOfStatement(String str) {
        if (StringUtils.startsWithIgnoreCaseAndWs(str, "/*")) {
            int iIndexOf = str.indexOf("*/");
            if (iIndexOf == -1) {
                return 0;
            }
            return iIndexOf + 2;
        }
        if (!StringUtils.startsWithIgnoreCaseAndWs(str, "--") && !StringUtils.startsWithIgnoreCaseAndWs(str, "#")) {
            return 0;
        }
        int iIndexOf2 = str.indexOf(10);
        if (iIndexOf2 != -1) {
            return iIndexOf2;
        }
        int iIndexOf3 = str.indexOf(13);
        if (iIndexOf3 == -1) {
            return 0;
        }
        return iIndexOf3;
    }

    public static int getOnDuplicateKeyLocation(String str, boolean z, boolean z2, boolean z3) {
        if (!z || z2) {
            return StringUtils.indexOfIgnoreCase(0, str, ON_DUPLICATE_KEY_UPDATE_CLAUSE, "\"'`", "\"'`", z3 ? StringUtils.SEARCH_MODE__MRK_COM_WS : StringUtils.SEARCH_MODE__ALL);
        }
        return -1;
    }

    private long getRecordCountFromInfo(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i = 0;
        char cCharAt = 0;
        while (i < length) {
            cCharAt = str.charAt(i);
            if (Character.isDigit(cCharAt)) {
                break;
            }
            i++;
        }
        sb.append(cCharAt);
        while (true) {
            i++;
            if (i >= length) {
                break;
            }
            cCharAt = str.charAt(i);
            if (!Character.isDigit(cCharAt)) {
                break;
            }
            sb.append(cCharAt);
        }
        long j = Long.parseLong(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        while (i < length) {
            cCharAt = str.charAt(i);
            if (Character.isDigit(cCharAt)) {
                break;
            }
            i++;
        }
        sb2.append(cCharAt);
        while (true) {
            i++;
            if (i >= length) {
                break;
            }
            char cCharAt2 = str.charAt(i);
            if (!Character.isDigit(cCharAt2)) {
                break;
            }
            sb2.append(cCharAt2);
        }
        return j - Long.parseLong(sb2.toString());
    }

    private boolean useServerFetch() throws SQLException {
        boolean z;
        synchronized (checkClosed().getConnectionMutex()) {
            z = this.connection.isCursorFetchEnabled() && this.fetchSize > 0 && this.resultSetConcurrency == 1007 && this.resultSetType == 1003;
        }
        return z;
    }

    @Override // java.sql.Statement
    public void addBatch(String str) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.batchedArgs == null) {
                this.batchedArgs = new ArrayList();
            }
            if (str != null) {
                this.batchedArgs.add(str);
            }
        }
    }

    @Override // java.sql.Statement
    public void cancel() throws Throwable {
        Connection connectionDuplicate;
        if (!this.statementExecuting.get() || this.isClosed || this.connection == null || !this.connection.versionMeetsMinimum(5, 0, 0)) {
            return;
        }
        java.sql.Statement statementCreateStatement = null;
        try {
            connectionDuplicate = this.connection.duplicate();
            try {
                statementCreateStatement = connectionDuplicate.createStatement();
                statementCreateStatement.execute("KILL QUERY " + this.connection.getIO().getThreadId());
                this.wasCancelled = true;
                if (statementCreateStatement != null) {
                    statementCreateStatement.close();
                }
                if (connectionDuplicate != null) {
                    connectionDuplicate.close();
                }
            } catch (Throwable th) {
                th = th;
                if (statementCreateStatement != null) {
                    statementCreateStatement.close();
                }
                if (connectionDuplicate != null) {
                    connectionDuplicate.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            connectionDuplicate = null;
        }
    }

    public MySQLConnection checkClosed() throws SQLException {
        MySQLConnection mySQLConnection = this.connection;
        if (mySQLConnection != null) {
            return mySQLConnection;
        }
        throw SQLError.createSQLException(Messages.getString("Statement.49"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
    }

    public void checkForDml(String str, char c) throws SQLException {
        if (c == 'I' || c == 'U' || c == 'D' || c == 'A' || c == 'C' || c == 'T' || c == 'R') {
            String strStripComments = StringUtils.stripComments(str, "'\"", "'\"", true, false, true, true);
            if (StringUtils.startsWithIgnoreCaseAndWs(strStripComments, "INSERT") || StringUtils.startsWithIgnoreCaseAndWs(strStripComments, "UPDATE") || StringUtils.startsWithIgnoreCaseAndWs(strStripComments, "DELETE") || StringUtils.startsWithIgnoreCaseAndWs(strStripComments, "DROP") || StringUtils.startsWithIgnoreCaseAndWs(strStripComments, "CREATE") || StringUtils.startsWithIgnoreCaseAndWs(strStripComments, "ALTER") || StringUtils.startsWithIgnoreCaseAndWs(strStripComments, "TRUNCATE") || StringUtils.startsWithIgnoreCaseAndWs(strStripComments, "RENAME")) {
                throw SQLError.createSQLException(Messages.getString("Statement.57"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
        }
    }

    public void checkNullOrEmptyQuery(String str) throws SQLException {
        if (str == null) {
            throw SQLError.createSQLException(Messages.getString("Statement.59"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
        if (str.length() == 0) {
            throw SQLError.createSQLException(Messages.getString("Statement.61"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
    }

    @Override // java.sql.Statement
    public void clearBatch() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            List<Object> list = this.batchedArgs;
            if (list != null) {
                list.clear();
            }
        }
    }

    @Override // java.sql.Statement
    public void clearWarnings() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            this.clearWarningsCalled = true;
            this.warningChain = null;
        }
    }

    @Override // java.sql.Statement, java.lang.AutoCloseable
    public void close() throws SQLException {
        realClose(true, true);
    }

    public void closeAllOpenResults() throws SQLException {
        MySQLConnection mySQLConnection = this.connection;
        if (mySQLConnection == null) {
            return;
        }
        synchronized (mySQLConnection.getConnectionMutex()) {
            Set<ResultSetInternalMethods> set = this.openResults;
            if (set != null) {
                Iterator<ResultSetInternalMethods> it = set.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().realClose(false);
                    } catch (SQLException e) {
                        AssertionFailedException.shouldNotHappen(e);
                    }
                }
                this.openResults.clear();
            }
        }
    }

    public void closeOnCompletion() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            this.closeOnCompletion = true;
        }
    }

    public boolean containsOnDuplicateKeyInString(String str) {
        return getOnDuplicateKeyLocation(str, this.connection.getDontCheckOnDuplicateKeyUpdateInSQL(), this.connection.getRewriteBatchedStatements(), this.connection.isNoBackslashEscapesSet()) != -1;
    }

    public boolean createStreamingResultSet() {
        return this.resultSetType == 1003 && this.resultSetConcurrency == 1007 && this.fetchSize == Integer.MIN_VALUE;
    }

    @Override // com.mysql.jdbc.Statement
    public void disableStreamingResults() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.fetchSize == Integer.MIN_VALUE && this.resultSetType == 1003) {
                setFetchSize(this.originalFetchSize);
                setResultSetType(this.originalResultSetType);
            }
        }
    }

    public void doPingInstead() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            PingTarget pingTarget = this.pingTarget;
            if (pingTarget != null) {
                pingTarget.doPing();
            } else {
                this.connection.ping();
            }
            this.results = generatePingResultSet();
        }
    }

    @Override // com.mysql.jdbc.Statement
    public void enableStreamingResults() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            this.originalResultSetType = this.resultSetType;
            this.originalFetchSize = this.fetchSize;
            setFetchSize(Integer.MIN_VALUE);
            setResultSetType(MysqlErrorNumbers.ER_YES);
        }
    }

    @Override // java.sql.Statement
    public boolean execute(String str) throws SQLException {
        return executeInternal(str, false);
    }

    @Override // java.sql.Statement
    public int[] executeBatch() throws SQLException {
        return Util.truncateAndConvertToInt(executeBatchInternal());
    }

    public long[] executeBatchInternal() throws SQLException {
        TimerTask timerTask;
        CancelTask cancelTask;
        long[] jArr;
        CancelTask cancelTask2;
        MySQLConnection mySQLConnectionCheckClosed = checkClosed();
        synchronized (mySQLConnectionCheckClosed.getConnectionMutex()) {
            if (mySQLConnectionCheckClosed.isReadOnly()) {
                throw SQLError.createSQLException(Messages.getString("Statement.34") + Messages.getString("Statement.35"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            implicitlyCloseAllOpenResults();
            List<Object> list = this.batchedArgs;
            if (list != null && list.size() != 0) {
                int i = this.timeoutInMillis;
                this.timeoutInMillis = 0;
                try {
                    resetCancelledState();
                    statementBegins();
                    try {
                        try {
                            this.retrieveGeneratedKeys = true;
                            List<Object> list2 = this.batchedArgs;
                            if (list2 != null) {
                                int size = list2.size();
                                this.batchedGeneratedKeys = new ArrayList<>(this.batchedArgs.size());
                                boolean allowMultiQueries = mySQLConnectionCheckClosed.getAllowMultiQueries();
                                if (mySQLConnectionCheckClosed.versionMeetsMinimum(4, 1, 1) && (allowMultiQueries || (mySQLConnectionCheckClosed.getRewriteBatchedStatements() && size > 4))) {
                                    long[] jArrExecuteBatchUsingMultiQueries = executeBatchUsingMultiQueries(allowMultiQueries, size, i);
                                    this.statementExecuting.set(false);
                                    resetCancelledState();
                                    this.timeoutInMillis = i;
                                    clearBatch();
                                    return jArrExecuteBatchUsingMultiQueries;
                                }
                                if (mySQLConnectionCheckClosed.getEnableQueryTimeouts() && i != 0 && mySQLConnectionCheckClosed.versionMeetsMinimum(5, 0, 0)) {
                                    cancelTask = new CancelTask(this);
                                    try {
                                        mySQLConnectionCheckClosed.getCancelTimer().schedule(cancelTask, i);
                                    } catch (Throwable th) {
                                        th = th;
                                        this.statementExecuting.set(false);
                                        throw th;
                                    }
                                } else {
                                    cancelTask = null;
                                }
                                jArr = new long[size];
                                for (int i2 = 0; i2 < size; i2++) {
                                    jArr[i2] = -3;
                                }
                                SQLException e = null;
                                for (int i3 = 0; i3 < size; i3++) {
                                    try {
                                        String str = (String) this.batchedArgs.get(i3);
                                        jArr[i3] = executeUpdateInternal(str, true, true);
                                        getBatchedGeneratedKeys((this.results.getFirstCharOfQuery() == 'I' && containsOnDuplicateKeyInString(str)) ? 1 : 0);
                                    } catch (SQLException e2) {
                                        e = e2;
                                        jArr[i3] = -3;
                                        if (!this.continueBatchOnError || (e instanceof MySQLTimeoutException) || (e instanceof MySQLStatementCancelledException) || hasDeadlockOrTimeoutRolledBackTx(e)) {
                                            long[] jArr2 = new long[i3];
                                            if (hasDeadlockOrTimeoutRolledBackTx(e)) {
                                                for (int i4 = 0; i4 < i3; i4++) {
                                                    jArr2[i4] = -3;
                                                }
                                            } else {
                                                System.arraycopy(jArr, 0, jArr2, 0, i3);
                                            }
                                            throw SQLError.createBatchUpdateException(e, jArr2, getExceptionInterceptor());
                                        }
                                    }
                                }
                                if (e != null) {
                                    throw SQLError.createBatchUpdateException(e, jArr, getExceptionInterceptor());
                                }
                                if (0 != 0) {
                                    timerTask.cancel();
                                    mySQLConnectionCheckClosed.getCancelTimer().purge();
                                }
                                resetCancelledState();
                                this.timeoutInMillis = i;
                                clearBatch();
                                throw th;
                            }
                            cancelTask = null;
                            jArr = null;
                            if (cancelTask != null) {
                                SQLException sQLException = cancelTask.caughtWhileCancelling;
                                if (sQLException != null) {
                                    throw sQLException;
                                }
                                cancelTask.cancel();
                                mySQLConnectionCheckClosed.getCancelTimer().purge();
                                cancelTask2 = null;
                            } else {
                                cancelTask2 = cancelTask;
                            }
                            if (jArr == null) {
                                try {
                                    jArr = new long[0];
                                } catch (Throwable th2) {
                                    th = th2;
                                    this.statementExecuting.set(false);
                                    throw th;
                                }
                            }
                            this.statementExecuting.set(false);
                            if (cancelTask2 != null) {
                                cancelTask2.cancel();
                                mySQLConnectionCheckClosed.getCancelTimer().purge();
                            }
                            resetCancelledState();
                            this.timeoutInMillis = i;
                            clearBatch();
                            return jArr;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    timerTask = null;
                }
            }
            return new long[0];
        }
    }

    public long[] executeLargeBatch() throws SQLException {
        return executeBatchInternal();
    }

    public long executeLargeUpdate(String str) throws SQLException {
        return executeUpdateInternal(str, false, false);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0171 */
    /* JADX WARN: Code duplicated, block: B:117:0x0190 A[Catch: all -> 0x01a0, TryCatch #1 {, blocks: (B:4:0x000d, B:6:0x0023, B:8:0x002b, B:9:0x0030, B:11:0x0032, B:13:0x0039, B:15:0x0047, B:16:0x004a, B:17:0x004e, B:19:0x005f, B:20:0x0065, B:81:0x012e, B:83:0x0136, B:86:0x0144, B:87:0x0147, B:89:0x0151, B:93:0x0165, B:94:0x0167, B:90:0x0157, B:92:0x015f, B:115:0x0188, B:117:0x0190, B:119:0x019c, B:120:0x019f), top: B:126:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:119:0x019c A[Catch: all -> 0x01a0, TryCatch #1 {, blocks: (B:4:0x000d, B:6:0x0023, B:8:0x002b, B:9:0x0030, B:11:0x0032, B:13:0x0039, B:15:0x0047, B:16:0x004a, B:17:0x004e, B:19:0x005f, B:20:0x0065, B:81:0x012e, B:83:0x0136, B:86:0x0144, B:87:0x0147, B:89:0x0151, B:93:0x0165, B:94:0x0167, B:90:0x0157, B:92:0x015f, B:115:0x0188, B:117:0x0190, B:119:0x019c, B:120:0x019f), top: B:126:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:129:0x00ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:131:0x0116 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:136:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:141:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x0091  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:52:0x00c0 A[Catch: all -> 0x00c8, TRY_LEAVE, TryCatch #3 {all -> 0x00c8, blocks: (B:50:0x00ba, B:52:0x00c0), top: B:129:0x00ba }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:57:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ff A[Catch: all -> 0x010c, TryCatch #7 {all -> 0x010c, blocks: (B:63:0x00fb, B:65:0x00ff, B:66:0x010b), top: B:136:0x00fb }] */
    /* JADX WARN: Code duplicated, block: B:66:0x010b A[Catch: all -> 0x010c, TRY_LEAVE, TryCatch #7 {all -> 0x010c, blocks: (B:63:0x00fb, B:65:0x00ff, B:66:0x010b), top: B:136:0x00fb }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0112  */
    /* JADX WARN: Code duplicated, block: B:74:0x011a A[Catch: all -> 0x0169, TryCatch #4 {all -> 0x0169, blocks: (B:72:0x0116, B:74:0x011a, B:76:0x011e, B:78:0x0129, B:79:0x012c, B:77:0x0124, B:80:0x012d), top: B:131:0x0116 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x011e A[Catch: all -> 0x0169, TryCatch #4 {all -> 0x0169, blocks: (B:72:0x0116, B:74:0x011a, B:76:0x011e, B:78:0x0129, B:79:0x012c, B:77:0x0124, B:80:0x012d), top: B:131:0x0116 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0124 A[Catch: all -> 0x0169, TryCatch #4 {all -> 0x0169, blocks: (B:72:0x0116, B:74:0x011a, B:76:0x011e, B:78:0x0129, B:79:0x012c, B:77:0x0124, B:80:0x012d), top: B:131:0x0116 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x012d A[Catch: all -> 0x0169, DONT_GENERATE, TRY_LEAVE, TryCatch #4 {all -> 0x0169, blocks: (B:72:0x0116, B:74:0x011a, B:76:0x011e, B:78:0x0129, B:79:0x012c, B:77:0x0124, B:80:0x012d), top: B:131:0x0116 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x0136 A[Catch: all -> 0x01a0, TryCatch #1 {, blocks: (B:4:0x000d, B:6:0x0023, B:8:0x002b, B:9:0x0030, B:11:0x0032, B:13:0x0039, B:15:0x0047, B:16:0x004a, B:17:0x004e, B:19:0x005f, B:20:0x0065, B:81:0x012e, B:83:0x0136, B:86:0x0144, B:87:0x0147, B:89:0x0151, B:93:0x0165, B:94:0x0167, B:90:0x0157, B:92:0x015f, B:115:0x0188, B:117:0x0190, B:119:0x019c, B:120:0x019f), top: B:126:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0144 A[Catch: all -> 0x01a0, TryCatch #1 {, blocks: (B:4:0x000d, B:6:0x0023, B:8:0x002b, B:9:0x0030, B:11:0x0032, B:13:0x0039, B:15:0x0047, B:16:0x004a, B:17:0x004e, B:19:0x005f, B:20:0x0065, B:81:0x012e, B:83:0x0136, B:86:0x0144, B:87:0x0147, B:89:0x0151, B:93:0x0165, B:94:0x0167, B:90:0x0157, B:92:0x015f, B:115:0x0188, B:117:0x0190, B:119:0x019c, B:120:0x019f), top: B:126:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:89:0x0151 A[Catch: all -> 0x01a0, TryCatch #1 {, blocks: (B:4:0x000d, B:6:0x0023, B:8:0x002b, B:9:0x0030, B:11:0x0032, B:13:0x0039, B:15:0x0047, B:16:0x004a, B:17:0x004e, B:19:0x005f, B:20:0x0065, B:81:0x012e, B:83:0x0136, B:86:0x0144, B:87:0x0147, B:89:0x0151, B:93:0x0165, B:94:0x0167, B:90:0x0157, B:92:0x015f, B:115:0x0188, B:117:0x0190, B:119:0x019c, B:120:0x019f), top: B:126:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:90:0x0157 A[Catch: all -> 0x01a0, TryCatch #1 {, blocks: (B:4:0x000d, B:6:0x0023, B:8:0x002b, B:9:0x0030, B:11:0x0032, B:13:0x0039, B:15:0x0047, B:16:0x004a, B:17:0x004e, B:19:0x005f, B:20:0x0065, B:81:0x012e, B:83:0x0136, B:86:0x0144, B:87:0x0147, B:89:0x0151, B:93:0x0165, B:94:0x0167, B:90:0x0157, B:92:0x015f, B:115:0x0188, B:117:0x0190, B:119:0x019c, B:120:0x019f), top: B:126:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:92:0x015f A[Catch: all -> 0x01a0, TryCatch #1 {, blocks: (B:4:0x000d, B:6:0x0023, B:8:0x002b, B:9:0x0030, B:11:0x0032, B:13:0x0039, B:15:0x0047, B:16:0x004a, B:17:0x004e, B:19:0x005f, B:20:0x0065, B:81:0x012e, B:83:0x0136, B:86:0x0144, B:87:0x0147, B:89:0x0151, B:93:0x0165, B:94:0x0167, B:90:0x0157, B:92:0x015f, B:115:0x0188, B:117:0x0190, B:119:0x019c, B:120:0x019f), top: B:126:0x000d }] */
    @Override // java.sql.Statement
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.sql.ResultSet executeQuery(java.lang.String r21) throws java.sql.SQLException {
        /*
            Method dump skipped, instruction units count: 419
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mysql.jdbc.StatementImpl.executeQuery(java.lang.String):java.sql.ResultSet");
    }

    public void executeSimpleNonQuery(MySQLConnection mySQLConnection, String str) throws SQLException {
        mySQLConnection.execSQL(this, str, -1, null, MysqlErrorNumbers.ER_YES, MysqlErrorNumbers.ER_DB_CREATE_EXISTS, false, this.currentCatalog, null, false).close();
    }

    @Override // java.sql.Statement
    public int executeUpdate(String str) throws SQLException {
        return Util.truncateAndConvertToInt(executeLargeUpdate(str));
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0168 */
    /* JADX WARN: Code duplicated, block: B:110:0x0191 A[Catch: all -> 0x01df, TryCatch #13 {, blocks: (B:4:0x000f, B:8:0x0029, B:12:0x0032, B:14:0x0038, B:16:0x0048, B:17:0x004b, B:18:0x004f, B:20:0x0056, B:22:0x005e, B:26:0x006b, B:78:0x012d, B:80:0x0132, B:83:0x0140, B:85:0x0145, B:86:0x014a, B:87:0x015d, B:108:0x018c, B:110:0x0191, B:112:0x019d, B:114:0x01a2, B:115:0x01a7, B:116:0x01a8, B:117:0x01b8, B:118:0x01b9, B:119:0x01de), top: B:147:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:112:0x019d A[Catch: all -> 0x01df, TryCatch #13 {, blocks: (B:4:0x000f, B:8:0x0029, B:12:0x0032, B:14:0x0038, B:16:0x0048, B:17:0x004b, B:18:0x004f, B:20:0x0056, B:22:0x005e, B:26:0x006b, B:78:0x012d, B:80:0x0132, B:83:0x0140, B:85:0x0145, B:86:0x014a, B:87:0x015d, B:108:0x018c, B:110:0x0191, B:112:0x019d, B:114:0x01a2, B:115:0x01a7, B:116:0x01a8, B:117:0x01b8, B:118:0x01b9, B:119:0x01de), top: B:147:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:114:0x01a2 A[Catch: all -> 0x01df, TryCatch #13 {, blocks: (B:4:0x000f, B:8:0x0029, B:12:0x0032, B:14:0x0038, B:16:0x0048, B:17:0x004b, B:18:0x004f, B:20:0x0056, B:22:0x005e, B:26:0x006b, B:78:0x012d, B:80:0x0132, B:83:0x0140, B:85:0x0145, B:86:0x014a, B:87:0x015d, B:108:0x018c, B:110:0x0191, B:112:0x019d, B:114:0x01a2, B:115:0x01a7, B:116:0x01a8, B:117:0x01b8, B:118:0x01b9, B:119:0x01de), top: B:147:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:123:0x00b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:133:0x00fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:146:0x0113 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:61:0x00fe A[Catch: all -> 0x010a, TryCatch #5 {all -> 0x010a, blocks: (B:59:0x00fa, B:61:0x00fe, B:62:0x0109), top: B:133:0x00fa }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0109 A[Catch: all -> 0x010a, TRY_LEAVE, TryCatch #5 {all -> 0x010a, blocks: (B:59:0x00fa, B:61:0x00fe, B:62:0x0109), top: B:133:0x00fa }] */
    /* JADX WARN: Code duplicated, block: B:65:0x010e  */
    /* JADX WARN: Code duplicated, block: B:70:0x0117 A[Catch: all -> 0x015f, TryCatch #12 {all -> 0x015f, blocks: (B:68:0x0113, B:70:0x0117, B:72:0x011b, B:74:0x0126, B:75:0x0129, B:73:0x0121, B:76:0x012a), top: B:146:0x0113 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x011b A[Catch: all -> 0x015f, TryCatch #12 {all -> 0x015f, blocks: (B:68:0x0113, B:70:0x0117, B:72:0x011b, B:74:0x0126, B:75:0x0129, B:73:0x0121, B:76:0x012a), top: B:146:0x0113 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0121 A[Catch: all -> 0x015f, TryCatch #12 {all -> 0x015f, blocks: (B:68:0x0113, B:70:0x0117, B:72:0x011b, B:74:0x0126, B:75:0x0129, B:73:0x0121, B:76:0x012a), top: B:146:0x0113 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x012a A[Catch: all -> 0x015f, DONT_GENERATE, TRY_LEAVE, TryCatch #12 {all -> 0x015f, blocks: (B:68:0x0113, B:70:0x0117, B:72:0x011b, B:74:0x0126, B:75:0x0129, B:73:0x0121, B:76:0x012a), top: B:146:0x0113 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x0132 A[Catch: all -> 0x01df, TryCatch #13 {, blocks: (B:4:0x000f, B:8:0x0029, B:12:0x0032, B:14:0x0038, B:16:0x0048, B:17:0x004b, B:18:0x004f, B:20:0x0056, B:22:0x005e, B:26:0x006b, B:78:0x012d, B:80:0x0132, B:83:0x0140, B:85:0x0145, B:86:0x014a, B:87:0x015d, B:108:0x018c, B:110:0x0191, B:112:0x019d, B:114:0x01a2, B:115:0x01a7, B:116:0x01a8, B:117:0x01b8, B:118:0x01b9, B:119:0x01de), top: B:147:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:83:0x0140 A[Catch: all -> 0x01df, TryCatch #13 {, blocks: (B:4:0x000f, B:8:0x0029, B:12:0x0032, B:14:0x0038, B:16:0x0048, B:17:0x004b, B:18:0x004f, B:20:0x0056, B:22:0x005e, B:26:0x006b, B:78:0x012d, B:80:0x0132, B:83:0x0140, B:85:0x0145, B:86:0x014a, B:87:0x015d, B:108:0x018c, B:110:0x0191, B:112:0x019d, B:114:0x01a2, B:115:0x01a7, B:116:0x01a8, B:117:0x01b8, B:118:0x01b9, B:119:0x01de), top: B:147:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0145 A[Catch: all -> 0x01df, TryCatch #13 {, blocks: (B:4:0x000f, B:8:0x0029, B:12:0x0032, B:14:0x0038, B:16:0x0048, B:17:0x004b, B:18:0x004f, B:20:0x0056, B:22:0x005e, B:26:0x006b, B:78:0x012d, B:80:0x0132, B:83:0x0140, B:85:0x0145, B:86:0x014a, B:87:0x015d, B:108:0x018c, B:110:0x0191, B:112:0x019d, B:114:0x01a2, B:115:0x01a7, B:116:0x01a8, B:117:0x01b8, B:118:0x01b9, B:119:0x01de), top: B:147:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long executeUpdateInternal(java.lang.String r23, boolean r24, boolean r25) throws java.sql.SQLException {
        /*
            Method dump skipped, instruction units count: 482
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mysql.jdbc.StatementImpl.executeUpdateInternal(java.lang.String, boolean, boolean):long");
    }

    public ResultSetInternalMethods generatePingResultSet() throws SQLException {
        ResultSetInternalMethods resultSetInternalMethods;
        synchronized (checkClosed().getConnectionMutex()) {
            Field[] fieldArr = {new Field(null, DiskLruCache.VERSION_1, -5, 1)};
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ByteArrayRow(new byte[][]{new byte[]{49}}, getExceptionInterceptor()));
            resultSetInternalMethods = (ResultSetInternalMethods) DatabaseMetaData.buildResultSet(fieldArr, arrayList, this.connection);
        }
        return resultSetInternalMethods;
    }

    public List<Object> getBatchedArgs() {
        List<Object> list = this.batchedArgs;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public void getBatchedGeneratedKeys(java.sql.Statement statement) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.retrieveGeneratedKeys) {
                ResultSet generatedKeys = null;
                try {
                    generatedKeys = statement.getGeneratedKeys();
                    while (generatedKeys.next()) {
                        this.batchedGeneratedKeys.add(new ByteArrayRow(new byte[][]{generatedKeys.getBytes(1)}, getExceptionInterceptor()));
                    }
                    if (generatedKeys != null) {
                        generatedKeys.close();
                    }
                } catch (Throwable th) {
                    if (generatedKeys != null) {
                        generatedKeys.close();
                    }
                    throw th;
                }
            }
        }
    }

    public Calendar getCalendarInstanceForSessionOrNew() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.connection != null) {
                return this.connection.getCalendarInstanceForSessionOrNew();
            }
            return new GregorianCalendar();
        }
    }

    @Override // java.sql.Statement
    public java.sql.Connection getConnection() throws SQLException {
        MySQLConnection mySQLConnection;
        synchronized (checkClosed().getConnectionMutex()) {
            mySQLConnection = this.connection;
        }
        return mySQLConnection;
    }

    @Override // com.mysql.jdbc.Statement
    public ExceptionInterceptor getExceptionInterceptor() {
        return this.exceptionInterceptor;
    }

    @Override // java.sql.Statement
    public int getFetchDirection() throws SQLException {
        return 1000;
    }

    @Override // java.sql.Statement
    public int getFetchSize() throws SQLException {
        int i;
        synchronized (checkClosed().getConnectionMutex()) {
            i = this.fetchSize;
        }
        return i;
    }

    @Override // java.sql.Statement
    public ResultSet getGeneratedKeys() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (!this.retrieveGeneratedKeys) {
                throw SQLError.createSQLException(Messages.getString("Statement.GeneratedKeysNotRequested"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            if (this.batchedGeneratedKeys != null) {
                Field[] fieldArr = {new Field(BuildConfig.FLAVOR, "GENERATED_KEY", -5, 20)};
                fieldArr[0].setConnection(this.connection);
                ResultSetImpl resultSetImpl = ResultSetImpl.getInstance(this.currentCatalog, fieldArr, new RowDataStatic(this.batchedGeneratedKeys), this.connection, this, false);
                this.generatedKeysResults = resultSetImpl;
                return resultSetImpl;
            }
            if (this.lastQueryIsOnDupKeyUpdate) {
                ResultSetInternalMethods generatedKeysInternal = getGeneratedKeysInternal(1L);
                this.generatedKeysResults = generatedKeysInternal;
                return generatedKeysInternal;
            }
            ResultSetInternalMethods generatedKeysInternal2 = getGeneratedKeysInternal();
            this.generatedKeysResults = generatedKeysInternal2;
            return generatedKeysInternal2;
        }
    }

    public ResultSetInternalMethods getGeneratedKeysInternal() throws SQLException {
        return getGeneratedKeysInternal(getLargeUpdateCount());
    }

    public int getId() {
        return this.statementId;
    }

    public long getLargeMaxRows() throws SQLException {
        return getMaxRows();
    }

    public long getLargeUpdateCount() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods resultSetInternalMethods = this.results;
            if (resultSetInternalMethods == null) {
                return -1L;
            }
            if (resultSetInternalMethods.reallyResult()) {
                return -1L;
            }
            return this.results.getUpdateCount();
        }
    }

    public long getLastInsertID() {
        long j;
        try {
            synchronized (checkClosed().getConnectionMutex()) {
                j = this.lastInsertId;
            }
            return j;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.mysql.jdbc.Statement
    public InputStream getLocalInfileInputStream() {
        return this.localInfileInputStream;
    }

    public long getLongUpdateCount() {
        try {
            synchronized (checkClosed().getConnectionMutex()) {
                ResultSetInternalMethods resultSetInternalMethods = this.results;
                if (resultSetInternalMethods == null) {
                    return -1L;
                }
                if (resultSetInternalMethods.reallyResult()) {
                    return -1L;
                }
                return this.updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.sql.Statement
    public int getMaxFieldSize() throws SQLException {
        int i;
        synchronized (checkClosed().getConnectionMutex()) {
            i = this.maxFieldSize;
        }
        return i;
    }

    @Override // java.sql.Statement
    public int getMaxRows() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            int i = this.maxRows;
            if (i <= 0) {
                return 0;
            }
            return i;
        }
    }

    @Override // java.sql.Statement
    public boolean getMoreResults() throws SQLException {
        return getMoreResults(1);
    }

    @Override // com.mysql.jdbc.Statement
    public int getOpenResultSetCount() {
        try {
            synchronized (checkClosed().getConnectionMutex()) {
                Set<ResultSetInternalMethods> set = this.openResults;
                if (set == null) {
                    return 0;
                }
                return set.size();
            }
        } catch (SQLException unused) {
            return 0;
        }
    }

    @Override // java.sql.Statement
    public int getQueryTimeout() throws SQLException {
        int i;
        synchronized (checkClosed().getConnectionMutex()) {
            i = this.timeoutInMillis / 1000;
        }
        return i;
    }

    @Override // java.sql.Statement
    public ResultSet getResultSet() throws SQLException {
        ResultSetInternalMethods resultSetInternalMethods;
        synchronized (checkClosed().getConnectionMutex()) {
            ResultSetInternalMethods resultSetInternalMethods2 = this.results;
            resultSetInternalMethods = (resultSetInternalMethods2 == null || !resultSetInternalMethods2.reallyResult()) ? null : this.results;
        }
        return resultSetInternalMethods;
    }

    @Override // java.sql.Statement
    public int getResultSetConcurrency() throws SQLException {
        int i;
        synchronized (checkClosed().getConnectionMutex()) {
            i = this.resultSetConcurrency;
        }
        return i;
    }

    @Override // java.sql.Statement
    public int getResultSetHoldability() throws SQLException {
        return 1;
    }

    public ResultSetInternalMethods getResultSetInternal() {
        ResultSetInternalMethods resultSetInternalMethods;
        try {
            synchronized (checkClosed().getConnectionMutex()) {
                resultSetInternalMethods = this.results;
            }
            return resultSetInternalMethods;
        } catch (SQLException unused) {
            return this.results;
        }
    }

    @Override // java.sql.Statement
    public int getResultSetType() throws SQLException {
        int i;
        synchronized (checkClosed().getConnectionMutex()) {
            i = this.resultSetType;
        }
        return i;
    }

    @Override // java.sql.Statement
    public int getUpdateCount() throws SQLException {
        return Util.truncateAndConvertToInt(getLargeUpdateCount());
    }

    @Override // java.sql.Statement
    public SQLWarning getWarnings() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.clearWarningsCalled) {
                return null;
            }
            if (!this.connection.versionMeetsMinimum(4, 1, 0)) {
                return this.warningChain;
            }
            SQLWarning sQLWarningConvertShowWarningsToSQLWarnings = SQLError.convertShowWarningsToSQLWarnings(this.connection);
            SQLWarning sQLWarning = this.warningChain;
            if (sQLWarning != null) {
                sQLWarning.setNextWarning(sQLWarningConvertShowWarningsToSQLWarnings);
            } else {
                this.warningChain = sQLWarningConvertShowWarningsToSQLWarnings;
            }
            return this.warningChain;
        }
    }

    public SQLException handleExceptionForBatch(int i, int i2, long[] jArr, SQLException sQLException) throws SQLException {
        for (int i3 = i; i3 > i - i2; i3--) {
            jArr[i3] = -3;
        }
        if (this.continueBatchOnError && !(sQLException instanceof MySQLTimeoutException) && !(sQLException instanceof MySQLStatementCancelledException) && !hasDeadlockOrTimeoutRolledBackTx(sQLException)) {
            return sQLException;
        }
        long[] jArr2 = new long[i];
        System.arraycopy(jArr, 0, jArr2, 0, i);
        throw SQLError.createBatchUpdateException(sQLException, jArr2, getExceptionInterceptor());
    }

    public final boolean hasDeadlockOrTimeoutRolledBackTx(SQLException sQLException) {
        int errorCode = sQLException.getErrorCode();
        if (errorCode != 1205) {
            return errorCode == 1206 || errorCode == 1213;
        }
        return !this.version5013OrNewer;
    }

    public void implicitlyCloseAllOpenResults() throws SQLException {
        this.isImplicitlyClosingResults = true;
        try {
            if (!this.connection.getHoldResultsOpenOverStatementClose() && !this.connection.getDontTrackOpenResources() && !this.holdResultsOpenOverClose) {
                ResultSetInternalMethods resultSetInternalMethods = this.results;
                if (resultSetInternalMethods != null) {
                    resultSetInternalMethods.realClose(false);
                }
                ResultSetInternalMethods resultSetInternalMethods2 = this.generatedKeysResults;
                if (resultSetInternalMethods2 != null) {
                    resultSetInternalMethods2.realClose(false);
                }
                closeAllOpenResults();
            }
        } finally {
            this.isImplicitlyClosingResults = false;
        }
    }

    public boolean isCloseOnCompletion() throws SQLException {
        boolean z;
        synchronized (checkClosed().getConnectionMutex()) {
            z = this.closeOnCompletion;
        }
        return z;
    }

    @Override // java.sql.Statement
    public boolean isClosed() throws SQLException {
        boolean z;
        MySQLConnection mySQLConnection = this.connection;
        if (mySQLConnection == null) {
            return true;
        }
        synchronized (mySQLConnection.getConnectionMutex()) {
            z = this.isClosed;
        }
        return z;
    }

    public boolean isCursorRequired() throws SQLException {
        return false;
    }

    @Override // java.sql.Statement
    public boolean isPoolable() throws SQLException {
        return this.isPoolable;
    }

    @Override // java.sql.Wrapper, com.mysql.jdbc.Wrapper
    public boolean isWrapperFor(Class<?> cls) throws SQLException {
        checkClosed();
        return cls.isInstance(this);
    }

    public int processMultiCountsAndKeys(StatementImpl statementImpl, int i, long[] jArr) throws SQLException {
        int i2;
        synchronized (checkClosed().getConnectionMutex()) {
            i2 = i + 1;
            jArr[i] = statementImpl.getLargeUpdateCount();
            boolean z = this.batchedGeneratedKeys != null;
            if (z) {
                this.batchedGeneratedKeys.add(new ByteArrayRow(new byte[][]{StringUtils.getBytes(Long.toString(statementImpl.getLastInsertID()))}, getExceptionInterceptor()));
            }
            while (true) {
                if (!statementImpl.getMoreResults() && statementImpl.getLargeUpdateCount() == -1) {
                }
                int i3 = i2 + 1;
                jArr[i2] = statementImpl.getLargeUpdateCount();
                if (z) {
                    this.batchedGeneratedKeys.add(new ByteArrayRow(new byte[][]{StringUtils.getBytes(Long.toString(statementImpl.getLastInsertID()))}, getExceptionInterceptor()));
                }
                i2 = i3;
            }
        }
        return i2;
    }

    public void realClose(boolean z, boolean z2) throws SQLException {
        boolean z3;
        MySQLConnection mySQLConnection = this.connection;
        if (mySQLConnection == null || this.isClosed) {
            return;
        }
        if (!mySQLConnection.getDontTrackOpenResources()) {
            mySQLConnection.unregisterStatement(this);
        }
        if (this.useUsageAdvisor && !z) {
            this.eventSink.consumeEvent(new ProfilerEvent((byte) 0, BuildConfig.FLAVOR, this.currentCatalog, this.connectionId, getId(), -1, System.currentTimeMillis(), 0L, Constants.MILLIS_I18N, null, this.pointOfOrigin, Messages.getString("Statement.63") + Messages.getString("Statement.64")));
        }
        if (z2) {
            z3 = (this.holdResultsOpenOverClose || this.connection.getDontTrackOpenResources()) ? false : true;
        } else {
            z3 = z2;
        }
        if (z3) {
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
            closeAllOpenResults();
        }
        this.isClosed = true;
        this.results = null;
        this.generatedKeysResults = null;
        this.connection = null;
        this.warningChain = null;
        this.openResults = null;
        this.batchedGeneratedKeys = null;
        this.localInfileInputStream = null;
        this.pingTarget = null;
    }

    @Override // com.mysql.jdbc.Statement
    public void removeOpenResultSet(ResultSetInternalMethods resultSetInternalMethods) {
        try {
            synchronized (checkClosed().getConnectionMutex()) {
                try {
                    Set<ResultSetInternalMethods> set = this.openResults;
                    if (set != null) {
                        set.remove(resultSetInternalMethods);
                    }
                    boolean z = resultSetInternalMethods.getNextResultSet() != null;
                    if (this.results == resultSetInternalMethods && !z) {
                        this.results = null;
                    }
                    if (this.generatedKeysResults == resultSetInternalMethods) {
                        this.generatedKeysResults = null;
                    }
                    if (!this.isImplicitlyClosingResults && !z) {
                        checkAndPerformCloseOnCompletionAction();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (SQLException unused) {
        }
    }

    public void resetCancelledState() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            Object obj = this.cancelTimeoutMutex;
            if (obj == null) {
                return;
            }
            synchronized (obj) {
                this.wasCancelled = false;
                this.wasCancelledByTimeout = false;
            }
        }
    }

    @Override // java.sql.Statement
    public void setCursorName(String str) throws SQLException {
    }

    @Override // java.sql.Statement
    public void setEscapeProcessing(boolean z) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            this.doEscapeProcessing = z;
        }
    }

    @Override // java.sql.Statement
    public void setFetchDirection(int i) throws SQLException {
        switch (i) {
            case 1000:
            case 1001:
            case MysqlErrorNumbers.ER_NO /* 1002 */:
                return;
            default:
                throw SQLError.createSQLException(Messages.getString("Statement.5"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
    }

    @Override // java.sql.Statement
    public void setFetchSize(int i) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (i >= 0 || i == Integer.MIN_VALUE) {
                if (this.maxRows > 0) {
                    if (i <= getMaxRows()) {
                    }
                }
                this.fetchSize = i;
            }
            throw SQLError.createSQLException(Messages.getString("Statement.7"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
    }

    @Override // com.mysql.jdbc.Statement
    public void setHoldResultsOpenOverClose(boolean z) {
        try {
            synchronized (checkClosed().getConnectionMutex()) {
                this.holdResultsOpenOverClose = z;
            }
        } catch (SQLException unused) {
        }
    }

    public void setLargeMaxRows(long j) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            try {
                if (j > 50000000 || j < 0) {
                    throw SQLError.createSQLException(Messages.getString("Statement.15") + j + " > " + MysqlDefs.MAX_ROWS + ".", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                }
                if (j == 0) {
                    j = -1;
                }
                this.maxRows = (int) j;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.mysql.jdbc.Statement
    public void setLocalInfileInputStream(InputStream inputStream) {
        this.localInfileInputStream = inputStream;
    }

    @Override // java.sql.Statement
    public void setMaxFieldSize(int i) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            try {
                if (i < 0) {
                    throw SQLError.createSQLException(Messages.getString("Statement.11"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                }
                int maxAllowedPacket = this.connection != null ? this.connection.getMaxAllowedPacket() : MysqlIO.getMaxBuf();
                if (i > maxAllowedPacket) {
                    throw SQLError.createSQLException(Messages.getString("Statement.13", new Object[]{Long.valueOf(maxAllowedPacket)}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                }
                this.maxFieldSize = i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.sql.Statement
    public void setMaxRows(int i) throws SQLException {
        setLargeMaxRows(i);
    }

    @Override // com.mysql.jdbc.Statement
    public void setPingTarget(PingTarget pingTarget) {
        this.pingTarget = pingTarget;
    }

    @Override // java.sql.Statement
    public void setPoolable(boolean z) throws SQLException {
        this.isPoolable = z;
    }

    @Override // java.sql.Statement
    public void setQueryTimeout(int i) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            try {
                if (i < 0) {
                    throw SQLError.createSQLException(Messages.getString("Statement.21"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                }
                this.timeoutInMillis = i * 1000;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setResultSetConcurrency(int i) {
        try {
            synchronized (checkClosed().getConnectionMutex()) {
                this.resultSetConcurrency = i;
            }
        } catch (SQLException unused) {
        }
    }

    public void setResultSetType(int i) {
        try {
            synchronized (checkClosed().getConnectionMutex()) {
                this.resultSetType = i;
            }
        } catch (SQLException unused) {
        }
    }

    public void setupStreamingTimeout(MySQLConnection mySQLConnection) throws SQLException {
        if (!createStreamingResultSet() || mySQLConnection.getNetTimeoutForStreamingResults() <= 0) {
            return;
        }
        executeSimpleNonQuery(mySQLConnection, "SET net_write_timeout=" + mySQLConnection.getNetTimeoutForStreamingResults());
    }

    public void statementBegins() {
        this.clearWarningsCalled = false;
        this.statementExecuting.set(true);
        MySQLConnection activeMySQLConnection = this.connection.getMultiHostSafeProxy().getActiveMySQLConnection();
        while (!(activeMySQLConnection instanceof ConnectionImpl)) {
            activeMySQLConnection = activeMySQLConnection.getMultiHostSafeProxy().getActiveMySQLConnection();
        }
        this.physicalConnection = new WeakReference(activeMySQLConnection);
    }

    @Override // java.sql.Wrapper, com.mysql.jdbc.Wrapper
    public <T> T unwrap(Class<T> cls) throws SQLException {
        try {
            return cls.cast(this);
        } catch (ClassCastException unused) {
            throw SQLError.createSQLException("Unable to unwrap to " + cls.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
    }

    @Override // java.sql.Statement
    public boolean execute(String str, int i) throws SQLException {
        return executeInternal(str, i == 1);
    }

    public long executeLargeUpdate(String str, int i) throws SQLException {
        return executeUpdateInternal(str, false, i == 1);
    }

    @Override // java.sql.Statement
    public int executeUpdate(String str, int i) throws SQLException {
        return Util.truncateAndConvertToInt(executeLargeUpdate(str, i));
    }

    @Override // java.sql.Statement
    public boolean getMoreResults(int i) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            boolean z = false;
            if (this.results == null) {
                return false;
            }
            boolean zCreateStreamingResultSet = createStreamingResultSet();
            if (zCreateStreamingResultSet && this.results.reallyResult()) {
                while (this.results.next()) {
                }
            }
            ResultSetInternalMethods nextResultSet = this.results.getNextResultSet();
            if (i != 1) {
                if (i == 2) {
                    if (!this.connection.getDontTrackOpenResources()) {
                        this.openResults.add(this.results);
                    }
                    this.results.clearNextResult();
                } else {
                    if (i != 3) {
                        throw SQLError.createSQLException(Messages.getString("Statement.19"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                    }
                    if (this.results != null) {
                        if (!zCreateStreamingResultSet && !this.connection.getDontTrackOpenResources()) {
                            this.results.realClose(false);
                        }
                        this.results.clearNextResult();
                    }
                    closeAllOpenResults();
                }
            } else if (this.results != null) {
                if (!zCreateStreamingResultSet && !this.connection.getDontTrackOpenResources()) {
                    this.results.realClose(false);
                }
                this.results.clearNextResult();
            }
            this.results = nextResultSet;
            if (nextResultSet == null || nextResultSet.reallyResult()) {
                this.updateCount = -1L;
                this.lastInsertId = -1L;
            } else {
                this.updateCount = this.results.getUpdateCount();
                this.lastInsertId = this.results.getUpdateID();
            }
            ResultSetInternalMethods resultSetInternalMethods = this.results;
            if (resultSetInternalMethods != null && resultSetInternalMethods.reallyResult()) {
                z = true;
            }
            if (!z) {
                checkAndPerformCloseOnCompletionAction();
            }
            return z;
        }
    }

    @Override // java.sql.Statement
    public boolean execute(String str, int[] iArr) throws SQLException {
        return executeInternal(str, iArr != null && iArr.length > 0);
    }

    public long executeLargeUpdate(String str, int[] iArr) throws SQLException {
        return executeUpdateInternal(str, false, iArr != null && iArr.length > 0);
    }

    @Override // java.sql.Statement
    public int executeUpdate(String str, int[] iArr) throws SQLException {
        return Util.truncateAndConvertToInt(executeLargeUpdate(str, iArr));
    }

    public ResultSetInternalMethods getGeneratedKeysInternal(long j) throws SQLException {
        ResultSetImpl resultSetImpl;
        synchronized (checkClosed().getConnectionMutex()) {
            int i = 1;
            Field[] fieldArr = {new Field(BuildConfig.FLAVOR, "GENERATED_KEY", -5, 20)};
            fieldArr[0].setConnection(this.connection);
            fieldArr[0].setUseOldNameMetadata(true);
            ArrayList arrayList = new ArrayList();
            long lastInsertID = getLastInsertID();
            long j2 = 0;
            if (lastInsertID < 0) {
                fieldArr[0].setUnsigned();
            }
            ResultSetInternalMethods resultSetInternalMethods = this.results;
            if (resultSetInternalMethods != null) {
                String serverInfo = resultSetInternalMethods.getServerInfo();
                long recordCountFromInfo = (j <= 0 || this.results.getFirstCharOfQuery() != 'R' || serverInfo == null || serverInfo.length() <= 0) ? j : getRecordCountFromInfo(serverInfo);
                if (lastInsertID != 0 && recordCountFromInfo > 0) {
                    int i2 = 0;
                    while (i2 < recordCountFromInfo) {
                        byte[][] bArr = new byte[i][];
                        if (lastInsertID > j2) {
                            bArr[0] = StringUtils.getBytes(Long.toString(lastInsertID));
                        } else {
                            bArr[0] = new BigInteger(1, new byte[]{(byte) (lastInsertID >>> 56), (byte) (lastInsertID >>> 48), (byte) (lastInsertID >>> 40), (byte) (lastInsertID >>> 32), (byte) (lastInsertID >>> 24), (byte) (lastInsertID >>> 16), (byte) (lastInsertID >>> 8), (byte) (lastInsertID & 255)}).toString().getBytes();
                        }
                        ArrayList arrayList2 = arrayList;
                        arrayList2.add(new ByteArrayRow(bArr, getExceptionInterceptor()));
                        lastInsertID += (long) this.connection.getAutoIncrementIncrement();
                        i2++;
                        recordCountFromInfo = recordCountFromInfo;
                        arrayList = arrayList2;
                        i = 1;
                        j2 = 0;
                    }
                }
            }
            resultSetImpl = ResultSetImpl.getInstance(this.currentCatalog, fieldArr, new RowDataStatic(arrayList), this.connection, this, false);
        }
        return resultSetImpl;
    }

    @Override // java.sql.Statement
    public boolean execute(String str, String[] strArr) throws SQLException {
        return executeInternal(str, strArr != null && strArr.length > 0);
    }

    public long executeLargeUpdate(String str, String[] strArr) throws SQLException {
        return executeUpdateInternal(str, false, strArr != null && strArr.length > 0);
    }

    @Override // java.sql.Statement
    public int executeUpdate(String str, String[] strArr) throws SQLException {
        return Util.truncateAndConvertToInt(executeLargeUpdate(str, strArr));
    }

    public void getBatchedGeneratedKeys(int i) throws SQLException {
        ResultSetInternalMethods generatedKeysInternal;
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.retrieveGeneratedKeys) {
                ResultSetInternalMethods resultSetInternalMethods = null;
                try {
                    if (i == 0) {
                        generatedKeysInternal = getGeneratedKeysInternal();
                    } else {
                        generatedKeysInternal = getGeneratedKeysInternal(i);
                    }
                    resultSetInternalMethods = generatedKeysInternal;
                    while (resultSetInternalMethods.next()) {
                        this.batchedGeneratedKeys.add(new ByteArrayRow(new byte[][]{resultSetInternalMethods.getBytes(1)}, getExceptionInterceptor()));
                    }
                    this.isImplicitlyClosingResults = true;
                    if (resultSetInternalMethods != null) {
                        try {
                            resultSetInternalMethods.close();
                        } catch (Throwable th) {
                            this.isImplicitlyClosingResults = false;
                            throw th;
                        }
                    }
                    this.isImplicitlyClosingResults = false;
                } catch (Throwable th2) {
                    this.isImplicitlyClosingResults = true;
                    if (resultSetInternalMethods != null) {
                        try {
                            resultSetInternalMethods.close();
                        } finally {
                            this.isImplicitlyClosingResults = false;
                        }
                    }
                    throw th2;
                }
            }
        }
    }
}
