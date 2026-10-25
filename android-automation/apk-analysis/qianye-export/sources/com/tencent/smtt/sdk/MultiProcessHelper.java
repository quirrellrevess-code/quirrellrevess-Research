package com.tencent.smtt.sdk;

import android.os.Bundle;
import com.google.android.flexbox.BuildConfig;

/* JADX INFO: loaded from: classes.dex */
public class MultiProcessHelper {
    /* JADX INFO: renamed from: a */
    private static Object m143a(String str, Bundle bundle) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a != null && c0431uM530a.m534b()) {
            try {
                return c0431uM530a.m535c().m558b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "invokeStaticMiscMethod", new Class[]{String.class, Bundle.class}, str, bundle);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static boolean getMultiProcessAutoRecoveryEnabled() {
        Object objM143a = m143a("getMultiProcessAutoRecoveryEnabled", null);
        if (objM143a instanceof Boolean) {
            return ((Boolean) objM143a).booleanValue();
        }
        return true;
    }

    public static String getMultiProcessChoseTypeReason() {
        Object objM143a = m143a("getMultiProcessChoseTypeReason", null);
        return objM143a instanceof String ? (String) objM143a : BuildConfig.FLAVOR;
    }

    public static boolean getMultiProcessNoSandBoxEnabled() {
        Object objM143a = m143a("getMultiProcessNoSandBoxIfNotIsolatedEnabled", null);
        if (objM143a instanceof Boolean) {
            return ((Boolean) objM143a).booleanValue();
        }
        return true;
    }

    public static int getMultiProcessType() {
        Object objM143a = m143a("getMultiProcessType", null);
        if (objM143a instanceof Integer) {
            return ((Integer) objM143a).intValue();
        }
        return -1;
    }
}
