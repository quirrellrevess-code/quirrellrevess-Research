package org.opencv.core;

import I1I.IL1Iii;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MatOfFloat extends Mat {
    private static final int _channels = 1;
    private static final int _depth = 5;

    public MatOfFloat() {
    }

    public static MatOfFloat fromNativeAddr(long j) {
        return new MatOfFloat(j);
    }

    public void alloc(int i) {
        if (i > 0) {
            super.create(i, 1, CvType.makeType(5, 1));
        }
    }

    public void fromArray(float... fArr) {
        if (fArr == null || fArr.length == 0) {
            return;
        }
        alloc(fArr.length / 1);
        put(0, 0, fArr);
    }

    public void fromList(List<Float> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        Float[] fArr = (Float[]) list.toArray(new Float[0]);
        float[] fArr2 = new float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = fArr[i].floatValue();
        }
        fromArray(fArr2);
    }

    public float[] toArray() {
        int iCheckVector = checkVector(1, 5);
        if (iCheckVector < 0) {
            throw new RuntimeException(IL1Iii.IL1Iii(new byte[]{119, 82, 18, 11, 64, 0, 25, 126, 7, 22, 22, 13, 88, 64, 70, 23, 88, 0, 65, 67, 3, 1, 66, 0, 93, 19, 18, 27, 70, 0, 25, 92, 20, 66, 69, 12, 67, 86, 92, 66}, IL1Iii.IL1Iii(new byte[]{11, 5, 87, 84, 80, 4}, IL1Iii.IL1Iii(new byte[]{0, 1, 6, 87, 86, 5}, "277a0d"))) + toString());
        }
        float[] fArr = new float[iCheckVector * 1];
        if (iCheckVector == 0) {
            return fArr;
        }
        get(0, 0, fArr);
        return fArr;
    }

    public List<Float> toList() {
        float[] array = toArray();
        Float[] fArr = new Float[array.length];
        for (int i = 0; i < array.length; i++) {
            fArr[i] = Float.valueOf(array[i]);
        }
        return Arrays.asList(fArr);
    }

    public MatOfFloat(long j) {
        super(j);
        if (!empty() && checkVector(1, 5) < 0) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{40, 87, 0, 87, 89, 20, 0, 77, 10, 90, 88, 1, 65, 116, 2, 76}, IL1Iii.IL1Iii(new byte[]{81, 88, 84, 1, 86, 83}, IL1Iii.IL1Iii(new byte[]{81, 83, 3, 9, 91, 3}, "a24094"))));
        }
    }

    public MatOfFloat(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(1, 5) < 0) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{122, 88, 83, 87, 90, 17, 82, 66, 89, 90, 91, 4, 19, 123, 81, 76}, IL1Iii.IL1Iii(new byte[]{82, 82, 1, 14, 1, 7}, IL1Iii.IL1Iii(new byte[]{86, 83, 82, 85, 5, 86}, "77cc30"))));
        }
    }

    public MatOfFloat(float... fArr) {
        fromArray(fArr);
    }
}
