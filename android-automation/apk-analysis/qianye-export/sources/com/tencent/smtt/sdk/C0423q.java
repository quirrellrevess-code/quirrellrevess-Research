package com.tencent.smtt.sdk;

import android.content.Context;
import com.google.android.flexbox.BuildConfig;
import com.tencent.smtt.export.external.DexLoader;

/* JADX INFO: renamed from: com.tencent.smtt.sdk.q */
/* JADX INFO: loaded from: classes.dex */
public class C0423q {

    /* JADX INFO: renamed from: a */
    private DexLoader f610a;

    public C0423q(DexLoader dexLoader) {
        this.f610a = null;
        this.f610a = dexLoader;
    }

    /* JADX INFO: renamed from: a */
    public String m480a(Context context) {
        Object objNewInstance;
        Object objInvokeMethod;
        DexLoader dexLoader = this.f610a;
        return (dexLoader == null || (objNewInstance = dexLoader.newInstance("com.tencent.tbs.utils.TbsVideoUtilsProxy", new Class[0], new Object[0])) == null || (objInvokeMethod = this.f610a.invokeMethod(objNewInstance, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "getCurWDPDecodeType", new Class[]{Context.class}, context)) == null) ? BuildConfig.FLAVOR : String.valueOf(objInvokeMethod);
    }

    /* JADX INFO: renamed from: a */
    public void m481a(Context context, String str) {
        Object objNewInstance;
        DexLoader dexLoader = this.f610a;
        if (dexLoader == null || (objNewInstance = dexLoader.newInstance("com.tencent.tbs.utils.TbsVideoUtilsProxy", new Class[0], new Object[0])) == null) {
            return;
        }
        this.f610a.invokeMethod(objNewInstance, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "deleteVideoCache", new Class[]{Context.class, String.class}, context, str);
    }
}
