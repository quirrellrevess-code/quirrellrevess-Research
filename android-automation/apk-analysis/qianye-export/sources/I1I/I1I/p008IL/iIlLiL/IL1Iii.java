package I1I.I1I.p008IL.iIlLiL;

import com.mysql.jdbc.StatementImpl;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;

/* JADX INFO: compiled from: InflaterInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii extends FilterInputStream {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public byte[] f3361I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Inflater f3362ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public boolean f3363Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f1077IL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public byte[] f1078iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean f1079lLi1LL;

    public IL1Iii(InputStream inputStream, Inflater inflater, int i) {
        super(inputStream);
        this.f3363Ilil = false;
        this.f1079lLi1LL = false;
        this.f1078iILLL1 = new byte[1];
        if (inputStream == null || inflater == null) {
            throw null;
        }
        if (i <= 0) {
            throw new IllegalArgumentException(I1I.IL1Iii.IL1Iii(new byte[]{81, 69, 7, 3, 84, 68, 19, 67, 8, 31, 84, 22, 15, 13, 65, 85}, I1I.IL1Iii.IL1Iii(new byte[]{87, 83, 4, 82, 3, 85}, I1I.IL1Iii.IL1Iii(new byte[]{93, 86, 85, 82, 5, 85}, "950e76"))));
        }
        this.f3362ILil = inflater;
        this.f3361I1I = new byte[i];
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final void m1105IiL() throws IOException {
        if (this.f3363Ilil) {
            throw new IOException(I1I.IL1Iii.IL1Iii(new byte[]{96, 21, 19, 92, 81, 92, 19, 2, 13, 86, 67, 84, 87}, I1I.IL1Iii.IL1Iii(new byte[]{4, 0, 85, 0, 9, 80}, I1I.IL1Iii.IL1Iii(new byte[]{1, 84, 6, 11, 13, 3}, "65224b"))));
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f3363Ilil) {
            return;
        }
        if (this.f1079lLi1LL) {
            this.f3362ILil.end();
        }
        ((FilterInputStream) this).in.close();
        this.f3363Ilil = true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        m1105IiL();
        if (read(this.f1078iILLL1, 0, 1) == -1) {
            return -1;
        }
        return this.f1078iILLL1[0] & StatementImpl.USES_VARIABLES_UNKNOWN;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        throw new IOException(I1I.IL1Iii.IL1Iii(new byte[]{8, 3, 70, 9, 77, 69, 0, 17, 81, 22, 66, 89, 10, 22, 20, 17, 23, 71, 21, 13, 70, 22, 7, 83}, I1I.IL1Iii.IL1Iii(new byte[]{85, 4, 12, 80, 84, 14}, I1I.IL1Iii.IL1Iii(new byte[]{82, 4, 90, 6, 80, 14}, "bbb4f7"))));
    }

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public void m1106() throws IOException {
        m1105IiL();
        InputStream inputStream = ((FilterInputStream) this).in;
        byte[] bArr = this.f3361I1I;
        int i = inputStream.read(bArr, 0, bArr.length);
        this.f1077IL = i;
        if (i == -1) {
            throw new EOFException(I1I.IL1Iii.IL1Iii(new byte[]{54, 89, 1, 72, 21, 4, 0, 67, 1, 84, 69, 4, 13, 83, 68, 95, 3, 65, 57, 123, 45, 114, 69, 8, 13, 71, 17, 68, 69, 18, 23, 69, 1, 81, 8}, I1I.IL1Iii.IL1Iii(new byte[]{83, 86, 80, 4, 81, 80}, I1I.IL1Iii.IL1Iii(new byte[]{3, 81, 6, 2, 85, 5}, "3026a4"))));
        }
        this.f3362ILil.setInput(this.f3361I1I, 0, i);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        m1105IiL();
        Objects.requireNonNull(bArr);
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        while (true) {
            try {
                int iInflate = this.f3362ILil.inflate(bArr, i, i2);
                if (iInflate != 0) {
                    return iInflate;
                }
                if (!this.f3362ILil.finished() && !this.f3362ILil.needsDictionary()) {
                    if (this.f3362ILil.needsInput()) {
                        m1106();
                    }
                }
                return -1;
            } catch (DataFormatException e) {
                String message = e.getMessage();
                if (message == null) {
                    message = I1I.IL1Iii.IL1Iii(new byte[]{43, 12, 64, 81, 88, 91, 6, 66, 108, 124, 125, 112, 66, 6, 87, 68, 85, 18, 4, 13, 68, 93, 85, 70}, I1I.IL1Iii.IL1Iii(new byte[]{3, 91, 7, 82, 7, 80}, I1I.IL1Iii.IL1Iii(new byte[]{84, 88, 4, 0, 80, 87}, "5a5bc5")));
                }
                throw new ZipException(message);
            }
        }
    }
}
