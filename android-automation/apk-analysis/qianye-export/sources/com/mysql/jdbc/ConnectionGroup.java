package com.mysql.jdbc;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ConnectionGroup {
    private String groupName;
    private long connections = 0;
    private long activeConnections = 0;
    private HashMap<Long, LoadBalancedConnectionProxy> connectionProxies = new HashMap<>();
    private Set<String> hostList = new HashSet();
    private boolean isInitialized = false;
    private long closedProxyTotalPhysicalConnections = 0;
    private long closedProxyTotalTransactions = 0;
    private int activeHosts = 0;
    private Set<String> closedHosts = new HashSet();

    public ConnectionGroup(String str) {
        this.groupName = str;
    }

    public void addHost(String str) {
        addHost(str, false);
    }

    public void closeConnectionProxy(LoadBalancedConnectionProxy loadBalancedConnectionProxy) {
        this.activeConnections--;
        this.connectionProxies.remove(Long.valueOf(loadBalancedConnectionProxy.getConnectionGroupProxyID()));
        this.closedProxyTotalPhysicalConnections += loadBalancedConnectionProxy.getTotalPhysicalConnectionCount();
        this.closedProxyTotalTransactions += loadBalancedConnectionProxy.getTransactionCount();
    }

    public int getActiveHostCount() {
        return this.activeHosts;
    }

    public long getActiveLogicalConnectionCount() {
        return this.activeConnections;
    }

    public long getActivePhysicalConnectionCount() {
        HashMap map = new HashMap();
        synchronized (this.connectionProxies) {
            map.putAll(this.connectionProxies);
        }
        Iterator it = map.values().iterator();
        long activePhysicalConnectionCount = 0;
        while (it.hasNext()) {
            activePhysicalConnectionCount += ((LoadBalancedConnectionProxy) it.next()).getActivePhysicalConnectionCount();
        }
        return activePhysicalConnectionCount;
    }

    public Collection<String> getClosedHosts() {
        return this.closedHosts;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public Collection<String> getInitialHosts() {
        return this.hostList;
    }

    public long getTotalLogicalConnectionCount() {
        return this.connections;
    }

    public long getTotalPhysicalConnectionCount() {
        long totalPhysicalConnectionCount = this.closedProxyTotalPhysicalConnections;
        HashMap map = new HashMap();
        synchronized (this.connectionProxies) {
            map.putAll(this.connectionProxies);
        }
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            totalPhysicalConnectionCount += ((LoadBalancedConnectionProxy) it.next()).getTotalPhysicalConnectionCount();
        }
        return totalPhysicalConnectionCount;
    }

    public long getTotalTransactionCount() {
        long transactionCount = this.closedProxyTotalTransactions;
        HashMap map = new HashMap();
        synchronized (this.connectionProxies) {
            map.putAll(this.connectionProxies);
        }
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            transactionCount += ((LoadBalancedConnectionProxy) it.next()).getTransactionCount();
        }
        return transactionCount;
    }

    public long registerConnectionProxy(LoadBalancedConnectionProxy loadBalancedConnectionProxy, List<String> list) {
        long j;
        synchronized (this) {
            if (!this.isInitialized) {
                this.hostList.addAll(list);
                this.isInitialized = true;
                this.activeHosts = list.size();
            }
            j = this.connections + 1;
            this.connections = j;
            this.connectionProxies.put(Long.valueOf(j), loadBalancedConnectionProxy);
        }
        this.activeConnections++;
        return j;
    }

    public void removeHost(String str) throws SQLException {
        removeHost(str, false);
    }

    public void addHost(String str, boolean z) {
        synchronized (this) {
            if (this.hostList.add(str)) {
                this.activeHosts++;
            }
        }
        if (z) {
            HashMap map = new HashMap();
            synchronized (this.connectionProxies) {
                map.putAll(this.connectionProxies);
            }
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                ((LoadBalancedConnectionProxy) it.next()).addHost(str);
            }
        }
    }

    public void removeHost(String str, boolean z) throws SQLException {
        removeHost(str, z, true);
    }

    public synchronized void removeHost(String str, boolean z, boolean z2) throws SQLException {
        if (this.activeHosts != 1) {
            if (!this.hostList.remove(str)) {
                throw SQLError.createSQLException("Host is not configured: " + str, null);
            }
            this.activeHosts--;
            if (z) {
                HashMap map = new HashMap();
                synchronized (this.connectionProxies) {
                    map.putAll(this.connectionProxies);
                }
                for (LoadBalancedConnectionProxy loadBalancedConnectionProxy : map.values()) {
                    if (z2) {
                        loadBalancedConnectionProxy.removeHostWhenNotInUse(str);
                    } else {
                        loadBalancedConnectionProxy.removeHost(str);
                    }
                }
            }
            this.closedHosts.add(str);
        } else {
            throw SQLError.createSQLException("Cannot remove host, only one configured host active.", null);
        }
    }
}
