package p051lLi1LL.I1I.p053IiL;

import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.MysqlErrorNumbers;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import okhttp3.internal.p006ws.WebSocketProtocol;
import p051lLi1LL.I1I.IL;
import p051lLi1LL.I1I.p054Ll1.ILL;
import p051lLi1LL.I1I.p054Ll1.IiL;
import p051lLi1LL.I1I.p054Ll1.iILLL1;
import p051lLi1LL.I1I.p057lIiI.InterfaceC0674il;
import p051lLi1LL.I1I.p057lIiI.L11I;
import p051lLi1LL.I1I.p058il.I1I;
import p051lLi1LL.I1I.p058il.lLi1LL;

/* JADX INFO: compiled from: Draft_6455.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil extends p051lLi1LL.I1I.p053IiL.IL1Iii {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final p051lLi1LL.p060IL.ILil f5442I1I;
    public final Random ILL;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public List<p051lLi1LL.I1I.ILL.ILil> f5443Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public p051lLi1LL.I1I.ILL.ILil f2982IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public iILLL1 f2983IiL;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public int f2984Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final List<ByteBuffer> f2985L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public List<p051lLi1LL.I1I.Lil.IL1Iii> f2986iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public p051lLi1LL.I1I.Lil.IL1Iii f2987lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public ByteBuffer f2988il;

    /* JADX INFO: compiled from: Draft_6455.java */
    public class IL1Iii {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public int f5444IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f5445ILil;

        public IL1Iii(ILil iLil, int i, int i2) {
            this.f5444IL1Iii = i;
            this.f5445ILil = i2;
        }

        public final int I1I() {
            return this.f5444IL1Iii;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final int m3573IL() {
            return this.f5445ILil;
        }
    }

    public ILil() {
        this(Collections.emptyList());
    }

    @Override // p051lLi1LL.I1I.p053IiL.IL1Iii
    public List<iILLL1> I11li1(ByteBuffer byteBuffer) throws I1I {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.f2988il == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int iRemaining = byteBuffer.remaining();
                int iRemaining2 = this.f2988il.remaining();
                if (iRemaining2 <= iRemaining) {
                    this.f2988il.put(byteBuffer.array(), byteBuffer.position(), iRemaining2);
                    byteBuffer.position(byteBuffer.position() + iRemaining2);
                    linkedList.add(m3556LIl((ByteBuffer) this.f2988il.duplicate().position(0)));
                    this.f2988il = null;
                    break;
                }
                this.f2988il.put(byteBuffer.array(), byteBuffer.position(), iRemaining);
                byteBuffer.position(byteBuffer.position() + iRemaining);
                return Collections.emptyList();
            } catch (p051lLi1LL.I1I.p058il.IL1Iii e) {
                int preferredSize = e.getPreferredSize();
                m3540IL(preferredSize);
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(preferredSize);
                this.f2988il.rewind();
                byteBufferAllocate.put(this.f2988il);
                this.f2988il = byteBufferAllocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(m3556LIl(byteBuffer));
            } catch (p051lLi1LL.I1I.p058il.IL1Iii e2) {
                byteBuffer.reset();
                int preferredSize2 = e2.getPreferredSize();
                m3540IL(preferredSize2);
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(preferredSize2);
                this.f2988il = byteBufferAllocate2;
                byteBufferAllocate2.put(byteBuffer);
            }
        }
        return linkedList;
    }

    /* JADX INFO: renamed from: I1L丨11L, reason: contains not printable characters */
    public final void m3550I1L11L(IL il, iILLL1 iilll1, p051lLi1LL.I1I.p055L11I.I1I i1i) throws I1I {
        p051lLi1LL.I1I.p055L11I.I1I i1i2 = p051lLi1LL.I1I.p055L11I.I1I.CONTINUOUS;
        if (i1i != i1i2) {
            m3568li11(iilll1);
        } else if (iilll1.Ilil()) {
            m3552ILLIi(il, iilll1);
        } else if (this.f2983IiL == null) {
            this.f5442I1I.error("Protocol error: Continuous frame sequence was not started.");
            throw new I1I(MysqlErrorNumbers.ER_NO, "Continuous frame sequence was not started.");
        }
        if (i1i == p051lLi1LL.I1I.p055L11I.I1I.TEXT && !p051lLi1LL.I1I.LlLI1.I1I.ILil(iilll1.mo3586lLi1LL())) {
            this.f5442I1I.error("Protocol error: Payload is not UTF8");
            throw new I1I(MysqlErrorNumbers.ER_DB_CREATE_EXISTS);
        }
        if (i1i != i1i2 || this.f2983IiL == null) {
            return;
        }
        m35711(iilll1.mo3586lLi1LL());
    }

    /* JADX INFO: renamed from: IIi丨丨I, reason: contains not printable characters */
    public final int m3551IIiI(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= 125) {
            return 1;
        }
        return byteBuffer.remaining() <= 65535 ? 2 : 8;
    }

    @Override // p051lLi1LL.I1I.p053IiL.IL1Iii
    public p051lLi1LL.I1I.p055L11I.ILil IL1Iii(p051lLi1LL.I1I.p057lIiI.IL1Iii iL1Iii, L11I l11i) throws p051lLi1LL.I1I.p058il.iILLL1 {
        if (!I1I(l11i)) {
            this.f5442I1I.trace("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return p051lLi1LL.I1I.p055L11I.ILil.NOT_MATCHED;
        }
        if (!iL1Iii.Ilil("Sec-WebSocket-Key") || !l11i.Ilil("Sec-WebSocket-Accept")) {
            this.f5442I1I.trace("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return p051lLi1LL.I1I.p055L11I.ILil.NOT_MATCHED;
        }
        if (!m829(iL1Iii.mo3595L11I("Sec-WebSocket-Key")).equals(l11i.mo3595L11I("Sec-WebSocket-Accept"))) {
            this.f5442I1I.trace("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
            return p051lLi1LL.I1I.p055L11I.ILil.NOT_MATCHED;
        }
        p051lLi1LL.I1I.p055L11I.ILil iLil = p051lLi1LL.I1I.p055L11I.ILil.NOT_MATCHED;
        String strMo3595L11I = l11i.mo3595L11I("Sec-WebSocket-Extensions");
        for (p051lLi1LL.I1I.ILL.ILil iLil2 : this.f5443Ilil) {
            if (iLil2.mo3507IL(strMo3595L11I)) {
                this.f2982IL = iLil2;
                iLil = p051lLi1LL.I1I.p055L11I.ILil.MATCHED;
                this.f5442I1I.trace("acceptHandshakeAsClient - Matching extension found: {}", iLil2);
                break;
            }
        }
        p051lLi1LL.I1I.p055L11I.ILil iLilLL1IL = LL1IL(l11i.mo3595L11I("Sec-WebSocket-Protocol"));
        p051lLi1LL.I1I.p055L11I.ILil iLil3 = p051lLi1LL.I1I.p055L11I.ILil.MATCHED;
        if (iLilLL1IL == iLil3 && iLil == iLil3) {
            return iLil3;
        }
        this.f5442I1I.trace("acceptHandshakeAsClient - No matching extension or protocol found.");
        return p051lLi1LL.I1I.p055L11I.ILil.NOT_MATCHED;
    }

    /* JADX INFO: renamed from: ILL丨Ii, reason: contains not printable characters */
    public final void m3552ILLIi(IL il, iILLL1 iilll1) throws I1I {
        if (this.f2983IiL == null) {
            this.f5442I1I.trace("Protocol error: Previous continuous frame sequence not completed.");
            throw new I1I(MysqlErrorNumbers.ER_NO, "Continuous frame sequence was not started.");
        }
        m35711(iilll1.mo3586lLi1LL());
        m3561LlLLL();
        if (this.f2983IiL.I1I() == p051lLi1LL.I1I.p055L11I.I1I.TEXT) {
            ((IiL) this.f2983IiL).mo3587il(m3564ill());
            ((IiL) this.f2983IiL).mo3583IiL();
            try {
                il.m3532lL().onWebsocketMessage(il, p051lLi1LL.I1I.LlLI1.I1I.Ilil(this.f2983IiL.mo3586lLi1LL()));
            } catch (RuntimeException e) {
                m3567lliiI1(il, e);
            }
        } else if (this.f2983IiL.I1I() == p051lLi1LL.I1I.p055L11I.I1I.BINARY) {
            ((IiL) this.f2983IiL).mo3587il(m3564ill());
            ((IiL) this.f2983IiL).mo3583IiL();
            try {
                il.m3532lL().onWebsocketMessage(il, this.f2983IiL.mo3586lLi1LL());
            } catch (RuntimeException e2) {
                m3567lliiI1(il, e2);
            }
        }
        this.f2983IiL = null;
        m3566lIII();
    }

    @Override // p051lLi1LL.I1I.p053IiL.IL1Iii
    public p051lLi1LL.I1I.p055L11I.ILil ILil(p051lLi1LL.I1I.p057lIiI.IL1Iii iL1Iii) throws p051lLi1LL.I1I.p058il.iILLL1 {
        if (m3546lIlii(iL1Iii) != 13) {
            this.f5442I1I.trace("acceptHandshakeAsServer - Wrong websocket version.");
            return p051lLi1LL.I1I.p055L11I.ILil.NOT_MATCHED;
        }
        p051lLi1LL.I1I.p055L11I.ILil iLil = p051lLi1LL.I1I.p055L11I.ILil.NOT_MATCHED;
        String strMo3595L11I = iL1Iii.mo3595L11I("Sec-WebSocket-Extensions");
        for (p051lLi1LL.I1I.ILL.ILil iLil2 : this.f5443Ilil) {
            if (iLil2.ILil(strMo3595L11I)) {
                this.f2982IL = iLil2;
                iLil = p051lLi1LL.I1I.p055L11I.ILil.MATCHED;
                this.f5442I1I.trace("acceptHandshakeAsServer - Matching extension found: {}", iLil2);
                break;
            }
        }
        p051lLi1LL.I1I.p055L11I.ILil iLilLL1IL = LL1IL(iL1Iii.mo3595L11I("Sec-WebSocket-Protocol"));
        p051lLi1LL.I1I.p055L11I.ILil iLil3 = p051lLi1LL.I1I.p055L11I.ILil.MATCHED;
        if (iLilLL1IL == iLil3 && iLil == iLil3) {
            return iLil3;
        }
        this.f5442I1I.trace("acceptHandshakeAsServer - No matching extension or protocol found.");
        return p051lLi1LL.I1I.p055L11I.ILil.NOT_MATCHED;
    }

    @Override // p051lLi1LL.I1I.p053IiL.IL1Iii
    /* JADX INFO: renamed from: IL丨丨l */
    public p051lLi1LL.I1I.p057lIiI.I1I mo3539ILl(p051lLi1LL.I1I.p057lIiI.IL1Iii iL1Iii, InterfaceC0674il interfaceC0674il) throws p051lLi1LL.I1I.p058il.iILLL1 {
        interfaceC0674il.I1I("Upgrade", "websocket");
        interfaceC0674il.I1I("Connection", iL1Iii.mo3595L11I("Connection"));
        String strMo3595L11I = iL1Iii.mo3595L11I("Sec-WebSocket-Key");
        if (strMo3595L11I == null) {
            throw new p051lLi1LL.I1I.p058il.iILLL1("missing Sec-WebSocket-Key");
        }
        interfaceC0674il.I1I("Sec-WebSocket-Accept", m829(strMo3595L11I));
        if (m3565l1IIi1().mo3508IiL().length() != 0) {
            interfaceC0674il.I1I("Sec-WebSocket-Extensions", m3565l1IIi1().mo3508IiL());
        }
        if (m3572() != null && m3572().ILil().length() != 0) {
            interfaceC0674il.I1I("Sec-WebSocket-Protocol", m3572().ILil());
        }
        interfaceC0674il.mo3597IiL("Web Socket Protocol Handshake");
        interfaceC0674il.I1I("Server", "TooTallNate Java-WebSocket");
        interfaceC0674il.I1I("Date", m3558LlIl());
        return interfaceC0674il;
    }

    /* JADX INFO: renamed from: I丨 */
    public final IL1Iii m826I(ByteBuffer byteBuffer, p051lLi1LL.I1I.p055L11I.I1I i1i, int i, int i2, int i3) throws p051lLi1LL.I1I.p058il.IiL, lLi1LL, p051lLi1LL.I1I.p058il.IL1Iii {
        int i4;
        int iIntValue;
        if (i1i == p051lLi1LL.I1I.p055L11I.I1I.PING || i1i == p051lLi1LL.I1I.p055L11I.I1I.PONG || i1i == p051lLi1LL.I1I.p055L11I.I1I.CLOSING) {
            this.f5442I1I.trace("Invalid frame: more than 125 octets");
            throw new lLi1LL("more than 125 octets");
        }
        if (i == 126) {
            i4 = i3 + 2;
            m3559LlLiLL(i2, i4);
            iIntValue = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
        } else {
            i4 = i3 + 8;
            m3559LlLiLL(i2, i4);
            byte[] bArr = new byte[8];
            for (int i5 = 0; i5 < 8; i5++) {
                bArr[i5] = byteBuffer.get();
            }
            long jLongValue = new BigInteger(bArr).longValue();
            m828iI(jLongValue);
            iIntValue = (int) jLongValue;
        }
        return new IL1Iii(this, iIntValue, i4);
    }

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public final byte m3553IIi(boolean z) {
        return z ? (byte) -128 : (byte) 0;
    }

    @Override // p051lLi1LL.I1I.p053IiL.IL1Iii
    /* JADX INFO: renamed from: I丨iL */
    public List<iILLL1> mo3541IiL(String str, boolean z) {
        ILL ill = new ILL();
        ill.mo3587il(ByteBuffer.wrap(p051lLi1LL.I1I.LlLI1.I1I.m3575lLi1LL(str)));
        ill.m3589ILl(z);
        try {
            ill.mo3583IiL();
            return Collections.singletonList(ill);
        } catch (I1I e) {
            throw new p051lLi1LL.I1I.p058il.L11I(e);
        }
    }

    /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
    public final byte m3554L11(int i) {
        if (i == 1) {
            return (byte) 64;
        }
        if (i == 2) {
            return (byte) 32;
        }
        return i == 3 ? (byte) 16 : (byte) 0;
    }

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public final ByteBuffer m3555L111(iILLL1 iilll1) {
        ByteBuffer byteBufferMo3586lLi1LL = iilll1.mo3586lLi1LL();
        int i = 0;
        boolean z = this.f5440IL1Iii == p051lLi1LL.I1I.p055L11I.lLi1LL.CLIENT;
        int iM3551IIiI = m3551IIiI(byteBufferMo3586lLi1LL);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((iM3551IIiI > 1 ? iM3551IIiI + 1 : iM3551IIiI) + 1 + (z ? 4 : 0) + byteBufferMo3586lLi1LL.remaining());
        byte bM3570LLlI1 = (byte) (m3570LLlI1(iilll1.I1I()) | ((byte) (iilll1.Ilil() ? -128 : 0)));
        if (iilll1.IL1Iii()) {
            bM3570LLlI1 = (byte) (bM3570LLlI1 | m3554L11(1));
        }
        if (iilll1.ILil()) {
            bM3570LLlI1 = (byte) (bM3570LLlI1 | m3554L11(2));
        }
        if (iilll1.mo3590IL()) {
            bM3570LLlI1 = (byte) (m3554L11(3) | bM3570LLlI1);
        }
        byteBufferAllocate.put(bM3570LLlI1);
        byte[] bArrM827i1 = m827i1(byteBufferMo3586lLi1LL.remaining(), iM3551IIiI);
        if (iM3551IIiI == 1) {
            byteBufferAllocate.put((byte) (bArrM827i1[0] | m3553IIi(z)));
        } else if (iM3551IIiI == 2) {
            byteBufferAllocate.put((byte) (m3553IIi(z) | 126));
            byteBufferAllocate.put(bArrM827i1);
        } else {
            if (iM3551IIiI != 8) {
                throw new IllegalStateException("Size representation not supported/specified");
            }
            byteBufferAllocate.put((byte) (m3553IIi(z) | 127));
            byteBufferAllocate.put(bArrM827i1);
        }
        if (z) {
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
            byteBufferAllocate2.putInt(this.ILL.nextInt());
            byteBufferAllocate.put(byteBufferAllocate2.array());
            while (byteBufferMo3586lLi1LL.hasRemaining()) {
                byteBufferAllocate.put((byte) (byteBufferMo3586lLi1LL.get() ^ byteBufferAllocate2.get(i % 4)));
                i++;
            }
        } else {
            byteBufferAllocate.put(byteBufferMo3586lLi1LL);
            byteBufferMo3586lLi1LL.flip();
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    /* JADX INFO: renamed from: LI丨l, reason: contains not printable characters */
    public final iILLL1 m3556LIl(ByteBuffer byteBuffer) throws I1I, p051lLi1LL.I1I.p058il.IL1Iii {
        if (byteBuffer == null) {
            throw new IllegalArgumentException();
        }
        int iRemaining = byteBuffer.remaining();
        int iM3573IL = 2;
        m3559LlLiLL(iRemaining, 2);
        byte b = byteBuffer.get();
        boolean z = (b >> 8) != 0;
        boolean z2 = (b & 64) != 0;
        boolean z3 = (b & 32) != 0;
        boolean z4 = (b & 16) != 0;
        byte b2 = byteBuffer.get();
        boolean z5 = (b2 & (-128)) != 0;
        int iI1I = (byte) (b2 & 127);
        p051lLi1LL.I1I.p055L11I.I1I i1iM3563ili11 = m3563ili11((byte) (b & 15));
        if (iI1I < 0 || iI1I > 125) {
            IL1Iii iL1IiiM826I = m826I(byteBuffer, i1iM3563ili11, iI1I, iRemaining, 2);
            iI1I = iL1IiiM826I.I1I();
            iM3573IL = iL1IiiM826I.m3573IL();
        }
        m828iI(iI1I);
        m3559LlLiLL(iRemaining, iM3573IL + (z5 ? 4 : 0) + iI1I);
        m3540IL(iI1I);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iI1I);
        if (z5) {
            byte[] bArr = new byte[4];
            byteBuffer.get(bArr);
            for (int i = 0; i < iI1I; i++) {
                byteBufferAllocate.put((byte) (byteBuffer.get() ^ bArr[i % 4]));
            }
        } else {
            byteBufferAllocate.put(byteBuffer.array(), byteBuffer.position(), byteBufferAllocate.limit());
            byteBuffer.position(byteBuffer.position() + byteBufferAllocate.limit());
        }
        IiL iiLM3588iILLL1 = IiL.m3588iILLL1(i1iM3563ili11);
        iiLM3588iILLL1.m3592L11I(z);
        iiLM3588iILLL1.ILL(z2);
        iiLM3588iILLL1.m3591Ll1(z3);
        iiLM3588iILLL1.m3593lIiI(z4);
        byteBufferAllocate.flip();
        iiLM3588iILLL1.mo3587il(byteBufferAllocate);
        m3565l1IIi1().mo3510lLi1LL(iiLM3588iILLL1);
        m3565l1IIi1().I1I(iiLM3588iILLL1);
        if (this.f5442I1I.isTraceEnabled()) {
            this.f5442I1I.trace("afterDecoding({}): {}", Integer.valueOf(iiLM3588iILLL1.mo3586lLi1LL().remaining()), iiLM3588iILLL1.mo3586lLi1LL().remaining() > 1000 ? "too big to display" : new String(iiLM3588iILLL1.mo3586lLi1LL().array()));
        }
        iiLM3588iILLL1.mo3583IiL();
        return iiLM3588iILLL1;
    }

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public int m3557LIll() {
        return this.f2984Ll1;
    }

    public final p051lLi1LL.I1I.p055L11I.ILil LL1IL(String str) {
        for (p051lLi1LL.I1I.Lil.IL1Iii iL1Iii : this.f2986iILLL1) {
            if (iL1Iii.I1I(str)) {
                this.f2987lLi1LL = iL1Iii;
                this.f5442I1I.trace("acceptHandshake - Matching protocol found: {}", iL1Iii);
                return p051lLi1LL.I1I.p055L11I.ILil.MATCHED;
            }
        }
        return p051lLi1LL.I1I.p055L11I.ILil.NOT_MATCHED;
    }

    public final void LLL(IL il, iILLL1 iilll1) {
        try {
            il.m3532lL().onWebsocketMessage(il, iilll1.mo3586lLi1LL());
        } catch (RuntimeException e) {
            m3567lliiI1(il, e);
        }
    }

    @Override // p051lLi1LL.I1I.p053IiL.IL1Iii
    public void Lil(IL il, iILLL1 iilll1) throws I1I {
        p051lLi1LL.I1I.p055L11I.I1I I1I2 = iilll1.I1I();
        if (I1I2 == p051lLi1LL.I1I.p055L11I.I1I.CLOSING) {
            m3562iI1iI(il, iilll1);
            return;
        }
        if (I1I2 == p051lLi1LL.I1I.p055L11I.I1I.PING) {
            il.m3532lL().onWebsocketPing(il, iilll1);
            return;
        }
        if (I1I2 == p051lLi1LL.I1I.p055L11I.I1I.PONG) {
            il.m3523ill();
            il.m3532lL().onWebsocketPong(il, iilll1);
            return;
        }
        if (!iilll1.Ilil() || I1I2 == p051lLi1LL.I1I.p055L11I.I1I.CONTINUOUS) {
            m3550I1L11L(il, iilll1, I1I2);
            return;
        }
        if (this.f2983IiL != null) {
            this.f5442I1I.error("Protocol error: Continuous frame sequence not completed.");
            throw new I1I(MysqlErrorNumbers.ER_NO, "Continuous frame sequence not completed.");
        }
        if (I1I2 == p051lLi1LL.I1I.p055L11I.I1I.TEXT) {
            iIilII1(il, iilll1);
        } else if (I1I2 == p051lLi1LL.I1I.p055L11I.I1I.BINARY) {
            LLL(il, iilll1);
        } else {
            this.f5442I1I.error("non control or continious frame expected");
            throw new I1I(MysqlErrorNumbers.ER_NO, "non control or continious frame expected");
        }
    }

    /* JADX INFO: renamed from: LlIl丨, reason: contains not printable characters */
    public final String m3558LlIl() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    /* JADX INFO: renamed from: LlLiL丨L丨, reason: contains not printable characters */
    public final void m3559LlLiLL(int i, int i2) throws p051lLi1LL.I1I.p058il.IL1Iii {
        if (i >= i2) {
            return;
        }
        this.f5442I1I.trace("Incomplete frame: maxpacketsize < realpacketsize");
        throw new p051lLi1LL.I1I.p058il.IL1Iii(i2);
    }

    @Override // p051lLi1LL.I1I.p053IiL.IL1Iii
    /* JADX INFO: renamed from: Ll丨1 */
    public p051lLi1LL.I1I.p055L11I.IL1Iii mo3542Ll1() {
        return p051lLi1LL.I1I.p055L11I.IL1Iii.TWOWAY;
    }

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public List<p051lLi1LL.I1I.ILL.ILil> m3560L1l() {
        return this.f5443Ilil;
    }

    @Override // p051lLi1LL.I1I.p053IiL.IL1Iii
    /* JADX INFO: renamed from: L丨1丨1丨I */
    public List<iILLL1> mo3543L11I(ByteBuffer byteBuffer, boolean z) {
        p051lLi1LL.I1I.p054Ll1.IL1Iii iL1Iii = new p051lLi1LL.I1I.p054Ll1.IL1Iii();
        iL1Iii.mo3587il(byteBuffer);
        iL1Iii.m3589ILl(z);
        try {
            iL1Iii.mo3583IiL();
            return Collections.singletonList(iL1Iii);
        } catch (I1I e) {
            throw new p051lLi1LL.I1I.p058il.L11I(e);
        }
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public final void m3561LlLLL() throws p051lLi1LL.I1I.p058il.IiL {
        long jLlI = llI();
        if (jLlI <= this.f2984Ll1) {
            return;
        }
        m3566lIII();
        this.f5442I1I.trace("Payload limit reached. Allowed: {} Current: {}", Integer.valueOf(this.f2984Ll1), Long.valueOf(jLlI));
        throw new p051lLi1LL.I1I.p058il.IiL(this.f2984Ll1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ILil.class != obj.getClass()) {
            return false;
        }
        ILil iLil = (ILil) obj;
        if (this.f2984Ll1 != iLil.m3557LIll()) {
            return false;
        }
        p051lLi1LL.I1I.ILL.ILil iLil2 = this.f2982IL;
        if (iLil2 == null ? iLil.m3565l1IIi1() != null : !iLil2.equals(iLil.m3565l1IIi1())) {
            return false;
        }
        p051lLi1LL.I1I.Lil.IL1Iii iL1Iii = this.f2987lLi1LL;
        p051lLi1LL.I1I.Lil.IL1Iii iL1IiiM3572 = iLil.m3572();
        if (iL1Iii != null) {
            return iL1Iii.equals(iL1IiiM3572);
        }
        return iL1IiiM3572 == null;
    }

    public int hashCode() {
        p051lLi1LL.I1I.ILL.ILil iLil = this.f2982IL;
        int iHashCode = (iLil != null ? iLil.hashCode() : 0) * 31;
        p051lLi1LL.I1I.Lil.IL1Iii iL1Iii = this.f2987lLi1LL;
        int iHashCode2 = (iHashCode + (iL1Iii != null ? iL1Iii.hashCode() : 0)) * 31;
        int i = this.f2984Ll1;
        return iHashCode2 + (i ^ (i >>> 32));
    }

    /* JADX INFO: renamed from: i1 */
    public final byte[] m827i1(long j, int i) {
        byte[] bArr = new byte[i];
        int i2 = (i * 8) - 8;
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) (j >>> (i2 - (i3 * 8)));
        }
        return bArr;
    }

    /* JADX INFO: renamed from: iI */
    public final void m828iI(long j) throws p051lLi1LL.I1I.p058il.IiL {
        if (j > 2147483647L) {
            this.f5442I1I.trace("Limit exedeed: Payloadsize is to big...");
            throw new p051lLi1LL.I1I.p058il.IiL("Payloadsize is to big...");
        }
        int i = this.f2984Ll1;
        if (j > i) {
            this.f5442I1I.trace("Payload limit reached. Allowed: {} Current: {}", Integer.valueOf(i), Long.valueOf(j));
            throw new p051lLi1LL.I1I.p058il.IiL("Payload limit reached.", this.f2984Ll1);
        }
        if (j >= 0) {
            return;
        }
        this.f5442I1I.trace("Limit underflow: Payloadsize is to little...");
        throw new p051lLi1LL.I1I.p058il.IiL("Payloadsize is to little...");
    }

    /* JADX INFO: renamed from: iI1i丨I, reason: contains not printable characters */
    public final void m3562iI1iI(IL il, iILLL1 iilll1) {
        int iLil;
        String strLlLI1;
        if (iilll1 instanceof p051lLi1LL.I1I.p054Ll1.ILil) {
            p051lLi1LL.I1I.p054Ll1.ILil iLil2 = (p051lLi1LL.I1I.p054Ll1.ILil) iilll1;
            iLil = iLil2.Lil();
            strLlLI1 = iLil2.LlLI1();
        } else {
            iLil = 1005;
            strLlLI1 = BuildConfig.FLAVOR;
        }
        if (il.iIi1() == p051lLi1LL.I1I.p055L11I.IL.CLOSING) {
            il.m3529lLi1LL(iLil, strLlLI1, true);
        } else if (mo3542Ll1() == p051lLi1LL.I1I.p055L11I.IL1Iii.TWOWAY) {
            il.I1I(iLil, strLlLI1, true);
        } else {
            il.m3511ILl(iLil, strLlLI1, false);
        }
    }

    @Override // p051lLi1LL.I1I.p053IiL.IL1Iii
    public void iIi1() {
        this.f2988il = null;
        p051lLi1LL.I1I.ILL.ILil iLil = this.f2982IL;
        if (iLil != null) {
            iLil.reset();
        }
        this.f2982IL = new p051lLi1LL.I1I.ILL.IL1Iii();
        this.f2987lLi1LL = null;
    }

    public final void iIilII1(IL il, iILLL1 iilll1) throws I1I {
        try {
            il.m3532lL().onWebsocketMessage(il, p051lLi1LL.I1I.LlLI1.I1I.Ilil(iilll1.mo3586lLi1LL()));
        } catch (RuntimeException e) {
            m3567lliiI1(il, e);
        }
    }

    @Override // p051lLi1LL.I1I.p053IiL.IL1Iii
    /* JADX INFO: renamed from: iI丨LLL1 */
    public ByteBuffer mo3544iILLL1(iILLL1 iilll1) {
        m3565l1IIi1().Ilil(iilll1);
        if (this.f5442I1I.isTraceEnabled()) {
            this.f5442I1I.trace("afterEnconding({}): {}", Integer.valueOf(iilll1.mo3586lLi1LL().remaining()), iilll1.mo3586lLi1LL().remaining() > 1000 ? "too big to display" : new String(iilll1.mo3586lLi1LL().array()));
        }
        return m3555L111(iilll1);
    }

    /* JADX INFO: renamed from: ili丨11, reason: contains not printable characters */
    public final p051lLi1LL.I1I.p055L11I.I1I m3563ili11(byte b) throws lLi1LL {
        if (b == 0) {
            return p051lLi1LL.I1I.p055L11I.I1I.CONTINUOUS;
        }
        if (b == 1) {
            return p051lLi1LL.I1I.p055L11I.I1I.TEXT;
        }
        if (b == 2) {
            return p051lLi1LL.I1I.p055L11I.I1I.BINARY;
        }
        switch (b) {
            case 8:
                return p051lLi1LL.I1I.p055L11I.I1I.CLOSING;
            case 9:
                return p051lLi1LL.I1I.p055L11I.I1I.PING;
            case 10:
                return p051lLi1LL.I1I.p055L11I.I1I.PONG;
            default:
                throw new lLi1LL("Unknown opcode " + ((int) b));
        }
    }

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public final ByteBuffer m3564ill() throws p051lLi1LL.I1I.p058il.IiL {
        ByteBuffer byteBufferAllocate;
        synchronized (this.f2985L11I) {
            Iterator<ByteBuffer> it = this.f2985L11I.iterator();
            long jLimit = 0;
            while (it.hasNext()) {
                jLimit += (long) it.next().limit();
            }
            m3561LlLLL();
            byteBufferAllocate = ByteBuffer.allocate((int) jLimit);
            Iterator<ByteBuffer> it2 = this.f2985L11I.iterator();
            while (it2.hasNext()) {
                byteBufferAllocate.put(it2.next());
            }
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public p051lLi1LL.I1I.ILL.ILil m3565l1IIi1() {
        return this.f2982IL;
    }

    @Override // p051lLi1LL.I1I.p053IiL.IL1Iii
    /* JADX INFO: renamed from: lIi丨I */
    public p051lLi1LL.I1I.p057lIiI.ILil mo3545lIiI(p051lLi1LL.I1I.p057lIiI.ILil iLil) {
        iLil.I1I("Upgrade", "websocket");
        iLil.I1I("Connection", "Upgrade");
        byte[] bArr = new byte[16];
        this.ILL.nextBytes(bArr);
        iLil.I1I("Sec-WebSocket-Key", p051lLi1LL.I1I.LlLI1.IL1Iii.m3579iILLL1(bArr));
        iLil.I1I("Sec-WebSocket-Version", "13");
        StringBuilder sb = new StringBuilder();
        for (p051lLi1LL.I1I.ILL.ILil iLil2 : this.f5443Ilil) {
            if (iLil2.mo3509iILLL1() != null && iLil2.mo3509iILLL1().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(iLil2.mo3509iILLL1());
            }
        }
        if (sb.length() != 0) {
            iLil.I1I("Sec-WebSocket-Extensions", sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (p051lLi1LL.I1I.Lil.IL1Iii iL1Iii : this.f2986iILLL1) {
            if (iL1Iii.ILil().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(iL1Iii.ILil());
            }
        }
        if (sb2.length() != 0) {
            iLil.I1I("Sec-WebSocket-Protocol", sb2.toString());
        }
        return iLil;
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public final void m3566lIII() {
        synchronized (this.f2985L11I) {
            this.f2985L11I.clear();
        }
    }

    public final long llI() {
        long jLimit;
        synchronized (this.f2985L11I) {
            Iterator<ByteBuffer> it = this.f2985L11I.iterator();
            jLimit = 0;
            while (it.hasNext()) {
                jLimit += (long) it.next().limit();
            }
        }
        return jLimit;
    }

    @Override // p051lLi1LL.I1I.p053IiL.IL1Iii
    /* JADX INFO: renamed from: l丨Li1LL */
    public p051lLi1LL.I1I.p053IiL.IL1Iii mo3547lLi1LL() {
        ArrayList arrayList = new ArrayList();
        Iterator<p051lLi1LL.I1I.ILL.ILil> it = m3560L1l().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().IL1Iii());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<p051lLi1LL.I1I.Lil.IL1Iii> it2 = m3569iILLl().iterator();
        while (it2.hasNext()) {
            arrayList2.add(it2.next().IL1Iii());
        }
        return new ILil(arrayList, arrayList2, this.f2984Ll1);
    }

    /* JADX INFO: renamed from: l丨liiI1, reason: contains not printable characters */
    public final void m3567lliiI1(IL il, RuntimeException runtimeException) {
        this.f5442I1I.error("Runtime exception during onWebsocketMessage", runtimeException);
        il.m3532lL().onWebsocketError(il, runtimeException);
    }

    /* JADX INFO: renamed from: l丨丨i11, reason: contains not printable characters */
    public final void m3568li11(iILLL1 iilll1) throws I1I {
        if (this.f2983IiL != null) {
            this.f5442I1I.trace("Protocol error: Previous continuous frame sequence not completed.");
            throw new I1I(MysqlErrorNumbers.ER_NO, "Previous continuous frame sequence not completed.");
        }
        this.f2983IiL = iilll1;
        m35711(iilll1.mo3586lLi1LL());
        m3561LlLLL();
    }

    @Override // p051lLi1LL.I1I.p053IiL.IL1Iii
    public String toString() {
        String string = super.toString();
        if (m3565l1IIi1() != null) {
            string = string + " extension: " + m3565l1IIi1().toString();
        }
        if (m3572() != null) {
            string = string + " protocol: " + m3572().toString();
        }
        return string + " max frame size: " + this.f2984Ll1;
    }

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public List<p051lLi1LL.I1I.Lil.IL1Iii> m3569iILLl() {
        return this.f2986iILLL1;
    }

    /* JADX INFO: renamed from: 丨丨 */
    public final String m829(String str) {
        try {
            return p051lLi1LL.I1I.LlLI1.IL1Iii.m3579iILLL1(MessageDigest.getInstance("SHA1").digest((str.trim() + WebSocketProtocol.ACCEPT_MAGIC).getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public final byte m3570LLlI1(p051lLi1LL.I1I.p055L11I.I1I i1i) {
        if (i1i == p051lLi1LL.I1I.p055L11I.I1I.CONTINUOUS) {
            return (byte) 0;
        }
        if (i1i == p051lLi1LL.I1I.p055L11I.I1I.TEXT) {
            return (byte) 1;
        }
        if (i1i == p051lLi1LL.I1I.p055L11I.I1I.BINARY) {
            return (byte) 2;
        }
        if (i1i == p051lLi1LL.I1I.p055L11I.I1I.CLOSING) {
            return (byte) 8;
        }
        if (i1i == p051lLi1LL.I1I.p055L11I.I1I.PING) {
            return (byte) 9;
        }
        if (i1i == p051lLi1LL.I1I.p055L11I.I1I.PONG) {
            return (byte) 10;
        }
        throw new IllegalArgumentException("Don't know how to handle " + i1i.toString());
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public final void m35711(ByteBuffer byteBuffer) {
        synchronized (this.f2985L11I) {
            this.f2985L11I.add(byteBuffer);
        }
    }

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public p051lLi1LL.I1I.Lil.IL1Iii m3572() {
        return this.f2987lLi1LL;
    }

    public ILil(List<p051lLi1LL.I1I.ILL.ILil> list) {
        this(list, Collections.singletonList(new p051lLi1LL.I1I.Lil.ILil(BuildConfig.FLAVOR)));
    }

    public ILil(List<p051lLi1LL.I1I.ILL.ILil> list, List<p051lLi1LL.I1I.Lil.IL1Iii> list2) {
        this(list, list2, Integer.MAX_VALUE);
    }

    public ILil(List<p051lLi1LL.I1I.ILL.ILil> list, List<p051lLi1LL.I1I.Lil.IL1Iii> list2, int i) {
        this.f5442I1I = p051lLi1LL.p060IL.I1I.m3681L11I(ILil.class);
        this.f2982IL = new p051lLi1LL.I1I.ILL.IL1Iii();
        this.ILL = new Random();
        if (list != null && list2 != null && i >= 1) {
            this.f5443Ilil = new ArrayList(list.size());
            this.f2986iILLL1 = new ArrayList(list2.size());
            boolean z = false;
            this.f2985L11I = new ArrayList();
            Iterator<p051lLi1LL.I1I.ILL.ILil> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().getClass().equals(p051lLi1LL.I1I.ILL.IL1Iii.class)) {
                    z = true;
                }
            }
            this.f5443Ilil.addAll(list);
            if (!z) {
                List<p051lLi1LL.I1I.ILL.ILil> list3 = this.f5443Ilil;
                list3.add(list3.size(), this.f2982IL);
            }
            this.f2986iILLL1.addAll(list2);
            this.f2984Ll1 = i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
