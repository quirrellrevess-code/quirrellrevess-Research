package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.flexbox.BuildConfig;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.C0445b;
import com.tencent.smtt.utils.C0450g;
import com.tencent.smtt.utils.C0451h;
import com.tencent.smtt.utils.C0458o;
import com.tencent.smtt.utils.C0462s;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.Timer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TimerTask;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
import org.opencv.core.Core;

/* JADX INFO: loaded from: classes.dex */
public class TbsDownloader {
    public static final boolean DEBUG_DISABLE_DOWNLOAD = false;
    public static boolean DOWNLOAD_OVERSEA_TBS = false;
    public static final String LOGTAG = "TbsDownload";
    public static final String TBS_METADATA = "com.tencent.mm.BuildInfo.CLIENT_VERSION";

    /* JADX INFO: renamed from: a */
    public static boolean f291a = false;

    /* JADX INFO: renamed from: b */
    private static String f292b = null;

    /* JADX INFO: renamed from: c */
    private static Context f293c = null;

    /* JADX INFO: renamed from: d */
    private static Handler f294d = null;

    /* JADX INFO: renamed from: e */
    private static String f295e = null;

    /* JADX INFO: renamed from: f */
    private static final Object f296f = new byte[0];

    /* JADX INFO: renamed from: g */
    private static C0417k f297g = null;

    /* JADX INFO: renamed from: h */
    private static HandlerThread f298h = null;

    /* JADX INFO: renamed from: i */
    private static int f299i = 0;

    /* JADX INFO: renamed from: j */
    private static boolean f300j = false;

    /* JADX INFO: renamed from: k */
    private static String f301k = "";

    /* JADX INFO: renamed from: l */
    private static String f302l = "";

    /* JADX INFO: renamed from: m */
    private static boolean f303m = false;

    /* JADX INFO: renamed from: n */
    private static boolean f304n = false;

    /* JADX INFO: renamed from: o */
    private static JSONObject f305o = null;

    /* JADX INFO: renamed from: p */
    private static JSONObject f306p = null;

    /* JADX INFO: renamed from: q */
    private static boolean f307q = false;

    /* JADX INFO: renamed from: r */
    private static int f308r = 0;

    /* JADX INFO: renamed from: s */
    private static int f309s = 0;

    /* JADX INFO: renamed from: t */
    private static JSONObject f310t = null;

    /* JADX INFO: renamed from: u */
    private static long f311u = -1;

    public interface TbsDownloaderCallback {
        void onNeedDownloadFinish(boolean z, int i);
    }

