package p047IL;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.Util;

/* JADX INFO: renamed from: I丨L.lI丨lii, reason: invalid class name */
/* JADX INFO: compiled from: ConnectionSpec.java */
/* JADX INFO: loaded from: classes.dex */
public final class lIlii {

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static final Lil[] f4675Ilil;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static final lIlii f2128IiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static final lIlii f2129iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static final Lil[] f2130lLi1LL;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    @Nullable
    public final String[] f4676I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final boolean f4677IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final boolean f4678ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    @Nullable
    public final String[] f2131IL;

    static {
        Lil lil = Lil.f2100llL1ii;
        Lil lil2 = Lil.f2099lIlii;
        Lil lil3 = Lil.iIi1;
        Lil lil4 = Lil.ILL;
        Lil lil5 = Lil.f2098lIiI;
        Lil lil6 = Lil.f2095Ll1;
        Lil lil7 = Lil.f2092ILl;
        Lil lil8 = Lil.LlLI1;
        Lil lil9 = Lil.Lil;
        Lil[] lilArr = {lil, lil2, lil3, lil4, lil5, lil6, lil7, lil8, lil9};
        f4675Ilil = lilArr;
        Lil[] lilArr2 = {lil, lil2, lil3, lil4, lil5, lil6, lil7, lil8, lil9, Lil.f2096L11I, Lil.f2102il, Lil.f2097iILLL1, Lil.f2094IiL, Lil.f4634Ilil, Lil.f2101lLi1LL, Lil.f2093IL};
        f2130lLi1LL = lilArr2;
        IL1Iii iL1Iii = new IL1Iii(true);
        iL1Iii.I1I(lilArr);
        EnumC0592 enumC0592 = EnumC0592.TLS_1_3;
        EnumC0592 enumC0593 = EnumC0592.TLS_1_2;
        iL1Iii.m2937lLi1LL(enumC0592, enumC0593);
        iL1Iii.m2936IL(true);
        iL1Iii.IL1Iii();
        IL1Iii iL1Iii2 = new IL1Iii(true);
        iL1Iii2.I1I(lilArr2);
        iL1Iii2.m2937lLi1LL(enumC0592, enumC0593);
        iL1Iii2.m2936IL(true);
        f2129iILLL1 = iL1Iii2.IL1Iii();
        IL1Iii iL1Iii3 = new IL1Iii(true);
        iL1Iii3.I1I(lilArr2);
        iL1Iii3.m2937lLi1LL(enumC0592, enumC0593, EnumC0592.TLS_1_1, EnumC0592.TLS_1_0);
        iL1Iii3.m2936IL(true);
        iL1Iii3.IL1Iii();
        f2128IiL = new IL1Iii(false).IL1Iii();
    }

    public lIlii(IL1Iii iL1Iii) {
        this.f4677IL1Iii = iL1Iii.f4680IL1Iii;
        this.f4676I1I = iL1Iii.f4681ILil;
        this.f2131IL = iL1Iii.f4679I1I;
        this.f4678ILil = iL1Iii.f2132IL;
    }

