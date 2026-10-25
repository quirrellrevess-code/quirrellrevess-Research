package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new IL1Iii();

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public ArrayList<String> f5014I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public ArrayList<FragmentState> f5015ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public String f5016Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public BackStackState[] f2643IL;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int f2644lLi1LL;

    public static class IL1Iii implements Parcelable.Creator<FragmentManagerState> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState[] newArray(int i) {
            return new FragmentManagerState[i];
        }
    }

    public FragmentManagerState() {
        this.f5016Ilil = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f5015ILil);
        parcel.writeStringList(this.f5014I1I);
        parcel.writeTypedArray(this.f2643IL, i);
        parcel.writeString(this.f5016Ilil);
        parcel.writeInt(this.f2644lLi1LL);
    }

    public FragmentManagerState(Parcel parcel) {
        this.f5016Ilil = null;
        this.f5015ILil = parcel.createTypedArrayList(FragmentState.CREATOR);
        this.f5014I1I = parcel.createStringArrayList();
        this.f2643IL = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.f5016Ilil = parcel.readString();
        this.f2644lLi1LL = parcel.readInt();
    }
}
