package org.opencv.core;

import I1I.IL1Iii;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MatOfPoint extends Mat {
    private static final int _channels = 2;
    private static final int _depth = 4;

    public MatOfPoint() {
    }

    public static MatOfPoint fromNativeAddr(long j) {
        return new MatOfPoint(j);
    }

    public void alloc(int i) {
        if (i > 0) {
            super.create(i, 1, CvType.makeType(4, 2));
        }
    }

    public void fromArray(Point... pointArr) {
        if (pointArr == null || pointArr.length == 0) {
            return;
        }
        int length = pointArr.length;
        alloc(length);
        int[] iArr = new int[length * 2];
        for (int i = 0; i < length; i++) {
            Point point = pointArr[i];
            int i2 = i * 2;
            iArr[i2 + 0] = (int) point.f898x;
            iArr[i2 + 1] = (int) point.f899y;
        }
        put(0, 0, iArr);
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
        int[] iArr = new int[i * 2];
        get(0, 0, iArr);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * 2;
            pointArr[i2] = new Point(iArr[i3], iArr[i3 + 1]);
        }
        return pointArr;
    }

    public List<Point> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfPoint(long j) {
        super(j);
        if (!empty() && checkVector(2, 4) < 0) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{120, 90, 5, 86, 88, 70, 80, 64, 15, 91, 89, 83, 17, 121, 7, 77}, IL1Iii.IL1Iii(new byte[]{1, 5, 87, 95, 6, 0}, IL1Iii.IL1Iii(new byte[]{5, 80, 82, 80, 6, 83}, "5ac65e"))));
        }
    }

    public MatOfPoint(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(2, 4) < 0) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{40, 86, 85, 86, 92, 22, 0, 76, 95, 91, 93, 3, 65, 117, 87, 77}, IL1Iii.IL1Iii(new byte[]{2, 1, 0, 91, 80, 7}, IL1Iii.IL1Iii(new byte[]{81, 92, 3, 82, 87, 86}, "2e5067"))));
        }
    }

    public MatOfPoint(Point... pointArr) {
        fromArray(pointArr);
    }
}
