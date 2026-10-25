package com.mysql.jdbc.interceptors;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetInternalMethods;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.StatementInterceptor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.SQLException;
import java.util.Properties;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class ResultSetScannerInterceptor implements StatementInterceptor {
    public Pattern regexP;

    @Override // com.mysql.jdbc.StatementInterceptor, com.mysql.jdbc.Extension
    public void destroy() {
    }

    @Override // com.mysql.jdbc.StatementInterceptor
    public boolean executeTopLevelOnly() {
        return false;
    }

    @Override // com.mysql.jdbc.StatementInterceptor, com.mysql.jdbc.Extension
    public void init(Connection connection, Properties properties) throws SQLException {
        String property = properties.getProperty("resultSetScannerRegex");
        if (property == null || property.length() == 0) {
            throw new SQLException("resultSetScannerRegex must be configured, and must be > 0 characters");
        }
        try {
            this.regexP = Pattern.compile(property);
        } catch (Throwable th) {
            SQLException sQLException = new SQLException("Can't use configured regex due to underlying exception.");
            sQLException.initCause(th);
            throw sQLException;
        }
    }

    @Override // com.mysql.jdbc.StatementInterceptor
    public ResultSetInternalMethods postProcess(String str, Statement statement, final ResultSetInternalMethods resultSetInternalMethods, Connection connection) throws SQLException {
        return (ResultSetInternalMethods) Proxy.newProxyInstance(resultSetInternalMethods.getClass().getClassLoader(), new Class[]{ResultSetInternalMethods.class}, new InvocationHandler() { // from class: com.mysql.jdbc.interceptors.ResultSetScannerInterceptor.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                if ("equals".equals(method.getName())) {
                    return Boolean.valueOf(objArr[0].equals(this));
                }
                Object objInvoke = method.invoke(resultSetInternalMethods, objArr);
                String name = method.getName();
                if (((objInvoke != null && (objInvoke instanceof String)) || "getString".equals(name) || "getObject".equals(name) || "getObjectStoredProc".equals(name)) && ResultSetScannerInterceptor.this.regexP.matcher(objInvoke.toString()).matches()) {
                    throw new SQLException("value disallowed by filter");
                }
                return objInvoke;
            }
        });
    }

    @Override // com.mysql.jdbc.StatementInterceptor
    public ResultSetInternalMethods preProcess(String str, Statement statement, Connection connection) throws SQLException {
        return null;
    }
}
