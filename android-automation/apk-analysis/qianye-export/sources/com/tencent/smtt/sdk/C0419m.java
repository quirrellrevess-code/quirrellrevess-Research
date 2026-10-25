package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.flexbox.BuildConfig;
import com.tencent.smtt.utils.C0443a;
import com.tencent.smtt.utils.C0460q;
import com.tencent.smtt.utils.C0462s;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import dalvik.system.DexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import okhttp3.internal.cache.DiskLruCache;

/* JADX INFO: renamed from: com.tencent.smtt.sdk.m */
/* JADX INFO: loaded from: classes.dex */
public class C0419m {

    /* JADX INFO: renamed from: c */
    private static C0419m f581c;

    /* JADX INFO: renamed from: e */
    private FileLock f589e;

    /* JADX INFO: renamed from: f */
    private FileOutputStream f590f;

    /* JADX INFO: renamed from: o */
    private QbSdk.InterfaceC0362a f593o;

    /* JADX INFO: renamed from: h */
    private static final ReentrantLock f582h = new ReentrantLock();

    /* JADX INFO: renamed from: i */
    private static final Lock f583i = new ReentrantLock();

    /* JADX INFO: renamed from: k */
    private static FileLock f584k = null;

    /* JADX INFO: renamed from: l */
    private static final ThreadLocal<Integer> f585l = new ThreadLocal<Integer>() { // from class: com.tencent.smtt.sdk.m.1
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer initialValue() {
            return 0;
        }
    };

    /* JADX INFO: renamed from: m */
    private static Handler f586m = null;

    /* JADX INFO: renamed from: a */
    public static boolean f579a = false;

