package p066Ilil;

import java.io.IOException;

/* JADX INFO: renamed from: Ilil.I丨iL, reason: invalid class name */
/* JADX INFO: compiled from: ForwardingSink.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class IiL implements iIlLiL {
    private final iIlLiL delegate;

    public IiL(iIlLiL iillil) {
        if (iillil == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.delegate = iillil;
    }

    @Override // p066Ilil.iIlLiL, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final iIlLiL delegate() {
        return this.delegate;
    }

    @Override // p066Ilil.iIlLiL, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // p066Ilil.iIlLiL
    public lL timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
    }

    @Override // p066Ilil.iIlLiL
    public void write(I1I i1i, long j) throws IOException {
        this.delegate.write(i1i, j);
    }
}
