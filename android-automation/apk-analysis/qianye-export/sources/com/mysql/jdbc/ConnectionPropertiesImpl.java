package com.mysql.jdbc;

import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.log.Log;
import com.mysql.jdbc.log.StandardLogger;
import com.p000nx.assist.log.standout.ConsoleWindow;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.StringRefAddr;
import okhttp3.internal.http2.Settings;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes.dex */
public class ConnectionPropertiesImpl implements Serializable, ConnectionProperties {
    private static final String CONNECTION_AND_AUTH_CATEGORY;
    private static final String DEBUGING_PROFILING_CATEGORY;
    private static final String HA_CATEGORY;
    private static final String MISC_CATEGORY;
    private static final String NETWORK_CATEGORY;
    private static final String PERFORMANCE_CATEGORY;
    private static final String[] PROPERTY_CATEGORIES;
    private static final ArrayList<java.lang.reflect.Field> PROPERTY_LIST;
    private static final String SECURITY_CATEGORY;
    private static final String STANDARD_LOGGER_NAME;
    public static final String ZERO_DATETIME_BEHAVIOR_CONVERT_TO_NULL = "convertToNull";
    public static final String ZERO_DATETIME_BEHAVIOR_EXCEPTION = "exception";
    public static final String ZERO_DATETIME_BEHAVIOR_ROUND = "round";
    private static final long serialVersionUID = 4257801713007640580L;
    private BooleanConnectionProperty allowLoadLocalInfile;
    private BooleanConnectionProperty allowMasterDownConnections;
    private BooleanConnectionProperty allowMultiQueries;
    private BooleanConnectionProperty allowNanAndInf;
    private BooleanConnectionProperty allowPublicKeyRetrieval;
    private BooleanConnectionProperty allowSlaveDownConnections;
    private BooleanConnectionProperty allowUrlInLocalInfile;
    private BooleanConnectionProperty alwaysSendSetIsolation;
    private StringConnectionProperty authenticationPlugins;
    private BooleanConnectionProperty autoClosePStmtStreams;
    private BooleanConnectionProperty autoDeserialize;
    private BooleanConnectionProperty autoGenerateTestcaseScript;
    private boolean autoGenerateTestcaseScriptAsBoolean;
    private BooleanConnectionProperty autoReconnect;
    private BooleanConnectionProperty autoReconnectForPools;
    private boolean autoReconnectForPoolsAsBoolean;
    private BooleanConnectionProperty autoSlowLog;
    private MemorySizeConnectionProperty blobSendChunkSize;
    private BooleanConnectionProperty blobsAreStrings;
    private BooleanConnectionProperty cacheCallableStatements;
    private BooleanConnectionProperty cacheDefaultTimezone;
    private BooleanConnectionProperty cachePreparedStatements;
    private boolean cacheResultSetMetaDataAsBoolean;
    private BooleanConnectionProperty cacheResultSetMetadata;
    private BooleanConnectionProperty cacheServerConfiguration;
    private IntegerConnectionProperty callableStatementCacheSize;
    private BooleanConnectionProperty capitalizeTypeNames;
    private StringConnectionProperty characterEncoding;
    private String characterEncodingAsString;
    public boolean characterEncodingIsAliasForSjis;
    private StringConnectionProperty characterSetResults;
    private StringConnectionProperty clientCertificateKeyStorePassword;
    private StringConnectionProperty clientCertificateKeyStoreType;
    private StringConnectionProperty clientCertificateKeyStoreUrl;
    private StringConnectionProperty clientInfoProvider;
    private StringConnectionProperty clobCharacterEncoding;
    private BooleanConnectionProperty clobberStreamingResults;
    private BooleanConnectionProperty compensateOnDuplicateKeyUpdateCounts;
    private IntegerConnectionProperty connectTimeout;
    private StringConnectionProperty connectionAttributes;
    private StringConnectionProperty connectionCollation;
    private StringConnectionProperty connectionLifecycleInterceptors;
    private BooleanConnectionProperty continueBatchOnError;
    private BooleanConnectionProperty createDatabaseIfNotExist;
    private StringConnectionProperty defaultAuthenticationPlugin;
    private IntegerConnectionProperty defaultFetchSize;
    private BooleanConnectionProperty detectCustomCollations;
    private BooleanConnectionProperty detectServerPreparedStmts;
    private StringConnectionProperty disabledAuthenticationPlugins;
    private BooleanConnectionProperty disconnectOnExpiredPasswords;
    private BooleanConnectionProperty dontCheckOnDuplicateKeyUpdateInSQL;
    private BooleanConnectionProperty dontTrackOpenResources;
    private BooleanConnectionProperty dumpMetadataOnColumnNotFound;
    private BooleanConnectionProperty dumpQueriesOnException;
    private BooleanConnectionProperty dynamicCalendars;
    private BooleanConnectionProperty elideSetAutoCommits;
    private BooleanConnectionProperty emptyStringsConvertToZero;
    private BooleanConnectionProperty emulateLocators;
    private BooleanConnectionProperty emulateUnsupportedPstmts;
    private BooleanConnectionProperty enableEscapeProcessing;
    private BooleanConnectionProperty enablePacketDebug;
    private BooleanConnectionProperty enableQueryTimeouts;
    private StringConnectionProperty enabledSSLCipherSuites;
    private StringConnectionProperty enabledTLSProtocols;
    private StringConnectionProperty exceptionInterceptors;
    private BooleanConnectionProperty explainSlowQueries;
    private BooleanConnectionProperty failOverReadOnly;
    private BooleanConnectionProperty functionsNeverReturnBlobs;
    private BooleanConnectionProperty gatherPerformanceMetrics;
    private BooleanConnectionProperty generateSimpleParameterMetadata;
    private BooleanConnectionProperty getProceduresReturnsFunctions;
    private boolean highAvailabilityAsBoolean;
    private BooleanConnectionProperty holdResultsOpenOverStatementClose;
    private BooleanConnectionProperty ignoreNonTxTables;
    private BooleanConnectionProperty includeInnodbStatusInDeadlockExceptions;
    private BooleanConnectionProperty includeThreadDumpInDeadlockExceptions;
    private BooleanConnectionProperty includeThreadNamesAsStatementComment;
    private IntegerConnectionProperty initialTimeout;
    private BooleanConnectionProperty isInteractiveClient;
    private BooleanConnectionProperty jdbcCompliantTruncation;
    private boolean jdbcCompliantTruncationForReads;
    public MemorySizeConnectionProperty largeRowSizeThreshold;
    private StringConnectionProperty loadBalanceAutoCommitStatementRegex;
    private IntegerConnectionProperty loadBalanceAutoCommitStatementThreshold;
    private IntegerConnectionProperty loadBalanceBlacklistTimeout;
    private StringConnectionProperty loadBalanceConnectionGroup;
    private BooleanConnectionProperty loadBalanceEnableJMX;
    private StringConnectionProperty loadBalanceExceptionChecker;
    private IntegerConnectionProperty loadBalanceHostRemovalGracePeriod;
    private IntegerConnectionProperty loadBalancePingTimeout;
    private StringConnectionProperty loadBalanceSQLExceptionSubclassFailover;
    private StringConnectionProperty loadBalanceSQLStateFailover;
    private StringConnectionProperty loadBalanceStrategy;
    private BooleanConnectionProperty loadBalanceValidateConnectionOnSwapServer;
    private StringConnectionProperty localSocketAddress;
    private MemorySizeConnectionProperty locatorFetchBufferSize;
    private BooleanConnectionProperty logSlowQueries;
    private BooleanConnectionProperty logXaCommands;
    private StringConnectionProperty loggerClassName;
    private BooleanConnectionProperty maintainTimeStats;
    private boolean maintainTimeStatsAsBoolean;
    private IntegerConnectionProperty maxAllowedPacket;
    private IntegerConnectionProperty maxQuerySizeToLog;
    private IntegerConnectionProperty maxReconnects;
    private IntegerConnectionProperty maxRows;
    private int maxRowsAsInt;
    private IntegerConnectionProperty metadataCacheSize;
    private IntegerConnectionProperty netTimeoutForStreamingResults;
    private BooleanConnectionProperty noAccessToProcedureBodies;
    private BooleanConnectionProperty noDatetimeStringSync;
    private BooleanConnectionProperty noTimezoneConversionForDateType;
    private BooleanConnectionProperty noTimezoneConversionForTimeType;
    private BooleanConnectionProperty nullCatalogMeansCurrent;
    private BooleanConnectionProperty nullNamePatternMatchesAll;
    private BooleanConnectionProperty overrideSupportsIntegrityEnhancementFacility;
    private IntegerConnectionProperty packetDebugBufferSize;
    private BooleanConnectionProperty padCharsWithSpace;
    private BooleanConnectionProperty paranoid;
    private StringConnectionProperty parseInfoCacheFactory;
    private StringConnectionProperty passwordCharacterEncoding;
    private BooleanConnectionProperty pedantic;
    private BooleanConnectionProperty pinGlobalTxToPhysicalConnection;
    private BooleanConnectionProperty populateInsertRowWithDefaultValues;
    private IntegerConnectionProperty preparedStatementCacheSize;
    private IntegerConnectionProperty preparedStatementCacheSqlLimit;
    private BooleanConnectionProperty processEscapeCodesForPrepStmts;
    private BooleanConnectionProperty profileSQL;
    private boolean profileSQLAsBoolean;
    private StringConnectionProperty profileSql;
    private StringConnectionProperty profilerEventHandler;
    private StringConnectionProperty propertiesTransform;
    private IntegerConnectionProperty queriesBeforeRetryMaster;
    private BooleanConnectionProperty queryTimeoutKillsConnection;
    private BooleanConnectionProperty readFromMasterWhenNoSlaves;
    private BooleanConnectionProperty readOnlyPropagatesToServer;
    private BooleanConnectionProperty reconnectAtTxEnd;
    private boolean reconnectTxAtEndAsBoolean;
    private BooleanConnectionProperty relaxAutoCommit;
    private StringConnectionProperty replicationConnectionGroup;
    private BooleanConnectionProperty replicationEnableJMX;
    private IntegerConnectionProperty reportMetricsIntervalMillis;
    private BooleanConnectionProperty requireSSL;
    private StringConnectionProperty resourceId;
    private IntegerConnectionProperty resultSetSizeThreshold;
    private BooleanConnectionProperty retainStatementAfterResultSetClose;
    private IntegerConnectionProperty retriesAllDown;
    private BooleanConnectionProperty rewriteBatchedStatements;
    private BooleanConnectionProperty rollbackOnPooledClose;
    private BooleanConnectionProperty roundRobinLoadBalance;
    private BooleanConnectionProperty runningCTS13;
    private IntegerConnectionProperty secondsBeforeRetryMaster;
    private IntegerConnectionProperty selfDestructOnPingMaxOperations;
    private IntegerConnectionProperty selfDestructOnPingSecondsLifetime;
    private BooleanConnectionProperty sendFractionalSeconds;
    private StringConnectionProperty serverAffinityOrder;
    private StringConnectionProperty serverConfigCacheFactory;
    private StringConnectionProperty serverRSAPublicKeyFile;
    private StringConnectionProperty serverTimezone;
    private StringConnectionProperty sessionVariables;
    private IntegerConnectionProperty slowQueryThresholdMillis;
    private LongConnectionProperty slowQueryThresholdNanos;
    private StringConnectionProperty socketFactoryClassName;
    private IntegerConnectionProperty socketTimeout;
    private StringConnectionProperty socksProxyHost;
    private IntegerConnectionProperty socksProxyPort;
    private StringConnectionProperty statementInterceptors;
    private BooleanConnectionProperty strictFloatingPoint;
    private BooleanConnectionProperty strictUpdates;
    private BooleanConnectionProperty tcpKeepAlive;
    private BooleanConnectionProperty tcpNoDelay;
    private IntegerConnectionProperty tcpRcvBuf;
    private IntegerConnectionProperty tcpSndBuf;
    private IntegerConnectionProperty tcpTrafficClass;
    private BooleanConnectionProperty tinyInt1isBit;
    public BooleanConnectionProperty traceProtocol;
    private BooleanConnectionProperty transformedBitIsBoolean;
    private BooleanConnectionProperty treatUtilDateAsTimestamp;
    private StringConnectionProperty trustCertificateKeyStorePassword;
    private StringConnectionProperty trustCertificateKeyStoreType;
    private StringConnectionProperty trustCertificateKeyStoreUrl;
    private BooleanConnectionProperty useAffectedRows;
    private BooleanConnectionProperty useBlobToStoreUTF8OutsideBMP;
    private BooleanConnectionProperty useColumnNamesInFindColumn;
    private BooleanConnectionProperty useCompression;
    private StringConnectionProperty useConfigs;
    private BooleanConnectionProperty useCursorFetch;
    private BooleanConnectionProperty useDirectRowUnpack;
    private BooleanConnectionProperty useDynamicCharsetInfo;
    private BooleanConnectionProperty useFastDateParsing;
    private BooleanConnectionProperty useFastIntParsing;
    private BooleanConnectionProperty useGmtMillisForDatetimes;
    private BooleanConnectionProperty useHostsInPrivileges;
    private BooleanConnectionProperty useInformationSchema;
    private BooleanConnectionProperty useJDBCCompliantTimezoneShift;
    private BooleanConnectionProperty useJvmCharsetConverters;
    private BooleanConnectionProperty useLegacyDatetimeCode;
    private BooleanConnectionProperty useLocalSessionState;
    private BooleanConnectionProperty useLocalTransactionState;
    private BooleanConnectionProperty useNanosForElapsedTime;
    private BooleanConnectionProperty useOldAliasMetadataBehavior;
    private BooleanConnectionProperty useOldUTF8Behavior;
    private boolean useOldUTF8BehaviorAsBoolean;
    private BooleanConnectionProperty useOnlyServerErrorMessages;
    private BooleanConnectionProperty useReadAheadInput;
    private BooleanConnectionProperty useSSL;
    private BooleanConnectionProperty useSSPSCompatibleTimezoneShift;
    private BooleanConnectionProperty useSqlStateCodes;
    private BooleanConnectionProperty useStreamLengthsInPrepStmts;
    private BooleanConnectionProperty useTimezone;
    private BooleanConnectionProperty useUltraDevWorkAround;
    private BooleanConnectionProperty useUnbufferedInput;
    private BooleanConnectionProperty useUnicode;
    private boolean useUnicodeAsBoolean;
    private BooleanConnectionProperty useUsageAdvisor;
    private boolean useUsageAdvisorAsBoolean;
    private StringConnectionProperty utf8OutsideBmpExcludedColumnNamePattern;
    private StringConnectionProperty utf8OutsideBmpIncludedColumnNamePattern;
    private BooleanConnectionProperty verifyServerCertificate;
    private BooleanConnectionProperty yearIsDateType;
    private StringConnectionProperty zeroDateTimeBehavior;

    public static class BooleanConnectionProperty extends ConnectionProperty implements Serializable {
        private static final long serialVersionUID = 2540132501709159404L;

        public BooleanConnectionProperty(String str, boolean z, String str2, String str3, String str4, int i) {
            super(str, Boolean.valueOf(z), null, 0, 0, str2, str3, str4, i);
        }

        @Override // com.mysql.jdbc.ConnectionPropertiesImpl.ConnectionProperty
        public String[] getAllowableValues() {
            return new String[]{"true", "false", "yes", "no"};
        }

        public boolean getValueAsBoolean() {
            return ((Boolean) this.valueAsObject).booleanValue();
        }

        @Override // com.mysql.jdbc.ConnectionPropertiesImpl.ConnectionProperty
        public boolean hasValueConstraints() {
            return true;
        }

        @Override // com.mysql.jdbc.ConnectionPropertiesImpl.ConnectionProperty
        public void initializeFrom(String str, ExceptionInterceptor exceptionInterceptor) throws SQLException {
            if (str != null) {
                validateStringValues(str, exceptionInterceptor);
                this.valueAsObject = Boolean.valueOf(str.equalsIgnoreCase("TRUE") || str.equalsIgnoreCase("YES"));
                this.wasExplicitlySet = true;
            } else {
                this.valueAsObject = this.defaultValue;
            }
            this.updateCount++;
        }

        @Override // com.mysql.jdbc.ConnectionPropertiesImpl.ConnectionProperty
        public boolean isRangeBased() {
            return false;
        }

        public void setValue(boolean z) {
            this.valueAsObject = Boolean.valueOf(z);
            this.wasExplicitlySet = true;
            this.updateCount++;
        }
    }

    public static class IntegerConnectionProperty extends ConnectionProperty implements Serializable {
        private static final long serialVersionUID = -3004305481796850832L;
        public int multiplier;

