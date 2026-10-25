package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.smtt.export.external.DexLoader;
import dalvik.system.DexClassLoader;

/* JADX INFO: renamed from: com.tencent.smtt.sdk.t */
/* JADX INFO: loaded from: classes.dex */
public class C0430t {

    /* JADX INFO: renamed from: a */
    public DexLoader f642a;

    public C0430t(DexLoader dexLoader) {
        this.f642a = null;
        this.f642a = dexLoader;
    }

    /* JADX INFO: renamed from: a */
    public Object m526a(Context context) {
        DexLoader dexLoader = this.f642a;
        return dexLoader.newInstance("com.tencent.tbs.player.TbsPlayerProxy", new Class[]{Context.class, DexClassLoader.class}, context, dexLoader.getClassLoader());
    }

    /* JADX INFO: renamed from: a */
    public void m527a(Object obj) {
        this.f642a.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", "onUserStateChanged", new Class[0], new Object[0]);
    }

    /* JADX INFO: renamed from: a */
    public void m528a(Object obj, Activity activity, int i) {
        this.f642a.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", "onActivity", new Class[]{Activity.class, Integer.TYPE}, activity, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: a */
    public boolean m529a(Object obj, Bundle bundle, FrameLayout frameLayout, Object obj2) {
        DexLoader dexLoader = this.f642a;
        Object objInvokeMethod = obj2 != null ? dexLoader.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", "play", new Class[]{Bundle.class, FrameLayout.class, Object.class}, bundle, frameLayout, obj2) : dexLoader.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", "play", new Class[]{Bundle.class, FrameLayout.class}, bundle, frameLayout);
        if (objInvokeMethod instanceof Boolean) {
            return ((Boolean) objInvokeMethod).booleanValue();
        }
        return false;
    }
}
