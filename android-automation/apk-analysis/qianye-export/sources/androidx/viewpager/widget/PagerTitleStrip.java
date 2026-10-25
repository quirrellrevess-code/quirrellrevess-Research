package androidx.viewpager.widget;

import ILil.p028IiL.Lil.C0636il;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@ViewPager.lLi1LL
public class PagerTitleStrip extends ViewGroup {
    public static final int[] LlLI1 = {R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public static final int[] f2791llL1ii = {R.attr.textAllCaps};

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public TextView f5213I1I;
    public boolean ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public ViewPager f5214ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public int f2792ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public TextView f5215Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public TextView f2793IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public int f2794IiL;
    public int Lil;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final IL1Iii f2795Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public int f2796L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public float f2797iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public WeakReference<ILil.iIlLiL.IL1Iii.IL1Iii> f2798lIiI;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int f2799lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public boolean f2800il;

    public class IL1Iii extends DataSetObserver implements ViewPager.InterfaceC0668il, ViewPager.L11I {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public int f5216IL1Iii;

        public IL1Iii() {
        }

        @Override // androidx.viewpager.widget.ViewPager.L11I
        public void onAdapterChanged(ViewPager viewPager, ILil.iIlLiL.IL1Iii.IL1Iii iL1Iii, ILil.iIlLiL.IL1Iii.IL1Iii iL1Iii2) {
            PagerTitleStrip.this.ILil(iL1Iii, iL1Iii2);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.I1I(pagerTitleStrip.f5214ILil.getCurrentItem(), PagerTitleStrip.this.f5214ILil.getAdapter());
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            float f = pagerTitleStrip2.f2797iILLL1;
            if (f < 0.0f) {
                f = 0.0f;
            }
            pagerTitleStrip2.mo3386IL(pagerTitleStrip2.f5214ILil.getCurrentItem(), f, true);
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0668il
        public void onPageScrollStateChanged(int i) {
            this.f5216IL1Iii = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0668il
        public void onPageScrolled(int i, float f, int i2) {
            if (f > 0.5f) {
                i++;
            }
            PagerTitleStrip.this.mo3386IL(i, f, false);
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0668il
        public void onPageSelected(int i) {
            if (this.f5216IL1Iii == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.I1I(pagerTitleStrip.f5214ILil.getCurrentItem(), PagerTitleStrip.this.f5214ILil.getAdapter());
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                float f = pagerTitleStrip2.f2797iILLL1;
                if (f < 0.0f) {
                    f = 0.0f;
                }
                pagerTitleStrip2.mo3386IL(pagerTitleStrip2.f5214ILil.getCurrentItem(), f, true);
            }
        }
    }

    public static class ILil extends SingleLineTransformationMethod {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public Locale f5218ILil;

        public ILil(Context context) {
            this.f5218ILil = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f5218ILil);
            }
            return null;
        }
    }

    public PagerTitleStrip(Context context) {
        this(context, null);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new ILil(textView.getContext()));
    }

    public void I1I(int i, ILil.iIlLiL.IL1Iii.IL1Iii iL1Iii) {
        int iIlil = iL1Iii != null ? iL1Iii.Ilil() : 0;
        this.f2800il = true;
        CharSequence charSequenceMo1283iILLL1 = null;
        this.f5213I1I.setText((i < 1 || iL1Iii == null) ? null : iL1Iii.mo1283iILLL1(i - 1));
        this.f2793IL.setText((iL1Iii == null || i >= iIlil) ? null : iL1Iii.mo1283iILLL1(i));
        int i2 = i + 1;
        if (i2 < iIlil && iL1Iii != null) {
            charSequenceMo1283iILLL1 = iL1Iii.mo1283iILLL1(i2);
        }
        this.f5215Ilil.setText(charSequenceMo1283iILLL1);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.f5213I1I.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f2793IL.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f5215Ilil.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f2799lLi1LL = i;
        if (!this.ILL) {
            mo3386IL(i, this.f2797iILLL1, false);
        }
        this.f2800il = false;
    }

    public void IL1Iii(int i, float f) {
        this.f5213I1I.setTextSize(i, f);
        this.f2793IL.setTextSize(i, f);
        this.f5215Ilil.setTextSize(i, f);
    }

    public void ILil(ILil.iIlLiL.IL1Iii.IL1Iii iL1Iii, ILil.iIlLiL.IL1Iii.IL1Iii iL1Iii2) {
        if (iL1Iii != null) {
            iL1Iii.I11li1(this.f2795Ll1);
            this.f2798lIiI = null;
        }
        if (iL1Iii2 != null) {
            iL1Iii2.m2484lIiI(this.f2795Ll1);
            this.f2798lIiI = new WeakReference<>(iL1Iii2);
        }
        ViewPager viewPager = this.f5214ILil;
        if (viewPager != null) {
            this.f2799lLi1LL = -1;
            this.f2797iILLL1 = -1.0f;
            I1I(viewPager.getCurrentItem(), iL1Iii2);
            requestLayout();
        }
    }

    /* JADX INFO: renamed from: I丨L */
    public void mo3386IL(int i, float f, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (i != this.f2799lLi1LL) {
            I1I(i, this.f5214ILil.getAdapter());
        } else if (!z && f == this.f2797iILLL1) {
            return;
        }
        this.ILL = true;
        int measuredWidth = this.f5213I1I.getMeasuredWidth();
        int measuredWidth2 = this.f2793IL.getMeasuredWidth();
        int measuredWidth3 = this.f5215Ilil.getMeasuredWidth();
        int i6 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i7 = paddingRight + i6;
        int i8 = (width - (paddingLeft + i6)) - i7;
        float f2 = 0.5f + f;
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        }
        int i9 = ((width - i7) - ((int) (i8 * f2))) - i6;
        int i10 = measuredWidth2 + i9;
        int baseline = this.f5213I1I.getBaseline();
        int baseline2 = this.f2793IL.getBaseline();
        int baseline3 = this.f5215Ilil.getBaseline();
        int iMax = Math.max(Math.max(baseline, baseline2), baseline3);
        int i11 = iMax - baseline;
        int i12 = iMax - baseline2;
        int i13 = iMax - baseline3;
        int iMax2 = Math.max(Math.max(this.f5213I1I.getMeasuredHeight() + i11, this.f2793IL.getMeasuredHeight() + i12), this.f5215Ilil.getMeasuredHeight() + i13);
        int i14 = this.f2796L11I & 112;
        if (i14 != 16) {
            if (i14 != 80) {
                i3 = i11 + paddingTop;
                i4 = i12 + paddingTop;
                i5 = paddingTop + i13;
            } else {
                i2 = (height - paddingBottom) - iMax2;
            }
            TextView textView = this.f2793IL;
            textView.layout(i9, i4, i10, textView.getMeasuredHeight() + i4);
            int iMin = Math.min(paddingLeft, (i9 - this.f2794IiL) - measuredWidth);
            TextView textView2 = this.f5213I1I;
            textView2.layout(iMin, i3, measuredWidth + iMin, textView2.getMeasuredHeight() + i3);
            int iMax3 = Math.max((width - paddingRight) - measuredWidth3, i10 + this.f2794IiL);
            TextView textView3 = this.f5215Ilil;
            textView3.layout(iMax3, i5, iMax3 + measuredWidth3, textView3.getMeasuredHeight() + i5);
            this.f2797iILLL1 = f;
            this.ILL = false;
        }
        i2 = (((height - paddingTop) - paddingBottom) - iMax2) / 2;
        i3 = i11 + i2;
        i4 = i12 + i2;
        i5 = i2 + i13;
        TextView textView4 = this.f2793IL;
        textView4.layout(i9, i4, i10, textView4.getMeasuredHeight() + i4);
        int iMin2 = Math.min(paddingLeft, (i9 - this.f2794IiL) - measuredWidth);
        TextView textView5 = this.f5213I1I;
        textView5.layout(iMin2, i3, measuredWidth + iMin2, textView5.getMeasuredHeight() + i3);
        int iMax4 = Math.max((width - paddingRight) - measuredWidth3, i10 + this.f2794IiL);
        TextView textView6 = this.f5215Ilil;
        textView6.layout(iMax4, i5, iMax4 + measuredWidth3, textView6.getMeasuredHeight() + i5);
        this.f2797iILLL1 = f;
        this.ILL = false;
    }

    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.f2794IiL;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (!(parent instanceof ViewPager)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        ViewPager viewPager = (ViewPager) parent;
        ILil.iIlLiL.IL1Iii.IL1Iii adapter = viewPager.getAdapter();
        viewPager.m3387IIiI(this.f2795Ll1);
        viewPager.ILil(this.f2795Ll1);
        this.f5214ILil = viewPager;
        WeakReference<ILil.iIlLiL.IL1Iii.IL1Iii> weakReference = this.f2798lIiI;
        ILil(weakReference != null ? weakReference.get() : null, adapter);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f5214ILil;
        if (viewPager != null) {
            ILil(viewPager.getAdapter(), null);
            this.f5214ILil.m3387IIiI(null);
            this.f5214ILil.m3397L1l(this.f2795Ll1);
            this.f5214ILil = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f5214ILil != null) {
            float f = this.f2797iILLL1;
            if (f < 0.0f) {
                f = 0.0f;
            }
            mo3386IL(this.f2799lLi1LL, f, true);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int iMax;
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingTop, -2);
        int size = View.MeasureSpec.getSize(i);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i, (int) (size * 0.2f), -2);
        this.f5213I1I.measure(childMeasureSpec2, childMeasureSpec);
        this.f2793IL.measure(childMeasureSpec2, childMeasureSpec);
        this.f5215Ilil.measure(childMeasureSpec2, childMeasureSpec);
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            iMax = View.MeasureSpec.getSize(i2);
        } else {
            iMax = Math.max(getMinHeight(), this.f2793IL.getMeasuredHeight() + paddingTop);
        }
        setMeasuredDimension(size, View.resolveSizeAndState(iMax, i2, this.f2793IL.getMeasuredState() << 16));
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f2800il) {
            return;
        }
        super.requestLayout();
    }

    public void setGravity(int i) {
        this.f2796L11I = i;
        requestLayout();
    }

    public void setNonPrimaryAlpha(float f) {
        int i = ((int) (f * 255.0f)) & 255;
        this.f2792ILl = i;
        int i2 = (i << 24) | (this.Lil & 16777215);
        this.f5213I1I.setTextColor(i2);
        this.f5215Ilil.setTextColor(i2);
    }

    public void setTextColor(int i) {
        this.Lil = i;
        this.f2793IL.setTextColor(i);
        int i2 = (this.f2792ILl << 24) | (this.Lil & 16777215);
        this.f5213I1I.setTextColor(i2);
        this.f5215Ilil.setTextColor(i2);
    }

    public void setTextSpacing(int i) {
        this.f2794IiL = i;
        requestLayout();
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2799lLi1LL = -1;
        this.f2797iILLL1 = -1.0f;
        this.f2795Ll1 = new IL1Iii();
        TextView textView = new TextView(context);
        this.f5213I1I = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f2793IL = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f5215Ilil = textView3;
        addView(textView3);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, LlLI1);
        boolean z = false;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            C0636il.m2228llL1ii(this.f5213I1I, resourceId);
            C0636il.m2228llL1ii(this.f2793IL, resourceId);
            C0636il.m2228llL1ii(this.f5215Ilil, resourceId);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            IL1Iii(0, dimensionPixelSize);
        }
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            int color = typedArrayObtainStyledAttributes.getColor(2, 0);
            this.f5213I1I.setTextColor(color);
            this.f2793IL.setTextColor(color);
            this.f5215Ilil.setTextColor(color);
        }
        this.f2796L11I = typedArrayObtainStyledAttributes.getInteger(3, 80);
        typedArrayObtainStyledAttributes.recycle();
        this.Lil = this.f2793IL.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.f5213I1I.setEllipsize(TextUtils.TruncateAt.END);
        this.f2793IL.setEllipsize(TextUtils.TruncateAt.END);
        this.f5215Ilil.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f2791llL1ii);
            z = typedArrayObtainStyledAttributes2.getBoolean(0, false);
            typedArrayObtainStyledAttributes2.recycle();
        }
        if (z) {
            setSingleLineAllCaps(this.f5213I1I);
            setSingleLineAllCaps(this.f2793IL);
            setSingleLineAllCaps(this.f5215Ilil);
        } else {
            this.f5213I1I.setSingleLine();
            this.f2793IL.setSingleLine();
            this.f5215Ilil.setSingleLine();
        }
        this.f2794IiL = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }
}
