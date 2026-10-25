package com.mysql.jdbc;

import java.sql.SQLException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface AuthenticationPlugin extends Extension {
    String getProtocolPluginName();

    boolean isReusable();

    boolean nextAuthenticationStep(Buffer buffer, List<Buffer> list) throws SQLException;

    boolean requiresConfidentiality();

    void reset();

    void setAuthenticationParameters(String str, String str2);
}
