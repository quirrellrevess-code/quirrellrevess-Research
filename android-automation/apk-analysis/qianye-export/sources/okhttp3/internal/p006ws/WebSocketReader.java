package okhttp3.internal.p006ws;

import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.StatementImpl;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import p066Ilil.I1I;
import p066Ilil.iILLL1;
import p066Ilil.lLi1LL;

/* JADX INFO: loaded from: classes.dex */
public final class WebSocketReader {
    public boolean closed;
    public final FrameCallback frameCallback;
    public long frameLength;
    public final boolean isClient;
    public boolean isControlFrame;
    public boolean isFinalFrame;
    private final I1I.C0590I1I maskCursor;
    private final byte[] maskKey;
    public int opcode;
    public final lLi1LL source;
    private final I1I controlFrameBuffer = new I1I();
    private final I1I messageFrameBuffer = new I1I();

    public interface FrameCallback {
        void onReadClose(int i, String str);

        void onReadMessage(iILLL1 iilll1) throws IOException;

        void onReadMessage(String str) throws IOException;

        void onReadPing(iILLL1 iilll1);

        void onReadPong(iILLL1 iilll1);
    }

    public WebSocketReader(boolean z, lLi1LL lli1ll, FrameCallback frameCallback) {
        Objects.requireNonNull(lli1ll, "source == null");
        Objects.requireNonNull(frameCallback, "frameCallback == null");
        this.isClient = z;
        this.source = lli1ll;
        this.frameCallback = frameCallback;
        this.maskKey = z ? null : new byte[4];
        this.maskCursor = z ? null : new I1I.C0590I1I();
    }

    private void readControlFrame() throws IOException {
        String strMo2785LlLLL;
        long j = this.frameLength;
        if (j > 0) {
            this.source.mo2796lIiI(this.controlFrameBuffer, j);
            if (!this.isClient) {
                this.controlFrameBuffer.iIilII1(this.maskCursor);
                this.maskCursor.m2813(0L);
                WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                short sMo101 = 1005;
                long jM96I = this.controlFrameBuffer.m96I();
                if (jM96I == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (jM96I != 0) {
                    sMo101 = this.controlFrameBuffer.mo101();
                    strMo2785LlLLL = this.controlFrameBuffer.mo2785LlLLL();
                    String strCloseCodeExceptionMessage = WebSocketProtocol.closeCodeExceptionMessage(sMo101);
                    if (strCloseCodeExceptionMessage != null) {
                        throw new ProtocolException(strCloseCodeExceptionMessage);
                    }
                } else {
                    strMo2785LlLLL = BuildConfig.FLAVOR;
                }
                this.frameCallback.onReadClose(sMo101, strMo2785LlLLL);
                this.closed = true;
                return;
            case 9:
                this.frameCallback.onReadPing(this.controlFrameBuffer.m98i1());
                return;
            case 10:
                this.frameCallback.onReadPong(this.controlFrameBuffer.m98i1());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.opcode));
        }
    }

    private void readHeader() throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        long jTimeoutNanos = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        try {
            int iMo2798lIlii = this.source.mo2798lIlii() & StatementImpl.USES_VARIABLES_UNKNOWN;
            this.source.timeout().timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            this.opcode = iMo2798lIlii & 15;
            boolean z = (iMo2798lIlii & 128) != 0;
            this.isFinalFrame = z;
            boolean z2 = (iMo2798lIlii & 8) != 0;
            this.isControlFrame = z2;
            if (z2 && !z) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z3 = (iMo2798lIlii & 64) != 0;
            boolean z4 = (iMo2798lIlii & 32) != 0;
            boolean z5 = (iMo2798lIlii & 16) != 0;
            if (z3 || z4 || z5) {
                throw new ProtocolException("Reserved flags are unsupported.");
            }
            int iMo2798lIlii2 = this.source.mo2798lIlii() & StatementImpl.USES_VARIABLES_UNKNOWN;
            boolean z6 = (iMo2798lIlii2 & 128) != 0;
            if (z6 == this.isClient) {
                throw new ProtocolException(this.isClient ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j = iMo2798lIlii2 & 127;
            this.frameLength = j;
            if (j == 126) {
                this.frameLength = ((long) this.source.mo101()) & 65535;
            } else if (j == 127) {
                long jMo2788iILLL1 = this.source.mo2788iILLL1();
                this.frameLength = jMo2788iILLL1;
                if (jMo2788iILLL1 < 0) {
                    throw new ProtocolException("Frame length 0x" + Long.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.isControlFrame && this.frameLength > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z6) {
                this.source.iIlLiL(this.maskKey);
            }
        } catch (Throwable th) {
            this.source.timeout().timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    private void readMessage() throws IOException {
        while (!this.closed) {
            long j = this.frameLength;
            if (j > 0) {
                this.source.mo2796lIiI(this.messageFrameBuffer, j);
                if (!this.isClient) {
                    this.messageFrameBuffer.iIilII1(this.maskCursor);
                    this.maskCursor.m2813(this.messageFrameBuffer.m96I() - this.frameLength);
                    WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            if (this.isFinalFrame) {
                return;
            }
            readUntilNonControlFrame();
            if (this.opcode != 0) {
                throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.opcode));
            }
        }
        throw new IOException("closed");
    }

    private void readMessageFrame() throws IOException {
        int i = this.opcode;
        if (i != 1 && i != 2) {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i));
        }
        readMessage();
        if (i == 1) {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.mo2785LlLLL());
        } else {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.m98i1());
        }
    }

    private void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            readHeader();
            if (!this.isControlFrame) {
                return;
            } else {
                readControlFrame();
            }
        }
    }

    public void processNextFrame() throws IOException {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }
}
