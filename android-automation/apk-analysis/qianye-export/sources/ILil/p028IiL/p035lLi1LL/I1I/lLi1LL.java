package ILil.p028IiL.p035lLi1LL.I1I;

import java.lang.reflect.Array;

/* JADX INFO: renamed from: ILil.I丨iL.l丨Li1LL.I1I.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: GrowingArrayUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class lLi1LL {
    public static int I1I(int i) {
        if (i <= 4) {
            return 8;
        }
        return i * 2;
    }

    public static int[] IL1Iii(int[] iArr, int i, int i2) {
        if (i + 1 > iArr.length) {
            int[] iArr2 = new int[I1I(i)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr = iArr2;
        }
        iArr[i] = i2;
        return iArr;
    }

    public static <T> T[] ILil(T[] tArr, int i, T t) {
        if (i + 1 > tArr.length) {
            Object[] objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), I1I(i));
            System.arraycopy(tArr, 0, objArr, 0, i);
            tArr = (T[]) objArr;
        }
        tArr[i] = t;
        return tArr;
    }
}
