package ILil.p044llL1ii;

import android.graphics.Rect;
import android.view.ViewGroup;
import androidx.transition.Transition;

/* JADX INFO: compiled from: CircularPropagation.java */
/* JADX INFO: loaded from: classes.dex */
public class I1I extends lliiI1 {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public float f4404ILil = 3.0f;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static float m2546IiL(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return (float) Math.sqrt((f5 * f5) + (f6 * f6));
    }

    @Override // ILil.p044llL1ii.llliI
    public long I1I(ViewGroup viewGroup, Transition transition, C1 c1, C1 c2) {
        int i;
        int iRound;
        int iCenterX;
        if (c1 == null && c2 == null) {
            return 0L;
        }
        if (c2 == null || Ilil(c1) == 0) {
            i = -1;
        } else {
            c1 = c2;
            i = 1;
        }
        int iM2577lLi1LL = m2577lLi1LL(c1);
        int iM2576iILLL1 = m2576iILLL1(c1);
        Rect epicenter = transition.getEpicenter();
        if (epicenter != null) {
            iCenterX = epicenter.centerX();
            iRound = epicenter.centerY();
        } else {
            int[] iArr = new int[2];
            viewGroup.getLocationOnScreen(iArr);
            int iRound2 = Math.round(iArr[0] + (viewGroup.getWidth() / 2) + viewGroup.getTranslationX());
            iRound = Math.round(iArr[1] + (viewGroup.getHeight() / 2) + viewGroup.getTranslationY());
            iCenterX = iRound2;
        }
        float fM2546IiL = m2546IiL(iM2577lLi1LL, iM2576iILLL1, iCenterX, iRound) / m2546IiL(0.0f, 0.0f, viewGroup.getWidth(), viewGroup.getHeight());
        long duration = transition.getDuration();
        if (duration < 0) {
            duration = 300;
        }
        return Math.round(((duration * ((long) i)) / this.f4404ILil) * fM2546IiL);
    }
}
