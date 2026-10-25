package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.tencent.smtt.utils.C0453j;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class CookieManager {
    public static String LOGTAG = "CookieManager";

    /* JADX INFO: renamed from: c */
    private static CookieManager f135c;

    /* JADX INFO: renamed from: a */
    public CopyOnWriteArrayList<C0350b> f136a;

    /* JADX INFO: renamed from: b */
    public EnumC0349a f137b = EnumC0349a.MODE_NONE;

    /* JADX INFO: renamed from: d */
    private boolean f138d = false;

    /* JADX INFO: renamed from: com.tencent.smtt.sdk.CookieManager$a */
    public enum EnumC0349a {
        MODE_NONE,
        MODE_KEYS,
        MODE_ALL
    }

    /* JADX INFO: renamed from: com.tencent.smtt.sdk.CookieManager$b */
    public class C0350b {

        /* JADX INFO: renamed from: a */
        public int f143a;

        /* JADX INFO: renamed from: b */
        public String f144b;

        /* JADX INFO: renamed from: c */
        public String f145c;

        /* JADX INFO: renamed from: d */
        public ValueCallback<Boolean> f146d;

        public C0350b() {
        }
    }

    private CookieManager() {
    }

    public static boolean checkSysCoreNotExist() {
        SystemCoreProtector systemCoreProtectorM162e = QbSdk.m162e();
        if (systemCoreProtectorM162e == null) {
            return false;
        }
        try {
            android.webkit.CookieManager.getInstance();
            return false;
        } catch (Exception e) {
            systemCoreProtectorM162e.onCookieManagerException(e);
            return true;
        }
    }

    public static CookieManager getInstance() {
        if (f135c == null) {
            synchronized (CookieManager.class) {
                if (f135c == null) {
                    f135c = new CookieManager();
                }
            }
        }
        return f135c;
    }

    public static int getROMCookieDBVersion(Context context) {
        return context.getSharedPreferences("cookiedb_info", Build.VERSION.SDK_INT >= 11 ? 4 : 0).getInt("db_version", -1);
    }

    public static void setROMCookieDBVersion(Context context, int i) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("cookiedb_info", Build.VERSION.SDK_INT >= 11 ? 4 : 0).edit();
        editorEdit.putInt("db_version", i);
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m129a() {
        CopyOnWriteArrayList<C0350b> copyOnWriteArrayList = this.f136a;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() != 0) {
            C0431u c0431uM530a = C0431u.m530a();
            if (c0431uM530a == null || !c0431uM530a.m534b()) {
                for (C0350b c0350b : this.f136a) {
                    int i = c0350b.f143a;
                    if (i != 1) {
                        if (i == 2) {
                            if (checkSysCoreNotExist()) {
                                return;
                            } else {
                                android.webkit.CookieManager.getInstance().setCookie(c0350b.f144b, c0350b.f145c);
                            }
                        }
                    } else if (Build.VERSION.SDK_INT < 21) {
                        continue;
                    } else if (checkSysCoreNotExist()) {
                        return;
                    } else {
                        C0453j.m763a(android.webkit.CookieManager.getInstance(), "setCookie", (Class<?>[]) new Class[]{String.class, String.class, android.webkit.ValueCallback.class}, c0350b.f144b, c0350b.f145c, c0350b.f146d);
                    }
                }
            } else {
                for (C0350b c0350b2 : this.f136a) {
                    int i2 = c0350b2.f143a;
                    if (i2 == 1) {
                        setCookie(c0350b2.f144b, c0350b2.f145c, c0350b2.f146d);
                    } else if (i2 == 2) {
                        setCookie(c0350b2.f144b, c0350b2.f145c);
                    }
                }
            }
            this.f136a.clear();
        }
    }

    public boolean acceptCookie() {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a != null && c0431uM530a.m534b()) {
            return c0431uM530a.m535c().m569d();
        }
        if (checkSysCoreNotExist()) {
            return false;
        }
        return android.webkit.CookieManager.getInstance().acceptCookie();
    }

    public synchronized boolean acceptThirdPartyCookies(WebView webView) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a != null && c0431uM530a.m534b()) {
            Object objInvokeStaticMethod = c0431uM530a.m535c().m558b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptThirdPartyCookies", new Class[]{Object.class}, webView.getView());
            if (objInvokeStaticMethod == null) {
                return true;
            }
            return ((Boolean) objInvokeStaticMethod).booleanValue();
        }
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        if (checkSysCoreNotExist()) {
            return false;
        }
        Object objM763a = C0453j.m763a(android.webkit.CookieManager.getInstance(), "acceptThirdPartyCookies", (Class<?>[]) new Class[]{android.webkit.WebView.class}, webView.getView());
        if (objM763a == null) {
            return false;
        }
        return ((Boolean) objM763a).booleanValue();
    }

    public void flush() {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a != null && c0431uM530a.m534b()) {
            c0431uM530a.m535c().m558b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
        } else if (Build.VERSION.SDK_INT >= 21 && !checkSysCoreNotExist()) {
            C0453j.m763a(android.webkit.CookieManager.getInstance(), "flush", (Class<?>[]) new Class[0], new Object[0]);
        }
    }

    public String getCookie(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a != null && c0431uM530a.m534b()) {
            return c0431uM530a.m535c().m546a(str);
        }
        if (checkSysCoreNotExist()) {
            return null;
        }
        try {
            return android.webkit.CookieManager.getInstance().getCookie(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public boolean hasCookies() {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a != null && c0431uM530a.m534b()) {
            return c0431uM530a.m535c().m582h();
        }
        if (checkSysCoreNotExist()) {
            return false;
        }
        return android.webkit.CookieManager.getInstance().hasCookies();
    }

    @Deprecated
    public void removeAllCookie() {
        CopyOnWriteArrayList<C0350b> copyOnWriteArrayList = this.f136a;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a != null && c0431uM530a.m534b()) {
            c0431uM530a.m535c().m571e();
        } else {
            if (checkSysCoreNotExist()) {
                return;
            }
            android.webkit.CookieManager.getInstance().removeAllCookie();
        }
    }

    public void removeAllCookies(ValueCallback<Boolean> valueCallback) {
        CopyOnWriteArrayList<C0350b> copyOnWriteArrayList = this.f136a;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a != null && c0431uM530a.m534b()) {
            c0431uM530a.m535c().m558b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        } else if (Build.VERSION.SDK_INT >= 21 && !checkSysCoreNotExist()) {
            C0453j.m763a(android.webkit.CookieManager.getInstance(), "removeAllCookies", (Class<?>[]) new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        }
    }

    @Deprecated
    public void removeExpiredCookie() {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a != null && c0431uM530a.m534b()) {
            c0431uM530a.m535c().m558b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
        } else {
            if (checkSysCoreNotExist()) {
                return;
            }
            android.webkit.CookieManager.getInstance().removeExpiredCookie();
        }
    }

    @Deprecated
    public void removeSessionCookie() {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a != null && c0431uM530a.m534b()) {
            c0431uM530a.m535c().m558b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
        } else {
            if (checkSysCoreNotExist()) {
                return;
            }
            android.webkit.CookieManager.getInstance().removeSessionCookie();
        }
    }

    public void removeSessionCookies(ValueCallback<Boolean> valueCallback) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a != null && c0431uM530a.m534b()) {
            c0431uM530a.m535c().m558b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        } else if (Build.VERSION.SDK_INT >= 21 && !checkSysCoreNotExist()) {
            C0453j.m763a(android.webkit.CookieManager.getInstance(), "removeSessionCookies", (Class<?>[]) new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        }
    }

    public synchronized void setAcceptCookie(boolean z) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            try {
                if (checkSysCoreNotExist()) {
                } else {
                    android.webkit.CookieManager.getInstance().setAcceptCookie(z);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            c0431uM530a.m535c().m558b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptCookie", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public synchronized void setAcceptThirdPartyCookies(WebView webView, boolean z) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a != null && c0431uM530a.m534b()) {
            c0431uM530a.m535c().m558b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptThirdPartyCookies", new Class[]{Object.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
        } else {
            if (Build.VERSION.SDK_INT < 21) {
                return;
            }
            if (checkSysCoreNotExist()) {
            } else {
                C0453j.m763a(android.webkit.CookieManager.getInstance(), "setAcceptThirdPartyCookies", (Class<?>[]) new Class[]{android.webkit.WebView.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
            }
        }
    }

    public synchronized void setCookie(String str, String str2) {
        setCookie(str, str2, false);
    }

    public synchronized void setCookie(String str, String str2, ValueCallback<Boolean> valueCallback) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            if (!c0431uM530a.m536d()) {
                C0350b c0350b = new C0350b();
                c0350b.f143a = 1;
                c0350b.f144b = str;
                c0350b.f145c = str2;
                c0350b.f146d = valueCallback;
                if (this.f136a == null) {
                    this.f136a = new CopyOnWriteArrayList<>();
                }
                this.f136a.add(c0350b);
            }
            if (Build.VERSION.SDK_INT < 21) {
                return;
            }
            if (checkSysCoreNotExist()) {
            } else {
                C0453j.m763a(android.webkit.CookieManager.getInstance(), "setCookie", (Class<?>[]) new Class[]{String.class, String.class, android.webkit.ValueCallback.class}, str, str2, valueCallback);
            }
        } else {
            c0431uM530a.m535c().m558b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class, android.webkit.ValueCallback.class}, str, str2, valueCallback);
        }
    }

    public synchronized void setCookie(String str, String str2, boolean z) {
        android.webkit.CookieManager cookieManager;
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a != null && c0431uM530a.m534b()) {
            c0431uM530a.m535c().m558b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class}, str, str2);
            if (WebView.hasCreatedSysWebViewInstance()) {
                if (checkSysCoreNotExist()) {
                    return;
                } else {
                    cookieManager = android.webkit.CookieManager.getInstance();
                }
            }
        }
        if (!C0431u.m530a().m536d()) {
            C0350b c0350b = new C0350b();
            c0350b.f143a = 2;
            c0350b.f144b = str;
            c0350b.f145c = str2;
            c0350b.f146d = null;
            if (this.f136a == null) {
                this.f136a = new CopyOnWriteArrayList<>();
            }
            this.f136a.add(c0350b);
        }
        if (checkSysCoreNotExist()) {
            return;
        } else {
            cookieManager = android.webkit.CookieManager.getInstance();
        }
        cookieManager.setCookie(str, str2);
    }

    public void setCookies(Map<String, String[]> map) {
        C0431u c0431uM530a = C0431u.m530a();
        if ((c0431uM530a == null || !c0431uM530a.m534b()) ? false : c0431uM530a.m535c().m555a(map)) {
            return;
        }
        for (String str : map.keySet()) {
            for (String str2 : map.get(str)) {
                setCookie(str, str2);
            }
        }
    }
}
