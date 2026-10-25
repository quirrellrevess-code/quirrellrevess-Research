package com.sun.mail.iap;

import com.google.android.flexbox.BuildConfig;
import com.sun.mail.util.ASCIIUtility;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public class Response {
    public static final int BAD = 12;
    public static final int BYE = 16;
    public static final int CONTINUATION = 1;

    /* JADX INFO: renamed from: NO */
    public static final int f119NO = 8;

    /* JADX INFO: renamed from: OK */
    public static final int f120OK = 4;
    public static final int SYNTHETIC = 32;
    public static final int TAGGED = 2;
    public static final int TAG_MASK = 3;
    public static final int TYPE_MASK = 28;
    public static final int UNTAGGED = 3;
    private static final int increment = 100;
    public byte[] buffer;
    public int index;
    public int pindex;
    public int size;
    public String tag;
    public int type;

    public Response(String str) {
        this.buffer = null;
        this.type = 0;
        this.tag = null;
        byte[] bytes = ASCIIUtility.getBytes(str);
        this.buffer = bytes;
        this.size = bytes.length;
        parse();
    }

    public static Response byeResponse(Exception exc) {
        Response response = new Response(("* BYE JavaMail Exception: " + exc.toString()).replace('\r', ' ').replace('\n', ' '));
        response.type = response.type | 32;
        return response;
    }

    private void parse() {
        this.index = 0;
        byte[] bArr = this.buffer;
        if (bArr[0] == 43) {
            this.type |= 1;
            this.index = 0 + 1;
            return;
        }
        if (bArr[0] == 42) {
            this.type |= 3;
            this.index = 0 + 1;
        } else {
            this.type |= 2;
            this.tag = readAtom();
        }
        int i = this.index;
        String atom = readAtom();
        if (atom == null) {
            atom = BuildConfig.FLAVOR;
        }
        if (atom.equalsIgnoreCase("OK")) {
            this.type |= 4;
        } else if (atom.equalsIgnoreCase("NO")) {
            this.type |= 8;
        } else if (atom.equalsIgnoreCase("BAD")) {
            this.type |= 12;
        } else if (atom.equalsIgnoreCase("BYE")) {
            this.type |= 16;
        } else {
            this.index = i;
        }
        this.pindex = this.index;
    }

    private Object parseString(boolean z, boolean z2) {
        byte[] bArr;
        int i;
        byte[] bArr2;
        int i2;
        skipSpaces();
        byte[] bArr3 = this.buffer;
        int i3 = this.index;
        byte b = bArr3[i3];
        if (b == 34) {
            int i4 = i3 + 1;
            this.index = i4;
            int i5 = i4;
            while (true) {
                bArr2 = this.buffer;
                i2 = this.index;
                byte b2 = bArr2[i2];
                if (b2 == 34) {
                    break;
                }
                if (b2 == 92) {
                    this.index = i2 + 1;
                }
                int i6 = this.index;
                if (i6 != i5) {
                    bArr2[i5] = bArr2[i6];
                }
                i5++;
                this.index = i6 + 1;
            }
            this.index = i2 + 1;
            return z2 ? ASCIIUtility.toString(bArr2, i4, i5) : new ByteArray(bArr2, i4, i5 - i4);
        }
        if (b != 123) {
            if (z) {
                return z2 ? readAtom() : new ByteArray(this.buffer, i3, this.index);
            }
            if (b != 78 && b != 110) {
                return null;
            }
            this.index = i3 + 3;
            return null;
        }
        int i7 = i3 + 1;
        this.index = i7;
        while (true) {
            bArr = this.buffer;
            i = this.index;
            if (bArr[i] == 125) {
                try {
                    break;
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
            this.index = i + 1;
        }
        int i8 = ASCIIUtility.parseInt(bArr, i7, i);
        int i9 = this.index + 3;
        int i10 = i9 + i8;
        this.index = i10;
        return z2 ? ASCIIUtility.toString(this.buffer, i9, i10) : new ByteArray(this.buffer, i9, i8);
    }

    public String getRest() {
        skipSpaces();
        return ASCIIUtility.toString(this.buffer, this.index, this.size);
    }

    public String getTag() {
        return this.tag;
    }

    public int getType() {
        return this.type;
    }

    public boolean isBAD() {
        return (this.type & 28) == 12;
    }

    public boolean isBYE() {
        return (this.type & 28) == 16;
    }

    public boolean isContinuation() {
        return (this.type & 3) == 1;
    }

    public boolean isNO() {
        return (this.type & 28) == 8;
    }

    public boolean isOK() {
        return (this.type & 28) == 4;
    }

    public boolean isSynthetic() {
        return (this.type & 32) == 32;
    }

    public boolean isTagged() {
        return (this.type & 3) == 2;
    }

    public boolean isUnTagged() {
        return (this.type & 3) == 3;
    }

    public byte peekByte() {
        int i = this.index;
        if (i < this.size) {
            return this.buffer[i];
        }
        return (byte) 0;
    }

    public String readAtom() {
        return readAtom((char) 0);
    }

    public String readAtomString() {
        return (String) parseString(true, true);
    }

    public byte readByte() {
        int i = this.index;
        if (i >= this.size) {
            return (byte) 0;
        }
        byte[] bArr = this.buffer;
        this.index = i + 1;
        return bArr[i];
    }

    public ByteArray readByteArray() {
        if (!isContinuation()) {
            return (ByteArray) parseString(false, false);
        }
        skipSpaces();
        byte[] bArr = this.buffer;
        int i = this.index;
        return new ByteArray(bArr, i, this.size - i);
    }

    public ByteArrayInputStream readBytes() {
        ByteArray byteArray = readByteArray();
        if (byteArray != null) {
            return byteArray.toByteArrayInputStream();
        }
        return null;
    }

    public long readLong() {
        skipSpaces();
        int i = this.index;
        while (true) {
            int i2 = this.index;
            if (i2 >= this.size || !Character.isDigit((char) this.buffer[i2])) {
                break;
            }
            this.index++;
        }
        int i3 = this.index;
        if (i3 <= i) {
            return -1L;
        }
        try {
            return ASCIIUtility.parseLong(this.buffer, i, i3);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public int readNumber() {
        skipSpaces();
        int i = this.index;
        while (true) {
            int i2 = this.index;
            if (i2 >= this.size || !Character.isDigit((char) this.buffer[i2])) {
                break;
            }
            this.index++;
        }
        int i3 = this.index;
        if (i3 <= i) {
            return -1;
        }
        try {
            return ASCIIUtility.parseInt(this.buffer, i, i3);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public String readString(char c) {
        int i;
        skipSpaces();
        int i2 = this.index;
        if (i2 >= this.size) {
            return null;
        }
        while (true) {
            i = this.index;
            if (i >= this.size || this.buffer[i] == c) {
                break;
            }
            this.index = i + 1;
        }
        return ASCIIUtility.toString(this.buffer, i2, i);
    }

    public String[] readStringList() {
        byte[] bArr;
        int i;
        skipSpaces();
        byte[] bArr2 = this.buffer;
        int i2 = this.index;
        if (bArr2[i2] != 40) {
            return null;
        }
        this.index = i2 + 1;
        Vector vector = new Vector();
        do {
            vector.addElement(readString());
            bArr = this.buffer;
            i = this.index;
            this.index = i + 1;
        } while (bArr[i] != 41);
        int size = vector.size();
        if (size <= 0) {
            return null;
        }
        String[] strArr = new String[size];
        vector.copyInto(strArr);
        return strArr;
    }

    public void reset() {
        this.index = this.pindex;
    }

    public void skip(int i) {
        this.index += i;
    }

    public void skipSpaces() {
        while (true) {
            int i = this.index;
            if (i >= this.size || this.buffer[i] != 32) {
                return;
            } else {
                this.index = i + 1;
            }
        }
    }

    public void skipToken() {
        while (true) {
            int i = this.index;
            if (i >= this.size || this.buffer[i] == 32) {
                return;
            } else {
                this.index = i + 1;
            }
        }
    }

    public String toString() {
        return ASCIIUtility.toString(this.buffer, 0, this.size);
    }

    public String readAtom(char c) {
        int i;
        byte b;
        skipSpaces();
        int i2 = this.index;
        if (i2 >= this.size) {
            return null;
        }
        while (true) {
            i = this.index;
            if (i >= this.size || (b = this.buffer[i]) <= 32 || b == 40 || b == 41 || b == 37 || b == 42 || b == 34 || b == 92 || b == 127 || (c != 0 && b == c)) {
                break;
            }
            this.index = i + 1;
        }
        return ASCIIUtility.toString(this.buffer, i2, i);
    }

    public String readString() {
        return (String) parseString(false, true);
    }

    public Response(Protocol protocol) throws ProtocolException, IOException {
        this.buffer = null;
        this.type = 0;
        this.tag = null;
        ByteArray response = protocol.getInputStream().readResponse(protocol.getResponseBuffer());
        this.buffer = response.getBytes();
        this.size = response.getCount() - 2;
        parse();
    }

    public Response(Response response) {
        this.buffer = null;
        this.type = 0;
        this.tag = null;
        this.index = response.index;
        this.size = response.size;
        this.buffer = response.buffer;
        this.type = response.type;
        this.tag = response.tag;
    }
}
