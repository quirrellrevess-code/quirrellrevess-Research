package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: classes.dex */
public class MimeTypeMap {

    /* JADX INFO: renamed from: a */
    private static MimeTypeMap f172a;

    private MimeTypeMap() {
    }

    public static String getFileExtensionFromUrl(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        return (c0431uM530a == null || !c0431uM530a.m534b()) ? android.webkit.MimeTypeMap.getFileExtensionFromUrl(str) : c0431uM530a.m535c().m581h(str);
    }

    public static synchronized MimeTypeMap getSingleton() {
        if (f172a == null) {
            f172a = new MimeTypeMap();
        }
        return f172a;
    }

    public String getExtensionFromMimeType(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        return (c0431uM530a == null || !c0431uM530a.m534b()) ? android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(str) : c0431uM530a.m535c().m590l(str);
    }

    public String getMimeTypeFromExtension(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        return (c0431uM530a == null || !c0431uM530a.m534b()) ? android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(str) : c0431uM530a.m535c().m587j(str);
    }

    public boolean hasExtension(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        return (c0431uM530a == null || !c0431uM530a.m534b()) ? android.webkit.MimeTypeMap.getSingleton().hasExtension(str) : c0431uM530a.m535c().m589k(str);
    }

    public boolean hasMimeType(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        return (c0431uM530a == null || !c0431uM530a.m534b()) ? android.webkit.MimeTypeMap.getSingleton().hasMimeType(str) : c0431uM530a.m535c().m585i(str);
    }
}
