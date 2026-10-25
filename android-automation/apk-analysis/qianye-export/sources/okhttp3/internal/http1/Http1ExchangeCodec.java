package okhttp3.internal.http1;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import p047IL.C0007;
import p047IL.C0656lIII;
import p047IL.IIi;
import p047IL.L1l;
import p047IL.LlLLL;
import p066Ilil.C0653il;
import p066Ilil.I11li1;
import p066Ilil.I1I;
import p066Ilil.IL;
import p066Ilil.iIlLiL;
import p066Ilil.lL;
import p066Ilil.lLi1LL;

/* JADX INFO: loaded from: classes.dex */
public final class Http1ExchangeCodec implements ExchangeCodec {
    private static final int HEADER_LIMIT = 262144;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    private final C0007 client;
    private final RealConnection realConnection;
    private final IL sink;
    private final lLi1LL source;
    private LlLLL trailers;
    private int state = 0;
    private long headerLimit = 262144;

    public abstract class AbstractSource implements I11li1 {
        public boolean closed;
        public final C0653il timeout;

        private AbstractSource() {
            this.timeout = new C0653il(Http1ExchangeCodec.this.source.timeout());
        }

        @Override // p066Ilil.I11li1, java.io.Closeable, java.lang.AutoCloseable
        public abstract /* synthetic */ void close() throws IOException;

        @Override // p066Ilil.I11li1
        public long read(I1I i1i, long j) throws IOException {
            try {
                return Http1ExchangeCodec.this.source.read(i1i, j);
            } catch (IOException e) {
                Http1ExchangeCodec.this.realConnection.noNewExchanges();
                responseBodyComplete();
                throw e;
            }
        }

        public final void responseBodyComplete() {
            if (Http1ExchangeCodec.this.state == 6) {
                return;
            }
            if (Http1ExchangeCodec.this.state == 5) {
                Http1ExchangeCodec.this.detachTimeout(this.timeout);
                Http1ExchangeCodec.this.state = 6;
            } else {
                throw new IllegalStateException("state: " + Http1ExchangeCodec.this.state);
            }
        }

        @Override // p066Ilil.I11li1, p066Ilil.iIlLiL
        public lL timeout() {
            return this.timeout;
        }
    }

    public final class ChunkedSink implements iIlLiL {
        private boolean closed;
        private final C0653il timeout;

        public ChunkedSink() {
            this.timeout = new C0653il(Http1ExchangeCodec.this.sink.timeout());
        }

        @Override // p066Ilil.iIlLiL, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Http1ExchangeCodec.this.sink.LlLI1("0\r\n\r\n");
            Http1ExchangeCodec.this.detachTimeout(this.timeout);
            Http1ExchangeCodec.this.state = 3;
        }

