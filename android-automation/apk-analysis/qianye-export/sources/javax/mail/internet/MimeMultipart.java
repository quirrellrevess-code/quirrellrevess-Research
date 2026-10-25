package javax.mail.internet;

import com.mysql.jdbc.StatementImpl;
import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.LineInputStream;
import com.sun.mail.util.LineOutputStream;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.MessageAware;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.MultipartDataSource;

/* JADX INFO: loaded from: classes.dex */
public class MimeMultipart extends Multipart {
    private static boolean bmparse = true;
    private static boolean ignoreMissingBoundaryParameter = true;
    private static boolean ignoreMissingEndBoundary = true;
    private boolean complete;

    /* JADX INFO: renamed from: ds */
    public DataSource f868ds;
    public boolean parsed;
    private String preamble;

    static {
        try {
            String property = System.getProperty("mail.mime.multipart.ignoremissingendboundary");
            boolean z = false;
            ignoreMissingEndBoundary = property == null || !property.equalsIgnoreCase("false");
            String property2 = System.getProperty("mail.mime.multipart.ignoremissingboundaryparameter");
            ignoreMissingBoundaryParameter = property2 == null || !property2.equalsIgnoreCase("false");
            String property3 = System.getProperty("mail.mime.multipart.bmparse");
            if (property3 == null || !property3.equalsIgnoreCase("false")) {
                z = true;
            }
            bmparse = z;
        } catch (SecurityException unused) {
        }
    }

    public MimeMultipart() {
        this("mixed");
    }

