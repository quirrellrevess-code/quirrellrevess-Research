package com.sun.mail.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public class SocketFetcher {
    private SocketFetcher() {
    }

    private static void configureSSLSocket(Socket socket, Properties properties, String str) {
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            String property = properties.getProperty(String.valueOf(str) + ".ssl.protocols", null);
            if (property != null) {
                sSLSocket.setEnabledProtocols(stringArray(property));
            } else {
                sSLSocket.setEnabledProtocols(new String[]{"TLSv1"});
            }
            String property2 = properties.getProperty(String.valueOf(str) + ".ssl.ciphersuites", null);
            if (property2 != null) {
                sSLSocket.setEnabledCipherSuites(stringArray(property2));
            }
        }
    }

    private static Socket createSocket(InetAddress inetAddress, int i, String str, int i2, int i3, SocketFactory socketFactory, boolean z) throws IOException {
        Socket socketCreateSocket;
        if (socketFactory != null) {
            socketCreateSocket = socketFactory.createSocket();
        } else {
            socketCreateSocket = z ? SSLSocketFactory.getDefault().createSocket() : new Socket();
        }
        if (inetAddress != null) {
            socketCreateSocket.bind(new InetSocketAddress(inetAddress, i));
        }
        if (i3 >= 0) {
            socketCreateSocket.connect(new InetSocketAddress(str, i2), i3);
        } else {
            socketCreateSocket.connect(new InetSocketAddress(str, i2));
        }
        return socketCreateSocket;
    }

    private static ClassLoader getContextClassLoader() {
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction() { // from class: com.sun.mail.util.SocketFetcher.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                try {
                    return Thread.currentThread().getContextClassLoader();
                } catch (SecurityException unused) {
                    return null;
                }
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:51:0x0114  */
    /* JADX WARN: Code duplicated, block: B:53:0x0118  */
    /* JADX WARN: Code duplicated, block: B:55:0x0123  */
    /* JADX WARN: Code duplicated, block: B:58:0x012a  */
    /* JADX WARN: Code duplicated, block: B:60:0x012d  */
    /* JADX WARN: Code duplicated, block: B:64:0x0161  */
    /* JADX WARN: Code duplicated, block: B:70:0x0179  */
    /* JADX WARN: Code duplicated, block: B:78:0x0171 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:60:0x012d, please report this as an issue */
    public static Socket getSocket(String str, int i, Properties properties, String str2, boolean z) throws IOException {
        int i2;
        int i3;
        Exception exc;
        Socket socketCreateSocket;
        int i4;
        Throwable targetException;
        int i5;
        String str3 = str2 == null ? "socket" : str2;
        Properties properties2 = properties == null ? new Properties() : properties;
        String property = properties2.getProperty(String.valueOf(str3) + ".connectiontimeout", null);
        int i6 = -1;
        if (property != null) {
            try {
                i2 = Integer.parseInt(property);
            } catch (NumberFormatException unused) {
                i2 = -1;
            }
        } else {
            i2 = -1;
        }
        String property2 = properties2.getProperty(String.valueOf(str3) + ".timeout", null);
        String property3 = properties2.getProperty(String.valueOf(str3) + ".localaddress", null);
        InetAddress byName = property3 != null ? InetAddress.getByName(property3) : null;
        String property4 = properties2.getProperty(String.valueOf(str3) + ".localport", null);
        if (property4 != null) {
            try {
                i3 = Integer.parseInt(property4);
            } catch (NumberFormatException unused2) {
                i3 = 0;
            }
        } else {
            i3 = 0;
        }
        String property5 = properties2.getProperty(String.valueOf(str3) + ".socketFactory.fallback", null);
        boolean z2 = property5 == null || !property5.equalsIgnoreCase("false");
        String property6 = properties2.getProperty(String.valueOf(str3) + ".socketFactory.class", null);
        try {
            try {
                SocketFactory socketFactory = getSocketFactory(property6);
                if (socketFactory != null) {
                    String property7 = properties2.getProperty(String.valueOf(str3) + ".socketFactory.port", null);
                    if (property7 != null) {
                        try {
                            i5 = Integer.parseInt(property7);
                        } catch (NumberFormatException unused3) {
                            i5 = -1;
                        } catch (Exception e) {
                            exc = e;
                            i4 = -1;
                            if (!z2) {
                                if (exc instanceof InvocationTargetException) {
                                    targetException = ((InvocationTargetException) exc).getTargetException();
                                    if (targetException instanceof Exception) {
                                        exc = (Exception) targetException;
                                    }
                                }
                                if (exc instanceof IOException) {
                                    throw ((IOException) exc);
                                }
                                IOException iOException = new IOException("Couldn't connect using \"" + property6 + "\" socket factory to host, port: " + str + ", " + i4 + "; Exception: " + exc);
                                iOException.initCause(exc);
                                throw iOException;
                            }
                            socketCreateSocket = null;
                            if (socketCreateSocket == null) {
                                socketCreateSocket = createSocket(byName, i3, str, i, i2, null, z);
                            }
                            if (property2 != null) {
                                try {
                                    i6 = Integer.parseInt(property2);
                                } catch (NumberFormatException unused4) {
                                }
                            }
                            if (i6 >= 0) {
                                socketCreateSocket.setSoTimeout(i6);
                            }
                            configureSSLSocket(socketCreateSocket, properties2, str3);
                            return socketCreateSocket;
                        }
                    } else {
                        i5 = -1;
                    }
                    int i7 = i5 == -1 ? i : i5;
                    property6 = property6;
                    try {
                        socketCreateSocket = createSocket(byName, i3, str, i7, i2, socketFactory, z);
                    } catch (Exception e2) {
                        exc = e2;
                        i4 = i7;
                        if (!z2) {
                            if (exc instanceof InvocationTargetException) {
                                targetException = ((InvocationTargetException) exc).getTargetException();
                                if (targetException instanceof Exception) {
                                    exc = (Exception) targetException;
                                }
                            }
                            if (exc instanceof IOException) {
                                throw ((IOException) exc);
                            }
                            IOException iOException2 = new IOException("Couldn't connect using \"" + property6 + "\" socket factory to host, port: " + str + ", " + i4 + "; Exception: " + exc);
                            iOException2.initCause(exc);
                            throw iOException2;
                        }
                        socketCreateSocket = null;
                    }
                } else {
                    socketCreateSocket = null;
                }
            } catch (SocketTimeoutException e3) {
                throw e3;
            }
        } catch (Exception e4) {
            exc = e4;
        }
        if (socketCreateSocket == null) {
            socketCreateSocket = createSocket(byName, i3, str, i, i2, null, z);
        }
        if (property2 != null) {
            i6 = Integer.parseInt(property2);
        }
        if (i6 >= 0) {
            socketCreateSocket.setSoTimeout(i6);
        }
        configureSSLSocket(socketCreateSocket, properties2, str3);
        return socketCreateSocket;
    }

    private static SocketFactory getSocketFactory(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Class<?> clsLoadClass = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        ClassLoader contextClassLoader = getContextClassLoader();
        if (contextClassLoader != null) {
            try {
                clsLoadClass = contextClassLoader.loadClass(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        if (clsLoadClass == null) {
            clsLoadClass = Class.forName(str);
        }
        return (SocketFactory) clsLoadClass.getMethod("getDefault", new Class[0]).invoke(new Object(), new Object[0]);
    }

    public static Socket startTLS(Socket socket) throws IOException {
        return startTLS(socket, new Properties(), "socket");
    }

    private static String[] stringArray(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static Socket startTLS(Socket socket, Properties properties, String str) throws IOException {
        String hostName = socket.getInetAddress().getHostName();
        int port = socket.getPort();
        try {
            SocketFactory socketFactory = getSocketFactory(properties.getProperty(String.valueOf(str) + ".socketFactory.class", null));
            Socket socketCreateSocket = ((socketFactory == null || !(socketFactory instanceof SSLSocketFactory)) ? (SSLSocketFactory) SSLSocketFactory.getDefault() : (SSLSocketFactory) socketFactory).createSocket(socket, hostName, port, true);
            configureSSLSocket(socketCreateSocket, properties, str);
            return socketCreateSocket;
        } catch (Exception e) {
            e = e;
            if (e instanceof InvocationTargetException) {
                Throwable targetException = ((InvocationTargetException) e).getTargetException();
                if (targetException instanceof Exception) {
                    e = (Exception) targetException;
                }
            }
            if (e instanceof IOException) {
                throw ((IOException) e);
            }
            IOException iOException = new IOException("Exception in startTLS: host " + hostName + ", port " + port + "; Exception: " + e);
            iOException.initCause(e);
            throw iOException;
        }
    }

    public static Socket getSocket(String str, int i, Properties properties, String str2) throws IOException {
        return getSocket(str, i, properties, str2, false);
    }
}
