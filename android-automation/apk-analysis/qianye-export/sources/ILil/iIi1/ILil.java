package ILil.iIi1;

import ILil.p065Ilil.Ll1;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.google.android.flexbox.BuildConfig;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: VersionedParcelParcel.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil extends IL1Iii {
    public int ILL;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final Parcel f4327Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final SparseIntArray f1786IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final String f1787IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public int f1788L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final int f1789iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final int f1790lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public int f1791il;

    public ILil(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), BuildConfig.FLAVOR, new Ll1(), new Ll1(), new Ll1());
    }

    @Override // ILil.iIi1.IL1Iii
    public void I11L(int i) {
        IL1Iii();
        this.f1788L11I = i;
        this.f1786IL.put(i, this.f4327Ilil.dataPosition());
        mo2476LLlI1(0);
        mo2476LLlI1(i);
    }

    @Override // ILil.iIi1.IL1Iii
    public void IL1Iii() {
        int i = this.f1788L11I;
        if (i >= 0) {
            int i2 = this.f1786IL.get(i);
            int iDataPosition = this.f4327Ilil.dataPosition();
            this.f4327Ilil.setDataPosition(i2);
            this.f4327Ilil.writeInt(iDataPosition - i2);
            this.f4327Ilil.setDataPosition(iDataPosition);
        }
    }

    @Override // ILil.iIi1.IL1Iii
    public CharSequence ILL() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f4327Ilil);
    }

    @Override // ILil.iIi1.IL1Iii
    public IL1Iii ILil() {
        Parcel parcel = this.f4327Ilil;
        int iDataPosition = parcel.dataPosition();
        int i = this.f1791il;
        if (i == this.f1790lLi1LL) {
            i = this.f1789iILLL1;
        }
        return new ILil(parcel, iDataPosition, i, this.f1787IiL + "  ", this.f4325IL1Iii, this.f4326ILil, this.f4324I1I);
    }

    @Override // ILil.iIi1.IL1Iii
    public void LL1IL(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f4327Ilil, 0);
    }

    @Override // ILil.iIi1.IL1Iii
    public int Lil() {
        return this.f4327Ilil.readInt();
    }

    @Override // ILil.iIi1.IL1Iii
    /* JADX INFO: renamed from: L丨1l */
    public void mo2461L1l(String str) {
        this.f4327Ilil.writeString(str);
    }

    @Override // ILil.iIi1.IL1Iii
    /* JADX INFO: renamed from: L丨1丨1丨I */
    public byte[] mo2462L11I() {
        int i = this.f4327Ilil.readInt();
        if (i < 0) {
            return null;
        }
        byte[] bArr = new byte[i];
        this.f4327Ilil.readByteArray(bArr);
        return bArr;
    }

    @Override // ILil.iIi1.IL1Iii
    /* JADX INFO: renamed from: L丨lLLL */
    public void mo2463LlLLL(byte[] bArr) {
        if (bArr == null) {
            this.f4327Ilil.writeInt(-1);
        } else {
            this.f4327Ilil.writeInt(bArr.length);
            this.f4327Ilil.writeByteArray(bArr);
        }
    }

    @Override // ILil.iIi1.IL1Iii
    public String iIi1() {
        return this.f4327Ilil.readString();
    }

    @Override // ILil.iIi1.IL1Iii
    /* JADX INFO: renamed from: iI丨LLL1 */
    public boolean mo2464iILLL1() {
        return this.f4327Ilil.readInt() != 0;
    }

    @Override // ILil.iIi1.IL1Iii
    /* JADX INFO: renamed from: lIi丨I */
    public boolean mo2467lIiI(int i) {
        while (this.f1791il < this.f1789iILLL1) {
            int i2 = this.ILL;
            if (i2 == i) {
                return true;
            }
            if (String.valueOf(i2).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            this.f4327Ilil.setDataPosition(this.f1791il);
            int i3 = this.f4327Ilil.readInt();
            this.ILL = this.f4327Ilil.readInt();
            this.f1791il += i3;
        }
        return this.ILL == i;
    }

    @Override // ILil.iIi1.IL1Iii
    public void llI(Parcelable parcelable) {
        this.f4327Ilil.writeParcelable(parcelable, 0);
    }

    @Override // ILil.iIi1.IL1Iii
    /* JADX INFO: renamed from: ll丨L1ii */
    public <T extends Parcelable> T mo2470llL1ii() {
        return (T) this.f4327Ilil.readParcelable(ILil.class.getClassLoader());
    }

    @Override // ILil.iIi1.IL1Iii
    /* JADX INFO: renamed from: 丨l丨 */
    public void mo2475l(boolean z) {
        this.f4327Ilil.writeInt(z ? 1 : 0);
    }

    @Override // ILil.iIi1.IL1Iii
    /* JADX INFO: renamed from: 丨丨LLlI1 */
    public void mo2476LLlI1(int i) {
        this.f4327Ilil.writeInt(i);
    }

    public ILil(Parcel parcel, int i, int i2, String str, Ll1<String, Method> ll1, Ll1<String, Method> ll2, Ll1<String, Class> ll3) {
        super(ll1, ll2, ll3);
        this.f1786IL = new SparseIntArray();
        this.f1788L11I = -1;
        this.f1791il = 0;
        this.ILL = -1;
        this.f4327Ilil = parcel;
        this.f1790lLi1LL = i;
        this.f1789iILLL1 = i2;
        this.f1791il = i;
        this.f1787IiL = str;
    }
}
