package p047IL;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.internal.Util;

/* JADX INFO: renamed from: I丨L.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: Address.java */
/* JADX INFO: loaded from: classes.dex */
public final class lLi1LL {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final SocketFactory f4685I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final C0656lIII f4686IL1Iii;

    @Nullable
    public final lIiI ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final I11L f4687ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final List<llI> f4688Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final IiL f2133IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    @Nullable
    public final Proxy f2134IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    @Nullable
    public final SSLSocketFactory f2135L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final ProxySelector f2136iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final List<lIlii> f2137lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    @Nullable
    public final HostnameVerifier f2138il;

    public lLi1LL(String str, int i, I11L i11l, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable lIiI liii, IiL iiL, @Nullable Proxy proxy, List<llI> list, List<lIlii> list2, ProxySelector proxySelector) {
        C0656lIII.IL1Iii iL1Iii = new C0656lIII.IL1Iii();
        iL1Iii.iIi1(sSLSocketFactory != null ? "https" : "http");
        iL1Iii.m2926iILLL1(str);
        iL1Iii.m2922ILl(i);
        this.f4686IL1Iii = iL1Iii.I1I();
        Objects.requireNonNull(i11l, "dns == null");
        this.f4687ILil = i11l;
        Objects.requireNonNull(socketFactory, "socketFactory == null");
        this.f4685I1I = socketFactory;
        Objects.requireNonNull(iiL, "proxyAuthenticator == null");
        this.f2133IL = iiL;
        Objects.requireNonNull(list, "protocols == null");
        this.f4688Ilil = Util.immutableList(list);
        Objects.requireNonNull(list2, "connectionSpecs == null");
        this.f2137lLi1LL = Util.immutableList(list2);
        Objects.requireNonNull(proxySelector, "proxySelector == null");
        this.f2136iILLL1 = proxySelector;
        this.f2134IiL = proxy;
        this.f2135L11I = sSLSocketFactory;
        this.f2138il = hostnameVerifier;
        this.ILL = liii;
    }

    public I11L I1I() {
        return this.f4687ILil;
    }

    @Nullable
    public lIiI IL1Iii() {
        return this.ILL;
    }

    @Nullable
    public SSLSocketFactory ILL() {
        return this.f2135L11I;
    }

    public List<lIlii> ILil() {
        return this.f2137lLi1LL;
    }

    @Nullable
    public HostnameVerifier Ilil() {
        return this.f2138il;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean m2950IL(lLi1LL lli1ll) {
        return this.f4687ILil.equals(lli1ll.f4687ILil) && this.f2133IL.equals(lli1ll.f2133IL) && this.f4688Ilil.equals(lli1ll.f4688Ilil) && this.f2137lLi1LL.equals(lli1ll.f2137lLi1LL) && this.f2136iILLL1.equals(lli1ll.f2136iILLL1) && Objects.equals(this.f2134IiL, lli1ll.f2134IiL) && Objects.equals(this.f2135L11I, lli1ll.f2135L11I) && Objects.equals(this.f2138il, lli1ll.f2138il) && Objects.equals(this.ILL, lli1ll.ILL) && m2952Ll1().m2918l() == lli1ll.m2952Ll1().m2918l();
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public IiL m2951IiL() {
        return this.f2133IL;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public C0656lIII m2952Ll1() {
        return this.f4686IL1Iii;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public ProxySelector m2953L11I() {
        return this.f2136iILLL1;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof lLi1LL) {
            lLi1LL lli1ll = (lLi1LL) obj;
            if (this.f4686IL1Iii.equals(lli1ll.f4686IL1Iii) && m2950IL(lli1ll)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.f4686IL1Iii.hashCode()) * 31) + this.f4687ILil.hashCode()) * 31) + this.f2133IL.hashCode()) * 31) + this.f4688Ilil.hashCode()) * 31) + this.f2137lLi1LL.hashCode()) * 31) + this.f2136iILLL1.hashCode()) * 31) + Objects.hashCode(this.f2134IiL)) * 31) + Objects.hashCode(this.f2135L11I)) * 31) + Objects.hashCode(this.f2138il)) * 31) + Objects.hashCode(this.ILL);
    }

    @Nullable
    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public Proxy m2954iILLL1() {
        return this.f2134IiL;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public List<llI> m2955lLi1LL() {
        return this.f4688Ilil;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f4686IL1Iii.m2911lIiI());
        sb.append(":");
        sb.append(this.f4686IL1Iii.m2918l());
        if (this.f2134IiL != null) {
            sb.append(", proxy=");
            sb.append(this.f2134IiL);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f2136iILLL1);
        }
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public SocketFactory m2956il() {
        return this.f4685I1I;
    }
}
