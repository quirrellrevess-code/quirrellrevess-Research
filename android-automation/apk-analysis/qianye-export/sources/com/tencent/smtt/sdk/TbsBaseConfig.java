package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.google.android.flexbox.BuildConfig;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class TbsBaseConfig {
    public static final String TAG = "TbsBaseConfig";

    /* JADX INFO: renamed from: a */
    public Map<String, String> f285a;

    /* JADX INFO: renamed from: b */
    private Context f286b;

    /* JADX INFO: renamed from: a */
    private static File m174a(Context context, String str) {
        C0419m.m393a();
        File fileM411o = C0419m.m411o(context);
        if (fileM411o == null) {
            return null;
        }
        File file = new File(fileM411o, str);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void clear() {
        this.f285a.clear();
        commit();
    }

    public synchronized void commit() {
        writeTbsDownloadInfo();
    }

    public abstract String getConfigFileName();

    public Map<String, String> getPVCLocal() {
        return this.f285a;
    }

    public void init(Context context) {
        this.f285a = new HashMap();
        Context applicationContext = context.getApplicationContext();
        this.f286b = applicationContext;
        if (applicationContext == null) {
            this.f286b = context;
        }
        refreshSyncMap(context);
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public synchronized void refreshSyncMap(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        String str;
        String str2;
        try {
            File fileM174a = m174a(this.f286b, getConfigFileName());
            TbsLog.m665i(TAG, "refreshSyncMap propFile is " + fileM174a);
            try {
                if (fileM174a == null) {
                    return;
                }
                this.f285a.clear();
                bufferedInputStream = new BufferedInputStream(new FileInputStream(fileM174a));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    for (String str3 : properties.stringPropertyNames()) {
                        this.f285a.put(str3, properties.getProperty(str3));
                    }
                    TbsLog.m665i(TAG, "refreshSyncMap pv mSyncMap is " + this.f285a.toString());
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e) {
                        str = TAG;
                        str2 = "refreshSyncMap stack is " + Log.getStackTraceString(e);
                        TbsLog.m665i(str, str2);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    TbsLog.m665i(TAG, "refreshSyncMap stack is " + Log.getStackTraceString(th));
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e2) {
                            str = TAG;
                            str2 = "refreshSyncMap stack is " + Log.getStackTraceString(e2);
                            TbsLog.m665i(str, str2);
                        }
                    }
                }
                TbsLog.m665i(TAG, "refreshSyncMap stack is " + Log.getStackTraceString(th));
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
            } catch (Throwable th3) {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e3) {
                        TbsLog.m665i(TAG, "refreshSyncMap stack is " + Log.getStackTraceString(e3));
                    }
                }
                throw th3;
            }
        } catch (Throwable th4) {
            bufferedInputStream = null;
            th = th4;
        }
    }

    public void update(Map<String, String> map) {
        this.f285a.clear();
        this.f285a.putAll(map);
        commit();
    }

    /* JADX WARN: Code duplicated, block: B:39:0x014d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:69:0x0192 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x014f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x012e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:? A[Catch: all -> 0x01b2, SYNTHETIC, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:16:0x00c6, B:20:0x00e5, B:23:0x00eb, B:24:0x0102, B:19:0x00cb, B:35:0x012e, B:40:0x014f, B:43:0x0154, B:38:0x0133, B:49:0x0171, B:54:0x0192, B:58:0x01b1, B:57:0x0197, B:52:0x0176, B:33:0x0112), top: B:62:0x0001, inners: #1, #2, #4, #6, #7, #8, #9 }] */
    public synchronized void writeTbsDownloadInfo() {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        String str;
        String str2;
        TbsLog.m665i(TAG, "writeTbsDownloadInfo #1");
        BufferedInputStream bufferedInputStream = null;
        try {
            File fileM174a = m174a(this.f286b, getConfigFileName());
            TbsLog.m665i(TAG, "writeTbsDownloadInfo propFile is " + fileM174a);
            try {
                if (fileM174a == null) {
                    return;
                }
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(fileM174a));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream2);
                    properties.clear();
                    Set<String> setKeySet = this.f285a.keySet();
                    TbsLog.m665i(TAG, "writeTbsDownloadInfo mSyncMap.size() is " + this.f285a.size());
                    for (String str3 : setKeySet) {
                        String str4 = this.f285a.get(str3);
                        properties.setProperty(str3, BuildConfig.FLAVOR + ((Object) str4));
                        TbsLog.m665i(TAG, "writeTbsDownloadInfo key is " + str3 + " value is " + ((Object) str4));
                    }
                    this.f285a.clear();
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileM174a));
                    try {
                        properties.store(bufferedOutputStream, (String) null);
                        TbsLog.m665i(TAG, "writeTbsDownloadInfo end ");
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception e) {
                            TbsLog.m665i(TAG, "writeTbsDownloadInfo stack is " + Log.getStackTraceString(e));
                        }
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception e2) {
                            str = TAG;
                            str2 = "writeTbsDownloadInfo stack is " + Log.getStackTraceString(e2);
                            TbsLog.m665i(str, str2);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream = bufferedInputStream2;
                        TbsLog.m665i(TAG, "writeTbsDownloadInfo stack is " + Log.getStackTraceString(th));
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e3) {
                                TbsLog.m665i(TAG, "writeTbsDownloadInfo stack is " + Log.getStackTraceString(e3));
                            }
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (Exception e4) {
                                    str = TAG;
                                    str2 = "writeTbsDownloadInfo stack is " + Log.getStackTraceString(e4);
                                    TbsLog.m665i(str, str2);
                                }
                            }
                        } else if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = null;
                }
                TbsLog.m665i(TAG, "writeTbsDownloadInfo stack is " + Log.getStackTraceString(th));
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                } else if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
            } catch (Throwable th4) {
                if (bufferedInputStream == null) {
                    if (bufferedOutputStream != null) {
                        throw th4;
                    }
                    bufferedOutputStream.close();
                    throw th4;
                }
                try {
                    bufferedInputStream.close();
                } catch (Exception e5) {
                    TbsLog.m665i(TAG, "writeTbsDownloadInfo stack is " + Log.getStackTraceString(e5));
                }
                if (bufferedOutputStream != null) {
                    throw th4;
                }
                try {
                    bufferedOutputStream.close();
                    throw th4;
                } catch (Exception e6) {
                    TbsLog.m665i(TAG, "writeTbsDownloadInfo stack is " + Log.getStackTraceString(e6));
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedOutputStream = null;
        }
    }
}
