package org.opencv.video;

/* JADX INFO: loaded from: classes.dex */
public class TrackerGOTURN_Params {
    public final long nativeObj;

    public TrackerGOTURN_Params(long j) {
        this.nativeObj = j;
    }

    private static native long TrackerGOTURN_Params_0();

    public static TrackerGOTURN_Params __fromPtr__(long j) {
        return new TrackerGOTURN_Params(j);
    }

    private static native void delete(long j);

    private static native String get_modelBin_0(long j);

    private static native String get_modelTxt_0(long j);

    private static native void set_modelBin_0(long j, String str);

    private static native void set_modelTxt_0(long j, String str);

    public void finalize() throws Throwable {
        delete(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public String get_modelBin() {
        return get_modelBin_0(this.nativeObj);
    }

    public String get_modelTxt() {
        return get_modelTxt_0(this.nativeObj);
    }

    public void set_modelBin(String str) {
        set_modelBin_0(this.nativeObj, str);
    }

    public void set_modelTxt(String str) {
        set_modelTxt_0(this.nativeObj, str);
    }

    public TrackerGOTURN_Params() {
        this.nativeObj = TrackerGOTURN_Params_0();
    }
}
