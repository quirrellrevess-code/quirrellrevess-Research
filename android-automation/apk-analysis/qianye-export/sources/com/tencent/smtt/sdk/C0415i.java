package com.tencent.smtt.sdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.export.external.proxy.X5ProxyWebViewClient;
import com.tencent.smtt.utils.C0459p;
import org.opencv.videoio.Videoio;

/* JADX INFO: renamed from: com.tencent.smtt.sdk.i */
/* JADX INFO: loaded from: classes.dex */
public class C0415i extends X5ProxyWebViewClient {

    /* JADX INFO: renamed from: c */
    private static String f537c;

    /* JADX INFO: renamed from: a */
    private WebViewClient f538a;

    /* JADX INFO: renamed from: b */
    private WebView f539b;

    public C0415i(IX5WebViewClient iX5WebViewClient, WebView webView, WebViewClient webViewClient) {
        super(iX5WebViewClient);
        this.f539b = webView;
        this.f538a = webViewClient;
        webViewClient.mX5Client = this;
    }

    /* JADX INFO: renamed from: a */
    public void m342a(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(this.f539b.m282b(), 0, 0, str, bitmap);
    }

    /* JADX INFO: renamed from: a */
    public void m343a(String str) {
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(str));
        intent.addFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
        try {
            if (this.f539b.getContext() != null) {
                this.f539b.getContext().startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public void countPVContentCacheCallBack(String str) {
        this.f539b.f427a++;
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void doUpdateVisitedHistory(IX5WebViewBase iX5WebViewBase, String str, boolean z) {
        this.f539b.m281a(iX5WebViewBase);
        this.f538a.doUpdateVisitedHistory(this.f539b, str, z);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onDetectedBlankScreen(IX5WebViewBase iX5WebViewBase, String str, int i) {
        this.f539b.m281a(iX5WebViewBase);
        this.f538a.onDetectedBlankScreen(str, i);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onFormResubmission(IX5WebViewBase iX5WebViewBase, Message message, Message message2) {
        this.f539b.m281a(iX5WebViewBase);
        this.f538a.onFormResubmission(this.f539b, message, message2);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onLoadResource(IX5WebViewBase iX5WebViewBase, String str) {
        this.f539b.m281a(iX5WebViewBase);
        this.f538a.onLoadResource(this.f539b, str);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageCommitVisible(IX5WebViewBase iX5WebViewBase, String str) {
        this.f539b.m281a(iX5WebViewBase);
        this.f538a.onPageCommitVisible(this.f539b, str);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageFinished(IX5WebViewBase iX5WebViewBase, int i, int i2, String str) {
        C0459p c0459pM801a;
        TbsPrivacyAccess.rmPrivacyItemIfNeeded(iX5WebViewBase.getView().getContext().getApplicationContext());
        if (f537c == null && (c0459pM801a = C0459p.m801a()) != null) {
            c0459pM801a.m803a(false);
            f537c = Boolean.toString(false);
        }
        this.f539b.m281a(iX5WebViewBase);
        this.f539b.f427a++;
        this.f538a.onPageFinished(this.f539b, str);
        try {
            super.onPageFinished(iX5WebViewBase, i, i2, str);
        } catch (Exception unused) {
        }
        WebView.m268c();
        if (!TbsShareManager.mHasQueried && this.f539b.getContext() != null && TbsShareManager.isThirdPartyApp(this.f539b.getContext()) && !QbSdk.m160d()) {
            TbsShareManager.mHasQueried = true;
            new Thread(new Runnable() { // from class: com.tencent.smtt.sdk.i.1
                @Override // java.lang.Runnable
                public void run() {
                    TbsDownloader.needDownload(C0415i.this.f539b.getContext(), false);
                }
            }).start();
        }
        if (this.f539b.getContext() == null || TbsLogReport.getInstance(this.f539b.getContext()).getShouldUploadEventReport()) {
            return;
        }
        TbsLogReport.getInstance(this.f539b.getContext()).setShouldUploadEventReport(true);
        TbsLogReport.getInstance(this.f539b.getContext()).dailyReport();
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageFinished(IX5WebViewBase iX5WebViewBase, String str) {
        onPageFinished(iX5WebViewBase, 0, 0, str);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageStarted(IX5WebViewBase iX5WebViewBase, int i, int i2, String str, Bitmap bitmap) {
        this.f539b.m281a(iX5WebViewBase);
        this.f538a.onPageStarted(this.f539b, str, bitmap);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageStarted(IX5WebViewBase iX5WebViewBase, String str, Bitmap bitmap) {
        onPageStarted(iX5WebViewBase, 0, 0, str, bitmap);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedClientCertRequest(IX5WebViewBase iX5WebViewBase, ClientCertRequest clientCertRequest) {
        this.f539b.m281a(iX5WebViewBase);
        this.f538a.onReceivedClientCertRequest(this.f539b, clientCertRequest);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedError(IX5WebViewBase iX5WebViewBase, int i, String str, String str2) {
        if (i < -15) {
            if (i != -17) {
                return;
            } else {
                i = -1;
            }
        }
        this.f539b.m281a(iX5WebViewBase);
        this.f538a.onReceivedError(this.f539b, i, str, str2);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedError(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        this.f539b.m281a(iX5WebViewBase);
        this.f538a.onReceivedError(this.f539b, webResourceRequest, webResourceError);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedHttpAuthRequest(IX5WebViewBase iX5WebViewBase, HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.f539b.m281a(iX5WebViewBase);
        this.f538a.onReceivedHttpAuthRequest(this.f539b, httpAuthHandler, str, str2);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedHttpError(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        this.f539b.m281a(iX5WebViewBase);
        this.f538a.onReceivedHttpError(this.f539b, webResourceRequest, webResourceResponse);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedLoginRequest(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3) {
        this.f539b.m281a(iX5WebViewBase);
        this.f538a.onReceivedLoginRequest(this.f539b, str, str2, str3);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedSslError(IX5WebViewBase iX5WebViewBase, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.f539b.m281a(iX5WebViewBase);
        this.f538a.onReceivedSslError(this.f539b, sslErrorHandler, sslError);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public boolean onRenderProcessGone(IX5WebViewBase iX5WebViewBase, final boolean z, final int i) {
        return this.f538a.onRenderProcessGone(this.f539b, new WebViewClient.RenderProcessGoneDetail() { // from class: com.tencent.smtt.sdk.i.2
            @Override // com.tencent.smtt.sdk.WebViewClient.RenderProcessGoneDetail
            public boolean didCrash() {
                return z;
            }

            @Override // com.tencent.smtt.sdk.WebViewClient.RenderProcessGoneDetail
            public int rendererPriorityAtExit() {
                return i;
            }
        });
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onScaleChanged(IX5WebViewBase iX5WebViewBase, float f, float f2) {
        this.f539b.m281a(iX5WebViewBase);
        this.f538a.onScaleChanged(this.f539b, f, f2);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onTooManyRedirects(IX5WebViewBase iX5WebViewBase, Message message, Message message2) {
        this.f539b.m281a(iX5WebViewBase);
        this.f538a.onTooManyRedirects(this.f539b, message, message2);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onUnhandledKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent) {
        this.f539b.m281a(iX5WebViewBase);
        this.f538a.onUnhandledKeyEvent(this.f539b, keyEvent);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest) {
        this.f539b.m281a(iX5WebViewBase);
        return this.f538a.shouldInterceptRequest(this.f539b, webResourceRequest);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, Bundle bundle) {
        this.f539b.m281a(iX5WebViewBase);
        return this.f538a.shouldInterceptRequest(this.f539b, webResourceRequest, bundle);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, String str) {
        this.f539b.m281a(iX5WebViewBase);
        return this.f538a.shouldInterceptRequest(this.f539b, str);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public boolean shouldOverrideKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent) {
        this.f539b.m281a(iX5WebViewBase);
        return this.f538a.shouldOverrideKeyEvent(this.f539b, keyEvent);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public boolean shouldOverrideUrlLoading(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest) {
        String string = (webResourceRequest == null || webResourceRequest.getUrl() == null) ? null : webResourceRequest.getUrl().toString();
        if (string == null || this.f539b.showDebugView(string)) {
            return true;
        }
        this.f539b.m281a(iX5WebViewBase);
        boolean zShouldOverrideUrlLoading = this.f538a.shouldOverrideUrlLoading(this.f539b, webResourceRequest);
        if (!zShouldOverrideUrlLoading) {
            if (string.startsWith("wtai://wp/mc;")) {
                this.f539b.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(WebView.SCHEME_TEL + string.substring(13))));
                return true;
            }
            if (string.startsWith(WebView.SCHEME_TEL)) {
                m343a(string);
                return true;
            }
        }
        return zShouldOverrideUrlLoading;
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public boolean shouldOverrideUrlLoading(IX5WebViewBase iX5WebViewBase, String str) {
        if (str == null || this.f539b.showDebugView(str)) {
            return true;
        }
        this.f539b.m281a(iX5WebViewBase);
        boolean zShouldOverrideUrlLoading = this.f538a.shouldOverrideUrlLoading(this.f539b, str);
        if (!zShouldOverrideUrlLoading) {
            if (str.startsWith("wtai://wp/mc;")) {
                this.f539b.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(WebView.SCHEME_TEL + str.substring(13))));
                return true;
            }
            if (str.startsWith(WebView.SCHEME_TEL)) {
                m343a(str);
                return true;
            }
        }
        return zShouldOverrideUrlLoading;
    }
}
