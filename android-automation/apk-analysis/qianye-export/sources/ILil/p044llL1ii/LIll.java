package ILil.p044llL1ii;

import android.annotation.SuppressLint;
import android.view.View;

/* JADX INFO: renamed from: ILil.ll丨L1ii.LI丨丨l丨l, reason: invalid class name */
/* JADX INFO: compiled from: ViewUtilsApi19.java */
/* JADX INFO: loaded from: classes.dex */
public class LIll extends IIiI {

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static boolean f1852lLi1LL = true;

    @Override // ILil.p044llL1ii.IIiI
    @SuppressLint({"NewApi"})
    public float I1I(View view) {
        if (f1852lLi1LL) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f1852lLi1LL = false;
            }
        }
        return view.getAlpha();
    }

    @Override // ILil.p044llL1ii.IIiI
    public void IL1Iii(View view) {
    }

    @Override // ILil.p044llL1ii.IIiI
    /* JADX INFO: renamed from: I丨L */
    public void mo2547IL(View view) {
    }

    @Override // ILil.p044llL1ii.IIiI
    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: iI丨LLL1 */
    public void mo2550iILLL1(View view, float f) {
        if (f1852lLi1LL) {
            try {
                view.setTransitionAlpha(f);
                return;
            } catch (NoSuchMethodError unused) {
                f1852lLi1LL = false;
            }
        }
        view.setAlpha(f);
    }
}
