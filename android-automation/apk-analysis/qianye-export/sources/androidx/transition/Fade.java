package androidx.transition;

import ILil.p028IiL.p029ILl.iIlLiL;
import ILil.p028IiL.p035lLi1LL.I1I.IiL;
import ILil.p044llL1ii.C1;
import ILil.p044llL1ii.I11li1;
import ILil.p044llL1ii.IIi;
import ILil.p044llL1ii.lL;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class Fade extends Visibility {

    public class IL1Iii extends lL {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ View f5179IL1Iii;

        public IL1Iii(Fade fade, View view) {
            this.f5179IL1Iii = view;
        }

        @Override // androidx.transition.Transition.IiL
        public void I1I(Transition transition) {
            IIi.m2554IiL(this.f5179IL1Iii, 1.0f);
            IIi.IL1Iii(this.f5179IL1Iii);
            transition.removeListener(this);
        }
    }

    public static class ILil extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final View f5180IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public boolean f5181ILil = false;

        public ILil(View view) {
            this.f5180IL1Iii = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IIi.m2554IiL(this.f5180IL1Iii, 1.0f);
            if (this.f5181ILil) {
                this.f5180IL1Iii.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (iIlLiL.m2102LIll(this.f5180IL1Iii) && this.f5180IL1Iii.getLayerType() == 0) {
                this.f5181ILil = true;
                this.f5180IL1Iii.setLayerType(2, null);
            }
        }
    }

    public Fade(int i) {
        m3382iILLL1(i);
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static float m3367il(C1 c1, float f) {
        Float f2;
        return (c1 == null || (f2 = (Float) c1.f4476IL1Iii.get("android:fade:transitionAlpha")) == null) ? f : f2.floatValue();
    }

    @Override // androidx.transition.Visibility
    public Animator I1I(ViewGroup viewGroup, View view, C1 c1, C1 c2) {
        float fM3367il = m3367il(c1, 0.0f);
        return m3368L11I(view, fM3367il != 1.0f ? fM3367il : 0.0f, 1.0f);
    }

    @Override // androidx.transition.Visibility
    public Animator Ilil(ViewGroup viewGroup, View view, C1 c1, C1 c2) {
        IIi.Ilil(view);
        return m3368L11I(view, m3367il(c1, 1.0f), 0.0f);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final Animator m3368L11I(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        IIi.m2554IiL(view, f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, IIi.f4414ILil, f2);
        objectAnimatorOfFloat.addListener(new ILil(view));
        addListener(new IL1Iii(this, view));
        return objectAnimatorOfFloat;
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(C1 c1) {
        super.captureStartValues(c1);
        c1.f4476IL1Iii.put("android:fade:transitionAlpha", Float.valueOf(IIi.I1I(c1.f4477ILil)));
    }

    public Fade() {
    }

    @SuppressLint({"RestrictedApi"})
    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, I11li1.f1846IL);
        m3382iILLL1(IiL.m2316iILLL1(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, IL1Iii()));
        typedArrayObtainStyledAttributes.recycle();
    }
}
