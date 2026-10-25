package com.google.android.flexbox;

import ILil.p028IiL.p029ILl.iILLL1;
import ILil.p028IiL.p029ILl.iIlLiL;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.http2.Http2Connection;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes.dex */
public class FlexboxLayout extends ViewGroup {
    public static final int ALIGN_CONTENT_CENTER = 2;
    public static final int ALIGN_CONTENT_FLEX_END = 1;
    public static final int ALIGN_CONTENT_FLEX_START = 0;
    public static final int ALIGN_CONTENT_SPACE_AROUND = 4;
    public static final int ALIGN_CONTENT_SPACE_BETWEEN = 3;
    public static final int ALIGN_CONTENT_STRETCH = 5;
    public static final int ALIGN_ITEMS_BASELINE = 3;
    public static final int ALIGN_ITEMS_CENTER = 2;
    public static final int ALIGN_ITEMS_FLEX_END = 1;
    public static final int ALIGN_ITEMS_FLEX_START = 0;
    public static final int ALIGN_ITEMS_STRETCH = 4;
    public static final int FLEX_DIRECTION_COLUMN = 2;
    public static final int FLEX_DIRECTION_COLUMN_REVERSE = 3;
    public static final int FLEX_DIRECTION_ROW = 0;
    public static final int FLEX_DIRECTION_ROW_REVERSE = 1;
    public static final int FLEX_WRAP_NOWRAP = 0;
    public static final int FLEX_WRAP_WRAP = 1;
    public static final int FLEX_WRAP_WRAP_REVERSE = 2;
    public static final int JUSTIFY_CONTENT_CENTER = 2;
    public static final int JUSTIFY_CONTENT_FLEX_END = 1;
    public static final int JUSTIFY_CONTENT_FLEX_START = 0;
    public static final int JUSTIFY_CONTENT_SPACE_AROUND = 4;
    public static final int JUSTIFY_CONTENT_SPACE_BETWEEN = 3;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    private int mAlignContent;
    private int mAlignItems;
    private boolean[] mChildrenFrozen;
    private Drawable mDividerDrawableHorizontal;
    private Drawable mDividerDrawableVertical;
    private int mDividerHorizontalHeight;
    private int mDividerVerticalWidth;
    private int mFlexDirection;
    private List<FlexLine> mFlexLines;
    private int mFlexWrap;
    private int mJustifyContent;
    private SparseIntArray mOrderCache;
    private int[] mReorderedIndices;
    private int mShowDividerHorizontal;
    private int mShowDividerVertical;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AlignContent {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AlignItems {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FlexDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FlexWrap {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface JustifyContent {
    }

    public static class Order implements Comparable<Order> {
        public int index;
        public int order;

        private Order() {
        }

        public String toString() {
            return "Order{order=" + this.order + ", index=" + this.index + '}';
        }

        @Override // java.lang.Comparable
        public int compareTo(Order order) {
            int i = this.order;
            int i2 = order.order;
            return i != i2 ? i - i2 : this.index - order.index;
        }
    }

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    private void addFlexLine(FlexLine flexLine) {
        if (isMainAxisDirectionHorizontal(this.mFlexDirection)) {
            if ((this.mShowDividerVertical & 4) > 0) {
                int i = flexLine.mMainSize;
                int i2 = this.mDividerVerticalWidth;
                flexLine.mMainSize = i + i2;
                flexLine.mDividerLengthInMainSize += i2;
            }
        } else if ((this.mShowDividerHorizontal & 4) > 0) {
            int i3 = flexLine.mMainSize;
            int i4 = this.mDividerHorizontalHeight;
            flexLine.mMainSize = i3 + i4;
            flexLine.mDividerLengthInMainSize += i4;
        }
        this.mFlexLines.add(flexLine);
    }

    private void addFlexLineIfLastFlexItem(int i, int i2, FlexLine flexLine) {
        if (i != i2 - 1 || flexLine.getItemCountNotGone() == 0) {
            return;
        }
        addFlexLine(flexLine);
    }

    private boolean allFlexLinesAreDummyBefore(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.mFlexLines.get(i2).getItemCountNotGone() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean allViewsAreGoneBefore(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View reorderedChildAt = getReorderedChildAt(i - i3);
            if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0017 A[PHI: r4
  0x0017: PHI (r4v3 int) = (r4v0 int), (r4v1 int) binds: [B:3:0x0015, B:6:0x0020] A[DONT_GENERATE, DONT_INLINE]] */
    private void checkSizeConstraints(View view) {
        boolean z;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int measuredWidth2 = view.getMeasuredWidth();
        int i = layoutParams.minWidth;
        boolean z2 = true;
        if (measuredWidth2 < i) {
            measuredWidth = i;
            z = true;
        } else {
            int measuredWidth3 = view.getMeasuredWidth();
            i = layoutParams.maxWidth;
            if (measuredWidth3 > i) {
                measuredWidth = i;
                z = true;
            } else {
                z = false;
            }
        }
        int i2 = layoutParams.minHeight;
        if (measuredHeight < i2) {
            measuredHeight = i2;
        } else {
            int i3 = layoutParams.maxHeight;
            if (measuredHeight > i3) {
                measuredHeight = i3;
            } else {
                z2 = z;
            }
        }
        if (z2) {
            view.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, Videoio.CAP_OPENNI_IMAGE_GENERATOR), View.MeasureSpec.makeMeasureSpec(measuredHeight, Videoio.CAP_OPENNI_IMAGE_GENERATOR));
        }
    }

    private List<Order> createOrders(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
            Order order = new Order();
            order.order = layoutParams.order;
            order.index = i2;
            arrayList.add(order);
        }
        return arrayList;
    }

    private int[] createReorderedIndices(View view, int i, ViewGroup.LayoutParams layoutParams) {
        int childCount = getChildCount();
        List<Order> listCreateOrders = createOrders(childCount);
        Order order = new Order();
        if (view == null || !(layoutParams instanceof LayoutParams)) {
            order.order = 1;
        } else {
            order.order = ((LayoutParams) layoutParams).order;
        }
        if (i == -1 || i == childCount || i >= getChildCount()) {
            order.index = childCount;
        } else {
            order.index = i;
            while (i < childCount) {
                listCreateOrders.get(i).index++;
                i++;
            }
        }
        listCreateOrders.add(order);
        return sortOrdersIntoReorderedIndices(childCount + 1, listCreateOrders);
    }

    private void determineCrossSize(int i, int i2, int i3, int i4) {
        int mode;
        int size;
        if (i == 0 || i == 1) {
            mode = View.MeasureSpec.getMode(i3);
            size = View.MeasureSpec.getSize(i3);
        } else {
            if (i != 2 && i != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + i);
            }
            mode = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
        }
        if (mode == 1073741824) {
            int sumOfCrossSize = getSumOfCrossSize() + i4;
            int i5 = 0;
            if (this.mFlexLines.size() == 1) {
                this.mFlexLines.get(0).mCrossSize = size - i4;
                return;
            }
            if (this.mFlexLines.size() < 2 || sumOfCrossSize >= size) {
                return;
            }
            int i6 = this.mAlignContent;
            if (i6 == 1) {
                int i7 = size - sumOfCrossSize;
                FlexLine flexLine = new FlexLine();
                flexLine.mCrossSize = i7;
                this.mFlexLines.add(0, flexLine);
                return;
            }
            if (i6 == 2) {
                int i8 = (size - sumOfCrossSize) / 2;
                ArrayList arrayList = new ArrayList();
                FlexLine flexLine2 = new FlexLine();
                flexLine2.mCrossSize = i8;
                int size2 = this.mFlexLines.size();
                while (i5 < size2) {
                    if (i5 == 0) {
                        arrayList.add(flexLine2);
                    }
                    arrayList.add(this.mFlexLines.get(i5));
                    if (i5 == this.mFlexLines.size() - 1) {
                        arrayList.add(flexLine2);
                    }
                    i5++;
                }
                this.mFlexLines = arrayList;
                return;
            }
            if (i6 == 3) {
                float size3 = (size - sumOfCrossSize) / (this.mFlexLines.size() - 1);
                ArrayList arrayList2 = new ArrayList();
                int size4 = this.mFlexLines.size();
                float f = 0.0f;
                while (i5 < size4) {
                    arrayList2.add(this.mFlexLines.get(i5));
                    if (i5 != this.mFlexLines.size() - 1) {
                        FlexLine flexLine3 = new FlexLine();
                        if (i5 == this.mFlexLines.size() - 2) {
                            flexLine3.mCrossSize = Math.round(f + size3);
                            f = 0.0f;
                        } else {
                            flexLine3.mCrossSize = Math.round(size3);
                        }
                        int i9 = flexLine3.mCrossSize;
                        f += size3 - i9;
                        if (f > 1.0f) {
                            flexLine3.mCrossSize = i9 + 1;
                            f -= 1.0f;
                        } else if (f < -1.0f) {
                            flexLine3.mCrossSize = i9 - 1;
                            f += 1.0f;
                        }
                        arrayList2.add(flexLine3);
                    }
                    i5++;
                }
                this.mFlexLines = arrayList2;
                return;
            }
            if (i6 == 4) {
                int size5 = (size - sumOfCrossSize) / (this.mFlexLines.size() * 2);
                ArrayList arrayList3 = new ArrayList();
                FlexLine flexLine4 = new FlexLine();
                flexLine4.mCrossSize = size5;
                for (FlexLine flexLine5 : this.mFlexLines) {
                    arrayList3.add(flexLine4);
                    arrayList3.add(flexLine5);
                    arrayList3.add(flexLine4);
                }
                this.mFlexLines = arrayList3;
                return;
            }
            if (i6 != 5) {
                return;
            }
            float size6 = (size - sumOfCrossSize) / this.mFlexLines.size();
            int size7 = this.mFlexLines.size();
            float f2 = 0.0f;
            while (i5 < size7) {
                FlexLine flexLine6 = this.mFlexLines.get(i5);
                float f3 = flexLine6.mCrossSize + size6;
                if (i5 == this.mFlexLines.size() - 1) {
                    f3 += f2;
                    f2 = 0.0f;
                }
                int iRound = Math.round(f3);
                f2 += f3 - iRound;
                if (f2 > 1.0f) {
                    iRound++;
                    f2 -= 1.0f;
                } else if (f2 < -1.0f) {
                    iRound--;
                    f2 += 1.0f;
                }
                flexLine6.mCrossSize = iRound;
                i5++;
            }
        }
    }

    private void determineMainSize(int i, int i2, int i3) {
        int size;
        int paddingLeft;
        int paddingRight;
        if (i == 0 || i == 1) {
            int mode = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            if (mode != 1073741824) {
                size = getLargestMainSize();
            }
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
        } else {
            if (i != 2 && i != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + i);
            }
            int mode2 = View.MeasureSpec.getMode(i3);
            size = View.MeasureSpec.getSize(i3);
            if (mode2 != 1073741824) {
                size = getLargestMainSize();
            }
            paddingLeft = getPaddingTop();
            paddingRight = getPaddingBottom();
        }
        int i4 = paddingLeft + paddingRight;
        int i5 = size;
        int iExpandFlexItems = 0;
        for (FlexLine flexLine : this.mFlexLines) {
            iExpandFlexItems = flexLine.mMainSize < i5 ? expandFlexItems(i2, i3, flexLine, i, i5, i4, iExpandFlexItems, false) : shrinkFlexItems(i2, i3, flexLine, i, i5, i4, iExpandFlexItems, false);
        }
    }

