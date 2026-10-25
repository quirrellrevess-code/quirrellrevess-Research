package com.mysql.jdbc;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class StandardSocketFactory implements SocketFactory, SocketMetadata {
    public static final String TCP_KEEP_ALIVE_DEFAULT_VALUE = "true";
    public static final String TCP_KEEP_ALIVE_PROPERTY_NAME = "tcpKeepAlive";
    public static final String TCP_NO_DELAY_DEFAULT_VALUE = "true";
    public static final String TCP_NO_DELAY_PROPERTY_NAME = "tcpNoDelay";
    public static final String TCP_RCV_BUF_DEFAULT_VALUE = "0";
    public static final String TCP_RCV_BUF_PROPERTY_NAME = "tcpRcvBuf";
    public static final String TCP_SND_BUF_DEFAULT_VALUE = "0";
    public static final String TCP_SND_BUF_PROPERTY_NAME = "tcpSndBuf";
    public static final String TCP_TRAFFIC_CLASS_DEFAULT_VALUE = "0";
    public static final String TCP_TRAFFIC_CLASS_PROPERTY_NAME = "tcpTrafficClass";
    public String host = null;
    public int port = 3306;
    public Socket rawSocket = null;
    public int loginTimeoutCountdown = DriverManager.getLoginTimeout() * 1000;
    public long loginTimeoutCheckTimestamp = System.currentTimeMillis();
    public int socketTimeoutBackup = 0;

    private void configureSocket(Socket socket, Properties properties) throws IOException {
        socket.setTcpNoDelay(Boolean.valueOf(properties.getProperty(TCP_NO_DELAY_PROPERTY_NAME, "true")).booleanValue());
        String property = properties.getProperty(TCP_KEEP_ALIVE_PROPERTY_NAME, "true");
        if (property != null && property.length() > 0) {
            socket.setKeepAlive(Boolean.valueOf(property).booleanValue());
        }
        int i = Integer.parseInt(properties.getProperty(TCP_RCV_BUF_PROPERTY_NAME, "0"));
        if (i > 0) {
            socket.setReceiveBufferSize(i);
        }
        int i2 = Integer.parseInt(properties.getProperty(TCP_SND_BUF_PROPERTY_NAME, "0"));
        if (i2 > 0) {
            socket.setSendBufferSize(i2);
        }
        int i3 = Integer.parseInt(properties.getProperty(TCP_TRAFFIC_CLASS_PROPERTY_NAME, "0"));
        if (i3 > 0) {
            socket.setTrafficClass(i3);
        }
    }

    @Override // com.mysql.jdbc.SocketFactory
    public Socket afterHandshake() throws IOException {
        resetLoginTimeCountdown();
        this.rawSocket.setSoTimeout(this.socketTimeoutBackup);
        return this.rawSocket;
    }

    @Override // com.mysql.jdbc.SocketFactory
    public Socket beforeHandshake() throws IOException {
        resetLoginTimeCountdown();
        int soTimeout = this.rawSocket.getSoTimeout();
        this.socketTimeoutBackup = soTimeout;
        this.rawSocket.setSoTimeout(getRealTimeout(soTimeout));
        return this.rawSocket;
    }

    @Override // com.mysql.jdbc.SocketFactory
    public Socket connect(String str, int i, Properties properties) throws IOException {
        int i2;
        if (properties != null) {
            this.host = str;
            this.port = i;
            String property = properties.getProperty("localSocketAddress");
            InetSocketAddress inetSocketAddress = (property == null || property.length() <= 0) ? null : new InetSocketAddress(InetAddress.getByName(property), 0);
            String property2 = properties.getProperty("connectTimeout");
            if (property2 != null) {
                try {
                    i2 = Integer.parseInt(property2);
                } catch (NumberFormatException unused) {
                    throw new SocketException("Illegal value '" + property2 + "' for connectTimeout");
                }
            } else {
                i2 = 0;
            }
            String str2 = this.host;
            if (str2 != null) {
                InetAddress[] allByName = InetAddress.getAllByName(str2);
                if (allByName.length == 0) {
                    throw new SocketException("No addresses for host");
                }
                SocketException e = null;
                for (InetAddress inetAddress : allByName) {
                    try {
                        Socket socketCreateSocket = createSocket(properties);
                        this.rawSocket = socketCreateSocket;
                        configureSocket(socketCreateSocket, properties);
                        InetSocketAddress inetSocketAddress2 = new InetSocketAddress(inetAddress, this.port);
                        if (inetSocketAddress != null) {
                            this.rawSocket.bind(inetSocketAddress);
                        }
                        this.rawSocket.connect(inetSocketAddress2, getRealTimeout(i2));
                        break;
                    } catch (SocketException e2) {
                        e = e2;
                        resetLoginTimeCountdown();
                        this.rawSocket = null;
                    }
                }
                if (this.rawSocket == null && e != null) {
                    throw e;
                }
                resetLoginTimeCountdown();
                return this.rawSocket;
            }
        }
        throw new SocketException("Unable to create socket");
    }

    public Socket createSocket(Properties properties) {
        return new Socket();
    }

    public int getRealTimeout(int i) {
        int i2 = this.loginTimeoutCountdown;
        return (i2 <= 0 || (i != 0 && i <= i2)) ? i : i2;
    }

    @Override // com.mysql.jdbc.SocketMetadata
    public boolean isLocallyConnected(ConnectionImpl connectionImpl) throws SQLException {
        return SocketMetadata.Helper.isLocallyConnected(connectionImpl);
    }

    public void resetLoginTimeCountdown() throws SocketException {
        if (this.loginTimeoutCountdown > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            int i = (int) (((long) this.loginTimeoutCountdown) - (jCurrentTimeMillis - this.loginTimeoutCheckTimestamp));
            this.loginTimeoutCountdown = i;
            if (i <= 0) {
                throw new SocketException(Messages.getString("Connection.LoginTimeout"));
            }
            this.loginTimeoutCheckTimestamp = jCurrentTimeMillis;
        }
    }
}
