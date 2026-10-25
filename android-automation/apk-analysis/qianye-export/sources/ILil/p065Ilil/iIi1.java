package ILil.p065Ilil;

/* JADX INFO: compiled from: SparseArrayCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class iIi1<E> implements Cloneable {

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static final Object f1566lLi1LL = new Object();

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int[] f3968I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public boolean f3969ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public int f3970Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Object[] f1567IL;

    public iIi1() {
        this(10);
    }

    /* JADX INFO: renamed from: I1I, reason: merged with bridge method [inline-methods] */
    public iIi1<E> clone() {
        try {
            iIi1<E> iii1 = (iIi1) super.clone();
            iii1.f3968I1I = (int[]) this.f3968I1I.clone();
            iii1.f1567IL = (Object[]) this.f1567IL.clone();
            return iii1;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public void IL1Iii(int i, E e) {
        int i2 = this.f3970Ilil;
        if (i2 != 0 && i <= this.f3968I1I[i2 - 1]) {
            ILL(i, e);
            return;
        }
        if (this.f3969ILil && i2 >= this.f3968I1I.length) {
            m1959IL();
        }
        int i3 = this.f3970Ilil;
        if (i3 >= this.f3968I1I.length) {
            int iIlil = ILl.Ilil(i3 + 1);
            int[] iArr = new int[iIlil];
            Object[] objArr = new Object[iIlil];
            int[] iArr2 = this.f3968I1I;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f1567IL;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f3968I1I = iArr;
            this.f1567IL = objArr;
        }
        this.f3968I1I[i3] = i;
        this.f1567IL[i3] = e;
        this.f3970Ilil = i3 + 1;
    }

    public void ILL(int i, E e) {
        int iIL1Iii = ILl.IL1Iii(this.f3968I1I, this.f3970Ilil, i);
        if (iIL1Iii >= 0) {
            this.f1567IL[iIL1Iii] = e;
            return;
        }
        int i2 = ~iIL1Iii;
        int i3 = this.f3970Ilil;
        if (i2 < i3) {
            Object[] objArr = this.f1567IL;
            if (objArr[i2] == f1566lLi1LL) {
                this.f3968I1I[i2] = i;
                objArr[i2] = e;
                return;
            }
        }
        if (this.f3969ILil && i3 >= this.f3968I1I.length) {
            m1959IL();
            i2 = ~ILl.IL1Iii(this.f3968I1I, this.f3970Ilil, i);
        }
        int i4 = this.f3970Ilil;
        if (i4 >= this.f3968I1I.length) {
            int iIlil = ILl.Ilil(i4 + 1);
            int[] iArr = new int[iIlil];
            Object[] objArr2 = new Object[iIlil];
            int[] iArr2 = this.f3968I1I;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f1567IL;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f3968I1I = iArr;
            this.f1567IL = objArr2;
        }
        int i5 = this.f3970Ilil;
        if (i5 - i2 != 0) {
            int[] iArr3 = this.f3968I1I;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr4 = this.f1567IL;
            System.arraycopy(objArr4, i2, objArr4, i6, this.f3970Ilil - i2);
        }
        this.f3968I1I[i2] = i;
        this.f1567IL[i2] = e;
        this.f3970Ilil++;
    }

    public void ILil() {
        int i = this.f3970Ilil;
        Object[] objArr = this.f1567IL;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f3970Ilil = 0;
        this.f3969ILil = false;
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public E m1958ILl(int i) {
        if (this.f3969ILil) {
            m1959IL();
        }
        return (E) this.f1567IL[i];
    }

    public E Ilil(int i) {
        return m1964lLi1LL(i, null);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final void m1959IL() {
        int i = this.f3970Ilil;
        int[] iArr = this.f3968I1I;
        Object[] objArr = this.f1567IL;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1566lLi1LL) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f3969ILil = false;
        this.f3970Ilil = i2;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public void m1960Ll1(int i) {
        int iIL1Iii = ILl.IL1Iii(this.f3968I1I, this.f3970Ilil, i);
        if (iIL1Iii >= 0) {
            Object[] objArr = this.f1567IL;
            Object obj = objArr[iIL1Iii];
            Object obj2 = f1566lLi1LL;
            if (obj != obj2) {
                objArr[iIL1Iii] = obj2;
                this.f3969ILil = true;
            }
        }
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public int m1961L11I(E e) {
        if (this.f3969ILil) {
            m1959IL();
        }
        for (int i = 0; i < this.f3970Ilil; i++) {
            if (this.f1567IL[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int m1962iILLL1(int i) {
        if (this.f3969ILil) {
            m1959IL();
        }
        return ILl.IL1Iii(this.f3968I1I, this.f3970Ilil, i);
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public int m1963lIiI() {
        if (this.f3969ILil) {
            m1959IL();
        }
        return this.f3970Ilil;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public E m1964lLi1LL(int i, E e) {
        int iIL1Iii = ILl.IL1Iii(this.f3968I1I, this.f3970Ilil, i);
        if (iIL1Iii >= 0) {
            Object[] objArr = this.f1567IL;
            if (objArr[iIL1Iii] != f1566lLi1LL) {
                return (E) objArr[iIL1Iii];
            }
        }
        return e;
    }

    public String toString() {
        if (m1963lIiI() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f3970Ilil * 28);
        sb.append('{');
        for (int i = 0; i < this.f3970Ilil; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(m1965il(i));
            sb.append('=');
            E eM1958ILl = m1958ILl(i);
            if (eM1958ILl != this) {
                sb.append(eM1958ILl);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public int m1965il(int i) {
        if (this.f3969ILil) {
            m1959IL();
        }
        return this.f3968I1I[i];
    }

    public iIi1(int i) {
        this.f3969ILil = false;
        if (i == 0) {
            this.f3968I1I = ILl.f3959IL1Iii;
            this.f1567IL = ILl.f3958I1I;
        } else {
            int iIlil = ILl.Ilil(i);
            this.f3968I1I = new int[iIlil];
            this.f1567IL = new Object[iIlil];
        }
    }
}
