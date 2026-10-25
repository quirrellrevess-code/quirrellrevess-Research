package ILil.p044llL1ii;

import android.annotation.SuppressLint;
import android.view.View;

/* JADX INFO: renamed from: ILil.ll丨L1ii.丨丨丨丨, reason: contains not printable characters */
/* JADX INFO: compiled from: ViewUtilsApi22.java */
/* JADX INFO: loaded from: classes.dex */
public class C0585 extends C0645ill {

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static boolean f1877il = true;

    @Override // ILil.p044llL1ii.IIiI
    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: l丨Li1LL */
    public void mo2551lLi1LL(View view, int i, int i2, int i3, int i4) {
        if (f1877il) {
            try {
                view.setLeftTopRightBottom(i, i2, i3, i4);
            } catch (NoSuchMethodError unused) {
                f1877il = false;
            }
        }
    }
}
