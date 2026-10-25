package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.flexbox.BuildConfig;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;
import java.io.FileFilter;

/* JADX INFO: renamed from: com.tencent.smtt.utils.n */
/* JADX INFO: loaded from: classes.dex */
public class C0457n {
    /* JADX INFO: renamed from: a */
    public static boolean m789a(Context context) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return m791b(context);
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m790a(File file) {
        try {
            return !C0448e.m724b(file);
        } catch (Throwable th) {
            Log.e("TbsCheckUtils", "isOatFileBroken exception: " + th);
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    public static boolean m791b(Context context) {
        File fileM792c;
        try {
            int i = Build.VERSION.SDK_INT;
            if (i < 21 || i > 25 || (fileM792c = m792c(context)) == null) {
                return true;
            }
            for (File file : fileM792c.listFiles(new FileFilter() { // from class: com.tencent.smtt.utils.n.1
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    String name = file2.getName();
                    return !TextUtils.isEmpty(name) && name.endsWith(".dex");
                }
            })) {
                if (file.isFile() && file.exists()) {
                    if (m790a(file)) {
                        TbsLog.m672w("TbsCheckUtils", BuildConfig.FLAVOR + file + " is invalid --> check failed!");
                        file.delete();
                        return false;
                    }
                    TbsLog.m665i("TbsCheckUtils", BuildConfig.FLAVOR + file + " #4 check success!");
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        TbsLog.m665i("TbsCheckUtils", "checkTbsValidity -->#5 check ok!");
        return true;
    }

    /* JADX INFO: renamed from: c */
    private static File m792c(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "core_share");
        if (file.isDirectory() && file.exists()) {
            return file;
        }
        return null;
    }
}
