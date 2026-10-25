package com.mysql.jdbc;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class MysqlDefs {
    public static final int COM_BINLOG_DUMP = 18;
    public static final int COM_CHANGE_USER = 17;
    public static final int COM_CLOSE_STATEMENT = 25;
    public static final int COM_CONNECT_OUT = 20;
    public static final int COM_END = 29;
    public static final int COM_EXECUTE = 23;
    public static final int COM_FETCH = 28;
    public static final int COM_LONG_DATA = 24;
    public static final int COM_PREPARE = 22;
    public static final int COM_REGISTER_SLAVE = 21;
    public static final int COM_RESET_STMT = 26;
    public static final int COM_SET_OPTION = 27;
    public static final int COM_TABLE_DUMP = 19;
    public static final int CONNECT = 11;
    public static final int CREATE_DB = 5;
    public static final int DEBUG = 13;
    public static final int DELAYED_INSERT = 16;
    public static final int DROP_DB = 6;
    public static final int FIELD_LIST = 4;
    public static final int FIELD_TYPE_BIT = 16;
    public static final int FIELD_TYPE_BLOB = 252;
    public static final int FIELD_TYPE_DATE = 10;
    public static final int FIELD_TYPE_DATETIME = 12;
    public static final int FIELD_TYPE_DECIMAL = 0;
    public static final int FIELD_TYPE_DOUBLE = 5;
    public static final int FIELD_TYPE_ENUM = 247;
    public static final int FIELD_TYPE_FLOAT = 4;
    public static final int FIELD_TYPE_GEOMETRY = 255;
    public static final int FIELD_TYPE_INT24 = 9;
    public static final int FIELD_TYPE_JSON = 245;
    public static final int FIELD_TYPE_LONG = 3;
    public static final int FIELD_TYPE_LONGLONG = 8;
    public static final int FIELD_TYPE_LONG_BLOB = 251;
    public static final int FIELD_TYPE_MEDIUM_BLOB = 250;
    public static final int FIELD_TYPE_NEWDATE = 14;
    public static final int FIELD_TYPE_NEW_DECIMAL = 246;
    public static final int FIELD_TYPE_NULL = 6;
    public static final int FIELD_TYPE_SET = 248;
    public static final int FIELD_TYPE_SHORT = 2;
    public static final int FIELD_TYPE_STRING = 254;
    public static final int FIELD_TYPE_TIME = 11;
    public static final int FIELD_TYPE_TIMESTAMP = 7;
    public static final int FIELD_TYPE_TINY = 1;
    public static final int FIELD_TYPE_TINY_BLOB = 249;
    public static final int FIELD_TYPE_VARCHAR = 15;
    public static final int FIELD_TYPE_VAR_STRING = 253;
    public static final int FIELD_TYPE_YEAR = 13;
    public static final int INIT_DB = 2;
    public static final long LENGTH_BLOB = 65535;
    public static final long LENGTH_LONGBLOB = 4294967295L;
    public static final long LENGTH_MEDIUMBLOB = 16777215;
    public static final long LENGTH_TINYBLOB = 255;
    public static final int MAX_ROWS = 50000000;
    public static final int NO_CHARSET_INFO = -1;
    public static final byte OPEN_CURSOR_FLAG = 1;
    public static final int PING = 14;
    public static final int PROCESS_INFO = 10;
    public static final int PROCESS_KILL = 12;
    public static final int QUERY = 3;
    public static final int QUIT = 1;
    public static final int RELOAD = 7;
    public static final int SHUTDOWN = 8;
    public static final int SLEEP = 0;
    public static final int STATISTICS = 9;
    public static final int TIME = 15;
    private static Map<String, Integer> mysqlToJdbcTypesMap;

    static {
        HashMap map = new HashMap();
        mysqlToJdbcTypesMap = map;
        map.put("BIT", Integer.valueOf(mysqlToJavaType(16)));
        mysqlToJdbcTypesMap.put("TINYINT", Integer.valueOf(mysqlToJavaType(1)));
        mysqlToJdbcTypesMap.put("SMALLINT", Integer.valueOf(mysqlToJavaType(2)));
        mysqlToJdbcTypesMap.put("MEDIUMINT", Integer.valueOf(mysqlToJavaType(9)));
        mysqlToJdbcTypesMap.put("INT", Integer.valueOf(mysqlToJavaType(3)));
        mysqlToJdbcTypesMap.put("INTEGER", Integer.valueOf(mysqlToJavaType(3)));
        mysqlToJdbcTypesMap.put("BIGINT", Integer.valueOf(mysqlToJavaType(8)));
        mysqlToJdbcTypesMap.put("INT24", Integer.valueOf(mysqlToJavaType(9)));
        mysqlToJdbcTypesMap.put("REAL", Integer.valueOf(mysqlToJavaType(5)));
        mysqlToJdbcTypesMap.put("FLOAT", Integer.valueOf(mysqlToJavaType(4)));
        mysqlToJdbcTypesMap.put("DECIMAL", Integer.valueOf(mysqlToJavaType(0)));
        mysqlToJdbcTypesMap.put("NUMERIC", Integer.valueOf(mysqlToJavaType(0)));
        mysqlToJdbcTypesMap.put("DOUBLE", Integer.valueOf(mysqlToJavaType(5)));
        mysqlToJdbcTypesMap.put("CHAR", Integer.valueOf(mysqlToJavaType(FIELD_TYPE_STRING)));
        mysqlToJdbcTypesMap.put("VARCHAR", Integer.valueOf(mysqlToJavaType(FIELD_TYPE_VAR_STRING)));
        mysqlToJdbcTypesMap.put("DATE", Integer.valueOf(mysqlToJavaType(10)));
        mysqlToJdbcTypesMap.put("TIME", Integer.valueOf(mysqlToJavaType(11)));
        mysqlToJdbcTypesMap.put("YEAR", Integer.valueOf(mysqlToJavaType(13)));
        mysqlToJdbcTypesMap.put("TIMESTAMP", Integer.valueOf(mysqlToJavaType(7)));
        mysqlToJdbcTypesMap.put("DATETIME", Integer.valueOf(mysqlToJavaType(12)));
        mysqlToJdbcTypesMap.put("TINYBLOB", -2);
        mysqlToJdbcTypesMap.put("BLOB", -4);
        mysqlToJdbcTypesMap.put("MEDIUMBLOB", -4);
        mysqlToJdbcTypesMap.put("LONGBLOB", -4);
        mysqlToJdbcTypesMap.put("TINYTEXT", 12);
        mysqlToJdbcTypesMap.put("TEXT", -1);
        mysqlToJdbcTypesMap.put("MEDIUMTEXT", -1);
        mysqlToJdbcTypesMap.put("LONGTEXT", -1);
        mysqlToJdbcTypesMap.put("ENUM", Integer.valueOf(mysqlToJavaType(FIELD_TYPE_ENUM)));
        mysqlToJdbcTypesMap.put("SET", Integer.valueOf(mysqlToJavaType(FIELD_TYPE_SET)));
        mysqlToJdbcTypesMap.put("GEOMETRY", Integer.valueOf(mysqlToJavaType(255)));
        mysqlToJdbcTypesMap.put("JSON", Integer.valueOf(mysqlToJavaType(FIELD_TYPE_JSON)));
    }

    public static final void appendJdbcTypeMappingQuery(StringBuilder sb, String str) {
        sb.append("CASE ");
        HashMap map = new HashMap();
        map.putAll(mysqlToJdbcTypesMap);
        map.put("BINARY", -2);
        map.put("VARBINARY", -3);
        for (String str2 : map.keySet()) {
            sb.append(" WHEN UPPER(");
            sb.append(str);
            sb.append(")='");
            sb.append(str2);
            sb.append("' THEN ");
            sb.append(map.get(str2));
            if (str2.equalsIgnoreCase("DOUBLE") || str2.equalsIgnoreCase("FLOAT") || str2.equalsIgnoreCase("DECIMAL") || str2.equalsIgnoreCase("NUMERIC")) {
                sb.append(" WHEN ");
                sb.append(str);
                sb.append("='");
                sb.append(str2);
                sb.append(" UNSIGNED' THEN ");
                sb.append(map.get(str2));
            }
        }
        sb.append(" ELSE ");
        sb.append(MysqlErrorNumbers.ER_INVALID_GROUP_FUNC_USE);
        sb.append(" END ");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:21:0x0032 A[ORIG_RETURN, RETURN] */
    public static int mysqlToJavaType(int i) {
        switch (i) {
            case 0:
                return 3;
            case 1:
                return -6;
            case 2:
                return 5;
            case 3:
            case 9:
                return 4;
            case 4:
                return 7;
            case 5:
                return 8;
            case 6:
                return 0;
            case 7:
            case 12:
                return 93;
            case 8:
                return -5;
            case 10:
            case 13:
            case 14:
                return 91;
            case 11:
                return 92;
            case 15:
                return 12;
            case 16:
                return -7;
            default:
                switch (i) {
                    case FIELD_TYPE_JSON /* 245 */:
                    case FIELD_TYPE_ENUM /* 247 */:
                    case FIELD_TYPE_SET /* 248 */:
                    case FIELD_TYPE_STRING /* 254 */:
                        return 1;
                    case FIELD_TYPE_NEW_DECIMAL /* 246 */:
                        return 3;
                    case FIELD_TYPE_TINY_BLOB /* 249 */:
                        return -3;
                    case 250:
                    case FIELD_TYPE_LONG_BLOB /* 251 */:
                    case FIELD_TYPE_BLOB /* 252 */:
                        return -4;
                    case FIELD_TYPE_VAR_STRING /* 253 */:
                    default:
                        return 12;
                    case 255:
                        return -2;
                }
        }
    }

    public static int mysqlToJavaType(String str) {
        if (str.equalsIgnoreCase("BIT")) {
            return mysqlToJavaType(16);
        }
        if (str.equalsIgnoreCase("TINYINT")) {
            return mysqlToJavaType(1);
        }
        if (str.equalsIgnoreCase("SMALLINT")) {
            return mysqlToJavaType(2);
        }
        if (str.equalsIgnoreCase("MEDIUMINT")) {
            return mysqlToJavaType(9);
        }
        if (str.equalsIgnoreCase("INT") || str.equalsIgnoreCase("INTEGER")) {
            return mysqlToJavaType(3);
        }
        if (str.equalsIgnoreCase("BIGINT")) {
            return mysqlToJavaType(8);
        }
        if (str.equalsIgnoreCase("INT24")) {
            return mysqlToJavaType(9);
        }
        if (str.equalsIgnoreCase("REAL")) {
            return mysqlToJavaType(5);
        }
        if (str.equalsIgnoreCase("FLOAT")) {
            return mysqlToJavaType(4);
        }
        if (str.equalsIgnoreCase("DECIMAL")) {
            return mysqlToJavaType(0);
        }
        if (str.equalsIgnoreCase("NUMERIC")) {
            return mysqlToJavaType(0);
        }
        if (str.equalsIgnoreCase("DOUBLE")) {
            return mysqlToJavaType(5);
        }
        if (str.equalsIgnoreCase("CHAR")) {
            return mysqlToJavaType(FIELD_TYPE_STRING);
        }
        if (str.equalsIgnoreCase("VARCHAR")) {
            return mysqlToJavaType(FIELD_TYPE_VAR_STRING);
        }
        if (str.equalsIgnoreCase("DATE")) {
            return mysqlToJavaType(10);
        }
        if (str.equalsIgnoreCase("TIME")) {
            return mysqlToJavaType(11);
        }
        if (str.equalsIgnoreCase("YEAR")) {
            return mysqlToJavaType(13);
        }
        if (str.equalsIgnoreCase("TIMESTAMP")) {
            return mysqlToJavaType(7);
        }
        if (str.equalsIgnoreCase("DATETIME")) {
            return mysqlToJavaType(12);
        }
        if (str.equalsIgnoreCase("TINYBLOB")) {
            return -2;
        }
        if (str.equalsIgnoreCase("BLOB") || str.equalsIgnoreCase("MEDIUMBLOB") || str.equalsIgnoreCase("LONGBLOB")) {
            return -4;
        }
        if (str.equalsIgnoreCase("TINYTEXT")) {
            return 12;
        }
        if (str.equalsIgnoreCase("TEXT") || str.equalsIgnoreCase("MEDIUMTEXT") || str.equalsIgnoreCase("LONGTEXT")) {
            return -1;
        }
        if (str.equalsIgnoreCase("ENUM")) {
            return mysqlToJavaType(FIELD_TYPE_ENUM);
        }
        if (str.equalsIgnoreCase("SET")) {
            return mysqlToJavaType(FIELD_TYPE_SET);
        }
        if (str.equalsIgnoreCase("GEOMETRY")) {
            return mysqlToJavaType(255);
        }
        if (str.equalsIgnoreCase("BINARY")) {
            return -2;
        }
        if (str.equalsIgnoreCase("VARBINARY")) {
            return -3;
        }
        if (str.equalsIgnoreCase("BIT")) {
            return mysqlToJavaType(16);
        }
        return str.equalsIgnoreCase("JSON") ? mysqlToJavaType(FIELD_TYPE_JSON) : MysqlErrorNumbers.ER_INVALID_GROUP_FUNC_USE;
    }

    public static String typeToName(int i) {
        if (i == 245) {
            return "FIELD_TYPE_JSON";
        }
        switch (i) {
            case 0:
                return "FIELD_TYPE_DECIMAL";
            case 1:
                return "FIELD_TYPE_TINY";
            case 2:
                return "FIELD_TYPE_SHORT";
            case 3:
                return "FIELD_TYPE_LONG";
            case 4:
                return "FIELD_TYPE_FLOAT";
            case 5:
                return "FIELD_TYPE_DOUBLE";
            case 6:
                return "FIELD_TYPE_NULL";
            case 7:
                return "FIELD_TYPE_TIMESTAMP";
            case 8:
                return "FIELD_TYPE_LONGLONG";
            case 9:
                return "FIELD_TYPE_INT24";
            case 10:
                return "FIELD_TYPE_DATE";
            case 11:
                return "FIELD_TYPE_TIME";
            case 12:
                return "FIELD_TYPE_DATETIME";
            case 13:
                return "FIELD_TYPE_YEAR";
            case 14:
                return "FIELD_TYPE_NEWDATE";
            case 15:
                return "FIELD_TYPE_VARCHAR";
            case 16:
                return "FIELD_TYPE_BIT";
            default:
                switch (i) {
                    case FIELD_TYPE_ENUM /* 247 */:
                        return "FIELD_TYPE_ENUM";
                    case FIELD_TYPE_SET /* 248 */:
                        return "FIELD_TYPE_SET";
                    case FIELD_TYPE_TINY_BLOB /* 249 */:
                        return "FIELD_TYPE_TINY_BLOB";
                    case 250:
                        return "FIELD_TYPE_MEDIUM_BLOB";
                    case FIELD_TYPE_LONG_BLOB /* 251 */:
                        return "FIELD_TYPE_LONG_BLOB";
                    case FIELD_TYPE_BLOB /* 252 */:
                        return "FIELD_TYPE_BLOB";
                    case FIELD_TYPE_VAR_STRING /* 253 */:
                        return "FIELD_TYPE_VAR_STRING";
                    case FIELD_TYPE_STRING /* 254 */:
                        return "FIELD_TYPE_STRING";
                    case 255:
                        return "FIELD_TYPE_GEOMETRY";
                    default:
                        return " Unknown MySQL Type # " + i;
                }
        }
    }
}
