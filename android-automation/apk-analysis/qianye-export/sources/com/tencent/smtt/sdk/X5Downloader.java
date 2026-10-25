package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.flexbox.BuildConfig;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.C0443a;
import com.tencent.smtt.utils.C0445b;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.p004a.C0444a;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.channels.FileLock;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class X5Downloader implements ProgressListener {

    /* JADX INFO: renamed from: a */
    private final Context f466a;

    /* JADX INFO: renamed from: b */
    private final QbSdk.PrivateCDNMode f467b;

    /* JADX INFO: renamed from: c */
    private String f468c;

    /* JADX INFO: renamed from: d */
    private String f469d;

    /* JADX INFO: renamed from: e */
    private File f470e;

    /* JADX INFO: renamed from: f */
    private File f471f;

    /* JADX INFO: renamed from: g */
    private long f472g;

    /* JADX INFO: renamed from: h */
    private String f473h;

    /* JADX INFO: renamed from: i */
    private int f474i;

    /* JADX INFO: renamed from: l */
    private DownloadDelegate f477l;

    /* JADX INFO: renamed from: n */
    private FileLock f479n;

    /* JADX INFO: renamed from: o */
    private FileOutputStream f480o;

    /* JADX INFO: renamed from: t */
    private HttpURLConnection f485t;

    /* JADX INFO: renamed from: v */
    private int f487v;

    /* JADX INFO: renamed from: w */
    private String f488w;

    /* JADX INFO: renamed from: j */
    private int f475j = 4;

    /* JADX INFO: renamed from: k */
    private int f476k = 10000;

    /* JADX INFO: renamed from: m */
    private volatile boolean f478m = false;

    /* JADX INFO: renamed from: p */
    private int f481p = 0;

    /* JADX INFO: renamed from: q */
    private int f482q = 0;

    /* JADX INFO: renamed from: r */
    private int f483r = 30000;

    /* JADX INFO: renamed from: s */
    private boolean f484s = false;

    /* JADX INFO: renamed from: u */
    private long f486u = -1;

    /* JADX INFO: renamed from: x */
    private boolean f489x = false;

    /* JADX INFO: renamed from: y */
    private boolean f490y = false;

    /* JADX INFO: renamed from: z */
    private final StringBuilder f491z = new StringBuilder();

    /* JADX INFO: renamed from: A */
    private int f464A = 0;

    /* JADX INFO: renamed from: B */
    private String f465B = BuildConfig.FLAVOR;

    public interface DownloadDelegate {
        void download(X5Downloader x5Downloader, String str, File file);
    }

    public X5Downloader(Context context) {
        throw new C0444a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:166:0x0363 A[Catch: all -> 0x03a9, TryCatch #5 {all -> 0x03a9, blocks: (B:164:0x035f, B:166:0x0363, B:169:0x0368, B:171:0x0370, B:178:0x038a, B:183:0x039b), top: B:194:0x035f }] */
    /* JADX WARN: Code duplicated, block: B:182:0x0398  */
    /* JADX INFO: renamed from: a */
    public void m292a() {
        int i;
        StringBuilder sb;
        String string;
        long jM299b;
        String str;
        int i2;
        Closeable closeable;
        Closeable closeable2;
        InputStream inflaterInputStream;
        FileOutputStream fileOutputStream;
        int i3;
        String str2;
        HttpURLConnection httpURLConnection;
        String str3;
        this.f490y = true;
        if (m304d()) {
            while (true) {
                if (this.f481p > this.f475j) {
                    i = -3;
                    sb = new StringBuilder();
                    sb.append("out of max retry, times:");
                    sb.append(this.f481p);
                    sb.append("; record: ");
                    string = this.f491z.toString();
                } else if (this.f482q > 8) {
                    i = -4;
                    sb = new StringBuilder();
                    sb.append("302 redirect to much, times:");
                    sb.append(this.f482q);
                    sb.append("; current location: ");
                    string = this.f469d;
                } else {
                    if (!FileUtil.m646b(this.f466a)) {
                        m300b(-5, "no disk space left");
                        break;
                    }
                    String str4 = this.f469d;
                    if (str4 == null) {
                        str4 = this.f468c;
                    }
                    TbsLog.m665i("X5Downloader", "url: " + str4);
                    try {
                        m297a(str4);
                        if (this.f484s) {
                            jM299b = 0;
                        } else {
                            jM299b = m299b();
                            TbsLog.m665i("X5Downloader", "[TbsApkDownloader.startDownload] range=" + jM299b);
                            if (this.f486u <= 0) {
                                TbsLog.m665i("X5Downloader", "STEP 1/2 begin downloading...current" + jM299b);
                                httpURLConnection = this.f485t;
                                str3 = "bytes=" + jM299b + "-";
                            } else {
                                TbsLog.m665i("X5Downloader", "#1 STEP 1/2 begin downloading...current/total=" + jM299b + "/" + this.f486u);
                                httpURLConnection = this.f485t;
                                str3 = "bytes=" + jM299b + "-" + this.f486u;
                            }
                            httpURLConnection.setRequestProperty("Range", str3);
                        }
                        m302c();
                        if (this.f481p >= 1) {
                            this.f485t.addRequestProperty("Referer", this.f468c);
                        }
                        int responseCode = this.f485t.getResponseCode();
                        TbsLog.m665i("X5Downloader", "responseCode=" + responseCode);
                        int i4 = -6;
                        if (!this.f478m) {
                            int i5 = 0;
                            if (responseCode != 200 && responseCode != 206) {
                                if (responseCode >= 300 && responseCode <= 307) {
                                    String headerField = this.f485t.getHeaderField("Location");
                                    if (TextUtils.isEmpty(headerField)) {
                                        i3 = -10;
                                        str2 = "http redirect location null, responseCode: " + responseCode;
                                        m300b(i3, str2);
                                        break;
                                    }
                                    this.f469d = headerField;
                                    this.f482q++;
                                } else {
                                    if (responseCode != 416) {
                                        if ((responseCode == 403 || responseCode == 406) && this.f486u == -1) {
                                            i3 = -16;
                                            str2 = "apk forbidden. responseCode: " + responseCode;
                                        } else if (responseCode == 202) {
                                            continue;
                                        } else if (responseCode == 503) {
                                            long j = Long.parseLong(this.f485t.getHeaderField("Retry-After"));
                                            StringBuilder sb2 = this.f491z;
                                            sb2.append("httpCode:");
                                            sb2.append(responseCode);
                                            m294a(j);
                                        } else if (responseCode == 408 || responseCode == 504 || responseCode == 502) {
                                            StringBuilder sb3 = this.f491z;
                                            sb3.append("httpCode:");
                                            sb3.append(responseCode);
                                            m294a(0L);
                                        } else if (m299b() > 0 || this.f484s || responseCode == 410) {
                                            i3 = -1;
                                            str2 = "other http code come up: " + responseCode;
                                        } else {
                                            this.f484s = true;
                                        }
                                        m300b(i3, str2);
                                        break;
                                    }
                                    if (!m298a(false)) {
                                        m307g();
                                        i2 = this.f464A;
                                        str = this.f465B;
                                        m300b(i2, str);
                                        break;
                                    }
                                    this.f489x = true;
                                    break;
                                }
                            } else {
                                long contentLength = ((long) this.f485t.getContentLength()) + jM299b;
                                this.f486u = contentLength;
                                long j2 = this.f472g;
                                if (j2 != 0 && contentLength != j2) {
                                    i2 = -7;
                                    str = "connection ok, but file length not match.Expected: " + this.f472g + "; real: " + this.f486u;
                                    m300b(i2, str);
                                    break;
                                }
                                Closeable closeable3 = null;
                                try {
                                    InputStream inputStream = this.f485t.getInputStream();
                                    if (inputStream == null) {
                                        try {
                                            m300b(-8, "response input stream null.");
                                            m296a((Closeable) null);
                                            m296a((Closeable) null);
                                            m296a(inputStream);
                                            break;
                                        } catch (IOException e) {
                                            e = e;
                                            closeable2 = inputStream;
                                            closeable = null;
                                            try {
                                                if (e instanceof SocketTimeoutException) {
                                                    this.f483r = 100000;
                                                    m294a(0L);
                                                    m296a(closeable3);
                                                    m296a(closeable);
                                                } else {
                                                    this.f483r = 100000;
                                                    m294a(0L);
                                                    m296a(closeable3);
                                                    m296a(closeable);
                                                }
                                                m296a(closeable2);
                                            } catch (Throwable th) {
                                                th = th;
                                                m296a(closeable3);
                                                m296a(closeable);
                                                m296a(closeable2);
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            closeable2 = inputStream;
                                            closeable = null;
                                            m296a(closeable3);
                                            m296a(closeable);
                                            m296a(closeable2);
                                            throw th;
                                        }
                                    } else {
                                        int i6 = 8192;
                                        try {
                                            byte[] bArr = new byte[8192];
                                            File file = this.f470e;
                                            String contentEncoding = this.f485t.getContentEncoding();
                                            if (contentEncoding == null || !contentEncoding.contains("gzip")) {
                                                inflaterInputStream = (contentEncoding == null || !contentEncoding.contains("deflate")) ? inputStream : new InflaterInputStream(inputStream, new Inflater(true));
                                            } else {
                                                inflaterInputStream = new GZIPInputStream(inputStream);
                                            }
                                            try {
                                                FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
                                                try {
                                                    try {
                                                        long jCurrentTimeMillis = System.currentTimeMillis();
                                                        while (true) {
                                                            if (this.f478m) {
                                                                try {
                                                                    try {
                                                                        m300b(i4, "user cancel download");
                                                                        break;
                                                                    } catch (Throwable th3) {
                                                                        th = th3;
                                                                        closeable2 = inputStream;
                                                                        closeable = inflaterInputStream;
                                                                        closeable3 = fileOutputStream2;
                                                                        m296a(closeable3);
                                                                        m296a(closeable);
                                                                        m296a(closeable2);
                                                                        throw th;
                                                                    }
                                                                } catch (IOException e2) {
                                                                    e = e2;
                                                                    closeable2 = inputStream;
                                                                    closeable = inflaterInputStream;
                                                                    closeable3 = fileOutputStream2;
                                                                    if (e instanceof SocketTimeoutException) {
                                                                        this.f483r = 100000;
                                                                        m294a(0L);
                                                                        m296a(closeable3);
                                                                        m296a(closeable);
                                                                    } else {
                                                                        this.f483r = 100000;
                                                                        m294a(0L);
                                                                        m296a(closeable3);
                                                                        m296a(closeable);
                                                                    }
                                                                    m296a(closeable2);
                                                                }
                                                            } else {
                                                                int i7 = inflaterInputStream.read(bArr, i5, i6);
                                                                if (i7 <= 0) {
                                                                    this.f491z.append("stream is 0, code: -9");
                                                                    break;
                                                                }
                                                                fileOutputStream2.write(bArr, i5, i7);
                                                                fileOutputStream2.flush();
                                                                if (!FileUtil.m646b(this.f466a)) {
                                                                    m300b(-5, "no disk space left");
                                                                    break;
                                                                }
                                                                fileOutputStream = fileOutputStream2;
                                                                try {
                                                                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                                                                    jM299b += (long) i7;
                                                                    if (jCurrentTimeMillis2 - jCurrentTimeMillis >= 500) {
                                                                        onProgress((int) ((jM299b / this.f486u) * 100.0d));
                                                                        jCurrentTimeMillis = jCurrentTimeMillis2;
                                                                    }
                                                                    fileOutputStream2 = fileOutputStream;
                                                                    i6 = 8192;
                                                                    i4 = -6;
                                                                    i5 = 0;
                                                                } catch (IOException e3) {
                                                                    e = e3;
                                                                } catch (Throwable th4) {
                                                                    th = th4;
                                                                    closeable2 = inputStream;
                                                                    closeable = inflaterInputStream;
                                                                    closeable3 = fileOutputStream;
                                                                    m296a(closeable3);
                                                                    m296a(closeable);
                                                                    m296a(closeable2);
                                                                    throw th;
                                                                }
                                                                closeable2 = inputStream;
                                                                closeable = inflaterInputStream;
                                                                closeable3 = fileOutputStream;
                                                                if ((e instanceof SocketTimeoutException) || (e instanceof SocketException)) {
                                                                    this.f483r = 100000;
                                                                    m294a(0L);
                                                                    m296a(closeable3);
                                                                    m296a(closeable);
                                                                } else {
                                                                    if (!FileUtil.m646b(this.f466a)) {
                                                                        m300b(-5, "no disk space left");
                                                                        m296a(closeable3);
                                                                        m296a(closeable);
                                                                        m296a(closeable2);
                                                                        break;
                                                                    }
                                                                    m294a(0L);
                                                                    m296a(closeable3);
                                                                    m296a(closeable);
                                                                }
                                                                m296a(closeable2);
                                                            }
                                                        }
                                                        m296a(fileOutputStream2);
                                                        m296a(inflaterInputStream);
                                                        m296a(inputStream);
                                                    } catch (Throwable th5) {
                                                        th = th5;
                                                        fileOutputStream = fileOutputStream2;
                                                    }
                                                } catch (IOException e4) {
                                                    e = e4;
                                                    fileOutputStream = fileOutputStream2;
                                                }
                                            } catch (IOException e5) {
                                                e = e5;
                                                closeable2 = inputStream;
                                                closeable = inflaterInputStream;
                                                closeable3 = null;
                                            } catch (Throwable th6) {
                                                th = th6;
                                                closeable2 = inputStream;
                                                closeable = inflaterInputStream;
                                                closeable3 = null;
                                            }
                                        } catch (IOException e6) {
                                            e = e6;
                                            closeable2 = inputStream;
                                            closeable3 = null;
                                            closeable = null;
                                        } catch (Throwable th7) {
                                            th = th7;
                                            closeable2 = inputStream;
                                            closeable3 = null;
                                            closeable = null;
                                        }
                                    }
                                } catch (IOException e7) {
                                    e = e7;
                                    closeable3 = null;
                                    closeable = null;
                                    closeable2 = null;
                                } catch (Throwable th8) {
                                    th = th8;
                                    closeable3 = null;
                                    closeable = null;
                                    closeable2 = null;
                                }
                            }
                        } else {
                            m300b(-6, "user cancel download");
                            break;
                        }
                    } catch (Throwable th9) {
                        th9.printStackTrace();
                        this.f491z.append(th9.getMessage());
                        m294a(0L);
                    }
                }
                sb.append(string);
                m300b(i, sb.toString());
                break;
            }
            m305e();
            if (this.f489x) {
                m310j();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m293a(int i, String str) {
        this.f464A = i;
        this.f465B = str;
    }

    /* JADX INFO: renamed from: a */
    private void m294a(long j) {
        int i = this.f481p + 1;
        this.f481p = i;
        if (j <= 0) {
            if (i == 1 || i == 2) {
                j = 5000 * ((long) i);
            } else {
                j = (i == 3 || i == 4) ? 25000L : 50000L;
            }
        }
        try {
            Thread.sleep(j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m295a(QbSdk.PrivateCDNMode privateCDNMode) {
        if (this.f467b == privateCDNMode) {
            return;
        }
        throw new UnsupportedOperationException("you are expected use " + privateCDNMode.name() + ".Current mode is " + privateCDNMode.name() + ". Plz check QbSdk.usePrivateCDN(PrivateCDNMode)");
    }

    /* JADX INFO: renamed from: a */
    private void m296a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m297a(String str) throws Exception {
        URL url = new URL(str);
        HttpURLConnection httpURLConnection = this.f485t;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                TbsLog.m662e("X5Downloader", "[initHttpRequest] mHttpRequest.disconnect() Throwable:" + th.toString());
            }
        }
        HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
        this.f485t = httpURLConnection2;
        httpURLConnection2.setRequestProperty("User-Agent", TbsDownloader.m190b(this.f466a));
        this.f485t.setRequestProperty("Accept-Encoding", "identity");
        this.f485t.setRequestMethod("GET");
        this.f485t.setInstanceFollowRedirects(false);
        this.f485t.setConnectTimeout(this.f476k);
        this.f485t.setReadTimeout(this.f483r);
    }

    /* JADX INFO: renamed from: a */
    private boolean m298a(boolean z) {
        boolean zRenameTo;
        File file = z ? this.f471f : this.f470e;
        if (this.f470e == null || !file.exists()) {
            m293a(-14, "target file not exist.");
            return false;
        }
        String strM685a = C0443a.m685a(file);
        String str = this.f473h;
        if (str == null || !str.equals(strM685a)) {
            m293a(-11, "md5 not match");
            return false;
        }
        long j = this.f472g;
        if (j == 0 || j != file.length()) {
            m293a(-12, "size not match. current: " + file.length());
            return false;
        }
        int i = this.f474i;
        if (i == 0 || i != C0443a.m681a(this.f466a, file)) {
            m293a(-15, "core version not match");
            return false;
        }
        if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(C0445b.m692a(this.f466a, false, file))) {
            m293a(-13, "core sig invalid.");
            return false;
        }
        if (!z) {
            Exception e = null;
            try {
                zRenameTo = this.f470e.renameTo(this.f471f);
            } catch (Exception e2) {
                e = e2;
                zRenameTo = false;
            }
            if (!zRenameTo) {
                m293a(-17, "reason: " + e);
                return false;
            }
        }
        m309i();
        return true;
    }

    /* JADX INFO: renamed from: b */
    private long m299b() {
        File file = this.f470e;
        if (file == null || !file.exists()) {
            return 0L;
        }
        return this.f470e.length();
    }

    /* JADX INFO: renamed from: b */
    private void m300b(int i, String str) {
        m308h();
        TbsLog.m665i("X5Downloader", "innerOnFailed, code: " + i + ", msg: " + str);
        onFailed(i, str);
    }

    /* JADX INFO: renamed from: c */
    private void m302c() {
        int apnType = Apn.getApnType(this.f466a);
        String apnInfo = Apn.getApnInfo(this.f466a);
        String str = this.f488w;
        if (!(str == null && this.f487v == -1) && apnType == this.f487v && apnInfo.equals(str)) {
            return;
        }
        this.f488w = apnInfo;
        this.f487v = apnType;
    }

    /* JADX INFO: renamed from: d */
    private boolean m304d() {
        int i;
        String str;
        FileOutputStream fileOutputStreamM643b = FileUtil.m643b(this.f466a, true, "x5dl.lock");
        this.f480o = fileOutputStreamM643b;
        if (fileOutputStreamM643b != null) {
            FileLock fileLockM625a = FileUtil.m625a(this.f466a, fileOutputStreamM643b);
            this.f479n = fileLockM625a;
            if (fileLockM625a != null) {
                return true;
            }
            i = -2;
            str = "Other Process Downloading";
        } else {
            i = -1;
            str = "lock fos is null";
        }
        m300b(i, str);
        return false;
    }

    /* JADX INFO: renamed from: e */
    private void m305e() {
        FileUtil.m631a(this.f479n, this.f480o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public void m306f() {
        SharedPreferences sharedPreferences = TbsDownloadConfig.getInstance(this.f466a).mPreferences;
        if (sharedPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWLOAD_FLOWCTR, 0) == 1) {
            this.f468c = BuildConfig.FLAVOR;
            m300b(-20, "meet flow control.");
            return;
        }
        String string = sharedPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, BuildConfig.FLAVOR);
        this.f468c = string;
        if (BuildConfig.FLAVOR.equals(string)) {
            m300b(-20, "meet flow control.");
        } else {
            TbsLog.m665i("X5Downloader", "start delegate download progress...");
            this.f477l.download(this, this.f468c, this.f471f);
        }
    }

    /* JADX INFO: renamed from: g */
    private void m307g() {
        File file = this.f470e;
        if (file == null || !file.exists()) {
            return;
        }
        FileUtil.m645b(file);
    }

    /* JADX INFO: renamed from: h */
    private void m308h() {
        this.f490y = false;
        this.f478m = false;
        this.f489x = false;
        this.f481p = 0;
        this.f482q = 0;
        this.f483r = 30000;
        this.f484s = false;
        this.f485t = null;
        this.f486u = -1L;
    }

    /* JADX INFO: renamed from: i */
    private void m309i() {
        TbsDownloadConfig.getInstance(this.f466a).mPreferences.edit().putString(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, BuildConfig.FLAVOR).apply();
    }

    /* JADX INFO: renamed from: j */
    private void m310j() {
        m308h();
        TbsLog.m665i("X5Downloader", "download and verify x5 finished, prepare to install");
        if (this.f471f.exists()) {
            C0419m.m393a().m428a(this.f466a, this.f471f.getAbsolutePath(), this.f474i);
        }
        TbsLog.m665i("X5Downloader", "download and install finished.");
        onFinished();
    }

    public final void notifyDownloadFinished() {
        m295a(QbSdk.PrivateCDNMode.SELF_IMPL);
        if (m298a(true)) {
            m310j();
        } else {
            m300b(this.f464A, this.f465B);
        }
    }

    @Override // com.tencent.smtt.sdk.ProgressListener
    public void onProgress(int i) {
    }

    public final X5Downloader setConnectTimesOut(int i) {
        if (i > 0) {
            this.f476k = i;
            return this;
        }
        throw new IllegalArgumentException("can not set ConnectTimesOut <= 0, input is: " + i);
    }

    public final X5Downloader setDownloadDelegate(DownloadDelegate downloadDelegate) {
        m295a(QbSdk.PrivateCDNMode.SELF_IMPL);
        this.f477l = downloadDelegate;
        return this;
    }

    public final X5Downloader setDownloadUrl(String str) {
        if (str.contains("imtt.qq.com")) {
            throw new IllegalArgumentException("you can't set TBS official domain");
        }
        m295a(QbSdk.PrivateCDNMode.OFFICIAL_IMPL);
        this.f468c = str;
        return this;
    }

    public final X5Downloader setMaxRetryTimes(int i) {
        if (i > 0) {
            this.f475j = i;
            return this;
        }
        throw new IllegalArgumentException("can not set MaxRetryTimes <= 0, input is: " + i);
    }

    public final void startDownload() {
        if (this.f467b == QbSdk.PrivateCDNMode.SELF_IMPL && this.f477l == null) {
            throw new IllegalStateException("is SELF_IMPL mode, but delegate is null. Please set setDownloadDelegate()");
        }
        String str = this.f468c;
        if (str == null || str.equals(BuildConfig.FLAVOR)) {
            m300b(-18, "url is empty, [OFFICIAL_IMPL] plz setDownloadUrl. [SELF_IMPL] Maybe flow control.");
            return;
        }
        if (this.f474i == 0) {
            m300b(-19, "No config version, please check whether TbsVersionController.checkVersion is call. Need more help please contact with x5tbs@tencent.com");
            return;
        }
        if (QbSdk.getTbsVersion(this.f466a) != this.f474i && !m298a(true)) {
            Thread thread = new Thread() { // from class: com.tencent.smtt.sdk.X5Downloader.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    if (X5Downloader.this.f467b == QbSdk.PrivateCDNMode.SELF_IMPL) {
                        X5Downloader.this.m306f();
                    } else {
                        TbsLog.m665i("X5Downloader", "Delegate is null, try to start default download.");
                        X5Downloader.this.m292a();
                    }
                }
            };
            thread.setName("thread-x5dl");
            thread.start();
        } else {
            m310j();
            TbsLog.m665i("X5Downloader", "local version match, no need to download: " + this.f474i);
        }
    }
}
