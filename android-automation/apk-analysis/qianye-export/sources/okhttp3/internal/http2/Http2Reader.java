package okhttp3.internal.http2;

import com.mysql.jdbc.StatementImpl;
import com.tencent.smtt.export.external.interfaces.ISelectionInterface;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import p066Ilil.I11li1;
import p066Ilil.I1I;
import p066Ilil.iILLL1;
import p066Ilil.lL;
import p066Ilil.lLi1LL;

/* JADX INFO: loaded from: classes.dex */
public final class Http2Reader implements Closeable {
    public static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private final ContinuationSource continuation;
    public final Hpack.Reader hpackReader;
    private final lLi1LL source;

    public static final class ContinuationSource implements I11li1 {
        public byte flags;
        public int left;
        public int length;
        public short padding;
        private final lLi1LL source;
        public int streamId;

        public ContinuationSource(lLi1LL lli1ll) {
            this.source = lli1ll;
        }

        private void readContinuationHeader() throws IOException {
            int i = this.streamId;
            int medium = Http2Reader.readMedium(this.source);
            this.left = medium;
            this.length = medium;
            byte bMo2798lIlii = (byte) (this.source.mo2798lIlii() & StatementImpl.USES_VARIABLES_UNKNOWN);
            this.flags = (byte) (this.source.mo2798lIlii() & StatementImpl.USES_VARIABLES_UNKNOWN);
            Logger logger = Http2Reader.logger;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Http2.frameLog(true, this.streamId, this.length, bMo2798lIlii, this.flags));
            }
            int iIlil = this.source.Ilil() & Integer.MAX_VALUE;
            this.streamId = iIlil;
            if (bMo2798lIlii != 9) {
                throw Http2.ioException("%s != TYPE_CONTINUATION", Byte.valueOf(bMo2798lIlii));
            }
            if (iIlil != i) {
                throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // p066Ilil.I11li1, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // p066Ilil.I11li1
        public long read(I1I i1i, long j) throws IOException {
            while (true) {
                int i = this.left;
                if (i != 0) {
                    long j2 = this.source.read(i1i, Math.min(j, i));
                    if (j2 == -1) {
                        return -1L;
                    }
                    this.left = (int) (((long) this.left) - j2);
                    return j2;
                }
                this.source.I11L(this.padding);
                this.padding = (short) 0;
                if ((this.flags & 4) != 0) {
                    return -1L;
                }
                readContinuationHeader();
            }
        }

        @Override // p066Ilil.I11li1, p066Ilil.iIlLiL
        public lL timeout() {
            return this.source.timeout();
        }
    }

    public interface Handler {
        void ackSettings();

        void alternateService(int i, String str, iILLL1 iilll1, String str2, int i2, long j);

        void data(boolean z, int i, lLi1LL lli1ll, int i2) throws IOException;

        void goAway(int i, ErrorCode errorCode, iILLL1 iilll1);

        void headers(boolean z, int i, int i2, List<Header> list);

        void ping(boolean z, int i, int i2);

        void priority(int i, int i2, int i3, boolean z);

        void pushPromise(int i, int i2, List<Header> list) throws IOException;

        void rstStream(int i, ErrorCode errorCode);

        void settings(boolean z, Settings settings);

        void windowUpdate(int i, long j);
    }

    public Http2Reader(lLi1LL lli1ll, boolean z) {
        this.source = lli1ll;
        this.client = z;
        ContinuationSource continuationSource = new ContinuationSource(lli1ll);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(4096, continuationSource);
    }

