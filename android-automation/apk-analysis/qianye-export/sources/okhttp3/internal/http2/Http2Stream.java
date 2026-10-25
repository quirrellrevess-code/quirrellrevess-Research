package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import p047IL.LlLLL;
import p066Ilil.I11li1;
import p066Ilil.I1I;
import p066Ilil.IL1Iii;
import p066Ilil.iIlLiL;
import p066Ilil.lL;
import p066Ilil.lLi1LL;

/* JADX INFO: loaded from: classes.dex */
public final class Http2Stream {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public long bytesLeftInWriteWindow;
    public final Http2Connection connection;

    @Nullable
    public ErrorCode errorCode;

    @Nullable
    public IOException errorException;
    private boolean hasResponseHeaders;
    private final Deque<LlLLL> headersQueue;

    /* JADX INFO: renamed from: id */
    public final int f883id;
    public final StreamTimeout readTimeout;
    public final FramingSink sink;
    private final FramingSource source;
    public long unacknowledgedBytesRead = 0;
    public final StreamTimeout writeTimeout;

    public final class FramingSink implements iIlLiL {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long EMIT_BUFFER_SIZE = 16384;
        public boolean closed;
        public boolean finished;
        private final I1I sendBuffer = new I1I();
        private LlLLL trailers;

        public FramingSink() {
        }

        /* JADX WARN: Code duplicated, block: B:24:0x005a  */
        private void emitFrame(boolean z) throws IOException {
            Http2Stream http2Stream;
            long jMin;
            Http2Stream http2Stream2;
            boolean z2;
            synchronized (Http2Stream.this) {
                Http2Stream.this.writeTimeout.enter();
                while (true) {
                    try {
                        http2Stream = Http2Stream.this;
                        if (http2Stream.bytesLeftInWriteWindow > 0 || this.finished || this.closed || http2Stream.errorCode != null) {
                            break;
                        } else {
                            http2Stream.waitForIo();
                        }
                    } catch (Throwable th) {
                        Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
                        throw th;
                    }
                }
                http2Stream.writeTimeout.exitAndThrowIfTimedOut();
                Http2Stream.this.checkOutNotClosed();
                jMin = Math.min(Http2Stream.this.bytesLeftInWriteWindow, this.sendBuffer.m96I());
                http2Stream2 = Http2Stream.this;
                http2Stream2.bytesLeftInWriteWindow -= jMin;
            }
            http2Stream2.writeTimeout.enter();
            if (z) {
                try {
                    if (jMin == this.sendBuffer.m96I()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } finally {
                    Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
                }
            } else {
                z2 = false;
            }
            Http2Stream http2Stream3 = Http2Stream.this;
            http2Stream3.connection.writeData(http2Stream3.f883id, z2, this.sendBuffer, jMin);
        }

        @Override // p066Ilil.iIlLiL, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (Http2Stream.this) {
                if (this.closed) {
                    return;
                }
                if (!Http2Stream.this.sink.finished) {
                    boolean z = this.sendBuffer.m96I() > 0;
                    if (this.trailers != null) {
                        while (this.sendBuffer.m96I() > 0) {
                            emitFrame(false);
                        }
                        Http2Stream http2Stream = Http2Stream.this;
                        http2Stream.connection.writeHeaders(http2Stream.f883id, true, Util.toHeaderBlock(this.trailers));
                    } else if (z) {
                        while (this.sendBuffer.m96I() > 0) {
                            emitFrame(true);
                        }
                    } else {
                        Http2Stream http2Stream2 = Http2Stream.this;
                        http2Stream2.connection.writeData(http2Stream2.f883id, true, null, 0L);
                    }
                }
                synchronized (Http2Stream.this) {
                    this.closed = true;
                }
                Http2Stream.this.connection.flush();
                Http2Stream.this.cancelStreamIfNecessary();
            }
        }

