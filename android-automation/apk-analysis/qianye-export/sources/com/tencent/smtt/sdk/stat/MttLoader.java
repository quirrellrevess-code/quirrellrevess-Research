package com.tencent.smtt.sdk.stat;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.flexbox.BuildConfig;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes.dex */
public class MttLoader {
    public static final String CHANNEL_ID = "ChannelID";
    public static final String ENTRY_ID = "entryId";

    @Deprecated
    public static final String KEY_ACTIVITY_NAME = "KEY_ACT";

    @Deprecated
    public static final String KEY_APP_NAME = "KEY_APPNAME";
    public static final String KEY_EUSESTAT = "KEY_EUSESTAT";

    @Deprecated
    public static final String KEY_PACKAGE = "KEY_PKG";
    public static final String KEY_PID = "KEY_PID";
    public static final String MTT_ACTION = "com.tencent.QQBrowser.action.VIEW";
    public static final String MTT_ACTION_SP = "com.tencent.QQBrowser.action.VIEWSP";
    public static final String PID_ARTICLE_NEWS = "21272";
    public static final String PID_MOBILE_QQ = "50079";
    public static final String PID_QQPIM = "50190";
    public static final String PID_QZONE = "10494";
    public static final String PID_WECHAT = "10318";
    public static final String POS_ID = "PosID";
    public static final String QQBROWSER_DIRECT_DOWNLOAD_URL = "https://mdc.html5.qq.com/d/directdown.jsp?channel_id=50079";
    public static final String QQBROWSER_DOWNLOAD_URL = "https://mdc.html5.qq.com/mh?channel_id=50079&u=";
    public static final String QQBROWSER_PARAMS_FROME = ",from=";
    public static final String QQBROWSER_PARAMS_PACKAGENAME = ",packagename=";
    public static final String QQBROWSER_PARAMS_PD = ",product=";
    public static final String QQBROWSER_PARAMS_VERSION = ",version=";
    public static final String QQBROWSER_SCHEME = "mttbrowser://url=";
    public static final int RESULT_INVALID_CONTEXT = 3;
    public static final int RESULT_INVALID_URL = 2;
    public static final int RESULT_NOT_INSTALL_QQBROWSER = 4;
    public static final int RESULT_OK = 0;
    public static final int RESULT_QQBROWSER_LOW = 5;
    public static final int RESULT_UNKNOWN = 1;
    public static final String STAT_KEY = "StatKey";

    public static class BrowserInfo {
        public int browserType = -1;
        public int ver = -1;
        public String quahead = BuildConfig.FLAVOR;

        /* JADX INFO: renamed from: vn */
        public String f623vn = "0";
        public String packageName = null;
    }

    /* JADX INFO: renamed from: com.tencent.smtt.sdk.stat.MttLoader$a */
    public static class C0427a {

        /* JADX INFO: renamed from: a */
        public String f624a;

        /* JADX INFO: renamed from: b */
        public String f625b;

        private C0427a() {
            this.f624a = BuildConfig.FLAVOR;
            this.f625b = BuildConfig.FLAVOR;
        }
    }

    /* JADX INFO: renamed from: a */
    private static int m499a(Context context) {
        String str = context.getApplicationInfo().processName;
        if (str.equals(TbsConfig.APP_QQ)) {
            return 13;
        }
        if (str.equals(TbsConfig.APP_QZONE)) {
            return 14;
        }
        if (str.equals("com.tencent.WBlog")) {
            return 15;
        }
        return str.equals(TbsConfig.APP_WX) ? 24 : 26;
    }

    /* JADX INFO: renamed from: a */
    private static Uri m500a(Context context, String str) {
        return Uri.fromFile(new File(str));
    }

