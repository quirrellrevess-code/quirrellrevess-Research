package com.mysql.jdbc;

import java.sql.SQLException;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public interface ConnectionPropertiesTransform {
    Properties transformProperties(Properties properties) throws SQLException;
}
