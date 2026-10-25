package com.tencent.smtt.utils;

import android.content.Context;
import com.tencent.smtt.sdk.QbSdk;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/* JADX INFO: renamed from: com.tencent.smtt.utils.p */
/* JADX INFO: loaded from: classes.dex */
public class C0459p {

    /* JADX INFO: renamed from: e */
    private static C0459p f840e;

    /* JADX INFO: renamed from: a */
    public boolean f841a;

    /* JADX INFO: renamed from: b */
    private Context f842b;

    /* JADX INFO: renamed from: c */
    private File f843c;

    /* JADX INFO: renamed from: d */
    private boolean f844d;

    /* JADX INFO: renamed from: a */
    public static synchronized C0459p m801a() {
        return f840e;
    }

    /* JADX INFO: renamed from: c */
    private File m802c() {
        try {
            if (this.f843c == null) {
                File file = new File(QbSdk.getTbsFolderDir(this.f842b), "core_private");
                this.f843c = file;
                if (file == null || !file.isDirectory()) {
                    return null;
                }
            }
            File file2 = new File(this.f843c, "debug.conf");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            return file2;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m803a(boolean z) {
        this.f844d = z;
        m804b();
    }

    /* JADX INFO: renamed from: b */
    public void m804b() {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        File fileM802c = m802c();
        if (fileM802c == null) {
            return;
        }
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(fileM802c));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    properties.setProperty("setting_forceUseSystemWebview", Boolean.toString(this.f841a));
                    properties.setProperty("result_systemWebviewForceUsed", Boolean.toString(this.f844d));
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileM802c));
                    try {
                        properties.store(bufferedOutputStream, (String) null);
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        bufferedOutputStream.close();
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            th.printStackTrace();
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            bufferedOutputStream.close();
                        } finally {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            try {
                                bufferedOutputStream.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = null;
                }
            } catch (Throwable th4) {
                bufferedInputStream = null;
                th = th4;
                bufferedOutputStream = null;
            }
        } catch (Exception e5) {
        }
    }
}
