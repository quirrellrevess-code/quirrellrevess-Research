package okhttp3.internal.p006ws;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import p047IL.C0007;
import p047IL.IIi;
import p047IL.ILL;
import p047IL.L11;
import p047IL.L1l;
import p047IL.Ll1;
import p047IL.LlIl;
import p047IL.llI;
import p047IL.llliI;
import p066Ilil.IL;
import p066Ilil.iILLL1;
import p066Ilil.lIiI;
import p066Ilil.lLi1LL;

/* JADX INFO: loaded from: classes.dex */
public final class RealWebSocket implements L11, WebSocketReader.FrameCallback {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private static final List<llI> ONLY_HTTP1 = Collections.singletonList(llI.HTTP_1_1);
    private boolean awaitingPong;
    private ILL call;
    private ScheduledFuture<?> cancelFuture;
    private boolean enqueuedClose;
    private ScheduledExecutorService executor;
    private boolean failed;
    private final String key;
    public final LlIl listener;
    private final L1l originalRequest;
    private final long pingIntervalMillis;
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private WebSocketWriter writer;
    private final Runnable writerRunnable;
    private final ArrayDeque<iILLL1> pongQueue = new ArrayDeque<>();
    private final ArrayDeque<Object> messageAndCloseQueue = new ArrayDeque<>();
    private int receivedCloseCode = -1;

