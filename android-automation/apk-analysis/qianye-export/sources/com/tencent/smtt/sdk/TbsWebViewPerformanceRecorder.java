package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: classes.dex */
public class TbsWebViewPerformanceRecorder {

    /* JADX INFO: renamed from: a */
    private long f390a = 0;

    /* JADX INFO: renamed from: b */
    private long f391b = 0;

    /* JADX INFO: renamed from: c */
    private long f392c = 0;

    /* JADX INFO: renamed from: d */
    private long f393d = 0;

    /* JADX INFO: renamed from: e */
    private long f394e = 0;

    /* JADX INFO: renamed from: f */
    private String f395f = "unknown";

    /* JADX INFO: renamed from: a */
    public void m244a(long j) {
        this.f390a = j;
    }

    /* JADX INFO: renamed from: a */
    public void m245a(long j, String str) {
        this.f393d += j;
        this.f392c++;
        this.f394e = j;
        this.f395f = str;
    }

    /* JADX INFO: renamed from: b */
    public void m246b(long j) {
        this.f391b = j;
    }

    public long getAverageUrlLoadTime() {
        long j = this.f392c;
        if (j == 0) {
            return 0L;
        }
        return this.f393d / j;
    }

    public long getConstructTime() {
        return this.f390a;
    }

    public long getCoreInitTime() {
        return this.f391b;
    }

    public String getCurrentUrl() {
        return this.f395f;
    }

    public long getCurrentUrlLoadTime() {
        return this.f394e;
    }

    public String getLog() {
        return "TbsWebViewPerformanceRecorder{constructTime=" + this.f390a + ", coreInitTime=" + this.f391b + ", currentUrlLoadTime=" + this.f394e + ", currentUrl='" + this.f395f + "'}";
    }
}
