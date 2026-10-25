package I1I.p062Ilil.p064Ilil.ILil.p011il;

import I1I.IL1Iii;
import I1I.p062Ilil.p064Ilil.ILil.lLi1LL;
import android.graphics.Rect;
import com.google.android.flexbox.BuildConfig;
import java.util.Locale;

/* JADX INFO: compiled from: BoundsFilter.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil extends iILLL1 {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public Rect f3557IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f3558ILil;

    public ILil(Rect rect, int i) {
        this.f3557IL1Iii = rect;
        this.f3558ILil = i;
    }

    @Override // I1I.p062Ilil.p064Ilil.ILil.p011il.iILLL1
    public boolean ILil(lLi1LL lli1ll) {
        if (this.f3558ILil == 2) {
            return I1I.p062Ilil.p064Ilil.IL1Iii.lLi1LL.ILil(lli1ll.m1410iILLl()).contains(this.f3557IL1Iii);
        }
        Rect rectILil = I1I.p062Ilil.p064Ilil.IL1Iii.lLi1LL.ILil(lli1ll.m1410iILLl());
        return this.f3558ILil == 0 ? rectILil.equals(this.f3557IL1Iii) : this.f3557IL1Iii.contains(rectILil);
    }

    public String toString() {
        String strIL1Iii;
        Locale locale = Locale.getDefault();
        String strIL1Iii2 = IL1Iii.IL1Iii(new byte[]{1, 93, 66, 10, 87, 16, 70, 65, 31, 65, 87, 79, 67, 23, 83, 72, 19, 70, 7, 30, 23, 65, 87, 74}, IL1Iii.IL1Iii(new byte[]{81, 4, 14, 82, 10, 2}, IL1Iii.IL1Iii(new byte[]{86, 5, 91, 82, 12, 5}, "d3bd5d")));
        Object[] objArr = new Object[5];
        int i = this.f3558ILil;
        if (i == 0) {
            strIL1Iii = BuildConfig.FLAVOR;
        } else {
            strIL1Iii = i == 1 ? IL1Iii.IL1Iii(new byte[]{113, 93, 74, 92, 87, 84}, IL1Iii.IL1Iii(new byte[]{1, 86, 11, 80, 1, 84}, IL1Iii.IL1Iii(new byte[]{9, 1, 0, 1, 80, 0}, "0d2dbe"))) : IL1Iii.IL1Iii(new byte[]{115, 95, 11, 71, 82, 15, 94, 67}, IL1Iii.IL1Iii(new byte[]{6, 0, 93, 85, 3, 80}, IL1Iii.IL1Iii(new byte[]{82, 82, 0, 80, 81, 14}, "db86a8")));
        }
        objArr[0] = strIL1Iii;
        objArr[1] = Integer.valueOf(this.f3557IL1Iii.left);
        objArr[2] = Integer.valueOf(this.f3557IL1Iii.top);
        objArr[3] = Integer.valueOf(this.f3557IL1Iii.right);
        objArr[4] = Integer.valueOf(this.f3557IL1Iii.bottom);
        return String.format(locale, strIL1Iii2, objArr);
    }
}
