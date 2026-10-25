package p066Ilil;

import com.tencent.smtt.export.external.interfaces.ISelectionInterface;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: Util.java */
/* JADX INFO: loaded from: classes.dex */
public final class I11L {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final Charset f4558IL1Iii = Charset.forName("UTF-8");

    public static int I1I(int i) {
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    public static boolean IL1Iii(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }

    public static void ILil(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)));
        }
    }

    public static void Ilil(Throwable th) throws Throwable {
        m2769lLi1LL(th);
        throw null;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static short m2768IL(short s) {
        int i = s & ISelectionInterface.HELD_NOTHING;
        return (short) (((i & 255) << 8) | ((65280 & i) >>> 8));
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static <T extends Throwable> void m2769lLi1LL(Throwable th) throws Throwable {
        throw th;
    }
}
