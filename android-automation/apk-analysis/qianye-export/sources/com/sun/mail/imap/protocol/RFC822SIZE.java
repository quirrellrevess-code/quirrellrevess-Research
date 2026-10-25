package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;

/* JADX INFO: loaded from: classes.dex */
public class RFC822SIZE implements Item {
    public static final char[] name = {'R', 'F', 'C', '8', '2', '2', '.', 'S', 'I', 'Z', 'E'};
    public int msgno;
    public int size;

    public RFC822SIZE(FetchResponse fetchResponse) throws ParsingException {
        this.msgno = fetchResponse.getNumber();
        fetchResponse.skipSpaces();
        this.size = fetchResponse.readNumber();
    }
}
