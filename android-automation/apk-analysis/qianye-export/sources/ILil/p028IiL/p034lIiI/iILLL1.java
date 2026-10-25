package ILil.p028IiL.p034lIiI;

/* JADX INFO: renamed from: ILil.I丨iL.lIi丨I.iI丨LLL1, reason: invalid class name */
/* JADX INFO: compiled from: Pools.java */
/* JADX INFO: loaded from: classes.dex */
public class iILLL1<T> implements lLi1LL<T> {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Object[] f4199IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f4200ILil;

    public iILLL1(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f4199IL1Iii = new Object[i];
    }

    public final boolean I1I(T t) {
        for (int i = 0; i < this.f4200ILil; i++) {
            if (this.f4199IL1Iii[i] == t) {
                return true;
            }
        }
        return false;
    }

    @Override // ILil.p028IiL.p034lIiI.lLi1LL
    public boolean IL1Iii(T t) {
        if (I1I(t)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i = this.f4200ILil;
        Object[] objArr = this.f4199IL1Iii;
        if (i >= objArr.length) {
            return false;
        }
        objArr[i] = t;
        this.f4200ILil = i + 1;
        return true;
    }

    @Override // ILil.p028IiL.p034lIiI.lLi1LL
    public T ILil() {
        int i = this.f4200ILil;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.f4199IL1Iii;
        T t = (T) objArr[i2];
        objArr[i2] = null;
        this.f4200ILil = i - 1;
        return t;
    }
}
