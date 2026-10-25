package com.mysql.jdbc.jdbc2.optional;

import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.sql.StatementEvent;
import javax.sql.StatementEventListener;

/* JADX INFO: loaded from: classes.dex */
public class JDBC4MysqlPooledConnection extends MysqlPooledConnection {
    private final Map<StatementEventListener, StatementEventListener> statementEventListeners;

    public JDBC4MysqlPooledConnection(Connection connection) {
        super(connection);
        this.statementEventListeners = new HashMap();
    }

    @Override // javax.sql.PooledConnection
    public void addStatementEventListener(StatementEventListener statementEventListener) {
        synchronized (this.statementEventListeners) {
            this.statementEventListeners.put(statementEventListener, statementEventListener);
        }
    }

    @Override // com.mysql.jdbc.jdbc2.optional.MysqlPooledConnection, javax.sql.PooledConnection
    public synchronized void close() throws SQLException {
        super.close();
        this.statementEventListeners.clear();
    }

    public void fireStatementEvent(StatementEvent statementEvent) throws SQLException {
        synchronized (this.statementEventListeners) {
            Iterator<StatementEventListener> it = this.statementEventListeners.keySet().iterator();
            while (it.hasNext()) {
                it.next().statementClosed(statementEvent);
            }
        }
    }

    @Override // javax.sql.PooledConnection
    public void removeStatementEventListener(StatementEventListener statementEventListener) {
        synchronized (this.statementEventListeners) {
            this.statementEventListeners.remove(statementEventListener);
        }
    }
}
