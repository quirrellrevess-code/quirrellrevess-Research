package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* JADX INFO: renamed from: com.tencent.smtt.sdk.l */
/* JADX INFO: loaded from: classes.dex */
public class C0418l {

    /* JADX INFO: renamed from: a */
    private static C0418l f577a;

    /* JADX INFO: renamed from: b */
    private static Context f578b;

    private C0418l() {
    }

    /* JADX INFO: renamed from: a */
    public static C0418l m374a(Context context) {
        if (f577a == null) {
            synchronized (C0418l.class) {
                if (f577a == null) {
                    f577a = new C0418l();
                }
            }
        }
        f578b = context.getApplicationContext();
        return f577a;
    }

    /* JADX WARN: Code duplicated, block: B:67:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.Properties] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.Properties] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX INFO: renamed from: e */
    private Properties m375e() throws Throwable {
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream;
        ?? properties;
        Exception e;
        ?? bufferedInputStream2;
        ?? r0 = 0;
        try {
            try {
                try {
                    File fileM376a = m376a();
                    properties = new Properties();
                    if (fileM376a != null) {
                        try {
                            fileInputStream = new FileInputStream(fileM376a);
                            try {
                                bufferedInputStream2 = new BufferedInputStream(fileInputStream);
                                try {
                                    properties.load(bufferedInputStream2);
                                    r0 = bufferedInputStream2;
                                } catch (Exception e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    if (bufferedInputStream2 != 0) {
                                        try {
                                            bufferedInputStream2.close();
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    return properties;
                                }
                            } catch (Exception e5) {
                                bufferedInputStream2 = 0;
                                e = e5;
                            } catch (Throwable th) {
                                bufferedInputStream = null;
                                th = th;
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                                if (fileInputStream == null) {
                                    throw th;
                                }
                                try {
                                    fileInputStream.close();
                                    throw th;
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                    throw th;
                                }
                            }
                        } catch (Exception e8) {
                            e = e8;
                            fileInputStream = null;
                            properties = properties;
                            e = e;
                            bufferedInputStream2 = fileInputStream;
                            e.printStackTrace();
                            if (bufferedInputStream2 != 0) {
                                bufferedInputStream2.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return properties;
                        }
                    } else {
                        fileInputStream = null;
                    }
                    if (r0 != 0) {
                        try {
                            r0.close();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    return properties;
                } catch (Exception e11) {
                    e = e11;
                    properties = 0;
                    fileInputStream = null;
                }
            } catch (Throwable th2) {
                fileInputStream = null;
                th = th2;
                bufferedInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: renamed from: a */
    public File m376a() {
        File file = new File(C0419m.m411o(f578b), "tbscoreinstall.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return file;
    }

    /* JADX INFO: renamed from: a */
    public void m377a(int i) {
        m380a("dexopt_retry_num", i);
    }

    /* JADX INFO: renamed from: a */
    public void m378a(int i, int i2) {
        m380a("copy_core_ver", i);
        m380a("copy_status", i2);
    }

    /* JADX INFO: renamed from: a */
    public void m379a(String str) throws Throwable {
        m381a("install_apk_path", str);
    }

    /* JADX INFO: renamed from: a */
    public void m380a(String str, int i) {
        m381a(str, String.valueOf(i));
    }

    /* JADX INFO: renamed from: a */
    public void m381a(String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    Properties propertiesM375e = m375e();
                    if (propertiesM375e != null) {
                        propertiesM375e.setProperty(str, str2);
                        File fileM376a = m376a();
                        if (fileM376a != null) {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(fileM376a);
                            try {
                                propertiesM375e.store(fileOutputStream2, "update " + str + " and status!");
                                fileOutputStream = fileOutputStream2;
                            } catch (Exception e) {
                                e = e;
                                fileOutputStream = fileOutputStream2;
                                e.printStackTrace();
                                if (fileOutputStream == null) {
                                    return;
                                } else {
                                    fileOutputStream.close();
                                }
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: b */
    public int m382b() {
        return m387c("install_core_ver");
    }

    /* JADX INFO: renamed from: b */
    public int m383b(String str) {
        Properties propertiesM375e = m375e();
        if (propertiesM375e != null && propertiesM375e.getProperty(str) != null) {
            try {
                return Integer.parseInt(propertiesM375e.getProperty(str));
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: b */
    public void m384b(int i) {
        m380a("unzip_retry_num", i);
    }

    /* JADX INFO: renamed from: b */
    public void m385b(int i, int i2) {
        m380a("tpatch_ver", i);
        m380a("tpatch_status", i2);
    }

    /* JADX INFO: renamed from: c */
    public int m386c() {
        return m383b("install_status");
    }

    /* JADX INFO: renamed from: c */
    public int m387c(String str) throws Throwable {
        Properties propertiesM375e = m375e();
        if (propertiesM375e != null && propertiesM375e.getProperty(str) != null) {
            try {
                return Integer.parseInt(propertiesM375e.getProperty(str));
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    /* JADX INFO: renamed from: c */
    public void m388c(int i) {
        m380a("incrupdate_status", i);
    }

    /* JADX INFO: renamed from: c */
    public void m389c(int i, int i2) {
        m380a("install_core_ver", i);
        m380a("install_status", i2);
    }

    /* JADX INFO: renamed from: d */
    public int m390d() {
        return m383b("incrupdate_status");
    }

    /* JADX INFO: renamed from: d */
    public String m391d(String str) throws Throwable {
        Properties propertiesM375e = m375e();
        if (propertiesM375e == null || propertiesM375e.getProperty(str) == null) {
            return null;
        }
        return propertiesM375e.getProperty(str);
    }

    /* JADX INFO: renamed from: d */
    public void m392d(int i) {
        m380a("unlzma_status", i);
    }
}
