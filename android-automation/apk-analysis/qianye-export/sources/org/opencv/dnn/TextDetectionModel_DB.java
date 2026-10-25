package org.opencv.dnn;

/* JADX INFO: loaded from: classes.dex */
public class TextDetectionModel_DB extends TextDetectionModel {
    public TextDetectionModel_DB(long j) {
        super(j);
    }

    private static native long TextDetectionModel_DB_0(long j);

    private static native long TextDetectionModel_DB_1(String str, String str2);

    private static native long TextDetectionModel_DB_2(String str);

    public static TextDetectionModel_DB __fromPtr__(long j) {
        return new TextDetectionModel_DB(j);
    }

    private static native void delete(long j);

    private static native float getBinaryThreshold_0(long j);

    private static native int getMaxCandidates_0(long j);

    private static native float getPolygonThreshold_0(long j);

    private static native double getUnclipRatio_0(long j);

    private static native long setBinaryThreshold_0(long j, float f);

    private static native long setMaxCandidates_0(long j, int i);

    private static native long setPolygonThreshold_0(long j, float f);

    private static native long setUnclipRatio_0(long j, double d);

    @Override // org.opencv.dnn.TextDetectionModel, org.opencv.dnn.Model
    public void finalize() throws Throwable {
        delete(this.nativeObj);
    }

    public float getBinaryThreshold() {
        return getBinaryThreshold_0(this.nativeObj);
    }

    public int getMaxCandidates() {
        return getMaxCandidates_0(this.nativeObj);
    }

    public float getPolygonThreshold() {
        return getPolygonThreshold_0(this.nativeObj);
    }

    public double getUnclipRatio() {
        return getUnclipRatio_0(this.nativeObj);
    }

    public TextDetectionModel_DB setBinaryThreshold(float f) {
        return new TextDetectionModel_DB(setBinaryThreshold_0(this.nativeObj, f));
    }

    public TextDetectionModel_DB setMaxCandidates(int i) {
        return new TextDetectionModel_DB(setMaxCandidates_0(this.nativeObj, i));
    }

    public TextDetectionModel_DB setPolygonThreshold(float f) {
        return new TextDetectionModel_DB(setPolygonThreshold_0(this.nativeObj, f));
    }

    public TextDetectionModel_DB setUnclipRatio(double d) {
        return new TextDetectionModel_DB(setUnclipRatio_0(this.nativeObj, d));
    }

    public TextDetectionModel_DB(Net net) {
        super(TextDetectionModel_DB_0(net.nativeObj));
    }

    public TextDetectionModel_DB(String str, String str2) {
        super(TextDetectionModel_DB_1(str, str2));
    }

    public TextDetectionModel_DB(String str) {
        super(TextDetectionModel_DB_2(str));
    }
}
