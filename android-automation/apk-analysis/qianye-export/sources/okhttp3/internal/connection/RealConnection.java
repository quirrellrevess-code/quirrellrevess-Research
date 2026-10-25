package okhttp3.internal.connection;

import androidx.recyclerview.widget.RecyclerView;
import com.mysql.jdbc.CharsetMapping;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.p006ws.RealWebSocket;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import p047IL.C0007;
import p047IL.C0655ill;
import p047IL.C0656lIII;
import p047IL.C1;
import p047IL.IIi;
import p047IL.ILL;
import p047IL.L1l;
import p047IL.LL1IL;
import p047IL.LlLI1;
import p047IL.lIlii;
import p047IL.llI;
import p047IL.llliI;
import p066Ilil.IL;
import p066Ilil.lIiI;
import p066Ilil.lL;
import p066Ilil.lLi1LL;

/* JADX INFO: loaded from: classes.dex */
public final class RealConnection extends Http2Connection.Listener implements LlLI1 {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    public final RealConnectionPool connectionPool;
    private C1 handshake;
    private Http2Connection http2Connection;
    public boolean noNewExchanges;
    private llI protocol;
    private Socket rawSocket;
    private int refusedStreamCount;
    private final C0655ill route;
    public int routeFailureCount;
    private IL sink;
    private Socket socket;
    private lLi1LL source;
    public int successCount;
    private int allocationLimit = 1;
    public final List<Reference<Transmitter>> transmitters = new ArrayList();
    public long idleAtNanos = RecyclerView.FOREVER_NS;

    public RealConnection(RealConnectionPool realConnectionPool, C0655ill c0655ill) {
        this.connectionPool = realConnectionPool;
        this.route = c0655ill;
    }

