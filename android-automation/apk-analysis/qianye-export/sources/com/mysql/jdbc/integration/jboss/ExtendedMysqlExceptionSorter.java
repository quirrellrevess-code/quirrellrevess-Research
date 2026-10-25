package com.mysql.jdbc.integration.jboss;

import java.sql.SQLException;
import org.jboss.resource.adapter.jdbc.vendor.MySQLExceptionSorter;

/* JADX INFO: loaded from: classes.dex */
public final class ExtendedMysqlExceptionSorter extends MySQLExceptionSorter {
    public static final long serialVersionUID = -2454582336945931069L;

    public boolean isExceptionFatal(SQLException sQLException) {
        String sQLState = sQLException.getSQLState();
        if (sQLState == null || !sQLState.startsWith("08")) {
            return super.isExceptionFatal(sQLException);
        }
        return true;
    }
}
