package com.mysql.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class RandomBalanceStrategy implements BalanceStrategy {
    private Map<String, Integer> getArrayIndexMap(List<String> list) {
        HashMap map = new HashMap(list.size());
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), Integer.valueOf(i));
        }
        return map;
    }

    @Override // com.mysql.jdbc.Extension
    public void destroy() {
    }

    @Override // com.mysql.jdbc.Extension
    public void init(Connection connection, Properties properties) throws SQLException {
    }

    @Override // com.mysql.jdbc.BalanceStrategy
    public ConnectionImpl pickConnection(LoadBalancedConnectionProxy loadBalancedConnectionProxy, List<String> list, Map<String, ConnectionImpl> map, long[] jArr, int i) throws SQLException {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        arrayList.addAll(list);
        arrayList.removeAll(loadBalancedConnectionProxy.getGlobalBlacklist().keySet());
        Map<String, Integer> arrayIndexMap = getArrayIndexMap(arrayList);
        int i2 = 0;
        SQLException sQLException = null;
        while (i2 < i) {
            int iFloor = (int) Math.floor(Math.random() * ((double) arrayList.size()));
            if (arrayList.size() == 0) {
                throw SQLError.createSQLException("No hosts configured", null);
            }
            String str = arrayList.get(iFloor);
            ConnectionImpl connectionImplCreateConnectionForHost = map.get(str);
            if (connectionImplCreateConnectionForHost == null) {
                try {
                    connectionImplCreateConnectionForHost = loadBalancedConnectionProxy.createConnectionForHost(str);
                } catch (SQLException e) {
                    if (!loadBalancedConnectionProxy.shouldExceptionTriggerConnectionSwitch(e)) {
                        throw e;
                    }
                    Integer num = arrayIndexMap.get(str);
                    if (num != null) {
                        arrayList.remove(num.intValue());
                        arrayIndexMap = getArrayIndexMap(arrayList);
                    }
                    loadBalancedConnectionProxy.addToGlobalBlacklist(str);
                    if (arrayList.size() == 0) {
                        i2++;
                        try {
                            Thread.sleep(250L);
                        } catch (InterruptedException unused) {
                        }
                        new HashMap(size);
                        arrayList.addAll(list);
                        arrayList.removeAll(loadBalancedConnectionProxy.getGlobalBlacklist().keySet());
                        arrayIndexMap = getArrayIndexMap(arrayList);
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
