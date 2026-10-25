package org.opencv.photo;

/* JADX INFO: loaded from: classes.dex */
public class TonemapDrago extends Tonemap {
    public TonemapDrago(long j) {
        super(j);
    }

    public static TonemapDrago __fromPtr__(long j) {
        return new TonemapDrago(j);
    }

    private static native void delete(long j);

    private static native float getBias_0(long j);

    private static native float getSaturation_0(long j);

    private static native void setBias_0(long j, float f);

    private static native void setSaturation_0(long j, float f);

    @Override // org.opencv.photo.Tonemap, org.opencv.core.Algorithm
    public void finalize() throws Throwable {
        delete(this.nativeObj);
    }

    public float getBias() {
        return getBias_0(this.nativeObj);
    }

    public float getSaturation() {
        return getSaturation_0(this.nativeObj);
    }

    public void setBias(float f) {
        setBias_0(this.nativeObj, f);
    }

    public void setSaturation(float f) {
        setSaturation_0(this.nativeObj, f);
    }
}
