package com.mysql.jdbc;

import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.profiler.ProfilerEvent;
import com.mysql.jdbc.profiler.ProfilerEventHandler;
import java.sql.SQLException;

/* JADX INFO: loaded from: classes.dex */
public class RowDataDynamic implements RowData {
    private int columnCount;
    private ExceptionInterceptor exceptionInterceptor;

    /* JADX INFO: renamed from: io */
    private MysqlIO f84io;
    private boolean isBinaryEncoded;
    private Field[] metadata;
    private boolean moreResultsExisted;
    private ResultSetRow nextRow;
    private ResultSetImpl owner;
    private boolean useBufferRowExplicit;
    private int index = -1;
    private boolean isAfterEnd = false;
    private boolean noMoreRows = false;
    private boolean streamerClosed = false;
    private boolean wasEmpty = false;

    public RowDataDynamic(MysqlIO mysqlIO, int i, Field[] fieldArr, boolean z) throws SQLException {
        this.isBinaryEncoded = false;
        this.f84io = mysqlIO;
        this.columnCount = i;
        this.isBinaryEncoded = z;
        this.metadata = fieldArr;
        this.exceptionInterceptor = mysqlIO.getExceptionInterceptor();
        this.useBufferRowExplicit = MysqlIO.useBufferRowExplicit(this.metadata);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void nextRecord() throws SQLException {
        try {
            if (this.noMoreRows) {
                this.nextRow = null;
                this.isAfterEnd = true;
                return;
            }
            ResultSetRow resultSetRowNextRow = this.f84io.nextRow(this.metadata, this.columnCount, this.isBinaryEncoded, MysqlErrorNumbers.ER_DB_CREATE_EXISTS, true, this.useBufferRowExplicit, true, null);
            this.nextRow = resultSetRowNextRow;
            if (resultSetRowNextRow == null) {
                this.noMoreRows = true;
                this.isAfterEnd = true;
                this.moreResultsExisted = this.f84io.tackOnMoreStreamingResults(this.owner);
                if (this.index == -1) {
                    this.wasEmpty = true;
                }
            }
        } catch (SQLException e) {
            if (e instanceof StreamingNotifiable) {
                ((StreamingNotifiable) e).setWasStreamingResults();
            }
            this.noMoreRows = true;
            throw e;
        } catch (Exception e2) {
            SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(Messages.getString("RowDataDynamic.8") + e2.getClass().getName() + Messages.getString("RowDataDynamic.9") + ((e2.getMessage() + Messages.getString("RowDataDynamic.7")) + Util.stackTraceToString(e2)), SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
            sQLExceptionCreateSQLException.initCause(e2);
            throw sQLExceptionCreateSQLException;
        }
    }

    private void notSupported() throws SQLException {
        throw new OperationNotSupportedException();
    }

    @Override // com.mysql.jdbc.RowData
    public void addRow(ResultSetRow resultSetRow) throws SQLException {
        notSupported();
    }

    @Override // com.mysql.jdbc.RowData
    public void afterLast() throws SQLException {
        notSupported();
    }

    @Override // com.mysql.jdbc.RowData
    public void beforeFirst() throws SQLException {
        notSupported();
    }

    @Override // com.mysql.jdbc.RowData
    public void beforeLast() throws SQLException {
        notSupported();
    }

    @Override // com.mysql.jdbc.RowData
    public void close() throws SQLException {
        Object connectionMutex;
        MySQLConnection mySQLConnection;
        java.sql.Statement statement;
        ResultSetImpl resultSetImpl = this.owner;
        if (resultSetImpl != null) {
            mySQLConnection = resultSetImpl.connection;
            connectionMutex = mySQLConnection != null ? mySQLConnection.getConnectionMutex() : this;
        } else {
            connectionMutex = this;
            mySQLConnection = null;
        }
        synchronized (connectionMutex) {
            int i = 0;
            boolean z = false;
            while (next() != null) {
                i++;
                if (i % 100 == 0) {
                    Thread.yield();
                }
                z = true;
            }
            if (mySQLConnection != null) {
                if (!mySQLConnection.getClobberStreamingResults() && mySQLConnection.getNetTimeoutForStreamingResults() > 0) {
                    String serverVariable = mySQLConnection.getServerVariable("net_write_timeout");
                    if (serverVariable == null || serverVariable.length() == 0) {
                        serverVariable = "60";
                    }
                    this.f84io.clearInputStream();
                    try {
                        java.sql.Statement statementCreateStatement = mySQLConnection.createStatement();
                        try {
                            ((StatementImpl) statementCreateStatement).executeSimpleNonQuery(mySQLConnection, "SET net_write_timeout=" + serverVariable);
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
                        statement = null;
                    }
                }
                if (mySQLConnection.getUseUsageAdvisor() && z) {
                    ProfilerEventHandler profilerEventHandlerFactory = ProfilerEventHandlerFactory.getInstance(mySQLConnection);
                    ResultSetImpl resultSetImpl2 = this.owner;
                    StatementImpl statementImpl = resultSetImpl2.owningStatement;
                    String str = statementImpl == null ? "N/A" : statementImpl.currentCatalog;
                    long j = resultSetImpl2.connectionId;
                    int id = statementImpl == null ? -1 : statementImpl.getId();
                    profilerEventHandlerFactory.consumeEvent(new ProfilerEvent((byte) 0, BuildConfig.FLAVOR, str, j, id, -1, System.currentTimeMillis(), 0L, Constants.MILLIS_I18N, null, null, Messages.getString("RowDataDynamic.2") + i + Messages.getString("RowDataDynamic.3") + Messages.getString("RowDataDynamic.4") + Messages.getString("RowDataDynamic.5") + Messages.getString("RowDataDynamic.6") + this.owner.pointOfOrigin));
                }
            }
        }
        this.metadata = null;
        this.owner = null;
    }

    @Override // com.mysql.jdbc.RowData
    public ResultSetRow getAt(int i) throws SQLException {
        notSupported();
        return null;
    }

    @Override // com.mysql.jdbc.RowData
    public int getCurrentRowNumber() throws SQLException {
        notSupported();
        return -1;
    }

    @Override // com.mysql.jdbc.RowData
    public ResultSetInternalMethods getOwner() {
        return this.owner;
    }

    @Override // com.mysql.jdbc.RowData
    public boolean hasNext() throws SQLException {
        boolean z = this.nextRow != null;
        if (!z && !this.streamerClosed) {
            this.f84io.closeStreamer(this);
            this.streamerClosed = true;
        }
        return z;
    }

    @Override // com.mysql.jdbc.RowData
    public boolean isAfterLast() throws SQLException {
        return this.isAfterEnd;
    }

    @Override // com.mysql.jdbc.RowData
    public boolean isBeforeFirst() throws SQLException {
        return this.index < 0;
    }

    @Override // com.mysql.jdbc.RowData
    public boolean isDynamic() {
        return true;
    }

    @Override // com.mysql.jdbc.RowData
    public boolean isEmpty() throws SQLException {
        notSupported();
        return false;
    }

    @Override // com.mysql.jdbc.RowData
    public boolean isFirst() throws SQLException {
        notSupported();
        return false;
    }

    @Override // com.mysql.jdbc.RowData
    public boolean isLast() throws SQLException {
        notSupported();
        return false;
    }

    @Override // com.mysql.jdbc.RowData
    public void moveRowRelative(int i) throws SQLException {
        notSupported();
    }

    @Override // com.mysql.jdbc.RowData
    public ResultSetRow next() throws SQLException {
        int i;
        nextRecord();
        if (this.nextRow == null && !this.streamerClosed && !this.moreResultsExisted) {
            this.f84io.closeStreamer(this);
            this.streamerClosed = true;
        }
        ResultSetRow resultSetRow = this.nextRow;
        if (resultSetRow != null && (i = this.index) != Integer.MAX_VALUE) {
            this.index = i + 1;
        }
        return resultSetRow;
    }

    @Override // com.mysql.jdbc.RowData
    public void removeRow(int i) throws SQLException {
        notSupported();
    }

    @Override // com.mysql.jdbc.RowData
    public void setCurrentRow(int i) throws SQLException {
        notSupported();
    }

    @Override // com.mysql.jdbc.RowData
    public void setMetadata(Field[] fieldArr) {
        this.metadata = fieldArr;
    }

    @Override // com.mysql.jdbc.RowData
    public void setOwner(ResultSetImpl resultSetImpl) {
        this.owner = resultSetImpl;
    }

    @Override // com.mysql.jdbc.RowData
    public int size() {
        return -1;
    }

    @Override // com.mysql.jdbc.RowData
    public boolean wasEmpty() {
        return this.wasEmpty;
    }
}
