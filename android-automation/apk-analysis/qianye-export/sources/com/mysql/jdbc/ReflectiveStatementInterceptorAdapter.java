package com.mysql.jdbc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class ReflectiveStatementInterceptorAdapter implements StatementInterceptorV2 {
    private final StatementInterceptor toProxy;
    public final Method v2PostProcessMethod;

    public ReflectiveStatementInterceptorAdapter(StatementInterceptor statementInterceptor) {
        this.toProxy = statementInterceptor;
        this.v2PostProcessMethod = getV2PostProcessMethod(statementInterceptor.getClass());
    }

    public static final Method getV2PostProcessMethod(Class<?> cls) {
        try {
            Class<?> cls2 = Boolean.TYPE;
            return cls.getMethod("postProcess", String.class, Statement.class, ResultSetInternalMethods.class, Connection.class, Integer.TYPE, cls2, cls2, SQLException.class);
        } catch (NoSuchMethodException | SecurityException unused) {
            return null;
        }
    }

    @Override // com.mysql.jdbc.StatementInterceptorV2, com.mysql.jdbc.Extension
    public void destroy() {
        this.toProxy.destroy();
    }

    @Override // com.mysql.jdbc.StatementInterceptorV2
    public boolean executeTopLevelOnly() {
        return this.toProxy.executeTopLevelOnly();
    }

    @Override // com.mysql.jdbc.StatementInterceptorV2, com.mysql.jdbc.Extension
    public void init(Connection connection, Properties properties) throws SQLException {
        this.toProxy.init(connection, properties);
    }

    @Override // com.mysql.jdbc.StatementInterceptorV2
    public ResultSetInternalMethods postProcess(String str, Statement statement, ResultSetInternalMethods resultSetInternalMethods, Connection connection, int i, boolean z, boolean z2, SQLException sQLException) throws SQLException {
        try {
            Method method = this.v2PostProcessMethod;
            StatementInterceptor statementInterceptor = this.toProxy;
            Object[] objArr = new Object[8];
            objArr[0] = str;
            objArr[1] = statement;
            objArr[2] = resultSetInternalMethods;
            objArr[3] = connection;
            objArr[4] = Integer.valueOf(i);
            objArr[5] = z ? Boolean.TRUE : Boolean.FALSE;
            objArr[6] = z2 ? Boolean.TRUE : Boolean.FALSE;
            objArr[7] = sQLException;
            return (ResultSetInternalMethods) method.invoke(statementInterceptor, objArr);
        } catch (IllegalAccessException e) {
            SQLException sQLException2 = new SQLException("Unable to reflectively invoke interceptor");
            sQLException2.initCause(e);
            throw sQLException2;
        } catch (IllegalArgumentException e2) {
            SQLException sQLException3 = new SQLException("Unable to reflectively invoke interceptor");
            sQLException3.initCause(e2);
            throw sQLException3;
        } catch (InvocationTargetException e3) {
            SQLException sQLException4 = new SQLException("Unable to reflectively invoke interceptor");
            sQLException4.initCause(e3);
            throw sQLException4;
        }
    }

    @Override // com.mysql.jdbc.StatementInterceptorV2
    public ResultSetInternalMethods preProcess(String str, Statement statement, Connection connection) throws SQLException {
        return this.toProxy.preProcess(str, statement, connection);
    }
}
