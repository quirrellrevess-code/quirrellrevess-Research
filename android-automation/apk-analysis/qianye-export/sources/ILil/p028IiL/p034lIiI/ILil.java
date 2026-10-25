package ILil.p028IiL.p034lIiI;

import android.util.Log;
import java.io.Writer;

/* JADX INFO: compiled from: LogWriter.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil extends Writer {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public StringBuilder f4194I1I = new StringBuilder(128);

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final String f4195ILil;

    public ILil(String str) {
        this.f4195ILil = str;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final void m2294IiL() {
        if (this.f4194I1I.length() > 0) {
            Log.d(this.f4195ILil, this.f4194I1I.toString());
            StringBuilder sb = this.f4194I1I;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m2294IiL();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        m2294IiL();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m2294IiL();
            } else {
                this.f4194I1I.append(c);
            }
        }
    }
}
