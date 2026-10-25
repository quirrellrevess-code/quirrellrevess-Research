package com.mysql.jdbc.authentication;

import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.AuthenticationPlugin;
import com.mysql.jdbc.Buffer;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ExceptionInterceptor;
import com.mysql.jdbc.Messages;
import com.mysql.jdbc.SQLError;
import com.mysql.jdbc.StringUtils;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class MysqlClearPasswordPlugin implements AuthenticationPlugin {
    private Connection connection;
    private String password = null;

    @Override // com.mysql.jdbc.Extension
    public void destroy() {
        this.password = null;
    }

    @Override // com.mysql.jdbc.AuthenticationPlugin
    public String getProtocolPluginName() {
        return "mysql_clear_password";
    }

    @Override // com.mysql.jdbc.Extension
    public void init(Connection connection, Properties properties) throws SQLException {
        this.connection = connection;
    }

    @Override // com.mysql.jdbc.AuthenticationPlugin
    public boolean isReusable() {
        return true;
    }

    @Override // com.mysql.jdbc.AuthenticationPlugin
    public boolean nextAuthenticationStep(Buffer buffer, List<Buffer> list) throws SQLException {
        list.clear();
        try {
            String passwordCharacterEncoding = this.connection.versionMeetsMinimum(5, 7, 6) ? this.connection.getPasswordCharacterEncoding() : "UTF-8";
            String str = this.password;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            Buffer buffer2 = new Buffer(StringUtils.getBytes(str, passwordCharacterEncoding));
            buffer2.setPosition(buffer2.getBufLength());
            int bufLength = buffer2.getBufLength();
            buffer2.writeByte((byte) 0);
            buffer2.setBufLength(bufLength + 1);
            buffer2.setPosition(0);
            list.add(buffer2);
            return true;
        } catch (UnsupportedEncodingException unused) {
            throw SQLError.createSQLException(Messages.getString("MysqlClearPasswordPlugin.1", new Object[]{this.connection.getPasswordCharacterEncoding()}), SQLError.SQL_STATE_GENERAL_ERROR, (ExceptionInterceptor) null);
        }
    }

    @Override // com.mysql.jdbc.AuthenticationPlugin
    public boolean requiresConfidentiality() {
        return true;
    }

    @Override // com.mysql.jdbc.AuthenticationPlugin
    public void reset() {
    }

    @Override // com.mysql.jdbc.AuthenticationPlugin
    public void setAuthenticationParameters(String str, String str2) {
        this.password = str2;
    }
}
