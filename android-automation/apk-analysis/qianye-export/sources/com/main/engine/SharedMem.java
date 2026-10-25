package com.main.engine;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Log;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class SharedMem implements Parcelable {
    public static final Parcelable.Creator<SharedMem> CREATOR = new IL1Iii();

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public long f5356I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public String f5357ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public long f5358Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public ParcelFileDescriptor f2890IL;

    public static class IL1Iii implements Parcelable.Creator<SharedMem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public SharedMem createFromParcel(Parcel parcel) {
            return new SharedMem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
        public SharedMem[] newArray(int i) {
            return new SharedMem[i];
        }
    }

    public SharedMem(String str, long j) {
        this.f2890IL = null;
        this.f5356I1I = j;
        this.f5357ILil = str;
        int iOpen = open(str, j);
        Log.i(I1I.IL1Iii.IL1Iii(new byte[]{119, 60}, I1I.IL1Iii.IL1Iii(new byte[]{12, 83, 10, 9, 10, 6}, I1I.IL1Iii.IL1Iii(new byte[]{3, 85, 91, 5, 91, 81}, "6bc5bd"))), I1I.IL1Iii.IL1Iii(new byte[]{84, 68, 85, 85, 67, 86, 31}, I1I.IL1Iii.IL1Iii(new byte[]{7, 82, 84, 7, 1, 80}, I1I.IL1Iii.IL1Iii(new byte[]{86, 7, 6, 3, 14, 6}, "fcb08e"))) + str + I1I.IL1Iii.IL1Iii(new byte[]{25}, I1I.IL1Iii.IL1Iii(new byte[]{81, 4, 14, 7, 5, 85}, I1I.IL1Iii.IL1Iii(new byte[]{0, 80, 90, 7, 87, 0}, "d6b430"))) + j + I1I.IL1Iii.IL1Iii(new byte[]{27, 15, 8}, I1I.IL1Iii.IL1Iii(new byte[]{81, 84, 4, 14, 12, 80}, I1I.IL1Iii.IL1Iii(new byte[]{6, 87, 5, 82, 95, 84}, "e17efb"))) + iOpen);
        if (iOpen >= 0) {
            try {
                this.f2890IL = ParcelFileDescriptor.fromFd(iOpen);
            } catch (Exception unused) {
            }
        }
    }

    public ByteBuffer I1I() {
        long j = this.f5358Ilil;
        if (j == 0) {
            return null;
        }
        return getByteBuffer(j, this.f5356I1I);
    }

    public void IL1Iii() {
        if (this.f2890IL != null) {
            Ilil();
            try {
                this.f2890IL.close();
            } catch (Exception e) {
                Log.i(I1I.IL1Iii.IL1Iii(new byte[]{47, 60}, I1I.IL1Iii.IL1Iii(new byte[]{82, 86, 87, 7, 6, 92}, I1I.IL1Iii.IL1Iii(new byte[]{6, 3, 87, 80, 83, 95}, "51abff"))), I1I.IL1Iii.IL1Iii(new byte[]{84, 15, 10, 16, 3, 66, 82, 17, 23, 89}, I1I.IL1Iii.IL1Iii(new byte[]{6, 5, 83, 90, 87, 82}, I1I.IL1Iii.IL1Iii(new byte[]{83, 4, 85, 92, 6, 0}, "bbce70"))) + e.toString());
            }
            this.f2890IL = null;
        }
    }

    public int ILil() {
        try {
            ParcelFileDescriptor parcelFileDescriptor = this.f2890IL;
            if (parcelFileDescriptor != null) {
                return parcelFileDescriptor.detachFd();
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public void Ilil() {
        long j = this.f5358Ilil;
        if (j != 0) {
            unmap(j, this.f5356I1I);
            this.f5358Ilil = 0L;
            this.f5356I1I = 0L;
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m3486IL() {
        int fd = this.f2890IL.getFd();
        if (fd > 0) {
            this.f5358Ilil = mmap(fd, this.f5356I1I);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final native ByteBuffer getByteBuffer(long j, long j2);

    public final native long mmap(int i, long j);

    public final native int open(String str, long j);

    public final native void unmap(long j, long j2);

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5357ILil);
        parcel.writeLong(this.f5356I1I);
        parcel.writeFileDescriptor(this.f2890IL.getFileDescriptor());
    }

    public SharedMem(Parcel parcel) {
        this.f2890IL = null;
        this.f5357ILil = parcel.readString();
        this.f5356I1I = parcel.readLong();
        this.f2890IL = parcel.readFileDescriptor();
    }
}
