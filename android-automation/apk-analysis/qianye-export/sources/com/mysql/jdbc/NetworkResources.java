package com.mysql.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/* JADX INFO: loaded from: classes.dex */
public class NetworkResources {
    private final Socket mysqlConnection;
    private final InputStream mysqlInput;
    private final OutputStream mysqlOutput;

    public NetworkResources(Socket socket, InputStream inputStream, OutputStream outputStream) {
        this.mysqlConnection = socket;
        this.mysqlInput = inputStream;
        this.mysqlOutput = outputStream;
    }

    public final void forceClose() {
        try {
            try {
                InputStream inputStream = this.mysqlInput;
                if (inputStream != null) {
                    inputStream.close();
                }
                Socket socket = this.mysqlConnection;
                if (socket != null && !socket.isClosed() && !this.mysqlConnection.isInputShutdown()) {
                    this.mysqlConnection.shutdownInput();
                }
            } catch (Throwable th) {
                Socket socket2 = this.mysqlConnection;
                if (socket2 != null && !socket2.isClosed() && !this.mysqlConnection.isInputShutdown()) {
                    try {
                        this.mysqlConnection.shutdownInput();
                    } catch (UnsupportedOperationException unused) {
                    }
                }
                throw th;
            }
        } catch (IOException | UnsupportedOperationException unused2) {
        }
        try {
            try {
                OutputStream outputStream = this.mysqlOutput;
                if (outputStream != null) {
                    outputStream.close();
                }
                Socket socket3 = this.mysqlConnection;
                if (socket3 != null && !socket3.isClosed() && !this.mysqlConnection.isOutputShutdown()) {
                    this.mysqlConnection.shutdownOutput();
                }
            } catch (Throwable th2) {
                Socket socket4 = this.mysqlConnection;
                if (socket4 != null && !socket4.isClosed() && !this.mysqlConnection.isOutputShutdown()) {
                    try {
                        this.mysqlConnection.shutdownOutput();
                    } catch (UnsupportedOperationException unused3) {
                    }
                }
                throw th2;
            }
        } catch (IOException | UnsupportedOperationException unused4) {
        }
        try {
            Socket socket5 = this.mysqlConnection;
            if (socket5 != null) {
                socket5.close();
            }
        } catch (IOException unused5) {
        }
    }
}
