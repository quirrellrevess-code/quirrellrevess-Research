package p066Ilil;

import androidx.recyclerview.widget.RecyclerView;
import com.mysql.jdbc.StatementImpl;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* JADX INFO: compiled from: RealBufferedSource.java */
/* JADX INFO: loaded from: classes.dex */
public final class LlLI1 implements lLi1LL {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final I11li1 f4580I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final I1I f4581ILil = new I1I();

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean f2064IL;

    public LlLI1(I11li1 i11li1) {
        Objects.requireNonNull(i11li1, "source == null");
        this.f4580I1I = i11li1;
    }

    @Override // p066Ilil.lLi1LL
    public void I11L(long j) throws IOException {
        if (this.f2064IL) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            I1I i1i = this.f4581ILil;
            if (i1i.f4559I1I == 0 && this.f4580I1I.read(i1i, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, this.f4581ILil.m96I());
            this.f4581ILil.I11L(jMin);
            j -= jMin;
        }
    }

    @Override // p066Ilil.lLi1LL, p066Ilil.IL
    public I1I IL1Iii() {
        return this.f4581ILil;
    }

    @Override // p066Ilil.lLi1LL
    public boolean ILL() throws IOException {
        if (this.f2064IL) {
            throw new IllegalStateException("closed");
        }
        return this.f4581ILil.ILL() && this.f4580I1I.read(this.f4581ILil, 8192L) == -1;
    }

    @Override // p066Ilil.lLi1LL
    public iILLL1 ILil(long j) throws IOException {
        llI(j);
        return this.f4581ILil.ILil(j);
    }

