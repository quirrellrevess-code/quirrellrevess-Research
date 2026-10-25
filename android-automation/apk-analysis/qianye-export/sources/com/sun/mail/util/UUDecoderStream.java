package com.sun.mail.util;

import com.mysql.jdbc.MysqlDefs;
import com.mysql.jdbc.StatementImpl;
import com.tencent.smtt.sdk.TbsListener;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class UUDecoderStream extends FilterInputStream {
    private byte[] buffer;
    private int bufsize;
    private boolean gotEnd;
    private boolean gotPrefix;
    private int index;
    private LineInputStream lin;
    private int mode;
    private String name;

    public UUDecoderStream(InputStream inputStream) {
        super(inputStream);
        this.bufsize = 0;
        this.index = 0;
        this.gotPrefix = false;
        this.gotEnd = false;
        this.lin = new LineInputStream(inputStream);
        this.buffer = new byte[45];
    }

    private boolean decode() throws IOException {
        String line;
        if (this.gotEnd) {
            return false;
        }
        this.bufsize = 0;
        do {
            line = this.lin.readLine();
            if (line == null) {
                throw new IOException("Missing End");
            }
            if (line.regionMatches(true, 0, "end", 0, 3)) {
                this.gotEnd = true;
                return false;
            }
        } while (line.length() == 0);
        char cCharAt = line.charAt(0);
        if (cCharAt < ' ') {
            throw new IOException("Buffer format error");
        }
        int i = (cCharAt - ' ') & 63;
        if (i == 0) {
            String line2 = this.lin.readLine();
            if (line2 == null || !line2.regionMatches(true, 0, "end", 0, 3)) {
                throw new IOException("Missing End");
            }
            this.gotEnd = true;
            return false;
        }
        if (line.length() < (((i * 8) + 5) / 6) + 1) {
            throw new IOException("Short buffer error");
        }
        int i2 = 1;
        while (this.bufsize < i) {
            int i3 = i2 + 1;
            byte bCharAt = (byte) ((line.charAt(i2) - ' ') & 63);
            int i4 = i3 + 1;
            byte bCharAt2 = (byte) ((line.charAt(i3) - ' ') & 63);
            byte[] bArr = this.buffer;
            int i5 = this.bufsize;
            int i6 = i5 + 1;
            this.bufsize = i6;
            bArr[i5] = (byte) (((bCharAt << 2) & MysqlDefs.FIELD_TYPE_BLOB) | ((bCharAt2 >>> 4) & 3));
            if (i6 < i) {
                i2 = i4 + 1;
                byte bCharAt3 = (byte) ((line.charAt(i4) - ' ') & 63);
                byte[] bArr2 = this.buffer;
                int i7 = this.bufsize;
                this.bufsize = i7 + 1;
                bArr2[i7] = (byte) (((bCharAt2 << 4) & TbsListener.ErrorCode.TPATCH_VERSION_FAILED) | ((bCharAt3 >>> 2) & 15));
                bCharAt2 = bCharAt3;
            } else {
                i2 = i4;
            }
            if (this.bufsize < i) {
                int i8 = i2 + 1;
                byte bCharAt4 = (byte) ((line.charAt(i2) - ' ') & 63);
                byte[] bArr3 = this.buffer;
                int i9 = this.bufsize;
                this.bufsize = i9 + 1;
                bArr3[i9] = (byte) ((bCharAt4 & 63) | ((bCharAt2 << 6) & 192));
                i2 = i8;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004b, code lost:
    
        throw new java.io.IOException("UUDecoder error: " + r0.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void readPrefix() throws java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r7.gotPrefix
            if (r0 == 0) goto L5
            return
        L5:
            com.sun.mail.util.LineInputStream r0 = r7.lin
            java.lang.String r0 = r0.readLine()
            if (r0 == 0) goto L4c
            r2 = 1
            r3 = 0
            r5 = 0
            r6 = 5
            java.lang.String r4 = "begin"
            r1 = r0
            boolean r1 = r1.regionMatches(r2, r3, r4, r5, r6)
            if (r1 == 0) goto L5
            r1 = 6
            r2 = 9
            java.lang.String r1 = r0.substring(r1, r2)     // Catch: java.lang.NumberFormatException -> L33
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L33
            r7.mode = r1     // Catch: java.lang.NumberFormatException -> L33
            r1 = 10
            java.lang.String r0 = r0.substring(r1)
            r7.name = r0
            r0 = 1
            r7.gotPrefix = r0
            return
        L33:
            r0 = move-exception
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "UUDecoder error: "
            r2.<init>(r3)
            java.lang.String r0 = r0.toString()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L4c:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "UUDecoder error: No Begin"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.UUDecoderStream.readPrefix():void");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return ((((FilterInputStream) this).in.available() * 3) / 4) + (this.bufsize - this.index);
    }

    public int getMode() throws IOException {
        readPrefix();
        return this.mode;
    }

    public String getName() throws IOException {
        readPrefix();
        return this.name;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.index >= this.bufsize) {
            readPrefix();
            if (!decode()) {
                return -1;
            }
            this.index = 0;
        }
        byte[] bArr = this.buffer;
        int i = this.index;
        this.index = i + 1;
        return bArr[i] & StatementImpl.USES_VARIABLES_UNKNOWN;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int i4 = read();
            if (i4 == -1) {
                if (i3 == 0) {
                    return -1;
                }
                return i3;
            }
            bArr[i + i3] = (byte) i4;
            i3++;
        }
        return i3;
    }
}
