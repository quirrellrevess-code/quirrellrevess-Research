package androidx.transition;

import ILil.p044llL1ii.C0646lIII;
import ILil.p044llL1ii.C1;
import ILil.p044llL1ii.I1I;
import ILil.p044llL1ii.llL1ii;
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes.dex */
public class Explode extends Visibility {

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static final TimeInterpolator f5178Ilil = new DecelerateInterpolator();

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static final TimeInterpolator f2766lLi1LL = new AccelerateInterpolator();

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int[] f2767IL;

    public Explode() {
        this.f2767IL = new int[2];
        setPropagation(new I1I());
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static float m3365L11I(float f, float f2) {
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }

    private void captureValues(C1 c1) {
        View view = c1.f4477ILil;
        view.getLocationOnScreen(this.f2767IL);
        int[] iArr = this.f2767IL;
        int i = iArr[0];
        int i2 = iArr[1];
        c1.f4476IL1Iii.put("android:explode:screenBounds", new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2));
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static float m3366il(View view, int i, int i2) {
        return m3365L11I(Math.max(i, view.getWidth() - i), Math.max(i2, view.getHeight() - i2));
    }

    @Override // androidx.transition.Visibility
    public Animator I1I(ViewGroup viewGroup, View view, C1 c1, C1 c2) {
        if (c2 == null) {
            return null;
        }
        Rect rect = (Rect) c2.f4476IL1Iii.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        ILL(viewGroup, rect, this.f2767IL);
        int[] iArr = this.f2767IL;
        return C0646lIII.IL1Iii(view, c2, rect.left, rect.top, translationX + iArr[0], translationY + iArr[1], translationX, translationY, f5178Ilil, this);
    }

    public final void ILL(View view, Rect rect, int[] iArr) {
        int iCenterY;
        int width;
        view.getLocationOnScreen(this.f2767IL);
        int[] iArr2 = this.f2767IL;
        int i = iArr2[0];
        int i2 = iArr2[1];
        Rect epicenter = getEpicenter();
        if (epicenter == null) {
            width = (view.getWidth() / 2) + i + Math.round(view.getTranslationX());
            iCenterY = (view.getHeight() / 2) + i2 + Math.round(view.getTranslationY());
        } else {
            int iCenterX = epicenter.centerX();
            iCenterY = epicenter.centerY();
            width = iCenterX;
        }
        float fCenterX = rect.centerX() - width;
        float fCenterY = rect.centerY() - iCenterY;
        if (fCenterX == 0.0f && fCenterY == 0.0f) {
            fCenterX = ((float) (Math.random() * 2.0d)) - 1.0f;
            fCenterY = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float fM3365L11I = m3365L11I(fCenterX, fCenterY);
        float fM3366il = m3366il(view, width - i, iCenterY - i2);
        iArr[0] = Math.round((fCenterX / fM3365L11I) * fM3366il);
        iArr[1] = Math.round(fM3366il * (fCenterY / fM3365L11I));
    }

    @Override // androidx.transition.Visibility
    public Animator Ilil(ViewGroup viewGroup, View view, C1 c1, C1 c2) {
        float f;
        float f2;
        if (c1 == null) {
            return null;
        }
        Rect rect = (Rect) c1.f4476IL1Iii.get("android:explode:screenBounds");
        int i = rect.left;
        int i2 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) c1.f4477ILil.getTag(llL1ii.transition_position);
        if (iArr != null) {
            f = (iArr[0] - rect.left) + translationX;
            f2 = (iArr[1] - rect.top) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
        } else {
            f = translationX;
            f2 = translationY;
        }
        ILL(viewGroup, rect, this.f2767IL);
        int[] iArr2 = this.f2767IL;
        return C0646lIII.IL1Iii(view, c1, i, i2, translationX, translationY, f + iArr2[0], f2 + iArr2[1], f2766lLi1LL, this);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(C1 c1) {
        super.captureEndValues(c1);
        captureValues(c1);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(C1 c1) {
        super.captureStartValues(c1);
        captureValues(c1);
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2767IL = new int[2];
        setPropagation(new I1I());
    }
}
