package com.tencent.smtt.sdk;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import com.tencent.smtt.export.external.interfaces.IconListener;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class WebIconDatabase {

    /* JADX INFO: renamed from: a */
    private static WebIconDatabase f412a;

    /* JADX INFO: renamed from: com.tencent.smtt.sdk.WebIconDatabase$a */
    @Deprecated
    public interface InterfaceC0395a {
        /* JADX INFO: renamed from: a */
        void m252a(String str, Bitmap bitmap);
    }

    private WebIconDatabase() {
    }

    /* JADX INFO: renamed from: a */
    private static synchronized WebIconDatabase m251a() {
        if (f412a == null) {
            f412a = new WebIconDatabase();
        }
        return f412a;
    }

    public static WebIconDatabase getInstance() {
        return m251a();
    }

    public void bulkRequestIconForPageUrl(ContentResolver contentResolver, String str, InterfaceC0395a interfaceC0395a) {
    }

    public void close() {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            android.webkit.WebIconDatabase.getInstance().close();
        } else {
            c0431uM530a.m535c().m593m();
        }
    }

    public void open(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            android.webkit.WebIconDatabase.getInstance().open(str);
        } else {
            c0431uM530a.m535c().m561b(str);
        }
    }

    public void releaseIconForPageUrl(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            android.webkit.WebIconDatabase.getInstance().releaseIconForPageUrl(str);
        } else {
            c0431uM530a.m535c().m568d(str);
        }
    }

    public void removeAllIcons() {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            android.webkit.WebIconDatabase.getInstance().removeAllIcons();
        } else {
            c0431uM530a.m535c().m591l();
        }
    }

    public void requestIconForPageUrl(String str, final InterfaceC0395a interfaceC0395a) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            android.webkit.WebIconDatabase.getInstance().requestIconForPageUrl(str, new android.webkit.WebIconDatabase.IconListener() { // from class: com.tencent.smtt.sdk.WebIconDatabase.2
                @Override // android.webkit.WebIconDatabase.IconListener
                public void onReceivedIcon(String str2, Bitmap bitmap) {
                    interfaceC0395a.m252a(str2, bitmap);
                }
            });
        } else {
            c0431uM530a.m535c().m552a(str, new IconListener() { // from class: com.tencent.smtt.sdk.WebIconDatabase.1
                @Override // com.tencent.smtt.export.external.interfaces.IconListener
                public void onReceivedIcon(String str2, Bitmap bitmap) {
                    interfaceC0395a.m252a(str2, bitmap);
                }
            });
        }
    }

    public void retainIconForPageUrl(String str) {
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            android.webkit.WebIconDatabase.getInstance().retainIconForPageUrl(str);
        } else {
            c0431uM530a.m535c().m566c(str);
        }
    }
}
