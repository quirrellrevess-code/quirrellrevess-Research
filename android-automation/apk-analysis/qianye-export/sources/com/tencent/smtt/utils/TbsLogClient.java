package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.widget.TextView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class TbsLogClient {

    /* JADX INFO: renamed from: a */
    public static TbsLogClient f694a;

    /* JADX INFO: renamed from: c */
    public static File f695c;

    /* JADX INFO: renamed from: d */
    public static String f696d;

    /* JADX INFO: renamed from: e */
    public static byte[] f697e;

    /* JADX INFO: renamed from: b */
    public TextView f698b;

    /* JADX INFO: renamed from: f */
    private SimpleDateFormat f699f;

    /* JADX INFO: renamed from: g */
    private Context f700g;

    /* JADX INFO: renamed from: h */
    private StringBuffer f701h = new StringBuffer();

    /* JADX INFO: renamed from: i */
    private boolean f702i = false;

    /* JADX INFO: renamed from: com.tencent.smtt.utils.TbsLogClient$a */
    public class RunnableC0442a implements Runnable {

        /* JADX INFO: renamed from: a */
        public String f703a;

        public RunnableC0442a(String str) {
            this.f703a = null;
            this.f703a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            TextView textView = TbsLogClient.this.f698b;
            if (textView != null) {
                textView.append(this.f703a + "\n");
            }
        }
    }

    public TbsLogClient(Context context) {
        this.f699f = null;
        this.f700g = null;
        try {
            this.f700g = context.getApplicationContext();
            this.f699f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS", Locale.US);
        } catch (Exception unused) {
            this.f699f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        }
    }

    /* JADX INFO: renamed from: a */
    private void m675a() {
        try {
            if (f695c == null) {
                String strM623a = FileUtil.m623a(this.f700g, 6);
                if (strM623a == null) {
                    f695c = null;
                } else {
                    f695c = new File(strM623a, "tbslog.txt");
                    f696d = LogFileUtils.createKey();
                    f697e = LogFileUtils.createHeaderText(f695c.getName(), f696d);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (SecurityException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: d */
    public void m676d(String str, String str2) {
    }

    /* JADX INFO: renamed from: e */
    public void m677e(String str, String str2) {
    }

    /* JADX INFO: renamed from: i */
    public void m678i(String str, String str2) {
    }

    public void setLogView(TextView textView) {
        this.f698b = textView;
    }

    public void setWriteLogJIT(boolean z) {
        this.f702i = z;
    }

    public void showLog(String str) {
        TextView textView = this.f698b;
        if (textView != null) {
            textView.post(new RunnableC0442a(str));
        }
    }

    /* JADX INFO: renamed from: v */
    public void m679v(String str, String str2) {
    }

    /* JADX INFO: renamed from: w */
    public void m680w(String str, String str2) {
    }

    public void writeLog(String str) {
        try {
            StringBuffer stringBuffer = this.f701h;
            stringBuffer.append(System.currentTimeMillis());
            stringBuffer.append(" pid=");
            stringBuffer.append(Process.myPid());
            stringBuffer.append(" tid=");
            stringBuffer.append(Process.myTid());
            stringBuffer.append(str);
            stringBuffer.append("\n");
            if (Thread.currentThread() != Looper.getMainLooper().getThread() || this.f702i) {
                writeLogToDisk();
            }
            if (this.f701h.length() > 524288) {
                StringBuffer stringBuffer2 = this.f701h;
                stringBuffer2.delete(0, stringBuffer2.length());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeLogToDisk() {
        try {
            m675a();
            File file = f695c;
            if (file != null) {
                LogFileUtils.writeDataToStorage(file, f696d, f697e, this.f701h.toString(), true);
                StringBuffer stringBuffer = this.f701h;
                stringBuffer.delete(0, stringBuffer.length());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
