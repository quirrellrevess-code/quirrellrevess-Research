package ILil.p045lLi1LL.IL1Iii.ILL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: Analyzer.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii {
    public static int I1I(L11I l11i, int i) {
        int i2 = i * 2;
        List<iILLL1> listILil = l11i.ILil(i);
        int size = listILil.size();
        int iMax = 0;
        for (int i3 = 0; i3 < size; i3++) {
            iILLL1 iilll1 = listILil.get(i3);
            lLi1LL[] lli1llArr = iilll1.f1928LlLLL;
            int i4 = i2 + 1;
            iMax = Math.max(iMax, m2592IL(iilll1, i, lli1llArr[i4].f1959IL == null || !(lli1llArr[i2].f1959IL == null || lli1llArr[i4].f1959IL == null), 0));
        }
        l11i.f4504Ilil[i] = iMax;
        return iMax;
    }

    public static void IL1Iii(IiL iiL) {
        if ((iiL.L1li1() & 32) != 32) {
            m2598il(iiL);
            return;
        }
        iiL.lI1I1 = true;
        iiL.f1899iILiiLl = false;
        iiL.ILI1Ll = false;
        iiL.f11l = false;
        ArrayList<iILLL1> arrayList = iiL.l1Lll;
        List<L11I> list = iiL.f121;
        iILLL1.ILil iLilIIi1 = iiL.iIi1();
        iILLL1.ILil iLil = iILLL1.ILil.WRAP_CONTENT;
        boolean z = iLilIIi1 == iLil;
        boolean z2 = iiL.m2652lIII() == iLil;
        boolean z3 = z || z2;
        list.clear();
        for (iILLL1 iilll1 : arrayList) {
            iilll1.LlLI1 = null;
            iilll1.f15I = false;
            iilll1.LLL();
        }
        for (iILLL1 iilll2 : arrayList) {
            if (iilll2.LlLI1 == null && !ILil(iilll2, list, z3)) {
                m2598il(iiL);
                iiL.lI1I1 = false;
                return;
            }
        }
        int iMax = 0;
        int iMax2 = 0;
        for (L11I l11i : list) {
            iMax = Math.max(iMax, I1I(l11i, 0));
            iMax2 = Math.max(iMax2, I1I(l11i, 1));
        }
        if (z) {
            iiL.m83I1(iILLL1.ILil.FIXED);
            iiL.ILI1Ll(iMax);
            iiL.f1899iILiiLl = true;
            iiL.ILI1Ll = true;
            iiL.f19011iIl = iMax;
        }
        if (z2) {
            iiL.m2647i1I1I1l(iILLL1.ILil.FIXED);
            iiL.m87iI(iMax2);
            iiL.f1899iILiiLl = true;
            iiL.f11l = true;
            iiL.LII = iMax2;
        }
        m2595L11I(list, 0, iiL.m2629L111());
        m2595L11I(list, 1, iiL.m2653lIlii());
    }

    /* JADX WARN: Code duplicated, block: B:115:0x015d  */
    /* JADX WARN: Code duplicated, block: B:88:0x0114  */
    public static boolean ILL(iILLL1 iilll1, L11I l11i, List<L11I> list, boolean z) {
        lLi1LL lli1ll;
        lLi1LL lli1ll2;
        if (iilll1 == null) {
            return true;
        }
        iilll1.f1924LlLiLL = false;
        IiL iiL = (IiL) iilll1.I11li1();
        L11I l11i2 = iilll1.LlLI1;
        if (l11i2 != null) {
            if (l11i2 != l11i) {
                l11i.f4502IL1Iii.addAll(l11i2.f4502IL1Iii);
                l11i.f1910lLi1LL.addAll(iilll1.LlLI1.f1910lLi1LL);
                l11i.f1909iILLL1.addAll(iilll1.LlLI1.f1909iILLL1);
                L11I l11i3 = iilll1.LlLI1;
                if (!l11i3.f1906IL) {
                    l11i.f1906IL = false;
                }
                list.remove(l11i3);
                Iterator<iILLL1> it = iilll1.LlLI1.f4502IL1Iii.iterator();
                while (it.hasNext()) {
                    it.next().LlLI1 = l11i;
                }
            }
            return true;
        }
        iilll1.f17iI = true;
        l11i.f4502IL1Iii.add(iilll1);
        iilll1.LlLI1 = l11i;
        if (iilll1.iIi1.f1959IL == null && iilll1.I11li1.f1959IL == null && iilll1.iIlLiL.f1959IL == null && iilll1.f1946lL.f1959IL == null && iilll1.I11L.f1959IL == null && iilll1.f19491.f1959IL == null) {
            m2597lLi1LL(iiL, iilll1, l11i);
            if (z) {
                return false;
            }
        }
        if (iilll1.iIlLiL.f1959IL != null && iilll1.f1946lL.f1959IL != null) {
            iiL.m2652lIII();
            iILLL1.ILil iLil = iILLL1.ILil.WRAP_CONTENT;
            if (z) {
                m2597lLi1LL(iiL, iilll1, l11i);
                return false;
            }
            if (iilll1.iIlLiL.f1959IL.f4516ILil != iilll1.I11li1() || iilll1.f1946lL.f1959IL.f4516ILil != iilll1.I11li1()) {
                m2597lLi1LL(iiL, iilll1, l11i);
            }
        }
        if (iilll1.iIi1.f1959IL != null && iilll1.I11li1.f1959IL != null) {
            iiL.iIi1();
            iILLL1.ILil iLil2 = iILLL1.ILil.WRAP_CONTENT;
            if (z) {
                m2597lLi1LL(iiL, iilll1, l11i);
                return false;
            }
            if (iilll1.iIi1.f1959IL.f4516ILil != iilll1.I11li1() || iilll1.I11li1.f1959IL.f4516ILil != iilll1.I11li1()) {
                m2597lLi1LL(iiL, iilll1, l11i);
            }
        }
        iILLL1.ILil iLilIIi1 = iilll1.iIi1();
        iILLL1.ILil iLil3 = iILLL1.ILil.MATCH_CONSTRAINT;
        if (((iLilIIi1 == iLil3) ^ (iilll1.m2652lIII() == iLil3)) && iilll1.llI != 0.0f) {
            m2596iILLL1(iilll1);
        } else if (iilll1.iIi1() == iLil3 || iilll1.m2652lIII() == iLil3) {
            m2597lLi1LL(iiL, iilll1, l11i);
            if (z) {
                return false;
            }
        }
        lLi1LL lli1ll3 = iilll1.iIi1.f1959IL;
        if ((lli1ll3 == null && iilll1.I11li1.f1959IL == null) || ((lli1ll3 != null && lli1ll3.f4516ILil == iilll1.f1920L111 && iilll1.I11li1.f1959IL == null) || ((lli1ll = iilll1.I11li1.f1959IL) != null && lli1ll.f4516ILil == iilll1.f1920L111 && lli1ll3 == null))) {
            if (iilll1.f19491.f1959IL == null) {
                l11i.f1910lLi1LL.add(iilll1);
            }
        } else if (lli1ll3 != null) {
            iILLL1 iilll2 = lli1ll3.f4516ILil;
            iILLL1 iilll3 = iilll1.f1920L111;
            if (iilll2 == iilll3 && lli1ll != null && lli1ll.f4516ILil == iilll3) {
                if (iilll1.f19491.f1959IL == null && !(iilll1 instanceof C0650il) && !(iilll1 instanceof ILL)) {
                    l11i.f1910lLi1LL.add(iilll1);
                }
            }
        }
        lLi1LL lli1ll4 = iilll1.iIlLiL.f1959IL;
        if ((lli1ll4 == null && iilll1.f1946lL.f1959IL == null) || ((lli1ll4 != null && lli1ll4.f4516ILil == iilll1.f1920L111 && iilll1.f1946lL.f1959IL == null) || ((lli1ll2 = iilll1.f1946lL.f1959IL) != null && lli1ll2.f4516ILil == iilll1.f1920L111 && lli1ll4 == null))) {
            if (iilll1.f19491.f1959IL == null) {
                l11i.f1909iILLL1.add(iilll1);
            }
        } else if (lli1ll4 != null) {
            iILLL1 iilll4 = lli1ll4.f4516ILil;
            iILLL1 iilll5 = iilll1.f1920L111;
            if (iilll4 == iilll5 && lli1ll2 != null && lli1ll2.f4516ILil == iilll5) {
                if (iilll1.f19491.f1959IL == null && iilll1.I11L.f1959IL == null && !(iilll1 instanceof C0650il) && !(iilll1 instanceof ILL)) {
                    l11i.f1909iILLL1.add(iilll1);
                }
            }
        }
        if (iilll1 instanceof ILL) {
            m2597lLi1LL(iiL, iilll1, l11i);
            if (z) {
                return false;
            }
            ILL ill = (ILL) iilll1;
            for (int i = 0; i < ill.I1IILIIL; i++) {
                if (!ILL(ill.l1Lll[i], l11i, list, z)) {
                    return false;
                }
            }
        }
        int length = iilll1.f1928LlLLL.length;
        for (int i2 = 0; i2 < length; i2++) {
            lLi1LL lli1ll5 = iilll1.f1928LlLLL[i2];
            lLi1LL lli1ll6 = lli1ll5.f1959IL;
            if (lli1ll6 != null && lli1ll6.f4516ILil != iilll1.I11li1()) {
                if (lli1ll5.f4514I1I == lLi1LL.IL.CENTER) {
                    m2597lLi1LL(iiL, iilll1, l11i);
                    if (z) {
                        return false;
                    }
                } else {
                    m2593IiL(lli1ll5);
                }
                if (!ILL(lli1ll5.f1959IL.f4516ILil, l11i, list, z)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean ILil(iILLL1 iilll1, List<L11I> list, boolean z) {
        L11I l11i = new L11I(new ArrayList(), true);
        list.add(l11i);
        return ILL(iilll1, l11i, list, z);
    }

    public static int Ilil(iILLL1 iilll1, int i) {
        lLi1LL lli1ll;
        int i2 = i * 2;
        lLi1LL[] lli1llArr = iilll1.f1928LlLLL;
        lLi1LL lli1ll2 = lli1llArr[i2];
        lLi1LL lli1ll3 = lli1llArr[i2 + 1];
        lLi1LL lli1ll4 = lli1ll2.f1959IL;
        if (lli1ll4 == null) {
            return 0;
        }
        iILLL1 iilll2 = lli1ll4.f4516ILil;
        iILLL1 iilll3 = iilll1.f1920L111;
        if (iilll2 != iilll3 || (lli1ll = lli1ll3.f1959IL) == null || lli1ll.f4516ILil != iilll3) {
            return 0;
        }
        return (int) ((((iilll3.iIlLiL(i) - lli1ll2.m2681IL()) - lli1ll3.m2681IL()) - iilll1.iIlLiL(i)) * (i == 0 ? iilll1.f1914ILLIi : iilll1.f1942li11));
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static int m2592IL(iILLL1 iilll1, int i, boolean z, int i2) {
        int iM2653lIlii;
        int iM2663il;
        int i3;
        int i4;
        int i5;
        int iM2629L111;
        int i6;
        int i7;
        int iMax = 0;
        if (!iilll1.f17iI) {
            return 0;
        }
        boolean z2 = iilll1.I11L.f1959IL != null && i == 1;
        if (z) {
            iM2653lIlii = iilll1.m2663il();
            iM2663il = iilll1.m2653lIlii() - iilll1.m2663il();
            i4 = i * 2;
            i3 = i4 + 1;
        } else {
            iM2653lIlii = iilll1.m2653lIlii() - iilll1.m2663il();
            iM2663il = iilll1.m2663il();
            i3 = i * 2;
            i4 = i3 + 1;
        }
        lLi1LL[] lli1llArr = iilll1.f1928LlLLL;
        if (lli1llArr[i3].f1959IL == null || lli1llArr[i4].f1959IL != null) {
            i5 = 1;
        } else {
            i5 = -1;
            int i8 = i3;
            i3 = i4;
            i4 = i8;
        }
        int i9 = z2 ? i2 - iM2653lIlii : i2;
        int iM2681IL = (lli1llArr[i4].m2681IL() * i5) + Ilil(iilll1, i);
        int i10 = i9 + iM2681IL;
        int iM2629L112 = (i == 0 ? iilll1.m2629L111() : iilll1.m2653lIlii()) * i5;
        Iterator<Lil> it = iilll1.f1928LlLLL[i4].m2687lLi1LL().f4490IL1Iii.iterator();
        while (it.hasNext()) {
            iMax = Math.max(iMax, m2592IL(((lIiI) it.next()).f4512I1I.f4516ILil, i, z, i10));
        }
        int iMax2 = 0;
        for (Iterator<Lil> it2 = iilll1.f1928LlLLL[i3].m2687lLi1LL().f4490IL1Iii.iterator(); it2.hasNext(); it2 = it2) {
            iMax2 = Math.max(iMax2, m2592IL(((lIiI) it2.next()).f4512I1I.f4516ILil, i, z, iM2629L112 + i10));
        }
        if (z2) {
            iMax -= iM2653lIlii;
            iM2629L111 = iMax2 + iM2663il;
        } else {
            iM2629L111 = iMax2 + ((i == 0 ? iilll1.m2629L111() : iilll1.m2653lIlii()) * i5);
        }
        int i11 = 1;
        if (i == 1) {
            Iterator<Lil> it3 = iilll1.I11L.m2687lLi1LL().f4490IL1Iii.iterator();
            int iMax3 = 0;
            while (it3.hasNext()) {
                Iterator<Lil> it4 = it3;
                lIiI liii = (lIiI) it3.next();
                iMax3 = i5 == i11 ? Math.max(iMax3, m2592IL(liii.f4512I1I.f4516ILil, i, z, iM2653lIlii + i10)) : Math.max(iMax3, m2592IL(liii.f4512I1I.f4516ILil, i, z, (iM2663il * i5) + i10));
                it3 = it4;
                i3 = i3;
                i11 = 1;
            }
            i6 = i3;
            int i12 = iMax3;
            i7 = (iilll1.I11L.m2687lLi1LL().f4490IL1Iii.size() <= 0 || z2) ? i12 : i5 == 1 ? i12 + iM2653lIlii : i12 - iM2663il;
        } else {
            i6 = i3;
            i7 = 0;
        }
        int iMax4 = iM2681IL + Math.max(iMax, Math.max(iM2629L111, i7));
        int i13 = iM2629L112 + i10;
        if (i5 == -1) {
            i13 = i10;
            i10 = i13;
        }
        if (z) {
            Ll1.Ilil(iilll1, i, i10);
            iilll1.m2645ili11(i10, i13, i);
        } else {
            iilll1.LlLI1.IL1Iii(iilll1, i);
            iilll1.LI11(i10, i);
        }
        if (iilll1.Lil(i) == iILLL1.ILil.MATCH_CONSTRAINT && iilll1.llI != 0.0f) {
            iilll1.LlLI1.IL1Iii(iilll1, i);
        }
        lLi1LL[] lli1llArr2 = iilll1.f1928LlLLL;
        if (lli1llArr2[i4].f1959IL != null && lli1llArr2[i6].f1959IL != null) {
            iILLL1 iilll1I11li1 = iilll1.I11li1();
            lLi1LL[] lli1llArr3 = iilll1.f1928LlLLL;
            if (lli1llArr3[i4].f1959IL.f4516ILil == iilll1I11li1 && lli1llArr3[i6].f1959IL.f4516ILil == iilll1I11li1) {
                iilll1.LlLI1.IL1Iii(iilll1, i);
            }
        }
        return iMax4;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static void m2593IiL(lLi1LL lli1ll) {
        lIiI liiiM2687lLi1LL = lli1ll.m2687lLi1LL();
        lLi1LL lli1ll2 = lli1ll.f1959IL;
        if (lli1ll2 == null || lli1ll2.f1959IL == lli1ll) {
            return;
        }
        lli1ll2.m2687lLi1LL().IL1Iii(liiiM2687lLi1LL);
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static void m2594Ll1(iILLL1 iilll1, int i, int i2) {
        int i3 = i * 2;
        lLi1LL[] lli1llArr = iilll1.f1928LlLLL;
        lLi1LL lli1ll = lli1llArr[i3];
        lLi1LL lli1ll2 = lli1llArr[i3 + 1];
        if ((lli1ll.f1959IL == null || lli1ll2.f1959IL == null) ? false : true) {
            Ll1.Ilil(iilll1, i, Ilil(iilll1, i) + lli1ll.m2681IL());
            return;
        }
        if (iilll1.llI == 0.0f || iilll1.Lil(i) != iILLL1.ILil.MATCH_CONSTRAINT) {
            int iM2664lL = i2 - iilll1.m2664lL(i);
            int iIIlLiL = iM2664lL - iilll1.iIlLiL(i);
            iilll1.m2645ili11(iIIlLiL, iM2664lL, i);
            Ll1.Ilil(iilll1, i, iIIlLiL);
            return;
        }
        int iM2596iILLL1 = m2596iILLL1(iilll1);
        int i4 = (int) iilll1.f1928LlLLL[i3].m2687lLi1LL().f1955iILLL1;
        lli1ll2.m2687lLi1LL().f1957lLi1LL = lli1ll.m2687lLi1LL();
        lli1ll2.m2687lLi1LL().f1955iILLL1 = iM2596iILLL1;
        lli1ll2.m2687lLi1LL().f4491ILil = 1;
        iilll1.m2645ili11(i4, i4 + iM2596iILLL1, i);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static void m2595L11I(List<L11I> list, int i, int i2) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            for (iILLL1 iilll1 : list.get(i3).I1I(i)) {
                if (iilll1.f17iI) {
                    m2594Ll1(iilll1, i, i2);
                }
            }
        }
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static int m2596iILLL1(iILLL1 iilll1) {
        iILLL1.ILil iLilIIi1 = iilll1.iIi1();
        iILLL1.ILil iLil = iILLL1.ILil.MATCH_CONSTRAINT;
        if (iLilIIi1 == iLil) {
            int iM2653lIlii = (int) (iilll1.f1935l1IIi1 == 0 ? iilll1.m2653lIlii() * iilll1.llI : iilll1.m2653lIlii() / iilll1.llI);
            iilll1.ILI1Ll(iM2653lIlii);
            return iM2653lIlii;
        }
        if (iilll1.m2652lIII() != iLil) {
            return -1;
        }
        int iM2629L111 = (int) (iilll1.f1935l1IIi1 == 1 ? iilll1.m2629L111() * iilll1.llI : iilll1.m2629L111() / iilll1.llI);
        iilll1.m87iI(iM2629L111);
        return iM2629L111;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static void m2597lLi1LL(IiL iiL, iILLL1 iilll1, L11I l11i) {
        l11i.f1906IL = false;
        iiL.lI1I1 = false;
        iilll1.f17iI = false;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static void m2598il(IiL iiL) {
        iiL.f121.clear();
        iiL.f121.add(0, new L11I(iiL.l1Lll));
    }
}