        @Override // p066Ilil.iIlLiL, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.closed) {
                return;
            }
            Http1ExchangeCodec.this.sink.flush();
        }

        @Override // p066Ilil.iIlLiL
        public lL timeout() {
            return this.timeout;
        }

        @Override // p066Ilil.iIlLiL
        public void write(I1I i1i, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            Http1ExchangeCodec.this.sink.mo2807lL(j);
            Http1ExchangeCodec.this.sink.LlLI1("\r\n");
            Http1ExchangeCodec.this.sink.write(i1i, j);
            Http1ExchangeCodec.this.sink.LlLI1("\r\n");
        }
    }

    public class ChunkedSource extends AbstractSource {
        private static final long NO_CHUNK_YET = -1;
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        private final C0656lIII url;

        public ChunkedSource(C0656lIII c0656lIII) {
            super();
            this.bytesRemainingInChunk = -1L;
            this.hasMoreChunks = true;
            this.url = c0656lIII;
        }

        private void readChunkSize() throws IOException {
            if (this.bytesRemainingInChunk != -1) {
                Http1ExchangeCodec.this.source.llliI();
            }
            try {
                this.bytesRemainingInChunk = Http1ExchangeCodec.this.source.mo2774IIi();
                String strTrim = Http1ExchangeCodec.this.source.llliI().trim();
                if (this.bytesRemainingInChunk < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + strTrim + "\"");
                }
                if (this.bytesRemainingInChunk == 0) {
                    this.hasMoreChunks = false;
                    Http1ExchangeCodec http1ExchangeCodec = Http1ExchangeCodec.this;
                    http1ExchangeCodec.trailers = http1ExchangeCodec.readHeaders();
                    HttpHeaders.receiveHeaders(Http1ExchangeCodec.this.client.m2968L11I(), this.url, Http1ExchangeCodec.this.trailers);
                    responseBodyComplete();
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, p066Ilil.I11li1, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                Http1ExchangeCodec.this.realConnection.noNewExchanges();
                responseBodyComplete();
            }
            this.closed = true;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, p066Ilil.I11li1
        public long read(I1I i1i, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (!this.hasMoreChunks) {
                return -1L;
            }
            long j2 = this.bytesRemainingInChunk;
            if (j2 == 0 || j2 == -1) {
                readChunkSize();
                if (!this.hasMoreChunks) {
                    return -1L;
                }
            }
            long j3 = super.read(i1i, Math.min(j, this.bytesRemainingInChunk));
            if (j3 != -1) {
                this.bytesRemainingInChunk -= j3;
                return j3;
            }
            Http1ExchangeCodec.this.realConnection.noNewExchanges();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            responseBodyComplete();
            throw protocolException;
        }
    }

    public class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;

        public FixedLengthSource(long j) {
            super();
            this.bytesRemaining = j;
            if (j == 0) {
                responseBodyComplete();
            }
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, p066Ilil.I11li1, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (this.bytesRemaining != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                Http1ExchangeCodec.this.realConnection.noNewExchanges();
                responseBodyComplete();
            }
            this.closed = true;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, p066Ilil.I11li1
        public long read(I1I i1i, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            long j2 = this.bytesRemaining;
            if (j2 == 0) {
                return -1L;
            }
            long j3 = super.read(i1i, Math.min(j2, j));
            if (j3 == -1) {
                Http1ExchangeCodec.this.realConnection.noNewExchanges();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                responseBodyComplete();
                throw protocolException;
            }
            long j4 = this.bytesRemaining - j3;
            this.bytesRemaining = j4;
            if (j4 == 0) {
                responseBodyComplete();
            }
            return j3;
        }
    }

    public final class KnownLengthSink implements iIlLiL {
        private boolean closed;
        private final C0653il timeout;

        private KnownLengthSink() {
            this.timeout = new C0653il(Http1ExchangeCodec.this.sink.timeout());
        }

        @Override // p066Ilil.iIlLiL, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Http1ExchangeCodec.this.detachTimeout(this.timeout);
            Http1ExchangeCodec.this.state = 3;
        }

        @Override // p066Ilil.iIlLiL, java.io.Flushable
        public void flush() throws IOException {
            if (this.closed) {
                return;
            }
            Http1ExchangeCodec.this.sink.flush();
        }

        @Override // p066Ilil.iIlLiL
        public lL timeout() {
            return this.timeout;
        }

        @Override // p066Ilil.iIlLiL
        public void write(I1I i1i, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            Util.checkOffsetAndCount(i1i.m96I(), 0L, j);
            Http1ExchangeCodec.this.sink.write(i1i, j);
        }
    }

    public class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;

        private UnknownLengthSource() {
            super();
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, p066Ilil.I11li1, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (!this.inputExhausted) {
                responseBodyComplete();
            }
            this.closed = true;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, p066Ilil.I11li1
        public long read(I1I i1i, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (this.inputExhausted) {
                return -1L;
            }
            long j2 = super.read(i1i, j);
            if (j2 != -1) {
                return j2;
            }
            this.inputExhausted = true;
            responseBodyComplete();
            return -1L;
        }
    }

    public Http1ExchangeCodec(C0007 c0007, RealConnection realConnection, lLi1LL lli1ll, IL il) {
        this.client = c0007;
        this.realConnection = realConnection;
        this.source = lli1ll;
        this.sink = il;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void detachTimeout(C0653il c0653il) {
        lL lLVarIL1Iii = c0653il.IL1Iii();
        c0653il.ILil(lL.NONE);
        lLVarIL1Iii.clearDeadline();
        lLVarIL1Iii.clearTimeout();
    }

    private iIlLiL newChunkedSink() {
        if (this.state == 1) {
            this.state = 2;
            return new ChunkedSink();
        }
        throw new IllegalStateException("state: " + this.state);
    }

    private I11li1 newChunkedSource(C0656lIII c0656lIII) {
        if (this.state == 4) {
            this.state = 5;
            return new ChunkedSource(c0656lIII);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    private I11li1 newFixedLengthSource(long j) {
        if (this.state == 4) {
            this.state = 5;
            return new FixedLengthSource(j);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    private iIlLiL newKnownLengthSink() {
        if (this.state == 1) {
            this.state = 2;
            return new KnownLengthSink();
        }
        throw new IllegalStateException("state: " + this.state);
    }

    private I11li1 newUnknownLengthSource() {
        if (this.state == 4) {
            this.state = 5;
            this.realConnection.noNewExchanges();
            return new UnknownLengthSource();
        }
        throw new IllegalStateException("state: " + this.state);
    }

    private String readHeaderLine() throws IOException {
        String strLil = this.source.Lil(this.headerLimit);
        this.headerLimit -= (long) strLil.length();
        return strLil;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LlLLL readHeaders() throws IOException {
        LlLLL.IL1Iii iL1Iii = new LlLLL.IL1Iii();
        while (true) {
            String headerLine = readHeaderLine();
            if (headerLine.length() == 0) {
                return iL1Iii.Ilil();
            }
            Internal.instance.addLenient(iL1Iii, headerLine);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        RealConnection realConnection = this.realConnection;
        if (realConnection != null) {
            realConnection.cancel();
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public RealConnection connection() {
        return this.realConnection;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public iIlLiL createRequestBody(L1l l1l, long j) throws IOException {
        if (l1l.IL1Iii() != null && l1l.IL1Iii().isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if ("chunked".equalsIgnoreCase(l1l.I1I("Transfer-Encoding"))) {
            return newChunkedSink();
        }
        if (j != -1) {
            return newKnownLengthSink();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() throws IOException {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() throws IOException {
        this.sink.flush();
    }

    public boolean isClosed() {
        return this.state == 6;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public I11li1 openResponseBodySource(IIi iIi) {
        if (!HttpHeaders.hasBody(iIi)) {
            return newFixedLengthSource(0L);
        }
        if ("chunked".equalsIgnoreCase(iIi.m2844IIiI("Transfer-Encoding"))) {
            return newChunkedSource(iIi.m2848LIl().m2875il());
        }
        long jContentLength = HttpHeaders.contentLength(iIi);
        return jContentLength != -1 ? newFixedLengthSource(jContentLength) : newUnknownLengthSource();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public IIi.IL1Iii readResponseHeaders(boolean z) throws IOException {
        int i = this.state;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.state);
        }
        try {
            StatusLine statusLine = StatusLine.parse(readHeaderLine());
            IIi.IL1Iii iL1Iii = new IIi.IL1Iii();
            iL1Iii.Lil(statusLine.protocol);
            iL1Iii.m2860iILLL1(statusLine.code);
            iL1Iii.m2858Ll1(statusLine.message);
            iL1Iii.m2865il(readHeaders());
            if (z && statusLine.code == 100) {
                return null;
            }
            if (statusLine.code == 100) {
                this.state = 3;
                return iL1Iii;
            }
            this.state = 4;
            return iL1Iii;
        } catch (EOFException e) {
            RealConnection realConnection = this.realConnection;
            throw new IOException("unexpected end of stream on " + (realConnection != null ? realConnection.route().IL1Iii().m2952Ll1().m2912lIII() : "unknown"), e);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(IIi iIi) {
        if (!HttpHeaders.hasBody(iIi)) {
            return 0L;
        }
        if ("chunked".equalsIgnoreCase(iIi.m2844IIiI("Transfer-Encoding"))) {
            return -1L;
        }
        return HttpHeaders.contentLength(iIi);
    }

    public void skipConnectBody(IIi iIi) throws IOException {
        long jContentLength = HttpHeaders.contentLength(iIi);
        if (jContentLength == -1) {
            return;
        }
        I11li1 i11li1NewFixedLengthSource = newFixedLengthSource(jContentLength);
        Util.skipAll(i11li1NewFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        i11li1NewFixedLengthSource.close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public LlLLL trailers() {
        if (this.state != 6) {
            throw new IllegalStateException("too early; can't read the trailers yet");
        }
        LlLLL llLLL = this.trailers;
        return llLLL != null ? llLLL : Util.EMPTY_HEADERS;
    }

    public void writeRequest(LlLLL llLLL, String str) throws IOException {
        if (this.state != 0) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.sink.LlLI1(str).LlLI1("\r\n");
        int iM2884IiL = llLLL.m2884IiL();
        for (int i = 0; i < iM2884IiL; i++) {
            this.sink.LlLI1(llLLL.Ilil(i)).LlLI1(": ").LlLI1(llLLL.m2885L11I(i)).LlLI1("\r\n");
        }
        this.sink.LlLI1("\r\n");
        this.state = 1;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(L1l l1l) throws IOException {
        writeRequest(l1l.Ilil(), RequestLine.get(l1l, this.realConnection.route().ILil().type()));
    }
}
