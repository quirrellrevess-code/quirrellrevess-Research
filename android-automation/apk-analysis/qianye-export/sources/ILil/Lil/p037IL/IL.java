package ILil.Lil.p037IL;

import ILil.p028IiL.p029ILl.iIlLiL;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: renamed from: ILil.Lil.I丨L.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: FastScroller.java */
/* JADX INFO: loaded from: classes.dex */
public class IL extends RecyclerView.Lil implements RecyclerView.iIi1 {

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public static final int[] f1746L111 = {R.attr.state_pressed};

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public static final int[] f1747LLlI1 = new int[0];

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final StateListDrawable f4265I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final int f4266IL1Iii;
    public int ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final int f4267ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public int f1748ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final int f4268Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final Drawable f1749IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final Drawable f1750IiL;
    public final RecyclerView.iIlLiL LL1IL;
    public int Lil;
    public float LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public int f1751Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final int f1752L11I;

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public int f1753LlLLL;
    public RecyclerView iIi1;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final StateListDrawable f1754iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public float f1755lIiI;

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public final Runnable f1756lIII;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final int f1759lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final int f1760il;

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public final ValueAnimator f17631;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public int f1758llL1ii = 0;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public int f1757lIlii = 0;
    public boolean iIlLiL = false;
    public boolean I11li1 = false;

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public int f1761lL = 0;
    public int I11L = 0;
    public final int[] llliI = new int[2];

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public final int[] f1762l = new int[2];

    /* JADX INFO: renamed from: ILil.Lil.I丨L.I丨L$I1I */
    /* JADX INFO: compiled from: FastScroller.java */
    public class I1I extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public boolean f4269IL1Iii = false;

