package p051lLi1LL.IL1Iii.ILil.IL1Iii;

import java.util.zip.ZipException;

/* JADX INFO: compiled from: AbstractUnicodeExtraField.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class IL1Iii implements I11li1 {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public byte[] f5484I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public long f5485ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public byte[] f3005IL;

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    public void I1I(byte[] bArr, int i, int i2) throws ZipException {
        if (i2 < 5) {
            throw new ZipException("UniCode path extra data must have at least 5 bytes.");
        }
        byte b = bArr[i];
        if (b != 1) {
            throw new ZipException("Unsupported version [" + ((int) b) + "] for UniCode path extra data.");
        }
        this.f5485ILil = I11L.Ilil(bArr, i + 1);
        int i3 = i2 - 5;
        byte[] bArr2 = new byte[i3];
        this.f5484I1I = bArr2;
        System.arraycopy(bArr, i + 5, bArr2, 0, i3);
        this.f3005IL = null;
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    public l ILil() {
        return mo3609lLi1LL();
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    public byte[] Ilil() {
        if (this.f3005IL == null) {
            m3611IiL();
        }
        byte[] bArr = this.f3005IL;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    /* JADX INFO: renamed from: I丨L */
    public byte[] mo3608IL() {
        return Ilil();
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final void m3611IiL() {
        byte[] bArr = this.f5484I1I;
        if (bArr == null) {
            return;
        }
        byte[] bArr2 = new byte[bArr.length + 5];
        this.f3005IL = bArr2;
        bArr2[0] = 1;
        System.arraycopy(I11L.ILil(this.f5485ILil), 0, this.f3005IL, 1, 4);
        byte[] bArr3 = this.f5484I1I;
        System.arraycopy(bArr3, 0, this.f3005IL, 5, bArr3.length);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public long m3612L11I() {
        return this.f5485ILil;
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    /* JADX INFO: renamed from: l丨Li1LL */
    public l mo3609lLi1LL() {
        if (this.f3005IL == null) {
            m3611IiL();
        }
        return new l(this.f3005IL.length);
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public byte[] m3613il() {
        byte[] bArr = this.f5484I1I;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }
}
