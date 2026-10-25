package com.tencent.smtt.sdk;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class WebViewDatabase {

    /* JADX INFO: renamed from: a */
    private static WebViewDatabase f462a;

    /* JADX INFO: renamed from: b */
    private Context f463b;

    public WebViewDatabase(Context context) {
        this.f463b = context;
    }

    /* JADX INFO: renamed from: a */
    private static synchronized WebViewDatabase m290a(Context context) {
        if (f462a == null) {
            f462a = new WebViewDatabase(context);
        }
        return f462a;
    }

    public static WebViewDatabase getInstance(Context context) {
        return m290a(context);
    }

    public void clearFormData() {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            android.webkit.WebViewDatabase.getInstance(this.f463b).clearFormData();
        } else {
            c0431uM530a.m535c().m578g(this.f463b);
        }
    }

    public void clearHttpAuthUsernamePassword() {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            android.webkit.WebViewDatabase.getInstance(this.f463b).clearHttpAuthUsernamePassword();
        } else {
            c0431uM530a.m535c().m572e(this.f463b);
        }
    }

    @Deprecated
    public void clearUsernamePassword() {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            android.webkit.WebViewDatabase.getInstance(this.f463b).clearUsernamePassword();
        } else {
            c0431uM530a.m535c().m565c(this.f463b);
        }
    }

    public boolean hasFormData() {
        C0431u c0431uM530a = C0431u.m530a();
        return (c0431uM530a == null || !c0431uM530a.m534b()) ? android.webkit.WebViewDatabase.getInstance(this.f463b).hasFormData() : c0431uM530a.m535c().m576f(this.f463b);
    }

    public boolean hasHttpAuthUsernamePassword() {
        C0431u c0431uM530a = C0431u.m530a();
        return (c0431uM530a == null || !c0431uM530a.m534b()) ? android.webkit.WebViewDatabase.getInstance(this.f463b).hasHttpAuthUsernamePassword() : c0431uM530a.m535c().m570d(this.f463b);
    }

    @Deprecated
    public boolean hasUsernamePassword() {
        C0431u c0431uM530a = C0431u.m530a();
        return (c0431uM530a == null || !c0431uM530a.m534b()) ? android.webkit.WebViewDatabase.getInstance(this.f463b).hasUsernamePassword() : c0431uM530a.m535c().m563b(this.f463b);
    }
}
