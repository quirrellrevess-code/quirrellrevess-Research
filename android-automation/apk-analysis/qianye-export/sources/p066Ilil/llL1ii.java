package p066Ilil;

import javax.annotation.Nullable;

/* JADX INFO: renamed from: Ilil.ll丨L1ii, reason: invalid class name */
/* JADX INFO: compiled from: Segment.java */
/* JADX INFO: loaded from: classes.dex */
public final class llL1ii {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f4594I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final byte[] f4595IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f4596ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public boolean f4597Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean f2066IL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public llL1ii f2067iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public llL1ii f2068lLi1LL;

    public llL1ii() {
        this.f4595IL1Iii = new byte[8192];
        this.f4597Ilil = true;
        this.f2066IL = false;
    }

    public final llL1ii I1I(llL1ii lll1ii) {
        lll1ii.f2067iILLL1 = this;
        lll1ii.f2068lLi1LL = this.f2068lLi1LL;
        this.f2068lLi1LL.f2067iILLL1 = lll1ii;
        this.f2068lLi1LL = lll1ii;
        return lll1ii;
    }

    public final void IL1Iii() {
        llL1ii lll1ii = this.f2067iILLL1;
        if (lll1ii == this) {
            throw new IllegalStateException();
        }
        if (lll1ii.f4597Ilil) {
            int i = this.f4594I1I - this.f4596ILil;
            if (i > (8192 - lll1ii.f4594I1I) + (lll1ii.f2066IL ? 0 : lll1ii.f4596ILil)) {
                return;
            }
            m2835iILLL1(lll1ii, i);
            ILil();
            lIlii.IL1Iii(this);
        }
    }

    @Nullable
    public final llL1ii ILil() {
        llL1ii lll1ii = this.f2068lLi1LL;
        llL1ii lll1ii2 = lll1ii != this ? lll1ii : null;
        llL1ii lll1ii3 = this.f2067iILLL1;
        lll1ii3.f2068lLi1LL = lll1ii;
        this.f2068lLi1LL.f2067iILLL1 = lll1ii3;
        this.f2068lLi1LL = null;
        this.f2067iILLL1 = null;
        return lll1ii2;
    }

    public final llL1ii Ilil(int i) {
        llL1ii lll1iiILil;
        if (i <= 0 || i > this.f4594I1I - this.f4596ILil) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            lll1iiILil = m2834IL();
        } else {
            lll1iiILil = lIlii.ILil();
            System.arraycopy(this.f4595IL1Iii, this.f4596ILil, lll1iiILil.f4595IL1Iii, 0, i);
        }
        lll1iiILil.f4594I1I = lll1iiILil.f4596ILil + i;
        this.f4596ILil += i;
        this.f2067iILLL1.I1I(lll1iiILil);
        return lll1iiILil;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final llL1ii m2834IL() {
        this.f2066IL = true;
        return new llL1ii(this.f4595IL1Iii, this.f4596ILil, this.f4594I1I, true, false);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final void m2835iILLL1(llL1ii lll1ii, int i) {
        if (!lll1ii.f4597Ilil) {
            throw new IllegalArgumentException();
        }
        int i2 = lll1ii.f4594I1I;
        if (i2 + i > 8192) {
            if (lll1ii.f2066IL) {
                throw new IllegalArgumentException();
            }
            int i3 = lll1ii.f4596ILil;
            if ((i2 + i) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = lll1ii.f4595IL1Iii;
            System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            lll1ii.f4594I1I -= lll1ii.f4596ILil;
            lll1ii.f4596ILil = 0;
        }
        System.arraycopy(this.f4595IL1Iii, this.f4596ILil, lll1ii.f4595IL1Iii, lll1ii.f4594I1I, i);
        lll1ii.f4594I1I += i;
        this.f4596ILil += i;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final llL1ii m2836lLi1LL() {
        return new llL1ii((byte[]) this.f4595IL1Iii.clone(), this.f4596ILil, this.f4594I1I, false, true);
    }

    public llL1ii(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f4595IL1Iii = bArr;
        this.f4596ILil = i;
        this.f4594I1I = i2;
        this.f2066IL = z;
        this.f4597Ilil = z2;
    }
}
