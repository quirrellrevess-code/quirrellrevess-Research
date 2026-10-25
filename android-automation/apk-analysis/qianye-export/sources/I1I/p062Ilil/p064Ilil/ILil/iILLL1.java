package I1I.p062Ilil.p064Ilil.ILil;

import android.os.Bundle;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: I1I.Ilil.Ilil.ILil.iI丨LLL1, reason: invalid class name */
/* JADX INFO: compiled from: UiObjectCollection.java */
/* JADX INFO: loaded from: classes.dex */
public class iILLL1 {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final iILLL1 f3546ILil = m1371IL(Collections.emptyList());

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public List<lLi1LL> f3547IL1Iii;

    public iILLL1(List<lLi1LL> list) {
        this.f3547IL1Iii = list;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static iILLL1 m1371IL(List<lLi1LL> list) {
        return new iILLL1(list);
    }

    public lLi1LL I1I(int i) {
        return this.f3547IL1Iii.get(i);
    }

    public final Bundle IL1Iii(ILil[] iLilArr) {
        Bundle bundle = new Bundle();
        for (ILil iLil : iLilArr) {
            iLil.IL1Iii(bundle);
        }
        return bundle;
    }

    public boolean ILil() {
        return m1373lLi1LL() == 0;
    }

    public boolean Ilil(int i, ILil... iLilArr) {
        Bundle bundleIL1Iii = IL1Iii(iLilArr);
        Iterator<lLi1LL> it = this.f3547IL1Iii.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (!it.next().m41i1(i, bundleIL1Iii)) {
                z = true;
            }
        }
        return !z;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public lLi1LL[] m1372iILLL1() {
        List<lLi1LL> list = this.f3547IL1Iii;
        return (lLi1LL[]) list.toArray(new lLi1LL[list.size()]);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int m1373lLi1LL() {
        return this.f3547IL1Iii.size();
    }
}
