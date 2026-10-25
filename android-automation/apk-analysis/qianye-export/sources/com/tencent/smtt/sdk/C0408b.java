package com.tencent.smtt.sdk;

/* JADX INFO: renamed from: com.tencent.smtt.sdk.b */
/* JADX INFO: loaded from: classes.dex */
public class C0408b implements com.tencent.smtt.export.external.interfaces.DownloadListener {

    /* JADX INFO: renamed from: a */
    private DownloadListener f505a;

    /* JADX INFO: renamed from: b */
    private WebView f506b;

    public C0408b(WebView webView, DownloadListener downloadListener, boolean z) {
        this.f505a = downloadListener;
        this.f506b = webView;
    }

    @Override // com.tencent.smtt.export.external.interfaces.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        onDownloadStart(str, null, null, str2, str3, str4, j, null, null);
    }

    @Override // com.tencent.smtt.export.external.interfaces.DownloadListener
    public void onDownloadStart(String str, String str2, byte[] bArr, String str3, String str4, String str5, long j, String str6, String str7) {
        DownloadListener downloadListener = this.f505a;
        if (downloadListener == null) {
            return;
        }
        downloadListener.onDownloadStart(str, str3, str4, str5, j);
    }

    @Override // com.tencent.smtt.export.external.interfaces.DownloadListener
    public void onDownloadVideo(String str, long j, int i) {
    }
}
