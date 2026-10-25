package ILil.ILil.p023lIlii;

import android.os.Build;
import android.view.View;

/* JADX INFO: renamed from: ILil.ILil.lI丨lii.L丨1l, reason: invalid class name */
/* JADX INFO: compiled from: TooltipCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class L1l {
    public static void IL1Iii(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        } else {
            iILLl.m1839lLi1LL(view, charSequence);
        }
    }
}
