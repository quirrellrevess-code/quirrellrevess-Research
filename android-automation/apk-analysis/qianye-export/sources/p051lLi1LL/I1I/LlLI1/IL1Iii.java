package p051lLi1LL.I1I.LlLI1;

import com.mysql.jdbc.StatementImpl;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: Base64.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final byte[] f5452IL1Iii = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final byte[] f5453ILil = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final byte[] f5451I1I = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static final byte[] f2989IL = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static final byte[] f5454Ilil = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static final byte[] f2990lLi1LL = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    public static final byte[] ILL(int i) {
        if ((i & 16) == 16) {
            return f2989IL;
        }
        return (i & 32) == 32 ? f2990lLi1LL : f5453ILil;
    }

    public static /* synthetic */ byte[] ILil(byte[] bArr, byte[] bArr2, int i, int i2) {
        m3580lLi1LL(bArr, bArr2, i, i2);
        return bArr;
    }

    public static byte[] Ilil(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        byte[] bArrM3581il = m3581il(i4);
        int i5 = (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0) | (i2 > 2 ? (bArr[i + 2] << 24) >>> 24 : 0);
        if (i2 == 1) {
            bArr2[i3] = bArrM3581il[i5 >>> 18];
            bArr2[i3 + 1] = bArrM3581il[(i5 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return bArr2;
        }
        if (i2 == 2) {
            bArr2[i3] = bArrM3581il[i5 >>> 18];
            bArr2[i3 + 1] = bArrM3581il[(i5 >>> 12) & 63];
            bArr2[i3 + 2] = bArrM3581il[(i5 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return bArr2;
        }
        if (i2 != 3) {
            return bArr2;
        }
        bArr2[i3] = bArrM3581il[i5 >>> 18];
        bArr2[i3 + 1] = bArrM3581il[(i5 >>> 12) & 63];
        bArr2[i3 + 2] = bArrM3581il[(i5 >>> 6) & 63];
        bArr2[i3 + 3] = bArrM3581il[i5 & 63];
        return bArr2;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static int m3576IL(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4;
        int i5;
        if (bArr == null) {
            throw new IllegalArgumentException("Source array was null.");
        }
        if (bArr2 == null) {
            throw new IllegalArgumentException("Destination array was null.");
        }
        if (i < 0 || (i4 = i + 3) >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i)));
        }
        if (i2 < 0 || (i5 = i2 + 2) >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i2)));
        }
        byte[] bArrILL = ILL(i3);
        int i6 = i + 2;
        if (bArr[i6] == 61) {
            bArr2[i2] = (byte) ((((bArrILL[bArr[i + 1]] & StatementImpl.USES_VARIABLES_UNKNOWN) << 12) | ((bArrILL[bArr[i]] & StatementImpl.USES_VARIABLES_UNKNOWN) << 18)) >>> 16);
            return 1;
        }
        if (bArr[i4] == 61) {
            int i7 = ((bArrILL[bArr[i6]] & StatementImpl.USES_VARIABLES_UNKNOWN) << 6) | ((bArrILL[bArr[i + 1]] & StatementImpl.USES_VARIABLES_UNKNOWN) << 12) | ((bArrILL[bArr[i]] & StatementImpl.USES_VARIABLES_UNKNOWN) << 18);
            bArr2[i2] = (byte) (i7 >>> 16);
            bArr2[i2 + 1] = (byte) (i7 >>> 8);
            return 2;
        }
        int i8 = (bArrILL[bArr[i4]] & StatementImpl.USES_VARIABLES_UNKNOWN) | ((bArrILL[bArr[i + 1]] & StatementImpl.USES_VARIABLES_UNKNOWN) << 12) | ((bArrILL[bArr[i]] & StatementImpl.USES_VARIABLES_UNKNOWN) << 18) | ((bArrILL[bArr[i6]] & StatementImpl.USES_VARIABLES_UNKNOWN) << 6);
        bArr2[i2] = (byte) (i8 >> 16);
        bArr2[i2 + 1] = (byte) (i8 >> 8);
        bArr2[i5] = (byte) i8;
        return 3;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static String m3577IiL(byte[] bArr, int i, int i2, int i3) throws Throwable {
        byte[] bArrM3578L11I = m3578L11I(bArr, i, i2, i3);
        try {
            return new String(bArrM3578L11I, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArrM3578L11I);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:104:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static byte[] m3578L11I(byte[] bArr, int i, int i2, int i3) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        C0596IL1Iii c0596IL1Iii;
        GZIPOutputStream gZIPOutputStream;
        if (bArr == null) {
            throw new IllegalArgumentException("Cannot serialize a null array.");
        }
        if (i < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i);
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Cannot have length offset: " + i2);
        }
        if (i + i2 > bArr.length) {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length)));
        }
        if ((i3 & 2) == 0) {
            boolean z = (i3 & 8) != 0;
            int i4 = ((i2 / 3) * 4) + (i2 % 3 > 0 ? 4 : 0);
            if (z) {
                i4 += i4 / 76;
            }
            int i5 = i4;
            byte[] bArr2 = new byte[i5];
            int i6 = i2 - 2;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i7 < i6) {
                int i10 = i7;
                Ilil(bArr, i7 + i, 3, bArr2, i8, i3);
                int i11 = i9 + 4;
                if (!z || i11 < 76) {
                    i9 = i11;
                } else {
                    bArr2[i8 + 4] = 10;
                    i8++;
                    i9 = 0;
                }
                i7 = i10 + 3;
                i8 += 4;
            }
            int i12 = i7;
            if (i12 < i2) {
                Ilil(bArr, i12 + i, i2 - i12, bArr2, i8, i3);
                i8 += 4;
            }
            int i13 = i8;
            if (i13 > i5 - 1) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i13];
            System.arraycopy(bArr2, 0, bArr3, 0, i13);
            return bArr3;
        }
        GZIPOutputStream gZIPOutputStream2 = null;
        gZIPOutputStream2 = null;
        gZIPOutputStream2 = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                c0596IL1Iii = new C0596IL1Iii(byteArrayOutputStream, i3 | 1);
                try {
                    gZIPOutputStream = new GZIPOutputStream(c0596IL1Iii);
                    try {
                        gZIPOutputStream.write(bArr, i, i2);
                        gZIPOutputStream.close();
                        try {
                            gZIPOutputStream.close();
                        } catch (Exception unused) {
                        }
                        try {
                            c0596IL1Iii.close();
                        } catch (Exception unused2) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused3) {
                        }
                        return byteArrayOutputStream.toByteArray();
                    } catch (IOException e) {
                        e = e;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            gZIPOutputStream2 = gZIPOutputStream;
                            if (gZIPOutputStream2 != null) {
                                try {
                                    gZIPOutputStream2.close();
                                } catch (Exception unused4) {
                                }
                            }
                            if (c0596IL1Iii != null) {
                                try {
                                    c0596IL1Iii.close();
                                } catch (Exception unused5) {
                                }
                            }
                            if (byteArrayOutputStream == null) {
                                throw th;
                            }
                            try {
                                byteArrayOutputStream.close();
                                throw th;
                            } catch (Exception unused6) {
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        gZIPOutputStream2 = gZIPOutputStream;
                        if (gZIPOutputStream2 != null) {
                            gZIPOutputStream2.close();
                        }
                        if (c0596IL1Iii != null) {
                            c0596IL1Iii.close();
                        }
                        if (byteArrayOutputStream == null) {
                            throw th;
                        }
                        byteArrayOutputStream.close();
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    gZIPOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    if (gZIPOutputStream2 != null) {
                        gZIPOutputStream2.close();
                    }
                    if (c0596IL1Iii != null) {
                        c0596IL1Iii.close();
                    }
                    if (byteArrayOutputStream == null) {
                        throw th;
                    }
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                c0596IL1Iii = null;
                gZIPOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                c0596IL1Iii = null;
            }
        } catch (IOException e4) {
            e = e4;
            c0596IL1Iii = null;
            gZIPOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
            c0596IL1Iii = null;
        }
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static String m3579iILLL1(byte[] bArr) {
        try {
            return m3577IiL(bArr, 0, bArr.length, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static byte[] m3580lLi1LL(byte[] bArr, byte[] bArr2, int i, int i2) {
        Ilil(bArr2, 0, i, bArr, 0, i2);
        return bArr;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static final byte[] m3581il(int i) {
        if ((i & 16) == 16) {
            return f5451I1I;
        }
        return (i & 32) == 32 ? f5454Ilil : f5452IL1Iii;
    }

    /* JADX INFO: renamed from: l丨Li1LL.I1I.LlLI1.IL1Iii$IL1Iii, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Base64.java */
    public static class C0596IL1Iii extends FilterOutputStream {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f5455I1I;
        public byte[] ILL;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public boolean f5456ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int f5457Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public byte[] f2991IL;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public byte[] f2992IiL;

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public boolean f2993L11I;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public boolean f2994iILLL1;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public int f2995lLi1LL;

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public int f2996il;

        public C0596IL1Iii(OutputStream outputStream, int i) {
            super(outputStream);
            this.f2994iILLL1 = (i & 8) != 0;
            boolean z = (i & 1) != 0;
            this.f5456ILil = z;
            int i2 = z ? 3 : 4;
            this.f5457Ilil = i2;
            this.f2991IL = new byte[i2];
            this.f5455I1I = 0;
            this.f2995lLi1LL = 0;
            this.f2993L11I = false;
            this.f2992IiL = new byte[4];
            this.f2996il = i;
            this.ILL = IL1Iii.ILL(i);
        }

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public void m3582IiL() throws IOException {
            int i = this.f5455I1I;
            if (i > 0) {
                if (!this.f5456ILil) {
                    throw new IOException("Base64 input not properly padded.");
                }
                OutputStream outputStream = ((FilterOutputStream) this).out;
                byte[] bArr = this.f2992IiL;
                IL1Iii.ILil(bArr, this.f2991IL, i, this.f2996il);
                outputStream.write(bArr);
                this.f5455I1I = 0;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            m3582IiL();
            super.close();
            this.f2991IL = null;
            ((FilterOutputStream) this).out = null;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            if (this.f2993L11I) {
                ((FilterOutputStream) this).out.write(i);
                return;
            }
            if (!this.f5456ILil) {
                byte[] bArr = this.ILL;
                int i2 = i & 127;
                if (bArr[i2] <= -5) {
                    if (bArr[i2] != -5) {
                        throw new IOException("Invalid character in Base64 data.");
                    }
                    return;
                }
                byte[] bArr2 = this.f2991IL;
                int i3 = this.f5455I1I;
                int i4 = i3 + 1;
                this.f5455I1I = i4;
                bArr2[i3] = (byte) i;
                if (i4 >= this.f5457Ilil) {
                    ((FilterOutputStream) this).out.write(this.f2992IiL, 0, IL1Iii.m3576IL(bArr2, 0, this.f2992IiL, 0, this.f2996il));
                    this.f5455I1I = 0;
                    return;
                }
                return;
            }
            byte[] bArr3 = this.f2991IL;
            int i5 = this.f5455I1I;
            int i6 = i5 + 1;
            this.f5455I1I = i6;
            bArr3[i5] = (byte) i;
            int i7 = this.f5457Ilil;
            if (i6 >= i7) {
                OutputStream outputStream = ((FilterOutputStream) this).out;
                byte[] bArr4 = this.f2992IiL;
                IL1Iii.ILil(bArr4, bArr3, i7, this.f2996il);
                outputStream.write(bArr4);
                int i8 = this.f2995lLi1LL + 4;
                this.f2995lLi1LL = i8;
                if (this.f2994iILLL1 && i8 >= 76) {
                    ((FilterOutputStream) this).out.write(10);
                    this.f2995lLi1LL = 0;
                }
                this.f5455I1I = 0;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.f2993L11I) {
                ((FilterOutputStream) this).out.write(bArr, i, i2);
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }
    }
}
