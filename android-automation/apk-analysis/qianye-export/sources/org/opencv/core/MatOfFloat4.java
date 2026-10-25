package org.opencv.core;

import I1I.IL1Iii;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MatOfFloat4 extends Mat {
    private static final int _channels = 4;
    private static final int _depth = 5;

    public MatOfFloat4() {
    }

    public static MatOfFloat4 fromNativeAddr(long j) {
        return new MatOfFloat4(j);
    }

    public void alloc(int i) {
        if (i > 0) {
            super.create(i, 1, CvType.makeType(5, 4));
        }
    }

    public void fromArray(float... fArr) {
        if (fArr == null || fArr.length == 0) {
            return;
        }
        alloc(fArr.length / 4);
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
        int iCheckVector = checkVector(4, 5);
        if (iCheckVector < 0) {
            throw new RuntimeException(IL1Iii.IL1Iii(new byte[]{125, 89, 18, 10, 66, 84, 19, 117, 7, 23, 20, 89, 82, 75, 70, 22, 90, 84, 75, 72, 3, 0, 64, 84, 87, 24, 18, 26, 68, 84, 19, 87, 20, 67, 71, 88, 73, 93, 92, 67}, IL1Iii.IL1Iii(new byte[]{82, 92, 81, 7, 7, 7}, IL1Iii.IL1Iii(new byte[]{82, 81, 85, 5, 10, 83}, "35ba9e"))) + toString());
        }
        float[] fArr = new float[iCheckVector * 4];
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

    public MatOfFloat4(long j) {
        super(j);
        if (!empty() && checkVector(4, 5) < 0) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{127, 11, 85, 9, 95, 19, 87, 17, 95, 4, 94, 6, 22, 40, 87, 18}, IL1Iii.IL1Iii(new byte[]{14, 3, 14, 95, 7, 0}, IL1Iii.IL1Iii(new byte[]{8, 87, 0, 95, 0, 0}, "018f5c"))));
        }
    }

    public MatOfFloat4(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(4, 5) < 0) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{47, 92, 81, 94, 92, 22, 7, 70, 91, 83, 93, 3, 70, 127, 83, 69}, IL1Iii.IL1Iii(new byte[]{84, 11, 11, 3, 1, 82}, IL1Iii.IL1Iii(new byte[]{4, 93, 95, 1, 8, 3}, "6df387"))));
        }
    }

    public MatOfFloat4(float... fArr) {
        fromArray(fArr);
    }
}
