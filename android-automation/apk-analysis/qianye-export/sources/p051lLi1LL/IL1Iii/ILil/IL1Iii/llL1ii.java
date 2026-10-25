package p051lLi1LL.IL1Iii.ILil.IL1Iii;

import java.math.BigInteger;

/* JADX INFO: renamed from: l丨Li1LL.IL1Iii.ILil.IL1Iii.ll丨L1ii, reason: invalid class name */
/* JADX INFO: compiled from: ZipEightByteInteger.java */
/* JADX INFO: loaded from: classes.dex */
public final class llL1ii {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final BigInteger f5520IL1Iii;

    static {
        new llL1ii(0L);
    }

    public llL1ii(long j) {
        this(BigInteger.valueOf(j));
    }

    public static byte[] ILil(BigInteger bigInteger) {
        long jLongValue = bigInteger.longValue();
        byte[] bArr = {(byte) (255 & jLongValue), (byte) ((65280 & jLongValue) >> 8), (byte) ((16711680 & jLongValue) >> 16), (byte) ((4278190080L & jLongValue) >> 24), (byte) ((1095216660480L & jLongValue) >> 32), (byte) ((280375465082880L & jLongValue) >> 40), (byte) ((71776119061217280L & jLongValue) >> 48), (byte) ((jLongValue & 9151314442816847872L) >> 56)};
        if (bigInteger.testBit(63)) {
            bArr[7] = (byte) (bArr[7] | (-128));
        }
        return bArr;
    }

    public static long Ilil(byte[] bArr, int i) {
        return m3644iILLL1(bArr, i).longValue();
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static long m3643IL(byte[] bArr) {
        return Ilil(bArr, 0);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static BigInteger m3644iILLL1(byte[] bArr, int i) {
        int i2 = i + 7;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(((((long) bArr[i2]) << 56) & 9151314442816847872L) + ((((long) bArr[i + 6]) << 48) & 71776119061217280L) + ((((long) bArr[i + 5]) << 40) & 280375465082880L) + ((((long) bArr[i + 4]) << 32) & 1095216660480L) + ((((long) bArr[i + 3]) << 24) & 4278190080L) + ((((long) bArr[i + 2]) << 16) & 16711680) + ((((long) bArr[i + 1]) << 8) & 65280) + (((long) bArr[i]) & 255));
        return (bArr[i2] & (-128)) == -128 ? bigIntegerValueOf.setBit(63) : bigIntegerValueOf;
    }

    public long I1I() {
        return this.f5520IL1Iii.longValue();
    }

    public byte[] IL1Iii() {
        return ILil(this.f5520IL1Iii);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof llL1ii)) {
            return false;
        }
        return this.f5520IL1Iii.equals(((llL1ii) obj).m3645lLi1LL());
    }

    public int hashCode() {
        return this.f5520IL1Iii.hashCode();
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public BigInteger m3645lLi1LL() {
        return this.f5520IL1Iii;
    }

    public String toString() {
        return "ZipEightByteInteger value: " + this.f5520IL1Iii;
    }

    public llL1ii(BigInteger bigInteger) {
        this.f5520IL1Iii = bigInteger;
    }

    public llL1ii(byte[] bArr, int i) {
        this.f5520IL1Iii = m3644iILLL1(bArr, i);
    }
}