        public IntegerConnectionProperty(String str, Object obj, String[] strArr, int i, int i2, String str2, String str3, String str4, int i3) {
            super(str, obj, strArr, i, i2, str2, str3, str4, i3);
            this.multiplier = 1;
        }

        @Override // com.mysql.jdbc.ConnectionPropertiesImpl.ConnectionProperty
        public String[] getAllowableValues() {
            return null;
        }

        @Override // com.mysql.jdbc.ConnectionPropertiesImpl.ConnectionProperty
        public int getLowerBound() {
            return this.lowerBound;
        }

        @Override // com.mysql.jdbc.ConnectionPropertiesImpl.ConnectionProperty
        public int getUpperBound() {
            return this.upperBound;
        }

        public int getValueAsInt() {
            return ((Integer) this.valueAsObject).intValue();
        }

        @Override // com.mysql.jdbc.ConnectionPropertiesImpl.ConnectionProperty
        public boolean hasValueConstraints() {
            return false;
        }

        @Override // com.mysql.jdbc.ConnectionPropertiesImpl.ConnectionProperty
        public void initializeFrom(String str, ExceptionInterceptor exceptionInterceptor) throws SQLException {
            if (str != null) {
                try {
                    setValue((int) (Double.valueOf(str).doubleValue() * ((double) this.multiplier)), str, exceptionInterceptor);
                } catch (NumberFormatException unused) {
                    throw SQLError.createSQLException("The connection property '" + getPropertyName() + "' only accepts integer values. The value '" + str + "' can not be converted to an integer.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
                }
            } else {
                this.valueAsObject = this.defaultValue;
            }
            this.updateCount++;
        }

        @Override // com.mysql.jdbc.ConnectionPropertiesImpl.ConnectionProperty
        public boolean isRangeBased() {
            return getUpperBound() != getLowerBound();
        }

        public void setValue(int i, ExceptionInterceptor exceptionInterceptor) throws SQLException {
            setValue(i, null, exceptionInterceptor);
        }

        public void setValue(int i, String str, ExceptionInterceptor exceptionInterceptor) throws SQLException {
            if (!isRangeBased() || (i >= getLowerBound() && i <= getUpperBound())) {
                this.valueAsObject = Integer.valueOf(i);
                this.wasExplicitlySet = true;
                this.updateCount++;
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("The connection property '");
            sb.append(getPropertyName());
            sb.append("' only accepts integer values in the range of ");
            sb.append(getLowerBound());
            sb.append(" - ");
            sb.append(getUpperBound());
            sb.append(", the value '");
            Object objValueOf = str;
            if (str == null) {
                objValueOf = Integer.valueOf(i);
            }
            sb.append(objValueOf);
            sb.append("' exceeds this range.");
            throw SQLError.createSQLException(sb.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
        }

        public IntegerConnectionProperty(String str, int i, int i2, int i3, String str2, String str3, String str4, int i4) {
            super(str, Integer.valueOf(i), null, i2, i3, str2, str3, str4, i4);
            this.multiplier = 1;
        }

        public IntegerConnectionProperty(String str, int i, String str2, String str3, String str4, int i2) {
            this(str, i, 0, 0, str2, str3, str4, i2);
        }
    }

    public static class LongConnectionProperty extends IntegerConnectionProperty {
        private static final long serialVersionUID = 6068572984340480895L;

        public LongConnectionProperty(String str, long j, long j2, long j3, String str2, String str3, String str4, int i) {
            super(str, Long.valueOf(j), null, (int) j2, (int) j3, str2, str3, str4, i);
        }

        public long getValueAsLong() {
            return ((Long) this.valueAsObject).longValue();
        }

        @Override // com.mysql.jdbc.ConnectionPropertiesImpl.IntegerConnectionProperty, com.mysql.jdbc.ConnectionPropertiesImpl.ConnectionProperty
        public void initializeFrom(String str, ExceptionInterceptor exceptionInterceptor) throws SQLException {
            if (str != null) {
                try {
                    setValue(Double.valueOf(str).longValue(), str, exceptionInterceptor);
                } catch (NumberFormatException unused) {
                    throw SQLError.createSQLException("The connection property '" + getPropertyName() + "' only accepts long integer values. The value '" + str + "' can not be converted to a long integer.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
                }
            } else {
                this.valueAsObject = this.defaultValue;
            }
            this.updateCount++;
        }

        public void setValue(long j, ExceptionInterceptor exceptionInterceptor) throws SQLException {
            setValue(j, (String) null, exceptionInterceptor);
        }

        public LongConnectionProperty(String str, long j, String str2, String str3, String str4, int i) {
            this(str, j, 0L, 0L, str2, str3, str4, i);
        }

        public void setValue(long j, String str, ExceptionInterceptor exceptionInterceptor) throws SQLException {
            if (!isRangeBased() || (j >= getLowerBound() && j <= getUpperBound())) {
                this.valueAsObject = Long.valueOf(j);
                this.wasExplicitlySet = true;
                this.updateCount++;
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("The connection property '");
            sb.append(getPropertyName());
            sb.append("' only accepts long integer values in the range of ");
            sb.append(getLowerBound());
            sb.append(" - ");
            sb.append(getUpperBound());
            sb.append(", the value '");
            Object objValueOf = str;
            if (str == null) {
                objValueOf = Long.valueOf(j);
            }
            sb.append(objValueOf);
            sb.append("' exceeds this range.");
            throw SQLError.createSQLException(sb.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
        }
    }

    public static class MemorySizeConnectionProperty extends IntegerConnectionProperty implements Serializable {
        private static final long serialVersionUID = 7351065128998572656L;
        private String valueAsString;

        public MemorySizeConnectionProperty(String str, int i, int i2, int i3, String str2, String str3, String str4, int i4) {
            super(str, i, i2, i3, str2, str3, str4, i4);
        }

        public String getValueAsString() {
            return this.valueAsString;
        }

        @Override // com.mysql.jdbc.ConnectionPropertiesImpl.IntegerConnectionProperty, com.mysql.jdbc.ConnectionPropertiesImpl.ConnectionProperty
        public void initializeFrom(String str, ExceptionInterceptor exceptionInterceptor) throws SQLException {
            this.valueAsString = str;
            this.multiplier = 1;
            if (str != null) {
                if (str.endsWith("k") || str.endsWith("K") || str.endsWith("kb") || str.endsWith("Kb") || str.endsWith("kB") || str.endsWith("KB")) {
                    this.multiplier = 1024;
                    str = str.substring(0, StringUtils.indexOfIgnoreCase(str, "k"));
                } else if (str.endsWith("m") || str.endsWith("M") || str.endsWith("mb") || str.endsWith("Mb") || str.endsWith("mB") || str.endsWith("MB")) {
                    this.multiplier = 1048576;
                    str = str.substring(0, StringUtils.indexOfIgnoreCase(str, "m"));
                } else if (str.endsWith("g") || str.endsWith("G") || str.endsWith("gb") || str.endsWith("Gb") || str.endsWith("gB") || str.endsWith("GB")) {
                    this.multiplier = Videoio.CAP_OPENNI_IMAGE_GENERATOR;
                    str = str.substring(0, StringUtils.indexOfIgnoreCase(str, "g"));
                }
            }
            super.initializeFrom(str, exceptionInterceptor);
        }

        public void setValue(String str, ExceptionInterceptor exceptionInterceptor) throws SQLException {
            initializeFrom(str, exceptionInterceptor);
        }
    }

    public static class StringConnectionProperty extends ConnectionProperty implements Serializable {
        private static final long serialVersionUID = 5432127962785948272L;

        public StringConnectionProperty(String str, String str2, String str3, String str4, String str5, int i) {
            this(str, str2, null, str3, str4, str5, i);
        }

        public String getValueAsString() {
            return (String) this.valueAsObject;
        }

        @Override // com.mysql.jdbc.ConnectionPropertiesImpl.ConnectionProperty
        public boolean hasValueConstraints() {
            String[] strArr = this.allowableValues;
            return strArr != null && strArr.length > 0;
        }

        @Override // com.mysql.jdbc.ConnectionPropertiesImpl.ConnectionProperty
        public void initializeFrom(String str, ExceptionInterceptor exceptionInterceptor) throws SQLException {
            if (str != null) {
                validateStringValues(str, exceptionInterceptor);
                this.valueAsObject = str;
                this.wasExplicitlySet = true;
            } else {
                this.valueAsObject = this.defaultValue;
            }
            this.updateCount++;
        }

        @Override // com.mysql.jdbc.ConnectionPropertiesImpl.ConnectionProperty
        public boolean isRangeBased() {
            return false;
        }

        public void setValue(String str) {
            this.valueAsObject = str;
            this.wasExplicitlySet = true;
            this.updateCount++;
        }

        public StringConnectionProperty(String str, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str, str2, strArr, 0, 0, str3, str4, str5, i);
        }
    }

    public class XmlMap {
        public Map<Integer, Map<String, ConnectionProperty>> ordered = new TreeMap();
        public Map<String, ConnectionProperty> alpha = new TreeMap();

        public XmlMap() {
        }
    }

    static {
        String string = Messages.getString("ConnectionProperties.categoryConnectionAuthentication");
        CONNECTION_AND_AUTH_CATEGORY = string;
        String string2 = Messages.getString("ConnectionProperties.categoryNetworking");
        NETWORK_CATEGORY = string2;
        String string3 = Messages.getString("ConnectionProperties.categoryDebuggingProfiling");
        DEBUGING_PROFILING_CATEGORY = string3;
        String string4 = Messages.getString("ConnectionProperties.categorryHA");
        HA_CATEGORY = string4;
        String string5 = Messages.getString("ConnectionProperties.categoryMisc");
        MISC_CATEGORY = string5;
        String string6 = Messages.getString("ConnectionProperties.categoryPerformance");
        PERFORMANCE_CATEGORY = string6;
        String string7 = Messages.getString("ConnectionProperties.categorySecurity");
        SECURITY_CATEGORY = string7;
        PROPERTY_CATEGORIES = new String[]{string, string2, string4, string7, string6, string3, string5};
        PROPERTY_LIST = new ArrayList<>();
        STANDARD_LOGGER_NAME = StandardLogger.class.getName();
        try {
            java.lang.reflect.Field[] declaredFields = ConnectionPropertiesImpl.class.getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++) {
                if (ConnectionProperty.class.isAssignableFrom(declaredFields[i].getType())) {
                    PROPERTY_LIST.add(declaredFields[i]);
                }
            }
        } catch (Exception e) {
            RuntimeException runtimeException = new RuntimeException();
            runtimeException.initCause(e);
            throw runtimeException;
        }
    }

    public ConnectionPropertiesImpl() {
        String string = Messages.getString("ConnectionProperties.loadDataLocal");
        String str = SECURITY_CATEGORY;
        this.allowLoadLocalInfile = new BooleanConnectionProperty("allowLoadLocalInfile", true, string, "3.0.3", str, Integer.MAX_VALUE);
        this.allowMultiQueries = new BooleanConnectionProperty("allowMultiQueries", false, Messages.getString("ConnectionProperties.allowMultiQueries"), "3.1.1", str, 1);
        String string2 = Messages.getString("ConnectionProperties.allowNANandINF");
        String str2 = MISC_CATEGORY;
        this.allowNanAndInf = new BooleanConnectionProperty("allowNanAndInf", false, string2, "3.1.5", str2, Integer.MIN_VALUE);
        this.allowUrlInLocalInfile = new BooleanConnectionProperty("allowUrlInLocalInfile", false, Messages.getString("ConnectionProperties.allowUrlInLoadLocal"), "3.1.4", str, Integer.MAX_VALUE);
        String string3 = Messages.getString("ConnectionProperties.alwaysSendSetIsolation");
        String str3 = PERFORMANCE_CATEGORY;
        this.alwaysSendSetIsolation = new BooleanConnectionProperty("alwaysSendSetIsolation", true, string3, "3.1.7", str3, Integer.MAX_VALUE);
        this.autoClosePStmtStreams = new BooleanConnectionProperty("autoClosePStmtStreams", false, Messages.getString("ConnectionProperties.autoClosePstmtStreams"), "3.1.12", str2, Integer.MIN_VALUE);
        String string4 = Messages.getString("ConnectionProperties.replicationConnectionGroup");
        String str4 = HA_CATEGORY;
        this.replicationConnectionGroup = new StringConnectionProperty("replicationConnectionGroup", null, string4, "5.1.27", str4, Integer.MIN_VALUE);
        this.allowMasterDownConnections = new BooleanConnectionProperty("allowMasterDownConnections", false, Messages.getString("ConnectionProperties.allowMasterDownConnections"), "5.1.27", str4, Integer.MAX_VALUE);
        this.allowSlaveDownConnections = new BooleanConnectionProperty("allowSlaveDownConnections", false, Messages.getString("ConnectionProperties.allowSlaveDownConnections"), "5.1.38", str4, Integer.MAX_VALUE);
        this.readFromMasterWhenNoSlaves = new BooleanConnectionProperty("readFromMasterWhenNoSlaves", false, Messages.getString("ConnectionProperties.readFromMasterWhenNoSlaves"), "5.1.38", str4, Integer.MAX_VALUE);
        this.autoDeserialize = new BooleanConnectionProperty("autoDeserialize", false, Messages.getString("ConnectionProperties.autoDeserialize"), "3.1.5", str2, Integer.MIN_VALUE);
        String string5 = Messages.getString("ConnectionProperties.autoGenerateTestcaseScript");
        String str5 = DEBUGING_PROFILING_CATEGORY;
        this.autoGenerateTestcaseScript = new BooleanConnectionProperty("autoGenerateTestcaseScript", false, string5, "3.1.9", str5, Integer.MIN_VALUE);
        this.autoGenerateTestcaseScriptAsBoolean = false;
        this.autoReconnect = new BooleanConnectionProperty("autoReconnect", false, Messages.getString("ConnectionProperties.autoReconnect"), "1.1", str4, 0);
        this.autoReconnectForPools = new BooleanConnectionProperty("autoReconnectForPools", false, Messages.getString("ConnectionProperties.autoReconnectForPools"), "3.1.3", str4, 1);
        this.autoReconnectForPoolsAsBoolean = false;
        this.blobSendChunkSize = new MemorySizeConnectionProperty("blobSendChunkSize", 1048576, 0, 0, Messages.getString("ConnectionProperties.blobSendChunkSize"), "3.1.9", str3, Integer.MIN_VALUE);
        this.autoSlowLog = new BooleanConnectionProperty("autoSlowLog", true, Messages.getString("ConnectionProperties.autoSlowLog"), "5.1.4", str5, Integer.MIN_VALUE);
        this.blobsAreStrings = new BooleanConnectionProperty("blobsAreStrings", false, "Should the driver always treat BLOBs as Strings - specifically to work around dubious metadata returned by the server for GROUP BY clauses?", "5.0.8", str2, Integer.MIN_VALUE);
        this.functionsNeverReturnBlobs = new BooleanConnectionProperty("functionsNeverReturnBlobs", false, "Should the driver always treat data from functions returning BLOBs as Strings - specifically to work around dubious metadata returned by the server for GROUP BY clauses?", "5.0.8", str2, Integer.MIN_VALUE);
        this.cacheCallableStatements = new BooleanConnectionProperty("cacheCallableStmts", false, Messages.getString("ConnectionProperties.cacheCallableStatements"), "3.1.2", str3, Integer.MIN_VALUE);
        this.cachePreparedStatements = new BooleanConnectionProperty("cachePrepStmts", false, Messages.getString("ConnectionProperties.cachePrepStmts"), "3.0.10", str3, Integer.MIN_VALUE);
        this.cacheResultSetMetadata = new BooleanConnectionProperty("cacheResultSetMetadata", false, Messages.getString("ConnectionProperties.cacheRSMetadata"), "3.1.1", str3, Integer.MIN_VALUE);
        this.serverConfigCacheFactory = new StringConnectionProperty("serverConfigCacheFactory", PerVmServerConfigCacheFactory.class.getName(), Messages.getString("ConnectionProperties.serverConfigCacheFactory"), "5.1.1", str3, 12);
        this.cacheServerConfiguration = new BooleanConnectionProperty("cacheServerConfiguration", false, Messages.getString("ConnectionProperties.cacheServerConfiguration"), "3.1.5", str3, Integer.MIN_VALUE);
        this.callableStatementCacheSize = new IntegerConnectionProperty("callableStmtCacheSize", 100, 0, Integer.MAX_VALUE, Messages.getString("ConnectionProperties.callableStmtCacheSize"), "3.1.2", str3, 5);
        this.capitalizeTypeNames = new BooleanConnectionProperty("capitalizeTypeNames", true, Messages.getString("ConnectionProperties.capitalizeTypeNames"), "2.0.7", str2, Integer.MIN_VALUE);
        this.characterEncoding = new StringConnectionProperty("characterEncoding", null, Messages.getString("ConnectionProperties.characterEncoding"), "1.1g", str2, 5);
        this.characterEncodingAsString = null;
        this.characterEncodingIsAliasForSjis = false;
        this.characterSetResults = new StringConnectionProperty("characterSetResults", null, Messages.getString("ConnectionProperties.characterSetResults"), "3.0.13", str2, 6);
        this.connectionAttributes = new StringConnectionProperty("connectionAttributes", null, Messages.getString("ConnectionProperties.connectionAttributes"), "5.1.25", str2, 7);
        this.clientInfoProvider = new StringConnectionProperty("clientInfoProvider", "com.mysql.jdbc.JDBC4CommentClientInfoProvider", Messages.getString("ConnectionProperties.clientInfoProvider"), "5.1.0", str5, Integer.MIN_VALUE);
        this.clobberStreamingResults = new BooleanConnectionProperty("clobberStreamingResults", false, Messages.getString("ConnectionProperties.clobberStreamingResults"), "3.0.9", str2, Integer.MIN_VALUE);
        this.clobCharacterEncoding = new StringConnectionProperty("clobCharacterEncoding", null, Messages.getString("ConnectionProperties.clobCharacterEncoding"), "5.0.0", str2, Integer.MIN_VALUE);
        this.compensateOnDuplicateKeyUpdateCounts = new BooleanConnectionProperty("compensateOnDuplicateKeyUpdateCounts", false, Messages.getString("ConnectionProperties.compensateOnDuplicateKeyUpdateCounts"), "5.1.7", str2, Integer.MIN_VALUE);
        this.connectionCollation = new StringConnectionProperty("connectionCollation", null, Messages.getString("ConnectionProperties.connectionCollation"), "3.0.13", str2, 7);
        String string6 = Messages.getString("ConnectionProperties.connectionLifecycleInterceptors");
        String str6 = CONNECTION_AND_AUTH_CATEGORY;
        this.connectionLifecycleInterceptors = new StringConnectionProperty("connectionLifecycleInterceptors", null, string6, "5.1.4", str6, Integer.MAX_VALUE);
        this.connectTimeout = new IntegerConnectionProperty("connectTimeout", 0, 0, Integer.MAX_VALUE, Messages.getString("ConnectionProperties.connectTimeout"), "3.0.1", str6, 9);
        this.continueBatchOnError = new BooleanConnectionProperty("continueBatchOnError", true, Messages.getString("ConnectionProperties.continueBatchOnError"), "3.0.3", str2, Integer.MIN_VALUE);
        this.createDatabaseIfNotExist = new BooleanConnectionProperty("createDatabaseIfNotExist", false, Messages.getString("ConnectionProperties.createDatabaseIfNotExist"), "3.1.9", str2, Integer.MIN_VALUE);
        this.defaultFetchSize = new IntegerConnectionProperty("defaultFetchSize", 0, Messages.getString("ConnectionProperties.defaultFetchSize"), "3.1.9", str3, Integer.MIN_VALUE);
        this.detectServerPreparedStmts = new BooleanConnectionProperty("useServerPrepStmts", false, Messages.getString("ConnectionProperties.useServerPrepStmts"), "3.1.0", str2, Integer.MIN_VALUE);
        this.dontTrackOpenResources = new BooleanConnectionProperty("dontTrackOpenResources", false, Messages.getString("ConnectionProperties.dontTrackOpenResources"), "3.1.7", str3, Integer.MIN_VALUE);
        this.dumpQueriesOnException = new BooleanConnectionProperty("dumpQueriesOnException", false, Messages.getString("ConnectionProperties.dumpQueriesOnException"), "3.1.3", str5, Integer.MIN_VALUE);
        this.dynamicCalendars = new BooleanConnectionProperty("dynamicCalendars", false, Messages.getString("ConnectionProperties.dynamicCalendars"), "3.1.5", str3, Integer.MIN_VALUE);
        this.elideSetAutoCommits = new BooleanConnectionProperty("elideSetAutoCommits", false, Messages.getString("ConnectionProperties.eliseSetAutoCommit"), "3.1.3", str3, Integer.MIN_VALUE);
        this.emptyStringsConvertToZero = new BooleanConnectionProperty("emptyStringsConvertToZero", true, Messages.getString("ConnectionProperties.emptyStringsConvertToZero"), "3.1.8", str2, Integer.MIN_VALUE);
        this.emulateLocators = new BooleanConnectionProperty("emulateLocators", false, Messages.getString("ConnectionProperties.emulateLocators"), "3.1.0", str2, Integer.MIN_VALUE);
        this.emulateUnsupportedPstmts = new BooleanConnectionProperty("emulateUnsupportedPstmts", true, Messages.getString("ConnectionProperties.emulateUnsupportedPstmts"), "3.1.7", str2, Integer.MIN_VALUE);
        this.enablePacketDebug = new BooleanConnectionProperty("enablePacketDebug", false, Messages.getString("ConnectionProperties.enablePacketDebug"), "3.1.3", str5, Integer.MIN_VALUE);
        this.enableQueryTimeouts = new BooleanConnectionProperty("enableQueryTimeouts", true, Messages.getString("ConnectionProperties.enableQueryTimeouts"), "5.0.6", str3, Integer.MIN_VALUE);
        this.explainSlowQueries = new BooleanConnectionProperty("explainSlowQueries", false, Messages.getString("ConnectionProperties.explainSlowQueries"), "3.1.2", str5, Integer.MIN_VALUE);
        this.exceptionInterceptors = new StringConnectionProperty("exceptionInterceptors", null, Messages.getString("ConnectionProperties.exceptionInterceptors"), "5.1.8", str2, Integer.MIN_VALUE);
        this.failOverReadOnly = new BooleanConnectionProperty("failOverReadOnly", true, Messages.getString("ConnectionProperties.failoverReadOnly"), "3.0.12", str4, 2);
        this.gatherPerformanceMetrics = new BooleanConnectionProperty("gatherPerfMetrics", false, Messages.getString("ConnectionProperties.gatherPerfMetrics"), "3.1.2", str5, 1);
        this.generateSimpleParameterMetadata = new BooleanConnectionProperty("generateSimpleParameterMetadata", false, Messages.getString("ConnectionProperties.generateSimpleParameterMetadata"), "5.0.5", str2, Integer.MIN_VALUE);
        this.highAvailabilityAsBoolean = false;
        this.holdResultsOpenOverStatementClose = new BooleanConnectionProperty("holdResultsOpenOverStatementClose", false, Messages.getString("ConnectionProperties.holdRSOpenOverStmtClose"), "3.1.7", str3, Integer.MIN_VALUE);
        this.includeInnodbStatusInDeadlockExceptions = new BooleanConnectionProperty("includeInnodbStatusInDeadlockExceptions", false, Messages.getString("ConnectionProperties.includeInnodbStatusInDeadlockExceptions"), "5.0.7", str5, Integer.MIN_VALUE);
        this.includeThreadDumpInDeadlockExceptions = new BooleanConnectionProperty("includeThreadDumpInDeadlockExceptions", false, Messages.getString("ConnectionProperties.includeThreadDumpInDeadlockExceptions"), "5.1.15", str5, Integer.MIN_VALUE);
        this.includeThreadNamesAsStatementComment = new BooleanConnectionProperty("includeThreadNamesAsStatementComment", false, Messages.getString("ConnectionProperties.includeThreadNamesAsStatementComment"), "5.1.15", str5, Integer.MIN_VALUE);
        this.ignoreNonTxTables = new BooleanConnectionProperty("ignoreNonTxTables", false, Messages.getString("ConnectionProperties.ignoreNonTxTables"), "3.0.9", str2, Integer.MIN_VALUE);
        this.initialTimeout = new IntegerConnectionProperty("initialTimeout", 2, 1, Integer.MAX_VALUE, Messages.getString("ConnectionProperties.initialTimeout"), "1.1", str4, 5);
        this.isInteractiveClient = new BooleanConnectionProperty("interactiveClient", false, Messages.getString("ConnectionProperties.interactiveClient"), "3.1.0", str6, Integer.MIN_VALUE);
        BooleanConnectionProperty booleanConnectionProperty = new BooleanConnectionProperty("jdbcCompliantTruncation", true, Messages.getString("ConnectionProperties.jdbcCompliantTruncation"), "3.1.2", str2, Integer.MIN_VALUE);
        this.jdbcCompliantTruncation = booleanConnectionProperty;
        this.jdbcCompliantTruncationForReads = booleanConnectionProperty.getValueAsBoolean();
        this.largeRowSizeThreshold = new MemorySizeConnectionProperty("largeRowSizeThreshold", 2048, 0, Integer.MAX_VALUE, Messages.getString("ConnectionProperties.largeRowSizeThreshold"), "5.1.1", str3, Integer.MIN_VALUE);
        this.loadBalanceStrategy = new StringConnectionProperty("loadBalanceStrategy", "random", null, Messages.getString("ConnectionProperties.loadBalanceStrategy"), "5.0.6", str3, Integer.MIN_VALUE);
        this.serverAffinityOrder = new StringConnectionProperty(ServerAffinityStrategy.AFFINITY_ORDER, BuildConfig.FLAVOR, null, Messages.getString("ConnectionProperties.serverAffinityOrder"), "5.1.43", str3, Integer.MIN_VALUE);
        this.loadBalanceBlacklistTimeout = new IntegerConnectionProperty(LoadBalancedConnectionProxy.BLACKLIST_TIMEOUT_PROPERTY_KEY, 0, 0, Integer.MAX_VALUE, Messages.getString("ConnectionProperties.loadBalanceBlacklistTimeout"), "5.1.0", str2, Integer.MIN_VALUE);
        this.loadBalancePingTimeout = new IntegerConnectionProperty("loadBalancePingTimeout", 0, 0, Integer.MAX_VALUE, Messages.getString("ConnectionProperties.loadBalancePingTimeout"), "5.1.13", str2, Integer.MIN_VALUE);
        this.loadBalanceValidateConnectionOnSwapServer = new BooleanConnectionProperty("loadBalanceValidateConnectionOnSwapServer", false, Messages.getString("ConnectionProperties.loadBalanceValidateConnectionOnSwapServer"), "5.1.13", str2, Integer.MIN_VALUE);
        this.loadBalanceConnectionGroup = new StringConnectionProperty("loadBalanceConnectionGroup", null, Messages.getString("ConnectionProperties.loadBalanceConnectionGroup"), "5.1.13", str2, Integer.MIN_VALUE);
        this.loadBalanceExceptionChecker = new StringConnectionProperty("loadBalanceExceptionChecker", "com.mysql.jdbc.StandardLoadBalanceExceptionChecker", null, Messages.getString("ConnectionProperties.loadBalanceExceptionChecker"), "5.1.13", str2, Integer.MIN_VALUE);
        this.loadBalanceSQLStateFailover = new StringConnectionProperty("loadBalanceSQLStateFailover", null, Messages.getString("ConnectionProperties.loadBalanceSQLStateFailover"), "5.1.13", str2, Integer.MIN_VALUE);
        this.loadBalanceSQLExceptionSubclassFailover = new StringConnectionProperty("loadBalanceSQLExceptionSubclassFailover", null, Messages.getString("ConnectionProperties.loadBalanceSQLExceptionSubclassFailover"), "5.1.13", str2, Integer.MIN_VALUE);
        this.loadBalanceEnableJMX = new BooleanConnectionProperty("loadBalanceEnableJMX", false, Messages.getString("ConnectionProperties.loadBalanceEnableJMX"), "5.1.13", str2, Integer.MAX_VALUE);
        this.loadBalanceHostRemovalGracePeriod = new IntegerConnectionProperty(LoadBalancedConnectionProxy.HOST_REMOVAL_GRACE_PERIOD_PROPERTY_KEY, 15000, 0, Integer.MAX_VALUE, Messages.getString("ConnectionProperties.loadBalanceHostRemovalGracePeriod"), "5.1.39", str2, Integer.MAX_VALUE);
        this.loadBalanceAutoCommitStatementRegex = new StringConnectionProperty("loadBalanceAutoCommitStatementRegex", null, Messages.getString("ConnectionProperties.loadBalanceAutoCommitStatementRegex"), "5.1.15", str2, Integer.MIN_VALUE);
        this.loadBalanceAutoCommitStatementThreshold = new IntegerConnectionProperty("loadBalanceAutoCommitStatementThreshold", 0, 0, Integer.MAX_VALUE, Messages.getString("ConnectionProperties.loadBalanceAutoCommitStatementThreshold"), "5.1.15", str2, Integer.MIN_VALUE);
        this.localSocketAddress = new StringConnectionProperty("localSocketAddress", null, Messages.getString("ConnectionProperties.localSocketAddress"), "5.0.5", str6, Integer.MIN_VALUE);
        this.locatorFetchBufferSize = new MemorySizeConnectionProperty("locatorFetchBufferSize", 1048576, 0, Integer.MAX_VALUE, Messages.getString("ConnectionProperties.locatorFetchBufferSize"), "3.2.1", str3, Integer.MIN_VALUE);
        String str7 = STANDARD_LOGGER_NAME;
        this.loggerClassName = new StringConnectionProperty("logger", str7, Messages.getString("ConnectionProperties.logger", new Object[]{Log.class.getName(), str7}), "3.1.1", str5, 0);
        this.logSlowQueries = new BooleanConnectionProperty("logSlowQueries", false, Messages.getString("ConnectionProperties.logSlowQueries"), "3.1.2", str5, Integer.MIN_VALUE);
        this.logXaCommands = new BooleanConnectionProperty("logXaCommands", false, Messages.getString("ConnectionProperties.logXaCommands"), "5.0.5", str5, Integer.MIN_VALUE);
        this.maintainTimeStats = new BooleanConnectionProperty("maintainTimeStats", true, Messages.getString("ConnectionProperties.maintainTimeStats"), "3.1.9", str3, Integer.MAX_VALUE);
        this.maintainTimeStatsAsBoolean = true;
        this.maxQuerySizeToLog = new IntegerConnectionProperty("maxQuerySizeToLog", 2048, 0, Integer.MAX_VALUE, Messages.getString("ConnectionProperties.maxQuerySizeToLog"), "3.1.3", str5, 4);
        this.maxReconnects = new IntegerConnectionProperty("maxReconnects", 3, 1, Integer.MAX_VALUE, Messages.getString("ConnectionProperties.maxReconnects"), "1.1", str4, 4);
        this.retriesAllDown = new IntegerConnectionProperty("retriesAllDown", 120, 0, Integer.MAX_VALUE, Messages.getString("ConnectionProperties.retriesAllDown"), "5.1.6", str4, 4);
        this.maxRows = new IntegerConnectionProperty("maxRows", -1, -1, Integer.MAX_VALUE, Messages.getString("ConnectionProperties.maxRows"), Messages.getString("ConnectionProperties.allVersions"), str2, Integer.MIN_VALUE);
        this.maxRowsAsInt = -1;
        this.metadataCacheSize = new IntegerConnectionProperty("metadataCacheSize", 50, 1, Integer.MAX_VALUE, Messages.getString("ConnectionProperties.metadataCacheSize"), "3.1.1", str3, 5);
        this.netTimeoutForStreamingResults = new IntegerConnectionProperty("netTimeoutForStreamingResults", 600, 0, Integer.MAX_VALUE, Messages.getString("ConnectionProperties.netTimeoutForStreamingResults"), "5.1.0", str2, Integer.MIN_VALUE);
        this.noAccessToProcedureBodies = new BooleanConnectionProperty("noAccessToProcedureBodies", false, "When determining procedure parameter types for CallableStatements, and the connected user  can't access procedure bodies through \"SHOW CREATE PROCEDURE\" or select on mysql.proc  should the driver instead create basic metadata (all parameters reported as IN VARCHARs, but allowing registerOutParameter() to be called on them anyway) instead of throwing an exception?", "5.0.3", str2, Integer.MIN_VALUE);
        this.noDatetimeStringSync = new BooleanConnectionProperty("noDatetimeStringSync", false, Messages.getString("ConnectionProperties.noDatetimeStringSync"), "3.1.7", str2, Integer.MIN_VALUE);
        this.noTimezoneConversionForTimeType = new BooleanConnectionProperty("noTimezoneConversionForTimeType", false, Messages.getString("ConnectionProperties.noTzConversionForTimeType"), "5.0.0", str2, Integer.MIN_VALUE);
        this.noTimezoneConversionForDateType = new BooleanConnectionProperty("noTimezoneConversionForDateType", true, Messages.getString("ConnectionProperties.noTzConversionForDateType"), "5.1.35", str2, Integer.MIN_VALUE);
        this.cacheDefaultTimezone = new BooleanConnectionProperty("cacheDefaultTimezone", true, Messages.getString("ConnectionProperties.cacheDefaultTimezone"), "5.1.35", str2, Integer.MIN_VALUE);
        this.nullCatalogMeansCurrent = new BooleanConnectionProperty("nullCatalogMeansCurrent", true, Messages.getString("ConnectionProperties.nullCatalogMeansCurrent"), "3.1.8", str2, Integer.MIN_VALUE);
        this.nullNamePatternMatchesAll = new BooleanConnectionProperty("nullNamePatternMatchesAll", true, Messages.getString("ConnectionProperties.nullNamePatternMatchesAll"), "3.1.8", str2, Integer.MIN_VALUE);
        this.packetDebugBufferSize = new IntegerConnectionProperty("packetDebugBufferSize", 20, 1, Integer.MAX_VALUE, Messages.getString("ConnectionProperties.packetDebugBufferSize"), "3.1.3", str5, 7);
        this.padCharsWithSpace = new BooleanConnectionProperty("padCharsWithSpace", false, Messages.getString("ConnectionProperties.padCharsWithSpace"), "5.0.6", str2, Integer.MIN_VALUE);
        this.paranoid = new BooleanConnectionProperty("paranoid", false, Messages.getString("ConnectionProperties.paranoid"), "3.0.1", str, Integer.MIN_VALUE);
        this.pedantic = new BooleanConnectionProperty("pedantic", false, Messages.getString("ConnectionProperties.pedantic"), "3.0.0", str2, Integer.MIN_VALUE);
        this.pinGlobalTxToPhysicalConnection = new BooleanConnectionProperty("pinGlobalTxToPhysicalConnection", false, Messages.getString("ConnectionProperties.pinGlobalTxToPhysicalConnection"), "5.0.1", str2, Integer.MIN_VALUE);
        this.populateInsertRowWithDefaultValues = new BooleanConnectionProperty("populateInsertRowWithDefaultValues", false, Messages.getString("ConnectionProperties.populateInsertRowWithDefaultValues"), "5.0.5", str2, Integer.MIN_VALUE);
        this.preparedStatementCacheSize = new IntegerConnectionProperty("prepStmtCacheSize", 25, 0, Integer.MAX_VALUE, Messages.getString("ConnectionProperties.prepStmtCacheSize"), "3.0.10", str3, 10);
        this.preparedStatementCacheSqlLimit = new IntegerConnectionProperty("prepStmtCacheSqlLimit", 256, 1, Integer.MAX_VALUE, Messages.getString("ConnectionProperties.prepStmtCacheSqlLimit"), "3.0.10", str3, 11);
        this.parseInfoCacheFactory = new StringConnectionProperty("parseInfoCacheFactory", PerConnectionLRUFactory.class.getName(), Messages.getString("ConnectionProperties.parseInfoCacheFactory"), "5.1.1", str3, 12);
        this.processEscapeCodesForPrepStmts = new BooleanConnectionProperty("processEscapeCodesForPrepStmts", true, Messages.getString("ConnectionProperties.processEscapeCodesForPrepStmts"), "3.1.12", str2, Integer.MIN_VALUE);
        this.profilerEventHandler = new StringConnectionProperty("profilerEventHandler", "com.mysql.jdbc.profiler.LoggingProfilerEventHandler", Messages.getString("ConnectionProperties.profilerEventHandler"), "5.1.6", str5, Integer.MIN_VALUE);
        this.profileSql = new StringConnectionProperty("profileSql", null, Messages.getString("ConnectionProperties.profileSqlDeprecated"), "2.0.14", str5, 3);
        this.profileSQL = new BooleanConnectionProperty("profileSQL", false, Messages.getString("ConnectionProperties.profileSQL"), "3.1.0", str5, 1);
        this.profileSQLAsBoolean = false;
        this.propertiesTransform = new StringConnectionProperty(NonRegisteringDriver.PROPERTIES_TRANSFORM_KEY, null, Messages.getString("ConnectionProperties.connectionPropertiesTransform"), "3.1.4", str6, Integer.MIN_VALUE);
        this.queriesBeforeRetryMaster = new IntegerConnectionProperty("queriesBeforeRetryMaster", 50, 0, Integer.MAX_VALUE, Messages.getString("ConnectionProperties.queriesBeforeRetryMaster"), "3.0.2", str4, 7);
        this.queryTimeoutKillsConnection = new BooleanConnectionProperty("queryTimeoutKillsConnection", false, Messages.getString("ConnectionProperties.queryTimeoutKillsConnection"), "5.1.9", str2, Integer.MIN_VALUE);
        this.reconnectAtTxEnd = new BooleanConnectionProperty("reconnectAtTxEnd", false, Messages.getString("ConnectionProperties.reconnectAtTxEnd"), "3.0.10", str4, 4);
        this.reconnectTxAtEndAsBoolean = false;
        this.relaxAutoCommit = new BooleanConnectionProperty("relaxAutoCommit", false, Messages.getString("ConnectionProperties.relaxAutoCommit"), "2.0.13", str2, Integer.MIN_VALUE);
        this.reportMetricsIntervalMillis = new IntegerConnectionProperty("reportMetricsIntervalMillis", 30000, 0, Integer.MAX_VALUE, Messages.getString("ConnectionProperties.reportMetricsIntervalMillis"), "3.1.2", str5, 3);
        this.requireSSL = new BooleanConnectionProperty("requireSSL", false, Messages.getString("ConnectionProperties.requireSSL"), "3.1.0", str, 3);
        this.resourceId = new StringConnectionProperty("resourceId", null, Messages.getString("ConnectionProperties.resourceId"), "5.0.1", str4, Integer.MIN_VALUE);
        this.resultSetSizeThreshold = new IntegerConnectionProperty("resultSetSizeThreshold", 100, Messages.getString("ConnectionProperties.resultSetSizeThreshold"), "5.0.5", str5, Integer.MIN_VALUE);
        this.retainStatementAfterResultSetClose = new BooleanConnectionProperty("retainStatementAfterResultSetClose", false, Messages.getString("ConnectionProperties.retainStatementAfterResultSetClose"), "3.1.11", str2, Integer.MIN_VALUE);
        this.rewriteBatchedStatements = new BooleanConnectionProperty("rewriteBatchedStatements", false, Messages.getString("ConnectionProperties.rewriteBatchedStatements"), "3.1.13", str3, Integer.MIN_VALUE);
        this.rollbackOnPooledClose = new BooleanConnectionProperty("rollbackOnPooledClose", true, Messages.getString("ConnectionProperties.rollbackOnPooledClose"), "3.0.15", str2, Integer.MIN_VALUE);
        this.roundRobinLoadBalance = new BooleanConnectionProperty("roundRobinLoadBalance", false, Messages.getString("ConnectionProperties.roundRobinLoadBalance"), "3.1.2", str4, 5);
        this.runningCTS13 = new BooleanConnectionProperty("runningCTS13", false, Messages.getString("ConnectionProperties.runningCTS13"), "3.1.7", str2, Integer.MIN_VALUE);
        this.secondsBeforeRetryMaster = new IntegerConnectionProperty("secondsBeforeRetryMaster", 30, 0, Integer.MAX_VALUE, Messages.getString("ConnectionProperties.secondsBeforeRetryMaster"), "3.0.2", str4, 8);
        this.selfDestructOnPingSecondsLifetime = new IntegerConnectionProperty("selfDestructOnPingSecondsLifetime", 0, 0, Integer.MAX_VALUE, Messages.getString("ConnectionProperties.selfDestructOnPingSecondsLifetime"), "5.1.6", str4, Integer.MAX_VALUE);
        this.selfDestructOnPingMaxOperations = new IntegerConnectionProperty("selfDestructOnPingMaxOperations", 0, 0, Integer.MAX_VALUE, Messages.getString("ConnectionProperties.selfDestructOnPingMaxOperations"), "5.1.6", str4, Integer.MAX_VALUE);
        this.replicationEnableJMX = new BooleanConnectionProperty("replicationEnableJMX", false, Messages.getString("ConnectionProperties.loadBalanceEnableJMX"), "5.1.27", str4, Integer.MAX_VALUE);
        this.serverTimezone = new StringConnectionProperty("serverTimezone", null, Messages.getString("ConnectionProperties.serverTimezone"), "3.0.2", str2, Integer.MIN_VALUE);
        this.sessionVariables = new StringConnectionProperty("sessionVariables", null, Messages.getString("ConnectionProperties.sessionVariables"), "3.1.8", str2, Integer.MAX_VALUE);
        this.slowQueryThresholdMillis = new IntegerConnectionProperty("slowQueryThresholdMillis", 2000, 0, Integer.MAX_VALUE, Messages.getString("ConnectionProperties.slowQueryThresholdMillis"), "3.1.2", str5, 9);
        this.slowQueryThresholdNanos = new LongConnectionProperty("slowQueryThresholdNanos", 0L, Messages.getString("ConnectionProperties.slowQueryThresholdNanos"), "5.0.7", str5, 10);
        this.socketFactoryClassName = new StringConnectionProperty("socketFactory", StandardSocketFactory.class.getName(), Messages.getString("ConnectionProperties.socketFactory"), "3.0.3", str6, 4);
        String string7 = Messages.getString("ConnectionProperties.socksProxyHost");
        String str8 = NETWORK_CATEGORY;
        this.socksProxyHost = new StringConnectionProperty("socksProxyHost", null, string7, "5.1.34", str8, 1);
        this.socksProxyPort = new IntegerConnectionProperty("socksProxyPort", SocksProxySocketFactory.SOCKS_DEFAULT_PORT, 0, Settings.DEFAULT_INITIAL_WINDOW_SIZE, Messages.getString("ConnectionProperties.socksProxyPort"), "5.1.34", str8, 2);
        this.socketTimeout = new IntegerConnectionProperty("socketTimeout", 0, 0, Integer.MAX_VALUE, Messages.getString("ConnectionProperties.socketTimeout"), "3.0.1", str6, 10);
        this.statementInterceptors = new StringConnectionProperty("statementInterceptors", null, Messages.getString("ConnectionProperties.statementInterceptors"), "5.1.1", str2, Integer.MIN_VALUE);
        this.strictFloatingPoint = new BooleanConnectionProperty("strictFloatingPoint", false, Messages.getString("ConnectionProperties.strictFloatingPoint"), "3.0.0", str2, Integer.MIN_VALUE);
        this.strictUpdates = new BooleanConnectionProperty("strictUpdates", true, Messages.getString("ConnectionProperties.strictUpdates"), "3.0.4", str2, Integer.MIN_VALUE);
        this.overrideSupportsIntegrityEnhancementFacility = new BooleanConnectionProperty("overrideSupportsIntegrityEnhancementFacility", false, Messages.getString("ConnectionProperties.overrideSupportsIEF"), "3.1.12", str2, Integer.MIN_VALUE);
        this.tcpNoDelay = new BooleanConnectionProperty(StandardSocketFactory.TCP_NO_DELAY_PROPERTY_NAME, Boolean.valueOf("true").booleanValue(), Messages.getString("ConnectionProperties.tcpNoDelay"), "5.0.7", str8, Integer.MIN_VALUE);
        this.tcpKeepAlive = new BooleanConnectionProperty(StandardSocketFactory.TCP_KEEP_ALIVE_PROPERTY_NAME, Boolean.valueOf("true").booleanValue(), Messages.getString("ConnectionProperties.tcpKeepAlive"), "5.0.7", str8, Integer.MIN_VALUE);
        this.tcpRcvBuf = new IntegerConnectionProperty(StandardSocketFactory.TCP_RCV_BUF_PROPERTY_NAME, Integer.parseInt("0"), 0, Integer.MAX_VALUE, Messages.getString("ConnectionProperties.tcpSoRcvBuf"), "5.0.7", str8, Integer.MIN_VALUE);
        this.tcpSndBuf = new IntegerConnectionProperty(StandardSocketFactory.TCP_SND_BUF_PROPERTY_NAME, Integer.parseInt("0"), 0, Integer.MAX_VALUE, Messages.getString("ConnectionProperties.tcpSoSndBuf"), "5.0.7", str8, Integer.MIN_VALUE);
        this.tcpTrafficClass = new IntegerConnectionProperty(StandardSocketFactory.TCP_TRAFFIC_CLASS_PROPERTY_NAME, Integer.parseInt("0"), 0, 255, Messages.getString("ConnectionProperties.tcpTrafficClass"), "5.0.7", str8, Integer.MIN_VALUE);
        this.tinyInt1isBit = new BooleanConnectionProperty("tinyInt1isBit", true, Messages.getString("ConnectionProperties.tinyInt1isBit"), "3.0.16", str2, Integer.MIN_VALUE);
        this.traceProtocol = new BooleanConnectionProperty("traceProtocol", false, Messages.getString("ConnectionProperties.traceProtocol"), "3.1.2", str5, Integer.MIN_VALUE);
        this.treatUtilDateAsTimestamp = new BooleanConnectionProperty("treatUtilDateAsTimestamp", true, Messages.getString("ConnectionProperties.treatUtilDateAsTimestamp"), "5.0.5", str2, Integer.MIN_VALUE);
        this.transformedBitIsBoolean = new BooleanConnectionProperty("transformedBitIsBoolean", false, Messages.getString("ConnectionProperties.transformedBitIsBoolean"), "3.1.9", str2, Integer.MIN_VALUE);
        this.useBlobToStoreUTF8OutsideBMP = new BooleanConnectionProperty("useBlobToStoreUTF8OutsideBMP", false, Messages.getString("ConnectionProperties.useBlobToStoreUTF8OutsideBMP"), "5.1.3", str2, 128);
        this.utf8OutsideBmpExcludedColumnNamePattern = new StringConnectionProperty("utf8OutsideBmpExcludedColumnNamePattern", null, Messages.getString("ConnectionProperties.utf8OutsideBmpExcludedColumnNamePattern"), "5.1.3", str2, 129);
        this.utf8OutsideBmpIncludedColumnNamePattern = new StringConnectionProperty("utf8OutsideBmpIncludedColumnNamePattern", null, Messages.getString("ConnectionProperties.utf8OutsideBmpIncludedColumnNamePattern"), "5.1.3", str2, 129);
        this.useCompression = new BooleanConnectionProperty("useCompression", false, Messages.getString("ConnectionProperties.useCompression"), "3.0.17", str6, Integer.MIN_VALUE);
        this.useColumnNamesInFindColumn = new BooleanConnectionProperty("useColumnNamesInFindColumn", false, Messages.getString("ConnectionProperties.useColumnNamesInFindColumn"), "5.1.7", str2, Integer.MAX_VALUE);
        this.useConfigs = new StringConnectionProperty(NonRegisteringDriver.USE_CONFIG_PROPERTY_KEY, null, Messages.getString("ConnectionProperties.useConfigs"), "3.1.5", str6, Integer.MAX_VALUE);
        this.useCursorFetch = new BooleanConnectionProperty("useCursorFetch", false, Messages.getString("ConnectionProperties.useCursorFetch"), "5.0.0", str3, Integer.MAX_VALUE);
        this.useDynamicCharsetInfo = new BooleanConnectionProperty("useDynamicCharsetInfo", true, Messages.getString("ConnectionProperties.useDynamicCharsetInfo"), "5.0.6", str3, Integer.MIN_VALUE);
        this.useDirectRowUnpack = new BooleanConnectionProperty("useDirectRowUnpack", true, "Use newer result set row unpacking code that skips a copy from network buffers  to a MySQL packet instance and instead reads directly into the result set row data buffers.", "5.1.1", str3, Integer.MIN_VALUE);
        this.useFastIntParsing = new BooleanConnectionProperty("useFastIntParsing", true, Messages.getString("ConnectionProperties.useFastIntParsing"), "3.1.4", str3, Integer.MIN_VALUE);
        this.useFastDateParsing = new BooleanConnectionProperty("useFastDateParsing", true, Messages.getString("ConnectionProperties.useFastDateParsing"), "5.0.5", str3, Integer.MIN_VALUE);
        this.useHostsInPrivileges = new BooleanConnectionProperty("useHostsInPrivileges", true, Messages.getString("ConnectionProperties.useHostsInPrivileges"), "3.0.2", str2, Integer.MIN_VALUE);
        this.useInformationSchema = new BooleanConnectionProperty("useInformationSchema", false, Messages.getString("ConnectionProperties.useInformationSchema"), "5.0.0", str2, Integer.MIN_VALUE);
        this.useJDBCCompliantTimezoneShift = new BooleanConnectionProperty("useJDBCCompliantTimezoneShift", false, Messages.getString("ConnectionProperties.useJDBCCompliantTimezoneShift"), "5.0.0", str2, Integer.MIN_VALUE);
        this.useLocalSessionState = new BooleanConnectionProperty("useLocalSessionState", false, Messages.getString("ConnectionProperties.useLocalSessionState"), "3.1.7", str3, 5);
        this.useLocalTransactionState = new BooleanConnectionProperty("useLocalTransactionState", false, Messages.getString("ConnectionProperties.useLocalTransactionState"), "5.1.7", str3, 6);
        this.useLegacyDatetimeCode = new BooleanConnectionProperty("useLegacyDatetimeCode", true, Messages.getString("ConnectionProperties.useLegacyDatetimeCode"), "5.1.6", str2, Integer.MIN_VALUE);
        this.sendFractionalSeconds = new BooleanConnectionProperty("sendFractionalSeconds", true, Messages.getString("ConnectionProperties.sendFractionalSeconds"), "5.1.37", str2, Integer.MIN_VALUE);
        this.useNanosForElapsedTime = new BooleanConnectionProperty("useNanosForElapsedTime", false, Messages.getString("ConnectionProperties.useNanosForElapsedTime"), "5.0.7", str5, Integer.MIN_VALUE);
        this.useOldAliasMetadataBehavior = new BooleanConnectionProperty("useOldAliasMetadataBehavior", false, Messages.getString("ConnectionProperties.useOldAliasMetadataBehavior"), "5.0.4", str2, Integer.MIN_VALUE);
        this.useOldUTF8Behavior = new BooleanConnectionProperty("useOldUTF8Behavior", false, Messages.getString("ConnectionProperties.useOldUtf8Behavior"), "3.1.6", str2, Integer.MIN_VALUE);
        this.useOldUTF8BehaviorAsBoolean = false;
        this.useOnlyServerErrorMessages = new BooleanConnectionProperty("useOnlyServerErrorMessages", true, Messages.getString("ConnectionProperties.useOnlyServerErrorMessages"), "3.0.15", str2, Integer.MIN_VALUE);
        this.useReadAheadInput = new BooleanConnectionProperty("useReadAheadInput", true, Messages.getString("ConnectionProperties.useReadAheadInput"), "3.1.5", str3, Integer.MIN_VALUE);
        this.useSqlStateCodes = new BooleanConnectionProperty("useSqlStateCodes", true, Messages.getString("ConnectionProperties.useSqlStateCodes"), "3.1.3", str2, Integer.MIN_VALUE);
        this.useSSL = new BooleanConnectionProperty("useSSL", false, Messages.getString("ConnectionProperties.useSSL"), "3.0.2", str, 2);
        this.useSSPSCompatibleTimezoneShift = new BooleanConnectionProperty("useSSPSCompatibleTimezoneShift", false, Messages.getString("ConnectionProperties.useSSPSCompatibleTimezoneShift"), "5.0.5", str2, Integer.MIN_VALUE);
        this.useStreamLengthsInPrepStmts = new BooleanConnectionProperty("useStreamLengthsInPrepStmts", true, Messages.getString("ConnectionProperties.useStreamLengthsInPrepStmts"), "3.0.2", str2, Integer.MIN_VALUE);
        this.useTimezone = new BooleanConnectionProperty("useTimezone", false, Messages.getString("ConnectionProperties.useTimezone"), "3.0.2", str2, Integer.MIN_VALUE);
        this.useUltraDevWorkAround = new BooleanConnectionProperty("ultraDevHack", false, Messages.getString("ConnectionProperties.ultraDevHack"), "2.0.3", str2, Integer.MIN_VALUE);
        this.useUnbufferedInput = new BooleanConnectionProperty("useUnbufferedInput", true, Messages.getString("ConnectionProperties.useUnbufferedInput"), "3.0.11", str2, Integer.MIN_VALUE);
        this.useUnicode = new BooleanConnectionProperty("useUnicode", true, Messages.getString("ConnectionProperties.useUnicode"), "1.1g", str2, 0);
        this.useUnicodeAsBoolean = true;
        this.useUsageAdvisor = new BooleanConnectionProperty("useUsageAdvisor", false, Messages.getString("ConnectionProperties.useUsageAdvisor"), "3.1.1", str5, 10);
        this.useUsageAdvisorAsBoolean = false;
        this.yearIsDateType = new BooleanConnectionProperty("yearIsDateType", true, Messages.getString("ConnectionProperties.yearIsDateType"), "3.1.9", str2, Integer.MIN_VALUE);
        this.zeroDateTimeBehavior = new StringConnectionProperty("zeroDateTimeBehavior", ZERO_DATETIME_BEHAVIOR_EXCEPTION, new String[]{ZERO_DATETIME_BEHAVIOR_EXCEPTION, ZERO_DATETIME_BEHAVIOR_ROUND, ZERO_DATETIME_BEHAVIOR_CONVERT_TO_NULL}, Messages.getString("ConnectionProperties.zeroDateTimeBehavior", new Object[]{ZERO_DATETIME_BEHAVIOR_EXCEPTION, ZERO_DATETIME_BEHAVIOR_ROUND, ZERO_DATETIME_BEHAVIOR_CONVERT_TO_NULL}), "3.1.4", str2, Integer.MIN_VALUE);
        this.useJvmCharsetConverters = new BooleanConnectionProperty("useJvmCharsetConverters", false, Messages.getString("ConnectionProperties.useJvmCharsetConverters"), "5.0.1", str3, Integer.MIN_VALUE);
        this.useGmtMillisForDatetimes = new BooleanConnectionProperty("useGmtMillisForDatetimes", false, Messages.getString("ConnectionProperties.useGmtMillisForDatetimes"), "3.1.12", str2, Integer.MIN_VALUE);
        this.dumpMetadataOnColumnNotFound = new BooleanConnectionProperty("dumpMetadataOnColumnNotFound", false, Messages.getString("ConnectionProperties.dumpMetadataOnColumnNotFound"), "3.1.13", str5, Integer.MIN_VALUE);
        this.clientCertificateKeyStoreUrl = new StringConnectionProperty("clientCertificateKeyStoreUrl", null, Messages.getString("ConnectionProperties.clientCertificateKeyStoreUrl"), "5.1.0", str, 5);
        this.trustCertificateKeyStoreUrl = new StringConnectionProperty("trustCertificateKeyStoreUrl", null, Messages.getString("ConnectionProperties.trustCertificateKeyStoreUrl"), "5.1.0", str, 8);
        this.clientCertificateKeyStoreType = new StringConnectionProperty("clientCertificateKeyStoreType", "JKS", Messages.getString("ConnectionProperties.clientCertificateKeyStoreType"), "5.1.0", str, 6);
        this.clientCertificateKeyStorePassword = new StringConnectionProperty("clientCertificateKeyStorePassword", null, Messages.getString("ConnectionProperties.clientCertificateKeyStorePassword"), "5.1.0", str, 7);
        this.trustCertificateKeyStoreType = new StringConnectionProperty("trustCertificateKeyStoreType", "JKS", Messages.getString("ConnectionProperties.trustCertificateKeyStoreType"), "5.1.0", str, 9);
        this.trustCertificateKeyStorePassword = new StringConnectionProperty("trustCertificateKeyStorePassword", null, Messages.getString("ConnectionProperties.trustCertificateKeyStorePassword"), "5.1.0", str, 10);
        this.verifyServerCertificate = new BooleanConnectionProperty("verifyServerCertificate", true, Messages.getString("ConnectionProperties.verifyServerCertificate"), "5.1.6", str, 4);
        this.useAffectedRows = new BooleanConnectionProperty("useAffectedRows", false, Messages.getString("ConnectionProperties.useAffectedRows"), "5.1.7", str2, Integer.MIN_VALUE);
        this.passwordCharacterEncoding = new StringConnectionProperty("passwordCharacterEncoding", null, Messages.getString("ConnectionProperties.passwordCharacterEncoding"), "5.1.7", str, Integer.MIN_VALUE);
        this.maxAllowedPacket = new IntegerConnectionProperty("maxAllowedPacket", -1, Messages.getString("ConnectionProperties.maxAllowedPacket"), "5.1.8", str8, Integer.MIN_VALUE);
        this.authenticationPlugins = new StringConnectionProperty("authenticationPlugins", null, Messages.getString("ConnectionProperties.authenticationPlugins"), "5.1.19", str6, Integer.MIN_VALUE);
        this.disabledAuthenticationPlugins = new StringConnectionProperty("disabledAuthenticationPlugins", null, Messages.getString("ConnectionProperties.disabledAuthenticationPlugins"), "5.1.19", str6, Integer.MIN_VALUE);
        this.defaultAuthenticationPlugin = new StringConnectionProperty("defaultAuthenticationPlugin", "com.mysql.jdbc.authentication.MysqlNativePasswordPlugin", Messages.getString("ConnectionProperties.defaultAuthenticationPlugin"), "5.1.19", str6, Integer.MIN_VALUE);
        this.disconnectOnExpiredPasswords = new BooleanConnectionProperty("disconnectOnExpiredPasswords", true, Messages.getString("ConnectionProperties.disconnectOnExpiredPasswords"), "5.1.23", str6, Integer.MIN_VALUE);
        this.getProceduresReturnsFunctions = new BooleanConnectionProperty("getProceduresReturnsFunctions", true, Messages.getString("ConnectionProperties.getProceduresReturnsFunctions"), "5.1.26", str2, Integer.MIN_VALUE);
        this.detectCustomCollations = new BooleanConnectionProperty("detectCustomCollations", false, Messages.getString("ConnectionProperties.detectCustomCollations"), "5.1.29", str2, Integer.MIN_VALUE);
        this.serverRSAPublicKeyFile = new StringConnectionProperty("serverRSAPublicKeyFile", null, Messages.getString("ConnectionProperties.serverRSAPublicKeyFile"), "5.1.31", str, Integer.MIN_VALUE);
        this.allowPublicKeyRetrieval = new BooleanConnectionProperty("allowPublicKeyRetrieval", false, Messages.getString("ConnectionProperties.allowPublicKeyRetrieval"), "5.1.31", str, Integer.MIN_VALUE);
        this.dontCheckOnDuplicateKeyUpdateInSQL = new BooleanConnectionProperty("dontCheckOnDuplicateKeyUpdateInSQL", false, Messages.getString("ConnectionProperties.dontCheckOnDuplicateKeyUpdateInSQL"), "5.1.32", str3, Integer.MIN_VALUE);
        this.readOnlyPropagatesToServer = new BooleanConnectionProperty("readOnlyPropagatesToServer", true, Messages.getString("ConnectionProperties.readOnlyPropagatesToServer"), "5.1.35", str3, Integer.MIN_VALUE);
        this.enabledSSLCipherSuites = new StringConnectionProperty("enabledSSLCipherSuites", null, Messages.getString("ConnectionProperties.enabledSSLCipherSuites"), "5.1.35", str, 11);
        this.enabledTLSProtocols = new StringConnectionProperty("enabledTLSProtocols", null, Messages.getString("ConnectionProperties.enabledTLSProtocols"), "5.1.44", str, 12);
        this.enableEscapeProcessing = new BooleanConnectionProperty("enableEscapeProcessing", true, Messages.getString("ConnectionProperties.enableEscapeProcessing"), "5.1.37", str3, Integer.MIN_VALUE);
    }

    public static DriverPropertyInfo[] exposeAsDriverPropertyInfo(Properties properties, int i) throws SQLException {
        return new ConnectionPropertiesImpl() { // from class: com.mysql.jdbc.ConnectionPropertiesImpl.1
            private static final long serialVersionUID = 4257801713007640581L;
        }.exposeAsDriverPropertyInfoInternal(properties, i);
    }

    public DriverPropertyInfo[] exposeAsDriverPropertyInfoInternal(Properties properties, int i) throws SQLException {
        initializeProperties(properties);
        int size = PROPERTY_LIST.size() + i;
        DriverPropertyInfo[] driverPropertyInfoArr = new DriverPropertyInfo[size];
        for (int i2 = i; i2 < size; i2++) {
            try {
                ConnectionProperty connectionProperty = (ConnectionProperty) PROPERTY_LIST.get(i2 - i).get(this);
                if (properties != null) {
                    connectionProperty.initializeFrom(properties, getExceptionInterceptor());
                }
                driverPropertyInfoArr[i2] = connectionProperty.getAsDriverPropertyInfo();
            } catch (IllegalAccessException unused) {
                throw SQLError.createSQLException(Messages.getString("ConnectionProperties.InternalPropertiesFailure"), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
            }
        }
        return driverPropertyInfoArr;
    }

    public Properties exposeAsProperties(Properties properties) throws SQLException {
        if (properties == null) {
            properties = new Properties();
        }
        int size = PROPERTY_LIST.size();
        for (int i = 0; i < size; i++) {
            try {
                ConnectionProperty connectionProperty = (ConnectionProperty) PROPERTY_LIST.get(i).get(this);
                Object valueAsObject = connectionProperty.getValueAsObject();
                if (valueAsObject != null) {
                    properties.setProperty(connectionProperty.getPropertyName(), valueAsObject.toString());
                }
            } catch (IllegalAccessException unused) {
                throw SQLError.createSQLException("Internal properties failure", SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
            }
        }
        return properties;
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String exposeAsXml() throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("<ConnectionProperties>");
        int size = PROPERTY_LIST.size();
        int length = PROPERTY_CATEGORIES.length;
        HashMap map = new HashMap();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            map.put(PROPERTY_CATEGORIES[i2], new XmlMap());
        }
        String string = Messages.getString("ConnectionProperties.Username");
        String string2 = Messages.getString("ConnectionProperties.allVersions");
        String str = CONNECTION_AND_AUTH_CATEGORY;
        StringConnectionProperty stringConnectionProperty = new StringConnectionProperty(NonRegisteringDriver.USER_PROPERTY_KEY, null, string, string2, str, ConsoleWindow.StandOutLayoutParams.AUTO_POSITION);
        StringConnectionProperty stringConnectionProperty2 = new StringConnectionProperty(NonRegisteringDriver.PASSWORD_PROPERTY_KEY, null, Messages.getString("ConnectionProperties.Password"), Messages.getString("ConnectionProperties.allVersions"), str, -2147483646);
        XmlMap xmlMap = (XmlMap) map.get(str);
        TreeMap treeMap = new TreeMap();
        treeMap.put(stringConnectionProperty.getPropertyName(), stringConnectionProperty);
        xmlMap.ordered.put(Integer.valueOf(stringConnectionProperty.getOrder()), treeMap);
        TreeMap treeMap2 = new TreeMap();
        treeMap2.put(stringConnectionProperty2.getPropertyName(), stringConnectionProperty2);
        xmlMap.ordered.put(new Integer(stringConnectionProperty2.getOrder()), treeMap2);
        for (int i3 = 0; i3 < size; i3++) {
            try {
                ConnectionProperty connectionProperty = (ConnectionProperty) PROPERTY_LIST.get(i3).get(this);
                XmlMap xmlMap2 = (XmlMap) map.get(connectionProperty.getCategoryName());
                int order = connectionProperty.getOrder();
                if (order == Integer.MIN_VALUE) {
                    xmlMap2.alpha.put(connectionProperty.getPropertyName(), connectionProperty);
                } else {
                    Integer numValueOf = Integer.valueOf(order);
                    Map<String, ConnectionProperty> treeMap3 = xmlMap2.ordered.get(numValueOf);
                    if (treeMap3 == null) {
                        treeMap3 = new TreeMap<>();
                        xmlMap2.ordered.put(numValueOf, treeMap3);
                    }
                    treeMap3.put(connectionProperty.getPropertyName(), connectionProperty);
                }
            } catch (IllegalAccessException unused) {
                throw SQLError.createSQLException("Internal properties failure", SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
            }
        }
        while (i < length) {
            String[] strArr = PROPERTY_CATEGORIES;
            XmlMap xmlMap3 = (XmlMap) map.get(strArr[i]);
            sb.append("\n <PropertyCategory name=\"");
            sb.append(strArr[i]);
            sb.append("\">");
            Iterator<Map<String, ConnectionProperty>> it = xmlMap3.ordered.values().iterator();
            while (it.hasNext()) {
                for (ConnectionProperty connectionProperty2 : it.next().values()) {
                    sb.append("\n  <Property name=\"");
                    Iterator<Map<String, ConnectionProperty>> it2 = it;
                    sb.append(connectionProperty2.getPropertyName());
                    sb.append("\" required=\"");
                    sb.append(connectionProperty2.required ? "Yes" : "No");
                    sb.append("\" default=\"");
                    if (connectionProperty2.getDefaultValue() != null) {
                        sb.append(connectionProperty2.getDefaultValue());
                    }
                    sb.append("\" sortOrder=\"");
                    sb.append(connectionProperty2.getOrder());
                    sb.append("\" since=\"");
                    sb.append(connectionProperty2.sinceVersion);
                    sb.append("\">\n");
                    sb.append("    ");
                    sb.append(connectionProperty2.description.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;"));
                    sb.append("\n  </Property>");
                    it = it2;
                    length = length;
                }
            }
            int i4 = length;
            for (ConnectionProperty connectionProperty3 : xmlMap3.alpha.values()) {
                sb.append("\n  <Property name=\"");
                sb.append(connectionProperty3.getPropertyName());
                sb.append("\" required=\"");
                sb.append(connectionProperty3.required ? "Yes" : "No");
                sb.append("\" default=\"");
                if (connectionProperty3.getDefaultValue() != null) {
                    sb.append(connectionProperty3.getDefaultValue());
                }
                sb.append("\" sortOrder=\"alpha\" since=\"");
                sb.append(connectionProperty3.sinceVersion);
                sb.append("\">\n");
                sb.append("    ");
                sb.append(connectionProperty3.description);
                sb.append("\n  </Property>");
            }
            sb.append("\n </PropertyCategory>");
            i++;
            length = i4;
        }
        sb.append("\n</ConnectionProperties>");
        return sb.toString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAllowLoadLocalInfile() {
        return this.allowLoadLocalInfile.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAllowMasterDownConnections() {
        return this.allowMasterDownConnections.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAllowMultiQueries() {
        return this.allowMultiQueries.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAllowNanAndInf() {
        return this.allowNanAndInf.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAllowPublicKeyRetrieval() {
        return this.allowPublicKeyRetrieval.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAllowSlaveDownConnections() {
        return this.allowSlaveDownConnections.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAllowUrlInLocalInfile() {
        return this.allowUrlInLocalInfile.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAlwaysSendSetIsolation() {
        return this.alwaysSendSetIsolation.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getAuthenticationPlugins() {
        return this.authenticationPlugins.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAutoClosePStmtStreams() {
        return this.autoClosePStmtStreams.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAutoDeserialize() {
        return this.autoDeserialize.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAutoGenerateTestcaseScript() {
        return this.autoGenerateTestcaseScriptAsBoolean;
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAutoReconnectForPools() {
        return this.autoReconnectForPoolsAsBoolean;
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAutoSlowLog() {
        return this.autoSlowLog.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getBlobSendChunkSize() {
        return this.blobSendChunkSize.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getBlobsAreStrings() {
        return this.blobsAreStrings.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCacheCallableStatements() {
        return this.cacheCallableStatements.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCacheCallableStmts() {
        return getCacheCallableStatements();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCacheDefaultTimezone() {
        return this.cacheDefaultTimezone.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCachePrepStmts() {
        return getCachePreparedStatements();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCachePreparedStatements() {
        return ((Boolean) this.cachePreparedStatements.getValueAsObject()).booleanValue();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCacheResultSetMetadata() {
        return this.cacheResultSetMetaDataAsBoolean;
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCacheServerConfiguration() {
        return this.cacheServerConfiguration.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getCallableStatementCacheSize() {
        return this.callableStatementCacheSize.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getCallableStmtCacheSize() {
        return getCallableStatementCacheSize();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCapitalizeTypeNames() {
        return this.capitalizeTypeNames.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getCharacterSetResults() {
        return this.characterSetResults.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getClientCertificateKeyStorePassword() {
        return this.clientCertificateKeyStorePassword.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getClientCertificateKeyStoreType() {
        return this.clientCertificateKeyStoreType.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getClientCertificateKeyStoreUrl() {
        return this.clientCertificateKeyStoreUrl.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getClientInfoProvider() {
        return this.clientInfoProvider.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getClobCharacterEncoding() {
        return this.clobCharacterEncoding.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getClobberStreamingResults() {
        return this.clobberStreamingResults.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCompensateOnDuplicateKeyUpdateCounts() {
        return this.compensateOnDuplicateKeyUpdateCounts.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getConnectTimeout() {
        return this.connectTimeout.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getConnectionAttributes() {
        return this.connectionAttributes.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getConnectionCollation() {
        return this.connectionCollation.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getConnectionLifecycleInterceptors() {
        return this.connectionLifecycleInterceptors.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getContinueBatchOnError() {
        return this.continueBatchOnError.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCreateDatabaseIfNotExist() {
        return this.createDatabaseIfNotExist.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getDefaultAuthenticationPlugin() {
        return this.defaultAuthenticationPlugin.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getDefaultFetchSize() {
        return this.defaultFetchSize.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getDetectCustomCollations() {
        return this.detectCustomCollations.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getDisabledAuthenticationPlugins() {
        return this.disabledAuthenticationPlugins.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getDisconnectOnExpiredPasswords() {
        return this.disconnectOnExpiredPasswords.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getDontCheckOnDuplicateKeyUpdateInSQL() {
        return this.dontCheckOnDuplicateKeyUpdateInSQL.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getDontTrackOpenResources() {
        return this.dontTrackOpenResources.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getDumpMetadataOnColumnNotFound() {
        return this.dumpMetadataOnColumnNotFound.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getDumpQueriesOnException() {
        return this.dumpQueriesOnException.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getDynamicCalendars() {
        return this.dynamicCalendars.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getElideSetAutoCommits() {
        return false;
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getEmptyStringsConvertToZero() {
        return this.emptyStringsConvertToZero.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getEmulateLocators() {
        return this.emulateLocators.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getEmulateUnsupportedPstmts() {
        return this.emulateUnsupportedPstmts.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getEnableEscapeProcessing() {
        return this.enableEscapeProcessing.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getEnablePacketDebug() {
        return this.enablePacketDebug.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getEnableQueryTimeouts() {
        return this.enableQueryTimeouts.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getEnabledSSLCipherSuites() {
        return this.enabledSSLCipherSuites.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getEnabledTLSProtocols() {
        return this.enabledTLSProtocols.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getEncoding() {
        return this.characterEncodingAsString;
    }

    public ExceptionInterceptor getExceptionInterceptor() {
        return null;
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getExceptionInterceptors() {
        return this.exceptionInterceptors.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getExplainSlowQueries() {
        return this.explainSlowQueries.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getFailOverReadOnly() {
        return this.failOverReadOnly.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getFunctionsNeverReturnBlobs() {
        return this.functionsNeverReturnBlobs.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getGatherPerfMetrics() {
        return getGatherPerformanceMetrics();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getGatherPerformanceMetrics() {
        return this.gatherPerformanceMetrics.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getGenerateSimpleParameterMetadata() {
        return this.generateSimpleParameterMetadata.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getGetProceduresReturnsFunctions() {
        return this.getProceduresReturnsFunctions.getValueAsBoolean();
    }

    public boolean getHighAvailability() {
        return this.highAvailabilityAsBoolean;
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getHoldResultsOpenOverStatementClose() {
        return this.holdResultsOpenOverStatementClose.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getIgnoreNonTxTables() {
        return this.ignoreNonTxTables.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getIncludeInnodbStatusInDeadlockExceptions() {
        return this.includeInnodbStatusInDeadlockExceptions.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getIncludeThreadDumpInDeadlockExceptions() {
        return this.includeThreadDumpInDeadlockExceptions.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getIncludeThreadNamesAsStatementComment() {
        return this.includeThreadNamesAsStatementComment.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getInitialTimeout() {
        return this.initialTimeout.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getInteractiveClient() {
        return this.isInteractiveClient.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getIsInteractiveClient() {
        return this.isInteractiveClient.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getJdbcCompliantTruncation() {
        return this.jdbcCompliantTruncation.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getJdbcCompliantTruncationForReads() {
        return this.jdbcCompliantTruncationForReads;
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLargeRowSizeThreshold() {
        return this.largeRowSizeThreshold.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLoadBalanceAutoCommitStatementRegex() {
        return this.loadBalanceAutoCommitStatementRegex.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getLoadBalanceAutoCommitStatementThreshold() {
        return this.loadBalanceAutoCommitStatementThreshold.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getLoadBalanceBlacklistTimeout() {
        return this.loadBalanceBlacklistTimeout.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLoadBalanceConnectionGroup() {
        return this.loadBalanceConnectionGroup.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getLoadBalanceEnableJMX() {
        return this.loadBalanceEnableJMX.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLoadBalanceExceptionChecker() {
        return this.loadBalanceExceptionChecker.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getLoadBalanceHostRemovalGracePeriod() {
        return this.loadBalanceHostRemovalGracePeriod.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getLoadBalancePingTimeout() {
        return this.loadBalancePingTimeout.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLoadBalanceSQLExceptionSubclassFailover() {
        return this.loadBalanceSQLExceptionSubclassFailover.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLoadBalanceSQLStateFailover() {
        return this.loadBalanceSQLStateFailover.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLoadBalanceStrategy() {
        return this.loadBalanceStrategy.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getLoadBalanceValidateConnectionOnSwapServer() {
        return this.loadBalanceValidateConnectionOnSwapServer.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLocalSocketAddress() {
        return this.localSocketAddress.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getLocatorFetchBufferSize() {
        return this.locatorFetchBufferSize.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getLogSlowQueries() {
        return this.logSlowQueries.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getLogXaCommands() {
        return this.logXaCommands.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLogger() {
        return this.loggerClassName.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLoggerClassName() {
        return this.loggerClassName.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getMaintainTimeStats() {
        return this.maintainTimeStatsAsBoolean;
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getMaxAllowedPacket() {
        return this.maxAllowedPacket.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getMaxQuerySizeToLog() {
        return this.maxQuerySizeToLog.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getMaxReconnects() {
        return this.maxReconnects.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getMaxRows() {
        return this.maxRowsAsInt;
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getMetadataCacheSize() {
        return this.metadataCacheSize.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getNetTimeoutForStreamingResults() {
        return this.netTimeoutForStreamingResults.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getNoAccessToProcedureBodies() {
        return this.noAccessToProcedureBodies.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getNoDatetimeStringSync() {
        return this.noDatetimeStringSync.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getNoTimezoneConversionForDateType() {
        return this.noTimezoneConversionForDateType.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getNoTimezoneConversionForTimeType() {
        return this.noTimezoneConversionForTimeType.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getNullCatalogMeansCurrent() {
        return this.nullCatalogMeansCurrent.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getNullNamePatternMatchesAll() {
        return this.nullNamePatternMatchesAll.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getOverrideSupportsIntegrityEnhancementFacility() {
        return this.overrideSupportsIntegrityEnhancementFacility.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getPacketDebugBufferSize() {
        return this.packetDebugBufferSize.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getPadCharsWithSpace() {
        return this.padCharsWithSpace.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getParanoid() {
        return this.paranoid.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getParseInfoCacheFactory() {
        return this.parseInfoCacheFactory.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getPasswordCharacterEncoding() {
        String encoding;
        String valueAsString = this.passwordCharacterEncoding.getValueAsString();
        if (valueAsString != null) {
            return valueAsString;
        }
        return (!getUseUnicode() || (encoding = getEncoding()) == null) ? "UTF-8" : encoding;
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getPedantic() {
        return this.pedantic.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getPinGlobalTxToPhysicalConnection() {
        return this.pinGlobalTxToPhysicalConnection.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getPopulateInsertRowWithDefaultValues() {
        return this.populateInsertRowWithDefaultValues.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getPrepStmtCacheSize() {
        return getPreparedStatementCacheSize();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getPrepStmtCacheSqlLimit() {
        return getPreparedStatementCacheSqlLimit();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getPreparedStatementCacheSize() {
        return ((Integer) this.preparedStatementCacheSize.getValueAsObject()).intValue();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getPreparedStatementCacheSqlLimit() {
        return ((Integer) this.preparedStatementCacheSqlLimit.getValueAsObject()).intValue();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getProcessEscapeCodesForPrepStmts() {
        return this.processEscapeCodesForPrepStmts.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getProfileSQL() {
        return this.profileSQL.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getProfileSql() {
        return this.profileSQLAsBoolean;
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getProfilerEventHandler() {
        return this.profilerEventHandler.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getPropertiesTransform() {
        return this.propertiesTransform.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getQueriesBeforeRetryMaster() {
        return this.queriesBeforeRetryMaster.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getQueryTimeoutKillsConnection() {
        return this.queryTimeoutKillsConnection.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getReadFromMasterWhenNoSlaves() {
        return this.readFromMasterWhenNoSlaves.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getReadOnlyPropagatesToServer() {
        return this.readOnlyPropagatesToServer.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getReconnectAtTxEnd() {
        return this.reconnectTxAtEndAsBoolean;
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getRelaxAutoCommit() {
        return this.relaxAutoCommit.getValueAsBoolean();
    }

    public String getReplicationConnectionGroup() {
        return this.replicationConnectionGroup.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getReplicationEnableJMX() {
        return this.replicationEnableJMX.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getReportMetricsIntervalMillis() {
        return this.reportMetricsIntervalMillis.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getRequireSSL() {
        return this.requireSSL.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getResourceId() {
        return this.resourceId.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getResultSetSizeThreshold() {
        return this.resultSetSizeThreshold.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getRetainStatementAfterResultSetClose() {
        return this.retainStatementAfterResultSetClose.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getRetriesAllDown() {
        return this.retriesAllDown.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getRewriteBatchedStatements() {
        return this.rewriteBatchedStatements.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getRollbackOnPooledClose() {
        return this.rollbackOnPooledClose.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getRoundRobinLoadBalance() {
        return this.roundRobinLoadBalance.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getRunningCTS13() {
        return this.runningCTS13.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getSecondsBeforeRetryMaster() {
        return this.secondsBeforeRetryMaster.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getSelfDestructOnPingMaxOperations() {
        return this.selfDestructOnPingMaxOperations.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getSelfDestructOnPingSecondsLifetime() {
        return this.selfDestructOnPingSecondsLifetime.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getSendFractionalSeconds() {
        return this.sendFractionalSeconds.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getServerAffinityOrder() {
        return this.serverAffinityOrder.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getServerConfigCacheFactory() {
        return this.serverConfigCacheFactory.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getServerRSAPublicKeyFile() {
        return this.serverRSAPublicKeyFile.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getServerTimezone() {
        return this.serverTimezone.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getSessionVariables() {
        return this.sessionVariables.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getSlowQueryThresholdMillis() {
        return this.slowQueryThresholdMillis.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public long getSlowQueryThresholdNanos() {
        return this.slowQueryThresholdNanos.getValueAsLong();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getSocketFactory() {
        return getSocketFactoryClassName();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getSocketFactoryClassName() {
        return this.socketFactoryClassName.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getSocketTimeout() {
        return this.socketTimeout.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getSocksProxyHost() {
        return this.socksProxyHost.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getSocksProxyPort() {
        return this.socksProxyPort.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getStatementInterceptors() {
        return this.statementInterceptors.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getStrictFloatingPoint() {
        return this.strictFloatingPoint.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getStrictUpdates() {
        return this.strictUpdates.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getTcpKeepAlive() {
        return this.tcpKeepAlive.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getTcpNoDelay() {
        return this.tcpNoDelay.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getTcpRcvBuf() {
        return this.tcpRcvBuf.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getTcpSndBuf() {
        return this.tcpSndBuf.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getTcpTrafficClass() {
        return this.tcpTrafficClass.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getTinyInt1isBit() {
        return this.tinyInt1isBit.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getTraceProtocol() {
        return this.traceProtocol.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getTransformedBitIsBoolean() {
        return this.transformedBitIsBoolean.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getTreatUtilDateAsTimestamp() {
        return this.treatUtilDateAsTimestamp.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getTrustCertificateKeyStorePassword() {
        return this.trustCertificateKeyStorePassword.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getTrustCertificateKeyStoreType() {
        return this.trustCertificateKeyStoreType.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getTrustCertificateKeyStoreUrl() {
        return this.trustCertificateKeyStoreUrl.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUltraDevHack() {
        return getUseUltraDevWorkAround();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseAffectedRows() {
        return this.useAffectedRows.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseBlobToStoreUTF8OutsideBMP() {
        return this.useBlobToStoreUTF8OutsideBMP.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseColumnNamesInFindColumn() {
        return this.useColumnNamesInFindColumn.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseCompression() {
        return this.useCompression.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getUseConfigs() {
        return this.useConfigs.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseCursorFetch() {
        return this.useCursorFetch.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseDirectRowUnpack() {
        return this.useDirectRowUnpack.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseDynamicCharsetInfo() {
        return this.useDynamicCharsetInfo.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseFastDateParsing() {
        return this.useFastDateParsing.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseFastIntParsing() {
        return this.useFastIntParsing.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseGmtMillisForDatetimes() {
        return this.useGmtMillisForDatetimes.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseHostsInPrivileges() {
        return this.useHostsInPrivileges.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseInformationSchema() {
        return this.useInformationSchema.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseJDBCCompliantTimezoneShift() {
        return this.useJDBCCompliantTimezoneShift.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseJvmCharsetConverters() {
        return this.useJvmCharsetConverters.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseLegacyDatetimeCode() {
        return this.useLegacyDatetimeCode.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseLocalSessionState() {
        return this.useLocalSessionState.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseLocalTransactionState() {
        return this.useLocalTransactionState.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseNanosForElapsedTime() {
        return this.useNanosForElapsedTime.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseOldAliasMetadataBehavior() {
        return this.useOldAliasMetadataBehavior.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseOldUTF8Behavior() {
        return this.useOldUTF8BehaviorAsBoolean;
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseOnlyServerErrorMessages() {
        return this.useOnlyServerErrorMessages.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseReadAheadInput() {
        return this.useReadAheadInput.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseSSL() {
        return this.useSSL.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseSSPSCompatibleTimezoneShift() {
        return this.useSSPSCompatibleTimezoneShift.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseServerPrepStmts() {
        return getUseServerPreparedStmts();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseServerPreparedStmts() {
        return this.detectServerPreparedStmts.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseSqlStateCodes() {
        return this.useSqlStateCodes.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseStreamLengthsInPrepStmts() {
        return this.useStreamLengthsInPrepStmts.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseTimezone() {
        return this.useTimezone.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseUltraDevWorkAround() {
        return this.useUltraDevWorkAround.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseUnbufferedInput() {
        return this.useUnbufferedInput.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseUnicode() {
        return this.useUnicodeAsBoolean;
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseUsageAdvisor() {
        return this.useUsageAdvisorAsBoolean;
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getUtf8OutsideBmpExcludedColumnNamePattern() {
        return this.utf8OutsideBmpExcludedColumnNamePattern.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getUtf8OutsideBmpIncludedColumnNamePattern() {
        return this.utf8OutsideBmpIncludedColumnNamePattern.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getVerifyServerCertificate() {
        return this.verifyServerCertificate.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getYearIsDateType() {
        return this.yearIsDateType.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getZeroDateTimeBehavior() {
        return this.zeroDateTimeBehavior.getValueAsString();
    }

    public void initializeFromRef(Reference reference) throws SQLException {
        int size = PROPERTY_LIST.size();
        for (int i = 0; i < size; i++) {
            try {
                ConnectionProperty connectionProperty = (ConnectionProperty) PROPERTY_LIST.get(i).get(this);
                if (reference != null) {
                    connectionProperty.initializeFrom(reference, getExceptionInterceptor());
                }
            } catch (IllegalAccessException unused) {
                throw SQLError.createSQLException("Internal properties failure", SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
            }
        }
        postInitialization();
    }

    public void initializeProperties(Properties properties) throws SQLException {
        if (properties != null) {
            String property = properties.getProperty("profileSql");
            if (property != null) {
                properties.put("profileSQL", property);
            }
            Properties properties2 = (Properties) properties.clone();
            properties2.remove(NonRegisteringDriver.HOST_PROPERTY_KEY);
            properties2.remove(NonRegisteringDriver.USER_PROPERTY_KEY);
            properties2.remove(NonRegisteringDriver.PASSWORD_PROPERTY_KEY);
            properties2.remove(NonRegisteringDriver.DBNAME_PROPERTY_KEY);
            properties2.remove(NonRegisteringDriver.PORT_PROPERTY_KEY);
            properties2.remove("profileSql");
            int size = PROPERTY_LIST.size();
            for (int i = 0; i < size; i++) {
                try {
                    ((ConnectionProperty) PROPERTY_LIST.get(i).get(this)).initializeFrom(properties2, getExceptionInterceptor());
                } catch (IllegalAccessException e) {
                    throw SQLError.createSQLException(Messages.getString("ConnectionProperties.unableToInitDriverProperties") + e.toString(), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
                }
            }
            postInitialization();
        }
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean isUseSSLExplicit() {
        return this.useSSL.wasExplicitlySet;
    }

    public void postInitialization() throws SQLException {
        if (this.profileSql.getValueAsObject() != null) {
            this.profileSQL.initializeFrom(this.profileSql.getValueAsObject().toString(), getExceptionInterceptor());
        }
        this.reconnectTxAtEndAsBoolean = ((Boolean) this.reconnectAtTxEnd.getValueAsObject()).booleanValue();
        if (getMaxRows() == 0) {
            this.maxRows.setValueAsObject(-1);
        }
        String str = (String) this.characterEncoding.getValueAsObject();
        if (str != null) {
            try {
                StringUtils.getBytes("abc", str);
            } catch (UnsupportedEncodingException unused) {
                throw SQLError.createSQLException(Messages.getString("ConnectionProperties.unsupportedCharacterEncoding", new Object[]{str}), "0S100", getExceptionInterceptor());
            }
        }
        if (((Boolean) this.cacheResultSetMetadata.getValueAsObject()).booleanValue()) {
            try {
                Class.forName("java.util.LinkedHashMap");
            } catch (ClassNotFoundException unused2) {
                this.cacheResultSetMetadata.setValue(false);
            }
        }
        this.cacheResultSetMetaDataAsBoolean = this.cacheResultSetMetadata.getValueAsBoolean();
        this.useUnicodeAsBoolean = this.useUnicode.getValueAsBoolean();
        this.characterEncodingAsString = (String) this.characterEncoding.getValueAsObject();
        this.highAvailabilityAsBoolean = this.autoReconnect.getValueAsBoolean();
        this.autoReconnectForPoolsAsBoolean = this.autoReconnectForPools.getValueAsBoolean();
        this.maxRowsAsInt = ((Integer) this.maxRows.getValueAsObject()).intValue();
        this.profileSQLAsBoolean = this.profileSQL.getValueAsBoolean();
        this.useUsageAdvisorAsBoolean = this.useUsageAdvisor.getValueAsBoolean();
        this.useOldUTF8BehaviorAsBoolean = this.useOldUTF8Behavior.getValueAsBoolean();
        this.autoGenerateTestcaseScriptAsBoolean = this.autoGenerateTestcaseScript.getValueAsBoolean();
        this.maintainTimeStatsAsBoolean = this.maintainTimeStats.getValueAsBoolean();
        this.jdbcCompliantTruncationForReads = getJdbcCompliantTruncation();
        if (getUseCursorFetch()) {
            setDetectServerPreparedStmts(true);
        }
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAllowLoadLocalInfile(boolean z) {
        this.allowLoadLocalInfile.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAllowMasterDownConnections(boolean z) {
        this.allowMasterDownConnections.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAllowMultiQueries(boolean z) {
        this.allowMultiQueries.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAllowNanAndInf(boolean z) {
        this.allowNanAndInf.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAllowPublicKeyRetrieval(boolean z) throws SQLException {
        if (this.allowPublicKeyRetrieval.getUpdateCount() > 0) {
            throw SQLError.createSQLException(Messages.getString("ConnectionProperties.dynamicChangeIsNotAllowed", new Object[]{"'allowPublicKeyRetrieval'"}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
        }
        this.allowPublicKeyRetrieval.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAllowSlaveDownConnections(boolean z) {
        this.allowSlaveDownConnections.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAllowUrlInLocalInfile(boolean z) {
        this.allowUrlInLocalInfile.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAlwaysSendSetIsolation(boolean z) {
        this.alwaysSendSetIsolation.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAuthenticationPlugins(String str) {
        this.authenticationPlugins.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAutoClosePStmtStreams(boolean z) {
        this.autoClosePStmtStreams.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAutoDeserialize(boolean z) {
        this.autoDeserialize.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAutoGenerateTestcaseScript(boolean z) {
        this.autoGenerateTestcaseScript.setValue(z);
        this.autoGenerateTestcaseScriptAsBoolean = this.autoGenerateTestcaseScript.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAutoReconnect(boolean z) {
        this.autoReconnect.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAutoReconnectForConnectionPools(boolean z) {
        this.autoReconnectForPools.setValue(z);
        this.autoReconnectForPoolsAsBoolean = this.autoReconnectForPools.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAutoReconnectForPools(boolean z) {
        this.autoReconnectForPools.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAutoSlowLog(boolean z) {
        this.autoSlowLog.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setBlobSendChunkSize(String str) throws SQLException {
        this.blobSendChunkSize.setValue(str, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setBlobsAreStrings(boolean z) {
        this.blobsAreStrings.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCacheCallableStatements(boolean z) {
        this.cacheCallableStatements.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCacheCallableStmts(boolean z) {
        setCacheCallableStatements(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCacheDefaultTimezone(boolean z) {
        this.cacheDefaultTimezone.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCachePrepStmts(boolean z) {
        setCachePreparedStatements(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCachePreparedStatements(boolean z) {
        this.cachePreparedStatements.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCacheResultSetMetadata(boolean z) {
        this.cacheResultSetMetadata.setValue(z);
        this.cacheResultSetMetaDataAsBoolean = this.cacheResultSetMetadata.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCacheServerConfiguration(boolean z) {
        this.cacheServerConfiguration.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCallableStatementCacheSize(int i) throws SQLException {
        this.callableStatementCacheSize.setValue(i, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCallableStmtCacheSize(int i) throws SQLException {
        setCallableStatementCacheSize(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCapitalizeDBMDTypes(boolean z) {
        this.capitalizeTypeNames.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCapitalizeTypeNames(boolean z) {
        this.capitalizeTypeNames.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCharacterEncoding(String str) {
        this.characterEncoding.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCharacterSetResults(String str) {
        this.characterSetResults.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setClientCertificateKeyStorePassword(String str) {
        this.clientCertificateKeyStorePassword.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setClientCertificateKeyStoreType(String str) {
        this.clientCertificateKeyStoreType.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setClientCertificateKeyStoreUrl(String str) {
        this.clientCertificateKeyStoreUrl.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setClientInfoProvider(String str) {
        this.clientInfoProvider.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setClobCharacterEncoding(String str) {
        this.clobCharacterEncoding.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setClobberStreamingResults(boolean z) {
        this.clobberStreamingResults.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCompensateOnDuplicateKeyUpdateCounts(boolean z) {
        this.compensateOnDuplicateKeyUpdateCounts.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setConnectTimeout(int i) throws SQLException {
        this.connectTimeout.setValue(i, getExceptionInterceptor());
    }

    public void setConnectionAttributes(String str) {
        this.connectionAttributes.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setConnectionCollation(String str) {
        this.connectionCollation.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setConnectionLifecycleInterceptors(String str) {
        this.connectionLifecycleInterceptors.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setContinueBatchOnError(boolean z) {
        this.continueBatchOnError.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCreateDatabaseIfNotExist(boolean z) {
        this.createDatabaseIfNotExist.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDefaultAuthenticationPlugin(String str) {
        this.defaultAuthenticationPlugin.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDefaultFetchSize(int i) throws SQLException {
        this.defaultFetchSize.setValue(i, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDetectCustomCollations(boolean z) {
        this.detectCustomCollations.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDetectServerPreparedStmts(boolean z) {
        this.detectServerPreparedStmts.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDisabledAuthenticationPlugins(String str) {
        this.disabledAuthenticationPlugins.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDisconnectOnExpiredPasswords(boolean z) {
        this.disconnectOnExpiredPasswords.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDontCheckOnDuplicateKeyUpdateInSQL(boolean z) {
        this.dontCheckOnDuplicateKeyUpdateInSQL.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDontTrackOpenResources(boolean z) {
        this.dontTrackOpenResources.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDumpMetadataOnColumnNotFound(boolean z) {
        this.dumpMetadataOnColumnNotFound.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDumpQueriesOnException(boolean z) {
        this.dumpQueriesOnException.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDynamicCalendars(boolean z) {
        this.dynamicCalendars.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setElideSetAutoCommits(boolean z) {
        this.elideSetAutoCommits.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setEmptyStringsConvertToZero(boolean z) {
        this.emptyStringsConvertToZero.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setEmulateLocators(boolean z) {
        this.emulateLocators.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setEmulateUnsupportedPstmts(boolean z) {
        this.emulateUnsupportedPstmts.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setEnableEscapeProcessing(boolean z) {
        this.enableEscapeProcessing.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setEnablePacketDebug(boolean z) {
        this.enablePacketDebug.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setEnableQueryTimeouts(boolean z) {
        this.enableQueryTimeouts.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setEnabledSSLCipherSuites(String str) {
        this.enabledSSLCipherSuites.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setEnabledTLSProtocols(String str) {
        this.enabledTLSProtocols.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setEncoding(String str) {
        this.characterEncoding.setValue(str);
        this.characterEncodingAsString = this.characterEncoding.getValueAsString();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setExceptionInterceptors(String str) {
        this.exceptionInterceptors.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setExplainSlowQueries(boolean z) {
        this.explainSlowQueries.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setFailOverReadOnly(boolean z) {
        this.failOverReadOnly.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setFunctionsNeverReturnBlobs(boolean z) {
        this.functionsNeverReturnBlobs.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setGatherPerfMetrics(boolean z) {
        setGatherPerformanceMetrics(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setGatherPerformanceMetrics(boolean z) {
        this.gatherPerformanceMetrics.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setGenerateSimpleParameterMetadata(boolean z) {
        this.generateSimpleParameterMetadata.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setGetProceduresReturnsFunctions(boolean z) {
        this.getProceduresReturnsFunctions.setValue(z);
    }

    public void setHighAvailability(boolean z) {
        this.autoReconnect.setValue(z);
        this.highAvailabilityAsBoolean = this.autoReconnect.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setHoldResultsOpenOverStatementClose(boolean z) {
        this.holdResultsOpenOverStatementClose.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setIgnoreNonTxTables(boolean z) {
        this.ignoreNonTxTables.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setIncludeInnodbStatusInDeadlockExceptions(boolean z) {
        this.includeInnodbStatusInDeadlockExceptions.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setIncludeThreadDumpInDeadlockExceptions(boolean z) {
        this.includeThreadDumpInDeadlockExceptions.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setIncludeThreadNamesAsStatementComment(boolean z) {
        this.includeThreadNamesAsStatementComment.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setInitialTimeout(int i) throws SQLException {
        this.initialTimeout.setValue(i, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setInteractiveClient(boolean z) {
        setIsInteractiveClient(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setIsInteractiveClient(boolean z) {
        this.isInteractiveClient.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setJdbcCompliantTruncation(boolean z) {
        this.jdbcCompliantTruncation.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setJdbcCompliantTruncationForReads(boolean z) {
        this.jdbcCompliantTruncationForReads = z;
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLargeRowSizeThreshold(String str) throws SQLException {
        this.largeRowSizeThreshold.setValue(str, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceAutoCommitStatementRegex(String str) {
        this.loadBalanceAutoCommitStatementRegex.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceAutoCommitStatementThreshold(int i) throws SQLException {
        this.loadBalanceAutoCommitStatementThreshold.setValue(i, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceBlacklistTimeout(int i) throws SQLException {
        this.loadBalanceBlacklistTimeout.setValue(i, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceConnectionGroup(String str) {
        this.loadBalanceConnectionGroup.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceEnableJMX(boolean z) {
        this.loadBalanceEnableJMX.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceExceptionChecker(String str) {
        this.loadBalanceExceptionChecker.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceHostRemovalGracePeriod(int i) throws SQLException {
        this.loadBalanceHostRemovalGracePeriod.setValue(i, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalancePingTimeout(int i) throws SQLException {
        this.loadBalancePingTimeout.setValue(i, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceSQLExceptionSubclassFailover(String str) {
        this.loadBalanceSQLExceptionSubclassFailover.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceSQLStateFailover(String str) {
        this.loadBalanceSQLStateFailover.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceStrategy(String str) {
        this.loadBalanceStrategy.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceValidateConnectionOnSwapServer(boolean z) {
        this.loadBalanceValidateConnectionOnSwapServer.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLocalSocketAddress(String str) {
        this.localSocketAddress.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLocatorFetchBufferSize(String str) throws SQLException {
        this.locatorFetchBufferSize.setValue(str, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLogSlowQueries(boolean z) {
        this.logSlowQueries.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLogXaCommands(boolean z) {
        this.logXaCommands.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLogger(String str) {
        this.loggerClassName.setValueAsObject(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoggerClassName(String str) {
        this.loggerClassName.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setMaintainTimeStats(boolean z) {
        this.maintainTimeStats.setValue(z);
        this.maintainTimeStatsAsBoolean = this.maintainTimeStats.getValueAsBoolean();
    }

    public void setMaxAllowedPacket(int i) throws SQLException {
        this.maxAllowedPacket.setValue(i, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setMaxQuerySizeToLog(int i) throws SQLException {
        this.maxQuerySizeToLog.setValue(i, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setMaxReconnects(int i) throws SQLException {
        this.maxReconnects.setValue(i, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setMaxRows(int i) throws SQLException {
        this.maxRows.setValue(i, getExceptionInterceptor());
        this.maxRowsAsInt = this.maxRows.getValueAsInt();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setMetadataCacheSize(int i) throws SQLException {
        this.metadataCacheSize.setValue(i, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setNetTimeoutForStreamingResults(int i) throws SQLException {
        this.netTimeoutForStreamingResults.setValue(i, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setNoAccessToProcedureBodies(boolean z) {
        this.noAccessToProcedureBodies.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setNoDatetimeStringSync(boolean z) {
        this.noDatetimeStringSync.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setNoTimezoneConversionForDateType(boolean z) {
        this.noTimezoneConversionForDateType.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setNoTimezoneConversionForTimeType(boolean z) {
        this.noTimezoneConversionForTimeType.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setNullCatalogMeansCurrent(boolean z) {
        this.nullCatalogMeansCurrent.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setNullNamePatternMatchesAll(boolean z) {
        this.nullNamePatternMatchesAll.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setOverrideSupportsIntegrityEnhancementFacility(boolean z) {
        this.overrideSupportsIntegrityEnhancementFacility.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPacketDebugBufferSize(int i) throws SQLException {
        this.packetDebugBufferSize.setValue(i, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPadCharsWithSpace(boolean z) {
        this.padCharsWithSpace.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setParanoid(boolean z) {
        this.paranoid.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setParseInfoCacheFactory(String str) {
        this.parseInfoCacheFactory.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPasswordCharacterEncoding(String str) {
        this.passwordCharacterEncoding.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPedantic(boolean z) {
        this.pedantic.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPinGlobalTxToPhysicalConnection(boolean z) {
        this.pinGlobalTxToPhysicalConnection.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPopulateInsertRowWithDefaultValues(boolean z) {
        this.populateInsertRowWithDefaultValues.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPrepStmtCacheSize(int i) throws SQLException {
        setPreparedStatementCacheSize(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPrepStmtCacheSqlLimit(int i) throws SQLException {
        setPreparedStatementCacheSqlLimit(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPreparedStatementCacheSize(int i) throws SQLException {
        this.preparedStatementCacheSize.setValue(i, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPreparedStatementCacheSqlLimit(int i) throws SQLException {
        this.preparedStatementCacheSqlLimit.setValue(i, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setProcessEscapeCodesForPrepStmts(boolean z) {
        this.processEscapeCodesForPrepStmts.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setProfileSQL(boolean z) {
        this.profileSQL.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setProfileSql(boolean z) {
        this.profileSQL.setValue(z);
        this.profileSQLAsBoolean = this.profileSQL.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setProfilerEventHandler(String str) {
        this.profilerEventHandler.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPropertiesTransform(String str) {
        this.propertiesTransform.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setQueriesBeforeRetryMaster(int i) throws SQLException {
        this.queriesBeforeRetryMaster.setValue(i, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setQueryTimeoutKillsConnection(boolean z) {
        this.queryTimeoutKillsConnection.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setReadFromMasterWhenNoSlaves(boolean z) {
        this.readFromMasterWhenNoSlaves.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setReadOnlyPropagatesToServer(boolean z) {
        this.readOnlyPropagatesToServer.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setReconnectAtTxEnd(boolean z) {
        this.reconnectAtTxEnd.setValue(z);
        this.reconnectTxAtEndAsBoolean = this.reconnectAtTxEnd.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setRelaxAutoCommit(boolean z) {
        this.relaxAutoCommit.setValue(z);
    }

    public void setReplicationConnectionGroup(String str) {
        this.replicationConnectionGroup.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setReplicationEnableJMX(boolean z) {
        this.replicationEnableJMX.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setReportMetricsIntervalMillis(int i) throws SQLException {
        this.reportMetricsIntervalMillis.setValue(i, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setRequireSSL(boolean z) {
        this.requireSSL.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setResourceId(String str) {
        this.resourceId.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setResultSetSizeThreshold(int i) throws SQLException {
        this.resultSetSizeThreshold.setValue(i, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setRetainStatementAfterResultSetClose(boolean z) {
        this.retainStatementAfterResultSetClose.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setRetriesAllDown(int i) throws SQLException {
        this.retriesAllDown.setValue(i, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setRewriteBatchedStatements(boolean z) {
        this.rewriteBatchedStatements.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setRollbackOnPooledClose(boolean z) {
        this.rollbackOnPooledClose.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setRoundRobinLoadBalance(boolean z) {
        this.roundRobinLoadBalance.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setRunningCTS13(boolean z) {
        this.runningCTS13.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSecondsBeforeRetryMaster(int i) throws SQLException {
        this.secondsBeforeRetryMaster.setValue(i, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSelfDestructOnPingMaxOperations(int i) throws SQLException {
        this.selfDestructOnPingMaxOperations.setValue(i, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSelfDestructOnPingSecondsLifetime(int i) throws SQLException {
        this.selfDestructOnPingSecondsLifetime.setValue(i, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSendFractionalSeconds(boolean z) {
        this.sendFractionalSeconds.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setServerAffinityOrder(String str) {
        this.serverAffinityOrder.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setServerConfigCacheFactory(String str) {
        this.serverConfigCacheFactory.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setServerRSAPublicKeyFile(String str) throws SQLException {
        if (this.serverRSAPublicKeyFile.getUpdateCount() > 0) {
            throw SQLError.createSQLException(Messages.getString("ConnectionProperties.dynamicChangeIsNotAllowed", new Object[]{"'serverRSAPublicKeyFile'"}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
        }
        this.serverRSAPublicKeyFile.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setServerTimezone(String str) {
        this.serverTimezone.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSessionVariables(String str) {
        this.sessionVariables.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSlowQueryThresholdMillis(int i) throws SQLException {
        this.slowQueryThresholdMillis.setValue(i, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSlowQueryThresholdNanos(long j) throws SQLException {
        this.slowQueryThresholdNanos.setValue(j, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSocketFactory(String str) {
        setSocketFactoryClassName(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSocketFactoryClassName(String str) {
        this.socketFactoryClassName.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSocketTimeout(int i) throws SQLException {
        this.socketTimeout.setValue(i, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSocksProxyHost(String str) {
        this.socksProxyHost.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSocksProxyPort(int i) throws SQLException {
        this.socksProxyPort.setValue(i, null);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setStatementInterceptors(String str) {
        this.statementInterceptors.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setStrictFloatingPoint(boolean z) {
        this.strictFloatingPoint.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setStrictUpdates(boolean z) {
        this.strictUpdates.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTcpKeepAlive(boolean z) {
        this.tcpKeepAlive.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTcpNoDelay(boolean z) {
        this.tcpNoDelay.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTcpRcvBuf(int i) throws SQLException {
        this.tcpRcvBuf.setValue(i, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTcpSndBuf(int i) throws SQLException {
        this.tcpSndBuf.setValue(i, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTcpTrafficClass(int i) throws SQLException {
        this.tcpTrafficClass.setValue(i, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTinyInt1isBit(boolean z) {
        this.tinyInt1isBit.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTraceProtocol(boolean z) {
        this.traceProtocol.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTransformedBitIsBoolean(boolean z) {
        this.transformedBitIsBoolean.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTreatUtilDateAsTimestamp(boolean z) {
        this.treatUtilDateAsTimestamp.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTrustCertificateKeyStorePassword(String str) {
        this.trustCertificateKeyStorePassword.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTrustCertificateKeyStoreType(String str) {
        this.trustCertificateKeyStoreType.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTrustCertificateKeyStoreUrl(String str) {
        this.trustCertificateKeyStoreUrl.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUltraDevHack(boolean z) {
        setUseUltraDevWorkAround(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseAffectedRows(boolean z) {
        this.useAffectedRows.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseBlobToStoreUTF8OutsideBMP(boolean z) {
        this.useBlobToStoreUTF8OutsideBMP.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseColumnNamesInFindColumn(boolean z) {
        this.useColumnNamesInFindColumn.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseCompression(boolean z) {
        this.useCompression.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseConfigs(String str) {
        this.useConfigs.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseCursorFetch(boolean z) {
        this.useCursorFetch.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseDirectRowUnpack(boolean z) {
        this.useDirectRowUnpack.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseDynamicCharsetInfo(boolean z) {
        this.useDynamicCharsetInfo.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseFastDateParsing(boolean z) {
        this.useFastDateParsing.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseFastIntParsing(boolean z) {
        this.useFastIntParsing.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseGmtMillisForDatetimes(boolean z) {
        this.useGmtMillisForDatetimes.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseHostsInPrivileges(boolean z) {
        this.useHostsInPrivileges.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseInformationSchema(boolean z) {
        this.useInformationSchema.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseJDBCCompliantTimezoneShift(boolean z) {
        this.useJDBCCompliantTimezoneShift.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseJvmCharsetConverters(boolean z) {
        this.useJvmCharsetConverters.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseLegacyDatetimeCode(boolean z) {
        this.useLegacyDatetimeCode.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseLocalSessionState(boolean z) {
        this.useLocalSessionState.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseLocalTransactionState(boolean z) {
        this.useLocalTransactionState.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseNanosForElapsedTime(boolean z) {
        this.useNanosForElapsedTime.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseOldAliasMetadataBehavior(boolean z) {
        this.useOldAliasMetadataBehavior.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseOldUTF8Behavior(boolean z) {
        this.useOldUTF8Behavior.setValue(z);
        this.useOldUTF8BehaviorAsBoolean = this.useOldUTF8Behavior.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseOnlyServerErrorMessages(boolean z) {
        this.useOnlyServerErrorMessages.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseReadAheadInput(boolean z) {
        this.useReadAheadInput.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseSSL(boolean z) {
        this.useSSL.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseSSPSCompatibleTimezoneShift(boolean z) {
        this.useSSPSCompatibleTimezoneShift.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseServerPrepStmts(boolean z) {
        setUseServerPreparedStmts(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseServerPreparedStmts(boolean z) {
        this.detectServerPreparedStmts.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseSqlStateCodes(boolean z) {
        this.useSqlStateCodes.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseStreamLengthsInPrepStmts(boolean z) {
        this.useStreamLengthsInPrepStmts.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseTimezone(boolean z) {
        this.useTimezone.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseUltraDevWorkAround(boolean z) {
        this.useUltraDevWorkAround.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseUnbufferedInput(boolean z) {
        this.useUnbufferedInput.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseUnicode(boolean z) {
        this.useUnicode.setValue(z);
        this.useUnicodeAsBoolean = this.useUnicode.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseUsageAdvisor(boolean z) {
        this.useUsageAdvisor.setValue(z);
        this.useUsageAdvisorAsBoolean = this.useUsageAdvisor.getValueAsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUtf8OutsideBmpExcludedColumnNamePattern(String str) {
        this.utf8OutsideBmpExcludedColumnNamePattern.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUtf8OutsideBmpIncludedColumnNamePattern(String str) {
        this.utf8OutsideBmpIncludedColumnNamePattern.setValue(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setVerifyServerCertificate(boolean z) {
        this.verifyServerCertificate.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setYearIsDateType(boolean z) {
        this.yearIsDateType.setValue(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setZeroDateTimeBehavior(String str) {
        this.zeroDateTimeBehavior.setValue(str);
    }

    public void storeToRef(Reference reference) throws SQLException {
        int size = PROPERTY_LIST.size();
        for (int i = 0; i < size; i++) {
            try {
                ConnectionProperty connectionProperty = (ConnectionProperty) PROPERTY_LIST.get(i).get(this);
                if (reference != null) {
                    connectionProperty.storeTo(reference);
                }
            } catch (IllegalAccessException unused) {
                throw SQLError.createSQLException(Messages.getString("ConnectionProperties.errorNotExpected"), getExceptionInterceptor());
            }
        }
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean useUnbufferedInput() {
        return this.useUnbufferedInput.getValueAsBoolean();
    }

    public static abstract class ConnectionProperty implements Serializable {
        public static final long serialVersionUID = -6644853639584478367L;
        public String[] allowableValues;
        public String categoryName;
        public Object defaultValue;
        public String description;
        public int lowerBound;
        public int order;
        public String propertyName;
        public boolean required;
        public String sinceVersion;
        public int updateCount;
        public int upperBound;
        public Object valueAsObject;
        public boolean wasExplicitlySet;

        public ConnectionProperty() {
            this.updateCount = 0;
            this.wasExplicitlySet = false;
        }

        public String[] getAllowableValues() {
            return this.allowableValues;
        }

        public DriverPropertyInfo getAsDriverPropertyInfo() {
            DriverPropertyInfo driverPropertyInfo = new DriverPropertyInfo(this.propertyName, null);
            driverPropertyInfo.choices = getAllowableValues();
            Object obj = this.valueAsObject;
            driverPropertyInfo.value = obj != null ? obj.toString() : null;
            driverPropertyInfo.required = this.required;
            driverPropertyInfo.description = this.description;
            return driverPropertyInfo;
        }

        public String getCategoryName() {
            return this.categoryName;
        }

        public Object getDefaultValue() {
            return this.defaultValue;
        }

        public int getLowerBound() {
            return this.lowerBound;
        }

        public int getOrder() {
            return this.order;
        }

        public String getPropertyName() {
            return this.propertyName;
        }

        public int getUpdateCount() {
            return this.updateCount;
        }

        public int getUpperBound() {
            return this.upperBound;
        }

        public Object getValueAsObject() {
            return this.valueAsObject;
        }

        public abstract boolean hasValueConstraints();

        public abstract void initializeFrom(String str, ExceptionInterceptor exceptionInterceptor) throws SQLException;

        public void initializeFrom(Properties properties, ExceptionInterceptor exceptionInterceptor) throws SQLException {
            String property = properties.getProperty(getPropertyName());
            properties.remove(getPropertyName());
            initializeFrom(property, exceptionInterceptor);
        }

        public boolean isExplicitlySet() {
            return this.wasExplicitlySet;
        }

        public abstract boolean isRangeBased();

        public void setCategoryName(String str) {
            this.categoryName = str;
        }

        public void setOrder(int i) {
            this.order = i;
        }

        public void setValueAsObject(Object obj) {
            this.valueAsObject = obj;
            this.updateCount++;
        }

        public void storeTo(Reference reference) {
            if (getValueAsObject() != null) {
                reference.add(new StringRefAddr(getPropertyName(), getValueAsObject().toString()));
            }
        }

        public void validateStringValues(String str, ExceptionInterceptor exceptionInterceptor) throws SQLException {
            String[] allowableValues = getAllowableValues();
            if (str == null || allowableValues == null || allowableValues.length == 0) {
                return;
            }
            for (int i = 0; i < allowableValues.length; i++) {
                if (allowableValues[i] != null && allowableValues[i].equalsIgnoreCase(str)) {
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("The connection property '");
            sb.append(getPropertyName());
            sb.append("' only accepts values of the form: ");
            if (allowableValues.length != 0) {
                sb.append("'");
                sb.append(allowableValues[0]);
                sb.append("'");
                for (int i2 = 1; i2 < allowableValues.length - 1; i2++) {
                    sb.append(", ");
                    sb.append("'");
                    sb.append(allowableValues[i2]);
                    sb.append("'");
                }
                sb.append(" or '");
                sb.append(allowableValues[allowableValues.length - 1]);
                sb.append("'");
            }
            sb.append(". The value '");
            sb.append(str);
            sb.append("' is not in this set.");
            throw SQLError.createSQLException(sb.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
        }

        public ConnectionProperty(String str, Object obj, String[] strArr, int i, int i2, String str2, String str3, String str4, int i3) {
            this.updateCount = 0;
            this.wasExplicitlySet = false;
            this.description = str2;
            this.propertyName = str;
            this.defaultValue = obj;
            this.valueAsObject = obj;
            this.allowableValues = strArr;
            this.lowerBound = i;
            this.upperBound = i2;
            this.required = false;
            this.sinceVersion = str3;
            this.categoryName = str4;
            this.order = i3;
        }

        public void initializeFrom(Reference reference, ExceptionInterceptor exceptionInterceptor) throws SQLException {
            RefAddr refAddr = reference.get(getPropertyName());
            if (refAddr != null) {
                initializeFrom((String) refAddr.getContent(), exceptionInterceptor);
            }
        }
    }

    public Properties exposeAsProperties(Properties properties, boolean z) throws SQLException {
        if (properties == null) {
            properties = new Properties();
        }
        int size = PROPERTY_LIST.size();
        for (int i = 0; i < size; i++) {
            try {
                ConnectionProperty connectionProperty = (ConnectionProperty) PROPERTY_LIST.get(i).get(this);
                Object valueAsObject = connectionProperty.getValueAsObject();
                if (valueAsObject != null && (!z || connectionProperty.isExplicitlySet())) {
                    properties.setProperty(connectionProperty.getPropertyName(), valueAsObject.toString());
                }
            } catch (IllegalAccessException e) {
                throw SQLError.createSQLException("Internal properties failure", SQLError.SQL_STATE_GENERAL_ERROR, e, getExceptionInterceptor());
            }
        }
        return properties;
    }
}
