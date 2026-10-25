package com.mysql.jdbc;

import java.io.IOException;
import java.net.Socket;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public interface SocketFactory {
    Socket afterHandshake() throws IOException;

    Socket beforeHandshake() throws IOException;

    Socket connect(String str, int i, Properties properties) throws IOException;
}
