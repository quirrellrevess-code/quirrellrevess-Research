package ILil.p045lLi1LL.IL1Iii.ILL;

import ILil.p045lLi1LL.IL1Iii.C0651il;
import ILil.p045lLi1LL.IL1Iii.lLi1LL;
import java.util.ArrayList;

/* JADX INFO: compiled from: Barrier.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil extends ILL {
    public int ill1LI1l = 0;

    /* JADX INFO: renamed from: lIIiIlL丨, reason: contains not printable characters */
    public ArrayList<lIiI> f1884lIIiIlL = new ArrayList<>(4);

    /* JADX INFO: renamed from: 丨i1丨1丨LL, reason: contains not printable characters */
    public boolean f1885i11LL = true;

    @Override // ILil.p045lLi1LL.IL1Iii.ILL.iILLL1
    public boolean I1I() {
        return true;
    }

    @Override // ILil.p045lLi1LL.IL1Iii.ILL.iILLL1
    /* JADX INFO: renamed from: I1L丨11L, reason: contains not printable characters */
    public void mo2600I1L11L() {
        lIiI liiiM2687lLi1LL;
        float f;
        lIiI liii;
        int i = this.ill1LI1l;
        float f2 = Float.MAX_VALUE;
        if (i != 0) {
            if (i == 1) {
                liiiM2687lLi1LL = this.I11li1.m2687lLi1LL();
            } else if (i == 2) {
                liiiM2687lLi1LL = this.iIlLiL.m2687lLi1LL();
            } else if (i != 3) {
                return;
            } else {
                liiiM2687lLi1LL = this.f1946lL.m2687lLi1LL();
            }
            f2 = 0.0f;
        } else {
            liiiM2687lLi1LL = this.iIi1.m2687lLi1LL();
        }
        int size = this.f1884lIIiIlL.size();
        lIiI liii2 = null;
        for (int i2 = 0; i2 < size; i2++) {
            lIiI liii3 = this.f1884lIIiIlL.get(i2);
            if (liii3.f4491ILil != 1) {
                return;
            }
            int i3 = this.ill1LI1l;
            if (i3 == 0 || i3 == 2) {
                f = liii3.f1955iILLL1;
                if (f < f2) {
                    liii = liii3.f1957lLi1LL;
                    liii2 = liii;
                    f2 = f;
                }
            } else {
                f = liii3.f1955iILLL1;
                if (f > f2) {
                    liii = liii3.f1957lLi1LL;
                    liii2 = liii;
                    f2 = f;
                }
            }
        }
        if (lLi1LL.llliI() != null) {
            lLi1LL.llliI().f1981l++;
        }
        liiiM2687lLi1LL.f1957lLi1LL = liii2;
        liiiM2687lLi1LL.f1955iILLL1 = f2;
        liiiM2687lLi1LL.ILil();
        int i4 = this.ill1LI1l;
        if (i4 == 0) {
            this.I11li1.m2687lLi1LL().m2671Ll1(liii2, f2);
            return;
        }
        if (i4 == 1) {
            this.iIi1.m2687lLi1LL().m2671Ll1(liii2, f2);
        } else if (i4 == 2) {
            this.f1946lL.m2687lLi1LL().m2671Ll1(liii2, f2);
        } else {
            if (i4 != 3) {
                return;
            }
            this.iIlLiL.m2687lLi1LL().m2671Ll1(liii2, f2);
        }
    }

    @Override // ILil.p045lLi1LL.IL1Iii.ILL.iILLL1
    public void ILil(lLi1LL lli1ll) {
        lLi1LL[] lli1llArr;
        boolean z;
        int i;
        int i2;
        lLi1LL[] lli1llArr2 = this.f1928LlLLL;
        lli1llArr2[0] = this.iIi1;
        lli1llArr2[2] = this.iIlLiL;
        lli1llArr2[1] = this.I11li1;
        lli1llArr2[3] = this.f1946lL;
        int i3 = 0;
        while (true) {
            lli1llArr = this.f1928LlLLL;
            if (i3 >= lli1llArr.length) {
                break;
            }
            lli1llArr[i3].f1961L11I = lli1ll.m2715lIlii(lli1llArr[i3]);
            i3++;
        }
        int i4 = this.ill1LI1l;
        if (i4 < 0 || i4 >= 4) {
            return;
        }
        lLi1LL lli1ll2 = lli1llArr[i4];
        int i5 = 0;
        while (true) {
            if (i5 >= this.I1IILIIL) {
                z = false;
                break;
            }
            iILLL1 iilll1 = this.l1Lll[i5];
            if ((this.f1885i11LL || iilll1.I1I()) && ((((i = this.ill1LI1l) == 0 || i == 1) && iilll1.iIi1() == iILLL1.ILil.MATCH_CONSTRAINT) || (((i2 = this.ill1LI1l) == 2 || i2 == 3) && iilll1.m2652lIII() == iILLL1.ILil.MATCH_CONSTRAINT))) {
                z = true;
                break;
            }
            i5++;
        }
        int i6 = this.ill1LI1l;
        if (i6 == 0 || i6 == 1 ? I11li1().iIi1() == iILLL1.ILil.WRAP_CONTENT : I11li1().m2652lIII() == iILLL1.ILil.WRAP_CONTENT) {
            z = false;
        }
        for (int i7 = 0; i7 < this.I1IILIIL; i7++) {
            iILLL1 iilll2 = this.l1Lll[i7];
            if (this.f1885i11LL || iilll2.I1I()) {
                C0651il c0651ilM2715lIlii = lli1ll.m2715lIlii(iilll2.f1928LlLLL[this.ill1LI1l]);
                lLi1LL[] lli1llArr3 = iilll2.f1928LlLLL;
                int i8 = this.ill1LI1l;
                lli1llArr3[i8].f1961L11I = c0651ilM2715lIlii;
                if (i8 == 0 || i8 == 2) {
                    lli1ll.m2718il(lli1ll2.f1961L11I, c0651ilM2715lIlii, z);
                } else {
                    lli1ll.m2707IiL(lli1ll2.f1961L11I, c0651ilM2715lIlii, z);
                }
            }
        }
        int i9 = this.ill1LI1l;
        if (i9 == 0) {
            lli1ll.Ilil(this.I11li1.f1961L11I, this.iIi1.f1961L11I, 0, 6);
            if (z) {
                return;
            }
            lli1ll.Ilil(this.iIi1.f1961L11I, this.f1920L111.I11li1.f1961L11I, 0, 5);
            return;
        }
        if (i9 == 1) {
            lli1ll.Ilil(this.iIi1.f1961L11I, this.I11li1.f1961L11I, 0, 6);
            if (z) {
                return;
            }
            lli1ll.Ilil(this.iIi1.f1961L11I, this.f1920L111.iIi1.f1961L11I, 0, 5);
            return;
        }
        if (i9 == 2) {
            lli1ll.Ilil(this.f1946lL.f1961L11I, this.iIlLiL.f1961L11I, 0, 6);
            if (z) {
                return;
            }
            lli1ll.Ilil(this.iIlLiL.f1961L11I, this.f1920L111.f1946lL.f1961L11I, 0, 5);
            return;
        }
        if (i9 == 3) {
            lli1ll.Ilil(this.iIlLiL.f1961L11I, this.f1946lL.f1961L11I, 0, 6);
            if (z) {
                return;
            }
            lli1ll.Ilil(this.iIlLiL.f1961L11I, this.f1920L111.iIlLiL.f1961L11I, 0, 5);
        }
    }

    @Override // ILil.p045lLi1LL.IL1Iii.ILL.iILLL1
    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void mo2601IL(int i) {
        lIiI liiiM2687lLi1LL;
        lIiI liiiM2687lLi1LL2;
        iILLL1 iilll1 = this.f1920L111;
        if (iilll1 != null && ((IiL) iilll1).m2609LL(2)) {
            int i2 = this.ill1LI1l;
            if (i2 == 0) {
                liiiM2687lLi1LL = this.iIi1.m2687lLi1LL();
            } else if (i2 == 1) {
                liiiM2687lLi1LL = this.I11li1.m2687lLi1LL();
            } else if (i2 == 2) {
                liiiM2687lLi1LL = this.iIlLiL.m2687lLi1LL();
            } else if (i2 != 3) {
                return;
            } else {
                liiiM2687lLi1LL = this.f1946lL.m2687lLi1LL();
            }
            liiiM2687lLi1LL.LlLI1(5);
            int i3 = this.ill1LI1l;
            if (i3 == 0 || i3 == 1) {
                this.iIlLiL.m2687lLi1LL().m2671Ll1(null, 0.0f);
                this.f1946lL.m2687lLi1LL().m2671Ll1(null, 0.0f);
            } else {
                this.iIi1.m2687lLi1LL().m2671Ll1(null, 0.0f);
                this.I11li1.m2687lLi1LL().m2671Ll1(null, 0.0f);
            }
            this.f1884lIIiIlL.clear();
            for (int i4 = 0; i4 < this.I1IILIIL; i4++) {
                iILLL1 iilll2 = this.l1Lll[i4];
                if (this.f1885i11LL || iilll2.I1I()) {
                    int i5 = this.ill1LI1l;
                    if (i5 == 0) {
                        liiiM2687lLi1LL2 = iilll2.iIi1.m2687lLi1LL();
                    } else if (i5 == 1) {
                        liiiM2687lLi1LL2 = iilll2.I11li1.m2687lLi1LL();
                    } else if (i5 != 2) {
                        liiiM2687lLi1LL2 = i5 != 3 ? null : iilll2.f1946lL.m2687lLi1LL();
                    } else {
                        liiiM2687lLi1LL2 = iilll2.iIlLiL.m2687lLi1LL();
                    }
                    if (liiiM2687lLi1LL2 != null) {
                        this.f1884lIIiIlL.add(liiiM2687lLi1LL2);
                        liiiM2687lLi1LL2.IL1Iii(liiiM2687lLi1LL);
                    }
                }
            }
        }
    }

    @Override // ILil.p045lLi1LL.IL1Iii.ILL.iILLL1
    public void LLL() {
        super.LLL();
        this.f1884lIIiIlL.clear();
    }

    /* JADX INFO: renamed from: iI1L1丨Ll, reason: contains not printable characters */
    public void m2602iI1L1Ll(boolean z) {
        this.f1885i11LL = z;
    }

    /* JADX INFO: renamed from: iLiLI丨, reason: contains not printable characters */
    public void m2603iLiLI(int i) {
        this.ill1LI1l = i;
    }
}
