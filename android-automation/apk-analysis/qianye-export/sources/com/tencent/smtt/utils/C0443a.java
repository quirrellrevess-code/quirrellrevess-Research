package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsExtensionFunctionManager;
import com.tencent.smtt.sdk.TbsPVConfig;
import com.tencent.smtt.sdk.TbsShareManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.jar.JarFile;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.tencent.smtt.utils.a */
/* JADX INFO: loaded from: classes.dex */
public class C0443a {
    /* JADX INFO: renamed from: a */
    public static int m681a(Context context, File file) {
        return m682a(context, file, 0);
    }

    /* JADX INFO: renamed from: a */
    public static int m682a(Context context, File file, int i) {
        try {
            return m683a(context, file, Build.VERSION.SDK_INT >= 20 ? !TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.DISABLE_GET_APK_VERSION_SWITCH_FILE_NAME) : false, i);
        } catch (Exception unused) {
            TbsLog.m665i("ApkUtil", "getApkVersion Failed");
            return 0;
        }
    }

    /* JADX INFO: renamed from: a */
    public static int m683a(Context context, File file, boolean z, int i) {
        int iM687b;
        if (file != null) {
            try {
                if (file.exists()) {
                    boolean zContains = file.getName().contains("tbs.org");
                    boolean zContains2 = file.getName().contains("x5.tbs.decouple");
                    if (zContains || zContains2) {
                        int iM684a = m684a(zContains2, file, i);
                        if (iM684a > 0) {
                            return iM684a;
                        }
                        if (!TbsShareManager.isThirdPartyApp(context) && !file.getAbsolutePath().contains(context.getApplicationInfo().packageName)) {
                            return 0;
                        }
                    }
                    int i2 = Build.VERSION.SDK_INT;
                    boolean z2 = (i2 == 23 || i2 == 25) && Build.MANUFACTURER.toLowerCase().contains("mi");
                    TbsPVConfig.releaseInstance();
                    int readApk = TbsPVConfig.getInstance(context).getReadApk();
                    if (readApk == 1) {
                        z = false;
                        z2 = false;
                    } else if (readApk == 2) {
                        return 0;
                    }
                    if ((z || z2) && (iM687b = m687b(file)) > 0) {
                        return iM687b;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (file == null || !file.exists()) {
            return 0;
        }
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.versionCode;
            }
            return 0;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return -1;
        }
    }

    /* JADX INFO: renamed from: a */
    private static int m684a(boolean z, File file, int i) {
        try {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                return -1;
            }
            File[] fileArrListFiles = parentFile.listFiles();
            Pattern patternCompile = Pattern.compile(m686a(z, i) + "(.*)");
            for (File file2 : fileArrListFiles) {
                if (patternCompile.matcher(file2.getName()).find() && file2.isFile() && file2.exists()) {
                    return Integer.parseInt(file2.getName().substring(file2.getName().lastIndexOf(".") + 1));
                }
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0068: MOVE (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:32:0x0068 */
    /* JADX INFO: renamed from: a */
    public static String m685a(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        int i;
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[32];
        FileInputStream fileInputStream3 = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i2 = fileInputStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i2);
                    }
                    byte[] bArrDigest = messageDigest.digest();
                    int i3 = 0;
                    for (i = 0; i < 16; i++) {
                        byte b = bArrDigest[i];
                        int i4 = i3 + 1;
                        cArr2[i3] = cArr[(b >>> 4) & 15];
                        i3 = i4 + 1;
                        cArr2[i4] = cArr[b & 15];
                    }
                    String str = new String(cArr2);
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return str;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Exception e4) {
                e = e4;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                if (fileInputStream3 != null) {
                    try {
                        fileInputStream3.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream3 = fileInputStream2;
            if (fileInputStream3 != null) {
                fileInputStream3.close();
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public static final String m686a(boolean z, int i) {
        boolean zM703c;
        if (i == 64) {
            zM703c = true;
        } else {
            zM703c = i == 32 ? false : C0445b.m703c();
        }
        if (zM703c) {
            return z ? "x5.64.decouple.backup" : "x5.64.backup";
        }
        return z ? "x5.decouple.backup" : "x5.backup";
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00c3 A[Catch: all -> 0x00b3, Exception -> 0x00c6, TRY_LEAVE, TryCatch #1 {all -> 0x00b3, blocks: (B:16:0x0086, B:17:0x008c, B:19:0x008e, B:20:0x0091, B:41:0x00b9, B:34:0x00af, B:45:0x00be, B:47:0x00c3, B:48:0x00c6), top: B:54:0x0032 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.util.jar.JarFile] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.util.jar.JarFile] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.util.jar.JarFile] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.io.BufferedReader] */
    /* JADX INFO: renamed from: b */
    public static int m687b(File file) {
        Throwable th;
        Exception e;
        BufferedReader bufferedReader;
        String[] strArrSplit;
        ?? sb = new StringBuilder();
        sb.append("getApkVersionByReadFile");
        sb.append(file);
        sb.append("exists:");
        sb.append(file.exists());
        sb.append(";canread:");
        ?? CanRead = file.canRead();
        sb.append(CanRead);
        TbsLog.m665i(TbsDownloader.LOGTAG, sb.toString());
        synchronized (C0443a.class) {
            try {
                try {
                    try {
                        try {
                            CanRead = new JarFile((File) file);
                            try {
                                bufferedReader = new BufferedReader(new InputStreamReader(CanRead.getInputStream(CanRead.getJarEntry("assets/webkit/tbs.conf"))));
                                while (true) {
                                    try {
                                        String line = bufferedReader.readLine();
                                        if (line == null) {
                                            bufferedReader.close();
                                            break;
                                        }
                                        if (line.contains("tbs_core_version") && (strArrSplit = line.split("=")) != null && strArrSplit.length == 2) {
                                            String strTrim = strArrSplit[1].trim();
                                            TbsLog.m665i(TbsDownloader.LOGTAG, "getApkVersionByReadFile version is " + strTrim);
                                            int i = Integer.parseInt(strTrim);
                                            try {
                                                bufferedReader.close();
                                                CanRead.close();
                                            } catch (Exception unused) {
                                            }
                                            return i;
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        TbsLog.m668i(e);
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                        if (CanRead != 0) {
                                            break;
                                        }
                                        return -1;
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                bufferedReader = null;
                            } catch (Throwable th2) {
                                th = th2;
                                file = 0;
                                if (file != 0) {
                                    try {
                                        file.close();
                                        if (CanRead != 0) {
                                            CanRead.close();
                                        }
                                    } catch (Exception unused2) {
                                        throw th;
                                    }
                                } else if (CanRead != 0) {
                                    CanRead.close();
                                }
                                throw th;
                            }
                        } catch (Exception e4) {
                            CanRead = 0;
                            e = e4;
                            bufferedReader = null;
                        } catch (Throwable th3) {
                            CanRead = 0;
                            th = th3;
                            file = 0;
                        }
                        CanRead.close();
                        return -1;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            } catch (Exception unused3) {
            }
        }
    }
}
