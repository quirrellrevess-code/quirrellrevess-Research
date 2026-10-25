package org.opencv.dnn;

import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfRect;

/* JADX INFO: loaded from: classes.dex */
public class DetectionModel extends Model {
    public DetectionModel(long j) {
        super(j);
    }

    private static native long DetectionModel_0(String str, String str2);

    private static native long DetectionModel_1(String str);

    private static native long DetectionModel_2(long j);

    public static DetectionModel __fromPtr__(long j) {
        return new DetectionModel(j);
    }

    private static native void delete(long j);

    private static native void detect_0(long j, long j2, long j3, long j4, long j5, float f, float f2);

    private static native void detect_1(long j, long j2, long j3, long j4, long j5, float f);

    private static native void detect_2(long j, long j2, long j3, long j4, long j5);

    private static native boolean getNmsAcrossClasses_0(long j);

    private static native long setNmsAcrossClasses_0(long j, boolean z);

    public void detect(Mat mat, MatOfInt matOfInt, MatOfFloat matOfFloat, MatOfRect matOfRect, float f, float f2) {
        detect_0(this.nativeObj, mat.nativeObj, matOfInt.nativeObj, matOfFloat.nativeObj, matOfRect.nativeObj, f, f2);
    }

    @Override // org.opencv.dnn.Model
    public void finalize() throws Throwable {
        delete(this.nativeObj);
    }

    public boolean getNmsAcrossClasses() {
        return getNmsAcrossClasses_0(this.nativeObj);
    }

    public DetectionModel setNmsAcrossClasses(boolean z) {
        return new DetectionModel(setNmsAcrossClasses_0(this.nativeObj, z));
    }

    public DetectionModel(String str, String str2) {
        super(DetectionModel_0(str, str2));
    }

    public void detect(Mat mat, MatOfInt matOfInt, MatOfFloat matOfFloat, MatOfRect matOfRect, float f) {
        detect_1(this.nativeObj, mat.nativeObj, matOfInt.nativeObj, matOfFloat.nativeObj, matOfRect.nativeObj, f);
    }

    public DetectionModel(String str) {
        super(DetectionModel_1(str));
    }

    public void detect(Mat mat, MatOfInt matOfInt, MatOfFloat matOfFloat, MatOfRect matOfRect) {
        detect_2(this.nativeObj, mat.nativeObj, matOfInt.nativeObj, matOfFloat.nativeObj, matOfRect.nativeObj);
    }

    public DetectionModel(Net net) {
        super(DetectionModel_2(net.nativeObj));
    }
}
