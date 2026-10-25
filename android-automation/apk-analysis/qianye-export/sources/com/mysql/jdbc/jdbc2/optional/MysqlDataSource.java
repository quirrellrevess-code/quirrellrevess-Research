package com.mysql.jdbc.jdbc2.optional;

import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.ConnectionPropertiesImpl;
import com.mysql.jdbc.ExceptionInterceptor;
import com.mysql.jdbc.Messages;
import com.mysql.jdbc.NonRegisteringDriver;
import com.mysql.jdbc.SQLError;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.naming.StringRefAddr;
import javax.sql.DataSource;

/* JADX INFO: loaded from: classes.dex */
public class MysqlDataSource extends ConnectionPropertiesImpl implements DataSource, Referenceable, Serializable {
    public static final NonRegisteringDriver mysqlDriver;
    public static final long serialVersionUID = -5515846944416881264L;
    public transient PrintWriter logWriter = null;
    public String databaseName = null;
    public String encoding = null;
    public String hostName = null;
    public String password = null;
    public String profileSql = "false";
    public String url = null;
    public String user = null;
    public boolean explicitUrl = false;
    public int port = 3306;

    static {
        try {
            mysqlDriver = new NonRegisteringDriver();
        } catch (Exception unused) {
            throw new RuntimeException("Can not load Driver class com.mysql.jdbc.Driver");
        }
    }

    @Override // com.mysql.jdbc.ConnectionPropertiesImpl
    public Properties exposeAsProperties(Properties properties) throws SQLException {
        return exposeAsProperties(properties, true);
    }

    @Override // javax.sql.DataSource
    public Connection getConnection() throws SQLException {
        return getConnection(this.user, this.password);
    }

    public String getDatabaseName() {
        String str = this.databaseName;
        return str != null ? str : BuildConfig.FLAVOR;
    }

    @Override // javax.sql.CommonDataSource
    public PrintWriter getLogWriter() {
        return this.logWriter;
    }

    @Override // javax.sql.CommonDataSource
    public int getLoginTimeout() {
        return 0;
    }

    public int getPort() {
        return this.port;
    }

    public int getPortNumber() {
        return getPort();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.naming.NamingException */
    public Reference getReference() throws NamingException {
        Reference reference = new Reference(getClass().getName(), "com.mysql.jdbc.jdbc2.optional.MysqlDataSourceFactory", (String) null);
        reference.add(new StringRefAddr(NonRegisteringDriver.USER_PROPERTY_KEY, getUser()));
        reference.add(new StringRefAddr(NonRegisteringDriver.PASSWORD_PROPERTY_KEY, this.password));
        reference.add(new StringRefAddr("serverName", getServerName()));
        reference.add(new StringRefAddr("port", BuildConfig.FLAVOR + getPort()));
        reference.add(new StringRefAddr("databaseName", getDatabaseName()));
        reference.add(new StringRefAddr(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, getUrl()));
        reference.add(new StringRefAddr("explicitUrl", String.valueOf(this.explicitUrl)));
        try {
            storeToRef(reference);
            return reference;
        } catch (SQLException e) {
            throw new NamingException(e.getMessage());
        }
    }

    public String getServerName() {
        String str = this.hostName;
        return str != null ? str : BuildConfig.FLAVOR;
    }

    public String getURL() {
        return getUrl();
    }

    public String getUrl() {
        if (this.explicitUrl) {
            return this.url;
        }
        return "jdbc:mysql://" + getServerName() + ":" + getPort() + "/" + getDatabaseName();
    }

    public String getUser() {
        return this.user;
    }

    public void setDatabaseName(String str) {
        this.databaseName = str;
    }

    @Override // javax.sql.CommonDataSource
    public void setLogWriter(PrintWriter printWriter) throws SQLException {
        this.logWriter = printWriter;
    }

    @Override // javax.sql.CommonDataSource
    public void setLoginTimeout(int i) throws SQLException {
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public void setPortNumber(int i) {
        setPort(i);
    }

    public void setPropertiesViaRef(Reference reference) throws SQLException {
        super.initializeFromRef(reference);
    }

    public void setServerName(String str) {
        this.hostName = str;
    }

    public void setURL(String str) {
        setUrl(str);
    }

    public void setUrl(String str) {
        this.url = str;
        this.explicitUrl = true;
    }

    public void setUser(String str) {
        this.user = str;
    }

    @Override // javax.sql.DataSource
    public Connection getConnection(String str, String str2) throws SQLException {
        Properties properties = new Properties();
        if (str != null) {
            properties.setProperty(NonRegisteringDriver.USER_PROPERTY_KEY, str);
        }
        if (str2 != null) {
            properties.setProperty(NonRegisteringDriver.PASSWORD_PROPERTY_KEY, str2);
        }
        exposeAsProperties(properties);
        return getConnection(properties);
    }

    public Connection getConnection(Properties properties) throws SQLException {
        String string;
        if (!this.explicitUrl) {
            StringBuilder sb = new StringBuilder("jdbc:mysql://");
            String str = this.hostName;
            if (str != null) {
                sb.append(str);
            }
            sb.append(":");
            sb.append(this.port);
            sb.append("/");
            String str2 = this.databaseName;
            if (str2 != null) {
                sb.append(str2);
            }
            string = sb.toString();
        } else {
            string = this.url;
        }
        Properties url = mysqlDriver.parseURL(string, null);
        if (url != null) {
            url.remove(NonRegisteringDriver.DBNAME_PROPERTY_KEY);
            url.remove(NonRegisteringDriver.HOST_PROPERTY_KEY);
            url.remove(NonRegisteringDriver.PORT_PROPERTY_KEY);
            for (String str3 : url.keySet()) {
                properties.setProperty(str3, url.getProperty(str3));
            }
            return mysqlDriver.connect(string, properties);
        }
        throw SQLError.createSQLException(Messages.getString("MysqlDataSource.BadUrl", new Object[]{string}), SQLError.SQL_STATE_CONNECTION_FAILURE, (ExceptionInterceptor) null);
    }
}
