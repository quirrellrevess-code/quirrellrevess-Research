package I1I.I1I.ILil;

import android.app.ActivityThread;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.UserHandle;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: I1I.I1I.ILil.丨lL, reason: invalid class name */
/* JADX INFO: compiled from: HiddenApiBridge.java */
/* JADX INFO: loaded from: classes.dex */
public class lL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static Method f3311IL1Iii;

    public static Context I1I() {
        return ActivityThread.systemMain().getSystemContext();
    }

    public static Context IL1Iii(Context context, String str, int i, UserHandle userHandle) throws PackageManager.NameNotFoundException {
        if (f3311IL1Iii == null) {
            try {
                f3311IL1Iii = Context.class.getMethod(I1I.IL1Iii.IL1Iii(new byte[]{81, 69, 84, 4, 70, 82, 98, 86, 82, 14, 83, 80, 87, 116, 94, 11, 70, 82, 74, 67, 112, 22, 103, 68, 87, 69}, I1I.IL1Iii.IL1Iii(new byte[]{0, 4, 0, 4, 87, 7}, I1I.IL1Iii.IL1Iii(new byte[]{83, 10, 83, 89, 80, 8}, "a9b858"))), String.class, Integer.TYPE, UserHandle.class);
            } catch (NoSuchMethodException unused) {
            }
        }
        try {
            Method method = f3311IL1Iii;
            if (method != null) {
                return (Context) method.invoke(context, str, Integer.valueOf(i), userHandle);
            }
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static UserHandle ILil(int i) {
        try {
            return (UserHandle) UserHandle.class.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(i));
        } catch (Exception unused) {
            return null;
        }
    }
}
