package ILil.p028IiL.p029ILl;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Objects;

/* JADX INFO: renamed from: ILil.I丨iL.IL丨丨l.ll丨L1ii, reason: invalid class name */
/* JADX INFO: compiled from: OneShotPreDrawListener.java */
/* JADX INFO: loaded from: classes.dex */
public final class llL1ii implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public ViewTreeObserver f4082I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final View f4083ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final Runnable f1634IL;

    public llL1ii(View view, Runnable runnable) {
        this.f4083ILil = view;
        this.f4082I1I = view.getViewTreeObserver();
        this.f1634IL = runnable;
    }

    public static llL1ii IL1Iii(View view, Runnable runnable) {
        Objects.requireNonNull(view, "view == null");
        Objects.requireNonNull(runnable, "runnable == null");
        llL1ii lll1ii = new llL1ii(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(lll1ii);
        view.addOnAttachStateChangeListener(lll1ii);
        return lll1ii;
    }

    public void ILil() {
        if (this.f4082I1I.isAlive()) {
            this.f4082I1I.removeOnPreDrawListener(this);
        } else {
            this.f4083ILil.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f4083ILil.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        ILil();
        this.f1634IL.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f4082I1I = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        ILil();
    }
}
