package org.opencv.core;

import I1I.IL1Iii;

/* JADX INFO: loaded from: classes.dex */
public final class CvType {
    public static final int CV_16F = 7;
    public static final int CV_16S = 3;
    public static final int CV_16U = 2;
    public static final int CV_32F = 5;
    public static final int CV_32S = 4;
    public static final int CV_64F = 6;
    public static final int CV_8S = 1;
    public static final int CV_8U = 0;
    private static final int CV_CN_MAX = 512;
    private static final int CV_CN_SHIFT = 3;
    private static final int CV_DEPTH_MAX = 8;

    @Deprecated
    public static final int CV_USRTYPE1 = 7;
    public static final int CV_8UC1 = CV_8UC(1);
    public static final int CV_8UC2 = CV_8UC(2);
    public static final int CV_8UC3 = CV_8UC(3);
    public static final int CV_8UC4 = CV_8UC(4);
    public static final int CV_8SC1 = CV_8SC(1);
    public static final int CV_8SC2 = CV_8SC(2);
    public static final int CV_8SC3 = CV_8SC(3);
    public static final int CV_8SC4 = CV_8SC(4);
    public static final int CV_16UC1 = CV_16UC(1);
    public static final int CV_16UC2 = CV_16UC(2);
    public static final int CV_16UC3 = CV_16UC(3);
    public static final int CV_16UC4 = CV_16UC(4);
    public static final int CV_16SC1 = CV_16SC(1);
    public static final int CV_16SC2 = CV_16SC(2);
    public static final int CV_16SC3 = CV_16SC(3);
    public static final int CV_16SC4 = CV_16SC(4);
    public static final int CV_32SC1 = CV_32SC(1);
    public static final int CV_32SC2 = CV_32SC(2);
    public static final int CV_32SC3 = CV_32SC(3);
    public static final int CV_32SC4 = CV_32SC(4);
    public static final int CV_32FC1 = CV_32FC(1);
    public static final int CV_32FC2 = CV_32FC(2);
    public static final int CV_32FC3 = CV_32FC(3);
    public static final int CV_32FC4 = CV_32FC(4);
    public static final int CV_64FC1 = CV_64FC(1);
    public static final int CV_64FC2 = CV_64FC(2);
    public static final int CV_64FC3 = CV_64FC(3);
    public static final int CV_64FC4 = CV_64FC(4);
    public static final int CV_16FC1 = CV_16FC(1);
    public static final int CV_16FC2 = CV_16FC(2);
    public static final int CV_16FC3 = CV_16FC(3);
    public static final int CV_16FC4 = CV_16FC(4);

    public static final int CV_16FC(int i) {
        return makeType(7, i);
    }

    public static final int CV_16SC(int i) {
        return makeType(3, i);
    }

    public static final int CV_16UC(int i) {
        return makeType(2, i);
    }

    public static final int CV_32FC(int i) {
        return makeType(5, i);
    }

    public static final int CV_32SC(int i) {
        return makeType(4, i);
    }

    public static final int CV_64FC(int i) {
        return makeType(6, i);
    }

    public static final int CV_8SC(int i) {
        return makeType(1, i);
    }

    public static final int CV_8UC(int i) {
        return makeType(0, i);
    }

    public static final int ELEM_SIZE(int i) {
        switch (depth(i)) {
            case 0:
            case 1:
                return channels(i);
            case 2:
            case 3:
            case 7:
                return channels(i) * 2;
            case 4:
            case 5:
                return channels(i) * 4;
            case 6:
                return channels(i) * 8;
            default:
                throw new UnsupportedOperationException(IL1Iii.IL1Iii(new byte[]{98, 91, 16, 70, 22, 69, 88, 71, 23, 86, 2, 21, 116, 67, 55, 74, 22, 80, 23, 67, 2, 95, 19, 80, 13, 21}, IL1Iii.IL1Iii(new byte[]{86, 84, 6, 0, 3, 83}, IL1Iii.IL1Iii(new byte[]{3, 83, 1, 5, 4, 80}, "b2d6a6"))) + i);
        }
    }

    public static final int channels(int i) {
        return (i >> 3) + 1;
    }

    public static final int depth(int i) {
        return i & 7;
    }

    public static final boolean isInteger(int i) {
        return depth(i) < 5;
    }

    public static final int makeType(int i, int i2) {
        if (i2 <= 0 || i2 >= 512) {
            throw new UnsupportedOperationException(IL1Iii.IL1Iii(new byte[]{113, 10, 85, 91, 86, 85, 94, 17, 20, 86, 87, 69, 92, 22, 20, 70, 80, 95, 71, 14, 80, 21, 90, 85, 18, 83, 26, 27, 13, 1, 3}, IL1Iii.IL1Iii(new byte[]{84, 80, 81, 12, 9, 84}, IL1Iii.IL1Iii(new byte[]{80, 86, 4, 95, 5, 85}, "6daf41"))));
        }
        if (i < 0 || i >= 8) {
            throw new UnsupportedOperationException(IL1Iii.IL1Iii(new byte[]{33, 2, 65, 84, 19, 18, 28, 19, 80, 21, 87, 3, 21, 23, 93, 21, 64, 14, 10, 22, 89, 81, 19, 4, 0, 67, 5, 27, 29, 81}, IL1Iii.IL1Iii(new byte[]{92, 2, 5, 7, 6, 84}, IL1Iii.IL1Iii(new byte[]{1, 87, 84, 2, 13, 7}, "86d085"))));
        }
        return (i & 7) + ((i2 - 1) << 3);
    }

