package com.mysql.jdbc;

import com.google.android.flexbox.BuildConfig;
import com.sun.mail.pop3.POP3Message;
import java.sql.SQLException;

/* JADX INFO: loaded from: classes.dex */
public class ResultSetMetaData implements java.sql.ResultSetMetaData {
    private ExceptionInterceptor exceptionInterceptor;
    public Field[] fields;
    public boolean treatYearAsDate;
    public boolean useOldAliasBehavior;

    public ResultSetMetaData(Field[] fieldArr, boolean z, boolean z2, ExceptionInterceptor exceptionInterceptor) {
        this.useOldAliasBehavior = false;
        this.treatYearAsDate = true;
        this.fields = fieldArr;
        this.useOldAliasBehavior = z;
        this.treatYearAsDate = z2;
        this.exceptionInterceptor = exceptionInterceptor;
    }

    private static int clampedGetLength(Field field) {
        long length = field.getLength();
        if (length > 2147483647L) {
            length = 2147483647L;
        }
        return (int) length;
    }

    public static String getClassNameForJavaType(int i, boolean z, int i2, boolean z2, boolean z3, boolean z4) {
        if (i != 12) {
            if (i == 16) {
                return "java.lang.Boolean";
            }
            switch (i) {
                case -7:
                    return "java.lang.Boolean";
                case -6:
                    if (z) {
                    }
                    return "java.lang.Integer";
                case -5:
                    return !z ? "java.lang.Long" : "java.math.BigInteger";
                case -4:
                case -3:
                case -2:
                    return (i2 == 255 || z2) ? "[B" : "java.lang.String";
                case -1:
                    break;
                default:
                    switch (i) {
                        case 1:
                            break;
                        case 2:
                        case 3:
                            return "java.math.BigDecimal";
                        case 4:
                            return (!z || i2 == 9) ? "java.lang.Integer" : "java.lang.Long";
                        case 5:
                            if (z) {
                            }
                            return "java.lang.Integer";
                        case 6:
                        case 8:
                            return "java.lang.Double";
                        case 7:
                            return "java.lang.Float";
                        default:
                            switch (i) {
                                case 91:
                                    return (z4 || i2 != 13) ? "java.sql.Date" : "java.lang.Short";
                                case 92:
                                    return "java.sql.Time";
                                case 93:
                                    return "java.sql.Timestamp";
                                default:
                                    return "java.lang.Object";
                            }
                    }
                    break;
            }
        }
        return !z3 ? "java.lang.String" : "[B";
    }

