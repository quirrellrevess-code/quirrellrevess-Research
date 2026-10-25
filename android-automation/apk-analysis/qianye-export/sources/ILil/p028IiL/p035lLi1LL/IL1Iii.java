package ILil.p028IiL.p035lLi1LL;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.TypedValue;
import java.io.File;

/* JADX INFO: compiled from: ContextCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final Object f4218IL1Iii = new Object();

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static TypedValue f4219ILil;

    public static ColorStateList I1I(Context context, int i) {
        return Build.VERSION.SDK_INT >= 23 ? context.getColorStateList(i) : context.getResources().getColorStateList(i);
    }

    public static int IL1Iii(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    public static int ILil(Context context, int i) {
        return Build.VERSION.SDK_INT >= 23 ? context.getColor(i) : context.getResources().getColor(i);
    }

    public static File[] Ilil(Context context) {
        return Build.VERSION.SDK_INT >= 19 ? context.getExternalCacheDirs() : new File[]{context.getExternalCacheDir()};
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static Drawable m2321IL(Context context, int i) {
        int i2;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            return context.getDrawable(i);
        }
        if (i3 >= 16) {
            return context.getResources().getDrawable(i);
        }
        synchronized (f4218IL1Iii) {
            if (f4219ILil == null) {
                f4219ILil = new TypedValue();
            }
            context.getResources().getValue(i, f4219ILil, true);
            i2 = f4219ILil.resourceId;
        }
        return context.getResources().getDrawable(i2);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static boolean m2322iILLL1(Context context, Intent[] intentArr, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            context.startActivities(intentArr, bundle);
            return true;
        }
        context.startActivities(intentArr);
        return true;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static File[] m2323lLi1LL(Context context, String str) {
        return Build.VERSION.SDK_INT >= 19 ? context.getExternalFilesDirs(str) : new File[]{context.getExternalFilesDir(str)};
    }
}
