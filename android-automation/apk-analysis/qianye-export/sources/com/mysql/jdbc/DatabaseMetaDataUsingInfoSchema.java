package com.mysql.jdbc;

import com.google.android.flexbox.BuildConfig;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DatabaseMetaDataUsingInfoSchema extends DatabaseMetaData {
    private final boolean hasParametersView;
    private boolean hasReferentialConstraintsView;

    public enum JDBC4FunctionConstant {
        FUNCTION_COLUMN_UNKNOWN,
        FUNCTION_COLUMN_IN,
        FUNCTION_COLUMN_INOUT,
        FUNCTION_COLUMN_OUT,
        FUNCTION_COLUMN_RETURN,
        FUNCTION_COLUMN_RESULT,
        FUNCTION_NO_NULLS,
        FUNCTION_NULLABLE,
        FUNCTION_NULLABLE_UNKNOWN
    }

    public DatabaseMetaDataUsingInfoSchema(MySQLConnection mySQLConnection, String str) throws SQLException {
        super(mySQLConnection, str);
        this.hasReferentialConstraintsView = this.conn.versionMeetsMinimum(5, 1, 10);
        ResultSet tables = null;
        try {
            tables = super.getTables("INFORMATION_SCHEMA", null, "PARAMETERS", new String[0]);
            this.hasParametersView = tables.next();
        } finally {
            if (tables != null) {
                tables.close();
            }
        }
    }

    private String generateDeleteRuleClause() {
        if (!this.hasReferentialConstraintsView) {
            return String.valueOf(1);
        }
        return "CASE WHEN R.DELETE_RULE='CASCADE' THEN " + String.valueOf(0) + " WHEN R.DELETE_RULE='SET NULL' THEN " + String.valueOf(2) + " WHEN R.DELETE_RULE='SET DEFAULT' THEN " + String.valueOf(4) + " WHEN R.DELETE_RULE='RESTRICT' THEN " + String.valueOf(1) + " WHEN R.DELETE_RULE='NO ACTION' THEN " + String.valueOf(3) + " ELSE " + String.valueOf(3) + " END ";
    }

    private String generateOptionalRefContraintsJoin() {
        return this.hasReferentialConstraintsView ? "JOIN INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS R ON (R.CONSTRAINT_NAME = B.CONSTRAINT_NAME AND R.TABLE_NAME = B.TABLE_NAME AND R.CONSTRAINT_SCHEMA = B.TABLE_SCHEMA) " : BuildConfig.FLAVOR;
    }

    private String generateUpdateRuleClause() {
        if (!this.hasReferentialConstraintsView) {
            return String.valueOf(1);
        }
        return "CASE WHEN R.UPDATE_RULE='CASCADE' THEN " + String.valueOf(0) + " WHEN R.UPDATE_RULE='SET NULL' THEN " + String.valueOf(2) + " WHEN R.UPDATE_RULE='SET DEFAULT' THEN " + String.valueOf(4) + " WHEN R.UPDATE_RULE='RESTRICT' THEN " + String.valueOf(1) + " WHEN R.UPDATE_RULE='NO ACTION' THEN " + String.valueOf(3) + " ELSE " + String.valueOf(3) + " END ";
    }

    public ResultSet executeMetadataQuery(java.sql.PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSetExecuteQuery = preparedStatement.executeQuery();
        ((ResultSetInternalMethods) resultSetExecuteQuery).setOwningStatement(null);
        return resultSetExecuteQuery;
    }

    @Override // com.mysql.jdbc.DatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getColumnPrivileges(String str, String str2, String str3, String str4) throws SQLException {
        if (str4 == null) {
            if (!this.conn.getNullNamePatternMatchesAll()) {
                throw SQLError.createSQLException("Column name pattern can not be NULL or empty.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            str4 = "%";
        }
        if (str == null && this.conn.getNullCatalogMeansCurrent()) {
            str = this.database;
        }
        java.sql.PreparedStatement preparedStatementPrepareMetaDataSafeStatement = null;
        try {
            preparedStatementPrepareMetaDataSafeStatement = prepareMetaDataSafeStatement("SELECT TABLE_SCHEMA AS TABLE_CAT, NULL AS TABLE_SCHEM, TABLE_NAME,COLUMN_NAME, NULL AS GRANTOR, GRANTEE, PRIVILEGE_TYPE AS PRIVILEGE, IS_GRANTABLE FROM INFORMATION_SCHEMA.COLUMN_PRIVILEGES WHERE TABLE_SCHEMA LIKE ? AND TABLE_NAME =? AND COLUMN_NAME LIKE ? ORDER BY COLUMN_NAME, PRIVILEGE_TYPE");
            if (str != null) {
                preparedStatementPrepareMetaDataSafeStatement.setString(1, str);
            } else {
                preparedStatementPrepareMetaDataSafeStatement.setString(1, "%");
            }
            preparedStatementPrepareMetaDataSafeStatement.setString(2, str3);
            preparedStatementPrepareMetaDataSafeStatement.setString(3, str4);
            ResultSet resultSetExecuteMetadataQuery = executeMetadataQuery(preparedStatementPrepareMetaDataSafeStatement);
            ((ResultSetInternalMethods) resultSetExecuteMetadataQuery).redefineFieldsForDBMD(new Field[]{new Field(BuildConfig.FLAVOR, "TABLE_CAT", 1, 64), new Field(BuildConfig.FLAVOR, "TABLE_SCHEM", 1, 1), new Field(BuildConfig.FLAVOR, "TABLE_NAME", 1, 64), new Field(BuildConfig.FLAVOR, "COLUMN_NAME", 1, 64), new Field(BuildConfig.FLAVOR, "GRANTOR", 1, 77), new Field(BuildConfig.FLAVOR, "GRANTEE", 1, 77), new Field(BuildConfig.FLAVOR, "PRIVILEGE", 1, 64), new Field(BuildConfig.FLAVOR, "IS_GRANTABLE", 1, 3)});
            return resultSetExecuteMetadataQuery;
        } finally {
            if (preparedStatementPrepareMetaDataSafeStatement != null) {
                preparedStatementPrepareMetaDataSafeStatement.close();
            }
        }
    }

    @Override // com.mysql.jdbc.DatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getColumns(String str, String str2, String str3, String str4) throws SQLException {
        if (str4 == null) {
            if (!this.conn.getNullNamePatternMatchesAll()) {
                throw SQLError.createSQLException("Column name pattern can not be NULL or empty.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            str4 = "%";
        }
        if (str == null && this.conn.getNullCatalogMeansCurrent()) {
            str = this.database;
        }
        StringBuilder sb = new StringBuilder("SELECT TABLE_SCHEMA AS TABLE_CAT, NULL AS TABLE_SCHEM, TABLE_NAME, COLUMN_NAME,");
        MysqlDefs.appendJdbcTypeMappingQuery(sb, "DATA_TYPE");
        sb.append(" AS DATA_TYPE, ");
        if (this.conn.getCapitalizeTypeNames()) {
            sb.append("UPPER(CASE WHEN LOCATE('unsigned', COLUMN_TYPE) != 0 AND LOCATE('unsigned', DATA_TYPE) = 0 AND LOCATE('set', DATA_TYPE) <> 1 AND LOCATE('enum', DATA_TYPE) <> 1 THEN CONCAT(DATA_TYPE, ' unsigned') ELSE DATA_TYPE END) AS TYPE_NAME,");
        } else {
            sb.append("CASE WHEN LOCATE('unsigned', COLUMN_TYPE) != 0 AND LOCATE('unsigned', DATA_TYPE) = 0 AND LOCATE('set', DATA_TYPE) <> 1 AND LOCATE('enum', DATA_TYPE) <> 1 THEN CONCAT(DATA_TYPE, ' unsigned') ELSE DATA_TYPE END AS TYPE_NAME,");
        }
        sb.append("CASE WHEN LCASE(DATA_TYPE)='date' THEN 10 WHEN LCASE(DATA_TYPE)='time' THEN 8 WHEN LCASE(DATA_TYPE)='datetime' THEN 19 WHEN LCASE(DATA_TYPE)='timestamp' THEN 19 WHEN CHARACTER_MAXIMUM_LENGTH IS NULL THEN NUMERIC_PRECISION WHEN CHARACTER_MAXIMUM_LENGTH > 2147483647 THEN 2147483647 ELSE CHARACTER_MAXIMUM_LENGTH END AS COLUMN_SIZE, " + MysqlIO.getMaxBuf() + " AS BUFFER_LENGTH,NUMERIC_SCALE AS DECIMAL_DIGITS,10 AS NUM_PREC_RADIX,CASE WHEN IS_NULLABLE='NO' THEN 0 ELSE CASE WHEN IS_NULLABLE='YES' THEN 1 ELSE 2 END END AS NULLABLE,COLUMN_COMMENT AS REMARKS,COLUMN_DEFAULT AS COLUMN_DEF,0 AS SQL_DATA_TYPE,0 AS SQL_DATETIME_SUB,CASE WHEN CHARACTER_OCTET_LENGTH > 2147483647 THEN 2147483647 ELSE CHARACTER_OCTET_LENGTH END AS CHAR_OCTET_LENGTH,ORDINAL_POSITION,IS_NULLABLE,NULL AS SCOPE_CATALOG,NULL AS SCOPE_SCHEMA,NULL AS SCOPE_TABLE,NULL AS SOURCE_DATA_TYPE,IF (EXTRA LIKE '%auto_increment%','YES','NO') AS IS_AUTOINCREMENT, IF (EXTRA LIKE '%GENERATED%','YES','NO') AS IS_GENERATEDCOLUMN FROM INFORMATION_SCHEMA.COLUMNS WHERE ");
        boolean zEqualsIgnoreCase = "information_schema".equalsIgnoreCase(str);
        if (str == null) {
            sb.append("TABLE_SCHEMA LIKE ? AND ");
        } else if (zEqualsIgnoreCase || (StringUtils.indexOfIgnoreCase(0, str, "%") == -1 && StringUtils.indexOfIgnoreCase(0, str, "_") == -1)) {
            sb.append("TABLE_SCHEMA = ? AND ");
        } else {
            sb.append("TABLE_SCHEMA LIKE ? AND ");
        }
        if (str3 != null && StringUtils.indexOfIgnoreCase(0, str3, "%") == -1 && StringUtils.indexOfIgnoreCase(0, str3, "_") == -1) {
            sb.append("TABLE_NAME = ? AND ");
        } else {
            sb.append("TABLE_NAME LIKE ? AND ");
        }
        if (StringUtils.indexOfIgnoreCase(0, str4, "%") == -1 && StringUtils.indexOfIgnoreCase(0, str4, "_") == -1) {
            sb.append("COLUMN_NAME = ? ");
        } else {
            sb.append("COLUMN_NAME LIKE ? ");
        }
        sb.append("ORDER BY TABLE_SCHEMA, TABLE_NAME, ORDINAL_POSITION");
        java.sql.PreparedStatement preparedStatementPrepareMetaDataSafeStatement = null;
        try {
            preparedStatementPrepareMetaDataSafeStatement = prepareMetaDataSafeStatement(sb.toString());
            if (str != null) {
                preparedStatementPrepareMetaDataSafeStatement.setString(1, str);
            } else {
                preparedStatementPrepareMetaDataSafeStatement.setString(1, "%");
            }
            preparedStatementPrepareMetaDataSafeStatement.setString(2, str3);
            preparedStatementPrepareMetaDataSafeStatement.setString(3, str4);
            ResultSet resultSetExecuteMetadataQuery = executeMetadataQuery(preparedStatementPrepareMetaDataSafeStatement);
            ((ResultSetInternalMethods) resultSetExecuteMetadataQuery).redefineFieldsForDBMD(createColumnsFields());
            return resultSetExecuteMetadataQuery;
        } finally {
            if (preparedStatementPrepareMetaDataSafeStatement != null) {
                preparedStatementPrepareMetaDataSafeStatement.close();
            }
        }
    }

    @Override // com.mysql.jdbc.DatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getCrossReference(String str, String str2, String str3, String str4, String str5, String str6) throws SQLException {
        if (str3 == null) {
            throw SQLError.createSQLException("Table not specified.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
        if (str == null && this.conn.getNullCatalogMeansCurrent()) {
            str = this.database;
        }
        if (str4 == null && this.conn.getNullCatalogMeansCurrent()) {
            str4 = this.database;
        }
        java.sql.PreparedStatement preparedStatement = null;
        try {
            java.sql.PreparedStatement preparedStatementPrepareMetaDataSafeStatement = prepareMetaDataSafeStatement("SELECT A.REFERENCED_TABLE_SCHEMA AS PKTABLE_CAT,NULL AS PKTABLE_SCHEM, A.REFERENCED_TABLE_NAME AS PKTABLE_NAME,A.REFERENCED_COLUMN_NAME AS PKCOLUMN_NAME, A.TABLE_SCHEMA AS FKTABLE_CAT, NULL AS FKTABLE_SCHEM, A.TABLE_NAME AS FKTABLE_NAME, A.COLUMN_NAME AS FKCOLUMN_NAME, A.ORDINAL_POSITION AS KEY_SEQ," + generateUpdateRuleClause() + " AS UPDATE_RULE," + generateDeleteRuleClause() + " AS DELETE_RULE,A.CONSTRAINT_NAME AS FK_NAME,(SELECT CONSTRAINT_NAME FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS WHERE TABLE_SCHEMA = A.REFERENCED_TABLE_SCHEMA AND TABLE_NAME = A.REFERENCED_TABLE_NAME AND CONSTRAINT_TYPE IN ('UNIQUE','PRIMARY KEY') LIMIT 1) AS PK_NAME,7 AS DEFERRABILITY FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE A JOIN INFORMATION_SCHEMA.TABLE_CONSTRAINTS B USING (TABLE_SCHEMA, TABLE_NAME, CONSTRAINT_NAME) " + generateOptionalRefContraintsJoin() + "WHERE B.CONSTRAINT_TYPE = 'FOREIGN KEY' AND A.REFERENCED_TABLE_SCHEMA LIKE ? AND A.REFERENCED_TABLE_NAME=? AND A.TABLE_SCHEMA LIKE ? AND A.TABLE_NAME=? ORDER BY A.TABLE_SCHEMA, A.TABLE_NAME, A.ORDINAL_POSITION");
            if (str != null) {
                preparedStatementPrepareMetaDataSafeStatement.setString(1, str);
            } else {
                preparedStatementPrepareMetaDataSafeStatement.setString(1, "%");
            }
            preparedStatementPrepareMetaDataSafeStatement.setString(2, str3);
            if (str4 != null) {
                preparedStatementPrepareMetaDataSafeStatement.setString(3, str4);
            } else {
                preparedStatementPrepareMetaDataSafeStatement.setString(3, "%");
            }
            preparedStatementPrepareMetaDataSafeStatement.setString(4, str6);
            ResultSet resultSetExecuteMetadataQuery = executeMetadataQuery(preparedStatementPrepareMetaDataSafeStatement);
            ((ResultSetInternalMethods) resultSetExecuteMetadataQuery).redefineFieldsForDBMD(createFkMetadataFields());
            if (preparedStatementPrepareMetaDataSafeStatement != null) {
                preparedStatementPrepareMetaDataSafeStatement.close();
            }
            return resultSetExecuteMetadataQuery;
        } catch (Throwable th) {
            if (0 != 0) {
                preparedStatement.close();
            }
            throw th;
        }
    }

    @Override // com.mysql.jdbc.DatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getExportedKeys(String str, String str2, String str3) throws SQLException {
        if (str3 == null) {
            throw SQLError.createSQLException("Table not specified.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
        if (str == null && this.conn.getNullCatalogMeansCurrent()) {
            str = this.database;
        }
        java.sql.PreparedStatement preparedStatementPrepareMetaDataSafeStatement = null;
        try {
            preparedStatementPrepareMetaDataSafeStatement = prepareMetaDataSafeStatement("SELECT A.REFERENCED_TABLE_SCHEMA AS PKTABLE_CAT, NULL AS PKTABLE_SCHEM, A.REFERENCED_TABLE_NAME AS PKTABLE_NAME, A.REFERENCED_COLUMN_NAME AS PKCOLUMN_NAME, A.TABLE_SCHEMA AS FKTABLE_CAT, NULL AS FKTABLE_SCHEM, A.TABLE_NAME AS FKTABLE_NAME,A.COLUMN_NAME AS FKCOLUMN_NAME, A.ORDINAL_POSITION AS KEY_SEQ," + generateUpdateRuleClause() + " AS UPDATE_RULE," + generateDeleteRuleClause() + " AS DELETE_RULE,A.CONSTRAINT_NAME AS FK_NAME,(SELECT CONSTRAINT_NAME FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS WHERE TABLE_SCHEMA = A.REFERENCED_TABLE_SCHEMA AND TABLE_NAME = A.REFERENCED_TABLE_NAME AND CONSTRAINT_TYPE IN ('UNIQUE','PRIMARY KEY') LIMIT 1) AS PK_NAME,7 AS DEFERRABILITY FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE A JOIN INFORMATION_SCHEMA.TABLE_CONSTRAINTS B USING (TABLE_SCHEMA, TABLE_NAME, CONSTRAINT_NAME) " + generateOptionalRefContraintsJoin() + "WHERE B.CONSTRAINT_TYPE = 'FOREIGN KEY' AND A.REFERENCED_TABLE_SCHEMA LIKE ? AND A.REFERENCED_TABLE_NAME=? ORDER BY A.TABLE_SCHEMA, A.TABLE_NAME, A.ORDINAL_POSITION");
            if (str != null) {
                preparedStatementPrepareMetaDataSafeStatement.setString(1, str);
            } else {
                preparedStatementPrepareMetaDataSafeStatement.setString(1, "%");
            }
            preparedStatementPrepareMetaDataSafeStatement.setString(2, str3);
            ResultSet resultSetExecuteMetadataQuery = executeMetadataQuery(preparedStatementPrepareMetaDataSafeStatement);
            ((ResultSetInternalMethods) resultSetExecuteMetadataQuery).redefineFieldsForDBMD(createFkMetadataFields());
            return resultSetExecuteMetadataQuery;
        } finally {
            if (preparedStatementPrepareMetaDataSafeStatement != null) {
                preparedStatementPrepareMetaDataSafeStatement.close();
            }
        }
    }

    @Override // com.mysql.jdbc.DatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getFunctionColumns(String str, String str2, String str3, String str4) throws SQLException {
        if (!this.hasParametersView) {
            return super.getFunctionColumns(str, str2, str3, str4);
        }
        if (str3 == null || str3.length() == 0) {
            if (!this.conn.getNullNamePatternMatchesAll()) {
                throw SQLError.createSQLException("Procedure name pattern can not be NULL or empty.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            str3 = "%";
        }
        java.sql.PreparedStatement preparedStatementPrepareMetaDataSafeStatement = null;
        if (str == null) {
            str = this.conn.getNullCatalogMeansCurrent() ? this.database : null;
        }
        StringBuilder sb = new StringBuilder("SELECT SPECIFIC_SCHEMA AS FUNCTION_CAT, NULL AS `FUNCTION_SCHEM`, SPECIFIC_NAME AS `FUNCTION_NAME`, ");
        sb.append("IFNULL(PARAMETER_NAME, '') AS `COLUMN_NAME`, CASE WHEN PARAMETER_MODE = 'IN' THEN ");
        sb.append(getJDBC4FunctionConstant(JDBC4FunctionConstant.FUNCTION_COLUMN_IN));
        sb.append(" WHEN PARAMETER_MODE = 'OUT' THEN ");
        sb.append(getJDBC4FunctionConstant(JDBC4FunctionConstant.FUNCTION_COLUMN_OUT));
        sb.append(" WHEN PARAMETER_MODE = 'INOUT' THEN ");
        sb.append(getJDBC4FunctionConstant(JDBC4FunctionConstant.FUNCTION_COLUMN_INOUT));
        sb.append(" WHEN ORDINAL_POSITION = 0 THEN ");
        sb.append(getJDBC4FunctionConstant(JDBC4FunctionConstant.FUNCTION_COLUMN_RETURN));
        sb.append(" ELSE ");
        sb.append(getJDBC4FunctionConstant(JDBC4FunctionConstant.FUNCTION_COLUMN_UNKNOWN));
        sb.append(" END AS `COLUMN_TYPE`, ");
        MysqlDefs.appendJdbcTypeMappingQuery(sb, "DATA_TYPE");
        sb.append(" AS `DATA_TYPE`, ");
        if (this.conn.getCapitalizeTypeNames()) {
            sb.append("UPPER(CASE WHEN LOCATE('unsigned', DATA_TYPE) != 0 AND LOCATE('unsigned', DATA_TYPE) = 0 THEN CONCAT(DATA_TYPE, ' unsigned') ELSE DATA_TYPE END) AS `TYPE_NAME`,");
        } else {
            sb.append("CASE WHEN LOCATE('unsigned', DATA_TYPE) != 0 AND LOCATE('unsigned', DATA_TYPE) = 0 THEN CONCAT(DATA_TYPE, ' unsigned') ELSE DATA_TYPE END AS `TYPE_NAME`,");
        }
        sb.append("NUMERIC_PRECISION AS `PRECISION`, ");
        sb.append("CASE WHEN LCASE(DATA_TYPE)='date' THEN 10 WHEN LCASE(DATA_TYPE)='time' THEN 8 WHEN LCASE(DATA_TYPE)='datetime' THEN 19 WHEN LCASE(DATA_TYPE)='timestamp' THEN 19 WHEN CHARACTER_MAXIMUM_LENGTH IS NULL THEN NUMERIC_PRECISION WHEN CHARACTER_MAXIMUM_LENGTH > 2147483647 THEN 2147483647 ELSE CHARACTER_MAXIMUM_LENGTH END AS LENGTH, ");
        sb.append("NUMERIC_SCALE AS `SCALE`, ");
        sb.append("10 AS RADIX,");
        sb.append(getJDBC4FunctionConstant(JDBC4FunctionConstant.FUNCTION_NULLABLE) + " AS `NULLABLE`,  NULL AS `REMARKS`, CHARACTER_OCTET_LENGTH AS `CHAR_OCTET_LENGTH`,  ORDINAL_POSITION, 'YES' AS `IS_NULLABLE`, SPECIFIC_NAME FROM INFORMATION_SCHEMA.PARAMETERS WHERE SPECIFIC_SCHEMA LIKE ? AND SPECIFIC_NAME LIKE ? AND (PARAMETER_NAME LIKE ? OR PARAMETER_NAME IS NULL) AND ROUTINE_TYPE='FUNCTION' ORDER BY SPECIFIC_SCHEMA, SPECIFIC_NAME, ORDINAL_POSITION");
        try {
            preparedStatementPrepareMetaDataSafeStatement = prepareMetaDataSafeStatement(sb.toString());
            if (str != null) {
                preparedStatementPrepareMetaDataSafeStatement.setString(1, str);
            } else {
                preparedStatementPrepareMetaDataSafeStatement.setString(1, "%");
            }
            preparedStatementPrepareMetaDataSafeStatement.setString(2, str3);
            preparedStatementPrepareMetaDataSafeStatement.setString(3, str4);
            ResultSet resultSetExecuteMetadataQuery = executeMetadataQuery(preparedStatementPrepareMetaDataSafeStatement);
            ((ResultSetInternalMethods) resultSetExecuteMetadataQuery).redefineFieldsForDBMD(createFunctionColumnsFields());
            return resultSetExecuteMetadataQuery;
        } finally {
            if (preparedStatementPrepareMetaDataSafeStatement != null) {
                preparedStatementPrepareMetaDataSafeStatement.close();
            }
        }
    }

    @Override // com.mysql.jdbc.DatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getFunctions(String str, String str2, String str3) throws SQLException {
        if (str3 == null || str3.length() == 0) {
            if (!this.conn.getNullNamePatternMatchesAll()) {
                throw SQLError.createSQLException("Function name pattern can not be NULL or empty.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            str3 = "%";
        }
        java.sql.PreparedStatement preparedStatementPrepareMetaDataSafeStatement = null;
        if (str == null) {
            str = this.conn.getNullCatalogMeansCurrent() ? this.database : null;
        }
        try {
            preparedStatementPrepareMetaDataSafeStatement = prepareMetaDataSafeStatement("SELECT ROUTINE_SCHEMA AS FUNCTION_CAT, NULL AS FUNCTION_SCHEM, ROUTINE_NAME AS FUNCTION_NAME, ROUTINE_COMMENT AS REMARKS, " + getJDBC4FunctionNoTableConstant() + " AS FUNCTION_TYPE, ROUTINE_NAME AS SPECIFIC_NAME FROM INFORMATION_SCHEMA.ROUTINES WHERE ROUTINE_TYPE LIKE 'FUNCTION' AND ROUTINE_SCHEMA LIKE ? AND ROUTINE_NAME LIKE ? ORDER BY FUNCTION_CAT, FUNCTION_SCHEM, FUNCTION_NAME, SPECIFIC_NAME");
            preparedStatementPrepareMetaDataSafeStatement.setString(1, str != null ? str : "%");
            preparedStatementPrepareMetaDataSafeStatement.setString(2, str3);
            ResultSet resultSetExecuteMetadataQuery = executeMetadataQuery(preparedStatementPrepareMetaDataSafeStatement);
            ((ResultSetInternalMethods) resultSetExecuteMetadataQuery).redefineFieldsForDBMD(new Field[]{new Field(BuildConfig.FLAVOR, "FUNCTION_CAT", 1, 255), new Field(BuildConfig.FLAVOR, "FUNCTION_SCHEM", 1, 255), new Field(BuildConfig.FLAVOR, "FUNCTION_NAME", 1, 255), new Field(BuildConfig.FLAVOR, "REMARKS", 1, 255), new Field(BuildConfig.FLAVOR, "FUNCTION_TYPE", 5, 6), new Field(BuildConfig.FLAVOR, "SPECIFIC_NAME", 1, 255)});
            return resultSetExecuteMetadataQuery;
        } finally {
            if (preparedStatementPrepareMetaDataSafeStatement != null) {
                preparedStatementPrepareMetaDataSafeStatement.close();
            }
        }
    }

    @Override // com.mysql.jdbc.DatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getImportedKeys(String str, String str2, String str3) throws SQLException {
        if (str3 == null) {
            throw SQLError.createSQLException("Table not specified.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
        if (str == null && this.conn.getNullCatalogMeansCurrent()) {
            str = this.database;
        }
        java.sql.PreparedStatement preparedStatementPrepareMetaDataSafeStatement = null;
        try {
            preparedStatementPrepareMetaDataSafeStatement = prepareMetaDataSafeStatement("SELECT A.REFERENCED_TABLE_SCHEMA AS PKTABLE_CAT, NULL AS PKTABLE_SCHEM, A.REFERENCED_TABLE_NAME AS PKTABLE_NAME,A.REFERENCED_COLUMN_NAME AS PKCOLUMN_NAME, A.TABLE_SCHEMA AS FKTABLE_CAT, NULL AS FKTABLE_SCHEM, A.TABLE_NAME AS FKTABLE_NAME, A.COLUMN_NAME AS FKCOLUMN_NAME, A.ORDINAL_POSITION AS KEY_SEQ," + generateUpdateRuleClause() + " AS UPDATE_RULE," + generateDeleteRuleClause() + " AS DELETE_RULE,A.CONSTRAINT_NAME AS FK_NAME,(SELECT CONSTRAINT_NAME FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS WHERE TABLE_SCHEMA = A.REFERENCED_TABLE_SCHEMA AND TABLE_NAME = A.REFERENCED_TABLE_NAME AND CONSTRAINT_TYPE IN ('UNIQUE','PRIMARY KEY') LIMIT 1) AS PK_NAME,7 AS DEFERRABILITY FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE A JOIN INFORMATION_SCHEMA.TABLE_CONSTRAINTS B USING (CONSTRAINT_NAME, TABLE_NAME) " + generateOptionalRefContraintsJoin() + "WHERE B.CONSTRAINT_TYPE = 'FOREIGN KEY' AND A.TABLE_SCHEMA LIKE ? AND A.TABLE_NAME=? AND A.REFERENCED_TABLE_SCHEMA IS NOT NULL ORDER BY A.REFERENCED_TABLE_SCHEMA, A.REFERENCED_TABLE_NAME, A.ORDINAL_POSITION");
            if (str != null) {
                preparedStatementPrepareMetaDataSafeStatement.setString(1, str);
            } else {
                preparedStatementPrepareMetaDataSafeStatement.setString(1, "%");
            }
            preparedStatementPrepareMetaDataSafeStatement.setString(2, str3);
            ResultSet resultSetExecuteMetadataQuery = executeMetadataQuery(preparedStatementPrepareMetaDataSafeStatement);
            ((ResultSetInternalMethods) resultSetExecuteMetadataQuery).redefineFieldsForDBMD(createFkMetadataFields());
            return resultSetExecuteMetadataQuery;
        } finally {
            if (preparedStatementPrepareMetaDataSafeStatement != null) {
                preparedStatementPrepareMetaDataSafeStatement.close();
            }
        }
    }

    @Override // com.mysql.jdbc.DatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getIndexInfo(String str, String str2, String str3, boolean z, boolean z2) throws SQLException {
        StringBuilder sb = new StringBuilder("SELECT TABLE_SCHEMA AS TABLE_CAT, NULL AS TABLE_SCHEM, TABLE_NAME, NON_UNIQUE,");
        sb.append("TABLE_SCHEMA AS INDEX_QUALIFIER, INDEX_NAME,3 AS TYPE, SEQ_IN_INDEX AS ORDINAL_POSITION, COLUMN_NAME,");
        sb.append("COLLATION AS ASC_OR_DESC, CARDINALITY, NULL AS PAGES, NULL AS FILTER_CONDITION FROM INFORMATION_SCHEMA.STATISTICS WHERE ");
        sb.append("TABLE_SCHEMA LIKE ? AND TABLE_NAME LIKE ?");
        if (z) {
            sb.append(" AND NON_UNIQUE=0 ");
        }
        sb.append("ORDER BY NON_UNIQUE, INDEX_NAME, SEQ_IN_INDEX");
        java.sql.PreparedStatement preparedStatementPrepareMetaDataSafeStatement = null;
        if (str == null) {
            try {
                if (this.conn.getNullCatalogMeansCurrent()) {
                    str = this.database;
                }
            } finally {
                if (preparedStatementPrepareMetaDataSafeStatement != null) {
                    preparedStatementPrepareMetaDataSafeStatement.close();
                }
            }
        }
        preparedStatementPrepareMetaDataSafeStatement = prepareMetaDataSafeStatement(sb.toString());
        if (str != null) {
            preparedStatementPrepareMetaDataSafeStatement.setString(1, str);
        } else {
            preparedStatementPrepareMetaDataSafeStatement.setString(1, "%");
        }
        preparedStatementPrepareMetaDataSafeStatement.setString(2, str3);
        ResultSet resultSetExecuteMetadataQuery = executeMetadataQuery(preparedStatementPrepareMetaDataSafeStatement);
        ((ResultSetInternalMethods) resultSetExecuteMetadataQuery).redefineFieldsForDBMD(createIndexInfoFields());
        return resultSetExecuteMetadataQuery;
    }

    public int getJDBC4FunctionConstant(JDBC4FunctionConstant jDBC4FunctionConstant) {
        return 0;
    }

    @Override // com.mysql.jdbc.DatabaseMetaData
    public int getJDBC4FunctionNoTableConstant() {
        return 0;
    }

    @Override // com.mysql.jdbc.DatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getPrimaryKeys(String str, String str2, String str3) throws SQLException {
        if (str == null && this.conn.getNullCatalogMeansCurrent()) {
            str = this.database;
        }
        if (str3 == null) {
            throw SQLError.createSQLException("Table not specified.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
        java.sql.PreparedStatement preparedStatementPrepareMetaDataSafeStatement = null;
        try {
            preparedStatementPrepareMetaDataSafeStatement = prepareMetaDataSafeStatement("SELECT TABLE_SCHEMA AS TABLE_CAT, NULL AS TABLE_SCHEM, TABLE_NAME, COLUMN_NAME, SEQ_IN_INDEX AS KEY_SEQ, 'PRIMARY' AS PK_NAME FROM INFORMATION_SCHEMA.STATISTICS WHERE TABLE_SCHEMA LIKE ? AND TABLE_NAME LIKE ? AND INDEX_NAME='PRIMARY' ORDER BY TABLE_SCHEMA, TABLE_NAME, INDEX_NAME, SEQ_IN_INDEX");
            if (str != null) {
                preparedStatementPrepareMetaDataSafeStatement.setString(1, str);
            } else {
                preparedStatementPrepareMetaDataSafeStatement.setString(1, "%");
            }
            preparedStatementPrepareMetaDataSafeStatement.setString(2, str3);
            ResultSet resultSetExecuteMetadataQuery = executeMetadataQuery(preparedStatementPrepareMetaDataSafeStatement);
            ((ResultSetInternalMethods) resultSetExecuteMetadataQuery).redefineFieldsForDBMD(new Field[]{new Field(BuildConfig.FLAVOR, "TABLE_CAT", 1, 255), new Field(BuildConfig.FLAVOR, "TABLE_SCHEM", 1, 0), new Field(BuildConfig.FLAVOR, "TABLE_NAME", 1, 255), new Field(BuildConfig.FLAVOR, "COLUMN_NAME", 1, 32), new Field(BuildConfig.FLAVOR, "KEY_SEQ", 5, 5), new Field(BuildConfig.FLAVOR, "PK_NAME", 1, 32)});
            return resultSetExecuteMetadataQuery;
        } finally {
            if (preparedStatementPrepareMetaDataSafeStatement != null) {
                preparedStatementPrepareMetaDataSafeStatement.close();
            }
        }
    }

    @Override // com.mysql.jdbc.DatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getProcedureColumns(String str, String str2, String str3, String str4) throws SQLException {
        if (!this.hasParametersView) {
            return getProcedureColumnsNoISParametersView(str, str2, str3, str4);
        }
        if (str3 == null || str3.length() == 0) {
            if (!this.conn.getNullNamePatternMatchesAll()) {
                throw SQLError.createSQLException("Procedure name pattern can not be NULL or empty.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            str3 = "%";
        }
        java.sql.PreparedStatement preparedStatementPrepareMetaDataSafeStatement = null;
        if (str == null) {
            str = this.conn.getNullCatalogMeansCurrent() ? this.database : null;
        }
        StringBuilder sb = new StringBuilder("SELECT SPECIFIC_SCHEMA AS PROCEDURE_CAT, NULL AS `PROCEDURE_SCHEM`, SPECIFIC_NAME AS `PROCEDURE_NAME`, IFNULL(PARAMETER_NAME, '') AS `COLUMN_NAME`, CASE WHEN PARAMETER_MODE = 'IN' THEN 1 WHEN PARAMETER_MODE = 'OUT' THEN 4 WHEN PARAMETER_MODE = 'INOUT' THEN 2 WHEN ORDINAL_POSITION = 0 THEN 5 ELSE 0 END AS `COLUMN_TYPE`, ");
        MysqlDefs.appendJdbcTypeMappingQuery(sb, "DATA_TYPE");
        sb.append(" AS `DATA_TYPE`, ");
        if (this.conn.getCapitalizeTypeNames()) {
            sb.append("UPPER(CASE WHEN LOCATE('unsigned', DATA_TYPE) != 0 AND LOCATE('unsigned', DATA_TYPE) = 0 THEN CONCAT(DATA_TYPE, ' unsigned') ELSE DATA_TYPE END) AS `TYPE_NAME`,");
        } else {
            sb.append("CASE WHEN LOCATE('unsigned', DATA_TYPE) != 0 AND LOCATE('unsigned', DATA_TYPE) = 0 THEN CONCAT(DATA_TYPE, ' unsigned') ELSE DATA_TYPE END AS `TYPE_NAME`,");
        }
        sb.append("NUMERIC_PRECISION AS `PRECISION`, ");
        sb.append("CASE WHEN LCASE(DATA_TYPE)='date' THEN 10 WHEN LCASE(DATA_TYPE)='time' THEN 8 WHEN LCASE(DATA_TYPE)='datetime' THEN 19 WHEN LCASE(DATA_TYPE)='timestamp' THEN 19 WHEN CHARACTER_MAXIMUM_LENGTH IS NULL THEN NUMERIC_PRECISION WHEN CHARACTER_MAXIMUM_LENGTH > 2147483647 THEN 2147483647 ELSE CHARACTER_MAXIMUM_LENGTH END AS LENGTH, ");
        sb.append("NUMERIC_SCALE AS `SCALE`, ");
        sb.append("10 AS RADIX,");
        sb.append("1 AS `NULLABLE`, NULL AS `REMARKS`, NULL AS `COLUMN_DEF`, NULL AS `SQL_DATA_TYPE`, NULL AS `SQL_DATETIME_SUB`, CHARACTER_OCTET_LENGTH AS `CHAR_OCTET_LENGTH`, ORDINAL_POSITION, 'YES' AS `IS_NULLABLE`, SPECIFIC_NAME FROM INFORMATION_SCHEMA.PARAMETERS WHERE " + getRoutineTypeConditionForGetProcedureColumns() + "SPECIFIC_SCHEMA LIKE ? AND SPECIFIC_NAME LIKE ? AND (PARAMETER_NAME LIKE ? OR PARAMETER_NAME IS NULL) ORDER BY SPECIFIC_SCHEMA, SPECIFIC_NAME, ROUTINE_TYPE, ORDINAL_POSITION");
        try {
            preparedStatementPrepareMetaDataSafeStatement = prepareMetaDataSafeStatement(sb.toString());
            if (str != null) {
                preparedStatementPrepareMetaDataSafeStatement.setString(1, str);
            } else {
                preparedStatementPrepareMetaDataSafeStatement.setString(1, "%");
            }
            preparedStatementPrepareMetaDataSafeStatement.setString(2, str3);
            preparedStatementPrepareMetaDataSafeStatement.setString(3, str4);
            ResultSet resultSetExecuteMetadataQuery = executeMetadataQuery(preparedStatementPrepareMetaDataSafeStatement);
            ((ResultSetInternalMethods) resultSetExecuteMetadataQuery).redefineFieldsForDBMD(createProcedureColumnsFields());
            return resultSetExecuteMetadataQuery;
        } finally {
            if (preparedStatementPrepareMetaDataSafeStatement != null) {
                preparedStatementPrepareMetaDataSafeStatement.close();
            }
        }
    }

    public ResultSet getProcedureColumnsNoISParametersView(String str, String str2, String str3, String str4) throws SQLException {
        return super.getProcedureColumns(str, str2, str3, str4);
    }

    @Override // com.mysql.jdbc.DatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getProcedures(String str, String str2, String str3) throws SQLException {
        if (str3 == null || str3.length() == 0) {
            if (!this.conn.getNullNamePatternMatchesAll()) {
                throw SQLError.createSQLException("Procedure name pattern can not be NULL or empty.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            str3 = "%";
        }
        java.sql.PreparedStatement preparedStatementPrepareMetaDataSafeStatement = null;
        if (str == null) {
            str = this.conn.getNullCatalogMeansCurrent() ? this.database : null;
        }
        try {
            preparedStatementPrepareMetaDataSafeStatement = prepareMetaDataSafeStatement("SELECT ROUTINE_SCHEMA AS PROCEDURE_CAT, NULL AS PROCEDURE_SCHEM, ROUTINE_NAME AS PROCEDURE_NAME, NULL AS RESERVED_1, NULL AS RESERVED_2, NULL AS RESERVED_3, ROUTINE_COMMENT AS REMARKS, CASE WHEN ROUTINE_TYPE = 'PROCEDURE' THEN 1 WHEN ROUTINE_TYPE='FUNCTION' THEN 2 ELSE 0 END AS PROCEDURE_TYPE, ROUTINE_NAME AS SPECIFIC_NAME FROM INFORMATION_SCHEMA.ROUTINES WHERE " + getRoutineTypeConditionForGetProcedures() + "ROUTINE_SCHEMA LIKE ? AND ROUTINE_NAME LIKE ? ORDER BY ROUTINE_SCHEMA, ROUTINE_NAME, ROUTINE_TYPE");
            if (str != null) {
                preparedStatementPrepareMetaDataSafeStatement.setString(1, str);
            } else {
                preparedStatementPrepareMetaDataSafeStatement.setString(1, "%");
            }
            preparedStatementPrepareMetaDataSafeStatement.setString(2, str3);
            ResultSet resultSetExecuteMetadataQuery = executeMetadataQuery(preparedStatementPrepareMetaDataSafeStatement);
            ((ResultSetInternalMethods) resultSetExecuteMetadataQuery).redefineFieldsForDBMD(createFieldMetadataForGetProcedures());
            return resultSetExecuteMetadataQuery;
        } finally {
            if (preparedStatementPrepareMetaDataSafeStatement != null) {
                preparedStatementPrepareMetaDataSafeStatement.close();
            }
        }
    }

    public String getRoutineTypeConditionForGetProcedureColumns() {
        return BuildConfig.FLAVOR;
    }

    public String getRoutineTypeConditionForGetProcedures() {
        return BuildConfig.FLAVOR;
    }

    @Override // com.mysql.jdbc.DatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getTables(String str, String str2, String str3, String[] strArr) throws SQLException {
        String str4;
        String str5;
        if (str == null && this.conn.getNullCatalogMeansCurrent()) {
            str = this.database;
        }
        if (str3 == null) {
            if (!this.conn.getNullNamePatternMatchesAll()) {
                throw SQLError.createSQLException("Table name pattern can not be NULL or empty.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            str3 = "%";
        }
        List<String> listSplitDBdotName = StringUtils.splitDBdotName(str3, (str == null || str.length() == 0) ? this.conn.getNullCatalogMeansCurrent() ? this.database : BuildConfig.FLAVOR : str, this.quotedId, this.conn.isNoBackslashEscapesSet());
        if (listSplitDBdotName.size() == 2) {
            str3 = listSplitDBdotName.get(1);
        }
        java.sql.PreparedStatement preparedStatementPrepareMetaDataSafeStatement = null;
        boolean zEqualsIgnoreCase = "information_schema".equalsIgnoreCase(str);
        int i = 0;
        if (str == null) {
            str4 = "SELECT TABLE_SCHEMA AS TABLE_CAT, NULL AS TABLE_SCHEM, TABLE_NAME, CASE WHEN TABLE_TYPE='BASE TABLE' THEN CASE WHEN TABLE_SCHEMA = 'mysql' OR TABLE_SCHEMA = 'performance_schema' THEN 'SYSTEM TABLE' ELSE 'TABLE' END WHEN TABLE_TYPE='TEMPORARY' THEN 'LOCAL_TEMPORARY' ELSE TABLE_TYPE END AS TABLE_TYPE, TABLE_COMMENT AS REMARKS, NULL AS TYPE_CAT, NULL AS TYPE_SCHEM, NULL AS TYPE_NAME, NULL AS SELF_REFERENCING_COL_NAME, NULL AS REF_GENERATION FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA LIKE ? ";
        } else if (zEqualsIgnoreCase || (StringUtils.indexOfIgnoreCase(0, str, "%") == -1 && StringUtils.indexOfIgnoreCase(0, str, "_") == -1)) {
            str4 = "SELECT TABLE_SCHEMA AS TABLE_CAT, NULL AS TABLE_SCHEM, TABLE_NAME, CASE WHEN TABLE_TYPE='BASE TABLE' THEN CASE WHEN TABLE_SCHEMA = 'mysql' OR TABLE_SCHEMA = 'performance_schema' THEN 'SYSTEM TABLE' ELSE 'TABLE' END WHEN TABLE_TYPE='TEMPORARY' THEN 'LOCAL_TEMPORARY' ELSE TABLE_TYPE END AS TABLE_TYPE, TABLE_COMMENT AS REMARKS, NULL AS TYPE_CAT, NULL AS TYPE_SCHEM, NULL AS TYPE_NAME, NULL AS SELF_REFERENCING_COL_NAME, NULL AS REF_GENERATION FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = ? ";
        } else {
            str4 = "SELECT TABLE_SCHEMA AS TABLE_CAT, NULL AS TABLE_SCHEM, TABLE_NAME, CASE WHEN TABLE_TYPE='BASE TABLE' THEN CASE WHEN TABLE_SCHEMA = 'mysql' OR TABLE_SCHEMA = 'performance_schema' THEN 'SYSTEM TABLE' ELSE 'TABLE' END WHEN TABLE_TYPE='TEMPORARY' THEN 'LOCAL_TEMPORARY' ELSE TABLE_TYPE END AS TABLE_TYPE, TABLE_COMMENT AS REMARKS, NULL AS TYPE_CAT, NULL AS TYPE_SCHEM, NULL AS TYPE_NAME, NULL AS SELF_REFERENCING_COL_NAME, NULL AS REF_GENERATION FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA LIKE ? ";
        }
        if (str3 == null) {
            str5 = str4 + "AND TABLE_NAME LIKE ? ";
        } else if (StringUtils.indexOfIgnoreCase(0, str3, "%") == -1 && StringUtils.indexOfIgnoreCase(0, str3, "_") == -1) {
            str5 = str4 + "AND TABLE_NAME = ? ";
        } else {
            str5 = str4 + "AND TABLE_NAME LIKE ? ";
        }
        try {
            preparedStatementPrepareMetaDataSafeStatement = prepareMetaDataSafeStatement((str5 + "HAVING TABLE_TYPE IN (?,?,?,?,?) ") + "ORDER BY TABLE_TYPE, TABLE_SCHEMA, TABLE_NAME");
            if (str != null) {
                preparedStatementPrepareMetaDataSafeStatement.setString(1, str);
            } else {
                preparedStatementPrepareMetaDataSafeStatement.setString(1, "%");
            }
            preparedStatementPrepareMetaDataSafeStatement.setString(2, str3);
            if (strArr == null || strArr.length == 0) {
                DatabaseMetaData.TableType[] tableTypeArrValues = DatabaseMetaData.TableType.values();
                while (i < 5) {
                    preparedStatementPrepareMetaDataSafeStatement.setString(i + 3, tableTypeArrValues[i].getName());
                    i++;
                }
            } else {
                for (int i2 = 0; i2 < 5; i2++) {
                    preparedStatementPrepareMetaDataSafeStatement.setNull(i2 + 3, 12);
                }
                int i3 = 3;
                while (i < strArr.length) {
                    DatabaseMetaData.TableType tableTypeEqualTo = DatabaseMetaData.TableType.getTableTypeEqualTo(strArr[i]);
                    if (tableTypeEqualTo != DatabaseMetaData.TableType.UNKNOWN) {
                        preparedStatementPrepareMetaDataSafeStatement.setString(i3, tableTypeEqualTo.getName());
                        i3++;
                    }
                    i++;
                }
            }
            ResultSet resultSetExecuteMetadataQuery = executeMetadataQuery(preparedStatementPrepareMetaDataSafeStatement);
            ((ResultSetInternalMethods) resultSetExecuteMetadataQuery).redefineFieldsForDBMD(createTablesFields());
            return resultSetExecuteMetadataQuery;
        } finally {
            if (preparedStatementPrepareMetaDataSafeStatement != null) {
                preparedStatementPrepareMetaDataSafeStatement.close();
            }
        }
    }

    @Override // com.mysql.jdbc.DatabaseMetaData, java.sql.DatabaseMetaData
    public ResultSet getVersionColumns(String str, String str2, String str3) throws SQLException {
        if (str == null && this.conn.getNullCatalogMeansCurrent()) {
            str = this.database;
        }
        if (str3 == null) {
            throw SQLError.createSQLException("Table not specified.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
        StringBuilder sb = new StringBuilder("SELECT NULL AS SCOPE, COLUMN_NAME, ");
        MysqlDefs.appendJdbcTypeMappingQuery(sb, "DATA_TYPE");
        sb.append(" AS DATA_TYPE, ");
        sb.append("COLUMN_TYPE AS TYPE_NAME, ");
        sb.append("CASE WHEN LCASE(DATA_TYPE)='date' THEN 10 WHEN LCASE(DATA_TYPE)='time' THEN 8 WHEN LCASE(DATA_TYPE)='datetime' THEN 19 WHEN LCASE(DATA_TYPE)='timestamp' THEN 19 WHEN CHARACTER_MAXIMUM_LENGTH IS NULL THEN NUMERIC_PRECISION WHEN CHARACTER_MAXIMUM_LENGTH > 2147483647 THEN 2147483647 ELSE CHARACTER_MAXIMUM_LENGTH END AS COLUMN_SIZE, ");
        sb.append(MysqlIO.getMaxBuf() + " AS BUFFER_LENGTH,NUMERIC_SCALE AS DECIMAL_DIGITS, " + Integer.toString(1) + " AS PSEUDO_COLUMN FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA LIKE ? AND TABLE_NAME LIKE ? AND EXTRA LIKE '%on update CURRENT_TIMESTAMP%'");
        java.sql.PreparedStatement preparedStatementPrepareMetaDataSafeStatement = null;
        try {
            preparedStatementPrepareMetaDataSafeStatement = prepareMetaDataSafeStatement(sb.toString());
            if (str != null) {
                preparedStatementPrepareMetaDataSafeStatement.setString(1, str);
            } else {
                preparedStatementPrepareMetaDataSafeStatement.setString(1, "%");
            }
            preparedStatementPrepareMetaDataSafeStatement.setString(2, str3);
            ResultSet resultSetExecuteMetadataQuery = executeMetadataQuery(preparedStatementPrepareMetaDataSafeStatement);
            ((ResultSetInternalMethods) resultSetExecuteMetadataQuery).redefineFieldsForDBMD(new Field[]{new Field(BuildConfig.FLAVOR, "SCOPE", 5, 5), new Field(BuildConfig.FLAVOR, "COLUMN_NAME", 1, 32), new Field(BuildConfig.FLAVOR, "DATA_TYPE", 4, 5), new Field(BuildConfig.FLAVOR, "TYPE_NAME", 1, 16), new Field(BuildConfig.FLAVOR, "COLUMN_SIZE", 4, 16), new Field(BuildConfig.FLAVOR, "BUFFER_LENGTH", 4, 16), new Field(BuildConfig.FLAVOR, "DECIMAL_DIGITS", 5, 16), new Field(BuildConfig.FLAVOR, "PSEUDO_COLUMN", 5, 5)});
            return resultSetExecuteMetadataQuery;
        } finally {
            if (preparedStatementPrepareMetaDataSafeStatement != null) {
                preparedStatementPrepareMetaDataSafeStatement.close();
            }
        }
    }

    public boolean gethasParametersView() {
        return this.hasParametersView;
    }
}
