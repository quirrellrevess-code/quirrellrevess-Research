package androidx.fragment.app;

import ILil.ILL.IL1Iii.ILL;
import ILil.ILL.IL1Iii.L11I;
import ILil.p042lIiI.IL;
import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new IL1Iii();

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final ArrayList<String> f5002I1I;
    public final CharSequence ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final int[] f5003ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final ArrayList<String> f2615ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final int[] f5004Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final int[] f2616IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final String f2617IiL;
    public final ArrayList<String> Lil;
    public final boolean LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final int f2618Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final int f2619L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final int f2620iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final CharSequence f2621lIiI;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final int f2622lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final int f2623il;

    public static class IL1Iii implements Parcelable.Creator<BackStackState> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
        public BackStackState[] newArray(int i) {
            return new BackStackState[i];
        }
    }

    public BackStackState(ILil.ILL.IL1Iii.IL1Iii iL1Iii) {
        int size = iL1Iii.f3620IL1Iii.size();
        this.f5003ILil = new int[size * 5];
        if (!iL1Iii.f1205IiL) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f5002I1I = new ArrayList<>(size);
        this.f2616IL = new int[size];
        this.f5004Ilil = new int[size];
        int i = 0;
        int i2 = 0;
        while (i < size) {
            ILL.IL1Iii iL1Iii2 = iL1Iii.f3620IL1Iii.get(i);
            int i3 = i2 + 1;
            this.f5003ILil[i2] = iL1Iii2.f3624IL1Iii;
            ArrayList<String> arrayList = this.f5002I1I;
            Fragment fragment = iL1Iii2.f3625ILil;
            arrayList.add(fragment != null ? fragment.mWho : null);
            int[] iArr = this.f5003ILil;
            int i4 = i3 + 1;
            iArr[i3] = iL1Iii2.f3623I1I;
            int i5 = i4 + 1;
            iArr[i4] = iL1Iii2.f1213IL;
            int i6 = i5 + 1;
            iArr[i5] = iL1Iii2.f3626Ilil;
            iArr[i6] = iL1Iii2.f1216lLi1LL;
            this.f2616IL[i] = iL1Iii2.f1215iILLL1.ordinal();
            this.f5004Ilil[i] = iL1Iii2.f1214IiL.ordinal();
            i++;
            i2 = i6 + 1;
        }
        this.f2622lLi1LL = iL1Iii.f1211lLi1LL;
        this.f2620iILLL1 = iL1Iii.f1208iILLL1;
        this.f2617IiL = iL1Iii.f1207L11I;
        this.f2619L11I = iL1Iii.iIlLiL;
        this.f2623il = iL1Iii.f1212il;
        this.ILL = iL1Iii.ILL;
        this.f2618Ll1 = iL1Iii.f1206Ll1;
        this.f2621lIiI = iL1Iii.f1209lIiI;
        this.f2615ILl = iL1Iii.f1203ILl;
        this.Lil = iL1Iii.Lil;
        this.LlLI1 = iL1Iii.LlLI1;
    }

    public ILil.ILL.IL1Iii.IL1Iii IL1Iii(L11I l11i) {
        ILil.ILL.IL1Iii.IL1Iii iL1Iii = new ILil.ILL.IL1Iii.IL1Iii(l11i);
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.f5003ILil;
            if (i >= iArr.length) {
                iL1Iii.f1211lLi1LL = this.f2622lLi1LL;
                iL1Iii.f1208iILLL1 = this.f2620iILLL1;
                iL1Iii.f1207L11I = this.f2617IiL;
                iL1Iii.iIlLiL = this.f2619L11I;
                iL1Iii.f1205IiL = true;
                iL1Iii.f1212il = this.f2623il;
                iL1Iii.ILL = this.ILL;
                iL1Iii.f1206Ll1 = this.f2618Ll1;
                iL1Iii.f1209lIiI = this.f2621lIiI;
                iL1Iii.f1203ILl = this.f2615ILl;
                iL1Iii.Lil = this.Lil;
                iL1Iii.LlLI1 = this.LlLI1;
                iL1Iii.Lil(1);
                return iL1Iii;
            }
            ILL.IL1Iii iL1Iii2 = new ILL.IL1Iii();
            int i3 = i + 1;
            iL1Iii2.f3624IL1Iii = iArr[i];
            if (L11I.f1239L1l) {
                Log.v("FragmentManager", "Instantiate " + iL1Iii + " op #" + i2 + " base fragment #" + this.f5003ILil[i3]);
            }
            String str = this.f5002I1I.get(i2);
            if (str != null) {
                iL1Iii2.f3625ILil = l11i.f1243IiL.get(str);
            } else {
                iL1Iii2.f3625ILil = null;
            }
            iL1Iii2.f1215iILLL1 = IL.ILil.values()[this.f2616IL[i2]];
            iL1Iii2.f1214IiL = IL.ILil.values()[this.f5004Ilil[i2]];
            int[] iArr2 = this.f5003ILil;
            int i4 = i3 + 1;
            int i5 = iArr2[i3];
            iL1Iii2.f3623I1I = i5;
            int i6 = i4 + 1;
            int i7 = iArr2[i4];
            iL1Iii2.f1213IL = i7;
            int i8 = i6 + 1;
            int i9 = iArr2[i6];
            iL1Iii2.f3626Ilil = i9;
            int i10 = iArr2[i8];
            iL1Iii2.f1216lLi1LL = i10;
            iL1Iii.f3621ILil = i5;
            iL1Iii.f3619I1I = i7;
            iL1Iii.f1204IL = i9;
            iL1Iii.f3622Ilil = i10;
            iL1Iii.m1460IL(iL1Iii2);
            i2++;
            i = i8 + 1;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f5003ILil);
        parcel.writeStringList(this.f5002I1I);
        parcel.writeIntArray(this.f2616IL);
        parcel.writeIntArray(this.f5004Ilil);
        parcel.writeInt(this.f2622lLi1LL);
        parcel.writeInt(this.f2620iILLL1);
        parcel.writeString(this.f2617IiL);
        parcel.writeInt(this.f2619L11I);
        parcel.writeInt(this.f2623il);
        TextUtils.writeToParcel(this.ILL, parcel, 0);
        parcel.writeInt(this.f2618Ll1);
        TextUtils.writeToParcel(this.f2621lIiI, parcel, 0);
        parcel.writeStringList(this.f2615ILl);
        parcel.writeStringList(this.Lil);
        parcel.writeInt(this.LlLI1 ? 1 : 0);
    }

    public BackStackState(Parcel parcel) {
        this.f5003ILil = parcel.createIntArray();
        this.f5002I1I = parcel.createStringArrayList();
        this.f2616IL = parcel.createIntArray();
        this.f5004Ilil = parcel.createIntArray();
        this.f2622lLi1LL = parcel.readInt();
        this.f2620iILLL1 = parcel.readInt();
        this.f2617IiL = parcel.readString();
        this.f2619L11I = parcel.readInt();
        this.f2623il = parcel.readInt();
        this.ILL = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2618Ll1 = parcel.readInt();
        this.f2621lIiI = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2615ILl = parcel.createStringArrayList();
        this.Lil = parcel.createStringArrayList();
        this.LlLI1 = parcel.readInt() != 0;
    }
}
