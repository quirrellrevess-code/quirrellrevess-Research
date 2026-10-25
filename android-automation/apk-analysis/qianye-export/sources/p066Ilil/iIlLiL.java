package p066Ilil;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* JADX INFO: compiled from: Sink.java */
/* JADX INFO: loaded from: classes.dex */
public interface iIlLiL extends Closeable, Flushable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    @Override // java.io.Flushable
    void flush() throws IOException;

    lL timeout();

    void write(I1I i1i, long j) throws IOException;
}
