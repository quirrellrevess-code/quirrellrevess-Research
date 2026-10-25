package ILil.p044llL1ii;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: renamed from: ILil.ll丨L1ii.il丨l丨, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: ViewUtilsApi21.java */
/* JADX INFO: loaded from: classes.dex */
public class C0645ill extends LIll {

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static boolean f1860IiL = true;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static boolean f1861L11I = true;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static boolean f1862iILLL1 = true;

    @Override // ILil.p044llL1ii.IIiI
    @SuppressLint({"NewApi"})
    public void Ilil(View view, Matrix matrix) {
        if (f1862iILLL1) {
            try {
                view.setAnimationMatrix(matrix);
            } catch (NoSuchMethodError unused) {
                f1862iILLL1 = false;
            }
        }
    }

    @Override // ILil.p044llL1ii.IIiI
    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: L丨1丨1丨I */
    public void mo2549L11I(View view, Matrix matrix) {
        if (f1860IiL) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f1860IiL = false;
            }
        }
    }

    @Override // ILil.p044llL1ii.IIiI
    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: 丨il */
    public void mo2552il(View view, Matrix matrix) {
        if (f1861L11I) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f1861L11I = false;
            }
        }
    }
}
