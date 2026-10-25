package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import com.tencent.smtt.export.external.DexLoader;

/* JADX INFO: renamed from: com.tencent.smtt.sdk.o */
/* JADX INFO: loaded from: classes.dex */
public class C0421o {

    /* JADX INFO: renamed from: a */
    private DexLoader f602a;

    /* JADX INFO: renamed from: b */
    private Object f603b = null;

    public C0421o(DexLoader dexLoader) {
        this.f602a = null;
        this.f602a = dexLoader;
    }

    /* JADX INFO: renamed from: a */
    public Object m467a(Context context, Object obj, Bundle bundle) {
        DexLoader dexLoader = this.f602a;
        if (dexLoader != null) {
            this.f603b = dexLoader.newInstance("com.tencent.tbs.cache.TbsVideoCacheTaskProxy", new Class[]{Context.class, Object.class, Bundle.class}, context, obj, bundle);
        }
        return this.f603b;
    }

    /* JADX INFO: renamed from: a */
    public void m468a() {
        DexLoader dexLoader = this.f602a;
        if (dexLoader != null) {
            dexLoader.invokeMethod(this.f603b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "pauseTask", new Class[0], new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m469a(boolean z) {
        DexLoader dexLoader = this.f602a;
        if (dexLoader != null) {
            dexLoader.invokeMethod(this.f603b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "removeTask", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    /* JADX INFO: renamed from: b */
    public void m470b() {
        DexLoader dexLoader = this.f602a;
        if (dexLoader != null) {
            dexLoader.invokeMethod(this.f603b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "resumeTask", new Class[0], new Object[0]);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m471c() {
        DexLoader dexLoader = this.f602a;
        if (dexLoader != null) {
            dexLoader.invokeMethod(this.f603b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "stopTask", new Class[0], new Object[0]);
        }
    }

    /* JADX INFO: renamed from: d */
    public long m472d() {
        DexLoader dexLoader = this.f602a;
        if (dexLoader == null) {
            return 0L;
        }
        Object objInvokeMethod = dexLoader.invokeMethod(this.f603b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getContentLength", new Class[0], new Object[0]);
        if (objInvokeMethod instanceof Long) {
            return ((Long) objInvokeMethod).longValue();
        }
        return 0L;
    }

    /* JADX INFO: renamed from: e */
    public int m473e() {
        DexLoader dexLoader = this.f602a;
        if (dexLoader != null) {
            Object objInvokeMethod = dexLoader.invokeMethod(this.f603b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getDownloadedSize", new Class[0], new Object[0]);
            if (objInvokeMethod instanceof Integer) {
                return ((Integer) objInvokeMethod).intValue();
            }
        }
        return 0;
    }

    /* JADX INFO: renamed from: f */
    public int m474f() {
        DexLoader dexLoader = this.f602a;
        if (dexLoader != null) {
            Object objInvokeMethod = dexLoader.invokeMethod(this.f603b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getProgress", new Class[0], new Object[0]);
            if (objInvokeMethod instanceof Integer) {
                return ((Integer) objInvokeMethod).intValue();
            }
        }
        return 0;
    }
}
