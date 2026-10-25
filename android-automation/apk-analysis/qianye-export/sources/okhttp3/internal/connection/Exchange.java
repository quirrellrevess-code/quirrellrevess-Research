package okhttp3.internal.connection;

import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketException;
import javax.annotation.Nullable;
import okhttp3.internal.Internal;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.p006ws.RealWebSocket;
import p047IL.IIi;
import p047IL.ILL;
import p047IL.L1l;
import p047IL.LIll;
import p047IL.LlLLL;
import p047IL.llliI;
import p066Ilil.I11li1;
import p066Ilil.I1I;
import p066Ilil.IiL;
import p066Ilil.L11I;
import p066Ilil.iIlLiL;
import p066Ilil.lIiI;

/* JADX INFO: loaded from: classes.dex */
public final class Exchange {
    public final ILL call;
    public final ExchangeCodec codec;
    private boolean duplex;
    public final llliI eventListener;
    public final ExchangeFinder finder;
    public final Transmitter transmitter;

    public final class RequestBodySink extends IiL {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private long contentLength;

        public RequestBodySink(iIlLiL iillil, long j) {
            super(iillil);
            this.contentLength = j;
        }

        @Nullable
        private IOException complete(@Nullable IOException iOException) {
            if (this.completed) {
                return iOException;
            }
            this.completed = true;
            return Exchange.this.bodyComplete(this.bytesReceived, false, true, iOException);
        }