    /* JADX INFO: renamed from: a */
    private static C0427a m501a(Context context, Uri uri) {
        Intent intent = new Intent(MTT_ACTION);
        intent.setData(uri);
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (listQueryIntentActivities.size() <= 0) {
            return null;
        }
        C0427a c0427a = new C0427a();
        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
            String str = resolveInfo.activityInfo.packageName;
            if (str.contains(TbsConfig.APP_QB)) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                c0427a.f624a = activityInfo.name;
                c0427a.f625b = activityInfo.packageName;
                return c0427a;
            }
            if (str.contains("com.tencent.qbx")) {
                ActivityInfo activityInfo2 = resolveInfo.activityInfo;
                c0427a.f624a = activityInfo2.name;
                c0427a.f625b = activityInfo2.packageName;
            }
        }
        return c0427a;
    }

    /* JADX INFO: renamed from: a */
    private static String m502a(Certificate certificate) throws CertificateEncodingException {
        byte[] encoded = certificate.getEncoded();
        int length = encoded.length;
        char[] cArr = new char[length * 2];
        for (int i = 0; i < length; i++) {
            byte b = encoded[i];
            int i2 = (b >> 4) & 15;
            int i3 = i * 2;
            cArr[i3] = (char) (i2 >= 10 ? (i2 + 97) - 10 : i2 + 48);
            int i4 = b & 15;
            cArr[i3 + 1] = (char) (i4 >= 10 ? (i4 + 97) - 10 : i4 + 48);
        }
        return new String(cArr);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m503a(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        String strTrim = str.trim();
        int iIndexOf = strTrim.toLowerCase().indexOf("://");
        int iIndexOf2 = strTrim.toLowerCase().indexOf(46);
        if (iIndexOf <= 0 || iIndexOf2 <= 0 || iIndexOf <= iIndexOf2) {
            return strTrim.toLowerCase().contains("://");
        }
        return false;
    }

    public static BrowserInfo getBrowserInfo(Context context) {
        boolean z = context.getApplicationContext().getSharedPreferences("x5_proxy_setting", 0).getBoolean("qb_install_status", false);
        BrowserInfo browserInfo = new BrowserInfo();
        if (z) {
            return browserInfo;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = null;
            try {
                packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
                browserInfo.browserType = 2;
                browserInfo.packageName = TbsConfig.APP_QB;
                browserInfo.quahead = "ADRQB_";
                if (packageInfo != null && packageInfo.versionCode > 420000) {
                    browserInfo.ver = packageInfo.versionCode;
                    browserInfo.quahead += packageInfo.versionName.replaceAll("\\.", BuildConfig.FLAVOR);
                    browserInfo.f623vn = packageInfo.versionName.replaceAll("\\.", BuildConfig.FLAVOR);
                    return browserInfo;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            try {
                try {
                    try {
                        try {
                            try {
                                packageInfo = packageManager.getPackageInfo("com.tencent.qbx", 0);
                                browserInfo.browserType = 0;
                                browserInfo.packageName = "com.tencent.qbx";
                                browserInfo.quahead = "ADRQBX_";
                            } catch (PackageManager.NameNotFoundException unused2) {
                                packageInfo = packageManager.getPackageInfo("com.tencent.mtt.x86", 0);
                                browserInfo.packageName = "com.tencent.mtt.x86";
                                browserInfo.browserType = 2;
                                browserInfo.quahead = "ADRQB_";
                            }
                        } catch (PackageManager.NameNotFoundException unused3) {
                            packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
                            browserInfo.packageName = TbsConfig.APP_QB;
                            browserInfo.browserType = 2;
                            browserInfo.quahead = "ADRQB_";
                        }
                    } catch (Exception unused4) {
                        C0427a c0427aM501a = m501a(context, Uri.parse(QQBROWSER_DOWNLOAD_URL));
                        if (c0427aM501a != null && !TextUtils.isEmpty(c0427aM501a.f625b)) {
                            PackageInfo packageInfo2 = packageManager.getPackageInfo(c0427aM501a.f625b, 0);
                            try {
                                browserInfo.packageName = c0427aM501a.f625b;
                                browserInfo.browserType = 2;
                                browserInfo.quahead = "ADRQB_";
                            } catch (Exception unused5) {
                            }
                            packageInfo = packageInfo2;
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused6) {
                    packageInfo = packageManager.getPackageInfo("com.tencent.qbx5", 0);
                    browserInfo.browserType = 1;
                    browserInfo.packageName = "com.tencent.qbx5";
                    browserInfo.quahead = "ADRQBX5_";
                }
            } catch (Exception unused7) {
            }
            if (packageInfo != null) {
                browserInfo.ver = packageInfo.versionCode;
                browserInfo.quahead += packageInfo.versionName.replaceAll("\\.", BuildConfig.FLAVOR);
                browserInfo.f623vn = packageInfo.versionName.replaceAll("\\.", BuildConfig.FLAVOR);
            }
        } catch (Exception unused8) {
        }
        return browserInfo;
    }

    public static String getDownloadUrlWithQb(String str) {
        try {
            return QQBROWSER_DOWNLOAD_URL + URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return QQBROWSER_DOWNLOAD_URL;
        }
    }

    public static String getValidQBUrl(Context context, String str) {
        if (str.toLowerCase().startsWith("qb://")) {
            boolean z = false;
            BrowserInfo browserInfo = getBrowserInfo(context);
            int i = browserInfo.browserType;
            if (i == -1 || (i == 2 && browserInfo.ver < 33)) {
                z = true;
            }
            if (z) {
                return getDownloadUrlWithQb(str);
            }
        }
        return str;
    }

    public static boolean isBrowserInstalled(Context context) {
        return getBrowserInfo(context).browserType != -1;
    }

    public static boolean isBrowserInstalledEx(Context context) {
        BrowserInfo browserInfo = getBrowserInfo(context);
        boolean z = false;
        try {
            if (Long.valueOf(browserInfo.f623vn).longValue() >= 6001500) {
                z = true;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (browserInfo.ver >= 601500) {
            return true;
        }
        return z;
    }

    public static boolean isGreatBrowserVer(Context context, long j, long j2) {
        BrowserInfo browserInfo = getBrowserInfo(context);
        boolean z = false;
        try {
            if (Long.valueOf(browserInfo.f623vn).longValue() >= j) {
                z = true;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (browserInfo.ver >= j2) {
            return true;
        }
        return z;
    }

    public static boolean isSupportQBScheme(Context context) {
        BrowserInfo browserInfo = getBrowserInfo(context);
        int i = browserInfo.browserType;
        if (i == -1) {
            return false;
        }
        return i != 2 || browserInfo.ver >= 42;
    }

    public static boolean isSupportingTbsTips(Context context) {
        BrowserInfo browserInfo = getBrowserInfo(context);
        return browserInfo.browserType == 2 && browserInfo.ver >= 580000;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0072, code lost:
    
        if (android.text.TextUtils.isEmpty(r0.f624a) == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0074, code lost:
    
        r1 = r0.f625b;
        r0 = r0.f624a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b4, code lost:
    
        if (android.text.TextUtils.isEmpty(r0.f624a) == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00c8, code lost:
    
        if (android.text.TextUtils.isEmpty(r0.f624a) == false) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int loadUrl(android.content.Context r7, java.lang.String r8, java.util.HashMap<java.lang.String, java.lang.String> r9, com.tencent.smtt.sdk.WebView r10) {
        /*
            Method dump skipped, instruction units count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.stat.MttLoader.loadUrl(android.content.Context, java.lang.String, java.util.HashMap, com.tencent.smtt.sdk.WebView):int");
    }

    public static int loadUrl(Context context, String str, HashMap<String, String> map, String str2, WebView webView) {
        boolean z;
        PackageInfo packageInfo;
        StringBuilder sb = new StringBuilder();
        boolean z2 = false;
        try {
            PackageManager packageManager = context.getPackageManager();
            z = (packageManager == null || (packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0)) == null || packageInfo.versionCode <= 601000) ? false : true;
        } catch (Throwable unused) {
        }
        try {
            String strEncode = URLEncoder.encode(str, "UTF-8");
            if (z) {
                str = strEncode;
            }
            z2 = z;
        } catch (Exception unused2) {
        }
        String str3 = z2 ? ",encoded=1" : BuildConfig.FLAVOR;
        sb.append(QQBROWSER_SCHEME);
        sb.append(str);
        sb.append(QQBROWSER_PARAMS_PD);
        sb.append("TBS");
        sb.append(QQBROWSER_PARAMS_PACKAGENAME);
        sb.append(context.getPackageName());
        sb.append(QQBROWSER_PARAMS_FROME);
        sb.append(str2);
        sb.append(QQBROWSER_PARAMS_VERSION);
        sb.append(TbsConfig.TBS_SDK_VERSIONNAME);
        sb.append(str3);
        return loadUrl(context, sb.toString(), map, webView);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x007c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x007d A[Catch: Exception -> 0x00a9, TryCatch #0 {Exception -> 0x00a9, blocks: (B:3:0x0001, B:5:0x000a, B:7:0x0010, B:8:0x0014, B:10:0x001a, B:12:0x002c, B:13:0x0030, B:15:0x0046, B:19:0x0050, B:22:0x0059, B:24:0x0060, B:26:0x006a, B:28:0x006e, B:29:0x0071, B:32:0x007d, B:34:0x00a0, B:35:0x00a5), top: B:40:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00a0 A[Catch: Exception -> 0x00a9, TryCatch #0 {Exception -> 0x00a9, blocks: (B:3:0x0001, B:5:0x000a, B:7:0x0010, B:8:0x0014, B:10:0x001a, B:12:0x002c, B:13:0x0030, B:15:0x0046, B:19:0x0050, B:22:0x0059, B:24:0x0060, B:26:0x006a, B:28:0x006e, B:29:0x0071, B:32:0x007d, B:34:0x00a0, B:35:0x00a5), top: B:40:0x0001 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:32:0x007d, please report this as an issue */
    public static boolean openDocWithQb(Context context, String str, int i, String str2, String str3, HashMap<String, String> map, Bundle bundle) {
        Uri uriM500a;
        String str4;
        Set<String> setKeySet;
        try {
            Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
            if (map != null && (setKeySet = map.keySet()) != null) {
                for (String str5 : setKeySet) {
                    String str6 = map.get(str5);
                    if (!TextUtils.isEmpty(str6)) {
                        intent.putExtra(str5, str6);
                    }
                }
            }
            new File(str);
            intent.putExtra("key_reader_sdk_id", 3);
            intent.putExtra("key_reader_sdk_type", i);
            if (!TextUtils.isEmpty(str3)) {
                intent.putExtra("big_brother_source_key", str3);
            }
            if (i != 0) {
                str4 = i == 1 ? "key_reader_sdk_url" : "key_reader_sdk_path";
                intent.putExtra("key_reader_sdk_format", str2);
                if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && Build.VERSION.SDK_INT >= 24) {
                    intent.addFlags(1);
                }
                intent.addFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
                uriM500a = m500a(context, str);
                if (uriM500a == null) {
                    return false;
                }
                intent.setDataAndType(uriM500a, "mtt/" + str2);
                intent.putExtra("loginType", m499a(context.getApplicationContext()));
                if (bundle != null) {
                    intent.putExtra("key_reader_sdk_extrals", bundle);
                }
                context.startActivity(intent);
                return true;
            }
            intent.putExtra(str4, str);
            intent.putExtra("key_reader_sdk_format", str2);
            if (context != null) {
                intent.addFlags(1);
            }
            intent.addFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
            uriM500a = m500a(context, str);
            if (uriM500a == null) {
                return false;
            }
            intent.setDataAndType(uriM500a, "mtt/" + str2);
            intent.putExtra("loginType", m499a(context.getApplicationContext()));
            if (bundle != null) {
                intent.putExtra("key_reader_sdk_extrals", bundle);
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean openDocWithQb(Context context, String str, int i, String str2, HashMap<String, String> map) {
        return openDocWithQb(context, str, i, str2, map, null);
    }

    public static boolean openDocWithQb(Context context, String str, int i, String str2, HashMap<String, String> map, Bundle bundle) {
        return openDocWithQb(context, str, i, str2, BuildConfig.FLAVOR, map, null);
    }

    public static boolean openVideoWithQb(Context context, String str, HashMap<String, String> map) {
        boolean z;
        Set<String> setKeySet;
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
        intent.setDataAndType(uri, "video/*");
        if (map != null && (setKeySet = map.keySet()) != null) {
            for (String str2 : setKeySet) {
                String str3 = map.get(str2);
                if (!TextUtils.isEmpty(str3)) {
                    intent.putExtra(str2, str3);
                }
            }
        }
        try {
            intent.putExtra("loginType", m499a(context));
            intent.setComponent(new ComponentName(TbsConfig.APP_QB, "com.tencent.mtt.browser.video.H5VideoThrdcallActivity"));
            context.startActivity(intent);
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        if (!z) {
            try {
                intent.setComponent(null);
                context.startActivity(intent);
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public static boolean verifySignature(File file) {
        JarFile jarFile;
        InputStream inputStream = null;
        try {
            jarFile = new JarFile(file);
            try {
                JarEntry jarEntry = jarFile.getJarEntry("AndroidManifest.xml");
                if (jarEntry == null) {
                    try {
                        jarFile.close();
                    } catch (IOException unused) {
                    }
                    return false;
                }
                byte[] bArr = new byte[8192];
                inputStream = jarFile.getInputStream(jarEntry);
                while (inputStream.read(bArr, 0, 8192) != -1) {
                }
                inputStream.close();
                Certificate[] certificates = jarEntry.getCertificates();
                if (certificates.length < 1) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    try {
                        jarFile.close();
                    } catch (IOException unused3) {
                    }
                    return false;
                }
                String strM502a = m502a(certificates[0]);
                if (strM502a != null && strM502a.equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    try {
                        jarFile.close();
                    } catch (IOException unused5) {
                    }
                    return true;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused6) {
                    }
                }
            } catch (Throwable unused7) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused8) {
                    }
                }
                if (jarFile != null) {
                }
                return false;
            }
        } catch (Throwable unused9) {
            jarFile = null;
        }
        try {
            jarFile.close();
        } catch (IOException unused10) {
        }
        return false;
    }
}
