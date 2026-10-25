package org.opencv.core;

import I1I.IL1Iii;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MatOfInt extends Mat {
    private static final int _channels = 1;
    private static final int _depth = 4;

    public MatOfInt() {
    }

    public static MatOfInt fromNativeAddr(long j) {
        return new MatOfInt(j);
    }

    public void alloc(int i) {
        if (i > 0) {
            super.create(i, 1, CvType.makeType(4, 1));
        }
    }

    public void fromArray(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        alloc(iArr.length / 1);
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
        int iCheckVector = checkVector(1, 4);
        if (iCheckVector < 0) {
            throw new RuntimeException(IL1Iii.IL1Iii(new byte[]{124, 80, 17, 12, 64, 3, 18, 124, 4, 17, 22, 14, 83, 66, 69, 16, 88, 3, 74, 65, 0, 6, 66, 3, 86, 17, 17, 28, 70, 3, 18, 94, 23, 69, 69, 15, 72, 84, 95, 69}, IL1Iii.IL1Iii(new byte[]{11, 83, 85, 3, 82, 95}, IL1Iii.IL1Iii(new byte[]{13, 81, 3, 85, 92, 1}, "433388"))) + toString());
        }
        int[] iArr = new int[iCheckVector * 1];
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

    public MatOfInt(long j) {
        super(j);
        if (!empty() && checkVector(1, 4) < 0) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{42, 8, 83, 10, 91, 69, 2, 18, 89, 7, 90, 80, 67, 43, 81, 17}, IL1Iii.IL1Iii(new byte[]{7, 94, 4, 0, 84, 5}, IL1Iii.IL1Iii(new byte[]{83, 93, 2, 4, 83, 3}, "7e6a13"))));
        }
    }

    public MatOfInt(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(1, 4) < 0) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{125, 90, 80, 95, 84, 21, 85, 64, 90, 82, 85, 0, 20, 121, 82, 68}, IL1Iii.IL1Iii(new byte[]{85, 2, 4, 3, 13, 86}, IL1Iii.IL1Iii(new byte[]{3, 1, 81, 85, 87, 85}, "b7ffcf"))));
        }
    }

    public MatOfInt(int... iArr) {
        fromArray(iArr);
    }
}
