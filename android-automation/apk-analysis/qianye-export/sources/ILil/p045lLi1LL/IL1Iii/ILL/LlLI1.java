package ILil.p045lLi1LL.IL1Iii.ILL;

import java.util.ArrayList;

/* JADX INFO: compiled from: Snapshot.java */
/* JADX INFO: loaded from: classes.dex */
public class LlLI1 {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f4492I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public int f4493IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f4494ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public ArrayList<IL1Iii> f4495Ilil = new ArrayList<>();

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f1904IL;

    /* JADX INFO: compiled from: Snapshot.java */
    public static class IL1Iii {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f4496I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public lLi1LL f4497IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public lLi1LL f4498ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int f4499Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public lLi1LL.I1I f1905IL;

        public IL1Iii(lLi1LL lli1ll) {
            this.f4497IL1Iii = lli1ll;
            this.f4498ILil = lli1ll.m2684L11I();
            this.f4496I1I = lli1ll.m2681IL();
            this.f1905IL = lli1ll.m2682IiL();
            this.f4499Ilil = lli1ll.I1I();
        }

        public void IL1Iii(iILLL1 iilll1) {
            iilll1.mo2627IiL(this.f4497IL1Iii.m2688il()).ILil(this.f4498ILil, this.f4496I1I, this.f1905IL, this.f4499Ilil);
        }

        public void ILil(iILLL1 iilll1) {
            lLi1LL lli1llMo2627IiL = iilll1.mo2627IiL(this.f4497IL1Iii.m2688il());
            this.f4497IL1Iii = lli1llMo2627IiL;
            if (lli1llMo2627IiL != null) {
                this.f4498ILil = lli1llMo2627IiL.m2684L11I();
                this.f4496I1I = this.f4497IL1Iii.m2681IL();
                this.f1905IL = this.f4497IL1Iii.m2682IiL();
                this.f4499Ilil = this.f4497IL1Iii.I1I();
                return;
            }
            this.f4498ILil = null;
            this.f4496I1I = 0;
            this.f1905IL = lLi1LL.I1I.STRONG;
            this.f4499Ilil = 0;
        }
    }

    public LlLI1(iILLL1 iilll1) {
        this.f4493IL1Iii = iilll1.llI();
        this.f4494ILil = iilll1.m2649l1IIi1();
        this.f4492I1I = iilll1.m2629L111();
        this.f1904IL = iilll1.m2653lIlii();
        ArrayList<lLi1LL> arrayListMo2636L11I = iilll1.mo2636L11I();
        int size = arrayListMo2636L11I.size();
        for (int i = 0; i < size; i++) {
            this.f4495Ilil.add(new IL1Iii(arrayListMo2636L11I.get(i)));
        }
    }

    public void IL1Iii(iILLL1 iilll1) {
        iilll1.LIlLi(this.f4493IL1Iii);
        iilll1.lI1I1(this.f4494ILil);
        iilll1.ILI1Ll(this.f4492I1I);
        iilll1.m87iI(this.f1904IL);
        int size = this.f4495Ilil.size();
        for (int i = 0; i < size; i++) {
            this.f4495Ilil.get(i).IL1Iii(iilll1);
        }
    }

    public void ILil(iILLL1 iilll1) {
        this.f4493IL1Iii = iilll1.llI();
        this.f4494ILil = iilll1.m2649l1IIi1();
        this.f4492I1I = iilll1.m2629L111();
        this.f1904IL = iilll1.m2653lIlii();
        int size = this.f4495Ilil.size();
        for (int i = 0; i < size; i++) {
            this.f4495Ilil.get(i).ILil(iilll1);
        }
    }
}
