package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: classes.dex */
public final class URLUtil {
    public static String composeSearchUrl(String str, String str2, String str3) {
        C0431u c0431uM530a = C0431u.m530a();
        return (c0431uM530a == null || !c0431uM530a.m534b()) ? android.webkit.URLUtil.composeSearchUrl(str, str2, str3) : c0431uM530a.m535c().m547a(str, str2, str3);
    }

    public static byte[] decode(byte[] bArr) throws IllegalArgumentException {
        C0431u c0431uM530a = C0431u.m530a();
        return (c0431uM530a == null || !c0431uM530a.m534b()) ? android.webkit.URLUtil.decode(bArr) : c0431uM530a.m535c().m556a(bArr);
    }

    public static final String guessFileName(String str, String str2, String str3) {
        C0431u c0431uM530a = C0431u.m530a();
        return (c0431uM530a == null || !c0431uM530a.m534b()) ? android.webkit.URLUtil.guessFileName(str, str2, str3) : c0431uM530a.m535c().m559b(str, str2, str3);
    }

    public static String guessUrl(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        return (c0431uM530a == null || !c0431uM530a.m534b()) ? android.webkit.URLUtil.guessUrl(str) : c0431uM530a.m535c().m592m(str);
    }

    public static boolean isAboutUrl(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        return (c0431uM530a == null || !c0431uM530a.m534b()) ? android.webkit.URLUtil.isAboutUrl(str) : c0431uM530a.m535c().m601q(str);
    }

    public static boolean isAssetUrl(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        return (c0431uM530a == null || !c0431uM530a.m534b()) ? android.webkit.URLUtil.isAssetUrl(str) : c0431uM530a.m535c().m595n(str);
    }

    public static boolean isContentUrl(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        return (c0431uM530a == null || !c0431uM530a.m534b()) ? android.webkit.URLUtil.isContentUrl(str) : c0431uM530a.m535c().m607w(str);
    }

    @Deprecated
    public static boolean isCookielessProxyUrl(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        return (c0431uM530a == null || !c0431uM530a.m534b()) ? android.webkit.URLUtil.isCookielessProxyUrl(str) : c0431uM530a.m535c().m597o(str);
    }

    public static boolean isDataUrl(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        return (c0431uM530a == null || !c0431uM530a.m534b()) ? android.webkit.URLUtil.isDataUrl(str) : c0431uM530a.m535c().m602r(str);
    }

    public static boolean isFileUrl(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        return (c0431uM530a == null || !c0431uM530a.m534b()) ? android.webkit.URLUtil.isFileUrl(str) : c0431uM530a.m535c().m599p(str);
    }

    public static boolean isHttpUrl(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        return (c0431uM530a == null || !c0431uM530a.m534b()) ? android.webkit.URLUtil.isHttpUrl(str) : c0431uM530a.m535c().m604t(str);
    }

    public static boolean isHttpsUrl(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        return (c0431uM530a == null || !c0431uM530a.m534b()) ? android.webkit.URLUtil.isHttpsUrl(str) : c0431uM530a.m535c().m605u(str);
    }

    public static boolean isJavaScriptUrl(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        return (c0431uM530a == null || !c0431uM530a.m534b()) ? android.webkit.URLUtil.isJavaScriptUrl(str) : c0431uM530a.m535c().m603s(str);
    }

    public static boolean isNetworkUrl(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        return (c0431uM530a == null || !c0431uM530a.m534b()) ? android.webkit.URLUtil.isNetworkUrl(str) : c0431uM530a.m535c().m606v(str);
    }

    public static boolean isValidUrl(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        return (c0431uM530a == null || !c0431uM530a.m534b()) ? android.webkit.URLUtil.isValidUrl(str) : c0431uM530a.m535c().m608x(str);
    }

    public static String stripAnchor(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        return (c0431uM530a == null || !c0431uM530a.m534b()) ? android.webkit.URLUtil.stripAnchor(str) : c0431uM530a.m535c().m609y(str);
    }
}
