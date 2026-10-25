package ILil.ILL.IL1Iii;

import ILil.p042lIiI.lIlii;
import ILil.p042lIiI.llL1ii;
import android.util.Log;
import androidx.fragment.app.Fragment;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: renamed from: ILil.ILL.IL1Iii.丨il, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: FragmentManagerViewModel.java */
/* JADX INFO: loaded from: classes.dex */
public class C0621il extends ILil.p042lIiI.LlLI1 {

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static final llL1ii.IL1Iii f1269IiL = new IL1Iii();

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final boolean f3698Ilil;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final HashSet<Fragment> f3697ILil = new HashSet<>();

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final HashMap<String, C0621il> f3696I1I = new HashMap<>();

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final HashMap<String, lIlii> f1270IL = new HashMap<>();

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean f1272lLi1LL = false;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public boolean f1271iILLL1 = false;

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.丨il$IL1Iii */
    /* JADX INFO: compiled from: FragmentManagerViewModel.java */
    public static class IL1Iii implements llL1ii.IL1Iii {
        @Override // ILil.p042lIiI.llL1ii.IL1Iii
        public <T extends ILil.p042lIiI.LlLI1> T IL1Iii(Class<T> cls) {
            return new C0621il(true);
        }
    }

    public C0621il(boolean z) {
        this.f3698Ilil = z;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static C0621il m1599iILLL1(lIlii lilii) {
        return (C0621il) new llL1ii(lilii, f1269IiL).IL1Iii(C0621il.class);
    }

    @Override // ILil.p042lIiI.LlLI1
    public void I1I() {
        if (L11I.f1239L1l) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f1272lLi1LL = true;
    }

    public boolean ILL(Fragment fragment) {
        return this.f3697ILil.remove(fragment);
    }

    public void Ilil(Fragment fragment) {
        if (L11I.f1239L1l) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        C0621il c0621il = this.f3696I1I.get(fragment.mWho);
        if (c0621il != null) {
            c0621il.I1I();
            this.f3696I1I.remove(fragment.mWho);
        }
        lIlii lilii = this.f1270IL.get(fragment.mWho);
        if (lilii != null) {
            lilii.IL1Iii();
            this.f1270IL.remove(fragment.mWho);
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean m1600IL(Fragment fragment) {
        return this.f3697ILil.add(fragment);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public Collection<Fragment> m1601IiL() {
        return this.f3697ILil;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public boolean m1602Ll1(Fragment fragment) {
        if (this.f3697ILil.contains(fragment)) {
            return this.f3698Ilil ? this.f1272lLi1LL : !this.f1271iILLL1;
        }
        return true;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public lIlii m1603L11I(Fragment fragment) {
        lIlii lilii = this.f1270IL.get(fragment.mWho);
        if (lilii != null) {
            return lilii;
        }
        lIlii lilii2 = new lIlii();
        this.f1270IL.put(fragment.mWho, lilii2);
        return lilii2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0621il c0621il = (C0621il) obj;
        return this.f3697ILil.equals(c0621il.f3697ILil) && this.f3696I1I.equals(c0621il.f3696I1I) && this.f1270IL.equals(c0621il.f1270IL);
    }

    public int hashCode() {
        return (((this.f3697ILil.hashCode() * 31) + this.f3696I1I.hashCode()) * 31) + this.f1270IL.hashCode();
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public C0621il m1604lLi1LL(Fragment fragment) {
        C0621il c0621il = this.f3696I1I.get(fragment.mWho);
        if (c0621il != null) {
            return c0621il;
        }
        C0621il c0621il2 = new C0621il(this.f3698Ilil);
        this.f3696I1I.put(fragment.mWho, c0621il2);
        return c0621il2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f3697ILil.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f3696I1I.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f1270IL.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public boolean m1605il() {
        return this.f1272lLi1LL;
    }
}
