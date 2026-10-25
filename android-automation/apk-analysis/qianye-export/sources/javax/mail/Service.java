package javax.mail;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Vector;
import javax.mail.event.ConnectionEvent;
import javax.mail.event.ConnectionListener;
import javax.mail.event.MailEvent;

/* JADX INFO: loaded from: classes.dex */
public abstract class Service {
    public boolean debug;

    /* JADX INFO: renamed from: q */
    private EventQueue f863q;
    public Session session;
    public URLName url;
    private boolean connected = false;
    private Vector connectionListeners = null;
    private Object qLock = new Object();

    public static class TerminatorEvent extends MailEvent {
        private static final long serialVersionUID = 5542172141759168416L;

        public TerminatorEvent() {
            super(new Object());
        }

        @Override // javax.mail.event.MailEvent
        public void dispatch(Object obj) {
            Thread.currentThread().interrupt();
        }
    }

    public Service(Session session, URLName uRLName) {
        this.url = null;
        this.debug = false;
        this.session = session;
        this.url = uRLName;
        this.debug = session.getDebug();
    }

    private void terminateQueue() {
        synchronized (this.qLock) {
            if (this.f863q != null) {
                Vector vector = new Vector();
                vector.setSize(1);
                this.f863q.enqueue(new TerminatorEvent(), vector);
                this.f863q = null;
            }
        }
    }

    public synchronized void addConnectionListener(ConnectionListener connectionListener) {
        if (this.connectionListeners == null) {
            this.connectionListeners = new Vector();
        }
        this.connectionListeners.addElement(connectionListener);
    }

    public synchronized void close() throws MessagingException {
        setConnected(false);
        notifyConnectionListeners(3);
    }

    public void connect() throws MessagingException {
        connect(null, null, null);
    }

    public void finalize() throws Throwable {
        super.finalize();
        terminateQueue();
    }

    public synchronized URLName getURLName() {
        URLName uRLName = this.url;
        if (uRLName == null || (uRLName.getPassword() == null && this.url.getFile() == null)) {
            return this.url;
        }
        return new URLName(this.url.getProtocol(), this.url.getHost(), this.url.getPort(), null, this.url.getUsername(), null);
    }

    public synchronized boolean isConnected() {
        return this.connected;
    }

    public synchronized void notifyConnectionListeners(int i) {
        if (this.connectionListeners != null) {
            queueEvent(new ConnectionEvent(this, i), this.connectionListeners);
        }
        if (i == 3) {
            terminateQueue();
        }
    }

    public boolean protocolConnect(String str, int i, String str2, String str3) throws MessagingException {
        return false;
    }

    public void queueEvent(MailEvent mailEvent, Vector vector) {
        synchronized (this.qLock) {
            if (this.f863q == null) {
                this.f863q = new EventQueue();
            }
        }
        this.f863q.enqueue(mailEvent, (Vector) vector.clone());
    }

    public synchronized void removeConnectionListener(ConnectionListener connectionListener) {
        Vector vector = this.connectionListeners;
        if (vector != null) {
            vector.removeElement(connectionListener);
        }
    }

    public synchronized void setConnected(boolean z) {
        this.connected = z;
    }

    public synchronized void setURLName(URLName uRLName) {
        this.url = uRLName;
    }

    public String toString() {
        URLName uRLName = getURLName();
        return uRLName != null ? uRLName.toString() : super.toString();
    }

    public void connect(String str, String str2, String str3) throws MessagingException, UnknownHostException {
        connect(str, -1, str2, str3);
    }

