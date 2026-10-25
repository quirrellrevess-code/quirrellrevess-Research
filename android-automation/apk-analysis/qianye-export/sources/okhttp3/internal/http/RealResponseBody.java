package okhttp3.internal.http;

import javax.annotation.Nullable;
import p047IL.L111;
import p047IL.LIll;
import p066Ilil.lLi1LL;

/* JADX INFO: loaded from: classes.dex */
public final class RealResponseBody extends LIll {
    private final long contentLength;

    @Nullable
    private final String contentTypeString;
    private final lLi1LL source;

    public RealResponseBody(@Nullable String str, long j, lLi1LL lli1ll) {
        this.contentTypeString = str;
        this.contentLength = j;
        this.source = lli1ll;
    }

    @Override // p047IL.LIll
    public long contentLength() {
        return this.contentLength;
    }

    @Override // p047IL.LIll
    public L111 contentType() {
        String str = this.contentTypeString;
        if (str != null) {
            return L111.m2866IL(str);
        }
        return null;
    }

    @Override // p047IL.LIll
    public lLi1LL source() {
        return this.source;
    }
}
