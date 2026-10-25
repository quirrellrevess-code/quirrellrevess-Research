package com.mysql.jdbc;

import java.io.Reader;
import java.sql.NClob;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;

/* JADX INFO: loaded from: classes.dex */
public class JDBC4CallableStatement extends CallableStatement {
    public JDBC4CallableStatement(MySQLConnection mySQLConnection, CallableStatement.CallableStatementParamInfo callableStatementParamInfo) throws SQLException {
        super(mySQLConnection, callableStatementParamInfo);
    }

    @Override // java.sql.CallableStatement
    public Reader getCharacterStream(int i) throws SQLException {
        ResultSetInternalMethods outputParameters = getOutputParameters(i);
        Reader characterStream = outputParameters.getCharacterStream(mapOutputParameterIndexToRsIndex(i));
        this.outputParamWasNull = outputParameters.wasNull();
        return characterStream;
    }

    @Override // java.sql.CallableStatement
    public Reader getNCharacterStream(int i) throws SQLException {
        ResultSetInternalMethods outputParameters = getOutputParameters(i);
        Reader nCharacterStream = ((JDBC4ResultSet) outputParameters).getNCharacterStream(mapOutputParameterIndexToRsIndex(i));
        this.outputParamWasNull = outputParameters.wasNull();
        return nCharacterStream;
    }

    @Override // java.sql.CallableStatement
    public NClob getNClob(int i) throws SQLException {
        ResultSetInternalMethods outputParameters = getOutputParameters(i);
        NClob nClob = ((JDBC4ResultSet) outputParameters).getNClob(mapOutputParameterIndexToRsIndex(i));
        this.outputParamWasNull = outputParameters.wasNull();
        return nClob;
    }

    @Override // java.sql.CallableStatement
    public String getNString(int i) throws SQLException {
        ResultSetInternalMethods outputParameters = getOutputParameters(i);
        String nString = ((JDBC4ResultSet) outputParameters).getNString(mapOutputParameterIndexToRsIndex(i));
        this.outputParamWasNull = outputParameters.wasNull();
        return nString;
    }

    @Override // java.sql.CallableStatement
    public RowId getRowId(int i) throws SQLException {
        ResultSetInternalMethods outputParameters = getOutputParameters(i);
        RowId rowId = ((JDBC4ResultSet) outputParameters).getRowId(mapOutputParameterIndexToRsIndex(i));
        this.outputParamWasNull = outputParameters.wasNull();
        return rowId;
    }

    @Override // java.sql.CallableStatement
    public SQLXML getSQLXML(int i) throws SQLException {
        ResultSetInternalMethods outputParameters = getOutputParameters(i);
        SQLXML sqlxml = ((JDBC4ResultSet) outputParameters).getSQLXML(mapOutputParameterIndexToRsIndex(i));
        this.outputParamWasNull = outputParameters.wasNull();
        return sqlxml;
    }

    @Override // java.sql.PreparedStatement
    public void setNClob(int i, NClob nClob) throws SQLException {
        JDBC4PreparedStatementHelper.setNClob(this, i, nClob);
    }

    @Override // java.sql.CallableStatement
    public void setNString(String str, String str2) throws SQLException {
        setNString(getNamedParamIndex(str, false), str2);
    }

    @Override // java.sql.PreparedStatement
    public void setRowId(int i, RowId rowId) throws SQLException {
        JDBC4PreparedStatementHelper.setRowId(this, i, rowId);
    }

    @Override // java.sql.PreparedStatement
    public void setSQLXML(int i, SQLXML sqlxml) throws SQLException {
        JDBC4PreparedStatementHelper.setSQLXML(this, i, sqlxml);
    }

    public JDBC4CallableStatement(MySQLConnection mySQLConnection, String str, String str2, boolean z) throws SQLException {
        super(mySQLConnection, str, str2, z);
    }

    @Override // java.sql.CallableStatement
    public void setNClob(String str, NClob nClob) throws SQLException {
        JDBC4PreparedStatementHelper.setNClob(this, getNamedParamIndex(str, false), nClob);
    }

    @Override // java.sql.CallableStatement
    public void setRowId(String str, RowId rowId) throws SQLException {
        JDBC4PreparedStatementHelper.setRowId(this, getNamedParamIndex(str, false), rowId);
    }

    @Override // java.sql.CallableStatement
    public void setSQLXML(String str, SQLXML sqlxml) throws SQLException {
        JDBC4PreparedStatementHelper.setSQLXML(this, getNamedParamIndex(str, false), sqlxml);
    }

    @Override // java.sql.CallableStatement
    public void setNClob(String str, Reader reader) throws SQLException {
        setNClob(getNamedParamIndex(str, false), reader);
    }

    @Override // java.sql.CallableStatement
    public Reader getCharacterStream(String str) throws SQLException {
        ResultSetInternalMethods outputParameters = getOutputParameters(0);
        Reader characterStream = outputParameters.getCharacterStream(fixParameterName(str));
        this.outputParamWasNull = outputParameters.wasNull();
        return characterStream;
    }

    @Override // java.sql.CallableStatement
    public Reader getNCharacterStream(String str) throws SQLException {
        ResultSetInternalMethods outputParameters = getOutputParameters(0);
        Reader nCharacterStream = ((JDBC4ResultSet) outputParameters).getNCharacterStream(fixParameterName(str));
        this.outputParamWasNull = outputParameters.wasNull();
        return nCharacterStream;
    }

    @Override // java.sql.CallableStatement
    public NClob getNClob(String str) throws SQLException {
        ResultSetInternalMethods outputParameters = getOutputParameters(0);
        NClob nClob = ((JDBC4ResultSet) outputParameters).getNClob(fixParameterName(str));
        this.outputParamWasNull = outputParameters.wasNull();
        return nClob;
    }

    @Override // java.sql.CallableStatement
    public String getNString(String str) throws SQLException {
        ResultSetInternalMethods outputParameters = getOutputParameters(0);
        String nString = ((JDBC4ResultSet) outputParameters).getNString(fixParameterName(str));
        this.outputParamWasNull = outputParameters.wasNull();
        return nString;
    }

    @Override // java.sql.CallableStatement
    public RowId getRowId(String str) throws SQLException {
        ResultSetInternalMethods outputParameters = getOutputParameters(0);
        RowId rowId = ((JDBC4ResultSet) outputParameters).getRowId(fixParameterName(str));
        this.outputParamWasNull = outputParameters.wasNull();
        return rowId;
    }

    @Override // java.sql.CallableStatement
    public SQLXML getSQLXML(String str) throws SQLException {
        ResultSetInternalMethods outputParameters = getOutputParameters(0);
        SQLXML sqlxml = ((JDBC4ResultSet) outputParameters).getSQLXML(fixParameterName(str));
        this.outputParamWasNull = outputParameters.wasNull();
        return sqlxml;
    }

    @Override // java.sql.CallableStatement
    public void setNClob(String str, Reader reader, long j) throws SQLException {
        setNClob(getNamedParamIndex(str, false), reader, j);
    }
}
