package ILil.p045lLi1LL.IL1Iii.ILL;

import ILil.p045lLi1LL.IL1Iii.C0651il;
import ILil.p045lLi1LL.IL1Iii.lLi1LL;
import java.util.ArrayList;

/* JADX INFO: renamed from: ILil.l丨Li1LL.IL1Iii.ILL.丨il, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: Guideline.java */
/* JADX INFO: loaded from: classes.dex */
public class C0650il extends iILLL1 {
    public float l1Lll = -1.0f;
    public int I1IILIIL = -1;
    public int ill1LI1l = -1;

    /* JADX INFO: renamed from: lIIiIlL丨, reason: contains not printable characters */
    public lLi1LL f1965lIIiIlL = this.iIlLiL;

    /* JADX INFO: renamed from: 丨i1丨1丨LL, reason: contains not printable characters */
    public int f1966i11LL = 0;

    /* JADX INFO: renamed from: iIl1il丨, reason: contains not printable characters */
    public boolean f1964iIl1il = false;

    /* JADX INFO: renamed from: ILil.l丨Li1LL.IL1Iii.ILL.丨il$IL1Iii */
    /* JADX INFO: compiled from: Guideline.java */
    public static /* synthetic */ class IL1Iii {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public static final /* synthetic */ int[] f4522IL1Iii;

        static {
            int[] iArr = new int[lLi1LL.IL.values().length];
            f4522IL1Iii = iArr;
            try {
                iArr[lLi1LL.IL.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4522IL1Iii[lLi1LL.IL.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4522IL1Iii[lLi1LL.IL.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4522IL1Iii[lLi1LL.IL.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4522IL1Iii[lLi1LL.IL.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4522IL1Iii[lLi1LL.IL.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4522IL1Iii[lLi1LL.IL.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4522IL1Iii[lLi1LL.IL.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4522IL1Iii[lLi1LL.IL.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public C0650il() {
        this.f1937lIII.clear();
        this.f1937lIII.add(this.f1965lIIiIlL);
        int length = this.f1928LlLLL.length;
        for (int i = 0; i < length; i++) {
            this.f1928LlLLL[i] = this.f1965lIIiIlL;
        }
    }

    @Override // ILil.p045lLi1LL.IL1Iii.ILL.iILLL1
    public boolean I1I() {
        return true;
    }

    @Override // ILil.p045lLi1LL.IL1Iii.ILL.iILLL1
    public void ILil(lLi1LL lli1ll) {
        IiL iiL = (IiL) I11li1();
        if (iiL == null) {
            return;
        }
        lLi1LL lli1llMo2627IiL = iiL.mo2627IiL(lLi1LL.IL.LEFT);
        lLi1LL lli1llMo2627IiL2 = iiL.mo2627IiL(lLi1LL.IL.RIGHT);
        iILLL1 iilll1 = this.f1920L111;
        boolean z = iilll1 != null && iilll1.LL1IL[0] == iILLL1.ILil.WRAP_CONTENT;
        if (this.f1966i11LL == 0) {
            lli1llMo2627IiL = iiL.mo2627IiL(lLi1LL.IL.TOP);
            lli1llMo2627IiL2 = iiL.mo2627IiL(lLi1LL.IL.BOTTOM);
            iILLL1 iilll2 = this.f1920L111;
            z = iilll2 != null && iilll2.LL1IL[1] == iILLL1.ILil.WRAP_CONTENT;
        }
        if (this.I1IILIIL != -1) {
            C0651il c0651ilM2715lIlii = lli1ll.m2715lIlii(this.f1965lIIiIlL);
            lli1ll.Ilil(c0651ilM2715lIlii, lli1ll.m2715lIlii(lli1llMo2627IiL), this.I1IILIIL, 6);
            if (z) {
                lli1ll.m2710L11I(lli1ll.m2715lIlii(lli1llMo2627IiL2), c0651ilM2715lIlii, 0, 5);
                return;
            }
            return;
        }
        if (this.ill1LI1l == -1) {
            if (this.l1Lll != -1.0f) {
                lli1ll.m2706IL(lLi1LL.iIlLiL(lli1ll, lli1ll.m2715lIlii(this.f1965lIIiIlL), lli1ll.m2715lIlii(lli1llMo2627IiL), lli1ll.m2715lIlii(lli1llMo2627IiL2), this.l1Lll, this.f1964iIl1il));
                return;
            }
            return;
        }
        C0651il c0651ilM2715lIlii2 = lli1ll.m2715lIlii(this.f1965lIIiIlL);
        C0651il c0651ilM2715lIlii3 = lli1ll.m2715lIlii(lli1llMo2627IiL2);
        lli1ll.Ilil(c0651ilM2715lIlii2, c0651ilM2715lIlii3, -this.ill1LI1l, 6);
        if (z) {
            lli1ll.m2710L11I(c0651ilM2715lIlii2, lli1ll.m2715lIlii(lli1llMo2627IiL), 0, 5);
            lli1ll.m2710L11I(c0651ilM2715lIlii3, c0651ilM2715lIlii2, 0, 5);
        }
    }

    @Override // ILil.p045lLi1LL.IL1Iii.ILL.iILLL1
    /* JADX INFO: renamed from: I丨L */
    public void mo2601IL(int i) {
        iILLL1 iilll1I11li1 = I11li1();
        if (iilll1I11li1 == null) {
            return;
        }
        if (m2691ILI() == 1) {
            this.iIlLiL.m2687lLi1LL().m2670IiL(1, iilll1I11li1.iIlLiL.m2687lLi1LL(), 0);
            this.f1946lL.m2687lLi1LL().m2670IiL(1, iilll1I11li1.iIlLiL.m2687lLi1LL(), 0);
            if (this.I1IILIIL != -1) {
                this.iIi1.m2687lLi1LL().m2670IiL(1, iilll1I11li1.iIi1.m2687lLi1LL(), this.I1IILIIL);
                this.I11li1.m2687lLi1LL().m2670IiL(1, iilll1I11li1.iIi1.m2687lLi1LL(), this.I1IILIIL);
                return;
            } else if (this.ill1LI1l != -1) {
                this.iIi1.m2687lLi1LL().m2670IiL(1, iilll1I11li1.I11li1.m2687lLi1LL(), -this.ill1LI1l);
                this.I11li1.m2687lLi1LL().m2670IiL(1, iilll1I11li1.I11li1.m2687lLi1LL(), -this.ill1LI1l);
                return;
            } else {
                if (this.l1Lll == -1.0f || iilll1I11li1.iIi1() != iILLL1.ILil.FIXED) {
                    return;
                }
                int i2 = (int) (iilll1I11li1.f1948LLlI1 * this.l1Lll);
                this.iIi1.m2687lLi1LL().m2670IiL(1, iilll1I11li1.iIi1.m2687lLi1LL(), i2);
                this.I11li1.m2687lLi1LL().m2670IiL(1, iilll1I11li1.iIi1.m2687lLi1LL(), i2);
                return;
            }
        }
        this.iIi1.m2687lLi1LL().m2670IiL(1, iilll1I11li1.iIi1.m2687lLi1LL(), 0);
        this.I11li1.m2687lLi1LL().m2670IiL(1, iilll1I11li1.iIi1.m2687lLi1LL(), 0);
        if (this.I1IILIIL != -1) {
            this.iIlLiL.m2687lLi1LL().m2670IiL(1, iilll1I11li1.iIlLiL.m2687lLi1LL(), this.I1IILIIL);
            this.f1946lL.m2687lLi1LL().m2670IiL(1, iilll1I11li1.iIlLiL.m2687lLi1LL(), this.I1IILIIL);
        } else if (this.ill1LI1l != -1) {
            this.iIlLiL.m2687lLi1LL().m2670IiL(1, iilll1I11li1.f1946lL.m2687lLi1LL(), -this.ill1LI1l);
            this.f1946lL.m2687lLi1LL().m2670IiL(1, iilll1I11li1.f1946lL.m2687lLi1LL(), -this.ill1LI1l);
        } else {
            if (this.l1Lll == -1.0f || iilll1I11li1.m2652lIII() != iILLL1.ILil.FIXED) {
                return;
            }
            int i3 = (int) (iilll1I11li1.f18 * this.l1Lll);
            this.iIlLiL.m2687lLi1LL().m2670IiL(1, iilll1I11li1.iIlLiL.m2687lLi1LL(), i3);
            this.f1946lL.m2687lLi1LL().m2670IiL(1, iilll1I11li1.iIlLiL.m2687lLi1LL(), i3);
        }
    }

    @Override // ILil.p045lLi1LL.IL1Iii.ILL.iILLL1
    /* JADX INFO: renamed from: I丨iL */
    public lLi1LL mo2627IiL(lLi1LL.IL il) {
        switch (IL1Iii.f4522IL1Iii[il.ordinal()]) {
            case 1:
            case 2:
                if (this.f1966i11LL == 1) {
                    return this.f1965lIIiIlL;
                }
                break;
            case 3:
            case 4:
                if (this.f1966i11LL == 0) {
                    return this.f1965lIIiIlL;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
        }
        throw new AssertionError(il.name());
    }

    @Override // ILil.p045lLi1LL.IL1Iii.ILL.iILLL1
    /* JADX INFO: renamed from: L丨1丨1丨I */
    public ArrayList<lLi1LL> mo2636L11I() {
        return this.f1937lIII;
    }

    /* JADX INFO: renamed from: iI1L1丨Ll, reason: contains not printable characters */
    public void m2689iI1L1Ll(int i) {
        if (i > -1) {
            this.l1Lll = -1.0f;
            this.I1IILIIL = -1;
            this.ill1LI1l = i;
        }
    }

    /* JADX INFO: renamed from: iLiLI丨, reason: contains not printable characters */
    public void m2690iLiLI(float f) {
        if (f > -1.0f) {
            this.l1Lll = f;
            this.I1IILIIL = -1;
            this.ill1LI1l = -1;
        }
    }

    @Override // ILil.p045lLi1LL.IL1Iii.ILL.iILLL1
    /* JADX INFO: renamed from: iil1丨 */
    public void mo2644iil1(lLi1LL lli1ll) {
        if (I11li1() == null) {
            return;
        }
        int iM2720l = lli1ll.m2720l(this.f1965lIIiIlL);
        if (this.f1966i11LL == 1) {
            LIlLi(iM2720l);
            lI1I1(0);
            m87iI(I11li1().m2653lIlii());
            ILI1Ll(0);
            return;
        }
        LIlLi(0);
        lI1I1(iM2720l);
        ILI1Ll(I11li1().m2629L111());
        m87iI(0);
    }

    public void lLIL1(int i) {
        if (i > -1) {
            this.l1Lll = -1.0f;
            this.I1IILIIL = i;
            this.ill1LI1l = -1;
        }
    }

    /* JADX INFO: renamed from: 丨ILI, reason: contains not printable characters */
    public int m2691ILI() {
        return this.f1966i11LL;
    }

    /* JADX INFO: renamed from: 丨ili丨, reason: contains not printable characters */
    public void m2692ili(int i) {
        if (this.f1966i11LL == i) {
            return;
        }
        this.f1966i11LL = i;
        this.f1937lIII.clear();
        if (this.f1966i11LL == 1) {
            this.f1965lIIiIlL = this.iIi1;
        } else {
            this.f1965lIIiIlL = this.iIlLiL;
        }
        this.f1937lIII.add(this.f1965lIIiIlL);
        int length = this.f1928LlLLL.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f1928LlLLL[i2] = this.f1965lIIiIlL;
        }
    }
}
