package com.mysql.jdbc.util;

import com.mysql.jdbc.StatementImpl;
import com.mysql.jdbc.log.Log;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ReadAheadInputStream extends InputStream {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private byte[] buf;
    public int currentPosition;
    public boolean doDebug;
    public int endOfCurrentData;
    public Log log;
    private InputStream underlyingStream;

    public ReadAheadInputStream(InputStream inputStream, boolean z, Log log) {
        this(inputStream, 4096, z, log);
    }

    private void checkClosed() throws IOException {
        if (this.buf == null) {
            throw new IOException("Stream closed");
        }
    }

    private void fill(int i) throws IOException {
        checkClosed();
        this.currentPosition = 0;
        this.endOfCurrentData = 0;
        int iMin = Math.min(this.buf.length - 0, i);
        int iAvailable = this.underlyingStream.available();
        if (iAvailable > iMin) {
            iMin = Math.min(this.buf.length - this.currentPosition, iAvailable);
        }
        if (this.doDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append("  ReadAheadInputStream.fill(");
            sb.append(i);
            sb.append("), buffer_size=");
            sb.append(this.buf.length);
            sb.append(", current_position=");
            sb.append(this.currentPosition);
            sb.append(", need to read ");
            sb.append(Math.min(this.buf.length - this.currentPosition, i));
            sb.append(" bytes to fill request,");
            if (iAvailable > 0) {
                sb.append(" underlying InputStream reports ");
                sb.append(iAvailable);
                sb.append(" total bytes available,");
            }
            sb.append(" attempting to read ");
            sb.append(iMin);
            sb.append(" bytes.");
            Log log = this.log;
            if (log != null) {
                log.logTrace(sb.toString());
            } else {
                System.err.println(sb.toString());
            }
        }
        int i2 = this.underlyingStream.read(this.buf, this.currentPosition, iMin);
        if (i2 > 0) {
            this.endOfCurrentData = i2 + this.currentPosition;
        }
    }

    private int readFromUnderlyingStreamIfNecessary(byte[] bArr, int i, int i2) throws IOException {
        checkClosed();
        int i3 = this.endOfCurrentData - this.currentPosition;
        if (this.doDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append("ReadAheadInputStream.readIfNecessary(");
            sb.append(Arrays.toString(bArr));
            sb.append(",");
            sb.append(i);
            sb.append(",");
            sb.append(i2);
            sb.append(")");
            if (i3 <= 0) {
                sb.append(" not all data available in buffer, must read from stream");
                if (i2 >= this.buf.length) {
                    sb.append(", amount requested > buffer, returning direct read() from stream");
                }
            }
            Log log = this.log;
            if (log != null) {
                log.logTrace(sb.toString());
            } else {
                System.err.println(sb.toString());
            }
        }
        if (i3 <= 0) {
            if (i2 >= this.buf.length) {
                return this.underlyingStream.read(bArr, i, i2);
            }
            fill(i2);
            i3 = this.endOfCurrentData - this.currentPosition;
            if (i3 <= 0) {
                return -1;
            }
        }
        if (i3 < i2) {
            i2 = i3;
        }
        System.arraycopy(this.buf, this.currentPosition, bArr, i, i2);
        this.currentPosition += i2;
        return i2;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        checkClosed();
        return this.underlyingStream.available() + (this.endOfCurrentData - this.currentPosition);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.underlyingStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.underlyingStream = null;
                this.buf = null;
                this.log = null;
            }
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        checkClosed();
        int i3 = i + i2;
        if ((i | i2 | i3 | (bArr.length - i3)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i4 = 0;
        if (i2 == 0) {
            return 0;
        }
        do {
            int fromUnderlyingStreamIfNecessary = readFromUnderlyingStreamIfNecessary(bArr, i + i4, i2 - i4);
            if (fromUnderlyingStreamIfNecessary <= 0) {
                if (i4 != 0) {
                    break;
                }
                i4 = fromUnderlyingStreamIfNecessary;
                break;
            }
            i4 += fromUnderlyingStreamIfNecessary;
            if (i4 >= i2) {
                break;
            }
        } while (this.underlyingStream.available() > 0);
        return i4;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        checkClosed();
        if (j <= 0) {
            return 0L;
        }
        long j2 = this.endOfCurrentData - this.currentPosition;
        if (j2 <= 0) {
            fill((int) j);
            j2 = this.endOfCurrentData - this.currentPosition;
            if (j2 <= 0) {
                return 0L;
            }
        }
        if (j2 < j) {
            j = j2;
        }
        this.currentPosition = (int) (((long) this.currentPosition) + j);
        return j;
    }

    public ReadAheadInputStream(InputStream inputStream, int i, boolean z, Log log) {
        this.doDebug = false;
        this.underlyingStream = inputStream;
        this.buf = new byte[i];
        this.doDebug = z;
        this.log = log;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        checkClosed();
        if (this.currentPosition >= this.endOfCurrentData) {
            fill(1);
            if (this.currentPosition >= this.endOfCurrentData) {
                return -1;
            }
        }
        byte[] bArr = this.buf;
        int i = this.currentPosition;
        this.currentPosition = i + 1;
        return bArr[i] & StatementImpl.USES_VARIABLES_UNKNOWN;
    }
}
