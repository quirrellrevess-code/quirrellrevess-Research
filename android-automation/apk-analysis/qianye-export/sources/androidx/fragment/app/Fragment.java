package androidx.fragment.app;

import ILil.ILL.IL1Iii.L11I;
import ILil.ILL.IL1Iii.Lil;
import ILil.ILL.IL1Iii.LlLI1;
import ILil.p028IiL.Ilil.ILL;
import ILil.p042lIiI.IiL;
import ILil.p042lIiI.iIi1;
import ILil.p042lIiI.lIiI;
import ILil.p042lIiI.lIlii;
import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.LiveData;
import androidx.savedstate.SavedStateRegistry;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, IiL, iIi1, ILil.LlLI1.ILil {
    public static final int ACTIVITY_CREATED = 2;
    public static final int CREATED = 1;
    public static final int INITIALIZING = 0;
    public static final int RESUMED = 4;
    public static final int STARTED = 3;
    public static final Object USE_DEFAULT_TRANSITION = new Object();
    public boolean mAdded;
    public IL mAnimationInfo;
    public Bundle mArguments;
    public int mBackStackNesting;
    private boolean mCalled;
    public L11I mChildFragmentManager;
    public ViewGroup mContainer;
    public int mContainerId;
    private int mContentLayoutId;
    public boolean mDeferStart;
    public boolean mDetached;
    public int mFragmentId;
    public L11I mFragmentManager;
    public boolean mFromLayout;
    public boolean mHasMenu;
    public boolean mHidden;
    public boolean mHiddenChanged;
    public ILil.ILL.IL1Iii.iILLL1 mHost;
    public boolean mInLayout;
    public View mInnerView;
    public boolean mIsCreated;
    public boolean mIsNewlyAdded;
    private Boolean mIsPrimaryNavigationFragment;
    public LayoutInflater mLayoutInflater;
    public ILil.p042lIiI.L11I mLifecycleRegistry;
    public ILil.p042lIiI.IL.ILil mMaxState;
    public boolean mMenuVisible;
    public Fragment mParentFragment;
    public boolean mPerformedCreateView;
    public float mPostponedAlpha;
    public Runnable mPostponedDurationRunnable;
    public boolean mRemoving;
    public boolean mRestored;
    public boolean mRetainInstance;
    public boolean mRetainInstanceChangedWhileDetached;
    public Bundle mSavedFragmentState;
    public ILil.LlLI1.IL1Iii mSavedStateRegistryController;
    public Boolean mSavedUserVisibleHint;
    public SparseArray<Parcelable> mSavedViewState;
    public int mState;
    public String mTag;
    public Fragment mTarget;
    public int mTargetRequestCode;
    public String mTargetWho;
    public boolean mUserVisibleHint;
    public View mView;
    public Lil mViewLifecycleOwner;
    public lIiI<IiL> mViewLifecycleOwnerLiveData;
    public String mWho;

    public class I1I extends ILil.ILL.IL1Iii.I1I {
        public I1I() {
        }

        @Override // ILil.ILL.IL1Iii.I1I
        public View I1I(int i) {
            View view = Fragment.this.mView;
            if (view != null) {
                return view.findViewById(i);
            }
            throw new IllegalStateException("Fragment " + this + " does not have a view");
        }

        @Override // ILil.ILL.IL1Iii.I1I
        /* JADX INFO: renamed from: I丨L */
        public boolean mo1446IL() {
            return Fragment.this.mView != null;
        }
    }

    public class IL1Iii implements Runnable {
        public IL1Iii() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.startPostponedEnterTransition();
        }
    }

    public class ILil implements Runnable {
        public ILil() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.callStartTransitionListener();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.Fragment$I丨L, reason: invalid class name */
    public static class IL {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f5009I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public View f5010IL1Iii;
        public Object ILL;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public Animator f5011ILil;

        /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
        public Boolean f2624ILl;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int f5012Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int f2625IL;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public Object f2626IiL;
        public ILL Lil;
        public ILL LlLI1;

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public Object f2627Ll1;

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public Object f2628L11I;
        public boolean iIi1;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public Object f2629iILLL1 = null;

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public Boolean f2630lIiI;

        /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
        public iILLL1 f2631lIlii;

        /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
        public boolean f2632llL1ii;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public int f2633lLi1LL;

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public Object f2634il;

        public IL() {
            Object obj = Fragment.USE_DEFAULT_TRANSITION;
            this.f2626IiL = obj;
            this.f2628L11I = null;
            this.f2634il = obj;
            this.ILL = null;
            this.f2627Ll1 = obj;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new IL1Iii();

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final Bundle f5013ILil;

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
            Bundle bundle = parcel.readBundle();
            this.f5013ILil = bundle;
            if (classLoader == null || bundle == null) {
                return;
            }
            bundle.setClassLoader(classLoader);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f5013ILil);
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.Fragment$iI丨LLL1, reason: invalid class name */
    public interface iILLL1 {
        void IL1Iii();

        void ILil();
    }

    /* JADX INFO: renamed from: androidx.fragment.app.Fragment$l丨Li1LL, reason: invalid class name */
    public static class lLi1LL extends RuntimeException {
        public lLi1LL(String str, Exception exc) {
            super(str, exc);
        }
    }

    public Fragment() {
        this.mState = 0;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new L11I();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new IL1Iii();
        this.mMaxState = ILil.p042lIiI.IL.ILil.RESUMED;
        this.mViewLifecycleOwnerLiveData = new lIiI<>();
        initLifecycle();
    }

    private IL ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new IL();
        }
        return this.mAnimationInfo;
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new ILil.p042lIiI.L11I(this);
        this.mSavedStateRegistryController = ILil.LlLI1.IL1Iii.IL1Iii(this);
        if (Build.VERSION.SDK_INT >= 19) {
            this.mLifecycleRegistry.IL1Iii(new ILil.p042lIiI.lLi1LL() { // from class: androidx.fragment.app.Fragment.2
                @Override // ILil.p042lIiI.lLi1LL
                public void I1I(IiL iiL, ILil.p042lIiI.IL.IL1Iii iL1Iii) {
                    View view;
                    if (iL1Iii != ILil.p042lIiI.IL.IL1Iii.ON_STOP || (view = Fragment.this.mView) == null) {
                        return;
                    }
                    view.cancelPendingInputEvents();
                }
            });
        }
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    public void callStartTransitionListener() {
        IL il = this.mAnimationInfo;
        iILLL1 iilll1 = null;
        if (il != null) {
            il.f2632llL1ii = false;
            iILLL1 iilll2 = il.f2631lIlii;
            il.f2631lIlii = null;
            iilll1 = iilll2;
        }
        if (iilll1 != null) {
            iilll1.ILil();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        if (getNextAnim() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(getNextAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (this.mInnerView != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(getStateAfterAnimating());
        }
        if (getContext() != null) {
            ILil.p025ILl.IL1Iii.IL1Iii.ILil(this).IL1Iii(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.ILil(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Fragment findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.LiL1(str);
    }

    public final FragmentActivity getActivity() {
        ILil.ILL.IL1Iii.iILLL1 iilll1 = this.mHost;
        if (iilll1 == null) {
            return null;
        }
        return (FragmentActivity) iilll1.Ilil();
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        IL il = this.mAnimationInfo;
        if (il == null || (bool = il.f2624ILl) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        IL il = this.mAnimationInfo;
        if (il == null || (bool = il.f2630lIiI) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public View getAnimatingAway() {
        IL il = this.mAnimationInfo;
        if (il == null) {
            return null;
        }
        return il.f5010IL1Iii;
    }

    public Animator getAnimator() {
        IL il = this.mAnimationInfo;
        if (il == null) {
            return null;
        }
        return il.f5011ILil;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final ILil.ILL.IL1Iii.IiL getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public Context getContext() {
        ILil.ILL.IL1Iii.iILLL1 iilll1 = this.mHost;
        if (iilll1 == null) {
            return null;
        }
        return iilll1.m1595lLi1LL();
    }

    public Object getEnterTransition() {
        IL il = this.mAnimationInfo;
        if (il == null) {
            return null;
        }
        return il.f2629iILLL1;
    }

    public ILL getEnterTransitionCallback() {
        IL il = this.mAnimationInfo;
        if (il == null) {
            return null;
        }
        return il.Lil;
    }

    public Object getExitTransition() {
        IL il = this.mAnimationInfo;
        if (il == null) {
            return null;
        }
        return il.f2628L11I;
    }

    public ILL getExitTransitionCallback() {
        IL il = this.mAnimationInfo;
        if (il == null) {
            return null;
        }
        return il.LlLI1;
    }

    public final ILil.ILL.IL1Iii.IiL getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        ILil.ILL.IL1Iii.iILLL1 iilll1 = this.mHost;
        if (iilll1 == null) {
            return null;
        }
        return iilll1.mo1596il();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    @Override // ILil.p042lIiI.IiL
    public ILil.p042lIiI.IL getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public ILil.p025ILl.IL1Iii.IL1Iii getLoaderManager() {
        return ILil.p025ILl.IL1Iii.IL1Iii.ILil(this);
    }

    public int getNextAnim() {
        IL il = this.mAnimationInfo;
        if (il == null) {
            return 0;
        }
        return il.f2625IL;
    }

    public int getNextTransition() {
        IL il = this.mAnimationInfo;
        if (il == null) {
            return 0;
        }
        return il.f5012Ilil;
    }

    public int getNextTransitionStyle() {
        IL il = this.mAnimationInfo;
        if (il == null) {
            return 0;
        }
        return il.f2633lLi1LL;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public Object getReenterTransition() {
        IL il = this.mAnimationInfo;
        if (il == null) {
            return null;
        }
        Object obj = il.f2634il;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        IL il = this.mAnimationInfo;
        if (il == null) {
            return null;
        }
        Object obj = il.f2626IiL;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    @Override // ILil.LlLI1.ILil
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.ILil();
    }

    public Object getSharedElementEnterTransition() {
        IL il = this.mAnimationInfo;
        if (il == null) {
            return null;
        }
        return il.ILL;
    }

    public Object getSharedElementReturnTransition() {
        IL il = this.mAnimationInfo;
        if (il == null) {
            return null;
        }
        Object obj = il.f2627Ll1;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    public int getStateAfterAnimating() {
        IL il = this.mAnimationInfo;
        if (il == null) {
            return 0;
        }
        return il.f5009I1I;
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final String getTag() {
        return this.mTag;
    }

    public final Fragment getTargetFragment() {
        String str;
        Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        L11I l11i = this.mFragmentManager;
        if (l11i == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return l11i.f1243IiL.get(str);
    }

    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i) {
        return getResources().getText(i);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public IiL getViewLifecycleOwner() {
        Lil lil = this.mViewLifecycleOwner;
        if (lil != null) {
            return lil;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public LiveData<IiL> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // ILil.p042lIiI.iIi1
    public lIlii getViewModelStore() {
        L11I l11i = this.mFragmentManager;
        if (l11i != null) {
            return l11i.LII(this);
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void initState() {
        initLifecycle();
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new L11I();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    public boolean isHideReplaced() {
        IL il = this.mAnimationInfo;
        if (il == null) {
            return false;
        }
        return il.iIi1;
    }

    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        return this.mMenuVisible;
    }

    public boolean isPostponed() {
        IL il = this.mAnimationInfo;
        if (il == null) {
            return false;
        }
        return il.f2632llL1ii;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        return this.mState >= 4;
    }

    public final boolean isStateSaved() {
        L11I l11i = this.mFragmentManager;
        if (l11i == null) {
            return false;
        }
        return l11i.m1568ILI();
    }

    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    public void noteStateNotSaved() {
        this.mChildFragmentManager.L1ii1();
    }

    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        ILil.ILL.IL1Iii.iILLL1 iilll1 = this.mHost;
        Activity activityIlil = iilll1 == null ? null : iilll1.Ilil();
        if (activityIlil != null) {
            this.mCalled = false;
            onAttach(activityIlil);
        }
    }

    public void onAttachFragment(Fragment fragment) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        if (this.mChildFragmentManager.iIlL1(1)) {
            return;
        }
        this.mChildFragmentManager.m1561lIII();
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = this.mContentLayoutId;
        if (i != 0) {
            return layoutInflater.inflate(i, viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean z) {
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        ILil.ILL.IL1Iii.iILLL1 iilll1 = this.mHost;
        Activity activityIlil = iilll1 == null ? null : iilll1.Ilil();
        if (activityIlil != null) {
            this.mCalled = false;
            onInflate(activityIlil, attributeSet, bundle);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    public void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.L1ii1();
        this.mState = 2;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (this.mCalled) {
            this.mChildFragmentManager.m1581l();
            return;
        }
        throw new LlLI1("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    public void performAttach() {
        this.mChildFragmentManager.LlLI1(this.mHost, new I1I(), this);
        this.mCalled = false;
        onAttach(this.mHost.m1595lLi1LL());
        if (this.mCalled) {
            return;
        }
        throw new LlLI1("Fragment " + this + " did not call through to super.onAttach()");
    }

    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.mChildFragmentManager.m15841(configuration);
    }

    public boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        return onContextItemSelected(menuItem) || this.mChildFragmentManager.m1545LlLLL(menuItem);
    }

    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.L1ii1();
        this.mState = 1;
        this.mCalled = false;
        this.mSavedStateRegistryController.I1I(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (this.mCalled) {
            this.mLifecycleRegistry.m2507L11I(ILil.p042lIiI.IL.IL1Iii.ON_CREATE);
            return;
        }
        throw new LlLI1("Fragment " + this + " did not call through to super.onCreate()");
    }

    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onCreateOptionsMenu(menu, menuInflater);
        }
        return z | this.mChildFragmentManager.LL1IL(menu, menuInflater);
    }

    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.L1ii1();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new Lil();
        View viewOnCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = viewOnCreateView;
        if (viewOnCreateView != null) {
            this.mViewLifecycleOwner.I1I();
            this.mViewLifecycleOwnerLiveData.mo1933IiL(this.mViewLifecycleOwner);
        } else {
            if (this.mViewLifecycleOwner.m1505IL()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.mViewLifecycleOwner = null;
        }
    }

    public void performDestroy() {
        this.mChildFragmentManager.m1534L111();
        this.mLifecycleRegistry.m2507L11I(ILil.p042lIiI.IL.IL1Iii.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (this.mCalled) {
            return;
        }
        throw new LlLI1("Fragment " + this + " did not call through to super.onDestroy()");
    }

    public void performDestroyView() {
        this.mChildFragmentManager.m1582LLlI1();
        if (this.mView != null) {
            this.mViewLifecycleOwner.IL1Iii(ILil.p042lIiI.IL.IL1Iii.ON_DESTROY);
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled) {
            ILil.p025ILl.IL1Iii.IL1Iii.ILil(this).I1I();
            this.mPerformedCreateView = false;
        } else {
            throw new LlLI1("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    public void performDetach() {
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (this.mCalled) {
            if (this.mChildFragmentManager.m52li()) {
                return;
            }
            this.mChildFragmentManager.m1534L111();
            this.mChildFragmentManager = new L11I();
            return;
        }
        throw new LlLI1("Fragment " + this + " did not call through to super.onDetach()");
    }

    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        LayoutInflater layoutInflaterOnGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = layoutInflaterOnGetLayoutInflater;
        return layoutInflaterOnGetLayoutInflater;
    }

    public void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.m57();
    }

    public void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
        this.mChildFragmentManager.llI(z);
    }

    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        return (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) || this.mChildFragmentManager.m1530ILLIi(menuItem);
    }

    public void performOptionsMenuClosed(Menu menu) {
        if (this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.m1565li11(menu);
    }

    public void performPause() {
        this.mChildFragmentManager.m49i1();
        if (this.mView != null) {
            this.mViewLifecycleOwner.IL1Iii(ILil.p042lIiI.IL.IL1Iii.ON_PAUSE);
        }
        this.mLifecycleRegistry.m2507L11I(ILil.p042lIiI.IL.IL1Iii.ON_PAUSE);
        this.mState = 3;
        this.mCalled = false;
        onPause();
        if (this.mCalled) {
            return;
        }
        throw new LlLI1("Fragment " + this + " did not call through to super.onPause()");
    }

    public void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
        this.mChildFragmentManager.m1553ili11(z);
    }

    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onPrepareOptionsMenu(menu);
        }
        return z | this.mChildFragmentManager.m1536LIl(menu);
    }

    public void performPrimaryNavigationFragmentChanged() {
        boolean zM1552iil1 = this.mFragmentManager.m1552iil1(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != zM1552iil1) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(zM1552iil1);
            onPrimaryNavigationFragmentChanged(zM1552iil1);
            this.mChildFragmentManager.m50iI();
        }
    }

    public void performResume() {
        this.mChildFragmentManager.L1ii1();
        this.mChildFragmentManager.I1IILIIL();
        this.mState = 4;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new LlLI1("Fragment " + this + " did not call through to super.onResume()");
        }
        ILil.p042lIiI.L11I l11i = this.mLifecycleRegistry;
        ILil.p042lIiI.IL.IL1Iii iL1Iii = ILil.p042lIiI.IL.IL1Iii.ON_RESUME;
        l11i.m2507L11I(iL1Iii);
        if (this.mView != null) {
            this.mViewLifecycleOwner.IL1Iii(iL1Iii);
        }
        this.mChildFragmentManager.m1541LlLiLL();
        this.mChildFragmentManager.I1IILIIL();
    }

    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.m2449IL(bundle);
        Parcelable parcelableLIiiILi = this.mChildFragmentManager.LIiiILi();
        if (parcelableLIiiILi != null) {
            bundle.putParcelable("android:support:fragments", parcelableLIiiILi);
        }
    }

    public void performStart() {
        this.mChildFragmentManager.L1ii1();
        this.mChildFragmentManager.I1IILIIL();
        this.mState = 3;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new LlLI1("Fragment " + this + " did not call through to super.onStart()");
        }
        ILil.p042lIiI.L11I l11i = this.mLifecycleRegistry;
        ILil.p042lIiI.IL.IL1Iii iL1Iii = ILil.p042lIiI.IL.IL1Iii.ON_START;
        l11i.m2507L11I(iL1Iii);
        if (this.mView != null) {
            this.mViewLifecycleOwner.IL1Iii(iL1Iii);
        }
        this.mChildFragmentManager.m46I();
    }

    public void performStop() {
        this.mChildFragmentManager.m1550iILilI();
        if (this.mView != null) {
            this.mViewLifecycleOwner.IL1Iii(ILil.p042lIiI.IL.IL1Iii.ON_STOP);
        }
        this.mLifecycleRegistry.m2507L11I(ILil.p042lIiI.IL.IL1Iii.ON_STOP);
        this.mState = 2;
        this.mCalled = false;
        onStop();
        if (this.mCalled) {
            return;
        }
        throw new LlLI1("Fragment " + this + " did not call through to super.onStop()");
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().f2632llL1ii = true;
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public final void requestPermissions(String[] strArr, int i) {
        ILil.ILL.IL1Iii.iILLL1 iilll1 = this.mHost;
        if (iilll1 != null) {
            iilll1.mo1587ILl(this, strArr, i);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final FragmentActivity requireActivity() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final ILil.ILL.IL1Iii.IiL requireFragmentManager() {
        ILil.ILL.IL1Iii.IiL fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public void restoreChildFragmentState(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.mChildFragmentManager.IL1(parcelable);
        this.mChildFragmentManager.m1561lIII();
    }

    public final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mInnerView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (this.mCalled) {
            if (this.mView != null) {
                this.mViewLifecycleOwner.IL1Iii(ILil.p042lIiI.IL.IL1Iii.ON_CREATE);
            }
        } else {
            throw new LlLI1("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        ensureAnimationInfo().f2624ILl = Boolean.valueOf(z);
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        ensureAnimationInfo().f2630lIiI = Boolean.valueOf(z);
    }

    public void setAnimatingAway(View view) {
        ensureAnimationInfo().f5010IL1Iii = view;
    }

    public void setAnimator(Animator animator) {
        ensureAnimationInfo().f5011ILil = animator;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public void setEnterSharedElementCallback(ILL ill) {
        ensureAnimationInfo().Lil = ill;
    }

    public void setEnterTransition(Object obj) {
        ensureAnimationInfo().f2629iILLL1 = obj;
    }

    public void setExitSharedElementCallback(ILL ill) {
        ensureAnimationInfo().LlLI1 = ill;
    }

    public void setExitTransition(Object obj) {
        ensureAnimationInfo().f2628L11I = obj;
    }

    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (!isAdded() || isHidden()) {
                return;
            }
            this.mHost.iIi1();
        }
    }

    public void setHideReplaced(boolean z) {
        ensureAnimationInfo().iIi1 = z;
    }

    public void setInitialSavedState(SavedState savedState) {
        Bundle bundle;
        if (this.mFragmentManager != null) {
            throw new IllegalStateException("Fragment already added");
        }
        if (savedState == null || (bundle = savedState.f5013ILil) == null) {
            bundle = null;
        }
        this.mSavedFragmentState = bundle;
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.iIi1();
            }
        }
    }

    public void setNextAnim(int i) {
        if (this.mAnimationInfo == null && i == 0) {
            return;
        }
        ensureAnimationInfo().f2625IL = i;
    }

    public void setNextTransition(int i, int i2) {
        if (this.mAnimationInfo == null && i == 0 && i2 == 0) {
            return;
        }
        ensureAnimationInfo();
        IL il = this.mAnimationInfo;
        il.f5012Ilil = i;
        il.f2633lLi1LL = i2;
    }

    public void setOnStartEnterTransitionListener(iILLL1 iilll1) {
        ensureAnimationInfo();
        IL il = this.mAnimationInfo;
        iILLL1 iilll2 = il.f2631lIlii;
        if (iilll1 == iilll2) {
            return;
        }
        if (iilll1 != null && iilll2 != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        if (il.f2632llL1ii) {
            il.f2631lIlii = iilll1;
        }
        if (iilll1 != null) {
            iilll1.IL1Iii();
        }
    }

    public void setReenterTransition(Object obj) {
        ensureAnimationInfo().f2634il = obj;
    }

    public void setRetainInstance(boolean z) {
        this.mRetainInstance = z;
        L11I l11i = this.mFragmentManager;
        if (l11i == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z) {
            l11i.m1560lIiI(this);
        } else {
            l11i.m1558iLI(this);
        }
    }

    public void setReturnTransition(Object obj) {
        ensureAnimationInfo().f2626IiL = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        ensureAnimationInfo().ILL = obj;
    }

    public void setSharedElementReturnTransition(Object obj) {
        ensureAnimationInfo().f2627Ll1 = obj;
    }

    public void setStateAfterAnimating(int i) {
        ensureAnimationInfo().f5009I1I = i;
    }

    public void setTargetFragment(Fragment fragment, int i) {
        ILil.ILL.IL1Iii.IiL fragmentManager = getFragmentManager();
        ILil.ILL.IL1Iii.IiL fragmentManager2 = fragment != null ? fragment.getFragmentManager() : null;
        if (fragmentManager != null && fragmentManager2 != null && fragmentManager != fragmentManager2) {
            throw new IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as a target fragment");
        }
        for (Fragment targetFragment = fragment; targetFragment != null; targetFragment = targetFragment.getTargetFragment()) {
            if (targetFragment == this) {
                throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
            }
        }
        if (fragment == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager == null || fragment.mFragmentManager == null) {
            this.mTargetWho = null;
            this.mTarget = fragment;
        } else {
            this.mTargetWho = fragment.mWho;
            this.mTarget = null;
        }
        this.mTargetRequestCode = i;
    }

    @Deprecated
    public void setUserVisibleHint(boolean z) {
        if (!this.mUserVisibleHint && z && this.mState < 3 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            this.mFragmentManager.Li1l(this);
        }
        this.mUserVisibleHint = z;
        this.mDeferStart = this.mState < 3 && !z;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        ILil.ILL.IL1Iii.iILLL1 iilll1 = this.mHost;
        if (iilll1 != null) {
            return iilll1.LlLI1(str);
        }
        return false;
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent) {
        startActivity(intent, null);
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        startActivityForResult(intent, i, null);
    }

    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        ILil.ILL.IL1Iii.iILLL1 iilll1 = this.mHost;
        if (iilll1 != null) {
            iilll1.mo1593lIlii(this, intentSender, i, intent, i2, i3, i4, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void startPostponedEnterTransition() {
        L11I l11i = this.mFragmentManager;
        if (l11i == null || l11i.f1252lIlii == null) {
            ensureAnimationInfo().f2632llL1ii = false;
        } else if (Looper.myLooper() != this.mFragmentManager.f1252lIlii.m1591iILLL1().getLooper()) {
            this.mFragmentManager.f1252lIlii.m1591iILLL1().postAtFrontOfQueue(new ILil());
        } else {
            callStartTransitionListener();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        ILil.p028IiL.p034lIiI.IL1Iii.IL1Iii(this, sb);
        sb.append(" (");
        sb.append(this.mWho);
        sb.append(")");
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" ");
            sb.append(this.mTag);
        }
        sb.append('}');
        return sb.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        try {
            Fragment fragmentNewInstance = ILil.ILL.IL1Iii.lLi1LL.m1598IL(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragmentNewInstance.getClass().getClassLoader());
                fragmentNewInstance.setArguments(bundle);
            }
            return fragmentNewInstance;
        } catch (IllegalAccessException e) {
            throw new lLi1LL("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (InstantiationException e2) {
            throw new lLi1LL("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new lLi1LL("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new lLi1LL("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
        }
    }

    public final String getString(int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final void postponeEnterTransition(long j, TimeUnit timeUnit) {
        ensureAnimationInfo().f2632llL1ii = true;
        L11I l11i = this.mFragmentManager;
        Handler handlerM1591iILLL1 = l11i != null ? l11i.f1252lIlii.m1591iILLL1() : new Handler(Looper.getMainLooper());
        handlerM1591iILLL1.removeCallbacks(this.mPostponedDurationRunnable);
        handlerM1591iILLL1.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j));
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent, Bundle bundle) {
        ILil.ILL.IL1Iii.iILLL1 iilll1 = this.mHost;
        if (iilll1 != null) {
            iilll1.mo1594llL1ii(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        ILil.ILL.IL1Iii.iILLL1 iilll1 = this.mHost;
        if (iilll1 != null) {
            iilll1.mo1594llL1ii(this, intent, i, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        ILil.ILL.IL1Iii.iILLL1 iilll1 = this.mHost;
        if (iilll1 != null) {
            LayoutInflater layoutInflaterILL = iilll1.ILL();
            L11I l11i = this.mChildFragmentManager;
            l11i.m53l();
            ILil.p028IiL.p029ILl.lLi1LL.ILil(layoutInflaterILL, l11i);
            return layoutInflaterILL;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    public Fragment(int i) {
        this();
        this.mContentLayoutId = i;
    }
}
