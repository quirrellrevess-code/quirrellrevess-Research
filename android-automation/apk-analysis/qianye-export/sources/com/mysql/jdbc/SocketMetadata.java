package com.mysql.jdbc;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;

/* JADX INFO: loaded from: classes.dex */
public interface SocketMetadata {

    public static class Helper {
        public static final String IS_LOCAL_HOSTNAME_REPLACEMENT_PROPERTY_NAME = "com.mysql.jdbc.test.isLocalHostnameReplacement";

        private static String findProcessHost(long j, java.sql.Statement statement) throws SQLException {
            ResultSet resultSetExecuteQuery = statement.executeQuery("SHOW PROCESSLIST");
            while (resultSetExecuteQuery.next()) {
                if (j == resultSetExecuteQuery.getLong(1)) {
                    return resultSetExecuteQuery.getString(3);
                }
            }
            return null;
        }

        public static boolean isLocallyConnected(ConnectionImpl connectionImpl) throws SQLException {
            String property;
            long id = connectionImpl.getId();
            java.sql.Statement metadataSafeStatement = connectionImpl.getMetadataSafeStatement();
            boolean z = true;
            if (System.getProperty(IS_LOCAL_HOSTNAME_REPLACEMENT_PROPERTY_NAME) != null) {
                property = System.getProperty(IS_LOCAL_HOSTNAME_REPLACEMENT_PROPERTY_NAME);
            } else if (connectionImpl.getProperties().getProperty(IS_LOCAL_HOSTNAME_REPLACEMENT_PROPERTY_NAME) != null) {
                property = connectionImpl.getProperties().getProperty(IS_LOCAL_HOSTNAME_REPLACEMENT_PROPERTY_NAME);
            } else {
                try {
                    String strFindProcessHost = findProcessHost(id, metadataSafeStatement);
                    if (strFindProcessHost == null) {
                        connectionImpl.getLog().logWarn(String.format("Connection id %d not found in \"SHOW PROCESSLIST\", assuming 32-bit overflow, using SELECT CONNECTION_ID() instead", Long.valueOf(id)));
                        ResultSet resultSetExecuteQuery = metadataSafeStatement.executeQuery("SELECT CONNECTION_ID()");
                        if (resultSetExecuteQuery.next()) {
                            id = resultSetExecuteQuery.getLong(1);
                            strFindProcessHost = findProcessHost(id, metadataSafeStatement);
                        } else {
                            connectionImpl.getLog().logError("No rows returned for statement \"SELECT CONNECTION_ID()\", local connection check will most likely be incorrect");
                        }
                    }
                    metadataSafeStatement.close();
                    property = strFindProcessHost;
                } catch (Throwable th) {
                    metadataSafeStatement.close();
                    throw th;
                }
            }
            if (property == null) {
                connectionImpl.getLog().logWarn(String.format("Cannot find process listing for connection %d in SHOW PROCESSLIST output, unable to determine if locally connected", Long.valueOf(id)));
                return false;
            }
            connectionImpl.getLog().logDebug(String.format("Using 'host' value of '%s' to determine locality of connection", property));
            int iLastIndexOf = property.lastIndexOf(":");
            if (iLastIndexOf == -1) {
                connectionImpl.getLog().logWarn(String.format("No port number present in 'host' from SHOW PROCESSLIST '%s', unable to determine whether locally connected", property));
                return false;
            }
            String strSubstring = property.substring(0, iLastIndexOf);
            try {
                InetAddress[] allByName = InetAddress.getAllByName(strSubstring);
                SocketAddress remoteSocketAddress = connectionImpl.getIO().mysqlConnection.getRemoteSocketAddress();
                if (!(remoteSocketAddress instanceof InetSocketAddress)) {
                    connectionImpl.getLog().logDebug(String.format("Remote socket address %s is not an inet socket address", remoteSocketAddress));
                    return false;
                }
                InetAddress address = ((InetSocketAddress) remoteSocketAddress).getAddress();
                for (InetAddress inetAddress : allByName) {
                    if (inetAddress.equals(address)) {
                        connectionImpl.getLog().logDebug(String.format("Locally connected - HostAddress(%s).equals(whereIconnectedTo({%s})", inetAddress, address));
                        return z;
                    }
                    connectionImpl.getLog().logDebug(String.format("Attempted locally connected check failed - ! HostAddress(%s).equals(whereIconnectedTo(%s)", inetAddress, address));
                }
                z = false;
                return z;
            } catch (UnknownHostException e) {
                connectionImpl.getLog().logWarn(Messages.getString("Connection.CantDetectLocalConnect", new Object[]{strSubstring}), e);
                return false;
            }
        }
    }

    boolean isLocallyConnected(ConnectionImpl connectionImpl) throws SQLException;
}
