package org.opencv.core;

import I1I.IL1Iii;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MatOfPoint2f extends Mat {
    private static final int _channels = 2;
    private static final int _depth = 5;

    public MatOfPoint2f() {
    }

    public static MatOfPoint2f fromNativeAddr(long j) {
        return new MatOfPoint2f(j);
    }

    public void alloc(int i) {
        if (i > 0) {
            super.create(i, 1, CvType.makeType(5, 2));
        }
    }

    public void fromArray(Point... pointArr) {
        if (pointArr == null || pointArr.length == 0) {
            return;
        }
        int length = pointArr.length;
        alloc(length);
        float[] fArr = new float[length * 2];
        for (int i = 0; i < length; i++) {
            Point point = pointArr[i];
            int i2 = i * 2;
            fArr[i2 + 0] = (float) point.f898x;
            fArr[i2 + 1] = (float) point.f899y;
        }
        put(0, 0, fArr);
    }

    public void fromList(List<Point> list) {
        fromArray((Point[]) list.toArray(new Point[0]));
    }

    public Point[] toArray() {
        int i = (int) total();
        Point[] pointArr = new Point[i];
        if (i == 0) {
            return pointArr;
        }
        float[] fArr = new float[i * 2];
        get(0, 0, fArr);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * 2;
            pointArr[i2] = new Point(fArr[i3], fArr[i3 + 1]);
        }
        return pointArr;
    }

    public List<Point> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfPoint2f(long j) {
        super(j);
        if (!empty() && checkVector(2, 5) < 0) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{123, 15, 1, 13, 11, 21, 83, 21, 11, 0, 10, 0, 18, 44, 3, 22}, IL1Iii.IL1Iii(new byte[]{3, 84, 6, 83, 3, 81}, IL1Iii.IL1Iii(new byte[]{8, 7, 93, 8, 1, 2}, "9299d6"))));
        }
    }

    public MatOfPoint2f(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(2, 5) < 0) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{121, 89, 90, 92, 14, 70, 81, 67, 80, 81, 15, 83, 16, 122, 88, 71}, IL1Iii.IL1Iii(new byte[]{3, 3, 8, 10, 0, 83}, IL1Iii.IL1Iii(new byte[]{81, 4, 9, 92, 6, 81}, "b08ee4"))));
        }
    }

    public MatOfPoint2f(Point... pointArr) {
        fromArray(pointArr);
    }
}
