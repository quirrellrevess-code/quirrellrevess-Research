package com.mysql.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

/* JADX INFO: loaded from: classes.dex */
public class ReplicationDriver extends NonRegisteringReplicationDriver implements java.sql.Driver {
    static {
        try {
            DriverManager.registerDriver(new NonRegisteringReplicationDriver());
        } catch (SQLException unused) {
            throw new RuntimeException("Can't register driver!");
        }
    }
}
