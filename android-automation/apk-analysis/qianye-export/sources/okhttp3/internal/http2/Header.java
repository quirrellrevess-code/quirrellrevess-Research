package okhttp3.internal.http2;

import okhttp3.internal.Util;
import p066Ilil.iILLL1;

/* JADX INFO: loaded from: classes.dex */
public final class Header {
    public final int hpackSize;
    public final iILLL1 name;
    public final iILLL1 value;
    public static final iILLL1 PSEUDO_PREFIX = iILLL1.encodeUtf8(":");
    public static final String RESPONSE_STATUS_UTF8 = ":status";
    public static final iILLL1 RESPONSE_STATUS = iILLL1.encodeUtf8(RESPONSE_STATUS_UTF8);
    public static final String TARGET_METHOD_UTF8 = ":method";
    public static final iILLL1 TARGET_METHOD = iILLL1.encodeUtf8(TARGET_METHOD_UTF8);
    public static final String TARGET_PATH_UTF8 = ":path";
    public static final iILLL1 TARGET_PATH = iILLL1.encodeUtf8(TARGET_PATH_UTF8);
    public static final String TARGET_SCHEME_UTF8 = ":scheme";
    public static final iILLL1 TARGET_SCHEME = iILLL1.encodeUtf8(TARGET_SCHEME_UTF8);
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";
    public static final iILLL1 TARGET_AUTHORITY = iILLL1.encodeUtf8(TARGET_AUTHORITY_UTF8);

    public Header(String str, String str2) {
        this(iILLL1.encodeUtf8(str), iILLL1.encodeUtf8(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return this.name.equals(header.name) && this.value.equals(header.value);
    }

    public int hashCode() {
        return ((527 + this.name.hashCode()) * 31) + this.value.hashCode();
    }

    public String toString() {
        return Util.format("%s: %s", this.name.utf8(), this.value.utf8());
    }

    public Header(iILLL1 iilll1, String str) {
        this(iilll1, iILLL1.encodeUtf8(str));
    }

    public Header(iILLL1 iilll1, iILLL1 iilll2) {
        this.name = iilll1;
        this.value = iilll2;
        this.hpackSize = iilll1.size() + 32 + iilll2.size();
    }
}
