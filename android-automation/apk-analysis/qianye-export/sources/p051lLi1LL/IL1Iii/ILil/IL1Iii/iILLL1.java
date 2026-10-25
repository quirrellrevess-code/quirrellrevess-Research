package p051lLi1LL.IL1Iii.ILil.IL1Iii;

/* JADX INFO: renamed from: l丨Li1LL.IL1Iii.ILil.IL1Iii.iI丨LLL1, reason: invalid class name */
/* JADX INFO: compiled from: GeneralPurposeBit.java */
/* JADX INFO: loaded from: classes.dex */
public final class iILLL1 {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public boolean f5513IL1Iii = false;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public boolean f5514ILil = false;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public boolean f5512I1I = false;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean f3022IL = false;

    public static iILLL1 IL1Iii(byte[] bArr, int i) {
        int iIlil = l.Ilil(bArr, i);
        iILLL1 iilll1 = new iILLL1();
        iilll1.ILil((iIlil & 8) != 0);
        iilll1.Ilil((iIlil & 2048) != 0);
        iilll1.m3640IL((iIlil & 64) != 0);
        iilll1.I1I((iIlil & 1) != 0);
        return iilll1;
    }

    public void I1I(boolean z) {
        this.f5512I1I = z;
    }

    public void ILil(boolean z) {
        this.f5514ILil = z;
    }

    public void Ilil(boolean z) {
        this.f5513IL1Iii = z;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m3640IL(boolean z) {
        this.f3022IL = z;
        if (z) {
            I1I(true);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof iILLL1)) {
            return false;
        }
        iILLL1 iilll1 = (iILLL1) obj;
        return iilll1.f5512I1I == this.f5512I1I && iilll1.f3022IL == this.f3022IL && iilll1.f5513IL1Iii == this.f5513IL1Iii && iilll1.f5514ILil == this.f5514ILil;
    }

    public int hashCode() {
        return (((((((this.f5512I1I ? 1 : 0) * 17) + (this.f3022IL ? 1 : 0)) * 13) + (this.f5513IL1Iii ? 1 : 0)) * 7) + (this.f5514ILil ? 1 : 0)) * 3;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public boolean m3641iILLL1() {
        return this.f5513IL1Iii;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean m3642lLi1LL() {
        return this.f5512I1I;
    }
}
