package ILil.p065Ilil;

/* JADX INFO: renamed from: ILil.Ilil.IL丨丨l, reason: invalid class name */
/* JADX INFO: compiled from: ContainerHelpers.java */
/* JADX INFO: loaded from: classes.dex */
public class ILl {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final int[] f3959IL1Iii = new int[0];

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final long[] f3960ILil = new long[0];

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final Object[] f3958I1I = new Object[0];

    public static boolean I1I(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int IL1Iii(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else {
                if (i6 <= i2) {
                    return i5;
                }
                i3 = i5 - 1;
            }
        }
        return ~i4;
    }

    public static int ILil(long[] jArr, int i, long j) {
        int i2 = i - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            long j2 = jArr[i4];
            if (j2 < j) {
                i3 = i4 + 1;
            } else {
                if (j2 <= j) {
                    return i4;
                }
                i2 = i4 - 1;
            }
        }
        return ~i3;
    }

    public static int Ilil(int i) {
        return m1939IL(i * 4) / 4;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static int m1939IL(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                return i3;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static int m1940lLi1LL(int i) {
        return m1939IL(i * 8) / 8;
    }
}
