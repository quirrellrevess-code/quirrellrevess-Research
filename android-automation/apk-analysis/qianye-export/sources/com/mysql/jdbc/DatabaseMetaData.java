package com.mysql.jdbc;

import com.google.android.flexbox.BuildConfig;
import com.sun.mail.pop3.POP3Message;
import java.lang.reflect.Constructor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.http2.Settings;

/* JADX INFO: loaded from: classes.dex */
public class DatabaseMetaData implements java.sql.DatabaseMetaData {
    private static final int DEFERRABILITY = 13;
    private static final int DELETE_RULE = 10;
    private static final int FKCOLUMN_NAME = 7;
    private static final int FKTABLE_CAT = 4;
    private static final int FKTABLE_NAME = 6;
    private static final int FKTABLE_SCHEM = 5;
    private static final int FK_NAME = 11;
    private static final Constructor<?> JDBC_4_DBMD_IS_CTOR;
    private static final Constructor<?> JDBC_4_DBMD_SHOW_CTOR;
    private static final int KEY_SEQ = 8;
    public static final int MAX_IDENTIFIER_LENGTH = 64;
    private static final String[] MYSQL_KEYWORDS;
    private static final int PKCOLUMN_NAME = 3;
    private static final int PKTABLE_CAT = 0;
    private static final int PKTABLE_NAME = 2;
    private static final int PKTABLE_SCHEM = 1;
    private static final int PK_NAME = 12;
    private static final String[] SQL2003_KEYWORDS;
    private static final String[] SQL92_KEYWORDS;
    private static final String SUPPORTS_FK = "SUPPORTS_FK";
    private static final int UPDATE_RULE = 9;
    private static volatile String mysqlKeywords;
    public MySQLConnection conn;
    public String database;
    private ExceptionInterceptor exceptionInterceptor;
    public final String quotedId;
    public static final byte[] TABLE_AS_BYTES = "TABLE".getBytes();
    public static final byte[] SYSTEM_TABLE_AS_BYTES = "SYSTEM TABLE".getBytes();
    public static final byte[] VIEW_AS_BYTES = "VIEW".getBytes();

