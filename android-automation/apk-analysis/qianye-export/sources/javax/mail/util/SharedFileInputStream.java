package javax.mail.util;

import com.mysql.jdbc.StatementImpl;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import javax.mail.internet.SharedInputStream;

/* JADX INFO: loaded from: classes.dex */
public class SharedFileInputStream extends BufferedInputStream implements SharedInputStream {
    private static int defaultBufferSize = 2048;
    public long bufpos;
    public int bufsize;
    public long datalen;

    /* JADX INFO: renamed from: in */
    public RandomAccessFile f878in;
    private boolean master;

    /* JADX INFO: renamed from: sf */
    private SharedFile f879sf;
    public long start;

    public SharedFileInputStream(File file) throws IOException {
        this(file, defaultBufferSize);
    }

    private void ensureOpen() throws IOException {
        if (this.f878in == null) {
            throw new IOException("Stream closed");
        }
    }

    private void fill() throws IOException {
        if (((BufferedInputStream) this).markpos < 0) {
            ((BufferedInputStream) this).pos = 0;
            this.bufpos += (long) ((BufferedInputStream) this).count;
        } else if (((BufferedInputStream) this).pos >= ((BufferedInputStream) this).buf.length) {
            int i = ((BufferedInputStream) this).markpos;
            if (i > 0) {
                int i2 = ((BufferedInputStream) this).pos - i;
                System.arraycopy(((BufferedInputStream) this).buf, ((BufferedInputStream) this).markpos, ((BufferedInputStream) this).buf, 0, i2);
                ((BufferedInputStream) this).pos = i2;
                this.bufpos += (long) ((BufferedInputStream) this).markpos;
                ((BufferedInputStream) this).markpos = 0;
            } else {
                int length = ((BufferedInputStream) this).buf.length;
                int i3 = ((BufferedInputStream) this).marklimit;
                if (length >= i3) {
                    ((BufferedInputStream) this).markpos = -1;
                    ((BufferedInputStream) this).pos = 0;
                    this.bufpos += (long) ((BufferedInputStream) this).count;
                } else {
                    int i4 = ((BufferedInputStream) this).pos * 2;
                    if (i4 <= i3) {
                        i3 = i4;
                    }
                    byte[] bArr = new byte[i3];
                    System.arraycopy(((BufferedInputStream) this).buf, 0, bArr, 0, ((BufferedInputStream) this).pos);
                    ((BufferedInputStream) this).buf = bArr;
                }
            }
        }
        int i5 = ((BufferedInputStream) this).pos;
        ((BufferedInputStream) this).count = i5;
        this.f878in.seek(this.bufpos + ((long) i5));
        int length2 = ((BufferedInputStream) this).buf.length;
        int i6 = ((BufferedInputStream) this).pos;
        int i7 = length2 - i6;
        long j = this.bufpos;
        long j2 = this.start;
        long j3 = (j - j2) + ((long) i6) + ((long) i7);
        long j4 = this.datalen;
        if (j3 > j4) {
            i7 = (int) (j4 - ((j - j2) + ((long) i6)));
        }
        int i8 = this.f878in.read(((BufferedInputStream) this).buf, ((BufferedInputStream) this).pos, i7);
        if (i8 > 0) {
            ((BufferedInputStream) this).count = i8 + ((BufferedInputStream) this).pos;
        }
    }

    private int in_available() throws IOException {
        return (int) ((this.start + this.datalen) - (this.bufpos + ((long) ((BufferedInputStream) this).count)));
    }

    private void init(SharedFile sharedFile, int i) throws IOException {
        this.f879sf = sharedFile;
        RandomAccessFile randomAccessFileOpen = sharedFile.open();
        this.f878in = randomAccessFileOpen;
        this.start = 0L;
        this.datalen = randomAccessFileOpen.length();
        this.bufsize = i;
        ((BufferedInputStream) this).buf = new byte[i];
    }

    private int read1(byte[] bArr, int i, int i2) throws IOException {
        int i3 = ((BufferedInputStream) this).count - ((BufferedInputStream) this).pos;
        if (i3 <= 0) {
            fill();
            i3 = ((BufferedInputStream) this).count - ((BufferedInputStream) this).pos;
            if (i3 <= 0) {
                return -1;
            }
        }
        if (i3 < i2) {
            i2 = i3;
        }
        System.arraycopy(((BufferedInputStream) this).buf, ((BufferedInputStream) this).pos, bArr, i, i2);
        ((BufferedInputStream) this).pos += i2;
        return i2;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        ensureOpen();
        return (((BufferedInputStream) this).count - ((BufferedInputStream) this).pos) + in_available();
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f878in == null) {
            return;
        }
        try {
            if (this.master) {
                this.f879sf.forceClose();
            } else {
                this.f879sf.close();
            }
        } finally {
            this.f879sf = null;
            this.f878in = null;
            ((BufferedInputStream) this).buf = null;
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        close();
    }

