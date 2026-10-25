package com.mysql.jdbc.util;

import com.mysql.jdbc.TimeUtil;
import java.sql.DriverManager;
import java.sql.ResultSet;

/* JADX INFO: loaded from: classes.dex */
public class TimezoneDump {
    private static final String DEFAULT_URL = "jdbc:mysql:///test";

    public static void main(String[] strArr) throws Exception {
        Throwable th;
        ResultSet resultSetExecuteQuery;
        String str = (strArr.length != 1 || strArr[0] == null) ? DEFAULT_URL : strArr[0];
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        try {
            resultSetExecuteQuery = DriverManager.getConnection(str).createStatement().executeQuery("SHOW VARIABLES LIKE 'timezone'");
            while (resultSetExecuteQuery.next()) {
                try {
                    String string = resultSetExecuteQuery.getString(2);
                    System.out.println("MySQL timezone name: " + string);
                    String canonicalTimezone = TimeUtil.getCanonicalTimezone(string, null);
                    System.out.println("Java timezone name: " + canonicalTimezone);
                } catch (Throwable th2) {
                    th = th2;
                    if (resultSetExecuteQuery != null) {
                        resultSetExecuteQuery.close();
                    }
                    throw th;
                }
            }
            if (resultSetExecuteQuery != null) {
                resultSetExecuteQuery.close();
            }
        } catch (Throwable th3) {
            th = th3;
            resultSetExecuteQuery = null;
        }
    }
}
