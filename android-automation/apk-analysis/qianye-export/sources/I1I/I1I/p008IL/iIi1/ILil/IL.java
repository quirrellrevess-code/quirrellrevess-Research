package I1I.I1I.p008IL.iIi1.ILil;

import I1I.IL1Iii;
import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import org.opencv.videoio.Videoio;

/* JADX INFO: renamed from: I1I.I1I.I丨L.iIi1.ILil.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: OppoUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class IL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final String f3358IL1Iii = IL1Iii.IL1Iii(new byte[]{119, 66, 67, 92, 51, 77, 81, 94, 64}, IL1Iii.IL1Iii(new byte[]{10, 11, 11, 7, 82, 8}, IL1Iii.IL1Iii(new byte[]{83, 91, 93, 1, 1, 5}, "abe554")));

    @TargetApi(19)
    public static boolean I1I(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(IL1Iii.IL1Iii(new byte[]{87, 20, 72, 95, 65, 71}, IL1Iii.IL1Iii(new byte[]{6, 0, 94, 4, 0, 85}, IL1Iii.IL1Iii(new byte[]{4, 82, 86, 1, 6, 80}, "460571"))));
            try {
                String strIL1Iii = IL1Iii.IL1Iii(new byte[]{82, 9, 84, 7, 92, 43, 65}, IL1Iii.IL1Iii(new byte[]{84, 80, 6, 93, 5, 1}, IL1Iii.IL1Iii(new byte[]{92, 80, 4, 8, 4, 7}, "9a316b")));
                Class cls = Integer.TYPE;
                return ((Integer) AppOpsManager.class.getDeclaredMethod(strIL1Iii, cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
            } catch (Exception e) {
                Log.e(f3358IL1Iii, Log.getStackTraceString(e));
            }
        } else {
            Log.e(f3358IL1Iii, IL1Iii.IL1Iii(new byte[]{33, 84, 13, 90, 18, 70, 34, 97, 40, 21, 84, 95, 67, 82, 0, 91, 11, 9, 23, 17, 8, 91, 19, 9, 8, 84, 64}, IL1Iii.IL1Iii(new byte[]{0, 5, 5, 4, 82, 86}, IL1Iii.IL1Iii(new byte[]{90, 12, 83, 80, 1, 82}, "987a6b"))));
        }
        return false;
    }

    public static void IL1Iii(Context context) {
        try {
            Intent intent = new Intent();
            intent.setFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
            intent.setComponent(new ComponentName(IL1Iii.IL1Iii(new byte[]{81, 11, 92, 28, 0, 10, 94, 11, 67, 93, 16, 75, 65, 5, 87, 87, 0, 0, 92, 16, 84, 64}, IL1Iii.IL1Iii(new byte[]{3, 0, 83, 87, 85, 87}, IL1Iii.IL1Iii(new byte[]{87, 93, 87, 82, 83, 83}, "f957ea"))), IL1Iii.IL1Iii(new byte[]{2, 12, 11, 76, 87, 14, 13, 12, 20, 13, 71, 79, 18, 2, 0, 7, 87, 4, 15, 23, 3, 16, 26, 18, 24, 16, 0, 14, 91, 0, 21, 20, 15, 12, 80, 14, 22, 77, 32, 14, 91, 0, 21, 52, 15, 12, 80, 14, 22, 47, 15, 17, 64, 32, 2, 23, 15, 20, 93, 21, 24}, IL1Iii.IL1Iii(new byte[]{0, 82, 95, 80, 82, 80}, IL1Iii.IL1Iii(new byte[]{87, 8, 95, 83, 84, 9}, "69fa28")))));
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean ILil(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return I1I(context, 24);
        }
        return true;
    }
}
