package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem;

/* JADX INFO: loaded from: classes.dex */
public class WebHistoryItem {

    /* JADX INFO: renamed from: a */
    private IX5WebHistoryItem f410a = null;

    /* JADX INFO: renamed from: b */
    private android.webkit.WebHistoryItem f411b = null;

    private WebHistoryItem() {
    }

    /* JADX INFO: renamed from: a */
    public static WebHistoryItem m249a(android.webkit.WebHistoryItem webHistoryItem) {
        if (webHistoryItem == null) {
            return null;
        }
        WebHistoryItem webHistoryItem2 = new WebHistoryItem();
        webHistoryItem2.f411b = webHistoryItem;
        return webHistoryItem2;
    }

    /* JADX INFO: renamed from: a */
    public static WebHistoryItem m250a(IX5WebHistoryItem iX5WebHistoryItem) {
        if (iX5WebHistoryItem == null) {
            return null;
        }
        WebHistoryItem webHistoryItem = new WebHistoryItem();
        webHistoryItem.f410a = iX5WebHistoryItem;
        return webHistoryItem;
    }

    public Bitmap getFavicon() {
        IX5WebHistoryItem iX5WebHistoryItem = this.f410a;
        return iX5WebHistoryItem != null ? iX5WebHistoryItem.getFavicon() : this.f411b.getFavicon();
    }

    public String getOriginalUrl() {
        IX5WebHistoryItem iX5WebHistoryItem = this.f410a;
        return iX5WebHistoryItem != null ? iX5WebHistoryItem.getOriginalUrl() : this.f411b.getOriginalUrl();
    }

    public String getTitle() {
        IX5WebHistoryItem iX5WebHistoryItem = this.f410a;
        return iX5WebHistoryItem != null ? iX5WebHistoryItem.getTitle() : this.f411b.getTitle();
    }

    public String getUrl() {
        IX5WebHistoryItem iX5WebHistoryItem = this.f410a;
        return iX5WebHistoryItem != null ? iX5WebHistoryItem.getUrl() : this.f411b.getUrl();
    }
}
