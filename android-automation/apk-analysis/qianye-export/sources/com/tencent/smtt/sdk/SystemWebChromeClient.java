package com.tencent.smtt.sdk;

import android.R;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.view.View;
import android.webkit.PermissionRequest;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebView.WebViewTransport;

/* JADX INFO: loaded from: classes.dex */
public class SystemWebChromeClient extends android.webkit.WebChromeClient {

    /* JADX INFO: renamed from: a */
    public WebChromeClient f234a;

    /* JADX INFO: renamed from: b */
    private WebView f235b;

    /* JADX INFO: renamed from: com.tencent.smtt.sdk.SystemWebChromeClient$a */
    public static class C0371a implements ConsoleMessage {

        /* JADX INFO: renamed from: a */
        private ConsoleMessage.MessageLevel f251a;

        /* JADX INFO: renamed from: b */
        private String f252b;

        /* JADX INFO: renamed from: c */
        private String f253c;

        /* JADX INFO: renamed from: d */
        private int f254d;

        public C0371a(android.webkit.ConsoleMessage consoleMessage) {
            this.f251a = ConsoleMessage.MessageLevel.valueOf(consoleMessage.messageLevel().name());
            this.f252b = consoleMessage.message();
            this.f253c = consoleMessage.sourceId();
            this.f254d = consoleMessage.lineNumber();
        }

