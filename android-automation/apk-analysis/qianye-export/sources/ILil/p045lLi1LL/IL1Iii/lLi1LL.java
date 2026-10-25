package ILil.p045lLi1LL.IL1Iii;

import ILil.p045lLi1LL.IL1Iii.ILL.iILLL1;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: renamed from: ILil.l丨Li1LL.IL1Iii.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: LinearSystem.java */
/* JADX INFO: loaded from: classes.dex */
public class lLi1LL {
    public static int LlLI1 = 1000;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public static iILLL1 f1983llL1ii;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public IL1Iii f4533I1I;
    public final IL1Iii Lil;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final I1I f1987Ll1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public ILil[] f1991lLi1LL;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public int f4534IL1Iii = 0;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public HashMap<String, C0651il> f4535ILil = null;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f1985IL = 32;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public int f4536Ilil = 32;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public boolean f1989iILLL1 = false;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public boolean[] f1986IiL = new boolean[32];

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public int f1988L11I = 1;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public int f1992il = 0;
    public int ILL = 32;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public C0651il[] f1990lIiI = new C0651il[LlLI1];

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public int f1984ILl = 0;

    /* JADX INFO: renamed from: ILil.l丨Li1LL.IL1Iii.l丨Li1LL$IL1Iii */
    /* JADX INFO: compiled from: LinearSystem.java */
    public interface IL1Iii {
        void I1I(IL1Iii iL1Iii);

        void IL1Iii(C0651il c0651il);

        C0651il ILil(lLi1LL lli1ll, boolean[] zArr);

        void clear();

        C0651il getKey();
    }

    public lLi1LL() {
        this.f1991lLi1LL = null;
        this.f1991lLi1LL = new ILil[32];
        m2708L111();
        I1I i1i = new I1I();
        this.f1987Ll1 = i1i;
        this.f4533I1I = new IL(i1i);
        this.Lil = new ILil(i1i);
    }

    public static ILil iIlLiL(lLi1LL lli1ll, C0651il c0651il, C0651il c0651il2, C0651il c0651il3, float f, boolean z) {
        ILil iLilIIi1 = lli1ll.iIi1();
        if (z) {
            lli1ll.m2712iILLL1(iLilIIi1);
        }
        iLilIIi1.m2697L11I(c0651il, c0651il2, c0651il3, f);
        return iLilIIi1;
    }

    public static iILLL1 llliI() {
        return f1983llL1ii;
    }

    public I1I I11L() {
        return this.f1987Ll1;
    }

    public C0651il I11li1() {
        iILLL1 iilll1 = f1983llL1ii;
        if (iilll1 != null) {
            iilll1.f1975lIiI++;
        }
        if (this.f1988L11I + 1 >= this.f4536Ilil) {
            m27221();
        }
        C0651il c0651ilIL1Iii = IL1Iii(C0651il.IL1Iii.SLACK, null);
        int i = this.f4534IL1Iii + 1;
        this.f4534IL1Iii = i;
        this.f1988L11I++;
        c0651ilIL1Iii.f4539ILil = i;
        this.f1987Ll1.f4478I1I[i] = c0651ilIL1Iii;
        return c0651ilIL1Iii;
    }

    public void I1I(C0651il c0651il, C0651il c0651il2, int i, float f, C0651il c0651il3, C0651il c0651il4, int i2, int i3) {
        ILil iLilIIi1 = iIi1();
        iLilIIi1.m2698iILLL1(c0651il, c0651il2, i, f, c0651il3, c0651il4, i2);
        if (i3 != 6) {
            iLilIIi1.m2694IL(this, i3);
        }
        m2706IL(iLilIIi1);
    }

    public final C0651il IL1Iii(C0651il.IL1Iii iL1Iii, String str) {
        C0651il c0651ilILil = this.f1987Ll1.f4480ILil.ILil();
        if (c0651ilILil == null) {
            c0651ilILil = new C0651il(iL1Iii, str);
            c0651ilILil.Ilil(iL1Iii, str);
        } else {
            c0651ilILil.m2723IL();
            c0651ilILil.Ilil(iL1Iii, str);
        }
        int i = this.f1984ILl;
        int i2 = LlLI1;
        if (i >= i2) {
            int i3 = i2 * 2;
            LlLI1 = i3;
            this.f1990lIiI = (C0651il[]) Arrays.copyOf(this.f1990lIiI, i3);
        }
        C0651il[] c0651ilArr = this.f1990lIiI;
        int i4 = this.f1984ILl;
        this.f1984ILl = i4 + 1;
        c0651ilArr[i4] = c0651ilILil;
        return c0651ilILil;
    }

