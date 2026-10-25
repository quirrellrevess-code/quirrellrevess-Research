package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.flexbox.BuildConfig;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.C0443a;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: com.tencent.smtt.sdk.k */
/* JADX INFO: loaded from: classes.dex */
public class C0417k {

    /* JADX INFO: renamed from: d */
    private static int f548d = 5;

    /* JADX INFO: renamed from: e */
    private static int f549e = 1;

    /* JADX INFO: renamed from: f */
    private static final String[] f550f = {"tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.tbs", "tbs_downloading_com.qzone"};

    /* JADX INFO: renamed from: C */
    private boolean f553C;

    /* JADX INFO: renamed from: g */
    private Context f557g;

    /* JADX INFO: renamed from: h */
    private String f558h;

    /* JADX INFO: renamed from: i */
    private String f559i;

    /* JADX INFO: renamed from: j */
    private String f560j;

    /* JADX INFO: renamed from: k */
    private File f561k;

    /* JADX INFO: renamed from: l */
    private long f562l;

    /* JADX INFO: renamed from: o */
    private boolean f565o;

    /* JADX INFO: renamed from: p */
    private int f566p;

    /* JADX INFO: renamed from: q */
    private int f567q;

    /* JADX INFO: renamed from: r */
    private boolean f568r;

    /* JADX INFO: renamed from: s */
    private boolean f569s;

    /* JADX INFO: renamed from: t */
    private HttpURLConnection f570t;

    /* JADX INFO: renamed from: u */
    private String f571u;

    /* JADX INFO: renamed from: v */
    private final TbsLogReport.TbsLogInfo f572v;

    /* JADX INFO: renamed from: w */
    private String f573w;

    /* JADX INFO: renamed from: x */
    private int f574x;

    /* JADX INFO: renamed from: y */
    private boolean f575y;

    /* JADX INFO: renamed from: z */
    private Handler f576z;

    /* JADX INFO: renamed from: c */
    private boolean f556c = false;

    /* JADX INFO: renamed from: m */
    private int f563m = 30000;

    /* JADX INFO: renamed from: n */
    private int f564n = 20000;

    /* JADX INFO: renamed from: A */
    private boolean f551A = false;

    /* JADX INFO: renamed from: B */
    private int f552B = f548d;

    /* JADX INFO: renamed from: a */
    public String[] f554a = null;

    /* JADX INFO: renamed from: b */
    public int f555b = 0;

    public C0417k(Context context) throws NullPointerException {
        Context applicationContext = context.getApplicationContext();
        this.f557g = applicationContext;
        this.f572v = TbsLogReport.getInstance(applicationContext).tbsLogInfo();
        this.f571u = "tbs_downloading_" + this.f557g.getPackageName();
        File fileM411o = C0419m.m411o(this.f557g);
        this.f561k = fileM411o;
        Objects.requireNonNull(fileM411o, "TbsCorePrivateDir is null!");
        m355f();
        this.f573w = null;
        this.f574x = -1;
    }

    /* JADX INFO: renamed from: a */
    private long m344a(long j, long j2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f572v.setDownConsumeTime(jCurrentTimeMillis - j);
        this.f572v.setDownloadSize(j2);
        return jCurrentTimeMillis;
    }

    /* JADX INFO: renamed from: a */
    private String m345a(Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        return stackTraceString.length() > 1024 ? stackTraceString.substring(0, 1024) : stackTraceString;
    }

