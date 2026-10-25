package com.mysql.jdbc;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class ServerAffinityStrategy extends RandomBalanceStrategy {
    public static final String AFFINITY_ORDER = "serverAffinityOrder";
    public String[] affinityOrderedServers = null;

    @Override // com.mysql.jdbc.RandomBalanceStrategy, com.mysql.jdbc.Extension
    public void init(Connection connection, Properties properties) throws SQLException {
        super.init(connection, properties);
        String property = properties.getProperty(AFFINITY_ORDER);
        if (StringUtils.isNullOrEmpty(property)) {
            return;
        }
        this.affinityOrderedServers = property.split(",");
    }

    @Override // com.mysql.jdbc.RandomBalanceStrategy, com.mysql.jdbc.BalanceStrategy
    public ConnectionImpl pickConnection(LoadBalancedConnectionProxy loadBalancedConnectionProxy, List<String> list, Map<String, ConnectionImpl> map, long[] jArr, int i) throws SQLException {
        if (this.affinityOrderedServers == null) {
            return super.pickConnection(loadBalancedConnectionProxy, list, map, jArr, i);
        }
        Map<String, Long> globalBlacklist = loadBalancedConnectionProxy.getGlobalBlacklist();
        for (String str : this.affinityOrderedServers) {
            if (list.contains(str) && !globalBlacklist.containsKey(str)) {
                ConnectionImpl connectionImpl = map.get(str);
                if (connectionImpl != null) {
                    return connectionImpl;
                }
                try {
                    return loadBalancedConnectionProxy.createConnectionForHost(str);
                } catch (SQLException e) {
                    if (loadBalancedConnectionProxy.shouldExceptionTriggerConnectionSwitch(e)) {
                        loadBalancedConnectionProxy.addToGlobalBlacklist(str);
                    }
                }
            }
        }
        return super.pickConnection(loadBalancedConnectionProxy, list, map, jArr, i);
    }
}
