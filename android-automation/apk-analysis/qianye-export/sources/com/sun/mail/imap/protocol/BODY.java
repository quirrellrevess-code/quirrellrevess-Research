package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ByteArray;
import com.sun.mail.iap.ParsingException;
import java.io.ByteArrayInputStream;

/* JADX INFO: loaded from: classes.dex */
public class BODY implements Item {
    public static final char[] name = {'B', 'O', 'D', 'Y'};
    public ByteArray data;
    public int msgno;
    public int origin;
    public String section;

    public BODY(FetchResponse fetchResponse) throws ParsingException {
        byte b;
        this.origin = 0;
        this.msgno = fetchResponse.getNumber();
        fetchResponse.skipSpaces();
        do {
            b = fetchResponse.readByte();
            if (b == 93) {
                if (fetchResponse.readByte() == 60) {
                    this.origin = fetchResponse.readNumber();
                    fetchResponse.skip(1);
                }
                this.data = fetchResponse.readByteArray();
                return;
            }
        } while (b != 0);
        throw new ParsingException("BODY parse error: missing ``]'' at section end");
    }

    public ByteArray getByteArray() {
        return this.data;
    }

    public ByteArrayInputStream getByteArrayInputStream() {
        ByteArray byteArray = this.data;
        if (byteArray != null) {
            return byteArray.toByteArrayInputStream();
        }
        return null;
    }
}