    public static int lengthWithoutPadding(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw Http2.ioException("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }

    private void readData(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        if ((b & 32) != 0) {
            throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short sMo2798lIlii = (b & 8) != 0 ? (short) (this.source.mo2798lIlii() & StatementImpl.USES_VARIABLES_UNKNOWN) : (short) 0;
        handler.data(z, i2, this.source, lengthWithoutPadding(i, b, sMo2798lIlii));
        this.source.I11L(sMo2798lIlii);
    }

    private void readGoAway(Handler handler, int i, byte b, int i2) throws IOException {
        if (i < 8) {
            throw Http2.ioException("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int iIlil = this.source.Ilil();
        int iIlil2 = this.source.Ilil();
        int i3 = i - 8;
        ErrorCode errorCodeFromHttp2 = ErrorCode.fromHttp2(iIlil2);
        if (errorCodeFromHttp2 == null) {
            throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(iIlil2));
        }
        iILLL1 iilll1ILil = iILLL1.EMPTY;
        if (i3 > 0) {
            iilll1ILil = this.source.ILil(i3);
        }
        handler.goAway(iIlil, errorCodeFromHttp2, iilll1ILil);
    }

    private List<Header> readHeaderBlock(int i, short s, byte b, int i2) throws IOException {
        ContinuationSource continuationSource = this.continuation;
        continuationSource.left = i;
        continuationSource.length = i;
        continuationSource.padding = s;
        continuationSource.flags = b;
        continuationSource.streamId = i2;
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private void readHeaders(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        short sMo2798lIlii = (b & 8) != 0 ? (short) (this.source.mo2798lIlii() & StatementImpl.USES_VARIABLES_UNKNOWN) : (short) 0;
        if ((b & 32) != 0) {
            readPriority(handler, i2);
            i -= 5;
        }
        handler.headers(z, i2, -1, readHeaderBlock(lengthWithoutPadding(i, b, sMo2798lIlii), sMo2798lIlii, b, i2));
    }

    public static int readMedium(lLi1LL lli1ll) throws IOException {
        return (lli1ll.mo2798lIlii() & StatementImpl.USES_VARIABLES_UNKNOWN) | ((lli1ll.mo2798lIlii() & StatementImpl.USES_VARIABLES_UNKNOWN) << 16) | ((lli1ll.mo2798lIlii() & StatementImpl.USES_VARIABLES_UNKNOWN) << 8);
    }

    private void readPing(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 8) {
            throw Http2.ioException("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
        }
        handler.ping((b & 1) != 0, this.source.Ilil(), this.source.Ilil());
    }

    private void readPriority(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 5) {
            throw Http2.ioException("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        readPriority(handler, i2);
    }

    private void readPushPromise(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short sMo2798lIlii = (b & 8) != 0 ? (short) (this.source.mo2798lIlii() & StatementImpl.USES_VARIABLES_UNKNOWN) : (short) 0;
        handler.pushPromise(i2, this.source.Ilil() & Integer.MAX_VALUE, readHeaderBlock(lengthWithoutPadding(i - 4, b, sMo2798lIlii), sMo2798lIlii, b, i2));
    }

    private void readRstStream(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int iIlil = this.source.Ilil();
        ErrorCode errorCodeFromHttp2 = ErrorCode.fromHttp2(iIlil);
        if (errorCodeFromHttp2 == null) {
            throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(iIlil));
        }
        handler.rstStream(i2, errorCodeFromHttp2);
    }

    private void readSettings(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            throw Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b & 1) != 0) {
            if (i != 0) {
                throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            handler.ackSettings();
            return;
        }
        if (i % 6 != 0) {
            throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
        Settings settings = new Settings();
        for (int i3 = 0; i3 < i; i3 += 6) {
            int iMo101 = this.source.mo101() & ISelectionInterface.HELD_NOTHING;
            int iIlil = this.source.Ilil();
            if (iMo101 == 2) {
                if (iIlil != 0 && iIlil != 1) {
                    throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
            } else if (iMo101 == 3) {
                iMo101 = 4;
            } else if (iMo101 == 4) {
                iMo101 = 7;
                if (iIlil < 0) {
                    throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                }
            } else if (iMo101 == 5 && (iIlil < 16384 || iIlil > 16777215)) {
                throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(iIlil));
            }
            settings.set(iMo101, iIlil);
        }
        handler.settings(false, settings);
    }

    private void readWindowUpdate(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long jIlil = ((long) this.source.Ilil()) & 2147483647L;
        if (jIlil == 0) {
            throw Http2.ioException("windowSizeIncrement was 0", Long.valueOf(jIlil));
        }
        handler.windowUpdate(i2, jIlil);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }

    public boolean nextFrame(boolean z, Handler handler) throws IOException {
        try {
            this.source.llI(9L);
            int medium = readMedium(this.source);
            if (medium < 0 || medium > 16384) {
                throw Http2.ioException("FRAME_SIZE_ERROR: %s", Integer.valueOf(medium));
            }
            byte bMo2798lIlii = (byte) (this.source.mo2798lIlii() & StatementImpl.USES_VARIABLES_UNKNOWN);
            if (z && bMo2798lIlii != 4) {
                throw Http2.ioException("Expected a SETTINGS frame but was %s", Byte.valueOf(bMo2798lIlii));
            }
            byte bMo2798lIlii2 = (byte) (this.source.mo2798lIlii() & StatementImpl.USES_VARIABLES_UNKNOWN);
            int iIlil = this.source.Ilil() & Integer.MAX_VALUE;
            Logger logger2 = logger;
            if (logger2.isLoggable(Level.FINE)) {
                logger2.fine(Http2.frameLog(true, iIlil, medium, bMo2798lIlii, bMo2798lIlii2));
            }
            switch (bMo2798lIlii) {
                case 0:
                    readData(handler, medium, bMo2798lIlii2, iIlil);
                    return true;
                case 1:
                    readHeaders(handler, medium, bMo2798lIlii2, iIlil);
                    return true;
                case 2:
                    readPriority(handler, medium, bMo2798lIlii2, iIlil);
                    return true;
                case 3:
                    readRstStream(handler, medium, bMo2798lIlii2, iIlil);
                    return true;
                case 4:
                    readSettings(handler, medium, bMo2798lIlii2, iIlil);
                    return true;
                case 5:
                    readPushPromise(handler, medium, bMo2798lIlii2, iIlil);
                    return true;
                case 6:
                    readPing(handler, medium, bMo2798lIlii2, iIlil);
                    return true;
                case 7:
                    readGoAway(handler, medium, bMo2798lIlii2, iIlil);
                    return true;
                case 8:
                    readWindowUpdate(handler, medium, bMo2798lIlii2, iIlil);
                    return true;
                default:
                    this.source.I11L(medium);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public void readConnectionPreface(Handler handler) throws IOException {
        if (this.client) {
            if (!nextFrame(true, handler)) {
                throw Http2.ioException("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        lLi1LL lli1ll = this.source;
        iILLL1 iilll1 = Http2.CONNECTION_PREFACE;
        iILLL1 iilll1ILil = lli1ll.ILil(iilll1.size());
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Util.format("<< CONNECTION %s", iilll1ILil.hex()));
        }
        if (!iilll1.equals(iilll1ILil)) {
            throw Http2.ioException("Expected a connection header but was %s", iilll1ILil.utf8());
        }
    }

    private void readPriority(Handler handler, int i) throws IOException {
        int iIlil = this.source.Ilil();
        handler.priority(i, iIlil & Integer.MAX_VALUE, (this.source.mo2798lIlii() & StatementImpl.USES_VARIABLES_UNKNOWN) + 1, (Integer.MIN_VALUE & iIlil) != 0);
    }
}
