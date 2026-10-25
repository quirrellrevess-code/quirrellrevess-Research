package p051lLi1LL.IL1Iii.ILil.IL1Iii;

import com.mysql.jdbc.StatementImpl;

/* JADX INFO: compiled from: ZipLong.java */
/* JADX INFO: loaded from: classes.dex */
public final class I11L implements Cloneable {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final long f5483ILil;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final I11L f5481I1I = new I11L(33639248);

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static final I11L f3004IL = new I11L(67324752);

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static final I11L f5482Ilil = new I11L(134695760);

    public I11L(long j) {
        this.f5483ILil = j;
    }

    public static byte[] ILil(long j) {
        return new byte[]{(byte) (255 & j), (byte) ((65280 & j) >> 8), (byte) ((16711680 & j) >> 16), (byte) ((j & 4278190080L) >> 24)};
    }

    public static long Ilil(byte[] bArr, int i) {
        return (((long) (bArr[i + 3] << 24)) & 4278190080L) + ((long) ((bArr[i + 2] << 16) & 16711680)) + ((long) ((bArr[i + 1] << 8) & 65280)) + ((long) (bArr[i] & StatementImpl.USES_VARIABLES_UNKNOWN));
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static long m3607IL(byte[] bArr) {
        return Ilil(bArr, 0);
    }

    public long I1I() {
        return this.f5483ILil;
    }

    public byte[] IL1Iii() {
        return ILil(this.f5483ILil);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof I11L) && this.f5483ILil == ((I11L) obj).I1I();
    }

    public int hashCode() {
        return (int) this.f5483ILil;
    }

    public String toString() {
        return "ZipLong value: " + this.f5483ILil;
    }

    public I11L(byte[] bArr, int i) {
        this.f5483ILil = Ilil(bArr, i);
    }
}
