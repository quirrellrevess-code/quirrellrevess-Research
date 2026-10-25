package p047IL;

import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealConnectionPool;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;

/* JADX INFO: renamed from: I丨L.丨丨 */
/* JADX INFO: compiled from: OkHttpClient.java */
/* JADX INFO: loaded from: classes.dex */
public class C0007 implements Cloneable, ILL.IL1Iii {

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public static final List<llI> f2152L111 = Util.immutableList(llI.HTTP_2, llI.HTTP_1_1);

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public static final List<lIlii> f2153LLlI1 = Util.immutableList(lIlii.f2129iILLL1, lIlii.f2128IiL);
    public final boolean I11L;
    public final I11L I11li1;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    @Nullable
    public final Proxy f4710I1I;

    @Nullable
    public final L11I ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final I11li1 f4711ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final SSLSocketFactory f2154ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final List<lIlii> f4712Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final List<llI> f2155IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final llliI.ILil f2156IiL;
    public final int LL1IL;
    public final CertificateChainCleaner Lil;
    public final HostnameVerifier LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    @Nullable
    public final InternalCache f2157Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final ProxySelector f2158L11I;

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public final int f2159LlLLL;
    public final IiL iIi1;
    public final llL1ii iIlLiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final List<LL1IL> f2160iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final SocketFactory f2161lIiI;

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public final int f2162lIII;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public final IiL f2163lIlii;
    public final boolean llliI;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public final lIiI f2164llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final List<LL1IL> f2165lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final iIlLiL f2166il;

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public final boolean f2167lL;

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public final int f2168l;

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public final int f21691;

    /* JADX INFO: renamed from: I丨L.丨丨$IL1Iii */
    /* JADX INFO: compiled from: OkHttpClient.java */
    public class IL1Iii extends Internal {
        @Override // okhttp3.internal.Internal
        public void addLenient(LlLLL.IL1Iii iL1Iii, String str) {
            iL1Iii.I1I(str);
        }

        @Override // okhttp3.internal.Internal
        public void apply(lIlii lilii, SSLSocket sSLSocket, boolean z) {
            lilii.IL1Iii(sSLSocket, z);
        }

        @Override // okhttp3.internal.Internal
        public int code(IIi.IL1Iii iL1Iii) {
            return iL1Iii.f4617I1I;
        }

        @Override // okhttp3.internal.Internal
        public boolean equalsNonHost(lLi1LL lli1ll, lLi1LL lli1ll2) {
            return lli1ll.m2950IL(lli1ll2);
        }

        @Override // okhttp3.internal.Internal
        @Nullable
        public Exchange exchange(IIi iIi) {
            return iIi.f2072ILl;
        }

        @Override // okhttp3.internal.Internal
        public void initExchange(IIi.IL1Iii iL1Iii, Exchange exchange) {
            iL1Iii.ILL(exchange);
        }

        @Override // okhttp3.internal.Internal
        public ILL newWebSocketCall(C0007 c0007, L1l l1l) {
            return l1IIi1.m2898IL(c0007, l1l, true);
        }

        @Override // okhttp3.internal.Internal
        public RealConnectionPool realConnectionPool(llL1ii lll1ii) {
            return lll1ii.f4684IL1Iii;
        }

        @Override // okhttp3.internal.Internal
        public void addLenient(LlLLL.IL1Iii iL1Iii, String str, String str2) {
            iL1Iii.m2888IL(str, str2);
        }
    }

    static {
        Internal.instance = new IL1Iii();
    }

    public C0007() {
        this(new ILil());
    }

