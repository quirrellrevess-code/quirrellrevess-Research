package com.main.engine;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class BinderContainer implements Parcelable {
    public static final Parcelable.Creator<BinderContainer> CREATOR = new IL1Iii();
    public IBinder binder;

    public static class IL1Iii implements Parcelable.Creator<BinderContainer> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public BinderContainer createFromParcel(Parcel parcel) {
            return new BinderContainer(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
        public BinderContainer[] newArray(int i) {
            return new BinderContainer[i];
        }
    }

    public BinderContainer(IBinder iBinder) {
        this.binder = iBinder;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.binder);
    }

    public BinderContainer(Parcel parcel) {
        this.binder = parcel.readStrongBinder();
    }
}
