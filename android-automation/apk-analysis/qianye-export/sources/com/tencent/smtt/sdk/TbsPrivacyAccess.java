package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.utils.C0462s;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public enum TbsPrivacyAccess {
    DeviceId(false),
    Imsi(false),
    AndroidId(false),
    MacAddress(false),
    AndroidVersion(true),
    DeviceModel(true),
    AppList(true);


    /* JADX INFO: renamed from: a */
    @Deprecated
    private static boolean f354a = true;

    /* JADX INFO: renamed from: c */
    private static boolean f355c = false;

    /* JADX INFO: renamed from: d */
    private static String[] f356d = null;

    /* JADX INFO: renamed from: b */
    private boolean f358b;

    public enum ConfigurablePrivacy {
        IMSI("imsi"),
        ANDROID_ID("android_id"),
        MAC("mac"),
        ANDROID_VERSION("android_version"),
        DEVICE_MODEL("device_model"),
        APP_LIST("app_list"),
        QIMEI36("q36"),
        MODEL("model"),
        OAID("oaid"),
        SERIAL("serial"),
        ACTION("action"),
        QB_INSTALLED("qb_installed");


        /* JADX INFO: renamed from: a */
        public String f360a;

        ConfigurablePrivacy(String str) {
            this.f360a = str;
        }
    }

    TbsPrivacyAccess(boolean z) {
        this.f358b = z;
    }

    /* JADX INFO: renamed from: a */
    private static void m233a(Context context, SharedPreferences.Editor editor, ConfigurablePrivacy configurablePrivacy, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        TbsLog.m665i("TbsPrivacy", "doConfigPrivacy  " + configurablePrivacy.f360a + " is " + str);
        if (!TextUtils.isEmpty(configurablePrivacy.f360a) && configurablePrivacy.f360a.equals("action")) {
            m234a(context, str);
            return;
        }
        editor.putString(configurablePrivacy.f360a, str);
        TbsLog.m665i("TbsPrivacy", "configurePrivacy " + configurablePrivacy.f360a + " is " + str);
    }

    /* JADX INFO: renamed from: a */
    private static void m234a(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str) && FileUtil.m633a(context) && str.equals("deleteQBApk")) {
                String strM623a = FileUtil.m623a(context, 9);
                if (TextUtils.isEmpty(strM623a)) {
                    return;
                }
                File file = new File(strM623a);
                TbsLog.m665i("TbsPrivacy", "doActionByApp QbApkDir is " + file.getAbsolutePath());
                FileUtil.m645b(file);
            }
        } catch (Throwable th) {
            TbsLog.m665i("TbsPrivacy", "doActionByApp stack is " + Log.getStackTraceString(th));
        }
    }

    public static void configureAllPrivacy(Context context, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            if (bundle.containsKey("qimei36")) {
                bundle.putString(ConfigurablePrivacy.QIMEI36.f360a, bundle.getString("qimei36"));
            }
            Iterator<String> it = bundle.keySet().iterator();
            while (it.hasNext()) {
                TbsLog.m665i("TbsPrivacy", "configureAllPrivacy bundle key is " + it.next());
            }
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("uifa", 0).edit();
            for (ConfigurablePrivacy configurablePrivacy : ConfigurablePrivacy.values()) {
                if (bundle.containsKey(configurablePrivacy.f360a)) {
                    m233a(context, editorEdit, configurablePrivacy, bundle.getString(configurablePrivacy.f360a));
                }
            }
            editorEdit.putString("app_call", "done");
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    public static void configureAllPrivacy(Context context, String str) {
        if (str == null) {
            return;
        }
        try {
            String strM823b = C0462s.m823b(context);
            TbsLog.m665i("TbsPrivacy", "configureAllPrivacy state is " + strM823b);
            if (strM823b.contains("app_list")) {
                return;
            }
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("uifa", 0).edit();
            editorEdit.putString("app_list", str);
            editorEdit.putString("app_call", "done");
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    public static void configurePrivacy(Context context, ConfigurablePrivacy configurablePrivacy, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("uifa", 0).edit();
        m233a(context, editorEdit, configurablePrivacy, str);
        editorEdit.commit();
    }

    @Deprecated
    public static void disableSensitiveApi() {
        f354a = false;
        HashMap map = new HashMap();
        map.put(TbsCoreSettings.NO_SENSITIVE_API, Boolean.TRUE);
        QbSdk.initTbsSettings(map);
    }

    public static String getConfigurePrivacy(Context context, ConfigurablePrivacy configurablePrivacy, String str) {
        return context.getSharedPreferences("uifa", 0).getString(configurablePrivacy.f360a, str);
    }

    public static String[] getItemToRmPrivacy() {
        return f356d;
    }

    @Deprecated
    public static boolean isEnableSensitiveApi() {
        return f354a;
    }

    public static void rmPrivacyItemIfNeeded(Context context) {
        try {
            TbsLog.m665i("TbsPrivacy", "mRmPrivacyItemChecked is " + f355c);
            if (f355c) {
                return;
            }
            f355c = true;
            String strM823b = C0462s.m823b(context);
            TbsLog.m665i("TbsPrivacy", "rmPrivacyItemIfNeeded state is " + strM823b);
            if (strM823b.equals("removenone")) {
                f356d = null;
                return;
            }
            f356d = strM823b.split("\\|");
            TbsLog.m665i("TbsPrivacy", "rmPrivacyItemIfNeeded mItemToRmPrivacy is " + f356d);
            SharedPreferences sharedPreferences = context.getSharedPreferences("uifa", 0);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            for (String str : f356d) {
                if (sharedPreferences.contains(str)) {
                    editorEdit.remove(str);
                }
            }
            editorEdit.commit();
        } catch (Throwable th) {
            TbsLog.m665i("TbsPrivacy", "stack is " + Log.getStackTraceString(th));
        }
    }

    public boolean isDisabled() {
        return !this.f358b;
    }

    public boolean isEnabled() {
        return this.f358b;
    }

    public void setEnabled(boolean z) {
        this.f358b = z;
        TbsLog.m665i("TbsPrivacy", name() + " is " + z);
    }
}
