package com.tencent.smtt.sdk.stat;

import IL1Iii.IL1Iii;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.StatementImpl;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.TbsCoreLoadStat;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.sdk.TbsPVConfig;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.smtt.utils.C0445b;
import com.tencent.smtt.utils.C0451h;
import com.tencent.smtt.utils.C0455l;
import com.tencent.smtt.utils.C0458o;
import com.tencent.smtt.utils.TbsLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.tencent.smtt.sdk.stat.b */
/* JADX INFO: loaded from: classes.dex */
public class C0429b {

    /* JADX INFO: renamed from: a */
    public static byte[] f639a;

    /* JADX INFO: renamed from: b */
    private static IL1Iii f640b;

    /* JADX INFO: renamed from: c */
    private static Map<String, String> f641c;

    static {
        try {
            f639a = "65dRa93L".getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m514a(Context context) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("cpuabi", C0445b.m703c() ? "64" : "32");
            } catch (Throwable unused) {
                jSONObject2 = jSONObject;
                jSONObject = jSONObject2;
            }
        } catch (Throwable unused2) {
        }
        return jSONObject == null ? BuildConfig.FLAVOR : jSONObject.toString();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0044 A[Catch: all -> 0x0094, Exception -> 0x0098, LOOP:0: B:17:0x003d->B:19:0x0044, LOOP_END, TryCatch #11 {Exception -> 0x0098, all -> 0x0094, blocks: (B:16:0x003b, B:17:0x003d, B:19:0x0044, B:20:0x005d, B:24:0x0068, B:25:0x0077), top: B:83:0x003b }] */
    /* JADX WARN: Code duplicated, block: B:22:0x0065  */
    /* JADX WARN: Code duplicated, block: B:23:0x0066 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x0068 A[Catch: all -> 0x0094, Exception -> 0x0098, TryCatch #11 {Exception -> 0x0098, all -> 0x0094, blocks: (B:16:0x003b, B:17:0x003d, B:19:0x0044, B:20:0x005d, B:24:0x0068, B:25:0x0077), top: B:83:0x003b }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0077 A[Catch: all -> 0x0094, Exception -> 0x0098, TRY_LEAVE, TryCatch #11 {Exception -> 0x0098, all -> 0x0094, blocks: (B:16:0x003b, B:17:0x003d, B:19:0x0044, B:20:0x005d, B:24:0x0068, B:25:0x0077), top: B:83:0x003b }] */
    /* JADX WARN: Code duplicated, block: B:32:0x008b A[Catch: IOException -> 0x008f, TRY_ENTER, TRY_LEAVE, TryCatch #7 {IOException -> 0x008f, blocks: (B:32:0x008b, B:53:0x00b2), top: B:79:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x005d A[EDGE_INSN: B:84:0x005d->B:20:0x005d BREAK  A[LOOP:0: B:17:0x003d->B:19:0x0044], SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:19:0x0044, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX INFO: renamed from: a */
    private static String m515a(HttpURLConnection httpURLConnection, String str, boolean z) throws Throwable {
        InputStream inputStream;
        InputStream inflaterInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        int i;
        byte[] byteArray;
        String str2 = BuildConfig.FLAVOR;
        ?? r2 = 0;
        r2 = 0;
        r2 = 0;
        r2 = 0;
        r2 = 0;
        try {
            try {
                try {
                    inputStream = httpURLConnection.getInputStream();
                    String contentEncoding = httpURLConnection.getContentEncoding();
                    try {
                        try {
                            try {
                                if (contentEncoding == null || !contentEncoding.equalsIgnoreCase("gzip")) {
                                    if (contentEncoding == null || !contentEncoding.equalsIgnoreCase("deflate")) {
                                        byteArrayOutputStream = new ByteArrayOutputStream();
                                        bArr = new byte[128];
                                        while (true) {
                                            i = inputStream.read(bArr);
                                            if (i != -1) {
                                                break;
                                            }
                                            TbsLog.m665i("HttpUtils", "getResponseFromConnection len is " + i);
                                            byteArrayOutputStream.write(bArr, 0, i);
                                        }
                                        byteArray = byteArrayOutputStream.toByteArray();
                                        if (byteArray.length == 7) {
                                            r2 = byteArray;
                                        } else if (z) {
                                            byte[] bArrM754c = C0451h.m745a().m754c(byteArray);
                                            str2 = new String(bArrM754c);
                                            r2 = bArrM754c;
                                        } else {
                                            str2 = new String(C0451h.m748b(byteArray, str));
                                            r2 = byteArray;
                                        }
                                        byteArrayOutputStream.close();
                                        if (inputStream != null) {
                                            inputStream.close();
                                            r2 = r2;
                                        }
                                    } else {
                                        inflaterInputStream = new InflaterInputStream(inputStream, new Inflater(true));
                                    }
                                    TbsLog.m665i("HttpUtils", "getResponseFromConnection,response=" + str2 + ";isUseRSA=" + z);
                                    return str2;
                                }
                                inflaterInputStream = new GZIPInputStream(inputStream);
                                byteArrayOutputStream.close();
                            } catch (IOException e) {
                                TbsLog.m668i(e);
                            }
                            bArr = new byte[128];
                            while (true) {
                                i = inputStream.read(bArr);
                                if (i != -1) {
                                    break;
                                    break;
                                }
                                TbsLog.m665i("HttpUtils", "getResponseFromConnection len is " + i);
                                byteArrayOutputStream.write(bArr, 0, i);
                            }
                            byteArray = byteArrayOutputStream.toByteArray();
                            if (byteArray.length == 7) {
                                r2 = byteArray;
                            } else if (z) {
                                byte[] bArrM754c2 = C0451h.m745a().m754c(byteArray);
                                str2 = new String(bArrM754c2);
                                r2 = bArrM754c2;
                            } else {
                                str2 = new String(C0451h.m748b(byteArray, str));
                                r2 = byteArray;
                            }
                            if (inputStream != null) {
                                inputStream.close();
                                r2 = r2;
                            }
                        } catch (Exception e2) {
                            r2 = byteArrayOutputStream;
                            e = e2;
                            TbsLog.m668i(e);
                            if (r2 != 0) {
                                try {
                                    r2.close();
                                } catch (IOException e3) {
                                    TbsLog.m668i(e3);
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                                r2 = r2;
                            }
                            TbsLog.m665i("HttpUtils", "getResponseFromConnection,response=" + str2 + ";isUseRSA=" + z);
                            return str2;
                        } catch (Throwable th) {
                            r2 = byteArrayOutputStream;
                            th = th;
                            if (r2 != 0) {
                                try {
                                    r2.close();
                                } catch (IOException e4) {
                                    TbsLog.m668i(e4);
                                }
                            }
                            if (inputStream == null) {
                                throw th;
                            }
                            try {
                                inputStream.close();
                                throw th;
                            } catch (IOException e5) {
                                TbsLog.m668i(e5);
                                throw th;
                            }
                        }
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (Exception e6) {
                        e = e6;
                    }
                    inputStream = inflaterInputStream;
                } catch (Exception e7) {
                    e = e7;
                    inputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                }
                TbsLog.m665i("HttpUtils", "getResponseFromConnection,response=" + str2 + ";isUseRSA=" + z);
                return str2;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e8) {
            TbsLog.m668i(e8);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m516a(IL1Iii iL1Iii, Context context) {
        String strSubstring;
        String strSubstring2;
        StringBuilder sb;
        String str;
        String string;
        String str2;
        C0445b.m700b(context, iL1Iii.f1188lLi1LL);
        iL1Iii.f1182Ll1 = C0445b.m688a();
        if (Build.VERSION.SDK_INT < 8) {
            return;
        }
        JSONObject jSONObjectM523b = null;
        if (f639a == null) {
            try {
                f639a = "65dRa93L".getBytes("utf-8");
            } catch (UnsupportedEncodingException unused) {
                f639a = null;
                TbsLog.m662e("sdkreport", "Post failed -- get POST_DATA_KEY failed!");
            }
        }
        if (f639a == null) {
            string = "Post failed -- POST_DATA_KEY is null!";
        } else {
            String string2 = TbsDownloadConfig.getInstance(context).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_DESkEY_TOKEN, BuildConfig.FLAVOR);
            if (TextUtils.isEmpty(string2)) {
                strSubstring = BuildConfig.FLAVOR;
                strSubstring2 = strSubstring;
            } else {
                strSubstring2 = string2.substring(0, string2.indexOf("&"));
                strSubstring = string2.substring(string2.indexOf("&") + 1, string2.length());
            }
            boolean z = TextUtils.isEmpty(strSubstring2) || strSubstring2.length() != 96 || TextUtils.isEmpty(strSubstring) || strSubstring.length() != 24;
            try {
                C0458o c0458oM793a = C0458o.m793a();
                if (z) {
                    str2 = c0458oM793a.m797b() + C0451h.m745a().m753b();
                } else {
                    str2 = c0458oM793a.m800e() + strSubstring2;
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(20000);
                if (Build.VERSION.SDK_INT > 13) {
                    httpURLConnection.setRequestProperty("Connection", "close");
                }
                try {
                    jSONObjectM523b = m523b(iL1Iii, context);
                } catch (Exception e) {
                    TbsLog.m668i(e);
                }
                if (jSONObjectM523b != null) {
                    try {
                        TbsLog.m665i("sdkreport", "Post jsonData.toString() is " + jSONObjectM523b.toString());
                        byte[] bytes = jSONObjectM523b.toString().getBytes("utf-8");
                        byte[] bArrM752a = z ? C0451h.m745a().m752a(bytes) : C0451h.m746a(bytes, strSubstring);
                        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bArrM752a.length));
                        try {
                            OutputStream outputStream = httpURLConnection.getOutputStream();
                            outputStream.write(bArrM752a);
                            outputStream.flush();
                            if (httpURLConnection.getResponseCode() == 200) {
                                TbsLog.m665i("SDKPVReport", "Post successful!");
                                m518a(context, m515a(httpURLConnection, strSubstring, z));
                            } else {
                                TbsLog.m662e("SDKPVReport", "Post failed -- not 200 code is " + httpURLConnection.getResponseCode());
                                TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
                                tbsLogInfo.setErrorCode(126);
                                tbsLogInfo.setFailDetail(BuildConfig.FLAVOR + httpURLConnection.getResponseCode());
                                TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_PV_UPLOAD_STAT, tbsLogInfo);
                            }
                            return;
                        } catch (Throwable th) {
                            TbsLog.m662e("SDKPVReport", "Post failed -- exceptions:" + th.getMessage());
                            TbsLogReport.TbsLogInfo tbsLogInfo2 = TbsLogReport.getInstance(context).tbsLogInfo();
                            tbsLogInfo2.setErrorCode(126);
                            tbsLogInfo2.setFailDetail(th);
                            TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_PV_UPLOAD_STAT, tbsLogInfo2);
                            return;
                        }
                    } catch (Throwable unused2) {
                        return;
                    }
                }
                string = "post -- jsonData is null!";
            } catch (IOException e2) {
                e = e2;
                sb = new StringBuilder();
                str = "Post failed -- IOException:";
                sb.append(str);
                sb.append(e);
                string = sb.toString();
            } catch (AssertionError e3) {
                e = e3;
                sb = new StringBuilder();
                str = "Post failed -- AssertionError:";
                sb.append(str);
                sb.append(e);
                string = sb.toString();
            } catch (Exception e4) {
                e = e4;
                sb = new StringBuilder();
                str = "Post failed -- Exception:";
                sb.append(str);
                sb.append(e);
                string = sb.toString();
            } catch (NoClassDefFoundError e5) {
                e = e5;
                sb = new StringBuilder();
                str = "Post failed -- NoClassDefFoundError:";
                sb.append(str);
                sb.append(e);
                string = sb.toString();
            }
        }
        TbsLog.m662e("sdkreport", string);
    }

    /* JADX INFO: renamed from: a */
    private static void m517a(Context context, int i) {
        TbsLog.m665i("HttpUtils", "updatePVConfig command is " + i);
        if (i == 1) {
            TbsPVConfig.getInstance(context).clear();
        }
        if (i == 2) {
            TbsPVConfig.getInstance(context).update(f641c);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m518a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                m517a(context, 1);
                return;
            }
            f641c = new HashMap();
            for (String str2 : str.split("\\|")) {
                try {
                    String[] strArrSplit = str2.split("=");
                    if (strArrSplit.length == 2) {
                        m519a(context, strArrSplit[0], strArrSplit[1]);
                    }
                } catch (Exception e) {
                    TbsLog.m668i(e);
                }
            }
            int iM524c = m524c(context);
            TbsLog.m665i("HttpUtils", "readResponse, after processSwitchKeyValue mMapFromResponse is " + f641c.toString() + " commandForUpdatePVC is " + iM524c);
            m517a(context, iM524c);
        } catch (Exception e2) {
            TbsLog.m668i(e2);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m519a(Context context, String str, String str2) {
        TbsLog.m665i("HttpUtils", "PV Config Receive. Key: " + str + ", value: " + str2);
        if ("reset".equals(str) && "true".equals(str2)) {
            QbSdk.reset(context);
        } else if ("resetCfg24".equals(str) && "true".equals(str2)) {
            m525d(context);
        } else {
            f641c.put(str, str2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m520a(Context context, String str, String str2, String str3, int i, boolean z, long j, boolean z2) {
        String str4;
        if (QbSdk.getSettings() != null && QbSdk.getSettings().containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.getSettings().get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.m665i("sdkreport", "[HttpUtils.doReport] -- SET_SENDREQUEST_AND_UPLOAD is false");
            return;
        }
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (TbsConfig.APP_QQ.equals(applicationInfo.packageName)) {
                str4 = context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0).versionName;
                try {
                    if (!TextUtils.isEmpty(QbSdk.getQQBuildNumber())) {
                        str4 = str4 + "." + QbSdk.getQQBuildNumber();
                    }
                } catch (Exception e) {
                    e = e;
                    TbsLog.m668i(e);
                }
            } else {
                str4 = BuildConfig.FLAVOR;
            }
        } catch (Exception e2) {
            e = e2;
            str4 = BuildConfig.FLAVOR;
        }
        try {
            IL1Iii iL1Iii = new IL1Iii();
            iL1Iii.f3586ILil = context.getApplicationContext().getApplicationInfo().packageName;
            C0458o.m794a(context);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
            iL1Iii.f3585I1I = simpleDateFormat.format(Calendar.getInstance().getTime());
            iL1Iii.ILL = C0445b.m698b(context);
            String strM691a = C0445b.m691a(context, TbsDownloader.TBS_METADATA);
            if (!TextUtils.isEmpty(strM691a)) {
                iL1Iii.f1189il = strM691a;
            }
            iL1Iii.f1188lLi1LL = str;
            if (z) {
                iL1Iii.f1180IL = str2;
            } else {
                iL1Iii.f1180IL = C0455l.m774a(context);
            }
            iL1Iii.f3587Ilil = str3;
            String strM706f = C0445b.m706f(context);
            String strM704d = C0445b.m704d(context);
            String strM705e = C0445b.m705e(context);
            String strM707g = C0445b.m707g(context);
            if (strM704d != null && !BuildConfig.FLAVOR.equals(strM704d)) {
                iL1Iii.f1184iILLL1 = strM704d;
            }
            if (strM705e != null && !BuildConfig.FLAVOR.equals(strM705e)) {
                iL1Iii.f1181IiL = strM705e;
            }
            if (!TextUtils.isEmpty(strM707g)) {
                iL1Iii.f1187llL1ii = strM707g;
            }
            if (strM706f != null && !BuildConfig.FLAVOR.equals(strM706f)) {
                iL1Iii.f1183L11I = strM706f;
            }
            iL1Iii.f1185lIiI = i;
            if (!TbsShareManager.isThirdPartyApp(context)) {
                iL1Iii.f1179ILl = z ? 1 : 0;
                if (z && z2) {
                    iL1Iii.f1179ILl = 3;
                }
            } else if (z) {
                iL1Iii.f1179ILl = 1;
                if (z2) {
                    iL1Iii.f1179ILl = 3;
                }
            } else {
                iL1Iii.f1179ILl = 0;
            }
            iL1Iii.Lil = str4;
            iL1Iii.LlLI1 = m522b(context);
            if (!z) {
                iL1Iii.f1186lIlii = j;
                iL1Iii.iIi1 = QbSdk.getTbsVersion(context);
            }
            f640b = iL1Iii;
            m516a(iL1Iii, context.getApplicationContext());
        } catch (Throwable th) {
            TbsLog.m668i(th);
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m521a(Map<String, String> map, Map<String, String> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            String str = BuildConfig.FLAVOR;
            String value2 = value == null ? BuildConfig.FLAVOR : entry.getValue();
            if (map2.get(entry.getKey()) != null) {
                str = map2.get(entry.getKey());
            }
            if (!value2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    private static String m522b(Context context) {
        try {
            byte[] byteArray = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray();
            if (byteArray != null) {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                messageDigest.update(byteArray);
                byte[] bArrDigest = messageDigest.digest();
                if (bArrDigest != null) {
                    StringBuilder sb = new StringBuilder(BuildConfig.FLAVOR);
                    if (bArrDigest != null && bArrDigest.length > 0) {
                        for (int i = 0; i < bArrDigest.length; i++) {
                            String upperCase = Integer.toHexString(bArrDigest[i] & StatementImpl.USES_VARIABLES_UNKNOWN).toUpperCase();
                            if (i > 0) {
                                sb.append(":");
                            }
                            if (upperCase.length() < 2) {
                                sb.append(0);
                            }
                            sb.append(upperCase);
                        }
                        return sb.toString();
                    }
                    return null;
                }
            }
        } catch (Exception e) {
            TbsLog.m668i(e);
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    private static JSONObject m523b(IL1Iii iL1Iii, Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("APPNAME", iL1Iii.f3586ILil);
            jSONObject.put("TIME", iL1Iii.f3585I1I);
            jSONObject.put("QUA2", iL1Iii.f1180IL);
            jSONObject.put("LC", iL1Iii.f3587Ilil);
            jSONObject.put("GUID", iL1Iii.f1188lLi1LL);
            jSONObject.put("IMEI", iL1Iii.f1184iILLL1);
            jSONObject.put("IMSI", iL1Iii.f1181IiL);
            jSONObject.put("MAC", iL1Iii.f1183L11I);
            jSONObject.put("PV", iL1Iii.f1185lIiI);
            jSONObject.put("CORETYPE", iL1Iii.f1179ILl);
            jSONObject.put("APPVN", iL1Iii.Lil);
            jSONObject.put("APPMETADATA", iL1Iii.f1189il);
            jSONObject.put("VERSION_CODE", iL1Iii.ILL);
            jSONObject.put("CPU", iL1Iii.f1182Ll1);
            String str = iL1Iii.LlLI1;
            if (str == null) {
                str = "0";
            }
            jSONObject.put("SIGNATURE", str);
            String strM514a = m514a(context);
            TbsLog.m665i("sdkreport", "addInfo is " + strM514a);
            if (!TextUtils.isEmpty(strM514a)) {
                jSONObject.put("EXT_INFO", strM514a);
            }
            jSONObject.put("PROTOCOL_VERSION", 3);
            jSONObject.put("ANDROID_ID", iL1Iii.f1187llL1ii);
            jSONObject.put("HOST_COREVERSION", 0);
            jSONObject.put("DECOUPLE_COREVERSION", 0);
            jSONObject.put("WIFICONNECTEDTIME", iL1Iii.f1186lIlii);
            jSONObject.put("CORE_EXIST", iL1Iii.iIi1);
            int loadErrorCode = TbsCoreLoadStat.getLoadErrorCode();
            if (iL1Iii.iIi1 <= 0) {
                jSONObject.put("TBS_ERROR_CODE", TbsDownloadConfig.getInstance(context).getDownloadInterruptCode());
            } else {
                jSONObject.put("TBS_ERROR_CODE", loadErrorCode);
            }
            if (loadErrorCode == -1) {
                TbsLog.m662e("sdkreport", "ATTENTION: Load errorCode missed!");
            }
            try {
                if (QbSdk.getTID() != null && (iL1Iii.f3586ILil.equals(TbsConfig.APP_QQ) || iL1Iii.f3586ILil.equals(TbsConfig.APP_WX))) {
                    String tid = QbSdk.getTID();
                    jSONObject.put("TID", tid);
                    jSONObject.put("TIDTYPE", 0);
                }
            } catch (Exception unused) {
            }
            return jSONObject;
        } catch (Exception unused2) {
            TbsLog.m662e("sdkreport", "getPostData exception!");
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    private static int m524c(Context context) {
        Map<String, String> map = f641c;
        if (map == null || map.size() == 0) {
            return 1;
        }
        Map<String, String> pVCLocal = TbsPVConfig.getInstance(context).getPVCLocal();
        TbsLog.m665i("HttpUtils", "getCommandForUpdatePVC, mMapPVCLocal is " + pVCLocal.toString());
        return (pVCLocal == null || pVCLocal.size() == 0 || !m521a(f641c, pVCLocal)) ? 2 : 0;
    }

    /* JADX INFO: renamed from: d */
    private static void m525d(Context context) {
        SharedPreferences.Editor editorEdit = TbsDownloadConfig.getInstance(context).mPreferences.edit();
        editorEdit.putLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK, 0L);
        editorEdit.apply();
    }
}
