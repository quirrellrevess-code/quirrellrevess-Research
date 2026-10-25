package I1I.I1I.p008IL.iIi1.ILil;

import I1I.IL1Iii;
import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import com.google.android.flexbox.BuildConfig;
import org.opencv.videoio.Videoio;

/* JADX INFO: renamed from: I1I.I1I.I丨L.iIi1.ILil.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: QikuUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class lLi1LL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final String f3360IL1Iii = IL1Iii.IL1Iii(new byte[]{99, 10, 95, 70, 98, 67, 91, 15, 71}, IL1Iii.IL1Iii(new byte[]{2, 6, 86, 3, 0, 85}, IL1Iii.IL1Iii(new byte[]{81, 4, 85, 9, 82, 85}, "aa79e7")));

    @TargetApi(19)
    public static boolean I1I(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(IL1Iii.IL1Iii(new byte[]{0, 19, 21, 9, 69, 67}, IL1Iii.IL1Iii(new byte[]{0, 2, 82, 82, 81, 9}, IL1Iii.IL1Iii(new byte[]{86, 89, 15, 0, 80, 10}, "788443"))));
            try {
                String strIL1Iii = IL1Iii.IL1Iii(new byte[]{90, 94, 92, 83, 90, 127, 73}, IL1Iii.IL1Iii(new byte[]{90, 87, 1, 84, 87, 3}, IL1Iii.IL1Iii(new byte[]{7, 86, 8, 5, 2, 81}, "d70adb")));
                Class cls = Integer.TYPE;
                return ((Integer) AppOpsManager.class.getDeclaredMethod(strIL1Iii, cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
            } catch (Exception e) {
                Log.e(f3360IL1Iii, Log.getStackTraceString(e));
            }
        } else {
            Log.e(BuildConfig.FLAVOR, IL1Iii.IL1Iii(new byte[]{118, 4, 14, 94, 18, 20, 117, 49, 43, 17, 84, 13, 20, 2, 3, 95, 11, 91, 64, 65, 11, 95, 19, 91, 95, 4, 67}, IL1Iii.IL1Iii(new byte[]{4, 2, 7, 85, 93, 0}, IL1Iii.IL1Iii(new byte[]{5, 81, 7, 2, 1, 85}, "52bf9a"))));
        }
        return false;
    }

    public static void IL1Iii(Context context) {
        Intent intent = new Intent();
        intent.setClassName(IL1Iii.IL1Iii(new byte[]{2, 9, 14, 75, 81, 11, 5, 20, 12, 12, 84, 75, 18, 3, 23, 17, 89, 11, 6, 21}, IL1Iii.IL1Iii(new byte[]{87, 94, 83, 82, 6, 6}, IL1Iii.IL1Iii(new byte[]{84, 91, 83, 4, 14, 2}, "bcc38a"))), IL1Iii.IL1Iii(new byte[]{1, 13, 12, 27, 86, 92, 6, 16, 14, 92, 83, 28, 17, 7, 21, 65, 94, 92, 5, 17, 79, 102, 82, 70, 22, 11, 15, 82, 68, 22, 45, 20, 4, 71, 91, 83, 27, 49, 4, 65, 67, 91, 12, 5, 18, 116, 84, 70, 11, 20, 8, 65, 78}, IL1Iii.IL1Iii(new byte[]{0, 82, 83, 81, 0, 5}, IL1Iii.IL1Iii(new byte[]{90, 4, 4, 83, 2, 2}, "846755"))));
        intent.setFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
        if (m1095IL(intent, context)) {
            context.startActivity(intent);
            return;
        }
        intent.setClassName(IL1Iii.IL1Iii(new byte[]{90, 86, 15, 30, 66, 95, 81, 86, 13, 3, 5, 6, 23, 84, 13, 82, 90, 90, 92, 74, 3, 86, 86}, IL1Iii.IL1Iii(new byte[]{9, 8, 85, 85, 87, 3}, IL1Iii.IL1Iii(new byte[]{6, 87, 85, 3, 87, 2}, "6fbf37"))), IL1Iii.IL1Iii(new byte[]{2, 91, 15, 74, 67, 93, 9, 91, 13, 87, 4, 4, 79, 89, 13, 6, 91, 88, 4, 71, 3, 2, 87, 26, 20, 93, 76, 13, 92, 80, 4, 76, 76, 37, 66, 68, 36, 90, 22, 1, 64, 117, 2, 64, 11, 18, 91, 64, 24}, IL1Iii.IL1Iii(new byte[]{87, 2, 82, 6, 11, 81}, IL1Iii.IL1Iii(new byte[]{4, 80, 84, 81, 95, 3}, "2fd3ff"))));
        if (m1095IL(intent, context)) {
            context.startActivity(intent);
        } else {
            Log.e(f3360IL1Iii, IL1Iii.IL1Iii(new byte[]{81, 7, 10, 31, 21, 20, 93, 22, 1, 86, 65, 68, 87, 20, 9, 81, 18, 71, 91, 9, 10, 24, 17, 85, 85, 3, 68, 79, 8, 64, 90, 70, 20, 89, 19, 64, 91, 5, 17, 84, 0, 70, 18, 8, 5, 85, 4, 24, 18, 22, 8, 93, 0, 71, 87, 70, 17, 75, 4, 20, 16, 7, 0, 90, 65, 71, 90, 3, 8, 84, 65, 80, 71, 11, 20, 75, 24, 71, 18, 7, 7, 76, 8, 66, 91, 18, 29, 26, 65, 87, 93, 11, 9, 89, 15, 80, 18, 7, 10, 92, 65, 64, 87, 10, 8, 24, 12, 81, 18, 18, 12, 93, 65, 90, 83, 11, 1, 24, 14, 82, 18, 18, 12, 93, 65, 82, 94, 9, 5, 76, 65, 67, 91, 8, 0, 87, 22, 20, 66, 3, 22, 85, 8, 71, 65, 15, 11, 86, 65, 68, 83, 1, 1}, IL1Iii.IL1Iii(new byte[]{3, 95, 6, 10, 81, 1}, IL1Iii.IL1Iii(new byte[]{80, 91, 85, 5, 84, 6}, "ab77d3"))));
        }
    }

    public static boolean ILil(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return I1I(context, 24);
        }
        return true;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static boolean m1095IL(Intent intent, Context context) {
        return intent != null && context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
