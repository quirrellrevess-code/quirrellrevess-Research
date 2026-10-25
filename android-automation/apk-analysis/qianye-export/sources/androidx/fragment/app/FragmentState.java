package androidx.fragment.app;

import ILil.ILL.IL1Iii.L11I;
import ILil.ILL.IL1Iii.lLi1LL;
import ILil.p042lIiI.IL;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new IL1Iii();

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final String f5017I1I;
    public final Bundle ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final String f5018ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public Bundle f2645ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final int f5019Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final boolean f2646IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final boolean f2647IiL;
    public Fragment Lil;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final boolean f2648Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final boolean f2649L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final String f2650iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final int f2651lIiI;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final int f2652lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final boolean f2653il;

    public static class IL1Iii implements Parcelable.Creator<FragmentState> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
        public FragmentState[] newArray(int i) {
            return new FragmentState[i];
        }
    }

    public FragmentState(Fragment fragment) {
        this.f5018ILil = fragment.getClass().getName();
        this.f5017I1I = fragment.mWho;
        this.f2646IL = fragment.mFromLayout;
        this.f5019Ilil = fragment.mFragmentId;
        this.f2652lLi1LL = fragment.mContainerId;
        this.f2650iILLL1 = fragment.mTag;
        this.f2647IiL = fragment.mRetainInstance;
        this.f2649L11I = fragment.mRemoving;
        this.f2653il = fragment.mDetached;
        this.ILL = fragment.mArguments;
        this.f2648Ll1 = fragment.mHidden;
        this.f2651lIiI = fragment.mMaxState.ordinal();
    }

    public Fragment IL1Iii(ClassLoader classLoader, lLi1LL lli1ll) {
        if (this.Lil == null) {
            Bundle bundle = this.ILL;
            if (bundle != null) {
                bundle.setClassLoader(classLoader);
            }
            Fragment fragmentIL1Iii = lli1ll.IL1Iii(classLoader, this.f5018ILil);
            this.Lil = fragmentIL1Iii;
            fragmentIL1Iii.setArguments(this.ILL);
            Bundle bundle2 = this.f2645ILl;
            if (bundle2 != null) {
                bundle2.setClassLoader(classLoader);
                this.Lil.mSavedFragmentState = this.f2645ILl;
            } else {
                this.Lil.mSavedFragmentState = new Bundle();
            }
            Fragment fragment = this.Lil;
            fragment.mWho = this.f5017I1I;
            fragment.mFromLayout = this.f2646IL;
            fragment.mRestored = true;
            fragment.mFragmentId = this.f5019Ilil;
            fragment.mContainerId = this.f2652lLi1LL;
            fragment.mTag = this.f2650iILLL1;
            fragment.mRetainInstance = this.f2647IiL;
            fragment.mRemoving = this.f2649L11I;
            fragment.mDetached = this.f2653il;
            fragment.mHidden = this.f2648Ll1;
            fragment.mMaxState = IL.ILil.values()[this.f2651lIiI];
            if (L11I.f1239L1l) {
                Log.v("FragmentManager", "Instantiated fragment " + this.Lil);
            }
        }
        return this.Lil;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f5018ILil);
        sb.append(" (");
        sb.append(this.f5017I1I);
        sb.append(")}:");
        if (this.f2646IL) {
            sb.append(" fromLayout");
        }
        if (this.f2652lLi1LL != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f2652lLi1LL));
        }
        String str = this.f2650iILLL1;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f2650iILLL1);
        }
        if (this.f2647IiL) {
            sb.append(" retainInstance");
        }
        if (this.f2649L11I) {
            sb.append(" removing");
        }
        if (this.f2653il) {
            sb.append(" detached");
        }
        if (this.f2648Ll1) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5018ILil);
        parcel.writeString(this.f5017I1I);
        parcel.writeInt(this.f2646IL ? 1 : 0);
        parcel.writeInt(this.f5019Ilil);
        parcel.writeInt(this.f2652lLi1LL);
        parcel.writeString(this.f2650iILLL1);
        parcel.writeInt(this.f2647IiL ? 1 : 0);
        parcel.writeInt(this.f2649L11I ? 1 : 0);
        parcel.writeInt(this.f2653il ? 1 : 0);
        parcel.writeBundle(this.ILL);
        parcel.writeInt(this.f2648Ll1 ? 1 : 0);
        parcel.writeBundle(this.f2645ILl);
        parcel.writeInt(this.f2651lIiI);
    }

    public FragmentState(Parcel parcel) {
        this.f5018ILil = parcel.readString();
        this.f5017I1I = parcel.readString();
        this.f2646IL = parcel.readInt() != 0;
        this.f5019Ilil = parcel.readInt();
        this.f2652lLi1LL = parcel.readInt();
        this.f2650iILLL1 = parcel.readString();
        this.f2647IiL = parcel.readInt() != 0;
        this.f2649L11I = parcel.readInt() != 0;
        this.f2653il = parcel.readInt() != 0;
        this.ILL = parcel.readBundle();
        this.f2648Ll1 = parcel.readInt() != 0;
        this.f2645ILl = parcel.readBundle();
        this.f2651lIiI = parcel.readInt();
    }
}
