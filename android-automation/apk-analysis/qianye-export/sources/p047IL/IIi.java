package p047IL;

import java.io.Closeable;
import javax.annotation.Nullable;
import okhttp3.internal.connection.Exchange;

/* JADX INFO: renamed from: I丨L.I丨Ii, reason: invalid class name */
/* JADX INFO: compiled from: Response.java */
/* JADX INFO: loaded from: classes.dex */
public final class IIi implements Closeable {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final llI f4614I1I;

    @Nullable
    public final IIi ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final L1l f4615ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    @Nullable
    public final Exchange f2072ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final String f4616Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final int f2073IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    @Nullable
    public final LIll f2074IiL;

    @Nullable
    public volatile C0657il Lil;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final long f2075Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    @Nullable
    public final IIi f2076L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final LlLLL f2077iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final long f2078lIiI;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    @Nullable
    public final C1 f2079lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    @Nullable
    public final IIi f2080il;

    public IIi(IL1Iii iL1Iii) {
        this.f4615ILil = iL1Iii.f4618IL1Iii;
        this.f4614I1I = iL1Iii.f4619ILil;
        this.f2073IL = iL1Iii.f4617I1I;
        this.f4616Ilil = iL1Iii.f2081IL;
        this.f2079lLi1LL = iL1Iii.f4620Ilil;
        this.f2077iILLL1 = iL1Iii.f2087lLi1LL.Ilil();
        this.f2074IiL = iL1Iii.f2085iILLL1;
        this.f2076L11I = iL1Iii.f2082IiL;
        this.f2080il = iL1Iii.f2084L11I;
        this.ILL = iL1Iii.f2088il;
        this.f2075Ll1 = iL1Iii.ILL;
        this.f2078lIiI = iL1Iii.f2083Ll1;
        this.f2072ILl = iL1Iii.f2086lIiI;
    }

    /* JADX INFO: renamed from: I1L丨11L, reason: contains not printable characters */
    public String m2843I1L11L() {
        return this.f4616Ilil;
    }

    @Nullable
    /* JADX INFO: renamed from: IIi丨丨I, reason: contains not printable characters */
    public String m2844IIiI(String str) {
        return m2852lliiI1(str, null);
    }

    @Nullable
    /* JADX INFO: renamed from: ILL丨Ii, reason: contains not printable characters */
    public IIi m2845ILLIi() {
        return this.f2076L11I;
    }

    @Nullable
    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public LIll m2846IiL() {
        return this.f2074IiL;
    }

    /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
    public int m2847L11() {
        return this.f2073IL;
    }

    /* JADX INFO: renamed from: LI丨l, reason: contains not printable characters */
    public L1l m2848LIl() {
        return this.f4615ILil;
    }

    public LlLLL LLL() {
        return this.f2077iILLL1;
    }

