package androidx.fragment.app;

import ILil.ILL.IL1Iii.ILL;
import ILil.ILL.IL1Iii.IiL;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TabHost;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Context f5020I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final ArrayList<IL1Iii> f5021ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public int f5022Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public IiL f2654IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public boolean f2655IiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public IL1Iii f2656iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public TabHost.OnTabChangeListener f2657lLi1LL;

    public static final class IL1Iii {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final Bundle f5023I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final String f5024IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final Class<?> f5025ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public Fragment f2658IL;
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new IL1Iii();

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public String f5026ILil;

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

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f5026ILil + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f5026ILil);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f5026ILil = parcel.readString();
        }
    }

    @Deprecated
    public FragmentTabHost(Context context) {
        super(context, null);
        this.f5021ILil = new ArrayList<>();
        I1I(context, null);
    }

    public final void I1I(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.inflatedId}, 0, 0);
        this.f5022Ilil = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    public final ILL IL1Iii(String str, ILL ill) {
        Fragment fragment;
        IL1Iii iL1IiiILil = ILil(str);
        if (this.f2656iILLL1 != iL1IiiILil) {
            if (ill == null) {
                ill = this.f2654IL.IL1Iii();
            }
            IL1Iii iL1Iii = this.f2656iILLL1;
            if (iL1Iii != null && (fragment = iL1Iii.f2658IL) != null) {
                ill.mo1450L11I(fragment);
            }
            if (iL1IiiILil != null) {
                Fragment fragment2 = iL1IiiILil.f2658IL;
                if (fragment2 == null) {
                    Fragment fragmentIL1Iii = this.f2654IL.Ilil().IL1Iii(this.f5020I1I.getClassLoader(), iL1IiiILil.f5025ILil.getName());
                    iL1IiiILil.f2658IL = fragmentIL1Iii;
                    fragmentIL1Iii.setArguments(iL1IiiILil.f5023I1I);
                    ill.ILil(this.f5022Ilil, iL1IiiILil.f2658IL, iL1IiiILil.f5024IL1Iii);
                } else {
                    ill.Ilil(fragment2);
                }
            }
            this.f2656iILLL1 = iL1IiiILil;
        }
        return ill;
    }

    public final IL1Iii ILil(String str) {
        int size = this.f5021ILil.size();
        for (int i = 0; i < size; i++) {
            IL1Iii iL1Iii = this.f5021ILil.get(i);
            if (iL1Iii.f5024IL1Iii.equals(str)) {
                return iL1Iii;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.f5021ILil.size();
        ILL illIL1Iii = null;
        for (int i = 0; i < size; i++) {
            IL1Iii iL1Iii = this.f5021ILil.get(i);
            Fragment fragmentMo1491IL = this.f2654IL.mo1491IL(iL1Iii.f5024IL1Iii);
            iL1Iii.f2658IL = fragmentMo1491IL;
            if (fragmentMo1491IL != null && !fragmentMo1491IL.isDetached()) {
                if (iL1Iii.f5024IL1Iii.equals(currentTabTag)) {
                    this.f2656iILLL1 = iL1Iii;
                } else {
                    if (illIL1Iii == null) {
                        illIL1Iii = this.f2654IL.IL1Iii();
                    }
                    illIL1Iii.mo1450L11I(iL1Iii.f2658IL);
                }
            }
        }
        this.f2655IiL = true;
        ILL illIL1Iii2 = IL1Iii(currentTabTag, illIL1Iii);
        if (illIL1Iii2 != null) {
            illIL1Iii2.mo1456lLi1LL();
            this.f2654IL.I1I();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2655IiL = false;
    }

    @Override // android.view.View
    @Deprecated
    public void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f5026ILil);
    }

    @Override // android.view.View
    @Deprecated
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5026ILil = getCurrentTabTag();
        return savedState;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @Deprecated
    public void onTabChanged(String str) {
        ILL illIL1Iii;
        if (this.f2655IiL && (illIL1Iii = IL1Iii(str, null)) != null) {
            illIL1Iii.mo1456lLi1LL();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.f2657lLi1LL;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.f2657lLi1LL = onTabChangeListener;
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5021ILil = new ArrayList<>();
        I1I(context, attributeSet);
    }
}
