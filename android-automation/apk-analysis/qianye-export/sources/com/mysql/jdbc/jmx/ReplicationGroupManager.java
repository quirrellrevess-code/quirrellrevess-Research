package com.mysql.jdbc.jmx;

import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.ExceptionInterceptor;
import com.mysql.jdbc.ReplicationConnectionGroup;
import com.mysql.jdbc.ReplicationConnectionGroupManager;
import com.mysql.jdbc.SQLError;
import java.lang.management.ManagementFactory;
import java.sql.SQLException;
import javax.management.ObjectName;

/* JADX INFO: loaded from: classes.dex */
public class ReplicationGroupManager implements ReplicationGroupManagerMBean {
    private boolean isJmxRegistered = false;

    @Override // com.mysql.jdbc.jmx.ReplicationGroupManagerMBean
    public void addSlaveHost(String str, String str2) throws SQLException {
        ReplicationConnectionGroupManager.addSlaveHost(str, str2);
    }

    @Override // com.mysql.jdbc.jmx.ReplicationGroupManagerMBean
    public long getActiveLogicalConnectionCount(String str) {
        return ReplicationConnectionGroupManager.getActiveConnectionCount(str);
    }

    @Override // com.mysql.jdbc.jmx.ReplicationGroupManagerMBean
    public int getActiveMasterHostCount(String str) {
        return ReplicationConnectionGroupManager.getMasterHosts(str).size();
    }

    @Override // com.mysql.jdbc.jmx.ReplicationGroupManagerMBean
    public int getActiveSlaveHostCount(String str) {
        return ReplicationConnectionGroupManager.getSlaveHosts(str).size();
    }

    @Override // com.mysql.jdbc.jmx.ReplicationGroupManagerMBean
    public String getMasterHostsList(String str) {
        StringBuilder sb = new StringBuilder(BuildConfig.FLAVOR);
        boolean z = false;
        for (String str2 : ReplicationConnectionGroupManager.getMasterHosts(str)) {
            if (z) {
                sb.append(",");
            }
            z = true;
            sb.append(str2);
        }
        return sb.toString();
    }

    @Override // com.mysql.jdbc.jmx.ReplicationGroupManagerMBean
    public String getRegisteredConnectionGroups() {
        StringBuilder sb = new StringBuilder(BuildConfig.FLAVOR);
        boolean z = false;
        for (ReplicationConnectionGroup replicationConnectionGroup : ReplicationConnectionGroupManager.getGroupsMatching(null)) {
            if (z) {
                sb.append(",");
            }
            z = true;
            sb.append(replicationConnectionGroup.getGroupName());
        }
        return sb.toString();
    }

    @Override // com.mysql.jdbc.jmx.ReplicationGroupManagerMBean
    public String getSlaveHostsList(String str) {
        StringBuilder sb = new StringBuilder(BuildConfig.FLAVOR);
        boolean z = false;
        for (String str2 : ReplicationConnectionGroupManager.getSlaveHosts(str)) {
            if (z) {
                sb.append(",");
            }
            z = true;
            sb.append(str2);
        }
        return sb.toString();
    }

    @Override // com.mysql.jdbc.jmx.ReplicationGroupManagerMBean
    public int getSlavePromotionCount(String str) {
        return ReplicationConnectionGroupManager.getNumberOfMasterPromotion(str);
    }

    @Override // com.mysql.jdbc.jmx.ReplicationGroupManagerMBean
    public long getTotalLogicalConnectionCount(String str) {
        return ReplicationConnectionGroupManager.getTotalConnectionCount(str);
    }

    @Override // com.mysql.jdbc.jmx.ReplicationGroupManagerMBean
    public void promoteSlaveToMaster(String str, String str2) throws SQLException {
        ReplicationConnectionGroupManager.promoteSlaveToMaster(str, str2);
    }

    public synchronized void registerJmx() throws SQLException {
        if (this.isJmxRegistered) {
            return;
        }
        try {
            ManagementFactory.getPlatformMBeanServer().registerMBean(this, new ObjectName("com.mysql.jdbc.jmx:type=ReplicationGroupManager"));
            this.isJmxRegistered = true;
        } catch (Exception e) {
            throw SQLError.createSQLException("Unable to register replication host management bean with JMX", (String) null, e, (ExceptionInterceptor) null);
        }
    }

    @Override // com.mysql.jdbc.jmx.ReplicationGroupManagerMBean
    public void removeMasterHost(String str, String str2) throws SQLException {
        ReplicationConnectionGroupManager.removeMasterHost(str, str2);
    }

    @Override // com.mysql.jdbc.jmx.ReplicationGroupManagerMBean
    public void removeSlaveHost(String str, String str2) throws SQLException {
        ReplicationConnectionGroupManager.removeSlaveHost(str, str2);
    }
}
