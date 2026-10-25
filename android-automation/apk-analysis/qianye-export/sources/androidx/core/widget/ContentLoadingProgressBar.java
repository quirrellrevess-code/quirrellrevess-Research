package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* JADX INFO: loaded from: classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public boolean f4978I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public long f4979ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public boolean f4980Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean f2566IL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final Runnable f2567iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final Runnable f2568lLi1LL;

    public class IL1Iii implements Runnable {
        public IL1Iii() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentLoadingProgressBar contentLoadingProgressBar = ContentLoadingProgressBar.this;
            contentLoadingProgressBar.f4978I1I = false;
            contentLoadingProgressBar.f4979ILil = -1L;
            contentLoadingProgressBar.setVisibility(8);
        }
    }

    public class ILil implements Runnable {
        public ILil() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentLoadingProgressBar contentLoadingProgressBar = ContentLoadingProgressBar.this;
            contentLoadingProgressBar.f2566IL = false;
            if (contentLoadingProgressBar.f4980Ilil) {
                return;
            }
            contentLoadingProgressBar.f4979ILil = System.currentTimeMillis();
            ContentLoadingProgressBar.this.setVisibility(0);
        }
    }

    public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    public final void IL1Iii() {
        removeCallbacks(this.f2568lLi1LL);
        removeCallbacks(this.f2567iILLL1);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IL1Iii();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IL1Iii();
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f4980Ilil = false;
        this.f2568lLi1LL = new IL1Iii();
        this.f2567iILLL1 = new ILil();
    }
}
