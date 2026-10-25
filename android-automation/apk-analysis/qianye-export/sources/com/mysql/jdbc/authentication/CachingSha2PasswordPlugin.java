package com.mysql.jdbc.authentication;

import com.mysql.jdbc.Buffer;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ExceptionInterceptor;
import com.mysql.jdbc.Messages;
import com.mysql.jdbc.MySQLConnection;
import com.mysql.jdbc.SQLError;
import com.mysql.jdbc.Security;
import com.mysql.jdbc.StringUtils;
import java.io.UnsupportedEncodingException;
import java.security.DigestException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class CachingSha2PasswordPlugin extends Sha256PasswordPlugin {
    public static String PLUGIN_NAME = "caching_sha2_password";
    private AuthStage stage = AuthStage.FAST_AUTH_SEND_SCRAMBLE;

    public enum AuthStage {
        FAST_AUTH_SEND_SCRAMBLE,
        FAST_AUTH_READ_RESULT,
        FAST_AUTH_COMPLETE,
        FULL_AUTH
    }

    @Override // com.mysql.jdbc.authentication.Sha256PasswordPlugin, com.mysql.jdbc.Extension
    public void destroy() {
        this.stage = AuthStage.FAST_AUTH_SEND_SCRAMBLE;
        super.destroy();
    }

    @Override // com.mysql.jdbc.authentication.Sha256PasswordPlugin
    public byte[] encryptPassword() throws SQLException {
        return this.connection.versionMeetsMinimum(8, 0, 5) ? super.encryptPassword() : super.encryptPassword("RSA/ECB/PKCS1Padding");
    }

    @Override // com.mysql.jdbc.authentication.Sha256PasswordPlugin, com.mysql.jdbc.AuthenticationPlugin
    public String getProtocolPluginName() {
        return PLUGIN_NAME;
    }

    @Override // com.mysql.jdbc.authentication.Sha256PasswordPlugin, com.mysql.jdbc.Extension
    public void init(Connection connection, Properties properties) throws SQLException {
        super.init(connection, properties);
        this.stage = AuthStage.FAST_AUTH_SEND_SCRAMBLE;
    }

    @Override // com.mysql.jdbc.authentication.Sha256PasswordPlugin, com.mysql.jdbc.AuthenticationPlugin
    public boolean nextAuthenticationStep(Buffer buffer, List<Buffer> list) throws SQLException {
        list.clear();
        String str = this.password;
        if (str == null || str.length() == 0 || buffer == null) {
            list.add(new Buffer(new byte[]{0}));
        } else {
            AuthStage authStage = this.stage;
            if (authStage == AuthStage.FAST_AUTH_SEND_SCRAMBLE) {
                this.seed = buffer.readString();
                try {
                    list.add(new Buffer(Security.scrambleCachingSha2(StringUtils.getBytes(this.password, this.connection.getPasswordCharacterEncoding()), this.seed.getBytes())));
                    this.stage = AuthStage.FAST_AUTH_READ_RESULT;
                    return true;
                } catch (UnsupportedEncodingException e) {
                    throw SQLError.createSQLException(e.getMessage(), SQLError.SQL_STATE_GENERAL_ERROR, e, (ExceptionInterceptor) null);
                } catch (DigestException e2) {
                    throw SQLError.createSQLException(e2.getMessage(), SQLError.SQL_STATE_GENERAL_ERROR, e2, (ExceptionInterceptor) null);
                }
            }
            if (authStage == AuthStage.FAST_AUTH_READ_RESULT) {
                byte b = buffer.getByteBuffer()[0];
                if (b == 3) {
                    this.stage = AuthStage.FAST_AUTH_COMPLETE;
                    return true;
                }
                if (b != 4) {
                    throw SQLError.createSQLException("Unknown server response after fast auth.", SQLError.SQL_STATE_UNABLE_TO_CONNECT_TO_DATASOURCE, this.connection.getExceptionInterceptor());
                }
                this.stage = AuthStage.FULL_AUTH;
            }
            if (((MySQLConnection) this.connection).getIO().isSSLEstablished()) {
                try {
                    Buffer buffer2 = new Buffer(StringUtils.getBytes(this.password, this.connection.getPasswordCharacterEncoding()));
                    buffer2.setPosition(buffer2.getBufLength());
                    int bufLength = buffer2.getBufLength();
                    buffer2.writeByte((byte) 0);
                    buffer2.setBufLength(bufLength + 1);
                    buffer2.setPosition(0);
                    list.add(buffer2);
                } catch (UnsupportedEncodingException unused) {
                    throw SQLError.createSQLException(Messages.getString("Sha256PasswordPlugin.3", new Object[]{this.connection.getPasswordCharacterEncoding()}), SQLError.SQL_STATE_GENERAL_ERROR, (ExceptionInterceptor) null);
                }
            } else if (this.connection.getServerRSAPublicKeyFile() != null) {
                list.add(new Buffer(encryptPassword()));
            } else {
                if (!this.connection.getAllowPublicKeyRetrieval()) {
                    throw SQLError.createSQLException(Messages.getString("Sha256PasswordPlugin.2"), SQLError.SQL_STATE_UNABLE_TO_CONNECT_TO_DATASOURCE, this.connection.getExceptionInterceptor());
                }
                if (!this.publicKeyRequested || buffer.getBufLength() <= 20) {
                    list.add(new Buffer(new byte[]{2}));
                    this.publicKeyRequested = true;
                } else {
                    this.publicKeyString = buffer.readString();
                    list.add(new Buffer(encryptPassword()));
                    this.publicKeyRequested = false;
                }
            }
        }
        return true;
    }

    @Override // com.mysql.jdbc.authentication.Sha256PasswordPlugin, com.mysql.jdbc.AuthenticationPlugin
    public void reset() {
        this.stage = AuthStage.FAST_AUTH_SEND_SCRAMBLE;
    }
}
