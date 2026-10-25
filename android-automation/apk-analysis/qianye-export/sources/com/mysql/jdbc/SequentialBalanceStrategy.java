package com.mysql.jdbc;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class SequentialBalanceStrategy implements BalanceStrategy {
    private int currentHostIndex = -1;

    @Override // com.mysql.jdbc.Extension
    public void destroy() {
    }

    @Override // com.mysql.jdbc.Extension
    public void init(Connection connection, Properties properties) throws SQLException {
    }

    @Override // com.mysql.jdbc.BalanceStrategy
    public ConnectionImpl pickConnection(LoadBalancedConnectionProxy loadBalancedConnectionProxy, List<String> list, Map<String, ConnectionImpl> map, long[] jArr, int i) throws SQLException {
        boolean z;
        int size = list.size();
        Map<String, Long> globalBlacklist = loadBalancedConnectionProxy.getGlobalBlacklist();
        SQLException sQLException = null;
        while (i > 0) {
            int i2 = 0;
            boolean z2 = true;
            if (size == 1) {
                this.currentHostIndex = 0;
            } else {
                int i3 = this.currentHostIndex;
                if (i3 == -1) {
                    int iFloor = (int) Math.floor(Math.random() * ((double) size));
                    for (int i4 = iFloor; i4 < size; i4++) {
                        if (!globalBlacklist.containsKey(list.get(i4))) {
                            this.currentHostIndex = i4;
                            break;
                        }
                    }
                    if (this.currentHostIndex == -1) {
                        while (i2 < iFloor) {
                            if (!globalBlacklist.containsKey(list.get(i2))) {
                                this.currentHostIndex = i2;
                                break;
                            }
                            i2++;
                        }
                    }
                    if (this.currentHostIndex == -1) {
                        globalBlacklist = loadBalancedConnectionProxy.getGlobalBlacklist();
                        try {
                            Thread.sleep(250L);
                        } catch (InterruptedException unused) {
                        }
                    }
                } else {
                    while (true) {
                        i3++;
                        if (i3 >= size) {
                            z = false;
                            break;
                        }
                        if (!globalBlacklist.containsKey(list.get(i3))) {
                            this.currentHostIndex = i3;
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        z2 = z;
                        break;
                    }
                    while (true) {
                        if (i2 >= this.currentHostIndex) {
                            z2 = z;
                            break;
                        }
                        if (!globalBlacklist.containsKey(list.get(i2))) {
                            this.currentHostIndex = i2;
                            break;
                        }
                        i2++;
                    }
                    if (!z2) {
                        globalBlacklist = loadBalancedConnectionProxy.getGlobalBlacklist();
                        Thread.sleep(250L);
                    }
                }
            }
            String str = list.get(this.currentHostIndex);
            ConnectionImpl connectionImplCreateConnectionForHost = map.get(str);
            if (connectionImplCreateConnectionForHost == null) {
                try {
                    connectionImplCreateConnectionForHost = loadBalancedConnectionProxy.createConnectionForHost(str);
                } catch (SQLException e) {
                    if (!loadBalancedConnectionProxy.shouldExceptionTriggerConnectionSwitch(e)) {
                        throw e;
                    }
                    loadBalancedConnectionProxy.addToGlobalBlacklist(str);
                    try {
                        Thread.sleep(250L);
                    } catch (InterruptedException unused2) {
                    }
                    sQLException = e;
                }
            }
            return connectionImplCreateConnectionForHost;
        }
        if (sQLException == null) {
            return null;
        }
        throw sQLException;
    }
}
