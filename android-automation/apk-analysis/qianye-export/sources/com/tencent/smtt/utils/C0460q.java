package com.tencent.smtt.utils;

import android.os.Build;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.tencent.smtt.utils.q */
/* JADX INFO: loaded from: classes.dex */
public class C0460q {

    /* JADX INFO: renamed from: a */
    private b f845a = null;

    /* JADX INFO: renamed from: b */
    private b f846b = null;

    /* JADX INFO: renamed from: com.tencent.smtt.utils.q$a */
    public class a {

        /* JADX INFO: renamed from: b */
        private String f848b;

        /* JADX INFO: renamed from: c */
        private long f849c;

        /* JADX INFO: renamed from: d */
        private long f850d;

        public a(String str, long j, long j2) {
            this.f848b = str;
            this.f849c = j;
            this.f850d = j2;
        }

        /* JADX INFO: renamed from: a */
        public long m809a() {
            return this.f849c;
        }

        /* JADX INFO: renamed from: b */
        public long m810b() {
            return this.f850d;
        }
    }

    /* JADX INFO: renamed from: com.tencent.smtt.utils.q$b */
    public class b {

        /* JADX INFO: renamed from: b */
        private Map<String, a> f852b;

        public b(File file) {
            HashMap map = new HashMap();
            this.f852b = map;
            map.clear();
            m811a(file);
        }

        /* JADX INFO: renamed from: a */
        private void m811a(File file) {
            if (!file.isDirectory()) {
                if (file.isFile()) {
                    m812a(file.getName(), file.length(), file.lastModified());
                    return;
                }
                return;
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null || Build.VERSION.SDK_INT < 26) {
                for (File file2 : fileArrListFiles) {
                    m811a(file2);
                }
            }
        }

        /* JADX INFO: renamed from: a */
        private void m812a(String str, long j, long j2) {
            if (str == null || str.length() <= 0 || j <= 0 || j2 <= 0) {
                return;
            }
            a aVar = C0460q.this.new a(str, j, j2);
            if (this.f852b.containsKey(str)) {
                return;
            }
            this.f852b.put(str, aVar);
        }

        /* JADX INFO: renamed from: a */
        public Map<String, a> m813a() {
            return this.f852b;
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m805a(b bVar, b bVar2) {
        if (bVar == null || bVar.m813a() == null || bVar2 == null || bVar2.m813a() == null) {
            return false;
        }
        Map<String, a> mapM813a = bVar.m813a();
        Map<String, a> mapM813a2 = bVar2.m813a();
        for (Map.Entry<String, a> entry : mapM813a.entrySet()) {
            String key = entry.getKey();
            a value = entry.getValue();
            if (mapM813a2.containsKey(key)) {
                a aVar = mapM813a2.get(key);
                if (value.m809a() != aVar.m809a() || value.m810b() != aVar.m810b()) {
                }
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void m806a(File file) {
        this.f845a = new b(file);
    }

    /* JADX INFO: renamed from: a */
    public boolean m807a() {
        b bVar = this.f846b;
        return bVar != null && this.f845a != null && bVar.m813a().size() == this.f845a.m813a().size() && m805a(this.f845a, this.f846b);
    }

    /* JADX INFO: renamed from: b */
    public void m808b(File file) {
        this.f846b = new b(file);
    }
}
