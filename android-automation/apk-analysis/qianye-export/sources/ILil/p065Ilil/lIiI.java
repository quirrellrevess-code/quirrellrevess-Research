package ILil.p065Ilil;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: ILil.Ilil.lIi丨I, reason: invalid class name */
/* JADX INFO: compiled from: ArraySet.java */
/* JADX INFO: loaded from: classes.dex */
public final class lIiI<E> implements Collection<E>, Set<E> {
    public static int ILL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static Object[] f1568IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static int f1569L11I;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static Object[] f1572il;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Object[] f3971I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int[] f3972ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public llL1ii<E, E> f3973Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f1573IL;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static final int[] f1571lLi1LL = new int[0];

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static final Object[] f1570iILLL1 = new Object[0];

    /* JADX INFO: renamed from: ILil.Ilil.lIi丨I$IL1Iii */
    /* JADX INFO: compiled from: ArraySet.java */
    public class IL1Iii extends llL1ii<E, E> {
        public IL1Iii() {
        }

        @Override // ILil.p065Ilil.llL1ii
        public Map<E, E> I1I() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // ILil.p065Ilil.llL1ii
        public void IL1Iii() {
            lIiI.this.clear();
        }

        @Override // ILil.p065Ilil.llL1ii
        public Object ILil(int i, int i2) {
            return lIiI.this.f3971I1I[i];
        }

        @Override // ILil.p065Ilil.llL1ii
        public int Ilil(Object obj) {
            return lIiI.this.indexOf(obj);
        }

        @Override // ILil.p065Ilil.llL1ii
        /* JADX INFO: renamed from: I丨L */
        public int mo1953IL() {
            return lIiI.this.f1573IL;
        }

        @Override // ILil.p065Ilil.llL1ii
        /* JADX INFO: renamed from: I丨iL */
        public void mo1954IiL(int i) {
            lIiI.this.m1968iILLL1(i);
        }

        @Override // ILil.p065Ilil.llL1ii
        /* JADX INFO: renamed from: L丨1丨1丨I */
        public E mo1955L11I(int i, E e) {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // ILil.p065Ilil.llL1ii
        /* JADX INFO: renamed from: iI丨LLL1 */
        public void mo1956iILLL1(E e, E e2) {
            lIiI.this.add(e);
        }

        @Override // ILil.p065Ilil.llL1ii
        /* JADX INFO: renamed from: l丨Li1LL */
        public int mo1957lLi1LL(Object obj) {
            return lIiI.this.indexOf(obj);
        }
    }

    public lIiI() {
        this(0);
    }

