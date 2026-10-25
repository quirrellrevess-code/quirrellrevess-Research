package org.opencv.core;

import I1I.IL1Iii;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MatOfPoint3f extends Mat {
    private static final int _channels = 3;
    private static final int _depth = 5;

    public MatOfPoint3f() {
    }

    public static MatOfPoint3f fromNativeAddr(long j) {
        return new MatOfPoint3f(j);
    }

    public void alloc(int i) {
        if (i > 0) {
            super.create(i, 1, CvType.makeType(5, 3));
        }
    }

    public void fromArray(Point3... point3Arr) {
        if (point3Arr == null || point3Arr.length == 0) {
            return;
        }
        int length = point3Arr.length;
        alloc(length);
        float[] fArr = new float[length * 3];
        for (int i = 0; i < length; i++) {
            Point3 point3 = point3Arr[i];
            int i2 = i * 3;
            fArr[i2 + 0] = (float) point3.f900x;
            fArr[i2 + 1] = (float) point3.f901y;
            fArr[i2 + 2] = (float) point3.f902z;
        }
        put(0, 0, fArr);
    }

    public void fromList(List<Point3> list) {
        fromArray((Point3[]) list.toArray(new Point3[0]));
    }

    public Point3[] toArray() {
        int i = (int) total();
        Point3[] point3Arr = new Point3[i];
        if (i == 0) {
            return point3Arr;
        }
        float[] fArr = new float[i * 3];
        get(0, 0, fArr);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * 3;
            point3Arr[i2] = new Point3(fArr[i3], fArr[i3 + 1], fArr[i3 + 2]);
        }
        return point3Arr;
    }

    public List<Point3> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfPoint3f(long j) {
        super(j);
        if (!empty() && checkVector(3, 5) < 0) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{113, 8, 1, 95, 88, 71, 89, 18, 11, 82, 89, 82, 24, 43, 3, 68}, IL1Iii.IL1Iii(new byte[]{90, 84, 90, 7, 86, 6}, IL1Iii.IL1Iii(new byte[]{1, 80, 92, 2, 2, 0}, "cbd5a1"))));
        }
    }

    public MatOfPoint3f(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(3, 5) < 0) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{44, 12, 0, 13, 95, 66, 4, 22, 10, 0, 94, 87, 69, 47, 2, 22}, IL1Iii.IL1Iii(new byte[]{0, 7, 81, 86, 87, 3}, IL1Iii.IL1Iii(new byte[]{83, 83, 83, 86, 6, 83}, "66abcb"))));
        }
    }

    public MatOfPoint3f(Point3... point3Arr) {
        fromArray(point3Arr);
    }
}
