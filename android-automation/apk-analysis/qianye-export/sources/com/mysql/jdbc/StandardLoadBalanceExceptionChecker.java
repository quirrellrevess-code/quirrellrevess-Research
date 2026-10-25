package com.mysql.jdbc;

import com.google.android.flexbox.BuildConfig;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class StandardLoadBalanceExceptionChecker implements LoadBalanceExceptionChecker {
    private List<Class<?>> sqlExClassList;
    private List<String> sqlStateList;

    private void configureSQLExceptionSubclassList(String str) {
        if (str == null || BuildConfig.FLAVOR.equals(str)) {
            return;
        }
        List<String> listSplit = StringUtils.split(str, ",", true);
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = listSplit.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(Class.forName(it.next()));
            } catch (Exception unused) {
            }
        }
        if (arrayList.size() > 0) {
            this.sqlExClassList = arrayList;
        }
    }

    private void configureSQLStateList(String str) {
        if (str == null || BuildConfig.FLAVOR.equals(str)) {
            return;
        }
        List<String> listSplit = StringUtils.split(str, ",", true);
        ArrayList arrayList = new ArrayList();
        for (String str2 : listSplit) {
            if (str2.length() > 0) {
                arrayList.add(str2);
            }
        }
        if (arrayList.size() > 0) {
            this.sqlStateList = arrayList;
        }
    }

    @Override // com.mysql.jdbc.Extension
    public void destroy() {
    }

    @Override // com.mysql.jdbc.Extension
    public void init(Connection connection, Properties properties) throws SQLException {
        configureSQLStateList(properties.getProperty("loadBalanceSQLStateFailover", null));
        configureSQLExceptionSubclassList(properties.getProperty("loadBalanceSQLExceptionSubclassFailover", null));
    }

    @Override // com.mysql.jdbc.LoadBalanceExceptionChecker
    public boolean shouldExceptionTriggerFailover(SQLException sQLException) {
        String sQLState = sQLException.getSQLState();
        if (sQLState != null) {
            if (sQLState.startsWith("08")) {
                return true;
            }
            List<String> list = this.sqlStateList;
            if (list != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (sQLState.startsWith(it.next().toString())) {
                        return true;
                    }
                }
            }
        }
        if (sQLException instanceof CommunicationsException) {
            return true;
        }
        List<Class<?>> list2 = this.sqlExClassList;
        if (list2 == null) {
            return false;
        }
        Iterator<Class<?>> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (it2.next().isInstance(sQLException)) {
                return true;
            }
        }
        return false;
    }
}
