package com.mysql.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

/* JADX INFO: loaded from: classes.dex */
public class Driver extends NonRegisteringDriver implements java.sql.Driver {
    static {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException unused) {
            throw new RuntimeException("Can't register driver!");
        }
    }
}
