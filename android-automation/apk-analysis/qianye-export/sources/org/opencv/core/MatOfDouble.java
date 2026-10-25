package org.opencv.core;

import I1I.IL1Iii;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MatOfDouble extends Mat {
    private static final int _channels = 1;
    private static final int _depth = 6;

    public MatOfDouble() {
    }

    public static MatOfDouble fromNativeAddr(long j) {
        return new MatOfDouble(j);
    }

    public void alloc(int i) {
        if (i > 0) {
            super.create(i, 1, CvType.makeType(6, 1));
        }
    }

    public void fromArray(double... dArr) {
        if (dArr == null || dArr.length == 0) {
            return;
        }
        alloc(dArr.length / 1);
        put(0, 0, dArr);
    }

    public void fromList(List<Double> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        Double[] dArr = (Double[]) list.toArray(new Double[0]);
        double[] dArr2 = new double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = dArr[i].doubleValue();
        }
        fromArray(dArr2);
    }

    public double[] toArray() {
        int iCheckVector = checkVector(1, 6);
        if (iCheckVector < 0) {
            throw new RuntimeException(IL1Iii.IL1Iii(new byte[]{124, 88, 64, 89, 79, 0, 18, 116, 85, 68, 25, 13, 83, 74, 20, 69, 87, 0, 74, 73, 81, 83, 77, 0, 86, 25, 64, 73, 73, 0, 18, 86, 70, 16, 74, 12, 72, 92, 14, 16}, IL1Iii.IL1Iii(new byte[]{84, 13, 7, 6, 93, 86}, IL1Iii.IL1Iii(new byte[]{86, 3, 1, 80, 83, 0}, "072f73"))) + toString());
        }
        double[] dArr = new double[iCheckVector * 1];
        if (iCheckVector == 0) {
            return dArr;
        }
        get(0, 0, dArr);
        return dArr;
    }

    public List<Double> toList() {
        double[] array = toArray();
        Double[] dArr = new Double[array.length];
        for (int i = 0; i < array.length; i++) {
            dArr[i] = Double.valueOf(array[i]);
        }
        return Arrays.asList(dArr);
    }

    public MatOfDouble(long j) {
        super(j);
        if (!empty() && checkVector(1, 6) < 0) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{122, 12, 84, 11, 9, 70, 82, 22, 94, 6, 8, 83, 19, 47, 86, 16}, IL1Iii.IL1Iii(new byte[]{7, 6, 0, 2, 0, 80}, IL1Iii.IL1Iii(new byte[]{87, 80, 86, 85, 82, 80}, "c4a366"))));
        }
    }

    public MatOfDouble(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(1, 6) < 0) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{121, 89, 2, 10, 90, 20, 81, 67, 8, 7, 91, 1, 16, 122, 0, 17}, IL1Iii.IL1Iii(new byte[]{4, 81, 2, 3, 83, 92}, IL1Iii.IL1Iii(new byte[]{5, 87, 87, 87, 93, 15}, "114197"))));
        }
    }

    public MatOfDouble(double... dArr) {
        fromArray(dArr);
    }
}
