package ILil.p065Ilil;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: renamed from: ILil.Ilil.ll丨L1ii, reason: invalid class name */
/* JADX INFO: compiled from: MapCollections.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class llL1ii<K, V> {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public llL1ii<K, V>.lLi1LL f3977I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public llL1ii<K, V>.ILil f3978IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public llL1ii<K, V>.I1I f3979ILil;

    /* JADX INFO: renamed from: ILil.Ilil.ll丨L1ii$I1I */
    /* JADX INFO: compiled from: MapCollections.java */
    public final class I1I implements Set<K> {
        public I1I() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            llL1ii.this.IL1Iii();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return llL1ii.this.Ilil(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return llL1ii.m1978il(llL1ii.this.I1I(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return llL1ii.ILL(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iMo1953IL = llL1ii.this.mo1953IL() - 1; iMo1953IL >= 0; iMo1953IL--) {
                Object objILil = llL1ii.this.ILil(iMo1953IL, 0);
                iHashCode += objILil == null ? 0 : objILil.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return llL1ii.this.mo1953IL() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new IL1Iii(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iIlil = llL1ii.this.Ilil(obj);
            if (iIlil < 0) {
                return false;
            }
            llL1ii.this.mo1954IiL(iIlil);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return llL1ii.Lil(llL1ii.this.I1I(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return llL1ii.LlLI1(llL1ii.this.I1I(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return llL1ii.this.mo1953IL();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return llL1ii.this.m1983llL1ii(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) llL1ii.this.m1982lIlii(tArr, 0);
        }
    }

    /* JADX INFO: renamed from: ILil.Ilil.ll丨L1ii$IL1Iii */
    /* JADX INFO: compiled from: MapCollections.java */
    public final class IL1Iii<T> implements Iterator<T> {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f3981I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final int f3982ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public boolean f3983Ilil = false;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int f1579IL;

        public IL1Iii(int i) {
            this.f3982ILil = i;
            this.f3981I1I = llL1ii.this.mo1953IL();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1579IL < this.f3981I1I;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = (T) llL1ii.this.ILil(this.f1579IL, this.f3982ILil);
            this.f1579IL++;
            this.f3983Ilil = true;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f3983Ilil) {
                throw new IllegalStateException();
            }
            int i = this.f1579IL - 1;
            this.f1579IL = i;
            this.f3981I1I--;
            this.f3983Ilil = false;
            llL1ii.this.mo1954IiL(i);
        }
    }

    /* JADX INFO: renamed from: ILil.Ilil.ll丨L1ii$ILil */
    /* JADX INFO: compiled from: MapCollections.java */
    public final class ILil implements Set<Map.Entry<K, V>> {
        public ILil() {
        }

        public boolean IL1Iii(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            IL1Iii((Map.Entry) obj);
            throw null;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int iMo1953IL = llL1ii.this.mo1953IL();
            for (Map.Entry<K, V> entry : collection) {
                llL1ii.this.mo1956iILLL1(entry.getKey(), entry.getValue());
            }
            return iMo1953IL != llL1ii.this.mo1953IL();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            llL1ii.this.IL1Iii();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iIlil = llL1ii.this.Ilil(entry.getKey());
            if (iIlil < 0) {
                return false;
            }
            return ILl.I1I(llL1ii.this.ILil(iIlil, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return llL1ii.ILL(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iMo1953IL = llL1ii.this.mo1953IL() - 1; iMo1953IL >= 0; iMo1953IL--) {
                Object objILil = llL1ii.this.ILil(iMo1953IL, 0);
                Object objILil2 = llL1ii.this.ILil(iMo1953IL, 1);
                iHashCode += (objILil == null ? 0 : objILil.hashCode()) ^ (objILil2 == null ? 0 : objILil2.hashCode());
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return llL1ii.this.mo1953IL() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new IL();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return llL1ii.this.mo1953IL();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: renamed from: ILil.Ilil.ll丨L1ii$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: MapCollections.java */
    public final class IL implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f3986ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public boolean f1581IL = false;

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f3985I1I = -1;

        public IL() {
            this.f3986ILil = llL1ii.this.mo1953IL() - 1;
        }

        public Map.Entry<K, V> IL1Iii() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f3985I1I++;
            this.f1581IL = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f1581IL) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return ILl.I1I(entry.getKey(), llL1ii.this.ILil(this.f3985I1I, 0)) && ILl.I1I(entry.getValue(), llL1ii.this.ILil(this.f3985I1I, 1));
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f1581IL) {
                return (K) llL1ii.this.ILil(this.f3985I1I, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f1581IL) {
                return (V) llL1ii.this.ILil(this.f3985I1I, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3985I1I < this.f3986ILil;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.f1581IL) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object objILil = llL1ii.this.ILil(this.f3985I1I, 0);
            Object objILil2 = llL1ii.this.ILil(this.f3985I1I, 1);
            return (objILil == null ? 0 : objILil.hashCode()) ^ (objILil2 != null ? objILil2.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            IL1Iii();
            return this;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f1581IL) {
                throw new IllegalStateException();
            }
            llL1ii.this.mo1954IiL(this.f3985I1I);
            this.f3985I1I--;
            this.f3986ILil--;
            this.f1581IL = false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (this.f1581IL) {
                return (V) llL1ii.this.mo1955L11I(this.f3985I1I, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* JADX INFO: renamed from: ILil.Ilil.ll丨L1ii$l丨Li1LL, reason: invalid class name */
    /* JADX INFO: compiled from: MapCollections.java */
    public final class lLi1LL implements Collection<V> {
        public lLi1LL() {
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            llL1ii.this.IL1Iii();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return llL1ii.this.mo1957lLi1LL(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return llL1ii.this.mo1953IL() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new IL1Iii(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int iMo1957lLi1LL = llL1ii.this.mo1957lLi1LL(obj);
            if (iMo1957lLi1LL < 0) {
                return false;
            }
            llL1ii.this.mo1954IiL(iMo1957lLi1LL);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int iMo1953IL = llL1ii.this.mo1953IL();
            int i = 0;
            boolean z = false;
            while (i < iMo1953IL) {
                if (collection.contains(llL1ii.this.ILil(i, 1))) {
                    llL1ii.this.mo1954IiL(i);
                    i--;
                    iMo1953IL--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int iMo1953IL = llL1ii.this.mo1953IL();
            int i = 0;
            boolean z = false;
            while (i < iMo1953IL) {
                if (!collection.contains(llL1ii.this.ILil(i, 1))) {
                    llL1ii.this.mo1954IiL(i);
                    i--;
                    iMo1953IL--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public int size() {
            return llL1ii.this.mo1953IL();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return llL1ii.this.m1983llL1ii(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) llL1ii.this.m1982lIlii(tArr, 1);
        }
    }

    public static <T> boolean ILL(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean Lil(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean LlLI1(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static <K, V> boolean m1978il(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public abstract Map<K, V> I1I();

    public abstract void IL1Iii();

    public abstract Object ILil(int i, int i2);

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public Collection<V> m1979ILl() {
        if (this.f3977I1I == null) {
            this.f3977I1I = new lLi1LL();
        }
        return this.f3977I1I;
    }

    public abstract int Ilil(Object obj);

    /* JADX INFO: renamed from: I丨L */
    public abstract int mo1953IL();

    /* JADX INFO: renamed from: I丨iL */
    public abstract void mo1954IiL(int i);

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public Set<Map.Entry<K, V>> m1980Ll1() {
        if (this.f3978IL1Iii == null) {
            this.f3978IL1Iii = new ILil();
        }
        return this.f3978IL1Iii;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I */
    public abstract V mo1955L11I(int i, V v);

    /* JADX INFO: renamed from: iI丨LLL1 */
    public abstract void mo1956iILLL1(K k, V v);

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public Set<K> m1981lIiI() {
        if (this.f3979ILil == null) {
            this.f3979ILil = new I1I();
        }
        return this.f3979ILil;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public <T> T[] m1982lIlii(T[] tArr, int i) {
        int iMo1953IL = mo1953IL();
        if (tArr.length < iMo1953IL) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iMo1953IL));
        }
        for (int i2 = 0; i2 < iMo1953IL; i2++) {
            tArr[i2] = ILil(i2, i);
        }
        if (tArr.length > iMo1953IL) {
            tArr[iMo1953IL] = null;
        }
        return tArr;
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public Object[] m1983llL1ii(int i) {
        int iMo1953IL = mo1953IL();
        Object[] objArr = new Object[iMo1953IL];
        for (int i2 = 0; i2 < iMo1953IL; i2++) {
            objArr[i2] = ILil(i2, i);
        }
        return objArr;
    }

    /* JADX INFO: renamed from: l丨Li1LL */
    public abstract int mo1957lLi1LL(Object obj);
}
