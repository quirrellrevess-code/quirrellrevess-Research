package ILil.p045lLi1LL.IL1Iii.ILL;

import java.util.Arrays;

/* JADX INFO: compiled from: Helper.java */
/* JADX INFO: loaded from: classes.dex */
public class ILL extends iILLL1 {
    public iILLL1[] l1Lll = new iILLL1[4];
    public int I1IILIIL = 0;

    public void lLIL1() {
        this.I1IILIIL = 0;
    }

    /* JADX INFO: renamed from: 丨ILI, reason: contains not printable characters */
    public void m2599ILI(iILLL1 iilll1) {
        int i = this.I1IILIIL + 1;
        iILLL1[] iilll1Arr = this.l1Lll;
        if (i > iilll1Arr.length) {
            this.l1Lll = (iILLL1[]) Arrays.copyOf(iilll1Arr, iilll1Arr.length * 2);
        }
        iILLL1[] iilll1Arr2 = this.l1Lll;
        int i2 = this.I1IILIIL;
        iilll1Arr2[i2] = iilll1;
        this.I1IILIIL = i2 + 1;
    }
}
