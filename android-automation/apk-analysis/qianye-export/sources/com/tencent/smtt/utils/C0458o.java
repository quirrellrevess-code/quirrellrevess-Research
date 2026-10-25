package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.flexbox.BuildConfig;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

/* JADX INFO: renamed from: com.tencent.smtt.utils.o */
/* JADX INFO: loaded from: classes.dex */
public class C0458o {

    /* JADX INFO: renamed from: c */
    private static C0458o f832c;

    /* JADX INFO: renamed from: a */
    private Context f833a;

    /* JADX INFO: renamed from: b */
    private File f834b = null;

    /* JADX INFO: renamed from: d */
    private String f835d = "https://log.tbs.qq.com/ajax?c=pu&v=2&k=";

    /* JADX INFO: renamed from: e */
    private String f836e = "https://log.tbs.qq.com/ajax?c=pu&tk=";

    /* JADX INFO: renamed from: f */
    private String f837f = "https://log.tbs.qq.com/ajax?c=dl&k=";

    /* JADX INFO: renamed from: g */
    private String f838g = "https://cfg.imtt.qq.com/tbs?v=2&mk=";

    /* JADX INFO: renamed from: h */
    private String f839h = "https://log.tbs.qq.com/ajax?c=ul&v=2&k=";

    @TargetApi(11)
    private C0458o(Context context) {
        this.f833a = null;
        TbsLog.m672w("TbsCommonConfig", "TbsCommonConfig constructing...");
        this.f833a = context.getApplicationContext();
        m795f();
    }

    /* JADX INFO: renamed from: a */
    public static synchronized C0458o m793a() {
        return f832c;
    }

    /* JADX INFO: renamed from: a */
    public static synchronized C0458o m794a(Context context) {
        if (f832c == null) {
            f832c = new C0458o(context);
        }
        return f832c;
    }

    /* JADX INFO: renamed from: f */
    private synchronized void m795f() {
        BufferedInputStream bufferedInputStream = null;
        try {
            File fileM796g = m796g();
            if (fileM796g == null) {
                TbsLog.m662e("TbsCommonConfig", "Config file is null, default values will be applied");
                return;
            }
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(fileM796g));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream2);
                String property = properties.getProperty("pv_post_url", BuildConfig.FLAVOR);
                if (!BuildConfig.FLAVOR.equals(property)) {
                    this.f835d = property;
                }
                String property2 = properties.getProperty("tbs_download_stat_post_url", BuildConfig.FLAVOR);
                if (!BuildConfig.FLAVOR.equals(property2)) {
                    this.f837f = property2;
                }
                String property3 = properties.getProperty("tbs_downloader_post_url", BuildConfig.FLAVOR);
                TbsLog.m665i("TbsCommonConfig", "KEY_TBS_DOWNLOADER_POST_URL is " + property3);
                if (!BuildConfig.FLAVOR.equals(property3)) {
                    this.f838g = property3;
                }
                String property4 = properties.getProperty("tbs_log_post_url", BuildConfig.FLAVOR);
                if (!BuildConfig.FLAVOR.equals(property4)) {
                    this.f839h = property4;
                }
                String property5 = properties.getProperty("pv_post_url_tk", BuildConfig.FLAVOR);
                if (!BuildConfig.FLAVOR.equals(property5)) {
                    this.f836e = property5;
                }
                try {
                    bufferedInputStream2.close();
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                try {
                    StringWriter stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    TbsLog.m662e("TbsCommonConfig", "exceptions occurred1:" + stringWriter.toString());
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            e.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: renamed from: g */
    private File m796g() {
        File file = null;
        try {
            if (this.f834b == null) {
                if (!TextUtils.isEmpty(this.f833a.getApplicationContext().getApplicationInfo().packageName)) {
                    this.f834b = new File(FileUtil.m623a(this.f833a, 8));
                }
                File file2 = this.f834b;
                if (file2 == null || !file2.isDirectory()) {
                    return null;
                }
            }
            TbsLog.m665i("TbsCommonConfig", "mTbsConfigDir is " + this.f834b.getAbsolutePath());
            File file3 = new File(this.f834b, "tbsnet.conf");
            if (!file3.exists()) {
                TbsLog.m662e("TbsCommonConfig", "Get file(" + file3.getCanonicalPath() + ") failed!");
                return null;
            }
            try {
                TbsLog.m672w("TbsCommonConfig", "pathc:" + file3.getCanonicalPath());
                return file3;
            } catch (Throwable th) {
                th = th;
                file = file3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        TbsLog.m662e("TbsCommonConfig", "exceptions occurred2:" + stringWriter.toString());
        return file;
    }

    /* JADX INFO: renamed from: b */
    public String m797b() {
        return this.f835d;
    }

    /* JADX INFO: renamed from: c */
    public String m798c() {
        return this.f837f;
    }

    /* JADX INFO: renamed from: d */
    public String m799d() {
        return this.f838g;
    }

    /* JADX INFO: renamed from: e */
    public String m800e() {
        return this.f836e;
    }
}
