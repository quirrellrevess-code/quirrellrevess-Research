package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.flexbox.BuildConfig;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.C0445b;
import com.tencent.smtt.utils.C0449f;
import com.tencent.smtt.utils.C0453j;
import com.tencent.smtt.utils.C0457n;
import com.tencent.smtt.utils.C0461r;
import com.tencent.smtt.utils.C0462s;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import com.tencent.smtt.utils.Timer;
import com.tencent.smtt.utils.p004a.C0444a;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi"})
public class QbSdk {

    /* JADX INFO: renamed from: A */
    private static int f180A = 170;

    /* JADX INFO: renamed from: B */
    private static String f181B = null;

    /* JADX INFO: renamed from: C */
    private static String f182C = null;

    @Deprecated
    public static final int CORE_VER_ENABLE_202112 = 45912;
    public static final int CORE_VER_ENABLE_202207 = 46110;

    /* JADX INFO: renamed from: D */
    private static boolean f183D = false;

    /* JADX INFO: renamed from: E */
    private static boolean f184E = false;
    public static final int EXTENSION_INIT_FAILURE = -99999;

    /* JADX INFO: renamed from: F */
    private static boolean f185F = false;

    /* JADX INFO: renamed from: G */
    private static TbsListener f186G = null;

    /* JADX INFO: renamed from: H */
    private static TbsListener f187H = null;

    /* JADX INFO: renamed from: I */
    private static boolean f188I = false;

    /* JADX INFO: renamed from: J */
    private static boolean f189J = false;
    public static final String KEY_SET_SENDREQUEST_AND_UPLOAD = "SET_SENDREQUEST_AND_UPLOAD";
    public static final String KEY_THIRD_PARTY_TURING = "turing";
    public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
    public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
    public static final int QBMODE = 2;
    public static final String SHARE_PREFERENCES_NAME = "tbs_file_open_dialog_config";
    public static final String SVNVERSION = "jnizz";
    public static final int TBSMODE = 1;
    public static final String TID_QQNumber_Prefix = "QQ:";
    public static final int VERSION = 1;

    /* JADX INFO: renamed from: b */
    public static boolean f197b = false;

    /* JADX INFO: renamed from: c */
    public static boolean f198c = true;

    /* JADX INFO: renamed from: d */
    public static String f199d = null;

    /* JADX INFO: renamed from: e */
    public static boolean f200e = false;

    /* JADX INFO: renamed from: f */
    public static long f201f = 0;

    /* JADX INFO: renamed from: g */
    public static long f202g = 0;

    /* JADX INFO: renamed from: i */
    public static boolean f204i = true;

    /* JADX INFO: renamed from: j */
    public static boolean f205j = true;

    /* JADX INFO: renamed from: k */
    public static boolean f206k = false;

    /* JADX INFO: renamed from: l */
    public static boolean f207l = false;
    public static boolean mDisableUseHostBackupCore = false;

    /* JADX INFO: renamed from: p */
    private static int f211p = 0;

    /* JADX INFO: renamed from: q */
    private static String f212q = "";

    /* JADX INFO: renamed from: r */
    private static Class<?> f213r = null;

    /* JADX INFO: renamed from: s */
    private static Object f214s = null;
    public static boolean sIsVersionPrinted = false;

    /* JADX INFO: renamed from: t */
    private static boolean f215t = false;

    /* JADX INFO: renamed from: u */
    private static String[] f216u = null;

    /* JADX INFO: renamed from: v */
    private static String f217v = "NULL";

    /* JADX INFO: renamed from: w */
    private static String f218w = "UNKNOWN";

    /* JADX INFO: renamed from: x */
    private static boolean f219x = false;

    /* JADX INFO: renamed from: y */
    private static int f220y = -1;

    /* JADX INFO: renamed from: z */
    private static int f221z;

    /* JADX INFO: renamed from: h */
    public static Object f203h = new Object();

    /* JADX INFO: renamed from: a */
    public static boolean f196a = false;

    /* JADX INFO: renamed from: m */
    public static volatile boolean f208m = f196a;

