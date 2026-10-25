package androidx.coordinatorlayout.widget;

import ILil.p028IiL.p029ILl.C0633lIII;
import ILil.p028IiL.p029ILl.Lil;
import ILil.p028IiL.p029ILl.Ll1;
import ILil.p028IiL.p029ILl.LlLI1;
import ILil.p028IiL.p029ILl.iIlLiL;
import ILil.p028IiL.p029ILl.lIiI;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.badge.BadgeDrawable;
import com.mysql.jdbc.MysqlErrorNumbers;
import com.tencent.smtt.sdk.WebView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements Ll1, lIiI {
    public static final Class<?>[] CONSTRUCTOR_PARAMS;
    public static final int EVENT_NESTED_SCROLL = 1;
    public static final int EVENT_PRE_DRAW = 0;
    public static final int EVENT_VIEW_REMOVED = 2;
    public static final String TAG = "CoordinatorLayout";
    public static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR;
    private static final int TYPE_ON_INTERCEPT = 0;
    private static final int TYPE_ON_TOUCH = 1;
    public static final String WIDGET_PACKAGE_NAME;
    public static final ThreadLocal<Map<String, Constructor<Behavior>>> sConstructors;
    private static final ILil.p028IiL.p034lIiI.lLi1LL<Rect> sRectPool;
    private LlLI1 mApplyWindowInsetsListener;
    private final int[] mBehaviorConsumed;
    private View mBehaviorTouchView;
    private final ILil.p040iILLL1.p041IL.IL1Iii<View> mChildDag;
    private final List<View> mDependencySortedChildren;
    private boolean mDisallowInterceptReset;
    private boolean mDrawStatusBarBackground;
    private boolean mIsAttachedToWindow;
    private int[] mKeylines;
    private C0633lIII mLastInsets;
    private boolean mNeedsPreDrawListener;
    private final Lil mNestedScrollingParentHelper;
    private View mNestedScrollingTarget;
    private final int[] mNestedScrollingV2ConsumedCompat;
    public ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    private iILLL1 mOnPreDrawListener;
    private Paint mScrimPaint;
    private Drawable mStatusBarBackground;
    private final List<View> mTempDependenciesList;
    private final List<View> mTempList1;

    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        public static Object getTag(View view) {
            return ((lLi1LL) view.getLayoutParams()).f2546lIlii;
        }

        public static void setTag(View view, Object obj) {
            ((lLi1LL) view.getLayoutParams()).f2546lIlii = obj;
        }

        public boolean blocksInteractionBelow(CoordinatorLayout coordinatorLayout, V v) {
            return getScrimOpacity(coordinatorLayout, v) > 0.0f;
        }

        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        public int getScrimColor(CoordinatorLayout coordinatorLayout, V v) {
            return WebView.NIGHT_MODE_COLOR;
        }

        public float getScrimOpacity(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public C0633lIII onApplyWindowInsets(CoordinatorLayout coordinatorLayout, V v, C0633lIII c0633lIII) {
            return c0633lIII;
        }

        public void onAttachedToLayoutParams(lLi1LL lli1ll) {
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean onNestedFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        @Deprecated
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                onNestedPreScroll(coordinatorLayout, v, view, i, i2, iArr);
            }
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                onNestedScroll(coordinatorLayout, v, view, i, i2, i3, i4);
            }
        }

        @Deprecated
        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                onNestedScrollAccepted(coordinatorLayout, v, view, view2, i);
            }
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                return onStartNestedScroll(coordinatorLayout, v, view, view2, i);
            }
            return false;
        }

        @Deprecated
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            if (i == 0) {
                onStopNestedScroll(coordinatorLayout, v, view);
            }
        }

        public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
            onNestedScroll(coordinatorLayout, v, view, i, i2, i3, i4, i5);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    public @interface I1I {
        Class<? extends Behavior> value();
    }

    public class IL1Iii implements LlLI1 {
        public IL1Iii() {
        }

        @Override // ILil.p028IiL.p029ILl.LlLI1
        public C0633lIII onApplyWindowInsets(View view, C0633lIII c0633lIII) {
            return CoordinatorLayout.this.setWindowInsets(c0633lIII);
        }
    }

    public interface ILil {
        Behavior getBehavior();
    }

    /* JADX INFO: renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$I丨L, reason: invalid class name */
    public class IL implements ViewGroup.OnHierarchyChangeListener {
        public IL() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.onChildViewsChanged(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$I丨iL, reason: invalid class name */
    public static class IiL implements Comparator<View> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            float fM2131iILLl = iIlLiL.m2131iILLl(view);
            float fM2131iILLl2 = iIlLiL.m2131iILLl(view2);
            if (fM2131iILLl > fM2131iILLl2) {
                return -1;
            }
            return fM2131iILLl < fM2131iILLl2 ? 1 : 0;
        }
    }

    /* JADX INFO: renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$iI丨LLL1, reason: invalid class name */
    public class iILLL1 implements ViewTreeObserver.OnPreDrawListener {
        public iILLL1() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.onChildViewsChanged(0);
            return true;
        }
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        WIDGET_PACKAGE_NAME = r0 != null ? r0.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            TOP_SORTED_CHILDREN_COMPARATOR = new IiL();
        } else {
            TOP_SORTED_CHILDREN_COMPARATOR = null;
        }
        CONSTRUCTOR_PARAMS = new Class[]{Context.class, AttributeSet.class};
        sConstructors = new ThreadLocal<>();
        sRectPool = new ILil.p028IiL.p034lIiI.IiL(12);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    private static Rect acquireTempRect() {
        Rect rectILil = sRectPool.ILil();
        return rectILil == null ? new Rect() : rectILil;
    }

    private static int clamp(int i, int i2, int i3) {
        if (i < i2) {
            return i2;
        }
        return i > i3 ? i3 : i;
    }

    private void constrainChildRect(lLi1LL lli1ll, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) lli1ll).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - ((ViewGroup.MarginLayoutParams) lli1ll).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) lli1ll).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - ((ViewGroup.MarginLayoutParams) lli1ll).bottomMargin));
        rect.set(iMax, iMax2, i + iMax, i2 + iMax2);
    }

    private C0633lIII dispatchApplyWindowInsetsToBehaviors(C0633lIII c0633lIII) {
        Behavior behaviorM3155lLi1LL;
        if (c0633lIII.m2156iILLL1()) {
            return c0633lIII;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (iIlLiL.m2133lL(childAt) && (behaviorM3155lLi1LL = ((lLi1LL) childAt.getLayoutParams()).m3155lLi1LL()) != null) {
                c0633lIII = behaviorM3155lLi1LL.onApplyWindowInsets(this, childAt, c0633lIII);
                if (c0633lIII.m2156iILLL1()) {
                    break;
                }
            }
        }
        return c0633lIII;
    }

    private void getDesiredAnchoredChildRectWithoutConstraints(View view, int i, Rect rect, Rect rect2, lLi1LL lli1ll, int i2, int i3) {
        int iWidth;
        int iHeight;
        int iILil = ILil.p028IiL.p029ILl.I1I.ILil(resolveAnchoredChildGravity(lli1ll.f4943I1I), i);
        int iILil2 = ILil.p028IiL.p029ILl.I1I.ILil(resolveGravity(lli1ll.f2540IL), i);
        int i4 = iILil & 7;
        int i5 = iILil & 112;
        int i6 = iILil2 & 7;
        int i7 = iILil2 & 112;
        if (i6 != 1) {
            iWidth = i6 != 5 ? rect.left : rect.right;
        } else {
            iWidth = rect.left + (rect.width() / 2);
        }
        if (i7 != 16) {
            iHeight = i7 != 80 ? rect.top : rect.bottom;
        } else {
            iHeight = rect.top + (rect.height() / 2);
        }
        if (i4 == 1) {
            iWidth -= i2 / 2;
        } else if (i4 != 5) {
            iWidth -= i2;
        }
        if (i5 == 16) {
            iHeight -= i3 / 2;
        } else if (i5 != 80) {
            iHeight -= i3;
        }
        rect2.set(iWidth, iHeight, i2 + iWidth, i3 + iHeight);
    }

    private int getKeyline(int i) {
        int[] iArr = this.mKeylines;
        if (iArr == null) {
            Log.e(TAG, "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        }
        if (i >= 0 && i < iArr.length) {
            return iArr[i];
        }
        Log.e(TAG, "Keyline index " + i + " out of range for " + this);
        return 0;
    }

    private void getTopSortedChildren(List<View> list) {
        list.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            list.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
        }
        Comparator<View> comparator = TOP_SORTED_CHILDREN_COMPARATOR;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean hasDependencies(View view) {
        return this.mChildDag.m2493il(view);
    }

    private void layoutChild(View view, int i) {
        lLi1LL lli1ll = (lLi1LL) view.getLayoutParams();
        Rect rectAcquireTempRect = acquireTempRect();
        rectAcquireTempRect.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) lli1ll).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) lli1ll).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) lli1ll).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) lli1ll).bottomMargin);
        if (this.mLastInsets != null && iIlLiL.m2133lL(this) && !iIlLiL.m2133lL(view)) {
            rectAcquireTempRect.left += this.mLastInsets.I1I();
            rectAcquireTempRect.top += this.mLastInsets.Ilil();
            rectAcquireTempRect.right -= this.mLastInsets.m2154IL();
            rectAcquireTempRect.bottom -= this.mLastInsets.ILil();
        }
        Rect rectAcquireTempRect2 = acquireTempRect();
        ILil.p028IiL.p029ILl.I1I.IL1Iii(resolveGravity(lli1ll.f4943I1I), view.getMeasuredWidth(), view.getMeasuredHeight(), rectAcquireTempRect, rectAcquireTempRect2, i);
        view.layout(rectAcquireTempRect2.left, rectAcquireTempRect2.top, rectAcquireTempRect2.right, rectAcquireTempRect2.bottom);
        releaseTempRect(rectAcquireTempRect);
        releaseTempRect(rectAcquireTempRect2);
    }

    private void layoutChildWithAnchor(View view, View view2, int i) {
        Rect rectAcquireTempRect = acquireTempRect();
        Rect rectAcquireTempRect2 = acquireTempRect();
        try {
            getDescendantRect(view2, rectAcquireTempRect);
            getDesiredAnchoredChildRect(view, i, rectAcquireTempRect, rectAcquireTempRect2);
            view.layout(rectAcquireTempRect2.left, rectAcquireTempRect2.top, rectAcquireTempRect2.right, rectAcquireTempRect2.bottom);
        } finally {
            releaseTempRect(rectAcquireTempRect);
            releaseTempRect(rectAcquireTempRect2);
        }
    }

    private void layoutChildWithKeyline(View view, int i, int i2) {
        lLi1LL lli1ll = (lLi1LL) view.getLayoutParams();
        int iILil = ILil.p028IiL.p029ILl.I1I.ILil(resolveKeylineGravity(lli1ll.f4943I1I), i2);
        int i3 = iILil & 7;
        int i4 = iILil & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int keyline = getKeyline(i) - measuredWidth;
        int i5 = 0;
        if (i3 == 1) {
            keyline += measuredWidth / 2;
        } else if (i3 == 5) {
            keyline += measuredWidth;
        }
        if (i4 == 16) {
            i5 = 0 + (measuredHeight / 2);
        } else if (i4 == 80) {
            i5 = measuredHeight + 0;
        }
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) lli1ll).leftMargin, Math.min(keyline, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) lli1ll).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) lli1ll).topMargin, Math.min(i5, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) lli1ll).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth + iMax, measuredHeight + iMax2);
    }

    private void offsetChildByInset(View view, Rect rect, int i) {
        boolean z;
        boolean z2;
        int width;
        int i2;
        int i3;
        int i4;
        int height;
        int i5;
        int i6;
        int i7;
        if (iIlLiL.m2103LlIl(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            lLi1LL lli1ll = (lLi1LL) view.getLayoutParams();
            Behavior behaviorM3155lLi1LL = lli1ll.m3155lLi1LL();
            Rect rectAcquireTempRect = acquireTempRect();
            Rect rectAcquireTempRect2 = acquireTempRect();
            rectAcquireTempRect2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (behaviorM3155lLi1LL == null || !behaviorM3155lLi1LL.getInsetDodgeRect(this, view, rectAcquireTempRect)) {
                rectAcquireTempRect.set(rectAcquireTempRect2);
            } else if (!rectAcquireTempRect2.contains(rectAcquireTempRect)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + rectAcquireTempRect.toShortString() + " | Bounds:" + rectAcquireTempRect2.toShortString());
            }
            releaseTempRect(rectAcquireTempRect2);
            if (rectAcquireTempRect.isEmpty()) {
                releaseTempRect(rectAcquireTempRect);
                return;
            }
            int iILil = ILil.p028IiL.p029ILl.I1I.ILil(lli1ll.f2541IiL, i);
            boolean z3 = true;
            if ((iILil & 48) != 48 || (i6 = (rectAcquireTempRect.top - ((ViewGroup.MarginLayoutParams) lli1ll).topMargin) - lli1ll.f2549il) >= (i7 = rect.top)) {
                z = false;
            } else {
                setInsetOffsetY(view, i7 - i6);
                z = true;
            }
            if ((iILil & 80) == 80 && (height = ((getHeight() - rectAcquireTempRect.bottom) - ((ViewGroup.MarginLayoutParams) lli1ll).bottomMargin) + lli1ll.f2549il) < (i5 = rect.bottom)) {
                setInsetOffsetY(view, height - i5);
                z = true;
            }
            if (!z) {
                setInsetOffsetY(view, 0);
            }
            if ((iILil & 3) != 3 || (i3 = (rectAcquireTempRect.left - ((ViewGroup.MarginLayoutParams) lli1ll).leftMargin) - lli1ll.f2543L11I) >= (i4 = rect.left)) {
                z2 = false;
            } else {
                setInsetOffsetX(view, i4 - i3);
                z2 = true;
            }
            if ((iILil & 5) != 5 || (width = ((getWidth() - rectAcquireTempRect.right) - ((ViewGroup.MarginLayoutParams) lli1ll).rightMargin) + lli1ll.f2543L11I) >= (i2 = rect.right)) {
                z3 = z2;
            } else {
                setInsetOffsetX(view, width - i2);
            }
            if (!z3) {
                setInsetOffsetX(view, 0);
            }
            releaseTempRect(rectAcquireTempRect);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Behavior parseBehavior(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = WIDGET_PACKAGE_NAME;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal<Map<String, Constructor<Behavior>>> threadLocal = sConstructors;
            Map<String, Constructor<Behavior>> map = threadLocal.get();
            if (map == null) {
                map = new HashMap<>();
                threadLocal.set(map);
            }
            Constructor<Behavior> constructor = map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(CONSTRUCTOR_PARAMS);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return constructor.newInstance(context, attributeSet);
        } catch (Exception e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    private boolean performIntercept(MotionEvent motionEvent, int i) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.mTempList1;
        getTopSortedChildren(list);
        int size = list.size();
        MotionEvent motionEventObtain = null;
        boolean zOnInterceptTouchEvent = false;
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            View view = list.get(i2);
            lLi1LL lli1ll = (lLi1LL) view.getLayoutParams();
            Behavior behaviorM3155lLi1LL = lli1ll.m3155lLi1LL();
            if (!(zOnInterceptTouchEvent || z) || actionMasked == 0) {
                if (!zOnInterceptTouchEvent && behaviorM3155lLi1LL != null) {
                    if (i == 0) {
                        zOnInterceptTouchEvent = behaviorM3155lLi1LL.onInterceptTouchEvent(this, view, motionEvent);
                    } else if (i == 1) {
                        zOnInterceptTouchEvent = behaviorM3155lLi1LL.onTouchEvent(this, view, motionEvent);
                    }
                    if (zOnInterceptTouchEvent) {
                        this.mBehaviorTouchView = view;
                    }
                }
                boolean zI1I = lli1ll.I1I();
                boolean zM3150L11I = lli1ll.m3150L11I(this, view);
                z = zM3150L11I && !zI1I;
                if (zM3150L11I && !z) {
                    break;
                }
            } else if (behaviorM3155lLi1LL != null) {
                if (motionEventObtain == null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i == 0) {
                    behaviorM3155lLi1LL.onInterceptTouchEvent(this, view, motionEventObtain);
                } else if (i == 1) {
                    behaviorM3155lLi1LL.onTouchEvent(this, view, motionEventObtain);
                }
            }
        }
        list.clear();
        return zOnInterceptTouchEvent;
    }

    private void prepareChildren() {
        this.mDependencySortedChildren.clear();
        this.mChildDag.I1I();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            lLi1LL resolvedLayoutParams = getResolvedLayoutParams(childAt);
            resolvedLayoutParams.m3147IL(this, childAt);
            this.mChildDag.ILil(childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != i) {
                    View childAt2 = getChildAt(i2);
                    if (resolvedLayoutParams.ILil(this, childAt, childAt2)) {
                        if (!this.mChildDag.m2488IL(childAt2)) {
                            this.mChildDag.ILil(childAt2);
                        }
                        this.mChildDag.IL1Iii(childAt2, childAt);
                    }
                }
            }
        }
        this.mDependencySortedChildren.addAll(this.mChildDag.m2490L11I());
        Collections.reverse(this.mDependencySortedChildren);
    }

    private static void releaseTempRect(Rect rect) {
        rect.setEmpty();
        sRectPool.IL1Iii(rect);
    }

    private void resetTouchBehaviors(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Behavior behaviorM3155lLi1LL = ((lLi1LL) childAt.getLayoutParams()).m3155lLi1LL();
            if (behaviorM3155lLi1LL != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    behaviorM3155lLi1LL.onInterceptTouchEvent(this, childAt, motionEventObtain);
                } else {
                    behaviorM3155lLi1LL.onTouchEvent(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((lLi1LL) getChildAt(i2).getLayoutParams()).m3152lIiI();
        }
        this.mBehaviorTouchView = null;
        this.mDisallowInterceptReset = false;
    }

    private static int resolveAnchoredChildGravity(int i) {
        if (i == 0) {
            return 17;
        }
        return i;
    }

    private static int resolveGravity(int i) {
        if ((i & 7) == 0) {
            i |= 8388611;
        }
        return (i & 112) == 0 ? i | 48 : i;
    }

    private static int resolveKeylineGravity(int i) {
        return i == 0 ? BadgeDrawable.TOP_END : i;
    }

    private void setInsetOffsetX(View view, int i) {
        lLi1LL lli1ll = (lLi1LL) view.getLayoutParams();
        int i2 = lli1ll.f2543L11I;
        if (i2 != i) {
            iIlLiL.m2092I1L11L(view, i - i2);
            lli1ll.f2543L11I = i;
        }
    }

    private void setInsetOffsetY(View view, int i) {
        lLi1LL lli1ll = (lLi1LL) view.getLayoutParams();
        int i2 = lli1ll.f2549il;
        if (i2 != i) {
            iIlLiL.m2094ILLIi(view, i - i2);
            lli1ll.f2549il = i;
        }
    }

    private void setupForInsets() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (!iIlLiL.m2133lL(this)) {
            iIlLiL.m2111iI1LI(this, null);
            return;
        }
        if (this.mApplyWindowInsetsListener == null) {
            this.mApplyWindowInsetsListener = new IL1Iii();
        }
        iIlLiL.m2111iI1LI(this, this.mApplyWindowInsetsListener);
        setSystemUiVisibility(MysqlErrorNumbers.ER_WRONG_NAME_FOR_INDEX);
    }

    public void addPreDrawListener() {
        if (this.mIsAttachedToWindow) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new iILLL1();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = true;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof lLi1LL) && super.checkLayoutParams(layoutParams);
    }

    public void dispatchDependentViewsChanged(View view) {
        List listM2491iILLL1 = this.mChildDag.m2491iILLL1(view);
        if (listM2491iILLL1 == null || listM2491iILLL1.isEmpty()) {
            return;
        }
        for (int i = 0; i < listM2491iILLL1.size(); i++) {
            View view2 = (View) listM2491iILLL1.get(i);
            Behavior behaviorM3155lLi1LL = ((lLi1LL) view2.getLayoutParams()).m3155lLi1LL();
            if (behaviorM3155lLi1LL != null) {
                behaviorM3155lLi1LL.onDependentViewChanged(this, view2, view);
            }
        }
    }

    public boolean doViewsOverlap(View view, View view2) {
        boolean z = false;
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        Rect rectAcquireTempRect = acquireTempRect();
        getChildRect(view, view.getParent() != this, rectAcquireTempRect);
        Rect rectAcquireTempRect2 = acquireTempRect();
        getChildRect(view2, view2.getParent() != this, rectAcquireTempRect2);
        try {
            if (rectAcquireTempRect.left <= rectAcquireTempRect2.right && rectAcquireTempRect.top <= rectAcquireTempRect2.bottom && rectAcquireTempRect.right >= rectAcquireTempRect2.left && rectAcquireTempRect.bottom >= rectAcquireTempRect2.top) {
                z = true;
            }
            return z;
        } finally {
            releaseTempRect(rectAcquireTempRect);
            releaseTempRect(rectAcquireTempRect2);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        lLi1LL lli1ll = (lLi1LL) view.getLayoutParams();
        Behavior behavior = lli1ll.f4944IL1Iii;
        if (behavior != null) {
            float scrimOpacity = behavior.getScrimOpacity(this, view);
            if (scrimOpacity > 0.0f) {
                if (this.mScrimPaint == null) {
                    this.mScrimPaint = new Paint();
                }
                this.mScrimPaint.setColor(lli1ll.f4944IL1Iii.getScrimColor(this, view));
                this.mScrimPaint.setAlpha(clamp(Math.round(scrimOpacity * 255.0f), 0, 255));
                int iSave = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.mScrimPaint);
                canvas.restoreToCount(iSave);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mStatusBarBackground;
        boolean state = false;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    public void ensurePreDrawListener() {
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            if (hasDependencies(getChildAt(i))) {
                z = true;
                break;
            }
        }
        if (z != this.mNeedsPreDrawListener) {
            if (z) {
                addPreDrawListener();
            } else {
                removePreDrawListener();
            }
        }
    }

    public void getChildRect(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            getDescendantRect(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public List<View> getDependencies(View view) {
        List<View> listM2489IiL = this.mChildDag.m2489IiL(view);
        this.mTempDependenciesList.clear();
        if (listM2489IiL != null) {
            this.mTempDependenciesList.addAll(listM2489IiL);
        }
        return this.mTempDependenciesList;
    }

    public final List<View> getDependencySortedChildren() {
        prepareChildren();
        return Collections.unmodifiableList(this.mDependencySortedChildren);
    }

    public List<View> getDependents(View view) {
        List listM2491iILLL1 = this.mChildDag.m2491iILLL1(view);
        this.mTempDependenciesList.clear();
        if (listM2491iILLL1 != null) {
            this.mTempDependenciesList.addAll(listM2491iILLL1);
        }
        return this.mTempDependenciesList;
    }

    public void getDescendantRect(View view, Rect rect) {
        ILil.p040iILLL1.p041IL.ILil.IL1Iii(this, view, rect);
    }

    public void getDesiredAnchoredChildRect(View view, int i, Rect rect, Rect rect2) {
        lLi1LL lli1ll = (lLi1LL) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        getDesiredAnchoredChildRectWithoutConstraints(view, i, rect, rect2, lli1ll, measuredWidth, measuredHeight);
        constrainChildRect(lli1ll, rect2, measuredWidth, measuredHeight);
    }

    public void getLastChildRect(View view, Rect rect) {
        rect.set(((lLi1LL) view.getLayoutParams()).m3148IiL());
    }

    public final C0633lIII getLastWindowInsets() {
        return this.mLastInsets;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.IL1Iii();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public lLi1LL getResolvedLayoutParams(View view) {
        lLi1LL lli1ll = (lLi1LL) view.getLayoutParams();
        if (!lli1ll.f4945ILil) {
            if (view instanceof ILil) {
                Behavior behavior = ((ILil) view).getBehavior();
                if (behavior == null) {
                    Log.e(TAG, "Attached behavior class is null");
                }
                lli1ll.Lil(behavior);
                lli1ll.f4945ILil = true;
            } else {
                I1I i1i = null;
                for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                    i1i = (I1I) superclass.getAnnotation(I1I.class);
                    if (i1i != null) {
                        break;
                    }
                }
                if (i1i != null) {
                    try {
                        lli1ll.Lil(i1i.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e) {
                        Log.e(TAG, "Default behavior class " + i1i.value().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                    }
                }
                lli1ll.f4945ILil = true;
            }
        }
        return lli1ll;
    }

    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public boolean isPointInChildBounds(View view, int i, int i2) {
        Rect rectAcquireTempRect = acquireTempRect();
        getDescendantRect(view, rectAcquireTempRect);
        try {
            return rectAcquireTempRect.contains(i, i2);
        } finally {
            releaseTempRect(rectAcquireTempRect);
        }
    }

    public void offsetChildToAnchor(View view, int i) {
        Behavior behaviorM3155lLi1LL;
        lLi1LL lli1ll = (lLi1LL) view.getLayoutParams();
        if (lli1ll.ILL != null) {
            Rect rectAcquireTempRect = acquireTempRect();
            Rect rectAcquireTempRect2 = acquireTempRect();
            Rect rectAcquireTempRect3 = acquireTempRect();
            getDescendantRect(lli1ll.ILL, rectAcquireTempRect);
            getChildRect(view, false, rectAcquireTempRect2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            getDesiredAnchoredChildRectWithoutConstraints(view, i, rectAcquireTempRect, rectAcquireTempRect3, lli1ll, measuredWidth, measuredHeight);
            boolean z = (rectAcquireTempRect3.left == rectAcquireTempRect2.left && rectAcquireTempRect3.top == rectAcquireTempRect2.top) ? false : true;
            constrainChildRect(lli1ll, rectAcquireTempRect3, measuredWidth, measuredHeight);
            int i2 = rectAcquireTempRect3.left - rectAcquireTempRect2.left;
            int i3 = rectAcquireTempRect3.top - rectAcquireTempRect2.top;
            if (i2 != 0) {
                iIlLiL.m2092I1L11L(view, i2);
            }
            if (i3 != 0) {
                iIlLiL.m2094ILLIi(view, i3);
            }
            if (z && (behaviorM3155lLi1LL = lli1ll.m3155lLi1LL()) != null) {
                behaviorM3155lLi1LL.onDependentViewChanged(this, view, lli1ll.ILL);
            }
            releaseTempRect(rectAcquireTempRect);
            releaseTempRect(rectAcquireTempRect2);
            releaseTempRect(rectAcquireTempRect3);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new iILLL1();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        if (this.mLastInsets == null && iIlLiL.m2133lL(this)) {
            iIlLiL.m70I1(this);
        }
        this.mIsAttachedToWindow = true;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00ca  */
    public final void onChildViewsChanged(int i) {
        int i2;
        Behavior behaviorM3155lLi1LL;
        boolean zOnDependentViewChanged;
        int iM2134l = iIlLiL.m2134l(this);
        int size = this.mDependencySortedChildren.size();
        Rect rectAcquireTempRect = acquireTempRect();
        Rect rectAcquireTempRect2 = acquireTempRect();
        Rect rectAcquireTempRect3 = acquireTempRect();
        for (int i3 = 0; i3 < size; i3++) {
            View view = this.mDependencySortedChildren.get(i3);
            lLi1LL lli1ll = (lLi1LL) view.getLayoutParams();
            if (i != 0 || view.getVisibility() != 8) {
                for (int i4 = 0; i4 < i3; i4++) {
                    if (lli1ll.f2542Ll1 == this.mDependencySortedChildren.get(i4)) {
                        offsetChildToAnchor(view, iM2134l);
                    }
                }
                getChildRect(view, true, rectAcquireTempRect2);
                if (lli1ll.f2544iILLL1 != 0 && !rectAcquireTempRect2.isEmpty()) {
                    int iILil = ILil.p028IiL.p029ILl.I1I.ILil(lli1ll.f2544iILLL1, iM2134l);
                    int i5 = iILil & 112;
                    if (i5 == 48) {
                        rectAcquireTempRect.top = Math.max(rectAcquireTempRect.top, rectAcquireTempRect2.bottom);
                    } else if (i5 == 80) {
                        rectAcquireTempRect.bottom = Math.max(rectAcquireTempRect.bottom, getHeight() - rectAcquireTempRect2.top);
                    }
                    int i6 = iILil & 7;
                    if (i6 == 3) {
                        rectAcquireTempRect.left = Math.max(rectAcquireTempRect.left, rectAcquireTempRect2.right);
                    } else if (i6 == 5) {
                        rectAcquireTempRect.right = Math.max(rectAcquireTempRect.right, getWidth() - rectAcquireTempRect2.left);
                    }
                }
                if (lli1ll.f2541IiL != 0 && view.getVisibility() == 0) {
                    offsetChildByInset(view, rectAcquireTempRect, iM2134l);
                }
                if (i != 2) {
                    getLastChildRect(view, rectAcquireTempRect3);
                    if (!rectAcquireTempRect3.equals(rectAcquireTempRect2)) {
                        recordLastChildRect(view, rectAcquireTempRect2);
                        for (i2 = i3 + 1; i2 < size; i2++) {
                            View view2 = this.mDependencySortedChildren.get(i2);
                            lLi1LL lli1ll2 = (lLi1LL) view2.getLayoutParams();
                            behaviorM3155lLi1LL = lli1ll2.m3155lLi1LL();
                            if (behaviorM3155lLi1LL == null && behaviorM3155lLi1LL.layoutDependsOn(this, view2, view)) {
                                if (i == 0 && lli1ll2.m3151iILLL1()) {
                                    lli1ll2.ILL();
                                } else {
                                    if (i != 2) {
                                        zOnDependentViewChanged = behaviorM3155lLi1LL.onDependentViewChanged(this, view2, view);
                                    } else {
                                        behaviorM3155lLi1LL.onDependentViewRemoved(this, view2, view);
                                        zOnDependentViewChanged = true;
                                    }
                                    if (i == 1) {
                                        lli1ll2.LlLI1(zOnDependentViewChanged);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    while (i2 < size) {
                        View view3 = this.mDependencySortedChildren.get(i2);
                        lLi1LL lli1ll3 = (lLi1LL) view3.getLayoutParams();
                        behaviorM3155lLi1LL = lli1ll3.m3155lLi1LL();
                        if (behaviorM3155lLi1LL == null) {
                        }
                    }
                }
            }
        }
        releaseTempRect(rectAcquireTempRect);
        releaseTempRect(rectAcquireTempRect2);
        releaseTempRect(rectAcquireTempRect3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        View view = this.mNestedScrollingTarget;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.mIsAttachedToWindow = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.mDrawStatusBarBackground || this.mStatusBarBackground == null) {
            return;
        }
        C0633lIII c0633lIII = this.mLastInsets;
        int iIlil = c0633lIII != null ? c0633lIII.Ilil() : 0;
        if (iIlil > 0) {
            this.mStatusBarBackground.setBounds(0, 0, getWidth(), iIlil);
            this.mStatusBarBackground.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            resetTouchBehaviors(true);
        }
        boolean zPerformIntercept = performIntercept(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            resetTouchBehaviors(true);
        }
        return zPerformIntercept;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Behavior behaviorM3155lLi1LL;
        int iM2134l = iIlLiL.m2134l(this);
        int size = this.mDependencySortedChildren.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.mDependencySortedChildren.get(i5);
            if (view.getVisibility() != 8 && ((behaviorM3155lLi1LL = ((lLi1LL) view.getLayoutParams()).m3155lLi1LL()) == null || !behaviorM3155lLi1LL.onLayoutChild(this, view, iM2134l))) {
                onLayoutChild(view, iM2134l);
            }
        }
    }

    public void onLayoutChild(View view, int i) {
        lLi1LL lli1ll = (lLi1LL) view.getLayoutParams();
        if (lli1ll.IL1Iii()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        View view2 = lli1ll.ILL;
        if (view2 != null) {
            layoutChildWithAnchor(view, view2, i);
            return;
        }
        int i2 = lli1ll.f4946Ilil;
        if (i2 >= 0) {
            layoutChildWithKeyline(view, i2, i);
        } else {
            layoutChild(view, i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:42:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:45:0x011d  */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int iMax;
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        Behavior behaviorM3155lLi1LL;
        lLi1LL lli1ll;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        prepareChildren();
        ensurePreDrawListener();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int iM2134l = iIlLiL.m2134l(this);
        boolean z = iM2134l == 1;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int i10 = paddingLeft + paddingRight;
        int i11 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        boolean z2 = this.mLastInsets != null && iIlLiL.m2133lL(this);
        int size3 = this.mDependencySortedChildren.size();
        int i12 = suggestedMinimumWidth;
        int i13 = suggestedMinimumHeight;
        int iCombineMeasuredStates = 0;
        int i14 = 0;
        while (i14 < size3) {
            View view = this.mDependencySortedChildren.get(i14);
            if (view.getVisibility() == 8) {
                i8 = i14;
                i5 = size3;
                i6 = paddingLeft;
            } else {
                lLi1LL lli1ll2 = (lLi1LL) view.getLayoutParams();
                int i15 = lli1ll2.f4946Ilil;
                if (i15 < 0 || mode == 0) {
                    i3 = iCombineMeasuredStates;
                } else {
                    int keyline = getKeyline(i15);
                    int iILil = ILil.p028IiL.p029ILl.I1I.ILil(resolveKeylineGravity(lli1ll2.f4943I1I), iM2134l) & 7;
                    i3 = iCombineMeasuredStates;
                    if ((iILil == 3 && !z) || (iILil == 5 && z)) {
                        iMax = Math.max(0, (size - paddingRight) - keyline);
                    } else if ((iILil == 5 && !z) || (iILil == 3 && z)) {
                        iMax = Math.max(0, keyline - paddingLeft);
                    }
                    if (z2 || iIlLiL.m2133lL(view)) {
                        iMakeMeasureSpec = i;
                        iMakeMeasureSpec2 = i2;
                    } else {
                        int iI1I = this.mLastInsets.I1I() + this.mLastInsets.m2154IL();
                        int iIlil = this.mLastInsets.Ilil() + this.mLastInsets.ILil();
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size - iI1I, mode);
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size2 - iIlil, mode2);
                    }
                    behaviorM3155lLi1LL = lli1ll2.m3155lLi1LL();
                    if (behaviorM3155lLi1LL != null) {
                        lli1ll = lli1ll2;
                        i7 = i3;
                        i8 = i14;
                        i4 = i13;
                        i6 = paddingLeft;
                        i9 = i12;
                        i5 = size3;
                        if (!behaviorM3155lLi1LL.onMeasureChild(this, view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0)) {
                        }
                        lLi1LL lli1ll3 = lli1ll;
                        int iMax2 = Math.max(i9, i10 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) lli1ll3).leftMargin + ((ViewGroup.MarginLayoutParams) lli1ll3).rightMargin);
                        int iMax3 = Math.max(i4, i11 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) lli1ll3).topMargin + ((ViewGroup.MarginLayoutParams) lli1ll3).bottomMargin);
                        iCombineMeasuredStates = View.combineMeasuredStates(i7, view.getMeasuredState());
                        i12 = iMax2;
                        i13 = iMax3;
                    } else {
                        lli1ll = lli1ll2;
                        i4 = i13;
                        i5 = size3;
                        i6 = paddingLeft;
                        i7 = i3;
                        i8 = i14;
                        i9 = i12;
                    }
                    onMeasureChild(view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0);
                    lLi1LL lli1ll4 = lli1ll;
                    int iMax4 = Math.max(i9, i10 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) lli1ll4).leftMargin + ((ViewGroup.MarginLayoutParams) lli1ll4).rightMargin);
                    int iMax5 = Math.max(i4, i11 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) lli1ll4).topMargin + ((ViewGroup.MarginLayoutParams) lli1ll4).bottomMargin);
                    iCombineMeasuredStates = View.combineMeasuredStates(i7, view.getMeasuredState());
                    i12 = iMax4;
                    i13 = iMax5;
                }
                iMax = 0;
                if (z2) {
                    iMakeMeasureSpec = i;
                    iMakeMeasureSpec2 = i2;
                } else {
                    iMakeMeasureSpec = i;
                    iMakeMeasureSpec2 = i2;
                }
                behaviorM3155lLi1LL = lli1ll2.m3155lLi1LL();
                if (behaviorM3155lLi1LL != null) {
                    lli1ll = lli1ll2;
                    i7 = i3;
                    i8 = i14;
                    i4 = i13;
                    i6 = paddingLeft;
                    i9 = i12;
                    i5 = size3;
                    if (!behaviorM3155lLi1LL.onMeasureChild(this, view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0)) {
                    }
                    lLi1LL lli1ll5 = lli1ll;
                    int iMax6 = Math.max(i9, i10 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) lli1ll5).leftMargin + ((ViewGroup.MarginLayoutParams) lli1ll5).rightMargin);
                    int iMax7 = Math.max(i4, i11 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) lli1ll5).topMargin + ((ViewGroup.MarginLayoutParams) lli1ll5).bottomMargin);
                    iCombineMeasuredStates = View.combineMeasuredStates(i7, view.getMeasuredState());
                    i12 = iMax6;
                    i13 = iMax7;
                } else {
                    lli1ll = lli1ll2;
                    i4 = i13;
                    i5 = size3;
                    i6 = paddingLeft;
                    i7 = i3;
                    i8 = i14;
                    i9 = i12;
                }
                onMeasureChild(view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0);
                lLi1LL lli1ll6 = lli1ll;
                int iMax8 = Math.max(i9, i10 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) lli1ll6).leftMargin + ((ViewGroup.MarginLayoutParams) lli1ll6).rightMargin);
                int iMax9 = Math.max(i4, i11 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) lli1ll6).topMargin + ((ViewGroup.MarginLayoutParams) lli1ll6).bottomMargin);
                iCombineMeasuredStates = View.combineMeasuredStates(i7, view.getMeasuredState());
                i12 = iMax8;
                i13 = iMax9;
            }
            i14 = i8 + 1;
            paddingLeft = i6;
            size3 = i5;
        }
        int i16 = iCombineMeasuredStates;
        setMeasuredDimension(View.resolveSizeAndState(i12, i, (-16777216) & i16), View.resolveSizeAndState(i13, i2, i16 << 16));
    }

    public void onMeasureChild(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, ILil.p028IiL.p029ILl.InterfaceC0632ILl
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        Behavior behaviorM3155lLi1LL;
        int childCount = getChildCount();
        boolean zOnNestedFling = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                lLi1LL lli1ll = (lLi1LL) childAt.getLayoutParams();
                if (lli1ll.m3156il(0) && (behaviorM3155lLi1LL = lli1ll.m3155lLi1LL()) != null) {
                    zOnNestedFling |= behaviorM3155lLi1LL.onNestedFling(this, childAt, view, f, f2, z);
                }
            }
        }
        if (zOnNestedFling) {
            onChildViewsChanged(1);
        }
        return zOnNestedFling;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, ILil.p028IiL.p029ILl.InterfaceC0632ILl
    public boolean onNestedPreFling(View view, float f, float f2) {
        Behavior behaviorM3155lLi1LL;
        int childCount = getChildCount();
        boolean zOnNestedPreFling = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                lLi1LL lli1ll = (lLi1LL) childAt.getLayoutParams();
                if (lli1ll.m3156il(0) && (behaviorM3155lLi1LL = lli1ll.m3155lLi1LL()) != null) {
                    zOnNestedPreFling |= behaviorM3155lLi1LL.onNestedPreFling(this, childAt, view, f, f2);
                }
            }
        }
        return zOnNestedPreFling;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, ILil.p028IiL.p029ILl.InterfaceC0632ILl
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, ILil.p028IiL.p029ILl.InterfaceC0632ILl
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScroll(view, i, i2, i3, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, ILil.p028IiL.p029ILl.InterfaceC0632ILl
    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        SparseArray<Parcelable> sparseArray = savedState.f4941ILil;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behaviorM3155lLi1LL = getResolvedLayoutParams(childAt).m3155lLi1LL();
            if (id != -1 && behaviorM3155lLi1LL != null && (parcelable2 = sparseArray.get(id)) != null) {
                behaviorM3155lLi1LL.onRestoreInstanceState(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behaviorM3155lLi1LL = ((lLi1LL) childAt.getLayoutParams()).m3155lLi1LL();
            if (id != -1 && behaviorM3155lLi1LL != null && (parcelableOnSaveInstanceState = behaviorM3155lLi1LL.onSaveInstanceState(this, childAt)) != null) {
                sparseArray.append(id, parcelableOnSaveInstanceState);
            }
        }
        savedState.f4941ILil = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, ILil.p028IiL.p029ILl.InterfaceC0632ILl
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, ILil.p028IiL.p029ILl.InterfaceC0632ILl
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002b A[PHI: r3
  0x002b: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:9:0x0022, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX WARN: Code duplicated, block: B:15:0x0037 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x0039  */
    /* JADX WARN: Code duplicated, block: B:18:0x004c  */
    /* JADX WARN: Code duplicated, block: B:22:0x0054  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zPerformIntercept;
        boolean zOnTouchEvent;
        MotionEvent motionEventObtain;
        int actionMasked = motionEvent.getActionMasked();
        if (this.mBehaviorTouchView == null) {
            zPerformIntercept = performIntercept(motionEvent, 1);
            if (!zPerformIntercept) {
                zOnTouchEvent = false;
            }
            motionEventObtain = null;
            if (this.mBehaviorTouchView == null) {
                zOnTouchEvent |= super.onTouchEvent(motionEvent);
            } else if (zPerformIntercept) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                super.onTouchEvent(motionEventObtain);
            }
            if (motionEventObtain != null) {
                motionEventObtain.recycle();
            }
            if (actionMasked != 1 || actionMasked == 3) {
                resetTouchBehaviors(false);
            }
            return zOnTouchEvent;
        }
        zPerformIntercept = false;
        Behavior behaviorM3155lLi1LL = ((lLi1LL) this.mBehaviorTouchView.getLayoutParams()).m3155lLi1LL();
        if (behaviorM3155lLi1LL != null) {
            zOnTouchEvent = behaviorM3155lLi1LL.onTouchEvent(this, this.mBehaviorTouchView, motionEvent);
        } else {
            zOnTouchEvent = false;
        }
        motionEventObtain = null;
        if (this.mBehaviorTouchView == null) {
            zOnTouchEvent |= super.onTouchEvent(motionEvent);
        } else if (zPerformIntercept) {
            long jUptimeMillis2 = SystemClock.uptimeMillis();
            motionEventObtain = MotionEvent.obtain(jUptimeMillis2, jUptimeMillis2, 3, 0.0f, 0.0f, 0);
            super.onTouchEvent(motionEventObtain);
        }
        if (motionEventObtain != null) {
            motionEventObtain.recycle();
        }
        if (actionMasked != 1) {
            resetTouchBehaviors(false);
        } else {
            resetTouchBehaviors(false);
        }
        return zOnTouchEvent;
    }

    public void recordLastChildRect(View view, Rect rect) {
        ((lLi1LL) view.getLayoutParams()).m3154llL1ii(rect);
    }

    public void removePreDrawListener() {
        if (this.mIsAttachedToWindow && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Behavior behaviorM3155lLi1LL = ((lLi1LL) view.getLayoutParams()).m3155lLi1LL();
        if (behaviorM3155lLi1LL == null || !behaviorM3155lLi1LL.onRequestChildRectangleOnScreen(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.mDisallowInterceptReset) {
            return;
        }
        resetTouchBehaviors(false);
        this.mDisallowInterceptReset = true;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        setupForInsets();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.mStatusBarBackground;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.mStatusBarBackground = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.mStatusBarBackground.setState(getDrawableState());
                }
                ILil.p028IiL.p033iILLL1.ILL.IL1Iii.m2255lIiI(this.mStatusBarBackground, iIlLiL.m2134l(this));
                this.mStatusBarBackground.setVisible(getVisibility() == 0, false);
                this.mStatusBarBackground.setCallback(this);
            }
            iIlLiL.m2101LIl(this);
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? ILil.p028IiL.p035lLi1LL.IL1Iii.m2321IL(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.mStatusBarBackground;
        if (drawable == null || drawable.isVisible() == z) {
            return;
        }
        this.mStatusBarBackground.setVisible(z, false);
    }

    public final C0633lIII setWindowInsets(C0633lIII c0633lIII) {
        if (ILil.p028IiL.p034lIiI.I1I.IL1Iii(this.mLastInsets, c0633lIII)) {
            return c0633lIII;
        }
        this.mLastInsets = c0633lIII;
        boolean z = c0633lIII != null && c0633lIII.Ilil() > 0;
        this.mDrawStatusBarBackground = z;
        setWillNotDraw(!z && getBackground() == null);
        C0633lIII c0633lIIIDispatchApplyWindowInsetsToBehaviors = dispatchApplyWindowInsetsToBehaviors(c0633lIII);
        requestLayout();
        return c0633lIIIDispatchApplyWindowInsetsToBehaviors;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mStatusBarBackground;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, ILil.p040iILLL1.IL1Iii.coordinatorLayoutStyle);
    }

    @Override // android.view.ViewGroup
    public lLi1LL generateDefaultLayoutParams() {
        return new lLi1LL(-2, -2);
    }

    @Override // ILil.p028IiL.p029ILl.Ll1
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        Behavior behaviorM3155lLi1LL;
        int childCount = getChildCount();
        boolean z = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                lLi1LL lli1ll = (lLi1LL) childAt.getLayoutParams();
                if (lli1ll.m3156il(i3) && (behaviorM3155lLi1LL = lli1ll.m3155lLi1LL()) != null) {
                    int[] iArr2 = this.mBehaviorConsumed;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behaviorM3155lLi1LL.onNestedPreScroll(this, childAt, view, i, i2, iArr2, i3);
                    int[] iArr3 = this.mBehaviorConsumed;
                    iMax = i > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    int[] iArr4 = this.mBehaviorConsumed;
                    iMax2 = i2 > 0 ? Math.max(iMax2, iArr4[1]) : Math.min(iMax2, iArr4[1]);
                    z = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z) {
            onChildViewsChanged(1);
        }
    }

    @Override // ILil.p028IiL.p029ILl.Ll1
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        onNestedScroll(view, i, i2, i3, i4, 0, this.mNestedScrollingV2ConsumedCompat);
    }

    @Override // ILil.p028IiL.p029ILl.Ll1
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        Behavior behaviorM3155lLi1LL;
        this.mNestedScrollingParentHelper.I1I(view, view2, i, i2);
        this.mNestedScrollingTarget = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            lLi1LL lli1ll = (lLi1LL) childAt.getLayoutParams();
            if (lli1ll.m3156il(i2) && (behaviorM3155lLi1LL = lli1ll.m3155lLi1LL()) != null) {
                behaviorM3155lLi1LL.onNestedScrollAccepted(this, childAt, view, view2, i, i2);
            }
        }
    }

    @Override // ILil.p028IiL.p029ILl.Ll1
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                lLi1LL lli1ll = (lLi1LL) childAt.getLayoutParams();
                Behavior behaviorM3155lLi1LL = lli1ll.m3155lLi1LL();
                if (behaviorM3155lLi1LL != null) {
                    boolean zOnStartNestedScroll = behaviorM3155lLi1LL.onStartNestedScroll(this, childAt, view, view2, i, i2);
                    z |= zOnStartNestedScroll;
                    lli1ll.m3153lIlii(i2, zOnStartNestedScroll);
                } else {
                    lli1ll.m3153lIlii(i2, false);
                }
            }
        }
        return z;
    }

    @Override // ILil.p028IiL.p029ILl.Ll1
    public void onStopNestedScroll(View view, int i) {
        this.mNestedScrollingParentHelper.m2091IL(view, i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            lLi1LL lli1ll = (lLi1LL) childAt.getLayoutParams();
            if (lli1ll.m3156il(i)) {
                Behavior behaviorM3155lLi1LL = lli1ll.m3155lLi1LL();
                if (behaviorM3155lLi1LL != null) {
                    behaviorM3155lLi1LL.onStopNestedScroll(this, childAt, view, i);
                }
                lli1ll.m3149Ll1(i);
                lli1ll.ILL();
            }
        }
        this.mNestedScrollingTarget = null;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes;
        super(context, attributeSet, i);
        this.mDependencySortedChildren = new ArrayList();
        this.mChildDag = new ILil.p040iILLL1.p041IL.IL1Iii<>();
        this.mTempList1 = new ArrayList();
        this.mTempDependenciesList = new ArrayList();
        this.mBehaviorConsumed = new int[2];
        this.mNestedScrollingV2ConsumedCompat = new int[2];
        this.mNestedScrollingParentHelper = new Lil(this);
        if (i == 0) {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ILil.p040iILLL1.I1I.CoordinatorLayout, 0, ILil.p040iILLL1.ILil.Widget_Support_CoordinatorLayout);
        } else {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ILil.p040iILLL1.I1I.CoordinatorLayout, i, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (i == 0) {
                saveAttributeDataForStyleable(context, ILil.p040iILLL1.I1I.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, 0, ILil.p040iILLL1.ILil.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, ILil.p040iILLL1.I1I.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, i, 0);
            }
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(ILil.p040iILLL1.I1I.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.mKeylines = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.mKeylines.length;
            for (int i2 = 0; i2 < length; i2++) {
                int[] iArr = this.mKeylines;
                iArr[i2] = (int) (iArr[i2] * f);
            }
        }
        this.mStatusBarBackground = typedArrayObtainStyledAttributes.getDrawable(ILil.p040iILLL1.I1I.CoordinatorLayout_statusBarBackground);
        typedArrayObtainStyledAttributes.recycle();
        setupForInsets();
        super.setOnHierarchyChangeListener(new IL());
        if (iIlLiL.I11L(this) == 0) {
            iIlLiL.m72LL(this, 1);
        }
    }

    @Override // android.view.ViewGroup
    public lLi1LL generateLayoutParams(AttributeSet attributeSet) {
        return new lLi1LL(getContext(), attributeSet);
    }

    @Override // ILil.p028IiL.p029ILl.lIiI
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        Behavior behaviorM3155lLi1LL;
        int iMin;
        int childCount = getChildCount();
        boolean z = false;
        int iMax = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                lLi1LL lli1ll = (lLi1LL) childAt.getLayoutParams();
                if (lli1ll.m3156il(i5) && (behaviorM3155lLi1LL = lli1ll.m3155lLi1LL()) != null) {
                    int[] iArr2 = this.mBehaviorConsumed;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behaviorM3155lLi1LL.onNestedScroll(this, childAt, view, i, i2, i3, i4, i5, iArr2);
                    int[] iArr3 = this.mBehaviorConsumed;
                    iMax = i3 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    if (i4 > 0) {
                        iMin = Math.max(i6, this.mBehaviorConsumed[1]);
                    } else {
                        iMin = Math.min(i6, this.mBehaviorConsumed[1]);
                    }
                    i6 = iMin;
                    z = true;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + i6;
        if (z) {
            onChildViewsChanged(1);
        }
    }

    @Override // android.view.ViewGroup
    public lLi1LL generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof lLi1LL) {
            return new lLi1LL((lLi1LL) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new lLi1LL((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new lLi1LL(layoutParams);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new IL1Iii();

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public SparseArray<Parcelable> f4941ILil;

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
            int i = parcel.readInt();
            int[] iArr = new int[i];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.f4941ILil = new SparseArray<>(i);
            for (int i2 = 0; i2 < i; i2++) {
                this.f4941ILil.append(iArr[i2], parcelableArray[i2]);
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            SparseArray<Parcelable> sparseArray = this.f4941ILil;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.f4941ILil.keyAt(i2);
                parcelableArr[i2] = this.f4941ILil.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* JADX INFO: renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$l丨Li1LL, reason: invalid class name */
    public static class lLi1LL extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f4943I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public Behavior f4944IL1Iii;
        public View ILL;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public boolean f4945ILil;

        /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
        public boolean f2539ILl;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int f4946Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int f2540IL;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public int f2541IiL;
        public boolean Lil;
        public boolean LlLI1;

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public View f2542Ll1;

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public int f2543L11I;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public int f2544iILLL1;

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public boolean f2545lIiI;

        /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
        public Object f2546lIlii;

        /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
        public final Rect f2547llL1ii;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public int f2548lLi1LL;

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public int f2549il;

        public lLi1LL(int i, int i2) {
            super(i, i2);
            this.f4945ILil = false;
            this.f4943I1I = 0;
            this.f2540IL = 0;
            this.f4946Ilil = -1;
            this.f2548lLi1LL = -1;
            this.f2544iILLL1 = 0;
            this.f2541IiL = 0;
            this.f2547llL1ii = new Rect();
        }

        public boolean I1I() {
            if (this.f4944IL1Iii == null) {
                this.f2545lIiI = false;
            }
            return this.f2545lIiI;
        }

        public boolean IL1Iii() {
            return this.ILL == null && this.f2548lLi1LL != -1;
        }

        public void ILL() {
            this.LlLI1 = false;
        }

        public boolean ILil(CoordinatorLayout coordinatorLayout, View view, View view2) {
            Behavior behavior;
            return view2 == this.f2542Ll1 || iIi1(view2, iIlLiL.m2134l(coordinatorLayout)) || ((behavior = this.f4944IL1Iii) != null && behavior.layoutDependsOn(coordinatorLayout, view, view2));
        }

        /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
        public final void m3146ILl(View view, CoordinatorLayout coordinatorLayout) {
            View viewFindViewById = coordinatorLayout.findViewById(this.f2548lLi1LL);
            this.ILL = viewFindViewById;
            if (viewFindViewById == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.f2542Ll1 = null;
                    this.ILL = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f2548lLi1LL) + " to anchor view " + view);
            }
            if (viewFindViewById == coordinatorLayout) {
                if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                this.f2542Ll1 = null;
                this.ILL = null;
                return;
            }
            for (ViewParent parent = viewFindViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                if (parent == view) {
                    if (!coordinatorLayout.isInEditMode()) {
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    this.f2542Ll1 = null;
                    this.ILL = null;
                    return;
                }
                if (parent instanceof View) {
                    viewFindViewById = parent;
                }
            }
            this.f2542Ll1 = viewFindViewById;
        }

        public int Ilil() {
            return this.f2548lLi1LL;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public View m3147IL(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f2548lLi1LL == -1) {
                this.f2542Ll1 = null;
                this.ILL = null;
                return null;
            }
            if (this.ILL == null || !iIlLiL(view, coordinatorLayout)) {
                m3146ILl(view, coordinatorLayout);
            }
            return this.ILL;
        }

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public Rect m3148IiL() {
            return this.f2547llL1ii;
        }

        public void Lil(Behavior behavior) {
            Behavior behavior2 = this.f4944IL1Iii;
            if (behavior2 != behavior) {
                if (behavior2 != null) {
                    behavior2.onDetachedFromLayoutParams();
                }
                this.f4944IL1Iii = behavior;
                this.f2546lIlii = null;
                this.f4945ILil = true;
                if (behavior != null) {
                    behavior.onAttachedToLayoutParams(this);
                }
            }
        }

        public void LlLI1(boolean z) {
            this.LlLI1 = z;
        }

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public void m3149Ll1(int i) {
            m3153lIlii(i, false);
        }

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public boolean m3150L11I(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = this.f2545lIiI;
            if (z) {
                return true;
            }
            Behavior behavior = this.f4944IL1Iii;
            boolean zBlocksInteractionBelow = (behavior != null ? behavior.blocksInteractionBelow(coordinatorLayout, view) : false) | z;
            this.f2545lIiI = zBlocksInteractionBelow;
            return zBlocksInteractionBelow;
        }

        public final boolean iIi1(View view, int i) {
            int iILil = ILil.p028IiL.p029ILl.I1I.ILil(((lLi1LL) view.getLayoutParams()).f2544iILLL1, i);
            return iILil != 0 && (ILil.p028IiL.p029ILl.I1I.ILil(this.f2541IiL, i) & iILil) == iILil;
        }

        public final boolean iIlLiL(View view, CoordinatorLayout coordinatorLayout) {
            if (this.ILL.getId() != this.f2548lLi1LL) {
                return false;
            }
            View view2 = this.ILL;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f2542Ll1 = null;
                    this.ILL = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
            this.f2542Ll1 = view2;
            return true;
        }

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public boolean m3151iILLL1() {
            return this.LlLI1;
        }

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public void m3152lIiI() {
            this.f2545lIiI = false;
        }

        /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
        public void m3153lIlii(int i, boolean z) {
            if (i == 0) {
                this.f2539ILl = z;
            } else {
                if (i != 1) {
                    return;
                }
                this.Lil = z;
            }
        }

        /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
        public void m3154llL1ii(Rect rect) {
            this.f2547llL1ii.set(rect);
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public Behavior m3155lLi1LL() {
            return this.f4944IL1Iii;
        }

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public boolean m3156il(int i) {
            if (i == 0) {
                return this.f2539ILl;
            }
            if (i != 1) {
                return false;
            }
            return this.Lil;
        }

        public lLi1LL(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4945ILil = false;
            this.f4943I1I = 0;
            this.f2540IL = 0;
            this.f4946Ilil = -1;
            this.f2548lLi1LL = -1;
            this.f2544iILLL1 = 0;
            this.f2541IiL = 0;
            this.f2547llL1ii = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ILil.p040iILLL1.I1I.CoordinatorLayout_Layout);
            this.f4943I1I = typedArrayObtainStyledAttributes.getInteger(ILil.p040iILLL1.I1I.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f2548lLi1LL = typedArrayObtainStyledAttributes.getResourceId(ILil.p040iILLL1.I1I.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f2540IL = typedArrayObtainStyledAttributes.getInteger(ILil.p040iILLL1.I1I.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f4946Ilil = typedArrayObtainStyledAttributes.getInteger(ILil.p040iILLL1.I1I.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f2544iILLL1 = typedArrayObtainStyledAttributes.getInt(ILil.p040iILLL1.I1I.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f2541IiL = typedArrayObtainStyledAttributes.getInt(ILil.p040iILLL1.I1I.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            int i = ILil.p040iILLL1.I1I.CoordinatorLayout_Layout_layout_behavior;
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i);
            this.f4945ILil = zHasValue;
            if (zHasValue) {
                this.f4944IL1Iii = CoordinatorLayout.parseBehavior(context, attributeSet, typedArrayObtainStyledAttributes.getString(i));
            }
            typedArrayObtainStyledAttributes.recycle();
            Behavior behavior = this.f4944IL1Iii;
            if (behavior != null) {
                behavior.onAttachedToLayoutParams(this);
            }
        }

        public lLi1LL(lLi1LL lli1ll) {
            super((ViewGroup.MarginLayoutParams) lli1ll);
            this.f4945ILil = false;
            this.f4943I1I = 0;
            this.f2540IL = 0;
            this.f4946Ilil = -1;
            this.f2548lLi1LL = -1;
            this.f2544iILLL1 = 0;
            this.f2541IiL = 0;
            this.f2547llL1ii = new Rect();
        }

        public lLi1LL(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f4945ILil = false;
            this.f4943I1I = 0;
            this.f2540IL = 0;
            this.f4946Ilil = -1;
            this.f2548lLi1LL = -1;
            this.f2544iILLL1 = 0;
            this.f2541IiL = 0;
            this.f2547llL1ii = new Rect();
        }

        public lLi1LL(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f4945ILil = false;
            this.f4943I1I = 0;
            this.f2540IL = 0;
            this.f4946Ilil = -1;
            this.f2548lLi1LL = -1;
            this.f2544iILLL1 = 0;
            this.f2541IiL = 0;
            this.f2547llL1ii = new Rect();
        }
    }
}
