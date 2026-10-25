package com.mysql.jdbc;

import java.io.Reader;
import java.sql.NClob;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;

/* JADX INFO: loaded from: classes.dex */
public class JDBC4ServerPreparedStatement extends ServerPreparedStatement {
    public JDBC4ServerPreparedStatement(MySQLConnection mySQLConnection, String str, String str2, int i, int i2) throws SQLException {
        super(mySQLConnection, str, str2, i, i2);
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setNCharacterStream(int i, Reader reader, long j) throws SQLException {
        if (!this.charEncoding.equalsIgnoreCase("UTF-8") && !this.charEncoding.equalsIgnoreCase("utf8")) {
            throw SQLError.createSQLException("Can not call setNCharacterStream() when connection character set isn't UTF-8", getExceptionInterceptor());
        }
        checkClosed();
        if (reader == null) {
            setNull(i, -2);
            return;
        }
        ServerPreparedStatement.BindValue binding = getBinding(i, true);
        resetToType(binding, MysqlDefs.FIELD_TYPE_BLOB);
        binding.value = reader;
        binding.isLongData = true;
        if (this.connection.getUseStreamLengthsInPrepStmts()) {
            binding.bindLength = j;
        } else {
            binding.bindLength = -1L;
        }
    }

    @Override // java.sql.PreparedStatement
    public void setNClob(int i, NClob nClob) throws SQLException {
        setNClob(i, nClob.getCharacterStream(), this.connection.getUseStreamLengthsInPrepStmts() ? nClob.length() : -1L);
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setNString(int i, String str) throws SQLException {
        if (!this.charEncoding.equalsIgnoreCase("UTF-8") && !this.charEncoding.equalsIgnoreCase("utf8")) {
            throw SQLError.createSQLException("Can not call setNString() when connection character set isn't UTF-8", getExceptionInterceptor());
        }
        setString(i, str);
    }

    @Override // java.sql.PreparedStatement
    public void setRowId(int i, RowId rowId) throws SQLException {
        JDBC4PreparedStatementHelper.setRowId(this, i, rowId);
    }

    @Override // java.sql.PreparedStatement
    public void setSQLXML(int i, SQLXML sqlxml) throws SQLException {
        JDBC4PreparedStatementHelper.setSQLXML(this, i, sqlxml);
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setNClob(int i, Reader reader, long j) throws SQLException {
        if (!this.charEncoding.equalsIgnoreCase("UTF-8") && !this.charEncoding.equalsIgnoreCase("utf8")) {
            throw SQLError.createSQLException("Can not call setNClob() when connection character set isn't UTF-8", getExceptionInterceptor());
        }
        checkClosed();
        if (reader == null) {
            setNull(i, 2011);
            return;
        }
        ServerPreparedStatement.BindValue binding = getBinding(i, true);
        resetToType(binding, MysqlDefs.FIELD_TYPE_BLOB);
        binding.value = reader;
        binding.isLongData = true;
        if (this.connection.getUseStreamLengthsInPrepStmts()) {
            binding.bindLength = j;
        } else {
            binding.bindLength = -1L;
        }
    }
}