    public void connect(String str, String str2) throws MessagingException, UnknownHostException {
        connect(null, str, str2);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0051 A[PHI: r0
  0x0051: PHI (r0v24 java.lang.String) = (r0v0 java.lang.String), (r0v0 java.lang.String), (r0v27 java.lang.String) binds: [B:20:0x003c, B:22:0x0048, B:18:0x0033] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:69:0x0135 A[Catch: all -> 0x017b, TryCatch #2 {, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x000f, B:10:0x0015, B:14:0x0023, B:17:0x002d, B:19:0x0035, B:25:0x0053, B:29:0x006b, B:31:0x0086, B:33:0x00a1, B:35:0x00ab, B:38:0x00b6, B:46:0x00cf, B:48:0x00d3, B:51:0x00f5, B:59:0x0115, B:64:0x0122, B:67:0x0129, B:69:0x0135, B:72:0x0145, B:73:0x0146, B:74:0x014b, B:75:0x014c, B:77:0x015d, B:78:0x016b, B:52:0x00fe, B:54:0x0108, B:41:0x00be, B:43:0x00c2, B:21:0x003e, B:23:0x004a, B:81:0x0173, B:82:0x017a), top: B:90:0x0005, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0143 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:72:0x0145 A[Catch: all -> 0x017b, TryCatch #2 {, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x000f, B:10:0x0015, B:14:0x0023, B:17:0x002d, B:19:0x0035, B:25:0x0053, B:29:0x006b, B:31:0x0086, B:33:0x00a1, B:35:0x00ab, B:38:0x00b6, B:46:0x00cf, B:48:0x00d3, B:51:0x00f5, B:59:0x0115, B:64:0x0122, B:67:0x0129, B:69:0x0135, B:72:0x0145, B:73:0x0146, B:74:0x014b, B:75:0x014c, B:77:0x015d, B:78:0x016b, B:52:0x00fe, B:54:0x0108, B:41:0x00be, B:43:0x00c2, B:21:0x003e, B:23:0x004a, B:81:0x0173, B:82:0x017a), top: B:90:0x0005, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0146 A[Catch: all -> 0x017b, TryCatch #2 {, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x000f, B:10:0x0015, B:14:0x0023, B:17:0x002d, B:19:0x0035, B:25:0x0053, B:29:0x006b, B:31:0x0086, B:33:0x00a1, B:35:0x00ab, B:38:0x00b6, B:46:0x00cf, B:48:0x00d3, B:51:0x00f5, B:59:0x0115, B:64:0x0122, B:67:0x0129, B:69:0x0135, B:72:0x0145, B:73:0x0146, B:74:0x014b, B:75:0x014c, B:77:0x015d, B:78:0x016b, B:52:0x00fe, B:54:0x0108, B:41:0x00be, B:43:0x00c2, B:21:0x003e, B:23:0x004a, B:81:0x0173, B:82:0x017a), top: B:90:0x0005, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x014c A[Catch: all -> 0x017b, TryCatch #2 {, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x000f, B:10:0x0015, B:14:0x0023, B:17:0x002d, B:19:0x0035, B:25:0x0053, B:29:0x006b, B:31:0x0086, B:33:0x00a1, B:35:0x00ab, B:38:0x00b6, B:46:0x00cf, B:48:0x00d3, B:51:0x00f5, B:59:0x0115, B:64:0x0122, B:67:0x0129, B:69:0x0135, B:72:0x0145, B:73:0x0146, B:74:0x014b, B:75:0x014c, B:77:0x015d, B:78:0x016b, B:52:0x00fe, B:54:0x0108, B:41:0x00be, B:43:0x00c2, B:21:0x003e, B:23:0x004a, B:81:0x0173, B:82:0x017a), top: B:90:0x0005, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x015d A[Catch: all -> 0x017b, TryCatch #2 {, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x000f, B:10:0x0015, B:14:0x0023, B:17:0x002d, B:19:0x0035, B:25:0x0053, B:29:0x006b, B:31:0x0086, B:33:0x00a1, B:35:0x00ab, B:38:0x00b6, B:46:0x00cf, B:48:0x00d3, B:51:0x00f5, B:59:0x0115, B:64:0x0122, B:67:0x0129, B:69:0x0135, B:72:0x0145, B:73:0x0146, B:74:0x014b, B:75:0x014c, B:77:0x015d, B:78:0x016b, B:52:0x00fe, B:54:0x0108, B:41:0x00be, B:43:0x00c2, B:21:0x003e, B:23:0x004a, B:81:0x0173, B:82:0x017a), top: B:90:0x0005, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v7 */
    public synchronized void connect(String str, int i, String str2, String str3) throws MessagingException, UnknownHostException {
        String property;
        String password;
        int i2;
        String str4;
        String file;
        boolean z;
        ?? r15;
        boolean z2;
        String password2;
        String userName;
        AuthenticationFailedException authenticationFailedException;
        boolean zProtocolConnect;
        InetAddress byName;
        PasswordAuthentication passwordAuthenticationRequestPasswordAuthentication;
        String str5;
        String password3;
        String property2 = str2;
        synchronized (this) {
            if (!isConnected()) {
                URLName uRLName = this.url;
                if (uRLName != null) {
                    String protocol = uRLName.getProtocol();
                    property = str == null ? this.url.getHost() : str;
                    int port = i == -1 ? this.url.getPort() : i;
                    if (property2 == null) {
                        property2 = this.url.getUsername();
                        if (str3 == null) {
                            password3 = this.url.getPassword();
                        } else {
                            password3 = str3;
                        }
                    } else if (str3 == null && property2.equals(this.url.getUsername())) {
                        password3 = this.url.getPassword();
                    } else {
                        password3 = str3;
                    }
                    str4 = protocol;
                    i2 = port;
                    password = password3;
                    file = this.url.getFile();
                } else {
                    property = str;
                    password = str3;
                    i2 = i;
                    str4 = null;
                    file = null;
                }
                if (str4 != null) {
                    if (property == null) {
                        property = this.session.getProperty("mail." + str4 + ".host");
                    }
                    if (property2 == null) {
                        property2 = this.session.getProperty("mail." + str4 + ".user");
                    }
                }
                if (property == null) {
                    property = this.session.getProperty("mail.host");
                }
                if (property2 == null) {
                    property2 = this.session.getProperty("mail.user");
                }
                String property3 = property2;
                if (property3 == null) {
                    try {
                        property3 = System.getProperty("user.name");
                    } catch (SecurityException e) {
                        if (this.debug) {
                            e.printStackTrace(this.session.getDebugOut());
                        }
                    }
                }
                String userName2 = property3;
                try {
                    if (password != null || this.url == null) {
                        z = true;
                    } else {
                        r15 = 1;
                        z = true;
                        z = true;
                        z = true;
                        setURLName(new URLName(str4, property, i2, file, userName2, null));
                        PasswordAuthentication passwordAuthentication = this.session.getPasswordAuthentication(getURLName());
                        if (passwordAuthentication == null) {
                            userName = userName2;
                            password2 = password;
                            z2 = true;
                        } else if (userName2 == null) {
                            userName2 = passwordAuthentication.getUserName();
                            password = passwordAuthentication.getPassword();
                        } else if (userName2.equals(passwordAuthentication.getUserName())) {
                            password = passwordAuthentication.getPassword();
                        }
                        zProtocolConnect = protocolConnect(property, i2, userName, password2);
                        authenticationFailedException = null;
                        if (!zProtocolConnect) {
                            try {
                                byName = InetAddress.getByName(property);
                            } catch (UnknownHostException unused) {
                                byName = null;
                            }
                            passwordAuthenticationRequestPasswordAuthentication = this.session.requestPasswordAuthentication(byName, i2, str4, null, userName);
                            if (passwordAuthenticationRequestPasswordAuthentication != null) {
                                userName = passwordAuthenticationRequestPasswordAuthentication.getUserName();
                                password2 = passwordAuthenticationRequestPasswordAuthentication.getPassword();
                                zProtocolConnect = protocolConnect(property, i2, userName, password2);
                            }
                        }
                        if (!zProtocolConnect) {
                            if (authenticationFailedException != null) {
                                throw authenticationFailedException;
                            }
                            throw new AuthenticationFailedException();
                        }
                        str5 = password2;
                        setURLName(new URLName(str4, property, i2, file, userName, password2));
                        if (z2) {
                            this.session.setPasswordAuthentication(getURLName(), new PasswordAuthentication(userName, str5));
                        }
                        setConnected(r15);
                        notifyConnectionListeners(r15);
                    }
                    zProtocolConnect = protocolConnect(property, i2, userName, password2);
                    authenticationFailedException = null;
                } catch (AuthenticationFailedException e2) {
                    authenticationFailedException = e2;
                    zProtocolConnect = false;
                }
                userName = userName2;
                password2 = password;
                z2 = false;
                r15 = z;
                if (!zProtocolConnect) {
                    byName = InetAddress.getByName(property);
                    passwordAuthenticationRequestPasswordAuthentication = this.session.requestPasswordAuthentication(byName, i2, str4, null, userName);
                    if (passwordAuthenticationRequestPasswordAuthentication != null) {
                        userName = passwordAuthenticationRequestPasswordAuthentication.getUserName();
                        password2 = passwordAuthenticationRequestPasswordAuthentication.getPassword();
                        zProtocolConnect = protocolConnect(property, i2, userName, password2);
                    }
                }
                if (!zProtocolConnect) {
                    if (authenticationFailedException != null) {
                        throw authenticationFailedException;
                    }
                    throw new AuthenticationFailedException();
                }
                str5 = password2;
                setURLName(new URLName(str4, property, i2, file, userName, password2));
                if (z2) {
                    this.session.setPasswordAuthentication(getURLName(), new PasswordAuthentication(userName, str5));
                }
                setConnected(r15);
                notifyConnectionListeners(r15);
            } else {
                throw new IllegalStateException("already connected");
            }
        }
    }
}
