package com.tencent.smtt.utils;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: com.tencent.smtt.utils.j */
/* JADX INFO: loaded from: classes.dex */
public class C0453j {
    /* JADX INFO: renamed from: a */
    public static Object m761a(Class<?> cls, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            method.setAccessible(true);
            return method.invoke(null, objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static Object m762a(Object obj, String str) {
        return m763a(obj, str, (Class<?>[]) null, new Object[0]);
    }

    /* JADX INFO: renamed from: a */
    public static Object m763a(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        if (obj == null) {
            return null;
        }
        try {
            Class<?> cls = obj.getClass();
            Method method = Build.VERSION.SDK_INT > 10 ? cls.getMethod(str, clsArr) : cls.getDeclaredMethod(str, clsArr);
            method.setAccessible(true);
            if (objArr.length == 0) {
                objArr = null;
            }
            return method.invoke(obj, objArr);
        } catch (Throwable th) {
            if (th.getCause() != null && th.getCause().toString().contains("AuthenticationFail")) {
                return new String("AuthenticationFail");
            }
            if (str != null && (str.equalsIgnoreCase("canLoadX5Core") || str.equalsIgnoreCase("initTesRuntimeEnvironment"))) {
                return null;
            }
            TbsLog.m665i("ReflectionUtils", "invokeInstance -- exceptions:" + Log.getStackTraceString(th));
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static Object m764a(String str, String str2) {
        try {
            return Class.forName(str).getMethod(str2, new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static Method m765a(Object obj, String str, Class<?>... clsArr) {
        for (Class<?> superclass = obj.getClass(); superclass != Object.class && superclass != null; superclass = superclass.getSuperclass()) {
            try {
                return superclass.getDeclaredMethod(str, clsArr);
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
