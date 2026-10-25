package com.mysql.jdbc.authentication;

import com.mysql.jdbc.AuthenticationPlugin;
import com.mysql.jdbc.Buffer;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.StringUtils;
import com.mysql.jdbc.Util;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class MysqlOldPasswordPlugin implements AuthenticationPlugin {
    private Connection connection;
    private String password = null;

    @Override // com.mysql.jdbc.Extension
    public void destroy() {
        this.password = null;
    }

    @Override // com.mysql.jdbc.AuthenticationPlugin
    public String getProtocolPluginName() {
        return "mysql_old_password";
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
        Buffer buffer2;
        list.clear();
        String str = this.password;
        if (buffer == null || str == null || str.length() == 0) {
            buffer2 = new Buffer(new byte[0]);
        } else {
            buffer2 = new Buffer(StringUtils.getBytes(Util.newCrypt(str, buffer.readString().substring(0, 8), this.connection.getPasswordCharacterEncoding())));
            buffer2.setPosition(buffer2.getBufLength());
            int bufLength = buffer2.getBufLength();
            buffer2.writeByte((byte) 0);
            buffer2.setBufLength(bufLength + 1);
            buffer2.setPosition(0);
        }
        list.add(buffer2);
        return true;
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
