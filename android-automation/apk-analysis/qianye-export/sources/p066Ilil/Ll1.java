package p066Ilil;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: renamed from: Ilil.Ll丨1, reason: invalid class name */
/* JADX INFO: compiled from: InflaterSource.java */
/* JADX INFO: loaded from: classes.dex */
public final class Ll1 implements I11li1 {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final Inflater f4583I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final lLi1LL f4584ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public boolean f4585Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f2065IL;

    public Ll1(lLi1LL lli1ll, Inflater inflater) {
        if (lli1ll == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f4584ILil = lli1ll;
        this.f4583I1I = inflater;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final boolean m2822IiL() throws IOException {
        if (!this.f4583I1I.needsInput()) {
            return false;
        }
        m2823();
        if (this.f4583I1I.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.f4584ILil.ILL()) {
            return true;
        }
        llL1ii lll1ii = this.f4584ILil.IL1Iii().f4560ILil;
        int i = lll1ii.f4594I1I;
        int i2 = lll1ii.f4596ILil;
        int i3 = i - i2;
        this.f2065IL = i3;
        this.f4583I1I.setInput(lll1ii.f4595IL1Iii, i2, i3);
        return false;
    }

    @Override // p066Ilil.I11li1, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f4585Ilil) {
            return;
        }
        this.f4583I1I.end();
        this.f4585Ilil = true;
        this.f4584ILil.close();
    }

    @Override // p066Ilil.I11li1
    public long read(I1I i1i, long j) throws IOException {
        boolean zM2822IiL;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f4585Ilil) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        do {
            zM2822IiL = m2822IiL();
            try {
                llL1ii lll1iiM95I1 = i1i.m95I1(1);
                int iInflate = this.f4583I1I.inflate(lll1iiM95I1.f4595IL1Iii, lll1iiM95I1.f4594I1I, (int) Math.min(j, 8192 - lll1iiM95I1.f4594I1I));
                if (iInflate > 0) {
                    lll1iiM95I1.f4594I1I += iInflate;
                    long j2 = iInflate;
                    i1i.f4559I1I += j2;
                    return j2;
                }
                if (!this.f4583I1I.finished() && !this.f4583I1I.needsDictionary()) {
                }
                m2823();
                if (lll1iiM95I1.f4596ILil != lll1iiM95I1.f4594I1I) {
                    return -1L;
                }
                i1i.f4560ILil = lll1iiM95I1.ILil();
                lIlii.IL1Iii(lll1iiM95I1);
                return -1L;
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        } while (!zM2822IiL);
        throw new EOFException("source exhausted prematurely");
    }

    @Override // p066Ilil.I11li1, p066Ilil.iIlLiL
    public lL timeout() {
        return this.f4584ILil.timeout();
    }

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public final void m2823() throws IOException {
        int i = this.f2065IL;
        if (i == 0) {
            return;
        }
        int remaining = i - this.f4583I1I.getRemaining();
        this.f2065IL -= remaining;
        this.f4584ILil.I11L(remaining);
    }
}
