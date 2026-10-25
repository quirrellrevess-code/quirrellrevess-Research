package com.tencent.smtt.sdk;

import android.content.Context;
import com.google.android.flexbox.BuildConfig;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import okhttp3.internal.cache.DiskLruCache;

/* JADX INFO: renamed from: com.tencent.smtt.sdk.f */
/* JADX INFO: loaded from: classes.dex */
public class C0412f {

    /* JADX INFO: renamed from: a */
    public static int f512a = 0;

    /* JADX INFO: renamed from: b */
    public static boolean f513b = false;

    /* JADX INFO: renamed from: e */
    private static C0412f f514e = null;

    /* JADX INFO: renamed from: h */
    private static int f515h = 0;

    /* JADX INFO: renamed from: j */
    private static int f516j = 3;

    /* JADX INFO: renamed from: l */
    private static String f517l;

    /* JADX INFO: renamed from: c */
    private C0425s f518c = null;

    /* JADX INFO: renamed from: d */
    private C0425s f519d = null;

    /* JADX INFO: renamed from: f */
    private boolean f520f = false;

    /* JADX INFO: renamed from: g */
    private boolean f521g = false;

    /* JADX INFO: renamed from: i */
    private String f522i = BuildConfig.FLAVOR;

    /* JADX INFO: renamed from: k */
    private File f523k = null;

    private C0412f() {
    }

    /* JADX INFO: renamed from: a */
    public static C0412f m323a(boolean z) {
        if (f514e == null && z) {
            synchronized (C0412f.class) {
                if (f514e == null) {
                    f514e = new C0412f();
                }
            }
        }
        return f514e;
    }

    /* JADX INFO: renamed from: a */
    public static void m324a(int i) {
        f515h = i;
    }

