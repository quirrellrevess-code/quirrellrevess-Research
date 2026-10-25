package com.mysql.jdbc;

import java.io.Reader;
import java.sql.NClob;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;

/* JADX INFO: loaded from: classes.dex */
public class JDBC4PreparedStatementHelper {
    private JDBC4PreparedStatementHelper() {
    }

    public static void setNClob(PreparedStatement preparedStatement, int i, NClob nClob) throws SQLException {
        if (nClob == null) {
            preparedStatement.setNull(i, 2011);
        } else {
            preparedStatement.setNCharacterStream(i, nClob.getCharacterStream(), nClob.length());
        }
    }

    public static void setRowId(PreparedStatement preparedStatement, int i, RowId rowId) throws SQLException {
        throw SQLError.createSQLFeatureNotSupportedException();
    }

    public static void setSQLXML(PreparedStatement preparedStatement, int i, SQLXML sqlxml) throws SQLException {
        if (sqlxml == null) {
            preparedStatement.setNull(i, 2009);
        } else {
            preparedStatement.setCharacterStream(i, ((JDBC4MysqlSQLXML) sqlxml).serializeAsCharacterStream());
        }
    }

    public static void setNClob(PreparedStatement preparedStatement, int i, Reader reader) throws SQLException {
        preparedStatement.setNCharacterStream(i, reader);
    }

    public static void setNClob(PreparedStatement preparedStatement, int i, Reader reader, long j) throws SQLException {
        if (reader == null) {
            preparedStatement.setNull(i, 2011);
        } else {
            preparedStatement.setNCharacterStream(i, reader, j);
        }
    }
}