    /* JADX WARN: Code duplicated, block: B:110:0x0169  */
    /* JADX WARN: Code duplicated, block: B:187:0x02f6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:193:0x0306 A[Catch: all -> 0x032f, IOException -> 0x0331, TryCatch #2 {IOException -> 0x0331, blocks: (B:27:0x004f, B:28:0x0056, B:48:0x0093, B:49:0x0099, B:51:0x00a5, B:53:0x00aa, B:57:0x00b9, B:58:0x00bd, B:60:0x00c3, B:63:0x00cb, B:65:0x00cf, B:70:0x00d8, B:71:0x00df, B:74:0x00ec, B:77:0x00f4, B:79:0x0101, B:80:0x0108, B:82:0x0115, B:85:0x011b, B:86:0x011f, B:138:0x01c5, B:148:0x01f7, B:139:0x01d4, B:141:0x01dc, B:143:0x01e5, B:146:0x01eb, B:147:0x01ef, B:87:0x012e, B:88:0x0135, B:97:0x014b, B:106:0x015d, B:153:0x0224, B:158:0x023b, B:159:0x0241, B:161:0x024c, B:162:0x0259, B:166:0x0265, B:168:0x026b, B:116:0x0178, B:118:0x0189, B:120:0x0191, B:122:0x0199, B:133:0x01b4, B:135:0x01be, B:151:0x0212, B:92:0x013d, B:170:0x0284, B:78:0x00fc, B:171:0x0291, B:172:0x0298, B:73:0x00e4, B:173:0x0299, B:181:0x02bc, B:177:0x02a8, B:178:0x02ad, B:180:0x02b5, B:182:0x02cd, B:183:0x02e8, B:184:0x02ef, B:31:0x0063, B:37:0x0073, B:39:0x007b, B:185:0x02f0, B:188:0x02f8, B:193:0x0306, B:194:0x0312, B:43:0x0086, B:34:0x006b), top: B:218:0x004f, outer: #5 }] */
    /* JADX WARN: Code duplicated, block: B:214:0x02f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:228:0x0318 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v35 */
    /* JADX WARN: Type inference failed for: r12v5, types: [boolean, int] */
    private synchronized void parsebm() throws MessagingException {
        String str;
        String line;
        boolean z;
        boolean z2;
        long j;
        InternetHeaders internetHeadersCreateInternetHeaders;
        ByteArrayOutputStream byteArrayOutputStream;
        int fully;
        LineInputStream lineInputStream;
        long j2;
        int i;
        long j3;
        MimeBodyPart mimeBodyPartCreateMimeBodyPart;
        byte[] bArr;
        int i2;
        byte b;
        String line2;
        String property;
        if (this.parsed) {
            return;
        }
        try {
            InputStream inputStream = this.f868ds.getInputStream();
            InputStream bufferedInputStream = ((inputStream instanceof ByteArrayInputStream) || (inputStream instanceof BufferedInputStream) || (inputStream instanceof SharedInputStream)) ? inputStream : new BufferedInputStream(inputStream);
            SharedInputStream sharedInputStream = bufferedInputStream instanceof SharedInputStream ? (SharedInputStream) bufferedInputStream : null;
            String parameter = new ContentType(this.contentType).getParameter("boundary");
            if (parameter != null) {
                str = "--" + parameter;
            } else {
                if (!ignoreMissingBoundaryParameter) {
                    throw new MessagingException("Missing boundary parameter");
                }
                str = null;
            }
            try {
                try {
                    LineInputStream lineInputStream2 = new LineInputStream(bufferedInputStream);
                    StringBuffer stringBuffer = null;
                    String str2 = null;
                    while (true) {
                        line = lineInputStream2.readLine();
                        char c = '\t';
                        char c2 = ' ';
                        z = false;
                        boolean z3 = false;
                        z2 = true;
                        z2 = true;
                        if (line == null) {
                            break;
                        }
                        int length = line.length() - 1;
                        while (length >= 0) {
                            char cCharAt = line.charAt(length);
                            if (cCharAt != c2 && cCharAt != c) {
                                break;
                            }
                            length--;
                            lineInputStream2 = lineInputStream2;
                            c = '\t';
                            c2 = ' ';
                            z3 = false;
                            z2 = true;
                        }
                        line = line.substring(z3 ? 1 : 0, length + 1);
                        if (str != null) {
                            if (line.equals(str)) {
                                z = z3;
                                break;
                            }
                            LineInputStream lineInputStream3 = lineInputStream2;
                            if (line.length() <= 0) {
                                if (str2 == null) {
                                    try {
                                        property = System.getProperty("line.separator", "\n");
                                    } catch (SecurityException unused) {
                                        property = "\n";
                                    }
                                    str2 = property;
                                }
                                if (stringBuffer == null) {
                                    stringBuffer = new StringBuffer(line.length() + 2);
                                }
                                stringBuffer.append(line);
                                stringBuffer.append(str2);
                            }
                            lineInputStream2 = lineInputStream3;
                        } else {
                            if (line.startsWith("--")) {
                                str = line;
                                z = z3;
                                break;
                            }
                            LineInputStream lineInputStream4 = lineInputStream2;
                            if (line.length() <= 0) {
                                if (str2 == null) {
                                    property = System.getProperty("line.separator", "\n");
                                    str2 = property;
                                }
                                if (stringBuffer == null) {
                                    stringBuffer = new StringBuffer(line.length() + 2);
                                }
                                stringBuffer.append(line);
                                stringBuffer.append(str2);
                            }
                            lineInputStream2 = lineInputStream4;
                        }
                    }
                    if (line == null) {
                        throw new MessagingException("Missing start boundary");
                    }
                    if (stringBuffer != null) {
                        this.preamble = stringBuffer.toString();
                    }
                    byte[] bytes = ASCIIUtility.getBytes(str);
                    int length2 = bytes.length;
                    int[] iArr = new int[256];
                    int i3 = 0;
                    boolean z4 = z;
                    while (i3 < length2) {
                        byte[] bArr2 = bytes;
                        int[] iArr2 = iArr;
                        byte b2 = bArr2[i3];
                        i3++;
                        iArr2[b2] = i3;
                        iArr = iArr2;
                        lineInputStream2 = lineInputStream2;
                        bytes = bArr2;
                        z4 = false;
                        z2 = true;
                    }
                    int[] iArr3 = new int[length2];
                    int i4 = length2;
                    boolean z5 = z4;
                    while (i4 > 0) {
                        byte[] bArr3 = bytes;
                        LineInputStream lineInputStream5 = lineInputStream2;
                        int[] iArr4 = iArr;
                        int[] iArr5 = iArr3;
                        int i5 = length2 - 1;
                        while (true) {
                            if (i5 >= i4) {
                                if (bArr3[i5] != bArr3[i5 - i4]) {
                                    break;
                                }
                                iArr5[i5 - 1] = i4;
                                i5--;
                            } else {
                                while (i5 > 0) {
                                    i5--;
                                    iArr5[i5] = i4;
                                }
                                break;
                            }
                        }
                        i4--;
                        iArr = iArr4;
                        lineInputStream2 = lineInputStream5;
                        bytes = bArr3;
                        iArr3 = iArr5;
                        z5 = false;
                        z2 = true;
                    }
                    int i6 = length2 - 1;
                    iArr3[i6] = z2 ? 1 : 0;
                    long j4 = 0;
                    long position = 0;
                    boolean z6 = false;
                    boolean z7 = z5;
                    while (!z6) {
                        if (sharedInputStream != null) {
                            long position2 = sharedInputStream.getPosition();
                            do {
                                line2 = lineInputStream2.readLine();
                                if (line2 == null) {
                                    break;
                                }
                            } while (line2.length() > 0);
                            if (line2 == null) {
                                if (!ignoreMissingEndBoundary) {
                                    throw new MessagingException("missing multipart end boundary");
                                }
                                this.complete = z7;
                                break;
                            }
                            j = position2;
                            internetHeadersCreateInternetHeaders = null;
                        } else {
                            j = j4;
                            internetHeadersCreateInternetHeaders = createInternetHeaders(bufferedInputStream);
                        }
                        if (!bufferedInputStream.markSupported()) {
                            throw new MessagingException("Stream doesn't support mark");
                        }
                        if (sharedInputStream == null) {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                        } else {
                            position = sharedInputStream.getPosition();
                            byteArrayOutputStream = null;
                        }
                        byte[] bArr4 = new byte[length2];
                        byte[] bArr5 = new byte[length2];
                        int i7 = 0;
                        boolean z8 = true;
                        ?? r12 = z7;
                        while (true) {
                            bufferedInputStream.mark(length2 + 4 + 1000);
                            fully = readFully(bufferedInputStream, bArr4, r12, length2);
                            if (fully < length2) {
                                if (!ignoreMissingEndBoundary) {
                                    throw new MessagingException("missing multipart end boundary");
                                }
                                if (sharedInputStream != null) {
                                    position = sharedInputStream.getPosition();
                                }
                                this.complete = r12;
                                lineInputStream = lineInputStream2;
                                iArr = iArr;
                                iArr3 = iArr3;
                                j2 = position;
                                z6 = true;
                                i = 0;
                                break;
                            }
                            int i8 = i6;
                            while (true) {
                                if (i8 < 0) {
                                    lineInputStream = lineInputStream2;
                                    break;
                                }
                                lineInputStream = lineInputStream2;
                                if (bArr4[i8] != bytes[i8]) {
                                    break;
                                }
                                i8--;
                                lineInputStream2 = lineInputStream;
                            }
                            if (i8 < 0) {
                                if (z8) {
                                    i2 = 0;
                                } else {
                                    byte b3 = bArr5[i7 - 1];
                                    if (b3 != 13) {
                                        b = 10;
                                        if (b3 != 10) {
                                            i2 = 0;
                                        }
                                    } else {
                                        b = 10;
                                    }
                                    i2 = (b3 == b && i7 >= 2 && bArr5[i7 + (-2)] == 13) ? 2 : 1;
                                }
                                if (z8 || i2 > 0) {
                                    if (sharedInputStream != null) {
                                        position = (sharedInputStream.getPosition() - ((long) length2)) - ((long) i2);
                                    }
                                    int i9 = bufferedInputStream.read();
                                    if (i9 == 45) {
                                        i = i2;
                                        if (bufferedInputStream.read() == 45) {
                                            this.complete = true;
                                            j2 = position;
                                            z6 = true;
                                            break;
                                        }
                                    } else {
                                        i = i2;
                                    }
                                    while (true) {
                                        if (i9 != 32 && i9 != 9) {
                                            break;
                                        }
                                        i9 = bufferedInputStream.read();
                                        bytes = bytes;
                                    }
                                    if (i9 != 10) {
                                        if (i9 == 13) {
                                            bufferedInputStream.mark(1);
                                            if (bufferedInputStream.read() != 10) {
                                                bufferedInputStream.reset();
                                            }
                                        } else {
                                            bArr = bytes;
                                        }
                                    }
                                    j2 = position;
                                    break;
                                }
                                bArr = bytes;
                                iArr = iArr;
                                iArr3 = iArr3;
                                i8 = 0;
                            } else {
                                bArr = bytes;
                                iArr = iArr;
                                iArr3 = iArr3;
                            }
                            int iMax = Math.max((i8 + 1) - iArr[(bArr4[i8] & 127) == true ? 1 : 0], iArr3[i8]);
                            if (iMax < 2) {
                                if (sharedInputStream == null && i7 > 1) {
                                    byteArrayOutputStream.write(bArr5, 0, i7 - 1);
                                }
                                bufferedInputStream.reset();
                                skipFully(bufferedInputStream, 1L);
                                if (i7 >= 1) {
                                    bArr5[0] = bArr5[i7 - 1];
                                    bArr5[1] = bArr4[0];
                                    i7 = 2;
                                } else {
                                    bArr5[0] = bArr4[0];
                                    i7 = 1;
                                }
                            } else {
                                if (i7 > 0 && sharedInputStream == null) {
                                    byteArrayOutputStream.write(bArr5, 0, i7);
                                }
                                bufferedInputStream.reset();
                                skipFully(bufferedInputStream, iMax);
                                i7 = iMax;
                                byte[] bArr6 = bArr5;
                                bArr5 = bArr4;
                                bArr4 = bArr6;
                            }
                            iArr = iArr;
                            lineInputStream2 = lineInputStream;
                            bytes = bArr;
                            iArr3 = iArr3;
                            r12 = 0;
                            z8 = false;
                        }
                        if (sharedInputStream != null) {
                            long j5 = j;
                            mimeBodyPartCreateMimeBodyPart = createMimeBodyPart(sharedInputStream.newStream(j5, j2));
                            j3 = j5;
                        } else {
                            j3 = j;
                            int i10 = i7 - i;
                            if (i10 > 0) {
                                byteArrayOutputStream.write(bArr5, 0, i10);
                            }
                            if (!this.complete && fully > 0) {
                                byteArrayOutputStream.write(bArr4, 0, fully);
                            }
                            mimeBodyPartCreateMimeBodyPart = createMimeBodyPart(internetHeadersCreateInternetHeaders, byteArrayOutputStream.toByteArray());
                        }
                        super.addBodyPart(mimeBodyPartCreateMimeBodyPart);
                        position = j2;
                        iArr = iArr;
                        j4 = j3;
                        lineInputStream2 = lineInputStream;
                        bytes = bytes;
                        iArr3 = iArr3;
                        z7 = false;
                        z2 = true;
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused2) {
                    }
                    this.parsed = z2;
                } catch (Throwable th) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused3) {
                    }
                    throw th;
                }
            } catch (IOException e) {
                throw new MessagingException("IO Error", e);
            }
        } catch (Exception e2) {
            throw new MessagingException("No inputstream from datasource", e2);
        }
    }

    private static int readFully(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        while (i2 > 0) {
            int i4 = inputStream.read(bArr, i, i2);
            if (i4 <= 0) {
                break;
            }
            i += i4;
            i3 += i4;
            i2 -= i4;
        }
        if (i3 > 0) {
            return i3;
        }
        return -1;
    }

    private void skipFully(InputStream inputStream, long j) throws IOException {
        while (j > 0) {
            long jSkip = inputStream.skip(j);
            if (jSkip <= 0) {
                throw new EOFException("can't skip");
            }
            j -= jSkip;
        }
    }

    @Override // javax.mail.Multipart
    public synchronized void addBodyPart(BodyPart bodyPart) throws MessagingException {
        parse();
        super.addBodyPart(bodyPart);
    }

    public InternetHeaders createInternetHeaders(InputStream inputStream) throws MessagingException {
        return new InternetHeaders(inputStream);
    }

    public MimeBodyPart createMimeBodyPart(InternetHeaders internetHeaders, byte[] bArr) throws MessagingException {
        return new MimeBodyPart(internetHeaders, bArr);
    }

    @Override // javax.mail.Multipart
    public synchronized BodyPart getBodyPart(int i) throws MessagingException {
        parse();
        return super.getBodyPart(i);
    }

    @Override // javax.mail.Multipart
    public synchronized int getCount() throws MessagingException {
        parse();
        return super.getCount();
    }

    public synchronized String getPreamble() throws MessagingException {
        parse();
        return this.preamble;
    }

    public synchronized boolean isComplete() throws MessagingException {
        parse();
        return this.complete;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x018a A[Catch: all -> 0x0241, IOException -> 0x0243, TryCatch #3 {IOException -> 0x0243, blocks: (B:32:0x0058, B:33:0x005f, B:53:0x009c, B:54:0x00a2, B:58:0x00b0, B:59:0x00b4, B:61:0x00ba, B:64:0x00c2, B:66:0x00c6, B:71:0x00cf, B:72:0x00d6, B:75:0x00df, B:78:0x00e7, B:82:0x00fb, B:88:0x0116, B:90:0x011e, B:92:0x0124, B:127:0x0190, B:129:0x01a1, B:128:0x0199, B:102:0x013b, B:104:0x0145, B:107:0x014c, B:108:0x0151, B:112:0x0159, B:114:0x0160, B:121:0x0180, B:123:0x0186, B:125:0x018a, B:130:0x01ae, B:131:0x01b5, B:138:0x01c2, B:141:0x01ce, B:144:0x01da, B:147:0x01e9, B:85:0x0108, B:117:0x016c, B:79:0x00ef, B:149:0x01f4, B:150:0x01fb, B:74:0x00d9, B:151:0x01fc, B:152:0x0203, B:36:0x006c, B:42:0x007c, B:44:0x0084, B:153:0x0204, B:156:0x020c, B:161:0x021a, B:162:0x0226, B:48:0x008f, B:39:0x0074), top: B:182:0x0058, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x0190 A[Catch: all -> 0x0241, IOException -> 0x0243, TryCatch #3 {IOException -> 0x0243, blocks: (B:32:0x0058, B:33:0x005f, B:53:0x009c, B:54:0x00a2, B:58:0x00b0, B:59:0x00b4, B:61:0x00ba, B:64:0x00c2, B:66:0x00c6, B:71:0x00cf, B:72:0x00d6, B:75:0x00df, B:78:0x00e7, B:82:0x00fb, B:88:0x0116, B:90:0x011e, B:92:0x0124, B:127:0x0190, B:129:0x01a1, B:128:0x0199, B:102:0x013b, B:104:0x0145, B:107:0x014c, B:108:0x0151, B:112:0x0159, B:114:0x0160, B:121:0x0180, B:123:0x0186, B:125:0x018a, B:130:0x01ae, B:131:0x01b5, B:138:0x01c2, B:141:0x01ce, B:144:0x01da, B:147:0x01e9, B:85:0x0108, B:117:0x016c, B:79:0x00ef, B:149:0x01f4, B:150:0x01fb, B:74:0x00d9, B:151:0x01fc, B:152:0x0203, B:36:0x006c, B:42:0x007c, B:44:0x0084, B:153:0x0204, B:156:0x020c, B:161:0x021a, B:162:0x0226, B:48:0x008f, B:39:0x0074), top: B:182:0x0058, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:128:0x0199 A[Catch: all -> 0x0241, IOException -> 0x0243, TryCatch #3 {IOException -> 0x0243, blocks: (B:32:0x0058, B:33:0x005f, B:53:0x009c, B:54:0x00a2, B:58:0x00b0, B:59:0x00b4, B:61:0x00ba, B:64:0x00c2, B:66:0x00c6, B:71:0x00cf, B:72:0x00d6, B:75:0x00df, B:78:0x00e7, B:82:0x00fb, B:88:0x0116, B:90:0x011e, B:92:0x0124, B:127:0x0190, B:129:0x01a1, B:128:0x0199, B:102:0x013b, B:104:0x0145, B:107:0x014c, B:108:0x0151, B:112:0x0159, B:114:0x0160, B:121:0x0180, B:123:0x0186, B:125:0x018a, B:130:0x01ae, B:131:0x01b5, B:138:0x01c2, B:141:0x01ce, B:144:0x01da, B:147:0x01e9, B:85:0x0108, B:117:0x016c, B:79:0x00ef, B:149:0x01f4, B:150:0x01fb, B:74:0x00d9, B:151:0x01fc, B:152:0x0203, B:36:0x006c, B:42:0x007c, B:44:0x0084, B:153:0x0204, B:156:0x020c, B:161:0x021a, B:162:0x0226, B:48:0x008f, B:39:0x0074), top: B:182:0x0058, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:141:0x01ce A[Catch: all -> 0x0241, IOException -> 0x0243, TryCatch #3 {IOException -> 0x0243, blocks: (B:32:0x0058, B:33:0x005f, B:53:0x009c, B:54:0x00a2, B:58:0x00b0, B:59:0x00b4, B:61:0x00ba, B:64:0x00c2, B:66:0x00c6, B:71:0x00cf, B:72:0x00d6, B:75:0x00df, B:78:0x00e7, B:82:0x00fb, B:88:0x0116, B:90:0x011e, B:92:0x0124, B:127:0x0190, B:129:0x01a1, B:128:0x0199, B:102:0x013b, B:104:0x0145, B:107:0x014c, B:108:0x0151, B:112:0x0159, B:114:0x0160, B:121:0x0180, B:123:0x0186, B:125:0x018a, B:130:0x01ae, B:131:0x01b5, B:138:0x01c2, B:141:0x01ce, B:144:0x01da, B:147:0x01e9, B:85:0x0108, B:117:0x016c, B:79:0x00ef, B:149:0x01f4, B:150:0x01fb, B:74:0x00d9, B:151:0x01fc, B:152:0x0203, B:36:0x006c, B:42:0x007c, B:44:0x0084, B:153:0x0204, B:156:0x020c, B:161:0x021a, B:162:0x0226, B:48:0x008f, B:39:0x0074), top: B:182:0x0058, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x01da A[Catch: all -> 0x0241, IOException -> 0x0243, TryCatch #3 {IOException -> 0x0243, blocks: (B:32:0x0058, B:33:0x005f, B:53:0x009c, B:54:0x00a2, B:58:0x00b0, B:59:0x00b4, B:61:0x00ba, B:64:0x00c2, B:66:0x00c6, B:71:0x00cf, B:72:0x00d6, B:75:0x00df, B:78:0x00e7, B:82:0x00fb, B:88:0x0116, B:90:0x011e, B:92:0x0124, B:127:0x0190, B:129:0x01a1, B:128:0x0199, B:102:0x013b, B:104:0x0145, B:107:0x014c, B:108:0x0151, B:112:0x0159, B:114:0x0160, B:121:0x0180, B:123:0x0186, B:125:0x018a, B:130:0x01ae, B:131:0x01b5, B:138:0x01c2, B:141:0x01ce, B:144:0x01da, B:147:0x01e9, B:85:0x0108, B:117:0x016c, B:79:0x00ef, B:149:0x01f4, B:150:0x01fb, B:74:0x00d9, B:151:0x01fc, B:152:0x0203, B:36:0x006c, B:42:0x007c, B:44:0x0084, B:153:0x0204, B:156:0x020c, B:161:0x021a, B:162:0x0226, B:48:0x008f, B:39:0x0074), top: B:182:0x0058, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:147:0x01e9 A[Catch: all -> 0x0241, IOException -> 0x0243, TryCatch #3 {IOException -> 0x0243, blocks: (B:32:0x0058, B:33:0x005f, B:53:0x009c, B:54:0x00a2, B:58:0x00b0, B:59:0x00b4, B:61:0x00ba, B:64:0x00c2, B:66:0x00c6, B:71:0x00cf, B:72:0x00d6, B:75:0x00df, B:78:0x00e7, B:82:0x00fb, B:88:0x0116, B:90:0x011e, B:92:0x0124, B:127:0x0190, B:129:0x01a1, B:128:0x0199, B:102:0x013b, B:104:0x0145, B:107:0x014c, B:108:0x0151, B:112:0x0159, B:114:0x0160, B:121:0x0180, B:123:0x0186, B:125:0x018a, B:130:0x01ae, B:131:0x01b5, B:138:0x01c2, B:141:0x01ce, B:144:0x01da, B:147:0x01e9, B:85:0x0108, B:117:0x016c, B:79:0x00ef, B:149:0x01f4, B:150:0x01fb, B:74:0x00d9, B:151:0x01fc, B:152:0x0203, B:36:0x006c, B:42:0x007c, B:44:0x0084, B:153:0x0204, B:156:0x020c, B:161:0x021a, B:162:0x0226, B:48:0x008f, B:39:0x0074), top: B:182:0x0058, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:155:0x020a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:161:0x021a A[Catch: all -> 0x0241, IOException -> 0x0243, TryCatch #3 {IOException -> 0x0243, blocks: (B:32:0x0058, B:33:0x005f, B:53:0x009c, B:54:0x00a2, B:58:0x00b0, B:59:0x00b4, B:61:0x00ba, B:64:0x00c2, B:66:0x00c6, B:71:0x00cf, B:72:0x00d6, B:75:0x00df, B:78:0x00e7, B:82:0x00fb, B:88:0x0116, B:90:0x011e, B:92:0x0124, B:127:0x0190, B:129:0x01a1, B:128:0x0199, B:102:0x013b, B:104:0x0145, B:107:0x014c, B:108:0x0151, B:112:0x0159, B:114:0x0160, B:121:0x0180, B:123:0x0186, B:125:0x018a, B:130:0x01ae, B:131:0x01b5, B:138:0x01c2, B:141:0x01ce, B:144:0x01da, B:147:0x01e9, B:85:0x0108, B:117:0x016c, B:79:0x00ef, B:149:0x01f4, B:150:0x01fb, B:74:0x00d9, B:151:0x01fc, B:152:0x0203, B:36:0x006c, B:42:0x007c, B:44:0x0084, B:153:0x0204, B:156:0x020c, B:161:0x021a, B:162:0x0226, B:48:0x008f, B:39:0x0074), top: B:182:0x0058, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:184:0x020c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:196:0x022c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:204:0x01ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:215:0x0186 A[SYNTHETIC] */
    public synchronized void parse() throws MessagingException {
        String str;
        String line;
        boolean z;
        boolean z2;
        InternetHeaders internetHeadersCreateInternetHeaders;
        ByteArrayOutputStream byteArrayOutputStream;
        int i;
        int i2;
        MimeBodyPart mimeBodyPartCreateMimeBodyPart;
        String line2;
        String property;
        if (this.parsed) {
            return;
        }
        if (bmparse) {
            parsebm();
            return;
        }
        try {
            InputStream inputStream = this.f868ds.getInputStream();
            InputStream bufferedInputStream = ((inputStream instanceof ByteArrayInputStream) || (inputStream instanceof BufferedInputStream) || (inputStream instanceof SharedInputStream)) ? inputStream : new BufferedInputStream(inputStream);
            SharedInputStream sharedInputStream = bufferedInputStream instanceof SharedInputStream ? (SharedInputStream) bufferedInputStream : null;
            String parameter = new ContentType(this.contentType).getParameter("boundary");
            if (parameter != null) {
                str = "--" + parameter;
            } else {
                if (!ignoreMissingBoundaryParameter) {
                    throw new MessagingException("Missing boundary parameter");
                }
                str = null;
            }
            try {
                try {
                    LineInputStream lineInputStream = new LineInputStream(bufferedInputStream);
                    StringBuffer stringBuffer = null;
                    String str2 = null;
                    while (true) {
                        line = lineInputStream.readLine();
                        char c = '\t';
                        char c2 = ' ';
                        z = false;
                        z = false;
                        z2 = true;
                        if (line == null) {
                            break;
                        }
                        int length = line.length() - 1;
                        while (length >= 0) {
                            char cCharAt = line.charAt(length);
                            if (cCharAt != c2 && cCharAt != c) {
                                break;
                            }
                            length--;
                            lineInputStream = lineInputStream;
                            c = '\t';
                            c2 = ' ';
                            z = false;
                            z2 = true;
                        }
                        line = line.substring(z ? 1 : 0, length + 1);
                        if (str != null) {
                            if (line.equals(str)) {
                                break;
                            }
                            LineInputStream lineInputStream2 = lineInputStream;
                            if (line.length() <= 0) {
                                if (str2 == null) {
                                    try {
                                        property = System.getProperty("line.separator", "\n");
                                    } catch (SecurityException unused) {
                                        property = "\n";
                                    }
                                    str2 = property;
                                }
                                if (stringBuffer == null) {
                                    stringBuffer = new StringBuffer(line.length() + 2);
                                }
                                stringBuffer.append(line);
                                stringBuffer.append(str2);
                            }
                            lineInputStream = lineInputStream2;
                        } else {
                            if (line.startsWith("--")) {
                                str = line;
                                break;
                            }
                            LineInputStream lineInputStream3 = lineInputStream;
                            if (line.length() <= 0) {
                                if (str2 == null) {
                                    property = System.getProperty("line.separator", "\n");
                                    str2 = property;
                                }
                                if (stringBuffer == null) {
                                    stringBuffer = new StringBuffer(line.length() + 2);
                                }
                                stringBuffer.append(line);
                                stringBuffer.append(str2);
                            }
                            lineInputStream = lineInputStream3;
                        }
                    }
                    if (line == null) {
                        throw new MessagingException("Missing start boundary");
                    }
                    if (stringBuffer != null) {
                        this.preamble = stringBuffer.toString();
                    }
                    byte[] bytes = ASCIIUtility.getBytes(str);
                    int length2 = bytes.length;
                    long position = 0;
                    long position2 = 0;
                    boolean z3 = false;
                    while (!z3) {
                        if (sharedInputStream != null) {
                            position = sharedInputStream.getPosition();
                            do {
                                line2 = lineInputStream.readLine();
                                if (line2 == null) {
                                    break;
                                }
                            } while (line2.length() > 0);
                            if (line2 == null) {
                                if (!ignoreMissingEndBoundary) {
                                    throw new MessagingException("missing multipart end boundary");
                                }
                                this.complete = z;
                                break;
                            }
                            internetHeadersCreateInternetHeaders = null;
                        } else {
                            internetHeadersCreateInternetHeaders = createInternetHeaders(bufferedInputStream);
                        }
                        if (!bufferedInputStream.markSupported()) {
                            throw new MessagingException("Stream doesn't support mark");
                        }
                        if (sharedInputStream == null) {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                        } else {
                            position2 = sharedInputStream.getPosition();
                            byteArrayOutputStream = null;
                        }
                        int i3 = -1;
                        boolean z4 = true;
                        int i4 = -1;
                        while (true) {
                            if (z4) {
                                bufferedInputStream.mark(length2 + 4 + 1000);
                                int i5 = 0;
                                while (true) {
                                    if (i5 >= length2) {
                                        lineInputStream = lineInputStream;
                                        break;
                                    }
                                    lineInputStream = lineInputStream;
                                    if (bufferedInputStream.read() != (bytes[i5] & StatementImpl.USES_VARIABLES_UNKNOWN)) {
                                        break;
                                    }
                                    i5++;
                                    lineInputStream = lineInputStream;
                                }
                                if (i5 == length2) {
                                    int i6 = bufferedInputStream.read();
                                    if (i6 == 45 && bufferedInputStream.read() == 45) {
                                        this.complete = true;
                                        z3 = true;
                                    } else {
                                        while (true) {
                                            if (i6 != 32 && i6 != 9) {
                                                break;
                                            } else {
                                                i6 = bufferedInputStream.read();
                                            }
                                        }
                                        if (i6 != 10) {
                                            if (i6 == 13) {
                                                bufferedInputStream.mark(1);
                                                if (bufferedInputStream.read() != 10) {
                                                    bufferedInputStream.reset();
                                                }
                                            }
                                        }
                                    }
                                    if (sharedInputStream != null) {
                                        mimeBodyPartCreateMimeBodyPart = createMimeBodyPart(sharedInputStream.newStream(position, position2));
                                    } else {
                                        mimeBodyPartCreateMimeBodyPart = createMimeBodyPart(internetHeadersCreateInternetHeaders, byteArrayOutputStream.toByteArray());
                                    }
                                    super.addBodyPart(mimeBodyPartCreateMimeBodyPart);
                                    lineInputStream = lineInputStream;
                                    z = false;
                                    z2 = true;
                                }
                                bufferedInputStream.reset();
                                if (byteArrayOutputStream == null || i3 == -1) {
                                    i4 = i4;
                                } else {
                                    byteArrayOutputStream.write(i3);
                                    int i7 = i4;
                                    if (i7 != -1) {
                                        byteArrayOutputStream.write(i7);
                                    }
                                    i3 = -1;
                                    i4 = -1;
                                }
                                i = bufferedInputStream.read();
                                if (i >= 0) {
                                    if (ignoreMissingEndBoundary) {
                                        throw new MessagingException("missing multipart end boundary");
                                    }
                                    this.complete = false;
                                    z3 = true;
                                    if (sharedInputStream != null) {
                                        mimeBodyPartCreateMimeBodyPart = createMimeBodyPart(sharedInputStream.newStream(position, position2));
                                    } else {
                                        mimeBodyPartCreateMimeBodyPart = createMimeBodyPart(internetHeadersCreateInternetHeaders, byteArrayOutputStream.toByteArray());
                                    }
                                    super.addBodyPart(mimeBodyPartCreateMimeBodyPart);
                                    lineInputStream = lineInputStream;
                                    z = false;
                                    z2 = true;
                                } else if (i != 13 || i == 10) {
                                    if (sharedInputStream != null) {
                                        position2 = sharedInputStream.getPosition() - 1;
                                    }
                                    if (i == 13) {
                                        bufferedInputStream.mark(1);
                                        i2 = bufferedInputStream.read();
                                        if (i2 == 10) {
                                            i4 = i2;
                                        } else {
                                            bufferedInputStream.reset();
                                        }
                                    }
                                    i3 = i;
                                    z4 = true;
                                } else {
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.write(i);
                                    }
                                    z4 = false;
                                }
                            } else {
                                lineInputStream = lineInputStream;
                            }
                            i4 = i4;
                            i = bufferedInputStream.read();
                            if (i >= 0) {
                                if (i != 13) {
                                }
                                if (sharedInputStream != null) {
                                    position2 = sharedInputStream.getPosition() - 1;
                                }
                                if (i == 13) {
                                    bufferedInputStream.mark(1);
                                    i2 = bufferedInputStream.read();
                                    if (i2 == 10) {
                                        i4 = i2;
                                    } else {
                                        bufferedInputStream.reset();
                                    }
                                }
                                i3 = i;
                                z4 = true;
                            } else {
                                if (ignoreMissingEndBoundary) {
                                    throw new MessagingException("missing multipart end boundary");
                                }
                                this.complete = false;
                                z3 = true;
                                if (sharedInputStream != null) {
                                    mimeBodyPartCreateMimeBodyPart = createMimeBodyPart(sharedInputStream.newStream(position, position2));
                                } else {
                                    mimeBodyPartCreateMimeBodyPart = createMimeBodyPart(internetHeadersCreateInternetHeaders, byteArrayOutputStream.toByteArray());
                                }
                                super.addBodyPart(mimeBodyPartCreateMimeBodyPart);
                                lineInputStream = lineInputStream;
                                z = false;
                                z2 = true;
                            }
                        }
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused2) {
                    }
                    this.parsed = z2;
                } catch (IOException e) {
                    throw new MessagingException("IO Error", e);
                }
            } catch (Throwable th) {
                try {
                    bufferedInputStream.close();
                } catch (IOException unused3) {
                }
                throw th;
            }
        } catch (Exception e2) {
            throw new MessagingException("No inputstream from datasource", e2);
        }
    }

    @Override // javax.mail.Multipart
    public boolean removeBodyPart(BodyPart bodyPart) throws MessagingException {
        parse();
        return super.removeBodyPart(bodyPart);
    }

    public synchronized void setPreamble(String str) throws MessagingException {
        this.preamble = str;
    }

    public synchronized void setSubType(String str) throws MessagingException {
        ContentType contentType = new ContentType(this.contentType);
        contentType.setSubType(str);
        this.contentType = contentType.toString();
    }

    public void updateHeaders() throws MessagingException {
        for (int i = 0; i < this.parts.size(); i++) {
            ((MimeBodyPart) this.parts.elementAt(i)).updateHeaders();
        }
    }

    @Override // javax.mail.Multipart
    public synchronized void writeTo(OutputStream outputStream) throws MessagingException, IOException {
        parse();
        String str = "--" + new ContentType(this.contentType).getParameter("boundary");
        LineOutputStream lineOutputStream = new LineOutputStream(outputStream);
        String str2 = this.preamble;
        if (str2 != null) {
            byte[] bytes = ASCIIUtility.getBytes(str2);
            lineOutputStream.write(bytes);
            if (bytes.length > 0 && bytes[bytes.length - 1] != 13 && bytes[bytes.length - 1] != 10) {
                lineOutputStream.writeln();
            }
        }
        for (int i = 0; i < this.parts.size(); i++) {
            lineOutputStream.writeln(str);
            ((MimeBodyPart) this.parts.elementAt(i)).writeTo(outputStream);
            lineOutputStream.writeln();
        }
        lineOutputStream.writeln(String.valueOf(str) + "--");
    }

    public MimeMultipart(String str) {
        this.f868ds = null;
        this.parsed = true;
        this.complete = true;
        this.preamble = null;
        String uniqueBoundaryValue = UniqueValue.getUniqueBoundaryValue();
        ContentType contentType = new ContentType("multipart", str, null);
        contentType.setParameter("boundary", uniqueBoundaryValue);
        this.contentType = contentType.toString();
    }

    public MimeBodyPart createMimeBodyPart(InputStream inputStream) throws MessagingException {
        return new MimeBodyPart(inputStream);
    }

    public synchronized BodyPart getBodyPart(String str) throws MessagingException {
        parse();
        int count = getCount();
        for (int i = 0; i < count; i++) {
            MimeBodyPart mimeBodyPart = (MimeBodyPart) getBodyPart(i);
            String contentID = mimeBodyPart.getContentID();
            if (contentID != null && contentID.equals(str)) {
                return mimeBodyPart;
            }
        }
        return null;
    }

    @Override // javax.mail.Multipart
    public void removeBodyPart(int i) throws MessagingException {
        parse();
        super.removeBodyPart(i);
    }

    @Override // javax.mail.Multipart
    public synchronized void addBodyPart(BodyPart bodyPart, int i) throws MessagingException {
        parse();
        super.addBodyPart(bodyPart, i);
    }

    public MimeMultipart(DataSource dataSource) throws MessagingException {
        this.f868ds = null;
        this.parsed = true;
        this.complete = true;
        this.preamble = null;
        if (dataSource instanceof MessageAware) {
            setParent(((MessageAware) dataSource).getMessageContext().getPart());
        }
        if (dataSource instanceof MultipartDataSource) {
            setMultipartDataSource((MultipartDataSource) dataSource);
            return;
        }
        this.parsed = false;
        this.f868ds = dataSource;
        this.contentType = dataSource.getContentType();
    }
}
