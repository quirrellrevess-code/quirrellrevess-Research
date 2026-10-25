package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;

/* JADX INFO: loaded from: classes.dex */
public class TbsMediaFactory {

    /* JADX INFO: renamed from: a */
    private Context f349a;

    /* JADX INFO: renamed from: b */
    private C0425s f350b = null;

    /* JADX INFO: renamed from: c */
    private DexLoader f351c = null;

    public TbsMediaFactory(Context context) {
        this.f349a = null;
        this.f349a = context.getApplicationContext();
        m231a();
    }

    /* JADX INFO: renamed from: a */
    private void m231a() {
        if (this.f349a == null) {
            Log.e("TbsVideo", "TbsVideo needs context !!");
            return;
        }
        if (this.f350b == null) {
            C0412f.m323a(true).m329a(this.f349a, false, false);
            C0425s c0425sM328a = C0412f.m323a(true).m328a();
            this.f350b = c0425sM328a;
            if (c0425sM328a != null) {
                this.f351c = c0425sM328a.m498c();
            }
        }
        if (this.f350b == null || this.f351c == null) {
            throw new RuntimeException("tbs core dex(s) load failure !!!");
        }
    }

    public TbsMediaPlayer createPlayer() {
        DexLoader dexLoader;
        if (this.f350b == null || (dexLoader = this.f351c) == null) {
            throw new RuntimeException("tbs core dex(s) did not loaded !!!");
        }
        return new TbsMediaPlayer(new C0420n(dexLoader, this.f349a));
    }
}