    private void drawDividersHorizontal(Canvas canvas, boolean z, boolean z2) {
        int paddingLeft = getPaddingLeft();
        int iMax = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.mFlexLines.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            FlexLine flexLine = this.mFlexLines.get(i2);
            for (int i3 = 0; i3 < flexLine.mItemCount; i3++) {
                View reorderedChildAt = getReorderedChildAt(i);
                if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (hasDividerBeforeChildAtAlongMainAxis(i, i3)) {
                        drawVerticalDivider(canvas, z ? reorderedChildAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : (reorderedChildAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.mDividerVerticalWidth, flexLine.mTop, flexLine.mCrossSize);
                    }
                    if (i3 == flexLine.mItemCount - 1 && (this.mShowDividerVertical & 4) > 0) {
                        drawVerticalDivider(canvas, z ? (reorderedChildAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.mDividerVerticalWidth : reorderedChildAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, flexLine.mTop, flexLine.mCrossSize);
                    }
                    i++;
                }
            }
            if (hasDividerBeforeFlexLine(i2)) {
                drawHorizontalDivider(canvas, paddingLeft, z2 ? flexLine.mBottom : flexLine.mTop - this.mDividerHorizontalHeight, iMax);
            }
            if (hasEndDividerAfterFlexLine(i2) && (this.mShowDividerHorizontal & 4) > 0) {
                drawHorizontalDivider(canvas, paddingLeft, z2 ? flexLine.mTop - this.mDividerHorizontalHeight : flexLine.mBottom, iMax);
            }
        }
    }

    private void drawDividersVertical(Canvas canvas, boolean z, boolean z2) {
        int paddingTop = getPaddingTop();
        int iMax = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.mFlexLines.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            FlexLine flexLine = this.mFlexLines.get(i2);
            for (int i3 = 0; i3 < flexLine.mItemCount; i3++) {
                View reorderedChildAt = getReorderedChildAt(i);
                if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (hasDividerBeforeChildAtAlongMainAxis(i, i3)) {
                        drawHorizontalDivider(canvas, flexLine.mLeft, z2 ? reorderedChildAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : (reorderedChildAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.mDividerHorizontalHeight, flexLine.mCrossSize);
                    }
                    if (i3 == flexLine.mItemCount - 1 && (this.mShowDividerHorizontal & 4) > 0) {
                        drawHorizontalDivider(canvas, flexLine.mLeft, z2 ? (reorderedChildAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.mDividerHorizontalHeight : reorderedChildAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, flexLine.mCrossSize);
                    }
                    i++;
                }
            }
            if (hasDividerBeforeFlexLine(i2)) {
                drawVerticalDivider(canvas, z ? flexLine.mRight : flexLine.mLeft - this.mDividerVerticalWidth, paddingTop, iMax);
            }
            if (hasEndDividerAfterFlexLine(i2) && (this.mShowDividerVertical & 4) > 0) {
                drawVerticalDivider(canvas, z ? flexLine.mLeft - this.mDividerVerticalWidth : flexLine.mRight, paddingTop, iMax);
            }
        }
    }

