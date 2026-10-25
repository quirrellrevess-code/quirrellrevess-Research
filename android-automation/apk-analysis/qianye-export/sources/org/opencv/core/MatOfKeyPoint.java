package org.opencv.core;

import I1I.IL1Iii;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MatOfKeyPoint extends Mat {
    private static final int _channels = 7;
    private static final int _depth = 5;

    public MatOfKeyPoint() {
    }

    public static MatOfKeyPoint fromNativeAddr(long j) {
        return new MatOfKeyPoint(j);
    }

    public void alloc(int i) {
        if (i > 0) {
            super.create(i, 1, CvType.makeType(5, 7));
        }
    }

    public void fromArray(KeyPoint... keyPointArr) {
        if (keyPointArr == null || keyPointArr.length == 0) {
            return;
        }
        int length = keyPointArr.length;
        alloc(length);
        float[] fArr = new float[length * 7];
        for (int i = 0; i < length; i++) {
            KeyPoint keyPoint = keyPointArr[i];
            int i2 = i * 7;
            Point point = keyPoint.f888pt;
            fArr[i2 + 0] = (float) point.f898x;
            fArr[i2 + 1] = (float) point.f899y;
            fArr[i2 + 2] = keyPoint.size;
            fArr[i2 + 3] = keyPoint.angle;
            fArr[i2 + 4] = keyPoint.response;
            fArr[i2 + 5] = keyPoint.octave;
            fArr[i2 + 6] = keyPoint.class_id;
        }
        put(0, 0, fArr);
    }

    public void fromList(List<KeyPoint> list) {
        fromArray((KeyPoint[]) list.toArray(new KeyPoint[0]));
    }

    public KeyPoint[] toArray() {
        int i = (int) total();
        KeyPoint[] keyPointArr = new KeyPoint[i];
        if (i == 0) {
            return keyPointArr;
        }
        float[] fArr = new float[i * 7];
        get(0, 0, fArr);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * 7;
            keyPointArr[i2] = new KeyPoint(fArr[i3 + 0], fArr[i3 + 1], fArr[i3 + 2], fArr[i3 + 3], fArr[i3 + 4], (int) fArr[i3 + 5], (int) fArr[i3 + 6]);
        }
        return keyPointArr;
    }

    public List<KeyPoint> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfKeyPoint(long j) {
        super(j);
        if (!empty() && checkVector(7, 5) < 0) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{121, 86, 6, 93, 85, 19, 81, 76, 12, 80, 84, 6, 16, 117, 4, 70}, IL1Iii.IL1Iii(new byte[]{83, 9, 93, 86, 12, 2}, IL1Iii.IL1Iii(new byte[]{2, 85, 12, 86, 0, 80}, "ad4241"))));
        }
    }

    public MatOfKeyPoint(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(7, 5) < 0) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{127, 86, 83, 86, 95, 68, 87, 76, 89, 91, 94, 81, 22, 117, 81, 77}, IL1Iii.IL1Iii(new byte[]{4, 10, 85, 95, 86, 81}, IL1Iii.IL1Iii(new byte[]{7, 83, 7, 86, 7, 86}, "5ab0c3"))));
        }
    }

    public MatOfKeyPoint(KeyPoint... keyPointArr) {
        fromArray(keyPointArr);
    }
}
