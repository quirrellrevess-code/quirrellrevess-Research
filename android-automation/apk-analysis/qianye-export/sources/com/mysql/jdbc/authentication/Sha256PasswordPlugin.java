package com.mysql.jdbc.authentication;

import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.AuthenticationPlugin;
import com.mysql.jdbc.Buffer;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ExceptionInterceptor;
import com.mysql.jdbc.ExportControlled;
import com.mysql.jdbc.Messages;
import com.mysql.jdbc.MySQLConnection;
import com.mysql.jdbc.SQLError;
import com.mysql.jdbc.Security;
import com.mysql.jdbc.StringUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class Sha256PasswordPlugin implements AuthenticationPlugin {
    public static String PLUGIN_NAME = "sha256_password";
    public Connection connection;
    public String password = null;
    public String seed = null;
    public boolean publicKeyRequested = false;
    public String publicKeyString = null;

    private static String readRSAKey(Connection connection, String str) throws Throwable {
        byte[] bArr = new byte[2048];
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(new File(str).getCanonicalPath()));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i = bufferedInputStream2.read(bArr);
                        if (i == -1) {
                            String string = sb.toString();
                            try {
                                bufferedInputStream2.close();
                                return string;
                            } catch (Exception e) {
                                throw SQLError.createSQLException(Messages.getString("Sha256PasswordPlugin.1"), SQLError.SQL_STATE_GENERAL_ERROR, e, connection.getExceptionInterceptor());
                            }
                        }
                        sb.append(StringUtils.toAsciiString(bArr, 0, i));
                    }
                } catch (IOException e2) {
                    e = e2;
                    if (connection.getParanoid()) {
                        throw SQLError.createSQLException(Messages.getString("Sha256PasswordPlugin.0", new Object[]{BuildConfig.FLAVOR}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, connection.getExceptionInterceptor());
                    }
                    throw SQLError.createSQLException(Messages.getString("Sha256PasswordPlugin.0", new Object[]{"'" + str + "'"}), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, e, connection.getExceptionInterceptor());
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e3) {
                            throw SQLError.createSQLException(Messages.getString("Sha256PasswordPlugin.1"), SQLError.SQL_STATE_GENERAL_ERROR, e3, connection.getExceptionInterceptor());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e4) {
            e = e4;
        }
    }

    @Override // com.mysql.jdbc.Extension
    public void destroy() {
        this.password = null;
        this.seed = null;
        this.publicKeyRequested = false;
    }

    public byte[] encryptPassword() throws SQLException {
        return encryptPassword("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
    }

    @Override // com.mysql.jdbc.AuthenticationPlugin
    public String getProtocolPluginName() {
        return PLUGIN_NAME;
    }

    @Override // com.mysql.jdbc.Extension
    public void init(Connection connection, Properties properties) throws SQLException {
        this.connection = connection;
        String serverRSAPublicKeyFile = connection.getServerRSAPublicKeyFile();
        if (serverRSAPublicKeyFile != null) {
            this.publicKeyString = readRSAKey(this.connection, serverRSAPublicKeyFile);
        }
    }

    @Override // com.mysql.jdbc.AuthenticationPlugin
    public boolean isReusable() {
        return true;
    }

    @Override // com.mysql.jdbc.AuthenticationPlugin
    public boolean nextAuthenticationStep(Buffer buffer, List<Buffer> list) throws SQLException {
        list.clear();
        String str = this.password;
        if (str == null || str.length() == 0 || buffer == null) {
            list.add(new Buffer(new byte[]{0}));
        } else if (((MySQLConnection) this.connection).getIO().isSSLEstablished()) {
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
            this.seed = buffer.readString();
            list.add(new Buffer(encryptPassword()));
        } else {
            if (!this.connection.getAllowPublicKeyRetrieval()) {
                throw SQLError.createSQLException(Messages.getString("Sha256PasswordPlugin.2"), SQLError.SQL_STATE_UNABLE_TO_CONNECT_TO_DATASOURCE, this.connection.getExceptionInterceptor());
            }
            if (!this.publicKeyRequested || buffer.getBufLength() <= 20) {
                this.seed = buffer.readString();
                list.add(new Buffer(new byte[]{1}));
                this.publicKeyRequested = true;
            } else {
                this.publicKeyString = buffer.readString();
                list.add(new Buffer(encryptPassword()));
                this.publicKeyRequested = false;
            }
        }
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

    public byte[] encryptPassword(String str) throws SQLException {
        try {
            String str2 = this.password;
            byte[] bytesNullTerminated = str2 != null ? StringUtils.getBytesNullTerminated(str2, this.connection.getPasswordCharacterEncoding()) : new byte[]{0};
            byte[] bArr = new byte[bytesNullTerminated.length];
            Security.xorString(bytesNullTerminated, bArr, this.seed.getBytes(), bytesNullTerminated.length);
            return ExportControlled.encryptWithRSAPublicKey(bArr, ExportControlled.decodeRSAPublicKey(this.publicKeyString, this.connection.getExceptionInterceptor()), str, this.connection.getExceptionInterceptor());
        } catch (UnsupportedEncodingException unused) {
            throw SQLError.createSQLException(Messages.getString("Sha256PasswordPlugin.3", new Object[]{this.connection.getPasswordCharacterEncoding()}), SQLError.SQL_STATE_GENERAL_ERROR, (ExceptionInterceptor) null);
        }
    }
}
