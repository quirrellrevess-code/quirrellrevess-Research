package com.mysql.jdbc.authentication;

import com.mysql.jdbc.AuthenticationPlugin;
import com.mysql.jdbc.Buffer;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ExceptionInterceptor;
import com.mysql.jdbc.Messages;
import com.mysql.jdbc.SQLError;
import com.mysql.jdbc.Security;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class MysqlNativePasswordPlugin implements AuthenticationPlugin {
    private Connection connection;
    private String password = null;

    @Override // com.mysql.jdbc.Extension
    public void destroy() {
        this.password = null;
    }

    @Override // com.mysql.jdbc.AuthenticationPlugin
    public String getProtocolPluginName() {
        return "mysql_native_password";
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
        try {
            list.clear();
            String str = this.password;
            list.add((buffer == null || str == null || str.length() == 0) ? new Buffer(new byte[0]) : new Buffer(Security.scramble411(str, buffer.readString(), this.connection.getPasswordCharacterEncoding())));
            return true;
        } catch (UnsupportedEncodingException unused) {
            throw SQLError.createSQLException(Messages.getString("MysqlNativePasswordPlugin.1", new Object[]{this.connection.getPasswordCharacterEncoding()}), SQLError.SQL_STATE_GENERAL_ERROR, (ExceptionInterceptor) null);
        } catch (NoSuchAlgorithmException unused2) {
            throw SQLError.createSQLException(Messages.getString("MysqlIO.91") + Messages.getString("MysqlIO.92"), SQLError.SQL_STATE_GENERAL_ERROR, (ExceptionInterceptor) null);
        }
    }

    @Override // com.mysql.jdbc.AuthenticationPlugin
    public boolean requiresConfidentiality() {
        return false;
    }

    @Override // com.mysql.jdbc.AuthenticationPlugin
    public void reset() {
    }

    @Override // com.mysql.jdbc.AuthenticationPlugin
    public void setAuthenticationParameters(String str, String str2) {
        this.password = str2;
    }
}
