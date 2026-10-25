package org.opencv.core;

import I1I.IL1Iii;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MatOfDMatch extends Mat {
    private static final int _channels = 4;
    private static final int _depth = 5;

    public MatOfDMatch() {
    }

    public static MatOfDMatch fromNativeAddr(long j) {
        return new MatOfDMatch(j);
    }

    public void alloc(int i) {
        if (i > 0) {
            super.create(i, 1, CvType.makeType(5, 4));
        }
    }

    public void fromArray(DMatch... dMatchArr) {
        if (dMatchArr == null || dMatchArr.length == 0) {
            return;
        }
        int length = dMatchArr.length;
        alloc(length);
        float[] fArr = new float[length * 4];
        for (int i = 0; i < length; i++) {
            DMatch dMatch = dMatchArr[i];
            int i2 = i * 4;
            fArr[i2 + 0] = dMatch.queryIdx;
            fArr[i2 + 1] = dMatch.trainIdx;
            fArr[i2 + 2] = dMatch.imgIdx;
            fArr[i2 + 3] = dMatch.distance;
        }
        put(0, 0, fArr);
    }

    public void fromList(List<DMatch> list) {
        fromArray((DMatch[]) list.toArray(new DMatch[0]));
    }

    public DMatch[] toArray() {
        int i = (int) total();
        DMatch[] dMatchArr = new DMatch[i];
        if (i == 0) {
            return dMatchArr;
        }
        float[] fArr = new float[i * 4];
        get(0, 0, fArr);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * 4;
            dMatchArr[i2] = new DMatch((int) fArr[i3 + 0], (int) fArr[i3 + 1], (int) fArr[i3 + 2], fArr[i3 + 3]);
        }
        return dMatchArr;
    }

    public List<DMatch> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfDMatch(long j) {
        super(j);
        if (empty() || checkVector(4, 5) >= 0) {
            return;
        }
        throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{127, 91, 5, 95, 94, 73, 87, 65, 15, 82, 95, 92, 22, 120, 7, 68, 9, 25}, IL1Iii.IL1Iii(new byte[]{7, 0, 5, 3, 2, 0}, IL1Iii.IL1Iii(new byte[]{1, 87, 87, 86, 3, 11}, "0b4e22"))) + toString());
    }

    public MatOfDMatch(Mat mat) {
        super(mat, Range.all());
        if (empty() || checkVector(4, 5) >= 0) {
            return;
        }
        throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{123, 86, 80, 95, 94, 17, 83, 76, 90, 82, 95, 4, 18, 117, 82, 68, 9, 65}, IL1Iii.IL1Iii(new byte[]{3, 15, 10, 5, 0, 81}, IL1Iii.IL1Iii(new byte[]{8, 81, 93, 86, 6, 85}, "9fdc5e"))) + toString());
    }

    public MatOfDMatch(DMatch... dMatchArr) {
        fromArray(dMatchArr);
    }
}
