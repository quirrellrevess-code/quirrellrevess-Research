package com.tencent.smtt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.flexbox.BuildConfig;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.TbsPrivacyAccess;

/* JADX INFO: renamed from: com.tencent.smtt.utils.s */
/* JADX INFO: loaded from: classes.dex */
public class C0462s {

    /* JADX INFO: renamed from: a */
    private static String f856a = "";

    /* JADX INFO: renamed from: a */
    public static long m820a() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
    }

    /* JADX INFO: renamed from: a */
    public static String m821a(Context context) {
        if (!TextUtils.isEmpty(f856a)) {
            return f856a;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("sai", 0);
            String string = sharedPreferences.getString("bmo", BuildConfig.FLAVOR);
            f856a = string;
            if (!TextUtils.isEmpty(string)) {
                return f856a;
            }
            TbsPrivacyAccess.ConfigurablePrivacy configurablePrivacy = TbsPrivacyAccess.ConfigurablePrivacy.MODEL;
            f856a = TbsPrivacyAccess.getConfigurePrivacy(context, configurablePrivacy, BuildConfig.FLAVOR);
            TbsLog.m665i("TbsUtils", "getBuildModel from sp is " + f856a);
            if (!TextUtils.isEmpty(f856a)) {
                return f856a;
            }
            if (TextUtils.isEmpty(f856a) && !TbsConfig.APP_QQ.equals(context.getPackageName())) {
                f856a = Build.MODEL;
            }
            TbsLog.m665i("TbsUtils", "getBuildModel is " + f856a);
            if (!TextUtils.isEmpty(f856a)) {
                TbsPrivacyAccess.configurePrivacy(context, configurablePrivacy, f856a);
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString("bmo", f856a);
                editorEdit.commit();
            }
            return f856a;
        } catch (Throwable th) {
            TbsLog.m665i("TbsUtils", "stack is " + Log.getStackTraceString(th));
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m822a(Context context, Bundle bundle) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("sai", 0).edit();
            if (bundle.containsKey(QbSdk.KEY_THIRD_PARTY_TURING)) {
                boolean z = bundle.getBoolean(QbSdk.KEY_THIRD_PARTY_TURING);
                editorEdit.putBoolean("itge", z);
                TbsLog.m662e("TbsUtils", "setEnableForThirdParty key is itge value is " + z);
            }
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    public static String m823b(Context context) {
        return "removenone";
    }
}
