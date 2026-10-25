package ILil.p045lLi1LL.IL1Iii;

import com.google.android.flexbox.BuildConfig;

/* JADX INFO: compiled from: ArrayRow.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil implements lLi1LL.IL1Iii {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public boolean f4523I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public C0651il f4524IL1Iii = null;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public float f4525ILil = 0.0f;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public boolean f4526Ilil = false;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final IL1Iii f1967IL;

    public ILil(I1I i1i) {
        this.f1967IL = new IL1Iii(this, i1i);
    }

    public void I11L() {
        this.f4524IL1Iii = null;
        this.f1967IL.I1I();
        this.f4525ILil = 0.0f;
        this.f4526Ilil = false;
    }

    public C0651il I11li1(C0651il c0651il) {
        return this.f1967IL.m2588iILLL1(null, c0651il);
    }

    @Override // ILil.p045lLi1LL.IL1Iii.lLi1LL.IL1Iii
    public void I1I(lLi1LL.IL1Iii iL1Iii) {
        if (!(iL1Iii instanceof ILil)) {
            return;
        }
        ILil iLil = (ILil) iL1Iii;
        this.f4524IL1Iii = null;
        this.f1967IL.I1I();
        int i = 0;
        while (true) {
            IL1Iii iL1Iii2 = iLil.f1967IL;
            if (i >= iL1Iii2.f4482IL1Iii) {
                return;
            }
            this.f1967IL.IL1Iii(iL1Iii2.m2585IiL(i), iLil.f1967IL.m2587L11I(i), true);
            i++;
        }
    }

    @Override // ILil.p045lLi1LL.IL1Iii.lLi1LL.IL1Iii
    public void IL1Iii(C0651il c0651il) {
        int i = c0651il.f1993IL;
        float f = 1.0f;
        if (i != 1) {
            if (i == 2) {
                f = 1000.0f;
            } else if (i == 3) {
                f = 1000000.0f;
            } else if (i == 4) {
                f = 1.0E9f;
            } else if (i == 5) {
                f = 1.0E12f;
            }
        }
        this.f1967IL.m2586Ll1(c0651il, f);
    }

    public ILil ILL(float f, float f2, float f3, C0651il c0651il, C0651il c0651il2, C0651il c0651il3, C0651il c0651il4) {
        this.f4525ILil = 0.0f;
        if (f2 == 0.0f || f == f3) {
            this.f1967IL.m2586Ll1(c0651il, 1.0f);
            this.f1967IL.m2586Ll1(c0651il2, -1.0f);
            this.f1967IL.m2586Ll1(c0651il4, 1.0f);
            this.f1967IL.m2586Ll1(c0651il3, -1.0f);
        } else if (f == 0.0f) {
            this.f1967IL.m2586Ll1(c0651il, 1.0f);
            this.f1967IL.m2586Ll1(c0651il2, -1.0f);
        } else if (f3 == 0.0f) {
            this.f1967IL.m2586Ll1(c0651il3, 1.0f);
            this.f1967IL.m2586Ll1(c0651il4, -1.0f);
        } else {
            float f4 = (f / f2) / (f3 / f2);
            this.f1967IL.m2586Ll1(c0651il, 1.0f);
            this.f1967IL.m2586Ll1(c0651il2, -1.0f);
            this.f1967IL.m2586Ll1(c0651il4, f4);
            this.f1967IL.m2586Ll1(c0651il3, -f4);
        }
        return this;
    }

    @Override // ILil.p045lLi1LL.IL1Iii.lLi1LL.IL1Iii
    public C0651il ILil(lLi1LL lli1ll, boolean[] zArr) {
        return this.f1967IL.m2588iILLL1(zArr, null);
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public ILil m2693ILl(C0651il c0651il, C0651il c0651il2, C0651il c0651il3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f4525ILil = i;
        }
        if (z) {
            this.f1967IL.m2586Ll1(c0651il, 1.0f);
            this.f1967IL.m2586Ll1(c0651il2, -1.0f);
            this.f1967IL.m2586Ll1(c0651il3, -1.0f);
        } else {
            this.f1967IL.m2586Ll1(c0651il, -1.0f);
            this.f1967IL.m2586Ll1(c0651il2, 1.0f);
            this.f1967IL.m2586Ll1(c0651il3, 1.0f);
        }
        return this;
    }

    public ILil Ilil(C0651il c0651il, int i) {
        this.f1967IL.m2586Ll1(c0651il, i);
        return this;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public ILil m2694IL(lLi1LL lli1ll, int i) {
        this.f1967IL.m2586Ll1(lli1ll.LlLI1(i, "ep"), 1.0f);
        this.f1967IL.m2586Ll1(lli1ll.LlLI1(i, "em"), -1.0f);
        return this;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public ILil m2695IiL(C0651il c0651il, int i) {
        this.f4524IL1Iii = c0651il;
        float f = i;
        c0651il.f4540Ilil = f;
        this.f4525ILil = f;
        this.f4526Ilil = true;
        return this;
    }

    public ILil Lil(C0651il c0651il, C0651il c0651il2, C0651il c0651il3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f4525ILil = i;
        }
        if (z) {
            this.f1967IL.m2586Ll1(c0651il, 1.0f);
            this.f1967IL.m2586Ll1(c0651il2, -1.0f);
            this.f1967IL.m2586Ll1(c0651il3, 1.0f);
        } else {
            this.f1967IL.m2586Ll1(c0651il, -1.0f);
            this.f1967IL.m2586Ll1(c0651il2, 1.0f);
            this.f1967IL.m2586Ll1(c0651il3, -1.0f);
        }
        return this;
    }

    public ILil LlLI1(C0651il c0651il, C0651il c0651il2, C0651il c0651il3, C0651il c0651il4, float f) {
        this.f1967IL.m2586Ll1(c0651il3, 0.5f);
        this.f1967IL.m2586Ll1(c0651il4, 0.5f);
        this.f1967IL.m2586Ll1(c0651il, -0.5f);
        this.f1967IL.m2586Ll1(c0651il2, -0.5f);
        this.f4525ILil = -f;
        return this;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public ILil m2696Ll1(C0651il c0651il, int i) {
        if (i < 0) {
            this.f4525ILil = i * (-1);
            this.f1967IL.m2586Ll1(c0651il, 1.0f);
        } else {
            this.f4525ILil = i;
            this.f1967IL.m2586Ll1(c0651il, -1.0f);
        }
        return this;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public ILil m2697L11I(C0651il c0651il, C0651il c0651il2, C0651il c0651il3, float f) {
        this.f1967IL.m2586Ll1(c0651il, -1.0f);
        this.f1967IL.m2586Ll1(c0651il2, 1.0f - f);
        this.f1967IL.m2586Ll1(c0651il3, f);
        return this;
    }

    @Override // ILil.p045lLi1LL.IL1Iii.lLi1LL.IL1Iii
    public void clear() {
        this.f1967IL.I1I();
        this.f4524IL1Iii = null;
        this.f4525ILil = 0.0f;
    }

    @Override // ILil.p045lLi1LL.IL1Iii.lLi1LL.IL1Iii
    public C0651il getKey() {
        return this.f4524IL1Iii;
    }

    public boolean iIi1(C0651il c0651il) {
        return this.f1967IL.m2584IL(c0651il);
    }

    public boolean iIlLiL() {
        return this.f4524IL1Iii == null && this.f4525ILil == 0.0f && this.f1967IL.f4482IL1Iii == 0;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public ILil m2698iILLL1(C0651il c0651il, C0651il c0651il2, int i, float f, C0651il c0651il3, C0651il c0651il4, int i2) {
        if (c0651il2 == c0651il3) {
            this.f1967IL.m2586Ll1(c0651il, 1.0f);
            this.f1967IL.m2586Ll1(c0651il4, 1.0f);
            this.f1967IL.m2586Ll1(c0651il2, -2.0f);
            return this;
        }
        if (f == 0.5f) {
            this.f1967IL.m2586Ll1(c0651il, 1.0f);
            this.f1967IL.m2586Ll1(c0651il2, -1.0f);
            this.f1967IL.m2586Ll1(c0651il3, -1.0f);
            this.f1967IL.m2586Ll1(c0651il4, 1.0f);
            if (i > 0 || i2 > 0) {
                this.f4525ILil = (-i) + i2;
            }
        } else if (f <= 0.0f) {
            this.f1967IL.m2586Ll1(c0651il, -1.0f);
            this.f1967IL.m2586Ll1(c0651il2, 1.0f);
            this.f4525ILil = i;
        } else if (f >= 1.0f) {
            this.f1967IL.m2586Ll1(c0651il3, -1.0f);
            this.f1967IL.m2586Ll1(c0651il4, 1.0f);
            this.f4525ILil = i2;
        } else {
            float f2 = 1.0f - f;
            this.f1967IL.m2586Ll1(c0651il, f2 * 1.0f);
            this.f1967IL.m2586Ll1(c0651il2, f2 * (-1.0f));
            this.f1967IL.m2586Ll1(c0651il3, (-1.0f) * f);
            this.f1967IL.m2586Ll1(c0651il4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                this.f4525ILil = ((-i) * f2) + (i2 * f);
            }
        }
        return this;
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public ILil m2699lIiI(C0651il c0651il, C0651il c0651il2, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f4525ILil = i;
        }
        if (z) {
            this.f1967IL.m2586Ll1(c0651il, 1.0f);
            this.f1967IL.m2586Ll1(c0651il2, -1.0f);
        } else {
            this.f1967IL.m2586Ll1(c0651il, -1.0f);
            this.f1967IL.m2586Ll1(c0651il2, 1.0f);
        }
        return this;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public boolean m2700lIlii() {
        C0651il c0651il = this.f4524IL1Iii;
        return c0651il != null && (c0651il.f1996iILLL1 == C0651il.IL1Iii.UNRESTRICTED || this.f4525ILil >= 0.0f);
    }

    public String llliI() {
        boolean z;
        String str = (this.f4524IL1Iii == null ? BuildConfig.FLAVOR + "0" : BuildConfig.FLAVOR + this.f4524IL1Iii) + " = ";
        if (this.f4525ILil != 0.0f) {
            str = str + this.f4525ILil;
            z = true;
        } else {
            z = false;
        }
        int i = this.f1967IL.f4482IL1Iii;
        for (int i2 = 0; i2 < i; i2++) {
            C0651il c0651ilM2585IiL = this.f1967IL.m2585IiL(i2);
            if (c0651ilM2585IiL != null) {
                float fM2587L11I = this.f1967IL.m2587L11I(i2);
                if (fM2587L11I != 0.0f) {
                    String string = c0651ilM2585IiL.toString();
                    if (z) {
                        if (fM2587L11I > 0.0f) {
                            str = str + " + ";
                        } else {
                            str = str + " - ";
                            fM2587L11I *= -1.0f;
                        }
                    } else if (fM2587L11I < 0.0f) {
                        str = str + "- ";
                        fM2587L11I *= -1.0f;
                    }
                    str = fM2587L11I == 1.0f ? str + string : str + fM2587L11I + " " + string;
                    z = true;
                }
            }
        }
        if (z) {
            return str;
        }
        return str + "0.0";
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public void m2701llL1ii() {
        float f = this.f4525ILil;
        if (f < 0.0f) {
            this.f4525ILil = f * (-1.0f);
            this.f1967IL.m2591il();
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean m2702lLi1LL(lLi1LL lli1ll) {
        boolean z;
        C0651il c0651ilILil = this.f1967IL.ILil(lli1ll);
        if (c0651ilILil == null) {
            z = true;
        } else {
            m2704lL(c0651ilILil);
            z = false;
        }
        if (this.f1967IL.f4482IL1Iii == 0) {
            this.f4526Ilil = true;
        }
        return z;
    }

    public String toString() {
        return llliI();
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public ILil m2703il(C0651il c0651il, C0651il c0651il2, C0651il c0651il3, C0651il c0651il4, float f) {
        this.f1967IL.m2586Ll1(c0651il, -1.0f);
        this.f1967IL.m2586Ll1(c0651il2, 1.0f);
        this.f1967IL.m2586Ll1(c0651il3, f);
        this.f1967IL.m2586Ll1(c0651il4, -f);
        return this;
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public void m2704lL(C0651il c0651il) {
        C0651il c0651il2 = this.f4524IL1Iii;
        if (c0651il2 != null) {
            this.f1967IL.m2586Ll1(c0651il2, -1.0f);
            this.f4524IL1Iii = null;
        }
        float fM2589lIiI = this.f1967IL.m2589lIiI(c0651il, true) * (-1.0f);
        this.f4524IL1Iii = c0651il;
        if (fM2589lIiI == 1.0f) {
            return;
        }
        this.f4525ILil /= fM2589lIiI;
        this.f1967IL.Ilil(fM2589lIiI);
    }
}