        public C0371a(String str, String str2, int i) {
            this.f251a = ConsoleMessage.MessageLevel.LOG;
            this.f252b = str;
            this.f253c = str2;
            this.f254d = i;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public int lineNumber() {
            return this.f254d;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public String message() {
            return this.f252b;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public ConsoleMessage.MessageLevel messageLevel() {
            return this.f251a;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public String sourceId() {
            return this.f253c;
        }
    }

    /* JADX INFO: renamed from: com.tencent.smtt.sdk.SystemWebChromeClient$b */
    public class C0372b implements IX5WebChromeClient.CustomViewCallback {

        /* JADX INFO: renamed from: a */
        public android.webkit.WebChromeClient.CustomViewCallback f255a;

        public C0372b(android.webkit.WebChromeClient.CustomViewCallback customViewCallback) {
            this.f255a = customViewCallback;
        }

        @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback
        public void onCustomViewHidden() {
            this.f255a.onCustomViewHidden();
        }
    }

    /* JADX INFO: renamed from: com.tencent.smtt.sdk.SystemWebChromeClient$c */
    public class C0373c implements GeolocationPermissionsCallback {

        /* JADX INFO: renamed from: a */
        public android.webkit.GeolocationPermissions.Callback f257a;

        public C0373c(android.webkit.GeolocationPermissions.Callback callback) {
            this.f257a = callback;
        }

        @Override // com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback
        public void invoke(String str, boolean z, boolean z2) {
            this.f257a.invoke(str, z, z2);
        }
    }

    /* JADX INFO: renamed from: com.tencent.smtt.sdk.SystemWebChromeClient$d */
    public class C0374d implements JsPromptResult {

        /* JADX INFO: renamed from: a */
        public android.webkit.JsPromptResult f259a;

        public C0374d(android.webkit.JsPromptResult jsPromptResult) {
            this.f259a = jsPromptResult;
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void cancel() {
            this.f259a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void confirm() {
            this.f259a.confirm();
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsPromptResult
        public void confirm(String str) {
            this.f259a.confirm(str);
        }
    }

    /* JADX INFO: renamed from: com.tencent.smtt.sdk.SystemWebChromeClient$e */
    public class C0375e implements JsResult {

        /* JADX INFO: renamed from: a */
        public android.webkit.JsResult f261a;

        public C0375e(android.webkit.JsResult jsResult) {
            this.f261a = jsResult;
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void cancel() {
            this.f261a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void confirm() {
            this.f261a.confirm();
        }
    }

    /* JADX INFO: renamed from: com.tencent.smtt.sdk.SystemWebChromeClient$f */
    public class C0376f implements WebStorage.QuotaUpdater {

        /* JADX INFO: renamed from: a */
        public android.webkit.WebStorage.QuotaUpdater f263a;

        public C0376f(android.webkit.WebStorage.QuotaUpdater quotaUpdater) {
            this.f263a = quotaUpdater;
        }

        @Override // com.tencent.smtt.sdk.WebStorage.QuotaUpdater
        public void updateQuota(long j) {
            this.f263a.updateQuota(j);
        }
    }

    public SystemWebChromeClient(WebView webView, WebChromeClient webChromeClient) {
        this.f235b = webView;
        this.f234a = webChromeClient;
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public Bitmap getDefaultVideoPoster() {
        Bitmap defaultVideoPoster = this.f234a.getDefaultVideoPoster();
        if (defaultVideoPoster != null) {
            return defaultVideoPoster;
        }
        try {
            return Build.VERSION.SDK_INT >= 24 ? BitmapFactory.decodeResource(this.f235b.getResources(), R.drawable.ic_media_play) : defaultVideoPoster;
        } catch (Exception unused) {
            return defaultVideoPoster;
        }
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public View getVideoLoadingProgressView() {
        return this.f234a.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(final android.webkit.ValueCallback<String[]> valueCallback) {
        this.f234a.getVisitedHistory(new ValueCallback<String[]>() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.1
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String[] strArr) {
                valueCallback.onReceiveValue(strArr);
            }
        });
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(android.webkit.WebView webView) {
        this.f235b.m280a(webView);
        this.f234a.onCloseWindow(this.f235b);
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i, String str2) {
        this.f234a.onConsoleMessage(new C0371a(str, str2, i));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(android.webkit.ConsoleMessage consoleMessage) {
        return this.f234a.onConsoleMessage(new C0371a(consoleMessage));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(android.webkit.WebView webView, boolean z, boolean z2, final Message message) {
        WebView webView2 = this.f235b;
        webView2.getClass();
        final WebView.WebViewTransport webViewTransport = webView2.new WebViewTransport();
        Message messageObtain = Message.obtain(message.getTarget(), new Runnable() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.2
            @Override // java.lang.Runnable
            public void run() {
                WebView webView3 = webViewTransport.getWebView();
                if (webView3 != null) {
                    ((android.webkit.WebView.WebViewTransport) message.obj).setWebView(webView3.m279a());
                }
                message.sendToTarget();
            }
        });
        messageObtain.obj = webViewTransport;
        return this.f234a.onCreateWindow(this.f235b, z, z2, messageObtain);
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(5)
    @Deprecated
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, android.webkit.WebStorage.QuotaUpdater quotaUpdater) {
        this.f234a.onExceededDatabaseQuota(str, str2, j, j2, j3, new C0376f(quotaUpdater));
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(5)
    public void onGeolocationPermissionsHidePrompt() {
        this.f234a.onGeolocationPermissionsHidePrompt();
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(5)
    public void onGeolocationPermissionsShowPrompt(String str, android.webkit.GeolocationPermissions.Callback callback) {
        this.f234a.onGeolocationPermissionsShowPrompt(str, new C0373c(callback));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(android.webkit.WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        this.f235b.m280a(webView);
        return this.f234a.onJsAlert(this.f235b, str, str2, new C0375e(jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(android.webkit.WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        this.f235b.m280a(webView);
        return this.f234a.onJsBeforeUnload(this.f235b, str, str2, new C0375e(jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(android.webkit.WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        this.f235b.m280a(webView);
        return this.f234a.onJsConfirm(this.f235b, str, str2, new C0375e(jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(android.webkit.WebView webView, String str, String str2, String str3, android.webkit.JsPromptResult jsPromptResult) {
        this.f235b.m280a(webView);
        return this.f234a.onJsPrompt(this.f235b, str, str2, str3, new C0374d(jsPromptResult));
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public boolean onJsTimeout() {
        return this.f234a.onJsTimeout();
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(final PermissionRequest permissionRequest) {
        this.f234a.onPermissionRequest(new com.tencent.smtt.export.external.interfaces.PermissionRequest() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.6
            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public void deny() {
                if (Build.VERSION.SDK_INT >= 21) {
                    permissionRequest.deny();
                }
            }

            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public Uri getOrigin() {
                if (Build.VERSION.SDK_INT >= 21) {
                    return permissionRequest.getOrigin();
                }
                return null;
            }

            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public String[] getResources() {
                return Build.VERSION.SDK_INT >= 21 ? permissionRequest.getResources() : new String[0];
            }

            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public void grant(String[] strArr) {
                if (Build.VERSION.SDK_INT >= 21) {
                    permissionRequest.grant(strArr);
                }
            }
        });
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequestCanceled(final PermissionRequest permissionRequest) {
        this.f234a.onPermissionRequestCanceled(new com.tencent.smtt.export.external.interfaces.PermissionRequest() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.7
            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public void deny() {
                if (Build.VERSION.SDK_INT >= 21) {
                    permissionRequest.deny();
                }
            }

            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public Uri getOrigin() {
                if (Build.VERSION.SDK_INT >= 21) {
                    return permissionRequest.getOrigin();
                }
                return null;
            }

            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public String[] getResources() {
                return Build.VERSION.SDK_INT >= 21 ? permissionRequest.getResources() : new String[0];
            }

            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public void grant(String[] strArr) {
                if (Build.VERSION.SDK_INT >= 21) {
                    permissionRequest.grant(strArr);
                }
            }
        });
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(android.webkit.WebView webView, int i) {
        this.f235b.m280a(webView);
        this.f234a.onProgressChanged(this.f235b, i);
    }

    @TargetApi(7)
    @Deprecated
    public void onReachedMaxAppCacheSize(long j, long j2, android.webkit.WebStorage.QuotaUpdater quotaUpdater) {
        this.f234a.onReachedMaxAppCacheSize(j, j2, new C0376f(quotaUpdater));
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(android.webkit.WebView webView, Bitmap bitmap) {
        this.f235b.m280a(webView);
        this.f234a.onReceivedIcon(this.f235b, bitmap);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(android.webkit.WebView webView, String str) {
        this.f235b.m280a(webView);
        this.f234a.onReceivedTitle(this.f235b, str);
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public void onReceivedTouchIconUrl(android.webkit.WebView webView, String str, boolean z) {
        this.f235b.m280a(webView);
        this.f234a.onReceivedTouchIconUrl(this.f235b, str, z);
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(android.webkit.WebView webView) {
        this.f235b.m280a(webView);
        this.f234a.onRequestFocus(this.f235b);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(android.webkit.WebView webView, final android.webkit.ValueCallback<Uri[]> valueCallback, final android.webkit.WebChromeClient.FileChooserParams fileChooserParams) {
        ValueCallback<Uri[]> valueCallback2 = new ValueCallback<Uri[]>() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.4
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(Uri[] uriArr) {
                valueCallback.onReceiveValue(uriArr);
            }
        };
        WebChromeClient.FileChooserParams fileChooserParams2 = new WebChromeClient.FileChooserParams() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.5
            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public Intent createIntent() {
                return fileChooserParams.createIntent();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public String[] getAcceptTypes() {
                return fileChooserParams.getAcceptTypes();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public String getFilenameHint() {
                return fileChooserParams.getFilenameHint();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public int getMode() {
                return fileChooserParams.getMode();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public CharSequence getTitle() {
                return fileChooserParams.getTitle();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public boolean isCaptureEnabled() {
                return fileChooserParams.isCaptureEnabled();
            }
        };
        this.f235b.m280a(webView);
        return this.f234a.onShowFileChooser(this.f235b, valueCallback2, fileChooserParams2);
    }

    public void openFileChooser(android.webkit.ValueCallback<Uri> valueCallback) {
        openFileChooser(valueCallback, null, null);
    }

    public void openFileChooser(android.webkit.ValueCallback<Uri> valueCallback, String str) {
        openFileChooser(valueCallback, str, null);
    }

    public void openFileChooser(final android.webkit.ValueCallback<Uri> valueCallback, String str, String str2) {
        this.f234a.openFileChooser(new ValueCallback<Uri>() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.3
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(Uri uri) {
                valueCallback.onReceiveValue(uri);
            }
        }, str, str2);
    }

    public void setupAutoFill(Message message) {
    }
}
