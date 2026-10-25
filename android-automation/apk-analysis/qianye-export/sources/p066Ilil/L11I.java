package p066Ilil;

import java.io.IOException;

/* JADX INFO: renamed from: Ilil.L丨1丨1丨I, reason: invalid class name */
/* JADX INFO: compiled from: ForwardingSource.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class L11I implements I11li1 {
    private final I11li1 delegate;

    public L11I(I11li1 i11li1) {
        if (i11li1 == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.delegate = i11li1;
    }

    @Override // p066Ilil.I11li1, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final I11li1 delegate() {
        return this.delegate;
    }

    @Override // p066Ilil.I11li1
    public long read(I1I i1i, long j) throws IOException {
        return this.delegate.read(i1i, j);
    }

    @Override // p066Ilil.I11li1, p066Ilil.iIlLiL
    public lL timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
    }
}
