package com.mysql.jdbc.jdbc2.optional;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ExceptionInterceptor;
import com.mysql.jdbc.Extension;
import com.mysql.jdbc.MySQLConnection;
import com.mysql.jdbc.MysqlErrorNumbers;
import com.mysql.jdbc.SQLError;
import com.mysql.jdbc.Util;
import com.mysql.jdbc.log.Log;
import java.lang.reflect.Constructor;
import java.sql.CallableStatement;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class ConnectionWrapper extends WrapperBase implements Connection {
    private static final Constructor<?> JDBC_4_CONNECTION_WRAPPER_CTOR;
    private boolean closed;
    private String invalidHandleStr;
    private boolean isForXa;

    /* JADX INFO: renamed from: mc */
    public Connection f85mc;

    static {
        if (!Util.isJdbc4()) {
            JDBC_4_CONNECTION_WRAPPER_CTOR = null;
            return;
        }
        try {
            JDBC_4_CONNECTION_WRAPPER_CTOR = Class.forName("com.mysql.jdbc.jdbc2.optional.JDBC4ConnectionWrapper").getConstructor(MysqlPooledConnection.class, Connection.class, Boolean.TYPE);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        } catch (SecurityException e3) {
            throw new RuntimeException(e3);
        }
    }

    public ConnectionWrapper(MysqlPooledConnection mysqlPooledConnection, Connection connection, boolean z) throws SQLException {
        super(mysqlPooledConnection);
        this.f85mc = null;
        this.invalidHandleStr = "Logical handle no longer valid";
        this.f85mc = connection;
        this.closed = false;
        this.isForXa = z;
        if (z) {
            setInGlobalTx(false);
        }
    }

    public static ConnectionWrapper getInstance(MysqlPooledConnection mysqlPooledConnection, Connection connection, boolean z) throws SQLException {
        return !Util.isJdbc4() ? new ConnectionWrapper(mysqlPooledConnection, connection, z) : (ConnectionWrapper) Util.handleNewInstance(JDBC_4_CONNECTION_WRAPPER_CTOR, new Object[]{mysqlPooledConnection, connection, Boolean.valueOf(z)}, mysqlPooledConnection.getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.Connection
    public void abort(Executor executor) throws SQLException {
        this.f85mc.abort(executor);
    }

    @Override // com.mysql.jdbc.Connection
    public void abortInternal() throws SQLException {
        this.f85mc.abortInternal();
    }

    @Override // com.mysql.jdbc.Connection
    public void changeUser(String str, String str2) throws SQLException {
        checkClosed();
        try {
            this.f85mc.changeUser(str, str2);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    @Override // com.mysql.jdbc.Connection
    public void checkClosed() throws SQLException {
        if (this.closed) {
            throw SQLError.createSQLException(this.invalidHandleStr, this.exceptionInterceptor);
        }
    }

    @Override // com.mysql.jdbc.Connection
    @Deprecated
    public void clearHasTriedMaster() {
        this.f85mc.clearHasTriedMaster();
    }

    @Override // java.sql.Connection
    public void clearWarnings() throws SQLException {
        checkClosed();
        try {
            this.f85mc.clearWarnings();
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    public PreparedStatement clientPrepare(String str) throws SQLException {
        checkClosed();
        try {
            return new PreparedStatementWrapper(this, this.pooledConnection, this.f85mc.clientPrepareStatement(str));
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // com.mysql.jdbc.Connection
    public PreparedStatement clientPrepareStatement(String str) throws SQLException {
        checkClosed();
        try {
            return PreparedStatementWrapper.getInstance(this, this.pooledConnection, this.f85mc.clientPrepareStatement(str));
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // java.sql.Connection, java.lang.AutoCloseable
    public void close() throws SQLException {
        close(true);
    }

    @Override // java.sql.Connection
    public void commit() throws SQLException {
        checkClosed();
        if (isInGlobalTx()) {
            throw SQLError.createSQLException("Can't call commit() on an XAConnection associated with a global transaction", SQLError.SQL_STATE_INVALID_TRANSACTION_TERMINATION, MysqlErrorNumbers.ER_XA_RMERR, this.exceptionInterceptor);
        }
        try {
            this.f85mc.commit();
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    @Override // java.sql.Connection
    public Statement createStatement() throws SQLException {
        checkClosed();
        try {
            return StatementWrapper.getInstance(this, this.pooledConnection, this.f85mc.createStatement());
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String exposeAsXml() throws SQLException {
        checkClosed();
        try {
            return this.f85mc.exposeAsXml();
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // com.mysql.jdbc.Connection
    public int getActiveStatementCount() {
        return this.f85mc.getActiveStatementCount();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAllowLoadLocalInfile() {
        return this.f85mc.getAllowLoadLocalInfile();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAllowMasterDownConnections() {
        return this.f85mc.getAllowMasterDownConnections();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAllowMultiQueries() {
        return this.f85mc.getAllowMultiQueries();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAllowNanAndInf() {
        return this.f85mc.getAllowNanAndInf();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAllowPublicKeyRetrieval() {
        return this.f85mc.getAllowPublicKeyRetrieval();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAllowSlaveDownConnections() {
        return this.f85mc.getAllowSlaveDownConnections();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAllowUrlInLocalInfile() {
        return this.f85mc.getAllowUrlInLocalInfile();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAlwaysSendSetIsolation() {
        return this.f85mc.getAlwaysSendSetIsolation();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getAuthenticationPlugins() {
        return this.f85mc.getAuthenticationPlugins();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAutoClosePStmtStreams() {
        return this.f85mc.getAutoClosePStmtStreams();
    }

    @Override // java.sql.Connection
    public boolean getAutoCommit() throws SQLException {
        checkClosed();
        try {
            return this.f85mc.getAutoCommit();
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return false;
        }
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAutoDeserialize() {
        return this.f85mc.getAutoDeserialize();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAutoGenerateTestcaseScript() {
        return this.f85mc.getAutoGenerateTestcaseScript();
    }

    @Override // com.mysql.jdbc.Connection
    public int getAutoIncrementIncrement() {
        return this.f85mc.getAutoIncrementIncrement();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAutoReconnectForPools() {
        return this.f85mc.getAutoReconnectForPools();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getAutoSlowLog() {
        return this.f85mc.getAutoSlowLog();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getBlobSendChunkSize() {
        return this.f85mc.getBlobSendChunkSize();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getBlobsAreStrings() {
        return this.f85mc.getBlobsAreStrings();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCacheCallableStatements() {
        return this.f85mc.getCacheCallableStatements();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCacheCallableStmts() {
        return this.f85mc.getCacheCallableStmts();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCacheDefaultTimezone() {
        return this.f85mc.getCacheDefaultTimezone();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCachePrepStmts() {
        return this.f85mc.getCachePrepStmts();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCachePreparedStatements() {
        return this.f85mc.getCachePreparedStatements();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCacheResultSetMetadata() {
        return this.f85mc.getCacheResultSetMetadata();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCacheServerConfiguration() {
        return this.f85mc.getCacheServerConfiguration();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getCallableStatementCacheSize() {
        return this.f85mc.getCallableStatementCacheSize();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getCallableStmtCacheSize() {
        return this.f85mc.getCallableStmtCacheSize();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCapitalizeTypeNames() {
        return this.f85mc.getCapitalizeTypeNames();
    }

    @Override // java.sql.Connection
    public String getCatalog() throws SQLException {
        checkClosed();
        try {
            return this.f85mc.getCatalog();
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getCharacterSetResults() {
        return this.f85mc.getCharacterSetResults();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getClientCertificateKeyStorePassword() {
        return this.f85mc.getClientCertificateKeyStorePassword();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getClientCertificateKeyStoreType() {
        return this.f85mc.getClientCertificateKeyStoreType();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getClientCertificateKeyStoreUrl() {
        return this.f85mc.getClientCertificateKeyStoreUrl();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getClientInfoProvider() {
        return this.f85mc.getClientInfoProvider();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getClobCharacterEncoding() {
        return this.f85mc.getClobCharacterEncoding();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getClobberStreamingResults() {
        return this.f85mc.getClobberStreamingResults();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCompensateOnDuplicateKeyUpdateCounts() {
        return this.f85mc.getCompensateOnDuplicateKeyUpdateCounts();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getConnectTimeout() {
        return this.f85mc.getConnectTimeout();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getConnectionAttributes() throws SQLException {
        return this.f85mc.getConnectionAttributes();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getConnectionCollation() {
        return this.f85mc.getConnectionCollation();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getConnectionLifecycleInterceptors() {
        return this.f85mc.getConnectionLifecycleInterceptors();
    }

    @Override // com.mysql.jdbc.Connection
    public Object getConnectionMutex() {
        return this.f85mc.getConnectionMutex();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getContinueBatchOnError() {
        return this.f85mc.getContinueBatchOnError();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getCreateDatabaseIfNotExist() {
        return this.f85mc.getCreateDatabaseIfNotExist();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getDefaultAuthenticationPlugin() {
        return this.f85mc.getDefaultAuthenticationPlugin();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getDefaultFetchSize() {
        return this.f85mc.getDefaultFetchSize();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getDetectCustomCollations() {
        return this.f85mc.getDetectCustomCollations();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getDisabledAuthenticationPlugins() {
        return this.f85mc.getDisabledAuthenticationPlugins();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getDisconnectOnExpiredPasswords() {
        return this.f85mc.getDisconnectOnExpiredPasswords();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getDontCheckOnDuplicateKeyUpdateInSQL() {
        return this.f85mc.getDontCheckOnDuplicateKeyUpdateInSQL();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getDontTrackOpenResources() {
        return this.f85mc.getDontTrackOpenResources();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getDumpMetadataOnColumnNotFound() {
        return this.f85mc.getDumpMetadataOnColumnNotFound();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getDumpQueriesOnException() {
        return this.f85mc.getDumpQueriesOnException();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getDynamicCalendars() {
        return this.f85mc.getDynamicCalendars();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getElideSetAutoCommits() {
        return this.f85mc.getElideSetAutoCommits();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getEmptyStringsConvertToZero() {
        return this.f85mc.getEmptyStringsConvertToZero();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getEmulateLocators() {
        return this.f85mc.getEmulateLocators();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getEmulateUnsupportedPstmts() {
        return this.f85mc.getEmulateUnsupportedPstmts();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getEnableEscapeProcessing() {
        return this.f85mc.getEnableEscapeProcessing();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getEnablePacketDebug() {
        return this.f85mc.getEnablePacketDebug();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getEnableQueryTimeouts() {
        return this.f85mc.getEnableQueryTimeouts();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getEnabledSSLCipherSuites() {
        return this.f85mc.getEnabledSSLCipherSuites();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getEnabledTLSProtocols() {
        return this.f85mc.getEnabledTLSProtocols();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getEncoding() {
        return this.f85mc.getEncoding();
    }

    @Override // com.mysql.jdbc.ConnectionProperties, com.mysql.jdbc.MySQLConnection
    public ExceptionInterceptor getExceptionInterceptor() {
        return this.pooledConnection.getExceptionInterceptor();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getExceptionInterceptors() {
        return this.f85mc.getExceptionInterceptors();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getExplainSlowQueries() {
        return this.f85mc.getExplainSlowQueries();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getFailOverReadOnly() {
        return this.f85mc.getFailOverReadOnly();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getFunctionsNeverReturnBlobs() {
        return this.f85mc.getFunctionsNeverReturnBlobs();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getGatherPerfMetrics() {
        return this.f85mc.getGatherPerfMetrics();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getGatherPerformanceMetrics() {
        return this.f85mc.getGatherPerformanceMetrics();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getGenerateSimpleParameterMetadata() {
        return this.f85mc.getGenerateSimpleParameterMetadata();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getGetProceduresReturnsFunctions() {
        return this.f85mc.getGetProceduresReturnsFunctions();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getHoldResultsOpenOverStatementClose() {
        return this.f85mc.getHoldResultsOpenOverStatementClose();
    }

    @Override // java.sql.Connection
    public int getHoldability() throws SQLException {
        checkClosed();
        try {
            return this.f85mc.getHoldability();
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return 1;
        }
    }

    @Override // com.mysql.jdbc.Connection
    public String getHost() {
        return this.f85mc.getHost();
    }

    @Override // com.mysql.jdbc.Connection
    public long getIdleFor() {
        return this.f85mc.getIdleFor();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getIgnoreNonTxTables() {
        return this.f85mc.getIgnoreNonTxTables();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getIncludeInnodbStatusInDeadlockExceptions() {
        return this.f85mc.getIncludeInnodbStatusInDeadlockExceptions();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getIncludeThreadDumpInDeadlockExceptions() {
        return this.f85mc.getIncludeThreadDumpInDeadlockExceptions();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getIncludeThreadNamesAsStatementComment() {
        return this.f85mc.getIncludeThreadNamesAsStatementComment();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getInitialTimeout() {
        return this.f85mc.getInitialTimeout();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getInteractiveClient() {
        return this.f85mc.getInteractiveClient();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getIsInteractiveClient() {
        return this.f85mc.getIsInteractiveClient();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getJdbcCompliantTruncation() {
        return this.f85mc.getJdbcCompliantTruncation();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getJdbcCompliantTruncationForReads() {
        return this.f85mc.getJdbcCompliantTruncationForReads();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLargeRowSizeThreshold() {
        return this.f85mc.getLargeRowSizeThreshold();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLoadBalanceAutoCommitStatementRegex() {
        return this.f85mc.getLoadBalanceAutoCommitStatementRegex();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getLoadBalanceAutoCommitStatementThreshold() {
        return this.f85mc.getLoadBalanceAutoCommitStatementThreshold();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getLoadBalanceBlacklistTimeout() {
        return this.f85mc.getLoadBalanceBlacklistTimeout();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLoadBalanceConnectionGroup() {
        return this.f85mc.getLoadBalanceConnectionGroup();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getLoadBalanceEnableJMX() {
        return this.f85mc.getLoadBalanceEnableJMX();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLoadBalanceExceptionChecker() {
        return this.f85mc.getLoadBalanceExceptionChecker();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getLoadBalanceHostRemovalGracePeriod() {
        return this.f85mc.getLoadBalanceHostRemovalGracePeriod();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getLoadBalancePingTimeout() {
        return this.f85mc.getLoadBalancePingTimeout();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLoadBalanceSQLExceptionSubclassFailover() {
        return this.f85mc.getLoadBalanceSQLExceptionSubclassFailover();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLoadBalanceSQLStateFailover() {
        return this.f85mc.getLoadBalanceSQLStateFailover();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLoadBalanceStrategy() {
        return this.f85mc.getLoadBalanceStrategy();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getLoadBalanceValidateConnectionOnSwapServer() {
        return this.f85mc.getLoadBalanceValidateConnectionOnSwapServer();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLocalSocketAddress() {
        return this.f85mc.getLocalSocketAddress();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getLocatorFetchBufferSize() {
        return this.f85mc.getLocatorFetchBufferSize();
    }

    @Override // com.mysql.jdbc.Connection
    public Log getLog() throws SQLException {
        return this.f85mc.getLog();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getLogSlowQueries() {
        return this.f85mc.getLogSlowQueries();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getLogXaCommands() {
        return this.f85mc.getLogXaCommands();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLogger() {
        return this.f85mc.getLogger();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getLoggerClassName() {
        return this.f85mc.getLoggerClassName();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getMaintainTimeStats() {
        return this.f85mc.getMaintainTimeStats();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getMaxAllowedPacket() {
        return this.f85mc.getMaxAllowedPacket();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getMaxQuerySizeToLog() {
        return this.f85mc.getMaxQuerySizeToLog();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getMaxReconnects() {
        return this.f85mc.getMaxReconnects();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getMaxRows() {
        return this.f85mc.getMaxRows();
    }

    @Override // java.sql.Connection
    public DatabaseMetaData getMetaData() throws SQLException {
        checkClosed();
        try {
            return this.f85mc.getMetaData();
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getMetadataCacheSize() {
        return this.f85mc.getMetadataCacheSize();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getNetTimeoutForStreamingResults() {
        return this.f85mc.getNetTimeoutForStreamingResults();
    }

    @Override // com.mysql.jdbc.Connection
    public int getNetworkTimeout() throws SQLException {
        return this.f85mc.getNetworkTimeout();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getNoAccessToProcedureBodies() {
        return this.f85mc.getNoAccessToProcedureBodies();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getNoDatetimeStringSync() {
        return this.f85mc.getNoDatetimeStringSync();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getNoTimezoneConversionForDateType() {
        return this.f85mc.getNoTimezoneConversionForDateType();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getNoTimezoneConversionForTimeType() {
        return this.f85mc.getNoTimezoneConversionForTimeType();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getNullCatalogMeansCurrent() {
        return this.f85mc.getNullCatalogMeansCurrent();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getNullNamePatternMatchesAll() {
        return this.f85mc.getNullNamePatternMatchesAll();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getOverrideSupportsIntegrityEnhancementFacility() {
        return this.f85mc.getOverrideSupportsIntegrityEnhancementFacility();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getPacketDebugBufferSize() {
        return this.f85mc.getPacketDebugBufferSize();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getPadCharsWithSpace() {
        return this.f85mc.getPadCharsWithSpace();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getParanoid() {
        return this.f85mc.getParanoid();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getParseInfoCacheFactory() {
        return this.f85mc.getParseInfoCacheFactory();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getPasswordCharacterEncoding() {
        return this.f85mc.getPasswordCharacterEncoding();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getPedantic() {
        return this.f85mc.getPedantic();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getPinGlobalTxToPhysicalConnection() {
        return this.f85mc.getPinGlobalTxToPhysicalConnection();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getPopulateInsertRowWithDefaultValues() {
        return this.f85mc.getPopulateInsertRowWithDefaultValues();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getPrepStmtCacheSize() {
        return this.f85mc.getPrepStmtCacheSize();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getPrepStmtCacheSqlLimit() {
        return this.f85mc.getPrepStmtCacheSqlLimit();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getPreparedStatementCacheSize() {
        return this.f85mc.getPreparedStatementCacheSize();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getPreparedStatementCacheSqlLimit() {
        return this.f85mc.getPreparedStatementCacheSqlLimit();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getProcessEscapeCodesForPrepStmts() {
        return this.f85mc.getProcessEscapeCodesForPrepStmts();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getProfileSQL() {
        return this.f85mc.getProfileSQL();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getProfileSql() {
        return this.f85mc.getProfileSql();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getProfilerEventHandler() {
        return this.f85mc.getProfilerEventHandler();
    }

    @Override // com.mysql.jdbc.Connection
    public Properties getProperties() {
        return this.f85mc.getProperties();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getPropertiesTransform() {
        return this.f85mc.getPropertiesTransform();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getQueriesBeforeRetryMaster() {
        return this.f85mc.getQueriesBeforeRetryMaster();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getQueryTimeoutKillsConnection() {
        return this.f85mc.getQueryTimeoutKillsConnection();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getReadFromMasterWhenNoSlaves() {
        return this.f85mc.getReadFromMasterWhenNoSlaves();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getReadOnlyPropagatesToServer() {
        return this.f85mc.getReadOnlyPropagatesToServer();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getReconnectAtTxEnd() {
        return this.f85mc.getReconnectAtTxEnd();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getRelaxAutoCommit() {
        return this.f85mc.getRelaxAutoCommit();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getReplicationEnableJMX() {
        return this.f85mc.getReplicationEnableJMX();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getReportMetricsIntervalMillis() {
        return this.f85mc.getReportMetricsIntervalMillis();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getRequireSSL() {
        return this.f85mc.getRequireSSL();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getResourceId() {
        return this.f85mc.getResourceId();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getResultSetSizeThreshold() {
        return this.f85mc.getResultSetSizeThreshold();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getRetainStatementAfterResultSetClose() {
        return this.f85mc.getRetainStatementAfterResultSetClose();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getRetriesAllDown() {
        return this.f85mc.getRetriesAllDown();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getRewriteBatchedStatements() {
        return this.f85mc.getRewriteBatchedStatements();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getRollbackOnPooledClose() {
        return this.f85mc.getRollbackOnPooledClose();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getRoundRobinLoadBalance() {
        return this.f85mc.getRoundRobinLoadBalance();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getRunningCTS13() {
        return this.f85mc.getRunningCTS13();
    }

    @Override // com.mysql.jdbc.Connection
    public String getSchema() throws SQLException {
        return this.f85mc.getSchema();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getSecondsBeforeRetryMaster() {
        return this.f85mc.getSecondsBeforeRetryMaster();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getSelfDestructOnPingMaxOperations() {
        return this.f85mc.getSelfDestructOnPingMaxOperations();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getSelfDestructOnPingSecondsLifetime() {
        return this.f85mc.getSelfDestructOnPingSecondsLifetime();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getSendFractionalSeconds() {
        return this.f85mc.getSendFractionalSeconds();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getServerAffinityOrder() {
        return this.f85mc.getServerAffinityOrder();
    }

    @Override // com.mysql.jdbc.Connection
    @Deprecated
    public String getServerCharacterEncoding() {
        return getServerCharset();
    }

    @Override // com.mysql.jdbc.Connection
    public String getServerCharset() {
        return this.f85mc.getServerCharset();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getServerConfigCacheFactory() {
        return this.f85mc.getServerConfigCacheFactory();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getServerRSAPublicKeyFile() {
        return this.f85mc.getServerRSAPublicKeyFile();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getServerTimezone() {
        return this.f85mc.getServerTimezone();
    }

    @Override // com.mysql.jdbc.Connection
    public TimeZone getServerTimezoneTZ() {
        return this.f85mc.getServerTimezoneTZ();
    }

    @Override // com.mysql.jdbc.Connection
    public int getSessionMaxRows() {
        return this.f85mc.getSessionMaxRows();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getSessionVariables() {
        return this.f85mc.getSessionVariables();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getSlowQueryThresholdMillis() {
        return this.f85mc.getSlowQueryThresholdMillis();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public long getSlowQueryThresholdNanos() {
        return this.f85mc.getSlowQueryThresholdNanos();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getSocketFactory() {
        return this.f85mc.getSocketFactory();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getSocketFactoryClassName() {
        return this.f85mc.getSocketFactoryClassName();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getSocketTimeout() {
        return this.f85mc.getSocketTimeout();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getSocksProxyHost() {
        return this.f85mc.getSocksProxyHost();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getSocksProxyPort() {
        return this.f85mc.getSocksProxyPort();
    }

    @Override // com.mysql.jdbc.Connection
    public String getStatementComment() {
        return this.f85mc.getStatementComment();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getStatementInterceptors() {
        return this.f85mc.getStatementInterceptors();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getStrictFloatingPoint() {
        return this.f85mc.getStrictFloatingPoint();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getStrictUpdates() {
        return this.f85mc.getStrictUpdates();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getTcpKeepAlive() {
        return this.f85mc.getTcpKeepAlive();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getTcpNoDelay() {
        return this.f85mc.getTcpNoDelay();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getTcpRcvBuf() {
        return this.f85mc.getTcpRcvBuf();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getTcpSndBuf() {
        return this.f85mc.getTcpSndBuf();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public int getTcpTrafficClass() {
        return this.f85mc.getTcpTrafficClass();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getTinyInt1isBit() {
        return this.f85mc.getTinyInt1isBit();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getTraceProtocol() {
        return this.f85mc.getTraceProtocol();
    }

    @Override // java.sql.Connection
    public int getTransactionIsolation() throws SQLException {
        checkClosed();
        try {
            return this.f85mc.getTransactionIsolation();
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return 4;
        }
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getTransformedBitIsBoolean() {
        return this.f85mc.getTransformedBitIsBoolean();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getTreatUtilDateAsTimestamp() {
        return this.f85mc.getTreatUtilDateAsTimestamp();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getTrustCertificateKeyStorePassword() {
        return this.f85mc.getTrustCertificateKeyStorePassword();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getTrustCertificateKeyStoreType() {
        return this.f85mc.getTrustCertificateKeyStoreType();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getTrustCertificateKeyStoreUrl() {
        return this.f85mc.getTrustCertificateKeyStoreUrl();
    }

    @Override // java.sql.Connection
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        checkClosed();
        try {
            return this.f85mc.getTypeMap();
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUltraDevHack() {
        return this.f85mc.getUltraDevHack();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseAffectedRows() {
        return this.f85mc.getUseAffectedRows();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseBlobToStoreUTF8OutsideBMP() {
        return this.f85mc.getUseBlobToStoreUTF8OutsideBMP();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseColumnNamesInFindColumn() {
        return this.f85mc.getUseColumnNamesInFindColumn();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseCompression() {
        return this.f85mc.getUseCompression();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getUseConfigs() {
        return this.f85mc.getUseConfigs();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseCursorFetch() {
        return this.f85mc.getUseCursorFetch();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseDirectRowUnpack() {
        return this.f85mc.getUseDirectRowUnpack();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseDynamicCharsetInfo() {
        return this.f85mc.getUseDynamicCharsetInfo();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseFastDateParsing() {
        return this.f85mc.getUseFastDateParsing();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseFastIntParsing() {
        return this.f85mc.getUseFastIntParsing();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseGmtMillisForDatetimes() {
        return this.f85mc.getUseGmtMillisForDatetimes();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseHostsInPrivileges() {
        return this.f85mc.getUseHostsInPrivileges();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseInformationSchema() {
        return this.f85mc.getUseInformationSchema();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseJDBCCompliantTimezoneShift() {
        return this.f85mc.getUseJDBCCompliantTimezoneShift();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseJvmCharsetConverters() {
        return this.f85mc.getUseJvmCharsetConverters();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseLegacyDatetimeCode() {
        return this.f85mc.getUseLegacyDatetimeCode();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseLocalSessionState() {
        return this.f85mc.getUseLocalSessionState();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseLocalTransactionState() {
        return this.f85mc.getUseLocalTransactionState();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseNanosForElapsedTime() {
        return this.f85mc.getUseNanosForElapsedTime();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseOldAliasMetadataBehavior() {
        return this.f85mc.getUseOldAliasMetadataBehavior();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseOldUTF8Behavior() {
        return this.f85mc.getUseOldUTF8Behavior();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseOnlyServerErrorMessages() {
        return this.f85mc.getUseOnlyServerErrorMessages();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseReadAheadInput() {
        return this.f85mc.getUseReadAheadInput();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseSSL() {
        return this.f85mc.getUseSSL();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseSSPSCompatibleTimezoneShift() {
        return this.f85mc.getUseSSPSCompatibleTimezoneShift();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseServerPrepStmts() {
        return this.f85mc.getUseServerPrepStmts();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseServerPreparedStmts() {
        return this.f85mc.getUseServerPreparedStmts();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseSqlStateCodes() {
        return this.f85mc.getUseSqlStateCodes();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseStreamLengthsInPrepStmts() {
        return this.f85mc.getUseStreamLengthsInPrepStmts();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseTimezone() {
        return this.f85mc.getUseTimezone();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseUltraDevWorkAround() {
        return this.f85mc.getUseUltraDevWorkAround();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseUnbufferedInput() {
        return this.f85mc.getUseUnbufferedInput();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseUnicode() {
        return this.f85mc.getUseUnicode();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getUseUsageAdvisor() {
        return this.f85mc.getUseUsageAdvisor();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getUtf8OutsideBmpExcludedColumnNamePattern() {
        return this.f85mc.getUtf8OutsideBmpExcludedColumnNamePattern();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getUtf8OutsideBmpIncludedColumnNamePattern() {
        return this.f85mc.getUtf8OutsideBmpIncludedColumnNamePattern();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getVerifyServerCertificate() {
        return this.f85mc.getVerifyServerCertificate();
    }

    @Override // java.sql.Connection
    public SQLWarning getWarnings() throws SQLException {
        checkClosed();
        try {
            return this.f85mc.getWarnings();
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean getYearIsDateType() {
        return this.f85mc.getYearIsDateType();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public String getZeroDateTimeBehavior() {
        return this.f85mc.getZeroDateTimeBehavior();
    }

    @Override // com.mysql.jdbc.Connection
    public boolean hasSameProperties(Connection connection) {
        return this.f85mc.hasSameProperties(connection);
    }

    @Override // com.mysql.jdbc.Connection
    @Deprecated
    public boolean hasTriedMaster() {
        return this.f85mc.hasTriedMaster();
    }

    @Override // com.mysql.jdbc.Connection
    public void initializeExtension(Extension extension) throws SQLException {
        this.f85mc.initializeExtension(extension);
    }

    @Override // com.mysql.jdbc.Connection
    public boolean isAbonormallyLongQuery(long j) {
        return this.f85mc.isAbonormallyLongQuery(j);
    }

    @Override // java.sql.Connection
    public boolean isClosed() throws SQLException {
        return this.closed || this.f85mc.isClosed();
    }

    @Override // com.mysql.jdbc.Connection
    public boolean isInGlobalTx() {
        return this.f85mc.isInGlobalTx();
    }

    @Override // com.mysql.jdbc.Connection
    public boolean isMasterConnection() {
        return this.f85mc.isMasterConnection();
    }

    @Override // com.mysql.jdbc.Connection
    public boolean isNoBackslashEscapesSet() {
        return this.f85mc.isNoBackslashEscapesSet();
    }

    @Override // java.sql.Connection
    public boolean isReadOnly() throws SQLException {
        checkClosed();
        try {
            return this.f85mc.isReadOnly();
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return false;
        }
    }

    @Override // com.mysql.jdbc.Connection
    public boolean isSameResource(Connection connection) {
        return connection instanceof ConnectionWrapper ? this.f85mc.isSameResource(((ConnectionWrapper) connection).f85mc) : this.f85mc.isSameResource(connection);
    }

    @Override // com.mysql.jdbc.Connection
    public boolean isServerLocal() throws SQLException {
        return this.f85mc.isServerLocal();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean isUseSSLExplicit() {
        return this.f85mc.isUseSSLExplicit();
    }

    @Override // com.mysql.jdbc.Connection
    public boolean lowerCaseTableNames() {
        return this.f85mc.lowerCaseTableNames();
    }

    @Override // java.sql.Connection
    public String nativeSQL(String str) throws SQLException {
        checkClosed();
        try {
            return this.f85mc.nativeSQL(str);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // com.mysql.jdbc.Connection
    public boolean parserKnowsUnicode() {
        return this.f85mc.parserKnowsUnicode();
    }

    @Override // com.mysql.jdbc.Connection
    public void ping() throws SQLException {
        Connection connection = this.f85mc;
        if (connection != null) {
            connection.ping();
        }
    }

    @Override // java.sql.Connection
    public CallableStatement prepareCall(String str) throws SQLException {
        checkClosed();
        try {
            return CallableStatementWrapper.getInstance(this, this.pooledConnection, this.f85mc.prepareCall(str));
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // java.sql.Connection
    public PreparedStatement prepareStatement(String str) throws SQLException {
        checkClosed();
        try {
            return PreparedStatementWrapper.getInstance(this, this.pooledConnection, this.f85mc.prepareStatement(str));
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // java.sql.Connection
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        checkClosed();
        try {
            this.f85mc.releaseSavepoint(savepoint);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    @Override // com.mysql.jdbc.Connection
    public void reportQueryTime(long j) {
        this.f85mc.reportQueryTime(j);
    }

    @Override // com.mysql.jdbc.Connection
    public void resetServerState() throws SQLException {
        checkClosed();
        try {
            this.f85mc.resetServerState();
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    @Override // java.sql.Connection
    public void rollback() throws SQLException {
        checkClosed();
        if (isInGlobalTx()) {
            throw SQLError.createSQLException("Can't call rollback() on an XAConnection associated with a global transaction", SQLError.SQL_STATE_INVALID_TRANSACTION_TERMINATION, MysqlErrorNumbers.ER_XA_RMERR, this.exceptionInterceptor);
        }
        try {
            this.f85mc.rollback();
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    @Override // com.mysql.jdbc.Connection
    public PreparedStatement serverPrepareStatement(String str) throws SQLException {
        checkClosed();
        try {
            return PreparedStatementWrapper.getInstance(this, this.pooledConnection, this.f85mc.serverPrepareStatement(str));
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAllowLoadLocalInfile(boolean z) {
        this.f85mc.setAllowLoadLocalInfile(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAllowMasterDownConnections(boolean z) {
        this.f85mc.setAllowMasterDownConnections(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAllowMultiQueries(boolean z) {
        this.f85mc.setAllowMultiQueries(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAllowNanAndInf(boolean z) {
        this.f85mc.setAllowNanAndInf(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAllowPublicKeyRetrieval(boolean z) throws SQLException {
        this.f85mc.setAllowPublicKeyRetrieval(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAllowSlaveDownConnections(boolean z) {
        this.f85mc.setAllowSlaveDownConnections(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAllowUrlInLocalInfile(boolean z) {
        this.f85mc.setAllowUrlInLocalInfile(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAlwaysSendSetIsolation(boolean z) {
        this.f85mc.setAlwaysSendSetIsolation(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAuthenticationPlugins(String str) {
        this.f85mc.setAuthenticationPlugins(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAutoClosePStmtStreams(boolean z) {
        this.f85mc.setAutoClosePStmtStreams(z);
    }

    @Override // java.sql.Connection
    public void setAutoCommit(boolean z) throws SQLException {
        checkClosed();
        if (z && isInGlobalTx()) {
            throw SQLError.createSQLException("Can't set autocommit to 'true' on an XAConnection", SQLError.SQL_STATE_INVALID_TRANSACTION_TERMINATION, MysqlErrorNumbers.ER_XA_RMERR, this.exceptionInterceptor);
        }
        try {
            this.f85mc.setAutoCommit(z);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAutoDeserialize(boolean z) {
        this.f85mc.setAutoDeserialize(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAutoGenerateTestcaseScript(boolean z) {
        this.f85mc.setAutoGenerateTestcaseScript(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAutoReconnect(boolean z) {
        this.f85mc.setAutoReconnect(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAutoReconnectForConnectionPools(boolean z) {
        this.f85mc.setAutoReconnectForConnectionPools(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAutoReconnectForPools(boolean z) {
        this.f85mc.setAutoReconnectForPools(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setAutoSlowLog(boolean z) {
        this.f85mc.setAutoSlowLog(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setBlobSendChunkSize(String str) throws SQLException {
        this.f85mc.setBlobSendChunkSize(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setBlobsAreStrings(boolean z) {
        this.f85mc.setBlobsAreStrings(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCacheCallableStatements(boolean z) {
        this.f85mc.setCacheCallableStatements(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCacheCallableStmts(boolean z) {
        this.f85mc.setCacheCallableStmts(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCacheDefaultTimezone(boolean z) {
        this.f85mc.setCacheDefaultTimezone(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCachePrepStmts(boolean z) {
        this.f85mc.setCachePrepStmts(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCachePreparedStatements(boolean z) {
        this.f85mc.setCachePreparedStatements(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCacheResultSetMetadata(boolean z) {
        this.f85mc.setCacheResultSetMetadata(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCacheServerConfiguration(boolean z) {
        this.f85mc.setCacheServerConfiguration(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCallableStatementCacheSize(int i) throws SQLException {
        this.f85mc.setCallableStatementCacheSize(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCallableStmtCacheSize(int i) throws SQLException {
        this.f85mc.setCallableStmtCacheSize(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCapitalizeDBMDTypes(boolean z) {
        this.f85mc.setCapitalizeDBMDTypes(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCapitalizeTypeNames(boolean z) {
        this.f85mc.setCapitalizeTypeNames(z);
    }

    @Override // java.sql.Connection
    public void setCatalog(String str) throws SQLException {
        checkClosed();
        try {
            this.f85mc.setCatalog(str);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCharacterEncoding(String str) {
        this.f85mc.setCharacterEncoding(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCharacterSetResults(String str) {
        this.f85mc.setCharacterSetResults(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setClientCertificateKeyStorePassword(String str) {
        this.f85mc.setClientCertificateKeyStorePassword(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setClientCertificateKeyStoreType(String str) {
        this.f85mc.setClientCertificateKeyStoreType(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setClientCertificateKeyStoreUrl(String str) {
        this.f85mc.setClientCertificateKeyStoreUrl(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setClientInfoProvider(String str) {
        this.f85mc.setClientInfoProvider(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setClobCharacterEncoding(String str) {
        this.f85mc.setClobCharacterEncoding(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setClobberStreamingResults(boolean z) {
        this.f85mc.setClobberStreamingResults(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCompensateOnDuplicateKeyUpdateCounts(boolean z) {
        this.f85mc.setCompensateOnDuplicateKeyUpdateCounts(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setConnectTimeout(int i) throws SQLException {
        this.f85mc.setConnectTimeout(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setConnectionCollation(String str) {
        this.f85mc.setConnectionCollation(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setConnectionLifecycleInterceptors(String str) {
        this.f85mc.setConnectionLifecycleInterceptors(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setContinueBatchOnError(boolean z) {
        this.f85mc.setContinueBatchOnError(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setCreateDatabaseIfNotExist(boolean z) {
        this.f85mc.setCreateDatabaseIfNotExist(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDefaultAuthenticationPlugin(String str) {
        this.f85mc.setDefaultAuthenticationPlugin(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDefaultFetchSize(int i) throws SQLException {
        this.f85mc.setDefaultFetchSize(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDetectCustomCollations(boolean z) {
        this.f85mc.setDetectCustomCollations(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDetectServerPreparedStmts(boolean z) {
        this.f85mc.setDetectServerPreparedStmts(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDisabledAuthenticationPlugins(String str) {
        this.f85mc.setDisabledAuthenticationPlugins(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDisconnectOnExpiredPasswords(boolean z) {
        this.f85mc.setDisconnectOnExpiredPasswords(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDontCheckOnDuplicateKeyUpdateInSQL(boolean z) {
        this.f85mc.setDontCheckOnDuplicateKeyUpdateInSQL(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDontTrackOpenResources(boolean z) {
        this.f85mc.setDontTrackOpenResources(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDumpMetadataOnColumnNotFound(boolean z) {
        this.f85mc.setDumpMetadataOnColumnNotFound(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDumpQueriesOnException(boolean z) {
        this.f85mc.setDumpQueriesOnException(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setDynamicCalendars(boolean z) {
        this.f85mc.setDynamicCalendars(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setElideSetAutoCommits(boolean z) {
        this.f85mc.setElideSetAutoCommits(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setEmptyStringsConvertToZero(boolean z) {
        this.f85mc.setEmptyStringsConvertToZero(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setEmulateLocators(boolean z) {
        this.f85mc.setEmulateLocators(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setEmulateUnsupportedPstmts(boolean z) {
        this.f85mc.setEmulateUnsupportedPstmts(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setEnableEscapeProcessing(boolean z) {
        this.f85mc.setEnableEscapeProcessing(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setEnablePacketDebug(boolean z) {
        this.f85mc.setEnablePacketDebug(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setEnableQueryTimeouts(boolean z) {
        this.f85mc.setEnableQueryTimeouts(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setEnabledSSLCipherSuites(String str) {
        this.f85mc.setEnabledSSLCipherSuites(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setEnabledTLSProtocols(String str) {
        this.f85mc.setEnabledTLSProtocols(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setEncoding(String str) {
        this.f85mc.setEncoding(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setExceptionInterceptors(String str) {
        this.f85mc.setExceptionInterceptors(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setExplainSlowQueries(boolean z) {
        this.f85mc.setExplainSlowQueries(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setFailOverReadOnly(boolean z) {
        this.f85mc.setFailOverReadOnly(z);
    }

    @Override // com.mysql.jdbc.Connection
    public void setFailedOver(boolean z) {
        this.f85mc.setFailedOver(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setFunctionsNeverReturnBlobs(boolean z) {
        this.f85mc.setFunctionsNeverReturnBlobs(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setGatherPerfMetrics(boolean z) {
        this.f85mc.setGatherPerfMetrics(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setGatherPerformanceMetrics(boolean z) {
        this.f85mc.setGatherPerformanceMetrics(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setGenerateSimpleParameterMetadata(boolean z) {
        this.f85mc.setGenerateSimpleParameterMetadata(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setGetProceduresReturnsFunctions(boolean z) {
        this.f85mc.setGetProceduresReturnsFunctions(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setHoldResultsOpenOverStatementClose(boolean z) {
        this.f85mc.setHoldResultsOpenOverStatementClose(z);
    }

    @Override // java.sql.Connection
    public void setHoldability(int i) throws SQLException {
        checkClosed();
        try {
            this.f85mc.setHoldability(i);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setIgnoreNonTxTables(boolean z) {
        this.f85mc.setIgnoreNonTxTables(z);
    }

    @Override // com.mysql.jdbc.Connection
    public void setInGlobalTx(boolean z) {
        this.f85mc.setInGlobalTx(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setIncludeInnodbStatusInDeadlockExceptions(boolean z) {
        this.f85mc.setIncludeInnodbStatusInDeadlockExceptions(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setIncludeThreadDumpInDeadlockExceptions(boolean z) {
        this.f85mc.setIncludeThreadDumpInDeadlockExceptions(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setIncludeThreadNamesAsStatementComment(boolean z) {
        this.f85mc.setIncludeThreadNamesAsStatementComment(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setInitialTimeout(int i) throws SQLException {
        this.f85mc.setInitialTimeout(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setInteractiveClient(boolean z) {
        this.f85mc.setInteractiveClient(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setIsInteractiveClient(boolean z) {
        this.f85mc.setIsInteractiveClient(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setJdbcCompliantTruncation(boolean z) {
        this.f85mc.setJdbcCompliantTruncation(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setJdbcCompliantTruncationForReads(boolean z) {
        this.f85mc.setJdbcCompliantTruncationForReads(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLargeRowSizeThreshold(String str) throws SQLException {
        this.f85mc.setLargeRowSizeThreshold(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceAutoCommitStatementRegex(String str) {
        this.f85mc.setLoadBalanceAutoCommitStatementRegex(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceAutoCommitStatementThreshold(int i) throws SQLException {
        this.f85mc.setLoadBalanceAutoCommitStatementThreshold(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceBlacklistTimeout(int i) throws SQLException {
        this.f85mc.setLoadBalanceBlacklistTimeout(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceConnectionGroup(String str) {
        this.f85mc.setLoadBalanceConnectionGroup(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceEnableJMX(boolean z) {
        this.f85mc.setLoadBalanceEnableJMX(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceExceptionChecker(String str) {
        this.f85mc.setLoadBalanceExceptionChecker(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceHostRemovalGracePeriod(int i) throws SQLException {
        this.f85mc.setLoadBalanceHostRemovalGracePeriod(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalancePingTimeout(int i) throws SQLException {
        this.f85mc.setLoadBalancePingTimeout(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceSQLExceptionSubclassFailover(String str) {
        this.f85mc.setLoadBalanceSQLExceptionSubclassFailover(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceSQLStateFailover(String str) {
        this.f85mc.setLoadBalanceSQLStateFailover(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceStrategy(String str) {
        this.f85mc.setLoadBalanceStrategy(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoadBalanceValidateConnectionOnSwapServer(boolean z) {
        this.f85mc.setLoadBalanceValidateConnectionOnSwapServer(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLocalSocketAddress(String str) {
        this.f85mc.setLocalSocketAddress(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLocatorFetchBufferSize(String str) throws SQLException {
        this.f85mc.setLocatorFetchBufferSize(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLogSlowQueries(boolean z) {
        this.f85mc.setLogSlowQueries(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLogXaCommands(boolean z) {
        this.f85mc.setLogXaCommands(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLogger(String str) {
        this.f85mc.setLogger(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setLoggerClassName(String str) {
        this.f85mc.setLoggerClassName(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setMaintainTimeStats(boolean z) {
        this.f85mc.setMaintainTimeStats(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setMaxQuerySizeToLog(int i) throws SQLException {
        this.f85mc.setMaxQuerySizeToLog(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setMaxReconnects(int i) throws SQLException {
        this.f85mc.setMaxReconnects(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setMaxRows(int i) throws SQLException {
        this.f85mc.setMaxRows(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setMetadataCacheSize(int i) throws SQLException {
        this.f85mc.setMetadataCacheSize(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setNetTimeoutForStreamingResults(int i) throws SQLException {
        this.f85mc.setNetTimeoutForStreamingResults(i);
    }

    @Override // com.mysql.jdbc.Connection
    public void setNetworkTimeout(Executor executor, int i) throws SQLException {
        this.f85mc.setNetworkTimeout(executor, i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setNoAccessToProcedureBodies(boolean z) {
        this.f85mc.setNoAccessToProcedureBodies(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setNoDatetimeStringSync(boolean z) {
        this.f85mc.setNoDatetimeStringSync(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setNoTimezoneConversionForDateType(boolean z) {
        this.f85mc.setNoTimezoneConversionForDateType(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setNoTimezoneConversionForTimeType(boolean z) {
        this.f85mc.setNoTimezoneConversionForTimeType(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setNullCatalogMeansCurrent(boolean z) {
        this.f85mc.setNullCatalogMeansCurrent(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setNullNamePatternMatchesAll(boolean z) {
        this.f85mc.setNullNamePatternMatchesAll(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setOverrideSupportsIntegrityEnhancementFacility(boolean z) {
        this.f85mc.setOverrideSupportsIntegrityEnhancementFacility(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPacketDebugBufferSize(int i) throws SQLException {
        this.f85mc.setPacketDebugBufferSize(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPadCharsWithSpace(boolean z) {
        this.f85mc.setPadCharsWithSpace(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setParanoid(boolean z) {
        this.f85mc.setParanoid(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setParseInfoCacheFactory(String str) {
        this.f85mc.setParseInfoCacheFactory(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPasswordCharacterEncoding(String str) {
        this.f85mc.setPasswordCharacterEncoding(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPedantic(boolean z) {
        this.f85mc.setPedantic(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPinGlobalTxToPhysicalConnection(boolean z) {
        this.f85mc.setPinGlobalTxToPhysicalConnection(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPopulateInsertRowWithDefaultValues(boolean z) {
        this.f85mc.setPopulateInsertRowWithDefaultValues(z);
    }

    @Override // com.mysql.jdbc.Connection
    @Deprecated
    public void setPreferSlaveDuringFailover(boolean z) {
        this.f85mc.setPreferSlaveDuringFailover(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPrepStmtCacheSize(int i) throws SQLException {
        this.f85mc.setPrepStmtCacheSize(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPrepStmtCacheSqlLimit(int i) throws SQLException {
        this.f85mc.setPrepStmtCacheSqlLimit(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPreparedStatementCacheSize(int i) throws SQLException {
        this.f85mc.setPreparedStatementCacheSize(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPreparedStatementCacheSqlLimit(int i) throws SQLException {
        this.f85mc.setPreparedStatementCacheSqlLimit(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setProcessEscapeCodesForPrepStmts(boolean z) {
        this.f85mc.setProcessEscapeCodesForPrepStmts(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setProfileSQL(boolean z) {
        this.f85mc.setProfileSQL(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setProfileSql(boolean z) {
        this.f85mc.setProfileSql(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setProfilerEventHandler(String str) {
        this.f85mc.setProfilerEventHandler(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setPropertiesTransform(String str) {
        this.f85mc.setPropertiesTransform(str);
    }

    @Override // com.mysql.jdbc.Connection
    public void setProxy(MySQLConnection mySQLConnection) {
        this.f85mc.setProxy(mySQLConnection);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setQueriesBeforeRetryMaster(int i) throws SQLException {
        this.f85mc.setQueriesBeforeRetryMaster(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setQueryTimeoutKillsConnection(boolean z) {
        this.f85mc.setQueryTimeoutKillsConnection(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setReadFromMasterWhenNoSlaves(boolean z) {
        this.f85mc.setReadFromMasterWhenNoSlaves(z);
    }

    @Override // java.sql.Connection
    public void setReadOnly(boolean z) throws SQLException {
        checkClosed();
        try {
            this.f85mc.setReadOnly(z);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setReadOnlyPropagatesToServer(boolean z) {
        this.f85mc.setReadOnlyPropagatesToServer(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setReconnectAtTxEnd(boolean z) {
        this.f85mc.setReconnectAtTxEnd(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setRelaxAutoCommit(boolean z) {
        this.f85mc.setRelaxAutoCommit(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setReplicationEnableJMX(boolean z) {
        this.f85mc.setReplicationEnableJMX(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setReportMetricsIntervalMillis(int i) throws SQLException {
        this.f85mc.setReportMetricsIntervalMillis(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setRequireSSL(boolean z) {
        this.f85mc.setRequireSSL(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setResourceId(String str) {
        this.f85mc.setResourceId(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setResultSetSizeThreshold(int i) throws SQLException {
        this.f85mc.setResultSetSizeThreshold(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setRetainStatementAfterResultSetClose(boolean z) {
        this.f85mc.setRetainStatementAfterResultSetClose(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setRetriesAllDown(int i) throws SQLException {
        this.f85mc.setRetriesAllDown(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setRewriteBatchedStatements(boolean z) {
        this.f85mc.setRewriteBatchedStatements(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setRollbackOnPooledClose(boolean z) {
        this.f85mc.setRollbackOnPooledClose(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setRoundRobinLoadBalance(boolean z) {
        this.f85mc.setRoundRobinLoadBalance(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setRunningCTS13(boolean z) {
        this.f85mc.setRunningCTS13(z);
    }

    @Override // java.sql.Connection
    public Savepoint setSavepoint() throws SQLException {
        checkClosed();
        if (isInGlobalTx()) {
            throw SQLError.createSQLException("Can't set autocommit to 'true' on an XAConnection", SQLError.SQL_STATE_INVALID_TRANSACTION_TERMINATION, MysqlErrorNumbers.ER_XA_RMERR, this.exceptionInterceptor);
        }
        try {
            return this.f85mc.setSavepoint();
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // com.mysql.jdbc.Connection
    public void setSchema(String str) throws SQLException {
        this.f85mc.setSchema(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSecondsBeforeRetryMaster(int i) throws SQLException {
        this.f85mc.setSecondsBeforeRetryMaster(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSelfDestructOnPingMaxOperations(int i) throws SQLException {
        this.f85mc.setSelfDestructOnPingMaxOperations(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSelfDestructOnPingSecondsLifetime(int i) throws SQLException {
        this.f85mc.setSelfDestructOnPingSecondsLifetime(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSendFractionalSeconds(boolean z) {
        this.f85mc.setSendFractionalSeconds(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setServerAffinityOrder(String str) {
        this.f85mc.setServerAffinityOrder(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setServerConfigCacheFactory(String str) {
        this.f85mc.setServerConfigCacheFactory(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setServerRSAPublicKeyFile(String str) throws SQLException {
        this.f85mc.setServerRSAPublicKeyFile(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setServerTimezone(String str) {
        this.f85mc.setServerTimezone(str);
    }

    @Override // com.mysql.jdbc.Connection
    public void setSessionMaxRows(int i) throws SQLException {
        this.f85mc.setSessionMaxRows(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSessionVariables(String str) {
        this.f85mc.setSessionVariables(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSlowQueryThresholdMillis(int i) throws SQLException {
        this.f85mc.setSlowQueryThresholdMillis(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSlowQueryThresholdNanos(long j) throws SQLException {
        this.f85mc.setSlowQueryThresholdNanos(j);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSocketFactory(String str) {
        this.f85mc.setSocketFactory(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSocketFactoryClassName(String str) {
        this.f85mc.setSocketFactoryClassName(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSocketTimeout(int i) throws SQLException {
        this.f85mc.setSocketTimeout(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSocksProxyHost(String str) {
        this.f85mc.setSocksProxyHost(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setSocksProxyPort(int i) throws SQLException {
        this.f85mc.setSocksProxyPort(i);
    }

    @Override // com.mysql.jdbc.Connection
    public void setStatementComment(String str) {
        this.f85mc.setStatementComment(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setStatementInterceptors(String str) {
        this.f85mc.setStatementInterceptors(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setStrictFloatingPoint(boolean z) {
        this.f85mc.setStrictFloatingPoint(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setStrictUpdates(boolean z) {
        this.f85mc.setStrictUpdates(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTcpKeepAlive(boolean z) {
        this.f85mc.setTcpKeepAlive(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTcpNoDelay(boolean z) {
        this.f85mc.setTcpNoDelay(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTcpRcvBuf(int i) throws SQLException {
        this.f85mc.setTcpRcvBuf(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTcpSndBuf(int i) throws SQLException {
        this.f85mc.setTcpSndBuf(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTcpTrafficClass(int i) throws SQLException {
        this.f85mc.setTcpTrafficClass(i);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTinyInt1isBit(boolean z) {
        this.f85mc.setTinyInt1isBit(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTraceProtocol(boolean z) {
        this.f85mc.setTraceProtocol(z);
    }

    @Override // java.sql.Connection
    public void setTransactionIsolation(int i) throws SQLException {
        checkClosed();
        try {
            this.f85mc.setTransactionIsolation(i);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTransformedBitIsBoolean(boolean z) {
        this.f85mc.setTransformedBitIsBoolean(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTreatUtilDateAsTimestamp(boolean z) {
        this.f85mc.setTreatUtilDateAsTimestamp(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTrustCertificateKeyStorePassword(String str) {
        this.f85mc.setTrustCertificateKeyStorePassword(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTrustCertificateKeyStoreType(String str) {
        this.f85mc.setTrustCertificateKeyStoreType(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setTrustCertificateKeyStoreUrl(String str) {
        this.f85mc.setTrustCertificateKeyStoreUrl(str);
    }

    @Override // java.sql.Connection
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        checkClosed();
        try {
            this.f85mc.setTypeMap(map);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUltraDevHack(boolean z) {
        this.f85mc.setUltraDevHack(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseAffectedRows(boolean z) {
        this.f85mc.setUseAffectedRows(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseBlobToStoreUTF8OutsideBMP(boolean z) {
        this.f85mc.setUseBlobToStoreUTF8OutsideBMP(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseColumnNamesInFindColumn(boolean z) {
        this.f85mc.setUseColumnNamesInFindColumn(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseCompression(boolean z) {
        this.f85mc.setUseCompression(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseConfigs(String str) {
        this.f85mc.setUseConfigs(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseCursorFetch(boolean z) {
        this.f85mc.setUseCursorFetch(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseDirectRowUnpack(boolean z) {
        this.f85mc.setUseDirectRowUnpack(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseDynamicCharsetInfo(boolean z) {
        this.f85mc.setUseDynamicCharsetInfo(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseFastDateParsing(boolean z) {
        this.f85mc.setUseFastDateParsing(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseFastIntParsing(boolean z) {
        this.f85mc.setUseFastIntParsing(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseGmtMillisForDatetimes(boolean z) {
        this.f85mc.setUseGmtMillisForDatetimes(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseHostsInPrivileges(boolean z) {
        this.f85mc.setUseHostsInPrivileges(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseInformationSchema(boolean z) {
        this.f85mc.setUseInformationSchema(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseJDBCCompliantTimezoneShift(boolean z) {
        this.f85mc.setUseJDBCCompliantTimezoneShift(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseJvmCharsetConverters(boolean z) {
        this.f85mc.setUseJvmCharsetConverters(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseLegacyDatetimeCode(boolean z) {
        this.f85mc.setUseLegacyDatetimeCode(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseLocalSessionState(boolean z) {
        this.f85mc.setUseLocalSessionState(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseLocalTransactionState(boolean z) {
        this.f85mc.setUseLocalTransactionState(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseNanosForElapsedTime(boolean z) {
        this.f85mc.setUseNanosForElapsedTime(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseOldAliasMetadataBehavior(boolean z) {
        this.f85mc.setUseOldAliasMetadataBehavior(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseOldUTF8Behavior(boolean z) {
        this.f85mc.setUseOldUTF8Behavior(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseOnlyServerErrorMessages(boolean z) {
        this.f85mc.setUseOnlyServerErrorMessages(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseReadAheadInput(boolean z) {
        this.f85mc.setUseReadAheadInput(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseSSL(boolean z) {
        this.f85mc.setUseSSL(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseSSPSCompatibleTimezoneShift(boolean z) {
        this.f85mc.setUseSSPSCompatibleTimezoneShift(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseServerPrepStmts(boolean z) {
        this.f85mc.setUseServerPrepStmts(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseServerPreparedStmts(boolean z) {
        this.f85mc.setUseServerPreparedStmts(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseSqlStateCodes(boolean z) {
        this.f85mc.setUseSqlStateCodes(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseStreamLengthsInPrepStmts(boolean z) {
        this.f85mc.setUseStreamLengthsInPrepStmts(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseTimezone(boolean z) {
        this.f85mc.setUseTimezone(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseUltraDevWorkAround(boolean z) {
        this.f85mc.setUseUltraDevWorkAround(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseUnbufferedInput(boolean z) {
        this.f85mc.setUseUnbufferedInput(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseUnicode(boolean z) {
        this.f85mc.setUseUnicode(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUseUsageAdvisor(boolean z) {
        this.f85mc.setUseUsageAdvisor(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUtf8OutsideBmpExcludedColumnNamePattern(String str) {
        this.f85mc.setUtf8OutsideBmpExcludedColumnNamePattern(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setUtf8OutsideBmpIncludedColumnNamePattern(String str) {
        this.f85mc.setUtf8OutsideBmpIncludedColumnNamePattern(str);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setVerifyServerCertificate(boolean z) {
        this.f85mc.setVerifyServerCertificate(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setYearIsDateType(boolean z) {
        this.f85mc.setYearIsDateType(z);
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public void setZeroDateTimeBehavior(String str) {
        this.f85mc.setZeroDateTimeBehavior(str);
    }

    @Override // com.mysql.jdbc.Connection
    public void shutdownServer() throws SQLException {
        checkClosed();
        try {
            this.f85mc.shutdownServer();
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
        }
    }

    @Override // com.mysql.jdbc.Connection
    public boolean supportsIsolationLevel() {
        return this.f85mc.supportsIsolationLevel();
    }

    @Override // com.mysql.jdbc.Connection
    public boolean supportsQuotedIdentifiers() {
        return this.f85mc.supportsQuotedIdentifiers();
    }

    @Override // com.mysql.jdbc.Connection
    public boolean supportsTransactions() {
        return this.f85mc.supportsTransactions();
    }

    @Override // com.mysql.jdbc.ConnectionProperties
    public boolean useUnbufferedInput() {
        return this.f85mc.useUnbufferedInput();
    }

    @Override // com.mysql.jdbc.Connection
    public boolean versionMeetsMinimum(int i, int i2, int i3) throws SQLException {
        checkClosed();
        try {
            return this.f85mc.versionMeetsMinimum(i, i2, i3);
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return false;
        }
    }

    public void close(boolean z) throws SQLException {
        synchronized (this.pooledConnection) {
            if (this.closed) {
                return;
            }
            if (!isInGlobalTx() && this.f85mc.getRollbackOnPooledClose() && !getAutoCommit()) {
                rollback();
            }
            if (z) {
                this.pooledConnection.callConnectionEventListeners(2, null);
            }
            this.closed = true;
        }
    }

    public PreparedStatement clientPrepare(String str, int i, int i2) throws SQLException {
        checkClosed();
        try {
            return new PreparedStatementWrapper(this, this.pooledConnection, this.f85mc.clientPrepareStatement(str, i, i2));
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // com.mysql.jdbc.Connection
    public PreparedStatement clientPrepareStatement(String str, int i) throws SQLException {
        try {
            return PreparedStatementWrapper.getInstance(this, this.pooledConnection, this.f85mc.clientPrepareStatement(str, i));
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // java.sql.Connection
    public Statement createStatement(int i, int i2) throws SQLException {
        checkClosed();
        try {
            return StatementWrapper.getInstance(this, this.pooledConnection, this.f85mc.createStatement(i, i2));
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // java.sql.Connection
    public CallableStatement prepareCall(String str, int i, int i2) throws SQLException {
        checkClosed();
        try {
            return CallableStatementWrapper.getInstance(this, this.pooledConnection, this.f85mc.prepareCall(str, i, i2));
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // java.sql.Connection
    public PreparedStatement prepareStatement(String str, int i, int i2) throws SQLException {
        checkClosed();
        try {
            return PreparedStatementWrapper.getInstance(this, this.pooledConnection, this.f85mc.prepareStatement(str, i, i2));
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // com.mysql.jdbc.Connection
    public PreparedStatement serverPrepareStatement(String str, int i) throws SQLException {
        try {
            return PreparedStatementWrapper.getInstance(this, this.pooledConnection, this.f85mc.serverPrepareStatement(str, i));
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // com.mysql.jdbc.Connection
    public PreparedStatement clientPrepareStatement(String str, int i, int i2) throws SQLException {
        try {
            return PreparedStatementWrapper.getInstance(this, this.pooledConnection, this.f85mc.clientPrepareStatement(str, i, i2));
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // java.sql.Connection
    public void rollback(Savepoint savepoint) throws SQLException {
        checkClosed();
        if (!isInGlobalTx()) {
            try {
                this.f85mc.rollback(savepoint);
                return;
            } catch (SQLException e) {
                checkAndFireConnectionError(e);
                return;
            }
        }
        throw SQLError.createSQLException("Can't call rollback() on an XAConnection associated with a global transaction", SQLError.SQL_STATE_INVALID_TRANSACTION_TERMINATION, MysqlErrorNumbers.ER_XA_RMERR, this.exceptionInterceptor);
    }

    @Override // com.mysql.jdbc.Connection
    public PreparedStatement serverPrepareStatement(String str, int i, int i2) throws SQLException {
        try {
            return PreparedStatementWrapper.getInstance(this, this.pooledConnection, this.f85mc.serverPrepareStatement(str, i, i2));
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // java.sql.Connection
    public Savepoint setSavepoint(String str) throws SQLException {
        checkClosed();
        if (!isInGlobalTx()) {
            try {
                return this.f85mc.setSavepoint(str);
            } catch (SQLException e) {
                checkAndFireConnectionError(e);
                return null;
            }
        }
        throw SQLError.createSQLException("Can't set autocommit to 'true' on an XAConnection", SQLError.SQL_STATE_INVALID_TRANSACTION_TERMINATION, MysqlErrorNumbers.ER_XA_RMERR, this.exceptionInterceptor);
    }

    @Override // java.sql.Connection
    public Statement createStatement(int i, int i2, int i3) throws SQLException {
        checkClosed();
        try {
            return StatementWrapper.getInstance(this, this.pooledConnection, this.f85mc.createStatement(i, i2, i3));
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // java.sql.Connection
    public CallableStatement prepareCall(String str, int i, int i2, int i3) throws SQLException {
        checkClosed();
        try {
            return CallableStatementWrapper.getInstance(this, this.pooledConnection, this.f85mc.prepareCall(str, i, i2, i3));
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // java.sql.Connection
    public PreparedStatement prepareStatement(String str, int i, int i2, int i3) throws SQLException {
        checkClosed();
        try {
            return PreparedStatementWrapper.getInstance(this, this.pooledConnection, this.f85mc.prepareStatement(str, i, i2, i3));
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // com.mysql.jdbc.Connection
    public PreparedStatement clientPrepareStatement(String str, int i, int i2, int i3) throws SQLException {
        try {
            return PreparedStatementWrapper.getInstance(this, this.pooledConnection, this.f85mc.clientPrepareStatement(str, i, i2, i3));
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // com.mysql.jdbc.Connection
    public PreparedStatement serverPrepareStatement(String str, int i, int i2, int i3) throws SQLException {
        try {
            return PreparedStatementWrapper.getInstance(this, this.pooledConnection, this.f85mc.serverPrepareStatement(str, i, i2, i3));
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // com.mysql.jdbc.Connection
    public PreparedStatement clientPrepareStatement(String str, int[] iArr) throws SQLException {
        try {
            return PreparedStatementWrapper.getInstance(this, this.pooledConnection, this.f85mc.clientPrepareStatement(str, iArr));
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // java.sql.Connection
    public PreparedStatement prepareStatement(String str, int i) throws SQLException {
        checkClosed();
        try {
            return PreparedStatementWrapper.getInstance(this, this.pooledConnection, this.f85mc.prepareStatement(str, i));
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // com.mysql.jdbc.Connection
    public PreparedStatement serverPrepareStatement(String str, int[] iArr) throws SQLException {
        try {
            return PreparedStatementWrapper.getInstance(this, this.pooledConnection, this.f85mc.serverPrepareStatement(str, iArr));
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // com.mysql.jdbc.Connection
    public PreparedStatement clientPrepareStatement(String str, String[] strArr) throws SQLException {
        try {
            return PreparedStatementWrapper.getInstance(this, this.pooledConnection, this.f85mc.clientPrepareStatement(str, strArr));
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // com.mysql.jdbc.Connection
    public PreparedStatement serverPrepareStatement(String str, String[] strArr) throws SQLException {
        try {
            return PreparedStatementWrapper.getInstance(this, this.pooledConnection, this.f85mc.serverPrepareStatement(str, strArr));
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // java.sql.Connection
    public PreparedStatement prepareStatement(String str, int[] iArr) throws SQLException {
        checkClosed();
        try {
            return PreparedStatementWrapper.getInstance(this, this.pooledConnection, this.f85mc.prepareStatement(str, iArr));
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }

    @Override // java.sql.Connection
    public PreparedStatement prepareStatement(String str, String[] strArr) throws SQLException {
        checkClosed();
        try {
            return PreparedStatementWrapper.getInstance(this, this.pooledConnection, this.f85mc.prepareStatement(str, strArr));
        } catch (SQLException e) {
            checkAndFireConnectionError(e);
            return null;
        }
    }
}
