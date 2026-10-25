package androidx.appcompat.widget;

import ILil.ILil.iILLL1;
import ILil.ILil.p023lIlii.C0624ill;
import ILil.ILil.p023lIlii.Lil;
import ILil.ILil.p023lIlii.LlLI1;
import ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl;
import ILil.p028IiL.p029ILl.InterfaceC0632ILl;
import ILil.p028IiL.p029ILl.Ll1;
import ILil.p028IiL.p029ILl.iIlLiL;
import ILil.p028IiL.p029ILl.lIiI;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.OverScroller;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements Lil, InterfaceC0632ILl, Ll1, lIiI {
    public static final int[] LL1IL = {ILil.ILil.IL1Iii.actionBarSize, R.attr.windowContentOverlay};
    public OverScroller I11L;
    public final Rect I11li1;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f4819I1I;
    public boolean ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f4820ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public int f2344ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public ActionBarContainer f4821Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public ContentFrameLayout f2345IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public boolean f2346IiL;
    public final Rect Lil;
    public final Rect LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public boolean f2347Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public boolean f2348L11I;

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public final Runnable f2349LlLLL;
    public final Rect iIi1;
    public final Rect iIlLiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public Drawable f2350iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public int f2351lIiI;

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public final ILil.p028IiL.p029ILl.Lil f2352lIII;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public final Rect f2353lIlii;
    public ViewPropertyAnimator llliI;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public final Rect f2354llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public LlLI1 f2355lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public boolean f2356il;

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public IL f2357lL;

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public final AnimatorListenerAdapter f2358l;

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public final Runnable f23591;

    public class I1I implements Runnable {
        public I1I() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.Lil();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.llliI = actionBarOverlayLayout.f4821Ilil.animate().translationY(-ActionBarOverlayLayout.this.f4821Ilil.getHeight()).setListener(ActionBarOverlayLayout.this.f2358l);
        }
    }

    public class IL1Iii extends AnimatorListenerAdapter {
        public IL1Iii() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.llliI = null;
            actionBarOverlayLayout.f2347Ll1 = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.llliI = null;
            actionBarOverlayLayout.f2347Ll1 = false;
        }
    }

    public class ILil implements Runnable {
        public ILil() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.Lil();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.llliI = actionBarOverlayLayout.f4821Ilil.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f2358l);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$I丨L, reason: invalid class name */
    public interface IL {
        void I1I(boolean z);

        void IL1Iii();

        void ILil();

        void Ilil();

        /* JADX INFO: renamed from: I丨L */
        void mo1659IL();

        /* JADX INFO: renamed from: l丨Li1LL */
        void mo1671lLi1LL(int i);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public final void I11li1() {
        Lil();
        this.f23591.run();
    }

    @Override // ILil.ILil.p023lIlii.Lil
    public void I1I() {
        iIlLiL();
        this.f2355lLi1LL.I1I();
    }

    @Override // ILil.ILil.p023lIlii.Lil
    public void IL1Iii(Menu menu, InterfaceC0628ILl.IL1Iii iL1Iii) {
        iIlLiL();
        this.f2355lLi1LL.IL1Iii(menu, iL1Iii);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final boolean ILL(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (z) {
            int i = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            int i2 = rect.left;
            if (i != i2) {
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i2;
                z5 = true;
            } else {
                z5 = false;
            }
        } else {
            z5 = false;
        }
        if (z2) {
            int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            int i4 = rect.top;
            if (i3 != i4) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i4;
                z5 = true;
            }
        }
        if (z4) {
            int i5 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            int i6 = rect.right;
            if (i5 != i6) {
                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i6;
                z5 = true;
            }
        }
        if (z3) {
            int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            int i8 = rect.bottom;
            if (i7 != i8) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i8;
                return true;
            }
        }
        return z5;
    }

    @Override // ILil.ILil.p023lIlii.Lil
    public boolean ILil() {
        iIlLiL();
        return this.f2355lLi1LL.ILil();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final LlLI1 m3052ILl(View view) {
        if (view instanceof LlLI1) {
            return (LlLI1) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    @Override // ILil.ILil.p023lIlii.Lil
    public boolean Ilil() {
        iIlLiL();
        return this.f2355lLi1LL.Ilil();
    }

    @Override // ILil.ILil.p023lIlii.Lil
    /* JADX INFO: renamed from: I丨L */
    public boolean mo1740IL() {
        iIlLiL();
        return this.f2355lLi1LL.mo1746IL();
    }

    @Override // ILil.ILil.p023lIlii.Lil
    /* JADX INFO: renamed from: I丨iL */
    public void mo1741IiL(int i) {
        iIlLiL();
        if (i == 2) {
            this.f2355lLi1LL.iIi1();
        } else if (i == 5) {
            this.f2355lLi1LL.iIlLiL();
        } else {
            if (i != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    public void Lil() {
        removeCallbacks(this.f23591);
        removeCallbacks(this.f2349LlLLL);
        ViewPropertyAnimator viewPropertyAnimator = this.llliI;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void LlLI1(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(LL1IL);
        this.f4820ILil = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f2350iILLL1 = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f2346IiL = context.getApplicationInfo().targetSdkVersion < 19;
        this.I11L = new OverScroller(context);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // ILil.ILil.p023lIlii.Lil
    /* JADX INFO: renamed from: L丨1丨1丨I */
    public void mo1742L11I() {
        iIlLiL();
        this.f2355lLi1LL.mo1747IiL();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f2350iILLL1 == null || this.f2346IiL) {
            return;
        }
        int bottom = this.f4821Ilil.getVisibility() == 0 ? (int) (this.f4821Ilil.getBottom() + this.f4821Ilil.getTranslationY() + 0.5f) : 0;
        this.f2350iILLL1.setBounds(0, bottom, getWidth(), this.f2350iILLL1.getIntrinsicHeight() + bottom);
        this.f2350iILLL1.draw(canvas);
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        iIlLiL();
        int iM2106L1l = iIlLiL.m2106L1l(this) & 256;
        boolean zILL = ILL(this.f4821Ilil, rect, true, true, false, true);
        this.f2353lIlii.set(rect);
        C0624ill.IL1Iii(this, this.f2353lIlii, this.Lil);
        if (!this.iIi1.equals(this.f2353lIlii)) {
            this.iIi1.set(this.f2353lIlii);
            zILL = true;
        }
        if (!this.LlLI1.equals(this.Lil)) {
            this.LlLI1.set(this.Lil);
            zILL = true;
        }
        if (zILL) {
            requestLayout();
        }
        return true;
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f4821Ilil;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f2352lIII.IL1Iii();
    }

    public CharSequence getTitle() {
        iIlLiL();
        return this.f2355lLi1LL.getTitle();
    }

    public final void iIi1() {
        Lil();
        postDelayed(this.f23591, 600L);
    }

    public void iIlLiL() {
        if (this.f2345IL == null) {
            this.f2345IL = (ContentFrameLayout) findViewById(iILLL1.action_bar_activity_content);
            this.f4821Ilil = (ActionBarContainer) findViewById(iILLL1.action_bar_container);
            this.f2355lLi1LL = m3052ILl(findViewById(iILLL1.action_bar));
        }
    }

    @Override // ILil.ILil.p023lIlii.Lil
    /* JADX INFO: renamed from: iI丨LLL1 */
    public boolean mo1743iILLL1() {
        iIlLiL();
        return this.f2355lLi1LL.mo1750iILLL1();
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public final void m3055lIlii() {
        Lil();
        postDelayed(this.f2349LlLLL, 600L);
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public boolean m3056llL1ii() {
        return this.f2348L11I;
    }

    @Override // ILil.ILil.p023lIlii.Lil
    /* JADX INFO: renamed from: l丨Li1LL */
    public boolean mo1744lLi1LL() {
        iIlLiL();
        return this.f2355lLi1LL.mo1754lLi1LL();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        LlLI1(getContext());
        iIlLiL.m70I1(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Lil();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int measuredHeight;
        iIlLiL();
        measureChildWithMargins(this.f4821Ilil, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.f4821Ilil.getLayoutParams();
        int iMax = Math.max(0, this.f4821Ilil.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
        int iMax2 = Math.max(0, this.f4821Ilil.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f4821Ilil.getMeasuredState());
        boolean z = (iIlLiL.m2106L1l(this) & 256) != 0;
        if (z) {
            measuredHeight = this.f4820ILil;
            if (this.f2356il && this.f4821Ilil.getTabContainer() != null) {
                measuredHeight += this.f4820ILil;
            }
        } else {
            measuredHeight = this.f4821Ilil.getVisibility() != 8 ? this.f4821Ilil.getMeasuredHeight() : 0;
        }
        this.f2354llL1ii.set(this.Lil);
        this.iIlLiL.set(this.f2353lIlii);
        if (this.f2348L11I || z) {
            Rect rect = this.iIlLiL;
            rect.top += measuredHeight;
            rect.bottom += 0;
        } else {
            Rect rect2 = this.f2354llL1ii;
            rect2.top += measuredHeight;
            rect2.bottom += 0;
        }
        ILL(this.f2345IL, this.f2354llL1ii, true, true, true, true);
        if (!this.I11li1.equals(this.iIlLiL)) {
            this.I11li1.set(this.iIlLiL);
            this.f2345IL.IL1Iii(this.iIlLiL);
        }
        measureChildWithMargins(this.f2345IL, i, 0, i2, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.f2345IL.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f2345IL.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
        int iMax4 = Math.max(iMax2, this.f2345IL.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f2345IL.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, ILil.p028IiL.p029ILl.InterfaceC0632ILl
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.ILL || !z) {
            return false;
        }
        if (m3058lL(f, f2)) {
            m3057il();
        } else {
            I11li1();
        }
        this.f2347Ll1 = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, ILil.p028IiL.p029ILl.InterfaceC0632ILl
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, ILil.p028IiL.p029ILl.InterfaceC0632ILl
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // ILil.p028IiL.p029ILl.Ll1
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 0) {
            onNestedPreScroll(view, i, i2, iArr);
        }
    }

    @Override // ILil.p028IiL.p029ILl.lIiI
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        onNestedScroll(view, i, i2, i3, i4, i5);
    }

    @Override // ILil.p028IiL.p029ILl.Ll1
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // ILil.p028IiL.p029ILl.Ll1
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    @Override // ILil.p028IiL.p029ILl.Ll1
    public void onStopNestedScroll(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        iIlLiL();
        int i2 = this.f2344ILl ^ i;
        this.f2344ILl = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        IL il = this.f2357lL;
        if (il != null) {
            il.I1I(!z2);
            if (z || !z2) {
                this.f2357lL.IL1Iii();
            } else {
                this.f2357lL.mo1659IL();
            }
        }
        if ((i2 & 256) == 0 || this.f2357lL == null) {
            return;
        }
        iIlLiL.m70I1(this);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f4819I1I = i;
        IL il = this.f2357lL;
        if (il != null) {
            il.mo1671lLi1LL(i);
        }
    }

    public void setActionBarHideOffset(int i) {
        Lil();
        this.f4821Ilil.setTranslationY(-Math.max(0, Math.min(i, this.f4821Ilil.getHeight())));
    }

    public void setActionBarVisibilityCallback(IL il) {
        this.f2357lL = il;
        if (getWindowToken() != null) {
            this.f2357lL.mo1671lLi1LL(this.f4819I1I);
            int i = this.f2344ILl;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                iIlLiL.m70I1(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f2356il = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.ILL) {
            this.ILL = z;
            if (z) {
                return;
            }
            Lil();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i) {
        iIlLiL();
        this.f2355lLi1LL.setIcon(i);
    }

    public void setLogo(int i) {
        iIlLiL();
        this.f2355lLi1LL.mo1748Ll1(i);
    }

    public void setOverlayMode(boolean z) {
        this.f2348L11I = z;
        this.f2346IiL = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    @Override // ILil.ILil.p023lIlii.Lil
    public void setWindowCallback(Window.Callback callback) {
        iIlLiL();
        this.f2355lLi1LL.setWindowCallback(callback);
    }

    @Override // ILil.ILil.p023lIlii.Lil
    public void setWindowTitle(CharSequence charSequence) {
        iIlLiL();
        this.f2355lLi1LL.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final void m3057il() {
        Lil();
        this.f2349LlLLL.run();
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public final boolean m3058lL(float f, float f2) {
        this.I11L.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.I11L.getFinalY() > this.f4821Ilil.getHeight();
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4819I1I = 0;
        this.Lil = new Rect();
        this.LlLI1 = new Rect();
        this.f2354llL1ii = new Rect();
        this.f2353lIlii = new Rect();
        this.iIi1 = new Rect();
        this.iIlLiL = new Rect();
        this.I11li1 = new Rect();
        this.f2358l = new IL1Iii();
        this.f23591 = new ILil();
        this.f2349LlLLL = new I1I();
        LlLI1(context);
        this.f2352lIII = new ILil.p028IiL.p029ILl.Lil(this);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // ILil.p028IiL.p029ILl.Ll1
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, ILil.p028IiL.p029ILl.InterfaceC0632ILl
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f2352lIII.ILil(view, view2, i);
        this.f2351lIiI = getActionBarHideOffset();
        Lil();
        IL il = this.f2357lL;
        if (il != null) {
            il.Ilil();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, ILil.p028IiL.p029ILl.InterfaceC0632ILl
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f4821Ilil.getVisibility() != 0) {
            return false;
        }
        return this.ILL;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, ILil.p028IiL.p029ILl.InterfaceC0632ILl
    public void onStopNestedScroll(View view) {
        if (this.ILL && !this.f2347Ll1) {
            if (this.f2351lIiI <= this.f4821Ilil.getHeight()) {
                iIi1();
            } else {
                m3055lIlii();
            }
        }
        IL il = this.f2357lL;
        if (il != null) {
            il.ILil();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, ILil.p028IiL.p029ILl.InterfaceC0632ILl
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5 = this.f2351lIiI + i2;
        this.f2351lIiI = i5;
        setActionBarHideOffset(i5);
    }

    public void setIcon(Drawable drawable) {
        iIlLiL();
        this.f2355lLi1LL.setIcon(drawable);
    }
}
