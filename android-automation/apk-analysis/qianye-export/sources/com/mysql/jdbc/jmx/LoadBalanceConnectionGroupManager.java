package com.mysql.jdbc.jmx;

import com.mysql.jdbc.ConnectionGroupManager;
import com.mysql.jdbc.ExceptionInterceptor;
import com.mysql.jdbc.SQLError;
import java.lang.management.ManagementFactory;
import java.sql.SQLException;
import javax.management.ObjectName;

/* JADX INFO: loaded from: classes.dex */
public class LoadBalanceConnectionGroupManager implements LoadBalanceConnectionGroupManagerMBean {
    private boolean isJmxRegistered = false;

    @Override // com.mysql.jdbc.jmx.LoadBalanceConnectionGroupManagerMBean
    public void addHost(String str, String str2, boolean z) {
        try {
            ConnectionGroupManager.addHost(str, str2, z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.mysql.jdbc.jmx.LoadBalanceConnectionGroupManagerMBean
    public int getActiveHostCount(String str) {
        return ConnectionGroupManager.getActiveHostCount(str);
    }

    @Override // com.mysql.jdbc.jmx.LoadBalanceConnectionGroupManagerMBean
    public String getActiveHostsList(String str) {
        return ConnectionGroupManager.getActiveHostLists(str);
    }

    @Override // com.mysql.jdbc.jmx.LoadBalanceConnectionGroupManagerMBean
    public long getActiveLogicalConnectionCount(String str) {
        return ConnectionGroupManager.getActiveLogicalConnectionCount(str);
    }

    @Override // com.mysql.jdbc.jmx.LoadBalanceConnectionGroupManagerMBean
    public long getActivePhysicalConnectionCount(String str) {
        return ConnectionGroupManager.getActivePhysicalConnectionCount(str);
    }

    @Override // com.mysql.jdbc.jmx.LoadBalanceConnectionGroupManagerMBean
    public String getRegisteredConnectionGroups() {
        return ConnectionGroupManager.getRegisteredConnectionGroups();
    }

    @Override // com.mysql.jdbc.jmx.LoadBalanceConnectionGroupManagerMBean
    public int getTotalHostCount(String str) {
        return ConnectionGroupManager.getTotalHostCount(str);
    }

    @Override // com.mysql.jdbc.jmx.LoadBalanceConnectionGroupManagerMBean
    public long getTotalLogicalConnectionCount(String str) {
        return ConnectionGroupManager.getTotalLogicalConnectionCount(str);
    }

    @Override // com.mysql.jdbc.jmx.LoadBalanceConnectionGroupManagerMBean
    public long getTotalPhysicalConnectionCount(String str) {
        return ConnectionGroupManager.getTotalPhysicalConnectionCount(str);
    }

    @Override // com.mysql.jdbc.jmx.LoadBalanceConnectionGroupManagerMBean
    public long getTotalTransactionCount(String str) {
        return ConnectionGroupManager.getTotalTransactionCount(str);
    }

    public synchronized void registerJmx() throws SQLException {
        if (this.isJmxRegistered) {
            return;
        }
        try {
            ManagementFactory.getPlatformMBeanServer().registerMBean(this, new ObjectName("com.mysql.jdbc.jmx:type=LoadBalanceConnectionGroupManager"));
            this.isJmxRegistered = true;
        } catch (Exception e) {
            throw SQLError.createSQLException("Unable to register load-balance management bean with JMX", (String) null, e, (ExceptionInterceptor) null);
        }
    }

    @Override // com.mysql.jdbc.jmx.LoadBalanceConnectionGroupManagerMBean
    public void removeHost(String str, String str2) throws SQLException {
        ConnectionGroupManager.removeHost(str, str2);
    }

    @Override // com.mysql.jdbc.jmx.LoadBalanceConnectionGroupManagerMBean
    public void stopNewConnectionsToHost(String str, String str2) throws SQLException {
        ConnectionGroupManager.removeHost(str, str2);
    }
}
