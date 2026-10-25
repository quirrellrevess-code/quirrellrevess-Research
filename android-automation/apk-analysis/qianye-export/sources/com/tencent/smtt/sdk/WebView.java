package com.tencent.smtt.sdk;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.flexbox.BuildConfig;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.extension.proxy.X5ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.stat.C0429b;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.utils.C0447d;
import com.tencent.smtt.utils.C0453j;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedWriter;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class WebView extends FrameLayout implements View.OnLongClickListener {
    public static int NIGHT_MODE_ALPHA = 153;
    public static final int NIGHT_MODE_COLOR = -16777216;
    public static final int NORMAL_MODE_ALPHA = 255;
    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_TEL = "tel:";

    /* JADX INFO: renamed from: i */
    private static Context f422i = null;

    /* JADX INFO: renamed from: l */
    private static Method f423l = null;
    public static boolean mSysWebviewCreated = false;
    public static boolean mWebViewCreated = false;

    /* JADX INFO: renamed from: o */
    private static String f424o = null;

    /* JADX INFO: renamed from: u */
    private static Paint f425u = null;

    /* JADX INFO: renamed from: v */
    private static boolean f426v = true;

    /* JADX INFO: renamed from: a */
    public volatile int f427a;

    /* JADX INFO: renamed from: b */
    private final String f428b;

    /* JADX INFO: renamed from: c */
    private boolean f429c;

    /* JADX INFO: renamed from: d */
    private IX5WebViewBase f430d;

    /* JADX INFO: renamed from: e */
    private C0404a f431e;

    /* JADX INFO: renamed from: f */
    private WebSettings f432f;

    /* JADX INFO: renamed from: g */
    private Context f433g;

    /* JADX INFO: renamed from: h */
    private TbsWebViewPerformanceRecorder f434h;

    /* JADX INFO: renamed from: j */
    private volatile boolean f435j;

    /* JADX INFO: renamed from: k */
    private boolean f436k;

    /* JADX INFO: renamed from: m */
    private WebViewClient f437m;
    public WebViewCallbackClient mWebViewCallbackClient;

    /* JADX INFO: renamed from: n */
    private WebChromeClient f438n;

    /* JADX INFO: renamed from: p */
    private final int f439p;

    /* JADX INFO: renamed from: q */
    private final int f440q;

    /* JADX INFO: renamed from: r */
    private final int f441r;

    /* JADX INFO: renamed from: s */
    private final String f442s;

    /* JADX INFO: renamed from: t */
    private final String f443t;

    /* JADX INFO: renamed from: w */
    private Object f444w;

    /* JADX INFO: renamed from: x */
    private View.OnLongClickListener f445x;

    public static class HitTestResult {

        @Deprecated
        public static final int ANCHOR_TYPE = 1;
        public static final int EDIT_TEXT_TYPE = 9;
        public static final int EMAIL_TYPE = 4;
        public static final int GEO_TYPE = 3;

        @Deprecated
        public static final int IMAGE_ANCHOR_TYPE = 6;
        public static final int IMAGE_TYPE = 5;
        public static final int PHONE_TYPE = 2;
        public static final int SRC_ANCHOR_TYPE = 7;
        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        public static final int UNKNOWN_TYPE = 0;

        /* JADX INFO: renamed from: a */
        private IX5WebViewBase.HitTestResult f457a;

        /* JADX INFO: renamed from: b */
        private android.webkit.WebView.HitTestResult f458b;

        public HitTestResult() {
            this.f458b = null;
            this.f457a = null;
            this.f458b = null;
        }

        public HitTestResult(android.webkit.WebView.HitTestResult hitTestResult) {
            this.f458b = null;
            this.f457a = null;
            this.f458b = hitTestResult;
        }

        public HitTestResult(IX5WebViewBase.HitTestResult hitTestResult) {
            this.f458b = null;
            this.f457a = hitTestResult;
            this.f458b = null;
        }

        public String getExtra() {
            IX5WebViewBase.HitTestResult hitTestResult = this.f457a;
            if (hitTestResult != null) {
                return hitTestResult.getExtra();
            }
            android.webkit.WebView.HitTestResult hitTestResult2 = this.f458b;
            return hitTestResult2 != null ? hitTestResult2.getExtra() : BuildConfig.FLAVOR;
        }

        public int getType() {
            IX5WebViewBase.HitTestResult hitTestResult = this.f457a;
            if (hitTestResult != null) {
                return hitTestResult.getType();
            }
            android.webkit.WebView.HitTestResult hitTestResult2 = this.f458b;
            if (hitTestResult2 != null) {
                return hitTestResult2.getType();
            }
            return 0;
        }
    }

    @Deprecated
    public interface PictureListener {
        @Deprecated
        void onNewPicture(WebView webView, Picture picture);
    }

    public class WebViewTransport {

        /* JADX INFO: renamed from: b */
        private WebView f460b;

        public WebViewTransport() {
        }

        public synchronized WebView getWebView() {
            return this.f460b;
        }

        public synchronized void setWebView(WebView webView) {
            this.f460b = webView;
        }
    }

    /* JADX INFO: renamed from: com.tencent.smtt.sdk.WebView$a */
    public class C0404a extends android.webkit.WebView {
        public C0404a(WebView webView, Context context) {
            this(context, null);
        }

        public C0404a(Context context, AttributeSet attributeSet) {
            super(WebView.this.m267c(context), attributeSet);
            WebView.mSysWebviewCreated = true;
            if (QbSdk.getIsSysWebViewForcedByOuter() && TbsShareManager.isThirdPartyApp(context)) {
                return;
            }
            CookieSyncManager.createInstance(WebView.this.f433g).startSync();
            try {
                Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
                declaredMethod.setAccessible(true);
                ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new C0413g());
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: renamed from: a */
        public void m283a() {
            super.computeScroll();
        }

        /* JADX INFO: renamed from: a */
        public void m284a(int i, int i2, int i3, int i4) {
            super.onScrollChanged(i, i2, i3, i4);
        }

        @TargetApi(9)
        /* JADX INFO: renamed from: a */
        public void m285a(int i, int i2, boolean z, boolean z2) {
            if (Build.VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i, i2, z, z2);
            }
        }

        @TargetApi(9)
        /* JADX INFO: renamed from: a */
        public boolean m286a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            if (Build.VERSION.SDK_INT >= 9) {
                return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            }
            return false;
        }

        /* JADX INFO: renamed from: a */
        public boolean m287a(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        /* JADX INFO: renamed from: b */
        public boolean m288b(MotionEvent motionEvent) {
            return super.dispatchTouchEvent(motionEvent);
        }

        /* JADX INFO: renamed from: c */
        public boolean m289c(MotionEvent motionEvent) {
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.webkit.WebView, android.view.View
        public void computeScroll() {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                webViewCallbackClient.computeScroll(this);
            } else {
                super.computeScroll();
            }
        }

        @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas canvas) {
            try {
                super.dispatchDraw(canvas);
                if (WebView.f426v || WebView.f425u == null) {
                    return;
                }
                canvas.save();
                canvas.drawPaint(WebView.f425u);
                canvas.restore();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            return webViewCallbackClient != null ? webViewCallbackClient.dispatchTouchEvent(motionEvent, this) : super.dispatchTouchEvent(motionEvent);
        }

        @Override // android.webkit.WebView
        public android.webkit.WebSettings getSettings() {
            try {
                return super.getSettings();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // android.view.View
        public void invalidate() {
            super.invalidate();
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                webViewCallbackClient.invalidate();
            }
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            return webViewCallbackClient != null ? webViewCallbackClient.onInterceptTouchEvent(motionEvent, this) : super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.webkit.WebView, android.view.View
        @TargetApi(9)
        public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                webViewCallbackClient.onOverScrolled(i, i2, z, z2, this);
            } else if (Build.VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i, i2, z, z2);
            }
        }

        @Override // android.webkit.WebView, android.view.View
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                webViewCallbackClient.onScrollChanged(i, i2, i3, i4, this);
            } else {
                super.onScrollChanged(i, i2, i3, i4);
                WebView.this.onScrollChanged(i, i2, i3, i4);
            }
        }

        @Override // android.webkit.WebView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!hasFocus()) {
                requestFocus();
            }
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                return webViewCallbackClient.onTouchEvent(motionEvent, this);
            }
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }

        @Override // android.view.View
        @TargetApi(9)
        public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                return webViewCallbackClient.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z, this);
            }
            if (Build.VERSION.SDK_INT >= 9) {
                return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            }
            return false;
        }

        @Override // android.webkit.WebView, android.view.View
        public void setOverScrollMode(int i) {
            try {
                super.setOverScrollMode(i);
            } catch (Exception unused) {
            }
        }
    }

    public WebView(Context context) {
        this(context, (AttributeSet) null);
    }

    public WebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, false);
    }

    @TargetApi(11)
    public WebView(Context context, AttributeSet attributeSet, int i, Map<String, Object> map, boolean z) {
        super(context, attributeSet, i);
        this.f428b = "WebView";
        this.f429c = false;
        this.f432f = null;
        this.f433g = null;
        this.f434h = new TbsWebViewPerformanceRecorder();
        this.f427a = 0;
        this.f435j = false;
        this.f436k = false;
        this.f437m = null;
        this.f438n = null;
        this.f439p = 1;
        this.f440q = 2;
        this.f441r = 3;
        this.f442s = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        this.f443t = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        this.f444w = null;
        this.f445x = null;
        long jCurrentTimeMillis = System.currentTimeMillis();
        mWebViewCreated = true;
        if (QbSdk.getIsSysWebViewForcedByOuter() && TbsShareManager.isThirdPartyApp(context)) {
            this.f433g = context;
            this.f430d = null;
            this.f429c = false;
            QbSdk.m149a(context, "failed to createTBSWebview!");
            this.f431e = new C0404a(context, attributeSet);
            CookieSyncManager.createInstance(this.f433g).startSync();
            try {
                Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
                declaredMethod.setAccessible(true);
                ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new C0413g());
            } catch (Exception unused) {
            }
            CookieManager.getInstance().m129a();
            this.f431e.setFocusableInTouchMode(true);
            addView(this.f431e, new FrameLayout.LayoutParams(-1, -1));
            TbsLog.m665i("WebView", "SystemWebView Created Success! #3, SysWebViewForcedByOuter.");
            TbsLog.m664e("WebView", "sys WebView: IsSysWebViewForcedByOuter = true", true);
        } else {
            if (TbsShareManager.isThirdPartyApp(context)) {
                TbsLog.m665i("webview", "new WebView, thread is " + Thread.currentThread() + "stack: " + Log.getStackTraceString(new Throwable("new WebView Detect")));
            }
            TbsLog.initIfNeed(context);
            if (context == null) {
                throw new IllegalArgumentException("Invalid context argument");
            }
            m263b(context);
            this.f433g = context;
            if (context != null) {
                f422i = context.getApplicationContext();
            }
            if (!this.f429c || QbSdk.f196a) {
                this.f430d = null;
                if (TbsShareManager.isThirdPartyApp(this.f433g)) {
                    this.f431e = new C0404a(context, attributeSet);
                } else {
                    this.f431e = new C0404a(this, context);
                }
                TbsLog.m665i("WebView", "SystemWebView Created Success! #2");
                CookieManager.getInstance().m129a();
                this.f431e.setFocusableInTouchMode(true);
                addView(this.f431e, new FrameLayout.LayoutParams(-1, -1));
                setDownloadListener(null);
                TbsLog.writeLogToDisk();
                C0419m.m395a(context);
            } else {
                IX5WebViewBase iX5WebViewBaseM544a = C0431u.m530a().m531a(true).m544a(context);
                this.f430d = iX5WebViewBaseM544a;
                if (iX5WebViewBaseM544a == null || iX5WebViewBaseM544a.getView() == null) {
                    TbsLog.m664e("WebView", "sys WebView: failed to createTBSWebview", true);
                    this.f430d = null;
                    this.f429c = false;
                    QbSdk.m149a(context, "failed to createTBSWebview!");
                    m263b(context);
                    if (TbsShareManager.isThirdPartyApp(this.f433g)) {
                        this.f431e = new C0404a(context, attributeSet);
                    } else {
                        this.f431e = new C0404a(this, context);
                    }
                    TbsLog.m665i("WebView", "SystemWebView Created Success! #1");
                    CookieManager.getInstance().m129a();
                    this.f431e.setFocusableInTouchMode(true);
                    addView(this.f431e, new FrameLayout.LayoutParams(-1, -1));
                    try {
                        if (Build.VERSION.SDK_INT >= 11) {
                            removeJavascriptInterface("searchBoxJavaBridge_");
                            removeJavascriptInterface("accessibility");
                            removeJavascriptInterface("accessibilityTraversal");
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    TbsLog.writeLogToDisk();
                    C0419m.m395a(context);
                } else {
                    TbsLog.m665i("WebView", "X5 WebView Created Success!!");
                    this.f430d.getView().setFocusableInTouchMode(true);
                    m256a(attributeSet);
                    addView(this.f430d.getView(), new FrameLayout.LayoutParams(-1, -1));
                    this.f430d.setDownloadListener(new C0408b(this, null, this.f429c));
                    this.f430d.getX5WebViewExtension().setWebViewClientExtension(new X5ProxyWebViewClientExtension(C0431u.m530a().m531a(true).m588k()) { // from class: com.tencent.smtt.sdk.WebView.1
                        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
                        public void invalidate() {
                        }

                        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
                        public void onScrollChanged(int i2, int i3, int i4, int i5) {
                            super.onScrollChanged(i2, i3, i4, i5);
                            WebView.this.onScrollChanged(i4, i5, i2, i3);
                        }
                    });
                }
            }
            try {
                if (Build.VERSION.SDK_INT >= 11) {
                    removeJavascriptInterface("searchBoxJavaBridge_");
                    removeJavascriptInterface("accessibility");
                    removeJavascriptInterface("accessibilityTraversal");
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            if ((TbsConfig.APP_QQ.equals(this.f433g.getApplicationInfo().packageName) || TbsConfig.APP_WX.equals(this.f433g.getApplicationInfo().packageName)) && C0412f.m323a(true).m338i() && Build.VERSION.SDK_INT >= 11) {
                setLayerType(1, null);
            }
            if (this.f430d != null) {
                TbsLog.writeLogToDisk();
            }
        }
        this.f434h.m244a(System.currentTimeMillis() - jCurrentTimeMillis);
    }

    @Deprecated
    public WebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        this(context, attributeSet, i, null, z);
    }

    @Deprecated
    public WebView(Context context, boolean z) {
        super(context);
        this.f428b = "WebView";
        this.f429c = false;
        this.f432f = null;
        this.f433g = null;
        this.f434h = new TbsWebViewPerformanceRecorder();
        this.f427a = 0;
        this.f435j = false;
        this.f436k = false;
        this.f437m = null;
        this.f438n = null;
        this.f439p = 1;
        this.f440q = 2;
        this.f441r = 3;
        this.f442s = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        this.f443t = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        this.f444w = null;
        this.f445x = null;
    }

    /* JADX INFO: renamed from: a */
    private void m256a(AttributeSet attributeSet) {
        View view;
        if (attributeSet != null) {
            try {
                int attributeCount = attributeSet.getAttributeCount();
                for (int i = 0; i < attributeCount; i++) {
                    if (attributeSet.getAttributeName(i).equalsIgnoreCase("scrollbars")) {
                        int[] intArray = getResources().getIntArray(R.attr.scrollbars);
                        int attributeIntValue = attributeSet.getAttributeIntValue(i, -1);
                        if (attributeIntValue == intArray[1]) {
                            this.f430d.getView().setVerticalScrollBarEnabled(false);
                            view = this.f430d.getView();
                        } else if (attributeIntValue == intArray[2]) {
                            this.f430d.getView().setVerticalScrollBarEnabled(false);
                        } else if (attributeIntValue == intArray[3]) {
                            view = this.f430d.getView();
                        }
                        view.setHorizontalScrollBarEnabled(false);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m259a(boolean z) {
        if (!this.f435j && this.f427a != 0) {
            m278j();
        }
        if (!this.f429c) {
            try {
                Class<?> cls = Class.forName("android.webkit.WebViewClassic");
                Method method = cls.getMethod("fromWebView", android.webkit.WebView.class);
                method.setAccessible(true);
                Object objInvoke = method.invoke(null, this.f431e);
                if (objInvoke != null) {
                    Field declaredField = cls.getDeclaredField("mListBoxDialog");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(objInvoke);
                    if (obj != null) {
                        Dialog dialog = (Dialog) obj;
                        dialog.setOnCancelListener(null);
                        Class<?> cls2 = Class.forName("android.app.Dialog");
                        Field declaredField2 = cls2.getDeclaredField("CANCEL");
                        declaredField2.setAccessible(true);
                        int iIntValue = ((Integer) declaredField2.get(dialog)).intValue();
                        Field declaredField3 = cls2.getDeclaredField("mListenersHandler");
                        declaredField3.setAccessible(true);
                        ((Handler) declaredField3.get(dialog)).removeMessages(iIntValue);
                    }
                }
            } catch (Exception unused) {
            }
            if (z) {
                this.f431e.destroy();
            }
            try {
                TbsLog.m665i("sdkreport", "webview.tbsWebviewDestroy mQQMusicCrashFix is " + this.f436k);
                if (this.f436k) {
                    return;
                }
                Field declaredField4 = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
                declaredField4.setAccessible(true);
                ComponentCallbacks componentCallbacks = (ComponentCallbacks) declaredField4.get(null);
                if (componentCallbacks != null) {
                    declaredField4.set(null, null);
                    Field declaredField5 = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
                    declaredField5.setAccessible(true);
                    Object obj2 = declaredField5.get(null);
                    if (obj2 != null) {
                        List list = (List) obj2;
                        synchronized (list) {
                            list.remove(componentCallbacks);
                        }
                    }
                }
            } catch (Exception unused2) {
            }
        } else if (z) {
            this.f430d.destroy();
        }
        TbsLog.m665i("WebView", "X5 GUID = " + QbSdk.m155b());
    }

    /* JADX INFO: renamed from: a */
    private boolean m260a(Context context) {
        try {
            return context.getPackageName().indexOf(TbsConfig.APP_QQ) >= 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m261a(View view) {
        Object objM763a;
        Context context = this.f433g;
        if ((context == null || getTbsCoreVersion(context) <= 36200) && (objM763a = C0453j.m763a(this.f444w, "onLongClick", (Class<?>[]) new Class[]{View.class}, view)) != null) {
            return ((Boolean) objM763a).booleanValue();
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private boolean m262a(WebChromeClient webChromeClient) {
        if (webChromeClient == null) {
            return false;
        }
        boolean z = false;
        boolean z2 = false;
        for (Class<?> superclass = webChromeClient.getClass(); superclass != WebChromeClient.class && (!z || !z2); superclass = superclass.getSuperclass()) {
            if (!z) {
                try {
                    superclass.getDeclaredMethod("onShowCustomView", View.class, IX5WebChromeClient.CustomViewCallback.class);
                    z = true;
                } catch (NoSuchMethodException unused) {
                }
            }
            if (!z2) {
                try {
                    superclass.getDeclaredMethod("onHideCustomView", new Class[0]);
                    z2 = true;
                } catch (NoSuchMethodException unused2) {
                }
            }
        }
        return z && z2;
    }

    /* JADX INFO: renamed from: b */
    private void m263b(Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        C0431u c0431uM530a = C0431u.m530a();
        c0431uM530a.m532a(context);
        this.f434h.m246b(System.currentTimeMillis() - jCurrentTimeMillis);
        this.f429c = c0431uM530a.m534b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public Context m267c(Context context) {
        int i = Build.VERSION.SDK_INT;
        return (i < 21 || i > 22) ? context : context.createConfigurationContext(new Configuration());
    }

    /* JADX INFO: renamed from: c */
    public static void m268c() {
        try {
            new Thread(new Runnable() { // from class: com.tencent.smtt.sdk.WebView.8
                @Override // java.lang.Runnable
                public void run() {
                    if (WebView.f422i == null) {
                        TbsLog.m659d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
                        return;
                    }
                    C0412f c0412fM323a = C0412f.m323a(true);
                    if (C0412f.f513b) {
                        TbsLog.m659d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
                        return;
                    }
                    C0418l c0418lM374a = C0418l.m374a(WebView.f422i);
                    int iM386c = c0418lM374a.m386c();
                    TbsLog.m659d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = " + iM386c);
                    if (iM386c == 2) {
                        TbsLog.m659d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
                        c0412fM323a.m330a(String.valueOf(c0418lM374a.m382b()));
                        c0412fM323a.m332b(true);
                        return;
                    }
                    int iM383b = c0418lM374a.m383b("copy_status");
                    TbsLog.m659d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = " + iM383b);
                    if (iM383b == 1) {
                        TbsLog.m659d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
                        c0412fM323a.m330a(String.valueOf(c0418lM374a.m387c("copy_core_ver")));
                        c0412fM323a.m332b(true);
                    } else {
                        if (C0431u.m530a().m534b()) {
                            return;
                        }
                        if (iM386c == 3 || iM383b == 3) {
                            TbsLog.m659d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
                            c0412fM323a.m330a(String.valueOf(C0412f.m326d()));
                            c0412fM323a.m332b(true);
                        }
                    }
                }
            }).start();
        } catch (Throwable th) {
            TbsLog.m662e("webview", "updateRebootStatus excpetion: " + th);
        }
    }

    @Deprecated
    public static void disablePlatformNotifications() {
        if (C0431u.m530a().m534b()) {
            return;
        }
        C0453j.m764a("android.webkit.WebView", "disablePlatformNotifications");
    }

    @Deprecated
    public static void enablePlatformNotifications() {
        if (C0431u.m530a().m534b()) {
            return;
        }
        C0453j.m764a("android.webkit.WebView", "enablePlatformNotifications");
    }

    @Deprecated
    public static String findAddress(String str) {
        if (C0431u.m530a().m534b()) {
            return null;
        }
        return android.webkit.WebView.findAddress(str);
    }

    /* JADX INFO: renamed from: g */
    private void m275g() {
        if (!this.f435j && this.f427a != 0) {
            m278j();
        }
        if (this.f429c) {
            this.f430d.destroy();
            return;
        }
        this.f431e.destroy();
        try {
            TbsLog.m665i("sdkreport", "webview.destroyImplNow mQQMusicCrashFix is " + this.f436k);
            if (this.f436k) {
                return;
            }
            Field declaredField = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
            declaredField.setAccessible(true);
            ComponentCallbacks componentCallbacks = (ComponentCallbacks) declaredField.get(null);
            if (componentCallbacks != null) {
                declaredField.set(null, null);
                Field declaredField2 = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
                declaredField2.setAccessible(true);
                Object obj = declaredField2.get(null);
                if (obj != null) {
                    List list = (List) obj;
                    synchronized (list) {
                        try {
                            list.remove(componentCallbacks);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static String getCrashExtraCacheInfo(Context context) {
        Map<String, Object> map;
        if (context == null) {
            return BuildConfig.FLAVOR;
        }
        String str = "tbs_core_version:" + QbSdk.getTbsVersionForCrash(context) + ";tbs_sdk_version:44286;";
        StringBuilder sb = new StringBuilder();
        sb.append(C0412f.m323a(true).m335f());
        sb.append("\n");
        sb.append(str);
        if (!TbsShareManager.isThirdPartyApp(context) && (map = QbSdk.f210o) != null && map.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) && QbSdk.f210o.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY)) {
            String str2 = "weapp_id:" + QbSdk.f210o.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) + ";" + TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY + ":" + QbSdk.f210o.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY) + ";";
            sb.append("\n");
            sb.append(str2);
        }
        return sb.length() > 8192 ? sb.substring(sb.length() - 8192) : sb.toString();
    }

    public static String getCrashExtraMessage(Context context) {
        Map<String, Object> map;
        if (context == null) {
            return BuildConfig.FLAVOR;
        }
        String str = "tbs_core_version:" + QbSdk.getTbsVersionForCrash(context) + ";tbs_sdk_version:44286;";
        StringBuilder sb = new StringBuilder();
        sb.append(C0412f.m323a(true).m334e());
        sb.append("\n");
        sb.append(str);
        if (!TbsShareManager.isThirdPartyApp(context) && (map = QbSdk.f210o) != null && map.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) && QbSdk.f210o.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY)) {
            String str2 = "weapp_id:" + QbSdk.f210o.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) + ";" + TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY + ":" + QbSdk.f210o.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY) + ";";
            sb.append("\n");
            sb.append(str2);
        }
        return sb.length() > 8192 ? sb.substring(sb.length() - 8192) : sb.toString();
    }

    public static PackageInfo getCurrentWebViewPackage() {
        if (C0431u.m530a().m534b() || Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            return (PackageInfo) C0453j.m764a("android.webkit.WebView", "getCurrentWebViewPackage");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Deprecated
    public static synchronized Object getPluginList() {
        if (C0431u.m530a().m534b()) {
            return null;
        }
        return C0453j.m764a("android.webkit.WebView", "getPluginList");
    }

    public static int getTbsCoreVersion(Context context) {
        return QbSdk.getTbsVersion(context);
    }

    public static boolean getTbsNeedReboot() {
        m268c();
        return C0412f.m323a(true).m336g();
    }

    public static int getTbsSDKVersion(Context context) {
        return 44286;
    }

    /* JADX INFO: renamed from: h */
    private void m276h() {
        try {
            if ("com.xunmeng.pinduoduo".equals(this.f433g.getApplicationInfo().packageName)) {
                new Thread("WebviewDestroy") { // from class: com.tencent.smtt.sdk.WebView.2
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        WebView.this.m259a(false);
                    }
                }.start();
                if (this.f429c) {
                    this.f430d.destroy();
                } else {
                    this.f431e.destroy();
                }
            } else {
                m259a(true);
            }
        } catch (Throwable unused) {
            m259a(true);
        }
    }

    public static boolean hasCreatedSysWebViewInstance() {
        return mSysWebviewCreated;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: i */
    public long m277i() {
        long j;
        synchronized (QbSdk.f203h) {
            if (QbSdk.f200e) {
                QbSdk.f202g += System.currentTimeMillis() - QbSdk.f201f;
                TbsLog.m659d("sdkreport", "pv report, WebView.getWifiConnectedTime QbSdk.sWifiConnectedTime=" + QbSdk.f202g);
            }
            j = QbSdk.f202g / 1000;
            QbSdk.f202g = 0L;
            QbSdk.f201f = System.currentTimeMillis();
        }
        return j;
    }

    /* JADX INFO: renamed from: j */
    private void m278j() {
        Runnable runnable = new Runnable() { // from class: com.tencent.smtt.sdk.WebView.7
            @Override // java.lang.Runnable
            public void run() {
                boolean zIsX5CoreSandboxMode;
                Bundle sdkQBStatisticsInfo;
                if (WebView.this.f435j || WebView.this.f427a == 0) {
                    return;
                }
                synchronized (WebView.this) {
                    if (!WebView.this.f435j && WebView.this.f427a != 0) {
                        WebView.this.f435j = true;
                        String string = BuildConfig.FLAVOR;
                        String string2 = BuildConfig.FLAVOR;
                        String string3 = BuildConfig.FLAVOR;
                        if (WebView.this.f429c && (sdkQBStatisticsInfo = WebView.this.f430d.getX5WebViewExtension().getSdkQBStatisticsInfo()) != null) {
                            string = sdkQBStatisticsInfo.getString("guid");
                            string2 = sdkQBStatisticsInfo.getString("qua2");
                            string3 = sdkQBStatisticsInfo.getString("lc");
                        }
                        String str = string2;
                        String str2 = string3;
                        String str3 = string;
                        try {
                            zIsX5CoreSandboxMode = WebView.this.f430d.getX5WebViewExtension().isX5CoreSandboxMode();
                        } catch (Throwable th) {
                            TbsLog.m672w("onVisibilityChanged", "exception: " + th);
                            zIsX5CoreSandboxMode = false;
                        }
                        C0429b.m520a(WebView.this.f433g, str3, str, str2, WebView.this.f427a, WebView.this.f429c, WebView.this.m277i(), zIsX5CoreSandboxMode);
                        WebView.this.f427a = 0;
                        WebView.this.f435j = false;
                    }
                }
            }
        };
        Handler tbsLogHandler = TbsLog.getTbsLogHandler();
        if (tbsLogHandler != null) {
            Message messageObtain = Message.obtain(tbsLogHandler, 501);
            messageObtain.obj = runnable;
            messageObtain.sendToTarget();
        } else {
            Thread thread = new Thread(runnable);
            thread.setName("TbsPV");
            thread.start();
        }
    }

    public static void setDataDirectorySuffix(String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                C0453j.m761a(Class.forName("android.webkit.WebView"), "setDataDirectorySuffix", (Class<?>[]) new Class[]{String.class}, str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        HashMap map = new HashMap();
        map.put("data_directory_suffix", str);
        QbSdk.initTbsSettings(map);
    }

    public static synchronized void setSysDayOrNight(boolean z) {
        int i;
        Paint paint;
        if (z == f426v) {
            return;
        }
        f426v = z;
        if (f425u == null) {
            Paint paint2 = new Paint();
            f425u = paint2;
            paint2.setColor(NIGHT_MODE_COLOR);
        }
        if (z) {
            i = 255;
            if (f425u.getAlpha() != 255) {
                paint = f425u;
                paint.setAlpha(i);
            }
        } else {
            int alpha = f425u.getAlpha();
            i = NIGHT_MODE_ALPHA;
            if (alpha != i) {
                paint = f425u;
                paint.setAlpha(i);
            }
        }
    }

    public static void setWebContentsDebuggingEnabled(boolean z) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a != null && c0431uM530a.m534b()) {
            c0431uM530a.m535c().m553a(z);
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("setWebContentsDebuggingEnabled", Boolean.TYPE);
                f423l = declaredMethod;
                if (declaredMethod != null) {
                    declaredMethod.setAccessible(true);
                    f423l.invoke(null, Boolean.valueOf(z));
                }
            } catch (Exception e) {
                TbsLog.m662e("QbSdk", "Exception:" + e.getStackTrace());
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public android.webkit.WebView m279a() {
        if (this.f429c) {
            return null;
        }
        return this.f431e;
    }

    /* JADX INFO: renamed from: a */
    public void m280a(android.webkit.WebView webView) {
    }

    /* JADX INFO: renamed from: a */
    public void m281a(IX5WebViewBase iX5WebViewBase) {
        this.f430d = iX5WebViewBase;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.f429c) {
            this.f430d.addJavascriptInterface(obj, str);
        } else {
            this.f431e.addJavascriptInterface(obj, str);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (!this.f429c) {
            this.f431e.addView(view);
            return;
        }
        View view2 = this.f430d.getView();
        try {
            Method methodM765a = C0453j.m765a(view2, "addView", View.class);
            methodM765a.setAccessible(true);
            methodM765a.invoke(view2, view);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    public IX5WebViewBase m282b() {
        return this.f430d;
    }

    public boolean canGoBack() {
        return !this.f429c ? this.f431e.canGoBack() : this.f430d.canGoBack();
    }

    public boolean canGoBackOrForward(int i) {
        return !this.f429c ? this.f431e.canGoBackOrForward(i) : this.f430d.canGoBackOrForward(i);
    }

    public boolean canGoForward() {
        return !this.f429c ? this.f431e.canGoForward() : this.f430d.canGoForward();
    }

    @Deprecated
    public boolean canZoomIn() {
        Object objM762a;
        if (this.f429c) {
            return this.f430d.canZoomIn();
        }
        if (Build.VERSION.SDK_INT < 11 || (objM762a = C0453j.m762a(this.f431e, "canZoomIn")) == null) {
            return false;
        }
        return ((Boolean) objM762a).booleanValue();
    }

    @Deprecated
    public boolean canZoomOut() {
        Object objM762a;
        if (this.f429c) {
            return this.f430d.canZoomOut();
        }
        if (Build.VERSION.SDK_INT < 11 || (objM762a = C0453j.m762a(this.f431e, "canZoomOut")) == null) {
            return false;
        }
        return ((Boolean) objM762a).booleanValue();
    }

    @Deprecated
    public Picture capturePicture() {
        if (this.f429c) {
            return this.f430d.capturePicture();
        }
        Object objM762a = C0453j.m762a(this.f431e, "capturePicture");
        if (objM762a == null) {
            return null;
        }
        return (Picture) objM762a;
    }

    public void clearCache(boolean z) {
        if (this.f429c) {
            this.f430d.clearCache(z);
        } else {
            this.f431e.clearCache(z);
        }
    }

    public void clearFormData() {
        if (this.f429c) {
            this.f430d.clearFormData();
        } else {
            this.f431e.clearFormData();
        }
    }

    public void clearHistory() {
        if (this.f429c) {
            this.f430d.clearHistory();
        } else {
            this.f431e.clearHistory();
        }
    }

    @TargetApi(3)
    public void clearMatches() {
        if (this.f429c) {
            this.f430d.clearMatches();
        } else {
            this.f431e.clearMatches();
        }
    }

    public void clearSslPreferences() {
        if (this.f429c) {
            this.f430d.clearSslPreferences();
        } else {
            this.f431e.clearSslPreferences();
        }
    }

    @Deprecated
    public void clearView() {
        if (this.f429c) {
            this.f430d.clearView();
        } else {
            C0453j.m762a(this.f431e, "clearView");
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        try {
            if (this.f429c) {
                Method methodM765a = C0453j.m765a(this.f430d.getView(), "computeHorizontalScrollExtent", new Class[0]);
                methodM765a.setAccessible(true);
                return ((Integer) methodM765a.invoke(this.f430d.getView(), new Object[0])).intValue();
            }
            Method methodM765a2 = C0453j.m765a(this.f431e, "computeHorizontalScrollExtent", new Class[0]);
            methodM765a2.setAccessible(true);
            return ((Integer) methodM765a2.invoke(this.f431e, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        try {
            if (this.f429c) {
                Method methodM765a = C0453j.m765a(this.f430d.getView(), "computeHorizontalScrollOffset", new Class[0]);
                methodM765a.setAccessible(true);
                return ((Integer) methodM765a.invoke(this.f430d.getView(), new Object[0])).intValue();
            }
            Method methodM765a2 = C0453j.m765a(this.f431e, "computeHorizontalScrollOffset", new Class[0]);
            methodM765a2.setAccessible(true);
            return ((Integer) methodM765a2.invoke(this.f431e, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        try {
            if (this.f429c) {
                return ((Integer) C0453j.m763a(this.f430d.getView(), "computeHorizontalScrollRange", (Class<?>[]) new Class[0], new Object[0])).intValue();
            }
            Method methodM765a = C0453j.m765a(this.f431e, "computeHorizontalScrollRange", new Class[0]);
            methodM765a.setAccessible(true);
            return ((Integer) methodM765a.invoke(this.f431e, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f429c) {
            this.f430d.computeScroll();
        } else {
            this.f431e.computeScroll();
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        try {
            if (this.f429c) {
                Method methodM765a = C0453j.m765a(this.f430d.getView(), "computeVerticalScrollExtent", new Class[0]);
                methodM765a.setAccessible(true);
                return ((Integer) methodM765a.invoke(this.f430d.getView(), new Object[0])).intValue();
            }
            Method methodM765a2 = C0453j.m765a(this.f431e, "computeVerticalScrollExtent", new Class[0]);
            methodM765a2.setAccessible(true);
            return ((Integer) methodM765a2.invoke(this.f431e, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        try {
            if (this.f429c) {
                Method methodM765a = C0453j.m765a(this.f430d.getView(), "computeVerticalScrollOffset", new Class[0]);
                methodM765a.setAccessible(true);
                return ((Integer) methodM765a.invoke(this.f430d.getView(), new Object[0])).intValue();
            }
            Method methodM765a2 = C0453j.m765a(this.f431e, "computeVerticalScrollOffset", new Class[0]);
            methodM765a2.setAccessible(true);
            return ((Integer) methodM765a2.invoke(this.f431e, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        try {
            if (this.f429c) {
                return ((Integer) C0453j.m763a(this.f430d.getView(), "computeVerticalScrollRange", (Class<?>[]) new Class[0], new Object[0])).intValue();
            }
            Method methodM765a = C0453j.m765a(this.f431e, "computeVerticalScrollRange", new Class[0]);
            methodM765a.setAccessible(true);
            return ((Integer) methodM765a.invoke(this.f431e, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public WebBackForwardList copyBackForwardList() {
        return this.f429c ? WebBackForwardList.m248a(this.f430d.copyBackForwardList()) : WebBackForwardList.m247a(this.f431e.copyBackForwardList());
    }

    public Object createPrintDocumentAdapter(String str) {
        if (!this.f429c) {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return C0453j.m763a(this.f431e, "createPrintDocumentAdapter", (Class<?>[]) new Class[]{String.class}, str);
        }
        try {
            return this.f430d.createPrintDocumentAdapter(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void customDiskCachePathEnabled(boolean z, String str) {
        if (!this.f429c || getX5WebViewExtension() == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("enabled", z);
        bundle.putString("path", str);
        getX5WebViewExtension().invokeMiscMethod("customDiskCachePathEnabled", bundle);
    }

    public void destroy() {
        int i;
        boolean z = false;
        this.f436k = false;
        try {
            if (this.f433g.getApplicationInfo().packageName.contains("com.tencent.qqmusic") && ((i = Build.VERSION.SDK_INT) == 21 || i == 22)) {
                this.f436k = true;
                z = true;
            }
        } catch (Throwable th) {
            TbsLog.m665i("webview", "stack is " + Log.getStackTraceString(th));
        }
        TbsLog.m665i("webview", "destroy forceDestoyOld is " + z);
        if (z) {
            m276h();
        } else {
            m275g();
        }
    }

    public void documentHasImages(Message message) {
        if (this.f429c) {
            this.f430d.documentHasImages(message);
        } else {
            this.f431e.documentHasImages(message);
        }
    }

    public void dumpViewHierarchyWithProperties(BufferedWriter bufferedWriter, int i) {
        if (this.f429c) {
            this.f430d.dumpViewHierarchyWithProperties(bufferedWriter, i);
        } else {
            C0453j.m763a(this.f431e, "dumpViewHierarchyWithProperties", (Class<?>[]) new Class[]{BufferedWriter.class, Integer.TYPE}, bufferedWriter, Integer.valueOf(i));
        }
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.f429c) {
            try {
                Method methodM765a = C0453j.m765a(this.f430d.getView(), "evaluateJavascript", String.class, android.webkit.ValueCallback.class);
                methodM765a.setAccessible(true);
                methodM765a.invoke(this.f430d.getView(), str, valueCallback);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                loadUrl(str);
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("evaluateJavascript", String.class, android.webkit.ValueCallback.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.f431e, str, valueCallback);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Deprecated
    public int findAll(String str) {
        if (this.f429c) {
            return this.f430d.findAll(str);
        }
        Object objM763a = C0453j.m763a(this.f431e, "findAll", (Class<?>[]) new Class[]{String.class}, str);
        if (objM763a == null) {
            return 0;
        }
        return ((Integer) objM763a).intValue();
    }

    @TargetApi(16)
    public void findAllAsync(String str) {
        if (this.f429c) {
            this.f430d.findAllAsync(str);
        } else if (Build.VERSION.SDK_INT >= 16) {
            C0453j.m763a(this.f431e, "findAllAsync", (Class<?>[]) new Class[]{String.class}, str);
        }
    }

    public View findHierarchyView(String str, int i) {
        return !this.f429c ? (View) C0453j.m763a(this.f431e, "findHierarchyView", (Class<?>[]) new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i)) : this.f430d.findHierarchyView(str, i);
    }

    @TargetApi(3)
    public void findNext(boolean z) {
        if (this.f429c) {
            this.f430d.findNext(z);
        } else {
            this.f431e.findNext(z);
        }
    }

    public void flingScroll(int i, int i2) {
        if (this.f429c) {
            this.f430d.flingScroll(i, i2);
        } else {
            this.f431e.flingScroll(i, i2);
        }
    }

    @Deprecated
    public void freeMemory() {
        if (this.f429c) {
            this.f430d.freeMemory();
        } else {
            C0453j.m762a(this.f431e, "freeMemory");
        }
    }

    public SslCertificate getCertificate() {
        return !this.f429c ? this.f431e.getCertificate() : this.f430d.getCertificate();
    }

    public int getContentHeight() {
        return !this.f429c ? this.f431e.getContentHeight() : this.f430d.getContentHeight();
    }

    public int getContentWidth() {
        if (this.f429c) {
            return this.f430d.getContentWidth();
        }
        Object objM762a = C0453j.m762a(this.f431e, "getContentWidth");
        if (objM762a == null) {
            return 0;
        }
        return ((Integer) objM762a).intValue();
    }

    public Bitmap getFavicon() {
        return !this.f429c ? this.f431e.getFavicon() : this.f430d.getFavicon();
    }

    public HitTestResult getHitTestResult() {
        return !this.f429c ? new HitTestResult(this.f431e.getHitTestResult()) : new HitTestResult(this.f430d.getHitTestResult());
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        return !this.f429c ? this.f431e.getHttpAuthUsernamePassword(str, str2) : this.f430d.getHttpAuthUsernamePassword(str, str2);
    }

    public boolean getIsX5Core() {
        return this.f429c;
    }

    @TargetApi(3)
    public String getOriginalUrl() {
        return !this.f429c ? this.f431e.getOriginalUrl() : this.f430d.getOriginalUrl();
    }

    public TbsWebViewPerformanceRecorder getPerformanceRecorder() {
        return this.f434h;
    }

    public int getProgress() {
        return !this.f429c ? this.f431e.getProgress() : this.f430d.getProgress();
    }

    public boolean getRendererPriorityWaivedWhenNotVisible() {
        Object objM762a;
        try {
            if (!this.f429c && Build.VERSION.SDK_INT >= 26 && (objM762a = C0453j.m762a(this.f431e, "getRendererPriorityWaivedWhenNotVisible")) != null) {
                return ((Boolean) objM762a).booleanValue();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getRendererRequestedPriority() {
        Object objM762a;
        try {
            if (!this.f429c && Build.VERSION.SDK_INT >= 26 && (objM762a = C0453j.m762a(this.f431e, "getRendererRequestedPriority")) != null) {
                return ((Integer) objM762a).intValue();
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Deprecated
    public float getScale() {
        if (this.f429c) {
            return this.f430d.getScale();
        }
        Object objM762a = C0453j.m762a(this.f431e, "getScale");
        if (objM762a == null) {
            return 0.0f;
        }
        return ((Float) objM762a).floatValue();
    }

    @Override // android.view.View
    public int getScrollBarDefaultDelayBeforeFade() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarDefaultDelayBeforeFade();
    }

    @Override // android.view.View
    public int getScrollBarFadeDuration() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarFadeDuration();
    }

    @Override // android.view.View
    public int getScrollBarSize() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarSize();
    }

    @Override // android.view.View
    public int getScrollBarStyle() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarStyle();
    }

    public WebSettings getSettings() {
        WebSettings webSettings = this.f432f;
        if (webSettings != null) {
            return webSettings;
        }
        WebSettings webSettings2 = this.f429c ? new WebSettings(this.f430d.getSettings()) : new WebSettings(this.f431e.getSettings());
        this.f432f = webSettings2;
        return webSettings2;
    }

    public IX5WebSettingsExtension getSettingsExtension() {
        if (this.f429c) {
            return this.f430d.getX5WebViewExtension().getSettingsExtension();
        }
        return null;
    }

    public int getSysNightModeAlpha() {
        return NIGHT_MODE_ALPHA;
    }

    public String getTitle() {
        return !this.f429c ? this.f431e.getTitle() : this.f430d.getTitle();
    }

    public String getUrl() {
        return !this.f429c ? this.f431e.getUrl() : this.f430d.getUrl();
    }

    public View getView() {
        return !this.f429c ? this.f431e : this.f430d.getView();
    }

    public int getVisibleTitleHeight() {
        if (this.f429c) {
            return this.f430d.getVisibleTitleHeight();
        }
        Object objM762a = C0453j.m762a(this.f431e, "getVisibleTitleHeight");
        if (objM762a == null) {
            return 0;
        }
        return ((Integer) objM762a).intValue();
    }

    public WebChromeClient getWebChromeClient() {
        return this.f438n;
    }

    public IX5WebChromeClientExtension getWebChromeClientExtension() {
        if (this.f429c) {
            return this.f430d.getX5WebViewExtension().getWebChromeClientExtension();
        }
        return null;
    }

    public int getWebScrollX() {
        return this.f429c ? this.f430d.getView().getScrollX() : this.f431e.getScrollX();
    }

    public int getWebScrollY() {
        return this.f429c ? this.f430d.getView().getScrollY() : this.f431e.getScrollY();
    }

    public WebViewClient getWebViewClient() {
        return this.f437m;
    }

    public IX5WebViewClientExtension getWebViewClientExtension() {
        if (this.f429c) {
            return this.f430d.getX5WebViewExtension().getWebViewClientExtension();
        }
        return null;
    }

    public IX5WebViewBase.HitTestResult getX5HitTestResult() {
        if (this.f429c) {
            return this.f430d.getHitTestResult();
        }
        return null;
    }

    public IX5WebViewExtension getX5WebViewExtension() {
        if (this.f429c) {
            return this.f430d.getX5WebViewExtension();
        }
        return null;
    }

    @Deprecated
    public View getZoomControls() {
        return !this.f429c ? (View) C0453j.m762a(this.f431e, "getZoomControls") : this.f430d.getZoomControls();
    }

    public void goBack() {
        if (this.f429c) {
            this.f430d.goBack();
        } else {
            this.f431e.goBack();
        }
    }

    public void goBackOrForward(int i) {
        if (this.f429c) {
            this.f430d.goBackOrForward(i);
        } else {
            this.f431e.goBackOrForward(i);
        }
    }

    public void goForward() {
        if (this.f429c) {
            this.f430d.goForward();
        } else {
            this.f431e.goForward();
        }
    }

    public void invokeZoomPicker() {
        if (this.f429c) {
            this.f430d.invokeZoomPicker();
        } else {
            this.f431e.invokeZoomPicker();
        }
    }

    public boolean isDayMode() {
        return f426v;
    }

    public boolean isPrivateBrowsingEnabled() {
        Object objM762a;
        if (this.f429c) {
            return this.f430d.isPrivateBrowsingEnable();
        }
        if (Build.VERSION.SDK_INT < 11 || (objM762a = C0453j.m762a(this.f431e, "isPrivateBrowsingEnabled")) == null) {
            return false;
        }
        return ((Boolean) objM762a).booleanValue();
    }

    public void loadData(String str, String str2, String str3) {
        if (this.f429c) {
            this.f430d.loadData(str, str2, str3);
        } else {
            this.f431e.loadData(str, str2, str3);
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.f429c) {
            this.f430d.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            this.f431e.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    public void loadUrl(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (str == null || showDebugView(str)) {
            return;
        }
        if (this.f429c) {
            this.f430d.loadUrl(str);
        } else {
            this.f431e.loadUrl(str);
        }
        this.f434h.m245a(System.currentTimeMillis() - jCurrentTimeMillis, str);
    }

    @TargetApi(8)
    public void loadUrl(String str, Map<String, String> map) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (str == null || showDebugView(str)) {
            return;
        }
        if (this.f429c) {
            this.f430d.loadUrl(str, map);
        } else if (Build.VERSION.SDK_INT >= 8) {
            this.f431e.loadUrl(str, map);
        }
        this.f434h.m245a(System.currentTimeMillis() - jCurrentTimeMillis, str);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f435j || this.f427a == 0) {
            return;
        }
        m278j();
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        View.OnLongClickListener onLongClickListener = this.f445x;
        if (onLongClickListener == null || !onLongClickListener.onLongClick(view)) {
            return m261a(view);
        }
        return true;
    }

    public void onPause() {
        if (this.f429c) {
            this.f430d.onPause();
        } else {
            C0453j.m762a(this.f431e, "onPause");
        }
    }

    public void onResume() {
        if (this.f429c) {
            this.f430d.onResume();
        } else {
            C0453j.m762a(this.f431e, "onResume");
        }
    }

    @Override // android.view.View
    @TargetApi(11)
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (Build.VERSION.SDK_INT < 21 || !m260a(this.f433g) || !isHardwareAccelerated() || i <= 0 || i2 <= 0) {
            return;
        }
        getLayerType();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        Context context = this.f433g;
        if (context == null) {
            super.onVisibilityChanged(view, i);
            return;
        }
        if (f424o == null) {
            f424o = context.getApplicationInfo().packageName;
        }
        String str = f424o;
        if (str != null && (str.equals(TbsConfig.APP_WX) || f424o.equals(TbsConfig.APP_QQ))) {
            super.onVisibilityChanged(view, i);
            return;
        }
        if (i != 0 && !this.f435j && this.f427a != 0) {
            m278j();
        }
        super.onVisibilityChanged(view, i);
    }

    public boolean overlayHorizontalScrollbar() {
        return !this.f429c ? this.f431e.overlayHorizontalScrollbar() : this.f430d.overlayHorizontalScrollbar();
    }

    public boolean overlayVerticalScrollbar() {
        return this.f429c ? this.f430d.overlayVerticalScrollbar() : this.f431e.overlayVerticalScrollbar();
    }

    public boolean pageDown(boolean z) {
        return !this.f429c ? this.f431e.pageDown(z) : this.f430d.pageDown(z, -1);
    }

    public boolean pageUp(boolean z) {
        return !this.f429c ? this.f431e.pageUp(z) : this.f430d.pageUp(z, -1);
    }

    public void pauseTimers() {
        if (this.f429c) {
            this.f430d.pauseTimers();
        } else {
            this.f431e.pauseTimers();
        }
    }

    @TargetApi(5)
    public void postUrl(String str, byte[] bArr) {
        if (this.f429c) {
            this.f430d.postUrl(str, bArr);
        } else {
            this.f431e.postUrl(str, bArr);
        }
    }

    @Deprecated
    public void refreshPlugins(boolean z) {
        if (this.f429c) {
            this.f430d.refreshPlugins(z);
        } else {
            C0453j.m763a(this.f431e, "refreshPlugins", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public void reload() {
        if (this.f429c) {
            this.f430d.reload();
        } else {
            this.f431e.reload();
        }
    }

    @TargetApi(11)
    public void removeJavascriptInterface(String str) {
        if (this.f429c) {
            this.f430d.removeJavascriptInterface(str);
        } else if (Build.VERSION.SDK_INT >= 11) {
            C0453j.m763a(this.f431e, "removeJavascriptInterface", (Class<?>[]) new Class[]{String.class}, str);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (!this.f429c) {
            this.f431e.removeView(view);
            return;
        }
        View view2 = this.f430d.getView();
        try {
            Method methodM765a = C0453j.m765a(view2, "removeView", View.class);
            methodM765a.setAccessible(true);
            methodM765a.invoke(view2, view);
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    public JSONObject reportInitPerformance(long j, int i, long j2, long j3) {
        return null;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        View view2;
        View view3;
        if (!this.f429c) {
            C0404a c0404a = this.f431e;
            if (view == this) {
                view2 = view;
                view2 = c0404a;
            }
            view2 = view;
            return c0404a.requestChildRectangleOnScreen(view2, rect, z);
        }
        View view4 = this.f430d.getView();
        if (!(view4 instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view4;
        if (view == this) {
            view3 = view;
            view3 = view4;
        }
        view3 = view;
        return viewGroup.requestChildRectangleOnScreen(view3, rect, z);
    }

    public void requestFocusNodeHref(Message message) {
        if (this.f429c) {
            this.f430d.requestFocusNodeHref(message);
        } else {
            this.f431e.requestFocusNodeHref(message);
        }
    }

    public void requestImageRef(Message message) {
        if (this.f429c) {
            this.f430d.requestImageRef(message);
        } else {
            this.f431e.requestImageRef(message);
        }
    }

    @Deprecated
    public boolean restorePicture(Bundle bundle, File file) {
        if (this.f429c) {
            return this.f430d.restorePicture(bundle, file);
        }
        Object objM763a = C0453j.m763a(this.f431e, "restorePicture", (Class<?>[]) new Class[]{Bundle.class, File.class}, bundle, file);
        if (objM763a == null) {
            return false;
        }
        return ((Boolean) objM763a).booleanValue();
    }

    public WebBackForwardList restoreState(Bundle bundle) {
        return !this.f429c ? WebBackForwardList.m247a(this.f431e.restoreState(bundle)) : WebBackForwardList.m248a(this.f430d.restoreState(bundle));
    }

    public void resumeTimers() {
        if (this.f429c) {
            this.f430d.resumeTimers();
        } else {
            this.f431e.resumeTimers();
        }
    }

    @Deprecated
    public void savePassword(String str, String str2, String str3) {
        if (this.f429c) {
            this.f430d.savePassword(str, str2, str3);
        } else {
            C0453j.m763a(this.f431e, "savePassword", (Class<?>[]) new Class[]{String.class, String.class, String.class}, str, str2, str3);
        }
    }

    @Deprecated
    public boolean savePicture(Bundle bundle, File file) {
        if (this.f429c) {
            return this.f430d.savePicture(bundle, file);
        }
        Object objM763a = C0453j.m763a(this.f431e, "savePicture", (Class<?>[]) new Class[]{Bundle.class, File.class}, bundle, file);
        if (objM763a == null) {
            return false;
        }
        return ((Boolean) objM763a).booleanValue();
    }

    public WebBackForwardList saveState(Bundle bundle) {
        return !this.f429c ? WebBackForwardList.m247a(this.f431e.saveState(bundle)) : WebBackForwardList.m248a(this.f430d.saveState(bundle));
    }

    @TargetApi(11)
    public void saveWebArchive(String str) {
        if (this.f429c) {
            this.f430d.saveWebArchive(str);
        } else if (Build.VERSION.SDK_INT >= 11) {
            C0453j.m763a(this.f431e, "saveWebArchive", (Class<?>[]) new Class[]{String.class}, str);
        }
    }

    @TargetApi(11)
    public void saveWebArchive(String str, boolean z, ValueCallback<String> valueCallback) {
        if (this.f429c) {
            this.f430d.saveWebArchive(str, z, valueCallback);
        } else if (Build.VERSION.SDK_INT >= 11) {
            C0453j.m763a(this.f431e, "saveWebArchive", (Class<?>[]) new Class[]{String.class, Boolean.TYPE, android.webkit.ValueCallback.class}, str, Boolean.valueOf(z), valueCallback);
        }
    }

    public void setARModeEnable(boolean z) {
        try {
            if (this.f429c) {
                getSettingsExtension().setARModeEnable(z);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.f429c) {
            this.f430d.setBackgroundColor(i);
        } else {
            this.f431e.setBackgroundColor(i);
        }
        super.setBackgroundColor(i);
    }

    @Deprecated
    public void setCertificate(SslCertificate sslCertificate) {
        if (this.f429c) {
            this.f430d.setCertificate(sslCertificate);
        } else {
            this.f431e.setCertificate(sslCertificate);
        }
    }

    public void setDayOrNight(boolean z) {
        try {
            if (this.f429c) {
                getSettingsExtension().setDayOrNight(z);
            }
            setSysDayOrNight(z);
            getView().postInvalidate();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setDownloadListener(final DownloadListener downloadListener) {
        boolean z = this.f429c;
        if (z) {
            this.f430d.setDownloadListener(new C0408b(this, downloadListener, z));
        } else {
            this.f431e.setDownloadListener(new android.webkit.DownloadListener() { // from class: com.tencent.smtt.sdk.WebView.4
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    DownloadListener downloadListener2 = downloadListener;
                    if (downloadListener2 != null) {
                        downloadListener2.onDownloadStart(str, str2, str3, str4, j);
                        return;
                    }
                    ApplicationInfo applicationInfo = WebView.this.f433g == null ? null : WebView.this.f433g.getApplicationInfo();
                    if (applicationInfo == null || !TbsConfig.APP_WX.equals(applicationInfo.packageName)) {
                        MttLoader.loadUrl(WebView.this.f433g, str, null, null);
                    }
                }
            });
        }
    }

    @TargetApi(16)
    public void setFindListener(final IX5WebViewBase.FindListener findListener) {
        if (this.f429c) {
            this.f430d.setFindListener(findListener);
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.f431e.setFindListener(new android.webkit.WebView.FindListener() { // from class: com.tencent.smtt.sdk.WebView.3
                @Override // android.webkit.WebView.FindListener
                public void onFindResultReceived(int i, int i2, boolean z) {
                    findListener.onFindResultReceived(i, i2, z);
                }
            });
        }
    }

    public void setHorizontalScrollbarOverlay(boolean z) {
        if (this.f429c) {
            this.f430d.setHorizontalScrollbarOverlay(z);
        } else {
            this.f431e.setHorizontalScrollbarOverlay(z);
        }
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        if (this.f429c) {
            this.f430d.setHttpAuthUsernamePassword(str, str2, str3, str4);
        } else {
            this.f431e.setHttpAuthUsernamePassword(str, str2, str3, str4);
        }
    }

    public void setInitialScale(int i) {
        if (this.f429c) {
            this.f430d.setInitialScale(i);
        } else {
            this.f431e.setInitialScale(i);
        }
    }

    @Deprecated
    public void setMapTrackballToArrowKeys(boolean z) {
        if (this.f429c) {
            this.f430d.setMapTrackballToArrowKeys(z);
        } else {
            C0453j.m763a(this.f431e, "setMapTrackballToArrowKeys", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public void setNetworkAvailable(boolean z) {
        if (this.f429c) {
            this.f430d.setNetworkAvailable(z);
        } else if (Build.VERSION.SDK_INT >= 3) {
            this.f431e.setNetworkAvailable(z);
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (!this.f429c) {
            this.f431e.setOnLongClickListener(onLongClickListener);
            return;
        }
        View view = this.f430d.getView();
        try {
            if (this.f444w == null) {
                Method methodM765a = C0453j.m765a(view, "getListenerInfo", new Class[0]);
                methodM765a.setAccessible(true);
                Object objInvoke = methodM765a.invoke(view, null);
                Field declaredField = objInvoke.getClass().getDeclaredField("mOnLongClickListener");
                declaredField.setAccessible(true);
                this.f444w = declaredField.get(objInvoke);
            }
            this.f445x = onLongClickListener;
            getView().setOnLongClickListener(this);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        getView().setOnTouchListener(onTouchListener);
    }

    @Deprecated
    public void setPictureListener(final PictureListener pictureListener) {
        if (this.f429c) {
            if (pictureListener == null) {
                this.f430d.setPictureListener(null);
                return;
            } else {
                this.f430d.setPictureListener(new IX5WebViewBase.PictureListener() { // from class: com.tencent.smtt.sdk.WebView.6
                    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener
                    public void onNewPicture(IX5WebViewBase iX5WebViewBase, Picture picture, boolean z) {
                        WebView.this.m281a(iX5WebViewBase);
                        pictureListener.onNewPicture(WebView.this, picture);
                    }

                    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener
                    public void onNewPictureIfHaveContent(IX5WebViewBase iX5WebViewBase, Picture picture) {
                    }
                });
                return;
            }
        }
        if (pictureListener == null) {
            this.f431e.setPictureListener(null);
        } else {
            this.f431e.setPictureListener(new android.webkit.WebView.PictureListener() { // from class: com.tencent.smtt.sdk.WebView.5
                @Override // android.webkit.WebView.PictureListener
                public void onNewPicture(android.webkit.WebView webView, Picture picture) {
                    WebView.this.m280a(webView);
                    pictureListener.onNewPicture(WebView.this, picture);
                }
            });
        }
    }

    public void setRendererPriorityPolicy(int i, boolean z) {
        try {
            if (this.f429c || Build.VERSION.SDK_INT < 26) {
                return;
            }
            C0453j.m763a(this.f431e, "setRendererPriorityPolicy", (Class<?>[]) new Class[]{Integer.TYPE, Boolean.TYPE}, Integer.valueOf(i), Boolean.valueOf(z));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    public void setScrollBarStyle(int i) {
        if (this.f429c) {
            this.f430d.getView().setScrollBarStyle(i);
        } else {
            this.f431e.setScrollBarStyle(i);
        }
    }

    public void setSysNightModeAlpha(int i) {
        NIGHT_MODE_ALPHA = i;
    }

    public void setVerticalScrollbarOverlay(boolean z) {
        if (this.f429c) {
            this.f430d.setVerticalScrollbarOverlay(z);
        } else {
            this.f431e.setVerticalScrollbarOverlay(z);
        }
    }

    public boolean setVideoFullScreen(Context context, boolean z) {
        if (!context.getApplicationInfo().processName.contains("com.tencent.android.qqdownloader") || this.f430d == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putInt("DefaultVideoScreen", 2);
        } else {
            bundle.putInt("DefaultVideoScreen", 1);
        }
        this.f430d.getX5WebViewExtension().invokeMiscMethod("setVideoParams", bundle);
        return true;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (getView() == null) {
            return;
        }
        getView().setVisibility(i);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        C0404a c0404a;
        android.webkit.WebChromeClient systemWebChromeClient = null;
        if (this.f429c) {
            this.f430d.setWebChromeClient(webChromeClient != null ? new C0414h(C0431u.m530a().m531a(true).m583i(), this, webChromeClient) : null);
        } else {
            if (webChromeClient == null) {
                c0404a = this.f431e;
            } else if (m262a(webChromeClient)) {
                c0404a = this.f431e;
                systemWebChromeClient = new C0409c(this, webChromeClient);
            } else {
                c0404a = this.f431e;
                systemWebChromeClient = new SystemWebChromeClient(this, webChromeClient);
            }
            c0404a.setWebChromeClient(systemWebChromeClient);
        }
        this.f438n = webChromeClient;
    }

    public void setWebChromeClientExtension(IX5WebChromeClientExtension iX5WebChromeClientExtension) {
        if (this.f429c) {
            this.f430d.getX5WebViewExtension().setWebChromeClientExtension(iX5WebChromeClientExtension);
        }
    }

    public void setWebViewCallbackClient(WebViewCallbackClient webViewCallbackClient) {
        this.mWebViewCallbackClient = webViewCallbackClient;
        if (!this.f429c || getX5WebViewExtension() == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("flag", true);
        getX5WebViewExtension().invokeMiscMethod("setWebViewCallbackClientFlag", bundle);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setWebViewClient(WebViewClient webViewClient) {
        if (this.f429c) {
            this.f430d.setWebViewClient(webViewClient != null ? new C0415i(C0431u.m530a().m531a(true).m586j(), this, webViewClient) : null);
        } else {
            this.f431e.setWebViewClient(webViewClient != null ? new SystemWebViewClient(this, webViewClient) : null);
        }
        this.f437m = webViewClient;
    }

    public void setWebViewClientExtension(IX5WebViewClientExtension iX5WebViewClientExtension) {
        if (this.f429c) {
            this.f430d.getX5WebViewExtension().setWebViewClientExtension(iX5WebViewClientExtension);
        }
    }

    @SuppressLint({"NewApi"})
    public boolean showDebugView(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("https://debugtbs.qq.com")) {
            getView().setVisibility(4);
            C0447d.m716a(this.f433g).m719a(lowerCase, this, this.f433g, TbsHandlerThread.getInstance().getLooper());
            return true;
        }
        if (!lowerCase.startsWith("https://debugx5.qq.com") || this.f429c) {
            return false;
        }
        loadDataWithBaseURL(null, "<!DOCTYPE html><html><body><head><title>无法打开debugx5</title><meta name=\"viewport\" content=\"width=device-width, user-scalable=no\" /></head><br/><br /><h2>debugx5页面仅在使用了X5内核时有效，由于当前没有使用X5内核，无法打开debugx5！</h2><br />尝试<a href=\"https://debugtbs.qq.com?10000\">进入DebugTbs安装或打开X5内核</a></body></html>", "text/html", "utf-8", null);
        return true;
    }

    public boolean showFindDialog(String str, boolean z) {
        return false;
    }

    public void stopLoading() {
        if (this.f429c) {
            this.f430d.stopLoading();
        } else {
            this.f431e.stopLoading();
        }
    }

    public void super_computeScroll() {
        if (!this.f429c) {
            this.f431e.m283a();
            return;
        }
        try {
            C0453j.m762a(this.f430d.getView(), "super_computeScroll");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.f429c) {
            return this.f431e.m288b(motionEvent);
        }
        try {
            Object objM763a = C0453j.m763a(this.f430d.getView(), "super_dispatchTouchEvent", (Class<?>[]) new Class[]{MotionEvent.class}, motionEvent);
            if (objM763a == null) {
                return false;
            }
            return ((Boolean) objM763a).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f429c) {
            return this.f431e.m289c(motionEvent);
        }
        try {
            Object objM763a = C0453j.m763a(this.f430d.getView(), "super_onInterceptTouchEvent", (Class<?>[]) new Class[]{MotionEvent.class}, motionEvent);
            if (objM763a == null) {
                return false;
            }
            return ((Boolean) objM763a).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (!this.f429c) {
            this.f431e.m285a(i, i2, z, z2);
            return;
        }
        View view = this.f430d.getView();
        try {
            Class cls = Integer.TYPE;
            Class cls2 = Boolean.TYPE;
            C0453j.m763a(view, "super_onOverScrolled", (Class<?>[]) new Class[]{cls, cls, cls2, cls2}, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void super_onScrollChanged(int i, int i2, int i3, int i4) {
        if (!this.f429c) {
            this.f431e.m284a(i, i2, i3, i4);
            return;
        }
        View view = this.f430d.getView();
        try {
            Class cls = Integer.TYPE;
            C0453j.m763a(view, "super_onScrollChanged", (Class<?>[]) new Class[]{cls, cls, cls, cls}, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean super_onTouchEvent(MotionEvent motionEvent) {
        if (!this.f429c) {
            return this.f431e.m287a(motionEvent);
        }
        try {
            Object objM763a = C0453j.m763a(this.f430d.getView(), "super_onTouchEvent", (Class<?>[]) new Class[]{MotionEvent.class}, motionEvent);
            if (objM763a == null) {
                return false;
            }
            return ((Boolean) objM763a).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        if (!this.f429c) {
            return this.f431e.m286a(i, i2, i3, i4, i5, i6, i7, i8, z);
        }
        View view = this.f430d.getView();
        try {
            Class cls = Integer.TYPE;
            Object objM763a = C0453j.m763a(view, "super_overScrollBy", (Class<?>[]) new Class[]{cls, cls, cls, cls, cls, cls, cls, cls, Boolean.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z));
            if (objM763a == null) {
                return false;
            }
            return ((Boolean) objM763a).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void switchNightMode(boolean z) {
        String str;
        if (z == f426v) {
            return;
        }
        f426v = z;
        if (z) {
            TbsLog.m662e("QB_SDK", "deleteNightMode");
            str = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        } else {
            TbsLog.m662e("QB_SDK", "nightMode");
            str = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        }
        loadUrl(str);
    }

    public void switchToNightMode() {
        TbsLog.m662e("QB_SDK", "switchToNightMode 01");
        if (f426v) {
            return;
        }
        TbsLog.m662e("QB_SDK", "switchToNightMode");
        loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
    }

    public boolean zoomIn() {
        return !this.f429c ? this.f431e.zoomIn() : this.f430d.zoomIn();
    }

    public boolean zoomOut() {
        return !this.f429c ? this.f431e.zoomOut() : this.f430d.zoomOut();
    }
}
