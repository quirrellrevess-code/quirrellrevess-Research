package androidx.appcompat.widget;

import ILil.ILil.ILL;
import ILil.ILil.iILLL1;
import ILil.ILil.p023lIlii.C0624ill;
import ILil.ILil.p023lIlii.llI;
import ILil.ILil.p024llL1ii.ILL.IiL;
import ILil.ILil.p024llL1ii.ILil;
import ILil.p028IiL.p029ILl.iIlLiL;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContextView extends ILil.ILil.p023lIlii.IL1Iii {
    public CharSequence ILL;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public LinearLayout f2338ILl;
    public TextView Lil;
    public TextView LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public View f2339Ll1;
    public boolean iIi1;
    public int iIlLiL;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public View f2340lIiI;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public int f2341lIlii;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public int f2342llL1ii;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public CharSequence f2343il;

    public class IL1Iii implements View.OnClickListener {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ ILil f4818ILil;

        public IL1Iii(ActionBarContextView actionBarContextView, ILil iLil) {
            this.f4818ILil = iLil;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f4818ILil.IL1Iii();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public void ILL() {
        removeAllViews();
        this.f2340lIiI = null;
        this.f1342IL = null;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m3047IiL(ILil iLil) {
        View view = this.f2339Ll1;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.iIlLiL, (ViewGroup) this, false);
            this.f2339Ll1 = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.f2339Ll1);
        }
        this.f2339Ll1.findViewById(iILLL1.action_mode_close_button).setOnClickListener(new IL1Iii(this, iLil));
        IiL iiL = (IiL) iLil.I1I();
        ActionMenuPresenter actionMenuPresenter = this.f3753Ilil;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.m3065llL1ii();
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.f3753Ilil = actionMenuPresenter2;
        actionMenuPresenter2.m3063lIII(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        iiL.addMenuPresenter(this.f3753Ilil, this.f3751I1I);
        ActionMenuView actionMenuView = (ActionMenuView) this.f3753Ilil.mo1870IiL(this);
        this.f1342IL = actionMenuView;
        iIlLiL.ill1LI1l(actionMenuView, null);
        addView(this.f1342IL, layoutParams);
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public boolean m3048Ll1() {
        ActionMenuPresenter actionMenuPresenter = this.f3753Ilil;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.LL1IL();
        }
        return false;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final void m3049L11I() {
        if (this.f2338ILl == null) {
            LayoutInflater.from(getContext()).inflate(ILil.ILil.IiL.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f2338ILl = linearLayout;
            this.Lil = (TextView) linearLayout.findViewById(iILLL1.action_bar_title);
            this.LlLI1 = (TextView) this.f2338ILl.findViewById(iILLL1.action_bar_subtitle);
            if (this.f2342llL1ii != 0) {
                this.Lil.setTextAppearance(getContext(), this.f2342llL1ii);
            }
            if (this.f2341lIlii != 0) {
                this.LlLI1.setTextAppearance(getContext(), this.f2341lIlii);
            }
        }
        this.Lil.setText(this.f2343il);
        this.LlLI1.setText(this.ILL);
        boolean z = !TextUtils.isEmpty(this.f2343il);
        boolean z2 = !TextUtils.isEmpty(this.ILL);
        int i = 0;
        this.LlLI1.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout2 = this.f2338ILl;
        if (!z && !z2) {
            i = 8;
        }
        linearLayout2.setVisibility(i);
        if (this.f2338ILl.getParent() == null) {
            addView(this.f2338ILl);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // ILil.ILil.p023lIlii.IL1Iii
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // ILil.ILil.p023lIlii.IL1Iii
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.ILL;
    }

    public CharSequence getTitle() {
        return this.f2343il;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m3050iILLL1() {
        if (this.f2339Ll1 == null) {
            ILL();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f3753Ilil;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.iIlLiL();
            this.f3753Ilil.I11li1();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            return;
        }
        accessibilityEvent.setSource(this);
        accessibilityEvent.setClassName(getClass().getName());
        accessibilityEvent.setPackageName(getContext().getPackageName());
        accessibilityEvent.setContentDescription(this.f2343il);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean zILil = C0624ill.ILil(this);
        int paddingRight = zILil ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        View view = this.f2339Ll1;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2339Ll1.getLayoutParams();
            int i5 = zILil ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = zILil ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iM1707IL = ILil.ILil.p023lIlii.IL1Iii.m1707IL(paddingRight, i5, zILil);
            paddingRight = ILil.ILil.p023lIlii.IL1Iii.m1707IL(iM1707IL + Ilil(this.f2339Ll1, iM1707IL, paddingTop, paddingTop2, zILil), i6, zILil);
        }
        int iIlil = paddingRight;
        LinearLayout linearLayout = this.f2338ILl;
        if (linearLayout != null && this.f2340lIiI == null && linearLayout.getVisibility() != 8) {
            iIlil += Ilil(this.f2338ILl, iIlil, paddingTop, paddingTop2, zILil);
        }
        int i7 = iIlil;
        View view2 = this.f2340lIiI;
        if (view2 != null) {
            Ilil(view2, i7, paddingTop, paddingTop2, zILil);
        }
        int paddingLeft = zILil ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        ActionMenuView actionMenuView = this.f1342IL;
        if (actionMenuView != null) {
            Ilil(actionMenuView, paddingLeft, paddingTop, paddingTop2, !zILil);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int i3 = Videoio.CAP_OPENNI_IMAGE_GENERATOR;
        if (mode != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.f1346lLi1LL;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i2);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f2339Ll1;
        if (view != null) {
            int iI1I = I1I(view, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2339Ll1.getLayoutParams();
            paddingLeft = iI1I - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f1342IL;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = I1I(this.f1342IL, paddingLeft, iMakeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f2338ILl;
        if (linearLayout != null && this.f2340lIiI == null) {
            if (this.iIi1) {
                this.f2338ILl.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f2338ILl.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.f2338ILl.setVisibility(z ? 0 : 8);
            } else {
                paddingLeft = I1I(linearLayout, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        View view2 = this.f2340lIiI;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i4 = layoutParams.width;
            int i5 = i4 != -2 ? Videoio.CAP_OPENNI_IMAGE_GENERATOR : Integer.MIN_VALUE;
            if (i4 >= 0) {
                paddingLeft = Math.min(i4, paddingLeft);
            }
            int i6 = layoutParams.height;
            if (i6 == -2) {
                i3 = Integer.MIN_VALUE;
            }
            if (i6 >= 0) {
                iMin = Math.min(i6, iMin);
            }
            this.f2340lIiI.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i5), View.MeasureSpec.makeMeasureSpec(iMin, i3));
        }
        if (this.f1346lLi1LL > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            int measuredHeight = getChildAt(i8).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i7) {
                i7 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i7);
    }

    @Override // ILil.ILil.p023lIlii.IL1Iii
    public void setContentHeight(int i) {
        this.f1346lLi1LL = i;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f2340lIiI;
        if (view2 != null) {
            removeView(view2);
        }
        this.f2340lIiI = view;
        if (view != null && (linearLayout = this.f2338ILl) != null) {
            removeView(linearLayout);
            this.f2338ILl = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.ILL = charSequence;
        m3049L11I();
    }

    public void setTitle(CharSequence charSequence) {
        this.f2343il = charSequence;
        m3049L11I();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.iIi1) {
            requestLayout();
        }
        this.iIi1 = z;
    }

    @Override // ILil.ILil.p023lIlii.IL1Iii, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public boolean m3051il() {
        return this.iIi1;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, ILil.ILil.IL1Iii.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        llI lliI11li1 = llI.I11li1(context, attributeSet, ILL.ActionMode, i, 0);
        iIlLiL.ill1LI1l(this, lliI11li1.m1827iILLL1(ILL.ActionMode_background));
        this.f2342llL1ii = lliI11li1.m1822ILl(ILL.ActionMode_titleTextStyle, 0);
        this.f2341lIlii = lliI11li1.m1822ILl(ILL.ActionMode_subtitleTextStyle, 0);
        this.f1346lLi1LL = lliI11li1.m1828lIiI(ILL.ActionMode_height, 0);
        this.iIlLiL = lliI11li1.m1822ILl(ILL.ActionMode_closeItemLayout, ILil.ILil.IiL.abc_action_mode_close_item_material);
        lliI11li1.m1833lL();
    }
}
