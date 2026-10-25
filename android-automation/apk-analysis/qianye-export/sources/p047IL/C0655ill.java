package p047IL;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: renamed from: I丨L.il丨l丨, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: Route.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0655ill {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final InetSocketAddress f4652I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final lLi1LL f4653IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final Proxy f4654ILil;

    public C0655ill(lLi1LL lli1ll, Proxy proxy, InetSocketAddress inetSocketAddress) {
        Objects.requireNonNull(lli1ll, "address == null");
        Objects.requireNonNull(proxy, "proxy == null");
        Objects.requireNonNull(inetSocketAddress, "inetSocketAddress == null");
        this.f4653IL1Iii = lli1ll;
        this.f4654ILil = proxy;
        this.f4652I1I = inetSocketAddress;
    }

    public boolean I1I() {
        return this.f4653IL1Iii.f2135L11I != null && this.f4654ILil.type() == Proxy.Type.HTTP;
    }

    public lLi1LL IL1Iii() {
        return this.f4653IL1Iii;
    }

    public Proxy ILil() {
        return this.f4654ILil;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public InetSocketAddress m2897IL() {
        return this.f4652I1I;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C0655ill) {
            C0655ill c0655ill = (C0655ill) obj;
            if (c0655ill.f4653IL1Iii.equals(this.f4653IL1Iii) && c0655ill.f4654ILil.equals(this.f4654ILil) && c0655ill.f4652I1I.equals(this.f4652I1I)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f4653IL1Iii.hashCode()) * 31) + this.f4654ILil.hashCode()) * 31) + this.f4652I1I.hashCode();
    }

    public String toString() {
        return "Route{" + this.f4652I1I + "}";
    }
}
