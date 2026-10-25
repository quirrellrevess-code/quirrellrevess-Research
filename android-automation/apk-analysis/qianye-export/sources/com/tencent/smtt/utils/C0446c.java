package com.tencent.smtt.utils;

import com.mysql.jdbc.Buffer;
import com.mysql.jdbc.StatementImpl;
import com.tencent.smtt.sdk.WebView;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: renamed from: com.tencent.smtt.utils.c */
/* JADX INFO: loaded from: classes.dex */
public class C0446c implements Closeable {

    /* JADX INFO: renamed from: a */
    private final RandomAccessFile f714a;

    /* JADX INFO: renamed from: b */
    private final File f715b;

    /* JADX INFO: renamed from: c */
    private final byte[] f716c;

    /* JADX INFO: renamed from: d */
    private boolean f717d;

    public C0446c(File file) throws FileNotFoundException {
        this.f716c = new byte[8];
        this.f715b = file;
        this.f714a = new RandomAccessFile(file, "r");
    }

    public C0446c(String str) throws FileNotFoundException {
        this(new File(str));
    }

    /* JADX INFO: renamed from: a */
    public final int m708a(byte[] bArr) throws IOException {
        return this.f714a.read(bArr);
    }

    /* JADX INFO: renamed from: a */
    public final int m709a(char[] cArr) throws IOException {
        byte[] bArr = new byte[cArr.length];
        int i = this.f714a.read(bArr);
        for (int i2 = 0; i2 < cArr.length; i2++) {
            cArr[i2] = (char) bArr[i2];
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    public final short m710a() throws IOException {
        short s = this.f714a.readShort();
        if (!this.f717d) {
            return s;
        }
        return (short) (((s & 65280) >>> 8) | ((s & Buffer.TYPE_ID_ERROR) << 8));
    }

    /* JADX INFO: renamed from: a */
    public void m711a(long j) throws IOException {
        this.f714a.seek(j);
    }

    /* JADX INFO: renamed from: a */
    public void m712a(boolean z) {
        this.f717d = z;
    }

    /* JADX INFO: renamed from: b */
    public final int m713b() throws IOException {
        int i = this.f714a.readInt();
        if (!this.f717d) {
            return i;
        }
        return ((i & WebView.NIGHT_MODE_COLOR) >>> 24) | ((i & 255) << 24) | ((65280 & i) << 8) | ((16711680 & i) >>> 8);
    }

    /* JADX INFO: renamed from: c */
    public final long m714c() throws IOException {
        if (!this.f717d) {
            return this.f714a.readLong();
        }
        this.f714a.readFully(this.f716c, 0, 8);
        byte[] bArr = this.f716c;
        return ((long) (bArr[0] & StatementImpl.USES_VARIABLES_UNKNOWN)) | (((long) bArr[7]) << 56) | (((long) (bArr[6] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 48) | (((long) (bArr[5] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 40) | (((long) (bArr[4] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 32) | (((long) (bArr[3] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 24) | (((long) (bArr[2] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 16) | (((long) (bArr[1] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 8);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.f714a.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
