package com.mysql.jdbc;

import com.mysql.jdbc.util.LRUCache;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class PerConnectionLRUFactory implements CacheAdapterFactory<String, PreparedStatement.ParseInfo> {

    public class PerConnectionLRU implements CacheAdapter<String, PreparedStatement.ParseInfo> {
        private final LRUCache<String, PreparedStatement.ParseInfo> cache;
        private final int cacheSqlLimit;
        private final Connection conn;

        public PerConnectionLRU(Connection connection, int i, int i2) {
            this.cacheSqlLimit = i2;
            this.cache = new LRUCache<>(i);
            this.conn = connection;
        }

        @Override // com.mysql.jdbc.CacheAdapter
        public void invalidateAll(Set<String> set) {
            synchronized (this.conn.getConnectionMutex()) {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    this.cache.remove(it.next());
                }
            }
        }

        @Override // com.mysql.jdbc.CacheAdapter
        public PreparedStatement.ParseInfo get(String str) {
            PreparedStatement.ParseInfo parseInfo;
            if (str == null || str.length() > this.cacheSqlLimit) {
                return null;
            }
            synchronized (this.conn.getConnectionMutex()) {
                parseInfo = this.cache.get(str);
            }
            return parseInfo;
        }

        @Override // com.mysql.jdbc.CacheAdapter
        public void invalidate(String str) {
            synchronized (this.conn.getConnectionMutex()) {
                this.cache.remove(str);
            }
        }

        @Override // com.mysql.jdbc.CacheAdapter
        public void put(String str, PreparedStatement.ParseInfo parseInfo) {
            if (str == null || str.length() > this.cacheSqlLimit) {
                return;
            }
            synchronized (this.conn.getConnectionMutex()) {
                this.cache.put(str, parseInfo);
            }
        }

        @Override // com.mysql.jdbc.CacheAdapter
        public void invalidateAll() {
            synchronized (this.conn.getConnectionMutex()) {
                this.cache.clear();
            }
        }
    }

    @Override // com.mysql.jdbc.CacheAdapterFactory
    public CacheAdapter<String, PreparedStatement.ParseInfo> getInstance(Connection connection, String str, int i, int i2, Properties properties) throws SQLException {
        return new PerConnectionLRU(connection, i, i2);
    }
}
