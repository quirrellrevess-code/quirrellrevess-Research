package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.DexLoader;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.tencent.smtt.sdk.e */
/* JADX INFO: loaded from: classes.dex */
public class C0411e extends ProxyController {
    /* JADX INFO: renamed from: a */
    private void m318a(Executor executor, Runnable runnable) {
        try {
            Class<?> cls = Class.forName("androidx.webkit.internal.ProxyControllerImpl");
            Method declaredMethod = cls.getDeclaredMethod("getBoundaryInterface", new Class[0]);
            declaredMethod.setAccessible(true);
            Class.forName("org.chromium.support_lib_boundary.ProxyControllerBoundaryInterface").getMethod("clearProxyOverride", Runnable.class, Executor.class).invoke(declaredMethod.invoke(cls.newInstance(), new Object[0]), runnable, executor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    public static String[][] m319a(List<ProxyConfig.ProxyRule> list) {
        String[][] strArr = (String[][]) Array.newInstance((Class<?>) String.class, list.size(), 2);
        for (int i = 0; i < list.size(); i++) {
            strArr[i][0] = list.get(i).getSchemeFilter();
            strArr[i][1] = list.get(i).getUrl();
        }
        return strArr;
    }

    /* JADX INFO: renamed from: b */
    private void m320b(Executor executor, Runnable runnable) {
        try {
            DexLoader dexLoaderM558b = C0431u.m530a().m535c().m558b();
            dexLoaderM558b.invokeMethod(dexLoaderM558b.newInstance("android.webview.chromium.tencent.TencentSupportProxyController", new Class[0], new Object[0]), "android.webview.chromium.tencent.TencentSupportProxyController", "clearProxyOverride", new Class[]{Runnable.class, Executor.class}, runnable, executor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m321a(String[][] strArr, String[] strArr2, Runnable runnable, Executor executor) {
        try {
            DexLoader dexLoaderM558b = C0431u.m530a().m535c().m558b();
            dexLoaderM558b.invokeMethod(dexLoaderM558b.newInstance("android.webview.chromium.tencent.TencentSupportProxyController", new Class[0], new Object[0]), "android.webview.chromium.tencent.TencentSupportProxyController", "setProxyOverride", new Class[]{String[][].class, String[].class, Runnable.class, Executor.class, Boolean.TYPE}, strArr, strArr2, runnable, executor, Boolean.FALSE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m322b(String[][] strArr, String[] strArr2, Runnable runnable, Executor executor) {
        try {
            Class<?> cls = Class.forName("androidx.webkit.internal.ProxyControllerImpl");
            Method declaredMethod = cls.getDeclaredMethod("getBoundaryInterface", new Class[0]);
            declaredMethod.setAccessible(true);
            Class.forName("org.chromium.support_lib_boundary.ProxyControllerBoundaryInterface").getMethod("setProxyOverride", String[][].class, String[].class, Runnable.class, Executor.class).invoke(declaredMethod.invoke(cls.newInstance(), new Object[0]), strArr, strArr2, runnable, executor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.tencent.smtt.sdk.ProxyController
    public void clearProxyOverride(Executor executor, Runnable runnable) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            m318a(executor, runnable);
        } else {
            m320b(executor, runnable);
        }
    }

    @Override // com.tencent.smtt.sdk.ProxyController
    public void setProxyOverride(ProxyConfig proxyConfig, Executor executor, Runnable runnable) {
        String[][] strArrM319a = m319a(proxyConfig.getProxyRules());
        String[] strArr = (String[]) proxyConfig.getBypassRules().toArray(new String[0]);
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            m322b(strArrM319a, strArr, runnable, executor);
        } else {
            m321a(strArrM319a, strArr, runnable, executor);
        }
    }
}
