package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class X5JsCore {

    /* JADX INFO: renamed from: a */
    private static EnumC0406a f493a;

    /* JADX INFO: renamed from: b */
    private static EnumC0406a f494b;

    /* JADX INFO: renamed from: c */
    private static EnumC0406a f495c;

    /* JADX INFO: renamed from: d */
    private final Context f496d;

    /* JADX INFO: renamed from: e */
    private Object f497e;

    /* JADX INFO: renamed from: f */
    private WebView f498f;

    /* JADX INFO: renamed from: com.tencent.smtt.sdk.X5JsCore$a */
    public enum EnumC0406a {
        UNINITIALIZED,
        UNAVAILABLE,
        AVAILABLE
    }

    static {
        EnumC0406a enumC0406a = EnumC0406a.UNINITIALIZED;
        f493a = enumC0406a;
        f494b = enumC0406a;
        f495c = enumC0406a;
    }

    @Deprecated
    public X5JsCore(Context context) {
        Object objM313a;
        this.f497e = null;
        this.f498f = null;
        this.f496d = context;
        if (canUseX5JsCore(context) && (objM313a = m313a("createX5JavaBridge", new Class[]{Context.class}, context)) != null) {
            this.f497e = objM313a;
            return;
        }
        Log.e("X5JsCore", "X5JsCore create X5JavaBridge failure, use fallback!");
        WebView webView = new WebView(context);
        this.f498f = webView;
        webView.getSettings().setJavaScriptEnabled(true);
    }

    /* JADX INFO: renamed from: a */
    public static IX5JsVirtualMachine m311a(Context context, Looper looper) {
        Object objM313a;
        if (canUseX5JsCore(context) && (objM313a = m313a("createX5JsVirtualMachine", new Class[]{Context.class, Looper.class}, context, looper)) != null) {
            return (IX5JsVirtualMachine) objM313a;
        }
        Log.e("X5JsCore", "X5JsCore#createVirtualMachine failure!");
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static Object m312a() {
        return m313a("currentContextData", new Class[0], new Object[0]);
    }

    /* JADX INFO: renamed from: a */
    private static Object m313a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            C0431u c0431uM530a = C0431u.m530a();
            if (c0431uM530a != null && c0431uM530a.m534b()) {
                return c0431uM530a.m535c().m558b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", str, clsArr, objArr);
            }
            Log.e("X5JsCore", "X5Jscore#" + str + " - x5CoreEngine is null or is not x5core.");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean canUseX5JsCore(Context context) {
        if (f493a != EnumC0406a.UNINITIALIZED) {
            return f493a == EnumC0406a.AVAILABLE;
        }
        f493a = EnumC0406a.UNAVAILABLE;
        Object objM313a = m313a("canUseX5JsCore", new Class[]{Context.class}, context);
        if (objM313a == null || !(objM313a instanceof Boolean) || !((Boolean) objM313a).booleanValue()) {
            return false;
        }
        m313a("setJsValueFactory", new Class[]{Object.class}, JsValue.m135a());
        f493a = EnumC0406a.AVAILABLE;
        return true;
    }

    public static boolean canUseX5JsCoreNewAPI(Context context) {
        if (f495c != EnumC0406a.UNINITIALIZED) {
            return f495c == EnumC0406a.AVAILABLE;
        }
        f495c = EnumC0406a.UNAVAILABLE;
        Object objM313a = m313a("canUseX5JsCoreNewAPI", new Class[]{Context.class}, context);
        if (objM313a == null || !(objM313a instanceof Boolean) || !((Boolean) objM313a).booleanValue()) {
            return false;
        }
        f495c = EnumC0406a.AVAILABLE;
        return true;
    }

    public static boolean canX5JsCoreUseNativeBuffer(Context context) {
        Object objM313a;
        if (f494b != EnumC0406a.UNINITIALIZED) {
            return f494b == EnumC0406a.AVAILABLE;
        }
        f494b = EnumC0406a.UNAVAILABLE;
        if (!canUseX5JsCore(context) || (objM313a = m313a("canX5JsCoreUseBuffer", new Class[]{Context.class}, context)) == null || !(objM313a instanceof Boolean) || !((Boolean) objM313a).booleanValue()) {
            return false;
        }
        f494b = EnumC0406a.AVAILABLE;
        return true;
    }

    @Deprecated
    public void addJavascriptInterface(Object obj, String str) {
        Object obj2 = this.f497e;
        if (obj2 != null) {
            m313a("addJavascriptInterface", new Class[]{Object.class, String.class, Object.class}, obj, str, obj2);
            return;
        }
        WebView webView = this.f498f;
        if (webView != null) {
            webView.addJavascriptInterface(obj, str);
            this.f498f.loadUrl("about:blank");
        }
    }

    @Deprecated
    public void destroy() {
        Object obj = this.f497e;
        if (obj != null) {
            m313a("destroyX5JsCore", new Class[]{Object.class}, obj);
            this.f497e = null;
            return;
        }
        WebView webView = this.f498f;
        if (webView != null) {
            webView.clearHistory();
            this.f498f.clearCache(true);
            this.f498f.loadUrl("about:blank");
            this.f498f.freeMemory();
            this.f498f.pauseTimers();
            this.f498f.destroy();
            this.f498f = null;
        }
    }

    @Deprecated
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        Object obj = this.f497e;
        if (obj != null) {
            m313a("evaluateJavascript", new Class[]{String.class, android.webkit.ValueCallback.class, Object.class}, str, valueCallback, obj);
            return;
        }
        WebView webView = this.f498f;
        if (webView != null) {
            webView.evaluateJavascript(str, valueCallback);
        }
    }

    @Deprecated
    public ByteBuffer getNativeBuffer(int i) {
        Object objM313a;
        if (this.f497e == null || !canX5JsCoreUseNativeBuffer(this.f496d) || (objM313a = m313a("getNativeBuffer", new Class[]{Object.class, Integer.TYPE}, this.f497e, Integer.valueOf(i))) == null || !(objM313a instanceof ByteBuffer)) {
            return null;
        }
        return (ByteBuffer) objM313a;
    }

    @Deprecated
    public int getNativeBufferId() {
        Object objM313a;
        if (this.f497e == null || !canX5JsCoreUseNativeBuffer(this.f496d) || (objM313a = m313a("getNativeBufferId", new Class[]{Object.class}, this.f497e)) == null || !(objM313a instanceof Integer)) {
            return -1;
        }
        return ((Integer) objM313a).intValue();
    }

    @Deprecated
    public void pause() {
        Object obj = this.f497e;
        if (obj != null) {
            m313a("pause", new Class[]{Object.class}, obj);
        }
    }

    @Deprecated
    public void pauseTimers() {
        Object obj = this.f497e;
        if (obj != null) {
            m313a("pauseTimers", new Class[]{Object.class}, obj);
        }
    }

    @Deprecated
    public void removeJavascriptInterface(String str) {
        Object obj = this.f497e;
        if (obj != null) {
            m313a("removeJavascriptInterface", new Class[]{String.class, Object.class}, str, obj);
            return;
        }
        WebView webView = this.f498f;
        if (webView != null) {
            webView.removeJavascriptInterface(str);
        }
    }

    @Deprecated
    public void resume() {
        Object obj = this.f497e;
        if (obj != null) {
            m313a("resume", new Class[]{Object.class}, obj);
        }
    }

    @Deprecated
    public void resumeTimers() {
        Object obj = this.f497e;
        if (obj != null) {
            m313a("resumeTimers", new Class[]{Object.class}, obj);
        }
    }

    @Deprecated
    public void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        if (this.f497e == null || !canX5JsCoreUseNativeBuffer(this.f496d)) {
            return;
        }
        m313a("setNativeBuffer", new Class[]{Object.class, Integer.TYPE, ByteBuffer.class}, this.f497e, Integer.valueOf(i), byteBuffer);
    }
}