    /* JADX INFO: renamed from: b */
    private void m325b(int i) {
        FileOutputStream fileOutputStream;
        IOException e;
        FileNotFoundException e2;
        String strValueOf = String.valueOf(i);
        Properties properties = new Properties();
        properties.setProperty(f517l, strValueOf);
        try {
            fileOutputStream = new FileOutputStream(new File(this.f523k, "count.prop"));
            try {
                properties.store(fileOutputStream, (String) null);
            } catch (FileNotFoundException e3) {
                e2 = e3;
                e2.printStackTrace();
            } catch (IOException e4) {
                e = e4;
                e.printStackTrace();
            }
        } catch (FileNotFoundException e5) {
            fileOutputStream = null;
            e2 = e5;
        } catch (IOException e6) {
            fileOutputStream = null;
            e = e6;
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public static int m326d() {
        return f515h;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0054: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:27:0x0054 */
    /* JADX INFO: renamed from: j */
    private int m327j() throws Throwable {
        BufferedInputStream bufferedInputStream;
        Exception e;
        BufferedInputStream bufferedInputStream2;
        BufferedInputStream bufferedInputStream3 = null;
        try {
            try {
                File file = new File(this.f523k, "count.prop");
                if (!file.exists()) {
                    return 0;
                }
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    int iIntValue = Integer.valueOf(properties.getProperty(f517l, DiskLruCache.VERSION_1)).intValue();
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return iIntValue;
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                bufferedInputStream = null;
                e = e4;
            } catch (Throwable th) {
                th = th;
                if (bufferedInputStream3 != null) {
                    try {
                        bufferedInputStream3.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream3 = bufferedInputStream2;
            if (bufferedInputStream3 != null) {
                bufferedInputStream3.close();
            }
            throw th;
        }
        e.printStackTrace();
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException e6) {
                e6.printStackTrace();
            }
        }
        return 0;
    }

    /* JADX INFO: renamed from: a */
    public C0425s m328a() {
        if (this.f520f) {
            return this.f518c;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m329a(Context context, boolean z, boolean z2) {
        TbsLog.initIfNeed(context);
        f512a++;
        TbsLog.m666i("SDKEngine", "init", "#1# context: " + context + ", mInitCount: " + f512a);
        if (this.f520f) {
            return;
        }
        C0419m.m393a().m435b(context, f512a == 1);
        C0419m.m393a().m447i(context);
        boolean zM154a = QbSdk.m154a(context, z, z2);
        TbsLog.m666i("SDKEngine", "init", "#2# canLoadX5 is " + zM154a);
        if (zM154a) {
            TbsLog.m666i("SDKEngine", "init", "#3# start to load tbs");
            try {
                File fileM452n = C0419m.m393a().m452n(context);
                Context applicationContext = context.getApplicationContext() != null ? context.getApplicationContext() : context;
                if (fileM452n == null) {
                    this.f520f = false;
                    this.f522i = "false03";
                    TbsCoreLoadStat.getInstance().m176a(context, TbsListener.ErrorCode.ERROR_TBSCORE_SHARE_DIR, new Throwable());
                    QbSdk.m149a(context, "SDKEngine::useSystemWebView by tbs_core_share_dir null!");
                    return;
                }
                String[] dexLoaderFileList = QbSdk.getDexLoaderFileList(context, applicationContext, fileM452n.getAbsolutePath());
                for (int i = 0; i < dexLoaderFileList.length; i++) {
                    TbsLog.m665i("SDKEngine", "dexLoaderFileList[" + i + "]: " + dexLoaderFileList[i]);
                }
                String absolutePath = fileM452n.getAbsolutePath();
                TbsLog.m666i("SDKEngine", "init", "#4# optDir is " + absolutePath);
                C0425s c0425s = this.f519d;
                if (c0425s != null) {
                    this.f518c = c0425s;
                    c0425s.m495a(context, applicationContext, fileM452n.getAbsolutePath(), absolutePath, dexLoaderFileList, QbSdk.f199d);
                } else {
                    this.f518c = new C0425s(context, applicationContext, fileM452n.getAbsolutePath(), absolutePath, dexLoaderFileList, QbSdk.f199d);
                }
                this.f520f = true;
                this.f522i = "true01";
            } catch (Throwable th) {
                TbsLog.m662e("SDKEngine", "useSystemWebView by exception: " + th);
                TbsCoreLoadStat.getInstance().m176a(context, TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE, th);
                this.f520f = false;
                this.f522i = "false04";
                QbSdk.m149a(context, "SDKEngine::useSystemWebView by exception: " + th);
            }
        } else if (!QbSdk.f196a || !this.f520f) {
            this.f520f = false;
            this.f522i = "false05";
            TbsLog.m663e("SDKEngine", "init", "[LoadError] check log upon for details");
        }
        this.f523k = C0419m.m411o(context);
        this.f521g = true;
    }

    /* JADX INFO: renamed from: a */
    public void m330a(String str) {
        f517l = str;
    }

    /* JADX INFO: renamed from: b */
    public boolean m331b() {
        return this.f520f;
    }

    /* JADX INFO: renamed from: b */
    public boolean m332b(boolean z) {
        f513b = z;
        return z;
    }

    /* JADX INFO: renamed from: c */
    public C0425s m333c() {
        return this.f518c;
    }

    /* JADX INFO: renamed from: e */
    public String m334e() {
        C0425s c0425s = this.f518c;
        return (c0425s == null || QbSdk.f196a) ? "system webview get nothing..." : c0425s.m493a();
    }

    /* JADX INFO: renamed from: f */
    public String m335f() {
        C0425s c0425s = this.f518c;
        return (c0425s == null || QbSdk.f196a) ? "system webview get nothing..." : c0425s.m497b();
    }

    /* JADX INFO: renamed from: g */
    public boolean m336g() throws Throwable {
        if (f513b) {
            if (f517l == null) {
                return false;
            }
            int iM327j = m327j();
            if (iM327j == 0) {
                m325b(1);
            } else {
                int i = iM327j + 1;
                if (i > f516j) {
                    return false;
                }
                m325b(i);
            }
        }
        return f513b;
    }

    /* JADX INFO: renamed from: h */
    public boolean m337h() {
        return this.f521g;
    }

    /* JADX INFO: renamed from: i */
    public boolean m338i() {
        return QbSdk.useSoftWare();
    }
}