    public final class CancelRunnable implements Runnable {
        public CancelRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RealWebSocket.this.cancel();
        }
    }

    public static final class Close {
        public final long cancelAfterCloseMillis;
        public final int code;
        public final iILLL1 reason;

        public Close(int i, iILLL1 iilll1, long j) {
            this.code = i;
            this.reason = iilll1;
            this.cancelAfterCloseMillis = j;
        }
    }

    public static final class Message {
        public final iILLL1 data;
        public final int formatOpcode;

        public Message(int i, iILLL1 iilll1) {
            this.formatOpcode = i;
            this.data = iilll1;
        }
    }

    public final class PingRunnable implements Runnable {
        public PingRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RealWebSocket.this.writePingFrame();
        }
    }

    public static abstract class Streams implements Closeable {
        public final boolean client;
        public final IL sink;
        public final lLi1LL source;

        public Streams(boolean z, lLi1LL lli1ll, IL il) {
            this.client = z;
            this.source = lli1ll;
            this.sink = il;
        }
    }

    public RealWebSocket(L1l l1l, LlIl llIl, Random random, long j) {
        if (!"GET".equals(l1l.m2873iILLL1())) {
            throw new IllegalArgumentException("Request must be GET: " + l1l.m2873iILLL1());
        }
        this.originalRequest = l1l;
        this.random = random;
        this.pingIntervalMillis = j;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.key = iILLL1.m103of(bArr).base64();
        this.writerRunnable = new Runnable() { // from class: I丨L.IIi丨丨I.I丨L.IL1Iii
            @Override // java.lang.Runnable
            public final void run() {
                this.f4609ILil.ILil();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void ILil() {
        do {
            try {
            } catch (IOException e) {
                failWebSocket(e, null);
                return;
            }
        } while (writeOneFrame());
    }

    private void runWriter() {
        ScheduledExecutorService scheduledExecutorService = this.executor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(this.writerRunnable);
        }
    }

    public void awaitTermination(int i, TimeUnit timeUnit) throws InterruptedException {
        this.executor.awaitTermination(i, timeUnit);
    }

    public void cancel() {
        this.call.cancel();
    }

    public void checkUpgradeSuccess(IIi iIi, @Nullable Exchange exchange) throws IOException {
        if (iIi.m2847L11() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + iIi.m2847L11() + " " + iIi.m2843I1L11L() + "'");
        }
        String strM2844IIiI = iIi.m2844IIiI("Connection");
        if (!"Upgrade".equalsIgnoreCase(strM2844IIiI)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + strM2844IIiI + "'");
        }
        String strM2844IIiI2 = iIi.m2844IIiI("Upgrade");
        if (!"websocket".equalsIgnoreCase(strM2844IIiI2)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + strM2844IIiI2 + "'");
        }
        String strM2844IIiI3 = iIi.m2844IIiI("Sec-WebSocket-Accept");
        String strBase64 = iILLL1.encodeUtf8(this.key + WebSocketProtocol.ACCEPT_MAGIC).sha1().base64();
        if (strBase64.equals(strM2844IIiI3)) {
            if (exchange == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strBase64 + "' but was '" + strM2844IIiI3 + "'");
    }

    public boolean close(int i, String str) {
        return close(i, str, CANCEL_AFTER_CLOSE_MILLIS);
    }

    public void connect(C0007 c0007) {
        C0007.ILil iLilIIi1 = c0007.iIi1();
        iLilIIi1.I1I(llliI.f4683IL1Iii);
        iLilIIi1.m2980IL(ONLY_HTTP1);
        C0007 c0007IL1Iii = iLilIIi1.IL1Iii();
        L1l.IL1Iii iL1IiiM2871IiL = this.originalRequest.m2871IiL();
        iL1IiiM2871IiL.I1I("Upgrade", "websocket");
        iL1IiiM2871IiL.I1I("Connection", "Upgrade");
        iL1IiiM2871IiL.I1I("Sec-WebSocket-Key", this.key);
        iL1IiiM2871IiL.I1I("Sec-WebSocket-Version", "13");
        final L1l l1lILil = iL1IiiM2871IiL.ILil();
        ILL illNewWebSocketCall = Internal.instance.newWebSocketCall(c0007IL1Iii, l1lILil);
        this.call = illNewWebSocketCall;
        illNewWebSocketCall.mo2842IiL(new Ll1() { // from class: okhttp3.internal.ws.RealWebSocket.1
            @Override // p047IL.Ll1
            public void onFailure(ILL ill, IOException iOException) {
                RealWebSocket.this.failWebSocket(iOException, null);
            }

            @Override // p047IL.Ll1
            public void onResponse(ILL ill, IIi iIi) {
                Exchange exchange = Internal.instance.exchange(iIi);
                try {
                    RealWebSocket.this.checkUpgradeSuccess(iIi, exchange);
                    try {
                        RealWebSocket.this.initReaderAndWriter("OkHttp WebSocket " + l1lILil.m2875il().m2912lIII(), exchange.newWebSocketStreams());
                        RealWebSocket realWebSocket = RealWebSocket.this;
                        realWebSocket.listener.m2869lLi1LL(realWebSocket, iIi);
                        RealWebSocket.this.loopReader();
                    } catch (Exception e) {
                        RealWebSocket.this.failWebSocket(e, null);
                    }
                } catch (IOException e2) {
                    if (exchange != null) {
                        exchange.webSocketUpgradeFailed();
                    }
                    RealWebSocket.this.failWebSocket(e2, iIi);
                    Util.closeQuietly(iIi);
                }
            }
        });
    }

    public void failWebSocket(Exception exc, @Nullable IIi iIi) {
        synchronized (this) {
            if (this.failed) {
                return;
            }
            this.failed = true;
            Streams streams = this.streams;
            this.streams = null;
            ScheduledFuture<?> scheduledFuture = this.cancelFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            ScheduledExecutorService scheduledExecutorService = this.executor;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
            }
            try {
                this.listener.I1I(this, exc, iIi);
            } finally {
                Util.closeQuietly(streams);
            }
        }
    }

    public void initReaderAndWriter(String str, Streams streams) throws IOException {
        synchronized (this) {
            this.streams = streams;
            this.writer = new WebSocketWriter(streams.client, streams.sink, this.random);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(str, false));
            this.executor = scheduledThreadPoolExecutor;
            if (this.pingIntervalMillis != 0) {
                PingRunnable pingRunnable = new PingRunnable();
                long j = this.pingIntervalMillis;
                scheduledThreadPoolExecutor.scheduleAtFixedRate(pingRunnable, j, j, TimeUnit.MILLISECONDS);
            }
            if (!this.messageAndCloseQueue.isEmpty()) {
                runWriter();
            }
        }
        this.reader = new WebSocketReader(streams.client, streams.source, this);
    }

    public void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            this.reader.processNextFrame();
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int i, String str) {
        Streams streams;
        if (i == -1) {
            throw new IllegalArgumentException();
        }
        synchronized (this) {
            if (this.receivedCloseCode != -1) {
                throw new IllegalStateException("already closed");
            }
            this.receivedCloseCode = i;
            this.receivedCloseReason = str;
            streams = null;
            if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                Streams streams2 = this.streams;
                this.streams = null;
                ScheduledFuture<?> scheduledFuture = this.cancelFuture;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.executor.shutdown();
                streams = streams2;
            }
        }
        try {
            this.listener.ILil(this, i, str);
            if (streams != null) {
                this.listener.IL1Iii(this, i, str);
            }
        } finally {
            Util.closeQuietly(streams);
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String str) throws IOException {
        this.listener.m2868IL(this, str);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(iILLL1 iilll1) {
        if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
            this.pongQueue.add(iilll1);
            runWriter();
            this.receivedPingCount++;
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(iILLL1 iilll1) {
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    public synchronized boolean pong(iILLL1 iilll1) {
        if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
            this.pongQueue.add(iilll1);
            runWriter();
            return true;
        }
        return false;
    }

    public boolean processNextFrame() throws IOException {
        try {
            this.reader.processNextFrame();
            return this.receivedCloseCode == -1;
        } catch (Exception e) {
            failWebSocket(e, null);
            return false;
        }
    }

    public synchronized long queueSize() {
        return this.queueSize;
    }

    public synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    public synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    public L1l request() {
        return this.originalRequest;
    }

    public boolean send(String str) {
        Objects.requireNonNull(str, "text == null");
        return send(iILLL1.encodeUtf8(str), 1);
    }

    public synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    public void tearDown() throws InterruptedException {
        ScheduledFuture<?> scheduledFuture = this.cancelFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.executor.shutdown();
        this.executor.awaitTermination(10L, TimeUnit.SECONDS);
    }

    public boolean writeOneFrame() throws IOException {
        Streams streams;
        String str;
        synchronized (this) {
            if (this.failed) {
                return false;
            }
            WebSocketWriter webSocketWriter = this.writer;
            iILLL1 iilll1Poll = this.pongQueue.poll();
            int i = -1;
            Object obj = null;
            if (iilll1Poll == null) {
                Object objPoll = this.messageAndCloseQueue.poll();
                if (objPoll instanceof Close) {
                    int i2 = this.receivedCloseCode;
                    str = this.receivedCloseReason;
                    if (i2 != -1) {
                        Streams streams2 = this.streams;
                        this.streams = null;
                        this.executor.shutdown();
                        obj = objPoll;
                        i = i2;
                        streams = streams2;
                    } else {
                        this.cancelFuture = this.executor.schedule(new CancelRunnable(), ((Close) objPoll).cancelAfterCloseMillis, TimeUnit.MILLISECONDS);
                        i = i2;
                        streams = null;
                    }
                } else {
                    if (objPoll == null) {
                        return false;
                    }
                    streams = null;
                    str = null;
                }
                obj = objPoll;
            } else {
                streams = null;
                str = null;
            }
            try {
                if (iilll1Poll != null) {
                    webSocketWriter.writePong(iilll1Poll);
                } else if (obj instanceof Message) {
                    iILLL1 iilll1 = ((Message) obj).data;
                    IL ilI1I = lIiI.I1I(webSocketWriter.newMessageSink(((Message) obj).formatOpcode, iilll1.size()));
                    ilI1I.LL1IL(iilll1);
                    ilI1I.close();
                    synchronized (this) {
                        this.queueSize -= (long) iilll1.size();
                    }
                } else {
                    if (!(obj instanceof Close)) {
                        throw new AssertionError();
                    }
                    Close close = (Close) obj;
                    webSocketWriter.writeClose(close.code, close.reason);
                    if (streams != null) {
                        this.listener.IL1Iii(this, i, str);
                    }
                }
                Util.closeQuietly(streams);
                return true;
            } catch (Throwable th) {
                Util.closeQuietly(streams);
                throw th;
            }
        }
    }

    public void writePingFrame() {
        synchronized (this) {
            if (this.failed) {
                return;
            }
            WebSocketWriter webSocketWriter = this.writer;
            int i = this.awaitingPong ? this.sentPingCount : -1;
            this.sentPingCount++;
            this.awaitingPong = true;
            if (i == -1) {
                try {
                    webSocketWriter.writePing(iILLL1.EMPTY);
                    return;
                } catch (IOException e) {
                    failWebSocket(e, null);
                    return;
                }
            }
            failWebSocket(new SocketTimeoutException("sent ping but didn't receive pong within " + this.pingIntervalMillis + "ms (after " + (i - 1) + " successful ping/pongs)"), null);
        }
    }

    public synchronized boolean close(int i, String str, long j) {
        WebSocketProtocol.validateCloseCode(i);
        iILLL1 iilll1EncodeUtf8 = null;
        if (str != null) {
            iilll1EncodeUtf8 = iILLL1.encodeUtf8(str);
            if (iilll1EncodeUtf8.size() > 123) {
                throw new IllegalArgumentException("reason.size() > 123: " + str);
            }
        }
        if (!this.failed && !this.enqueuedClose) {
            this.enqueuedClose = true;
            this.messageAndCloseQueue.add(new Close(i, iilll1EncodeUtf8, j));
            runWriter();
            return true;
        }
        return false;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(iILLL1 iilll1) throws IOException {
        this.listener.Ilil(this, iilll1);
    }

    public boolean send(iILLL1 iilll1) {
        Objects.requireNonNull(iilll1, "bytes == null");
        return send(iilll1, 2);
    }

    private synchronized boolean send(iILLL1 iilll1, int i) {
        if (!this.failed && !this.enqueuedClose) {
            if (this.queueSize + ((long) iilll1.size()) > MAX_QUEUE_SIZE) {
                close(1001, null);
                return false;
            }
            this.queueSize += (long) iilll1.size();
            this.messageAndCloseQueue.add(new Message(i, iilll1));
            runWriter();
            return true;
        }
        return false;
    }
}
