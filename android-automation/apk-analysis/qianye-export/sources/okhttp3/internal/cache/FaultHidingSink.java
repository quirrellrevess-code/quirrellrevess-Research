package okhttp3.internal.cache;

import java.io.IOException;
import p066Ilil.I1I;
import p066Ilil.IiL;
import p066Ilil.iIlLiL;

/* JADX INFO: loaded from: classes.dex */
public class FaultHidingSink extends IiL {
    private boolean hasErrors;

    public FaultHidingSink(iIlLiL iillil) {
        super(iillil);
    }

    @Override // p066Ilil.IiL, p066Ilil.iIlLiL, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.hasErrors) {
            return;
        }
        try {
            super.close();
        } catch (IOException e) {
            this.hasErrors = true;
            onException(e);
        }
    }

    @Override // p066Ilil.IiL, p066Ilil.iIlLiL, java.io.Flushable
    public void flush() throws IOException {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e) {
            this.hasErrors = true;
            onException(e);
        }
    }

    public void onException(IOException iOException) {
    }

    @Override // p066Ilil.IiL, p066Ilil.iIlLiL
    public void write(I1I i1i, long j) throws IOException {
        if (this.hasErrors) {
            i1i.I11L(j);
            return;
        }
        try {
            super.write(i1i, j);
        } catch (IOException e) {
            this.hasErrors = true;
            onException(e);
        }
    }
}
