package androidx.recyclerview.widget;

import ILil.p028IiL.p029ILl.InterfaceC0634il;
import android.R;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.customview.view.AbsSavedState;
import com.google.android.flexbox.BuildConfig;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.opencv.calib3d.Calib3d;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements InterfaceC0634il {
    public static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
    public static final boolean ALLOW_THREAD_GAP_WORK;
    public static final boolean DEBUG = false;
    public static final int DEFAULT_ORIENTATION = 1;
    public static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION;
    public static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
    public static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    public static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS = {R.attr.nestedScrollingEnabled};
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    public static final boolean POST_UPDATES_ON_ANIMATION;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    public static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    public static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    public static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    public static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    public static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    public static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    public static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    public static final Interpolator sQuinticInterpolator;
    public ILil.Lil.p037IL.lIiI mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    public IiL mAdapter;
    public ILil.Lil.p037IL.IL1Iii mAdapterHelper;
    public boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private ILL mChildDrawingOrderCallback;
    public ILil.Lil.p037IL.ILil mChildHelper;
    public boolean mClipToPadding;
    public boolean mDataSetHasChangedAfterLayout;
    public boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private Ll1 mEdgeEffectFactory;
    public boolean mEnableFastScroller;
    public boolean mFirstLayoutComplete;
    public ILil.Lil.p037IL.lLi1LL mGapWorker;
    public boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private iIi1 mInterceptingOnItemTouchListener;
    public boolean mIsAttached;
    public lIiI mItemAnimator;
    private lIiI.ILil mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    public final ArrayList<Lil> mItemDecorations;
    public boolean mItemsAddedOrRemoved;
    public boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    public LlLI1 mLayout;
    private int mLayoutOrScrollCounter;
    public boolean mLayoutSuppressed;
    public boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final llliI mObserver;
    private List<llL1ii> mOnChildAttachStateListeners;
    private lIlii mOnFlingListener;
    private final ArrayList<iIi1> mOnItemTouchListeners;
    public final List<LL1IL> mPendingAccessibilityImportanceChange;
    private SavedState mPendingSavedState;
    public boolean mPostedAnimatorRunner;
    public ILil.Lil.p037IL.lLi1LL.ILil mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    public final lL mRecycler;
    public I11L mRecyclerListener;
    public final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private iIlLiL mScrollListener;
    private List<iIlLiL> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private ILil.p028IiL.p029ILl.ILL mScrollingChildHelper;
    public final C1 mState;
    public final Rect mTempRect;
    private final Rect mTempRect2;
    public final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    public final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    public final RunnableC0664lIII mViewFlinger;
    private final ILil.Lil.p037IL.lIlii.ILil mViewInfoProcessCallback;
    public final ILil.Lil.p037IL.lIlii mViewInfoStore;

    public interface I11L {
        void IL1Iii(LL1IL ll1il);
    }

    public static class I11li1 {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public SparseArray<IL1Iii> f5065IL1Iii = new SparseArray<>();

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f5066ILil = 0;

        public static class IL1Iii {

            /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
            public final ArrayList<LL1IL> f5068IL1Iii = new ArrayList<>();

            /* JADX INFO: renamed from: ILil, reason: collision with root package name */
            public int f5069ILil = 5;

            /* JADX INFO: renamed from: I1I, reason: collision with root package name */
            public long f5067I1I = 0;

            /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
            public long f2684IL = 0;
        }

        public void I1I() {
            this.f5066ILil--;
        }

        public void IL1Iii() {
            this.f5066ILil++;
        }

        public boolean ILL(int i, long j, long j2) {
            long j3 = m3255iILLL1(i).f2684IL;
            return j3 == 0 || j + j3 < j2;
        }

        public void ILil() {
            for (int i = 0; i < this.f5065IL1Iii.size(); i++) {
                this.f5065IL1Iii.valueAt(i).f5068IL1Iii.clear();
            }
        }

        public void Ilil(int i, long j) {
            IL1Iii iL1IiiM3255iILLL1 = m3255iILLL1(i);
            iL1IiiM3255iILLL1.f5067I1I = m3257il(iL1IiiM3255iILLL1.f5067I1I, j);
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public void m3251IL(int i, long j) {
            IL1Iii iL1IiiM3255iILLL1 = m3255iILLL1(i);
            iL1IiiM3255iILLL1.f2684IL = m3257il(iL1IiiM3255iILLL1.f2684IL, j);
        }

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public void m3252IiL(IiL iiL, IiL iiL2, boolean z) {
            if (iiL != null) {
                I1I();
            }
            if (!z && this.f5066ILil == 0) {
                ILil();
            }
            if (iiL2 != null) {
                IL1Iii();
            }
        }

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public boolean m3253Ll1(int i, long j, long j2) {
            long j3 = m3255iILLL1(i).f5067I1I;
            return j3 == 0 || j + j3 < j2;
        }

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public void m3254L11I(LL1IL ll1il) {
            int itemViewType = ll1il.getItemViewType();
            ArrayList<LL1IL> arrayList = m3255iILLL1(itemViewType).f5068IL1Iii;
            if (this.f5065IL1Iii.get(itemViewType).f5069ILil <= arrayList.size()) {
                return;
            }
            ll1il.resetInternal();
            arrayList.add(ll1il);
        }

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public final IL1Iii m3255iILLL1(int i) {
            IL1Iii iL1Iii = this.f5065IL1Iii.get(i);
            if (iL1Iii != null) {
                return iL1Iii;
            }
            IL1Iii iL1Iii2 = new IL1Iii();
            this.f5065IL1Iii.put(i, iL1Iii2);
            return iL1Iii2;
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public LL1IL m3256lLi1LL(int i) {
            IL1Iii iL1Iii = this.f5065IL1Iii.get(i);
            if (iL1Iii == null || iL1Iii.f5068IL1Iii.isEmpty()) {
                return null;
            }
            ArrayList<LL1IL> arrayList = iL1Iii.f5068IL1Iii;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public long m3257il(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }
    }

    public static class I1I implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    public class IL1Iii implements Runnable {
        public IL1Iii() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.mFirstLayoutComplete || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.mIsAttached) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.mLayoutSuppressed) {
                recyclerView2.mLayoutWasDefered = true;
            } else {
                recyclerView2.consumePendingUpdateOperations();
            }
        }
    }

    public interface ILL {
        int IL1Iii(int i, int i2);
    }

    public class ILil implements Runnable {
        public ILil() {
        }

        @Override // java.lang.Runnable
        public void run() {
            lIiI liii = RecyclerView.this.mItemAnimator;
            if (liii != null) {
                liii.I11li1();
            }
            RecyclerView.this.mPostedAnimatorRunner = false;
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$IL丨丨l, reason: invalid class name and case insensitive filesystem */
    public class C0663ILl implements lIiI.ILil {
        public C0663ILl() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.lIiI.ILil
        public void IL1Iii(LL1IL ll1il) {
            ll1il.setIsRecyclable(true);
            if (ll1il.mShadowedHolder != null && ll1il.mShadowingHolder == null) {
                ll1il.mShadowedHolder = null;
            }
            ll1il.mShadowingHolder = null;
            if (ll1il.shouldBeKeptAsChild() || RecyclerView.this.removeAnimatingView(ll1il.itemView) || !ll1il.isTmpDetached()) {
                return;
            }
            RecyclerView.this.removeDetachedView(ll1il.itemView, false);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$I丨L, reason: invalid class name */
    public class IL implements ILil.Lil.p037IL.lIlii.ILil {
        public IL() {
        }

        @Override // ILil.Lil.p037IL.lIlii.ILil
        public void I1I(LL1IL ll1il, lIiI.I1I i1i, lIiI.I1I i1i2) {
            RecyclerView.this.mRecycler.m3292iILLl(ll1il);
            RecyclerView.this.animateDisappearance(ll1il, i1i, i1i2);
        }

        @Override // ILil.Lil.p037IL.lIlii.ILil
        public void IL1Iii(LL1IL ll1il) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mLayout.removeAndRecycleView(ll1il.itemView, recyclerView.mRecycler);
        }

        @Override // ILil.Lil.p037IL.lIlii.ILil
        public void ILil(LL1IL ll1il, lIiI.I1I i1i, lIiI.I1I i1i2) {
            RecyclerView.this.animateAppearance(ll1il, i1i, i1i2);
        }

        @Override // ILil.Lil.p037IL.lIlii.ILil
        /* JADX INFO: renamed from: I丨L */
        public void mo2437IL(LL1IL ll1il, lIiI.I1I i1i, lIiI.I1I i1i2) {
            ll1il.setIsRecyclable(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mDataSetHasChangedAfterLayout) {
                if (recyclerView.mItemAnimator.ILil(ll1il, ll1il, i1i, i1i2)) {
                    RecyclerView.this.postAnimationRunner();
                }
            } else if (recyclerView.mItemAnimator.mo2398IL(ll1il, i1i, i1i2)) {
                RecyclerView.this.postAnimationRunner();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$I丨iL, reason: invalid class name */
    public static abstract class IiL<VH extends LL1IL> {
        private final L11I mObservable = new L11I();
        private boolean mHasStableIds = false;

        public final void bindViewHolder(VH vh, int i) {
            vh.mPosition = i;
            if (hasStableIds()) {
                vh.mItemId = getItemId(i);
            }
            vh.setFlags(1, 519);
            ILil.p028IiL.p036il.IL1Iii.IL1Iii(RecyclerView.TRACE_BIND_VIEW_TAG);
            onBindViewHolder(vh, i, vh.getUnmodifiedPayloads());
            vh.clearPayload();
            ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                ((LayoutParams) layoutParams).f5074I1I = true;
            }
            ILil.p028IiL.p036il.IL1Iii.ILil();
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i) {
            try {
                ILil.p028IiL.p036il.IL1Iii.IL1Iii(RecyclerView.TRACE_CREATE_VIEW_TAG);
                VH vh = (VH) onCreateViewHolder(viewGroup, i);
                if (vh.itemView.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                vh.mItemViewType = i;
                ILil.p028IiL.p036il.IL1Iii.ILil();
                return vh;
            } catch (Throwable th) {
                ILil.p028IiL.p036il.IL1Iii.ILil();
                throw th;
            }
        }

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1L;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public final boolean hasObservers() {
            return this.mObservable.IL1Iii();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.ILil();
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.m3259IL(i, 1);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.m3261lLi1LL(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.mObservable.I1I(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.mObservable.m3259IL(i, i2);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.mObservable.m3261lLi1LL(i, i2);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.mObservable.m3260iILLL1(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.m3260iILLL1(i, 1);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i);

        public void onBindViewHolder(VH vh, int i, List<Object> list) {
            onBindViewHolder(vh, i);
        }

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void registerAdapterDataObserver(AbstractC0665il abstractC0665il) {
            this.mObservable.registerObserver(abstractC0665il);
        }

        public void setHasStableIds(boolean z) {
            if (hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.mHasStableIds = z;
        }

        public void unregisterAdapterDataObserver(AbstractC0665il abstractC0665il) {
            this.mObservable.unregisterObserver(abstractC0665il);
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.mObservable.Ilil(i, 1, obj);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.mObservable.Ilil(i, i2, obj);
        }
    }

    public static abstract class LL1IL {
        public static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        public static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        public static final int FLAG_BOUND = 1;
        public static final int FLAG_IGNORE = 128;
        public static final int FLAG_INVALID = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_NOT_RECYCLABLE = 16;
        public static final int FLAG_REMOVED = 8;
        public static final int FLAG_RETURNED_FROM_SCRAP = 32;
        public static final int FLAG_TMP_DETACHED = 256;
        public static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        public static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        public int mFlags;
        public WeakReference<RecyclerView> mNestedRecyclerView;
        public RecyclerView mOwnerRecyclerView;
        public int mPosition = -1;
        public int mOldPosition = -1;
        public long mItemId = -1;
        public int mItemViewType = -1;
        public int mPreLayoutPosition = -1;
        public LL1IL mShadowedHolder = null;
        public LL1IL mShadowingHolder = null;
        public List<Object> mPayloads = null;
        public List<Object> mUnmodifiedPayloads = null;
        private int mIsRecyclableCount = 0;
        public lL mScrapContainer = null;
        public boolean mInChangeScrap = false;
        private int mWasImportantForAccessibilityBeforeHidden = 0;
        public int mPendingAccessibilityState = -1;

        public LL1IL(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.itemView = view;
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        public void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        public void addFlags(int i) {
            this.mFlags = i | this.mFlags;
        }

        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        public void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        public boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && ILil.p028IiL.p029ILl.iIlLiL.m2116ill(this.itemView);
        }

        public void flagRemovedAndOffsetPosition(int i, int i2, boolean z) {
            addFlags(8);
            offsetPosition(i2, z);
            this.mPosition = i;
        }

        public final int getAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionFor(this);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            return (list == null || list.size() == 0) ? FULLUPDATE_PAYLOADS : this.mUnmodifiedPayloads;
        }

        public boolean hasAnyOfTheFlags(int i) {
            return (i & this.mFlags) != 0;
        }

        public boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        public boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        public boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !ILil.p028IiL.p029ILl.iIlLiL.m2116ill(this.itemView);
        }

        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        public boolean isScrap() {
            return this.mScrapContainer != null;
        }

        public boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        public boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }

        public boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        public void offsetPosition(int i, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).f5074I1I = true;
            }
        }

        public void onEnteredHiddenState(RecyclerView recyclerView) {
            int i = this.mPendingAccessibilityState;
            if (i != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = ILil.p028IiL.p029ILl.iIlLiL.I11L(this.itemView);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1L;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        public void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        public void setFlags(int i, int i2) {
            this.mFlags = (i & i2) | (this.mFlags & (~i2));
        }

        public final void setIsRecyclable(boolean z) {
            int i = this.mIsRecyclableCount;
            int i2 = z ? i - 1 : i + 1;
            this.mIsRecyclableCount = i2;
            if (i2 < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z && i2 == 1) {
                this.mFlags |= 16;
            } else if (z && i2 == 0) {
                this.mFlags &= -17;
            }
        }

        public void setScrapContainer(lL lLVar, boolean z) {
            this.mScrapContainer = lLVar;
            this.mInChangeScrap = z;
        }

        public boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        public boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb.append(" scrap ");
                sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public void unScrap() {
            this.mScrapContainer.m3292iILLl(this);
        }

        public boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }
    }

    public static abstract class Lil {
        @Deprecated
        public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        @Deprecated
        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, C1 c1) {
            onDraw(canvas, recyclerView);
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, C1 c1) {
            onDrawOver(canvas, recyclerView);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1 c1) {
            getItemOffsets(rect, ((LayoutParams) view.getLayoutParams()).IL1Iii(), recyclerView);
        }
    }

    public static abstract class LlLI1 {
        public boolean mAutoMeasure;
        public ILil.Lil.p037IL.ILil mChildHelper;
        private int mHeight;
        private int mHeightMode;
        public ILil.Lil.p037IL.llL1ii mHorizontalBoundCheck;
        private final ILil.Lil.p037IL.llL1ii.ILil mHorizontalBoundCheckCallback;
        public boolean mIsAttachedToWindow;
        private boolean mItemPrefetchEnabled;
        private boolean mMeasurementCacheEnabled;
        public int mPrefetchMaxCountObserved;
        public boolean mPrefetchMaxObservedInInitialPrefetch;
        public RecyclerView mRecyclerView;
        public boolean mRequestedSimpleAnimations;
        public l mSmoothScroller;
        public ILil.Lil.p037IL.llL1ii mVerticalBoundCheck;
        private final ILil.Lil.p037IL.llL1ii.ILil mVerticalBoundCheckCallback;
        private int mWidth;
        private int mWidthMode;

        public interface I1I {
            void IL1Iii(int i, int i2);
        }

        public class IL1Iii implements ILil.Lil.p037IL.llL1ii.ILil {
            public IL1Iii() {
            }

            @Override // ILil.Lil.p037IL.llL1ii.ILil
            public int I1I() {
                return LlLI1.this.getPaddingLeft();
            }

            @Override // ILil.Lil.p037IL.llL1ii.ILil
            public View IL1Iii(int i) {
                return LlLI1.this.getChildAt(i);
            }

            @Override // ILil.Lil.p037IL.llL1ii.ILil
            public int ILil(View view) {
                return LlLI1.this.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).leftMargin;
            }

            @Override // ILil.Lil.p037IL.llL1ii.ILil
            public int Ilil(View view) {
                return LlLI1.this.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).rightMargin;
            }

            @Override // ILil.Lil.p037IL.llL1ii.ILil
            /* JADX INFO: renamed from: I丨L */
            public int mo2439IL() {
                return LlLI1.this.getWidth() - LlLI1.this.getPaddingRight();
            }
        }

        public class ILil implements ILil.Lil.p037IL.llL1ii.ILil {
            public ILil() {
            }

            @Override // ILil.Lil.p037IL.llL1ii.ILil
            public int I1I() {
                return LlLI1.this.getPaddingTop();
            }

            @Override // ILil.Lil.p037IL.llL1ii.ILil
            public View IL1Iii(int i) {
                return LlLI1.this.getChildAt(i);
            }

            @Override // ILil.Lil.p037IL.llL1ii.ILil
            public int ILil(View view) {
                return LlLI1.this.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).topMargin;
            }

            @Override // ILil.Lil.p037IL.llL1ii.ILil
            public int Ilil(View view) {
                return LlLI1.this.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
            }

            @Override // ILil.Lil.p037IL.llL1ii.ILil
            /* JADX INFO: renamed from: I丨L */
            public int mo2439IL() {
                return LlLI1.this.getHeight() - LlLI1.this.getPaddingBottom();
            }
        }

        /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$LlLI1$I丨L, reason: invalid class name */
        public static class IL {

            /* JADX INFO: renamed from: I1I, reason: collision with root package name */
            public boolean f5079I1I;

            /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
            public int f5080IL1Iii;

            /* JADX INFO: renamed from: ILil, reason: collision with root package name */
            public int f5081ILil;

            /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
            public boolean f2686IL;
        }

        public LlLI1() {
            IL1Iii iL1Iii = new IL1Iii();
            this.mHorizontalBoundCheckCallback = iL1Iii;
            ILil iLil = new ILil();
            this.mVerticalBoundCheckCallback = iLil;
            this.mHorizontalBoundCheck = new ILil.Lil.p037IL.llL1ii(iL1Iii);
            this.mVerticalBoundCheck = new ILil.Lil.p037IL.llL1ii(iLil);
            this.mRequestedSimpleAnimations = false;
            this.mIsAttachedToWindow = false;
            this.mAutoMeasure = false;
            this.mMeasurementCacheEnabled = true;
            this.mItemPrefetchEnabled = true;
        }

        private void addViewInt(View view, int i, boolean z) {
            LL1IL childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z || childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.ILil(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.LlLI1(childViewHolderInt);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.I1I(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.mRecyclerView) {
                int iM2370lIiI = this.mChildHelper.m2370lIiI(view);
                if (i == -1) {
                    i = this.mChildHelper.m2369iILLL1();
                }
                if (iM2370lIiI == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(view) + this.mRecyclerView.exceptionLabel());
                }
                if (iM2370lIiI != i) {
                    this.mRecyclerView.mLayout.moveView(iM2370lIiI, i);
                }
            } else {
                this.mChildHelper.IL1Iii(view, i, false);
                layoutParams.f5074I1I = true;
                l lVar = this.mSmoothScroller;
                if (lVar != null && lVar.isRunning()) {
                    this.mSmoothScroller.onChildAttachedToWindow(view);
                }
            }
            if (layoutParams.f2685IL) {
                childViewHolderInt.itemView.invalidate();
                layoutParams.f2685IL = false;
            }
        }

        public static int chooseSize(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        private void detachViewInternal(int i, View view) {
            this.mChildHelper.m2365IL(i);
        }

        /* JADX WARN: Code duplicated, block: B:6:0x000d  */
        /* JADX WARN: Code duplicated, block: B:8:0x0011  */
        @Deprecated
        public static int getChildMeasureSpec(int i, int i2, int i3, boolean z) {
            int i4 = i - i2;
            int i5 = 0;
            int iMax = Math.max(0, i4);
            if (z) {
                if (i3 >= 0) {
                    i5 = Videoio.CAP_OPENNI_IMAGE_GENERATOR;
                } else {
                    i3 = 0;
                }
            } else if (i3 >= 0) {
                i5 = Videoio.CAP_OPENNI_IMAGE_GENERATOR;
            } else {
                if (i3 == -1) {
                    i5 = Videoio.CAP_OPENNI_IMAGE_GENERATOR;
                } else if (i3 == -2) {
                    i5 = Integer.MIN_VALUE;
                } else {
                    i3 = 0;
                }
                i3 = iMax;
            }
            return View.MeasureSpec.makeMeasureSpec(i3, i5);
        }

        private int[] getChildRectangleOnScreenScrollAmount(View view, Rect rect) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i = left - paddingLeft;
            int iMin = Math.min(0, i);
            int i2 = top - paddingTop;
            int iMin2 = Math.min(0, i2);
            int i3 = iWidth - width;
            int iMax = Math.max(0, i3);
            int iMax2 = Math.max(0, iHeight - height);
            if (getLayoutDirection() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i3);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i2, iMax2);
            }
            iArr[0] = iMax;
            iArr[1] = iMin2;
            return iArr;
        }

        public static IL getProperties(Context context, AttributeSet attributeSet, int i, int i2) {
            IL il = new IL();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ILil.Lil.I1I.RecyclerView, i, i2);
            il.f5080IL1Iii = typedArrayObtainStyledAttributes.getInt(ILil.Lil.I1I.RecyclerView_android_orientation, 1);
            il.f5081ILil = typedArrayObtainStyledAttributes.getInt(ILil.Lil.I1I.RecyclerView_spanCount, 1);
            il.f5079I1I = typedArrayObtainStyledAttributes.getBoolean(ILil.Lil.I1I.RecyclerView_reverseLayout, false);
            il.f2686IL = typedArrayObtainStyledAttributes.getBoolean(ILil.Lil.I1I.RecyclerView_stackFromEnd, false);
            typedArrayObtainStyledAttributes.recycle();
            return il;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            return rect.left - i < width && rect.right - i > paddingLeft && rect.top - i2 < height && rect.bottom - i2 > paddingTop;
        }

        private static boolean isMeasurementUpToDate(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        private void scrapOrRecycleView(lL lLVar, int i, View view) {
            LL1IL childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.shouldIgnore()) {
                return;
            }
            if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.mRecyclerView.mAdapter.hasStableIds()) {
                removeViewAt(i);
                lLVar.LL1IL(childViewHolderInt);
            } else {
                detachViewAt(i);
                lLVar.m3278L111(view);
                this.mRecyclerView.mViewInfoStore.ILL(childViewHolderInt);
            }
        }

        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        public void addView(View view) {
            addView(view, -1);
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertInLayoutOrScroll(str);
            }
        }

        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        public void attachView(View view, int i, LayoutParams layoutParams) {
            LL1IL childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.ILil(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.LlLI1(childViewHolderInt);
            }
            this.mChildHelper.I1I(view, i, layoutParams, childViewHolderInt.isRemoved());
        }

        public void calculateItemDecorationsForChild(View view, Rect rect) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public void collectAdjacentPrefetchPositions(int i, int i2, C1 c1, I1I i1i) {
        }

        public void collectInitialPrefetchPositions(int i, I1I i1i) {
        }

        public int computeHorizontalScrollExtent(C1 c1) {
            return 0;
        }

        public int computeHorizontalScrollOffset(C1 c1) {
            return 0;
        }

        public int computeHorizontalScrollRange(C1 c1) {
            return 0;
        }

        public int computeVerticalScrollExtent(C1 c1) {
            return 0;
        }

        public int computeVerticalScrollOffset(C1 c1) {
            return 0;
        }

        public int computeVerticalScrollRange(C1 c1) {
            return 0;
        }

        public void detachAndScrapAttachedViews(lL lLVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(lLVar, childCount, getChildAt(childCount));
            }
        }

        public void detachAndScrapView(View view, lL lLVar) {
            scrapOrRecycleView(lLVar, this.mChildHelper.m2370lIiI(view), view);
        }

        public void detachAndScrapViewAt(int i, lL lLVar) {
            scrapOrRecycleView(lLVar, i, getChildAt(i));
        }

        public void detachView(View view) {
            int iM2370lIiI = this.mChildHelper.m2370lIiI(view);
            if (iM2370lIiI >= 0) {
                detachViewInternal(iM2370lIiI, view);
            }
        }

        public void detachViewAt(int i) {
            detachViewInternal(i, getChildAt(i));
        }

        public void dispatchAttachedToWindow(RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        public void dispatchDetachedFromWindow(RecyclerView recyclerView, lL lLVar) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerView, lLVar);
        }

        public void endAnimation(View view) {
            lIiI liii = this.mRecyclerView.mItemAnimator;
            if (liii != null) {
                liii.mo2332il(RecyclerView.getChildViewHolderInt(view));
            }
        }

        public View findContainingItemView(View view) {
            View viewFindContainingItemView;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (viewFindContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.m2364ILl(viewFindContainingItemView)) {
                return null;
            }
            return viewFindContainingItemView;
        }

        public View findViewByPosition(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                LL1IL childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.Ilil() || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).f5076ILil.bottom;
        }

        public View getChildAt(int i) {
            ILil.Lil.p037IL.ILil iLil = this.mChildHelper;
            if (iLil != null) {
                return iLil.m2373lLi1LL(i);
            }
            return null;
        }

        public int getChildCount() {
            ILil.Lil.p037IL.ILil iLil = this.mChildHelper;
            if (iLil != null) {
                return iLil.m2369iILLL1();
            }
            return 0;
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.mClipToPadding;
        }

        public int getColumnCountForAccessibility(lL lLVar, C1 c1) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || recyclerView.mAdapter == null || !canScrollHorizontally()) {
                return 1;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public int getDecoratedBottom(View view) {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public void getDecoratedBoundsWithMargins(View view, Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f5076ILil;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int getDecoratedMeasuredWidth(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f5076ILil;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedRight(View view) {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.m2364ILl(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getItemCount() {
            RecyclerView recyclerView = this.mRecyclerView;
            IiL adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public int getItemViewType(View view) {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public int getLayoutDirection() {
            return ILil.p028IiL.p029ILl.iIlLiL.m2134l(this.mRecyclerView);
        }

        public int getLeftDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).f5076ILil.left;
        }

        public int getMinimumHeight() {
            return ILil.p028IiL.p029ILl.iIlLiL.m2108LlLLL(this.mRecyclerView);
        }

        public int getMinimumWidth() {
            return ILil.p028IiL.p029ILl.iIlLiL.m2122lIII(this.mRecyclerView);
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ILil.p028IiL.p029ILl.iIlLiL.m2100L111(recyclerView);
            }
            return 0;
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ILil.p028IiL.p029ILl.iIlLiL.m2135LLlI1(recyclerView);
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPosition(View view) {
            return ((LayoutParams) view.getLayoutParams()).IL1Iii();
        }

        public int getRightDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).f5076ILil.right;
        }

        public int getRowCountForAccessibility(lL lLVar, C1 c1) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || recyclerView.mAdapter == null || !canScrollVertically()) {
                return 1;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public int getSelectionModeForAccessibility(lL lLVar, C1 c1) {
            return 0;
        }

        public int getTopDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).f5076ILil.top;
        }

        public void getTransformedBoundingBox(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).f5076ILil;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.mRecyclerView != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.mRecyclerView.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        public boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public void ignoreView(View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.mRecyclerView;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.exceptionLabel());
            }
            LL1IL childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.addFlags(128);
            this.mRecyclerView.mViewInfoStore.m2434llL1ii(childViewHolderInt);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.isFocused();
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        public boolean isLayoutHierarchical(lL lLVar, C1 c1) {
            return false;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public boolean isSmoothScrolling() {
            l lVar = this.mSmoothScroller;
            return lVar != null && lVar.isRunning();
        }

        public boolean isViewPartiallyVisible(View view, boolean z, boolean z2) {
            boolean z3 = this.mHorizontalBoundCheck.ILil(view, 24579) && this.mVerticalBoundCheck.ILil(view, 24579);
            return z ? z3 : !z3;
        }

        public void layoutDecorated(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f5076ILil;
            view.layout(i + rect.left, i2 + rect.top, i3 - rect.right, i4 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(View view, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.f5076ILil;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        }

        public void measureChild(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = i + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i4 = i2 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + i3, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void measureChildWithMargins(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = i + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i4 = i2 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i3, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void moveView(int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                detachViewAt(i);
                attachView(childAt, i2);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.mRecyclerView.toString());
            }
        }

        public void offsetChildrenHorizontal(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i);
            }
        }

        public void offsetChildrenVertical(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i);
            }
        }

        public void onAdapterChanged(IiL iiL, IiL iiL2) {
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        public void onDetachedFromWindow(RecyclerView recyclerView, lL lLVar) {
            onDetachedFromWindow(recyclerView);
        }

        public View onFocusSearchFailed(View view, int i, lL lLVar, C1 c1) {
            return null;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityEvent(recyclerView.mRecycler, recyclerView.mState, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(ILil.p028IiL.p029ILl.LL1IL.I1I i1i) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfo(recyclerView.mRecycler, recyclerView.mState, i1i);
        }

        public void onInitializeAccessibilityNodeInfoForItem(View view, ILil.p028IiL.p029ILl.LL1IL.I1I i1i) {
            LL1IL childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null || childViewHolderInt.isRemoved() || this.mChildHelper.m2364ILl(childViewHolderInt.itemView)) {
                return;
            }
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfoForItem(recyclerView.mRecycler, recyclerView.mState, view, i1i);
        }

        public View onInterceptFocusSearch(View view, int i) {
            return null;
        }

        public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
            onItemsUpdated(recyclerView, i, i2);
        }

        public void onLayoutChildren(lL lLVar, C1 c1) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void onLayoutCompleted(C1 c1) {
        }

        public void onMeasure(lL lLVar, C1 c1, int i, int i2) {
            this.mRecyclerView.defaultOnMeasure(i, i2);
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i) {
        }

        public void onSmoothScrollerStopped(l lVar) {
            if (this.mSmoothScroller == lVar) {
                this.mSmoothScroller = null;
            }
        }

        public boolean performAccessibilityAction(int i, Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityAction(recyclerView.mRecycler, recyclerView.mState, i, bundle);
        }

        public boolean performAccessibilityActionForItem(View view, int i, Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityActionForItem(recyclerView.mRecycler, recyclerView.mState, view, i, bundle);
        }

        public boolean performAccessibilityActionForItem(lL lLVar, C1 c1, View view, int i, Bundle bundle) {
            return false;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                ILil.p028IiL.p029ILl.iIlLiL.m74iI(recyclerView, runnable);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.m2372llL1ii(childCount);
            }
        }

        public void removeAndRecycleAllViews(lL lLVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, lLVar);
                }
            }
        }

        public void removeAndRecycleScrapInt(lL lLVar) {
            int iM3293il = lLVar.m3293il();
            for (int i = iM3293il - 1; i >= 0; i--) {
                View viewM3274ILl = lLVar.m3274ILl(i);
                LL1IL childViewHolderInt = RecyclerView.getChildViewHolderInt(viewM3274ILl);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(viewM3274ILl, false);
                    }
                    lIiI liii = this.mRecyclerView.mItemAnimator;
                    if (liii != null) {
                        liii.mo2332il(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    lLVar.m3295l(viewM3274ILl);
                }
            }
            lLVar.Ilil();
            if (iM3293il > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void removeAndRecycleView(View view, lL lLVar) {
            removeView(view);
            lLVar.m3288lIII(view);
        }

        public void removeAndRecycleViewAt(int i, lL lLVar) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            lLVar.m3288lIII(childAt);
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void removeDetachedView(View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        public void removeView(View view) {
            this.mChildHelper.LlLI1(view);
        }

        public void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                this.mChildHelper.m2372llL1ii(i);
            }
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z, false);
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        public int scrollHorizontallyBy(int i, lL lLVar, C1 c1) {
            return 0;
        }

        public void scrollToPosition(int i) {
        }

        public int scrollVerticallyBy(int i, lL lLVar, C1 c1) {
            return 0;
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z) {
            this.mAutoMeasure = z;
        }

        public void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), Videoio.CAP_OPENNI_IMAGE_GENERATOR), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), Videoio.CAP_OPENNI_IMAGE_GENERATOR));
        }

        public final void setItemPrefetchEnabled(boolean z) {
            if (z != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z;
                this.mPrefetchMaxCountObserved = 0;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.mRecycler.m3275IIi();
                }
            }
        }

        public void setMeasureSpecs(int i, int i2) {
            this.mWidth = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.mWidthMode = mode;
            if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.mHeightMode = mode2;
            if (mode2 != 0 || RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                return;
            }
            this.mHeight = 0;
        }

        public void setMeasuredDimension(Rect rect, int i, int i2) {
            setMeasuredDimension(chooseSize(i, rect.width() + getPaddingLeft() + getPaddingRight(), getMinimumWidth()), chooseSize(i2, rect.height() + getPaddingTop() + getPaddingBottom(), getMinimumHeight()));
        }

        public void setMeasuredDimensionFromChildren(int i, int i2) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i, i2);
                return;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                int i8 = rect.left;
                if (i8 < i5) {
                    i5 = i8;
                }
                int i9 = rect.right;
                if (i9 > i3) {
                    i3 = i9;
                }
                int i10 = rect.top;
                if (i10 < i6) {
                    i6 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i4) {
                    i4 = i11;
                }
            }
            this.mRecyclerView.mTempRect.set(i5, i6, i3, i4);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i, i2);
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.mMeasurementCacheEnabled = z;
        }

        public void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = Videoio.CAP_OPENNI_IMAGE_GENERATOR;
            this.mHeightMode = Videoio.CAP_OPENNI_IMAGE_GENERATOR;
        }

        public boolean shouldMeasureChild(View view, int i, int i2, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
        }

        public boolean shouldMeasureTwice() {
            return false;
        }

        public boolean shouldReMeasureChild(View view, int i, int i2, LayoutParams layoutParams) {
            return (this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, C1 c1, int i) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(l lVar) {
            l lVar2 = this.mSmoothScroller;
            if (lVar2 != null && lVar != lVar2 && lVar2.isRunning()) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = lVar;
            lVar.start(this.mRecyclerView, this);
        }

        public void stopIgnoringView(View view) {
            LL1IL childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.stopIgnoring();
            childViewHolderInt.resetInternal();
            childViewHolderInt.addFlags(4);
        }

        public void stopSmoothScroller() {
            l lVar = this.mSmoothScroller;
            if (lVar != null) {
                lVar.stop();
            }
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        public void addDisappearingView(View view, int i) {
            addViewInt(view, i, true);
        }

        public void addView(View view, int i) {
            addViewInt(view, i, false);
        }

        public void onInitializeAccessibilityEvent(lL lLVar, C1 c1, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            IiL iiL = this.mRecyclerView.mAdapter;
            if (iiL != null) {
                accessibilityEvent.setItemCount(iiL.getItemCount());
            }
        }

        public void onInitializeAccessibilityNodeInfo(lL lLVar, C1 c1, ILil.p028IiL.p029ILl.LL1IL.I1I i1i) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                i1i.IL1Iii(8192);
                i1i.m63LL(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                i1i.IL1Iii(4096);
                i1i.m63LL(true);
            }
            i1i.m2059LlLiLL(ILil.I丨iL.IL丨丨l.LL1IL.I1I.ILil.ILil(getRowCountForAccessibility(lLVar, c1), getColumnCountForAccessibility(lLVar, c1), isLayoutHierarchical(lLVar, c1), getSelectionModeForAccessibility(lLVar, c1)));
        }

        public boolean onRequestChildFocus(RecyclerView recyclerView, C1 c1, View view, View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0071 A[PHI: r8
  0x0071: PHI (r8v8 int) = (r8v4 int), (r8v12 int) binds: [B:22:0x005e, B:15:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
        public boolean performAccessibilityAction(lL lLVar, C1 c1, int i, Bundle bundle) {
            int height;
            int width;
            int i2;
            int i3;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                return false;
            }
            if (i == 4096) {
                height = recyclerView.canScrollVertically(1) ? (getHeight() - getPaddingTop()) - getPaddingBottom() : 0;
                if (this.mRecyclerView.canScrollHorizontally(1)) {
                    width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                    i2 = height;
                    i3 = width;
                } else {
                    i2 = height;
                    i3 = 0;
                }
            } else if (i != 8192) {
                i3 = 0;
                i2 = 0;
            } else {
                height = recyclerView.canScrollVertically(-1) ? -((getHeight() - getPaddingTop()) - getPaddingBottom()) : 0;
                if (this.mRecyclerView.canScrollHorizontally(-1)) {
                    width = -((getWidth() - getPaddingLeft()) - getPaddingRight());
                    i2 = height;
                    i3 = width;
                } else {
                    i2 = height;
                    i3 = 0;
                }
            }
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            this.mRecyclerView.smoothScrollBy(i3, i2, null, Integer.MIN_VALUE, true);
            return true;
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] childRectangleOnScreenScrollAmount = getChildRectangleOnScreenScrollAmount(view, rect);
            int i = childRectangleOnScreenScrollAmount[0];
            int i2 = childRectangleOnScreenScrollAmount[1];
            if ((z2 && !isFocusedChildVisibleAfterScrolling(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.smoothScrollBy(i, i2);
            }
            return true;
        }

        /* JADX WARN: Code duplicated, block: B:12:0x001c  */
        /* JADX WARN: Code duplicated, block: B:21:0x002f  */
        public static int getChildMeasureSpec(int i, int i2, int i3, int i4, boolean z) {
            int iMax = Math.max(0, i - i3);
            if (z) {
                if (i4 >= 0) {
                    i2 = Videoio.CAP_OPENNI_IMAGE_GENERATOR;
                } else if (i4 != -1 || (i2 != Integer.MIN_VALUE && (i2 == 0 || i2 != 1073741824))) {
                    i2 = 0;
                    i4 = 0;
                } else {
                    i4 = iMax;
                }
            } else if (i4 >= 0) {
                i2 = Videoio.CAP_OPENNI_IMAGE_GENERATOR;
            } else {
                if (i4 != -1) {
                    if (i4 == -2) {
                        i2 = (i2 == Integer.MIN_VALUE || i2 == 1073741824) ? Integer.MIN_VALUE : 0;
                    } else {
                        i2 = 0;
                        i4 = 0;
                    }
                }
                i4 = iMax;
            }
            return View.MeasureSpec.makeMeasureSpec(i4, i2);
        }

        public void onInitializeAccessibilityNodeInfoForItem(lL lLVar, C1 c1, View view, ILil.p028IiL.p029ILl.LL1IL.I1I i1i) {
            i1i.m62I(ILil.p028IiL.p029ILl.LL1IL.I1I.C0564I1I.IL1Iii(canScrollVertically() ? getPosition(view) : 0, 1, canScrollHorizontally() ? getPosition(view) : 0, 1, false, false));
        }

        public void attachView(View view, int i) {
            attachView(view, i, (LayoutParams) view.getLayoutParams());
        }

        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public void setMeasuredDimension(int i, int i2) {
            this.mRecyclerView.setMeasuredDimension(i, i2);
        }

        public void attachView(View view) {
            attachView(view, -1);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$Ll丨1, reason: invalid class name */
    public static class Ll1 {
        public EdgeEffect IL1Iii(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$L丨1丨1丨I, reason: invalid class name */
    public static class L11I extends Observable<AbstractC0665il> {
        public void I1I(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AbstractC0665il) ((Observable) this).mObservers.get(size)).onItemRangeMoved(i, i2, 1);
            }
        }

        public boolean IL1Iii() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void ILil() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AbstractC0665il) ((Observable) this).mObservers.get(size)).onChanged();
            }
        }

        public void Ilil(int i, int i2, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AbstractC0665il) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i, i2, obj);
            }
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public void m3259IL(int i, int i2) {
            Ilil(i, i2, null);
        }

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public void m3260iILLL1(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AbstractC0665il) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i, i2);
            }
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public void m3261lLi1LL(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AbstractC0665il) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i, i2);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$L丨lLLL, reason: invalid class name */
    public static abstract class LlLLL {
        public abstract View IL1Iii(lL lLVar, int i, int i2);
    }

    public interface iIi1 {
        void I1I(boolean z);

        void IL1Iii(RecyclerView recyclerView, MotionEvent motionEvent);

        boolean ILil(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static abstract class iIlLiL {
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$iI丨LLL1, reason: invalid class name */
    public class iILLL1 implements ILil.Lil.p037IL.IL1Iii.InterfaceC0576IL1Iii {
        public iILLL1() {
        }

        @Override // ILil.Lil.p037IL.IL1Iii.InterfaceC0576IL1Iii
        public void I1I(int i, int i2, Object obj) {
            RecyclerView.this.viewRangeUpdate(i, i2, obj);
            RecyclerView.this.mItemsChanged = true;
        }

        @Override // ILil.Lil.p037IL.IL1Iii.InterfaceC0576IL1Iii
        public void IL1Iii(int i, int i2) {
            RecyclerView.this.offsetPositionRecordsForMove(i, i2);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        @Override // ILil.Lil.p037IL.IL1Iii.InterfaceC0576IL1Iii
        public void ILil(ILil.Lil.I丨L.IL1Iii.ILil iLil) {
            m3262L11I(iLil);
        }

        @Override // ILil.Lil.p037IL.IL1Iii.InterfaceC0576IL1Iii
        public LL1IL Ilil(int i) {
            LL1IL ll1ilFindViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i, true);
            if (ll1ilFindViewHolderForPosition == null || RecyclerView.this.mChildHelper.m2364ILl(ll1ilFindViewHolderForPosition.itemView)) {
                return null;
            }
            return ll1ilFindViewHolderForPosition;
        }

        @Override // ILil.Lil.p037IL.IL1Iii.InterfaceC0576IL1Iii
        /* JADX INFO: renamed from: I丨L */
        public void mo2349IL(ILil.Lil.I丨L.IL1Iii.ILil iLil) {
            m3262L11I(iLil);
        }

        @Override // ILil.Lil.p037IL.IL1Iii.InterfaceC0576IL1Iii
        /* JADX INFO: renamed from: I丨iL */
        public void mo2350IiL(int i, int i2) {
            RecyclerView.this.offsetPositionRecordsForRemove(i, i2, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mItemsAddedOrRemoved = true;
            recyclerView.mState.f2702IL += i2;
        }

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public void m3262L11I(ILil.Lil.I丨L.IL1Iii.ILil iLil) {
            int i = iLil.f4255IL1Iii;
            if (i == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mLayout.onItemsAdded(recyclerView, iLil.f4256ILil, iLil.f1745IL);
                return;
            }
            if (i == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.mLayout.onItemsRemoved(recyclerView2, iLil.f4256ILil, iLil.f1745IL);
            } else if (i == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.mLayout.onItemsUpdated(recyclerView3, iLil.f4256ILil, iLil.f1745IL, iLil.f4254I1I);
            } else {
                if (i != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.mLayout.onItemsMoved(recyclerView4, iLil.f4256ILil, iLil.f1745IL, 1);
            }
        }

        @Override // ILil.Lil.p037IL.IL1Iii.InterfaceC0576IL1Iii
        /* JADX INFO: renamed from: iI丨LLL1 */
        public void mo2351iILLL1(int i, int i2) {
            RecyclerView.this.offsetPositionRecordsForInsert(i, i2);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        @Override // ILil.Lil.p037IL.IL1Iii.InterfaceC0576IL1Iii
        /* JADX INFO: renamed from: l丨Li1LL */
        public void mo2352lLi1LL(int i, int i2) {
            RecyclerView.this.offsetPositionRecordsForRemove(i, i2, false);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$lIi丨I, reason: invalid class name */
    public static abstract class lIiI {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public ILil f5085IL1Iii = null;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public ArrayList<IL1Iii> f5086ILil = new ArrayList<>();

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public long f5084I1I = 120;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public long f2687IL = 120;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public long f5087Ilil = 250;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public long f2688lLi1LL = 250;

        /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$lIi丨I$I1I */
        public static class I1I {

            /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
            public int f5088IL1Iii;

            /* JADX INFO: renamed from: ILil, reason: collision with root package name */
            public int f5089ILil;

            public I1I IL1Iii(LL1IL ll1il) {
                ILil(ll1il, 0);
                return this;
            }

            public I1I ILil(LL1IL ll1il, int i) {
                View view = ll1il.itemView;
                this.f5088IL1Iii = view.getLeft();
                this.f5089ILil = view.getTop();
                view.getRight();
                view.getBottom();
                return this;
            }
        }

        /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$lIi丨I$IL1Iii */
        public interface IL1Iii {
            void IL1Iii();
        }

        /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$lIi丨I$ILil */
        public interface ILil {
            void IL1Iii(LL1IL ll1il);
        }

        public static int Ilil(LL1IL ll1il) {
            int i = ll1il.mFlags & 14;
            if (ll1il.isInvalid()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int oldPosition = ll1il.getOldPosition();
            int adapterPosition = ll1il.getAdapterPosition();
            return (oldPosition == -1 || adapterPosition == -1 || oldPosition == adapterPosition) ? i : i | 2048;
        }

        public abstract void I11li1();

        public abstract boolean I1I(LL1IL ll1il, I1I i1i, I1I i1i2);

        public abstract boolean IL1Iii(LL1IL ll1il, I1I i1i, I1I i1i2);

        public abstract void ILL();

        public abstract boolean ILil(LL1IL ll1il, LL1IL ll1il2, I1I i1i, I1I i1i2);

        /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
        public long m3263ILl() {
            return this.f5087Ilil;
        }

        /* JADX INFO: renamed from: I丨L */
        public abstract boolean mo2398IL(LL1IL ll1il, I1I i1i, I1I i1i2);

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public final void m3264IiL(LL1IL ll1il) {
            m3268lIlii(ll1il);
            ILil iLil = this.f5085IL1Iii;
            if (iLil != null) {
                iLil.IL1Iii(ll1il);
            }
        }

        public long Lil() {
            return this.f2687IL;
        }

        public abstract boolean LlLI1();

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public long m3265Ll1() {
            return this.f5084I1I;
        }

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public final void m3266L11I() {
            int size = this.f5086ILil.size();
            for (int i = 0; i < size; i++) {
                this.f5086ILil.get(i).IL1Iii();
            }
            this.f5086ILil.clear();
        }

        public I1I iIi1(C1 c1, LL1IL ll1il) {
            I1I i1iM3269llL1ii = m3269llL1ii();
            i1iM3269llL1ii.IL1Iii(ll1il);
            return i1iM3269llL1ii;
        }

        public I1I iIlLiL(C1 c1, LL1IL ll1il, int i, List<Object> list) {
            I1I i1iM3269llL1ii = m3269llL1ii();
            i1iM3269llL1ii.IL1Iii(ll1il);
            return i1iM3269llL1ii;
        }

        /* JADX INFO: renamed from: iI丨LLL1 */
        public boolean mo2328iILLL1(LL1IL ll1il, List<Object> list) {
            return mo2408lLi1LL(ll1il);
        }

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public long m3267lIiI() {
            return this.f2688lLi1LL;
        }

        /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
        public void m3268lIlii(LL1IL ll1il) {
        }

        /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
        public I1I m3269llL1ii() {
            return new I1I();
        }

        /* JADX INFO: renamed from: l丨Li1LL */
        public abstract boolean mo2408lLi1LL(LL1IL ll1il);

        /* JADX INFO: renamed from: 丨il */
        public abstract void mo2332il(LL1IL ll1il);

        /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
        public void m3270lL(ILil iLil) {
            this.f5085IL1Iii = iLil;
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$lI丨II, reason: invalid class name and case insensitive filesystem */
    public class RunnableC0664lIII implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f5090I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f5091ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public Interpolator f5092Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public OverScroller f2689IL;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public boolean f2691iILLL1;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public boolean f2692lLi1LL;

        public RunnableC0664lIII() {
            Interpolator interpolator = RecyclerView.sQuinticInterpolator;
            this.f5092Ilil = interpolator;
            this.f2692lLi1LL = false;
            this.f2691iILLL1 = false;
            this.f2689IL = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        public void I1I(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.f5090I1I = 0;
            this.f5091ILil = 0;
            Interpolator interpolator = this.f5092Ilil;
            Interpolator interpolator2 = RecyclerView.sQuinticInterpolator;
            if (interpolator != interpolator2) {
                this.f5092Ilil = interpolator2;
                this.f2689IL = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.f2689IL.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            Ilil();
        }

        public final int IL1Iii(int i, int i2, int i3, int i4) {
            int iRound;
            int iAbs = Math.abs(i);
            int iAbs2 = Math.abs(i2);
            boolean z = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int iSqrt2 = (int) Math.sqrt((i * i) + (i2 * i2));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            int i5 = width / 2;
            float f = width;
            float f2 = i5;
            float fILil = f2 + (ILil(Math.min(1.0f, (iSqrt2 * 1.0f) / f)) * f2);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fILil / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, 2000);
        }

        public final float ILil(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        public void Ilil() {
            if (this.f2692lLi1LL) {
                this.f2691iILLL1 = true;
            } else {
                m3271IL();
            }
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final void m3271IL() {
            RecyclerView.this.removeCallbacks(this);
            ILil.p028IiL.p029ILl.iIlLiL.m74iI(RecyclerView.this, this);
        }

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public void m3272iILLL1() {
            RecyclerView.this.removeCallbacks(this);
            this.f2689IL.abortAnimation();
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public void m3273lLi1LL(int i, int i2, int i3, Interpolator interpolator) {
            if (i3 == Integer.MIN_VALUE) {
                i3 = IL1Iii(i, i2, 0, 0);
            }
            int i4 = i3;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.f5092Ilil != interpolator) {
                this.f5092Ilil = interpolator;
                this.f2689IL = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f5090I1I = 0;
            this.f5091ILil = 0;
            RecyclerView.this.setScrollState(2);
            this.f2689IL.startScroll(0, 0, i, i2, i4);
            if (Build.VERSION.SDK_INT < 23) {
                this.f2689IL.computeScrollOffset();
            }
            Ilil();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            int i3;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mLayout == null) {
                m3272iILLL1();
                return;
            }
            this.f2691iILLL1 = false;
            this.f2692lLi1LL = true;
            recyclerView.consumePendingUpdateOperations();
            OverScroller overScroller = this.f2689IL;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i4 = currX - this.f5091ILil;
                int i5 = currY - this.f5090I1I;
                this.f5091ILil = currX;
                this.f5090I1I = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.dispatchNestedPreScroll(i4, i5, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.mReusableIntPair;
                    i4 -= iArr2[0];
                    i5 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(i4, i5);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.mAdapter != null) {
                    int[] iArr3 = recyclerView3.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.scrollStep(i4, i5, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.mReusableIntPair;
                    i2 = iArr4[0];
                    i = iArr4[1];
                    i4 -= i2;
                    i5 -= i;
                    l lVar = recyclerView4.mLayout.mSmoothScroller;
                    if (lVar != null && !lVar.isPendingInitialRun() && lVar.isRunning()) {
                        int iILil = RecyclerView.this.mState.ILil();
                        if (iILil == 0) {
                            lVar.stop();
                        } else if (lVar.getTargetPosition() >= iILil) {
                            lVar.setTargetPosition(iILil - 1);
                            lVar.onAnimation(i2, i);
                        } else {
                            lVar.onAnimation(i2, i);
                        }
                    }
                } else {
                    i = 0;
                    i2 = 0;
                }
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.mReusableIntPair;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.dispatchNestedScroll(i2, i, i4, i5, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.mReusableIntPair;
                int i6 = i4 - iArr6[0];
                int i7 = i5 - iArr6[1];
                if (i2 != 0 || i != 0) {
                    recyclerView6.dispatchOnScrolled(i2, i);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i6 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i7 != 0));
                l lVar2 = RecyclerView.this.mLayout.mSmoothScroller;
                if ((lVar2 != null && lVar2.isPendingInitialRun()) || !z) {
                    Ilil();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    ILil.Lil.p037IL.lLi1LL lli1ll = recyclerView7.mGapWorker;
                    if (lli1ll != null) {
                        lli1ll.m2444lLi1LL(recyclerView7, i2, i);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        if (i6 < 0) {
                            i3 = -currVelocity;
                        } else {
                            i3 = i6 > 0 ? currVelocity : 0;
                        }
                        if (i7 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i7 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.absorbGlows(i3, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        RecyclerView.this.mPrefetchRegistry.ILil();
                    }
                }
            }
            l lVar3 = RecyclerView.this.mLayout.mSmoothScroller;
            if (lVar3 != null && lVar3.isPendingInitialRun()) {
                lVar3.onAnimation(0, 0);
            }
            this.f2692lLi1LL = false;
            if (this.f2691iILLL1) {
                m3271IL();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.stopNestedScroll(1);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$lI丨lii, reason: invalid class name */
    public static abstract class lIlii {
        public abstract boolean IL1Iii(int i, int i2);
    }

    public class llliI extends AbstractC0665il {
        public llliI() {
        }

        public void IL1Iii() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mHasFixedSize && recyclerView.mIsAttached) {
                    ILil.p028IiL.p029ILl.iIlLiL.m74iI(recyclerView, recyclerView.mUpdateChildViewsRunnable);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.mAdapterUpdateDuringMeasure = true;
            recyclerView2.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0665il
        public void onChanged() {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mState.f2706iILLL1 = true;
            recyclerView.processDataSetCompletelyChanged(true);
            if (RecyclerView.this.mAdapterHelper.LlLI1()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0665il
        public void onItemRangeChanged(int i, int i2, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.m2342lIlii(i, i2, obj)) {
                IL1Iii();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0665il
        public void onItemRangeInserted(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.iIi1(i, i2)) {
                IL1Iii();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0665il
        public void onItemRangeMoved(int i, int i2, int i3) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.iIlLiL(i, i2, i3)) {
                IL1Iii();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0665il
        public void onItemRangeRemoved(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.I11li1(i, i2)) {
                IL1Iii();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$ll丨L1ii, reason: invalid class name */
    public interface llL1ii {
        void IL1Iii(View view);

        void ILil(View view);
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$l丨Li1LL, reason: invalid class name */
    public class lLi1LL implements ILil.Lil.p037IL.ILil.InterfaceC0577ILil {
        public lLi1LL() {
        }

        @Override // ILil.Lil.p037IL.ILil.InterfaceC0577ILil
        public int I1I() {
            return RecyclerView.this.getChildCount();
        }

        @Override // ILil.Lil.p037IL.ILil.InterfaceC0577ILil
        public View IL1Iii(int i) {
            return RecyclerView.this.getChildAt(i);
        }

        @Override // ILil.Lil.p037IL.ILil.InterfaceC0577ILil
        public void ILL(View view, int i, ViewGroup.LayoutParams layoutParams) {
            LL1IL childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                }
                childViewHolderInt.clearTmpDetachFlag();
            }
            RecyclerView.this.attachViewToParent(view, i, layoutParams);
        }

        @Override // ILil.Lil.p037IL.ILil.InterfaceC0577ILil
        public void ILil(View view) {
            LL1IL childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
            }
        }

        @Override // ILil.Lil.p037IL.ILil.InterfaceC0577ILil
        public int Ilil(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // ILil.Lil.p037IL.ILil.InterfaceC0577ILil
        /* JADX INFO: renamed from: I丨L */
        public void mo2379IL() {
            int iI1I = I1I();
            for (int i = 0; i < iI1I; i++) {
                View viewIL1Iii = IL1Iii(i);
                RecyclerView.this.dispatchChildDetached(viewIL1Iii);
                viewIL1Iii.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // ILil.Lil.p037IL.ILil.InterfaceC0577ILil
        /* JADX INFO: renamed from: I丨iL */
        public void mo2380IiL(View view) {
            LL1IL childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onLeftHiddenState(RecyclerView.this);
            }
        }

        @Override // ILil.Lil.p037IL.ILil.InterfaceC0577ILil
        /* JADX INFO: renamed from: L丨1丨1丨I */
        public void mo2381L11I(View view, int i) {
            RecyclerView.this.addView(view, i);
            RecyclerView.this.dispatchChildAttached(view);
        }

        @Override // ILil.Lil.p037IL.ILil.InterfaceC0577ILil
        /* JADX INFO: renamed from: iI丨LLL1 */
        public void mo2382iILLL1(int i) {
            LL1IL childViewHolderInt;
            View viewIL1Iii = IL1Iii(i);
            if (viewIL1Iii != null && (childViewHolderInt = RecyclerView.getChildViewHolderInt(viewIL1Iii)) != null) {
                if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                }
                childViewHolderInt.addFlags(256);
            }
            RecyclerView.this.detachViewFromParent(i);
        }

        @Override // ILil.Lil.p037IL.ILil.InterfaceC0577ILil
        /* JADX INFO: renamed from: l丨Li1LL */
        public LL1IL mo2383lLi1LL(View view) {
            return RecyclerView.getChildViewHolderInt(view);
        }

        @Override // ILil.Lil.p037IL.ILil.InterfaceC0577ILil
        /* JADX INFO: renamed from: 丨il */
        public void mo2384il(int i) {
            View childAt = RecyclerView.this.getChildAt(i);
            if (childAt != null) {
                RecyclerView.this.dispatchChildDetached(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$丨il, reason: invalid class name and case insensitive filesystem */
    public static abstract class AbstractC0665il {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i, int i2) {
        }

        public void onItemRangeChanged(int i, int i2, Object obj) {
            onItemRangeChanged(i, i2);
        }

        public void onItemRangeInserted(int i, int i2) {
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
        }

        public void onItemRangeRemoved(int i, int i2) {
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$丨lL, reason: invalid class name */
    public final class lL {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final ArrayList<LL1IL> f5095I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final ArrayList<LL1IL> f5096IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public ArrayList<LL1IL> f5097ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int f5098Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final List<LL1IL> f2693IL;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public LlLLL f2694IiL;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public I11li1 f2696iILLL1;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public int f2697lLi1LL;

        public lL() {
            ArrayList<LL1IL> arrayList = new ArrayList<>();
            this.f5096IL1Iii = arrayList;
            this.f5097ILil = null;
            this.f5095I1I = new ArrayList<>();
            this.f2693IL = Collections.unmodifiableList(arrayList);
            this.f5098Ilil = 2;
            this.f2697lLi1LL = 2;
        }

        public void I11L(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.f5095I1I.size() - 1; size >= 0; size--) {
                LL1IL ll1il = this.f5095I1I.get(size);
                if (ll1il != null) {
                    int i4 = ll1il.mPosition;
                    if (i4 >= i3) {
                        ll1il.offsetPosition(-i2, z);
                    } else if (i4 >= i) {
                        ll1il.addFlags(8);
                        m3283LlLLL(size);
                    }
                }
            }
        }

        public void I11li1(int i, int i2) {
            int size = this.f5095I1I.size();
            for (int i3 = 0; i3 < size; i3++) {
                LL1IL ll1il = this.f5095I1I.get(i3);
                if (ll1il != null && ll1il.mPosition >= i) {
                    ll1il.offsetPosition(i2, true);
                }
            }
        }

        public void I1I() {
            this.f5096IL1Iii.clear();
            m32971();
        }

        public void IL1Iii(LL1IL ll1il, boolean z) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(ll1il);
            View view = ll1il.itemView;
            ILil.Lil.p037IL.lIiI liii = RecyclerView.this.mAccessibilityDelegate;
            if (liii != null) {
                ILil.p028IiL.p029ILl.IL1Iii itemDelegate = liii.getItemDelegate();
                ILil.p028IiL.p029ILl.iIlLiL.m75lL(view, itemDelegate instanceof ILil.Lil.p037IL.lIiI.IL1Iii ? ((ILil.Lil.p037IL.lIiI.IL1Iii) itemDelegate).IL1Iii(view) : null);
            }
            if (z) {
                m3284iILLL1(ll1il);
            }
            ll1il.mOwnerRecyclerView = null;
            m3282L11I().m3254L11I(ll1il);
        }

        public List<LL1IL> ILL() {
            return this.f2693IL;
        }

        public final void ILil(LL1IL ll1il) {
            if (RecyclerView.this.isAccessibilityEnabled()) {
                View view = ll1il.itemView;
                if (ILil.p028IiL.p029ILl.iIlLiL.I11L(view) == 0) {
                    ILil.p028IiL.p029ILl.iIlLiL.m72LL(view, 1);
                }
                ILil.Lil.p037IL.lIiI liii = RecyclerView.this.mAccessibilityDelegate;
                if (liii == null) {
                    return;
                }
                ILil.p028IiL.p029ILl.IL1Iii itemDelegate = liii.getItemDelegate();
                if (itemDelegate instanceof ILil.Lil.p037IL.lIiI.IL1Iii) {
                    ((ILil.Lil.p037IL.lIiI.IL1Iii) itemDelegate).ILil(view);
                }
                ILil.p028IiL.p029ILl.iIlLiL.m75lL(view, itemDelegate);
            }
        }

        /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
        public View m3274ILl(int i) {
            return this.f5096IL1Iii.get(i).itemView;
        }

        public void Ilil() {
            this.f5096IL1Iii.clear();
            ArrayList<LL1IL> arrayList = this.f5097ILil;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
        public void m3275IIi() {
            LlLI1 llLI1 = RecyclerView.this.mLayout;
            this.f2697lLi1LL = this.f5098Ilil + (llLI1 != null ? llLI1.mPrefetchMaxCountObserved : 0);
            for (int size = this.f5095I1I.size() - 1; size >= 0 && this.f5095I1I.size() > this.f2697lLi1LL; size--) {
                m3283LlLLL(size);
            }
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public void m3276IL() {
            int size = this.f5095I1I.size();
            for (int i = 0; i < size; i++) {
                this.f5095I1I.get(i).clearOldPosition();
            }
            int size2 = this.f5096IL1Iii.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.f5096IL1Iii.get(i2).clearOldPosition();
            }
            ArrayList<LL1IL> arrayList = this.f5097ILil;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.f5097ILil.get(i3).clearOldPosition();
                }
            }
        }

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public LL1IL m3277IiL(int i) {
            int size;
            int iM2341lIiI;
            ArrayList<LL1IL> arrayList = this.f5097ILil;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    LL1IL ll1il = this.f5097ILil.get(i2);
                    if (!ll1il.wasReturnedFromScrap() && ll1il.getLayoutPosition() == i) {
                        ll1il.addFlags(32);
                        return ll1il;
                    }
                }
                if (RecyclerView.this.mAdapter.hasStableIds() && (iM2341lIiI = RecyclerView.this.mAdapterHelper.m2341lIiI(i)) > 0 && iM2341lIiI < RecyclerView.this.mAdapter.getItemCount()) {
                    long itemId = RecyclerView.this.mAdapter.getItemId(iM2341lIiI);
                    for (int i3 = 0; i3 < size; i3++) {
                        LL1IL ll1il2 = this.f5097ILil.get(i3);
                        if (!ll1il2.wasReturnedFromScrap() && ll1il2.getItemId() == itemId) {
                            ll1il2.addFlags(32);
                            return ll1il2;
                        }
                    }
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
        public void m3278L111(View view) {
            LL1IL childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.f5097ILil == null) {
                    this.f5097ILil = new ArrayList<>();
                }
                childViewHolderInt.setScrapContainer(this, true);
                this.f5097ILil.add(childViewHolderInt);
                return;
            }
            if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || RecyclerView.this.mAdapter.hasStableIds()) {
                childViewHolderInt.setScrapContainer(this, false);
                this.f5096IL1Iii.add(childViewHolderInt);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.exceptionLabel());
            }
        }

        /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
        public boolean m3279LIll(LL1IL ll1il) {
            if (ll1il.isRemoved()) {
                return RecyclerView.this.mState.Ilil();
            }
            int i = ll1il.mPosition;
            if (i >= 0 && i < RecyclerView.this.mAdapter.getItemCount()) {
                if (RecyclerView.this.mState.Ilil() || RecyclerView.this.mAdapter.getItemViewType(ll1il.mPosition) == ll1il.getItemViewType()) {
                    return !RecyclerView.this.mAdapter.hasStableIds() || ll1il.getItemId() == RecyclerView.this.mAdapter.getItemId(ll1il.mPosition);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + ll1il + RecyclerView.this.exceptionLabel());
        }

        public void LL1IL(LL1IL ll1il) {
            boolean z;
            boolean z2 = false;
            boolean z3 = true;
            if (ll1il.isScrap() || ll1il.itemView.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(ll1il.isScrap());
                sb.append(" isAttached:");
                sb.append(ll1il.itemView.getParent() != null);
                sb.append(RecyclerView.this.exceptionLabel());
                throw new IllegalArgumentException(sb.toString());
            }
            if (ll1il.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + ll1il + RecyclerView.this.exceptionLabel());
            }
            if (ll1il.shouldIgnore()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.exceptionLabel());
            }
            boolean zDoesTransientStatePreventRecycling = ll1il.doesTransientStatePreventRecycling();
            IiL iiL = RecyclerView.this.mAdapter;
            if ((iiL != null && zDoesTransientStatePreventRecycling && iiL.onFailedToRecycleView(ll1il)) || ll1il.isRecyclable()) {
                if (this.f2697lLi1LL <= 0 || ll1il.hasAnyOfTheFlags(526)) {
                    z = false;
                } else {
                    int size = this.f5095I1I.size();
                    if (size >= this.f2697lLi1LL && size > 0) {
                        m3283LlLLL(0);
                        size--;
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.m2446IL(ll1il.mPosition)) {
                        int i = size - 1;
                        while (i >= 0) {
                            if (!RecyclerView.this.mPrefetchRegistry.m2446IL(this.f5095I1I.get(i).mPosition)) {
                                break;
                            } else {
                                i--;
                            }
                        }
                        size = i + 1;
                    }
                    this.f5095I1I.add(size, ll1il);
                    z = true;
                }
                if (z) {
                    z2 = z;
                    z3 = false;
                } else {
                    IL1Iii(ll1il, true);
                    z2 = z;
                }
            } else {
                z3 = false;
            }
            RecyclerView.this.mViewInfoStore.m2434llL1ii(ll1il);
            if (z2 || z3 || !zDoesTransientStatePreventRecycling) {
                return;
            }
            ll1il.mOwnerRecyclerView = null;
        }

        public View Lil(int i) {
            return LlLI1(i, false);
        }

        public View LlLI1(int i, boolean z) {
            return m3281L1l(i, z, RecyclerView.FOREVER_NS).itemView;
        }

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public LL1IL m3280Ll1(long j, int i, boolean z) {
            for (int size = this.f5096IL1Iii.size() - 1; size >= 0; size--) {
                LL1IL ll1il = this.f5096IL1Iii.get(size);
                if (ll1il.getItemId() == j && !ll1il.wasReturnedFromScrap()) {
                    if (i == ll1il.getItemViewType()) {
                        ll1il.addFlags(32);
                        if (ll1il.isRemoved() && !RecyclerView.this.mState.Ilil()) {
                            ll1il.setFlags(2, 14);
                        }
                        return ll1il;
                    }
                    if (!z) {
                        this.f5096IL1Iii.remove(size);
                        RecyclerView.this.removeDetachedView(ll1il.itemView, false);
                        m3295l(ll1il.itemView);
                    }
                }
            }
            int size2 = this.f5095I1I.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                LL1IL ll1il2 = this.f5095I1I.get(size2);
                if (ll1il2.getItemId() == j && !ll1il2.isAttachedToTransitionOverlay()) {
                    if (i == ll1il2.getItemViewType()) {
                        if (!z) {
                            this.f5095I1I.remove(size2);
                        }
                        return ll1il2;
                    }
                    if (!z) {
                        m3283LlLLL(size2);
                        return null;
                    }
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:100:0x020c  */
        /* JADX WARN: Code duplicated, block: B:102:0x0214  */
        /* JADX WARN: Code duplicated, block: B:103:0x0222  */
        /* JADX WARN: Code duplicated, block: B:106:0x0228 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:108:0x022b  */
        /* JADX WARN: Code duplicated, block: B:18:0x0037 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:19:0x0039  */
        /* JADX WARN: Code duplicated, block: B:21:0x0043  */
        /* JADX WARN: Code duplicated, block: B:22:0x004e  */
        /* JADX WARN: Code duplicated, block: B:24:0x0054  */
        /* JADX WARN: Code duplicated, block: B:27:0x005c  */
        /* JADX WARN: Code duplicated, block: B:29:0x005f  */
        /* JADX WARN: Code duplicated, block: B:73:0x0181 A[PHI: r1 r4
  0x0181: PHI (r1v12 androidx.recyclerview.widget.RecyclerView$LL1IL) = (r1v11 androidx.recyclerview.widget.RecyclerView$LL1IL), (r1v31 androidx.recyclerview.widget.RecyclerView$LL1IL) binds: [B:28:0x005d, B:59:0x0102] A[DONT_GENERATE, DONT_INLINE]
  0x0181: PHI (r4v3 boolean) = (r4v2 boolean), (r4v7 boolean) binds: [B:28:0x005d, B:59:0x0102] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:82:0x01a2  */
        /* JADX WARN: Code duplicated, block: B:88:0x01ce  */
        /* JADX WARN: Code duplicated, block: B:90:0x01d4  */
        /* JADX WARN: Code duplicated, block: B:99:0x01fe  */
        /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
        public LL1IL m3281L1l(int i, boolean z, long j) {
            LL1IL childViewHolder;
            boolean z2;
            LL1IL ll1il;
            boolean z3;
            ViewGroup.LayoutParams layoutParams;
            LayoutParams layoutParams2;
            int iM2341lIiI;
            RecyclerView recyclerViewFindNestedRecyclerView;
            LlLLL llLLL;
            View viewIL1Iii;
            if (i < 0 || i >= RecyclerView.this.mState.ILil()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + RecyclerView.this.mState.ILil() + RecyclerView.this.exceptionLabel());
            }
            if (RecyclerView.this.mState.Ilil()) {
                childViewHolder = m3277IiL(i);
                z2 = childViewHolder != null;
                if (childViewHolder == null && (childViewHolder = m3287lIiI(i, z)) != null) {
                    if (m3279LIll(childViewHolder)) {
                        z2 = true;
                    } else {
                        if (!z) {
                            childViewHolder.addFlags(4);
                            if (childViewHolder.isScrap()) {
                                RecyclerView.this.removeDetachedView(childViewHolder.itemView, false);
                                childViewHolder.unScrap();
                            } else if (childViewHolder.wasReturnedFromScrap()) {
                                childViewHolder.clearReturnedFromScrapFlag();
                            }
                            LL1IL(childViewHolder);
                        }
                        childViewHolder = null;
                    }
                }
                if (childViewHolder == null) {
                    ll1il = childViewHolder;
                } else {
                    iM2341lIiI = RecyclerView.this.mAdapterHelper.m2341lIiI(i);
                    if (iM2341lIiI >= 0 || iM2341lIiI >= RecyclerView.this.mAdapter.getItemCount()) {
                        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + iM2341lIiI + ").state:" + RecyclerView.this.mState.ILil() + RecyclerView.this.exceptionLabel());
                    }
                    int itemViewType = RecyclerView.this.mAdapter.getItemViewType(iM2341lIiI);
                    if (RecyclerView.this.mAdapter.hasStableIds() && (childViewHolder = m3280Ll1(RecyclerView.this.mAdapter.getItemId(iM2341lIiI), itemViewType, z)) != null) {
                        childViewHolder.mPosition = iM2341lIiI;
                        z2 = true;
                    }
                    if (childViewHolder == null && (llLLL = this.f2694IiL) != null && (viewIL1Iii = llLLL.IL1Iii(this, i, itemViewType)) != null) {
                        childViewHolder = RecyclerView.this.getChildViewHolder(viewIL1Iii);
                        if (childViewHolder == null) {
                            throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder" + RecyclerView.this.exceptionLabel());
                        }
                        if (childViewHolder.shouldIgnore()) {
                            throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view." + RecyclerView.this.exceptionLabel());
                        }
                    }
                    if (childViewHolder == null) {
                        LL1IL ll1ilM3256lLi1LL = m3282L11I().m3256lLi1LL(itemViewType);
                        if (ll1ilM3256lLi1LL != null) {
                            ll1ilM3256lLi1LL.resetInternal();
                            if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST) {
                                m3289lIlii(ll1ilM3256lLi1LL);
                            }
                        }
                        childViewHolder = ll1ilM3256lLi1LL;
                    }
                    if (childViewHolder == null) {
                        long nanoTime = RecyclerView.this.getNanoTime();
                        if (j != RecyclerView.FOREVER_NS && !this.f2696iILLL1.m3253Ll1(itemViewType, nanoTime, j)) {
                            return null;
                        }
                        RecyclerView recyclerView = RecyclerView.this;
                        LL1IL ll1ilCreateViewHolder = recyclerView.mAdapter.createViewHolder(recyclerView, itemViewType);
                        if (RecyclerView.ALLOW_THREAD_GAP_WORK && (recyclerViewFindNestedRecyclerView = RecyclerView.findNestedRecyclerView(ll1ilCreateViewHolder.itemView)) != null) {
                            ll1ilCreateViewHolder.mNestedRecyclerView = new WeakReference<>(recyclerViewFindNestedRecyclerView);
                        }
                        this.f2696iILLL1.Ilil(itemViewType, RecyclerView.this.getNanoTime() - nanoTime);
                        ll1il = ll1ilCreateViewHolder;
                    } else {
                        ll1il = childViewHolder;
                    }
                }
                z3 = z2;
                if (z3 && !RecyclerView.this.mState.Ilil() && ll1il.hasAnyOfTheFlags(8192)) {
                    ll1il.setFlags(0, 8192);
                    if (RecyclerView.this.mState.ILL) {
                        int iIlil = lIiI.Ilil(ll1il) | 4096;
                        RecyclerView recyclerView2 = RecyclerView.this;
                        RecyclerView.this.recordAnimationInfoIfBouncedHiddenView(ll1il, recyclerView2.mItemAnimator.iIlLiL(recyclerView2.mState, ll1il, iIlil, ll1il.getUnmodifiedPayloads()));
                    }
                }
                if (RecyclerView.this.mState.Ilil() || !ll1il.isBound()) {
                    boolean zM3286l1IIi1 = (ll1il.isBound() || ll1il.needsUpdate() || ll1il.isInvalid()) ? m3286l1IIi1(ll1il, RecyclerView.this.mAdapterHelper.m2341lIiI(i), i, j) : false;
                    layoutParams = ll1il.itemView.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams2 = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                        ll1il.itemView.setLayoutParams(layoutParams2);
                    } else if (RecyclerView.this.checkLayoutParams(layoutParams)) {
                        layoutParams2 = (LayoutParams) layoutParams;
                    } else {
                        layoutParams2 = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams);
                        ll1il.itemView.setLayoutParams(layoutParams2);
                    }
                    layoutParams2.f5075IL1Iii = ll1il;
                    layoutParams2.f2685IL = !z3 && zM3286l1IIi1;
                    return ll1il;
                }
                ll1il.mPreLayoutPosition = i;
                layoutParams = ll1il.itemView.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams2 = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                    ll1il.itemView.setLayoutParams(layoutParams2);
                } else if (RecyclerView.this.checkLayoutParams(layoutParams)) {
                    layoutParams2 = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams);
                    ll1il.itemView.setLayoutParams(layoutParams2);
                } else {
                    layoutParams2 = (LayoutParams) layoutParams;
                }
                layoutParams2.f5075IL1Iii = ll1il;
                layoutParams2.f2685IL = !z3 && zM3286l1IIi1;
                return ll1il;
            }
            childViewHolder = null;
            if (childViewHolder == null) {
                if (m3279LIll(childViewHolder)) {
                    if (!z) {
                        childViewHolder.addFlags(4);
                        if (childViewHolder.isScrap()) {
                            RecyclerView.this.removeDetachedView(childViewHolder.itemView, false);
                            childViewHolder.unScrap();
                        } else if (childViewHolder.wasReturnedFromScrap()) {
                            childViewHolder.clearReturnedFromScrapFlag();
                        }
                        LL1IL(childViewHolder);
                    }
                    childViewHolder = null;
                } else {
                    z2 = true;
                }
            }
            if (childViewHolder == null) {
                iM2341lIiI = RecyclerView.this.mAdapterHelper.m2341lIiI(i);
                if (iM2341lIiI >= 0) {
                }
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + iM2341lIiI + ").state:" + RecyclerView.this.mState.ILil() + RecyclerView.this.exceptionLabel());
            }
            ll1il = childViewHolder;
            z3 = z2;
            if (z3) {
                ll1il.setFlags(0, 8192);
                if (RecyclerView.this.mState.ILL) {
                    int iIlil2 = lIiI.Ilil(ll1il) | 4096;
                    RecyclerView recyclerView3 = RecyclerView.this;
                    RecyclerView.this.recordAnimationInfoIfBouncedHiddenView(ll1il, recyclerView3.mItemAnimator.iIlLiL(recyclerView3.mState, ll1il, iIlil2, ll1il.getUnmodifiedPayloads()));
                }
            }
            if (RecyclerView.this.mState.Ilil()) {
                if (ll1il.isBound()) {
                }
            } else {
                if (ll1il.isBound()) {
                }
            }
            layoutParams = ll1il.itemView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams2 = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                ll1il.itemView.setLayoutParams(layoutParams2);
            } else if (RecyclerView.this.checkLayoutParams(layoutParams)) {
                layoutParams2 = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams);
                ll1il.itemView.setLayoutParams(layoutParams2);
            } else {
                layoutParams2 = (LayoutParams) layoutParams;
            }
            layoutParams2.f5075IL1Iii = ll1il;
            layoutParams2.f2685IL = !z3 && zM3286l1IIi1;
            return ll1il;
        }

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public I11li1 m3282L11I() {
            if (this.f2696iILLL1 == null) {
                this.f2696iILLL1 = new I11li1();
            }
            return this.f2696iILLL1;
        }

        /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
        public void m3283LlLLL(int i) {
            IL1Iii(this.f5095I1I.get(i), true);
            this.f5095I1I.remove(i);
        }

        public void iIi1() {
            int size = this.f5095I1I.size();
            for (int i = 0; i < size; i++) {
                LayoutParams layoutParams = (LayoutParams) this.f5095I1I.get(i).itemView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.f5074I1I = true;
                }
            }
        }

        public void iIlLiL() {
            int size = this.f5095I1I.size();
            for (int i = 0; i < size; i++) {
                LL1IL ll1il = this.f5095I1I.get(i);
                if (ll1il != null) {
                    ll1il.addFlags(6);
                    ll1il.addChangePayload(null);
                }
            }
            IiL iiL = RecyclerView.this.mAdapter;
            if (iiL == null || !iiL.hasStableIds()) {
                m32971();
            }
        }

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public void m3284iILLL1(LL1IL ll1il) {
            I11L i11l = RecyclerView.this.mRecyclerListener;
            if (i11l != null) {
                i11l.IL1Iii(ll1il);
            }
            IiL iiL = RecyclerView.this.mAdapter;
            if (iiL != null) {
                iiL.onViewRecycled(ll1il);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mState != null) {
                recyclerView.mViewInfoStore.m2434llL1ii(ll1il);
            }
        }

        /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
        public void m3285ill(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.f5095I1I.size() - 1; size >= 0; size--) {
                LL1IL ll1il = this.f5095I1I.get(size);
                if (ll1il != null && (i3 = ll1il.mPosition) >= i && i3 < i4) {
                    ll1il.addFlags(2);
                    m3283LlLLL(size);
                }
            }
        }

        /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
        public final boolean m3286l1IIi1(LL1IL ll1il, int i, int i2, long j) {
            ll1il.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = ll1il.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != RecyclerView.FOREVER_NS && !this.f2696iILLL1.ILL(itemViewType, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.mAdapter.bindViewHolder(ll1il, i);
            this.f2696iILLL1.m3251IL(ll1il.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            ILil(ll1il);
            if (!RecyclerView.this.mState.Ilil()) {
                return true;
            }
            ll1il.mPreLayoutPosition = i2;
            return true;
        }

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public LL1IL m3287lIiI(int i, boolean z) {
            View viewIlil;
            int size = this.f5096IL1Iii.size();
            for (int i2 = 0; i2 < size; i2++) {
                LL1IL ll1il = this.f5096IL1Iii.get(i2);
                if (!ll1il.wasReturnedFromScrap() && ll1il.getLayoutPosition() == i && !ll1il.isInvalid() && (RecyclerView.this.mState.f2703IiL || !ll1il.isRemoved())) {
                    ll1il.addFlags(32);
                    return ll1il;
                }
            }
            if (z || (viewIlil = RecyclerView.this.mChildHelper.Ilil(i)) == null) {
                int size2 = this.f5095I1I.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    LL1IL ll1il2 = this.f5095I1I.get(i3);
                    if (!ll1il2.isInvalid() && ll1il2.getLayoutPosition() == i && !ll1il2.isAttachedToTransitionOverlay()) {
                        if (!z) {
                            this.f5095I1I.remove(i3);
                        }
                        return ll1il2;
                    }
                }
                return null;
            }
            LL1IL childViewHolderInt = RecyclerView.getChildViewHolderInt(viewIlil);
            RecyclerView.this.mChildHelper.iIi1(viewIlil);
            int iM2370lIiI = RecyclerView.this.mChildHelper.m2370lIiI(viewIlil);
            if (iM2370lIiI != -1) {
                RecyclerView.this.mChildHelper.m2365IL(iM2370lIiI);
                m3278L111(viewIlil);
                childViewHolderInt.addFlags(8224);
                return childViewHolderInt;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt + RecyclerView.this.exceptionLabel());
        }

        /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
        public void m3288lIII(View view) {
            LL1IL childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            LL1IL(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator == null || childViewHolderInt.isRecyclable()) {
                return;
            }
            RecyclerView.this.mItemAnimator.mo2332il(childViewHolderInt);
        }

        /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
        public final void m3289lIlii(LL1IL ll1il) {
            View view = ll1il.itemView;
            if (view instanceof ViewGroup) {
                m3290llL1ii((ViewGroup) view, false);
            }
        }

        public void llI(int i) {
            this.f5098Ilil = i;
            m3275IIi();
        }

        public void llliI(IiL iiL, IiL iiL2, boolean z) {
            I1I();
            m3282L11I().m3252IiL(iiL, iiL2, z);
        }

        /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
        public final void m3290llL1ii(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    m3290llL1ii((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public int m3291lLi1LL(int i) {
            if (i >= 0 && i < RecyclerView.this.mState.ILil()) {
                return !RecyclerView.this.mState.Ilil() ? i : RecyclerView.this.mAdapterHelper.m2341lIiI(i);
            }
            throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.mState.ILil() + RecyclerView.this.exceptionLabel());
        }

        /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
        public void m3292iILLl(LL1IL ll1il) {
            if (ll1il.mInChangeScrap) {
                this.f5097ILil.remove(ll1il);
            } else {
                this.f5096IL1Iii.remove(ll1il);
            }
            ll1il.mScrapContainer = null;
            ll1il.mInChangeScrap = false;
            ll1il.clearReturnedFromScrapFlag();
        }

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public int m3293il() {
            return this.f5096IL1Iii.size();
        }

        /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
        public void m3294lL(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            if (i < i2) {
                i3 = -1;
                i5 = i;
                i4 = i2;
            } else {
                i3 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = this.f5095I1I.size();
            for (int i7 = 0; i7 < size; i7++) {
                LL1IL ll1il = this.f5095I1I.get(i7);
                if (ll1il != null && (i6 = ll1il.mPosition) >= i5 && i6 <= i4) {
                    if (i6 == i) {
                        ll1il.offsetPosition(i2 - i, false);
                    } else {
                        ll1il.offsetPosition(i3, false);
                    }
                }
            }
        }

        /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
        public void m3295l(View view) {
            LL1IL childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = false;
            childViewHolderInt.clearReturnedFromScrapFlag();
            LL1IL(childViewHolderInt);
        }

        /* JADX INFO: renamed from: 丨丨 */
        public void m121(LlLLL llLLL) {
        }

        /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
        public void m3296LLlI1(I11li1 i11li1) {
            I11li1 i11li2 = this.f2696iILLL1;
            if (i11li2 != null) {
                i11li2.I1I();
            }
            this.f2696iILLL1 = i11li1;
            if (i11li1 == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.f2696iILLL1.IL1Iii();
        }

        /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
        public void m32971() {
            for (int size = this.f5095I1I.size() - 1; size >= 0; size--) {
                m3283LlLLL(size);
            }
            this.f5095I1I.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                RecyclerView.this.mPrefetchRegistry.ILil();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$丨l丨, reason: invalid class name */
    public static abstract class l {
        private LlLI1 mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private boolean mRunning;
        private boolean mStarted;
        private View mTargetView;
        private int mTargetPosition = -1;
        private final IL1Iii mRecyclingAction = new IL1Iii(0, 0);

        /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$丨l丨$IL1Iii */
        public static class IL1Iii {

            /* JADX INFO: renamed from: I1I, reason: collision with root package name */
            public int f5099I1I;

            /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
            public int f5100IL1Iii;

            /* JADX INFO: renamed from: ILil, reason: collision with root package name */
            public int f5101ILil;

            /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
            public Interpolator f5102Ilil;

            /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
            public int f2698IL;

            /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
            public int f2699iILLL1;

            /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
            public boolean f2700lLi1LL;

            public IL1Iii(int i, int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }

            public void I1I(RecyclerView recyclerView) {
                int i = this.f2698IL;
                if (i >= 0) {
                    this.f2698IL = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i);
                    this.f2700lLi1LL = false;
                } else {
                    if (!this.f2700lLi1LL) {
                        this.f2699iILLL1 = 0;
                        return;
                    }
                    Ilil();
                    recyclerView.mViewFlinger.m3273lLi1LL(this.f5100IL1Iii, this.f5101ILil, this.f5099I1I, this.f5102Ilil);
                    int i2 = this.f2699iILLL1 + 1;
                    this.f2699iILLL1 = i2;
                    if (i2 > 10) {
                        Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f2700lLi1LL = false;
                }
            }

            public boolean IL1Iii() {
                return this.f2698IL >= 0;
            }

            public void ILil(int i) {
                this.f2698IL = i;
            }

            public final void Ilil() {
                if (this.f5102Ilil != null && this.f5099I1I < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f5099I1I < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
            public void m3298IL(int i, int i2, int i3, Interpolator interpolator) {
                this.f5100IL1Iii = i;
                this.f5101ILil = i2;
                this.f5099I1I = i3;
                this.f5102Ilil = interpolator;
                this.f2700lLi1LL = true;
            }

            public IL1Iii(int i, int i2, int i3, Interpolator interpolator) {
                this.f2698IL = -1;
                this.f2700lLi1LL = false;
                this.f2699iILLL1 = 0;
                this.f5100IL1Iii = i;
                this.f5101ILil = i2;
                this.f5099I1I = i3;
                this.f5102Ilil = interpolator;
            }
        }

        /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$丨l丨$ILil */
        public interface ILil {
            PointF computeScrollVectorForPosition(int i);
        }

        public PointF computeScrollVectorForPosition(int i) {
            Object layoutManager = getLayoutManager();
            if (layoutManager instanceof ILil) {
                return ((ILil) layoutManager).computeScrollVectorForPosition(i);
            }
            Log.w(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + ILil.class.getCanonicalName());
            return null;
        }

        public View findViewByPosition(int i) {
            return this.mRecyclerView.mLayout.findViewByPosition(i);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public int getChildPosition(View view) {
            return this.mRecyclerView.getChildLayoutPosition(view);
        }

        public LlLI1 getLayoutManager() {
            return this.mLayoutManager;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        @Deprecated
        public void instantScrollToPosition(int i) {
            this.mRecyclerView.scrollToPosition(i);
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public void normalize(PointF pointF) {
            float f = pointF.x;
            float f2 = pointF.y;
            float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }

        public void onAnimation(int i, int i2) {
            PointF pointFComputeScrollVectorForPosition;
            RecyclerView recyclerView = this.mRecyclerView;
            if (this.mTargetPosition == -1 || recyclerView == null) {
                stop();
            }
            if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null && (pointFComputeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) != null) {
                float f = pointFComputeScrollVectorForPosition.x;
                if (f != 0.0f || pointFComputeScrollVectorForPosition.y != 0.0f) {
                    recyclerView.scrollStep((int) Math.signum(f), (int) Math.signum(pointFComputeScrollVectorForPosition.y), null);
                }
            }
            this.mPendingInitialRun = false;
            View view = this.mTargetView;
            if (view != null) {
                if (getChildPosition(view) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                    this.mRecyclingAction.I1I(recyclerView);
                    stop();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(i, i2, recyclerView.mState, this.mRecyclingAction);
                boolean zIL1Iii = this.mRecyclingAction.IL1Iii();
                this.mRecyclingAction.I1I(recyclerView);
                if (zIL1Iii && this.mRunning) {
                    this.mPendingInitialRun = true;
                    recyclerView.mViewFlinger.Ilil();
                }
            }
        }

        public void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
            }
        }

        public abstract void onSeekTargetStep(int i, int i2, C1 c1, IL1Iii iL1Iii);

        public abstract void onStart();

        public abstract void onStop();

        public abstract void onTargetFound(View view, C1 c1, IL1Iii iL1Iii);

        public void setTargetPosition(int i) {
            this.mTargetPosition = i;
        }

        public void start(RecyclerView recyclerView, LlLI1 llLI1) {
            recyclerView.mViewFlinger.m3272iILLL1();
            if (this.mStarted) {
                Log.w(RecyclerView.TAG, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.mRecyclerView = recyclerView;
            this.mLayoutManager = llLI1;
            int i = this.mTargetPosition;
            if (i == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.mState.f5104IL1Iii = i;
            this.mRunning = true;
            this.mPendingInitialRun = true;
            this.mTargetView = findViewByPosition(getTargetPosition());
            onStart();
            this.mRecyclerView.mViewFlinger.Ilil();
            this.mStarted = true;
        }

        public final void stop() {
            if (this.mRunning) {
                this.mRunning = false;
                onStop();
                this.mRecyclerView.mState.f5104IL1Iii = -1;
                this.mTargetView = null;
                this.mTargetPosition = -1;
                this.mPendingInitialRun = false;
                this.mLayoutManager.onSmoothScrollerStopped(this);
                this.mLayoutManager = null;
                this.mRecyclerView = null;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$丨丨丨1丨, reason: invalid class name */
    public static class C1 {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public SparseArray<Object> f5105ILil;

        /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
        public long f2701ILl;
        public int Lil;
        public int LlLI1;

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public int f2707lIiI;

        /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
        public int f2708llL1ii;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public int f5104IL1Iii = -1;

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f5103I1I = 0;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int f2702IL = 0;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int f5106Ilil = 1;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public int f2709lLi1LL = 0;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public boolean f2706iILLL1 = false;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public boolean f2703IiL = false;

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public boolean f2705L11I = false;

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public boolean f2710il = false;
        public boolean ILL = false;

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public boolean f2704Ll1 = false;

        public int I1I() {
            return this.f5104IL1Iii;
        }

        public void IL1Iii(int i) {
            if ((this.f5106Ilil & i) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f5106Ilil));
        }

        public int ILil() {
            return this.f2703IiL ? this.f5103I1I - this.f2702IL : this.f2709lLi1LL;
        }

        public boolean Ilil() {
            return this.f2703IiL;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public boolean m3299IL() {
            return this.f5104IL1Iii != -1;
        }

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public boolean m3300iILLL1() {
            return this.f2704Ll1;
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public void m3301lLi1LL(IiL iiL) {
            this.f5106Ilil = 1;
            this.f2709lLi1LL = iiL.getItemCount();
            this.f2703IiL = false;
            this.f2705L11I = false;
            this.f2710il = false;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f5104IL1Iii + ", mData=" + this.f5105ILil + ", mItemCount=" + this.f2709lLi1LL + ", mIsMeasuring=" + this.f2710il + ", mPreviousLayoutItemCount=" + this.f5103I1I + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f2702IL + ", mStructureChanged=" + this.f2706iILLL1 + ", mInPreLayout=" + this.f2703IiL + ", mRunSimpleAnimations=" + this.ILL + ", mRunPredictiveAnimations=" + this.f2704Ll1 + '}';
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        FORCE_INVALIDATE_DISPLAY_LIST = i == 18 || i == 19 || i == 20;
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = i >= 23;
        POST_UPDATES_ON_ANIMATION = i >= 16;
        ALLOW_THREAD_GAP_WORK = i >= 21;
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = i <= 15;
        IGNORE_DETACHED_FOCUSED_CHILD = i <= 15;
        Class<?> cls = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, cls, cls};
        sQuinticInterpolator = new I1I();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    private void addAnimatingView(LL1IL ll1il) {
        View view = ll1il.itemView;
        boolean z = view.getParent() == this;
        this.mRecycler.m3292iILLl(getChildViewHolder(view));
        if (ll1il.isTmpDetached()) {
            this.mChildHelper.I1I(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            this.mChildHelper.ILL(view);
        } else {
            this.mChildHelper.ILil(view, true);
        }
    }

    private void animateChange(LL1IL ll1il, LL1IL ll1il2, lIiI.I1I i1i, lIiI.I1I i1i2, boolean z, boolean z2) {
        ll1il.setIsRecyclable(false);
        if (z) {
            addAnimatingView(ll1il);
        }
        if (ll1il != ll1il2) {
            if (z2) {
                addAnimatingView(ll1il2);
            }
            ll1il.mShadowedHolder = ll1il2;
            addAnimatingView(ll1il);
            this.mRecycler.m3292iILLl(ll1il);
            ll1il2.setIsRecyclable(false);
            ll1il2.mShadowingHolder = ll1il;
        }
        if (this.mItemAnimator.ILil(ll1il, ll1il2, i1i, i1i2)) {
            postAnimationRunner();
        }
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    public static void clearNestedRecyclerViewIfNotNested(LL1IL ll1il) {
        WeakReference<RecyclerView> weakReference = ll1il.mNestedRecyclerView;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == ll1il.itemView) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            ll1il.mNestedRecyclerView = null;
        }
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        Constructor constructor;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String fullClassName = getFullClassName(context, strTrim);
            try {
                Class<? extends U> clsAsSubclass = Class.forName(fullClassName, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(LlLI1.class);
                Object[] objArr = null;
                try {
                    constructor = clsAsSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                } catch (NoSuchMethodException e) {
                    try {
                        constructor = clsAsSubclass.getConstructor(new Class[0]);
                    } catch (NoSuchMethodException e2) {
                        e2.initCause(e);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e2);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((LlLI1) constructor.newInstance(objArr));
            } catch (ClassCastException e3) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e3);
            } catch (ClassNotFoundException e4) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e4);
            } catch (IllegalAccessException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e5);
            } catch (InstantiationException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e6);
            } catch (InvocationTargetException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e7);
            }
        }
    }

    private boolean didChildRangeChange(int i, int i2) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        return (iArr[0] == i && iArr[1] == i2) ? false : true;
    }

    private void dispatchContentChangedIfNecessary() {
        int i = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i == 0 || !isAccessibilityEnabled()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        ILil.p028IiL.p029ILl.LL1IL.ILil.ILil(accessibilityEventObtain, i);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    private void dispatchLayoutStep1() {
        this.mState.IL1Iii(1);
        fillRemainingScrollValues(this.mState);
        this.mState.f2710il = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.m2435lLi1LL();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        C1 c1 = this.mState;
        c1.f2705L11I = c1.ILL && this.mItemsChanged;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        c1.f2703IiL = c1.f2704Ll1;
        c1.f2709lLi1LL = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.ILL) {
            int iM2369iILLL1 = this.mChildHelper.m2369iILLL1();
            for (int i = 0; i < iM2369iILLL1; i++) {
                LL1IL childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2373lLi1LL(i));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    this.mViewInfoStore.Ilil(childViewHolderInt, this.mItemAnimator.iIlLiL(this.mState, childViewHolderInt, lIiI.Ilil(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                    if (this.mState.f2705L11I && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.I1I(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.f2704Ll1) {
            saveOldPositions();
            C1 c2 = this.mState;
            boolean z = c2.f2706iILLL1;
            c2.f2706iILLL1 = false;
            this.mLayout.onLayoutChildren(this.mRecycler, c2);
            this.mState.f2706iILLL1 = z;
            for (int i2 = 0; i2 < this.mChildHelper.m2369iILLL1(); i2++) {
                LL1IL childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.m2373lLi1LL(i2));
                if (!childViewHolderInt2.shouldIgnore() && !this.mViewInfoStore.m2431L11I(childViewHolderInt2)) {
                    int iIlil = lIiI.Ilil(childViewHolderInt2);
                    boolean zHasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                    if (!zHasAnyOfTheFlags) {
                        iIlil |= 4096;
                    }
                    lIiI.I1I i1iIIlLiL = this.mItemAnimator.iIlLiL(this.mState, childViewHolderInt2, iIlil, childViewHolderInt2.getUnmodifiedPayloads());
                    if (zHasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, i1iIIlLiL);
                    } else {
                        this.mViewInfoStore.IL1Iii(childViewHolderInt2, i1iIIlLiL);
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.f5106Ilil = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.IL1Iii(6);
        this.mAdapterHelper.m2345il();
        this.mState.f2709lLi1LL = this.mAdapter.getItemCount();
        C1 c1 = this.mState;
        c1.f2702IL = 0;
        c1.f2703IiL = false;
        this.mLayout.onLayoutChildren(this.mRecycler, c1);
        C1 c2 = this.mState;
        c2.f2706iILLL1 = false;
        this.mPendingSavedState = null;
        c2.ILL = c2.ILL && this.mItemAnimator != null;
        c2.f5106Ilil = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        this.mState.IL1Iii(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        C1 c1 = this.mState;
        c1.f5106Ilil = 1;
        if (c1.ILL) {
            for (int iM2369iILLL1 = this.mChildHelper.m2369iILLL1() - 1; iM2369iILLL1 >= 0; iM2369iILLL1--) {
                LL1IL childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2373lLi1LL(iM2369iILLL1));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    lIiI.I1I i1iIIi1 = this.mItemAnimator.iIi1(this.mState, childViewHolderInt);
                    LL1IL ll1ilM2432iILLL1 = this.mViewInfoStore.m2432iILLL1(changedHolderKey);
                    if (ll1ilM2432iILLL1 == null || ll1ilM2432iILLL1.shouldIgnore()) {
                        this.mViewInfoStore.m2428IL(childViewHolderInt, i1iIIi1);
                    } else {
                        boolean zM2429IiL = this.mViewInfoStore.m2429IiL(ll1ilM2432iILLL1);
                        boolean zM2429IiL2 = this.mViewInfoStore.m2429IiL(childViewHolderInt);
                        if (zM2429IiL && ll1ilM2432iILLL1 == childViewHolderInt) {
                            this.mViewInfoStore.m2428IL(childViewHolderInt, i1iIIi1);
                        } else {
                            lIiI.I1I i1iM2427ILl = this.mViewInfoStore.m2427ILl(ll1ilM2432iILLL1);
                            this.mViewInfoStore.m2428IL(childViewHolderInt, i1iIIi1);
                            lIiI.I1I i1iM2433lIiI = this.mViewInfoStore.m2433lIiI(childViewHolderInt);
                            if (i1iM2427ILl == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, ll1ilM2432iILLL1);
                            } else {
                                animateChange(ll1ilM2432iILLL1, childViewHolderInt, i1iM2427ILl, i1iM2433lIiI, zM2429IiL, zM2429IiL2);
                            }
                        }
                    }
                }
            }
            this.mViewInfoStore.Lil(this.mViewInfoProcessCallback);
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        C1 c2 = this.mState;
        c2.f5103I1I = c2.f2709lLi1LL;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        c2.ILL = false;
        c2.f2704Ll1 = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        ArrayList<LL1IL> arrayList = this.mRecycler.f5097ILil;
        if (arrayList != null) {
            arrayList.clear();
        }
        LlLI1 llLI1 = this.mLayout;
        if (llLI1.mPrefetchMaxObservedInInitialPrefetch) {
            llLI1.mPrefetchMaxCountObserved = 0;
            llLI1.mPrefetchMaxObservedInInitialPrefetch = false;
            this.mRecycler.m3275IIi();
        }
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.m2435lLi1LL();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        iIi1 iii1 = this.mInterceptingOnItemTouchListener;
        if (iii1 == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return findInterceptingOnItemTouchListener(motionEvent);
        }
        iii1.IL1Iii(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mInterceptingOnItemTouchListener = null;
        }
        return true;
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        for (int i = 0; i < size; i++) {
            iIi1 iii1 = this.mOnItemTouchListeners.get(i);
            if (iii1.ILil(this, motionEvent) && action != 3) {
                this.mInterceptingOnItemTouchListener = iii1;
                return true;
            }
        }
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int iM2369iILLL1 = this.mChildHelper.m2369iILLL1();
        if (iM2369iILLL1 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < iM2369iILLL1; i3++) {
            LL1IL childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2373lLi1LL(i3));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i) {
                    i = layoutPosition;
                }
                if (layoutPosition > i2) {
                    i2 = layoutPosition;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    public static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView recyclerViewFindNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i));
            if (recyclerViewFindNestedRecyclerView != null) {
                return recyclerViewFindNestedRecyclerView;
            }
        }
        return null;
    }

    private View findNextViewToFocus() {
        LL1IL ll1ilFindViewHolderForAdapterPosition;
        C1 c1 = this.mState;
        int i = c1.f2707lIiI;
        if (i == -1) {
            i = 0;
        }
        int iILil = c1.ILil();
        for (int i2 = i; i2 < iILil; i2++) {
            LL1IL ll1ilFindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i2);
            if (ll1ilFindViewHolderForAdapterPosition2 == null) {
                break;
            }
            if (ll1ilFindViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return ll1ilFindViewHolderForAdapterPosition2.itemView;
            }
        }
        int iMin = Math.min(iILil, i);
        do {
            iMin--;
            if (iMin < 0 || (ll1ilFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(iMin)) == null) {
                return null;
            }
        } while (!ll1ilFindViewHolderForAdapterPosition.itemView.hasFocusable());
        return ll1ilFindViewHolderForAdapterPosition.itemView;
    }

    public static LL1IL getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f5075IL1Iii;
    }

    public static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.f5076ILil;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    private ILil.p028IiL.p029ILl.ILL getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new ILil.p028IiL.p029ILl.ILL(this);
        }
        return this.mScrollingChildHelper;
    }

    private void handleMissingPreInfoForChangeError(long j, LL1IL ll1il, LL1IL ll1il2) {
        int iM2369iILLL1 = this.mChildHelper.m2369iILLL1();
        for (int i = 0; i < iM2369iILLL1; i++) {
            LL1IL childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2373lLi1LL(i));
            if (childViewHolderInt != ll1il && getChangedHolderKey(childViewHolderInt) == j) {
                IiL iiL = this.mAdapter;
                if (iiL == null || !iiL.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + ll1il + exceptionLabel());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + ll1il + exceptionLabel());
            }
        }
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + ll1il2 + " cannot be found but it is necessary for " + ll1il + exceptionLabel());
    }

    private boolean hasUpdatedView() {
        int iM2369iILLL1 = this.mChildHelper.m2369iILLL1();
        for (int i = 0; i < iM2369iILLL1; i++) {
            LL1IL childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2373lLi1LL(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        if (ILil.p028IiL.p029ILl.iIlLiL.llliI(this) == 0) {
            ILil.p028IiL.p029ILl.iIlLiL.m2117i1I1I1l(this, 8);
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new ILil.Lil.p037IL.ILil(new lLi1LL());
    }

    private boolean isPreferredNextFocus(View view, View view2, int i) {
        int i2;
        if (view2 == null || view2 == this || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        byte b = -1;
        int i3 = this.mLayout.getLayoutDirection() == 1 ? -1 : 1;
        Rect rect = this.mTempRect;
        int i4 = rect.left;
        Rect rect2 = this.mTempRect2;
        int i5 = rect2.left;
        if ((i4 < i5 || rect.right <= i5) && rect.right < rect2.right) {
            i2 = 1;
        } else {
            int i6 = rect.right;
            int i7 = rect2.right;
            i2 = ((i6 > i7 || i4 >= i7) && i4 > i5) ? -1 : 0;
        }
        int i8 = rect.top;
        int i9 = rect2.top;
        if ((i8 < i9 || rect.bottom <= i9) && rect.bottom < rect2.bottom) {
            b = 1;
        } else {
            int i10 = rect.bottom;
            int i11 = rect2.bottom;
            if ((i10 <= i11 && i8 < i11) || i8 <= i9) {
                b = 0;
            }
        }
        if (i == 1) {
            return b < 0 || (b == 0 && i2 * i3 <= 0);
        }
        if (i == 2) {
            return b > 0 || (b == 0 && i2 * i3 >= 0);
        }
        if (i == 17) {
            return i2 < 0;
        }
        if (i == 33) {
            return b < 0;
        }
        if (i == 66) {
            return i2 > 0;
        }
        if (i == 130) {
            return b > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i + exceptionLabel());
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z;
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.m2347l();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.I11L();
        } else {
            this.mAdapterHelper.m2345il();
        }
        boolean z2 = false;
        boolean z3 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.ILL = this.mFirstLayoutComplete && this.mItemAnimator != null && ((z = this.mDataSetHasChangedAfterLayout) || z3 || this.mLayout.mRequestedSimpleAnimations) && (!z || this.mAdapter.hasStableIds());
        C1 c1 = this.mState;
        if (c1.ILL && z3 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
            z2 = true;
        }
        c1.f2704Ll1 = z2;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0040  */
    /* JADX WARN: Code duplicated, block: B:13:0x0056  */
    /* JADX WARN: Code duplicated, block: B:15:0x005a  */
    /* JADX WARN: Code duplicated, block: B:16:0x0071  */
    private void pullGlows(float f, float f2, float f3, float f4) {
        boolean z;
        boolean z2 = true;
        if (f2 >= 0.0f) {
            if (f2 > 0.0f) {
                ensureRightGlow();
                ILil.p028IiL.Lil.IL.IL1Iii(this.mRightGlow, f2 / getWidth(), f3 / getHeight());
            } else {
                z = false;
            }
            if (f4 < 0.0f) {
                ensureTopGlow();
                ILil.p028IiL.Lil.IL.IL1Iii(this.mTopGlow, (-f4) / getHeight(), f / getWidth());
            } else if (f4 > 0.0f) {
                ensureBottomGlow();
                ILil.p028IiL.Lil.IL.IL1Iii(this.mBottomGlow, f4 / getHeight(), 1.0f - (f / getWidth()));
            } else {
                z2 = z;
            }
            if (z2 && f2 == 0.0f && f4 == 0.0f) {
                return;
            }
            ILil.p028IiL.p029ILl.iIlLiL.m2101LIl(this);
        }
        ensureLeftGlow();
        ILil.p028IiL.Lil.IL.IL1Iii(this.mLeftGlow, (-f2) / getWidth(), 1.0f - (f3 / getHeight()));
        z = true;
        if (f4 < 0.0f) {
            ensureTopGlow();
            ILil.p028IiL.Lil.IL.IL1Iii(this.mTopGlow, (-f4) / getHeight(), f / getWidth());
        } else if (f4 > 0.0f) {
            ensureBottomGlow();
            ILil.p028IiL.Lil.IL.IL1Iii(this.mBottomGlow, f4 / getHeight(), 1.0f - (f / getWidth()));
        } else {
            z2 = z;
        }
        if (z2) {
        }
        ILil.p028IiL.p029ILl.iIlLiL.m2101LIl(this);
    }

    private void recoverFocusFromState() {
        View viewFindViewById;
        if (!this.mPreserveFocusAfterLayout || this.mAdapter == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!IGNORE_DETACHED_FOCUSED_CHILD || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.mChildHelper.m2364ILl(focusedChild)) {
                    return;
                }
            } else if (this.mChildHelper.m2369iILLL1() == 0) {
                requestFocus();
                return;
            }
        }
        View viewFindNextViewToFocus = null;
        LL1IL ll1ilFindViewHolderForItemId = (this.mState.f2701ILl == -1 || !this.mAdapter.hasStableIds()) ? null : findViewHolderForItemId(this.mState.f2701ILl);
        if (ll1ilFindViewHolderForItemId != null && !this.mChildHelper.m2364ILl(ll1ilFindViewHolderForItemId.itemView) && ll1ilFindViewHolderForItemId.itemView.hasFocusable()) {
            viewFindNextViewToFocus = ll1ilFindViewHolderForItemId.itemView;
        } else if (this.mChildHelper.m2369iILLL1() > 0) {
            viewFindNextViewToFocus = findNextViewToFocus();
        }
        if (viewFindNextViewToFocus != null) {
            int i = this.mState.Lil;
            if (i != -1 && (viewFindViewById = viewFindNextViewToFocus.findViewById(i)) != null && viewFindViewById.isFocusable()) {
                viewFindNextViewToFocus = viewFindViewById;
            }
            viewFindNextViewToFocus.requestFocus();
        }
    }

    private void releaseGlows() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            ILil.p028IiL.p029ILl.iIlLiL.m2101LIl(this);
        }
    }

    private void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.f5074I1I) {
                Rect rect = layoutParams2.f5076ILil;
                Rect rect2 = this.mTempRect;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.requestChildRectangleOnScreen(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    private void resetFocusInfo() {
        C1 c1 = this.mState;
        c1.f2701ILl = -1L;
        c1.f2707lIiI = -1;
        c1.Lil = -1;
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void saveFocusInfo() {
        int adapterPosition;
        View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) ? getFocusedChild() : null;
        LL1IL ll1ilFindContainingViewHolder = focusedChild != null ? findContainingViewHolder(focusedChild) : null;
        if (ll1ilFindContainingViewHolder == null) {
            resetFocusInfo();
            return;
        }
        this.mState.f2701ILl = this.mAdapter.hasStableIds() ? ll1ilFindContainingViewHolder.getItemId() : -1L;
        C1 c1 = this.mState;
        if (this.mDataSetHasChangedAfterLayout) {
            adapterPosition = -1;
        } else {
            adapterPosition = ll1ilFindContainingViewHolder.isRemoved() ? ll1ilFindContainingViewHolder.mOldPosition : ll1ilFindContainingViewHolder.getAdapterPosition();
        }
        c1.f2707lIiI = adapterPosition;
        this.mState.Lil = getDeepestFocusedViewWithId(ll1ilFindContainingViewHolder.itemView);
    }

    private void setAdapterInternal(IiL iiL, boolean z, boolean z2) {
        IiL iiL2 = this.mAdapter;
        if (iiL2 != null) {
            iiL2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.m2347l();
        IiL iiL3 = this.mAdapter;
        this.mAdapter = iiL;
        if (iiL != null) {
            iiL.registerAdapterDataObserver(this.mObserver);
            iiL.onAttachedToRecyclerView(this);
        }
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 != null) {
            llLI1.onAdapterChanged(iiL3, this.mAdapter);
        }
        this.mRecycler.llliI(iiL3, this.mAdapter, z);
        this.mState.f2706iILLL1 = true;
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.m3272iILLL1();
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 != null) {
            llLI1.stopSmoothScroller();
        }
    }

    public void absorbGlows(int i, int i2) {
        if (i < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i);
            }
        } else if (i > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i);
            }
        }
        if (i2 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i2);
            }
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        ILil.p028IiL.p029ILl.iIlLiL.m2101LIl(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 == null || !llLI1.onAddFocusables(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    public void addItemDecoration(Lil lil, int i) {
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 != null) {
            llLI1.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.mItemDecorations.add(lil);
        } else {
            this.mItemDecorations.add(i, lil);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(llL1ii lll1ii) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(lll1ii);
    }

    public void addOnItemTouchListener(iIi1 iii1) {
        this.mOnItemTouchListeners.add(iii1);
    }

    public void addOnScrollListener(iIlLiL iillil) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(iillil);
    }

    public void animateAppearance(LL1IL ll1il, lIiI.I1I i1i, lIiI.I1I i1i2) {
        ll1il.setIsRecyclable(false);
        if (this.mItemAnimator.IL1Iii(ll1il, i1i, i1i2)) {
            postAnimationRunner();
        }
    }

    public void animateDisappearance(LL1IL ll1il, lIiI.I1I i1i, lIiI.I1I i1i2) {
        addAnimatingView(ll1il);
        ll1il.setIsRecyclable(false);
        if (this.mItemAnimator.I1I(ll1il, i1i, i1i2)) {
            postAnimationRunner();
        }
    }

    public void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
        }
        throw new IllegalStateException(str + exceptionLabel());
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
        }
        if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(BuildConfig.FLAVOR + exceptionLabel()));
        }
    }

    public boolean canReuseUpdatedViewHolder(LL1IL ll1il) {
        lIiI liii = this.mItemAnimator;
        return liii == null || liii.mo2328iILLL1(ll1il, ll1il.getUnmodifiedPayloads());
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.mLayout.checkLayoutParams((LayoutParams) layoutParams);
    }

    public void clearOldPositions() {
        int iM2374il = this.mChildHelper.m2374il();
        for (int i = 0; i < iM2374il; i++) {
            LL1IL childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2368L11I(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        this.mRecycler.m3276IL();
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<llL1ii> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<iIlLiL> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 != null && llLI1.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 != null && llLI1.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 != null && llLI1.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 != null && llLI1.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 != null && llLI1.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 != null && llLI1.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return 0;
    }

    public void considerReleasingGlowsOnScroll(int i, int i2) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            zIsFinished = false;
        } else {
            this.mLeftGlow.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.mRightGlow.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.mTopGlow.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.mBottomGlow.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            ILil.p028IiL.p029ILl.iIlLiL.m2101LIl(this);
        }
    }

    public void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            ILil.p028IiL.p036il.IL1Iii.IL1Iii(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            ILil.p028IiL.p036il.IL1Iii.ILil();
            return;
        }
        if (this.mAdapterHelper.LlLI1()) {
            if (!this.mAdapterHelper.Lil(4) || this.mAdapterHelper.Lil(11)) {
                if (this.mAdapterHelper.LlLI1()) {
                    ILil.p028IiL.p036il.IL1Iii.IL1Iii(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                    dispatchLayout();
                    ILil.p028IiL.p036il.IL1Iii.ILil();
                    return;
                }
                return;
            }
            ILil.p028IiL.p036il.IL1Iii.IL1Iii(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            this.mAdapterHelper.I11L();
            if (!this.mLayoutWasDefered) {
                if (hasUpdatedView()) {
                    dispatchLayout();
                } else {
                    this.mAdapterHelper.m2339L11I();
                }
            }
            stopInterceptRequestLayout(true);
            onExitLayoutOrScroll();
            ILil.p028IiL.p036il.IL1Iii.ILil();
        }
    }

    public void defaultOnMeasure(int i, int i2) {
        setMeasuredDimension(LlLI1.chooseSize(i, getPaddingLeft() + getPaddingRight(), ILil.p028IiL.p029ILl.iIlLiL.m2122lIII(this)), LlLI1.chooseSize(i2, getPaddingTop() + getPaddingBottom(), ILil.p028IiL.p029ILl.iIlLiL.m2108LlLLL(this)));
    }

    public void dispatchChildAttached(View view) {
        LL1IL childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        IiL iiL = this.mAdapter;
        if (iiL != null && childViewHolderInt != null) {
            iiL.onViewAttachedToWindow(childViewHolderInt);
        }
        List<llL1ii> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).ILil(view);
            }
        }
    }

    public void dispatchChildDetached(View view) {
        LL1IL childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        IiL iiL = this.mAdapter;
        if (iiL != null && childViewHolderInt != null) {
            iiL.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<llL1ii> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).IL1Iii(view);
            }
        }
    }

    public void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.e(TAG, "No adapter attached; skipping layout");
            return;
        }
        if (this.mLayout == null) {
            Log.e(TAG, "No layout manager attached; skipping layout");
            return;
        }
        C1 c1 = this.mState;
        c1.f2710il = false;
        if (c1.f5106Ilil == 1) {
            dispatchLayoutStep1();
            this.mLayout.setExactMeasureSpecsFrom(this);
            dispatchLayoutStep2();
        } else if (!this.mAdapterHelper.m2343llL1ii() && this.mLayout.getWidth() == getWidth() && this.mLayout.getHeight() == getHeight()) {
            this.mLayout.setExactMeasureSpecsFrom(this);
        } else {
            this.mLayout.setExactMeasureSpecsFrom(this);
            dispatchLayoutStep2();
        }
        dispatchLayoutStep3();
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().IL1Iii(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().ILil(f, f2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().I1I(i, i2, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().m2035lLi1LL(i, i2, i3, i4, iArr);
    }

    public void dispatchOnScrollStateChanged(int i) {
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 != null) {
            llLI1.onScrollStateChanged(i);
        }
        onScrollStateChanged(i);
        iIlLiL iillil = this.mScrollListener;
        if (iillil != null) {
            iillil.onScrollStateChanged(this, i);
        }
        List<iIlLiL> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i);
            }
        }
    }

    public void dispatchOnScrolled(int i, int i2) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i, scrollY - i2);
        onScrolled(i, i2);
        iIlLiL iillil = this.mScrollListener;
        if (iillil != null) {
            iillil.onScrolled(this, i, i2);
        }
        List<iIlLiL> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i, i2);
            }
        }
        this.mDispatchScrollCounter--;
    }

    public void dispatchPendingImportantForAccessibilityChanges() {
        int i;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            LL1IL ll1il = this.mPendingAccessibilityImportanceChange.get(size);
            if (ll1il.itemView.getParent() == this && !ll1il.shouldIgnore() && (i = ll1il.mPendingAccessibilityState) != -1) {
                ILil.p028IiL.p029ILl.iIlLiL.m72LL(ll1il.itemView, i);
                ll1il.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            this.mItemDecorations.get(i).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(iSave4);
        }
        if ((z || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.LlLI1()) ? z : true) {
            ILil.p028IiL.p029ILl.iIlLiL.m2101LIl(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public void ensureBottomGlow() {
        if (this.mBottomGlow != null) {
            return;
        }
        EdgeEffect edgeEffectIL1Iii = this.mEdgeEffectFactory.IL1Iii(this, 3);
        this.mBottomGlow = edgeEffectIL1Iii;
        if (this.mClipToPadding) {
            edgeEffectIL1Iii.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectIL1Iii.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void ensureLeftGlow() {
        if (this.mLeftGlow != null) {
            return;
        }
        EdgeEffect edgeEffectIL1Iii = this.mEdgeEffectFactory.IL1Iii(this, 0);
        this.mLeftGlow = edgeEffectIL1Iii;
        if (this.mClipToPadding) {
            edgeEffectIL1Iii.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectIL1Iii.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void ensureRightGlow() {
        if (this.mRightGlow != null) {
            return;
        }
        EdgeEffect edgeEffectIL1Iii = this.mEdgeEffectFactory.IL1Iii(this, 2);
        this.mRightGlow = edgeEffectIL1Iii;
        if (this.mClipToPadding) {
            edgeEffectIL1Iii.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectIL1Iii.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void ensureTopGlow() {
        if (this.mTopGlow != null) {
            return;
        }
        EdgeEffect edgeEffectIL1Iii = this.mEdgeEffectFactory.IL1Iii(this, 1);
        this.mTopGlow = edgeEffectIL1Iii;
        if (this.mClipToPadding) {
            edgeEffectIL1Iii.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectIL1Iii.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    public final void fillRemainingScrollValues(C1 c1) {
        if (getScrollState() != 2) {
            c1.LlLI1 = 0;
            c1.f2708llL1ii = 0;
        } else {
            OverScroller overScroller = this.mViewFlinger.f2689IL;
            c1.LlLI1 = overScroller.getFinalX() - overScroller.getCurrX();
            c1.f2708llL1ii = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    public View findChildViewUnder(float f, float f2) {
        for (int iM2369iILLL1 = this.mChildHelper.m2369iILLL1() - 1; iM2369iILLL1 >= 0; iM2369iILLL1--) {
            View viewM2373lLi1LL = this.mChildHelper.m2373lLi1LL(iM2369iILLL1);
            float translationX = viewM2373lLi1LL.getTranslationX();
            float translationY = viewM2373lLi1LL.getTranslationY();
            if (f >= viewM2373lLi1LL.getLeft() + translationX && f <= viewM2373lLi1LL.getRight() + translationX && f2 >= viewM2373lLi1LL.getTop() + translationY && f2 <= viewM2373lLi1LL.getBottom() + translationY) {
                return viewM2373lLi1LL;
            }
        }
        return null;
    }

    public View findContainingItemView(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public LL1IL findContainingViewHolder(View view) {
        View viewFindContainingItemView = findContainingItemView(view);
        if (viewFindContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(viewFindContainingItemView);
    }

    public LL1IL findViewHolderForAdapterPosition(int i) {
        LL1IL ll1il = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int iM2374il = this.mChildHelper.m2374il();
        for (int i2 = 0; i2 < iM2374il; i2++) {
            LL1IL childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2368L11I(i2));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionFor(childViewHolderInt) == i) {
                if (!this.mChildHelper.m2364ILl(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                ll1il = childViewHolderInt;
            }
        }
        return ll1il;
    }

    public LL1IL findViewHolderForItemId(long j) {
        IiL iiL = this.mAdapter;
        LL1IL ll1il = null;
        if (iiL != null && iiL.hasStableIds()) {
            int iM2374il = this.mChildHelper.m2374il();
            for (int i = 0; i < iM2374il; i++) {
                LL1IL childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2368L11I(i));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j) {
                    if (!this.mChildHelper.m2364ILl(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    ll1il = childViewHolderInt;
                }
            }
        }
        return ll1il;
    }

    public LL1IL findViewHolderForLayoutPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    @Deprecated
    public LL1IL findViewHolderForPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    public boolean fling(int i, int i2) {
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 == null) {
            Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.mLayoutSuppressed) {
            return false;
        }
        boolean zCanScrollHorizontally = llLI1.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (!zCanScrollHorizontally || Math.abs(i) < this.mMinFlingVelocity) {
            i = 0;
        }
        if (!zCanScrollVertically || Math.abs(i2) < this.mMinFlingVelocity) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return false;
        }
        float f = i;
        float f2 = i2;
        if (!dispatchNestedPreFling(f, f2)) {
            boolean z = zCanScrollHorizontally || zCanScrollVertically;
            dispatchNestedFling(f, f2, z);
            lIlii lilii = this.mOnFlingListener;
            if (lilii != null && lilii.IL1Iii(i, i2)) {
                return true;
            }
            if (z) {
                int i3 = zCanScrollHorizontally ? 1 : 0;
                if (zCanScrollVertically) {
                    i3 |= 2;
                }
                startNestedScroll(i3, 1);
                int i4 = this.mMaxFlingVelocity;
                int iMax = Math.max(-i4, Math.min(i, i4));
                int i5 = this.mMaxFlingVelocity;
                this.mViewFlinger.I1I(iMax, Math.max(-i5, Math.min(i2, i5)));
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i) {
        View viewOnFocusSearchFailed;
        boolean z;
        View viewOnInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i);
        if (viewOnInterceptFocusSearch != null) {
            return viewOnInterceptFocusSearch;
        }
        boolean z2 = (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutSuppressed) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z2 && (i == 2 || i == 1)) {
            if (this.mLayout.canScrollVertically()) {
                int i2 = i == 2 ? 130 : 33;
                z = focusFinder.findNextFocus(this, view, i2) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i2;
                }
            } else {
                z = false;
            }
            if (!z && this.mLayout.canScrollHorizontally()) {
                int i3 = (this.mLayout.getLayoutDirection() == 1) ^ (i == 2) ? 66 : 17;
                boolean z3 = focusFinder.findNextFocus(this, view, i3) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i3;
                }
                z = z3;
            }
            if (z) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view, i, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            viewOnFocusSearchFailed = focusFinder.findNextFocus(this, view, i);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i);
            if (viewFindNextFocus == null && z2) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                viewOnFocusSearchFailed = this.mLayout.onFocusSearchFailed(view, i, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            } else {
                viewOnFocusSearchFailed = viewFindNextFocus;
            }
        }
        if (viewOnFocusSearchFailed == null || viewOnFocusSearchFailed.hasFocusable()) {
            return isPreferredNextFocus(view, viewOnFocusSearchFailed, i) ? viewOnFocusSearchFailed : super.focusSearch(view, i);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i);
        }
        requestChildOnScreen(viewOnFocusSearchFailed, null);
        return view;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 != null) {
            return llLI1.generateDefaultLayoutParams();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 != null) {
            return llLI1.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public IiL getAdapter() {
        return this.mAdapter;
    }

    public int getAdapterPositionFor(LL1IL ll1il) {
        if (ll1il.hasAnyOfTheFlags(524) || !ll1il.isBound()) {
            return -1;
        }
        return this.mAdapterHelper.Ilil(ll1il.mPosition);
    }

    @Override // android.view.View
    public int getBaseline() {
        LlLI1 llLI1 = this.mLayout;
        return llLI1 != null ? llLI1.getBaseline() : super.getBaseline();
    }

    public long getChangedHolderKey(LL1IL ll1il) {
        return this.mAdapter.hasStableIds() ? ll1il.getItemId() : ll1il.mPosition;
    }

    public int getChildAdapterPosition(View view) {
        LL1IL childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAdapterPosition();
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        ILL ill = this.mChildDrawingOrderCallback;
        return ill == null ? super.getChildDrawingOrder(i, i2) : ill.IL1Iii(i, i2);
    }

    public long getChildItemId(View view) {
        LL1IL childViewHolderInt;
        IiL iiL = this.mAdapter;
        if (iiL == null || !iiL.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1L;
        }
        return childViewHolderInt.getItemId();
    }

    public int getChildLayoutPosition(View view) {
        LL1IL childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public LL1IL getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public ILil.Lil.p037IL.lIiI getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    public Ll1 getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public lIiI getItemAnimator() {
        return this.mItemAnimator;
    }

    public Rect getItemDecorInsetsForChild(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f5074I1I) {
            return layoutParams.f5076ILil;
        }
        if (this.mState.Ilil() && (layoutParams.ILil() || layoutParams.m3258IL())) {
            return layoutParams.f5076ILil;
        }
        Rect rect = layoutParams.f5076ILil;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i).getItemOffsets(this.mTempRect, view, this, this.mState);
            int i2 = rect.left;
            Rect rect2 = this.mTempRect;
            rect.left = i2 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.f5074I1I = false;
        return rect;
    }

    public Lil getItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i >= 0 && i < itemDecorationCount) {
            return this.mItemDecorations.get(i);
        }
        throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public LlLI1 getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0L;
    }

    public lIlii getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public I11li1 getRecycledViewPool() {
        return this.mRecycler.m3282L11I();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().ILL();
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.LlLI1();
    }

    public void initAdapterManager() {
        this.mAdapterHelper = new ILil.Lil.p037IL.IL1Iii(new iILLL1());
    }

    public void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new ILil.Lil.p037IL.IL(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(ILil.Lil.ILil.fastscroll_default_thickness), resources.getDimensionPixelSize(ILil.Lil.ILil.fastscroll_minimum_range), resources.getDimensionPixelOffset(ILil.Lil.ILil.fastscroll_margin));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
        }
    }

    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() == 0) {
            return;
        }
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 != null) {
            llLI1.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean isAnimating() {
        lIiI liii = this.mItemAnimator;
        return liii != null && liii.LlLI1();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Override // android.view.View, ILil.p028IiL.p029ILl.InterfaceC0634il
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m2032lIiI();
    }

    public void jumpToPositionForSmoothScroller(int i) {
        if (this.mLayout == null) {
            return;
        }
        setScrollState(2);
        this.mLayout.scrollToPosition(i);
        awakenScrollBars();
    }

    public void markItemDecorInsetsDirty() {
        int iM2374il = this.mChildHelper.m2374il();
        for (int i = 0; i < iM2374il; i++) {
            ((LayoutParams) this.mChildHelper.m2368L11I(i).getLayoutParams()).f5074I1I = true;
        }
        this.mRecycler.iIi1();
    }

    public void markKnownViewsInvalid() {
        int iM2374il = this.mChildHelper.m2374il();
        for (int i = 0; i < iM2374il; i++) {
            LL1IL childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2368L11I(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.iIlLiL();
    }

    public void offsetChildrenHorizontal(int i) {
        int iM2369iILLL1 = this.mChildHelper.m2369iILLL1();
        for (int i2 = 0; i2 < iM2369iILLL1; i2++) {
            this.mChildHelper.m2373lLi1LL(i2).offsetLeftAndRight(i);
        }
    }

    public void offsetChildrenVertical(int i) {
        int iM2369iILLL1 = this.mChildHelper.m2369iILLL1();
        for (int i2 = 0; i2 < iM2369iILLL1; i2++) {
            this.mChildHelper.m2373lLi1LL(i2).offsetTopAndBottom(i);
        }
    }

    public void offsetPositionRecordsForInsert(int i, int i2) {
        int iM2374il = this.mChildHelper.m2374il();
        for (int i3 = 0; i3 < iM2374il; i3++) {
            LL1IL childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2368L11I(i3));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i) {
                childViewHolderInt.offsetPosition(i2, false);
                this.mState.f2706iILLL1 = true;
            }
        }
        this.mRecycler.I11li1(i, i2);
        requestLayout();
    }

    public void offsetPositionRecordsForMove(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int iM2374il = this.mChildHelper.m2374il();
        if (i < i2) {
            i5 = -1;
            i4 = i;
            i3 = i2;
        } else {
            i3 = i;
            i4 = i2;
            i5 = 1;
        }
        for (int i7 = 0; i7 < iM2374il; i7++) {
            LL1IL childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2368L11I(i7));
            if (childViewHolderInt != null && (i6 = childViewHolderInt.mPosition) >= i4 && i6 <= i3) {
                if (i6 == i) {
                    childViewHolderInt.offsetPosition(i2 - i, false);
                } else {
                    childViewHolderInt.offsetPosition(i5, false);
                }
                this.mState.f2706iILLL1 = true;
            }
        }
        this.mRecycler.m3294lL(i, i2);
        requestLayout();
    }

    public void offsetPositionRecordsForRemove(int i, int i2, boolean z) {
        int i3 = i + i2;
        int iM2374il = this.mChildHelper.m2374il();
        for (int i4 = 0; i4 < iM2374il; i4++) {
            LL1IL childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2368L11I(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                int i5 = childViewHolderInt.mPosition;
                if (i5 >= i3) {
                    childViewHolderInt.offsetPosition(-i2, z);
                    this.mState.f2706iILLL1 = true;
                } else if (i5 >= i) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i - 1, -i2, z);
                    this.mState.f2706iILLL1 = true;
                }
            }
        }
        this.mRecycler.I11L(i, i2, z);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        this.mIsAttached = true;
        this.mFirstLayoutComplete = this.mFirstLayoutComplete && !isLayoutRequested();
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 != null) {
            llLI1.dispatchAttachedToWindow(this);
        }
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK) {
            ThreadLocal<ILil.Lil.p037IL.lLi1LL> threadLocal = ILil.Lil.p037IL.lLi1LL.f1775lLi1LL;
            ILil.Lil.p037IL.lLi1LL lli1ll = threadLocal.get();
            this.mGapWorker = lli1ll;
            if (lli1ll == null) {
                this.mGapWorker = new ILil.Lil.p037IL.lLi1LL();
                Display displayIIi1 = ILil.p028IiL.p029ILl.iIlLiL.iIi1(this);
                float f = 60.0f;
                if (!isInEditMode() && displayIIi1 != null) {
                    float refreshRate = displayIIi1.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f = refreshRate;
                    }
                }
                ILil.Lil.p037IL.lLi1LL lli1ll2 = this.mGapWorker;
                lli1ll2.f1776IL = (long) (1.0E9f / f);
                threadLocal.set(lli1ll2);
            }
            this.mGapWorker.IL1Iii(this);
        }
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ILil.Lil.p037IL.lLi1LL lli1ll;
        super.onDetachedFromWindow();
        lIiI liii = this.mItemAnimator;
        if (liii != null) {
            liii.ILL();
        }
        stopScroll();
        this.mIsAttached = false;
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 != null) {
            llLI1.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.m2436il();
        if (!ALLOW_THREAD_GAP_WORK || (lli1ll = this.mGapWorker) == null) {
            return;
        }
        lli1ll.m2445il(this);
        this.mGapWorker = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mItemDecorations.get(i).onDraw(canvas, this, this.mState);
        }
    }

    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0060  */
    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f;
        float axisValue;
        if (this.mLayout != null && !this.mLayoutSuppressed && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f = this.mLayout.canScrollVertically() ? -motionEvent.getAxisValue(9) : 0.0f;
                axisValue = this.mLayout.canScrollHorizontally() ? motionEvent.getAxisValue(10) : 0.0f;
            } else if ((motionEvent.getSource() & Calib3d.CALIB_USE_EXTRINSIC_GUESS) != 0) {
                float axisValue2 = motionEvent.getAxisValue(26);
                if (this.mLayout.canScrollVertically()) {
                    f = -axisValue2;
                } else if (this.mLayout.canScrollHorizontally()) {
                    axisValue = axisValue2;
                    f = 0.0f;
                } else {
                    f = 0.0f;
                }
            } else {
                f = 0.0f;
            }
            if (f != 0.0f || axisValue != 0.0f) {
                scrollByInternal((int) (axisValue * this.mScaledHorizontalScrollFactor), (int) (f * this.mScaledVerticalScrollFactor), motionEvent);
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 == null) {
            return false;
        }
        boolean zCanScrollHorizontally = llLI1.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
            if (this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            int i = zCanScrollHorizontally;
            if (zCanScrollVertically) {
                i = (zCanScrollHorizontally ? 1 : 0) | 2;
            }
            startNestedScroll(i, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (iFindPointerIndex < 0) {
                Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x2 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i2 = x2 - this.mInitialTouchX;
                int i3 = y2 - this.mInitialTouchY;
                if (!zCanScrollHorizontally || Math.abs(i2) <= this.mTouchSlop) {
                    z = false;
                } else {
                    this.mLastTouchX = x2;
                    z = true;
                }
                if (zCanScrollVertically && Math.abs(i3) > this.mTouchSlop) {
                    this.mLastTouchY = y2;
                    z = true;
                }
                if (z) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x3;
            this.mInitialTouchX = x3;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y3;
            this.mInitialTouchY = y3;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        return this.mScrollState == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ILil.p028IiL.p036il.IL1Iii.IL1Iii(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        ILil.p028IiL.p036il.IL1Iii.ILil();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 == null) {
            defaultOnMeasure(i, i2);
            return;
        }
        boolean z = false;
        if (llLI1.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (z || this.mAdapter == null) {
                return;
            }
            if (this.mState.f5106Ilil == 1) {
                dispatchLayoutStep1();
            }
            this.mLayout.setMeasureSpecs(i, i2);
            this.mState.f2710il = true;
            dispatchLayoutStep2();
            this.mLayout.setMeasuredDimensionFromChildren(i, i2);
            if (this.mLayout.shouldMeasureTwice()) {
                this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), Videoio.CAP_OPENNI_IMAGE_GENERATOR), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), Videoio.CAP_OPENNI_IMAGE_GENERATOR));
                this.mState.f2710il = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(i, i2);
                return;
            }
            return;
        }
        if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
            return;
        }
        if (this.mAdapterUpdateDuringMeasure) {
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            processAdapterUpdatesAndSetAnimationFlags();
            onExitLayoutOrScroll();
            C1 c1 = this.mState;
            if (c1.f2704Ll1) {
                c1.f2703IiL = true;
            } else {
                this.mAdapterHelper.m2345il();
                this.mState.f2703IiL = false;
            }
            this.mAdapterUpdateDuringMeasure = false;
            stopInterceptRequestLayout(false);
        } else if (this.mState.f2704Ll1) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        IiL iiL = this.mAdapter;
        if (iiL != null) {
            this.mState.f2709lLi1LL = iiL.getItemCount();
        } else {
            this.mState.f2709lLi1LL = 0;
        }
        startInterceptRequestLayout();
        this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
        stopInterceptRequestLayout(false);
        this.mState.f2703IiL = false;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.mPendingSavedState = savedState;
        super.onRestoreInstanceState(savedState.getSuperState());
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 == null || (parcelable2 = this.mPendingSavedState.f5082ILil) == null) {
            return;
        }
        llLI1.onRestoreInstanceState(parcelable2);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSavedState;
        if (savedState2 != null) {
            savedState.IL1Iii(savedState2);
        } else {
            LlLI1 llLI1 = this.mLayout;
            if (llLI1 != null) {
                savedState.f5082ILil = llLI1.onSaveInstanceState();
            } else {
                savedState.f5082ILil = null;
            }
        }
        return savedState;
    }

    public void onScrollStateChanged(int i) {
    }

    public void onScrolled(int i, int i2) {
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        invalidateGlows();
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00df A[PHI: r0
  0x00df: PHI (r0v36 int) = (r0v26 int), (r0v40 int) binds: [B:41:0x00c8, B:45:0x00db] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        boolean z;
        boolean z2 = false;
        if (this.mLayoutSuppressed || this.mIgnoreMotionEventTillDown) {
            return false;
        }
        if (dispatchToOnItemTouchListeners(motionEvent)) {
            cancelScroll();
            return true;
        }
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 == null) {
            return false;
        }
        boolean zCanScrollHorizontally = llLI1.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int[] iArr2 = this.mNestedOffsets;
        motionEventObtain.offsetLocation(iArr2[0], iArr2[1]);
        if (actionMasked == 0) {
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
            if (zCanScrollVertically) {
                i = zCanScrollHorizontally;
                i = (zCanScrollHorizontally ? 1 : 0) | 2;
            }
            i = zCanScrollHorizontally;
            startNestedScroll(i, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.addMovement(motionEventObtain);
            this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
            float f = zCanScrollHorizontally ? -this.mVelocityTracker.getXVelocity(this.mScrollPointerId) : 0.0f;
            float f2 = zCanScrollVertically ? -this.mVelocityTracker.getYVelocity(this.mScrollPointerId) : 0.0f;
            if ((f == 0.0f && f2 == 0.0f) || !fling((int) f, (int) f2)) {
                setScrollState(0);
            }
            resetScroll();
            z2 = true;
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (iFindPointerIndex < 0) {
                Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x2 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            int iMax = this.mLastTouchX - x2;
            int iMax2 = this.mLastTouchY - y2;
            if (this.mScrollState != 1) {
                if (zCanScrollHorizontally) {
                    iMax = iMax > 0 ? Math.max(0, iMax - this.mTouchSlop) : Math.min(0, iMax + this.mTouchSlop);
                    if (iMax != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                if (zCanScrollVertically) {
                    iMax2 = iMax2 > 0 ? Math.max(0, iMax2 - this.mTouchSlop) : Math.min(0, iMax2 + this.mTouchSlop);
                    if (iMax2 != 0) {
                        z = true;
                    }
                }
                if (z) {
                    setScrollState(1);
                }
            }
            int i2 = iMax;
            int i3 = iMax2;
            if (this.mScrollState == 1) {
                int[] iArr3 = this.mReusableIntPair;
                iArr3[0] = 0;
                iArr3[1] = 0;
                if (dispatchNestedPreScroll(zCanScrollHorizontally ? i2 : 0, zCanScrollVertically ? i3 : 0, iArr3, this.mScrollOffset, 0)) {
                    int[] iArr4 = this.mReusableIntPair;
                    i2 -= iArr4[0];
                    i3 -= iArr4[1];
                    int[] iArr5 = this.mNestedOffsets;
                    int i4 = iArr5[0];
                    int[] iArr6 = this.mScrollOffset;
                    iArr5[0] = i4 + iArr6[0];
                    iArr5[1] = iArr5[1] + iArr6[1];
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                int i5 = i3;
                int[] iArr7 = this.mScrollOffset;
                this.mLastTouchX = x2 - iArr7[0];
                this.mLastTouchY = y2 - iArr7[1];
                if (scrollByInternal(zCanScrollHorizontally ? i2 : 0, zCanScrollVertically ? i5 : 0, motionEvent)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                ILil.Lil.p037IL.lLi1LL lli1ll = this.mGapWorker;
                if (lli1ll != null && (i2 != 0 || i5 != 0)) {
                    lli1ll.m2444lLi1LL(this, i2, i5);
                }
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x3;
            this.mInitialTouchX = x3;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y3;
            this.mInitialTouchY = y3;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        if (!z2) {
            this.mVelocityTracker.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    public void postAnimationRunner() {
        if (this.mPostedAnimatorRunner || !this.mIsAttached) {
            return;
        }
        ILil.p028IiL.p029ILl.iIlLiL.m74iI(this, this.mItemAnimatorRunner);
        this.mPostedAnimatorRunner = true;
    }

    public void processDataSetCompletelyChanged(boolean z) {
        this.mDispatchItemsChangedEvent = z | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    public void recordAnimationInfoIfBouncedHiddenView(LL1IL ll1il, lIiI.I1I i1i) {
        ll1il.setFlags(0, 8192);
        if (this.mState.f2705L11I && ll1il.isUpdated() && !ll1il.isRemoved() && !ll1il.shouldIgnore()) {
            this.mViewInfoStore.I1I(getChangedHolderKey(ll1il), ll1il);
        }
        this.mViewInfoStore.Ilil(ll1il, i1i);
    }

    public void removeAndRecycleViews() {
        lIiI liii = this.mItemAnimator;
        if (liii != null) {
            liii.ILL();
        }
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 != null) {
            llLI1.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        this.mRecycler.I1I();
    }

    public boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        boolean zM2371lIlii = this.mChildHelper.m2371lIlii(view);
        if (zM2371lIlii) {
            LL1IL childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.m3292iILLl(childViewHolderInt);
            this.mRecycler.LL1IL(childViewHolderInt);
        }
        stopInterceptRequestLayout(!zM2371lIlii);
        return zM2371lIlii;
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z) {
        LL1IL childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt + exceptionLabel());
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z);
    }

    public void removeItemDecoration(Lil lil) {
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 != null) {
            llLI1.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(lil);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i >= 0 && i < itemDecorationCount) {
            removeItemDecoration(getItemDecorationAt(i));
            return;
        }
        throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
    }

    public void removeOnChildAttachStateChangeListener(llL1ii lll1ii) {
        List<llL1ii> list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(lll1ii);
    }

    public void removeOnItemTouchListener(iIi1 iii1) {
        this.mOnItemTouchListeners.remove(iii1);
        if (this.mInterceptingOnItemTouchListener == iii1) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(iIlLiL iillil) {
        List<iIlLiL> list = this.mScrollListeners;
        if (list != null) {
            list.remove(iillil);
        }
    }

    public void repositionShadowingViews() {
        LL1IL ll1il;
        int iM2369iILLL1 = this.mChildHelper.m2369iILLL1();
        for (int i = 0; i < iM2369iILLL1; i++) {
            View viewM2373lLi1LL = this.mChildHelper.m2373lLi1LL(i);
            LL1IL childViewHolder = getChildViewHolder(viewM2373lLi1LL);
            if (childViewHolder != null && (ll1il = childViewHolder.mShadowingHolder) != null) {
                View view = ll1il.itemView;
                int left = viewM2373lLi1LL.getLeft();
                int top = viewM2373lLi1LL.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.mOnItemTouchListeners.size();
        for (int i = 0; i < size; i++) {
            this.mOnItemTouchListeners.get(i).I1I(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutSuppressed) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    public void saveOldPositions() {
        int iM2374il = this.mChildHelper.m2374il();
        for (int i = 0; i < iM2374il; i++) {
            LL1IL childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2368L11I(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        boolean zCanScrollHorizontally = llLI1.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (zCanScrollHorizontally || zCanScrollVertically) {
            if (!zCanScrollHorizontally) {
                i = 0;
            }
            if (!zCanScrollVertically) {
                i2 = 0;
            }
            scrollByInternal(i, i2, null);
        }
    }

    public boolean scrollByInternal(int i, int i2, MotionEvent motionEvent) {
        int i3;
        int i4;
        int i5;
        int i6;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i, i2, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i7 = iArr2[0];
            int i8 = iArr2[1];
            i3 = i8;
            i4 = i7;
            i5 = i - i7;
            i6 = i2 - i8;
        } else {
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        dispatchNestedScroll(i4, i3, i5, i6, this.mScrollOffset, 0, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i9 = i5 - iArr4[0];
        int i10 = i6 - iArr4[1];
        boolean z = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i11 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        this.mLastTouchX = i11 - iArr5[0];
        this.mLastTouchY -= iArr5[1];
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !ILil.p028IiL.p029ILl.L11I.IL1Iii(motionEvent, 8194)) {
                pullGlows(motionEvent.getX(), i9, motionEvent.getY(), i10);
            }
            considerReleasingGlowsOnScroll(i, i2);
        }
        if (i4 != 0 || i3 != 0) {
            dispatchOnScrolled(i4, i3);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z && i4 == 0 && i3 == 0) ? false : true;
    }

    public void scrollStep(int i, int i2, int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        ILil.p028IiL.p036il.IL1Iii.IL1Iii(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        int iScrollHorizontallyBy = i != 0 ? this.mLayout.scrollHorizontallyBy(i, this.mRecycler, this.mState) : 0;
        int iScrollVerticallyBy = i2 != 0 ? this.mLayout.scrollVerticallyBy(i2, this.mRecycler, this.mState) : 0;
        ILil.p028IiL.p036il.IL1Iii.ILil();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = iScrollHorizontallyBy;
            iArr[1] = iScrollVerticallyBy;
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i) {
        if (this.mLayoutSuppressed) {
            return;
        }
        stopScroll();
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 == null) {
            Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            llLI1.scrollToPosition(i);
            awakenScrollBars();
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(ILil.Lil.p037IL.lIiI liii) {
        this.mAccessibilityDelegate = liii;
        ILil.p028IiL.p029ILl.iIlLiL.m75lL(this, liii);
    }

    public void setAdapter(IiL iiL) {
        setLayoutFrozen(false);
        setAdapterInternal(iiL, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(ILL ill) {
        if (ill == this.mChildDrawingOrderCallback) {
            return;
        }
        this.mChildDrawingOrderCallback = ill;
        setChildrenDrawingOrderEnabled(ill != null);
    }

    public boolean setChildImportantForAccessibilityInternal(LL1IL ll1il, int i) {
        if (!isComputingLayout()) {
            ILil.p028IiL.p029ILl.iIlLiL.m72LL(ll1il.itemView, i);
            return true;
        }
        ll1il.mPendingAccessibilityState = i;
        this.mPendingAccessibilityImportanceChange.add(ll1il);
        return false;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z;
        super.setClipToPadding(z);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(Ll1 ll1) {
        ILil.p028IiL.p034lIiI.L11I.m2295IL(ll1);
        this.mEdgeEffectFactory = ll1;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean z) {
        this.mHasFixedSize = z;
    }

    public void setItemAnimator(lIiI liii) {
        lIiI liii2 = this.mItemAnimator;
        if (liii2 != null) {
            liii2.ILL();
            this.mItemAnimator.m3270lL(null);
        }
        this.mItemAnimator = liii;
        if (liii != null) {
            liii.m3270lL(this.mItemAnimatorListener);
        }
    }

    public void setItemViewCacheSize(int i) {
        this.mRecycler.llI(i);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    public void setLayoutManager(LlLI1 llLI1) {
        if (llLI1 == this.mLayout) {
            return;
        }
        stopScroll();
        if (this.mLayout != null) {
            lIiI liii = this.mItemAnimator;
            if (liii != null) {
                liii.ILL();
            }
            this.mLayout.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
            this.mRecycler.I1I();
            if (this.mIsAttached) {
                this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
            }
            this.mLayout.setRecyclerView(null);
            this.mLayout = null;
        } else {
            this.mRecycler.I1I();
        }
        this.mChildHelper.Lil();
        this.mLayout = llLI1;
        if (llLI1 != null) {
            if (llLI1.mRecyclerView != null) {
                throw new IllegalArgumentException("LayoutManager " + llLI1 + " is already attached to a RecyclerView:" + llLI1.mRecyclerView.exceptionLabel());
            }
            llLI1.setRecyclerView(this);
            if (this.mIsAttached) {
                this.mLayout.dispatchAttachedToWindow(this);
            }
        }
        this.mRecycler.m3275IIi();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            if (layoutTransition == null) {
                suppressLayout(false);
                return;
            } else if (layoutTransition.getAnimator(0) == null && layoutTransition.getAnimator(1) == null && layoutTransition.getAnimator(2) == null && layoutTransition.getAnimator(3) == null && layoutTransition.getAnimator(4) == null) {
                suppressLayout(true);
                return;
            }
        }
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().m2026ILl(z);
    }

    public void setOnFlingListener(lIlii lilii) {
        this.mOnFlingListener = lilii;
    }

    @Deprecated
    public void setOnScrollListener(iIlLiL iillil) {
        this.mScrollListener = iillil;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.mPreserveFocusAfterLayout = z;
    }

    public void setRecycledViewPool(I11li1 i11li1) {
        this.mRecycler.m3296LLlI1(i11li1);
    }

    public void setRecyclerListener(I11L i11l) {
        this.mRecyclerListener = i11l;
    }

    public void setScrollState(int i) {
        if (i == this.mScrollState) {
            return;
        }
        this.mScrollState = i;
        if (i != 2) {
            stopScrollersInternal();
        }
        dispatchOnScrollStateChanged(i);
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i != 0) {
            if (i == 1) {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(LlLLL llLLL) {
        this.mRecycler.m121(llLLL);
    }

    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!isComputingLayout()) {
            return false;
        }
        int iIL1Iii = accessibilityEvent != null ? ILil.p028IiL.p029ILl.LL1IL.ILil.IL1Iii(accessibilityEvent) : 0;
        this.mEatenAccessibilityChangeFlags |= iIL1Iii != 0 ? iIL1Iii : 0;
        return true;
    }

    public void smoothScrollBy(int i, int i2) {
        smoothScrollBy(i, i2, null);
    }

    public void smoothScrollToPosition(int i) {
        if (this.mLayoutSuppressed) {
            return;
        }
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            llLI1.smoothScrollToPosition(this, this.mState, i);
        }
    }

    public void startInterceptRequestLayout() {
        int i = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i;
        if (i != 1 || this.mLayoutSuppressed) {
            return;
        }
        this.mLayoutWasDefered = false;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().LlLI1(i);
    }

    public void stopInterceptRequestLayout(boolean z) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.View, ILil.p028IiL.p029ILl.InterfaceC0634il
    public void stopNestedScroll() {
        getScrollingChildHelper().m2033lIlii();
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z) {
        if (z != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (z) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.mLayoutSuppressed = true;
                this.mIgnoreMotionEventTillDown = true;
                stopScroll();
                return;
            }
            this.mLayoutSuppressed = false;
            if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                requestLayout();
            }
            this.mLayoutWasDefered = false;
        }
    }

    public void swapAdapter(IiL iiL, boolean z) {
        setLayoutFrozen(false);
        setAdapterInternal(iiL, true, z);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void viewRangeUpdate(int i, int i2, Object obj) {
        int i3;
        int iM2374il = this.mChildHelper.m2374il();
        int i4 = i + i2;
        for (int i5 = 0; i5 < iM2374il; i5++) {
            View viewM2368L11I = this.mChildHelper.m2368L11I(i5);
            LL1IL childViewHolderInt = getChildViewHolderInt(viewM2368L11I);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (i3 = childViewHolderInt.mPosition) >= i && i3 < i4) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((LayoutParams) viewM2368L11I.getLayoutParams()).f5074I1I = true;
            }
        }
        this.mRecycler.m3285ill(i, i2);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, ILil.Lil.IL1Iii.recyclerViewStyle);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().m2027IL(i, i2, iArr, iArr2, i3);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().m2031iILLL1(i, i2, i3, i4, iArr, i5);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002a  */
    /* JADX WARN: Code duplicated, block: B:17:0x0034  */
    /* JADX WARN: Code duplicated, block: B:22:0x0036 A[SYNTHETIC] */
    public LL1IL findViewHolderForPosition(int i, boolean z) {
        int iM2374il = this.mChildHelper.m2374il();
        LL1IL ll1il = null;
        for (int i2 = 0; i2 < iM2374il; i2++) {
            LL1IL childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2368L11I(i2));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved()) {
                if (z) {
                    if (childViewHolderInt.mPosition != i) {
                        continue;
                    } else {
                        if (this.mChildHelper.m2364ILl(childViewHolderInt.itemView)) {
                            return childViewHolderInt;
                        }
                        ll1il = childViewHolderInt;
                    }
                } else if (childViewHolderInt.getLayoutPosition() != i) {
                    continue;
                } else {
                    if (this.mChildHelper.m2364ILl(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    ll1il = childViewHolderInt;
                }
            }
        }
        return ll1il;
    }

    public boolean hasNestedScrollingParent(int i) {
        return getScrollingChildHelper().m2029Ll1(i);
    }

    public void onExitLayoutOrScroll(boolean z) {
        int i = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i;
        if (i < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    public void smoothScrollBy(int i, int i2, Interpolator interpolator) {
        smoothScrollBy(i, i2, interpolator, Integer.MIN_VALUE);
    }

    public boolean startNestedScroll(int i, int i2) {
        return getScrollingChildHelper().m2034llL1ii(i, i2);
    }

    public void stopNestedScroll(int i) {
        getScrollingChildHelper().iIi1(i);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mObserver = new llliI();
        this.mRecycler = new lL();
        this.mViewInfoStore = new ILil.Lil.p037IL.lIlii();
        this.mUpdateChildViewsRunnable = new IL1Iii();
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new Ll1();
        this.mItemAnimator = new ILil.Lil.p037IL.I1I();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        boolean z = true;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new RunnableC0664lIII();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new ILil.Lil.p037IL.lLi1LL.ILil() : null;
        this.mState = new C1();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new C0663ILl();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new ILil();
        this.mViewInfoProcessCallback = new IL();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = ILil.p028IiL.p029ILl.I11li1.ILil(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = ILil.p028IiL.p029ILl.I11li1.m2025IL(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.m3270lL(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (ILil.p028IiL.p029ILl.iIlLiL.I11L(this) == 0) {
            ILil.p028IiL.p029ILl.iIlLiL.m72LL(this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new ILil.Lil.p037IL.lIiI(this));
        int[] iArr = ILil.Lil.I1I.RecyclerView;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, i, 0);
        }
        String string = typedArrayObtainStyledAttributes.getString(ILil.Lil.I1I.RecyclerView_layoutManager);
        if (typedArrayObtainStyledAttributes.getInt(ILil.Lil.I1I.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(Calib3d.CALIB_TILTED_MODEL);
        }
        this.mClipToPadding = typedArrayObtainStyledAttributes.getBoolean(ILil.Lil.I1I.RecyclerView_android_clipToPadding, true);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(ILil.Lil.I1I.RecyclerView_fastScrollEnabled, false);
        this.mEnableFastScroller = z2;
        if (z2) {
            initFastScroller((StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(ILil.Lil.I1I.RecyclerView_fastScrollVerticalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(ILil.Lil.I1I.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(ILil.Lil.I1I.RecyclerView_fastScrollHorizontalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(ILil.Lil.I1I.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        typedArrayObtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, i, 0);
        if (i2 >= 21) {
            int[] iArr2 = NESTED_SCROLLING_ATTRS;
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i, 0);
            if (i2 >= 29) {
                saveAttributeDataForStyleable(context, iArr2, attributeSet, typedArrayObtainStyledAttributes2, i, 0);
            }
            z = typedArrayObtainStyledAttributes2.getBoolean(0, true);
            typedArrayObtainStyledAttributes2.recycle();
        }
        setNestedScrollingEnabled(z);
    }

    public final void dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        getScrollingChildHelper().Ilil(i, i2, i3, i4, iArr, i5, iArr2);
    }

    public void smoothScrollBy(int i, int i2, Interpolator interpolator, int i3) {
        smoothScrollBy(i, i2, interpolator, i3, false);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public boolean f5074I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public LL1IL f5075IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final Rect f5076ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public boolean f2685IL;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f5076ILil = new Rect();
            this.f5074I1I = true;
            this.f2685IL = false;
        }

        public boolean I1I() {
            return this.f5075IL1Iii.isRemoved();
        }

        public int IL1Iii() {
            return this.f5075IL1Iii.getLayoutPosition();
        }

        public boolean ILil() {
            return this.f5075IL1Iii.isUpdated();
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public boolean m3258IL() {
            return this.f5075IL1Iii.isInvalid();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f5076ILil = new Rect();
            this.f5074I1I = true;
            this.f2685IL = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f5076ILil = new Rect();
            this.f5074I1I = true;
            this.f2685IL = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f5076ILil = new Rect();
            this.f5074I1I = true;
            this.f2685IL = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.f5076ILil = new Rect();
            this.f5074I1I = true;
            this.f2685IL = false;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new IL1Iii();

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public Parcelable f5082ILil;

        public static class IL1Iii implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: I1I, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f5082ILil = parcel.readParcelable(classLoader == null ? LlLI1.class.getClassLoader() : classLoader);
        }

        public void IL1Iii(SavedState savedState) {
            this.f5082ILil = savedState.f5082ILil;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f5082ILil, 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 != null) {
            return llLI1.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    public void smoothScrollBy(int i, int i2, Interpolator interpolator, int i3, boolean z) {
        LlLI1 llLI1 = this.mLayout;
        if (llLI1 == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        if (!llLI1.canScrollHorizontally()) {
            i = 0;
        }
        if (!this.mLayout.canScrollVertically()) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        if (i3 == Integer.MIN_VALUE || i3 > 0) {
            if (z) {
                int i4 = i != 0 ? 1 : 0;
                if (i2 != 0) {
                    i4 |= 2;
                }
                startNestedScroll(i4, 1);
            }
            this.mViewFlinger.m3273lLi1LL(i, i2, i3, interpolator);
            return;
        }
        scrollBy(i, i2);
    }

    public void addItemDecoration(Lil lil) {
        addItemDecoration(lil, -1);
    }
}
