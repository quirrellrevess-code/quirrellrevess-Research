package androidx.core.graphics.drawable;

import ILil.iIi1.IL1Iii;
import android.content.res.ColorStateList;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(IL1Iii iL1Iii) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f4975IL1Iii = iL1Iii.LlLI1(iconCompat.f4975IL1Iii, 1);
        iconCompat.f4974I1I = iL1Iii.m2473il(iconCompat.f4974I1I, 2);
        iconCompat.f2561IL = iL1Iii.m2469lIlii(iconCompat.f2561IL, 3);
        iconCompat.f4977Ilil = iL1Iii.LlLI1(iconCompat.f4977Ilil, 4);
        iconCompat.f2565lLi1LL = iL1Iii.LlLI1(iconCompat.f2565lLi1LL, 5);
        iconCompat.f2564iILLL1 = (ColorStateList) iL1Iii.m2469lIlii(iconCompat.f2564iILLL1, 6);
        iconCompat.f2563L11I = iL1Iii.iIlLiL(iconCompat.f2563L11I, 7);
        iconCompat.Ilil();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, IL1Iii iL1Iii) {
        iL1Iii.llliI(true, true);
        iconCompat.m3167lLi1LL(iL1Iii.m2471lLi1LL());
        int i = iconCompat.f4975IL1Iii;
        if (-1 != i) {
            iL1Iii.m81(i, 1);
        }
        byte[] bArr = iconCompat.f4974I1I;
        if (bArr != null) {
            iL1Iii.m2468lIII(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f2561IL;
        if (parcelable != null) {
            iL1Iii.m2466l1IIi1(parcelable, 3);
        }
        int i2 = iconCompat.f4977Ilil;
        if (i2 != 0) {
            iL1Iii.m81(i2, 4);
        }
        int i3 = iconCompat.f2565lLi1LL;
        if (i3 != 0) {
            iL1Iii.m81(i3, 5);
        }
        ColorStateList colorStateList = iconCompat.f2564iILLL1;
        if (colorStateList != null) {
            iL1Iii.m2466l1IIi1(colorStateList, 6);
        }
        String str = iconCompat.f2563L11I;
        if (str != null) {
            iL1Iii.m2472iILLl(str, 7);
        }
    }
}
