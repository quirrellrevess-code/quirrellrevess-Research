package org.opencv.dnn;

/* JADX INFO: loaded from: classes.dex */
public class TextDetectionModel_EAST extends TextDetectionModel {
    public TextDetectionModel_EAST(long j) {
        super(j);
    }

    private static native long TextDetectionModel_EAST_0(long j);

    private static native long TextDetectionModel_EAST_1(String str, String str2);

    private static native long TextDetectionModel_EAST_2(String str);

    public static TextDetectionModel_EAST __fromPtr__(long j) {
        return new TextDetectionModel_EAST(j);
    }

    private static native void delete(long j);

    private static native float getConfidenceThreshold_0(long j);

    private static native float getNMSThreshold_0(long j);

    private static native long setConfidenceThreshold_0(long j, float f);

    private static native long setNMSThreshold_0(long j, float f);

    @Override // org.opencv.dnn.TextDetectionModel, org.opencv.dnn.Model
    public void finalize() throws Throwable {
        delete(this.nativeObj);
    }

    public float getConfidenceThreshold() {
        return getConfidenceThreshold_0(this.nativeObj);
    }

    public float getNMSThreshold() {
        return getNMSThreshold_0(this.nativeObj);
    }

    public TextDetectionModel_EAST setConfidenceThreshold(float f) {
        return new TextDetectionModel_EAST(setConfidenceThreshold_0(this.nativeObj, f));
    }

    public TextDetectionModel_EAST setNMSThreshold(float f) {
        return new TextDetectionModel_EAST(setNMSThreshold_0(this.nativeObj, f));
    }

    public TextDetectionModel_EAST(Net net) {
        super(TextDetectionModel_EAST_0(net.nativeObj));
    }

    public TextDetectionModel_EAST(String str, String str2) {
        super(TextDetectionModel_EAST_1(str, str2));
    }

    public TextDetectionModel_EAST(String str) {
        super(TextDetectionModel_EAST_2(str));
    }
}
