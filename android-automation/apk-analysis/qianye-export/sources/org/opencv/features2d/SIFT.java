package org.opencv.features2d;

/* JADX INFO: loaded from: classes.dex */
public class SIFT extends Feature2D {
    public SIFT(long j) {
        super(j);
    }

    public static SIFT __fromPtr__(long j) {
        return new SIFT(j);
    }

    public static SIFT create(int i, int i2, double d, double d2, double d3) {
        return __fromPtr__(create_0(i, i2, d, d2, d3));
    }

    private static native long create_0(int i, int i2, double d, double d2, double d3);

    private static native long create_1(int i, int i2, double d, double d2);

    private static native long create_2(int i, int i2, double d);

    private static native long create_3(int i, int i2);

    private static native long create_4(int i);

    private static native long create_5();

    private static native long create_6(int i, int i2, double d, double d2, double d3, int i3);

    private static native void delete(long j);

    private static native String getDefaultName_0(long j);

    @Override // org.opencv.features2d.Feature2D, org.opencv.core.Algorithm
    public void finalize() throws Throwable {
        delete(this.nativeObj);
    }

    @Override // org.opencv.features2d.Feature2D, org.opencv.core.Algorithm
    public String getDefaultName() {
        return getDefaultName_0(this.nativeObj);
    }

    public static SIFT create(int i, int i2, double d, double d2) {
        return __fromPtr__(create_1(i, i2, d, d2));
    }

    public static SIFT create(int i, int i2, double d) {
        return __fromPtr__(create_2(i, i2, d));
    }

    public static SIFT create(int i, int i2) {
        return __fromPtr__(create_3(i, i2));
    }

    public static SIFT create(int i) {
        return __fromPtr__(create_4(i));
    }

    public static SIFT create() {
        return __fromPtr__(create_5());
    }

    public static SIFT create(int i, int i2, double d, double d2, double d3, int i3) {
        return __fromPtr__(create_6(i, i2, d, d2, d3, i3));
    }
}
