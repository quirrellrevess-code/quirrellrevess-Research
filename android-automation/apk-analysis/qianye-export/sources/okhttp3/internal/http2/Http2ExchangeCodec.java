package okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import p047IL.C0007;
import p047IL.IIi;
import p047IL.L1l;
import p047IL.LL1IL;
import p047IL.LlLLL;
import p047IL.llI;
import p066Ilil.I11li1;
import p066Ilil.iIlLiL;
import p066Ilil.lL;

/* JADX INFO: loaded from: classes.dex */
public final class Http2ExchangeCodec implements ExchangeCodec {
    private volatile boolean canceled;
    private final LL1IL.IL1Iii chain;
    private final Http2Connection connection;
    private final llI protocol;
    private final RealConnection realConnection;
    private volatile Http2Stream stream;
    private static final String CONNECTION = "connection";
    private static final String HOST = "host";
    private static final String KEEP_ALIVE = "keep-alive";
    private static final String PROXY_CONNECTION = "proxy-connection";

    /* JADX INFO: renamed from: TE */
    private static final String f882TE = "te";
    private static final String TRANSFER_ENCODING = "transfer-encoding";
    private static final String ENCODING = "encoding";
    private static final String UPGRADE = "upgrade";
    private static final List<String> HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, f882TE, TRANSFER_ENCODING, ENCODING, UPGRADE, Header.TARGET_METHOD_UTF8, Header.TARGET_PATH_UTF8, Header.TARGET_SCHEME_UTF8, Header.TARGET_AUTHORITY_UTF8);
    private static final List<String> HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, f882TE, TRANSFER_ENCODING, ENCODING, UPGRADE);

    public Http2ExchangeCodec(C0007 c0007, RealConnection realConnection, LL1IL.IL1Iii iL1Iii, Http2Connection http2Connection) {
        this.realConnection = realConnection;
        this.chain = iL1Iii;
        this.connection = http2Connection;
        List<llI> listM2977lL = c0007.m2977lL();
        llI lli = llI.H2_PRIOR_KNOWLEDGE;
        this.protocol = listM2977lL.contains(lli) ? lli : llI.HTTP_2;
    }

    public static List<Header> http2HeadersList(L1l l1l) {
        LlLLL llLLLIlil = l1l.Ilil();
        ArrayList arrayList = new ArrayList(llLLLIlil.m2884IiL() + 4);
        arrayList.add(new Header(Header.TARGET_METHOD, l1l.m2873iILLL1()));
        arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(l1l.m2875il())));
        String strI1I = l1l.I1I("Host");
        if (strI1I != null) {
            arrayList.add(new Header(Header.TARGET_AUTHORITY, strI1I));
        }
        arrayList.add(new Header(Header.TARGET_SCHEME, l1l.m2875il().m2908L111()));
        int iM2884IiL = llLLLIlil.m2884IiL();
        for (int i = 0; i < iM2884IiL; i++) {
            String lowerCase = llLLLIlil.Ilil(i).toLowerCase(Locale.US);
            if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(lowerCase) || (lowerCase.equals(f882TE) && llLLLIlil.m2885L11I(i).equals("trailers"))) {
                arrayList.add(new Header(lowerCase, llLLLIlil.m2885L11I(i)));
            }
        }
        return arrayList;
    }

    public static IIi.IL1Iii readHttp2HeadersList(LlLLL llLLL, llI lli) throws IOException {
        LlLLL.IL1Iii iL1Iii = new LlLLL.IL1Iii();
        int iM2884IiL = llLLL.m2884IiL();
        StatusLine statusLine = null;
        for (int i = 0; i < iM2884IiL; i++) {
            String strIlil = llLLL.Ilil(i);
            String strM2885L11I = llLLL.m2885L11I(i);
            if (strIlil.equals(Header.RESPONSE_STATUS_UTF8)) {
                statusLine = StatusLine.parse("HTTP/1.1 " + strM2885L11I);
            } else if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(strIlil)) {
                Internal.instance.addLenient(iL1Iii, strIlil, strM2885L11I);
            }
        }
        if (statusLine == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        IIi.IL1Iii iL1Iii2 = new IIi.IL1Iii();
        iL1Iii2.Lil(lli);
        iL1Iii2.m2860iILLL1(statusLine.code);
        iL1Iii2.m2858Ll1(statusLine.message);
        iL1Iii2.m2865il(iL1Iii.Ilil());
        return iL1Iii2;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        this.canceled = true;
        if (this.stream != null) {
            this.stream.closeLater(ErrorCode.CANCEL);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public RealConnection connection() {
        return this.realConnection;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public iIlLiL createRequestBody(L1l l1l, long j) {
        return this.stream.getSink();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() throws IOException {
        this.stream.getSink().close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() throws IOException {
        this.connection.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public I11li1 openResponseBodySource(IIi iIi) {
        return this.stream.getSource();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public IIi.IL1Iii readResponseHeaders(boolean z) throws IOException {
        IIi.IL1Iii http2HeadersList = readHttp2HeadersList(this.stream.takeHeaders(), this.protocol);
        if (z && Internal.instance.code(http2HeadersList) == 100) {
            return null;
        }
        return http2HeadersList;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(IIi iIi) {
        return HttpHeaders.contentLength(iIi);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public LlLLL trailers() throws IOException {
        return this.stream.trailers();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(L1l l1l) throws IOException {
        if (this.stream != null) {
            return;
        }
        this.stream = this.connection.newStream(http2HeadersList(l1l), l1l.IL1Iii() != null);
        if (this.canceled) {
            this.stream.closeLater(ErrorCode.CANCEL);
            throw new IOException("Canceled");
        }
        lL timeout = this.stream.readTimeout();
        long timeoutMillis = this.chain.readTimeoutMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeout.timeout(timeoutMillis, timeUnit);
        this.stream.writeTimeout().timeout(this.chain.writeTimeoutMillis(), timeUnit);
    }
}
