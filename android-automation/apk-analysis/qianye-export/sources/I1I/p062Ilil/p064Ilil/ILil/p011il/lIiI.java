package I1I.p062Ilil.p064Ilil.ILil.p011il;

import I1I.IL1Iii;
import I1I.p062Ilil.p064Ilil.ILil.lLi1LL;
import com.google.android.flexbox.BuildConfig;

/* JADX INFO: renamed from: I1I.Ilil.Ilil.ILil.丨il.lIi丨I, reason: invalid class name */
/* JADX INFO: compiled from: StringContainsFilter.java */
/* JADX INFO: loaded from: classes.dex */
public class lIiI extends iILLL1 {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final InterfaceC0617il f3570IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final String f3571ILil;

    public lIiI(String str, InterfaceC0617il interfaceC0617il) {
        this.f3571ILil = str;
        this.f3570IL1Iii = interfaceC0617il;
    }

    @Override // I1I.p062Ilil.p064Ilil.ILil.p011il.iILLL1
    public boolean ILil(lLi1LL lli1ll) {
        String strIL1Iii = this.f3570IL1Iii.IL1Iii(lli1ll);
        if (strIL1Iii == null) {
            strIL1Iii = BuildConfig.FLAVOR;
        }
        return strIL1Iii != null && strIL1Iii.contains(this.f3571ILil);
    }

    public String toString() {
        return this.f3570IL1Iii.toString() + IL1Iii.IL1Iii(new byte[]{112, 12, 10, 66, 4, 95, 93, 16, 76, 20}, IL1Iii.IL1Iii(new byte[]{85, 83, 6, 5, 3, 83}, IL1Iii.IL1Iii(new byte[]{2, 2, 0, 82, 86, 85}, "d2ba00"))) + this.f3571ILil + IL1Iii.IL1Iii(new byte[]{18, 28}, IL1Iii.IL1Iii(new byte[]{2, 3, 87, 0, 0, 12}, IL1Iii.IL1Iii(new byte[]{0, 0, 3, 15, 86, 12}, "26b949")));
    }
}
