package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.utils.C0453j;
import com.tencent.smtt.utils.C0459p;
import java.io.InputStream;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi", "Override"})
public class SystemWebViewClient extends android.webkit.WebViewClient {

    /* JADX INFO: renamed from: c */
    private static String f265c;

    /* JADX INFO: renamed from: a */
    private WebViewClient f266a;

    /* JADX INFO: renamed from: b */
    private WebView f267b;

    /* JADX INFO: renamed from: com.tencent.smtt.sdk.SystemWebViewClient$a */
    public static class C0380a extends ClientCertRequest {

        /* JADX INFO: renamed from: a */
        private android.webkit.ClientCertRequest f273a;

        public C0380a(android.webkit.ClientCertRequest clientCertRequest) {
            this.f273a = clientCertRequest;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void cancel() {
            this.f273a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public String getHost() {
            return this.f273a.getHost();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public String[] getKeyTypes() {
            return this.f273a.getKeyTypes();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public int getPort() {
            return this.f273a.getPort();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public Principal[] getPrincipals() {
            return this.f273a.getPrincipals();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void ignore() {
            this.f273a.ignore();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void proceed(PrivateKey privateKey, X509Certificate[] x509CertificateArr) {
            this.f273a.proceed(privateKey, x509CertificateArr);
        }
    }

    /* JADX INFO: renamed from: com.tencent.smtt.sdk.SystemWebViewClient$b */
    public static class C0381b implements HttpAuthHandler {

        /* JADX INFO: renamed from: a */
        private android.webkit.HttpAuthHandler f274a;

        public C0381b(android.webkit.HttpAuthHandler httpAuthHandler) {
            this.f274a = httpAuthHandler;
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public void cancel() {
            this.f274a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public void proceed(String str, String str2) {
            this.f274a.proceed(str, str2);
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public boolean useHttpAuthUsernamePassword() {
            return this.f274a.useHttpAuthUsernamePassword();
        }
    }

    /* JADX INFO: renamed from: com.tencent.smtt.sdk.SystemWebViewClient$c */
    public static class C0382c implements SslErrorHandler {

        /* JADX INFO: renamed from: a */
        public android.webkit.SslErrorHandler f275a;

        public C0382c(android.webkit.SslErrorHandler sslErrorHandler) {
            this.f275a = sslErrorHandler;
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslErrorHandler
        public void cancel() {
            this.f275a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslErrorHandler
        public void proceed() {
            this.f275a.proceed();
        }
    }

    /* JADX INFO: renamed from: com.tencent.smtt.sdk.SystemWebViewClient$d */
    public static class C0383d implements SslError {

        /* JADX INFO: renamed from: a */
        public android.net.http.SslError f276a;

        public C0383d(android.net.http.SslError sslError) {
            this.f276a = sslError;
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public boolean addError(int i) {
            return this.f276a.addError(i);
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public SslCertificate getCertificate() {
            return this.f276a.getCertificate();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public int getPrimaryError() {
            return this.f276a.getPrimaryError();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public String getUrl() {
            return this.f276a.getUrl();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public boolean hasError(int i) {
            return this.f276a.hasError(i);
        }
    }

    /* JADX INFO: renamed from: com.tencent.smtt.sdk.SystemWebViewClient$e */
    public static class C0384e implements WebResourceRequest {

        /* JADX INFO: renamed from: a */
        private String f277a;

        /* JADX INFO: renamed from: b */
        private boolean f278b;

        /* JADX INFO: renamed from: c */
        private boolean f279c;

        /* JADX INFO: renamed from: d */
        private boolean f280d;

        /* JADX INFO: renamed from: e */
        private String f281e;

        /* JADX INFO: renamed from: f */
        private Map<String, String> f282f;

        public C0384e(String str, boolean z, boolean z2, boolean z3, String str2, Map<String, String> map) {
            this.f277a = str;
            this.f278b = z;
            this.f279c = z2;
            this.f280d = z3;
            this.f281e = str2;
            this.f282f = map;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public String getMethod() {
            return this.f281e;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Map<String, String> getRequestHeaders() {
            return this.f282f;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Uri getUrl() {
            return Uri.parse(this.f277a);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean hasGesture() {
            return this.f280d;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isForMainFrame() {
            return this.f278b;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isRedirect() {
            return this.f279c;
        }
    }

    /* JADX INFO: renamed from: com.tencent.smtt.sdk.SystemWebViewClient$f */
    public static class C0385f implements WebResourceRequest {

        /* JADX INFO: renamed from: a */
        public android.webkit.WebResourceRequest f283a;

        public C0385f(android.webkit.WebResourceRequest webResourceRequest) {
            this.f283a = webResourceRequest;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public String getMethod() {
            return this.f283a.getMethod();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Map<String, String> getRequestHeaders() {
            return this.f283a.getRequestHeaders();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Uri getUrl() {
            return this.f283a.getUrl();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean hasGesture() {
            return this.f283a.hasGesture();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isForMainFrame() {
            return this.f283a.isForMainFrame();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isRedirect() {
            if (Build.VERSION.SDK_INT >= 24) {
                Object objM762a = C0453j.m762a(this.f283a, "isRedirect");
                if (objM762a instanceof Boolean) {
                    return ((Boolean) objM762a).booleanValue();
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: com.tencent.smtt.sdk.SystemWebViewClient$g */
    public static class C0386g extends WebResourceResponse {

        /* JADX INFO: renamed from: a */
        public android.webkit.WebResourceResponse f284a;

        public C0386g(android.webkit.WebResourceResponse webResourceResponse) {
            this.f284a = webResourceResponse;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public InputStream getData() {
            return this.f284a.getData();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public String getEncoding() {
            return this.f284a.getEncoding();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public String getMimeType() {
            return this.f284a.getMimeType();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public String getReasonPhrase() {
            return this.f284a.getReasonPhrase();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public Map<String, String> getResponseHeaders() {
            return this.f284a.getResponseHeaders();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public int getStatusCode() {
            return this.f284a.getStatusCode();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setData(InputStream inputStream) {
            this.f284a.setData(inputStream);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setEncoding(String str) {
            this.f284a.setEncoding(str);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setMimeType(String str) {
            this.f284a.setMimeType(str);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setResponseHeaders(Map<String, String> map) {
            this.f284a.setResponseHeaders(map);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setStatusCodeAndReasonPhrase(int i, String str) {
            this.f284a.setStatusCodeAndReasonPhrase(i, str);
        }
    }

    public SystemWebViewClient(WebView webView, WebViewClient webViewClient) {
        this.f267b = webView;
        this.f266a = webViewClient;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(android.webkit.WebView webView, String str, boolean z) {
        this.f267b.m280a(webView);
        this.f266a.doUpdateVisitedHistory(this.f267b, str, z);
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(android.webkit.WebView webView, Message message, Message message2) {
        this.f267b.m280a(webView);
        this.f266a.onFormResubmission(this.f267b, message, message2);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(android.webkit.WebView webView, String str) {
        this.f267b.m280a(webView);
        this.f266a.onLoadResource(this.f267b, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(android.webkit.WebView webView, String str) {
        this.f267b.m280a(webView);
        this.f266a.onPageCommitVisible(this.f267b, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(android.webkit.WebView webView, String str) {
        C0459p c0459pM801a;
        TbsPrivacyAccess.rmPrivacyItemIfNeeded(webView.getContext().getApplicationContext());
        if (f265c == null && (c0459pM801a = C0459p.m801a()) != null) {
            c0459pM801a.m803a(true);
            f265c = Boolean.toString(true);
        }
        this.f267b.m280a(webView);
        this.f267b.f427a++;
        this.f266a.onPageFinished(this.f267b, str);
        WebView.m268c();
        if (!TbsShareManager.mHasQueried && this.f267b.getContext() != null && TbsShareManager.isThirdPartyApp(this.f267b.getContext()) && !QbSdk.m160d()) {
            TbsShareManager.mHasQueried = true;
            new Thread(new Runnable() { // from class: com.tencent.smtt.sdk.SystemWebViewClient.1
                @Override // java.lang.Runnable
                public void run() {
                    TbsDownloader.needDownload(SystemWebViewClient.this.f267b.getContext(), false);
                }
            }).start();
        }
        if (this.f267b.getContext() == null || TbsLogReport.getInstance(this.f267b.getContext()).getShouldUploadEventReport()) {
            return;
        }
        TbsLogReport.getInstance(this.f267b.getContext()).setShouldUploadEventReport(true);
        TbsLogReport.getInstance(this.f267b.getContext()).dailyReport();
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(android.webkit.WebView webView, String str, Bitmap bitmap) {
        this.f267b.m280a(webView);
        this.f266a.onPageStarted(this.f267b, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedClientCertRequest(android.webkit.WebView webView, android.webkit.ClientCertRequest clientCertRequest) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f267b.m280a(webView);
            this.f266a.onReceivedClientCertRequest(this.f267b, new C0380a(clientCertRequest));
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(android.webkit.WebView webView, int i, String str, String str2) {
        this.f267b.m280a(webView);
        this.f266a.onReceivedError(this.f267b, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, final WebResourceError webResourceError) {
        this.f267b.m280a(webView);
        this.f266a.onReceivedError(this.f267b, webResourceRequest != null ? new C0385f(webResourceRequest) : null, webResourceError != null ? new com.tencent.smtt.export.external.interfaces.WebResourceError() { // from class: com.tencent.smtt.sdk.SystemWebViewClient.2
            @Override // com.tencent.smtt.export.external.interfaces.WebResourceError
            public CharSequence getDescription() {
                return webResourceError.getDescription();
            }

            @Override // com.tencent.smtt.export.external.interfaces.WebResourceError
            public int getErrorCode() {
                return webResourceError.getErrorCode();
            }
        } : null);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(android.webkit.WebView webView, android.webkit.HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.f267b.m280a(webView);
        this.f266a.onReceivedHttpAuthRequest(this.f267b, new C0381b(httpAuthHandler), str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceResponse webResourceResponse) {
        this.f267b.m280a(webView);
        this.f266a.onReceivedHttpError(this.f267b, new C0385f(webResourceRequest), new C0386g(webResourceResponse));
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(12)
    public void onReceivedLoginRequest(android.webkit.WebView webView, String str, String str2, String str3) {
        if (Build.VERSION.SDK_INT >= 12) {
            this.f267b.m280a(webView);
            this.f266a.onReceivedLoginRequest(this.f267b, str, str2, str3);
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(8)
    public void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
        if (Build.VERSION.SDK_INT >= 8) {
            this.f267b.m280a(webView);
            this.f266a.onReceivedSslError(this.f267b, new C0382c(sslErrorHandler), new C0383d(sslError));
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(android.webkit.WebView webView, final RenderProcessGoneDetail renderProcessGoneDetail) {
        this.f267b.m280a(webView);
        return this.f266a.onRenderProcessGone(this.f267b, new WebViewClient.RenderProcessGoneDetail() { // from class: com.tencent.smtt.sdk.SystemWebViewClient.3
            @Override // com.tencent.smtt.sdk.WebViewClient.RenderProcessGoneDetail
            public boolean didCrash() {
                return renderProcessGoneDetail.didCrash();
            }

            @Override // com.tencent.smtt.sdk.WebViewClient.RenderProcessGoneDetail
            public int rendererPriorityAtExit() {
                return renderProcessGoneDetail.rendererPriorityAtExit();
            }
        });
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(android.webkit.WebView webView, float f, float f2) {
        this.f267b.m280a(webView);
        this.f266a.onScaleChanged(this.f267b, f, f2);
    }

    @Override // android.webkit.WebViewClient
    public void onTooManyRedirects(android.webkit.WebView webView, Message message, Message message2) {
        this.f267b.m280a(webView);
        this.f266a.onTooManyRedirects(this.f267b, message, message2);
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(android.webkit.WebView webView, KeyEvent keyEvent) {
        this.f267b.m280a(webView);
        this.f266a.onUnhandledKeyEvent(this.f267b, keyEvent);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0022  */
    @Override // android.webkit.WebViewClient
    public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
        boolean zBooleanValue;
        int i = Build.VERSION.SDK_INT;
        if (i < 21 || webResourceRequest == null) {
            return null;
        }
        if (i >= 24) {
            Object objM762a = C0453j.m762a(webResourceRequest, "isRedirect");
            if (objM762a instanceof Boolean) {
                zBooleanValue = ((Boolean) objM762a).booleanValue();
            } else {
                zBooleanValue = false;
            }
        } else {
            zBooleanValue = false;
        }
        WebResourceResponse webResourceResponseShouldInterceptRequest = this.f266a.shouldInterceptRequest(this.f267b, new C0384e(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), zBooleanValue, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
        if (webResourceResponseShouldInterceptRequest == null) {
            return null;
        }
        android.webkit.WebResourceResponse webResourceResponse = new android.webkit.WebResourceResponse(webResourceResponseShouldInterceptRequest.getMimeType(), webResourceResponseShouldInterceptRequest.getEncoding(), webResourceResponseShouldInterceptRequest.getData());
        webResourceResponse.setResponseHeaders(webResourceResponseShouldInterceptRequest.getResponseHeaders());
        int statusCode = webResourceResponseShouldInterceptRequest.getStatusCode();
        String reasonPhrase = webResourceResponseShouldInterceptRequest.getReasonPhrase();
        if (statusCode != webResourceResponse.getStatusCode() || (reasonPhrase != null && !reasonPhrase.equals(webResourceResponse.getReasonPhrase()))) {
            webResourceResponse.setStatusCodeAndReasonPhrase(statusCode, reasonPhrase);
        }
        return webResourceResponse;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(11)
    public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, String str) {
        WebResourceResponse webResourceResponseShouldInterceptRequest;
        if (Build.VERSION.SDK_INT >= 11 && (webResourceResponseShouldInterceptRequest = this.f266a.shouldInterceptRequest(this.f267b, str)) != null) {
            return new android.webkit.WebResourceResponse(webResourceResponseShouldInterceptRequest.getMimeType(), webResourceResponseShouldInterceptRequest.getEncoding(), webResourceResponseShouldInterceptRequest.getData());
        }
        return null;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(android.webkit.WebView webView, KeyEvent keyEvent) {
        this.f267b.m280a(webView);
        return this.f266a.shouldOverrideKeyEvent(this.f267b, keyEvent);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003b  */
    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
        boolean zBooleanValue;
        String string = (webResourceRequest == null || webResourceRequest.getUrl() == null) ? null : webResourceRequest.getUrl().toString();
        if (string == null || this.f267b.showDebugView(string)) {
            return true;
        }
        this.f267b.m280a(webView);
        if (Build.VERSION.SDK_INT >= 24) {
            Object objM762a = C0453j.m762a(webResourceRequest, "isRedirect");
            if (objM762a instanceof Boolean) {
                zBooleanValue = ((Boolean) objM762a).booleanValue();
            } else {
                zBooleanValue = false;
            }
        } else {
            zBooleanValue = false;
        }
        return this.f266a.shouldOverrideUrlLoading(this.f267b, new C0384e(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), zBooleanValue, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, String str) {
        if (str == null || this.f267b.showDebugView(str)) {
            return true;
        }
        this.f267b.m280a(webView);
        return this.f266a.shouldOverrideUrlLoading(this.f267b, str);
    }
}
