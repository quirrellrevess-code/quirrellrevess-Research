package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import com.tencent.smtt.export.external.DexLoader;

/* JADX INFO: loaded from: classes.dex */
public class TbsVideoCacheTask {
    public static final String KEY_VIDEO_CACHE_PARAM_FILENAME = "filename";
    public static final String KEY_VIDEO_CACHE_PARAM_FOLDERPATH = "folderPath";
    public static final String KEY_VIDEO_CACHE_PARAM_HEADER = "header";
    public static final String KEY_VIDEO_CACHE_PARAM_URL = "url";

    /* JADX INFO: renamed from: a */
    public Context f382a;

    /* JADX INFO: renamed from: b */
    public TbsVideoCacheListener f383b;

    /* JADX INFO: renamed from: e */
    private String f386e;

    /* JADX INFO: renamed from: f */
    private String f387f;

    /* JADX INFO: renamed from: c */
    private boolean f384c = false;

    /* JADX INFO: renamed from: d */
    private C0421o f385d = null;

    /* JADX INFO: renamed from: g */
    private Object f388g = null;

    public TbsVideoCacheTask(Context context, Bundle bundle, TbsVideoCacheListener tbsVideoCacheListener) {
        this.f382a = null;
        this.f383b = null;
        this.f382a = context;
        this.f383b = tbsVideoCacheListener;
        if (bundle != null) {
            this.f386e = bundle.getString("taskId");
            this.f387f = bundle.getString(KEY_VIDEO_CACHE_PARAM_URL);
        }
        m242a(bundle);
    }

    /* JADX INFO: renamed from: a */
    private void m242a(Bundle bundle) {
        TbsVideoCacheListener tbsVideoCacheListener;
        String str;
        DexLoader dexLoaderM498c;
        if (this.f385d == null) {
            C0412f.m323a(true).m329a(this.f382a, false, false);
            C0425s c0425sM328a = C0412f.m323a(true).m328a();
            if (c0425sM328a != null) {
                dexLoaderM498c = c0425sM328a.m498c();
            } else {
                this.f383b.onVideoDownloadError(this, -1, "init engine error!", null);
                dexLoaderM498c = null;
            }
            if (dexLoaderM498c != null) {
                this.f385d = new C0421o(dexLoaderM498c);
            } else {
                this.f383b.onVideoDownloadError(this, -1, "Java dexloader invalid!", null);
            }
        }
        C0421o c0421o = this.f385d;
        if (c0421o != null) {
            Object objM467a = c0421o.m467a(this.f382a, this, bundle);
            this.f388g = objM467a;
            if (objM467a != null) {
                return;
            }
            tbsVideoCacheListener = this.f383b;
            str = "init task error!";
        } else {
            tbsVideoCacheListener = this.f383b;
            if (tbsVideoCacheListener == null) {
                return;
            } else {
                str = "init error!";
            }
        }
        tbsVideoCacheListener.onVideoDownloadError(this, -1, str, null);
    }

    public long getContentLength() {
        C0421o c0421o = this.f385d;
        if (c0421o != null && this.f388g != null) {
            return c0421o.m472d();
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.f383b;
        if (tbsVideoCacheListener == null) {
            return 0L;
        }
        tbsVideoCacheListener.onVideoDownloadError(this, -1, "getContentLength failed, init uncompleted!", null);
        return 0L;
    }

    public int getDownloadedSize() {
        C0421o c0421o = this.f385d;
        if (c0421o != null && this.f388g != null) {
            return c0421o.m473e();
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.f383b;
        if (tbsVideoCacheListener == null) {
            return 0;
        }
        tbsVideoCacheListener.onVideoDownloadError(this, -1, "getDownloadedSize failed, init uncompleted!", null);
        return 0;
    }

    public int getProgress() {
        C0421o c0421o = this.f385d;
        if (c0421o != null && this.f388g != null) {
            return c0421o.m474f();
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.f383b;
        if (tbsVideoCacheListener == null) {
            return 0;
        }
        tbsVideoCacheListener.onVideoDownloadError(this, -1, "getProgress failed, init uncompleted!", null);
        return 0;
    }

    public String getTaskID() {
        return this.f386e;
    }

    public String getTaskUrl() {
        return this.f387f;
    }

    public void pauseTask() {
        C0421o c0421o = this.f385d;
        if (c0421o != null && this.f388g != null) {
            c0421o.m468a();
            return;
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.f383b;
        if (tbsVideoCacheListener != null) {
            tbsVideoCacheListener.onVideoDownloadError(this, -1, "pauseTask failed, init uncompleted!", null);
        }
    }

    public void removeTask(boolean z) {
        C0421o c0421o = this.f385d;
        if (c0421o != null && this.f388g != null) {
            c0421o.m469a(z);
            return;
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.f383b;
        if (tbsVideoCacheListener != null) {
            tbsVideoCacheListener.onVideoDownloadError(this, -1, "removeTask failed, init uncompleted!", null);
        }
    }

    public void resumeTask() {
        C0421o c0421o = this.f385d;
        if (c0421o != null && this.f388g != null) {
            c0421o.m470b();
            return;
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.f383b;
        if (tbsVideoCacheListener != null) {
            tbsVideoCacheListener.onVideoDownloadError(this, -1, "resumeTask failed, init uncompleted!", null);
        }
    }

    public void stopTask() {
        C0421o c0421o = this.f385d;
        if (c0421o != null && this.f388g != null) {
            c0421o.m471c();
            return;
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.f383b;
        if (tbsVideoCacheListener != null) {
            tbsVideoCacheListener.onVideoDownloadError(this, -1, "stopTask failed, init uncompleted!", null);
        }
    }
}
