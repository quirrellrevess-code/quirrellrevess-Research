package com.sun.mail.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* JADX INFO: loaded from: classes.dex */
public class LineInputStream extends FilterInputStream {
    private char[] lineBuffer;

    public LineInputStream(InputStream inputStream) {
        super(inputStream);
        this.lineBuffer = null;
    }

    public String readLine() throws IOException {
        int i;
        InputStream inputStream = ((FilterInputStream) this).in;
        char[] cArr = this.lineBuffer;
        if (cArr == null) {
            cArr = new char[128];
            this.lineBuffer = cArr;
        }
        int length = cArr.length;
        int i2 = 0;
        while (true) {
            i = inputStream.read();
            if (i == -1 || i == 10) {
                break;
            }
            if (i == 13) {
                int i3 = inputStream.read();
                if (i3 == 13) {
                    i3 = inputStream.read();
                }
                if (i3 == 10) {
                    break;
                }
                if (!(inputStream instanceof PushbackInputStream)) {
                    PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);
                    ((FilterInputStream) this).in = pushbackInputStream;
                    inputStream = pushbackInputStream;
                }
                ((PushbackInputStream) inputStream).unread(i3);
                break;
            }
            length--;
            if (length < 0) {
                int i4 = i2 + 128;
                char[] cArr2 = new char[i4];
                System.arraycopy(this.lineBuffer, 0, cArr2, 0, i2);
                this.lineBuffer = cArr2;
                length = (i4 - i2) - 1;
                cArr = cArr2;
            }
            cArr[i2] = (char) i;
            i2++;
        }
        if (i == -1 && i2 == 0) {
            return null;
        }
        return String.copyValueOf(cArr, 0, i2);
    }
}
