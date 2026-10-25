package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.flexbox.BuildConfig;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.WebView;

/* JADX INFO: renamed from: com.tencent.smtt.utils.l */
/* JADX INFO: loaded from: classes.dex */
public class C0455l {

    /* JADX INFO: renamed from: a */
    private static String f814a = null;

    /* JADX INFO: renamed from: b */
    private static String f815b = "GA";

    /* JADX INFO: renamed from: c */
    private static String f816c = "GE";

    /* JADX INFO: renamed from: d */
    private static String f817d = "9422";

    /* JADX INFO: renamed from: e */
    private static String f818e = "0";

    /* JADX INFO: renamed from: f */
    private static String f819f = "";

    /* JADX INFO: renamed from: g */
    private static boolean f820g = false;

    /* JADX INFO: renamed from: h */
    private static boolean f821h = false;

    /* JADX INFO: renamed from: i */
    private static boolean f822i = false;

    /* JADX INFO: renamed from: a */
    public static String m774a(Context context) {
        return m775a(context, "0");
    }

    /* JADX INFO: renamed from: a */
    public static String m775a(Context context, String str) {
        if (!TextUtils.isEmpty(f814a)) {
            return f814a;
        }
        String strM776a = m776a(context, String.valueOf(WebView.getTbsSDKVersion(context)), str, f815b, f816c, f817d, f818e, f819f, f820g);
        f814a = strM776a;
        return strM776a;
    }

    /* JADX INFO: renamed from: a */
    private static String m776a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z) {
        String str8;
        StringBuilder sb = new StringBuilder();
        String str9 = m779b(context) + "*" + m780c(context);
        try {
            ApplicationInfo applicationInfo = context.getApplicationContext().getApplicationInfo();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
            str8 = applicationInfo.packageName;
            try {
                if (TextUtils.isEmpty(str7)) {
                    str7 = packageInfo.versionName;
                }
            } catch (PackageManager.NameNotFoundException e) {
                e = e;
                e.printStackTrace();
                str7 = BuildConfig.FLAVOR;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e = e2;
            str8 = BuildConfig.FLAVOR;
        }
        String strM777a = m777a(str8);
        String str10 = "PAD";
        if (!"QB".equals(strM777a) ? !m781d(context) : !z) {
            str10 = "PHONE";
        }
        sb.append("QV");
        sb.append("=");
        sb.append("3");
        m778a(sb, "PL", "ADR");
        m778a(sb, "PR", strM777a);
        m778a(sb, "PP", str8);
        m778a(sb, "PPVN", str7);
        if (!TextUtils.isEmpty(str)) {
            m778a(sb, "TBSVC", str);
        }
        m778a(sb, "CO", "SYS");
        if (!TextUtils.isEmpty(str2) && !str2.equals("0")) {
            m778a(sb, "CO", "BK");
        }
        if (!TextUtils.isEmpty(str2)) {
            m778a(sb, "COVC", str2);
        }
        m778a(sb, "PB", str4);
        m778a(sb, "VE", str3);
        m778a(sb, "DE", str10);
        if (TextUtils.isEmpty(str6)) {
            str6 = "0";
        }
        m778a(sb, "CHID", str6);
        m778a(sb, "LCID", str5);
        m778a(sb, "MO", "unknown");
        m778a(sb, "RL", str9);
        String str11 = Build.VERSION.RELEASE;
        try {
            str11 = new String(str11.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(str11)) {
            m778a(sb, "OS", str11);
        }
        m778a(sb, "API", Build.VERSION.SDK_INT + BuildConfig.FLAVOR);
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    private static String m777a(String str) {
        if (TbsConfig.APP_WX.equals(str)) {
            return "WX";
        }
        if (TbsConfig.APP_QQ.equals(str)) {
            return "QQ";
        }
        if (TbsConfig.APP_QZONE.equals(str)) {
            return "QZ";
        }
        return TbsConfig.APP_QB.equals(str) ? "QB" : "TRD";
    }

    /* JADX INFO: renamed from: a */
    private static void m778a(StringBuilder sb, String str, String str2) {
        sb.append("&");
        sb.append(str);
        sb.append("=");
        sb.append(str2);
    }

    /* JADX INFO: renamed from: b */
    private static int m779b(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            return defaultDisplay.getWidth();
        }
        return -1;
    }

    /* JADX INFO: renamed from: c */
    private static int m780c(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            return defaultDisplay.getHeight();
        }
        return -1;
    }

    /* JADX INFO: renamed from: d */
    private static boolean m781d(Context context) {
        if (f821h) {
            return f822i;
        }
        try {
            boolean z = (Math.min(m779b(context), m780c(context)) * 160) / m782e(context) >= 700;
            f822i = z;
            f821h = true;
            return z;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: e */
    private static int m782e(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (defaultDisplay == null) {
            return 160;
        }
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics.densityDpi;
    }
}
