package com.tencent.smtt.sdk;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import com.tencent.smtt.export.external.DexLoader;

/* JADX INFO: renamed from: com.tencent.smtt.sdk.n */
/* JADX INFO: loaded from: classes.dex */
public class C0420n {

    /* JADX INFO: renamed from: a */
    private DexLoader f600a;

    /* JADX INFO: renamed from: b */
    private Object f601b;

    public C0420n(DexLoader dexLoader, Context context) {
        this.f600a = null;
        this.f601b = null;
        this.f600a = dexLoader;
        this.f601b = dexLoader.newInstance("com.tencent.tbs.player.TbsMediaPlayerProxy", new Class[]{Context.class}, context);
    }

    /* JADX INFO: renamed from: a */
    public void m455a(float f) {
        this.f600a.invokeMethod(this.f601b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setVolume", new Class[]{Float.TYPE}, Float.valueOf(f));
    }

    /* JADX INFO: renamed from: a */
    public void m456a(int i) {
        this.f600a.invokeMethod(this.f601b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "subtitle", new Class[]{Integer.TYPE}, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: a */
    public void m457a(long j) {
        this.f600a.invokeMethod(this.f601b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "seek", new Class[]{Long.TYPE}, Long.valueOf(j));
    }

    /* JADX INFO: renamed from: a */
    public void m458a(SurfaceTexture surfaceTexture) {
        this.f600a.invokeMethod(this.f601b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setSurfaceTexture", new Class[]{SurfaceTexture.class}, surfaceTexture);
    }

    /* JADX INFO: renamed from: a */
    public void m459a(TbsMediaPlayer.TbsMediaPlayerListener tbsMediaPlayerListener) {
        this.f600a.invokeMethod(this.f601b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setPlayerListener", new Class[]{Object.class}, tbsMediaPlayerListener);
    }

    /* JADX INFO: renamed from: a */
    public void m460a(String str, Bundle bundle) {
        this.f600a.invokeMethod(this.f601b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "startPlay", new Class[]{String.class, Bundle.class}, str, bundle);
    }

    /* JADX INFO: renamed from: a */
    public boolean m461a() {
        return this.f601b != null;
    }

    /* JADX INFO: renamed from: b */
    public float m462b() {
        Float f = (Float) this.f600a.invokeMethod(this.f601b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "getVolume", new Class[0], new Object[0]);
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    /* JADX INFO: renamed from: b */
    public void m463b(int i) {
        this.f600a.invokeMethod(this.f601b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "audio", new Class[]{Integer.TYPE}, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: c */
    public void m464c() {
        this.f600a.invokeMethod(this.f601b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "pause", new Class[0], new Object[0]);
    }

    /* JADX INFO: renamed from: d */
    public void m465d() {
        this.f600a.invokeMethod(this.f601b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "play", new Class[0], new Object[0]);
    }

    /* JADX INFO: renamed from: e */
    public void m466e() {
        this.f600a.invokeMethod(this.f601b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "close", new Class[0], new Object[0]);
    }
}