    public static void I1I(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (lIiI.class) {
                if (ILL < 10) {
                    objArr[0] = f1572il;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f1572il = objArr;
                    ILL++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (lIiI.class) {
                if (f1569L11I < 10) {
                    objArr[0] = f1568IiL;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f1568IiL = objArr;
                    f1569L11I++;
                }
            }
        }
    }

    public final void IL1Iii(int i) {
        if (i == 8) {
            synchronized (lIiI.class) {
                Object[] objArr = f1572il;
                if (objArr != null) {
                    this.f3971I1I = objArr;
                    f1572il = (Object[]) objArr[0];
                    this.f3972ILil = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    ILL--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (lIiI.class) {
                Object[] objArr2 = f1568IiL;
                if (objArr2 != null) {
                    this.f3971I1I = objArr2;
                    f1568IiL = (Object[]) objArr2[0];
                    this.f3972ILil = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f1569L11I--;
                    return;
                }
            }
        }
        this.f3972ILil = new int[i];
        this.f3971I1I = new Object[i];
    }

    public void ILil(int i) {
        int[] iArr = this.f3972ILil;
        if (iArr.length < i) {
            Object[] objArr = this.f3971I1I;
            IL1Iii(i);
            int i2 = this.f1573IL;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.f3972ILil, 0, i2);
                System.arraycopy(objArr, 0, this.f3971I1I, 0, this.f1573IL);
            }
            I1I(iArr, objArr, this.f1573IL);
        }
    }

    public final int Ilil(Object obj, int i) {
        int i2 = this.f1573IL;
        if (i2 == 0) {
            return -1;
        }
        int iIL1Iii = ILl.IL1Iii(this.f3972ILil, i2, i);
        if (iIL1Iii < 0 || obj.equals(this.f3971I1I[iIL1Iii])) {
            return iIL1Iii;
        }
        int i3 = iIL1Iii + 1;
        while (i3 < i2 && this.f3972ILil[i3] == i) {
            if (obj.equals(this.f3971I1I[i3])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iIL1Iii - 1; i4 >= 0 && this.f3972ILil[i4] == i; i4--) {
            if (obj.equals(this.f3971I1I[i4])) {
                return i4;
            }
        }
        return ~i3;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final llL1ii<E, E> m1966IL() {
        if (this.f3973Ilil == null) {
            this.f3973Ilil = new IL1Iii();
        }
        return this.f3973Ilil;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public E m1967IiL(int i) {
        return (E) this.f3971I1I[i];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i;
        int iIlil;
        if (e == null) {
            iIlil = m1969lLi1LL();
            i = 0;
        } else {
            int iHashCode = e.hashCode();
            i = iHashCode;
            iIlil = Ilil(e, iHashCode);
        }
        if (iIlil >= 0) {
            return false;
        }
        int i2 = ~iIlil;
        int i3 = this.f1573IL;
        int[] iArr = this.f3972ILil;
        if (i3 >= iArr.length) {
            int i4 = 4;
            if (i3 >= 8) {
                i4 = (i3 >> 1) + i3;
            } else if (i3 >= 4) {
                i4 = 8;
            }
            Object[] objArr = this.f3971I1I;
            IL1Iii(i4);
            int[] iArr2 = this.f3972ILil;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f3971I1I, 0, objArr.length);
            }
            I1I(iArr, objArr, this.f1573IL);
        }
        int i5 = this.f1573IL;
        if (i2 < i5) {
            int[] iArr3 = this.f3972ILil;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr2 = this.f3971I1I;
            System.arraycopy(objArr2, i2, objArr2, i6, this.f1573IL - i2);
        }
        this.f3972ILil[i2] = i;
        this.f3971I1I[i2] = e;
        this.f1573IL++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        ILil(this.f1573IL + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i = this.f1573IL;
        if (i != 0) {
            I1I(this.f3972ILil, this.f3971I1I, i);
            this.f3972ILil = f1571lLi1LL;
            this.f3971I1I = f1570iILLL1;
            this.f1573IL = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i = 0; i < this.f1573IL; i++) {
                try {
                    if (!set.contains(m1967IiL(i))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f3972ILil;
        int i = this.f1573IL;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public E m1968iILLL1(int i) {
        Object[] objArr = this.f3971I1I;
        E e = (E) objArr[i];
        int i2 = this.f1573IL;
        if (i2 <= 1) {
            I1I(this.f3972ILil, objArr, i2);
            this.f3972ILil = f1571lLi1LL;
            this.f3971I1I = f1570iILLL1;
            this.f1573IL = 0;
        } else {
            int[] iArr = this.f3972ILil;
            if (iArr.length <= 8 || i2 >= iArr.length / 3) {
                int i3 = i2 - 1;
                this.f1573IL = i3;
                if (i < i3) {
                    int i4 = i + 1;
                    System.arraycopy(iArr, i4, iArr, i, i3 - i);
                    Object[] objArr2 = this.f3971I1I;
                    System.arraycopy(objArr2, i4, objArr2, i, this.f1573IL - i);
                }
                this.f3971I1I[this.f1573IL] = null;
            } else {
                IL1Iii(i2 > 8 ? i2 + (i2 >> 1) : 8);
                this.f1573IL--;
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.f3972ILil, 0, i);
                    System.arraycopy(objArr, 0, this.f3971I1I, 0, i);
                }
                int i5 = this.f1573IL;
                if (i < i5) {
                    int i6 = i + 1;
                    System.arraycopy(iArr, i6, this.f3972ILil, i, i5 - i);
                    System.arraycopy(objArr, i6, this.f3971I1I, i, this.f1573IL - i);
                }
            }
        }
        return e;
    }

    public int indexOf(Object obj) {
        return obj == null ? m1969lLi1LL() : Ilil(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f1573IL <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return m1966IL().m1981lIiI().iterator();
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final int m1969lLi1LL() {
        int i = this.f1573IL;
        if (i == 0) {
            return -1;
        }
        int iIL1Iii = ILl.IL1Iii(this.f3972ILil, i, 0);
        if (iIL1Iii < 0 || this.f3971I1I[iIL1Iii] == null) {
            return iIL1Iii;
        }
        int i2 = iIL1Iii + 1;
        while (i2 < i && this.f3972ILil[i2] == 0) {
            if (this.f3971I1I[i2] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iIL1Iii - 1; i3 >= 0 && this.f3972ILil[i3] == 0; i3--) {
            if (this.f3971I1I[i3] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        m1968iILLL1(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.f1573IL - 1; i >= 0; i--) {
            if (!collection.contains(this.f3971I1I[i])) {
                m1968iILLL1(i);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f1573IL;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i = this.f1573IL;
        Object[] objArr = new Object[i];
        System.arraycopy(this.f3971I1I, 0, objArr, 0, i);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1573IL * 14);
        sb.append('{');
        for (int i = 0; i < this.f1573IL; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            E eM1967IiL = m1967IiL(i);
            if (eM1967IiL != this) {
                sb.append(eM1967IiL);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public lIiI(int i) {
        if (i == 0) {
            this.f3972ILil = f1571lLi1LL;
            this.f3971I1I = f1570iILLL1;
        } else {
            IL1Iii(i);
        }
        this.f1573IL = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f1573IL) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f1573IL));
        }
        System.arraycopy(this.f3971I1I, 0, tArr, 0, this.f1573IL);
        int length = tArr.length;
        int i = this.f1573IL;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }
}
