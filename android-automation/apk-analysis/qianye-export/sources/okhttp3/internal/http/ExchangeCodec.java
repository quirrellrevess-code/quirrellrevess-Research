package okhttp3.internal.http;

import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.internal.connection.RealConnection;
import p047IL.IIi;
import p047IL.L1l;
import p047IL.LlLLL;
import p066Ilil.I11li1;
import p066Ilil.iIlLiL;

/* JADX INFO: loaded from: classes.dex */
public interface ExchangeCodec {
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    void cancel();

    RealConnection connection();

    iIlLiL createRequestBody(L1l l1l, long j) throws IOException;

    void finishRequest() throws IOException;

    void flushRequest() throws IOException;

    I11li1 openResponseBodySource(IIi iIi) throws IOException;

    @Nullable
    IIi.IL1Iii readResponseHeaders(boolean z) throws IOException;

    long reportedContentLength(IIi iIi) throws IOException;

    LlLLL trailers() throws IOException;

    void writeRequestHeaders(L1l l1l) throws IOException;
}
