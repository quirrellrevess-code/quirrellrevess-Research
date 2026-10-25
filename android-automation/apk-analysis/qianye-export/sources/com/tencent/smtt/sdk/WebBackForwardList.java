package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.IX5WebBackForwardList;

/* JADX INFO: loaded from: classes.dex */
public class WebBackForwardList {

    /* JADX INFO: renamed from: a */
    private IX5WebBackForwardList f408a = null;

    /* JADX INFO: renamed from: b */
    private android.webkit.WebBackForwardList f409b = null;

    /* JADX INFO: renamed from: a */
    public static WebBackForwardList m247a(android.webkit.WebBackForwardList webBackForwardList) {
        if (webBackForwardList == null) {
            return null;
        }
        WebBackForwardList webBackForwardList2 = new WebBackForwardList();
        webBackForwardList2.f409b = webBackForwardList;
        return webBackForwardList2;
    }

    /* JADX INFO: renamed from: a */
    public static WebBackForwardList m248a(IX5WebBackForwardList iX5WebBackForwardList) {
        if (iX5WebBackForwardList == null) {
            return null;
        }
        WebBackForwardList webBackForwardList = new WebBackForwardList();
        webBackForwardList.f408a = iX5WebBackForwardList;
        return webBackForwardList;
    }

    public int getCurrentIndex() {
        IX5WebBackForwardList iX5WebBackForwardList = this.f408a;
        return iX5WebBackForwardList != null ? iX5WebBackForwardList.getCurrentIndex() : this.f409b.getCurrentIndex();
    }

    public WebHistoryItem getCurrentItem() {
        IX5WebBackForwardList iX5WebBackForwardList = this.f408a;
        return iX5WebBackForwardList != null ? WebHistoryItem.m250a(iX5WebBackForwardList.getCurrentItem()) : WebHistoryItem.m249a(this.f409b.getCurrentItem());
    }

    public WebHistoryItem getItemAtIndex(int i) {
        IX5WebBackForwardList iX5WebBackForwardList = this.f408a;
        return iX5WebBackForwardList != null ? WebHistoryItem.m250a(iX5WebBackForwardList.getItemAtIndex(i)) : WebHistoryItem.m249a(this.f409b.getItemAtIndex(i));
    }

    public int getSize() {
        IX5WebBackForwardList iX5WebBackForwardList = this.f408a;
        return iX5WebBackForwardList != null ? iX5WebBackForwardList.getSize() : this.f409b.getSize();
    }
}
