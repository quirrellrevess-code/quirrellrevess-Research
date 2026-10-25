package I1I.I1I.p008IL.iIi1.ILil;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: HuaweiUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final String f3356IL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{113, 23, 5, 78, 93, 81, 108, 22, 13, 85, 75}, I1I.IL1Iii.IL1Iii(new byte[]{90, 81, 0, 91, 11, 11}, I1I.IL1Iii.IL1Iii(new byte[]{6, 80, 83, 7, 82, 86}, "ec7eae")));

    @TargetApi(19)
    public static boolean I1I(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{85, 19, 20, 93, 66, 22}, I1I.IL1Iii.IL1Iii(new byte[]{2, 85, 85, 3, 11, 1}, I1I.IL1Iii.IL1Iii(new byte[]{2, 0, 3, 83, 13, 92}, "462b48"))));
            try {
                String strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{7, 90, 7, 86, 93, 46, 20}, I1I.IL1Iii.IL1Iii(new byte[]{82, 80, 81, 4, 0, 0}, I1I.IL1Iii.IL1Iii(new byte[]{82, 80, 1, 87, 14, 85}, "d22f84")));
                Class cls = Integer.TYPE;
                return ((Integer) AppOpsManager.class.getDeclaredMethod(strIL1Iii, cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
            } catch (Exception e) {
                Log.e(f3356IL1Iii, Log.getStackTraceString(e));
            }
        } else {
            Log.e(f3356IL1Iii, I1I.IL1Iii.IL1Iii(new byte[]{114, 86, 93, 9, 18, 18, 113, 99, 120, 70, 84, 11, 16, 80, 80, 8, 11, 93, 68, 19, 88, 8, 19, 93, 91, 86, 16}, I1I.IL1Iii.IL1Iii(new byte[]{82, 87, 4, 87, 82, 1}, I1I.IL1Iii.IL1Iii(new byte[]{85, 5, 87, 7, 15, 81}, "7ab68b"))));
        }
        return false;
    }

    public static void IL1Iii(Context context) {
        try {
            Intent intent = new Intent();
            intent.setFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
            intent.setComponent(new ComponentName(I1I.IL1Iii.IL1Iii(new byte[]{6, 12, 85, 28, 11, 16, 4, 20, 93, 91, 77, 22, 28, 16, 76, 87, 14, 8, 4, 13, 89, 85, 6, 23}, I1I.IL1Iii.IL1Iii(new byte[]{87, 7, 14, 87, 5, 86}, I1I.IL1Iii.IL1Iii(new byte[]{4, 7, 87, 0, 82, 81}, "6cae4b"))), I1I.IL1Iii.IL1Iii(new byte[]{86, 93, 11, 77, 9, 76, 84, 69, 3, 10, 79, 74, 76, 65, 18, 6, 12, 84, 84, 92, 7, 4, 4, 75, 27, 83, 2, 7, 23, 80, 80, 69, 11, 12, 15, 80, 65, 93, 20, 77, 32, 93, 81, 100, 15, 6, 22, 116, 90, 92, 15, 23, 14, 75, 116, 81, 18, 10, 23, 80, 65, 75}, I1I.IL1Iii.IL1Iii(new byte[]{0, 83, 0, 6, 80, 15}, I1I.IL1Iii.IL1Iii(new byte[]{87, 7, 4, 0, 7, 15}, "bfbe69")))));
            if (iILLL1.m1094lLi1LL() == 3.1d) {
                context.startActivity(intent);
            } else {
                intent.setComponent(new ComponentName(I1I.IL1Iii.IL1Iii(new byte[]{90, 89, 14, 28, 13, 76, 88, 65, 6, 91, 75, 74, 64, 69, 23, 87, 8, 84, 88, 88, 2, 85, 0, 75}, I1I.IL1Iii.IL1Iii(new byte[]{11, 80, 81, 81, 87, 10}, I1I.IL1Iii.IL1Iii(new byte[]{80, 81, 6, 91, 7, 4}, "b74857"))), I1I.IL1Iii.IL1Iii(new byte[]{87, 14, 94, 77, 12, 19, 85, 22, 86, 10, 74, 8, 91, 21, 90, 5, 13, 5, 85, 21, 90, 12, 10, 11, 85, 15, 82, 4, 1, 20, 26, 20, 90, 77, 42, 9, 64, 8, 85, 10, 7, 7, 64, 8, 92, 13, 41, 7, 90, 0, 84, 14, 1, 8, 64, 32, 80, 23, 13, 16, 93, 21, 74}, I1I.IL1Iii.IL1Iii(new byte[]{3, 88, 80, 81, 93, 85}, I1I.IL1Iii.IL1Iii(new byte[]{86, 88, 2, 0, 14, 85}, "aaa27f")))));
                context.startActivity(intent);
            }
        } catch (ActivityNotFoundException e) {
            Intent intent2 = new Intent();
            intent2.setFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
            intent2.setComponent(new ComponentName(I1I.IL1Iii.IL1Iii(new byte[]{84, 86, 8, 22, 118, 11, 83, 75, 10, 81, 83, 75, 68, 92, 17, 76, 94, 11, 80, 74}, I1I.IL1Iii.IL1Iii(new byte[]{14, 12, 84, 15, 2, 93}, I1I.IL1Iii.IL1Iii(new byte[]{90, 81, 80, 6, 7, 94}, "cda12f"))), I1I.IL1Iii.IL1Iii(new byte[]{5, 13, 93, 75, 80, 86, 2, 16, 95, 12, 85, 22, 21, 7, 68, 17, 88, 86, 1, 17, 30, 21, 84, 74, 11, 11, 67, 22, 88, 87, 8, 76, 100, 4, 83, 113, 18, 7, 93}, I1I.IL1Iii.IL1Iii(new byte[]{95, 82, 6, 1, 80, 9}, I1I.IL1Iii.IL1Iii(new byte[]{91, 7, 82, 2, 4, 85}, "b7dfed")))));
            context.startActivity(intent2);
            e.printStackTrace();
            Log.e(f3356IL1Iii, Log.getStackTraceString(e));
        } catch (SecurityException e2) {
            Intent intent3 = new Intent();
            intent3.setFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
            intent3.setComponent(new ComponentName(I1I.IL1Iii.IL1Iii(new byte[]{5, 91, 15, 30, 13, 17, 7, 67, 7, 89, 75, 23, 31, 71, 22, 85, 8, 9, 7, 90, 3, 87, 0, 22}, I1I.IL1Iii.IL1Iii(new byte[]{87, 82, 6, 0, 84, 86}, I1I.IL1Iii.IL1Iii(new byte[]{7, 3, 84, 86, 82, 80}, "6e0fcb"))), I1I.IL1Iii.IL1Iii(new byte[]{86, 92, 88, 74, 80, 65, 84, 68, 80, 13, 22, 68, 80, 65, 88, 13, 75, 71, 92, 92, 91, 9, 89, 90, 84, 84, 80, 22, 22, 65, 92, 29, 120, 5, 81, 90, 116, 80, 65, 13, 78, 93, 65, 74}, I1I.IL1Iii.IL1Iii(new byte[]{7, 5, 87, 82, 0, 12}, I1I.IL1Iii.IL1Iii(new byte[]{3, 4, 1, 82, 1, 13}, "12cd95")))));
            context.startActivity(intent3);
            Log.e(f3356IL1Iii, Log.getStackTraceString(e2));
        } catch (Exception e3) {
            Toast.makeText(context, I1I.IL1Iii.IL1Iii(new byte[]{-117, -114, -81, -125, -76, -99, -117, -97, -118, -127, -116, -106, -118, -112, -127, -113, -84, -102, -122, -107, -123, -114, -123, -99, -116, -115, -72, -114, -98, -113, -123, -72, -65, -125, -69, -112, -117, -97, -118, -127, -116, -106}, I1I.IL1Iii.IL1Iii(new byte[]{1, 82, 7, 81, 1, 91}, I1I.IL1Iii.IL1Iii(new byte[]{81, 91, 5, 2, 3, 86}, "386535"))), 1).show();
            Log.e(f3356IL1Iii, Log.getStackTraceString(e3));
        }
    }

    public static boolean ILil(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return I1I(context, 24);
        }
        return true;
    }
}