        public I1I() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f4269IL1Iii = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f4269IL1Iii) {
                this.f4269IL1Iii = false;
                return;
            }
            if (((Float) IL.this.f17631.getAnimatedValue()).floatValue() == 0.0f) {
                IL il = IL.this;
                il.f1753LlLLL = 0;
                il.iIi1(0);
            } else {
                IL il2 = IL.this;
                il2.f1753LlLLL = 2;
                il2.LlLI1();
            }
        }
    }

    /* JADX INFO: renamed from: ILil.Lil.I丨L.I丨L$IL1Iii */
    /* JADX INFO: compiled from: FastScroller.java */
    public class IL1Iii implements Runnable {
        public IL1Iii() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IL.this.ILL(500);
        }
    }

    /* JADX INFO: renamed from: ILil.Lil.I丨L.I丨L$ILil */
    /* JADX INFO: compiled from: FastScroller.java */
    public class ILil extends RecyclerView.iIlLiL {
        public ILil() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.iIlLiL
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            IL.this.m2396lL(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    /* JADX INFO: renamed from: ILil.Lil.I丨L.I丨L$I丨L, reason: invalid class name and collision with other inner class name */
    /* JADX INFO: compiled from: FastScroller.java */
    public class C0578IL implements ValueAnimator.AnimatorUpdateListener {
        public C0578IL() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            IL.this.f4265I1I.setAlpha(iFloatValue);
            IL.this.f1749IL.setAlpha(iFloatValue);
            IL.this.LlLI1();
        }
    }

    public IL(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f17631 = valueAnimatorOfFloat;
        this.f1753LlLLL = 0;
        this.f1756lIII = new IL1Iii();
        this.LL1IL = new ILil();
        this.f4265I1I = stateListDrawable;
        this.f1749IL = drawable;
        this.f1754iILLL1 = stateListDrawable2;
        this.f1750IiL = drawable2;
        this.f4268Ilil = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.f1759lLi1LL = Math.max(i, drawable.getIntrinsicWidth());
        this.f1752L11I = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.f1760il = Math.max(i, drawable2.getIntrinsicWidth());
        this.f4266IL1Iii = i2;
        this.f4267ILil = i3;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new I1I());
        valueAnimatorOfFloat.addUpdateListener(new C0578IL());
        m2386IL(recyclerView);
    }

    public final void I11L(float f) {
        int[] iArrM2395il = m2395il();
        float fMax = Math.max(iArrM2395il[0], Math.min(iArrM2395il[1], f));
        if (Math.abs(this.f1751Ll1 - fMax) < 2.0f) {
            return;
        }
        int iM2392lIlii = m2392lIlii(this.f1755lIiI, fMax, iArrM2395il, this.iIi1.computeVerticalScrollRange(), this.iIi1.computeVerticalScrollOffset(), this.f1757lIlii);
        if (iM2392lIlii != 0) {
            this.iIi1.scrollBy(0, iM2392lIlii);
        }
        this.f1755lIiI = fMax;
    }

    public void I11li1() {
        int i = this.f1753LlLLL;
        if (i != 0) {
            if (i != 3) {
                return;
            } else {
                this.f17631.cancel();
            }
        }
        this.f1753LlLLL = 1;
        ValueAnimator valueAnimator = this.f17631;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f17631.setDuration(500L);
        this.f17631.setStartDelay(0L);
        this.f17631.start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.iIi1
    public void I1I(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.iIi1
    public void IL1Iii(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f1761lL == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zLil = Lil(motionEvent.getX(), motionEvent.getY());
            boolean zM2385ILl = m2385ILl(motionEvent.getX(), motionEvent.getY());
            if (zLil || zM2385ILl) {
                if (zM2385ILl) {
                    this.I11L = 1;
                    this.LlLI1 = (int) motionEvent.getX();
                } else if (zLil) {
                    this.I11L = 2;
                    this.f1755lIiI = (int) motionEvent.getY();
                }
                iIi1(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f1761lL == 2) {
            this.f1755lIiI = 0.0f;
            this.LlLI1 = 0.0f;
            iIi1(1);
            this.I11L = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f1761lL == 2) {
            I11li1();
            if (this.I11L == 1) {
                m2388Ll1(motionEvent.getX());
            }
            if (this.I11L == 2) {
                I11L(motionEvent.getY());
            }
        }
    }

    public void ILL(int i) {
        int i2 = this.f1753LlLLL;
        if (i2 == 1) {
            this.f17631.cancel();
        } else if (i2 != 2) {
            return;
        }
        this.f1753LlLLL = 3;
        ValueAnimator valueAnimator = this.f17631;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f17631.setDuration(i);
        this.f17631.start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.iIi1
    public boolean ILil(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i = this.f1761lL;
        if (i == 1) {
            boolean zLil = Lil(motionEvent.getX(), motionEvent.getY());
            boolean zM2385ILl = m2385ILl(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!zLil && !zM2385ILl) {
                return false;
            }
            if (zM2385ILl) {
                this.I11L = 1;
                this.LlLI1 = (int) motionEvent.getX();
            } else if (zLil) {
                this.I11L = 2;
                this.f1755lIiI = (int) motionEvent.getY();
            }
            iIi1(2);
        } else if (i != 2) {
            return false;
        }
        return true;
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public boolean m2385ILl(float f, float f2) {
        if (f2 >= this.f1757lIlii - this.f1752L11I) {
            int i = this.Lil;
            int i2 = this.f1748ILl;
            if (f >= i - (i2 / 2) && f <= i + (i2 / 2)) {
                return true;
            }
        }
        return false;
    }

    public final void Ilil() {
        this.iIi1.removeCallbacks(this.f1756lIII);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m2386IL(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.iIi1;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            m2394lLi1LL();
        }
        this.iIi1 = recyclerView;
        if (recyclerView != null) {
            iIlLiL();
        }
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final void m2387IiL(Canvas canvas) {
        int i = this.f1758llL1ii;
        int i2 = this.f4268Ilil;
        int i3 = i - i2;
        int i4 = this.f1751Ll1;
        int i5 = this.ILL;
        int i6 = i4 - (i5 / 2);
        this.f4265I1I.setBounds(0, 0, i2, i5);
        this.f1749IL.setBounds(0, 0, this.f1759lLi1LL, this.f1757lIlii);
        if (!m2391lIiI()) {
            canvas.translate(i3, 0.0f);
            this.f1749IL.draw(canvas);
            canvas.translate(0.0f, i6);
            this.f4265I1I.draw(canvas);
            canvas.translate(-i3, -i6);
            return;
        }
        this.f1749IL.draw(canvas);
        canvas.translate(this.f4268Ilil, i6);
        canvas.scale(-1.0f, 1.0f);
        this.f4265I1I.draw(canvas);
        canvas.scale(1.0f, 1.0f);
        canvas.translate(-this.f4268Ilil, -i6);
    }

    public boolean Lil(float f, float f2) {
        if (!m2391lIiI() ? f >= this.f1758llL1ii - this.f4268Ilil : f <= this.f4268Ilil / 2) {
            int i = this.f1751Ll1;
            int i2 = this.ILL;
            if (f2 >= i - (i2 / 2) && f2 <= i + (i2 / 2)) {
                return true;
            }
        }
        return false;
    }

    public void LlLI1() {
        this.iIi1.invalidate();
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final void m2388Ll1(float f) {
        int[] iArrM2389L11I = m2389L11I();
        float fMax = Math.max(iArrM2389L11I[0], Math.min(iArrM2389L11I[1], f));
        if (Math.abs(this.Lil - fMax) < 2.0f) {
            return;
        }
        int iM2392lIlii = m2392lIlii(this.LlLI1, fMax, iArrM2389L11I, this.iIi1.computeHorizontalScrollRange(), this.iIi1.computeHorizontalScrollOffset(), this.f1758llL1ii);
        if (iM2392lIlii != 0) {
            this.iIi1.scrollBy(iM2392lIlii, 0);
        }
        this.LlLI1 = fMax;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final int[] m2389L11I() {
        int[] iArr = this.f1762l;
        int i = this.f4267ILil;
        iArr[0] = i;
        iArr[1] = this.f1758llL1ii - i;
        return iArr;
    }

    public void iIi1(int i) {
        if (i == 2 && this.f1761lL != 2) {
            this.f4265I1I.setState(f1746L111);
            Ilil();
        }
        if (i == 0) {
            LlLI1();
        } else {
            I11li1();
        }
        if (this.f1761lL == 2 && i != 2) {
            this.f4265I1I.setState(f1747LLlI1);
            m2393llL1ii(1200);
        } else if (i == 1) {
            m2393llL1ii(1500);
        }
        this.f1761lL = i;
    }

    public final void iIlLiL() {
        this.iIi1.addItemDecoration(this);
        this.iIi1.addOnItemTouchListener(this);
        this.iIi1.addOnScrollListener(this.LL1IL);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final void m2390iILLL1(Canvas canvas) {
        int i = this.f1757lIlii;
        int i2 = this.f1752L11I;
        int i3 = i - i2;
        int i4 = this.Lil;
        int i5 = this.f1748ILl;
        int i6 = i4 - (i5 / 2);
        this.f1754iILLL1.setBounds(0, 0, i5, i2);
        this.f1750IiL.setBounds(0, 0, this.f1758llL1ii, this.f1760il);
        canvas.translate(0.0f, i3);
        this.f1750IiL.draw(canvas);
        canvas.translate(i6, 0.0f);
        this.f1754iILLL1.draw(canvas);
        canvas.translate(-i6, -i3);
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final boolean m2391lIiI() {
        return iIlLiL.m2134l(this.iIi1) == 1;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public final int m2392lIlii(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f2 - f) / i4) * i5);
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public final void m2393llL1ii(int i) {
        Ilil();
        this.iIi1.postDelayed(this.f1756lIII, i);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final void m2394lLi1LL() {
        this.iIi1.removeItemDecoration(this);
        this.iIi1.removeOnItemTouchListener(this);
        this.iIi1.removeOnScrollListener(this.LL1IL);
        Ilil();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Lil
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.C1 c1) {
        if (this.f1758llL1ii != this.iIi1.getWidth() || this.f1757lIlii != this.iIi1.getHeight()) {
            this.f1758llL1ii = this.iIi1.getWidth();
            this.f1757lIlii = this.iIi1.getHeight();
            iIi1(0);
        } else if (this.f1753LlLLL != 0) {
            if (this.iIlLiL) {
                m2387IiL(canvas);
            }
            if (this.I11li1) {
                m2390iILLL1(canvas);
            }
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final int[] m2395il() {
        int[] iArr = this.llliI;
        int i = this.f4267ILil;
        iArr[0] = i;
        iArr[1] = this.f1757lIlii - i;
        return iArr;
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public void m2396lL(int i, int i2) {
        int iComputeVerticalScrollRange = this.iIi1.computeVerticalScrollRange();
        int i3 = this.f1757lIlii;
        this.iIlLiL = iComputeVerticalScrollRange - i3 > 0 && i3 >= this.f4266IL1Iii;
        int iComputeHorizontalScrollRange = this.iIi1.computeHorizontalScrollRange();
        int i4 = this.f1758llL1ii;
        boolean z = iComputeHorizontalScrollRange - i4 > 0 && i4 >= this.f4266IL1Iii;
        this.I11li1 = z;
        boolean z2 = this.iIlLiL;
        if (!z2 && !z) {
            if (this.f1761lL != 0) {
                iIi1(0);
                return;
            }
            return;
        }
        if (z2) {
            float f = i3;
            this.f1751Ll1 = (int) ((f * (i2 + (f / 2.0f))) / iComputeVerticalScrollRange);
            this.ILL = Math.min(i3, (i3 * i3) / iComputeVerticalScrollRange);
        }
        if (this.I11li1) {
            float f2 = i4;
            this.Lil = (int) ((f2 * (i + (f2 / 2.0f))) / iComputeHorizontalScrollRange);
            this.f1748ILl = Math.min(i4, (i4 * i4) / iComputeHorizontalScrollRange);
        }
        int i5 = this.f1761lL;
        if (i5 == 0 || i5 == 1) {
            iIi1(1);
        }
    }
}
