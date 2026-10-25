package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.google.android.flexbox.BuildConfig;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class TbsReaderPredownload {
    public static final int READER_SO_SUCCESS = 2;
    public static final int READER_WAIT_IN_QUEUE = 3;

    /* JADX INFO: renamed from: b */
    public static final String[] f361b = {"docx", "pptx", "xlsx", "pdf", "epub", "txt"};

    /* JADX INFO: renamed from: a */
    public Handler f362a = null;

    /* JADX INFO: renamed from: c */
    public LinkedList<String> f363c = new LinkedList<>();

    /* JADX INFO: renamed from: d */
    public boolean f364d = false;

    /* JADX INFO: renamed from: e */
    public ReaderWizard f365e = null;

    /* JADX INFO: renamed from: f */
    public TbsReaderView.ReaderCallback f366f = null;

    /* JADX INFO: renamed from: g */
    public Object f367g = null;

    /* JADX INFO: renamed from: h */
    public Context f368h = null;

    /* JADX INFO: renamed from: i */
    public ReaderPreDownloadCallback f369i = null;

    /* JADX INFO: renamed from: j */
    public String f370j = BuildConfig.FLAVOR;

    public interface ReaderPreDownloadCallback {
        public static final int NOTIFY_PLUGIN_FAILED = -1;
        public static final int NOTIFY_PLUGIN_SUCCESS = 0;

        void onEvent(String str, int i, boolean z);
    }

    public TbsReaderPredownload(ReaderPreDownloadCallback readerPreDownloadCallback) {
        throw new IllegalAccessError("Current SDK not support Reader.");
    }

    /* JADX INFO: renamed from: a */
    private void m235a() {
        m238b(3);
    }

    /* JADX INFO: renamed from: a */
    public void m236a(int i) {
        if (this.f369i != null) {
            this.f369i.onEvent(this.f370j, i, this.f363c.isEmpty());
        }
    }

    /* JADX INFO: renamed from: a */
    public void m237a(int i, int i2) {
        this.f362a.sendMessageDelayed(this.f362a.obtainMessage(i), i2);
    }

    /* JADX INFO: renamed from: b */
    public void m238b(int i) {
        this.f362a.removeMessages(i);
    }

    /* JADX INFO: renamed from: c */
    public boolean m239c(int i) {
        return this.f362a.hasMessages(i);
    }

    public boolean init(Context context) {
        if (context == null) {
            return false;
        }
        this.f368h = context.getApplicationContext();
        boolean zM240a = TbsReaderView.m240a(context.getApplicationContext());
        TbsReaderView.ReaderCallback readerCallback = new TbsReaderView.ReaderCallback() { // from class: com.tencent.smtt.sdk.TbsReaderPredownload.1
            @Override // com.tencent.smtt.sdk.TbsReaderView.ReaderCallback
            public void onCallBackAction(Integer num, Object obj, Object obj2) {
                int iIntValue;
                if (num.intValue() == 5012 && 5014 != (iIntValue = ((Integer) obj).intValue())) {
                    if (5013 == iIntValue || iIntValue == 0) {
                        TbsReaderPredownload.this.m236a(0);
                    } else {
                        TbsReaderPredownload.this.m236a(-1);
                    }
                    TbsReaderPredownload tbsReaderPredownload = TbsReaderPredownload.this;
                    tbsReaderPredownload.f370j = BuildConfig.FLAVOR;
                    tbsReaderPredownload.m237a(3, 100);
                }
            }
        };
        this.f366f = readerCallback;
        try {
            if (this.f365e == null) {
                this.f365e = new ReaderWizard(readerCallback);
            }
            if (this.f367g == null) {
                this.f367g = this.f365e.getTbsReader();
            }
            Object obj = this.f367g;
            return obj != null ? this.f365e.initTbsReader(obj, context.getApplicationContext()) : zM240a;
        } catch (NullPointerException unused) {
            Log.e("TbsReaderPredownload", "Unexpect null object!");
            return false;
        }
    }

    public void pause() {
        this.f364d = true;
    }

    public void shutdown() {
        this.f369i = null;
        this.f364d = false;
        this.f363c.clear();
        m235a();
        ReaderWizard readerWizard = this.f365e;
        if (readerWizard != null) {
            readerWizard.destroy(this.f367g);
            this.f367g = null;
        }
        this.f368h = null;
    }

    public void start(String str) {
        this.f364d = false;
        m238b(3);
        this.f363c.add(str);
        m237a(3, 100);
    }

    public void startAll() {
        this.f364d = false;
        if (!false && !m239c(3)) {
            m237a(3, 100);
        }
    }
}
