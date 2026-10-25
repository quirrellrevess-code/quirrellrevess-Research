package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.C0453j;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class TbsExtensionFunctionManager {
    public static final String BUGLY_SWITCH_FILE_NAME = "bugly_switch.txt";
    public static final String COOKIE_SWITCH_FILE_NAME = "cookie_switch.txt";
    public static final String DISABLE_GET_APK_VERSION_SWITCH_FILE_NAME = "disable_get_apk_version_switch.txt";
    public static final String DISABLE_UNPREINIT = "disable_unpreinit.txt";
    public static final String DISABLE_USE_HOST_BACKUP_CORE = "disable_use_host_backup_core.txt";
    public static final String SP_KEY_COOKIE_DB_VERSION = "cookie_db_version";
    public static final String SP_NAME_FOR_COOKIE = "cookie_compatiable";
    public static final int SWITCH_BYTE_COOKIE = 1;
    public static final int SWITCH_BYTE_DISABLE_GET_APK_VERSION = 2;
    public static final int SWITCH_BYTE_DISABLE_UNPREINIT = 4;
    public static final int SWITCH_BYTE_DISABLE_USE_HOST_BACKUPCORE = 8;
    public static final String USEX5_FILE_NAME = "usex5.txt";

    /* JADX INFO: renamed from: b */
    private static TbsExtensionFunctionManager f320b;

    /* JADX INFO: renamed from: a */
    private boolean f321a;

    private TbsExtensionFunctionManager() {
    }

    public static TbsExtensionFunctionManager getInstance() {
        if (f320b == null) {
            synchronized (TbsExtensionFunctionManager.class) {
                if (f320b == null) {
                    f320b = new TbsExtensionFunctionManager();
                }
            }
        }
        return f320b;
    }

    public synchronized boolean canUseFunction(Context context, String str) {
        File file;
        file = new File(context.getFilesDir(), str);
        return file.exists() && file.isFile();
    }

    public synchronized int getRomCookieDBVersion(Context context) {
        SharedPreferences sharedPreferences = Build.VERSION.SDK_INT >= 11 ? context.getSharedPreferences(SP_NAME_FOR_COOKIE, 4) : context.getSharedPreferences(SP_NAME_FOR_COOKIE, 0);
        if (sharedPreferences == null) {
            return -1;
        }
        return sharedPreferences.getInt(SP_KEY_COOKIE_DB_VERSION, -1);
    }

    public synchronized void initTbsBuglyIfNeed(Context context) {
        if (this.f321a) {
            return;
        }
        if (!canUseFunction(context, BUGLY_SWITCH_FILE_NAME)) {
            TbsLog.m665i("TbsExtensionFunMana", "bugly is forbiden!!");
            return;
        }
        File fileM452n = C0419m.m393a().m452n(context);
        if (fileM452n == null) {
            TbsLog.m665i("TbsExtensionFunMana", "getTbsCoreShareDir is null");
            return;
        }
        if (fileM452n.listFiles() != null && fileM452n.listFiles().length > 0) {
            String absolutePath = fileM452n.getAbsolutePath();
            if (TextUtils.isEmpty(absolutePath)) {
                TbsLog.m665i("TbsExtensionFunMana", "bugly init ,corePath is null");
                return;
            }
            File fileM452n2 = C0419m.m393a().m452n(context);
            if (fileM452n2 == null) {
                TbsLog.m665i("TbsExtensionFunMana", "bugly init ,optDir is null");
                return;
            }
            File file = new File(absolutePath, "tbs_bugly_dex.jar");
            try {
                C0453j.m761a(new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, fileM452n2.getAbsolutePath(), QbSdk.getSettings()).loadClass("com.tencent.smtt.tbs.bugly.TBSBuglyManager"), "initBugly", (Class<?>[]) new Class[]{Context.class, String.class, String.class, String.class}, context, absolutePath, String.valueOf(WebView.getTbsSDKVersion(context)), String.valueOf(WebView.getTbsCoreVersion(context)));
                this.f321a = true;
                TbsLog.m665i("TbsExtensionFunMana", "initTbsBuglyIfNeed success!");
                return;
            } catch (Throwable th) {
                TbsLog.m665i("TbsExtensionFunMana", "bugly init ,try init bugly failed(need new core):" + Log.getStackTraceString(th));
                return;
            }
        }
        TbsLog.m665i("TbsExtensionFunMana", "getTbsCoreShareDir is empty!");
    }

    public synchronized boolean setFunctionEnable(Context context, String str, boolean z) {
        if (context == null) {
            return false;
        }
        File file = new File(context.getFilesDir(), str);
        if (z) {
            if (!file.exists()) {
                try {
                    if (file.createNewFile()) {
                        return true;
                    }
                } catch (IOException e) {
                    TbsLog.m662e("TbsExtensionFunMana", "setFunctionEnable,createNewFile fail:" + str);
                    e.printStackTrace();
                    return false;
                }
            }
        } else if (file.exists()) {
            if (file.delete()) {
                return true;
            }
            TbsLog.m662e("TbsExtensionFunMana", "setFunctionEnable,file.delete fail:" + str);
            return false;
        }
        return true;
    }
}
