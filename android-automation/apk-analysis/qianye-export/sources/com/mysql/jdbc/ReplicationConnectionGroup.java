package com.mysql.jdbc;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class ReplicationConnectionGroup {
    private String groupName;
    private long connections = 0;
    private long slavesAdded = 0;
    private long slavesRemoved = 0;
    private long slavesPromoted = 0;
    private long activeConnections = 0;
    private HashMap<Long, ReplicationConnection> replicationConnections = new HashMap<>();
    private Set<String> slaveHostList = new CopyOnWriteArraySet();
    private boolean isInitialized = false;
    private Set<String> masterHostList = new CopyOnWriteArraySet();

    public ReplicationConnectionGroup(String str) {
        this.groupName = str;
    }

    public void addSlaveHost(String str) throws SQLException {
        if (this.slaveHostList.add(str)) {
            this.slavesAdded++;
            Iterator<ReplicationConnection> it = this.replicationConnections.values().iterator();
            while (it.hasNext()) {
                it.next().addSlaveHost(str);
            }
        }
    }

    public long getActiveConnectionCount() {
        return this.activeConnections;
    }

    public long getConnectionCount() {
        return this.connections;
    }

    public int getConnectionCountWithHostAsMaster(String str) {
        Iterator<ReplicationConnection> it = this.replicationConnections.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().isHostMaster(str)) {
                i++;
            }
        }
        return i;
    }

    public int getConnectionCountWithHostAsSlave(String str) {
        Iterator<ReplicationConnection> it = this.replicationConnections.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().isHostSlave(str)) {
                i++;
            }
        }
        return i;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public Collection<String> getMasterHosts() {
        return this.masterHostList;
    }

    public long getNumberOfSlavePromotions() {
        return this.slavesPromoted;
    }

    public long getNumberOfSlavesAdded() {
        return this.slavesAdded;
    }

    public long getNumberOfSlavesRemoved() {
        return this.slavesRemoved;
    }

    public Collection<String> getSlaveHosts() {
        return this.slaveHostList;
    }

    public long getTotalConnectionCount() {
        return this.connections;
    }

    public void handleCloseConnection(ReplicationConnection replicationConnection) {
        this.replicationConnections.remove(Long.valueOf(replicationConnection.getConnectionGroupId()));
        this.activeConnections--;
    }

    public void promoteSlaveToMaster(String str) throws SQLException {
        if (this.slaveHostList.remove(str) || this.masterHostList.add(str)) {
            this.slavesPromoted++;
            Iterator<ReplicationConnection> it = this.replicationConnections.values().iterator();
            while (it.hasNext()) {
                it.next().promoteSlaveToMaster(str);
            }
        }
    }

    public long registerReplicationConnection(ReplicationConnection replicationConnection, List<String> list, List<String> list2) {
        long j;
        synchronized (this) {
            if (!this.isInitialized) {
                if (list != null) {
                    this.masterHostList.addAll(list);
                }
                if (list2 != null) {
                    this.slaveHostList.addAll(list2);
                }
                this.isInitialized = true;
            }
            j = this.connections + 1;
            this.connections = j;
            this.replicationConnections.put(Long.valueOf(j), replicationConnection);
        }
        this.activeConnections++;
        return j;
    }

    public void removeMasterHost(String str) throws SQLException {
        removeMasterHost(str, true);
    }

    public void removeSlaveHost(String str, boolean z) throws SQLException {
        if (this.slaveHostList.remove(str)) {
            this.slavesRemoved++;
            Iterator<ReplicationConnection> it = this.replicationConnections.values().iterator();
            while (it.hasNext()) {
                it.next().removeSlave(str, z);
            }
        }
    }

    public String toString() {
        return "ReplicationConnectionGroup[groupName=" + this.groupName + ",masterHostList=" + this.masterHostList + ",slaveHostList=" + this.slaveHostList + "]";
    }

    public void removeMasterHost(String str, boolean z) throws SQLException {
        if (this.masterHostList.remove(str)) {
            Iterator<ReplicationConnection> it = this.replicationConnections.values().iterator();
            while (it.hasNext()) {
                it.next().removeMasterHost(str, z);
            }
        }
    }
}
