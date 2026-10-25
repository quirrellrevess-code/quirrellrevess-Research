package org.opencv.video;

import org.opencv.core.Algorithm;
import org.opencv.core.Mat;

/* JADX INFO: loaded from: classes.dex */
public class BackgroundSubtractor extends Algorithm {
    public BackgroundSubtractor(long j) {
        super(j);
    }

    public static BackgroundSubtractor __fromPtr__(long j) {
        return new BackgroundSubtractor(j);
    }

    private static native void apply_0(long j, long j2, long j3, double d);

    private static native void apply_1(long j, long j2, long j3);

    private static native void delete(long j);

    private static native void getBackgroundImage_0(long j, long j2);

    public void apply(Mat mat, Mat mat2, double d) {
        apply_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, d);
    }

    @Override // org.opencv.core.Algorithm
    public void finalize() throws Throwable {
        delete(this.nativeObj);
    }

    public void getBackgroundImage(Mat mat) {
        getBackgroundImage_0(this.nativeObj, mat.nativeObj);
    }

    public void apply(Mat mat, Mat mat2) {
        apply_1(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }
}