    public boolean I1I(SSLSocket sSLSocket) {
        if (!this.f4677IL1Iii) {
            return false;
        }
        String[] strArr = this.f2131IL;
        if (strArr != null && !Util.nonEmptyIntersection(Util.NATURAL_ORDER, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f4676I1I;
        return strArr2 == null || Util.nonEmptyIntersection(Lil.f4633ILil, strArr2, sSLSocket.getEnabledCipherSuites());
    }

    public void IL1Iii(SSLSocket sSLSocket, boolean z) {
        lIlii liliiIlil = Ilil(sSLSocket, z);
        String[] strArr = liliiIlil.f2131IL;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = liliiIlil.f4676I1I;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    @Nullable
    public List<Lil> ILil() {
        String[] strArr = this.f4676I1I;
        if (strArr != null) {
            return Lil.ILil(strArr);
        }
        return null;
    }

    public final lIlii Ilil(SSLSocket sSLSocket, boolean z) {
        String[] strArrIntersect = this.f4676I1I != null ? Util.intersect(Lil.f4633ILil, sSLSocket.getEnabledCipherSuites(), this.f4676I1I) : sSLSocket.getEnabledCipherSuites();
        String[] strArrIntersect2 = this.f2131IL != null ? Util.intersect(Util.NATURAL_ORDER, sSLSocket.getEnabledProtocols(), this.f2131IL) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iIndexOf = Util.indexOf(Lil.f4633ILil, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && iIndexOf != -1) {
            strArrIntersect = Util.concat(strArrIntersect, supportedCipherSuites[iIndexOf]);
        }
        IL1Iii iL1Iii = new IL1Iii(this);
        iL1Iii.ILil(strArrIntersect);
        iL1Iii.Ilil(strArrIntersect2);
        return iL1Iii.IL1Iii();
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean m2933IL() {
        return this.f4677IL1Iii;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof lIlii)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        lIlii lilii = (lIlii) obj;
        boolean z = this.f4677IL1Iii;
        if (z != lilii.f4677IL1Iii) {
            return false;
        }
        return !z || (Arrays.equals(this.f4676I1I, lilii.f4676I1I) && Arrays.equals(this.f2131IL, lilii.f2131IL) && this.f4678ILil == lilii.f4678ILil);
    }

    public int hashCode() {
        if (this.f4677IL1Iii) {
            return ((((527 + Arrays.hashCode(this.f4676I1I)) * 31) + Arrays.hashCode(this.f2131IL)) * 31) + (!this.f4678ILil ? 1 : 0);
        }
        return 17;
    }

    @Nullable
    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public List<EnumC0592> m2934iILLL1() {
        String[] strArr = this.f2131IL;
        if (strArr != null) {
            return EnumC0592.forJavaNames(strArr);
        }
        return null;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean m2935lLi1LL() {
        return this.f4678ILil;
    }

    public String toString() {
        if (!this.f4677IL1Iii) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(ILil(), "[all enabled]") + ", tlsVersions=" + Objects.toString(m2934iILLL1(), "[all enabled]") + ", supportsTlsExtensions=" + this.f4678ILil + ")";
    }

    /* JADX INFO: renamed from: I丨L.lI丨lii$IL1Iii */
    /* JADX INFO: compiled from: ConnectionSpec.java */
    public static final class IL1Iii {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        @Nullable
        public String[] f4679I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public boolean f4680IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        @Nullable
        public String[] f4681ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public boolean f2132IL;

        public IL1Iii(boolean z) {
            this.f4680IL1Iii = z;
        }

        public IL1Iii I1I(Lil... lilArr) {
            if (!this.f4680IL1Iii) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[lilArr.length];
            for (int i = 0; i < lilArr.length; i++) {
                strArr[i] = lilArr[i].f4635IL1Iii;
            }
            ILil(strArr);
            return this;
        }

        public lIlii IL1Iii() {
            return new lIlii(this);
        }

        public IL1Iii ILil(String... strArr) {
            if (!this.f4680IL1Iii) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.f4681ILil = (String[]) strArr.clone();
            return this;
        }

        public IL1Iii Ilil(String... strArr) {
            if (!this.f4680IL1Iii) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f4679I1I = (String[]) strArr.clone();
            return this;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public IL1Iii m2936IL(boolean z) {
            if (!this.f4680IL1Iii) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f2132IL = z;
            return this;
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public IL1Iii m2937lLi1LL(EnumC0592... enumC0592Arr) {
            if (!this.f4680IL1Iii) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[enumC0592Arr.length];
            for (int i = 0; i < enumC0592Arr.length; i++) {
                strArr[i] = enumC0592Arr[i].javaName;
            }
            Ilil(strArr);
            return this;
        }

        public IL1Iii(lIlii lilii) {
            this.f4680IL1Iii = lilii.f4677IL1Iii;
            this.f4681ILil = lilii.f4676I1I;
            this.f4679I1I = lilii.f2131IL;
            this.f2132IL = lilii.f4678ILil;
        }
    }
}
