package com.mysql.jdbc;

import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.exceptions.MySQLDataException;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.mysql.jdbc.exceptions.MySQLNonTransientConnectionException;
import com.mysql.jdbc.exceptions.MySQLQueryInterruptedException;
import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;
import com.mysql.jdbc.exceptions.MySQLTransactionRollbackException;
import com.mysql.jdbc.exceptions.MySQLTransientConnectionException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.net.BindException;
import java.sql.BatchUpdateException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class SQLError {
    private static final long DEFAULT_WAIT_TIMEOUT_SECONDS = 28800;
    private static final int DUE_TO_TIMEOUT_FALSE = 0;
    private static final int DUE_TO_TIMEOUT_MAYBE = 2;
    private static final int DUE_TO_TIMEOUT_TRUE = 1;
    public static final int ER_WARNING_NOT_COMPLETE_ROLLBACK = 1196;
    private static final Constructor<?> JDBC_4_COMMUNICATIONS_EXCEPTION_CTOR;
    public static final String SQL_STATE_ACTIVE_SQL_TRANSACTION = "25001";
    public static final String SQL_STATE_BASE_TABLE_NOT_FOUND = "S0002";
    public static final String SQL_STATE_BASE_TABLE_OR_VIEW_ALREADY_EXISTS = "S0001";
    public static final String SQL_STATE_BASE_TABLE_OR_VIEW_NOT_FOUND = "42S02";
    public static final String SQL_STATE_CARDINALITY_VIOLATION = "21000";
    public static final String SQL_STATE_CASE_NOT_FOUND_FOR_CASE_STATEMENT = "20000";
    public static final String SQL_STATE_CLI_SPECIFIC_CONDITION = "HY000";
    public static final String SQL_STATE_COLUMN_ALREADY_EXISTS = "S0021";
    public static final String SQL_STATE_COLUMN_NOT_FOUND = "S0022";
    public static final String SQL_STATE_COMMUNICATION_LINK_FAILURE = "08S01";
    public static final String SQL_STATE_CONNECTION_FAILURE = "08006";
    public static final String SQL_STATE_CONNECTION_IN_USE = "08002";
    public static final String SQL_STATE_CONNECTION_NOT_OPEN = "08003";
    public static final String SQL_STATE_CONNECTION_REJECTED = "08004";
    public static final String SQL_STATE_DATA_TRUNCATED = "01004";
    public static final String SQL_STATE_DATETIME_FIELD_OVERFLOW = "22008";
    public static final String SQL_STATE_DISCONNECT_ERROR = "01002";
    public static final String SQL_STATE_DIVISION_BY_ZERO = "22012";
    public static final String SQL_STATE_DRIVER_NOT_CAPABLE = "S1C00";
    public static final String SQL_STATE_ERROR_IN_ROW = "01S01";
    public static final String SQL_STATE_ER_BAD_FIELD_ERROR = "42S22";
    public static final String SQL_STATE_ER_DUP_FIELDNAME = "42S21";
    public static final String SQL_STATE_ER_NO_SUCH_INDEX = "42S12";
    public static final String SQL_STATE_ER_QUERY_INTERRUPTED = "70100";
    public static final String SQL_STATE_ER_TABLE_EXISTS_ERROR = "42S01";
    public static final String SQL_STATE_FEATURE_NOT_SUPPORTED = "0A000";
    public static final String SQL_STATE_GENERAL_ERROR = "S1000";
    public static final String SQL_STATE_ILLEGAL_ARGUMENT = "S1009";
    public static final String SQL_STATE_INDEX_ALREADY_EXISTS = "S0011";
    public static final String SQL_STATE_INDEX_NOT_FOUND = "S0012";
    public static final String SQL_STATE_INSERT_VALUE_LIST_NO_MATCH_COL_LIST = "21S01";
    public static final String SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION = "23000";
    public static final String SQL_STATE_INVALID_AUTH_SPEC = "28000";
    public static final String SQL_STATE_INVALID_CATALOG_NAME = "3D000";
    public static final String SQL_STATE_INVALID_CHARACTER_VALUE_FOR_CAST = "22018";
    public static final String SQL_STATE_INVALID_COLUMN_NUMBER = "S1002";
    public static final String SQL_STATE_INVALID_CONDITION_NUMBER = "35000";
    public static final String SQL_STATE_INVALID_CONNECTION_ATTRIBUTE = "01S00";
    public static final String SQL_STATE_INVALID_CURSOR_STATE = "24000";
    public static final String SQL_STATE_INVALID_DATETIME_FORMAT = "22007";
    public static final String SQL_STATE_INVALID_LOGARITHM_ARGUMENT = "2201E";
    public static final String SQL_STATE_INVALID_TRANSACTION_STATE = "25000";
    public static final String SQL_STATE_INVALID_TRANSACTION_TERMINATION = "2D000";
    public static final String SQL_STATE_MEMORY_ALLOCATION_ERROR = "HY001";
    public static final String SQL_STATE_MEMORY_ALLOCATION_FAILURE = "S1001";
    public static final String SQL_STATE_MORE_THAN_ONE_ROW_UPDATED_OR_DELETED = "01S04";
    public static final String SQL_STATE_NO_DATA = "02000";
    public static final String SQL_STATE_NO_DEFAULT_FOR_COLUMN = "S0023";
    public static final String SQL_STATE_NO_ROWS_UPDATED_OR_DELETED = "01S03";
    public static final String SQL_STATE_NULL_VALUE_NOT_ALLOWED = "22004";
    public static final String SQL_STATE_NUMERIC_VALUE_OUT_OF_RANGE = "22003";
    public static final String SQL_STATE_PRIVILEGE_NOT_REVOKED = "01006";
    public static final String SQL_STATE_READ_ONLY_SQL_TRANSACTION = "25006";
    public static final String SQL_STATE_RESIGNAL_WHEN_HANDLER_NOT_ACTIVE = "0K000";
    public static final String SQL_STATE_ROLLBACK_SERIALIZATION_FAILURE = "40001";
    public static final String SQL_STATE_SRE_FUNCTION_EXECUTED_NO_RETURN_STATEMENT = "2F005";
    public static final String SQL_STATE_SRE_PROHIBITED_SQL_STATEMENT_ATTEMPTED = "2F003";
    public static final String SQL_STATE_STACKED_DIAGNOSTICS_ACCESSED_WITHOUT_ACTIVE_HANDLER = "0Z002";
    public static final String SQL_STATE_STRING_DATA_RIGHT_TRUNCATION = "22001";
    public static final String SQL_STATE_SYNTAX_ERROR = "42000";
    public static final String SQL_STATE_TIMEOUT_EXPIRED = "S1T00";
    public static final String SQL_STATE_TRANSACTION_RESOLUTION_UNKNOWN = "08007";
    public static final String SQL_STATE_UNABLE_TO_CONNECT_TO_DATASOURCE = "08001";
    public static final String SQL_STATE_WARNING = "01000";
    public static final String SQL_STATE_WRONG_NO_OF_PARAMETERS = "07001";
    public static final String SQL_STATE_XAER_DUPID = "XAE08";
    public static final String SQL_STATE_XAER_INVAL = "XAE05";
    public static final String SQL_STATE_XAER_NOTA = "XAE04";
    public static final String SQL_STATE_XAER_OUTSIDE = "XAE09";
    public static final String SQL_STATE_XAER_RMFAIL = "XAE07";
    public static final String SQL_STATE_XA_RBDEADLOCK = "XA102";
    public static final String SQL_STATE_XA_RBROLLBACK = "XA100";
    public static final String SQL_STATE_XA_RBTIMEOUT = "XA106";
    public static final String SQL_STATE_XA_RMERR = "XAE03";
    private static Map<Integer, String> mysqlToSql99State;
    private static Map<Integer, String> mysqlToSqlState;
    private static Map<String, String> sqlStateMessages;

    static {
        if (Util.isJdbc4()) {
            try {
                Class<?> cls = Class.forName("com.mysql.jdbc.exceptions.jdbc4.CommunicationsException");
                Class<?> cls2 = Long.TYPE;
                JDBC_4_COMMUNICATIONS_EXCEPTION_CTOR = cls.getConstructor(MySQLConnection.class, cls2, cls2, Exception.class);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException(e2);
            } catch (SecurityException e3) {
                throw new RuntimeException(e3);
            }
        } else {
            JDBC_4_COMMUNICATIONS_EXCEPTION_CTOR = null;
        }
        HashMap map = new HashMap();
        sqlStateMessages = map;
        map.put(SQL_STATE_DISCONNECT_ERROR, Messages.getString("SQLError.35"));
        sqlStateMessages.put(SQL_STATE_DATA_TRUNCATED, Messages.getString("SQLError.36"));
        sqlStateMessages.put(SQL_STATE_PRIVILEGE_NOT_REVOKED, Messages.getString("SQLError.37"));
        sqlStateMessages.put(SQL_STATE_INVALID_CONNECTION_ATTRIBUTE, Messages.getString("SQLError.38"));
        sqlStateMessages.put(SQL_STATE_ERROR_IN_ROW, Messages.getString("SQLError.39"));
        sqlStateMessages.put(SQL_STATE_NO_ROWS_UPDATED_OR_DELETED, Messages.getString("SQLError.40"));
        sqlStateMessages.put(SQL_STATE_MORE_THAN_ONE_ROW_UPDATED_OR_DELETED, Messages.getString("SQLError.41"));
        sqlStateMessages.put(SQL_STATE_WRONG_NO_OF_PARAMETERS, Messages.getString("SQLError.42"));
        sqlStateMessages.put(SQL_STATE_UNABLE_TO_CONNECT_TO_DATASOURCE, Messages.getString("SQLError.43"));
        sqlStateMessages.put(SQL_STATE_CONNECTION_IN_USE, Messages.getString("SQLError.44"));
        sqlStateMessages.put(SQL_STATE_CONNECTION_NOT_OPEN, Messages.getString("SQLError.45"));
        sqlStateMessages.put(SQL_STATE_CONNECTION_REJECTED, Messages.getString("SQLError.46"));
        sqlStateMessages.put(SQL_STATE_TRANSACTION_RESOLUTION_UNKNOWN, Messages.getString("SQLError.47"));
        sqlStateMessages.put(SQL_STATE_COMMUNICATION_LINK_FAILURE, Messages.getString("SQLError.48"));
        sqlStateMessages.put(SQL_STATE_INSERT_VALUE_LIST_NO_MATCH_COL_LIST, Messages.getString("SQLError.49"));
        sqlStateMessages.put(SQL_STATE_NUMERIC_VALUE_OUT_OF_RANGE, Messages.getString("SQLError.50"));
        sqlStateMessages.put(SQL_STATE_DATETIME_FIELD_OVERFLOW, Messages.getString("SQLError.51"));
        sqlStateMessages.put(SQL_STATE_DIVISION_BY_ZERO, Messages.getString("SQLError.52"));
        sqlStateMessages.put(SQL_STATE_ROLLBACK_SERIALIZATION_FAILURE, Messages.getString("SQLError.53"));
        sqlStateMessages.put(SQL_STATE_INVALID_AUTH_SPEC, Messages.getString("SQLError.54"));
        sqlStateMessages.put(SQL_STATE_SYNTAX_ERROR, Messages.getString("SQLError.55"));
        sqlStateMessages.put(SQL_STATE_BASE_TABLE_OR_VIEW_NOT_FOUND, Messages.getString("SQLError.56"));
        sqlStateMessages.put(SQL_STATE_BASE_TABLE_OR_VIEW_ALREADY_EXISTS, Messages.getString("SQLError.57"));
        sqlStateMessages.put(SQL_STATE_BASE_TABLE_NOT_FOUND, Messages.getString("SQLError.58"));
        sqlStateMessages.put(SQL_STATE_INDEX_ALREADY_EXISTS, Messages.getString("SQLError.59"));
        sqlStateMessages.put(SQL_STATE_INDEX_NOT_FOUND, Messages.getString("SQLError.60"));
        sqlStateMessages.put(SQL_STATE_COLUMN_ALREADY_EXISTS, Messages.getString("SQLError.61"));
        sqlStateMessages.put(SQL_STATE_COLUMN_NOT_FOUND, Messages.getString("SQLError.62"));
        sqlStateMessages.put(SQL_STATE_NO_DEFAULT_FOR_COLUMN, Messages.getString("SQLError.63"));
        sqlStateMessages.put(SQL_STATE_GENERAL_ERROR, Messages.getString("SQLError.64"));
        sqlStateMessages.put(SQL_STATE_MEMORY_ALLOCATION_FAILURE, Messages.getString("SQLError.65"));
        sqlStateMessages.put(SQL_STATE_INVALID_COLUMN_NUMBER, Messages.getString("SQLError.66"));
        sqlStateMessages.put(SQL_STATE_ILLEGAL_ARGUMENT, Messages.getString("SQLError.67"));
        sqlStateMessages.put(SQL_STATE_DRIVER_NOT_CAPABLE, Messages.getString("SQLError.68"));
        sqlStateMessages.put(SQL_STATE_TIMEOUT_EXPIRED, Messages.getString("SQLError.69"));
        Hashtable hashtable = new Hashtable();
        mysqlToSqlState = hashtable;
        hashtable.put(Integer.valueOf(MysqlErrorNumbers.ER_SELECT_REDUCED), SQL_STATE_WARNING);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_WARN_TOO_FEW_RECORDS), SQL_STATE_WARNING);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_WARN_TOO_MANY_RECORDS), SQL_STATE_WARNING);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_WARN_DATA_TRUNCATED), SQL_STATE_WARNING);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_UNINIT_VAR), SQL_STATE_WARNING);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SIGNAL_WARN), SQL_STATE_WARNING);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_CON_COUNT_ERROR), SQL_STATE_CONNECTION_REJECTED);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_NOT_SUPPORTED_AUTH_MODE), SQL_STATE_CONNECTION_REJECTED);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_BAD_HOST_ERROR), SQL_STATE_CONNECTION_REJECTED);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_HANDSHAKE_ERROR), SQL_STATE_CONNECTION_REJECTED);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_HOST_IS_BLOCKED), SQL_STATE_CONNECTION_REJECTED);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_HOST_NOT_PRIVILEGED), SQL_STATE_CONNECTION_REJECTED);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_UNKNOWN_COM_ERROR), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SERVER_SHUTDOWN), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_FORCING_CLOSE), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_IPSOCK_ERROR), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_ABORTING_CONNECTION), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_NET_PACKET_TOO_LARGE), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_NET_READ_ERROR_FROM_PIPE), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_NET_FCNTL_ERROR), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_NET_PACKETS_OUT_OF_ORDER), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_NET_UNCOMPRESS_ERROR), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_NET_READ_ERROR), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_NET_READ_INTERRUPTED), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_NET_ERROR_ON_WRITE), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_NET_WRITE_INTERRUPTED), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_NEW_ABORTING_CONNECTION), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_MASTER_NET_READ), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_MASTER_NET_WRITE), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_CONNECT_TO_MASTER), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_BADSELECT), SQL_STATE_FEATURE_NOT_SUPPORTED);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_BADSTATEMENT), SQL_STATE_FEATURE_NOT_SUPPORTED);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_SUBSELECT_NYI), SQL_STATE_FEATURE_NOT_SUPPORTED);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_STMT_NOT_ALLOWED_IN_SF_OR_TRG), SQL_STATE_FEATURE_NOT_SUPPORTED);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_NO_RETSET), SQL_STATE_FEATURE_NOT_SUPPORTED);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_ALTER_OPERATION_NOT_SUPPORTED), SQL_STATE_FEATURE_NOT_SUPPORTED);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_ALTER_OPERATION_NOT_SUPPORTED_REASON), SQL_STATE_FEATURE_NOT_SUPPORTED);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_DBACCESS_DENIED_ERROR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_BAD_DB_ERROR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_FIELD_WITH_GROUP), SQL_STATE_ILLEGAL_ARGUMENT);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_GROUP_FIELD), SQL_STATE_ILLEGAL_ARGUMENT);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_SUM_SELECT), SQL_STATE_ILLEGAL_ARGUMENT);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_LONG_IDENT), SQL_STATE_ILLEGAL_ARGUMENT);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_DUP_FIELDNAME), SQL_STATE_ILLEGAL_ARGUMENT);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_DUP_KEYNAME), SQL_STATE_ILLEGAL_ARGUMENT);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_DUP_ENTRY), SQL_STATE_ILLEGAL_ARGUMENT);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_FIELD_SPEC), SQL_STATE_ILLEGAL_ARGUMENT);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_PARSE_ERROR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_EMPTY_QUERY), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_NONUNIQ_TABLE), SQL_STATE_ILLEGAL_ARGUMENT);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_INVALID_DEFAULT), SQL_STATE_ILLEGAL_ARGUMENT);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_MULTIPLE_PRI_KEY), SQL_STATE_ILLEGAL_ARGUMENT);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_MANY_KEYS), SQL_STATE_ILLEGAL_ARGUMENT);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_MANY_KEY_PARTS), SQL_STATE_ILLEGAL_ARGUMENT);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_LONG_KEY), SQL_STATE_ILLEGAL_ARGUMENT);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_KEY_COLUMN_DOES_NOT_EXITS), SQL_STATE_ILLEGAL_ARGUMENT);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_BLOB_USED_AS_KEY), SQL_STATE_ILLEGAL_ARGUMENT);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_BIG_FIELDLENGTH), SQL_STATE_ILLEGAL_ARGUMENT);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_AUTO_KEY), SQL_STATE_ILLEGAL_ARGUMENT);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_NO_SUCH_INDEX), SQL_STATE_ILLEGAL_ARGUMENT);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_FIELD_TERMINATORS), SQL_STATE_ILLEGAL_ARGUMENT);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_BLOBS_AND_NO_TERMINATED), SQL_STATE_ILLEGAL_ARGUMENT);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_CANT_REMOVE_ALL_FIELDS), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_CANT_DROP_FIELD_OR_KEY), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_BLOB_CANT_HAVE_DEFAULT), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_DB_NAME), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_TABLE_NAME), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_BIG_SELECT), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_UNKNOWN_PROCEDURE), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_PARAMCOUNT_TO_PROCEDURE), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_FIELD_SPECIFIED_TWICE), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_UNSUPPORTED_EXTENSION), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_TABLE_MUST_HAVE_COLUMNS), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_UNKNOWN_CHARACTER_SET), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_BIG_ROWSIZE), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_OUTER_JOIN), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_NULL_COLUMN_IN_INDEX), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_PASSWORD_ANONYMOUS_USER), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_PASSWORD_NOT_ALLOWED), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_PASSWORD_NO_MATCH), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_REGEXP_ERROR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_MIX_OF_GROUP_FUNC_AND_FIELDS), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_NONEXISTING_GRANT), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_TABLEACCESS_DENIED_ERROR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_COLUMNACCESS_DENIED_ERROR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_ILLEGAL_GRANT_FOR_TABLE), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_GRANT_WRONG_HOST_OR_USER), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_NONEXISTING_TABLE_GRANT), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_NOT_ALLOWED_COMMAND), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SYNTAX_ERROR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_LONG_STRING), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_TABLE_CANT_HANDLE_BLOB), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_TABLE_CANT_HANDLE_AUTO_INCREMENT), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_COLUMN_NAME), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_KEY_COLUMN), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_BLOB_KEY_WITHOUT_LENGTH), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_PRIMARY_CANT_HAVE_NULL), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_MANY_ROWS), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_REQUIRES_PRIMARY_KEY), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_KEY_DOES_NOT_EXITS), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_CHECK_NO_SUCH_TABLE), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_CHECK_NOT_IMPLEMENTED), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_MANY_USER_CONNECTIONS), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_NO_PERMISSION_TO_CREATE_USER), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_USER_LIMIT_REACHED), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SPECIFIC_ACCESS_DENIED_ERROR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_NO_DEFAULT), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_VALUE_FOR_VAR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_TYPE_FOR_VAR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_CANT_USE_OPTION_HERE), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_NOT_SUPPORTED_YET), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_FK_DEF), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_DERIVED_MUST_HAVE_ALIAS), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_TABLENAME_NOT_ALLOWED_HERE), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SPATIAL_CANT_HAVE_NULL), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_COLLATION_CHARSET_MISMATCH), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_NAME_FOR_INDEX), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_NAME_FOR_CATALOG), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_UNKNOWN_STORAGE_ENGINE), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_ALREADY_EXISTS), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_DOES_NOT_EXIST), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_LILABEL_MISMATCH), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_LABEL_REDEFINE), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_LABEL_MISMATCH), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_BADRETURN), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_UPDATE_LOG_DEPRECATED_IGNORED), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_UPDATE_LOG_DEPRECATED_TRANSLATED), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_WRONG_NO_OF_ARGS), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_COND_MISMATCH), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_NORETURN), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_BAD_CURSOR_QUERY), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_BAD_CURSOR_SELECT), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_CURSOR_MISMATCH), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_UNDECLARED_VAR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_DUP_PARAM), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_DUP_VAR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_DUP_COND), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_DUP_CURS), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_VARCOND_AFTER_CURSHNDLR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_CURSOR_AFTER_HANDLER), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_PROCACCESS_DENIED_ERROR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_NONEXISTING_PROC_GRANT), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_BAD_SQLSTATE), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(1410, SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_DUP_HANDLER), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_NOT_VAR_ARG), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_BIG_SCALE), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_BIG_PRECISION), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_M_BIGGER_THAN_D), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_LONG_BODY), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_BIG_DISPLAYWIDTH), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_BAD_VAR_SHADOW), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_WRONG_NAME), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_NO_AGGREGATE), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_MAX_PREPARED_STMT_COUNT_REACHED), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_NON_GROUPING_FIELD_USED), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_PARAMCOUNT_TO_NATIVE_FCT), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_PARAMETERS_TO_NATIVE_FCT), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_PARAMETERS_TO_STORED_FCT), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_FUNC_INEXISTENT_NAME_COLLISION), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_DUP_SIGNAL_SET), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SPATIAL_MUST_HAVE_GEOM_COL), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_TRUNCATE_ILLEGAL_FK), SQL_STATE_SYNTAX_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_NUMBER_OF_COLUMNS_IN_SELECT), SQL_STATE_CARDINALITY_VIOLATION);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_OPERAND_COLUMNS), SQL_STATE_CARDINALITY_VIOLATION);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SUBQUERY_NO_1_ROW), SQL_STATE_CARDINALITY_VIOLATION);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_DUP_KEY), SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_BAD_NULL_ERROR), SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_NON_UNIQ_ERROR), SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_DUP_UNIQUE), SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_NO_REFERENCED_ROW), SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_ROW_IS_REFERENCED), SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_ROW_IS_REFERENCED_2), SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_NO_REFERENCED_ROW_2), SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_FOREIGN_DUPLICATE_KEY), SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_DUP_ENTRY_WITH_KEY_NAME), SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_FOREIGN_DUPLICATE_KEY_WITH_CHILD_INFO), SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_FOREIGN_DUPLICATE_KEY_WITHOUT_CHILD_INFO), SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_DUP_UNKNOWN_IN_INDEX), SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_DATA_TOO_LONG), SQL_STATE_STRING_DATA_RIGHT_TRUNCATION);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_WARN_DATA_OUT_OF_RANGE), SQL_STATE_WARNING);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_CANT_CREATE_GEOMETRY_OBJECT), SQL_STATE_NUMERIC_VALUE_OUT_OF_RANGE);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_DATA_OUT_OF_RANGE), SQL_STATE_NUMERIC_VALUE_OUT_OF_RANGE);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_TRUNCATED_WRONG_VALUE), SQL_STATE_INVALID_DATETIME_FORMAT);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_ILLEGAL_VALUE_FOR_TYPE), SQL_STATE_INVALID_DATETIME_FORMAT);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_DATETIME_FUNCTION_OVERFLOW), SQL_STATE_DATETIME_FIELD_OVERFLOW);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_DIVISION_BY_ZERO), SQL_STATE_DIVISION_BY_ZERO);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_CURSOR_ALREADY_OPEN), SQL_STATE_INVALID_CURSOR_STATE);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_CURSOR_NOT_OPEN), SQL_STATE_INVALID_CURSOR_STATE);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_CANT_DO_THIS_DURING_AN_TRANSACTION), SQL_STATE_INVALID_TRANSACTION_STATE);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_READ_ONLY_TRANSACTION), SQL_STATE_INVALID_TRANSACTION_STATE);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_ACCESS_DENIED_ERROR), SQL_STATE_INVALID_AUTH_SPEC);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_ACCESS_DENIED_NO_PASSWORD_ERROR), SQL_STATE_INVALID_AUTH_SPEC);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_ACCESS_DENIED_CHANGE_USER_ERROR), SQL_STATE_INVALID_AUTH_SPEC);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_DA_INVALID_CONDITION_NUMBER), SQL_STATE_INVALID_CONDITION_NUMBER);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_NO_DB_ERROR), SQL_STATE_INVALID_CATALOG_NAME);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_VALUE_COUNT), SQL_STATE_INSERT_VALUE_LIST_NO_MATCH_COL_LIST);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_VALUE_COUNT_ON_ROW), SQL_STATE_INSERT_VALUE_LIST_NO_MATCH_COL_LIST);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_TABLE_EXISTS_ERROR), SQL_STATE_ER_TABLE_EXISTS_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_BAD_TABLE_ERROR), SQL_STATE_BASE_TABLE_OR_VIEW_NOT_FOUND);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_UNKNOWN_TABLE), SQL_STATE_BASE_TABLE_OR_VIEW_NOT_FOUND);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_NO_SUCH_TABLE), SQL_STATE_BASE_TABLE_OR_VIEW_NOT_FOUND);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_BAD_FIELD_ERROR), SQL_STATE_COLUMN_NOT_FOUND);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_ILLEGAL_REFERENCE), SQL_STATE_ER_BAD_FIELD_ERROR);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_OUTOFMEMORY), SQL_STATE_MEMORY_ALLOCATION_FAILURE);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_OUT_OF_SORTMEMORY), SQL_STATE_MEMORY_ALLOCATION_FAILURE);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_LOCK_WAIT_TIMEOUT), SQL_STATE_ROLLBACK_SERIALIZATION_FAILURE);
        mysqlToSqlState.put(Integer.valueOf(MysqlErrorNumbers.ER_LOCK_DEADLOCK), SQL_STATE_ROLLBACK_SERIALIZATION_FAILURE);
        HashMap map2 = new HashMap();
        mysqlToSql99State = map2;
        map2.put(Integer.valueOf(MysqlErrorNumbers.ER_SELECT_REDUCED), SQL_STATE_WARNING);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WARN_TOO_FEW_RECORDS), SQL_STATE_WARNING);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WARN_TOO_MANY_RECORDS), SQL_STATE_WARNING);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WARN_DATA_TRUNCATED), SQL_STATE_WARNING);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WARN_NULL_TO_NOTNULL), SQL_STATE_WARNING);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WARN_DATA_OUT_OF_RANGE), SQL_STATE_WARNING);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_UNINIT_VAR), SQL_STATE_WARNING);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SIGNAL_WARN), SQL_STATE_WARNING);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_FETCH_NO_DATA), SQL_STATE_NO_DATA);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SIGNAL_NOT_FOUND), SQL_STATE_NO_DATA);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_CON_COUNT_ERROR), SQL_STATE_CONNECTION_REJECTED);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_NOT_SUPPORTED_AUTH_MODE), SQL_STATE_CONNECTION_REJECTED);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_BAD_HOST_ERROR), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_HANDSHAKE_ERROR), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_UNKNOWN_COM_ERROR), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SERVER_SHUTDOWN), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_FORCING_CLOSE), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_IPSOCK_ERROR), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_ABORTING_CONNECTION), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_NET_PACKET_TOO_LARGE), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_NET_READ_ERROR_FROM_PIPE), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_NET_FCNTL_ERROR), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_NET_PACKETS_OUT_OF_ORDER), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_NET_UNCOMPRESS_ERROR), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_NET_READ_ERROR), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_NET_READ_INTERRUPTED), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_NET_ERROR_ON_WRITE), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_NET_WRITE_INTERRUPTED), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_NEW_ABORTING_CONNECTION), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_MASTER_NET_READ), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_MASTER_NET_WRITE), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_CONNECT_TO_MASTER), SQL_STATE_COMMUNICATION_LINK_FAILURE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_BADSELECT), SQL_STATE_FEATURE_NOT_SUPPORTED);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_BADSTATEMENT), SQL_STATE_FEATURE_NOT_SUPPORTED);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_SUBSELECT_NYI), SQL_STATE_FEATURE_NOT_SUPPORTED);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_STMT_NOT_ALLOWED_IN_SF_OR_TRG), SQL_STATE_FEATURE_NOT_SUPPORTED);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_NO_RETSET), SQL_STATE_FEATURE_NOT_SUPPORTED);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_ALTER_OPERATION_NOT_SUPPORTED), SQL_STATE_FEATURE_NOT_SUPPORTED);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_ALTER_OPERATION_NOT_SUPPORTED_REASON), SQL_STATE_FEATURE_NOT_SUPPORTED);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_DBACCESS_DENIED_ERROR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_BAD_DB_ERROR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_FIELD_WITH_GROUP), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_GROUP_FIELD), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_SUM_SELECT), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_LONG_IDENT), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_DUP_KEYNAME), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_FIELD_SPEC), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_PARSE_ERROR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_EMPTY_QUERY), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_NONUNIQ_TABLE), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_INVALID_DEFAULT), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_MULTIPLE_PRI_KEY), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_MANY_KEYS), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_MANY_KEY_PARTS), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_LONG_KEY), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_KEY_COLUMN_DOES_NOT_EXITS), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_BLOB_USED_AS_KEY), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_BIG_FIELDLENGTH), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_AUTO_KEY), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_FIELD_TERMINATORS), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_BLOBS_AND_NO_TERMINATED), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_CANT_REMOVE_ALL_FIELDS), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_CANT_DROP_FIELD_OR_KEY), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_BLOB_CANT_HAVE_DEFAULT), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_DB_NAME), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_TABLE_NAME), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_BIG_SELECT), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_UNKNOWN_PROCEDURE), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_PARAMCOUNT_TO_PROCEDURE), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_FIELD_SPECIFIED_TWICE), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_UNSUPPORTED_EXTENSION), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_TABLE_MUST_HAVE_COLUMNS), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_UNKNOWN_CHARACTER_SET), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_BIG_ROWSIZE), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_OUTER_JOIN), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_NULL_COLUMN_IN_INDEX), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_PASSWORD_ANONYMOUS_USER), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_PASSWORD_NOT_ALLOWED), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_PASSWORD_NO_MATCH), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_REGEXP_ERROR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_MIX_OF_GROUP_FUNC_AND_FIELDS), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_NONEXISTING_GRANT), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_TABLEACCESS_DENIED_ERROR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_COLUMNACCESS_DENIED_ERROR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_ILLEGAL_GRANT_FOR_TABLE), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_GRANT_WRONG_HOST_OR_USER), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_NONEXISTING_TABLE_GRANT), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_NOT_ALLOWED_COMMAND), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SYNTAX_ERROR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_LONG_STRING), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_TABLE_CANT_HANDLE_BLOB), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_TABLE_CANT_HANDLE_AUTO_INCREMENT), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_COLUMN_NAME), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_KEY_COLUMN), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_BLOB_KEY_WITHOUT_LENGTH), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_PRIMARY_CANT_HAVE_NULL), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_MANY_ROWS), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_REQUIRES_PRIMARY_KEY), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_KEY_DOES_NOT_EXITS), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_CHECK_NO_SUCH_TABLE), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_CHECK_NOT_IMPLEMENTED), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_MANY_USER_CONNECTIONS), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_NO_PERMISSION_TO_CREATE_USER), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_USER_LIMIT_REACHED), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SPECIFIC_ACCESS_DENIED_ERROR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_NO_DEFAULT), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_VALUE_FOR_VAR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_TYPE_FOR_VAR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_CANT_USE_OPTION_HERE), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_NOT_SUPPORTED_YET), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_FK_DEF), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_DERIVED_MUST_HAVE_ALIAS), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_TABLENAME_NOT_ALLOWED_HERE), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SPATIAL_CANT_HAVE_NULL), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_COLLATION_CHARSET_MISMATCH), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_NAME_FOR_INDEX), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_NAME_FOR_CATALOG), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_UNKNOWN_STORAGE_ENGINE), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_ALREADY_EXISTS), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_DOES_NOT_EXIST), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_LILABEL_MISMATCH), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_LABEL_REDEFINE), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_LABEL_MISMATCH), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_BADRETURN), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_UPDATE_LOG_DEPRECATED_IGNORED), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_UPDATE_LOG_DEPRECATED_TRANSLATED), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_WRONG_NO_OF_ARGS), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_COND_MISMATCH), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_NORETURN), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_BAD_CURSOR_QUERY), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_BAD_CURSOR_SELECT), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_CURSOR_MISMATCH), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_UNDECLARED_VAR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_DUP_PARAM), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_DUP_VAR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_DUP_COND), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_DUP_CURS), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_VARCOND_AFTER_CURSHNDLR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_CURSOR_AFTER_HANDLER), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_PROCACCESS_DENIED_ERROR), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_NONEXISTING_PROC_GRANT), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_BAD_SQLSTATE), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(1410, SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_DUP_HANDLER), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_NOT_VAR_ARG), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_BIG_SCALE), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_BIG_PRECISION), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_M_BIGGER_THAN_D), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_LONG_BODY), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_TOO_BIG_DISPLAYWIDTH), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_BAD_VAR_SHADOW), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_WRONG_NAME), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_NO_AGGREGATE), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_MAX_PREPARED_STMT_COUNT_REACHED), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_NON_GROUPING_FIELD_USED), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_PARAMCOUNT_TO_NATIVE_FCT), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_PARAMETERS_TO_NATIVE_FCT), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_PARAMETERS_TO_STORED_FCT), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_FUNC_INEXISTENT_NAME_COLLISION), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_DUP_SIGNAL_SET), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SPATIAL_MUST_HAVE_GEOM_COL), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_TRUNCATE_ILLEGAL_FK), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_NUMBER_OF_COLUMNS_IN_SELECT), SQL_STATE_CARDINALITY_VIOLATION);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_OPERAND_COLUMNS), SQL_STATE_CARDINALITY_VIOLATION);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SUBQUERY_NO_1_ROW), SQL_STATE_CARDINALITY_VIOLATION);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_DUP_KEY), SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_BAD_NULL_ERROR), SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_NON_UNIQ_ERROR), SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_DUP_ENTRY), SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_DUP_UNIQUE), SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_NO_REFERENCED_ROW), SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_ROW_IS_REFERENCED), SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_ROW_IS_REFERENCED_2), SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_NO_REFERENCED_ROW_2), SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_FOREIGN_DUPLICATE_KEY), SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_DUP_ENTRY_WITH_KEY_NAME), SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_FOREIGN_DUPLICATE_KEY_WITH_CHILD_INFO), SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_FOREIGN_DUPLICATE_KEY_WITHOUT_CHILD_INFO), SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_DUP_UNKNOWN_IN_INDEX), SQL_STATE_INTEGRITY_CONSTRAINT_VIOLATION);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_DATA_TOO_LONG), SQL_STATE_STRING_DATA_RIGHT_TRUNCATION);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_CANT_CREATE_GEOMETRY_OBJECT), SQL_STATE_NUMERIC_VALUE_OUT_OF_RANGE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_DATA_OUT_OF_RANGE), SQL_STATE_NUMERIC_VALUE_OUT_OF_RANGE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_TRUNCATED_WRONG_VALUE), SQL_STATE_INVALID_DATETIME_FORMAT);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_ILLEGAL_VALUE_FOR_TYPE), SQL_STATE_INVALID_DATETIME_FORMAT);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_DATETIME_FUNCTION_OVERFLOW), SQL_STATE_DATETIME_FIELD_OVERFLOW);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_DIVISION_BY_ZERO), SQL_STATE_DIVISION_BY_ZERO);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_CURSOR_ALREADY_OPEN), SQL_STATE_INVALID_CURSOR_STATE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_CURSOR_NOT_OPEN), SQL_STATE_INVALID_CURSOR_STATE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_CANT_DO_THIS_DURING_AN_TRANSACTION), SQL_STATE_INVALID_TRANSACTION_STATE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_READ_ONLY_TRANSACTION), SQL_STATE_INVALID_TRANSACTION_STATE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_ACCESS_DENIED_ERROR), SQL_STATE_INVALID_AUTH_SPEC);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_ACCESS_DENIED_NO_PASSWORD_ERROR), SQL_STATE_INVALID_AUTH_SPEC);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_ACCESS_DENIED_CHANGE_USER_ERROR), SQL_STATE_INVALID_AUTH_SPEC);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_DA_INVALID_CONDITION_NUMBER), SQL_STATE_INVALID_CONDITION_NUMBER);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_NO_DB_ERROR), SQL_STATE_INVALID_CATALOG_NAME);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_RESIGNAL_WITHOUT_ACTIVE_HANDLER), SQL_STATE_RESIGNAL_WHEN_HANDLER_NOT_ACTIVE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_GET_STACKED_DA_WITHOUT_ACTIVE_HANDLER), SQL_STATE_STACKED_DIAGNOSTICS_ACCESSED_WITHOUT_ACTIVE_HANDLER);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_CASE_NOT_FOUND), SQL_STATE_CASE_NOT_FOUND_FOR_CASE_STATEMENT);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_VALUE_COUNT), SQL_STATE_INSERT_VALUE_LIST_NO_MATCH_COL_LIST);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_WRONG_VALUE_COUNT_ON_ROW), SQL_STATE_INSERT_VALUE_LIST_NO_MATCH_COL_LIST);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_INVALID_USE_OF_NULL), SQL_STATE_SYNTAX_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_INVALID_ARGUMENT_FOR_LOGARITHM), SQL_STATE_INVALID_LOGARITHM_ARGUMENT);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_CANT_CHANGE_TX_ISOLATION), SQL_STATE_ACTIVE_SQL_TRANSACTION);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_CANT_EXECUTE_IN_READ_ONLY_TRANSACTION), SQL_STATE_READ_ONLY_SQL_TRANSACTION);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_NO_RECURSIVE_CREATE), SQL_STATE_SRE_PROHIBITED_SQL_STATEMENT_ATTEMPTED);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_SP_NORETURNEND), SQL_STATE_SRE_FUNCTION_EXECUTED_NO_RETURN_STATEMENT);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_TABLE_EXISTS_ERROR), SQL_STATE_ER_TABLE_EXISTS_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_BAD_TABLE_ERROR), SQL_STATE_BASE_TABLE_OR_VIEW_NOT_FOUND);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_UNKNOWN_TABLE), SQL_STATE_BASE_TABLE_OR_VIEW_NOT_FOUND);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_NO_SUCH_TABLE), SQL_STATE_BASE_TABLE_OR_VIEW_NOT_FOUND);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_NO_SUCH_INDEX), SQL_STATE_ER_NO_SUCH_INDEX);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_DUP_FIELDNAME), SQL_STATE_ER_DUP_FIELDNAME);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_BAD_FIELD_ERROR), SQL_STATE_ER_BAD_FIELD_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_ILLEGAL_REFERENCE), SQL_STATE_ER_BAD_FIELD_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_QUERY_INTERRUPTED), SQL_STATE_ER_QUERY_INTERRUPTED);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_OUTOFMEMORY), SQL_STATE_MEMORY_ALLOCATION_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_OUT_OF_SORTMEMORY), SQL_STATE_MEMORY_ALLOCATION_ERROR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_XA_RBROLLBACK), SQL_STATE_XA_RBROLLBACK);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_XA_RBDEADLOCK), SQL_STATE_XA_RBDEADLOCK);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_XA_RBTIMEOUT), SQL_STATE_XA_RBTIMEOUT);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_XA_RMERR), SQL_STATE_XA_RMERR);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_XAER_NOTA), SQL_STATE_XAER_NOTA);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_XAER_INVAL), SQL_STATE_XAER_INVAL);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_XAER_RMFAIL), SQL_STATE_XAER_RMFAIL);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_XAER_DUPID), SQL_STATE_XAER_DUPID);
        mysqlToSql99State.put(1400, SQL_STATE_XAER_OUTSIDE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_LOCK_WAIT_TIMEOUT), SQL_STATE_ROLLBACK_SERIALIZATION_FAILURE);
        mysqlToSql99State.put(Integer.valueOf(MysqlErrorNumbers.ER_LOCK_DEADLOCK), SQL_STATE_ROLLBACK_SERIALIZATION_FAILURE);
    }

    public static SQLWarning convertShowWarningsToSQLWarnings(Connection connection) throws SQLException {
        return convertShowWarningsToSQLWarnings(connection, 0, false);
    }

    public static SQLException createBatchUpdateException(SQLException sQLException, long[] jArr, ExceptionInterceptor exceptionInterceptor) throws SQLException {
        SQLException sQLException2;
        if (Util.isJdbc42()) {
            sQLException2 = (SQLException) Util.getInstance("java.sql.BatchUpdateException", new Class[]{String.class, String.class, Integer.TYPE, long[].class, Throwable.class}, new Object[]{sQLException.getMessage(), sQLException.getSQLState(), Integer.valueOf(sQLException.getErrorCode()), jArr, sQLException}, exceptionInterceptor);
        } else {
            BatchUpdateException batchUpdateException = new BatchUpdateException(sQLException.getMessage(), sQLException.getSQLState(), sQLException.getErrorCode(), Util.truncateAndConvertToInt(jArr));
            batchUpdateException.initCause(sQLException);
            sQLException2 = batchUpdateException;
        }
        return runThroughExceptionInterceptor(exceptionInterceptor, sQLException2, null);
    }

    public static SQLException createCommunicationsException(MySQLConnection mySQLConnection, long j, long j2, Exception exc, ExceptionInterceptor exceptionInterceptor) {
        SQLException communicationsException;
        if (Util.isJdbc4()) {
            try {
                communicationsException = (SQLException) Util.handleNewInstance(JDBC_4_COMMUNICATIONS_EXCEPTION_CTOR, new Object[]{mySQLConnection, Long.valueOf(j), Long.valueOf(j2), exc}, exceptionInterceptor);
            } catch (SQLException e) {
                return e;
            }
        } else {
            communicationsException = new CommunicationsException(mySQLConnection, j, j2, exc);
        }
        return runThroughExceptionInterceptor(exceptionInterceptor, communicationsException, mySQLConnection);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x009f  */
    public static String createLinkFailureMessageBasedOnHeuristics(MySQLConnection mySQLConnection, long j, long j2, Exception exc) {
        long j3;
        boolean interactiveClient;
        StringBuilder sb;
        char c;
        if (mySQLConnection != null) {
            interactiveClient = mySQLConnection.getInteractiveClient();
            String serverVariable = interactiveClient ? mySQLConnection.getServerVariable("interactive_timeout") : mySQLConnection.getServerVariable("wait_timeout");
            if (serverVariable != null) {
                try {
                    j3 = Long.parseLong(serverVariable);
                } catch (NumberFormatException unused) {
                    j3 = 0;
                }
            } else {
                j3 = 0;
            }
        } else {
            j3 = 0;
            interactiveClient = false;
        }
        StringBuilder sb2 = new StringBuilder();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j4 = jCurrentTimeMillis - (j == 0 ? jCurrentTimeMillis : j);
        long j5 = j4 / 1000;
        long j6 = jCurrentTimeMillis - j2;
        if (j3 != 0) {
            if (j5 > j3) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(Messages.getString("CommunicationsException.2"));
                if (interactiveClient) {
                    sb3.append(Messages.getString("CommunicationsException.4"));
                } else {
                    sb3.append(Messages.getString("CommunicationsException.3"));
                }
                sb = sb3;
                c = 1;
            } else {
                sb = null;
                c = 0;
            }
        } else if (j5 > DEFAULT_WAIT_TIMEOUT_SECONDS) {
            sb = new StringBuilder();
            sb.append(Messages.getString("CommunicationsException.5"));
            sb.append(Messages.getString("CommunicationsException.6"));
            sb.append(Messages.getString("CommunicationsException.7"));
            sb.append(Messages.getString("CommunicationsException.8"));
            c = 2;
        } else {
            sb = null;
            c = 0;
        }
        if (c == 1 || c == 2) {
            if (j2 != 0) {
                sb2.append(Messages.getString("CommunicationsException.ServerPacketTimingInfo", new Object[]{Long.valueOf(j6), Long.valueOf(j4)}));
            } else {
                sb2.append(Messages.getString("CommunicationsException.ServerPacketTimingInfoNoRecv", new Object[]{Long.valueOf(j4)}));
            }
            if (sb != null) {
                sb2.append((CharSequence) sb);
            }
            sb2.append(Messages.getString("CommunicationsException.11"));
            sb2.append(Messages.getString("CommunicationsException.12"));
            sb2.append(Messages.getString("CommunicationsException.13"));
        } else if (exc instanceof BindException) {
            if (mySQLConnection.getLocalSocketAddress() == null || Util.interfaceExists(mySQLConnection.getLocalSocketAddress())) {
                sb2.append(Messages.getString("CommunicationsException.TooManyClientConnections"));
            } else {
                sb2.append(Messages.getString("CommunicationsException.LocalSocketAddressNotAvailable"));
            }
        }
        if (sb2.length() == 0) {
            sb2.append(Messages.getString("CommunicationsException.20"));
            if (mySQLConnection != null && mySQLConnection.getMaintainTimeStats() && !mySQLConnection.getParanoid()) {
                sb2.append("\n\n");
                if (j2 != 0) {
                    sb2.append(Messages.getString("CommunicationsException.ServerPacketTimingInfo", new Object[]{Long.valueOf(j6), Long.valueOf(j4)}));
                } else {
                    sb2.append(Messages.getString("CommunicationsException.ServerPacketTimingInfoNoRecv", new Object[]{Long.valueOf(j4)}));
                }
            }
        }
        return sb2.toString();
    }

    public static SQLException createSQLException(String str, String str2, ExceptionInterceptor exceptionInterceptor) {
        return createSQLException(str, str2, 0, exceptionInterceptor);
    }

    public static SQLException createSQLFeatureNotSupportedException() throws SQLException {
        return Util.isJdbc4() ? (SQLException) Util.getInstance("java.sql.SQLFeatureNotSupportedException", null, null, null) : new NotImplemented();
    }

    public static void dumpSqlStatesMappingsAsXml() throws Exception {
        TreeMap treeMap = new TreeMap();
        HashMap map = new HashMap();
        for (Integer num : mysqlToSql99State.keySet()) {
            treeMap.put(num, num);
        }
        for (Integer num2 : mysqlToSqlState.keySet()) {
            treeMap.put(num2, num2);
        }
        java.lang.reflect.Field[] declaredFields = MysqlErrorNumbers.class.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            String name = declaredFields[i].getName();
            if (name.startsWith("ER_")) {
                map.put(declaredFields[i].get(null), name);
            }
        }
        System.out.println("<ErrorMappings>");
        for (Integer num3 : treeMap.keySet()) {
            String strMysqlToSql99 = mysqlToSql99(num3.intValue());
            String strMysqlToXOpen = mysqlToXOpen(num3.intValue());
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("   <ErrorMapping mysqlErrorNumber=\"");
            sb.append(num3);
            sb.append("\" mysqlErrorName=\"");
            sb.append((String) map.get(num3));
            sb.append("\" legacySqlState=\"");
            if (strMysqlToXOpen == null) {
                strMysqlToXOpen = BuildConfig.FLAVOR;
            }
            sb.append(strMysqlToXOpen);
            sb.append("\" sql92SqlState=\"");
            if (strMysqlToSql99 == null) {
                strMysqlToSql99 = BuildConfig.FLAVOR;
            }
            sb.append(strMysqlToSql99);
            sb.append("\"/>");
            printStream.println(sb.toString());
        }
        System.out.println("</ErrorMappings>");
    }

    public static String get(String str) {
        return sqlStateMessages.get(str);
    }

    private static String mysqlToSql99(int i) {
        Integer numValueOf = Integer.valueOf(i);
        return mysqlToSql99State.containsKey(numValueOf) ? mysqlToSql99State.get(numValueOf) : SQL_STATE_CLI_SPECIFIC_CONDITION;
    }

    public static String mysqlToSqlState(int i, boolean z) {
        return z ? mysqlToSql99(i) : mysqlToXOpen(i);
    }

    private static String mysqlToXOpen(int i) {
        Integer numValueOf = Integer.valueOf(i);
        return mysqlToSqlState.containsKey(numValueOf) ? mysqlToSqlState.get(numValueOf) : SQL_STATE_GENERAL_ERROR;
    }

    private static SQLException runThroughExceptionInterceptor(ExceptionInterceptor exceptionInterceptor, SQLException sQLException, Connection connection) {
        SQLException sQLExceptionInterceptException;
        return (exceptionInterceptor == null || (sQLExceptionInterceptException = exceptionInterceptor.interceptException(sQLException, connection)) == null) ? sQLException : sQLExceptionInterceptException;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [int] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [java.sql.Statement] */
    /* JADX WARN: Type inference failed for: r14v6, types: [java.sql.Statement] */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9 */
    public static SQLWarning convertShowWarningsToSQLWarnings(Connection connection, int i, boolean z) throws Throwable {
        ResultSet resultSetExecuteQuery;
        SQLException e = null;
        try {
            try {
                if (i < 100) {
                    java.sql.Statement statementCreateStatement = connection.createStatement();
                    statementCreateStatement.setFetchSize(0);
                    int maxRows = statementCreateStatement.getMaxRows();
                    i = statementCreateStatement;
                    if (maxRows != 0) {
                        statementCreateStatement.setMaxRows(0);
                        i = statementCreateStatement;
                    }
                } else {
                    java.sql.Statement statementCreateStatement2 = connection.createStatement(MysqlErrorNumbers.ER_YES, MysqlErrorNumbers.ER_DB_CREATE_EXISTS);
                    statementCreateStatement2.setFetchSize(Integer.MIN_VALUE);
                    i = statementCreateStatement2;
                }
                resultSetExecuteQuery = i.executeQuery("SHOW WARNINGS");
                SQLWarning sQLWarning = null;
                while (resultSetExecuteQuery.next()) {
                    try {
                        int i2 = resultSetExecuteQuery.getInt("Code");
                        if (!z) {
                            SQLWarning sQLWarning2 = new SQLWarning(resultSetExecuteQuery.getString("Message"), mysqlToSqlState(i2, connection.getUseSqlStateCodes()), i2);
                            if (sQLWarning == null) {
                                sQLWarning = sQLWarning2;
                            } else {
                                sQLWarning.setNextWarning(sQLWarning2);
                            }
                        } else if (i2 == 1265 || i2 == 1264) {
                            MysqlDataTruncation mysqlDataTruncation = new MysqlDataTruncation(resultSetExecuteQuery.getString("Message"), 0, false, false, 0, 0, i2);
                            if (sQLWarning == null) {
                                sQLWarning = mysqlDataTruncation;
                            } else {
                                sQLWarning.setNextWarning(mysqlDataTruncation);
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (resultSetExecuteQuery != null) {
                            try {
                                resultSetExecuteQuery.close();
                            } catch (SQLException e2) {
                                e = e2;
                            }
                        }
                        if (i != 0) {
                            try {
                                i.close();
                            } catch (SQLException e3) {
                                e = e3;
                            }
                        }
                        if (e != null) {
                            throw e;
                        }
                        throw th;
                    }
                }
                if (z && sQLWarning != null) {
                    throw sQLWarning;
                }
                if (resultSetExecuteQuery != null) {
                    try {
                        resultSetExecuteQuery.close();
                    } catch (SQLException e4) {
                        e = e4;
                    }
                }
                if (i != 0) {
                    try {
                        i.close();
                    } catch (SQLException e5) {
                        e = e5;
                    }
                }
                if (e == null) {
                    return sQLWarning;
                }
                throw e;
            } catch (Throwable th2) {
                th = th2;
                resultSetExecuteQuery = null;
            }
        } catch (Throwable th3) {
            th = th3;
            i = 0;
            resultSetExecuteQuery = null;
        }
    }

    public static SQLException createSQLException(String str, ExceptionInterceptor exceptionInterceptor) {
        return createSQLException(str, exceptionInterceptor, (Connection) null);
    }

    public static SQLException createSQLException(String str, ExceptionInterceptor exceptionInterceptor, Connection connection) {
        return runThroughExceptionInterceptor(exceptionInterceptor, new SQLException(str), connection);
    }

    public static SQLException createSQLFeatureNotSupportedException(String str, String str2, ExceptionInterceptor exceptionInterceptor) throws SQLException {
        SQLException notImplemented;
        if (Util.isJdbc4()) {
            notImplemented = (SQLException) Util.getInstance("java.sql.SQLFeatureNotSupportedException", new Class[]{String.class, String.class}, new Object[]{str, str2}, exceptionInterceptor);
        } else {
            notImplemented = new NotImplemented();
        }
        return runThroughExceptionInterceptor(exceptionInterceptor, notImplemented, null);
    }

    public static SQLException createSQLException(String str, String str2, Throwable th, ExceptionInterceptor exceptionInterceptor) {
        return createSQLException(str, str2, th, exceptionInterceptor, (Connection) null);
    }

    public static SQLException createSQLException(String str, String str2, Throwable th, ExceptionInterceptor exceptionInterceptor, Connection connection) {
        SQLException sQLExceptionCreateSQLException = createSQLException(str, str2, (ExceptionInterceptor) null);
        if (sQLExceptionCreateSQLException.getCause() == null) {
            sQLExceptionCreateSQLException.initCause(th);
        }
        return runThroughExceptionInterceptor(exceptionInterceptor, sQLExceptionCreateSQLException, connection);
    }

    public static SQLException createSQLException(String str, String str2, int i, ExceptionInterceptor exceptionInterceptor) {
        return createSQLException(str, str2, i, false, exceptionInterceptor);
    }

    public static SQLException createSQLException(String str, String str2, int i, boolean z, ExceptionInterceptor exceptionInterceptor) {
        return createSQLException(str, str2, i, z, exceptionInterceptor, null);
    }

    public static SQLException createSQLException(String str, String str2, int i, boolean z, ExceptionInterceptor exceptionInterceptor, Connection connection) {
        SQLException sQLException;
        try {
            if (str2 != null) {
                if (str2.startsWith("08")) {
                    if (z) {
                        sQLException = !Util.isJdbc4() ? new MySQLTransientConnectionException(str, str2, i) : (SQLException) Util.getInstance("com.mysql.jdbc.exceptions.jdbc4.MySQLTransientConnectionException", new Class[]{String.class, String.class, Integer.TYPE}, new Object[]{str, str2, Integer.valueOf(i)}, exceptionInterceptor);
                    } else {
                        sQLException = !Util.isJdbc4() ? new MySQLNonTransientConnectionException(str, str2, i) : (SQLException) Util.getInstance("com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException", new Class[]{String.class, String.class, Integer.TYPE}, new Object[]{str, str2, Integer.valueOf(i)}, exceptionInterceptor);
                    }
                } else if (str2.startsWith("22")) {
                    sQLException = !Util.isJdbc4() ? new MySQLDataException(str, str2, i) : (SQLException) Util.getInstance("com.mysql.jdbc.exceptions.jdbc4.MySQLDataException", new Class[]{String.class, String.class, Integer.TYPE}, new Object[]{str, str2, Integer.valueOf(i)}, exceptionInterceptor);
                } else if (str2.startsWith("23")) {
                    sQLException = !Util.isJdbc4() ? new MySQLIntegrityConstraintViolationException(str, str2, i) : (SQLException) Util.getInstance("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException", new Class[]{String.class, String.class, Integer.TYPE}, new Object[]{str, str2, Integer.valueOf(i)}, exceptionInterceptor);
                } else if (str2.startsWith("42")) {
                    sQLException = !Util.isJdbc4() ? new MySQLSyntaxErrorException(str, str2, i) : (SQLException) Util.getInstance("com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException", new Class[]{String.class, String.class, Integer.TYPE}, new Object[]{str, str2, Integer.valueOf(i)}, exceptionInterceptor);
                } else if (str2.startsWith("40")) {
                    sQLException = !Util.isJdbc4() ? new MySQLTransactionRollbackException(str, str2, i) : (SQLException) Util.getInstance("com.mysql.jdbc.exceptions.jdbc4.MySQLTransactionRollbackException", new Class[]{String.class, String.class, Integer.TYPE}, new Object[]{str, str2, Integer.valueOf(i)}, exceptionInterceptor);
                } else if (str2.startsWith(SQL_STATE_ER_QUERY_INTERRUPTED)) {
                    sQLException = !Util.isJdbc4() ? new MySQLQueryInterruptedException(str, str2, i) : (SQLException) Util.getInstance("com.mysql.jdbc.exceptions.jdbc4.MySQLQueryInterruptedException", new Class[]{String.class, String.class, Integer.TYPE}, new Object[]{str, str2, Integer.valueOf(i)}, exceptionInterceptor);
                } else {
                    sQLException = new SQLException(str, str2, i);
                }
            } else {
                sQLException = new SQLException(str, str2, i);
            }
            return runThroughExceptionInterceptor(exceptionInterceptor, sQLException, connection);
        } catch (SQLException e) {
            return runThroughExceptionInterceptor(exceptionInterceptor, new SQLException("Unable to create correct SQLException class instance, error class/codes may be incorrect. Reason: " + Util.stackTraceToString(e), SQL_STATE_GENERAL_ERROR), connection);
        }
    }
}