    private void drawHorizontalDivider(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.mDividerDrawableHorizontal;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, i3 + i, this.mDividerHorizontalHeight + i2);
        this.mDividerDrawableHorizontal.draw(canvas);
    }

    private void drawVerticalDivider(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.mDividerDrawableVertical;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, this.mDividerVerticalWidth + i, i3 + i2);
        this.mDividerDrawableVertical.draw(canvas);
    }

    private int expandFlexItems(int i, int i2, FlexLine flexLine, int i3, int i4, int i5, int i6, boolean z) {
        int i7;
        double d;
        double d2;
        float f = flexLine.mTotalFlexGrow;
        if (f <= 0.0f || i4 < (i7 = flexLine.mMainSize)) {
            return i6 + flexLine.mItemCount;
        }
        float f2 = (i4 - i7) / f;
        flexLine.mMainSize = i5 + flexLine.mDividerLengthInMainSize;
        if (!z) {
            flexLine.mCrossSize = Integer.MIN_VALUE;
        }
        int i8 = i6;
        boolean z2 = false;
        int iMax = 0;
        float f3 = 0.0f;
        for (int i9 = 0; i9 < flexLine.mItemCount; i9++) {
            View reorderedChildAt = getReorderedChildAt(i8);
            if (reorderedChildAt != null) {
                if (reorderedChildAt.getVisibility() == 8) {
                    i8++;
                } else {
                    LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (isMainAxisDirectionHorizontal(i3)) {
                        if (!this.mChildrenFrozen[i8]) {
                            float measuredWidth = reorderedChildAt.getMeasuredWidth() + (layoutParams.flexGrow * f2);
                            if (i9 == flexLine.mItemCount - 1) {
                                measuredWidth += f3;
                                f3 = 0.0f;
                            }
                            int iRound = Math.round(measuredWidth);
                            int i10 = layoutParams.maxWidth;
                            if (iRound > i10) {
                                this.mChildrenFrozen[i8] = true;
                                flexLine.mTotalFlexGrow -= layoutParams.flexGrow;
                                iRound = i10;
                                z2 = true;
                            } else {
                                f3 += measuredWidth - iRound;
                                double d3 = f3;
                                if (d3 > 1.0d) {
                                    iRound++;
                                    d2 = d3 - 1.0d;
                                } else if (d3 < -1.0d) {
                                    iRound--;
                                    d2 = d3 + 1.0d;
                                }
                                f3 = (float) d2;
                            }
                            reorderedChildAt.measure(View.MeasureSpec.makeMeasureSpec(iRound, Videoio.CAP_OPENNI_IMAGE_GENERATOR), getChildHeightMeasureSpec(i2, layoutParams));
                            iMax = Math.max(iMax, reorderedChildAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                        }
                        flexLine.mMainSize += reorderedChildAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    } else {
                        if (!this.mChildrenFrozen[i8]) {
                            float measuredHeight = reorderedChildAt.getMeasuredHeight() + (layoutParams.flexGrow * f2);
                            if (i9 == flexLine.mItemCount - 1) {
                                measuredHeight += f3;
                                f3 = 0.0f;
                            }
                            int iRound2 = Math.round(measuredHeight);
                            int i11 = layoutParams.maxHeight;
                            if (iRound2 > i11) {
                                this.mChildrenFrozen[i8] = true;
                                flexLine.mTotalFlexGrow -= layoutParams.flexGrow;
                                iRound2 = i11;
                                z2 = true;
                            } else {
                                f3 += measuredHeight - iRound2;
                                double d4 = f3;
                                if (d4 > 1.0d) {
                                    iRound2++;
                                    d = d4 - 1.0d;
                                } else if (d4 < -1.0d) {
                                    iRound2--;
                                    d = d4 + 1.0d;
                                }
                                f3 = (float) d;
                            }
                            reorderedChildAt.measure(getChildWidthMeasureSpec(i, layoutParams), View.MeasureSpec.makeMeasureSpec(iRound2, Videoio.CAP_OPENNI_IMAGE_GENERATOR));
                            iMax = Math.max(iMax, reorderedChildAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                        }
                        flexLine.mMainSize += reorderedChildAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    }
                    flexLine.mCrossSize = Math.max(flexLine.mCrossSize, iMax);
                    i8++;
                }
            }
        }
        if (z2 && i7 != flexLine.mMainSize) {
            expandFlexItems(i, i2, flexLine, i3, i4, i5, i6, true);
        }
        return i8;
    }

    private int getChildHeightMeasureSpec(int i, LayoutParams layoutParams) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams).height);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        int i2 = layoutParams.maxHeight;
        if (size > i2) {
            return View.MeasureSpec.makeMeasureSpec(i2, View.MeasureSpec.getMode(childMeasureSpec));
        }
        int i3 = layoutParams.minHeight;
        return size < i3 ? View.MeasureSpec.makeMeasureSpec(i3, View.MeasureSpec.getMode(childMeasureSpec)) : childMeasureSpec;
    }

    private int getChildWidthMeasureSpec(int i, LayoutParams layoutParams) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams).width);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        int i2 = layoutParams.maxWidth;
        if (size > i2) {
            return View.MeasureSpec.makeMeasureSpec(i2, View.MeasureSpec.getMode(childMeasureSpec));
        }
        int i3 = layoutParams.minWidth;
        return size < i3 ? View.MeasureSpec.makeMeasureSpec(i3, View.MeasureSpec.getMode(childMeasureSpec)) : childMeasureSpec;
    }

    private int getLargestMainSize() {
        Iterator<FlexLine> it = this.mFlexLines.iterator();
        int iMax = Integer.MIN_VALUE;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().mMainSize);
        }
        return iMax;
    }

    private int getSumOfCrossSize() {
        int size = this.mFlexLines.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            FlexLine flexLine = this.mFlexLines.get(i2);
            if (hasDividerBeforeFlexLine(i2)) {
                i += isMainAxisDirectionHorizontal(this.mFlexDirection) ? this.mDividerHorizontalHeight : this.mDividerVerticalWidth;
            }
            if (hasEndDividerAfterFlexLine(i2)) {
                i += isMainAxisDirectionHorizontal(this.mFlexDirection) ? this.mDividerHorizontalHeight : this.mDividerVerticalWidth;
            }
            i += flexLine.mCrossSize;
        }
        return i;
    }

    private boolean hasDividerBeforeChildAtAlongMainAxis(int i, int i2) {
        if (allViewsAreGoneBefore(i, i2)) {
            if (isMainAxisDirectionHorizontal(this.mFlexDirection)) {
                return (this.mShowDividerVertical & 1) != 0;
            }
            return (this.mShowDividerHorizontal & 1) != 0;
        }
        if (isMainAxisDirectionHorizontal(this.mFlexDirection)) {
            return (this.mShowDividerVertical & 2) != 0;
        }
        return (this.mShowDividerHorizontal & 2) != 0;
    }

    private boolean hasDividerBeforeFlexLine(int i) {
        if (i < 0 || i >= this.mFlexLines.size()) {
            return false;
        }
        if (allFlexLinesAreDummyBefore(i)) {
            if (isMainAxisDirectionHorizontal(this.mFlexDirection)) {
                return (this.mShowDividerHorizontal & 1) != 0;
            }
            return (this.mShowDividerVertical & 1) != 0;
        }
        if (isMainAxisDirectionHorizontal(this.mFlexDirection)) {
            return (this.mShowDividerHorizontal & 2) != 0;
        }
        return (this.mShowDividerVertical & 2) != 0;
    }

    private boolean hasEndDividerAfterFlexLine(int i) {
        if (i < 0 || i >= this.mFlexLines.size()) {
            return false;
        }
        for (int i2 = i + 1; i2 < this.mFlexLines.size(); i2++) {
            if (this.mFlexLines.get(i2).getItemCountNotGone() > 0) {
                return false;
            }
        }
        if (isMainAxisDirectionHorizontal(this.mFlexDirection)) {
            return (this.mShowDividerHorizontal & 4) != 0;
        }
        return (this.mShowDividerVertical & 4) != 0;
    }

    private boolean isMainAxisDirectionHorizontal(int i) {
        return i == 0 || i == 1;
    }

    private boolean isOrderChangedFromLastMeasurement() {
        int childCount = getChildCount();
        if (this.mOrderCache == null) {
            this.mOrderCache = new SparseIntArray(childCount);
        }
        if (this.mOrderCache.size() != childCount) {
            return true;
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null && ((LayoutParams) childAt.getLayoutParams()).order != this.mOrderCache.get(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isWrapRequired(int i, int i2, int i3, int i4, LayoutParams layoutParams, int i5, int i6) {
        int i7;
        if (this.mFlexWrap == 0) {
            return false;
        }
        if (layoutParams.wrapBefore) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        if (isMainAxisDirectionHorizontal(this.mFlexDirection)) {
            if (hasDividerBeforeChildAtAlongMainAxis(i5, i6)) {
                i4 += this.mDividerVerticalWidth;
            }
            if ((this.mShowDividerVertical & 4) > 0) {
                i7 = this.mDividerVerticalWidth;
                i4 += i7;
            }
        } else {
            if (hasDividerBeforeChildAtAlongMainAxis(i5, i6)) {
                i4 += this.mDividerHorizontalHeight;
            }
            if ((this.mShowDividerHorizontal & 4) > 0) {
                i7 = this.mDividerHorizontalHeight;
                i4 += i7;
            }
        }
        return i2 < i3 + i4;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00be  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c4 A[PHI: r6
  0x00c4: PHI (r6v12 int) = (r6v1 int), (r6v10 int) binds: [B:37:0x00c2, B:41:0x00d3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:39:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:44:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:47:0x00f9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:49:0x0131  */
    /* JADX WARN: Code duplicated, block: B:50:0x0160  */
    /* JADX WARN: Code duplicated, block: B:52:0x016b  */
    /* JADX WARN: Code duplicated, block: B:53:0x018f  */
    private void layoutHorizontal(boolean z, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float fMax;
        int i5;
        int i6;
        View reorderedChildAt;
        LayoutParams layoutParams;
        float f4;
        float f5;
        float f6;
        float f7;
        int i7;
        LayoutParams layoutParams2;
        int i8;
        int i9;
        FlexLine flexLine;
        FlexLine flexLine2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i10 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int size = this.mFlexLines.size();
        int i11 = 0;
        int i12 = 0;
        while (i12 < size) {
            FlexLine flexLine3 = this.mFlexLines.get(i12);
            if (hasDividerBeforeFlexLine(i12)) {
                int i13 = this.mDividerHorizontalHeight;
                paddingBottom -= i13;
                paddingTop += i13;
            }
            int i14 = paddingBottom;
            int i15 = paddingTop;
            int i16 = this.mJustifyContent;
            int i17 = 2;
            if (i16 == 0) {
                f = paddingLeft;
                f2 = i10 - paddingRight;
            } else if (i16 != 1) {
                if (i16 == 2) {
                    int i18 = flexLine3.mMainSize;
                    f = paddingLeft + ((i10 - i18) / 2.0f);
                    f2 = (i10 - paddingRight) - ((i10 - i18) / 2.0f);
                } else if (i16 == 3) {
                    f = paddingLeft;
                    int itemCountNotGone = flexLine3.getItemCountNotGone();
                    f3 = (i10 - flexLine3.mMainSize) / (itemCountNotGone != 1 ? itemCountNotGone - 1 : 1.0f);
                    f2 = i10 - paddingRight;
                } else {
                    if (i16 != 4) {
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.mJustifyContent);
                    }
                    int itemCountNotGone2 = flexLine3.getItemCountNotGone();
                    f3 = itemCountNotGone2 != 0 ? (i10 - flexLine3.mMainSize) / itemCountNotGone2 : 0.0f;
                    float f8 = f3 / 2.0f;
                    f = paddingLeft + f8;
                    f2 = (i10 - paddingRight) - f8;
                }
                fMax = Math.max(f3, 0.0f);
                i5 = i11;
                i6 = 0;
                while (i6 < flexLine3.mItemCount) {
                    reorderedChildAt = getReorderedChildAt(i5);
                    if (reorderedChildAt != null) {
                        i8 = i6;
                        flexLine2 = flexLine3;
                    } else if (reorderedChildAt.getVisibility() == 8) {
                        i5++;
                        i8 = i6;
                        flexLine2 = flexLine3;
                    } else {
                        layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                        f4 = f + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                        f5 = f2 - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        if (hasDividerBeforeChildAtAlongMainAxis(i5, i6)) {
                            int i19 = this.mDividerVerticalWidth;
                            f4 += i19;
                            f5 -= i19;
                        }
                        f6 = f4;
                        f7 = f5;
                        i7 = this.mFlexWrap;
                        if (i7 == i17) {
                            layoutParams2 = layoutParams;
                            i8 = i6;
                            i9 = i5;
                            flexLine = flexLine3;
                            if (z) {
                                layoutSingleChildHorizontal(reorderedChildAt, flexLine, i7, this.mAlignItems, Math.round(f7) - reorderedChildAt.getMeasuredWidth(), i15, Math.round(f7), i15 + reorderedChildAt.getMeasuredHeight());
                            } else {
                                layoutSingleChildHorizontal(reorderedChildAt, flexLine, i7, this.mAlignItems, Math.round(f6), i15, Math.round(f6) + reorderedChildAt.getMeasuredWidth(), i15 + reorderedChildAt.getMeasuredHeight());
                            }
                        } else if (z) {
                            layoutParams2 = layoutParams;
                            i8 = i6;
                            i9 = i5;
                            flexLine = flexLine3;
                            layoutSingleChildHorizontal(reorderedChildAt, flexLine3, i7, this.mAlignItems, Math.round(f7) - reorderedChildAt.getMeasuredWidth(), i14 - reorderedChildAt.getMeasuredHeight(), Math.round(f7), i14);
                        } else {
                            layoutParams2 = layoutParams;
                            i8 = i6;
                            i9 = i5;
                            flexLine = flexLine3;
                            layoutSingleChildHorizontal(reorderedChildAt, flexLine, i7, this.mAlignItems, Math.round(f6), i14 - reorderedChildAt.getMeasuredHeight(), Math.round(f6) + reorderedChildAt.getMeasuredWidth(), i14);
                        }
                        float measuredWidth = f6 + reorderedChildAt.getMeasuredWidth() + fMax + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                        float measuredWidth2 = f7 - ((reorderedChildAt.getMeasuredWidth() + fMax) + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin);
                        i5 = i9 + 1;
                        flexLine2 = flexLine;
                        flexLine2.mLeft = Math.min(flexLine2.mLeft, reorderedChildAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin);
                        flexLine2.mTop = Math.min(flexLine2.mTop, reorderedChildAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin);
                        flexLine2.mRight = Math.max(flexLine2.mRight, reorderedChildAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
                        flexLine2.mBottom = Math.max(flexLine2.mBottom, reorderedChildAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
                        f = measuredWidth;
                        f2 = measuredWidth2;
                    }
                    i6 = i8 + 1;
                    flexLine3 = flexLine2;
                    i17 = 2;
                }
                int i20 = flexLine3.mCrossSize;
                paddingTop = i15 + i20;
                paddingBottom = i14 - i20;
                i12++;
                i11 = i5;
            } else {
                int i21 = flexLine3.mMainSize;
                f2 = i21 - paddingLeft;
                f = (i10 - i21) + paddingRight;
            }
            f3 = 0.0f;
            fMax = Math.max(f3, 0.0f);
            i5 = i11;
            i6 = 0;
            while (i6 < flexLine3.mItemCount) {
                reorderedChildAt = getReorderedChildAt(i5);
                if (reorderedChildAt != null) {
                    i8 = i6;
                    flexLine2 = flexLine3;
                } else if (reorderedChildAt.getVisibility() == 8) {
                    i5++;
                    i8 = i6;
                    flexLine2 = flexLine3;
                } else {
                    layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    f4 = f + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    f5 = f2 - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    if (hasDividerBeforeChildAtAlongMainAxis(i5, i6)) {
                        int i110 = this.mDividerVerticalWidth;
                        f4 += i110;
                        f5 -= i110;
                    }
                    f6 = f4;
                    f7 = f5;
                    i7 = this.mFlexWrap;
                    if (i7 == i17) {
                        layoutParams2 = layoutParams;
                        i8 = i6;
                        i9 = i5;
                        flexLine = flexLine3;
                        if (z) {
                            layoutSingleChildHorizontal(reorderedChildAt, flexLine, i7, this.mAlignItems, Math.round(f7) - reorderedChildAt.getMeasuredWidth(), i15, Math.round(f7), i15 + reorderedChildAt.getMeasuredHeight());
                        } else {
                            layoutSingleChildHorizontal(reorderedChildAt, flexLine, i7, this.mAlignItems, Math.round(f6), i15, Math.round(f6) + reorderedChildAt.getMeasuredWidth(), i15 + reorderedChildAt.getMeasuredHeight());
                        }
                    } else if (z) {
                        layoutParams2 = layoutParams;
                        i8 = i6;
                        i9 = i5;
                        flexLine = flexLine3;
                        layoutSingleChildHorizontal(reorderedChildAt, flexLine3, i7, this.mAlignItems, Math.round(f7) - reorderedChildAt.getMeasuredWidth(), i14 - reorderedChildAt.getMeasuredHeight(), Math.round(f7), i14);
                    } else {
                        layoutParams2 = layoutParams;
                        i8 = i6;
                        i9 = i5;
                        flexLine = flexLine3;
                        layoutSingleChildHorizontal(reorderedChildAt, flexLine, i7, this.mAlignItems, Math.round(f6), i14 - reorderedChildAt.getMeasuredHeight(), Math.round(f6) + reorderedChildAt.getMeasuredWidth(), i14);
                    }
                    float measuredWidth3 = f6 + reorderedChildAt.getMeasuredWidth() + fMax + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                    float measuredWidth4 = f7 - ((reorderedChildAt.getMeasuredWidth() + fMax) + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin);
                    i5 = i9 + 1;
                    flexLine2 = flexLine;
                    flexLine2.mLeft = Math.min(flexLine2.mLeft, reorderedChildAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin);
                    flexLine2.mTop = Math.min(flexLine2.mTop, reorderedChildAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin);
                    flexLine2.mRight = Math.max(flexLine2.mRight, reorderedChildAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
                    flexLine2.mBottom = Math.max(flexLine2.mBottom, reorderedChildAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
                    f = measuredWidth3;
                    f2 = measuredWidth4;
                }
                i6 = i8 + 1;
                flexLine3 = flexLine2;
                i17 = 2;
            }
            int i22 = flexLine3.mCrossSize;
            paddingTop = i15 + i22;
            paddingBottom = i14 - i22;
            i12++;
            i11 = i5;
        }
    }

    private void layoutSingleChildHorizontal(View view, FlexLine flexLine, int i, int i2, int i3, int i4, int i5, int i6) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i7 = layoutParams.alignSelf;
        if (i7 != -1) {
            i2 = i7;
        }
        int i8 = flexLine.mCrossSize;
        if (i2 != 0) {
            if (i2 == 1) {
                if (i == 2) {
                    view.layout(i3, (i4 - i8) + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, i5, (i6 - i8) + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin);
                    return;
                }
                int i9 = i4 + i8;
                int measuredHeight = i9 - view.getMeasuredHeight();
                int i10 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                view.layout(i3, measuredHeight - i10, i5, i9 - i10);
                return;
            }
            if (i2 == 2) {
                int measuredHeight2 = (((i8 - view.getMeasuredHeight()) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) / 2;
                if (i != 2) {
                    int i11 = i4 + measuredHeight2;
                    view.layout(i3, i11, i5, view.getMeasuredHeight() + i11);
                    return;
                } else {
                    int i12 = i4 - measuredHeight2;
                    view.layout(i3, i12, i5, view.getMeasuredHeight() + i12);
                    return;
                }
            }
            if (i2 == 3) {
                if (i != 2) {
                    int iMax = Math.max(flexLine.mMaxBaseline - view.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).topMargin);
                    view.layout(i3, i4 + iMax, i5, i6 + iMax);
                    return;
                } else {
                    int iMax2 = Math.max((flexLine.mMaxBaseline - view.getMeasuredHeight()) + view.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                    view.layout(i3, i4 - iMax2, i5, i6 - iMax2);
                    return;
                }
            }
            if (i2 != 4) {
                return;
            }
        }
        if (i != 2) {
            int i13 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            view.layout(i3, i4 + i13, i5, i6 + i13);
        } else {
            int i14 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            view.layout(i3, i4 - i14, i5, i6 - i14);
        }
    }

    private void layoutSingleChildVertical(View view, FlexLine flexLine, boolean z, int i, int i2, int i3, int i4, int i5) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i6 = layoutParams.alignSelf;
        if (i6 != -1) {
            i = i6;
        }
        int i7 = flexLine.mCrossSize;
        if (i != 0) {
            if (i == 1) {
                if (z) {
                    view.layout((i2 - i7) + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i3, (i4 - i7) + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i5);
                    return;
                } else {
                    view.layout(((i2 + i7) - view.getMeasuredWidth()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i3, ((i4 + i7) - view.getMeasuredWidth()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i5);
                    return;
                }
            }
            if (i == 2) {
                int measuredWidth = (((i7 - view.getMeasuredWidth()) + iILLL1.ILil(layoutParams)) - iILLL1.IL1Iii(layoutParams)) / 2;
                if (z) {
                    view.layout(i2 - measuredWidth, i3, i4 - measuredWidth, i5);
                    return;
                } else {
                    view.layout(i2 + measuredWidth, i3, i4 + measuredWidth, i5);
                    return;
                }
            }
            if (i != 3 && i != 4) {
                return;
            }
        }
        if (z) {
            int i8 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            view.layout(i2 - i8, i3, i4 - i8, i5);
        } else {
            int i9 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            view.layout(i2 + i9, i3, i4 + i9, i5);
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c5 A[PHI: r7
  0x00c5: PHI (r7v9 int) = (r7v1 int), (r7v7 int) binds: [B:37:0x00c3, B:41:0x00d2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:39:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:47:0x00f6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:49:0x0129  */
    /* JADX WARN: Code duplicated, block: B:50:0x0153  */
    /* JADX WARN: Code duplicated, block: B:52:0x015c  */
    /* JADX WARN: Code duplicated, block: B:53:0x017f  */
    private void layoutVertical(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float fMax;
        int i5;
        int i6;
        View reorderedChildAt;
        LayoutParams layoutParams;
        float f4;
        float f5;
        float f6;
        float f7;
        LayoutParams layoutParams2;
        int i7;
        int i8;
        FlexLine flexLine;
        FlexLine flexLine2;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i9 = i4 - i2;
        int i10 = (i3 - i) - paddingRight;
        int size = this.mFlexLines.size();
        int i11 = 0;
        int i12 = 0;
        while (i12 < size) {
            FlexLine flexLine3 = this.mFlexLines.get(i12);
            if (hasDividerBeforeFlexLine(i12)) {
                int i13 = this.mDividerVerticalWidth;
                paddingLeft += i13;
                i10 -= i13;
            }
            int i14 = paddingLeft;
            int i15 = i10;
            int i16 = this.mJustifyContent;
            if (i16 == 0) {
                f = paddingTop;
                f2 = i9 - paddingBottom;
            } else if (i16 != 1) {
                if (i16 == 2) {
                    int i17 = flexLine3.mMainSize;
                    f = paddingTop + ((i9 - i17) / 2.0f);
                    f2 = (i9 - paddingBottom) - ((i9 - i17) / 2.0f);
                } else if (i16 == 3) {
                    f = paddingTop;
                    int itemCountNotGone = flexLine3.getItemCountNotGone();
                    f3 = (i9 - flexLine3.mMainSize) / (itemCountNotGone != 1 ? itemCountNotGone - 1 : 1.0f);
                    f2 = i9 - paddingBottom;
                } else {
                    if (i16 != 4) {
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.mJustifyContent);
                    }
                    int itemCountNotGone2 = flexLine3.getItemCountNotGone();
                    f3 = itemCountNotGone2 != 0 ? (i9 - flexLine3.mMainSize) / itemCountNotGone2 : 0.0f;
                    float f8 = f3 / 2.0f;
                    f = paddingTop + f8;
                    f2 = (i9 - paddingBottom) - f8;
                }
                fMax = Math.max(f3, 0.0f);
                i5 = i11;
                i6 = 0;
                while (i6 < flexLine3.mItemCount) {
                    reorderedChildAt = getReorderedChildAt(i5);
                    if (reorderedChildAt != null) {
                        i7 = i6;
                        flexLine2 = flexLine3;
                    } else if (reorderedChildAt.getVisibility() == 8) {
                        i5++;
                        i7 = i6;
                        flexLine2 = flexLine3;
                    } else {
                        layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                        f4 = f + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        f5 = f2 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        if (hasDividerBeforeChildAtAlongMainAxis(i5, i6)) {
                            int i18 = this.mDividerHorizontalHeight;
                            f4 += i18;
                            f5 -= i18;
                        }
                        f6 = f4;
                        f7 = f5;
                        if (z) {
                            layoutParams2 = layoutParams;
                            i7 = i6;
                            i8 = i5;
                            flexLine = flexLine3;
                            if (z2) {
                                layoutSingleChildVertical(reorderedChildAt, flexLine, false, this.mAlignItems, i14, Math.round(f7) - reorderedChildAt.getMeasuredHeight(), i14 + reorderedChildAt.getMeasuredWidth(), Math.round(f7));
                            } else {
                                layoutSingleChildVertical(reorderedChildAt, flexLine, false, this.mAlignItems, i14, Math.round(f6), i14 + reorderedChildAt.getMeasuredWidth(), Math.round(f6) + reorderedChildAt.getMeasuredHeight());
                            }
                        } else if (z2) {
                            layoutParams2 = layoutParams;
                            i7 = i6;
                            i8 = i5;
                            flexLine = flexLine3;
                            layoutSingleChildVertical(reorderedChildAt, flexLine3, true, this.mAlignItems, i15 - reorderedChildAt.getMeasuredWidth(), Math.round(f7) - reorderedChildAt.getMeasuredHeight(), i15, Math.round(f7));
                        } else {
                            layoutParams2 = layoutParams;
                            i7 = i6;
                            i8 = i5;
                            flexLine = flexLine3;
                            layoutSingleChildVertical(reorderedChildAt, flexLine, true, this.mAlignItems, i15 - reorderedChildAt.getMeasuredWidth(), Math.round(f6), i15, Math.round(f6) + reorderedChildAt.getMeasuredHeight());
                        }
                        float measuredHeight = f6 + reorderedChildAt.getMeasuredHeight() + fMax + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                        float measuredHeight2 = f7 - ((reorderedChildAt.getMeasuredHeight() + fMax) + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin);
                        i5 = i8 + 1;
                        flexLine2 = flexLine;
                        flexLine2.mLeft = Math.min(flexLine2.mLeft, reorderedChildAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin);
                        flexLine2.mTop = Math.min(flexLine2.mTop, reorderedChildAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin);
                        flexLine2.mRight = Math.max(flexLine2.mRight, reorderedChildAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
                        flexLine2.mBottom = Math.max(flexLine2.mBottom, reorderedChildAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
                        f = measuredHeight;
                        f2 = measuredHeight2;
                    }
                    i6 = i7 + 1;
                    flexLine3 = flexLine2;
                }
                int i19 = flexLine3.mCrossSize;
                paddingLeft = i14 + i19;
                i10 = i15 - i19;
                i12++;
                i11 = i5;
            } else {
                int i20 = flexLine3.mMainSize;
                f2 = i20 - paddingTop;
                f = (i9 - i20) + paddingBottom;
            }
            f3 = 0.0f;
            fMax = Math.max(f3, 0.0f);
            i5 = i11;
            i6 = 0;
            while (i6 < flexLine3.mItemCount) {
                reorderedChildAt = getReorderedChildAt(i5);
                if (reorderedChildAt != null) {
                    i7 = i6;
                    flexLine2 = flexLine3;
                } else if (reorderedChildAt.getVisibility() == 8) {
                    i5++;
                    i7 = i6;
                    flexLine2 = flexLine3;
                } else {
                    layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    f4 = f + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    f5 = f2 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    if (hasDividerBeforeChildAtAlongMainAxis(i5, i6)) {
                        int i110 = this.mDividerHorizontalHeight;
                        f4 += i110;
                        f5 -= i110;
                    }
                    f6 = f4;
                    f7 = f5;
                    if (z) {
                        layoutParams2 = layoutParams;
                        i7 = i6;
                        i8 = i5;
                        flexLine = flexLine3;
                        if (z2) {
                            layoutSingleChildVertical(reorderedChildAt, flexLine, false, this.mAlignItems, i14, Math.round(f7) - reorderedChildAt.getMeasuredHeight(), i14 + reorderedChildAt.getMeasuredWidth(), Math.round(f7));
                        } else {
                            layoutSingleChildVertical(reorderedChildAt, flexLine, false, this.mAlignItems, i14, Math.round(f6), i14 + reorderedChildAt.getMeasuredWidth(), Math.round(f6) + reorderedChildAt.getMeasuredHeight());
                        }
                    } else if (z2) {
                        layoutParams2 = layoutParams;
                        i7 = i6;
                        i8 = i5;
                        flexLine = flexLine3;
                        layoutSingleChildVertical(reorderedChildAt, flexLine3, true, this.mAlignItems, i15 - reorderedChildAt.getMeasuredWidth(), Math.round(f7) - reorderedChildAt.getMeasuredHeight(), i15, Math.round(f7));
                    } else {
                        layoutParams2 = layoutParams;
                        i7 = i6;
                        i8 = i5;
                        flexLine = flexLine3;
                        layoutSingleChildVertical(reorderedChildAt, flexLine, true, this.mAlignItems, i15 - reorderedChildAt.getMeasuredWidth(), Math.round(f6), i15, Math.round(f6) + reorderedChildAt.getMeasuredHeight());
                    }
                    float measuredHeight3 = f6 + reorderedChildAt.getMeasuredHeight() + fMax + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                    float measuredHeight4 = f7 - ((reorderedChildAt.getMeasuredHeight() + fMax) + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin);
                    i5 = i8 + 1;
                    flexLine2 = flexLine;
                    flexLine2.mLeft = Math.min(flexLine2.mLeft, reorderedChildAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin);
                    flexLine2.mTop = Math.min(flexLine2.mTop, reorderedChildAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin);
                    flexLine2.mRight = Math.max(flexLine2.mRight, reorderedChildAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
                    flexLine2.mBottom = Math.max(flexLine2.mBottom, reorderedChildAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
                    f = measuredHeight3;
                    f2 = measuredHeight4;
                }
                i6 = i7 + 1;
                flexLine3 = flexLine2;
            }
            int i111 = flexLine3.mCrossSize;
            paddingLeft = i14 + i111;
            i10 = i15 - i111;
            i12++;
            i11 = i5;
        }
    }

    private void measureHorizontal(int i, int i2) {
        int i3;
        LayoutParams layoutParams;
        int i4;
        int measuredHeight;
        int i5;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        this.mFlexLines.clear();
        int childCount = getChildCount();
        int iM2135LLlI1 = iIlLiL.m2135LLlI1(this);
        int iM2100L111 = iIlLiL.m2100L111(this);
        FlexLine flexLine = new FlexLine();
        int i6 = iM2135LLlI1 + iM2100L111;
        flexLine.mMainSize = i6;
        int i7 = 0;
        FlexLine flexLine2 = flexLine;
        int i8 = 0;
        int i9 = Integer.MIN_VALUE;
        int i10 = 0;
        int i11 = 0;
        while (i10 < childCount) {
            View reorderedChildAt = getReorderedChildAt(i10);
            if (reorderedChildAt == null) {
                addFlexLineIfLastFlexItem(i10, childCount, flexLine2);
            } else {
                if (reorderedChildAt.getVisibility() == 8) {
                    flexLine2.mItemCount++;
                    flexLine2.mGoneItemCount++;
                    addFlexLineIfLastFlexItem(i10, childCount, flexLine2);
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (layoutParams2.alignSelf == 4) {
                        flexLine2.mIndicesAlignSelfStretch.add(Integer.valueOf(i10));
                    }
                    int iRound = ((ViewGroup.MarginLayoutParams) layoutParams2).width;
                    float f = layoutParams2.flexBasisPercent;
                    if (f != -1.0f && mode == 1073741824) {
                        iRound = Math.round(size * f);
                    }
                    reorderedChildAt.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin, iRound), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams2).height));
                    checkSizeConstraints(reorderedChildAt);
                    int iM2097IL = iIlLiL.m2097IL(i8, iIlLiL.m21361(reorderedChildAt));
                    int iMax = Math.max(i9, reorderedChildAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
                    int i12 = i10;
                    FlexLine flexLine3 = flexLine2;
                    if (isWrapRequired(mode, size, flexLine2.mMainSize, reorderedChildAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin, layoutParams2, i10, i11)) {
                        if (flexLine3.getItemCountNotGone() > 0) {
                            addFlexLine(flexLine3);
                        }
                        flexLine2 = new FlexLine();
                        flexLine2.mItemCount = 1;
                        flexLine2.mMainSize = i6;
                        layoutParams = layoutParams2;
                        measuredHeight = reorderedChildAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        i4 = 0;
                    } else {
                        layoutParams = layoutParams2;
                        flexLine3.mItemCount++;
                        flexLine2 = flexLine3;
                        i4 = i11 + 1;
                        measuredHeight = iMax;
                    }
                    flexLine2.mMainSize += reorderedChildAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    flexLine2.mTotalFlexGrow += layoutParams.flexGrow;
                    flexLine2.mTotalFlexShrink += layoutParams.flexShrink;
                    flexLine2.mCrossSize = Math.max(flexLine2.mCrossSize, measuredHeight);
                    i5 = i12;
                    if (hasDividerBeforeChildAtAlongMainAxis(i5, i4)) {
                        int i13 = flexLine2.mMainSize;
                        int i14 = this.mDividerVerticalWidth;
                        flexLine2.mMainSize = i13 + i14;
                        flexLine2.mDividerLengthInMainSize += i14;
                    }
                    if (this.mFlexWrap != 2) {
                        flexLine2.mMaxBaseline = Math.max(flexLine2.mMaxBaseline, reorderedChildAt.getBaseline() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin);
                    } else {
                        flexLine2.mMaxBaseline = Math.max(flexLine2.mMaxBaseline, (reorderedChildAt.getMeasuredHeight() - reorderedChildAt.getBaseline()) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                    }
                    addFlexLineIfLastFlexItem(i5, childCount, flexLine2);
                    i9 = measuredHeight;
                    i11 = i4;
                    i8 = iM2097IL;
                }
                i10 = i5 + 1;
                mode = mode;
            }
            i5 = i10;
            i10 = i5 + 1;
            mode = mode;
        }
        determineMainSize(this.mFlexDirection, i, i2);
        if (this.mAlignItems == 3) {
            for (FlexLine flexLine4 : this.mFlexLines) {
                int i15 = i7;
                int iMax2 = Integer.MIN_VALUE;
                while (true) {
                    i3 = flexLine4.mItemCount;
                    if (i15 < i7 + i3) {
                        View reorderedChildAt2 = getReorderedChildAt(i15);
                        LayoutParams layoutParams3 = (LayoutParams) reorderedChildAt2.getLayoutParams();
                        iMax2 = this.mFlexWrap != 2 ? Math.max(iMax2, reorderedChildAt2.getHeight() + Math.max(flexLine4.mMaxBaseline - reorderedChildAt2.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin) + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin) : Math.max(iMax2, reorderedChildAt2.getHeight() + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + Math.max((flexLine4.mMaxBaseline - reorderedChildAt2.getMeasuredHeight()) + reorderedChildAt2.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin));
                        i15++;
                    }
                }
                flexLine4.mCrossSize = iMax2;
                i7 += i3;
            }
        }
        determineCrossSize(this.mFlexDirection, i, i2, getPaddingTop() + getPaddingBottom());
        stretchViews(this.mFlexDirection, this.mAlignItems);
        setMeasuredDimensionForFlex(this.mFlexDirection, i, i2, i8);
    }

    private void measureVertical(int i, int i2) {
        int iM2097IL;
        LayoutParams layoutParams;
        int i3;
        int measuredWidth;
        int i4;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        this.mFlexLines.clear();
        int childCount = getChildCount();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        FlexLine flexLine = new FlexLine();
        int i5 = paddingTop + paddingBottom;
        flexLine.mMainSize = i5;
        int i6 = Integer.MIN_VALUE;
        FlexLine flexLine2 = flexLine;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i8 < childCount) {
            View reorderedChildAt = getReorderedChildAt(i8);
            if (reorderedChildAt == null) {
                addFlexLineIfLastFlexItem(i8, childCount, flexLine2);
            } else {
                if (reorderedChildAt.getVisibility() == 8) {
                    flexLine2.mItemCount++;
                    flexLine2.mGoneItemCount++;
                    addFlexLineIfLastFlexItem(i8, childCount, flexLine2);
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (layoutParams2.alignSelf == 4) {
                        flexLine2.mIndicesAlignSelfStretch.add(Integer.valueOf(i8));
                    }
                    int iRound = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                    float f = layoutParams2.flexBasisPercent;
                    if (f != -1.0f && mode == 1073741824) {
                        iRound = Math.round(size * f);
                    }
                    int i10 = i8;
                    reorderedChildAt.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams2).width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, iRound));
                    checkSizeConstraints(reorderedChildAt);
                    iM2097IL = iIlLiL.m2097IL(i7, iIlLiL.m21361(reorderedChildAt));
                    int iMax = Math.max(i6, reorderedChildAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
                    FlexLine flexLine3 = flexLine2;
                    if (isWrapRequired(mode, size, flexLine2.mMainSize, reorderedChildAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, layoutParams2, i10, i9)) {
                        if (flexLine3.getItemCountNotGone() > 0) {
                            addFlexLine(flexLine3);
                        }
                        flexLine2 = new FlexLine();
                        flexLine2.mItemCount = 1;
                        flexLine2.mMainSize = i5;
                        layoutParams = layoutParams2;
                        measuredWidth = reorderedChildAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        i3 = 0;
                    } else {
                        layoutParams = layoutParams2;
                        flexLine3.mItemCount++;
                        flexLine2 = flexLine3;
                        i3 = i9 + 1;
                        measuredWidth = iMax;
                    }
                    flexLine2.mMainSize += reorderedChildAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    flexLine2.mTotalFlexGrow += layoutParams.flexGrow;
                    flexLine2.mTotalFlexShrink += layoutParams.flexShrink;
                    flexLine2.mCrossSize = Math.max(flexLine2.mCrossSize, measuredWidth);
                    i4 = i10;
                    if (hasDividerBeforeChildAtAlongMainAxis(i4, i3)) {
                        flexLine2.mMainSize += this.mDividerHorizontalHeight;
                    }
                    addFlexLineIfLastFlexItem(i4, childCount, flexLine2);
                    i9 = i3;
                    i6 = measuredWidth;
                }
                i8 = i4 + 1;
                i7 = iM2097IL;
                mode = mode;
            }
            iM2097IL = i7;
            i4 = i8;
            i8 = i4 + 1;
            i7 = iM2097IL;
            mode = mode;
        }
        determineMainSize(this.mFlexDirection, i, i2);
        determineCrossSize(this.mFlexDirection, i, i2, getPaddingLeft() + getPaddingRight());
        stretchViews(this.mFlexDirection, this.mAlignItems);
        setMeasuredDimensionForFlex(this.mFlexDirection, i, i2, i7);
    }

    private void setMeasuredDimensionForFlex(int i, int i2, int i3, int i4) {
        int sumOfCrossSize;
        int largestMainSize;
        int iM2129i11i;
        int iM2129i11i2;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (i == 0 || i == 1) {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        } else {
            if (i != 2 && i != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + i);
            }
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i4 = iIlLiL.m2097IL(i4, Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
            } else {
                size = largestMainSize;
            }
            iM2129i11i = iIlLiL.m2129i11i(size, i2, i4);
        } else if (mode == 0) {
            iM2129i11i = iIlLiL.m2129i11i(largestMainSize, i2, i4);
        } else {
            if (mode != 1073741824) {
                throw new IllegalStateException("Unknown width mode is set: " + mode);
            }
            if (size < largestMainSize) {
                i4 = iIlLiL.m2097IL(i4, Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
            }
            iM2129i11i = iIlLiL.m2129i11i(size, i2, i4);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < sumOfCrossSize) {
                i4 = iIlLiL.m2097IL(i4, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            iM2129i11i2 = iIlLiL.m2129i11i(size2, i3, i4);
        } else if (mode2 == 0) {
            iM2129i11i2 = iIlLiL.m2129i11i(sumOfCrossSize, i3, i4);
        } else {
            if (mode2 != 1073741824) {
                throw new IllegalStateException("Unknown height mode is set: " + mode2);
            }
            if (size2 < sumOfCrossSize) {
                i4 = iIlLiL.m2097IL(i4, 256);
            }
            iM2129i11i2 = iIlLiL.m2129i11i(size2, i3, i4);
        }
        setMeasuredDimension(iM2129i11i, iM2129i11i2);
    }

    private void setWillNotDrawFlag() {
        if (this.mDividerDrawableHorizontal == null && this.mDividerDrawableVertical == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private int shrinkFlexItems(int i, int i2, FlexLine flexLine, int i3, int i4, int i5, int i6, boolean z) {
        int i7 = flexLine.mMainSize;
        float f = flexLine.mTotalFlexShrink;
        if (f <= 0.0f || i4 > i7) {
            return i6 + flexLine.mItemCount;
        }
        float f2 = (i7 - i4) / f;
        flexLine.mMainSize = i5 + flexLine.mDividerLengthInMainSize;
        if (!z) {
            flexLine.mCrossSize = Integer.MIN_VALUE;
        }
        int i8 = i6;
        boolean z2 = false;
        int iMax = 0;
        float f3 = 0.0f;
        for (int i9 = 0; i9 < flexLine.mItemCount; i9++) {
            View reorderedChildAt = getReorderedChildAt(i8);
            if (reorderedChildAt != null) {
                if (reorderedChildAt.getVisibility() == 8) {
                    i8++;
                } else {
                    LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (isMainAxisDirectionHorizontal(i3)) {
                        if (!this.mChildrenFrozen[i8]) {
                            float measuredWidth = reorderedChildAt.getMeasuredWidth() - (layoutParams.flexShrink * f2);
                            if (i9 == flexLine.mItemCount - 1) {
                                measuredWidth += f3;
                                f3 = 0.0f;
                            }
                            int iRound = Math.round(measuredWidth);
                            int i10 = layoutParams.minWidth;
                            if (iRound < i10) {
                                this.mChildrenFrozen[i8] = true;
                                flexLine.mTotalFlexShrink -= layoutParams.flexShrink;
                                iRound = i10;
                                z2 = true;
                            } else {
                                f3 += measuredWidth - iRound;
                                double d = f3;
                                if (d > 1.0d) {
                                    iRound++;
                                    f3 -= 1.0f;
                                } else if (d < -1.0d) {
                                    iRound--;
                                    f3 += 1.0f;
                                }
                            }
                            reorderedChildAt.measure(View.MeasureSpec.makeMeasureSpec(iRound, Videoio.CAP_OPENNI_IMAGE_GENERATOR), getChildHeightMeasureSpec(i2, layoutParams));
                            iMax = Math.max(iMax, reorderedChildAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                        }
                        flexLine.mMainSize += reorderedChildAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    } else {
                        if (!this.mChildrenFrozen[i8]) {
                            float measuredHeight = reorderedChildAt.getMeasuredHeight() - (layoutParams.flexShrink * f2);
                            if (i9 == flexLine.mItemCount - 1) {
                                measuredHeight += f3;
                                f3 = 0.0f;
                            }
                            int iRound2 = Math.round(measuredHeight);
                            int i11 = layoutParams.minHeight;
                            if (iRound2 < i11) {
                                this.mChildrenFrozen[i8] = true;
                                flexLine.mTotalFlexShrink -= layoutParams.flexShrink;
                                iRound2 = i11;
                                z2 = true;
                            } else {
                                f3 += measuredHeight - iRound2;
                                double d2 = f3;
                                if (d2 > 1.0d) {
                                    iRound2++;
                                    f3 -= 1.0f;
                                } else if (d2 < -1.0d) {
                                    iRound2--;
                                    f3 += 1.0f;
                                }
                            }
                            reorderedChildAt.measure(getChildWidthMeasureSpec(i, layoutParams), View.MeasureSpec.makeMeasureSpec(iRound2, Videoio.CAP_OPENNI_IMAGE_GENERATOR));
                            iMax = Math.max(iMax, reorderedChildAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                        }
                        flexLine.mMainSize += reorderedChildAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    }
                    flexLine.mCrossSize = Math.max(flexLine.mCrossSize, iMax);
                    i8++;
                }
            }
        }
        if (z2 && i7 != flexLine.mMainSize) {
            shrinkFlexItems(i, i2, flexLine, i3, i4, i5, i6, true);
        }
        return i8;
    }

    private int[] sortOrdersIntoReorderedIndices(int i, List<Order> list) {
        Collections.sort(list);
        if (this.mOrderCache == null) {
            this.mOrderCache = new SparseIntArray(i);
        }
        this.mOrderCache.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        for (Order order : list) {
            iArr[i2] = order.index;
            this.mOrderCache.append(i2, order.order);
            i2++;
        }
        return iArr;
    }

    private void stretchViewHorizontally(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        view.measure(View.MeasureSpec.makeMeasureSpec(Math.max((i - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, 0), Videoio.CAP_OPENNI_IMAGE_GENERATOR), View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), Videoio.CAP_OPENNI_IMAGE_GENERATOR));
    }

    private void stretchViewVertically(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), Videoio.CAP_OPENNI_IMAGE_GENERATOR), View.MeasureSpec.makeMeasureSpec(Math.max((i - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, 0), Videoio.CAP_OPENNI_IMAGE_GENERATOR));
    }

    private void stretchViews(int i, int i2) {
        if (i2 != 4) {
            for (FlexLine flexLine : this.mFlexLines) {
                Iterator<Integer> it = flexLine.mIndicesAlignSelfStretch.iterator();
                while (it.hasNext()) {
                    View reorderedChildAt = getReorderedChildAt(it.next().intValue());
                    if (i == 0 || i == 1) {
                        stretchViewVertically(reorderedChildAt, flexLine.mCrossSize);
                    } else {
                        if (i != 2 && i != 3) {
                            throw new IllegalArgumentException("Invalid flex direction: " + i);
                        }
                        stretchViewHorizontally(reorderedChildAt, flexLine.mCrossSize);
                    }
                }
            }
            return;
        }
        int i3 = 0;
        for (FlexLine flexLine2 : this.mFlexLines) {
            int i4 = 0;
            while (i4 < flexLine2.mItemCount) {
                View reorderedChildAt2 = getReorderedChildAt(i3);
                int i5 = ((LayoutParams) reorderedChildAt2.getLayoutParams()).alignSelf;
                if (i5 == -1 || i5 == 4) {
                    if (i == 0 || i == 1) {
                        stretchViewVertically(reorderedChildAt2, flexLine2.mCrossSize);
                    } else {
                        if (i != 2 && i != 3) {
                            throw new IllegalArgumentException("Invalid flex direction: " + i);
                        }
                        stretchViewHorizontally(reorderedChildAt2, flexLine2.mCrossSize);
                    }
                }
                i4++;
                i3++;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        this.mReorderedIndices = createReorderedIndices(view, i, layoutParams);
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public int getAlignContent() {
        return this.mAlignContent;
    }

    public int getAlignItems() {
        return this.mAlignItems;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.mDividerDrawableHorizontal;
    }

    public Drawable getDividerDrawableVertical() {
        return this.mDividerDrawableVertical;
    }

    public int getFlexDirection() {
        return this.mFlexDirection;
    }

    public List<FlexLine> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.mFlexLines.size());
        for (FlexLine flexLine : this.mFlexLines) {
            if (flexLine.getItemCountNotGone() != 0) {
                arrayList.add(flexLine);
            }
        }
        return arrayList;
    }

    public int getFlexWrap() {
        return this.mFlexWrap;
    }

    public int getJustifyContent() {
        return this.mJustifyContent;
    }

    public View getReorderedChildAt(int i) {
        if (i < 0) {
            return null;
        }
        int[] iArr = this.mReorderedIndices;
        if (i >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i]);
    }

    public int getShowDividerHorizontal() {
        return this.mShowDividerHorizontal;
    }

    public int getShowDividerVertical() {
        return this.mShowDividerVertical;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mDividerDrawableVertical == null && this.mDividerDrawableHorizontal == null) {
            return;
        }
        if (this.mShowDividerHorizontal == 0 && this.mShowDividerVertical == 0) {
            return;
        }
        int iM2134l = iIlLiL.m2134l(this);
        int i = this.mFlexDirection;
        if (i == 0) {
            drawDividersHorizontal(canvas, iM2134l == 1, this.mFlexWrap == 2);
            return;
        }
        if (i == 1) {
            drawDividersHorizontal(canvas, iM2134l != 1, this.mFlexWrap == 2);
            return;
        }
        if (i == 2) {
            boolean z = iM2134l == 1;
            if (this.mFlexWrap == 2) {
                z = !z;
            }
            drawDividersVertical(canvas, z, false);
            return;
        }
        if (i != 3) {
            return;
        }
        boolean z2 = iM2134l == 1;
        if (this.mFlexWrap == 2) {
            z2 = !z2;
        }
        drawDividersVertical(canvas, z2, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        int iM2134l = iIlLiL.m2134l(this);
        int i5 = this.mFlexDirection;
        if (i5 == 0) {
            layoutHorizontal(iM2134l == 1, i, i2, i3, i4);
            return;
        }
        if (i5 == 1) {
            layoutHorizontal(iM2134l != 1, i, i2, i3, i4);
            return;
        }
        if (i5 == 2) {
            z2 = iM2134l == 1;
            layoutVertical(this.mFlexWrap == 2 ? !z2 : z2, false, i, i2, i3, i4);
        } else if (i5 == 3) {
            z2 = iM2134l == 1;
            layoutVertical(this.mFlexWrap == 2 ? !z2 : z2, true, i, i2, i3, i4);
        } else {
            throw new IllegalStateException("Invalid flex direction is set: " + this.mFlexDirection);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (isOrderChangedFromLastMeasurement()) {
            this.mReorderedIndices = createReorderedIndices();
        }
        boolean[] zArr = this.mChildrenFrozen;
        if (zArr == null || zArr.length < getChildCount()) {
            this.mChildrenFrozen = new boolean[getChildCount()];
        }
        int i3 = this.mFlexDirection;
        if (i3 == 0 || i3 == 1) {
            measureHorizontal(i, i2);
        } else {
            if (i3 != 2 && i3 != 3) {
                throw new IllegalStateException("Invalid value for the flex direction is set: " + this.mFlexDirection);
            }
            measureVertical(i, i2);
        }
        Arrays.fill(this.mChildrenFrozen, false);
    }

    public void setAlignContent(int i) {
        if (this.mAlignContent != i) {
            this.mAlignContent = i;
            requestLayout();
        }
    }

    public void setAlignItems(int i) {
        if (this.mAlignItems != i) {
            this.mAlignItems = i;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable == this.mDividerDrawableHorizontal) {
            return;
        }
        this.mDividerDrawableHorizontal = drawable;
        if (drawable != null) {
            this.mDividerHorizontalHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerHorizontalHeight = 0;
        }
        setWillNotDrawFlag();
        requestLayout();
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable == this.mDividerDrawableVertical) {
            return;
        }
        this.mDividerDrawableVertical = drawable;
        if (drawable != null) {
            this.mDividerVerticalWidth = drawable.getIntrinsicWidth();
        } else {
            this.mDividerVerticalWidth = 0;
        }
        setWillNotDrawFlag();
        requestLayout();
    }

    public void setFlexDirection(int i) {
        if (this.mFlexDirection != i) {
            this.mFlexDirection = i;
            requestLayout();
        }
    }

    public void setFlexWrap(int i) {
        if (this.mFlexWrap != i) {
            this.mFlexWrap = i;
            requestLayout();
        }
    }

    public void setJustifyContent(int i) {
        if (this.mJustifyContent != i) {
            this.mJustifyContent = i;
            requestLayout();
        }
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.mShowDividerHorizontal) {
            this.mShowDividerHorizontal = i;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i) {
        if (i != this.mShowDividerVertical) {
            this.mShowDividerVertical = i;
            requestLayout();
        }
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFlexLines = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0015R.styleable.FlexboxLayout, i, 0);
        this.mFlexDirection = typedArrayObtainStyledAttributes.getInt(C0015R.styleable.FlexboxLayout_flexDirection, 0);
        this.mFlexWrap = typedArrayObtainStyledAttributes.getInt(C0015R.styleable.FlexboxLayout_flexWrap, 0);
        this.mJustifyContent = typedArrayObtainStyledAttributes.getInt(C0015R.styleable.FlexboxLayout_justifyContent, 0);
        this.mAlignItems = typedArrayObtainStyledAttributes.getInt(C0015R.styleable.FlexboxLayout_alignItems, 4);
        this.mAlignContent = typedArrayObtainStyledAttributes.getInt(C0015R.styleable.FlexboxLayout_alignContent, 5);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(C0015R.styleable.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(C0015R.styleable.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = typedArrayObtainStyledAttributes.getDrawable(C0015R.styleable.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i2 = typedArrayObtainStyledAttributes.getInt(C0015R.styleable.FlexboxLayout_showDivider, 0);
        if (i2 != 0) {
            this.mShowDividerVertical = i2;
            this.mShowDividerHorizontal = i2;
        }
        int i3 = typedArrayObtainStyledAttributes.getInt(C0015R.styleable.FlexboxLayout_showDividerVertical, 0);
        if (i3 != 0) {
            this.mShowDividerVertical = i3;
        }
        int i4 = typedArrayObtainStyledAttributes.getInt(C0015R.styleable.FlexboxLayout_showDividerHorizontal, 0);
        if (i4 != 0) {
            this.mShowDividerHorizontal = i4;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    private int[] createReorderedIndices() {
        int childCount = getChildCount();
        return sortOrdersIntoReorderedIndices(childCount, createOrders(childCount));
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int ALIGN_SELF_AUTO = -1;
        public static final int ALIGN_SELF_BASELINE = 3;
        public static final int ALIGN_SELF_CENTER = 2;
        public static final int ALIGN_SELF_FLEX_END = 1;
        public static final int ALIGN_SELF_FLEX_START = 0;
        public static final int ALIGN_SELF_STRETCH = 4;
        public static final float FLEX_BASIS_PERCENT_DEFAULT = -1.0f;
        private static final float FLEX_GROW_DEFAULT = 0.0f;
        private static final float FLEX_SHRINK_DEFAULT = 1.0f;
        private static final int MAX_SIZE = 16777215;
        private static final int ORDER_DEFAULT = 1;
        public int alignSelf;
        public float flexBasisPercent;
        public float flexGrow;
        public float flexShrink;
        public int maxHeight;
        public int maxWidth;
        public int minHeight;
        public int minWidth;
        public int order;
        public boolean wrapBefore;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.order = 1;
            this.flexGrow = FLEX_GROW_DEFAULT;
            this.flexShrink = 1.0f;
            this.alignSelf = -1;
            this.flexBasisPercent = -1.0f;
            this.maxWidth = MAX_SIZE;
            this.maxHeight = MAX_SIZE;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0015R.styleable.FlexboxLayout_Layout);
            this.order = typedArrayObtainStyledAttributes.getInt(C0015R.styleable.FlexboxLayout_Layout_layout_order, 1);
            this.flexGrow = typedArrayObtainStyledAttributes.getFloat(C0015R.styleable.FlexboxLayout_Layout_layout_flexGrow, FLEX_GROW_DEFAULT);
            this.flexShrink = typedArrayObtainStyledAttributes.getFloat(C0015R.styleable.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.alignSelf = typedArrayObtainStyledAttributes.getInt(C0015R.styleable.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.flexBasisPercent = typedArrayObtainStyledAttributes.getFraction(C0015R.styleable.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.minWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0015R.styleable.FlexboxLayout_Layout_layout_minWidth, 0);
            this.minHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0015R.styleable.FlexboxLayout_Layout_layout_minHeight, 0);
            this.maxWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0015R.styleable.FlexboxLayout_Layout_layout_maxWidth, MAX_SIZE);
            this.maxHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0015R.styleable.FlexboxLayout_Layout_layout_maxHeight, MAX_SIZE);
            this.wrapBefore = typedArrayObtainStyledAttributes.getBoolean(C0015R.styleable.FlexboxLayout_Layout_layout_wrapBefore, false);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.order = 1;
            this.flexGrow = FLEX_GROW_DEFAULT;
            this.flexShrink = 1.0f;
            this.alignSelf = -1;
            this.flexBasisPercent = -1.0f;
            this.maxWidth = MAX_SIZE;
            this.maxHeight = MAX_SIZE;
            this.order = layoutParams.order;
            this.flexGrow = layoutParams.flexGrow;
            this.flexShrink = layoutParams.flexShrink;
            this.alignSelf = layoutParams.alignSelf;
            this.flexBasisPercent = layoutParams.flexBasisPercent;
            this.minWidth = layoutParams.minWidth;
            this.minHeight = layoutParams.minHeight;
            this.maxWidth = layoutParams.maxWidth;
            this.maxHeight = layoutParams.maxHeight;
            this.wrapBefore = layoutParams.wrapBefore;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.order = 1;
            this.flexGrow = FLEX_GROW_DEFAULT;
            this.flexShrink = 1.0f;
            this.alignSelf = -1;
            this.flexBasisPercent = -1.0f;
            this.maxWidth = MAX_SIZE;
            this.maxHeight = MAX_SIZE;
        }

        public LayoutParams(int i, int i2) {
            super(new ViewGroup.LayoutParams(i, i2));
            this.order = 1;
            this.flexGrow = FLEX_GROW_DEFAULT;
            this.flexShrink = 1.0f;
            this.alignSelf = -1;
            this.flexBasisPercent = -1.0f;
            this.maxWidth = MAX_SIZE;
            this.maxHeight = MAX_SIZE;
        }
    }
}
