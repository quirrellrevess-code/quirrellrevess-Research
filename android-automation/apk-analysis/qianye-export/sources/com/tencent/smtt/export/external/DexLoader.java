package com.tencent.smtt.export.external;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.flexbox.BuildConfig;
import com.tencent.smtt.utils.RunnableC0456m;
import dalvik.system.DexClassLoader;
import dalvik.system.VMStack;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class DexLoader {
    private static final String TAG = "DexLoader";
    private static final String TBS_FUSION_DEX = "tbs_jars_fusion_dex";
    private static final String TBS_WEBVIEW_DEX = "webview_dex";
    private static final String TENCENT_PACKAGE_PREFIX = "com.tencent";
    public static boolean mCanUseDexLoaderProviderService = true;
    private static boolean mUseSpeedyClassLoader = false;
    private static boolean mUseTbsCorePrivateClassLoader = false;
    private DexClassLoader mClassLoader;
    private static final String CHROMIUM_PREFIX = "org.chromium";
    private static final String ANDROIDX_PREFIX = "androidx";
    private static final String TAF_PREFIX = "com.taf";
    private static final String CHROMIUM_J_N = "J.N";
    private static String[] mPrivatePrefix = {CHROMIUM_PREFIX, ANDROIDX_PREFIX, TAF_PREFIX, CHROMIUM_J_N};

    public static class TbsCorePrivateClassLoader extends DexClassLoader {
        public TbsCorePrivateClassLoader(String str, String str2, String str3, ClassLoader classLoader) {
            super(str, str2, str3, classLoader);
        }

        @Override // java.lang.ClassLoader
        public Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
            ClassLoader parent;
            if (str == null) {
                return super.loadClass(str, z);
            }
            boolean z2 = false;
            for (String str2 : DexLoader.mPrivatePrefix) {
                if (str.startsWith(str2)) {
                    z2 = true;
                    break;
                }
            }
            if (!z2) {
                return super.loadClass(str, z);
            }
            Class<?> clsFindLoadedClass = findLoadedClass(str);
            if (clsFindLoadedClass != null) {
                return clsFindLoadedClass;
            }
            try {
                clsFindLoadedClass = findClass(str);
            } catch (ClassNotFoundException unused) {
            }
            return (clsFindLoadedClass != null || (parent = getParent()) == null) ? clsFindLoadedClass : parent.loadClass(str);
        }
    }

    public DexLoader(Context context, String str, String str2) {
        this(context, new String[]{str}, str2);
    }

    public DexLoader(Context context, String[] strArr, String str) {
        this((String) null, context, strArr, str);
    }

    public DexLoader(Context context, String[] strArr, String str, DexLoader dexLoader) throws Throwable {
        DexClassLoader classLoader = dexLoader.getClassLoader();
        for (String str2 : strArr) {
            classLoader = createDexClassLoader(str2, str, context.getApplicationInfo().nativeLibraryDir, classLoader, context);
            this.mClassLoader = classLoader;
        }
    }

    public DexLoader(Context context, String[] strArr, String str, String str2) throws Throwable {
        ClassLoader classLoader = context.getClassLoader();
        String str3 = context.getApplicationInfo().nativeLibraryDir;
        if (!TextUtils.isEmpty(str2)) {
            str3 = str3 + File.pathSeparator + str2;
        }
        int i = 0;
        ClassLoader classLoader2 = classLoader;
        while (i < strArr.length) {
            DexClassLoader dexClassLoaderCreateDexClassLoader = createDexClassLoader(strArr[i], str, str3, classLoader2, context);
            this.mClassLoader = dexClassLoaderCreateDexClassLoader;
            i++;
            classLoader2 = dexClassLoaderCreateDexClassLoader;
        }
    }

    public DexLoader(String str, Context context, String[] strArr, String str2) {
        this(str, context, strArr, str2, null);
    }

    public DexLoader(String str, Context context, String[] strArr, String str2, Map<String, Object> map) throws Throwable {
        initTbsSettings(map);
        ClassLoader callingClassLoader = VMStack.getCallingClassLoader();
        callingClassLoader = callingClassLoader == null ? context.getClassLoader() : callingClassLoader;
        Log.d("dexloader", "Set base classLoader for DexClassLoader: " + callingClassLoader);
        int i = 0;
        ClassLoader classLoader = callingClassLoader;
        while (i < strArr.length) {
            DexClassLoader dexClassLoaderCreateDexClassLoader = createDexClassLoader(strArr[i], str2, str, classLoader, context);
            this.mClassLoader = dexClassLoaderCreateDexClassLoader;
            i++;
            classLoader = dexClassLoaderCreateDexClassLoader;
        }
    }

    private void closeStream(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:41:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:43:0x0201  */
    /* JADX WARN: Code duplicated, block: B:44:0x020a  */
    /* JADX WARN: Code duplicated, block: B:46:0x0219  */
    /* JADX WARN: Code duplicated, block: B:57:0x025a  */
    private DexClassLoader createDexClassLoader(String str, String str2, String str3, ClassLoader classLoader, Context context) throws Throwable {
        int i;
        DexClassLoader dexClassLoader;
        DexClassLoader dexClassLoaderCreateDexClassLoader;
        ApplicationInfo applicationInfo;
        String privateDexFilePath;
        RunnableC0456m runnableC0456m;
        if (Build.VERSION.SDK_INT >= 29) {
            String str4 = str + "_code";
            String str5 = str + "_name";
            String str6 = str + "_display";
            SharedPreferences sharedPreferences = context.getSharedPreferences("tbs_oat_status", 0);
            File file = new File(str);
            File file2 = new File(context.getDir("tbs", 0), "core_private");
            try {
                int i2 = sharedPreferences.getInt(str4, -1);
                String string = sharedPreferences.getString(str5, BuildConfig.FLAVOR);
                String string2 = sharedPreferences.getString(str6, BuildConfig.FLAVOR);
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                int i3 = packageInfo.versionCode;
                String str7 = packageInfo.versionName;
                String str8 = Build.DISPLAY;
                Log.i(TAG, "createDexClassLoader,old VerisonCode=" + string + ";newVersionCode=" + i3 + "oldVersionName" + string + ";newVersionName+" + str7 + "oldDisplay" + string2 + ";newDisplay=" + str8);
                if (i3 == i2 && str7.equals(string) && str8.equals(string2)) {
                    runnableC0456m = null;
                } else {
                    Log.e(TAG, "version updated!,clear oat file");
                    RunnableC0456m runnableC0456m2 = new RunnableC0456m(file2, file.getName() + "_loading.lock");
                    try {
                        runnableC0456m2.m785b();
                        int i4 = sharedPreferences.getInt(str4, -1);
                        String string3 = sharedPreferences.getString(str5, BuildConfig.FLAVOR);
                        String string4 = sharedPreferences.getString(str6, BuildConfig.FLAVOR);
                        if (i3 != i4 || !str7.equals(string3) || !str8.equals(string4)) {
                            File file3 = new File(file.getParent(), "oat");
                            String fileNameNoEx = getFileNameNoEx(file.getName());
                            File file4 = new File(file3, file.getName() + ".prof");
                            File file5 = new File(file3, file.getName() + ".cur.prof");
                            File file6 = new File(file3, "arm");
                            File file7 = new File(file6, fileNameNoEx + ".odex");
                            File file8 = new File(file6, fileNameNoEx + ".vdex");
                            delete(file4);
                            delete(file5);
                            delete(file7);
                            delete(file8);
                            Log.i(TAG, "delete file:" + file4 + file5 + file7 + file8);
                            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                            editorEdit.putString(str5, str7);
                            editorEdit.putInt(str4, i3);
                            editorEdit.putString(str6, str8);
                            editorEdit.apply();
                        }
                        runnableC0456m = runnableC0456m2;
                    } catch (Exception e) {
                        e = e;
                        runnableC0456m = runnableC0456m2;
                        try {
                            e.printStackTrace();
                            if (runnableC0456m != null) {
                            }
                            Log.d("dexloader", "createDexClassLoader: " + str);
                            if (shouldUseTbsCorePrivateClassLoader(str)) {
                                applicationInfo = context.getApplicationInfo();
                                if (applicationInfo != null) {
                                    privateDexFilePath = getPrivateDexFilePath(str, applicationInfo.targetSdkVersion);
                                } else {
                                    privateDexFilePath = str;
                                }
                                dexClassLoaderCreateDexClassLoader = new TbsCorePrivateClassLoader(privateDexFilePath, str2, str3, classLoader);
                            } else {
                                i = Build.VERSION.SDK_INT;
                                if (i >= 21) {
                                    Log.d("dexloader", "sync odex...new DexClassLoader");
                                    dexClassLoader = new DexClassLoader(str, str2, str3, classLoader);
                                    dexClassLoaderCreateDexClassLoader = dexClassLoader;
                                } else {
                                    Log.d("dexloader", "sync odex...new DexClassLoader");
                                    dexClassLoader = new DexClassLoader(str, str2, str3, classLoader);
                                    dexClassLoaderCreateDexClassLoader = dexClassLoader;
                                }
                            }
                            Log.d("dexloader", "createDexClassLoader result: " + dexClassLoaderCreateDexClassLoader);
                            return dexClassLoaderCreateDexClassLoader;
                        } catch (Throwable th) {
                            th = th;
                            if (runnableC0456m != null) {
                                runnableC0456m.m788e();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        runnableC0456m = runnableC0456m2;
                        if (runnableC0456m != null) {
                            runnableC0456m.m788e();
                        }
                        throw th;
                    }
                }
                if (runnableC0456m != null) {
                    runnableC0456m.m788e();
                }
            } catch (Exception e2) {
                e = e2;
                runnableC0456m = null;
            } catch (Throwable th3) {
                th = th3;
                runnableC0456m = null;
            }
        }
        Log.d("dexloader", "createDexClassLoader: " + str);
        if (shouldUseTbsCorePrivateClassLoader(str)) {
            applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null) {
                privateDexFilePath = getPrivateDexFilePath(str, applicationInfo.targetSdkVersion);
            } else {
                privateDexFilePath = str;
            }
            dexClassLoaderCreateDexClassLoader = new TbsCorePrivateClassLoader(privateDexFilePath, str2, str3, classLoader);
        } else {
            i = Build.VERSION.SDK_INT;
            if (i >= 21 || i > 25 || !mUseSpeedyClassLoader) {
                Log.d("dexloader", "sync odex...new DexClassLoader");
                dexClassLoader = new DexClassLoader(str, str2, str3, classLoader);
            } else {
                Log.d("dexloader", "async odex...DexClassLoaderProvider.createDexClassLoader");
                try {
                    dexClassLoaderCreateDexClassLoader = DexClassLoaderProvider.createDexClassLoader(str, str2, str3, classLoader, context);
                } catch (Throwable th4) {
                    Log.e("dexloader", "createDexClassLoader exception: " + th4);
                    Log.d("dexloader", "sync odex...new DexClassLoader#2");
                    dexClassLoader = new DexClassLoader(str, str2, str3, classLoader);
                    dexClassLoaderCreateDexClassLoader = dexClassLoader;
                }
            }
            dexClassLoaderCreateDexClassLoader = dexClassLoader;
        }
        Log.d("dexloader", "createDexClassLoader result: " + dexClassLoaderCreateDexClassLoader);
        return dexClassLoaderCreateDexClassLoader;
    }

    public static void delete(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            delete(file2);
        }
        file.delete();
    }

    public static String getFileNameNoEx(String str) {
        int iLastIndexOf;
        return (str == null || str.length() <= 0 || (iLastIndexOf = str.lastIndexOf(46)) <= -1 || iLastIndexOf >= str.length()) ? str : str.substring(0, iLastIndexOf);
    }

    private String getPrivateDexFilePath(String str, int i) {
        BufferedReader bufferedReader;
        if (Build.VERSION.SDK_INT < 29 || i < 29 || str == null) {
            return str;
        }
        File file = new File(str);
        File file2 = new File(file.getParent(), file.getName().replace(".", BuildConfig.FLAVOR));
        if (!file2.exists()) {
            Closeable closeable = null;
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec("ln -s " + str + " " + file2.getAbsolutePath()).getInputStream());
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    do {
                        try {
                        } catch (Throwable th) {
                            th = th;
                            closeable = inputStreamReader;
                            try {
                                Log.w("[TBS]", "create PrivateDex failed : " + th);
                                return str;
                            } finally {
                                closeStream(bufferedReader);
                                closeStream(closeable);
                            }
                        }
                    } while (bufferedReader.readLine() != null);
                    closeStream(bufferedReader);
                    closeStream(inputStreamReader);
                    if (!file2.exists()) {
                        Log.w("[TBS]", "PrivateDex not exist, after ln -s " + str);
                        return str;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        }
        return file2.getAbsolutePath();
    }

    public static void initTbsSettings(Map<String, Object> map) {
        Log.d(TAG, "initTbsSettings - " + map);
        if (map != null) {
            try {
                Object obj = map.get(TbsCoreSettings.TBS_SETTINGS_USE_PRIVATE_CLASSLOADER);
                if (obj instanceof Boolean) {
                    mUseTbsCorePrivateClassLoader = ((Boolean) obj).booleanValue();
                }
                Object obj2 = map.get(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER);
                if (obj2 instanceof Boolean) {
                    mUseSpeedyClassLoader = ((Boolean) obj2).booleanValue();
                }
                Object obj3 = map.get(TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE);
                if (obj3 instanceof Boolean) {
                    mCanUseDexLoaderProviderService = ((Boolean) obj3).booleanValue();
                }
                Object obj4 = map.get(TbsCoreSettings.TBS_SETTINGS_PRIVATE_CLASS_LIST);
                if (obj4 instanceof String) {
                    mPrivatePrefix = ((String) obj4).split(";");
                    Log.i(TAG, "PrivateClassPrefix: " + ((String) obj4));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private boolean shouldUseTbsCorePrivateClassLoader(String str) {
        if (mUseTbsCorePrivateClassLoader) {
            return str.contains(TBS_FUSION_DEX) || str.contains(TBS_WEBVIEW_DEX);
        }
        return false;
    }

    public DexClassLoader getClassLoader() {
        return this.mClassLoader;
    }

    public Object getStaticField(String str, String str2) {
        try {
            Field field = this.mClassLoader.loadClass(str).getField(str2);
            field.setAccessible(true);
            return field.get(null);
        } catch (Throwable th) {
            Log.e(getClass().getSimpleName(), "'" + str + "' get field '" + str2 + "' failed", th);
            return null;
        }
    }

    public Object invokeMethod(Object obj, String str, String str2, Class<?>[] clsArr, Object... objArr) {
        try {
            Method method = this.mClassLoader.loadClass(str).getMethod(str2, clsArr);
            method.setAccessible(true);
            return method.invoke(obj, objArr);
        } catch (Throwable th) {
            Log.e(getClass().getSimpleName(), "'" + str + "' invoke method '" + str2 + "' failed", th);
            return null;
        }
    }

    public Object invokeStaticMethod(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        try {
            Method method = this.mClassLoader.loadClass(str).getMethod(str2, clsArr);
            method.setAccessible(true);
            return method.invoke(null, objArr);
        } catch (Throwable th) {
            if (str2 == null || !str2.equalsIgnoreCase("initTesRuntimeEnvironment")) {
                Log.i(getClass().getSimpleName(), "'" + str + "' invoke static method '" + str2 + "' failed", th);
                return null;
            }
            Log.e(getClass().getSimpleName(), "'" + str + "' invoke static method '" + str2 + "' failed", th);
            return th;
        }
    }

    public Class<?> loadClass(String str) {
        try {
            return this.mClassLoader.loadClass(str);
        } catch (Throwable th) {
            Log.e(getClass().getSimpleName(), "loadClass '" + str + "' failed", th);
            return null;
        }
    }

    public Object newInstance(String str) {
        try {
            return this.mClassLoader.loadClass(str).newInstance();
        } catch (Throwable th) {
            Log.e(getClass().getSimpleName(), "create " + str + " instance failed", th);
            return null;
        }
    }

    public Object newInstance(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            return this.mClassLoader.loadClass(str).getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable th) {
            if ("com.tencent.smtt.webkit.adapter.X5WebViewAdapter".equalsIgnoreCase(str)) {
                Log.e(getClass().getSimpleName(), "'newInstance " + str + " failed", th);
                return th;
            }
            Log.e(getClass().getSimpleName(), "create '" + str + "' instance failed", th);
            return null;
        }
    }

    public void setStaticField(String str, String str2, Object obj) {
        try {
            Field field = this.mClassLoader.loadClass(str).getField(str2);
            field.setAccessible(true);
            field.set(null, obj);
        } catch (Throwable th) {
            Log.e(getClass().getSimpleName(), "'" + str + "' set field '" + str2 + "' failed", th);
        }
    }
}
