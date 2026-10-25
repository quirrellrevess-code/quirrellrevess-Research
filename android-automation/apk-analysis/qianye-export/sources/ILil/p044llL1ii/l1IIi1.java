package ILil.p044llL1ii;

import ILil.p028IiL.p029ILl.iIlLiL;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;

/* JADX INFO: renamed from: ILil.ll丨L1ii.l1IIi1丨, reason: invalid class name */
/* JADX INFO: compiled from: ViewOverlayApi14.java */
/* JADX INFO: loaded from: classes.dex */
public class l1IIi1 implements iILLl {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public IL1Iii f4439IL1Iii;

    /* JADX INFO: renamed from: ILil.ll丨L1ii.l1IIi1丨$IL1Iii */
    /* JADX INFO: compiled from: ViewOverlayApi14.java */
    public static class IL1Iii extends ViewGroup {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public View f4440I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public ViewGroup f4441ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public l1IIi1 f4442Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public ArrayList<Drawable> f1863IL;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public boolean f1864lLi1LL;

        static {
            try {
                Class cls = Integer.TYPE;
                ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", cls, cls, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        public IL1Iii(Context context, ViewGroup viewGroup, View view, l1IIi1 l1iii1) {
            super(context);
            this.f1863IL = null;
            this.f4441ILil = viewGroup;
            this.f4440I1I = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f4442Ilil = l1iii1;
        }

        public final void I1I() {
            if (this.f1864lLi1LL) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        public void IL1Iii(Drawable drawable) {
            I1I();
            if (this.f1863IL == null) {
                this.f1863IL = new ArrayList<>();
            }
            if (this.f1863IL.contains(drawable)) {
                return;
            }
            this.f1863IL.add(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(this);
        }

        public void ILil(View view) {
            I1I();
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != this.f4441ILil && viewGroup.getParent() != null && iIlLiL.m2099L11(viewGroup)) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f4441ILil.getLocationOnScreen(iArr2);
                    iIlLiL.m2092I1L11L(view, iArr[0] - iArr2[0]);
                    iIlLiL.m2094ILLIi(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view);
        }

        public final void Ilil(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f4441ILil.getLocationOnScreen(iArr2);
            this.f4440I1I.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final void m2570IL() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.f1863IL;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f1864lLi1LL = true;
                    this.f4441ILil.removeView(this);
                }
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.f4441ILil.getLocationOnScreen(iArr);
            this.f4440I1I.getLocationOnScreen(iArr2);
            canvas.translate(iArr2[0] - iArr[0], iArr2[1] - iArr[1]);
            canvas.clipRect(new Rect(0, 0, this.f4440I1I.getWidth(), this.f4440I1I.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f1863IL;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i = 0; i < size; i++) {
                this.f1863IL.get(i).draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public void m2571iILLL1(View view) {
            super.removeView(view);
            m2570IL();
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f4441ILil == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (!(this.f4441ILil instanceof ViewGroup)) {
                invalidate(rect);
                return null;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            int[] iArr2 = new int[2];
            Ilil(iArr2);
            rect.offset(iArr2[0], iArr2[1]);
            return super.invalidateChildInParent(iArr, rect);
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public void m2572lLi1LL(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.f1863IL;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
                m2570IL();
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        @Override // android.view.View
        public boolean verifyDrawable(Drawable drawable) {
            ArrayList<Drawable> arrayList;
            return super.verifyDrawable(drawable) || ((arrayList = this.f1863IL) != null && arrayList.contains(drawable));
        }
    }

    public l1IIi1(Context context, ViewGroup viewGroup, View view) {
        this.f4439IL1Iii = new IL1Iii(context, viewGroup, view, this);
    }

    public static l1IIi1 Ilil(View view) {
        ViewGroup viewGroupM2569lLi1LL = m2569lLi1LL(view);
        if (viewGroupM2569lLi1LL == null) {
            return null;
        }
        int childCount = viewGroupM2569lLi1LL.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroupM2569lLi1LL.getChildAt(i);
            if (childAt instanceof IL1Iii) {
                return ((IL1Iii) childAt).f4442Ilil;
            }
        }
        return new LL1IL(viewGroupM2569lLi1LL.getContext(), viewGroupM2569lLi1LL, view);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static ViewGroup m2569lLi1LL(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    @Override // ILil.p044llL1ii.iILLl
    public void IL1Iii(Drawable drawable) {
        this.f4439IL1Iii.IL1Iii(drawable);
    }

    @Override // ILil.p044llL1ii.iILLl
    public void ILil(Drawable drawable) {
        this.f4439IL1Iii.m2572lLi1LL(drawable);
    }
}
