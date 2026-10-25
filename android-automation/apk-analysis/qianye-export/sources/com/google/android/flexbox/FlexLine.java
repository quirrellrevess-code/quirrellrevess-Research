package com.google.android.flexbox;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FlexLine {
    public int mCrossSize;
    public int mDividerLengthInMainSize;
    public int mGoneItemCount;
    public int mItemCount;
    public int mMainSize;
    public int mMaxBaseline;
    public float mTotalFlexGrow;
    public float mTotalFlexShrink;
    public int mLeft = Integer.MAX_VALUE;
    public int mTop = Integer.MAX_VALUE;
    public int mRight = Integer.MIN_VALUE;
    public int mBottom = Integer.MIN_VALUE;
    public List<Integer> mIndicesAlignSelfStretch = new ArrayList();

    public int getBottom() {
        return this.mBottom;
    }

    public int getCrossSize() {
        return this.mCrossSize;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public int getItemCountNotGone() {
        return this.mItemCount - this.mGoneItemCount;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public int getMainSize() {
        return this.mMainSize;
    }

    public int getRight() {
        return this.mRight;
    }

    public int getTop() {
        return this.mTop;
    }

    public float getTotalFlexGrow() {
        return this.mTotalFlexGrow;
    }

    public float getTotalFlexShrink() {
        return this.mTotalFlexShrink;
    }
}