    public static final String typeToString(int i) {
        String strIL1Iii;
        switch (depth(i)) {
            case 0:
                strIL1Iii = IL1Iii.IL1Iii(new byte[]{115, 55, 111, 94, 109}, IL1Iii.IL1Iii(new byte[]{4, 87, 4, 87, 0, 11}, IL1Iii.IL1Iii(new byte[]{80, 7, 80, 0, 94, 9}, "d1d1f0")));
                break;
            case 1:
                strIL1Iii = IL1Iii.IL1Iii(new byte[]{33, 111, 110, 12, 97}, IL1Iii.IL1Iii(new byte[]{86, 90, 9, 4, 2, 83}, IL1Iii.IL1Iii(new byte[]{0, 84, 91, 85, 81, 80}, "47cea4")));
                break;
            case 2:
                strIL1Iii = IL1Iii.IL1Iii(new byte[]{113, 100, 62, 8, 5, 55}, IL1Iii.IL1Iii(new byte[]{10, 86, 83, 1, 86, 82}, IL1Iii.IL1Iii(new byte[]{93, 1, 1, 14, 80, 1}, "ee3651")));
                break;
            case 3:
                strIL1Iii = IL1Iii.IL1Iii(new byte[]{33, 99, 107, 83, 7, 53}, IL1Iii.IL1Iii(new byte[]{82, 13, 3, 91, 0, 81}, IL1Iii.IL1Iii(new byte[]{6, 10, 82, 92, 80, 15}, "62eea8")));
                break;
            case 4:
                strIL1Iii = IL1Iii.IL1Iii(new byte[]{122, 100, 57, 87, 2, 49}, IL1Iii.IL1Iii(new byte[]{13, 4, 2, 2, 3, 82}, IL1Iii.IL1Iii(new byte[]{13, 4, 83, 87, 0, 85}, "92713e")));
                break;
            case 5:
                strIL1Iii = IL1Iii.IL1Iii(new byte[]{117, 111, 104, 87, 6, 113}, IL1Iii.IL1Iii(new byte[]{4, 8, 1, 87, 80, 2}, IL1Iii.IL1Iii(new byte[]{4, 2, 3, 1, 0, 3}, "6352d6")));
                break;
            case 6:
                strIL1Iii = IL1Iii.IL1Iii(new byte[]{123, 111, 61, 80, 80, 112}, IL1Iii.IL1Iii(new byte[]{13, 91, 87, 85, 83, 0}, IL1Iii.IL1Iii(new byte[]{80, 1, 7, 82, 0, 84}, "ec2a7b")));
                break;
            case 7:
                strIL1Iii = IL1Iii.IL1Iii(new byte[]{112, 110, 104, 7, 15, 127}, IL1Iii.IL1Iii(new byte[]{0, 90, 6, 87, 92, 1}, IL1Iii.IL1Iii(new byte[]{0, 87, 1, 82, 80, 15}, "350357")));
                break;
            default:
                throw new UnsupportedOperationException(IL1Iii.IL1Iii(new byte[]{51, 15, 65, 22, 71, 68, 9, 19, 70, 6, 83, 20, 37, 23, 102, 26, 71, 81, 70, 23, 83, 15, 66, 81, 92, 65}, IL1Iii.IL1Iii(new byte[]{95, 82, 83, 1, 83, 4}, IL1Iii.IL1Iii(new byte[]{92, 11, 86, 91, 82, 83}, "e8796c"))) + i);
        }
        int iChannels = channels(i);
        if (iChannels <= 4) {
            return strIL1Iii + IL1Iii.IL1Iii(new byte[]{113}, IL1Iii.IL1Iii(new byte[]{1, 84, 85, 12, 15, 0}, IL1Iii.IL1Iii(new byte[]{4, 80, 0, 7, 95, 5}, "7f62f2"))) + iChannels;
        }
        return strIL1Iii + IL1Iii.IL1Iii(new byte[]{115, 74}, IL1Iii.IL1Iii(new byte[]{7, 81, 80, 83, 7, 82}, IL1Iii.IL1Iii(new byte[]{84, 86, 85, 3, 6, 6}, "ce0b71"))) + iChannels + IL1Iii.IL1Iii(new byte[]{77}, IL1Iii.IL1Iii(new byte[]{86, 85, 83, 14, 83, 0}, IL1Iii.IL1Iii(new byte[]{4, 86, 91, 14, 84, 85}, "629910")));
    }
}
