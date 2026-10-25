package com.mysql.jdbc.jdbc2.optional;

import com.mysql.jdbc.NonRegisteringDriver;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.Name;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;

/* JADX INFO: loaded from: classes.dex */
public class MysqlDataSourceFactory implements ObjectFactory {
    public static final String DATA_SOURCE_CLASS_NAME = "com.mysql.jdbc.jdbc2.optional.MysqlDataSource";
    public static final String POOL_DATA_SOURCE_CLASS_NAME = "com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource";
    public static final String XA_DATA_SOURCE_CLASS_NAME = "com.mysql.jdbc.jdbc2.optional.MysqlXADataSource";

    private String nullSafeRefAddrStringGet(String str, Reference reference) {
        RefAddr refAddr = reference.get(str);
        if (refAddr != null) {
            return (String) refAddr.getContent();
        }
        return null;
    }

    public Object getObjectInstance(Object obj, Name name, Context context, Hashtable<?, ?> hashtable) throws Exception {
        Reference reference = (Reference) obj;
        String className = reference.getClassName();
        if (className == null) {
            return null;
        }
        if (!className.equals(DATA_SOURCE_CLASS_NAME) && !className.equals(POOL_DATA_SOURCE_CLASS_NAME) && !className.equals(XA_DATA_SOURCE_CLASS_NAME)) {
            return null;
        }
        try {
            MysqlDataSource mysqlDataSource = (MysqlDataSource) Class.forName(className).newInstance();
            String strNullSafeRefAddrStringGet = nullSafeRefAddrStringGet("port", reference);
            mysqlDataSource.setPort(strNullSafeRefAddrStringGet != null ? Integer.parseInt(strNullSafeRefAddrStringGet) : 3306);
            String strNullSafeRefAddrStringGet2 = nullSafeRefAddrStringGet(NonRegisteringDriver.USER_PROPERTY_KEY, reference);
            if (strNullSafeRefAddrStringGet2 != null) {
                mysqlDataSource.setUser(strNullSafeRefAddrStringGet2);
            }
            String strNullSafeRefAddrStringGet3 = nullSafeRefAddrStringGet(NonRegisteringDriver.PASSWORD_PROPERTY_KEY, reference);
            if (strNullSafeRefAddrStringGet3 != null) {
                mysqlDataSource.setPassword(strNullSafeRefAddrStringGet3);
            }
            String strNullSafeRefAddrStringGet4 = nullSafeRefAddrStringGet("serverName", reference);
            if (strNullSafeRefAddrStringGet4 != null) {
                mysqlDataSource.setServerName(strNullSafeRefAddrStringGet4);
            }
            String strNullSafeRefAddrStringGet5 = nullSafeRefAddrStringGet("databaseName", reference);
            if (strNullSafeRefAddrStringGet5 != null) {
                mysqlDataSource.setDatabaseName(strNullSafeRefAddrStringGet5);
            }
            String strNullSafeRefAddrStringGet6 = nullSafeRefAddrStringGet("explicitUrl", reference);
            if (strNullSafeRefAddrStringGet6 != null && Boolean.valueOf(strNullSafeRefAddrStringGet6).booleanValue()) {
                mysqlDataSource.setUrl(nullSafeRefAddrStringGet(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, reference));
            }
            mysqlDataSource.setPropertiesViaRef(reference);
            return mysqlDataSource;
        } catch (Exception e) {
            throw new RuntimeException("Unable to create DataSource of class '" + className + "', reason: " + e.toString());
        }
    }
}
