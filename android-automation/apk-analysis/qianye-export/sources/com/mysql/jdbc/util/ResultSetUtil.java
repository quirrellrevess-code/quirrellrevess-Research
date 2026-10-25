package com.mysql.jdbc.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/* JADX INFO: loaded from: classes.dex */
public class ResultSetUtil {
    public static StringBuilder appendResultSetSlashGStyle(StringBuilder sb, ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        String[] strArr = new String[columnCount];
        int i = 0;
        int length = 0;
        while (i < columnCount) {
            int i2 = i + 1;
            strArr[i] = metaData.getColumnLabel(i2);
            if (strArr[i].length() > length) {
                length = strArr[i].length();
            }
            i = i2;
        }
        int i3 = 1;
        while (resultSet.next()) {
            sb.append("*************************** ");
            int i4 = i3 + 1;
            sb.append(i3);
            sb.append(". row ***************************\n");
            int i5 = 0;
            while (i5 < columnCount) {
                int length2 = length - strArr[i5].length();
                for (int i6 = 0; i6 < length2; i6++) {
                    sb.append(" ");
                }
                sb.append(strArr[i5]);
                sb.append(": ");
                i5++;
                String string = resultSet.getString(i5);
                if (string != null) {
                    sb.append(string);
                } else {
                    sb.append("NULL");
                }
                sb.append("\n");
            }
            sb.append("\n");
            i3 = i4;
        }
        return sb;
    }
}
