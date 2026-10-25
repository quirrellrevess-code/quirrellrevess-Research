package ILil.p045lLi1LL.IL1Iii.ILL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: renamed from: ILil.l丨Li1LL.IL1Iii.ILL.L丨1丨1丨I, reason: invalid class name */
/* JADX INFO: compiled from: ConstraintWidgetGroup.java */
/* JADX INFO: loaded from: classes.dex */
public class L11I {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f4501I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public List<iILLL1> f4502IL1Iii;
    public List<iILLL1> ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f4503ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final int[] f4504Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean f1906IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public HashSet<iILLL1> f1907IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public HashSet<iILLL1> f1908L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public List<iILLL1> f1909iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public List<iILLL1> f1910lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public List<iILLL1> f1911il;

    public L11I(List<iILLL1> list) {
        this.f4503ILil = -1;
        this.f4501I1I = -1;
        this.f1906IL = false;
        this.f4504Ilil = new int[]{-1, -1};
        this.f1910lLi1LL = new ArrayList();
        this.f1909iILLL1 = new ArrayList();
        this.f1907IiL = new HashSet<>();
        this.f1908L11I = new HashSet<>();
        this.f1911il = new ArrayList();
        this.ILL = new ArrayList();
        this.f4502IL1Iii = list;
    }

    public Set<iILLL1> I1I(int i) {
        if (i == 0) {
            return this.f1907IiL;
        }
        if (i == 1) {
            return this.f1908L11I;
        }
        return null;
    }

    public void IL1Iii(iILLL1 iilll1, int i) {
        if (i == 0) {
            this.f1907IiL.add(iilll1);
        } else if (i == 1) {
            this.f1908L11I.add(iilll1);
        }
    }

    public List<iILLL1> ILil(int i) {
        if (i == 0) {
            return this.f1910lLi1LL;
        }
        if (i == 1) {
            return this.f1909iILLL1;
        }
        return null;
    }

    public final void Ilil(ArrayList<iILLL1> arrayList, iILLL1 iilll1) {
        if (iilll1.f15I) {
            return;
        }
        arrayList.add(iilll1);
        iilll1.f15I = true;
        if (iilll1.m2631LIll()) {
            return;
        }
        if (iilll1 instanceof ILL) {
            ILL ill = (ILL) iilll1;
            int i = ill.I1IILIIL;
            for (int i2 = 0; i2 < i; i2++) {
                Ilil(arrayList, ill.l1Lll[i2]);
            }
        }
        int length = iilll1.f1928LlLLL.length;
        for (int i3 = 0; i3 < length; i3++) {
            lLi1LL lli1ll = iilll1.f1928LlLLL[i3].f1959IL;
            if (lli1ll != null) {
                iILLL1 iilll2 = lli1ll.f4516ILil;
                if (lli1ll != null && iilll2 != iilll1.I11li1()) {
                    Ilil(arrayList, iilll2);
                }
            }
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public List<iILLL1> m2621IL() {
        if (!this.f1911il.isEmpty()) {
            return this.f1911il;
        }
        int size = this.f4502IL1Iii.size();
        for (int i = 0; i < size; i++) {
            iILLL1 iilll1 = this.f4502IL1Iii.get(i);
            if (!iilll1.f17iI) {
                Ilil((ArrayList) this.f1911il, iilll1);
            }
        }
        this.ILL.clear();
        this.ILL.addAll(this.f4502IL1Iii);
        this.ILL.removeAll(this.f1911il);
        return this.f1911il;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m2622iILLL1() {
        int size = this.ILL.size();
        for (int i = 0; i < size; i++) {
            m2623lLi1LL(this.ILL.get(i));
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0041  */
    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final void m2623lLi1LL(iILLL1 iilll1) {
        int iM2629L111;
        if (!iilll1.f17iI || iilll1.m2631LIll()) {
            return;
        }
        lLi1LL lli1ll = iilll1.I11li1.f1959IL;
        boolean z = lli1ll != null;
        if (!z) {
            lli1ll = iilll1.iIi1.f1959IL;
        }
        if (lli1ll != null) {
            iILLL1 iilll2 = lli1ll.f4516ILil;
            if (!iilll2.f1924LlLiLL) {
                m2623lLi1LL(iilll2);
            }
            lLi1LL.IL il = lli1ll.f4514I1I;
            if (il == lLi1LL.IL.RIGHT) {
                iILLL1 iilll3 = lli1ll.f4516ILil;
                iM2629L111 = iilll3.f1926L1l + iilll3.m2629L111();
            } else if (il == lLi1LL.IL.LEFT) {
                iM2629L111 = lli1ll.f4516ILil.f1926L1l;
            } else {
                iM2629L111 = 0;
            }
        } else {
            iM2629L111 = 0;
        }
        int iM2681IL = z ? iM2629L111 - iilll1.I11li1.m2681IL() : iM2629L111 + iilll1.iIi1.m2681IL() + iilll1.m2629L111();
        iilll1.m2642iILilI(iM2681IL - iilll1.m2629L111(), iM2681IL);
        lLi1LL lli1ll2 = iilll1.I11L.f1959IL;
        if (lli1ll2 != null) {
            iILLL1 iilll4 = lli1ll2.f4516ILil;
            if (!iilll4.f1924LlLiLL) {
                m2623lLi1LL(iilll4);
            }
            iILLL1 iilll5 = lli1ll2.f4516ILil;
            int i = (iilll5.f1944iILLl + iilll5.f1913IIiI) - iilll1.f1913IIiI;
            iilll1.m85LL(i, iilll1.f18 + i);
            iilll1.f1924LlLiLL = true;
            return;
        }
        lLi1LL lli1ll3 = iilll1.f1946lL.f1959IL;
        boolean z2 = lli1ll3 != null;
        if (!z2) {
            lli1ll3 = iilll1.iIlLiL.f1959IL;
        }
        if (lli1ll3 != null) {
            iILLL1 iilll6 = lli1ll3.f4516ILil;
            if (!iilll6.f1924LlLiLL) {
                m2623lLi1LL(iilll6);
            }
            lLi1LL.IL il2 = lli1ll3.f4514I1I;
            if (il2 == lLi1LL.IL.BOTTOM) {
                iILLL1 iilll7 = lli1ll3.f4516ILil;
                iM2681IL = iilll7.f1944iILLl + iilll7.m2653lIlii();
            } else if (il2 == lLi1LL.IL.TOP) {
                iM2681IL = lli1ll3.f4516ILil.f1944iILLl;
            }
        }
        int iM2681IL2 = z2 ? iM2681IL - iilll1.f1946lL.m2681IL() : iM2681IL + iilll1.iIlLiL.m2681IL() + iilll1.m2653lIlii();
        iilll1.m85LL(iM2681IL2 - iilll1.m2653lIlii(), iM2681IL2);
        iilll1.f1924LlLiLL = true;
    }

    public L11I(List<iILLL1> list, boolean z) {
        this.f4503ILil = -1;
        this.f4501I1I = -1;
        this.f1906IL = false;
        this.f4504Ilil = new int[]{-1, -1};
        this.f1910lLi1LL = new ArrayList();
        this.f1909iILLL1 = new ArrayList();
        this.f1907IiL = new HashSet<>();
        this.f1908L11I = new HashSet<>();
        this.f1911il = new ArrayList();
        this.ILL = new ArrayList();
        this.f4502IL1Iii = list;
        this.f1906IL = z;
    }
}
