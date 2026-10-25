package I1I.p062Ilil.p064Ilil.ILil.p011il;

import I1I.IL1Iii;
import I1I.p062Ilil.p064Ilil.ILil.lLi1LL;
import com.google.android.flexbox.BuildConfig;

/* JADX INFO: renamed from: I1I.Ilil.Ilil.ILil.丨il.IL丨丨l, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: StringEndsWithFilter.java */
/* JADX INFO: loaded from: classes.dex */
public class C0616ILl extends iILLL1 {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final String f3559IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final InterfaceC0617il f3560ILil;

    public C0616ILl(String str, InterfaceC0617il interfaceC0617il) {
        this.f3559IL1Iii = str;
        this.f3560ILil = interfaceC0617il;
    }

    @Override // I1I.p062Ilil.p064Ilil.ILil.p011il.iILLL1
    public boolean ILil(lLi1LL lli1ll) {
        String strIL1Iii = this.f3560ILil.IL1Iii(lli1ll);
        if (strIL1Iii == null) {
            strIL1Iii = BuildConfig.FLAVOR;
        }
        return strIL1Iii != null && strIL1Iii.endsWith(this.f3559IL1Iii);
    }

    public String toString() {
        return this.f3560ILil.toString() + IL1Iii.IL1Iii(new byte[]{114, 91, 6, 18, 110, 10, 67, 93, 74, 67}, IL1Iii.IL1Iii(new byte[]{15, 83, 80, 7, 15, 82}, IL1Iii.IL1Iii(new byte[]{13, 82, 7, 2, 83, 83}, "545deb"))) + this.f3559IL1Iii + IL1Iii.IL1Iii(new byte[]{71, 29}, IL1Iii.IL1Iii(new byte[]{4, 85, 87, 1, 9, 85}, IL1Iii.IL1Iii(new byte[]{85, 85, 5, 84, 7, 6}, "44d175")));
    }
}
