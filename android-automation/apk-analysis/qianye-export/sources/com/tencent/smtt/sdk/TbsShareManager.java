package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build;
import com.google.android.flexbox.BuildConfig;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class TbsShareManager {

    /* JADX INFO: renamed from: a */
    private static Context f378a = null;

    /* JADX INFO: renamed from: b */
    private static boolean f379b = false;
    public static boolean mHasQueried = false;

    @Deprecated
    public static int findCoreForThirdPartyApp(Context context) {
        return -1;
    }

    @Deprecated
    public static File getBackupCoreFile(Context context, String str) {
        return null;
    }

    @Deprecated
    public static int getBackupCoreVersion(Context context, String str) {
        return 0;
    }

    @Deprecated
    public static File getBackupDecoupleCoreFile(Context context, String str) {
        return null;
    }

    @Deprecated
    public static int getBackupDecoupleCoreVersion(Context context, String str) {
        return 0;
    }

    @Deprecated
    public static boolean getCoreDisabled() {
        return false;
    }

    @Deprecated
    public static String[] getCoreProviderAppList() {
        return new String[0];
    }

    @Deprecated
    public static int getCoreShareDecoupleCoreVersion(Context context, String str) {
        return 0;
    }

    @Deprecated
    public static String getHostCorePathAppDefined() {
        return BuildConfig.FLAVOR;
    }

    public static Context getPackageContext(Context context, String str, boolean z) {
        if (context != null && context.getPackageName().equals(str)) {
            return context;
        }
        if (context == null) {
            TbsLog.m662e("TbsShareManager", "getPackageContext appContext is null!!");
            return null;
        }
        if (z) {
            try {
                if (!context.getPackageName().equals(str) && (TbsPVConfig.getInstance(context).isEnableNoCoreGray() || Build.VERSION.SDK_INT >= 29)) {
                    return null;
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        return context.createPackageContext(str, 2);
    }

    @Deprecated
    public static File getSDCoreFile(Context context, String str, int i) {
        return null;
    }

    @Deprecated
    public static int getSharedTbsCoreVersion(Context context, String str) {
        return 0;
    }

    @Deprecated
    public static File getStableCoreFile(Context context, String str) {
        return null;
    }

    @Deprecated
    public static int getStableCoreVersion(Context context, String str) {
        return 0;
    }

    @Deprecated
    public static int getTbsStableCoreVersion(Context context, int i) {
        return 0;
    }

    public static boolean isThirdPartyApp(Context context) {
        try {
            Context context2 = f378a;
            if (context2 != null && context2.equals(context.getApplicationContext())) {
                return f379b;
            }
            Context applicationContext = context.getApplicationContext();
            f378a = applicationContext;
            String packageName = applicationContext.getPackageName();
            String[] strArr = {TbsConfig.APP_DEMO, TbsConfig.APP_WX, TbsConfig.APP_QQ, TbsConfig.APP_QZONE, "com.tencent.qqlite"};
            for (int i = 0; i < 5; i++) {
                if (packageName.equals(strArr[i])) {
                    f379b = false;
                    return false;
                }
            }
            f379b = true;
            return true;
        } catch (Throwable th) {
            TbsLog.m668i(th);
        }
    }

    @Deprecated
    public static void setHostCorePathAppDefined(String str) {
    }
}
