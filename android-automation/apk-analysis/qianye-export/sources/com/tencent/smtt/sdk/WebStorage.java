package com.tencent.smtt.sdk;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class WebStorage {

    /* JADX INFO: renamed from: a */
    private static WebStorage f421a;

    @Deprecated
    public interface QuotaUpdater {
        void updateQuota(long j);
    }

    /* JADX INFO: renamed from: a */
    private static synchronized WebStorage m253a() {
        if (f421a == null) {
            f421a = new WebStorage();
        }
        return f421a;
    }

    public static WebStorage getInstance() {
        return m253a();
    }

    public void deleteAllData() {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            android.webkit.WebStorage.getInstance().deleteAllData();
        } else {
            c0431uM530a.m535c().m594n();
        }
    }

    public void deleteOrigin(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            android.webkit.WebStorage.getInstance().deleteOrigin(str);
        } else {
            c0431uM530a.m535c().m573e(str);
        }
    }

    public void getOrigins(ValueCallback<Map> valueCallback) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            android.webkit.WebStorage.getInstance().getOrigins(valueCallback);
        } else {
            c0431uM530a.m535c().m549a(valueCallback);
        }
    }

    public void getQuotaForOrigin(String str, ValueCallback<Long> valueCallback) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            android.webkit.WebStorage.getInstance().getQuotaForOrigin(str, valueCallback);
        } else {
            c0431uM530a.m535c().m562b(str, valueCallback);
        }
    }

    public void getUsageForOrigin(String str, ValueCallback<Long> valueCallback) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            android.webkit.WebStorage.getInstance().getUsageForOrigin(str, valueCallback);
        } else {
            c0431uM530a.m535c().m551a(str, valueCallback);
        }
    }

    @Deprecated
    public void setQuotaForOrigin(String str, long j) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            android.webkit.WebStorage.getInstance().setQuotaForOrigin(str, j);
        } else {
            c0431uM530a.m535c().m550a(str, j);
        }
    }
}
