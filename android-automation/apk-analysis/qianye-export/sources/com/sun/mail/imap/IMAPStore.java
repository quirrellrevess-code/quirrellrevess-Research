package com.sun.mail.imap;

import com.google.android.flexbox.BuildConfig;
import com.sun.mail.iap.BadCommandException;
import com.sun.mail.iap.CommandFailedException;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import com.sun.mail.iap.ResponseHandler;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.imap.protocol.Namespaces;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.mail.AuthenticationFailedException;
import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Quota;
import javax.mail.QuotaAwareStore;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.StoreClosedException;
import javax.mail.URLName;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: loaded from: classes.dex */
public class IMAPStore extends Store implements QuotaAwareStore, ResponseHandler {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int RESPONSE = 1000;
    private int appendBufferSize;
    private String authorizationID;
    private int blksize;
    private volatile boolean connected;
    private int defaultPort;
    private boolean disableAuthLogin;
    private boolean disableAuthPlain;
    private boolean enableImapEvents;
    private boolean enableSASL;
    private boolean enableStartTLS;
    private boolean forcePasswordRefresh;
    private String host;
    private boolean isSSL;
    private int minIdleTime;
    private String name;
    private Namespaces namespaces;
    private PrintStream out;
    private String password;
    private ConnectionPool pool;
    private int port;
    private String proxyAuthUser;
    private String[] saslMechanisms;
    private String saslRealm;
    private int statusCacheTimeout;
    private String user;

    public static class ConnectionPool {
        private static final int ABORTING = 2;
        private static final int IDLE = 1;
        private static final int RUNNING = 0;
        private Vector folders;
        private IMAPProtocol idleProtocol;
        private long lastTimePruned;
        private Vector authenticatedConnections = new Vector();
        private boolean separateStoreConnection = false;
        private boolean storeConnectionInUse = false;
        private long clientTimeoutInterval = 45000;
        private long serverTimeoutInterval = 1800000;
        private int poolSize = 1;
        private long pruningInterval = 60000;
        private boolean debug = false;
        private int idleState = 0;
    }

    public IMAPStore(Session session, URLName uRLName) {
        this(session, uRLName, "imap", Imgproc.COLOR_COLORCVT_MAX, false);
    }

    private void checkConnected() {
        if (this.connected) {
            return;
        }
        super.setConnected(false);
        throw new IllegalStateException("Not connected");
    }

    private void cleanup() {
        cleanup(false);
    }

    private void emptyConnectionPool(boolean z) {
        synchronized (this.pool) {
            for (int size = this.pool.authenticatedConnections.size() - 1; size >= 0; size--) {
                try {
                    IMAPProtocol iMAPProtocol = (IMAPProtocol) this.pool.authenticatedConnections.elementAt(size);
                    iMAPProtocol.removeResponseHandler(this);
                    if (z) {
                        iMAPProtocol.disconnect();
                    } else {
                        iMAPProtocol.logout();
                    }
                } catch (ProtocolException unused) {
                }
            }
            this.pool.authenticatedConnections.removeAllElements();
        }
        if (this.pool.debug) {
            this.out.println("DEBUG: removed all authenticated connections");
        }
    }

    private synchronized Namespaces getNamespaces() throws MessagingException {
        checkConnected();
        IMAPProtocol storeProtocol = null;
        try {
            if (this.namespaces == null) {
                try {
                    try {
                        storeProtocol = getStoreProtocol();
                        this.namespaces = storeProtocol.namespace();
                        releaseStoreProtocol(storeProtocol);
                        if (storeProtocol == null) {
                            cleanup();
                        }
                    } catch (BadCommandException unused) {
                        releaseStoreProtocol(storeProtocol);
                        if (storeProtocol == null) {
                            cleanup();
                        }
                    } catch (ProtocolException e) {
                        throw new MessagingException(e.getMessage(), e);
                    }
                } catch (ConnectionException e2) {
                    throw new StoreClosedException(this, e2.getMessage());
                }
            }
        } catch (Throwable th) {
            releaseStoreProtocol(storeProtocol);
            if (storeProtocol == null) {
                cleanup();
            }
            throw th;
        }
        return this.namespaces;
    }

