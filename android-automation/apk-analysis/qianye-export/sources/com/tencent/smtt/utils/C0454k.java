package com.tencent.smtt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.StatementImpl;
import com.tencent.smtt.sdk.TbsPrivacyAccess;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

/* JADX INFO: renamed from: com.tencent.smtt.utils.k */
/* JADX INFO: loaded from: classes.dex */
public class C0454k {

    /* JADX INFO: renamed from: a */
    private static SharedPreferences f812a;

    /* JADX INFO: renamed from: b */
    private static SharedPreferences.Editor f813b;

    /* JADX INFO: renamed from: a */
    private static String m766a() {
        return Build.FINGERPRINT + new Random().nextInt(2147483646);
    }

    /* JADX INFO: renamed from: a */
    public static String m767a(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("tsui", 0);
        f812a = sharedPreferences;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("tsui", BuildConfig.FLAVOR);
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        StringBuilder sb = new StringBuilder();
        String strM766a = m766a();
        String strM707g = C0445b.m707g(context);
        String strM773c = m773c(context);
        String strReplace = m771b(context).replace("-", BuildConfig.FLAVOR);
        if (strM766a != null && strM766a.length() > 0) {
            sb.append(strM766a);
            sb.append("|");
        }
        if (strM707g != null && strM707g.length() > 0) {
            sb.append(strM707g);
            sb.append("|");
        }
        if (strM773c != null && strM773c.length() > 0) {
            sb.append(strM773c);
            sb.append("|");
        }
        if (strReplace != null && strReplace.length() > 0) {
            sb.append(strReplace);
        }
        if (sb.length() > 0) {
            String strM768a = m768a(sb.toString());
            if (!TextUtils.isEmpty(strM768a)) {
                m770a(context, "tsui", strM768a);
                return strM768a;
            }
        }
        String strReplace2 = UUID.randomUUID().toString().replace("-", BuildConfig.FLAVOR);
        m770a(context, "tsui", strReplace2);
        return strReplace2;
    }

    /* JADX INFO: renamed from: a */
    public static String m768a(String str) {
        try {
            String strM769a = m769a(m772b(str));
            return strM769a.length() > 0 ? strM769a : BuildConfig.FLAVOR;
        } catch (Exception e) {
            TbsLog.m672w("SDKUID", "encrypt sdkuid failed, origin is " + str + "reason: " + e);
            return BuildConfig.FLAVOR;
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m769a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & StatementImpl.USES_VARIABLES_UNKNOWN);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
        }
        return sb.toString().toUpperCase(Locale.CHINA);
    }

    /* JADX INFO: renamed from: a */
    private static void m770a(Context context, String str, String str2) {
        if (f812a == null) {
            f812a = context.getApplicationContext().getSharedPreferences("tsui", 0);
        }
        SharedPreferences.Editor editorEdit = f812a.edit();
        f813b = editorEdit;
        editorEdit.putString(str, str2);
        f813b.commit();
    }

    /* JADX INFO: renamed from: b */
    private static String m771b(Context context) {
        try {
            String strM821a = C0462s.m821a(context);
            return new UUID((BuildConfig.FLAVOR + new Random().nextInt(2147483646) + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.DEVICE.length() % 10) + (Build.HARDWARE.length() % 10) + (Build.ID.length() % 10) + (strM821a.length() % 10) + (Build.PRODUCT.length() % 10) + (m773c(context).length() % 10)).hashCode(), m773c(context).hashCode()).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return BuildConfig.FLAVOR;
        }
    }

    /* JADX INFO: renamed from: b */
    private static byte[] m772b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
            return messageDigest.digest();
        } catch (Exception unused) {
            return BuildConfig.FLAVOR.getBytes();
        }
    }

    /* JADX INFO: renamed from: c */
    private static String m773c(Context context) {
        try {
            String configurePrivacy = TbsPrivacyAccess.getConfigurePrivacy(context, TbsPrivacyAccess.ConfigurablePrivacy.SERIAL, BuildConfig.FLAVOR);
            if (!TextUtils.isEmpty(configurePrivacy) && !configurePrivacy.contains("unknown")) {
                return configurePrivacy;
            }
            return m766a();
        } catch (Exception unused) {
            return "unknown";
        }
    }
}
