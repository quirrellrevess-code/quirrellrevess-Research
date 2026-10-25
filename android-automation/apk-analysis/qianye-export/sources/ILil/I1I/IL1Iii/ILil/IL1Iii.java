package ILil.I1I.IL1Iii.ILil;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: FastSafeIterableMap.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii<K, V> extends ILil<K, V> {

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public HashMap<K, ILil.I1I<K, V>> f1198lLi1LL = new HashMap<>();

    @Override // ILil.I1I.IL1Iii.ILil.ILil
    public ILil.I1I<K, V> I1I(K k) {
        return this.f1198lLi1LL.get(k);
    }

    @Override // ILil.I1I.IL1Iii.ILil.ILil
    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public V mo1438IiL(K k) {
        V v = (V) super.mo1438IiL(k);
        this.f1198lLi1LL.remove(k);
        return v;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public Map.Entry<K, V> m1439L11I(K k) {
        if (contains(k)) {
            return this.f1198lLi1LL.get(k).f3612Ilil;
        }
        return null;
    }

    public boolean contains(K k) {
        return this.f1198lLi1LL.containsKey(k);
    }

    @Override // ILil.I1I.IL1Iii.ILil.ILil
    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public V mo1440iILLL1(K k, V v) {
        ILil.I1I<K, V> I1I2 = I1I(k);
        if (I1I2 != null) {
            return I1I2.f3610I1I;
        }
        this.f1198lLi1LL.put(k, m1442lLi1LL(k, v));
        return null;
    }
}
