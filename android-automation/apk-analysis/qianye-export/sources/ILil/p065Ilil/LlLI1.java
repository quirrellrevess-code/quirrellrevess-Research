package ILil.p065Ilil;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: LruCache.java */
/* JADX INFO: loaded from: classes.dex */
public class LlLI1<K, V> {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f3964I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final LinkedHashMap<K, V> f3965IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f3966ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public int f3967Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f1560IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public int f1561IiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int f1562iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int f1563lLi1LL;

    public LlLI1(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f3964I1I = i;
        this.f3965IL1Iii = new LinkedHashMap<>(0, 0.75f, true);
    }

    public final V I1I(K k) {
        V vPut;
        Objects.requireNonNull(k, "key == null");
        synchronized (this) {
            V v = this.f3965IL1Iii.get(k);
            if (v != null) {
                this.f1562iILLL1++;
                return v;
            }
            this.f1561IiL++;
            V vIL1Iii = IL1Iii(k);
            if (vIL1Iii == null) {
                return null;
            }
            synchronized (this) {
                this.f3967Ilil++;
                vPut = this.f3965IL1Iii.put(k, vIL1Iii);
                if (vPut != null) {
                    this.f3965IL1Iii.put(k, vPut);
                } else {
                    this.f3966ILil += Ilil(k, vIL1Iii);
                }
            }
            if (vPut != null) {
                ILil(false, k, vIL1Iii, vPut);
                return vPut;
            }
            m1950iILLL1(this.f3964I1I);
            return vIL1Iii;
        }
    }

    public V IL1Iii(K k) {
        return null;
    }

    public void ILil(boolean z, K k, V v, V v2) {
    }

    public final int Ilil(K k, V v) {
        int iM1951lLi1LL = m1951lLi1LL(k, v);
        if (iM1951lLi1LL >= 0) {
            return iM1951lLi1LL;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final V m1949IL(K k, V v) {
        V vPut;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f1560IL++;
            this.f3966ILil += Ilil(k, v);
            vPut = this.f3965IL1Iii.put(k, v);
            if (vPut != null) {
                this.f3966ILil -= Ilil(k, vPut);
            }
        }
        if (vPut != null) {
            ILil(false, k, vPut, v);
        }
        m1950iILLL1(this.f3964I1I);
        return vPut;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m1950iILLL1(int i) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.f3966ILil < 0 || (this.f3965IL1Iii.isEmpty() && this.f3966ILil != 0)) {
                    break;
                }
                if (this.f3966ILil > i && !this.f3965IL1Iii.isEmpty()) {
                    Map.Entry<K, V> next = this.f3965IL1Iii.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.f3965IL1Iii.remove(key);
                    this.f3966ILil -= Ilil(key, value);
                    this.f1563lLi1LL++;
                }
                return;
            }
            ILil(true, key, value, null);
        }
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int m1951lLi1LL(K k, V v) {
        return 1;
    }

    public final synchronized String toString() {
        int i;
        int i2;
        i = this.f1562iILLL1;
        i2 = this.f1561IiL + i;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f3964I1I), Integer.valueOf(this.f1562iILLL1), Integer.valueOf(this.f1561IiL), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }
}
