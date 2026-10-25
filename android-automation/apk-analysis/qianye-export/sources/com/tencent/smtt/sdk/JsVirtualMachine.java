package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class JsVirtualMachine {

    /* JADX INFO: renamed from: a */
    private final Context f164a;

    /* JADX INFO: renamed from: b */
    private final IX5JsVirtualMachine f165b;

    /* JADX INFO: renamed from: c */
    private final HashSet<WeakReference<C0355a>> f166c;

    /* JADX INFO: renamed from: com.tencent.smtt.sdk.JsVirtualMachine$a */
    public static class C0355a implements IX5JsContext {

        /* JADX INFO: renamed from: a */
        private WebView f167a;

        public C0355a(Context context) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                WebView webView = new WebView(context);
                this.f167a = webView;
                webView.getSettings().setJavaScriptEnabled(true);
            } else {
                Log.e("JsContext", "in system core, JsContext can just in mainLooper, current looper is " + Looper.myLooper());
            }
        }

        /* JADX INFO: renamed from: a */
        public void m139a() {
            WebView webView = this.f167a;
            if (webView == null) {
                return;
            }
            webView.onPause();
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void addJavascriptInterface(Object obj, String str) {
            WebView webView = this.f167a;
            if (webView == null) {
                return;
            }
            webView.addJavascriptInterface(obj, str);
            this.f167a.loadUrl("about:blank");
        }

        /* JADX INFO: renamed from: b */
        public void m140b() {
            WebView webView = this.f167a;
            if (webView == null) {
                return;
            }
            webView.onResume();
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void destroy() {
            WebView webView = this.f167a;
            if (webView == null) {
                return;
            }
            webView.clearHistory();
            this.f167a.clearCache(true);
            this.f167a.loadUrl("about:blank");
            this.f167a.freeMemory();
            this.f167a.pauseTimers();
            this.f167a.destroy();
            this.f167a = null;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void evaluateJavascript(String str, final android.webkit.ValueCallback<String> valueCallback, URL url) {
            WebView webView = this.f167a;
            if (webView == null) {
                return;
            }
            webView.evaluateJavascript(str, valueCallback == null ? null : new ValueCallback<String>() { // from class: com.tencent.smtt.sdk.JsVirtualMachine.a.1
                @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onReceiveValue(String str2) {
                    valueCallback.onReceiveValue(str2);
                }
            });
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public IX5JsValue evaluateScript(String str, URL url) {
            WebView webView = this.f167a;
            if (webView == null) {
                return null;
            }
            webView.evaluateJavascript(str, null);
            return null;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void evaluateScriptAsync(String str, final android.webkit.ValueCallback<IX5JsValue> valueCallback, URL url) {
            WebView webView = this.f167a;
            if (webView == null) {
                return;
            }
            webView.evaluateJavascript(str, valueCallback == null ? null : new ValueCallback<String>() { // from class: com.tencent.smtt.sdk.JsVirtualMachine.a.2
                @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onReceiveValue(String str2) {
                    valueCallback.onReceiveValue(null);
                }
            });
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public byte[] getNativeBuffer(int i) {
            return null;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public int getNativeBufferId() {
            return -1;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void removeJavascriptInterface(String str) {
            WebView webView = this.f167a;
            if (webView == null) {
                return;
            }
            webView.removeJavascriptInterface(str);
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void setExceptionHandler(android.webkit.ValueCallback<IX5JsError> valueCallback) {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void setName(String str) {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public int setNativeBuffer(int i, byte[] bArr) {
            return -1;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void setPerContextData(Object obj) {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void stealValueFromOtherCtx(String str, IX5JsContext iX5JsContext, String str2) {
        }
    }

    public JsVirtualMachine(Context context) {
        this(context, null);
    }

    public JsVirtualMachine(Context context, Looper looper) {
        this.f166c = new HashSet<>();
        this.f164a = context;
        this.f165b = X5JsCore.m311a(context, looper);
    }

    /* JADX INFO: renamed from: a */
    public IX5JsContext m138a() {
        IX5JsVirtualMachine iX5JsVirtualMachine = this.f165b;
        if (iX5JsVirtualMachine != null) {
            return iX5JsVirtualMachine.createJsContext();
        }
        C0355a c0355a = new C0355a(this.f164a);
        this.f166c.add(new WeakReference<>(c0355a));
        return c0355a;
    }

    public void destroy() {
        IX5JsVirtualMachine iX5JsVirtualMachine = this.f165b;
        if (iX5JsVirtualMachine != null) {
            iX5JsVirtualMachine.destroy();
            return;
        }
        for (WeakReference<C0355a> weakReference : this.f166c) {
            if (weakReference.get() != null) {
                weakReference.get().destroy();
            }
        }
    }

    public Looper getLooper() {
        IX5JsVirtualMachine iX5JsVirtualMachine = this.f165b;
        return iX5JsVirtualMachine != null ? iX5JsVirtualMachine.getLooper() : Looper.myLooper();
    }

    public boolean isFallback() {
        return this.f165b == null;
    }

    public void onPause() {
        IX5JsVirtualMachine iX5JsVirtualMachine = this.f165b;
        if (iX5JsVirtualMachine != null) {
            iX5JsVirtualMachine.onPause();
            return;
        }
        for (WeakReference<C0355a> weakReference : this.f166c) {
            if (weakReference.get() != null) {
                weakReference.get().m139a();
            }
        }
    }

    public void onResume() {
        IX5JsVirtualMachine iX5JsVirtualMachine = this.f165b;
        if (iX5JsVirtualMachine != null) {
            iX5JsVirtualMachine.onResume();
            return;
        }
        for (WeakReference<C0355a> weakReference : this.f166c) {
            if (weakReference.get() != null) {
                weakReference.get().m140b();
            }
        }
    }
}
