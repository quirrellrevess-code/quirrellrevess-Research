package ILil.ILil.p023lIlii;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import org.opencv.videoio.Videoio;

/* JADX INFO: renamed from: ILil.ILil.lI丨lii.丨丨丨1丨, reason: invalid class name */
/* JADX INFO: compiled from: ScrollingTabContainerView.java */
/* JADX INFO: loaded from: classes.dex */
public class C1 extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public I1I f3852I1I;
    public ViewPropertyAnimator ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Runnable f3853ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public Spinner f3854Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public LinearLayoutCompat f1432IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public int f1433IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public int f1434L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int f1435iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean f1436lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public int f1437il;

    /* JADX INFO: renamed from: ILil.ILil.lI丨lii.丨丨丨1丨$I1I */
    /* JADX INFO: compiled from: ScrollingTabContainerView.java */
    public class I1I implements View.OnClickListener {
        public I1I() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((IL) view).ILil().Ilil();
            int childCount = C1.this.f1432IL.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = C1.this.f1432IL.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* JADX INFO: renamed from: ILil.ILil.lI丨lii.丨丨丨1丨$IL1Iii */
    /* JADX INFO: compiled from: ScrollingTabContainerView.java */
    public class IL1Iii implements Runnable {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ View f3857ILil;

        public IL1Iii(View view) {
            this.f3857ILil = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            C1.this.smoothScrollTo(this.f3857ILil.getLeft() - ((C1.this.getWidth() - this.f3857ILil.getWidth()) / 2), 0);
            C1.this.f3853ILil = null;
        }
    }

    /* JADX INFO: renamed from: ILil.ILil.lI丨lii.丨丨丨1丨$ILil */
    /* JADX INFO: compiled from: ScrollingTabContainerView.java */
    public class ILil extends BaseAdapter {
        public ILil() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return C1.this.f1432IL.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ((IL) C1.this.f1432IL.getChildAt(i)).ILil();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return C1.this.m1852IL((ActionBar.ILil) getItem(i), true);
            }
            ((IL) view).IL1Iii((ActionBar.ILil) getItem(i));
            return view;
        }
    }

    /* JADX INFO: renamed from: ILil.ILil.lI丨lii.丨丨丨1丨$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: ScrollingTabContainerView.java */
    public class IL extends LinearLayout {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public ActionBar.ILil f3859I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final int[] f3860ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public ImageView f3861Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public TextView f1438IL;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public View f1440lLi1LL;

        /* JADX WARN: Illegal instructions before constructor call */
        public IL(Context context, ActionBar.ILil iLil, boolean z) {
            int i = ILil.ILil.IL1Iii.actionBarTabStyle;
            super(context, null, i);
            int[] iArr = {R.attr.background};
            this.f3860ILil = iArr;
            this.f3859I1I = iLil;
            llI lliI11li1 = llI.I11li1(context, null, iArr, i, 0);
            if (lliI11li1.m1829lIlii(0)) {
                setBackgroundDrawable(lliI11li1.m1827iILLL1(0));
            }
            lliI11li1.m1833lL();
            if (z) {
                setGravity(8388627);
            }
            I1I();
        }

        public void I1I() {
            ActionBar.ILil iLil = this.f3859I1I;
            View viewILil = iLil.ILil();
            if (viewILil != null) {
                ViewParent parent = viewILil.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewILil);
                    }
                    addView(viewILil);
                }
                this.f1440lLi1LL = viewILil;
                TextView textView = this.f1438IL;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f3861Ilil;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f3861Ilil.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f1440lLi1LL;
            if (view != null) {
                removeView(view);
                this.f1440lLi1LL = null;
            }
            Drawable drawableI1I = iLil.I1I();
            CharSequence charSequenceM2990IL = iLil.m2990IL();
            if (drawableI1I != null) {
                if (this.f3861Ilil == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f3861Ilil = appCompatImageView;
                }
                this.f3861Ilil.setImageDrawable(drawableI1I);
                this.f3861Ilil.setVisibility(0);
            } else {
                ImageView imageView2 = this.f3861Ilil;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f3861Ilil.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(charSequenceM2990IL);
            if (z) {
                if (this.f1438IL == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, ILil.ILil.IL1Iii.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f1438IL = appCompatTextView;
                }
                this.f1438IL.setText(charSequenceM2990IL);
                this.f1438IL.setVisibility(0);
            } else {
                TextView textView2 = this.f1438IL;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f1438IL.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f3861Ilil;
            if (imageView3 != null) {
                imageView3.setContentDescription(iLil.IL1Iii());
            }
            L1l.IL1Iii(this, z ? null : iLil.IL1Iii());
        }

        public void IL1Iii(ActionBar.ILil iLil) {
            this.f3859I1I = iLil;
            I1I();
        }

        public ActionBar.ILil ILil() {
            return this.f3859I1I;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (C1.this.f1435iILLL1 > 0) {
                int measuredWidth = getMeasuredWidth();
                int i3 = C1.this.f1435iILLL1;
                if (measuredWidth > i3) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, Videoio.CAP_OPENNI_IMAGE_GENERATOR), i2);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }
    }

    /* JADX INFO: renamed from: ILil.ILil.lI丨lii.丨丨丨1丨$l丨Li1LL, reason: invalid class name */
    /* JADX INFO: compiled from: ScrollingTabContainerView.java */
    public class lLi1LL extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public boolean f3863IL1Iii = false;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f3864ILil;

        public lLi1LL() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3863IL1Iii = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f3863IL1Iii) {
                return;
            }
            C1 c1 = C1.this;
            c1.ILL = null;
            c1.setVisibility(this.f3864ILil);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            C1.this.setVisibility(0);
            this.f3863IL1Iii = false;
        }
    }

    static {
        new DecelerateInterpolator();
    }

    public C1(Context context) {
        super(context);
        new lLi1LL();
        setHorizontalScrollBarEnabled(false);
        ILil.ILil.p024llL1ii.IL1Iii iL1IiiILil = ILil.ILil.p024llL1ii.IL1Iii.ILil(context);
        setContentHeight(iL1IiiILil.m1858lLi1LL());
        this.f1433IiL = iL1IiiILil.Ilil();
        LinearLayoutCompat linearLayoutCompatI1I = I1I();
        this.f1432IL = linearLayoutCompatI1I;
        addView(linearLayoutCompatI1I, new ViewGroup.LayoutParams(-2, -1));
    }

    public final LinearLayoutCompat I1I() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), null, ILil.ILil.IL1Iii.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return linearLayoutCompat;
    }

    public void IL1Iii(int i) {
        View childAt = this.f1432IL.getChildAt(i);
        Runnable runnable = this.f3853ILil;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        IL1Iii iL1Iii = new IL1Iii(childAt);
        this.f3853ILil = iL1Iii;
        post(iL1Iii);
    }

    public final Spinner ILil() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, ILil.ILil.IL1Iii.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    public final boolean Ilil() {
        Spinner spinner = this.f3854Ilil;
        return spinner != null && spinner.getParent() == this;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public IL m1852IL(ActionBar.ILil iLil, boolean z) {
        IL il = new IL(getContext(), iLil, z);
        if (z) {
            il.setBackgroundDrawable(null);
            il.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1434L11I));
        } else {
            il.setFocusable(true);
            if (this.f3852I1I == null) {
                this.f3852I1I = new I1I();
            }
            il.setOnClickListener(this.f3852I1I);
        }
        return il;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final boolean m1853iILLL1() {
        if (!Ilil()) {
            return false;
        }
        removeView(this.f3854Ilil);
        addView(this.f1432IL, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f3854Ilil.getSelectedItemPosition());
        return false;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final void m1854lLi1LL() {
        if (Ilil()) {
            return;
        }
        if (this.f3854Ilil == null) {
            this.f3854Ilil = ILil();
        }
        removeView(this.f1432IL);
        addView(this.f3854Ilil, new ViewGroup.LayoutParams(-2, -1));
        if (this.f3854Ilil.getAdapter() == null) {
            this.f3854Ilil.setAdapter((SpinnerAdapter) new ILil());
        }
        Runnable runnable = this.f3853ILil;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f3853ILil = null;
        }
        this.f3854Ilil.setSelection(this.f1437il);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f3853ILil;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ILil.ILil.p024llL1ii.IL1Iii iL1IiiILil = ILil.ILil.p024llL1ii.IL1Iii.ILil(getContext());
        setContentHeight(iL1IiiILil.m1858lLi1LL());
        this.f1433IiL = iL1IiiILil.Ilil();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f3853ILil;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((IL) view).ILil().Ilil();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f1432IL.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f1435iILLL1 = -1;
        } else {
            if (childCount > 2) {
                this.f1435iILLL1 = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.f1435iILLL1 = View.MeasureSpec.getSize(i) / 2;
            }
            this.f1435iILLL1 = Math.min(this.f1435iILLL1, this.f1433IiL);
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1434L11I, Videoio.CAP_OPENNI_IMAGE_GENERATOR);
        if (!z && this.f1436lLi1LL) {
            this.f1432IL.measure(0, iMakeMeasureSpec);
            if (this.f1432IL.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                m1854lLi1LL();
            } else {
                m1853iILLL1();
            }
        } else {
            m1853iILLL1();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, iMakeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.f1437il);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.f1436lLi1LL = z;
    }

    public void setContentHeight(int i) {
        this.f1434L11I = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.f1437il = i;
        int childCount = this.f1432IL.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f1432IL.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                IL1Iii(i);
            }
            i2++;
        }
        Spinner spinner = this.f3854Ilil;
        if (spinner == null || i < 0) {
            return;
        }
        spinner.setSelection(i);
    }
}
