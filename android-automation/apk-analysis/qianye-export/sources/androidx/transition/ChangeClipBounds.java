package androidx.transition;

import ILil.p028IiL.p029ILl.iIlLiL;
import ILil.p044llL1ii.C1;
import ILil.p044llL1ii.IIi;
import ILil.p044llL1ii.lIlii;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class ChangeClipBounds extends Transition {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final String[] f5155ILil = {"android:clipBounds:clip"};

    public class IL1Iii extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ View f5156IL1Iii;

        public IL1Iii(ChangeClipBounds changeClipBounds, View view) {
            this.f5156IL1Iii = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            iIlLiL.m2110iIl1il(this.f5156IL1Iii, null);
        }
    }

    public ChangeClipBounds() {
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
        View view = c1.f4477ILil;
        if (view.getVisibility() == 8) {
            return;
        }
        Rect rectM2123lIlii = iIlLiL.m2123lIlii(view);
        c1.f4476IL1Iii.put("android:clipBounds:clip", rectM2123lIlii);
        if (rectM2123lIlii == null) {
            c1.f4476IL1Iii.put("android:clipBounds:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
        }
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, C1 c1, C1 c2) {
        ObjectAnimator objectAnimatorOfObject = null;
        if (c1 != null && c2 != null && c1.f4476IL1Iii.containsKey("android:clipBounds:clip") && c2.f4476IL1Iii.containsKey("android:clipBounds:clip")) {
            Rect rect = (Rect) c1.f4476IL1Iii.get("android:clipBounds:clip");
            Rect rect2 = (Rect) c2.f4476IL1Iii.get("android:clipBounds:clip");
            boolean z = rect2 == null;
            if (rect == null && rect2 == null) {
                return null;
            }
            if (rect == null) {
                rect = (Rect) c1.f4476IL1Iii.get("android:clipBounds:bounds");
            } else if (rect2 == null) {
                rect2 = (Rect) c2.f4476IL1Iii.get("android:clipBounds:bounds");
            }
            if (rect.equals(rect2)) {
                return null;
            }
            iIlLiL.m2110iIl1il(c2.f4477ILil, rect);
            objectAnimatorOfObject = ObjectAnimator.ofObject(c2.f4477ILil, (Property<View, V>) IIi.f4412I1I, (TypeEvaluator) new lIlii(new Rect()), (Object[]) new Rect[]{rect, rect2});
            if (z) {
                objectAnimatorOfObject.addListener(new IL1Iii(this, c2.f4477ILil));
            }
        }
        return objectAnimatorOfObject;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return f5155ILil;
    }

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
