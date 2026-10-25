package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.flexbox.BuildConfig;
import com.tencent.smtt.utils.Base64;
import com.tencent.smtt.utils.C0445b;
import com.tencent.smtt.utils.C0450g;
import com.tencent.smtt.utils.C0455l;
import com.tencent.smtt.utils.C0458o;
import com.tencent.smtt.utils.TbsLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class TbsLogReport {

    /* JADX INFO: renamed from: a */
    private static TbsLogReport f323a;

    /* JADX INFO: renamed from: b */
    private Handler f324b;

    /* JADX INFO: renamed from: c */
    private final Map<EventType, Boolean> f325c;

    /* JADX INFO: renamed from: d */
    private final Context f326d;

    /* JADX INFO: renamed from: e */
    private boolean f327e = false;

    public enum EventType {
        TYPE_DOWNLOAD(0),
        TYPE_INSTALL(1),
        TYPE_LOAD(2),
        TYPE_CDN_DOWNLOAD_STAT(3),
        TYPE_COOKIE_DB_SWITCH(4),
        TYPE_PV_UPLOAD_STAT(5),
        TYPE_CORE_LOAD_PERFORMANCE(6),
        TYPE_CORE_PROTECT_RESET(7);


        /* JADX INFO: renamed from: a */
        public int f331a;

        EventType(int i) {
            this.f331a = i;
        }
    }

    public static class TbsLogInfo implements Cloneable {

        /* JADX INFO: renamed from: a */
        public int f332a;

        /* JADX INFO: renamed from: b */
        private long f333b;

        /* JADX INFO: renamed from: c */
        private String f334c;

        /* JADX INFO: renamed from: d */
        private String f335d;

        /* JADX INFO: renamed from: e */
        private int f336e;

        /* JADX INFO: renamed from: f */
        private int f337f;

        /* JADX INFO: renamed from: g */
        private int f338g;

        /* JADX INFO: renamed from: h */
        private int f339h;

        /* JADX INFO: renamed from: i */
        private String f340i;

        /* JADX INFO: renamed from: j */
        private int f341j;

        /* JADX INFO: renamed from: k */
        private int f342k;

        /* JADX INFO: renamed from: l */
        private long f343l;

        /* JADX INFO: renamed from: m */
        private long f344m;

        /* JADX INFO: renamed from: n */
        private int f345n;

        /* JADX INFO: renamed from: o */
        private String f346o;

        /* JADX INFO: renamed from: p */
        private String f347p;

        /* JADX INFO: renamed from: q */
        private long f348q;

        private TbsLogInfo() {
            resetArgs();
        }

        public Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException unused) {
                return this;
            }
        }

        public int getDownFinalFlag() {
            return this.f342k;
        }

        public void resetArgs() {
            this.f333b = 0L;
            this.f334c = null;
            this.f335d = null;
            this.f336e = 0;
            this.f337f = 0;
            this.f338g = 0;
            this.f339h = 2;
            this.f340i = "unknown";
            this.f341j = 0;
            this.f342k = 2;
            this.f343l = 0L;
            this.f344m = 0L;
            this.f345n = 1;
            this.f332a = 0;
            this.f346o = null;
            this.f347p = null;
            this.f348q = 0L;
        }

        public void setApn(String str) {
            this.f340i = str;
        }

        public void setCheckErrorDetail(String str) {
            setErrorCode(108);
            this.f346o = str;
        }

        public void setDownConsumeTime(long j) {
            this.f344m += j;
        }

        public void setDownFinalFlag(int i) {
            this.f342k = i;
        }

        public void setDownloadCancel(int i) {
            this.f338g = i;
        }

        public void setDownloadSize(long j) {
            this.f348q += j;
        }

        public void setDownloadUrl(String str) {
            if (this.f334c != null) {
                str = this.f334c + ";" + str;
            }
            this.f334c = str;
        }

        public void setErrorCode(int i) {
            if (i != 100 && i != 110 && i != 120 && i != 111 && i < 400) {
                TbsLog.m667i(TbsDownloader.LOGTAG, "error occured, errorCode:" + i, true);
            }
            if (i == 111) {
                TbsLog.m667i(TbsDownloader.LOGTAG, "you are not in wifi, downloading stoped", true);
            }
            this.f332a = i;
        }

        public void setEventTime(long j) {
            this.f333b = j;
        }

        public void setFailDetail(String str) {
            if (str == null) {
                return;
            }
            if (str.length() > 1024) {
                str = str.substring(0, 1024);
            }
            this.f347p = str;
        }

        public void setFailDetail(Throwable th) {
            if (th == null) {
                this.f347p = BuildConfig.FLAVOR;
                return;
            }
            String stackTraceString = Log.getStackTraceString(th);
            if (stackTraceString.length() > 1024) {
                stackTraceString = stackTraceString.substring(0, 1024);
            }
            this.f347p = stackTraceString;
        }

        public void setHttpCode(int i) {
            this.f336e = i;
        }

        public void setNetworkChange(int i) {
            this.f345n = i;
        }

        public void setNetworkType(int i) {
            this.f341j = i;
        }

        public void setPatchUpdateFlag(int i) {
            this.f337f = i;
        }

        public void setPkgSize(long j) {
            this.f343l = j;
        }

        public void setResolveIp(String str) {
            this.f335d = str;
        }

        public void setUnpkgFlag(int i) {
            this.f339h = i;
        }

        public String toString() {
            return "TbsLogInfo{mEventTime=" + this.f333b + ", mResolveIp='" + this.f335d + "', mHttpCode=" + this.f336e + ", mDownloadCancel=" + this.f338g + ", mNetworkType=" + this.f341j + ", mDownConsumeTime=" + this.f344m + ", mErrorCode=" + this.f332a + ", mCheckErrorDetail='" + this.f346o + "', mFailDetail='" + this.f347p + "'}";
        }
    }

    private TbsLogReport(Context context) {
        this.f324b = null;
        this.f326d = context.getApplicationContext();
        this.f325c = TbsPVConfig.getInstance(context).getLogReportSwitchMap();
        this.f324b = new Handler(TbsHandlerThread.getInstance().getLooper()) { // from class: com.tencent.smtt.sdk.TbsLogReport.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i != 600) {
                    if (i == 601) {
                        TbsLogReport.this.m211b();
                        return;
                    }
                    return;
                }
                Object obj = message.obj;
                if (obj instanceof TbsLogInfo) {
                    try {
                        int i2 = message.arg1;
                        TbsLogReport.this.m205a(i2, (TbsLogInfo) obj);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    /* JADX INFO: renamed from: a */
    private String m201a(int i) {
        return i + "|";
    }

    /* JADX INFO: renamed from: a */
    private String m202a(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j));
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private String m203a(String str) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        sb.append(str);
        sb.append("|");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    private JSONArray m204a() {
        String string = m214d().getString("tbs_tbslogreport_upload", null);
        if (string != null) {
            try {
                string = new String(Base64.m612a(string, 2));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (string == null) {
            return new JSONArray();
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() <= 5) {
                return jSONArray;
            }
            JSONArray jSONArray2 = new JSONArray();
            int length = jSONArray.length();
            while (true) {
                length--;
                if (length < jSONArray.length() - 5) {
                    return jSONArray2;
                }
                jSONArray2.put(jSONArray.get(length));
            }
        } catch (Exception unused) {
            return new JSONArray();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m205a(int i, TbsLogInfo tbsLogInfo) {
        Map<String, Object> map = QbSdk.f210o;
        if (map != null && map.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.f210o.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.m665i("TbsLogReport", "[TbsLogReport.sendLogReportRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(m201a(i));
        sb.append(m203a(BuildConfig.FLAVOR));
        sb.append(m203a(C0455l.m774a(this.f326d)));
        sb.append(m201a(C0419m.m393a().m445g(this.f326d)));
        sb.append(m203a(BuildConfig.FLAVOR));
        String packageName = this.f326d.getPackageName();
        sb.append(m203a(packageName));
        sb.append(TbsConfig.APP_WX.equals(packageName) ? m203a(C0445b.m691a(this.f326d, TbsDownloader.TBS_METADATA)) : m201a(C0445b.m698b(this.f326d)));
        sb.append(m203a(m202a(tbsLogInfo.f333b)));
        sb.append(m203a(tbsLogInfo.f334c));
        sb.append(m203a(tbsLogInfo.f335d));
        sb.append(m201a(tbsLogInfo.f336e));
        sb.append(m201a(tbsLogInfo.f337f));
        sb.append(m201a(tbsLogInfo.f338g));
        sb.append(m201a(tbsLogInfo.f339h));
        sb.append(m203a(tbsLogInfo.f340i));
        sb.append(m201a(tbsLogInfo.f341j));
        sb.append(m201a(tbsLogInfo.f342k));
        sb.append(m210b(tbsLogInfo.f348q));
        sb.append(m210b(tbsLogInfo.f343l));
        sb.append(m210b(tbsLogInfo.f344m));
        sb.append(m201a(tbsLogInfo.f345n));
        sb.append(m201a(tbsLogInfo.f332a));
        sb.append(m203a(tbsLogInfo.f346o));
        sb.append(m203a(tbsLogInfo.f347p));
        sb.append(m201a(TbsDownloadConfig.getInstance(this.f326d).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0)));
        sb.append(m203a(C0445b.m707g(this.f326d)));
        sb.append(m203a("44286"));
        sb.append(false);
        SharedPreferences sharedPreferencesM214d = m214d();
        JSONArray jSONArrayM204a = m204a();
        jSONArrayM204a.put(sb.toString());
        SharedPreferences.Editor editorEdit = sharedPreferencesM214d.edit();
        String string = jSONArrayM204a.toString();
        try {
            string = Base64.encodeToString(string.getBytes(), 2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        editorEdit.putString("tbs_tbslogreport_upload", string);
        editorEdit.commit();
        if (this.f327e) {
            m211b();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m206a(int i, TbsLogInfo tbsLogInfo, EventType eventType) {
        tbsLogInfo.setErrorCode(i);
        tbsLogInfo.setEventTime(System.currentTimeMillis());
        QbSdk.f209n.onInstallFinish(i);
        eventReport(eventType, tbsLogInfo);
    }

    /* JADX INFO: renamed from: a */
    private void m207a(int i, String str) {
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setErrorCode(i);
        tbsLogInfo.setEventTime(System.currentTimeMillis());
        tbsLogInfo.setFailDetail(str);
        eventReport(EventType.TYPE_LOAD, tbsLogInfo);
    }

    /* JADX INFO: renamed from: b */
    private String m210b(long j) {
        return j + "|";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m211b() {
        String str;
        String str2;
        Map<String, Object> map = QbSdk.f210o;
        if (map != null && map.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.f210o.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            str = "TbsLogReport";
            str2 = "[TbsLogReport.sendLogReportRequest] -- SET_SENDREQUEST_AND_UPLOAD is false";
        } else {
            str = TbsDownloader.LOGTAG;
            TbsLog.m665i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat]");
            JSONArray jSONArrayM204a = m204a();
            if (jSONArrayM204a != null && jSONArrayM204a.length() != 0) {
                TbsLog.m665i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] jsonArray:" + jSONArrayM204a);
                try {
                    TbsLog.m665i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] response:" + C0450g.m740a(C0458o.m794a(this.f326d).m798c(), jSONArrayM204a.toString().getBytes("utf-8"), new C0450g.a() { // from class: com.tencent.smtt.sdk.TbsLogReport.2
                        @Override // com.tencent.smtt.utils.C0450g.a
                        /* JADX INFO: renamed from: a */
                        public void mo200a(int i) {
                            TbsLog.m665i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:" + i);
                            if (i < 300) {
                                TbsLogReport.this.m213c();
                            }
                        }
                    }, true) + " testcase: -1");
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            str2 = "[TbsApkDownloadStat.reportDownloadStat] no data";
        }
        TbsLog.m665i(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public void m213c() {
        SharedPreferences.Editor editorEdit = m214d().edit();
        editorEdit.remove("tbs_tbslogreport_upload");
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: d */
    private SharedPreferences m214d() {
        return this.f326d.getSharedPreferences("tbs_event_stat", 4);
    }

    public static TbsLogReport getInstance(Context context) {
        if (f323a == null) {
            synchronized (TbsLogReport.class) {
                if (f323a == null) {
                    f323a = new TbsLogReport(context);
                }
            }
        }
        return f323a;
    }

    public void clear() {
        try {
            SharedPreferences.Editor editorEdit = m214d().edit();
            editorEdit.clear();
            editorEdit.commit();
        } catch (Exception unused) {
        }
    }

    public void dailyReport() {
        this.f324b.sendEmptyMessage(601);
    }

    public void eventReport(EventType eventType, TbsLogInfo tbsLogInfo) {
        TbsLog.m665i("TbsLogReport", "[TbsLogReport.eventRepost] " + eventType + ": " + tbsLogInfo);
        Boolean bool = this.f325c.get(eventType);
        if (bool == null || !bool.booleanValue()) {
            return;
        }
        TbsLog.m665i("TbsLogReport", "[TbsLogReport.eventRepost] needReport!");
        try {
            TbsLogInfo tbsLogInfo2 = (TbsLogInfo) tbsLogInfo.clone();
            Message messageObtainMessage = this.f324b.obtainMessage();
            messageObtainMessage.what = 600;
            messageObtainMessage.arg1 = eventType.f331a;
            messageObtainMessage.obj = tbsLogInfo2;
            this.f324b.sendMessage(messageObtainMessage);
        } catch (Throwable th) {
            TbsLog.m672w("TbsLogReport", "[TbsLogReport.eventReport] error, message=" + th.getMessage());
        }
    }

    public boolean getShouldUploadEventReport() {
        return this.f327e;
    }

    public void setInstallErrorCode(int i, String str) {
        setInstallErrorCode(i, str, EventType.TYPE_INSTALL);
    }

    public void setInstallErrorCode(int i, String str, EventType eventType) {
        if (i != 200 && i != 220 && i != 221) {
            TbsLog.m667i(TbsDownloader.LOGTAG, "error occured in installation, errorCode:" + i, true);
        }
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setFailDetail(str);
        m206a(i, tbsLogInfo, eventType);
    }

    public void setInstallErrorCode(int i, Throwable th) {
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setFailDetail(th);
        m206a(i, tbsLogInfo, EventType.TYPE_INSTALL);
    }

    public void setLoadErrorCode(int i, Throwable th) {
        String strSubstring;
        if (th != null) {
            strSubstring = "msg: " + th.getMessage() + "; err: " + th + "; cause: " + Log.getStackTraceString(th.getCause());
            if (strSubstring.length() > 1024) {
                strSubstring = strSubstring.substring(0, 1024);
            }
        } else {
            strSubstring = "NULL";
        }
        m207a(i, strSubstring);
    }

    public void setShouldUploadEventReport(boolean z) {
        this.f327e = z;
    }

    public TbsLogInfo tbsLogInfo() {
        return new TbsLogInfo();
    }
}
