package ILil.p045lLi1LL.IL1Iii.ILL;

import ILil.p045lLi1LL.IL1Iii.I1I;
import java.util.ArrayList;

/* JADX INFO: renamed from: ILil.l丨Li1LL.IL1Iii.ILL.ll丨L1ii, reason: invalid class name */
/* JADX INFO: compiled from: WidgetContainer.java */
/* JADX INFO: loaded from: classes.dex */
public class llL1ii extends iILLL1 {
    public ArrayList<iILLL1> l1Lll = new ArrayList<>();

    @Override // ILil.p045lLi1LL.IL1Iii.ILL.iILLL1
    /* JADX INFO: renamed from: IIi丨丨I */
    public void mo2607IIiI() {
        this.l1Lll.clear();
        super.mo2607IIiI();
    }

    /* JADX INFO: renamed from: iI1L1丨Ll */
    public void mo2612iI1L1Ll() {
        mo2659IillIi();
        ArrayList<iILLL1> arrayList = this.l1Lll;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            iILLL1 iilll1 = this.l1Lll.get(i);
            if (iilll1 instanceof llL1ii) {
                ((llL1ii) iilll1).mo2612iI1L1Ll();
            }
        }
    }

    @Override // ILil.p045lLi1LL.IL1Iii.ILL.iILLL1
    /* JADX INFO: renamed from: iI1i丨I */
    public void mo2638iI1iI(I1I i1i) {
        super.mo2638iI1iI(i1i);
        int size = this.l1Lll.size();
        for (int i = 0; i < size; i++) {
            this.l1Lll.get(i).mo2638iI1iI(i1i);
        }
    }

    /* JADX INFO: renamed from: iLiLI丨, reason: contains not printable characters */
    public void m2677iLiLI(iILLL1 iilll1) {
        this.l1Lll.remove(iilll1);
        iilll1.m2639iIl1il(null);
    }

    @Override // ILil.p045lLi1LL.IL1Iii.ILL.iILLL1
    /* JADX INFO: renamed from: lIIiIlL丨 */
    public void mo2650lIIiIlL(int i, int i2) {
        super.mo2650lIIiIlL(i, i2);
        int size = this.l1Lll.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.l1Lll.get(i3).mo2650lIIiIlL(m26671(), m2637LlLLL());
        }
    }

    public IiL lLIL1() {
        iILLL1 iilll1I11li1 = I11li1();
        IiL iiL = this instanceof IiL ? (IiL) this : null;
        while (iilll1I11li1 != null) {
            iILLL1 iilll1I11li2 = iilll1I11li1.I11li1();
            if (iilll1I11li1 instanceof IiL) {
                iiL = (IiL) iilll1I11li1;
            }
            iilll1I11li1 = iilll1I11li2;
        }
        return iiL;
    }

    /* JADX INFO: renamed from: 丨ILI, reason: contains not printable characters */
    public void m2678ILI(iILLL1 iilll1) {
        this.l1Lll.add(iilll1);
        if (iilll1.I11li1() != null) {
            ((llL1ii) iilll1.I11li1()).m2677iLiLI(iilll1);
        }
        iilll1.m2639iIl1il(this);
    }

    @Override // ILil.p045lLi1LL.IL1Iii.ILL.iILLL1
    /* JADX INFO: renamed from: 丨IillIi */
    public void mo2659IillIi() {
        super.mo2659IillIi();
        ArrayList<iILLL1> arrayList = this.l1Lll;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            iILLL1 iilll1 = this.l1Lll.get(i);
            iilll1.mo2650lIIiIlL(LlLI1(), m2654llL1ii());
            if (!(iilll1 instanceof IiL)) {
                iilll1.mo2659IillIi();
            }
        }
    }

    /* JADX INFO: renamed from: 丨ili丨, reason: contains not printable characters */
    public void m2679ili() {
        this.l1Lll.clear();
    }
}