    private void login(IMAPProtocol iMAPProtocol, String str, String str2) throws ProtocolException, IOException {
        if (this.enableStartTLS && iMAPProtocol.hasCapability("STARTTLS")) {
            iMAPProtocol.startTLS();
            iMAPProtocol.capability();
        }
        if (iMAPProtocol.isAuthenticated()) {
            return;
        }
        iMAPProtocol.getCapabilities().put("__PRELOGIN__", BuildConfig.FLAVOR);
        String str3 = this.authorizationID;
        if (str3 == null && (str3 = this.proxyAuthUser) == null) {
            str3 = str;
        }
        if (this.enableSASL) {
            iMAPProtocol.sasllogin(this.saslMechanisms, this.saslRealm, str3, str, str2);
        }
        if (!iMAPProtocol.isAuthenticated()) {
            if (iMAPProtocol.hasCapability("AUTH=PLAIN") && !this.disableAuthPlain) {
                iMAPProtocol.authplain(str3, str, str2);
            } else if ((iMAPProtocol.hasCapability("AUTH-LOGIN") || iMAPProtocol.hasCapability("AUTH=LOGIN")) && !this.disableAuthLogin) {
                iMAPProtocol.authlogin(str, str2);
            } else {
                if (iMAPProtocol.hasCapability("LOGINDISABLED")) {
                    throw new ProtocolException("No login methods supported!");
                }
                iMAPProtocol.login(str, str2);
            }
        }
        String str4 = this.proxyAuthUser;
        if (str4 != null) {
            iMAPProtocol.proxyauth(str4);
        }
        if (iMAPProtocol.hasCapability("__PRELOGIN__")) {
            try {
                iMAPProtocol.capability();
            } catch (ConnectionException e) {
                throw e;
            } catch (ProtocolException unused) {
            }
        }
    }

    private Folder[] namespaceToFolders(Namespaces.Namespace[] namespaceArr, String str) {
        int length = namespaceArr.length;
        Folder[] folderArr = new Folder[length];
        for (int i = 0; i < length; i++) {
            String strSubstring = namespaceArr[i].prefix;
            if (str == null) {
                int length2 = strSubstring.length();
                if (length2 > 0) {
                    int i2 = length2 - 1;
                    if (strSubstring.charAt(i2) == namespaceArr[i].delimiter) {
                        strSubstring = strSubstring.substring(0, i2);
                    }
                }
            } else {
                strSubstring = String.valueOf(strSubstring) + str;
            }
            folderArr[i] = new IMAPFolder(strSubstring, namespaceArr[i].delimiter, this, str == null);
        }
        return folderArr;
    }

    private void timeoutConnections() {
        synchronized (this.pool) {
            if (System.currentTimeMillis() - this.pool.lastTimePruned > this.pool.pruningInterval && this.pool.authenticatedConnections.size() > 1) {
                if (this.pool.debug) {
                    this.out.println("DEBUG: checking for connections to prune: " + (System.currentTimeMillis() - this.pool.lastTimePruned));
                    this.out.println("DEBUG: clientTimeoutInterval: " + this.pool.clientTimeoutInterval);
                }
                for (int size = this.pool.authenticatedConnections.size() - 1; size > 0; size--) {
                    IMAPProtocol iMAPProtocol = (IMAPProtocol) this.pool.authenticatedConnections.elementAt(size);
                    if (this.pool.debug) {
                        this.out.println("DEBUG: protocol last used: " + (System.currentTimeMillis() - iMAPProtocol.getTimestamp()));
                    }
                    if (System.currentTimeMillis() - iMAPProtocol.getTimestamp() > this.pool.clientTimeoutInterval) {
                        if (this.pool.debug) {
                            this.out.println("DEBUG: authenticated connection timed out");
                            this.out.println("DEBUG: logging out the connection");
                        }
                        iMAPProtocol.removeResponseHandler(this);
                        this.pool.authenticatedConnections.removeElementAt(size);
                        try {
                            iMAPProtocol.logout();
                        } catch (ProtocolException unused) {
                        }
                    }
                }
                this.pool.lastTimePruned = System.currentTimeMillis();
            }
        }
    }

