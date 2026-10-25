package com.mysql.jdbc;

import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.sql.NClob;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.SQLXML;
import java.sql.Struct;

/* JADX INFO: loaded from: classes.dex */
public class JDBC4ResultSet extends ResultSetImpl {
    public JDBC4ResultSet(long j, long j2, MySQLConnection mySQLConnection, StatementImpl statementImpl) {
        super(j, j2, mySQLConnection, statementImpl);
    }

    private final NClob getNClobFromString(String str, int i) throws SQLException {
        return new JDBC4NClob(str, getExceptionInterceptor());
    }

    private String getStringForNClob(int i) throws SQLException {
        try {
            byte[] bytes = !this.isBinaryEncoded ? getBytes(i) : getNativeBytes(i, true);
            if (bytes != null) {
                return new String(bytes, "UTF-8");
            }
            return null;
        } catch (UnsupportedEncodingException unused) {
            throw SQLError.createSQLException("Unsupported character encoding UTF-8", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
    }

    @Override // java.sql.ResultSet
    public int getHoldability() throws SQLException {
        throw SQLError.createSQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public Reader getNCharacterStream(int i) throws SQLException {
        checkColumnBounds(i);
        String encoding = this.fields[i - 1].getEncoding();
        if (encoding == null || !encoding.equals("UTF-8")) {
            throw new SQLException("Can not call getNCharacterStream() when field's charset isn't UTF-8");
        }
        return getCharacterStream(i);
    }

    @Override // java.sql.ResultSet
    public NClob getNClob(int i) throws SQLException {
        checkColumnBounds(i);
        String encoding = this.fields[i - 1].getEncoding();
        if (encoding == null || !encoding.equals("UTF-8")) {
            throw new SQLException("Can not call getNClob() when field's charset isn't UTF-8");
        }
        if (this.isBinaryEncoded) {
            return getNativeNClob(i);
        }
        String stringForNClob = getStringForNClob(i);
        if (stringForNClob == null) {
            return null;
        }
        return new JDBC4NClob(stringForNClob, getExceptionInterceptor());
    }

    @Override // java.sql.ResultSet
    public String getNString(int i) throws SQLException {
        checkColumnBounds(i);
        String encoding = this.fields[i - 1].getEncoding();
        if (encoding == null || !encoding.equals("UTF-8")) {
            throw new SQLException("Can not call getNString() when field's charset isn't UTF-8");
        }
        return getString(i);
    }

    public NClob getNativeNClob(int i) throws SQLException {
        String stringForNClob = getStringForNClob(i);
        if (stringForNClob == null) {
            return null;
        }
        return getNClobFromString(stringForNClob, i);
    }

    @Override // com.mysql.jdbc.ResultSetImpl
    public <T> T getObject(int i, Class<T> cls) throws SQLException {
        if (cls == null) {
            throw SQLError.createSQLException("Type parameter can not be null", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
        if (cls.equals(Struct.class)) {
            throw new SQLFeatureNotSupportedException();
        }
        if (cls.equals(RowId.class)) {
            return (T) getRowId(i);
        }
        if (cls.equals(NClob.class)) {
            return (T) getNClob(i);
        }
        return cls.equals(SQLXML.class) ? (T) getSQLXML(i) : (T) super.getObject(i, cls);
    }

    @Override // java.sql.ResultSet
    public RowId getRowId(int i) throws SQLException {
        throw SQLError.createSQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public SQLXML getSQLXML(int i) throws SQLException {
        checkColumnBounds(i);
        return new JDBC4MysqlSQLXML(this, i, getExceptionInterceptor());
    }

    @Override // java.sql.Wrapper
    public boolean isWrapperFor(Class<?> cls) throws SQLException {
        checkClosed();
        return cls.isInstance(this);
    }

    @Override // java.sql.Wrapper
    public <T> T unwrap(Class<T> cls) throws SQLException {
        try {
            return cls.cast(this);
        } catch (ClassCastException unused) {
            throw SQLError.createSQLException("Unable to unwrap to " + cls.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
    }

    @Override // java.sql.ResultSet
    public void updateAsciiStream(int i, InputStream inputStream) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateBinaryStream(int i, InputStream inputStream) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateBlob(int i, InputStream inputStream) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateCharacterStream(int i, Reader reader) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateClob(int i, Reader reader) throws SQLException {
        throw new NotUpdatable();
    }

    public void updateNCharacterStream(int i, Reader reader, int i2) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateNClob(String str, NClob nClob) throws SQLException {
        updateNClob(findColumn(str), nClob);
    }

    @Override // java.sql.ResultSet
    public void updateNString(int i, String str) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateRowId(int i, RowId rowId) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateSQLXML(int i, SQLXML sqlxml) throws SQLException {
        throw new NotUpdatable();
    }

    public JDBC4ResultSet(String str, Field[] fieldArr, RowData rowData, MySQLConnection mySQLConnection, StatementImpl statementImpl) throws SQLException {
        super(str, fieldArr, rowData, mySQLConnection, statementImpl);
    }

    @Override // java.sql.ResultSet
    public RowId getRowId(String str) throws SQLException {
        return getRowId(findColumn(str));
    }

    @Override // java.sql.ResultSet
    public void updateAsciiStream(String str, InputStream inputStream) throws SQLException {
        updateAsciiStream(findColumn(str), inputStream);
    }

    @Override // java.sql.ResultSet
    public void updateBinaryStream(String str, InputStream inputStream) throws SQLException {
        updateBinaryStream(findColumn(str), inputStream);
    }

    @Override // java.sql.ResultSet
    public void updateBlob(String str, InputStream inputStream) throws SQLException {
        updateBlob(findColumn(str), inputStream);
    }

    @Override // java.sql.ResultSet
    public void updateCharacterStream(String str, Reader reader) throws SQLException {
        updateCharacterStream(findColumn(str), reader);
    }

    @Override // java.sql.ResultSet
    public void updateClob(String str, Reader reader) throws SQLException {
        updateClob(findColumn(str), reader);
    }

    public void updateNCharacterStream(String str, Reader reader, int i) throws SQLException {
        updateNCharacterStream(findColumn(str), reader, i);
    }

    @Override // java.sql.ResultSet
    public void updateNClob(int i, NClob nClob) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateNString(String str, String str2) throws SQLException {
        updateNString(findColumn(str), str2);
    }

    @Override // java.sql.ResultSet
    public void updateRowId(String str, RowId rowId) throws SQLException {
        updateRowId(findColumn(str), rowId);
    }

    @Override // java.sql.ResultSet
    public void updateSQLXML(String str, SQLXML sqlxml) throws SQLException {
        updateSQLXML(findColumn(str), sqlxml);
    }

    @Override // java.sql.ResultSet
    public SQLXML getSQLXML(String str) throws SQLException {
        return getSQLXML(findColumn(str));
    }

    @Override // java.sql.ResultSet
    public void updateAsciiStream(int i, InputStream inputStream, long j) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateBinaryStream(int i, InputStream inputStream, long j) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateBlob(int i, InputStream inputStream, long j) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateCharacterStream(int i, Reader reader, long j) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateClob(int i, Reader reader, long j) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateNCharacterStream(int i, Reader reader) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateNClob(int i, Reader reader) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateAsciiStream(String str, InputStream inputStream, long j) throws SQLException {
        updateAsciiStream(findColumn(str), inputStream, j);
    }

    @Override // java.sql.ResultSet
    public void updateBinaryStream(String str, InputStream inputStream, long j) throws SQLException {
        updateBinaryStream(findColumn(str), inputStream, j);
    }

    @Override // java.sql.ResultSet
    public void updateBlob(String str, InputStream inputStream, long j) throws SQLException {
        updateBlob(findColumn(str), inputStream, j);
    }

    @Override // java.sql.ResultSet
    public void updateCharacterStream(String str, Reader reader, long j) throws SQLException {
        updateCharacterStream(findColumn(str), reader, j);
    }

    @Override // java.sql.ResultSet
    public void updateClob(String str, Reader reader, long j) throws SQLException {
        updateClob(findColumn(str), reader, j);
    }

    @Override // java.sql.ResultSet
    public void updateNCharacterStream(String str, Reader reader) throws SQLException {
        updateNCharacterStream(findColumn(str), reader);
    }

    @Override // java.sql.ResultSet
    public void updateNClob(String str, Reader reader) throws SQLException {
        updateNClob(findColumn(str), reader);
    }

    @Override // java.sql.ResultSet
    public void updateNCharacterStream(int i, Reader reader, long j) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public void updateNClob(int i, Reader reader, long j) throws SQLException {
        throw new NotUpdatable();
    }

    @Override // java.sql.ResultSet
    public Reader getNCharacterStream(String str) throws SQLException {
        return getNCharacterStream(findColumn(str));
    }

    @Override // java.sql.ResultSet
    public String getNString(String str) throws SQLException {
        return getNString(findColumn(str));
    }

    @Override // java.sql.ResultSet
    public void updateNCharacterStream(String str, Reader reader, long j) throws SQLException {
        updateNCharacterStream(findColumn(str), reader, j);
    }

    @Override // java.sql.ResultSet
    public void updateNClob(String str, Reader reader, long j) throws SQLException {
        updateNClob(findColumn(str), reader, j);
    }

    @Override // java.sql.ResultSet
    public NClob getNClob(String str) throws SQLException {
        return getNClob(findColumn(str));
    }
}