    public void ILL(C0651il c0651il, C0651il c0651il2, int i, int i2) {
        ILil iLilIIi1 = iIi1();
        C0651il c0651ilI11li1 = I11li1();
        c0651ilI11li1.f1993IL = 0;
        iLilIIi1.Lil(c0651il, c0651il2, c0651ilI11li1, i);
        if (i2 != 6) {
            m2705ILl(iLilIIi1, (int) (iLilIIi1.f1967IL.m2590lLi1LL(c0651ilI11li1) * (-1.0f)), i2);
        }
        m2706IL(iLilIIi1);
    }

    public void ILil(iILLL1 iilll1, iILLL1 iilll2, float f, int i) {
        ILil.p045lLi1LL.IL1Iii.ILL.lLi1LL.IL il = ILil.p045lLi1LL.IL1Iii.ILL.lLi1LL.IL.LEFT;
        C0651il c0651ilM2715lIlii = m2715lIlii(iilll1.mo2627IiL(il));
        ILil.p045lLi1LL.IL1Iii.ILL.lLi1LL.IL il2 = ILil.p045lLi1LL.IL1Iii.ILL.lLi1LL.IL.TOP;
        C0651il c0651ilM2715lIlii2 = m2715lIlii(iilll1.mo2627IiL(il2));
        ILil.p045lLi1LL.IL1Iii.ILL.lLi1LL.IL il3 = ILil.p045lLi1LL.IL1Iii.ILL.lLi1LL.IL.RIGHT;
        C0651il c0651ilM2715lIlii3 = m2715lIlii(iilll1.mo2627IiL(il3));
        ILil.p045lLi1LL.IL1Iii.ILL.lLi1LL.IL il4 = ILil.p045lLi1LL.IL1Iii.ILL.lLi1LL.IL.BOTTOM;
        C0651il c0651ilM2715lIlii4 = m2715lIlii(iilll1.mo2627IiL(il4));
        C0651il c0651ilM2715lIlii5 = m2715lIlii(iilll2.mo2627IiL(il));
        C0651il c0651ilM2715lIlii6 = m2715lIlii(iilll2.mo2627IiL(il2));
        C0651il c0651ilM2715lIlii7 = m2715lIlii(iilll2.mo2627IiL(il3));
        C0651il c0651ilM2715lIlii8 = m2715lIlii(iilll2.mo2627IiL(il4));
        ILil iLilIIi1 = iIi1();
        double d = f;
        double d2 = i;
        iLilIIi1.LlLI1(c0651ilM2715lIlii2, c0651ilM2715lIlii4, c0651ilM2715lIlii6, c0651ilM2715lIlii8, (float) (Math.sin(d) * d2));
        m2706IL(iLilIIi1);
        ILil iLilIIi2 = iIi1();
        iLilIIi2.LlLI1(c0651ilM2715lIlii, c0651ilM2715lIlii3, c0651ilM2715lIlii5, c0651ilM2715lIlii7, (float) (Math.cos(d) * d2));
        m2706IL(iLilIIi2);
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public void m2705ILl(ILil iLil, int i, int i2) {
        iLil.Ilil(LlLI1(i2, null), i);
    }

    public ILil Ilil(C0651il c0651il, C0651il c0651il2, int i, int i2) {
        ILil iLilIIi1 = iIi1();
        iLilIIi1.m2699lIiI(c0651il, c0651il2, i);
        if (i2 != 6) {
            iLilIIi1.m2694IL(this, i2);
        }
        m2706IL(iLilIIi1);
        return iLilIIi1;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m2706IL(ILil iLil) {
        C0651il c0651ilI11li1;
        if (iLil == null) {
            return;
        }
        iILLL1 iilll1 = f1983llL1ii;
        if (iilll1 != null) {
            iilll1.f1978lLi1LL++;
            if (iLil.f4526Ilil) {
                iilll1.f1974iILLL1++;
            }
        }
        boolean z = true;
        if (this.f1992il + 1 >= this.ILL || this.f1988L11I + 1 >= this.f4536Ilil) {
            m27221();
        }
        boolean z2 = false;
        if (!iLil.f4526Ilil) {
            m93(iLil);
            if (iLil.iIlLiL()) {
                return;
            }
            iLil.m2701llL1ii();
            if (iLil.m2702lLi1LL(this)) {
                C0651il c0651ilM2716llL1ii = m2716llL1ii();
                iLil.f4524IL1Iii = c0651ilM2716llL1ii;
                m2713lIiI(iLil);
                this.Lil.I1I(iLil);
                LL1IL(this.Lil, true);
                if (c0651ilM2716llL1ii.f4537I1I == -1) {
                    if (iLil.f4524IL1Iii == c0651ilM2716llL1ii && (c0651ilI11li1 = iLil.I11li1(c0651ilM2716llL1ii)) != null) {
                        iILLL1 iilll2 = f1983llL1ii;
                        if (iilll2 != null) {
                            iilll2.f1979il++;
                        }
                        iLil.m2704lL(c0651ilI11li1);
                    }
                    if (!iLil.f4526Ilil) {
                        iLil.f4524IL1Iii.m2724lLi1LL(iLil);
                    }
                    this.f1992il--;
                }
            } else {
                z = false;
            }
            if (!iLil.m2700lIlii()) {
                return;
            } else {
                z2 = z;
            }
        }
        if (z2) {
            return;
        }
        m2713lIiI(iLil);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m2707IiL(C0651il c0651il, C0651il c0651il2, boolean z) {
        ILil iLilIIi1 = iIi1();
        C0651il c0651ilI11li1 = I11li1();
        c0651ilI11li1.f1993IL = 0;
        iLilIIi1.m2693ILl(c0651il, c0651il2, c0651ilI11li1, 0);
        if (z) {
            m2705ILl(iLilIIi1, (int) (iLilIIi1.f1967IL.m2590lLi1LL(c0651ilI11li1) * (-1.0f)), 1);
        }
        m2706IL(iLilIIi1);
    }

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public final void m2708L111() {
        int i = 0;
        while (true) {
            ILil[] iLilArr = this.f1991lLi1LL;
            if (i >= iLilArr.length) {
                return;
            }
            ILil iLil = iLilArr[i];
            if (iLil != null) {
                this.f1987Ll1.f4479IL1Iii.IL1Iii(iLil);
            }
            this.f1991lLi1LL[i] = null;
            i++;
        }
    }

    public final int LL1IL(IL1Iii iL1Iii, boolean z) {
        iILLL1 iilll1 = f1983llL1ii;
        if (iilll1 != null) {
            iilll1.f1970IiL++;
        }
        for (int i = 0; i < this.f1988L11I; i++) {
            this.f1986IiL[i] = false;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            iILLL1 iilll2 = f1983llL1ii;
            if (iilll2 != null) {
                iilll2.f1972L11I++;
            }
            i2++;
            if (i2 >= this.f1988L11I * 2) {
                return i2;
            }
            if (iL1Iii.getKey() != null) {
                this.f1986IiL[iL1Iii.getKey().f4539ILil] = true;
            }
            C0651il c0651ilILil = iL1Iii.ILil(this, this.f1986IiL);
            if (c0651ilILil != null) {
                boolean[] zArr = this.f1986IiL;
                int i3 = c0651ilILil.f4539ILil;
                if (zArr[i3]) {
                    return i2;
                }
                zArr[i3] = true;
            }
            if (c0651ilILil != null) {
                float f = Float.MAX_VALUE;
                int i4 = -1;
                for (int i5 = 0; i5 < this.f1992il; i5++) {
                    ILil iLil = this.f1991lLi1LL[i5];
                    if (iLil.f4524IL1Iii.f1996iILLL1 != C0651il.IL1Iii.UNRESTRICTED && !iLil.f4526Ilil && iLil.iIi1(c0651ilILil)) {
                        float fM2590lLi1LL = iLil.f1967IL.m2590lLi1LL(c0651ilILil);
                        if (fM2590lLi1LL < 0.0f) {
                            float f2 = (-iLil.f4525ILil) / fM2590lLi1LL;
                            if (f2 < f) {
                                i4 = i5;
                                f = f2;
                            }
                        }
                    }
                }
                if (i4 > -1) {
                    ILil iLil2 = this.f1991lLi1LL[i4];
                    iLil2.f4524IL1Iii.f4537I1I = -1;
                    iILLL1 iilll3 = f1983llL1ii;
                    if (iilll3 != null) {
                        iilll3.f1979il++;
                    }
                    iLil2.m2704lL(c0651ilILil);
                    C0651il c0651il = iLil2.f4524IL1Iii;
                    c0651il.f4537I1I = i4;
                    c0651il.m2724lLi1LL(iLil2);
                }
            }
            z2 = true;
        }
        return i2;
    }

    public final void Lil() {
        for (int i = 0; i < this.f1992il; i++) {
            ILil iLil = this.f1991lLi1LL[i];
            iLil.f4524IL1Iii.f4540Ilil = iLil.f4525ILil;
        }
    }

    public C0651il LlLI1(int i, String str) {
        iILLL1 iilll1 = f1983llL1ii;
        if (iilll1 != null) {
            iilll1.f1971Ll1++;
        }
        if (this.f1988L11I + 1 >= this.f4536Ilil) {
            m27221();
        }
        C0651il c0651ilIL1Iii = IL1Iii(C0651il.IL1Iii.ERROR, str);
        int i2 = this.f4534IL1Iii + 1;
        this.f4534IL1Iii = i2;
        this.f1988L11I++;
        c0651ilIL1Iii.f4539ILil = i2;
        c0651ilIL1Iii.f1993IL = i;
        this.f1987Ll1.f4478I1I[i2] = c0651ilIL1Iii;
        this.f4533I1I.IL1Iii(c0651ilIL1Iii);
        return c0651ilIL1Iii;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public void m2709Ll1(C0651il c0651il, C0651il c0651il2, C0651il c0651il3, C0651il c0651il4, float f, int i) {
        ILil iLilIIi1 = iIi1();
        iLilIIi1.m2703il(c0651il, c0651il2, c0651il3, c0651il4, f);
        if (i != 6) {
            iLilIIi1.m2694IL(this, i);
        }
        m2706IL(iLilIIi1);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public void m2710L11I(C0651il c0651il, C0651il c0651il2, int i, int i2) {
        ILil iLilIIi1 = iIi1();
        C0651il c0651ilI11li1 = I11li1();
        c0651ilI11li1.f1993IL = 0;
        iLilIIi1.m2693ILl(c0651il, c0651il2, c0651ilI11li1, i);
        if (i2 != 6) {
            m2705ILl(iLilIIi1, (int) (iLilIIi1.f1967IL.m2590lLi1LL(c0651ilI11li1) * (-1.0f)), i2);
        }
        m2706IL(iLilIIi1);
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public void m2711LlLLL() throws Exception {
        iILLL1 iilll1 = f1983llL1ii;
        if (iilll1 != null) {
            iilll1.f4532Ilil++;
        }
        if (!this.f1989iILLL1) {
            m2714lIII(this.f4533I1I);
            return;
        }
        if (iilll1 != null) {
            iilll1.f1977llL1ii++;
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= this.f1992il) {
                z = true;
                break;
            } else if (!this.f1991lLi1LL[i].f4526Ilil) {
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            m2714lIII(this.f4533I1I);
            return;
        }
        iILLL1 iilll2 = f1983llL1ii;
        if (iilll2 != null) {
            iilll2.LlLI1++;
        }
        Lil();
    }

    public ILil iIi1() {
        ILil ILil2 = this.f1987Ll1.f4479IL1Iii.ILil();
        if (ILil2 == null) {
            ILil2 = new ILil(this.f1987Ll1);
        } else {
            ILil2.I11L();
        }
        C0651il.ILil();
        return ILil2;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final void m2712iILLL1(ILil iLil) {
        iLil.m2694IL(this, 0);
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final void m2713lIiI(ILil iLil) {
        ILil[] iLilArr = this.f1991lLi1LL;
        int i = this.f1992il;
        if (iLilArr[i] != null) {
            this.f1987Ll1.f4479IL1Iii.IL1Iii(iLilArr[i]);
        }
        ILil[] iLilArr2 = this.f1991lLi1LL;
        int i2 = this.f1992il;
        iLilArr2[i2] = iLil;
        C0651il c0651il = iLil.f4524IL1Iii;
        c0651il.f4537I1I = i2;
        this.f1992il = i2 + 1;
        c0651il.m2724lLi1LL(iLil);
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public void m2714lIII(IL1Iii iL1Iii) throws Exception {
        iILLL1 iilll1 = f1983llL1ii;
        if (iilll1 != null) {
            iilll1.iIi1++;
            iilll1.iIlLiL = Math.max(iilll1.iIlLiL, this.f1988L11I);
            iILLL1 iilll2 = f1983llL1ii;
            iilll2.I11li1 = Math.max(iilll2.I11li1, this.f1992il);
        }
        m93((ILil) iL1Iii);
        m2719lL(iL1Iii);
        LL1IL(iL1Iii, false);
        Lil();
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public C0651il m2715lIlii(Object obj) {
        C0651il c0651ilM2685iILLL1 = null;
        if (obj == null) {
            return null;
        }
        if (this.f1988L11I + 1 >= this.f4536Ilil) {
            m27221();
        }
        if (obj instanceof ILil.p045lLi1LL.IL1Iii.ILL.lLi1LL) {
            ILil.p045lLi1LL.IL1Iii.ILL.lLi1LL lli1ll = (ILil.p045lLi1LL.IL1Iii.ILL.lLi1LL) obj;
            c0651ilM2685iILLL1 = lli1ll.m2685iILLL1();
            if (c0651ilM2685iILLL1 == null) {
                lli1ll.m2680ILl(this.f1987Ll1);
                c0651ilM2685iILLL1 = lli1ll.m2685iILLL1();
            }
            int i = c0651ilM2685iILLL1.f4539ILil;
            if (i == -1 || i > this.f4534IL1Iii || this.f1987Ll1.f4478I1I[i] == null) {
                if (i != -1) {
                    c0651ilM2685iILLL1.m2723IL();
                }
                int i2 = this.f4534IL1Iii + 1;
                this.f4534IL1Iii = i2;
                this.f1988L11I++;
                c0651ilM2685iILLL1.f4539ILil = i2;
                c0651ilM2685iILLL1.f1996iILLL1 = C0651il.IL1Iii.UNRESTRICTED;
                this.f1987Ll1.f4478I1I[i2] = c0651ilM2685iILLL1;
            }
        }
        return c0651ilM2685iILLL1;
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public C0651il m2716llL1ii() {
        iILLL1 iilll1 = f1983llL1ii;
        if (iilll1 != null) {
            iilll1.f1968ILl++;
        }
        if (this.f1988L11I + 1 >= this.f4536Ilil) {
            m27221();
        }
        C0651il c0651ilIL1Iii = IL1Iii(C0651il.IL1Iii.SLACK, null);
        int i = this.f4534IL1Iii + 1;
        this.f4534IL1Iii = i;
        this.f1988L11I++;
        c0651ilIL1Iii.f4539ILil = i;
        this.f1987Ll1.f4478I1I[i] = c0651ilIL1Iii;
        return c0651ilIL1Iii;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void m2717lLi1LL(C0651il c0651il, int i) {
        int i2 = c0651il.f4537I1I;
        if (i2 == -1) {
            ILil iLilIIi1 = iIi1();
            iLilIIi1.m2695IiL(c0651il, i);
            m2706IL(iLilIIi1);
            return;
        }
        ILil iLil = this.f1991lLi1LL[i2];
        if (iLil.f4526Ilil) {
            iLil.f4525ILil = i;
            return;
        }
        if (iLil.f1967IL.f4482IL1Iii == 0) {
            iLil.f4526Ilil = true;
            iLil.f4525ILil = i;
        } else {
            ILil iLilIIi2 = iIi1();
            iLilIIi2.m2696Ll1(c0651il, i);
            m2706IL(iLilIIi2);
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void m2718il(C0651il c0651il, C0651il c0651il2, boolean z) {
        ILil iLilIIi1 = iIi1();
        C0651il c0651ilI11li1 = I11li1();
        c0651ilI11li1.f1993IL = 0;
        iLilIIi1.Lil(c0651il, c0651il2, c0651ilI11li1, 0);
        if (z) {
            m2705ILl(iLilIIi1, (int) (iLilIIi1.f1967IL.m2590lLi1LL(c0651ilI11li1) * (-1.0f)), 1);
        }
        m2706IL(iLilIIi1);
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public final int m2719lL(IL1Iii iL1Iii) throws Exception {
        float f;
        boolean z;
        int i = 0;
        while (true) {
            f = 0.0f;
            if (i >= this.f1992il) {
                z = false;
                break;
            }
            ILil[] iLilArr = this.f1991lLi1LL;
            if (iLilArr[i].f4524IL1Iii.f1996iILLL1 != C0651il.IL1Iii.UNRESTRICTED && iLilArr[i].f4525ILil < 0.0f) {
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            return 0;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            iILLL1 iilll1 = f1983llL1ii;
            if (iilll1 != null) {
                iilll1.ILL++;
            }
            i2++;
            float f2 = Float.MAX_VALUE;
            int i3 = 0;
            int i4 = -1;
            int i5 = -1;
            int i6 = 0;
            while (i3 < this.f1992il) {
                ILil iLil = this.f1991lLi1LL[i3];
                if (iLil.f4524IL1Iii.f1996iILLL1 != C0651il.IL1Iii.UNRESTRICTED && !iLil.f4526Ilil && iLil.f4525ILil < f) {
                    int i7 = 1;
                    while (i7 < this.f1988L11I) {
                        C0651il c0651il = this.f1987Ll1.f4478I1I[i7];
                        float fM2590lLi1LL = iLil.f1967IL.m2590lLi1LL(c0651il);
                        if (fM2590lLi1LL > f) {
                            for (int i8 = 0; i8 < 7; i8++) {
                                float f3 = c0651il.f1997lLi1LL[i8] / fM2590lLi1LL;
                                if ((f3 < f2 && i8 == i6) || i8 > i6) {
                                    i5 = i7;
                                    i6 = i8;
                                    f2 = f3;
                                    i4 = i3;
                                }
                            }
                        }
                        i7++;
                        f = 0.0f;
                    }
                }
                i3++;
                f = 0.0f;
            }
            if (i4 != -1) {
                ILil iLil2 = this.f1991lLi1LL[i4];
                iLil2.f4524IL1Iii.f4537I1I = -1;
                iILLL1 iilll2 = f1983llL1ii;
                if (iilll2 != null) {
                    iilll2.f1979il++;
                }
                iLil2.m2704lL(this.f1987Ll1.f4478I1I[i5]);
                C0651il c0651il2 = iLil2.f4524IL1Iii;
                c0651il2.f4537I1I = i4;
                c0651il2.m2724lLi1LL(iLil2);
            } else {
                z2 = true;
            }
            if (i2 > this.f1988L11I / 2) {
                z2 = true;
            }
            f = 0.0f;
        }
        return i2;
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public int m2720l(Object obj) {
        C0651il c0651ilM2685iILLL1 = ((ILil.p045lLi1LL.IL1Iii.ILL.lLi1LL) obj).m2685iILLL1();
        if (c0651ilM2685iILLL1 != null) {
            return (int) (c0651ilM2685iILLL1.f4540Ilil + 0.5f);
        }
        return 0;
    }

    /* JADX INFO: renamed from: 丨丨 */
    public final void m93(ILil iLil) {
        if (this.f1992il > 0) {
            iLil.f1967IL.Lil(iLil, this.f1991lLi1LL);
            if (iLil.f1967IL.f4482IL1Iii == 0) {
                iLil.f4526Ilil = true;
            }
        }
    }

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public void m2721LLlI1() {
        I1I i1i;
        int i = 0;
        while (true) {
            i1i = this.f1987Ll1;
            C0651il[] c0651ilArr = i1i.f4478I1I;
            if (i >= c0651ilArr.length) {
                break;
            }
            C0651il c0651il = c0651ilArr[i];
            if (c0651il != null) {
                c0651il.m2723IL();
            }
            i++;
        }
        i1i.f4480ILil.I1I(this.f1990lIiI, this.f1984ILl);
        this.f1984ILl = 0;
        Arrays.fill(this.f1987Ll1.f4478I1I, (Object) null);
        HashMap<String, C0651il> map = this.f4535ILil;
        if (map != null) {
            map.clear();
        }
        this.f4534IL1Iii = 0;
        this.f4533I1I.clear();
        this.f1988L11I = 1;
        for (int i2 = 0; i2 < this.f1992il; i2++) {
            this.f1991lLi1LL[i2].f4523I1I = false;
        }
        m2708L111();
        this.f1992il = 0;
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public final void m27221() {
        int i = this.f1985IL * 2;
        this.f1985IL = i;
        this.f1991lLi1LL = (ILil[]) Arrays.copyOf(this.f1991lLi1LL, i);
        I1I i1i = this.f1987Ll1;
        i1i.f4478I1I = (C0651il[]) Arrays.copyOf(i1i.f4478I1I, this.f1985IL);
        int i2 = this.f1985IL;
        this.f1986IiL = new boolean[i2];
        this.f4536Ilil = i2;
        this.ILL = i2;
        iILLL1 iilll1 = f1983llL1ii;
        if (iilll1 != null) {
            iilll1.f1969IL++;
            iilll1.Lil = Math.max(iilll1.Lil, i2);
            iILLL1 iilll2 = f1983llL1ii;
            iilll2.f1973LlLLL = iilll2.Lil;
        }
    }
}
