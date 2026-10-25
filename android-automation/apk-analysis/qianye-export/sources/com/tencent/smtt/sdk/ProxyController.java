package com.tencent.smtt.sdk;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class ProxyController {

    /* JADX INFO: renamed from: com.tencent.smtt.sdk.ProxyController$a */
    public static class C0356a {

        /* JADX INFO: renamed from: a */
        public static final ProxyController f179a = new C0411e();
    }

    public static ProxyController getInstance() {
        return C0356a.f179a;
    }

    public abstract void clearProxyOverride(Executor executor, Runnable runnable);

    public abstract void setProxyOverride(ProxyConfig proxyConfig, Executor executor, Runnable runnable);
}
