package com.p000nx.baseui;

import I1I.p062Ilil.ILil.IiL;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes.dex */
public class ViewPagerEx extends ViewPager {
    public boolean L1iI1;

    /* JADX INFO: renamed from: lL */
    public boolean f96lL;

    /* JADX INFO: renamed from: 丨i1丨1i, reason: contains not printable characters */
    public int f2959i11i;

    public ViewPagerEx(Context context) {
        super(context);
        this.f2959i11i = 0;
        this.L1iI1 = false;
        this.f96lL = true;
    }

    /* JADX INFO: renamed from: iI1i丨I, reason: contains not printable characters */
    public void m3501iI1iI(int i) {
        if (this.L1iI1 && getChildCount() > i) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-1, this.f2959i11i);
            } else {
                layoutParams.height = this.f2959i11i;
            }
            setLayoutParams(layoutParams);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i, int i2) {
        View viewM1286l;
        if (this.L1iI1 && getAdapter() != null && (viewM1286l = ((IiL) getAdapter()).m1286l(getCurrentItem())) != null) {
            viewM1286l.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredHeight = viewM1286l.getMeasuredHeight();
            this.f2959i11i = measuredHeight;
            i2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, Videoio.CAP_OPENNI_IMAGE_GENERATOR);
        }
        super.onMeasure(i, i2);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f96lL) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setIsNeedSetHeight(boolean z) {
        this.L1iI1 = z;
    }

    public void setScrollble(boolean z) {
        this.f96lL = z;
    }

    public ViewPagerEx(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2959i11i = 0;
        this.L1iI1 = false;
        this.f96lL = true;
    }
}
