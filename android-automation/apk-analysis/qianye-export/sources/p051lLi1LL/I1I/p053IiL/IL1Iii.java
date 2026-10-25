package p051lLi1LL.I1I.p053IiL;

import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.MysqlErrorNumbers;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import p051lLi1LL.I1I.p054Ll1.ILL;
import p051lLi1LL.I1I.p054Ll1.IiL;
import p051lLi1LL.I1I.p055L11I.I1I;
import p051lLi1LL.I1I.p055L11I.lLi1LL;
import p051lLi1LL.I1I.p057lIiI.IL;
import p051lLi1LL.I1I.p057lIiI.InterfaceC0674il;
import p051lLi1LL.I1I.p057lIiI.L11I;
import p051lLi1LL.I1I.p058il.ILil;
import p051lLi1LL.I1I.p058il.iILLL1;

/* JADX INFO: compiled from: Draft.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class IL1Iii {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public lLi1LL f5440IL1Iii = null;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public I1I f5441ILil = null;

    public static p051lLi1LL.I1I.p057lIiI.I1I I11L(ByteBuffer byteBuffer, lLi1LL lli1ll) throws iILLL1 {
        String strM3537llL1ii = m3537llL1ii(byteBuffer);
        if (strM3537llL1ii == null) {
            throw new ILil(byteBuffer.capacity() + 128);
        }
        String[] strArrSplit = strM3537llL1ii.split(" ", 3);
        if (strArrSplit.length != 3) {
            throw new iILLL1();
        }
        p051lLi1LL.I1I.p057lIiI.I1I i1iLlliI = lli1ll == lLi1LL.CLIENT ? llliI(strArrSplit, strM3537llL1ii) : m3538l(strArrSplit, strM3537llL1ii);
        String strM3537llL1ii2 = m3537llL1ii(byteBuffer);
        while (strM3537llL1ii2 != null && strM3537llL1ii2.length() > 0) {
            String[] strArrSplit2 = strM3537llL1ii2.split(":", 2);
            if (strArrSplit2.length != 2) {
                throw new iILLL1("not an http header");
            }
            if (i1iLlliI.Ilil(strArrSplit2[0])) {
                i1iLlliI.I1I(strArrSplit2[0], i1iLlliI.mo3595L11I(strArrSplit2[0]) + "; " + strArrSplit2[1].replaceFirst("^ +", BuildConfig.FLAVOR));
            } else {
                i1iLlliI.I1I(strArrSplit2[0], strArrSplit2[1].replaceFirst("^ +", BuildConfig.FLAVOR));
            }
            strM3537llL1ii2 = m3537llL1ii(byteBuffer);
        }
        if (strM3537llL1ii2 != null) {
            return i1iLlliI;
        }
        throw new ILil();
    }

    public static ByteBuffer LlLI1(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b = 48;
        while (byteBuffer.hasRemaining()) {
            byte b2 = byteBuffer.get();
            byteBufferAllocate.put(b2);
            if (b == 13 && b2 == 10) {
                byteBufferAllocate.limit(byteBufferAllocate.position() - 2);
                byteBufferAllocate.position(0);
                return byteBufferAllocate;
            }
            b = b2;
        }
        byteBuffer.position(byteBuffer.position() - byteBufferAllocate.position());
        return null;
    }

    public static p051lLi1LL.I1I.p057lIiI.I1I llliI(String[] strArr, String str) throws iILLL1 {
        if (!"101".equals(strArr[1])) {
            throw new iILLL1(String.format("Invalid status code received: %s Status line: %s", strArr[1], str));
        }
        if (!"HTTP/1.1".equalsIgnoreCase(strArr[0])) {
            throw new iILLL1(String.format("Invalid status line received: %s Status line: %s", strArr[0], str));
        }
        p051lLi1LL.I1I.p057lIiI.lLi1LL lli1ll = new p051lLi1LL.I1I.p057lIiI.lLi1LL();
        lli1ll.mo3598lLi1LL(Short.parseShort(strArr[1]));
        lli1ll.mo3597IiL(strArr[2]);
        return lli1ll;
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public static String m3537llL1ii(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferLlLI1 = LlLI1(byteBuffer);
        if (byteBufferLlLI1 == null) {
            return null;
        }
        return p051lLi1LL.I1I.LlLI1.I1I.m3574IL(byteBufferLlLI1.array(), 0, byteBufferLlLI1.limit());
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public static p051lLi1LL.I1I.p057lIiI.I1I m3538l(String[] strArr, String str) throws iILLL1 {
        if (!"GET".equalsIgnoreCase(strArr[0])) {
            throw new iILLL1(String.format("Invalid request method received: %s Status line: %s", strArr[0], str));
        }
        if (!"HTTP/1.1".equalsIgnoreCase(strArr[2])) {
            throw new iILLL1(String.format("Invalid status line received: %s Status line: %s", strArr[2], str));
        }
        IL il = new IL();
        il.mo3594iILLL1(strArr[1]);
        return il;
    }

    public abstract List<p051lLi1LL.I1I.p054Ll1.iILLL1> I11li1(ByteBuffer byteBuffer) throws p051lLi1LL.I1I.p058il.I1I;

    public boolean I1I(p051lLi1LL.I1I.p057lIiI.iILLL1 iilll1) {
        return iilll1.mo3595L11I("Upgrade").equalsIgnoreCase("websocket") && iilll1.mo3595L11I("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade");
    }

    public abstract p051lLi1LL.I1I.p055L11I.ILil IL1Iii(p051lLi1LL.I1I.p057lIiI.IL1Iii iL1Iii, L11I l11i) throws iILLL1;

    public List<ByteBuffer> ILL(p051lLi1LL.I1I.p057lIiI.iILLL1 iilll1, boolean z) {
        StringBuilder sb = new StringBuilder(100);
        if (iilll1 instanceof p051lLi1LL.I1I.p057lIiI.IL1Iii) {
            sb.append("GET ");
            sb.append(((p051lLi1LL.I1I.p057lIiI.IL1Iii) iilll1).IL1Iii());
            sb.append(" HTTP/1.1");
        } else {
            if (!(iilll1 instanceof L11I)) {
                throw new IllegalArgumentException("unknown role");
            }
            sb.append("HTTP/1.1 101 ");
            sb.append(((L11I) iilll1).mo3596IL());
        }
        sb.append("\r\n");
        Iterator<String> itILil = iilll1.ILil();
        while (itILil.hasNext()) {
            String next = itILil.next();
            String strMo3595L11I = iilll1.mo3595L11I(next);
            sb.append(next);
            sb.append(": ");
            sb.append(strMo3595L11I);
            sb.append("\r\n");
        }
        sb.append("\r\n");
        byte[] bArrIL1Iii = p051lLi1LL.I1I.LlLI1.I1I.IL1Iii(sb.toString());
        byte[] content = z ? iilll1.getContent() : null;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((content == null ? 0 : content.length) + bArrIL1Iii.length);
        byteBufferAllocate.put(bArrIL1Iii);
        if (content != null) {
            byteBufferAllocate.put(content);
        }
        byteBufferAllocate.flip();
        return Collections.singletonList(byteBufferAllocate);
    }

    public abstract p051lLi1LL.I1I.p055L11I.ILil ILil(p051lLi1LL.I1I.p057lIiI.IL1Iii iL1Iii) throws iILLL1;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public abstract p051lLi1LL.I1I.p057lIiI.I1I mo3539ILl(p051lLi1LL.I1I.p057lIiI.IL1Iii iL1Iii, InterfaceC0674il interfaceC0674il) throws iILLL1;

    public List<p051lLi1LL.I1I.p054Ll1.iILLL1> Ilil(I1I i1i, ByteBuffer byteBuffer, boolean z) {
        IiL ill;
        I1I i1i2 = I1I.BINARY;
        if (i1i != i1i2 && i1i != I1I.TEXT) {
            throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
        }
        if (this.f5441ILil != null) {
            ill = new p051lLi1LL.I1I.p054Ll1.I1I();
        } else {
            this.f5441ILil = i1i;
            if (i1i == i1i2) {
                ill = new p051lLi1LL.I1I.p054Ll1.IL1Iii();
            } else {
                ill = i1i == I1I.TEXT ? new ILL() : null;
            }
        }
        ill.mo3587il(byteBuffer);
        ill.m3592L11I(z);
        try {
            ill.mo3583IiL();
            if (z) {
                this.f5441ILil = null;
            } else {
                this.f5441ILil = i1i;
            }
            return Collections.singletonList(ill);
        } catch (p051lLi1LL.I1I.p058il.I1I e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int m3540IL(int i) throws p051lLi1LL.I1I.p058il.I1I {
        if (i >= 0) {
            return i;
        }
        throw new p051lLi1LL.I1I.p058il.I1I(MysqlErrorNumbers.ER_NO, "Negative count");
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public abstract List<p051lLi1LL.I1I.p054Ll1.iILLL1> mo3541IiL(String str, boolean z);

    public abstract void Lil(p051lLi1LL.I1I.IL il, p051lLi1LL.I1I.p054Ll1.iILLL1 iilll1) throws p051lLi1LL.I1I.p058il.I1I;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public abstract p051lLi1LL.I1I.p055L11I.IL1Iii mo3542Ll1();

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public abstract List<p051lLi1LL.I1I.p054Ll1.iILLL1> mo3543L11I(ByteBuffer byteBuffer, boolean z);

    public abstract void iIi1();

    public void iIlLiL(lLi1LL lli1ll) {
        this.f5440IL1Iii = lli1ll;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public abstract ByteBuffer mo3544iILLL1(p051lLi1LL.I1I.p054Ll1.iILLL1 iilll1);

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public abstract p051lLi1LL.I1I.p057lIiI.ILil mo3545lIiI(p051lLi1LL.I1I.p057lIiI.ILil iLil) throws iILLL1;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public int m3546lIlii(p051lLi1LL.I1I.p057lIiI.iILLL1 iilll1) {
        String strMo3595L11I = iilll1.mo3595L11I("Sec-WebSocket-Version");
        if (strMo3595L11I.length() > 0) {
            try {
                return new Integer(strMo3595L11I.trim()).intValue();
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public abstract IL1Iii mo3547lLi1LL();

    public String toString() {
        return getClass().getSimpleName();
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public List<ByteBuffer> m3548il(p051lLi1LL.I1I.p057lIiI.iILLL1 iilll1) {
        return ILL(iilll1, true);
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public p051lLi1LL.I1I.p057lIiI.iILLL1 m3549lL(ByteBuffer byteBuffer) throws iILLL1 {
        return I11L(byteBuffer, this.f5440IL1Iii);
    }
}
