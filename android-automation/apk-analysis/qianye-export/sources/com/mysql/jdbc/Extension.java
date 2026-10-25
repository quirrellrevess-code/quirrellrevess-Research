package com.mysql.jdbc;

import java.sql.SQLException;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public interface Extension {
    void destroy();

    void init(Connection connection, Properties properties) throws SQLException;
}
