package androidx.appcompat.widget;

import ILil.ILil.p023lIlii.C0624ill;
import ILil.ILil.p024llL1ii.ILL.C0629il;
import ILil.ILil.p024llL1ii.ILL.IiL;
import ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl;
import ILil.ILil.p024llL1ii.ILL.Lil;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements IiL.ILil, Lil {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Context f4830I1I;
    public int ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public IiL f4831ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public boolean f4832Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f2374IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public IiL.IL1Iii f2375IiL;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public int f2376Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public boolean f2377L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public InterfaceC0628ILl.IL1Iii f2378iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public IL f2379lIiI;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public ActionMenuPresenter f2380lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public int f2381il;

    public class I1I implements IiL.IL1Iii {
        public I1I() {
        }

        @Override // ILil.ILil.p024llL1ii.ILL.IiL.IL1Iii
        public boolean onMenuItemSelected(IiL iiL, MenuItem menuItem) {
            IL il = ActionMenuView.this.f2379lIiI;
            return il != null && il.onMenuItemClick(menuItem);
        }

        @Override // ILil.ILil.p024llL1ii.ILL.IiL.IL1Iii
        public void onMenuModeChange(IiL iiL) {
            IiL.IL1Iii iL1Iii = ActionMenuView.this.f2375IiL;
            if (iL1Iii != null) {
                iL1Iii.onMenuModeChange(iiL);
            }
        }
    }

    public interface IL1Iii {
        boolean IL1Iii();

        boolean ILil();
    }

    public static class ILil implements InterfaceC0628ILl.IL1Iii {
        @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl.IL1Iii
        public boolean IL1Iii(IiL iiL) {
            return false;
        }

        @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl.IL1Iii
        public void onCloseMenu(IiL iiL, boolean z) {
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.ActionMenuView$I丨L, reason: invalid class name */
    public interface IL {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f4834I1I;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f4835Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        @ViewDebug.ExportedProperty
        public int f2382IL;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public boolean f2383IiL;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        @ViewDebug.ExportedProperty
        public boolean f2384iILLL1;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        @ViewDebug.ExportedProperty
        public boolean f2385lLi1LL;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f4834I1I = layoutParams.f4834I1I;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f4834I1I = false;
        }
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public static int m3069ILl(View view, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = actionMenuItemView != null && actionMenuItemView.I1I();
        int i5 = 2;
        if (i2 <= 0 || (z && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), iMakeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i6++;
            }
            if (!z || i6 >= 2) {
                i5 = i6;
            }
        }
        layoutParams.f2385lLi1LL = !layoutParams.f4834I1I && z;
        layoutParams.f2382IL = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, Videoio.CAP_OPENNI_IMAGE_GENERATOR), iMakeMeasureSpec);
        return i5;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.IiL.ILil
    public boolean IL1Iii(C0629il c0629il) {
        return this.f4831ILil.performItemAction(c0629il, 0);
    }

    public boolean ILL() {
        ActionMenuPresenter actionMenuPresenter = this.f2380lLi1LL;
        return actionMenuPresenter != null && actionMenuPresenter.m3066lL();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    /* JADX INFO: renamed from: Ilil, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.f4879ILil = 16;
        return layoutParams;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m3070IL() {
        ActionMenuPresenter actionMenuPresenter = this.f2380lLi1LL;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.m3065llL1ii();
        }
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public LayoutParams m3071IiL() {
        LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        layoutParamsGenerateDefaultLayoutParams.f4834I1I = true;
        return layoutParamsGenerateDefaultLayoutParams;
    }

    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9, types: [boolean, int] */
    public final void Lil(int i, int i2) {
        boolean z;
        int i3;
        boolean z2;
        ?? r14;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingTop, -2);
        int i4 = size - paddingLeft;
        int i5 = this.ILL;
        int i6 = i4 / i5;
        int i7 = i4 % i5;
        if (i6 == 0) {
            setMeasuredDimension(i4, 0);
            return;
        }
        int i8 = i5 + (i7 / i6);
        int childCount = getChildCount();
        int iMax = 0;
        int i9 = 0;
        boolean z3 = false;
        int i10 = 0;
        int iMax2 = 0;
        int i11 = 0;
        long j = 0;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            int i12 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z4 = childAt instanceof ActionMenuItemView;
                int i13 = i10 + 1;
                if (z4) {
                    int i14 = this.f2376Ll1;
                    r14 = 0;
                    childAt.setPadding(i14, 0, i14, 0);
                } else {
                    r14 = 0;
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.f2383IiL = r14;
                layoutParams.f4835Ilil = r14;
                layoutParams.f2382IL = r14;
                layoutParams.f2385lLi1LL = r14;
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = r14;
                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = r14;
                layoutParams.f2384iILLL1 = z4 && ((ActionMenuItemView) childAt).I1I();
                int iM3069ILl = m3069ILl(childAt, i8, layoutParams.f4834I1I ? 1 : i6, childMeasureSpec, paddingTop);
                iMax2 = Math.max(iMax2, iM3069ILl);
                if (layoutParams.f2385lLi1LL) {
                    i11++;
                }
                if (layoutParams.f4834I1I) {
                    z3 = true;
                }
                i6 -= iM3069ILl;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (iM3069ILl == 1) {
                    j |= (long) (1 << i9);
                    iMax = iMax;
                }
                i10 = i13;
            }
            i9++;
            size2 = i12;
        }
        int i15 = size2;
        boolean z5 = z3 && i10 == 2;
        boolean z6 = false;
        while (true) {
            if (i11 <= 0 || i6 <= 0) {
                z = z6;
                i3 = iMax;
                break;
            }
            int i16 = 0;
            int i17 = 0;
            int i18 = Integer.MAX_VALUE;
            long j2 = 0;
            while (i17 < childCount) {
                boolean z7 = z6;
                LayoutParams layoutParams2 = (LayoutParams) getChildAt(i17).getLayoutParams();
                int i19 = iMax;
                if (layoutParams2.f2385lLi1LL) {
                    int i20 = layoutParams2.f2382IL;
                    if (i20 < i18) {
                        j2 = 1 << i17;
                        i18 = i20;
                        i16 = 1;
                    } else if (i20 == i18) {
                        i16++;
                        j2 |= 1 << i17;
                    }
                }
                i17++;
                iMax = i19;
                z6 = z7;
            }
            z = z6;
            i3 = iMax;
            j |= j2;
            if (i16 > i6) {
                break;
            }
            int i21 = i18 + 1;
            int i22 = 0;
            while (i22 < childCount) {
                View childAt2 = getChildAt(i22);
                LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                int i23 = i4;
                int i24 = mode;
                long j3 = 1 << i22;
                if ((j2 & j3) == 0) {
                    if (layoutParams3.f2382IL == i21) {
                        j |= j3;
                    }
                    z5 = z5;
                } else {
                    if (z5 && layoutParams3.f2384iILLL1 && i6 == 1) {
                        int i25 = this.f2376Ll1;
                        childAt2.setPadding(i25 + i8, 0, i25, 0);
                    }
                    layoutParams3.f2382IL++;
                    layoutParams3.f2383IiL = true;
                    i6--;
                }
                i22++;
                mode = i24;
                i4 = i23;
                z5 = z5;
            }
            iMax = i3;
            z6 = true;
        }
        boolean z8 = !z3 && i10 == 1;
        if (i6 <= 0 || j == 0 || (i6 >= i10 - 1 && !z8 && iMax2 <= 1)) {
            z2 = z;
        } else {
            float fBitCount = Long.bitCount(j);
            if (!z8) {
                if ((j & 1) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).f2384iILLL1) {
                    fBitCount -= 0.5f;
                }
                int i26 = childCount - 1;
                if ((j & ((long) (1 << i26))) != 0 && !((LayoutParams) getChildAt(i26).getLayoutParams()).f2384iILLL1) {
                    fBitCount -= 0.5f;
                }
            }
            int i27 = fBitCount > 0.0f ? (int) ((i6 * i8) / fBitCount) : 0;
            z2 = z;
            for (int i28 = 0; i28 < childCount; i28++) {
                if ((j & ((long) (1 << i28))) != 0) {
                    View childAt3 = getChildAt(i28);
                    LayoutParams layoutParams4 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams4.f4835Ilil = i27;
                        layoutParams4.f2383IiL = true;
                        if (i28 == 0 && !layoutParams4.f2384iILLL1) {
                            ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = (-i27) / 2;
                        }
                    } else if (layoutParams4.f4834I1I) {
                        layoutParams4.f4835Ilil = i27;
                        layoutParams4.f2383IiL = true;
                        ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = (-i27) / 2;
                    } else {
                        if (i28 != 0) {
                            ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = i27 / 2;
                        }
                        if (i28 != childCount - 1) {
                            ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = i27 / 2;
                        }
                    }
                    z2 = true;
                }
            }
        }
        if (z2) {
            for (int i29 = 0; i29 < childCount; i29++) {
                View childAt4 = getChildAt(i29);
                LayoutParams layoutParams5 = (LayoutParams) childAt4.getLayoutParams();
                if (layoutParams5.f2383IiL) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams5.f2382IL * i8) + layoutParams5.f4835Ilil, Videoio.CAP_OPENNI_IMAGE_GENERATOR), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i4, mode != 1073741824 ? i3 : i15);
    }

    public IiL LlLI1() {
        return this.f4831ILil;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public boolean m3072Ll1() {
        ActionMenuPresenter actionMenuPresenter = this.f2380lLi1LL;
        return actionMenuPresenter != null && actionMenuPresenter.I11L();
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public boolean m3073L11I(int i) {
        boolean zIL1Iii = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof IL1Iii)) {
            zIL1Iii = false | ((IL1Iii) childAt).IL1Iii();
        }
        return (i <= 0 || !(childAt2 instanceof IL1Iii)) ? zIL1Iii : zIL1Iii | ((IL1Iii) childAt2).ILil();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public Menu getMenu() {
        if (this.f4831ILil == null) {
            Context context = getContext();
            IiL iiL = new IiL(context);
            this.f4831ILil = iiL;
            iiL.setCallback(new I1I());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.f2380lLi1LL = actionMenuPresenter;
            actionMenuPresenter.m3063lIII(true);
            ActionMenuPresenter actionMenuPresenter2 = this.f2380lLi1LL;
            InterfaceC0628ILl.IL1Iii iLil = this.f2378iILLL1;
            if (iLil == null) {
                iLil = new ILil();
            }
            actionMenuPresenter2.setCallback(iLil);
            this.f4831ILil.addMenuPresenter(this.f2380lLi1LL, this.f4830I1I);
            this.f2380lLi1LL.m30681(this);
        }
        return this.f4831ILil;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f2380lLi1LL.iIi1();
    }

    public int getPopupTheme() {
        return this.f2374IL;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
        if (layoutParams2.f4879ILil <= 0) {
            layoutParams2.f4879ILil = 16;
        }
        return layoutParams2;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.Lil
    public void initialize(IiL iiL) {
        this.f4831ILil = iiL;
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public boolean m3075lIiI() {
        return this.f4832Ilil;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public boolean m3076lIlii() {
        ActionMenuPresenter actionMenuPresenter = this.f2380lLi1LL;
        return actionMenuPresenter != null && actionMenuPresenter.LL1IL();
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public void m3077llL1ii(InterfaceC0628ILl.IL1Iii iL1Iii, IiL.IL1Iii iL1Iii2) {
        this.f2378iILLL1 = iL1Iii;
        this.f2375IiL = iL1Iii2;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.f2380lLi1LL;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.updateMenuView(false);
            if (this.f2380lLi1LL.I11L()) {
                this.f2380lLi1LL.iIlLiL();
                this.f2380lLi1LL.LL1IL();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m3070IL();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width;
        int paddingLeft;
        if (!this.f2377L11I) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i5 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i6 = i3 - i;
        int paddingRight = (i6 - getPaddingRight()) - getPaddingLeft();
        boolean zILil = C0624ill.ILil(this);
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f4834I1I) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (m3073L11I(i9)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zILil) {
                        paddingLeft = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i10 = i5 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i10, width, measuredHeight + i10);
                    paddingRight -= measuredWidth;
                    i7 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    m3073L11I(i9);
                    i8++;
                }
            }
        }
        if (childCount == 1 && i7 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i11 = (i6 / 2) - (measuredWidth2 / 2);
            int i12 = i5 - (measuredHeight2 / 2);
            childAt2.layout(i11, i12, measuredWidth2 + i11, measuredHeight2 + i12);
            return;
        }
        int i13 = i8 - (i7 ^ 1);
        int iMax = Math.max(0, i13 > 0 ? paddingRight / i13 : 0);
        if (zILil) {
            int width2 = getWidth() - getPaddingRight();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt3 = getChildAt(i14);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.f4834I1I) {
                    int i15 = width2 - ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i16 = i5 - (measuredHeight3 / 2);
                    childAt3.layout(i15 - measuredWidth3, i16, i15, measuredHeight3 + i16);
                    width2 = i15 - ((measuredWidth3 + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt4 = getChildAt(i17);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.f4834I1I) {
                int i18 = paddingLeft2 + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i19 = i5 - (measuredHeight4 / 2);
                childAt4.layout(i18, i19, i18 + measuredWidth4, measuredHeight4 + i19);
                paddingLeft2 = i18 + measuredWidth4 + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin + iMax;
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i2) {
        IiL iiL;
        boolean z = this.f2377L11I;
        boolean z2 = View.MeasureSpec.getMode(i) == 1073741824;
        this.f2377L11I = z2;
        if (z != z2) {
            this.f2381il = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.f2377L11I && (iiL = this.f4831ILil) != null && size != this.f2381il) {
            this.f2381il = size;
            iiL.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (this.f2377L11I && childCount > 0) {
            Lil(i, i2);
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = 0;
        }
        super.onMeasure(i, i2);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f2380lLi1LL.m3067l(z);
    }

    public void setOnMenuItemClickListener(IL il) {
        this.f2379lIiI = il;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f2380lLi1LL.m3062LlLLL(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.f4832Ilil = z;
    }

    public void setPopupTheme(int i) {
        if (this.f2374IL != i) {
            this.f2374IL = i;
            if (i == 0) {
                this.f4830I1I = getContext();
            } else {
                this.f4830I1I = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f2380lLi1LL = actionMenuPresenter;
        actionMenuPresenter.m30681(this);
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public boolean m3079il() {
        ActionMenuPresenter actionMenuPresenter = this.f2380lLi1LL;
        return actionMenuPresenter != null && actionMenuPresenter.iIlLiL();
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.ILL = (int) (56.0f * f);
        this.f2376Ll1 = (int) (f * 4.0f);
        this.f4830I1I = context;
        this.f2374IL = 0;
    }
}