    @Nullable
    /* JADX INFO: renamed from: LlIl丨, reason: contains not printable characters */
    public C1 m2849LlIl() {
        return this.f2079lLi1LL;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        LIll lIll = this.f2074IiL;
        if (lIll == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        lIll.close();
    }

    /* JADX INFO: renamed from: i1 */
    public llI m105i1() {
        return this.f4614I1I;
    }

    /* JADX INFO: renamed from: iI */
    public long m106iI() {
        return this.f2075Ll1;
    }

    /* JADX INFO: renamed from: iI1i丨I, reason: contains not printable characters */
    public boolean m2850iI1iI() {
        int i = this.f2073IL;
        return i >= 200 && i < 300;
    }

    @Nullable
    public IIi iIilII1() {
        return this.ILL;
    }

    /* JADX INFO: renamed from: ili丨11, reason: contains not printable characters */
    public long m2851ili11() {
        return this.f2078lIiI;
    }

    @Nullable
    /* JADX INFO: renamed from: l丨liiI1, reason: contains not printable characters */
    public String m2852lliiI1(String str, @Nullable String str2) {
        String strI1I = this.f2077iILLL1.I1I(str);
        return strI1I != null ? strI1I : str2;
    }

    /* JADX INFO: renamed from: l丨丨i11, reason: contains not printable characters */
    public IL1Iii m2853li11() {
        return new IL1Iii(this);
    }

    public String toString() {
        return "Response{protocol=" + this.f4614I1I + ", code=" + this.f2073IL + ", message=" + this.f4616Ilil + ", url=" + this.f4615ILil.m2875il() + '}';
    }

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public C0657il m2854() {
        C0657il c0657il = this.Lil;
        if (c0657il != null) {
            return c0657il;
        }
        C0657il c0657ilILL = C0657il.ILL(this.f2077iILLL1);
        this.Lil = c0657ilILL;
        return c0657ilILL;
    }

    /* JADX INFO: renamed from: I丨L.I丨Ii$IL1Iii */
    /* JADX INFO: compiled from: Response.java */
    public static class IL1Iii {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f4617I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        @Nullable
        public L1l f4618IL1Iii;
        public long ILL;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        @Nullable
        public llI f4619ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        @Nullable
        public C1 f4620Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public String f2081IL;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        @Nullable
        public IIi f2082IiL;

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public long f2083Ll1;

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        @Nullable
        public IIi f2084L11I;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        @Nullable
        public LIll f2085iILLL1;

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        @Nullable
        public Exchange f2086lIiI;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public LlLLL.IL1Iii f2087lLi1LL;

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        @Nullable
        public IIi f2088il;

        public IL1Iii() {
            this.f4617I1I = -1;
            this.f2087lLi1LL = new LlLLL.IL1Iii();
        }

        public IIi I1I() {
            if (this.f4618IL1Iii == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f4619ILil == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.f4617I1I >= 0) {
                if (this.f2081IL != null) {
                    return new IIi(this);
                }
                throw new IllegalStateException("message == null");
            }
            throw new IllegalStateException("code < 0: " + this.f4617I1I);
        }

        public IL1Iii IL1Iii(String str, String str2) {
            this.f2087lLi1LL.IL1Iii(str, str2);
            return this;
        }

        public void ILL(Exchange exchange) {
            this.f2086lIiI = exchange;
        }

        public IL1Iii ILil(@Nullable LIll lIll) {
            this.f2085iILLL1 = lIll;
            return this;
        }

        /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
        public IL1Iii m2855ILl(@Nullable IIi iIi) {
            if (iIi != null) {
                Ilil(iIi);
            }
            this.f2088il = iIi;
            return this;
        }

        public final void Ilil(IIi iIi) {
            if (iIi.f2074IiL != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public IL1Iii m2856IL(@Nullable IIi iIi) {
            if (iIi != null) {
                m2864lLi1LL("cacheResponse", iIi);
            }
            this.f2084L11I = iIi;
            return this;
        }

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public IL1Iii m2857IiL(@Nullable C1 c1) {
            this.f4620Ilil = c1;
            return this;
        }

        public IL1Iii Lil(llI lli) {
            this.f4619ILil = lli;
            return this;
        }

        public IL1Iii LlLI1(long j) {
            this.f2083Ll1 = j;
            return this;
        }

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public IL1Iii m2858Ll1(String str) {
            this.f2081IL = str;
            return this;
        }

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public IL1Iii m2859L11I(String str, String str2) {
            this.f2087lLi1LL.m2889iILLL1(str, str2);
            return this;
        }

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public IL1Iii m2860iILLL1(int i) {
            this.f4617I1I = i;
            return this;
        }

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public IL1Iii m2861lIiI(@Nullable IIi iIi) {
            if (iIi != null) {
                m2864lLi1LL("networkResponse", iIi);
            }
            this.f2082IiL = iIi;
            return this;
        }

        /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
        public IL1Iii m2862lIlii(long j) {
            this.ILL = j;
            return this;
        }

        /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
        public IL1Iii m2863llL1ii(L1l l1l) {
            this.f4618IL1Iii = l1l;
            return this;
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public final void m2864lLi1LL(String str, IIi iIi) {
            if (iIi.f2074IiL != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (iIi.f2076L11I != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (iIi.f2080il != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (iIi.ILL == null) {
                return;
            }
            throw new IllegalArgumentException(str + ".priorResponse != null");
        }

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public IL1Iii m2865il(LlLLL llLLL) {
            this.f2087lLi1LL = llLLL.m2886lLi1LL();
            return this;
        }

        public IL1Iii(IIi iIi) {
            this.f4617I1I = -1;
            this.f4618IL1Iii = iIi.f4615ILil;
            this.f4619ILil = iIi.f4614I1I;
            this.f4617I1I = iIi.f2073IL;
            this.f2081IL = iIi.f4616Ilil;
            this.f4620Ilil = iIi.f2079lLi1LL;
            this.f2087lLi1LL = iIi.f2077iILLL1.m2886lLi1LL();
            this.f2085iILLL1 = iIi.f2074IiL;
            this.f2082IiL = iIi.f2076L11I;
            this.f2084L11I = iIi.f2080il;
            this.f2088il = iIi.ILL;
            this.ILL = iIi.f2075Ll1;
            this.f2083Ll1 = iIi.f2078lIiI;
            this.f2086lIiI = iIi.f2072ILl;
        }
    }
}
