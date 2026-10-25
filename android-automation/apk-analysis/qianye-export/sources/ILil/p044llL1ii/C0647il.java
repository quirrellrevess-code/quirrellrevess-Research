package ILil.p044llL1ii;

import ILil.p028IiL.p029ILl.iIlLiL;
import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/* JADX INFO: renamed from: ILil.ll丨L1ii.丨il, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: GhostViewPort.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
public class C0647il extends ViewGroup implements iILLL1 {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public View f4462I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public ViewGroup f4463ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public int f4464Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final View f1874IL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final ViewTreeObserver.OnPreDrawListener f1875iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public Matrix f1876lLi1LL;

    /* JADX INFO: renamed from: ILil.ll丨L1ii.丨il$IL1Iii */
    /* JADX INFO: compiled from: GhostViewPort.java */
    public class IL1Iii implements ViewTreeObserver.OnPreDrawListener {
        public IL1Iii() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            View view;
            iIlLiL.m2101LIl(C0647il.this);
            C0647il c0647il = C0647il.this;
            ViewGroup viewGroup = c0647il.f4463ILil;
            if (viewGroup == null || (view = c0647il.f4462I1I) == null) {
                return true;
            }
            viewGroup.endViewTransition(view);
            iIlLiL.m2101LIl(C0647il.this.f4463ILil);
            C0647il c0647il2 = C0647il.this;
            c0647il2.f4463ILil = null;
            c0647il2.f4462I1I = null;
            return true;
        }
    }

    public C0647il(View view) {
        super(view.getContext());
        this.f1875iILLL1 = new IL1Iii();
        this.f1874IL = view;
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    public static void I1I(View view, ViewGroup viewGroup, Matrix matrix) {
        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
        matrix.reset();
        IIi.m2558il(viewGroup2, matrix);
        matrix.preTranslate(-viewGroup2.getScrollX(), -viewGroup2.getScrollY());
        IIi.ILL(viewGroup, matrix);
    }

    public static C0647il ILil(View view, ViewGroup viewGroup, Matrix matrix) {
        IiL iiL;
        if (!(view.getParent() instanceof ViewGroup)) {
            throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
        }
        IiL iiLILil = IiL.ILil(viewGroup);
        C0647il c0647ilIlil = Ilil(view);
        int i = 0;
        if (c0647ilIlil != null && (iiL = (IiL) c0647ilIlil.getParent()) != iiLILil) {
            i = c0647ilIlil.f4464Ilil;
            iiL.removeView(c0647ilIlil);
            c0647ilIlil = null;
        }
        if (c0647ilIlil == null) {
            if (matrix == null) {
                matrix = new Matrix();
                I1I(view, viewGroup, matrix);
            }
            c0647ilIlil = new C0647il(view);
            c0647ilIlil.m2581IiL(matrix);
            if (iiLILil == null) {
                iiLILil = new IiL(viewGroup);
            } else {
                iiLILil.m2561iILLL1();
            }
            m2578IL(viewGroup, iiLILil);
            m2578IL(viewGroup, c0647ilIlil);
            iiLILil.IL1Iii(c0647ilIlil);
            c0647ilIlil.f4464Ilil = i;
        } else if (matrix != null) {
            c0647ilIlil.m2581IiL(matrix);
        }
        c0647ilIlil.f4464Ilil++;
        return c0647ilIlil;
    }

    public static C0647il Ilil(View view) {
        return (C0647il) view.getTag(llL1ii.ghost_view);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static void m2578IL(View view, View view2) {
        IIi.m2556iILLL1(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static void m2579iILLL1(View view, C0647il c0647il) {
        view.setTag(llL1ii.ghost_view, c0647il);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static void m2580lLi1LL(View view) {
        C0647il c0647ilIlil = Ilil(view);
        if (c0647ilIlil != null) {
            int i = c0647ilIlil.f4464Ilil - 1;
            c0647ilIlil.f4464Ilil = i;
            if (i <= 0) {
                ((IiL) c0647ilIlil.getParent()).removeView(c0647ilIlil);
            }
        }
    }

    @Override // ILil.p044llL1ii.iILLL1
    public void IL1Iii(ViewGroup viewGroup, View view) {
        this.f4463ILil = viewGroup;
        this.f4462I1I = view;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m2581IiL(Matrix matrix) {
        this.f1876lLi1LL = matrix;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m2579iILLL1(this.f1874IL, this);
        this.f1874IL.getViewTreeObserver().addOnPreDrawListener(this.f1875iILLL1);
        IIi.m2555L11I(this.f1874IL, 4);
        if (this.f1874IL.getParent() != null) {
            ((View) this.f1874IL.getParent()).invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f1874IL.getViewTreeObserver().removeOnPreDrawListener(this.f1875iILLL1);
        IIi.m2555L11I(this.f1874IL, 0);
        m2579iILLL1(this.f1874IL, null);
        if (this.f1874IL.getParent() != null) {
            ((View) this.f1874IL.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        ILil.IL1Iii(canvas, true);
        canvas.setMatrix(this.f1876lLi1LL);
        IIi.m2555L11I(this.f1874IL, 0);
        this.f1874IL.invalidate();
        IIi.m2555L11I(this.f1874IL, 4);
        drawChild(canvas, this.f1874IL, getDrawingTime());
        ILil.IL1Iii(canvas, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View, ILil.p044llL1ii.iILLL1
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (Ilil(this.f1874IL) == this) {
            IIi.m2555L11I(this.f1874IL, i == 0 ? 4 : 0);
        }
    }
}