    /* JADX INFO: renamed from: a */
    private void m346a(int i, String str, boolean z) {
        if (z || this.f566p > this.f552B) {
            this.f572v.setErrorCode(i);
            this.f572v.setFailDetail(str);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m347a(long j) {
        this.f566p++;
        if (j <= 0) {
            try {
                j = m362m();
            } catch (Exception unused) {
                return;
            }
        }
        Thread.sleep(j);
    }

    /* JADX INFO: renamed from: a */
    public static void m348a(Context context) {
        try {
            TbsLog.m665i(TbsDownloader.LOGTAG, "clearDecoupleDirOld #00");
            File fileM424a = C0419m.m393a().m424a(context, context.getDir("tbs_64", 0));
            FileUtil.m645b(fileM424a);
            if (fileM424a != null) {
                TbsLog.m665i(TbsDownloader.LOGTAG, "clearDecoupleDirOld dir is " + fileM424a.getAbsolutePath());
            }
            File fileM424a2 = C0419m.m393a().m424a(context, context.getDir("tbs", 0));
            FileUtil.m645b(fileM424a2);
            if (fileM424a2 != null) {
                TbsLog.m665i(TbsDownloader.LOGTAG, "clearDecoupleDirOld dir is " + fileM424a2.getAbsolutePath());
            }
        } catch (Throwable th) {
            TbsLog.m665i(TbsDownloader.LOGTAG, "clearDecoupleDirOld stack is " + Log.getStackTraceString(th));
        }
    }

    /* JADX INFO: renamed from: a */
    private void m349a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m350a(String str) throws Exception {
        URL url = new URL(str);
        HttpURLConnection httpURLConnection = this.f570t;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                TbsLog.m662e(TbsDownloader.LOGTAG, "[initHttpRequest] mHttpRequest.disconnect() Throwable:" + th.toString());
            }
        }
        HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
        this.f570t = httpURLConnection2;
        httpURLConnection2.setRequestProperty("User-Agent", TbsDownloader.m190b(this.f557g));
        this.f570t.setRequestProperty("Accept-Encoding", "identity");
        this.f570t.setRequestMethod("GET");
        this.f570t.setInstanceFollowRedirects(false);
        this.f570t.setConnectTimeout(this.f564n);
        this.f570t.setReadTimeout(this.f563m);
    }

    /* JADX INFO: renamed from: b */
    public static void m351b(Context context) {
        try {
            C0419m.m393a();
            File fileM411o = C0419m.m411o(context);
            new File(fileM411o, "x5.tbs").delete();
            new File(fileM411o, "x5.tbs.temp").delete();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0085, code lost:
    
        if (r10 != r8) goto L22;
     */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m352b(boolean r13, boolean r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 490
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.C0417k.m352b(boolean, boolean):boolean");
    }

    /* JADX INFO: renamed from: c */
    private void m353c(boolean z) throws Throwable {
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(this.f557g);
        Map<String, Object> map = tbsDownloadConfig.mSyncMap;
        Boolean bool = Boolean.FALSE;
        map.put(TbsDownloadConfig.TbsConfigKey.KEY_FULL_PACKAGE, bool);
        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, bool);
        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -123);
        tbsDownloadConfig.commit();
        this.f572v.f332a = 100;
        int i = tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
        TbsDownloader.m183a(this.f557g);
        if (i == 5 || i == 3) {
            Bundle bundleM364a = m364a(i);
            if (bundleM364a == null) {
                TbsLog.m665i(TbsDownloader.LOGTAG, "downloadSuccess RESPONSECODE_TPATCH bundle is null ");
            } else {
                TbsLog.m665i(TbsDownloader.LOGTAG, "downloadSuccess RESPONSECODE_TPATCH bundle is " + bundleM364a);
                C0419m.m393a().m433b(this.f557g, bundleM364a);
            }
        } else if (i > 10000) {
            m368b();
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.TRUE);
            tbsDownloadConfig.commit();
        } else {
            C0419m.m393a().m428a(this.f557g, new File(this.f561k, "x5.tbs").getAbsolutePath(), tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
        }
        m348a(this.f557g);
    }

    /* JADX INFO: renamed from: d */
    private boolean m354d(boolean z) {
        TbsLog.m665i(TbsDownloader.LOGTAG, "[TbsApkDownloader.deleteFile] isApk=" + z);
        File file = z ? new File(this.f561k, "x5.tbs") : new File(this.f561k, "x5.tbs.temp");
        if (file.exists()) {
            FileUtil.m645b(file);
        }
        return true;
    }

    /* JADX INFO: renamed from: f */
    private void m355f() {
        this.f566p = 0;
        this.f567q = 0;
        this.f562l = -1L;
        this.f560j = null;
        this.f565o = false;
        this.f568r = false;
        this.f569s = false;
        this.f575y = false;
    }

