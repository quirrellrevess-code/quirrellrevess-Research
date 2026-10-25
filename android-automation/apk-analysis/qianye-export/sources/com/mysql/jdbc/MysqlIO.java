package com.mysql.jdbc;

import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.authentication.CachingSha2PasswordPlugin;
import com.mysql.jdbc.authentication.MysqlClearPasswordPlugin;
import com.mysql.jdbc.authentication.MysqlNativePasswordPlugin;
import com.mysql.jdbc.authentication.MysqlOldPasswordPlugin;
import com.mysql.jdbc.authentication.Sha256PasswordPlugin;
import com.mysql.jdbc.exceptions.MySQLStatementCancelledException;
import com.mysql.jdbc.exceptions.MySQLTimeoutException;
import com.mysql.jdbc.log.LogUtils;
import com.mysql.jdbc.profiler.ProfilerEvent;
import com.mysql.jdbc.profiler.ProfilerEventHandler;
import com.mysql.jdbc.util.ReadAheadInputStream;
import com.mysql.jdbc.util.ResultSetUtil;
import com.tencent.smtt.export.external.interfaces.ISelectionInterface;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.lang.ref.SoftReference;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.zip.Deflater;

/* JADX INFO: loaded from: classes.dex */
public class MysqlIO {
    public static final int AUTH_411_OVERHEAD = 33;
    private static final int CLIENT_CAN_HANDLE_EXPIRED_PASSWORD = 4194304;
    private static final int CLIENT_COMPRESS = 32;
    private static final int CLIENT_CONNECT_ATTRS = 1048576;
    public static final int CLIENT_CONNECT_WITH_DB = 8;
    private static final int CLIENT_DEPRECATE_EOF = 16777216;
    private static final int CLIENT_FOUND_ROWS = 2;
    private static final int CLIENT_INTERACTIVE = 1024;
    private static final int CLIENT_LOCAL_FILES = 128;
    private static final int CLIENT_LONG_FLAG = 4;
    private static final int CLIENT_LONG_PASSWORD = 1;
    private static final int CLIENT_MULTI_RESULTS = 131072;
    private static final int CLIENT_MULTI_STATEMENTS = 65536;
    private static final int CLIENT_PLUGIN_AUTH = 524288;
    private static final int CLIENT_PLUGIN_AUTH_LENENC_CLIENT_DATA = 2097152;
    private static final int CLIENT_PROTOCOL_41 = 512;
    public static final int CLIENT_RESERVED = 16384;
    public static final int CLIENT_SECURE_CONNECTION = 32768;
    private static final int CLIENT_SESSION_TRACK = 8388608;
    public static final int CLIENT_SSL = 2048;
    private static final int CLIENT_TRANSACTIONS = 8192;
    private static final String CODE_PAGE_1252 = "Cp1252";
    public static final int COMP_HEADER_LENGTH = 3;
    private static final String EXPLAINABLE_STATEMENT = "SELECT";
    private static final String[] EXPLAINABLE_STATEMENT_EXTENSION = {"INSERT", "UPDATE", "REPLACE", "DELETE"};
    private static final String FALSE_SCRAMBLE = "xxxxxxxx";
    public static final int HEADER_LENGTH = 4;
    public static final int INITIAL_PACKET_SIZE = 1024;
    private static final int MAX_PACKET_DUMP_LENGTH = 1024;
    public static final int MAX_QUERY_SIZE_TO_EXPLAIN = 1048576;
    public static final int MAX_QUERY_SIZE_TO_LOG = 1024;
    public static final int MIN_COMPRESS_LEN = 50;
    private static final String NONE = "none";
    public static final int NULL_LENGTH = -1;
    public static final int SEED_LENGTH = 20;
    public static final int SERVER_MORE_RESULTS_EXISTS = 8;
    private static final int SERVER_QUERY_NO_GOOD_INDEX_USED = 16;
    private static final int SERVER_QUERY_NO_INDEX_USED = 32;
    private static final int SERVER_QUERY_WAS_SLOW = 2048;
    private static final int SERVER_STATUS_AUTOCOMMIT = 2;
    private static final int SERVER_STATUS_CURSOR_EXISTS = 64;
    private static final int SERVER_STATUS_IN_TRANS = 1;
    public static final String ZERO_DATETIME_VALUE_MARKER = "0000-00-00 00:00:00";
    public static final String ZERO_DATE_VALUE_MARKER = "0000-00-00";
    private static String jvmPlatformCharset = null;
    private static int maxBufferSize = 65535;
    private boolean autoGenerateTestcaseScript;
    private SoftReference<Buffer> compressBufRef;
    public MySQLConnection connection;
    private ExceptionInterceptor exceptionInterceptor;
    public String host;
    private boolean isInteractiveClient;
    private SoftReference<Buffer> loadFileBufRef;
    private boolean logSlowQueries;
    public Socket mysqlConnection;
    public InputStream mysqlInput;
    public BufferedOutputStream mysqlOutput;
    private boolean needToGrabQueryFromPacket;
    private LinkedList<StringBuilder> packetDebugRingBuffer;
    public int port;
    private boolean profileSql;
    private String queryTimingUnits;
    private Buffer reusablePacket;
    public String seed;
    private Buffer sendPacket;
    public int serverCapabilities;
    public int serverCharsetIndex;
    private long slowQueryThreshold;
    public SocketFactory socketFactory;
    private String socketFactoryClassName;
    private SoftReference<Buffer> splitBufRef;
    private List<StatementInterceptorV2> statementInterceptors;
    private long threadId;
    private boolean traceProtocol;
    private boolean useAutoSlowLog;
    private int useBufferRowSizeThreshold;
    private boolean useConnectWithDb;
    private boolean useDirectRowUnpack;
    private boolean useNanosForElapsedTime;
    private boolean packetSequenceReset = false;
    private Buffer sharedSendPacket = null;
    private Deflater deflater = null;
    private RowData streamingData = null;
    private String serverVersion = null;
    private byte[] packetHeaderBuf = new byte[4];
    private boolean colDecimalNeedsBump = false;
    private boolean hadWarnings = false;
    private boolean has41NewNewProt = false;
    private boolean hasLongColumnInfo = false;
    private boolean platformDbCharsetMatches = true;
    private boolean queryBadIndexUsed = false;
    private boolean queryNoIndexUsed = false;
    private boolean serverQueryWasSlow = false;
    private boolean use41Extensions = false;
    private boolean useCompression = false;
    private boolean useNewLargePackets = false;
    private boolean useNewUpdateCounts = false;
    private byte packetSequence = 0;
    private byte compressedPacketSequence = 0;
    private byte readPacketSequence = -1;
    private boolean checkPacketSequence = false;
    private byte protocolVersion = 0;
    private int maxAllowedPacket = 1048576;
    public int maxThreeBytes = 16581375;
    private int serverMajorVersion = 0;
    private int serverMinorVersion = 0;
    private int oldServerStatus = 0;
    private int serverStatus = 0;
    private int serverSubMinorVersion = 0;
    private int warningCount = 0;
    public long clientParam = 0;
    public long lastPacketSentTimeMs = 0;
    public long lastPacketReceivedTimeMs = 0;
    private boolean enablePacketDebug = false;
    private int commandCount = 0;
    private int authPluginDataLength = 0;
    private Map<String, AuthenticationPlugin> authenticationPlugins = null;
    private List<String> disabledAuthenticationPlugins = null;
    private String clientDefaultAuthenticationPlugin = null;
    private String clientDefaultAuthenticationPluginName = null;
    private String serverDefaultAuthenticationPluginName = null;
    private int statementExecutionDepth = 0;

