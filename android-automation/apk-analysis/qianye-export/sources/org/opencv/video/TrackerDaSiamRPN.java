package org.opencv.video;

/* JADX INFO: loaded from: classes.dex */
public class TrackerDaSiamRPN extends Tracker {
    public TrackerDaSiamRPN(long j) {
        super(j);
    }

    public static TrackerDaSiamRPN __fromPtr__(long j) {
        return new TrackerDaSiamRPN(j);
    }

    public static TrackerDaSiamRPN create(TrackerDaSiamRPN_Params trackerDaSiamRPN_Params) {
        return __fromPtr__(create_0(trackerDaSiamRPN_Params.nativeObj));
    }

    private static native long create_0(long j);

    private static native long create_1();

    private static native void delete(long j);

    private static native float getTrackingScore_0(long j);

    @Override // org.opencv.video.Tracker
    public void finalize() throws Throwable {
        delete(this.nativeObj);
    }

    public float getTrackingScore() {
        return getTrackingScore_0(this.nativeObj);
    }

    public static TrackerDaSiamRPN create() {
        return __fromPtr__(create_1());
    }
}
