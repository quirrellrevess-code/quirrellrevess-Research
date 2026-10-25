package javax.mail;

import com.sun.mail.util.LineInputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public final class Session {
    private static Session defaultSession;
    private final Authenticator authenticator;
    private boolean debug;
    private PrintStream out;
    private final Properties props;
    private final Hashtable authTable = new Hashtable();
    private final Vector providers = new Vector();
    private final Hashtable providersByProtocol = new Hashtable();
    private final Hashtable providersByClassName = new Hashtable();
    private final Properties addressMap = new Properties();

    private Session(Properties properties, Authenticator authenticator) throws Throwable {
        this.debug = false;
        this.props = properties;
        this.authenticator = authenticator;
        if (Boolean.valueOf(properties.getProperty("mail.debug")).booleanValue()) {
            this.debug = true;
        }
        if (this.debug) {
            m824pr("DEBUG: JavaMail version 1.4.1");
        }
        Class<?> cls = authenticator != null ? authenticator.getClass() : Session.class;
        loadProviders(cls);
        loadAddressMap(cls);
    }

    private static ClassLoader getContextClassLoader() {
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction() { // from class: javax.mail.Session.3
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

    public static synchronized Session getDefaultInstance(Properties properties, Authenticator authenticator) {
        Session session = defaultSession;
        if (session == null) {
            defaultSession = new Session(properties, authenticator);
        } else {
            Authenticator authenticator2 = session.authenticator;
            if (authenticator2 != authenticator && (authenticator2 == null || authenticator == null || authenticator2.getClass().getClassLoader() != authenticator.getClass().getClassLoader())) {
                throw new SecurityException("Access to default session denied");
            }
        }
        return defaultSession;
    }

    public static Session getInstance(Properties properties, Authenticator authenticator) {
        return new Session(properties, authenticator);
    }

    private static InputStream getResourceAsStream(final Class cls, final String str) throws IOException {
        try {
            return (InputStream) AccessController.doPrivileged(new PrivilegedExceptionAction() { // from class: javax.mail.Session.4
                @Override // java.security.PrivilegedExceptionAction
                public Object run() throws IOException {
                    return cls.getResourceAsStream(str);
                }
            });
        } catch (PrivilegedActionException e) {
            throw ((IOException) e.getException());
        }
    }

    private static URL[] getResources(final ClassLoader classLoader, final String str) {
        return (URL[]) AccessController.doPrivileged(new PrivilegedAction() { // from class: javax.mail.Session.5
            @Override // java.security.PrivilegedAction
            public Object run() {
                URL[] urlArr = null;
                try {
                    Vector vector = new Vector();
                    Enumeration<URL> resources = classLoader.getResources(str);
                    while (resources != null && resources.hasMoreElements()) {
                        URL urlNextElement = resources.nextElement();
                        if (urlNextElement != null) {
                            vector.addElement(urlNextElement);
                        }
                    }
                    if (vector.size() <= 0) {
                        return null;
                    }
                    urlArr = new URL[vector.size()];
                    vector.copyInto(urlArr);
                    return urlArr;
                } catch (IOException | SecurityException unused) {
                    return urlArr;
                }
            }
        });
    }

    private Object getService(Provider provider, URLName uRLName) throws NoSuchProviderException {
        if (provider == null) {
            throw new NoSuchProviderException("null");
        }
        if (uRLName == null) {
            uRLName = new URLName(provider.getProtocol(), null, -1, null, null, null);
        }
        Authenticator authenticator = this.authenticator;
        ClassLoader classLoader = authenticator != null ? authenticator.getClass().getClassLoader() : Session.class.getClassLoader();
        Class<?> cls = null;
        try {
            try {
                ClassLoader contextClassLoader = getContextClassLoader();
                if (contextClassLoader != null) {
                    try {
                        cls = contextClassLoader.loadClass(provider.getClassName());
                    } catch (ClassNotFoundException unused) {
                    }
                }
                if (cls == null) {
                    cls = classLoader.loadClass(provider.getClassName());
                }
            } catch (Exception unused2) {
                cls = Class.forName(provider.getClassName());
            }
            try {
                return cls.getConstructor(Session.class, URLName.class).newInstance(this, uRLName);
            } catch (Exception e) {
                if (this.debug) {
                    e.printStackTrace(getDebugOut());
                }
                throw new NoSuchProviderException(provider.getProtocol());
            }
        } catch (Exception e2) {
            if (this.debug) {
                e2.printStackTrace(getDebugOut());
            }
            throw new NoSuchProviderException(provider.getProtocol());
        }
    }

    private static URL[] getSystemResources(final String str) {
        return (URL[]) AccessController.doPrivileged(new PrivilegedAction() { // from class: javax.mail.Session.6
            @Override // java.security.PrivilegedAction
            public Object run() {
                URL[] urlArr = null;
                try {
                    Vector vector = new Vector();
                    Enumeration<URL> systemResources = ClassLoader.getSystemResources(str);
                    while (systemResources != null && systemResources.hasMoreElements()) {
                        URL urlNextElement = systemResources.nextElement();
                        if (urlNextElement != null) {
                            vector.addElement(urlNextElement);
                        }
                    }
                    if (vector.size() <= 0) {
                        return null;
                    }
                    urlArr = new URL[vector.size()];
                    vector.copyInto(urlArr);
                    return urlArr;
                } catch (IOException | SecurityException unused) {
                    return urlArr;
                }
            }
        });
    }

    private void loadAddressMap(Class cls) throws Throwable {
        StreamLoader streamLoader = new StreamLoader() { // from class: javax.mail.Session.2
            @Override // javax.mail.StreamLoader
            public void load(InputStream inputStream) throws IOException {
                Session.this.addressMap.load(inputStream);
            }
        };
        loadResource("/META-INF/javamail.default.address.map", cls, streamLoader);
        loadAllResources("META-INF/javamail.address.map", cls, streamLoader);
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(System.getProperty("java.home")));
            String str = File.separator;
            sb.append(str);
            sb.append("lib");
            sb.append(str);
            sb.append("javamail.address.map");
            loadFile(sb.toString(), streamLoader);
        } catch (SecurityException e) {
            if (this.debug) {
                m824pr("DEBUG: can't get java.home: " + e);
            }
        }
        if (this.addressMap.isEmpty()) {
            if (this.debug) {
                m824pr("DEBUG: failed to load address map, using defaults");
            }
            this.addressMap.put("rfc822", "smtp");
        }
    }

    /* JADX WARN: Code duplicated, block: B:70:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:80:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:? A[RETURN, SYNTHETIC] */
    private void loadAllResources(String str, Class cls, StreamLoader streamLoader) throws Throwable {
        SecurityException e;
        IOException e2;
        int i = 0;
        try {
            ClassLoader contextClassLoader = getContextClassLoader();
            if (contextClassLoader == null) {
                contextClassLoader = cls.getClassLoader();
            }
            URL[] resources = contextClassLoader != null ? getResources(contextClassLoader, str) : getSystemResources(str);
            if (resources != null) {
                int i2 = 0;
                while (i < resources.length) {
                    try {
                        URL url = resources[i];
                        InputStream inputStreamOpenStream = null;
                        if (this.debug) {
                            m824pr("DEBUG: URL " + url);
                        }
                        int i3 = 1;
                        try {
                            inputStreamOpenStream = openStream(url);
                            if (inputStreamOpenStream != null) {
                                streamLoader.load(inputStreamOpenStream);
                                try {
                                    if (this.debug) {
                                        m824pr("DEBUG: successfully loaded resource: " + url);
                                    }
                                    i2 = 1;
                                } catch (IOException e3) {
                                    e2 = e3;
                                    if (this.debug) {
                                        m824pr("DEBUG: " + e2);
                                    }
                                    if (inputStreamOpenStream != null) {
                                        try {
                                            inputStreamOpenStream.close();
                                        } catch (IOException unused) {
                                        } catch (Exception e4) {
                                            e = e4;
                                            i = i3;
                                            if (this.debug) {
                                                m824pr("DEBUG: " + e);
                                            }
                                            if (i == 0) {
                                                if (this.debug) {
                                                    m824pr("DEBUG: !anyLoaded");
                                                }
                                                loadResource("/" + str, cls, streamLoader);
                                            }
                                        }
                                    }
                                    i2 = i3;
                                } catch (SecurityException e5) {
                                    e = e5;
                                    try {
                                        if (this.debug) {
                                            m824pr("DEBUG: " + e);
                                        }
                                        if (inputStreamOpenStream != null) {
                                            inputStreamOpenStream.close();
                                        }
                                        i2 = i3;
                                    } catch (Throwable th) {
                                        th = th;
                                        i2 = i3;
                                        if (inputStreamOpenStream != null) {
                                            try {
                                                inputStreamOpenStream.close();
                                            } catch (IOException unused2) {
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    i2 = 1;
                                    if (inputStreamOpenStream != null) {
                                        inputStreamOpenStream.close();
                                    }
                                    throw th;
                                }
                            } else if (this.debug) {
                                m824pr("DEBUG: not loading resource: " + url);
                            }
                            if (inputStreamOpenStream != null) {
                                try {
                                    inputStreamOpenStream.close();
                                } catch (IOException unused3) {
                                }
                            }
                        } catch (IOException e6) {
                            i3 = i2;
                            e2 = e6;
                        } catch (SecurityException e7) {
                            i3 = i2;
                            e = e7;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        i++;
                    } catch (Exception e8) {
                        e = e8;
                        i = i2;
                    }
                }
                i = i2;
            }
        } catch (Exception e9) {
            e = e9;
        }
        if (i == 0) {
            if (this.debug) {
                m824pr("DEBUG: !anyLoaded");
            }
            loadResource("/" + str, cls, streamLoader);
        }
    }

    private void loadFile(String str, StreamLoader streamLoader) throws Throwable {
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str));
                    try {
                        streamLoader.load(bufferedInputStream2);
                        if (this.debug) {
                            m824pr("DEBUG: successfully loaded file: " + str);
                        }
                        bufferedInputStream2.close();
                    } catch (IOException e) {
                        e = e;
                        bufferedInputStream = bufferedInputStream2;
                        if (this.debug) {
                            m824pr("DEBUG: not loading file: " + str);
                            m824pr("DEBUG: " + e);
                        }
                        if (bufferedInputStream == null) {
                            return;
                        }
                        bufferedInputStream.close();
                    } catch (SecurityException e2) {
                        e = e2;
                        bufferedInputStream = bufferedInputStream2;
                        if (this.debug) {
                            m824pr("DEBUG: not loading file: " + str);
                            m824pr("DEBUG: " + e);
                        }
                        if (bufferedInputStream == null) {
                            return;
                        }
                        bufferedInputStream.close();
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                } catch (SecurityException e4) {
                    e = e4;
                }
            } catch (IOException unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void loadProviders(Class cls) throws Throwable {
        StreamLoader streamLoader = new StreamLoader() { // from class: javax.mail.Session.1
            @Override // javax.mail.StreamLoader
            public void load(InputStream inputStream) throws IOException {
                Session.this.loadProvidersFromStream(inputStream);
            }
        };
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(System.getProperty("java.home")));
            String str = File.separator;
            sb.append(str);
            sb.append("lib");
            sb.append(str);
            sb.append("javamail.providers");
            loadFile(sb.toString(), streamLoader);
        } catch (SecurityException e) {
            if (this.debug) {
                m824pr("DEBUG: can't get java.home: " + e);
            }
        }
        loadAllResources("META-INF/javamail.providers", cls, streamLoader);
        loadResource("/META-INF/javamail.default.providers", cls, streamLoader);
        if (this.providers.size() == 0) {
            if (this.debug) {
                m824pr("DEBUG: failed to load any providers, using defaults");
            }
            Provider.Type type = Provider.Type.STORE;
            addProvider(new Provider(type, "imap", "com.sun.mail.imap.IMAPStore", "Sun Microsystems, Inc.", Version.version));
            addProvider(new Provider(type, "imaps", "com.sun.mail.imap.IMAPSSLStore", "Sun Microsystems, Inc.", Version.version));
            addProvider(new Provider(type, "pop3", "com.sun.mail.pop3.POP3Store", "Sun Microsystems, Inc.", Version.version));
            addProvider(new Provider(type, "pop3s", "com.sun.mail.pop3.POP3SSLStore", "Sun Microsystems, Inc.", Version.version));
            Provider.Type type2 = Provider.Type.TRANSPORT;
            addProvider(new Provider(type2, "smtp", "com.sun.mail.smtp.SMTPTransport", "Sun Microsystems, Inc.", Version.version));
            addProvider(new Provider(type2, "smtps", "com.sun.mail.smtp.SMTPSSLTransport", "Sun Microsystems, Inc.", Version.version));
        }
        if (this.debug) {
            m824pr("DEBUG: Tables of loaded providers");
            m824pr("DEBUG: Providers Listed By Class Name: " + this.providersByClassName.toString());
            m824pr("DEBUG: Providers Listed By Protocol: " + this.providersByProtocol.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadProvidersFromStream(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return;
        }
        LineInputStream lineInputStream = new LineInputStream(inputStream);
        while (true) {
            String line = lineInputStream.readLine();
            if (line == null) {
                return;
            }
            if (!line.startsWith("#")) {
                StringTokenizer stringTokenizer = new StringTokenizer(line, ";");
                Provider.Type type = null;
                String strSubstring = null;
                String strSubstring2 = null;
                String strSubstring3 = null;
                String strSubstring4 = null;
                while (stringTokenizer.hasMoreTokens()) {
                    String strTrim = stringTokenizer.nextToken().trim();
                    int iIndexOf = strTrim.indexOf("=");
                    if (strTrim.startsWith("protocol=")) {
                        strSubstring = strTrim.substring(iIndexOf + 1);
                    } else if (strTrim.startsWith("type=")) {
                        String strSubstring5 = strTrim.substring(iIndexOf + 1);
                        if (strSubstring5.equalsIgnoreCase("store")) {
                            type = Provider.Type.STORE;
                        } else if (strSubstring5.equalsIgnoreCase("transport")) {
                            type = Provider.Type.TRANSPORT;
                        }
                    } else if (strTrim.startsWith("class=")) {
                        strSubstring2 = strTrim.substring(iIndexOf + 1);
                    } else if (strTrim.startsWith("vendor=")) {
                        strSubstring3 = strTrim.substring(iIndexOf + 1);
                    } else if (strTrim.startsWith("version=")) {
                        strSubstring4 = strTrim.substring(iIndexOf + 1);
                    }
                }
                if (type != null && strSubstring != null && strSubstring2 != null && strSubstring.length() > 0 && strSubstring2.length() > 0) {
                    addProvider(new Provider(type, strSubstring, strSubstring2, strSubstring3, strSubstring4));
                } else if (this.debug) {
                    m824pr("DEBUG: Bad provider entry: " + line);
                }
            }
        }
    }

    private void loadResource(String str, Class cls, StreamLoader streamLoader) {
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = getResourceAsStream(cls, str);
            if (resourceAsStream != null) {
                streamLoader.load(resourceAsStream);
                if (this.debug) {
                    m824pr("DEBUG: successfully loaded resource: " + str);
                }
            } else if (this.debug) {
                m824pr("DEBUG: not loading resource: " + str);
            }
        } catch (IOException e) {
            if (this.debug) {
                m824pr("DEBUG: " + e);
            }
        } catch (SecurityException e2) {
            if (this.debug) {
                m824pr("DEBUG: " + e2);
            }
        } finally {
            if (0 != 0) {
                try {
                    resourceAsStream.close();
                } catch (IOException unused) {
                }
            }
        }
    }

    private static InputStream openStream(final URL url) throws IOException {
        try {
            return (InputStream) AccessController.doPrivileged(new PrivilegedExceptionAction() { // from class: javax.mail.Session.7
                @Override // java.security.PrivilegedExceptionAction
                public Object run() throws IOException {
                    return url.openStream();
                }
            });
        } catch (PrivilegedActionException e) {
            throw ((IOException) e.getException());
        }
    }

    /* JADX INFO: renamed from: pr */
    private void m824pr(String str) {
        getDebugOut().println(str);
    }

    public synchronized void addProvider(Provider provider) {
        this.providers.addElement(provider);
        this.providersByClassName.put(provider.getClassName(), provider);
        if (!this.providersByProtocol.containsKey(provider.getProtocol())) {
            this.providersByProtocol.put(provider.getProtocol(), provider);
        }
    }

    public synchronized boolean getDebug() {
        return this.debug;
    }

    public synchronized PrintStream getDebugOut() {
        PrintStream printStream = this.out;
        if (printStream != null) {
            return printStream;
        }
        return System.out;
    }

    public Folder getFolder(URLName uRLName) throws MessagingException {
        Store store = getStore(uRLName);
        store.connect();
        return store.getFolder(uRLName);
    }

    public PasswordAuthentication getPasswordAuthentication(URLName uRLName) {
        return (PasswordAuthentication) this.authTable.get(uRLName);
    }

    public Properties getProperties() {
        return this.props;
    }

    public String getProperty(String str) {
        return this.props.getProperty(str);
    }

    public synchronized Provider getProvider(String str) throws NoSuchProviderException {
        if (str != null) {
            if (str.length() > 0) {
                Provider provider = null;
                String property = this.props.getProperty("mail." + str + ".class");
                if (property != null) {
                    if (this.debug) {
                        m824pr("DEBUG: mail." + str + ".class property exists and points to " + property);
                    }
                    provider = (Provider) this.providersByClassName.get(property);
                }
                if (provider != null) {
                    return provider;
                }
                Provider provider2 = (Provider) this.providersByProtocol.get(str);
                if (provider2 == null) {
                    throw new NoSuchProviderException("No provider for " + str);
                }
                if (this.debug) {
                    m824pr("DEBUG: getProvider() returning " + provider2.toString());
                }
                return provider2;
            }
        }
        throw new NoSuchProviderException("Invalid protocol: null");
    }

    public synchronized Provider[] getProviders() {
        Provider[] providerArr;
        providerArr = new Provider[this.providers.size()];
        this.providers.copyInto(providerArr);
        return providerArr;
    }

    public Store getStore() throws NoSuchProviderException {
        return getStore(getProperty("mail.store.protocol"));
    }

    public Transport getTransport() throws NoSuchProviderException {
        return getTransport(getProperty("mail.transport.protocol"));
    }

    public PasswordAuthentication requestPasswordAuthentication(InetAddress inetAddress, int i, String str, String str2, String str3) {
        Authenticator authenticator = this.authenticator;
        if (authenticator != null) {
            return authenticator.requestPasswordAuthentication(inetAddress, i, str, str2, str3);
        }
        return null;
    }

    public synchronized void setDebug(boolean z) {
        this.debug = z;
        if (z) {
            m824pr("DEBUG: setDebug: JavaMail version 1.4.1");
        }
    }

    public synchronized void setDebugOut(PrintStream printStream) {
        this.out = printStream;
    }

    public void setPasswordAuthentication(URLName uRLName, PasswordAuthentication passwordAuthentication) {
        if (passwordAuthentication == null) {
            this.authTable.remove(uRLName);
        } else {
            this.authTable.put(uRLName, passwordAuthentication);
        }
    }

    public synchronized void setProtocolForAddress(String str, String str2) {
        try {
            if (str2 == null) {
                this.addressMap.remove(str);
            } else {
                this.addressMap.put(str, str2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setProvider(Provider provider) throws NoSuchProviderException {
        try {
            if (provider == null) {
                throw new NoSuchProviderException("Can't set null provider");
            }
            this.providersByProtocol.put(provider.getProtocol(), provider);
            this.props.put("mail." + provider.getProtocol() + ".class", provider.getClassName());
        } catch (Throwable th) {
            throw th;
        }
    }

    public static Session getInstance(Properties properties) {
        return new Session(properties, null);
    }

    public Store getStore(String str) throws NoSuchProviderException {
        return getStore(new URLName(str, null, -1, null, null, null));
    }

    public Transport getTransport(String str) throws NoSuchProviderException {
        return getTransport(new URLName(str, null, -1, null, null, null));
    }

    public Store getStore(URLName uRLName) throws NoSuchProviderException {
        return getStore(getProvider(uRLName.getProtocol()), uRLName);
    }

    public Transport getTransport(URLName uRLName) throws NoSuchProviderException {
        return getTransport(getProvider(uRLName.getProtocol()), uRLName);
    }

    public Store getStore(Provider provider) throws NoSuchProviderException {
        return getStore(provider, null);
    }

    public Transport getTransport(Provider provider) throws NoSuchProviderException {
        return getTransport(provider, null);
    }

    private Store getStore(Provider provider, URLName uRLName) throws NoSuchProviderException {
        if (provider != null && provider.getType() == Provider.Type.STORE) {
            try {
                return (Store) getService(provider, uRLName);
            } catch (ClassCastException unused) {
                throw new NoSuchProviderException("incorrect class");
            }
        }
        throw new NoSuchProviderException("invalid provider");
    }

    public Transport getTransport(Address address) throws NoSuchProviderException {
        String str = (String) this.addressMap.get(address.getType());
        if (str != null) {
            return getTransport(str);
        }
        throw new NoSuchProviderException("No provider for Address type: " + address.getType());
    }

    public static Session getDefaultInstance(Properties properties) {
        return getDefaultInstance(properties, null);
    }

    private Transport getTransport(Provider provider, URLName uRLName) throws NoSuchProviderException {
        if (provider != null && provider.getType() == Provider.Type.TRANSPORT) {
            try {
                return (Transport) getService(provider, uRLName);
            } catch (ClassCastException unused) {
                throw new NoSuchProviderException("incorrect class");
            }
        }
        throw new NoSuchProviderException("invalid provider");
    }
}
