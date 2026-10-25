package org.opencv.core;

import I1I.IL1Iii;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MatOfRect2d extends Mat {
    private static final int _channels = 4;
    private static final int _depth = 6;

    public MatOfRect2d() {
    }

    public static MatOfRect2d fromNativeAddr(long j) {
        return new MatOfRect2d(j);
    }

    public void alloc(int i) {
        if (i > 0) {
            super.create(i, 1, CvType.makeType(6, 4));
        }
    }

    public void fromArray(Rect2d... rect2dArr) {
        if (rect2dArr == null || rect2dArr.length == 0) {
            return;
        }
        int length = rect2dArr.length;
        alloc(length);
        double[] dArr = new double[length * 4];
        for (int i = 0; i < length; i++) {
            Rect2d rect2d = rect2dArr[i];
            int i2 = i * 4;
            dArr[i2 + 0] = rect2d.f905x;
            dArr[i2 + 1] = rect2d.f906y;
            dArr[i2 + 2] = rect2d.width;
            dArr[i2 + 3] = rect2d.height;
        }
        put(0, 0, dArr);
    }

    public void fromList(List<Rect2d> list) {
        fromArray((Rect2d[]) list.toArray(new Rect2d[0]));
    }

    public Rect2d[] toArray() {
        int i = (int) total();
        Rect2d[] rect2dArr = new Rect2d[i];
        if (i == 0) {
            return rect2dArr;
        }
        double[] dArr = new double[i * 4];
        get(0, 0, dArr);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * 4;
            rect2dArr[i2] = new Rect2d(dArr[i3], dArr[i3 + 1], dArr[i3 + 2], dArr[i3 + 3]);
        }
        return rect2dArr;
    }

    public List<Rect2d> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfRect2d(long j) {
        super(j);
        if (!empty() && checkVector(4, 6) < 0) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{126, 95, 86, 86, 92, 69, 86, 69, 92, 91, 93, 80, 23, 124, 84, 77}, IL1Iii.IL1Iii(new byte[]{3, 80, 84, 95, 83, 12}, IL1Iii.IL1Iii(new byte[]{0, 0, 85, 7, 80, 10}, "4a4a23"))));
        }
    }

    public MatOfRect2d(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(4, 6) < 0) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{44, 11, 2, 91, 93, 73, 4, 17, 8, 86, 92, 92, 69, 40, 0, 64}, IL1Iii.IL1Iii(new byte[]{86, 93, 7, 87, 81, 91}, IL1Iii.IL1Iii(new byte[]{85, 89, 3, 83, 80, 1}, "fae01c"))));
        }
    }

    public MatOfRect2d(Rect2d... rect2dArr) {
        fromArray(rect2dArr);
    }
}
