package com.mysql.jdbc;

import com.mysql.jdbc.log.Log;
import com.mysql.jdbc.profiler.ProfilerEventHandler;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Savepoint;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.Timer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class MultiHostMySQLConnection implements MySQLConnection {
    public MultiHostConnectionProxy thisAsProxy;

    public MultiHostMySQLConnection(MultiHostConnectionProxy multiHostConnectionProxy) {
        this.thisAsProxy = multiHostConnectionProxy;
    }

    @Override // com.mysql.jdbc.Connection
    public void abort(Executor executor) throws SQLException {
        getActiveMySQLConnection().abort(executor);
    }

    @Override // com.mysql.jdbc.Connection
    public void abortInternal() throws SQLException {
        getActiveMySQLConnection().abortInternal();
    }

    @Override // com.mysql.jdbc.Connection
    public void changeUser(String str, String str2) throws SQLException {
        getActiveMySQLConnection().changeUser(str, str2);
    }

    @Override // com.mysql.jdbc.Connection
    public void checkClosed() throws SQLException {
        getActiveMySQLConnection().checkClosed();
    }

    @Override // com.mysql.jdbc.Connection
    @Deprecated
    public void clearHasTriedMaster() {
        getActiveMySQLConnection().clearHasTriedMaster();
    }

    @Override // java.sql.Connection
    public void clearWarnings() throws SQLException {
        getActiveMySQLConnection().clearWarnings();
    }

    @Override // com.mysql.jdbc.Connection
    public java.sql.PreparedStatement clientPrepareStatement(String str, int i, int i2, int i3) throws SQLException {
        return getActiveMySQLConnection().clientPrepareStatement(str, i, i2, i3);
    }

    @Override // java.sql.Connection, java.lang.AutoCloseable
    public void close() throws SQLException {
        getActiveMySQLConnection().close();
    }

    @Override // java.sql.Connection
    public void commit() throws SQLException {
        getActiveMySQLConnection().commit();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void createNewIO(boolean z) throws SQLException {
        getActiveMySQLConnection().createNewIO(z);
    }

    @Override // java.sql.Connection
    public java.sql.Statement createStatement() throws SQLException {
        return getActiveMySQLConnection().createStatement();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void decachePreparedStatement(ServerPreparedStatement serverPreparedStatement) throws SQLException {
        getActiveMySQLConnection().decachePreparedStatement(serverPreparedStatement);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void dumpTestcaseQuery(String str) {
        getActiveMySQLConnection().dumpTestcaseQuery(str);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public Connection duplicate() throws SQLException {
        return getActiveMySQLConnection().duplicate();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public ResultSetInternalMethods execSQL(StatementImpl statementImpl, String str, int i, Buffer buffer, int i2, int i3, boolean z, String str2, Field[] fieldArr, boolean z2) throws SQLException {
        return getActiveMySQLConnection().execSQL(statementImpl, str, i, buffer, i2, i3, z, str2, fieldArr, z2);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String exposeAsXml() throws SQLException {
        return getActiveMySQLConnection().exposeAsXml();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public String extractSqlFromPacket(String str, Buffer buffer, int i) throws SQLException {
        return getActiveMySQLConnection().extractSqlFromPacket(str, buffer, i);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public StringBuilder generateConnectionCommentBlock(StringBuilder sb) {
        return getActiveMySQLConnection().generateConnectionCommentBlock(sb);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public MySQLConnection getActiveMySQLConnection() {
        MySQLConnection mySQLConnection;
        synchronized (this.thisAsProxy) {
            mySQLConnection = this.thisAsProxy.currentConnection;
        }
        return mySQLConnection;
    }

    @Override // com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public int getActiveStatementCount() {
        return getActiveMySQLConnection().getActiveStatementCount();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAllowLoadLocalInfile() {
        return getActiveMySQLConnection().getAllowLoadLocalInfile();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAllowMasterDownConnections() {
        return getActiveMySQLConnection().getAllowMasterDownConnections();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAllowMultiQueries() {
        return getActiveMySQLConnection().getAllowMultiQueries();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAllowNanAndInf() {
        return getActiveMySQLConnection().getAllowNanAndInf();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAllowPublicKeyRetrieval() {
        return getActiveMySQLConnection().getAllowPublicKeyRetrieval();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAllowSlaveDownConnections() {
        return getActiveMySQLConnection().getAllowSlaveDownConnections();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAllowUrlInLocalInfile() {
        return getActiveMySQLConnection().getAllowUrlInLocalInfile();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAlwaysSendSetIsolation() {
        return getActiveMySQLConnection().getAlwaysSendSetIsolation();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getAuthenticationPlugins() {
        return getActiveMySQLConnection().getAuthenticationPlugins();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAutoClosePStmtStreams() {
        return getActiveMySQLConnection().getAutoClosePStmtStreams();
    }

    @Override // java.sql.Connection
    public boolean getAutoCommit() throws SQLException {
        return getActiveMySQLConnection().getAutoCommit();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAutoDeserialize() {
        return getActiveMySQLConnection().getAutoDeserialize();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAutoGenerateTestcaseScript() {
        return getActiveMySQLConnection().getAutoGenerateTestcaseScript();
    }

    @Override // com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public int getAutoIncrementIncrement() {
        return getActiveMySQLConnection().getAutoIncrementIncrement();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAutoReconnectForPools() {
        return getActiveMySQLConnection().getAutoReconnectForPools();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAutoSlowLog() {
        return getActiveMySQLConnection().getAutoSlowLog();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getBlobSendChunkSize() {
        return getActiveMySQLConnection().getBlobSendChunkSize();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getBlobsAreStrings() {
        return getActiveMySQLConnection().getBlobsAreStrings();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCacheCallableStatements() {
        return getActiveMySQLConnection().getCacheCallableStatements();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCacheCallableStmts() {
        return getActiveMySQLConnection().getCacheCallableStmts();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCacheDefaultTimezone() {
        return getActiveMySQLConnection().getCacheDefaultTimezone();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCachePrepStmts() {
        return getActiveMySQLConnection().getCachePrepStmts();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCachePreparedStatements() {
        return getActiveMySQLConnection().getCachePreparedStatements();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCacheResultSetMetadata() {
        return getActiveMySQLConnection().getCacheResultSetMetadata();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCacheServerConfiguration() {
        return getActiveMySQLConnection().getCacheServerConfiguration();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public CachedResultSetMetaData getCachedMetaData(String str) {
        return getActiveMySQLConnection().getCachedMetaData(str);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public Calendar getCalendarInstanceForSessionOrNew() {
        return getActiveMySQLConnection().getCalendarInstanceForSessionOrNew();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getCallableStatementCacheSize() {
        return getActiveMySQLConnection().getCallableStatementCacheSize();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getCallableStmtCacheSize() {
        return getActiveMySQLConnection().getCallableStmtCacheSize();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public Timer getCancelTimer() {
        return getActiveMySQLConnection().getCancelTimer();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCapitalizeTypeNames() {
        return getActiveMySQLConnection().getCapitalizeTypeNames();
    }

    @Override // java.sql.Connection
    public String getCatalog() throws SQLException {
        return getActiveMySQLConnection().getCatalog();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public String getCharacterSetMetadata() {
        return getActiveMySQLConnection().getCharacterSetMetadata();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getCharacterSetResults() {
        return getActiveMySQLConnection().getCharacterSetResults();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public SingleByteCharsetConverter getCharsetConverter(String str) throws SQLException {
        return getActiveMySQLConnection().getCharsetConverter(str);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    @Deprecated
    public String getCharsetNameForIndex(int i) throws SQLException {
        return getEncodingForIndex(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getClientCertificateKeyStorePassword() {
        return getActiveMySQLConnection().getClientCertificateKeyStorePassword();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getClientCertificateKeyStoreType() {
        return getActiveMySQLConnection().getClientCertificateKeyStoreType();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getClientCertificateKeyStoreUrl() {
        return getActiveMySQLConnection().getClientCertificateKeyStoreUrl();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getClientInfoProvider() {
        return getActiveMySQLConnection().getClientInfoProvider();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getClobCharacterEncoding() {
        return getActiveMySQLConnection().getClobCharacterEncoding();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getClobberStreamingResults() {
        return getActiveMySQLConnection().getClobberStreamingResults();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCompensateOnDuplicateKeyUpdateCounts() {
        return getActiveMySQLConnection().getCompensateOnDuplicateKeyUpdateCounts();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getConnectTimeout() {
        return getActiveMySQLConnection().getConnectTimeout();
    }

    @Override // com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.ConnectionProperties
    public String getConnectionAttributes() throws SQLException {
        return getActiveMySQLConnection().getConnectionAttributes();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getConnectionCollation() {
        return getActiveMySQLConnection().getConnectionCollation();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getConnectionLifecycleInterceptors() {
        return getActiveMySQLConnection().getConnectionLifecycleInterceptors();
    }

    @Override // com.mysql.jdbc.Connection
    public Object getConnectionMutex() {
        return getActiveMySQLConnection().getConnectionMutex();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getContinueBatchOnError() {
        return getActiveMySQLConnection().getContinueBatchOnError();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCreateDatabaseIfNotExist() {
        return getActiveMySQLConnection().getCreateDatabaseIfNotExist();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getDefaultAuthenticationPlugin() {
        return getActiveMySQLConnection().getDefaultAuthenticationPlugin();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getDefaultFetchSize() {
        return getActiveMySQLConnection().getDefaultFetchSize();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public TimeZone getDefaultTimeZone() {
        return getActiveMySQLConnection().getDefaultTimeZone();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getDetectCustomCollations() {
        return getActiveMySQLConnection().getDetectCustomCollations();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getDisabledAuthenticationPlugins() {
        return getActiveMySQLConnection().getDisabledAuthenticationPlugins();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getDisconnectOnExpiredPasswords() {
        return getActiveMySQLConnection().getDisconnectOnExpiredPasswords();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getDontCheckOnDuplicateKeyUpdateInSQL() {
        return getActiveMySQLConnection().getDontCheckOnDuplicateKeyUpdateInSQL();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getDontTrackOpenResources() {
        return getActiveMySQLConnection().getDontTrackOpenResources();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getDumpMetadataOnColumnNotFound() {
        return getActiveMySQLConnection().getDumpMetadataOnColumnNotFound();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getDumpQueriesOnException() {
        return getActiveMySQLConnection().getDumpQueriesOnException();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getDynamicCalendars() {
        return getActiveMySQLConnection().getDynamicCalendars();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getElideSetAutoCommits() {
        return getActiveMySQLConnection().getElideSetAutoCommits();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getEmptyStringsConvertToZero() {
        return getActiveMySQLConnection().getEmptyStringsConvertToZero();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getEmulateLocators() {
        return getActiveMySQLConnection().getEmulateLocators();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getEmulateUnsupportedPstmts() {
        return getActiveMySQLConnection().getEmulateUnsupportedPstmts();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getEnableEscapeProcessing() {
        return getActiveMySQLConnection().getEnableEscapeProcessing();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getEnablePacketDebug() {
        return getActiveMySQLConnection().getEnablePacketDebug();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getEnableQueryTimeouts() {
        return getActiveMySQLConnection().getEnableQueryTimeouts();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getEnabledSSLCipherSuites() {
        return getActiveMySQLConnection().getEnabledSSLCipherSuites();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getEnabledTLSProtocols() {
        return getActiveMySQLConnection().getEnabledTLSProtocols();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getEncoding() {
        return getActiveMySQLConnection().getEncoding();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public String getEncodingForIndex(int i) throws SQLException {
        return getActiveMySQLConnection().getEncodingForIndex(i);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public String getErrorMessageEncoding() {
        return getActiveMySQLConnection().getErrorMessageEncoding();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public ExceptionInterceptor getExceptionInterceptor() {
        return getActiveMySQLConnection().getExceptionInterceptor();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getExceptionInterceptors() {
        return getActiveMySQLConnection().getExceptionInterceptors();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getExplainSlowQueries() {
        return getActiveMySQLConnection().getExplainSlowQueries();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getFailOverReadOnly() {
        return getActiveMySQLConnection().getFailOverReadOnly();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getFunctionsNeverReturnBlobs() {
        return getActiveMySQLConnection().getFunctionsNeverReturnBlobs();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getGatherPerfMetrics() {
        return getActiveMySQLConnection().getGatherPerfMetrics();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getGatherPerformanceMetrics() {
        return getActiveMySQLConnection().getGatherPerformanceMetrics();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getGenerateSimpleParameterMetadata() {
        return getActiveMySQLConnection().getGenerateSimpleParameterMetadata();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getGetProceduresReturnsFunctions() {
        return getActiveMySQLConnection().getGetProceduresReturnsFunctions();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getHoldResultsOpenOverStatementClose() {
        return getActiveMySQLConnection().getHoldResultsOpenOverStatementClose();
    }

    @Override // java.sql.Connection
    public int getHoldability() throws SQLException {
        return getActiveMySQLConnection().getHoldability();
    }

    @Override // com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public String getHost() {
        return getActiveMySQLConnection().getHost();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public String getHostPortPair() {
        return getActiveMySQLConnection().getHostPortPair();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public MysqlIO getIO() throws SQLException {
        return getActiveMySQLConnection().getIO();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public long getId() {
        return getActiveMySQLConnection().getId();
    }

    @Override // com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public long getIdleFor() {
        return getActiveMySQLConnection().getIdleFor();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getIgnoreNonTxTables() {
        return getActiveMySQLConnection().getIgnoreNonTxTables();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getIncludeInnodbStatusInDeadlockExceptions() {
        return getActiveMySQLConnection().getIncludeInnodbStatusInDeadlockExceptions();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getIncludeThreadDumpInDeadlockExceptions() {
        return getActiveMySQLConnection().getIncludeThreadDumpInDeadlockExceptions();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getIncludeThreadNamesAsStatementComment() {
        return getActiveMySQLConnection().getIncludeThreadNamesAsStatementComment();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getInitialTimeout() {
        return getActiveMySQLConnection().getInitialTimeout();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getInteractiveClient() {
        return getActiveMySQLConnection().getInteractiveClient();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getIsInteractiveClient() {
        return getActiveMySQLConnection().getIsInteractiveClient();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getJdbcCompliantTruncation() {
        return getActiveMySQLConnection().getJdbcCompliantTruncation();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getJdbcCompliantTruncationForReads() {
        return getActiveMySQLConnection().getJdbcCompliantTruncationForReads();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLargeRowSizeThreshold() {
        return getActiveMySQLConnection().getLargeRowSizeThreshold();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLoadBalanceAutoCommitStatementRegex() {
        return getActiveMySQLConnection().getLoadBalanceAutoCommitStatementRegex();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getLoadBalanceAutoCommitStatementThreshold() {
        return getActiveMySQLConnection().getLoadBalanceAutoCommitStatementThreshold();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getLoadBalanceBlacklistTimeout() {
        return getActiveMySQLConnection().getLoadBalanceBlacklistTimeout();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLoadBalanceConnectionGroup() {
        return getActiveMySQLConnection().getLoadBalanceConnectionGroup();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getLoadBalanceEnableJMX() {
        return getActiveMySQLConnection().getLoadBalanceEnableJMX();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLoadBalanceExceptionChecker() {
        return getActiveMySQLConnection().getLoadBalanceExceptionChecker();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getLoadBalanceHostRemovalGracePeriod() {
        return getActiveMySQLConnection().getLoadBalanceHostRemovalGracePeriod();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getLoadBalancePingTimeout() {
        return getActiveMySQLConnection().getLoadBalancePingTimeout();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLoadBalanceSQLExceptionSubclassFailover() {
        return getActiveMySQLConnection().getLoadBalanceSQLExceptionSubclassFailover();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLoadBalanceSQLStateFailover() {
        return getActiveMySQLConnection().getLoadBalanceSQLStateFailover();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    @Deprecated
    public MySQLConnection getLoadBalanceSafeProxy() {
        return getMultiHostSafeProxy();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLoadBalanceStrategy() {
        return getActiveMySQLConnection().getLoadBalanceStrategy();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getLoadBalanceValidateConnectionOnSwapServer() {
        return getActiveMySQLConnection().getLoadBalanceValidateConnectionOnSwapServer();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLocalSocketAddress() {
        return getActiveMySQLConnection().getLocalSocketAddress();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getLocatorFetchBufferSize() {
        return getActiveMySQLConnection().getLocatorFetchBufferSize();
    }

    @Override // com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public Log getLog() throws SQLException {
        return getActiveMySQLConnection().getLog();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getLogSlowQueries() {
        return getActiveMySQLConnection().getLogSlowQueries();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getLogXaCommands() {
        return getActiveMySQLConnection().getLogXaCommands();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLogger() {
        return getActiveMySQLConnection().getLogger();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLoggerClassName() {
        return getActiveMySQLConnection().getLoggerClassName();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getMaintainTimeStats() {
        return getActiveMySQLConnection().getMaintainTimeStats();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getMaxAllowedPacket() {
        return getActiveMySQLConnection().getMaxAllowedPacket();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public int getMaxBytesPerChar(String str) throws SQLException {
        return getActiveMySQLConnection().getMaxBytesPerChar(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getMaxQuerySizeToLog() {
        return getActiveMySQLConnection().getMaxQuerySizeToLog();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getMaxReconnects() {
        return getActiveMySQLConnection().getMaxReconnects();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getMaxRows() {
        return getActiveMySQLConnection().getMaxRows();
    }

    @Override // java.sql.Connection
    public java.sql.DatabaseMetaData getMetaData() throws SQLException {
        return getActiveMySQLConnection().getMetaData();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getMetadataCacheSize() {
        return getActiveMySQLConnection().getMetadataCacheSize();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public java.sql.Statement getMetadataSafeStatement() throws SQLException {
        return getActiveMySQLConnection().getMetadataSafeStatement();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public MySQLConnection getMultiHostSafeProxy() {
        return getThisAsProxy().getProxy();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public int getNetBufferLength() {
        return getActiveMySQLConnection().getNetBufferLength();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getNetTimeoutForStreamingResults() {
        return getActiveMySQLConnection().getNetTimeoutForStreamingResults();
    }

    @Override // com.mysql.jdbc.Connection
    public int getNetworkTimeout() throws SQLException {
        return getActiveMySQLConnection().getNetworkTimeout();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getNoAccessToProcedureBodies() {
        return getActiveMySQLConnection().getNoAccessToProcedureBodies();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getNoDatetimeStringSync() {
        return getActiveMySQLConnection().getNoDatetimeStringSync();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getNoTimezoneConversionForDateType() {
        return getActiveMySQLConnection().getNoTimezoneConversionForDateType();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getNoTimezoneConversionForTimeType() {
        return getActiveMySQLConnection().getNoTimezoneConversionForTimeType();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getNullCatalogMeansCurrent() {
        return getActiveMySQLConnection().getNullCatalogMeansCurrent();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getNullNamePatternMatchesAll() {
        return getActiveMySQLConnection().getNullNamePatternMatchesAll();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getOverrideSupportsIntegrityEnhancementFacility() {
        return getActiveMySQLConnection().getOverrideSupportsIntegrityEnhancementFacility();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getPacketDebugBufferSize() {
        return getActiveMySQLConnection().getPacketDebugBufferSize();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getPadCharsWithSpace() {
        return getActiveMySQLConnection().getPadCharsWithSpace();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getParanoid() {
        return getActiveMySQLConnection().getParanoid();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getParseInfoCacheFactory() {
        return getActiveMySQLConnection().getParseInfoCacheFactory();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getPasswordCharacterEncoding() {
        return getActiveMySQLConnection().getPasswordCharacterEncoding();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getPedantic() {
        return getActiveMySQLConnection().getPedantic();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getPinGlobalTxToPhysicalConnection() {
        return getActiveMySQLConnection().getPinGlobalTxToPhysicalConnection();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getPopulateInsertRowWithDefaultValues() {
        return getActiveMySQLConnection().getPopulateInsertRowWithDefaultValues();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getPrepStmtCacheSize() {
        return getActiveMySQLConnection().getPrepStmtCacheSize();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getPrepStmtCacheSqlLimit() {
        return getActiveMySQLConnection().getPrepStmtCacheSqlLimit();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getPreparedStatementCacheSize() {
        return getActiveMySQLConnection().getPreparedStatementCacheSize();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getPreparedStatementCacheSqlLimit() {
        return getActiveMySQLConnection().getPreparedStatementCacheSqlLimit();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getProcessEscapeCodesForPrepStmts() {
        return getActiveMySQLConnection().getProcessEscapeCodesForPrepStmts();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getProfileSQL() {
        return getActiveMySQLConnection().getProfileSQL();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getProfileSql() {
        return getActiveMySQLConnection().getProfileSql();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getProfilerEventHandler() {
        return getActiveMySQLConnection().getProfilerEventHandler();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public ProfilerEventHandler getProfilerEventHandlerInstance() {
        return getActiveMySQLConnection().getProfilerEventHandlerInstance();
    }

    @Override // com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public Properties getProperties() {
        return getActiveMySQLConnection().getProperties();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getPropertiesTransform() {
        return getActiveMySQLConnection().getPropertiesTransform();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getQueriesBeforeRetryMaster() {
        return getActiveMySQLConnection().getQueriesBeforeRetryMaster();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getQueryTimeoutKillsConnection() {
        return getActiveMySQLConnection().getQueryTimeoutKillsConnection();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getReadFromMasterWhenNoSlaves() {
        return getActiveMySQLConnection().getReadFromMasterWhenNoSlaves();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getReadOnlyPropagatesToServer() {
        return getActiveMySQLConnection().getReadOnlyPropagatesToServer();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getReconnectAtTxEnd() {
        return getActiveMySQLConnection().getReconnectAtTxEnd();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getRelaxAutoCommit() {
        return getActiveMySQLConnection().getRelaxAutoCommit();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getReplicationEnableJMX() {
        return getActiveMySQLConnection().getReplicationEnableJMX();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getReportMetricsIntervalMillis() {
        return getActiveMySQLConnection().getReportMetricsIntervalMillis();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getRequireSSL() {
        return getActiveMySQLConnection().getRequireSSL();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public boolean getRequiresEscapingEncoder() {
        return getActiveMySQLConnection().getRequiresEscapingEncoder();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getResourceId() {
        return getActiveMySQLConnection().getResourceId();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getResultSetSizeThreshold() {
        return getActiveMySQLConnection().getResultSetSizeThreshold();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getRetainStatementAfterResultSetClose() {
        return getActiveMySQLConnection().getRetainStatementAfterResultSetClose();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getRetriesAllDown() {
        return getActiveMySQLConnection().getRetriesAllDown();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getRewriteBatchedStatements() {
        return getActiveMySQLConnection().getRewriteBatchedStatements();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getRollbackOnPooledClose() {
        return getActiveMySQLConnection().getRollbackOnPooledClose();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getRoundRobinLoadBalance() {
        return getActiveMySQLConnection().getRoundRobinLoadBalance();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getRunningCTS13() {
        return getActiveMySQLConnection().getRunningCTS13();
    }

    @Override // com.mysql.jdbc.Connection
    public String getSchema() throws SQLException {
        return getActiveMySQLConnection().getSchema();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getSecondsBeforeRetryMaster() {
        return getActiveMySQLConnection().getSecondsBeforeRetryMaster();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getSelfDestructOnPingMaxOperations() {
        return getActiveMySQLConnection().getSelfDestructOnPingMaxOperations();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getSelfDestructOnPingSecondsLifetime() {
        return getActiveMySQLConnection().getSelfDestructOnPingSecondsLifetime();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getSendFractionalSeconds() {
        return getActiveMySQLConnection().getSendFractionalSeconds();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getServerAffinityOrder() {
        return getActiveMySQLConnection().getServerAffinityOrder();
    }

    @Override // com.mysql.jdbc.Connection
    @Deprecated
    public String getServerCharacterEncoding() {
        return getServerCharset();
    }

    @Override // com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public String getServerCharset() {
        return getActiveMySQLConnection().getServerCharset();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getServerConfigCacheFactory() {
        return getActiveMySQLConnection().getServerConfigCacheFactory();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public int getServerMajorVersion() {
        return getActiveMySQLConnection().getServerMajorVersion();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public int getServerMinorVersion() {
        return getActiveMySQLConnection().getServerMinorVersion();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getServerRSAPublicKeyFile() {
        return getActiveMySQLConnection().getServerRSAPublicKeyFile();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public int getServerSubMinorVersion() {
        return getActiveMySQLConnection().getServerSubMinorVersion();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getServerTimezone() {
        return getActiveMySQLConnection().getServerTimezone();
    }

    @Override // com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public TimeZone getServerTimezoneTZ() {
        return getActiveMySQLConnection().getServerTimezoneTZ();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public String getServerVariable(String str) {
        return getActiveMySQLConnection().getServerVariable(str);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public String getServerVersion() {
        return getActiveMySQLConnection().getServerVersion();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public Calendar getSessionLockedCalendar() {
        return getActiveMySQLConnection().getSessionLockedCalendar();
    }

    @Override // com.mysql.jdbc.Connection
    public int getSessionMaxRows() {
        return getActiveMySQLConnection().getSessionMaxRows();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getSessionVariables() {
        return getActiveMySQLConnection().getSessionVariables();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getSlowQueryThresholdMillis() {
        return getActiveMySQLConnection().getSlowQueryThresholdMillis();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public long getSlowQueryThresholdNanos() {
        return getActiveMySQLConnection().getSlowQueryThresholdNanos();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getSocketFactory() {
        return getActiveMySQLConnection().getSocketFactory();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getSocketFactoryClassName() {
        return getActiveMySQLConnection().getSocketFactoryClassName();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getSocketTimeout() {
        return getActiveMySQLConnection().getSocketTimeout();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getSocksProxyHost() {
        return getActiveMySQLConnection().getSocksProxyHost();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getSocksProxyPort() {
        return getActiveMySQLConnection().getSocksProxyPort();
    }

    @Override // com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public String getStatementComment() {
        return getActiveMySQLConnection().getStatementComment();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getStatementInterceptors() {
        return getActiveMySQLConnection().getStatementInterceptors();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public List<StatementInterceptorV2> getStatementInterceptorsInstances() {
        return getActiveMySQLConnection().getStatementInterceptorsInstances();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getStrictFloatingPoint() {
        return getActiveMySQLConnection().getStrictFloatingPoint();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getStrictUpdates() {
        return getActiveMySQLConnection().getStrictUpdates();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getTcpKeepAlive() {
        return getActiveMySQLConnection().getTcpKeepAlive();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getTcpNoDelay() {
        return getActiveMySQLConnection().getTcpNoDelay();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getTcpRcvBuf() {
        return getActiveMySQLConnection().getTcpRcvBuf();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getTcpSndBuf() {
        return getActiveMySQLConnection().getTcpSndBuf();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getTcpTrafficClass() {
        return getActiveMySQLConnection().getTcpTrafficClass();
    }

    public MultiHostConnectionProxy getThisAsProxy() {
        return this.thisAsProxy;
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getTinyInt1isBit() {
        return getActiveMySQLConnection().getTinyInt1isBit();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getTraceProtocol() {
        return getActiveMySQLConnection().getTraceProtocol();
    }

    @Override // java.sql.Connection
    public int getTransactionIsolation() throws SQLException {
        return getActiveMySQLConnection().getTransactionIsolation();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getTransformedBitIsBoolean() {
        return getActiveMySQLConnection().getTransformedBitIsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getTreatUtilDateAsTimestamp() {
        return getActiveMySQLConnection().getTreatUtilDateAsTimestamp();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getTrustCertificateKeyStorePassword() {
        return getActiveMySQLConnection().getTrustCertificateKeyStorePassword();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getTrustCertificateKeyStoreType() {
        return getActiveMySQLConnection().getTrustCertificateKeyStoreType();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getTrustCertificateKeyStoreUrl() {
        return getActiveMySQLConnection().getTrustCertificateKeyStoreUrl();
    }

    @Override // java.sql.Connection
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return getActiveMySQLConnection().getTypeMap();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public String getURL() {
        return getActiveMySQLConnection().getURL();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUltraDevHack() {
        return getActiveMySQLConnection().getUltraDevHack();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseAffectedRows() {
        return getActiveMySQLConnection().getUseAffectedRows();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseBlobToStoreUTF8OutsideBMP() {
        return getActiveMySQLConnection().getUseBlobToStoreUTF8OutsideBMP();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseColumnNamesInFindColumn() {
        return getActiveMySQLConnection().getUseColumnNamesInFindColumn();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseCompression() {
        return getActiveMySQLConnection().getUseCompression();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getUseConfigs() {
        return getActiveMySQLConnection().getUseConfigs();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseCursorFetch() {
        return getActiveMySQLConnection().getUseCursorFetch();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseDirectRowUnpack() {
        return getActiveMySQLConnection().getUseDirectRowUnpack();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseDynamicCharsetInfo() {
        return getActiveMySQLConnection().getUseDynamicCharsetInfo();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseFastDateParsing() {
        return getActiveMySQLConnection().getUseFastDateParsing();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseFastIntParsing() {
        return getActiveMySQLConnection().getUseFastIntParsing();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseGmtMillisForDatetimes() {
        return getActiveMySQLConnection().getUseGmtMillisForDatetimes();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseHostsInPrivileges() {
        return getActiveMySQLConnection().getUseHostsInPrivileges();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseInformationSchema() {
        return getActiveMySQLConnection().getUseInformationSchema();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseJDBCCompliantTimezoneShift() {
        return getActiveMySQLConnection().getUseJDBCCompliantTimezoneShift();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseJvmCharsetConverters() {
        return getActiveMySQLConnection().getUseJvmCharsetConverters();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseLegacyDatetimeCode() {
        return getActiveMySQLConnection().getUseLegacyDatetimeCode();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseLocalSessionState() {
        return getActiveMySQLConnection().getUseLocalSessionState();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseLocalTransactionState() {
        return getActiveMySQLConnection().getUseLocalTransactionState();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseNanosForElapsedTime() {
        return getActiveMySQLConnection().getUseNanosForElapsedTime();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseOldAliasMetadataBehavior() {
        return getActiveMySQLConnection().getUseOldAliasMetadataBehavior();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseOldUTF8Behavior() {
        return getActiveMySQLConnection().getUseOldUTF8Behavior();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseOnlyServerErrorMessages() {
        return getActiveMySQLConnection().getUseOnlyServerErrorMessages();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseReadAheadInput() {
        return getActiveMySQLConnection().getUseReadAheadInput();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseSSL() {
        return getActiveMySQLConnection().getUseSSL();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseSSPSCompatibleTimezoneShift() {
        return getActiveMySQLConnection().getUseSSPSCompatibleTimezoneShift();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseServerPrepStmts() {
        return getActiveMySQLConnection().getUseServerPrepStmts();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseServerPreparedStmts() {
        return getActiveMySQLConnection().getUseServerPreparedStmts();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseSqlStateCodes() {
        return getActiveMySQLConnection().getUseSqlStateCodes();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseStreamLengthsInPrepStmts() {
        return getActiveMySQLConnection().getUseStreamLengthsInPrepStmts();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseTimezone() {
        return getActiveMySQLConnection().getUseTimezone();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseUltraDevWorkAround() {
        return getActiveMySQLConnection().getUseUltraDevWorkAround();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseUnbufferedInput() {
        return getActiveMySQLConnection().getUseUnbufferedInput();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseUnicode() {
        return getActiveMySQLConnection().getUseUnicode();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseUsageAdvisor() {
        return getActiveMySQLConnection().getUseUsageAdvisor();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public String getUser() {
        return getActiveMySQLConnection().getUser();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public Calendar getUtcCalendar() {
        return getActiveMySQLConnection().getUtcCalendar();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getUtf8OutsideBmpExcludedColumnNamePattern() {
        return getActiveMySQLConnection().getUtf8OutsideBmpExcludedColumnNamePattern();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getUtf8OutsideBmpIncludedColumnNamePattern() {
        return getActiveMySQLConnection().getUtf8OutsideBmpIncludedColumnNamePattern();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getVerifyServerCertificate() {
        return getActiveMySQLConnection().getVerifyServerCertificate();
    }

    @Override // java.sql.Connection
    public SQLWarning getWarnings() throws SQLException {
        return getActiveMySQLConnection().getWarnings();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getYearIsDateType() {
        return getActiveMySQLConnection().getYearIsDateType();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getZeroDateTimeBehavior() {
        return getActiveMySQLConnection().getZeroDateTimeBehavior();
    }

    @Override // com.mysql.jdbc.Connection
    public boolean hasSameProperties(Connection connection) {
        return getActiveMySQLConnection().hasSameProperties(connection);
    }

    @Override // com.mysql.jdbc.Connection
    @Deprecated
    public boolean hasTriedMaster() {
        return getActiveMySQLConnection().hasTriedMaster();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void incrementNumberOfPreparedExecutes() {
        getActiveMySQLConnection().incrementNumberOfPreparedExecutes();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void incrementNumberOfPrepares() {
        getActiveMySQLConnection().incrementNumberOfPrepares();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void incrementNumberOfResultSetsCreated() {
        getActiveMySQLConnection().incrementNumberOfResultSetsCreated();
    }

    @Override // com.mysql.jdbc.Connection
    public void initializeExtension(Extension extension) throws SQLException {
        getActiveMySQLConnection().initializeExtension(extension);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void initializeResultsMetadataFromCache(String str, CachedResultSetMetaData cachedResultSetMetaData, ResultSetInternalMethods resultSetInternalMethods) throws SQLException {
        getActiveMySQLConnection().initializeResultsMetadataFromCache(str, cachedResultSetMetaData, resultSetInternalMethods);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void initializeSafeStatementInterceptors() throws SQLException {
        getActiveMySQLConnection().initializeSafeStatementInterceptors();
    }

    @Override // com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public boolean isAbonormallyLongQuery(long j) {
        return getActiveMySQLConnection().isAbonormallyLongQuery(j);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public boolean isClientTzUTC() {
        return getActiveMySQLConnection().isClientTzUTC();
    }

    @Override // java.sql.Connection
    public boolean isClosed() throws SQLException {
        return getThisAsProxy().isClosed;
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public boolean isCursorFetchEnabled() throws SQLException {
        return getActiveMySQLConnection().isCursorFetchEnabled();
    }

    @Override // com.mysql.jdbc.Connection
    public boolean isInGlobalTx() {
        return getActiveMySQLConnection().isInGlobalTx();
    }

    @Override // com.mysql.jdbc.Connection
    public boolean isMasterConnection() {
        return getThisAsProxy().isMasterConnection();
    }

    @Override // com.mysql.jdbc.Connection
    public boolean isNoBackslashEscapesSet() {
        return getActiveMySQLConnection().isNoBackslashEscapesSet();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public boolean isProxySet() {
        return getActiveMySQLConnection().isProxySet();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public boolean isReadInfoMsgEnabled() {
        return getActiveMySQLConnection().isReadInfoMsgEnabled();
    }

    @Override // com.mysql.jdbc.MySQLConnection, java.sql.Connection
    public boolean isReadOnly() throws SQLException {
        return getActiveMySQLConnection().isReadOnly();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public boolean isRunningOnJDK13() {
        return getActiveMySQLConnection().isRunningOnJDK13();
    }

    @Override // com.mysql.jdbc.Connection
    public boolean isSameResource(Connection connection) {
        return getActiveMySQLConnection().isSameResource(connection);
    }

    @Override // com.mysql.jdbc.Connection
    public boolean isServerLocal() throws SQLException {
        return getActiveMySQLConnection().isServerLocal();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public boolean isServerTruncatesFracSecs() {
        return getActiveMySQLConnection().isServerTruncatesFracSecs();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public boolean isServerTzUTC() {
        return getActiveMySQLConnection().isServerTzUTC();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean isUseSSLExplicit() {
        return getActiveMySQLConnection().isUseSSLExplicit();
    }

    @Override // com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public boolean lowerCaseTableNames() {
        return getActiveMySQLConnection().lowerCaseTableNames();
    }

    @Override // java.sql.Connection
    public String nativeSQL(String str) throws SQLException {
        return getActiveMySQLConnection().nativeSQL(str);
    }

    @Override // com.mysql.jdbc.Connection
    public boolean parserKnowsUnicode() {
        return getActiveMySQLConnection().parserKnowsUnicode();
    }

    @Override // com.mysql.jdbc.Connection
    public void ping() throws SQLException {
        getActiveMySQLConnection().ping();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void pingInternal(boolean z, int i) throws SQLException {
        getActiveMySQLConnection().pingInternal(z, i);
    }

    @Override // java.sql.Connection
    public java.sql.CallableStatement prepareCall(String str, int i, int i2, int i3) throws SQLException {
        return getActiveMySQLConnection().prepareCall(str, i, i2, i3);
    }

    @Override // java.sql.Connection
    public java.sql.PreparedStatement prepareStatement(String str, int i, int i2, int i3) throws SQLException {
        return getActiveMySQLConnection().prepareStatement(str, i, i2, i3);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void realClose(boolean z, boolean z2, boolean z3, Throwable th) throws SQLException {
        getActiveMySQLConnection().realClose(z, z2, z3, th);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void recachePreparedStatement(ServerPreparedStatement serverPreparedStatement) throws SQLException {
        getActiveMySQLConnection().recachePreparedStatement(serverPreparedStatement);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void registerQueryExecutionTime(long j) {
        getActiveMySQLConnection().registerQueryExecutionTime(j);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void registerStatement(Statement statement) {
        getActiveMySQLConnection().registerStatement(statement);
    }

    @Override // java.sql.Connection
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        getActiveMySQLConnection().releaseSavepoint(savepoint);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void reportNumberOfTablesAccessed(int i) {
        getActiveMySQLConnection().reportNumberOfTablesAccessed(i);
    }

    @Override // com.mysql.jdbc.Connection
    public void reportQueryTime(long j) {
        getActiveMySQLConnection().reportQueryTime(j);
    }

    @Override // com.mysql.jdbc.Connection
    public void resetServerState() throws SQLException {
        getActiveMySQLConnection().resetServerState();
    }

    @Override // java.sql.Connection
    public void rollback() throws SQLException {
        getActiveMySQLConnection().rollback();
    }

    @Override // com.mysql.jdbc.Connection
    public java.sql.PreparedStatement serverPrepareStatement(String str, int i, int i2, int i3) throws SQLException {
        return getActiveMySQLConnection().serverPrepareStatement(str, i, i2, i3);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public boolean serverSupportsConvertFn() throws SQLException {
        return getActiveMySQLConnection().serverSupportsConvertFn();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAllowLoadLocalInfile(boolean z) {
        getActiveMySQLConnection().setAllowLoadLocalInfile(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAllowMasterDownConnections(boolean z) {
        getActiveMySQLConnection().setAllowMasterDownConnections(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAllowMultiQueries(boolean z) {
        getActiveMySQLConnection().setAllowMultiQueries(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAllowNanAndInf(boolean z) {
        getActiveMySQLConnection().setAllowNanAndInf(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAllowPublicKeyRetrieval(boolean z) throws SQLException {
        getActiveMySQLConnection().setAllowPublicKeyRetrieval(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAllowSlaveDownConnections(boolean z) {
        getActiveMySQLConnection().setAllowSlaveDownConnections(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAllowUrlInLocalInfile(boolean z) {
        getActiveMySQLConnection().setAllowUrlInLocalInfile(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAlwaysSendSetIsolation(boolean z) {
        getActiveMySQLConnection().setAlwaysSendSetIsolation(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAuthenticationPlugins(String str) {
        getActiveMySQLConnection().setAuthenticationPlugins(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAutoClosePStmtStreams(boolean z) {
        getActiveMySQLConnection().setAutoClosePStmtStreams(z);
    }

    @Override // java.sql.Connection
    public void setAutoCommit(boolean z) throws SQLException {
        getActiveMySQLConnection().setAutoCommit(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAutoDeserialize(boolean z) {
        getActiveMySQLConnection().setAutoDeserialize(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAutoGenerateTestcaseScript(boolean z) {
        getActiveMySQLConnection().setAutoGenerateTestcaseScript(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAutoReconnect(boolean z) {
        getActiveMySQLConnection().setAutoReconnect(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAutoReconnectForConnectionPools(boolean z) {
        getActiveMySQLConnection().setAutoReconnectForConnectionPools(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAutoReconnectForPools(boolean z) {
        getActiveMySQLConnection().setAutoReconnectForPools(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAutoSlowLog(boolean z) {
        getActiveMySQLConnection().setAutoSlowLog(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setBlobSendChunkSize(String str) throws SQLException {
        getActiveMySQLConnection().setBlobSendChunkSize(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setBlobsAreStrings(boolean z) {
        getActiveMySQLConnection().setBlobsAreStrings(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCacheCallableStatements(boolean z) {
        getActiveMySQLConnection().setCacheCallableStatements(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCacheCallableStmts(boolean z) {
        getActiveMySQLConnection().setCacheCallableStmts(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCacheDefaultTimezone(boolean z) {
        getActiveMySQLConnection().setCacheDefaultTimezone(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCachePrepStmts(boolean z) {
        getActiveMySQLConnection().setCachePrepStmts(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCachePreparedStatements(boolean z) {
        getActiveMySQLConnection().setCachePreparedStatements(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCacheResultSetMetadata(boolean z) {
        getActiveMySQLConnection().setCacheResultSetMetadata(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCacheServerConfiguration(boolean z) {
        getActiveMySQLConnection().setCacheServerConfiguration(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCallableStatementCacheSize(int i) throws SQLException {
        getActiveMySQLConnection().setCallableStatementCacheSize(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCallableStmtCacheSize(int i) throws SQLException {
        getActiveMySQLConnection().setCallableStmtCacheSize(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCapitalizeDBMDTypes(boolean z) {
        getActiveMySQLConnection().setCapitalizeDBMDTypes(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCapitalizeTypeNames(boolean z) {
        getActiveMySQLConnection().setCapitalizeTypeNames(z);
    }

    @Override // java.sql.Connection
    public void setCatalog(String str) throws SQLException {
        getActiveMySQLConnection().setCatalog(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCharacterEncoding(String str) {
        getActiveMySQLConnection().setCharacterEncoding(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCharacterSetResults(String str) {
        getActiveMySQLConnection().setCharacterSetResults(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setClientCertificateKeyStorePassword(String str) {
        getActiveMySQLConnection().setClientCertificateKeyStorePassword(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setClientCertificateKeyStoreType(String str) {
        getActiveMySQLConnection().setClientCertificateKeyStoreType(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setClientCertificateKeyStoreUrl(String str) {
        getActiveMySQLConnection().setClientCertificateKeyStoreUrl(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setClientInfoProvider(String str) {
        getActiveMySQLConnection().setClientInfoProvider(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setClobCharacterEncoding(String str) {
        getActiveMySQLConnection().setClobCharacterEncoding(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setClobberStreamingResults(boolean z) {
        getActiveMySQLConnection().setClobberStreamingResults(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCompensateOnDuplicateKeyUpdateCounts(boolean z) {
        getActiveMySQLConnection().setCompensateOnDuplicateKeyUpdateCounts(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setConnectTimeout(int i) throws SQLException {
        getActiveMySQLConnection().setConnectTimeout(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setConnectionCollation(String str) {
        getActiveMySQLConnection().setConnectionCollation(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setConnectionLifecycleInterceptors(String str) {
        getActiveMySQLConnection().setConnectionLifecycleInterceptors(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setContinueBatchOnError(boolean z) {
        getActiveMySQLConnection().setContinueBatchOnError(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCreateDatabaseIfNotExist(boolean z) {
        getActiveMySQLConnection().setCreateDatabaseIfNotExist(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDefaultAuthenticationPlugin(String str) {
        getActiveMySQLConnection().setDefaultAuthenticationPlugin(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDefaultFetchSize(int i) throws SQLException {
        getActiveMySQLConnection().setDefaultFetchSize(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDetectCustomCollations(boolean z) {
        getActiveMySQLConnection().setDetectCustomCollations(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDetectServerPreparedStmts(boolean z) {
        getActiveMySQLConnection().setDetectServerPreparedStmts(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDisabledAuthenticationPlugins(String str) {
        getActiveMySQLConnection().setDisabledAuthenticationPlugins(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDisconnectOnExpiredPasswords(boolean z) {
        getActiveMySQLConnection().setDisconnectOnExpiredPasswords(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDontCheckOnDuplicateKeyUpdateInSQL(boolean z) {
        getActiveMySQLConnection().setDontCheckOnDuplicateKeyUpdateInSQL(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDontTrackOpenResources(boolean z) {
        getActiveMySQLConnection().setDontTrackOpenResources(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDumpMetadataOnColumnNotFound(boolean z) {
        getActiveMySQLConnection().setDumpMetadataOnColumnNotFound(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDumpQueriesOnException(boolean z) {
        getActiveMySQLConnection().setDumpQueriesOnException(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDynamicCalendars(boolean z) {
        getActiveMySQLConnection().setDynamicCalendars(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setElideSetAutoCommits(boolean z) {
        getActiveMySQLConnection().setElideSetAutoCommits(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setEmptyStringsConvertToZero(boolean z) {
        getActiveMySQLConnection().setEmptyStringsConvertToZero(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setEmulateLocators(boolean z) {
        getActiveMySQLConnection().setEmulateLocators(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setEmulateUnsupportedPstmts(boolean z) {
        getActiveMySQLConnection().setEmulateUnsupportedPstmts(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setEnableEscapeProcessing(boolean z) {
        getActiveMySQLConnection().setEnableEscapeProcessing(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setEnablePacketDebug(boolean z) {
        getActiveMySQLConnection().setEnablePacketDebug(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setEnableQueryTimeouts(boolean z) {
        getActiveMySQLConnection().setEnableQueryTimeouts(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setEnabledSSLCipherSuites(String str) {
        getActiveMySQLConnection().setEnabledSSLCipherSuites(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setEnabledTLSProtocols(String str) {
        getActiveMySQLConnection().setEnabledTLSProtocols(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setEncoding(String str) {
        getActiveMySQLConnection().setEncoding(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setExceptionInterceptors(String str) {
        getActiveMySQLConnection().setExceptionInterceptors(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setExplainSlowQueries(boolean z) {
        getActiveMySQLConnection().setExplainSlowQueries(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setFailOverReadOnly(boolean z) {
        getActiveMySQLConnection().setFailOverReadOnly(z);
    }

    @Override // com.mysql.jdbc.Connection
    public void setFailedOver(boolean z) {
        getActiveMySQLConnection().setFailedOver(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setFunctionsNeverReturnBlobs(boolean z) {
        getActiveMySQLConnection().setFunctionsNeverReturnBlobs(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setGatherPerfMetrics(boolean z) {
        getActiveMySQLConnection().setGatherPerfMetrics(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setGatherPerformanceMetrics(boolean z) {
        getActiveMySQLConnection().setGatherPerformanceMetrics(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setGenerateSimpleParameterMetadata(boolean z) {
        getActiveMySQLConnection().setGenerateSimpleParameterMetadata(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setGetProceduresReturnsFunctions(boolean z) {
        getActiveMySQLConnection().setGetProceduresReturnsFunctions(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setHoldResultsOpenOverStatementClose(boolean z) {
        getActiveMySQLConnection().setHoldResultsOpenOverStatementClose(z);
    }

    @Override // java.sql.Connection
    public void setHoldability(int i) throws SQLException {
        getActiveMySQLConnection().setHoldability(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setIgnoreNonTxTables(boolean z) {
        getActiveMySQLConnection().setIgnoreNonTxTables(z);
    }

    @Override // com.mysql.jdbc.Connection
    public void setInGlobalTx(boolean z) {
        getActiveMySQLConnection().setInGlobalTx(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setIncludeInnodbStatusInDeadlockExceptions(boolean z) {
        getActiveMySQLConnection().setIncludeInnodbStatusInDeadlockExceptions(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setIncludeThreadDumpInDeadlockExceptions(boolean z) {
        getActiveMySQLConnection().setIncludeThreadDumpInDeadlockExceptions(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setIncludeThreadNamesAsStatementComment(boolean z) {
        getActiveMySQLConnection().setIncludeThreadNamesAsStatementComment(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setInitialTimeout(int i) throws SQLException {
        getActiveMySQLConnection().setInitialTimeout(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setInteractiveClient(boolean z) {
        getActiveMySQLConnection().setInteractiveClient(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setIsInteractiveClient(boolean z) {
        getActiveMySQLConnection().setIsInteractiveClient(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setJdbcCompliantTruncation(boolean z) {
        getActiveMySQLConnection().setJdbcCompliantTruncation(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setJdbcCompliantTruncationForReads(boolean z) {
        getActiveMySQLConnection().setJdbcCompliantTruncationForReads(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLargeRowSizeThreshold(String str) throws SQLException {
        getActiveMySQLConnection().setLargeRowSizeThreshold(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceAutoCommitStatementRegex(String str) {
        getActiveMySQLConnection().setLoadBalanceAutoCommitStatementRegex(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceAutoCommitStatementThreshold(int i) throws SQLException {
        getActiveMySQLConnection().setLoadBalanceAutoCommitStatementThreshold(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceBlacklistTimeout(int i) throws SQLException {
        getActiveMySQLConnection().setLoadBalanceBlacklistTimeout(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceConnectionGroup(String str) {
        getActiveMySQLConnection().setLoadBalanceConnectionGroup(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceEnableJMX(boolean z) {
        getActiveMySQLConnection().setLoadBalanceEnableJMX(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceExceptionChecker(String str) {
        getActiveMySQLConnection().setLoadBalanceExceptionChecker(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceHostRemovalGracePeriod(int i) throws SQLException {
        getActiveMySQLConnection().setLoadBalanceHostRemovalGracePeriod(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalancePingTimeout(int i) throws SQLException {
        getActiveMySQLConnection().setLoadBalancePingTimeout(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceSQLExceptionSubclassFailover(String str) {
        getActiveMySQLConnection().setLoadBalanceSQLExceptionSubclassFailover(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceSQLStateFailover(String str) {
        getActiveMySQLConnection().setLoadBalanceSQLStateFailover(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceStrategy(String str) {
        getActiveMySQLConnection().setLoadBalanceStrategy(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceValidateConnectionOnSwapServer(boolean z) {
        getActiveMySQLConnection().setLoadBalanceValidateConnectionOnSwapServer(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLocalSocketAddress(String str) {
        getActiveMySQLConnection().setLocalSocketAddress(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLocatorFetchBufferSize(String str) throws SQLException {
        getActiveMySQLConnection().setLocatorFetchBufferSize(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLogSlowQueries(boolean z) {
        getActiveMySQLConnection().setLogSlowQueries(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLogXaCommands(boolean z) {
        getActiveMySQLConnection().setLogXaCommands(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLogger(String str) {
        getActiveMySQLConnection().setLogger(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoggerClassName(String str) {
        getActiveMySQLConnection().setLoggerClassName(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setMaintainTimeStats(boolean z) {
        getActiveMySQLConnection().setMaintainTimeStats(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setMaxQuerySizeToLog(int i) throws SQLException {
        getActiveMySQLConnection().setMaxQuerySizeToLog(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setMaxReconnects(int i) throws SQLException {
        getActiveMySQLConnection().setMaxReconnects(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setMaxRows(int i) throws SQLException {
        getActiveMySQLConnection().setMaxRows(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setMetadataCacheSize(int i) throws SQLException {
        getActiveMySQLConnection().setMetadataCacheSize(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setNetTimeoutForStreamingResults(int i) throws SQLException {
        getActiveMySQLConnection().setNetTimeoutForStreamingResults(i);
    }

    @Override // com.mysql.jdbc.Connection
    public void setNetworkTimeout(Executor executor, int i) throws SQLException {
        getActiveMySQLConnection().setNetworkTimeout(executor, i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setNoAccessToProcedureBodies(boolean z) {
        getActiveMySQLConnection().setNoAccessToProcedureBodies(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setNoDatetimeStringSync(boolean z) {
        getActiveMySQLConnection().setNoDatetimeStringSync(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setNoTimezoneConversionForDateType(boolean z) {
        getActiveMySQLConnection().setNoTimezoneConversionForDateType(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setNoTimezoneConversionForTimeType(boolean z) {
        getActiveMySQLConnection().setNoTimezoneConversionForTimeType(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setNullCatalogMeansCurrent(boolean z) {
        getActiveMySQLConnection().setNullCatalogMeansCurrent(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setNullNamePatternMatchesAll(boolean z) {
        getActiveMySQLConnection().setNullNamePatternMatchesAll(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setOverrideSupportsIntegrityEnhancementFacility(boolean z) {
        getActiveMySQLConnection().setOverrideSupportsIntegrityEnhancementFacility(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPacketDebugBufferSize(int i) throws SQLException {
        getActiveMySQLConnection().setPacketDebugBufferSize(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPadCharsWithSpace(boolean z) {
        getActiveMySQLConnection().setPadCharsWithSpace(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setParanoid(boolean z) {
        getActiveMySQLConnection().setParanoid(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setParseInfoCacheFactory(String str) {
        getActiveMySQLConnection().setParseInfoCacheFactory(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPasswordCharacterEncoding(String str) {
        getActiveMySQLConnection().setPasswordCharacterEncoding(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPedantic(boolean z) {
        getActiveMySQLConnection().setPedantic(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPinGlobalTxToPhysicalConnection(boolean z) {
        getActiveMySQLConnection().setPinGlobalTxToPhysicalConnection(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPopulateInsertRowWithDefaultValues(boolean z) {
        getActiveMySQLConnection().setPopulateInsertRowWithDefaultValues(z);
    }

    @Override // com.mysql.jdbc.Connection
    @Deprecated
    public void setPreferSlaveDuringFailover(boolean z) {
        getActiveMySQLConnection().setPreferSlaveDuringFailover(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPrepStmtCacheSize(int i) throws SQLException {
        getActiveMySQLConnection().setPrepStmtCacheSize(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPrepStmtCacheSqlLimit(int i) throws SQLException {
        getActiveMySQLConnection().setPrepStmtCacheSqlLimit(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPreparedStatementCacheSize(int i) throws SQLException {
        getActiveMySQLConnection().setPreparedStatementCacheSize(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPreparedStatementCacheSqlLimit(int i) throws SQLException {
        getActiveMySQLConnection().setPreparedStatementCacheSqlLimit(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setProcessEscapeCodesForPrepStmts(boolean z) {
        getActiveMySQLConnection().setProcessEscapeCodesForPrepStmts(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setProfileSQL(boolean z) {
        getActiveMySQLConnection().setProfileSQL(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setProfileSql(boolean z) {
        getActiveMySQLConnection().setProfileSql(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setProfilerEventHandler(String str) {
        getActiveMySQLConnection().setProfilerEventHandler(str);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void setProfilerEventHandlerInstance(ProfilerEventHandler profilerEventHandler) {
        getActiveMySQLConnection().setProfilerEventHandlerInstance(profilerEventHandler);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPropertiesTransform(String str) {
        getActiveMySQLConnection().setPropertiesTransform(str);
    }

    @Override // com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public void setProxy(MySQLConnection mySQLConnection) {
        getThisAsProxy().setProxy(mySQLConnection);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setQueriesBeforeRetryMaster(int i) throws SQLException {
        getActiveMySQLConnection().setQueriesBeforeRetryMaster(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setQueryTimeoutKillsConnection(boolean z) {
        getActiveMySQLConnection().setQueryTimeoutKillsConnection(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setReadFromMasterWhenNoSlaves(boolean z) {
        getActiveMySQLConnection().setReadFromMasterWhenNoSlaves(z);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void setReadInfoMsgEnabled(boolean z) {
        getActiveMySQLConnection().setReadInfoMsgEnabled(z);
    }

    @Override // java.sql.Connection
    public void setReadOnly(boolean z) throws SQLException {
        getActiveMySQLConnection().setReadOnly(z);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void setReadOnlyInternal(boolean z) throws SQLException {
        getActiveMySQLConnection().setReadOnlyInternal(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setReadOnlyPropagatesToServer(boolean z) {
        getActiveMySQLConnection().setReadOnlyPropagatesToServer(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setReconnectAtTxEnd(boolean z) {
        getActiveMySQLConnection().setReconnectAtTxEnd(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setRelaxAutoCommit(boolean z) {
        getActiveMySQLConnection().setRelaxAutoCommit(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setReplicationEnableJMX(boolean z) {
        getActiveMySQLConnection().setReplicationEnableJMX(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setReportMetricsIntervalMillis(int i) throws SQLException {
        getActiveMySQLConnection().setReportMetricsIntervalMillis(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setRequireSSL(boolean z) {
        getActiveMySQLConnection().setRequireSSL(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setResourceId(String str) {
        getActiveMySQLConnection().setResourceId(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setResultSetSizeThreshold(int i) throws SQLException {
        getActiveMySQLConnection().setResultSetSizeThreshold(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setRetainStatementAfterResultSetClose(boolean z) {
        getActiveMySQLConnection().setRetainStatementAfterResultSetClose(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setRetriesAllDown(int i) throws SQLException {
        getActiveMySQLConnection().setRetriesAllDown(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setRewriteBatchedStatements(boolean z) {
        getActiveMySQLConnection().setRewriteBatchedStatements(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setRollbackOnPooledClose(boolean z) {
        getActiveMySQLConnection().setRollbackOnPooledClose(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setRoundRobinLoadBalance(boolean z) {
        getActiveMySQLConnection().setRoundRobinLoadBalance(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setRunningCTS13(boolean z) {
        getActiveMySQLConnection().setRunningCTS13(z);
    }

    @Override // java.sql.Connection
    public Savepoint setSavepoint() throws SQLException {
        return getActiveMySQLConnection().setSavepoint();
    }

    @Override // com.mysql.jdbc.Connection
    public void setSchema(String str) throws SQLException {
        getActiveMySQLConnection().setSchema(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSecondsBeforeRetryMaster(int i) throws SQLException {
        getActiveMySQLConnection().setSecondsBeforeRetryMaster(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSelfDestructOnPingMaxOperations(int i) throws SQLException {
        getActiveMySQLConnection().setSelfDestructOnPingMaxOperations(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSelfDestructOnPingSecondsLifetime(int i) throws SQLException {
        getActiveMySQLConnection().setSelfDestructOnPingSecondsLifetime(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSendFractionalSeconds(boolean z) {
        getActiveMySQLConnection().setSendFractionalSeconds(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setServerAffinityOrder(String str) {
        getActiveMySQLConnection().setServerAffinityOrder(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setServerConfigCacheFactory(String str) {
        getActiveMySQLConnection().setServerConfigCacheFactory(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setServerRSAPublicKeyFile(String str) throws SQLException {
        getActiveMySQLConnection().setServerRSAPublicKeyFile(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setServerTimezone(String str) {
        getActiveMySQLConnection().setServerTimezone(str);
    }

    @Override // com.mysql.jdbc.Connection
    public void setSessionMaxRows(int i) throws SQLException {
        getActiveMySQLConnection().setSessionMaxRows(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSessionVariables(String str) {
        getActiveMySQLConnection().setSessionVariables(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSlowQueryThresholdMillis(int i) throws SQLException {
        getActiveMySQLConnection().setSlowQueryThresholdMillis(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSlowQueryThresholdNanos(long j) throws SQLException {
        getActiveMySQLConnection().setSlowQueryThresholdNanos(j);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSocketFactory(String str) {
        getActiveMySQLConnection().setSocketFactory(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSocketFactoryClassName(String str) {
        getActiveMySQLConnection().setSocketFactoryClassName(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSocketTimeout(int i) throws SQLException {
        getActiveMySQLConnection().setSocketTimeout(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSocksProxyHost(String str) {
        getActiveMySQLConnection().setSocksProxyHost(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSocksProxyPort(int i) throws SQLException {
        getActiveMySQLConnection().setSocksProxyPort(i);
    }

    @Override // com.mysql.jdbc.Connection
    public void setStatementComment(String str) {
        getActiveMySQLConnection().setStatementComment(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setStatementInterceptors(String str) {
        getActiveMySQLConnection().setStatementInterceptors(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setStrictFloatingPoint(boolean z) {
        getActiveMySQLConnection().setStrictFloatingPoint(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setStrictUpdates(boolean z) {
        getActiveMySQLConnection().setStrictUpdates(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTcpKeepAlive(boolean z) {
        getActiveMySQLConnection().setTcpKeepAlive(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTcpNoDelay(boolean z) {
        getActiveMySQLConnection().setTcpNoDelay(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTcpRcvBuf(int i) throws SQLException {
        getActiveMySQLConnection().setTcpRcvBuf(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTcpSndBuf(int i) throws SQLException {
        getActiveMySQLConnection().setTcpSndBuf(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTcpTrafficClass(int i) throws SQLException {
        getActiveMySQLConnection().setTcpTrafficClass(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTinyInt1isBit(boolean z) {
        getActiveMySQLConnection().setTinyInt1isBit(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTraceProtocol(boolean z) {
        getActiveMySQLConnection().setTraceProtocol(z);
    }

    @Override // java.sql.Connection
    public void setTransactionIsolation(int i) throws SQLException {
        getActiveMySQLConnection().setTransactionIsolation(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTransformedBitIsBoolean(boolean z) {
        getActiveMySQLConnection().setTransformedBitIsBoolean(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTreatUtilDateAsTimestamp(boolean z) {
        getActiveMySQLConnection().setTreatUtilDateAsTimestamp(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTrustCertificateKeyStorePassword(String str) {
        getActiveMySQLConnection().setTrustCertificateKeyStorePassword(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTrustCertificateKeyStoreType(String str) {
        getActiveMySQLConnection().setTrustCertificateKeyStoreType(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTrustCertificateKeyStoreUrl(String str) {
        getActiveMySQLConnection().setTrustCertificateKeyStoreUrl(str);
    }

    @Override // java.sql.Connection
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        getActiveMySQLConnection().setTypeMap(map);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUltraDevHack(boolean z) {
        getActiveMySQLConnection().setUltraDevHack(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseAffectedRows(boolean z) {
        getActiveMySQLConnection().setUseAffectedRows(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseBlobToStoreUTF8OutsideBMP(boolean z) {
        getActiveMySQLConnection().setUseBlobToStoreUTF8OutsideBMP(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseColumnNamesInFindColumn(boolean z) {
        getActiveMySQLConnection().setUseColumnNamesInFindColumn(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseCompression(boolean z) {
        getActiveMySQLConnection().setUseCompression(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseConfigs(String str) {
        getActiveMySQLConnection().setUseConfigs(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseCursorFetch(boolean z) {
        getActiveMySQLConnection().setUseCursorFetch(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseDirectRowUnpack(boolean z) {
        getActiveMySQLConnection().setUseDirectRowUnpack(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseDynamicCharsetInfo(boolean z) {
        getActiveMySQLConnection().setUseDynamicCharsetInfo(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseFastDateParsing(boolean z) {
        getActiveMySQLConnection().setUseFastDateParsing(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseFastIntParsing(boolean z) {
        getActiveMySQLConnection().setUseFastIntParsing(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseGmtMillisForDatetimes(boolean z) {
        getActiveMySQLConnection().setUseGmtMillisForDatetimes(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseHostsInPrivileges(boolean z) {
        getActiveMySQLConnection().setUseHostsInPrivileges(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseInformationSchema(boolean z) {
        getActiveMySQLConnection().setUseInformationSchema(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseJDBCCompliantTimezoneShift(boolean z) {
        getActiveMySQLConnection().setUseJDBCCompliantTimezoneShift(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseJvmCharsetConverters(boolean z) {
        getActiveMySQLConnection().setUseJvmCharsetConverters(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseLegacyDatetimeCode(boolean z) {
        getActiveMySQLConnection().setUseLegacyDatetimeCode(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseLocalSessionState(boolean z) {
        getActiveMySQLConnection().setUseLocalSessionState(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseLocalTransactionState(boolean z) {
        getActiveMySQLConnection().setUseLocalTransactionState(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseNanosForElapsedTime(boolean z) {
        getActiveMySQLConnection().setUseNanosForElapsedTime(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseOldAliasMetadataBehavior(boolean z) {
        getActiveMySQLConnection().setUseOldAliasMetadataBehavior(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseOldUTF8Behavior(boolean z) {
        getActiveMySQLConnection().setUseOldUTF8Behavior(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseOnlyServerErrorMessages(boolean z) {
        getActiveMySQLConnection().setUseOnlyServerErrorMessages(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseReadAheadInput(boolean z) {
        getActiveMySQLConnection().setUseReadAheadInput(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseSSL(boolean z) {
        getActiveMySQLConnection().setUseSSL(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseSSPSCompatibleTimezoneShift(boolean z) {
        getActiveMySQLConnection().setUseSSPSCompatibleTimezoneShift(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseServerPrepStmts(boolean z) {
        getActiveMySQLConnection().setUseServerPrepStmts(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseServerPreparedStmts(boolean z) {
        getActiveMySQLConnection().setUseServerPreparedStmts(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseSqlStateCodes(boolean z) {
        getActiveMySQLConnection().setUseSqlStateCodes(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseStreamLengthsInPrepStmts(boolean z) {
        getActiveMySQLConnection().setUseStreamLengthsInPrepStmts(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseTimezone(boolean z) {
        getActiveMySQLConnection().setUseTimezone(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseUltraDevWorkAround(boolean z) {
        getActiveMySQLConnection().setUseUltraDevWorkAround(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseUnbufferedInput(boolean z) {
        getActiveMySQLConnection().setUseUnbufferedInput(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseUnicode(boolean z) {
        getActiveMySQLConnection().setUseUnicode(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseUsageAdvisor(boolean z) {
        getActiveMySQLConnection().setUseUsageAdvisor(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUtf8OutsideBmpExcludedColumnNamePattern(String str) {
        getActiveMySQLConnection().setUtf8OutsideBmpExcludedColumnNamePattern(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUtf8OutsideBmpIncludedColumnNamePattern(String str) {
        getActiveMySQLConnection().setUtf8OutsideBmpIncludedColumnNamePattern(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setVerifyServerCertificate(boolean z) {
        getActiveMySQLConnection().setVerifyServerCertificate(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setYearIsDateType(boolean z) {
        getActiveMySQLConnection().setYearIsDateType(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setZeroDateTimeBehavior(String str) {
        getActiveMySQLConnection().setZeroDateTimeBehavior(str);
    }

    @Override // com.mysql.jdbc.MySQLConnection, com.mysql.jdbc.Connection
    public void shutdownServer() throws SQLException {
        getActiveMySQLConnection().shutdownServer();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public boolean storesLowerCaseTableName() {
        return getActiveMySQLConnection().storesLowerCaseTableName();
    }

    @Override // com.mysql.jdbc.Connection
    public boolean supportsIsolationLevel() {
        return getActiveMySQLConnection().supportsIsolationLevel();
    }

    @Override // com.mysql.jdbc.Connection
    public boolean supportsQuotedIdentifiers() {
        return getActiveMySQLConnection().supportsQuotedIdentifiers();
    }

    @Override // com.mysql.jdbc.Connection
    public boolean supportsTransactions() {
        return getActiveMySQLConnection().supportsTransactions();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void throwConnectionClosedException() throws SQLException {
        getActiveMySQLConnection().throwConnectionClosedException();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void transactionBegun() throws SQLException {
        getActiveMySQLConnection().transactionBegun();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void transactionCompleted() throws SQLException {
        getActiveMySQLConnection().transactionCompleted();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void unSafeStatementInterceptors() throws SQLException {
        getActiveMySQLConnection().unSafeStatementInterceptors();
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public void unregisterStatement(Statement statement) {
        getActiveMySQLConnection().unregisterStatement(statement);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public boolean useAnsiQuotedIdentifiers() {
        return getActiveMySQLConnection().useAnsiQuotedIdentifiers();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean useUnbufferedInput() {
        return getActiveMySQLConnection().useUnbufferedInput();
    }

    @Override // com.mysql.jdbc.Connection
    public boolean versionMeetsMinimum(int i, int i2, int i3) throws SQLException {
        return getActiveMySQLConnection().versionMeetsMinimum(i, i2, i3);
    }

    @Override // com.mysql.jdbc.Connection
    public java.sql.PreparedStatement clientPrepareStatement(String str, int i, int i2) throws SQLException {
        return getActiveMySQLConnection().clientPrepareStatement(str, i, i2);
    }

    @Override // java.sql.Connection
    public java.sql.Statement createStatement(int i, int i2, int i3) throws SQLException {
        return getActiveMySQLConnection().createStatement(i, i2, i3);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public ResultSetInternalMethods execSQL(StatementImpl statementImpl, String str, int i, Buffer buffer, int i2, int i3, boolean z, String str2, Field[] fieldArr) throws SQLException {
        return getActiveMySQLConnection().execSQL(statementImpl, str, i, buffer, i2, i3, z, str2, fieldArr);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public int getMaxBytesPerChar(Integer num, String str) throws SQLException {
        return getActiveMySQLConnection().getMaxBytesPerChar(num, str);
    }

    @Override // com.mysql.jdbc.MySQLConnection
    public boolean isReadOnly(boolean z) throws SQLException {
        return getActiveMySQLConnection().isReadOnly(z);
    }

    @Override // java.sql.Connection
    public java.sql.CallableStatement prepareCall(String str, int i, int i2) throws SQLException {
        return getActiveMySQLConnection().prepareCall(str, i, i2);
    }

    @Override // java.sql.Connection
    public java.sql.PreparedStatement prepareStatement(String str, int i, int i2) throws SQLException {
        return getActiveMySQLConnection().prepareStatement(str, i, i2);
    }

    @Override // java.sql.Connection
    public void rollback(Savepoint savepoint) throws SQLException {
        getActiveMySQLConnection().rollback(savepoint);
    }

    @Override // com.mysql.jdbc.Connection
    public java.sql.PreparedStatement serverPrepareStatement(String str, int i, int i2) throws SQLException {
        return getActiveMySQLConnection().serverPrepareStatement(str, i, i2);
    }

    @Override // java.sql.Connection
    public Savepoint setSavepoint(String str) throws SQLException {
        return getActiveMySQLConnection().setSavepoint(str);
    }

    @Override // com.mysql.jdbc.Connection
    public java.sql.PreparedStatement clientPrepareStatement(String str, int i) throws SQLException {
        return getActiveMySQLConnection().clientPrepareStatement(str, i);
    }

    @Override // java.sql.Connection
    public java.sql.Statement createStatement(int i, int i2) throws SQLException {
        return getActiveMySQLConnection().createStatement(i, i2);
    }

    @Override // java.sql.Connection
    public java.sql.CallableStatement prepareCall(String str) throws SQLException {
        return getActiveMySQLConnection().prepareCall(str);
    }

    @Override // java.sql.Connection
    public java.sql.PreparedStatement prepareStatement(String str, int i) throws SQLException {
        return getActiveMySQLConnection().prepareStatement(str, i);
    }

    @Override // com.mysql.jdbc.Connection
    public java.sql.PreparedStatement serverPrepareStatement(String str, int i) throws SQLException {
        return getActiveMySQLConnection().serverPrepareStatement(str, i);
    }

    @Override // com.mysql.jdbc.Connection
    public java.sql.PreparedStatement clientPrepareStatement(String str, int[] iArr) throws SQLException {
        return getActiveMySQLConnection().clientPrepareStatement(str, iArr);
    }

    @Override // java.sql.Connection
    public java.sql.PreparedStatement prepareStatement(String str, int[] iArr) throws SQLException {
        return getActiveMySQLConnection().prepareStatement(str, iArr);
    }

    @Override // com.mysql.jdbc.Connection
    public java.sql.PreparedStatement serverPrepareStatement(String str, int[] iArr) throws SQLException {
        return getActiveMySQLConnection().serverPrepareStatement(str, iArr);
    }

    @Override // com.mysql.jdbc.Connection
    public java.sql.PreparedStatement clientPrepareStatement(String str, String[] strArr) throws SQLException {
        return getActiveMySQLConnection().clientPrepareStatement(str, strArr);
    }

    @Override // java.sql.Connection
    public java.sql.PreparedStatement prepareStatement(String str, String[] strArr) throws SQLException {
        return getActiveMySQLConnection().prepareStatement(str, strArr);
    }

    @Override // com.mysql.jdbc.Connection
    public java.sql.PreparedStatement serverPrepareStatement(String str, String[] strArr) throws SQLException {
        return getActiveMySQLConnection().serverPrepareStatement(str, strArr);
    }

    @Override // com.mysql.jdbc.Connection
    public java.sql.PreparedStatement clientPrepareStatement(String str) throws SQLException {
        return getActiveMySQLConnection().clientPrepareStatement(str);
    }

    @Override // java.sql.Connection
    public java.sql.PreparedStatement prepareStatement(String str) throws SQLException {
        return getActiveMySQLConnection().prepareStatement(str);
    }

    @Override // com.mysql.jdbc.Connection
    public java.sql.PreparedStatement serverPrepareStatement(String str) throws SQLException {
        return getActiveMySQLConnection().serverPrepareStatement(str);
    }
}
