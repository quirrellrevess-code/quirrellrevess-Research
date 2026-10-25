package ILil.p065Ilil;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: renamed from: ILil.Ilil.lI丨lii, reason: invalid class name */
/* JADX INFO: compiled from: SimpleArrayMap.java */
/* JADX INFO: loaded from: classes.dex */
public class lIlii<K, V> {

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static Object[] f3974Ilil;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static int f1575IiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static Object[] f1576iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static int f1577lLi1LL;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Object[] f3975I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int[] f3976ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f1578IL;

    public lIlii() {
        this.f3976ILil = ILl.f3959IL1Iii;
        this.f3975I1I = ILl.f3958I1I;
        this.f1578IL = 0;
    }

    public static int ILil(int[] iArr, int i, int i2) {
        try {
            return ILl.IL1Iii(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static void m1970IL(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (lIlii.class) {
                if (f1575IiL < 10) {
                    objArr[0] = f1576iILLL1;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f1576iILLL1 = objArr;
                    f1575IiL++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (lIlii.class) {
                if (f1577lLi1LL < 10) {
                    objArr[0] = f3974Ilil;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f3974Ilil = objArr;
                    f1577lLi1LL++;
                }
            }
        }
    }

    public void I1I(int i) {
        int i2 = this.f1578IL;
        int[] iArr = this.f3976ILil;
        if (iArr.length < i) {
            Object[] objArr = this.f3975I1I;
            IL1Iii(i);
            if (this.f1578IL > 0) {
                System.arraycopy(iArr, 0, this.f3976ILil, 0, i2);
                System.arraycopy(objArr, 0, this.f3975I1I, 0, i2 << 1);
            }
            m1970IL(iArr, objArr, i2);
        }
        if (this.f1578IL != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public final void IL1Iii(int i) {
        if (i == 8) {
            synchronized (lIlii.class) {
                Object[] objArr = f1576iILLL1;
                if (objArr != null) {
                    this.f3975I1I = objArr;
                    f1576iILLL1 = (Object[]) objArr[0];
                    this.f3976ILil = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f1575IiL--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (lIlii.class) {
                Object[] objArr2 = f3974Ilil;
                if (objArr2 != null) {
                    this.f3975I1I = objArr2;
                    f3974Ilil = (Object[]) objArr2[0];
                    this.f3976ILil = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f1577lLi1LL--;
                    return;
                }
            }
        }
        this.f3976ILil = new int[i];
        this.f3975I1I = new Object[i << 1];
    }

    public V ILL(int i) {
        Object[] objArr = this.f3975I1I;
        int i2 = i << 1;
        V v = (V) objArr[i2 + 1];
        int i3 = this.f1578IL;
        int i4 = 0;
        if (i3 <= 1) {
            m1970IL(this.f3976ILil, objArr, i3);
            this.f3976ILil = ILl.f3959IL1Iii;
            this.f3975I1I = ILl.f3958I1I;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.f3976ILil;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                if (i < i5) {
                    int i6 = i + 1;
                    int i7 = i5 - i;
                    System.arraycopy(iArr, i6, iArr, i, i7);
                    Object[] objArr2 = this.f3975I1I;
                    System.arraycopy(objArr2, i6 << 1, objArr2, i2, i7 << 1);
                }
                Object[] objArr3 = this.f3975I1I;
                int i8 = i5 << 1;
                objArr3[i8] = null;
                objArr3[i8 + 1] = null;
            } else {
                IL1Iii(i3 > 8 ? i3 + (i3 >> 1) : 8);
                if (i3 != this.f1578IL) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.f3976ILil, 0, i);
                    System.arraycopy(objArr, 0, this.f3975I1I, 0, i2);
                }
                if (i < i5) {
                    int i9 = i + 1;
                    int i10 = i5 - i;
                    System.arraycopy(iArr, i9, this.f3976ILil, i, i10);
                    System.arraycopy(objArr, i9 << 1, this.f3975I1I, i2, i10 << 1);
                }
            }
            i4 = i5;
        }
        if (i3 != this.f1578IL) {
            throw new ConcurrentModificationException();
        }
        this.f1578IL = i4;
        return v;
    }

    public int Ilil(Object obj, int i) {
        int i2 = this.f1578IL;
        if (i2 == 0) {
            return -1;
        }
        int iILil = ILil(this.f3976ILil, i2, i);
        if (iILil < 0 || obj.equals(this.f3975I1I[iILil << 1])) {
            return iILil;
        }
        int i3 = iILil + 1;
        while (i3 < i2 && this.f3976ILil[i3] == i) {
            if (obj.equals(this.f3975I1I[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iILil - 1; i4 >= 0 && this.f3976ILil[i4] == i; i4--) {
            if (obj.equals(this.f3975I1I[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public int m1971IiL(Object obj) {
        int i = this.f1578IL * 2;
        Object[] objArr = this.f3975I1I;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public V m1972Ll1(int i, V v) {
        int i2 = (i << 1) + 1;
        Object[] objArr = this.f3975I1I;
        V v2 = (V) objArr[i2];
        objArr[i2] = v;
        return v2;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public K m1973L11I(int i) {
        return (K) this.f3975I1I[i << 1];
    }

    public void clear() {
        int i = this.f1578IL;
        if (i > 0) {
            int[] iArr = this.f3976ILil;
            Object[] objArr = this.f3975I1I;
            this.f3976ILil = ILl.f3959IL1Iii;
            this.f3975I1I = ILl.f3958I1I;
            this.f1578IL = 0;
            m1970IL(iArr, objArr, i);
        }
        if (this.f1578IL > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return m1976lLi1LL(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return m1971IiL(obj) >= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof lIlii) {
            lIlii lilii = (lIlii) obj;
            if (size() != lilii.size()) {
                return false;
            }
            for (int i = 0; i < this.f1578IL; i++) {
                try {
                    K kM1973L11I = m1973L11I(i);
                    V vM1975lIiI = m1975lIiI(i);
                    Object obj2 = lilii.get(kM1973L11I);
                    if (vM1975lIiI == null) {
                        if (obj2 != null || !lilii.containsKey(kM1973L11I)) {
                            return false;
                        }
                    } else if (!vM1975lIiI.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f1578IL; i2++) {
                try {
                    K kM1973L11I2 = m1973L11I(i2);
                    V vM1975lIiI2 = m1975lIiI(i2);
                    Object obj3 = map.get(kM1973L11I2);
                    if (vM1975lIiI2 == null) {
                        if (obj3 != null || !map.containsKey(kM1973L11I2)) {
                            return false;
                        }
                    } else if (!vM1975lIiI2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v) {
        int iM1976lLi1LL = m1976lLi1LL(obj);
        return iM1976lLi1LL >= 0 ? (V) this.f3975I1I[(iM1976lLi1LL << 1) + 1] : v;
    }

    public int hashCode() {
        int[] iArr = this.f3976ILil;
        Object[] objArr = this.f3975I1I;
        int i = this.f1578IL;
        int i2 = 1;
        int i3 = 0;
        int iHashCode = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return iHashCode;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int m1974iILLL1() {
        int i = this.f1578IL;
        if (i == 0) {
            return -1;
        }
        int iILil = ILil(this.f3976ILil, i, 0);
        if (iILil < 0 || this.f3975I1I[iILil << 1] == null) {
            return iILil;
        }
        int i2 = iILil + 1;
        while (i2 < i && this.f3976ILil[i2] == 0) {
            if (this.f3975I1I[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iILil - 1; i3 >= 0 && this.f3976ILil[i3] == 0; i3--) {
            if (this.f3975I1I[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    public boolean isEmpty() {
        return this.f1578IL <= 0;
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public V m1975lIiI(int i) {
        return (V) this.f3975I1I[(i << 1) + 1];
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int m1976lLi1LL(Object obj) {
        return obj == null ? m1974iILLL1() : Ilil(obj, obj.hashCode());
    }

    public V put(K k, V v) {
        int i;
        int iIlil;
        int i2 = this.f1578IL;
        if (k == null) {
            iIlil = m1974iILLL1();
            i = 0;
        } else {
            int iHashCode = k.hashCode();
            i = iHashCode;
            iIlil = Ilil(k, iHashCode);
        }
        if (iIlil >= 0) {
            int i3 = (iIlil << 1) + 1;
            Object[] objArr = this.f3975I1I;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        int i4 = ~iIlil;
        int[] iArr = this.f3976ILil;
        if (i2 >= iArr.length) {
            int i5 = 4;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 >= 4) {
                i5 = 8;
            }
            Object[] objArr2 = this.f3975I1I;
            IL1Iii(i5);
            if (i2 != this.f1578IL) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f3976ILil;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f3975I1I, 0, objArr2.length);
            }
            m1970IL(iArr, objArr2, i2);
        }
        if (i4 < i2) {
            int[] iArr3 = this.f3976ILil;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.f3975I1I;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.f1578IL - i4) << 1);
        }
        int i7 = this.f1578IL;
        if (i2 == i7) {
            int[] iArr4 = this.f3976ILil;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.f3975I1I;
                int i8 = i4 << 1;
                objArr4[i8] = k;
                objArr4[i8 + 1] = v;
                this.f1578IL = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k, V v) {
        V v2 = get(k);
        return v2 == null ? put(k, v) : v2;
    }

    public V remove(Object obj) {
        int iM1976lLi1LL = m1976lLi1LL(obj);
        if (iM1976lLi1LL >= 0) {
            return ILL(iM1976lLi1LL);
        }
        return null;
    }

    public V replace(K k, V v) {
        int iM1976lLi1LL = m1976lLi1LL(k);
        if (iM1976lLi1LL >= 0) {
            return m1972Ll1(iM1976lLi1LL, v);
        }
        return null;
    }

    public int size() {
        return this.f1578IL;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1578IL * 28);
        sb.append('{');
        for (int i = 0; i < this.f1578IL; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K kM1973L11I = m1973L11I(i);
            if (kM1973L11I != this) {
                sb.append(kM1973L11I);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V vM1975lIiI = m1975lIiI(i);
            if (vM1975lIiI != this) {
                sb.append(vM1975lIiI);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void m1977il(lIlii<? extends K, ? extends V> lilii) {
        int i = lilii.f1578IL;
        I1I(this.f1578IL + i);
        if (this.f1578IL != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(lilii.m1973L11I(i2), lilii.m1975lIiI(i2));
            }
        } else if (i > 0) {
            System.arraycopy(lilii.f3976ILil, 0, this.f3976ILil, 0, i);
            System.arraycopy(lilii.f3975I1I, 0, this.f3975I1I, 0, i << 1);
            this.f1578IL = i;
        }
    }

    public boolean remove(Object obj, Object obj2) {
        int iM1976lLi1LL = m1976lLi1LL(obj);
        if (iM1976lLi1LL < 0) {
            return false;
        }
        V vM1975lIiI = m1975lIiI(iM1976lLi1LL);
        if (obj2 != vM1975lIiI && (obj2 == null || !obj2.equals(vM1975lIiI))) {
            return false;
        }
        ILL(iM1976lLi1LL);
        return true;
    }

    public boolean replace(K k, V v, V v2) {
        int iM1976lLi1LL = m1976lLi1LL(k);
        if (iM1976lLi1LL < 0) {
            return false;
        }
        V vM1975lIiI = m1975lIiI(iM1976lLi1LL);
        if (vM1975lIiI != v && (v == null || !v.equals(vM1975lIiI))) {
            return false;
        }
        m1972Ll1(iM1976lLi1LL, v2);
        return true;
    }

    public lIlii(int i) {
        if (i == 0) {
            this.f3976ILil = ILl.f3959IL1Iii;
            this.f3975I1I = ILl.f3958I1I;
        } else {
            IL1Iii(i);
        }
        this.f1578IL = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public lIlii(lIlii<K, V> lilii) {
        this();
        if (lilii != 0) {
            m1977il(lilii);
        }
    }
}
