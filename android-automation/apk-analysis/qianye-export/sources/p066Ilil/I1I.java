package p066Ilil;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.MysqlDefs;
import com.mysql.jdbc.StatementImpl;
import com.tencent.smtt.sdk.TbsListener;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: Buffer.java */
/* JADX INFO: loaded from: classes.dex */
public final class I1I implements lLi1LL, IL, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static final byte[] f2056IL = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public long f4559I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    @Nullable
    public llL1ii f4560ILil;

    /* JADX INFO: renamed from: Ilil.I1I$I1I, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Buffer.java */
    public static final class C0590I1I implements Closeable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public boolean f4561I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public I1I f4562ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public llL1ii f2057IL;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public byte[] f2060lLi1LL;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public long f4563Ilil = -1;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public int f2059iILLL1 = -1;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public int f2058IiL = -1;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public final int m2812IiL() {
            long j = this.f4563Ilil;
            if (j != this.f4562ILil.f4559I1I) {
                return j == -1 ? m2813(0L) : m2813(j + ((long) (this.f2058IiL - this.f2059iILLL1)));
            }
            throw new IllegalStateException();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f4562ILil == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.f4562ILil = null;
            this.f2057IL = null;
            this.f4563Ilil = -1L;
            this.f2060lLi1LL = null;
            this.f2059iILLL1 = -1;
            this.f2058IiL = -1;
        }

        /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
        public final int m2813(long j) {
            if (j >= -1) {
                I1I i1i = this.f4562ILil;
                long j2 = i1i.f4559I1I;
                if (j <= j2) {
                    if (j == -1 || j == j2) {
                        this.f2057IL = null;
                        this.f4563Ilil = j;
                        this.f2060lLi1LL = null;
                        this.f2059iILLL1 = -1;
                        this.f2058IiL = -1;
                        return -1;
                    }
                    long j3 = 0;
                    llL1ii lll1ii = i1i.f4560ILil;
                    llL1ii lll1ii2 = this.f2057IL;
                    if (lll1ii2 != null) {
                        long j4 = this.f4563Ilil - ((long) (this.f2059iILLL1 - lll1ii2.f4596ILil));
                        if (j4 > j) {
                            j2 = j4;
                            lll1ii2 = lll1ii;
                            lll1ii = lll1ii2;
                        } else {
                            j3 = j4;
                        }
                    } else {
                        lll1ii2 = lll1ii;
                    }
                    if (j2 - j > j - j3) {
                        while (true) {
                            int i = lll1ii2.f4594I1I;
                            int i2 = lll1ii2.f4596ILil;
                            if (j < ((long) (i - i2)) + j3) {
                                break;
                            }
                            j3 += (long) (i - i2);
                            lll1ii2 = lll1ii2.f2068lLi1LL;
                        }
                    } else {
                        while (j2 > j) {
                            lll1ii = lll1ii.f2067iILLL1;
                            j2 -= (long) (lll1ii.f4594I1I - lll1ii.f4596ILil);
                        }
                        lll1ii2 = lll1ii;
                        j3 = j2;
                    }
                    if (this.f4561I1I && lll1ii2.f2066IL) {
                        llL1ii lll1iiM2836lLi1LL = lll1ii2.m2836lLi1LL();
                        I1I i1i2 = this.f4562ILil;
                        if (i1i2.f4560ILil == lll1ii2) {
                            i1i2.f4560ILil = lll1iiM2836lLi1LL;
                        }
                        lll1ii2.I1I(lll1iiM2836lLi1LL);
                        lll1iiM2836lLi1LL.f2067iILLL1.ILil();
                        lll1ii2 = lll1iiM2836lLi1LL;
                    }
                    this.f2057IL = lll1ii2;
                    this.f4563Ilil = j;
                    this.f2060lLi1LL = lll1ii2.f4595IL1Iii;
                    int i3 = lll1ii2.f4596ILil + ((int) (j - j3));
                    this.f2059iILLL1 = i3;
                    int i4 = lll1ii2.f4594I1I;
                    this.f2058IiL = i4;
                    return i4 - i3;
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Long.valueOf(j), Long.valueOf(this.f4562ILil.f4559I1I)));
        }
    }

    /* JADX INFO: compiled from: Buffer.java */
    public class IL1Iii extends OutputStream {
        public IL1Iii() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return I1I.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            I1I.this.l1Lll((byte) i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            I1I.this.m100lL(bArr, i, i2);
        }
    }

    /* JADX INFO: compiled from: Buffer.java */
    public class ILil extends InputStream {
        public ILil() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(I1I.this.f4559I1I, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            I1I i1i = I1I.this;
            if (i1i.f4559I1I > 0) {
                return i1i.mo2798lIlii() & StatementImpl.USES_VARIABLES_UNKNOWN;
            }
            return -1;
        }

        public String toString() {
            return I1I.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            return I1I.this.m2802li11(bArr, i, i2);
        }
    }

    /* JADX INFO: renamed from: I1 */
    public llL1ii m95I1(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        llL1ii lll1ii = this.f4560ILil;
        if (lll1ii == null) {
            llL1ii lll1iiILil = lIlii.ILil();
            this.f4560ILil = lll1iiILil;
            lll1iiILil.f2067iILLL1 = lll1iiILil;
            lll1iiILil.f2068lLi1LL = lll1iiILil;
            return lll1iiILil;
        }
        llL1ii lll1ii2 = lll1ii.f2067iILLL1;
        if (lll1ii2.f4594I1I + i <= 8192 && lll1ii2.f4597Ilil) {
            return lll1ii2;
        }
        llL1ii lll1iiILil2 = lIlii.ILil();
        lll1ii2.I1I(lll1iiILil2);
        return lll1iiILil2;
    }

    @Override // p066Ilil.lLi1LL
    public void I11L(long j) throws EOFException {
        while (j > 0) {
            llL1ii lll1ii = this.f4560ILil;
            if (lll1ii == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, lll1ii.f4594I1I - lll1ii.f4596ILil);
            long j2 = iMin;
            this.f4559I1I -= j2;
            j -= j2;
            llL1ii lll1ii2 = this.f4560ILil;
            int i = lll1ii2.f4596ILil + iMin;
            lll1ii2.f4596ILil = i;
            if (i == lll1ii2.f4594I1I) {
                this.f4560ILil = lll1ii2.ILil();
                lIlii.IL1Iii(lll1ii2);
            }
        }
    }

    @Override // p066Ilil.IL
    public long I11li1(I11li1 i11li1) throws IOException {
        if (i11li1 == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long j2 = i11li1.read(this, 8192L);
            if (j2 == -1) {
                return j;
            }
            j += j2;
        }
    }

    @Override // p066Ilil.IL
    public IL I1I() {
        return this;
    }

    public I1I I1IILIIL(long j) {
        if (j == 0) {
            l1Lll(48);
            return this;
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                Liil1L1l("-9223372036854775808");
                return this;
            }
            z = true;
        }
        if (j < 100000000) {
            if (j < 10000) {
                if (j >= 100) {
                    i = j < 1000 ? 3 : 4;
                } else if (j >= 10) {
                    i = 2;
                }
            } else if (j < 1000000) {
                i = j < 100000 ? 5 : 6;
            } else {
                i = j < 10000000 ? 7 : 8;
            }
        } else if (j < 1000000000000L) {
            if (j < 10000000000L) {
                i = j < Http2Connection.DEGRADED_PONG_TIMEOUT_NS ? 9 : 10;
            } else {
                i = j < 100000000000L ? 11 : 12;
            }
        } else if (j < 1000000000000000L) {
            if (j < 10000000000000L) {
                i = 13;
            } else {
                i = j < 100000000000000L ? 14 : 15;
            }
        } else if (j < 100000000000000000L) {
            i = j < 10000000000000000L ? 16 : 17;
        } else {
            i = j < 1000000000000000000L ? 18 : 19;
        }
        if (z) {
            i++;
        }
        llL1ii lll1iiM95I1 = m95I1(i);
        byte[] bArr = lll1iiM95I1.f4595IL1Iii;
        int i2 = lll1iiM95I1.f4594I1I + i;
        while (j != 0) {
            i2--;
            bArr[i2] = f2056IL[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        lll1iiM95I1.f4594I1I += i;
        this.f4559I1I += (long) i;
        return this;
    }

    /* JADX INFO: renamed from: I1L丨11L, reason: contains not printable characters */
    public long m2770I1L11L(iILLL1 iilll1) {
        return m2772ILLIi(iilll1, 0L);
    }

    /* JADX INFO: renamed from: IIi丨丨I, reason: contains not printable characters */
    public final I1I m2771IIiI(I1I i1i, long j, long j2) {
        if (i1i == null) {
            throw new IllegalArgumentException("out == null");
        }
        I11L.ILil(this.f4559I1I, j, j2);
        if (j2 == 0) {
            return this;
        }
        i1i.f4559I1I += j2;
        llL1ii lll1ii = this.f4560ILil;
        while (true) {
            int i = lll1ii.f4594I1I;
            int i2 = lll1ii.f4596ILil;
            if (j < i - i2) {
                break;
            }
            j -= (long) (i - i2);
            lll1ii = lll1ii.f2068lLi1LL;
        }
        while (j2 > 0) {
            llL1ii lll1iiM2834IL = lll1ii.m2834IL();
            int i3 = (int) (((long) lll1iiM2834IL.f4596ILil) + j);
            lll1iiM2834IL.f4596ILil = i3;
            lll1iiM2834IL.f4594I1I = Math.min(i3 + ((int) j2), lll1iiM2834IL.f4594I1I);
            llL1ii lll1ii2 = i1i.f4560ILil;
            if (lll1ii2 == null) {
                lll1iiM2834IL.f2067iILLL1 = lll1iiM2834IL;
                lll1iiM2834IL.f2068lLi1LL = lll1iiM2834IL;
                i1i.f4560ILil = lll1iiM2834IL;
            } else {
                lll1ii2.f2067iILLL1.I1I(lll1iiM2834IL);
            }
            j2 -= (long) (lll1iiM2834IL.f4594I1I - lll1iiM2834IL.f4596ILil);
            lll1ii = lll1ii.f2068lLi1LL;
            j = 0;
        }
        return this;
    }

    @Override // p066Ilil.lLi1LL, p066Ilil.IL
    public I1I IL1Iii() {
        return this;
    }

    @Override // p066Ilil.lLi1LL
    public boolean ILL() {
        return this.f4559I1I == 0;
    }

    /* JADX INFO: renamed from: ILL丨Ii, reason: contains not printable characters */
    public long m2772ILLIi(iILLL1 iilll1, long j) {
        int i;
        int i2;
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        llL1ii lll1ii = this.f4560ILil;
        if (lll1ii == null) {
            return -1L;
        }
        long j3 = this.f4559I1I;
        if (j3 - j < j) {
            while (j3 > j) {
                lll1ii = lll1ii.f2067iILLL1;
                j3 -= (long) (lll1ii.f4594I1I - lll1ii.f4596ILil);
            }
        } else {
            while (true) {
                long j4 = ((long) (lll1ii.f4594I1I - lll1ii.f4596ILil)) + j2;
                if (j4 >= j) {
                    break;
                }
                lll1ii = lll1ii.f2068lLi1LL;
                j2 = j4;
            }
            j3 = j2;
        }
        if (iilll1.size() == 2) {
            byte b = iilll1.getByte(0);
            byte b2 = iilll1.getByte(1);
            while (j3 < this.f4559I1I) {
                byte[] bArr = lll1ii.f4595IL1Iii;
                i = (int) ((((long) lll1ii.f4596ILil) + j) - j3);
                int i3 = lll1ii.f4594I1I;
                while (i < i3) {
                    byte b3 = bArr[i];
                    if (b3 == b || b3 == b2) {
                        i2 = lll1ii.f4596ILil;
                        return ((long) (i - i2)) + j3;
                    }
                    i++;
                }
                j3 += (long) (lll1ii.f4594I1I - lll1ii.f4596ILil);
                lll1ii = lll1ii.f2068lLi1LL;
                j = j3;
            }
            return -1L;
        }
        byte[] bArrInternalArray = iilll1.internalArray();
        while (j3 < this.f4559I1I) {
            byte[] bArr2 = lll1ii.f4595IL1Iii;
            i = (int) ((((long) lll1ii.f4596ILil) + j) - j3);
            int i4 = lll1ii.f4594I1I;
            while (i < i4) {
                byte b4 = bArr2[i];
                for (byte b5 : bArrInternalArray) {
                    if (b4 == b5) {
                        i2 = lll1ii.f4596ILil;
                        return ((long) (i - i2)) + j3;
                    }
                }
                i++;
            }
            j3 += (long) (lll1ii.f4594I1I - lll1ii.f4596ILil);
            lll1ii = lll1ii.f2068lLi1LL;
            j = j3;
        }
        return -1L;
    }

    @Override // p066Ilil.lLi1LL
    public iILLL1 ILil(long j) throws EOFException {
        return new iILLL1(mo28101(j));
    }

    @Override // p066Ilil.IL
    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public /* bridge */ /* synthetic */ IL mo2773ILl() throws IOException {
        m2801lliiI1();
        return this;
    }

    @Override // p066Ilil.lLi1LL
    public int Ilil() {
        long j = this.f4559I1I;
        if (j < 4) {
            throw new IllegalStateException("size < 4: " + this.f4559I1I);
        }
        llL1ii lll1ii = this.f4560ILil;
        int i = lll1ii.f4596ILil;
        int i2 = lll1ii.f4594I1I;
        if (i2 - i < 4) {
            return ((mo2798lIlii() & StatementImpl.USES_VARIABLES_UNKNOWN) << 24) | ((mo2798lIlii() & StatementImpl.USES_VARIABLES_UNKNOWN) << 16) | ((mo2798lIlii() & StatementImpl.USES_VARIABLES_UNKNOWN) << 8) | (mo2798lIlii() & StatementImpl.USES_VARIABLES_UNKNOWN);
        }
        byte[] bArr = lll1ii.f4595IL1Iii;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & StatementImpl.USES_VARIABLES_UNKNOWN) << 24) | ((bArr[i3] & StatementImpl.USES_VARIABLES_UNKNOWN) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & StatementImpl.USES_VARIABLES_UNKNOWN) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & StatementImpl.USES_VARIABLES_UNKNOWN);
        this.f4559I1I = j - 4;
        if (i8 == i2) {
            this.f4560ILil = lll1ii.ILil();
            lIlii.IL1Iii(lll1ii);
        } else {
            lll1ii.f4596ILil = i8;
        }
        return i9;
    }

    /* JADX INFO: renamed from: I丨 */
    public final long m96I() {
        return this.f4559I1I;
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public long mo2774IIi() {
        int i;
        int i2;
        if (this.f4559I1I == 0) {
            throw new IllegalStateException("size == 0");
        }
        int i3 = 0;
        long j = 0;
        boolean z = false;
        do {
            llL1ii lll1ii = this.f4560ILil;
            byte[] bArr = lll1ii.f4595IL1Iii;
            int i4 = lll1ii.f4596ILil;
            int i5 = lll1ii.f4594I1I;
            while (i4 < i5) {
                byte b = bArr[i4];
                if (b < 48 || b > 57) {
                    if (b >= 97 && b <= 102) {
                        i = b - 97;
                    } else {
                        if (b < 65 || b > 70) {
                            if (i3 != 0) {
                                z = true;
                                break;
                            }
                            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b));
                        }
                        i = b - 65;
                    }
                    i2 = i + 10;
                } else {
                    i2 = b - 48;
                }
                if (((-1152921504606846976L) & j) != 0) {
                    I1I i1i = new I1I();
                    i1i.ill1LI1l(j);
                    i1i.l1Lll(b);
                    throw new NumberFormatException("Number too large: " + i1i.mo2785LlLLL());
                }
                j = (j << 4) | ((long) i2);
                i4++;
                i3++;
            }
            if (i4 == i5) {
                this.f4560ILil = lll1ii.ILil();
                lIlii.IL1Iii(lll1ii);
            } else {
                lll1ii.f4596ILil = i4;
            }
            if (z) {
                break;
            }
        } while (this.f4560ILil != null);
        this.f4559I1I -= (long) i3;
        return j;
    }

    @Override // p066Ilil.IL
    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public /* bridge */ /* synthetic */ IL mo2775IL(int i) throws IOException {
        m2787iIl1il(i);
        return this;
    }

    /* JADX INFO: renamed from: L11丨, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public I1I clone() {
        I1I i1i = new I1I();
        if (this.f4559I1I == 0) {
            return i1i;
        }
        llL1ii lll1iiM2834IL = this.f4560ILil.m2834IL();
        i1i.f4560ILil = lll1iiM2834IL;
        lll1iiM2834IL.f2067iILLL1 = lll1iiM2834IL;
        lll1iiM2834IL.f2068lLi1LL = lll1iiM2834IL;
        llL1ii lll1ii = this.f4560ILil;
        while (true) {
            lll1ii = lll1ii.f2068lLi1LL;
            if (lll1ii == this.f4560ILil) {
                i1i.f4559I1I = this.f4559I1I;
                return i1i;
            }
            i1i.f4560ILil.f2067iILLL1.I1I(lll1ii.m2834IL());
        }
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public short mo2777L111() {
        return I11L.m2768IL(mo101());
    }

    public I1I L1iI1(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        m100lL(bArr, 0, bArr.length);
        return this;
    }

    public I1I LI11(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (charset.equals(I11L.f4558IL1Iii)) {
            m97LL(str, i, i2);
            return this;
        }
        byte[] bytes = str.substring(i, i2).getBytes(charset);
        m100lL(bytes, 0, bytes.length);
        return this;
    }

    /* JADX INFO: renamed from: LI丨l, reason: contains not printable characters */
    public String m2778LIl(long j) throws EOFException {
        return m2791ili11(j, I11L.f4558IL1Iii);
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public InputStream mo2779LIll() {
        return new ILil();
    }

    /* JADX INFO: renamed from: LL */
    public I1I m97LL(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                llL1ii lll1iiM95I1 = m95I1(1);
                byte[] bArr = lll1iiM95I1.f4595IL1Iii;
                int i3 = lll1iiM95I1.f4594I1I - i;
                int iMin = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) cCharAt;
                while (i4 < iMin) {
                    char cCharAt2 = str.charAt(i4);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i4 + i3] = (byte) cCharAt2;
                    i4++;
                }
                int i5 = lll1iiM95I1.f4594I1I;
                int i6 = (i3 + i4) - i5;
                lll1iiM95I1.f4594I1I = i5 + i6;
                this.f4559I1I += (long) i6;
                i = i4;
            } else {
                if (cCharAt < 2048) {
                    l1Lll((cCharAt >> 6) | 192);
                    l1Lll((cCharAt & '?') | 128);
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    l1Lll((cCharAt >> '\f') | TbsListener.ErrorCode.EXCEED_INCR_UPDATE);
                    l1Lll(((cCharAt >> 6) & 63) | 128);
                    l1Lll((cCharAt & '?') | 128);
                } else {
                    int i7 = i + 1;
                    char cCharAt3 = i7 < i2 ? str.charAt(i7) : (char) 0;
                    if (cCharAt > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                        l1Lll(63);
                        i = i7;
                    } else {
                        int i8 = (((cCharAt & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                        l1Lll((i8 >> 18) | TbsListener.ErrorCode.TPATCH_VERSION_FAILED);
                        l1Lll(((i8 >> 12) & 63) | 128);
                        l1Lll(((i8 >> 6) & 63) | 128);
                        l1Lll((i8 & 63) | 128);
                        i += 2;
                    }
                }
                i++;
            }
        }
        return this;
    }

    @Override // p066Ilil.IL
    public /* bridge */ /* synthetic */ IL LL1IL(iILLL1 iilll1) throws IOException {
        m2803i11i(iilll1);
        return this;
    }

    public final byte LLL(long j) {
        int i;
        I11L.ILil(this.f4559I1I, j, 1L);
        long j2 = this.f4559I1I;
        if (j2 - j <= j) {
            long j3 = j - j2;
            llL1ii lll1ii = this.f4560ILil;
            do {
                lll1ii = lll1ii.f2067iILLL1;
                int i2 = lll1ii.f4594I1I;
                i = lll1ii.f4596ILil;
                j3 += (long) (i2 - i);
            } while (j3 < 0);
            return lll1ii.f4595IL1Iii[i + ((int) j3)];
        }
        llL1ii lll1ii2 = this.f4560ILil;
        while (true) {
            int i3 = lll1ii2.f4594I1I;
            int i4 = lll1ii2.f4596ILil;
            long j4 = i3 - i4;
            if (j < j4) {
                return lll1ii2.f4595IL1Iii[i4 + ((int) j)];
            }
            j -= j4;
            lll1ii2 = lll1ii2.f2068lLi1LL;
        }
    }

    public I1I LiL1(String str, Charset charset) {
        LI11(str, 0, str.length(), charset);
        return this;
    }

    public I1I Liil1L1l(String str) {
        m97LL(str, 0, str.length());
        return this;
    }

    @Override // p066Ilil.lLi1LL
    public String Lil(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = RecyclerView.FOREVER_NS;
        if (j != RecyclerView.FOREVER_NS) {
            j2 = j + 1;
        }
        long jM2786iI1iI = m2786iI1iI((byte) 10, 0L, j2);
        if (jM2786iI1iI != -1) {
            return m99iI(jM2786iI1iI);
        }
        if (j2 < m96I() && LLL(j2 - 1) == 13 && LLL(j2) == 10) {
            return m99iI(j2);
        }
        I1I i1i = new I1I();
        m2771IIiI(i1i, 0L, Math.min(32L, m96I()));
        throw new EOFException("\\n not found: limit=" + Math.min(m96I(), j) + " content=" + i1i.m98i1().hex() + (char) 8230);
    }

    /* JADX INFO: renamed from: LlIl丨, reason: contains not printable characters */
    public final long m2780LlIl() {
        long j = this.f4559I1I;
        if (j == 0) {
            return 0L;
        }
        llL1ii lll1ii = this.f4560ILil.f2067iILLL1;
        int i = lll1ii.f4594I1I;
        return (i >= 8192 || !lll1ii.f4597Ilil) ? j : j - ((long) (i - lll1ii.f4596ILil));
    }

    @Override // p066Ilil.IL
    public /* bridge */ /* synthetic */ IL LlLI1(String str) throws IOException {
        Liil1L1l(str);
        return this;
    }

    /* JADX INFO: renamed from: LlLiL丨L丨, reason: contains not printable characters */
    public int m2781LlLiLL(C0652ILl c0652ILl, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        llL1ii lll1ii;
        llL1ii lll1ii2 = this.f4560ILil;
        int i5 = -2;
        if (lll1ii2 == null) {
            if (z) {
                return -2;
            }
            return c0652ILl.indexOf(iILLL1.EMPTY);
        }
        byte[] bArr = lll1ii2.f4595IL1Iii;
        int i6 = lll1ii2.f4596ILil;
        int i7 = lll1ii2.f4594I1I;
        int[] iArr = c0652ILl.f4575I1I;
        llL1ii lll1ii3 = lll1ii2;
        int i8 = 0;
        int i9 = -1;
        loop0: while (true) {
            int i10 = i8 + 1;
            int i11 = iArr[i8];
            int i12 = i10 + 1;
            int i13 = iArr[i10];
            if (i13 != -1) {
                i9 = i13;
            }
            if (lll1ii3 == null) {
                break;
            }
            if (i11 >= 0) {
                int i14 = i6 + 1;
                int i15 = bArr[i6] & StatementImpl.USES_VARIABLES_UNKNOWN;
                int i16 = i12 + i11;
                while (i12 != i16) {
                    if (i15 == iArr[i12]) {
                        i = iArr[i12 + i11];
                        if (i14 == i7) {
                            lll1ii3 = lll1ii3.f2068lLi1LL;
                            i2 = lll1ii3.f4596ILil;
                            bArr = lll1ii3.f4595IL1Iii;
                            i7 = lll1ii3.f4594I1I;
                            if (lll1ii3 == lll1ii2) {
                                lll1ii3 = null;
                            }
                        } else {
                            i2 = i14;
                        }
                    } else {
                        i12++;
                    }
                }
                return i9;
            }
            int i17 = i12 + (i11 * (-1));
            while (true) {
                int i18 = i6 + 1;
                int i19 = i12 + 1;
                if ((bArr[i6] & StatementImpl.USES_VARIABLES_UNKNOWN) != iArr[i12]) {
                    return i9;
                }
                boolean z2 = i19 == i17;
                if (i18 == i7) {
                    llL1ii lll1ii4 = lll1ii3.f2068lLi1LL;
                    i4 = lll1ii4.f4596ILil;
                    byte[] bArr2 = lll1ii4.f4595IL1Iii;
                    i3 = lll1ii4.f4594I1I;
                    if (lll1ii4 != lll1ii2) {
                        lll1ii = lll1ii4;
                        bArr = bArr2;
                    } else {
                        if (!z2) {
                            break loop0;
                        }
                        bArr = bArr2;
                        lll1ii = null;
                    }
                } else {
                    llL1ii lll1ii5 = lll1ii3;
                    i3 = i7;
                    i4 = i18;
                    lll1ii = lll1ii5;
                }
                if (z2) {
                    i = iArr[i19];
                    i2 = i4;
                    i7 = i3;
                    lll1ii3 = lll1ii;
                    break;
                }
                i6 = i4;
                i7 = i3;
                i12 = i19;
                lll1ii3 = lll1ii;
            }
            if (i >= 0) {
                return i;
            }
            i8 = -i;
            i6 = i2;
            i5 = -2;
        }
        return z ? i5 : i9;
    }

    @Override // p066Ilil.IL
    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public /* bridge */ /* synthetic */ IL mo2782Ll1(int i) throws IOException {
        l1Lll(i);
        return this;
    }

    @Override // p066Ilil.IL
    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public OutputStream mo2783L1l() {
        return new IL1Iii();
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public byte[] mo2784L11I() {
        try {
            return mo28101(this.f4559I1I);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public String mo2785LlLLL() {
        try {
            return m2791ili11(this.f4559I1I, I11L.f4558IL1Iii);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // p066Ilil.I11li1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof I1I)) {
            return false;
        }
        I1I i1i = (I1I) obj;
        long j = this.f4559I1I;
        if (j != i1i.f4559I1I) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        llL1ii lll1ii = this.f4560ILil;
        llL1ii lll1ii2 = i1i.f4560ILil;
        int i = lll1ii.f4596ILil;
        int i2 = lll1ii2.f4596ILil;
        while (j2 < this.f4559I1I) {
            long jMin = Math.min(lll1ii.f4594I1I - i, lll1ii2.f4594I1I - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (lll1ii.f4595IL1Iii[i] != lll1ii2.f4595IL1Iii[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == lll1ii.f4594I1I) {
                lll1ii = lll1ii.f2068lLi1LL;
                i = lll1ii.f4596ILil;
            }
            if (i2 == lll1ii2.f4594I1I) {
                lll1ii2 = lll1ii2.f2068lLi1LL;
                i2 = lll1ii2.f4596ILil;
            }
            j2 += jMin;
        }
        return true;
    }

    @Override // p066Ilil.IL, p066Ilil.iIlLiL, java.io.Flushable
    public void flush() {
    }

    public int hashCode() {
        llL1ii lll1ii = this.f4560ILil;
        if (lll1ii == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = lll1ii.f4594I1I;
            for (int i3 = lll1ii.f4596ILil; i3 < i2; i3++) {
                i = (i * 31) + lll1ii.f4595IL1Iii[i3];
            }
            lll1ii = lll1ii.f2068lLi1LL;
        } while (lll1ii != this.f4560ILil);
        return i;
    }

    /* JADX INFO: renamed from: i1 */
    public iILLL1 m98i1() {
        return new iILLL1(mo2784L11I());
    }

    /* JADX INFO: renamed from: iI */
    public String m99iI(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (LLL(j2) == 13) {
                String strM2778LIl = m2778LIl(j2);
                I11L(2L);
                return strM2778LIl;
            }
        }
        String strM2778LIl2 = m2778LIl(j);
        I11L(1L);
        return strM2778LIl2;
    }

    /* JADX INFO: renamed from: iI1i丨I, reason: contains not printable characters */
    public long m2786iI1iI(byte b, long j, long j2) {
        llL1ii lll1ii;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f4559I1I), Long.valueOf(j), Long.valueOf(j2)));
        }
        long j4 = this.f4559I1I;
        long j5 = j2 > j4 ? j4 : j2;
        if (j == j5 || (lll1ii = this.f4560ILil) == null) {
            return -1L;
        }
        if (j4 - j < j) {
            while (j4 > j) {
                lll1ii = lll1ii.f2067iILLL1;
                j4 -= (long) (lll1ii.f4594I1I - lll1ii.f4596ILil);
            }
        } else {
            while (true) {
                long j6 = ((long) (lll1ii.f4594I1I - lll1ii.f4596ILil)) + j3;
                if (j6 >= j) {
                    break;
                }
                lll1ii = lll1ii.f2068lLi1LL;
                j3 = j6;
            }
            j4 = j3;
        }
        long j7 = j;
        while (j4 < j5) {
            byte[] bArr = lll1ii.f4595IL1Iii;
            int iMin = (int) Math.min(lll1ii.f4594I1I, (((long) lll1ii.f4596ILil) + j5) - j4);
            for (int i = (int) ((((long) lll1ii.f4596ILil) + j7) - j4); i < iMin; i++) {
                if (bArr[i] == b) {
                    return ((long) (i - lll1ii.f4596ILil)) + j4;
                }
            }
            j4 += (long) (lll1ii.f4594I1I - lll1ii.f4596ILil);
            lll1ii = lll1ii.f2068lLi1LL;
            j7 = j4;
        }
        return -1L;
    }

    @Override // p066Ilil.IL
    public /* bridge */ /* synthetic */ IL iIi1(byte[] bArr, int i, int i2) throws IOException {
        m100lL(bArr, i, i2);
        return this;
    }

    public final C0590I1I iIilII1(C0590I1I c0590i1i) {
        if (c0590i1i.f4562ILil != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        c0590i1i.f4562ILil = this;
        c0590i1i.f4561I1I = true;
        return c0590i1i;
    }

    /* JADX INFO: renamed from: iIl1il丨, reason: contains not printable characters */
    public I1I m2787iIl1il(int i) {
        llL1ii lll1iiM95I1 = m95I1(2);
        byte[] bArr = lll1iiM95I1.f4595IL1Iii;
        int i2 = lll1iiM95I1.f4594I1I;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        lll1iiM95I1.f4594I1I = i3 + 1;
        this.f4559I1I += 2;
        return this;
    }

    @Override // p066Ilil.lLi1LL
    public void iIlLiL(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int iM2802li11 = m2802li11(bArr, i, bArr.length - i);
            if (iM2802li11 == -1) {
                throw new EOFException();
            }
            i += iM2802li11;
        }
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public long mo2788iILLL1() {
        long j = this.f4559I1I;
        if (j < 8) {
            throw new IllegalStateException("size < 8: " + this.f4559I1I);
        }
        llL1ii lll1ii = this.f4560ILil;
        int i = lll1ii.f4596ILil;
        int i2 = lll1ii.f4594I1I;
        if (i2 - i < 8) {
            return ((((long) Ilil()) & MysqlDefs.LENGTH_LONGBLOB) << 32) | (MysqlDefs.LENGTH_LONGBLOB & ((long) Ilil()));
        }
        byte[] bArr = lll1ii.f4595IL1Iii;
        int i3 = i + 1;
        long j2 = (((long) bArr[i]) & 255) << 56;
        int i4 = i3 + 1;
        long j3 = ((((long) bArr[i3]) & 255) << 48) | j2;
        int i5 = i4 + 1;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 40);
        int i6 = i5 + 1;
        int i7 = i6 + 1;
        long j5 = j4 | ((((long) bArr[i5]) & 255) << 32) | ((((long) bArr[i6]) & 255) << 24);
        int i8 = i7 + 1;
        long j6 = j5 | ((((long) bArr[i7]) & 255) << 16);
        int i9 = i8 + 1;
        long j7 = j6 | ((((long) bArr[i8]) & 255) << 8);
        int i10 = i9 + 1;
        long j8 = j7 | (((long) bArr[i9]) & 255);
        this.f4559I1I = j - 8;
        if (i10 == i2) {
            this.f4560ILil = lll1ii.ILil();
            lIlii.IL1Iii(lll1ii);
        } else {
            lll1ii.f4596ILil = i10;
        }
        return j8;
    }

    /* JADX INFO: renamed from: iI丨Li丨lI, reason: contains not printable characters */
    public final iILLL1 m2789iILilI(int i) {
        return i == 0 ? iILLL1.EMPTY : new iIi1(this, i);
    }

    /* JADX INFO: renamed from: iiIIi丨11, reason: contains not printable characters */
    public final iILLL1 m2790iiIIi11() {
        long j = this.f4559I1I;
        if (j <= 2147483647L) {
            return m2789iILilI((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f4559I1I);
    }

    /* JADX INFO: renamed from: ili丨11, reason: contains not printable characters */
    public String m2791ili11(long j, Charset charset) throws EOFException {
        I11L.ILil(this.f4559I1I, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return BuildConfig.FLAVOR;
        }
        llL1ii lll1ii = this.f4560ILil;
        if (((long) lll1ii.f4596ILil) + j > lll1ii.f4594I1I) {
            return new String(mo28101(j), charset);
        }
        String str = new String(lll1ii.f4595IL1Iii, lll1ii.f4596ILil, (int) j, charset);
        int i = (int) (((long) lll1ii.f4596ILil) + j);
        lll1ii.f4596ILil = i;
        this.f4559I1I -= j;
        if (i == lll1ii.f4594I1I) {
            this.f4560ILil = lll1ii.ILil();
            lIlii.IL1Iii(lll1ii);
        }
        return str;
    }

    public I1I ill1LI1l(long j) {
        if (j == 0) {
            l1Lll(48);
            return this;
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        llL1ii lll1iiM95I1 = m95I1(iNumberOfTrailingZeros);
        byte[] bArr = lll1iiM95I1.f4595IL1Iii;
        int i = lll1iiM95I1.f4594I1I;
        for (int i2 = (i + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f2056IL[(int) (15 & j)];
            j >>>= 4;
        }
        lll1iiM95I1.f4594I1I += iNumberOfTrailingZeros;
        this.f4559I1I += (long) iNumberOfTrailingZeros;
        return this;
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public int mo2792ill(C0652ILl c0652ILl) {
        int iM2781LlLiLL = m2781LlLiLL(c0652ILl, false);
        if (iM2781LlLiLL == -1) {
            return -1;
        }
        try {
            I11L(c0652ILl.f4576ILil[iM2781LlLiLL].size());
            return iM2781LlLiLL;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    /* JADX INFO: renamed from: i丨1I1I1l, reason: contains not printable characters */
    public I1I m2793i1I1I1l(int i) {
        if (i < 128) {
            l1Lll(i);
        } else if (i < 2048) {
            l1Lll((i >> 6) | 192);
            l1Lll((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                l1Lll((i >> 12) | TbsListener.ErrorCode.EXCEED_INCR_UPDATE);
                l1Lll(((i >> 6) & 63) | 128);
                l1Lll((i & 63) | 128);
            } else {
                l1Lll(63);
            }
        } else {
            if (i > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            }
            l1Lll((i >> 18) | TbsListener.ErrorCode.TPATCH_VERSION_FAILED);
            l1Lll(((i >> 12) & 63) | 128);
            l1Lll(((i >> 6) & 63) | 128);
            l1Lll((i & 63) | 128);
        }
        return this;
    }

    @Override // p066Ilil.IL
    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public /* bridge */ /* synthetic */ IL mo2794l1IIi1(long j) throws IOException {
        I1IILIIL(j);
        return this;
    }

    public I1I l1Lll(int i) {
        llL1ii lll1iiM95I1 = m95I1(1);
        byte[] bArr = lll1iiM95I1.f4595IL1Iii;
        int i2 = lll1iiM95I1.f4594I1I;
        lll1iiM95I1.f4594I1I = i2 + 1;
        bArr[i2] = (byte) i;
        this.f4559I1I++;
        return this;
    }

    /* JADX INFO: renamed from: lIIiIlL丨, reason: contains not printable characters */
    public I1I m2795lIIiIlL(int i) {
        llL1ii lll1iiM95I1 = m95I1(4);
        byte[] bArr = lll1iiM95I1.f4595IL1Iii;
        int i2 = lll1iiM95I1.f4594I1I;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        lll1iiM95I1.f4594I1I = i5 + 1;
        this.f4559I1I += 4;
        return this;
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public void mo2796lIiI(I1I i1i, long j) throws EOFException {
        long j2 = this.f4559I1I;
        if (j2 >= j) {
            i1i.write(this, j);
        } else {
            i1i.write(this, j2);
            throw new EOFException();
        }
    }

    @Override // p066Ilil.IL
    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public /* bridge */ /* synthetic */ IL mo2797lIII(byte[] bArr) throws IOException {
        L1iI1(bArr);
        return this;
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public byte mo2798lIlii() {
        long j = this.f4559I1I;
        if (j == 0) {
            throw new IllegalStateException("size == 0");
        }
        llL1ii lll1ii = this.f4560ILil;
        int i = lll1ii.f4596ILil;
        int i2 = lll1ii.f4594I1I;
        int i3 = i + 1;
        byte b = lll1ii.f4595IL1Iii[i];
        this.f4559I1I = j - 1;
        if (i3 == i2) {
            this.f4560ILil = lll1ii.ILil();
            lIlii.IL1Iii(lll1ii);
        } else {
            lll1ii.f4596ILil = i3;
        }
        return b;
    }

    /* JADX INFO: renamed from: lL */
    public I1I m100lL(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        I11L.ILil(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            llL1ii lll1iiM95I1 = m95I1(1);
            int iMin = Math.min(i3 - i, 8192 - lll1iiM95I1.f4594I1I);
            System.arraycopy(bArr, i, lll1iiM95I1.f4595IL1Iii, lll1iiM95I1.f4594I1I, iMin);
            i += iMin;
            lll1iiM95I1.f4594I1I += iMin;
        }
        this.f4559I1I += j;
        return this;
    }

    @Override // p066Ilil.lLi1LL
    public void llI(long j) throws EOFException {
        if (this.f4559I1I < j) {
            throw new EOFException();
        }
    }

    @Override // p066Ilil.lLi1LL
    public String llliI() throws EOFException {
        return Lil(RecyclerView.FOREVER_NS);
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public String mo2799llL1ii(Charset charset) {
        try {
            return m2791ili11(this.f4559I1I, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // p066Ilil.IL
    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public /* bridge */ /* synthetic */ IL mo2800lLi1LL(int i) throws IOException {
        m2795lIIiIlL(i);
        return this;
    }

    /* JADX INFO: renamed from: l丨liiI1, reason: contains not printable characters */
    public I1I m2801lliiI1() {
        return this;
    }

    /* JADX INFO: renamed from: l丨丨i11, reason: contains not printable characters */
    public int m2802li11(byte[] bArr, int i, int i2) {
        I11L.ILil(bArr.length, i, i2);
        llL1ii lll1ii = this.f4560ILil;
        if (lll1ii == null) {
            return -1;
        }
        int iMin = Math.min(i2, lll1ii.f4594I1I - lll1ii.f4596ILil);
        System.arraycopy(lll1ii.f4595IL1Iii, lll1ii.f4596ILil, bArr, i, iMin);
        int i3 = lll1ii.f4596ILil + iMin;
        lll1ii.f4596ILil = i3;
        this.f4559I1I -= (long) iMin;
        if (i3 == lll1ii.f4594I1I) {
            this.f4560ILil = lll1ii.ILil();
            lIlii.IL1Iii(lll1ii);
        }
        return iMin;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        llL1ii lll1ii = this.f4560ILil;
        if (lll1ii == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), lll1ii.f4594I1I - lll1ii.f4596ILil);
        byteBuffer.put(lll1ii.f4595IL1Iii, lll1ii.f4596ILil, iMin);
        int i = lll1ii.f4596ILil + iMin;
        lll1ii.f4596ILil = i;
        this.f4559I1I -= (long) iMin;
        if (i == lll1ii.f4594I1I) {
            this.f4560ILil = lll1ii.ILil();
            lIlii.IL1Iii(lll1ii);
        }
        return iMin;
    }

    @Override // p066Ilil.I11li1, p066Ilil.iIlLiL
    public lL timeout() {
        return lL.NONE;
    }

    public String toString() {
        return m2790iiIIi11().toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            llL1ii lll1iiM95I1 = m95I1(1);
            int iMin = Math.min(i, 8192 - lll1iiM95I1.f4594I1I);
            byteBuffer.get(lll1iiM95I1.f4595IL1Iii, lll1iiM95I1.f4594I1I, iMin);
            i -= iMin;
            lll1iiM95I1.f4594I1I += iMin;
        }
        this.f4559I1I += (long) iRemaining;
        return iRemaining;
    }

    /* JADX INFO: renamed from: 丨i1丨1i, reason: contains not printable characters */
    public I1I m2803i11i(iILLL1 iilll1) {
        if (iilll1 == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        iilll1.write(this);
        return this;
    }

    /* JADX INFO: renamed from: 丨i1丨1丨LL, reason: contains not printable characters */
    public I1I m2804i11LL(long j) {
        llL1ii lll1iiM95I1 = m95I1(8);
        byte[] bArr = lll1iiM95I1.f4595IL1Iii;
        int i = lll1iiM95I1.f4594I1I;
        int i2 = i + 1;
        bArr[i] = (byte) ((j >>> 56) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 48) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 40) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j >>> 32) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j >>> 8) & 255);
        bArr[i8] = (byte) (j & 255);
        lll1iiM95I1.f4594I1I = i8 + 1;
        this.f4559I1I += 8;
        return this;
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public long mo2805iILLl(byte b) {
        return m2786iI1iI(b, 0L, RecyclerView.FOREVER_NS);
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public I1I mo2806il() {
        return this;
    }

    @Override // p066Ilil.IL
    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public /* bridge */ /* synthetic */ IL mo2807lL(long j) throws IOException {
        ill1LI1l(j);
        return this;
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public int mo2808l() {
        return I11L.I1I(Ilil());
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: 丨丨 */
    public short mo101() {
        long j = this.f4559I1I;
        if (j < 2) {
            throw new IllegalStateException("size < 2: " + this.f4559I1I);
        }
        llL1ii lll1ii = this.f4560ILil;
        int i = lll1ii.f4596ILil;
        int i2 = lll1ii.f4594I1I;
        if (i2 - i < 2) {
            return (short) (((mo2798lIlii() & StatementImpl.USES_VARIABLES_UNKNOWN) << 8) | (mo2798lIlii() & StatementImpl.USES_VARIABLES_UNKNOWN));
        }
        byte[] bArr = lll1ii.f4595IL1Iii;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & StatementImpl.USES_VARIABLES_UNKNOWN) << 8) | (bArr[i3] & StatementImpl.USES_VARIABLES_UNKNOWN);
        this.f4559I1I = j - 2;
        if (i4 == i2) {
            this.f4560ILil = lll1ii.ILil();
            lIlii.IL1Iii(lll1ii);
        } else {
            lll1ii.f4596ILil = i4;
        }
        return (short) i5;
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public long mo2809LLlI1(iIlLiL iillil) throws IOException {
        long j = this.f4559I1I;
        if (j > 0) {
            iillil.write(this, j);
        }
        return j;
    }

    @Override // p066Ilil.lLi1LL
    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public byte[] mo28101(long j) throws EOFException {
        I11L.ILil(this.f4559I1I, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            iIlLiL(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public final void m2811() {
        try {
            I11L(this.f4559I1I);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // p066Ilil.iIlLiL
    public void write(I1I i1i, long j) {
        if (i1i == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (i1i != this) {
            I11L.ILil(i1i.f4559I1I, 0L, j);
            while (j > 0) {
                llL1ii lll1ii = i1i.f4560ILil;
                if (j < lll1ii.f4594I1I - lll1ii.f4596ILil) {
                    llL1ii lll1ii2 = this.f4560ILil;
                    llL1ii lll1ii3 = lll1ii2 != null ? lll1ii2.f2067iILLL1 : null;
                    if (lll1ii3 != null && lll1ii3.f4597Ilil) {
                        if ((((long) lll1ii3.f4594I1I) + j) - ((long) (lll1ii3.f2066IL ? 0 : lll1ii3.f4596ILil)) <= 8192) {
                            lll1ii.m2835iILLL1(lll1ii3, (int) j);
                            i1i.f4559I1I -= j;
                            this.f4559I1I += j;
                            return;
                        }
                    }
                    i1i.f4560ILil = lll1ii.Ilil((int) j);
                }
                llL1ii lll1ii4 = i1i.f4560ILil;
                long j2 = lll1ii4.f4594I1I - lll1ii4.f4596ILil;
                i1i.f4560ILil = lll1ii4.ILil();
                llL1ii lll1ii5 = this.f4560ILil;
                if (lll1ii5 == null) {
                    this.f4560ILil = lll1ii4;
                    lll1ii4.f2067iILLL1 = lll1ii4;
                    lll1ii4.f2068lLi1LL = lll1ii4;
                } else {
                    lll1ii5.f2067iILLL1.I1I(lll1ii4);
                    lll1ii4.IL1Iii();
                }
                i1i.f4559I1I -= j2;
                this.f4559I1I += j2;
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    @Override // p066Ilil.I11li1
    public long read(I1I i1i, long j) {
        if (i1i == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j >= 0) {
            long j2 = this.f4559I1I;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            i1i.write(this, j);
            return j;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }
}
