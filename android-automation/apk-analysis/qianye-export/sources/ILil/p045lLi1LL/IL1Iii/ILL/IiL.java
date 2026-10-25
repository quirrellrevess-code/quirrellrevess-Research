package ILil.p045lLi1LL.IL1Iii.ILL;

import ILil.p045lLi1LL.IL1Iii.lLi1LL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: ILil.l丨Li1LL.IL1Iii.ILL.I丨iL, reason: invalid class name */
/* JADX INFO: compiled from: ConstraintWidgetContainer.java */
/* JADX INFO: loaded from: classes.dex */
public class IiL extends llL1ii {
    public int LI11;
    public int LiL1;

    /* JADX INFO: renamed from: iIl1il丨, reason: contains not printable characters */
    public int f1896iIl1il;

    /* JADX INFO: renamed from: lIIiIlL丨, reason: contains not printable characters */
    public LlLI1 f1900lIIiIlL;

    /* JADX INFO: renamed from: 丨i1丨1丨LL, reason: contains not printable characters */
    public int f1903i11LL;
    public boolean I1IILIIL = false;
    public lLi1LL ill1LI1l = new lLi1LL();
    public int Liil1L1l = 0;

    /* JADX INFO: renamed from: LL */
    public int f9LL = 0;

    /* JADX INFO: renamed from: i丨1I1I1l, reason: contains not printable characters */
    public IL[] f1898i1I1I1l = new IL[4];

    /* JADX INFO: renamed from: iI丨1LI, reason: contains not printable characters */
    public IL[] f1897iI1LI = new IL[4];

    /* JADX INFO: renamed from: 丨1 */
    public List<L11I> f121 = new ArrayList();

    /* JADX INFO: renamed from: i丨ILiiLl, reason: contains not printable characters */
    public boolean f1899iILiiLl = false;
    public boolean ILI1Ll = false;

    /* JADX INFO: renamed from: l丨 */
    public boolean f11l = false;

    /* JADX INFO: renamed from: 丨1丨iIl, reason: contains not printable characters */
    public int f19011iIl = 0;
    public int LII = 0;
    public int LIlLi = 7;
    public boolean lI1I1 = false;

    /* JADX INFO: renamed from: li */
    public boolean f10li = false;

    /* JADX INFO: renamed from: 丨IillIi, reason: contains not printable characters */
    public boolean f1902IillIi = false;

    /* JADX INFO: renamed from: I11II丨i, reason: contains not printable characters */
    public void m2606I11IIi() {
        if (!m2609LL(8)) {
            mo2601IL(this.LIlLi);
        }
        Ll1();
    }

    public final void IIi1II(iILLL1 iilll1) {
        int i = this.Liil1L1l + 1;
        IL[] ilArr = this.f1897iI1LI;
        if (i >= ilArr.length) {
            this.f1897iI1LI = (IL[]) Arrays.copyOf(ilArr, ilArr.length * 2);
        }
        this.f1897iI1LI[this.Liil1L1l] = new IL(iilll1, 0, Li1l());
        this.Liil1L1l++;
    }

    @Override // ILil.p045lLi1LL.IL1Iii.ILL.llL1ii, ILil.p045lLi1LL.IL1Iii.ILL.iILLL1
    /* JADX INFO: renamed from: IIi丨丨I, reason: contains not printable characters */
    public void mo2607IIiI() {
        this.ill1LI1l.m2721LLlI1();
        this.f1903i11LL = 0;
        this.LI11 = 0;
        this.f1896iIl1il = 0;
        this.LiL1 = 0;
        this.f121.clear();
        this.lI1I1 = false;
        super.mo2607IIiI();
    }

    public void IL1(boolean z) {
        this.I1IILIIL = z;
    }

    /* JADX INFO: renamed from: IL11L丨, reason: contains not printable characters */
    public boolean m2608IL11L() {
        return false;
    }