    private void connectSocket(int i, int i2, ILL ill, llliI lllii) throws IOException {
        Proxy proxyILil = this.route.ILil();
        this.rawSocket = (proxyILil.type() == Proxy.Type.DIRECT || proxyILil.type() == Proxy.Type.HTTP) ? this.route.IL1Iii().m2956il().createSocket() : new Socket(proxyILil);
        lllii.m2947lLi1LL(ill, this.route.m2897IL(), proxyILil);
        this.rawSocket.setSoTimeout(i2);
        try {
            Platform.get().connectSocket(this.rawSocket, this.route.m2897IL(), i);
            try {
                this.source = lIiI.m2826IL(lIiI.m2831lIiI(this.rawSocket));
                this.sink = lIiI.I1I(lIiI.m2829L11I(this.rawSocket));
            } catch (NullPointerException e) {
                if (NPE_THROW_WITH_NULL.equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.route.m2897IL());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void connectTls(ConnectionSpecSelector connectionSpecSelector) throws Throwable {
        p047IL.lLi1LL lli1llIL1Iii = this.route.IL1Iii();
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) lli1llIL1Iii.ILL().createSocket(this.rawSocket, lli1llIL1Iii.m2952Ll1().m2911lIiI(), lli1llIL1Iii.m2952Ll1().m2918l(), true);
                try {
                    lIlii liliiConfigureSecureSocket = connectionSpecSelector.configureSecureSocket(sSLSocket2);
                    if (liliiConfigureSecureSocket.m2935lLi1LL()) {
                        Platform.get().configureTlsExtensions(sSLSocket2, lli1llIL1Iii.m2952Ll1().m2911lIiI(), lli1llIL1Iii.m2955lLi1LL());
                    }
                    sSLSocket2.startHandshake();
                    SSLSession session = sSLSocket2.getSession();
                    C1 c1ILil = C1.ILil(session);
                    if (lli1llIL1Iii.Ilil().verify(lli1llIL1Iii.m2952Ll1().m2911lIiI(), session)) {
                        lli1llIL1Iii.IL1Iii().IL1Iii(lli1llIL1Iii.m2952Ll1().m2911lIiI(), c1ILil.m2983IL());
                        String selectedProtocol = liliiConfigureSecureSocket.m2935lLi1LL() ? Platform.get().getSelectedProtocol(sSLSocket2) : null;
                        this.socket = sSLSocket2;
                        this.source = lIiI.m2826IL(lIiI.m2831lIiI(sSLSocket2));
                        this.sink = lIiI.I1I(lIiI.m2829L11I(this.socket));
                        this.handshake = c1ILil;
                        this.protocol = selectedProtocol != null ? llI.get(selectedProtocol) : llI.HTTP_1_1;
                        if (sSLSocket2 != null) {
                            Platform.get().afterHandshake(sSLSocket2);
                            return;
                        }
                        return;
                    }
                    List<Certificate> listM2983IL = c1ILil.m2983IL();
                    if (listM2983IL.isEmpty()) {
                        throw new SSLPeerUnverifiedException("Hostname " + lli1llIL1Iii.m2952Ll1().m2911lIiI() + " not verified (no certificates)");
                    }
                    X509Certificate x509Certificate = (X509Certificate) listM2983IL.get(0);
                    throw new SSLPeerUnverifiedException("Hostname " + lli1llIL1Iii.m2952Ll1().m2911lIiI() + " not verified:\n    certificate: " + p047IL.lIiI.I1I(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + OkHostnameVerifier.allSubjectAltNames(x509Certificate));
                } catch (AssertionError e) {
                    e = e;
                    if (!Util.isAndroidGetsocknameError(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        Platform.get().afterHandshake(sSLSocket);
                    }
                    Util.closeQuietly((Socket) sSLSocket);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (AssertionError e2) {
            e = e2;
        }
    }

    private void connectTunnel(int i, int i2, int i3, ILL ill, llliI lllii) throws IOException {
        L1l l1lCreateTunnelRequest = createTunnelRequest();
        C0656lIII c0656lIIIM2875il = l1lCreateTunnelRequest.m2875il();
        for (int i4 = 0; i4 < 21; i4++) {
            connectSocket(i, i2, ill, lllii);
            l1lCreateTunnelRequest = createTunnel(i2, i3, l1lCreateTunnelRequest, c0656lIIIM2875il);
            if (l1lCreateTunnelRequest == null) {
                return;
            }
            Util.closeQuietly(this.rawSocket);
            this.rawSocket = null;
            this.sink = null;
            this.source = null;
            lllii.m2940IL(ill, this.route.m2897IL(), this.route.ILil(), null);
        }
    }

    private L1l createTunnel(int i, int i2, L1l l1l, C0656lIII c0656lIII) throws IOException {
        String str = "CONNECT " + Util.hostHeader(c0656lIII, true) + " HTTP/1.1";
        while (true) {
            Http1ExchangeCodec http1ExchangeCodec = new Http1ExchangeCodec(null, null, this.source, this.sink);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.source.timeout().timeout(i, timeUnit);
            this.sink.timeout().timeout(i2, timeUnit);
            http1ExchangeCodec.writeRequest(l1l.Ilil(), str);
            http1ExchangeCodec.finishRequest();
            IIi.IL1Iii responseHeaders = http1ExchangeCodec.readResponseHeaders(false);
            responseHeaders.m2863llL1ii(l1l);
            IIi iIiI1I = responseHeaders.I1I();
            http1ExchangeCodec.skipConnectBody(iIiI1I);
            int iM2847L11 = iIiI1I.m2847L11();
            if (iM2847L11 == 200) {
                if (this.source.mo2806il().ILL() && this.sink.IL1Iii().ILL()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iM2847L11 != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + iIiI1I.m2847L11());
            }
            L1l l1lIL1Iii = this.route.IL1Iii().m2951IiL().IL1Iii(this.route, iIiI1I);
            if (l1lIL1Iii == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if ("close".equalsIgnoreCase(iIiI1I.m2844IIiI("Connection"))) {
                return l1lIL1Iii;
            }
            l1l = l1lIL1Iii;
        }
    }

    private L1l createTunnelRequest() throws IOException {
        L1l.IL1Iii iL1Iii = new L1l.IL1Iii();
        iL1Iii.m2881il(this.route.IL1Iii().m2952Ll1());
        iL1Iii.Ilil("CONNECT", null);
        iL1Iii.I1I("Host", Util.hostHeader(this.route.IL1Iii().m2952Ll1(), true));
        iL1Iii.I1I("Proxy-Connection", "Keep-Alive");
        iL1Iii.I1I("User-Agent", Version.userAgent());
        L1l l1lILil = iL1Iii.ILil();
        IIi.IL1Iii iL1Iii2 = new IIi.IL1Iii();
        iL1Iii2.m2863llL1ii(l1lILil);
        iL1Iii2.Lil(llI.HTTP_1_1);
        iL1Iii2.m2860iILLL1(407);
        iL1Iii2.m2858Ll1("Preemptive Authenticate");
        iL1Iii2.ILil(Util.EMPTY_RESPONSE);
        iL1Iii2.m2862lIlii(-1L);
        iL1Iii2.LlLI1(-1L);
        iL1Iii2.m2859L11I("Proxy-Authenticate", "OkHttp-Preemptive");
        L1l l1lIL1Iii = this.route.IL1Iii().m2951IiL().IL1Iii(this.route, iL1Iii2.I1I());
        return l1lIL1Iii != null ? l1lIL1Iii : l1lILil;
    }

    private void establishProtocol(ConnectionSpecSelector connectionSpecSelector, int i, ILL ill, llliI lllii) throws Throwable {
        if (this.route.IL1Iii().ILL() != null) {
            lllii.llliI(ill);
            connectTls(connectionSpecSelector);
            lllii.I11L(ill, this.handshake);
            if (this.protocol == llI.HTTP_2) {
                startHttp2(i);
                return;
            }
            return;
        }
        List<llI> listM2955lLi1LL = this.route.IL1Iii().m2955lLi1LL();
        llI lli = llI.H2_PRIOR_KNOWLEDGE;
        if (!listM2955lLi1LL.contains(lli)) {
            this.socket = this.rawSocket;
            this.protocol = llI.HTTP_1_1;
        } else {
            this.socket = this.rawSocket;
            this.protocol = lli;
            startHttp2(i);
        }
    }

    private boolean routeMatchesAny(List<C0655ill> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C0655ill c0655ill = list.get(i);
            if (c0655ill.ILil().type() == Proxy.Type.DIRECT && this.route.ILil().type() == Proxy.Type.DIRECT && this.route.m2897IL().equals(c0655ill.m2897IL())) {
                return true;
            }
        }
        return false;
    }

    private void startHttp2(int i) throws IOException {
        this.socket.setSoTimeout(0);
        Http2Connection http2ConnectionBuild = new Http2Connection.Builder(true).socket(this.socket, this.route.IL1Iii().m2952Ll1().m2911lIiI(), this.source, this.sink).listener(this).pingIntervalMillis(i).build();
        this.http2Connection = http2ConnectionBuild;
        http2ConnectionBuild.start();
    }

    public static RealConnection testConnection(RealConnectionPool realConnectionPool, C0655ill c0655ill, Socket socket, long j) {
        RealConnection realConnection = new RealConnection(realConnectionPool, c0655ill);
        realConnection.socket = socket;
        realConnection.idleAtNanos = j;
        return realConnection;
    }

    public void cancel() {
        Util.closeQuietly(this.rawSocket);
    }

    /* JADX WARN: Code duplicated, block: B:55:0x012f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0135  */
    /* JADX WARN: Code duplicated, block: B:58:0x013a  */
    /* JADX WARN: Code duplicated, block: B:76:0x0142 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x0142 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:? A[LOOP:0: B:66:0x0088->B:78:?, LOOP_END, SYNTHETIC] */
    public void connect(int i, int i2, int i3, int i4, boolean z, ILL ill, llliI lllii) throws Throwable {
        if (this.protocol != null) {
            throw new IllegalStateException("already connected");
        }
        List<lIlii> listILil = this.route.IL1Iii().ILil();
        ConnectionSpecSelector connectionSpecSelector = new ConnectionSpecSelector(listILil);
        if (this.route.IL1Iii().ILL() == null) {
            if (!listILil.contains(lIlii.f2128IiL)) {
                throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String strM2911lIiI = this.route.IL1Iii().m2952Ll1().m2911lIiI();
            if (!Platform.get().isCleartextTrafficPermitted(strM2911lIiI)) {
                throw new RouteException(new UnknownServiceException("CLEARTEXT communication to " + strM2911lIiI + " not permitted by network security policy"));
            }
        } else if (this.route.IL1Iii().m2955lLi1LL().contains(llI.H2_PRIOR_KNOWLEDGE)) {
            throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        RouteException routeException = null;
        while (true) {
            try {
                if (this.route.I1I()) {
                    connectTunnel(i, i2, i3, ill, lllii);
                    if (this.rawSocket == null) {
                        break;
                    }
                } else {
                    try {
                        connectSocket(i, i2, ill, lllii);
                    } catch (IOException e) {
                        e = e;
                        Util.closeQuietly(this.socket);
                        Util.closeQuietly(this.rawSocket);
                        this.socket = null;
                        this.rawSocket = null;
                        this.source = null;
                        this.sink = null;
                        this.handshake = null;
                        this.protocol = null;
                        this.http2Connection = null;
                        lllii.Ilil(ill, this.route.m2897IL(), this.route.ILil(), null, e);
                        if (routeException == null) {
                            routeException = new RouteException(e);
                        } else {
                            routeException.addConnectException(e);
                        }
                        if (z) {
                            throw routeException;
                        }
                        if (connectionSpecSelector.connectionFailed(e)) {
                            throw routeException;
                        }
                    }
                }
                try {
                    establishProtocol(connectionSpecSelector, i4, ill, lllii);
                    lllii.m2940IL(ill, this.route.m2897IL(), this.route.ILil(), this.protocol);
                    break;
                } catch (IOException e2) {
                    e = e2;
                    Util.closeQuietly(this.socket);
                    Util.closeQuietly(this.rawSocket);
                    this.socket = null;
                    this.rawSocket = null;
                    this.source = null;
                    this.sink = null;
                    this.handshake = null;
                    this.protocol = null;
                    this.http2Connection = null;
                    lllii.Ilil(ill, this.route.m2897IL(), this.route.ILil(), null, e);
                    if (routeException == null) {
                        routeException = new RouteException(e);
                    } else {
                        routeException.addConnectException(e);
                    }
                    if (z) {
                        throw routeException;
                    }
                    if (connectionSpecSelector.connectionFailed(e)) {
                        throw routeException;
                    }
                }
            } catch (IOException e3) {
                e = e3;
            }
        }
        if (this.route.I1I() && this.rawSocket == null) {
            throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
        }
        if (this.http2Connection != null) {
            synchronized (this.connectionPool) {
                this.allocationLimit = this.http2Connection.maxConcurrentStreams();
            }
        }
    }

    public C1 handshake() {
        return this.handshake;
    }

    public boolean isEligible(p047IL.lLi1LL lli1ll, @Nullable List<C0655ill> list) {
        if (this.transmitters.size() >= this.allocationLimit || this.noNewExchanges || !Internal.instance.equalsNonHost(this.route.IL1Iii(), lli1ll)) {
            return false;
        }
        if (lli1ll.m2952Ll1().m2911lIiI().equals(route().IL1Iii().m2952Ll1().m2911lIiI())) {
            return true;
        }
        if (this.http2Connection == null || list == null || !routeMatchesAny(list) || lli1ll.Ilil() != OkHostnameVerifier.INSTANCE || !supportsUrl(lli1ll.m2952Ll1())) {
            return false;
        }
        try {
            lli1ll.IL1Iii().IL1Iii(lli1ll.m2952Ll1().m2911lIiI(), handshake().m2983IL());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean isHealthy(boolean z) {
        if (this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.http2Connection;
        if (http2Connection != null) {
            return http2Connection.isHealthy(System.nanoTime());
        }
        if (z) {
            try {
                int soTimeout = this.socket.getSoTimeout();
                try {
                    this.socket.setSoTimeout(1);
                    if (this.source.ILL()) {
                        this.socket.setSoTimeout(soTimeout);
                        return false;
                    }
                    this.socket.setSoTimeout(soTimeout);
                    return true;
                } catch (Throwable th) {
                    this.socket.setSoTimeout(soTimeout);
                    throw th;
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    public boolean isMultiplexed() {
        return this.http2Connection != null;
    }

    public ExchangeCodec newCodec(C0007 c0007, LL1IL.IL1Iii iL1Iii) throws SocketException {
        if (this.http2Connection != null) {
            return new Http2ExchangeCodec(c0007, this, iL1Iii, this.http2Connection);
        }
        this.socket.setSoTimeout(iL1Iii.readTimeoutMillis());
        lL lLVarTimeout = this.source.timeout();
        long timeoutMillis = iL1Iii.readTimeoutMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        lLVarTimeout.timeout(timeoutMillis, timeUnit);
        this.sink.timeout().timeout(iL1Iii.writeTimeoutMillis(), timeUnit);
        return new Http1ExchangeCodec(c0007, this, this.source, this.sink);
    }

    public RealWebSocket.Streams newWebSocketStreams(final Exchange exchange) throws SocketException {
        this.socket.setSoTimeout(0);
        noNewExchanges();
        return new RealWebSocket.Streams(true, this.source, this.sink) { // from class: okhttp3.internal.connection.RealConnection.1
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                exchange.bodyComplete(-1L, true, true, null);
            }
        };
    }

    public void noNewExchanges() {
        synchronized (this.connectionPool) {
            this.noNewExchanges = true;
        }
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onSettings(Http2Connection http2Connection) {
        synchronized (this.connectionPool) {
            this.allocationLimit = http2Connection.maxConcurrentStreams();
        }
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onStream(Http2Stream http2Stream) throws IOException {
        http2Stream.close(ErrorCode.REFUSED_STREAM, null);
    }

    public llI protocol() {
        return this.protocol;
    }

    public C0655ill route() {
        return this.route;
    }

    public Socket socket() {
        return this.socket;
    }

    public boolean supportsUrl(C0656lIII c0656lIII) {
        if (c0656lIII.m2918l() != this.route.IL1Iii().m2952Ll1().m2918l()) {
            return false;
        }
        if (c0656lIII.m2911lIiI().equals(this.route.IL1Iii().m2952Ll1().m2911lIiI())) {
            return true;
        }
        return this.handshake != null && OkHostnameVerifier.INSTANCE.verify(c0656lIII.m2911lIiI(), (X509Certificate) this.handshake.m2983IL().get(0));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.route.IL1Iii().m2952Ll1().m2911lIiI());
        sb.append(":");
        sb.append(this.route.IL1Iii().m2952Ll1().m2918l());
        sb.append(", proxy=");
        sb.append(this.route.ILil());
        sb.append(" hostAddress=");
        sb.append(this.route.m2897IL());
        sb.append(" cipherSuite=");
        C1 c1 = this.handshake;
        sb.append(c1 != null ? c1.IL1Iii() : CharsetMapping.COLLATION_NOT_DEFINED);
        sb.append(" protocol=");
        sb.append(this.protocol);
        sb.append('}');
        return sb.toString();
    }

    public void trackFailure(@Nullable IOException iOException) {
        synchronized (this.connectionPool) {
            if (iOException instanceof StreamResetException) {
                ErrorCode errorCode = ((StreamResetException) iOException).errorCode;
                if (errorCode == ErrorCode.REFUSED_STREAM) {
                    int i = this.refusedStreamCount + 1;
                    this.refusedStreamCount = i;
                    if (i > 1) {
                        this.noNewExchanges = true;
                        this.routeFailureCount++;
                    }
                } else if (errorCode != ErrorCode.CANCEL) {
                    this.noNewExchanges = true;
                    this.routeFailureCount++;
                }
            } else if (!isMultiplexed() || (iOException instanceof ConnectionShutdownException)) {
                this.noNewExchanges = true;
                if (this.successCount == 0) {
                    if (iOException != null) {
                        this.connectionPool.connectFailed(this.route, iOException);
                    }
                    this.routeFailureCount++;
                }
            }
        }
    }
}
