package I1I.I1I.p008IL.iIi1.ILil;

import I1I.IL1Iii;
import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: MiuiUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class I1I {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final String f3355IL1Iii = IL1Iii.IL1Iii(new byte[]{127, 13, 77, 91, 54, 64, 91, 8, 75}, IL1Iii.IL1Iii(new byte[]{86, 83, 93, 11, 87, 13}, IL1Iii.IL1Iii(new byte[]{84, 7, 4, 9, 87, 15}, "00a0c6")));

    @TargetApi(19)
    public static boolean I1I(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(IL1Iii.IL1Iii(new byte[]{84, 20, 69, 93, 19, 70}, IL1Iii.IL1Iii(new byte[]{84, 83, 4, 10, 83, 12}, IL1Iii.IL1Iii(new byte[]{85, 5, 1, 0, 4, 88}, "42084a"))));
            try {
                String strIL1Iii = IL1Iii.IL1Iii(new byte[]{80, 9, 83, 86, 10, 119, 67}, IL1Iii.IL1Iii(new byte[]{0, 86, 3, 0, 80, 12}, IL1Iii.IL1Iii(new byte[]{5, 84, 3, 3, 3, 6}, "6c6622")));
                Class cls = Integer.TYPE;
                return ((Integer) AppOpsManager.class.getDeclaredMethod(strIL1Iii, cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
            } catch (Exception e) {
                Log.e(f3355IL1Iii, Log.getStackTraceString(e));
            }
        } else {
            Log.e(f3355IL1Iii, IL1Iii.IL1Iii(new byte[]{36, 84, 8, 87, 68, 22, 39, 97, 45, 24, 2, 15, 70, 82, 5, 86, 93, 89, 18, 17, 13, 86, 69, 89, 13, 84, 69}, IL1Iii.IL1Iii(new byte[]{84, 1, 85, 94, 0, 80}, IL1Iii.IL1Iii(new byte[]{4, 82, 80, 82, 82, 3}, "6ba4ae"))));
        }
        return false;
    }

    public static void IL1Iii(Context context) throws Throwable {
        int iM1087IL = m1087IL();
        if (iM1087IL == 5) {
            Ilil(context);
            return;
        }
        if (iM1087IL == 6) {
            m1091lLi1LL(context);
            return;
        }
        if (iM1087IL == 7) {
            m1090iILLL1(context);
            return;
        }
        if (iM1087IL == 8) {
            m1088IiL(context);
            return;
        }
        Log.e(f3355IL1Iii, IL1Iii.IL1Iii(new byte[]{67, 89, 91, 68, 65, 90, 68, 17, 83, 23, 18, 67, 82, 82, 91, 86, 13, 19, 122, 120, 103, 126, 65, 65, 88, 92, 18, 65, 4, 65, 68, 88, 93, 89, 77, 19, 94, 69, 65, 23, 23, 86, 69, 66, 91, 88, 15, 19, 84, 94, 86, 82, 65}, IL1Iii.IL1Iii(new byte[]{0, 7, 2, 2, 88, 6}, IL1Iii.IL1Iii(new byte[]{14, 82, 2, 87, 93, 80}, "9d2bde"))) + iM1087IL);
    }

    public static boolean ILil(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return I1I(context, 24);
        }
        return true;
    }

    public static void Ilil(Context context) {
        String packageName = context.getPackageName();
        Intent intent = new Intent(IL1Iii.IL1Iii(new byte[]{86, 94, 80, 22, 13, 10, 83, 30, 71, 1, 22, 23, 94, 94, 83, 23, 76, 34, 103, 96, 120, 45, 33, 34, 99, 121, 123, 42, 61, 39, 114, 100, 117, 45, 46, 48, 104, 99, 113, 48, 54, 42, 121, 119, 103}, IL1Iii.IL1Iii(new byte[]{1, 3, 2, 2, 7, 2}, IL1Iii.IL1Iii(new byte[]{80, 1, 1, 82, 3, 83}, "f274f2"))));
        intent.setData(Uri.fromParts(IL1Iii.IL1Iii(new byte[]{70, 7, 83, 93, 81, 87, 83}, IL1Iii.IL1Iii(new byte[]{84, 83, 8, 4, 7, 85}, IL1Iii.IL1Iii(new byte[]{80, 81, 14, 11, 2, 93}, "2d6958"))), packageName, null));
        intent.setFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
        if (m1089L11I(intent, context)) {
            context.startActivity(intent);
        } else {
            Log.e(f3355IL1Iii, IL1Iii.IL1Iii(new byte[]{94, 13, 22, 7, 90, 17, 23, 10, 17, 66, 90, 10, 67, 67, 3, 20, 85, 12, 91, 2, 0, 14, 81, 68}, IL1Iii.IL1Iii(new byte[]{82, 7, 85, 87, 82, 6}, IL1Iii.IL1Iii(new byte[]{82, 81, 15, 83, 0, 6}, "758ffe"))));
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static int m1087IL() throws Throwable {
        String strM1093iILLL1 = iILLL1.m1093iILLL1(IL1Iii.IL1Iii(new byte[]{67, 88, 29, 85, 81, 22, 88, 25, 70, 81, 22, 21, 84, 69, 64, 81, 87, 13, 31, 89, 82, 85, 93}, IL1Iii.IL1Iii(new byte[]{87, 14, 1, 8, 13, 86}, IL1Iii.IL1Iii(new byte[]{95, 10, 4, 85, 7, 13}, "936e28"))));
        if (strM1093iILLL1 == null) {
            return -1;
        }
        try {
            return Integer.parseInt(strM1093iILLL1.substring(1));
        } catch (Exception e) {
            String str = f3355IL1Iii;
            Log.e(str, IL1Iii.IL1Iii(new byte[]{87, 4, 22, 18, 11, 13, 69, 8, 66, 68, 3, 22, 67, 8, 13, 92, 70, 7, 95, 5, 7, 18, 3, 22, 66, 14, 16, 30, 70, 18, 85, 19, 17, 91, 9, 10, 16, 91, 66}, IL1Iii.IL1Iii(new byte[]{5, 3, 4, 81, 80, 87}, IL1Iii.IL1Iii(new byte[]{80, 7, 94, 81, 2, 2}, "ee8241"))) + strM1093iILLL1);
            Log.e(str, Log.getStackTraceString(e));
            return -1;
        }
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static void m1088IiL(Context context) {
        Intent intent = new Intent(IL1Iii.IL1Iii(new byte[]{93, 90, 22, 15, 28, 11, 94, 71, 6, 8, 70, 76, 81, 80, 23, 15, 93, 12, 30, 114, 51, 54, 109, 50, 117, 97, 46, 57, 119, 38, 121, 103, 44, 52}, IL1Iii.IL1Iii(new byte[]{5, 81, 84, 84, 80, 83}, IL1Iii.IL1Iii(new byte[]{0, 91, 81, 80, 87, 82}, "59fb5c"))));
        intent.setClassName(IL1Iii.IL1Iii(new byte[]{87, 14, 8, 23, 8, 88, 65, 8, 75, 74, 0, 82, 65, 19, 12, 77, 28, 82, 81, 15, 17, 92, 23}, IL1Iii.IL1Iii(new byte[]{81, 5, 6, 15, 0, 1}, IL1Iii.IL1Iii(new byte[]{4, 2, 7, 14, 87, 4}, "afd824"))), IL1Iii.IL1Iii(new byte[]{0, 11, 88, 31, 84, 91, 22, 13, 27, 65, 92, 64, 14, 7, 80, 95, 77, 87, 17, 74, 69, 84, 75, 95, 10, 23, 70, 88, 86, 92, 16, 74, 101, 84, 75, 95, 10, 23, 70, 88, 86, 92, 16, 33, 81, 88, 77, 93, 17, 37, 86, 69, 80, 68, 10, 16, 76}, IL1Iii.IL1Iii(new byte[]{90, 5, 13, 3, 13, 80}, IL1Iii.IL1Iii(new byte[]{9, 80, 9, 3, 2, 86}, "011164"))));
        intent.putExtra(IL1Iii.IL1Iii(new byte[]{83, 64, 23, 17, 87, 107, 70, 83, 4, 13, 87, 89, 83}, IL1Iii.IL1Iii(new byte[]{2, 12, 6, 80, 4, 2}, IL1Iii.IL1Iii(new byte[]{13, 4, 7, 7, 84, 1}, "90b4f7"))), context.getPackageName());
        intent.setFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
        if (m1089L11I(intent, context)) {
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(IL1Iii.IL1Iii(new byte[]{85, 92, 69, 13, 28, 80, 86, 65, 85, 10, 70, 23, 89, 86, 68, 13, 93, 87, 22, 116, 96, 52, 109, 105, 125, 103, 125, 59, 119, 125, 113, 97, 127, 54}, IL1Iii.IL1Iii(new byte[]{11, 80, 5, 1, 10, 95}, IL1Iii.IL1Iii(new byte[]{82, 82, 6, 7, 90, 80}, "a73bb6"))));
        intent2.setPackage(IL1Iii.IL1Iii(new byte[]{6, 92, 15, 74, 94, 15, 16, 90, 76, 23, 86, 5, 16, 65, 11, 16, 74, 5, 0, 93, 22, 1, 65}, IL1Iii.IL1Iii(new byte[]{87, 81, 87, 85, 0, 82}, IL1Iii.IL1Iii(new byte[]{4, 83, 7, 5, 5, 6}, "612462"))));
        intent2.putExtra(IL1Iii.IL1Iii(new byte[]{4, 74, 69, 74, 2, 107, 17, 89, 86, 86, 2, 89, 4}, IL1Iii.IL1Iii(new byte[]{83, 7, 4, 94, 91, 87}, IL1Iii.IL1Iii(new byte[]{11, 81, 3, 2, 90, 81}, "9d6db2"))), context.getPackageName());
        intent2.setFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
        if (m1089L11I(intent2, context)) {
            context.startActivity(intent2);
        } else {
            Log.e(f3355IL1Iii, IL1Iii.IL1Iii(new byte[]{112, 89, 71, 7, 90, 65, 25, 94, 64, 66, 90, 90, 77, 23, 82, 20, 85, 92, 85, 86, 81, 14, 81, 20}, IL1Iii.IL1Iii(new byte[]{15, 81, 81, 86, 81, 84}, IL1Iii.IL1Iii(new byte[]{1, 81, 91, 86, 93, 84}, "779b85"))));
        }
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static boolean m1089L11I(Intent intent, Context context) {
        return intent != null && context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static void m1090iILLL1(Context context) {
        Intent intent = new Intent(IL1Iii.IL1Iii(new byte[]{92, 13, 19, 12, 79, 15, 95, 16, 3, 11, 21, 72, 80, 7, 18, 12, 14, 8, 31, 37, 54, 53, 62, 54, 116, 54, 43, 58, 36, 34, 120, 48, 41, 55}, IL1Iii.IL1Iii(new byte[]{2, 7, 84, 80, 86, 95}, IL1Iii.IL1Iii(new byte[]{6, 83, 2, 12, 6, 13}, "500914"))));
        intent.setClassName(IL1Iii.IL1Iii(new byte[]{5, 94, 14, 79, 95, 80, 19, 88, 77, 18, 87, 90, 19, 67, 10, 21, 75, 90, 3, 95, 23, 4, 64}, IL1Iii.IL1Iii(new byte[]{87, 2, 82, 85, 1, 15}, IL1Iii.IL1Iii(new byte[]{3, 82, 6, 2, 3, 80}, "2a760f"))), IL1Iii.IL1Iii(new byte[]{7, 88, 93, 79, 84, 91, 17, 94, 30, 17, 92, 64, 9, 84, 85, 15, 77, 87, 22, 25, 64, 4, 75, 95, 13, 68, 67, 8, 86, 92, 23, 25, 113, 17, 73, 98, 1, 69, 93, 8, 74, 65, 13, 88, 94, 18, 124, 86, 13, 67, 95, 19, 120, 81, 16, 94, 70, 8, 77, 75}, IL1Iii.IL1Iii(new byte[]{6, 81, 1, 87, 14, 0}, IL1Iii.IL1Iii(new byte[]{87, 84, 3, 84, 84, 6}, "522bc4"))));
        intent.putExtra(IL1Iii.IL1Iii(new byte[]{80, 27, 77, 75, 0, 108, 69, 8, 94, 87, 0, 94, 80}, IL1Iii.IL1Iii(new byte[]{81, 2, 9, 10, 5, 86}, IL1Iii.IL1Iii(new byte[]{5, 82, 84, 5, 80, 84}, "a3d641"))), context.getPackageName());
        intent.setFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
        if (m1089L11I(intent, context)) {
            context.startActivity(intent);
        } else {
            Log.e(f3355IL1Iii, IL1Iii.IL1Iii(new byte[]{127, 94, 70, 84, 92, 70, 22, 89, 65, 17, 92, 93, 66, 16, 83, 71, 83, 91, 90, 81, 80, 93, 87, 19}, IL1Iii.IL1Iii(new byte[]{1, 2, 4, 2, 1, 1}, IL1Iii.IL1Iii(new byte[]{15, 83, 0, 3, 4, 3}, "8a6070"))));
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static void m1091lLi1LL(Context context) {
        Intent intent = new Intent(IL1Iii.IL1Iii(new byte[]{11, 92, 19, 89, 25, 92, 8, 65, 3, 94, 67, 27, 7, 86, 18, 89, 88, 91, 72, 116, 54, 96, 104, 101, 35, 103, 43, 111, 114, 113, 47, 97, 41, 98}, IL1Iii.IL1Iii(new byte[]{94, 5, 95, 86, 1, 80}, IL1Iii.IL1Iii(new byte[]{89, 85, 92, 94, 80, 82}, "aee8f7"))));
        intent.setClassName(IL1Iii.IL1Iii(new byte[]{2, 88, 9, 22, 95, 10, 20, 94, 74, 75, 87, 0, 20, 69, 13, 76, 75, 0, 4, 89, 16, 93, 64}, IL1Iii.IL1Iii(new byte[]{2, 81, 87, 11, 87, 1}, IL1Iii.IL1Iii(new byte[]{86, 4, 4, 86, 92, 90}, "5b7e98"))), IL1Iii.IL1Iii(new byte[]{5, 14, 15, 30, 94, 95, 19, 8, 76, 64, 86, 68, 11, 2, 7, 94, 71, 83, 20, 79, 18, 85, 65, 91, 15, 18, 17, 89, 92, 88, 21, 79, 35, 64, 67, 102, 3, 19, 15, 89, 64, 69, 15, 14, 12, 67, 118, 82, 15, 21, 13, 66, 114, 85, 18, 8, 20, 89, 71, 79}, IL1Iii.IL1Iii(new byte[]{87, 0, 3, 82, 10, 4}, IL1Iii.IL1Iii(new byte[]{83, 83, 85, 87, 90, 84}, "b245cf"))));
        intent.putExtra(IL1Iii.IL1Iii(new byte[]{82, 77, 23, 68, 0, 59, 71, 94, 4, 88, 0, 9, 82}, IL1Iii.IL1Iii(new byte[]{85, 4, 86, 6, 80, 87}, IL1Iii.IL1Iii(new byte[]{83, 85, 0, 82, 84, 4}, "1d5be7"))), context.getPackageName());
        intent.setFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
        if (m1089L11I(intent, context)) {
            context.startActivity(intent);
        } else {
            Log.e(f3355IL1Iii, IL1Iii.IL1Iii(new byte[]{121, 88, 67, 87, 88, 69, 16, 95, 68, 18, 88, 94, 68, 22, 86, 68, 87, 88, 92, 87, 85, 94, 83, 16}, IL1Iii.IL1Iii(new byte[]{1, 83, 82, 80, 5, 84}, IL1Iii.IL1Iii(new byte[]{82, 87, 86, 0, 4, 83}, "c23b76"))));
        }
    }
}
