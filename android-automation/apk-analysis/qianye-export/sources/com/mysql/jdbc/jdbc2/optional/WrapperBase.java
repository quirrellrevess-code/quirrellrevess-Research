package com.mysql.jdbc.jdbc2.optional;

import com.mysql.jdbc.ExceptionInterceptor;
import com.mysql.jdbc.SQLError;
import com.mysql.jdbc.Util;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.SQLException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class WrapperBase {
    public ExceptionInterceptor exceptionInterceptor;
    public MysqlPooledConnection pooledConnection;
    public Map<Class<?>, Object> unwrappedInterfaces = null;

    public class ConnectionErrorFiringInvocationHandler implements InvocationHandler {
        public Object invokeOn;

        public ConnectionErrorFiringInvocationHandler(Object obj) {
            this.invokeOn = null;
            this.invokeOn = obj;
        }

        private Object proxyIfInterfaceIsJdbc(Object obj, Class<?> cls) {
            Class<?>[] interfaces = cls.getInterfaces();
            if (interfaces.length <= 0) {
                return obj;
            }
            Class<?> cls2 = interfaces[0];
            String packageName = Util.getPackageName(cls2);
            return ("java.sql".equals(packageName) || "javax.sql".equals(packageName)) ? Proxy.newProxyInstance(obj.getClass().getClassLoader(), interfaces, WrapperBase.this.new ConnectionErrorFiringInvocationHandler(obj)) : proxyIfInterfaceIsJdbc(obj, cls2);
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if ("equals".equals(method.getName())) {
                return Boolean.valueOf(objArr[0].equals(this));
            }
            try {
                Object objInvoke = method.invoke(this.invokeOn, objArr);
                return objInvoke != null ? proxyIfInterfaceIsJdbc(objInvoke, objInvoke.getClass()) : objInvoke;
            } catch (InvocationTargetException e) {
                if (!(e.getTargetException() instanceof SQLException)) {
                    throw e;
                }
                WrapperBase.this.checkAndFireConnectionError((SQLException) e.getTargetException());
                return null;
            }
        }
    }

    public WrapperBase(MysqlPooledConnection mysqlPooledConnection) {
        this.pooledConnection = mysqlPooledConnection;
        this.exceptionInterceptor = mysqlPooledConnection.getExceptionInterceptor();
    }

    public void checkAndFireConnectionError(SQLException sQLException) throws SQLException {
        if (this.pooledConnection == null || !SQLError.SQL_STATE_COMMUNICATION_LINK_FAILURE.equals(sQLException.getSQLState())) {
            throw sQLException;
        }
        this.pooledConnection.callConnectionEventListeners(1, sQLException);
        throw sQLException;
    }
}
