package com.tencent.smtt.sdk;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class GeolocationPermissions {

    /* JADX INFO: renamed from: a */
    private static GeolocationPermissions f153a;

    /* JADX INFO: renamed from: a */
    private static synchronized GeolocationPermissions m131a() {
        if (f153a == null) {
            f153a = new GeolocationPermissions();
        }
        return f153a;
    }

    public static GeolocationPermissions getInstance() {
        return m131a();
    }

    public void allow(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            android.webkit.GeolocationPermissions.getInstance().allow(str);
        } else {
            c0431uM530a.m535c().m579g(str);
        }
    }

    public void clear(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            android.webkit.GeolocationPermissions.getInstance().clear(str);
        } else {
            c0431uM530a.m535c().m575f(str);
        }
    }

    public void clearAll() {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            android.webkit.GeolocationPermissions.getInstance().clearAll();
        } else {
            c0431uM530a.m535c().m596o();
        }
    }

    public void getAllowed(String str, ValueCallback<Boolean> valueCallback) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            android.webkit.GeolocationPermissions.getInstance().getAllowed(str, valueCallback);
        } else {
            c0431uM530a.m535c().m567c(str, valueCallback);
        }
    }

    public void getOrigins(ValueCallback<Set<String>> valueCallback) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            android.webkit.GeolocationPermissions.getInstance().getOrigins(valueCallback);
        } else {
            c0431uM530a.m535c().m560b(valueCallback);
        }
    }
}
