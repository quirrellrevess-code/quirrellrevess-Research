package ILil.p028IiL.p034lIiI;

/* JADX INFO: renamed from: ILil.I丨iL.lIi丨I.I丨iL, reason: invalid class name */
/* JADX INFO: compiled from: Pools.java */
/* JADX INFO: loaded from: classes.dex */
public class IiL<T> extends iILLL1<T> {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final Object f4198I1I;

    public IiL(int i) {
        super(i);
        this.f4198I1I = new Object();
    }

    @Override // ILil.p028IiL.p034lIiI.iILLL1, ILil.p028IiL.p034lIiI.lLi1LL
    public boolean IL1Iii(T t) {
        boolean zIL1Iii;
        synchronized (this.f4198I1I) {
            zIL1Iii = super.IL1Iii(t);
        }
        return zIL1Iii;
    }

    @Override // ILil.p028IiL.p034lIiI.iILLL1, ILil.p028IiL.p034lIiI.lLi1LL
    public T ILil() {
        T t;
        synchronized (this.f4198I1I) {
            t = (T) super.ILil();
        }
        return t;
    }
}
