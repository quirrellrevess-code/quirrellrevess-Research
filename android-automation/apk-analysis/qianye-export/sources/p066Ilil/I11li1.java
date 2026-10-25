package p066Ilil;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: compiled from: Source.java */
/* JADX INFO: loaded from: classes.dex */
public interface I11li1 extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long read(I1I i1i, long j) throws IOException;

    lL timeout();
}
