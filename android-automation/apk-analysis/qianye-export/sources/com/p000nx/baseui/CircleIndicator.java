package com.p000nx.baseui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.qyzs.smn2.R;

/* JADX INFO: loaded from: classes.dex */
public class CircleIndicator extends LinearLayout {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Animator f5403I1I;
    public int ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Animator f5404ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final ViewPager.InterfaceC0668il f2942ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public int f5405Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f2943IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public int f2944IiL;
    public int Lil;
    public ViewPager LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public int f2945Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public int f2946L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public Animator f2947iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public DataSetObserver f2948lIiI;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public Animator f2949lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public int f2950il;

    public class I1I implements Interpolator {
        public /* synthetic */ I1I(CircleIndicator circleIndicator, IL1Iii iL1Iii) {
            this(circleIndicator);
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return Math.abs(1.0f - f);
        }

        public I1I(CircleIndicator circleIndicator) {
        }
    }

    public class IL1Iii extends DataSetObserver {
        public IL1Iii() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            int iIlil;
            super.onChanged();
            ViewPager viewPager = CircleIndicator.this.LlLI1;
            if (viewPager == null || (iIlil = viewPager.getAdapter().Ilil()) == CircleIndicator.this.getChildCount()) {
                return;
            }
            CircleIndicator circleIndicator = CircleIndicator.this;
            if (circleIndicator.Lil < iIlil) {
                circleIndicator.Lil = circleIndicator.LlLI1.getCurrentItem();
            } else {
                circleIndicator.Lil = -1;
            }
            CircleIndicator.this.Ilil();
        }
    }

    public class ILil implements ViewPager.InterfaceC0668il {
        public ILil() {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0668il
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0668il
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0668il
        public void onPageSelected(int i) {
            View childAt;
            if (CircleIndicator.this.LlLI1.getAdapter() == null || CircleIndicator.this.LlLI1.getAdapter().Ilil() <= 0) {
                return;
            }
            if (CircleIndicator.this.f5404ILil.isRunning()) {
                CircleIndicator.this.f5404ILil.end();
                CircleIndicator.this.f5404ILil.cancel();
            }
            if (CircleIndicator.this.f5403I1I.isRunning()) {
                CircleIndicator.this.f5403I1I.end();
                CircleIndicator.this.f5403I1I.cancel();
            }
            CircleIndicator circleIndicator = CircleIndicator.this;
            int i2 = circleIndicator.Lil;
            if (i2 >= 0 && (childAt = circleIndicator.getChildAt(i2)) != null) {
                childAt.setBackgroundResource(CircleIndicator.this.ILL);
                CircleIndicator.this.f5404ILil.setTarget(childAt);
                CircleIndicator.this.f5404ILil.start();
            }
            View childAt2 = CircleIndicator.this.getChildAt(i);
            if (childAt2 != null) {
                childAt2.setBackgroundResource(CircleIndicator.this.f2944IiL);
                CircleIndicator.this.f5403I1I.setTarget(childAt2);
                CircleIndicator.this.f5403I1I.start();
            }
            CircleIndicator.this.Lil = i;
        }
    }

    public CircleIndicator(Context context) {
        super(context);
        this.f2943IL = R.animator.no_animator;
        this.f5405Ilil = 0;
        this.f2944IiL = R.mipmap.ci_blue_point;
        this.f2946L11I = -1;
        this.f2950il = -1;
        this.ILL = R.mipmap.ci_gray_point;
        this.f2945Ll1 = -1;
        this.f2948lIiI = new IL1Iii();
        this.f2942ILl = new ILil();
        this.Lil = -1;
        m3496IiL(context, null);
    }

    public final Animator I1I(Context context) {
        int i = this.f5405Ilil;
        if (i != 0) {
            return AnimatorInflater.loadAnimator(context, i);
        }
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, this.f2943IL);
        animatorLoadAnimator.setInterpolator(new I1I(this, null));
        return animatorLoadAnimator;
    }

    public final void IL1Iii(int i, int i2, Animator animator) {
        if (animator.isRunning()) {
            animator.end();
            animator.cancel();
        }
        View view = new View(getContext());
        view.setBackgroundResource(i2);
        addView(view, this.f2945Ll1, this.f2946L11I);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (i == 0) {
            int i3 = this.f2950il;
            layoutParams.leftMargin = i3;
            layoutParams.rightMargin = i3;
        } else {
            int i4 = this.f2950il;
            layoutParams.topMargin = i4;
            layoutParams.bottomMargin = i4;
        }
        view.setLayoutParams(layoutParams);
        animator.setTarget(view);
        animator.start();
    }

    public final void ILil(Context context) {
        int iM3498lLi1LL = this.f2945Ll1;
        if (iM3498lLi1LL < 0) {
            iM3498lLi1LL = m3498lLi1LL(8.0f);
        }
        this.f2945Ll1 = iM3498lLi1LL;
        int iM3498lLi1LL2 = this.f2946L11I;
        if (iM3498lLi1LL2 < 0) {
            iM3498lLi1LL2 = m3498lLi1LL(8.0f);
        }
        this.f2946L11I = iM3498lLi1LL2;
        int iM3498lLi1LL3 = this.f2950il;
        if (iM3498lLi1LL3 < 0) {
            iM3498lLi1LL3 = m3498lLi1LL(8.0f);
        }
        this.f2950il = iM3498lLi1LL3;
        int i = this.f2943IL;
        if (i == 0) {
            i = R.animator.scale_with_alpha;
        }
        this.f2943IL = i;
        this.f5403I1I = m3495IL(context);
        Animator animatorM3495IL = m3495IL(context);
        this.f2947iILLL1 = animatorM3495IL;
        animatorM3495IL.setDuration(0L);
        this.f5404ILil = I1I(context);
        Animator animatorI1I = I1I(context);
        this.f2949lLi1LL = animatorI1I;
        animatorI1I.setDuration(0L);
        int i2 = this.f2944IiL;
        if (i2 == 0) {
            i2 = R.drawable.white_radius;
        }
        this.f2944IiL = i2;
        int i3 = this.ILL;
        if (i3 != 0) {
            i2 = i3;
        }
        this.ILL = i2;
    }

    public void Ilil() {
        removeAllViews();
        int iIlil = this.LlLI1.getAdapter().Ilil();
        if (iIlil > 0) {
            int currentItem = this.LlLI1.getCurrentItem();
            int orientation = getOrientation();
            for (int i = 0; i < iIlil; i++) {
                if (currentItem == i) {
                    IL1Iii(orientation, this.f2944IiL, this.f2947iILLL1);
                } else {
                    IL1Iii(orientation, this.ILL, this.f2949lLi1LL);
                }
            }
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final Animator m3495IL(Context context) {
        return AnimatorInflater.loadAnimator(context, this.f2943IL);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final void m3496IiL(Context context, AttributeSet attributeSet) {
        m3497iILLL1(context, attributeSet);
        ILil(context);
    }

    public DataSetObserver getDataSetObserver() {
        return this.f2948lIiI;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final void m3497iILLL1(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, I1I.p062Ilil.p013IL.IL1Iii.CircleIndicator);
            this.f2945Ll1 = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, -1);
            this.f2946L11I = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, -1);
            this.f2950il = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, -1);
            this.f2943IL = typedArrayObtainStyledAttributes.getResourceId(0, R.animator.scale_with_alpha);
            this.f5405Ilil = typedArrayObtainStyledAttributes.getResourceId(1, 0);
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(2, R.drawable.white_radius);
            this.f2944IiL = resourceId;
            this.ILL = typedArrayObtainStyledAttributes.getResourceId(3, resourceId);
            setOrientation(typedArrayObtainStyledAttributes.getInt(7, -1) == 1 ? 1 : 0);
            int i = typedArrayObtainStyledAttributes.getInt(4, -1);
            if (i < 0) {
                i = 17;
            }
            setGravity(i);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int m3498lLi1LL(float f) {
        return (int) ((f * getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Deprecated
    public void setOnPageChangeListener(ViewPager.InterfaceC0668il interfaceC0668il) {
        ViewPager viewPager = this.LlLI1;
        if (viewPager == null) {
            throw new NullPointerException(I1I.IL1Iii.IL1Iii(new byte[]{86, 7, 11, 18, 11, 86, 65, 70, 3, 91, 11, 93, 21, 48, 12, 87, 18, 73, 84, 1, 0, 64, 69, 21, 21, 21, 0, 70, 51, 80, 80, 17, 53, 83, 2, 92, 71, 70, 3, 91, 23, 74, 65}, I1I.IL1Iii.IL1Iii(new byte[]{5, 85, 6, 87, 1, 95}, I1I.IL1Iii.IL1Iii(new byte[]{84, 5, 84, 86, 0, 5}, "d673dc"))));
        }
        viewPager.m3409iILLl(interfaceC0668il);
        this.LlLI1.I1I(interfaceC0668il);
    }

    public void setViewPager(ViewPager viewPager) {
        this.LlLI1 = viewPager;
        if (viewPager == null || viewPager.getAdapter() == null) {
            return;
        }
        this.Lil = -1;
        Ilil();
        this.LlLI1.m3409iILLl(this.f2942ILl);
        this.LlLI1.I1I(this.f2942ILl);
        this.f2942ILl.onPageSelected(this.LlLI1.getCurrentItem());
    }

    public CircleIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2943IL = R.animator.no_animator;
        this.f5405Ilil = 0;
        this.f2944IiL = R.mipmap.ci_blue_point;
        this.f2946L11I = -1;
        this.f2950il = -1;
        this.ILL = R.mipmap.ci_gray_point;
        this.f2945Ll1 = -1;
        this.f2948lIiI = new IL1Iii();
        this.f2942ILl = new ILil();
        this.Lil = -1;
        m3496IiL(context, attributeSet);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2943IL = R.animator.no_animator;
        this.f5405Ilil = 0;
        this.f2944IiL = R.mipmap.ci_blue_point;
        this.f2946L11I = -1;
        this.f2950il = -1;
        this.ILL = R.mipmap.ci_gray_point;
        this.f2945Ll1 = -1;
        this.f2948lIiI = new IL1Iii();
        this.f2942ILl = new ILil();
        this.Lil = -1;
        m3496IiL(context, attributeSet);
    }
}
