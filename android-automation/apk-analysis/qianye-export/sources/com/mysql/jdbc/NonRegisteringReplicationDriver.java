package com.mysql.jdbc;

import java.sql.SQLException;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class NonRegisteringReplicationDriver extends NonRegisteringDriver {
    @Override // com.mysql.jdbc.NonRegisteringDriver, java.sql.Driver
    public java.sql.Connection connect(String str, Properties properties) throws SQLException {
        return connectReplicationConnection(str, properties);
    }
}
