package I1I.p062Ilil.p064Ilil.ILil.p011il;

import I1I.IL1Iii;
import I1I.p062Ilil.p064Ilil.ILil.lLi1LL;
import com.google.android.flexbox.BuildConfig;

/* JADX INFO: compiled from: StringMatchesFilter.java */
/* JADX INFO: loaded from: classes.dex */
public class LlLI1 extends iILLL1 {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final String f3564IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final InterfaceC0617il f3565ILil;

    public LlLI1(String str, InterfaceC0617il interfaceC0617il) {
        this.f3564IL1Iii = str;
        this.f3565ILil = interfaceC0617il;
    }

    @Override // I1I.p062Ilil.p064Ilil.ILil.p011il.iILLL1
    public boolean ILil(lLi1LL lli1ll) {
        String strIL1Iii = this.f3565ILil.IL1Iii(lli1ll);
        if (strIL1Iii == null) {
            strIL1Iii = BuildConfig.FLAVOR;
        }
        return strIL1Iii != null && strIL1Iii.matches(this.f3564IL1Iii);
    }

    public String toString() {
        return this.f3565ILil.toString() + IL1Iii.IL1Iii(new byte[]{44, 80, 70, 84, 88, 4, 18, 25, 16}, IL1Iii.IL1Iii(new byte[]{85, 82, 11, 82, 2, 4}, IL1Iii.IL1Iii(new byte[]{13, 90, 14, 84, 5, 1}, "99717d"))) + this.f3564IL1Iii + IL1Iii.IL1Iii(new byte[]{16, 16}, IL1Iii.IL1Iii(new byte[]{5, 14, 1, 2, 10, 82}, IL1Iii.IL1Iii(new byte[]{5, 5, 3, 82, 5, 84}, "226a7b")));
    }
}
