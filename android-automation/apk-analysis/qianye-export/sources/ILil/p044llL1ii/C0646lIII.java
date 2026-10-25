package ILil.p044llL1ii;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.util.Property;
import android.view.View;
import androidx.transition.Transition;

/* JADX INFO: renamed from: ILil.ll丨L1ii.lI丨II, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: TranslationAnimationCreator.java */
/* JADX INFO: loaded from: classes.dex */
public class C0646lIII {

    /* JADX INFO: renamed from: ILil.ll丨L1ii.lI丨II$IL1Iii */
    /* JADX INFO: compiled from: TranslationAnimationCreator.java */
    public static class IL1Iii extends AnimatorListenerAdapter implements Transition.IiL {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final int f4444I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final View f4445IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final View f4446ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int[] f4447Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final int f1865IL;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public final float f1866IiL;

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public final float f1867L11I;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public float f1868iILLL1;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public float f1869lLi1LL;

        public IL1Iii(View view, View view2, int i, int i2, float f, float f2) {
            this.f4446ILil = view;
            this.f4445IL1Iii = view2;
            this.f4444I1I = i - Math.round(view.getTranslationX());
            this.f1865IL = i2 - Math.round(view.getTranslationY());
            this.f1866IiL = f;
            this.f1867L11I = f2;
            int i3 = llL1ii.transition_position;
            int[] iArr = (int[]) view2.getTag(i3);
            this.f4447Ilil = iArr;
            if (iArr != null) {
                view2.setTag(i3, null);
            }
        }

        @Override // androidx.transition.Transition.IiL
        public void I1I(Transition transition) {
            this.f4446ILil.setTranslationX(this.f1866IiL);
            this.f4446ILil.setTranslationY(this.f1867L11I);
            transition.removeListener(this);
        }

        @Override // androidx.transition.Transition.IiL
        public void IL1Iii(Transition transition) {
        }

        @Override // androidx.transition.Transition.IiL
        public void ILil(Transition transition) {
        }

        @Override // androidx.transition.Transition.IiL
        public void Ilil(Transition transition) {
        }

        @Override // androidx.transition.Transition.IiL
        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public void mo2573IL(Transition transition) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f4447Ilil == null) {
                this.f4447Ilil = new int[2];
            }
            this.f4447Ilil[0] = Math.round(this.f4444I1I + this.f4446ILil.getTranslationX());
            this.f4447Ilil[1] = Math.round(this.f1865IL + this.f4446ILil.getTranslationY());
            this.f4445IL1Iii.setTag(llL1ii.transition_position, this.f4447Ilil);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.f1869lLi1LL = this.f4446ILil.getTranslationX();
            this.f1868iILLL1 = this.f4446ILil.getTranslationY();
            this.f4446ILil.setTranslationX(this.f1866IiL);
            this.f4446ILil.setTranslationY(this.f1867L11I);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            this.f4446ILil.setTranslationX(this.f1869lLi1LL);
            this.f4446ILil.setTranslationY(this.f1868iILLL1);
        }
    }

    public static Animator IL1Iii(View view, C1 c1, int i, int i2, float f, float f2, float f3, float f4, TimeInterpolator timeInterpolator, Transition transition) {
        float f5;
        float f6;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) c1.f4477ILil.getTag(llL1ii.transition_position);
        if (iArr != null) {
            f5 = (iArr[0] - i) + translationX;
            f6 = (iArr[1] - i2) + translationY;
        } else {
            f5 = f;
            f6 = f2;
        }
        int iRound = i + Math.round(f5 - translationX);
        int iRound2 = i2 + Math.round(f6 - translationY);
        view.setTranslationX(f5);
        view.setTranslationY(f6);
        if (f5 == f3 && f6 == f4) {
            return null;
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f5, f3), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f6, f4));
        IL1Iii iL1Iii = new IL1Iii(view, c1.f4477ILil, iRound, iRound2, translationX, translationY);
        transition.addListener(iL1Iii);
        objectAnimatorOfPropertyValuesHolder.addListener(iL1Iii);
        ILil.p044llL1ii.IL1Iii.IL1Iii(objectAnimatorOfPropertyValuesHolder, iL1Iii);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(timeInterpolator);
        return objectAnimatorOfPropertyValuesHolder;
    }
}
