package com.tencent.smtt.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class PropertyUtils {

    /* JADX INFO: renamed from: a */
    private static Class f689a;

    /* JADX INFO: renamed from: b */
    private static Method f690b;

    static {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            f689a = cls;
            f690b = cls.getDeclaredMethod("get", String.class, String.class);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m657a(String str, String str2) {
        Method method;
        Class cls = f689a;
        if (cls == null || (method = f690b) == null) {
            return str2;
        }
        try {
            return (String) method.invoke(cls, str, str2);
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }

    public static String getQuickly(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : m657a(str, str2);
    }
}
