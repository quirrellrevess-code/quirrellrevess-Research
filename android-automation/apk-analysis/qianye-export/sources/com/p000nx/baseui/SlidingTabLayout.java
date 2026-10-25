package com.p000nx.baseui;

import I1I.p062Ilil.ILil.IiL;
import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.qyzs.smn2.R;

/* JADX INFO: loaded from: classes.dex */
public class SlidingTabLayout extends HorizontalScrollView {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public boolean f5415I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public SparseArray<String> f5416ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public int f5417Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final I1I.p062Ilil.ILil.ILil f2954IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public ViewPager f2955IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public ViewPager.InterfaceC0668il f2956L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int f2957iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int f2958lLi1LL;

    public class I1I implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (int i = 0; i < SlidingTabLayout.this.f2954IL.getChildCount(); i++) {
                if (view == SlidingTabLayout.this.f2954IL.getChildAt(i)) {
                    SlidingTabLayout.this.f2955IiL.setCurrentItem(i);
                    return;
                }
            }
        }

        public I1I() {
        }
    }

    public class ILil implements ViewPager.InterfaceC0668il {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public int f5419IL1Iii;

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0668il
        public void onPageScrollStateChanged(int i) {
            this.f5419IL1Iii = i;
            ViewPager.InterfaceC0668il interfaceC0668il = SlidingTabLayout.this.f2956L11I;
            if (interfaceC0668il != null) {
                interfaceC0668il.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0668il
        public void onPageScrolled(int i, float f, int i2) {
            int childCount = SlidingTabLayout.this.f2954IL.getChildCount();
            if (childCount == 0 || i < 0 || i >= childCount) {
                return;
            }
            SlidingTabLayout.this.f2954IL.ILil(i, f);
            View childAt = SlidingTabLayout.this.f2954IL.getChildAt(i);
            SlidingTabLayout.this.m3500IL(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
            ViewPager.InterfaceC0668il interfaceC0668il = SlidingTabLayout.this.f2956L11I;
            if (interfaceC0668il != null) {
                interfaceC0668il.onPageScrolled(i, f, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0668il
        public void onPageSelected(int i) {
            if (this.f5419IL1Iii == 0) {
                SlidingTabLayout.this.f2954IL.ILil(i, 0.0f);
                SlidingTabLayout.this.m3500IL(i, 0);
            }
            int i2 = 0;
            while (i2 < SlidingTabLayout.this.f2954IL.getChildCount()) {
                SlidingTabLayout.this.f2954IL.getChildAt(i2).setSelected(i == i2);
                i2++;
            }
            ViewPager.InterfaceC0668il interfaceC0668il = SlidingTabLayout.this.f2956L11I;
            if (interfaceC0668il != null) {
                interfaceC0668il.onPageSelected(i);
            }
        }

        public ILil() {
        }
    }

    /* JADX INFO: renamed from: com.nx.baseui.SlidingTabLayout$I丨L, reason: invalid class name */
    public interface IL {
        int IL1Iii(int i);
    }

    public SlidingTabLayout(Context context) {
        this(context, null);
    }

    public final void I1I() {
        View viewILil;
        TextView textView;
        ILil.iIlLiL.IL1Iii.IL1Iii adapter = this.f2955IiL.getAdapter();
        I1I i1i = new I1I();
        for (int i = 0; i < adapter.Ilil(); i++) {
            if (this.f5417Ilil != 0) {
                viewILil = LayoutInflater.from(getContext()).inflate(this.f5417Ilil, (ViewGroup) this.f2954IL, false);
                textView = (TextView) viewILil.findViewById(this.f2958lLi1LL);
            } else {
                viewILil = null;
                textView = null;
            }
            if (viewILil == null) {
                viewILil = ILil(getContext());
            }
            if (textView == null && TextView.class.isInstance(viewILil)) {
                textView = (TextView) viewILil;
            }
            if (this.f5415I1I) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewILil.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
            }
            textView.setTextColor(getResources().getColorStateList(R.color.selector_tab));
            textView.setTextSize(2, 14.0f);
            textView.setText(adapter.mo1283iILLL1(i));
            textView.setAllCaps(false);
            viewILil.setOnClickListener(i1i);
            String str = this.f5416ILil.get(i, null);
            if (str != null) {
                viewILil.setContentDescription(str);
            }
            this.f2954IL.addView(viewILil);
            if (i == this.f2955IiL.getCurrentItem()) {
                viewILil.setSelected(true);
            }
        }
    }

    public void IL1Iii(LinearLayout linearLayout, String str) {
        IiL iiL = (IiL) this.f2955IiL.getAdapter();
        iiL.m1285lL(linearLayout, str);
        this.f2955IiL.setAdapter(iiL);
        setViewPager(this.f2955IiL);
    }

    public TextView ILil(Context context) {
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setTextSize(2, 12.0f);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(android.R.attr.selectableItemBackground, typedValue, true);
        textView.setBackgroundResource(typedValue.resourceId);
        textView.setAllCaps(true);
        int i = (int) (getResources().getDisplayMetrics().density * 4.0f);
        textView.setPadding(i, i, i, i);
        textView.setSingleLine(true);
        return textView;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m3500IL(int i, int i2) {
        View childAt;
        int childCount = this.f2954IL.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.f2954IL.getChildAt(i)) == null) {
            return;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.f2957iILLL1;
        }
        scrollTo(left, 0);
    }

    public ViewPager getViewPager() {
        return this.f2955IiL;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewPager viewPager = this.f2955IiL;
        if (viewPager != null) {
            m3500IL(viewPager.getCurrentItem(), 0);
        }
    }

    public void setCustomTabColorizer(IL il) {
        this.f2954IL.m1281IL(il);
    }

    public void setDistributeEvenly(boolean z) {
        this.f5415I1I = z;
    }

    public void setOnPageChangeListener(ViewPager.InterfaceC0668il interfaceC0668il) {
        this.f2956L11I = interfaceC0668il;
    }

    public void setSelectedIndicatorColors(int... iArr) {
        this.f2954IL.Ilil(iArr);
    }

    public void setViewPager(ViewPager viewPager) {
        this.f2954IL.removeAllViews();
        this.f2955IiL = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new ILil());
            I1I();
        }
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5416ILil = new SparseArray<>();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.f2957iILLL1 = (int) (getResources().getDisplayMetrics().density * 24.0f);
        I1I.p062Ilil.ILil.ILil iLil = new I1I.p062Ilil.ILil.ILil(context);
        this.f2954IL = iLil;
        addView(iLil, -1, -2);
    }
}
