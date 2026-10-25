package I1I.I1I.p008IL;

import I1I.IL1Iii;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;

/* JADX INFO: compiled from: ScreenUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class LlLI1 {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static PowerManager.WakeLock f3336IL1Iii;

    public static void IL1Iii(Context context) {
        PowerManager.WakeLock wakeLock = f3336IL1Iii;
        if (wakeLock == null || !wakeLock.isHeld()) {
            return;
        }
        f3336IL1Iii.release();
        f3336IL1Iii = null;
    }

    @SuppressLint({"InvalidWakeLockTag"})
    public static void ILil(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService(IL1Iii.IL1Iii(new byte[]{72, 90, 17, 86, 20}, IL1Iii.IL1Iii(new byte[]{11, 80, 84, 4, 0, 6}, IL1Iii.IL1Iii(new byte[]{11, 3, 4, 5, 85, 87}, "8f623a"))));
        if (powerManager != null && f3336IL1Iii == null) {
            PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(268435584, IL1Iii.IL1Iii(new byte[]{107, 85, 67, 80, 7, 15, 109, 66, 88, 89, 17}, IL1Iii.IL1Iii(new byte[]{94, 82, 80, 83, 81, 4}, IL1Iii.IL1Iii(new byte[]{86, 6, 80, 95, 86, 82}, "0b19e7"))));
            f3336IL1Iii = wakeLockNewWakeLock;
            wakeLockNewWakeLock.acquire();
        }
    }
}
