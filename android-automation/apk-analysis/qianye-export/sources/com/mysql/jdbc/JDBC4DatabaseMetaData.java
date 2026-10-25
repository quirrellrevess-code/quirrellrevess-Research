package com.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.RowIdLifetime;
import java.sql.SQLException;

/* JADX INFO: loaded from: classes.dex */
public class JDBC4DatabaseMetaData extends DatabaseMetaData {
    public JDBC4DatabaseMetaData(MySQLConnection mySQLConnection, String str) {
        super(mySQLConnection, str);
    }

    public static int getProcedureOrFunctionColumnType(boolean z, boolean z2, boolean z3, boolean z4) {
        if (z2 && z) {
            return 2;
        }
        if (z2) {
            return 1;
        }
        if (z) {
            return z4 ? 3 : 4;
        }
        if (z3) {
            return z4 ? 4 : 5;
        }
        return 0;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean autoCommitFailureClosesAllResultSets() throws SQLException {
        return false;
    }

    @Override // com.mysql.jdbc.DatabaseMetaData
    public int getColumnType(boolean z, boolean z2, boolean z3, boolean z4) {
        return getProcedureOrFunctionColumnType(z, z2, z3, z4);
    }

    @Override // com.mysql.jdbc.DatabaseMetaData
    public int getJDBC4FunctionNoTableConstant() {
        return 1;
    }

    @Override // com.mysql.jdbc.DatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getProcedureColumns(String str, String str2, String str3, String str4) throws SQLException {
        return getProcedureOrFunctionColumns(createProcedureColumnsFields(), str, str2, str3, str4, true, this.conn.getGetProceduresReturnsFunctions());
    }

    @Override // com.mysql.jdbc.DatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getProcedures(String str, String str2, String str3) throws SQLException {
        return getProceduresAndOrFunctions(createFieldMetadataForGetProcedures(), str, str2, str3, true, this.conn.getGetProceduresReturnsFunctions());
    }

    @Override // java.sql.DatabaseMetaData
    public RowIdLifetime getRowIdLifetime() throws SQLException {
        return RowIdLifetime.ROWID_UNSUPPORTED;
    }

    @Override // java.sql.Wrapper
    public boolean isWrapperFor(Class<?> cls) throws SQLException {
        return cls.isInstance(this);
    }

    @Override // java.sql.Wrapper
    public <T> T unwrap(Class<T> cls) throws SQLException {
        try {
            return cls.cast(this);
        } catch (ClassCastException unused) {
            throw SQLError.createSQLException("Unable to unwrap to " + cls.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.conn.getExceptionInterceptor());
        }
    }
}
