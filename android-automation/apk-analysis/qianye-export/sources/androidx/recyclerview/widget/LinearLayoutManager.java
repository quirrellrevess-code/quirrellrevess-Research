package androidx.recyclerview.widget;

import ILil.Lil.p037IL.C0639ILl;
import ILil.Lil.p037IL.ILL;
import ILil.Lil.p037IL.IiL;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.smtt.sdk.TbsListener;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.LlLI1 implements RecyclerView.l.ILil {
    public static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    public final IL1Iii mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final ILil mLayoutChunkResult;
    private I1I mLayoutState;
    public int mOrientation;
    public ILL mOrientationHelper;
    public SavedState mPendingSavedState;
    public int mPendingScrollPosition;
    public int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    public boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    public static class I1I {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f5052I1I;
        public int ILL;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f5054ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int f5055Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int f2673IL;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public int f2677iILLL1;

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public boolean f2678lIiI;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public int f2679lLi1LL;

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public boolean f2680il;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public boolean f5053IL1Iii = true;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public int f2674IiL = 0;

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public int f2676L11I = 0;

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public List<RecyclerView.LL1IL> f2675Ll1 = null;

        public boolean I1I(RecyclerView.C1 c1) {
            int i = this.f2673IL;
            return i >= 0 && i < c1.ILil();
        }

        public void IL1Iii() {
            ILil(null);
        }

        public void ILil(View view) {
            View viewM3249lLi1LL = m3249lLi1LL(view);
            if (viewM3249lLi1LL == null) {
                this.f2673IL = -1;
            } else {
                this.f2673IL = ((RecyclerView.LayoutParams) viewM3249lLi1LL.getLayoutParams()).IL1Iii();
            }
        }

        public final View Ilil() {
            int size = this.f2675Ll1.size();
            for (int i = 0; i < size; i++) {
                View view = this.f2675Ll1.get(i).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.I1I() && this.f2673IL == layoutParams.IL1Iii()) {
                    ILil(view);
                    return view;
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public View m3248IL(RecyclerView.lL lLVar) {
            if (this.f2675Ll1 != null) {
                return Ilil();
            }
            View viewLil = lLVar.Lil(this.f2673IL);
            this.f2673IL += this.f5055Ilil;
            return viewLil;
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public View m3249lLi1LL(View view) {
            int iIL1Iii;
            int size = this.f2675Ll1.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.f2675Ll1.get(i2).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.I1I() && (iIL1Iii = (layoutParams.IL1Iii() - this.f2673IL) * this.f5055Ilil) >= 0 && iIL1Iii < i) {
                    view2 = view3;
                    if (iIL1Iii == 0) {
                        break;
                    }
                    i = iIL1Iii;
                }
            }
            return view2;
        }
    }

    public static class IL1Iii {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f5056I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public ILL f5057IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f5058ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public boolean f5059Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public boolean f2681IL;

        public IL1Iii() {
            Ilil();
        }

        public void I1I(View view, int i) {
            int iLil = this.f5057IL1Iii.Lil();
            if (iLil >= 0) {
                ILil(view, i);
                return;
            }
            this.f5058ILil = i;
            if (this.f2681IL) {
                int iMo2357L11I = (this.f5057IL1Iii.mo2357L11I() - iLil) - this.f5057IL1Iii.mo2354IL(view);
                this.f5056I1I = this.f5057IL1Iii.mo2357L11I() - iMo2357L11I;
                if (iMo2357L11I > 0) {
                    int iIlil = this.f5056I1I - this.f5057IL1Iii.Ilil(view);
                    int iMo2359lIiI = this.f5057IL1Iii.mo2359lIiI();
                    int iMin = iIlil - (iMo2359lIiI + Math.min(this.f5057IL1Iii.mo2358iILLL1(view) - iMo2359lIiI, 0));
                    if (iMin < 0) {
                        this.f5056I1I += Math.min(iMo2357L11I, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iMo2358iILLL1 = this.f5057IL1Iii.mo2358iILLL1(view);
            int iMo2359lIiI2 = iMo2358iILLL1 - this.f5057IL1Iii.mo2359lIiI();
            this.f5056I1I = iMo2358iILLL1;
            if (iMo2359lIiI2 > 0) {
                int iMo2357L11I2 = (this.f5057IL1Iii.mo2357L11I() - Math.min(0, (this.f5057IL1Iii.mo2357L11I() - iLil) - this.f5057IL1Iii.mo2354IL(view))) - (iMo2358iILLL1 + this.f5057IL1Iii.Ilil(view));
                if (iMo2357L11I2 < 0) {
                    this.f5056I1I -= Math.min(iMo2359lIiI2, -iMo2357L11I2);
                }
            }
        }

        public void IL1Iii() {
            this.f5056I1I = this.f2681IL ? this.f5057IL1Iii.mo2357L11I() : this.f5057IL1Iii.mo2359lIiI();
        }

        public void ILil(View view, int i) {
            if (this.f2681IL) {
                this.f5056I1I = this.f5057IL1Iii.mo2354IL(view) + this.f5057IL1Iii.Lil();
            } else {
                this.f5056I1I = this.f5057IL1Iii.mo2358iILLL1(view);
            }
            this.f5058ILil = i;
        }

        public void Ilil() {
            this.f5058ILil = -1;
            this.f5056I1I = Integer.MIN_VALUE;
            this.f2681IL = false;
            this.f5059Ilil = false;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public boolean m3250IL(View view, RecyclerView.C1 c1) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return !layoutParams.I1I() && layoutParams.IL1Iii() >= 0 && layoutParams.IL1Iii() < c1.ILil();
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f5058ILil + ", mCoordinate=" + this.f5056I1I + ", mLayoutFromEnd=" + this.f2681IL + ", mValid=" + this.f5059Ilil + '}';
        }
    }

    public static class ILil {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public boolean f5060I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public int f5061IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public boolean f5062ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public boolean f2682IL;

        public void IL1Iii() {
            this.f5061IL1Iii = 0;
            this.f5062ILil = false;
            this.f5060I1I = false;
            this.f2682IL = false;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new IL1Iii();

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f5063I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f5064ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public boolean f2683IL;

        public static class IL1Iii implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState() {
        }

        public boolean IL1Iii() {
            return this.f5064ILil >= 0;
        }

        public void ILil() {
            this.f5064ILil = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f5064ILil);
            parcel.writeInt(this.f5063I1I);
            parcel.writeInt(this.f2683IL ? 1 : 0);
        }

        public SavedState(Parcel parcel) {
            this.f5064ILil = parcel.readInt();
            this.f5063I1I = parcel.readInt();
            this.f2683IL = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.f5064ILil = savedState.f5064ILil;
            this.f5063I1I = savedState.f5063I1I;
            this.f2683IL = savedState.f2683IL;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private int computeScrollExtent(RecyclerView.C1 c1) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return C0639ILl.IL1Iii(c1, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.C1 c1) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return C0639ILl.ILil(c1, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.C1 c1) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return C0639ILl.I1I(c1, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findFirstReferenceChild(RecyclerView.lL lLVar, RecyclerView.C1 c1) {
        return findReferenceChild(lLVar, c1, 0, getChildCount(), c1.ILil());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    private View findLastReferenceChild(RecyclerView.lL lLVar, RecyclerView.C1 c1) {
        return findReferenceChild(lLVar, c1, getChildCount() - 1, -1, c1.ILil());
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        return this.mShouldReverseLayout ? findFirstPartiallyOrCompletelyInvisibleChild() : findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        return this.mShouldReverseLayout ? findLastPartiallyOrCompletelyInvisibleChild() : findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private View findReferenceChildClosestToEnd(RecyclerView.lL lLVar, RecyclerView.C1 c1) {
        return this.mShouldReverseLayout ? findFirstReferenceChild(lLVar, c1) : findLastReferenceChild(lLVar, c1);
    }

    private View findReferenceChildClosestToStart(RecyclerView.lL lLVar, RecyclerView.C1 c1) {
        return this.mShouldReverseLayout ? findLastReferenceChild(lLVar, c1) : findFirstReferenceChild(lLVar, c1);
    }

    private int fixLayoutEndGap(int i, RecyclerView.lL lLVar, RecyclerView.C1 c1, boolean z) {
        int iMo2357L11I;
        int iMo2357L11I2 = this.mOrientationHelper.mo2357L11I() - i;
        if (iMo2357L11I2 <= 0) {
            return 0;
        }
        int i2 = -scrollBy(-iMo2357L11I2, lLVar, c1);
        int i3 = i + i2;
        if (!z || (iMo2357L11I = this.mOrientationHelper.mo2357L11I() - i3) <= 0) {
            return i2;
        }
        this.mOrientationHelper.mo2360lIlii(iMo2357L11I);
        return iMo2357L11I + i2;
    }

    private int fixLayoutStartGap(int i, RecyclerView.lL lLVar, RecyclerView.C1 c1, boolean z) {
        int iMo2359lIiI;
        int iMo2359lIiI2 = i - this.mOrientationHelper.mo2359lIiI();
        if (iMo2359lIiI2 <= 0) {
            return 0;
        }
        int i2 = -scrollBy(iMo2359lIiI2, lLVar, c1);
        int i3 = i + i2;
        if (!z || (iMo2359lIiI = i3 - this.mOrientationHelper.mo2359lIiI()) <= 0) {
            return i2;
        }
        this.mOrientationHelper.mo2360lIlii(-iMo2359lIiI);
        return i2 - iMo2359lIiI;
    }

    private View getChildClosestToEnd() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    private View getChildClosestToStart() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    private void layoutForPredictiveAnimations(RecyclerView.lL lLVar, RecyclerView.C1 c1, int i, int i2) {
        if (!c1.m3300iILLL1() || getChildCount() == 0 || c1.Ilil() || !supportsPredictiveItemAnimations()) {
            return;
        }
        List<RecyclerView.LL1IL> listILL = lLVar.ILL();
        int size = listILL.size();
        int position = getPosition(getChildAt(0));
        int iIlil = 0;
        int iIlil2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView.LL1IL ll1il = listILL.get(i3);
            if (!ll1il.isRemoved()) {
                if (((ll1il.getLayoutPosition() < position) != this.mShouldReverseLayout ? (byte) -1 : (byte) 1) == -1) {
                    iIlil += this.mOrientationHelper.Ilil(ll1il.itemView);
                } else {
                    iIlil2 += this.mOrientationHelper.Ilil(ll1il.itemView);
                }
            }
        }
        this.mLayoutState.f2675Ll1 = listILL;
        if (iIlil > 0) {
            updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i);
            I1I i1i = this.mLayoutState;
            i1i.f2674IiL = iIlil;
            i1i.f5052I1I = 0;
            i1i.IL1Iii();
            fill(lLVar, this.mLayoutState, c1, false);
        }
        if (iIlil2 > 0) {
            updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i2);
            I1I i1i2 = this.mLayoutState;
            i1i2.f2674IiL = iIlil2;
            i1i2.f5052I1I = 0;
            i1i2.IL1Iii();
            fill(lLVar, this.mLayoutState, c1, false);
        }
        this.mLayoutState.f2675Ll1 = null;
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            Log.d(TAG, "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.mo2358iILLL1(childAt));
        }
        Log.d(TAG, "==============");
    }

    private void recycleByLayoutState(RecyclerView.lL lLVar, I1I i1i) {
        if (!i1i.f5053IL1Iii || i1i.f2678lIiI) {
            return;
        }
        int i = i1i.f2677iILLL1;
        int i2 = i1i.f2676L11I;
        if (i1i.f2679lLi1LL == -1) {
            recycleViewsFromEnd(lLVar, i, i2);
        } else {
            recycleViewsFromStart(lLVar, i, i2);
        }
    }

    private void recycleChildren(RecyclerView.lL lLVar, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                removeAndRecycleViewAt(i, lLVar);
                i--;
            }
        } else {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                removeAndRecycleViewAt(i3, lLVar);
            }
        }
    }

    private void recycleViewsFromEnd(RecyclerView.lL lLVar, int i, int i2) {
        int childCount = getChildCount();
        if (i < 0) {
            return;
        }
        int iMo2355IiL = (this.mOrientationHelper.mo2355IiL() - i) + i2;
        if (this.mShouldReverseLayout) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (this.mOrientationHelper.mo2358iILLL1(childAt) < iMo2355IiL || this.mOrientationHelper.mo2361llL1ii(childAt) < iMo2355IiL) {
                    recycleChildren(lLVar, 0, i3);
                    return;
                }
            }
            return;
        }
        int i4 = childCount - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            View childAt2 = getChildAt(i5);
            if (this.mOrientationHelper.mo2358iILLL1(childAt2) < iMo2355IiL || this.mOrientationHelper.mo2361llL1ii(childAt2) < iMo2355IiL) {
                recycleChildren(lLVar, i4, i5);
                return;
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView.lL lLVar, int i, int i2) {
        if (i < 0) {
            return;
        }
        int i3 = i - i2;
        int childCount = getChildCount();
        if (!this.mShouldReverseLayout) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (this.mOrientationHelper.mo2354IL(childAt) > i3 || this.mOrientationHelper.LlLI1(childAt) > i3) {
                    recycleChildren(lLVar, 0, i4);
                    return;
                }
            }
            return;
        }
        int i5 = childCount - 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            View childAt2 = getChildAt(i6);
            if (this.mOrientationHelper.mo2354IL(childAt2) > i3 || this.mOrientationHelper.LlLI1(childAt2) > i3) {
                recycleChildren(lLVar, i5, i6);
                return;
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.lL lLVar, RecyclerView.C1 c1, IL1Iii iL1Iii) {
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && iL1Iii.m3250IL(focusedChild, c1)) {
            iL1Iii.I1I(focusedChild, getPosition(focusedChild));
            return true;
        }
        if (this.mLastStackFromEnd != this.mStackFromEnd) {
            return false;
        }
        View viewFindReferenceChildClosestToEnd = iL1Iii.f2681IL ? findReferenceChildClosestToEnd(lLVar, c1) : findReferenceChildClosestToStart(lLVar, c1);
        if (viewFindReferenceChildClosestToEnd == null) {
            return false;
        }
        iL1Iii.ILil(viewFindReferenceChildClosestToEnd, getPosition(viewFindReferenceChildClosestToEnd));
        if (!c1.Ilil() && supportsPredictiveItemAnimations()) {
            if (this.mOrientationHelper.mo2358iILLL1(viewFindReferenceChildClosestToEnd) >= this.mOrientationHelper.mo2357L11I() || this.mOrientationHelper.mo2354IL(viewFindReferenceChildClosestToEnd) < this.mOrientationHelper.mo2359lIiI()) {
                iL1Iii.f5056I1I = iL1Iii.f2681IL ? this.mOrientationHelper.mo2357L11I() : this.mOrientationHelper.mo2359lIiI();
            }
        }
        return true;
    }

    private boolean updateAnchorFromPendingData(RecyclerView.C1 c1, IL1Iii iL1Iii) {
        int i;
        if (!c1.Ilil() && (i = this.mPendingScrollPosition) != -1) {
            if (i >= 0 && i < c1.ILil()) {
                iL1Iii.f5058ILil = this.mPendingScrollPosition;
                SavedState savedState = this.mPendingSavedState;
                if (savedState != null && savedState.IL1Iii()) {
                    boolean z = this.mPendingSavedState.f2683IL;
                    iL1Iii.f2681IL = z;
                    if (z) {
                        iL1Iii.f5056I1I = this.mOrientationHelper.mo2357L11I() - this.mPendingSavedState.f5063I1I;
                    } else {
                        iL1Iii.f5056I1I = this.mOrientationHelper.mo2359lIiI() + this.mPendingSavedState.f5063I1I;
                    }
                    return true;
                }
                if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                    boolean z2 = this.mShouldReverseLayout;
                    iL1Iii.f2681IL = z2;
                    if (z2) {
                        iL1Iii.f5056I1I = this.mOrientationHelper.mo2357L11I() - this.mPendingScrollPositionOffset;
                    } else {
                        iL1Iii.f5056I1I = this.mOrientationHelper.mo2359lIiI() + this.mPendingScrollPositionOffset;
                    }
                    return true;
                }
                View viewFindViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                if (viewFindViewByPosition == null) {
                    if (getChildCount() > 0) {
                        iL1Iii.f2681IL = (this.mPendingScrollPosition < getPosition(getChildAt(0))) == this.mShouldReverseLayout;
                    }
                    iL1Iii.IL1Iii();
                } else {
                    if (this.mOrientationHelper.Ilil(viewFindViewByPosition) > this.mOrientationHelper.mo2353ILl()) {
                        iL1Iii.IL1Iii();
                        return true;
                    }
                    if (this.mOrientationHelper.mo2358iILLL1(viewFindViewByPosition) - this.mOrientationHelper.mo2359lIiI() < 0) {
                        iL1Iii.f5056I1I = this.mOrientationHelper.mo2359lIiI();
                        iL1Iii.f2681IL = false;
                        return true;
                    }
                    if (this.mOrientationHelper.mo2357L11I() - this.mOrientationHelper.mo2354IL(viewFindViewByPosition) < 0) {
                        iL1Iii.f5056I1I = this.mOrientationHelper.mo2357L11I();
                        iL1Iii.f2681IL = true;
                        return true;
                    }
                    iL1Iii.f5056I1I = iL1Iii.f2681IL ? this.mOrientationHelper.mo2354IL(viewFindViewByPosition) + this.mOrientationHelper.Lil() : this.mOrientationHelper.mo2358iILLL1(viewFindViewByPosition);
                }
                return true;
            }
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        }
        return false;
    }

    private void updateAnchorInfoForLayout(RecyclerView.lL lLVar, RecyclerView.C1 c1, IL1Iii iL1Iii) {
        if (updateAnchorFromPendingData(c1, iL1Iii) || updateAnchorFromChildren(lLVar, c1, iL1Iii)) {
            return;
        }
        iL1Iii.IL1Iii();
        iL1Iii.f5058ILil = this.mStackFromEnd ? c1.ILil() - 1 : 0;
    }

    private void updateLayoutState(int i, int i2, boolean z, RecyclerView.C1 c1) {
        int iMo2359lIiI;
        this.mLayoutState.f2678lIiI = resolveIsInfinite();
        this.mLayoutState.f2679lLi1LL = i;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(c1, iArr);
        int iMax = Math.max(0, this.mReusableIntPair[0]);
        int iMax2 = Math.max(0, this.mReusableIntPair[1]);
        boolean z2 = i == 1;
        I1I i1i = this.mLayoutState;
        int i3 = z2 ? iMax2 : iMax;
        i1i.f2674IiL = i3;
        if (!z2) {
            iMax = iMax2;
        }
        i1i.f2676L11I = iMax;
        if (z2) {
            i1i.f2674IiL = i3 + this.mOrientationHelper.mo2363il();
            View childClosestToEnd = getChildClosestToEnd();
            I1I i1i2 = this.mLayoutState;
            i1i2.f5055Ilil = this.mShouldReverseLayout ? -1 : 1;
            int position = getPosition(childClosestToEnd);
            I1I i1i3 = this.mLayoutState;
            i1i2.f2673IL = position + i1i3.f5055Ilil;
            i1i3.f5054ILil = this.mOrientationHelper.mo2354IL(childClosestToEnd);
            iMo2359lIiI = this.mOrientationHelper.mo2354IL(childClosestToEnd) - this.mOrientationHelper.mo2357L11I();
        } else {
            View childClosestToStart = getChildClosestToStart();
            this.mLayoutState.f2674IiL += this.mOrientationHelper.mo2359lIiI();
            I1I i1i4 = this.mLayoutState;
            i1i4.f5055Ilil = this.mShouldReverseLayout ? 1 : -1;
            int position2 = getPosition(childClosestToStart);
            I1I i1i5 = this.mLayoutState;
            i1i4.f2673IL = position2 + i1i5.f5055Ilil;
            i1i5.f5054ILil = this.mOrientationHelper.mo2358iILLL1(childClosestToStart);
            iMo2359lIiI = (-this.mOrientationHelper.mo2358iILLL1(childClosestToStart)) + this.mOrientationHelper.mo2359lIiI();
        }
        I1I i1i6 = this.mLayoutState;
        i1i6.f5052I1I = i2;
        if (z) {
            i1i6.f5052I1I = i2 - iMo2359lIiI;
        }
        i1i6.f2677iILLL1 = iMo2359lIiI;
    }

    private void updateLayoutStateToFillEnd(IL1Iii iL1Iii) {
        updateLayoutStateToFillEnd(iL1Iii.f5058ILil, iL1Iii.f5056I1I);
    }

    private void updateLayoutStateToFillStart(IL1Iii iL1Iii) {
        updateLayoutStateToFillStart(iL1Iii.f5058ILil, iL1Iii.f5056I1I);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public void calculateExtraLayoutSpace(RecyclerView.C1 c1, int[] iArr) {
        int i;
        int extraLayoutSpace = getExtraLayoutSpace(c1);
        if (this.mLayoutState.f2679lLi1LL == -1) {
            i = 0;
        } else {
            i = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.C1 c1, RecyclerView.LlLI1.I1I i1i) {
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return;
        }
        ensureLayoutState();
        updateLayoutState(i > 0 ? 1 : -1, Math.abs(i), true, c1);
        collectPrefetchPositionsForLayoutState(c1, this.mLayoutState, i1i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void collectInitialPrefetchPositions(int i, RecyclerView.LlLI1.I1I i1i) {
        boolean z;
        int i2;
        SavedState savedState = this.mPendingSavedState;
        if (savedState == null || !savedState.IL1Iii()) {
            resolveShouldLayoutReverse();
            z = this.mShouldReverseLayout;
            i2 = this.mPendingScrollPosition;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            SavedState savedState2 = this.mPendingSavedState;
            z = savedState2.f2683IL;
            i2 = savedState2.f5064ILil;
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.mInitialPrefetchItemCount && i2 >= 0 && i2 < i; i4++) {
            i1i.IL1Iii(i2, 0);
            i2 += i3;
        }
    }

    public void collectPrefetchPositionsForLayoutState(RecyclerView.C1 c1, I1I i1i, RecyclerView.LlLI1.I1I i1i2) {
        int i = i1i.f2673IL;
        if (i < 0 || i >= c1.ILil()) {
            return;
        }
        i1i2.IL1Iii(i, Math.max(0, i1i.f2677iILLL1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public int computeHorizontalScrollExtent(RecyclerView.C1 c1) {
        return computeScrollExtent(c1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public int computeHorizontalScrollOffset(RecyclerView.C1 c1) {
        return computeScrollOffset(c1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public int computeHorizontalScrollRange(RecyclerView.C1 c1) {
        return computeScrollRange(c1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l.ILil
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = (i < getPosition(getChildAt(0))) != this.mShouldReverseLayout ? -1 : 1;
        return this.mOrientation == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public int computeVerticalScrollExtent(RecyclerView.C1 c1) {
        return computeScrollExtent(c1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public int computeVerticalScrollOffset(RecyclerView.C1 c1) {
        return computeScrollOffset(c1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public int computeVerticalScrollRange(RecyclerView.C1 c1) {
        return computeScrollRange(c1);
    }

    public int convertFocusDirectionToLayoutDirection(int i) {
        if (i == 1) {
            return (this.mOrientation != 1 && isLayoutRTL()) ? 1 : -1;
        }
        if (i == 2) {
            return (this.mOrientation != 1 && isLayoutRTL()) ? -1 : 1;
        }
        if (i == 17) {
            return this.mOrientation == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i == 33) {
            return this.mOrientation == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i != 66) {
            return (i == 130 && this.mOrientation == 1) ? 1 : Integer.MIN_VALUE;
        }
        return this.mOrientation == 0 ? 1 : Integer.MIN_VALUE;
    }

    public I1I createLayoutState() {
        return new I1I();
    }

    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    public int fill(RecyclerView.lL lLVar, I1I i1i, RecyclerView.C1 c1, boolean z) {
        int i = i1i.f5052I1I;
        int i2 = i1i.f2677iILLL1;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                i1i.f2677iILLL1 = i2 + i;
            }
            recycleByLayoutState(lLVar, i1i);
        }
        int i3 = i1i.f5052I1I + i1i.f2674IiL;
        ILil iLil = this.mLayoutChunkResult;
        while (true) {
            if ((!i1i.f2678lIiI && i3 <= 0) || !i1i.I1I(c1)) {
                break;
            }
            iLil.IL1Iii();
            layoutChunk(lLVar, c1, i1i, iLil);
            if (!iLil.f5062ILil) {
                i1i.f5054ILil += iLil.f5061IL1Iii * i1i.f2679lLi1LL;
                if (!iLil.f5060I1I || i1i.f2675Ll1 != null || !c1.Ilil()) {
                    int i4 = i1i.f5052I1I;
                    int i5 = iLil.f5061IL1Iii;
                    i1i.f5052I1I = i4 - i5;
                    i3 -= i5;
                }
                int i6 = i1i.f2677iILLL1;
                if (i6 != Integer.MIN_VALUE) {
                    int i7 = i6 + iLil.f5061IL1Iii;
                    i1i.f2677iILLL1 = i7;
                    int i8 = i1i.f5052I1I;
                    if (i8 < 0) {
                        i1i.f2677iILLL1 = i7 + i8;
                    }
                    recycleByLayoutState(lLVar, i1i);
                }
                if (z && iLil.f2682IL) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - i1i.f5052I1I;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public View findFirstVisibleChildClosestToEnd(boolean z, boolean z2) {
        return this.mShouldReverseLayout ? findOneVisibleChild(0, getChildCount(), z, z2) : findOneVisibleChild(getChildCount() - 1, -1, z, z2);
    }

    public View findFirstVisibleChildClosestToStart(boolean z, boolean z2) {
        return this.mShouldReverseLayout ? findOneVisibleChild(getChildCount() - 1, -1, z, z2) : findOneVisibleChild(0, getChildCount(), z, z2);
    }

    public int findFirstVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public View findOnePartiallyOrCompletelyInvisibleChild(int i, int i2) {
        byte b;
        int i3;
        int i4;
        ensureLayoutState();
        if (i2 > i) {
            b = 1;
        } else {
            b = i2 < i ? (byte) -1 : (byte) 0;
        }
        if (b == 0) {
            return getChildAt(i);
        }
        if (this.mOrientationHelper.mo2358iILLL1(getChildAt(i)) < this.mOrientationHelper.mo2359lIiI()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        return this.mOrientation == 0 ? this.mHorizontalBoundCheck.IL1Iii(i, i2, i3, i4) : this.mVerticalBoundCheck.IL1Iii(i, i2, i3, i4);
    }

    public View findOneVisibleChild(int i, int i2, boolean z, boolean z2) {
        ensureLayoutState();
        int i3 = TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE;
        int i4 = z ? 24579 : TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE;
        if (!z2) {
            i3 = 0;
        }
        return this.mOrientation == 0 ? this.mHorizontalBoundCheck.IL1Iii(i, i2, i4, i3) : this.mVerticalBoundCheck.IL1Iii(i, i2, i4, i3);
    }

    public View findReferenceChild(RecyclerView.lL lLVar, RecyclerView.C1 c1, int i, int i2, int i3) {
        ensureLayoutState();
        int iMo2359lIiI = this.mOrientationHelper.mo2359lIiI();
        int iMo2357L11I = this.mOrientationHelper.mo2357L11I();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).I1I()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.mOrientationHelper.mo2358iILLL1(childAt) < iMo2357L11I && this.mOrientationHelper.mo2354IL(childAt) >= iMo2359lIiI) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public View findViewByPosition(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i) {
                return childAt;
            }
        }
        return super.findViewByPosition(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Deprecated
    public int getExtraLayoutSpace(RecyclerView.C1 c1) {
        if (c1.m3299IL()) {
            return this.mOrientationHelper.mo2353ILl();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    public void layoutChunk(RecyclerView.lL lLVar, RecyclerView.C1 c1, I1I i1i, ILil iLil) {
        int i;
        int i2;
        int i3;
        int paddingLeft;
        int iMo2362lLi1LL;
        View viewM3248IL = i1i.m3248IL(lLVar);
        if (viewM3248IL == null) {
            iLil.f5062ILil = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewM3248IL.getLayoutParams();
        if (i1i.f2675Ll1 == null) {
            if (this.mShouldReverseLayout == (i1i.f2679lLi1LL == -1)) {
                addView(viewM3248IL);
            } else {
                addView(viewM3248IL, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (i1i.f2679lLi1LL == -1)) {
                addDisappearingView(viewM3248IL);
            } else {
                addDisappearingView(viewM3248IL, 0);
            }
        }
        measureChildWithMargins(viewM3248IL, 0, 0);
        iLil.f5061IL1Iii = this.mOrientationHelper.Ilil(viewM3248IL);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                iMo2362lLi1LL = getWidth() - getPaddingRight();
                paddingLeft = iMo2362lLi1LL - this.mOrientationHelper.mo2362lLi1LL(viewM3248IL);
            } else {
                paddingLeft = getPaddingLeft();
                iMo2362lLi1LL = this.mOrientationHelper.mo2362lLi1LL(viewM3248IL) + paddingLeft;
            }
            if (i1i.f2679lLi1LL == -1) {
                int i4 = i1i.f5054ILil;
                i3 = i4;
                i2 = iMo2362lLi1LL;
                i = i4 - iLil.f5061IL1Iii;
            } else {
                int i5 = i1i.f5054ILil;
                i = i5;
                i2 = iMo2362lLi1LL;
                i3 = iLil.f5061IL1Iii + i5;
            }
        } else {
            int paddingTop = getPaddingTop();
            int iMo2362lLi1LL2 = this.mOrientationHelper.mo2362lLi1LL(viewM3248IL) + paddingTop;
            if (i1i.f2679lLi1LL == -1) {
                int i6 = i1i.f5054ILil;
                i2 = i6;
                i = paddingTop;
                i3 = iMo2362lLi1LL2;
                paddingLeft = i6 - iLil.f5061IL1Iii;
            } else {
                int i7 = i1i.f5054ILil;
                i = paddingTop;
                i2 = iLil.f5061IL1Iii + i7;
                i3 = iMo2362lLi1LL2;
                paddingLeft = i7;
            }
        }
        layoutDecoratedWithMargins(viewM3248IL, paddingLeft, i, i2, i3);
        if (layoutParams.I1I() || layoutParams.ILil()) {
            iLil.f5060I1I = true;
        }
        iLil.f2682IL = viewM3248IL.hasFocusable();
    }

    public void onAnchorReady(RecyclerView.lL lLVar, RecyclerView.C1 c1, IL1Iii iL1Iii, int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.lL lLVar) {
        super.onDetachedFromWindow(recyclerView, lLVar);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(lLVar);
            lLVar.I1I();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public View onFocusSearchFailed(View view, int i, RecyclerView.lL lLVar, RecyclerView.C1 c1) {
        int iConvertFocusDirectionToLayoutDirection;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (iConvertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(iConvertFocusDirectionToLayoutDirection, (int) (this.mOrientationHelper.mo2353ILl() * MAX_SCROLL_FACTOR), false, c1);
        I1I i1i = this.mLayoutState;
        i1i.f2677iILLL1 = Integer.MIN_VALUE;
        i1i.f5053IL1Iii = false;
        fill(lLVar, i1i, c1, true);
        View viewFindPartiallyOrCompletelyInvisibleChildClosestToStart = iConvertFocusDirectionToLayoutDirection == -1 ? findPartiallyOrCompletelyInvisibleChildClosestToStart() : findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        View childClosestToStart = iConvertFocusDirectionToLayoutDirection == -1 ? getChildClosestToStart() : getChildClosestToEnd();
        if (!childClosestToStart.hasFocusable()) {
            return viewFindPartiallyOrCompletelyInvisibleChildClosestToStart;
        }
        if (viewFindPartiallyOrCompletelyInvisibleChildClosestToStart == null) {
            return null;
        }
        return childClosestToStart;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void onLayoutChildren(RecyclerView.lL lLVar, RecyclerView.C1 c1) {
        int i;
        int i2;
        int i3;
        int i4;
        int iFixLayoutEndGap;
        int i5;
        View viewFindViewByPosition;
        int iMo2358iILLL1;
        int iMo2357L11I;
        int i6 = -1;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && c1.ILil() == 0) {
            removeAndRecycleAllViews(lLVar);
            return;
        }
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.IL1Iii()) {
            this.mPendingScrollPosition = this.mPendingSavedState.f5064ILil;
        }
        ensureLayoutState();
        this.mLayoutState.f5053IL1Iii = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        IL1Iii iL1Iii = this.mAnchorInfo;
        if (!iL1Iii.f5059Ilil || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            iL1Iii.Ilil();
            IL1Iii iL1Iii2 = this.mAnchorInfo;
            iL1Iii2.f2681IL = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(lLVar, c1, iL1Iii2);
            this.mAnchorInfo.f5059Ilil = true;
        } else if (focusedChild != null && (this.mOrientationHelper.mo2358iILLL1(focusedChild) >= this.mOrientationHelper.mo2357L11I() || this.mOrientationHelper.mo2354IL(focusedChild) <= this.mOrientationHelper.mo2359lIiI())) {
            this.mAnchorInfo.I1I(focusedChild, getPosition(focusedChild));
        }
        I1I i1i = this.mLayoutState;
        i1i.f2679lLi1LL = i1i.ILL >= 0 ? 1 : -1;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(c1, iArr);
        int iMax = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.mo2359lIiI();
        int iMax2 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.mo2363il();
        if (c1.Ilil() && (i5 = this.mPendingScrollPosition) != -1 && this.mPendingScrollPositionOffset != Integer.MIN_VALUE && (viewFindViewByPosition = findViewByPosition(i5)) != null) {
            if (this.mShouldReverseLayout) {
                iMo2357L11I = this.mOrientationHelper.mo2357L11I() - this.mOrientationHelper.mo2354IL(viewFindViewByPosition);
                iMo2358iILLL1 = this.mPendingScrollPositionOffset;
            } else {
                iMo2358iILLL1 = this.mOrientationHelper.mo2358iILLL1(viewFindViewByPosition) - this.mOrientationHelper.mo2359lIiI();
                iMo2357L11I = this.mPendingScrollPositionOffset;
            }
            int i7 = iMo2357L11I - iMo2358iILLL1;
            if (i7 > 0) {
                iMax += i7;
            } else {
                iMax2 -= i7;
            }
        }
        IL1Iii iL1Iii3 = this.mAnchorInfo;
        if (!iL1Iii3.f2681IL ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i6 = 1;
        }
        onAnchorReady(lLVar, c1, iL1Iii3, i6);
        detachAndScrapAttachedViews(lLVar);
        this.mLayoutState.f2678lIiI = resolveIsInfinite();
        this.mLayoutState.f2680il = c1.Ilil();
        this.mLayoutState.f2676L11I = 0;
        IL1Iii iL1Iii4 = this.mAnchorInfo;
        if (iL1Iii4.f2681IL) {
            updateLayoutStateToFillStart(iL1Iii4);
            I1I i1i2 = this.mLayoutState;
            i1i2.f2674IiL = iMax;
            fill(lLVar, i1i2, c1, false);
            I1I i1i3 = this.mLayoutState;
            i2 = i1i3.f5054ILil;
            int i8 = i1i3.f2673IL;
            int i9 = i1i3.f5052I1I;
            if (i9 > 0) {
                iMax2 += i9;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            I1I i1i4 = this.mLayoutState;
            i1i4.f2674IiL = iMax2;
            i1i4.f2673IL += i1i4.f5055Ilil;
            fill(lLVar, i1i4, c1, false);
            I1I i1i5 = this.mLayoutState;
            i = i1i5.f5054ILil;
            int i10 = i1i5.f5052I1I;
            if (i10 > 0) {
                updateLayoutStateToFillStart(i8, i2);
                I1I i1i6 = this.mLayoutState;
                i1i6.f2674IiL = i10;
                fill(lLVar, i1i6, c1, false);
                i2 = this.mLayoutState.f5054ILil;
            }
        } else {
            updateLayoutStateToFillEnd(iL1Iii4);
            I1I i1i7 = this.mLayoutState;
            i1i7.f2674IiL = iMax2;
            fill(lLVar, i1i7, c1, false);
            I1I i1i8 = this.mLayoutState;
            i = i1i8.f5054ILil;
            int i11 = i1i8.f2673IL;
            int i12 = i1i8.f5052I1I;
            if (i12 > 0) {
                iMax += i12;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            I1I i1i9 = this.mLayoutState;
            i1i9.f2674IiL = iMax;
            i1i9.f2673IL += i1i9.f5055Ilil;
            fill(lLVar, i1i9, c1, false);
            I1I i1i10 = this.mLayoutState;
            i2 = i1i10.f5054ILil;
            int i13 = i1i10.f5052I1I;
            if (i13 > 0) {
                updateLayoutStateToFillEnd(i11, i);
                I1I i1i11 = this.mLayoutState;
                i1i11.f2674IiL = i13;
                fill(lLVar, i1i11, c1, false);
                i = this.mLayoutState.f5054ILil;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int iFixLayoutEndGap2 = fixLayoutEndGap(i, lLVar, c1, true);
                i3 = i2 + iFixLayoutEndGap2;
                i4 = i + iFixLayoutEndGap2;
                iFixLayoutEndGap = fixLayoutStartGap(i3, lLVar, c1, false);
            } else {
                int iFixLayoutStartGap = fixLayoutStartGap(i2, lLVar, c1, true);
                i3 = i2 + iFixLayoutStartGap;
                i4 = i + iFixLayoutStartGap;
                iFixLayoutEndGap = fixLayoutEndGap(i4, lLVar, c1, false);
            }
            i2 = i3 + iFixLayoutEndGap;
            i = i4 + iFixLayoutEndGap;
        }
        layoutForPredictiveAnimations(lLVar, c1, i2, i);
        if (c1.Ilil()) {
            this.mAnchorInfo.Ilil();
        } else {
            this.mOrientationHelper.iIi1();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void onLayoutCompleted(RecyclerView.C1 c1) {
        super.onLayoutCompleted(c1);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.Ilil();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.mPendingSavedState = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState.f2683IL = z;
            if (z) {
                View childClosestToEnd = getChildClosestToEnd();
                savedState.f5063I1I = this.mOrientationHelper.mo2357L11I() - this.mOrientationHelper.mo2354IL(childClosestToEnd);
                savedState.f5064ILil = getPosition(childClosestToEnd);
            } else {
                View childClosestToStart = getChildClosestToStart();
                savedState.f5064ILil = getPosition(childClosestToStart);
                savedState.f5063I1I = this.mOrientationHelper.mo2358iILLL1(childClosestToStart) - this.mOrientationHelper.mo2359lIiI();
            }
        } else {
            savedState.ILil();
        }
        return savedState;
    }

    public void prepareForDrop(View view, View view2, int i, int i2) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        byte b = position < position2 ? (byte) 1 : (byte) -1;
        if (this.mShouldReverseLayout) {
            if (b == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.mo2357L11I() - (this.mOrientationHelper.mo2358iILLL1(view2) + this.mOrientationHelper.Ilil(view)));
                return;
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.mo2357L11I() - this.mOrientationHelper.mo2354IL(view2));
                return;
            }
        }
        if (b == -1) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.mo2358iILLL1(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.mo2354IL(view2) - this.mOrientationHelper.Ilil(view));
        }
    }

    public boolean resolveIsInfinite() {
        return this.mOrientationHelper.ILL() == 0 && this.mOrientationHelper.mo2355IiL() == 0;
    }

    public int scrollBy(int i, RecyclerView.lL lLVar, RecyclerView.C1 c1) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.f5053IL1Iii = true;
        int i2 = i > 0 ? 1 : -1;
        int iAbs = Math.abs(i);
        updateLayoutState(i2, iAbs, true, c1);
        I1I i1i = this.mLayoutState;
        int iFill = i1i.f2677iILLL1 + fill(lLVar, i1i, c1, false);
        if (iFill < 0) {
            return 0;
        }
        if (iAbs > iFill) {
            i = i2 * iFill;
        }
        this.mOrientationHelper.mo2360lIlii(-i);
        this.mLayoutState.ILL = i;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public int scrollHorizontallyBy(int i, RecyclerView.lL lLVar, RecyclerView.C1 c1) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i, lLVar, c1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.ILil();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = i2;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.ILil();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public int scrollVerticallyBy(int i, RecyclerView.lL lLVar, RecyclerView.C1 c1) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i, lLVar, c1);
    }

    public void setInitialPrefetchItemCount(int i) {
        this.mInitialPrefetchItemCount = i;
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        assertNotInLayoutOrScroll(null);
        if (i != this.mOrientation || this.mOrientationHelper == null) {
            ILL illILil = ILL.ILil(this, i);
            this.mOrientationHelper = illILil;
            this.mAnchorInfo.f5057IL1Iii = illILil;
            this.mOrientation = i;
            requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.mRecycleChildrenOnDetach = z;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (z == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = z;
        requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == z) {
            return;
        }
        this.mStackFromEnd = z;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.C1 c1, int i) {
        IiL iiL = new IiL(recyclerView.getContext());
        iiL.setTargetPosition(i);
        startSmoothScroll(iiL);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    public void validateChildOrder() {
        Log.d(TAG, "validating child count " + getChildCount());
        if (getChildCount() < 1) {
            return;
        }
        int position = getPosition(getChildAt(0));
        int iMo2358iILLL1 = this.mOrientationHelper.mo2358iILLL1(getChildAt(0));
        if (this.mShouldReverseLayout) {
            for (int i = 1; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                int position2 = getPosition(childAt);
                int iMo2358iILLL2 = this.mOrientationHelper.mo2358iILLL1(childAt);
                if (position2 < position) {
                    logChildren();
                    StringBuilder sb = new StringBuilder();
                    sb.append("detected invalid position. loc invalid? ");
                    sb.append(iMo2358iILLL2 < iMo2358iILLL1);
                    throw new RuntimeException(sb.toString());
                }
                if (iMo2358iILLL2 > iMo2358iILLL1) {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
            return;
        }
        for (int i2 = 1; i2 < getChildCount(); i2++) {
            View childAt2 = getChildAt(i2);
            int position3 = getPosition(childAt2);
            int iMo2358iILLL3 = this.mOrientationHelper.mo2358iILLL1(childAt2);
            if (position3 < position) {
                logChildren();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("detected invalid position. loc invalid? ");
                sb2.append(iMo2358iILLL3 < iMo2358iILLL1);
                throw new RuntimeException(sb2.toString());
            }
            if (iMo2358iILLL3 < iMo2358iILLL1) {
                logChildren();
                throw new RuntimeException("detected invalid location");
            }
        }
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new IL1Iii();
        this.mLayoutChunkResult = new ILil();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i);
        setReverseLayout(z);
    }

    private void updateLayoutStateToFillEnd(int i, int i2) {
        this.mLayoutState.f5052I1I = this.mOrientationHelper.mo2357L11I() - i2;
        I1I i1i = this.mLayoutState;
        i1i.f5055Ilil = this.mShouldReverseLayout ? -1 : 1;
        i1i.f2673IL = i;
        i1i.f2679lLi1LL = 1;
        i1i.f5054ILil = i2;
        i1i.f2677iILLL1 = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(int i, int i2) {
        this.mLayoutState.f5052I1I = i2 - this.mOrientationHelper.mo2359lIiI();
        I1I i1i = this.mLayoutState;
        i1i.f2673IL = i;
        i1i.f5055Ilil = this.mShouldReverseLayout ? 1 : -1;
        i1i.f2679lLi1LL = -1;
        i1i.f5054ILil = i2;
        i1i.f2677iILLL1 = Integer.MIN_VALUE;
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new IL1Iii();
        this.mLayoutChunkResult = new ILil();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.LlLI1.IL properties = RecyclerView.LlLI1.getProperties(context, attributeSet, i, i2);
        setOrientation(properties.f5080IL1Iii);
        setReverseLayout(properties.f5079I1I);
        setStackFromEnd(properties.f2686IL);
    }
}
