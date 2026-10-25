package com.tencent.smtt.sdk;

import android.content.Context;
import com.google.android.flexbox.BuildConfig;
import com.tencent.smtt.export.external.DexLoader;

/* JADX INFO: loaded from: classes.dex */
public class TbsVideoUtils {

    /* JADX INFO: renamed from: a */
    private static C0423q f389a;

    /* JADX INFO: renamed from: a */
    private static void m243a(Context context) {
        synchronized (TbsVideoUtils.class) {
            if (f389a == null) {
                C0412f.m323a(true).m329a(context, false, false);
                C0425s c0425sM328a = C0412f.m323a(true).m328a();
                DexLoader dexLoaderM498c = c0425sM328a != null ? c0425sM328a.m498c() : null;
                if (dexLoaderM498c != null) {
                    f389a = new C0423q(dexLoaderM498c);
                }
            }
        }
    }

    public static void deleteVideoCache(Context context, String str) {
        m243a(context);
        C0423q c0423q = f389a;
        if (c0423q != null) {
            c0423q.m481a(context, str);
        }
    }

    public static String getCurWDPDecodeType(Context context) {
        m243a(context);
        C0423q c0423q = f389a;
        return c0423q != null ? c0423q.m480a(context) : BuildConfig.FLAVOR;
    }
}
