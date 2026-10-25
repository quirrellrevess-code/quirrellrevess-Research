package p051lLi1LL.I1I.p054Ll1;

import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.MysqlErrorNumbers;
import java.nio.ByteBuffer;
import p051lLi1LL.I1I.p055L11I.I1I;
import p051lLi1LL.I1I.p058il.lLi1LL;

/* JADX INFO: compiled from: CloseFrame.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil extends IL {

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public int f2997IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public String f2998L11I;

    public ILil() {
        super(I1I.CLOSING);
        m3584lIlii(BuildConfig.FLAVOR);
        m3585llL1ii(1000);
    }

    @Override // p051lLi1LL.I1I.p054Ll1.IL, p051lLi1LL.I1I.p054Ll1.IiL
    /* JADX INFO: renamed from: I丨iL */
    public void mo3583IiL() throws p051lLi1LL.I1I.p058il.I1I {
        super.mo3583IiL();
        if (this.f2997IiL == 1007 && this.f2998L11I.isEmpty()) {
            throw new p051lLi1LL.I1I.p058il.I1I(MysqlErrorNumbers.ER_DB_CREATE_EXISTS, "Received text is no valid utf8 string!");
        }
        if (this.f2997IiL == 1005 && this.f2998L11I.length() > 0) {
            throw new p051lLi1LL.I1I.p058il.I1I(MysqlErrorNumbers.ER_NO, "A close frame must have a closecode if it has a reason");
        }
        int i = this.f2997IiL;
        if (i > 1015 && i < 3000) {
            throw new p051lLi1LL.I1I.p058il.I1I(MysqlErrorNumbers.ER_NO, "Trying to send an illegal close code!");
        }
        if (i == 1006 || i == 1015 || i == 1005 || i > 4999 || i < 1000 || i == 1004) {
            throw new lLi1LL("closecode must not be sent over the wire: " + this.f2997IiL);
        }
    }

    public int Lil() {
        return this.f2997IiL;
    }

    public String LlLI1() {
        return this.f2998L11I;
    }

    @Override // p051lLi1LL.I1I.p054Ll1.IiL
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ILil.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        ILil iLil = (ILil) obj;
        if (this.f2997IiL != iLil.f2997IiL) {
            return false;
        }
        String str = this.f2998L11I;
        String str2 = iLil.f2998L11I;
        if (str != null) {
            return str.equals(str2);
        }
        return str2 == null;
    }

    @Override // p051lLi1LL.I1I.p054Ll1.IiL
    public int hashCode() {
        int iHashCode = ((super.hashCode() * 31) + this.f2997IiL) * 31;
        String str = this.f2998L11I;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final void iIi1() {
        byte[] bArrM3575lLi1LL = p051lLi1LL.I1I.LlLI1.I1I.m3575lLi1LL(this.f2998L11I);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.putInt(this.f2997IiL);
        byteBufferAllocate.position(2);
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(bArrM3575lLi1LL.length + 2);
        byteBufferAllocate2.put(byteBufferAllocate);
        byteBufferAllocate2.put(bArrM3575lLi1LL);
        byteBufferAllocate2.rewind();
        super.mo3587il(byteBufferAllocate2);
    }

    public final void iIlLiL(ByteBuffer byteBuffer, int i) throws p051lLi1LL.I1I.p058il.I1I {
        try {
            try {
                byteBuffer.position(byteBuffer.position() + 2);
                this.f2998L11I = p051lLi1LL.I1I.LlLI1.I1I.Ilil(byteBuffer);
                byteBuffer.position(i);
            } catch (IllegalArgumentException unused) {
                throw new p051lLi1LL.I1I.p058il.I1I(MysqlErrorNumbers.ER_DB_CREATE_EXISTS);
            }
        } catch (Throwable th) {
            byteBuffer.position(i);
            throw th;
        }
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public void m3584lIlii(String str) {
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        this.f2998L11I = str;
        iIi1();
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public void m3585llL1ii(int i) {
        this.f2997IiL = i;
        if (i == 1015) {
            this.f2997IiL = 1005;
            this.f2998L11I = BuildConfig.FLAVOR;
        }
        iIi1();
    }

    @Override // p051lLi1LL.I1I.p054Ll1.IiL, p051lLi1LL.I1I.p054Ll1.iILLL1
    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public ByteBuffer mo3586lLi1LL() {
        return this.f2997IiL == 1005 ? p051lLi1LL.I1I.LlLI1.ILil.IL1Iii() : super.mo3586lLi1LL();
    }

    @Override // p051lLi1LL.I1I.p054Ll1.IiL
    public String toString() {
        return super.toString() + "code: " + this.f2997IiL;
    }

    @Override // p051lLi1LL.I1I.p054Ll1.IiL
    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void mo3587il(ByteBuffer byteBuffer) {
        this.f2997IiL = 1005;
        this.f2998L11I = BuildConfig.FLAVOR;
        byteBuffer.mark();
        if (byteBuffer.remaining() == 0) {
            this.f2997IiL = 1000;
            return;
        }
        if (byteBuffer.remaining() == 1) {
            this.f2997IiL = MysqlErrorNumbers.ER_NO;
            return;
        }
        if (byteBuffer.remaining() >= 2) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            byteBufferAllocate.position(2);
            byteBufferAllocate.putShort(byteBuffer.getShort());
            byteBufferAllocate.position(0);
            this.f2997IiL = byteBufferAllocate.getInt();
        }
        byteBuffer.reset();
        try {
            iIlLiL(byteBuffer, byteBuffer.position());
        } catch (p051lLi1LL.I1I.p058il.I1I unused) {
            this.f2997IiL = MysqlErrorNumbers.ER_DB_CREATE_EXISTS;
            this.f2998L11I = null;
        }
    }
}
