package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.Protocol;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import java.io.IOException;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public class FetchResponse extends IMAPResponse {
    private static final char[] HEADER = {'.', 'H', 'E', 'A', 'D', 'E', 'R'};
    private static final char[] TEXT = {'.', 'T', 'E', 'X', 'T'};
    private Item[] items;

    public FetchResponse(Protocol protocol) throws ProtocolException, IOException {
        super(protocol);
        parse();
    }

    private boolean match(char[] cArr) {
        int length = cArr.length;
        int i = this.index;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i + 1;
            int i4 = i2 + 1;
            if (Character.toUpperCase((char) this.buffer[i]) != cArr[i2]) {
                return false;
            }
            i2 = i4;
            i = i3;
        }
        return true;
    }

    private void parse() throws ParsingException {
        byte[] bArr;
        int i;
        skipSpaces();
        if (this.buffer[this.index] != 40) {
            throw new ParsingException("error in FETCH parsing, missing '(' at index " + this.index);
        }
        Vector vector = new Vector();
        Object bodystructure = null;
        do {
            int i2 = this.index + 1;
            this.index = i2;
            if (i2 >= this.size) {
                throw new ParsingException("error in FETCH parsing, ran off end of buffer, size " + this.size);
            }
            byte b = this.buffer[i2];
            if (b == 66) {
                char[] cArr = BODY.name;
                if (match(cArr)) {
                    byte[] bArr2 = this.buffer;
                    int i3 = this.index;
                    if (bArr2[i3 + 4] == 91) {
                        this.index = i3 + cArr.length;
                        bodystructure = new BODY(this);
                    } else {
                        char[] cArr2 = BODYSTRUCTURE.name;
                        if (match(cArr2)) {
                            this.index += cArr2.length;
                        } else {
                            this.index += cArr.length;
                        }
                        bodystructure = new BODYSTRUCTURE(this);
                    }
                }
            } else if (b == 73) {
                char[] cArr3 = INTERNALDATE.name;
                if (match(cArr3)) {
                    this.index += cArr3.length;
                    bodystructure = new INTERNALDATE(this);
                }
            } else if (b == 82) {
                char[] cArr4 = RFC822SIZE.name;
                if (match(cArr4)) {
                    this.index += cArr4.length;
                    bodystructure = new RFC822SIZE(this);
                } else {
                    char[] cArr5 = RFC822DATA.name;
                    if (match(cArr5)) {
                        this.index += cArr5.length;
                        char[] cArr6 = HEADER;
                        if (match(cArr6)) {
                            this.index += cArr6.length;
                        } else {
                            char[] cArr7 = TEXT;
                            if (match(cArr7)) {
                                this.index += cArr7.length;
                            }
                        }
                        bodystructure = new RFC822DATA(this);
                    }
                }
            } else if (b == 85) {
                char[] cArr8 = UID.name;
                if (match(cArr8)) {
                    this.index += cArr8.length;
                    bodystructure = new UID(this);
                }
            } else if (b == 69) {
                char[] cArr9 = ENVELOPE.name;
                if (match(cArr9)) {
                    this.index += cArr9.length;
                    bodystructure = new ENVELOPE(this);
                }
            } else if (b == 70) {
                char[] cArr10 = FLAGS.name;
                if (match(cArr10)) {
                    this.index += cArr10.length;
                    bodystructure = new FLAGS(this);
                }
            }
            if (bodystructure != null) {
                vector.addElement(bodystructure);
            }
            bArr = this.buffer;
            i = this.index;
        } while (bArr[i] != 41);
        this.index = i + 1;
        Item[] itemArr = new Item[vector.size()];
        this.items = itemArr;
        vector.copyInto(itemArr);
    }

    public Item getItem(int i) {
        return this.items[i];
    }

    public int getItemCount() {
        return this.items.length;
    }

    public Item getItem(Class cls) {
        int i = 0;
        while (true) {
            Item[] itemArr = this.items;
            if (i >= itemArr.length) {
                return null;
            }
            if (cls.isInstance(itemArr[i])) {
                return this.items[i];
            }
            i++;
        }
    }

    public FetchResponse(IMAPResponse iMAPResponse) throws ProtocolException, IOException {
        super(iMAPResponse);
        parse();
    }

    public static Item getItem(Response[] responseArr, int i, Class cls) {
        if (responseArr == null) {
            return null;
        }
        for (int i2 = 0; i2 < responseArr.length; i2++) {
            if (responseArr[i2] != null && (responseArr[i2] instanceof FetchResponse) && ((FetchResponse) responseArr[i2]).getNumber() == i) {
                FetchResponse fetchResponse = (FetchResponse) responseArr[i2];
                int i3 = 0;
                while (true) {
                    Item[] itemArr = fetchResponse.items;
                    if (i3 >= itemArr.length) {
                        break;
                    }
                    if (cls.isInstance(itemArr[i3])) {
                        return fetchResponse.items[i3];
                    }
                    i3++;
                }
            }
        }
        return null;
    }
}
