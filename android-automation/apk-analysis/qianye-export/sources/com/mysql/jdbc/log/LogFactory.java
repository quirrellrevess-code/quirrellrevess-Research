package com.mysql.jdbc.log;

import com.mysql.jdbc.ExceptionInterceptor;
import com.mysql.jdbc.SQLError;
import com.mysql.jdbc.Util;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/* JADX INFO: loaded from: classes.dex */
public class LogFactory {
    public static Log getLogger(String str, String str2, ExceptionInterceptor exceptionInterceptor) throws SQLException {
        Class<?> cls;
        if (str == null) {
            throw SQLError.createSQLException("Logger class can not be NULL", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
        }
        if (str2 == null) {
            throw SQLError.createSQLException("Logger instance name can not be NULL", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
        }
        try {
            try {
                try {
                    cls = Class.forName(str);
                } catch (ClassCastException e) {
                    SQLException sQLExceptionCreateSQLException = SQLError.createSQLException("Logger class '" + str + "' does not implement the '" + Log.class.getName() + "' interface", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
                    sQLExceptionCreateSQLException.initCause(e);
                    throw sQLExceptionCreateSQLException;
                } catch (IllegalAccessException e2) {
                    SQLException sQLExceptionCreateSQLException2 = SQLError.createSQLException("Unable to instantiate logger class '" + str + "', constructor not public", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
                    sQLExceptionCreateSQLException2.initCause(e2);
                    throw sQLExceptionCreateSQLException2;
                } catch (InstantiationException e3) {
                    SQLException sQLExceptionCreateSQLException3 = SQLError.createSQLException("Unable to instantiate logger class '" + str + "', exception in constructor?", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
                    sQLExceptionCreateSQLException3.initCause(e3);
                    throw sQLExceptionCreateSQLException3;
                } catch (NoSuchMethodException e4) {
                    SQLException sQLExceptionCreateSQLException4 = SQLError.createSQLException("Logger class does not have a single-arg constructor that takes an instance name", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
                    sQLExceptionCreateSQLException4.initCause(e4);
                    throw sQLExceptionCreateSQLException4;
                } catch (InvocationTargetException e5) {
                    SQLException sQLExceptionCreateSQLException5 = SQLError.createSQLException("Unable to instantiate logger class '" + str + "', exception in constructor?", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
                    sQLExceptionCreateSQLException5.initCause(e5);
                    throw sQLExceptionCreateSQLException5;
                }
            } catch (ClassNotFoundException unused) {
                cls = Class.forName(Util.getPackageName(Log.class) + "." + str);
            }
            return (Log) cls.getConstructor(String.class).newInstance(str2);
        } catch (ClassNotFoundException e6) {
            SQLException sQLExceptionCreateSQLException6 = SQLError.createSQLException("Unable to load class for logger '" + str + "'", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
            sQLExceptionCreateSQLException6.initCause(e6);
            throw sQLExceptionCreateSQLException6;
        }
    }
}
