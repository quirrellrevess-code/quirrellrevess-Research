package com.tencent.smtt.utils;

import android.content.Context;
import com.google.android.flexbox.BuildConfig;
import com.tencent.smtt.sdk.TbsLogReport;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.tencent.smtt.utils.r */
/* JADX INFO: loaded from: classes.dex */
public class C0461r {

    /* JADX INFO: renamed from: a */
    private static C0461r f853a;

    /* JADX INFO: renamed from: c */
    private boolean f855c = false;

    /* JADX INFO: renamed from: b */
    private Map<String, Long> f854b = new HashMap();

    private C0461r() {
    }

    /* JADX INFO: renamed from: a */
    public static C0461r m814a() {
        if (f853a == null) {
            synchronized (TbsLogReport.class) {
                if (f853a == null) {
                    f853a = new C0461r();
                }
            }
        }
        return f853a;
    }

    /* JADX INFO: renamed from: a */
    private boolean m815a(long j) {
        return j <= 100000 && j > 0;
    }

    /* JADX INFO: renamed from: b */
    private long m816b(String str) {
        Long l = this.f854b.get(str);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    /* JADX INFO: renamed from: a */
    public void m817a(Context context) {
        if (this.f855c) {
            return;
        }
        TbsLog.m665i("TbsTimeRecorder", m819b());
        this.f855c = true;
        TbsLogReport tbsLogReport = TbsLogReport.getInstance(context);
        tbsLogReport.eventReport(TbsLogReport.EventType.TYPE_CORE_LOAD_PERFORMANCE, tbsLogReport.tbsLogInfo());
    }

    /* JADX INFO: renamed from: a */
    public void m818a(String str) {
        this.f854b.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    /* JADX INFO: renamed from: b */
    public String m819b() {
        long jM816b = m816b("init_tbs_end") - m816b("init_tbs_Start");
        long jM816b2 = m816b("preinit_finish") - m816b("preinit_start");
        long jM816b3 = m816b("create_webview_end") - m816b("create_webview_start");
        long jM816b4 = m816b("core_load_end") - m816b("core_load_start");
        StringBuilder sb = new StringBuilder();
        sb.append(BuildConfig.FLAVOR);
        sb.append("initX5Environment: ");
        if (!m815a(jM816b)) {
            jM816b = -1;
        }
        sb.append(jM816b);
        sb.append(",");
        String string = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(string);
        sb2.append("preInit: ");
        if (!m815a(jM816b2)) {
            jM816b2 = -1;
        }
        sb2.append(jM816b2);
        sb2.append(",");
        String string2 = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(string2);
        sb3.append("webview: ");
        if (!m815a(jM816b3)) {
            jM816b3 = -1;
        }
        sb3.append(jM816b3);
        sb3.append(",");
        String string3 = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(string3);
        sb4.append("coreLoadCost: ");
        if (!m815a(jM816b4)) {
            jM816b4 = -1;
        }
        sb4.append(jM816b4);
        return sb4.toString();
    }
}