    /* JADX INFO: renamed from: com.mysql.jdbc.DatabaseMetaData$11 */
    public static /* synthetic */ class C028411 {
        public static final /* synthetic */ int[] $SwitchMap$com$mysql$jdbc$DatabaseMetaData$TableType;

        static {
            int[] iArr = new int[TableType.values().length];
            $SwitchMap$com$mysql$jdbc$DatabaseMetaData$TableType = iArr;
            try {
                iArr[TableType.TABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$mysql$jdbc$DatabaseMetaData$TableType[TableType.VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$mysql$jdbc$DatabaseMetaData$TableType[TableType.SYSTEM_TABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$mysql$jdbc$DatabaseMetaData$TableType[TableType.SYSTEM_VIEW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$mysql$jdbc$DatabaseMetaData$TableType[TableType.LOCAL_TEMPORARY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public class ComparableWrapper<K extends Comparable<? super K>, V> implements Comparable<ComparableWrapper<K, V>> {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public K key;
        public V value;

        public ComparableWrapper(K k, V v) {
            this.key = k;
            this.value = v;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ComparableWrapper)) {
                return false;
            }
            return this.key.equals(((ComparableWrapper) obj).getKey());
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public int hashCode() {
            return 0;
        }

        public String toString() {
            return "{KEY:" + this.key + "; VALUE:" + this.value + "}";
        }

        @Override // java.lang.Comparable
        public int compareTo(ComparableWrapper<K, V> comparableWrapper) {
            return ((Comparable) getKey()).compareTo(comparableWrapper.getKey());
        }
    }

    public class IndexMetaDataKey implements Comparable<IndexMetaDataKey> {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public String columnIndexName;
        public Boolean columnNonUnique;
        public Short columnOrdinalPosition;
        public Short columnType;

        public IndexMetaDataKey(boolean z, short s, String str, short s2) {
            this.columnNonUnique = Boolean.valueOf(z);
            this.columnType = Short.valueOf(s);
            this.columnIndexName = str;
            this.columnOrdinalPosition = Short.valueOf(s2);
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            return (obj instanceof IndexMetaDataKey) && compareTo((IndexMetaDataKey) obj) == 0;
        }

        public int hashCode() {
            return 0;
        }

        @Override // java.lang.Comparable
        public int compareTo(IndexMetaDataKey indexMetaDataKey) {
            int iCompareTo = this.columnNonUnique.compareTo(indexMetaDataKey.columnNonUnique);
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            int iCompareTo2 = this.columnType.compareTo(indexMetaDataKey.columnType);
            if (iCompareTo2 != 0) {
                return iCompareTo2;
            }
            int iCompareTo3 = this.columnIndexName.compareTo(indexMetaDataKey.columnIndexName);
            return iCompareTo3 != 0 ? iCompareTo3 : this.columnOrdinalPosition.compareTo(indexMetaDataKey.columnOrdinalPosition);
        }
    }

    public abstract class IteratorWithCleanup<T> {
        public IteratorWithCleanup() {
        }

        public abstract void close() throws SQLException;

        public abstract boolean hasNext() throws SQLException;

        public abstract T next() throws SQLException;
    }

    public class LocalAndReferencedColumns {
        public String constraintName;
        public List<String> localColumnsList;
        public String referencedCatalog;
        public List<String> referencedColumnsList;
        public String referencedTable;

        public LocalAndReferencedColumns(List<String> list, List<String> list2, String str, String str2, String str3) {
            this.localColumnsList = list;
            this.referencedColumnsList = list2;
            this.constraintName = str;
            this.referencedTable = str3;
            this.referencedCatalog = str2;
        }
    }

    public enum ProcedureType {
        PROCEDURE,
        FUNCTION
    }

    public class ResultSetIterator extends IteratorWithCleanup<String> {
        public int colIndex;
        public ResultSet resultSet;

        public ResultSetIterator(ResultSet resultSet, int i) {
            super();
            this.resultSet = resultSet;
            this.colIndex = i;
        }

        @Override // com.mysql.jdbc.DatabaseMetaData.IteratorWithCleanup
        public void close() throws SQLException {
            this.resultSet.close();
        }

        @Override // com.mysql.jdbc.DatabaseMetaData.IteratorWithCleanup
        public boolean hasNext() throws SQLException {
            return this.resultSet.next();
        }

        @Override // com.mysql.jdbc.DatabaseMetaData.IteratorWithCleanup
        public String next() throws SQLException {
            return this.resultSet.getObject(this.colIndex).toString();
        }
    }

    public class SingleStringIterator extends IteratorWithCleanup<String> {
        public boolean onFirst;
        public String value;

        public SingleStringIterator(String str) {
            super();
            this.onFirst = true;
            this.value = str;
        }

        @Override // com.mysql.jdbc.DatabaseMetaData.IteratorWithCleanup
        public void close() throws SQLException {
        }

        @Override // com.mysql.jdbc.DatabaseMetaData.IteratorWithCleanup
        public boolean hasNext() throws SQLException {
            return this.onFirst;
        }

        @Override // com.mysql.jdbc.DatabaseMetaData.IteratorWithCleanup
        public String next() throws SQLException {
            this.onFirst = false;
            return this.value;
        }
    }

    public class TableMetaDataKey implements Comparable<TableMetaDataKey> {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public String tableCat;
        public String tableName;
        public String tableSchem;
        public String tableType;

        public TableMetaDataKey(String str, String str2, String str3, String str4) {
            this.tableType = str == null ? BuildConfig.FLAVOR : str;
            this.tableCat = str2 == null ? BuildConfig.FLAVOR : str2;
            this.tableSchem = str3 == null ? BuildConfig.FLAVOR : str3;
            this.tableName = str4 == null ? BuildConfig.FLAVOR : str4;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            return (obj instanceof TableMetaDataKey) && compareTo((TableMetaDataKey) obj) == 0;
        }

        public int hashCode() {
            return 0;
        }

        @Override // java.lang.Comparable
        public int compareTo(TableMetaDataKey tableMetaDataKey) {
            int iCompareTo = this.tableType.compareTo(tableMetaDataKey.tableType);
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            int iCompareTo2 = this.tableCat.compareTo(tableMetaDataKey.tableCat);
            if (iCompareTo2 != 0) {
                return iCompareTo2;
            }
            int iCompareTo3 = this.tableSchem.compareTo(tableMetaDataKey.tableSchem);
            return iCompareTo3 != 0 ? iCompareTo3 : this.tableName.compareTo(tableMetaDataKey.tableName);
        }
    }

    public enum TableType {
        LOCAL_TEMPORARY("LOCAL TEMPORARY"),
        SYSTEM_TABLE("SYSTEM TABLE"),
        SYSTEM_VIEW("SYSTEM VIEW"),
        TABLE("TABLE", new String[]{"BASE TABLE"}),
        VIEW("VIEW"),
        UNKNOWN(POP3Message.UNKNOWN);

        private String name;
        private byte[] nameAsBytes;
        private String[] synonyms;

        TableType(String str) {
            this(str, null);
        }

        public static TableType getTableTypeCompliantWith(String str) {
            for (TableType tableType : values()) {
                if (tableType.compliesWith(str)) {
                    return tableType;
                }
            }
            return UNKNOWN;
        }

        public static TableType getTableTypeEqualTo(String str) {
            for (TableType tableType : values()) {
                if (tableType.equalsTo(str)) {
                    return tableType;
                }
            }
            return UNKNOWN;
        }

        public byte[] asBytes() {
            return this.nameAsBytes;
        }

        public boolean compliesWith(String str) {
            if (equalsTo(str)) {
                return true;
            }
            String[] strArr = this.synonyms;
            if (strArr != null) {
                for (String str2 : strArr) {
                    if (str2.equalsIgnoreCase(str)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean equalsTo(String str) {
            return this.name.equalsIgnoreCase(str);
        }

        public String getName() {
            return this.name;
        }

        TableType(String str, String[] strArr) {
            this.name = str;
            this.nameAsBytes = str.getBytes();
            this.synonyms = strArr;
        }
    }

    public class TypeDescriptor {
        public int bufferLength;
        public int charOctetLength;
        public Integer columnSize;
        public short dataType;
        public Integer decimalDigits;
        public String isNullable;
        public int nullability;
        public int numPrecRadix;
        public String typeName;

        public TypeDescriptor(String str, String str2) throws SQLException {
            String upperCase;
            boolean z;
            this.numPrecRadix = 10;
            if (str == null) {
                throw SQLError.createSQLException("NULL typeinfo not supported.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, DatabaseMetaData.this.getExceptionInterceptor());
            }
            String strTrim = str.indexOf("(") != -1 ? str.substring(0, str.indexOf("(")).trim() : str;
            int iIndexOfIgnoreCase = StringUtils.indexOfIgnoreCase(strTrim, "unsigned");
            strTrim = iIndexOfIgnoreCase != -1 ? strTrim.substring(0, iIndexOfIgnoreCase - 1) : strTrim;
            if (StringUtils.indexOfIgnoreCase(str, "unsigned") == -1 || StringUtils.indexOfIgnoreCase(str, "set") == 0 || StringUtils.indexOfIgnoreCase(str, "enum") == 0) {
                upperCase = strTrim;
                z = false;
            } else {
                upperCase = strTrim + " unsigned";
                z = true;
            }
            upperCase = DatabaseMetaData.this.conn.getCapitalizeTypeNames() ? upperCase.toUpperCase(Locale.ENGLISH) : upperCase;
            this.dataType = (short) MysqlDefs.mysqlToJavaType(strTrim);
            this.typeName = upperCase;
            if (StringUtils.startsWithIgnoreCase(str, "enum")) {
                StringTokenizer stringTokenizer = new StringTokenizer(str.substring(str.indexOf("("), str.lastIndexOf(")")), ",");
                int iMax = 0;
                while (stringTokenizer.hasMoreTokens()) {
                    iMax = Math.max(iMax, stringTokenizer.nextToken().length() - 2);
                }
                this.columnSize = Integer.valueOf(iMax);
                this.decimalDigits = null;
            } else if (StringUtils.startsWithIgnoreCase(str, "set")) {
                StringTokenizer stringTokenizer2 = new StringTokenizer(str.substring(str.indexOf("(") + 1, str.lastIndexOf(")")), ",");
                int iCountTokens = stringTokenizer2.countTokens();
                int length = iCountTokens > 0 ? (iCountTokens - 1) + 0 : 0;
                while (stringTokenizer2.hasMoreTokens()) {
                    String strTrim2 = stringTokenizer2.nextToken().trim();
                    length += (strTrim2.startsWith("'") && strTrim2.endsWith("'")) ? strTrim2.length() - 2 : strTrim2.length();
                }
                this.columnSize = Integer.valueOf(length);
                this.decimalDigits = null;
            } else if (str.indexOf(",") != -1) {
                this.columnSize = Integer.valueOf(str.substring(str.indexOf("(") + 1, str.indexOf(",")).trim());
                this.decimalDigits = Integer.valueOf(str.substring(str.indexOf(",") + 1, str.indexOf(")")).trim());
            } else {
                this.columnSize = null;
                this.decimalDigits = null;
                if ((StringUtils.indexOfIgnoreCase(str, "char") != -1 || StringUtils.indexOfIgnoreCase(str, "text") != -1 || StringUtils.indexOfIgnoreCase(str, "blob") != -1 || StringUtils.indexOfIgnoreCase(str, "binary") != -1 || StringUtils.indexOfIgnoreCase(str, "bit") != -1) && str.indexOf("(") != -1) {
                    int iIndexOf = str.indexOf(")");
                    this.columnSize = Integer.valueOf(str.substring(str.indexOf("(") + 1, iIndexOf == -1 ? str.length() : iIndexOf).trim());
                    if (DatabaseMetaData.this.conn.getTinyInt1isBit() && this.columnSize.intValue() == 1 && StringUtils.startsWithIgnoreCase(str, 0, "tinyint")) {
                        if (DatabaseMetaData.this.conn.getTransformedBitIsBoolean()) {
                            this.dataType = (short) 16;
                            this.typeName = "BOOLEAN";
                        } else {
                            this.dataType = (short) -7;
                            this.typeName = "BIT";
                        }
                    }
                } else if (StringUtils.startsWithIgnoreCaseAndWs(str, "tinyint")) {
                    if (!DatabaseMetaData.this.conn.getTinyInt1isBit() || str.indexOf("(1)") == -1) {
                        this.columnSize = 3;
                        this.decimalDigits = 0;
                    } else if (DatabaseMetaData.this.conn.getTransformedBitIsBoolean()) {
                        this.dataType = (short) 16;
                        this.typeName = "BOOLEAN";
                    } else {
                        this.dataType = (short) -7;
                        this.typeName = "BIT";
                    }
                } else if (StringUtils.startsWithIgnoreCaseAndWs(str, "smallint")) {
                    this.columnSize = 5;
                    this.decimalDigits = 0;
                } else if (StringUtils.startsWithIgnoreCaseAndWs(str, "mediumint")) {
                    this.columnSize = Integer.valueOf(z ? 8 : 7);
                    this.decimalDigits = 0;
                } else if (StringUtils.startsWithIgnoreCaseAndWs(str, "int") || StringUtils.startsWithIgnoreCaseAndWs(str, "integer")) {
                    this.columnSize = 10;
                    this.decimalDigits = 0;
                } else {
                    if (StringUtils.startsWithIgnoreCaseAndWs(str, "bigint")) {
                        this.columnSize = Integer.valueOf(z ? 20 : 19);
                        this.decimalDigits = 0;
                    } else if (StringUtils.startsWithIgnoreCaseAndWs(str, "int24")) {
                        this.columnSize = 19;
                        this.decimalDigits = 0;
                    } else if (StringUtils.startsWithIgnoreCaseAndWs(str, "real") || StringUtils.startsWithIgnoreCaseAndWs(str, "float") || StringUtils.startsWithIgnoreCaseAndWs(str, "decimal") || StringUtils.startsWithIgnoreCaseAndWs(str, "numeric")) {
                        this.columnSize = 12;
                    } else if (StringUtils.startsWithIgnoreCaseAndWs(str, "double")) {
                        this.columnSize = 22;
                    } else if (StringUtils.startsWithIgnoreCaseAndWs(str, "char")) {
                        this.columnSize = 1;
                    } else if (StringUtils.startsWithIgnoreCaseAndWs(str, "varchar")) {
                        this.columnSize = 255;
                    } else if (StringUtils.startsWithIgnoreCaseAndWs(str, "timestamp") || StringUtils.startsWithIgnoreCaseAndWs(str, "datetime")) {
                        this.columnSize = 19;
                    } else if (StringUtils.startsWithIgnoreCaseAndWs(str, "date")) {
                        this.columnSize = 10;
                    } else if (StringUtils.startsWithIgnoreCaseAndWs(str, "time")) {
                        this.columnSize = 8;
                    } else if (StringUtils.startsWithIgnoreCaseAndWs(str, "tinyblob")) {
                        this.columnSize = 255;
                    } else if (StringUtils.startsWithIgnoreCaseAndWs(str, "blob")) {
                        this.columnSize = Integer.valueOf(Settings.DEFAULT_INITIAL_WINDOW_SIZE);
                    } else if (StringUtils.startsWithIgnoreCaseAndWs(str, "mediumblob")) {
                        this.columnSize = 16777215;
                    } else if (StringUtils.startsWithIgnoreCaseAndWs(str, "longblob")) {
                        this.columnSize = Integer.MAX_VALUE;
                    } else if (StringUtils.startsWithIgnoreCaseAndWs(str, "tinytext")) {
                        this.columnSize = 255;
                    } else if (StringUtils.startsWithIgnoreCaseAndWs(str, "text")) {
                        this.columnSize = Integer.valueOf(Settings.DEFAULT_INITIAL_WINDOW_SIZE);
                    } else if (StringUtils.startsWithIgnoreCaseAndWs(str, "mediumtext")) {
                        this.columnSize = 16777215;
                    } else if (StringUtils.startsWithIgnoreCaseAndWs(str, "longtext")) {
                        this.columnSize = Integer.MAX_VALUE;
                    } else if (StringUtils.startsWithIgnoreCaseAndWs(str, "enum") || StringUtils.startsWithIgnoreCaseAndWs(str, "set")) {
                        this.columnSize = 255;
                    }
                }
            }
            this.bufferLength = MysqlIO.getMaxBuf();
            this.numPrecRadix = 10;
            if (str2 == null) {
                this.nullability = 0;
                this.isNullable = "NO";
            } else if (str2.equals("YES")) {
                this.nullability = 1;
                this.isNullable = "YES";
            } else if (str2.equals(POP3Message.UNKNOWN)) {
                this.nullability = 2;
                this.isNullable = BuildConfig.FLAVOR;
            } else {
                this.nullability = 0;
                this.isNullable = "NO";
            }
        }
    }

    static {
        if (Util.isJdbc4()) {
            try {
                JDBC_4_DBMD_SHOW_CTOR = Class.forName("com.mysql.jdbc.JDBC4DatabaseMetaData").getConstructor(MySQLConnection.class, String.class);
                JDBC_4_DBMD_IS_CTOR = Class.forName("com.mysql.jdbc.JDBC4DatabaseMetaDataUsingInfoSchema").getConstructor(MySQLConnection.class, String.class);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException(e2);
            } catch (SecurityException e3) {
                throw new RuntimeException(e3);
            }
        } else {
            JDBC_4_DBMD_IS_CTOR = null;
            JDBC_4_DBMD_SHOW_CTOR = null;
        }
        MYSQL_KEYWORDS = new String[]{"ACCESSIBLE", "ADD", "ALL", "ALTER", "ANALYZE", "AND", "AS", "ASC", "ASENSITIVE", "BEFORE", "BETWEEN", "BIGINT", "BINARY", "BLOB", "BOTH", "BY", "CALL", "CASCADE", "CASE", "CHANGE", "CHAR", "CHARACTER", "CHECK", "COLLATE", "COLUMN", "CONDITION", "CONSTRAINT", "CONTINUE", "CONVERT", "CREATE", "CROSS", "CURRENT_DATE", "CURRENT_TIME", "CURRENT_TIMESTAMP", "CURRENT_USER", "CURSOR", "DATABASE", "DATABASES", "DAY_HOUR", "DAY_MICROSECOND", "DAY_MINUTE", "DAY_SECOND", "DEC", "DECIMAL", "DECLARE", "DEFAULT", "DELAYED", "DELETE", "DESC", "DESCRIBE", "DETERMINISTIC", "DISTINCT", "DISTINCTROW", "DIV", "DOUBLE", "DROP", "DUAL", "EACH", "ELSE", "ELSEIF", "ENCLOSED", "ESCAPED", "EXISTS", "EXIT", "EXPLAIN", "FALSE", "FETCH", "FLOAT", "FLOAT4", "FLOAT8", "FOR", "FORCE", "FOREIGN", "FROM", "FULLTEXT", "GENERATED", "GET", "GRANT", "GROUP", "HAVING", "HIGH_PRIORITY", "HOUR_MICROSECOND", "HOUR_MINUTE", "HOUR_SECOND", "IF", "IGNORE", "IN", "INDEX", "INFILE", "INNER", "INOUT", "INSENSITIVE", "INSERT", "INT", "INT1", "INT2", "INT3", "INT4", "INT8", "INTEGER", "INTERVAL", "INTO", "IO_AFTER_GTIDS", "IO_BEFORE_GTIDS", "IS", "ITERATE", "JOIN", "KEY", "KEYS", "KILL", "LEADING", "LEAVE", "LEFT", "LIKE", "LIMIT", "LINEAR", "LINES", "LOAD", "LOCALTIME", "LOCALTIMESTAMP", "LOCK", "LONG", "LONGBLOB", "LONGTEXT", "LOOP", "LOW_PRIORITY", "MASTER_BIND", "MASTER_SSL_VERIFY_SERVER_CERT", "MATCH", "MAXVALUE", "MEDIUMBLOB", "MEDIUMINT", "MEDIUMTEXT", "MIDDLEINT", "MINUTE_MICROSECOND", "MINUTE_SECOND", "MOD", "MODIFIES", "NATURAL", "NOT", "NO_WRITE_TO_BINLOG", "NULL", "NUMERIC", "ON", "OPTIMIZE", "OPTIMIZER_COSTS", "OPTION", "OPTIONALLY", "OR", "ORDER", "OUT", "OUTER", "OUTFILE", "PARTITION", "PRECISION", "PRIMARY", "PROCEDURE", "PURGE", "RANGE", "READ", "READS", "READ_WRITE", "REAL", "REFERENCES", "REGEXP", "RELEASE", "RENAME", "REPEAT", "REPLACE", "REQUIRE", "RESIGNAL", "RESTRICT", "RETURN", "REVOKE", "RIGHT", "RLIKE", "SCHEMA", "SCHEMAS", "SECOND_MICROSECOND", "SELECT", "SENSITIVE", "SEPARATOR", "SET", "SHOW", "SIGNAL", "SMALLINT", "SPATIAL", "SPECIFIC", "SQL", "SQLEXCEPTION", "SQLSTATE", "SQLWARNING", "SQL_BIG_RESULT", "SQL_CALC_FOUND_ROWS", "SQL_SMALL_RESULT", "SSL", "STARTING", "STORED", "STRAIGHT_JOIN", "TABLE", "TERMINATED", "THEN", "TINYBLOB", "TINYINT", "TINYTEXT", "TO", "TRAILING", "TRIGGER", "TRUE", "UNDO", "UNION", "UNIQUE", "UNLOCK", "UNSIGNED", "UPDATE", "USAGE", "USE", "USING", "UTC_DATE", "UTC_TIME", "UTC_TIMESTAMP", "VALUES", "VARBINARY", "VARCHAR", "VARCHARACTER", "VARYING", "VIRTUAL", "WHEN", "WHERE", "WHILE", "WITH", "WRITE", "XOR", "YEAR_MONTH", "ZEROFILL"};
        SQL92_KEYWORDS = new String[]{"ABSOLUTE", "ACTION", "ADD", "ALL", "ALLOCATE", "ALTER", "AND", "ANY", "ARE", "AS", "ASC", "ASSERTION", "AT", "AUTHORIZATION", "AVG", "BEGIN", "BETWEEN", "BIT", "BIT_LENGTH", "BOTH", "BY", "CASCADE", "CASCADED", "CASE", "CAST", "CATALOG", "CHAR", "CHARACTER", "CHARACTER_LENGTH", "CHAR_LENGTH", "CHECK", "CLOSE", "COALESCE", "COLLATE", "COLLATION", "COLUMN", "COMMIT", "CONNECT", "CONNECTION", "CONSTRAINT", "CONSTRAINTS", "CONTINUE", "CONVERT", "CORRESPONDING", "COUNT", "CREATE", "CROSS", "CURRENT", "CURRENT_DATE", "CURRENT_TIME", "CURRENT_TIMESTAMP", "CURRENT_USER", "CURSOR", "DATE", "DAY", "DEALLOCATE", "DEC", "DECIMAL", "DECLARE", "DEFAULT", "DEFERRABLE", "DEFERRED", "DELETE", "DESC", "DESCRIBE", "DESCRIPTOR", "DIAGNOSTICS", "DISCONNECT", "DISTINCT", "DOMAIN", "DOUBLE", "DROP", "ELSE", "END", "END-EXEC", "ESCAPE", "EXCEPT", "EXCEPTION", "EXEC", "EXECUTE", "EXISTS", "EXTERNAL", "EXTRACT", "FALSE", "FETCH", "FIRST", "FLOAT", "FOR", "FOREIGN", "FOUND", "FROM", "FULL", "GET", "GLOBAL", "GO", "GOTO", "GRANT", "GROUP", "HAVING", "HOUR", "IDENTITY", "IMMEDIATE", "IN", "INDICATOR", "INITIALLY", "INNER", "INPUT", "INSENSITIVE", "INSERT", "INT", "INTEGER", "INTERSECT", "INTERVAL", "INTO", "IS", "ISOLATION", "JOIN", "KEY", "LANGUAGE", "LAST", "LEADING", "LEFT", "LEVEL", "LIKE", "LOCAL", "LOWER", "MATCH", "MAX", "MIN", "MINUTE", "MODULE", "MONTH", "NAMES", "NATIONAL", "NATURAL", "NCHAR", "NEXT", "NO", "NOT", "NULL", "NULLIF", "NUMERIC", "OCTET_LENGTH", "OF", "ON", "ONLY", "OPEN", "OPTION", "OR", "ORDER", "OUTER", "OUTPUT", "OVERLAPS", "PAD", "PARTIAL", "POSITION", "PRECISION", "PREPARE", "PRESERVE", "PRIMARY", "PRIOR", "PRIVILEGES", "PROCEDURE", "PUBLIC", "READ", "REAL", "REFERENCES", "RELATIVE", "RESTRICT", "REVOKE", "RIGHT", "ROLLBACK", "ROWS", "SCHEMA", "SCROLL", "SECOND", "SECTION", "SELECT", "SESSION", "SESSION_USER", "SET", "SIZE", "SMALLINT", "SOME", "SPACE", "SQL", "SQLCODE", "SQLERROR", "SQLSTATE", "SUBSTRING", "SUM", "SYSTEM_USER", "TABLE", "TEMPORARY", "THEN", "TIME", "TIMESTAMP", "TIMEZONE_HOUR", "TIMEZONE_MINUTE", "TO", "TRAILING", "TRANSACTION", "TRANSLATE", "TRANSLATION", "TRIM", "TRUE", "UNION", "UNIQUE", POP3Message.UNKNOWN, "UPDATE", "UPPER", "USAGE", "USER", "USING", "VALUE", "VALUES", "VARCHAR", "VARYING", "VIEW", "WHEN", "WHENEVER", "WHERE", "WITH", "WORK", "WRITE", "YEAR", "ZONE"};
        SQL2003_KEYWORDS = new String[]{"ABS", "ALL", "ALLOCATE", "ALTER", "AND", "ANY", "ARE", "ARRAY", "AS", "ASENSITIVE", "ASYMMETRIC", "AT", "ATOMIC", "AUTHORIZATION", "AVG", "BEGIN", "BETWEEN", "BIGINT", "BINARY", "BLOB", "BOOLEAN", "BOTH", "BY", "CALL", "CALLED", "CARDINALITY", "CASCADED", "CASE", "CAST", "CEIL", "CEILING", "CHAR", "CHARACTER", "CHARACTER_LENGTH", "CHAR_LENGTH", "CHECK", "CLOB", "CLOSE", "COALESCE", "COLLATE", "COLLECT", "COLUMN", "COMMIT", "CONDITION", "CONNECT", "CONSTRAINT", "CONVERT", "CORR", "CORRESPONDING", "COUNT", "COVAR_POP", "COVAR_SAMP", "CREATE", "CROSS", "CUBE", "CUME_DIST", "CURRENT", "CURRENT_DATE", "CURRENT_DEFAULT_TRANSFORM_GROUP", "CURRENT_PATH", "CURRENT_ROLE", "CURRENT_TIME", "CURRENT_TIMESTAMP", "CURRENT_TRANSFORM_GROUP_FOR_TYPE", "CURRENT_USER", "CURSOR", "CYCLE", "DATE", "DAY", "DEALLOCATE", "DEC", "DECIMAL", "DECLARE", "DEFAULT", "DELETE", "DENSE_RANK", "DEREF", "DESCRIBE", "DETERMINISTIC", "DISCONNECT", "DISTINCT", "DOUBLE", "DROP", "DYNAMIC", "EACH", "ELEMENT", "ELSE", "END", "END-EXEC", "ESCAPE", "EVERY", "EXCEPT", "EXEC", "EXECUTE", "EXISTS", "EXP", "EXTERNAL", "EXTRACT", "FALSE", "FETCH", "FILTER", "FLOAT", "FLOOR", "FOR", "FOREIGN", "FREE", "FROM", "FULL", "FUNCTION", "FUSION", "GET", "GLOBAL", "GRANT", "GROUP", "GROUPING", "HAVING", "HOLD", "HOUR", "IDENTITY", "IN", "INDICATOR", "INNER", "INOUT", "INSENSITIVE", "INSERT", "INT", "INTEGER", "INTERSECT", "INTERSECTION", "INTERVAL", "INTO", "IS", "JOIN", "LANGUAGE", "LARGE", "LATERAL", "LEADING", "LEFT", "LIKE", "LN", "LOCAL", "LOCALTIME", "LOCALTIMESTAMP", "LOWER", "MATCH", "MAX", "MEMBER", "MERGE", "METHOD", "MIN", "MINUTE", "MOD", "MODIFIES", "MODULE", "MONTH", "MULTISET", "NATIONAL", "NATURAL", "NCHAR", "NCLOB", "NEW", "NO", "NONE", "NORMALIZE", "NOT", "NULL", "NULLIF", "NUMERIC", "OCTET_LENGTH", "OF", "OLD", "ON", "ONLY", "OPEN", "OR", "ORDER", "OUT", "OUTER", "OVER", "OVERLAPS", "OVERLAY", "PARAMETER", "PARTITION", "PERCENTILE_CONT", "PERCENTILE_DISC", "PERCENT_RANK", "POSITION", "POWER", "PRECISION", "PREPARE", "PRIMARY", "PROCEDURE", "RANGE", "RANK", "READS", "REAL", "RECURSIVE", "REF", "REFERENCES", "REFERENCING", "REGR_AVGX", "REGR_AVGY", "REGR_COUNT", "REGR_INTERCEPT", "REGR_R2", "REGR_SLOPE", "REGR_SXX", "REGR_SXY", "REGR_SYY", "RELEASE", "RESULT", "RETURN", "RETURNS", "REVOKE", "RIGHT", "ROLLBACK", "ROLLUP", "ROW", "ROWS", "ROW_NUMBER", "SAVEPOINT", "SCOPE", "SCROLL", "SEARCH", "SECOND", "SELECT", "SENSITIVE", "SESSION_USER", "SET", "SIMILAR", "SMALLINT", "SOME", "SPECIFIC", "SPECIFICTYPE", "SQL", "SQLEXCEPTION", "SQLSTATE", "SQLWARNING", "SQRT", "START", "STATIC", "STDDEV_POP", "STDDEV_SAMP", "SUBMULTISET", "SUBSTRING", "SUM", "SYMMETRIC", "SYSTEM", "SYSTEM_USER", "TABLE", "TABLESAMPLE", "THEN", "TIME", "TIMESTAMP", "TIMEZONE_HOUR", "TIMEZONE_MINUTE", "TO", "TRAILING", "TRANSLATE", "TRANSLATION", "TREAT", "TRIGGER", "TRIM", "TRUE", "UESCAPE", "UNION", "UNIQUE", POP3Message.UNKNOWN, "UNNEST", "UPDATE", "UPPER", "USER", "USING", "VALUE", "VALUES", "VARCHAR", "VARYING", "VAR_POP", "VAR_SAMP", "WHEN", "WHENEVER", "WHERE", "WIDTH_BUCKET", "WINDOW", "WITH", "WITHIN", "WITHOUT", "YEAR"};
        mysqlKeywords = null;
    }

    public DatabaseMetaData(MySQLConnection mySQLConnection, String str) {
        this.database = null;
        this.conn = mySQLConnection;
        this.database = str;
        this.exceptionInterceptor = mySQLConnection.getExceptionInterceptor();
        try {
            try {
                this.quotedId = getIdentifierQuoteString();
            } catch (SQLException e) {
                AssertionFailedException.shouldNotHappen(e);
                this.quotedId = null;
            }
        } catch (Throwable th) {
            this.quotedId = null;
            throw th;
        }
    }

    private ResultSet buildResultSet(Field[] fieldArr, ArrayList<ResultSetRow> arrayList) throws SQLException {
        return buildResultSet(fieldArr, arrayList, this.conn);
    }

    private ResultSetRow convertTypeDescriptorToProcedureRow(byte[] bArr, byte[] bArr2, String str, boolean z, boolean z2, boolean z3, TypeDescriptor typeDescriptor, boolean z4, int i) throws SQLException {
        byte[][] bArr3 = z4 ? new byte[17][] : new byte[20][];
        bArr3[0] = bArr2;
        bArr3[1] = null;
        bArr3[2] = bArr;
        bArr3[3] = s2b(str);
        bArr3[4] = s2b(String.valueOf(getColumnType(z, z2, z3, z4)));
        bArr3[5] = s2b(Short.toString(typeDescriptor.dataType));
        bArr3[6] = s2b(typeDescriptor.typeName);
        Integer num = typeDescriptor.columnSize;
        bArr3[7] = num == null ? null : s2b(num.toString());
        bArr3[8] = bArr3[7];
        Integer num2 = typeDescriptor.decimalDigits;
        bArr3[9] = num2 == null ? null : s2b(num2.toString());
        bArr3[10] = s2b(Integer.toString(typeDescriptor.numPrecRadix));
        int i2 = typeDescriptor.nullability;
        if (i2 == 0) {
            bArr3[11] = s2b(String.valueOf(0));
        } else if (i2 == 1) {
            bArr3[11] = s2b(String.valueOf(1));
        } else {
            if (i2 != 2) {
                throw SQLError.createSQLException("Internal error while parsing callable statement metadata (unknown nullability value fount)", SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
            }
            bArr3[11] = s2b(String.valueOf(2));
        }
        bArr3[12] = null;
        if (z4) {
            bArr3[13] = null;
            bArr3[14] = s2b(String.valueOf(i));
            bArr3[15] = s2b(typeDescriptor.isNullable);
            bArr3[16] = bArr;
        } else {
            bArr3[13] = null;
            bArr3[14] = null;
            bArr3[15] = null;
            bArr3[16] = null;
            bArr3[17] = s2b(String.valueOf(i));
            bArr3[18] = s2b(typeDescriptor.isNullable);
            bArr3[19] = bArr;
        }
        return new ByteArrayRow(bArr3, getExceptionInterceptor());
    }

    private int endPositionOfParameterDeclaration(int i, String str, String str2) throws SQLException {
        int i2 = 1;
        int i3 = i + 1;
        while (i2 > 0 && i3 < str.length()) {
            int iIndexOfIgnoreCase = StringUtils.indexOfIgnoreCase(i3, str, ")", str2, str2, this.conn.isNoBackslashEscapesSet() ? StringUtils.SEARCH_MODE__MRK_COM_WS : StringUtils.SEARCH_MODE__ALL);
            if (iIndexOfIgnoreCase == -1) {
                throw SQLError.createSQLException("Internal error when parsing callable statement metadata", SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
            }
            int iIndexOfIgnoreCase2 = StringUtils.indexOfIgnoreCase(i3, str, "(", str2, str2, this.conn.isNoBackslashEscapesSet() ? StringUtils.SEARCH_MODE__MRK_COM_WS : StringUtils.SEARCH_MODE__ALL);
            if (iIndexOfIgnoreCase2 == -1 || iIndexOfIgnoreCase2 >= iIndexOfIgnoreCase) {
                i2--;
            } else {
                i2++;
                iIndexOfIgnoreCase++;
            }
            i3 = iIndexOfIgnoreCase;
        }
        return i3;
    }

    private int findEndOfReturnsClause(String str, int i) throws SQLException {
        String str2 = this.quotedId + "(";
        String str3 = this.quotedId + ")";
        String[] strArr = {"LANGUAGE", "NOT", "DETERMINISTIC", "CONTAINS", "NO", "READ", "MODIFIES", "SQL", "COMMENT", "BEGIN", "RETURN"};
        int i2 = i + 7 + 1;
        int i3 = -1;
        for (int i4 = 0; i4 < 11; i4++) {
            int iIndexOfIgnoreCase = StringUtils.indexOfIgnoreCase(i2, str, strArr[i4], str2, str3, this.conn.isNoBackslashEscapesSet() ? StringUtils.SEARCH_MODE__MRK_COM_WS : StringUtils.SEARCH_MODE__ALL);
            if (iIndexOfIgnoreCase != -1 && (i3 == -1 || iIndexOfIgnoreCase < i3)) {
                i3 = iIndexOfIgnoreCase;
            }
        }
        if (i3 != -1) {
            return i3;
        }
        int iIndexOfIgnoreCase2 = StringUtils.indexOfIgnoreCase(i2, str, ":", str2, str3, this.conn.isNoBackslashEscapesSet() ? StringUtils.SEARCH_MODE__MRK_COM_WS : StringUtils.SEARCH_MODE__ALL);
        if (iIndexOfIgnoreCase2 != -1) {
            while (iIndexOfIgnoreCase2 > 0) {
                if (Character.isWhitespace(str.charAt(iIndexOfIgnoreCase2))) {
                    return iIndexOfIgnoreCase2;
                }
                iIndexOfIgnoreCase2--;
            }
        }
        throw SQLError.createSQLException("Internal error when parsing callable statement metadata", SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:207:0x0449
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:143)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:58)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:50)
        */
    private void getCallStmtParameterTypes(java.lang.String r42, java.lang.String r43, com.mysql.jdbc.DatabaseMetaData.ProcedureType r44, java.lang.String r45, java.util.List<com.mysql.jdbc.ResultSetRow> r46, boolean r47) throws java.sql.SQLException {
        /*
            Method dump skipped, instruction units count: 1134
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mysql.jdbc.DatabaseMetaData.getCallStmtParameterTypes(java.lang.String, java.lang.String, com.mysql.jdbc.DatabaseMetaData$ProcedureType, java.lang.String, java.util.List, boolean):void");
    }

    private int getCascadeDeleteOption(String str) {
        int iIndexOf = str.indexOf("ON DELETE");
        if (iIndexOf != -1) {
            String strSubstring = str.substring(iIndexOf, str.length());
            if (strSubstring.startsWith("ON DELETE CASCADE")) {
                return 0;
            }
            if (strSubstring.startsWith("ON DELETE SET NULL")) {
                return 2;
            }
            if (strSubstring.startsWith("ON DELETE RESTRICT")) {
                return 1;
            }
            if (strSubstring.startsWith("ON DELETE NO ACTION")) {
            }
        }
        return 3;
    }

    private int getCascadeUpdateOption(String str) {
        int iIndexOf = str.indexOf("ON UPDATE");
        if (iIndexOf != -1) {
            String strSubstring = str.substring(iIndexOf, str.length());
            if (strSubstring.startsWith("ON UPDATE CASCADE")) {
                return 0;
            }
            if (strSubstring.startsWith("ON UPDATE SET NULL")) {
                return 2;
            }
            if (strSubstring.startsWith("ON UPDATE RESTRICT")) {
                return 1;
            }
            if (strSubstring.startsWith("ON UPDATE NO ACTION")) {
            }
        }
        return 3;
    }

    public static DatabaseMetaData getInstance(MySQLConnection mySQLConnection, String str, boolean z) throws SQLException {
        if (Util.isJdbc4()) {
            return (z && mySQLConnection.getUseInformationSchema() && mySQLConnection.versionMeetsMinimum(5, 0, 7)) ? (DatabaseMetaData) Util.handleNewInstance(JDBC_4_DBMD_IS_CTOR, new Object[]{mySQLConnection, str}, mySQLConnection.getExceptionInterceptor()) : (DatabaseMetaData) Util.handleNewInstance(JDBC_4_DBMD_SHOW_CTOR, new Object[]{mySQLConnection, str}, mySQLConnection.getExceptionInterceptor());
        }
        return (z && mySQLConnection.getUseInformationSchema() && mySQLConnection.versionMeetsMinimum(5, 0, 7)) ? new DatabaseMetaDataUsingInfoSchema(mySQLConnection, str) : new DatabaseMetaData(mySQLConnection, str);
    }

    private void getResultsImpl(String str, String str2, String str3, List<ResultSetRow> list, String str4, boolean z) throws SQLException {
        String str5;
        LocalAndReferencedColumns tableStatusIntoLocalAndReferencedColumns = parseTableStatusIntoLocalAndReferencedColumns(str3);
        if (z) {
            str5 = str2;
            if (!tableStatusIntoLocalAndReferencedColumns.referencedTable.equals(str5)) {
                return;
            }
        } else {
            str5 = str2;
        }
        if (tableStatusIntoLocalAndReferencedColumns.localColumnsList.size() != tableStatusIntoLocalAndReferencedColumns.referencedColumnsList.size()) {
            throw SQLError.createSQLException("Error parsing foreign keys definition, number of local and referenced columns is not the same.", SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
        }
        Iterator<String> it = tableStatusIntoLocalAndReferencedColumns.localColumnsList.iterator();
        Iterator<String> it2 = tableStatusIntoLocalAndReferencedColumns.referencedColumnsList.iterator();
        int i = 1;
        while (it.hasNext()) {
            byte[][] bArr = new byte[14][];
            String strUnQuoteIdentifier = StringUtils.unQuoteIdentifier(it.next(), this.quotedId);
            String strUnQuoteIdentifier2 = StringUtils.unQuoteIdentifier(it2.next(), this.quotedId);
            bArr[4] = str == null ? new byte[0] : s2b(str);
            bArr[5] = null;
            bArr[6] = s2b(z ? str4 : str5);
            bArr[7] = s2b(strUnQuoteIdentifier);
            bArr[0] = s2b(tableStatusIntoLocalAndReferencedColumns.referencedCatalog);
            bArr[1] = null;
            bArr[2] = s2b(z ? str5 : tableStatusIntoLocalAndReferencedColumns.referencedTable);
            bArr[3] = s2b(strUnQuoteIdentifier2);
            int i2 = i + 1;
            bArr[8] = s2b(Integer.toString(i));
            int[] foreignKeyActions = getForeignKeyActions(str3);
            bArr[9] = s2b(Integer.toString(foreignKeyActions[1]));
            bArr[10] = s2b(Integer.toString(foreignKeyActions[0]));
            bArr[11] = s2b(tableStatusIntoLocalAndReferencedColumns.constraintName);
            bArr[12] = null;
            bArr[13] = s2b(Integer.toString(7));
            list.add(new ByteArrayRow(bArr, getExceptionInterceptor()));
            i = i2;
        }
    }

    @Override // java.sql.DatabaseMetaData
    public boolean allProceduresAreCallable() throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean allTablesAreSelectable() throws SQLException {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0028  */
    public void convertToJdbcFunctionList(String str, ResultSet resultSet, boolean z, String str2, List<ComparableWrapper<String, ResultSetRow>> list, int i, Field[] fieldArr) throws SQLException {
        boolean z2;
        byte[][] bArr;
        while (resultSet.next()) {
            if (z) {
                String string = resultSet.getString(1);
                if (!(str2 == null && string == null) && (str2 == null || !str2.equals(string))) {
                    z2 = false;
                } else {
                    z2 = true;
                }
            } else {
                z2 = true;
            }
            if (z2) {
                String string2 = resultSet.getString(i);
                if (fieldArr == null || fieldArr.length != 9) {
                    bArr = new byte[6][];
                    bArr[0] = str == null ? null : s2b(str);
                    bArr[1] = null;
                    bArr[2] = s2b(string2);
                    bArr[3] = s2b(resultSet.getString("comment"));
                    bArr[4] = s2b(Integer.toString(getJDBC4FunctionNoTableConstant()));
                    bArr[5] = s2b(string2);
                } else {
                    bArr = new byte[9][];
                    bArr[0] = str == null ? null : s2b(str);
                    bArr[1] = null;
                    bArr[2] = s2b(string2);
                    bArr[3] = null;
                    bArr[4] = null;
                    bArr[5] = null;
                    bArr[6] = s2b(resultSet.getString("comment"));
                    bArr[7] = s2b(Integer.toString(2));
                    bArr[8] = s2b(string2);
                }
                list.add(new ComparableWrapper<>(getFullyQualifiedName(str, string2), new ByteArrayRow(bArr, getExceptionInterceptor())));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001e  */
    public void convertToJdbcProcedureList(boolean z, String str, ResultSet resultSet, boolean z2, String str2, List<ComparableWrapper<String, ResultSetRow>> list, int i) throws SQLException {
        boolean z3;
        while (resultSet.next()) {
            if (z2) {
                String string = resultSet.getString(1);
                if (!(str2 == null && string == null) && (str2 == null || !str2.equals(string))) {
                    z3 = false;
                } else {
                    z3 = true;
                }
            } else {
                z3 = true;
            }
            if (z3) {
                String string2 = resultSet.getString(i);
                byte[][] bArr = new byte[9][];
                bArr[0] = str == null ? null : s2b(str);
                bArr[1] = null;
                bArr[2] = s2b(string2);
                bArr[3] = null;
                bArr[4] = null;
                bArr[5] = null;
                bArr[6] = s2b(resultSet.getString("comment"));
                bArr[7] = s2b(z ? "FUNCTION".equalsIgnoreCase(resultSet.getString("type")) : false ? Integer.toString(2) : Integer.toString(1));
                bArr[8] = s2b(string2);
                list.add(new ComparableWrapper<>(getFullyQualifiedName(str, string2), new ByteArrayRow(bArr, getExceptionInterceptor())));
            }
        }
    }

    public Field[] createColumnsFields() {
        return new Field[]{new Field(BuildConfig.FLAVOR, "TABLE_CAT", 1, 255), new Field(BuildConfig.FLAVOR, "TABLE_SCHEM", 1, 0), new Field(BuildConfig.FLAVOR, "TABLE_NAME", 1, 255), new Field(BuildConfig.FLAVOR, "COLUMN_NAME", 1, 32), new Field(BuildConfig.FLAVOR, "DATA_TYPE", 4, 5), new Field(BuildConfig.FLAVOR, "TYPE_NAME", 1, 16), new Field(BuildConfig.FLAVOR, "COLUMN_SIZE", 4, Integer.toString(Integer.MAX_VALUE).length()), new Field(BuildConfig.FLAVOR, "BUFFER_LENGTH", 4, 10), new Field(BuildConfig.FLAVOR, "DECIMAL_DIGITS", 4, 10), new Field(BuildConfig.FLAVOR, "NUM_PREC_RADIX", 4, 10), new Field(BuildConfig.FLAVOR, "NULLABLE", 4, 10), new Field(BuildConfig.FLAVOR, "REMARKS", 1, 0), new Field(BuildConfig.FLAVOR, "COLUMN_DEF", 1, 0), new Field(BuildConfig.FLAVOR, "SQL_DATA_TYPE", 4, 10), new Field(BuildConfig.FLAVOR, "SQL_DATETIME_SUB", 4, 10), new Field(BuildConfig.FLAVOR, "CHAR_OCTET_LENGTH", 4, Integer.toString(Integer.MAX_VALUE).length()), new Field(BuildConfig.FLAVOR, "ORDINAL_POSITION", 4, 10), new Field(BuildConfig.FLAVOR, "IS_NULLABLE", 1, 3), new Field(BuildConfig.FLAVOR, "SCOPE_CATALOG", 1, 255), new Field(BuildConfig.FLAVOR, "SCOPE_SCHEMA", 1, 255), new Field(BuildConfig.FLAVOR, "SCOPE_TABLE", 1, 255), new Field(BuildConfig.FLAVOR, "SOURCE_DATA_TYPE", 5, 10), new Field(BuildConfig.FLAVOR, "IS_AUTOINCREMENT", 1, 3), new Field(BuildConfig.FLAVOR, "IS_GENERATEDCOLUMN", 1, 3)};
    }

    public Field[] createFieldMetadataForGetProcedures() {
        return new Field[]{new Field(BuildConfig.FLAVOR, "PROCEDURE_CAT", 1, 255), new Field(BuildConfig.FLAVOR, "PROCEDURE_SCHEM", 1, 255), new Field(BuildConfig.FLAVOR, "PROCEDURE_NAME", 1, 255), new Field(BuildConfig.FLAVOR, "reserved1", 1, 0), new Field(BuildConfig.FLAVOR, "reserved2", 1, 0), new Field(BuildConfig.FLAVOR, "reserved3", 1, 0), new Field(BuildConfig.FLAVOR, "REMARKS", 1, 255), new Field(BuildConfig.FLAVOR, "PROCEDURE_TYPE", 5, 6), new Field(BuildConfig.FLAVOR, "SPECIFIC_NAME", 1, 255)};
    }

    public Field[] createFkMetadataFields() {
        return new Field[]{new Field(BuildConfig.FLAVOR, "PKTABLE_CAT", 1, 255), new Field(BuildConfig.FLAVOR, "PKTABLE_SCHEM", 1, 0), new Field(BuildConfig.FLAVOR, "PKTABLE_NAME", 1, 255), new Field(BuildConfig.FLAVOR, "PKCOLUMN_NAME", 1, 32), new Field(BuildConfig.FLAVOR, "FKTABLE_CAT", 1, 255), new Field(BuildConfig.FLAVOR, "FKTABLE_SCHEM", 1, 0), new Field(BuildConfig.FLAVOR, "FKTABLE_NAME", 1, 255), new Field(BuildConfig.FLAVOR, "FKCOLUMN_NAME", 1, 32), new Field(BuildConfig.FLAVOR, "KEY_SEQ", 5, 2), new Field(BuildConfig.FLAVOR, "UPDATE_RULE", 5, 2), new Field(BuildConfig.FLAVOR, "DELETE_RULE", 5, 2), new Field(BuildConfig.FLAVOR, "FK_NAME", 1, 0), new Field(BuildConfig.FLAVOR, "PK_NAME", 1, 0), new Field(BuildConfig.FLAVOR, "DEFERRABILITY", 5, 2)};
    }

    public Field[] createFunctionColumnsFields() {
        return new Field[]{new Field(BuildConfig.FLAVOR, "FUNCTION_CAT", 12, 512), new Field(BuildConfig.FLAVOR, "FUNCTION_SCHEM", 12, 512), new Field(BuildConfig.FLAVOR, "FUNCTION_NAME", 12, 512), new Field(BuildConfig.FLAVOR, "COLUMN_NAME", 12, 512), new Field(BuildConfig.FLAVOR, "COLUMN_TYPE", 12, 64), new Field(BuildConfig.FLAVOR, "DATA_TYPE", 5, 6), new Field(BuildConfig.FLAVOR, "TYPE_NAME", 12, 64), new Field(BuildConfig.FLAVOR, "PRECISION", 4, 12), new Field(BuildConfig.FLAVOR, "LENGTH", 4, 12), new Field(BuildConfig.FLAVOR, "SCALE", 5, 12), new Field(BuildConfig.FLAVOR, "RADIX", 5, 6), new Field(BuildConfig.FLAVOR, "NULLABLE", 5, 6), new Field(BuildConfig.FLAVOR, "REMARKS", 12, 512), new Field(BuildConfig.FLAVOR, "CHAR_OCTET_LENGTH", 4, 32), new Field(BuildConfig.FLAVOR, "ORDINAL_POSITION", 4, 32), new Field(BuildConfig.FLAVOR, "IS_NULLABLE", 12, 12), new Field(BuildConfig.FLAVOR, "SPECIFIC_NAME", 12, 64)};
    }

    public Field[] createIndexInfoFields() {
        Field[] fieldArr = new Field[13];
        fieldArr[0] = new Field(BuildConfig.FLAVOR, "TABLE_CAT", 1, 255);
        fieldArr[1] = new Field(BuildConfig.FLAVOR, "TABLE_SCHEM", 1, 0);
        fieldArr[2] = new Field(BuildConfig.FLAVOR, "TABLE_NAME", 1, 255);
        fieldArr[3] = new Field(BuildConfig.FLAVOR, "NON_UNIQUE", 16, 4);
        fieldArr[4] = new Field(BuildConfig.FLAVOR, "INDEX_QUALIFIER", 1, 1);
        fieldArr[5] = new Field(BuildConfig.FLAVOR, "INDEX_NAME", 1, 32);
        fieldArr[6] = new Field(BuildConfig.FLAVOR, "TYPE", 5, 32);
        fieldArr[7] = new Field(BuildConfig.FLAVOR, "ORDINAL_POSITION", 5, 5);
        fieldArr[8] = new Field(BuildConfig.FLAVOR, "COLUMN_NAME", 1, 32);
        fieldArr[9] = new Field(BuildConfig.FLAVOR, "ASC_OR_DESC", 1, 1);
        if (Util.isJdbc42()) {
            fieldArr[10] = new Field(BuildConfig.FLAVOR, "CARDINALITY", -5, 20);
            fieldArr[11] = new Field(BuildConfig.FLAVOR, "PAGES", -5, 20);
        } else {
            fieldArr[10] = new Field(BuildConfig.FLAVOR, "CARDINALITY", 4, 20);
            fieldArr[11] = new Field(BuildConfig.FLAVOR, "PAGES", 4, 10);
        }
        fieldArr[12] = new Field(BuildConfig.FLAVOR, "FILTER_CONDITION", 1, 32);
        return fieldArr;
    }

    public Field[] createProcedureColumnsFields() {
        return new Field[]{new Field(BuildConfig.FLAVOR, "PROCEDURE_CAT", 1, 512), new Field(BuildConfig.FLAVOR, "PROCEDURE_SCHEM", 1, 512), new Field(BuildConfig.FLAVOR, "PROCEDURE_NAME", 1, 512), new Field(BuildConfig.FLAVOR, "COLUMN_NAME", 1, 512), new Field(BuildConfig.FLAVOR, "COLUMN_TYPE", 1, 64), new Field(BuildConfig.FLAVOR, "DATA_TYPE", 5, 6), new Field(BuildConfig.FLAVOR, "TYPE_NAME", 1, 64), new Field(BuildConfig.FLAVOR, "PRECISION", 4, 12), new Field(BuildConfig.FLAVOR, "LENGTH", 4, 12), new Field(BuildConfig.FLAVOR, "SCALE", 5, 12), new Field(BuildConfig.FLAVOR, "RADIX", 5, 6), new Field(BuildConfig.FLAVOR, "NULLABLE", 5, 6), new Field(BuildConfig.FLAVOR, "REMARKS", 1, 512), new Field(BuildConfig.FLAVOR, "COLUMN_DEF", 1, 512), new Field(BuildConfig.FLAVOR, "SQL_DATA_TYPE", 4, 12), new Field(BuildConfig.FLAVOR, "SQL_DATETIME_SUB", 4, 12), new Field(BuildConfig.FLAVOR, "CHAR_OCTET_LENGTH", 4, 12), new Field(BuildConfig.FLAVOR, "ORDINAL_POSITION", 4, 12), new Field(BuildConfig.FLAVOR, "IS_NULLABLE", 1, 512), new Field(BuildConfig.FLAVOR, "SPECIFIC_NAME", 1, 512)};
    }

    public Field[] createTablesFields() {
        return new Field[]{new Field(BuildConfig.FLAVOR, "TABLE_CAT", 12, 255), new Field(BuildConfig.FLAVOR, "TABLE_SCHEM", 12, 0), new Field(BuildConfig.FLAVOR, "TABLE_NAME", 12, 255), new Field(BuildConfig.FLAVOR, "TABLE_TYPE", 12, 5), new Field(BuildConfig.FLAVOR, "REMARKS", 12, 0), new Field(BuildConfig.FLAVOR, "TYPE_CAT", 12, 0), new Field(BuildConfig.FLAVOR, "TYPE_SCHEM", 12, 0), new Field(BuildConfig.FLAVOR, "TYPE_NAME", 12, 0), new Field(BuildConfig.FLAVOR, "SELF_REFERENCING_COL_NAME", 12, 0), new Field(BuildConfig.FLAVOR, "REF_GENERATION", 12, 0)};
    }

    @Override // java.sql.DatabaseMetaData
    public boolean dataDefinitionCausesTransactionCommit() throws SQLException {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean dataDefinitionIgnoredInTransactions() throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean deletesAreDetected(int i) throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean doesMaxRowSizeIncludeBlobs() throws SQLException {
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x007f  */
    /* JADX WARN: Code duplicated, block: B:38:0x0139  */
    public List<ResultSetRow> extractForeignKeyForTable(ArrayList<ResultSetRow> arrayList, ResultSet resultSet, String str) throws SQLException {
        String strSubstring;
        String str2;
        String strSubstring2;
        String strSubstring3;
        String strSubstring4;
        boolean z;
        byte[][] bArr = new byte[3][];
        int i = 1;
        bArr[0] = resultSet.getBytes(1);
        bArr[1] = s2b(SUPPORTS_FK);
        StringTokenizer stringTokenizer = new StringTokenizer(resultSet.getString(2), "\n");
        StringBuilder sb = new StringBuilder("comment; ");
        boolean z2 = true;
        while (stringTokenizer.hasMoreTokens()) {
            String strTrim = stringTokenizer.nextToken().trim();
            if (StringUtils.startsWithIgnoreCase(strTrim, "CONSTRAINT")) {
                int iIndexOfQuoteDoubleAware = StringUtils.indexOfQuoteDoubleAware(strTrim, this.quotedId, 0);
                if (iIndexOfQuoteDoubleAware == -1) {
                    iIndexOfQuoteDoubleAware = strTrim.indexOf("\"");
                    z = false;
                } else {
                    z = true;
                }
                if (iIndexOfQuoteDoubleAware == -1) {
                    strSubstring = null;
                } else {
                    int iIndexOfQuoteDoubleAware2 = z ? StringUtils.indexOfQuoteDoubleAware(strTrim, this.quotedId, iIndexOfQuoteDoubleAware + 1) : StringUtils.indexOfQuoteDoubleAware(strTrim, "\"", iIndexOfQuoteDoubleAware + 1);
                    if (iIndexOfQuoteDoubleAware2 != -1) {
                        strSubstring = strTrim.substring(iIndexOfQuoteDoubleAware + 1, iIndexOfQuoteDoubleAware2);
                        strTrim = strTrim.substring(iIndexOfQuoteDoubleAware2 + 1, strTrim.length()).trim();
                    } else {
                        strSubstring = null;
                    }
                }
            } else {
                strSubstring = null;
            }
            if (strTrim.startsWith("FOREIGN KEY")) {
                if (strTrim.endsWith(",")) {
                    strTrim = strTrim.substring(0, strTrim.length() - i);
                }
                int iIndexOf = strTrim.indexOf("FOREIGN KEY");
                String strQuoteIdentifier = StringUtils.quoteIdentifier(str, this.quotedId, this.conn.getPedantic());
                if (iIndexOf != -1) {
                    int i2 = iIndexOf + 11;
                    String str3 = this.quotedId;
                    Set<StringUtils.SearchMode> set = StringUtils.SEARCH_MODE__ALL;
                    int iIndexOfIgnoreCase = StringUtils.indexOfIgnoreCase(i2, strTrim, "REFERENCES", str3, str3, set);
                    if (iIndexOfIgnoreCase != -1) {
                        int iIndexOf2 = strTrim.indexOf(40, i2);
                        String str4 = this.quotedId;
                        strSubstring4 = strTrim.substring(iIndexOf2 + 1, StringUtils.indexOfIgnoreCase(iIndexOf2, strTrim, ")", str4, str4, set));
                        int i3 = iIndexOfIgnoreCase + 10;
                        String str5 = this.quotedId;
                        int iIndexOfIgnoreCase2 = StringUtils.indexOfIgnoreCase(i3, strTrim, "(", str5, str5, set);
                        if (iIndexOfIgnoreCase2 != -1) {
                            strSubstring3 = strTrim.substring(i3, iIndexOfIgnoreCase2);
                            int i4 = iIndexOfIgnoreCase2 + 1;
                            String str6 = this.quotedId;
                            int iIndexOfIgnoreCase3 = StringUtils.indexOfIgnoreCase(i4, strTrim, ")", str6, str6, set);
                            strSubstring2 = iIndexOfIgnoreCase3 != -1 ? strTrim.substring(i4, iIndexOfIgnoreCase3) : null;
                            String str7 = this.quotedId;
                            int iIndexOfIgnoreCase4 = StringUtils.indexOfIgnoreCase(0, strSubstring3, ".", str7, str7, set);
                            if (iIndexOfIgnoreCase4 != -1) {
                                strQuoteIdentifier = strSubstring3.substring(0, iIndexOfIgnoreCase4);
                                strSubstring3 = strSubstring3.substring(iIndexOfIgnoreCase4 + 1);
                            }
                            str2 = strQuoteIdentifier;
                        } else {
                            str2 = strQuoteIdentifier;
                            strSubstring2 = null;
                            strSubstring3 = null;
                        }
                    } else {
                        str2 = strQuoteIdentifier;
                        strSubstring2 = null;
                        strSubstring3 = null;
                        strSubstring4 = null;
                    }
                } else {
                    str2 = strQuoteIdentifier;
                    strSubstring2 = null;
                    strSubstring3 = null;
                    strSubstring4 = null;
                }
                if (z2) {
                    z2 = false;
                } else {
                    sb.append("; ");
                }
                if (strSubstring != null) {
                    sb.append(strSubstring);
                } else {
                    sb.append("not_available");
                }
                sb.append("(");
                sb.append(strSubstring4);
                sb.append(") REFER ");
                sb.append(str2);
                sb.append("/");
                sb.append(strSubstring3);
                sb.append("(");
                sb.append(strSubstring2);
                sb.append(")");
                int iLastIndexOf = strTrim.lastIndexOf(")");
                if (iLastIndexOf != strTrim.length() - 1) {
                    String strSubstring5 = strTrim.substring(iLastIndexOf + 1);
                    sb.append(" ");
                    sb.append(strSubstring5);
                }
            }
            i = 1;
        }
        bArr[2] = s2b(sb.toString());
        arrayList.add(new ByteArrayRow(bArr, getExceptionInterceptor()));
        return arrayList;
    }

    public ResultSet extractForeignKeyFromCreateTable(String str, String str2) throws Throwable {
        ArrayList arrayList = new ArrayList();
        ResultSet resultSetExecuteQuery = null;
        if (str2 != null) {
            arrayList.add(str2);
        } else {
            try {
                ResultSet tables = getTables(str, BuildConfig.FLAVOR, "%", new String[]{"TABLE"});
                while (tables.next()) {
                    try {
                        arrayList.add(tables.getString("TABLE_NAME"));
                    } catch (Throwable th) {
                        th = th;
                        resultSetExecuteQuery = tables;
                        if (resultSetExecuteQuery != null) {
                            resultSetExecuteQuery.close();
                        }
                        throw th;
                    }
                }
                if (tables != null) {
                    tables.close();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        ArrayList<ResultSetRow> arrayList2 = new ArrayList<>();
        Field[] fieldArr = {new Field(BuildConfig.FLAVOR, "Name", 1, Integer.MAX_VALUE), new Field(BuildConfig.FLAVOR, "Type", 1, 255), new Field(BuildConfig.FLAVOR, "Comment", 1, Integer.MAX_VALUE)};
        int size = arrayList.size();
        java.sql.Statement metadataSafeStatement = this.conn.getMetadataSafeStatement();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    resultSetExecuteQuery = metadataSafeStatement.executeQuery("SHOW CREATE TABLE " + getFullyQualifiedName(str, (String) arrayList.get(i)));
                    while (resultSetExecuteQuery.next()) {
                        extractForeignKeyForTable(arrayList2, resultSetExecuteQuery, str);
                    }
                } catch (SQLException e) {
                    if (SQLError.SQL_STATE_BASE_TABLE_OR_VIEW_NOT_FOUND.equals(e.getSQLState())) {
                        continue;
                    } else if (e.getErrorCode() != 1146) {
                        throw e;
                    }
                }
            } catch (Throwable th3) {
                if (resultSetExecuteQuery != null) {
                    resultSetExecuteQuery.close();
                }
                if (metadataSafeStatement != null) {
                    metadataSafeStatement.close();
                }
                throw th3;
            }
        }
        if (resultSetExecuteQuery != null) {
            resultSetExecuteQuery.close();
        }
        if (metadataSafeStatement != null) {
            metadataSafeStatement.close();
        }
        return buildResultSet(fieldArr, arrayList2);
    }

    public boolean generatedKeyAlwaysReturned() throws SQLException {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getAttributes(String str, String str2, String str3, String str4) throws SQLException {
        return buildResultSet(new Field[]{new Field(BuildConfig.FLAVOR, "TYPE_CAT", 1, 32), new Field(BuildConfig.FLAVOR, "TYPE_SCHEM", 1, 32), new Field(BuildConfig.FLAVOR, "TYPE_NAME", 1, 32), new Field(BuildConfig.FLAVOR, "ATTR_NAME", 1, 32), new Field(BuildConfig.FLAVOR, "DATA_TYPE", 5, 32), new Field(BuildConfig.FLAVOR, "ATTR_TYPE_NAME", 1, 32), new Field(BuildConfig.FLAVOR, "ATTR_SIZE", 4, 32), new Field(BuildConfig.FLAVOR, "DECIMAL_DIGITS", 4, 32), new Field(BuildConfig.FLAVOR, "NUM_PREC_RADIX", 4, 32), new Field(BuildConfig.FLAVOR, "NULLABLE ", 4, 32), new Field(BuildConfig.FLAVOR, "REMARKS", 1, 32), new Field(BuildConfig.FLAVOR, "ATTR_DEF", 1, 32), new Field(BuildConfig.FLAVOR, "SQL_DATA_TYPE", 4, 32), new Field(BuildConfig.FLAVOR, "SQL_DATETIME_SUB", 4, 32), new Field(BuildConfig.FLAVOR, "CHAR_OCTET_LENGTH", 4, 32), new Field(BuildConfig.FLAVOR, "ORDINAL_POSITION", 4, 32), new Field(BuildConfig.FLAVOR, "IS_NULLABLE", 1, 32), new Field(BuildConfig.FLAVOR, "SCOPE_CATALOG", 1, 32), new Field(BuildConfig.FLAVOR, "SCOPE_SCHEMA", 1, 32), new Field(BuildConfig.FLAVOR, "SCOPE_TABLE", 1, 32), new Field(BuildConfig.FLAVOR, "SOURCE_DATA_TYPE", 5, 32)}, new ArrayList<>());
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getBestRowIdentifier(String str, String str2, final String str3, int i, boolean z) throws SQLException {
        if (str3 == null) {
            throw SQLError.createSQLException("Table not specified.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
        Field[] fieldArr = {new Field(BuildConfig.FLAVOR, "SCOPE", 5, 5), new Field(BuildConfig.FLAVOR, "COLUMN_NAME", 1, 32), new Field(BuildConfig.FLAVOR, "DATA_TYPE", 4, 32), new Field(BuildConfig.FLAVOR, "TYPE_NAME", 1, 32), new Field(BuildConfig.FLAVOR, "COLUMN_SIZE", 4, 10), new Field(BuildConfig.FLAVOR, "BUFFER_LENGTH", 4, 10), new Field(BuildConfig.FLAVOR, "DECIMAL_DIGITS", 5, 10), new Field(BuildConfig.FLAVOR, "PSEUDO_COLUMN", 5, 5)};
        final ArrayList<ResultSetRow> arrayList = new ArrayList<>();
        final java.sql.Statement metadataSafeStatement = this.conn.getMetadataSafeStatement();
        try {
            new IterateBlock<String>(getCatalogIterator(str)) { // from class: com.mysql.jdbc.DatabaseMetaData.1
                @Override // com.mysql.jdbc.IterateBlock
                public void forEach(String str4) throws SQLException {
                    int i2;
                    ResultSet resultSetExecuteQuery = null;
                    try {
                        try {
                            StringBuilder sb = new StringBuilder("SHOW COLUMNS FROM ");
                            String str5 = str3;
                            DatabaseMetaData databaseMetaData = DatabaseMetaData.this;
                            sb.append(StringUtils.quoteIdentifier(str5, databaseMetaData.quotedId, databaseMetaData.conn.getPedantic()));
                            sb.append(" FROM ");
                            DatabaseMetaData databaseMetaData2 = DatabaseMetaData.this;
                            sb.append(StringUtils.quoteIdentifier(str4, databaseMetaData2.quotedId, databaseMetaData2.conn.getPedantic()));
                            resultSetExecuteQuery = metadataSafeStatement.executeQuery(sb.toString());
                            while (resultSetExecuteQuery.next()) {
                                String string = resultSetExecuteQuery.getString("Key");
                                if (string != null && StringUtils.startsWithIgnoreCase(string, "PRI")) {
                                    byte[][] bArr = new byte[8][];
                                    int i3 = 0;
                                    bArr[0] = Integer.toString(2).getBytes();
                                    bArr[1] = resultSetExecuteQuery.getBytes("Field");
                                    String string2 = resultSetExecuteQuery.getString("Type");
                                    int maxBuf = MysqlIO.getMaxBuf();
                                    if (string2.indexOf("enum") != -1) {
                                        StringTokenizer stringTokenizer = new StringTokenizer(string2.substring(string2.indexOf("("), string2.indexOf(")")), ",");
                                        int iMax = 0;
                                        while (stringTokenizer.hasMoreTokens()) {
                                            iMax = Math.max(iMax, stringTokenizer.nextToken().length() - 2);
                                        }
                                        maxBuf = iMax;
                                        string2 = "enum";
                                    } else if (string2.indexOf("(") != -1) {
                                        if (string2.indexOf(",") != -1) {
                                            maxBuf = Integer.parseInt(string2.substring(string2.indexOf("(") + 1, string2.indexOf(",")));
                                            i2 = Integer.parseInt(string2.substring(string2.indexOf(",") + 1, string2.indexOf(")")));
                                        } else {
                                            maxBuf = Integer.parseInt(string2.substring(string2.indexOf("(") + 1, string2.indexOf(")")));
                                            i2 = 0;
                                        }
                                        string2 = string2.substring(0, string2.indexOf("("));
                                        i3 = i2;
                                    }
                                    bArr[2] = DatabaseMetaData.this.s2b(String.valueOf(MysqlDefs.mysqlToJavaType(string2)));
                                    bArr[3] = DatabaseMetaData.this.s2b(string2);
                                    int i4 = maxBuf + i3;
                                    bArr[4] = Integer.toString(i4).getBytes();
                                    bArr[5] = Integer.toString(i4).getBytes();
                                    bArr[6] = Integer.toString(i3).getBytes();
                                    bArr[7] = Integer.toString(1).getBytes();
                                    arrayList.add(new ByteArrayRow(bArr, DatabaseMetaData.this.getExceptionInterceptor()));
                                }
                            }
                            if (resultSetExecuteQuery == null) {
                                return;
                            }
                        } catch (SQLException e) {
                            if (!SQLError.SQL_STATE_BASE_TABLE_OR_VIEW_NOT_FOUND.equals(e.getSQLState())) {
                                throw e;
                            }
                            if (resultSetExecuteQuery == null) {
                                return;
                            }
                        }
                        try {
                            resultSetExecuteQuery.close();
                        } catch (Exception unused) {
                        }
                    } catch (Throwable th) {
                        if (resultSetExecuteQuery != null) {
                            try {
                                resultSetExecuteQuery.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                }
            }.doForAll();
            return buildResultSet(fieldArr, arrayList);
        } finally {
            if (metadataSafeStatement != null) {
                metadataSafeStatement.close();
            }
        }
    }

    public IteratorWithCleanup<String> getCatalogIterator(String str) throws SQLException {
        if (str == null) {
            return this.conn.getNullCatalogMeansCurrent() ? new SingleStringIterator(this.database) : new ResultSetIterator(getCatalogs(), 1);
        }
        if (str.equals(BuildConfig.FLAVOR)) {
            return new SingleStringIterator(this.database);
        }
        return this.conn.getPedantic() ? new SingleStringIterator(str) : new SingleStringIterator(StringUtils.unQuoteIdentifier(str, this.quotedId));
    }

    @Override // java.sql.DatabaseMetaData
    public String getCatalogSeparator() throws SQLException {
        return ".";
    }

    @Override // java.sql.DatabaseMetaData
    public String getCatalogTerm() throws SQLException {
        return "database";
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getCatalogs() throws Throwable {
        java.sql.Statement metadataSafeStatement;
        int row;
        ResultSet resultSetExecuteQuery = null;
        try {
            metadataSafeStatement = this.conn.getMetadataSafeStatement();
            try {
                resultSetExecuteQuery = metadataSafeStatement.executeQuery("SHOW DATABASES");
                if (resultSetExecuteQuery.last()) {
                    row = resultSetExecuteQuery.getRow();
                    resultSetExecuteQuery.beforeFirst();
                } else {
                    row = 0;
                }
                ArrayList arrayList = new ArrayList(row);
                while (resultSetExecuteQuery.next()) {
                    arrayList.add(resultSetExecuteQuery.getString(1));
                }
                Collections.sort(arrayList);
                Field[] fieldArr = {new Field(BuildConfig.FLAVOR, "TABLE_CAT", 12, resultSetExecuteQuery.getMetaData().getColumnDisplaySize(1))};
                ArrayList<ResultSetRow> arrayList2 = new ArrayList<>(row);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new ByteArrayRow(new byte[][]{s2b((String) it.next())}, getExceptionInterceptor()));
                }
                ResultSet resultSetBuildResultSet = buildResultSet(fieldArr, arrayList2);
                if (resultSetExecuteQuery != null) {
                    try {
                        resultSetExecuteQuery.close();
                    } catch (SQLException e) {
                        AssertionFailedException.shouldNotHappen(e);
                    }
                }
                if (metadataSafeStatement != null) {
                    try {
                        metadataSafeStatement.close();
                    } catch (SQLException e2) {
                        AssertionFailedException.shouldNotHappen(e2);
                    }
                }
                return resultSetBuildResultSet;
            } catch (Throwable th) {
                th = th;
                if (resultSetExecuteQuery != null) {
                    try {
                        resultSetExecuteQuery.close();
                    } catch (SQLException e3) {
                        AssertionFailedException.shouldNotHappen(e3);
                    }
                }
                if (metadataSafeStatement == null) {
                    throw th;
                }
                try {
                    metadataSafeStatement.close();
                    throw th;
                } catch (SQLException e4) {
                    AssertionFailedException.shouldNotHappen(e4);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            metadataSafeStatement = null;
        }
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getClientInfoProperties() throws SQLException {
        return buildResultSet(new Field[]{new Field(BuildConfig.FLAVOR, "NAME", 12, 255), new Field(BuildConfig.FLAVOR, "MAX_LEN", 4, 10), new Field(BuildConfig.FLAVOR, "DEFAULT_VALUE", 12, 255), new Field(BuildConfig.FLAVOR, "DESCRIPTION", 12, 255)}, new ArrayList(), this.conn);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x007a  */
    /* JADX WARN: Code duplicated, block: B:15:0x0090 A[Catch: all -> 0x0166, TryCatch #2 {all -> 0x0166, blocks: (B:13:0x008a, B:15:0x0090, B:17:0x00a2, B:22:0x00ad, B:24:0x00b4, B:26:0x00bc, B:27:0x00c4, B:29:0x00ce, B:30:0x00db, B:32:0x00e1, B:34:0x0109, B:36:0x0118, B:35:0x0112), top: B:66:0x008a }] */
    /* JADX WARN: Code duplicated, block: B:21:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:29:0x00ce A[Catch: all -> 0x0166, TryCatch #2 {all -> 0x0166, blocks: (B:13:0x008a, B:15:0x0090, B:17:0x00a2, B:22:0x00ad, B:24:0x00b4, B:26:0x00bc, B:27:0x00c4, B:29:0x00ce, B:30:0x00db, B:32:0x00e1, B:34:0x0109, B:36:0x0118, B:35:0x0112), top: B:66:0x008a }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00e1 A[Catch: all -> 0x0166, TryCatch #2 {all -> 0x0166, blocks: (B:13:0x008a, B:15:0x0090, B:17:0x00a2, B:22:0x00ad, B:24:0x00b4, B:26:0x00bc, B:27:0x00c4, B:29:0x00ce, B:30:0x00db, B:32:0x00e1, B:34:0x0109, B:36:0x0118, B:35:0x0112), top: B:66:0x008a }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0109 A[Catch: all -> 0x0166, TryCatch #2 {all -> 0x0166, blocks: (B:13:0x008a, B:15:0x0090, B:17:0x00a2, B:22:0x00ad, B:24:0x00b4, B:26:0x00bc, B:27:0x00c4, B:29:0x00ce, B:30:0x00db, B:32:0x00e1, B:34:0x0109, B:36:0x0118, B:35:0x0112), top: B:66:0x008a }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0112 A[Catch: all -> 0x0166, TryCatch #2 {all -> 0x0166, blocks: (B:13:0x008a, B:15:0x0090, B:17:0x00a2, B:22:0x00ad, B:24:0x00b4, B:26:0x00bc, B:27:0x00c4, B:29:0x00ce, B:30:0x00db, B:32:0x00e1, B:34:0x0109, B:36:0x0118, B:35:0x0112), top: B:66:0x008a }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0157 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x015e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x013f A[SYNTHETIC] */
    @Override // java.sql.DatabaseMetaData
    public ResultSet getColumnPrivileges(String str, String str2, String str3, String str4) throws Throwable {
        java.sql.PreparedStatement preparedStatementPrepareMetaDataSafeStatement;
        ResultSet resultSet;
        String str5;
        ResultSet resultSetExecuteQuery;
        String string;
        String string2;
        String string3;
        String string4;
        String str6;
        StringBuilder sb;
        String string5;
        String string6;
        StringTokenizer stringTokenizer;
        byte[][] bArr;
        int i = 8;
        int i2 = 1;
        int i3 = 2;
        int i4 = 3;
        int i5 = 4;
        int i6 = 6;
        int i7 = 7;
        Field[] fieldArr = {new Field(BuildConfig.FLAVOR, "TABLE_CAT", 1, 64), new Field(BuildConfig.FLAVOR, "TABLE_SCHEM", 1, 1), new Field(BuildConfig.FLAVOR, "TABLE_NAME", 1, 64), new Field(BuildConfig.FLAVOR, "COLUMN_NAME", 1, 64), new Field(BuildConfig.FLAVOR, "GRANTOR", 1, 77), new Field(BuildConfig.FLAVOR, "GRANTEE", 1, 77), new Field(BuildConfig.FLAVOR, "PRIVILEGE", 1, 64), new Field(BuildConfig.FLAVOR, "IS_GRANTABLE", 1, 3)};
        ArrayList<ResultSetRow> arrayList = new ArrayList<>();
        try {
            preparedStatementPrepareMetaDataSafeStatement = prepareMetaDataSafeStatement("SELECT c.host, c.db, t.grantor, c.user, c.table_name, c.column_name, c.column_priv FROM mysql.columns_priv c, mysql.tables_priv t WHERE c.host = t.host AND c.db = t.db AND c.table_name = t.table_name AND c.db LIKE ? AND c.table_name = ? AND c.column_name LIKE ?");
            if (str == null) {
                str5 = "%";
                preparedStatementPrepareMetaDataSafeStatement.setString(1, str5);
                preparedStatementPrepareMetaDataSafeStatement.setString(2, str3);
                preparedStatementPrepareMetaDataSafeStatement.setString(3, str4);
                resultSetExecuteQuery = preparedStatementPrepareMetaDataSafeStatement.executeQuery();
                while (resultSetExecuteQuery.next()) {
                    string = resultSetExecuteQuery.getString(i2);
                    string2 = resultSetExecuteQuery.getString(i3);
                    string3 = resultSetExecuteQuery.getString(i4);
                    string4 = resultSetExecuteQuery.getString(i5);
                    if (string4 != null) {
                        str6 = "%";
                    } else {
                        str6 = "%";
                    }
                    sb = new StringBuilder(str6);
                    if (string != null) {
                        sb.append("@");
                        sb.append(string);
                    }
                    string5 = resultSetExecuteQuery.getString(i6);
                    string6 = resultSetExecuteQuery.getString(i7);
                    if (string6 != null) {
                        stringTokenizer = new StringTokenizer(string6.toUpperCase(Locale.ENGLISH), ",");
                        while (stringTokenizer.hasMoreTokens()) {
                            String strTrim = stringTokenizer.nextToken().trim();
                            bArr = new byte[i][];
                            bArr[0] = s2b(string2);
                            bArr[1] = null;
                            bArr[2] = s2b(str3);
                            bArr[3] = s2b(string5);
                            if (string3 != null) {
                                bArr[4] = s2b(string3);
                            } else {
                                bArr[4] = null;
                            }
                            bArr[5] = s2b(sb.toString());
                            bArr[6] = s2b(strTrim);
                            bArr[7] = null;
                            arrayList.add(new ByteArrayRow(bArr, getExceptionInterceptor()));
                            i = 8;
                        }
                    }
                    i = 8;
                    i7 = 7;
                    i2 = 1;
                    i6 = 6;
                    i3 = 2;
                    i4 = 3;
                    i5 = 4;
                }
                if (resultSetExecuteQuery != null) {
                    resultSetExecuteQuery.close();
                }
                if (preparedStatementPrepareMetaDataSafeStatement != null) {
                    preparedStatementPrepareMetaDataSafeStatement.close();
                }
                return buildResultSet(fieldArr, arrayList);
            }
            try {
                if (str.length() != 0) {
                    str5 = str;
                } else {
                    str5 = "%";
                }
                try {
                    preparedStatementPrepareMetaDataSafeStatement.setString(1, str5);
                    preparedStatementPrepareMetaDataSafeStatement.setString(2, str3);
                    preparedStatementPrepareMetaDataSafeStatement.setString(3, str4);
                    resultSetExecuteQuery = preparedStatementPrepareMetaDataSafeStatement.executeQuery();
                    while (resultSetExecuteQuery.next()) {
                        try {
                            string = resultSetExecuteQuery.getString(i2);
                            string2 = resultSetExecuteQuery.getString(i3);
                            string3 = resultSetExecuteQuery.getString(i4);
                            string4 = resultSetExecuteQuery.getString(i5);
                            if (string4 != null || string4.length() == 0) {
                                str6 = "%";
                            } else {
                                str6 = string4;
                            }
                            sb = new StringBuilder(str6);
                            if (string != null && this.conn.getUseHostsInPrivileges()) {
                                sb.append("@");
                                sb.append(string);
                            }
                            string5 = resultSetExecuteQuery.getString(i6);
                            string6 = resultSetExecuteQuery.getString(i7);
                            if (string6 != null) {
                                stringTokenizer = new StringTokenizer(string6.toUpperCase(Locale.ENGLISH), ",");
                                while (stringTokenizer.hasMoreTokens()) {
                                    String strTrim2 = stringTokenizer.nextToken().trim();
                                    bArr = new byte[i][];
                                    bArr[0] = s2b(string2);
                                    bArr[1] = null;
                                    bArr[2] = s2b(str3);
                                    bArr[3] = s2b(string5);
                                    if (string3 != null) {
                                        bArr[4] = s2b(string3);
                                    } else {
                                        bArr[4] = null;
                                    }
                                    bArr[5] = s2b(sb.toString());
                                    bArr[6] = s2b(strTrim2);
                                    bArr[7] = null;
                                    arrayList.add(new ByteArrayRow(bArr, getExceptionInterceptor()));
                                    i = 8;
                                }
                            }
                            i = 8;
                            i7 = 7;
                            i2 = 1;
                            i6 = 6;
                            i3 = 2;
                            i4 = 3;
                            i5 = 4;
                        } catch (Throwable th) {
                            th = th;
                            resultSet = resultSetExecuteQuery;
                        }
                    }
                    if (resultSetExecuteQuery != null) {
                        try {
                            resultSetExecuteQuery.close();
                        } catch (Exception unused) {
                        }
                    }
                    if (preparedStatementPrepareMetaDataSafeStatement != null) {
                        try {
                            preparedStatementPrepareMetaDataSafeStatement.close();
                        } catch (Exception unused2) {
                        }
                    }
                    return buildResultSet(fieldArr, arrayList);
                } catch (Throwable th2) {
                    th = th2;
                    resultSet = null;
                }
            } catch (Throwable th3) {
                th = th3;
                resultSet = null;
            }
        } catch (Throwable th4) {
            th = th4;
            preparedStatementPrepareMetaDataSafeStatement = null;
            resultSet = null;
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception unused3) {
            }
        }
        if (preparedStatementPrepareMetaDataSafeStatement == null) {
            throw th;
        }
        try {
            preparedStatementPrepareMetaDataSafeStatement.close();
            throw th;
        } catch (Exception unused4) {
            throw th;
        }
    }

    public int getColumnType(boolean z, boolean z2, boolean z3, boolean z4) {
        if (z2 && z) {
            return 2;
        }
        if (z2) {
            return 1;
        }
        if (z) {
            return 4;
        }
        return z3 ? 5 : 0;
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getColumns(String str, final String str2, final String str3, String str4) throws SQLException {
        if (str4 == null) {
            if (!this.conn.getNullNamePatternMatchesAll()) {
                throw SQLError.createSQLException("Column name pattern can not be NULL or empty.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            str4 = "%";
        }
        final String str5 = str4;
        Field[] fieldArrCreateColumnsFields = createColumnsFields();
        final ArrayList<ResultSetRow> arrayList = new ArrayList<>();
        final java.sql.Statement metadataSafeStatement = this.conn.getMetadataSafeStatement();
        try {
            new IterateBlock<String>(getCatalogIterator(str)) { // from class: com.mysql.jdbc.DatabaseMetaData.2
                /* JADX WARN: Code duplicated, block: B:186:0x03b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:84:0x01fc  */
                @Override // com.mysql.jdbc.IterateBlock
                public void forEach(String str6) throws Throwable {
                    Throwable th;
                    ResultSet resultSet;
                    ResultSet resultSet2;
                    boolean z;
                    HashMap map;
                    int i;
                    String str7;
                    Throwable th2;
                    ResultSet resultSet3;
                    String str8 = str6;
                    String str9 = " FROM ";
                    String str10 = "COLUMNS FROM ";
                    String str11 = "SHOW ";
                    ArrayList arrayList2 = new ArrayList();
                    String str12 = str3;
                    int i2 = 0;
                    if (str12 == null) {
                        try {
                            ResultSet tables = DatabaseMetaData.this.getTables(str8, str2, "%", new String[0]);
                            while (tables.next()) {
                                try {
                                    arrayList2.add(tables.getString("TABLE_NAME"));
                                } catch (Throwable th3) {
                                    th = th3;
                                    resultSet = tables;
                                    if (resultSet == null) {
                                        throw th;
                                    }
                                    try {
                                        resultSet.close();
                                        throw th;
                                    } catch (Exception e) {
                                        AssertionFailedException.shouldNotHappen(e);
                                        throw th;
                                    }
                                }
                            }
                            if (tables != null) {
                                try {
                                    tables.close();
                                } catch (Exception e2) {
                                    AssertionFailedException.shouldNotHappen(e2);
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            resultSet = null;
                        }
                    } else {
                        try {
                            ResultSet tables2 = DatabaseMetaData.this.getTables(str8, str2, str12, new String[0]);
                            while (tables2.next()) {
                                try {
                                    arrayList2.add(tables2.getString("TABLE_NAME"));
                                } catch (Throwable th5) {
                                    th2 = th5;
                                    resultSet3 = tables2;
                                    if (resultSet3 == null) {
                                        throw th2;
                                    }
                                    try {
                                        resultSet3.close();
                                        throw th2;
                                    } catch (SQLException e3) {
                                        AssertionFailedException.shouldNotHappen(e3);
                                        throw th2;
                                    }
                                }
                            }
                            if (tables2 != null) {
                                try {
                                    tables2.close();
                                } catch (SQLException e4) {
                                    AssertionFailedException.shouldNotHappen(e4);
                                }
                            }
                        } catch (Throwable th6) {
                            th2 = th6;
                            resultSet3 = null;
                        }
                    }
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        String str13 = (String) it.next();
                        try {
                            StringBuilder sb = new StringBuilder(str11);
                            char c = 1;
                            if (DatabaseMetaData.this.conn.versionMeetsMinimum(4, 1, i2)) {
                                sb.append("FULL ");
                            }
                            sb.append(str10);
                            DatabaseMetaData databaseMetaData = DatabaseMetaData.this;
                            sb.append(StringUtils.quoteIdentifier(str13, databaseMetaData.quotedId, databaseMetaData.conn.getPedantic()));
                            sb.append(str9);
                            DatabaseMetaData databaseMetaData2 = DatabaseMetaData.this;
                            sb.append(StringUtils.quoteIdentifier(str8, databaseMetaData2.quotedId, databaseMetaData2.conn.getPedantic()));
                            sb.append(" LIKE ");
                            sb.append(StringUtils.quoteIdentifier(str5, "'", true));
                            if (str5.equals("%")) {
                                z = false;
                                map = null;
                                resultSet2 = null;
                            } else {
                                StringBuilder sb2 = new StringBuilder(str11);
                                if (DatabaseMetaData.this.conn.versionMeetsMinimum(4, 1, 0)) {
                                    sb2.append("FULL ");
                                }
                                sb2.append(str10);
                                DatabaseMetaData databaseMetaData3 = DatabaseMetaData.this;
                                sb2.append(StringUtils.quoteIdentifier(str13, databaseMetaData3.quotedId, databaseMetaData3.conn.getPedantic()));
                                sb2.append(str9);
                                DatabaseMetaData databaseMetaData4 = DatabaseMetaData.this;
                                sb2.append(StringUtils.quoteIdentifier(str8, databaseMetaData4.quotedId, databaseMetaData4.conn.getPedantic()));
                                ResultSet resultSetExecuteQuery = metadataSafeStatement.executeQuery(sb2.toString());
                                try {
                                    map = new HashMap();
                                    int i3 = 1;
                                    while (resultSetExecuteQuery.next()) {
                                        int i4 = i3 + 1;
                                        map.put(resultSetExecuteQuery.getString("Field"), Integer.valueOf(i3));
                                        i3 = i4;
                                    }
                                    resultSet2 = resultSetExecuteQuery;
                                    z = true;
                                } catch (Throwable th7) {
                                    th = th7;
                                    resultSet2 = resultSetExecuteQuery;
                                    if (resultSet2 != null) {
                                        try {
                                            resultSet2.close();
                                        } catch (Exception unused) {
                                        }
                                    }
                                    throw th;
                                }
                            }
                            try {
                                ResultSet resultSetExecuteQuery2 = metadataSafeStatement.executeQuery(sb.toString());
                                int i5 = 1;
                                while (resultSetExecuteQuery2.next()) {
                                    try {
                                        byte[][] bArr = new byte[24][];
                                        bArr[0] = DatabaseMetaData.this.s2b(str8);
                                        bArr[c] = null;
                                        bArr[2] = DatabaseMetaData.this.s2b(str13);
                                        bArr[3] = resultSetExecuteQuery2.getBytes("Field");
                                        Iterator it2 = it;
                                        TypeDescriptor typeDescriptor = DatabaseMetaData.this.new TypeDescriptor(resultSetExecuteQuery2.getString("Type"), resultSetExecuteQuery2.getString("Null"));
                                        bArr[4] = Short.toString(typeDescriptor.dataType).getBytes();
                                        bArr[5] = DatabaseMetaData.this.s2b(typeDescriptor.typeName);
                                        String str14 = str9;
                                        if (typeDescriptor.columnSize == null) {
                                            bArr[6] = null;
                                        } else {
                                            String string = resultSetExecuteQuery2.getString("Collation");
                                            if (string == null || !("TEXT".equals(typeDescriptor.typeName) || "TINYTEXT".equals(typeDescriptor.typeName) || "MEDIUMTEXT".equals(typeDescriptor.typeName))) {
                                                i = 1;
                                            } else if (string.indexOf("ucs2") > -1 || string.indexOf("utf16") > -1) {
                                                i = 2;
                                            } else if (string.indexOf("utf32") > -1) {
                                                i = 4;
                                            } else {
                                                i = 1;
                                            }
                                            bArr[6] = i == 1 ? DatabaseMetaData.this.s2b(typeDescriptor.columnSize.toString()) : DatabaseMetaData.this.s2b(Integer.valueOf(typeDescriptor.columnSize.intValue() / i).toString());
                                        }
                                        bArr[7] = DatabaseMetaData.this.s2b(Integer.toString(typeDescriptor.bufferLength));
                                        Integer num = typeDescriptor.decimalDigits;
                                        bArr[8] = num == null ? null : DatabaseMetaData.this.s2b(num.toString());
                                        bArr[9] = DatabaseMetaData.this.s2b(Integer.toString(typeDescriptor.numPrecRadix));
                                        bArr[10] = DatabaseMetaData.this.s2b(Integer.toString(typeDescriptor.nullability));
                                        try {
                                            str7 = str10;
                                            try {
                                                if (DatabaseMetaData.this.conn.versionMeetsMinimum(4, 1, 0)) {
                                                    bArr[11] = resultSetExecuteQuery2.getBytes("Comment");
                                                } else {
                                                    bArr[11] = resultSetExecuteQuery2.getBytes("Extra");
                                                }
                                            } catch (Exception unused2) {
                                                bArr[11] = new byte[0];
                                            }
                                        } catch (Exception unused3) {
                                            str7 = str10;
                                        }
                                        bArr[12] = resultSetExecuteQuery2.getBytes("Default");
                                        bArr[13] = new byte[]{48};
                                        bArr[14] = new byte[]{48};
                                        if (StringUtils.indexOfIgnoreCase(typeDescriptor.typeName, "CHAR") == -1 && StringUtils.indexOfIgnoreCase(typeDescriptor.typeName, "BLOB") == -1 && StringUtils.indexOfIgnoreCase(typeDescriptor.typeName, "TEXT") == -1 && StringUtils.indexOfIgnoreCase(typeDescriptor.typeName, "BINARY") == -1) {
                                            bArr[15] = null;
                                        } else {
                                            bArr[15] = bArr[6];
                                        }
                                        if (z) {
                                            Integer num2 = (Integer) map.get(resultSetExecuteQuery2.getString("Field"));
                                            if (num2 == null) {
                                                throw SQLError.createSQLException("Can not find column in full column list to determine true ordinal position.", SQLError.SQL_STATE_GENERAL_ERROR, DatabaseMetaData.this.getExceptionInterceptor());
                                            }
                                            bArr[16] = num2.toString().getBytes();
                                        } else {
                                            bArr[16] = Integer.toString(i5).getBytes();
                                            i5++;
                                        }
                                        bArr[17] = DatabaseMetaData.this.s2b(typeDescriptor.isNullable);
                                        bArr[18] = null;
                                        bArr[19] = null;
                                        bArr[20] = null;
                                        bArr[21] = null;
                                        bArr[22] = DatabaseMetaData.this.s2b(BuildConfig.FLAVOR);
                                        String string2 = resultSetExecuteQuery2.getString("Extra");
                                        if (string2 != null) {
                                            bArr[22] = DatabaseMetaData.this.s2b(StringUtils.indexOfIgnoreCase(string2, "auto_increment") != -1 ? "YES" : "NO");
                                            bArr[23] = DatabaseMetaData.this.s2b(StringUtils.indexOfIgnoreCase(string2, "generated") != -1 ? "YES" : "NO");
                                        }
                                        arrayList.add(new ByteArrayRow(bArr, DatabaseMetaData.this.getExceptionInterceptor()));
                                        str8 = str6;
                                        str10 = str7;
                                        it = it2;
                                        str9 = str14;
                                        c = 1;
                                    } catch (Throwable th8) {
                                        th = th8;
                                        resultSet2 = resultSetExecuteQuery2;
                                        if (resultSet2 != null) {
                                            resultSet2.close();
                                        }
                                        throw th;
                                    }
                                }
                                Iterator it3 = it;
                                String str15 = str9;
                                String str16 = str10;
                                if (resultSetExecuteQuery2 != null) {
                                    try {
                                        resultSetExecuteQuery2.close();
                                    } catch (Exception unused4) {
                                    }
                                }
                                str8 = str6;
                                str11 = str11;
                                str10 = str16;
                                it = it3;
                                str9 = str15;
                                i2 = 0;
                            } catch (Throwable th9) {
                                th = th9;
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            resultSet2 = null;
                        }
                    }
                }
            }.doForAll();
            return buildResultSet(fieldArrCreateColumnsFields, arrayList);
        } finally {
            if (metadataSafeStatement != null) {
                metadataSafeStatement.close();
            }
        }
    }

    @Override // java.sql.DatabaseMetaData
    public java.sql.Connection getConnection() throws SQLException {
        return this.conn;
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getCrossReference(final String str, final String str2, final String str3, final String str4, final String str5, final String str6) throws SQLException {
        if (str3 == null) {
            throw SQLError.createSQLException("Table not specified.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
        Field[] fieldArrCreateFkMetadataFields = createFkMetadataFields();
        final ArrayList<ResultSetRow> arrayList = new ArrayList<>();
        if (this.conn.versionMeetsMinimum(3, 23, 0)) {
            final java.sql.Statement metadataSafeStatement = this.conn.getMetadataSafeStatement();
            try {
                new IterateBlock<String>(getCatalogIterator(str4)) { // from class: com.mysql.jdbc.DatabaseMetaData.3
                    /* JADX WARN: Code duplicated, block: B:73:0x01ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    /* JADX WARN: Code duplicated, block: B:94:? A[SYNTHETIC] */
                    @Override // com.mysql.jdbc.IterateBlock
                    public void forEach(String str7) throws Throwable {
                        Throwable th;
                        ResultSet resultSetExtractForeignKeyFromCreateTable;
                        String strTrim;
                        ResultSet resultSet = null;
                        try {
                            if (DatabaseMetaData.this.conn.versionMeetsMinimum(3, 23, 50)) {
                                try {
                                    resultSetExtractForeignKeyFromCreateTable = DatabaseMetaData.this.extractForeignKeyFromCreateTable(str7, null);
                                } catch (Throwable th2) {
                                    th = th2;
                                    th = th;
                                    if (resultSet != null) {
                                        throw th;
                                    }
                                    try {
                                        resultSet.close();
                                        throw th;
                                    } catch (Exception e) {
                                        AssertionFailedException.shouldNotHappen(e);
                                        throw th;
                                    }
                                }
                            } else {
                                StringBuilder sb = new StringBuilder("SHOW TABLE STATUS FROM ");
                                DatabaseMetaData databaseMetaData = DatabaseMetaData.this;
                                sb.append(StringUtils.quoteIdentifier(str7, databaseMetaData.quotedId, databaseMetaData.conn.getPedantic()));
                                resultSetExtractForeignKeyFromCreateTable = metadataSafeStatement.executeQuery(sb.toString());
                            }
                            ResultSet resultSet2 = resultSetExtractForeignKeyFromCreateTable;
                            try {
                                String tableNameWithCase = DatabaseMetaData.this.getTableNameWithCase(str6);
                                String tableNameWithCase2 = DatabaseMetaData.this.getTableNameWithCase(str3);
                                while (resultSet2.next()) {
                                    String string = resultSet2.getString("Type");
                                    if (string != null && ((string.equalsIgnoreCase("innodb") || string.equalsIgnoreCase(DatabaseMetaData.SUPPORTS_FK)) && (strTrim = resultSet2.getString("Comment").trim()) != null)) {
                                        StringTokenizer stringTokenizer = new StringTokenizer(strTrim, ";", false);
                                        if (stringTokenizer.hasMoreTokens()) {
                                            stringTokenizer.nextToken();
                                        }
                                        while (stringTokenizer.hasMoreTokens()) {
                                            String strNextToken = stringTokenizer.nextToken();
                                            LocalAndReferencedColumns tableStatusIntoLocalAndReferencedColumns = DatabaseMetaData.this.parseTableStatusIntoLocalAndReferencedColumns(strNextToken);
                                            Iterator<String> it = tableStatusIntoLocalAndReferencedColumns.localColumnsList.iterator();
                                            Iterator<String> it2 = tableStatusIntoLocalAndReferencedColumns.referencedColumnsList.iterator();
                                            int i = 0;
                                            while (it.hasNext()) {
                                                String strUnQuoteIdentifier = StringUtils.unQuoteIdentifier(it.next(), DatabaseMetaData.this.quotedId);
                                                byte[][] bArr = new byte[14][];
                                                String str8 = str4;
                                                bArr[4] = str8 == null ? null : DatabaseMetaData.this.s2b(str8);
                                                String str9 = str5;
                                                bArr[5] = str9 == null ? null : DatabaseMetaData.this.s2b(str9);
                                                String string2 = resultSet2.getString("Name");
                                                if (string2.compareTo(tableNameWithCase) == 0) {
                                                    bArr[6] = DatabaseMetaData.this.s2b(string2);
                                                    bArr[7] = DatabaseMetaData.this.s2b(strUnQuoteIdentifier);
                                                    String str10 = str;
                                                    bArr[0] = str10 == null ? null : DatabaseMetaData.this.s2b(str10);
                                                    String str11 = str2;
                                                    bArr[1] = str11 == null ? null : DatabaseMetaData.this.s2b(str11);
                                                    if (tableStatusIntoLocalAndReferencedColumns.referencedTable.compareTo(tableNameWithCase2) == 0) {
                                                        bArr[2] = DatabaseMetaData.this.s2b(tableStatusIntoLocalAndReferencedColumns.referencedTable);
                                                        bArr[3] = DatabaseMetaData.this.s2b(StringUtils.unQuoteIdentifier(it2.next(), DatabaseMetaData.this.quotedId));
                                                        bArr[8] = Integer.toString(i).getBytes();
                                                        int[] foreignKeyActions = DatabaseMetaData.this.getForeignKeyActions(strNextToken);
                                                        bArr[9] = Integer.toString(foreignKeyActions[1]).getBytes();
                                                        bArr[10] = Integer.toString(foreignKeyActions[0]).getBytes();
                                                        bArr[11] = null;
                                                        bArr[12] = null;
                                                        bArr[13] = Integer.toString(7).getBytes();
                                                        arrayList.add(new ByteArrayRow(bArr, DatabaseMetaData.this.getExceptionInterceptor()));
                                                        i++;
                                                        resultSet = null;
                                                    }
                                                }
                                                resultSet = null;
                                            }
                                        }
                                    }
                                    resultSet = resultSet;
                                }
                                if (resultSet2 != null) {
                                    try {
                                        resultSet2.close();
                                    } catch (Exception e2) {
                                        AssertionFailedException.shouldNotHappen(e2);
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                resultSet = resultSet2;
                                th = th;
                                if (resultSet != null) {
                                    throw th;
                                }
                                resultSet.close();
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    }
                }.doForAll();
            } finally {
                if (metadataSafeStatement != null) {
                    metadataSafeStatement.close();
                }
            }
        }
        return buildResultSet(fieldArrCreateFkMetadataFields, arrayList);
    }

    @Override // java.sql.DatabaseMetaData
    public int getDatabaseMajorVersion() throws SQLException {
        return this.conn.getServerMajorVersion();
    }

    @Override // java.sql.DatabaseMetaData
    public int getDatabaseMinorVersion() throws SQLException {
        return this.conn.getServerMinorVersion();
    }

    @Override // java.sql.DatabaseMetaData
    public String getDatabaseProductName() throws SQLException {
        return "MySQL";
    }

    @Override // java.sql.DatabaseMetaData
    public String getDatabaseProductVersion() throws SQLException {
        return this.conn.getServerVersion();
    }

    @Override // java.sql.DatabaseMetaData
    public int getDefaultTransactionIsolation() throws SQLException {
        return this.conn.supportsIsolationLevel() ? 2 : 0;
    }

    @Override // java.sql.DatabaseMetaData
    public int getDriverMajorVersion() {
        return NonRegisteringDriver.getMajorVersionInternal();
    }

    @Override // java.sql.DatabaseMetaData
    public int getDriverMinorVersion() {
        return NonRegisteringDriver.getMinorVersionInternal();
    }

    @Override // java.sql.DatabaseMetaData
    public String getDriverName() throws SQLException {
        return NonRegisteringDriver.NAME;
    }

    @Override // java.sql.DatabaseMetaData
    public String getDriverVersion() throws SQLException {
        return "mysql-connector-java-5.1.47 ( Revision: fe1903b1ecb4a96a917f7ed3190d80c049b1de29 )";
    }

    public ExceptionInterceptor getExceptionInterceptor() {
        return this.exceptionInterceptor;
    }

    public void getExportKeyResults(String str, String str2, String str3, List<ResultSetRow> list, String str4) throws SQLException {
        getResultsImpl(str, str2, str3, list, str4, true);
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getExportedKeys(String str, String str2, final String str3) throws SQLException {
        if (str3 == null) {
            throw SQLError.createSQLException("Table not specified.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
        Field[] fieldArrCreateFkMetadataFields = createFkMetadataFields();
        final ArrayList<ResultSetRow> arrayList = new ArrayList<>();
        if (this.conn.versionMeetsMinimum(3, 23, 0)) {
            final java.sql.Statement metadataSafeStatement = this.conn.getMetadataSafeStatement();
            try {
                new IterateBlock<String>(getCatalogIterator(str)) { // from class: com.mysql.jdbc.DatabaseMetaData.4
                    @Override // com.mysql.jdbc.IterateBlock
                    public void forEach(String str4) throws SQLException {
                        ResultSet resultSetExecuteQuery = null;
                        try {
                            if (DatabaseMetaData.this.conn.versionMeetsMinimum(3, 23, 50)) {
                                resultSetExecuteQuery = DatabaseMetaData.this.extractForeignKeyFromCreateTable(str4, null);
                            } else {
                                StringBuilder sb = new StringBuilder("SHOW TABLE STATUS FROM ");
                                DatabaseMetaData databaseMetaData = DatabaseMetaData.this;
                                sb.append(StringUtils.quoteIdentifier(str4, databaseMetaData.quotedId, databaseMetaData.conn.getPedantic()));
                                resultSetExecuteQuery = metadataSafeStatement.executeQuery(sb.toString());
                            }
                            String tableNameWithCase = DatabaseMetaData.this.getTableNameWithCase(str3);
                            while (resultSetExecuteQuery.next()) {
                                String string = resultSetExecuteQuery.getString("Type");
                                if (string != null && (string.equalsIgnoreCase("innodb") || string.equalsIgnoreCase(DatabaseMetaData.SUPPORTS_FK))) {
                                    String strTrim = resultSetExecuteQuery.getString("Comment").trim();
                                    if (strTrim != null) {
                                        StringTokenizer stringTokenizer = new StringTokenizer(strTrim, ";", false);
                                        if (stringTokenizer.hasMoreTokens()) {
                                            stringTokenizer.nextToken();
                                            while (stringTokenizer.hasMoreTokens()) {
                                                DatabaseMetaData.this.getExportKeyResults(str4, tableNameWithCase, stringTokenizer.nextToken(), arrayList, resultSetExecuteQuery.getString("Name"));
                                            }
                                        }
                                    }
                                }
                            }
                        } finally {
                            if (resultSetExecuteQuery != null) {
                                try {
                                    resultSetExecuteQuery.close();
                                } catch (SQLException e) {
                                    AssertionFailedException.shouldNotHappen(e);
                                }
                            }
                        }
                    }
                }.doForAll();
            } finally {
                if (metadataSafeStatement != null) {
                    metadataSafeStatement.close();
                }
            }
        }
        return buildResultSet(fieldArrCreateFkMetadataFields, arrayList);
    }

    @Override // java.sql.DatabaseMetaData
    public String getExtraNameCharacters() throws SQLException {
        return "#@";
    }

    public int[] getForeignKeyActions(String str) {
        int[] iArr = {3, 3};
        int iLastIndexOf = str.lastIndexOf(")");
        if (iLastIndexOf != str.length() - 1) {
            String upperCase = str.substring(iLastIndexOf + 1).trim().toUpperCase(Locale.ENGLISH);
            iArr[0] = getCascadeDeleteOption(upperCase);
            iArr[1] = getCascadeUpdateOption(upperCase);
        }
        return iArr;
    }

    public String getFullyQualifiedName(String str, String str2) {
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        return StringUtils.quoteIdentifier(str, this.quotedId, this.conn.getPedantic()) + '.' + StringUtils.quoteIdentifier(str2, this.quotedId, this.conn.getPedantic());
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getFunctionColumns(String str, String str2, String str3, String str4) throws SQLException {
        return getProcedureOrFunctionColumns(createFunctionColumnsFields(), str, str2, str3, str4, false, true);
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getFunctions(String str, String str2, String str3) throws SQLException {
        return getProceduresAndOrFunctions(new Field[]{new Field(BuildConfig.FLAVOR, "FUNCTION_CAT", 1, 255), new Field(BuildConfig.FLAVOR, "FUNCTION_SCHEM", 1, 255), new Field(BuildConfig.FLAVOR, "FUNCTION_NAME", 1, 255), new Field(BuildConfig.FLAVOR, "REMARKS", 1, 255), new Field(BuildConfig.FLAVOR, "FUNCTION_TYPE", 5, 6), new Field(BuildConfig.FLAVOR, "SPECIFIC_NAME", 1, 255)}, str, str2, str3, false, true);
    }

    @Override // java.sql.DatabaseMetaData
    public String getIdentifierQuoteString() throws SQLException {
        if (this.conn.supportsQuotedIdentifiers()) {
            return this.conn.useAnsiQuotedIdentifiers() ? "\"" : "`";
        }
        return " ";
    }

    public void getImportKeyResults(String str, String str2, String str3, List<ResultSetRow> list) throws SQLException {
        getResultsImpl(str, str2, str3, list, null, false);
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getImportedKeys(String str, String str2, final String str3) throws SQLException {
        if (str3 == null) {
            throw SQLError.createSQLException("Table not specified.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
        Field[] fieldArrCreateFkMetadataFields = createFkMetadataFields();
        final ArrayList<ResultSetRow> arrayList = new ArrayList<>();
        if (this.conn.versionMeetsMinimum(3, 23, 0)) {
            final java.sql.Statement metadataSafeStatement = this.conn.getMetadataSafeStatement();
            try {
                new IterateBlock<String>(getCatalogIterator(str)) { // from class: com.mysql.jdbc.DatabaseMetaData.5
                    @Override // com.mysql.jdbc.IterateBlock
                    public void forEach(String str4) throws SQLException {
                        ResultSet resultSetExecuteQuery = null;
                        try {
                            if (DatabaseMetaData.this.conn.versionMeetsMinimum(3, 23, 50)) {
                                resultSetExecuteQuery = DatabaseMetaData.this.extractForeignKeyFromCreateTable(str4, str3);
                            } else {
                                StringBuilder sb = new StringBuilder("SHOW TABLE STATUS ");
                                sb.append(" FROM ");
                                DatabaseMetaData databaseMetaData = DatabaseMetaData.this;
                                sb.append(StringUtils.quoteIdentifier(str4, databaseMetaData.quotedId, databaseMetaData.conn.getPedantic()));
                                sb.append(" LIKE ");
                                sb.append(StringUtils.quoteIdentifier(str3, "'", true));
                                resultSetExecuteQuery = metadataSafeStatement.executeQuery(sb.toString());
                            }
                            while (resultSetExecuteQuery.next()) {
                                String string = resultSetExecuteQuery.getString("Type");
                                if (string != null && (string.equalsIgnoreCase("innodb") || string.equalsIgnoreCase(DatabaseMetaData.SUPPORTS_FK))) {
                                    String strTrim = resultSetExecuteQuery.getString("Comment").trim();
                                    if (strTrim != null) {
                                        StringTokenizer stringTokenizer = new StringTokenizer(strTrim, ";", false);
                                        if (stringTokenizer.hasMoreTokens()) {
                                            stringTokenizer.nextToken();
                                            while (stringTokenizer.hasMoreTokens()) {
                                                DatabaseMetaData.this.getImportKeyResults(str4, str3, stringTokenizer.nextToken(), arrayList);
                                            }
                                        }
                                    }
                                }
                            }
                        } finally {
                            if (resultSetExecuteQuery != null) {
                                try {
                                    resultSetExecuteQuery.close();
                                } catch (SQLException e) {
                                    AssertionFailedException.shouldNotHappen(e);
                                }
                            }
                        }
                    }
                }.doForAll();
            } finally {
                if (metadataSafeStatement != null) {
                    metadataSafeStatement.close();
                }
            }
        }
        return buildResultSet(fieldArrCreateFkMetadataFields, arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.sql.DatabaseMetaData
    public ResultSet getIndexInfo(String str, String str2, final String str3, final boolean z, boolean z2) throws SQLException {
        Field[] fieldArrCreateIndexInfoFields = createIndexInfoFields();
        final TreeMap treeMap = new TreeMap();
        ArrayList arrayList = new ArrayList();
        final java.sql.Statement metadataSafeStatement = this.conn.getMetadataSafeStatement();
        try {
            new IterateBlock<String>(getCatalogIterator(str)) { // from class: com.mysql.jdbc.DatabaseMetaData.6
                @Override // com.mysql.jdbc.IterateBlock
                public void forEach(String str4) throws Throwable {
                    ResultSet resultSetExecuteQuery;
                    DatabaseMetaData databaseMetaData;
                    String str5;
                    ResultSet resultSet = null;
                    try {
                        StringBuilder sb = new StringBuilder("SHOW INDEX FROM ");
                        String str6 = str3;
                        DatabaseMetaData databaseMetaData2 = DatabaseMetaData.this;
                        sb.append(StringUtils.quoteIdentifier(str6, databaseMetaData2.quotedId, databaseMetaData2.conn.getPedantic()));
                        sb.append(" FROM ");
                        DatabaseMetaData databaseMetaData3 = DatabaseMetaData.this;
                        sb.append(StringUtils.quoteIdentifier(str4, databaseMetaData3.quotedId, databaseMetaData3.conn.getPedantic()));
                        try {
                            resultSetExecuteQuery = metadataSafeStatement.executeQuery(sb.toString());
                        } catch (SQLException e) {
                            int errorCode = e.getErrorCode();
                            if (!SQLError.SQL_STATE_BASE_TABLE_OR_VIEW_NOT_FOUND.equals(e.getSQLState()) && errorCode != 1146) {
                                throw e;
                            }
                            resultSetExecuteQuery = null;
                        }
                        while (resultSetExecuteQuery != null) {
                            try {
                                if (!resultSetExecuteQuery.next()) {
                                    break;
                                }
                                byte[][] bArr = new byte[14][];
                                bArr[0] = str4 == null ? new byte[0] : DatabaseMetaData.this.s2b(str4);
                                bArr[1] = null;
                                bArr[2] = resultSetExecuteQuery.getBytes("Table");
                                boolean z3 = resultSetExecuteQuery.getInt("Non_unique") == 0;
                                if (z3) {
                                    databaseMetaData = DatabaseMetaData.this;
                                    str5 = "false";
                                } else {
                                    databaseMetaData = DatabaseMetaData.this;
                                    str5 = "true";
                                }
                                bArr[3] = databaseMetaData.s2b(str5);
                                bArr[4] = new byte[0];
                                bArr[5] = resultSetExecuteQuery.getBytes("Key_name");
                                bArr[6] = Integer.toString(3).getBytes();
                                bArr[7] = resultSetExecuteQuery.getBytes("Seq_in_index");
                                bArr[8] = resultSetExecuteQuery.getBytes("Column_name");
                                bArr[9] = resultSetExecuteQuery.getBytes("Collation");
                                long j = resultSetExecuteQuery.getLong("Cardinality");
                                if (!Util.isJdbc42() && j > 2147483647L) {
                                    j = 2147483647L;
                                }
                                bArr[10] = DatabaseMetaData.this.s2b(String.valueOf(j));
                                bArr[11] = DatabaseMetaData.this.s2b("0");
                                bArr[12] = null;
                                IndexMetaDataKey indexMetaDataKey = DatabaseMetaData.this.new IndexMetaDataKey(!z3, (short) 3, resultSetExecuteQuery.getString("Key_name").toLowerCase(), resultSetExecuteQuery.getShort("Seq_in_index"));
                                if (!z) {
                                    treeMap.put(indexMetaDataKey, new ByteArrayRow(bArr, DatabaseMetaData.this.getExceptionInterceptor()));
                                } else if (z3) {
                                    treeMap.put(indexMetaDataKey, new ByteArrayRow(bArr, DatabaseMetaData.this.getExceptionInterceptor()));
                                }
                            } catch (Throwable th) {
                                th = th;
                                resultSet = resultSetExecuteQuery;
                                if (resultSet != null) {
                                    try {
                                        resultSet.close();
                                    } catch (Exception unused) {
                                    }
                                }
                                throw th;
                            }
                        }
                        if (resultSetExecuteQuery != null) {
                            try {
                                resultSetExecuteQuery.close();
                            } catch (Exception unused2) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }.doForAll();
            Iterator it = treeMap.values().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            return buildResultSet(fieldArrCreateIndexInfoFields, arrayList);
        } finally {
            if (metadataSafeStatement != null) {
                metadataSafeStatement.close();
            }
        }
    }

    public int getJDBC4FunctionNoTableConstant() {
        return 0;
    }

    @Override // java.sql.DatabaseMetaData
    public int getJDBCMajorVersion() throws SQLException {
        return 4;
    }

    @Override // java.sql.DatabaseMetaData
    public int getJDBCMinorVersion() throws SQLException {
        return 0;
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxBinaryLiteralLength() throws SQLException {
        return 16777208;
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxCatalogNameLength() throws SQLException {
        return 32;
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxCharLiteralLength() throws SQLException {
        return 16777208;
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxColumnNameLength() throws SQLException {
        return 64;
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxColumnsInGroupBy() throws SQLException {
        return 64;
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxColumnsInIndex() throws SQLException {
        return 16;
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxColumnsInOrderBy() throws SQLException {
        return 64;
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxColumnsInSelect() throws SQLException {
        return 256;
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxColumnsInTable() throws SQLException {
        return 512;
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxConnections() throws SQLException {
        return 0;
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxCursorNameLength() throws SQLException {
        return 64;
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxIndexLength() throws SQLException {
        return 256;
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxProcedureNameLength() throws SQLException {
        return 0;
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxRowSize() throws SQLException {
        return 2147483639;
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxSchemaNameLength() throws SQLException {
        return 0;
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxStatementLength() throws SQLException {
        return MysqlIO.getMaxBuf() - 4;
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxStatements() throws SQLException {
        return 0;
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxTableNameLength() throws SQLException {
        return 64;
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxTablesInSelect() throws SQLException {
        return 256;
    }

    @Override // java.sql.DatabaseMetaData
    public int getMaxUserNameLength() throws SQLException {
        return 16;
    }

    @Override // java.sql.DatabaseMetaData
    public String getNumericFunctions() throws SQLException {
        return "ABS,ACOS,ASIN,ATAN,ATAN2,BIT_COUNT,CEILING,COS,COT,DEGREES,EXP,FLOOR,LOG,LOG10,MAX,MIN,MOD,PI,POW,POWER,RADIANS,RAND,ROUND,SIN,SQRT,TAN,TRUNCATE";
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getPrimaryKeys(String str, String str2, final String str3) throws SQLException {
        Field[] fieldArr = {new Field(BuildConfig.FLAVOR, "TABLE_CAT", 1, 255), new Field(BuildConfig.FLAVOR, "TABLE_SCHEM", 1, 0), new Field(BuildConfig.FLAVOR, "TABLE_NAME", 1, 255), new Field(BuildConfig.FLAVOR, "COLUMN_NAME", 1, 32), new Field(BuildConfig.FLAVOR, "KEY_SEQ", 5, 5), new Field(BuildConfig.FLAVOR, "PK_NAME", 1, 32)};
        if (str3 == null) {
            throw SQLError.createSQLException("Table not specified.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
        final ArrayList<ResultSetRow> arrayList = new ArrayList<>();
        final java.sql.Statement metadataSafeStatement = this.conn.getMetadataSafeStatement();
        try {
            new IterateBlock<String>(getCatalogIterator(str)) { // from class: com.mysql.jdbc.DatabaseMetaData.7
                @Override // com.mysql.jdbc.IterateBlock
                public void forEach(String str4) throws Throwable {
                    ResultSet resultSet = null;
                    try {
                        StringBuilder sb = new StringBuilder("SHOW KEYS FROM ");
                        String str5 = str3;
                        DatabaseMetaData databaseMetaData = DatabaseMetaData.this;
                        sb.append(StringUtils.quoteIdentifier(str5, databaseMetaData.quotedId, databaseMetaData.conn.getPedantic()));
                        sb.append(" FROM ");
                        DatabaseMetaData databaseMetaData2 = DatabaseMetaData.this;
                        sb.append(StringUtils.quoteIdentifier(str4, databaseMetaData2.quotedId, databaseMetaData2.conn.getPedantic()));
                        ResultSet resultSetExecuteQuery = metadataSafeStatement.executeQuery(sb.toString());
                        try {
                            TreeMap treeMap = new TreeMap();
                            while (resultSetExecuteQuery.next()) {
                                String string = resultSetExecuteQuery.getString("Key_name");
                                if (string != null && (string.equalsIgnoreCase("PRIMARY") || string.equalsIgnoreCase("PRI"))) {
                                    byte[][] bArr = new byte[6][];
                                    bArr[0] = str4 == null ? new byte[0] : DatabaseMetaData.this.s2b(str4);
                                    bArr[1] = null;
                                    bArr[2] = DatabaseMetaData.this.s2b(str3);
                                    String string2 = resultSetExecuteQuery.getString("Column_name");
                                    bArr[3] = DatabaseMetaData.this.s2b(string2);
                                    bArr[4] = DatabaseMetaData.this.s2b(resultSetExecuteQuery.getString("Seq_in_index"));
                                    bArr[5] = DatabaseMetaData.this.s2b(string);
                                    treeMap.put(string2, bArr);
                                }
                            }
                            Iterator it = treeMap.values().iterator();
                            while (it.hasNext()) {
                                arrayList.add(new ByteArrayRow((byte[][]) it.next(), DatabaseMetaData.this.getExceptionInterceptor()));
                            }
                            if (resultSetExecuteQuery != null) {
                                try {
                                    resultSetExecuteQuery.close();
                                } catch (Exception unused) {
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            resultSet = resultSetExecuteQuery;
                            if (resultSet != null) {
                                try {
                                    resultSet.close();
                                } catch (Exception unused2) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }.doForAll();
            return buildResultSet(fieldArr, arrayList);
        } finally {
            if (metadataSafeStatement != null) {
                metadataSafeStatement.close();
            }
        }
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getProcedureColumns(String str, String str2, String str3, String str4) throws SQLException {
        return getProcedureOrFunctionColumns(createProcedureColumnsFields(), str, str2, str3, str4, true, true);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002b  */
    /* JADX WARN: Code duplicated, block: B:15:0x002f A[Catch: all -> 0x0023, TryCatch #2 {all -> 0x0023, blocks: (B:6:0x0016, B:8:0x001e, B:19:0x0052, B:15:0x002f, B:17:0x0044), top: B:74:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x0044 A[Catch: all -> 0x0023, TryCatch #2 {all -> 0x0023, blocks: (B:6:0x0016, B:8:0x001e, B:19:0x0052, B:15:0x002f, B:17:0x0044), top: B:74:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0051  */
    /* JADX WARN: Code duplicated, block: B:23:0x006b A[Catch: all -> 0x00a1, TryCatch #1 {all -> 0x00a1, blocks: (B:21:0x0065, B:23:0x006b, B:25:0x0082, B:27:0x0087, B:26:0x0085, B:30:0x0092), top: B:72:0x0065 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0082 A[Catch: all -> 0x00a1, TryCatch #1 {all -> 0x00a1, blocks: (B:21:0x0065, B:23:0x006b, B:25:0x0082, B:27:0x0087, B:26:0x0085, B:30:0x0092), top: B:72:0x0065 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x0085 A[Catch: all -> 0x00a1, TryCatch #1 {all -> 0x00a1, blocks: (B:21:0x0065, B:23:0x006b, B:25:0x0082, B:27:0x0087, B:26:0x0085, B:30:0x0092), top: B:72:0x0065 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0091  */
    /* JADX WARN: Code duplicated, block: B:30:0x0092 A[Catch: all -> 0x00a1, TRY_LEAVE, TryCatch #1 {all -> 0x00a1, blocks: (B:21:0x0065, B:23:0x006b, B:25:0x0082, B:27:0x0087, B:26:0x0085, B:30:0x0092), top: B:72:0x0065 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:70:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x00a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public ResultSet getProcedureOrFunctionColumns(Field[] fieldArr, String str, String str2, String str3, String str4, boolean z, boolean z2) throws Throwable {
        String strUnQuoteIdentifier;
        int iIndexOf;
        Throwable th;
        ResultSet proceduresAndOrFunctions;
        String strSanitizeProcOrFuncName;
        List<String> listSplitDBdotName;
        String str5;
        boolean z3;
        ProcedureType procedureType;
        String str6 = str3;
        ArrayList<ComparableWrapper> arrayList = new ArrayList();
        if (supportsStoredProcedures()) {
            SQLException sQLException = null;
            if (str6 != null) {
                try {
                    strSanitizeProcOrFuncName = str6.equals("%") ? null : StringUtils.sanitizeProcOrFuncName(str3);
                    if (strSanitizeProcOrFuncName == null) {
                        strUnQuoteIdentifier = str;
                    } else {
                        strUnQuoteIdentifier = str;
                        listSplitDBdotName = StringUtils.splitDBdotName(strSanitizeProcOrFuncName, strUnQuoteIdentifier, this.quotedId, this.conn.isNoBackslashEscapesSet());
                        if (listSplitDBdotName.size() == 2) {
                            listSplitDBdotName.get(0);
                            str6 = listSplitDBdotName.get(1);
                        } else {
                            str5 = strSanitizeProcOrFuncName;
                        }
                        proceduresAndOrFunctions = getProceduresAndOrFunctions(createFieldMetadataForGetProcedures(), str, str2, str5, z, z2);
                        z3 = false;
                        while (proceduresAndOrFunctions.next()) {
                            try {
                                String fullyQualifiedName = getFullyQualifiedName(proceduresAndOrFunctions.getString(1), proceduresAndOrFunctions.getString(3));
                                if (proceduresAndOrFunctions.getShort(8) == 1) {
                                    procedureType = ProcedureType.PROCEDURE;
                                } else {
                                    procedureType = ProcedureType.FUNCTION;
                                }
                                arrayList.add(new ComparableWrapper(fullyQualifiedName, procedureType));
                                z3 = true;
                            } catch (Throwable th2) {
                                th = th2;
                                if (proceduresAndOrFunctions != null) {
                                    try {
                                        proceduresAndOrFunctions.close();
                                    } catch (SQLException e) {
                                        sQLException = e;
                                    }
                                }
                                if (sQLException != null) {
                                    throw sQLException;
                                }
                                throw th;
                            }
                        }
                        if (!z3) {
                            Collections.sort(arrayList);
                        }
                        if (proceduresAndOrFunctions != null) {
                            try {
                                proceduresAndOrFunctions.close();
                            } catch (SQLException e2) {
                                sQLException = e2;
                            }
                        }
                        if (sQLException != null) {
                            throw sQLException;
                        }
                    }
                    str5 = str6;
                    proceduresAndOrFunctions = getProceduresAndOrFunctions(createFieldMetadataForGetProcedures(), str, str2, str5, z, z2);
                    z3 = false;
                    while (proceduresAndOrFunctions.next()) {
                        String fullyQualifiedName2 = getFullyQualifiedName(proceduresAndOrFunctions.getString(1), proceduresAndOrFunctions.getString(3));
                        if (proceduresAndOrFunctions.getShort(8) == 1) {
                            procedureType = ProcedureType.PROCEDURE;
                        } else {
                            procedureType = ProcedureType.FUNCTION;
                        }
                        arrayList.add(new ComparableWrapper(fullyQualifiedName2, procedureType));
                        z3 = true;
                    }
                    if (!z3) {
                        Collections.sort(arrayList);
                    }
                    if (proceduresAndOrFunctions != null) {
                        proceduresAndOrFunctions.close();
                    }
                    if (sQLException != null) {
                        throw sQLException;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    proceduresAndOrFunctions = null;
                    if (proceduresAndOrFunctions != null) {
                        proceduresAndOrFunctions.close();
                    }
                    if (sQLException != null) {
                        throw sQLException;
                    }
                    throw th;
                }
            }
            if (strSanitizeProcOrFuncName == null) {
                strUnQuoteIdentifier = str;
            } else {
                strUnQuoteIdentifier = str;
                listSplitDBdotName = StringUtils.splitDBdotName(strSanitizeProcOrFuncName, strUnQuoteIdentifier, this.quotedId, this.conn.isNoBackslashEscapesSet());
                if (listSplitDBdotName.size() == 2) {
                    listSplitDBdotName.get(0);
                    str6 = listSplitDBdotName.get(1);
                } else {
                    str5 = strSanitizeProcOrFuncName;
                }
                proceduresAndOrFunctions = getProceduresAndOrFunctions(createFieldMetadataForGetProcedures(), str, str2, str5, z, z2);
                z3 = false;
                while (proceduresAndOrFunctions.next()) {
                    String fullyQualifiedName3 = getFullyQualifiedName(proceduresAndOrFunctions.getString(1), proceduresAndOrFunctions.getString(3));
                    if (proceduresAndOrFunctions.getShort(8) == 1) {
                        procedureType = ProcedureType.PROCEDURE;
                    } else {
                        procedureType = ProcedureType.FUNCTION;
                    }
                    arrayList.add(new ComparableWrapper(fullyQualifiedName3, procedureType));
                    z3 = true;
                }
                if (!z3) {
                    Collections.sort(arrayList);
                }
                if (proceduresAndOrFunctions != null) {
                    proceduresAndOrFunctions.close();
                }
                if (sQLException != null) {
                    throw sQLException;
                }
            }
            str5 = str6;
            proceduresAndOrFunctions = getProceduresAndOrFunctions(createFieldMetadataForGetProcedures(), str, str2, str5, z, z2);
            z3 = false;
            while (proceduresAndOrFunctions.next()) {
                String fullyQualifiedName4 = getFullyQualifiedName(proceduresAndOrFunctions.getString(1), proceduresAndOrFunctions.getString(3));
                if (proceduresAndOrFunctions.getShort(8) == 1) {
                    procedureType = ProcedureType.PROCEDURE;
                } else {
                    procedureType = ProcedureType.FUNCTION;
                }
                arrayList.add(new ComparableWrapper(fullyQualifiedName4, procedureType));
                z3 = true;
            }
            if (!z3) {
                Collections.sort(arrayList);
            }
            if (proceduresAndOrFunctions != null) {
                proceduresAndOrFunctions.close();
            }
            if (sQLException != null) {
                throw sQLException;
            }
        } else {
            strUnQuoteIdentifier = str;
        }
        ArrayList<ResultSetRow> arrayList2 = new ArrayList<>();
        for (ComparableWrapper comparableWrapper : arrayList) {
            String str7 = (String) comparableWrapper.getKey();
            ProcedureType procedureType2 = (ProcedureType) comparableWrapper.getValue();
            if (" ".equals(this.quotedId)) {
                iIndexOf = str7.indexOf(".");
            } else {
                String str8 = this.quotedId;
                iIndexOf = StringUtils.indexOfIgnoreCase(0, str7, ".", str8, str8, this.conn.isNoBackslashEscapesSet() ? StringUtils.SEARCH_MODE__MRK_COM_WS : StringUtils.SEARCH_MODE__ALL);
            }
            if (iIndexOf > 0) {
                strUnQuoteIdentifier = StringUtils.unQuoteIdentifier(str7.substring(0, iIndexOf), this.quotedId);
            }
            getCallStmtParameterTypes(strUnQuoteIdentifier, str7, procedureType2, str4, arrayList2, fieldArr.length == 17);
        }
        return buildResultSet(fieldArr, arrayList2);
    }

    @Override // java.sql.DatabaseMetaData
    public String getProcedureTerm() throws SQLException {
        return "PROCEDURE";
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getProcedures(String str, String str2, String str3) throws SQLException {
        return getProceduresAndOrFunctions(createFieldMetadataForGetProcedures(), str, str2, str3, true, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ResultSet getProceduresAndOrFunctions(final Field[] fieldArr, String str, String str2, String str3, final boolean z, final boolean z2) throws SQLException {
        if (str3 == null || str3.length() == 0) {
            if (!this.conn.getNullNamePatternMatchesAll()) {
                throw SQLError.createSQLException("Procedure name pattern can not be NULL or empty.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            str3 = "%";
        }
        final String str4 = str3;
        ArrayList arrayList = new ArrayList();
        if (supportsStoredProcedures()) {
            final ArrayList arrayList2 = new ArrayList();
            new IterateBlock<String>(getCatalogIterator(str)) { // from class: com.mysql.jdbc.DatabaseMetaData.8
                @Override // com.mysql.jdbc.IterateBlock
                public void forEach(String str5) throws Throwable {
                    Throwable th;
                    ResultSet resultSetExecuteQuery;
                    String lowerCase;
                    boolean z3;
                    StringBuilder sb = new StringBuilder();
                    sb.append("SELECT name, type, comment FROM mysql.proc WHERE ");
                    boolean z4 = z;
                    if (z4 && !z2) {
                        sb.append("type = 'PROCEDURE' AND ");
                    } else if (!z4 && z2) {
                        sb.append("type = 'FUNCTION' AND ");
                    }
                    sb.append("name LIKE ? AND db <=> ? ORDER BY name, type");
                    java.sql.PreparedStatement preparedStatementPrepareMetaDataSafeStatement = DatabaseMetaData.this.prepareMetaDataSafeStatement(sb.toString());
                    int i = 2;
                    SQLException sQLException = null;
                    try {
                        if (str5 != null) {
                            lowerCase = DatabaseMetaData.this.conn.lowerCaseTableNames() ? str5.toLowerCase() : str5;
                            preparedStatementPrepareMetaDataSafeStatement.setString(2, lowerCase);
                        } else {
                            preparedStatementPrepareMetaDataSafeStatement.setNull(2, 12);
                            lowerCase = str5;
                        }
                        preparedStatementPrepareMetaDataSafeStatement.setString(1, str4);
                        try {
                            resultSetExecuteQuery = preparedStatementPrepareMetaDataSafeStatement.executeQuery();
                            z3 = false;
                            try {
                                try {
                                    if (z) {
                                        DatabaseMetaData.this.convertToJdbcProcedureList(true, lowerCase, resultSetExecuteQuery, false, lowerCase, arrayList2, 1);
                                    }
                                    if (z2) {
                                        DatabaseMetaData.this.convertToJdbcFunctionList(lowerCase, resultSetExecuteQuery, false, lowerCase, arrayList2, 1, fieldArr);
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (resultSetExecuteQuery != null) {
                                        try {
                                            resultSetExecuteQuery.close();
                                        } catch (SQLException e) {
                                            sQLException = e;
                                        }
                                    }
                                    if (preparedStatementPrepareMetaDataSafeStatement != null) {
                                        try {
                                            preparedStatementPrepareMetaDataSafeStatement.close();
                                        } catch (SQLException e2) {
                                            sQLException = e2;
                                        }
                                    }
                                    if (sQLException == null) {
                                        throw th;
                                    }
                                    throw sQLException;
                                }
                            } catch (SQLException unused) {
                                if (!DatabaseMetaData.this.conn.versionMeetsMinimum(5, 0, 1)) {
                                    i = 1;
                                }
                                if (z2) {
                                    preparedStatementPrepareMetaDataSafeStatement.close();
                                    preparedStatementPrepareMetaDataSafeStatement = DatabaseMetaData.this.prepareMetaDataSafeStatement("SHOW FUNCTION STATUS LIKE ?");
                                    preparedStatementPrepareMetaDataSafeStatement.setString(1, str4);
                                    resultSetExecuteQuery = preparedStatementPrepareMetaDataSafeStatement.executeQuery();
                                    DatabaseMetaData.this.convertToJdbcFunctionList(lowerCase, resultSetExecuteQuery, z3, lowerCase, arrayList2, i, fieldArr);
                                }
                                if (z) {
                                    preparedStatementPrepareMetaDataSafeStatement.close();
                                    preparedStatementPrepareMetaDataSafeStatement = DatabaseMetaData.this.prepareMetaDataSafeStatement("SHOW PROCEDURE STATUS LIKE ?");
                                    preparedStatementPrepareMetaDataSafeStatement.setString(1, str4);
                                    resultSetExecuteQuery = preparedStatementPrepareMetaDataSafeStatement.executeQuery();
                                    DatabaseMetaData.this.convertToJdbcProcedureList(false, lowerCase, resultSetExecuteQuery, z3, lowerCase, arrayList2, i);
                                }
                            }
                        } catch (SQLException unused2) {
                            resultSetExecuteQuery = null;
                            z3 = true;
                        }
                        if (resultSetExecuteQuery != null) {
                            try {
                                resultSetExecuteQuery.close();
                            } catch (SQLException e3) {
                                sQLException = e3;
                            }
                        }
                        if (preparedStatementPrepareMetaDataSafeStatement != null) {
                            try {
                                preparedStatementPrepareMetaDataSafeStatement.close();
                            } catch (SQLException e4) {
                                sQLException = e4;
                            }
                        }
                        if (sQLException != null) {
                            throw sQLException;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        resultSetExecuteQuery = null;
                    }
                }
            }.doForAll();
            Collections.sort(arrayList2);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(((ComparableWrapper) it.next()).getValue());
            }
        }
        return buildResultSet(fieldArr, arrayList);
    }

    public ResultSet getPseudoColumns(String str, String str2, String str3, String str4) throws SQLException {
        return buildResultSet(new Field[]{new Field(BuildConfig.FLAVOR, "TABLE_CAT", 12, 512), new Field(BuildConfig.FLAVOR, "TABLE_SCHEM", 12, 512), new Field(BuildConfig.FLAVOR, "TABLE_NAME", 12, 512), new Field(BuildConfig.FLAVOR, "COLUMN_NAME", 12, 512), new Field(BuildConfig.FLAVOR, "DATA_TYPE", 4, 12), new Field(BuildConfig.FLAVOR, "COLUMN_SIZE", 4, 12), new Field(BuildConfig.FLAVOR, "DECIMAL_DIGITS", 4, 12), new Field(BuildConfig.FLAVOR, "NUM_PREC_RADIX", 4, 12), new Field(BuildConfig.FLAVOR, "COLUMN_USAGE", 12, 512), new Field(BuildConfig.FLAVOR, "REMARKS", 12, 512), new Field(BuildConfig.FLAVOR, "CHAR_OCTET_LENGTH", 4, 12), new Field(BuildConfig.FLAVOR, "IS_NULLABLE", 12, 512)}, new ArrayList<>());
    }

    @Override // java.sql.DatabaseMetaData
    public int getResultSetHoldability() throws SQLException {
        return 1;
    }

    @Override // java.sql.DatabaseMetaData
    public String getSQLKeywords() throws SQLException {
        if (mysqlKeywords != null) {
            return mysqlKeywords;
        }
        synchronized (DatabaseMetaData.class) {
            if (mysqlKeywords != null) {
                return mysqlKeywords;
            }
            TreeSet<String> treeSet = new TreeSet();
            StringBuilder sb = new StringBuilder();
            Collections.addAll(treeSet, MYSQL_KEYWORDS);
            treeSet.removeAll(Arrays.asList(Util.isJdbc4() ? SQL2003_KEYWORDS : SQL92_KEYWORDS));
            for (String str : treeSet) {
                sb.append(",");
                sb.append(str);
            }
            mysqlKeywords = sb.substring(1);
            return mysqlKeywords;
        }
    }

    @Override // java.sql.DatabaseMetaData
    public int getSQLStateType() throws SQLException {
        return (this.conn.versionMeetsMinimum(4, 1, 0) || this.conn.getUseSqlStateCodes()) ? 2 : 1;
    }

    @Override // java.sql.DatabaseMetaData
    public String getSchemaTerm() throws SQLException {
        return BuildConfig.FLAVOR;
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getSchemas() throws SQLException {
        return buildResultSet(new Field[]{new Field(BuildConfig.FLAVOR, "TABLE_SCHEM", 1, 0), new Field(BuildConfig.FLAVOR, "TABLE_CATALOG", 1, 0)}, new ArrayList<>());
    }

    @Override // java.sql.DatabaseMetaData
    public String getSearchStringEscape() throws SQLException {
        return "\\";
    }

    @Override // java.sql.DatabaseMetaData
    public String getStringFunctions() throws SQLException {
        return "ASCII,BIN,BIT_LENGTH,CHAR,CHARACTER_LENGTH,CHAR_LENGTH,CONCAT,CONCAT_WS,CONV,ELT,EXPORT_SET,FIELD,FIND_IN_SET,HEX,INSERT,INSTR,LCASE,LEFT,LENGTH,LOAD_FILE,LOCATE,LOCATE,LOWER,LPAD,LTRIM,MAKE_SET,MATCH,MID,OCT,OCTET_LENGTH,ORD,POSITION,QUOTE,REPEAT,REPLACE,REVERSE,RIGHT,RPAD,RTRIM,SOUNDEX,SPACE,STRCMP,SUBSTRING,SUBSTRING,SUBSTRING,SUBSTRING,SUBSTRING_INDEX,TRIM,UCASE,UPPER";
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getSuperTables(String str, String str2, String str3) throws SQLException {
        return buildResultSet(new Field[]{new Field(BuildConfig.FLAVOR, "TABLE_CAT", 1, 32), new Field(BuildConfig.FLAVOR, "TABLE_SCHEM", 1, 32), new Field(BuildConfig.FLAVOR, "TABLE_NAME", 1, 32), new Field(BuildConfig.FLAVOR, "SUPERTABLE_NAME", 1, 32)}, new ArrayList<>());
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getSuperTypes(String str, String str2, String str3) throws SQLException {
        return buildResultSet(new Field[]{new Field(BuildConfig.FLAVOR, "TYPE_CAT", 1, 32), new Field(BuildConfig.FLAVOR, "TYPE_SCHEM", 1, 32), new Field(BuildConfig.FLAVOR, "TYPE_NAME", 1, 32), new Field(BuildConfig.FLAVOR, "SUPERTYPE_CAT", 1, 32), new Field(BuildConfig.FLAVOR, "SUPERTYPE_SCHEM", 1, 32), new Field(BuildConfig.FLAVOR, "SUPERTYPE_NAME", 1, 32)}, new ArrayList<>());
    }

    @Override // java.sql.DatabaseMetaData
    public String getSystemFunctions() throws SQLException {
        return "DATABASE,USER,SYSTEM_USER,SESSION_USER,PASSWORD,ENCRYPT,LAST_INSERT_ID,VERSION";
    }

    public String getTableNameWithCase(String str) {
        return this.conn.lowerCaseTableNames() ? str.toLowerCase() : str;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0191 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x015f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:112:0x0176 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:0x0162 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:18:0x0089  */
    /* JADX WARN: Code duplicated, block: B:22:0x009a A[Catch: all -> 0x01a0, TryCatch #0 {all -> 0x01a0, blocks: (B:20:0x0094, B:22:0x009a, B:24:0x00b0, B:29:0x00bb, B:31:0x00c2, B:33:0x00ca, B:34:0x00d2, B:36:0x00d8, B:37:0x00e5, B:39:0x00eb, B:52:0x015f, B:59:0x0172, B:60:0x0175), top: B:87:0x0094 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d8 A[Catch: all -> 0x01a0, TryCatch #0 {all -> 0x01a0, blocks: (B:20:0x0094, B:22:0x009a, B:24:0x00b0, B:29:0x00bb, B:31:0x00c2, B:33:0x00ca, B:34:0x00d2, B:36:0x00d8, B:37:0x00e5, B:39:0x00eb, B:52:0x015f, B:59:0x0172, B:60:0x0175), top: B:87:0x0094 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00eb A[Catch: all -> 0x01a0, TRY_LEAVE, TryCatch #0 {all -> 0x01a0, blocks: (B:20:0x0094, B:22:0x009a, B:24:0x00b0, B:29:0x00bb, B:31:0x00c2, B:33:0x00ca, B:34:0x00d2, B:36:0x00d8, B:37:0x00e5, B:39:0x00eb, B:52:0x015f, B:59:0x0172, B:60:0x0175), top: B:87:0x0094 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00ff A[Catch: all -> 0x0167, TryCatch #5 {all -> 0x0167, blocks: (B:42:0x00f9, B:44:0x00ff, B:46:0x0119, B:48:0x0128, B:47:0x0122), top: B:97:0x00f9 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x0119 A[Catch: all -> 0x0167, TryCatch #5 {all -> 0x0167, blocks: (B:42:0x00f9, B:44:0x00ff, B:46:0x0119, B:48:0x0128, B:47:0x0122), top: B:97:0x00f9 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0122 A[Catch: all -> 0x0167, TryCatch #5 {all -> 0x0167, blocks: (B:42:0x00f9, B:44:0x00ff, B:46:0x0119, B:48:0x0128, B:47:0x0122), top: B:97:0x00f9 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0198 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.sql.DatabaseMetaData
    public ResultSet getTablePrivileges(String str, String str2, String str3) throws Throwable {
        String str4;
        java.sql.PreparedStatement preparedStatementPrepareMetaDataSafeStatement;
        ResultSet resultSet;
        String str5;
        ResultSet resultSetExecuteQuery;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String str6;
        StringBuilder sb;
        String string6;
        StringTokenizer stringTokenizer;
        String strTrim;
        ResultSet resultSet2;
        ResultSet columns;
        byte[][] bArr;
        String str7 = str;
        if (str3 != null) {
            str4 = str3;
        } else {
            if (!this.conn.getNullNamePatternMatchesAll()) {
                throw SQLError.createSQLException("Table name pattern can not be NULL or empty.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            str4 = "%";
        }
        int i = 1;
        char c = 0;
        int i2 = 2;
        int i3 = 3;
        int i4 = 4;
        int i5 = 5;
        int i6 = 6;
        Field[] fieldArr = {new Field(BuildConfig.FLAVOR, "TABLE_CAT", 1, 64), new Field(BuildConfig.FLAVOR, "TABLE_SCHEM", 1, 1), new Field(BuildConfig.FLAVOR, "TABLE_NAME", 1, 64), new Field(BuildConfig.FLAVOR, "GRANTOR", 1, 77), new Field(BuildConfig.FLAVOR, "GRANTEE", 1, 77), new Field(BuildConfig.FLAVOR, "PRIVILEGE", 1, 64), new Field(BuildConfig.FLAVOR, "IS_GRANTABLE", 1, 3)};
        ArrayList<ResultSetRow> arrayList = new ArrayList<>();
        try {
            preparedStatementPrepareMetaDataSafeStatement = prepareMetaDataSafeStatement("SELECT host,db,table_name,grantor,user,table_priv FROM mysql.tables_priv WHERE db LIKE ? AND table_name LIKE ?");
            if (str7 == null) {
                str5 = "%";
                preparedStatementPrepareMetaDataSafeStatement.setString(1, str5);
                preparedStatementPrepareMetaDataSafeStatement.setString(2, str4);
                resultSetExecuteQuery = preparedStatementPrepareMetaDataSafeStatement.executeQuery();
                while (resultSetExecuteQuery.next()) {
                    string = resultSetExecuteQuery.getString(i);
                    string2 = resultSetExecuteQuery.getString(i2);
                    string3 = resultSetExecuteQuery.getString(i3);
                    string4 = resultSetExecuteQuery.getString(i4);
                    string5 = resultSetExecuteQuery.getString(i5);
                    if (string5 != null) {
                        str6 = "%";
                    } else {
                        str6 = "%";
                    }
                    sb = new StringBuilder(str6);
                    if (string != null) {
                        sb.append("@");
                        sb.append(string);
                    }
                    string6 = resultSetExecuteQuery.getString(i6);
                    if (string6 != null) {
                        stringTokenizer = new StringTokenizer(string6.toUpperCase(Locale.ENGLISH), ",");
                        while (stringTokenizer.hasMoreTokens()) {
                            strTrim = stringTokenizer.nextToken().trim();
                            columns = getColumns(str7, str2, string3, "%");
                            while (columns.next()) {
                                bArr = new byte[8][];
                                bArr[c] = s2b(string2);
                                bArr[1] = null;
                                bArr[2] = s2b(string3);
                                if (string4 != null) {
                                    bArr[3] = s2b(string4);
                                } else {
                                    bArr[3] = null;
                                }
                                bArr[4] = s2b(sb.toString());
                                bArr[5] = s2b(strTrim);
                                bArr[6] = null;
                                arrayList.add(new ByteArrayRow(bArr, getExceptionInterceptor()));
                                c = 0;
                            }
                            if (columns != null) {
                                columns.close();
                            }
                            str7 = str;
                            c = 0;
                        }
                    }
                    str7 = str;
                    i6 = 6;
                    c = 0;
                    i = 1;
                    i5 = 5;
                    i2 = 2;
                    i3 = 3;
                    i4 = 4;
                }
                if (resultSetExecuteQuery != null) {
                    resultSetExecuteQuery.close();
                }
                if (preparedStatementPrepareMetaDataSafeStatement != null) {
                    preparedStatementPrepareMetaDataSafeStatement.close();
                }
                return buildResultSet(fieldArr, arrayList);
            }
            try {
                if (str.length() != 0) {
                    str5 = str7;
                } else {
                    str5 = "%";
                }
                try {
                    preparedStatementPrepareMetaDataSafeStatement.setString(1, str5);
                    preparedStatementPrepareMetaDataSafeStatement.setString(2, str4);
                    resultSetExecuteQuery = preparedStatementPrepareMetaDataSafeStatement.executeQuery();
                    while (resultSetExecuteQuery.next()) {
                        try {
                            string = resultSetExecuteQuery.getString(i);
                            string2 = resultSetExecuteQuery.getString(i2);
                            string3 = resultSetExecuteQuery.getString(i3);
                            string4 = resultSetExecuteQuery.getString(i4);
                            string5 = resultSetExecuteQuery.getString(i5);
                            if (string5 != null || string5.length() == 0) {
                                str6 = "%";
                            } else {
                                str6 = string5;
                            }
                            sb = new StringBuilder(str6);
                            if (string != null && this.conn.getUseHostsInPrivileges()) {
                                sb.append("@");
                                sb.append(string);
                            }
                            string6 = resultSetExecuteQuery.getString(i6);
                            if (string6 != null) {
                                stringTokenizer = new StringTokenizer(string6.toUpperCase(Locale.ENGLISH), ",");
                                while (stringTokenizer.hasMoreTokens()) {
                                    strTrim = stringTokenizer.nextToken().trim();
                                    try {
                                        columns = getColumns(str7, str2, string3, "%");
                                        while (columns.next()) {
                                            try {
                                                bArr = new byte[8][];
                                                bArr[c] = s2b(string2);
                                                bArr[1] = null;
                                                bArr[2] = s2b(string3);
                                                if (string4 != null) {
                                                    bArr[3] = s2b(string4);
                                                } else {
                                                    bArr[3] = null;
                                                }
                                                bArr[4] = s2b(sb.toString());
                                                bArr[5] = s2b(strTrim);
                                                bArr[6] = null;
                                                arrayList.add(new ByteArrayRow(bArr, getExceptionInterceptor()));
                                                c = 0;
                                            } catch (Throwable th) {
                                                th = th;
                                                resultSet2 = columns;
                                                if (resultSet2 != null) {
                                                    try {
                                                        resultSet2.close();
                                                    } catch (Exception unused) {
                                                    }
                                                }
                                                throw th;
                                            }
                                        }
                                        if (columns != null) {
                                            try {
                                                columns.close();
                                            } catch (Exception unused2) {
                                            }
                                        }
                                        str7 = str;
                                        c = 0;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        resultSet2 = null;
                                    }
                                }
                            }
                            str7 = str;
                            i6 = 6;
                            c = 0;
                            i = 1;
                            i5 = 5;
                            i2 = 2;
                            i3 = 3;
                            i4 = 4;
                        } catch (Throwable th3) {
                            th = th3;
                            resultSet = resultSetExecuteQuery;
                        }
                    }
                    if (resultSetExecuteQuery != null) {
                        try {
                            resultSetExecuteQuery.close();
                        } catch (Exception unused3) {
                        }
                    }
                    if (preparedStatementPrepareMetaDataSafeStatement != null) {
                        try {
                            preparedStatementPrepareMetaDataSafeStatement.close();
                        } catch (Exception unused4) {
                        }
                    }
                    return buildResultSet(fieldArr, arrayList);
                } catch (Throwable th4) {
                    th = th4;
                    resultSet = null;
                }
            } catch (Throwable th5) {
                th = th5;
                resultSet = null;
            }
        } catch (Throwable th6) {
            th = th6;
            preparedStatementPrepareMetaDataSafeStatement = null;
            resultSet = null;
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception unused5) {
            }
        }
        if (preparedStatementPrepareMetaDataSafeStatement == null) {
            throw th;
        }
        try {
            preparedStatementPrepareMetaDataSafeStatement.close();
            throw th;
        } catch (Exception unused6) {
            throw th;
        }
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getTableTypes() throws SQLException {
        ArrayList<ResultSetRow> arrayList = new ArrayList<>();
        Field[] fieldArr = {new Field(BuildConfig.FLAVOR, "TABLE_TYPE", 12, 256)};
        boolean zVersionMeetsMinimum = this.conn.versionMeetsMinimum(5, 0, 1);
        arrayList.add(new ByteArrayRow(new byte[][]{TableType.LOCAL_TEMPORARY.asBytes()}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{TableType.SYSTEM_TABLE.asBytes()}, getExceptionInterceptor()));
        if (zVersionMeetsMinimum) {
            arrayList.add(new ByteArrayRow(new byte[][]{TableType.SYSTEM_VIEW.asBytes()}, getExceptionInterceptor()));
        }
        arrayList.add(new ByteArrayRow(new byte[][]{TableType.TABLE.asBytes()}, getExceptionInterceptor()));
        if (zVersionMeetsMinimum) {
            arrayList.add(new ByteArrayRow(new byte[][]{TableType.VIEW.asBytes()}, getExceptionInterceptor()));
        }
        return buildResultSet(fieldArr, arrayList);
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getTables(String str, String str2, String str3, final String[] strArr) throws SQLException {
        String str4;
        if (str3 == null) {
            if (!this.conn.getNullNamePatternMatchesAll()) {
                throw SQLError.createSQLException("Table name pattern can not be NULL or empty.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }
            str3 = "%";
        }
        final TreeMap treeMap = new TreeMap();
        ArrayList<ResultSetRow> arrayList = new ArrayList<>();
        final java.sql.Statement metadataSafeStatement = this.conn.getMetadataSafeStatement();
        if (str == null || str.length() == 0) {
            str4 = this.conn.getNullCatalogMeansCurrent() ? this.database : BuildConfig.FLAVOR;
        } else {
            str4 = str;
        }
        List<String> listSplitDBdotName = StringUtils.splitDBdotName(str3, str4, this.quotedId, this.conn.isNoBackslashEscapesSet());
        if (listSplitDBdotName.size() == 2) {
            str3 = listSplitDBdotName.get(1);
        }
        final String str5 = str3;
        try {
            new IterateBlock<String>(getCatalogIterator(str)) { // from class: com.mysql.jdbc.DatabaseMetaData.9
                /* JADX WARN: Code duplicated, block: B:121:0x0311 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:90:0x02a2 A[Catch: all -> 0x02fa, TryCatch #3 {all -> 0x02fa, blocks: (B:20:0x006a, B:22:0x006e, B:26:0x0078, B:28:0x007d, B:43:0x00c0, B:31:0x0089, B:34:0x0097, B:37:0x00a5, B:40:0x00b3, B:46:0x00d5, B:48:0x00df, B:53:0x00f3, B:55:0x00f9, B:59:0x0107, B:61:0x012a, B:67:0x0145, B:70:0x0185, B:73:0x01ba, B:76:0x01ef, B:79:0x0224, B:83:0x025b, B:90:0x02a2, B:87:0x027f, B:93:0x02b8, B:58:0x0101, B:50:0x00e9), top: B:119:0x006a }] */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.mysql.jdbc.IterateBlock
                public void forEach(String str6) throws Throwable {
                    ResultSet resultSet;
                    boolean z;
                    boolean z2;
                    boolean z3;
                    boolean z4;
                    boolean z5;
                    int iFindColumn;
                    int i;
                    boolean z6;
                    int i2;
                    boolean z7;
                    TableMetaDataKey tableMetaDataKey;
                    int i3 = 0;
                    boolean z8 = "information_schema".equalsIgnoreCase(str6) || "mysql".equalsIgnoreCase(str6) || "performance_schema".equalsIgnoreCase(str6);
                    byte[] bArr = null;
                    try {
                        try {
                            java.sql.Statement statement = metadataSafeStatement;
                            StringBuilder sb = new StringBuilder();
                            int i4 = 2;
                            sb.append(!DatabaseMetaData.this.conn.versionMeetsMinimum(5, 0, 2) ? "SHOW TABLES FROM " : "SHOW FULL TABLES FROM ");
                            DatabaseMetaData databaseMetaData = DatabaseMetaData.this;
                            sb.append(StringUtils.quoteIdentifier(str6, databaseMetaData.quotedId, databaseMetaData.conn.getPedantic()));
                            sb.append(" LIKE ");
                            sb.append(StringUtils.quoteIdentifier(str5, "'", true));
                            ResultSet resultSetExecuteQuery = statement.executeQuery(sb.toString());
                            try {
                                String[] strArr2 = strArr;
                                if (strArr2 == null || strArr2.length == 0) {
                                    z = true;
                                    z2 = true;
                                    z3 = true;
                                    z4 = true;
                                    z5 = true;
                                } else {
                                    int i5 = 0;
                                    boolean z9 = false;
                                    boolean z10 = false;
                                    boolean z11 = false;
                                    boolean z12 = false;
                                    boolean z13 = false;
                                    while (true) {
                                        String[] strArr3 = strArr;
                                        if (i5 >= strArr3.length) {
                                            break;
                                        }
                                        if (TableType.TABLE.equalsTo(strArr3[i5])) {
                                            z9 = true;
                                        } else if (TableType.VIEW.equalsTo(strArr[i5])) {
                                            z10 = true;
                                        } else if (TableType.SYSTEM_TABLE.equalsTo(strArr[i5])) {
                                            z11 = true;
                                        } else if (TableType.SYSTEM_VIEW.equalsTo(strArr[i5])) {
                                            z12 = true;
                                        } else if (TableType.LOCAL_TEMPORARY.equalsTo(strArr[i5])) {
                                            z13 = true;
                                        }
                                        i5++;
                                    }
                                    z = z9;
                                    z2 = z10;
                                    z3 = z11;
                                    z4 = z12;
                                    z5 = z13;
                                }
                                if (DatabaseMetaData.this.conn.versionMeetsMinimum(5, 0, 2)) {
                                    try {
                                        try {
                                            iFindColumn = resultSetExecuteQuery.findColumn("table_type");
                                        } catch (SQLException unused) {
                                            iFindColumn = resultSetExecuteQuery.findColumn("Type");
                                        }
                                        i = iFindColumn;
                                        z6 = true;
                                    } catch (SQLException unused2) {
                                        i = 1;
                                        z6 = false;
                                    }
                                } else {
                                    i = 1;
                                    z6 = false;
                                }
                                while (resultSetExecuteQuery.next()) {
                                    byte[][] bArr2 = new byte[10][];
                                    bArr2[i3] = str6 == null ? bArr : DatabaseMetaData.this.s2b(str6);
                                    bArr2[1] = bArr;
                                    bArr2[i4] = resultSetExecuteQuery.getBytes(1);
                                    bArr2[4] = new byte[i3];
                                    bArr2[5] = bArr;
                                    bArr2[6] = bArr;
                                    bArr2[7] = bArr;
                                    bArr2[8] = bArr;
                                    bArr2[9] = bArr;
                                    if (z6) {
                                        int i6 = C028411.$SwitchMap$com$mysql$jdbc$DatabaseMetaData$TableType[TableType.getTableTypeCompliantWith(resultSetExecuteQuery.getString(i)).ordinal()];
                                        if (i6 == 1) {
                                            i2 = i;
                                            if (z8 && z3) {
                                                TableType tableType = TableType.SYSTEM_TABLE;
                                                bArr2[3] = tableType.asBytes();
                                                tableMetaDataKey = DatabaseMetaData.this.new TableMetaDataKey(tableType.getName(), str6, null, resultSetExecuteQuery.getString(1));
                                            } else {
                                                if (z8 || !z) {
                                                    z7 = false;
                                                    tableMetaDataKey = null;
                                                } else {
                                                    TableType tableType2 = TableType.TABLE;
                                                    bArr2[3] = tableType2.asBytes();
                                                    tableMetaDataKey = DatabaseMetaData.this.new TableMetaDataKey(tableType2.getName(), str6, null, resultSetExecuteQuery.getString(1));
                                                }
                                                if (z7) {
                                                    treeMap.put(tableMetaDataKey, new ByteArrayRow(bArr2, DatabaseMetaData.this.getExceptionInterceptor()));
                                                }
                                            }
                                            z7 = true;
                                            if (z7) {
                                                treeMap.put(tableMetaDataKey, new ByteArrayRow(bArr2, DatabaseMetaData.this.getExceptionInterceptor()));
                                            }
                                        } else if (i6 == i4) {
                                            i2 = i;
                                            if (z2) {
                                                TableType tableType3 = TableType.VIEW;
                                                bArr2[3] = tableType3.asBytes();
                                                treeMap.put(DatabaseMetaData.this.new TableMetaDataKey(tableType3.getName(), str6, null, resultSetExecuteQuery.getString(1)), new ByteArrayRow(bArr2, DatabaseMetaData.this.getExceptionInterceptor()));
                                            }
                                        } else if (i6 == 3) {
                                            i2 = i;
                                            if (z3) {
                                                TableType tableType4 = TableType.SYSTEM_TABLE;
                                                bArr2[3] = tableType4.asBytes();
                                                treeMap.put(DatabaseMetaData.this.new TableMetaDataKey(tableType4.getName(), str6, null, resultSetExecuteQuery.getString(1)), new ByteArrayRow(bArr2, DatabaseMetaData.this.getExceptionInterceptor()));
                                            }
                                        } else if (i6 == 4) {
                                            i2 = i;
                                            if (z4) {
                                                TableType tableType5 = TableType.SYSTEM_VIEW;
                                                bArr2[3] = tableType5.asBytes();
                                                treeMap.put(DatabaseMetaData.this.new TableMetaDataKey(tableType5.getName(), str6, null, resultSetExecuteQuery.getString(1)), new ByteArrayRow(bArr2, DatabaseMetaData.this.getExceptionInterceptor()));
                                            }
                                        } else if (i6 != 5) {
                                            TableType tableType6 = TableType.TABLE;
                                            bArr2[3] = tableType6.asBytes();
                                            i2 = i;
                                            treeMap.put(DatabaseMetaData.this.new TableMetaDataKey(tableType6.getName(), str6, null, resultSetExecuteQuery.getString(1)), new ByteArrayRow(bArr2, DatabaseMetaData.this.getExceptionInterceptor()));
                                        } else {
                                            i2 = i;
                                            if (z5) {
                                                TableType tableType7 = TableType.LOCAL_TEMPORARY;
                                                bArr2[3] = tableType7.asBytes();
                                                treeMap.put(DatabaseMetaData.this.new TableMetaDataKey(tableType7.getName(), str6, null, resultSetExecuteQuery.getString(1)), new ByteArrayRow(bArr2, DatabaseMetaData.this.getExceptionInterceptor()));
                                            }
                                        }
                                    } else {
                                        i2 = i;
                                        if (z) {
                                            TableType tableType8 = TableType.TABLE;
                                            bArr2[3] = tableType8.asBytes();
                                            treeMap.put(DatabaseMetaData.this.new TableMetaDataKey(tableType8.getName(), str6, null, resultSetExecuteQuery.getString(1)), new ByteArrayRow(bArr2, DatabaseMetaData.this.getExceptionInterceptor()));
                                        }
                                        i = i2;
                                        i3 = 0;
                                        bArr = null;
                                        i4 = 2;
                                    }
                                    i = i2;
                                    i3 = 0;
                                    bArr = null;
                                    i4 = 2;
                                }
                                if (resultSetExecuteQuery != null) {
                                    try {
                                        resultSetExecuteQuery.close();
                                    } catch (Exception unused3) {
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                resultSet = resultSetExecuteQuery;
                                if (resultSet != null) {
                                    try {
                                        resultSet.close();
                                    } catch (Exception unused4) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            resultSet = null;
                        }
                    } catch (SQLException e) {
                        if (SQLError.SQL_STATE_COMMUNICATION_LINK_FAILURE.equals(e.getSQLState())) {
                            throw e;
                        }
                        return;
                        if (resultSet != null) {
                            resultSet.close();
                        }
                        throw th;
                    }
                }
            }.doForAll();
            if (metadataSafeStatement != null) {
                metadataSafeStatement.close();
            }
            arrayList.addAll(treeMap.values());
            return buildResultSet(createTablesFields(), arrayList);
        } catch (Throwable th) {
            if (metadataSafeStatement != null) {
                metadataSafeStatement.close();
            }
            throw th;
        }
    }

    @Override // java.sql.DatabaseMetaData
    public String getTimeDateFunctions() throws SQLException {
        return "DAYOFWEEK,WEEKDAY,DAYOFMONTH,DAYOFYEAR,MONTH,DAYNAME,MONTHNAME,QUARTER,WEEK,YEAR,HOUR,MINUTE,SECOND,PERIOD_ADD,PERIOD_DIFF,TO_DAYS,FROM_DAYS,DATE_FORMAT,TIME_FORMAT,CURDATE,CURRENT_DATE,CURTIME,CURRENT_TIME,NOW,SYSDATE,CURRENT_TIMESTAMP,UNIX_TIMESTAMP,FROM_UNIXTIME,SEC_TO_TIME,TIME_TO_SEC";
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getTypeInfo() throws SQLException {
        Field[] fieldArr = {new Field(BuildConfig.FLAVOR, "TYPE_NAME", 1, 32), new Field(BuildConfig.FLAVOR, "DATA_TYPE", 4, 5), new Field(BuildConfig.FLAVOR, "PRECISION", 4, 10), new Field(BuildConfig.FLAVOR, "LITERAL_PREFIX", 1, 4), new Field(BuildConfig.FLAVOR, "LITERAL_SUFFIX", 1, 4), new Field(BuildConfig.FLAVOR, "CREATE_PARAMS", 1, 32), new Field(BuildConfig.FLAVOR, "NULLABLE", 5, 5), new Field(BuildConfig.FLAVOR, "CASE_SENSITIVE", 16, 3), new Field(BuildConfig.FLAVOR, "SEARCHABLE", 5, 3), new Field(BuildConfig.FLAVOR, "UNSIGNED_ATTRIBUTE", 16, 3), new Field(BuildConfig.FLAVOR, "FIXED_PREC_SCALE", 16, 3), new Field(BuildConfig.FLAVOR, "AUTO_INCREMENT", 16, 3), new Field(BuildConfig.FLAVOR, "LOCAL_TYPE_NAME", 1, 32), new Field(BuildConfig.FLAVOR, "MINIMUM_SCALE", 5, 5), new Field(BuildConfig.FLAVOR, "MAXIMUM_SCALE", 5, 5), new Field(BuildConfig.FLAVOR, "SQL_DATA_TYPE", 4, 10), new Field(BuildConfig.FLAVOR, "SQL_DATETIME_SUB", 4, 10), new Field(BuildConfig.FLAVOR, "NUM_PREC_RADIX", 4, 10)};
        ArrayList<ResultSetRow> arrayList = new ArrayList<>();
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("BIT"), Integer.toString(-7).getBytes(), s2b(DiskLruCache.VERSION_1), s2b(BuildConfig.FLAVOR), s2b(BuildConfig.FLAVOR), s2b(BuildConfig.FLAVOR), Integer.toString(1).getBytes(), s2b("true"), Integer.toString(3).getBytes(), s2b("false"), s2b("false"), s2b("false"), s2b("BIT"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("BOOL"), Integer.toString(-7).getBytes(), s2b(DiskLruCache.VERSION_1), s2b(BuildConfig.FLAVOR), s2b(BuildConfig.FLAVOR), s2b(BuildConfig.FLAVOR), Integer.toString(1).getBytes(), s2b("true"), Integer.toString(3).getBytes(), s2b("false"), s2b("false"), s2b("false"), s2b("BOOL"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("TINYINT"), Integer.toString(-6).getBytes(), s2b("3"), s2b(BuildConfig.FLAVOR), s2b(BuildConfig.FLAVOR), s2b("[(M)] [UNSIGNED] [ZEROFILL]"), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("true"), s2b("false"), s2b("true"), s2b("TINYINT"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("TINYINT UNSIGNED"), Integer.toString(-6).getBytes(), s2b("3"), s2b(BuildConfig.FLAVOR), s2b(BuildConfig.FLAVOR), s2b("[(M)] [UNSIGNED] [ZEROFILL]"), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("true"), s2b("false"), s2b("true"), s2b("TINYINT UNSIGNED"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("BIGINT"), Integer.toString(-5).getBytes(), s2b("19"), s2b(BuildConfig.FLAVOR), s2b(BuildConfig.FLAVOR), s2b("[(M)] [UNSIGNED] [ZEROFILL]"), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("true"), s2b("false"), s2b("true"), s2b("BIGINT"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("BIGINT UNSIGNED"), Integer.toString(-5).getBytes(), s2b("20"), s2b(BuildConfig.FLAVOR), s2b(BuildConfig.FLAVOR), s2b("[(M)] [ZEROFILL]"), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("true"), s2b("false"), s2b("true"), s2b("BIGINT UNSIGNED"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("LONG VARBINARY"), Integer.toString(-4).getBytes(), s2b("16777215"), s2b("'"), s2b("'"), s2b(BuildConfig.FLAVOR), Integer.toString(1).getBytes(), s2b("true"), Integer.toString(3).getBytes(), s2b("false"), s2b("false"), s2b("false"), s2b("LONG VARBINARY"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("MEDIUMBLOB"), Integer.toString(-4).getBytes(), s2b("16777215"), s2b("'"), s2b("'"), s2b(BuildConfig.FLAVOR), Integer.toString(1).getBytes(), s2b("true"), Integer.toString(3).getBytes(), s2b("false"), s2b("false"), s2b("false"), s2b("MEDIUMBLOB"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("LONGBLOB"), Integer.toString(-4).getBytes(), Integer.toString(Integer.MAX_VALUE).getBytes(), s2b("'"), s2b("'"), s2b(BuildConfig.FLAVOR), Integer.toString(1).getBytes(), s2b("true"), Integer.toString(3).getBytes(), s2b("false"), s2b("false"), s2b("false"), s2b("LONGBLOB"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("BLOB"), Integer.toString(-4).getBytes(), s2b("65535"), s2b("'"), s2b("'"), s2b(BuildConfig.FLAVOR), Integer.toString(1).getBytes(), s2b("true"), Integer.toString(3).getBytes(), s2b("false"), s2b("false"), s2b("false"), s2b("BLOB"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("TINYBLOB"), Integer.toString(-4).getBytes(), s2b("255"), s2b("'"), s2b("'"), s2b(BuildConfig.FLAVOR), Integer.toString(1).getBytes(), s2b("true"), Integer.toString(3).getBytes(), s2b("false"), s2b("false"), s2b("false"), s2b("TINYBLOB"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        byte[][] bArr = new byte[18][];
        bArr[0] = s2b("VARBINARY");
        bArr[1] = Integer.toString(-3).getBytes();
        bArr[2] = s2b(this.conn.versionMeetsMinimum(5, 0, 3) ? "65535" : "255");
        bArr[3] = s2b("'");
        bArr[4] = s2b("'");
        bArr[5] = s2b("(M)");
        bArr[6] = Integer.toString(1).getBytes();
        bArr[7] = s2b("true");
        bArr[8] = Integer.toString(3).getBytes();
        bArr[9] = s2b("false");
        bArr[10] = s2b("false");
        bArr[11] = s2b("false");
        bArr[12] = s2b("VARBINARY");
        bArr[13] = s2b("0");
        bArr[14] = s2b("0");
        bArr[15] = s2b("0");
        bArr[16] = s2b("0");
        bArr[17] = s2b("10");
        arrayList.add(new ByteArrayRow(bArr, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("BINARY"), Integer.toString(-2).getBytes(), s2b("255"), s2b("'"), s2b("'"), s2b("(M)"), Integer.toString(1).getBytes(), s2b("true"), Integer.toString(3).getBytes(), s2b("false"), s2b("false"), s2b("false"), s2b("BINARY"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("LONG VARCHAR"), Integer.toString(-1).getBytes(), s2b("16777215"), s2b("'"), s2b("'"), s2b(BuildConfig.FLAVOR), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("false"), s2b("false"), s2b("false"), s2b("LONG VARCHAR"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("MEDIUMTEXT"), Integer.toString(-1).getBytes(), s2b("16777215"), s2b("'"), s2b("'"), s2b(BuildConfig.FLAVOR), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("false"), s2b("false"), s2b("false"), s2b("MEDIUMTEXT"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("LONGTEXT"), Integer.toString(-1).getBytes(), Integer.toString(Integer.MAX_VALUE).getBytes(), s2b("'"), s2b("'"), s2b(BuildConfig.FLAVOR), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("false"), s2b("false"), s2b("false"), s2b("LONGTEXT"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("TEXT"), Integer.toString(-1).getBytes(), s2b("65535"), s2b("'"), s2b("'"), s2b(BuildConfig.FLAVOR), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("false"), s2b("false"), s2b("false"), s2b("TEXT"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("TINYTEXT"), Integer.toString(-1).getBytes(), s2b("255"), s2b("'"), s2b("'"), s2b(BuildConfig.FLAVOR), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("false"), s2b("false"), s2b("false"), s2b("TINYTEXT"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("CHAR"), Integer.toString(1).getBytes(), s2b("255"), s2b("'"), s2b("'"), s2b("(M)"), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("false"), s2b("false"), s2b("false"), s2b("CHAR"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        int i = MysqlDefs.FIELD_TYPE_STRING;
        if (this.conn.versionMeetsMinimum(5, 0, 3)) {
            i = this.conn.versionMeetsMinimum(5, 0, 6) ? 65 : 64;
        }
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("NUMERIC"), Integer.toString(2).getBytes(), s2b(String.valueOf(i)), s2b(BuildConfig.FLAVOR), s2b(BuildConfig.FLAVOR), s2b("[(M[,D])] [ZEROFILL]"), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("false"), s2b("false"), s2b("true"), s2b("NUMERIC"), s2b("-308"), s2b("308"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("DECIMAL"), Integer.toString(3).getBytes(), s2b(String.valueOf(i)), s2b(BuildConfig.FLAVOR), s2b(BuildConfig.FLAVOR), s2b("[(M[,D])] [ZEROFILL]"), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("false"), s2b("false"), s2b("true"), s2b("DECIMAL"), s2b("-308"), s2b("308"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("INTEGER"), Integer.toString(4).getBytes(), s2b("10"), s2b(BuildConfig.FLAVOR), s2b(BuildConfig.FLAVOR), s2b("[(M)] [UNSIGNED] [ZEROFILL]"), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("true"), s2b("false"), s2b("true"), s2b("INTEGER"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("INTEGER UNSIGNED"), Integer.toString(4).getBytes(), s2b("10"), s2b(BuildConfig.FLAVOR), s2b(BuildConfig.FLAVOR), s2b("[(M)] [ZEROFILL]"), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("true"), s2b("false"), s2b("true"), s2b("INTEGER UNSIGNED"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("INT"), Integer.toString(4).getBytes(), s2b("10"), s2b(BuildConfig.FLAVOR), s2b(BuildConfig.FLAVOR), s2b("[(M)] [UNSIGNED] [ZEROFILL]"), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("true"), s2b("false"), s2b("true"), s2b("INT"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("INT UNSIGNED"), Integer.toString(4).getBytes(), s2b("10"), s2b(BuildConfig.FLAVOR), s2b(BuildConfig.FLAVOR), s2b("[(M)] [ZEROFILL]"), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("true"), s2b("false"), s2b("true"), s2b("INT UNSIGNED"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("MEDIUMINT"), Integer.toString(4).getBytes(), s2b("7"), s2b(BuildConfig.FLAVOR), s2b(BuildConfig.FLAVOR), s2b("[(M)] [UNSIGNED] [ZEROFILL]"), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("true"), s2b("false"), s2b("true"), s2b("MEDIUMINT"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("MEDIUMINT UNSIGNED"), Integer.toString(4).getBytes(), s2b("8"), s2b(BuildConfig.FLAVOR), s2b(BuildConfig.FLAVOR), s2b("[(M)] [ZEROFILL]"), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("true"), s2b("false"), s2b("true"), s2b("MEDIUMINT UNSIGNED"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("SMALLINT"), Integer.toString(5).getBytes(), s2b("5"), s2b(BuildConfig.FLAVOR), s2b(BuildConfig.FLAVOR), s2b("[(M)] [UNSIGNED] [ZEROFILL]"), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("true"), s2b("false"), s2b("true"), s2b("SMALLINT"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("SMALLINT UNSIGNED"), Integer.toString(5).getBytes(), s2b("5"), s2b(BuildConfig.FLAVOR), s2b(BuildConfig.FLAVOR), s2b("[(M)] [ZEROFILL]"), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("true"), s2b("false"), s2b("true"), s2b("SMALLINT UNSIGNED"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("FLOAT"), Integer.toString(7).getBytes(), s2b("10"), s2b(BuildConfig.FLAVOR), s2b(BuildConfig.FLAVOR), s2b("[(M,D)] [ZEROFILL]"), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("false"), s2b("false"), s2b("true"), s2b("FLOAT"), s2b("-38"), s2b("38"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("DOUBLE"), Integer.toString(8).getBytes(), s2b("17"), s2b(BuildConfig.FLAVOR), s2b(BuildConfig.FLAVOR), s2b("[(M,D)] [ZEROFILL]"), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("false"), s2b("false"), s2b("true"), s2b("DOUBLE"), s2b("-308"), s2b("308"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("DOUBLE PRECISION"), Integer.toString(8).getBytes(), s2b("17"), s2b(BuildConfig.FLAVOR), s2b(BuildConfig.FLAVOR), s2b("[(M,D)] [ZEROFILL]"), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("false"), s2b("false"), s2b("true"), s2b("DOUBLE PRECISION"), s2b("-308"), s2b("308"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("REAL"), Integer.toString(8).getBytes(), s2b("17"), s2b(BuildConfig.FLAVOR), s2b(BuildConfig.FLAVOR), s2b("[(M,D)] [ZEROFILL]"), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("false"), s2b("false"), s2b("true"), s2b("REAL"), s2b("-308"), s2b("308"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        byte[][] bArr2 = new byte[18][];
        bArr2[0] = s2b("VARCHAR");
        bArr2[1] = Integer.toString(12).getBytes();
        bArr2[2] = s2b(this.conn.versionMeetsMinimum(5, 0, 3) ? "65535" : "255");
        bArr2[3] = s2b("'");
        bArr2[4] = s2b("'");
        bArr2[5] = s2b("(M)");
        bArr2[6] = Integer.toString(1).getBytes();
        bArr2[7] = s2b("false");
        bArr2[8] = Integer.toString(3).getBytes();
        bArr2[9] = s2b("false");
        bArr2[10] = s2b("false");
        bArr2[11] = s2b("false");
        bArr2[12] = s2b("VARCHAR");
        bArr2[13] = s2b("0");
        bArr2[14] = s2b("0");
        bArr2[15] = s2b("0");
        bArr2[16] = s2b("0");
        bArr2[17] = s2b("10");
        arrayList.add(new ByteArrayRow(bArr2, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("ENUM"), Integer.toString(12).getBytes(), s2b("65535"), s2b("'"), s2b("'"), s2b(BuildConfig.FLAVOR), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("false"), s2b("false"), s2b("false"), s2b("ENUM"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("SET"), Integer.toString(12).getBytes(), s2b("64"), s2b("'"), s2b("'"), s2b(BuildConfig.FLAVOR), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("false"), s2b("false"), s2b("false"), s2b("SET"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("DATE"), Integer.toString(91).getBytes(), s2b("0"), s2b("'"), s2b("'"), s2b(BuildConfig.FLAVOR), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("false"), s2b("false"), s2b("false"), s2b("DATE"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("TIME"), Integer.toString(92).getBytes(), s2b("0"), s2b("'"), s2b("'"), s2b(BuildConfig.FLAVOR), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("false"), s2b("false"), s2b("false"), s2b("TIME"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("DATETIME"), Integer.toString(93).getBytes(), s2b("0"), s2b("'"), s2b("'"), s2b(BuildConfig.FLAVOR), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("false"), s2b("false"), s2b("false"), s2b("DATETIME"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        arrayList.add(new ByteArrayRow(new byte[][]{s2b("TIMESTAMP"), Integer.toString(93).getBytes(), s2b("0"), s2b("'"), s2b("'"), s2b("[(M)]"), Integer.toString(1).getBytes(), s2b("false"), Integer.toString(3).getBytes(), s2b("false"), s2b("false"), s2b("false"), s2b("TIMESTAMP"), s2b("0"), s2b("0"), s2b("0"), s2b("0"), s2b("10")}, getExceptionInterceptor()));
        return buildResultSet(fieldArr, arrayList);
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getUDTs(String str, String str2, String str3, int[] iArr) throws SQLException {
        return buildResultSet(new Field[]{new Field(BuildConfig.FLAVOR, "TYPE_CAT", 12, 32), new Field(BuildConfig.FLAVOR, "TYPE_SCHEM", 12, 32), new Field(BuildConfig.FLAVOR, "TYPE_NAME", 12, 32), new Field(BuildConfig.FLAVOR, "CLASS_NAME", 12, 32), new Field(BuildConfig.FLAVOR, "DATA_TYPE", 4, 10), new Field(BuildConfig.FLAVOR, "REMARKS", 12, 32), new Field(BuildConfig.FLAVOR, "BASE_TYPE", 5, 10)}, new ArrayList<>());
    }

    @Override // java.sql.DatabaseMetaData
    public String getURL() throws SQLException {
        return this.conn.getURL();
    }

    @Override // java.sql.DatabaseMetaData
    public String getUserName() throws Throwable {
        java.sql.Statement metadataSafeStatement;
        if (!this.conn.getUseHostsInPrivileges()) {
            return this.conn.getUser();
        }
        ResultSet resultSetExecuteQuery = null;
        try {
            metadataSafeStatement = this.conn.getMetadataSafeStatement();
            try {
                resultSetExecuteQuery = metadataSafeStatement.executeQuery("SELECT USER()");
                resultSetExecuteQuery.next();
                String string = resultSetExecuteQuery.getString(1);
                if (resultSetExecuteQuery != null) {
                    try {
                        resultSetExecuteQuery.close();
                    } catch (Exception e) {
                        AssertionFailedException.shouldNotHappen(e);
                    }
                }
                if (metadataSafeStatement != null) {
                    try {
                        metadataSafeStatement.close();
                    } catch (Exception e2) {
                        AssertionFailedException.shouldNotHappen(e2);
                    }
                }
                return string;
            } catch (Throwable th) {
                th = th;
                if (resultSetExecuteQuery != null) {
                    try {
                        resultSetExecuteQuery.close();
                    } catch (Exception e3) {
                        AssertionFailedException.shouldNotHappen(e3);
                    }
                }
                if (metadataSafeStatement == null) {
                    throw th;
                }
                try {
                    metadataSafeStatement.close();
                    throw th;
                } catch (Exception e4) {
                    AssertionFailedException.shouldNotHappen(e4);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            metadataSafeStatement = null;
        }
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getVersionColumns(String str, String str2, final String str3) throws SQLException {
        if (str3 == null) {
            throw SQLError.createSQLException("Table not specified.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
        Field[] fieldArr = {new Field(BuildConfig.FLAVOR, "SCOPE", 5, 5), new Field(BuildConfig.FLAVOR, "COLUMN_NAME", 1, 32), new Field(BuildConfig.FLAVOR, "DATA_TYPE", 4, 5), new Field(BuildConfig.FLAVOR, "TYPE_NAME", 1, 16), new Field(BuildConfig.FLAVOR, "COLUMN_SIZE", 4, 16), new Field(BuildConfig.FLAVOR, "BUFFER_LENGTH", 4, 16), new Field(BuildConfig.FLAVOR, "DECIMAL_DIGITS", 5, 16), new Field(BuildConfig.FLAVOR, "PSEUDO_COLUMN", 5, 5)};
        final ArrayList<ResultSetRow> arrayList = new ArrayList<>();
        final java.sql.Statement metadataSafeStatement = this.conn.getMetadataSafeStatement();
        try {
            new IterateBlock<String>(getCatalogIterator(str)) { // from class: com.mysql.jdbc.DatabaseMetaData.10
                @Override // com.mysql.jdbc.IterateBlock
                public void forEach(String str4) throws Throwable {
                    ResultSet resultSetExecuteQuery;
                    boolean z;
                    boolean zVersionMeetsMinimum = DatabaseMetaData.this.conn.versionMeetsMinimum(5, 0, 0);
                    ResultSet resultSet = null;
                    try {
                        try {
                            try {
                                StringBuilder sb = new StringBuilder(" Extra LIKE '%on update CURRENT_TIMESTAMP%'");
                                ArrayList arrayList2 = new ArrayList();
                                int i = 2;
                                if (DatabaseMetaData.this.conn.versionMeetsMinimum(5, 1, 23)) {
                                    resultSetExecuteQuery = null;
                                } else {
                                    sb = new StringBuilder();
                                    resultSetExecuteQuery = metadataSafeStatement.executeQuery("SHOW CREATE TABLE " + DatabaseMetaData.this.getFullyQualifiedName(str4, str3));
                                    boolean z2 = true;
                                    while (resultSetExecuteQuery.next()) {
                                        try {
                                            StringTokenizer stringTokenizer = new StringTokenizer(resultSetExecuteQuery.getString(i), "\n");
                                            while (stringTokenizer.hasMoreTokens()) {
                                                String strTrim = stringTokenizer.nextToken().trim();
                                                if (StringUtils.indexOfIgnoreCase(strTrim, "on update CURRENT_TIMESTAMP") > -1) {
                                                    int iIndexOf = strTrim.indexOf(DatabaseMetaData.this.quotedId);
                                                    if (iIndexOf == -1) {
                                                        iIndexOf = strTrim.indexOf("\"");
                                                        z = false;
                                                    } else {
                                                        z = true;
                                                    }
                                                    if (iIndexOf != -1) {
                                                        int iIndexOf2 = z ? strTrim.indexOf(DatabaseMetaData.this.quotedId, iIndexOf + 1) : strTrim.indexOf("\"", iIndexOf + 1);
                                                        if (iIndexOf2 != -1) {
                                                            if (zVersionMeetsMinimum) {
                                                                if (z2) {
                                                                    z2 = false;
                                                                } else {
                                                                    sb.append(" or");
                                                                }
                                                                sb.append(" Field='");
                                                                sb.append(strTrim.substring(iIndexOf + 1, iIndexOf2));
                                                                sb.append("'");
                                                            } else {
                                                                arrayList2.add(strTrim.substring(iIndexOf + 1, iIndexOf2));
                                                            }
                                                        }
                                                    }
                                                }
                                                i = 2;
                                            }
                                        } catch (SQLException e) {
                                            e = e;
                                            resultSet = resultSetExecuteQuery;
                                            if (!SQLError.SQL_STATE_BASE_TABLE_OR_VIEW_NOT_FOUND.equals(e.getSQLState())) {
                                                throw e;
                                            }
                                            if (resultSet == null) {
                                                return;
                                            } else {
                                                resultSet.close();
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            resultSet = resultSetExecuteQuery;
                                            if (resultSet != null) {
                                                try {
                                                    resultSet.close();
                                                } catch (Exception unused) {
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                }
                                if (sb.length() > 0 || arrayList2.size() > 0) {
                                    StringBuilder sb2 = new StringBuilder("SHOW COLUMNS FROM ");
                                    String str5 = str3;
                                    DatabaseMetaData databaseMetaData = DatabaseMetaData.this;
                                    sb2.append(StringUtils.quoteIdentifier(str5, databaseMetaData.quotedId, databaseMetaData.conn.getPedantic()));
                                    sb2.append(" FROM ");
                                    DatabaseMetaData databaseMetaData2 = DatabaseMetaData.this;
                                    sb2.append(StringUtils.quoteIdentifier(str4, databaseMetaData2.quotedId, databaseMetaData2.conn.getPedantic()));
                                    if (zVersionMeetsMinimum) {
                                        sb2.append(" WHERE");
                                        sb2.append(sb.toString());
                                    }
                                    resultSetExecuteQuery = metadataSafeStatement.executeQuery(sb2.toString());
                                    while (resultSetExecuteQuery.next()) {
                                        if (zVersionMeetsMinimum || arrayList2.contains(resultSetExecuteQuery.getString("Field"))) {
                                            TypeDescriptor typeDescriptor = DatabaseMetaData.this.new TypeDescriptor(resultSetExecuteQuery.getString("Type"), resultSetExecuteQuery.getString("Null"));
                                            byte[][] bArr = new byte[8][];
                                            bArr[0] = null;
                                            bArr[1] = resultSetExecuteQuery.getBytes("Field");
                                            bArr[2] = Short.toString(typeDescriptor.dataType).getBytes();
                                            bArr[3] = DatabaseMetaData.this.s2b(typeDescriptor.typeName);
                                            Integer num = typeDescriptor.columnSize;
                                            bArr[4] = num == null ? null : DatabaseMetaData.this.s2b(num.toString());
                                            bArr[5] = DatabaseMetaData.this.s2b(Integer.toString(typeDescriptor.bufferLength));
                                            Integer num2 = typeDescriptor.decimalDigits;
                                            bArr[6] = num2 == null ? null : DatabaseMetaData.this.s2b(num2.toString());
                                            bArr[7] = Integer.toString(1).getBytes();
                                            arrayList.add(new ByteArrayRow(bArr, DatabaseMetaData.this.getExceptionInterceptor()));
                                        }
                                    }
                                }
                                if (resultSetExecuteQuery != null) {
                                    resultSetExecuteQuery.close();
                                }
                            } catch (SQLException e2) {
                                e = e2;
                            }
                        } catch (Exception unused2) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }.doForAll();
            return buildResultSet(fieldArr, arrayList);
        } finally {
            if (metadataSafeStatement != null) {
                metadataSafeStatement.close();
            }
        }
    }

    @Override // java.sql.DatabaseMetaData
    public boolean insertsAreDetected(int i) throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean isCatalogAtStart() throws SQLException {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean isReadOnly() throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean locatorsUpdateCopy() throws SQLException {
        return !this.conn.getEmulateLocators();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean nullPlusNonNullIsNull() throws SQLException {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean nullsAreSortedAtEnd() throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean nullsAreSortedAtStart() throws SQLException {
        return this.conn.versionMeetsMinimum(4, 0, 2) && !this.conn.versionMeetsMinimum(4, 0, 11);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean nullsAreSortedHigh() throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean nullsAreSortedLow() throws SQLException {
        return !nullsAreSortedHigh();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean othersDeletesAreVisible(int i) throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean othersInsertsAreVisible(int i) throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean othersUpdatesAreVisible(int i) throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean ownDeletesAreVisible(int i) throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean ownInsertsAreVisible(int i) throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean ownUpdatesAreVisible(int i) throws SQLException {
        return false;
    }

    public LocalAndReferencedColumns parseTableStatusIntoLocalAndReferencedColumns(String str) throws SQLException {
        String str2 = this.quotedId;
        Set<StringUtils.SearchMode> set = StringUtils.SEARCH_MODE__ALL;
        int iIndexOfIgnoreCase = StringUtils.indexOfIgnoreCase(0, str, "(", str2, str2, set);
        if (iIndexOfIgnoreCase == -1) {
            throw SQLError.createSQLException("Error parsing foreign keys definition, couldn't find start of local columns list.", SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
        }
        String strUnQuoteIdentifier = StringUtils.unQuoteIdentifier(str.substring(0, iIndexOfIgnoreCase).trim(), this.quotedId);
        String strTrim = str.substring(iIndexOfIgnoreCase, str.length()).trim();
        String str3 = this.quotedId;
        int iIndexOfIgnoreCase2 = StringUtils.indexOfIgnoreCase(0, strTrim, ")", str3, str3, set);
        if (iIndexOfIgnoreCase2 == -1) {
            throw SQLError.createSQLException("Error parsing foreign keys definition, couldn't find end of local columns list.", SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
        }
        String strSubstring = strTrim.substring(1, iIndexOfIgnoreCase2);
        String str4 = this.quotedId;
        int iIndexOfIgnoreCase3 = StringUtils.indexOfIgnoreCase(0, strTrim, "REFER ", str4, str4, set);
        if (iIndexOfIgnoreCase3 == -1) {
            throw SQLError.createSQLException("Error parsing foreign keys definition, couldn't find start of referenced tables list.", SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
        }
        String str5 = this.quotedId;
        Set<StringUtils.SearchMode> set2 = StringUtils.SEARCH_MODE__MRK_COM_WS;
        int iIndexOfIgnoreCase4 = StringUtils.indexOfIgnoreCase(iIndexOfIgnoreCase3, strTrim, "(", str5, str5, set2);
        if (iIndexOfIgnoreCase4 == -1) {
            throw SQLError.createSQLException("Error parsing foreign keys definition, couldn't find start of referenced columns list.", SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
        }
        String strSubstring2 = strTrim.substring(iIndexOfIgnoreCase3 + 6, iIndexOfIgnoreCase4);
        String str6 = this.quotedId;
        int iIndexOfIgnoreCase5 = StringUtils.indexOfIgnoreCase(0, strSubstring2, "/", str6, str6, set2);
        if (iIndexOfIgnoreCase5 == -1) {
            throw SQLError.createSQLException("Error parsing foreign keys definition, couldn't find name of referenced catalog.", SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
        }
        String strUnQuoteIdentifier2 = StringUtils.unQuoteIdentifier(strSubstring2.substring(0, iIndexOfIgnoreCase5), this.quotedId);
        String strUnQuoteIdentifier3 = StringUtils.unQuoteIdentifier(strSubstring2.substring(iIndexOfIgnoreCase5 + 1).trim(), this.quotedId);
        String str7 = this.quotedId;
        int iIndexOfIgnoreCase6 = StringUtils.indexOfIgnoreCase(iIndexOfIgnoreCase4, strTrim, ")", str7, str7, set);
        if (iIndexOfIgnoreCase6 == -1) {
            throw SQLError.createSQLException("Error parsing foreign keys definition, couldn't find end of referenced columns list.", SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
        }
        String strSubstring3 = strTrim.substring(iIndexOfIgnoreCase4 + 1, iIndexOfIgnoreCase6);
        String str8 = this.quotedId;
        List<String> listSplit = StringUtils.split(strSubstring3, ",", str8, str8, false);
        String str9 = this.quotedId;
        return new LocalAndReferencedColumns(StringUtils.split(strSubstring, ",", str9, str9, false), listSplit, strUnQuoteIdentifier, strUnQuoteIdentifier2, strUnQuoteIdentifier3);
    }

    public java.sql.PreparedStatement prepareMetaDataSafeStatement(String str) throws SQLException {
        java.sql.PreparedStatement preparedStatementClientPrepareStatement = this.conn.clientPrepareStatement(str);
        if (preparedStatementClientPrepareStatement.getMaxRows() != 0) {
            preparedStatementClientPrepareStatement.setMaxRows(0);
        }
        ((Statement) preparedStatementClientPrepareStatement).setHoldResultsOpenOverClose(true);
        return preparedStatementClientPrepareStatement;
    }

    public boolean providesQueryObjectGenerator() throws SQLException {
        return false;
    }

    public byte[] s2b(String str) throws SQLException {
        if (str == null) {
            return null;
        }
        return StringUtils.getBytes(str, this.conn.getCharacterSetMetadata(), this.conn.getServerCharset(), this.conn.parserKnowsUnicode(), this.conn, getExceptionInterceptor());
    }

    @Override // java.sql.DatabaseMetaData
    public boolean storesLowerCaseIdentifiers() throws SQLException {
        return this.conn.storesLowerCaseTableName();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean storesLowerCaseQuotedIdentifiers() throws SQLException {
        return this.conn.storesLowerCaseTableName();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean storesMixedCaseIdentifiers() throws SQLException {
        return !this.conn.storesLowerCaseTableName();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean storesMixedCaseQuotedIdentifiers() throws SQLException {
        return !this.conn.storesLowerCaseTableName();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean storesUpperCaseIdentifiers() throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean storesUpperCaseQuotedIdentifiers() throws SQLException {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsANSI92EntryLevelSQL() throws SQLException {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsANSI92FullSQL() throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsANSI92IntermediateSQL() throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsAlterTableWithAddColumn() throws SQLException {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsAlterTableWithDropColumn() throws SQLException {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsBatchUpdates() throws SQLException {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsCatalogsInDataManipulation() throws SQLException {
        return this.conn.versionMeetsMinimum(3, 22, 0);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsCatalogsInIndexDefinitions() throws SQLException {
        return this.conn.versionMeetsMinimum(3, 22, 0);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsCatalogsInPrivilegeDefinitions() throws SQLException {
        return this.conn.versionMeetsMinimum(3, 22, 0);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsCatalogsInProcedureCalls() throws SQLException {
        return this.conn.versionMeetsMinimum(3, 22, 0);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsCatalogsInTableDefinitions() throws SQLException {
        return this.conn.versionMeetsMinimum(3, 22, 0);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsColumnAliasing() throws SQLException {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsConvert() throws SQLException {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x004a  */
    /* JADX WARN: Code duplicated, block: B:39:0x004d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x004e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:55:0x006b A[FALL_THROUGH, RETURN] */
    @Override // java.sql.DatabaseMetaData
    public boolean supportsConvert(int i, int i2) throws SQLException {
        if (i != 12) {
            if (i == 1111) {
                return i2 == -4 || i2 == -3 || i2 == -2 || i2 == -1 || i2 == 1 || i2 == 12;
            }
            switch (i) {
                case -6:
                case -5:
                    switch (i2) {
                        case -6:
                        case -5:
                        case -4:
                        case -3:
                        case -2:
                        case -1:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 12:
                            return true;
                        case 0:
                        case 9:
                        case 10:
                        case 11:
                        default:
                            return false;
                    }
                case -4:
                case -3:
                case -2:
                case -1:
                    break;
                default:
                    switch (i) {
                        case 1:
                            break;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                            switch (i2) {
                                case -6:
                                case -5:
                                case -4:
                                case -3:
                                case -2:
                                case -1:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 12:
                                    return true;
                                case 0:
                                case 9:
                                case 10:
                                case 11:
                                default:
                                    return false;
                            }
                        default:
                            switch (i) {
                                case 91:
                                    return i2 == -4 || i2 == -3 || i2 == -2 || i2 == -1 || i2 == 1 || i2 == 12;
                                case 92:
                                    return i2 == -4 || i2 == -3 || i2 == -2 || i2 == -1 || i2 == 1 || i2 == 12;
                                case 93:
                                    return i2 == -4 || i2 == -3 || i2 == -2 || i2 == -1 || i2 == 1 || i2 == 12 || i2 == 91 || i2 == 92;
                                default:
                                    return false;
                            }
                    }
                    break;
            }
        }
        if (i2 != 12 && i2 != 1111) {
            switch (i2) {
                default:
                    switch (i2) {
                        default:
                            switch (i2) {
                                case 91:
                                case 92:
                                case 93:
                                    break;
                                default:
                                    return false;
                            }
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                            return true;
                    }
                case -6:
                case -5:
                case -4:
                case -3:
                case -2:
                case -1:
                    return true;
            }
        }
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsCoreSQLGrammar() throws SQLException {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsCorrelatedSubqueries() throws SQLException {
        return this.conn.versionMeetsMinimum(4, 1, 0);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsDataDefinitionAndDataManipulationTransactions() throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsDataManipulationTransactionsOnly() throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsDifferentTableCorrelationNames() throws SQLException {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsExpressionsInOrderBy() throws SQLException {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsExtendedSQLGrammar() throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsFullOuterJoins() throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsGetGeneratedKeys() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsGroupBy() throws SQLException {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsGroupByBeyondSelect() throws SQLException {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsGroupByUnrelated() throws SQLException {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsIntegrityEnhancementFacility() throws SQLException {
        return this.conn.getOverrideSupportsIntegrityEnhancementFacility();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsLikeEscapeClause() throws SQLException {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsLimitedOuterJoins() throws SQLException {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsMinimumSQLGrammar() throws SQLException {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsMixedCaseIdentifiers() throws SQLException {
        return !this.conn.lowerCaseTableNames();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsMixedCaseQuotedIdentifiers() throws SQLException {
        return !this.conn.lowerCaseTableNames();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsMultipleOpenResults() throws SQLException {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsMultipleResultSets() throws SQLException {
        return this.conn.versionMeetsMinimum(4, 1, 0);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsMultipleTransactions() throws SQLException {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsNamedParameters() throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsNonNullableColumns() throws SQLException {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsOpenCursorsAcrossCommit() throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsOpenCursorsAcrossRollback() throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsOpenStatementsAcrossCommit() throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsOpenStatementsAcrossRollback() throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsOrderByUnrelated() throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsOuterJoins() throws SQLException {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsPositionedDelete() throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsPositionedUpdate() throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsResultSetConcurrency(int i, int i2) throws SQLException {
        switch (i) {
            case MysqlErrorNumbers.ER_YES /* 1003 */:
                if (i2 == 1007 || i2 == 1008) {
                    return true;
                }
                throw SQLError.createSQLException("Illegal arguments to supportsResultSetConcurrency()", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            case MysqlErrorNumbers.ER_CANT_CREATE_FILE /* 1004 */:
                if (i2 == 1007 || i2 == 1008) {
                    return true;
                }
                throw SQLError.createSQLException("Illegal arguments to supportsResultSetConcurrency()", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            case 1005:
                return false;
            default:
                throw SQLError.createSQLException("Illegal arguments to supportsResultSetConcurrency()", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsResultSetHoldability(int i) throws SQLException {
        return i == 1;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsResultSetType(int i) throws SQLException {
        return i == 1004;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsSavepoints() throws SQLException {
        return this.conn.versionMeetsMinimum(4, 0, 14) || this.conn.versionMeetsMinimum(4, 1, 1);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsSchemasInDataManipulation() throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsSchemasInIndexDefinitions() throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsSchemasInPrivilegeDefinitions() throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsSchemasInProcedureCalls() throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsSchemasInTableDefinitions() throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsSelectForUpdate() throws SQLException {
        return this.conn.versionMeetsMinimum(4, 0, 0);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsStatementPooling() throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsStoredFunctionsUsingCallSyntax() throws SQLException {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsStoredProcedures() throws SQLException {
        return this.conn.versionMeetsMinimum(5, 0, 0);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsSubqueriesInComparisons() throws SQLException {
        return this.conn.versionMeetsMinimum(4, 1, 0);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsSubqueriesInExists() throws SQLException {
        return this.conn.versionMeetsMinimum(4, 1, 0);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsSubqueriesInIns() throws SQLException {
        return this.conn.versionMeetsMinimum(4, 1, 0);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsSubqueriesInQuantifieds() throws SQLException {
        return this.conn.versionMeetsMinimum(4, 1, 0);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsTableCorrelationNames() throws SQLException {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsTransactionIsolationLevel(int i) throws SQLException {
        if (this.conn.supportsIsolationLevel()) {
            return i == 1 || i == 2 || i == 4 || i == 8;
        }
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsTransactions() throws SQLException {
        return this.conn.supportsTransactions();
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsUnion() throws SQLException {
        return this.conn.versionMeetsMinimum(4, 0, 0);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean supportsUnionAll() throws SQLException {
        return this.conn.versionMeetsMinimum(4, 0, 0);
    }

    @Override // java.sql.DatabaseMetaData
    public boolean updatesAreDetected(int i) throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean usesLocalFilePerTable() throws SQLException {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public boolean usesLocalFiles() throws SQLException {
        return false;
    }

    public static ResultSet buildResultSet(Field[] fieldArr, ArrayList<ResultSetRow> arrayList, MySQLConnection mySQLConnection) throws SQLException {
        int length = fieldArr.length;
        for (int i = 0; i < length; i++) {
            int sQLType = fieldArr[i].getSQLType();
            if (sQLType == -1 || sQLType == 1 || sQLType == 12) {
                fieldArr[i].setEncoding(mySQLConnection.getCharacterSetMetadata(), mySQLConnection);
            }
            fieldArr[i].setConnection(mySQLConnection);
            fieldArr[i].setUseOldNameMetadata(true);
        }
        return ResultSetImpl.getInstance(mySQLConnection.getCatalog(), fieldArr, new RowDataStatic(arrayList), mySQLConnection, null, false);
    }

    @Override // java.sql.DatabaseMetaData
    public ResultSet getSchemas(String str, String str2) throws SQLException {
        return buildResultSet(new Field[]{new Field(BuildConfig.FLAVOR, "TABLE_SCHEM", 12, 255), new Field(BuildConfig.FLAVOR, "TABLE_CATALOG", 12, 255)}, new ArrayList<>());
    }
}
