package com.mysql.jdbc.jdbc2.optional;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Util;
import java.lang.reflect.Constructor;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.sql.XAConnection;
import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes.dex */
public class SuspendableXAConnection extends MysqlPooledConnection implements XAConnection, XAResource {
    private static final Constructor<?> JDBC_4_XA_CONNECTION_WRAPPER_CTOR;
    private static final Map<Xid, XAConnection> XIDS_TO_PHYSICAL_CONNECTIONS;
    private XAConnection currentXAConnection;
    private XAResource currentXAResource;
    private Xid currentXid;
    private Connection underlyingConnection;

    static {
        if (Util.isJdbc4()) {
            try {
                JDBC_4_XA_CONNECTION_WRAPPER_CTOR = Class.forName("com.mysql.jdbc.jdbc2.optional.JDBC4SuspendableXAConnection").getConstructor(Connection.class);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException(e2);
            } catch (SecurityException e3) {
                throw new RuntimeException(e3);
            }
        } else {
            JDBC_4_XA_CONNECTION_WRAPPER_CTOR = null;
        }
        XIDS_TO_PHYSICAL_CONNECTIONS = new HashMap();
    }

    public SuspendableXAConnection(Connection connection) {
        super(connection);
        this.underlyingConnection = connection;
    }

    private static synchronized XAConnection findConnectionForXid(Connection connection, Xid xid) throws SQLException {
        throw null;
    }

    public static SuspendableXAConnection getInstance(Connection connection) throws SQLException {
        return !Util.isJdbc4() ? new SuspendableXAConnection(connection) : (SuspendableXAConnection) Util.handleNewInstance(JDBC_4_XA_CONNECTION_WRAPPER_CTOR, new Object[]{connection}, connection.getExceptionInterceptor());
    }

    private static synchronized void removeXAConnectionMapping(Xid xid) {
        XIDS_TO_PHYSICAL_CONNECTIONS.remove(xid);
    }

    private synchronized void switchToXid(Xid xid) throws XAException {
        if (xid == null) {
            throw new XAException();
        }
        try {
            if (!xid.equals(this.currentXid)) {
                XAConnection xAConnectionFindConnectionForXid = findConnectionForXid(this.underlyingConnection, xid);
                this.currentXAConnection = xAConnectionFindConnectionForXid;
                this.currentXid = xid;
                this.currentXAResource = xAConnectionFindConnectionForXid.getXAResource();
            }
        } catch (SQLException unused) {
            throw new XAException();
        }
    }

    @Override // com.mysql.jdbc.jdbc2.optional.MysqlPooledConnection, javax.sql.PooledConnection
    public void close() throws SQLException {
        if (this.currentXAConnection == null) {
            super.close();
        } else {
            removeXAConnectionMapping(this.currentXid);
            this.currentXAConnection.close();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.transaction.xa.XAException */
    public void commit(Xid xid, boolean z) throws XAException {
        switchToXid(xid);
        this.currentXAResource.commit(xid, z);
        removeXAConnectionMapping(xid);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.transaction.xa.XAException */
    public void end(Xid xid, int i) throws XAException {
        switchToXid(xid);
        this.currentXAResource.end(xid, i);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.transaction.xa.XAException */
    public void forget(Xid xid) throws XAException {
        switchToXid(xid);
        this.currentXAResource.forget(xid);
        removeXAConnectionMapping(xid);
    }

    @Override // com.mysql.jdbc.jdbc2.optional.MysqlPooledConnection, javax.sql.PooledConnection
    public synchronized java.sql.Connection getConnection() throws SQLException {
        XAConnection xAConnection = this.currentXAConnection;
        if (xAConnection == null) {
            return getConnection(false, true);
        }
        return xAConnection.getConnection();
    }

    public int getTransactionTimeout() throws XAException {
        return 0;
    }

    public XAResource getXAResource() throws SQLException {
        return this;
    }

    public boolean isSameRM(XAResource xAResource) throws XAException {
        return xAResource == this;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.transaction.xa.XAException */
    public int prepare(Xid xid) throws XAException {
        switchToXid(xid);
        return this.currentXAResource.prepare(xid);
    }

    public Xid[] recover(int i) throws XAException {
        return MysqlXAConnection.recover(this.underlyingConnection, i);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.transaction.xa.XAException */
    public void rollback(Xid xid) throws XAException {
        switchToXid(xid);
        this.currentXAResource.rollback(xid);
        removeXAConnectionMapping(xid);
    }

    public boolean setTransactionTimeout(int i) throws XAException {
        return false;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.transaction.xa.XAException */
    public void start(Xid xid, int i) throws XAException {
        switchToXid(xid);
        if (i != 2097152) {
            this.currentXAResource.start(xid, i);
        } else {
            this.currentXAResource.start(xid, Videoio.CAP_INTELPERC_IR_GENERATOR);
        }
    }
}
