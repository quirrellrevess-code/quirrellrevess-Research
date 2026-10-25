package p051lLi1LL.IL1Iii.ILil.IL1Iii;

import java.util.zip.ZipException;

/* JADX INFO: compiled from: Zip64ExtendedInformationExtraField.java */
/* JADX INFO: loaded from: classes.dex */
public class LlLI1 implements I1I {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public llL1ii f5500I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public llL1ii f5501ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public I11L f5502Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public llL1ii f3014IL;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public byte[] f3015lLi1LL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static final l f3013iILLL1 = new l(1);

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static final byte[] f3012IiL = new byte[0];

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    public void I1I(byte[] bArr, int i, int i2) throws ZipException {
        if (i2 == 0) {
            return;
        }
        if (i2 < 16) {
            throw new ZipException("Zip64 extended information must contain both size values in the local file header.");
        }
        this.f5501ILil = new llL1ii(bArr, i);
        int i3 = i + 8;
        this.f5500I1I = new llL1ii(bArr, i3);
        int i4 = i3 + 8;
        int i5 = i2 - 16;
        if (i5 >= 8) {
            this.f3014IL = new llL1ii(bArr, i4);
            i4 += 8;
            i5 -= 8;
        }
        if (i5 >= 4) {
            this.f5502Ilil = new I11L(bArr, i4);
        }
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    public l IL1Iii() {
        return f3013iILLL1;
    }

    public llL1ii ILL() {
        return this.f5501ILil;
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    public l ILil() {
        return new l(this.f5501ILil != null ? 16 : 0);
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public void m3624ILl(llL1ii lll1ii) {
        this.f5501ILil = lll1ii;
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    public byte[] Ilil() {
        byte[] bArr = new byte[mo3609lLi1LL().I1I()];
        int iM3625IiL = m3625IiL(bArr);
        llL1ii lll1ii = this.f3014IL;
        if (lll1ii != null) {
            System.arraycopy(lll1ii.IL1Iii(), 0, bArr, iM3625IiL, 8);
            iM3625IiL += 8;
        }
        I11L i11l = this.f5502Ilil;
        if (i11l != null) {
            System.arraycopy(i11l.IL1Iii(), 0, bArr, iM3625IiL, 4);
        }
        return bArr;
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    /* JADX INFO: renamed from: I丨L */
    public byte[] mo3608IL() {
        llL1ii lll1ii = this.f5501ILil;
        if (lll1ii == null && this.f5500I1I == null) {
            return f3012IiL;
        }
        if (lll1ii == null || this.f5500I1I == null) {
            throw new IllegalArgumentException("Zip64 extended information must contain both size values in the local file header.");
        }
        byte[] bArr = new byte[16];
        m3625IiL(bArr);
        return bArr;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final int m3625IiL(byte[] bArr) {
        int i;
        llL1ii lll1ii = this.f5501ILil;
        if (lll1ii != null) {
            System.arraycopy(lll1ii.IL1Iii(), 0, bArr, 0, 8);
            i = 8;
        } else {
            i = 0;
        }
        llL1ii lll1ii2 = this.f5500I1I;
        if (lll1ii2 == null) {
            return i;
        }
        System.arraycopy(lll1ii2.IL1Iii(), 0, bArr, i, 8);
        return i + 8;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public void m3626Ll1(boolean z, boolean z2, boolean z3, boolean z4) throws ZipException {
        byte[] bArr = this.f3015lLi1LL;
        if (bArr != null) {
            int i = 0;
            int i2 = (z ? 8 : 0) + (z2 ? 8 : 0) + (z3 ? 8 : 0) + (z4 ? 4 : 0);
            if (bArr.length != i2) {
                throw new ZipException("central directory zip64 extended information extra field's length doesn't match central directory data.  Expected length " + i2 + " but is " + this.f3015lLi1LL.length);
            }
            if (z) {
                this.f5501ILil = new llL1ii(this.f3015lLi1LL, 0);
                i = 8;
            }
            if (z2) {
                this.f5500I1I = new llL1ii(this.f3015lLi1LL, i);
                i += 8;
            }
            if (z3) {
                this.f3014IL = new llL1ii(this.f3015lLi1LL, i);
                i += 8;
            }
            if (z4) {
                this.f5502Ilil = new I11L(this.f3015lLi1LL, i);
            }
        }
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public llL1ii m3627L11I() {
        return this.f5500I1I;
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I1I
    /* JADX INFO: renamed from: iI丨LLL1 */
    public void mo3610iILLL1(byte[] bArr, int i, int i2) throws ZipException {
        byte[] bArr2 = new byte[i2];
        this.f3015lLi1LL = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        if (i2 >= 28) {
            I1I(bArr, i, i2);
            return;
        }
        if (i2 != 24) {
            if (i2 % 8 == 4) {
                this.f5502Ilil = new I11L(bArr, (i + i2) - 4);
            }
        } else {
            this.f5501ILil = new llL1ii(bArr, i);
            int i3 = i + 8;
            this.f5500I1I = new llL1ii(bArr, i3);
            this.f3014IL = new llL1ii(bArr, i3 + 8);
        }
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public void m3628lIiI(llL1ii lll1ii) {
        this.f5500I1I = lll1ii;
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    /* JADX INFO: renamed from: l丨Li1LL */
    public l mo3609lLi1LL() {
        return new l((this.f5501ILil != null ? 8 : 0) + (this.f5500I1I != null ? 8 : 0) + (this.f3014IL == null ? 0 : 8) + (this.f5502Ilil != null ? 4 : 0));
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public llL1ii m3629il() {
        return this.f3014IL;
    }
}
