package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;
import com.google.android.flexbox.BuildConfig;
import com.tencent.smtt.sdk.TbsHandlerThread;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class TbsLog {
    public static final int MSG_PV_REPORT = 501;
    public static final String X5LOGTAG = "x5logtag";

    /* JADX INFO: renamed from: a */
    private static boolean f691a = true;

    /* JADX INFO: renamed from: b */
    private static Handler f692b;

    /* JADX INFO: renamed from: c */
    private static TbsLogClient f693c;

    /* JADX INFO: renamed from: d */
    public static void m659d(String str, String str2) {
        m660d(str, BuildConfig.FLAVOR, str2);
    }

    /* JADX INFO: renamed from: d */
    public static void m660d(String str, String str2, String str3) {
        TbsLogClient tbsLogClient = f693c;
    }

    /* JADX INFO: renamed from: d */
    public static void m661d(String str, String str2, boolean z) {
        m659d(str, str2);
        TbsLogClient tbsLogClient = f693c;
        if (tbsLogClient != null && f691a && z) {
            tbsLogClient.showLog(str + ": " + str2);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m662e(String str, String str2) {
        m663e(str, BuildConfig.FLAVOR, str2);
    }

    /* JADX INFO: renamed from: e */
    public static void m663e(String str, String str2, String str3) {
        TbsLogClient tbsLogClient = f693c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.m677e(str, "TBS:" + str2 + " " + str3);
        f693c.writeLog("(E)-" + str + "-TBS:" + str2 + " " + str3);
    }

    /* JADX INFO: renamed from: e */
    public static void m664e(String str, String str2, boolean z) {
        m662e(str, str2);
        TbsLogClient tbsLogClient = f693c;
        if (tbsLogClient != null && f691a && z) {
            tbsLogClient.showLog(str + ": " + str2);
        }
    }

    public static String getTbsLogFilePath() {
        File file = TbsLogClient.f695c;
        if (file != null) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public static Handler getTbsLogHandler() {
        return f692b;
    }

    /* JADX INFO: renamed from: i */
    public static void m665i(String str, String str2) {
        m666i(str, BuildConfig.FLAVOR, str2);
    }

    /* JADX INFO: renamed from: i */
    public static void m666i(String str, String str2, String str3) {
        TbsLogClient tbsLogClient = f693c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.m678i(str, "TBS:" + str2 + " " + str3);
        f693c.writeLog("(I)-" + str + "-TBS:" + str2 + " " + str3);
    }

    /* JADX INFO: renamed from: i */
    public static void m667i(String str, String str2, boolean z) {
        m665i(str, str2);
        TbsLogClient tbsLogClient = f693c;
        if (tbsLogClient != null && f691a && z) {
            tbsLogClient.showLog(str + ": " + str2);
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m668i(Throwable th) {
        m665i("handle_throwable", Log.getStackTraceString(th));
    }

    public static synchronized void initIfNeed(Context context) {
        if (f693c == null) {
            setTbsLogClient(new TbsLogClient(context));
        }
        if (f692b == null) {
            f692b = new Handler(TbsHandlerThread.getInstance().getLooper()) { // from class: com.tencent.smtt.utils.TbsLog.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    int i = message.what;
                    if (i == 500) {
                        if (TbsLog.f693c != null) {
                            TbsLog.f693c.writeLogToDisk();
                        }
                    } else if (i == 501) {
                        Object obj = message.obj;
                        if (obj instanceof Runnable) {
                            ((Runnable) obj).run();
                        }
                    }
                }
            };
        }
    }

    public static void setLogView(TextView textView) {
        TbsLogClient tbsLogClient;
        if (textView == null || (tbsLogClient = f693c) == null) {
            return;
        }
        tbsLogClient.setLogView(textView);
    }

    public static boolean setTbsLogClient(TbsLogClient tbsLogClient) {
        if (tbsLogClient == null) {
            return false;
        }
        f693c = tbsLogClient;
        return true;
    }

    @Deprecated
    public static void setWriteLogJIT(boolean z) {
        TbsLogClient tbsLogClient = f693c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.setWriteLogJIT(z);
    }

    /* JADX INFO: renamed from: v */
    public static void m669v(String str, String str2) {
        m670v(str, BuildConfig.FLAVOR, str2);
    }

    /* JADX INFO: renamed from: v */
    public static void m670v(String str, String str2, String str3) {
        TbsLogClient tbsLogClient = f693c;
    }

    /* JADX INFO: renamed from: v */
    public static void m671v(String str, String str2, boolean z) {
        m669v(str, str2);
        TbsLogClient tbsLogClient = f693c;
        if (tbsLogClient != null && f691a && z) {
            tbsLogClient.showLog(str + ": " + str2);
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m672w(String str, String str2) {
        m673w(str, BuildConfig.FLAVOR, str2);
    }

    /* JADX INFO: renamed from: w */
    public static void m673w(String str, String str2, String str3) {
        TbsLogClient tbsLogClient = f693c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.m680w(str, "TBS:" + str2 + " " + str3);
        f693c.writeLog("(W)-" + str + "-TBS:" + str2 + " " + str3);
    }

    /* JADX INFO: renamed from: w */
    public static void m674w(String str, String str2, boolean z) {
        m672w(str, str2);
        TbsLogClient tbsLogClient = f693c;
        if (tbsLogClient != null && f691a && z) {
            tbsLogClient.showLog(str + ": " + str2);
        }
    }

    public static synchronized void writeLogToDisk() {
        Handler handler;
        if (f693c != null && (handler = f692b) != null) {
            handler.obtainMessage(500).sendToTarget();
        }
    }
}
