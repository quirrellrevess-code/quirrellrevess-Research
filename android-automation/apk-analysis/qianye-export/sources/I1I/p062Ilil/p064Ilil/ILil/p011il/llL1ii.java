package I1I.p062Ilil.p064Ilil.ILil.p011il;

import I1I.IL1Iii;
import I1I.p062Ilil.p064Ilil.ILil.lLi1LL;
import com.google.android.flexbox.BuildConfig;

/* JADX INFO: renamed from: I1I.Ilil.Ilil.ILil.丨il.ll丨L1ii, reason: invalid class name */
/* JADX INFO: compiled from: StringStartsWithFilter.java */
/* JADX INFO: loaded from: classes.dex */
public class llL1ii extends iILLL1 {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final String f3573IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final InterfaceC0617il f3574ILil;

    public llL1ii(String str, InterfaceC0617il interfaceC0617il) {
        this.f3573IL1Iii = str;
        this.f3574ILil = interfaceC0617il;
    }

    @Override // I1I.p062Ilil.p064Ilil.ILil.p011il.iILLL1
    public boolean ILil(lLi1LL lli1ll) {
        String strIL1Iii = this.f3574ILil.IL1Iii(lli1ll);
        if (strIL1Iii == null) {
            strIL1Iii = BuildConfig.FLAVOR;
        }
        return strIL1Iii != null && strIL1Iii.startsWith(this.f3573IL1Iii);
    }

    public String toString() {
        return this.f3574ILil.toString() + IL1Iii.IL1Iii(new byte[]{55, 77, 81, 71, 69, 66, 51, 80, 68, 93, 25, 19}, IL1Iii.IL1Iii(new byte[]{84, 8, 6, 84, 0, 83}, IL1Iii.IL1Iii(new byte[]{86, 2, 2, 4, 4, 86}, "f34e54"))) + this.f3573IL1Iii + IL1Iii.IL1Iii(new byte[]{70, 24}, IL1Iii.IL1Iii(new byte[]{80, 3, 80, 7, 9, 2}, IL1Iii.IL1Iii(new byte[]{81, 80, 80, 5, 1, 4}, "eba103")));
    }
}
