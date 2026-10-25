package com.mysql.jdbc;

import java.sql.SQLException;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public interface CacheAdapterFactory<K, V> {
    CacheAdapter<K, V> getInstance(Connection connection, String str, int i, int i2, Properties properties) throws SQLException;
}
