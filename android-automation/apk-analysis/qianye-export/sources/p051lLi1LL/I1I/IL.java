package p051lLi1LL.I1I;

import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.MysqlErrorNumbers;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import javax.net.ssl.SSLSession;
import p051lLi1LL.I1I.p053IiL.IL1Iii;
import p051lLi1LL.I1I.p054Ll1.iILLL1;
import p051lLi1LL.I1I.p055L11I.lLi1LL;
import p051lLi1LL.I1I.p057lIiI.L11I;
import p051lLi1LL.I1I.p058il.C0675il;
import p051lLi1LL.I1I.p058il.IiL;
import p051lLi1LL.p060IL.I1I;
import p051lLi1LL.p060IL.ILil;

/* JADX INFO: renamed from: l丨Li1LL.I1I.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: WebSocketImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class IL implements ILil {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final BlockingQueue<ByteBuffer> f5437I1I;
    public lLi1LL ILL;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public SelectionKey f5439Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final lLi1LL f2972IL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public List<IL1Iii> f2975L11I;
    public Object iIlLiL;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public ByteChannel f2980lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public IL1Iii f2981il;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final ILil f5438ILil = I1I.m3681L11I(IL.class);

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public boolean f2976iILLL1 = false;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public volatile p051lLi1LL.I1I.p055L11I.IL f2973IiL = p051lLi1LL.I1I.p055L11I.IL.NOT_YET_CONNECTED;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public ByteBuffer f2974Ll1 = ByteBuffer.allocate(0);

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public p051lLi1LL.I1I.p057lIiI.IL1Iii f2977lIiI = null;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public String f2971ILl = null;
    public Integer Lil = null;
    public Boolean LlLI1 = null;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public String f2979llL1ii = null;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public long f2978lIlii = System.nanoTime();
    public final Object iIi1 = new Object();

    public IL(lLi1LL lli1ll, IL1Iii iL1Iii) {
        this.f2981il = null;
        if (lli1ll == null || (iL1Iii == null && this.ILL == lLi1LL.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.f5437I1I = new LinkedBlockingQueue();
        new LinkedBlockingQueue();
        this.f2972IL = lli1ll;
        this.ILL = lLi1LL.CLIENT;
        if (iL1Iii != null) {
            this.f2981il = iL1Iii.mo3547lLi1LL();
        }
    }

    public boolean I11L() {
        return !this.f5437I1I.isEmpty();
    }

    public SSLSession I11li1() {
        if (llliI()) {
            return ((p051lLi1LL.I1I.p052ILl.IL1Iii) this.f2980lLi1LL).IL1Iii().getSession();
        }
        throw new IllegalArgumentException("This websocket uses ws instead of wss. No SSLSession available.");
    }

    public synchronized void I1I(int i, String str, boolean z) {
        p051lLi1LL.I1I.p055L11I.IL il = this.f2973IiL;
        p051lLi1LL.I1I.p055L11I.IL il2 = p051lLi1LL.I1I.p055L11I.IL.CLOSING;
        if (il == il2 || this.f2973IiL == p051lLi1LL.I1I.p055L11I.IL.CLOSED) {
            return;
        }
        if (this.f2973IiL == p051lLi1LL.I1I.p055L11I.IL.OPEN) {
            if (i == 1006) {
                this.f2973IiL = il2;
                m3511ILl(i, str, false);
                return;
            }
            if (this.f2981il.mo3542Ll1() != p051lLi1LL.I1I.p055L11I.IL1Iii.NONE) {
                try {
                    if (!z) {
                        try {
                            this.f2972IL.onWebsocketCloseInitiated(this, i, str);
                        } catch (RuntimeException e) {
                            this.f2972IL.onWebsocketError(this, e);
                        }
                    }
                    if (m3526lIII()) {
                        p051lLi1LL.I1I.p054Ll1.ILil iLil = new p051lLi1LL.I1I.p054Ll1.ILil();
                        iLil.m3584lIlii(str);
                        iLil.m3585llL1ii(i);
                        iLil.mo3583IiL();
                        sendFrame(iLil);
                    }
                } catch (p051lLi1LL.I1I.p058il.I1I e2) {
                    this.f5438ILil.error("generated frame is invalid", e2);
                    this.f2972IL.onWebsocketError(this, e2);
                    m3511ILl(MysqlErrorNumbers.ER_CANT_CREATE_DB, "generated frame is invalid", false);
                }
            }
            m3511ILl(i, str, z);
        } else if (i == -3) {
            m3511ILl(-3, str, true);
        } else if (i == 1002) {
            m3511ILl(i, str, z);
        } else {
            m3511ILl(-1, str, false);
        }
        this.f2973IiL = p051lLi1LL.I1I.p055L11I.IL.CLOSING;
        this.f2974Ll1 = null;
    }

    public void IL1Iii(int i) {
        I1I(i, BuildConfig.FLAVOR, false);
    }

    public final void ILL(ByteBuffer byteBuffer) {
        try {
            for (iILLL1 iilll1 : this.f2981il.I11li1(byteBuffer)) {
                this.f5438ILil.trace("matched frame: {}", iilll1);
                this.f2981il.Lil(this, iilll1);
            }
        } catch (IiL e) {
            if (e.getLimit() == Integer.MAX_VALUE) {
                this.f5438ILil.error("Closing due to invalid size of frame", e);
                this.f2972IL.onWebsocketError(this, e);
            }
            m3513IL(e);
        } catch (p051lLi1LL.I1I.p058il.I1I e2) {
            this.f5438ILil.error("Closing due to invalid data in frame", e2);
            this.f2972IL.onWebsocketError(this, e2);
            m3513IL(e2);
        }
    }

    public void ILil(int i, String str) {
        I1I(i, str, false);
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public synchronized void m3511ILl(int i, String str, boolean z) {
        if (this.f2976iILLL1) {
            return;
        }
        this.Lil = Integer.valueOf(i);
        this.f2971ILl = str;
        this.LlLI1 = Boolean.valueOf(z);
        this.f2976iILLL1 = true;
        this.f2972IL.onWriteDemand(this);
        try {
            this.f2972IL.onWebsocketClosing(this, i, str, z);
        } catch (RuntimeException e) {
            this.f5438ILil.error("Exception in onWebsocketClosing", e);
            this.f2972IL.onWebsocketError(this, e);
        }
        IL1Iii iL1Iii = this.f2981il;
        if (iL1Iii != null) {
            iL1Iii.iIi1();
        }
        this.f2977lIiI = null;
    }

    public void Ilil(int i, String str) {
        m3529lLi1LL(i, str, false);
    }

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public <T> void m3512IIi(T t) {
        this.iIlLiL = t;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m3513IL(p051lLi1LL.I1I.p058il.I1I i1i) {
        I1I(i1i.getCloseCode(), i1i.getMessage(), false);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final void m3514IiL(RuntimeException runtimeException) {
        m3536(Lil(500));
        m3511ILl(-1, runtimeException.getMessage(), false);
    }

    /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
    public final void m3515L11(List<ByteBuffer> list) {
        synchronized (this.iIi1) {
            Iterator<ByteBuffer> it = list.iterator();
            while (it.hasNext()) {
                m3536(it.next());
            }
        }
    }

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public void m3516L111(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        m825(this.f2981il.mo3541IiL(str, this.ILL == lLi1LL.CLIENT));
    }

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public void m3517LIll(p051lLi1LL.I1I.p057lIiI.ILil iLil) throws p051lLi1LL.I1I.p058il.iILLL1 {
        this.f2977lIiI = this.f2981il.mo3545lIiI(iLil);
        this.f2979llL1ii = iLil.IL1Iii();
        try {
            this.f2972IL.onWebsocketHandshakeSentAsClient(this, this.f2977lIiI);
            m3515L11(this.f2981il.m3548il(this.f2977lIiI));
        } catch (RuntimeException e) {
            this.f5438ILil.error("Exception in startHandshake", e);
            this.f2972IL.onWebsocketError(this, e);
            throw new p051lLi1LL.I1I.p058il.iILLL1("rejected because of " + e);
        } catch (p051lLi1LL.I1I.p058il.I1I unused) {
            throw new p051lLi1LL.I1I.p058il.iILLL1("Handshake data rejected by client.");
        }
    }

    public final void LL1IL(p051lLi1LL.I1I.p057lIiI.iILLL1 iilll1) {
        this.f5438ILil.trace("open using draft: {}", this.f2981il);
        this.f2973IiL = p051lLi1LL.I1I.p055L11I.IL.OPEN;
        try {
            this.f2972IL.onWebsocketOpen(this, iilll1);
        } catch (RuntimeException e) {
            this.f2972IL.onWebsocketError(this, e);
        }
    }

    public final ByteBuffer Lil(int i) {
        String str = i != 404 ? "500 Internal Server Error" : "404 WebSocket Upgrade Failure";
        return ByteBuffer.wrap(p051lLi1LL.I1I.LlLI1.I1I.IL1Iii("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public <T> T LlLI1() {
        return (T) this.iIlLiL;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final boolean m3518Ll1(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        if (this.f2974Ll1.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.f2974Ll1.remaining() < byteBuffer.remaining()) {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.f2974Ll1.capacity() + byteBuffer.remaining());
                this.f2974Ll1.flip();
                byteBufferAllocate.put(this.f2974Ll1);
                this.f2974Ll1 = byteBufferAllocate;
            }
            this.f2974Ll1.put(byteBuffer);
            this.f2974Ll1.flip();
            byteBuffer2 = this.f2974Ll1;
        }
        byteBuffer2.mark();
        try {
            try {
                lLi1LL lli1ll = this.ILL;
                if (lli1ll != lLi1LL.SERVER) {
                    if (lli1ll == lLi1LL.CLIENT) {
                        this.f2981il.iIlLiL(lli1ll);
                        p051lLi1LL.I1I.p057lIiI.iILLL1 iilll1M3549lL = this.f2981il.m3549lL(byteBuffer2);
                        if (!(iilll1M3549lL instanceof L11I)) {
                            this.f5438ILil.trace("Closing due to protocol error: wrong http function");
                            m3511ILl(MysqlErrorNumbers.ER_NO, "wrong http function", false);
                            return false;
                        }
                        L11I l11i = (L11I) iilll1M3549lL;
                        if (this.f2981il.IL1Iii(this.f2977lIiI, l11i) == p051lLi1LL.I1I.p055L11I.ILil.MATCHED) {
                            try {
                                this.f2972IL.onWebsocketHandshakeReceivedAsClient(this, this.f2977lIiI, l11i);
                                LL1IL(l11i);
                                return true;
                            } catch (RuntimeException e) {
                                this.f5438ILil.error("Closing since client was never connected", e);
                                this.f2972IL.onWebsocketError(this, e);
                                m3511ILl(-1, e.getMessage(), false);
                                return false;
                            } catch (p051lLi1LL.I1I.p058il.I1I e2) {
                                this.f5438ILil.trace("Closing due to invalid data exception. Possible handshake rejection", (Throwable) e2);
                                m3511ILl(e2.getCloseCode(), e2.getMessage(), false);
                                return false;
                            }
                        }
                        this.f5438ILil.trace("Closing due to protocol error: draft {} refuses handshake", this.f2981il);
                        ILil(MysqlErrorNumbers.ER_NO, "draft " + this.f2981il + " refuses handshake");
                    }
                    return false;
                }
                IL1Iii iL1Iii = this.f2981il;
                if (iL1Iii != null) {
                    p051lLi1LL.I1I.p057lIiI.iILLL1 iilll1M3549lL2 = iL1Iii.m3549lL(byteBuffer2);
                    if (!(iilll1M3549lL2 instanceof p051lLi1LL.I1I.p057lIiI.IL1Iii)) {
                        this.f5438ILil.trace("Closing due to protocol error: wrong http function");
                        m3511ILl(MysqlErrorNumbers.ER_NO, "wrong http function", false);
                        return false;
                    }
                    p051lLi1LL.I1I.p057lIiI.IL1Iii iL1Iii2 = (p051lLi1LL.I1I.p057lIiI.IL1Iii) iilll1M3549lL2;
                    if (this.f2981il.ILil(iL1Iii2) == p051lLi1LL.I1I.p055L11I.ILil.MATCHED) {
                        LL1IL(iL1Iii2);
                        return true;
                    }
                    this.f5438ILil.trace("Closing due to protocol error: the handshake did finally not match");
                    ILil(MysqlErrorNumbers.ER_NO, "the handshake did finally not match");
                    return false;
                }
                Iterator<IL1Iii> it = this.f2975L11I.iterator();
                while (it.hasNext()) {
                    IL1Iii iL1IiiMo3547lLi1LL = it.next().mo3547lLi1LL();
                    try {
                        iL1IiiMo3547lLi1LL.iIlLiL(this.ILL);
                        byteBuffer2.reset();
                        p051lLi1LL.I1I.p057lIiI.iILLL1 iilll1M3549lL3 = iL1IiiMo3547lLi1LL.m3549lL(byteBuffer2);
                        if (!(iilll1M3549lL3 instanceof p051lLi1LL.I1I.p057lIiI.IL1Iii)) {
                            this.f5438ILil.trace("Closing due to wrong handshake");
                            m3520L11I(new p051lLi1LL.I1I.p058il.I1I(MysqlErrorNumbers.ER_NO, "wrong http function"));
                            return false;
                        }
                        p051lLi1LL.I1I.p057lIiI.IL1Iii iL1Iii3 = (p051lLi1LL.I1I.p057lIiI.IL1Iii) iilll1M3549lL3;
                        if (iL1IiiMo3547lLi1LL.ILil(iL1Iii3) == p051lLi1LL.I1I.p055L11I.ILil.MATCHED) {
                            this.f2979llL1ii = iL1Iii3.IL1Iii();
                            try {
                                m3515L11(iL1IiiMo3547lLi1LL.m3548il(iL1IiiMo3547lLi1LL.mo3539ILl(iL1Iii3, this.f2972IL.onWebsocketHandshakeReceivedAsServer(this, iL1IiiMo3547lLi1LL, iL1Iii3))));
                                this.f2981il = iL1IiiMo3547lLi1LL;
                                LL1IL(iL1Iii3);
                                return true;
                            } catch (RuntimeException e3) {
                                this.f5438ILil.error("Closing due to internal server error", e3);
                                this.f2972IL.onWebsocketError(this, e3);
                                m3514IiL(e3);
                                return false;
                            } catch (p051lLi1LL.I1I.p058il.I1I e4) {
                                this.f5438ILil.trace("Closing due to wrong handshake. Possible handshake rejection", (Throwable) e4);
                                m3520L11I(e4);
                                return false;
                            }
                        }
                    } catch (p051lLi1LL.I1I.p058il.iILLL1 unused) {
                    }
                }
                if (this.f2981il == null) {
                    this.f5438ILil.trace("Closing due to protocol error: no draft matches");
                    m3520L11I(new p051lLi1LL.I1I.p058il.I1I(MysqlErrorNumbers.ER_NO, "no draft matches"));
                }
                return false;
            } catch (p051lLi1LL.I1I.p058il.iILLL1 e5) {
                this.f5438ILil.trace("Closing due to invalid handshake", (Throwable) e5);
                m3513IL(e5);
            }
        } catch (p051lLi1LL.I1I.p058il.ILil e6) {
            if (this.f2974Ll1.capacity() == 0) {
                byteBuffer2.reset();
                int preferredSize = e6.getPreferredSize();
                if (preferredSize == 0) {
                    preferredSize = byteBuffer2.capacity() + 16;
                }
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(preferredSize);
                this.f2974Ll1 = byteBufferAllocate2;
                byteBufferAllocate2.put(byteBuffer);
            } else {
                ByteBuffer byteBuffer3 = this.f2974Ll1;
                byteBuffer3.position(byteBuffer3.limit());
                ByteBuffer byteBuffer4 = this.f2974Ll1;
                byteBuffer4.limit(byteBuffer4.capacity());
            }
        }
    }

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public void m3519L1l(Collection<iILLL1> collection) {
        m825(collection);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final void m3520L11I(p051lLi1LL.I1I.p058il.I1I i1i) {
        m3536(Lil(404));
        m3511ILl(i1i.getCloseCode(), i1i.getMessage(), false);
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public boolean m3521LlLLL() {
        return this.f2976iILLL1;
    }

    public p051lLi1LL.I1I.p055L11I.IL iIi1() {
        return this.f2973IiL;
    }

    public InetSocketAddress iIlLiL() {
        return this.f2972IL.getRemoteSocketAddress(this);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m3522iILLL1(int i, boolean z) {
        m3529lLi1LL(i, BuildConfig.FLAVOR, z);
    }

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public void m3523ill() {
        this.f2978lIlii = System.nanoTime();
    }

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public void m3524l1IIi1(p051lLi1LL.I1I.p055L11I.I1I i1i, ByteBuffer byteBuffer, boolean z) {
        m825(this.f2981il.Ilil(i1i, byteBuffer, z));
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public void m3525lIiI() {
        if (this.f2973IiL == p051lLi1LL.I1I.p055L11I.IL.NOT_YET_CONNECTED) {
            m3522iILLL1(-1, true);
            return;
        }
        if (this.f2976iILLL1) {
            m3529lLi1LL(this.Lil.intValue(), this.f2971ILl, this.LlLI1.booleanValue());
            return;
        }
        if (this.f2981il.mo3542Ll1() == p051lLi1LL.I1I.p055L11I.IL1Iii.NONE) {
            m3522iILLL1(1000, true);
            return;
        }
        if (this.f2981il.mo3542Ll1() != p051lLi1LL.I1I.p055L11I.IL1Iii.ONEWAY) {
            m3522iILLL1(MysqlErrorNumbers.ER_CANT_CREATE_DB, true);
        } else if (this.ILL == lLi1LL.SERVER) {
            m3522iILLL1(MysqlErrorNumbers.ER_CANT_CREATE_DB, true);
        } else {
            m3522iILLL1(1000, true);
        }
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public boolean m3526lIII() {
        return this.f2973IiL == p051lLi1LL.I1I.p055L11I.IL.OPEN;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public InetSocketAddress m3527lIlii() {
        return this.f2972IL.getLocalSocketAddress(this);
    }

    public void llI(byte[] bArr) {
        m3534LLlI1(ByteBuffer.wrap(bArr));
    }

    public boolean llliI() {
        return this.f2980lLi1LL instanceof p051lLi1LL.I1I.p052ILl.IL1Iii;
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public long m3528llL1ii() {
        return this.f2978lIlii;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x005d A[Catch: all -> 0x0069, TryCatch #2 {, blocks: (B:3:0x0001, B:7:0x0009, B:11:0x0013, B:12:0x0017, B:14:0x001b, B:15:0x001e, B:17:0x0022, B:26:0x004d, B:30:0x0059, B:32:0x005d, B:33:0x0060, B:29:0x0054, B:20:0x0027, B:22:0x002d, B:24:0x0039, B:25:0x0041), top: B:43:0x0001, inners: #0, #1 }] */
    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public synchronized void m3529lLi1LL(int i, String str, boolean z) {
        IL1Iii iL1Iii;
        if (this.f2973IiL == p051lLi1LL.I1I.p055L11I.IL.CLOSED) {
            return;
        }
        if (this.f2973IiL == p051lLi1LL.I1I.p055L11I.IL.OPEN && i == 1006) {
            this.f2973IiL = p051lLi1LL.I1I.p055L11I.IL.CLOSING;
        }
        SelectionKey selectionKey = this.f5439Ilil;
        if (selectionKey != null) {
            selectionKey.cancel();
        }
        ByteChannel byteChannel = this.f2980lLi1LL;
        if (byteChannel == null) {
            this.f2972IL.onWebsocketClose(this, i, str, z);
            iL1Iii = this.f2981il;
            if (iL1Iii != null) {
                iL1Iii.iIi1();
            }
            this.f2977lIiI = null;
            this.f2973IiL = p051lLi1LL.I1I.p055L11I.IL.CLOSED;
            return;
        }
        try {
            byteChannel.close();
        } catch (IOException e) {
            if (e.getMessage() == null || !e.getMessage().equals("Broken pipe")) {
                this.f5438ILil.error("Exception during channel.close()", e);
                this.f2972IL.onWebsocketError(this, e);
            } else {
                this.f5438ILil.trace("Caught IOException: Broken pipe during closeConnection()", (Throwable) e);
            }
        }
        try {
            this.f2972IL.onWebsocketClose(this, i, str, z);
        } catch (RuntimeException e2) {
            this.f2972IL.onWebsocketError(this, e2);
        }
        iL1Iii = this.f2981il;
        if (iL1Iii != null) {
            iL1Iii.iIi1();
        }
        this.f2977lIiI = null;
        this.f2973IiL = p051lLi1LL.I1I.p055L11I.IL.CLOSED;
        return;
        throw th;
    }

    @Override // p051lLi1LL.I1I.ILil
    public void sendFrame(iILLL1 iilll1) {
        m825(Collections.singletonList(iilll1));
    }

    public String toString() {
        return super.toString();
    }

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public void m3530iILLl() throws NullPointerException {
        p051lLi1LL.I1I.p054Ll1.L11I l11iOnPreparePing = this.f2972IL.onPreparePing(this);
        Objects.requireNonNull(l11iOnPreparePing, "onPreparePing(WebSocket) returned null. PingFrame to sent can't be null.");
        sendFrame(l11iOnPreparePing);
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void m3531il(ByteBuffer byteBuffer) {
        this.f5438ILil.trace("process({}): ({})", Integer.valueOf(byteBuffer.remaining()), byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining()));
        if (this.f2973IiL != p051lLi1LL.I1I.p055L11I.IL.NOT_YET_CONNECTED) {
            if (this.f2973IiL == p051lLi1LL.I1I.p055L11I.IL.OPEN) {
                ILL(byteBuffer);
            }
        } else {
            if (!m3518Ll1(byteBuffer) || m35351() || m3533l()) {
                return;
            }
            if (byteBuffer.hasRemaining()) {
                ILL(byteBuffer);
            } else if (this.f2974Ll1.hasRemaining()) {
                ILL(this.f2974Ll1);
            }
        }
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public lLi1LL m3532lL() {
        return this.f2972IL;
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public boolean m3533l() {
        return this.f2973IiL == p051lLi1LL.I1I.p055L11I.IL.CLOSED;
    }

    /* JADX INFO: renamed from: 丨丨 */
    public final void m825(Collection<iILLL1> collection) {
        if (!m3526lIII()) {
            throw new C0675il();
        }
        if (collection == null) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList();
        for (iILLL1 iilll1 : collection) {
            this.f5438ILil.trace("send frame: {}", iilll1);
            arrayList.add(this.f2981il.mo3544iILLL1(iilll1));
        }
        m3515L11(arrayList);
    }

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public void m3534LLlI1(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        m825(this.f2981il.mo3543L11I(byteBuffer, this.ILL == lLi1LL.CLIENT));
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public boolean m35351() {
        return this.f2973IiL == p051lLi1LL.I1I.p055L11I.IL.CLOSING;
    }

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public final void m3536(ByteBuffer byteBuffer) {
        this.f5438ILil.trace("write({}): {}", Integer.valueOf(byteBuffer.remaining()), byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array()));
        this.f5437I1I.add(byteBuffer);
        this.f2972IL.onWriteDemand(this);
    }
}
