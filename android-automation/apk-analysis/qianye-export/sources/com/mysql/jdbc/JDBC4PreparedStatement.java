package com.mysql.jdbc;

import java.sql.NClob;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;

/* JADX INFO: loaded from: classes.dex */
public class JDBC4PreparedStatement extends PreparedStatement {
    public JDBC4PreparedStatement(MySQLConnection mySQLConnection, String str) throws SQLException {
        super(mySQLConnection, str);
    }

    @Override // java.sql.PreparedStatement
    public void setNClob(int i, NClob nClob) throws SQLException {
        JDBC4PreparedStatementHelper.setNClob(this, i, nClob);
    }

    @Override // java.sql.PreparedStatement
    public void setRowId(int i, RowId rowId) throws SQLException {
        JDBC4PreparedStatementHelper.setRowId(this, i, rowId);
    }

    @Override // java.sql.PreparedStatement
    public void setSQLXML(int i, SQLXML sqlxml) throws SQLException {
        JDBC4PreparedStatementHelper.setSQLXML(this, i, sqlxml);
    }

    public JDBC4PreparedStatement(MySQLConnection mySQLConnection, String str, String str2) throws SQLException {
        super(mySQLConnection, str, str2);
    }

    public JDBC4PreparedStatement(MySQLConnection mySQLConnection, String str, String str2, PreparedStatement.ParseInfo parseInfo) throws SQLException {
        super(mySQLConnection, str, str2, parseInfo);
    }
}
