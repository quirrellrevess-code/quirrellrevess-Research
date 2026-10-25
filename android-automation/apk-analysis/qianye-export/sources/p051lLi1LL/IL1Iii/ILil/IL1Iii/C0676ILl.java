package p051lLi1LL.IL1Iii.ILil.IL1Iii;

/* JADX INFO: renamed from: l丨Li1LL.IL1Iii.ILil.IL1Iii.IL丨丨l, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: UnrecognizedExtraField.java */
/* JADX INFO: loaded from: classes.dex */
public class C0676ILl implements I1I {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public byte[] f5490I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public l f5491ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public byte[] f3010IL;

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    public void I1I(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        m3622il(bArr2);
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    public l IL1Iii() {
        return this.f5491ILil;
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    public l ILil() {
        return new l(this.f5490I1I.length);
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    public byte[] Ilil() {
        byte[] bArr = this.f3010IL;
        return bArr != null ? C1.ILil(bArr) : mo3608IL();
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    /* JADX INFO: renamed from: I丨L */
    public byte[] mo3608IL() {
        return C1.ILil(this.f5490I1I);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m3620IiL(byte[] bArr) {
        this.f3010IL = C1.ILil(bArr);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public void m3621L11I(l lVar) {
        this.f5491ILil = lVar;
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I1I
    /* JADX INFO: renamed from: iI丨LLL1 */
    public void mo3610iILLL1(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        m3620IiL(bArr2);
        if (this.f5490I1I == null) {
            m3622il(bArr2);
        }
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    /* JADX INFO: renamed from: l丨Li1LL */
    public l mo3609lLi1LL() {
        byte[] bArr = this.f3010IL;
        return bArr != null ? new l(bArr.length) : ILil();
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void m3622il(byte[] bArr) {
        this.f5490I1I = C1.ILil(bArr);
    }
}
