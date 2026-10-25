package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.view.View;

/* JADX INFO: renamed from: com.tencent.smtt.sdk.c */
/* JADX INFO: loaded from: classes.dex */
public class C0409c extends SystemWebChromeClient {
    public C0409c(WebView webView, WebChromeClient webChromeClient) {
        super(webView, webChromeClient);
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public void onHideCustomView() {
        this.f234a.onHideCustomView();
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(14)
    @Deprecated
    public void onShowCustomView(View view, int i, android.webkit.WebChromeClient.CustomViewCallback customViewCallback) {
        this.f234a.onShowCustomView(view, i, new SystemWebChromeClient.C0372b(customViewCallback));
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public void onShowCustomView(View view, android.webkit.WebChromeClient.CustomViewCallback customViewCallback) {
        this.f234a.onShowCustomView(view, new SystemWebChromeClient.C0372b(customViewCallback));
    }
}
