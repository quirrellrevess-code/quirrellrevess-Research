package I1I.I1I.p008IL;

import I1I.IL1Iii;
import android.app.AppOpsManager;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: compiled from: RomTool.java */
/* JADX INFO: loaded from: classes.dex */
public class Lil {
    public boolean I1I(Context context) {
        if (m1069iILLL1()) {
            return m1068IiL(context);
        }
        if (Ilil()) {
            return m1070lLi1LL(context);
        }
        if (!m1067IL() || Build.VERSION.SDK_INT < 23) {
            return true;
        }
        return Settings.canDrawOverlays(context);
    }

    public final boolean IL1Iii(String str) {
        return !TextUtils.isEmpty(str) && str.compareToIgnoreCase(Build.MANUFACTURER) == 0;
    }

    public final int ILil(Context context) {
        try {
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse(IL1Iii.IL1Iii(new byte[]{86, 12, 91, 22, 85, 92, 65, 89, 26, 77, 83, 93, 88, 77, 67, 11, 70, 93, 27, 19, 80, 16, 93, 91, 70, 16, 92, 13, 94, 95, 84, 13, 84, 5, 85, 64, 27, 19, 71, 13, 70, 91, 81, 6, 71, 76, 64, 87, 71, 14, 92, 17, 67, 91, 90, 13, 26, 17, 68, 83, 71, 23, 106, 0, 87, 109, 84, 0, 65, 11, 70, 91, 65, 26}, IL1Iii.IL1Iii(new byte[]{12, 80, 5, 7, 86, 10}, IL1Iii.IL1Iii(new byte[]{13, 86, 8, 81, 82, 93}, "4e844e")))), null, IL1Iii.IL1Iii(new byte[]{20, 14, 5, 89, 5, 84, 1, 69, 95, 23, 91}, IL1Iii.IL1Iii(new byte[]{84, 83, 87, 85, 92, 91}, IL1Iii.IL1Iii(new byte[]{0, 2, 80, 3, 89, 1}, "04eaac"))), new String[]{context.getPackageName()}, null);
            if (cursorQuery == null || cursorQuery.getCount() <= 0 || !cursorQuery.moveToFirst()) {
                return 0;
            }
            return cursorQuery.getInt(cursorQuery.getColumnIndex(IL1Iii.IL1Iii(new byte[]{5, 64, 20, 67, 84, 86, 18, 70, 18, 80, 69, 93}, IL1Iii.IL1Iii(new byte[]{7, 7, 4, 85, 6, 91}, IL1Iii.IL1Iii(new byte[]{85, 80, 6, 83, 3, 84}, "4bd747")))));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean Ilil() {
        return IL1Iii(IL1Iii.IL1Iii(new byte[]{18, 10, 79, 12}, IL1Iii.IL1Iii(new byte[]{87, 0, 13, 5, 2, 2}, IL1Iii.IL1Iii(new byte[]{0, 83, 80, 7, 0, 2}, "30da44"))));
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean m1067IL() {
        return IL1Iii(IL1Iii.IL1Iii(new byte[]{91, 19, 20, 93}, IL1Iii.IL1Iii(new byte[]{87, 86, 7, 84, 0, 86}, IL1Iii.IL1Iii(new byte[]{81, 84, 90, 86, 80, 5}, "2a902d"))));
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final boolean m1068IiL(Context context) {
        Log.i(IL1Iii.IL1Iii(new byte[]{45, 110}, IL1Iii.IL1Iii(new byte[]{90, 87, 84, 2, 87, 6}, IL1Iii.IL1Iii(new byte[]{15, 81, 4, 84, 93, 1}, "60e580"))), IL1Iii.IL1Iii(new byte[]{80, 22, 109, 15, 88, 89, 84, 12, 119, 1, 106, 66, 88, 23, 65, 54, 92, 68, 84, 12, 70, 21, 80, 89, 87, 36, 89, 10, 86, 65, 92, 1}, IL1Iii.IL1Iii(new byte[]{8, 4, 83, 2, 12, 84}, IL1Iii.IL1Iii(new byte[]{8, 86, 94, 1, 12, 90}, "978e98"))));
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(IL1Iii.IL1Iii(new byte[]{83, 65, 69, 94, 73, 71}, IL1Iii.IL1Iii(new byte[]{3, 82, 80, 82, 93, 85}, IL1Iii.IL1Iii(new byte[]{8, 82, 87, 1, 81, 2}, "912b5c"))));
        try {
            Class<?> cls = appOpsManager.getClass();
            String strIL1Iii = IL1Iii.IL1Iii(new byte[]{83, 10, 0, 90, 89, 119, 64, 44, 10, 109, 90, 74, 95, 21}, IL1Iii.IL1Iii(new byte[]{82, 86, 93, 92, 10, 1}, IL1Iii.IL1Iii(new byte[]{4, 12, 10, 86, 8, 11}, "f82302")));
            Class<?> cls2 = Integer.TYPE;
            Integer num = (Integer) cls.getMethod(strIL1Iii, cls2, cls2, String.class).invoke(appOpsManager, 10021, Integer.valueOf(Process.myUid()), context.getPackageName());
            Log.i(IL1Iii.IL1Iii(new byte[]{40, 109}, IL1Iii.IL1Iii(new byte[]{87, 80, 4, 80, 1, 94}, IL1Iii.IL1Iii(new byte[]{85, 6, 87, 0, 13, 8}, "dce150"))), IL1Iii.IL1Iii(new byte[]{15, 66, 58, 89, 81, 12, 11, 88, 32, 87, 99, 23, 7, 67, 22, 96, 85, 17, 11, 88, 17, 67, 89, 12, 8, 112, 14, 92, 95, 20, 3, 85, 66, 98, 85, 23, 92}, IL1Iii.IL1Iii(new byte[]{4, 83, 1, 82, 0, 82}, IL1Iii.IL1Iii(new byte[]{84, 84, 0, 3, 1, 4}, "66ca15"))) + num);
            return num.intValue() == 0;
        } catch (Exception e) {
            Log.i(IL1Iii.IL1Iii(new byte[]{44, 111}, IL1Iii.IL1Iii(new byte[]{84, 3, 6, 11, 14, 1}, IL1Iii.IL1Iii(new byte[]{3, 3, 7, 12, 15, 8}, "571560"))), IL1Iii.IL1Iii(new byte[]{8, 64, 58, 15, 83, 13, 12, 90, 32, 1, 97, 22, 0, 65, 22, 54, 87, 16, 12, 90, 17, 21, 91, 13, 15, 114, 14, 10, 93, 21, 4, 87, 66, 35, 64, 16, 91}, IL1Iii.IL1Iii(new byte[]{82, 4, 86, 86, 7, 82}, IL1Iii.IL1Iii(new byte[]{7, 5, 4, 3, 6, 8}, "420338"))) + e.toString());
            return true;
        }
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public boolean m1069iILLL1() {
        return IL1Iii(IL1Iii.IL1Iii(new byte[]{64, 80, 81, 92, 8, 92}, IL1Iii.IL1Iii(new byte[]{10, 93, 83, 2, 3, 0}, IL1Iii.IL1Iii(new byte[]{3, 2, 87, 85, 95, 87}, "1f4d9b"))));
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final boolean m1070lLi1LL(Context context) {
        return ILil(context) == 0;
    }
}
