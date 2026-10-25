package ILil.p028IiL.p029ILl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: ViewPropertyAnimatorCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class llliI {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public WeakReference<View> f4074IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Runnable f4075ILil = null;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Runnable f4073I1I = null;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f1633IL = -1;

    /* JADX INFO: compiled from: ViewPropertyAnimatorCompat.java */
    public static class I1I implements l {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public llliI f4076IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public boolean f4077ILil;

        public I1I(llliI lllii) {
            this.f4076IL1Iii = lllii;
        }

        @Override // ILil.p028IiL.p029ILl.l
        public void I1I(View view) {
            this.f4077ILil = false;
            if (this.f4076IL1Iii.f1633IL > -1) {
                view.setLayerType(2, null);
            }
            llliI lllii = this.f4076IL1Iii;
            Runnable runnable = lllii.f4075ILil;
            if (runnable != null) {
                lllii.f4075ILil = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            l lVar = tag instanceof l ? (l) tag : null;
            if (lVar != null) {
                lVar.I1I(view);
            }
        }

        @Override // ILil.p028IiL.p029ILl.l
        public void IL1Iii(View view) {
            Object tag = view.getTag(2113929216);
            l lVar = tag instanceof l ? (l) tag : null;
            if (lVar != null) {
                lVar.IL1Iii(view);
            }
        }

        @Override // ILil.p028IiL.p029ILl.l
        public void ILil(View view) {
            int i = this.f4076IL1Iii.f1633IL;
            if (i > -1) {
                view.setLayerType(i, null);
                this.f4076IL1Iii.f1633IL = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.f4077ILil) {
                llliI lllii = this.f4076IL1Iii;
                Runnable runnable = lllii.f4073I1I;
                if (runnable != null) {
                    lllii.f4073I1I = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                l lVar = tag instanceof l ? (l) tag : null;
                if (lVar != null) {
                    lVar.ILil(view);
                }
                this.f4077ILil = true;
            }
        }
    }

    /* JADX INFO: compiled from: ViewPropertyAnimatorCompat.java */
    public class IL1Iii extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ l f4078IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ View f4079ILil;

        public IL1Iii(llliI lllii, l lVar, View view) {
            this.f4078IL1Iii = lVar;
            this.f4079ILil = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f4078IL1Iii.IL1Iii(this.f4079ILil);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f4078IL1Iii.ILil(this.f4079ILil);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f4078IL1Iii.I1I(this.f4079ILil);
        }
    }

    /* JADX INFO: compiled from: ViewPropertyAnimatorCompat.java */
    public class ILil implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ LlLLL f4080IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ View f4081ILil;

        public ILil(llliI lllii, LlLLL llLLL, View view) {
            this.f4080IL1Iii = llLLL;
            this.f4081ILil = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f4080IL1Iii.IL1Iii(this.f4081ILil);
        }
    }

    public llliI(View view) {
        this.f4074IL1Iii = new WeakReference<>(view);
    }

    public long I1I() {
        View view = this.f4074IL1Iii.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public llliI IL1Iii(float f) {
        View view = this.f4074IL1Iii.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public llliI ILL(float f) {
        View view = this.f4074IL1Iii.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public void ILil() {
        View view = this.f4074IL1Iii.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public llliI Ilil(Interpolator interpolator) {
        View view = this.f4074IL1Iii.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public llliI m2158IL(long j) {
        View view = this.f4074IL1Iii.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public llliI m2159IiL(long j) {
        View view = this.f4074IL1Iii.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public llliI m2160L11I(LlLLL llLLL) {
        View view = this.f4074IL1Iii.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            view.animate().setUpdateListener(llLLL != null ? new ILil(this, llLLL, view) : null);
        }
        return this;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final void m2161iILLL1(View view, l lVar) {
        if (lVar != null) {
            view.animate().setListener(new IL1Iii(this, lVar, view));
        } else {
            view.animate().setListener(null);
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public llliI m2162lLi1LL(l lVar) {
        View view = this.f4074IL1Iii.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                m2161iILLL1(view, lVar);
            } else {
                view.setTag(2113929216, lVar);
                m2161iILLL1(view, new I1I(this));
            }
        }
        return this;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void m2163il() {
        View view = this.f4074IL1Iii.get();
        if (view != null) {
            view.animate().start();
        }
    }
}
