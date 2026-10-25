package com.mysql.jdbc.util;

/* JADX INFO: loaded from: classes.dex */
public class Base64Decoder {
    private static byte[] decoderMap = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    public static class IntWrapper {
        public int value;

        public IntWrapper(int i) {
            this.value = i;
        }
    }

    public static byte[] decode(byte[] bArr, int i, int i2) {
        IntWrapper intWrapper = new IntWrapper(i);
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[(i2 * 3) / 4];
        int i3 = (intWrapper.value + i2) - 1;
        int i4 = 0;
        while (intWrapper.value <= i3) {
            bArr2[0] = decoderMap[getNextValidByte(bArr, intWrapper, i3)];
            bArr2[1] = decoderMap[getNextValidByte(bArr, intWrapper, i3)];
            bArr2[2] = decoderMap[getNextValidByte(bArr, intWrapper, i3)];
            bArr2[3] = decoderMap[getNextValidByte(bArr, intWrapper, i3)];
            if (bArr2[1] != -2) {
                bArr3[i4] = (byte) ((bArr2[0] << 2) | (bArr2[1] >>> 4));
                i4++;
            }
            if (bArr2[2] != -2) {
                bArr3[i4] = (byte) (((bArr2[1] & 15) << 4) | (bArr2[2] >>> 2));
                i4++;
            }
            if (bArr2[3] != -2) {
                bArr3[i4] = (byte) (((bArr2[2] & 3) << 6) | bArr2[3]);
                i4++;
            }
        }
        byte[] bArr4 = new byte[i4];
        System.arraycopy(bArr3, 0, bArr4, 0, i4);
        return bArr4;
    }

    private static byte getNextValidByte(byte[] bArr, IntWrapper intWrapper, int i) {
        while (true) {
            int i2 = intWrapper.value;
            if (i2 > i) {
                return (byte) 61;
            }
            if (bArr[i2] >= 0 && decoderMap[bArr[i2]] >= 0) {
                intWrapper.value = i2 + 1;
                return bArr[i2];
            }
            intWrapper.value = i2 + 1;
        }
    }
}
