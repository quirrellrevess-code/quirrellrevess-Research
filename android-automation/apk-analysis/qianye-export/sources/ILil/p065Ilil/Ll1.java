package ILil.p065Ilil;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: ILil.Ilil.Ll丨1, reason: invalid class name */
/* JADX INFO: compiled from: ArrayMap.java */
/* JADX INFO: loaded from: classes.dex */
public class Ll1<K, V> extends lIlii<K, V> implements Map<K, V> {

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public llL1ii<K, V> f1564L11I;

    /* JADX INFO: renamed from: ILil.Ilil.Ll丨1$IL1Iii */
    /* JADX INFO: compiled from: ArrayMap.java */
    public class IL1Iii extends llL1ii<K, V> {
        public IL1Iii() {
        }

        @Override // ILil.p065Ilil.llL1ii
        public Map<K, V> I1I() {
            return Ll1.this;
        }

        @Override // ILil.p065Ilil.llL1ii
        public void IL1Iii() {
            Ll1.this.clear();
        }

        @Override // ILil.p065Ilil.llL1ii
        public Object ILil(int i, int i2) {
            return Ll1.this.f3975I1I[(i << 1) + i2];
        }

        @Override // ILil.p065Ilil.llL1ii
        public int Ilil(Object obj) {
            return Ll1.this.m1976lLi1LL(obj);
        }

        @Override // ILil.p065Ilil.llL1ii
        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int mo1953IL() {
            return Ll1.this.f1578IL;
        }

        @Override // ILil.p065Ilil.llL1ii
        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public void mo1954IiL(int i) {
            Ll1.this.ILL(i);
        }

        @Override // ILil.p065Ilil.llL1ii
        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public V mo1955L11I(int i, V v) {
            return Ll1.this.m1972Ll1(i, v);
        }

        @Override // ILil.p065Ilil.llL1ii
        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public void mo1956iILLL1(K k, V v) {
            Ll1.this.put(k, v);
        }

        @Override // ILil.p065Ilil.llL1ii
        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public int mo1957lLi1LL(Object obj) {
            return Ll1.this.m1971IiL(obj);
        }
    }

    public Ll1() {
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final llL1ii<K, V> m1952ILl() {
        if (this.f1564L11I == null) {
            this.f1564L11I = new IL1Iii();
        }
        return this.f1564L11I;
    }

    public boolean Lil(Collection<?> collection) {
        return llL1ii.LlLI1(this, collection);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return m1952ILl().m1980Ll1();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return m1952ILl().m1981lIiI();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        I1I(this.f1578IL + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return m1952ILl().m1979ILl();
    }

    public Ll1(int i) {
        super(i);
    }

    public Ll1(lIlii lilii) {
        super(lilii);
    }
}
