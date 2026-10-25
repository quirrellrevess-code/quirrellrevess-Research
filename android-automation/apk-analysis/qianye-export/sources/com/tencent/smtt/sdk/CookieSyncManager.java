package com.tencent.smtt.sdk;

import android.content.Context;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class CookieSyncManager {

    /* JADX INFO: renamed from: a */
    private static android.webkit.CookieSyncManager f148a = null;

    /* JADX INFO: renamed from: b */
    private static CookieSyncManager f149b = null;

    /* JADX INFO: renamed from: c */
    private static boolean f150c = false;

    private CookieSyncManager(Context context) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            return;
        }
        c0431uM530a.m535c().m558b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_createInstance", new Class[]{Context.class}, context);
        f150c = true;
    }

    public static synchronized CookieSyncManager createInstance(Context context) {
        f148a = android.webkit.CookieSyncManager.createInstance(context);
        if (f149b == null || !f150c) {
            f149b = new CookieSyncManager(context.getApplicationContext());
        }
        return f149b;
    }

    public static synchronized CookieSyncManager getInstance() {
        CookieSyncManager cookieSyncManager;
        cookieSyncManager = f149b;
        if (cookieSyncManager == null) {
            throw new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
        }
        return cookieSyncManager;
    }

    public void startSync() {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a != null && c0431uM530a.m534b()) {
            c0431uM530a.m535c().m558b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_startSync", new Class[0], new Object[0]);
            return;
        }
        f148a.startSync();
        try {
            Field declaredField = Class.forName("android.webkit.WebSyncManager").getDeclaredField("mSyncThread");
            declaredField.setAccessible(true);
            ((Thread) declaredField.get(f148a)).setUncaughtExceptionHandler(new C0413g());
        } catch (Exception unused) {
        }
    }

    public void stopSync() {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            f148a.stopSync();
        } else {
            c0431uM530a.m535c().m558b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_stopSync", new Class[0], new Object[0]);
        }
    }

    public void sync() {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            f148a.sync();
        } else {
            c0431uM530a.m535c().m558b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_Sync", new Class[0], new Object[0]);
        }
    }
}
