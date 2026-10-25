package ILil.ILil.p023lIlii;

import ILil.p028IiL.p029ILl.I11li1;
import ILil.p028IiL.p029ILl.iIlLiL;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* JADX INFO: renamed from: ILil.ILil.lI丨lii.丨iI丨丨LLl, reason: invalid class name */
/* JADX INFO: compiled from: TooltipCompatHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class iILLl implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    public static iILLl ILL;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static iILLl f1416Ll1;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final CharSequence f3836I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final View f3837ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final int f1417IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public int f1418IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public IIi f1419L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int f1420iILLL1;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public boolean f1422il;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final Runnable f3838Ilil = new IL1Iii();

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final Runnable f1421lLi1LL = new ILil();

    /* JADX INFO: renamed from: ILil.ILil.lI丨lii.丨iI丨丨LLl$IL1Iii */
    /* JADX INFO: compiled from: TooltipCompatHandler.java */
    public class IL1Iii implements Runnable {
        public IL1Iii() {
        }

        @Override // java.lang.Runnable
        public void run() {
            iILLl.this.m1842iILLL1(false);
        }
    }

    /* JADX INFO: renamed from: ILil.ILil.lI丨lii.丨iI丨丨LLl$ILil */
    /* JADX INFO: compiled from: TooltipCompatHandler.java */
    public class ILil implements Runnable {
        public ILil() {
        }

        @Override // java.lang.Runnable
        public void run() {
            iILLl.this.I1I();
        }
    }

    public iILLl(View view, CharSequence charSequence) {
        this.f3837ILil = view;
        this.f3836I1I = charSequence;
        this.f1417IL = I11li1.I1I(ViewConfiguration.get(view.getContext()));
        ILil();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void Ilil(iILLl iilll) {
        iILLl iilll2 = ILL;
        if (iilll2 != null) {
            iilll2.IL1Iii();
        }
        ILL = iilll;
        if (iilll != null) {
            iilll.m1840IL();
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static void m1839lLi1LL(View view, CharSequence charSequence) {
        iILLl iilll = ILL;
        if (iilll != null && iilll.f3837ILil == view) {
            Ilil(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new iILLl(view, charSequence);
            return;
        }
        iILLl iilll2 = f1416Ll1;
        if (iilll2 != null && iilll2.f3837ILil == view) {
            iilll2.I1I();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public void I1I() {
        if (f1416Ll1 == this) {
            f1416Ll1 = null;
            IIi iIi = this.f1419L11I;
            if (iIi != null) {
                iIi.I1I();
                this.f1419L11I = null;
                ILil();
                this.f3837ILil.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (ILL == this) {
            Ilil(null);
        }
        this.f3837ILil.removeCallbacks(this.f1421lLi1LL);
    }

    public final void IL1Iii() {
        this.f3837ILil.removeCallbacks(this.f3838Ilil);
    }

    public final void ILil() {
        this.f1420iILLL1 = Integer.MAX_VALUE;
        this.f1418IiL = Integer.MAX_VALUE;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final void m1840IL() {
        this.f3837ILil.postDelayed(this.f3838Ilil, ViewConfiguration.getLongPressTimeout());
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final boolean m1841IiL(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.f1420iILLL1) <= this.f1417IL && Math.abs(y - this.f1418IiL) <= this.f1417IL) {
            return false;
        }
        this.f1420iILLL1 = x;
        this.f1418IiL = y;
        return true;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m1842iILLL1(boolean z) {
        long j;
        int longPressTimeout;
        long j2;
        if (iIlLiL.m2099L11(this.f3837ILil)) {
            Ilil(null);
            iILLl iilll = f1416Ll1;
            if (iilll != null) {
                iilll.I1I();
            }
            f1416Ll1 = this;
            this.f1422il = z;
            IIi iIi = new IIi(this.f3837ILil.getContext());
            this.f1419L11I = iIi;
            iIi.Ilil(this.f3837ILil, this.f1420iILLL1, this.f1418IiL, this.f1422il, this.f3836I1I);
            this.f3837ILil.addOnAttachStateChangeListener(this);
            if (this.f1422il) {
                j2 = 2500;
            } else {
                if ((iIlLiL.m2106L1l(this.f3837ILil) & 1) == 1) {
                    j = 3000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                } else {
                    j = 15000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                }
                j2 = j - ((long) longPressTimeout);
            }
            this.f3837ILil.removeCallbacks(this.f1421lLi1LL);
            this.f3837ILil.postDelayed(this.f1421lLi1LL, j2);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f1419L11I != null && this.f1422il) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f3837ILil.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                ILil();
                I1I();
            }
        } else if (this.f3837ILil.isEnabled() && this.f1419L11I == null && m1841IiL(motionEvent)) {
            Ilil(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f1420iILLL1 = view.getWidth() / 2;
        this.f1418IiL = view.getHeight() / 2;
        m1842iILLL1(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        I1I();
    }
}
