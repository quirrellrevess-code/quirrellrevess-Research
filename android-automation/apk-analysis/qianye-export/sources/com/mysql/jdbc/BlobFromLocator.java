package com.mysql.jdbc;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BlobFromLocator implements java.sql.Blob {
    private String blobColumnName;
    private ResultSetImpl creatorResultSet;
    private ExceptionInterceptor exceptionInterceptor;
    private int numColsInResultSet;
    private int numPrimaryKeys;
    private List<String> primaryKeyColumns;
    private List<String> primaryKeyValues;
    private String quotedId;
    private String tableName;

    public BlobFromLocator(ResultSetImpl resultSetImpl, int i, ExceptionInterceptor exceptionInterceptor) throws SQLException {
        this.primaryKeyColumns = null;
        this.primaryKeyValues = null;
        this.blobColumnName = null;
        this.tableName = null;
        this.numColsInResultSet = 0;
        this.numPrimaryKeys = 0;
        this.exceptionInterceptor = exceptionInterceptor;
        this.creatorResultSet = resultSetImpl;
        this.numColsInResultSet = resultSetImpl.fields.length;
        this.quotedId = resultSetImpl.connection.getMetaData().getIdentifierQuoteString();
        if (this.numColsInResultSet > 1) {
            this.primaryKeyColumns = new ArrayList();
            this.primaryKeyValues = new ArrayList();
            for (int i2 = 0; i2 < this.numColsInResultSet; i2++) {
                if (this.creatorResultSet.fields[i2].isPrimaryKey()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.quotedId);
                    String originalName = this.creatorResultSet.fields[i2].getOriginalName();
                    if (originalName == null || originalName.length() <= 0) {
                        sb.append(this.creatorResultSet.fields[i2].getName());
                    } else {
                        sb.append(originalName);
                    }
                    sb.append(this.quotedId);
                    this.primaryKeyColumns.add(sb.toString());
                    this.primaryKeyValues.add(this.creatorResultSet.getString(i2 + 1));
                }
            }
        } else {
            notEnoughInformationInQuery();
        }
        int size = this.primaryKeyColumns.size();
        this.numPrimaryKeys = size;
        if (size == 0) {
            notEnoughInformationInQuery();
        }
        if (this.creatorResultSet.fields[0].getOriginalTableName() != null) {
            StringBuilder sb2 = new StringBuilder();
            String databaseName = this.creatorResultSet.fields[0].getDatabaseName();
            if (databaseName != null && databaseName.length() > 0) {
                sb2.append(this.quotedId);
                sb2.append(databaseName);
                sb2.append(this.quotedId);
                sb2.append('.');
            }
            sb2.append(this.quotedId);
            sb2.append(this.creatorResultSet.fields[0].getOriginalTableName());
            sb2.append(this.quotedId);
            this.tableName = sb2.toString();
        } else {
            this.tableName = this.quotedId + this.creatorResultSet.fields[0].getTableName() + this.quotedId;
        }
        this.blobColumnName = this.quotedId + this.creatorResultSet.getString(i) + this.quotedId;
    }

    private void notEnoughInformationInQuery() throws SQLException {
        throw SQLError.createSQLException("Emulated BLOB locators must come from a ResultSet with only one table selected, and all primary keys selected", SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
    }

    public java.sql.PreparedStatement createGetBytesStatement() throws SQLException {
        StringBuilder sb = new StringBuilder("SELECT SUBSTRING(");
        sb.append(this.blobColumnName);
        sb.append(", ");
        sb.append("?");
        sb.append(", ");
        sb.append("?");
        sb.append(") FROM ");
        sb.append(this.tableName);
        sb.append(" WHERE ");
        sb.append(this.primaryKeyColumns.get(0));
        sb.append(" = ?");
        for (int i = 1; i < this.numPrimaryKeys; i++) {
            sb.append(" AND ");
            sb.append(this.primaryKeyColumns.get(i));
            sb.append(" = ?");
        }
        return this.creatorResultSet.connection.prepareStatement(sb.toString());
    }

    @Override // java.sql.Blob
    public void free() throws SQLException {
        this.creatorResultSet = null;
        this.primaryKeyColumns = null;
        this.primaryKeyValues = null;
    }

    @Override // java.sql.Blob
    public InputStream getBinaryStream() throws SQLException {
        return new BufferedInputStream(new LocatorInputStream(), this.creatorResultSet.connection.getLocatorFetchBufferSize());
    }

    @Override // java.sql.Blob
    public byte[] getBytes(long j, int i) throws Throwable {
        java.sql.PreparedStatement preparedStatementCreateGetBytesStatement;
        try {
            preparedStatementCreateGetBytesStatement = createGetBytesStatement();
            try {
                byte[] bytesInternal = getBytesInternal(preparedStatementCreateGetBytesStatement, j, i);
                if (preparedStatementCreateGetBytesStatement != null) {
                    try {
                        preparedStatementCreateGetBytesStatement.close();
                    } catch (SQLException unused) {
                    }
                }
                return bytesInternal;
            } catch (Throwable th) {
                th = th;
                if (preparedStatementCreateGetBytesStatement != null) {
                    try {
                        preparedStatementCreateGetBytesStatement.close();
                    } catch (SQLException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            preparedStatementCreateGetBytesStatement = null;
        }
    }

    public byte[] getBytesInternal(java.sql.PreparedStatement preparedStatement, long j, int i) throws SQLException {
        ResultSet resultSet = null;
        try {
            preparedStatement.setLong(1, j);
            preparedStatement.setInt(2, i);
            for (int i2 = 0; i2 < this.numPrimaryKeys; i2++) {
                preparedStatement.setString(i2 + 3, this.primaryKeyValues.get(i2));
            }
            ResultSet resultSetExecuteQuery = preparedStatement.executeQuery();
            if (!resultSetExecuteQuery.next()) {
                throw SQLError.createSQLException("BLOB data not found! Did primary keys change?", SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
            }
            byte[] bytes = ((ResultSetImpl) resultSetExecuteQuery).getBytes(1, true);
            if (resultSetExecuteQuery != null) {
                try {
                    resultSetExecuteQuery.close();
                } catch (SQLException unused) {
                }
            }
            return bytes;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    resultSet.close();
                } catch (SQLException unused2) {
                }
            }
            throw th;
        }
    }

    @Override // java.sql.Blob
    public long length() throws Throwable {
        java.sql.PreparedStatement preparedStatementPrepareStatement;
        StringBuilder sb = new StringBuilder("SELECT LENGTH(");
        sb.append(this.blobColumnName);
        sb.append(") FROM ");
        sb.append(this.tableName);
        sb.append(" WHERE ");
        int i = 0;
        sb.append(this.primaryKeyColumns.get(0));
        sb.append(" = ?");
        for (int i2 = 1; i2 < this.numPrimaryKeys; i2++) {
            sb.append(" AND ");
            sb.append(this.primaryKeyColumns.get(i2));
            sb.append(" = ?");
        }
        ResultSet resultSet = null;
        try {
            preparedStatementPrepareStatement = this.creatorResultSet.connection.prepareStatement(sb.toString());
            while (i < this.numPrimaryKeys) {
                try {
                    int i3 = i + 1;
                    preparedStatementPrepareStatement.setString(i3, this.primaryKeyValues.get(i));
                    i = i3;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            resultSet.close();
                        } catch (SQLException unused) {
                        }
                    }
                    if (preparedStatementPrepareStatement == null) {
                        throw th;
                    }
                    try {
                        preparedStatementPrepareStatement.close();
                        throw th;
                    } catch (SQLException unused2) {
                        throw th;
                    }
                }
            }
            ResultSet resultSetExecuteQuery = preparedStatementPrepareStatement.executeQuery();
            if (!resultSetExecuteQuery.next()) {
                throw SQLError.createSQLException("BLOB data not found! Did primary keys change?", SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
            }
            long j = resultSetExecuteQuery.getLong(1);
            if (resultSetExecuteQuery != null) {
                try {
                    resultSetExecuteQuery.close();
                } catch (SQLException unused3) {
                }
            }
            if (preparedStatementPrepareStatement != null) {
                try {
                    preparedStatementPrepareStatement.close();
                } catch (SQLException unused4) {
                }
            }
            return j;
        } catch (Throwable th2) {
            th = th2;
            preparedStatementPrepareStatement = null;
        }
    }

    @Override // java.sql.Blob
    public long position(java.sql.Blob blob, long j) throws SQLException {
        return position(blob.getBytes(0L, (int) blob.length()), j);
    }

    @Override // java.sql.Blob
    public OutputStream setBinaryStream(long j) throws SQLException {
        throw SQLError.createSQLFeatureNotSupportedException();
    }

    @Override // java.sql.Blob
    public int setBytes(long j, byte[] bArr, int i, int i2) throws SQLException {
        if (i + i2 > bArr.length) {
            i2 = bArr.length - i;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(this.tableName);
        sb.append(" SET ");
        sb.append(this.blobColumnName);
        sb.append(" = INSERT(");
        sb.append(this.blobColumnName);
        sb.append(", ");
        sb.append(j);
        sb.append(", ");
        sb.append(i2);
        sb.append(", ?) WHERE ");
        sb.append(this.primaryKeyColumns.get(0));
        sb.append(" = ?");
        for (int i3 = 1; i3 < this.numPrimaryKeys; i3++) {
            sb.append(" AND ");
            sb.append(this.primaryKeyColumns.get(i3));
            sb.append(" = ?");
        }
        java.sql.PreparedStatement preparedStatementPrepareStatement = null;
        try {
            preparedStatementPrepareStatement = this.creatorResultSet.connection.prepareStatement(sb.toString());
            preparedStatementPrepareStatement.setBytes(1, bArr2);
            for (int i4 = 0; i4 < this.numPrimaryKeys; i4++) {
                preparedStatementPrepareStatement.setString(i4 + 2, this.primaryKeyValues.get(i4));
            }
            if (preparedStatementPrepareStatement.executeUpdate() != 1) {
                throw SQLError.createSQLException("BLOB data not found! Did primary keys change?", SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
            }
            if (preparedStatementPrepareStatement != null) {
                try {
                    preparedStatementPrepareStatement.close();
                } catch (SQLException unused) {
                }
            }
            return (int) length();
        } catch (Throwable th) {
            if (preparedStatementPrepareStatement != null) {
                try {
                    preparedStatementPrepareStatement.close();
                } catch (SQLException unused2) {
                }
            }
            throw th;
        }
    }

    @Override // java.sql.Blob
    public void truncate(long j) throws SQLException {
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(this.tableName);
        sb.append(" SET ");
        sb.append(this.blobColumnName);
        sb.append(" = LEFT(");
        sb.append(this.blobColumnName);
        sb.append(", ");
        sb.append(j);
        sb.append(") WHERE ");
        int i = 0;
        sb.append(this.primaryKeyColumns.get(0));
        sb.append(" = ?");
        for (int i2 = 1; i2 < this.numPrimaryKeys; i2++) {
            sb.append(" AND ");
            sb.append(this.primaryKeyColumns.get(i2));
            sb.append(" = ?");
        }
        java.sql.PreparedStatement preparedStatementPrepareStatement = null;
        try {
            preparedStatementPrepareStatement = this.creatorResultSet.connection.prepareStatement(sb.toString());
            while (i < this.numPrimaryKeys) {
                int i3 = i + 1;
                preparedStatementPrepareStatement.setString(i3, this.primaryKeyValues.get(i));
                i = i3;
            }
            if (preparedStatementPrepareStatement.executeUpdate() != 1) {
                throw SQLError.createSQLException("BLOB data not found! Did primary keys change?", SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
            }
        } finally {
            if (preparedStatementPrepareStatement != null) {
                try {
                    preparedStatementPrepareStatement.close();
                } catch (SQLException unused) {
                }
            }
        }
    }

    @Override // java.sql.Blob
    public InputStream getBinaryStream(long j, long j2) throws SQLException {
        return new LocatorInputStream(j, j2);
    }

    @Override // java.sql.Blob
    public long position(byte[] bArr, long j) throws Throwable {
        java.sql.PreparedStatement preparedStatementPrepareStatement;
        StringBuilder sb = new StringBuilder("SELECT LOCATE(");
        sb.append("?, ");
        sb.append(this.blobColumnName);
        sb.append(", ");
        sb.append(j);
        sb.append(") FROM ");
        sb.append(this.tableName);
        sb.append(" WHERE ");
        sb.append(this.primaryKeyColumns.get(0));
        sb.append(" = ?");
        for (int i = 1; i < this.numPrimaryKeys; i++) {
            sb.append(" AND ");
            sb.append(this.primaryKeyColumns.get(i));
            sb.append(" = ?");
        }
        ResultSet resultSet = null;
        try {
            preparedStatementPrepareStatement = this.creatorResultSet.connection.prepareStatement(sb.toString());
            try {
                preparedStatementPrepareStatement.setBytes(1, bArr);
                for (int i2 = 0; i2 < this.numPrimaryKeys; i2++) {
                    preparedStatementPrepareStatement.setString(i2 + 2, this.primaryKeyValues.get(i2));
                }
                ResultSet resultSetExecuteQuery = preparedStatementPrepareStatement.executeQuery();
                if (!resultSetExecuteQuery.next()) {
                    throw SQLError.createSQLException("BLOB data not found! Did primary keys change?", SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
                }
                long j2 = resultSetExecuteQuery.getLong(1);
                if (resultSetExecuteQuery != null) {
                    try {
                        resultSetExecuteQuery.close();
                    } catch (SQLException unused) {
                    }
                }
                if (preparedStatementPrepareStatement != null) {
                    try {
                        preparedStatementPrepareStatement.close();
                    } catch (SQLException unused2) {
                    }
                }
                return j2;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        resultSet.close();
                    } catch (SQLException unused3) {
                    }
                }
                if (preparedStatementPrepareStatement == null) {
                    throw th;
                }
                try {
                    preparedStatementPrepareStatement.close();
                    throw th;
                } catch (SQLException unused4) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            preparedStatementPrepareStatement = null;
        }
    }

    public class LocatorInputStream extends InputStream {
        public long currentPositionInBlob;
        public long length;
        public java.sql.PreparedStatement pStmt;

        public LocatorInputStream() throws SQLException {
            this.currentPositionInBlob = 0L;
            this.length = 0L;
            this.pStmt = null;
            this.length = BlobFromLocator.this.length();
            this.pStmt = BlobFromLocator.this.createGetBytesStatement();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            java.sql.PreparedStatement preparedStatement = this.pStmt;
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new IOException(e.toString());
                }
            }
            super.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            long j = this.currentPositionInBlob;
            if (j + 1 > this.length) {
                return -1;
            }
            try {
                BlobFromLocator blobFromLocator = BlobFromLocator.this;
                java.sql.PreparedStatement preparedStatement = this.pStmt;
                long j2 = j + 1;
                this.currentPositionInBlob = j2;
                byte[] bytesInternal = blobFromLocator.getBytesInternal(preparedStatement, j2, 1);
                if (bytesInternal == null) {
                    return -1;
                }
                return bytesInternal[0];
            } catch (SQLException e) {
                throw new IOException(e.toString());
            }
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            long j = this.currentPositionInBlob;
            if (j + 1 > this.length) {
                return -1;
            }
            try {
                byte[] bytesInternal = BlobFromLocator.this.getBytesInternal(this.pStmt, j + 1, i2);
                if (bytesInternal == null) {
                    return -1;
                }
                System.arraycopy(bytesInternal, 0, bArr, i, bytesInternal.length);
                this.currentPositionInBlob += (long) bytesInternal.length;
                return bytesInternal.length;
            } catch (SQLException e) {
                throw new IOException(e.toString());
            }
        }

        public LocatorInputStream(long j, long j2) throws Throwable {
            this.currentPositionInBlob = 0L;
            this.length = 0L;
            this.pStmt = null;
            long j3 = j + j2;
            this.length = j3;
            this.currentPositionInBlob = j;
            long length = BlobFromLocator.this.length();
            if (j3 > length) {
                throw SQLError.createSQLException(Messages.getString("Blob.invalidStreamLength", new Object[]{Long.valueOf(length), Long.valueOf(j), Long.valueOf(j2)}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, BlobFromLocator.this.exceptionInterceptor);
            }
            if (j < 1) {
                throw SQLError.createSQLException(Messages.getString("Blob.invalidStreamPos"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, BlobFromLocator.this.exceptionInterceptor);
            }
            if (j > length) {
                throw SQLError.createSQLException(Messages.getString("Blob.invalidStreamPos"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, BlobFromLocator.this.exceptionInterceptor);
            }
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            long j = this.currentPositionInBlob;
            if (j + 1 > this.length) {
                return -1;
            }
            try {
                byte[] bytesInternal = BlobFromLocator.this.getBytesInternal(this.pStmt, j + 1, bArr.length);
                if (bytesInternal == null) {
                    return -1;
                }
                System.arraycopy(bytesInternal, 0, bArr, 0, bytesInternal.length);
                this.currentPositionInBlob += (long) bytesInternal.length;
                return bytesInternal.length;
            } catch (SQLException e) {
                throw new IOException(e.toString());
            }
        }
    }

    @Override // java.sql.Blob
    public int setBytes(long j, byte[] bArr) throws SQLException {
        return setBytes(j, bArr, 0, bArr.length);
    }
}
