package I1I.I1I.p008IL.iIi1.ILil;

import I1I.IL1Iii;
import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: MeizuUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final String f3357IL1Iii = IL1Iii.IL1Iii(new byte[]{43, 83, 12, 28, 76, 102, 18, 95, 9, 21}, IL1Iii.IL1Iii(new byte[]{86, 4, 84, 87, 10, 82}, IL1Iii.IL1Iii(new byte[]{83, 11, 87, 9, 85, 83}, "c9f8f2")));

    @TargetApi(19)
    public static boolean I1I(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(IL1Iii.IL1Iii(new byte[]{7, 70, 17, 92, 69, 22}, IL1Iii.IL1Iii(new byte[]{85, 3, 87, 85, 84, 82}, IL1Iii.IL1Iii(new byte[]{11, 6, 6, 4, 85, 83}, "830b4d"))));
            try {
                String strIL1Iii = IL1Iii.IL1Iii(new byte[]{85, 93, 80, 5, 94, 45, 70}, IL1Iii.IL1Iii(new byte[]{1, 12, 6, 83, 4, 82}, IL1Iii.IL1Iii(new byte[]{15, 93, 81, 84, 80, 85}, "8dbaae")));
                Class cls = Integer.TYPE;
                return ((Integer) AppOpsManager.class.getDeclaredMethod(strIL1Iii, cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
            } catch (Exception e) {
                Log.e(f3357IL1Iii, Log.getStackTraceString(e));
            }
        } else {
            Log.e(f3357IL1Iii, IL1Iii.IL1Iii(new byte[]{117, 82, 15, 11, 20, 69, 118, 103, 42, 68, 82, 92, 23, 84, 2, 10, 13, 10, 67, 23, 10, 10, 21, 10, 92, 82, 66}, IL1Iii.IL1Iii(new byte[]{14, 6, 84, 93, 6, 80}, IL1Iii.IL1Iii(new byte[]{91, 6, 83, 9, 0, 6}, "b7d0e3"))));
        }
        return false;
    }

    public static void IL1Iii(Context context) {
        try {
            Intent intent = new Intent(IL1Iii.IL1Iii(new byte[]{7, 9, 14, 29, 85, 80, 13, 28, 22, 29, 75, 84, 2, 3, 77, 64, 93, 86, 17, 20, 10, 71, 65, 27, 55, 46, 44, 100, 103, 116, 52, 54, 48, 118, 123}, IL1Iii.IL1Iii(new byte[]{6, 84, 7, 10, 0, 4}, IL1Iii.IL1Iii(new byte[]{4, 3, 93, 12, 1, 83}, "f1959b"))));
            intent.putExtra(IL1Iii.IL1Iii(new byte[]{69, 83, 0, 89, 86, 80, 80, 124, 2, 95, 82}, IL1Iii.IL1Iii(new byte[]{2, 87, 83, 86, 86, 5}, IL1Iii.IL1Iii(new byte[]{14, 6, 0, 92, 84, 81}, "9c085c"))), context.getPackageName());
            intent.setFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
            try {
                context.startActivity(intent);
            } catch (Exception e) {
                e = e;
                try {
                    Log.e(f3357IL1Iii, IL1Iii.IL1Iii(new byte[]{-117, -74, -113, -44, -70, -14, -123, -70, -108, -41, -128, -54, -124, -110, -81, -41, -88, -25, -118, -95, -88, 29, 21, -126, -22, -85, -35, -115, -75, 37, 19, 72, 107, 84, 86, 37, 0, 76, 81, 71, 92, 16, 26, -35, -100, -128, -35, -48, -58, 20, 24}, IL1Iii.IL1Iii(new byte[]{1, 9, 12, 85, 7, 87}, IL1Iii.IL1Iii(new byte[]{83, 9, 3, 7, 87, 80}, "187cec"))) + Log.getStackTraceString(e));
                    I1I.I1I.p008IL.iIi1.IL1Iii.Ilil(context);
                } catch (Exception e2) {
                    Log.e(f3357IL1Iii, IL1Iii.IL1Iii(new byte[]{-117, -71, -122, -48, -20, -13, -123, -75, -99, -45, -42, -53, -124, -99, -90, -45, -2, -26, -118, -82, -95, -48, -57, -44, -117, -125, -108, 25, 67, -116, -29, -83, -42, -95, -53, -115, -19, -128, -44, -70, -11, -125, -11, -114, -41, -122, -10, -128, -57, -122, -39, -127, -58, 73, 67}, IL1Iii.IL1Iii(new byte[]{84, 4, 1, 12, 85, 93}, IL1Iii.IL1Iii(new byte[]{83, 1, 85, 88, 1, 1}, "d2ea79"))) + Log.getStackTraceString(e2));
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static boolean ILil(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return I1I(context, 24);
        }
        return true;
    }
}
