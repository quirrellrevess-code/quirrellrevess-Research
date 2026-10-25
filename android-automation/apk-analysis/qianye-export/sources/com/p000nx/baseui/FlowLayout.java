package com.p000nx.baseui;

import I1I.p062Ilil.p013IL.IL1Iii;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(14)
public class FlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final List<List<View>> f5408I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f5409ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final List<Integer> f5410Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final List<Integer> f2951IL;

    public FlowLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static boolean m3499IL() {
        return Build.VERSION.SDK_INT >= 14;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: I1I, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public int getGravity() {
        return this.f5409ILil;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0179  */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        int i5;
        int i6;
        int i7;
        int i8;
        FlowLayout flowLayout = this;
        flowLayout.f5408I1I.clear();
        flowLayout.f2951IL.clear();
        flowLayout.f5410Ilil.clear();
        int width = getWidth();
        int height = getHeight();
        int paddingTop = getPaddingTop();
        ArrayList arrayList = new ArrayList();
        int i9 = flowLayout.f5409ILil & 7;
        if (i9 != 1) {
            f = i9 != 5 ? 0.0f : 1.0f;
        } else {
            f = 0.5f;
        }
        int i10 = 0;
        int iMax = 0;
        int i11 = 0;
        while (true) {
            i5 = 8;
            if (i10 >= getChildCount()) {
                break;
            }
            View childAt = flowLayout.getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int measuredHeight = childAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                if (i11 + measuredWidth > width) {
                    flowLayout.f2951IL.add(Integer.valueOf(iMax));
                    flowLayout.f5408I1I.add(arrayList);
                    flowLayout.f5410Ilil.add(Integer.valueOf(((int) ((width - i11) * f)) + getPaddingLeft()));
                    paddingTop += iMax;
                    arrayList = new ArrayList();
                    iMax = 0;
                    i11 = 0;
                }
                i11 += measuredWidth;
                iMax = Math.max(iMax, measuredHeight);
                arrayList.add(childAt);
            }
            i10++;
        }
        flowLayout.f2951IL.add(Integer.valueOf(iMax));
        flowLayout.f5408I1I.add(arrayList);
        flowLayout.f5410Ilil.add(Integer.valueOf(((int) ((width - i11) * f)) + getPaddingLeft()));
        int i12 = paddingTop + iMax;
        int i13 = flowLayout.f5409ILil & 112;
        if (i13 != 16) {
            i6 = i13 != 80 ? 0 : height - i12;
        } else {
            i6 = (height - i12) / 2;
        }
        int size = flowLayout.f5408I1I.size();
        int paddingTop2 = getPaddingTop();
        int i14 = 0;
        while (i14 < size) {
            int iIntValue = flowLayout.f2951IL.get(i14).intValue();
            List<View> list = flowLayout.f5408I1I.get(i14);
            int iIntValue2 = flowLayout.f5410Ilil.get(i14).intValue();
            int size2 = list.size();
            int i15 = 0;
            while (i15 < size2) {
                View view = list.get(i15);
                if (view.getVisibility() != i5) {
                    LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                    if (((ViewGroup.MarginLayoutParams) layoutParams2).height == -1) {
                        int i16 = ((ViewGroup.MarginLayoutParams) layoutParams2).width;
                        if (i16 == -1) {
                            i16 = i11;
                        } else {
                            if (i16 < 0) {
                                i16 = i11;
                                i8 = Integer.MIN_VALUE;
                            }
                            view.measure(View.MeasureSpec.makeMeasureSpec(i16, i8), View.MeasureSpec.makeMeasureSpec((iIntValue - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, Videoio.CAP_OPENNI_IMAGE_GENERATOR));
                        }
                        i8 = Videoio.CAP_OPENNI_IMAGE_GENERATOR;
                        view.measure(View.MeasureSpec.makeMeasureSpec(i16, i8), View.MeasureSpec.makeMeasureSpec((iIntValue - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, Videoio.CAP_OPENNI_IMAGE_GENERATOR));
                    }
                    int measuredWidth2 = view.getMeasuredWidth();
                    int measuredHeight2 = view.getMeasuredHeight();
                    if (Gravity.isVertical(layoutParams2.f5411IL1Iii)) {
                        int i17 = layoutParams2.f5411IL1Iii;
                        if (i17 == 16 || i17 == 17) {
                            i7 = (((iIntValue - measuredHeight2) - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin) / 2;
                        } else if (i17 != 80) {
                            i7 = 0;
                        } else {
                            i7 = ((iIntValue - measuredHeight2) - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                        }
                    } else {
                        i7 = 0;
                    }
                    int i18 = ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
                    int i19 = ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
                    view.layout(iIntValue2 + i18, paddingTop2 + i19 + i7 + i6, iIntValue2 + measuredWidth2 + i18, measuredHeight2 + paddingTop2 + i19 + i7 + i6);
                    iIntValue2 += measuredWidth2 + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                }
                i15++;
                size = size;
                i11 = i11;
                list = list;
                i5 = 8;
            }
            paddingTop2 += iIntValue;
            i14++;
            flowLayout = this;
            i5 = 8;
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x008c  */
    /* JADX WARN: Code duplicated, block: B:24:0x008f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0091  */
    /* JADX WARN: Code duplicated, block: B:26:0x0094  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:30:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:32:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d9 A[SYNTHETIC] */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int measuredWidth;
        super.onMeasure(i, i2);
        int size = (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childCount = getChildCount();
        int i6 = paddingTop;
        int iMax = 0;
        int i7 = 0;
        int i8 = 0;
        int iMax2 = 0;
        while (i8 < childCount) {
            View childAt = getChildAt(i8);
            boolean z = i8 == childCount + (-1);
            if (childAt.getVisibility() == 8) {
                if (z) {
                    iMax2 = Math.max(iMax2, i7);
                    i6 += iMax;
                }
                i3 = size2;
            } else {
                int i9 = iMax;
                i3 = size2;
                int i10 = i7;
                measureChildWithMargins(childAt, i, i7, i2, i6);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i11 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                int i12 = Integer.MIN_VALUE;
                if (i11 == -1) {
                    i11 = size - (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                } else {
                    if (i11 < 0) {
                        i11 = size;
                        i4 = Integer.MIN_VALUE;
                    }
                    i5 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                    if (i5 >= 0) {
                        i12 = Videoio.CAP_OPENNI_IMAGE_GENERATOR;
                    } else if (mode2 == 0) {
                        i12 = 0;
                        i5 = 0;
                    } else {
                        i5 = i3;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i11, i4), View.MeasureSpec.makeMeasureSpec(i5, i12));
                    measuredWidth = childAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    i7 = i10 + measuredWidth;
                    if (i7 > size) {
                        iMax2 = Math.max(iMax2, i10);
                        i6 += i9;
                        i7 = measuredWidth;
                        iMax = childAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    } else {
                        iMax = Math.max(i9, childAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                    }
                    if (z) {
                        iMax2 = Math.max(iMax2, i7);
                        i6 += iMax;
                    }
                }
                i4 = Videoio.CAP_OPENNI_IMAGE_GENERATOR;
                i5 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                if (i5 >= 0) {
                    i12 = Videoio.CAP_OPENNI_IMAGE_GENERATOR;
                } else if (mode2 == 0) {
                    i12 = 0;
                    i5 = 0;
                } else {
                    i5 = i3;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i11, i4), View.MeasureSpec.makeMeasureSpec(i5, i12));
                measuredWidth = childAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                i7 = i10 + measuredWidth;
                if (i7 > size) {
                    iMax2 = Math.max(iMax2, i10);
                    i6 += i9;
                    i7 = measuredWidth;
                    iMax = childAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                } else {
                    iMax = Math.max(i9, childAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                }
                if (z) {
                    iMax2 = Math.max(iMax2, i7);
                    i6 += iMax;
                }
            }
            i8++;
            size2 = i3;
        }
        int i13 = size2;
        int paddingLeft = iMax2 + getPaddingLeft() + getPaddingRight();
        if (mode != 1073741824) {
            size = paddingLeft;
        }
        setMeasuredDimension(size, mode2 == 1073741824 ? i13 : i6);
    }

    @TargetApi(14)
    public void setGravity(int i) {
        if (this.f5409ILil != i) {
            if ((8388615 & i) == 0) {
                i |= m3499IL() ? 8388611 : 3;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.f5409ILil = i;
            requestLayout();
        }
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5409ILil = (m3499IL() ? 8388611 : 3) | 48;
        this.f5408I1I = new ArrayList();
        this.f2951IL = new ArrayList();
        this.f5410Ilil = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, IL1Iii.FlowLayout, i, 0);
        try {
            int i2 = typedArrayObtainStyledAttributes.getInt(0, -1);
            if (i2 > 0) {
                setGravity(i2);
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public int f5411IL1Iii;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f5411IL1Iii = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, IL1Iii.FlowLayout_Layout);
            try {
                this.f5411IL1Iii = typedArrayObtainStyledAttributes.getInt(0, -1);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f5411IL1Iii = -1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f5411IL1Iii = -1;
        }
    }
}
