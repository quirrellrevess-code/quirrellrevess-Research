package androidx.core.widget;

import ILil.p028IiL.Lil.IL;
import ILil.p028IiL.p029ILl.ILL;
import ILil.p028IiL.p029ILl.InterfaceC0634il;
import ILil.p028IiL.p029ILl.LL1IL.I1I;
import ILil.p028IiL.p029ILl.LL1IL.lLi1LL;
import ILil.p028IiL.p029ILl.Lil;
import ILil.p028IiL.p029ILl.iIlLiL;
import ILil.p028IiL.p029ILl.lIiI;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import java.util.ArrayList;
import org.opencv.calib3d.Calib3d;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements lIiI, InterfaceC0634il {
    public SavedState I11L;
    public int I11li1;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final Rect f4983I1I;
    public boolean ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public long f4984ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public boolean f2570ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public EdgeEffect f4985Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public OverScroller f2571IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public boolean f2572IiL;
    public int Lil;
    public int LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public VelocityTracker f2573Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public boolean f2574L11I;

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public ILil f2575LlLLL;
    public final int[] iIi1;
    public final int[] iIlLiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int f2576iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public boolean f2577lIiI;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public int f2578lIlii;
    public final Lil llliI;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public int f2579llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public EdgeEffect f2580lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public View f2581il;

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public int f2582lL;

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public final ILL f2583l;

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public float f25841;

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public static final IL1Iii f2569lIII = new IL1Iii();
    public static final int[] LL1IL = {R.attr.fillViewport};

    public static class IL1Iii extends ILil.p028IiL.p029ILl.IL1Iii {
        @Override // ILil.p028IiL.p029ILl.IL1Iii
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            lLi1LL.IL1Iii(accessibilityEvent, nestedScrollView.getScrollX());
            lLi1LL.ILil(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // ILil.p028IiL.p029ILl.IL1Iii
        public void onInitializeAccessibilityNodeInfo(View view, I1I i1i) {
            int scrollRange;
            super.onInitializeAccessibilityNodeInfo(view, i1i);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            i1i.m2056LIl(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            i1i.m63LL(true);
            if (nestedScrollView.getScrollY() > 0) {
                i1i.IL1Iii(8192);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                i1i.IL1Iii(4096);
            }
        }

        @Override // ILil.p028IiL.p029ILl.IL1Iii
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            if (i == 4096) {
                int iMin = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
                if (iMin == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.llI(0, iMin);
                return true;
            }
            if (i != 8192) {
                return false;
            }
            int iMax = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
            if (iMax == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.llI(0, iMax);
            return true;
        }
    }

    public interface ILil {
        void IL1Iii(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new IL1Iii();

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f4986ILil;

        public static class IL1Iii implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f4986ILil + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f4986ILil);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f4986ILil = parcel.readInt();
        }
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public static boolean I11li1(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && I11li1((View) parent, view2);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static int m3168IL(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        return i2 + i > i3 ? i3 - i2 : i;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f25841 == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f25841 = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f25841;
    }

    public final void I11L(int i, int i2, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f2583l.Ilil(0, scrollY2, 0, i - scrollY2, null, i2, iArr);
    }

    public final boolean I1I() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    public final void IL1Iii() {
        this.f2571IL.abortAnimation();
        m3173L1l(1);
    }

    public boolean ILL(KeyEvent keyEvent) {
        this.f4983I1I.setEmpty();
        if (!I1I()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View viewFindFocus = findFocus();
            if (viewFindFocus == this) {
                viewFindFocus = null;
            }
            View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
            return (viewFindNextFocus == null || viewFindNextFocus == this || !viewFindNextFocus.requestFocus(130)) ? false : true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19) {
            return !keyEvent.isAltPressed() ? ILil(33) : m3169ILl(33);
        }
        if (keyCode == 20) {
            return !keyEvent.isAltPressed() ? ILil(130) : m3169ILl(130);
        }
        if (keyCode != 62) {
            return false;
        }
        m31871(keyEvent.isShiftPressed() ? 33 : 130);
        return false;
    }

    public boolean ILil(int i) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !m3184lL(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m3170IiL(maxScrollAmount);
        } else {
            viewFindNextFocus.getDrawingRect(this.f4983I1I);
            offsetDescendantRectToMyCoords(viewFindNextFocus, this.f4983I1I);
            m3170IiL(Ilil(this.f4983I1I));
            viewFindNextFocus.requestFocus(i);
        }
        if (viewFindFocus == null || !viewFindFocus.isFocused() || !iIlLiL(viewFindFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public boolean m3169ILl(int i) {
        int childCount;
        boolean z = i == 130;
        int height = getHeight();
        Rect rect = this.f4983I1I;
        rect.top = 0;
        rect.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f4983I1I.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f4983I1I;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f4983I1I;
        return LL1IL(i, rect3.top, rect3.bottom);
    }

    public int Ilil(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i2 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i - verticalFadingEdgeLength : i;
        int i3 = rect.bottom;
        if (i3 > i2 && rect.top > scrollY) {
            return Math.min((rect.height() > height ? rect.top - scrollY : rect.bottom - i2) + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i);
        }
        if (rect.top >= scrollY || i3 >= i2) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i2 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final void m3170IiL(int i) {
        if (i != 0) {
            if (this.f2570ILl) {
                m119(0, i);
            } else {
                scrollBy(0, i);
            }
        }
    }

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public final void m3171L111(View view) {
        view.getDrawingRect(this.f4983I1I);
        offsetDescendantRectToMyCoords(view, this.f4983I1I);
        int iIlil = Ilil(this.f4983I1I);
        if (iIlil != 0) {
            scrollBy(0, iIlil);
        }
    }

    public final boolean LL1IL(int i, int i2, int i3) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = height + scrollY;
        boolean z = false;
        boolean z2 = i == 33;
        View viewM3172Ll1 = m3172Ll1(z2, i2, i3);
        if (viewM3172Ll1 == null) {
            viewM3172Ll1 = this;
        }
        if (i2 < scrollY || i3 > i4) {
            m3170IiL(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (viewM3172Ll1 != findFocus()) {
            viewM3172Ll1.requestFocus(i);
        }
        return z;
    }

    public boolean Lil(int i) {
        return this.f2583l.m2029Ll1(i);
    }

    public final boolean LlLI1(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i >= childAt.getLeft() && i < childAt.getRight();
    }

    /* JADX WARN: Code duplicated, block: B:28:0x004f  */
    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final View m3172Ll1(boolean z, int i, int i2) {
        ArrayList focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = (View) focusables.get(i3);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i < bottom && top < i2) {
                boolean z3 = i < top && bottom < i2;
                if (view == null) {
                    view = view2;
                    z2 = z3;
                } else {
                    boolean z4 = (z && top < view.getTop()) || (!z && bottom > view.getBottom());
                    if (z2) {
                        if (z3 && z4) {
                            view = view2;
                        }
                    } else if (z3) {
                        view = view2;
                        z2 = true;
                    } else if (z4) {
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public void m3173L1l(int i) {
        this.f2583l.iIi1(i);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final void m3174L11I() {
        this.ILL = false;
        m3175LlLLL();
        m3173L1l(0);
        EdgeEffect edgeEffect = this.f4985Ilil;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.f2580lLi1LL.onRelease();
        }
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public final void m3175LlLLL() {
        VelocityTracker velocityTracker = this.f2573Ll1;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2573Ll1 = null;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f2571IL.isFinished()) {
            return;
        }
        this.f2571IL.computeScrollOffset();
        int currY = this.f2571IL.getCurrY();
        int i = currY - this.f2582lL;
        this.f2582lL = currY;
        int[] iArr = this.iIlLiL;
        boolean z = true;
        iArr[1] = 0;
        m3182lLi1LL(0, i, iArr, null, 1);
        int i2 = i - this.iIlLiL[1];
        int scrollRange = getScrollRange();
        if (i2 != 0) {
            int scrollY = getScrollY();
            m3185l(0, i2, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i3 = i2 - scrollY2;
            int[] iArr2 = this.iIlLiL;
            iArr2[1] = 0;
            m3176iILLL1(0, scrollY2, 0, i3, this.iIi1, 1, iArr2);
            i2 = i3 - this.iIlLiL[1];
        }
        if (i2 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode != 0 && (overScrollMode != 1 || scrollRange <= 0)) {
                z = false;
            }
            if (z) {
                m3183il();
                if (i2 < 0) {
                    if (this.f4985Ilil.isFinished()) {
                        this.f4985Ilil.onAbsorb((int) this.f2571IL.getCurrVelocity());
                    }
                } else if (this.f2580lLi1LL.isFinished()) {
                    this.f2580lLi1LL.onAbsorb((int) this.f2571IL.getCurrVelocity());
                }
            }
            IL1Iii();
        }
        if (this.f2571IL.isFinished()) {
            return;
        }
        iIlLiL.m2101LIl(this);
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        return scrollY > iMax ? bottom + (scrollY - iMax) : bottom;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || ILL(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f2583l.IL1Iii(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f2583l.ILil(f, f2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return m3182lLi1LL(i, i2, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f2583l.m2035lLi1LL(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        if (this.f4985Ilil != null) {
            int scrollY = getScrollY();
            int paddingLeft2 = 0;
            if (!this.f4985Ilil.isFinished()) {
                int iSave = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int iMin = Math.min(0, scrollY);
                int i = Build.VERSION.SDK_INT;
                if (i < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    paddingLeft = getPaddingLeft() + 0;
                } else {
                    paddingLeft = 0;
                }
                if (i >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    iMin += getPaddingTop();
                }
                canvas.translate(paddingLeft, iMin);
                this.f4985Ilil.setSize(width, height);
                if (this.f4985Ilil.draw(canvas)) {
                    iIlLiL.m2101LIl(this);
                }
                canvas.restoreToCount(iSave);
            }
            if (this.f2580lLi1LL.isFinished()) {
                return;
            }
            int iSave2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int iMax = Math.max(getScrollRange(), scrollY) + height2;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 21 || getClipToPadding()) {
                width2 -= getPaddingLeft() + getPaddingRight();
                paddingLeft2 = 0 + getPaddingLeft();
            }
            if (i2 >= 21 && getClipToPadding()) {
                height2 -= getPaddingTop() + getPaddingBottom();
                iMax -= getPaddingBottom();
            }
            canvas.translate(paddingLeft2 - width2, iMax);
            canvas.rotate(180.0f, width2, 0.0f);
            this.f2580lLi1LL.setSize(width2, height2);
            if (this.f2580lLi1LL.draw(canvas)) {
                iIlLiL.m2101LIl(this);
            }
            canvas.restoreToCount(iSave2);
        }
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.llliI.IL1Iii();
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return Lil(0);
    }

    public final void iIi1() {
        if (this.f2573Ll1 == null) {
            this.f2573Ll1 = VelocityTracker.obtain();
        }
    }

    public final boolean iIlLiL(View view) {
        return !m3184lL(view, 0, getHeight());
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m3176iILLL1(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        this.f2583l.Ilil(i, i2, i3, i4, iArr, i5, iArr2);
    }

    @Override // android.view.View, ILil.p028IiL.p029ILl.InterfaceC0634il
    public boolean isNestedScrollingEnabled() {
        return this.f2583l.m2032lIiI();
    }

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public boolean m3177l1IIi1(int i, int i2) {
        return this.f2583l.m2034llL1ii(i, i2);
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public void m3178lIiI(int i) {
        if (getChildCount() > 0) {
            this.f2571IL.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            m3179lIII(true);
        }
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public final void m3179lIII(boolean z) {
        if (z) {
            m3177l1IIi1(2, 1);
        } else {
            m3173L1l(1);
        }
        this.f2582lL = getScrollY();
        iIlLiL.m2101LIl(this);
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public final void m3180lIlii() {
        this.f2571IL = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(Calib3d.CALIB_TILTED_MODEL);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.Lil = viewConfiguration.getScaledTouchSlop();
        this.LlLI1 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f2579llL1ii = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public final void llI(int i, int i2) {
        m119(i - getScrollX(), i2 - getScrollY());
    }

    public final void llliI(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f2578lIlii) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f2576iILLL1 = (int) motionEvent.getY(i);
            this.f2578lIlii = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.f2573Ll1;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public final void m3181llL1ii() {
        VelocityTracker velocityTracker = this.f2573Ll1;
        if (velocityTracker == null) {
            this.f2573Ll1 = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean m3182lLi1LL(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.f2583l.m2027IL(i, i2, iArr, iArr2, i3);
    }

    @Override // android.view.ViewGroup
    public void measureChild(View view, int i, int i2) {
        view.measure(FrameLayout.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(FrameLayout.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2574L11I = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.ILL) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i = scrollY - verticalScrollFactorCompat;
                if (i < 0) {
                    scrollRange = 0;
                } else if (i <= scrollRange) {
                    scrollRange = i;
                }
                if (scrollRange != scrollY) {
                    super.scrollTo(getScrollX(), scrollRange);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x007d  */
    /* JADX WARN: Code duplicated, block: B:33:0x009b  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.ILL) {
            return true;
        }
        int i = action & 255;
        if (i == 0) {
            int y = (int) motionEvent.getY();
            if (LlLI1((int) motionEvent.getX(), y)) {
                this.f2576iILLL1 = y;
                this.f2578lIlii = motionEvent.getPointerId(0);
                m3181llL1ii();
                this.f2573Ll1.addMovement(motionEvent);
                this.f2571IL.computeScrollOffset();
                this.ILL = !this.f2571IL.isFinished();
                m3177l1IIi1(2, 0);
            } else {
                this.ILL = false;
                m3175LlLLL();
            }
        } else if (i == 1) {
            this.ILL = false;
            this.f2578lIlii = -1;
            m3175LlLLL();
            if (this.f2571IL.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                iIlLiL.m2101LIl(this);
            }
            m3173L1l(0);
        } else if (i == 2) {
            int i2 = this.f2578lIlii;
            if (i2 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i2);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + i2 + " in onInterceptTouchEvent");
                } else {
                    int y2 = (int) motionEvent.getY(iFindPointerIndex);
                    if (Math.abs(y2 - this.f2576iILLL1) > this.Lil && (2 & getNestedScrollAxes()) == 0) {
                        this.ILL = true;
                        this.f2576iILLL1 = y2;
                        iIi1();
                        this.f2573Ll1.addMovement(motionEvent);
                        this.I11li1 = 0;
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
            }
        } else if (i == 3) {
            this.ILL = false;
            this.f2578lIlii = -1;
            m3175LlLLL();
            if (this.f2571IL.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                iIlLiL.m2101LIl(this);
            }
            m3173L1l(0);
        } else if (i == 6) {
            llliI(motionEvent);
        }
        return this.ILL;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int measuredHeight = 0;
        this.f2572IiL = false;
        View view = this.f2581il;
        if (view != null && I11li1(view, this)) {
            m3171L111(this.f2581il);
        }
        this.f2581il = null;
        if (!this.f2574L11I) {
            if (this.I11L != null) {
                scrollTo(getScrollX(), this.I11L.f4986ILil);
                this.I11L = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int iM3168IL = m3168IL(scrollY, paddingTop, measuredHeight);
            if (iM3168IL != scrollY) {
                scrollTo(getScrollX(), iM3168IL);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f2574L11I = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f2577lIiI && View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(FrameLayout.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, Videoio.CAP_OPENNI_IMAGE_GENERATOR));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, ILil.p028IiL.p029ILl.InterfaceC0632ILl
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        dispatchNestedFling(0.0f, f2, true);
        m3178lIiI((int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, ILil.p028IiL.p029ILl.InterfaceC0632ILl
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // ILil.p028IiL.p029ILl.Ll1
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        m3182lLi1LL(i, i2, iArr, null, i3);
    }

    @Override // ILil.p028IiL.p029ILl.lIiI
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        I11L(i4, i5, iArr);
    }

    @Override // ILil.p028IiL.p029ILl.Ll1
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        this.llliI.I1I(view, view2, i, i2);
        m3177l1IIi1(2, i2);
    }

    @Override // android.view.View
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        if (viewFindNextFocus == null || iIlLiL(viewFindNextFocus)) {
            return false;
        }
        return viewFindNextFocus.requestFocus(i, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.I11L = savedState;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4986ILil = getScrollY();
        return savedState;
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        ILil iLil = this.f2575LlLLL;
        if (iLil != null) {
            iLil.IL1Iii(this, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !m3184lL(viewFindFocus, 0, i4)) {
            return;
        }
        viewFindFocus.getDrawingRect(this.f4983I1I);
        offsetDescendantRectToMyCoords(viewFindFocus, this.f4983I1I);
        m3170IiL(Ilil(this.f4983I1I));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, ILil.p028IiL.p029ILl.InterfaceC0632ILl
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    @Override // ILil.p028IiL.p029ILl.Ll1
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    @Override // ILil.p028IiL.p029ILl.Ll1
    public void onStopNestedScroll(View view, int i) {
        this.llliI.m2091IL(view, i);
        m3173L1l(i);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        iIi1();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.I11li1 = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(0.0f, this.I11li1);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f2573Ll1;
                velocityTracker.computeCurrentVelocity(1000, this.f2579llL1ii);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f2578lIlii);
                if (Math.abs(yVelocity) > this.LlLI1) {
                    int i = -yVelocity;
                    float f = i;
                    if (!dispatchNestedPreFling(0.0f, f)) {
                        dispatchNestedFling(0.0f, f, true);
                        m3178lIiI(i);
                    }
                } else if (this.f2571IL.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    iIlLiL.m2101LIl(this);
                }
                this.f2578lIlii = -1;
                m3174L11I();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f2578lIlii);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.f2578lIlii + " in onTouchEvent");
                } else {
                    int y = (int) motionEvent.getY(iFindPointerIndex);
                    int i2 = this.f2576iILLL1 - y;
                    if (m3182lLi1LL(0, i2, this.iIlLiL, this.iIi1, 0)) {
                        i2 -= this.iIlLiL[1];
                        this.I11li1 += this.iIi1[1];
                    }
                    if (!this.ILL && Math.abs(i2) > this.Lil) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.ILL = true;
                        i2 = i2 > 0 ? i2 - this.Lil : i2 + this.Lil;
                    }
                    int i3 = i2;
                    if (this.ILL) {
                        this.f2576iILLL1 = y - this.iIi1[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = getOverScrollMode();
                        boolean z = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                        if (m3185l(0, i3, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !Lil(0)) {
                            this.f2573Ll1.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        int[] iArr = this.iIlLiL;
                        iArr[1] = 0;
                        m3176iILLL1(0, scrollY2, 0, i3 - scrollY2, this.iIi1, 0, iArr);
                        int i4 = this.f2576iILLL1;
                        int[] iArr2 = this.iIi1;
                        this.f2576iILLL1 = i4 - iArr2[1];
                        this.I11li1 += iArr2[1];
                        if (z) {
                            int i5 = i3 - this.iIlLiL[1];
                            m3183il();
                            int i6 = scrollY + i5;
                            if (i6 < 0) {
                                IL.IL1Iii(this.f4985Ilil, i5 / getHeight(), motionEvent.getX(iFindPointerIndex) / getWidth());
                                if (!this.f2580lLi1LL.isFinished()) {
                                    this.f2580lLi1LL.onRelease();
                                }
                            } else if (i6 > scrollRange) {
                                IL.IL1Iii(this.f2580lLi1LL, i5 / getHeight(), 1.0f - (motionEvent.getX(iFindPointerIndex) / getWidth()));
                                if (!this.f4985Ilil.isFinished()) {
                                    this.f4985Ilil.onRelease();
                                }
                            }
                            EdgeEffect edgeEffect = this.f4985Ilil;
                            if (edgeEffect != null && (!edgeEffect.isFinished() || !this.f2580lLi1LL.isFinished())) {
                                iIlLiL.m2101LIl(this);
                            }
                        }
                    }
                }
            } else if (actionMasked == 3) {
                if (this.ILL && getChildCount() > 0 && this.f2571IL.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    iIlLiL.m2101LIl(this);
                }
                this.f2578lIlii = -1;
                m3174L11I();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f2576iILLL1 = (int) motionEvent.getY(actionIndex);
                this.f2578lIlii = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                llliI(motionEvent);
                this.f2576iILLL1 = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f2578lIlii));
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            boolean z2 = !this.f2571IL.isFinished();
            this.ILL = z2;
            if (z2 && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f2571IL.isFinished()) {
                IL1Iii();
            }
            this.f2576iILLL1 = (int) motionEvent.getY();
            this.f2578lIlii = motionEvent.getPointerId(0);
            m3177l1IIi1(2, 0);
        }
        VelocityTracker velocityTracker2 = this.f2573Ll1;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.f2572IiL) {
            this.f2581il = view2;
        } else {
            m3171L111(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m3186LLlI1(rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m3175LlLLL();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f2572IiL = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int iM3168IL = m3168IL(i, width, width2);
            int iM3168IL2 = m3168IL(i2, height, height2);
            if (iM3168IL == getScrollX() && iM3168IL2 == getScrollY()) {
                return;
            }
            super.scrollTo(iM3168IL, iM3168IL2);
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.f2577lIiI) {
            this.f2577lIiI = z;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.f2583l.m2026ILl(z);
    }

    public void setOnScrollChangeListener(ILil iLil) {
        this.f2575LlLLL = iLil;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f2570ILl = z;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return m3177l1IIi1(i, 0);
    }

    @Override // android.view.View, ILil.p028IiL.p029ILl.InterfaceC0634il
    public void stopNestedScroll() {
        m3173L1l(0);
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final void m3183il() {
        if (getOverScrollMode() == 2) {
            this.f4985Ilil = null;
            this.f2580lLi1LL = null;
        } else if (this.f4985Ilil == null) {
            Context context = getContext();
            this.f4985Ilil = new EdgeEffect(context);
            this.f2580lLi1LL = new EdgeEffect(context);
        }
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public final boolean m3184lL(View view, int i, int i2) {
        view.getDrawingRect(this.f4983I1I);
        offsetDescendantRectToMyCoords(view, this.f4983I1I);
        return this.f4983I1I.bottom + i >= getScrollY() && this.f4983I1I.top - i <= getScrollY() + i2;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0057  */
    /* JADX WARN: Code duplicated, block: B:40:0x005a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x005c  */
    /* JADX WARN: Code duplicated, block: B:42:0x005e  */
    /* JADX WARN: Code duplicated, block: B:44:0x0061  */
    /* JADX WARN: Code duplicated, block: B:49:0x0083 A[ADDED_TO_REGION] */
    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public boolean m3185l(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2;
        boolean z3;
        int overScrollMode = getOverScrollMode();
        boolean z4 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z5 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z6 = overScrollMode == 0 || (overScrollMode == 1 && z4);
        boolean z7 = overScrollMode == 0 || (overScrollMode == 1 && z5);
        int i9 = i3 + i;
        int i10 = !z6 ? 0 : i7;
        int i11 = i4 + i2;
        int i12 = !z7 ? 0 : i8;
        int i13 = -i10;
        int i14 = i10 + i5;
        int i15 = -i12;
        int i16 = i12 + i6;
        if (i9 <= i14) {
            if (i9 < i13) {
                i9 = i13;
            } else {
                z2 = false;
            }
            if (i11 > i16) {
                if (i11 < i15) {
                    i11 = i15;
                } else {
                    z3 = false;
                }
                if (z3 && !Lil(1)) {
                    this.f2571IL.springBack(i9, i11, 0, 0, 0, getScrollRange());
                }
                onOverScrolled(i9, i11, z2, z3);
                return !z2 || z3;
            }
            i11 = i16;
            z3 = true;
            if (z3) {
                this.f2571IL.springBack(i9, i11, 0, 0, 0, getScrollRange());
            }
            onOverScrolled(i9, i11, z2, z3);
            if (z2) {
            }
        }
        i9 = i14;
        z2 = true;
        if (i11 > i16) {
            if (i11 < i15) {
                i11 = i15;
            } else {
                z3 = false;
            }
            if (z3) {
                this.f2571IL.springBack(i9, i11, 0, 0, 0, getScrollRange());
            }
            onOverScrolled(i9, i11, z2, z3);
            if (z2) {
            }
        }
        i11 = i16;
        z3 = true;
        if (z3) {
            this.f2571IL.springBack(i9, i11, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i9, i11, z2, z3);
        if (z2) {
        }
    }

    /* JADX INFO: renamed from: 丨丨 */
    public final void m119(int i, int i2) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f4984ILil > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f2571IL.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i2 + scrollY, Math.max(0, height - height2))) - scrollY);
            m3179lIII(false);
        } else {
            if (!this.f2571IL.isFinished()) {
                IL1Iii();
            }
            scrollBy(i, i2);
        }
        this.f4984ILil = AnimationUtils.currentAnimationTimeMillis();
    }

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public final boolean m3186LLlI1(Rect rect, boolean z) {
        int iIlil = Ilil(rect);
        boolean z2 = iIlil != 0;
        if (z2) {
            if (z) {
                scrollBy(0, iIlil);
            } else {
                m119(0, iIlil);
            }
        }
        return z2;
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public boolean m31871(int i) {
        boolean z = i == 130;
        int height = getHeight();
        if (z) {
            this.f4983I1I.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f4983I1I;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f4983I1I.top = getScrollY() - height;
            Rect rect2 = this.f4983I1I;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f4983I1I;
        int i2 = rect3.top;
        int i3 = height + i2;
        rect3.bottom = i3;
        return LL1IL(i, i2, i3);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, ILil.p028IiL.p029ILl.InterfaceC0632ILl
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    @Override // ILil.p028IiL.p029ILl.Ll1
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        I11L(i4, i5, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4983I1I = new Rect();
        this.f2572IiL = true;
        this.f2574L11I = false;
        this.f2581il = null;
        this.ILL = false;
        this.f2570ILl = true;
        this.f2578lIlii = -1;
        this.iIi1 = new int[2];
        this.iIlLiL = new int[2];
        m3180lIlii();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, LL1IL, i, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.llliI = new Lil(this);
        this.f2583l = new ILL(this);
        setNestedScrollingEnabled(true);
        iIlLiL.m75lL(this, f2569lIII);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, ILil.p028IiL.p029ILl.InterfaceC0632ILl
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        I11L(i4, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, ILil.p028IiL.p029ILl.InterfaceC0632ILl
    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, ILil.p028IiL.p029ILl.InterfaceC0632ILl
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        if (getChildCount() <= 0) {
            super.addView(view, i);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
