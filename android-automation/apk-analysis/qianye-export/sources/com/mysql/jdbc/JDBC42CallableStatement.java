package com.mysql.jdbc;

import java.sql.SQLException;
import java.sql.SQLType;

/* JADX INFO: loaded from: classes.dex */
public class JDBC42CallableStatement extends JDBC4CallableStatement {
    public JDBC42CallableStatement(MySQLConnection mySQLConnection, CallableStatement.CallableStatementParamInfo callableStatementParamInfo) throws SQLException {
        super(mySQLConnection, callableStatementParamInfo);
    }

    private int checkSqlType(int i) throws SQLException {
        return JDBC42Helper.checkSqlType(i, getExceptionInterceptor());
    }

    private int translateAndCheckSqlType(SQLType sQLType) throws SQLException {
        return JDBC42Helper.translateAndCheckSqlType(sQLType, getExceptionInterceptor());
    }

    public void registerOutParameter(int i, SQLType sQLType) throws SQLException {
        super.registerOutParameter(i, translateAndCheckSqlType(sQLType));
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setObject(int i, Object obj) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            super.setObject(i, JDBC42Helper.convertJavaTimeToJavaSql(obj));
        }
    }

    public JDBC42CallableStatement(MySQLConnection mySQLConnection, String str, String str2, boolean z) throws SQLException {
        super(mySQLConnection, str, str2, z);
    }

    public void registerOutParameter(int i, SQLType sQLType, int i2) throws SQLException {
        super.registerOutParameter(i, translateAndCheckSqlType(sQLType), i2);
    }

    public void registerOutParameter(int i, SQLType sQLType, String str) throws SQLException {
        super.registerOutParameter(i, translateAndCheckSqlType(sQLType), str);
    }

    public void registerOutParameter(String str, SQLType sQLType) throws SQLException {
        super.registerOutParameter(str, translateAndCheckSqlType(sQLType));
    }

    @Override // com.mysql.jdbc.PreparedStatement, java.sql.PreparedStatement
    public void setObject(int i, Object obj, int i2) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            super.setObject(i, JDBC42Helper.convertJavaTimeToJavaSql(obj), checkSqlType(i2));
        }
    }

    public void registerOutParameter(String str, SQLType sQLType, int i) throws SQLException {
        super.registerOutParameter(str, translateAndCheckSqlType(sQLType), i);
    }

    public void registerOutParameter(String str, SQLType sQLType, String str2) throws SQLException {
        super.registerOutParameter(str, translateAndCheckSqlType(sQLType), str2);
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

    public void setObject(String str, Object obj, SQLType sQLType) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            super.setObject(str, JDBC42Helper.convertJavaTimeToJavaSql(obj), translateAndCheckSqlType(sQLType));
        }
    }

    public void setObject(String str, Object obj, SQLType sQLType, int i) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            super.setObject(str, JDBC42Helper.convertJavaTimeToJavaSql(obj), translateAndCheckSqlType(sQLType), i);
        }
    }
}
