package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.C0453j;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class CacheManager {
    @Deprecated
    public static boolean cacheDisabled() {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a != null && c0431uM530a.m534b()) {
            return ((Boolean) c0431uM530a.m535c().m564c()).booleanValue();
        }
        Object objM764a = C0453j.m764a("android.webkit.CacheManager", "cacheDisabled");
        if (objM764a == null) {
            return false;
        }
        return ((Boolean) objM764a).booleanValue();
    }

    public static InputStream getCacheFile(String str, boolean z) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            return null;
        }
        return c0431uM530a.m535c().m545a(str, z);
    }

    public static Object getCacheFile(String str, Map<String, String> map) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a != null && c0431uM530a.m534b()) {
            return c0431uM530a.m535c().m577g();
        }
        try {
            return C0453j.m761a(Class.forName("android.webkit.CacheManager"), "getCacheFile", (Class<?>[]) new Class[]{String.class, Map.class}, str, map);
        } catch (Exception unused) {
            return null;
        }
    }

    @Deprecated
    public static File getCacheFileBaseDir() {
        C0431u c0431uM530a = C0431u.m530a();
        return (File) ((c0431uM530a == null || !c0431uM530a.m534b()) ? C0453j.m764a("android.webkit.CacheManager", "getCacheFileBaseDir") : c0431uM530a.m535c().m577g());
    }
}
