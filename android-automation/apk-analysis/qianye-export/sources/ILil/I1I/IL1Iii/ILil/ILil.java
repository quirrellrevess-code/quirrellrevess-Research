package ILil.I1I.IL1Iii.ILil;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: SafeIterableMap.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil<K, V> implements Iterable<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public I1I<K, V> f3607I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public I1I<K, V> f3608ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public WeakHashMap<iILLL1<K, V>, Boolean> f1199IL = new WeakHashMap<>();

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public int f3609Ilil = 0;

    /* JADX INFO: compiled from: SafeIterableMap.java */
    public static class I1I<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final V f3610I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final K f3611ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public I1I<K, V> f3612Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public I1I<K, V> f1200IL;

        public I1I(K k, V v) {
            this.f3611ILil = k;
            this.f3610I1I = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof I1I)) {
                return false;
            }
            I1I i1i = (I1I) obj;
            return this.f3611ILil.equals(i1i.f3611ILil) && this.f3610I1I.equals(i1i.f3610I1I);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f3611ILil;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f3610I1I;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f3611ILil.hashCode() ^ this.f3610I1I.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f3611ILil + "=" + this.f3610I1I;
        }
    }

    /* JADX INFO: compiled from: SafeIterableMap.java */
    public static class IL1Iii<K, V> extends lLi1LL<K, V> {
        public IL1Iii(I1I<K, V> i1i, I1I<K, V> i1i2) {
            super(i1i, i1i2);
        }

        @Override // ILil.I1I.IL1Iii.ILil.ILil.lLi1LL
        public I1I<K, V> I1I(I1I<K, V> i1i) {
            return i1i.f1200IL;
        }

        @Override // ILil.I1I.IL1Iii.ILil.ILil.lLi1LL
        public I1I<K, V> ILil(I1I<K, V> i1i) {
            return i1i.f3612Ilil;
        }
    }

    /* JADX INFO: renamed from: ILil.I1I.IL1Iii.ILil.ILil$ILil, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SafeIterableMap.java */
    public static class C0548ILil<K, V> extends lLi1LL<K, V> {
        public C0548ILil(I1I<K, V> i1i, I1I<K, V> i1i2) {
            super(i1i, i1i2);
        }

        @Override // ILil.I1I.IL1Iii.ILil.ILil.lLi1LL
        public I1I<K, V> I1I(I1I<K, V> i1i) {
            return i1i.f3612Ilil;
        }

        @Override // ILil.I1I.IL1Iii.ILil.ILil.lLi1LL
        public I1I<K, V> ILil(I1I<K, V> i1i) {
            return i1i.f1200IL;
        }
    }

    /* JADX INFO: renamed from: ILil.I1I.IL1Iii.ILil.ILil$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: SafeIterableMap.java */
    public class IL implements Iterator<Map.Entry<K, V>>, iILLL1<K, V> {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public boolean f3613I1I = true;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public I1I<K, V> f3614ILil;

        public IL() {
        }

        @Override // ILil.I1I.IL1Iii.ILil.ILil.iILLL1
        public void IL1Iii(I1I<K, V> i1i) {
            I1I<K, V> i1i2 = this.f3614ILil;
            if (i1i == i1i2) {
                I1I<K, V> i1i3 = i1i2.f3612Ilil;
                this.f3614ILil = i1i3;
                this.f3613I1I = i1i3 == null;
            }
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (this.f3613I1I) {
                this.f3613I1I = false;
                this.f3614ILil = ILil.this.f3608ILil;
            } else {
                I1I<K, V> i1i = this.f3614ILil;
                this.f3614ILil = i1i != null ? i1i.f1200IL : null;
            }
            return this.f3614ILil;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f3613I1I) {
                return ILil.this.f3608ILil != null;
            }
            I1I<K, V> i1i = this.f3614ILil;
            return (i1i == null || i1i.f1200IL == null) ? false : true;
        }
    }

    /* JADX INFO: renamed from: ILil.I1I.IL1Iii.ILil.ILil$iI丨LLL1, reason: invalid class name */
    /* JADX INFO: compiled from: SafeIterableMap.java */
    public interface iILLL1<K, V> {
        void IL1Iii(I1I<K, V> i1i);
    }

    /* JADX INFO: renamed from: ILil.I1I.IL1Iii.ILil.ILil$l丨Li1LL, reason: invalid class name */
    /* JADX INFO: compiled from: SafeIterableMap.java */
    public static abstract class lLi1LL<K, V> implements Iterator<Map.Entry<K, V>>, iILLL1<K, V> {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public I1I<K, V> f3615I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public I1I<K, V> f3616ILil;

        public lLi1LL(I1I<K, V> i1i, I1I<K, V> i1i2) {
            this.f3616ILil = i1i2;
            this.f3615I1I = i1i;
        }

        public abstract I1I<K, V> I1I(I1I<K, V> i1i);

        @Override // ILil.I1I.IL1Iii.ILil.ILil.iILLL1
        public void IL1Iii(I1I<K, V> i1i) {
            if (this.f3616ILil == i1i && i1i == this.f3615I1I) {
                this.f3615I1I = null;
                this.f3616ILil = null;
            }
            I1I<K, V> i1i2 = this.f3616ILil;
            if (i1i2 == i1i) {
                this.f3616ILil = ILil(i1i2);
            }
            if (this.f3615I1I == i1i) {
                this.f3615I1I = Ilil();
            }
        }

        public abstract I1I<K, V> ILil(I1I<K, V> i1i);

        public final I1I<K, V> Ilil() {
            I1I<K, V> i1i = this.f3615I1I;
            I1I<K, V> i1i2 = this.f3616ILil;
            if (i1i == i1i2 || i1i2 == null) {
                return null;
            }
            return I1I(i1i);
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            I1I<K, V> i1i = this.f3615I1I;
            this.f3615I1I = Ilil();
            return i1i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3615I1I != null;
        }
    }

    public I1I<K, V> I1I(K k) {
        I1I<K, V> i1i = this.f3608ILil;
        while (i1i != null && !i1i.f3611ILil.equals(k)) {
            i1i = i1i.f1200IL;
        }
        return i1i;
    }

    public Iterator<Map.Entry<K, V>> IL1Iii() {
        C0548ILil c0548ILil = new C0548ILil(this.f3607I1I, this.f3608ILil);
        this.f1199IL.put(c0548ILil, Boolean.FALSE);
        return c0548ILil;
    }

    public Map.Entry<K, V> ILil() {
        return this.f3608ILil;
    }

    public Map.Entry<K, V> Ilil() {
        return this.f3607I1I;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public ILil<K, V>.IL m1441IL() {
        ILil<K, V>.IL il = new IL();
        this.f1199IL.put(il, Boolean.FALSE);
        return il;
    }

    /* JADX INFO: renamed from: I丨iL */
    public V mo1438IiL(K k) {
        I1I<K, V> I1I2 = I1I(k);
        if (I1I2 == null) {
            return null;
        }
        this.f3609Ilil--;
        if (!this.f1199IL.isEmpty()) {
            Iterator<iILLL1<K, V>> it = this.f1199IL.keySet().iterator();
            while (it.hasNext()) {
                it.next().IL1Iii(I1I2);
            }
        }
        I1I<K, V> i1i = I1I2.f3612Ilil;
        if (i1i != null) {
            i1i.f1200IL = I1I2.f1200IL;
        } else {
            this.f3608ILil = I1I2.f1200IL;
        }
        I1I<K, V> i1i2 = I1I2.f1200IL;
        if (i1i2 != null) {
            i1i2.f3612Ilil = i1i;
        } else {
            this.f3607I1I = i1i;
        }
        I1I2.f1200IL = null;
        I1I2.f3612Ilil = null;
        return I1I2.f3610I1I;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ILil)) {
            return false;
        }
        ILil iLil = (ILil) obj;
        if (size() != iLil.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = iLil.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += it.next().hashCode();
        }
        return iHashCode;
    }

    /* JADX INFO: renamed from: iI丨LLL1 */
    public V mo1440iILLL1(K k, V v) {
        I1I<K, V> I1I2 = I1I(k);
        if (I1I2 != null) {
            return I1I2.f3610I1I;
        }
        m1442lLi1LL(k, v);
        return null;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        IL1Iii iL1Iii = new IL1Iii(this.f3608ILil, this.f3607I1I);
        this.f1199IL.put(iL1Iii, Boolean.FALSE);
        return iL1Iii;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public I1I<K, V> m1442lLi1LL(K k, V v) {
        I1I<K, V> i1i = new I1I<>(k, v);
        this.f3609Ilil++;
        I1I<K, V> i1i2 = this.f3607I1I;
        if (i1i2 == null) {
            this.f3608ILil = i1i;
            this.f3607I1I = i1i;
            return i1i;
        }
        i1i2.f1200IL = i1i;
        i1i.f3612Ilil = i1i2;
        this.f3607I1I = i1i;
        return i1i;
    }

    public int size() {
        return this.f3609Ilil;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
