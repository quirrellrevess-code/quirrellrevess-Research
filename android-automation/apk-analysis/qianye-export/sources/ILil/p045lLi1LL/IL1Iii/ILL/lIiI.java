package ILil.p045lLi1LL.IL1Iii.ILL;

import ILil.p045lLi1LL.IL1Iii.C0651il;
import ILil.p045lLi1LL.IL1Iii.lLi1LL;

/* JADX INFO: renamed from: ILil.l丨Li1LL.IL1Iii.ILL.lIi丨I, reason: invalid class name */
/* JADX INFO: compiled from: ResolutionAnchor.java */
/* JADX INFO: loaded from: classes.dex */
public class lIiI extends Lil {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public lLi1LL f4512I1I;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public float f4513Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public lIiI f1951IL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public lIiI f1954L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public float f1955iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public lIiI f1957lLi1LL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public int f1952IiL = 0;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public C0649ILl f1958il = null;
    public int ILL = 1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public C0649ILl f1953Ll1 = null;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public int f1956lIiI = 1;

    public lIiI(lLi1LL lli1ll) {
        this.f4512I1I = lli1ll;
    }

    public float ILL() {
        return this.f1955iILLL1;
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public void m2669ILl(lIiI liii, float f) {
        this.f1954L11I = liii;
    }

    @Override // ILil.p045lLi1LL.IL1Iii.ILL.Lil
    public void Ilil() {
        super.Ilil();
        this.f1951IL = null;
        this.f4513Ilil = 0.0f;
        this.f1958il = null;
        this.ILL = 1;
        this.f1953Ll1 = null;
        this.f1956lIiI = 1;
        this.f1957lLi1LL = null;
        this.f1955iILLL1 = 0.0f;
        this.f1954L11I = null;
        this.f1952IiL = 0;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m2670IiL(int i, lIiI liii, int i2) {
        this.f1952IiL = i;
        this.f1951IL = liii;
        this.f4513Ilil = i2;
        liii.IL1Iii(this);
    }

    public void Lil(lIiI liii, int i, C0649ILl c0649ILl) {
        this.f1954L11I = liii;
        this.f1953Ll1 = c0649ILl;
        this.f1956lIiI = i;
    }

    public void LlLI1(int i) {
        this.f1952IiL = i;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public void m2671Ll1(lIiI liii, float f) {
        int i = this.f4491ILil;
        if (i == 0 || !(this.f1957lLi1LL == liii || this.f1955iILLL1 == f)) {
            this.f1957lLi1LL = liii;
            this.f1955iILLL1 = f;
            if (i == 1) {
                I1I();
            }
            ILil();
        }
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public void m2672L11I(lIiI liii, int i) {
        this.f1951IL = liii;
        this.f4513Ilil = i;
        liii.IL1Iii(this);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m2673iILLL1(lLi1LL lli1ll) {
        C0651il c0651ilM2685iILLL1 = this.f4512I1I.m2685iILLL1();
        lIiI liii = this.f1957lLi1LL;
        if (liii == null) {
            lli1ll.m2717lLi1LL(c0651ilM2685iILLL1, (int) (this.f1955iILLL1 + 0.5f));
        } else {
            lli1ll.Ilil(c0651ilM2685iILLL1, lli1ll.m2715lIlii(liii.f4512I1I), (int) (this.f1955iILLL1 + 0.5f), 6);
        }
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public String m2674lIiI(int i) {
        if (i == 1) {
            return "DIRECT";
        }
        if (i == 2) {
            return "CENTER";
        }
        if (i == 3) {
            return "MATCH";
        }
        if (i == 4) {
            return "CHAIN";
        }
        return i == 5 ? "BARRIER" : "UNCONNECTED";
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public void m2675llL1ii() {
        lLi1LL lli1llM2684L11I = this.f4512I1I.m2684L11I();
        if (lli1llM2684L11I == null) {
            return;
        }
        if (lli1llM2684L11I.m2684L11I() == this.f4512I1I) {
            this.f1952IiL = 4;
            lli1llM2684L11I.m2687lLi1LL().f1952IiL = 4;
        }
        int iM2681IL = this.f4512I1I.m2681IL();
        lLi1LL.IL il = this.f4512I1I.f4514I1I;
        if (il == lLi1LL.IL.RIGHT || il == lLi1LL.IL.BOTTOM) {
            iM2681IL = -iM2681IL;
        }
        m2672L11I(lli1llM2684L11I.m2687lLi1LL(), iM2681IL);
    }

    @Override // ILil.p045lLi1LL.IL1Iii.ILL.Lil
    /* JADX INFO: renamed from: l丨Li1LL */
    public void mo2619lLi1LL() {
        int i;
        lIiI liii;
        lIiI liii2;
        lIiI liii3;
        lIiI liii4;
        lIiI liii5;
        lIiI liii6;
        float fM2629L111;
        float f;
        lIiI liii7;
        boolean z = true;
        if (this.f4491ILil == 1 || (i = this.f1952IiL) == 4) {
            return;
        }
        C0649ILl c0649ILl = this.f1958il;
        if (c0649ILl != null) {
            if (c0649ILl.f4491ILil != 1) {
                return;
            } else {
                this.f4513Ilil = this.ILL * c0649ILl.f4485I1I;
            }
        }
        C0649ILl c0649ILl2 = this.f1953Ll1;
        if (c0649ILl2 != null) {
            if (c0649ILl2.f4491ILil != 1) {
                return;
            } else {
                float f2 = c0649ILl2.f4485I1I;
            }
        }
        if (i == 1 && ((liii7 = this.f1951IL) == null || liii7.f4491ILil == 1)) {
            if (liii7 == null) {
                this.f1957lLi1LL = this;
                this.f1955iILLL1 = this.f4513Ilil;
            } else {
                this.f1957lLi1LL = liii7.f1957lLi1LL;
                this.f1955iILLL1 = liii7.f1955iILLL1 + this.f4513Ilil;
            }
            ILil();
            return;
        }
        if (i != 2 || (liii4 = this.f1951IL) == null || liii4.f4491ILil != 1 || (liii5 = this.f1954L11I) == null || (liii6 = liii5.f1951IL) == null || liii6.f4491ILil != 1) {
            if (i != 3 || (liii = this.f1951IL) == null || liii.f4491ILil != 1 || (liii2 = this.f1954L11I) == null || (liii3 = liii2.f1951IL) == null || liii3.f4491ILil != 1) {
                if (i == 5) {
                    this.f4512I1I.f4516ILil.mo2600I1L11L();
                    return;
                }
                return;
            }
            if (lLi1LL.llliI() != null) {
                lLi1LL.llliI().I11L++;
            }
            lIiI liii8 = this.f1951IL;
            this.f1957lLi1LL = liii8.f1957lLi1LL;
            lIiI liii9 = this.f1954L11I;
            lIiI liii10 = liii9.f1951IL;
            liii9.f1957lLi1LL = liii10.f1957lLi1LL;
            this.f1955iILLL1 = liii8.f1955iILLL1 + this.f4513Ilil;
            liii9.f1955iILLL1 = liii10.f1955iILLL1 + liii9.f4513Ilil;
            ILil();
            this.f1954L11I.ILil();
            return;
        }
        if (lLi1LL.llliI() != null) {
            lLi1LL.llliI().f1980lL++;
        }
        lIiI liii11 = this.f1951IL;
        this.f1957lLi1LL = liii11.f1957lLi1LL;
        lIiI liii12 = this.f1954L11I;
        lIiI liii13 = liii12.f1951IL;
        liii12.f1957lLi1LL = liii13.f1957lLi1LL;
        lLi1LL lli1ll = this.f4512I1I;
        lLi1LL.IL il = lli1ll.f4514I1I;
        lLi1LL.IL il2 = lLi1LL.IL.RIGHT;
        int i2 = 0;
        if (il != il2 && il != lLi1LL.IL.BOTTOM) {
            z = false;
        }
        float f3 = z ? liii11.f1955iILLL1 - liii13.f1955iILLL1 : liii13.f1955iILLL1 - liii11.f1955iILLL1;
        if (il == lLi1LL.IL.LEFT || il == il2) {
            fM2629L111 = f3 - lli1ll.f4516ILil.m2629L111();
            f = this.f4512I1I.f4516ILil.f1914ILLIi;
        } else {
            fM2629L111 = f3 - lli1ll.f4516ILil.m2653lIlii();
            f = this.f4512I1I.f4516ILil.f1942li11;
        }
        int iM2681IL = this.f4512I1I.m2681IL();
        int iM2681IL2 = this.f1954L11I.f4512I1I.m2681IL();
        if (this.f4512I1I.m2684L11I() == this.f1954L11I.f4512I1I.m2684L11I()) {
            f = 0.5f;
            iM2681IL2 = 0;
        } else {
            i2 = iM2681IL;
        }
        float f4 = i2;
        float f5 = iM2681IL2;
        float f6 = (fM2629L111 - f4) - f5;
        if (z) {
            lIiI liii14 = this.f1954L11I;
            liii14.f1955iILLL1 = liii14.f1951IL.f1955iILLL1 + f5 + (f6 * f);
            this.f1955iILLL1 = (this.f1951IL.f1955iILLL1 - f4) - (f6 * (1.0f - f));
        } else {
            this.f1955iILLL1 = this.f1951IL.f1955iILLL1 + f4 + (f6 * f);
            lIiI liii15 = this.f1954L11I;
            liii15.f1955iILLL1 = (liii15.f1951IL.f1955iILLL1 - f5) - (f6 * (1.0f - f));
        }
        ILil();
        this.f1954L11I.ILil();
    }

    public String toString() {
        if (this.f4491ILil != 1) {
            return "{ " + this.f4512I1I + " UNRESOLVED} type: " + m2674lIiI(this.f1952IiL);
        }
        if (this.f1957lLi1LL == this) {
            return "[" + this.f4512I1I + ", RESOLVED: " + this.f1955iILLL1 + "]  type: " + m2674lIiI(this.f1952IiL);
        }
        return "[" + this.f4512I1I + ", RESOLVED: " + this.f1957lLi1LL + ":" + this.f1955iILLL1 + "] type: " + m2674lIiI(this.f1952IiL);
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void m2676il(lIiI liii, int i, C0649ILl c0649ILl) {
        this.f1951IL = liii;
        liii.IL1Iii(this);
        this.f1958il = c0649ILl;
        this.ILL = i;
        c0649ILl.IL1Iii(this);
    }
}
