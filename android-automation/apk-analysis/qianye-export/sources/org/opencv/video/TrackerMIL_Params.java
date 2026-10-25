package org.opencv.video;

/* JADX INFO: loaded from: classes.dex */
public class TrackerMIL_Params {
    public final long nativeObj;

    public TrackerMIL_Params(long j) {
        this.nativeObj = j;
    }

    private static native long TrackerMIL_Params_0();

    public static TrackerMIL_Params __fromPtr__(long j) {
        return new TrackerMIL_Params(j);
    }

    private static native void delete(long j);

    private static native int get_featureSetNumFeatures_0(long j);

    private static native float get_samplerInitInRadius_0(long j);

    private static native int get_samplerInitMaxNegNum_0(long j);

    private static native float get_samplerSearchWinSize_0(long j);

    private static native float get_samplerTrackInRadius_0(long j);

    private static native int get_samplerTrackMaxNegNum_0(long j);

    private static native int get_samplerTrackMaxPosNum_0(long j);

    private static native void set_featureSetNumFeatures_0(long j, int i);

    private static native void set_samplerInitInRadius_0(long j, float f);

    private static native void set_samplerInitMaxNegNum_0(long j, int i);

    private static native void set_samplerSearchWinSize_0(long j, float f);

    private static native void set_samplerTrackInRadius_0(long j, float f);

    private static native void set_samplerTrackMaxNegNum_0(long j, int i);

    private static native void set_samplerTrackMaxPosNum_0(long j, int i);

    public void finalize() throws Throwable {
        delete(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public int get_featureSetNumFeatures() {
        return get_featureSetNumFeatures_0(this.nativeObj);
    }

    public float get_samplerInitInRadius() {
        return get_samplerInitInRadius_0(this.nativeObj);
    }

    public int get_samplerInitMaxNegNum() {
        return get_samplerInitMaxNegNum_0(this.nativeObj);
    }

    public float get_samplerSearchWinSize() {
        return get_samplerSearchWinSize_0(this.nativeObj);
    }

    public float get_samplerTrackInRadius() {
        return get_samplerTrackInRadius_0(this.nativeObj);
    }

    public int get_samplerTrackMaxNegNum() {
        return get_samplerTrackMaxNegNum_0(this.nativeObj);
    }

    public int get_samplerTrackMaxPosNum() {
        return get_samplerTrackMaxPosNum_0(this.nativeObj);
    }

    public void set_featureSetNumFeatures(int i) {
        set_featureSetNumFeatures_0(this.nativeObj, i);
    }

    public void set_samplerInitInRadius(float f) {
        set_samplerInitInRadius_0(this.nativeObj, f);
    }

    public void set_samplerInitMaxNegNum(int i) {
        set_samplerInitMaxNegNum_0(this.nativeObj, i);
    }

    public void set_samplerSearchWinSize(float f) {
        set_samplerSearchWinSize_0(this.nativeObj, f);
    }

    public void set_samplerTrackInRadius(float f) {
        set_samplerTrackInRadius_0(this.nativeObj, f);
    }

    public void set_samplerTrackMaxNegNum(int i) {
        set_samplerTrackMaxNegNum_0(this.nativeObj, i);
    }

    public void set_samplerTrackMaxPosNum(int i) {
        set_samplerTrackMaxPosNum_0(this.nativeObj, i);
    }

    public TrackerMIL_Params() {
        this.nativeObj = TrackerMIL_Params_0();
    }
}
