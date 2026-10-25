package p051lLi1LL.IL1Iii.ILil.IL1Iii;

import com.mysql.jdbc.StatementImpl;

/* JADX INFO: renamed from: l丨Li1LL.IL1Iii.ILil.IL1Iii.丨l丨, reason: invalid class name */
/* JADX INFO: compiled from: ZipShort.java */
/* JADX INFO: loaded from: classes.dex */
public final class l implements Cloneable {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final int f5538ILil;

    public l(int i) {
        this.f5538ILil = i;
    }

    public static byte[] ILil(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i & 65280) >> 8)};
    }

    public static int Ilil(byte[] bArr, int i) {
        return ((bArr[i + 1] << 8) & 65280) + (bArr[i] & StatementImpl.USES_VARIABLES_UNKNOWN);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static int m3657IL(byte[] bArr) {
        return Ilil(bArr, 0);
    }

    public int I1I() {
        return this.f5538ILil;
    }

    public byte[] IL1Iii() {
        int i = this.f5538ILil;
        return new byte[]{(byte) (i & 255), (byte) ((i & 65280) >> 8)};
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof l) && this.f5538ILil == ((l) obj).I1I();
    }

    public int hashCode() {
        return this.f5538ILil;
    }

    public String toString() {
        return "ZipShort value: " + this.f5538ILil;
    }

    public l(byte[] bArr, int i) {
        this.f5538ILil = Ilil(bArr, i);
    }
}
