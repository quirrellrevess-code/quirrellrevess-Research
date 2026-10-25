package ILil.p065Ilil;

/* JADX INFO: compiled from: LongSparseArray.java */
/* JADX INFO: loaded from: classes.dex */
public class Lil<E> implements Cloneable {

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static final Object f1558lLi1LL = new Object();

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public long[] f3961I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public boolean f3962ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public int f3963Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Object[] f1559IL;

    public Lil() {
        this(10);
    }

    /* JADX INFO: renamed from: I1I, reason: merged with bridge method [inline-methods] */
    public Lil<E> clone() {
        try {
            Lil<E> lil = (Lil) super.clone();
            lil.f3961I1I = (long[]) this.f3961I1I.clone();
            lil.f1559IL = (Object[]) this.f1559IL.clone();
            return lil;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public void IL1Iii(long j, E e) {
        int i = this.f3963Ilil;
        if (i != 0 && j <= this.f3961I1I[i - 1]) {
            ILL(j, e);
            return;
        }
        if (this.f3962ILil && i >= this.f3961I1I.length) {
            Ilil();
        }
        int i2 = this.f3963Ilil;
        if (i2 >= this.f3961I1I.length) {
            int iM1940lLi1LL = ILl.m1940lLi1LL(i2 + 1);
            long[] jArr = new long[iM1940lLi1LL];
            Object[] objArr = new Object[iM1940lLi1LL];
            long[] jArr2 = this.f3961I1I;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f1559IL;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f3961I1I = jArr;
            this.f1559IL = objArr;
        }
        this.f3961I1I[i2] = j;
        this.f1559IL[i2] = e;
        this.f3963Ilil = i2 + 1;
    }

    public void ILL(long j, E e) {
        int iILil = ILl.ILil(this.f3961I1I, this.f3963Ilil, j);
        if (iILil >= 0) {
            this.f1559IL[iILil] = e;
            return;
        }
        int i = ~iILil;
        int i2 = this.f3963Ilil;
        if (i < i2) {
            Object[] objArr = this.f1559IL;
            if (objArr[i] == f1558lLi1LL) {
                this.f3961I1I[i] = j;
                objArr[i] = e;
                return;
            }
        }
        if (this.f3962ILil && i2 >= this.f3961I1I.length) {
            Ilil();
            i = ~ILl.ILil(this.f3961I1I, this.f3963Ilil, j);
        }
        int i3 = this.f3963Ilil;
        if (i3 >= this.f3961I1I.length) {
            int iM1940lLi1LL = ILl.m1940lLi1LL(i3 + 1);
            long[] jArr = new long[iM1940lLi1LL];
            Object[] objArr2 = new Object[iM1940lLi1LL];
            long[] jArr2 = this.f3961I1I;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f1559IL;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f3961I1I = jArr;
            this.f1559IL = objArr2;
        }
        int i4 = this.f3963Ilil;
        if (i4 - i != 0) {
            long[] jArr3 = this.f3961I1I;
            int i5 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i5, i4 - i);
            Object[] objArr4 = this.f1559IL;
            System.arraycopy(objArr4, i, objArr4, i5, this.f3963Ilil - i);
        }
        this.f3961I1I[i] = j;
        this.f1559IL[i] = e;
        this.f3963Ilil++;
    }

    public void ILil() {
        int i = this.f3963Ilil;
        Object[] objArr = this.f1559IL;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f3963Ilil = 0;
        this.f3962ILil = false;
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public int m1941ILl() {
        if (this.f3962ILil) {
            Ilil();
        }
        return this.f3963Ilil;
    }

    public final void Ilil() {
        int i = this.f3963Ilil;
        long[] jArr = this.f3961I1I;
        Object[] objArr = this.f1559IL;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1558lLi1LL) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f3962ILil = false;
        this.f3963Ilil = i2;
    }

    @Deprecated
    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m1942IL(long j) {
        m1943Ll1(j);
    }

    public E Lil(int i) {
        if (this.f3962ILil) {
            Ilil();
        }
        return (E) this.f1559IL[i];
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public void m1943Ll1(long j) {
        int iILil = ILl.ILil(this.f3961I1I, this.f3963Ilil, j);
        if (iILil >= 0) {
            Object[] objArr = this.f1559IL;
            Object obj = objArr[iILil];
            Object obj2 = f1558lLi1LL;
            if (obj != obj2) {
                objArr[iILil] = obj2;
                this.f3962ILil = true;
            }
        }
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public int m1944L11I(long j) {
        if (this.f3962ILil) {
            Ilil();
        }
        return ILl.ILil(this.f3961I1I, this.f3963Ilil, j);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public E m1945iILLL1(long j, E e) {
        int iILil = ILl.ILil(this.f3961I1I, this.f3963Ilil, j);
        if (iILil >= 0) {
            Object[] objArr = this.f1559IL;
            if (objArr[iILil] != f1558lLi1LL) {
                return (E) objArr[iILil];
            }
        }
        return e;
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public void m1946lIiI(int i) {
        Object[] objArr = this.f1559IL;
        Object obj = objArr[i];
        Object obj2 = f1558lLi1LL;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.f3962ILil = true;
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public E m1947lLi1LL(long j) {
        return m1945iILLL1(j, null);
    }

    public String toString() {
        if (m1941ILl() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f3963Ilil * 28);
        sb.append('{');
        for (int i = 0; i < this.f3963Ilil; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(m1948il(i));
            sb.append('=');
            E eLil = Lil(i);
            if (eLil != this) {
                sb.append(eLil);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public long m1948il(int i) {
        if (this.f3962ILil) {
            Ilil();
        }
        return this.f3961I1I[i];
    }

    public Lil(int i) {
        this.f3962ILil = false;
        if (i == 0) {
            this.f3961I1I = ILl.f3960ILil;
            this.f1559IL = ILl.f3958I1I;
        } else {
            int iM1940lLi1LL = ILl.m1940lLi1LL(i);
            this.f3961I1I = new long[iM1940lLi1LL];
            this.f1559IL = new Object[iM1940lLi1LL];
        }
    }
}