    @Override // javax.mail.internet.SharedInputStream
    public long getPosition() {
        if (this.f878in != null) {
            return (this.bufpos + ((long) ((BufferedInputStream) this).pos)) - this.start;
        }
        throw new RuntimeException("Stream closed");
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        ((BufferedInputStream) this).marklimit = i;
        ((BufferedInputStream) this).markpos = ((BufferedInputStream) this).pos;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // javax.mail.internet.SharedInputStream
    public InputStream newStream(long j, long j2) {
        if (this.f878in == null) {
            throw new RuntimeException("Stream closed");
        }
        if (j < 0) {
            throw new IllegalArgumentException("start < 0");
        }
        if (j2 == -1) {
            j2 = this.datalen;
        }
        return new SharedFileInputStream(this.f879sf, this.start + ((long) ((int) j)), (int) (j2 - j), this.bufsize);
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        ensureOpen();
        if (((BufferedInputStream) this).pos >= ((BufferedInputStream) this).count) {
            fill();
            if (((BufferedInputStream) this).pos >= ((BufferedInputStream) this).count) {
                return -1;
            }
        }
        byte[] bArr = ((BufferedInputStream) this).buf;
        int i = ((BufferedInputStream) this).pos;
        ((BufferedInputStream) this).pos = i + 1;
        return bArr[i] & StatementImpl.USES_VARIABLES_UNKNOWN;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        ensureOpen();
        int i = ((BufferedInputStream) this).markpos;
        if (i < 0) {
            throw new IOException("Resetting to invalid mark");
        }
        ((BufferedInputStream) this).pos = i;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        ensureOpen();
        if (j <= 0) {
            return 0L;
        }
        long j2 = ((BufferedInputStream) this).count - ((BufferedInputStream) this).pos;
        if (j2 <= 0) {
            fill();
            j2 = ((BufferedInputStream) this).count - ((BufferedInputStream) this).pos;
            if (j2 <= 0) {
                return 0L;
            }
        }
        if (j2 < j) {
            j = j2;
        }
        ((BufferedInputStream) this).pos = (int) (((long) ((BufferedInputStream) this).pos) + j);
        return j;
    }

    public static class SharedFile {
        private int cnt;

        /* JADX INFO: renamed from: in */
        private RandomAccessFile f880in;

        public SharedFile(String str) throws IOException {
            this.f880in = new RandomAccessFile(str, "r");
        }

        public synchronized void close() throws IOException {
            int i = this.cnt;
            if (i > 0) {
                int i2 = i - 1;
                this.cnt = i2;
                if (i2 <= 0) {
                    this.f880in.close();
                }
            }
        }

        public void finalize() throws Throwable {
            super.finalize();
            this.f880in.close();
        }

        public synchronized void forceClose() throws IOException {
            if (this.cnt > 0) {
                this.cnt = 0;
                this.f880in.close();
            } else {
                try {
                    this.f880in.close();
                } catch (IOException unused) {
                }
            }
        }

        public RandomAccessFile open() {
            this.cnt++;
            return this.f880in;
        }

        public SharedFile(File file) throws IOException {
            this.f880in = new RandomAccessFile(file, "r");
        }
    }

    public SharedFileInputStream(String str) throws IOException {
        this(str, defaultBufferSize);
    }

    public SharedFileInputStream(File file, int i) throws IOException {
        super(null);
        this.start = 0L;
        this.master = true;
        if (i > 0) {
            init(new SharedFile(file), i);
            return;
        }
        throw new IllegalArgumentException("Buffer size <= 0");
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        ensureOpen();
        int i3 = i + i2;
        if ((i | i2 | i3 | (bArr.length - i3)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        int i4 = read1(bArr, i, i2);
        if (i4 <= 0) {
            return i4;
        }
        while (i4 < i2) {
            int i5 = read1(bArr, i + i4, i2 - i4);
            if (i5 <= 0) {
                break;
            }
            i4 += i5;
        }
        return i4;
    }

    public SharedFileInputStream(String str, int i) throws IOException {
        super(null);
        this.start = 0L;
        this.master = true;
        if (i > 0) {
            init(new SharedFile(str), i);
            return;
        }
        throw new IllegalArgumentException("Buffer size <= 0");
    }

    private SharedFileInputStream(SharedFile sharedFile, long j, long j2, int i) {
        super(null);
        this.start = 0L;
        this.master = true;
        this.master = false;
        this.f879sf = sharedFile;
        this.f878in = sharedFile.open();
        this.start = j;
        this.bufpos = j;
        this.datalen = j2;
        this.bufsize = i;
        ((BufferedInputStream) this).buf = new byte[i];
    }
}
