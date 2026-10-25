package androidx.transition;

import ILil.p044llL1ii.C1;
import ILil.p044llL1ii.l;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class ChangeScroll extends Transition {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final String[] f5160ILil = {"android:changeScroll:x", "android:changeScroll:y"};

    public ChangeScroll() {
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(C1 c1) {
        captureValues(c1);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(C1 c1) {
        captureValues(c1);
    }

    public final void captureValues(C1 c1) {
        c1.f4476IL1Iii.put("android:changeScroll:x", Integer.valueOf(c1.f4477ILil.getScrollX()));
        c1.f4476IL1Iii.put("android:changeScroll:y", Integer.valueOf(c1.f4477ILil.getScrollY()));
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, C1 c1, C1 c2) {
        ObjectAnimator objectAnimatorOfInt;
        ObjectAnimator objectAnimatorOfInt2 = null;
        if (c1 == null || c2 == null) {
            return null;
        }
        View view = c2.f4477ILil;
        int iIntValue = ((Integer) c1.f4476IL1Iii.get("android:changeScroll:x")).intValue();
        int iIntValue2 = ((Integer) c2.f4476IL1Iii.get("android:changeScroll:x")).intValue();
        int iIntValue3 = ((Integer) c1.f4476IL1Iii.get("android:changeScroll:y")).intValue();
        int iIntValue4 = ((Integer) c2.f4476IL1Iii.get("android:changeScroll:y")).intValue();
        if (iIntValue != iIntValue2) {
            view.setScrollX(iIntValue);
            objectAnimatorOfInt = ObjectAnimator.ofInt(view, "scrollX", iIntValue, iIntValue2);
        } else {
            objectAnimatorOfInt = null;
        }
        if (iIntValue3 != iIntValue4) {
            view.setScrollY(iIntValue3);
            objectAnimatorOfInt2 = ObjectAnimator.ofInt(view, "scrollY", iIntValue3, iIntValue4);
        }
        return l.I1I(objectAnimatorOfInt, objectAnimatorOfInt2);
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return f5160ILil;
    }

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