    /* JADX INFO: renamed from: n */
    public static TbsListener f209n = new TbsListener() { // from class: com.tencent.smtt.sdk.QbSdk.5
        @Override // com.tencent.smtt.sdk.TbsListener
        public void onDownloadFinish(int i) {
            TbsDownloader.f291a = false;
            if (QbSdk.f186G != null) {
                QbSdk.f186G.onDownloadFinish(i);
            }
            if (QbSdk.f187H != null) {
                QbSdk.f187H.onDownloadFinish(i);
            }
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onDownloadProgress(int i) {
            if (QbSdk.f187H != null) {
                QbSdk.f187H.onDownloadProgress(i);
            }
            if (QbSdk.f186G != null) {
                QbSdk.f186G.onDownloadProgress(i);
            }
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onInstallFinish(int i) {
            if (i == 243 && QbSdk.f187H != null) {
                QbSdk.f187H.onInstallFinish(i);
                return;
            }
            if (i != 200) {
            }
            TbsLog.m667i("QbSdk", "onInstallFinish errCode is " + i, true);
            QbSdk.setTBSInstallingStatus(false);
            TbsDownloader.f291a = false;
            if (QbSdk.f186G != null) {
                QbSdk.f186G.onInstallFinish(i);
            }
            if (QbSdk.f187H != null) {
                QbSdk.f187H.onInstallFinish(i);
            }
        }
    };

    /* JADX INFO: renamed from: K */
    private static boolean f190K = false;

    /* JADX INFO: renamed from: L */
    private static boolean f191L = false;

    /* JADX INFO: renamed from: o */
    public static Map<String, Object> f210o = null;

    @Deprecated
    public static final String USER_ID_FROM_APP_IMSI = TbsPrivacyAccess.ConfigurablePrivacy.IMSI.f360a;

    @Deprecated
    public static final String USER_ID_FROM_APP_ANDROID_ID = TbsPrivacyAccess.ConfigurablePrivacy.ANDROID_ID.f360a;

    @Deprecated
    public static final String USER_ID_FROM_APP_MAC = TbsPrivacyAccess.ConfigurablePrivacy.MAC.f360a;

    @Deprecated
    public static final String USER_ID_FROM_APP_ANDROID_VERSION = TbsPrivacyAccess.ConfigurablePrivacy.ANDROID_VERSION.f360a;

    @Deprecated
    public static final String USER_ID_FROM_APP_DEVICE_MODEL = TbsPrivacyAccess.ConfigurablePrivacy.DEVICE_MODEL.f360a;
    public static final String USER_ID_FROM_APP_QIMEI36 = TbsPrivacyAccess.ConfigurablePrivacy.QIMEI36.f360a;

    /* JADX INFO: renamed from: M */
    private static int f192M = -1;

    /* JADX INFO: renamed from: N */
    private static Timer f193N = null;

    /* JADX INFO: renamed from: O */
    private static PrivateCDNMode f194O = PrivateCDNMode.NOT_USE;

    /* JADX INFO: renamed from: P */
    private static SystemCoreProtector f195P = null;

    public interface PreInitCallback {
        void onCoreInitFinished();

        void onViewInitFinished(boolean z);
    }

    public enum PrivateCDNMode {
        OFFICIAL_IMPL,
        SELF_IMPL,
        NOT_USE
    }

    /* JADX INFO: renamed from: com.tencent.smtt.sdk.QbSdk$a */
    public interface InterfaceC0362a {
        /* JADX INFO: renamed from: a */
        void m168a(File[] fileArr);
    }

    /* JADX INFO: renamed from: a */
    public static Bundle m146a(Context context, Bundle bundle) {
        TbsLogReport tbsLogReport;
        String str;
        if (m150a(context)) {
            Object objM763a = C0453j.m763a(f214s, "incrUpdate", (Class<?>[]) new Class[]{Context.class, Bundle.class}, context, bundle);
            if (objM763a != null) {
                return (Bundle) objM763a;
            }
            tbsLogReport = TbsLogReport.getInstance(context);
            str = "incrUpdate return null!";
        } else {
            tbsLogReport = TbsLogReport.getInstance(context);
            str = "initForPatch return false!";
        }
        tbsLogReport.setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_ERROR, str);
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static Object m147a(Context context, String str, Bundle bundle) {
        if (!m150a(context)) {
            return Integer.valueOf(EXTENSION_INIT_FAILURE);
        }
        Object objM763a = C0453j.m763a(f214s, "miscCall", (Class<?>[]) new Class[]{String.class, Bundle.class}, str, bundle);
        if (objM763a != null) {
            return objM763a;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static String m148a() {
        return f212q;
    }

    /* JADX INFO: renamed from: a */
    public static synchronized void m149a(Context context, String str) {
        if (f197b) {
            TbsCoreLoadStat.getInstance().m176a(context, 402, new Throwable(f217v));
            return;
        }
        if (f196a) {
            return;
        }
        f196a = true;
        f218w = "forceSysWebViewInner: " + str;
        TbsLog.m663e("QbSdk", "forceSysWebViewInner", "Reason:" + f218w);
        TbsLog.m663e("QbSdk", "forceSysWebViewInner", Log.getStackTraceString(new Throwable("#")));
        TbsCoreLoadStat.getInstance().m175a(context, 401);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m150a(Context context) {
        try {
            if (f213r != null) {
                return true;
            }
            File fileM452n = C0419m.m393a().m452n(context);
            if (fileM452n == null) {
                TbsLog.m662e("QbSdk", "QbSdk initExtension (false) optDir == null");
                return false;
            }
            File file = new File(fileM452n, "tbs_sdk_extension_dex.jar");
            if (!file.exists()) {
                TbsLog.m664e("QbSdk", "QbSdk initExtension (false) dexFile.exists()=false", true);
                return false;
            }
            TbsLog.m665i("QbSdk", "new DexLoader #3 dexFile is " + file.getAbsolutePath());
            C0431u.m530a().m533b(context);
            C0457n.m789a(context);
            f213r = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, fileM452n.getAbsolutePath(), getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
            if (isEnableSensitiveApi() || C0453j.m761a(f213r, "isSuiteableGetSensitative", (Class<?>[]) new Class[0], new Object[0]) != null) {
                loadTBSSDKExtension(context, file.getParent());
                return true;
            }
            TbsLog.m662e("QbSdk", "isSuiteableGetSensitative check failed,can not use x5");
            return false;
        } catch (Throwable th) {
            TbsLog.m662e("QbSdk", "initExtension sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m151a(Context context, int i) {
        return m152a(context, i, 20000);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m152a(Context context, int i, int i2) {
        Map<String, Object> map = f210o;
        if (map != null && map.containsKey(KEY_SET_SENDREQUEST_AND_UPLOAD) && f210o.get(KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.m665i("QbSdk", "[QbSdk.isX5Disabled] -- SET_SENDREQUEST_AND_UPLOAD is false");
            return true;
        }
        if (!isEnableSensitiveApi() && C0453j.m761a(f213r, "isSuiteableGetSensitative", (Class<?>[]) new Class[0], new Object[0]) == null) {
            TbsLog.m662e("QbSdk", "isSuiteableGetSensitative check failed,can not use x5");
            return false;
        }
        C0419m.m393a().m435b(context, C0412f.f512a == 0);
        if (m161d(context)) {
            return TbsDownloader.isTbsCoreDisabledBySwitch(context.getApplicationContext(), i);
        }
        return true;
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: a */
    private static boolean m153a(Context context, boolean z) {
        TbsLog.initIfNeed(context);
        if (!sIsVersionPrinted) {
            TbsLog.m665i("QbSdk", "svn revision: jnizz; SDK_VERSION_CODE: 44286; SDK_VERSION_NAME: 4.3.0.386");
            sIsVersionPrinted = true;
        }
        if (f196a && !z) {
            TbsCoreLoadStat.getInstance().m175a(context, 414);
            TbsLog.m663e("QbSdk", "init", "Force WebView Inner, " + f218w);
            return false;
        }
        if (f197b) {
            TbsCoreLoadStat.getInstance().m176a(context, 402, new Throwable(f217v));
            TbsLog.m663e("QbSdk", "init", "QbSdk init mIsSysWebViewForcedByOuter = true, " + f217v);
            return false;
        }
        if (!C0445b.m701b()) {
            TbsCoreLoadStat.getInstance().m176a(context, TbsListener.ErrorCode.ERROR_CPU_NOT_SUPPORT, new Throwable(C0445b.f707c));
            TbsLog.m666i("QbSdk", "init", "cpu is invalid: " + C0445b.f707c);
            return false;
        }
        if (TbsPVConfig.getInstance(context).isEnableProtection()) {
            m163e(context);
        }
        try {
            File fileM452n = C0419m.m393a().m452n(context);
            if (fileM452n == null) {
                TbsCoreLoadStat.getInstance().m176a(context, TbsListener.ErrorCode.ERROR_TBSCORE_SHARE_DIR, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                return false;
            }
            int iM422a = C0419m.m393a().m422a(true, context);
            int i = f211p;
            if (i != 0 && i != iM422a) {
                f213r = null;
                f214s = null;
                TbsCoreLoadStat.getInstance().m176a(context, 303, new Throwable("sTbsVersion: " + f211p + "; tbsCoreInstalledVer: " + iM422a));
                return false;
            }
            f211p = iM422a;
            if (TbsDownloader.m184a(context, iM422a)) {
                TbsLog.m673w("QbSdk", "init", "version " + f211p + " is in blacklist,can not load! return");
                return false;
            }
            if (m157b(context, f211p)) {
                TbsLog.m672w("QbSdk", "version " + f211p + " is in below min-version that app set by QbSdk.setCoreMinVersion, reset and not load.");
                return false;
            }
            int i2 = f220y;
            if (i2 == -1) {
                boolean zIsTbsCoreDisabledBySwitch = TbsDownloader.isTbsCoreDisabledBySwitch(context.getApplicationContext(), f211p);
                f220y = zIsTbsCoreDisabledBySwitch ? 0 : 1;
                if (zIsTbsCoreDisabledBySwitch) {
                    TbsLog.m673w("QbSdk", "init", "version " + f211p + "is disable by remote switch");
                    TbsCoreLoadStat.getInstance().m176a(context, TbsListener.ErrorCode.WARNING_REMOTE_SWITCH_DISABLE, new Throwable("version " + f211p + "is disable by remote switch"));
                    return false;
                }
            } else if (i2 == 0) {
                TbsLog.m673w("QbSdk", "init", "version " + f211p + "is disable by remote switch");
                return false;
            }
            if (f213r != null && f214s != null) {
                return true;
            }
            File fileM452n2 = C0419m.m393a().m452n(context);
            File file = new File(fileM452n2, "tbs_sdk_extension_dex.jar");
            if (file.exists()) {
                String absolutePath = fileM452n.getAbsolutePath();
                TbsLog.m666i("QbSdk", "init", "optDirExtension #1 is " + absolutePath);
                TbsLog.m666i("QbSdk", "init", "new DexLoader #1 dexFile is " + file.getAbsolutePath());
                C0431u.m530a().m533b(context);
                C0457n.m789a(context);
                f213r = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, absolutePath, getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                if (!isEnableSensitiveApi() && C0453j.m761a(f213r, "isSuiteableGetSensitative", (Class<?>[]) new Class[0], new Object[0]) == null) {
                    TbsLog.m663e("QbSdk", "init", "isSuiteableGetSensitative check failed, can not use x5");
                    return false;
                }
                loadTBSSDKExtension(context, file.getParent());
                C0453j.m763a(f214s, "setClientVersion", (Class<?>[]) new Class[]{Integer.TYPE}, 1);
                return true;
            }
            try {
                int iM445g = C0419m.m393a().m445g(context);
                if (iM445g > 0) {
                    File file2 = new File(file.getParentFile(), "tbs_jars_fusion_dex.jar");
                    TbsCoreLoadStat.getInstance().m176a(context, 403, new Throwable("[loadMsg] extension is miss, fusion exist is " + file2.exists() + ", core is " + iM445g + ", dexPath is " + file.getPath()));
                } else {
                    TbsCoreLoadStat.getInstance().m176a(context, 404, new Throwable("core path: " + fileM452n2));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return false;
        } catch (Throwable th2) {
            TbsLog.m662e("QbSdk", "QbSdk init Throwable: " + Log.getStackTraceString(th2));
            TbsCoreLoadStat.getInstance().m176a(context, 306, th2);
            return false;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:59:0x01a3
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX INFO: renamed from: a */
    public static boolean m154a(android.content.Context r8, boolean r9, boolean r10) {
        /*
            Method dump skipped, instruction units count: 752
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.QbSdk.m154a(android.content.Context, boolean, boolean):boolean");
    }

    /* JADX INFO: renamed from: b */
    public static String m155b() {
        Object objInvokeStaticMethod;
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b() || (objInvokeStaticMethod = c0431uM530a.m535c().m558b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getGUID", new Class[0], new Object[0])) == null || !(objInvokeStaticMethod instanceof String)) {
            return null;
        }
        return (String) objInvokeStaticMethod;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m156b(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null) {
            return false;
        }
        try {
            if (!context.getApplicationInfo().packageName.contains("com.tencent.portfolio")) {
                return true;
            }
            TbsLog.m665i("QbSdk", "clearPluginConfigFile #1");
            String string = TbsDownloadConfig.getInstance(context).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, null);
            String str = context.getPackageManager().getPackageInfo("com.tencent.portfolio", 0).versionName;
            TbsLog.m665i("QbSdk", "clearPluginConfigFile oldAppVersionName is " + string + " newAppVersionName is " + str);
            if (string == null || string.contains(str) || (sharedPreferences = context.getSharedPreferences("plugin_setting", 0)) == null) {
                return true;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.clear();
            editorEdit.commit();
            TbsLog.m665i("QbSdk", "clearPluginConfigFile done");
            return true;
        } catch (Throwable th) {
            TbsLog.m665i("QbSdk", "clearPluginConfigFile error is " + th.getMessage());
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    public static boolean m157b(Context context, int i) {
        int i2 = f192M;
        if (i >= i2 || i == 0 || i2 == -1 || !TbsShareManager.isThirdPartyApp(context)) {
            return false;
        }
        m167g(context);
        TbsCoreLoadStat.getInstance().m176a(context, TbsListener.ErrorCode.APP_SET_MIN_CORE_VER, new Throwable("QbSdk.setCoreMinVersion: " + f192M));
        return true;
    }

    /* JADX INFO: renamed from: c */
    public static Timer m158c() {
        return f193N;
    }

    public static boolean canDownloadWithoutWifi() {
        return f188I;
    }

    @Deprecated
    public static void canGetAndroidId(boolean z) {
        TbsPrivacyAccess.AndroidId.setEnabled(z);
    }

    @Deprecated
    public static void canGetDeviceId(boolean z) {
        TbsPrivacyAccess.DeviceId.setEnabled(z);
    }

    @Deprecated
    public static void canGetSubscriberId(boolean z) {
        TbsPrivacyAccess.Imsi.setEnabled(z);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0036  */
    /* JADX WARN: Code duplicated, block: B:13:? A[RETURN, SYNTHETIC] */
    public static boolean canLoadVideo(Context context) {
        TbsCoreLoadStat tbsCoreLoadStat;
        int i;
        Object objM763a = C0453j.m763a(f214s, "canLoadVideo", (Class<?>[]) new Class[]{Integer.TYPE}, 0);
        if (objM763a != null) {
            if (!((Boolean) objM763a).booleanValue()) {
                tbsCoreLoadStat = TbsCoreLoadStat.getInstance();
                i = TbsListener.ErrorCode.ERROR_CANLOADVIDEO_RETURN_FALSE;
            }
            if (objM763a == null) {
                return false;
            }
            return ((Boolean) objM763a).booleanValue();
        }
        tbsCoreLoadStat = TbsCoreLoadStat.getInstance();
        i = TbsListener.ErrorCode.ERROR_CANLOADVIDEO_RETURN_NULL;
        tbsCoreLoadStat.m175a(context, i);
        if (objM763a == null) {
            return false;
        }
        return ((Boolean) objM763a).booleanValue();
    }

    @Deprecated
    public static boolean canLoadX5(Context context) {
        return m154a(context, false, false);
    }

    @Deprecated
    public static boolean canLoadX5FirstTimeThirdApp(Context context) {
        return false;
    }

    public static void canOpenFile(Context context, String str, ValueCallback<Boolean> valueCallback) {
        throw new IllegalAccessError("Current SDK not support TbsReaderView.");
    }

    public static boolean canOpenMimeFileType(Context context, String str) {
        throw new IllegalAccessError("Current SDK not support TbsReaderView.");
    }

    public static boolean canOpenWebPlus(Context context) {
        if (f221z == 0) {
            f221z = C0407a.m314a();
        }
        TbsLog.m665i("QbSdk", "canOpenWebPlus - totalRAM: " + f221z);
        boolean z = false;
        if (Build.VERSION.SDK_INT < 7 || f221z < f180A || context == null) {
            return false;
        }
        BufferedInputStream bufferedInputStream = null;
        FileInputStream fileInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(new File(C0419m.m393a().m452n(context), "tbs.conf")));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream2);
                String property = properties.getProperty("android_sdk_max_supported");
                String property2 = properties.getProperty("android_sdk_min_supported");
                int i = Integer.parseInt(property);
                int i2 = Integer.parseInt(property2);
                int i3 = Integer.parseInt(Build.VERSION.SDK);
                if (i3 <= i && i3 >= i2) {
                    int i4 = Integer.parseInt(properties.getProperty("tbs_core_version"));
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception unused) {
                    }
                    try {
                        FileInputStream fileInputStream2 = new FileInputStream(new File(C0419m.m411o(context), "tbs_extension.conf"));
                        try {
                            Properties properties2 = new Properties();
                            properties2.load(fileInputStream2);
                            int i5 = Integer.parseInt(properties2.getProperty("tbs_local_version"));
                            int i6 = Integer.parseInt(properties2.getProperty(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE_FOR_SWITCH));
                            if (i4 != 88888888 && i5 != 88888888 && i4 <= i5 && i4 == i5 && ((i6 <= 0 || i6 == C0445b.m698b(context)) && Boolean.parseBoolean(properties2.getProperty("x5_disabled")) && !TbsDownloadConfig.getInstance(context.getApplicationContext()).mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_SWITCH_BACKUPCORE_ENABLE, false))) {
                                z = true;
                            }
                            try {
                                fileInputStream2.close();
                            } catch (Exception unused2) {
                            }
                        } catch (Throwable unused3) {
                            fileInputStream = fileInputStream2;
                            try {
                                TbsLog.m665i("QbSdk", "canOpenWebPlus - isX5Disabled Exception");
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception unused4) {
                                    }
                                }
                                z = true;
                            } catch (Throwable th) {
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception unused5) {
                                    }
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable unused6) {
                    }
                    return !z;
                }
                TbsLog.m665i("QbSdk", "canOpenWebPlus - sdkVersion: " + i3);
                try {
                    bufferedInputStream2.close();
                } catch (Exception unused7) {
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = bufferedInputStream2;
                try {
                    th.printStackTrace();
                    TbsLog.m665i("QbSdk", "canOpenWebPlus - canLoadX5 Exception");
                    return false;
                } finally {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused8) {
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static boolean canUseVideoFeatrue(Context context, int i) {
        Object objM763a = C0453j.m763a(f214s, "canUseVideoFeatrue", (Class<?>[]) new Class[]{Integer.TYPE}, Integer.valueOf(i));
        if (objM763a == null || !(objM763a instanceof Boolean)) {
            return false;
        }
        return ((Boolean) objM763a).booleanValue();
    }

    public static void checkTbsValidity(Context context) {
        if (context == null || C0457n.m791b(context)) {
            return;
        }
        TbsLog.m662e("QbSdk", "sys WebView: SysWebViewForcedBy checkTbsValidity");
        TbsCoreLoadStat.getInstance().m175a(context, 419);
        forceSysWebView();
    }

    @Deprecated
    public static void clear(Context context) {
    }

    public static void clearAllWebViewCache(Context context, boolean z) {
        Throwable th;
        boolean z2;
        TbsLog.m665i("QbSdk", "clearAllWebViewCache(" + context + ", " + z + ")");
        boolean z3 = false;
        try {
            if (new WebView(context).getWebViewClientExtension() != null) {
                try {
                    C0431u c0431uM530a = C0431u.m530a();
                    if (c0431uM530a != null && c0431uM530a.m534b()) {
                        c0431uM530a.m535c().m548a(context, z);
                    }
                    z3 = true;
                } catch (Throwable th2) {
                    th = th2;
                    z2 = true;
                    TbsLog.m662e("QbSdk", "clearAllWebViewCache exception 2 -- " + Log.getStackTraceString(th));
                    z3 = z2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z2 = false;
        }
        if (z3) {
            TbsLog.m665i("QbSdk", "is_in_x5_mode --> no need to clear system webview!");
            return;
        }
        try {
            android.webkit.WebView webView = new android.webkit.WebView(context);
            if (Build.VERSION.SDK_INT >= 11) {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            }
            webView.clearCache(true);
            if (z) {
                android.webkit.CookieSyncManager.createInstance(context);
                android.webkit.CookieManager.getInstance().removeAllCookie();
            }
            android.webkit.WebViewDatabase.getInstance(context).clearUsernamePassword();
            android.webkit.WebViewDatabase.getInstance(context).clearHttpAuthUsernamePassword();
            android.webkit.WebViewDatabase.getInstance(context).clearFormData();
            android.webkit.WebStorage.getInstance().deleteAllData();
            android.webkit.WebIconDatabase.getInstance().removeAllIcons();
        } catch (Throwable th4) {
            TbsLog.m662e("QbSdk", "clearAllWebViewCache exception 1 -- " + Log.getStackTraceString(th4));
        }
    }

    @Deprecated
    public static void closeFileReader(Context context) {
        C0431u c0431uM530a = C0431u.m530a();
        c0431uM530a.m532a(context);
        if (c0431uM530a.m534b()) {
            c0431uM530a.m535c().m598p();
        }
    }

    public static String closeNetLogAndSavaToLocal() {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a != null && c0431uM530a.m534b()) {
            try {
                Object objInvokeStaticMethod = c0431uM530a.m535c().m558b().invokeStaticMethod("com.tencent.smtt.livelog.NetLogManager", "closeNetLogAndSavaToLocal", new Class[0], new Object[0]);
                if (objInvokeStaticMethod != null && (objInvokeStaticMethod instanceof String)) {
                    return (String) objInvokeStaticMethod;
                }
            } catch (Exception unused) {
            }
        }
        return BuildConfig.FLAVOR;
    }

    public static void configurePrivacy(Context context, TbsPrivacyAccess.ConfigurablePrivacy configurablePrivacy, String str) {
        TbsPrivacyAccess.configurePrivacy(context, configurablePrivacy, str);
    }

    public static boolean createMiniQBShortCut(Context context, String str, String str2, Drawable drawable) {
        C0431u c0431uM530a;
        if (context != null && !TbsDownloader.getOverSea(context) && !isMiniQBShortCutExist(context, str, str2) && (c0431uM530a = C0431u.m530a()) != null && c0431uM530a.m534b()) {
            Bitmap bitmap = drawable instanceof BitmapDrawable ? ((BitmapDrawable) drawable).getBitmap() : null;
            DexLoader dexLoaderM558b = c0431uM530a.m535c().m558b();
            TbsLog.m662e("QbSdk", "qbsdk createMiniQBShortCut");
            Object objInvokeStaticMethod = dexLoaderM558b.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[]{Context.class, String.class, String.class, Bitmap.class}, context, str, str2, bitmap);
            TbsLog.m662e("QbSdk", "qbsdk after createMiniQBShortCut ret: " + objInvokeStaticMethod);
            if (objInvokeStaticMethod != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: d */
    public static boolean m160d() {
        return f194O != PrivateCDNMode.NOT_USE;
    }

    /* JADX INFO: renamed from: d */
    private static boolean m161d(Context context) {
        try {
            if (f213r != null) {
                return true;
            }
            File fileM452n = C0419m.m393a().m452n(context);
            if (fileM452n == null) {
                TbsLog.m662e("QbSdk", "QbSdk initForX5DisableConfig (false) optDir == null");
                return false;
            }
            File file = new File(C0419m.m393a().m452n(context), "tbs_sdk_extension_dex.jar");
            if (!file.exists()) {
                TbsCoreLoadStat.getInstance().m176a(context, 406, new Exception("initForX5DisableConfig failure -- tbs_sdk_extension_dex.jar is not exist!"));
                return false;
            }
            String absolutePath = fileM452n.getAbsolutePath();
            TbsLog.m665i("QbSdk", "QbSdk init optDirExtension #3 is " + absolutePath);
            TbsLog.m665i("QbSdk", "new DexLoader #4 dexFile is " + file.getAbsolutePath());
            C0431u.m530a().m533b(context);
            C0457n.m789a(context);
            f213r = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, absolutePath, getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
            if (!isEnableSensitiveApi() && C0453j.m761a(f213r, "isSuiteableGetSensitative", (Class<?>[]) new Class[0], new Object[0]) == null) {
                TbsLog.m662e("QbSdk", "isSuiteableGetSensitative check failed,can not use x5");
                return false;
            }
            loadTBSSDKExtension(context, file.getParent());
            C0453j.m763a(f214s, "setClientVersion", (Class<?>[]) new Class[]{Integer.TYPE}, 1);
            return true;
        } catch (Throwable th) {
            TbsLog.m662e("QbSdk", "initForX5DisableConfig sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    public static boolean deleteMiniQBShortCut(Context context, String str, String str2) {
        C0431u c0431uM530a;
        return (context == null || TbsDownloader.getOverSea(context) || (c0431uM530a = C0431u.m530a()) == null || !c0431uM530a.m534b() || c0431uM530a.m535c().m558b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new Class[]{Context.class, String.class, String.class}, context, str, str2) == null) ? false : true;
    }

    @Deprecated
    public static void deleteStableCore(Context context, int i) {
    }

    public static void disAllowThirdAppDownload() {
        f198c = false;
    }

    public static void disableAutoCreateX5Webview() {
        f205j = false;
    }

    @Deprecated
    public static void disableSensitiveApi() {
        TbsPrivacyAccess.disableSensitiveApi();
    }

    /* JADX INFO: renamed from: e */
    public static SystemCoreProtector m162e() {
        return f195P;
    }

    /* JADX INFO: renamed from: e */
    private static void m163e(Context context) {
        if (f185F || !Thread.currentThread().getName().equals("tbs_preinit")) {
            return;
        }
        f185F = true;
        TbsLog.m665i("QbSdk", "QbSdk - preload_x5_check -- process:" + context.getApplicationInfo().processName + "; thread:" + Thread.currentThread().getName());
        int iM445g = C0419m.m393a().m445g(context);
        if (iM445g <= 0) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
            int i = sharedPreferences.getInt("tbs_preload_x5_recorder", 0) + 1;
            if (i > 3) {
                TbsCoreLoadStat.getInstance().m176a(context, TbsListener.ErrorCode.ERROR_CORE_LOAD_CRASH_PROTECT, new Throwable("thread " + Thread.currentThread().getName()));
                m165f(context);
                m167g(context);
                TbsLogReport tbsLogReport = TbsLogReport.getInstance(context);
                TbsLogReport.TbsLogInfo tbsLogInfo = tbsLogReport.tbsLogInfo();
                tbsLogInfo.setErrorCode(iM445g);
                tbsLogReport.eventReport(TbsLogReport.EventType.TYPE_CORE_PROTECT_RESET, tbsLogInfo);
            } else {
                sharedPreferences.edit().putInt("tbs_preload_x5_recorder", i).commit();
            }
        } catch (Throwable th) {
            TbsLog.m662e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th));
        }
    }

    public static void enableX5WithoutRestart() {
        throw new UnsupportedOperationException("Current TBS SDK doesn't support");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public static void m165f(Context context) {
        if (Thread.currentThread().getName().equals("tbs_preinit")) {
            context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4).edit().putInt("tbs_preload_x5_recorder", 0).commit();
        }
    }

    public static void fileInfoDetect(Context context, String str, android.webkit.ValueCallback<String> valueCallback) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            return;
        }
        try {
            c0431uM530a.m535c().m558b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "fileInfoDetect", new Class[]{Context.class, String.class, android.webkit.ValueCallback.class}, context, str, valueCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void forceSysWebView() {
        f197b = true;
        f217v = "SysWebViewForcedByOuter: " + Log.getStackTraceString(new Throwable());
        TbsLog.m662e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
    }

    /* JADX INFO: renamed from: g */
    private static void m167g(Context context) {
        TbsLog.m664e("QbSdk", "QbSdk reset!", true);
        try {
            TbsDownloader.stopDownload();
            TbsDownloader.m193c(context);
            FileUtil.m629a(getTbsFolderDir(context), false, "core_share_decouple");
            TbsLog.m667i("QbSdk", "delete downloaded apk success", true);
            C0419m.m401b();
            File file = new File(context.getFilesDir(), TbsExtensionFunctionManager.BUGLY_SWITCH_FILE_NAME);
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable th) {
            TbsLog.m662e("QbSdk", "QbSdk reset exception:" + Log.getStackTraceString(th));
        }
    }

    public static long getApkFileSize(Context context) {
        if (context != null) {
            return TbsDownloadConfig.getInstance(context.getApplicationContext()).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, 0L);
        }
        return 0L;
    }

    public static String getCurrentProcessName(Context context) {
        FileInputStream fileInputStream;
        try {
            try {
                fileInputStream = new FileInputStream("/proc/self/cmdline");
                try {
                    byte[] bArr = new byte[256];
                    int i = 0;
                    while (true) {
                        int i2 = fileInputStream.read();
                        if (i2 <= 0 || i >= 256) {
                            break;
                        }
                        bArr[i] = (byte) i2;
                        i++;
                    }
                    if (i > 0) {
                        String str = new String(bArr, 0, i, "UTF-8");
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return str;
                    }
                    fileInputStream.close();
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return null;
    }

    public static String[] getDexLoaderFileList(Context context, Context context2, String str) {
        String[] strArr = f216u;
        if (!(strArr instanceof String[])) {
            Object objM763a = C0453j.m763a(f214s, "getJarFiles", (Class<?>[]) new Class[]{Context.class, Context.class, String.class}, context, context2, str);
            if (!(objM763a instanceof String[])) {
                objM763a = new String[]{BuildConfig.FLAVOR};
            }
            return (String[]) objM763a;
        }
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i = 0; i < length; i++) {
            strArr2[i] = str + f216u[i];
        }
        return strArr2;
    }

    @Deprecated
    public static boolean getDownloadWithoutWifi() {
        return f188I;
    }

    public static boolean getIsInitX5Environment() {
        return f206k;
    }

    public static boolean getIsSysWebViewForcedByOuter() {
        return f197b;
    }

    public static boolean getJarFilesAndLibraryPath(Context context) {
        String str;
        Object obj = f214s;
        if (obj == null) {
            str = "getJarFilesAndLibraryPath sExtensionObj is null";
        } else {
            Bundle bundle = (Bundle) C0453j.m763a(obj, "canLoadX5CoreAndNotLoadSo", (Class<?>[]) new Class[]{Integer.TYPE}, 44286);
            if (bundle != null) {
                f216u = bundle.getStringArray("tbs_jarfiles");
                f199d = bundle.getString("tbs_librarypath");
                return true;
            }
            str = "getJarFilesAndLibraryPath bundle is null and coreverison is " + C0419m.m393a().m422a(true, context);
        }
        TbsLog.m665i("QbSdk", str);
        return false;
    }

    public static String getMiniQBVersion(Context context) {
        C0431u c0431uM530a = C0431u.m530a();
        c0431uM530a.m532a(context);
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            return null;
        }
        return c0431uM530a.m535c().m574f();
    }

    public static boolean getOnlyDownload() {
        return f207l;
    }

    public static String getQQBuildNumber() {
        return f182C;
    }

    public static Map<String, Object> getSettings() {
        return f210o;
    }

    public static boolean getTBSInstalling() {
        return f189J;
    }

    public static String getTID() {
        return f181B;
    }

    public static File getTbsFolderDir(Context context) {
        if (context == null) {
            return null;
        }
        return context.getDir(C0445b.m703c() ? "tbs_64" : "tbs", 0);
    }

    @Deprecated
    public static String getTbsResourcesPath(Context context) {
        return BuildConfig.FLAVOR;
    }

    public static int getTbsSdkVersion() {
        return 44286;
    }

    public static int getTbsVersion(Context context) {
        return C0419m.m393a().m445g(context);
    }

    public static int getTbsVersionForCrash(Context context) {
        if (f196a) {
            return 0;
        }
        int iM446h = C0419m.m393a().m446h(context);
        if (iM446h == 0 && C0418l.m374a(context).m386c() == 3) {
            m167g(context);
        }
        return iM446h;
    }

    public static int getTmpDirTbsVersion(Context context) {
        if (C0418l.m374a(context).m386c() == 2) {
            return C0419m.m393a().m440d(context, 0);
        }
        if (C0418l.m374a(context).m383b("copy_status") == 1) {
            return C0419m.m393a().m440d(context, 1);
        }
        return 0;
    }

    public static String getX5CoreLoadHelp(Context context) {
        String str;
        if (context == null) {
            return "context is null";
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        int iM445g = C0419m.m393a().m445g(context);
        if (iM445g > 0) {
            int loadErrorCode = TbsCoreLoadStat.getLoadErrorCode();
            if (loadErrorCode == -1 && C0431u.m530a().m534b()) {
                str = "core load success";
            } else {
                str = "Core Exist version is " + iM445g + ", error code: " + loadErrorCode + ", detail: " + TbsCoreLoadStat.getLoadErrorMessage() + ", suggestion: " + C0449f.m738a().m739a(loadErrorCode);
            }
        } else {
            int nextPostInterval = TbsDownloader.getNextPostInterval(context);
            if (TbsDownloader.f291a) {
                str = "core is downloading, please check TbsListener.onDownloadProgress.";
            } else if (Apn.getApnType(context) != 3 && !canDownloadWithoutWifi()) {
                str = "Mobile Network will not download as default. If you want, you can set QbSdk.setDownloadWithoutWifi(true) in the beginning of your app.";
            } else if (nextPostInterval > 0) {
                str = "Perhaps server is busy, try to restart your app in " + nextPostInterval + "s later or (uninstall + reinstall).";
            } else {
                str = "Core not exist, unknown network problem.";
            }
        }
        return str + "If it doesn't help, contact with x5 with your tbslog.txt, site: x5.tencent.com";
    }

    public static void initBuglyAsync(boolean z) {
        f204i = z;
    }

    public static void initForinitAndNotLoadSo(Context context) {
        String str;
        if (f213r == null) {
            File fileM452n = C0419m.m393a().m452n(context);
            if (fileM452n == null) {
                str = "QbSdk initForinitAndNotLoadSo optDir == null";
            } else {
                File file = new File(fileM452n, "tbs_sdk_extension_dex.jar");
                if (file.exists()) {
                    String absolutePath = fileM452n.getAbsolutePath();
                    C0431u.m530a().m533b(context);
                    C0457n.m789a(context);
                    f213r = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, absolutePath, getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                    return;
                }
                str = "QbSdk initForinitAndNotLoadSo dexFile.exists()=false";
            }
            Log.e("QbSdk", str);
        }
    }

    public static void initTbsSettings(Map<String, Object> map) {
        Map<String, Object> map2 = f210o;
        if (map2 == null) {
            f210o = map;
            return;
        }
        try {
            map2.putAll(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initX5Environment(final Context context, final PreInitCallback preInitCallback) {
        C0461r.m814a().m818a("init_tbs_Start");
        TbsLog.initIfNeed(context);
        if (context == null) {
            TbsLog.m662e("QbSdk", "initX5Environment,context=null");
            return;
        }
        if (m160d()) {
            TbsLog.m665i("QbSdk", "using private CDN mode, preInit directly.");
            preInit(context, preInitCallback);
            return;
        }
        m156b(context);
        f187H = new TbsListener() { // from class: com.tencent.smtt.sdk.QbSdk.3
            @Override // com.tencent.smtt.sdk.TbsListener
            public void onDownloadFinish(int i) {
            }

            @Override // com.tencent.smtt.sdk.TbsListener
            public void onDownloadProgress(int i) {
            }

            @Override // com.tencent.smtt.sdk.TbsListener
            public void onInstallFinish(int i) {
                QbSdk.preInit(context, preInitCallback);
            }
        };
        if (TbsShareManager.isThirdPartyApp(context)) {
            C0419m.m393a().m435b(context, C0412f.f512a == 0);
        }
        TbsDownloader.needDownload(context, false, false, true, new TbsDownloader.TbsDownloaderCallback() { // from class: com.tencent.smtt.sdk.QbSdk.4
            @Override // com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback
            public void onNeedDownloadFinish(boolean z, int i) {
                if (TbsShareManager.isThirdPartyApp(context)) {
                    QbSdk.f209n.onDownloadFinish(TbsDownloadConfig.getInstance(context).getCurrentDownloadInterruptCode());
                    if (QbSdk.f204i) {
                        TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(context);
                    }
                }
                if (QbSdk.m158c() != null) {
                    TbsDownloader.m181a(context, new Runnable() { // from class: com.tencent.smtt.sdk.QbSdk.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            C03604 c03604 = C03604.this;
                            QbSdk.preInit(context, preInitCallback);
                        }
                    });
                } else {
                    QbSdk.preInit(context, preInitCallback);
                }
            }
        });
        f206k = true;
    }

    public static boolean installLocalQbApk(Context context, String str, String str2, Bundle bundle) {
        C0412f c0412fM323a = C0412f.m323a(true);
        c0412fM323a.m329a(context, false, false);
        if (c0412fM323a == null || !c0412fM323a.m331b()) {
            return false;
        }
        return c0412fM323a.m328a().m496a(context, str, str2, bundle);
    }

    @Deprecated
    public static void installLocalTbsCore(Context context, int i, String str) {
        C0419m.m393a().m428a(context, str, i);
    }

    public static boolean intentDispatch(WebView webView, Intent intent, String str, String str2) {
        String str3;
        if (webView == null) {
            return false;
        }
        if (str.startsWith("mttbrowser://miniqb/ch=icon?")) {
            Context context = webView.getContext();
            int iIndexOf = str.indexOf("url=");
            str = iIndexOf > 0 ? str.substring(iIndexOf + 4) : null;
            HashMap map = new HashMap();
            try {
                str3 = context.getApplicationInfo().packageName;
            } catch (Exception e) {
                e.printStackTrace();
                str3 = "unknown";
            }
            map.put("ChannelID", str3);
            map.put("PosID", "14004");
            if (MttLoader.loadUrl(context, "miniqb://home".equals(str) ? "qb://navicard/addCard?cardId=168&cardName=168" : str, map, "QbSdk.startMiniQBToLoadUrl", null) != 0) {
                C0431u c0431uM530a = C0431u.m530a();
                if (c0431uM530a != null && c0431uM530a.m534b() && c0431uM530a.m535c().m543a(context, str, null, str2, null) == 0) {
                    return true;
                }
                webView.loadUrl(str);
            }
        } else {
            webView.loadUrl(str);
        }
        return false;
    }

    @Deprecated
    public static boolean isEnableCanGetSubscriberId() {
        return TbsPrivacyAccess.Imsi.isEnabled();
    }

    @Deprecated
    public static boolean isEnableGetAndroidID() {
        return TbsPrivacyAccess.AndroidId.isEnabled();
    }

    @Deprecated
    public static boolean isEnableGetDeviceID() {
        return TbsPrivacyAccess.DeviceId.isEnabled();
    }

    @Deprecated
    public static boolean isEnableSensitiveApi() {
        return TbsPrivacyAccess.isEnableSensitiveApi();
    }

    public static boolean isEnableX5WithoutRestart() {
        return f184E;
    }

    public static boolean isMiniQBShortCutExist(Context context, String str, String str2) {
        C0431u c0431uM530a;
        Object objInvokeStaticMethod;
        if (context == null || TbsDownloader.getOverSea(context) || (c0431uM530a = C0431u.m530a()) == null || !c0431uM530a.m534b() || (objInvokeStaticMethod = c0431uM530a.m535c().m558b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[]{Context.class, String.class}, context, str)) == null) {
            return false;
        }
        Boolean bool = Boolean.FALSE;
        if (objInvokeStaticMethod instanceof Boolean) {
            bool = (Boolean) objInvokeStaticMethod;
        }
        return bool.booleanValue();
    }

    public static boolean isNeedInitX5FirstTime() {
        return f219x;
    }

    public static boolean isStaticNeedDownload() {
        return f191L;
    }

    public static boolean isTbsCoreInited() {
        C0412f c0412fM323a = C0412f.m323a(false);
        return c0412fM323a != null && c0412fM323a.m337h();
    }

    public static boolean isX5Core() {
        if (getIsSysWebViewForcedByOuter()) {
            return false;
        }
        return C0431u.m530a().m534b();
    }

    public static boolean isX5DisabledSync(Context context) {
        if (C0418l.m374a(context).m386c() == 2) {
            return false;
        }
        if (!m161d(context)) {
            return true;
        }
        int iM445g = C0419m.m393a().m445g(context);
        Object obj = f214s;
        Class cls = Integer.TYPE;
        Object objM763a = C0453j.m763a(obj, "isX5DisabledSync", (Class<?>[]) new Class[]{cls, cls}, Integer.valueOf(iM445g), 44286);
        if (objM763a != null) {
            return ((Boolean) objM763a).booleanValue();
        }
        return true;
    }

    public static void loadTBSSDKExtension(Context context, String str) {
        Constructor<?> constructor;
        boolean z;
        Object objNewInstance;
        if (f214s != null) {
            return;
        }
        synchronized (QbSdk.class) {
            if (f214s != null) {
                return;
            }
            if (f213r == null) {
                TbsLog.m665i("QbSdk", "QbSdk loadTBSSDKExtension sExtensionClass is null");
            }
            try {
                constructor = f213r.getConstructor(Context.class, Context.class, String.class, String.class, String.class);
                z = true;
            } catch (Throwable unused) {
                constructor = null;
                z = false;
            }
            try {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                if (z) {
                    objNewInstance = constructor.newInstance(context, context, null, str, (!TbsConfig.APP_WX.equals(getCurrentProcessName(context)) || WebView.mWebViewCreated) ? null : "notLoadSo");
                } else {
                    objNewInstance = f213r.getConstructor(Context.class, Context.class).newInstance(context, context);
                }
                f214s = objNewInstance;
            } catch (Throwable th) {
                TbsCoreLoadStat.getInstance().m176a(context, TbsListener.ErrorCode.ERROR_NEW_EXTENSION_INSTANCE_FAILED, th);
                TbsLog.m662e("QbSdk", "throwable" + Log.getStackTraceString(th));
            }
        }
    }

    public static void openNetLog(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            return;
        }
        try {
            c0431uM530a.m535c().m558b().invokeStaticMethod("com.tencent.smtt.livelog.NetLogManager", "openNetLog", new Class[]{String.class}, str);
        } catch (Exception unused) {
        }
    }

    public static void pauseDownload() {
        TbsDownloader.pauseDownload();
    }

    public static void preInit(Context context) {
        preInit(context, null);
    }

    public static void preInit(Context context, PreInitCallback preInitCallback) {
        preInit(context, false, preInitCallback);
    }

    public static synchronized void preInit(final Context context, boolean z, final PreInitCallback preInitCallback) {
        C0461r.m814a().m818a("preinit_start");
        TbsLog.initIfNeed(context);
        TbsLog.m666i("QbSdk", "preInit", "processName: " + getCurrentProcessName(context));
        TbsLog.m666i("QbSdk", "preInit", "stack trace: " + Log.getStackTraceString(new Throwable("PreInit Detect:")));
        if (z && f215t && !f184E) {
            TbsLog.m672w("QbSdk", "haven't enableX5WithoutRestart");
            return;
        }
        if (z) {
            f196a = false;
            f215t = false;
            TbsLog.m672w("QbSdk", "is forcePreInit, local web core status has reset");
        }
        if (!f215t) {
            TbsLog.m666i("QbSdk", "preInit", "#1# Start new thread to preInit, thread name: tbs_preinit");
            final Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.smtt.sdk.QbSdk.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    PreInitCallback preInitCallback2;
                    int i = message.what;
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3 && (preInitCallback2 = preInitCallback) != null) {
                                preInitCallback2.onCoreInitFinished();
                                return;
                            }
                            return;
                        }
                        C0461r.m814a().m818a("preinit_finish");
                        PreInitCallback preInitCallback3 = preInitCallback;
                        if (preInitCallback3 != null) {
                            preInitCallback3.onViewInitFinished(false);
                            C0461r.m814a().m818a("init_tbs_end");
                        }
                        TbsLog.writeLogToDisk();
                        C0461r.m814a().m817a(context);
                        return;
                    }
                    C0461r.m814a().m818a("preinit_finish");
                    if (QbSdk.f205j) {
                        C0461r.m814a().m818a("create_webview_start");
                        C0433v c0433vM535c = C0431u.m530a().m535c();
                        if (c0433vM535c != null) {
                            c0433vM535c.m544a(context);
                        }
                        C0461r.m814a().m818a("create_webview_end");
                    }
                    PreInitCallback preInitCallback4 = preInitCallback;
                    if (preInitCallback4 != null) {
                        preInitCallback4.onViewInitFinished(true);
                        C0461r.m814a().m818a("init_tbs_end");
                    }
                    C0461r.m814a().m817a(context);
                    TbsLog.writeLogToDisk();
                }
            };
            Thread thread = new Thread() { // from class: com.tencent.smtt.sdk.QbSdk.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    int iM422a = C0419m.m393a().m422a(true, context);
                    TbsDownloader.setAppContext(context);
                    TbsLog.m665i("QbSdk", "QbSdk preinit ver is " + iM422a);
                    C0419m.m393a().m435b(context, C0412f.f512a == 0);
                    TbsLog.m666i("QbSdk", "preInit", "#2-1# prepare initAndLoadSo");
                    C0431u c0431uM530a = C0431u.m530a();
                    c0431uM530a.m532a(context);
                    QbSdk.m165f(context);
                    TbsLog.m666i("QbSdk", "preInit", "#2-3# X5CoreEngine init finish");
                    boolean zM534b = c0431uM530a.m534b();
                    handler.sendEmptyMessage(3);
                    if (zM534b) {
                        handler.sendEmptyMessage(1);
                    } else {
                        handler.sendEmptyMessage(2);
                    }
                }
            };
            thread.setName("tbs_preinit");
            thread.setPriority(10);
            thread.start();
            f215t = true;
        }
    }

    public static boolean preinstallStaticTbs(Context context) {
        throw new IllegalStateException("Current SDK is not support static mode.");
    }

    public static void reset(Context context) {
        if (f190K) {
            TbsLog.m672w("QbSdk", "[warning] TBS only allow reset 1 times each process.");
        } else {
            f190K = true;
            m167g(context);
        }
    }

    @Deprecated
    public static void reset(Context context, boolean z) {
        if (f190K) {
            TbsLog.m672w("QbSdk", "[warning] TBS only allow reset 1 times each process.");
        } else {
            f190K = true;
            m167g(context);
        }
    }

    @Deprecated
    public static void resetDecoupleCore(Context context) {
    }

    public static void resumeDownload() {
        TbsDownloader.resumeDownload();
    }

    public static void setAppList(Context context, List<String> list) {
        if (list == null) {
            return;
        }
        TbsPrivacyAccess.configureAllPrivacy(context, TextUtils.join(",", list));
    }

    public static void setCoreMinVersion(int i) {
        TbsLog.m665i("QbSdk", "setCoreMinVersion: " + i);
        f192M = i;
    }

    public static void setCurrentID(String str) {
        if (str != null && str.startsWith(TID_QQNumber_Prefix)) {
            String strSubstring = str.substring(3);
            f181B = "0000000000000000".substring(strSubstring.length()) + strSubstring;
        }
    }

    public static void setDisableUnpreinitBySwitch(boolean z) {
        f183D = z;
        TbsLog.m665i("QbSdk", "setDisableUnpreinitBySwitch -- mDisableUnpreinitBySwitch is " + f183D);
    }

    public static void setDisableUseHostBackupCoreBySwitch(boolean z) {
        mDisableUseHostBackupCore = z;
        TbsLog.m665i("QbSdk", "setDisableUseHostBackupCoreBySwitch -- mDisableUseHostBackupCore is " + mDisableUseHostBackupCore);
    }

    public static void setDownloadWithoutWifi(boolean z) {
        f188I = z;
    }

    @Deprecated
    public static void setEnableForThirdParty(Context context, Bundle bundle) {
        C0462s.m822a(context, bundle);
    }

    public static void setMultiProcessSyncInitTimer(Timer timer) {
        if (f193N == null) {
            f193N = timer;
        }
    }

    public static void setNeedInitX5FirstTime(boolean z) {
        f219x = z;
    }

    public static void setNeedStaticWithDownload(boolean z) {
        throw new IllegalStateException("Current SDK is not support static mode.");
    }

    public static void setNetLogEncryptionKey(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            return;
        }
        try {
            c0431uM530a.m535c().m558b().invokeStaticMethod("com.tencent.smtt.livelog.NetLogManager", "setNetLogEncryptionKey", new Class[]{String.class}, str);
        } catch (Exception unused) {
        }
    }

    public static void setNewDnsHostList(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            return;
        }
        try {
            c0431uM530a.m535c().m558b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "setNewDnsHostList", new Class[]{String.class}, str);
        } catch (Exception unused) {
        }
    }

    public static void setOnlyDownload(boolean z) {
        f207l = z;
    }

    public static void setQQBuildNumber(String str) {
        f182C = str;
    }

    public static void setSandboxExternalEnable(boolean z) {
        FileUtil.m632a(z);
    }

    public static void setSystemCoreProtector(SystemCoreProtector systemCoreProtector) {
        throw new C0444a();
    }

    public static void setTBSInstallingStatus(boolean z) {
        f189J = z;
    }

    public static void setTbsInstallerCallback(InterfaceC0362a interfaceC0362a) {
        C0419m.m393a().m430a(interfaceC0362a);
    }

    public static void setTbsListener(TbsListener tbsListener) {
        f186G = tbsListener;
    }

    public static void setTbsLogClient(TbsLogClient tbsLogClient) {
        TbsLog.setTbsLogClient(tbsLogClient);
    }

    public static void setUUID(String str) {
        C0445b.m695a(str, true);
    }

    @Deprecated
    public static void setUploadCode(Context context, int i) {
    }

    public static void setUserID(Context context, Bundle bundle) {
        TbsPrivacyAccess.configureAllPrivacy(context, bundle);
    }

    public static int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> map, android.webkit.ValueCallback<String> valueCallback) {
        TbsCoreLoadStat.getInstance().m175a(context, 501);
        if (context == null) {
            return -100;
        }
        C0431u c0431uM530a = C0431u.m530a();
        c0431uM530a.m532a(context);
        if (!c0431uM530a.m534b()) {
            TbsCoreLoadStat.getInstance().m175a(context, TbsListener.ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
            Log.e("QbSdk", "startMiniQBToLoadUrl  ret = -102");
            return -102;
        }
        if (context != null && context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") && getTbsVersion(context) < 25487) {
            return -101;
        }
        int iM543a = c0431uM530a.m535c().m543a(context, str, map, null, valueCallback);
        TbsLog.m665i("QbSdk", "startMiniQBToLoadUrl  ret = " + iM543a);
        return iM543a;
    }

    public static boolean startQBForDoc(Context context, String str, int i, int i2, String str2, Bundle bundle) {
        HashMap map = new HashMap();
        map.put("ChannelID", context.getApplicationContext().getApplicationInfo().processName);
        map.put("PosID", Integer.toString(i));
        return MttLoader.openDocWithQb(context, str, i2, str2, map, bundle);
    }

    public static boolean startQBForVideo(Context context, String str, int i) {
        HashMap map = new HashMap();
        map.put("ChannelID", context.getApplicationInfo().processName);
        map.put("PosID", Integer.toString(i));
        return MttLoader.openVideoWithQb(context, str, map);
    }

    public static boolean startQBToLoadurl(Context context, String str, int i, WebView webView) {
        C0431u c0431uM530a;
        Object objInvokeStaticMethod;
        IX5WebViewBase iX5WebViewBase;
        HashMap map = new HashMap();
        map.put("ChannelID", context.getApplicationInfo().processName);
        map.put("PosID", Integer.toString(i));
        if (webView == null) {
            try {
                String str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
                if ((str2 == TbsConfig.APP_WX || str2 == TbsConfig.APP_QQ) && (c0431uM530a = C0431u.m530a()) != null && c0431uM530a.m534b() && (objInvokeStaticMethod = c0431uM530a.m535c().m558b().invokeStaticMethod("com.tencent.smtt.webkit.WebViewList", "getCurrentMainWebviewJustForQQandWechat", new Class[0], new Object[0])) != null && (iX5WebViewBase = (IX5WebViewBase) objInvokeStaticMethod) != null) {
                    webView = (WebView) iX5WebViewBase.getView().getParent();
                }
            } catch (Exception unused) {
            }
        }
        return MttLoader.loadUrl(context, str, map, "QbSdk.startQBToLoadurl", webView) == 0;
    }

    public static boolean startQbOrMiniQBToLoadUrl(Context context, String str, HashMap<String, String> map, ValueCallback<String> valueCallback) {
        if (context == null) {
            return false;
        }
        C0431u c0431uM530a = C0431u.m530a();
        c0431uM530a.m532a(context);
        if (map != null && "5".equals(map.get("PosID")) && c0431uM530a.m534b()) {
        }
        if (MttLoader.loadUrl(context, str, map, "QbSdk.startMiniQBToLoadUrl", null) != 0) {
            return c0431uM530a.m534b() && (context == null || !context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") || getTbsVersion(context) >= 25487) && c0431uM530a.m535c().m543a(context, str, map, null, valueCallback) == 0;
        }
        return true;
    }

    public static void unForceSysWebView() {
        f197b = false;
        TbsLog.m662e("QbSdk", "sys WebView: unForceSysWebView called");
    }

    public static void uploadNetLog(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            return;
        }
        try {
            c0431uM530a.m535c().m558b().invokeStaticMethod("com.tencent.smtt.livelog.NetLogManager", "uploadNetLog", new Class[]{String.class}, str);
        } catch (Exception unused) {
        }
    }

    public static void usePrivateCDN() {
        throw new C0444a();
    }

    public static void usePrivateCDN(PrivateCDNMode privateCDNMode) {
        throw new C0444a();
    }

    public static boolean useSoftWare() {
        Object obj = f214s;
        if (obj == null) {
            return false;
        }
        Object objM763a = C0453j.m763a(obj, "useSoftWare", (Class<?>[]) new Class[0], new Object[0]);
        if (objM763a == null) {
            objM763a = C0453j.m763a(f214s, "useSoftWare", (Class<?>[]) new Class[]{Integer.TYPE}, Integer.valueOf(C0407a.m314a()));
        }
        if (objM763a == null) {
            return false;
        }
        return ((Boolean) objM763a).booleanValue();
    }
}
