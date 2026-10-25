package ILil.p046il.IL1Iii;

import ILil.p028IiL.p029ILl.iIlLiL;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;

/* JADX INFO: compiled from: ViewDragHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class I1I {
    public static final Interpolator I11L = new IL1Iii();
    public final ViewGroup I11li1;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public int f4550IL1Iii;
    public int ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f4551ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public float f2043ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public float[] f4552Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public float[] f2044IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public int[] f2045IiL;
    public int Lil;
    public int LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public VelocityTracker f2046Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public int[] f2047L11I;
    public View iIi1;
    public boolean iIlLiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public float[] f2048iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public float f2049lIiI;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public final AbstractC0587I1I f2050lIlii;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public OverScroller f2051llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public float[] f2052lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public int[] f2053il;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f4549I1I = -1;

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public final Runnable f2054lL = new ILil();

    /* JADX INFO: renamed from: ILil.丨il.IL1Iii.I1I$I1I, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ViewDragHelper.java */
    public static abstract class AbstractC0587I1I {
        public abstract int clampViewPositionHorizontal(View view, int i, int i2);

        public abstract int clampViewPositionVertical(View view, int i, int i2);

        public int getOrderedChildIndex(int i) {
            return i;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i, int i2) {
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void onEdgeTouched(int i, int i2) {
        }

        public void onViewCaptured(View view, int i) {
        }

        public abstract void onViewDragStateChanged(int i);

        public abstract void onViewPositionChanged(View view, int i, int i2, int i3, int i4);

        public abstract void onViewReleased(View view, float f, float f2);

        public abstract boolean tryCaptureView(View view, int i);
    }

    /* JADX INFO: compiled from: ViewDragHelper.java */
    public static class IL1Iii implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* JADX INFO: compiled from: ViewDragHelper.java */
    public class ILil implements Runnable {
        public ILil() {
        }

        @Override // java.lang.Runnable
        public void run() {
            I1I.this.m2751iILLl(0);
        }
    }

    public I1I(Context context, ViewGroup viewGroup, AbstractC0587I1I abstractC0587I1I) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (abstractC0587I1I == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.I11li1 = viewGroup;
        this.f2050lIlii = abstractC0587I1I;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.Lil = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f4551ILil = viewConfiguration.getScaledTouchSlop();
        this.f2049lIiI = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f2043ILl = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f2051llL1ii = new OverScroller(context, I11L);
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public static I1I m2731ILl(ViewGroup viewGroup, float f, AbstractC0587I1I abstractC0587I1I) {
        I1I i1iLil = Lil(viewGroup, abstractC0587I1I);
        i1iLil.f4551ILil = (int) (i1iLil.f4551ILil * (1.0f / f));
        return i1iLil;
    }

    public static I1I Lil(ViewGroup viewGroup, AbstractC0587I1I abstractC0587I1I) {
        return new I1I(viewGroup.getContext(), viewGroup, abstractC0587I1I);
    }

    public int I11L() {
        return this.Lil;
    }

    public final boolean I11li1(int i, int i2, int i3, int i4) {
        int left = this.iIi1.getLeft();
        int top = this.iIi1.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f2051llL1ii.abortAnimation();
            m2751iILLl(0);
            return false;
        }
        this.f2051llL1ii.startScroll(left, top, i5, i6, m2739Ll1(this.iIi1, i5, i6, i3, i4));
        m2751iILLl(2);
        return true;
    }

    public final boolean I1I(float f, float f2, int i, int i2) {
        float fAbs = Math.abs(f);
        float fAbs2 = Math.abs(f2);
        if ((this.f2045IiL[i] & i2) != i2 || (this.LlLI1 & i2) == 0 || (this.f2053il[i] & i2) == i2 || (this.f2047L11I[i] & i2) == i2) {
            return false;
        }
        int i3 = this.f4551ILil;
        if (fAbs <= i3 && fAbs2 <= i3) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.f2050lIlii.onEdgeLock(i2)) {
            return (this.f2047L11I[i] & i2) == 0 && fAbs > ((float) this.f4551ILil);
        }
        int[] iArr = this.f2053il;
        iArr[i] = iArr[i] | i2;
        return false;
    }

    public void IL1Iii() {
        this.f4549I1I = -1;
        m2741L11I();
        VelocityTracker velocityTracker = this.f2046Ll1;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2046Ll1 = null;
        }
    }

    public final int ILL(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.I11li1.getWidth();
        float f = width / 2;
        float fM2749llL1ii = f + (m2749llL1ii(Math.min(1.0f, Math.abs(i) / width)) * f);
        int iAbs = Math.abs(i2);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fM2749llL1ii / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f), 600);
    }

    public void ILil(View view, int i) {
        if (view.getParent() == this.I11li1) {
            this.iIi1 = view;
            this.f4549I1I = i;
            this.f2050lIlii.onViewCaptured(view, i);
            m2751iILLl(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.I11li1 + ")");
    }

    public boolean Ilil(int i, int i2) {
        if (!m2747lIII(i2)) {
            return false;
        }
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        float f = this.f2052lLi1LL[i2] - this.f2044IL[i2];
        float f2 = this.f2048iILLL1[i2] - this.f4552Ilil[i2];
        if (z && z2) {
            float f3 = (f * f) + (f2 * f2);
            int i3 = this.f4551ILil;
            return f3 > ((float) (i3 * i3));
        }
        if (z) {
            return Math.abs(f) > ((float) this.f4551ILil);
        }
        return z2 && Math.abs(f2) > ((float) this.f4551ILil);
    }

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public void m2732IIi(int i) {
        this.LlLI1 = i;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean m2733IL(int i) {
        int length = this.f2044IL.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (Ilil(i, i2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final int m2734IiL(int i, int i2, int i3) {
        int iAbs = Math.abs(i);
        if (iAbs < i2) {
            return 0;
        }
        if (iAbs > i3) {
            return i > 0 ? i3 : -i3;
        }
        return i;
    }

    /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
    public boolean m2735L11(View view, int i, int i2) {
        this.iIi1 = view;
        this.f4549I1I = -1;
        boolean zI11li1 = I11li1(i, i2, 0, 0);
        if (!zI11li1 && this.f4550IL1Iii == 0 && this.iIi1 != null) {
            this.iIi1 = null;
        }
        return zI11li1;
    }

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public boolean m2736L111(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public void m2737LIll(float f) {
        this.f2043ILl = f;
    }

    public final boolean LL1IL(int i) {
        if (m2747lIII(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    /* JADX INFO: renamed from: LlIl丨, reason: contains not printable characters */
    public boolean m2738LlIl(View view, int i) {
        if (view == this.iIi1 && this.f4549I1I == i) {
            return true;
        }
        if (view == null || !this.f2050lIlii.tryCaptureView(view, i)) {
            return false;
        }
        this.f4549I1I = i;
        ILil(view, i);
        return true;
    }

    public final void LlLI1(float f, float f2) {
        this.iIlLiL = true;
        this.f2050lIlii.onViewReleased(this.iIi1, f, f2);
        this.iIlLiL = false;
        if (this.f4550IL1Iii == 1) {
            m2751iILLl(0);
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final int m2739Ll1(View view, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int iM2734IiL = m2734IiL(i3, (int) this.f2043ILl, (int) this.f2049lIiI);
        int iM2734IiL2 = m2734IiL(i4, (int) this.f2043ILl, (int) this.f2049lIiI);
        int iAbs = Math.abs(i);
        int iAbs2 = Math.abs(i2);
        int iAbs3 = Math.abs(iM2734IiL);
        int iAbs4 = Math.abs(iM2734IiL2);
        int i5 = iAbs3 + iAbs4;
        int i6 = iAbs + iAbs2;
        if (iM2734IiL != 0) {
            f = iAbs3;
            f2 = i5;
        } else {
            f = iAbs;
            f2 = i6;
        }
        float f5 = f / f2;
        if (iM2734IiL2 != 0) {
            f3 = iAbs4;
            f4 = i5;
        } else {
            f3 = iAbs2;
            f4 = i6;
        }
        return (int) ((ILL(i, iM2734IiL, this.f2050lIlii.getViewHorizontalDragRange(view)) * f5) + (ILL(i2, iM2734IiL2, this.f2050lIlii.getViewVerticalDragRange(view)) * (f3 / f4)));
    }

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public final void m2740L1l(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (LL1IL(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f2052lLi1LL[pointerId] = x;
                this.f2048iILLL1[pointerId] = y;
            }
        }
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final void m2741L11I() {
        float[] fArr = this.f2044IL;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f4552Ilil, 0.0f);
        Arrays.fill(this.f2052lLi1LL, 0.0f);
        Arrays.fill(this.f2048iILLL1, 0.0f);
        Arrays.fill(this.f2045IiL, 0);
        Arrays.fill(this.f2047L11I, 0);
        Arrays.fill(this.f2053il, 0);
        this.ILL = 0;
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public boolean m2742LlLLL(int i, int i2) {
        return m2736L111(this.iIi1, i, i2);
    }

    public final void iIi1(int i) {
        float[] fArr = this.f2044IL;
        if (fArr == null || fArr.length <= i) {
            int i2 = i + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f4552Ilil;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f2052lLi1LL;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f2048iILLL1;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f2045IiL;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f2047L11I;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f2053il;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f2044IL = fArr2;
            this.f4552Ilil = fArr3;
            this.f2052lLi1LL = fArr4;
            this.f2048iILLL1 = fArr5;
            this.f2045IiL = iArr;
            this.f2047L11I = iArr2;
            this.f2053il = iArr3;
        }
    }

    public View iIlLiL(int i, int i2) {
        for (int childCount = this.I11li1.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.I11li1.getChildAt(this.f2050lIlii.getOrderedChildIndex(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final float m2743iILLL1(float f, float f2, float f3) {
        float fAbs = Math.abs(f);
        if (fAbs < f2) {
            return 0.0f;
        }
        if (fAbs > f3) {
            return f > 0.0f ? f3 : -f3;
        }
        return f;
    }

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public boolean m2744ill(int i, int i2) {
        if (this.iIlLiL) {
            return I11li1(i, i2, (int) this.f2046Ll1.getXVelocity(this.f4549I1I), (int) this.f2046Ll1.getYVelocity(this.f4549I1I));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public final void m2745l1IIi1(float f, float f2, int i) {
        iIi1(i);
        float[] fArr = this.f2044IL;
        this.f2052lLi1LL[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.f4552Ilil;
        this.f2048iILLL1[i] = f2;
        fArr2[i] = f2;
        this.f2045IiL[i] = llliI((int) f, (int) f2);
        this.ILL |= 1 << i;
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public boolean m2746lIiI(boolean z) {
        if (this.f4550IL1Iii == 2) {
            boolean zComputeScrollOffset = this.f2051llL1ii.computeScrollOffset();
            int currX = this.f2051llL1ii.getCurrX();
            int currY = this.f2051llL1ii.getCurrY();
            int left = currX - this.iIi1.getLeft();
            int top = currY - this.iIi1.getTop();
            if (left != 0) {
                iIlLiL.m2092I1L11L(this.iIi1, left);
            }
            if (top != 0) {
                iIlLiL.m2094ILLIi(this.iIi1, top);
            }
            if (left != 0 || top != 0) {
                this.f2050lIlii.onViewPositionChanged(this.iIi1, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.f2051llL1ii.getFinalX() && currY == this.f2051llL1ii.getFinalY()) {
                this.f2051llL1ii.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                if (z) {
                    this.I11li1.post(this.f2054lL);
                } else {
                    m2751iILLl(0);
                }
            }
        }
        return this.f4550IL1Iii == 2;
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public boolean m2747lIII(int i) {
        return ((1 << i) & this.ILL) != 0;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public final void m2748lIlii(int i, int i2, int i3, int i4) {
        int left = this.iIi1.getLeft();
        int top = this.iIi1.getTop();
        if (i3 != 0) {
            i = this.f2050lIlii.clampViewPositionHorizontal(this.iIi1, i, i3);
            iIlLiL.m2092I1L11L(this.iIi1, i - left);
        }
        int i5 = i;
        if (i4 != 0) {
            i2 = this.f2050lIlii.clampViewPositionVertical(this.iIi1, i2, i4);
            iIlLiL.m2094ILLIi(this.iIi1, i2 - top);
        }
        int i6 = i2;
        if (i3 == 0 && i4 == 0) {
            return;
        }
        this.f2050lIlii.onViewPositionChanged(this.iIi1, i5, i6, i5 - left, i6 - top);
    }

    public final void llI(float f, float f2, int i) {
        int i2 = I1I(f, f2, i, 1) ? 1 : 0;
        if (I1I(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (I1I(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (I1I(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f2047L11I;
            iArr[i] = iArr[i] | i2;
            this.f2050lIlii.onEdgeDragStarted(i2, i);
        }
    }

    public final int llliI(int i, int i2) {
        int i3 = i < this.I11li1.getLeft() + this.Lil ? 1 : 0;
        if (i2 < this.I11li1.getTop() + this.Lil) {
            i3 |= 4;
        }
        if (i > this.I11li1.getRight() - this.Lil) {
            i3 |= 2;
        }
        return i2 > this.I11li1.getBottom() - this.Lil ? i3 | 8 : i3;
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public final float m2749llL1ii(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final boolean m2750lLi1LL(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.f2050lIlii.getViewHorizontalDragRange(view) > 0;
        boolean z2 = this.f2050lIlii.getViewVerticalDragRange(view) > 0;
        if (z && z2) {
            float f3 = (f * f) + (f2 * f2);
            int i = this.f4551ILil;
            return f3 > ((float) (i * i));
        }
        if (z) {
            return Math.abs(f) > ((float) this.f4551ILil);
        }
        return z2 && Math.abs(f2) > ((float) this.f4551ILil);
    }

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public void m2751iILLl(int i) {
        this.I11li1.removeCallbacks(this.f2054lL);
        if (this.f4550IL1Iii != i) {
            this.f4550IL1Iii = i;
            this.f2050lIlii.onViewDragStateChanged(i);
            if (this.f4550IL1Iii == 0) {
                this.iIi1 = null;
            }
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final void m2752il(int i) {
        if (this.f2044IL == null || !m2747lIII(i)) {
            return;
        }
        this.f2044IL[i] = 0.0f;
        this.f4552Ilil[i] = 0.0f;
        this.f2052lLi1LL[i] = 0.0f;
        this.f2048iILLL1[i] = 0.0f;
        this.f2045IiL[i] = 0;
        this.f2047L11I[i] = 0;
        this.f2053il[i] = 0;
        this.ILL = (~(1 << i)) & this.ILL;
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public View m2753lL() {
        return this.iIi1;
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public int m2754l() {
        return this.f4551ILil;
    }

    /* JADX INFO: renamed from: 丨丨 */
    public final void m94() {
        this.f2046Ll1.computeCurrentVelocity(1000, this.f2049lIiI);
        LlLI1(m2743iILLL1(this.f2046Ll1.getXVelocity(this.f4549I1I), this.f2043ILl, this.f2049lIiI), m2743iILLL1(this.f2046Ll1.getYVelocity(this.f4549I1I), this.f2043ILl, this.f2049lIiI));
    }

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public void m2755LLlI1(MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            IL1Iii();
        }
        if (this.f2046Ll1 == null) {
            this.f2046Ll1 = VelocityTracker.obtain();
        }
        this.f2046Ll1.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewIIlLiL = iIlLiL((int) x, (int) y);
            m2745l1IIi1(x, y, pointerId);
            m2738LlIl(viewIIlLiL, pointerId);
            int i3 = this.f2045IiL[pointerId];
            int i4 = this.LlLI1;
            if ((i3 & i4) != 0) {
                this.f2050lIlii.onEdgeTouched(i3 & i4, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f4550IL1Iii == 1) {
                m94();
            }
            IL1Iii();
            return;
        }
        if (actionMasked == 2) {
            if (this.f4550IL1Iii == 1) {
                if (LL1IL(this.f4549I1I)) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f4549I1I);
                    float x2 = motionEvent.getX(iFindPointerIndex);
                    float y2 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.f2052lLi1LL;
                    int i5 = this.f4549I1I;
                    int i6 = (int) (x2 - fArr[i5]);
                    int i7 = (int) (y2 - this.f2048iILLL1[i5]);
                    m2748lIlii(this.iIi1.getLeft() + i6, this.iIi1.getTop() + i7, i6, i7);
                    m2740L1l(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i2 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i2);
                if (LL1IL(pointerId2)) {
                    float x3 = motionEvent.getX(i2);
                    float y3 = motionEvent.getY(i2);
                    float f = x3 - this.f2044IL[pointerId2];
                    float f2 = y3 - this.f4552Ilil[pointerId2];
                    llI(f, f2, pointerId2);
                    if (this.f4550IL1Iii != 1) {
                        View viewIIlLiL2 = iIlLiL((int) x3, (int) y3);
                        if (m2750lLi1LL(viewIIlLiL2, f, f2) && m2738LlIl(viewIIlLiL2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i2++;
            }
            m2740L1l(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f4550IL1Iii == 1) {
                LlLI1(0.0f, 0.0f);
            }
            IL1Iii();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x4 = motionEvent.getX(actionIndex);
            float y4 = motionEvent.getY(actionIndex);
            m2745l1IIi1(x4, y4, pointerId3);
            if (this.f4550IL1Iii != 0) {
                if (m2742LlLLL((int) x4, (int) y4)) {
                    m2738LlIl(this.iIi1, pointerId3);
                    return;
                }
                return;
            } else {
                m2738LlIl(iIlLiL((int) x4, (int) y4), pointerId3);
                int i8 = this.f2045IiL[pointerId3];
                int i9 = this.LlLI1;
                if ((i8 & i9) != 0) {
                    this.f2050lIlii.onEdgeTouched(i8 & i9, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f4550IL1Iii == 1 && pointerId4 == this.f4549I1I) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i2 >= pointerCount2) {
                    i = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i2);
                if (pointerId5 != this.f4549I1I) {
                    View viewIIlLiL3 = iIlLiL((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                    View view = this.iIi1;
                    if (viewIIlLiL3 == view && m2738LlIl(view, pointerId5)) {
                        i = this.f4549I1I;
                        break;
                    }
                }
                i2++;
            }
            if (i == -1) {
                m94();
            }
        }
        m2752il(pointerId4);
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public int m27561() {
        return this.f4550IL1Iii;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ff  */
    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public boolean m2757(MotionEvent motionEvent) {
        boolean z;
        View viewIIlLiL;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            IL1Iii();
        }
        if (this.f2046Ll1 == null) {
            this.f2046Ll1 = VelocityTracker.obtain();
        }
        this.f2046Ll1.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                IL1Iii();
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    IL1Iii();
                } else if (actionMasked == 5) {
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    float x = motionEvent.getX(actionIndex);
                    float y = motionEvent.getY(actionIndex);
                    m2745l1IIi1(x, y, pointerId);
                    int i = this.f4550IL1Iii;
                    if (i == 0) {
                        int i2 = this.f2045IiL[pointerId];
                        int i3 = this.LlLI1;
                        if ((i2 & i3) != 0) {
                            this.f2050lIlii.onEdgeTouched(i2 & i3, pointerId);
                        }
                    } else if (i == 2 && (viewIIlLiL = iIlLiL((int) x, (int) y)) == this.iIi1) {
                        m2738LlIl(viewIIlLiL, pointerId);
                    }
                } else if (actionMasked == 6) {
                    m2752il(motionEvent.getPointerId(actionIndex));
                }
            } else if (this.f2044IL != null && this.f4552Ilil != null) {
                int pointerCount = motionEvent.getPointerCount();
                for (int i4 = 0; i4 < pointerCount; i4++) {
                    int pointerId2 = motionEvent.getPointerId(i4);
                    if (LL1IL(pointerId2)) {
                        float x2 = motionEvent.getX(i4);
                        float y2 = motionEvent.getY(i4);
                        float f = x2 - this.f2044IL[pointerId2];
                        float f2 = y2 - this.f4552Ilil[pointerId2];
                        View viewIIlLiL2 = iIlLiL((int) x2, (int) y2);
                        boolean z2 = viewIIlLiL2 != null && m2750lLi1LL(viewIIlLiL2, f, f2);
                        if (!z2) {
                            llI(f, f2, pointerId2);
                            if (this.f4550IL1Iii != 1) {
                                break;
                            }
                        } else {
                            int left = viewIIlLiL2.getLeft();
                            int i5 = (int) f;
                            int iClampViewPositionHorizontal = this.f2050lIlii.clampViewPositionHorizontal(viewIIlLiL2, left + i5, i5);
                            int top = viewIIlLiL2.getTop();
                            int i6 = (int) f2;
                            int iClampViewPositionVertical = this.f2050lIlii.clampViewPositionVertical(viewIIlLiL2, top + i6, i6);
                            int viewHorizontalDragRange = this.f2050lIlii.getViewHorizontalDragRange(viewIIlLiL2);
                            int viewVerticalDragRange = this.f2050lIlii.getViewVerticalDragRange(viewIIlLiL2);
                            if ((viewHorizontalDragRange == 0 || (viewHorizontalDragRange > 0 && iClampViewPositionHorizontal == left)) && (viewVerticalDragRange == 0 || (viewVerticalDragRange > 0 && iClampViewPositionVertical == top))) {
                                break;
                            }
                            llI(f, f2, pointerId2);
                            if (this.f4550IL1Iii != 1 || (z2 && m2738LlIl(viewIIlLiL2, pointerId2))) {
                                break;
                            }
                        }
                    }
                }
                m2740L1l(motionEvent);
            }
            z = false;
        } else {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            z = false;
            int pointerId3 = motionEvent.getPointerId(0);
            m2745l1IIi1(x3, y3, pointerId3);
            View viewIIlLiL3 = iIlLiL((int) x3, (int) y3);
            if (viewIIlLiL3 == this.iIi1 && this.f4550IL1Iii == 2) {
                m2738LlIl(viewIIlLiL3, pointerId3);
            }
            int i7 = this.f2045IiL[pointerId3];
            int i8 = this.LlLI1;
            if ((i7 & i8) != 0) {
                this.f2050lIlii.onEdgeTouched(i7 & i8, pointerId3);
            }
        }
        if (this.f4550IL1Iii == 1) {
            return true;
        }
        return z;
    }
}
