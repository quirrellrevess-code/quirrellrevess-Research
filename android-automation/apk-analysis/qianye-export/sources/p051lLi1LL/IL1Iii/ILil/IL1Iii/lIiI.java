package p051lLi1LL.IL1Iii.ILil.IL1Iii;

/* JADX INFO: renamed from: l丨Li1LL.IL1Iii.ILil.IL1Iii.lIi丨I, reason: invalid class name */
/* JADX INFO: compiled from: UnparseableExtraFieldData.java */
/* JADX INFO: loaded from: classes.dex */
public final class lIiI implements I1I {

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static final l f3023IL = new l(44225);

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public byte[] f5515I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public byte[] f5516ILil;

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    public void I1I(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.f5516ILil = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    public l IL1Iii() {
        return f3023IL;
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    public l ILil() {
        byte[] bArr = this.f5516ILil;
        return new l(bArr == null ? 0 : bArr.length);
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    public byte[] Ilil() {
        byte[] bArr = this.f5515I1I;
        return bArr == null ? mo3608IL() : C1.ILil(bArr);
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    /* JADX INFO: renamed from: I丨L */
    public byte[] mo3608IL() {
        return C1.ILil(this.f5516ILil);
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I1I
    /* JADX INFO: renamed from: iI丨LLL1 */
    public void mo3610iILLL1(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.f5515I1I = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        if (this.f5516ILil == null) {
            I1I(bArr, i, i2);
        }
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    /* JADX INFO: renamed from: l丨Li1LL */
    public l mo3609lLi1LL() {
        byte[] bArr = this.f5515I1I;
        return bArr == null ? ILil() : new l(bArr.length);
    }
}
