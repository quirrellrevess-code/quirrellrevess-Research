package ILil.p044llL1ii;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* JADX INFO: renamed from: ILil.ll丨L1ii.L11丨, reason: invalid class name */
/* JADX INFO: compiled from: ViewUtilsApi23.java */
/* JADX INFO: loaded from: classes.dex */
public class L11 extends C0585 {
    public static boolean ILL = true;

    @Override // ILil.p044llL1ii.IIiI
    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: I丨iL */
    public void mo2548IiL(View view, int i) {
        if (Build.VERSION.SDK_INT == 28) {
            super.mo2548IiL(view, i);
        } else if (ILL) {
            try {
                view.setTransitionVisibility(i);
            } catch (NoSuchMethodError unused) {
                ILL = false;
            }
        }
    }
}
