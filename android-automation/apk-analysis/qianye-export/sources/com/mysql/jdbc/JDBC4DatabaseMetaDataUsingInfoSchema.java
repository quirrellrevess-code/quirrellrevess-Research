package com.mysql.jdbc;

import com.google.android.flexbox.BuildConfig;
import java.sql.ResultSet;
import java.sql.RowIdLifetime;
import java.sql.SQLException;

/* JADX INFO: loaded from: classes.dex */
public class JDBC4DatabaseMetaDataUsingInfoSchema extends DatabaseMetaDataUsingInfoSchema {

    /* JADX INFO: renamed from: com.mysql.jdbc.JDBC4DatabaseMetaDataUsingInfoSchema$1 */
    public static /* synthetic */ class C02931 {

        /* JADX INFO: renamed from: $SwitchMap$com$mysql$jdbc$DatabaseMetaDataUsingInfoSchema$JDBC4FunctionConstant */
        public static final /* synthetic */ int[] f80x8b915a16;

        static {
            int[] iArr = new int[DatabaseMetaDataUsingInfoSchema.JDBC4FunctionConstant.values().length];
            f80x8b915a16 = iArr;
            try {
                iArr[DatabaseMetaDataUsingInfoSchema.JDBC4FunctionConstant.FUNCTION_COLUMN_IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f80x8b915a16[DatabaseMetaDataUsingInfoSchema.JDBC4FunctionConstant.FUNCTION_COLUMN_INOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f80x8b915a16[DatabaseMetaDataUsingInfoSchema.JDBC4FunctionConstant.FUNCTION_COLUMN_OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f80x8b915a16[DatabaseMetaDataUsingInfoSchema.JDBC4FunctionConstant.FUNCTION_COLUMN_RETURN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f80x8b915a16[DatabaseMetaDataUsingInfoSchema.JDBC4FunctionConstant.FUNCTION_COLUMN_RESULT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f80x8b915a16[DatabaseMetaDataUsingInfoSchema.JDBC4FunctionConstant.FUNCTION_COLUMN_UNKNOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f80x8b915a16[DatabaseMetaDataUsingInfoSchema.JDBC4FunctionConstant.FUNCTION_NO_NULLS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f80x8b915a16[DatabaseMetaDataUsingInfoSchema.JDBC4FunctionConstant.FUNCTION_NULLABLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f80x8b915a16[DatabaseMetaDataUsingInfoSchema.JDBC4FunctionConstant.FUNCTION_NULLABLE_UNKNOWN.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public JDBC4DatabaseMetaDataUsingInfoSchema(MySQLConnection mySQLConnection, String str) throws SQLException {
        super(mySQLConnection, str);
    }

    @Override // com.mysql.jdbc.DatabaseMetaData
    public int getColumnType(boolean z, boolean z2, boolean z3, boolean z4) {
        return JDBC4DatabaseMetaData.getProcedureOrFunctionColumnType(z, z2, z3, z4);
    }

    @Override // com.mysql.jdbc.DatabaseMetaDataUsingInfoSchema
    public int getJDBC4FunctionConstant(DatabaseMetaDataUsingInfoSchema.JDBC4FunctionConstant jDBC4FunctionConstant) {
        switch (C02931.f80x8b915a16[jDBC4FunctionConstant.ordinal()]) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
            case 7:
                return 0;
            case 8:
                return 1;
            case 9:
                return 2;
            default:
                return -1;
        }
    }

    @Override // com.mysql.jdbc.DatabaseMetaDataUsingInfoSchema, com.mysql.jdbc.DatabaseMetaData
    public int getJDBC4FunctionNoTableConstant() {
        return 1;
    }

    @Override // com.mysql.jdbc.DatabaseMetaDataUsingInfoSchema
    public ResultSet getProcedureColumnsNoISParametersView(String str, String str2, String str3, String str4) throws SQLException {
        return getProcedureOrFunctionColumns(createProcedureColumnsFields(), str, str2, str3, str4, true, this.conn.getGetProceduresReturnsFunctions());
    }

    @Override // com.mysql.jdbc.DatabaseMetaDataUsingInfoSchema
    public String getRoutineTypeConditionForGetProcedureColumns() {
        return this.conn.getGetProceduresReturnsFunctions() ? BuildConfig.FLAVOR : "ROUTINE_TYPE = 'PROCEDURE' AND ";
    }

    @Override // com.mysql.jdbc.DatabaseMetaDataUsingInfoSchema
    public String getRoutineTypeConditionForGetProcedures() {
        return this.conn.getGetProceduresReturnsFunctions() ? BuildConfig.FLAVOR : "ROUTINE_TYPE = 'PROCEDURE' AND ";
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