    public static SSLSocketFactory iIlLiL(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = Platform.get().getSSLContext();
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw new AssertionError("No System TLS", e);
        }
    }

    @Nullable
    public Proxy I11L() {
        return this.f4710I1I;
    }

    public int I11li1() {
        return this.LL1IL;
    }

    public int I1I() {
        return this.f2168l;
    }

    @Override // I丨L.ILL.IL1Iii
    public ILL IL1Iii(L1l l1l) {
        return l1IIi1.m2898IL(this, l1l, false);
    }

    public I11L ILL() {
        return this.I11li1;
    }

    public IiL ILil() {
        return this.iIi1;
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public boolean m2964ILl() {
        return this.f2167lL;
    }

    public int Ilil() {
        return this.f21691;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public lIiI m2965IL() {
        return this.f2164llL1ii;
    }

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public int m2966L111() {
        return this.f2162lIII;
    }

    public SSLSocketFactory LL1IL() {
        return this.f2154ILl;
    }

    public HostnameVerifier Lil() {
        return this.LlLI1;
    }

    public List<LL1IL> LlLI1() {
        return this.f2165lLi1LL;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public llliI.ILil m2967Ll1() {
        return this.f2156IiL;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public iIlLiL m2968L11I() {
        return this.f2166il;
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public boolean m2969LlLLL() {
        return this.llliI;
    }

    public ILil iIi1() {
        return new ILil(this);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public List<lIlii> m2970iILLL1() {
        return this.f4712Ilil;
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public boolean m2971lIiI() {
        return this.I11L;
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public SocketFactory m2972lIII() {
        return this.f2161lIiI;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public List<LL1IL> m2973lIlii() {
        return this.f2160iILLL1;
    }

    public IiL llliI() {
        return this.f2163lIlii;
    }

    @Nullable
    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public InternalCache m2974llL1ii() {
        L11I l11i = this.ILL;
        return l11i != null ? l11i.f4644ILil : this.f2157Ll1;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public llL1ii m2975lLi1LL() {
        return this.iIlLiL;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public I11li1 m2976il() {
        return this.f4711ILil;
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public List<llI> m2977lL() {
        return this.f2155IL;
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public ProxySelector m2978l() {
        return this.f2158L11I;
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public int m29791() {
        return this.f2159LlLLL;
    }

    public C0007(ILil iLil) {
        boolean z;
        this.f4711ILil = iLil.f4714IL1Iii;
        this.f4710I1I = iLil.f4715ILil;
        this.f2155IL = iLil.f4713I1I;
        List<lIlii> list = iLil.f2171IL;
        this.f4712Ilil = list;
        this.f2165lLi1LL = Util.immutableList(iLil.f4716Ilil);
        this.f2160iILLL1 = Util.immutableList(iLil.f2181lLi1LL);
        this.f2156IiL = iLil.f2176iILLL1;
        this.f2158L11I = iLil.f2172IiL;
        this.f2166il = iLil.f2174L11I;
        L11I l11i = iLil.f2182il;
        this.f2157Ll1 = iLil.ILL;
        this.f2161lIiI = iLil.f2173Ll1;
        Iterator<lIlii> it = list.iterator();
        loop0: while (true) {
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                } else {
                    z = z || it.next().m2933IL();
                }
            }
        }
        SSLSocketFactory sSLSocketFactory = iLil.f2177lIiI;
        if (sSLSocketFactory == null && z) {
            X509TrustManager x509TrustManagerPlatformTrustManager = Util.platformTrustManager();
            this.f2154ILl = iIlLiL(x509TrustManagerPlatformTrustManager);
            this.Lil = CertificateChainCleaner.get(x509TrustManagerPlatformTrustManager);
        } else {
            this.f2154ILl = sSLSocketFactory;
            this.Lil = iLil.f2170ILl;
        }
        if (this.f2154ILl != null) {
            Platform.get().configureSslSocketFactory(this.f2154ILl);
        }
        this.LlLI1 = iLil.Lil;
        this.f2164llL1ii = iLil.LlLI1.m2902lLi1LL(this.Lil);
        this.f2163lIlii = iLil.f2180llL1ii;
        this.iIi1 = iLil.f2179lIlii;
        this.iIlLiL = iLil.iIi1;
        this.I11li1 = iLil.iIlLiL;
        this.f2167lL = iLil.I11li1;
        this.I11L = iLil.f2183lL;
        this.llliI = iLil.I11L;
        this.f2168l = iLil.llliI;
        this.f21691 = iLil.f2184l;
        this.f2159LlLLL = iLil.f21851;
        this.f2162lIII = iLil.f2175LlLLL;
        this.LL1IL = iLil.f2178lIII;
        if (this.f2165lLi1LL.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.f2165lLi1LL);
        }
        if (this.f2160iILLL1.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.f2160iILLL1);
        }
    }

    /* JADX INFO: renamed from: I丨L.丨丨$ILil */
    /* JADX INFO: compiled from: OkHttpClient.java */
    public static final class ILil {
        public boolean I11L;
        public boolean I11li1;

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public List<llI> f4713I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public I11li1 f4714IL1Iii;

        @Nullable
        public InternalCache ILL;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        @Nullable
        public Proxy f4715ILil;

        /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
        @Nullable
        public CertificateChainCleaner f2170ILl;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public final List<LL1IL> f4716Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public List<lIlii> f2171IL;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public ProxySelector f2172IiL;
        public HostnameVerifier Lil;
        public lIiI LlLI1;

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public SocketFactory f2173Ll1;

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public iIlLiL f2174L11I;

        /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
        public int f2175LlLLL;
        public llL1ii iIi1;
        public I11L iIlLiL;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public llliI.ILil f2176iILLL1;

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        @Nullable
        public SSLSocketFactory f2177lIiI;

        /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
        public int f2178lIII;

        /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
        public IiL f2179lIlii;
        public int llliI;

        /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
        public IiL f2180llL1ii;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public final List<LL1IL> f2181lLi1LL;

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        @Nullable
        public L11I f2182il;

        /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
        public boolean f2183lL;

        /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
        public int f2184l;

        /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
        public int f21851;

        public ILil() {
            this.f4716Ilil = new ArrayList();
            this.f2181lLi1LL = new ArrayList();
            this.f4714IL1Iii = new I11li1();
            this.f4713I1I = C0007.f2152L111;
            this.f2171IL = C0007.f2153LLlI1;
            this.f2176iILLL1 = llliI.ILL(llliI.f4683IL1Iii);
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.f2172IiL = proxySelector;
            if (proxySelector == null) {
                this.f2172IiL = new NullProxySelector();
            }
            this.f2174L11I = iIlLiL.f4651IL1Iii;
            this.f2173Ll1 = SocketFactory.getDefault();
            this.Lil = OkHostnameVerifier.INSTANCE;
            this.LlLI1 = lIiI.f4660I1I;
            IiL iiL = IiL.f4622IL1Iii;
            this.f2180llL1ii = iiL;
            this.f2179lIlii = iiL;
            this.iIi1 = new llL1ii();
            this.iIlLiL = I11L.f4599IL1Iii;
            this.I11li1 = true;
            this.f2183lL = true;
            this.I11L = true;
            this.llliI = 0;
            this.f2184l = 10000;
            this.f21851 = 10000;
            this.f2175LlLLL = 10000;
            this.f2178lIII = 0;
        }

        public ILil I1I(llliI lllii) {
            Objects.requireNonNull(lllii, "eventListener == null");
            this.f2176iILLL1 = llliI.ILL(lllii);
            return this;
        }

        public C0007 IL1Iii() {
            return new C0007(this);
        }

        public ILil ILil(long j, TimeUnit timeUnit) {
            this.f2184l = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public ILil Ilil(long j, TimeUnit timeUnit) {
            this.f21851 = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public ILil m2980IL(List<llI> list) {
            ArrayList arrayList = new ArrayList(list);
            llI lli = llI.H2_PRIOR_KNOWLEDGE;
            if (!arrayList.contains(lli) && !arrayList.contains(llI.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + arrayList);
            }
            if (arrayList.contains(lli) && arrayList.size() > 1) {
                throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayList);
            }
            if (arrayList.contains(llI.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
            }
            if (arrayList.contains(null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            }
            arrayList.remove(llI.SPDY_3);
            this.f4713I1I = Collections.unmodifiableList(arrayList);
            return this;
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public ILil m2981lLi1LL(long j, TimeUnit timeUnit) {
            this.f2175LlLLL = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public ILil(C0007 c0007) {
            ArrayList arrayList = new ArrayList();
            this.f4716Ilil = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f2181lLi1LL = arrayList2;
            this.f4714IL1Iii = c0007.f4711ILil;
            this.f4715ILil = c0007.f4710I1I;
            this.f4713I1I = c0007.f2155IL;
            this.f2171IL = c0007.f4712Ilil;
            arrayList.addAll(c0007.f2165lLi1LL);
            arrayList2.addAll(c0007.f2160iILLL1);
            this.f2176iILLL1 = c0007.f2156IiL;
            this.f2172IiL = c0007.f2158L11I;
            this.f2174L11I = c0007.f2166il;
            this.ILL = c0007.f2157Ll1;
            L11I l11i = c0007.ILL;
            this.f2173Ll1 = c0007.f2161lIiI;
            this.f2177lIiI = c0007.f2154ILl;
            this.f2170ILl = c0007.Lil;
            this.Lil = c0007.LlLI1;
            this.LlLI1 = c0007.f2164llL1ii;
            this.f2180llL1ii = c0007.f2163lIlii;
            this.f2179lIlii = c0007.iIi1;
            this.iIi1 = c0007.iIlLiL;
            this.iIlLiL = c0007.I11li1;
            this.I11li1 = c0007.f2167lL;
            this.f2183lL = c0007.I11L;
            this.I11L = c0007.llliI;
            this.llliI = c0007.f2168l;
            this.f2184l = c0007.f21691;
            this.f21851 = c0007.f2159LlLLL;
            this.f2175LlLLL = c0007.f2162lIII;
            this.f2178lIII = c0007.LL1IL;
        }
    }
}
