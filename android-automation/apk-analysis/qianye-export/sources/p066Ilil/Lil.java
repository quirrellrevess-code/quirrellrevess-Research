package p066Ilil;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: RealBufferedSink.java */
/* JADX INFO: loaded from: classes.dex */
public final class Lil implements IL {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final iIlLiL f4577I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final I1I f4578ILil = new I1I();

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean f2063IL;

    public Lil(iIlLiL iillil) {
        Objects.requireNonNull(iillil, "sink == null");
        this.f4577I1I = iillil;
    }

    @Override // p066Ilil.IL
    public long I11li1(I11li1 i11li1) throws IOException {
        if (i11li1 == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long j2 = i11li1.read(this.f4578ILil, 8192L);
            if (j2 == -1) {
                return j;
            }
            j += j2;
            mo2773ILl();
        }
    }

    @Override // p066Ilil.IL
    public IL I1I() throws IOException {
        if (this.f2063IL) {
            throw new IllegalStateException("closed");
        }
        long jM96I = this.f4578ILil.m96I();
        if (jM96I > 0) {
            this.f4577I1I.write(this.f4578ILil, jM96I);
        }
        return this;
    }

    @Override // p066Ilil.IL
    public I1I IL1Iii() {
        return this.f4578ILil;
    }

    @Override // p066Ilil.IL
    /* JADX INFO: renamed from: IL丨丨l */
    public IL mo2773ILl() throws IOException {
        if (this.f2063IL) {
            throw new IllegalStateException("closed");
        }
        long jM2780LlIl = this.f4578ILil.m2780LlIl();
        if (jM2780LlIl > 0) {
            this.f4577I1I.write(this.f4578ILil, jM2780LlIl);
        }
        return this;
    }

    @Override // p066Ilil.IL
    /* JADX INFO: renamed from: I丨L */
    public IL mo2775IL(int i) throws IOException {
        if (this.f2063IL) {
            throw new IllegalStateException("closed");
        }
        this.f4578ILil.m2787iIl1il(i);
        mo2773ILl();
        return this;
    }

    @Override // p066Ilil.IL
    public IL LL1IL(iILLL1 iilll1) throws IOException {
        if (this.f2063IL) {
            throw new IllegalStateException("closed");
        }
        this.f4578ILil.m2803i11i(iilll1);
        mo2773ILl();
        return this;
    }

    @Override // p066Ilil.IL
    public IL LlLI1(String str) throws IOException {
        if (this.f2063IL) {
            throw new IllegalStateException("closed");
        }
        this.f4578ILil.Liil1L1l(str);
        mo2773ILl();
        return this;
    }

    @Override // p066Ilil.IL
    /* JADX INFO: renamed from: Ll丨1 */
    public IL mo2782Ll1(int i) throws IOException {
        if (this.f2063IL) {
            throw new IllegalStateException("closed");
        }
        this.f4578ILil.l1Lll(i);
        mo2773ILl();
        return this;
    }

    @Override // p066Ilil.IL
    /* JADX INFO: renamed from: L丨1l */
    public OutputStream mo2783L1l() {
        return new IL1Iii();
    }

    @Override // p066Ilil.iIlLiL, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f2063IL) {
            return;
        }
        I1I i1i = this.f4578ILil;
        long j = i1i.f4559I1I;
        if (j > 0) {
            this.f4577I1I.write(i1i, j);
        }
        th = null;
        try {
            this.f4577I1I.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        this.f2063IL = true;
        if (th == null) {
            return;
        }
        I11L.Ilil(th);
        throw null;
    }

    @Override // p066Ilil.IL, p066Ilil.iIlLiL, java.io.Flushable
    public void flush() throws IOException {
        if (this.f2063IL) {
            throw new IllegalStateException("closed");
        }
        I1I i1i = this.f4578ILil;
        long j = i1i.f4559I1I;
        if (j > 0) {
            this.f4577I1I.write(i1i, j);
        }
        this.f4577I1I.flush();
    }

    @Override // p066Ilil.IL
    public IL iIi1(byte[] bArr, int i, int i2) throws IOException {
        if (this.f2063IL) {
            throw new IllegalStateException("closed");
        }
        this.f4578ILil.m100lL(bArr, i, i2);
        mo2773ILl();
        return this;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f2063IL;
    }

    @Override // p066Ilil.IL
    /* JADX INFO: renamed from: l1IIi1丨 */
    public IL mo2794l1IIi1(long j) throws IOException {
        if (this.f2063IL) {
            throw new IllegalStateException("closed");
        }
        this.f4578ILil.I1IILIIL(j);
        mo2773ILl();
        return this;
    }

    @Override // p066Ilil.IL
    /* JADX INFO: renamed from: lI丨II */
    public IL mo2797lIII(byte[] bArr) throws IOException {
        if (this.f2063IL) {
            throw new IllegalStateException("closed");
        }
        this.f4578ILil.L1iI1(bArr);
        mo2773ILl();
        return this;
    }

    @Override // p066Ilil.IL
    /* JADX INFO: renamed from: l丨Li1LL */
    public IL mo2800lLi1LL(int i) throws IOException {
        if (this.f2063IL) {
            throw new IllegalStateException("closed");
        }
        this.f4578ILil.m2795lIIiIlL(i);
        mo2773ILl();
        return this;
    }

    @Override // p066Ilil.iIlLiL
    public lL timeout() {
        return this.f4577I1I.timeout();
    }

    public String toString() {
        return "buffer(" + this.f4577I1I + ")";
    }

    @Override // p066Ilil.iIlLiL
    public void write(I1I i1i, long j) throws IOException {
        if (this.f2063IL) {
            throw new IllegalStateException("closed");
        }
        this.f4578ILil.write(i1i, j);
        mo2773ILl();
    }

    @Override // p066Ilil.IL
    /* JADX INFO: renamed from: 丨lL */
    public IL mo2807lL(long j) throws IOException {
        if (this.f2063IL) {
            throw new IllegalStateException("closed");
        }
        this.f4578ILil.ill1LI1l(j);
        mo2773ILl();
        return this;
    }

    /* JADX INFO: compiled from: RealBufferedSink.java */
    public class IL1Iii extends OutputStream {
        public IL1Iii() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws Throwable {
            Lil.this.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            Lil lil = Lil.this;
            if (lil.f2063IL) {
                return;
            }
            lil.flush();
        }

        public String toString() {
            return Lil.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            Lil lil = Lil.this;
            if (lil.f2063IL) {
                throw new IOException("closed");
            }
            lil.f4578ILil.l1Lll((byte) i);
            Lil.this.mo2773ILl();
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            Lil lil = Lil.this;
            if (!lil.f2063IL) {
                lil.f4578ILil.m100lL(bArr, i, i2);
                Lil.this.mo2773ILl();
                return;
            }
            throw new IOException("closed");
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f2063IL) {
            int iWrite = this.f4578ILil.write(byteBuffer);
            mo2773ILl();
            return iWrite;
        }
        throw new IllegalStateException("closed");
    }
}
