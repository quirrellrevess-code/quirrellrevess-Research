package com.tencent.smtt.utils;

import com.tencent.smtt.sdk.TbsListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.tencent.smtt.utils.f */
/* JADX INFO: loaded from: classes.dex */
public class C0449f {

    /* JADX INFO: renamed from: b */
    private static C0449f f798b;

    /* JADX INFO: renamed from: a */
    private final Map<Integer, String> f799a;

    private C0449f() {
        HashMap map = new HashMap();
        this.f799a = map;
        map.put(Integer.valueOf(TbsListener.ErrorCode.THROWABLE_INITX5CORE), "if NoSuchMethodError, please check the Class in base.apk which is conflict with x5.");
        map.put(Integer.valueOf(TbsListener.ErrorCode.ERROR_CPU_NOT_SUPPORT), "your CPU is i686|mips|x86_64? sorry X5 is not support them.");
        map.put(402, "QbSdk.forceSysWebView() has been called! Check it.");
        map.put(404, "try to restart your app.");
    }

    /* JADX INFO: renamed from: a */
    public static C0449f m738a() {
        if (f798b == null) {
            f798b = new C0449f();
        }
        return f798b;
    }

    /* JADX INFO: renamed from: a */
    public String m739a(int i) {
        if (i >= 303 && i <= 324) {
            return "Core has some problem, try to reinstall the app.";
        }
        try {
            return this.f799a.get(Integer.valueOf(i));
        } catch (Exception unused) {
            return "Unexpected load error.";
        }
    }
}