        @Override // p066Ilil.IiL, p066Ilil.iIlLiL, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            long j = this.contentLength;
            if (j != -1 && this.bytesReceived != j) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                complete(null);
            } catch (IOException e) {
                throw complete(e);
            }
        }

        @Override // p066Ilil.IiL, p066Ilil.iIlLiL, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e) {
                throw complete(e);
            }
        }

        @Override // p066Ilil.IiL, p066Ilil.iIlLiL
        public void write(I1I i1i, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            long j2 = this.contentLength;
            if (j2 == -1 || this.bytesReceived + j <= j2) {
                try {
                    super.write(i1i, j);
                    this.bytesReceived += j;
                    return;
                } catch (IOException e) {
                    throw complete(e);
                }
            }
            throw new ProtocolException("expected " + this.contentLength + " bytes but received " + (this.bytesReceived + j));
        }
    }

    public final class ResponseBodySource extends L11I {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;

        public ResponseBodySource(I11li1 i11li1, long j) {
            super(i11li1);
            this.contentLength = j;
            if (j == 0) {
                complete(null);
            }
        }

        @Override // p066Ilil.L11I, p066Ilil.I11li1, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            try {
                super.close();
                complete(null);
            } catch (IOException e) {
                throw complete(e);
            }
        }

        @Nullable
        public IOException complete(@Nullable IOException iOException) {
            if (this.completed) {
                return iOException;
            }
            this.completed = true;
            return Exchange.this.bodyComplete(this.bytesReceived, true, false, iOException);
        }

        @Override // p066Ilil.L11I, p066Ilil.I11li1
        public long read(I1I i1i, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            try {
                long j2 = delegate().read(i1i, j);
                if (j2 == -1) {
                    complete(null);
                    return -1L;
                }
                long j3 = this.bytesReceived + j2;
                long j4 = this.contentLength;
                if (j4 != -1 && j3 > j4) {
                    throw new ProtocolException("expected " + this.contentLength + " bytes but received " + j3);
                }
                this.bytesReceived = j3;
                if (j3 == j4) {
                    complete(null);
                }
                return j2;
            } catch (IOException e) {
                throw complete(e);
            }
        }
    }

    public Exchange(Transmitter transmitter, ILL ill, llliI lllii, ExchangeFinder exchangeFinder, ExchangeCodec exchangeCodec) {
        this.transmitter = transmitter;
        this.call = ill;
        this.eventListener = lllii;
        this.finder = exchangeFinder;
        this.codec = exchangeCodec;
    }

    @Nullable
    public IOException bodyComplete(long j, boolean z, boolean z2, @Nullable IOException iOException) {
        if (iOException != null) {
            trackFailure(iOException);
        }
        if (z2) {
            if (iOException != null) {
                this.eventListener.Lil(this.call, iOException);
            } else {
                this.eventListener.m2944lIiI(this.call, j);
            }
        }
        if (z) {
            if (iOException != null) {
                this.eventListener.iIlLiL(this.call, iOException);
            } else {
                this.eventListener.m2945lIlii(this.call, j);
            }
        }
        return this.transmitter.exchangeMessageDone(this, z2, z, iOException);
    }

    public void cancel() {
        this.codec.cancel();
    }

    public RealConnection connection() {
        return this.codec.connection();
    }

    public iIlLiL createRequestBody(L1l l1l, boolean z) throws IOException {
        this.duplex = z;
        long jContentLength = l1l.IL1Iii().contentLength();
        this.eventListener.m2939ILl(this.call);
        return new RequestBodySink(this.codec.createRequestBody(l1l, jContentLength), jContentLength);
    }

    public void detachWithViolence() {
        this.codec.cancel();
        this.transmitter.exchangeMessageDone(this, true, true, null);
    }

    public void finishRequest() throws IOException {
        try {
            this.codec.finishRequest();
        } catch (IOException e) {
            this.eventListener.Lil(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public void flushRequest() throws IOException {
        try {
            this.codec.flushRequest();
        } catch (IOException e) {
            this.eventListener.Lil(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public boolean isDuplex() {
        return this.duplex;
    }

    public RealWebSocket.Streams newWebSocketStreams() throws SocketException {
        this.transmitter.timeoutEarlyExit();
        return this.codec.connection().newWebSocketStreams(this);
    }

    public void noNewExchangesOnConnection() {
        this.codec.connection().noNewExchanges();
    }

    public void noRequestBody() {
        this.transmitter.exchangeMessageDone(this, true, false, null);
    }

    public LIll openResponseBody(IIi iIi) throws IOException {
        try {
            this.eventListener.iIi1(this.call);
            String strM2844IIiI = iIi.m2844IIiI("Content-Type");
            long jReportedContentLength = this.codec.reportedContentLength(iIi);
            return new RealResponseBody(strM2844IIiI, jReportedContentLength, lIiI.m2826IL(new ResponseBodySource(this.codec.openResponseBodySource(iIi), jReportedContentLength)));
        } catch (IOException e) {
            this.eventListener.iIlLiL(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    @Nullable
    public IIi.IL1Iii readResponseHeaders(boolean z) throws IOException {
        try {
            IIi.IL1Iii responseHeaders = this.codec.readResponseHeaders(z);
            if (responseHeaders != null) {
                Internal.instance.initExchange(responseHeaders, this);
            }
            return responseHeaders;
        } catch (IOException e) {
            this.eventListener.iIlLiL(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public void responseHeadersEnd(IIi iIi) {
        this.eventListener.I11li1(this.call, iIi);
    }

    public void responseHeadersStart() {
        this.eventListener.m2949lL(this.call);
    }

    public void timeoutEarlyExit() {
        this.transmitter.timeoutEarlyExit();
    }

    public void trackFailure(IOException iOException) {
        this.finder.trackFailure();
        this.codec.connection().trackFailure(iOException);
    }

    public LlLLL trailers() throws IOException {
        return this.codec.trailers();
    }

    public void webSocketUpgradeFailed() {
        bodyComplete(-1L, true, true, null);
    }

    public void writeRequestHeaders(L1l l1l) throws IOException {
        try {
            this.eventListener.m2946llL1ii(this.call);
            this.codec.writeRequestHeaders(l1l);
            this.eventListener.LlLI1(this.call, l1l);
        } catch (IOException e) {
            this.eventListener.Lil(this.call, e);
            trackFailure(e);
            throw e;
        }
    }
}
