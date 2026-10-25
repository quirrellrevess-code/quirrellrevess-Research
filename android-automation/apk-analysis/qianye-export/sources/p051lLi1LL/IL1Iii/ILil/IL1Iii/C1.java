package p051lLi1LL.IL1Iii.ILil.IL1Iii;

import java.io.IOException;
import java.util.Calendar;
import java.util.zip.CRC32;

/* JADX INFO: renamed from: l丨Li1LL.IL1Iii.ILil.IL1Iii.丨丨丨1丨, reason: invalid class name */
/* JADX INFO: compiled from: ZipUtil.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class C1 {
    static {
        I11L.ILil(8448L);
    }

    public static long I1I(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, ((int) ((j >> 25) & 127)) + 1980);
        calendar.set(2, ((int) ((j >> 21) & 15)) - 1);
        calendar.set(5, ((int) (j >> 16)) & 31);
        calendar.set(11, ((int) (j >> 11)) & 31);
        calendar.set(12, ((int) (j >> 5)) & 63);
        calendar.set(13, ((int) (j << 1)) & 62);
        return calendar.getTime().getTime();
    }

    public static void IL1Iii(iIlLiL iillil) throws Lil {
        if (!m3660lLi1LL(iillil)) {
            throw new Lil(Lil.IL1Iii.f5498ILil, iillil);
        }
        if (!m3659iILLL1(iillil)) {
            throw new Lil(Lil.IL1Iii.f5497I1I, iillil);
        }
    }

    public static byte[] ILil(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public static void Ilil(iIlLiL iillil, byte[] bArr, byte[] bArr2) {
        String strM3658IL;
        Ll1 ll1 = (Ll1) iillil.m3631IL(Ll1.f5503Ilil);
        String name = iillil.getName();
        String strM3658IL2 = m3658IL(ll1, bArr);
        if (strM3658IL2 != null && !name.equals(strM3658IL2)) {
            iillil.m3636lIlii(strM3658IL2);
        }
        if (bArr2 == null || bArr2.length <= 0 || (strM3658IL = m3658IL((ILL) iillil.m3631IL(ILL.f5486Ilil), bArr2)) == null) {
            return;
        }
        iillil.setComment(strM3658IL);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static String m3658IL(IL1Iii iL1Iii, byte[] bArr) {
        if (iL1Iii != null) {
            CRC32 crc32 = new CRC32();
            crc32.update(bArr);
            if (crc32.getValue() == iL1Iii.m3612L11I()) {
                try {
                    return iIi1.f5506ILil.IL1Iii(iL1Iii.m3613il());
                } catch (IOException unused) {
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static boolean m3659iILLL1(iIlLiL iillil) {
        return iillil.getMethod() == 0 || iillil.getMethod() == 8;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static boolean m3660lLi1LL(iIlLiL iillil) {
        return !iillil.m3638lLi1LL().m3642lLi1LL();
    }
}