    @Override // ILil.p045lLi1LL.IL1Iii.ILL.iILLL1
    /* JADX INFO: renamed from: I丨L */
    public void mo2601IL(int i) {
        super.mo2601IL(i);
        int size = this.l1Lll.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.l1Lll.get(i2).mo2601IL(i);
        }
    }

    public boolean L1ii1() {
        return this.f1902IillIi;
    }

    public int L1li1() {
        return this.LIlLi;
    }

    public void LIiiILi(lLi1LL lli1ll, boolean[] zArr) {
        zArr[2] = false;
        mo2644iil1(lli1ll);
        int size = this.l1Lll.size();
        for (int i = 0; i < size; i++) {
            iILLL1 iilll1 = this.l1Lll.get(i);
            iilll1.mo2644iil1(lli1ll);
            iILLL1.ILil iLil = iilll1.LL1IL[0];
            iILLL1.ILil iLil2 = iILLL1.ILil.MATCH_CONSTRAINT;
            if (iLil == iLil2 && iilll1.m2629L111() < iilll1.m92()) {
                zArr[2] = true;
            }
            if (iilll1.LL1IL[1] == iLil2 && iilll1.m2653lIlii() < iilll1.m2666LLlI1()) {
                zArr[2] = true;
            }
        }
    }

    /* JADX INFO: renamed from: LL丨, reason: contains not printable characters */
    public boolean m2609LL(int i) {
        return (this.LIlLi & i) == i;
    }

    public boolean Li1l() {
        return this.I1IILIIL;
    }

    /* JADX INFO: renamed from: Li1丨IL1, reason: contains not printable characters */
    public void m2610Li1IL1(iILLL1 iilll1, int i) {
        if (i == 0) {
            IIi1II(iilll1);
        } else if (i == 1) {
            m82i(iilll1);
        }
    }

    public void Ll1() {
        lIiI liiiM2687lLi1LL = mo2627IiL(lLi1LL.IL.LEFT).m2687lLi1LL();
        lIiI liiiM2687lLi1LL2 = mo2627IiL(lLi1LL.IL.TOP).m2687lLi1LL();
        liiiM2687lLi1LL.m2671Ll1(null, 0.0f);
        liiiM2687lLi1LL2.m2671Ll1(null, 0.0f);
    }

    /* JADX INFO: renamed from: Lll丨I11, reason: contains not printable characters */
    public void m2611LllI11(int i) {
        this.LIlLi = i;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0247  */
    /* JADX WARN: Code duplicated, block: B:108:0x0258  */
    /* JADX WARN: Code duplicated, block: B:111:0x0275  */
    /* JADX WARN: Code duplicated, block: B:112:0x0282  */
    /* JADX WARN: Code duplicated, block: B:114:0x0287  */
    /* JADX WARN: Code duplicated, block: B:116:0x0290 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:122:0x02ac A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:126:0x02c2 A[PHI: r0 r9
  0x02c2: PHI (r0v31 boolean) = (r0v30 boolean), (r0v33 boolean), (r0v33 boolean), (r0v33 boolean) binds: [B:113:0x0285, B:121:0x02aa, B:122:0x02ac, B:124:0x02b2] A[DONT_GENERATE, DONT_INLINE]
  0x02c2: PHI (r9v7 boolean) = (r9v6 boolean), (r9v9 boolean), (r9v9 boolean), (r9v9 boolean) binds: [B:113:0x0285, B:121:0x02aa, B:122:0x02ac, B:124:0x02b2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:160:0x018b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:161:0x01b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x0184  */
    /* JADX WARN: Code duplicated, block: B:73:0x018f  */
    /* JADX WARN: Code duplicated, block: B:75:0x0197  */
    /* JADX WARN: Code duplicated, block: B:77:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:80:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:88:0x01dd  */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v26 */
    @Override // ILil.p045lLi1LL.IL1Iii.ILL.llL1ii
    /* JADX INFO: renamed from: iI1L1丨Ll, reason: contains not printable characters */
    public void mo2612iI1L1Ll() {
        int i;
        int i2;
        int i3;
        iILLL1 iilll1;
        iILLL1.ILil iLil;
        iILLL1.ILil iLil2;
        int i4;
        char c;
        boolean z;
        int iMax;
        int iMax2;
        ?? r8;
        boolean z2;
        iILLL1.ILil iLil3;
        iILLL1.ILil iLil4;
        int i5 = this.f1926L1l;
        int i6 = this.f1944iILLl;
        int iMax3 = Math.max(0, m2629L111());
        int iMax4 = Math.max(0, m2653lIlii());
        this.f10li = false;
        this.f1902IillIi = false;
        if (this.f1920L111 != null) {
            if (this.f1900lIIiIlL == null) {
                this.f1900lIIiIlL = new LlLI1(this);
            }
            this.f1900lIIiIlL.ILil(this);
            LIlLi(this.f1903i11LL);
            lI1I1(this.f1896iIl1il);
            m2656lliiI1();
            mo2638iI1iI(this.ill1LI1l.I11L());
        } else {
            this.f1926L1l = 0;
            this.f1944iILLl = 0;
        }
        int i7 = 32;
        if (this.LIlLi != 0) {
            if (!m2609LL(8)) {
                m2616li1Ii1i();
            }
            if (!m2609LL(32)) {
                m2606I11IIi();
            }
            this.ill1LI1l.f1989iILLL1 = true;
        } else {
            this.ill1LI1l.f1989iILLL1 = false;
        }
        iILLL1.ILil[] iLilArr = this.LL1IL;
        iILLL1.ILil iLil5 = iLilArr[1];
        iILLL1.ILil iLil6 = iLilArr[0];
        m2614iLI();
        if (this.f121.size() == 0) {
            this.f121.clear();
            this.f121.add(0, new L11I(this.l1Lll));
        }
        int size = this.f121.size();
        ArrayList<iILLL1> arrayList = this.l1Lll;
        iILLL1.ILil iLilIIi1 = iIi1();
        iILLL1.ILil iLil7 = iILLL1.ILil.WRAP_CONTENT;
        boolean z3 = iLilIIi1 == iLil7 || m2652lIII() == iLil7;
        boolean z4 = false;
        int i8 = 0;
        while (i8 < size && !this.lI1I1) {
            if (this.f121.get(i8).f1906IL) {
                i = i6;
                i2 = size;
            } else {
                if (m2609LL(i7)) {
                    iILLL1.ILil iLilIIi2 = iIi1();
                    iILLL1.ILil iLil8 = iILLL1.ILil.FIXED;
                    if (iLilIIi2 == iLil8 && m2652lIII() == iLil8) {
                        this.l1Lll = (ArrayList) this.f121.get(i8).m2621IL();
                    } else {
                        this.l1Lll = (ArrayList) this.f121.get(i8).f4502IL1Iii;
                    }
                }
                m2614iLI();
                int size2 = this.l1Lll.size();
                for (int i9 = 0; i9 < size2; i9++) {
                    iILLL1 iilll2 = this.l1Lll.get(i9);
                    if (iilll2 instanceof llL1ii) {
                        ((llL1ii) iilll2).mo2612iI1L1Ll();
                    }
                }
                boolean z5 = z4;
                int i10 = 0;
                boolean zM2613iliiL = true;
                while (zM2613iliiL) {
                    boolean z6 = z5;
                    int i11 = i10 + 1;
                    try {
                        this.ill1LI1l.m2721LLlI1();
                        m2614iLI();
                        m2641iILLL1(this.ill1LI1l);
                        int i12 = 0;
                        while (i12 < size2) {
                            boolean z7 = zM2613iliiL;
                            try {
                                this.l1Lll.get(i12).m2641iILLL1(this.ill1LI1l);
                                i12++;
                                zM2613iliiL = z7;
                            } catch (Exception e) {
                                e = e;
                                zM2613iliiL = z7;
                                e.printStackTrace();
                                System.out.println("EXCEPTION : " + e);
                                zM2613iliiL = zM2613iliiL;
                                if (zM2613iliiL) {
                                    LIiiILi(this.ill1LI1l, Ll1.f4500IL1Iii);
                                } else {
                                    mo2644iil1(this.ill1LI1l);
                                    i3 = 0;
                                    while (true) {
                                        if (i3 < size2) {
                                            iilll1 = this.l1Lll.get(i3);
                                            iLil = iilll1.LL1IL[0];
                                            iLil2 = iILLL1.ILil.MATCH_CONSTRAINT;
                                            if (iLil == iLil2) {
                                                i4 = i6;
                                                if (iilll1.m2629L111() < iilll1.m92()) {
                                                    c = 2;
                                                    Ll1.f4500IL1Iii[2] = true;
                                                    break;
                                                }
                                            } else {
                                                i4 = i6;
                                            }
                                            if (iilll1.LL1IL[1] != iLil2) {
                                            }
                                            i3++;
                                            i6 = i4;
                                        }
                                    }
                                    if (z3) {
                                        z = false;
                                    } else {
                                        z = false;
                                    }
                                    iMax = Math.max(this.f1941lliiI1, m2629L111());
                                    if (iMax > m2629L111()) {
                                        ILI1Ll(iMax);
                                        this.LL1IL[0] = iILLL1.ILil.FIXED;
                                        z = true;
                                        z6 = true;
                                    }
                                    iMax2 = Math.max(this.LLL, m2653lIlii());
                                    if (iMax2 > m2653lIlii()) {
                                        m87iI(iMax2);
                                        r8 = 1;
                                        this.LL1IL[1] = iILLL1.ILil.FIXED;
                                        z = true;
                                        z2 = true;
                                    } else {
                                        r8 = 1;
                                        z2 = z6;
                                    }
                                    if (z2) {
                                        zM2613iliiL = z;
                                    } else {
                                        iLil3 = this.LL1IL[0];
                                        iLil4 = iILLL1.ILil.WRAP_CONTENT;
                                        if (iLil3 == iLil4) {
                                            this.f10li = r8;
                                            this.LL1IL[0] = iILLL1.ILil.FIXED;
                                            ILI1Ll(iMax3);
                                            z = true;
                                            z2 = true;
                                        }
                                        if (this.LL1IL[r8] == iLil4) {
                                            zM2613iliiL = z;
                                        } else {
                                            zM2613iliiL = z;
                                        }
                                    }
                                    i10 = i11;
                                    z5 = z2;
                                    size = size;
                                    i6 = i4;
                                }
                                i4 = i6;
                                c = 2;
                                if (z3) {
                                    z = false;
                                } else {
                                    z = false;
                                }
                                iMax = Math.max(this.f1941lliiI1, m2629L111());
                                if (iMax > m2629L111()) {
                                    ILI1Ll(iMax);
                                    this.LL1IL[0] = iILLL1.ILil.FIXED;
                                    z = true;
                                    z6 = true;
                                }
                                iMax2 = Math.max(this.LLL, m2653lIlii());
                                if (iMax2 > m2653lIlii()) {
                                    m87iI(iMax2);
                                    r8 = 1;
                                    this.LL1IL[1] = iILLL1.ILil.FIXED;
                                    z = true;
                                    z2 = true;
                                } else {
                                    r8 = 1;
                                    z2 = z6;
                                }
                                if (z2) {
                                    iLil3 = this.LL1IL[0];
                                    iLil4 = iILLL1.ILil.WRAP_CONTENT;
                                    if (iLil3 == iLil4) {
                                        this.f10li = r8;
                                        this.LL1IL[0] = iILLL1.ILil.FIXED;
                                        ILI1Ll(iMax3);
                                        z = true;
                                        z2 = true;
                                    }
                                    if (this.LL1IL[r8] == iLil4) {
                                        zM2613iliiL = z;
                                    } else {
                                        zM2613iliiL = z;
                                    }
                                } else {
                                    zM2613iliiL = z;
                                }
                                i10 = i11;
                                z5 = z2;
                                size = size;
                                i6 = i4;
                            }
                        }
                        zM2613iliiL = m2613iliiL(this.ill1LI1l);
                        if (zM2613iliiL) {
                            try {
                                this.ill1LI1l.m2711LlLLL();
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                System.out.println("EXCEPTION : " + e);
                                zM2613iliiL = zM2613iliiL;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                    if (zM2613iliiL) {
                        LIiiILi(this.ill1LI1l, Ll1.f4500IL1Iii);
                    } else {
                        mo2644iil1(this.ill1LI1l);
                        i3 = 0;
                        while (true) {
                            if (i3 < size2) {
                                iilll1 = this.l1Lll.get(i3);
                                iLil = iilll1.LL1IL[0];
                                iLil2 = iILLL1.ILil.MATCH_CONSTRAINT;
                                if (iLil == iLil2) {
                                    i4 = i6;
                                    if (iilll1.m2629L111() < iilll1.m92()) {
                                        c = 2;
                                        Ll1.f4500IL1Iii[2] = true;
                                        break;
                                    }
                                } else {
                                    i4 = i6;
                                }
                                if (iilll1.LL1IL[1] != iLil2 && iilll1.m2653lIlii() < iilll1.m2666LLlI1()) {
                                    c = 2;
                                    Ll1.f4500IL1Iii[2] = true;
                                    break;
                                } else {
                                    i3++;
                                    i6 = i4;
                                }
                            }
                        }
                        if (z3 || i11 >= 8 || !Ll1.f4500IL1Iii[c]) {
                            z = false;
                        } else {
                            int iMax5 = 0;
                            int iMax6 = 0;
                            for (int i13 = 0; i13 < size2; i13++) {
                                iILLL1 iilll3 = this.l1Lll.get(i13);
                                iMax5 = Math.max(iMax5, iilll3.f1926L1l + iilll3.m2629L111());
                                iMax6 = Math.max(iMax6, iilll3.f1944iILLl + iilll3.m2653lIlii());
                            }
                            int iMax7 = Math.max(this.f1941lliiI1, iMax5);
                            int iMax8 = Math.max(this.LLL, iMax6);
                            iILLL1.ILil iLil9 = iILLL1.ILil.WRAP_CONTENT;
                            if (iLil6 != iLil9 || m2629L111() >= iMax7) {
                                z = false;
                            } else {
                                ILI1Ll(iMax7);
                                this.LL1IL[0] = iLil9;
                                z = true;
                                z6 = true;
                            }
                            if (iLil5 == iLil9 && m2653lIlii() < iMax8) {
                                m87iI(iMax8);
                                this.LL1IL[1] = iLil9;
                                z = true;
                                z6 = true;
                            }
                        }
                        iMax = Math.max(this.f1941lliiI1, m2629L111());
                        if (iMax > m2629L111()) {
                            ILI1Ll(iMax);
                            this.LL1IL[0] = iILLL1.ILil.FIXED;
                            z = true;
                            z6 = true;
                        }
                        iMax2 = Math.max(this.LLL, m2653lIlii());
                        if (iMax2 > m2653lIlii()) {
                            m87iI(iMax2);
                            r8 = 1;
                            this.LL1IL[1] = iILLL1.ILil.FIXED;
                            z = true;
                            z2 = true;
                        } else {
                            r8 = 1;
                            z2 = z6;
                        }
                        if (z2) {
                            iLil3 = this.LL1IL[0];
                            iLil4 = iILLL1.ILil.WRAP_CONTENT;
                            if (iLil3 == iLil4 && iMax3 > 0 && m2629L111() > iMax3) {
                                this.f10li = r8;
                                this.LL1IL[0] = iILLL1.ILil.FIXED;
                                ILI1Ll(iMax3);
                                z = true;
                                z2 = true;
                            }
                            if (this.LL1IL[r8] == iLil4 || iMax4 <= 0 || m2653lIlii() <= iMax4) {
                                zM2613iliiL = z;
                            } else {
                                this.f1902IillIi = r8;
                                this.LL1IL[r8] = iILLL1.ILil.FIXED;
                                m87iI(iMax4);
                                zM2613iliiL = true;
                                z2 = true;
                            }
                        } else {
                            zM2613iliiL = z;
                        }
                        i10 = i11;
                        z5 = z2;
                        size = size;
                        i6 = i4;
                    }
                    i4 = i6;
                    c = 2;
                    if (z3) {
                        z = false;
                    } else {
                        z = false;
                    }
                    iMax = Math.max(this.f1941lliiI1, m2629L111());
                    if (iMax > m2629L111()) {
                        ILI1Ll(iMax);
                        this.LL1IL[0] = iILLL1.ILil.FIXED;
                        z = true;
                        z6 = true;
                    }
                    iMax2 = Math.max(this.LLL, m2653lIlii());
                    if (iMax2 > m2653lIlii()) {
                        m87iI(iMax2);
                        r8 = 1;
                        this.LL1IL[1] = iILLL1.ILil.FIXED;
                        z = true;
                        z2 = true;
                    } else {
                        r8 = 1;
                        z2 = z6;
                    }
                    if (z2) {
                        iLil3 = this.LL1IL[0];
                        iLil4 = iILLL1.ILil.WRAP_CONTENT;
                        if (iLil3 == iLil4) {
                            this.f10li = r8;
                            this.LL1IL[0] = iILLL1.ILil.FIXED;
                            ILI1Ll(iMax3);
                            z = true;
                            z2 = true;
                        }
                        if (this.LL1IL[r8] == iLil4) {
                            zM2613iliiL = z;
                        } else {
                            zM2613iliiL = z;
                        }
                    } else {
                        zM2613iliiL = z;
                    }
                    i10 = i11;
                    z5 = z2;
                    size = size;
                    i6 = i4;
                }
                i = i6;
                i2 = size;
                this.f121.get(i8).m2622iILLL1();
                z4 = z5;
            }
            i8++;
            size = i2;
            i6 = i;
            i7 = 32;
        }
        int i14 = i6;
        this.l1Lll = arrayList;
        if (this.f1920L111 != null) {
            int iMax9 = Math.max(this.f1941lliiI1, m2629L111());
            int iMax10 = Math.max(this.LLL, m2653lIlii());
            this.f1900lIIiIlL.IL1Iii(this);
            ILI1Ll(iMax9 + this.f1903i11LL + this.LI11);
            m87iI(iMax10 + this.f1896iIl1il + this.LiL1);
        } else {
            this.f1926L1l = i5;
            this.f1944iILLl = i14;
        }
        if (z4) {
            iILLL1.ILil[] iLilArr2 = this.LL1IL;
            iLilArr2[0] = iLil6;
            iLilArr2[1] = iLil5;
        }
        mo2638iI1iI(this.ill1LI1l.I11L());
        if (this == lLIL1()) {
            mo2659IillIi();
        }
    }

    /* JADX INFO: renamed from: il丨iiL丨, reason: contains not printable characters */
    public boolean m2613iliiL(lLi1LL lli1ll) {
        ILil(lli1ll);
        int size = this.l1Lll.size();
        for (int i = 0; i < size; i++) {
            iILLL1 iilll1 = this.l1Lll.get(i);
            if (iilll1 instanceof IiL) {
                iILLL1.ILil[] iLilArr = iilll1.LL1IL;
                iILLL1.ILil iLil = iLilArr[0];
                iILLL1.ILil iLil2 = iLilArr[1];
                iILLL1.ILil iLil3 = iILLL1.ILil.WRAP_CONTENT;
                if (iLil == iLil3) {
                    iilll1.m83I1(iILLL1.ILil.FIXED);
                }
                if (iLil2 == iLil3) {
                    iilll1.m2647i1I1I1l(iILLL1.ILil.FIXED);
                }
                iilll1.ILil(lli1ll);
                if (iLil == iLil3) {
                    iilll1.m83I1(iLil);
                }
                if (iLil2 == iLil3) {
                    iilll1.m2647i1I1I1l(iLil2);
                }
            } else {
                Ll1.I1I(this, lli1ll, iilll1);
                iilll1.ILil(lli1ll);
            }
        }
        if (this.Liil1L1l > 0) {
            I1I.IL1Iii(this, lli1ll, 0);
        }
        if (this.f9LL > 0) {
            I1I.IL1Iii(this, lli1ll, 1);
        }
        return true;
    }

    /* JADX INFO: renamed from: i丨LI, reason: contains not printable characters */
    public final void m2614iLI() {
        this.Liil1L1l = 0;
        this.f9LL = 0;
    }

    public void lI11lLL() {
        m2616li1Ii1i();
        mo2601IL(this.LIlLi);
    }

    /* JADX INFO: renamed from: 丨IL1i丨LI, reason: contains not printable characters */
    public void m2615IL1iLI(int i, int i2) {
        C0649ILl c0649ILl;
        C0649ILl c0649ILl2;
        iILLL1.ILil iLil = this.LL1IL[0];
        iILLL1.ILil iLil2 = iILLL1.ILil.WRAP_CONTENT;
        if (iLil != iLil2 && (c0649ILl2 = this.f4505I1I) != null) {
            c0649ILl2.m2604IiL(i);
        }
        if (this.LL1IL[1] == iLil2 || (c0649ILl = this.f1917IL) == null) {
            return;
        }
        c0649ILl.m2604IiL(i2);
    }

    /* JADX INFO: renamed from: 丨i */
    public final void m82i(iILLL1 iilll1) {
        int i = this.f9LL + 1;
        IL[] ilArr = this.f1898i1I1I1l;
        if (i >= ilArr.length) {
            this.f1898i1I1I1l = (IL[]) Arrays.copyOf(ilArr, ilArr.length * 2);
        }
        this.f1898i1I1I1l[this.f9LL] = new IL(iilll1, 1, Li1l());
        this.f9LL++;
    }

    /* JADX INFO: renamed from: 丨li1Ii1i, reason: contains not printable characters */
    public void m2616li1Ii1i() {
        int size = this.l1Lll.size();
        LLL();
        for (int i = 0; i < size; i++) {
            this.l1Lll.get(i).LLL();
        }
    }

    /* JADX INFO: renamed from: 丨ll丨I11I, reason: contains not printable characters */
    public boolean m2617llI11I() {
        return this.f10li;
    }
}