    /* JADX INFO: renamed from: a */
    private static String m178a(String str) {
        return str == null ? BuildConfig.FLAVOR : str;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02a6 A[Catch: Exception -> 0x02ab, TRY_LEAVE, TryCatch #0 {Exception -> 0x02ab, blocks: (B:16:0x006e, B:19:0x0082, B:22:0x008b, B:25:0x0095, B:27:0x00a5, B:28:0x00aa, B:30:0x00b7, B:51:0x0143, B:55:0x014d, B:57:0x0155, B:59:0x0176, B:60:0x017b, B:62:0x01c6, B:63:0x01cb, B:67:0x01e3, B:71:0x01ef, B:75:0x01fe, B:76:0x0201, B:80:0x023f, B:84:0x024a, B:85:0x0261, B:87:0x0276, B:89:0x0280, B:91:0x0284, B:94:0x028e, B:96:0x0292, B:97:0x0297, B:99:0x029f, B:101:0x02a6, B:32:0x00c5, B:35:0x00dc, B:37:0x00e8, B:39:0x00f9, B:41:0x0108, B:42:0x0112, B:44:0x0130, B:33:0x00d0, B:23:0x008f), top: B:105:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:27:0x00a5 A[Catch: Exception -> 0x02ab, TryCatch #0 {Exception -> 0x02ab, blocks: (B:16:0x006e, B:19:0x0082, B:22:0x008b, B:25:0x0095, B:27:0x00a5, B:28:0x00aa, B:30:0x00b7, B:51:0x0143, B:55:0x014d, B:57:0x0155, B:59:0x0176, B:60:0x017b, B:62:0x01c6, B:63:0x01cb, B:67:0x01e3, B:71:0x01ef, B:75:0x01fe, B:76:0x0201, B:80:0x023f, B:84:0x024a, B:85:0x0261, B:87:0x0276, B:89:0x0280, B:91:0x0284, B:94:0x028e, B:96:0x0292, B:97:0x0297, B:99:0x029f, B:101:0x02a6, B:32:0x00c5, B:35:0x00dc, B:37:0x00e8, B:39:0x00f9, B:41:0x0108, B:42:0x0112, B:44:0x0130, B:33:0x00d0, B:23:0x008f), top: B:105:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:30:0x00b7 A[Catch: Exception -> 0x02ab, TryCatch #0 {Exception -> 0x02ab, blocks: (B:16:0x006e, B:19:0x0082, B:22:0x008b, B:25:0x0095, B:27:0x00a5, B:28:0x00aa, B:30:0x00b7, B:51:0x0143, B:55:0x014d, B:57:0x0155, B:59:0x0176, B:60:0x017b, B:62:0x01c6, B:63:0x01cb, B:67:0x01e3, B:71:0x01ef, B:75:0x01fe, B:76:0x0201, B:80:0x023f, B:84:0x024a, B:85:0x0261, B:87:0x0276, B:89:0x0280, B:91:0x0284, B:94:0x028e, B:96:0x0292, B:97:0x0297, B:99:0x029f, B:101:0x02a6, B:32:0x00c5, B:35:0x00dc, B:37:0x00e8, B:39:0x00f9, B:41:0x0108, B:42:0x0112, B:44:0x0130, B:33:0x00d0, B:23:0x008f), top: B:105:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:31:0x00c3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x00c5 A[Catch: Exception -> 0x02ab, TryCatch #0 {Exception -> 0x02ab, blocks: (B:16:0x006e, B:19:0x0082, B:22:0x008b, B:25:0x0095, B:27:0x00a5, B:28:0x00aa, B:30:0x00b7, B:51:0x0143, B:55:0x014d, B:57:0x0155, B:59:0x0176, B:60:0x017b, B:62:0x01c6, B:63:0x01cb, B:67:0x01e3, B:71:0x01ef, B:75:0x01fe, B:76:0x0201, B:80:0x023f, B:84:0x024a, B:85:0x0261, B:87:0x0276, B:89:0x0280, B:91:0x0284, B:94:0x028e, B:96:0x0292, B:97:0x0297, B:99:0x029f, B:101:0x02a6, B:32:0x00c5, B:35:0x00dc, B:37:0x00e8, B:39:0x00f9, B:41:0x0108, B:42:0x0112, B:44:0x0130, B:33:0x00d0, B:23:0x008f), top: B:105:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00d0 A[Catch: Exception -> 0x02ab, TryCatch #0 {Exception -> 0x02ab, blocks: (B:16:0x006e, B:19:0x0082, B:22:0x008b, B:25:0x0095, B:27:0x00a5, B:28:0x00aa, B:30:0x00b7, B:51:0x0143, B:55:0x014d, B:57:0x0155, B:59:0x0176, B:60:0x017b, B:62:0x01c6, B:63:0x01cb, B:67:0x01e3, B:71:0x01ef, B:75:0x01fe, B:76:0x0201, B:80:0x023f, B:84:0x024a, B:85:0x0261, B:87:0x0276, B:89:0x0280, B:91:0x0284, B:94:0x028e, B:96:0x0292, B:97:0x0297, B:99:0x029f, B:101:0x02a6, B:32:0x00c5, B:35:0x00dc, B:37:0x00e8, B:39:0x00f9, B:41:0x0108, B:42:0x0112, B:44:0x0130, B:33:0x00d0, B:23:0x008f), top: B:105:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00f9 A[Catch: Exception -> 0x02ab, TryCatch #0 {Exception -> 0x02ab, blocks: (B:16:0x006e, B:19:0x0082, B:22:0x008b, B:25:0x0095, B:27:0x00a5, B:28:0x00aa, B:30:0x00b7, B:51:0x0143, B:55:0x014d, B:57:0x0155, B:59:0x0176, B:60:0x017b, B:62:0x01c6, B:63:0x01cb, B:67:0x01e3, B:71:0x01ef, B:75:0x01fe, B:76:0x0201, B:80:0x023f, B:84:0x024a, B:85:0x0261, B:87:0x0276, B:89:0x0280, B:91:0x0284, B:94:0x028e, B:96:0x0292, B:97:0x0297, B:99:0x029f, B:101:0x02a6, B:32:0x00c5, B:35:0x00dc, B:37:0x00e8, B:39:0x00f9, B:41:0x0108, B:42:0x0112, B:44:0x0130, B:33:0x00d0, B:23:0x008f), top: B:105:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0108 A[Catch: Exception -> 0x02ab, TryCatch #0 {Exception -> 0x02ab, blocks: (B:16:0x006e, B:19:0x0082, B:22:0x008b, B:25:0x0095, B:27:0x00a5, B:28:0x00aa, B:30:0x00b7, B:51:0x0143, B:55:0x014d, B:57:0x0155, B:59:0x0176, B:60:0x017b, B:62:0x01c6, B:63:0x01cb, B:67:0x01e3, B:71:0x01ef, B:75:0x01fe, B:76:0x0201, B:80:0x023f, B:84:0x024a, B:85:0x0261, B:87:0x0276, B:89:0x0280, B:91:0x0284, B:94:0x028e, B:96:0x0292, B:97:0x0297, B:99:0x029f, B:101:0x02a6, B:32:0x00c5, B:35:0x00dc, B:37:0x00e8, B:39:0x00f9, B:41:0x0108, B:42:0x0112, B:44:0x0130, B:33:0x00d0, B:23:0x008f), top: B:105:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0142  */
    /* JADX WARN: Code duplicated, block: B:52:0x0147 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x0149  */
    /* JADX WARN: Code duplicated, block: B:54:0x014b  */
    /* JADX WARN: Code duplicated, block: B:57:0x0155 A[Catch: Exception -> 0x02ab, TryCatch #0 {Exception -> 0x02ab, blocks: (B:16:0x006e, B:19:0x0082, B:22:0x008b, B:25:0x0095, B:27:0x00a5, B:28:0x00aa, B:30:0x00b7, B:51:0x0143, B:55:0x014d, B:57:0x0155, B:59:0x0176, B:60:0x017b, B:62:0x01c6, B:63:0x01cb, B:67:0x01e3, B:71:0x01ef, B:75:0x01fe, B:76:0x0201, B:80:0x023f, B:84:0x024a, B:85:0x0261, B:87:0x0276, B:89:0x0280, B:91:0x0284, B:94:0x028e, B:96:0x0292, B:97:0x0297, B:99:0x029f, B:101:0x02a6, B:32:0x00c5, B:35:0x00dc, B:37:0x00e8, B:39:0x00f9, B:41:0x0108, B:42:0x0112, B:44:0x0130, B:33:0x00d0, B:23:0x008f), top: B:105:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0176 A[Catch: Exception -> 0x02ab, TryCatch #0 {Exception -> 0x02ab, blocks: (B:16:0x006e, B:19:0x0082, B:22:0x008b, B:25:0x0095, B:27:0x00a5, B:28:0x00aa, B:30:0x00b7, B:51:0x0143, B:55:0x014d, B:57:0x0155, B:59:0x0176, B:60:0x017b, B:62:0x01c6, B:63:0x01cb, B:67:0x01e3, B:71:0x01ef, B:75:0x01fe, B:76:0x0201, B:80:0x023f, B:84:0x024a, B:85:0x0261, B:87:0x0276, B:89:0x0280, B:91:0x0284, B:94:0x028e, B:96:0x0292, B:97:0x0297, B:99:0x029f, B:101:0x02a6, B:32:0x00c5, B:35:0x00dc, B:37:0x00e8, B:39:0x00f9, B:41:0x0108, B:42:0x0112, B:44:0x0130, B:33:0x00d0, B:23:0x008f), top: B:105:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:62:0x01c6 A[Catch: Exception -> 0x02ab, TryCatch #0 {Exception -> 0x02ab, blocks: (B:16:0x006e, B:19:0x0082, B:22:0x008b, B:25:0x0095, B:27:0x00a5, B:28:0x00aa, B:30:0x00b7, B:51:0x0143, B:55:0x014d, B:57:0x0155, B:59:0x0176, B:60:0x017b, B:62:0x01c6, B:63:0x01cb, B:67:0x01e3, B:71:0x01ef, B:75:0x01fe, B:76:0x0201, B:80:0x023f, B:84:0x024a, B:85:0x0261, B:87:0x0276, B:89:0x0280, B:91:0x0284, B:94:0x028e, B:96:0x0292, B:97:0x0297, B:99:0x029f, B:101:0x02a6, B:32:0x00c5, B:35:0x00dc, B:37:0x00e8, B:39:0x00f9, B:41:0x0108, B:42:0x0112, B:44:0x0130, B:33:0x00d0, B:23:0x008f), top: B:105:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:65:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:66:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:69:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:70:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:74:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:78:0x023b  */
    /* JADX WARN: Code duplicated, block: B:82:0x0247  */
    /* JADX WARN: Code duplicated, block: B:92:0x028b  */
    /* JADX WARN: Code duplicated, block: B:94:0x028e A[Catch: Exception -> 0x02ab, TryCatch #0 {Exception -> 0x02ab, blocks: (B:16:0x006e, B:19:0x0082, B:22:0x008b, B:25:0x0095, B:27:0x00a5, B:28:0x00aa, B:30:0x00b7, B:51:0x0143, B:55:0x014d, B:57:0x0155, B:59:0x0176, B:60:0x017b, B:62:0x01c6, B:63:0x01cb, B:67:0x01e3, B:71:0x01ef, B:75:0x01fe, B:76:0x0201, B:80:0x023f, B:84:0x024a, B:85:0x0261, B:87:0x0276, B:89:0x0280, B:91:0x0284, B:94:0x028e, B:96:0x0292, B:97:0x0297, B:99:0x029f, B:101:0x02a6, B:32:0x00c5, B:35:0x00dc, B:37:0x00e8, B:39:0x00f9, B:41:0x0108, B:42:0x0112, B:44:0x0130, B:33:0x00d0, B:23:0x008f), top: B:105:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:96:0x0292 A[Catch: Exception -> 0x02ab, TryCatch #0 {Exception -> 0x02ab, blocks: (B:16:0x006e, B:19:0x0082, B:22:0x008b, B:25:0x0095, B:27:0x00a5, B:28:0x00aa, B:30:0x00b7, B:51:0x0143, B:55:0x014d, B:57:0x0155, B:59:0x0176, B:60:0x017b, B:62:0x01c6, B:63:0x01cb, B:67:0x01e3, B:71:0x01ef, B:75:0x01fe, B:76:0x0201, B:80:0x023f, B:84:0x024a, B:85:0x0261, B:87:0x0276, B:89:0x0280, B:91:0x0284, B:94:0x028e, B:96:0x0292, B:97:0x0297, B:99:0x029f, B:101:0x02a6, B:32:0x00c5, B:35:0x00dc, B:37:0x00e8, B:39:0x00f9, B:41:0x0108, B:42:0x0112, B:44:0x0130, B:33:0x00d0, B:23:0x008f), top: B:105:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:99:0x029f A[Catch: Exception -> 0x02ab, TryCatch #0 {Exception -> 0x02ab, blocks: (B:16:0x006e, B:19:0x0082, B:22:0x008b, B:25:0x0095, B:27:0x00a5, B:28:0x00aa, B:30:0x00b7, B:51:0x0143, B:55:0x014d, B:57:0x0155, B:59:0x0176, B:60:0x017b, B:62:0x01c6, B:63:0x01cb, B:67:0x01e3, B:71:0x01ef, B:75:0x01fe, B:76:0x0201, B:80:0x023f, B:84:0x024a, B:85:0x0261, B:87:0x0276, B:89:0x0280, B:91:0x0284, B:94:0x028e, B:96:0x0292, B:97:0x0297, B:99:0x029f, B:101:0x02a6, B:32:0x00c5, B:35:0x00dc, B:37:0x00e8, B:39:0x00f9, B:41:0x0108, B:42:0x0112, B:44:0x0130, B:33:0x00d0, B:23:0x008f), top: B:105:0x006e }] */
    /* JADX INFO: renamed from: a */
    private static JSONObject m179a(boolean z, boolean z2, boolean z3) {
        int i;
        int iM449k;
        int i2;
        int i3;
        int i4;
        boolean z4;
        boolean zBooleanValue;
        Object objM147a;
        int i5;
        TbsLog.m665i(LOGTAG, "[TbsDownloader.postJsonData]isQuery: " + z + " forDecoupleCore is " + z3);
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f293c);
        String strM190b = m190b(f293c);
        String strM705e = C0445b.m705e(f293c);
        String strM704d = C0445b.m704d(f293c);
        String strM707g = C0445b.m707g(f293c);
        String id = TimeZone.getDefault().getID();
        String str = id != null ? id : BuildConfig.FLAVOR;
        try {
            if (((TelephonyManager) f293c.getSystemService("phone")) != null) {
                id = "cn";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (id == null) {
            id = BuildConfig.FLAVOR;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (C0418l.m374a(f293c).m387c("tpatch_num") < 5) {
                if (TbsShareManager.isThirdPartyApp(f293c)) {
                    i = 2;
                } else {
                    jSONObject.put("REQUEST_TPATCH", 1);
                }
                jSONObject.put("TIMEZONEID", str);
                jSONObject.put("COUNTRYISO", id);
                if (C0445b.m703c()) {
                    jSONObject.put("REQUEST_64", 1);
                }
                jSONObject.put("PROTOCOLVERSION", 1);
                if (TbsShareManager.isThirdPartyApp(f293c)) {
                    iM449k = C0419m.m393a().m449k(f293c);
                } else {
                    if (z3) {
                        iM449k = C0419m.m393a().m445g(f293c);
                    } else {
                        iM449k = C0419m.m393a().m449k(f293c);
                    }
                    if (iM449k == 0 && C0419m.m393a().m448j(f293c)) {
                        iM449k = -1;
                        if (TbsConfig.APP_QQ.equals(f293c.getApplicationInfo().packageName)) {
                            TbsPVConfig.releaseInstance();
                            if (TbsPVConfig.getInstance(f293c).getLocalCoreVersionMoreTimes() == 1) {
                                iM449k = C0419m.m393a().m445g(f293c);
                            }
                        }
                    }
                    TbsLog.m665i(LOGTAG, "[TbsDownloader.postJsonData] tbsLocalVersion=" + iM449k + " isDownloadForeground=" + z2);
                    if (z2 && !C0419m.m393a().m448j(f293c)) {
                        iM449k = 0;
                    }
                }
                if (z) {
                    i2 = 2;
                } else if (iM449k == 0) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                jSONObject.put("FUNCTION", i2);
                if (TbsShareManager.isThirdPartyApp(f293c)) {
                    JSONArray jSONArrayM195e = m195e();
                    jSONObject.put("TBSVLARR", jSONArrayM195e);
                    f301k = jSONArrayM195e.toString();
                    tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION, jSONArrayM195e.toString());
                    tbsDownloadConfig.commit();
                    if (QbSdk.f198c) {
                        jSONObject.put("THIRDREQ", 1);
                    }
                }
                jSONObject.put("APPN", f293c.getPackageName());
                jSONObject.put("APPVN", m178a(tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, null)));
                jSONObject.put("APPVC", tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, 0));
                jSONObject.put("APPMETA", m178a(tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_METADATA, null)));
                jSONObject.put("TBSSDKV", 44286);
                jSONObject.put("TBSV", iM449k);
                if (iM449k == 0) {
                    jSONObject.put("ISFORCE", true);
                }
                f302l = BuildConfig.FLAVOR + iM449k;
                if (z3) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                jSONObject.put("DOWNLOADDECOUPLECORE", i3);
                Map<String, Object> map = tbsDownloadConfig.mSyncMap;
                if (z3) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                map.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, Integer.valueOf(i4));
                tbsDownloadConfig.commit();
                if (iM449k != 0) {
                    jSONObject.put("TBSBACKUPV", 0);
                }
                jSONObject.put("CPU", f295e);
                jSONObject.put("UA", strM190b);
                jSONObject.put("IMSI", m178a(strM705e));
                jSONObject.put("IMEI", m178a(strM704d));
                jSONObject.put("ANDROID_ID", m178a(strM707g));
                jSONObject.put("GUID", C0445b.m702c(f293c));
                if (!TbsShareManager.isThirdPartyApp(f293c)) {
                    if (iM449k != 0 || QbSdk.m151a(f293c, iM449k)) {
                        i5 = 0;
                    } else {
                        i5 = 1;
                    }
                    jSONObject.put("STATUS", i5);
                    int iM444f = C0419m.m393a().m444f(f293c);
                    jSONObject.put("TBSDV", iM449k % 10000);
                    jSONObject.put("TBSBACKUPV", iM444f);
                }
                z4 = TbsDownloadConfig.getInstance(f293c).mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_FULL_PACKAGE, false);
                if (QbSdk.isEnableSensitiveApi() || (objM147a = QbSdk.m147a(f293c, "can_unlzma", (Bundle) null)) == null || !(objM147a instanceof Boolean)) {
                    zBooleanValue = false;
                } else {
                    zBooleanValue = ((Boolean) objM147a).booleanValue();
                }
                if (zBooleanValue ? !z4 : false) {
                    jSONObject.put("REQUEST_LZMA", 1);
                }
                if (getOverSea(f293c)) {
                    jSONObject.put("OVERSEA", 1);
                }
                if (z2) {
                    jSONObject.put("DOWNLOAD_FOREGROUND", 1);
                }
                TbsLog.m665i(LOGTAG, "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
                return jSONObject;
            }
            i = 0;
            jSONObject.put("REQUEST_TPATCH", i);
            jSONObject.put("TIMEZONEID", str);
            jSONObject.put("COUNTRYISO", id);
            if (C0445b.m703c()) {
                jSONObject.put("REQUEST_64", 1);
            }
            jSONObject.put("PROTOCOLVERSION", 1);
            if (TbsShareManager.isThirdPartyApp(f293c)) {
                iM449k = C0419m.m393a().m449k(f293c);
            } else {
                if (z3) {
                    iM449k = C0419m.m393a().m445g(f293c);
                } else {
                    iM449k = C0419m.m393a().m449k(f293c);
                }
                if (iM449k == 0) {
                    iM449k = -1;
                    if (TbsConfig.APP_QQ.equals(f293c.getApplicationInfo().packageName)) {
                        TbsPVConfig.releaseInstance();
                        if (TbsPVConfig.getInstance(f293c).getLocalCoreVersionMoreTimes() == 1) {
                            iM449k = C0419m.m393a().m445g(f293c);
                        }
                    }
                }
                TbsLog.m665i(LOGTAG, "[TbsDownloader.postJsonData] tbsLocalVersion=" + iM449k + " isDownloadForeground=" + z2);
                if (z2) {
                    iM449k = 0;
                }
            }
            if (z) {
                i2 = 2;
            } else if (iM449k == 0) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            jSONObject.put("FUNCTION", i2);
            if (TbsShareManager.isThirdPartyApp(f293c)) {
                JSONArray jSONArrayM195e2 = m195e();
                jSONObject.put("TBSVLARR", jSONArrayM195e2);
                f301k = jSONArrayM195e2.toString();
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION, jSONArrayM195e2.toString());
                tbsDownloadConfig.commit();
                if (QbSdk.f198c) {
                    jSONObject.put("THIRDREQ", 1);
                }
            }
            jSONObject.put("APPN", f293c.getPackageName());
            jSONObject.put("APPVN", m178a(tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, null)));
            jSONObject.put("APPVC", tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, 0));
            jSONObject.put("APPMETA", m178a(tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_METADATA, null)));
            jSONObject.put("TBSSDKV", 44286);
            jSONObject.put("TBSV", iM449k);
            if (iM449k == 0) {
                jSONObject.put("ISFORCE", true);
            }
            f302l = BuildConfig.FLAVOR + iM449k;
            if (z3) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            jSONObject.put("DOWNLOADDECOUPLECORE", i3);
            Map<String, Object> map2 = tbsDownloadConfig.mSyncMap;
            if (z3) {
                i4 = 1;
            } else {
                i4 = 0;
            }
            map2.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, Integer.valueOf(i4));
            tbsDownloadConfig.commit();
            if (iM449k != 0) {
                jSONObject.put("TBSBACKUPV", 0);
            }
            jSONObject.put("CPU", f295e);
            jSONObject.put("UA", strM190b);
            jSONObject.put("IMSI", m178a(strM705e));
            jSONObject.put("IMEI", m178a(strM704d));
            jSONObject.put("ANDROID_ID", m178a(strM707g));
            jSONObject.put("GUID", C0445b.m702c(f293c));
            if (!TbsShareManager.isThirdPartyApp(f293c)) {
                if (iM449k != 0) {
                    i5 = 0;
                } else {
                    i5 = 0;
                }
                jSONObject.put("STATUS", i5);
                int iM444f2 = C0419m.m393a().m444f(f293c);
                jSONObject.put("TBSDV", iM449k % 10000);
                jSONObject.put("TBSBACKUPV", iM444f2);
            }
            z4 = TbsDownloadConfig.getInstance(f293c).mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_FULL_PACKAGE, false);
            if (QbSdk.isEnableSensitiveApi()) {
                zBooleanValue = false;
            } else {
                zBooleanValue = false;
            }
            if (zBooleanValue ? !z4 : false) {
                jSONObject.put("REQUEST_LZMA", 1);
            }
            if (getOverSea(f293c)) {
                jSONObject.put("OVERSEA", 1);
            }
            if (z2) {
                jSONObject.put("DOWNLOAD_FOREGROUND", 1);
            }
        } catch (Exception unused) {
        }
        TbsLog.m665i(LOGTAG, "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
        return jSONObject;
    }

    /* JADX INFO: renamed from: a */
    private static void m180a(int i) {
        File file = new File(C0419m.m411o(f293c), "tbs_switch_disable_" + i);
        if (file.exists()) {
            return;
        }
        try {
            TbsLog.m665i(LOGTAG, "setTbsCoreDisabledBySwitch status: " + file.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m181a(final Context context, final Runnable runnable) {
        Thread thread = new Thread() { // from class: com.tencent.smtt.sdk.TbsDownloader.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws Throwable {
                FileOutputStream fileOutputStreamM643b;
                final FileChannel channel;
                FileLock fileLockLock = null;
                try {
                    try {
                        final Timer timerM158c = QbSdk.m158c();
                        fileOutputStreamM643b = FileUtil.m643b(context, true, "tbs_download_lock_file");
                        if (fileOutputStreamM643b == null || timerM158c == null) {
                            channel = null;
                        } else {
                            try {
                                channel = fileOutputStreamM643b.getChannel();
                                try {
                                    new java.util.Timer().schedule(new TimerTask() { // from class: com.tencent.smtt.sdk.TbsDownloader.3.1
                                        @Override // java.util.TimerTask, java.lang.Runnable
                                        public void run() {
                                            FileChannel fileChannel = channel;
                                            if (fileChannel == null || !fileChannel.isOpen()) {
                                                return;
                                            }
                                            try {
                                                channel.close();
                                                timerM158c.onTimeOut();
                                                TbsLog.m665i(TbsDownloader.LOGTAG, "wait download process lock timeout");
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }, timerM158c.timeOut);
                                    TbsLog.m665i(TbsDownloader.LOGTAG, "start waiting other process Download finished");
                                    fileLockLock = channel.lock();
                                    TbsLog.m665i(TbsDownloader.LOGTAG, "wait lock success");
                                } catch (Exception e) {
                                    e = e;
                                    TbsLog.m672w(TbsDownloader.LOGTAG, "MultiProcessSyncInit exception: " + Log.getStackTraceString(e));
                                }
                            } catch (Exception e2) {
                                e = e2;
                                channel = null;
                            } catch (Throwable th) {
                                th = th;
                                channel = null;
                                FileUtil.m631a(fileLockLock, fileOutputStreamM643b);
                                TbsLog.m665i(TbsDownloader.LOGTAG, "release wait download lock");
                                FileUtil.m627a(channel);
                                FileUtil.m627a(fileOutputStreamM643b);
                                throw th;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fileOutputStreamM643b = null;
                        channel = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStreamM643b = null;
                        channel = null;
                    }
                    FileUtil.m631a(fileLockLock, fileOutputStreamM643b);
                    TbsLog.m665i(TbsDownloader.LOGTAG, "release wait download lock");
                    FileUtil.m627a(channel);
                    FileUtil.m627a(fileOutputStreamM643b);
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        };
        thread.setName("tbsSyncWaiter");
        thread.start();
    }

    /* JADX INFO: renamed from: a */
    private static void m182a(boolean z, TbsDownloaderCallback tbsDownloaderCallback, boolean z2) {
        TbsLog.m665i(LOGTAG, "[TbsDownloader.queryConfig]");
        f294d.removeMessages(100);
        Message messageObtain = Message.obtain(f294d, 100);
        if (tbsDownloaderCallback != null) {
            messageObtain.obj = tbsDownloaderCallback;
        }
        messageObtain.arg1 = 0;
        messageObtain.arg1 = z ? 1 : 0;
        messageObtain.arg2 = z2 ? 1 : 0;
        messageObtain.sendToTarget();
    }

    /* JADX INFO: renamed from: a */
    public static boolean m183a(Context context) {
        return TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m184a(Context context, int i) {
        return Build.VERSION.SDK_INT > 28 && context.getApplicationInfo().targetSdkVersion > 28 && i > 0 && i < 45114;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m185a(Context context, boolean z) {
        int i;
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
        if (Build.VERSION.SDK_INT < 8) {
            i = -102;
        } else {
            String string = tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_DEVICE_CPUABI, null);
            f295e = string;
            if (TextUtils.isEmpty(string) || C0445b.m696a(f295e)) {
                return true;
            }
            TbsLog.m662e(LOGTAG, "can not support x86 devices!!");
            i = -104;
        }
        tbsDownloadConfig.setDownloadInterruptCode(i);
        return false;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m186a(Context context, boolean z, boolean z2) {
        String str;
        boolean z3;
        String str2;
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
        if (z) {
            str = "needSendRequest true download foreground, stack: " + Log.getStackTraceString(new Throwable());
        } else {
            String string = tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, null);
            int i = tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, 0);
            String string2 = tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_METADATA, null);
            String strM689a = C0445b.m689a(f293c);
            int iM698b = C0445b.m698b(f293c);
            String strM691a = C0445b.m691a(f293c, TBS_METADATA);
            TbsLog.m665i(LOGTAG, "[TbsDownloader.needSendQueryRequest] appVersionName=" + strM689a + " oldAppVersionName=" + string + " appVersionCode=" + iM698b + " oldAppVersionCode=" + i + " appMetadata=" + strM691a + " oldAppVersionMetadata=" + string2);
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK, 0L);
            StringBuilder sb = new StringBuilder();
            sb.append("[TbsDownloader.needSendQueryRequest] timeLastCheck=");
            sb.append(j);
            sb.append(" timeNow=");
            sb.append(jCurrentTimeMillis);
            TbsLog.m665i(LOGTAG, sb.toString());
            if (z2) {
                boolean zContains = tbsDownloadConfig.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK);
                TbsLog.m665i(LOGTAG, "[TbsDownloader.needSendQueryRequest] hasLaskCheckKey=" + zContains);
                if (zContains && j == 0) {
                    j = jCurrentTimeMillis;
                }
            }
            long j2 = tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_REQUEST_SUCCESS, 0L);
            long j3 = tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0L);
            long retryInterval = tbsDownloadConfig.getRetryInterval();
            TbsLog.m665i(LOGTAG, "retryInterval = " + retryInterval + " s");
            TbsPVConfig.releaseInstance();
            int emergentCoreVersion = TbsPVConfig.getInstance(f293c).getEmergentCoreVersion();
            int i2 = TbsDownloadConfig.getInstance(f293c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            long j4 = jCurrentTimeMillis - j;
            long j5 = retryInterval * 1000;
            if (j4 > j5) {
                str = "needSendRequest  true  #1";
            } else if (emergentCoreVersion > C0419m.m393a().m445g(f293c) && emergentCoreVersion > i2) {
                str = "emergentCoreVersion is " + emergentCoreVersion + " getTbsCoreInstalledVerInNolock is " + C0419m.m393a().m445g(f293c) + " responseCoreVersion is " + i2;
            } else {
                if (!TbsShareManager.isThirdPartyApp(f293c) || j2 <= 0 || jCurrentTimeMillis - j2 <= j5 || j3 >= 11) {
                    if (TbsShareManager.isThirdPartyApp(f293c) && QbSdk.getTbsVersion(f293c) == 0 && !m194d()) {
                        TbsLog.m665i(LOGTAG, "needSendRequest  true  #4");
                        C0419m.m393a().m441d(f293c);
                        str2 = null;
                        z3 = true;
                    } else {
                        if (strM689a == null || iM698b == 0 || strM691a == null) {
                            if (TbsShareManager.isThirdPartyApp(f293c)) {
                                str2 = "timeNow - timeLastCheck is " + j4 + " sendRequestWithSameHostCoreVersion() is " + m194d() + " appVersionName is " + strM689a + " appVersionCode is " + iM698b + " appMetadata is " + strM691a + " oldAppVersionName is " + string + " oldAppVersionCode is " + i + " oldAppVersionMetadata is " + string2;
                            }
                            z3 = false;
                        } else if (!strM689a.equals(string) || iM698b != i || !strM691a.equals(string2)) {
                            str = "needSendRequest  true  #5";
                        }
                        str2 = null;
                        z3 = false;
                    }
                    if (!z3 && TbsShareManager.isThirdPartyApp(f293c)) {
                        TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(f293c).tbsLogInfo();
                        tbsLogInfo.setErrorCode(-119);
                        tbsLogInfo.setFailDetail(str2);
                        TbsLogReport.getInstance(f293c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
                    }
                    return z3;
                }
                str = "needSendRequest  true  #3";
            }
        }
        TbsLog.m665i(LOGTAG, str);
        str2 = null;
        z3 = true;
        if (!z3) {
            TbsLogReport.TbsLogInfo tbsLogInfo2 = TbsLogReport.getInstance(f293c).tbsLogInfo();
            tbsLogInfo2.setErrorCode(-119);
            tbsLogInfo2.setFailDetail(str2);
            TbsLogReport.getInstance(f293c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo2);
        }
        return z3;
    }

    @TargetApi(11)
    /* JADX INFO: renamed from: a */
    private static boolean m187a(String str, int i, boolean z, boolean z2, boolean z3) throws Exception {
        boolean z4;
        Integer num;
        String str2;
        String str3;
        int tbsVersion;
        TbsLog.m665i(LOGTAG, "[TbsDownloader.readResponse] response=" + str + ";isNeedInstall=" + z3);
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f293c);
        if (TextUtils.isEmpty(str)) {
            tbsDownloadConfig.setDownloadInterruptCode(-108);
            TbsLog.m665i(LOGTAG, "[TbsDownloader.readResponse] return #1,response is empty...");
            return false;
        }
        JSONObject jSONObject = new JSONObject(str);
        int i2 = jSONObject.getInt("RET");
        if (i2 != 0) {
            tbsDownloadConfig.setDownloadInterruptCode(-109);
            TbsLog.m665i(LOGTAG, "[TbsDownloader.readResponse] return #2,returnCode=" + i2);
            return false;
        }
        int i3 = jSONObject.getInt("RESPONSECODE");
        String string = jSONObject.getString("DOWNLOADURL");
        String strOptString = jSONObject.optString("URLLIST", BuildConfig.FLAVOR);
        int i4 = jSONObject.getInt("TBSAPKSERVERVERSION");
        if (QbSdk.m157b(f293c, i4)) {
            tbsDownloadConfig.setDownloadInterruptCode(-126);
            return false;
        }
        int i5 = jSONObject.getInt("DOWNLOADMAXFLOW") * 2;
        int i6 = jSONObject.getInt("DOWNLOAD_MIN_FREE_SPACE");
        int i7 = jSONObject.getInt("DOWNLOAD_SUCCESS_MAX_RETRYTIMES");
        int i8 = jSONObject.getInt("DOWNLOAD_FAILED_MAX_RETRYTIMES");
        long j = jSONObject.getLong("DOWNLOAD_SINGLE_TIMEOUT");
        long j2 = jSONObject.getLong("TBSAPKFILESIZE");
        long jOptLong = jSONObject.optLong("RETRY_INTERVAL", 0L);
        int iOptInt = jSONObject.optInt("FLOWCTR", -1);
        int iOptInt2 = jSONObject.optInt("USEX5", 1);
        m198h();
        m197g();
        if (iOptInt2 == 0 && (tbsVersion = QbSdk.getTbsVersion(f293c)) != 0) {
            m180a(tbsVersion);
        }
        try {
            if (!TextUtils.isEmpty(string)) {
                string.contains(BuildConfig.FLAVOR + i4);
            }
        } catch (Throwable th) {
            TbsLog.m665i(LOGTAG, "throwable is " + Log.getStackTraceString(th));
        }
        int iOptInt3 = jSONObject.optInt("USEBBACKUPVER", 0);
        try {
            iOptInt3 = jSONObject.getInt("USEBBACKUPVER");
        } catch (Exception unused) {
        }
        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_USE_BACKUP_VERSION, Integer.valueOf(iOptInt3));
        String strOptString2 = jSONObject.optString("PKGMD5", null);
        int iOptInt4 = jSONObject.optInt("RESETX5", 0);
        jSONObject.optInt("UPLOADLOG", 0);
        jSONObject.optInt("RESETDECOUPLECORE", 0);
        String strOptString3 = jSONObject.optString("SETTOKEN", BuildConfig.FLAVOR);
        boolean z5 = jSONObject.optInt("RESETTOKEN", 0) != 0;
        boolean z6 = jSONObject.optInt("ENABLE_LOAD_RENAME_FILE_LOCK_WAIT", 1) != 0;
        int iOptInt5 = jSONObject.optInt("RESETTODECOUPLECORE", 0);
        synchronized (f296f) {
            if (z5) {
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DESkEY_TOKEN, BuildConfig.FLAVOR);
            }
            if (!TextUtils.isEmpty(strOptString3) && strOptString3.length() == 96) {
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DESkEY_TOKEN, strOptString3 + "&" + C0451h.m749c());
            }
        }
        if (iOptInt4 == 1) {
            tbsDownloadConfig.setDownloadInterruptCode(-110);
            QbSdk.reset(f293c, iOptInt5 == 1);
            str2 = LOGTAG;
            str3 = "[TbsDownloader.readResponse] return #3,needResetTbs=1,isQuery=" + z;
        } else {
            if (!z6) {
                tbsDownloadConfig.setTbsCoreLoadRenameFileLockWaitEnable(z6);
            }
            long retryIntervalInSeconds = TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC;
            if (iOptInt == 1) {
                if (jOptLong > 604800) {
                    jOptLong = 604800;
                }
                if (jOptLong > 0) {
                    retryIntervalInSeconds = jOptLong;
                }
                TbsLog.m672w(LOGTAG, "Download is Flowed, next download request is " + retryIntervalInSeconds + "s later");
                if (TbsShareManager.isThirdPartyApp(f293c)) {
                    tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.FALSE);
                    tbsDownloadConfig.commit();
                    tbsDownloadConfig.setDownloadInterruptCode(TbsCommonCode.DOWNLOAD_FLOW_CANCEL);
                    return false;
                }
            }
            if (getRetryIntervalInSeconds() >= 0) {
                retryIntervalInSeconds = getRetryIntervalInSeconds();
            }
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_RETRY_INTERVAL, Long.valueOf(retryIntervalInSeconds));
            int i9 = -124;
            if (TextUtils.isEmpty(string) && TbsShareManager.isThirdPartyApp(f293c)) {
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.FALSE);
                tbsDownloadConfig.commit();
                tbsDownloadConfig.setDownloadInterruptCode(-124);
                str2 = LOGTAG;
                str3 = "[TbsDownloader.readResponse] blank url,current app is third app...";
            } else {
                TbsLog.m665i(LOGTAG, "in response responseCode is " + i3);
                if (i3 == 0) {
                    tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, Integer.valueOf(i3));
                    tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.FALSE);
                    tbsDownloadConfig.setDownloadInterruptCode(-111);
                    tbsDownloadConfig.commit();
                    TbsLog.m665i(LOGTAG, "[TbsDownloader.readResponse] return #5,responseCode=0");
                    return false;
                }
                int i10 = TbsDownloadConfig.getInstance(f293c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
                if (i10 > i4) {
                    f297g.m368b();
                    C0419m.m393a().m450l(f293c);
                }
                if (TbsShareManager.isThirdPartyApp(f293c)) {
                    z4 = false;
                } else {
                    int iM440d = C0419m.m393a().m440d(f293c, 0);
                    z4 = iM440d >= i4;
                    TbsLog.m665i(LOGTAG, "tmpCoreVersion is " + iM440d + " tbsDownloadVersion is" + i4);
                }
                if (i >= i4 || TextUtils.isEmpty(string) || z4) {
                    tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.FALSE);
                    tbsDownloadConfig.commit();
                    if (!TextUtils.isEmpty(string)) {
                        if (i4 <= 0) {
                            i9 = -125;
                        } else {
                            i9 = i >= i4 ? -127 : -112;
                        }
                    }
                    tbsDownloadConfig.setDownloadInterruptCode(i9);
                    TbsLog.m665i(LOGTAG, "version error or downloadUrl empty ,return ahead tbsLocalVersion=" + i + " tbsDownloadVersion=" + i4 + " tbsLastDownloadVersion=" + i10 + " downloadUrl=" + string);
                    return false;
                }
                if (string.equals(tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, null))) {
                    num = 0;
                } else {
                    f297g.m368b();
                    num = 0;
                    tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, null);
                    tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, null);
                }
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, Integer.valueOf(i4));
                TbsLog.m665i(LOGTAG, "put KEY_TBS_DOWNLOAD_V is " + i4);
                if (i4 > 0) {
                    tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, num);
                }
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, string);
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADURL_LIST, strOptString);
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, Integer.valueOf(i3));
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_MAXFLOW, Integer.valueOf(i5));
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_MIN_FREE_SPACE, Integer.valueOf(i6));
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES, Integer.valueOf(i7));
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES, Integer.valueOf(i8));
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SINGLE_TIMEOUT, Long.valueOf(j));
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, Long.valueOf(j2));
                tbsDownloadConfig.commit();
                if (strOptString2 != 0) {
                    tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPK_MD5, strOptString2);
                }
                if (z2 || !z3 || !C0419m.m393a().m436b(f293c, i4)) {
                    if (!z) {
                        tbsDownloadConfig.setDownloadInterruptCode(Core.GpuNotSupported);
                    }
                    Map<String, Object> map = tbsDownloadConfig.mSyncMap;
                    Boolean bool = Boolean.TRUE;
                    map.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, bool);
                    TbsLog.m665i(LOGTAG, "[TbsDownloader.readResponse] ##9 set needDownload=true");
                    if (jSONObject.optInt("stop_pre_oat", 0) == 1) {
                        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_STOP_PRE_OAT, bool);
                    }
                    tbsDownloadConfig.commit();
                    return true;
                }
                tbsDownloadConfig.setDownloadInterruptCode(Core.StsNotImplemented);
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.FALSE);
                str2 = LOGTAG;
                str3 = "[TbsDownloader.readResponse] ##6 set needDownload=false";
            }
        }
        TbsLog.m665i(str2, str3);
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0068  */
    /* JADX WARN: Code duplicated, block: B:30:0x007a  */
    /* JADX WARN: Code duplicated, block: B:31:0x007e  */
    /* JADX WARN: Code duplicated, block: B:33:0x0084  */
    /* JADX WARN: Code duplicated, block: B:36:0x0090  */
    /* JADX WARN: Code duplicated, block: B:39:0x009b  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:43:0x00aa  */
    /* JADX INFO: renamed from: b */
    public static String m190b(Context context) {
        String lowerCase;
        String str;
        String strReplaceAll;
        String strM821a;
        if (!TextUtils.isEmpty(f292b)) {
            return f292b;
        }
        Locale locale = Locale.getDefault();
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = Build.VERSION.RELEASE;
        try {
            str2 = new String(str2.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception unused) {
        }
        if (str2 != null && str2.length() > 0) {
            stringBuffer.append(str2);
        } else {
            stringBuffer.append("1.0");
        }
        stringBuffer.append("; ");
        String language = locale.getLanguage();
        if (language != null) {
            stringBuffer.append(language.toLowerCase());
            String country = locale.getCountry();
            if (country != null) {
                stringBuffer.append("-");
                lowerCase = country.toLowerCase();
            }
            if ("REL".equals(Build.VERSION.CODENAME)) {
                strM821a = C0462s.m821a(context);
                try {
                    strM821a = new String(strM821a.getBytes("UTF-8"), "ISO8859-1");
                } catch (Exception unused2) {
                }
                if (strM821a == null) {
                    stringBuffer.append("; ");
                } else if (strM821a.length() > 0) {
                    stringBuffer.append("; ");
                    stringBuffer.append(strM821a);
                }
            }
            str = Build.ID;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            strReplaceAll = str.replaceAll("[一-龥]", BuildConfig.FLAVOR);
            if (strReplaceAll == null) {
                if (strReplaceAll.length() > 0) {
                    stringBuffer.append(" Build/");
                }
                String str3 = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", stringBuffer);
                f292b = str3;
                return str3;
            }
            stringBuffer.append(" Build/");
            strReplaceAll = "00";
            stringBuffer.append(strReplaceAll);
            String str4 = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", stringBuffer);
            f292b = str4;
            return str4;
        }
        lowerCase = "en";
        stringBuffer.append(lowerCase);
        if ("REL".equals(Build.VERSION.CODENAME)) {
            strM821a = C0462s.m821a(context);
            strM821a = new String(strM821a.getBytes("UTF-8"), "ISO8859-1");
            if (strM821a == null) {
                stringBuffer.append("; ");
            } else if (strM821a.length() > 0) {
                stringBuffer.append("; ");
                stringBuffer.append(strM821a);
            }
        }
        str = Build.ID;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        strReplaceAll = str.replaceAll("[一-龥]", BuildConfig.FLAVOR);
        if (strReplaceAll == null) {
            if (strReplaceAll.length() > 0) {
                stringBuffer.append(" Build/");
            }
            String str5 = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", stringBuffer);
            f292b = str5;
            return str5;
        }
        stringBuffer.append(" Build/");
        strReplaceAll = "00";
        stringBuffer.append(strReplaceAll);
        String str6 = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", stringBuffer);
        f292b = str6;
        return str6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static boolean m191b(final boolean z, boolean z2, boolean z3, boolean z4) {
        final TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f293c);
        Map<String, Object> map = QbSdk.f210o;
        if (map != null && map.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.f210o.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.m665i(LOGTAG, "[TbsDownloader.sendRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
            tbsDownloadConfig.setDownloadInterruptCode(-131);
            return false;
        }
        TbsLog.m665i(LOGTAG, "[TbsDownloader.sendRequest]isQuery: " + z + " forDecoupleCore is " + z3);
        if (C0419m.m393a().m439c(f293c)) {
            TbsLog.m665i(LOGTAG, "[TbsDownloader.sendRequest] -- isTbsLocalInstalled!");
            tbsDownloadConfig.setDownloadInterruptCode(-132);
            return false;
        }
        if (f295e == null) {
            String strM688a = C0445b.m688a();
            f295e = strM688a;
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DEVICE_CPUABI, strM688a);
            tbsDownloadConfig.commit();
        }
        if (!TextUtils.isEmpty(f295e) && !C0445b.m696a(f295e)) {
            tbsDownloadConfig.setDownloadInterruptCode(-104);
            TbsLog.m665i(LOGTAG, "TbsDownloader sendRequest cpu is invalid:" + f295e);
            return false;
        }
        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, C0445b.m689a(f293c));
        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, Integer.valueOf(C0445b.m698b(f293c)));
        tbsDownloadConfig.commit();
        JSONObject jSONObjectM179a = m179a(z, z2, z3);
        int iOptInt = jSONObjectM179a.optInt("TBSV", -1);
        if (iOptInt != -1) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (TbsShareManager.isThirdPartyApp(f293c)) {
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, Long.valueOf(jCurrentTimeMillis - tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_REQUEST_FAIL, 0L) < tbsDownloadConfig.getRetryInterval() * 1000 ? tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0L) + 1 : 1L));
            }
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_REQUEST_FAIL, Long.valueOf(jCurrentTimeMillis));
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, C0445b.m689a(f293c));
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, Integer.valueOf(C0445b.m698b(f293c)));
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_METADATA, C0445b.m691a(f293c, TBS_METADATA));
            tbsDownloadConfig.commit();
        }
        if (iOptInt != -1 || z3) {
            try {
                String strM799d = C0458o.m794a(f293c).m799d();
                TbsLog.m665i(LOGTAG, "[TbsDownloader.sendRequest] postUrl=" + strM799d);
                if (z) {
                    f305o = jSONObjectM179a;
                } else {
                    f306p = jSONObjectM179a;
                }
                if (z) {
                    return true;
                }
                try {
                    String strM740a = C0450g.m740a(strM799d, jSONObjectM179a.toString().getBytes("utf-8"), new C0450g.a() { // from class: com.tencent.smtt.sdk.TbsDownloader.2
                        @Override // com.tencent.smtt.utils.C0450g.a
                        /* JADX INFO: renamed from: a */
                        public void mo200a(int i) {
                            TbsDownloadConfig tbsDownloadConfig2;
                            int i2;
                            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK, Long.valueOf(System.currentTimeMillis()));
                            tbsDownloadConfig.commit();
                            TbsLog.m665i(TbsDownloader.LOGTAG, "[TbsDownloader.sendRequest] httpResponseCode=" + i);
                            if (TbsShareManager.isThirdPartyApp(TbsDownloader.f293c) && i == 200) {
                                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_REQUEST_SUCCESS, Long.valueOf(System.currentTimeMillis()));
                                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_REQUEST_FAIL, 0L);
                                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0L);
                                tbsDownloadConfig.commit();
                            }
                            if (i >= 300) {
                                if (z) {
                                    tbsDownloadConfig2 = tbsDownloadConfig;
                                    i2 = -107;
                                } else {
                                    tbsDownloadConfig2 = tbsDownloadConfig;
                                    i2 = Core.StsBadPoint;
                                }
                                tbsDownloadConfig2.setDownloadInterruptCode(i2);
                            }
                        }
                    }, false);
                    if (!TextUtils.isEmpty(strM740a) && strM740a.contains("HttpError")) {
                        TbsLog.m665i(LOGTAG, "Cfg Request error: " + strM740a);
                        TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(f293c).tbsLogInfo();
                        tbsLogInfo.setErrorCode(-129);
                        tbsLogInfo.setFailDetail(strM740a);
                        TbsLogReport.getInstance(f293c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
                    }
                    return m187a(strM740a, iOptInt, z, z2, z4);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            TbsLog.m665i(LOGTAG, "sendrequest return false " + Log.getStackTraceString(th));
            th.printStackTrace();
            tbsDownloadConfig.setDownloadInterruptCode(-106);
        } else {
            tbsDownloadConfig.setDownloadInterruptCode(-113);
        }
        return false;
    }

    /* JADX INFO: renamed from: c */
    private static synchronized void m192c() {
        if (f298h == null) {
            f298h = TbsHandlerThread.getInstance();
            try {
                f297g = new C0417k(f293c);
                f294d = new Handler(f298h.getLooper()) { // from class: com.tencent.smtt.sdk.TbsDownloader.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        int i = message.what;
                        if (i == 109) {
                            if (TbsDownloader.f297g != null) {
                                TbsDownloader.f297g.m373e();
                                return;
                            }
                            return;
                        }
                        if (i == 110) {
                            if (TbsDownloader.f293c != null) {
                                TbsDownloadConfig.getInstance(TbsDownloader.f293c).saveDownloadInterruptCode();
                                return;
                            }
                            return;
                        }
                        switch (i) {
                            case 100:
                                boolean z = message.arg1 == 1;
                                boolean zM191b = TbsDownloader.m191b(true, false, false, message.arg2 == 1);
                                Object obj = message.obj;
                                if (obj != null && (obj instanceof TbsDownloaderCallback)) {
                                    TbsLog.m665i(TbsDownloader.LOGTAG, "needDownload-onNeedDownloadFinish needStartDownload=" + zM191b);
                                    String str = (TbsDownloader.f293c == null || TbsDownloader.f293c.getApplicationContext() == null || TbsDownloader.f293c.getApplicationContext().getApplicationInfo() == null) ? BuildConfig.FLAVOR : TbsDownloader.f293c.getApplicationContext().getApplicationInfo().packageName;
                                    if (!zM191b || z) {
                                        ((TbsDownloaderCallback) message.obj).onNeedDownloadFinish(zM191b, TbsDownloadConfig.getInstance(TbsDownloader.f293c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                                    } else if (TbsConfig.APP_WX.equals(str) || TbsConfig.APP_QQ.equals(str)) {
                                        TbsLog.m665i(TbsDownloader.LOGTAG, "needDownload-onNeedDownloadFinish in mm or QQ callback needStartDownload = " + zM191b);
                                        ((TbsDownloaderCallback) message.obj).onNeedDownloadFinish(zM191b, TbsDownloadConfig.getInstance(TbsDownloader.f293c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                                    }
                                }
                                if (TbsShareManager.isThirdPartyApp(TbsDownloader.f293c) && zM191b) {
                                    TbsDownloader.startDownload(TbsDownloader.f293c);
                                    break;
                                }
                                break;
                            case 101:
                                TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(TbsDownloader.f293c);
                                if (Apn.getApnType(TbsDownloader.f293c) == 3 || QbSdk.canDownloadWithoutWifi()) {
                                    TbsLog.m665i(TbsDownloader.LOGTAG, "---getting download file lock...");
                                    FileOutputStream fileOutputStreamM643b = FileUtil.m643b(TbsDownloader.f293c, true, "tbs_download_lock_file");
                                    if (fileOutputStreamM643b == null) {
                                        tbsDownloadConfig.setDownloadInterruptCode(Core.StsObjectNotFound);
                                        QbSdk.f209n.onDownloadFinish(TbsListener.ErrorCode.STARTDOWNLOAD_LOCKED_IO_FAILED);
                                        QbSdk.f209n.onInstallFinish(243);
                                        TbsLog.m672w(TbsDownloader.LOGTAG, "download file-lock file io exception");
                                    } else {
                                        FileLock fileLockM625a = FileUtil.m625a(TbsDownloader.f293c, fileOutputStreamM643b);
                                        if (fileLockM625a != null) {
                                            boolean z2 = message.arg1 == 1;
                                            if (TbsDownloader.m191b(false, z2, false, true)) {
                                                if (z2 && C0419m.m393a().m436b(TbsDownloader.f293c, TbsDownloadConfig.getInstance(TbsDownloader.f293c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0))) {
                                                    TbsLog.m665i(TbsDownloader.LOGTAG, "needStartDownload, but try local install core firstly");
                                                    QbSdk.f209n.onDownloadFinish(122);
                                                    QbSdk.f209n.onInstallFinish(243);
                                                    tbsDownloadConfig.setDownloadInterruptCode(Core.StsNotImplemented);
                                                } else if (tbsDownloadConfig.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false)) {
                                                    TbsDownloadConfig.getInstance(TbsDownloader.f293c).setDownloadInterruptCode(Core.StsAssert);
                                                    TbsLog.m665i(TbsDownloader.LOGTAG, "start download in apk downloader...");
                                                    TbsDownloader.f297g.m367a(z2, false);
                                                } else {
                                                    tbsDownloadConfig.setDownloadInterruptCode(-133);
                                                    QbSdk.f209n.onDownloadFinish(TbsListener.ErrorCode.STARTDOWNLOAD_NEEDDOWNLOAD_KEY_ERROR);
                                                }
                                                TbsLog.m665i(TbsDownloader.LOGTAG, "------freeDownloadFileLock...");
                                                FileUtil.m631a(fileLockM625a, fileOutputStreamM643b);
                                            } else {
                                                int currentDownloadInterruptCode = TbsDownloadConfig.getInstance(TbsDownloader.f293c).getCurrentDownloadInterruptCode();
                                                TbsLog.m665i(TbsDownloader.LOGTAG, "No need to download, code is " + currentDownloadInterruptCode);
                                                QbSdk.f209n.onDownloadFinish(currentDownloadInterruptCode);
                                            }
                                            QbSdk.f209n.onInstallFinish(243);
                                            TbsLog.m665i(TbsDownloader.LOGTAG, "------freeDownloadFileLock...");
                                            FileUtil.m631a(fileLockM625a, fileOutputStreamM643b);
                                        } else {
                                            TbsLog.m665i(TbsDownloader.LOGTAG, "download file-lock locked, core is downloading");
                                            tbsDownloadConfig.setDownloadInterruptCode(Core.StsInplaceNotSupported);
                                            FileUtil.m627a(fileOutputStreamM643b);
                                            if (QbSdk.m158c() == null) {
                                                QbSdk.f209n.onDownloadFinish(TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING);
                                                QbSdk.f209n.onInstallFinish(243);
                                            } else {
                                                TbsDownloader.m181a(TbsDownloader.f293c, new Runnable() { // from class: com.tencent.smtt.sdk.TbsDownloader.1.1
                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        QbSdk.f209n.onDownloadFinish(TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING);
                                                        QbSdk.f209n.onInstallFinish(243);
                                                    }
                                                });
                                            }
                                        }
                                    }
                                } else {
                                    TbsLog.m665i(TbsDownloader.LOGTAG, "not wifi,no need send request");
                                    tbsDownloadConfig.setDownloadInterruptCode(Core.OpenCLApiCallError);
                                    QbSdk.f209n.onDownloadFinish(111);
                                    QbSdk.f209n.onInstallFinish(243);
                                }
                                break;
                            case 102:
                                TbsLog.m665i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
                                int iM449k = C0419m.m393a().m449k(TbsDownloader.f293c);
                                TbsLog.m665i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] localTbsVersion=" + iM449k);
                                TbsDownloader.f297g.m369b(iM449k);
                                TbsLogReport.getInstance(TbsDownloader.f293c).dailyReport();
                                break;
                            case 103:
                                TbsLog.m665i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
                                if (message.arg1 == 0) {
                                    C0419m.m393a().m429a((Context) message.obj, true);
                                }
                                break;
                        }
                    }
                };
            } catch (Exception e) {
                f300j = true;
                TbsLog.m662e(LOGTAG, "TbsApkDownloader init has Exception, " + Log.getStackTraceString(e));
            }
        }
    }

    @TargetApi(11)
    /* JADX INFO: renamed from: c */
    public static void m193c(Context context) {
        TbsDownloadConfig.getInstance(context).clear();
        TbsLogReport.getInstance(context).clear();
        C0417k.m351b(context);
        int i = Build.VERSION.SDK_INT;
        (i >= 11 ? context.getSharedPreferences("tbs_extension_config", 4) : context.getSharedPreferences("tbs_extension_config", 0)).edit().clear().commit();
        (i >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit().clear().commit();
    }

    /* JADX INFO: renamed from: d */
    private static boolean m194d() {
        try {
            return TbsDownloadConfig.getInstance(f293c).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION, BuildConfig.FLAVOR).equals(m195e().toString());
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: e */
    private static JSONArray m195e() {
        if (!TbsShareManager.isThirdPartyApp(f293c)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        int tbsVersion = QbSdk.getTbsVersion(f293c);
        if (tbsVersion > 0) {
            jSONArray.put(tbsVersion);
        }
        return jSONArray;
    }

    /* JADX INFO: renamed from: f */
    private static boolean m196f() {
        int i;
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f293c);
        if (tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, 0) >= tbsDownloadConfig.getDownloadSuccessMaxRetrytimes()) {
            TbsLog.m667i(LOGTAG, "[TbsDownloader.needStartDownload] out of success retrytimes", true);
            i = -115;
        } else if (tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, 0) >= tbsDownloadConfig.getDownloadFailedMaxRetrytimes()) {
            TbsLog.m667i(LOGTAG, "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
            i = -116;
        } else {
            if (FileUtil.m646b(f293c)) {
                if (System.currentTimeMillis() - tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_STARTTIME, 0L) <= 86400000) {
                    long j = tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, 0L);
                    TbsLog.m665i(LOGTAG, "[TbsDownloader.needStartDownload] downloadFlow=" + j);
                    if (j >= tbsDownloadConfig.getDownloadMaxflow()) {
                        TbsLog.m667i(LOGTAG, "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
                        i = -120;
                    }
                }
                return true;
            }
            TbsLog.m667i(LOGTAG, "[TbsDownloader.needStartDownload] local rom freespace limit", true);
            i = -117;
        }
        tbsDownloadConfig.setDownloadInterruptCode(i);
        return false;
    }

    /* JADX INFO: renamed from: g */
    private static void m197g() {
        File fileM411o = C0419m.m411o(f293c);
        if (fileM411o == null) {
            return;
        }
        File[] fileArrListFiles = fileM411o.listFiles();
        Pattern patternCompile = Pattern.compile("tbs_switch_disable_(.*)");
        for (File file : fileArrListFiles) {
            if (patternCompile.matcher(file.getName()).find() && file.isFile() && file.exists() && file.canRead()) {
                TbsLog.m665i(LOGTAG, "clearTbsCoreDisableFlagFiles: " + file.getName() + "; res: " + file.delete());
            }
        }
    }

    public static String getBackupFileName(boolean z) {
        return getBackupFileName(z, 0);
    }

    public static String getBackupFileName(boolean z, int i) {
        boolean zM703c;
        if (i == 64) {
            zM703c = true;
        } else {
            zM703c = i == 32 ? false : C0445b.m703c();
        }
        if (z) {
            return zM703c ? "x5.tbs.decouple.64" : "x5.tbs.decouple";
        }
        return zM703c ? "x5.tbs.org.64" : "x5.tbs.org";
    }

    public static int getCoreShareDecoupleCoreVersion() {
        return C0419m.m393a().m444f(f293c);
    }

    public static int getCoreShareDecoupleCoreVersionByContext(Context context) {
        return C0419m.m393a().m444f(context);
    }

    public static int getNextPostInterval(Context context) {
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
        long j = tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK, 0L);
        return Math.max((int) (((tbsDownloadConfig.getRetryInterval() * 1000) - (System.currentTimeMillis() - j)) / 1000), 0);
    }

    public static synchronized boolean getOverSea(Context context) {
        if (!f304n) {
            f304n = true;
            TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
            if (tbsDownloadConfig.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA)) {
                f303m = tbsDownloadConfig.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA, false);
                TbsLog.m665i(LOGTAG, "[TbsDownloader.getOverSea]  first called. sOverSea = " + f303m);
            }
            TbsLog.m665i(LOGTAG, "[TbsDownloader.getOverSea]  sOverSea = " + f303m);
        }
        return f303m;
    }

    public static long getRetryIntervalInSeconds() {
        return f311u;
    }

    public static HandlerThread getsTbsHandlerThread() {
        return f298h;
    }

    /* JADX INFO: renamed from: h */
    private static void m198h() {
        File file = new File(C0419m.m411o(f293c), "switch_disable_check");
        if (file.exists()) {
            return;
        }
        try {
            TbsLog.m665i(LOGTAG, "addSwitchDisableCheckFlag status: " + file.createNewFile());
        } catch (IOException e) {
            TbsLog.m665i(LOGTAG, BuildConfig.FLAVOR + e);
        }
    }

    /* JADX INFO: renamed from: i */
    private static void m199i() {
        Handler handler = f294d;
        if (handler != null) {
            handler.obtainMessage(110).sendToTarget();
        }
    }

    public static boolean isDownloadForeground() {
        C0417k c0417k = f297g;
        return c0417k != null && c0417k.m371c();
    }

    public static synchronized boolean isDownloading() {
        TbsLog.m665i(LOGTAG, "[TbsDownloader.isDownloading] is " + f291a);
        return f291a;
    }

    public static boolean isTbsCoreDisabledBySwitch(Context context, int i) {
        return new File(C0419m.m411o(context), "tbs_switch_disable_" + i).exists();
    }

    public static boolean needDownload(Context context, boolean z) {
        return needDownload(context, z, false, true, null);
    }

    public static boolean needDownload(Context context, boolean z, boolean z2, TbsDownloaderCallback tbsDownloaderCallback) {
        return needDownload(context, z, z2, true, tbsDownloaderCallback);
    }

    public static boolean needDownload(Context context, boolean z, boolean z2, boolean z3, TbsDownloaderCallback tbsDownloaderCallback) {
        int i;
        TbsShareManager.mHasQueried = true;
        Context applicationContext = context.getApplicationContext();
        f293c = applicationContext;
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(applicationContext);
        tbsDownloadConfig.setDownloadInterruptCode(-100);
        TbsLog.initIfNeed(context);
        TbsLog.m665i(LOGTAG, "needDownload,process=" + QbSdk.getCurrentProcessName(context) + "stack=" + Log.getStackTraceString(new Throwable()));
        C0419m.m393a().m435b(context, C0412f.f512a == 0);
        int iM431b = C0419m.m393a().m431b(context);
        TbsLog.m665i(LOGTAG, "[TbsDownloader.needDownload],renameRet=" + iM431b);
        if (iM431b != 0) {
            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
            tbsLogInfo.f332a = 129;
            tbsLogInfo.setFailDetail("code=2" + iM431b);
        }
        if (iM431b < 0) {
            TbsLog.m665i(LOGTAG, "[TbsDownloader.needDownload],needReNameFile=" + iM431b);
            tbsDownloadConfig.setDownloadInterruptCode(-128);
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            return false;
        }
        TbsLog.m665i(LOGTAG, "[TbsDownloader.needDownload] oversea=" + z + ",isDownloadForeground=" + z2);
        if (C0419m.f579a) {
            TbsLog.m665i(LOGTAG, "[TbsDownloader.needDownload]#1 Static Installing, return false");
            tbsDownloadConfig.setDownloadInterruptCode(-130);
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            return false;
        }
        if (!m185a(f293c, z)) {
            TbsLog.m665i(LOGTAG, "[TbsDownloader.needDownload]#2 Not shouldDoNeedDownload, return false");
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            return false;
        }
        m192c();
        if (f300j) {
            tbsDownloadConfig.setDownloadInterruptCode(-105);
            TbsLog.m665i(LOGTAG, "[TbsDownloader.needDownload]#3 TbsApkDownloader init Exception, return false");
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            return false;
        }
        boolean zM186a = m186a(f293c, z2, false);
        TbsLog.m665i(LOGTAG, "[TbsDownloader.needDownload],needSendRequest=" + zM186a);
        if (zM186a) {
            m182a(z2, tbsDownloaderCallback, z3);
            i = -114;
        } else {
            i = TbsCommonCode.DOWNLOAD_NO_NEED_REQUEST;
        }
        tbsDownloadConfig.setDownloadInterruptCode(i);
        f294d.removeMessages(102);
        Message.obtain(f294d, 102).sendToTarget();
        boolean zContains = tbsDownloadConfig.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD);
        TbsLog.m665i(LOGTAG, "[TbsDownloader.needDownload] hasNeedDownloadKey=" + zContains);
        boolean z4 = (zContains || TbsShareManager.isThirdPartyApp(context)) ? tbsDownloadConfig.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false) : true;
        TbsLog.m665i(LOGTAG, "[TbsDownloader.needDownload]#4,needDownload=" + z4 + ",hasNeedDownloadKey=" + zContains);
        if (!z4) {
            int iM449k = C0419m.m393a().m449k(f293c);
            TbsLog.m665i(LOGTAG, "[TbsDownloader.needDownload]#7,tbsLocalVersion=" + iM449k + ",needSendRequest=" + zM186a);
            if (zM186a || iM449k <= 0) {
                f294d.removeMessages(103);
                if (iM449k <= 0 && !zM186a) {
                    Message.obtain(f294d, 103, 0, 0, f293c).sendToTarget();
                }
            }
        } else if (m196f()) {
            TbsLog.m665i(LOGTAG, "[TbsDownloader.needDownload] NEEDDOWNLOAD_WILL_STARTDOWNLOAD");
        } else {
            TbsLog.m665i(LOGTAG, "[TbsDownloader.needDownload]#5,set needDownload = false");
            z4 = false;
        }
        if (!zM186a && tbsDownloaderCallback != null) {
            tbsDownloaderCallback.onNeedDownloadFinish(z4, 0);
        }
        m199i();
        return z4;
    }

    public static boolean needDownloadDecoupleCore() {
        int i;
        if (TbsShareManager.isThirdPartyApp(f293c) || m183a(f293c)) {
            return false;
        }
        return System.currentTimeMillis() - TbsDownloadConfig.getInstance(f293c).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, 0L) >= TbsDownloadConfig.getInstance(f293c).getRetryInterval() * 1000 && (i = TbsDownloadConfig.getInstance(f293c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0)) > 0 && i != C0419m.m393a().m444f(f293c) && TbsDownloadConfig.getInstance(f293c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) != i;
    }

    public static void pauseDownload() {
        TbsLog.m665i(LOGTAG, "called pauseDownload,downloader=" + f297g);
        C0417k c0417k = f297g;
        if (c0417k != null) {
            c0417k.m372d();
        }
    }

    public static void resumeDownload() {
        TbsLog.m665i(LOGTAG, "called resumeDownload,downloader=" + f297g);
        Handler handler = f294d;
        if (handler != null) {
            handler.removeMessages(109);
            f294d.sendEmptyMessage(109);
        }
    }

    public static void setAppContext(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return;
        }
        f293c = context.getApplicationContext();
    }

    public static void setRetryIntervalInSeconds(Context context, long j) {
        if (context == null) {
            return;
        }
        if (context.getApplicationInfo().packageName.equals("com.tencent.qqlive")) {
            f311u = j;
        }
        TbsLog.m665i(LOGTAG, "mRetryIntervalInSeconds is " + f311u);
    }

    @Deprecated
    public static boolean startDecoupleCoreIfNeeded() {
        return false;
    }

    public static void startDownload(Context context) {
        startDownload(context, false);
    }

    public static synchronized void startDownload(Context context, boolean z) {
        int i = 1;
        if (TbsShareManager.isThirdPartyApp(context)) {
            int i2 = f299i + 1;
            f299i = i2;
            if (i2 > 1) {
                TbsLog.m672w(LOGTAG, "[Warning] for privacy security, TBS Only allow startDownload 1 times each process");
                QbSdk.f209n.onDownloadFinish(127);
                return;
            }
        }
        if (QbSdk.m160d()) {
            TbsLog.m672w(LOGTAG, "[warning] using private CDN mode, default downloader can not startDownload.");
            QbSdk.f209n.onDownloadFinish(135);
            return;
        }
        Context applicationContext = context.getApplicationContext();
        f293c = applicationContext;
        TbsLog.initIfNeed(applicationContext);
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f293c);
        tbsDownloadConfig.setDownloadInterruptCode(-200);
        TbsLog.m665i(LOGTAG, "[TbsDownloader.startDownload] sAppContext=" + f293c);
        if (C0419m.f579a) {
            tbsDownloadConfig.setDownloadInterruptCode(-130);
            QbSdk.f209n.onDownloadFinish(TbsListener.ErrorCode.NEEDDOWNLOAD_STATIC_INSTALLING);
            return;
        }
        C0419m.m393a().m435b(context, C0412f.f512a == 0);
        int iM431b = C0419m.m393a().m431b(context);
        TbsLog.m665i(LOGTAG, "[TbsDownloader.needDownload],renameRet=" + iM431b);
        if (iM431b < 0) {
            tbsDownloadConfig.setDownloadInterruptCode(-128);
            QbSdk.f209n.onDownloadFinish(TbsListener.ErrorCode.NEEDDOWNLOAD_TMPCORE_PREPARING);
            TbsLog.m665i(LOGTAG, "[TbsDownloader.needDownload],needReNameFile=" + iM431b);
            return;
        }
        f291a = true;
        if (Build.VERSION.SDK_INT < 8) {
            tbsDownloadConfig.setDownloadInterruptCode(Core.StsBadSize);
            QbSdk.f209n.onDownloadFinish(TbsListener.ErrorCode.STARTDOWNLOAD_API_LEVEL_BELOW_FROYO);
            return;
        }
        m192c();
        if (f300j) {
            tbsDownloadConfig.setDownloadInterruptCode(Core.StsDivByZero);
            QbSdk.f209n.onDownloadFinish(121);
            return;
        }
        if (z) {
            stopDownload();
        }
        f294d.removeMessages(101);
        f294d.removeMessages(100);
        Message messageObtain = Message.obtain(f294d, 101, QbSdk.f209n);
        if (!z) {
            i = 0;
        }
        messageObtain.arg1 = i;
        messageObtain.sendToTarget();
    }

    public static void stopDownload() {
        if (f300j) {
            return;
        }
        TbsLog.m665i(LOGTAG, "[TbsDownloader.stopDownload]");
        C0417k c0417k = f297g;
        if (c0417k != null) {
            c0417k.m365a();
        }
        Handler handler = f294d;
        if (handler != null) {
            handler.removeMessages(100);
            f294d.removeMessages(101);
            f294d.removeMessages(108);
        }
    }
}