    private void waitIfIdle() throws ProtocolException {
        while (this.pool.idleState != 0) {
            if (this.pool.idleState == 1) {
                this.pool.idleProtocol.idleAbort();
                this.pool.idleState = 2;
            }
            try {
                this.pool.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public boolean allowReadOnlySelect() {
        String property = this.session.getProperty("mail." + this.name + ".allowreadonlyselect");
        return property != null && property.equalsIgnoreCase("true");
    }

    @Override // javax.mail.Service
    public synchronized void close() throws MessagingException {
        boolean zIsEmpty;
        if (super.isConnected()) {
            try {
                try {
                    synchronized (this.pool) {
                        zIsEmpty = this.pool.authenticatedConnections.isEmpty();
                    }
                    if (zIsEmpty) {
                        if (this.pool.debug) {
                            this.out.println("DEBUG: close() - no connections ");
                        }
                        cleanup();
                        releaseStoreProtocol(null);
                        return;
                    }
                    IMAPProtocol storeProtocol = getStoreProtocol();
                    synchronized (this.pool) {
                        this.pool.authenticatedConnections.removeElement(storeProtocol);
                    }
                    storeProtocol.logout();
                    releaseStoreProtocol(storeProtocol);
                } catch (ProtocolException e) {
                    cleanup();
                    throw new MessagingException(e.getMessage(), e);
                }
            } catch (Throwable th) {
                releaseStoreProtocol(null);
                throw th;
            }
        }
    }

    @Override // javax.mail.Service
    public void finalize() throws Throwable {
        super.finalize();
        close();
    }

    public int getAppendBufferSize() {
        return this.appendBufferSize;
    }

    public boolean getConnectionPoolDebug() {
        return this.pool.debug;
    }

    @Override // javax.mail.Store
    public synchronized Folder getDefaultFolder() throws MessagingException {
        checkConnected();
        return new DefaultFolder(this);
    }

    public int getFetchBlockSize() {
        return this.blksize;
    }

    @Override // javax.mail.Store
    public synchronized Folder getFolder(String str) throws MessagingException {
        checkConnected();
        return new IMAPFolder(str, IMAPFolder.UNKNOWN_SEPARATOR, this);
    }

    public int getMinIdleTime() {
        return this.minIdleTime;
    }

    @Override // javax.mail.Store
    public Folder[] getPersonalNamespaces() throws MessagingException {
        Namespaces.Namespace[] namespaceArr;
        Namespaces namespaces = getNamespaces();
        return (namespaces == null || (namespaceArr = namespaces.personal) == null) ? super.getPersonalNamespaces() : namespaceToFolders(namespaceArr, null);
    }

    public IMAPProtocol getProtocol(IMAPFolder iMAPFolder) throws MessagingException, UnknownHostException {
        IMAPProtocol iMAPProtocol;
        InetAddress byName;
        while (true) {
            IMAPProtocol iMAPProtocol2 = null;
            while (iMAPProtocol2 == null) {
                synchronized (this.pool) {
                    if (this.pool.authenticatedConnections.isEmpty() || (this.pool.authenticatedConnections.size() == 1 && (this.pool.separateStoreConnection || this.pool.storeConnectionInUse))) {
                        if (this.debug) {
                            this.out.println("DEBUG: no connections in the pool, creating a new one");
                        }
                        try {
                            if (this.forcePasswordRefresh) {
                                try {
                                    byName = InetAddress.getByName(this.host);
                                } catch (UnknownHostException unused) {
                                    byName = null;
                                }
                                PasswordAuthentication passwordAuthenticationRequestPasswordAuthentication = this.session.requestPasswordAuthentication(byName, this.port, this.name, null, this.user);
                                if (passwordAuthenticationRequestPasswordAuthentication != null) {
                                    this.user = passwordAuthenticationRequestPasswordAuthentication.getUserName();
                                    this.password = passwordAuthenticationRequestPasswordAuthentication.getPassword();
                                }
                            }
                            iMAPProtocol = new IMAPProtocol(this.name, this.host, this.port, this.session.getDebug(), this.session.getDebugOut(), this.session.getProperties(), this.isSSL);
                            try {
                                login(iMAPProtocol, this.user, this.password);
                            } catch (Exception unused2) {
                                iMAPProtocol2 = iMAPProtocol;
                                if (iMAPProtocol2 != null) {
                                    try {
                                        iMAPProtocol2.disconnect();
                                    } catch (Exception unused3) {
                                    }
                                }
                                iMAPProtocol = null;
                            }
                        } catch (Exception unused4) {
                        }
                        if (iMAPProtocol == null) {
                            throw new MessagingException("connection failure");
                        }
                        iMAPProtocol2 = iMAPProtocol;
                    } else {
                        if (this.debug) {
                            this.out.println("DEBUG: connection available -- size: " + this.pool.authenticatedConnections.size());
                        }
                        iMAPProtocol2 = (IMAPProtocol) this.pool.authenticatedConnections.lastElement();
                        this.pool.authenticatedConnections.removeElement(iMAPProtocol2);
                        if (System.currentTimeMillis() - iMAPProtocol2.getTimestamp() > this.pool.serverTimeoutInterval) {
                            try {
                                try {
                                    iMAPProtocol2.noop();
                                } catch (ProtocolException unused5) {
                                    iMAPProtocol2.removeResponseHandler(this);
                                    iMAPProtocol2.disconnect();
                                }
                            } catch (Throwable unused6) {
                            }
                        }
                        iMAPProtocol2.removeResponseHandler(this);
                    }
                    timeoutConnections();
                    if (iMAPFolder != null) {
                        if (this.pool.folders == null) {
                            this.pool.folders = new Vector();
                        }
                        this.pool.folders.addElement(iMAPFolder);
                    }
                }
            }
            return iMAPProtocol2;
        }
    }

    @Override // javax.mail.QuotaAwareStore
    public synchronized Quota[] getQuota(String str) throws MessagingException {
        Quota[] quotaRoot;
        checkConnected();
        IMAPProtocol storeProtocol = null;
        try {
            try {
                storeProtocol = getStoreProtocol();
                quotaRoot = storeProtocol.getQuotaRoot(str);
                releaseStoreProtocol(storeProtocol);
                if (storeProtocol == null) {
                    cleanup();
                }
            } catch (BadCommandException e) {
                throw new MessagingException("QUOTA not supported", e);
            } catch (ConnectionException e2) {
                throw new StoreClosedException(this, e2.getMessage());
            } catch (ProtocolException e3) {
                throw new MessagingException(e3.getMessage(), e3);
            }
        } catch (Throwable th) {
            releaseStoreProtocol(storeProtocol);
            if (storeProtocol == null) {
                cleanup();
            }
            throw th;
        }
        return quotaRoot;
    }

    public Session getSession() {
        return this.session;
    }

    @Override // javax.mail.Store
    public Folder[] getSharedNamespaces() throws MessagingException {
        Namespaces.Namespace[] namespaceArr;
        Namespaces namespaces = getNamespaces();
        return (namespaces == null || (namespaceArr = namespaces.shared) == null) ? super.getSharedNamespaces() : namespaceToFolders(namespaceArr, null);
    }

    public int getStatusCacheTimeout() {
        return this.statusCacheTimeout;
    }

    public IMAPProtocol getStoreProtocol() throws ProtocolException {
        IMAPProtocol iMAPProtocol;
        IMAPProtocol iMAPProtocol2 = null;
        while (iMAPProtocol2 == null) {
            synchronized (this.pool) {
                waitIfIdle();
                if (this.pool.authenticatedConnections.isEmpty()) {
                    if (this.pool.debug) {
                        this.out.println("DEBUG: getStoreProtocol() - no connections in the pool, creating a new one");
                    }
                    try {
                        iMAPProtocol = new IMAPProtocol(this.name, this.host, this.port, this.session.getDebug(), this.session.getDebugOut(), this.session.getProperties(), this.isSSL);
                        try {
                            login(iMAPProtocol, this.user, this.password);
                        } catch (Exception unused) {
                            iMAPProtocol2 = iMAPProtocol;
                            if (iMAPProtocol2 != null) {
                                try {
                                    iMAPProtocol2.logout();
                                } catch (Exception unused2) {
                                }
                            }
                            iMAPProtocol = null;
                        }
                    } catch (Exception unused3) {
                    }
                    if (iMAPProtocol == null) {
                        throw new ConnectionException("failed to create new store connection");
                    }
                    iMAPProtocol.addResponseHandler(this);
                    this.pool.authenticatedConnections.addElement(iMAPProtocol);
                } else {
                    if (this.pool.debug) {
                        this.out.println("DEBUG: getStoreProtocol() - connection available -- size: " + this.pool.authenticatedConnections.size());
                    }
                    iMAPProtocol = (IMAPProtocol) this.pool.authenticatedConnections.firstElement();
                }
                if (this.pool.storeConnectionInUse) {
                    try {
                        this.pool.wait();
                    } catch (InterruptedException unused4) {
                    }
                    iMAPProtocol2 = null;
                } else {
                    this.pool.storeConnectionInUse = true;
                    if (this.pool.debug) {
                        this.out.println("DEBUG: getStoreProtocol() -- storeConnectionInUse");
                    }
                    iMAPProtocol2 = iMAPProtocol;
                }
                timeoutConnections();
            }
        }
        return iMAPProtocol2;
    }

    @Override // javax.mail.Store
    public Folder[] getUserNamespaces(String str) throws MessagingException {
        Namespaces.Namespace[] namespaceArr;
        Namespaces namespaces = getNamespaces();
        return (namespaces == null || (namespaceArr = namespaces.otherUsers) == null) ? super.getUserNamespaces(str) : namespaceToFolders(namespaceArr, str);
    }

    @Override // com.sun.mail.iap.ResponseHandler
    public void handleResponse(Response response) {
        if (response.isOK() || response.isNO() || response.isBAD() || response.isBYE()) {
            handleResponseCode(response);
        }
        if (response.isBYE()) {
            if (this.debug) {
                this.out.println("DEBUG: IMAPStore connection dead");
            }
            if (this.connected) {
                cleanup(response.isSynthetic());
            }
        }
    }

    public void handleResponseCode(Response response) {
        String rest = response.getRest();
        boolean z = false;
        if (rest.startsWith("[")) {
            int iIndexOf = rest.indexOf(93);
            if (iIndexOf > 0 && rest.substring(0, iIndexOf + 1).equalsIgnoreCase("[ALERT]")) {
                z = true;
            }
            rest = rest.substring(iIndexOf + 1).trim();
        }
        if (z) {
            notifyStoreListeners(1, rest);
        } else {
            if (!response.isUnTagged() || rest.length() <= 0) {
                return;
            }
            notifyStoreListeners(2, rest);
        }
    }

    public synchronized boolean hasCapability(String str) throws MessagingException {
        boolean zHasCapability;
        IMAPProtocol storeProtocol = null;
        try {
            try {
                storeProtocol = getStoreProtocol();
                zHasCapability = storeProtocol.hasCapability(str);
                releaseStoreProtocol(storeProtocol);
            } catch (ProtocolException e) {
                if (storeProtocol == null) {
                    cleanup();
                }
                throw new MessagingException(e.getMessage(), e);
            }
        } catch (Throwable th) {
            releaseStoreProtocol(storeProtocol);
            throw th;
        }
        return zHasCapability;
    }

    public boolean hasSeparateStoreConnection() {
        return this.pool.separateStoreConnection;
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:114:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x005b  */
    /* JADX WARN: Code duplicated, block: B:38:0x006d  */
    /* JADX WARN: Code duplicated, block: B:92:0x00d2  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
    
        if (r5.enableImapEvents == false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
    
        if (r1.isUnTagged() == false) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003f, code lost:
    
        notifyStoreListeners(1000, r1.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void idle() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.idle():void");
    }

    @Override // javax.mail.Service
    public synchronized boolean isConnected() {
        if (!this.connected) {
            super.setConnected(false);
            return false;
        }
        IMAPProtocol storeProtocol = null;
        try {
            try {
                storeProtocol = getStoreProtocol();
                storeProtocol.noop();
            } catch (ProtocolException unused) {
                if (storeProtocol == null) {
                    cleanup();
                }
            }
            releaseStoreProtocol(storeProtocol);
            return super.isConnected();
        } catch (Throwable th) {
            releaseStoreProtocol(storeProtocol);
            throw th;
        }
    }

    public boolean isConnectionPoolFull() {
        boolean z;
        synchronized (this.pool) {
            if (this.pool.debug) {
                this.out.println("DEBUG: current size: " + this.pool.authenticatedConnections.size() + "   pool size: " + this.pool.poolSize);
            }
            z = this.pool.authenticatedConnections.size() >= this.pool.poolSize;
        }
        return z;
    }

    @Override // javax.mail.Service
    public synchronized boolean protocolConnect(String str, int i, String str2, String str3) throws MessagingException {
        boolean zIsEmpty;
        IMAPProtocol iMAPProtocol = null;
        if (str == null || str3 == null || str2 == null) {
            if (this.debug) {
                PrintStream printStream = this.out;
                StringBuilder sb = new StringBuilder("DEBUG: protocolConnect returning false, host=");
                sb.append(str);
                sb.append(", user=");
                sb.append(str2);
                sb.append(", password=");
                sb.append(str3 != null ? "<non-null>" : "<null>");
                printStream.println(sb.toString());
            }
            return false;
        }
        if (i != -1) {
            this.port = i;
        } else {
            String property = this.session.getProperty("mail." + this.name + ".port");
            if (property != null) {
                this.port = Integer.parseInt(property);
            }
        }
        if (this.port == -1) {
            this.port = this.defaultPort;
        }
        try {
            try {
                try {
                    synchronized (this.pool) {
                        zIsEmpty = this.pool.authenticatedConnections.isEmpty();
                    }
                    if (zIsEmpty) {
                        IMAPProtocol iMAPProtocol2 = new IMAPProtocol(this.name, str, this.port, this.session.getDebug(), this.session.getDebugOut(), this.session.getProperties(), this.isSSL);
                        try {
                            if (this.debug) {
                                this.out.println("DEBUG: protocolConnect login, host=" + str + ", user=" + str2 + ", password=<non-null>");
                            }
                            login(iMAPProtocol2, str2, str3);
                            iMAPProtocol2.addResponseHandler(this);
                            this.host = str;
                            this.user = str2;
                            this.password = str3;
                            synchronized (this.pool) {
                                this.pool.authenticatedConnections.addElement(iMAPProtocol2);
                            }
                        } catch (CommandFailedException e) {
                            e = e;
                            iMAPProtocol = iMAPProtocol2;
                            if (iMAPProtocol != null) {
                                iMAPProtocol.disconnect();
                            }
                            throw new AuthenticationFailedException(e.getResponse().getRest());
                        }
                    }
                    this.connected = true;
                    return true;
                } catch (ProtocolException e2) {
                    throw new MessagingException(e2.getMessage(), e2);
                }
            } catch (CommandFailedException e3) {
                e = e3;
            }
        } catch (IOException e4) {
            throw new MessagingException(e4.getMessage(), e4);
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004f A[Catch: all -> 0x005d, TryCatch #1 {, blocks: (B:5:0x0005, B:7:0x000b, B:9:0x001b, B:10:0x0039, B:12:0x003d, B:13:0x0044, B:14:0x0047, B:16:0x004f, B:17:0x0058, B:18:0x005b), top: B:26:0x0005 }] */
    public void releaseProtocol(IMAPFolder iMAPFolder, IMAPProtocol iMAPProtocol) {
        synchronized (this.pool) {
            if (iMAPProtocol != null) {
                if (isConnectionPoolFull()) {
                    if (this.debug) {
                        this.out.println("DEBUG: pool is full, not adding an Authenticated connection");
                    }
                    try {
                        iMAPProtocol.logout();
                    } catch (ProtocolException unused) {
                    }
                } else {
                    iMAPProtocol.addResponseHandler(this);
                    this.pool.authenticatedConnections.addElement(iMAPProtocol);
                    if (this.debug) {
                        this.out.println("DEBUG: added an Authenticated connection -- size: " + this.pool.authenticatedConnections.size());
                    }
                }
                if (this.pool.folders != null) {
                    this.pool.folders.removeElement(iMAPFolder);
                }
                timeoutConnections();
            } else {
                if (this.pool.folders != null) {
                    this.pool.folders.removeElement(iMAPFolder);
                }
                timeoutConnections();
            }
            throw th;
        }
    }

    public void releaseStoreProtocol(IMAPProtocol iMAPProtocol) {
        if (iMAPProtocol == null) {
            return;
        }
        synchronized (this.pool) {
            this.pool.storeConnectionInUse = false;
            this.pool.notifyAll();
            if (this.pool.debug) {
                this.out.println("DEBUG: releaseStoreProtocol()");
            }
            timeoutConnections();
        }
    }

    public synchronized void setPassword(String str) {
        this.password = str;
    }

    @Override // javax.mail.QuotaAwareStore
    public synchronized void setQuota(Quota quota) throws MessagingException {
        checkConnected();
        IMAPProtocol storeProtocol = null;
        try {
            try {
                storeProtocol = getStoreProtocol();
                storeProtocol.setQuota(quota);
                releaseStoreProtocol(storeProtocol);
                if (storeProtocol == null) {
                    cleanup();
                }
            } catch (BadCommandException e) {
                throw new MessagingException("QUOTA not supported", e);
            } catch (ConnectionException e2) {
                throw new StoreClosedException(this, e2.getMessage());
            } catch (ProtocolException e3) {
                throw new MessagingException(e3.getMessage(), e3);
            }
        } catch (Throwable th) {
            releaseStoreProtocol(storeProtocol);
            if (storeProtocol == null) {
                cleanup();
            }
            throw th;
        }
    }

    public synchronized void setUsername(String str) {
        this.user = str;
    }

    public IMAPStore(Session session, URLName uRLName, String str, int i, boolean z) {
        super(session, uRLName);
        this.name = "imap";
        this.defaultPort = Imgproc.COLOR_COLORCVT_MAX;
        this.isSSL = false;
        this.port = -1;
        this.blksize = 16384;
        this.statusCacheTimeout = 1000;
        this.appendBufferSize = -1;
        this.minIdleTime = 10;
        this.disableAuthLogin = false;
        this.disableAuthPlain = false;
        this.enableStartTLS = false;
        this.enableSASL = false;
        this.forcePasswordRefresh = false;
        this.enableImapEvents = false;
        this.connected = false;
        this.pool = new ConnectionPool();
        str = uRLName != null ? uRLName.getProtocol() : str;
        this.name = str;
        this.defaultPort = i;
        this.isSSL = z;
        this.pool.lastTimePruned = System.currentTimeMillis();
        this.debug = session.getDebug();
        PrintStream debugOut = session.getDebugOut();
        this.out = debugOut;
        if (debugOut == null) {
            this.out = System.out;
        }
        String property = session.getProperty("mail." + str + ".connectionpool.debug");
        if (property != null && property.equalsIgnoreCase("true")) {
            this.pool.debug = true;
        }
        String property2 = session.getProperty("mail." + str + ".partialfetch");
        if (property2 == null || !property2.equalsIgnoreCase("false")) {
            String property3 = session.getProperty("mail." + str + ".fetchsize");
            if (property3 != null) {
                this.blksize = Integer.parseInt(property3);
            }
            if (this.debug) {
                this.out.println("DEBUG: mail.imap.fetchsize: " + this.blksize);
            }
        } else {
            this.blksize = -1;
            if (this.debug) {
                this.out.println("DEBUG: mail.imap.partialfetch: false");
            }
        }
        String property4 = session.getProperty("mail." + str + ".statuscachetimeout");
        if (property4 != null) {
            this.statusCacheTimeout = Integer.parseInt(property4);
            if (this.debug) {
                this.out.println("DEBUG: mail.imap.statuscachetimeout: " + this.statusCacheTimeout);
            }
        }
        String property5 = session.getProperty("mail." + str + ".appendbuffersize");
        if (property5 != null) {
            this.appendBufferSize = Integer.parseInt(property5);
            if (this.debug) {
                this.out.println("DEBUG: mail.imap.appendbuffersize: " + this.appendBufferSize);
            }
        }
        String property6 = session.getProperty("mail." + str + ".minidletime");
        if (property6 != null) {
            this.minIdleTime = Integer.parseInt(property6);
            if (this.debug) {
                this.out.println("DEBUG: mail.imap.minidletime: " + this.minIdleTime);
            }
        }
        String property7 = session.getProperty("mail." + str + ".connectionpoolsize");
        if (property7 != null) {
            try {
                int i2 = Integer.parseInt(property7);
                if (i2 > 0) {
                    this.pool.poolSize = i2;
                }
            } catch (NumberFormatException unused) {
            }
            if (this.pool.debug) {
                this.out.println("DEBUG: mail.imap.connectionpoolsize: " + this.pool.poolSize);
            }
        }
        String property8 = session.getProperty("mail." + str + ".connectionpooltimeout");
        if (property8 != null) {
            try {
                int i3 = Integer.parseInt(property8);
                if (i3 > 0) {
                    this.pool.clientTimeoutInterval = i3;
                }
            } catch (NumberFormatException unused2) {
            }
            if (this.pool.debug) {
                this.out.println("DEBUG: mail.imap.connectionpooltimeout: " + this.pool.clientTimeoutInterval);
            }
        }
        String property9 = session.getProperty("mail." + str + ".servertimeout");
        if (property9 != null) {
            try {
                int i4 = Integer.parseInt(property9);
                if (i4 > 0) {
                    this.pool.serverTimeoutInterval = i4;
                }
            } catch (NumberFormatException unused3) {
            }
            if (this.pool.debug) {
                this.out.println("DEBUG: mail.imap.servertimeout: " + this.pool.serverTimeoutInterval);
            }
        }
        String property10 = session.getProperty("mail." + str + ".separatestoreconnection");
        if (property10 != null && property10.equalsIgnoreCase("true")) {
            if (this.pool.debug) {
                this.out.println("DEBUG: dedicate a store connection");
            }
            this.pool.separateStoreConnection = true;
        }
        String property11 = session.getProperty("mail." + str + ".proxyauth.user");
        if (property11 != null) {
            this.proxyAuthUser = property11;
            if (this.debug) {
                this.out.println("DEBUG: mail.imap.proxyauth.user: " + this.proxyAuthUser);
            }
        }
        String property12 = session.getProperty("mail." + str + ".auth.login.disable");
        if (property12 != null && property12.equalsIgnoreCase("true")) {
            if (this.debug) {
                this.out.println("DEBUG: disable AUTH=LOGIN");
            }
            this.disableAuthLogin = true;
        }
        String property13 = session.getProperty("mail." + str + ".auth.plain.disable");
        if (property13 != null && property13.equalsIgnoreCase("true")) {
            if (this.debug) {
                this.out.println("DEBUG: disable AUTH=PLAIN");
            }
            this.disableAuthPlain = true;
        }
        String property14 = session.getProperty("mail." + str + ".starttls.enable");
        if (property14 != null && property14.equalsIgnoreCase("true")) {
            if (this.debug) {
                this.out.println("DEBUG: enable STARTTLS");
            }
            this.enableStartTLS = true;
        }
        String property15 = session.getProperty("mail." + str + ".sasl.enable");
        if (property15 != null && property15.equalsIgnoreCase("true")) {
            if (this.debug) {
                this.out.println("DEBUG: enable SASL");
            }
            this.enableSASL = true;
        }
        if (this.enableSASL) {
            String property16 = session.getProperty("mail." + str + ".sasl.mechanisms");
            if (property16 != null && property16.length() > 0) {
                if (this.debug) {
                    this.out.println("DEBUG: SASL mechanisms allowed: " + property16);
                }
                Vector vector = new Vector(5);
                StringTokenizer stringTokenizer = new StringTokenizer(property16, " ,");
                while (stringTokenizer.hasMoreTokens()) {
                    String strNextToken = stringTokenizer.nextToken();
                    if (strNextToken.length() > 0) {
                        vector.addElement(strNextToken);
                    }
                }
                String[] strArr = new String[vector.size()];
                this.saslMechanisms = strArr;
                vector.copyInto(strArr);
            }
        }
        String property17 = session.getProperty("mail." + str + ".sasl.authorizationid");
        if (property17 != null) {
            this.authorizationID = property17;
            if (this.debug) {
                this.out.println("DEBUG: mail.imap.sasl.authorizationid: " + this.authorizationID);
            }
        }
        String property18 = session.getProperty("mail." + str + ".sasl.realm");
        if (property18 != null) {
            this.saslRealm = property18;
            if (this.debug) {
                this.out.println("DEBUG: mail.imap.sasl.realm: " + this.saslRealm);
            }
        }
        String property19 = session.getProperty("mail." + str + ".forcepasswordrefresh");
        if (property19 != null && property19.equalsIgnoreCase("true")) {
            if (this.debug) {
                this.out.println("DEBUG: enable forcePasswordRefresh");
            }
            this.forcePasswordRefresh = true;
        }
        String property20 = session.getProperty("mail." + str + ".enableimapevents");
        if (property20 == null || !property20.equalsIgnoreCase("true")) {
            return;
        }
        if (this.debug) {
            this.out.println("DEBUG: enable IMAP events");
        }
        this.enableImapEvents = true;
    }

    private void cleanup(boolean z) {
        boolean z2;
        if (this.debug) {
            this.out.println("DEBUG: IMAPStore cleanup, force " + z);
        }
        Vector vector = null;
        while (true) {
            synchronized (this.pool) {
                if (this.pool.folders != null) {
                    vector = this.pool.folders;
                    this.pool.folders = null;
                    z2 = false;
                } else {
                    z2 = true;
                }
            }
            if (z2) {
                break;
            }
            int size = vector.size();
            for (int i = 0; i < size; i++) {
                IMAPFolder iMAPFolder = (IMAPFolder) vector.elementAt(i);
                if (z) {
                    try {
                        if (this.debug) {
                            this.out.println("DEBUG: force folder to close");
                        }
                        iMAPFolder.forceClose();
                    } catch (IllegalStateException | MessagingException unused) {
                    }
                } else {
                    if (this.debug) {
                        this.out.println("DEBUG: close folder");
                    }
                    iMAPFolder.close(false);
                }
            }
        }
        synchronized (this.pool) {
            emptyConnectionPool(z);
        }
        this.connected = false;
        notifyConnectionListeners(3);
        if (this.debug) {
            this.out.println("DEBUG: IMAPStore cleanup done");
        }
    }

    @Override // javax.mail.Store
    public synchronized Folder getFolder(URLName uRLName) throws MessagingException {
        checkConnected();
        return new IMAPFolder(uRLName.getFile(), IMAPFolder.UNKNOWN_SEPARATOR, this);
    }
}
