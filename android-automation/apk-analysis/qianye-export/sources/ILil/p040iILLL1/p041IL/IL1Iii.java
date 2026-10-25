package ILil.p040iILLL1.p041IL;

import ILil.p028IiL.p034lIiI.iILLL1;
import ILil.p028IiL.p034lIiI.lLi1LL;
import ILil.p065Ilil.lIlii;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: DirectedAcyclicGraph.java */
/* JADX INFO: loaded from: classes.dex */
public final class IL1Iii<T> {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final lLi1LL<ArrayList<T>> f4331IL1Iii = new iILLL1(10);

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final lIlii<T, ArrayList<T>> f4332ILil = new lIlii<>();

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final ArrayList<T> f4330I1I = new ArrayList<>();

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final HashSet<T> f1792IL = new HashSet<>();

    public void I1I() {
        int size = this.f4332ILil.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> arrayListM1975lIiI = this.f4332ILil.m1975lIiI(i);
            if (arrayListM1975lIiI != null) {
                ILL(arrayListM1975lIiI);
            }
        }
        this.f4332ILil.clear();
    }

    public void IL1Iii(T t, T t2) {
        if (!this.f4332ILil.containsKey(t) || !this.f4332ILil.containsKey(t2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayListM2492lLi1LL = this.f4332ILil.get(t);
        if (arrayListM2492lLi1LL == null) {
            arrayListM2492lLi1LL = m2492lLi1LL();
            this.f4332ILil.put(t, arrayListM2492lLi1LL);
        }
        arrayListM2492lLi1LL.add(t2);
    }

    public final void ILL(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f4331IL1Iii.IL1Iii(arrayList);
    }

    public void ILil(T t) {
        if (this.f4332ILil.containsKey(t)) {
            return;
        }
        this.f4332ILil.put(t, null);
    }

    public final void Ilil(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t)) {
            return;
        }
        if (hashSet.contains(t)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t);
        ArrayList<T> arrayList2 = this.f4332ILil.get(t);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                Ilil(arrayList2.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(t);
        arrayList.add(t);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean m2488IL(T t) {
        return this.f4332ILil.containsKey(t);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public List<T> m2489IiL(T t) {
        int size = this.f4332ILil.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ArrayList<T> arrayListM1975lIiI = this.f4332ILil.m1975lIiI(i);
            if (arrayListM1975lIiI != null && arrayListM1975lIiI.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f4332ILil.m1973L11I(i));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public ArrayList<T> m2490L11I() {
        this.f4330I1I.clear();
        this.f1792IL.clear();
        int size = this.f4332ILil.size();
        for (int i = 0; i < size; i++) {
            Ilil(this.f4332ILil.m1973L11I(i), this.f4330I1I, this.f1792IL);
        }
        return this.f4330I1I;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public List m2491iILLL1(T t) {
        return this.f4332ILil.get(t);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final ArrayList<T> m2492lLi1LL() {
        ArrayList<T> arrayListILil = this.f4331IL1Iii.ILil();
        return arrayListILil == null ? new ArrayList<>() : arrayListILil;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public boolean m2493il(T t) {
        int size = this.f4332ILil.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> arrayListM1975lIiI = this.f4332ILil.m1975lIiI(i);
            if (arrayListM1975lIiI != null && arrayListM1975lIiI.contains(t)) {
                return true;
            }
        }
        return false;
    }
}
