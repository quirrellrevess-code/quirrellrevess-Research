package p066Ilil;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: compiled from: SegmentedByteString.java */
/* JADX INFO: loaded from: classes.dex */
public final class iIi1 extends iILLL1 {
    public final transient int[] directory;
    public final transient byte[][] segments;

    public iIi1(I1I i1i, int i) {
        super(null);
        I11L.ILil(i1i.f4559I1I, 0L, i);
        llL1ii lll1ii = i1i.f4560ILil;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = lll1ii.f4594I1I;
            int i6 = lll1ii.f4596ILil;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            lll1ii = lll1ii.f2068lLi1LL;
        }
        this.segments = new byte[i4][];
        this.directory = new int[i4 * 2];
        llL1ii lll1ii2 = i1i.f4560ILil;
        int i7 = 0;
        while (i2 < i) {
            byte[][] bArr = this.segments;
            bArr[i7] = lll1ii2.f4595IL1Iii;
            int i8 = lll1ii2.f4594I1I;
            int i9 = lll1ii2.f4596ILil;
            i2 += i8 - i9;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.directory;
            iArr[i7] = i2;
            iArr[bArr.length + i7] = i9;
            lll1ii2.f2066IL = true;
            i7++;
            lll1ii2 = lll1ii2.f2068lLi1LL;
        }
    }

    private Object writeReplace() {
        return Ilil();
    }

    public final iILLL1 Ilil() {
        return new iILLL1(toByteArray());
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final int m2824IL(int i) {
        int iBinarySearch = Arrays.binarySearch(this.directory, 0, this.segments.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    @Override // p066Ilil.iILLL1
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // p066Ilil.iILLL1
    public String base64() {
        return Ilil().base64();
    }

    @Override // p066Ilil.iILLL1
    public String base64Url() {
        return Ilil().base64Url();
    }

    @Override // p066Ilil.iILLL1
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof iILLL1) {
            iILLL1 iilll1 = (iILLL1) obj;
            if (iilll1.size() == size() && rangeEquals(0, iilll1, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @Override // p066Ilil.iILLL1
    public byte getByte(int i) {
        I11L.ILil(this.directory[this.segments.length - 1], i, 1L);
        int iM2824IL = m2824IL(i);
        int i2 = iM2824IL == 0 ? 0 : this.directory[iM2824IL - 1];
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        return bArr[iM2824IL][(i - i2) + iArr[bArr.length + iM2824IL]];
    }

    @Override // p066Ilil.iILLL1
    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int length = this.segments.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.segments[i2];
            int[] iArr = this.directory;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.hashCode = i4;
        return i4;
    }

    @Override // p066Ilil.iILLL1
    public String hex() {
        return Ilil().hex();
    }

    @Override // p066Ilil.iILLL1
    public iILLL1 hmacSha1(iILLL1 iilll1) {
        return Ilil().hmacSha1(iilll1);
    }

    @Override // p066Ilil.iILLL1
    public iILLL1 hmacSha256(iILLL1 iilll1) {
        return Ilil().hmacSha256(iilll1);
    }

    @Override // p066Ilil.iILLL1
    public int indexOf(byte[] bArr, int i) {
        return Ilil().indexOf(bArr, i);
    }

    @Override // p066Ilil.iILLL1
    public byte[] internalArray() {
        return toByteArray();
    }

    @Override // p066Ilil.iILLL1
    public int lastIndexOf(byte[] bArr, int i) {
        return Ilil().lastIndexOf(bArr, i);
    }

    @Override // p066Ilil.iILLL1
    public iILLL1 md5() {
        return Ilil().md5();
    }

    @Override // p066Ilil.iILLL1
    public boolean rangeEquals(int i, iILLL1 iilll1, int i2, int i3) {
        if (i < 0 || i > size() - i3) {
            return false;
        }
        int iM2824IL = m2824IL(i);
        while (i3 > 0) {
            int i4 = iM2824IL == 0 ? 0 : this.directory[iM2824IL - 1];
            int iMin = Math.min(i3, ((this.directory[iM2824IL] - i4) + i4) - i);
            int[] iArr = this.directory;
            byte[][] bArr = this.segments;
            if (!iilll1.rangeEquals(i2, bArr[iM2824IL], (i - i4) + iArr[bArr.length + iM2824IL], iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iM2824IL++;
        }
        return true;
    }

    @Override // p066Ilil.iILLL1
    public iILLL1 sha1() {
        return Ilil().sha1();
    }

    @Override // p066Ilil.iILLL1
    public iILLL1 sha256() {
        return Ilil().sha256();
    }

    @Override // p066Ilil.iILLL1
    public int size() {
        return this.directory[this.segments.length - 1];
    }

    @Override // p066Ilil.iILLL1
    public String string(Charset charset) {
        return Ilil().string(charset);
    }

    @Override // p066Ilil.iILLL1
    public iILLL1 substring(int i) {
        return Ilil().substring(i);
    }

    @Override // p066Ilil.iILLL1
    public iILLL1 toAsciiLowercase() {
        return Ilil().toAsciiLowercase();
    }

    @Override // p066Ilil.iILLL1
    public iILLL1 toAsciiUppercase() {
        return Ilil().toAsciiUppercase();
    }

    @Override // p066Ilil.iILLL1
    public byte[] toByteArray() {
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.directory;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.segments[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // p066Ilil.iILLL1
    public String toString() {
        return Ilil().toString();
    }

    @Override // p066Ilil.iILLL1
    public String utf8() {
        return Ilil().utf8();
    }

    @Override // p066Ilil.iILLL1
    public void write(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        int length = this.segments.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.directory;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            outputStream.write(this.segments[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
    }

    @Override // p066Ilil.iILLL1
    public iILLL1 substring(int i, int i2) {
        return Ilil().substring(i, i2);
    }

    @Override // p066Ilil.iILLL1
    public void write(I1I i1i) {
        int length = this.segments.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.directory;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            llL1ii lll1ii = new llL1ii(this.segments[i], i3, (i3 + i4) - i2, true, false);
            llL1ii lll1ii2 = i1i.f4560ILil;
            if (lll1ii2 == null) {
                lll1ii.f2067iILLL1 = lll1ii;
                lll1ii.f2068lLi1LL = lll1ii;
                i1i.f4560ILil = lll1ii;
            } else {
                lll1ii2.f2067iILLL1.I1I(lll1ii);
            }
            i++;
            i2 = i4;
        }
        i1i.f4559I1I += (long) i2;
    }

    @Override // p066Ilil.iILLL1
    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > size() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iM2824IL = m2824IL(i);
        while (i3 > 0) {
            int i4 = iM2824IL == 0 ? 0 : this.directory[iM2824IL - 1];
            int iMin = Math.min(i3, ((this.directory[iM2824IL] - i4) + i4) - i);
            int[] iArr = this.directory;
            byte[][] bArr2 = this.segments;
            if (!I11L.IL1Iii(bArr2[iM2824IL], (i - i4) + iArr[bArr2.length + iM2824IL], bArr, i2, iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iM2824IL++;
        }
        return true;
    }
}
