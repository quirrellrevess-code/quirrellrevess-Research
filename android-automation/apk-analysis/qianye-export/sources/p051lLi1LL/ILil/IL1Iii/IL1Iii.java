package p051lLi1LL.ILil.IL1Iii;

/* JADX INFO: compiled from: AsyncPoster.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii implements Runnable, lIiI {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final I1I f5549I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final Ll1 f5550ILil = new Ll1();

    public IL1Iii(I1I i1i) {
        this.f5549I1I = i1i;
    }

    @Override // p051lLi1LL.ILil.IL1Iii.lIiI
    public void IL1Iii(lIlii lilii, Object obj) {
        this.f5550ILil.IL1Iii(ILL.IL1Iii(lilii, obj));
        this.f5549I1I.m3663IL().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        ILL illILil = this.f5550ILil.ILil();
        if (illILil == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.f5549I1I.m3667iILLL1(illILil);
    }
}
