package ILil.p045lLi1LL.IL1Iii;

/* JADX INFO: renamed from: ILil.l丨Li1LL.IL1Iii.L丨1丨1丨I, reason: invalid class name */
/* JADX INFO: compiled from: Pools.java */
/* JADX INFO: loaded from: classes.dex */
public class L11I<T> implements IiL<T> {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Object[] f4527IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f4528ILil;

    public L11I(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f4527IL1Iii = new Object[i];
    }

    @Override // ILil.p045lLi1LL.IL1Iii.IiL
    public void I1I(T[] tArr, int i) {
        if (i > tArr.length) {
            i = tArr.length;
        }
        for (int i2 = 0; i2 < i; i2++) {
            T t = tArr[i2];
            int i3 = this.f4528ILil;
            Object[] objArr = this.f4527IL1Iii;
            if (i3 < objArr.length) {
                objArr[i3] = t;
                this.f4528ILil = i3 + 1;
            }
        }
    }

    @Override // ILil.p045lLi1LL.IL1Iii.IiL
    public boolean IL1Iii(T t) {
        int i = this.f4528ILil;
        Object[] objArr = this.f4527IL1Iii;
        if (i >= objArr.length) {
            return false;
        }
        objArr[i] = t;
        this.f4528ILil = i + 1;
        return true;
    }

    @Override // ILil.p045lLi1LL.IL1Iii.IiL
    public T ILil() {
        int i = this.f4528ILil;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.f4527IL1Iii;
        T t = (T) objArr[i2];
        objArr[i2] = null;
        this.f4528ILil = i - 1;
        return t;
    }
}