    static {
        OutputStreamWriter outputStreamWriter;
        Throwable th;
        try {
            outputStreamWriter = new OutputStreamWriter(new ByteArrayOutputStream());
            try {
                jvmPlatformCharset = outputStreamWriter.getEncoding();
                try {
                    outputStreamWriter.close();
                } catch (IOException unused) {
                }
            } catch (Throwable th2) {
                th = th2;
                if (outputStreamWriter != null) {
                    try {
                        outputStreamWriter.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            outputStreamWriter = null;
            th = th3;
        }
    }

    public MysqlIO(String str, int i, Properties properties, String str2, MySQLConnection mySQLConnection, int i2, int i3) throws SQLException, IOException {
        this.reusablePacket = null;
        this.sendPacket = null;
        this.mysqlOutput = null;
        this.mysqlInput = null;
        this.packetDebugRingBuffer = null;
        this.mysqlConnection = null;
        this.socketFactory = null;
        this.host = null;
        this.socketFactoryClassName = null;
        this.isInteractiveClient = false;
        this.logSlowQueries = false;
        this.profileSql = false;
        this.port = 3306;
        this.traceProtocol = false;
        this.useDirectRowUnpack = true;
        this.connection = mySQLConnection;
        if (mySQLConnection.getEnablePacketDebug()) {
            this.packetDebugRingBuffer = new LinkedList<>();
        }
        this.traceProtocol = this.connection.getTraceProtocol();
        this.useAutoSlowLog = this.connection.getAutoSlowLog();
        this.useBufferRowSizeThreshold = i3;
        this.useDirectRowUnpack = this.connection.getUseDirectRowUnpack();
        this.logSlowQueries = this.connection.getLogSlowQueries();
        this.reusablePacket = new Buffer(1024);
        this.sendPacket = new Buffer(1024);
        this.port = i;
        this.host = str;
        this.socketFactoryClassName = str2;
        this.socketFactory = createSocketFactory();
        this.exceptionInterceptor = this.connection.getExceptionInterceptor();
        try {
            Socket socketConnect = this.socketFactory.connect(this.host, this.port, properties);
            this.mysqlConnection = socketConnect;
            if (i2 != 0) {
                try {
                    socketConnect.setSoTimeout(i2);
                } catch (Exception unused) {
                }
            }
            this.mysqlConnection = this.socketFactory.beforeHandshake();
            if (this.connection.getUseReadAheadInput()) {
                this.mysqlInput = new ReadAheadInputStream(this.mysqlConnection.getInputStream(), 16384, this.connection.getTraceProtocol(), this.connection.getLog());
            } else if (this.connection.useUnbufferedInput()) {
                this.mysqlInput = this.mysqlConnection.getInputStream();
            } else {
                this.mysqlInput = new BufferedInputStream(this.mysqlConnection.getInputStream(), 16384);
            }
            this.mysqlOutput = new BufferedOutputStream(this.mysqlConnection.getOutputStream(), 16384);
            this.isInteractiveClient = this.connection.getInteractiveClient();
            this.profileSql = this.connection.getProfileSql();
            boolean autoGenerateTestcaseScript = this.connection.getAutoGenerateTestcaseScript();
            this.autoGenerateTestcaseScript = autoGenerateTestcaseScript;
            this.needToGrabQueryFromPacket = this.profileSql || this.logSlowQueries || autoGenerateTestcaseScript;
            if (this.connection.getUseNanosForElapsedTime() && TimeUtil.nanoTimeAvailable()) {
                this.useNanosForElapsedTime = true;
                this.queryTimingUnits = Messages.getString("Nanoseconds");
            } else {
                this.queryTimingUnits = Messages.getString("Milliseconds");
            }
            if (this.connection.getLogSlowQueries()) {
                calculateSlowQueryThreshold();
            }
        } catch (IOException e) {
            throw SQLError.createCommunicationsException(this.connection, 0L, 0L, e, getExceptionInterceptor());
        }
    }

    private boolean addAuthenticationPlugin(AuthenticationPlugin authenticationPlugin) throws SQLException {
        String name = authenticationPlugin.getClass().getName();
        String protocolPluginName = authenticationPlugin.getProtocolPluginName();
        List<String> list = this.disabledAuthenticationPlugins;
        boolean z = list != null && list.contains(name);
        List<String> list2 = this.disabledAuthenticationPlugins;
        boolean z2 = list2 != null && list2.contains(protocolPluginName);
        if (!z && !z2) {
            this.authenticationPlugins.put(protocolPluginName, authenticationPlugin);
            if (this.clientDefaultAuthenticationPlugin.equals(name)) {
                this.clientDefaultAuthenticationPluginName = protocolPluginName;
                return true;
            }
        } else if (this.clientDefaultAuthenticationPlugin.equals(name)) {
            Object[] objArr = new Object[1];
            if (!z) {
                name = protocolPluginName;
            }
            objArr[0] = name;
            throw SQLError.createSQLException(Messages.getString("Connection.BadDisabledAuthenticationPlugin", objArr), getExceptionInterceptor());
        }
        return false;
    }

    private int adjustStartForFieldLength(int i, int i2) {
        if (i2 < 251) {
            return i;
        }
        if (i2 < 251 || i2 >= 65536) {
            return (i2 < 65536 || i2 >= 16777216) ? i + 8 : i + 3;
        }
        return i + 2;
    }

    private int alignPacketSize(int i, int i2) {
        return ((i + i2) - 1) & (~(i2 - 1));
    }

    private void appendCharsetByteForHandshake(Buffer buffer, String str) throws SQLException {
        int collationIndexForJavaEncoding = str != null ? CharsetMapping.getCollationIndexForJavaEncoding(str, this.connection) : 0;
        if (collationIndexForJavaEncoding == 0) {
            collationIndexForJavaEncoding = 33;
        }
        if (collationIndexForJavaEncoding <= 255) {
            buffer.writeByte((byte) collationIndexForJavaEncoding);
            return;
        }
        throw SQLError.createSQLException("Invalid character set index for encoding: " + str, SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
    }

    private void appendDeadlockStatusInformation(String str, StringBuilder sb) throws SQLException {
        if (this.connection.getIncludeInnodbStatusInDeadlockExceptions() && str != null && ((str.startsWith("40") || str.startsWith("41")) && this.streamingData == null)) {
            ResultSetInternalMethods resultSetInternalMethodsSqlQueryDirect = null;
            try {
                try {
                    resultSetInternalMethodsSqlQueryDirect = sqlQueryDirect(null, "SHOW ENGINE INNODB STATUS", this.connection.getEncoding(), null, -1, MysqlErrorNumbers.ER_YES, MysqlErrorNumbers.ER_DB_CREATE_EXISTS, false, this.connection.getCatalog(), null);
                    if (resultSetInternalMethodsSqlQueryDirect.next()) {
                        sb.append("\n\n");
                        sb.append(resultSetInternalMethodsSqlQueryDirect.getString("Status"));
                    } else {
                        sb.append("\n\n");
                        sb.append(Messages.getString("MysqlIO.NoInnoDBStatusFound"));
                    }
                    if (resultSetInternalMethodsSqlQueryDirect != null) {
                        resultSetInternalMethodsSqlQueryDirect.close();
                    }
                } catch (Exception e) {
                    sb.append("\n\n");
                    sb.append(Messages.getString("MysqlIO.InnoDBStatusFailed"));
                    sb.append("\n\n");
                    sb.append(Util.stackTraceToString(e));
                    if (0 != 0) {
                    }
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    resultSetInternalMethodsSqlQueryDirect.close();
                }
                throw th;
            }
        }
        if (this.connection.getIncludeThreadDumpInDeadlockExceptions()) {
            sb.append("\n\n*** Java threads running at time of deadlock ***\n\n");
            ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
            ThreadInfo[] threadInfo = threadMXBean.getThreadInfo(threadMXBean.getAllThreadIds(), Integer.MAX_VALUE);
            ArrayList<ThreadInfo> arrayList = new ArrayList();
            for (ThreadInfo threadInfo2 : threadInfo) {
                if (threadInfo2 != null) {
                    arrayList.add(threadInfo2);
                }
            }
            for (ThreadInfo threadInfo3 : arrayList) {
                sb.append('\"');
                sb.append(threadInfo3.getThreadName());
                sb.append("\" tid=");
                sb.append(threadInfo3.getThreadId());
                sb.append(" ");
                sb.append(threadInfo3.getThreadState());
                if (threadInfo3.getLockName() != null) {
                    sb.append(" on lock=" + threadInfo3.getLockName());
                }
                if (threadInfo3.isSuspended()) {
                    sb.append(" (suspended)");
                }
                if (threadInfo3.isInNative()) {
                    sb.append(" (running in native)");
                }
                StackTraceElement[] stackTrace = threadInfo3.getStackTrace();
                if (stackTrace.length > 0) {
                    sb.append(" in ");
                    sb.append(stackTrace[0].getClassName());
                    sb.append(".");
                    sb.append(stackTrace[0].getMethodName());
                    sb.append("()");
                }
                sb.append("\n");
                if (threadInfo3.getLockOwnerName() != null) {
                    sb.append("\t owned by " + threadInfo3.getLockOwnerName() + " Id=" + threadInfo3.getLockOwnerId());
                    sb.append("\n");
                }
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb.append("\tat " + stackTraceElement.toString());
                    sb.append("\n");
                }
            }
        }
    }

    private ResultSetImpl buildResultSetWithRows(StatementImpl statementImpl, String str, Field[] fieldArr, RowData rowData, int i, int i2, boolean z) throws SQLException {
        ResultSetImpl resultSetImpl;
        if (i2 == 1007) {
            resultSetImpl = ResultSetImpl.getInstance(str, fieldArr, rowData, this.connection, statementImpl, false);
            if (z) {
                resultSetImpl.setBinaryEncoded();
            }
        } else {
            if (i2 != 1008) {
                return ResultSetImpl.getInstance(str, fieldArr, rowData, this.connection, statementImpl, false);
            }
            resultSetImpl = ResultSetImpl.getInstance(str, fieldArr, rowData, this.connection, statementImpl, true);
        }
        resultSetImpl.setResultSetType(i);
        resultSetImpl.setResultSetConcurrency(i2);
        return resultSetImpl;
    }

    private ResultSetImpl buildResultSetWithUpdates(StatementImpl statementImpl, Buffer buffer) throws SQLException {
        long length;
        long length2;
        try {
            if (this.useNewUpdateCounts) {
                length = buffer.newReadLength();
                length2 = buffer.newReadLength();
            } else {
                length = buffer.readLength();
                length2 = buffer.readLength();
            }
            long j = length;
            long j2 = length2;
            if (this.use41Extensions) {
                this.serverStatus = buffer.readInt();
                checkTransactionState(this.oldServerStatus);
                int i = buffer.readInt();
                this.warningCount = i;
                if (i > 0) {
                    this.hadWarnings = true;
                }
                buffer.readByte();
                setServerSlowQueryFlags();
            }
            String string = this.connection.isReadInfoMsgEnabled() ? buffer.readString(this.connection.getErrorMessageEncoding(), getExceptionInterceptor()) : null;
            ResultSetImpl resultSetImpl = ResultSetImpl.getInstance(j, j2, this.connection, statementImpl);
            if (string != null) {
                resultSetImpl.setServerInfo(string);
            }
            return resultSetImpl;
        } catch (Exception e) {
            SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(SQLError.get(SQLError.SQL_STATE_GENERAL_ERROR), SQLError.SQL_STATE_GENERAL_ERROR, -1, getExceptionInterceptor());
            sQLExceptionCreateSQLException.initCause(e);
            throw sQLExceptionCreateSQLException;
        }
    }

    private void calculateSlowQueryThreshold() {
        this.slowQueryThreshold = this.connection.getSlowQueryThresholdMillis();
        if (this.connection.getUseNanosForElapsedTime()) {
            long slowQueryThresholdNanos = this.connection.getSlowQueryThresholdNanos();
            if (slowQueryThresholdNanos != 0) {
                this.slowQueryThreshold = slowQueryThresholdNanos;
            } else {
                this.slowQueryThreshold *= 1000000;
            }
        }
    }

    private void changeDatabaseTo(String str) throws SQLException {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            sendCommand(2, str, null, false, null, 0);
        } catch (Exception e) {
            if (!this.connection.getCreateDatabaseIfNotExist()) {
                throw SQLError.createCommunicationsException(this.connection, this.lastPacketSentTimeMs, this.lastPacketReceivedTimeMs, e, getExceptionInterceptor());
            }
            sendCommand(3, "CREATE DATABASE IF NOT EXISTS " + str, null, false, null, 0);
            sendCommand(2, str, null, false, null, 0);
        }
    }

    private void checkConfidentiality(AuthenticationPlugin authenticationPlugin) throws SQLException {
        if (authenticationPlugin.requiresConfidentiality() && !isSSLEstablished()) {
            throw SQLError.createSQLException(Messages.getString("Connection.AuthenticationPluginRequiresSSL", new Object[]{authenticationPlugin.getProtocolPluginName()}), getExceptionInterceptor());
        }
    }

    private void checkForOutstandingStreamingData() throws SQLException {
        if (this.streamingData != null) {
            if (this.connection.getClobberStreamingResults()) {
                this.streamingData.getOwner().realClose(false);
                clearInputStream();
                return;
            }
            throw SQLError.createSQLException(Messages.getString("MysqlIO.39") + this.streamingData + Messages.getString("MysqlIO.40") + Messages.getString("MysqlIO.41") + Messages.getString("MysqlIO.42"), getExceptionInterceptor());
        }
    }

    private void checkPacketSequencing(byte b) throws SQLException {
        if (b == -128 && this.readPacketSequence != 127) {
            throw SQLError.createCommunicationsException(this.connection, this.lastPacketSentTimeMs, this.lastPacketReceivedTimeMs, new IOException("Packets out of order, expected packet # -128, but received packet # " + ((int) b)), getExceptionInterceptor());
        }
        byte b2 = this.readPacketSequence;
        if (b2 == -1 && b != 0) {
            throw SQLError.createCommunicationsException(this.connection, this.lastPacketSentTimeMs, this.lastPacketReceivedTimeMs, new IOException("Packets out of order, expected packet # -1, but received packet # " + ((int) b)), getExceptionInterceptor());
        }
        if (b == -128 || b2 == -1 || b == b2 + 1) {
            return;
        }
        throw SQLError.createCommunicationsException(this.connection, this.lastPacketSentTimeMs, this.lastPacketReceivedTimeMs, new IOException("Packets out of order, expected packet # " + (this.readPacketSequence + 1) + ", but received packet # " + ((int) b)), getExceptionInterceptor());
    }

    private void checkTransactionState(int i) throws SQLException {
        boolean z = (i & 1) != 0;
        boolean zInTransactionOnServer = inTransactionOnServer();
        if (z && !zInTransactionOnServer) {
            this.connection.transactionCompleted();
        } else {
            if (z || !zInTransactionOnServer) {
                return;
            }
            this.connection.transactionBegun();
        }
    }

    private Buffer compressPacket(Buffer buffer, int i, int i2) throws SQLException {
        byte[] byteBuffer;
        int i3;
        if (i2 >= 50) {
            byte[] byteBuffer2 = buffer.getByteBuffer();
            byte[] bArr = new byte[byteBuffer2.length * 2];
            if (this.deflater == null) {
                this.deflater = new Deflater();
            }
            this.deflater.reset();
            this.deflater.setInput(byteBuffer2, i, i2);
            this.deflater.finish();
            int iDeflate = this.deflater.deflate(bArr);
            if (iDeflate > i2) {
                byteBuffer = buffer.getByteBuffer();
            } else {
                byteBuffer = bArr;
                i = 0;
                i3 = i2;
                i2 = iDeflate;
            }
            Buffer buffer2 = new Buffer(i2 + 7);
            buffer2.setPosition(0);
            buffer2.writeLongInt(i2);
            buffer2.writeByte(this.compressedPacketSequence);
            buffer2.writeLongInt(i3);
            buffer2.writeBytesNoNull(byteBuffer, i, i2);
            return buffer2;
        }
        byteBuffer = buffer.getByteBuffer();
        i3 = 0;
        Buffer buffer3 = new Buffer(i2 + 7);
        buffer3.setPosition(0);
        buffer3.writeLongInt(i2);
        buffer3.writeByte(this.compressedPacketSequence);
        buffer3.writeLongInt(i3);
        buffer3.writeBytesNoNull(byteBuffer, i, i2);
        return buffer3;
    }

    private SocketFactory createSocketFactory() throws SQLException {
        try {
            String str = this.socketFactoryClassName;
            if (str != null) {
                return (SocketFactory) Class.forName(str).newInstance();
            }
            throw SQLError.createSQLException(Messages.getString("MysqlIO.75"), SQLError.SQL_STATE_UNABLE_TO_CONNECT_TO_DATASOURCE, getExceptionInterceptor());
        } catch (Exception e) {
            SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(Messages.getString("MysqlIO.76") + this.socketFactoryClassName + Messages.getString("MysqlIO.77"), SQLError.SQL_STATE_UNABLE_TO_CONNECT_TO_DATASOURCE, getExceptionInterceptor());
            sQLExceptionCreateSQLException.initCause(e);
            throw sQLExceptionCreateSQLException;
        }
    }

    private void enqueuePacketForDebugging(boolean z, boolean z2, int i, byte[] bArr, Buffer buffer) throws SQLException {
        StringBuilder sb;
        if (this.packetDebugRingBuffer.size() + 1 > this.connection.getPacketDebugBufferSize()) {
            this.packetDebugRingBuffer.removeFirst();
        }
        if (z) {
            int iMin = Math.min(1024, i);
            String strDump = buffer.dump(iMin);
            sb = new StringBuilder(strDump.length() + 68);
            sb.append("Client ");
            sb.append(buffer.toSuperString());
            sb.append("--------------------> Server\n");
            sb.append("\nPacket payload:\n\n");
            sb.append(strDump);
            if (iMin == 1024) {
                sb.append("\nNote: Packet of " + i + " bytes truncated to 1024 bytes.\n");
            }
        } else {
            int iMin2 = Math.min(1024, buffer.getBufLength());
            Buffer buffer2 = new Buffer(iMin2 + 4);
            buffer2.setPosition(0);
            buffer2.writeBytesNoNull(bArr);
            buffer2.writeBytesNoNull(buffer.getBytes(0, iMin2));
            String strDump2 = buffer2.dump(iMin2);
            sb = new StringBuilder(strDump2.length() + 96);
            sb.append("Server ");
            sb.append(z2 ? "(re-used) " : "(new) ");
            sb.append(buffer.toSuperString());
            sb.append(" --------------------> Client\n");
            sb.append("\nPacket payload:\n\n");
            sb.append(strDump2);
            if (iMin2 == 1024) {
                sb.append("\nNote: Packet of " + buffer.getBufLength() + " bytes truncated to 1024 bytes.\n");
            }
        }
        this.packetDebugRingBuffer.addLast(sb);
    }

    private final void extractNativeEncodedColumn(Buffer buffer, Field[] fieldArr, int i, byte[][] bArr) throws SQLException {
        Field field = fieldArr[i];
        int mysqlType = field.getMysqlType();
        if (mysqlType != 15 && mysqlType != 16 && mysqlType != 245 && mysqlType != 246) {
            switch (mysqlType) {
                case 0:
                    break;
                case 1:
                    bArr[i] = new byte[]{buffer.readByte()};
                    return;
                case 2:
                case 13:
                    bArr[i] = buffer.getBytes(2);
                    return;
                case 3:
                case 9:
                    bArr[i] = buffer.getBytes(4);
                    return;
                case 4:
                    bArr[i] = buffer.getBytes(4);
                    return;
                case 5:
                    bArr[i] = buffer.getBytes(8);
                    return;
                case 6:
                    return;
                case 7:
                case 12:
                    bArr[i] = buffer.getBytes((int) buffer.readFieldLength());
                    return;
                case 8:
                    bArr[i] = buffer.getBytes(8);
                    return;
                case 10:
                    bArr[i] = buffer.getBytes((int) buffer.readFieldLength());
                    return;
                case 11:
                    bArr[i] = buffer.getBytes((int) buffer.readFieldLength());
                    return;
                default:
                    switch (mysqlType) {
                        case MysqlDefs.FIELD_TYPE_TINY_BLOB /* 249 */:
                        case 250:
                        case MysqlDefs.FIELD_TYPE_LONG_BLOB /* 251 */:
                        case MysqlDefs.FIELD_TYPE_BLOB /* 252 */:
                        case MysqlDefs.FIELD_TYPE_VAR_STRING /* 253 */:
                        case MysqlDefs.FIELD_TYPE_STRING /* 254 */:
                        case 255:
                            break;
                        default:
                            throw SQLError.createSQLException(Messages.getString("MysqlIO.97") + field.getMysqlType() + Messages.getString("MysqlIO.98") + i + Messages.getString("MysqlIO.99") + fieldArr.length + Messages.getString("MysqlIO.100"), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
                    }
                    break;
            }
        }
        bArr[i] = buffer.readLenByteArray(0);
    }

    private AuthenticationPlugin getAuthenticationPlugin(String str) throws SQLException {
        AuthenticationPlugin authenticationPlugin;
        Throwable th;
        AuthenticationPlugin authenticationPlugin2 = this.authenticationPlugins.get(str);
        if (authenticationPlugin2 == null || authenticationPlugin2.isReusable()) {
            return authenticationPlugin2;
        }
        try {
            authenticationPlugin = (AuthenticationPlugin) authenticationPlugin2.getClass().newInstance();
            try {
                MySQLConnection mySQLConnection = this.connection;
                authenticationPlugin.init(mySQLConnection, mySQLConnection.getProperties());
                return authenticationPlugin;
            } catch (Throwable th2) {
                th = th2;
                SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(Messages.getString("Connection.BadAuthenticationPlugin", new Object[]{authenticationPlugin.getClass().getName()}), getExceptionInterceptor());
                sQLExceptionCreateSQLException.initCause(th);
                throw sQLExceptionCreateSQLException;
            }
        } catch (Throwable th3) {
            authenticationPlugin = authenticationPlugin2;
            th = th3;
        }
    }

    private Properties getConnectionAttributesAsProperties(String str) throws SQLException {
        int i;
        Properties properties = new Properties();
        if (str != null) {
            for (String str2 : str.split(",")) {
                int iIndexOf = str2.indexOf(":");
                if (iIndexOf > 0 && (i = iIndexOf + 1) < str2.length()) {
                    properties.setProperty(str2.substring(0, iIndexOf), str2.substring(i));
                }
            }
        }
        properties.setProperty("_client_name", NonRegisteringDriver.NAME);
        properties.setProperty("_client_version", NonRegisteringDriver.VERSION);
        properties.setProperty("_runtime_vendor", NonRegisteringDriver.RUNTIME_VENDOR);
        properties.setProperty("_runtime_version", NonRegisteringDriver.RUNTIME_VERSION);
        properties.setProperty("_client_license", NonRegisteringDriver.LICENSE);
        return properties;
    }

    public static int getMaxBuf() {
        return maxBufferSize;
    }

    private static final String getPacketDumpToLog(Buffer buffer, int i) {
        if (i < 1024) {
            return buffer.dump(i);
        }
        StringBuilder sb = new StringBuilder(4096);
        sb.append(buffer.dump(1024));
        sb.append(Messages.getString("MysqlIO.36"));
        sb.append(1024);
        sb.append(Messages.getString("MysqlIO.37"));
        return sb.toString();
    }

    private void loadAuthenticationPlugins() throws SQLException {
        String defaultAuthenticationPlugin = this.connection.getDefaultAuthenticationPlugin();
        this.clientDefaultAuthenticationPlugin = defaultAuthenticationPlugin;
        if (defaultAuthenticationPlugin == null || BuildConfig.FLAVOR.equals(defaultAuthenticationPlugin.trim())) {
            throw SQLError.createSQLException(Messages.getString("Connection.BadDefaultAuthenticationPlugin", new Object[]{this.clientDefaultAuthenticationPlugin}), getExceptionInterceptor());
        }
        String disabledAuthenticationPlugins = this.connection.getDisabledAuthenticationPlugins();
        if (disabledAuthenticationPlugins != null && !BuildConfig.FLAVOR.equals(disabledAuthenticationPlugins)) {
            this.disabledAuthenticationPlugins = new ArrayList();
            Iterator<String> it = StringUtils.split(disabledAuthenticationPlugins, ",", true).iterator();
            while (it.hasNext()) {
                this.disabledAuthenticationPlugins.add(it.next());
            }
        }
        this.authenticationPlugins = new HashMap();
        MysqlOldPasswordPlugin mysqlOldPasswordPlugin = new MysqlOldPasswordPlugin();
        MySQLConnection mySQLConnection = this.connection;
        mysqlOldPasswordPlugin.init(mySQLConnection, mySQLConnection.getProperties());
        boolean zAddAuthenticationPlugin = addAuthenticationPlugin(mysqlOldPasswordPlugin);
        MysqlNativePasswordPlugin mysqlNativePasswordPlugin = new MysqlNativePasswordPlugin();
        MySQLConnection mySQLConnection2 = this.connection;
        mysqlNativePasswordPlugin.init(mySQLConnection2, mySQLConnection2.getProperties());
        if (addAuthenticationPlugin(mysqlNativePasswordPlugin)) {
            zAddAuthenticationPlugin = true;
        }
        MysqlClearPasswordPlugin mysqlClearPasswordPlugin = new MysqlClearPasswordPlugin();
        MySQLConnection mySQLConnection3 = this.connection;
        mysqlClearPasswordPlugin.init(mySQLConnection3, mySQLConnection3.getProperties());
        if (addAuthenticationPlugin(mysqlClearPasswordPlugin)) {
            zAddAuthenticationPlugin = true;
        }
        Sha256PasswordPlugin sha256PasswordPlugin = new Sha256PasswordPlugin();
        MySQLConnection mySQLConnection4 = this.connection;
        sha256PasswordPlugin.init(mySQLConnection4, mySQLConnection4.getProperties());
        if (addAuthenticationPlugin(sha256PasswordPlugin)) {
            zAddAuthenticationPlugin = true;
        }
        CachingSha2PasswordPlugin cachingSha2PasswordPlugin = new CachingSha2PasswordPlugin();
        MySQLConnection mySQLConnection5 = this.connection;
        cachingSha2PasswordPlugin.init(mySQLConnection5, mySQLConnection5.getProperties());
        if (addAuthenticationPlugin(cachingSha2PasswordPlugin)) {
            zAddAuthenticationPlugin = true;
        }
        String authenticationPlugins = this.connection.getAuthenticationPlugins();
        if (authenticationPlugins != null && !BuildConfig.FLAVOR.equals(authenticationPlugins)) {
            MySQLConnection mySQLConnection6 = this.connection;
            Iterator<Extension> it2 = Util.loadExtensions(mySQLConnection6, mySQLConnection6.getProperties(), authenticationPlugins, "Connection.BadAuthenticationPlugin", getExceptionInterceptor()).iterator();
            while (it2.hasNext()) {
                if (addAuthenticationPlugin((AuthenticationPlugin) it2.next())) {
                    zAddAuthenticationPlugin = true;
                }
            }
        }
        if (!zAddAuthenticationPlugin) {
            throw SQLError.createSQLException(Messages.getString("Connection.DefaultAuthenticationPluginIsNotListed", new Object[]{this.clientDefaultAuthenticationPlugin}), getExceptionInterceptor());
        }
    }

    private void negotiateSSLConnection(String str, String str2, String str3, int i) throws SQLException {
        if (!ExportControlled.enabled()) {
            throw new ConnectionFeatureNotAvailableException(this.connection, this.lastPacketSentTimeMs, null);
        }
        if ((this.serverCapabilities & 32768) != 0) {
            this.clientParam |= 32768;
        }
        this.clientParam |= 2048;
        Buffer buffer = new Buffer(i);
        if (this.use41Extensions) {
            buffer.writeLong(this.clientParam);
            buffer.writeLong(this.maxThreeBytes);
            appendCharsetByteForHandshake(buffer, getEncodingForHandshake());
            buffer.writeBytesNoNull(new byte[23]);
        } else {
            buffer.writeInt((int) this.clientParam);
        }
        send(buffer, buffer.getPosition());
        ExportControlled.transformSocketToSSLSocket(this);
    }

    private void preserveOldTransactionState() {
        this.serverStatus |= this.oldServerStatus & 1;
    }

    private void proceedHandshakeWithPluggableAuthentication(String str, String str2, String str3, Buffer buffer) throws SQLException {
        int i;
        String str4;
        Buffer buffer2;
        boolean z;
        int i2;
        if (this.authenticationPlugins == null) {
            loadAuthenticationPlugins();
        }
        byte b = 0;
        int length = (((str != null ? str.length() : 0) + 16 + (str3 != null ? str3.length() : 0)) * 3) + 7 + 4 + 33;
        ArrayList<Buffer> arrayList = new ArrayList();
        Buffer bufferCheckErrorPacket = buffer;
        int i3 = 100;
        boolean z2 = false;
        AuthenticationPlugin authenticationPlugin = null;
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            i = i3 - 1;
            if (i3 <= 0) {
                break;
            }
            if (z2) {
                str4 = str2;
                bufferCheckErrorPacket = checkErrorPacket();
                this.packetSequence = (byte) (this.packetSequence + 1);
                this.compressedPacketSequence = (byte) (this.compressedPacketSequence + 1);
                if (authenticationPlugin == null) {
                    String str5 = this.serverDefaultAuthenticationPluginName;
                    if (str5 == null) {
                        str5 = this.clientDefaultAuthenticationPluginName;
                    }
                    authenticationPlugin = getAuthenticationPlugin(str5);
                }
                if (bufferCheckErrorPacket.isOKPacket()) {
                    bufferCheckErrorPacket.newReadLength();
                    bufferCheckErrorPacket.newReadLength();
                    this.oldServerStatus = this.serverStatus;
                    this.serverStatus = bufferCheckErrorPacket.readInt();
                    authenticationPlugin.destroy();
                    break;
                }
                if (bufferCheckErrorPacket.isAuthMethodSwitchRequestPacket()) {
                    String string = bufferCheckErrorPacket.readString("ASCII", getExceptionInterceptor());
                    if (authenticationPlugin.getProtocolPluginName().equals(string)) {
                        authenticationPlugin.reset();
                    } else {
                        authenticationPlugin.destroy();
                        authenticationPlugin = getAuthenticationPlugin(string);
                        if (authenticationPlugin == null) {
                            Object[] objArr = new Object[1];
                            objArr[b] = string;
                            throw SQLError.createSQLException(Messages.getString("Connection.BadAuthenticationPlugin", objArr), getExceptionInterceptor());
                        }
                    }
                    checkConfidentiality(authenticationPlugin);
                    buffer2 = new Buffer(StringUtils.getBytes(bufferCheckErrorPacket.readString("ASCII", getExceptionInterceptor())));
                    z3 = false;
                } else if (versionMeetsMinimum(5, 5, 16)) {
                    buffer2 = new Buffer(bufferCheckErrorPacket.getBytes(bufferCheckErrorPacket.getPosition(), bufferCheckErrorPacket.getBufLength() - bufferCheckErrorPacket.getPosition()));
                } else {
                    buffer2 = new Buffer(bufferCheckErrorPacket.getBytes(bufferCheckErrorPacket.getPosition() - 1, (bufferCheckErrorPacket.getBufLength() - bufferCheckErrorPacket.getPosition()) + 1));
                    z4 = true;
                }
                z4 = false;
            } else if (bufferCheckErrorPacket == null) {
                str4 = str2;
                String str6 = this.serverDefaultAuthenticationPluginName;
                if (str6 == null) {
                    str6 = this.clientDefaultAuthenticationPluginName;
                }
                AuthenticationPlugin authenticationPlugin2 = getAuthenticationPlugin(str6);
                checkConfidentiality(authenticationPlugin2);
                authenticationPlugin = authenticationPlugin2;
                buffer2 = new Buffer(StringUtils.getBytes(this.seed));
            } else {
                if (bufferCheckErrorPacket.isOKPacket()) {
                    Object[] objArr2 = new Object[1];
                    objArr2[b] = authenticationPlugin.getProtocolPluginName();
                    throw SQLError.createSQLException(Messages.getString("Connection.UnexpectedAuthenticationApproval", objArr2), getExceptionInterceptor());
                }
                this.clientParam |= 696833;
                if (this.connection.getAllowMultiQueries()) {
                    this.clientParam |= 65536;
                }
                if ((this.serverCapabilities & 4194304) != 0 && !this.connection.getDisconnectOnExpiredPasswords()) {
                    this.clientParam |= 4194304;
                }
                if ((this.serverCapabilities & 1048576) != 0 && !"none".equals(this.connection.getConnectionAttributes())) {
                    this.clientParam |= 1048576;
                }
                if ((this.serverCapabilities & 2097152) != 0) {
                    this.clientParam |= 2097152;
                }
                this.has41NewNewProt = true;
                this.use41Extensions = true;
                if (this.connection.getUseSSL()) {
                    str4 = str2;
                    negotiateSSLConnection(str, str4, str3, length);
                } else {
                    str4 = str2;
                }
                String string2 = (this.serverCapabilities & 524288) != 0 ? (!versionMeetsMinimum(5, 5, 10) || (versionMeetsMinimum(5, 6, b) && !versionMeetsMinimum(5, 6, 2))) ? bufferCheckErrorPacket.readString("ASCII", getExceptionInterceptor(), this.authPluginDataLength) : bufferCheckErrorPacket.readString("ASCII", getExceptionInterceptor()) : null;
                AuthenticationPlugin authenticationPlugin3 = getAuthenticationPlugin(string2);
                if (authenticationPlugin3 == null) {
                    authenticationPlugin3 = getAuthenticationPlugin(this.clientDefaultAuthenticationPluginName);
                } else if (string2.equals(Sha256PasswordPlugin.PLUGIN_NAME) && !isSSLEstablished() && this.connection.getServerRSAPublicKeyFile() == null && !this.connection.getAllowPublicKeyRetrieval()) {
                    authenticationPlugin3 = getAuthenticationPlugin(this.clientDefaultAuthenticationPluginName);
                    z3 = !this.clientDefaultAuthenticationPluginName.equals(string2);
                }
                this.serverDefaultAuthenticationPluginName = authenticationPlugin3.getProtocolPluginName();
                checkConfidentiality(authenticationPlugin3);
                buffer2 = new Buffer(StringUtils.getBytes(this.seed));
                authenticationPlugin = authenticationPlugin3;
            }
            try {
                authenticationPlugin.setAuthenticationParameters(str, z3 ? null : str4);
                boolean zNextAuthenticationStep = authenticationPlugin.nextAuthenticationStep(buffer2, arrayList);
                if (arrayList.size() <= 0) {
                    z = zNextAuthenticationStep;
                    i2 = length;
                } else if (bufferCheckErrorPacket == null) {
                    String encodingForHandshake = getEncodingForHandshake();
                    Buffer buffer3 = new Buffer(length + 1);
                    buffer3.writeByte((byte) 17);
                    buffer3.writeString(str, encodingForHandshake, this.connection);
                    z = zNextAuthenticationStep;
                    if (((Buffer) arrayList.get(b)).getBufLength() < 256) {
                        buffer3.writeByte((byte) ((Buffer) arrayList.get(b)).getBufLength());
                        buffer3.writeBytesNoNull(((Buffer) arrayList.get(b)).getByteBuffer(), b, ((Buffer) arrayList.get(b)).getBufLength());
                    } else {
                        buffer3.writeByte(b);
                    }
                    if (this.useConnectWithDb) {
                        buffer3.writeString(str3, encodingForHandshake, this.connection);
                    } else {
                        buffer3.writeByte(b);
                    }
                    appendCharsetByteForHandshake(buffer3, encodingForHandshake);
                    buffer3.writeByte(b);
                    if ((this.serverCapabilities & 524288) != 0) {
                        buffer3.writeString(authenticationPlugin.getProtocolPluginName(), encodingForHandshake, this.connection);
                    }
                    i2 = length;
                    if ((this.clientParam & 1048576) != 0) {
                        sendConnectionAttributes(buffer3, encodingForHandshake, this.connection);
                        buffer3.writeByte((byte) 0);
                    }
                    send(buffer3, buffer3.getPosition());
                } else {
                    z = zNextAuthenticationStep;
                    i2 = length;
                    if (bufferCheckErrorPacket.isAuthMethodSwitchRequestPacket()) {
                        Buffer buffer4 = new Buffer(((Buffer) arrayList.get(b)).getBufLength() + 4);
                        buffer4.writeBytesNoNull(((Buffer) arrayList.get(b)).getByteBuffer(), b, ((Buffer) arrayList.get(b)).getBufLength());
                        send(buffer4, buffer4.getPosition());
                    } else if (bufferCheckErrorPacket.isRawPacket() || z4) {
                        for (Buffer buffer5 : arrayList) {
                            Buffer buffer6 = new Buffer(buffer5.getBufLength() + 4);
                            buffer6.writeBytesNoNull(buffer5.getByteBuffer(), 0, ((Buffer) arrayList.get(0)).getBufLength());
                            send(buffer6, buffer6.getPosition());
                        }
                    } else {
                        String encodingForHandshake2 = getEncodingForHandshake();
                        Buffer buffer7 = new Buffer(i2);
                        buffer7.writeLong(this.clientParam);
                        buffer7.writeLong(this.maxThreeBytes);
                        appendCharsetByteForHandshake(buffer7, encodingForHandshake2);
                        buffer7.writeBytesNoNull(new byte[23]);
                        buffer7.writeString(str, encodingForHandshake2, this.connection);
                        if ((this.serverCapabilities & 2097152) != 0) {
                            buffer7.writeLenBytes(((Buffer) arrayList.get(0)).getBytes(((Buffer) arrayList.get(0)).getBufLength()));
                        } else {
                            buffer7.writeByte((byte) ((Buffer) arrayList.get(0)).getBufLength());
                            buffer7.writeBytesNoNull(((Buffer) arrayList.get(0)).getByteBuffer(), 0, ((Buffer) arrayList.get(0)).getBufLength());
                        }
                        if (this.useConnectWithDb) {
                            buffer7.writeString(str3, encodingForHandshake2, this.connection);
                        }
                        if ((this.serverCapabilities & 524288) != 0) {
                            buffer7.writeString(authenticationPlugin.getProtocolPluginName(), encodingForHandshake2, this.connection);
                        }
                        if ((this.clientParam & 1048576) != 0) {
                            sendConnectionAttributes(buffer7, encodingForHandshake2, this.connection);
                        }
                        send(buffer7, buffer7.getPosition());
                    }
                }
                length = i2;
                i3 = i;
                z2 = z;
                b = 0;
            } catch (SQLException e) {
                throw SQLError.createSQLException(e.getMessage(), e.getSQLState(), e, getExceptionInterceptor());
            }
        }
        if (i == 0) {
            throw SQLError.createSQLException(Messages.getString("CommunicationsException.TooManyAuthenticationPluginNegotiations"), getExceptionInterceptor());
        }
        if ((this.serverCapabilities & 32) != 0 && this.connection.getUseCompression() && !(this.mysqlInput instanceof CompressedInputStream)) {
            this.deflater = new Deflater();
            this.useCompression = true;
            this.mysqlInput = new CompressedInputStream(this.connection, this.mysqlInput);
        }
        if (!this.useConnectWithDb) {
            changeDatabaseTo(str3);
        }
        try {
            this.mysqlConnection = this.socketFactory.afterHandshake();
        } catch (IOException e2) {
            throw SQLError.createCommunicationsException(this.connection, this.lastPacketSentTimeMs, this.lastPacketReceivedTimeMs, e2, getExceptionInterceptor());
        }
    }

    private final int readFully(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = 0;
        while (i3 < i2) {
            int i4 = inputStream.read(bArr, i + i3, i2 - i3);
            if (i4 < 0) {
                throw new EOFException(Messages.getString("MysqlIO.EOF", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
            }
            i3 += i4;
        }
        return i3;
    }

    private int readRemainingMultiPackets(Buffer buffer, byte b) throws SQLException, IOException {
        Buffer buffer2 = null;
        while (readFully(this.mysqlInput, this.packetHeaderBuf, 0, 4) >= 4) {
            byte[] bArr = this.packetHeaderBuf;
            int i = (bArr[0] & StatementImpl.USES_VARIABLES_UNKNOWN) + ((bArr[1] & StatementImpl.USES_VARIABLES_UNKNOWN) << 8) + ((bArr[2] & StatementImpl.USES_VARIABLES_UNKNOWN) << 16);
            if (buffer2 == null) {
                buffer2 = new Buffer(i);
            }
            if (this.useNewLargePackets || i != 1) {
                b = (byte) (b + 1);
                if (b != this.packetHeaderBuf[3]) {
                    throw new IOException(Messages.getString("MysqlIO.49"));
                }
                buffer2.setPosition(0);
                buffer2.setBufLength(i);
                byte[] byteBuffer = buffer2.getByteBuffer();
                int fully = readFully(this.mysqlInput, byteBuffer, 0, i);
                if (fully != i) {
                    throw SQLError.createCommunicationsException(this.connection, this.lastPacketSentTimeMs, this.lastPacketReceivedTimeMs, SQLError.createSQLException(Messages.getString("MysqlIO.50") + i + Messages.getString("MysqlIO.51") + fully + ".", getExceptionInterceptor()), getExceptionInterceptor());
                }
                buffer.writeBytesNoNull(byteBuffer, 0, i);
                if (i != this.maxThreeBytes) {
                }
            } else {
                clearInputStream();
            }
            buffer.setPosition(0);
            buffer.setWasMultiPacket(true);
            return i;
        }
        forceClose();
        throw new IOException(Messages.getString("MysqlIO.47"));
    }

    private final void readServerStatusForResultSets(Buffer buffer) throws SQLException {
        if (this.use41Extensions) {
            buffer.readByte();
            if (isEOFDeprecated()) {
                buffer.newReadLength();
                buffer.newReadLength();
                this.oldServerStatus = this.serverStatus;
                this.serverStatus = buffer.readInt();
                checkTransactionState(this.oldServerStatus);
                int i = buffer.readInt();
                this.warningCount = i;
                if (i > 0) {
                    this.hadWarnings = true;
                }
                buffer.readByte();
                if (this.connection.isReadInfoMsgEnabled()) {
                    buffer.readString(this.connection.getErrorMessageEncoding(), getExceptionInterceptor());
                }
            } else {
                int i2 = buffer.readInt();
                this.warningCount = i2;
                if (i2 > 0) {
                    this.hadWarnings = true;
                }
                this.oldServerStatus = this.serverStatus;
                this.serverStatus = buffer.readInt();
                checkTransactionState(this.oldServerStatus);
            }
            setServerSlowQueryFlags();
        }
    }

    private RowData readSingleRowSet(long j, int i, int i2, boolean z, Field[] fieldArr) throws SQLException {
        int i3;
        ArrayList arrayList = new ArrayList();
        boolean zUseBufferRowExplicit = useBufferRowExplicit(fieldArr);
        int i4 = (int) j;
        ResultSetRow resultSetRowNextRow = nextRow(fieldArr, i4, z, i2, false, zUseBufferRowExplicit, false, null);
        if (resultSetRowNextRow != null) {
            arrayList.add(resultSetRowNextRow);
            i3 = 1;
        } else {
            i3 = 0;
        }
        while (resultSetRowNextRow != null) {
            resultSetRowNextRow = nextRow(fieldArr, i4, z, i2, false, zUseBufferRowExplicit, false, null);
            if (resultSetRowNextRow != null && (i == -1 || i3 < i)) {
                arrayList.add(resultSetRowNextRow);
                i3++;
            }
        }
        return new RowDataStatic(arrayList);
    }

    private void reclaimLargeReusablePacket() {
        Buffer buffer = this.reusablePacket;
        if (buffer == null || buffer.getCapacity() <= 1048576) {
            return;
        }
        this.reusablePacket = new Buffer(1024);
    }

    private void reclaimLargeSharedSendPacket() {
        Buffer buffer = this.sharedSendPacket;
        if (buffer == null || buffer.getCapacity() <= 1048576) {
            return;
        }
        this.sharedSendPacket = new Buffer(1024);
    }

    private final Buffer reuseAndReadPacket(Buffer buffer) throws SQLException {
        return reuseAndReadPacket(buffer, -1);
    }

    private void secureAuth(Buffer buffer, int i, String str, String str2, String str3, boolean z) throws SQLException {
        if (buffer == null) {
            buffer = new Buffer(i);
        }
        if (z) {
            if (!this.use41Extensions) {
                buffer.writeInt((int) this.clientParam);
                buffer.writeLongInt(this.maxThreeBytes);
            } else if (versionMeetsMinimum(4, 1, 1)) {
                buffer.writeLong(this.clientParam);
                buffer.writeLong(this.maxThreeBytes);
                buffer.writeByte((byte) 8);
                buffer.writeBytesNoNull(new byte[23]);
            } else {
                buffer.writeLong(this.clientParam);
                buffer.writeLong(this.maxThreeBytes);
            }
        }
        buffer.writeString(str, CODE_PAGE_1252, this.connection);
        if (str2.length() != 0) {
            buffer.writeString(FALSE_SCRAMBLE, CODE_PAGE_1252, this.connection);
        } else {
            buffer.writeString(BuildConfig.FLAVOR, CODE_PAGE_1252, this.connection);
        }
        if (this.useConnectWithDb) {
            buffer.writeString(str3, CODE_PAGE_1252, this.connection);
        }
        send(buffer, buffer.getPosition());
        if (str2.length() > 0) {
            Buffer packet = readPacket();
            packet.setPosition(0);
            byte[] byteBuffer = packet.getByteBuffer();
            if (byteBuffer.length != 24 || byteBuffer[0] == 0) {
                return;
            }
            if (byteBuffer[0] == 42) {
                try {
                    byte[] bArrCreateKeyFromOldPassword = Security.createKeyFromOldPassword(str2);
                    byte[] bArr = new byte[byteBuffer.length - 4];
                    System.arraycopy(byteBuffer, 4, bArr, 0, byteBuffer.length - 4);
                    byte[] bArr2 = new byte[20];
                    Security.xorString(bArr, bArr2, bArrCreateKeyFromOldPassword, 20);
                    String strScramble = Util.scramble(StringUtils.toString(bArr2), str2);
                    Buffer buffer2 = new Buffer(i);
                    buffer2.writeString(strScramble, CODE_PAGE_1252, this.connection);
                    this.packetSequence = (byte) (this.packetSequence + 1);
                    send(buffer2, 24);
                    return;
                } catch (NoSuchAlgorithmException unused) {
                    throw SQLError.createSQLException(Messages.getString("MysqlIO.91") + Messages.getString("MysqlIO.92"), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
                }
            }
            try {
                byte[] bArrPasswordHashStage1 = Security.passwordHashStage1(str2);
                byte[] bArr3 = new byte[bArrPasswordHashStage1.length];
                System.arraycopy(bArrPasswordHashStage1, 0, bArr3, 0, bArrPasswordHashStage1.length);
                byte[] bArrPasswordHashStage2 = Security.passwordHashStage2(bArr3, byteBuffer);
                byte[] bArr4 = new byte[byteBuffer.length - 4];
                System.arraycopy(byteBuffer, 4, bArr4, 0, byteBuffer.length - 4);
                byte[] bArr5 = new byte[20];
                Security.xorString(bArr4, bArr5, bArrPasswordHashStage2, 20);
                Security.xorString(bArr5, bArrPasswordHashStage1, bArrPasswordHashStage1, 20);
                Buffer buffer3 = new Buffer(25);
                buffer3.writeBytesNoNull(bArrPasswordHashStage1);
                this.packetSequence = (byte) (this.packetSequence + 1);
                send(buffer3, 24);
            } catch (NoSuchAlgorithmException unused2) {
                throw SQLError.createSQLException(Messages.getString("MysqlIO.91") + Messages.getString("MysqlIO.92"), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
            }
        }
    }

    private final void send(Buffer buffer, int i) throws SQLException {
        Buffer bufferCompressPacket;
        int i2;
        int i3;
        try {
            int i4 = this.maxAllowedPacket;
            if (i4 > 0 && i > i4) {
                throw new PacketTooBigException(i, this.maxAllowedPacket);
            }
            if (this.serverMajorVersion < 4 || ((i2 = i - 4) < (i3 = this.maxThreeBytes) && (!this.useCompression || i2 < i3 - 3))) {
                this.packetSequence = (byte) (this.packetSequence + 1);
                buffer.setPosition(0);
                buffer.writeLongInt(i - 4);
                buffer.writeByte(this.packetSequence);
                if (this.useCompression) {
                    this.compressedPacketSequence = (byte) (this.compressedPacketSequence + 1);
                    bufferCompressPacket = compressPacket(buffer, 0, i);
                    int position = bufferCompressPacket.getPosition();
                    if (this.traceProtocol) {
                        this.connection.getLog().logTrace(Messages.getString("MysqlIO.57") + getPacketDumpToLog(bufferCompressPacket, position) + Messages.getString("MysqlIO.58") + getPacketDumpToLog(buffer, i));
                    }
                    i = position;
                } else {
                    if (this.traceProtocol) {
                        this.connection.getLog().logTrace(Messages.getString("MysqlIO.59") + "host: '" + this.host + "' threadId: '" + this.threadId + "'\n" + buffer.dump(i));
                    }
                    bufferCompressPacket = buffer;
                }
                this.mysqlOutput.write(bufferCompressPacket.getByteBuffer(), 0, i);
                this.mysqlOutput.flush();
            } else {
                sendSplitPackets(buffer, i);
            }
            if (this.enablePacketDebug) {
                enqueuePacketForDebugging(true, false, i + 5, this.packetHeaderBuf, buffer);
            }
            if (buffer == this.sharedSendPacket) {
                reclaimLargeSharedSendPacket();
            }
            if (this.connection.getMaintainTimeStats()) {
                this.lastPacketSentTimeMs = System.currentTimeMillis();
            }
        } catch (IOException e) {
            throw SQLError.createCommunicationsException(this.connection, this.lastPacketSentTimeMs, this.lastPacketReceivedTimeMs, e, getExceptionInterceptor());
        }
    }

    private void sendConnectionAttributes(Buffer buffer, String str, MySQLConnection mySQLConnection) throws SQLException {
        String connectionAttributes = mySQLConnection.getConnectionAttributes();
        Buffer buffer2 = new Buffer(100);
        try {
            Properties connectionAttributesAsProperties = getConnectionAttributesAsProperties(connectionAttributes);
            for (Object obj : connectionAttributesAsProperties.keySet()) {
                buffer2.writeLenString((String) obj, str, mySQLConnection.getServerCharset(), null, mySQLConnection.parserKnowsUnicode(), mySQLConnection);
                buffer2.writeLenString(connectionAttributesAsProperties.getProperty((String) obj), str, mySQLConnection.getServerCharset(), null, mySQLConnection.parserKnowsUnicode(), mySQLConnection);
            }
        } catch (UnsupportedEncodingException unused) {
        }
        buffer.writeByte((byte) (buffer2.getPosition() - 4));
        buffer.writeBytesNoNull(buffer2.getByteBuffer(), 4, buffer2.getBufLength() - 4);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00ef A[Catch: all -> 0x0130, IOException -> 0x0132, LOOP:0: B:35:0x00e9->B:37:0x00ef, LOOP_END, TRY_LEAVE, TryCatch #2 {IOException -> 0x0132, blocks: (B:16:0x008e, B:19:0x0098, B:23:0x00a1, B:35:0x00e9, B:37:0x00ef, B:25:0x00a8, B:27:0x00b0, B:29:0x00bc, B:31:0x00c4, B:34:0x00de, B:33:0x00d3, B:45:0x0121, B:46:0x012f), top: B:68:0x008e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x00fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private final ResultSetImpl sendFileToServer(StatementImpl statementImpl, String str) throws SQLException {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        BufferedInputStream bufferedInputStream3;
        int i;
        if (this.useCompression) {
            this.compressedPacketSequence = (byte) (this.compressedPacketSequence + 1);
        }
        SoftReference<Buffer> softReference = this.loadFileBufRef;
        BufferedInputStream bufferedInputStream4 = null;
        Buffer buffer = softReference == null ? null : softReference.get();
        int iMin = Math.min(Math.min(1048564, alignPacketSize(1048560, 4096) - 12), Math.min(this.connection.getMaxAllowedPacket() - 12, alignPacketSize(this.connection.getMaxAllowedPacket() - 16, 4096) - 12));
        if (buffer == null) {
            try {
                buffer = new Buffer(iMin + 4);
                this.loadFileBufRef = new SoftReference<>(buffer);
            } catch (OutOfMemoryError unused) {
                throw SQLError.createSQLException("Could not allocate packet of " + iMin + " bytes required for LOAD DATA LOCAL INFILE operation. Try increasing max heap allocation for JVM or decreasing server variable 'max_allowed_packet'", SQLError.SQL_STATE_MEMORY_ALLOCATION_FAILURE, getExceptionInterceptor());
            }
        }
        buffer.clear();
        send(buffer, 0);
        byte[] bArr = new byte[iMin];
        try {
            try {
                if (!this.connection.getAllowLoadLocalInfile()) {
                    throw SQLError.createSQLException(Messages.getString("MysqlIO.LoadDataLocalNotAllowed"), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
                }
                InputStream localInfileInputStream = statementImpl != null ? statementImpl.getLocalInfileInputStream() : null;
                if (localInfileInputStream != null) {
                    bufferedInputStream2 = new BufferedInputStream(localInfileInputStream);
                } else {
                    if (this.connection.getAllowUrlInLocalInfile() && str.indexOf(58) != -1) {
                        try {
                            bufferedInputStream2 = new BufferedInputStream(new URL(str).openStream());
                        } catch (MalformedURLException unused2) {
                            bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
                            bufferedInputStream3 = bufferedInputStream;
                        }
                    } else {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
                    }
                    bufferedInputStream3 = bufferedInputStream;
                    while (true) {
                        i = bufferedInputStream3.read(bArr);
                        if (i != -1) {
                            try {
                                bufferedInputStream3.close();
                                buffer.clear();
                                send(buffer, buffer.getPosition());
                                return buildResultSetWithUpdates(statementImpl, checkErrorPacket());
                            } catch (Exception e) {
                                throw SQLError.createSQLException(Messages.getString("MysqlIO.65"), SQLError.SQL_STATE_GENERAL_ERROR, e, getExceptionInterceptor());
                            }
                        }
                        buffer.clear();
                        buffer.writeBytesNoNull(bArr, 0, i);
                        send(buffer, buffer.getPosition());
                    }
                }
                bufferedInputStream3 = bufferedInputStream2;
                while (true) {
                    i = bufferedInputStream3.read(bArr);
                    if (i != -1) {
                        bufferedInputStream3.close();
                        buffer.clear();
                        send(buffer, buffer.getPosition());
                        return buildResultSetWithUpdates(statementImpl, checkErrorPacket());
                    }
                    buffer.clear();
                    buffer.writeBytesNoNull(bArr, 0, i);
                    send(buffer, buffer.getPosition());
                }
            } catch (IOException e2) {
                StringBuilder sb = new StringBuilder(Messages.getString("MysqlIO.60"));
                if (str != null && !this.connection.getParanoid()) {
                    sb.append("'");
                    sb.append(str);
                    sb.append("'");
                }
                sb.append(Messages.getString("MysqlIO.63"));
                if (!this.connection.getParanoid()) {
                    sb.append(Messages.getString("MysqlIO.64"));
                    sb.append(Util.stackTraceToString(e2));
                }
                throw SQLError.createSQLException(sb.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    bufferedInputStream4.close();
                } catch (Exception e3) {
                    throw SQLError.createSQLException(Messages.getString("MysqlIO.65"), SQLError.SQL_STATE_GENERAL_ERROR, e3, getExceptionInterceptor());
                }
            } else {
                buffer.clear();
                send(buffer, buffer.getPosition());
                checkErrorPacket();
            }
            throw th;
        }
    }

    private final void sendSplitPackets(Buffer buffer, int i) throws SQLException {
        SoftReference<Buffer> softReference;
        try {
            SoftReference<Buffer> softReference2 = this.splitBufRef;
            Buffer buffer2 = null;
            Buffer buffer3 = softReference2 == null ? null : softReference2.get();
            if (this.useCompression && (softReference = this.compressBufRef) != null) {
                buffer2 = softReference.get();
            }
            if (buffer3 == null) {
                buffer3 = new Buffer(this.maxThreeBytes + 4);
                this.splitBufRef = new SoftReference<>(buffer3);
            }
            if (this.useCompression) {
                int i2 = (((i / this.maxThreeBytes) + 1) * 4) + i;
                if (buffer2 == null) {
                    buffer2 = new Buffer(i2);
                    this.compressBufRef = new SoftReference<>(buffer2);
                } else if (buffer2.getBufLength() < i2) {
                    buffer2.setPosition(buffer2.getBufLength());
                    buffer2.ensureCapacity(i2 - buffer2.getBufLength());
                }
            }
            int i3 = i - 4;
            int i4 = this.maxThreeBytes;
            byte[] byteBuffer = buffer.getByteBuffer();
            int i5 = 0;
            int i6 = 4;
            while (i3 >= 0) {
                this.packetSequence = (byte) (this.packetSequence + 1);
                if (i3 < i4) {
                    i4 = i3;
                }
                buffer3.setPosition(0);
                buffer3.writeLongInt(i4);
                buffer3.writeByte(this.packetSequence);
                if (i3 > 0) {
                    System.arraycopy(byteBuffer, i6, buffer3.getByteBuffer(), 4, i4);
                }
                if (this.useCompression) {
                    int i7 = i4 + 4;
                    System.arraycopy(buffer3.getByteBuffer(), 0, buffer2.getByteBuffer(), i5, i7);
                    i5 += i7;
                } else {
                    this.mysqlOutput.write(buffer3.getByteBuffer(), 0, i4 + 4);
                    this.mysqlOutput.flush();
                }
                i6 += i4;
                i3 -= this.maxThreeBytes;
            }
            if (this.useCompression) {
                int i8 = this.maxThreeBytes - 3;
                int i9 = 0;
                while (i5 >= 0) {
                    this.compressedPacketSequence = (byte) (this.compressedPacketSequence + 1);
                    if (i5 < i8) {
                        i8 = i5;
                    }
                    Buffer bufferCompressPacket = compressPacket(buffer2, i9, i8);
                    this.mysqlOutput.write(bufferCompressPacket.getByteBuffer(), 0, bufferCompressPacket.getPosition());
                    this.mysqlOutput.flush();
                    i9 += i8;
                    i5 -= this.maxThreeBytes - 3;
                }
            }
        } catch (IOException e) {
            throw SQLError.createCommunicationsException(this.connection, this.lastPacketSentTimeMs, this.lastPacketReceivedTimeMs, e, getExceptionInterceptor());
        }
    }

    private void setServerSlowQueryFlags() {
        int i = this.serverStatus;
        this.queryBadIndexUsed = (i & 16) != 0;
        this.queryNoIndexUsed = (i & 32) != 0;
        this.serverQueryWasSlow = (i & 2048) != 0;
    }

    private final long skipFully(InputStream inputStream, long j) throws IOException {
        if (j < 0) {
            throw new IOException("Negative skip length not allowed");
        }
        long j2 = 0;
        while (j2 < j) {
            long jSkip = inputStream.skip(j - j2);
            if (jSkip < 0) {
                throw new EOFException(Messages.getString("MysqlIO.EOF", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
            }
            j2 += jSkip;
        }
        return j2;
    }

    private final int skipLengthEncodedInteger(InputStream inputStream) throws IOException {
        long jSkipFully;
        switch (inputStream.read() & 255) {
            case MysqlDefs.FIELD_TYPE_BLOB /* 252 */:
                jSkipFully = skipFully(inputStream, 2L);
                break;
            case MysqlDefs.FIELD_TYPE_VAR_STRING /* 253 */:
                jSkipFully = skipFully(inputStream, 3L);
                break;
            case MysqlDefs.FIELD_TYPE_STRING /* 254 */:
                jSkipFully = skipFully(inputStream, 8L);
                break;
            default:
                return 1;
        }
        return ((int) jSkipFully) + 1;
    }

    private final ResultSetRow unpackBinaryResultSetRow(Field[] fieldArr, Buffer buffer, int i) throws SQLException {
        int length = fieldArr.length;
        byte[][] bArr = new byte[length][];
        int position = buffer.getPosition();
        buffer.setPosition(((length + 9) / 8) + position);
        int i2 = 4;
        for (int i3 = 0; i3 < length; i3++) {
            if ((buffer.readByte(position) & i2) != 0) {
                bArr[i3] = null;
            } else if (i != 1008) {
                extractNativeEncodedColumn(buffer, fieldArr, i3, bArr);
            } else {
                unpackNativeEncodedColumn(buffer, fieldArr, i3, bArr);
            }
            i2 <<= 1;
            if ((i2 & 255) == 0) {
                position++;
                i2 = 1;
            }
        }
        return new ByteArrayRow(bArr, getExceptionInterceptor());
    }

    /* JADX WARN: Code duplicated, block: B:56:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:57:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:59:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:60:0x01fc  */
    private final void unpackNativeEncodedColumn(Buffer buffer, Field[] fieldArr, int i, byte[][] bArr) throws SQLException {
        byte b;
        int i2;
        byte b2;
        byte b3;
        byte b4;
        byte b5;
        int i3;
        byte b6;
        byte b7;
        byte b8;
        byte b9;
        byte b10;
        Field field = fieldArr[i];
        int mysqlType = field.getMysqlType();
        if (mysqlType != 15 && mysqlType != 16 && mysqlType != 245 && mysqlType != 246) {
            switch (mysqlType) {
                case 0:
                    break;
                case 1:
                    byte b11 = buffer.readByte();
                    if (field.isUnsigned()) {
                        bArr[i] = StringUtils.getBytes(String.valueOf((int) ((short) (b11 & StatementImpl.USES_VARIABLES_UNKNOWN))));
                        return;
                    } else {
                        bArr[i] = StringUtils.getBytes(String.valueOf((int) b11));
                        return;
                    }
                case 2:
                case 13:
                    short s = (short) buffer.readInt();
                    if (field.isUnsigned()) {
                        bArr[i] = StringUtils.getBytes(String.valueOf(s & ISelectionInterface.HELD_NOTHING));
                        return;
                    } else {
                        bArr[i] = StringUtils.getBytes(String.valueOf((int) s));
                        return;
                    }
                case 3:
                case 9:
                    int i4 = (int) buffer.readLong();
                    if (field.isUnsigned()) {
                        bArr[i] = StringUtils.getBytes(String.valueOf(((long) i4) & MysqlDefs.LENGTH_LONGBLOB));
                        return;
                    } else {
                        bArr[i] = StringUtils.getBytes(String.valueOf(i4));
                        return;
                    }
                case 4:
                    bArr[i] = StringUtils.getBytes(String.valueOf(Float.intBitsToFloat(buffer.readIntAsLong())));
                    return;
                case 5:
                    bArr[i] = StringUtils.getBytes(String.valueOf(Double.longBitsToDouble(buffer.readLongLong())));
                    return;
                case 6:
                    return;
                case 7:
                case 12:
                    int fieldLength = (int) buffer.readFieldLength();
                    if (fieldLength != 0) {
                        i2 = buffer.readInt();
                        b2 = buffer.readByte();
                        b3 = buffer.readByte();
                        if (fieldLength > 4) {
                            b = buffer.readByte();
                            b4 = buffer.readByte();
                            b5 = buffer.readByte();
                        } else {
                            b = 0;
                        }
                        if (i2 == 0 && b2 == 0 && b3 == 0) {
                            if (ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_CONVERT_TO_NULL.equals(this.connection.getZeroDateTimeBehavior())) {
                                bArr[i] = null;
                                return;
                            } else {
                                if (!ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_EXCEPTION.equals(this.connection.getZeroDateTimeBehavior())) {
                                    throw SQLError.createSQLException("Value '0000-00-00' can not be represented as java.sql.Timestamp", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                                }
                                i2 = 1;
                                b2 = 1;
                                b3 = 1;
                            }
                        }
                        byte[] bytes = StringUtils.getBytes(Integer.toString(0));
                        byte[] bArr2 = new byte[bytes.length + 1 + 19];
                        bArr2[0] = (byte) Character.forDigit(i2 / 1000, 10);
                        int i5 = i2 % 1000;
                        bArr2[1] = (byte) Character.forDigit(i5 / 100, 10);
                        int i6 = i5 % 100;
                        bArr2[2] = (byte) Character.forDigit(i6 / 10, 10);
                        bArr2[3] = (byte) Character.forDigit(i6 % 10, 10);
                        bArr2[4] = 45;
                        bArr2[5] = (byte) Character.forDigit(b2 / 10, 10);
                        bArr2[6] = (byte) Character.forDigit(b2 % 10, 10);
                        bArr2[7] = 45;
                        bArr2[8] = (byte) Character.forDigit(b3 / 10, 10);
                        bArr2[9] = (byte) Character.forDigit(b3 % 10, 10);
                        bArr2[10] = 32;
                        bArr2[11] = (byte) Character.forDigit(b / 10, 10);
                        bArr2[12] = (byte) Character.forDigit(b % 10, 10);
                        bArr2[13] = 58;
                        bArr2[14] = (byte) Character.forDigit(b4 / 10, 10);
                        bArr2[15] = (byte) Character.forDigit(b4 % 10, 10);
                        bArr2[16] = 58;
                        bArr2[17] = (byte) Character.forDigit(b5 / 10, 10);
                        bArr2[18] = (byte) Character.forDigit(b5 % 10, 10);
                        bArr2[19] = 46;
                        System.arraycopy(bytes, 0, bArr2, 20, bytes.length);
                        bArr[i] = bArr2;
                        return;
                    }
                    b = 0;
                    i2 = 0;
                    b2 = 0;
                    b3 = 0;
                    b4 = 0;
                    b5 = 0;
                    if (i2 == 0) {
                        if (ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_CONVERT_TO_NULL.equals(this.connection.getZeroDateTimeBehavior())) {
                            bArr[i] = null;
                            return;
                        } else {
                            if (!ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_EXCEPTION.equals(this.connection.getZeroDateTimeBehavior())) {
                                throw SQLError.createSQLException("Value '0000-00-00' can not be represented as java.sql.Timestamp", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                            }
                            i2 = 1;
                            b2 = 1;
                            b3 = 1;
                        }
                    }
                    byte[] bytes2 = StringUtils.getBytes(Integer.toString(0));
                    byte[] bArr3 = new byte[bytes2.length + 1 + 19];
                    bArr3[0] = (byte) Character.forDigit(i2 / 1000, 10);
                    int i7 = i2 % 1000;
                    bArr3[1] = (byte) Character.forDigit(i7 / 100, 10);
                    int i8 = i7 % 100;
                    bArr3[2] = (byte) Character.forDigit(i8 / 10, 10);
                    bArr3[3] = (byte) Character.forDigit(i8 % 10, 10);
                    bArr3[4] = 45;
                    bArr3[5] = (byte) Character.forDigit(b2 / 10, 10);
                    bArr3[6] = (byte) Character.forDigit(b2 % 10, 10);
                    bArr3[7] = 45;
                    bArr3[8] = (byte) Character.forDigit(b3 / 10, 10);
                    bArr3[9] = (byte) Character.forDigit(b3 % 10, 10);
                    bArr3[10] = 32;
                    bArr3[11] = (byte) Character.forDigit(b / 10, 10);
                    bArr3[12] = (byte) Character.forDigit(b % 10, 10);
                    bArr3[13] = 58;
                    bArr3[14] = (byte) Character.forDigit(b4 / 10, 10);
                    bArr3[15] = (byte) Character.forDigit(b4 % 10, 10);
                    bArr3[16] = 58;
                    bArr3[17] = (byte) Character.forDigit(b5 / 10, 10);
                    bArr3[18] = (byte) Character.forDigit(b5 % 10, 10);
                    bArr3[19] = 46;
                    System.arraycopy(bytes2, 0, bArr3, 20, bytes2.length);
                    bArr[i] = bArr3;
                    return;
                case 8:
                    long longLong = buffer.readLongLong();
                    if (field.isUnsigned()) {
                        bArr[i] = StringUtils.getBytes(ResultSetImpl.convertLongToUlong(longLong).toString());
                        return;
                    } else {
                        bArr[i] = StringUtils.getBytes(String.valueOf(longLong));
                        return;
                    }
                case 10:
                    if (((int) buffer.readFieldLength()) != 0) {
                        i3 = buffer.readInt();
                        b6 = buffer.readByte();
                        b7 = buffer.readByte();
                    } else {
                        i3 = 0;
                        b6 = 0;
                        b7 = 0;
                    }
                    if (i3 == 0 && b6 == 0 && b7 == 0) {
                        if (ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_CONVERT_TO_NULL.equals(this.connection.getZeroDateTimeBehavior())) {
                            bArr[i] = null;
                            return;
                        } else {
                            if (ConnectionPropertiesImpl.ZERO_DATETIME_BEHAVIOR_EXCEPTION.equals(this.connection.getZeroDateTimeBehavior())) {
                                throw SQLError.createSQLException("Value '0000-00-00' can not be represented as java.sql.Date", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                            }
                            i3 = 1;
                            b6 = 1;
                            b7 = 1;
                        }
                    }
                    int i9 = i3 % 1000;
                    int i10 = i9 % 100;
                    bArr[i] = new byte[]{(byte) Character.forDigit(i3 / 1000, 10), (byte) Character.forDigit(i9 / 100, 10), (byte) Character.forDigit(i10 / 10, 10), (byte) Character.forDigit(i10 % 10, 10), 45, (byte) Character.forDigit(b6 / 10, 10), (byte) Character.forDigit(b6 % 10, 10), 45, (byte) Character.forDigit(b7 / 10, 10), (byte) Character.forDigit(b7 % 10, 10)};
                    return;
                case 11:
                    int fieldLength2 = (int) buffer.readFieldLength();
                    if (fieldLength2 != 0) {
                        buffer.readByte();
                        buffer.readLong();
                        b8 = buffer.readByte();
                        b9 = buffer.readByte();
                        b10 = buffer.readByte();
                        if (fieldLength2 > 8) {
                            buffer.readLong();
                        }
                    } else {
                        b8 = 0;
                        b9 = 0;
                        b10 = 0;
                    }
                    bArr[i] = new byte[]{(byte) Character.forDigit(b8 / 10, 10), (byte) Character.forDigit(b8 % 10, 10), 58, (byte) Character.forDigit(b9 / 10, 10), (byte) Character.forDigit(b9 % 10, 10), 58, (byte) Character.forDigit(b10 / 10, 10), (byte) Character.forDigit(b10 % 10, 10)};
                    return;
                default:
                    switch (mysqlType) {
                        case MysqlDefs.FIELD_TYPE_TINY_BLOB /* 249 */:
                        case 250:
                        case MysqlDefs.FIELD_TYPE_LONG_BLOB /* 251 */:
                        case MysqlDefs.FIELD_TYPE_BLOB /* 252 */:
                        case MysqlDefs.FIELD_TYPE_VAR_STRING /* 253 */:
                        case MysqlDefs.FIELD_TYPE_STRING /* 254 */:
                            break;
                        default:
                            throw SQLError.createSQLException(Messages.getString("MysqlIO.97") + field.getMysqlType() + Messages.getString("MysqlIO.98") + i + Messages.getString("MysqlIO.99") + fieldArr.length + Messages.getString("MysqlIO.100"), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
                    }
                    break;
            }
        }
        bArr[i] = buffer.readLenByteArray(0);
    }

    public static boolean useBufferRowExplicit(Field[] fieldArr) {
        if (fieldArr == null) {
            return false;
        }
        for (Field field : fieldArr) {
            int sQLType = field.getSQLType();
            if (sQLType == -4 || sQLType == -1 || sQLType == 2004 || sQLType == 2005) {
                return true;
            }
        }
        return false;
    }

    public void changeUser(String str, String str2, String str3) throws SQLException {
        this.packetSequence = (byte) -1;
        this.compressedPacketSequence = (byte) -1;
        boolean z = false;
        int length = (((str != null ? str.length() : 0) + 16 + (str3 != null ? str3.length() : 0)) * 3) + 7 + 4 + 33;
        int i = this.serverCapabilities;
        if ((524288 & i) != 0) {
            proceedHandshakeWithPluggableAuthentication(str, str2, str3, null);
            return;
        }
        if ((i & 32768) != 0) {
            Buffer buffer = new Buffer(length + 1);
            buffer.writeByte((byte) 17);
            if (versionMeetsMinimum(4, 1, 1)) {
                secureAuth411(buffer, length, str, str2, str3, false, true);
                return;
            } else {
                secureAuth(buffer, length, str, str2, str3, false);
                return;
            }
        }
        Buffer buffer2 = new Buffer(length);
        buffer2.writeByte((byte) 17);
        buffer2.writeString(str);
        if (this.protocolVersion > 9) {
            buffer2.writeString(Util.newCrypt(str2, this.seed, this.connection.getPasswordCharacterEncoding()));
        } else {
            buffer2.writeString(Util.oldCrypt(str2, this.seed));
        }
        if (this.useConnectWithDb && str3 != null && str3.length() > 0) {
            z = true;
        }
        if (z) {
            buffer2.writeString(str3);
        }
        send(buffer2, buffer2.getPosition());
        checkErrorPacket();
        if (z) {
            return;
        }
        changeDatabaseTo(str3);
    }

    public Buffer checkErrorPacket() throws SQLException {
        return checkErrorPacket(-1);
    }

    public void checkForCharsetMismatch() {
        if (!this.connection.getUseUnicode() || this.connection.getEncoding() == null) {
            return;
        }
        String property = jvmPlatformCharset;
        if (property == null) {
            property = System.getProperty("file.encoding");
        }
        if (property == null) {
            this.platformDbCharsetMatches = false;
        } else {
            this.platformDbCharsetMatches = property.equals(this.connection.getEncoding());
        }
    }

    public void clearInputStream() throws SQLException {
        int iAvailable;
        do {
            try {
                iAvailable = this.mysqlInput.available();
                if (iAvailable <= 0) {
                    return;
                }
            } catch (IOException e) {
                throw SQLError.createCommunicationsException(this.connection, this.lastPacketSentTimeMs, this.lastPacketReceivedTimeMs, e, getExceptionInterceptor());
            }
        } while (this.mysqlInput.skip(iAvailable) > 0);
    }

    public void closeStreamer(RowData rowData) throws SQLException {
        RowData rowData2 = this.streamingData;
        if (rowData2 == null) {
            throw SQLError.createSQLException(Messages.getString("MysqlIO.17") + rowData + Messages.getString("MysqlIO.18"), getExceptionInterceptor());
        }
        if (rowData == rowData2) {
            this.streamingData = null;
            return;
        }
        throw SQLError.createSQLException(Messages.getString("MysqlIO.19") + rowData + Messages.getString("MysqlIO.20") + Messages.getString("MysqlIO.21") + Messages.getString("MysqlIO.22"), getExceptionInterceptor());
    }

    public void disableMultiQueries() throws SQLException {
        Buffer sharedSendPacket = getSharedSendPacket();
        sharedSendPacket.clear();
        sharedSendPacket.writeByte((byte) 27);
        sharedSendPacket.writeInt(1);
        sendCommand(27, null, sharedSendPacket, false, null, 0);
        preserveOldTransactionState();
    }

    public void doHandshake(String str, String str2, String str3) throws SQLException {
        String string;
        StringBuilder sb;
        this.checkPacketSequence = false;
        this.readPacketSequence = (byte) 0;
        Buffer packet = readPacket();
        byte b = packet.readByte();
        this.protocolVersion = b;
        if (b == -1) {
            try {
                this.mysqlConnection.close();
            } catch (Exception unused) {
            }
            int i = packet.readInt();
            String string2 = packet.readString("ASCII", getExceptionInterceptor());
            String strMysqlToSqlState = SQLError.mysqlToSqlState(i, this.connection.getUseSqlStateCodes());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(SQLError.get(strMysqlToSqlState));
            sb2.append(", ");
            sb2.append(Messages.getString("MysqlIO.10") + string2 + "\"");
            throw SQLError.createSQLException(sb2.toString(), strMysqlToSqlState, i, getExceptionInterceptor());
        }
        String string3 = packet.readString("ASCII", getExceptionInterceptor());
        this.serverVersion = string3;
        int iIndexOf = string3.indexOf(46);
        if (iIndexOf != -1) {
            try {
                this.serverMajorVersion = Integer.parseInt(this.serverVersion.substring(0, iIndexOf));
            } catch (NumberFormatException unused2) {
            }
            String str4 = this.serverVersion;
            String strSubstring = str4.substring(iIndexOf + 1, str4.length());
            int iIndexOf2 = strSubstring.indexOf(46);
            if (iIndexOf2 != -1) {
                try {
                    this.serverMinorVersion = Integer.parseInt(strSubstring.substring(0, iIndexOf2));
                } catch (NumberFormatException unused3) {
                }
                String strSubstring2 = strSubstring.substring(iIndexOf2 + 1, strSubstring.length());
                int i2 = 0;
                while (i2 < strSubstring2.length() && strSubstring2.charAt(i2) >= '0' && strSubstring2.charAt(i2) <= '9') {
                    i2++;
                }
                try {
                    this.serverSubMinorVersion = Integer.parseInt(strSubstring2.substring(0, i2));
                } catch (NumberFormatException unused4) {
                }
            }
        }
        if (versionMeetsMinimum(4, 0, 8)) {
            this.maxThreeBytes = 16777215;
            this.useNewLargePackets = true;
        } else {
            this.maxThreeBytes = 16581375;
            this.useNewLargePackets = false;
        }
        this.colDecimalNeedsBump = versionMeetsMinimum(3, 23, 0);
        this.colDecimalNeedsBump = !versionMeetsMinimum(3, 23, 15);
        this.useNewUpdateCounts = versionMeetsMinimum(3, 22, 5);
        this.threadId = packet.readLong();
        if (this.protocolVersion > 9) {
            this.seed = packet.readString("ASCII", getExceptionInterceptor(), 8);
            packet.readByte();
        } else {
            this.seed = packet.readString("ASCII", getExceptionInterceptor());
        }
        this.serverCapabilities = 0;
        if (packet.getPosition() < packet.getBufLength()) {
            this.serverCapabilities = packet.readInt();
        }
        if (versionMeetsMinimum(4, 1, 1) || (this.protocolVersion > 9 && (this.serverCapabilities & 512) != 0)) {
            this.serverCharsetIndex = packet.readByte() & StatementImpl.USES_VARIABLES_UNKNOWN;
            this.serverStatus = packet.readInt();
            checkTransactionState(0);
            int i3 = this.serverCapabilities | (packet.readInt() << 16);
            this.serverCapabilities = i3;
            if ((i3 & 524288) != 0) {
                this.authPluginDataLength = packet.readByte() & StatementImpl.USES_VARIABLES_UNKNOWN;
            } else {
                packet.readByte();
            }
            packet.setPosition(packet.getPosition() + 10);
            if ((this.serverCapabilities & 32768) != 0) {
                if (this.authPluginDataLength > 0) {
                    string = packet.readString("ASCII", getExceptionInterceptor(), this.authPluginDataLength - 8);
                    sb = new StringBuilder(this.authPluginDataLength);
                } else {
                    string = packet.readString("ASCII", getExceptionInterceptor());
                    sb = new StringBuilder(20);
                }
                sb.append(this.seed);
                sb.append(string);
                this.seed = sb.toString();
            }
        }
        if ((this.serverCapabilities & 32) != 0 && this.connection.getUseCompression()) {
            this.clientParam |= 32;
        }
        boolean z = (str3 == null || str3.length() <= 0 || this.connection.getCreateDatabaseIfNotExist()) ? false : true;
        this.useConnectWithDb = z;
        if (z) {
            this.clientParam |= 8;
        }
        if (versionMeetsMinimum(5, 7, 0) && !this.connection.getUseSSL() && !this.connection.isUseSSLExplicit()) {
            this.connection.setUseSSL(true);
            this.connection.setVerifyServerCertificate(false);
            this.connection.getLog().logWarn(Messages.getString("MysqlIO.SSLWarning"));
        }
        if ((this.serverCapabilities & 2048) == 0 && this.connection.getUseSSL()) {
            if (this.connection.getRequireSSL()) {
                this.connection.close();
                forceClose();
                throw SQLError.createSQLException(Messages.getString("MysqlIO.15"), SQLError.SQL_STATE_UNABLE_TO_CONNECT_TO_DATASOURCE, getExceptionInterceptor());
            }
            this.connection.setUseSSL(false);
        }
        if ((this.serverCapabilities & 4) != 0) {
            this.clientParam |= 4;
            this.hasLongColumnInfo = true;
        }
        if (!this.connection.getUseAffectedRows()) {
            this.clientParam |= 2;
        }
        if (this.connection.getAllowLoadLocalInfile()) {
            this.clientParam |= 128;
        }
        if (this.isInteractiveClient) {
            this.clientParam |= 1024;
        }
        int i4 = this.serverCapabilities;
        if ((16777216 & i4) != 0) {
            this.clientParam |= 16777216;
        }
        if ((i4 & 524288) != 0) {
            proceedHandshakeWithPluggableAuthentication(str, str2, str3, packet);
            return;
        }
        if (this.protocolVersion > 9) {
            this.clientParam |= 1;
        } else {
            this.clientParam &= -2;
        }
        if (versionMeetsMinimum(4, 1, 0) || (this.protocolVersion > 9 && (this.serverCapabilities & 16384) != 0)) {
            if (versionMeetsMinimum(4, 1, 1) || (this.protocolVersion > 9 && (this.serverCapabilities & 512) != 0)) {
                long j = this.clientParam | 512;
                this.clientParam = j;
                this.has41NewNewProt = true;
                long j2 = j | 8192;
                this.clientParam = j2;
                this.clientParam = j2 | 131072;
                if (this.connection.getAllowMultiQueries()) {
                    this.clientParam |= 65536;
                }
            } else {
                this.clientParam |= 16384;
                this.has41NewNewProt = false;
            }
            this.use41Extensions = true;
        }
        int length = (((str != null ? str.length() : 0) + 16 + (str3 != null ? str3.length() : 0)) * 3) + 7 + 4 + 33;
        if (this.connection.getUseSSL()) {
            negotiateSSLConnection(str, str2, str3, length);
            if ((this.serverCapabilities & 32768) == 0) {
                Buffer buffer = new Buffer(length);
                if (this.use41Extensions) {
                    buffer.writeLong(this.clientParam);
                    buffer.writeLong(this.maxThreeBytes);
                } else {
                    buffer.writeInt((int) this.clientParam);
                    buffer.writeLongInt(this.maxThreeBytes);
                }
                buffer.writeString(str);
                if (this.protocolVersion > 9) {
                    buffer.writeString(Util.newCrypt(str2, this.seed, this.connection.getPasswordCharacterEncoding()));
                } else {
                    buffer.writeString(Util.oldCrypt(str2, this.seed));
                }
                if ((this.serverCapabilities & 8) != 0 && str3 != null && str3.length() > 0) {
                    buffer.writeString(str3);
                }
                send(buffer, buffer.getPosition());
            } else if (versionMeetsMinimum(4, 1, 1)) {
                secureAuth411(null, length, str, str2, str3, true, false);
            } else {
                secureAuth411(null, length, str, str2, str3, true, false);
            }
        } else if ((this.serverCapabilities & 32768) != 0) {
            this.clientParam |= 32768;
            if (versionMeetsMinimum(4, 1, 1) || (this.protocolVersion > 9 && (this.serverCapabilities & 512) != 0)) {
                secureAuth411(null, length, str, str2, str3, true, false);
            } else {
                secureAuth(null, length, str, str2, str3, true);
            }
        } else {
            Buffer buffer2 = new Buffer(length);
            long j3 = this.clientParam;
            if ((j3 & 16384) == 0) {
                buffer2.writeInt((int) j3);
                buffer2.writeLongInt(this.maxThreeBytes);
            } else if (versionMeetsMinimum(4, 1, 1) || (this.protocolVersion > 9 && (this.serverCapabilities & 512) != 0)) {
                buffer2.writeLong(this.clientParam);
                buffer2.writeLong(this.maxThreeBytes);
                buffer2.writeByte((byte) 8);
                buffer2.writeBytesNoNull(new byte[23]);
            } else {
                buffer2.writeLong(this.clientParam);
                buffer2.writeLong(this.maxThreeBytes);
            }
            buffer2.writeString(str, CODE_PAGE_1252, this.connection);
            if (this.protocolVersion > 9) {
                buffer2.writeString(Util.newCrypt(str2, this.seed, this.connection.getPasswordCharacterEncoding()), CODE_PAGE_1252, this.connection);
            } else {
                buffer2.writeString(Util.oldCrypt(str2, this.seed), CODE_PAGE_1252, this.connection);
            }
            if (this.useConnectWithDb) {
                buffer2.writeString(str3, CODE_PAGE_1252, this.connection);
            }
            send(buffer2, buffer2.getPosition());
        }
        if (!versionMeetsMinimum(4, 1, 1) || this.protocolVersion <= 9 || (this.serverCapabilities & 512) == 0) {
            checkErrorPacket();
        }
        if ((this.serverCapabilities & 32) != 0 && this.connection.getUseCompression() && !(this.mysqlInput instanceof CompressedInputStream)) {
            this.deflater = new Deflater();
            this.useCompression = true;
            this.mysqlInput = new CompressedInputStream(this.connection, this.mysqlInput);
        }
        if (!this.useConnectWithDb) {
            changeDatabaseTo(str3);
        }
        try {
            this.mysqlConnection = this.socketFactory.afterHandshake();
        } catch (IOException e) {
            throw SQLError.createCommunicationsException(this.connection, this.lastPacketSentTimeMs, this.lastPacketReceivedTimeMs, e, getExceptionInterceptor());
        }
    }

    public void dumpPacketRingBuffer() throws SQLException {
        if (this.packetDebugRingBuffer == null || !this.connection.getEnablePacketDebug()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Last " + this.packetDebugRingBuffer.size() + " packets received from server, from oldest->newest:\n");
        sb.append("\n");
        Iterator<StringBuilder> it = this.packetDebugRingBuffer.iterator();
        while (it.hasNext()) {
            sb.append((CharSequence) it.next());
            sb.append("\n");
        }
        this.connection.getLog().logTrace(sb.toString());
    }

    public void enableMultiQueries() throws SQLException {
        Buffer sharedSendPacket = getSharedSendPacket();
        sharedSendPacket.clear();
        sharedSendPacket.writeByte((byte) 27);
        sharedSendPacket.writeInt(0);
        sendCommand(27, null, sharedSendPacket, false, null, 0);
        preserveOldTransactionState();
    }

    public void explainSlowQuery(byte[] bArr, String str) throws Throwable {
        PreparedStatement preparedStatement;
        if (StringUtils.startsWithIgnoreCaseAndWs(str, EXPLAINABLE_STATEMENT) || (versionMeetsMinimum(5, 6, 3) && StringUtils.startsWithIgnoreCaseAndWs(str, EXPLAINABLE_STATEMENT_EXTENSION) != -1)) {
            ResultSet resultSetExecuteQuery = null;
            try {
                preparedStatement = (PreparedStatement) this.connection.clientPrepareStatement("EXPLAIN ?");
                try {
                    preparedStatement.setBytesNoEscapeNoQuotes(1, bArr);
                    resultSetExecuteQuery = preparedStatement.executeQuery();
                    StringBuilder sb = new StringBuilder(Messages.getString("MysqlIO.8") + str + Messages.getString("MysqlIO.9"));
                    ResultSetUtil.appendResultSetSlashGStyle(sb, resultSetExecuteQuery);
                    this.connection.getLog().logWarn(sb.toString());
                    if (resultSetExecuteQuery != null) {
                        resultSetExecuteQuery.close();
                    }
                    if (preparedStatement == null) {
                        return;
                    }
                } catch (SQLException unused) {
                    if (resultSetExecuteQuery != null) {
                        resultSetExecuteQuery.close();
                    }
                    if (preparedStatement == null) {
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (resultSetExecuteQuery != null) {
                        resultSetExecuteQuery.close();
                    }
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    throw th;
                }
            } catch (SQLException unused2) {
                preparedStatement = null;
            } catch (Throwable th2) {
                th = th2;
                preparedStatement = null;
            }
            preparedStatement.close();
        }
    }

    public List<ResultSetRow> fetchRowsViaCursor(List<ResultSetRow> list, long j, Field[] fieldArr, int i, boolean z) throws SQLException {
        List<ResultSetRow> arrayList;
        if (list == null) {
            arrayList = new ArrayList(i);
        } else {
            list.clear();
            arrayList = list;
        }
        this.sharedSendPacket.clear();
        this.sharedSendPacket.writeByte((byte) 28);
        this.sharedSendPacket.writeLong(j);
        this.sharedSendPacket.writeLong(i);
        sendCommand(28, null, this.sharedSendPacket, true, null, 0);
        while (true) {
            ResultSetRow resultSetRowNextRow = nextRow(fieldArr, fieldArr.length, true, MysqlErrorNumbers.ER_DB_CREATE_EXISTS, false, z, false, null);
            if (resultSetRowNextRow == null) {
                return arrayList;
            }
            arrayList.add(resultSetRowNextRow);
        }
    }

    public final void forceClose() {
        try {
            getNetworkResources().forceClose();
        } finally {
            this.mysqlConnection = null;
            this.mysqlInput = null;
            this.mysqlOutput = null;
        }
    }

    public int getCommandCount() {
        return this.commandCount;
    }

    public long getCurrentTimeNanosOrMillis() {
        return this.useNanosForElapsedTime ? TimeUtil.getCurrentTimeNanosOrMillis() : System.currentTimeMillis();
    }

    public String getEncodingForHandshake() {
        String encoding = this.connection.getEncoding();
        return encoding == null ? "UTF-8" : encoding;
    }

    public ExceptionInterceptor getExceptionInterceptor() {
        return this.exceptionInterceptor;
    }

    public String getHost() {
        return this.host;
    }

    public long getLastPacketReceivedTimeMs() {
        return this.lastPacketReceivedTimeMs;
    }

    public long getLastPacketSentTimeMs() {
        return this.lastPacketSentTimeMs;
    }

    public NetworkResources getNetworkResources() {
        return new NetworkResources(this.mysqlConnection, this.mysqlInput, this.mysqlOutput);
    }

    public String getQueryTimingUnits() {
        return this.queryTimingUnits;
    }

    public ResultSetImpl getResultSet(StatementImpl statementImpl, long j, int i, int i2, int i3, boolean z, String str, boolean z2, Field[] fieldArr) throws SQLException {
        Field[] fieldArr2;
        RowData rowDataDynamic;
        if (fieldArr == null) {
            fieldArr2 = new Field[(int) j];
            for (int i4 = 0; i4 < j; i4++) {
                fieldArr2[i4] = unpackField(readPacket(), false);
            }
        } else {
            for (int i5 = 0; i5 < j; i5++) {
                skipPacket();
            }
            fieldArr2 = null;
        }
        Field[] fieldArr3 = fieldArr2;
        if (!isEOFDeprecated() || (this.connection.versionMeetsMinimum(5, 0, 2) && statementImpl != null && z2 && statementImpl.isCursorRequired())) {
            readServerStatusForResultSets(reuseAndReadPacket(this.reusablePacket));
        }
        if (this.connection.versionMeetsMinimum(5, 0, 2) && this.connection.getUseCursorFetch() && z2 && statementImpl != null && statementImpl.getFetchSize() != 0 && statementImpl.getResultSetType() == 1003) {
            ServerPreparedStatement serverPreparedStatement = (ServerPreparedStatement) statementImpl;
            boolean z3 = this.connection.versionMeetsMinimum(5, 0, 5) ? (this.serverStatus & 64) != 0 : true;
            if (z3) {
                ResultSetImpl resultSetImplBuildResultSetWithRows = buildResultSetWithRows(statementImpl, str, fieldArr3, new RowDataCursor(this, serverPreparedStatement, fieldArr3), i2, i3, z2);
                if (z3) {
                    resultSetImplBuildResultSetWithRows.setFetchSize(statementImpl.getFetchSize());
                }
                return resultSetImplBuildResultSetWithRows;
            }
        }
        if (z) {
            rowDataDynamic = new RowDataDynamic(this, (int) j, fieldArr == null ? fieldArr3 : fieldArr, z2);
            this.streamingData = rowDataDynamic;
        } else {
            rowDataDynamic = readSingleRowSet(j, i, i3, z2, fieldArr == null ? fieldArr3 : fieldArr);
        }
        return buildResultSetWithRows(statementImpl, str, fieldArr == null ? fieldArr3 : fieldArr, rowDataDynamic, i2, i3, z2);
    }

    public final int getServerMajorVersion() {
        return this.serverMajorVersion;
    }

    public final int getServerMinorVersion() {
        return this.serverMinorVersion;
    }

    public int getServerStatus() {
        return this.serverStatus;
    }

    public final int getServerSubMinorVersion() {
        return this.serverSubMinorVersion;
    }

    public String getServerVersion() {
        return this.serverVersion;
    }

    public Buffer getSharedSendPacket() {
        if (this.sharedSendPacket == null) {
            this.sharedSendPacket = new Buffer(1024);
        }
        return this.sharedSendPacket;
    }

    public long getSlowQueryThreshold() {
        return this.slowQueryThreshold;
    }

    public long getThreadId() {
        return this.threadId;
    }

    public boolean hadWarnings() {
        return this.hadWarnings;
    }

    public boolean hasLongColumnInfo() {
        return this.hasLongColumnInfo;
    }

    public boolean inTransactionOnServer() {
        return (this.serverStatus & 1) != 0;
    }

    public ResultSetInternalMethods invokeStatementInterceptorsPost(String str, Statement statement, ResultSetInternalMethods resultSetInternalMethods, boolean z, SQLException sQLException) throws SQLException {
        int size = this.statementInterceptors.size();
        ResultSetInternalMethods resultSetInternalMethods2 = resultSetInternalMethods;
        for (int i = 0; i < size; i++) {
            StatementInterceptorV2 statementInterceptorV2 = this.statementInterceptors.get(i);
            boolean zExecuteTopLevelOnly = statementInterceptorV2.executeTopLevelOnly();
            boolean z2 = true;
            if ((!zExecuteTopLevelOnly || (this.statementExecutionDepth != 1 && !z)) && zExecuteTopLevelOnly) {
                z2 = false;
            }
            if (z2) {
                ResultSetInternalMethods resultSetInternalMethodsPostProcess = statementInterceptorV2.postProcess(str, statement, resultSetInternalMethods2, this.connection, this.warningCount, this.queryNoIndexUsed, this.queryBadIndexUsed, sQLException);
                if (resultSetInternalMethodsPostProcess != null) {
                    resultSetInternalMethods2 = resultSetInternalMethodsPostProcess;
                }
            }
        }
        return resultSetInternalMethods2;
    }

    public ResultSetInternalMethods invokeStatementInterceptorsPre(String str, Statement statement, boolean z) throws SQLException {
        ResultSetInternalMethods resultSetInternalMethodsPreProcess;
        int size = this.statementInterceptors.size();
        ResultSetInternalMethods resultSetInternalMethods = null;
        for (int i = 0; i < size; i++) {
            StatementInterceptorV2 statementInterceptorV2 = this.statementInterceptors.get(i);
            boolean zExecuteTopLevelOnly = statementInterceptorV2.executeTopLevelOnly();
            boolean z2 = true;
            if ((!zExecuteTopLevelOnly || (this.statementExecutionDepth != 1 && !z)) && zExecuteTopLevelOnly) {
                z2 = false;
            }
            if (z2 && (resultSetInternalMethodsPreProcess = statementInterceptorV2.preProcess(str, statement, this.connection)) != null) {
                resultSetInternalMethods = resultSetInternalMethodsPreProcess;
            }
        }
        return resultSetInternalMethods;
    }

    public boolean isDataAvailable() throws SQLException {
        try {
            return this.mysqlInput.available() > 0;
        } catch (IOException e) {
            throw SQLError.createCommunicationsException(this.connection, this.lastPacketSentTimeMs, this.lastPacketReceivedTimeMs, e, getExceptionInterceptor());
        }
    }

    public boolean isEOFDeprecated() {
        return (this.clientParam & 16777216) != 0;
    }

    public boolean isSSLEstablished() {
        return ExportControlled.enabled() && ExportControlled.isSSLEstablished(this);
    }

    public boolean isSetNeededForAutoCommitMode(boolean z) {
        if (!this.use41Extensions || !this.connection.getElideSetAutoCommits()) {
            return true;
        }
        boolean z2 = (this.serverStatus & 2) != 0;
        if (z || !versionMeetsMinimum(5, 0, 0)) {
            return z2 != z;
        }
        return !inTransactionOnServer();
    }

    public boolean isVersion(int i, int i2, int i3) {
        return i == getServerMajorVersion() && i2 == getServerMinorVersion() && i3 == getServerSubMinorVersion();
    }

    public final ResultSetRow nextRow(Field[] fieldArr, int i, boolean z, int i2, boolean z2, boolean z3, boolean z4, Buffer buffer) throws SQLException {
        if (this.useDirectRowUnpack && buffer == null && !z && !z2 && !z3) {
            return nextRowFast(fieldArr, i, z, i2, z2, z3, z4);
        }
        if (buffer == null) {
            buffer = checkErrorPacket();
            if (!z3 && z2 && buffer.getBufLength() > this.useBufferRowSizeThreshold) {
                z3 = true;
            }
        } else {
            checkErrorPacket(buffer);
        }
        if (z) {
            if ((!isEOFDeprecated() && buffer.isEOFPacket()) || (isEOFDeprecated() && buffer.isResultSetOKPacket())) {
                buffer.setPosition(buffer.getPosition() - 1);
                readServerStatusForResultSets(buffer);
                return null;
            }
            if (i2 == 1008 || !(z2 || z3)) {
                return unpackBinaryResultSetRow(fieldArr, buffer, i2);
            }
            if (!z4) {
                this.reusablePacket = new Buffer(buffer.getBufLength());
            }
            return new BufferRow(buffer, fieldArr, true, getExceptionInterceptor());
        }
        buffer.setPosition(buffer.getPosition() - 1);
        if ((!isEOFDeprecated() && buffer.isEOFPacket()) || (isEOFDeprecated() && buffer.isResultSetOKPacket())) {
            readServerStatusForResultSets(buffer);
            return null;
        }
        if (i2 != 1008 && (z2 || z3)) {
            if (!z4) {
                this.reusablePacket = new Buffer(buffer.getBufLength());
            }
            return new BufferRow(buffer, fieldArr, false, getExceptionInterceptor());
        }
        byte[][] bArr = new byte[i][];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = buffer.readLenByteArray(0);
        }
        return new ByteArrayRow(bArr, getExceptionInterceptor());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [boolean, byte] */
    /* JADX WARN: Type inference failed for: r7v37 */
    public final ResultSetRow nextRowFast(Field[] fieldArr, int i, boolean z, int i2, boolean z2, boolean z3, boolean z4) throws SQLException {
        int i3;
        try {
            int i4 = 4;
            int i5 = 0;
            if (readFully(this.mysqlInput, this.packetHeaderBuf, 0, 4) < 4) {
                forceClose();
                throw new RuntimeException(Messages.getString("MysqlIO.43"));
            }
            byte[] bArr = this.packetHeaderBuf;
            ?? r7 = 1;
            char c = 2;
            int i6 = (bArr[0] & 255) + ((bArr[1] & 255) << 8) + ((bArr[2] & 255) << 16);
            if (i6 == this.maxThreeBytes) {
                reuseAndReadPacket(this.reusablePacket, i6);
                return nextRow(fieldArr, i, z, i2, z2, z3, z4, this.reusablePacket);
            }
            if (i6 > this.useBufferRowSizeThreshold) {
                reuseAndReadPacket(this.reusablePacket, i6);
                return nextRow(fieldArr, i, z, i2, true, true, false, this.reusablePacket);
            }
            int i7 = i6;
            int i8 = 0;
            boolean z5 = true;
            byte[][] bArr2 = null;
            while (i8 < i) {
                int i9 = this.mysqlInput.read() & 255;
                i7--;
                if (z5) {
                    if (i9 == 255) {
                        Buffer buffer = new Buffer(i6 + 4);
                        buffer.setPosition(i5);
                        buffer.writeByte(this.packetHeaderBuf[i5]);
                        buffer.writeByte(this.packetHeaderBuf[r7]);
                        buffer.writeByte(this.packetHeaderBuf[c]);
                        buffer.writeByte(r7);
                        buffer.writeByte((byte) i9);
                        readFully(this.mysqlInput, buffer.getByteBuffer(), 5, i6 - 1);
                        buffer.setPosition(i4);
                        checkErrorPacket(buffer);
                    }
                    if (i9 == 254 && i6 < 16777215) {
                        if (!this.use41Extensions) {
                            return null;
                        }
                        if (isEOFDeprecated()) {
                            int iSkipLengthEncodedInteger = (i7 - skipLengthEncodedInteger(this.mysqlInput)) - skipLengthEncodedInteger(this.mysqlInput);
                            this.oldServerStatus = this.serverStatus;
                            this.serverStatus = (this.mysqlInput.read() & 255) | ((this.mysqlInput.read() & 255) << 8);
                            checkTransactionState(this.oldServerStatus);
                            int i10 = (this.mysqlInput.read() & 255) | ((this.mysqlInput.read() & 255) << 8);
                            this.warningCount = i10;
                            i3 = (iSkipLengthEncodedInteger - 2) - 2;
                            if (i10 > 0) {
                                this.hadWarnings = r7;
                            }
                        } else {
                            int i11 = (this.mysqlInput.read() & 255) | ((this.mysqlInput.read() & 255) << 8);
                            this.warningCount = i11;
                            int i12 = i7 - 2;
                            if (i11 > 0) {
                                this.hadWarnings = r7;
                            }
                            this.oldServerStatus = this.serverStatus;
                            this.serverStatus = (this.mysqlInput.read() & 255) | ((this.mysqlInput.read() & 255) << 8);
                            checkTransactionState(this.oldServerStatus);
                            i3 = i12 - 2;
                        }
                        setServerSlowQueryFlags();
                        if (i3 <= 0) {
                            return null;
                        }
                        skipFully(this.mysqlInput, i3);
                        return null;
                    }
                    bArr2 = new byte[i][];
                    z5 = false;
                }
                switch (i9) {
                    case MysqlDefs.FIELD_TYPE_LONG_BLOB /* 251 */:
                        i9 = -1;
                        break;
                    case MysqlDefs.FIELD_TYPE_BLOB /* 252 */:
                        i9 = (this.mysqlInput.read() & 255) | ((this.mysqlInput.read() & 255) << 8);
                        i7 -= 2;
                        break;
                    case MysqlDefs.FIELD_TYPE_VAR_STRING /* 253 */:
                        i9 = (this.mysqlInput.read() & 255) | ((this.mysqlInput.read() & 255) << 8) | ((this.mysqlInput.read() & 255) << 16);
                        i7 -= 3;
                        break;
                    case MysqlDefs.FIELD_TYPE_STRING /* 254 */:
                        i9 = (int) (((long) (this.mysqlInput.read() & 255)) | (((long) (this.mysqlInput.read() & 255)) << 8) | (((long) (this.mysqlInput.read() & 255)) << 16) | (((long) (this.mysqlInput.read() & 255)) << 24) | (((long) (this.mysqlInput.read() & 255)) << 32) | (((long) (this.mysqlInput.read() & 255)) << 40) | (((long) (this.mysqlInput.read() & 255)) << 48) | (((long) (this.mysqlInput.read() & 255)) << 56));
                        i7 -= 8;
                    default:
                        break;
                }
                if (i9 == -1) {
                    bArr2[i8] = null;
                } else {
                    if (i9 == 0) {
                        bArr2[i8] = Constants.EMPTY_BYTE_ARRAY;
                    } else {
                        bArr2[i8] = new byte[i9];
                        int fully = readFully(this.mysqlInput, bArr2[i8], 0, i9);
                        if (fully != i9) {
                            throw SQLError.createCommunicationsException(this.connection, this.lastPacketSentTimeMs, this.lastPacketReceivedTimeMs, new IOException(Messages.getString("MysqlIO.43")), getExceptionInterceptor());
                        }
                        i7 -= fully;
                    }
                    i8++;
                    i4 = 4;
                    i5 = 0;
                    r7 = 1;
                    c = 2;
                }
                i8++;
                i4 = 4;
                i5 = 0;
                r7 = 1;
                c = 2;
            }
            if (i7 > 0) {
                skipFully(this.mysqlInput, i7);
            }
            return new ByteArrayRow(bArr2, getExceptionInterceptor());
        } catch (IOException e) {
            throw SQLError.createCommunicationsException(this.connection, this.lastPacketSentTimeMs, this.lastPacketReceivedTimeMs, e, getExceptionInterceptor());
        }
    }

    public final void quit() throws SQLException {
        try {
            try {
                if (!this.mysqlConnection.isClosed()) {
                    try {
                        this.mysqlConnection.shutdownInput();
                    } catch (UnsupportedOperationException unused) {
                    }
                }
            } catch (IOException e) {
                this.connection.getLog().logWarn("Caught while disconnecting...", e);
            }
            Buffer buffer = new Buffer(6);
            this.packetSequence = (byte) -1;
            this.compressedPacketSequence = (byte) -1;
            buffer.writeByte((byte) 1);
            send(buffer, buffer.getPosition());
        } finally {
            forceClose();
        }
    }

    public ResultSetImpl readAllResults(StatementImpl statementImpl, int i, int i2, int i3, boolean z, String str, Buffer buffer, boolean z2, long j, Field[] fieldArr) throws SQLException {
        buffer.setPosition(buffer.getPosition() - 1);
        ResultSetImpl resultsForQueryOrUpdate = readResultsForQueryOrUpdate(statementImpl, i, i2, i3, z, str, buffer, z2, j, fieldArr);
        boolean z3 = (this.clientParam & 131072) != 0;
        boolean z4 = (this.serverStatus & 8) != 0;
        if (z4 && z) {
            if (resultsForQueryOrUpdate.getUpdateCount() != -1) {
                tackOnMoreStreamingResults(resultsForQueryOrUpdate);
            }
            reclaimLargeReusablePacket();
            return resultsForQueryOrUpdate;
        }
        boolean z5 = z3 & z4;
        ResultSetImpl resultsForQueryOrUpdate2 = resultsForQueryOrUpdate;
        while (z5) {
            Buffer bufferCheckErrorPacket = checkErrorPacket();
            bufferCheckErrorPacket.setPosition(0);
            ResultSetImpl resultSetImpl = resultsForQueryOrUpdate2;
            resultsForQueryOrUpdate2 = readResultsForQueryOrUpdate(statementImpl, i, i2, i3, z, str, bufferCheckErrorPacket, z2, j, fieldArr);
            resultSetImpl.setNextResultSet(resultsForQueryOrUpdate2);
            z5 = (this.serverStatus & 8) != 0;
        }
        if (!z) {
            clearInputStream();
        }
        reclaimLargeReusablePacket();
        return resultsForQueryOrUpdate;
    }

    public final Buffer readPacket() throws SQLException {
        try {
            if (readFully(this.mysqlInput, this.packetHeaderBuf, 0, 4) < 4) {
                forceClose();
                throw new IOException(Messages.getString("MysqlIO.1"));
            }
            byte[] bArr = this.packetHeaderBuf;
            int i = (bArr[0] & 255) + ((bArr[1] & 255) << 8) + ((bArr[2] & 255) << 16);
            if (i > this.maxAllowedPacket) {
                throw new PacketTooBigException(i, this.maxAllowedPacket);
            }
            if (this.traceProtocol) {
                this.connection.getLog().logTrace(Messages.getString("MysqlIO.2") + i + Messages.getString("MysqlIO.3") + StringUtils.dumpAsHex(this.packetHeaderBuf, 4));
            }
            byte b = this.packetHeaderBuf[3];
            if (this.packetSequenceReset) {
                this.packetSequenceReset = false;
            } else if (this.enablePacketDebug && this.checkPacketSequence) {
                checkPacketSequencing(b);
            }
            this.readPacketSequence = b;
            byte[] bArr2 = new byte[i];
            int fully = readFully(this.mysqlInput, bArr2, 0, i);
            if (fully != i) {
                throw new IOException("Short read, expected " + i + " bytes, only read " + fully);
            }
            Buffer buffer = new Buffer(bArr2);
            if (this.traceProtocol) {
                this.connection.getLog().logTrace(Messages.getString("MysqlIO.4") + getPacketDumpToLog(buffer, i));
            }
            if (this.enablePacketDebug) {
                enqueuePacketForDebugging(false, false, 0, this.packetHeaderBuf, buffer);
            }
            if (this.connection.getMaintainTimeStats()) {
                this.lastPacketReceivedTimeMs = System.currentTimeMillis();
            }
            return buffer;
        } catch (IOException e) {
            throw SQLError.createCommunicationsException(this.connection, this.lastPacketSentTimeMs, this.lastPacketReceivedTimeMs, e, getExceptionInterceptor());
        } catch (OutOfMemoryError e2) {
            try {
                this.connection.realClose(false, false, true, e2);
            } catch (Exception unused) {
            }
            throw e2;
        }
    }

    public final ResultSetImpl readResultsForQueryOrUpdate(StatementImpl statementImpl, int i, int i2, int i3, boolean z, String str, Buffer buffer, boolean z2, long j, Field[] fieldArr) throws SQLException {
        long fieldLength = buffer.readFieldLength();
        if (fieldLength == 0) {
            return buildResultSetWithUpdates(statementImpl, buffer);
        }
        if (fieldLength != -1) {
            return getResultSet(statementImpl, fieldLength, i, i2, i3, z, str, z2, fieldArr);
        }
        String encoding = this.connection.getUseUnicode() ? this.connection.getEncoding() : null;
        String string = (!this.platformDbCharsetMatches || encoding == null) ? buffer.readString() : buffer.readString(encoding, getExceptionInterceptor());
        return sendFileToServer(statementImpl, string);
    }

    public void releaseResources() {
        Deflater deflater = this.deflater;
        if (deflater != null) {
            deflater.end();
            this.deflater = null;
        }
    }

    public void resetMaxBuf() {
        this.maxAllowedPacket = this.connection.getMaxAllowedPacket();
    }

    public void resetReadPacketSequence() {
        this.readPacketSequence = (byte) 0;
    }

    public void scanForAndThrowDataTruncation() throws Throwable {
        int i;
        if (this.streamingData == null && versionMeetsMinimum(4, 1, 0) && this.connection.getJdbcCompliantTruncation() && (i = this.warningCount) > 0) {
            SQLError.convertShowWarningsToSQLWarnings(this.connection, i, true);
            this.warningCount = i;
        }
    }

    public void secureAuth411(Buffer buffer, int i, String str, String str2, String str3, boolean z, boolean z2) throws SQLException {
        String encodingForHandshake = getEncodingForHandshake();
        if (buffer == null) {
            buffer = new Buffer(i);
        }
        if (z) {
            if (!this.use41Extensions) {
                buffer.writeInt((int) this.clientParam);
                buffer.writeLongInt(this.maxThreeBytes);
            } else if (versionMeetsMinimum(4, 1, 1)) {
                buffer.writeLong(this.clientParam);
                buffer.writeLong(this.maxThreeBytes);
                appendCharsetByteForHandshake(buffer, encodingForHandshake);
                buffer.writeBytesNoNull(new byte[23]);
            } else {
                buffer.writeLong(this.clientParam);
                buffer.writeLong(this.maxThreeBytes);
            }
        }
        if (str != null) {
            buffer.writeString(str, encodingForHandshake, this.connection);
        }
        if (str2.length() != 0) {
            buffer.writeByte((byte) 20);
            try {
                buffer.writeBytesNoNull(Security.scramble411(str2, this.seed, this.connection.getPasswordCharacterEncoding()));
            } catch (UnsupportedEncodingException unused) {
                throw SQLError.createSQLException(Messages.getString("MysqlIO.91") + Messages.getString("MysqlIO.92"), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
            } catch (NoSuchAlgorithmException unused2) {
                throw SQLError.createSQLException(Messages.getString("MysqlIO.91") + Messages.getString("MysqlIO.92"), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
            }
        } else {
            buffer.writeByte((byte) 0);
        }
        if (this.useConnectWithDb) {
            buffer.writeString(str3, encodingForHandshake, this.connection);
        } else if (z2) {
            buffer.writeByte((byte) 0);
        }
        if ((this.serverCapabilities & 1048576) != 0) {
            sendConnectionAttributes(buffer, encodingForHandshake, this.connection);
        }
        send(buffer, buffer.getPosition());
        byte b = (byte) (this.packetSequence + 1);
        this.packetSequence = b;
        if (checkErrorPacket().isAuthMethodSwitchRequestPacket()) {
            this.packetSequence = b;
            buffer.clear();
            buffer.writeString(Util.newCrypt(str2, this.seed.substring(0, 8), this.connection.getPasswordCharacterEncoding()));
            send(buffer, buffer.getPosition());
            checkErrorPacket();
        }
        if (this.useConnectWithDb) {
            return;
        }
        changeDatabaseTo(str3);
    }

    public final Buffer sendCommand(int i, String str, Buffer buffer, boolean z, String str2, int i2) throws SQLException {
        int i3;
        int iAvailable;
        this.commandCount++;
        this.enablePacketDebug = this.connection.getEnablePacketDebug();
        this.readPacketSequence = (byte) 0;
        if (i2 != 0) {
            try {
                int soTimeout = this.mysqlConnection.getSoTimeout();
                this.mysqlConnection.setSoTimeout(i2);
                i3 = soTimeout;
            } catch (SocketException e) {
                throw SQLError.createCommunicationsException(this.connection, this.lastPacketSentTimeMs, this.lastPacketReceivedTimeMs, e, getExceptionInterceptor());
            }
        } else {
            i3 = 0;
        }
        try {
            try {
                checkForOutstandingStreamingData();
                this.oldServerStatus = this.serverStatus;
                this.serverStatus = 0;
                this.hadWarnings = false;
                this.warningCount = 0;
                this.queryNoIndexUsed = false;
                this.queryBadIndexUsed = false;
                this.serverQueryWasSlow = false;
                if (this.useCompression && (iAvailable = this.mysqlInput.available()) > 0) {
                    this.mysqlInput.skip(iAvailable);
                }
                try {
                    clearInputStream();
                    if (buffer == null) {
                        int length = 8 + (str != null ? str.length() : 0) + 2;
                        if (this.sendPacket == null) {
                            this.sendPacket = new Buffer(length);
                        }
                        this.packetSequence = (byte) -1;
                        this.compressedPacketSequence = (byte) -1;
                        this.readPacketSequence = (byte) 0;
                        this.checkPacketSequence = true;
                        this.sendPacket.clear();
                        this.sendPacket.writeByte((byte) i);
                        if (i == 2 || i == 3 || i == 22) {
                            if (str2 == null) {
                                this.sendPacket.writeStringNoNull(str);
                            } else {
                                this.sendPacket.writeStringNoNull(str, str2, this.connection.getServerCharset(), this.connection.parserKnowsUnicode(), this.connection);
                            }
                        }
                        Buffer buffer2 = this.sendPacket;
                        send(buffer2, buffer2.getPosition());
                    } else {
                        this.packetSequence = (byte) -1;
                        this.compressedPacketSequence = (byte) -1;
                        send(buffer, buffer.getPosition());
                    }
                    Buffer bufferCheckErrorPacket = null;
                    if (!z) {
                        if (i == 23 || i == 26) {
                            this.readPacketSequence = (byte) 0;
                            this.packetSequenceReset = true;
                        }
                        bufferCheckErrorPacket = checkErrorPacket(i);
                    }
                    if (i2 != 0) {
                        try {
                            this.mysqlConnection.setSoTimeout(i3);
                        } catch (SocketException e2) {
                            throw SQLError.createCommunicationsException(this.connection, this.lastPacketSentTimeMs, this.lastPacketReceivedTimeMs, e2, getExceptionInterceptor());
                        }
                    }
                    return bufferCheckErrorPacket;
                } catch (SQLException e3) {
                    throw e3;
                } catch (Exception e4) {
                    throw SQLError.createCommunicationsException(this.connection, this.lastPacketSentTimeMs, this.lastPacketReceivedTimeMs, e4, getExceptionInterceptor());
                }
            } catch (IOException e5) {
                preserveOldTransactionState();
                throw SQLError.createCommunicationsException(this.connection, this.lastPacketSentTimeMs, this.lastPacketReceivedTimeMs, e5, getExceptionInterceptor());
            } catch (SQLException e6) {
                preserveOldTransactionState();
                throw e6;
            }
        } catch (Throwable th) {
            if (i2 != 0) {
                try {
                    this.mysqlConnection.setSoTimeout(i3);
                } catch (SocketException e7) {
                    throw SQLError.createCommunicationsException(this.connection, this.lastPacketSentTimeMs, this.lastPacketReceivedTimeMs, e7, getExceptionInterceptor());
                }
            }
            throw th;
        }
    }

    public void setSocketTimeout(int i) throws SQLException {
        try {
            Socket socket = this.mysqlConnection;
            if (socket != null) {
                socket.setSoTimeout(i);
            }
        } catch (SocketException e) {
            SQLException sQLExceptionCreateSQLException = SQLError.createSQLException("Invalid socket timeout value or state", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            sQLExceptionCreateSQLException.initCause(e);
            throw sQLExceptionCreateSQLException;
        }
    }

    public void setStatementInterceptors(List<StatementInterceptorV2> list) {
        if (list.isEmpty()) {
            list = null;
        }
        this.statementInterceptors = list;
    }

    public boolean shouldIntercept() {
        return this.statementInterceptors != null;
    }

    public final void skipPacket() throws SQLException {
        try {
            if (readFully(this.mysqlInput, this.packetHeaderBuf, 0, 4) < 4) {
                forceClose();
                throw new IOException(Messages.getString("MysqlIO.1"));
            }
            byte[] bArr = this.packetHeaderBuf;
            int i = (bArr[0] & StatementImpl.USES_VARIABLES_UNKNOWN) + ((bArr[1] & StatementImpl.USES_VARIABLES_UNKNOWN) << 8) + ((bArr[2] & StatementImpl.USES_VARIABLES_UNKNOWN) << 16);
            if (this.traceProtocol) {
                this.connection.getLog().logTrace(Messages.getString("MysqlIO.2") + i + Messages.getString("MysqlIO.3") + StringUtils.dumpAsHex(this.packetHeaderBuf, 4));
            }
            byte b = this.packetHeaderBuf[3];
            if (this.packetSequenceReset) {
                this.packetSequenceReset = false;
            } else if (this.enablePacketDebug && this.checkPacketSequence) {
                checkPacketSequencing(b);
            }
            this.readPacketSequence = b;
            skipFully(this.mysqlInput, i);
        } catch (IOException e) {
            throw SQLError.createCommunicationsException(this.connection, this.lastPacketSentTimeMs, this.lastPacketReceivedTimeMs, e, getExceptionInterceptor());
        } catch (OutOfMemoryError e2) {
            try {
                this.connection.realClose(false, false, true, e2);
            } catch (Exception unused) {
            }
            throw e2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:75:0x01d4 A[Catch: all -> 0x04bc, SQLException -> 0x04bf, TryCatch #1 {SQLException -> 0x04bf, blocks: (B:3:0x000e, B:5:0x0013, B:9:0x0020, B:11:0x002e, B:13:0x0035, B:15:0x0049, B:18:0x0068, B:20:0x0073, B:22:0x0091, B:24:0x0095, B:26:0x00a0, B:28:0x00a7, B:30:0x00bc, B:32:0x00c0, B:38:0x0107, B:40:0x010d, B:42:0x0113, B:44:0x0128, B:48:0x0130, B:51:0x0152, B:50:0x014c, B:52:0x0173, B:54:0x018e, B:84:0x020d, B:86:0x0235, B:88:0x0239, B:92:0x0256, B:94:0x0288, B:96:0x0291, B:100:0x02c8, B:101:0x02d5, B:103:0x02ff, B:105:0x0303, B:107:0x030d, B:109:0x0311, B:111:0x031f, B:113:0x0328, B:114:0x0360, B:116:0x0364, B:118:0x0368, B:120:0x0376, B:122:0x037f, B:123:0x03b7, B:125:0x03bb, B:127:0x03bf, B:129:0x03cd, B:131:0x03d6, B:132:0x040e, B:134:0x0412, B:136:0x0429, B:138:0x0432, B:140:0x0467, B:142:0x0470, B:143:0x0495, B:145:0x0499, B:146:0x049c, B:148:0x04a0, B:91:0x0250, B:58:0x019b, B:75:0x01d4, B:77:0x01dc, B:79:0x01e8, B:81:0x01ef, B:62:0x01a6, B:64:0x01aa, B:66:0x01b0, B:70:0x01bf, B:33:0x00d8, B:35:0x00e0, B:36:0x00ea, B:37:0x0102, B:25:0x009d), top: B:181:0x000e, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x01dc A[Catch: all -> 0x04bc, SQLException -> 0x04bf, TryCatch #1 {SQLException -> 0x04bf, blocks: (B:3:0x000e, B:5:0x0013, B:9:0x0020, B:11:0x002e, B:13:0x0035, B:15:0x0049, B:18:0x0068, B:20:0x0073, B:22:0x0091, B:24:0x0095, B:26:0x00a0, B:28:0x00a7, B:30:0x00bc, B:32:0x00c0, B:38:0x0107, B:40:0x010d, B:42:0x0113, B:44:0x0128, B:48:0x0130, B:51:0x0152, B:50:0x014c, B:52:0x0173, B:54:0x018e, B:84:0x020d, B:86:0x0235, B:88:0x0239, B:92:0x0256, B:94:0x0288, B:96:0x0291, B:100:0x02c8, B:101:0x02d5, B:103:0x02ff, B:105:0x0303, B:107:0x030d, B:109:0x0311, B:111:0x031f, B:113:0x0328, B:114:0x0360, B:116:0x0364, B:118:0x0368, B:120:0x0376, B:122:0x037f, B:123:0x03b7, B:125:0x03bb, B:127:0x03bf, B:129:0x03cd, B:131:0x03d6, B:132:0x040e, B:134:0x0412, B:136:0x0429, B:138:0x0432, B:140:0x0467, B:142:0x0470, B:143:0x0495, B:145:0x0499, B:146:0x049c, B:148:0x04a0, B:91:0x0250, B:58:0x019b, B:75:0x01d4, B:77:0x01dc, B:79:0x01e8, B:81:0x01ef, B:62:0x01a6, B:64:0x01aa, B:66:0x01b0, B:70:0x01bf, B:33:0x00d8, B:35:0x00e0, B:36:0x00ea, B:37:0x0102, B:25:0x009d), top: B:181:0x000e, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:81:0x01ef A[Catch: all -> 0x04bc, SQLException -> 0x04bf, TryCatch #1 {SQLException -> 0x04bf, blocks: (B:3:0x000e, B:5:0x0013, B:9:0x0020, B:11:0x002e, B:13:0x0035, B:15:0x0049, B:18:0x0068, B:20:0x0073, B:22:0x0091, B:24:0x0095, B:26:0x00a0, B:28:0x00a7, B:30:0x00bc, B:32:0x00c0, B:38:0x0107, B:40:0x010d, B:42:0x0113, B:44:0x0128, B:48:0x0130, B:51:0x0152, B:50:0x014c, B:52:0x0173, B:54:0x018e, B:84:0x020d, B:86:0x0235, B:88:0x0239, B:92:0x0256, B:94:0x0288, B:96:0x0291, B:100:0x02c8, B:101:0x02d5, B:103:0x02ff, B:105:0x0303, B:107:0x030d, B:109:0x0311, B:111:0x031f, B:113:0x0328, B:114:0x0360, B:116:0x0364, B:118:0x0368, B:120:0x0376, B:122:0x037f, B:123:0x03b7, B:125:0x03bb, B:127:0x03bf, B:129:0x03cd, B:131:0x03d6, B:132:0x040e, B:134:0x0412, B:136:0x0429, B:138:0x0432, B:140:0x0467, B:142:0x0470, B:143:0x0495, B:145:0x0499, B:146:0x049c, B:148:0x04a0, B:91:0x0250, B:58:0x019b, B:75:0x01d4, B:77:0x01dc, B:79:0x01e8, B:81:0x01ef, B:62:0x01a6, B:64:0x01aa, B:66:0x01b0, B:70:0x01bf, B:33:0x00d8, B:35:0x00e0, B:36:0x00ea, B:37:0x0102, B:25:0x009d), top: B:181:0x000e, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0206  */
    /* JADX WARN: Instruction removed from duplicated block: B:81:0x01ef, please report this as an issue */
    public final ResultSetInternalMethods sqlQueryDirect(StatementImpl statementImpl, String str, String str2, Buffer buffer, int i, int i2, int i3, boolean z, String str3, Field[] fieldArr) throws Exception {
        Buffer buffer2;
        byte[] byteBuffer;
        long currentTimeNanosOrMillis;
        int position;
        boolean z2;
        boolean z3;
        boolean z4;
        long j;
        long j2;
        boolean z5;
        int maxQuerySizeToLog;
        boolean z6;
        String string;
        String str4;
        ResultSetInternalMethods resultSetInternalMethodsInvokeStatementInterceptorsPost;
        String string2;
        byte[] bytes;
        String str5;
        ResultSetInternalMethods resultSetInternalMethodsInvokeStatementInterceptorsPre;
        this.statementExecutionDepth++;
        try {
            try {
                if (this.statementInterceptors != null && (resultSetInternalMethodsInvokeStatementInterceptorsPre = invokeStatementInterceptorsPre(str, statementImpl, false)) != null) {
                    this.statementExecutionDepth--;
                    return resultSetInternalMethodsInvokeStatementInterceptorsPre;
                }
                String statementComment = this.connection.getStatementComment();
                if (this.connection.getIncludeThreadNamesAsStatementComment()) {
                    StringBuilder sb = new StringBuilder();
                    if (statementComment != null) {
                        str5 = statementComment + ", ";
                    } else {
                        str5 = BuildConfig.FLAVOR;
                    }
                    sb.append(str5);
                    sb.append("java thread: ");
                    sb.append(Thread.currentThread().getName());
                    statementComment = sb.toString();
                }
                String str6 = statementComment;
                String str7 = null;
                if (str != null) {
                    int length = (str.length() * 3) + 5 + 2;
                    if (str6 != null) {
                        bytes = StringUtils.getBytes(str6, (SingleByteCharsetConverter) null, str2, this.connection.getServerCharset(), this.connection.parserKnowsUnicode(), getExceptionInterceptor());
                        length = length + bytes.length + 6;
                    } else {
                        bytes = null;
                    }
                    Buffer buffer3 = this.sendPacket;
                    if (buffer3 == null) {
                        this.sendPacket = new Buffer(length);
                    } else {
                        buffer3.clear();
                    }
                    this.sendPacket.writeByte((byte) 3);
                    if (bytes != null) {
                        this.sendPacket.writeBytesNoNull(Constants.SLASH_STAR_SPACE_AS_BYTES);
                        this.sendPacket.writeBytesNoNull(bytes);
                        this.sendPacket.writeBytesNoNull(Constants.SPACE_STAR_SLASH_SPACE_AS_BYTES);
                    }
                    if (str2 == null) {
                        this.sendPacket.writeStringNoNull(str);
                    } else if (!this.platformDbCharsetMatches && StringUtils.startsWithIgnoreCaseAndWs(str, "LOAD DATA")) {
                        this.sendPacket.writeBytesNoNull(StringUtils.getBytes(str));
                    } else {
                        this.sendPacket.writeStringNoNull(str, str2, this.connection.getServerCharset(), this.connection.parserKnowsUnicode(), this.connection);
                    }
                    buffer2 = this.sendPacket;
                } else {
                    buffer2 = buffer;
                }
                if (this.needToGrabQueryFromPacket) {
                    byteBuffer = buffer2.getByteBuffer();
                    position = buffer2.getPosition();
                    currentTimeNanosOrMillis = getCurrentTimeNanosOrMillis();
                } else {
                    byteBuffer = null;
                    currentTimeNanosOrMillis = 0;
                    position = 0;
                }
                if (this.autoGenerateTestcaseScript) {
                    if (str == null) {
                        string2 = StringUtils.toString(byteBuffer, 5, position - 5);
                    } else if (str6 != null) {
                        string2 = "/* " + str6 + " */ " + str;
                    } else {
                        string2 = str;
                    }
                    StringBuilder sb2 = new StringBuilder(string2.length() + 32);
                    this.connection.generateConnectionCommentBlock(sb2);
                    sb2.append(string2);
                    sb2.append(';');
                    this.connection.dumpTestcaseQuery(sb2.toString());
                }
                int i4 = position;
                byte[] bArr = byteBuffer;
                Buffer buffer4 = buffer2;
                Buffer bufferSendCommand = sendCommand(3, null, buffer2, false, null, 0);
                if (this.profileSql || this.logSlowQueries) {
                    long currentTimeNanosOrMillis2 = getCurrentTimeNanosOrMillis();
                    if (this.profileSql) {
                        z2 = true;
                    } else {
                        if (this.logSlowQueries) {
                            long j3 = currentTimeNanosOrMillis2 - currentTimeNanosOrMillis;
                            if (this.useAutoSlowLog) {
                                boolean zIsAbonormallyLongQuery = this.connection.isAbonormallyLongQuery(j3);
                                this.connection.reportQueryTime(j3);
                                z3 = zIsAbonormallyLongQuery;
                            } else {
                                z3 = j3 > ((long) this.connection.getSlowQueryThresholdMillis());
                            }
                            if (z3) {
                                z2 = true;
                                z4 = true;
                            }
                            if (z2) {
                                if (i4 > this.connection.getMaxQuerySizeToLog()) {
                                    maxQuerySizeToLog = this.connection.getMaxQuerySizeToLog() + 5;
                                    z6 = true;
                                } else {
                                    maxQuerySizeToLog = i4;
                                    z6 = false;
                                }
                                string = StringUtils.toString(bArr, 5, maxQuerySizeToLog - 5);
                                if (z6) {
                                    str7 = string + Messages.getString("MysqlIO.25");
                                } else {
                                    str7 = string;
                                }
                            }
                            j = currentTimeNanosOrMillis2;
                            j2 = j;
                            z5 = z4;
                        }
                        z2 = false;
                    }
                    z4 = false;
                    if (z2) {
                        if (i4 > this.connection.getMaxQuerySizeToLog()) {
                            maxQuerySizeToLog = this.connection.getMaxQuerySizeToLog() + 5;
                            z6 = true;
                        } else {
                            maxQuerySizeToLog = i4;
                            z6 = false;
                        }
                        string = StringUtils.toString(bArr, 5, maxQuerySizeToLog - 5);
                        if (z6) {
                            str7 = string + Messages.getString("MysqlIO.25");
                        } else {
                            str7 = string;
                        }
                    }
                    j = currentTimeNanosOrMillis2;
                    j2 = j;
                    z5 = z4;
                } else {
                    j = 0;
                    j2 = 0;
                    z5 = false;
                }
                String str8 = str7;
                ResultSetImpl allResults = readAllResults(statementImpl, i, i2, i3, z, str3, bufferSendCommand, false, -1L, fieldArr);
                if (!z5 || this.serverQueryWasSlow) {
                    str4 = str8;
                } else {
                    StringBuilder sb3 = new StringBuilder(str8.length() + 48);
                    Object[] objArr = new Object[3];
                    objArr[0] = String.valueOf(this.useAutoSlowLog ? " 95% of all queries " : Long.valueOf(this.slowQueryThreshold));
                    objArr[1] = this.queryTimingUnits;
                    long j4 = j - currentTimeNanosOrMillis;
                    objArr[2] = Long.valueOf(j4);
                    sb3.append(Messages.getString("MysqlIO.SlowQuery", objArr));
                    str4 = str8;
                    sb3.append(str4);
                    ProfilerEventHandlerFactory.getInstance(this.connection).consumeEvent(new ProfilerEvent((byte) 6, BuildConfig.FLAVOR, str3, this.connection.getId(), statementImpl != null ? statementImpl.getId() : 999, allResults.resultId, System.currentTimeMillis(), (int) j4, this.queryTimingUnits, null, LogUtils.findCallingClassAndMethod(new Throwable()), sb3.toString()));
                    if (this.connection.getExplainSlowQueries()) {
                        if (i4 < 1048576) {
                            explainSlowQuery(buffer4.getBytes(5, i4 - 5), str4);
                        } else {
                            this.connection.getLog().logWarn(Messages.getString("MysqlIO.28") + 1048576 + Messages.getString("MysqlIO.29"));
                        }
                    }
                }
                if (this.logSlowQueries) {
                    ProfilerEventHandler profilerEventHandlerFactory = ProfilerEventHandlerFactory.getInstance(this.connection);
                    if (this.queryBadIndexUsed && this.profileSql) {
                        long id = this.connection.getId();
                        int id2 = statementImpl != null ? statementImpl.getId() : 999;
                        profilerEventHandlerFactory.consumeEvent(new ProfilerEvent((byte) 6, BuildConfig.FLAVOR, str3, id, id2, allResults.resultId, System.currentTimeMillis(), j - currentTimeNanosOrMillis, this.queryTimingUnits, null, LogUtils.findCallingClassAndMethod(new Throwable()), Messages.getString("MysqlIO.33") + str4));
                    }
                    if (this.queryNoIndexUsed && this.profileSql) {
                        long id3 = this.connection.getId();
                        int id4 = statementImpl != null ? statementImpl.getId() : 999;
                        profilerEventHandlerFactory.consumeEvent(new ProfilerEvent((byte) 6, BuildConfig.FLAVOR, str3, id3, id4, allResults.resultId, System.currentTimeMillis(), j - currentTimeNanosOrMillis, this.queryTimingUnits, null, LogUtils.findCallingClassAndMethod(new Throwable()), Messages.getString("MysqlIO.35") + str4));
                    }
                    if (this.serverQueryWasSlow && this.profileSql) {
                        long id5 = this.connection.getId();
                        int id6 = statementImpl != null ? statementImpl.getId() : 999;
                        profilerEventHandlerFactory.consumeEvent(new ProfilerEvent((byte) 6, BuildConfig.FLAVOR, str3, id5, id6, allResults.resultId, System.currentTimeMillis(), j - currentTimeNanosOrMillis, this.queryTimingUnits, null, LogUtils.findCallingClassAndMethod(new Throwable()), Messages.getString("MysqlIO.ServerSlowQuery") + str4));
                    }
                }
                if (this.profileSql) {
                    long currentTimeNanosOrMillis3 = getCurrentTimeNanosOrMillis();
                    ProfilerEventHandler profilerEventHandlerFactory2 = ProfilerEventHandlerFactory.getInstance(this.connection);
                    profilerEventHandlerFactory2.consumeEvent(new ProfilerEvent((byte) 3, BuildConfig.FLAVOR, str3, this.connection.getId(), statementImpl != null ? statementImpl.getId() : 999, allResults.resultId, System.currentTimeMillis(), j - currentTimeNanosOrMillis, this.queryTimingUnits, null, LogUtils.findCallingClassAndMethod(new Throwable()), str4));
                    profilerEventHandlerFactory2.consumeEvent(new ProfilerEvent((byte) 5, BuildConfig.FLAVOR, str3, this.connection.getId(), statementImpl != null ? statementImpl.getId() : 999, allResults.resultId, System.currentTimeMillis(), currentTimeNanosOrMillis3 - j2, this.queryTimingUnits, null, LogUtils.findCallingClassAndMethod(new Throwable()), null));
                }
                if (this.hadWarnings) {
                    scanForAndThrowDataTruncation();
                }
                ResultSetInternalMethods resultSetInternalMethods = allResults;
                if (this.statementInterceptors != null && (resultSetInternalMethodsInvokeStatementInterceptorsPost = invokeStatementInterceptorsPost(str, statementImpl, allResults, false, null)) != null) {
                    resultSetInternalMethods = allResults;
                    resultSetInternalMethods = resultSetInternalMethodsInvokeStatementInterceptorsPost;
                }
                resultSetInternalMethods = allResults;
                this.statementExecutionDepth--;
                return resultSetInternalMethods;
            } catch (SQLException e) {
                if (this.statementInterceptors != null) {
                    invokeStatementInterceptorsPost(str, statementImpl, null, false, e);
                }
                if (statementImpl == null) {
                    throw e;
                }
                synchronized (statementImpl.cancelTimeoutMutex) {
                    if (!statementImpl.wasCancelled) {
                        throw e;
                    }
                    Throwable mySQLTimeoutException = statementImpl.wasCancelledByTimeout ? new MySQLTimeoutException() : new MySQLStatementCancelledException();
                    statementImpl.resetCancelledState();
                    throw mySQLTimeoutException;
                }
            }
        } catch (Throwable th) {
            this.statementExecutionDepth--;
            throw th;
        }
        this.statementExecutionDepth--;
        throw th;
    }

    public boolean tackOnMoreStreamingResults(ResultSetImpl resultSetImpl) throws SQLException {
        if ((this.serverStatus & 8) == 0) {
            return false;
        }
        ResultSetImpl resultSetImpl2 = resultSetImpl;
        boolean z = true;
        for (boolean z2 = true; z && (z2 || !resultSetImpl2.reallyResult()); z2 = false) {
            Buffer bufferCheckErrorPacket = checkErrorPacket();
            bufferCheckErrorPacket.setPosition(0);
            java.sql.Statement statement = resultSetImpl.getStatement();
            ResultSetImpl resultsForQueryOrUpdate = readResultsForQueryOrUpdate((StatementImpl) statement, statement.getMaxRows(), statement.getResultSetType(), statement.getResultSetConcurrency(), true, statement.getConnection().getCatalog(), bufferCheckErrorPacket, resultSetImpl.isBinaryEncoded, -1L, null);
            resultSetImpl2.setNextResultSet(resultsForQueryOrUpdate);
            z = (this.serverStatus & 8) != 0;
            if (!resultsForQueryOrUpdate.reallyResult() && !z) {
                return false;
            }
            resultSetImpl2 = resultsForQueryOrUpdate;
        }
        return true;
    }

    public final Field unpackField(Buffer buffer, boolean z) throws SQLException {
        int position;
        int iFastSkipLenString;
        if (!this.use41Extensions) {
            int position2 = buffer.getPosition() + 1;
            int iFastSkipLenString2 = buffer.fastSkipLenString();
            int iAdjustStartForFieldLength = adjustStartForFieldLength(position2, iFastSkipLenString2);
            int position3 = buffer.getPosition() + 1;
            int iFastSkipLenString3 = buffer.fastSkipLenString();
            int iAdjustStartForFieldLength2 = adjustStartForFieldLength(position3, iFastSkipLenString3);
            int i = buffer.readnBytes();
            int i2 = buffer.readnBytes();
            buffer.readByte();
            short s = (short) (this.hasLongColumnInfo ? buffer.readInt() : buffer.readByte() & StatementImpl.USES_VARIABLES_UNKNOWN);
            int i3 = buffer.readByte() & StatementImpl.USES_VARIABLES_UNKNOWN;
            if (this.colDecimalNeedsBump) {
                i3++;
            }
            return new Field(this.connection, buffer.getByteBuffer(), iAdjustStartForFieldLength2, iFastSkipLenString3, iAdjustStartForFieldLength, iFastSkipLenString2, i, i2, s, i3);
        }
        if (this.has41NewNewProt) {
            adjustStartForFieldLength(buffer.getPosition() + 1, buffer.fastSkipLenString());
        }
        int position4 = buffer.getPosition() + 1;
        int iFastSkipLenString4 = buffer.fastSkipLenString();
        int iAdjustStartForFieldLength3 = adjustStartForFieldLength(position4, iFastSkipLenString4);
        int position5 = buffer.getPosition() + 1;
        int iFastSkipLenString5 = buffer.fastSkipLenString();
        int iAdjustStartForFieldLength4 = adjustStartForFieldLength(position5, iFastSkipLenString5);
        int position6 = buffer.getPosition() + 1;
        int iFastSkipLenString6 = buffer.fastSkipLenString();
        int iAdjustStartForFieldLength5 = adjustStartForFieldLength(position6, iFastSkipLenString6);
        int position7 = buffer.getPosition() + 1;
        int iFastSkipLenString7 = buffer.fastSkipLenString();
        int iAdjustStartForFieldLength6 = adjustStartForFieldLength(position7, iFastSkipLenString7);
        int position8 = buffer.getPosition() + 1;
        int iFastSkipLenString8 = buffer.fastSkipLenString();
        int iAdjustStartForFieldLength7 = adjustStartForFieldLength(position8, iFastSkipLenString8);
        buffer.readByte();
        short s2 = (short) buffer.readInt();
        long j = this.has41NewNewProt ? buffer.readLong() : buffer.readLongInt();
        int i4 = buffer.readByte() & StatementImpl.USES_VARIABLES_UNKNOWN;
        short s3 = (short) (this.hasLongColumnInfo ? buffer.readInt() : buffer.readByte() & StatementImpl.USES_VARIABLES_UNKNOWN);
        int i5 = buffer.readByte() & StatementImpl.USES_VARIABLES_UNKNOWN;
        if (z) {
            position = buffer.getPosition() + 1;
            iFastSkipLenString = buffer.fastSkipLenString();
        } else {
            position = -1;
            iFastSkipLenString = -1;
        }
        return new Field(this.connection, buffer.getByteBuffer(), iAdjustStartForFieldLength3, iFastSkipLenString4, iAdjustStartForFieldLength4, iFastSkipLenString5, iAdjustStartForFieldLength5, iFastSkipLenString6, iAdjustStartForFieldLength6, iFastSkipLenString7, iAdjustStartForFieldLength7, iFastSkipLenString8, j, i4, s3, i5, position, iFastSkipLenString, s2);
    }

    public boolean useNanosForElapsedTime() {
        return this.useNanosForElapsedTime;
    }

    public boolean versionMeetsMinimum(int i, int i2, int i3) {
        if (getServerMajorVersion() < i) {
            return false;
        }
        if (getServerMajorVersion() != i) {
            return true;
        }
        if (getServerMinorVersion() >= i2) {
            return getServerMinorVersion() != i2 || getServerSubMinorVersion() >= i3;
        }
        return false;
    }

    private Buffer checkErrorPacket(int i) throws SQLException {
        this.serverStatus = 0;
        try {
            Buffer bufferReuseAndReadPacket = reuseAndReadPacket(this.reusablePacket);
            checkErrorPacket(bufferReuseAndReadPacket);
            return bufferReuseAndReadPacket;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e2) {
            throw SQLError.createCommunicationsException(this.connection, this.lastPacketSentTimeMs, this.lastPacketReceivedTimeMs, e2, getExceptionInterceptor());
        }
    }

    private final Buffer reuseAndReadPacket(Buffer buffer, int i) throws SQLException {
        boolean z;
        try {
            buffer.setWasMultiPacket(false);
            if (i == -1) {
                if (readFully(this.mysqlInput, this.packetHeaderBuf, 0, 4) < 4) {
                    forceClose();
                    throw new IOException(Messages.getString("MysqlIO.43"));
                }
                byte[] bArr = this.packetHeaderBuf;
                i = ((bArr[2] & StatementImpl.USES_VARIABLES_UNKNOWN) << 16) + (bArr[0] & StatementImpl.USES_VARIABLES_UNKNOWN) + ((bArr[1] & StatementImpl.USES_VARIABLES_UNKNOWN) << 8);
            }
            if (this.traceProtocol) {
                this.connection.getLog().logTrace(Messages.getString("MysqlIO.44") + i + Messages.getString("MysqlIO.45") + StringUtils.dumpAsHex(this.packetHeaderBuf, 4));
            }
            byte b = this.packetHeaderBuf[3];
            if (this.packetSequenceReset) {
                this.packetSequenceReset = false;
            } else if (this.enablePacketDebug && this.checkPacketSequence) {
                checkPacketSequencing(b);
            }
            this.readPacketSequence = b;
            buffer.setPosition(0);
            if (buffer.getByteBuffer().length <= i) {
                buffer.setByteBuffer(new byte[i + 1]);
            }
            buffer.setBufLength(i);
            int fully = readFully(this.mysqlInput, buffer.getByteBuffer(), 0, i);
            if (fully != i) {
                throw new IOException("Short read, expected " + i + " bytes, only read " + fully);
            }
            if (this.traceProtocol) {
                this.connection.getLog().logTrace(Messages.getString("MysqlIO.46") + getPacketDumpToLog(buffer, i));
            }
            if (this.enablePacketDebug) {
                enqueuePacketForDebugging(false, true, 0, this.packetHeaderBuf, buffer);
            }
            int i2 = this.maxThreeBytes;
            if (i == i2) {
                buffer.setPosition(i2);
                i = readRemainingMultiPackets(buffer, b);
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                buffer.getByteBuffer()[i] = 0;
            }
            if (this.connection.getMaintainTimeStats()) {
                this.lastPacketReceivedTimeMs = System.currentTimeMillis();
            }
            return buffer;
        } catch (IOException e) {
            throw SQLError.createCommunicationsException(this.connection, this.lastPacketSentTimeMs, this.lastPacketReceivedTimeMs, e, getExceptionInterceptor());
        } catch (OutOfMemoryError e2) {
            try {
                clearInputStream();
            } catch (Exception unused) {
            }
            try {
                this.connection.realClose(false, false, true, e2);
                throw e2;
            } catch (Exception unused2) {
                throw e2;
            }
        }
    }

    private void checkErrorPacket(Buffer buffer) throws SQLException {
        String strMysqlToSqlState;
        if (buffer.readByte() == -1) {
            if (this.protocolVersion > 9) {
                int i = buffer.readInt();
                String string = buffer.readString(this.connection.getErrorMessageEncoding(), getExceptionInterceptor());
                if (string.charAt(0) == '#' && string.length() > 6) {
                    strMysqlToSqlState = string.substring(1, 6);
                    string = string.substring(6);
                    if (strMysqlToSqlState.equals(SQLError.SQL_STATE_CLI_SPECIFIC_CONDITION)) {
                        strMysqlToSqlState = SQLError.mysqlToSqlState(i, this.connection.getUseSqlStateCodes());
                    }
                } else {
                    strMysqlToSqlState = SQLError.mysqlToSqlState(i, this.connection.getUseSqlStateCodes());
                }
                String str = strMysqlToSqlState;
                clearInputStream();
                StringBuilder sb = new StringBuilder();
                String str2 = SQLError.get(str);
                if (!this.connection.getUseOnlyServerErrorMessages() && str2 != null) {
                    sb.append(str2);
                    sb.append(Messages.getString("MysqlIO.68"));
                }
                sb.append(string);
                if (!this.connection.getUseOnlyServerErrorMessages() && str2 != null) {
                    sb.append("\"");
                }
                appendDeadlockStatusInformation(str, sb);
                if (str != null && str.startsWith("22")) {
                    throw new MysqlDataTruncation(sb.toString(), 0, true, false, 0, 0, i);
                }
                throw SQLError.createSQLException(sb.toString(), str, i, false, getExceptionInterceptor(), this.connection);
            }
            String string2 = buffer.readString(this.connection.getErrorMessageEncoding(), getExceptionInterceptor());
            clearInputStream();
            if (string2.indexOf(Messages.getString("MysqlIO.70")) != -1) {
                throw SQLError.createSQLException(SQLError.get(SQLError.SQL_STATE_COLUMN_NOT_FOUND) + ", " + string2, SQLError.SQL_STATE_COLUMN_NOT_FOUND, -1, false, getExceptionInterceptor(), this.connection);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(SQLError.get(SQLError.SQL_STATE_GENERAL_ERROR));
            sb2.append(", ");
            sb2.append(Messages.getString("MysqlIO.72") + string2 + "\"");
            throw SQLError.createSQLException(sb2.toString(), SQLError.SQL_STATE_GENERAL_ERROR, -1, false, getExceptionInterceptor(), this.connection);
        }
    }
}
