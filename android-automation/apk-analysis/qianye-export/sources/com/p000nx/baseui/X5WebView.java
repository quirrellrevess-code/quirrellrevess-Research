package com.p000nx.baseui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/* JADX INFO: loaded from: classes.dex */
public class X5WebView extends WebView {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public WebViewClient f5421ILil;

    public class IL1Iii extends WebViewClient {
        public IL1Iii(X5WebView x5WebView) {
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public X5WebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IL1Iii iL1Iii = new IL1Iii(this);
        this.f5421ILil = iL1Iii;
        setWebViewClient(iL1Iii);
        IL1Iii();
        getView().setClickable(true);
    }

    public final void IL1Iii() {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setAllowFileAccess(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setSupportMultipleWindows(true);
        settings.setAppCacheEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setAppCacheMaxSize(RecyclerView.FOREVER_NS);
        settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        settings.setCacheMode(2);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean zDrawChild = super.drawChild(canvas, view, j);
        canvas.save();
        return zDrawChild;
    }

    public X5WebView(Context context) {
        super(context);
        this.f5421ILil = new IL1Iii(this);
    }
}
