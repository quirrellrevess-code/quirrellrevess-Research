package com.mysql.jdbc.jdbc2.optional;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ExceptionInterceptor;
import com.mysql.jdbc.SQLError;
import com.mysql.jdbc.Util;
import java.lang.reflect.Constructor;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;
import javax.sql.PooledConnection;

/* JADX INFO: loaded from: classes.dex */
public class MysqlPooledConnection implements PooledConnection {
    public static final int CONNECTION_CLOSED_EVENT = 2;
    public static final int CONNECTION_ERROR_EVENT = 1;
    private static final Constructor<?> JDBC_4_POOLED_CONNECTION_WRAPPER_CTOR;
    private ExceptionInterceptor exceptionInterceptor;
    private Connection physicalConn;
    private java.sql.Connection logicalHandle = null;
    private Map<ConnectionEventListener, ConnectionEventListener> connectionEventListeners = new HashMap();

    static {
        if (!Util.isJdbc4()) {
            JDBC_4_POOLED_CONNECTION_WRAPPER_CTOR = null;
            return;
        }
        try {
            JDBC_4_POOLED_CONNECTION_WRAPPER_CTOR = Class.forName("com.mysql.jdbc.jdbc2.optional.JDBC4MysqlPooledConnection").getConstructor(Connection.class);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        } catch (SecurityException e3) {
            throw new RuntimeException(e3);
        }
    }

    public MysqlPooledConnection(Connection connection) {
        this.physicalConn = connection;
        this.exceptionInterceptor = this.physicalConn.getExceptionInterceptor();
    }

    public static MysqlPooledConnection getInstance(Connection connection) throws SQLException {
        return !Util.isJdbc4() ? new MysqlPooledConnection(connection) : (MysqlPooledConnection) Util.handleNewInstance(JDBC_4_POOLED_CONNECTION_WRAPPER_CTOR, new Object[]{connection}, connection.getExceptionInterceptor());
    }

    @Override // javax.sql.PooledConnection
    public synchronized void addConnectionEventListener(ConnectionEventListener connectionEventListener) {
        Map<ConnectionEventListener, ConnectionEventListener> map = this.connectionEventListeners;
        if (map != null) {
            map.put(connectionEventListener, connectionEventListener);
        }
    }

    public synchronized void callConnectionEventListeners(int i, SQLException sQLException) {
        Map<ConnectionEventListener, ConnectionEventListener> map = this.connectionEventListeners;
        if (map == null) {
            return;
        }
        Iterator<Map.Entry<ConnectionEventListener, ConnectionEventListener>> it = map.entrySet().iterator();
        ConnectionEvent connectionEvent = new ConnectionEvent(this, sQLException);
        while (it.hasNext()) {
            ConnectionEventListener value = it.next().getValue();
            if (i == 2) {
                value.connectionClosed(connectionEvent);
            } else if (i == 1) {
                value.connectionErrorOccurred(connectionEvent);
            }
        }
    }

    @Override // javax.sql.PooledConnection
    public synchronized void close() throws SQLException {
        Connection connection = this.physicalConn;
        if (connection != null) {
            connection.close();
            this.physicalConn = null;
        }
        Map<ConnectionEventListener, ConnectionEventListener> map = this.connectionEventListeners;
        if (map != null) {
            map.clear();
            this.connectionEventListeners = null;
        }
    }

    @Override // javax.sql.PooledConnection
    public synchronized java.sql.Connection getConnection() throws SQLException {
        return getConnection(true, false);
    }

    public ExceptionInterceptor getExceptionInterceptor() {
        return this.exceptionInterceptor;
    }

    @Override // javax.sql.PooledConnection
    public synchronized void removeConnectionEventListener(ConnectionEventListener connectionEventListener) {
        Map<ConnectionEventListener, ConnectionEventListener> map = this.connectionEventListeners;
        if (map != null) {
            map.remove(connectionEventListener);
        }
    }

    public synchronized java.sql.Connection getConnection(boolean z, boolean z2) throws SQLException {
        ConnectionWrapper connectionWrapper;
        if (this.physicalConn == null) {
            SQLException sQLExceptionCreateSQLException = SQLError.createSQLException("Physical Connection doesn't exist", this.exceptionInterceptor);
            callConnectionEventListeners(1, sQLExceptionCreateSQLException);
            throw sQLExceptionCreateSQLException;
        }
        try {
            java.sql.Connection connection = this.logicalHandle;
            if (connection != null) {
                ((ConnectionWrapper) connection).close(false);
            }
            if (z) {
                this.physicalConn.resetServerState();
            }
            connectionWrapper = ConnectionWrapper.getInstance(this, this.physicalConn, z2);
            this.logicalHandle = connectionWrapper;
        } catch (SQLException e) {
            callConnectionEventListeners(1, e);
            throw e;
        }
        return connectionWrapper;
    }
}
