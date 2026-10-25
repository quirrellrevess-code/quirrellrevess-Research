package com.p000nx.assist.lua;

import I1I.IL1Iii;
import android.text.TextUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SQL {
    public static final String JDBC_DRIVER = IL1Iii.IL1Iii(new byte[]{1, 86, 8, 23, 8, 78, 17, 72, 9, 23, 15, 83, 0, 90, 75, 125, 23, 94, 20, 92, 23}, IL1Iii.IL1Iii(new byte[]{80, 90, 82, 14, 80, 82}, IL1Iii.IL1Iii(new byte[]{84, 91, 84, 2, 13, 85}, "f8c580")));
    private Connection connection;

    public boolean connect(String str, int i, String str2, String str3, String str4, int i2) throws Exception {
        String str5 = String.format(IL1Iii.IL1Iii(new byte[]{83, 83, 4, 1, 92, 15, 64, 68, 23, 14, 92, 77, 22, 18, 21, 88, 67, 6, 22, 18, 21, 93, 5, 13, 87, 89, 3, 1, 18, 54, 80, 90, 3, 13, 19, 22, 4, 18, 2}, IL1Iii.IL1Iii(new byte[]{13, 2, 81, 83, 7, 80}, IL1Iii.IL1Iii(new byte[]{12, 87, 1, 80, 82, 80}, "8b6a3b"))), str, Integer.valueOf(i), str2, Integer.valueOf(i2));
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(str5, str3, str4);
        this.connection = connection;
        return connection != null;
    }

    public boolean disconnect() {
        try {
            Connection connection = this.connection;
            if (connection == null || connection.isClosed()) {
                return false;
            }
            this.connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean execute(String str) throws Exception {
        return this.connection.createStatement().execute(str);
    }

    public String executeQuery(String str) throws Exception {
        JSONArray jSONArray = new JSONArray();
        ResultSet resultSetExecuteQuery = this.connection.createStatement().executeQuery(str);
        if (resultSetExecuteQuery != null) {
            int i = 0;
            while (resultSetExecuteQuery.next()) {
                ResultSetMetaData metaData = resultSetExecuteQuery.getMetaData();
                int columnCount = metaData.getColumnCount();
                JSONObject jSONObject = new JSONObject();
                for (int i2 = 1; i2 <= columnCount; i2++) {
                    String columnName = metaData.getColumnName(i2);
                    String string = resultSetExecuteQuery.getString(columnName);
                    if (!TextUtils.isEmpty(columnName)) {
                        jSONObject.put(columnName, string);
                    }
                }
                jSONArray.put(i, jSONObject);
                i++;
            }
        }
        SQL.class.toString();
        return jSONArray.toString();
    }
}
