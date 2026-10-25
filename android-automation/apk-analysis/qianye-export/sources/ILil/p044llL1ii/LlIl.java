package ILil.p044llL1ii;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: renamed from: ILil.ll丨L1ii.LlIl丨, reason: invalid class name */
/* JADX INFO: compiled from: ViewUtilsApi29.java */
/* JADX INFO: loaded from: classes.dex */
public class LlIl extends L11 {
    @Override // ILil.p044llL1ii.LIll, ILil.p044llL1ii.IIiI
    public float I1I(View view) {
        return view.getTransitionAlpha();
    }

    @Override // ILil.p044llL1ii.C0645ill, ILil.p044llL1ii.IIiI
    public void Ilil(View view, Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }

    @Override // ILil.p044llL1ii.L11, ILil.p044llL1ii.IIiI
    /* JADX INFO: renamed from: I丨iL */
    public void mo2548IiL(View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // ILil.p044llL1ii.C0645ill, ILil.p044llL1ii.IIiI
    /* JADX INFO: renamed from: L丨1丨1丨I */
    public void mo2549L11I(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // ILil.p044llL1ii.LIll, ILil.p044llL1ii.IIiI
    /* JADX INFO: renamed from: iI丨LLL1 */
    public void mo2550iILLL1(View view, float f) {
        view.setTransitionAlpha(f);
    }

    @Override // ILil.p044llL1ii.C0585, ILil.p044llL1ii.IIiI
    /* JADX INFO: renamed from: l丨Li1LL */
    public void mo2551lLi1LL(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    @Override // ILil.p044llL1ii.C0645ill, ILil.p044llL1ii.IIiI
    /* JADX INFO: renamed from: 丨il */
    public void mo2552il(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