    /* JADX INFO: renamed from: b */
    public static final FileFilter f580b = new FileFilter() { // from class: com.tencent.smtt.sdk.m.2
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (name == null || name.endsWith(".jar_is_first_load_dex_flag_file")) {
                return false;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 21 && name.endsWith(".dex")) {
                return false;
            }
            if (i < 26 || !name.endsWith(".prof")) {
                return i < 26 || !name.equals("oat");
            }
            return false;
        }
    };

    /* JADX INFO: renamed from: n */
    private static int f587n = 0;

    /* JADX INFO: renamed from: d */
    private int f588d = 0;

    /* JADX INFO: renamed from: g */
    private boolean f591g = false;

    /* JADX INFO: renamed from: j */
    private boolean f592j = false;

    /* JADX INFO: renamed from: p */
    private int f594p = -1;

    private C0419m() {
        if (f586m == null) {
            f586m = new Handler(TbsHandlerThread.getInstance().getLooper()) { // from class: com.tencent.smtt.sdk.m.3
                @Override // android.os.Handler
                public void handleMessage(Message message) throws Throwable {
                    QbSdk.setTBSInstallingStatus(true);
                    int i = message.what;
                    if (i == 1) {
                        TbsLog.m665i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE");
                        Object[] objArr = (Object[]) message.obj;
                        C0419m.this.m434b((Context) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue());
                        return;
                    }
                    if (i == 2) {
                        TbsLog.m665i("TbsInstaller", "TbsInstaller--handleMessage--MSG_COPY_TBS_CORE");
                        Object[] objArr2 = (Object[]) message.obj;
                        C0419m.this.m396a((Context) objArr2[0], (Context) objArr2[1], ((Integer) objArr2[2]).intValue());
                    } else if (i == 3) {
                        TbsLog.m665i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE_EX");
                        Object[] objArr3 = (Object[]) message.obj;
                        C0419m.this.m433b((Context) objArr3[0], (Bundle) objArr3[1]);
                    } else {
                        if (i != 4) {
                            return;
                        }
                        TbsLog.m665i("TbsInstaller", "TbsInstaller--handleMessage--MSG_UNZIP_TBS_CORE");
                        Object[] objArr4 = (Object[]) message.obj;
                        C0419m.this.m427a((Context) objArr4[0], (File) objArr4[1], ((Integer) objArr4[2]).intValue());
                        QbSdk.setTBSInstallingStatus(false);
                        super.handleMessage(message);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: a */
    public static synchronized C0419m m393a() {
        if (f581c == null) {
            synchronized (C0419m.class) {
                if (f581c == null) {
                    f581c = new C0419m();
                }
            }
        }
        return f581c;
    }

    /* JADX INFO: renamed from: a */
    private void m394a(int i, String str, Context context) {
        BufferedInputStream bufferedInputStream;
        new File(str).delete();
        TbsLog.m667i("TbsInstaller", "Local tbs apk(" + str + ") is deleted!", true);
        File file = new File(QbSdk.getTbsFolderDir(context), "core_unzip_tmp");
        if (file.canRead()) {
            File file2 = new File(file, "tbs.conf");
            Properties properties = new Properties();
            BufferedOutputStream bufferedOutputStream = null;
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file2));
                    try {
                        properties.load(bufferedInputStream);
                        BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file2));
                        try {
                            properties.setProperty("tbs_local_installation", "true");
                            properties.store(bufferedOutputStream2, (String) null);
                            TbsLog.m667i("TbsInstaller", "TBS_LOCAL_INSTALLATION is set!", true);
                            try {
                                bufferedOutputStream2.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            bufferedInputStream.close();
                        } catch (Throwable th) {
                            th = th;
                            bufferedOutputStream = bufferedOutputStream2;
                            try {
                                th.printStackTrace();
                            } finally {
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream = null;
                }
            } catch (IOException e4) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m395a(Context context) {
        String str;
        if (m413r(context)) {
            return;
        }
        if (m399a(context, "core_unzip_tmp")) {
            TbsCoreLoadStat.getInstance().m176a(context, 417, new Throwable("TMP_TBS_UNZIP_FOLDER_NAME"));
            str = "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_UNZIP_FOLDER_NAME";
        } else if (m399a(context, "core_share_backup_tmp")) {
            TbsCoreLoadStat.getInstance().m176a(context, 417, new Throwable("TMP_BACKUP_TBSCORE_FOLDER_NAME"));
            str = "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_BACKUP_TBSCORE_FOLDER_NAME";
        } else {
            if (!m399a(context, "core_copy_tmp")) {
                return;
            }
            TbsCoreLoadStat.getInstance().m176a(context, 417, new Throwable("TMP_TBS_COPY_FOLDER_NAME"));
            str = "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_COPY_FOLDER_NAME";
        }
        TbsLog.m662e("TbsInstaller", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:106:0x02b6 A[Catch: all -> 0x047a, Exception -> 0x047f, TryCatch #16 {Exception -> 0x047f, all -> 0x047a, blocks: (B:65:0x021e, B:67:0x022a, B:69:0x0233, B:84:0x028c, B:106:0x02b6, B:107:0x02c4, B:109:0x02c7, B:111:0x02d3, B:113:0x02df, B:115:0x02eb, B:117:0x02f1, B:120:0x02fe, B:123:0x0312, B:125:0x0318, B:126:0x0334, B:129:0x0366, B:132:0x037e, B:135:0x03a8, B:127:0x0361, B:88:0x0292, B:99:0x02aa, B:103:0x02b0), top: B:205:0x021e }] */
    /* JADX WARN: Code duplicated, block: B:109:0x02c7 A[Catch: all -> 0x047a, Exception -> 0x047f, TryCatch #16 {Exception -> 0x047f, all -> 0x047a, blocks: (B:65:0x021e, B:67:0x022a, B:69:0x0233, B:84:0x028c, B:106:0x02b6, B:107:0x02c4, B:109:0x02c7, B:111:0x02d3, B:113:0x02df, B:115:0x02eb, B:117:0x02f1, B:120:0x02fe, B:123:0x0312, B:125:0x0318, B:126:0x0334, B:129:0x0366, B:132:0x037e, B:135:0x03a8, B:127:0x0361, B:88:0x0292, B:99:0x02aa, B:103:0x02b0), top: B:205:0x021e }] */
    /* JADX WARN: Code duplicated, block: B:128:0x0365  */
    /* JADX WARN: Code duplicated, block: B:139:0x03c4 A[Catch: Exception -> 0x049c, all -> 0x04b6, TryCatch #8 {Exception -> 0x049c, blocks: (B:63:0x01eb, B:137:0x03b6, B:139:0x03c4, B:140:0x03cc, B:142:0x03d9, B:144:0x03fc, B:149:0x0421, B:145:0x0403, B:141:0x03d0, B:154:0x0445, B:159:0x044e, B:158:0x044b, B:160:0x044f, B:166:0x0487, B:170:0x04a1), top: B:200:0x01e7 }] */
    /* JADX WARN: Code duplicated, block: B:141:0x03d0 A[Catch: Exception -> 0x049c, all -> 0x04b6, TryCatch #8 {Exception -> 0x049c, blocks: (B:63:0x01eb, B:137:0x03b6, B:139:0x03c4, B:140:0x03cc, B:142:0x03d9, B:144:0x03fc, B:149:0x0421, B:145:0x0403, B:141:0x03d0, B:154:0x0445, B:159:0x044e, B:158:0x044b, B:160:0x044f, B:166:0x0487, B:170:0x04a1), top: B:200:0x01e7 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x03fc A[Catch: Exception -> 0x049c, all -> 0x04b6, TryCatch #8 {Exception -> 0x049c, blocks: (B:63:0x01eb, B:137:0x03b6, B:139:0x03c4, B:140:0x03cc, B:142:0x03d9, B:144:0x03fc, B:149:0x0421, B:145:0x0403, B:141:0x03d0, B:154:0x0445, B:159:0x044e, B:158:0x044b, B:160:0x044f, B:166:0x0487, B:170:0x04a1), top: B:200:0x01e7 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x0403 A[Catch: Exception -> 0x049c, all -> 0x04b6, TRY_LEAVE, TryCatch #8 {Exception -> 0x049c, blocks: (B:63:0x01eb, B:137:0x03b6, B:139:0x03c4, B:140:0x03cc, B:142:0x03d9, B:144:0x03fc, B:149:0x0421, B:145:0x0403, B:141:0x03d0, B:154:0x0445, B:159:0x044e, B:158:0x044b, B:160:0x044f, B:166:0x0487, B:170:0x04a1), top: B:200:0x01e7 }] */
    /* JADX WARN: Code duplicated, block: B:194:0x02aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:196:0x0445 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:208:0x0365 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:217:? A[Catch: Exception -> 0x049c, all -> 0x04b6, SYNTHETIC, TryCatch #8 {Exception -> 0x049c, blocks: (B:63:0x01eb, B:137:0x03b6, B:139:0x03c4, B:140:0x03cc, B:142:0x03d9, B:144:0x03fc, B:149:0x0421, B:145:0x0403, B:141:0x03d0, B:154:0x0445, B:159:0x044e, B:158:0x044b, B:160:0x044f, B:166:0x0487, B:170:0x04a1), top: B:200:0x01e7 }] */
    @TargetApi(11)
    /* JADX INFO: renamed from: a */
    public void m396a(Context context, Context context2, int i) throws Throwable {
        File file;
        Properties properties;
        Throwable th;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        boolean z;
        boolean z2;
        TbsLogReport tbsLogReport;
        String str;
        int i2;
        int i3;
        SharedPreferences sharedPreferences;
        File[] fileArrListFiles;
        int i4;
        File file2;
        String strM685a;
        String property;
        BufferedInputStream bufferedInputStream3;
        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-524);
        if (m439c(context2)) {
            return;
        }
        TbsLog.m665i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread start!  tbsCoreTargetVer is " + i);
        if ((Build.VERSION.SDK_INT >= 11 ? context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).getInt("tbs_precheck_disable_version", -1) == i) {
            TbsLog.m662e("TbsInstaller", "TbsInstaller-copyTbsCoreInThread -- version:" + i + " is disabled by preload_x5_check!");
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-525);
            return;
        }
        if (!m453p(context2)) {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-526);
            return;
        }
        Lock lock = f583i;
        boolean zTryLock = lock.tryLock();
        TbsLog.m665i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread #1 locked is " + zTryLock);
        if (!zTryLock) {
            m438c();
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-538);
            return;
        }
        ReentrantLock reentrantLock = f582h;
        reentrantLock.lock();
        try {
            try {
                int iM387c = C0418l.m374a(context2).m387c("copy_core_ver");
                int iM383b = C0418l.m374a(context2).m383b("copy_status");
                if (iM387c == i) {
                    QbSdk.f209n.onInstallFinish(TbsListener.ErrorCode.COPY_INSTALL_SUCCESS);
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-528);
                    reentrantLock.unlock();
                    lock.unlock();
                    m438c();
                    return;
                }
                int iM445g = m445g(context2);
                TbsLog.m665i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread tbsCoreInstalledVer=" + iM445g);
                if (iM445g == i) {
                    QbSdk.f209n.onInstallFinish(TbsListener.ErrorCode.COPY_INSTALL_SUCCESS);
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-528);
                    TbsLog.m665i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread return have same version is " + iM445g);
                    reentrantLock.unlock();
                    lock.unlock();
                    m438c();
                    return;
                }
                int iM382b = C0418l.m374a(context2).m382b();
                if ((iM382b > 0 && i > iM382b) || (iM387c > 0 && i > iM387c)) {
                    m450l(context2);
                }
                if (iM383b == 3 && iM445g > 0 && (i > iM445g || i == 88888888)) {
                    m450l(context2);
                    TbsLog.m667i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread -- update TBS.....", true);
                    iM383b = -1;
                }
                if (!FileUtil.m646b(context2)) {
                    long jM820a = C0462s.m820a();
                    long downloadMinFreeSpace = TbsDownloadConfig.getInstance(context2).getDownloadMinFreeSpace();
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-529);
                    TbsLogReport.getInstance(context2).setInstallErrorCode(TbsListener.ErrorCode.ROM_NOT_ENOUGH, "rom is not enough when copying tbs core! curAvailROM=" + jM820a + ",minReqRom=" + downloadMinFreeSpace);
                    reentrantLock.unlock();
                    lock.unlock();
                    m438c();
                    return;
                }
                if (iM383b > 0) {
                    TbsLog.m665i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread return have copied is " + m444f(context2));
                    reentrantLock.unlock();
                    lock.unlock();
                    m438c();
                    return;
                }
                if (iM383b == 0) {
                    int iM387c2 = C0418l.m374a(context2).m387c("copy_retry_num");
                    if (iM387c2 > 2) {
                        TbsLogReport.getInstance(context2).setInstallErrorCode(TbsListener.ErrorCode.EXCEED_COPY_RETRY_NUM, "exceed copy retry num!");
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-530);
                        reentrantLock.unlock();
                        lock.unlock();
                        m438c();
                        return;
                    }
                    C0418l.m374a(context2).m380a("copy_retry_num", iM387c2 + 1);
                }
                File fileM452n = m452n(context);
                File fileM442e = m442e(context2, 1);
                try {
                    if (fileM452n == null || fileM442e == null) {
                        if (fileM452n == null) {
                            TbsLogReport.getInstance(context2).setInstallErrorCode(TbsListener.ErrorCode.COPY_SRCDIR_ERROR, "src-dir is null when copying tbs core!");
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-535);
                        }
                        if (fileM442e == null) {
                            TbsLogReport.getInstance(context2).setInstallErrorCode(TbsListener.ErrorCode.COPY_TMPDIR_ERROR, "dst-dir is null when copying tbs core!");
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-536);
                        }
                    } else {
                        C0418l.m374a(context2).m378a(i, 0);
                        C0460q c0460q = new C0460q();
                        c0460q.m806a(fileM452n);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-551);
                        boolean zM636a = FileUtil.m636a(fileM452n, fileM442e, f580b);
                        StringBuilder sb = new StringBuilder();
                        sb.append("TbsInstaller-copyTbsCoreInThread time=");
                        try {
                            sb.append(System.currentTimeMillis() - jCurrentTimeMillis);
                            TbsLog.m665i("TbsInstaller", sb.toString());
                            if (zM636a) {
                                c0460q.m808b(fileM452n);
                                if (!c0460q.m807a()) {
                                    TbsLog.m665i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread copy-verify fail!");
                                    FileUtil.m628a(fileM442e, true);
                                    TbsLogReport.getInstance(context2).setInstallErrorCode(TbsListener.ErrorCode.COPY_SRCDIR_ERROR, "TbsCopy-Verify fail after copying tbs core!");
                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-531);
                                    reentrantLock.unlock();
                                    lock.unlock();
                                    m438c();
                                    return;
                                }
                                try {
                                    try {
                                        File file3 = new File(fileM442e, DiskLruCache.VERSION_1);
                                        properties = new Properties();
                                        try {
                                            if (file3.exists()) {
                                                BufferedInputStream bufferedInputStream4 = new BufferedInputStream(new FileInputStream(file3));
                                                try {
                                                    properties.load(bufferedInputStream4);
                                                    bufferedInputStream3 = bufferedInputStream4;
                                                    z = true;
                                                } catch (Exception e) {
                                                    e = e;
                                                    bufferedInputStream2 = bufferedInputStream4;
                                                    try {
                                                        e.printStackTrace();
                                                        if (bufferedInputStream2 != null) {
                                                            try {
                                                                bufferedInputStream2.close();
                                                            } catch (IOException e2) {
                                                                e2.printStackTrace();
                                                            }
                                                        }
                                                        z = true;
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        bufferedInputStream = bufferedInputStream2;
                                                        if (bufferedInputStream != null) {
                                                            throw th;
                                                        }
                                                        try {
                                                            bufferedInputStream.close();
                                                            throw th;
                                                        } catch (IOException e3) {
                                                            e3.printStackTrace();
                                                            throw th;
                                                        }
                                                    }
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    bufferedInputStream = bufferedInputStream4;
                                                    if (bufferedInputStream != null) {
                                                        throw th;
                                                    }
                                                    bufferedInputStream.close();
                                                    throw th;
                                                }
                                            } else {
                                                z = false;
                                                bufferedInputStream3 = null;
                                            }
                                            if (bufferedInputStream3 != null) {
                                                try {
                                                    bufferedInputStream3.close();
                                                } catch (IOException e4) {
                                                    e4.printStackTrace();
                                                }
                                            }
                                        } catch (Exception e5) {
                                            e = e5;
                                            bufferedInputStream2 = null;
                                            e.printStackTrace();
                                            if (bufferedInputStream2 != null) {
                                                bufferedInputStream2.close();
                                            }
                                            z = true;
                                            if (z) {
                                                fileArrListFiles = fileM442e.listFiles();
                                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-552);
                                                i4 = 0;
                                                while (true) {
                                                    if (i4 < fileArrListFiles.length) {
                                                        file2 = fileArrListFiles[i4];
                                                        if (!DiskLruCache.VERSION_1.equals(file2.getName())) {
                                                            strM685a = C0443a.m685a(file2);
                                                            property = properties.getProperty(file2.getName(), BuildConfig.FLAVOR);
                                                            if (property.equals(BuildConfig.FLAVOR)) {
                                                            }
                                                            TbsLog.m662e("TbsInstaller", "md5_check_failure for (" + file2.getName() + ") targetMd5:" + property + ", realMd5:" + strM685a);
                                                            z2 = false;
                                                        }
                                                        i4++;
                                                    } else {
                                                        z2 = true;
                                                    }
                                                }
                                            } else {
                                                z2 = true;
                                            }
                                            TbsLog.m665i("TbsInstaller", "copyTbsCoreInThread - md5_check_success:" + z2);
                                            if (!z) {
                                            }
                                            TbsLog.m665i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success!");
                                            TbsLog.m665i("TbsInstaller", "setTmpFolderCoreToRead call #04");
                                            m408e(context2, true);
                                            C0418l.m374a(context2).m378a(i, 1);
                                            if (this.f592j) {
                                                tbsLogReport = TbsLogReport.getInstance(context2);
                                                str = "continueInstallWithout core success";
                                                i2 = TbsListener.ErrorCode.COPY_INSTALL_SUCCESS;
                                            } else {
                                                tbsLogReport = TbsLogReport.getInstance(context2);
                                                str = "success";
                                                i2 = TbsListener.ErrorCode.COPY_INSTALL_SUCCESS;
                                            }
                                            tbsLogReport.setInstallErrorCode(i2, str);
                                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-533);
                                            TbsLog.m665i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success -- version:" + i);
                                            if (Build.VERSION.SDK_INT >= 11) {
                                                sharedPreferences = context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
                                                i3 = 0;
                                            } else {
                                                i3 = 0;
                                                sharedPreferences = context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
                                            }
                                            try {
                                                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                                                editorEdit.putInt("tbs_preload_x5_counter", i3);
                                                editorEdit.putInt("tbs_preload_x5_recorder", i3);
                                                editorEdit.putInt("tbs_preload_x5_version", i);
                                                editorEdit.commit();
                                            } catch (Throwable th4) {
                                                TbsLog.m662e("TbsInstaller", "Init tbs_preload_x5_counter#2 exception:" + Log.getStackTraceString(th4));
                                            }
                                            f582h.unlock();
                                            f583i.unlock();
                                            m438c();
                                        }
                                    } catch (Exception e6) {
                                        e = e6;
                                        properties = null;
                                    }
                                    if (z) {
                                        fileArrListFiles = fileM442e.listFiles();
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-552);
                                        i4 = 0;
                                        while (true) {
                                            if (i4 < fileArrListFiles.length) {
                                                file2 = fileArrListFiles[i4];
                                                if (!DiskLruCache.VERSION_1.equals(file2.getName()) && !file2.getName().endsWith(".dex") && !"tbs.conf".equals(file2.getName()) && !file2.isDirectory() && !file2.getName().endsWith(".prof")) {
                                                    strM685a = C0443a.m685a(file2);
                                                    property = properties.getProperty(file2.getName(), BuildConfig.FLAVOR);
                                                    if (property.equals(BuildConfig.FLAVOR) && strM685a.equals(property)) {
                                                        TbsLog.m665i("TbsInstaller", "md5_check_success for (" + file2.getName() + ")");
                                                    } else {
                                                        TbsLog.m662e("TbsInstaller", "md5_check_failure for (" + file2.getName() + ") targetMd5:" + property + ", realMd5:" + strM685a);
                                                        z2 = false;
                                                    }
                                                }
                                                i4++;
                                            } else {
                                                z2 = true;
                                            }
                                        }
                                    } else {
                                        z2 = true;
                                    }
                                    TbsLog.m665i("TbsInstaller", "copyTbsCoreInThread - md5_check_success:" + z2);
                                    if (!z && !z2) {
                                        TbsLog.m662e("TbsInstaller", "copyTbsCoreInThread - md5 incorrect -> delete destTmpDir!");
                                        FileUtil.m628a(fileM442e, true);
                                        TbsLogReport.getInstance(context2).setInstallErrorCode(TbsListener.ErrorCode.COPY_SRCDIR_ERROR, "TbsCopy-Verify md5 fail after copying tbs core!");
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-532);
                                        f582h.unlock();
                                        f583i.unlock();
                                        m438c();
                                        return;
                                    }
                                    TbsLog.m665i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success!");
                                    TbsLog.m665i("TbsInstaller", "setTmpFolderCoreToRead call #04");
                                    m408e(context2, true);
                                    C0418l.m374a(context2).m378a(i, 1);
                                    if (this.f592j) {
                                        tbsLogReport = TbsLogReport.getInstance(context2);
                                        str = "continueInstallWithout core success";
                                        i2 = TbsListener.ErrorCode.COPY_INSTALL_SUCCESS;
                                    } else {
                                        tbsLogReport = TbsLogReport.getInstance(context2);
                                        str = "success";
                                        i2 = TbsListener.ErrorCode.COPY_INSTALL_SUCCESS;
                                    }
                                    tbsLogReport.setInstallErrorCode(i2, str);
                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-533);
                                    TbsLog.m665i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success -- version:" + i);
                                    if (Build.VERSION.SDK_INT >= 11) {
                                        sharedPreferences = context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
                                        i3 = 0;
                                    } else {
                                        i3 = 0;
                                        sharedPreferences = context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
                                    }
                                    SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
                                    editorEdit2.putInt("tbs_preload_x5_counter", i3);
                                    editorEdit2.putInt("tbs_preload_x5_recorder", i3);
                                    editorEdit2.putInt("tbs_preload_x5_version", i);
                                    editorEdit2.commit();
                                } catch (Throwable th5) {
                                    th = th5;
                                    bufferedInputStream = null;
                                }
                            } else {
                                TbsLog.m665i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread fail!");
                                C0418l.m374a(context2).m378a(i, 2);
                                FileUtil.m628a(fileM442e, false);
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-534);
                                TbsLogReport.getInstance(context2).setInstallErrorCode(TbsListener.ErrorCode.COPY_FAIL, "copy fail!");
                            }
                        } catch (Exception e7) {
                            e = e7;
                            file = fileM442e;
                            TbsLogReport.getInstance(context2).setInstallErrorCode(TbsListener.ErrorCode.COPY_EXCEPTION, e.toString());
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-537);
                            try {
                                FileUtil.m628a(file, false);
                                C0418l.m374a(context2).m378a(0, -1);
                            } catch (Exception e8) {
                                TbsLog.m662e("TbsInstaller", "[TbsInstaller-copyTbsCoreInThread] delete dstTmpDir throws exception:" + e8.getMessage() + "," + e8.getCause());
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            f582h.unlock();
                            f583i.unlock();
                            m438c();
                            throw th;
                        }
                    }
                } catch (Exception e9) {
                    e = e9;
                }
                f582h.unlock();
                f583i.unlock();
                m438c();
            } catch (Throwable th7) {
                th = th7;
                f582h.unlock();
                f583i.unlock();
                m438c();
                throw th;
            }
        } catch (Exception e10) {
            e = e10;
            file = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m398a(Context context, File file, boolean z) {
        TbsDownloadConfig tbsDownloadConfig;
        int i;
        TbsLog.m665i("TbsInstaller", "TbsInstaller-unzipTbs start isDecoupleCore is " + z);
        if (FileUtil.m650c(file)) {
            try {
                File tbsFolderDir = QbSdk.getTbsFolderDir(context);
                File file2 = z ? new File(tbsFolderDir, "core_share_decouple") : new File(tbsFolderDir, "core_unzip_tmp");
                if (file2.exists() && !TbsDownloader.m183a(context)) {
                    FileUtil.m645b(file2);
                }
            } catch (Throwable th) {
                TbsLog.m662e("TbsInstaller", "TbsInstaller-unzipTbs -- delete unzip folder if exists exception" + Log.getStackTraceString(th));
            }
            File fileM442e = z ? m442e(context, 2) : m442e(context, 0);
            if (fileM442e != null) {
                try {
                    try {
                        try {
                            FileUtil.m634a(fileM442e);
                            if (z) {
                                FileUtil.m628a(fileM442e, true);
                            }
                            boolean zM635a = FileUtil.m635a(file, fileM442e);
                            if (zM635a) {
                                zM635a = m400a(fileM442e, context);
                            }
                            if (z) {
                                for (String str : fileM442e.list()) {
                                    File file3 = new File(fileM442e, str);
                                    if (file3.getName().endsWith(".dex")) {
                                        file3.delete();
                                    }
                                }
                                try {
                                    new File(m411o(context), "x5.tbs").delete();
                                } catch (Exception unused) {
                                }
                            }
                            if (zM635a) {
                                TbsLog.m665i("TbsInstaller", "setTmpFolderCoreToRead call #05");
                                m408e(context, true);
                            } else {
                                FileUtil.m645b(fileM442e);
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-522);
                                TbsLog.m662e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#1! exist:" + fileM442e.exists());
                            }
                            TbsLog.m665i("TbsInstaller", "TbsInstaller-unzipTbs done");
                            return zM635a;
                        } catch (Exception e) {
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-523);
                            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.UNZIP_OTHER_ERROR, e);
                            if ((fileM442e != null && fileM442e.exists()) && fileM442e != null) {
                                try {
                                    FileUtil.m645b(fileM442e);
                                    TbsLog.m662e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:" + fileM442e.exists());
                                } catch (Throwable th2) {
                                    TbsLog.m662e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:" + Log.getStackTraceString(th2));
                                }
                            }
                            TbsLog.m665i("TbsInstaller", "TbsInstaller-unzipTbs done");
                            return false;
                        }
                    } catch (IOException e2) {
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-523);
                        TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.UNZIP_IO_ERROR, e2);
                        if ((fileM442e != null && fileM442e.exists()) && fileM442e != null) {
                            try {
                                FileUtil.m645b(fileM442e);
                                TbsLog.m662e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:" + fileM442e.exists());
                            } catch (Throwable th3) {
                                TbsLog.m662e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:" + Log.getStackTraceString(th3));
                            }
                        }
                        TbsLog.m665i("TbsInstaller", "TbsInstaller-unzipTbs done");
                        return false;
                    }
                } catch (Throwable th4) {
                    TbsLog.m665i("TbsInstaller", "TbsInstaller-unzipTbs done");
                    throw th4;
                }
            }
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.UNZIP_DIR_ERROR, "tmp unzip dir is null!");
            tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
            i = -521;
        } else {
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.APK_INVALID, "apk is invalid!");
            tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
            i = -520;
        }
        tbsDownloadConfig.setInstallInterruptCode(i);
        return false;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m399a(Context context, String str) {
        StringBuilder sb;
        String str2;
        File file = new File(QbSdk.getTbsFolderDir(context), str);
        if (!file.exists()) {
            sb = new StringBuilder();
            str2 = "#1# ";
        } else {
            if (new File(file, "tbs.conf").exists()) {
                TbsLog.m666i("TbsInstaller", "isPrepareTbsCore", "#3# " + str);
                return true;
            }
            sb = new StringBuilder();
            str2 = "#2# ";
        }
        sb.append(str2);
        sb.append(str);
        TbsLog.m666i("TbsInstaller", "isPrepareTbsCore", sb.toString());
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:69:0x0152 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    private boolean m400a(File file, Context context) throws Throwable {
        Properties properties;
        Exception e;
        BufferedInputStream bufferedInputStream;
        boolean z;
        boolean z2;
        TbsLog.m665i("TbsInstaller", "finalCheckForTbsCoreValidity - " + file + ", " + context);
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                File file2 = new File(file, DiskLruCache.VERSION_1);
                properties = new Properties();
                try {
                    if (file2.exists()) {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file2));
                        try {
                            try {
                                properties.load(bufferedInputStream);
                                bufferedInputStream2 = bufferedInputStream;
                                z = true;
                            } catch (Throwable th) {
                                th = th;
                                bufferedInputStream2 = bufferedInputStream;
                                if (bufferedInputStream2 != null) {
                                    try {
                                        bufferedInputStream2.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            e.printStackTrace();
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            z = true;
                        }
                    } else {
                        z = false;
                    }
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                } catch (Exception e6) {
                    bufferedInputStream = null;
                    e = e6;
                }
            } catch (Exception e7) {
                properties = null;
                e = e7;
                bufferedInputStream = null;
            }
            TbsLog.m665i("TbsInstaller", "finalCheckForTbsCoreValidity - need_check:" + z);
            if (z) {
                File[] fileArrListFiles = file.listFiles();
                int i = 0;
                while (true) {
                    if (i < fileArrListFiles.length) {
                        File file3 = fileArrListFiles[i];
                        if (!DiskLruCache.VERSION_1.equals(file3.getName()) && !file3.getName().endsWith(".dex") && !"tbs.conf".equals(file3.getName()) && !file3.isDirectory() && !file3.getName().endsWith(".prof")) {
                            String strM685a = C0443a.m685a(file3);
                            String property = properties.getProperty(file3.getName(), BuildConfig.FLAVOR);
                            if (property.equals(BuildConfig.FLAVOR) || !property.equals(strM685a)) {
                                TbsLog.m662e("TbsInstaller", "md5_check_failure for (" + file3.getName() + ") targetMd5:" + property + ", realMd5:" + strM685a);
                                z2 = false;
                            } else {
                                TbsLog.m665i("TbsInstaller", "md5_check_success for (" + file3.getName() + ")");
                            }
                        }
                        i++;
                    } else {
                        z2 = true;
                    }
                }
            } else {
                z2 = true;
            }
            TbsLog.m665i("TbsInstaller", "finalCheckForTbsCoreValidity - md5_check_success:" + z2);
            if (!z || z2) {
                TbsLog.m665i("TbsInstaller", "finalCheckForTbsCoreValidity success!");
                return true;
            }
            TbsLog.m662e("TbsInstaller", "finalCheckForTbsCoreValidity - Verify failed after unzipping!");
            return false;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m401b() {
        f585l.set(0);
    }

    /* JADX INFO: renamed from: b */
    private boolean m402b(Context context, File file) {
        return m398a(context, file, false);
    }

    /* JADX INFO: renamed from: c */
    private int m403c(Context context, Bundle bundle) throws Throwable {
        try {
            Bundle bundleM146a = QbSdk.m146a(context, bundle);
            TbsLog.m665i("TbsInstaller", "tpatch finished,ret is" + bundleM146a);
            int i = bundleM146a.getInt("patch_result");
            if (i != 0) {
                String string = bundle.getString("new_apk_location");
                if (!TextUtils.isEmpty(string)) {
                    FileUtil.m645b(new File(string));
                }
                TbsLogReport.getInstance(context).setInstallErrorCode(i, "tpatch fail,patch error_code=" + i);
                return 1;
            }
            String string2 = bundle.getString("new_apk_location");
            int i2 = bundle.getInt("new_core_ver");
            int iM421a = m421a(new File(string2));
            TbsLog.m665i("TbsInstaller", "doTpatch version is " + i2 + " patchVersion is " + iM421a);
            if (i2 == iM421a) {
                TbsLog.m665i("TbsInstaller", "Tpatch success!");
                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.TPATCH_INSTALL_SUCCESS, BuildConfig.FLAVOR);
                return 0;
            }
            TbsLog.m665i("TbsInstaller", "version not equals!!!" + i2 + "patchVersion:" + iM421a);
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.TPATCH_VERSION_FAILED, "version=" + i2 + ",patchVersion=" + iM421a);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL, "patch exception" + Log.getStackTraceString(e));
            return 1;
        }
    }

    /* JADX INFO: renamed from: c */
    private boolean m404c(Context context, File file) {
        try {
            File[] fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.tencent.smtt.sdk.m.6
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    return file2.getName().endsWith(".jar");
                }
            });
            int length = fileArrListFiles.length;
            if (Build.VERSION.SDK_INT < 16 && context.getPackageName() != null && context.getPackageName().equalsIgnoreCase(TbsConfig.APP_DEMO)) {
                try {
                    Thread.sleep(5000L);
                } catch (Exception unused) {
                }
            }
            ClassLoader classLoader = context.getClassLoader();
            for (int i = 0; i < length; i++) {
                TbsLog.m665i("TbsInstaller", "jarFile: " + fileArrListFiles[i].getAbsolutePath());
                new DexClassLoader(fileArrListFiles[i].getAbsolutePath(), file.getAbsolutePath(), null, classLoader);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.DEXOPT_EXCEPTION, e.toString());
            TbsLog.m665i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
            return false;
        }
    }

    /* JADX INFO: renamed from: c */
    private synchronized boolean m405c(Context context, boolean z) {
        TbsLog.m665i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch");
        boolean z2 = false;
        try {
            if (!m453p(context)) {
                return false;
            }
            ReentrantLock reentrantLock = f582h;
            boolean zTryLock = reentrantLock.tryLock();
            TbsLog.m665i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch Locked =" + zTryLock);
            if (zTryLock) {
                try {
                    int iM383b = C0418l.m374a(context).m383b("tpatch_status");
                    int iM422a = m422a(false, context);
                    TbsLog.m665i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch copyStatus =" + iM383b);
                    TbsLog.m665i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer =" + iM422a);
                    if (iM383b == 1) {
                        if (iM422a == 0) {
                            TbsLog.m667i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer = 0", true);
                        } else if (z) {
                            TbsLog.m667i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer != 0", true);
                        }
                        m416u(context);
                        z2 = true;
                    }
                    reentrantLock.unlock();
                } catch (Throwable th) {
                    f582h.unlock();
                    throw th;
                }
            }
            m438c();
        } catch (Throwable th2) {
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.COPY_EXCEPTION, th2.toString());
            QbSdk.m149a(context, "TbsInstaller::enableTbsCoreFromTpatch exception:" + Log.getStackTraceString(th2));
        }
        return z2;
    }

    /* JADX INFO: renamed from: d */
    private boolean m406d(Context context, File file) {
        try {
            File file2 = new File(file, "tbs_sdk_extension_dex.jar");
            File file3 = new File(file, "tbs_sdk_extension_dex.dex");
            new DexClassLoader(file2.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
            String strM315a = C0410d.m315a(context, file3.getAbsolutePath());
            if (TextUtils.isEmpty(strM315a)) {
                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.DEXOAT_EXCEPTION, "can not find oat command");
                return false;
            }
            for (File file4 : file.listFiles(new FileFilter() { // from class: com.tencent.smtt.sdk.m.7
                @Override // java.io.FileFilter
                public boolean accept(File file5) {
                    return file5.getName().endsWith(".jar");
                }
            })) {
                String strSubstring = file4.getName().substring(0, file4.getName().length() - 4);
                Runtime.getRuntime().exec("/system/bin/dex2oat " + strM315a.replaceAll("tbs_sdk_extension_dex", strSubstring) + " --dex-location=" + m393a().m452n(context) + File.separator + strSubstring + ".jar").waitFor();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.DEXOAT_EXCEPTION, e);
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0046 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:14:0x0048 A[Catch: Exception -> 0x00c1, all -> 0x00db, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x00c1, blocks: (B:10:0x0040, B:14:0x0048, B:25:0x00b2, B:29:0x00bd, B:27:0x00b7, B:28:0x00bc), top: B:41:0x0040, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0093 A[Catch: all -> 0x00b6, TryCatch #0 {all -> 0x00b6, blocks: (B:16:0x006d, B:18:0x0093, B:20:0x009c, B:21:0x00a3, B:23:0x00aa), top: B:38:0x006d }] */
    /* JADX WARN: Code duplicated, block: B:20:0x009c A[Catch: all -> 0x00b6, TryCatch #0 {all -> 0x00b6, blocks: (B:16:0x006d, B:18:0x0093, B:20:0x009c, B:21:0x00a3, B:23:0x00aa), top: B:38:0x006d }] */
    /* JADX WARN: Code duplicated, block: B:22:0x00a8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x00aa A[Catch: all -> 0x00b6, TRY_LEAVE, TryCatch #0 {all -> 0x00b6, blocks: (B:16:0x006d, B:18:0x0093, B:20:0x009c, B:21:0x00a3, B:23:0x00aa), top: B:38:0x006d }] */
    /* JADX WARN: Code duplicated, block: B:38:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:12:0x0046, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:14:0x0048, please report this as an issue */
    /* JADX INFO: renamed from: d */
    private synchronized boolean m407d(Context context, boolean z) {
        boolean z2;
        ReentrantLock reentrantLock;
        boolean zTryLock;
        int iM386c;
        int iM422a;
        if (context == null) {
            TbsLog.m666i("TbsInstaller", "enableTbsCoreFromUnzip", "canRenameTmpDir =" + z);
            TbsLog.m666i("TbsInstaller", "enableTbsCoreFromUnzip", "#1#");
            z2 = false;
            if (!m453p(context)) {
                return false;
            }
            TbsLog.m666i("TbsInstaller", "enableTbsCoreFromUnzip", "#2# getInstallFileLock Success!!");
            reentrantLock = f582h;
            zTryLock = reentrantLock.tryLock();
            TbsLog.m666i("TbsInstaller", "enableTbsCoreFromUnzip", "locked=" + zTryLock);
            if (zTryLock) {
                iM386c = C0418l.m374a(context).m386c();
                TbsLog.m665i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip installStatus=" + iM386c);
                iM422a = m422a(false, context);
                if (iM386c == 2) {
                    TbsLog.m666i("TbsInstaller", "enableTbsCoreFromUnzip", "#4# In Rename Logic");
                    if (iM422a == 0) {
                        TbsLog.m667i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer = 0", false);
                    } else if (z) {
                        TbsLog.m667i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer != 0", false);
                    }
                    m415t(context);
                    z2 = true;
                }
                reentrantLock.unlock();
            }
            m438c();
            return z2;
        }
        if (TbsConfig.APP_WX.equals(context.getApplicationContext().getApplicationInfo().packageName)) {
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INSTALL_FROM_UNZIP, " ");
        }
        TbsLog.m666i("TbsInstaller", "enableTbsCoreFromUnzip", "canRenameTmpDir =" + z);
        TbsLog.m666i("TbsInstaller", "enableTbsCoreFromUnzip", "#1#");
        z2 = false;
        try {
            if (!m453p(context)) {
                return false;
            }
            TbsLog.m666i("TbsInstaller", "enableTbsCoreFromUnzip", "#2# getInstallFileLock Success!!");
            reentrantLock = f582h;
            zTryLock = reentrantLock.tryLock();
            TbsLog.m666i("TbsInstaller", "enableTbsCoreFromUnzip", "locked=" + zTryLock);
            if (zTryLock) {
                try {
                    iM386c = C0418l.m374a(context).m386c();
                    TbsLog.m665i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip installStatus=" + iM386c);
                    iM422a = m422a(false, context);
                    if (iM386c == 2) {
                        TbsLog.m666i("TbsInstaller", "enableTbsCoreFromUnzip", "#4# In Rename Logic");
                        if (iM422a == 0) {
                            TbsLog.m667i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer = 0", false);
                        } else if (z) {
                            TbsLog.m667i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer != 0", false);
                        }
                        m415t(context);
                        z2 = true;
                    }
                    reentrantLock.unlock();
                } catch (Throwable th) {
                    f582h.unlock();
                    throw th;
                }
            }
            m438c();
            return z2;
        } catch (Exception e) {
            QbSdk.m149a(context, "TbsInstaller::enableTbsCoreFromUnzip Exception: " + e);
            e.printStackTrace();
        }
        throw th;
    }

    /* JADX INFO: renamed from: e */
    private void m408e(Context context, boolean z) {
        if (context == null) {
            TbsLogReport.getInstance(context).setInstallErrorCode(225, "setTmpFolderCoreToRead context is null");
            TbsLog.m665i("TbsInstaller", "setTmpFolderCoreToRead inner return #01");
            return;
        }
        try {
            File file = new File(QbSdk.getTbsFolderDir(context), "tmp_folder_core_to_read.conf");
            if (!z) {
                TbsLog.m665i("TbsInstaller", "setTmpFolderCoreToRead inner tmp file delete #01");
                FileUtil.m645b(file);
            } else if (file.exists()) {
                TbsLog.m665i("TbsInstaller", "setTmpFolderCoreToRead inner tmp file already exist #01");
            } else {
                TbsLog.m665i("TbsInstaller", "setTmpFolderCoreToRead inner tmp file create #01");
                file.createNewFile();
            }
        } catch (Exception e) {
            TbsLogReport.getInstance(context).setInstallErrorCode(225, "setTmpFolderCoreToRead Exception message is " + e.getMessage() + " Exception cause is " + e.getCause());
            TbsLog.m665i("TbsInstaller", "setTmpFolderCoreToRead inner exception #01");
        }
    }

    /* JADX INFO: renamed from: f */
    private void m409f(Context context, int i) {
        TbsLog.m665i("TbsInstaller", "proceedTpatchStatus,result=" + i);
        if (i != 0) {
            return;
        }
        TbsLog.m665i("TbsInstaller", "setTmpFolderCoreToRead call #03");
        m408e(context, true);
        C0418l.m374a(context).m385b(TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0), 1);
    }

    /* JADX INFO: renamed from: g */
    private boolean m410g(Context context, int i) {
        File fileM442e;
        boolean z;
        TbsLog.m665i("TbsInstaller", "TbsInstaller-doTbsDexOpt start - dirMode: " + i);
        boolean z2 = false;
        try {
            if (i != 0) {
                if (i == 1) {
                    fileM442e = m442e(context, 1);
                } else {
                    if (i != 2) {
                        TbsLog.m662e("TbsInstaller", "doDexoptOrDexoat mode error: " + i);
                        return false;
                    }
                    fileM442e = m452n(context);
                }
            } else {
                if (TbsDownloader.m183a(context)) {
                    return true;
                }
                fileM442e = m442e(context, 0);
            }
            try {
                String property = System.getProperty("java.vm.version");
                z = property != null && property.startsWith("2");
            } catch (Throwable th) {
                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.DEXOAT_EXCEPTION, th);
            }
            boolean z3 = Build.VERSION.SDK_INT == 23;
            boolean z4 = TbsDownloadConfig.getInstance(context).mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_STOP_PRE_OAT, false);
            if (z && z3 && !z4) {
                z2 = true;
            }
            if (z2 && m406d(context, fileM442e)) {
                TbsLog.m665i("TbsInstaller", "doTbsDexOpt -- doDexoatForArtVm");
                return true;
            }
            if (!z) {
                TbsLog.m665i("TbsInstaller", "doTbsDexOpt -- doDexoptForDavlikVM");
                return m404c(context, fileM442e);
            }
            TbsLog.m665i("TbsInstaller", "doTbsDexOpt -- is ART mode, skip!");
            TbsLog.m665i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.DEXOPT_EXCEPTION, e.toString());
        }
    }

    /* JADX INFO: renamed from: o */
    public static File m411o(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "core_private");
        if (file.isDirectory() || file.mkdir()) {
            return file;
        }
        return null;
    }

    /* JADX INFO: renamed from: q */
    private int m412q(Context context) {
        boolean z = C0418l.m374a(context).m390d() == 1;
        boolean zM183a = TbsDownloader.m183a(context);
        if (z) {
            return zM183a ? TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS : TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS;
        }
        if (zM183a) {
            return TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS;
        }
        return 200;
    }

    /* JADX INFO: renamed from: r */
    private static boolean m413r(Context context) {
        String str;
        if (context == null) {
            str = "#1#";
        } else {
            try {
                if (new File(QbSdk.getTbsFolderDir(context), "tmp_folder_core_to_read.conf").exists()) {
                    TbsLog.m666i("TbsInstaller", "getTmpFolderCoreToRead", "#2#");
                    return true;
                }
                TbsLog.m666i("TbsInstaller", "getTmpFolderCoreToRead", "#3#");
                return false;
            } catch (Exception unused) {
                str = "#4#";
            }
        }
        TbsLog.m666i("TbsInstaller", "getTmpFolderCoreToRead", str);
        return true;
    }

    /* JADX INFO: renamed from: s */
    private boolean m414s(Context context) {
        TbsLog.m665i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #1 ");
        FileLock fileLockM653e = FileUtil.m653e(context);
        f584k = fileLockM653e;
        if (fileLockM653e == null) {
            TbsLog.m665i("TbsInstaller", "getTbsCoreRenameFileLock## failed!");
            return false;
        }
        TbsLog.m665i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock true ");
        return true;
    }

    /* JADX INFO: renamed from: t */
    private void m415t(Context context) {
        TbsLog.m665i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
        if (!m414s(context)) {
            TbsLog.m665i("TbsInstaller", "get rename fileLock#4 ## failed!");
            return;
        }
        try {
            m417v(context);
            m418w(context);
            TbsLog.m665i("TbsInstaller", "after renameTbsCoreShareDir");
            TbsLog.m665i("TbsInstaller", "is thirdapp and not chmod");
            C0418l.m374a(context).m377a(0);
            C0418l.m374a(context).m384b(0);
            C0418l.m374a(context).m392d(0);
            C0418l.m374a(context).m380a("incrupdate_retry_num", 0);
            C0418l.m374a(context).m389c(0, 3);
            C0418l.m374a(context).m379a(BuildConfig.FLAVOR);
            C0418l.m374a(context).m380a("tpatch_num", 0);
            C0418l.m374a(context).m388c(-1);
            f585l.set(0);
            f587n = 0;
        } catch (Throwable th) {
            th.printStackTrace();
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.RENAME_EXCEPTION, "exception when renameing from unzip:" + th.toString());
            TbsLog.m664e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
        }
        m443e(context);
    }

    /* JADX INFO: renamed from: u */
    private void m416u(Context context) {
        TbsLog.m665i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromTpatch");
        if (!m414s(context)) {
            TbsLog.m665i("TbsInstaller", "get rename fileLock#4 ## failed!");
            return;
        }
        try {
            m417v(context);
            m419x(context);
            C0418l.m374a(context).m385b(0, -1);
            C0418l.m374a(context).m380a("tpatch_num", 0);
            f585l.set(0);
        } catch (Exception e) {
            e.printStackTrace();
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.TPATCH_ENABLE_EXCEPTION, "exception when renameing from tpatch:" + e.toString());
        }
        m443e(context);
    }

    /* JADX INFO: renamed from: v */
    private void m417v(Context context) {
        TbsLog.m665i("TbsInstaller", "TbsInstaller--deleteOldCore");
        FileUtil.m630a(m452n(context), false, true);
    }

    /* JADX INFO: renamed from: w */
    private void m418w(Context context) {
        TbsLog.m665i("TbsInstaller", "TbsInstaller--renameShareDir");
        File fileM442e = m442e(context, 0);
        File fileM452n = m452n(context);
        if (fileM442e == null || fileM452n == null) {
            TbsLog.m665i("TbsInstaller", "renameTbsCoreShareDir return,tmpTbsCoreUnzipDir=" + fileM442e + "tbsSharePath=" + fileM452n);
            return;
        }
        boolean zRenameTo = fileM442e.renameTo(fileM452n);
        if (zRenameTo && this.f593o != null) {
            this.f593o.m168a(fileM452n.listFiles(new FileFilter() { // from class: com.tencent.smtt.sdk.m.4
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.getName().contains(".so");
                }
            }));
        }
        TbsLog.m665i("TbsInstaller", "renameTbsCoreShareDir rename success=" + zRenameTo);
        m408e(context, false);
    }

    /* JADX INFO: renamed from: x */
    private void m419x(Context context) {
        TbsLog.m665i("TbsInstaller", "TbsInstaller--renameTbsTpatchCoreDir");
        File fileM442e = m442e(context, 5);
        File fileM452n = m452n(context);
        if (fileM442e == null || fileM452n == null) {
            return;
        }
        if (fileM442e.renameTo(fileM452n) && this.f593o != null) {
            this.f593o.m168a(fileM452n.listFiles(new FileFilter() { // from class: com.tencent.smtt.sdk.m.5
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.getName().contains(".so");
                }
            }));
        }
        TbsLog.m665i("TbsInstaller", "setTmpFolderCoreToRead call #09");
        m408e(context, false);
    }

    /* JADX INFO: renamed from: y */
    private void m420y(Context context) {
        TbsLog.m665i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
        File fileM442e = m442e(context, 0);
        if (fileM442e != null) {
            FileUtil.m628a(fileM442e, false);
        }
        C0418l.m374a(context).m389c(0, 5);
        C0418l.m374a(context).m388c(-1);
        QbSdk.m149a(context, "TbsInstaller::clearNewTbsCore forceSysWebViewInner!");
    }

    /* JADX INFO: renamed from: a */
    public int m421a(File file) throws Throwable {
        BufferedInputStream bufferedInputStream = null;
        try {
            TbsLog.m665i("TbsInstaller", "TbsInstaller--getTbsVersion  tbsShareDir is " + file);
            File file2 = new File(file, "tbs.conf");
            if (!file2.exists()) {
                return 0;
            }
            Properties properties = new Properties();
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file2));
            try {
                properties.load(bufferedInputStream2);
                bufferedInputStream2.close();
                String property = properties.getProperty("tbs_core_version");
                if (property == null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return 0;
                }
                int i = Integer.parseInt(property);
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused2) {
                }
                return i;
            } catch (Exception unused3) {
                bufferedInputStream = bufferedInputStream2;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException unused6) {
            }
        }
        return 0;
    }

    /* JADX INFO: renamed from: a */
    public int m422a(boolean z, Context context) {
        if (z || f585l.get().intValue() <= 0) {
            f585l.set(Integer.valueOf(m445g(context)));
        }
        return f585l.get().intValue();
    }

    /* JADX INFO: renamed from: a */
    public File m423a(Context context, int i, boolean z) {
        String str;
        String str2;
        File tbsFolderDir = QbSdk.getTbsFolderDir(context);
        switch (i) {
            case 0:
                str = "core_unzip_tmp";
                break;
            case 1:
                str = "core_copy_tmp";
                break;
            case 2:
                str = "core_unzip_tmp_decouple";
                break;
            case 3:
                str = "core_share_backup";
                break;
            case 4:
                str = "core_share_backup_tmp";
                break;
            case 5:
                str = "tpatch_tmp";
                break;
            case 6:
                str = "tpatch_decouple_tmp";
                break;
            default:
                str = BuildConfig.FLAVOR;
                break;
        }
        TbsLog.m665i("TbsInstaller", "type=" + i + "needMakeDir=" + z + "folder=" + str);
        File file = new File(tbsFolderDir, str);
        if (!file.isDirectory()) {
            if (z) {
                str2 = file.mkdir() ? "getCoreDir,no need mkdir" : "getCoreDir,mkdir false";
            }
            TbsLog.m665i("TbsInstaller", str2);
            return null;
        }
        return file;
    }

    /* JADX INFO: renamed from: a */
    public File m424a(Context context, File file) {
        File file2 = new File(file, "core_share_decouple");
        if (file2.isDirectory() || file2.mkdir()) {
            return file2;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void m425a(Context context, int i) {
        TbsLog.m665i("TbsInstaller", "setTmpFolderCoreToRead call #01 ");
        m408e(context, true);
        C0418l.m374a(context).m389c(i, 2);
    }

    /* JADX INFO: renamed from: a */
    public void m426a(Context context, Bundle bundle) {
        if (bundle == null || context == null) {
            return;
        }
        Object[] objArr = {context, bundle};
        Message message = new Message();
        message.what = 3;
        message.obj = objArr;
        f586m.sendMessage(message);
    }

    /* JADX INFO: renamed from: a */
    public void m427a(Context context, File file, int i) {
        FileOutputStream fileOutputStreamM643b = FileUtil.m643b(context, true, "core_unzip.lock");
        FileLock fileLockM625a = FileUtil.m625a(context, fileOutputStreamM643b);
        if (fileLockM625a == null) {
            TbsLog.m665i("TbsInstaller", "can not get Core unzip FileLock,skip!!!");
            return;
        }
        TbsLog.m665i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread #1");
        boolean zM398a = m398a(context, file, false);
        TbsLog.m665i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread result is " + zM398a);
        if (zM398a) {
            m393a().m425a(context, i);
        }
        FileUtil.m631a(fileLockM625a, fileOutputStreamM643b);
    }

    /* JADX INFO: renamed from: a */
    public void m428a(Context context, String str, int i) {
        TbsLog.m665i("TbsInstaller", "installTbsCore Path: " + str + ";Ver: " + i + "\npn: " + context.getApplicationInfo().processName + "\npid: " + Process.myPid() + "\ntn: " + Thread.currentThread().getName());
        Object[] objArr = {context, str, Integer.valueOf(i)};
        Message message = new Message();
        message.what = 1;
        message.obj = objArr;
        f586m.sendMessage(message);
    }

    /* JADX INFO: renamed from: a */
    public void m429a(Context context, boolean z) {
        int iM386c;
        int iM382b;
        String strM391d;
        int iM387c;
        int iM383b;
        boolean z2 = true;
        if (z) {
            this.f592j = true;
        }
        TbsLog.m665i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.m665i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessId=" + Process.myPid());
        TbsLog.m665i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentThreadName=" + Thread.currentThread().getName());
        if (m453p(context)) {
            ReentrantLock reentrantLock = f582h;
            if (reentrantLock.tryLock()) {
                try {
                    iM386c = C0418l.m374a(context).m386c();
                    iM382b = C0418l.m374a(context).m382b();
                    strM391d = C0418l.m374a(context).m391d("install_apk_path");
                    iM387c = C0418l.m374a(context).m387c("copy_core_ver");
                    iM383b = C0418l.m374a(context).m383b("copy_status");
                    reentrantLock.unlock();
                } catch (Throwable th) {
                    f582h.unlock();
                    throw th;
                }
            } else {
                strM391d = null;
                iM386c = -1;
                iM382b = 0;
                iM387c = 0;
                iM383b = -1;
            }
            m438c();
            TbsLog.m665i("TbsInstaller", "TbsInstaller-continueInstallTbsCore installStatus=" + iM386c);
            TbsLog.m665i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreInstallVer=" + iM382b);
            TbsLog.m665i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsApkPath=" + strM391d);
            TbsLog.m665i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreCopyVer=" + iM387c);
            TbsLog.m665i("TbsInstaller", "TbsInstaller-continueInstallTbsCore copyStatus=" + iM383b);
            int i = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
            if (i != 1 && i != 2 && i != 4) {
                z2 = false;
            }
            if (!z2 && i != 0 && i != 5) {
                Bundle bundle = new Bundle();
                bundle.putInt("operation", 10001);
                m426a(context, bundle);
            }
            if (iM386c > -1 && iM386c < 2) {
                m428a(context, strM391d, iM382b);
            }
            if (iM383b == 0) {
                m436b(context, iM387c);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m430a(QbSdk.InterfaceC0362a interfaceC0362a) {
        this.f593o = interfaceC0362a;
    }

    /* JADX INFO: renamed from: b */
    public int m431b(Context context) {
        if (!m413r(context)) {
            return 0;
        }
        if (m399a(context, "core_unzip_tmp")) {
            return -1;
        }
        if (m399a(context, "core_share_backup_tmp")) {
            return -2;
        }
        if (m399a(context, "core_copy_tmp")) {
            return -3;
        }
        return m399a(context, "tpatch_tmp") ? -4 : 1;
    }

    /* JADX INFO: renamed from: b */
    public int m432b(Context context, String str) {
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 0);
        if (packageArchiveInfo != null) {
            return packageArchiveInfo.versionCode;
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0287  */
    /* JADX INFO: renamed from: b */
    public void m433b(Context context, Bundle bundle) throws Throwable {
        TbsDownloadConfig tbsDownloadConfig;
        int i;
        TbsLog.m665i("TbsInstaller", "TbsInstaller installLocalTbsCoreExInThreadthread " + Thread.currentThread().getName() + Log.getStackTraceString(new Throwable()));
        if (m439c(context)) {
            tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
            i = -539;
        } else {
            TbsLog.m665i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread");
            if (bundle == null || context == null) {
                return;
            }
            if (!FileUtil.m646b(context)) {
                long jM820a = C0462s.m820a();
                long downloadMinFreeSpace = TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.ROM_NOT_ENOUGH, "rom is not enough when patching tbs core! curAvailROM=" + jM820a + ",minReqRom=" + downloadMinFreeSpace);
                tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
                i = -540;
            } else if (m453p(context)) {
                Lock lock = f583i;
                boolean zTryLock = lock.tryLock();
                TbsLog.m665i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread locked=" + zTryLock);
                if (!zTryLock) {
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-547);
                    m438c();
                    return;
                }
                int i2 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
                int i3 = 2;
                try {
                    try {
                        QbSdk.setTBSInstallingStatus(true);
                        if (i2 != 5 && i2 != 3) {
                            if (m445g(context) > 0 && C0418l.m374a(context).m390d() != 1) {
                                if (!(i2 == 1 || i2 == 2 || i2 == 4) && i2 != 0) {
                                    int iM387c = C0418l.m374a(context).m387c("incrupdate_retry_num");
                                    if (iM387c > 5) {
                                        TbsLog.m665i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread exceed incrupdate num");
                                        String string = bundle.getString("old_apk_location");
                                        String string2 = bundle.getString("new_apk_location");
                                        String string3 = bundle.getString("diff_file_location");
                                        if (!TextUtils.isEmpty(string)) {
                                            FileUtil.m645b(new File(string));
                                        }
                                        if (!TextUtils.isEmpty(string2)) {
                                            FileUtil.m645b(new File(string2));
                                        }
                                        if (!TextUtils.isEmpty(string3)) {
                                            FileUtil.m645b(new File(string3));
                                        }
                                        TbsDownloadConfig.getInstance(context).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.TRUE);
                                        TbsDownloadConfig.getInstance(context).commit();
                                        TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.EXCEED_INCR_UPDATE, "incrUpdate exceed retry max num");
                                        lock.unlock();
                                        m438c();
                                        if (i2 == 5) {
                                            m409f(context, 2);
                                        }
                                        QbSdk.setTBSInstallingStatus(false);
                                        return;
                                    }
                                    C0418l.m374a(context).m380a("incrupdate_retry_num", iM387c + 1);
                                    File fileM411o = m411o(context);
                                    if (fileM411o != null && new File(fileM411o, "x5.tbs").exists()) {
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-550);
                                        Bundle bundleM146a = QbSdk.m146a(context, bundle);
                                        if (bundleM146a == null) {
                                            try {
                                                try {
                                                    TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_ERROR_DETAIL, "result null : " + bundle.getInt("new_core_ver"));
                                                    i3 = 1;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    i3 = 1;
                                                    f583i.unlock();
                                                    m438c();
                                                    if (i2 == 5) {
                                                        m409f(context, i3);
                                                    }
                                                    QbSdk.setTBSInstallingStatus(false);
                                                    throw th;
                                                }
                                            } catch (Exception e) {
                                                e = e;
                                                TbsLog.m665i("TbsInstaller", "installLocalTbsCoreExInThread exception:" + Log.getStackTraceString(e));
                                                e.printStackTrace();
                                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                                                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, e.toString());
                                                f583i.unlock();
                                                m438c();
                                                if (i2 == 5) {
                                                    m409f(context, 1);
                                                }
                                            }
                                        } else {
                                            i3 = bundleM146a.getInt("patch_result");
                                            if (i3 != 0) {
                                                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_ERROR_DETAIL, "result " + i3 + " : " + bundle.getInt("new_core_ver"));
                                            }
                                        }
                                    }
                                }
                                lock.unlock();
                                m438c();
                                if (i2 == 5) {
                                    m409f(context, i3);
                                }
                                QbSdk.setTBSInstallingStatus(false);
                                return;
                            }
                            QbSdk.setTBSInstallingStatus(false);
                            lock.unlock();
                            m438c();
                            if (i2 == 5) {
                                m409f(context, 2);
                            }
                            QbSdk.setTBSInstallingStatus(false);
                            return;
                        }
                        int iM403c = m403c(context, bundle);
                        TbsLog.m665i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread doTpatch result is " + iM403c);
                        if (iM403c == 1) {
                            C0418l.m374a(context).m380a("tpatch_num", C0418l.m374a(context).m387c("tpatch_num") + 1);
                        }
                        lock.unlock();
                        m438c();
                        if (i2 == 5) {
                            m409f(context, iM403c);
                        }
                        QbSdk.setTBSInstallingStatus(false);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        f583i.unlock();
                        m438c();
                        if (i2 == 5) {
                            m409f(context, i3);
                        }
                        QbSdk.setTBSInstallingStatus(false);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } else {
                tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
                i = -541;
            }
        }
        tbsDownloadConfig.setInstallInterruptCode(i);
    }

    /* JADX WARN: Code duplicated, block: B:247:0x0476 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @TargetApi(11)
    /* JADX INFO: renamed from: b */
    public void m434b(Context context, String str, int i) {
        boolean z;
        int i2;
        int iM432b;
        int i3;
        SharedPreferences sharedPreferences;
        TbsLogReport tbsLogReport;
        int iM412q;
        String str2;
        String strM391d;
        boolean z2;
        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-501);
        if (m439c(context)) {
            TbsLog.m667i("TbsInstaller", "isTbsLocalInstalled --> no installation!", true);
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-502);
            QbSdk.f209n.onInstallFinish(-502);
            return;
        }
        TbsLog.m665i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsApkPath=" + str);
        TbsLog.m665i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer=" + i);
        TbsLog.m665i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.m665i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentProcessId=" + Process.myPid());
        TbsLog.m665i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentThreadName=" + Thread.currentThread().getName());
        int i4 = Build.VERSION.SDK_INT;
        if ((i4 >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).getInt("tbs_precheck_disable_version", -1) == i) {
            TbsLog.m662e("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- version:" + i + " is disabled by preload_x5_check!");
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-503);
            QbSdk.f209n.onInstallFinish(-503);
            return;
        }
        if (!FileUtil.m646b(context)) {
            long jM820a = C0462s.m820a();
            long downloadMinFreeSpace = TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-504);
            String str3 = "rom is not enough when installing tbs core! curAvailROM=" + jM820a + ",minReqRom=" + downloadMinFreeSpace;
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.ROM_NOT_ENOUGH, str3);
            TbsLog.m665i("TbsInstaller", str3);
            QbSdk.f209n.onInstallFinish(TbsListener.ErrorCode.ROM_NOT_ENOUGH);
            return;
        }
        if (!m453p(context)) {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-505);
            TbsLog.m665i("TbsInstaller", "getInstalling file lock failed,return!");
            QbSdk.f209n.onInstallFinish(-505);
            return;
        }
        Lock lock = f583i;
        boolean zTryLock = lock.tryLock();
        TbsLog.m665i("TbsInstaller", "TbsInstaller-installTbsCoreInThread locked =" + zTryLock);
        if (!zTryLock) {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-519);
            m438c();
            return;
        }
        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-507);
        ReentrantLock reentrantLock = f582h;
        reentrantLock.lock();
        try {
            int iM387c = C0418l.m374a(context).m387c("copy_core_ver");
            int iM382b = C0418l.m374a(context).m382b();
            TbsLog.m665i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreCopyVer =" + iM387c);
            TbsLog.m665i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstallVer =" + iM382b);
            TbsLog.m665i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer =" + i);
            if ((iM382b > 0 && i > iM382b) || (iM387c > 0 && i > iM387c)) {
                m450l(context);
            }
            int iM386c = C0418l.m374a(context).m386c();
            int iM445g = m445g(context);
            TbsLog.m665i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus1=" + iM386c);
            TbsLog.m665i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstalledVer=" + iM445g);
            if (iM386c < 0 || iM386c >= 2) {
                if (iM386c == 3 && iM445g >= 0 && (i > iM445g || i == 88888888)) {
                    m450l(context);
                    TbsLog.m667i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- update TBS.....", true);
                    iM386c = -1;
                }
                z = false;
            } else {
                TbsLog.m667i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- retry.....", true);
                z = true;
            }
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-508);
            TbsLog.m665i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus2=" + iM386c);
            if (iM386c < 1) {
                TbsLog.m667i("TbsInstaller", "STEP 2/2 begin installation.....", true);
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-509);
                if (z) {
                    int iM387c2 = C0418l.m374a(context).m387c("unzip_retry_num");
                    if (iM387c2 > 10) {
                        TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.EXCEED_UNZIP_RETRY_NUM, "exceed unzip retry num!");
                        m420y(context);
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-510);
                        try {
                            reentrantLock.unlock();
                            lock.unlock();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        try {
                            m438c();
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    C0418l.m374a(context).m384b(iM387c2 + 1);
                }
                if (str == null) {
                    strM391d = C0418l.m374a(context).m391d("install_apk_path");
                    if (strM391d == null) {
                        TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.APK_PATH_ERROR, "apk path is null!");
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-511);
                        try {
                            reentrantLock.unlock();
                            lock.unlock();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        try {
                            m438c();
                            return;
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            return;
                        }
                    }
                } else {
                    strM391d = str;
                }
                TbsLog.m665i("TbsInstaller", "TbsInstaller-installTbsCoreInThread apkPath =" + strM391d);
                iM432b = m432b(context, strM391d);
                if (iM432b == 0) {
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-512);
                    TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.APK_VERSION_ERROR, "apk version is 0!");
                    try {
                        reentrantLock.unlock();
                        lock.unlock();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                    try {
                        m438c();
                        return;
                    } catch (Exception e6) {
                        e6.printStackTrace();
                        return;
                    }
                }
                C0418l.m374a(context).m381a("install_apk_path", strM391d);
                C0418l.m374a(context).m389c(iM432b, 0);
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-548);
                if (!m402b(context, new File(strM391d))) {
                    TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.UNZIP_OTHER_ERROR, "unzipTbsApk failed");
                    try {
                        reentrantLock.unlock();
                        lock.unlock();
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                    try {
                        m438c();
                        return;
                    } catch (Exception e8) {
                        e8.printStackTrace();
                        return;
                    }
                }
                if (z) {
                    int iM383b = C0418l.m374a(context).m383b("unlzma_status");
                    if (iM383b > 5) {
                        TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, "exceed unlzma retry num!");
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-553);
                        m420y(context);
                        C0417k.m351b(context);
                        Map<String, Object> map = TbsDownloadConfig.getInstance(context).mSyncMap;
                        Boolean bool = Boolean.TRUE;
                        map.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, bool);
                        TbsDownloadConfig.getInstance(context).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_FULL_PACKAGE, bool);
                        TbsDownloadConfig.getInstance(context).commit();
                        try {
                            reentrantLock.unlock();
                            lock.unlock();
                        } catch (Exception e9) {
                            e9.printStackTrace();
                        }
                        try {
                            m438c();
                            return;
                        } catch (Exception e10) {
                            e10.printStackTrace();
                            return;
                        }
                    }
                    C0418l.m374a(context).m392d(iM383b + 1);
                }
                TbsLog.m665i("TbsInstaller", "unlzma begin");
                int i5 = TbsDownloadConfig.getInstance().mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
                if (m445g(context) != 0) {
                    Object objM147a = QbSdk.m147a(context, "can_unlzma", (Bundle) null);
                    if ((objM147a == null || !(objM147a instanceof Boolean)) ? false : ((Boolean) objM147a).booleanValue()) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("responseCode", i5);
                        bundle.putString("unzip_temp_path", TbsDownloader.m183a(context) ? m451m(context).getAbsolutePath() : m442e(context, 0).getAbsolutePath());
                        Object objM147a2 = QbSdk.m147a(context, "unlzma", bundle);
                        if (objM147a2 == null) {
                            TbsLog.m665i("TbsInstaller", "unlzma return null");
                            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.UNLZMA_FAIURE, "unlzma is null");
                        } else {
                            if (objM147a2 instanceof Boolean) {
                                if (((Boolean) objM147a2).booleanValue()) {
                                    TbsLog.m665i("TbsInstaller", "unlzma success");
                                    z2 = true;
                                } else {
                                    TbsLog.m665i("TbsInstaller", "unlzma return false");
                                    TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.UNLZMA_FAIURE, "unlzma return false");
                                }
                            } else if (objM147a2 instanceof Bundle) {
                                z2 = true;
                            } else if (objM147a2 instanceof Throwable) {
                                TbsLog.m665i("TbsInstaller", "unlzma failure because Throwable" + Log.getStackTraceString((Throwable) objM147a2));
                                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.UNLZMA_FAIURE, (Throwable) objM147a2);
                            }
                            if (!z2) {
                                try {
                                    reentrantLock.unlock();
                                    lock.unlock();
                                } catch (Exception e11) {
                                    e11.printStackTrace();
                                }
                                try {
                                    m438c();
                                    return;
                                } catch (Exception e12) {
                                    e12.printStackTrace();
                                    return;
                                }
                            }
                        }
                        z2 = false;
                        if (!z2) {
                            reentrantLock.unlock();
                            lock.unlock();
                            m438c();
                            return;
                        }
                    }
                }
                TbsLog.m665i("TbsInstaller", "unlzma finished");
                C0418l.m374a(context).m389c(iM432b, 1);
                i2 = 2;
            } else {
                i2 = 2;
                iM432b = 0;
            }
            if (iM386c < i2) {
                if (z) {
                    int iM387c3 = C0418l.m374a(context).m387c("dexopt_retry_num");
                    if (iM387c3 > 10) {
                        TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.EXCEED_DEXOPT_RETRY_NUM, "exceed dexopt retry num!");
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-514);
                        m420y(context);
                        try {
                            reentrantLock.unlock();
                            lock.unlock();
                        } catch (Exception e13) {
                            e13.printStackTrace();
                        }
                        try {
                            m438c();
                            return;
                        } catch (Exception e14) {
                            e14.printStackTrace();
                            return;
                        }
                    }
                    C0418l.m374a(context).m377a(iM387c3 + 1);
                }
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-549);
                if (!m410g(context, 0)) {
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-515);
                    try {
                        reentrantLock.unlock();
                        lock.unlock();
                    } catch (Exception e15) {
                        e15.printStackTrace();
                    }
                    try {
                        m438c();
                        return;
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        return;
                    }
                }
                C0418l.m374a(context).m389c(iM432b, 2);
                TbsLog.m667i("TbsInstaller", "STEP 2/2 installation completed! you can restart!", true);
                TbsLog.m665i("TbsInstaller", "STEP 2/2 installation completed! you can restart! version:" + i);
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-516);
                if (i4 >= 11) {
                    sharedPreferences = context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
                    i3 = 0;
                } else {
                    i3 = 0;
                    sharedPreferences = context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
                }
                try {
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putInt("tbs_preload_x5_counter", i3);
                    editorEdit.putInt("tbs_preload_x5_recorder", i3);
                    editorEdit.putInt("tbs_preload_x5_version", i);
                    editorEdit.commit();
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-517);
                } catch (Throwable th) {
                    TbsLog.m662e("TbsInstaller", "Init tbs_preload_x5_counter#1 exception:" + Log.getStackTraceString(th));
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-518);
                }
                if (i == 88888888) {
                    m394a(i, str, context);
                }
                if (this.f592j) {
                    tbsLogReport = TbsLogReport.getInstance(context);
                    iM412q = m412q(context);
                    str2 = "continueInstallWithout core success";
                } else {
                    if (str != null) {
                        FileUtil.m645b(new File(str));
                    }
                    tbsLogReport = TbsLogReport.getInstance(context);
                    iM412q = m412q(context);
                    str2 = "success";
                }
                tbsLogReport.setInstallErrorCode(iM412q, str2);
            } else if (iM386c == i2) {
                if (str != null) {
                    FileUtil.m645b(new File(str));
                }
                QbSdk.f209n.onInstallFinish(200);
            }
            try {
                f582h.unlock();
                f583i.unlock();
            } catch (Exception e17) {
                e17.printStackTrace();
            }
            try {
                m438c();
            } catch (Exception e18) {
                e18.printStackTrace();
            }
        } catch (Throwable th2) {
            try {
                f582h.unlock();
                f583i.unlock();
            } catch (Exception e19) {
                e19.printStackTrace();
            }
            try {
                m438c();
                throw th2;
            } catch (Exception e20) {
                e20.printStackTrace();
                throw th2;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m435b(Context context, boolean z) {
        String str;
        if (QbSdk.f197b) {
            return;
        }
        if (Build.VERSION.SDK_INT < 8) {
            TbsLog.m664e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
            return;
        }
        TbsLog.m666i("TbsInstaller", "installTbsCoreIfNeeded", "#1# check local x5core prepared to install");
        if (m413r(context)) {
            TbsLog.m666i("TbsInstaller", "installTbsCoreIfNeeded", "#2# try to install tbs core from tmp dir");
            if (m399a(context, "core_unzip_tmp") && m407d(context, z)) {
                str = "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromUnzip !!";
            } else {
                str = (m399a(context, "tpatch_tmp") && m405c(context, z)) ? "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromTpatch !!" : "TbsInstaller-installTbsCoreIfNeeded, error !!";
            }
            TbsLog.m665i("TbsInstaller", str);
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean m436b(Context context, int i) {
        if (TbsDownloader.getOverSea(context)) {
            return false;
        }
        TbsLog.m665i("TbsInstaller", "TbsInstaller-installLocalTbsCore targetTbsCoreVer=" + i);
        TbsLog.m665i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.m665i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentProcessId=" + Process.myPid());
        TbsLog.m665i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentThreadName=" + Thread.currentThread().getName());
        Context contextM437c = m437c(context, i);
        if (contextM437c == null) {
            TbsLog.m665i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
            return false;
        }
        Object[] objArr = {contextM437c, context, Integer.valueOf(i)};
        Message message = new Message();
        message.what = 2;
        message.obj = objArr;
        f586m.sendMessage(message);
        return true;
    }

    @Deprecated
    /* JADX INFO: renamed from: c */
    public Context m437c(Context context, int i) {
        return null;
    }

    /* JADX INFO: renamed from: c */
    public synchronized void m438c() {
        int i = this.f588d;
        if (i <= 0) {
            TbsLog.m665i("TbsInstaller", "releaseTbsInstallingFileLock currentTbsFileLockStackCount=" + this.f588d + "call stack:" + Log.getStackTraceString(new Throwable()));
            return;
        }
        if (i > 1) {
            TbsLog.m665i("TbsInstaller", "releaseTbsInstallingFileLock with skip");
            this.f588d--;
        } else {
            if (i == 1) {
                TbsLog.m665i("TbsInstaller", "releaseTbsInstallingFileLock without skip");
                FileUtil.m631a(this.f589e, this.f590f);
                this.f588d = 0;
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public boolean m439c(Context context) {
        File file = new File(m452n(context), "tbs.conf");
        boolean z = false;
        if (!file.exists()) {
            return false;
        }
        Properties properties = new Properties();
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                properties.load(bufferedInputStream2);
                boolean zBooleanValue = Boolean.valueOf(properties.getProperty("tbs_local_installation", "false")).booleanValue();
                if (zBooleanValue) {
                    try {
                        if (System.currentTimeMillis() - file.lastModified() > 259200000) {
                            z = true;
                        }
                    } catch (Throwable th) {
                        th = th;
                        z = zBooleanValue;
                        bufferedInputStream = bufferedInputStream2;
                        try {
                            th.printStackTrace();
                            return z;
                        } finally {
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
                TbsLog.m665i("TbsInstaller", "TBS_LOCAL_INSTALLATION is:" + zBooleanValue + " expired=" + z);
                boolean z2 = zBooleanValue & (!z);
                try {
                    bufferedInputStream2.close();
                    return z2;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return z2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: renamed from: d */
    public int m440d(Context context, int i) {
        return m421a(m442e(context, i));
    }

    /* JADX INFO: renamed from: d */
    public void m441d(Context context) {
        BufferedInputStream bufferedInputStream;
        try {
            File file = new File(m452n(context), "tbs.conf");
            Properties properties = new Properties();
            BufferedOutputStream bufferedOutputStream = null;
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream);
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        properties.setProperty("tbs_local_installation", "false");
                        properties.store(bufferedOutputStream2, (String) null);
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException unused) {
                        }
                    } catch (Throwable unused2) {
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (bufferedInputStream == null) {
                            return;
                        }
                    }
                } catch (Throwable unused4) {
                }
            } catch (Throwable unused5) {
                bufferedInputStream = null;
            }
            bufferedInputStream.close();
        } catch (Throwable unused6) {
        }
    }

    /* JADX INFO: renamed from: e */
    public File m442e(Context context, int i) {
        return m423a(context, i, true);
    }

    /* JADX INFO: renamed from: e */
    public void m443e(Context context) {
        FileLock fileLock = f584k;
        if (fileLock != null) {
            FileUtil.m626a(context, fileLock);
        }
    }

    /* JADX INFO: renamed from: f */
    public int m444f(Context context) {
        BufferedInputStream bufferedInputStream = null;
        try {
            File file = new File(m451m(context), "tbs.conf");
            if (!file.exists()) {
                return 0;
            }
            Properties properties = new Properties();
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                properties.load(bufferedInputStream2);
                bufferedInputStream2.close();
                String property = properties.getProperty("tbs_core_version");
                if (property == null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return 0;
                }
                int i = Integer.parseInt(property);
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused2) {
                }
                return i;
            } catch (Exception unused3) {
                bufferedInputStream = bufferedInputStream2;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException unused6) {
            }
        }
        return 0;
    }

    /* JADX INFO: renamed from: g */
    public int m445g(Context context) {
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                File file = new File(m452n(context), "tbs.conf");
                if (!file.exists()) {
                    return 0;
                }
                TbsLog.m665i("TbsInstaller", "getTbsCoreInstalledVerInNolock tbsPropFile is " + file.getAbsolutePath());
                Properties properties = new Properties();
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream2);
                    bufferedInputStream2.close();
                    String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e) {
                            TbsLog.m665i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e.toString());
                        }
                        return 0;
                    }
                    int i = Integer.parseInt(property);
                    if (f587n == 0) {
                        f587n = i;
                    }
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e2) {
                        TbsLog.m665i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e2.toString());
                    }
                    return i;
                } catch (Exception e3) {
                    e = e3;
                    bufferedInputStream = bufferedInputStream2;
                    TbsLog.m665i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock Exception=" + e.toString());
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                            TbsLog.m665i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e4.toString());
                        }
                    }
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                }
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException e6) {
                TbsLog.m665i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e6.toString());
            }
        }
        throw th;
    }

    /* JADX INFO: renamed from: h */
    public int m446h(Context context) {
        int i = f587n;
        return i != 0 ? i : m445g(context);
    }

    /* JADX INFO: renamed from: i */
    public void m447i(Context context) {
        if (f587n != 0) {
            return;
        }
        f587n = m445g(context);
    }

    /* JADX INFO: renamed from: j */
    public boolean m448j(Context context) {
        return new File(m452n(context), "tbs.conf").exists();
    }

    /* JADX INFO: renamed from: k */
    public int m449k(Context context) {
        if (!m453p(context)) {
            return -1;
        }
        ReentrantLock reentrantLock = f582h;
        boolean zTryLock = reentrantLock.tryLock();
        TbsLog.m665i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock locked=" + zTryLock);
        if (!zTryLock) {
            m438c();
            return 0;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                File file = new File(m452n(context), "tbs.conf");
                if (!file.exists()) {
                    try {
                        if (reentrantLock.isHeldByCurrentThread()) {
                            reentrantLock.unlock();
                        }
                    } catch (Throwable th) {
                        TbsLog.m662e("TbsInstaller", "TbsRenameLock.unlock exception: " + th);
                    }
                    m438c();
                    return 0;
                }
                Properties properties = new Properties();
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream2);
                    bufferedInputStream2.close();
                    String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e) {
                            TbsLog.m665i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock IOException=" + e.toString());
                        }
                        try {
                            ReentrantLock reentrantLock2 = f582h;
                            if (reentrantLock2.isHeldByCurrentThread()) {
                                reentrantLock2.unlock();
                            }
                        } catch (Throwable th2) {
                            TbsLog.m662e("TbsInstaller", "TbsRenameLock.unlock exception: " + th2);
                        }
                        m438c();
                        return 0;
                    }
                    ThreadLocal<Integer> threadLocal = f585l;
                    threadLocal.set(Integer.valueOf(Integer.parseInt(property)));
                    int iIntValue = threadLocal.get().intValue();
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e2) {
                        TbsLog.m665i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock IOException=" + e2.toString());
                    }
                    try {
                        ReentrantLock reentrantLock3 = f582h;
                        if (reentrantLock3.isHeldByCurrentThread()) {
                            reentrantLock3.unlock();
                        }
                    } catch (Throwable th3) {
                        TbsLog.m662e("TbsInstaller", "TbsRenameLock.unlock exception: " + th3);
                    }
                    m438c();
                    return iIntValue;
                } catch (Exception e3) {
                    e = e3;
                    bufferedInputStream = bufferedInputStream2;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                            TbsLog.m665i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock IOException=" + e4.toString());
                        }
                    }
                    try {
                        ReentrantLock reentrantLock4 = f582h;
                        if (reentrantLock4.isHeldByCurrentThread()) {
                            reentrantLock4.unlock();
                        }
                    } catch (Throwable th5) {
                        TbsLog.m662e("TbsInstaller", "TbsRenameLock.unlock exception: " + th5);
                    }
                    m438c();
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e5) {
            e = e5;
        }
        TbsLog.m665i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock Exception=" + e.toString());
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException e6) {
                TbsLog.m665i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock IOException=" + e6.toString());
            }
        }
        try {
            ReentrantLock reentrantLock5 = f582h;
            if (reentrantLock5.isHeldByCurrentThread()) {
                reentrantLock5.unlock();
            }
        } catch (Throwable th7) {
            TbsLog.m662e("TbsInstaller", "TbsRenameLock.unlock exception: " + th7);
        }
        m438c();
        return 0;
    }

    /* JADX INFO: renamed from: l */
    public void m450l(Context context) {
        TbsLog.m665i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
        C0418l.m374a(context).m377a(0);
        C0418l.m374a(context).m384b(0);
        C0418l.m374a(context).m392d(0);
        C0418l.m374a(context).m380a("incrupdate_retry_num", 0);
        if (TbsDownloader.m183a(context)) {
            return;
        }
        C0418l.m374a(context).m389c(0, -1);
        C0418l.m374a(context).m379a(BuildConfig.FLAVOR);
        C0418l.m374a(context).m380a("copy_retry_num", 0);
        C0418l.m374a(context).m388c(-1);
        C0418l.m374a(context).m378a(0, -1);
        FileUtil.m628a(m442e(context, 0), true);
        FileUtil.m628a(m442e(context, 1), true);
    }

    /* JADX INFO: renamed from: m */
    public File m451m(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "core_share_decouple");
        if (file.isDirectory() || file.mkdir()) {
            return file;
        }
        return null;
    }

    /* JADX INFO: renamed from: n */
    public File m452n(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "core_share");
        if (file.isDirectory() || file.mkdir()) {
            return file;
        }
        TbsLog.m665i("TbsInstaller", "getTbsCoreShareDir,mkdir false");
        return null;
    }

    /* JADX INFO: renamed from: p */
    public synchronized boolean m453p(Context context) {
        if (this.f588d > 0) {
            TbsLog.m665i("TbsInstaller", "getTbsInstallingFileLock success,is cached= true");
            this.f588d++;
            return true;
        }
        FileOutputStream fileOutputStreamM643b = FileUtil.m643b(context, true, "tbslock.txt");
        this.f590f = fileOutputStreamM643b;
        if (fileOutputStreamM643b == null) {
            TbsLog.m665i("TbsInstaller", "getTbsInstallingFileLock get install fos failed");
            return false;
        }
        FileLock fileLockM625a = FileUtil.m625a(context, fileOutputStreamM643b);
        this.f589e = fileLockM625a;
        if (fileLockM625a == null) {
            TbsLog.m665i("TbsInstaller", "getTbsInstallingFileLock tbsFileLockFileLock == null");
            return false;
        }
        TbsLog.m665i("TbsInstaller", "getTbsInstallingFileLock success,is cached= false");
        this.f588d++;
        return true;
    }
}
