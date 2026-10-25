package org.opencv.core;

import I1I.IL1Iii;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MatOfFloat6 extends Mat {
    private static final int _channels = 6;
    private static final int _depth = 5;

    public MatOfFloat6() {
    }

    public static MatOfFloat6 fromNativeAddr(long j) {
        return new MatOfFloat6(j);
    }

    public void alloc(int i) {
        if (i > 0) {
            super.create(i, 1, CvType.makeType(5, 6));
        }
    }

    public void fromArray(float... fArr) {
        if (fArr == null || fArr.length == 0) {
            return;
        }
        alloc(fArr.length / 6);
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
        int iCheckVector = checkVector(6, 5);
        if (iCheckVector < 0) {
            throw new RuntimeException(IL1Iii.IL1Iii(new byte[]{120, 3, 18, 92, 19, 1, 22, 47, 7, 65, 69, 12, 87, 17, 70, 64, 11, 1, 78, 18, 3, 86, 17, 1, 82, 66, 18, 76, 21, 1, 22, 13, 20, 21, 22, 13, 76, 7, 92, 21}, IL1Iii.IL1Iii(new byte[]{4, 81, 95, 1, 1, 5}, IL1Iii.IL1Iii(new byte[]{84, 85, 15, 2, 1, 7}, "ff66ef"))) + toString());
        }
        float[] fArr = new float[iCheckVector * 6];
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

    public MatOfFloat6(long j) {
        super(j);
        if (!empty() && checkVector(6, 5) < 0) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{125, 88, 6, 90, 8, 18, 85, 66, 12, 87, 9, 7, 20, 123, 4, 65}, IL1Iii.IL1Iii(new byte[]{6, 4, 92, 6, 82, 7}, IL1Iii.IL1Iii(new byte[]{0, 80, 15, 10, 0, 6}, "2b697c"))));
        }
    }

    public MatOfFloat6(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(6, 5) < 0) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{124, 89, 7, 9, 85, 69, 84, 67, 13, 4, 84, 80, 21, 122, 5, 18}, IL1Iii.IL1Iii(new byte[]{1, 81, 86, 82, 93, 2}, IL1Iii.IL1Iii(new byte[]{80, 2, 11, 81, 85, 0}, "dd9e07"))));
        }
    }

    public MatOfFloat6(float... fArr) {
        fromArray(fArr);
    }
}
