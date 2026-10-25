package I1I.I1I.p008IL.iIlLiL;

import I1I.IL1Iii;
import com.main.utils.zip.ZipEntry;
import com.mysql.jdbc.StatementImpl;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import java.util.zip.ZipException;

/* JADX INFO: compiled from: ZipInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class I1I extends IL1Iii {
    public long ILL;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public boolean f1071ILl;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public ZipEntry f1072IiL;
    public String Lil;
    public byte[] LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public byte[] f1073Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public int f1074L11I;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public boolean f1075lIiI;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public CRC32 f1076il;

    public I1I(InputStream inputStream) {
        super(new PushbackInputStream(inputStream, 512), new Inflater(true), 512);
        this.f1076il = new CRC32();
        this.f1073Ll1 = new byte[512];
        this.f1075lIiI = false;
        this.f1071ILl = false;
        this.Lil = IL1Iii.IL1Iii(new byte[]{108, 101, 118, 73, 89}, IL1Iii.IL1Iii(new byte[]{8, 1, 2, 83, 5, 82}, IL1Iii.IL1Iii(new byte[]{9, 81, 5, 82, 83, 86}, "8a7e70")));
        this.LlLI1 = new byte[256];
        this.f1079lLi1LL = true;
        if (inputStream == null) {
            throw new NullPointerException(IL1Iii.IL1Iii(new byte[]{15, 92, 66, 90, 17, 20, 8, 71, 14, 95}, IL1Iii.IL1Iii(new byte[]{2, 11, 87, 11, 81, 5}, IL1Iii.IL1Iii(new byte[]{81, 88, 4, 14, 82, 83}, "5a16ab"))));
        }
    }

    /* JADX INFO: renamed from: IIi丨丨I, reason: contains not printable characters */
    public static final int m1096IIiI(byte[] bArr, int i) {
        return ((bArr[i + 1] & StatementImpl.USES_VARIABLES_UNKNOWN) << 8) | (bArr[i] & StatementImpl.USES_VARIABLES_UNKNOWN);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    private void m1097IiL() throws IOException {
        if (this.f1075lIiI) {
            throw new IOException(IL1Iii.IL1Iii(new byte[]{96, 71, 70, 0, 3, 92, 19, 80, 88, 10, 17, 84, 87}, IL1Iii.IL1Iii(new byte[]{2, 6, 2, 6, 1, 7}, IL1Iii.IL1Iii(new byte[]{6, 83, 6, 86, 2, 84}, "7f05ab"))));
        }
    }

    /* JADX INFO: renamed from: iI1i丨I, reason: contains not printable characters */
    public static String m1098iI1iI(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, IL1Iii.IL1Iii(new byte[]{81, 1, 94}, IL1Iii.IL1Iii(new byte[]{85, 83, 13, 87, 3, 5}, IL1Iii.IL1Iii(new byte[]{5, 2, 12, 82, 2, 81}, "f24c10"))));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            int i3 = i2 + i;
            int i4 = i;
            int i5 = 0;
            while (i4 < i3) {
                int i6 = i4 + 1;
                switch ((bArr[i4] & StatementImpl.USES_VARIABLES_UNKNOWN) >> 4) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        break;
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    default:
                        throw new IllegalArgumentException();
                    case 12:
                    case 13:
                        i4 = i6 + 1;
                        if ((bArr[i6] & 192) != 128) {
                            throw new IllegalArgumentException();
                        }
                        i5++;
                        continue;
                        break;
                    case 14:
                        int i7 = i6 + 1;
                        if ((bArr[i6] & 192) == 128) {
                            i6 = i7 + 1;
                            if ((bArr[i7] & 192) != 128) {
                            }
                        }
                        throw new IllegalArgumentException();
                }
                i5++;
                i4 = i6;
            }
            if (i4 != i3) {
                throw new IllegalArgumentException();
            }
            char[] cArr = new char[i5];
            int i8 = 0;
            while (i < i3) {
                int i9 = i + 1;
                int i10 = bArr[i] & StatementImpl.USES_VARIABLES_UNKNOWN;
                switch (i10 >> 4) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        cArr[i8] = (char) i10;
                        i = i9;
                        i8++;
                        break;
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    default:
                        throw new IllegalArgumentException();
                    case 12:
                    case 13:
                        cArr[i8] = (char) (((i10 & 31) << 6) | (bArr[i9] & 63));
                        i8++;
                        i = i9 + 1;
                        break;
                    case 14:
                        int i11 = i9 + 1;
                        cArr[i8] = (char) (((i10 & 15) << 12) | ((bArr[i9] & 63) << 6) | (bArr[i11] & 63));
                        i = i11 + 1;
                        i8++;
                        break;
                }
            }
            return new String(cArr, 0, i5);
        }
    }

    /* JADX INFO: renamed from: l丨liiI1, reason: contains not printable characters */
    public static final long m1099lliiI1(byte[] bArr, int i) {
        return (((long) m1096IIiI(bArr, i + 2)) << 16) | ((long) m1096IIiI(bArr, i));
    }

    /* JADX INFO: renamed from: I1L丨11L, reason: contains not printable characters */
    public final void m1100I1L11L(ZipEntry zipEntry) throws IOException {
        int remaining = this.f3362ILil.getRemaining();
        if (remaining > 0) {
            ((PushbackInputStream) ((FilterInputStream) this).in).unread(this.f3361I1I, this.f1077IL - remaining, remaining);
        }
        if ((this.f1074L11I & 8) == 8) {
            m1101ILLIi(this.f1073Ll1, 0, 16);
            long jM1099lliiI1 = m1099lliiI1(this.f1073Ll1, 0);
            if (jM1099lliiI1 != 134695760) {
                zipEntry.f2893IL = jM1099lliiI1;
                zipEntry.f2896lLi1LL = m1099lliiI1(this.f1073Ll1, 4);
                zipEntry.f5366Ilil = m1099lliiI1(this.f1073Ll1, 8);
                ((PushbackInputStream) ((FilterInputStream) this).in).unread(this.f1073Ll1, 11, 4);
            } else {
                zipEntry.f2893IL = m1099lliiI1(this.f1073Ll1, 4);
                zipEntry.f2896lLi1LL = m1099lliiI1(this.f1073Ll1, 8);
                zipEntry.f5366Ilil = m1099lliiI1(this.f1073Ll1, 12);
            }
        }
        if (zipEntry.f5366Ilil != this.f3362ILil.getBytesWritten()) {
            throw new ZipException(IL1Iii.IL1Iii(new byte[]{95, 8, 20, 81, 10, 13, 82, 70, 7, 94, 18, 22, 79, 70, 17, 89, 28, 1, 22, 78, 7, 72, 22, 1, 85, 18, 7, 84, 70}, IL1Iii.IL1Iii(new byte[]{84, 7, 90, 3, 85, 93}, IL1Iii.IL1Iii(new byte[]{90, 87, 12, 82, 7, 9}, "864a40"))) + zipEntry.f5366Ilil + IL1Iii.IL1Iii(new byte[]{17, 7, 67, 67, 19, 2, 94, 17, 22}, IL1Iii.IL1Iii(new byte[]{83, 93, 87, 85, 85, 4}, IL1Iii.IL1Iii(new byte[]{90, 8, 81, 0, 3, 84}, "800be5"))) + this.f3362ILil.getBytesWritten() + IL1Iii.IL1Iii(new byte[]{70, 85, 78, 66, 92, 64, 79}, IL1Iii.IL1Iii(new byte[]{7, 83, 82, 80, 15, 11}, IL1Iii.IL1Iii(new byte[]{5, 86, 3, 3, 14, 93}, "d2fe8e"))));
        }
        if (zipEntry.f2896lLi1LL != this.f3362ILil.getBytesRead()) {
            throw new ZipException(IL1Iii.IL1Iii(new byte[]{80, 13, 78, 87, 95, 92, 93, 67, 93, 88, 71, 71, 64, 67, 91, 89, 94, 69, 75, 6, 75, 69, 86, 81, 25, 16, 81, 76, 86, 21, 17, 6, 64, 70, 86, 86, 77, 6, 92, 22}, IL1Iii.IL1Iii(new byte[]{90, 2, 11, 83, 86, 1}, IL1Iii.IL1Iii(new byte[]{0, 3, 81, 6, 82, 85}, "cbbc7a"))) + zipEntry.f2896lLi1LL + IL1Iii.IL1Iii(new byte[]{23, 86, 67, 65, 18, 4, 88, 64, 22}, IL1Iii.IL1Iii(new byte[]{15, 4, 14, 7, 6, 83}, IL1Iii.IL1Iii(new byte[]{9, 85, 92, 87, 80, 3}, "1eded3"))) + this.f3362ILil.getBytesRead() + IL1Iii.IL1Iii(new byte[]{21, 3, 73, 70, 3, 16, 28}, IL1Iii.IL1Iii(new byte[]{1, 84, 84, 83, 86, 83}, IL1Iii.IL1Iii(new byte[]{0, 87, 5, 81, 81, 85}, "4ba0ae"))));
        }
        if (zipEntry.f2893IL == this.f1076il.getValue()) {
            return;
        }
        throw new ZipException(IL1Iii.IL1Iii(new byte[]{92, 10, 79, 86, 94, 11, 81, 68, 92, 89, 70, 16, 76, 68, 122, 101, 113, 66, 29, 1, 65, 71, 87, 1, 65, 1, 93, 23, 2, 26}, IL1Iii.IL1Iii(new byte[]{83, 82, 9, 81, 0, 90}, IL1Iii.IL1Iii(new byte[]{2, 80, 82, 5, 6, 9}, "dfbc41"))) + Long.toHexString(zipEntry.f2893IL) + IL1Iii.IL1Iii(new byte[]{17, 3, 23, 23, 66, 81, 94, 21, 66, 83, 26}, IL1Iii.IL1Iii(new byte[]{5, 83, 90, 87, 80, 3}, IL1Iii.IL1Iii(new byte[]{0, 2, 10, 3, 0, 84}, "40272a"))) + Long.toHexString(this.f1076il.getValue()) + IL1Iii.IL1Iii(new byte[]{26}, IL1Iii.IL1Iii(new byte[]{2, 84, 10, 0, 4, 82}, IL1Iii.IL1Iii(new byte[]{5, 1, 91, 5, 80, 3}, "44b054"))));
    }

    /* JADX INFO: renamed from: ILL丨Ii, reason: contains not printable characters */
    public final void m1101ILLIi(byte[] bArr, int i, int i2) throws IOException {
        while (i2 > 0) {
            int i3 = ((FilterInputStream) this).in.read(bArr, i, i2);
            if (i3 == -1) {
                throw new EOFException();
            }
            i += i3;
            i2 -= i3;
        }
    }

    /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
    public void m1102L11() throws IOException {
        byte[] bArr;
        m1097IiL();
        do {
            bArr = this.f1073Ll1;
        } while (read(bArr, 0, bArr.length) != -1);
        this.f1071ILl = true;
    }

    public ZipEntry LLL() throws IOException {
        m1097IiL();
        if (this.f1072IiL != null) {
            m1102L11();
        }
        this.f1076il.reset();
        this.f3362ILil.reset();
        ZipEntry zipEntryM1104li11 = m1104li11();
        this.f1072IiL = zipEntryM1104li11;
        if (zipEntryM1104li11 == null) {
            return null;
        }
        if (zipEntryM1104li11.f2895iILLL1 == 0) {
            this.ILL = zipEntryM1104li11.f5366Ilil;
        }
        this.f1071ILl = false;
        return zipEntryM1104li11;
    }

    /* JADX INFO: renamed from: LlIl丨, reason: contains not printable characters */
    public ZipEntry m1103LlIl(String str) {
        return new ZipEntry(str);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        m1097IiL();
        return this.f1071ILl ? 0 : 1;
    }

    @Override // I1I.I1I.p008IL.iIlLiL.IL1Iii, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f1075lIiI) {
            return;
        }
        super.close();
        this.f1075lIiI = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX INFO: renamed from: l丨丨i11, reason: contains not printable characters */
    public final ZipEntry m1104li11() throws IOException {
        try {
            m1101ILLIi(this.f1073Ll1, 0, 30);
            if (m1099lliiI1(this.f1073Ll1, 0) != 67324752) {
                return null;
            }
            ZipEntry zipEntryM1096IIiI = m1096IIiI(this.f1073Ll1, 26);
            int length = this.LlLI1.length;
            if (zipEntryM1096IIiI > length) {
                do {
                    length *= 2;
                } while (zipEntryM1096IIiI > length);
                this.LlLI1 = new byte[length];
            }
            m1101ILLIi(this.LlLI1, 0, zipEntryM1096IIiI);
            try {
                zipEntryM1096IIiI = this.Lil.toUpperCase().equals(IL1Iii.IL1Iii(new byte[]{109, 54, 119, 75, 93}, IL1Iii.IL1Iii(new byte[]{89, 80, 9, 95, 87, 8}, IL1Iii.IL1Iii(new byte[]{3, 81, 93, 90, 84, 91}, "bcecfb")))) ? m1103LlIl(m1098iI1iI(this.LlLI1, 0, zipEntryM1096IIiI)) : m1103LlIl(new String(this.LlLI1, 0, zipEntryM1096IIiI, this.Lil));
            } catch (Exception unused) {
                zipEntryM1096IIiI = m1103LlIl(m1098iI1iI(this.LlLI1, 0, zipEntryM1096IIiI));
            }
            int iM1096IIiI = m1096IIiI(this.f1073Ll1, 6);
            this.f1074L11I = iM1096IIiI;
            if ((iM1096IIiI & 1) == 1) {
                throw new ZipException(IL1Iii.IL1Iii(new byte[]{81, 10, 87, 68, 76, 67, 64, 1, 80, 22, 111, 122, 100, 68, 81, 88, 65, 65, 77, 68, 90, 89, 65, 19, 71, 17, 68, 70, 90, 65, 64, 1, 80}, IL1Iii.IL1Iii(new byte[]{86, 6, 87, 3, 4, 5}, IL1Iii.IL1Iii(new byte[]{87, 84, 84, 83, 2, 3}, "567f35"))));
            }
            zipEntryM1096IIiI.f2895iILLL1 = m1096IIiI(this.f1073Ll1, 8);
            zipEntryM1096IIiI.f5364I1I = m1099lliiI1(this.f1073Ll1, 10);
            if ((this.f1074L11I & 8) != 8) {
                zipEntryM1096IIiI.f2893IL = m1099lliiI1(this.f1073Ll1, 14);
                zipEntryM1096IIiI.f2896lLi1LL = m1099lliiI1(this.f1073Ll1, 18);
                zipEntryM1096IIiI.f5366Ilil = m1099lliiI1(this.f1073Ll1, 22);
            } else if (zipEntryM1096IIiI.f2895iILLL1 != 8) {
                throw new ZipException(IL1Iii.IL1Iii(new byte[]{10, 12, 13, 24, 22, 115, 32, 36, 45, 32, 98, 114, 33, 66, 4, 15, 66, 69, 12, 7, 18, 65, 85, 86, 11, 66, 9, 0, 64, 82, 69, 39, 57, 53, 22, 83, 0, 17, 2, 19, 95, 71, 17, 13, 19}, IL1Iii.IL1Iii(new byte[]{92, 6, 2, 82, 6, 1}, IL1Iii.IL1Iii(new byte[]{90, 6, 85, 2, 7, 87}, "cb617a"))));
            }
            int iM1096IIiI2 = m1096IIiI(this.f1073Ll1, 28);
            if (iM1096IIiI2 > 0) {
                byte[] bArr = new byte[iM1096IIiI2];
                m1101ILLIi(bArr, 0, iM1096IIiI2);
                zipEntryM1096IIiI.I1I(bArr);
            }
            return zipEntryM1096IIiI;
        } catch (EOFException unused2) {
            return null;
        }
    }

    @Override // I1I.I1I.p008IL.iIlLiL.IL1Iii, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        m1097IiL();
        if (i < 0 || i2 < 0 || i > bArr.length - i2) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        ZipEntry zipEntry = this.f1072IiL;
        if (zipEntry == null) {
            return -1;
        }
        int i3 = zipEntry.f2895iILLL1;
        if (i3 != 0) {
            if (i3 != 8) {
                throw new ZipException(IL1Iii.IL1Iii(new byte[]{10, 91, 71, 4, 84, 13, 7, 21, 82, 10, 85, 20, 17, 80, 66, 22, 81, 11, 13, 21, 92, 0, 76, 12, 12, 81}, IL1Iii.IL1Iii(new byte[]{84, 80, 85, 92, 14, 0}, IL1Iii.IL1Iii(new byte[]{82, 92, 0, 0, 82, 1}, "e9d9de"))));
            }
            int i4 = super.read(bArr, i, i2);
            if (i4 == -1) {
                m1100I1L11L(this.f1072IiL);
                this.f1071ILl = true;
                this.f1072IiL = null;
            } else {
                this.f1076il.update(bArr, i, i4);
            }
            return i4;
        }
        long j = this.ILL;
        if (j <= 0) {
            this.f1071ILl = true;
            this.f1072IiL = null;
            return -1;
        }
        if (i2 > j) {
            i2 = (int) j;
        }
        int i5 = ((FilterInputStream) this).in.read(bArr, i, i2);
        if (i5 == -1) {
            throw new ZipException(IL1Iii.IL1Iii(new byte[]{68, 13, 1, 77, 73, 83, 82, 23, 1, 81, 25, 115, 126, 37}, IL1Iii.IL1Iii(new byte[]{7, 82, 0, 81, 13, 2}, IL1Iii.IL1Iii(new byte[]{87, 1, 87, 93, 85, 81}, "a039ae"))));
        }
        this.f1076il.update(bArr, i, i5);
        long j2 = this.ILL - ((long) i5);
        this.ILL = j2;
        if (j2 != 0 || this.f1072IiL.f2893IL == this.f1076il.getValue()) {
            return i5;
        }
        throw new ZipException(IL1Iii.IL1Iii(new byte[]{80, 90, 23, 81, 93, 11, 93, 20, 4, 94, 69, 16, 64, 20, 34, 98, 114, 66, 17, 81, 25, 64, 84, 1, 77, 81, 5, 16, 1, 26}, IL1Iii.IL1Iii(new byte[]{13, 13, 82, 1, 1, 85}, IL1Iii.IL1Iii(new byte[]{5, 8, 3, 80, 5, 4}, "110a53"))) + Long.toHexString(this.f1072IiL.f2893IL) + IL1Iii.IL1Iii(new byte[]{17, 87, 65, 76, 65, 94, 94, 65, 20, 8, 25}, IL1Iii.IL1Iii(new byte[]{7, 12, 80, 92, 89, 90}, IL1Iii.IL1Iii(new byte[]{3, 13, 83, 80, 8, 90}, "547409"))) + Long.toHexString(this.f1076il.getValue()) + IL1Iii.IL1Iii(new byte[]{16}, IL1Iii.IL1Iii(new byte[]{92, 95, 80, 81, 80, 86}, IL1Iii.IL1Iii(new byte[]{0, 3, 14, 0, 3, 82}, "ee8a11"))));
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{93, 82, 6, 89, 69, 89, 69, 82, 65, 75, 90, 89, 67, 23, 13, 93, 95, 87, 71, 95}, IL1Iii.IL1Iii(new byte[]{80, 1, 88, 8, 7, 8}, IL1Iii.IL1Iii(new byte[]{90, 6, 11, 82, 85, 1}, "902bc9"))));
        }
        m1097IiL();
        int iMin = (int) Math.min(j, 2147483647L);
        int i = 0;
        while (i < iMin) {
            int length = iMin - i;
            byte[] bArr = this.f1073Ll1;
            if (length > bArr.length) {
                length = bArr.length;
            }
            int i2 = read(bArr, 0, length);
            if (i2 == -1) {
                this.f1071ILl = true;
                break;
            }
            i += i2;
        }
        return i;
    }
}
