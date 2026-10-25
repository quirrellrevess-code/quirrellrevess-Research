package javax.mail.internet;

import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: MailDateFormat.java */
/* JADX INFO: loaded from: classes.dex */
public class MailDateParser {
    public int index = 0;
    public char[] orig;

    public MailDateParser(char[] cArr) {
        this.orig = null;
        this.orig = cArr;
    }

    public int getIndex() {
        return this.index;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0065  */
    /* JADX WARN: Code duplicated, block: B:31:0x0071  */
    /* JADX WARN: Code duplicated, block: B:47:0x009c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:51:0x00a7 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:59:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public int parseAlphaTimeZone() throws java.text.ParseException {
        int i;
        int i2;
        char c;
        char c2;
        try {
            char[] cArr = this.orig;
            int i3 = this.index;
            int i4 = i3 + 1;
            this.index = i4;
            boolean z = false;
            switch (cArr[i3]) {
                case 'C':
                case 'c':
                    i = 360;
                    z = true;
                    if (z) {
                        return i;
                    }
                    int i5 = this.index;
                    i2 = i5 + 1;
                    this.index = i2;
                    c = cArr[i5];
                    if (c != 'S' || c == 's') {
                        this.index = i2 + 1;
                        c2 = cArr[i2];
                        if (c2 != 'T' || c2 == 't') {
                            return i;
                        }
                        throw new java.text.ParseException("Bad Alpha TimeZone", this.index);
                    }
                    if (c != 'D' && c != 'd') {
                        return i;
                    }
                    this.index = i2 + 1;
                    char c3 = cArr[i2];
                    if (c3 == 'T' || c3 != 't') {
                        return i - 60;
                    }
                    throw new java.text.ParseException("Bad Alpha TimeZone", this.index);
                case 'E':
                case 'e':
                    i = 300;
                    z = true;
                    if (z) {
                        return i;
                    }
                    int i6 = this.index;
                    i2 = i6 + 1;
                    this.index = i2;
                    c = cArr[i6];
                    if (c != 'S') {
                        break;
                    }
                    this.index = i2 + 1;
                    c2 = cArr[i2];
                    if (c2 != 'T') {
                        return i;
                    }
                    return i;
                case 'G':
                case 'g':
                    int i7 = i4 + 1;
                    this.index = i7;
                    char c4 = cArr[i4];
                    if (c4 == 'M' || c4 == 'm') {
                        this.index = i7 + 1;
                        char c5 = cArr[i7];
                        if (c5 != 'T') {
                            if (c5 == 't') {
                            }
                        }
                        i = 0;
                        if (z) {
                            return i;
                        }
                        int i8 = this.index;
                        i2 = i8 + 1;
                        this.index = i2;
                        c = cArr[i8];
                        if (c != 'S') {
                            break;
                        }
                        this.index = i2 + 1;
                        c2 = cArr[i2];
                        if (c2 != 'T') {
                            return i;
                        }
                        return i;
                    }
                    throw new java.text.ParseException("Bad Alpha TimeZone", this.index);
                case 'M':
                case 'm':
                    i = Videoio.CAP_PROP_XI_TIMEOUT;
                    z = true;
                    if (z) {
                        return i;
                    }
                    int i9 = this.index;
                    i2 = i9 + 1;
                    this.index = i2;
                    c = cArr[i9];
                    if (c != 'S') {
                        break;
                    }
                    this.index = i2 + 1;
                    c2 = cArr[i2];
                    if (c2 != 'T') {
                        return i;
                    }
                    return i;
                case 'P':
                case 'p':
                    i = Videoio.CAP_PROP_XI_CC_MATRIX_01;
                    z = true;
                    if (z) {
                        return i;
                    }
                    int i10 = this.index;
                    i2 = i10 + 1;
                    this.index = i2;
                    c = cArr[i10];
                    if (c != 'S') {
                        break;
                    }
                    this.index = i2 + 1;
                    c2 = cArr[i2];
                    if (c2 != 'T') {
                        return i;
                    }
                    return i;
                case 'U':
                case 'u':
                    this.index = i4 + 1;
                    char c6 = cArr[i4];
                    if (c6 != 'T' && c6 != 't') {
                        throw new java.text.ParseException("Bad Alpha TimeZone", this.index);
                    }
                    i = 0;
                    if (z) {
                        return i;
                    }
                    int i11 = this.index;
                    i2 = i11 + 1;
                    this.index = i2;
                    c = cArr[i11];
                    if (c != 'S') {
                        break;
                    }
                    this.index = i2 + 1;
                    c2 = cArr[i2];
                    if (c2 != 'T') {
                        return i;
                    }
                    return i;
                default:
                    throw new java.text.ParseException("Bad Alpha TimeZone", this.index);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new java.text.ParseException("Bad Alpha TimeZone", this.index);
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x011b A[Catch: ArrayIndexOutOfBoundsException -> 0x0155, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x0155, blocks: (B:3:0x0002, B:22:0x0046, B:23:0x0049, B:25:0x004e, B:28:0x0058, B:34:0x0069, B:38:0x0077, B:44:0x0088, B:47:0x0092, B:59:0x00a9, B:62:0x00b3, B:67:0x00c0, B:73:0x00d4, B:85:0x00eb, B:90:0x00f7, B:93:0x0101, B:99:0x0111, B:102:0x011b, B:107:0x0128, B:114:0x0139, B:120:0x0149), top: B:129:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x0123 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:105:0x0125 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:107:0x0128 A[Catch: ArrayIndexOutOfBoundsException -> 0x0155, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x0155, blocks: (B:3:0x0002, B:22:0x0046, B:23:0x0049, B:25:0x004e, B:28:0x0058, B:34:0x0069, B:38:0x0077, B:44:0x0088, B:47:0x0092, B:59:0x00a9, B:62:0x00b3, B:67:0x00c0, B:73:0x00d4, B:85:0x00eb, B:90:0x00f7, B:93:0x0101, B:99:0x0111, B:102:0x011b, B:107:0x0128, B:114:0x0139, B:120:0x0149), top: B:129:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:120:0x0149 A[Catch: ArrayIndexOutOfBoundsException -> 0x0155, TRY_LEAVE, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x0155, blocks: (B:3:0x0002, B:22:0x0046, B:23:0x0049, B:25:0x004e, B:28:0x0058, B:34:0x0069, B:38:0x0077, B:44:0x0088, B:47:0x0092, B:59:0x00a9, B:62:0x00b3, B:67:0x00c0, B:73:0x00d4, B:85:0x00eb, B:90:0x00f7, B:93:0x0101, B:99:0x0111, B:102:0x011b, B:107:0x0128, B:114:0x0139, B:120:0x0149), top: B:129:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x0151 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:123:0x0153 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x004e A[Catch: ArrayIndexOutOfBoundsException -> 0x0155, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x0155, blocks: (B:3:0x0002, B:22:0x0046, B:23:0x0049, B:25:0x004e, B:28:0x0058, B:34:0x0069, B:38:0x0077, B:44:0x0088, B:47:0x0092, B:59:0x00a9, B:62:0x00b3, B:67:0x00c0, B:73:0x00d4, B:85:0x00eb, B:90:0x00f7, B:93:0x0101, B:99:0x0111, B:102:0x011b, B:107:0x0128, B:114:0x0139, B:120:0x0149), top: B:129:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0058 A[Catch: ArrayIndexOutOfBoundsException -> 0x0155, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x0155, blocks: (B:3:0x0002, B:22:0x0046, B:23:0x0049, B:25:0x004e, B:28:0x0058, B:34:0x0069, B:38:0x0077, B:44:0x0088, B:47:0x0092, B:59:0x00a9, B:62:0x00b3, B:67:0x00c0, B:73:0x00d4, B:85:0x00eb, B:90:0x00f7, B:93:0x0101, B:99:0x0111, B:102:0x011b, B:107:0x0128, B:114:0x0139, B:120:0x0149), top: B:129:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0062  */
    /* JADX WARN: Code duplicated, block: B:32:0x0066 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x0069 A[Catch: ArrayIndexOutOfBoundsException -> 0x0155, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x0155, blocks: (B:3:0x0002, B:22:0x0046, B:23:0x0049, B:25:0x004e, B:28:0x0058, B:34:0x0069, B:38:0x0077, B:44:0x0088, B:47:0x0092, B:59:0x00a9, B:62:0x00b3, B:67:0x00c0, B:73:0x00d4, B:85:0x00eb, B:90:0x00f7, B:93:0x0101, B:99:0x0111, B:102:0x011b, B:107:0x0128, B:114:0x0139, B:120:0x0149), top: B:129:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0077 A[Catch: ArrayIndexOutOfBoundsException -> 0x0155, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x0155, blocks: (B:3:0x0002, B:22:0x0046, B:23:0x0049, B:25:0x004e, B:28:0x0058, B:34:0x0069, B:38:0x0077, B:44:0x0088, B:47:0x0092, B:59:0x00a9, B:62:0x00b3, B:67:0x00c0, B:73:0x00d4, B:85:0x00eb, B:90:0x00f7, B:93:0x0101, B:99:0x0111, B:102:0x011b, B:107:0x0128, B:114:0x0139, B:120:0x0149), top: B:129:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0081  */
    /* JADX WARN: Code duplicated, block: B:42:0x0085 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:44:0x0088 A[Catch: ArrayIndexOutOfBoundsException -> 0x0155, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x0155, blocks: (B:3:0x0002, B:22:0x0046, B:23:0x0049, B:25:0x004e, B:28:0x0058, B:34:0x0069, B:38:0x0077, B:44:0x0088, B:47:0x0092, B:59:0x00a9, B:62:0x00b3, B:67:0x00c0, B:73:0x00d4, B:85:0x00eb, B:90:0x00f7, B:93:0x0101, B:99:0x0111, B:102:0x011b, B:107:0x0128, B:114:0x0139, B:120:0x0149), top: B:129:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0092 A[Catch: ArrayIndexOutOfBoundsException -> 0x0155, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x0155, blocks: (B:3:0x0002, B:22:0x0046, B:23:0x0049, B:25:0x004e, B:28:0x0058, B:34:0x0069, B:38:0x0077, B:44:0x0088, B:47:0x0092, B:59:0x00a9, B:62:0x00b3, B:67:0x00c0, B:73:0x00d4, B:85:0x00eb, B:90:0x00f7, B:93:0x0101, B:99:0x0111, B:102:0x011b, B:107:0x0128, B:114:0x0139, B:120:0x0149), top: B:129:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x009a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:53:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a5 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:57:0x00a7 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:59:0x00a9 A[Catch: ArrayIndexOutOfBoundsException -> 0x0155, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x0155, blocks: (B:3:0x0002, B:22:0x0046, B:23:0x0049, B:25:0x004e, B:28:0x0058, B:34:0x0069, B:38:0x0077, B:44:0x0088, B:47:0x0092, B:59:0x00a9, B:62:0x00b3, B:67:0x00c0, B:73:0x00d4, B:85:0x00eb, B:90:0x00f7, B:93:0x0101, B:99:0x0111, B:102:0x011b, B:107:0x0128, B:114:0x0139, B:120:0x0149), top: B:129:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x00b3 A[Catch: ArrayIndexOutOfBoundsException -> 0x0155, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x0155, blocks: (B:3:0x0002, B:22:0x0046, B:23:0x0049, B:25:0x004e, B:28:0x0058, B:34:0x0069, B:38:0x0077, B:44:0x0088, B:47:0x0092, B:59:0x00a9, B:62:0x00b3, B:67:0x00c0, B:73:0x00d4, B:85:0x00eb, B:90:0x00f7, B:93:0x0101, B:99:0x0111, B:102:0x011b, B:107:0x0128, B:114:0x0139, B:120:0x0149), top: B:129:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x00bb A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:65:0x00bd A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:67:0x00c0 A[Catch: ArrayIndexOutOfBoundsException -> 0x0155, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x0155, blocks: (B:3:0x0002, B:22:0x0046, B:23:0x0049, B:25:0x004e, B:28:0x0058, B:34:0x0069, B:38:0x0077, B:44:0x0088, B:47:0x0092, B:59:0x00a9, B:62:0x00b3, B:67:0x00c0, B:73:0x00d4, B:85:0x00eb, B:90:0x00f7, B:93:0x0101, B:99:0x0111, B:102:0x011b, B:107:0x0128, B:114:0x0139, B:120:0x0149), top: B:129:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ce A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d4 A[Catch: ArrayIndexOutOfBoundsException -> 0x0155, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x0155, blocks: (B:3:0x0002, B:22:0x0046, B:23:0x0049, B:25:0x004e, B:28:0x0058, B:34:0x0069, B:38:0x0077, B:44:0x0088, B:47:0x0092, B:59:0x00a9, B:62:0x00b3, B:67:0x00c0, B:73:0x00d4, B:85:0x00eb, B:90:0x00f7, B:93:0x0101, B:99:0x0111, B:102:0x011b, B:107:0x0128, B:114:0x0139, B:120:0x0149), top: B:129:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x00dc A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:79:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e7 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:83:0x00e9 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:85:0x00eb A[Catch: ArrayIndexOutOfBoundsException -> 0x0155, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x0155, blocks: (B:3:0x0002, B:22:0x0046, B:23:0x0049, B:25:0x004e, B:28:0x0058, B:34:0x0069, B:38:0x0077, B:44:0x0088, B:47:0x0092, B:59:0x00a9, B:62:0x00b3, B:67:0x00c0, B:73:0x00d4, B:85:0x00eb, B:90:0x00f7, B:93:0x0101, B:99:0x0111, B:102:0x011b, B:107:0x0128, B:114:0x0139, B:120:0x0149), top: B:129:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x00f3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:88:0x00f5 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:90:0x00f7 A[Catch: ArrayIndexOutOfBoundsException -> 0x0155, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x0155, blocks: (B:3:0x0002, B:22:0x0046, B:23:0x0049, B:25:0x004e, B:28:0x0058, B:34:0x0069, B:38:0x0077, B:44:0x0088, B:47:0x0092, B:59:0x00a9, B:62:0x00b3, B:67:0x00c0, B:73:0x00d4, B:85:0x00eb, B:90:0x00f7, B:93:0x0101, B:99:0x0111, B:102:0x011b, B:107:0x0128, B:114:0x0139, B:120:0x0149), top: B:129:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0101 A[Catch: ArrayIndexOutOfBoundsException -> 0x0155, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x0155, blocks: (B:3:0x0002, B:22:0x0046, B:23:0x0049, B:25:0x004e, B:28:0x0058, B:34:0x0069, B:38:0x0077, B:44:0x0088, B:47:0x0092, B:59:0x00a9, B:62:0x00b3, B:67:0x00c0, B:73:0x00d4, B:85:0x00eb, B:90:0x00f7, B:93:0x0101, B:99:0x0111, B:102:0x011b, B:107:0x0128, B:114:0x0139, B:120:0x0149), top: B:129:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x010b  */
    /* JADX WARN: Code duplicated, block: B:97:0x010f A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:99:0x0111 A[Catch: ArrayIndexOutOfBoundsException -> 0x0155, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x0155, blocks: (B:3:0x0002, B:22:0x0046, B:23:0x0049, B:25:0x004e, B:28:0x0058, B:34:0x0069, B:38:0x0077, B:44:0x0088, B:47:0x0092, B:59:0x00a9, B:62:0x00b3, B:67:0x00c0, B:73:0x00d4, B:85:0x00eb, B:90:0x00f7, B:93:0x0101, B:99:0x0111, B:102:0x011b, B:107:0x0128, B:114:0x0139, B:120:0x0149), top: B:129:0x0002 }] */
    public int parseMonth() throws java.text.ParseException {
        int i;
        char c;
        char c2;
        int i2;
        char c3;
        char c4;
        int i3;
        char c5;
        char c6;
        int i4;
        char c7;
        char c8;
        char c9;
        int i5;
        char c10;
        char c11;
        int i6;
        char c12;
        char c13;
        int i7;
        char c14;
        char c15;
        int i8;
        char c16;
        char c17;
        try {
            char[] cArr = this.orig;
            int i9 = this.index;
            int i10 = i9 + 1;
            this.index = i10;
            char c18 = cArr[i9];
            if (c18 == 'A') {
                i = i10 + 1;
                this.index = i;
                c = cArr[i10];
                if (c != 'P' || c == 'p') {
                    this.index = i + 1;
                    c2 = cArr[i];
                    if (c2 != 'R' || c2 == 'r') {
                        return 3;
                    }
                } else if (c == 'U' || c == 'u') {
                    this.index = i + 1;
                    char c19 = cArr[i];
                    if (c19 == 'G' || c19 == 'g') {
                        return 7;
                    }
                }
            } else if (c18 == 'D') {
                i2 = i10 + 1;
                this.index = i2;
                c3 = cArr[i10];
                if (c3 != 'E' || c3 == 'e') {
                    this.index = i2 + 1;
                    c4 = cArr[i2];
                    if (c4 != 'C' || c4 == 'c') {
                        return 11;
                    }
                }
            } else if (c18 == 'F') {
                i3 = i10 + 1;
                this.index = i3;
                c5 = cArr[i10];
                if (c5 != 'E' || c5 == 'e') {
                    this.index = i3 + 1;
                    c6 = cArr[i3];
                    if (c6 != 'B' || c6 == 'b') {
                        return 1;
                    }
                }
            } else if (c18 == 'J') {
                i4 = i10 + 1;
                this.index = i4;
                c7 = cArr[i10];
                if (c7 == 'A') {
                    this.index = i4 + 1;
                    c8 = cArr[i4];
                    if (c8 != 'N' || c8 == 'n') {
                        return 0;
                    }
                } else {
                    if (c7 == 'U') {
                        this.index = i4 + 1;
                        c9 = cArr[i4];
                        if (c9 == 'N' && c9 != 'n') {
                            if (c9 != 'L' || c9 == 'l') {
                                return 6;
                            }
                        }
                        return 5;
                    }
                    if (c7 != 'a') {
                        this.index = i4 + 1;
                        c8 = cArr[i4];
                        if (c8 != 'N') {
                            return 0;
                        }
                        return 0;
                    }
                    if (c7 == 'u') {
                        this.index = i4 + 1;
                        c9 = cArr[i4];
                        if (c9 == 'N') {
                            return 5;
                        }
                        if (c9 != 'L') {
                            return 6;
                        }
                        return 6;
                    }
                }
            } else if (c18 == 'S') {
                i5 = i10 + 1;
                this.index = i5;
                c10 = cArr[i10];
                if (c10 != 'E' || c10 == 'e') {
                    this.index = i5 + 1;
                    c11 = cArr[i5];
                    if (c11 != 'P' || c11 == 'p') {
                        return 8;
                    }
                }
            } else {
                if (c18 == 'a') {
                    i = i10 + 1;
                    this.index = i;
                    c = cArr[i10];
                    if (c != 'P') {
                        this.index = i + 1;
                        c2 = cArr[i];
                        if (c2 != 'R') {
                            return 3;
                        }
                        return 3;
                    }
                    this.index = i + 1;
                    c2 = cArr[i];
                    if (c2 != 'R') {
                        return 3;
                    }
                    return 3;
                }
                if (c18 == 'd') {
                    i2 = i10 + 1;
                    this.index = i2;
                    c3 = cArr[i10];
                    if (c3 != 'E') {
                        this.index = i2 + 1;
                        c4 = cArr[i2];
                        if (c4 != 'C') {
                            return 11;
                        }
                        return 11;
                    }
                    this.index = i2 + 1;
                    c4 = cArr[i2];
                    if (c4 != 'C') {
                        return 11;
                    }
                    return 11;
                }
                if (c18 == 'f') {
                    i3 = i10 + 1;
                    this.index = i3;
                    c5 = cArr[i10];
                    if (c5 != 'E') {
                        this.index = i3 + 1;
                        c6 = cArr[i3];
                        if (c6 != 'B') {
                            return 1;
                        }
                        return 1;
                    }
                    this.index = i3 + 1;
                    c6 = cArr[i3];
                    if (c6 != 'B') {
                        return 1;
                    }
                    return 1;
                }
                if (c18 == 'j') {
                    i4 = i10 + 1;
                    this.index = i4;
                    c7 = cArr[i10];
                    if (c7 == 'A') {
                        this.index = i4 + 1;
                        c8 = cArr[i4];
                        if (c8 != 'N') {
                            return 0;
                        }
                        return 0;
                    }
                    if (c7 == 'U') {
                        this.index = i4 + 1;
                        c9 = cArr[i4];
                        if (c9 == 'N') {
                            return 5;
                        }
                        if (c9 != 'L') {
                            return 6;
                        }
                        return 6;
                    }
                    if (c7 != 'a') {
                        this.index = i4 + 1;
                        c8 = cArr[i4];
                        if (c8 != 'N') {
                            return 0;
                        }
                        return 0;
                    }
                    if (c7 == 'u') {
                        this.index = i4 + 1;
                        c9 = cArr[i4];
                        if (c9 == 'N') {
                            return 5;
                        }
                        if (c9 != 'L') {
                            return 6;
                        }
                        return 6;
                    }
                } else {
                    if (c18 == 's') {
                        i5 = i10 + 1;
                        this.index = i5;
                        c10 = cArr[i10];
                        if (c10 != 'E') {
                            this.index = i5 + 1;
                            c11 = cArr[i5];
                            if (c11 != 'P') {
                                return 8;
                            }
                            return 8;
                        }
                        this.index = i5 + 1;
                        c11 = cArr[i5];
                        if (c11 != 'P') {
                            return 8;
                        }
                        return 8;
                    }
                    switch (c18) {
                        case 'M':
                            i6 = i10 + 1;
                            this.index = i6;
                            c12 = cArr[i10];
                            if (c12 != 'A' || c12 == 'a') {
                                this.index = i6 + 1;
                                c13 = cArr[i6];
                                if (c13 == 'R' && c13 != 'r') {
                                    if (c13 != 'Y' || c13 == 'y') {
                                        return 4;
                                    }
                                }
                                return 2;
                            }
                            break;
                        case 'N':
                            i7 = i10 + 1;
                            this.index = i7;
                            c14 = cArr[i10];
                            if (c14 != 'O' || c14 == 'o') {
                                this.index = i7 + 1;
                                c15 = cArr[i7];
                                if (c15 != 'V' || c15 == 'v') {
                                    return 10;
                                }
                            }
                            break;
                        case 'O':
                            i8 = i10 + 1;
                            this.index = i8;
                            c16 = cArr[i10];
                            if (c16 != 'C' || c16 == 'c') {
                                this.index = i8 + 1;
                                c17 = cArr[i8];
                                if (c17 != 'T' || c17 == 't') {
                                    return 9;
                                }
                            }
                            break;
                        default:
                            switch (c18) {
                                case 'm':
                                    i6 = i10 + 1;
                                    this.index = i6;
                                    c12 = cArr[i10];
                                    if (c12 != 'A') {
                                        this.index = i6 + 1;
                                        c13 = cArr[i6];
                                        if (c13 == 'R') {
                                            return 2;
                                        }
                                        if (c13 != 'Y') {
                                            return 4;
                                        }
                                        return 4;
                                    }
                                    this.index = i6 + 1;
                                    c13 = cArr[i6];
                                    if (c13 == 'R') {
                                        return 2;
                                    }
                                    if (c13 != 'Y') {
                                        return 4;
                                    }
                                    return 4;
                                case 'n':
                                    i7 = i10 + 1;
                                    this.index = i7;
                                    c14 = cArr[i10];
                                    if (c14 != 'O') {
                                        this.index = i7 + 1;
                                        c15 = cArr[i7];
                                        if (c15 != 'V') {
                                            return 10;
                                        }
                                        return 10;
                                    }
                                    this.index = i7 + 1;
                                    c15 = cArr[i7];
                                    if (c15 != 'V') {
                                        return 10;
                                    }
                                    return 10;
                                case 'o':
                                    i8 = i10 + 1;
                                    this.index = i8;
                                    c16 = cArr[i10];
                                    if (c16 != 'C') {
                                        this.index = i8 + 1;
                                        c17 = cArr[i8];
                                        if (c17 != 'T') {
                                            return 9;
                                        }
                                        return 9;
                                    }
                                    this.index = i8 + 1;
                                    c17 = cArr[i8];
                                    if (c17 != 'T') {
                                        return 9;
                                    }
                                    return 9;
                            }
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
        }
        throw new java.text.ParseException("Bad Month", this.index);
    }

    public int parseNumber() throws java.text.ParseException {
        int length = this.orig.length;
        boolean z = false;
        int i = 0;
        while (true) {
            int i2 = this.index;
            if (i2 >= length) {
                if (z) {
                    return i;
                }
                throw new java.text.ParseException("No Number found", this.index);
            }
            switch (this.orig[i2]) {
                case '0':
                    i *= 10;
                    break;
                case '1':
                    i = (i * 10) + 1;
                    break;
                case '2':
                    i = (i * 10) + 2;
                    break;
                case '3':
                    i = (i * 10) + 3;
                    break;
                case '4':
                    i = (i * 10) + 4;
                    break;
                case '5':
                    i = (i * 10) + 5;
                    break;
                case '6':
                    i = (i * 10) + 6;
                    break;
                case '7':
                    i = (i * 10) + 7;
                    break;
                case '8':
                    i = (i * 10) + 8;
                    break;
                case '9':
                    i = (i * 10) + 9;
                    break;
                default:
                    if (z) {
                        return i;
                    }
                    throw new java.text.ParseException("No Number found", this.index);
            }
            this.index = i2 + 1;
            z = true;
        }
    }

    public int parseNumericTimeZone() throws java.text.ParseException {
        boolean z;
        char[] cArr = this.orig;
        int i = this.index;
        this.index = i + 1;
        char c = cArr[i];
        if (c == '+') {
            z = true;
        } else {
            if (c != '-') {
                throw new java.text.ParseException("Bad Numeric TimeZone", this.index);
            }
            z = false;
        }
        int number = parseNumber();
        int i2 = ((number / 100) * 60) + (number % 100);
        return z ? -i2 : i2;
    }

    public int parseTimeZone() throws java.text.ParseException {
        int i = this.index;
        char[] cArr = this.orig;
        if (i >= cArr.length) {
            throw new java.text.ParseException("No more characters", this.index);
        }
        char c = cArr[i];
        return (c == '+' || c == '-') ? parseNumericTimeZone() : parseAlphaTimeZone();
    }

    public int peekChar() throws java.text.ParseException {
        int i = this.index;
        char[] cArr = this.orig;
        if (i < cArr.length) {
            return cArr[i];
        }
        throw new java.text.ParseException("No more characters", this.index);
    }

    public void skipChar(char c) throws java.text.ParseException {
        int i = this.index;
        char[] cArr = this.orig;
        if (i >= cArr.length) {
            throw new java.text.ParseException("No more characters", this.index);
        }
        if (cArr[i] != c) {
            throw new java.text.ParseException("Wrong char", this.index);
        }
        this.index = i + 1;
    }

    public boolean skipIfChar(char c) throws java.text.ParseException {
        int i = this.index;
        char[] cArr = this.orig;
        if (i >= cArr.length) {
            throw new java.text.ParseException("No more characters", this.index);
        }
        if (cArr[i] != c) {
            return false;
        }
        this.index = i + 1;
        return true;
    }

    public void skipUntilNumber() throws java.text.ParseException {
        while (true) {
            try {
                char[] cArr = this.orig;
                int i = this.index;
                switch (cArr[i]) {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        return;
                    default:
                        this.index = i + 1;
                        break;
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new java.text.ParseException("No Number Found", this.index);
            }
            throw new java.text.ParseException("No Number Found", this.index);
        }
    }

    public void skipWhiteSpace() {
        int length = this.orig.length;
        while (true) {
            int i = this.index;
            if (i >= length) {
                return;
            }
            char c = this.orig[i];
            if (c != '\t' && c != '\n' && c != '\r' && c != ' ') {
                return;
            } else {
                this.index = i + 1;
            }
        }
    }
}
