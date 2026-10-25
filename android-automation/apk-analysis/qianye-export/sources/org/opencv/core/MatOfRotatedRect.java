package org.opencv.core;

import I1I.IL1Iii;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MatOfRotatedRect extends Mat {
    private static final int _channels = 5;
    private static final int _depth = 5;

    public MatOfRotatedRect() {
    }

    public static MatOfRotatedRect fromNativeAddr(long j) {
        return new MatOfRotatedRect(j);
    }

    public void alloc(int i) {
        if (i > 0) {
            super.create(i, 1, CvType.makeType(5, 5));
        }
    }

    public void fromArray(RotatedRect... rotatedRectArr) {
        if (rotatedRectArr == null || rotatedRectArr.length == 0) {
            return;
        }
        int length = rotatedRectArr.length;
        alloc(length);
        float[] fArr = new float[length * 5];
        for (int i = 0; i < length; i++) {
            RotatedRect rotatedRect = rotatedRectArr[i];
            int i2 = i * 5;
            Point point = rotatedRect.center;
            fArr[i2 + 0] = (float) point.f898x;
            fArr[i2 + 1] = (float) point.f899y;
            Size size = rotatedRect.size;
            fArr[i2 + 2] = (float) size.width;
            fArr[i2 + 3] = (float) size.height;
            fArr[i2 + 4] = (float) rotatedRect.angle;
        }
        put(0, 0, fArr);
    }

    public void fromList(List<RotatedRect> list) {
        fromArray((RotatedRect[]) list.toArray(new RotatedRect[0]));
    }

    public RotatedRect[] toArray() {
        int i = (int) total();
        RotatedRect[] rotatedRectArr = new RotatedRect[i];
        if (i == 0) {
            return rotatedRectArr;
        }
        float[] fArr = new float[5];
        for (int i2 = 0; i2 < i; i2++) {
            get(i2, 0, fArr);
            rotatedRectArr[i2] = new RotatedRect(new Point(fArr[0], fArr[1]), new Size(fArr[2], fArr[3]), fArr[4]);
        }
        return rotatedRectArr;
    }

    public List<RotatedRect> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfRotatedRect(long j) {
        super(j);
        if (!empty() && checkVector(5, 5) < 0) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{125, 12, 86, 86, 84, 72, 85, 22, 92, 91, 85, 93, 20, 47, 84, 77}, IL1Iii.IL1Iii(new byte[]{87, 91, 13, 91, 14, 14}, IL1Iii.IL1Iii(new byte[]{80, 0, 13, 83, 7, 84}, "39510b"))));
        }
    }

    public MatOfRotatedRect(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(5, 5) < 0) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{123, 90, 1, 95, 9, 17, 83, 64, 11, 82, 8, 4, 18, 121, 3, 68}, IL1Iii.IL1Iii(new byte[]{86, 85, 82, 3, 5, 88}, IL1Iii.IL1Iii(new byte[]{93, 3, 81, 1, 89, 9}, "9ba280"))));
        }
    }

    public MatOfRotatedRect(RotatedRect... rotatedRectArr) {
        fromArray(rotatedRectArr);
    }
}