    /* JADX INFO: renamed from: g */
    private void m356g() {
        TbsLog.m665i(TbsDownloader.LOGTAG, "[TbsApkDownloader.closeHttpRequest]");
        HttpURLConnection httpURLConnection = this.f570t;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                TbsLog.m662e(TbsDownloader.LOGTAG, "[closeHttpRequest] mHttpRequest.disconnect() Throwable:" + th.toString());
            }
            this.f570t = null;
        }
        int i = this.f572v.f332a;
        TbsLog.m665i(TbsDownloader.LOGTAG, "[TbsApkDownloader.closeHttpRequest] download finish code: " + i);
        if (!this.f568r && this.f575y) {
            m357h();
        } else if (!this.f556c) {
            TbsDownloader.f291a = false;
        }
        TbsDownloadConfig.getInstance(this.f557g).saveDownloadInterruptCode();
        QbSdk.f209n.onDownloadFinish(i);
    }

    /* JADX INFO: renamed from: h */
    private void m357h() {
        this.f572v.setEventTime(System.currentTimeMillis());
        String apnInfo = Apn.getApnInfo(this.f557g);
        if (apnInfo == null) {
            apnInfo = BuildConfig.FLAVOR;
        }
        int apnType = Apn.getApnType(this.f557g);
        this.f572v.setApn(apnInfo);
        this.f572v.setNetworkType(apnType);
        if (apnType != this.f574x || !apnInfo.equals(this.f573w)) {
            this.f572v.setNetworkChange(0);
        }
        TbsLogReport.TbsLogInfo tbsLogInfo = this.f572v;
        int i = tbsLogInfo.f332a;
        if ((i == 0 || i == 107) && tbsLogInfo.getDownFinalFlag() == 0 && (!Apn.isNetworkAvailable(this.f557g) || !m361l())) {
            m346a(101, null, true);
        }
        TbsLogReport.getInstance(this.f557g).eventReport(TbsLogReport.EventType.TYPE_CDN_DOWNLOAD_STAT, this.f572v);
        this.f572v.resetArgs();
    }

    /* JADX INFO: renamed from: i */
    private void m358i() {
        int apnType = Apn.getApnType(this.f557g);
        String apnInfo = Apn.getApnInfo(this.f557g);
        String str = this.f573w;
        if (str != null || this.f574x != -1) {
            if (apnType == this.f574x && apnInfo.equals(str)) {
                return;
            } else {
                this.f572v.setNetworkChange(0);
            }
        }
        this.f573w = apnInfo;
        this.f574x = apnType;
    }

    /* JADX INFO: renamed from: j */
    private boolean m359j() {
        return new File(this.f561k, "x5.tbs.temp").exists();
    }

    /* JADX INFO: renamed from: k */
    private long m360k() {
        File file = new File(this.f561k, "x5.tbs.temp");
        if (file.exists()) {
            return file.length();
        }
        return 0L;
    }

    /* JADX INFO: renamed from: l */
    private boolean m361l() {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Throwable th;
        InputStream inputStream;
        boolean z = false;
        try {
            inputStream = Runtime.getRuntime().exec("ping www.qq.com").getInputStream();
            try {
                inputStreamReader = new InputStreamReader(inputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    int i = 0;
                    do {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            if (line.contains("TTL") || line.contains("ttl")) {
                                z = true;
                                break;
                            }
                            i++;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                th.printStackTrace();
                            } finally {
                                m349a(inputStream);
                                m349a(inputStreamReader);
                                m349a(bufferedReader);
                            }
                        }
                    } while (i < 5);
                } catch (Throwable th3) {
                    bufferedReader = null;
                    th = th3;
                }
            } catch (Throwable th4) {
                bufferedReader = null;
                th = th4;
                inputStreamReader = null;
            }
        } catch (Throwable th5) {
            inputStreamReader = null;
            bufferedReader = null;
            th = th5;
            inputStream = null;
        }
        return z;
    }

    /* JADX INFO: renamed from: m */
    private long m362m() {
        int i = this.f566p;
        if (i == 1 || i == 2) {
            return ((long) i) * 20000;
        }
        return (i == 3 || i == 4) ? 100000L : 200000L;
    }

    /* JADX INFO: renamed from: n */
    private boolean m363n() {
        HttpURLConnection httpURLConnection;
        boolean z;
        boolean z2 = Apn.getApnType(this.f557g) == 3;
        TbsLog.m665i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] isWifi=" + z2);
        if (z2) {
            try {
                httpURLConnection = (HttpURLConnection) new URL("https://pms.mb.qq.com/rsp204").openConnection();
                try {
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(10000);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.getInputStream();
                    int responseCode = httpURLConnection.getResponseCode();
                    TbsLog.m665i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] responseCode=" + responseCode);
                    z = responseCode == 204;
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception unused) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused2) {
                            }
                        }
                        z = false;
                    } catch (Throwable th2) {
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused3) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = null;
            }
        } else {
            z = false;
        }
        if (z) {
            this.f551A = true;
        } else {
            this.f551A = false;
            this.f576z.sendMessageDelayed(this.f576z.obtainMessage(TbsListener.ErrorCode.STARTDOWNLOAD_API_LEVEL_BELOW_FROYO, null), 120000L);
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    public Bundle m364a(int i) {
        File fileM452n = C0419m.m393a().m452n(this.f557g);
        int iM445g = C0419m.m393a().m445g(this.f557g);
        File file = new File(this.f561k, "x5.tbs");
        String absolutePath = file.exists() ? file.getAbsolutePath() : null;
        if (absolutePath == null) {
            TbsLog.m665i(TbsDownloader.LOGTAG, "getTpatchBundle tbsApkFile is " + file.getAbsolutePath());
            return null;
        }
        int i2 = TbsDownloadConfig.getInstance(this.f557g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        File fileM442e = C0419m.m393a().m442e(this.f557g, 5);
        Bundle bundle = new Bundle();
        bundle.putInt("operation", i);
        bundle.putInt("old_core_ver", iM445g);
        bundle.putInt("new_core_ver", i2);
        bundle.putString("old_apk_location", fileM452n.getAbsolutePath());
        bundle.putString("new_apk_location", fileM442e.getAbsolutePath());
        bundle.putString("diff_file_location", absolutePath);
        bundle.putString("core_type_tpatch", "not_stable");
        bundle.putInt("for_self_core", 1);
        return bundle;
    }

    /* JADX INFO: renamed from: a */
    public void m365a() {
        this.f568r = true;
        if (TbsShareManager.isThirdPartyApp(this.f557g)) {
            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(this.f557g).tbsLogInfo();
            tbsLogInfo.setErrorCode(-309);
            tbsLogInfo.setFailDetail(new Exception());
            TbsLogReport.getInstance(this.f557g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m366a(boolean z) {
        m367a(z, false);
    }

    /* JADX WARN: Code duplicated, block: B:307:0x0815  */
    /* JADX WARN: Code duplicated, block: B:308:0x0830  */
    /* JADX WARN: Code duplicated, block: B:362:0x08ed A[Catch: all -> 0x0992, TryCatch #13 {all -> 0x0992, blocks: (B:360:0x08e6, B:362:0x08ed, B:366:0x08f5, B:368:0x08fd, B:373:0x0949, B:375:0x0952, B:376:0x0959, B:377:0x095d, B:383:0x0974), top: B:458:0x08e6 }] */
    /* JADX WARN: Code duplicated, block: B:382:0x0971  */
    /* JADX WARN: Code duplicated, block: B:398:0x09a8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:411:0x0a0d  */
    /* JADX WARN: Code duplicated, block: B:413:0x0a11  */
    /* JADX WARN: Code duplicated, block: B:415:0x0a15 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:419:0x0a27 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:420:0x0a29  */
    /* JADX WARN: Code duplicated, block: B:421:0x0a2b  */
    /* JADX WARN: Code duplicated, block: B:422:0x0a2d  */
    /* JADX WARN: Code duplicated, block: B:425:0x0a47  */
    /* JADX WARN: Code duplicated, block: B:426:0x0a5f  */
    /* JADX WARN: Code duplicated, block: B:427:0x0a6f  */
    /* JADX WARN: Code duplicated, block: B:430:0x0a7a  */
    /* JADX WARN: Code duplicated, block: B:431:0x0a8e  */
    /* JADX WARN: Code duplicated, block: B:433:0x0aa7  */
    /* JADX WARN: Code duplicated, block: B:435:0x0ab6  */
    /* JADX WARN: Code duplicated, block: B:437:0x0aba  */
    /* JADX WARN: Code duplicated, block: B:438:0x0ac0  */
    /* JADX WARN: Code duplicated, block: B:442:0x0acc  */
    /* JADX WARN: Code duplicated, block: B:446:0x0adc  */
    /* JADX WARN: Code duplicated, block: B:454:0x0808 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:506:0x0842 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:514:0x09fa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x01df A[PHI: r5 r13 r16
  0x01df: PHI (r5v15 long) = 
  (r5v3 long)
  (r5v11 long)
  (r5v14 long)
  (r5v17 long)
  (r5v18 long)
  (r5v19 long)
  (r5v17 long)
  (r5v17 long)
  (r5v17 long)
  (r5v17 long)
  (r5v17 long)
  (r5v17 long)
  (r5v17 long)
 binds: [B:54:0x01dd, B:60:0x021a, B:407:0x0a05, B:105:0x0397, B:370:0x0943, B:352:0x08d6, B:210:0x05c3, B:144:0x044d, B:186:0x04ef, B:172:0x04c4, B:158:0x049b, B:136:0x0430, B:122:0x03d9] A[DONT_GENERATE, DONT_INLINE]
  0x01df: PHI (r13v3 java.lang.String) = 
  (r13v1 java.lang.String)
  (r13v1 java.lang.String)
  (r13v2 java.lang.String)
  (r13v1 java.lang.String)
  (r13v5 java.lang.String)
  (r13v6 java.lang.String)
  (r13v1 java.lang.String)
  (r13v1 java.lang.String)
  (r13v1 java.lang.String)
  (r13v1 java.lang.String)
  (r13v1 java.lang.String)
  (r13v1 java.lang.String)
  (r13v1 java.lang.String)
 binds: [B:54:0x01dd, B:60:0x021a, B:407:0x0a05, B:105:0x0397, B:370:0x0943, B:352:0x08d6, B:210:0x05c3, B:144:0x044d, B:186:0x04ef, B:172:0x04c4, B:158:0x049b, B:136:0x0430, B:122:0x03d9] A[DONT_GENERATE, DONT_INLINE]
  0x01df: PHI (r16v7 boolean) = 
  (r16v2 boolean)
  (r16v2 boolean)
  (r16v6 boolean)
  (r16v2 boolean)
  (r16v2 boolean)
  (r16v9 boolean)
  (r16v2 boolean)
  (r16v2 boolean)
  (r16v2 boolean)
  (r16v2 boolean)
  (r16v2 boolean)
  (r16v2 boolean)
  (r16v2 boolean)
 binds: [B:54:0x01dd, B:60:0x021a, B:407:0x0a05, B:105:0x0397, B:370:0x0943, B:352:0x08d6, B:210:0x05c3, B:144:0x044d, B:186:0x04ef, B:172:0x04c4, B:158:0x049b, B:136:0x0430, B:122:0x03d9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code restructure failed: missing block: B:380:0x096e, code lost:
    
        if (r42 == false) goto L386;
     */
    /* JADX WARN: Code restructure failed: missing block: B:385:0x098e, code lost:
    
        if (r42 == false) goto L386;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r3v12, types: [com.tencent.smtt.sdk.TbsLogReport$TbsLogInfo] */
    /* JADX WARN: Type inference failed for: r41v0, types: [com.tencent.smtt.sdk.k] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m367a(boolean r42, boolean r43) {
        /*
            Method dump skipped, instruction units count: 2842
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.C0417k.m367a(boolean, boolean):void");
    }

    /* JADX INFO: renamed from: b */
    public void m368b() {
        m365a();
        m354d(false);
        m354d(true);
    }

    /* JADX INFO: renamed from: b */
    public void m369b(int i) {
        if (C0419m.m393a().m453p(this.f557g)) {
            C0419m.m393a().m438c();
            try {
                File file = new File(this.f561k, "x5.tbs");
                int iM681a = C0443a.m681a(this.f557g, file);
                if (-1 == iM681a || (i > 0 && i == iM681a)) {
                    FileUtil.m645b(file);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean m370b(boolean z) {
        String[] strArr;
        int i;
        if ((z && !m363n() && (!QbSdk.canDownloadWithoutWifi() || !Apn.isNetworkAvailable(this.f557g))) || (strArr = this.f554a) == null || (i = this.f555b) < 0 || i >= strArr.length) {
            return false;
        }
        this.f555b = i + 1;
        this.f560j = strArr[i];
        this.f566p = 0;
        this.f567q = 0;
        this.f562l = -1L;
        this.f565o = false;
        this.f568r = false;
        this.f569s = false;
        this.f575y = false;
        return true;
    }

    /* JADX INFO: renamed from: c */
    public boolean m371c() {
        TbsLog.m665i(TbsDownloader.LOGTAG, "[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=" + this.f553C);
        return this.f553C;
    }

    /* JADX INFO: renamed from: d */
    public void m372d() {
        TbsLog.m665i(TbsDownloader.LOGTAG, "pauseDownload,isPause=" + this.f556c + "isDownloading=" + TbsDownloader.isDownloading());
        if (this.f556c || !TbsDownloader.isDownloading()) {
            return;
        }
        m365a();
        this.f556c = true;
        this.f575y = false;
    }

    /* JADX INFO: renamed from: e */
    public void m373e() {
        TbsLog.m665i(TbsDownloader.LOGTAG, "resumeDownload,isPause=" + this.f556c + "isDownloading=" + TbsDownloader.isDownloading());
        if (this.f556c && TbsDownloader.isDownloading()) {
            this.f556c = false;
            m366a(false);
        }
    }
}
