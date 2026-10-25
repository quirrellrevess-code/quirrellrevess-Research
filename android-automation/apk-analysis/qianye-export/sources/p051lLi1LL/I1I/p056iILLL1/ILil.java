package p051lLi1LL.I1I.p056iILLL1;

import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.MysqlErrorNumbers;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import p051lLi1LL.I1I.IL;
import p051lLi1LL.I1I.p055L11I.I1I;
import p051lLi1LL.I1I.p057lIiI.L11I;
import p051lLi1LL.I1I.p058il.iILLL1;

/* JADX INFO: compiled from: WebSocketClient.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class ILil extends p051lLi1LL.I1I.IL1Iii implements Runnable, p051lLi1LL.I1I.ILil {
    private CountDownLatch closeLatch;
    private CountDownLatch connectLatch;
    private Thread connectReadThread;
    private int connectTimeout;
    private p051lLi1LL.I1I.p056iILLL1.IL1Iii dnsResolver;
    private p051lLi1LL.I1I.p053IiL.IL1Iii draft;
    private IL engine;
    private Map<String, String> headers;
    private OutputStream ostream;
    private Proxy proxy;
    private Socket socket;
    private SocketFactory socketFactory;
    public URI uri;
    private Thread writeThread;

    /* JADX INFO: compiled from: WebSocketClient.java */
    public class IL1Iii implements p051lLi1LL.I1I.p056iILLL1.IL1Iii {
        public IL1Iii(ILil iLil) {
        }

        @Override // p051lLi1LL.I1I.p056iILLL1.IL1Iii
        public InetAddress IL1Iii(URI uri) throws UnknownHostException {
            return InetAddress.getByName(uri.getHost());
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL.I1I.iI丨LLL1.ILil$ILil, reason: collision with other inner class name */
    /* JADX INFO: compiled from: WebSocketClient.java */
    public class RunnableC0597ILil implements Runnable {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final ILil f5472ILil;

        public RunnableC0597ILil(ILil iLil) {
            this.f5472ILil = iLil;
        }

        public final void IL1Iii() {
            try {
                if (ILil.this.socket != null) {
                    ILil.this.socket.close();
                }
            } catch (IOException e) {
                ILil.this.onWebsocketError(this.f5472ILil, e);
            }
        }

        public final void ILil() throws IOException {
            while (!Thread.interrupted()) {
                try {
                    ByteBuffer byteBufferTake = ILil.this.engine.f5437I1I.take();
                    ILil.this.ostream.write(byteBufferTake.array(), 0, byteBufferTake.limit());
                    ILil.this.ostream.flush();
                } catch (InterruptedException unused) {
                    for (ByteBuffer byteBuffer : ILil.this.engine.f5437I1I) {
                        ILil.this.ostream.write(byteBuffer.array(), 0, byteBuffer.limit());
                        ILil.this.ostream.flush();
                    }
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("WebSocketWriteThread-" + Thread.currentThread().getId());
            try {
                try {
                    ILil();
                } catch (IOException e) {
                    ILil.this.handleIOException(e);
                }
            } finally {
                IL1Iii();
                ILil.this.writeThread = null;
            }
        }
    }

    public ILil(URI uri) {
        this(uri, new p051lLi1LL.I1I.p053IiL.ILil());
    }

    private int getPort() {
        int port = this.uri.getPort();
        if (port != -1) {
            return port;
        }
        String scheme = this.uri.getScheme();
        if ("wss".equals(scheme)) {
            return 443;
        }
        if ("ws".equals(scheme)) {
            return 80;
        }
        throw new IllegalArgumentException("unknown scheme: " + scheme);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleIOException(IOException iOException) {
        if (iOException instanceof SSLException) {
            onError(iOException);
        }
        this.engine.m3525lIiI();
    }

    private void reset() {
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread == this.writeThread || threadCurrentThread == this.connectReadThread) {
            throw new IllegalStateException("You cannot initialize a reconnect out of the websocket thread. Use reconnect in another thread to insure a successful cleanup.");
        }
        try {
            closeBlocking();
            Thread thread = this.writeThread;
            if (thread != null) {
                thread.interrupt();
                this.writeThread = null;
            }
            Thread thread2 = this.connectReadThread;
            if (thread2 != null) {
                thread2.interrupt();
                this.connectReadThread = null;
            }
            this.draft.iIi1();
            Socket socket = this.socket;
            if (socket != null) {
                socket.close();
                this.socket = null;
            }
            this.connectLatch = new CountDownLatch(1);
            this.closeLatch = new CountDownLatch(1);
            this.engine = new IL(this, this.draft);
        } catch (Exception e) {
            onError(e);
            this.engine.Ilil(MysqlErrorNumbers.ER_CANT_CREATE_DB, e.getMessage());
        }
    }

    private void sendHandshake() throws iILLL1 {
        String rawPath = this.uri.getRawPath();
        String rawQuery = this.uri.getRawQuery();
        if (rawPath == null || rawPath.length() == 0) {
            rawPath = "/";
        }
        if (rawQuery != null) {
            rawPath = rawPath + '?' + rawQuery;
        }
        int port = getPort();
        StringBuilder sb = new StringBuilder();
        sb.append(this.uri.getHost());
        sb.append((port == 80 || port == 443) ? BuildConfig.FLAVOR : ":" + port);
        String string = sb.toString();
        p051lLi1LL.I1I.p057lIiI.IL il = new p051lLi1LL.I1I.p057lIiI.IL();
        il.mo3594iILLL1(rawPath);
        il.I1I("Host", string);
        Map<String, String> map = this.headers;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                il.I1I(entry.getKey(), entry.getValue());
            }
        }
        this.engine.m3517LIll(il);
    }

    public void addHeader(String str, String str2) {
        if (this.headers == null) {
            this.headers = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        }
        this.headers.put(str, str2);
    }

    public void clearHeaders() {
        this.headers = null;
    }

    public void close() {
        if (this.writeThread != null) {
            this.engine.IL1Iii(1000);
        }
    }

    public void closeBlocking() throws InterruptedException {
        close();
        this.closeLatch.await();
    }

    public void closeConnection(int i, String str) {
        this.engine.Ilil(i, str);
    }

    public void connect() {
        if (this.connectReadThread != null) {
            throw new IllegalStateException("WebSocketClient objects are not reuseable");
        }
        Thread thread = new Thread(this);
        this.connectReadThread = thread;
        thread.setName("WebSocketConnectReadThread-" + this.connectReadThread.getId());
        this.connectReadThread.start();
    }

    public boolean connectBlocking() throws InterruptedException {
        connect();
        this.connectLatch.await();
        return this.engine.m3526lIII();
    }

    public <T> T getAttachment() {
        return (T) this.engine.LlLI1();
    }

    public p051lLi1LL.I1I.ILil getConnection() {
        return this.engine;
    }

    @Override // p051lLi1LL.I1I.IL1Iii
    public Collection<p051lLi1LL.I1I.ILil> getConnections() {
        return Collections.singletonList(this.engine);
    }

    public p051lLi1LL.I1I.p053IiL.IL1Iii getDraft() {
        return this.draft;
    }

    @Override // p051lLi1LL.I1I.lLi1LL
    public InetSocketAddress getLocalSocketAddress(p051lLi1LL.I1I.ILil iLil) {
        Socket socket = this.socket;
        if (socket != null) {
            return (InetSocketAddress) socket.getLocalSocketAddress();
        }
        return null;
    }

    public p051lLi1LL.I1I.p055L11I.IL getReadyState() {
        return this.engine.iIi1();
    }

    @Override // p051lLi1LL.I1I.lLi1LL
    public InetSocketAddress getRemoteSocketAddress(p051lLi1LL.I1I.ILil iLil) {
        Socket socket = this.socket;
        if (socket != null) {
            return (InetSocketAddress) socket.getRemoteSocketAddress();
        }
        return null;
    }

    public String getResourceDescriptor() {
        return this.uri.getPath();
    }

    public SSLSession getSSLSession() {
        return this.engine.I11li1();
    }

    public Socket getSocket() {
        return this.socket;
    }

    public URI getURI() {
        return this.uri;
    }

    public boolean hasBufferedData() {
        return this.engine.I11L();
    }

    public boolean hasSSLSupport() {
        return this.engine.llliI();
    }

    public boolean isClosed() {
        return this.engine.m3533l();
    }

    public boolean isClosing() {
        return this.engine.m35351();
    }

    public boolean isFlushAndClose() {
        return this.engine.m3521LlLLL();
    }

    public boolean isOpen() {
        return this.engine.m3526lIII();
    }

    public abstract void onClose(int i, String str, boolean z);

    public void onCloseInitiated(int i, String str) {
    }

    public void onClosing(int i, String str, boolean z) {
    }

    public abstract void onError(Exception exc);

    public abstract void onMessage(String str);

    public void onMessage(ByteBuffer byteBuffer) {
    }

    public abstract void onOpen(L11I l11i);

    public void onSetSSLParameters(SSLParameters sSLParameters) {
        sSLParameters.setEndpointIdentificationAlgorithm("HTTPS");
    }

    @Override // p051lLi1LL.I1I.lLi1LL
    public final void onWebsocketClose(p051lLi1LL.I1I.ILil iLil, int i, String str, boolean z) {
        stopConnectionLostTimer();
        Thread thread = this.writeThread;
        if (thread != null) {
            thread.interrupt();
        }
        onClose(i, str, z);
        this.connectLatch.countDown();
        this.closeLatch.countDown();
    }

    @Override // p051lLi1LL.I1I.lLi1LL
    public void onWebsocketCloseInitiated(p051lLi1LL.I1I.ILil iLil, int i, String str) {
        onCloseInitiated(i, str);
    }

    @Override // p051lLi1LL.I1I.lLi1LL
    public void onWebsocketClosing(p051lLi1LL.I1I.ILil iLil, int i, String str, boolean z) {
        onClosing(i, str, z);
    }

    @Override // p051lLi1LL.I1I.lLi1LL
    public final void onWebsocketError(p051lLi1LL.I1I.ILil iLil, Exception exc) {
        onError(exc);
    }

    @Override // p051lLi1LL.I1I.lLi1LL
    public final void onWebsocketMessage(p051lLi1LL.I1I.ILil iLil, String str) {
        onMessage(str);
    }

    @Override // p051lLi1LL.I1I.lLi1LL
    public final void onWebsocketOpen(p051lLi1LL.I1I.ILil iLil, p051lLi1LL.I1I.p057lIiI.iILLL1 iilll1) {
        startConnectionLostTimer();
        onOpen((L11I) iilll1);
        this.connectLatch.countDown();
    }

    @Override // p051lLi1LL.I1I.lLi1LL
    public final void onWriteDemand(p051lLi1LL.I1I.ILil iLil) {
    }

    public void reconnect() {
        reset();
        connect();
    }

    public boolean reconnectBlocking() throws InterruptedException {
        reset();
        return connectBlocking();
    }

    public String removeHeader(String str) {
        Map<String, String> map = this.headers;
        if (map == null) {
            return null;
        }
        return map.remove(str);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003e A[Catch: InternalError -> 0x00fb, Exception -> 0x012a, TryCatch #4 {Exception -> 0x012a, InternalError -> 0x00fb, blocks: (B:3:0x0001, B:5:0x0007, B:12:0x0024, B:14:0x003e, B:17:0x0059, B:19:0x0067, B:20:0x0086, B:22:0x008c, B:23:0x0098, B:6:0x000e, B:8:0x0012, B:9:0x001d, B:40:0x00f5, B:41:0x00fa), top: B:53:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x008c A[Catch: InternalError -> 0x00fb, Exception -> 0x012a, TryCatch #4 {Exception -> 0x012a, InternalError -> 0x00fb, blocks: (B:3:0x0001, B:5:0x0007, B:12:0x0024, B:14:0x003e, B:17:0x0059, B:19:0x0067, B:20:0x0086, B:22:0x008c, B:23:0x0098, B:6:0x000e, B:8:0x0012, B:9:0x001d, B:40:0x00f5, B:41:0x00fa), top: B:53:0x0001 }] */
    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Socket socket;
        byte[] bArr;
        int i;
        try {
            SocketFactory socketFactory = this.socketFactory;
            if (socketFactory == null) {
                Socket socket2 = this.socket;
                if (socket2 == null) {
                    this.socket = new Socket(this.proxy);
                    z = true;
                } else if (socket2.isClosed()) {
                    throw new IOException();
                }
                this.socket.setTcpNoDelay(isTcpNoDelay());
                this.socket.setReuseAddress(isReuseAddr());
                if (!this.socket.isConnected()) {
                    this.socket.connect(new InetSocketAddress(this.dnsResolver.IL1Iii(this.uri), getPort()), this.connectTimeout);
                }
                if (z && "wss".equals(this.uri.getScheme())) {
                    SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
                    sSLContext.init(null, null, null);
                    this.socket = sSLContext.getSocketFactory().createSocket(this.socket, this.uri.getHost(), getPort(), true);
                }
                socket = this.socket;
                if (socket instanceof SSLSocket) {
                    SSLSocket sSLSocket = (SSLSocket) socket;
                    SSLParameters sSLParameters = sSLSocket.getSSLParameters();
                    onSetSSLParameters(sSLParameters);
                    sSLSocket.setSSLParameters(sSLParameters);
                }
                InputStream inputStream = this.socket.getInputStream();
                this.ostream = this.socket.getOutputStream();
                sendHandshake();
                Thread thread = new Thread(new RunnableC0597ILil(this));
                this.writeThread = thread;
                thread.start();
                bArr = new byte[16384];
                while (!isClosing() && !isClosed() && (i = inputStream.read(bArr)) != -1) {
                    try {
                        this.engine.m3531il(ByteBuffer.wrap(bArr, 0, i));
                    } catch (IOException e) {
                        handleIOException(e);
                    } catch (RuntimeException e2) {
                        onError(e2);
                        this.engine.Ilil(MysqlErrorNumbers.ER_CANT_CREATE_DB, e2.getMessage());
                    }
                }
                this.engine.m3525lIiI();
                this.connectReadThread = null;
            }
            this.socket = socketFactory.createSocket();
            z = false;
            this.socket.setTcpNoDelay(isTcpNoDelay());
            this.socket.setReuseAddress(isReuseAddr());
            if (!this.socket.isConnected()) {
                this.socket.connect(new InetSocketAddress(this.dnsResolver.IL1Iii(this.uri), getPort()), this.connectTimeout);
            }
            if (z) {
                SSLContext sSLContext2 = SSLContext.getInstance("TLSv1.2");
                sSLContext2.init(null, null, null);
                this.socket = sSLContext2.getSocketFactory().createSocket(this.socket, this.uri.getHost(), getPort(), true);
            }
            socket = this.socket;
            if (socket instanceof SSLSocket) {
                SSLSocket sSLSocket2 = (SSLSocket) socket;
                SSLParameters sSLParameters2 = sSLSocket2.getSSLParameters();
                onSetSSLParameters(sSLParameters2);
                sSLSocket2.setSSLParameters(sSLParameters2);
            }
            InputStream inputStream2 = this.socket.getInputStream();
            this.ostream = this.socket.getOutputStream();
            sendHandshake();
            Thread thread2 = new Thread(new RunnableC0597ILil(this));
            this.writeThread = thread2;
            thread2.start();
            bArr = new byte[16384];
            while (!isClosing()) {
                this.engine.m3531il(ByteBuffer.wrap(bArr, 0, i));
            }
            this.engine.m3525lIiI();
            this.connectReadThread = null;
        } catch (Exception e3) {
            onWebsocketError(this.engine, e3);
            this.engine.Ilil(-1, e3.getMessage());
        } catch (InternalError e4) {
            if (!(e4.getCause() instanceof InvocationTargetException) || !(e4.getCause().getCause() instanceof IOException)) {
                throw e4;
            }
            IOException iOException = (IOException) e4.getCause().getCause();
            onWebsocketError(this.engine, iOException);
            this.engine.Ilil(-1, iOException.getMessage());
        }
    }

    public void send(String str) {
        this.engine.m3516L111(str);
    }

    public void sendFragmentedFrame(I1I i1i, ByteBuffer byteBuffer, boolean z) {
        this.engine.m3524l1IIi1(i1i, byteBuffer, z);
    }

    @Override // p051lLi1LL.I1I.ILil
    public void sendFrame(p051lLi1LL.I1I.p054Ll1.iILLL1 iilll1) {
        this.engine.sendFrame(iilll1);
    }

    public void sendPing() {
        this.engine.m3530iILLl();
    }

    public <T> void setAttachment(T t) {
        this.engine.m3512IIi(t);
    }

    public void setDnsResolver(p051lLi1LL.I1I.p056iILLL1.IL1Iii iL1Iii) {
        this.dnsResolver = iL1Iii;
    }

    public void setProxy(Proxy proxy) {
        if (proxy == null) {
            throw new IllegalArgumentException();
        }
        this.proxy = proxy;
    }

    @Deprecated
    public void setSocket(Socket socket) {
        if (this.socket != null) {
            throw new IllegalStateException("socket has already been set");
        }
        this.socket = socket;
    }

    public void setSocketFactory(SocketFactory socketFactory) {
        this.socketFactory = socketFactory;
    }

    public ILil(URI uri, p051lLi1LL.I1I.p053IiL.IL1Iii iL1Iii) {
        this(uri, iL1Iii, null, 0);
    }

    @Override // p051lLi1LL.I1I.lLi1LL
    public final void onWebsocketMessage(p051lLi1LL.I1I.ILil iLil, ByteBuffer byteBuffer) {
        onMessage(byteBuffer);
    }

    public void send(byte[] bArr) {
        this.engine.llI(bArr);
    }

    public void sendFrame(Collection<p051lLi1LL.I1I.p054Ll1.iILLL1> collection) {
        this.engine.m3519L1l(collection);
    }

    public ILil(URI uri, Map<String, String> map) {
        this(uri, new p051lLi1LL.I1I.p053IiL.ILil(), map);
    }

    public void close(int i) {
        this.engine.IL1Iii(i);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.engine.m3527lIlii();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.engine.iIlLiL();
    }

    public void send(ByteBuffer byteBuffer) {
        this.engine.m3534LLlI1(byteBuffer);
    }

    public ILil(URI uri, p051lLi1LL.I1I.p053IiL.IL1Iii iL1Iii, Map<String, String> map) {
        this(uri, iL1Iii, map, 0);
    }

    public void close(int i, String str) {
        this.engine.ILil(i, str);
    }

    public boolean connectBlocking(long j, TimeUnit timeUnit) throws InterruptedException {
        connect();
        return this.connectLatch.await(j, timeUnit) && this.engine.m3526lIII();
    }

    public ILil(URI uri, p051lLi1LL.I1I.p053IiL.IL1Iii iL1Iii, Map<String, String> map, int i) {
        this.uri = null;
        this.engine = null;
        this.socket = null;
        this.socketFactory = null;
        this.proxy = Proxy.NO_PROXY;
        this.connectLatch = new CountDownLatch(1);
        this.closeLatch = new CountDownLatch(1);
        this.connectTimeout = 0;
        this.dnsResolver = null;
        if (uri == null) {
            throw new IllegalArgumentException();
        }
        if (iL1Iii != null) {
            this.uri = uri;
            this.draft = iL1Iii;
            this.dnsResolver = new IL1Iii(this);
            if (map != null) {
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                this.headers = treeMap;
                treeMap.putAll(map);
            }
            this.connectTimeout = i;
            setTcpNoDelay(false);
            setReuseAddr(false);
            this.engine = new IL(this, iL1Iii);
            return;
        }
        throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }
}
