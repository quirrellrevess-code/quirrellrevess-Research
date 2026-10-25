package p066Ilil;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: GzipSource.java */
/* JADX INFO: loaded from: classes.dex */
public final class ILL implements I11li1 {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final lLi1LL f4570I1I;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final Ll1 f4572Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final Inflater f2061IL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f4571ILil = 0;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final CRC32 f2062lLi1LL = new CRC32();

    public ILL(I11li1 i11li1) {
        if (i11li1 == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.f2061IL = inflater;
        lLi1LL lli1llM2826IL = lIiI.m2826IL(i11li1);
        this.f4570I1I = lli1llM2826IL;
        this.f4572Ilil = new Ll1(lli1llM2826IL, inflater);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final void m2814IiL(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
    public final void m2815L11() throws IOException {
        m2814IiL("CRC", this.f4570I1I.mo2808l(), (int) this.f2062lLi1LL.getValue());
        m2814IiL("ISIZE", this.f4570I1I.mo2808l(), (int) this.f2061IL.getBytesWritten());
    }

    /* JADX INFO: renamed from: LlIl丨, reason: contains not printable characters */
    public final void m2816LlIl(I1I i1i, long j, long j2) {
        llL1ii lll1ii = i1i.f4560ILil;
        while (true) {
            int i = lll1ii.f4594I1I;
            int i2 = lll1ii.f4596ILil;
            if (j < i - i2) {
                break;
            }
            j -= (long) (i - i2);
            lll1ii = lll1ii.f2068lLi1LL;
        }
        while (j2 > 0) {
            int i3 = (int) (((long) lll1ii.f4596ILil) + j);
            int iMin = (int) Math.min(lll1ii.f4594I1I - i3, j2);
            this.f2062lLi1LL.update(lll1ii.f4595IL1Iii, i3, iMin);
            j2 -= (long) iMin;
            lll1ii = lll1ii.f2068lLi1LL;
            j = 0;
        }
    }

    @Override // p066Ilil.I11li1, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f4572Ilil.close();
    }

    @Override // p066Ilil.I11li1
    public long read(I1I i1i, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return 0L;
        }
        if (this.f4571ILil == 0) {
            m2817();
            this.f4571ILil = 1;
        }
        if (this.f4571ILil == 1) {
            long j2 = i1i.f4559I1I;
            long j3 = this.f4572Ilil.read(i1i, j);
            if (j3 != -1) {
                m2816LlIl(i1i, j2, j3);
                return j3;
            }
            this.f4571ILil = 2;
        }
        if (this.f4571ILil == 2) {
            m2815L11();
            this.f4571ILil = 3;
            if (!this.f4570I1I.ILL()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // p066Ilil.I11li1, p066Ilil.iIlLiL
    public lL timeout() {
        return this.f4570I1I.timeout();
    }

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public final void m2817() throws IOException {
        this.f4570I1I.llI(10L);
        byte bLLL = this.f4570I1I.IL1Iii().LLL(3L);
        boolean z = ((bLLL >> 1) & 1) == 1;
        if (z) {
            m2816LlIl(this.f4570I1I.IL1Iii(), 0L, 10L);
        }
        m2814IiL("ID1ID2", 8075, this.f4570I1I.mo101());
        this.f4570I1I.I11L(8L);
        if (((bLLL >> 2) & 1) == 1) {
            this.f4570I1I.llI(2L);
            if (z) {
                m2816LlIl(this.f4570I1I.IL1Iii(), 0L, 2L);
            }
            long jMo2777L111 = this.f4570I1I.IL1Iii().mo2777L111();
            this.f4570I1I.llI(jMo2777L111);
            if (z) {
                m2816LlIl(this.f4570I1I.IL1Iii(), 0L, jMo2777L111);
            }
            this.f4570I1I.I11L(jMo2777L111);
        }
        if (((bLLL >> 3) & 1) == 1) {
            long jMo2805iILLl = this.f4570I1I.mo2805iILLl((byte) 0);
            if (jMo2805iILLl == -1) {
                throw new EOFException();
            }
            if (z) {
                m2816LlIl(this.f4570I1I.IL1Iii(), 0L, jMo2805iILLl + 1);
            }
            this.f4570I1I.I11L(jMo2805iILLl + 1);
        }
        if (((bLLL >> 4) & 1) == 1) {
            long jMo2805iILLl2 = this.f4570I1I.mo2805iILLl((byte) 0);
            if (jMo2805iILLl2 == -1) {
                throw new EOFException();
            }
            if (z) {
                m2816LlIl(this.f4570I1I.IL1Iii(), 0L, jMo2805iILLl2 + 1);
            }
            this.f4570I1I.I11L(jMo2805iILLl2 + 1);
        }
        if (z) {
            m2814IiL("FHCRC", this.f4570I1I.mo2777L111(), (short) this.f2062lLi1LL.getValue());
            this.f2062lLi1LL.reset();
        }
    }
}