    private static final boolean isDecimalType(int i) {
        if (i == -7 || i == -6 || i == -5) {
            return true;
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    @Override // java.sql.ResultSetMetaData
    public String getCatalogName(int i) throws SQLException {
        String databaseName = getField(i).getDatabaseName();
        return databaseName == null ? BuildConfig.FLAVOR : databaseName;
    }

    public String getColumnCharacterEncoding(int i) throws SQLException {
        String columnCharacterSet = getColumnCharacterSet(i);
        if (columnCharacterSet == null) {
            return null;
        }
        try {
            return CharsetMapping.getJavaEncodingForMysqlCharset(columnCharacterSet);
        } catch (RuntimeException e) {
            SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(e.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
            sQLExceptionCreateSQLException.initCause(e);
            throw sQLExceptionCreateSQLException;
        }
    }

    public String getColumnCharacterSet(int i) throws SQLException {
        return getField(i).getEncoding();
    }

    @Override // java.sql.ResultSetMetaData
    public String getColumnClassName(int i) throws SQLException {
        Field field = getField(i);
        return getClassNameForJavaType(field.getSQLType(), field.isUnsigned(), field.getMysqlType(), field.isBinary() || field.isBlob(), field.isOpaqueBinary(), this.treatYearAsDate);
    }

    @Override // java.sql.ResultSetMetaData
    public int getColumnCount() throws SQLException {
        return this.fields.length;
    }

    @Override // java.sql.ResultSetMetaData
    public int getColumnDisplaySize(int i) throws SQLException {
        Field field = getField(i);
        return clampedGetLength(field) / field.getMaxBytesPerCharacter();
    }

    @Override // java.sql.ResultSetMetaData
    public String getColumnLabel(int i) throws SQLException {
        return this.useOldAliasBehavior ? getColumnName(i) : getField(i).getColumnLabel();
    }

    @Override // java.sql.ResultSetMetaData
    public String getColumnName(int i) throws SQLException {
        if (this.useOldAliasBehavior) {
            return getField(i).getName();
        }
        String nameNoAliases = getField(i).getNameNoAliases();
        return (nameNoAliases == null || nameNoAliases.length() != 0) ? nameNoAliases : getField(i).getName();
    }

    @Override // java.sql.ResultSetMetaData
    public int getColumnType(int i) throws SQLException {
        return getField(i).getSQLType();
    }

    @Override // java.sql.ResultSetMetaData
    public String getColumnTypeName(int i) throws SQLException {
        Field field = getField(i);
        int mysqlType = field.getMysqlType();
        int sQLType = field.getSQLType();
        if (mysqlType == 15) {
            return "VARCHAR";
        }
        if (mysqlType == 16) {
            return "BIT";
        }
        switch (mysqlType) {
            case 0:
                break;
            case 1:
                return field.isUnsigned() ? "TINYINT UNSIGNED" : "TINYINT";
            case 2:
                return field.isUnsigned() ? "SMALLINT UNSIGNED" : "SMALLINT";
            case 3:
                return field.isUnsigned() ? "INT UNSIGNED" : "INT";
            case 4:
                return field.isUnsigned() ? "FLOAT UNSIGNED" : "FLOAT";
            case 5:
                return field.isUnsigned() ? "DOUBLE UNSIGNED" : "DOUBLE";
            case 6:
                return "NULL";
            case 7:
                return "TIMESTAMP";
            case 8:
                return field.isUnsigned() ? "BIGINT UNSIGNED" : "BIGINT";
            case 9:
                return field.isUnsigned() ? "MEDIUMINT UNSIGNED" : "MEDIUMINT";
            case 10:
                return "DATE";
            case 11:
                return "TIME";
            case 12:
                return "DATETIME";
            case 13:
                return "YEAR";
            default:
                switch (mysqlType) {
                    case MysqlDefs.FIELD_TYPE_JSON /* 245 */:
                        return "JSON";
                    case MysqlDefs.FIELD_TYPE_NEW_DECIMAL /* 246 */:
                        break;
                    case MysqlDefs.FIELD_TYPE_ENUM /* 247 */:
                        return "ENUM";
                    case MysqlDefs.FIELD_TYPE_SET /* 248 */:
                        return "SET";
                    case MysqlDefs.FIELD_TYPE_TINY_BLOB /* 249 */:
                        return "TINYBLOB";
                    case 250:
                        return "MEDIUMBLOB";
                    case MysqlDefs.FIELD_TYPE_LONG_BLOB /* 251 */:
                        return "LONGBLOB";
                    case MysqlDefs.FIELD_TYPE_BLOB /* 252 */:
                        return getField(i).isBinary() ? "BLOB" : "TEXT";
                    case MysqlDefs.FIELD_TYPE_VAR_STRING /* 253 */:
                        return sQLType == -3 ? "VARBINARY" : "VARCHAR";
                    case MysqlDefs.FIELD_TYPE_STRING /* 254 */:
                        return sQLType == -2 ? "BINARY" : "CHAR";
                    case 255:
                        return "GEOMETRY";
                    default:
                        return POP3Message.UNKNOWN;
                }
                break;
        }
        return field.isUnsigned() ? "DECIMAL UNSIGNED" : "DECIMAL";
    }

    public Field getField(int i) throws SQLException {
        if (i >= 1) {
            Field[] fieldArr = this.fields;
            if (i <= fieldArr.length) {
                return fieldArr[i - 1];
            }
        }
        throw SQLError.createSQLException(Messages.getString("ResultSetMetaData.46"), SQLError.SQL_STATE_INVALID_COLUMN_NUMBER, this.exceptionInterceptor);
    }

    @Override // java.sql.ResultSetMetaData
    public int getPrecision(int i) throws SQLException {
        Field field = getField(i);
        if (isDecimalType(field.getSQLType())) {
            return field.getDecimals() > 0 ? (clampedGetLength(field) - 1) + field.getPrecisionAdjustFactor() : clampedGetLength(field) + field.getPrecisionAdjustFactor();
        }
        switch (field.getMysqlType()) {
            case MysqlDefs.FIELD_TYPE_TINY_BLOB /* 249 */:
            case 250:
            case MysqlDefs.FIELD_TYPE_LONG_BLOB /* 251 */:
            case MysqlDefs.FIELD_TYPE_BLOB /* 252 */:
                return clampedGetLength(field);
            default:
                return clampedGetLength(field) / field.getMaxBytesPerCharacter();
        }
    }

    @Override // java.sql.ResultSetMetaData
    public int getScale(int i) throws SQLException {
        Field field = getField(i);
        if (isDecimalType(field.getSQLType())) {
            return field.getDecimals();
        }
        return 0;
    }

    @Override // java.sql.ResultSetMetaData
    public String getSchemaName(int i) throws SQLException {
        return BuildConfig.FLAVOR;
    }

    @Override // java.sql.ResultSetMetaData
    public String getTableName(int i) throws SQLException {
        return this.useOldAliasBehavior ? getField(i).getTableName() : getField(i).getTableNameNoAliases();
    }

    @Override // java.sql.ResultSetMetaData
    public boolean isAutoIncrement(int i) throws SQLException {
        return getField(i).isAutoIncrement();
    }

    @Override // java.sql.ResultSetMetaData
    public boolean isCaseSensitive(int i) throws SQLException {
        Field field = getField(i);
        int sQLType = field.getSQLType();
        if (sQLType == -7 || sQLType == -6 || sQLType == -5) {
            return false;
        }
        if (sQLType == -1 || sQLType == 1 || sQLType == 12) {
            if (field.isBinary()) {
                return true;
            }
            String collation = field.getCollation();
            return (collation == null || collation.endsWith("_ci")) ? false : true;
        }
        switch (sQLType) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return false;
            default:
                switch (sQLType) {
                    case 91:
                    case 92:
                    case 93:
                        return false;
                    default:
                        return true;
                }
        }
    }

    @Override // java.sql.ResultSetMetaData
    public boolean isCurrency(int i) throws SQLException {
        return false;
    }

    @Override // java.sql.ResultSetMetaData
    public boolean isDefinitelyWritable(int i) throws SQLException {
        return isWritable(i);
    }

    @Override // java.sql.ResultSetMetaData
    public int isNullable(int i) throws SQLException {
        return !getField(i).isNotNull() ? 1 : 0;
    }

    @Override // java.sql.ResultSetMetaData
    public boolean isReadOnly(int i) throws SQLException {
        return getField(i).isReadOnly();
    }

    @Override // java.sql.ResultSetMetaData
    public boolean isSearchable(int i) throws SQLException {
        return true;
    }

    @Override // java.sql.ResultSetMetaData
    public boolean isSigned(int i) throws SQLException {
        Field field = getField(i);
        int sQLType = field.getSQLType();
        if (sQLType != -6 && sQLType != -5) {
            switch (sQLType) {
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    return false;
            }
        }
        return !field.isUnsigned();
    }

    @Override // java.sql.Wrapper
    public boolean isWrapperFor(Class<?> cls) throws SQLException {
        return cls.isInstance(this);
    }

    @Override // java.sql.ResultSetMetaData
    public boolean isWritable(int i) throws SQLException {
        return !isReadOnly(i);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" - Field level information: ");
        for (int i = 0; i < this.fields.length; i++) {
            sb.append("\n\t");
            sb.append(this.fields[i].toString());
        }
        return sb.toString();
    }

    @Override // java.sql.Wrapper
    public <T> T unwrap(Class<T> cls) throws SQLException {
        try {
            return cls.cast(this);
        } catch (ClassCastException unused) {
            throw SQLError.createSQLException("Unable to unwrap to " + cls.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        }
    }
}
