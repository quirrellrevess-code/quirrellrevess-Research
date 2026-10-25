package com.mysql.jdbc;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class PerVmServerConfigCacheFactory implements CacheAdapterFactory<String, Map<String, String>> {
    public static final ConcurrentHashMap<String, Map<String, String>> serverConfigByUrl = new ConcurrentHashMap<>();
    private static final CacheAdapter<String, Map<String, String>> serverConfigCache = new CacheAdapter<String, Map<String, String>>() { // from class: com.mysql.jdbc.PerVmServerConfigCacheFactory.1
        @Override // com.mysql.jdbc.CacheAdapter
        public Map<String, String> get(String str) {
            return PerVmServerConfigCacheFactory.serverConfigByUrl.get(str);
        }

        @Override // com.mysql.jdbc.CacheAdapter
        public void invalidate(String str) {
            PerVmServerConfigCacheFactory.serverConfigByUrl.remove(str);
        }

        @Override // com.mysql.jdbc.CacheAdapter
        public void invalidateAll(Set<String> set) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                PerVmServerConfigCacheFactory.serverConfigByUrl.remove(it.next());
            }
        }

        @Override // com.mysql.jdbc.CacheAdapter
        public void put(String str, Map<String, String> map) {
            PerVmServerConfigCacheFactory.serverConfigByUrl.putIfAbsent(str, map);
        }

        @Override // com.mysql.jdbc.CacheAdapter
        public void invalidateAll() {
            PerVmServerConfigCacheFactory.serverConfigByUrl.clear();
        }
    };

    @Override // com.mysql.jdbc.CacheAdapterFactory
    public CacheAdapter<String, Map<String, String>> getInstance(Connection connection, String str, int i, int i2, Properties properties) throws SQLException {
        return serverConfigCache;
    }
}
