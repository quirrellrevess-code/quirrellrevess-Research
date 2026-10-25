package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;

/* JADX INFO: loaded from: classes.dex */
public class DateSorter {
    public static int DAY_COUNT;

    /* JADX INFO: renamed from: a */
    private android.webkit.DateSorter f151a;

    /* JADX INFO: renamed from: b */
    private IX5DateSorter f152b;

    static {
        m130a();
        DAY_COUNT = 5;
    }

    public DateSorter(Context context) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            this.f151a = new android.webkit.DateSorter(context);
        } else {
            this.f152b = c0431uM530a.m535c().m580h(context);
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m130a() {
        C0431u c0431uM530a = C0431u.m530a();
        return c0431uM530a != null && c0431uM530a.m534b();
    }

    public long getBoundary(int i) {
        C0431u c0431uM530a = C0431u.m530a();
        return (c0431uM530a == null || !c0431uM530a.m534b()) ? this.f151a.getBoundary(i) : this.f152b.getBoundary(i);
    }

    public int getIndex(long j) {
        C0431u c0431uM530a = C0431u.m530a();
        return (c0431uM530a == null || !c0431uM530a.m534b()) ? this.f151a.getIndex(j) : this.f152b.getIndex(j);
    }

    public String getLabel(int i) {
        C0431u c0431uM530a = C0431u.m530a();
        return (c0431uM530a == null || !c0431uM530a.m534b()) ? this.f151a.getLabel(i) : this.f152b.getLabel(i);
    }
}
