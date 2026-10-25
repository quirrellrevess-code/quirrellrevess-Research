package com.mysql.jdbc;

import java.sql.SQLException;
import java.sql.SQLType;

/* JADX INFO: loaded from: classes.dex */
public class JDBC42PreparedStatement extends JDBC4PreparedStatement {
    public JDBC42PreparedStatement(MySQLConnection mySQLConnection, String str) throws SQLException {
        super(mySQLConnection, str);
    }

    private int checkSqlType(int i) throws SQLException {
        return JDBC42Helper.checkSqlType(i, getExceptionInterceptor());
    }

    private int translateAndCheckSqlType(SQLType sQLType) throws SQLException {
        return JDBC42Helper.translateAndCheckSqlType(sQLType, getExceptionInterceptor());
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setObject(int i, Object obj) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            super.setObject(i, JDBC42Helper.convertJavaTimeToJavaSql(obj));
        }
    }

    public JDBC42PreparedStatement(MySQLConnection mySQLConnection, String str, String str2) throws SQLException {
        super(mySQLConnection, str, str2);
    }

    public JDBC42PreparedStatement(MySQLConnection mySQLConnection, String str, String str2, PreparedStatement.ParseInfo parseInfo) throws SQLException {
        super(mySQLConnection, str, str2, parseInfo);
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setObject(int i, Object obj, int i2) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            super.setObject(i, JDBC42Helper.convertJavaTimeToJavaSql(obj), checkSqlType(i2));
        }
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setObject(int i, Object obj, int i2, int i3) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            super.setObject(i, JDBC42Helper.convertJavaTimeToJavaSql(obj), checkSqlType(i2), i3);
        }
    }

    public void setObject(int i, Object obj, SQLType sQLType) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            super.setObject(i, JDBC42Helper.convertJavaTimeToJavaSql(obj), translateAndCheckSqlType(sQLType));
        }
    }

    public void setObject(int i, Object obj, SQLType sQLType, int i2) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            super.setObject(i, JDBC42Helper.convertJavaTimeToJavaSql(obj), translateAndCheckSqlType(sQLType), i2);
        }
    }
}
