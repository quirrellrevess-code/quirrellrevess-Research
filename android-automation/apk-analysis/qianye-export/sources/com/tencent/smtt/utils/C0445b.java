package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.flexbox.BuildConfig;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.tencent.smtt.utils.b */
/* JADX INFO: loaded from: classes.dex */
public class C0445b {

    /* JADX INFO: renamed from: a */
    public static String f705a = "";

    /* JADX INFO: renamed from: b */
    public static String f706b = "";

    /* JADX INFO: renamed from: c */
    public static String f707c = "";

    /* JADX INFO: renamed from: d */
    public static String f708d = "";

    /* JADX INFO: renamed from: e */
    public static String f709e = "";

    /* JADX INFO: renamed from: f */
    public static String f710f = "";

    /* JADX INFO: renamed from: g */
    private static boolean f711g = false;

    /* JADX INFO: renamed from: h */
    private static boolean f712h = false;

    /* JADX INFO: renamed from: i */
    private static boolean f713i = false;

    /* JADX INFO: renamed from: a */
    public static String m688a() {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        String strM699b = "os.arch";
        if (!f712h) {
            String strM699b2 = null;
            try {
                inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream());
                try {
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                        try {
                            strM699b = m699b(bufferedReader.readLine().contains("x86") ? "i686" : System.getProperty("os.arch"));
                            if (strM699b != null) {
                                f707c = strM699b;
                            }
                            try {
                                bufferedReader.close();
                            } catch (IOException unused) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            try {
                                strM699b2 = m699b(System.getProperty(strM699b));
                                th.printStackTrace();
                                if (strM699b2 != null) {
                                    f707c = strM699b2;
                                }
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                if (inputStreamReader != null) {
                                }
                                f712h = true;
                                return f707c;
                            } catch (Throwable th2) {
                                if (strM699b2 != null) {
                                    f707c = strM699b2;
                                }
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                                if (inputStreamReader == null) {
                                    throw th2;
                                }
                                try {
                                    inputStreamReader.close();
                                    throw th2;
                                } catch (IOException unused4) {
                                    throw th2;
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                    }
                    inputStreamReader.close();
                } catch (IOException unused5) {
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                inputStreamReader = null;
            }
            f712h = true;
        }
        return f707c;
    }

    /* JADX INFO: renamed from: a */
    public static String m689a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m690a(Context context, File file) {
        Signature signature;
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 65);
            if (packageArchiveInfo == null) {
                signature = null;
            } else if (packageArchiveInfo.signatures == null || packageArchiveInfo.signatures.length <= 0) {
                TbsLog.m672w("AppUtil", "[getSignatureFromApk] pkgInfo is not null BUT signatures is null!");
                signature = null;
            } else {
                signature = packageArchiveInfo.signatures[0];
            }
            if (signature != null) {
                return signature.toCharsString();
            }
            return null;
        } catch (Exception unused) {
            TbsLog.m665i("AppUtil", "getSign " + file + "failed");
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m691a(Context context, String str) {
        String strValueOf = null;
        try {
            strValueOf = String.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(str));
            return String.valueOf(Integer.toHexString(Integer.parseInt(strValueOf)));
        } catch (Exception unused) {
            return strValueOf;
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m692a(Context context, boolean z, File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        Exception e;
        if (file == null || !file.exists()) {
            return BuildConfig.FLAVOR;
        }
        if (z) {
            RandomAccessFile randomAccessFile2 = null;
            try {
                try {
                    byte[] bArr = new byte[2];
                    randomAccessFile = new RandomAccessFile(file, "r");
                    try {
                        try {
                            randomAccessFile.read(bArr);
                            if (!new String(bArr).equalsIgnoreCase("PK")) {
                                try {
                                    randomAccessFile.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                                return BuildConfig.FLAVOR;
                            }
                            randomAccessFile.close();
                        } catch (Throwable th) {
                            th = th;
                            randomAccessFile2 = randomAccessFile;
                            try {
                                randomAccessFile2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        e.printStackTrace();
                        randomAccessFile.close();
                    }
                } catch (Exception e5) {
                    randomAccessFile = null;
                    e = e5;
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile2.close();
                    throw th;
                }
            } catch (IOException e6) {
                e6.printStackTrace();
            }
        }
        try {
            if (context.getApplicationContext().getPackageName().contains("com.jd.jrapp")) {
                TbsLog.m665i("AppUtil", "[AppUtil.getSignatureFromApk]  #1");
                String strM693a = m693a(file);
                if (strM693a != null) {
                    TbsLog.m665i("AppUtil", "[AppUtil.getSignatureFromApk]  #2");
                    return strM693a;
                }
            }
        } catch (Throwable unused) {
            TbsLog.m665i("AppUtil", "[AppUtil.getSignatureFromApk]  #3");
        }
        TbsLog.m665i("AppUtil", "[AppUtil.getSignatureFromApk]  #4");
        String strM690a = m690a(context, file);
        TbsLog.m665i("AppUtil", "[AppUtil.getSignatureFromApk]  android api signature=" + strM690a);
        if (strM690a != null) {
            return strM690a;
        }
        String strM693a2 = m693a(file);
        TbsLog.m665i("AppUtil", "[AppUtil.getSignatureFromApk]  java get signature=" + strM693a2);
        return strM693a2;
    }

    /* JADX INFO: renamed from: a */
    private static String m693a(File file) {
        try {
            JarFile jarFile = new JarFile(file);
            byte[] bArr = new byte[8192];
            String strM694a = m694a(m697a(jarFile, jarFile.getJarEntry("AndroidManifest.xml"), bArr)[0].getEncoded());
            Enumeration<JarEntry> enumerationEntries = jarFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                JarEntry jarEntryNextElement = enumerationEntries.nextElement();
                String name = jarEntryNextElement.getName();
                if (name != null) {
                    Certificate[] certificateArrM697a = m697a(jarFile, jarEntryNextElement, bArr);
                    String strM694a2 = certificateArrM697a != null ? m694a(certificateArrM697a[0].getEncoded()) : null;
                    if (strM694a2 == null) {
                        if (!name.startsWith("META-INF/")) {
                            return null;
                        }
                    } else if (!strM694a2.equals(strM694a)) {
                        return null;
                    }
                }
            }
            return strM694a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m694a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length * 2];
        for (int i = 0; i < length; i++) {
            byte b = bArr[i];
            int i2 = (b >> 4) & 15;
            int i3 = i * 2;
            cArr[i3] = (char) (i2 >= 10 ? (i2 + 97) - 10 : i2 + 48);
            int i4 = b & 15;
            cArr[i3 + 1] = (char) (i4 >= 10 ? (i4 + 97) - 10 : i4 + 48);
        }
        return new String(cArr);
    }

    /* JADX INFO: renamed from: a */
    public static void m695a(String str, boolean z) {
        if (z) {
            str = C0454k.m768a(str);
        }
        f705a = str;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m696a(String str) {
        Matcher matcher;
        try {
            matcher = Pattern.compile("i686|mips|x86_64|x86").matcher(str);
        } catch (Exception unused) {
            matcher = null;
        }
        return matcher == null || !matcher.find();
    }

    /* JADX INFO: renamed from: a */
    private static Certificate[] m697a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) throws Exception {
        InputStream inputStream = jarFile.getInputStream(jarEntry);
        while (inputStream.read(bArr, 0, bArr.length) != -1) {
        }
        inputStream.close();
        if (jarEntry != null) {
            return jarEntry.getCertificates();
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public static int m698b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: b */
    private static String m699b(String str) {
        return str == null ? BuildConfig.FLAVOR : str;
    }

    /* JADX INFO: renamed from: b */
    public static void m700b(Context context, String str) {
        try {
            TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_GUID, str);
            tbsDownloadConfig.commit();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    public static boolean m701b() {
        Matcher matcher;
        try {
            matcher = Pattern.compile("i686|mips|x86_64|x86").matcher(f707c);
        } catch (Exception unused) {
            matcher = null;
        }
        return matcher == null || !matcher.find();
    }

    /* JADX INFO: renamed from: c */
    public static String m702c(Context context) {
        try {
            return TbsDownloadConfig.getInstance(context).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_GUID, BuildConfig.FLAVOR);
        } catch (Exception unused) {
            return BuildConfig.FLAVOR;
        }
    }

    /* JADX INFO: renamed from: c */
    public static boolean m703c() {
        Class<?> cls;
        Method declaredMethod;
        Object objInvoke;
        Method declaredMethod2;
        try {
            if (Build.VERSION.SDK_INT < 21 || (cls = Class.forName("dalvik.system.VMRuntime")) == null || (declaredMethod = cls.getDeclaredMethod("getRuntime", new Class[0])) == null || (objInvoke = declaredMethod.invoke(null, new Object[0])) == null || (declaredMethod2 = cls.getDeclaredMethod("is64Bit", new Class[0])) == null) {
                return false;
            }
            Object objInvoke2 = declaredMethod2.invoke(objInvoke, new Object[0]);
            if (objInvoke2 instanceof Boolean) {
                return ((Boolean) objInvoke2).booleanValue();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    /* JADX INFO: renamed from: d */
    public static String m704d(Context context) {
        if (!f711g) {
            try {
                if (TextUtils.isEmpty(f705a)) {
                    f705a = C0454k.m767a(context);
                }
            } catch (Exception e) {
                TbsLog.m668i(e);
            }
            f711g = true;
        }
        return f705a;
    }

    /* JADX INFO: renamed from: e */
    public static String m705e(Context context) {
        return BuildConfig.FLAVOR;
    }

    /* JADX INFO: renamed from: f */
    public static String m706f(Context context) {
        return "02:00:00:00:00:00";
    }

    /* JADX INFO: renamed from: g */
    public static String m707g(Context context) {
        return BuildConfig.FLAVOR;
    }
}
