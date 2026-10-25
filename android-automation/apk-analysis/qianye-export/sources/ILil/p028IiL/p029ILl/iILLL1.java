package ILil.p028IiL.p029ILl;

import android.os.Build;
import android.view.ViewGroup;

/* JADX INFO: renamed from: ILil.I丨iL.IL丨丨l.iI丨LLL1, reason: invalid class name */
/* JADX INFO: compiled from: MarginLayoutParamsCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class iILLL1 {
    public static void I1I(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            marginLayoutParams.setMarginEnd(i);
        } else {
            marginLayoutParams.rightMargin = i;
        }
    }

    public static int IL1Iii(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return Build.VERSION.SDK_INT >= 17 ? marginLayoutParams.getMarginEnd() : marginLayoutParams.rightMargin;
    }

    public static int ILil(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return Build.VERSION.SDK_INT >= 17 ? marginLayoutParams.getMarginStart() : marginLayoutParams.leftMargin;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static void m2151IL(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            marginLayoutParams.setMarginStart(i);
        } else {
            marginLayoutParams.leftMargin = i;
        }
    }
}