    @Override // p066Ilil.lLi1LL
    public int Ilil() throws IOException {
        llI(4L);
        return this.f4581ILil.Ilil();
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: I丨Ii */
    public long mo2774IIi() throws IOException {
        llI(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!m2821(i2)) {
                break;
            }
            byte bLLL = this.f4581ILil.LLL(i);
            if ((bLLL < 48 || bLLL > 57) && ((bLLL < 97 || bLLL > 102) && (bLLL < 65 || bLLL > 70))) {
                if (i != 0) {
                    break;
                }
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(bLLL)));
            }
            i = i2;
        }
        return this.f4581ILil.mo2774IIi();
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public long m2820IiL(byte b, long j, long j2) throws IOException {
        if (this.f2064IL) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long jM2786iI1iI = this.f4581ILil.m2786iI1iI(b, j, j2);
            if (jM2786iI1iI != -1) {
                return jM2786iI1iI;
            }
            I1I i1i = this.f4581ILil;
            long j3 = i1i.f4559I1I;
            if (j3 >= j2 || this.f4580I1I.read(i1i, 8192L) == -1) {
                break;
            }
            j = Math.max(j, j3);
        }
        return -1L;
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: L11丨丨丨1 */
    public short mo2777L111() throws IOException {
        llI(2L);
        return this.f4581ILil.mo2777L111();
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: LI丨丨l丨l */
    public InputStream mo2779LIll() {
        return new IL1Iii();
    }

    @Override // p066Ilil.lLi1LL
    public String Lil(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j == RecyclerView.FOREVER_NS ? Long.MAX_VALUE : j + 1;
        long jM2820IiL = m2820IiL((byte) 10, 0L, j2);
        if (jM2820IiL != -1) {
            return this.f4581ILil.m99iI(jM2820IiL);
        }
        if (j2 < RecyclerView.FOREVER_NS && m2821(j2) && this.f4581ILil.LLL(j2 - 1) == 13 && m2821(1 + j2) && this.f4581ILil.LLL(j2) == 10) {
            return this.f4581ILil.m99iI(j2);
        }
        I1I i1i = new I1I();
        I1I i1i2 = this.f4581ILil;
        i1i2.m2771IIiI(i1i, 0L, Math.min(32L, i1i2.m96I()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f4581ILil.m96I(), j) + " content=" + i1i.m98i1().hex() + (char) 8230);
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: L丨1丨1丨I */
    public byte[] mo2784L11I() throws IOException {
        this.f4581ILil.I11li1(this.f4580I1I);
        return this.f4581ILil.mo2784L11I();
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: L丨lLLL */
    public String mo2785LlLLL() throws IOException {
        this.f4581ILil.I11li1(this.f4580I1I);
        return this.f4581ILil.mo2785LlLLL();
    }

    @Override // p066Ilil.I11li1, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f2064IL) {
            return;
        }
        this.f2064IL = true;
        this.f4580I1I.close();
        this.f4581ILil.m2811();
    }

    @Override // p066Ilil.lLi1LL
    public void iIlLiL(byte[] bArr) throws IOException {
        try {
            llI(bArr.length);
            this.f4581ILil.iIlLiL(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                I1I i1i = this.f4581ILil;
                long j = i1i.f4559I1I;
                if (j <= 0) {
                    throw e;
                }
                int iM2802li11 = i1i.m2802li11(bArr, i, (int) j);
                if (iM2802li11 == -1) {
                    throw new AssertionError();
                }
                i += iM2802li11;
            }
        }
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: iI丨LLL1 */
    public long mo2788iILLL1() throws IOException {
        llI(8L);
        return this.f4581ILil.mo2788iILLL1();
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: il丨l丨 */
    public int mo2792ill(C0652ILl c0652ILl) throws IOException {
        if (this.f2064IL) {
            throw new IllegalStateException("closed");
        }
        do {
            int iM2781LlLiLL = this.f4581ILil.m2781LlLiLL(c0652ILl, true);
            if (iM2781LlLiLL == -1) {
                return -1;
            }
            if (iM2781LlLiLL != -2) {
                this.f4581ILil.I11L(c0652ILl.f4576ILil[iM2781LlLiLL].size());
                return iM2781LlLiLL;
            }
        } while (this.f4580I1I.read(this.f4581ILil, 8192L) != -1);
        return -1;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f2064IL;
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: lIi丨I */
    public void mo2796lIiI(I1I i1i, long j) throws IOException {
        try {
            llI(j);
            this.f4581ILil.mo2796lIiI(i1i, j);
        } catch (EOFException e) {
            i1i.I11li1(this.f4581ILil);
            throw e;
        }
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: lI丨lii */
    public byte mo2798lIlii() throws IOException {
        llI(1L);
        return this.f4581ILil.mo2798lIlii();
    }

    @Override // p066Ilil.lLi1LL
    public void llI(long j) throws IOException {
        if (!m2821(j)) {
            throw new EOFException();
        }
    }

    @Override // p066Ilil.lLi1LL
    public String llliI() throws IOException {
        return Lil(RecyclerView.FOREVER_NS);
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: ll丨L1ii */
    public String mo2799llL1ii(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.f4581ILil.I11li1(this.f4580I1I);
        return this.f4581ILil.mo2799llL1ii(charset);
    }

    @Override // p066Ilil.I11li1
    public long read(I1I i1i, long j) throws IOException {
        if (i1i == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f2064IL) {
            throw new IllegalStateException("closed");
        }
        I1I i1i2 = this.f4581ILil;
        if (i1i2.f4559I1I == 0 && this.f4580I1I.read(i1i2, 8192L) == -1) {
            return -1L;
        }
        return this.f4581ILil.read(i1i, Math.min(j, this.f4581ILil.f4559I1I));
    }

    @Override // p066Ilil.I11li1, p066Ilil.iIlLiL
    public lL timeout() {
        return this.f4580I1I.timeout();
    }

    public String toString() {
        return "buffer(" + this.f4580I1I + ")";
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: 丨iI丨丨LLl */
    public long mo2805iILLl(byte b) throws IOException {
        return m2820IiL(b, 0L, RecyclerView.FOREVER_NS);
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: 丨il */
    public I1I mo2806il() {
        return this.f4581ILil;
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: 丨l丨 */
    public int mo2808l() throws IOException {
        llI(4L);
        return this.f4581ILil.mo2808l();
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: 丨丨 */
    public short mo101() throws IOException {
        llI(2L);
        return this.f4581ILil.mo101();
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: 丨丨LLlI1 */
    public long mo2809LLlI1(iIlLiL iillil) throws IOException {
        if (iillil == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long j = 0;
        while (this.f4580I1I.read(this.f4581ILil, 8192L) != -1) {
            long jM2780LlIl = this.f4581ILil.m2780LlIl();
            if (jM2780LlIl > 0) {
                j += jM2780LlIl;
                iillil.write(this.f4581ILil, jM2780LlIl);
            }
        }
        if (this.f4581ILil.m96I() <= 0) {
            return j;
        }
        long jM96I = j + this.f4581ILil.m96I();
        I1I i1i = this.f4581ILil;
        iillil.write(i1i, i1i.m96I());
        return jM96I;
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: 丨丨丨1丨 */
    public byte[] mo28101(long j) throws IOException {
        llI(j);
        return this.f4581ILil.mo28101(j);
    }

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public boolean m2821(long j) throws IOException {
        I1I i1i;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f2064IL) {
            throw new IllegalStateException("closed");
        }
        do {
            i1i = this.f4581ILil;
            if (i1i.f4559I1I >= j) {
                return true;
            }
        } while (this.f4580I1I.read(i1i, 8192L) != -1);
        return false;
    }

    /* JADX INFO: compiled from: RealBufferedSource.java */
    public class IL1Iii extends InputStream {
        public IL1Iii() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            LlLI1 llLI1 = LlLI1.this;
            if (llLI1.f2064IL) {
                throw new IOException("closed");
            }
            return (int) Math.min(llLI1.f4581ILil.f4559I1I, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            LlLI1.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            LlLI1 llLI1 = LlLI1.this;
            if (llLI1.f2064IL) {
                throw new IOException("closed");
            }
            I1I i1i = llLI1.f4581ILil;
            if (i1i.f4559I1I == 0 && llLI1.f4580I1I.read(i1i, 8192L) == -1) {
                return -1;
            }
            return LlLI1.this.f4581ILil.mo2798lIlii() & StatementImpl.USES_VARIABLES_UNKNOWN;
        }

        public String toString() {
            return LlLI1.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (!LlLI1.this.f2064IL) {
                I11L.ILil(bArr.length, i, i2);
                LlLI1 llLI1 = LlLI1.this;
                I1I i1i = llLI1.f4581ILil;
                if (i1i.f4559I1I == 0 && llLI1.f4580I1I.read(i1i, 8192L) == -1) {
                    return -1;
                }
                return LlLI1.this.f4581ILil.m2802li11(bArr, i, i2);
            }
            throw new IOException("closed");
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        I1I i1i = this.f4581ILil;
        if (i1i.f4559I1I == 0 && this.f4580I1I.read(i1i, 8192L) == -1) {
            return -1;
        }
        return this.f4581ILil.read(byteBuffer);
    }
}
