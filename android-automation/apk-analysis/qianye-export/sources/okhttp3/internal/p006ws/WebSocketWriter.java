package okhttp3.internal.p006ws;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import p066Ilil.I1I;
import p066Ilil.IL;
import p066Ilil.iILLL1;
import p066Ilil.iIlLiL;
import p066Ilil.lL;

/* JADX INFO: loaded from: classes.dex */
public final class WebSocketWriter {
    public boolean activeWriter;
    public final I1I buffer = new I1I();
    public final FrameSink frameSink = new FrameSink();
    public final boolean isClient;
    private final I1I.C0590I1I maskCursor;
    private final byte[] maskKey;
    public final Random random;
    public final IL sink;
    public final I1I sinkBuffer;
    public boolean writerClosed;

    public final class FrameSink implements iIlLiL {
        public boolean closed;
        public long contentLength;
        public int formatOpcode;
        public boolean isFirstFrame;

        public FrameSink() {
        }

        @Override // p066Ilil.iIlLiL, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            WebSocketWriter webSocketWriter = WebSocketWriter.this;
            webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.m96I(), this.isFirstFrame, true);
            this.closed = true;
            WebSocketWriter.this.activeWriter = false;
        }

        @Override // p066Ilil.iIlLiL, java.io.Flushable
        public void flush() throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            WebSocketWriter webSocketWriter = WebSocketWriter.this;
            webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.m96I(), this.isFirstFrame, false);
            this.isFirstFrame = false;
        }

        @Override // p066Ilil.iIlLiL
        public lL timeout() {
            return WebSocketWriter.this.sink.timeout();
        }

        @Override // p066Ilil.iIlLiL
        public void write(I1I i1i, long j) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            WebSocketWriter.this.buffer.write(i1i, j);
            boolean z = this.isFirstFrame && this.contentLength != -1 && WebSocketWriter.this.buffer.m96I() > this.contentLength - 8192;
            long jM2780LlIl = WebSocketWriter.this.buffer.m2780LlIl();
            if (jM2780LlIl <= 0 || z) {
                return;
            }
            WebSocketWriter.this.writeMessageFrame(this.formatOpcode, jM2780LlIl, this.isFirstFrame, false);
            this.isFirstFrame = false;
        }
    }

    public WebSocketWriter(boolean z, IL il, Random random) {
        Objects.requireNonNull(il, "sink == null");
        Objects.requireNonNull(random, "random == null");
        this.isClient = z;
        this.sink = il;
        this.sinkBuffer = il.IL1Iii();
        this.random = random;
        this.maskKey = z ? new byte[4] : null;
        this.maskCursor = z ? new I1I.C0590I1I() : null;
    }

    private void writeControlFrame(int i, iILLL1 iilll1) throws IOException {
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        int size = iilll1.size();
        if (size > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.sinkBuffer.l1Lll(i | 128);
        if (this.isClient) {
            this.sinkBuffer.l1Lll(size | 128);
            this.random.nextBytes(this.maskKey);
            this.sinkBuffer.L1iI1(this.maskKey);
            if (size > 0) {
                long jM96I = this.sinkBuffer.m96I();
                this.sinkBuffer.m2803i11i(iilll1);
                this.sinkBuffer.iIilII1(this.maskCursor);
                this.maskCursor.m2813(jM96I);
                WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.l1Lll(size);
            this.sinkBuffer.m2803i11i(iilll1);
        }
        this.sink.flush();
    }

    public iIlLiL newMessageSink(int i, long j) {
        if (this.activeWriter) {
            throw new IllegalStateException("Another message writer is active. Did you call close()?");
        }
        this.activeWriter = true;
        FrameSink frameSink = this.frameSink;
        frameSink.formatOpcode = i;
        frameSink.contentLength = j;
        frameSink.isFirstFrame = true;
        frameSink.closed = false;
        return frameSink;
    }

    public void writeClose(int i, iILLL1 iilll1) throws IOException {
        iILLL1 iilll1M98i1 = iILLL1.EMPTY;
        if (i != 0 || iilll1 != null) {
            if (i != 0) {
                WebSocketProtocol.validateCloseCode(i);
            }
            I1I i1i = new I1I();
            i1i.m2787iIl1il(i);
            if (iilll1 != null) {
                i1i.m2803i11i(iilll1);
            }
            iilll1M98i1 = i1i.m98i1();
        }
        try {
            writeControlFrame(8, iilll1M98i1);
        } finally {
            this.writerClosed = true;
        }
    }

    public void writeMessageFrame(int i, long j, boolean z, boolean z2) throws IOException {
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        if (!z) {
            i = 0;
        }
        if (z2) {
            i |= 128;
        }
        this.sinkBuffer.l1Lll(i);
        int i2 = this.isClient ? 128 : 0;
        if (j <= 125) {
            this.sinkBuffer.l1Lll(((int) j) | i2);
        } else if (j <= 65535) {
            this.sinkBuffer.l1Lll(i2 | 126);
            this.sinkBuffer.m2787iIl1il((int) j);
        } else {
            this.sinkBuffer.l1Lll(i2 | 127);
            this.sinkBuffer.m2804i11LL(j);
        }
        if (this.isClient) {
            this.random.nextBytes(this.maskKey);
            this.sinkBuffer.L1iI1(this.maskKey);
            if (j > 0) {
                long jM96I = this.sinkBuffer.m96I();
                this.sinkBuffer.write(this.buffer, j);
                this.sinkBuffer.iIilII1(this.maskCursor);
                this.maskCursor.m2813(jM96I);
                WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.write(this.buffer, j);
        }
        this.sink.I1I();
    }

    public void writePing(iILLL1 iilll1) throws IOException {
        writeControlFrame(9, iilll1);
    }

    public void writePong(iILLL1 iilll1) throws IOException {
        writeControlFrame(10, iilll1);
    }
}
