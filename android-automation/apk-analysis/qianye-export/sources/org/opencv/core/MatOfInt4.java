package org.opencv.core;

import I1I.IL1Iii;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MatOfInt4 extends Mat {
    private static final int _channels = 4;
    private static final int _depth = 4;

    public MatOfInt4() {
    }

    public static MatOfInt4 fromNativeAddr(long j) {
        return new MatOfInt4(j);
    }

    public void alloc(int i) {
        if (i > 0) {
            super.create(i, 1, CvType.makeType(4, 4));
        }
    }

    public void fromArray(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        alloc(iArr.length / 4);
        put(0, 0, iArr);
    }

    public void fromList(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        Integer[] numArr = (Integer[]) list.toArray(new Integer[0]);
        int[] iArr = new int[numArr.length];
        for (int i = 0; i < numArr.length; i++) {
            iArr[i] = numArr[i].intValue();
        }
        fromArray(iArr);
    }

    public int[] toArray() {
        int iCheckVector = checkVector(4, 4);
        if (iCheckVector < 0) {
            throw new RuntimeException(IL1Iii.IL1Iii(new byte[]{127, 86, 16, 90, 70, 87, 17, 122, 5, 71, 16, 90, 80, 68, 68, 70, 94, 87, 73, 71, 1, 80, 68, 87, 85, 23, 16, 74, 64, 87, 17, 88, 22, 19, 67, 91, 75, 82, 94, 19}, IL1Iii.IL1Iii(new byte[]{3, 7, 85, 87, 8, 5}, IL1Iii.IL1Iii(new byte[]{1, 83, 1, 82, 89, 83}, "3c06ad"))) + toString());
        }
        int[] iArr = new int[iCheckVector * 4];
        if (iCheckVector == 0) {
            return iArr;
        }
        get(0, 0, iArr);
        return iArr;
    }

    public List<Integer> toList() {
        int[] array = toArray();
        Integer[] numArr = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            numArr[i] = Integer.valueOf(array[i]);
        }
        return Arrays.asList(numArr);
    }

    public MatOfInt4(long j) {
        super(j);
        if (!empty() && checkVector(4, 4) < 0) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{45, 8, 84, 87, 95, 19, 5, 18, 94, 90, 94, 6, 68, 43, 86, 76}, IL1Iii.IL1Iii(new byte[]{81, 86, 84, 1, 5, 90}, IL1Iii.IL1Iii(new byte[]{3, 85, 85, 10, 82, 88}, "6e63ea"))));
        }
    }

    public MatOfInt4(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(4, 4) < 0) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{42, 11, 90, 94, 88, 19, 2, 17, 80, 83, 89, 6, 67, 40, 88, 69}, IL1Iii.IL1Iii(new byte[]{87, 84, 13, 4, 5, 85}, IL1Iii.IL1Iii(new byte[]{87, 80, 81, 1, 3, 83}, "cae43e"))));
        }
    }

    public MatOfInt4(int... iArr) {
        fromArray(iArr);
    }
}
