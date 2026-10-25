package ILil.p044llL1ii;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;

/* JADX INFO: compiled from: SidePropagation.java */
/* JADX INFO: loaded from: classes.dex */
public class iIlLiL extends lliiI1 {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public float f4438ILil = 3.0f;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f4437I1I = 80;

    @Override // ILil.p044llL1ii.llliI
    public long I1I(ViewGroup viewGroup, Transition transition, C1 c1, C1 c2) {
        int i;
        int iCenterX;
        int iCenterY;
        C1 c3 = c1;
        if (c3 == null && c2 == null) {
            return 0L;
        }
        Rect epicenter = transition.getEpicenter();
        if (c2 == null || Ilil(c3) == 0) {
            i = -1;
        } else {
            c3 = c2;
            i = 1;
        }
        int iM2577lLi1LL = m2577lLi1LL(c3);
        int iM2576iILLL1 = m2576iILLL1(c3);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int iRound = iArr[0] + Math.round(viewGroup.getTranslationX());
        int iRound2 = iArr[1] + Math.round(viewGroup.getTranslationY());
        int width = iRound + viewGroup.getWidth();
        int height = iRound2 + viewGroup.getHeight();
        if (epicenter != null) {
            iCenterX = epicenter.centerX();
            iCenterY = epicenter.centerY();
        } else {
            iCenterX = (iRound + width) / 2;
            iCenterY = (iRound2 + height) / 2;
        }
        float fM2566IiL = m2566IiL(viewGroup, iM2577lLi1LL, iM2576iILLL1, iCenterX, iCenterY, iRound, iRound2, width, height) / m2567L11I(viewGroup);
        long duration = transition.getDuration();
        if (duration < 0) {
            duration = 300;
        }
        return Math.round(((duration * ((long) i)) / this.f4438ILil) * fM2566IiL);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0017  */
    /* JADX WARN: Code duplicated, block: B:9:0x0015  */
    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final int m2566IiL(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = this.f4437I1I;
        if (i9 == 8388611) {
            if (ILil.p028IiL.p029ILl.iIlLiL.m2134l(view) == 1) {
                i9 = 5;
            } else {
                i9 = 3;
            }
        } else if (i9 == 8388613) {
            if (ILil.p028IiL.p029ILl.iIlLiL.m2134l(view) == 1) {
                i9 = 3;
            } else {
                i9 = 5;
            }
        }
        if (i9 == 3) {
            return (i7 - i) + Math.abs(i4 - i2);
        }
        if (i9 == 5) {
            return (i - i5) + Math.abs(i4 - i2);
        }
        if (i9 == 48) {
            return (i8 - i2) + Math.abs(i3 - i);
        }
        if (i9 != 80) {
            return 0;
        }
        return (i2 - i6) + Math.abs(i3 - i);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final int m2567L11I(ViewGroup viewGroup) {
        int i = this.f4437I1I;
        return (i == 3 || i == 5 || i == 8388611 || i == 8388613) ? viewGroup.getWidth() : viewGroup.getHeight();
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void m2568il(int i) {
        this.f4437I1I = i;
    }
}
