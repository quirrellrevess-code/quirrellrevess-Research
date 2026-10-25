package org.opencv.core;

import I1I.IL1Iii;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class MatOfByte extends Mat {
    private static final int _channels = 1;
    private static final int _depth = 0;

    public MatOfByte() {
    }

    public static MatOfByte fromNativeAddr(long j) {
        return new MatOfByte(j);
    }

    public void alloc(int i) {
        if (i > 0) {
            super.create(i, 1, CvType.makeType(0, 1));
        }
    }

    public void fromArray(byte... bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        alloc(bArr.length / 1);
        put(0, 0, bArr);
    }

    public void fromList(List<Byte> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        Byte[] bArr = (Byte[]) list.toArray(new Byte[0]);
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = bArr[i].byteValue();
        }
        fromArray(bArr2);
    }

    public byte[] toArray() {
        int iCheckVector = checkVector(1, 0);
        if (iCheckVector < 0) {
            throw new RuntimeException(IL1Iii.IL1Iii(new byte[]{122, 4, 66, 90, 20, 80, 20, 40, 87, 71, 66, 93, 85, 22, 22, 70, 12, 80, 76, 21, 83, 80, 22, 80, 80, 69, 66, 74, 18, 80, 20, 10, 68, 19, 17, 92, 78, 0, 12, 19}, IL1Iii.IL1Iii(new byte[]{4, 0, 87, 10, 91, 83}, IL1Iii.IL1Iii(new byte[]{0, 7, 3, 9, 92, 87}, "0bb0e1"))) + toString());
        }
        byte[] bArr = new byte[iCheckVector * 1];
        if (iCheckVector == 0) {
            return bArr;
        }
        get(0, 0, bArr);
        return bArr;
    }

    public List<Byte> toList() {
        byte[] array = toArray();
        Byte[] bArr = new Byte[array.length];
        for (int i = 0; i < array.length; i++) {
            bArr[i] = Byte.valueOf(array[i]);
        }
        return Arrays.asList(bArr);
    }

    public MatOfByte(long j) {
        super(j);
        if (!empty() && checkVector(1, 0) < 0) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{126, 92, 0, 95, 88, 67, 86, 70, 10, 82, 89, 86, 23, 127, 2, 68}, IL1Iii.IL1Iii(new byte[]{5, 2, 5, 7, 80, 5}, IL1Iii.IL1Iii(new byte[]{83, 1, 94, 84, 7, 87}, "a18cba"))));
        }
    }

    public MatOfByte(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(1, 0) < 0) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{40, 91, 1, 87, 12, 19, 0, 65, 11, 90, 13, 6, 65, 120, 3, 76}, IL1Iii.IL1Iii(new byte[]{87, 86, 4, 0, 87, 83}, IL1Iii.IL1Iii(new byte[]{14, 84, 95, 89, 3, 82}, "879a5b"))));
        }
    }

    public void fromArray(int i, int i2, byte... bArr) {
        if (i >= 0) {
            Objects.requireNonNull(bArr);
            if (i2 >= 0 && i2 + i <= bArr.length) {
                if (bArr.length == 0) {
                    return;
                }
                alloc(i2 / 1);
                put(0, 0, bArr, i, i2);
                return;
            }
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{11, 88, 19, 84, 84, 10, 6, 22, 66, 89, 93, 13, 5, 66, 13, 18, 24, 19, 3, 68, 4, 88, 93, 23, 7, 68, 95, 21}, IL1Iii.IL1Iii(new byte[]{84, 82, 84, 83, 0, 83}, IL1Iii.IL1Iii(new byte[]{87, 84, 8, 86, 90, 86}, "a090bf"))) + Integer.toString(i2));
        }
        throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{9, 5, 4, 74, 86, 64, 70, 95, 66, 9}, IL1Iii.IL1Iii(new byte[]{81, 81, 7, 10, 10, 3}, IL1Iii.IL1Iii(new byte[]{0, 11, 82, 4, 95, 1}, "7977f6"))));
    }

    public MatOfByte(byte... bArr) {
        fromArray(bArr);
    }

    public MatOfByte(int i, int i2, byte... bArr) {
        fromArray(i, i2, bArr);
    }
}
