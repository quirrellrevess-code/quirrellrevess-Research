package androidx.drawerlayout.widget;

import ILil.p028IiL.p029ILl.iIlLiL;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.customview.view.AbsSavedState;
import com.mysql.jdbc.MysqlErrorNumbers;
import java.util.ArrayList;
import java.util.List;
import org.opencv.calib3d.Calib3d;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {

    /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
    public static final boolean f2585L11;

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public static final int[] f2586LIll = {R.attr.colorPrimaryDark};

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public static final int[] f2587ill = {R.attr.layout_gravity};

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public static final boolean f2588;
    public float I11L;
    public List<IL> I11li1;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public float f4987I1I;
    public final lLi1LL ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final I1I f4988ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public boolean f2589ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public int f4989Ilil;

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public Matrix f2590IIi;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f2591IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final ILil.p046il.IL1Iii.I1I f2592IiL;

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public boolean f2593L111;
    public Object LL1IL;
    public int Lil;
    public int LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public int f2594Ll1;

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public final ArrayList<View> f2595L1l;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final ILil.p046il.IL1Iii.I1I f2596L11I;

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public CharSequence f2597LlLLL;
    public boolean iIi1;
    public IL iIlLiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public Paint f2598iILLL1;

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public Drawable f2599l1IIi1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public boolean f2600lIiI;

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public CharSequence f2601lIII;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public int f2602lIlii;
    public Drawable llI;
    public Drawable llliI;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public int f2603llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public float f2604lLi1LL;

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public Rect f2605iILLl;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final lLi1LL f2606il;

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public float f2607lL;

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public Drawable f2608l;

    /* JADX INFO: renamed from: 丨丨 */
    public Drawable f43;

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public Drawable f2609LLlI1;

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public Drawable f26101;

    public static final class I1I extends ILil.p028IiL.p029ILl.IL1Iii {
        @Override // ILil.p028IiL.p029ILl.IL1Iii
        public void onInitializeAccessibilityNodeInfo(View view, ILil.p028IiL.p029ILl.LL1IL.I1I i1i) {
            super.onInitializeAccessibilityNodeInfo(view, i1i);
            if (DrawerLayout.m3189l(view)) {
                return;
            }
            i1i.LI11(null);
        }
    }

    public class IL1Iii implements View.OnApplyWindowInsetsListener {
        public IL1Iii(DrawerLayout drawerLayout) {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((DrawerLayout) view).m3204ill(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    public class ILil extends ILil.p028IiL.p029ILl.IL1Iii {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final Rect f4990IL1Iii = new Rect();

        public ILil() {
        }

        public final void IL1Iii(ILil.p028IiL.p029ILl.LL1IL.I1I i1i, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (DrawerLayout.m3189l(childAt)) {
                    i1i.I1I(childAt);
                }
            }
        }

        public final void ILil(ILil.p028IiL.p029ILl.LL1IL.I1I i1i, ILil.p028IiL.p029ILl.LL1IL.I1I i1i2) {
            Rect rect = this.f4990IL1Iii;
            i1i2.m2060Ll1(rect);
            i1i.m2050ILLIi(rect);
            i1i2.m2074lIiI(rect);
            i1i.m2080li11(rect);
            i1i.m67l(i1i2.m2057LIll());
            i1i.m2083i11LL(i1i2.iIlLiL());
            i1i.m2056LIl(i1i2.Lil());
            i1i.m2068iiIIi11(i1i2.m2077llL1ii());
            i1i.m2082i11i(i1i2.m2055L111());
            i1i.m65iI(i1i2.LL1IL());
            i1i.m66lL(i1i2.m2088LLlI1());
            i1i.l1Lll(i1i2.m69());
            i1i.m2063iI1iI(i1i2.m20891());
            i1i.m2070i1I1I1l(i1i2.m2084iILLl());
            i1i.m2073lIIiIlL(i1i2.llI());
            i1i.IL1Iii(i1i2.m2085il());
        }

        @Override // ILil.p028IiL.p029ILl.IL1Iii
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            View viewM3191ILl = DrawerLayout.this.m3191ILl();
            if (viewM3191ILl == null) {
                return true;
            }
            CharSequence charSequenceM3209llL1ii = DrawerLayout.this.m3209llL1ii(DrawerLayout.this.m3208lIlii(viewM3191ILl));
            if (charSequenceM3209llL1ii == null) {
                return true;
            }
            text.add(charSequenceM3209llL1ii);
            return true;
        }

        @Override // ILil.p028IiL.p029ILl.IL1Iii
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        @Override // ILil.p028IiL.p029ILl.IL1Iii
        public void onInitializeAccessibilityNodeInfo(View view, ILil.p028IiL.p029ILl.LL1IL.I1I i1i) {
            if (DrawerLayout.f2588) {
                super.onInitializeAccessibilityNodeInfo(view, i1i);
            } else {
                ILil.p028IiL.p029ILl.LL1IL.I1I i1iM2044L11 = ILil.p028IiL.p029ILl.LL1IL.I1I.m2044L11(i1i);
                super.onInitializeAccessibilityNodeInfo(view, i1iM2044L11);
                i1i.m681(view);
                Object objM78 = iIlLiL.m78(view);
                if (objM78 instanceof View) {
                    i1i.LI11((View) objM78);
                }
                ILil(i1i, i1iM2044L11);
                i1iM2044L11.m2049IIiI();
                IL1Iii(i1i, (ViewGroup) view);
            }
            i1i.m2056LIl(DrawerLayout.class.getName());
            i1i.m66lL(false);
            i1i.l1Lll(false);
            i1i.m2079lliiI1(ILil.I丨iL.IL丨丨l.LL1IL.I1I.IL1Iii.f4048Ilil);
            i1i.m2079lliiI1(ILil.I丨iL.IL丨丨l.LL1IL.I1I.IL1Iii.f1622lLi1LL);
        }

        @Override // ILil.p028IiL.p029ILl.IL1Iii
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.f2588 || DrawerLayout.m3189l(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: androidx.drawerlayout.widget.DrawerLayout$I丨L, reason: invalid class name */
    public interface IL {
        void I1I(int i);

        void IL1Iii(View view);

        void ILil(View view);

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        void m3216IL(View view, float f);
    }

    /* JADX INFO: renamed from: androidx.drawerlayout.widget.DrawerLayout$l丨Li1LL, reason: invalid class name */
    public class lLi1LL extends ILil.p046il.IL1Iii.I1I.AbstractC0587I1I {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final Runnable f4998I1I = new IL1Iii();

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final int f4999IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public ILil.p046il.IL1Iii.I1I f5000ILil;

        /* JADX INFO: renamed from: androidx.drawerlayout.widget.DrawerLayout$l丨Li1LL$IL1Iii */
        public class IL1Iii implements Runnable {
            public IL1Iii() {
            }

            @Override // java.lang.Runnable
            public void run() {
                lLi1LL.this.ILil();
            }
        }

        public lLi1LL(int i) {
            this.f4999IL1Iii = i;
        }

        public void I1I() {
            DrawerLayout.this.removeCallbacks(this.f4998I1I);
        }

        public final void IL1Iii() {
            View viewM3199Ll1 = DrawerLayout.this.m3199Ll1(this.f4999IL1Iii == 3 ? 5 : 3);
            if (viewM3199Ll1 != null) {
                DrawerLayout.this.m3193IL(viewM3199Ll1);
            }
        }

        public void ILil() {
            View viewM3199Ll1;
            int width;
            int iI11L = this.f5000ILil.I11L();
            boolean z = this.f4999IL1Iii == 3;
            if (z) {
                viewM3199Ll1 = DrawerLayout.this.m3199Ll1(3);
                width = (viewM3199Ll1 != null ? -viewM3199Ll1.getWidth() : 0) + iI11L;
            } else {
                viewM3199Ll1 = DrawerLayout.this.m3199Ll1(5);
                width = DrawerLayout.this.getWidth() - iI11L;
            }
            if (viewM3199Ll1 != null) {
                if (((!z || viewM3199Ll1.getLeft() >= width) && (z || viewM3199Ll1.getLeft() <= width)) || DrawerLayout.this.LlLI1(viewM3199Ll1) != 0) {
                    return;
                }
                LayoutParams layoutParams = (LayoutParams) viewM3199Ll1.getLayoutParams();
                this.f5000ILil.m2735L11(viewM3199Ll1, width, viewM3199Ll1.getTop());
                layoutParams.f4992I1I = true;
                DrawerLayout.this.invalidate();
                IL1Iii();
                DrawerLayout.this.ILil();
            }
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public void m3217IL(ILil.p046il.IL1Iii.I1I i1i) {
            this.f5000ILil = i1i;
        }

        @Override // ILil.p046il.IL1Iii.I1I.AbstractC0587I1I
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            if (DrawerLayout.this.I1I(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        @Override // ILil.p046il.IL1Iii.I1I.AbstractC0587I1I
        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // ILil.p046il.IL1Iii.I1I.AbstractC0587I1I
        public int getViewHorizontalDragRange(View view) {
            if (DrawerLayout.this.m3207lIII(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // ILil.p046il.IL1Iii.I1I.AbstractC0587I1I
        public void onEdgeDragStarted(int i, int i2) {
            View viewM3199Ll1 = (i & 1) == 1 ? DrawerLayout.this.m3199Ll1(3) : DrawerLayout.this.m3199Ll1(5);
            if (viewM3199Ll1 == null || DrawerLayout.this.LlLI1(viewM3199Ll1) != 0) {
                return;
            }
            this.f5000ILil.ILil(viewM3199Ll1, i2);
        }

        @Override // ILil.p046il.IL1Iii.I1I.AbstractC0587I1I
        public boolean onEdgeLock(int i) {
            return false;
        }

        @Override // ILil.p046il.IL1Iii.I1I.AbstractC0587I1I
        public void onEdgeTouched(int i, int i2) {
            DrawerLayout.this.postDelayed(this.f4998I1I, 160L);
        }

        @Override // ILil.p046il.IL1Iii.I1I.AbstractC0587I1I
        public void onViewCaptured(View view, int i) {
            ((LayoutParams) view.getLayoutParams()).f4992I1I = false;
            IL1Iii();
        }

        @Override // ILil.p046il.IL1Iii.I1I.AbstractC0587I1I
        public void onViewDragStateChanged(int i) {
            DrawerLayout.this.m3190IIiI(this.f4999IL1Iii, i, this.f5000ILil.m2753lL());
        }

        @Override // ILil.p046il.IL1Iii.I1I.AbstractC0587I1I
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            int width = view.getWidth();
            float width2 = (DrawerLayout.this.I1I(view, 3) ? i + width : DrawerLayout.this.getWidth() - i) / width;
            DrawerLayout.this.m3195L11(view, width2);
            view.setVisibility(width2 == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        @Override // ILil.p046il.IL1Iii.I1I.AbstractC0587I1I
        public void onViewReleased(View view, float f, float f2) {
            int i;
            float fIIi1 = DrawerLayout.this.iIi1(view);
            int width = view.getWidth();
            if (DrawerLayout.this.I1I(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && fIIi1 > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f < 0.0f || (f == 0.0f && fIIi1 > 0.5f)) {
                    width2 -= width;
                }
                i = width2;
            }
            this.f5000ILil.m2744ill(i, view.getTop());
            DrawerLayout.this.invalidate();
        }

        @Override // ILil.p046il.IL1Iii.I1I.AbstractC0587I1I
        public boolean tryCaptureView(View view, int i) {
            return DrawerLayout.this.m3207lIII(view) && DrawerLayout.this.I1I(view, this.f4999IL1Iii) && DrawerLayout.this.LlLI1(view) == 0;
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        f2588 = i >= 19;
        f2585L11 = i >= 21;
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    public static String I11li1(int i) {
        if ((i & 3) == 3) {
            return "LEFT";
        }
        return (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public static boolean m3188lL(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public static boolean m3189l(View view) {
        return (iIlLiL.I11L(view) == 4 || iIlLiL.I11L(view) == 2) ? false : true;
    }

    public final boolean I11L() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).f4992I1I) {
                return true;
            }
        }
        return false;
    }

    public boolean I1I(View view, int i) {
        return (m3208lIlii(view) & i) == i;
    }

    /* JADX INFO: renamed from: IIi丨丨I, reason: contains not printable characters */
    public void m3190IIiI(int i, int i2, View view) {
        int iM27561 = this.f2592IiL.m27561();
        int iM27562 = this.f2596L11I.m27561();
        int i3 = 2;
        if (iM27561 == 1 || iM27562 == 1) {
            i3 = 1;
        } else if (iM27561 != 2 && iM27562 != 2) {
            i3 = 0;
        }
        if (view != null && i2 == 0) {
            float f = ((LayoutParams) view.getLayoutParams()).f4994ILil;
            if (f == 0.0f) {
                m3194IiL(view);
            } else if (f == 1.0f) {
                m3201L11I(view);
            }
        }
        if (i3 != this.f2594Ll1) {
            this.f2594Ll1 = i3;
            List<IL> list = this.I11li1;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.I11li1.get(size).I1I(i3);
                }
            }
        }
    }

    public void IL1Iii(IL il) {
        if (il == null) {
            return;
        }
        if (this.I11li1 == null) {
            this.I11li1 = new ArrayList();
        }
        this.I11li1.add(il);
    }

    public final boolean ILL(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent motionEventIIlLiL = iIlLiL(motionEvent, view);
            boolean zDispatchGenericMotionEvent = view.dispatchGenericMotionEvent(motionEventIIlLiL);
            motionEventIIlLiL.recycle();
            return zDispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean zDispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return zDispatchGenericMotionEvent2;
    }

    public void ILil() {
        if (this.iIi1) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).dispatchTouchEvent(motionEventObtain);
        }
        motionEventObtain.recycle();
        this.iIi1 = true;
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public View m3191ILl() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m3207lIII(childAt) && LL1IL(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public void Ilil(View view, boolean z) {
        if (!m3207lIII(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.f2589ILl) {
            layoutParams.f4994ILil = 0.0f;
            layoutParams.f2611IL = 0;
        } else if (z) {
            layoutParams.f2611IL |= 4;
            if (I1I(view, 3)) {
                this.f2592IiL.m2735L11(view, -view.getWidth(), view.getTop());
            } else {
                this.f2596L11I.m2735L11(view, getWidth(), view.getTop());
            }
        } else {
            m120(view, 0.0f);
            m3190IIiI(layoutParams.f4993IL1Iii, 0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public final Drawable m3192IIi() {
        int iM2134l = iIlLiL.m2134l(this);
        if (iM2134l == 0) {
            Drawable drawable = this.f43;
            if (drawable != null) {
                m3213LLlI1(drawable, iM2134l);
                return this.f43;
            }
        } else {
            Drawable drawable2 = this.f2609LLlI1;
            if (drawable2 != null) {
                m3213LLlI1(drawable2, iM2134l);
                return this.f2609LLlI1;
            }
        }
        return this.f2599l1IIi1;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m3193IL(View view) {
        Ilil(view, true);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m3194IiL(View view) {
        View rootView;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f2611IL & 1) == 1) {
            layoutParams.f2611IL = 0;
            List<IL> list = this.I11li1;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.I11li1.get(size).ILil(view);
                }
            }
            m3198LlIl(view, false);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
    public void m3195L11(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f == layoutParams.f4994ILil) {
            return;
        }
        layoutParams.f4994ILil = f;
        m3212il(view, f);
    }

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public final boolean m3196L111(float f, float f2, View view) {
        if (this.f2605iILLl == null) {
            this.f2605iILLl = new Rect();
        }
        view.getHitRect(this.f2605iILLl);
        return this.f2605iILLl.contains((int) f, (int) f2);
    }

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public final void m3197LIll() {
        if (f2585L11) {
            return;
        }
        this.f2608l = m3211iILLl();
        this.f26101 = m3192IIi();
    }

    public boolean LL1IL(View view) {
        if (m3207lIII(view)) {
            return ((LayoutParams) view.getLayoutParams()).f4994ILil > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public int Lil(int i) {
        int iM2134l = iIlLiL.m2134l(this);
        if (i == 3) {
            int i2 = this.Lil;
            if (i2 != 3) {
                return i2;
            }
            int i3 = iM2134l == 0 ? this.f2603llL1ii : this.f2602lIlii;
            if (i3 != 3) {
                return i3;
            }
            return 0;
        }
        if (i == 5) {
            int i4 = this.LlLI1;
            if (i4 != 3) {
                return i4;
            }
            int i5 = iM2134l == 0 ? this.f2602lIlii : this.f2603llL1ii;
            if (i5 != 3) {
                return i5;
            }
            return 0;
        }
        if (i == 8388611) {
            int i6 = this.f2603llL1ii;
            if (i6 != 3) {
                return i6;
            }
            int i7 = iM2134l == 0 ? this.Lil : this.LlLI1;
            if (i7 != 3) {
                return i7;
            }
            return 0;
        }
        if (i != 8388613) {
            return 0;
        }
        int i8 = this.f2602lIlii;
        if (i8 != 3) {
            return i8;
        }
        int i9 = iM2134l == 0 ? this.LlLI1 : this.Lil;
        if (i9 != 3) {
            return i9;
        }
        return 0;
    }

    /* JADX INFO: renamed from: LlIl丨, reason: contains not printable characters */
    public final void m3198LlIl(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || m3207lIII(childAt)) && !(z && childAt == view)) {
                iIlLiL.m72LL(childAt, 4);
            } else {
                iIlLiL.m72LL(childAt, 1);
            }
        }
    }

    public int LlLI1(View view) {
        if (m3207lIII(view)) {
            return Lil(((LayoutParams) view.getLayoutParams()).f4993IL1Iii);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public View m3199Ll1(int i) {
        int iILil = ILil.p028IiL.p029ILl.I1I.ILil(i, iIlLiL.m2134l(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((m3208lIlii(childAt) & 7) == iILil) {
                return childAt;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public void m3200L1l(IL il) {
        List<IL> list;
        if (il == null || (list = this.I11li1) == null) {
            return;
        }
        list.remove(il);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public void m3201L11I(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f2611IL & 1) == 0) {
            layoutParams.f2611IL = 1;
            List<IL> list = this.I11li1;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.I11li1.get(size).IL1Iii(view);
                }
            }
            m3198LlIl(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public boolean m3202LlLLL(View view) {
        if (m3207lIII(view)) {
            return (((LayoutParams) view.getLayoutParams()).f2611IL & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (!m3207lIII(childAt)) {
                this.f2595L1l.add(childAt);
            } else if (m3202LlLLL(childAt)) {
                childAt.addFocusables(arrayList, i, i2);
                z = true;
            }
        }
        if (!z) {
            int size = this.f2595L1l.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = this.f2595L1l.get(i4);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i, i2);
                }
            }
        }
        this.f2595L1l.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (m3206lIiI() != null || m3207lIII(view)) {
            iIlLiL.m72LL(view, 4);
        } else {
            iIlLiL.m72LL(view, 1);
        }
        if (f2588) {
            return;
        }
        iIlLiL.m75lL(view, this.f4988ILil);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i = 0; i < childCount; i++) {
            fMax = Math.max(fMax, ((LayoutParams) getChildAt(i).getLayoutParams()).f4994ILil);
        }
        this.f2604lLi1LL = fMax;
        boolean zM2746lIiI = this.f2592IiL.m2746lIiI(true);
        boolean zM2746lIiI2 = this.f2596L11I.m2746lIiI(true);
        if (zM2746lIiI || zM2746lIiI2) {
            iIlLiL.m2101LIl(this);
        }
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f2604lLi1LL <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        for (int i = childCount - 1; i >= 0; i--) {
            View childAt = getChildAt(i);
            if (m3196L111(x, y, childAt) && !m32141(childAt) && ILL(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        int height = getHeight();
        boolean zM32141 = m32141(view);
        int width = getWidth();
        int iSave = canvas.save();
        int i = 0;
        if (zM32141) {
            int childCount = getChildCount();
            int i2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && m3188lL(childAt) && m3207lIII(childAt) && childAt.getHeight() >= height) {
                    if (I1I(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i2) {
                            i2 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i2, 0, width, getHeight());
            i = i2;
        }
        boolean zDrawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(iSave);
        float f = this.f2604lLi1LL;
        if (f > 0.0f && zM32141) {
            int i4 = this.f4989Ilil;
            this.f2598iILLL1.setColor((i4 & 16777215) | (((int) ((((-16777216) & i4) >>> 24) * f)) << 24));
            canvas.drawRect(i, 0.0f, width, getHeight(), this.f2598iILLL1);
        } else if (this.f2608l != null && I1I(view, 3)) {
            int intrinsicWidth = this.f2608l.getIntrinsicWidth();
            int right2 = view.getRight();
            float fMax = Math.max(0.0f, Math.min(right2 / this.f2592IiL.I11L(), 1.0f));
            this.f2608l.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.f2608l.setAlpha((int) (fMax * 255.0f));
            this.f2608l.draw(canvas);
        } else if (this.f26101 != null && I1I(view, 5)) {
            int intrinsicWidth2 = this.f26101.getIntrinsicWidth();
            int left2 = view.getLeft();
            float fMax2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.f2596L11I.I11L(), 1.0f));
            this.f26101.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.f26101.setAlpha((int) (fMax2 * 255.0f));
            this.f26101.draw(canvas);
        }
        return zDrawChild;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public float getDrawerElevation() {
        if (f2585L11) {
            return this.f4987I1I;
        }
        return 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.llliI;
    }

    public float iIi1(View view) {
        return ((LayoutParams) view.getLayoutParams()).f4994ILil;
    }

    public final MotionEvent iIlLiL(MotionEvent motionEvent, View view) {
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(scrollX, scrollY);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.f2590IIi == null) {
                this.f2590IIi = new Matrix();
            }
            matrix.invert(this.f2590IIi);
            motionEventObtain.transform(this.f2590IIi);
        }
        return motionEventObtain;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m3203iILLL1(boolean z) {
        int childCount = getChildCount();
        boolean zM2735L11 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (m3207lIII(childAt) && (!z || layoutParams.f4992I1I)) {
                zM2735L11 |= I1I(childAt, 3) ? this.f2592IiL.m2735L11(childAt, -childAt.getWidth(), childAt.getTop()) : this.f2596L11I.m2735L11(childAt, getWidth(), childAt.getTop());
                layoutParams.f4992I1I = false;
            }
        }
        this.f2606il.I1I();
        this.ILL.I1I();
        if (zM2735L11) {
            invalidate();
        }
    }

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public void m3204ill(Object obj, boolean z) {
        this.LL1IL = obj;
        this.f2593L111 = z;
        setWillNotDraw(!z && getBackground() == null);
        requestLayout();
    }

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public void m3205l1IIi1(View view, boolean z) {
        if (!m3207lIII(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.f2589ILl) {
            layoutParams.f4994ILil = 1.0f;
            layoutParams.f2611IL = 1;
            m3198LlIl(view, true);
        } else if (z) {
            layoutParams.f2611IL |= 2;
            if (I1I(view, 3)) {
                this.f2592IiL.m2735L11(view, 0, view.getTop());
            } else {
                this.f2596L11I.m2735L11(view, getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            m120(view, 1.0f);
            m3190IIiI(layoutParams.f4993IL1Iii, 0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public View m3206lIiI() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((LayoutParams) childAt.getLayoutParams()).f2611IL & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public boolean m3207lIII(View view) {
        int iILil = ILil.p028IiL.p029ILl.I1I.ILil(((LayoutParams) view.getLayoutParams()).f4993IL1Iii, iIlLiL.m2134l(view));
        return ((iILil & 3) == 0 && (iILil & 5) == 0) ? false : true;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public int m3208lIlii(View view) {
        return ILil.p028IiL.p029ILl.I1I.ILil(((LayoutParams) view.getLayoutParams()).f4993IL1Iii, iIlLiL.m2134l(this));
    }

    public void llI(View view) {
        m3205l1IIi1(view, true);
    }

    public final boolean llliI() {
        return m3191ILl() != null;
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public CharSequence m3209llL1ii(int i) {
        int iILil = ILil.p028IiL.p029ILl.I1I.ILil(i, iIlLiL.m2134l(this));
        if (iILil == 3) {
            return this.f2597LlLLL;
        }
        if (iILil == 5) {
            return this.f2601lIII;
        }
        return null;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void m3210lLi1LL() {
        m3203iILLL1(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2589ILl = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2589ILl = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Object obj;
        super.onDraw(canvas);
        if (!this.f2593L111 || this.llliI == null) {
            return;
        }
        int systemWindowInsetTop = (Build.VERSION.SDK_INT < 21 || (obj = this.LL1IL) == null) ? 0 : ((WindowInsets) obj).getSystemWindowInsetTop();
        if (systemWindowInsetTop > 0) {
            this.llliI.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.llliI.draw(canvas);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0031  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View viewIIlLiL;
        int actionMasked = motionEvent.getActionMasked();
        boolean zM2757 = this.f2592IiL.m2757(motionEvent) | this.f2596L11I.m2757(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                m3203iILLL1(true);
                this.iIi1 = false;
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    m3203iILLL1(true);
                    this.iIi1 = false;
                }
            } else if (this.f2592IiL.m2733IL(3)) {
                this.f2606il.I1I();
                this.ILL.I1I();
            }
            z = false;
        } else {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.f2607lL = x;
            this.I11L = y;
            z = this.f2604lLi1LL > 0.0f && (viewIIlLiL = this.f2592IiL.iIlLiL((int) x, (int) y)) != null && m32141(viewIIlLiL);
            this.iIi1 = false;
        }
        return zM2757 || z || I11L() || this.iIi1;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !llliI()) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View viewM3191ILl = m3191ILl();
        if (viewM3191ILl != null && LlLI1(viewM3191ILl) == 0) {
            m3210lLi1LL();
        }
        return viewM3191ILl != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        int i5;
        this.f2600lIiI = true;
        int i6 = i3 - i;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (m32141(childAt)) {
                    int i8 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    childAt.layout(i8, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, childAt.getMeasuredWidth() + i8, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (I1I(childAt, 3)) {
                        float f2 = measuredWidth;
                        i5 = (-measuredWidth) + ((int) (layoutParams.f4994ILil * f2));
                        f = (measuredWidth + i5) / f2;
                    } else {
                        float f3 = measuredWidth;
                        int i9 = i6 - ((int) (layoutParams.f4994ILil * f3));
                        f = (i6 - i9) / f3;
                        i5 = i9;
                    }
                    boolean z2 = f != layoutParams.f4994ILil;
                    int i10 = layoutParams.f4993IL1Iii & 112;
                    if (i10 == 16) {
                        int i11 = i4 - i2;
                        int i12 = (i11 - measuredHeight) / 2;
                        int i13 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        if (i12 < i13) {
                            i12 = i13;
                        } else {
                            int i14 = i12 + measuredHeight;
                            int i15 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                            if (i14 > i11 - i15) {
                                i12 = (i11 - i15) - measuredHeight;
                            }
                        }
                        childAt.layout(i5, i12, measuredWidth + i5, measuredHeight + i12);
                    } else if (i10 != 80) {
                        int i16 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        childAt.layout(i5, i16, measuredWidth + i5, measuredHeight + i16);
                    } else {
                        int i17 = i4 - i2;
                        childAt.layout(i5, (i17 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i5, i17 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                    }
                    if (z2) {
                        m3195L11(childAt, f);
                    }
                    int i18 = layoutParams.f4994ILil > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i18) {
                        childAt.setVisibility(i18);
                    }
                }
            }
        }
        this.f2600lIiI = false;
        this.f2589ILl = false;
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
            if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                size2 = 300;
            }
        }
        setMeasuredDimension(size, size2);
        int i3 = 0;
        boolean z = this.LL1IL != null && iIlLiL.m2133lL(this);
        int iM2134l = iIlLiL.m2134l(this);
        int childCount = getChildCount();
        int i4 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z) {
                    int iILil = ILil.p028IiL.p029ILl.I1I.ILil(layoutParams.f4993IL1Iii, iM2134l);
                    if (iIlLiL.m2133lL(childAt)) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            WindowInsets windowInsetsReplaceSystemWindowInsets = (WindowInsets) this.LL1IL;
                            if (iILil == 3) {
                                windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), i3, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                            } else if (iILil == 5) {
                                windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(i3, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                            }
                            childAt.dispatchApplyWindowInsets(windowInsetsReplaceSystemWindowInsets);
                        }
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        WindowInsets windowInsetsReplaceSystemWindowInsets2 = (WindowInsets) this.LL1IL;
                        if (iILil == 3) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), i3, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        } else if (iILil == 5) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(i3, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (m32141(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, Videoio.CAP_OPENNI_IMAGE_GENERATOR), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, Videoio.CAP_OPENNI_IMAGE_GENERATOR));
                } else {
                    if (!m3207lIII(childAt)) {
                        throw new IllegalStateException("Child " + childAt + " at index " + i4 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                    }
                    if (f2585L11) {
                        float fIIlLiL = iIlLiL.iIlLiL(childAt);
                        float f = this.f4987I1I;
                        if (fIIlLiL != f) {
                            iIlLiL.LI11(childAt, f);
                        }
                    }
                    int iM3208lIlii = m3208lIlii(childAt) & 7;
                    boolean z4 = iM3208lIlii == 3;
                    if ((z4 && z2) || (!z4 && z3)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + I11li1(iM3208lIlii) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                    if (z4) {
                        z2 = true;
                    } else {
                        z3 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i, this.f2591IL + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(i2, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams).height));
                }
            }
            i4++;
            i3 = 0;
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        View viewM3199Ll1;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i = savedState.f4996ILil;
        if (i != 0 && (viewM3199Ll1 = m3199Ll1(i)) != null) {
            llI(viewM3199Ll1);
        }
        int i2 = savedState.f4995I1I;
        if (i2 != 3) {
            m3215(i2, 3);
        }
        int i3 = savedState.f2612IL;
        if (i3 != 3) {
            m3215(i3, 5);
        }
        int i4 = savedState.f4997Ilil;
        if (i4 != 3) {
            m3215(i4, 8388611);
        }
        int i5 = savedState.f2613lLi1LL;
        if (i5 != 3) {
            m3215(i5, 8388613);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        m3197LIll();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            int i2 = layoutParams.f2611IL;
            boolean z = i2 == 1;
            boolean z2 = i2 == 2;
            if (z || z2) {
                savedState.f4996ILil = layoutParams.f4993IL1Iii;
                break;
            }
        }
        savedState.f4995I1I = this.Lil;
        savedState.f2612IL = this.LlLI1;
        savedState.f4997Ilil = this.f2603llL1ii;
        savedState.f2613lLi1LL = this.f2602lIlii;
        return savedState;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005d  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View viewM3206lIiI;
        this.f2592IiL.m2755LLlI1(motionEvent);
        this.f2596L11I.m2755LLlI1(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.f2607lL = x;
            this.I11L = y;
            this.iIi1 = false;
        } else if (action == 1) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            View viewIIlLiL = this.f2592IiL.iIlLiL((int) x2, (int) y2);
            if (viewIIlLiL != null && m32141(viewIIlLiL)) {
                float f = x2 - this.f2607lL;
                float f2 = y2 - this.I11L;
                int iM2754l = this.f2592IiL.m2754l();
                z = (f * f) + (f2 * f2) >= ((float) (iM2754l * iM2754l)) || (viewM3206lIiI = m3206lIiI()) == null || LlLI1(viewM3206lIiI) == 2;
            }
            m3203iILLL1(z);
        } else if (action == 3) {
            m3203iILLL1(true);
            this.iIi1 = false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            m3203iILLL1(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f2600lIiI) {
            return;
        }
        super.requestLayout();
    }

    public void setDrawerElevation(float f) {
        this.f4987I1I = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (m3207lIII(childAt)) {
                iIlLiL.LI11(childAt, this.f4987I1I);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(IL il) {
        IL il2 = this.iIlLiL;
        if (il2 != null) {
            m3200L1l(il2);
        }
        if (il != null) {
            IL1Iii(il);
        }
        this.iIlLiL = il;
    }

    public void setDrawerLockMode(int i) {
        m3215(i, 3);
        m3215(i, 5);
    }

    public void setScrimColor(int i) {
        this.f4989Ilil = i;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.llliI = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.llliI = new ColorDrawable(i);
        invalidate();
    }

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public final Drawable m3211iILLl() {
        int iM2134l = iIlLiL.m2134l(this);
        if (iM2134l == 0) {
            Drawable drawable = this.f2609LLlI1;
            if (drawable != null) {
                m3213LLlI1(drawable, iM2134l);
                return this.f2609LLlI1;
            }
        } else {
            Drawable drawable2 = this.f43;
            if (drawable2 != null) {
                m3213LLlI1(drawable2, iM2134l);
                return this.f43;
            }
        }
        return this.llI;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void m3212il(View view, float f) {
        List<IL> list = this.I11li1;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.I11li1.get(size).m3216IL(view, f);
            }
        }
    }

    /* JADX INFO: renamed from: 丨丨 */
    public void m120(View view, float f) {
        float fIIi1 = iIi1(view);
        float width = view.getWidth();
        int i = ((int) (width * f)) - ((int) (fIIi1 * width));
        if (!I1I(view, 3)) {
            i = -i;
        }
        view.offsetLeftAndRight(i);
        m3195L11(view, f);
    }

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public final boolean m3213LLlI1(Drawable drawable, int i) {
        if (drawable == null || !ILil.p028IiL.p033iILLL1.ILL.IL1Iii.m2251IiL(drawable)) {
            return false;
        }
        ILil.p028IiL.p033iILLL1.ILL.IL1Iii.m2255lIiI(drawable, i);
        return true;
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public boolean m32141(View view) {
        return ((LayoutParams) view.getLayoutParams()).f4993IL1Iii == 0;
    }

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public void m3215(int i, int i2) {
        View viewM3199Ll1;
        int iILil = ILil.p028IiL.p029ILl.I1I.ILil(i2, iIlLiL.m2134l(this));
        if (i2 == 3) {
            this.Lil = i;
        } else if (i2 == 5) {
            this.LlLI1 = i;
        } else if (i2 == 8388611) {
            this.f2603llL1ii = i;
        } else if (i2 == 8388613) {
            this.f2602lIlii = i;
        }
        if (i != 0) {
            (iILil == 3 ? this.f2592IiL : this.f2596L11I).IL1Iii();
        }
        if (i != 1) {
            if (i == 2 && (viewM3199Ll1 = m3199Ll1(iILil)) != null) {
                llI(viewM3199Ll1);
                return;
            }
            return;
        }
        View viewM3199Ll2 = m3199Ll1(iILil);
        if (viewM3199Ll2 != null) {
            m3193IL(viewM3199Ll2);
        }
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4988ILil = new I1I();
        this.f4989Ilil = -1728053248;
        this.f2598iILLL1 = new Paint();
        this.f2589ILl = true;
        this.Lil = 3;
        this.LlLI1 = 3;
        this.f2603llL1ii = 3;
        this.f2602lIlii = 3;
        this.f2609LLlI1 = null;
        this.f43 = null;
        this.llI = null;
        this.f2599l1IIi1 = null;
        setDescendantFocusability(Calib3d.CALIB_TILTED_MODEL);
        float f = getResources().getDisplayMetrics().density;
        this.f2591IL = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        lLi1LL lli1ll = new lLi1LL(3);
        this.f2606il = lli1ll;
        lLi1LL lli1ll2 = new lLi1LL(5);
        this.ILL = lli1ll2;
        ILil.p046il.IL1Iii.I1I i1iM2731ILl = ILil.p046il.IL1Iii.I1I.m2731ILl(this, 1.0f, lli1ll);
        this.f2592IiL = i1iM2731ILl;
        i1iM2731ILl.m2732IIi(1);
        i1iM2731ILl.m2737LIll(f2);
        lli1ll.m3217IL(i1iM2731ILl);
        ILil.p046il.IL1Iii.I1I i1iM2731ILl2 = ILil.p046il.IL1Iii.I1I.m2731ILl(this, 1.0f, lli1ll2);
        this.f2596L11I = i1iM2731ILl2;
        i1iM2731ILl2.m2732IIi(2);
        i1iM2731ILl2.m2737LIll(f2);
        lli1ll2.m3217IL(i1iM2731ILl2);
        setFocusableInTouchMode(true);
        iIlLiL.m72LL(this, 1);
        iIlLiL.m75lL(this, new ILil());
        setMotionEventSplittingEnabled(false);
        if (iIlLiL.m2133lL(this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new IL1Iii(this));
                setSystemUiVisibility(MysqlErrorNumbers.ER_WRONG_NAME_FOR_INDEX);
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f2586LIll);
                try {
                    this.llliI = typedArrayObtainStyledAttributes.getDrawable(0);
                    typedArrayObtainStyledAttributes.recycle();
                } catch (Throwable th) {
                    typedArrayObtainStyledAttributes.recycle();
                    throw th;
                }
            } else {
                this.llliI = null;
            }
        }
        this.f4987I1I = f * 10.0f;
        this.f2595L1l = new ArrayList<>();
    }

    public void setStatusBarBackground(int i) {
        this.llliI = i != 0 ? ILil.p028IiL.p035lLi1LL.IL1Iii.m2321IL(getContext(), i) : null;
        invalidate();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public boolean f4992I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public int f4993IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public float f4994ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int f2611IL;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4993IL1Iii = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f2587ill);
            this.f4993IL1Iii = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f4993IL1Iii = 0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f4993IL1Iii = 0;
            this.f4993IL1Iii = layoutParams.f4993IL1Iii;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f4993IL1Iii = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f4993IL1Iii = 0;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new IL1Iii();

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f4995I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f4996ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int f4997Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int f2612IL;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public int f2613lLi1LL;

        public static class IL1Iii implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: I1I, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f4996ILil = 0;
            this.f4996ILil = parcel.readInt();
            this.f4995I1I = parcel.readInt();
            this.f2612IL = parcel.readInt();
            this.f4997Ilil = parcel.readInt();
            this.f2613lLi1LL = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f4996ILil);
            parcel.writeInt(this.f4995I1I);
            parcel.writeInt(this.f2612IL);
            parcel.writeInt(this.f4997Ilil);
            parcel.writeInt(this.f2613lLi1LL);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.f4996ILil = 0;
        }
    }
}
