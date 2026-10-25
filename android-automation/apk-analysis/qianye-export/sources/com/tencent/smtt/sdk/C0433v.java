package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.flexbox.BuildConfig;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5CoreServiceWorkerController;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.IconListener;
import com.tencent.smtt.utils.TbsLog;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: com.tencent.smtt.sdk.v */
/* JADX INFO: loaded from: classes.dex */
public class C0433v {

    /* JADX INFO: renamed from: a */
    private DexLoader f661a;

    /* JADX INFO: renamed from: b */
    private String f662b = BuildConfig.FLAVOR;

    public C0433v(DexLoader dexLoader) {
        this.f661a = dexLoader;
    }

    /* JADX INFO: renamed from: a */
    public int m543a(Context context, String str, Map<String, String> map, String str2, android.webkit.ValueCallback<String> valueCallback) {
        if (TbsDownloader.getOverSea(context)) {
            return -103;
        }
        DexLoader dexLoader = this.f661a;
        if (str2 != null) {
            Object objInvokeStaticMethod = dexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, String.class}, context, str, str2);
            if (objInvokeStaticMethod == null) {
                return -104;
            }
            return ((Integer) objInvokeStaticMethod).intValue();
        }
        Object objInvokeStaticMethod2 = dexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, Map.class, android.webkit.ValueCallback.class}, context, str, map, valueCallback);
        if (objInvokeStaticMethod2 == null) {
            objInvokeStaticMethod2 = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, Map.class}, context, str, map);
        }
        if (objInvokeStaticMethod2 == null) {
            objInvokeStaticMethod2 = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class}, context, str);
        }
        if (objInvokeStaticMethod2 == null) {
            return -104;
        }
        return ((Integer) objInvokeStaticMethod2).intValue();
    }

    /* JADX INFO: renamed from: a */
    public IX5WebViewBase m544a(Context context) {
        IX5WebViewBase iX5WebViewBase;
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createSDKWebview", new Class[]{Context.class}, context);
        try {
            if (objInvokeStaticMethod == null) {
                Object objInvokeStaticMethod2 = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
                if (objInvokeStaticMethod2 != null && (objInvokeStaticMethod2 instanceof Throwable)) {
                    TbsCoreLoadStat.getInstance().m176a(context, TbsListener.ErrorCode.THROWABLE_INITX5CORE, (Throwable) objInvokeStaticMethod2);
                }
                if (objInvokeStaticMethod2 != null && (objInvokeStaticMethod2 instanceof String)) {
                    TbsCoreLoadStat.getInstance().m176a(context, TbsListener.ErrorCode.THROWABLE_INITX5CORE, new Throwable((String) objInvokeStaticMethod2));
                }
                objInvokeStaticMethod = null;
                iX5WebViewBase = null;
            } else {
                iX5WebViewBase = (IX5WebViewBase) objInvokeStaticMethod;
                if (iX5WebViewBase != null) {
                    try {
                        if (iX5WebViewBase.getView() == null) {
                            TbsCoreLoadStat.getInstance().m176a(context, TbsListener.ErrorCode.THROWABLE_INITX5CORE, new Throwable("x5webview.getView is null!"));
                            objInvokeStaticMethod = null;
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e2) {
            e = e2;
            iX5WebViewBase = null;
        }
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return iX5WebViewBase;
    }

    /* JADX INFO: renamed from: a */
    public InputStream m545a(String str, boolean z) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCacheFile", new Class[]{String.class, Boolean.TYPE}, str, Boolean.valueOf(z));
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (InputStream) objInvokeStaticMethod;
    }

    /* JADX INFO: renamed from: a */
    public String m546a(String str) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCookie", new Class[]{String.class}, str);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (String) objInvokeStaticMethod;
    }

    /* JADX INFO: renamed from: a */
    public String m547a(String str, String str2, String str3) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilComposeSearchUrl", new Class[]{String.class, String.class, String.class}, str, str2, str3);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (String) objInvokeStaticMethod;
    }

    /* JADX INFO: renamed from: a */
    public void m548a(Context context, boolean z) {
        TbsLog.m672w("desktop", " tbsWizard clearAllX5Cache");
        if (z) {
            this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[]{Context.class}, context);
            return;
        }
        try {
            this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[]{Context.class, Boolean.TYPE}, context, Boolean.valueOf(z));
        } catch (Exception unused) {
            this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[]{Context.class}, context);
            this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[]{Context.class}, context);
            this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[]{Context.class}, context);
            this.f661a.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "removeAllCacheFiles", null, new Object[0]);
            this.f661a.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "clearLocalStorage", null, new Object[0]);
            Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.smtt.net.http.DnsManager", "getInstance", null, new Object[0]);
            if (objInvokeStaticMethod != null) {
                this.f661a.invokeMethod(objInvokeStaticMethod, "com.tencent.smtt.net.http.DnsManager", "removeAllDns", null, new Object[0]);
            }
            Object objInvokeStaticMethod2 = this.f661a.invokeStaticMethod("com.tencent.smtt.webkit.SmttPermanentPermissions", "getInstance", null, new Object[0]);
            if (objInvokeStaticMethod2 != null) {
                this.f661a.invokeMethod(objInvokeStaticMethod2, "com.tencent.smtt.webkit.SmttPermanentPermissions", "clearAllPermanentPermission", null, new Object[0]);
            }
            this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m549a(android.webkit.ValueCallback<Map> valueCallback) {
        this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetOrigins", new Class[]{android.webkit.ValueCallback.class}, valueCallback);
    }

    /* JADX INFO: renamed from: a */
    public void m550a(String str, long j) {
        this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageSetQuotaForOrigin", new Class[]{String.class, Long.TYPE}, str, Long.valueOf(j));
    }

    /* JADX INFO: renamed from: a */
    public void m551a(String str, android.webkit.ValueCallback<Long> valueCallback) {
        this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetUsageForOrigin", new Class[]{String.class, android.webkit.ValueCallback.class}, str, valueCallback);
    }

    /* JADX INFO: renamed from: a */
    public void m552a(String str, IconListener iconListener) {
        this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "requestIconForPageUrl", new Class[]{String.class, IconListener.class}, str, iconListener);
    }

    /* JADX INFO: renamed from: a */
    public void m553a(boolean z) {
        this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webview_setWebContentsDebuggingEnabled", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: a */
    public boolean m554a() throws Throwable {
        try {
            Method method = this.f661a.getClassLoader().loadClass("com.tencent.tbs.tbsshell.WebCoreProxy").getMethod("canUseX5", new Class[0]);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, new Object[0]);
            if (objInvoke instanceof Boolean) {
                this.f662b = "normal_" + ((Boolean) objInvoke);
                return ((Boolean) objInvoke).booleanValue();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("end_");
            Boolean bool = (Boolean) objInvoke;
            sb.append(bool);
            sb.append("_");
            sb.append("notBoolean");
            this.f662b = sb.toString();
            return bool.booleanValue();
        } catch (Throwable th) {
            this.f662b = "Throwable";
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m555a(Map<String, String[]> map) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookies", new Class[]{Map.class}, map);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) objInvokeStaticMethod).booleanValue();
    }

    /* JADX INFO: renamed from: a */
    public byte[] m556a(byte[] bArr) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilDecode", new Class[]{String.class}, bArr);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (byte[]) objInvokeStaticMethod;
    }

    /* JADX INFO: renamed from: a */
    public Uri[] m557a(int i, Intent intent) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "parseFileChooserResult", new Class[]{Integer.TYPE, Intent.class}, Integer.valueOf(i), intent);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (Uri[]) objInvokeStaticMethod;
    }

    /* JADX INFO: renamed from: b */
    public DexLoader m558b() {
        return this.f661a;
    }

    /* JADX INFO: renamed from: b */
    public String m559b(String str, String str2, String str3) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessFileName", new Class[]{String.class, String.class, String.class}, str, str2, str3);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (String) objInvokeStaticMethod;
    }

    /* JADX INFO: renamed from: b */
    public void m560b(android.webkit.ValueCallback<Set<String>> valueCallback) {
        this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetOrigins", new Class[]{android.webkit.ValueCallback.class}, valueCallback);
    }

    /* JADX INFO: renamed from: b */
    public void m561b(String str) {
        this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "openIconDB", new Class[]{String.class}, str);
    }

    /* JADX INFO: renamed from: b */
    public void m562b(String str, android.webkit.ValueCallback<Long> valueCallback) {
        this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetQuotaForOrigin", new Class[]{String.class, android.webkit.ValueCallback.class}, str, valueCallback);
    }

    /* JADX INFO: renamed from: b */
    public boolean m563b(Context context) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasUsernamePassword", new Class[]{Context.class}, context);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) objInvokeStaticMethod).booleanValue();
    }

    /* JADX INFO: renamed from: c */
    public Object m564c() {
        return this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cacheDisabled", new Class[0], new Object[0]);
    }

    /* JADX INFO: renamed from: c */
    public void m565c(Context context) {
        this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[]{Context.class}, context);
    }

    /* JADX INFO: renamed from: c */
    public void m566c(String str) {
        this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "retainIconForPageUrl", new Class[]{String.class}, str);
    }

    /* JADX INFO: renamed from: c */
    public void m567c(String str, android.webkit.ValueCallback<Boolean> valueCallback) {
        this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetAllowed", new Class[]{String.class, android.webkit.ValueCallback.class}, str, valueCallback);
    }

    /* JADX INFO: renamed from: d */
    public void m568d(String str) {
        this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "releaseIconForPageUrl", new Class[]{String.class}, str);
    }

    /* JADX INFO: renamed from: d */
    public boolean m569d() {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptCookie", new Class[0], new Object[0]);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) objInvokeStaticMethod).booleanValue();
    }

    /* JADX INFO: renamed from: d */
    public boolean m570d(Context context) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasHttpAuthUsernamePassword", new Class[]{Context.class}, context);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) objInvokeStaticMethod).booleanValue();
    }

    /* JADX INFO: renamed from: e */
    public void m571e() {
        this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookie", new Class[0], new Object[0]);
    }

    /* JADX INFO: renamed from: e */
    public void m572e(Context context) {
        this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[]{Context.class}, context);
    }

    /* JADX INFO: renamed from: e */
    public void m573e(String str) {
        this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteOrigin", new Class[]{String.class}, str);
    }

    /* JADX INFO: renamed from: f */
    public String m574f() {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getMiniQBVersion", new Class[0], new Object[0]);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (String) objInvokeStaticMethod;
    }

    /* JADX INFO: renamed from: f */
    public void m575f(String str) {
        this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClear", new Class[]{String.class}, str);
    }

    /* JADX INFO: renamed from: f */
    public boolean m576f(Context context) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasFormData", new Class[]{Context.class}, context);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) objInvokeStaticMethod).booleanValue();
    }

    /* JADX INFO: renamed from: g */
    public Object m577g() {
        return this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCachFileBaseDir", new Class[0], new Object[0]);
    }

    /* JADX INFO: renamed from: g */
    public void m578g(Context context) {
        this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[]{Context.class}, context);
    }

    /* JADX INFO: renamed from: g */
    public void m579g(String str) {
        this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsAllow", new Class[]{String.class}, str);
    }

    /* JADX INFO: renamed from: h */
    public IX5DateSorter m580h(Context context) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDateSorter", new Class[]{Context.class}, context);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (IX5DateSorter) objInvokeStaticMethod;
    }

    /* JADX INFO: renamed from: h */
    public String m581h(String str) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetFileExtensionFromUrl", new Class[]{String.class}, str);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (String) objInvokeStaticMethod;
    }

    /* JADX INFO: renamed from: h */
    public boolean m582h() {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_hasCookies", new Class[0], new Object[0]);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) objInvokeStaticMethod).booleanValue();
    }

    /* JADX INFO: renamed from: i */
    public IX5WebChromeClient m583i() {
        Object objInvokeStaticMethod;
        DexLoader dexLoader = this.f661a;
        if (dexLoader == null || (objInvokeStaticMethod = dexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClient", new Class[0], new Object[0])) == null) {
            return null;
        }
        return (IX5WebChromeClient) objInvokeStaticMethod;
    }

    /* JADX INFO: renamed from: i */
    public String m584i(Context context) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getDefaultUserAgent", new Class[]{Context.class}, context);
        if (objInvokeStaticMethod instanceof String) {
            return (String) objInvokeStaticMethod;
        }
        return null;
    }

    /* JADX INFO: renamed from: i */
    public boolean m585i(String str) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapHasMimeType", new Class[]{String.class}, str);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) objInvokeStaticMethod).booleanValue();
    }

    /* JADX INFO: renamed from: j */
    public IX5WebViewClient m586j() {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebViewClient", new Class[0], new Object[0]);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (IX5WebViewClient) objInvokeStaticMethod;
    }

    /* JADX INFO: renamed from: j */
    public String m587j(String str) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetMimeTypeFromExtension", new Class[]{String.class}, str);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (String) objInvokeStaticMethod;
    }

    /* JADX INFO: renamed from: k */
    public IX5WebViewClientExtension m588k() {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClientExtension", new Class[0], new Object[0]);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (IX5WebViewClientExtension) objInvokeStaticMethod;
    }

    /* JADX INFO: renamed from: k */
    public boolean m589k(String str) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapHasExtension", new Class[]{String.class}, str);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) objInvokeStaticMethod).booleanValue();
    }

    /* JADX INFO: renamed from: l */
    public String m590l(String str) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetMimeTypeFromExtension", new Class[]{String.class}, str);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (String) objInvokeStaticMethod;
    }

    /* JADX INFO: renamed from: l */
    public void m591l() {
        this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
    }

    /* JADX INFO: renamed from: m */
    public String m592m(String str) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessUrl", new Class[]{String.class}, str);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (String) objInvokeStaticMethod;
    }

    /* JADX INFO: renamed from: m */
    public void m593m() {
        this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeIconDB", null, new Object[0]);
    }

    /* JADX INFO: renamed from: n */
    public void m594n() {
        this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteAllData", null, new Object[0]);
    }

    /* JADX INFO: renamed from: n */
    public boolean m595n(String str) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAssetUrl", new Class[]{String.class}, str);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) objInvokeStaticMethod).booleanValue();
    }

    /* JADX INFO: renamed from: o */
    public void m596o() {
        this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClearAll", null, new Object[0]);
    }

    /* JADX INFO: renamed from: o */
    public boolean m597o(String str) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsCookielessProxyUrl", new Class[]{String.class}, str);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) objInvokeStaticMethod).booleanValue();
    }

    /* JADX INFO: renamed from: p */
    public void m598p() {
        this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeFileReader", new Class[0], new Object[0]);
    }

    /* JADX INFO: renamed from: p */
    public boolean m599p(String str) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsFileUrl", new Class[]{String.class}, str);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) objInvokeStaticMethod).booleanValue();
    }

    /* JADX INFO: renamed from: q */
    public IX5CoreServiceWorkerController m600q() {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getServiceWorkerController", new Class[0], new Object[0]);
        if (objInvokeStaticMethod instanceof IX5CoreServiceWorkerController) {
            return (IX5CoreServiceWorkerController) objInvokeStaticMethod;
        }
        return null;
    }

    /* JADX INFO: renamed from: q */
    public boolean m601q(String str) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAboutUrl", new Class[]{String.class}, str);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) objInvokeStaticMethod).booleanValue();
    }

    /* JADX INFO: renamed from: r */
    public boolean m602r(String str) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsDataUrl", new Class[]{String.class}, str);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) objInvokeStaticMethod).booleanValue();
    }

    /* JADX INFO: renamed from: s */
    public boolean m603s(String str) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsJavaScriptUrl", new Class[]{String.class}, str);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) objInvokeStaticMethod).booleanValue();
    }

    /* JADX INFO: renamed from: t */
    public boolean m604t(String str) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpUrl", new Class[]{String.class}, str);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) objInvokeStaticMethod).booleanValue();
    }

    /* JADX INFO: renamed from: u */
    public boolean m605u(String str) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpsUrl", new Class[]{String.class}, str);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) objInvokeStaticMethod).booleanValue();
    }

    /* JADX INFO: renamed from: v */
    public boolean m606v(String str) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsNetworkUrl", new Class[]{String.class}, str);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) objInvokeStaticMethod).booleanValue();
    }

    /* JADX INFO: renamed from: w */
    public boolean m607w(String str) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsContentUrl", new Class[]{String.class}, str);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) objInvokeStaticMethod).booleanValue();
    }

    /* JADX INFO: renamed from: x */
    public boolean m608x(String str) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsValidUrl", new Class[]{String.class}, str);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) objInvokeStaticMethod).booleanValue();
    }

    /* JADX INFO: renamed from: y */
    public String m609y(String str) {
        Object objInvokeStaticMethod = this.f661a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilStripAnchor", new Class[]{String.class}, str);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (String) objInvokeStaticMethod;
    }
}
