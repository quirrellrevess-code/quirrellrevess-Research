package ILil.ILil.p023lIlii;

/* JADX INFO: renamed from: ILil.ILil.lI丨lii.丨l丨, reason: invalid class name */
/* JADX INFO: compiled from: RtlSpacingHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public int f3845IL1Iii = 0;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f3846ILil = 0;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f3844I1I = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f1427IL = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public int f3847Ilil = 0;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int f1430lLi1LL = 0;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public boolean f1429iILLL1 = false;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public boolean f1428IiL = false;

    public int I1I() {
        return this.f3846ILil;
    }

    public int IL1Iii() {
        return this.f1429iILLL1 ? this.f3845IL1Iii : this.f3846ILil;
    }

    public int ILil() {
        return this.f3845IL1Iii;
    }

    public void Ilil(int i, int i2) {
        this.f1428IiL = false;
        if (i != Integer.MIN_VALUE) {
            this.f3847Ilil = i;
            this.f3845IL1Iii = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1430lLi1LL = i2;
            this.f3846ILil = i2;
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int m1849IL() {
        return this.f1429iILLL1 ? this.f3846ILil : this.f3845IL1Iii;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m1850iILLL1(int i, int i2) {
        this.f3844I1I = i;
        this.f1427IL = i2;
        this.f1428IiL = true;
        if (this.f1429iILLL1) {
            if (i2 != Integer.MIN_VALUE) {
                this.f3845IL1Iii = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f3846ILil = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f3845IL1Iii = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f3846ILil = i2;
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void m1851lLi1LL(boolean z) {
        if (z == this.f1429iILLL1) {
            return;
        }
        this.f1429iILLL1 = z;
        if (!this.f1428IiL) {
            this.f3845IL1Iii = this.f3847Ilil;
            this.f3846ILil = this.f1430lLi1LL;
            return;
        }
        if (z) {
            int i = this.f1427IL;
            if (i == Integer.MIN_VALUE) {
                i = this.f3847Ilil;
            }
            this.f3845IL1Iii = i;
            int i2 = this.f3844I1I;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.f1430lLi1LL;
            }
            this.f3846ILil = i2;
            return;
        }
        int i3 = this.f3844I1I;
        if (i3 == Integer.MIN_VALUE) {
            i3 = this.f3847Ilil;
        }
        this.f3845IL1Iii = i3;
        int i4 = this.f1427IL;
        if (i4 == Integer.MIN_VALUE) {
            i4 = this.f1430lLi1LL;
        }
        this.f3846ILil = i4;
    }
}
