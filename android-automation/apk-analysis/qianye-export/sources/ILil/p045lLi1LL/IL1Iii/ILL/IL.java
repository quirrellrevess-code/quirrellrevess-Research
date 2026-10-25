package ILil.p045lLi1LL.IL1Iii.ILL;

import java.util.ArrayList;

/* JADX INFO: renamed from: ILil.l丨Li1LL.IL1Iii.ILL.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: ChainHead.java */
/* JADX INFO: loaded from: classes.dex */
public class IL {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public iILLL1 f4486I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public iILLL1 f4487IL1Iii;
    public float ILL = 0.0f;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public iILLL1 f4488ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public boolean f1886ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public iILLL1 f4489Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public iILLL1 f1887IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public ArrayList<iILLL1> f1888IiL;
    public boolean Lil;
    public boolean LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public int f1889Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public int f1890L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public iILLL1 f1891iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public boolean f1892lIiI;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public boolean f1893llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public iILLL1 f1894lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public int f1895il;

    public IL(iILLL1 iilll1, int i, boolean z) {
        this.f1892lIiI = false;
        this.f4487IL1Iii = iilll1;
        this.f1889Ll1 = i;
        this.f1892lIiI = z;
    }

    public static boolean I1I(iILLL1 iilll1, int i) {
        if (iilll1.LL1IL() != 8 && iilll1.LL1IL[i] == iILLL1.ILil.MATCH_CONSTRAINT) {
            int[] iArr = iilll1.f1930iILLL1;
            if (iArr[i] == 0 || iArr[i] == 3) {
                return true;
            }
        }
        return false;
    }

    public void IL1Iii() {
        if (!this.f1893llL1ii) {
            ILil();
        }
        this.f1893llL1ii = true;
    }

    public final void ILil() {
        int i = this.f1889Ll1 * 2;
        iILLL1 iilll1 = this.f4487IL1Iii;
        boolean z = false;
        iILLL1 iilll2 = iilll1;
        boolean z2 = false;
        while (!z2) {
            this.f1890L11I++;
            iILLL1[] iilll1Arr = iilll1.L1iI1;
            int i2 = this.f1889Ll1;
            iILLL1 iilll3 = null;
            iilll1Arr[i2] = null;
            iilll1.f1943i11i[i2] = null;
            if (iilll1.LL1IL() != 8) {
                if (this.f4488ILil == null) {
                    this.f4488ILil = iilll1;
                }
                this.f1887IL = iilll1;
                iILLL1.ILil[] iLilArr = iilll1.LL1IL;
                int i3 = this.f1889Ll1;
                if (iLilArr[i3] == iILLL1.ILil.MATCH_CONSTRAINT) {
                    int[] iArr = iilll1.f1930iILLL1;
                    if (iArr[i3] == 0 || iArr[i3] == 3 || iArr[i3] == 2) {
                        this.f1895il++;
                        float[] fArr = iilll1.f14I1;
                        float f = fArr[i3];
                        if (f > 0.0f) {
                            this.ILL += fArr[i3];
                        }
                        if (I1I(iilll1, i3)) {
                            if (f < 0.0f) {
                                this.f1886ILl = true;
                            } else {
                                this.Lil = true;
                            }
                            if (this.f1888IiL == null) {
                                this.f1888IiL = new ArrayList<>();
                            }
                            this.f1888IiL.add(iilll1);
                        }
                        if (this.f1894lLi1LL == null) {
                            this.f1894lLi1LL = iilll1;
                        }
                        iILLL1 iilll4 = this.f1891iILLL1;
                        if (iilll4 != null) {
                            iilll4.f1943i11i[this.f1889Ll1] = iilll1;
                        }
                        this.f1891iILLL1 = iilll1;
                    }
                }
            }
            if (iilll2 != iilll1) {
                iilll2.L1iI1[this.f1889Ll1] = iilll1;
            }
            lLi1LL lli1ll = iilll1.f1928LlLLL[i + 1].f1959IL;
            if (lli1ll != null) {
                iILLL1 iilll5 = lli1ll.f4516ILil;
                lLi1LL[] lli1llArr = iilll5.f1928LlLLL;
                if (lli1llArr[i].f1959IL != null && lli1llArr[i].f1959IL.f4516ILil == iilll1) {
                    iilll3 = iilll5;
                }
            }
            if (iilll3 == null) {
                iilll3 = iilll1;
                z2 = true;
            }
            iilll2 = iilll1;
            iilll1 = iilll3;
        }
        this.f4486I1I = iilll1;
        if (this.f1889Ll1 == 0 && this.f1892lIiI) {
            this.f4489Ilil = iilll1;
        } else {
            this.f4489Ilil = this.f4487IL1Iii;
        }
        if (this.Lil && this.f1886ILl) {
            z = true;
        }
        this.LlLI1 = z;
    }
}
