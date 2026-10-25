package ILil.p044llL1ii;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: GhostViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class ILL {
    public static iILLL1 IL1Iii(View view, ViewGroup viewGroup, Matrix matrix) {
        return Build.VERSION.SDK_INT == 28 ? L11I.ILil(view, viewGroup, matrix) : C0647il.ILil(view, viewGroup, matrix);
    }

    public static void ILil(View view) {
        if (Build.VERSION.SDK_INT == 28) {
            L11I.m2565lLi1LL(view);
        } else {
            C0647il.m2580lLi1LL(view);
        }
    }
}
