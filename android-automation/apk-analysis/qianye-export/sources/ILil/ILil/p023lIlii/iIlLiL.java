package ILil.ILil.p023lIlii;

import ILil.ILil.p024llL1ii.ILL.llL1ii;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* JADX INFO: compiled from: ForwardingListener.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class iIlLiL implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final int f3785I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final float f3786ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final View f3787Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final int f1375IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public boolean f1376IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public int f1377L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public Runnable f1378iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public Runnable f1379lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final int[] f1380il = new int[2];

    /* JADX INFO: compiled from: ForwardingListener.java */
    public class IL1Iii implements Runnable {
        public IL1Iii() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = iIlLiL.this.f3787Ilil.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* JADX INFO: compiled from: ForwardingListener.java */
    public class ILil implements Runnable {
        public ILil() {
        }

        @Override // java.lang.Runnable
        public void run() {
            iIlLiL.this.Ilil();
        }
    }

    public iIlLiL(View view) {
        this.f3787Ilil = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f3786ILil = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f3785I1I = tapTimeout;
        this.f1375IL = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static boolean m1774IiL(View view, float f, float f2, float f3) {
        float f4 = -f3;
        return f >= f4 && f2 >= f4 && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    public abstract boolean I1I();

    public final void IL1Iii() {
        Runnable runnable = this.f1378iILLL1;
        if (runnable != null) {
            this.f3787Ilil.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f1379lLi1LL;
        if (runnable2 != null) {
            this.f3787Ilil.removeCallbacks(runnable2);
        }
    }

    public abstract llL1ii ILil();

    public void Ilil() {
        IL1Iii();
        View view = this.f3787Ilil;
        if (view.isEnabled() && !view.isLongClickable() && I1I()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.f1376IiL = true;
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean mo1775IL() {
        llL1ii lll1iiILil = ILil();
        if (lll1iiILil == null || !lll1iiILil.IL1Iii()) {
            return true;
        }
        lll1iiILil.dismiss();
        return true;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final boolean m1776L11I(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1380il;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(iArr[0], iArr[1]);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003d  */
    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final boolean m1777iILLL1(MotionEvent motionEvent) {
        View view = this.f3787Ilil;
        if (!view.isEnabled()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1377L11I = motionEvent.getPointerId(0);
            if (this.f1379lLi1LL == null) {
                this.f1379lLi1LL = new IL1Iii();
            }
            view.postDelayed(this.f1379lLi1LL, this.f3785I1I);
            if (this.f1378iILLL1 == null) {
                this.f1378iILLL1 = new ILil();
            }
            view.postDelayed(this.f1378iILLL1, this.f1375IL);
        } else if (actionMasked == 1) {
            IL1Iii();
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f1377L11I);
            if (iFindPointerIndex >= 0 && !m1774IiL(view, motionEvent.getX(iFindPointerIndex), motionEvent.getY(iFindPointerIndex), this.f3786ILil)) {
                IL1Iii();
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
        } else if (actionMasked == 3) {
            IL1Iii();
        }
        return false;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final boolean m1778lLi1LL(MotionEvent motionEvent) {
        lIlii lilii;
        View view = this.f3787Ilil;
        llL1ii lll1iiILil = ILil();
        if (lll1iiILil == null || !lll1iiILil.IL1Iii() || (lilii = (lIlii) lll1iiILil.mo1876IiL()) == null || !lilii.isShown()) {
            return false;
        }
        MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        m1776L11I(view, motionEventObtainNoHistory);
        m1779il(lilii, motionEventObtainNoHistory);
        boolean zIlil = lilii.Ilil(motionEventObtainNoHistory, this.f1377L11I);
        motionEventObtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return zIlil && (actionMasked != 1 && actionMasked != 3);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.f1376IiL;
        if (z2) {
            z = m1778lLi1LL(motionEvent) || !mo1775IL();
        } else {
            z = m1777iILLL1(motionEvent) && I1I();
            if (z) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f3787Ilil.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.f1376IiL = z;
        return z || z2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f1376IiL = false;
        this.f1377L11I = -1;
        Runnable runnable = this.f1379lLi1LL;
        if (runnable != null) {
            this.f3787Ilil.removeCallbacks(runnable);
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final boolean m1779il(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1380il;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(-iArr[0], -iArr[1]);
        return true;
    }
}