        @Override // p066Ilil.iIlLiL, java.io.Flushable
        public void flush() throws IOException {
            synchronized (Http2Stream.this) {
                Http2Stream.this.checkOutNotClosed();
            }
            while (this.sendBuffer.m96I() > 0) {
                emitFrame(false);
                Http2Stream.this.connection.flush();
            }
        }

        @Override // p066Ilil.iIlLiL
        public lL timeout() {
            return Http2Stream.this.writeTimeout;
        }

        @Override // p066Ilil.iIlLiL
        public void write(I1I i1i, long j) throws IOException {
            this.sendBuffer.write(i1i, j);
            while (this.sendBuffer.m96I() >= EMIT_BUFFER_SIZE) {
                emitFrame(false);
            }
        }
    }

    public final class FramingSource implements I11li1 {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public boolean closed;
        public boolean finished;
        private final long maxByteCount;
        private LlLLL trailers;
        private final I1I receiveBuffer = new I1I();
        private final I1I readBuffer = new I1I();

        public FramingSource(long j) {
            this.maxByteCount = j;
        }

        private void updateConnectionFlowControl(long j) {
            Http2Stream.this.connection.updateConnectionFlowControl(j);
        }

        @Override // p066Ilil.I11li1, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long jM96I;
            synchronized (Http2Stream.this) {
                this.closed = true;
                jM96I = this.readBuffer.m96I();
                this.readBuffer.m2811();
                Http2Stream.this.notifyAll();
            }
            if (jM96I > 0) {
                updateConnectionFlowControl(jM96I);
            }
            Http2Stream.this.cancelStreamIfNecessary();
        }

        /* JADX WARN: Code duplicated, block: B:34:0x008c  */
        /* JADX WARN: Code duplicated, block: B:36:0x0090 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:37:0x0092 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:38:0x0093  */
        @Override // p066Ilil.I11li1
        public long read(I1I i1i, long j) throws Throwable {
            Throwable streamResetException;
            long j2;
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            while (true) {
                streamResetException = null;
                synchronized (Http2Stream.this) {
                    Http2Stream.this.readTimeout.enter();
                    try {
                        Http2Stream http2Stream = Http2Stream.this;
                        if (http2Stream.errorCode != null && (streamResetException = http2Stream.errorException) == null) {
                            streamResetException = new StreamResetException(Http2Stream.this.errorCode);
                        }
                        if (this.closed) {
                            throw new IOException("stream closed");
                        }
                        if (this.readBuffer.m96I() > 0) {
                            I1I i1i2 = this.readBuffer;
                            j2 = i1i2.read(i1i, Math.min(j, i1i2.m96I()));
                            Http2Stream http2Stream2 = Http2Stream.this;
                            long j3 = http2Stream2.unacknowledgedBytesRead + j2;
                            http2Stream2.unacknowledgedBytesRead = j3;
                            if (streamResetException != null || j3 < http2Stream2.connection.okHttpSettings.getInitialWindowSize() / 2) {
                                break;
                                break;
                            }
                            Http2Stream http2Stream3 = Http2Stream.this;
                            http2Stream3.connection.writeWindowUpdateLater(http2Stream3.f883id, http2Stream3.unacknowledgedBytesRead);
                            Http2Stream.this.unacknowledgedBytesRead = 0L;
                            break;
                        }
                        if (this.finished || streamResetException != null) {
                            j2 = -1;
                            break;
                        }
                        Http2Stream.this.waitForIo();
                        Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                    } catch (Throwable th) {
                        Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                        throw th;
                    }
                }
                if (j2 != -1) {
                    updateConnectionFlowControl(j2);
                    return j2;
                }
                if (streamResetException == null) {
                    return -1L;
                }
                throw streamResetException;
            }
            Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
            if (j2 != -1) {
                updateConnectionFlowControl(j2);
                return j2;
            }
            if (streamResetException == null) {
                return -1L;
            }
            throw streamResetException;
        }

        public void receive(lLi1LL lli1ll, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            long jM96I;
            while (j > 0) {
                synchronized (Http2Stream.this) {
                    z = this.finished;
                    z2 = true;
                    z3 = this.readBuffer.m96I() + j > this.maxByteCount;
                }
                if (z3) {
                    lli1ll.I11L(j);
                    Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    lli1ll.I11L(j);
                    return;
                }
                long j2 = lli1ll.read(this.receiveBuffer, j);
                if (j2 == -1) {
                    throw new EOFException();
                }
                j -= j2;
                synchronized (Http2Stream.this) {
                    if (this.closed) {
                        jM96I = this.receiveBuffer.m96I();
                        this.receiveBuffer.m2811();
                    } else {
                        if (this.readBuffer.m96I() != 0) {
                            z2 = false;
                        }
                        this.readBuffer.I11li1(this.receiveBuffer);
                        if (z2) {
                            Http2Stream.this.notifyAll();
                        }
                        jM96I = 0;
                    }
                }
                if (jM96I > 0) {
                    updateConnectionFlowControl(jM96I);
                }
            }
        }

        @Override // p066Ilil.I11li1, p066Ilil.iIlLiL
        public lL timeout() {
            return Http2Stream.this.readTimeout;
        }
    }

    public class StreamTimeout extends IL1Iii {
        public StreamTimeout() {
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        @Override // p066Ilil.IL1Iii
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // p066Ilil.IL1Iii
        public void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
            Http2Stream.this.connection.sendDegradedPingLater();
        }
    }

    public Http2Stream(int i, Http2Connection http2Connection, boolean z, boolean z2, @Nullable LlLLL llLLL) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.headersQueue = arrayDeque;
        this.readTimeout = new StreamTimeout();
        this.writeTimeout = new StreamTimeout();
        Objects.requireNonNull(http2Connection, "connection == null");
        this.f883id = i;
        this.connection = http2Connection;
        this.bytesLeftInWriteWindow = http2Connection.peerSettings.getInitialWindowSize();
        FramingSource framingSource = new FramingSource(http2Connection.okHttpSettings.getInitialWindowSize());
        this.source = framingSource;
        FramingSink framingSink = new FramingSink();
        this.sink = framingSink;
        framingSource.finished = z2;
        framingSink.finished = z;
        if (llLLL != null) {
            arrayDeque.add(llLLL);
        }
        if (isLocallyInitiated() && llLLL != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!isLocallyInitiated() && llLLL == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    private boolean closeInternal(ErrorCode errorCode, @Nullable IOException iOException) {
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            if (this.source.finished && this.sink.finished) {
                return false;
            }
            this.errorCode = errorCode;
            this.errorException = iOException;
            notifyAll();
            this.connection.removeStream(this.f883id);
            return true;
        }
    }

    public void addBytesToWriteWindow(long j) {
        this.bytesLeftInWriteWindow += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0017  */
    public void cancelStreamIfNecessary() throws IOException {
        boolean z;
        boolean zIsOpen;
        synchronized (this) {
            FramingSource framingSource = this.source;
            if (framingSource.finished || !framingSource.closed) {
                z = false;
            } else {
                FramingSink framingSink = this.sink;
                if (framingSink.finished || framingSink.closed) {
                    z = true;
                } else {
                    z = false;
                }
            }
            zIsOpen = isOpen();
        }
        if (z) {
            close(ErrorCode.CANCEL, null);
        } else {
            if (zIsOpen) {
                return;
            }
            this.connection.removeStream(this.f883id);
        }
    }

    public void checkOutNotClosed() throws IOException {
        FramingSink framingSink = this.sink;
        if (framingSink.closed) {
            throw new IOException("stream closed");
        }
        if (framingSink.finished) {
            throw new IOException("stream finished");
        }
        if (this.errorCode != null) {
            IOException iOException = this.errorException;
            if (iOException == null) {
                throw new StreamResetException(this.errorCode);
            }
        }
    }

    public void close(ErrorCode errorCode, @Nullable IOException iOException) throws IOException {
        if (closeInternal(errorCode, iOException)) {
            this.connection.writeSynReset(this.f883id, errorCode);
        }
    }

    public void closeLater(ErrorCode errorCode) {
        if (closeInternal(errorCode, null)) {
            this.connection.writeSynResetLater(this.f883id, errorCode);
        }
    }

    public void enqueueTrailers(LlLLL llLLL) {
        synchronized (this) {
            if (this.sink.finished) {
                throw new IllegalStateException("already finished");
            }
            if (llLLL.m2884IiL() == 0) {
                throw new IllegalArgumentException("trailers.size() == 0");
            }
            this.sink.trailers = llLLL;
        }
    }

    public Http2Connection getConnection() {
        return this.connection;
    }

    public synchronized ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public int getId() {
        return this.f883id;
    }

    public iIlLiL getSink() {
        synchronized (this) {
            if (!this.hasResponseHeaders && !isLocallyInitiated()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.sink;
    }

    public I11li1 getSource() {
        return this.source;
    }

    public boolean isLocallyInitiated() {
        return this.connection.client == ((this.f883id & 1) == 1);
    }

    public synchronized boolean isOpen() {
        if (this.errorCode != null) {
            return false;
        }
        FramingSource framingSource = this.source;
        if (framingSource.finished || framingSource.closed) {
            FramingSink framingSink = this.sink;
            if ((framingSink.finished || framingSink.closed) && this.hasResponseHeaders) {
                return false;
            }
        }
        return true;
    }

    public lL readTimeout() {
        return this.readTimeout;
    }

    public void receiveData(lLi1LL lli1ll, int i) throws IOException {
        this.source.receive(lli1ll, i);
    }

    public void receiveHeaders(LlLLL llLLL, boolean z) {
        boolean zIsOpen;
        synchronized (this) {
            if (this.hasResponseHeaders && z) {
                this.source.trailers = llLLL;
            } else {
                this.hasResponseHeaders = true;
                this.headersQueue.add(llLLL);
            }
            if (z) {
                this.source.finished = true;
            }
            zIsOpen = isOpen();
            notifyAll();
        }
        if (zIsOpen) {
            return;
        }
        this.connection.removeStream(this.f883id);
    }

    public synchronized void receiveRstStream(ErrorCode errorCode) {
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            notifyAll();
        }
    }

    public synchronized LlLLL takeHeaders() throws IOException {
        this.readTimeout.enter();
        while (this.headersQueue.isEmpty() && this.errorCode == null) {
            try {
                waitForIo();
            } catch (Throwable th) {
                this.readTimeout.exitAndThrowIfTimedOut();
                throw th;
            }
        }
        this.readTimeout.exitAndThrowIfTimedOut();
        if (this.headersQueue.isEmpty()) {
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            throw new StreamResetException(this.errorCode);
        }
        return this.headersQueue.removeFirst();
    }

    public synchronized LlLLL trailers() throws IOException {
        if (this.errorCode != null) {
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            throw new StreamResetException(this.errorCode);
        }
        FramingSource framingSource = this.source;
        if (!framingSource.finished || !framingSource.receiveBuffer.ILL() || !this.source.readBuffer.ILL()) {
            throw new IllegalStateException("too early; can't read the trailers yet");
        }
        return this.source.trailers != null ? this.source.trailers : Util.EMPTY_HEADERS;
    }

    public void waitForIo() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public void writeHeaders(List<Header> list, boolean z, boolean z2) throws IOException {
        Objects.requireNonNull(list, "headers == null");
        synchronized (this) {
            this.hasResponseHeaders = true;
            if (z) {
                this.sink.finished = true;
            }
        }
        if (!z2) {
            synchronized (this.connection) {
                z2 = this.connection.bytesLeftInWriteWindow == 0;
            }
        }
        this.connection.writeHeaders(this.f883id, z, list);
        if (z2) {
            this.connection.flush();
        }
    }

    public lL writeTimeout() {
        return this.writeTimeout;
    }
}
