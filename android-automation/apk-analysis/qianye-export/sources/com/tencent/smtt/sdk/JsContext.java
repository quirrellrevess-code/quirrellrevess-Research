package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public final class JsContext {

    /* JADX INFO: renamed from: a */
    private final JsVirtualMachine f154a;

    /* JADX INFO: renamed from: b */
    private final IX5JsContext f155b;

    /* JADX INFO: renamed from: c */
    private ExceptionHandler f156c;

    /* JADX INFO: renamed from: d */
    private String f157d;

    public interface ExceptionHandler {
        void handleException(JsContext jsContext, JsError jsError);
    }

    public JsContext(Context context) {
        this(new JsVirtualMachine(context));
    }

    public JsContext(JsVirtualMachine jsVirtualMachine) {
        if (jsVirtualMachine == null) {
            throw new IllegalArgumentException("The virtualMachine value can not be null");
        }
        this.f154a = jsVirtualMachine;
        IX5JsContext iX5JsContextM138a = jsVirtualMachine.m138a();
        this.f155b = iX5JsContextM138a;
        try {
            iX5JsContextM138a.setPerContextData(this);
        } catch (AbstractMethodError unused) {
        }
    }

    public static JsContext current() {
        return (JsContext) X5JsCore.m312a();
    }

    public void addJavascriptInterface(Object obj, String str) {
        this.f155b.addJavascriptInterface(obj, str);
    }

    public void destroy() {
        this.f155b.destroy();
    }

    public void evaluateJavascript(String str, android.webkit.ValueCallback<String> valueCallback) {
        evaluateJavascript(str, valueCallback, null);
    }

    public void evaluateJavascript(String str, android.webkit.ValueCallback<String> valueCallback, URL url) {
        this.f155b.evaluateJavascript(str, valueCallback, url);
    }

    public JsValue evaluateScript(String str) {
        return evaluateScript(str, null);
    }

    public JsValue evaluateScript(String str, URL url) {
        IX5JsValue iX5JsValueEvaluateScript = this.f155b.evaluateScript(str, url);
        if (iX5JsValueEvaluateScript == null) {
            return null;
        }
        return new JsValue(this, iX5JsValueEvaluateScript);
    }

    public void evaluateScriptAsync(String str, final android.webkit.ValueCallback<JsValue> valueCallback, URL url) {
        this.f155b.evaluateScriptAsync(str, valueCallback == null ? null : new android.webkit.ValueCallback<IX5JsValue>() { // from class: com.tencent.smtt.sdk.JsContext.1
            @Override // android.webkit.ValueCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(IX5JsValue iX5JsValue) {
                valueCallback.onReceiveValue(iX5JsValue == null ? null : new JsValue(JsContext.this, iX5JsValue));
            }
        }, url);
    }

    public ExceptionHandler exceptionHandler() {
        return this.f156c;
    }

    public byte[] getNativeBuffer(int i) {
        return this.f155b.getNativeBuffer(i);
    }

    public int getNativeBufferId() {
        return this.f155b.getNativeBufferId();
    }

    public String name() {
        return this.f157d;
    }

    public void removeJavascriptInterface(String str) {
        this.f155b.removeJavascriptInterface(str);
    }

    public void setExceptionHandler(ExceptionHandler exceptionHandler) {
        IX5JsContext iX5JsContext;
        android.webkit.ValueCallback<IX5JsError> valueCallback;
        this.f156c = exceptionHandler;
        if (exceptionHandler == null) {
            iX5JsContext = this.f155b;
            valueCallback = null;
        } else {
            iX5JsContext = this.f155b;
            valueCallback = new android.webkit.ValueCallback<IX5JsError>() { // from class: com.tencent.smtt.sdk.JsContext.2
                @Override // android.webkit.ValueCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onReceiveValue(IX5JsError iX5JsError) {
                    JsContext.this.f156c.handleException(JsContext.this, new JsError(iX5JsError));
                }
            };
        }
        iX5JsContext.setExceptionHandler(valueCallback);
    }

    public void setName(String str) {
        this.f157d = str;
        this.f155b.setName(str);
    }

    public int setNativeBuffer(int i, byte[] bArr) {
        return this.f155b.setNativeBuffer(i, bArr);
    }

    public void stealValueFromOtherCtx(String str, JsContext jsContext, String str2) {
        this.f155b.stealValueFromOtherCtx(str, jsContext.f155b, str2);
    }

    public JsVirtualMachine virtualMachine() {
        return this.f154a;
    }
}
