package com.sun.mail.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class QDecoderStream extends QPDecoderStream {
    public QDecoderStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // com.sun.mail.util.QPDecoderStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i = ((FilterInputStream) this).in.read();
        if (i == 95) {
            return 32;
        }
        if (i != 61) {
            return i;
        }
        this.f133ba[0] = (byte) ((FilterInputStream) this).in.read();
        this.f133ba[1] = (byte) ((FilterInputStream) this).in.read();
        try {
            return ASCIIUtility.parseInt(this.f133ba, 0, 2, 16);
        } catch (NumberFormatException e) {
            throw new IOException("Error in QP stream " + e.getMessage());
        }
    }
}
