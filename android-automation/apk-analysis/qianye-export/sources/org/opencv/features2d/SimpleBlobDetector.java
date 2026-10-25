package org.opencv.features2d;

/* JADX INFO: loaded from: classes.dex */
public class SimpleBlobDetector extends Feature2D {
    public SimpleBlobDetector(long j) {
        super(j);
    }

    public static SimpleBlobDetector __fromPtr__(long j) {
        return new SimpleBlobDetector(j);
    }

    public static SimpleBlobDetector create(SimpleBlobDetector_Params simpleBlobDetector_Params) {
        return __fromPtr__(create_0(simpleBlobDetector_Params.nativeObj));
    }

    private static native long create_0(long j);

    private static native long create_1();

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

    public static SimpleBlobDetector create() {
        return __fromPtr__(create_1());
    }
}
