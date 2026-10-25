package I1I.p062Ilil.p064Ilil.ILil.p011il;

import I1I.IL1Iii;
import I1I.p062Ilil.p064Ilil.ILil.lLi1LL;
import com.google.android.flexbox.BuildConfig;

/* JADX INFO: compiled from: StringEqualsFilter.java */
/* JADX INFO: loaded from: classes.dex */
public class Lil extends iILLL1 {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public String f3562IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public InterfaceC0617il f3563ILil;

    public Lil(String str, InterfaceC0617il interfaceC0617il) {
        this.f3562IL1Iii = str;
        this.f3563ILil = interfaceC0617il;
    }

    @Override // I1I.p062Ilil.p064Ilil.ILil.p011il.iILLL1
    public boolean ILil(lLi1LL lli1ll) {
        String strIL1Iii = this.f3563ILil.IL1Iii(lli1ll);
        if (strIL1Iii == null) {
            strIL1Iii = BuildConfig.FLAVOR;
        }
        if (strIL1Iii != null) {
            return strIL1Iii.equals(this.f3562IL1Iii);
        }
        return false;
    }

    public String toString() {
        return this.f3563ILil.toString() + IL1Iii.IL1Iii(new byte[]{30, 71}, IL1Iii.IL1Iii(new byte[]{14, 84, 87, 85, 7, 9}, IL1Iii.IL1Iii(new byte[]{9, 8, 85, 80, 83, 86}, "194cef"))) + this.f3562IL1Iii + IL1Iii.IL1Iii(new byte[]{64, 77}, IL1Iii.IL1Iii(new byte[]{90, 84, 92, 82, 86, 90}, IL1Iii.IL1Iii(new byte[]{9, 81, 9, 80, 2, 6}, "1a0f0d")));
    }
}
