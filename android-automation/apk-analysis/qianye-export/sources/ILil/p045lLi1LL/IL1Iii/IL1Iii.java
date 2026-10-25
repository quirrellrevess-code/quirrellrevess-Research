package ILil.p045lLi1LL.IL1Iii;

import com.google.android.flexbox.BuildConfig;
import java.util.Arrays;

/* JADX INFO: compiled from: ArrayLinkedVariables.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final I1I f4481I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final ILil f4483ILil;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public int f4482IL1Iii = 0;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f1878IL = 8;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public C0651il f4484Ilil = null;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int[] f1882lLi1LL = new int[8];

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int[] f1881iILLL1 = new int[8];

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public float[] f1879IiL = new float[8];

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public int f1880L11I = -1;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public int f1883il = -1;
    public boolean ILL = false;

    public IL1Iii(ILil iLil, I1I i1i) {
        this.f4483ILil = iLil;
        this.f4481I1I = i1i;
    }

    public final void I1I() {
        int i = this.f1880L11I;
        for (int i2 = 0; i != -1 && i2 < this.f4482IL1Iii; i2++) {
            C0651il c0651il = this.f4481I1I.f4478I1I[this.f1882lLi1LL[i]];
            if (c0651il != null) {
                c0651il.I1I(this.f4483ILil);
            }
            i = this.f1881iILLL1[i];
        }
        this.f1880L11I = -1;
        this.f1883il = -1;
        this.ILL = false;
        this.f4482IL1Iii = 0;
    }

    public final void IL1Iii(C0651il c0651il, float f, boolean z) {
        if (f == 0.0f) {
            return;
        }
        int i = this.f1880L11I;
        if (i == -1) {
            this.f1880L11I = 0;
            this.f1879IiL[0] = f;
            this.f1882lLi1LL[0] = c0651il.f4539ILil;
            this.f1881iILLL1[0] = -1;
            c0651il.f1998il++;
            c0651il.IL1Iii(this.f4483ILil);
            this.f4482IL1Iii++;
            if (this.ILL) {
                return;
            }
            int i2 = this.f1883il + 1;
            this.f1883il = i2;
            int[] iArr = this.f1882lLi1LL;
            if (i2 >= iArr.length) {
                this.ILL = true;
                this.f1883il = iArr.length - 1;
                return;
            }
            return;
        }
        int i3 = -1;
        for (int i4 = 0; i != -1 && i4 < this.f4482IL1Iii; i4++) {
            int[] iArr2 = this.f1882lLi1LL;
            int i5 = iArr2[i];
            int i6 = c0651il.f4539ILil;
            if (i5 == i6) {
                float[] fArr = this.f1879IiL;
                fArr[i] = fArr[i] + f;
                if (fArr[i] == 0.0f) {
                    if (i == this.f1880L11I) {
                        this.f1880L11I = this.f1881iILLL1[i];
                    } else {
                        int[] iArr3 = this.f1881iILLL1;
                        iArr3[i3] = iArr3[i];
                    }
                    if (z) {
                        c0651il.I1I(this.f4483ILil);
                    }
                    if (this.ILL) {
                        this.f1883il = i;
                    }
                    c0651il.f1998il--;
                    this.f4482IL1Iii--;
                    return;
                }
                return;
            }
            if (iArr2[i] < i6) {
                i3 = i;
            }
            i = this.f1881iILLL1[i];
        }
        int length = this.f1883il;
        int i7 = length + 1;
        if (this.ILL) {
            int[] iArr4 = this.f1882lLi1LL;
            if (iArr4[length] != -1) {
                length = iArr4.length;
            }
        } else {
            length = i7;
        }
        int[] iArr5 = this.f1882lLi1LL;
        if (length >= iArr5.length && this.f4482IL1Iii < iArr5.length) {
            int i8 = 0;
            while (true) {
                int[] iArr6 = this.f1882lLi1LL;
                if (i8 >= iArr6.length) {
                    break;
                }
                if (iArr6[i8] == -1) {
                    length = i8;
                    break;
                }
                i8++;
            }
        }
        int[] iArr7 = this.f1882lLi1LL;
        if (length >= iArr7.length) {
            length = iArr7.length;
            int i9 = this.f1878IL * 2;
            this.f1878IL = i9;
            this.ILL = false;
            this.f1883il = length - 1;
            this.f1879IiL = Arrays.copyOf(this.f1879IiL, i9);
            this.f1882lLi1LL = Arrays.copyOf(this.f1882lLi1LL, this.f1878IL);
            this.f1881iILLL1 = Arrays.copyOf(this.f1881iILLL1, this.f1878IL);
        }
        this.f1882lLi1LL[length] = c0651il.f4539ILil;
        this.f1879IiL[length] = f;
        if (i3 != -1) {
            int[] iArr8 = this.f1881iILLL1;
            iArr8[length] = iArr8[i3];
            iArr8[i3] = length;
        } else {
            this.f1881iILLL1[length] = this.f1880L11I;
            this.f1880L11I = length;
        }
        c0651il.f1998il++;
        c0651il.IL1Iii(this.f4483ILil);
        this.f4482IL1Iii++;
        if (!this.ILL) {
            this.f1883il++;
        }
        int i10 = this.f1883il;
        int[] iArr9 = this.f1882lLi1LL;
        if (i10 >= iArr9.length) {
            this.ILL = true;
            this.f1883il = iArr9.length - 1;
        }
    }

    public final boolean ILL(C0651il c0651il, lLi1LL lli1ll) {
        return c0651il.f1998il <= 1;
    }

    public C0651il ILil(lLi1LL lli1ll) {
        int i = this.f1880L11I;
        C0651il c0651il = null;
        C0651il c0651il2 = null;
        boolean z = false;
        boolean z2 = false;
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i2 = 0; i != -1 && i2 < this.f4482IL1Iii; i2++) {
            float[] fArr = this.f1879IiL;
            float f3 = fArr[i];
            C0651il c0651il3 = this.f4481I1I.f4478I1I[this.f1882lLi1LL[i]];
            if (f3 < 0.0f) {
                if (f3 > -0.001f) {
                    fArr[i] = 0.0f;
                    c0651il3.I1I(this.f4483ILil);
                    f3 = 0.0f;
                }
            } else if (f3 < 0.001f) {
                fArr[i] = 0.0f;
                c0651il3.I1I(this.f4483ILil);
                f3 = 0.0f;
            }
            if (f3 != 0.0f) {
                if (c0651il3.f1996iILLL1 == C0651il.IL1Iii.UNRESTRICTED) {
                    if (c0651il2 == null || f > f3) {
                        boolean zILL = ILL(c0651il3, lli1ll);
                        z = zILL;
                        f = f3;
                        c0651il2 = c0651il3;
                    } else if (!z && ILL(c0651il3, lli1ll)) {
                        f = f3;
                        c0651il2 = c0651il3;
                        z = true;
                    }
                } else if (c0651il2 == null && f3 < 0.0f) {
                    if (c0651il == null || f2 > f3) {
                        boolean zILL2 = ILL(c0651il3, lli1ll);
                        z2 = zILL2;
                        f2 = f3;
                        c0651il = c0651il3;
                    } else if (!z2 && ILL(c0651il3, lli1ll)) {
                        f2 = f3;
                        c0651il = c0651il3;
                        z2 = true;
                    }
                }
            }
            i = this.f1881iILLL1[i];
        }
        return c0651il2 != null ? c0651il2 : c0651il;
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final void m2583ILl(ILil iLil, ILil iLil2, boolean z) {
        int i = this.f1880L11I;
        while (true) {
            for (int i2 = 0; i != -1 && i2 < this.f4482IL1Iii; i2++) {
                int i3 = this.f1882lLi1LL[i];
                C0651il c0651il = iLil2.f4524IL1Iii;
                if (i3 == c0651il.f4539ILil) {
                    float f = this.f1879IiL[i];
                    m2589lIiI(c0651il, z);
                    IL1Iii iL1Iii = iLil2.f1967IL;
                    int i4 = iL1Iii.f1880L11I;
                    for (int i5 = 0; i4 != -1 && i5 < iL1Iii.f4482IL1Iii; i5++) {
                        IL1Iii(this.f4481I1I.f4478I1I[iL1Iii.f1882lLi1LL[i4]], iL1Iii.f1879IiL[i4] * f, z);
                        i4 = iL1Iii.f1881iILLL1[i4];
                    }
                    iLil.f4525ILil += iLil2.f4525ILil * f;
                    if (z) {
                        iLil2.f4524IL1Iii.I1I(iLil);
                    }
                    i = this.f1880L11I;
                } else {
                    i = this.f1881iILLL1[i];
                }
            }
            return;
        }
    }

    public void Ilil(float f) {
        int i = this.f1880L11I;
        for (int i2 = 0; i != -1 && i2 < this.f4482IL1Iii; i2++) {
            float[] fArr = this.f1879IiL;
            fArr[i] = fArr[i] / f;
            i = this.f1881iILLL1[i];
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final boolean m2584IL(C0651il c0651il) {
        int i = this.f1880L11I;
        if (i == -1) {
            return false;
        }
        for (int i2 = 0; i != -1 && i2 < this.f4482IL1Iii; i2++) {
            if (this.f1882lLi1LL[i] == c0651il.f4539ILil) {
                return true;
            }
            i = this.f1881iILLL1[i];
        }
        return false;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final C0651il m2585IiL(int i) {
        int i2 = this.f1880L11I;
        for (int i3 = 0; i2 != -1 && i3 < this.f4482IL1Iii; i3++) {
            if (i3 == i) {
                return this.f4481I1I.f4478I1I[this.f1882lLi1LL[i2]];
            }
            i2 = this.f1881iILLL1[i2];
        }
        return null;
    }

    public void Lil(ILil iLil, ILil[] iLilArr) {
        int i = this.f1880L11I;
        while (true) {
            for (int i2 = 0; i != -1 && i2 < this.f4482IL1Iii; i2++) {
                C0651il c0651il = this.f4481I1I.f4478I1I[this.f1882lLi1LL[i]];
                if (c0651il.f4537I1I != -1) {
                    float f = this.f1879IiL[i];
                    m2589lIiI(c0651il, true);
                    ILil iLil2 = iLilArr[c0651il.f4537I1I];
                    if (!iLil2.f4526Ilil) {
                        IL1Iii iL1Iii = iLil2.f1967IL;
                        int i3 = iL1Iii.f1880L11I;
                        for (int i4 = 0; i3 != -1 && i4 < iL1Iii.f4482IL1Iii; i4++) {
                            IL1Iii(this.f4481I1I.f4478I1I[iL1Iii.f1882lLi1LL[i3]], iL1Iii.f1879IiL[i3] * f, true);
                            i3 = iL1Iii.f1881iILLL1[i3];
                        }
                    }
                    iLil.f4525ILil += iLil2.f4525ILil * f;
                    iLil2.f4524IL1Iii.I1I(iLil);
                    i = this.f1880L11I;
                } else {
                    i = this.f1881iILLL1[i];
                }
            }
            return;
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final void m2586Ll1(C0651il c0651il, float f) {
        if (f == 0.0f) {
            m2589lIiI(c0651il, true);
            return;
        }
        int i = this.f1880L11I;
        if (i == -1) {
            this.f1880L11I = 0;
            this.f1879IiL[0] = f;
            this.f1882lLi1LL[0] = c0651il.f4539ILil;
            this.f1881iILLL1[0] = -1;
            c0651il.f1998il++;
            c0651il.IL1Iii(this.f4483ILil);
            this.f4482IL1Iii++;
            if (this.ILL) {
                return;
            }
            int i2 = this.f1883il + 1;
            this.f1883il = i2;
            int[] iArr = this.f1882lLi1LL;
            if (i2 >= iArr.length) {
                this.ILL = true;
                this.f1883il = iArr.length - 1;
                return;
            }
            return;
        }
        int i3 = -1;
        for (int i4 = 0; i != -1 && i4 < this.f4482IL1Iii; i4++) {
            int[] iArr2 = this.f1882lLi1LL;
            int i5 = iArr2[i];
            int i6 = c0651il.f4539ILil;
            if (i5 == i6) {
                this.f1879IiL[i] = f;
                return;
            }
            if (iArr2[i] < i6) {
                i3 = i;
            }
            i = this.f1881iILLL1[i];
        }
        int length = this.f1883il;
        int i7 = length + 1;
        if (this.ILL) {
            int[] iArr3 = this.f1882lLi1LL;
            if (iArr3[length] != -1) {
                length = iArr3.length;
            }
        } else {
            length = i7;
        }
        int[] iArr4 = this.f1882lLi1LL;
        if (length >= iArr4.length && this.f4482IL1Iii < iArr4.length) {
            int i8 = 0;
            while (true) {
                int[] iArr5 = this.f1882lLi1LL;
                if (i8 >= iArr5.length) {
                    break;
                }
                if (iArr5[i8] == -1) {
                    length = i8;
                    break;
                }
                i8++;
            }
        }
        int[] iArr6 = this.f1882lLi1LL;
        if (length >= iArr6.length) {
            length = iArr6.length;
            int i9 = this.f1878IL * 2;
            this.f1878IL = i9;
            this.ILL = false;
            this.f1883il = length - 1;
            this.f1879IiL = Arrays.copyOf(this.f1879IiL, i9);
            this.f1882lLi1LL = Arrays.copyOf(this.f1882lLi1LL, this.f1878IL);
            this.f1881iILLL1 = Arrays.copyOf(this.f1881iILLL1, this.f1878IL);
        }
        this.f1882lLi1LL[length] = c0651il.f4539ILil;
        this.f1879IiL[length] = f;
        if (i3 != -1) {
            int[] iArr7 = this.f1881iILLL1;
            iArr7[length] = iArr7[i3];
            iArr7[i3] = length;
        } else {
            this.f1881iILLL1[length] = this.f1880L11I;
            this.f1880L11I = length;
        }
        c0651il.f1998il++;
        c0651il.IL1Iii(this.f4483ILil);
        int i10 = this.f4482IL1Iii + 1;
        this.f4482IL1Iii = i10;
        if (!this.ILL) {
            this.f1883il++;
        }
        int[] iArr8 = this.f1882lLi1LL;
        if (i10 >= iArr8.length) {
            this.ILL = true;
        }
        if (this.f1883il >= iArr8.length) {
            this.ILL = true;
            this.f1883il = iArr8.length - 1;
        }
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final float m2587L11I(int i) {
        int i2 = this.f1880L11I;
        for (int i3 = 0; i2 != -1 && i3 < this.f4482IL1Iii; i3++) {
            if (i3 == i) {
                return this.f1879IiL[i2];
            }
            i2 = this.f1881iILLL1[i2];
        }
        return 0.0f;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public C0651il m2588iILLL1(boolean[] zArr, C0651il c0651il) {
        C0651il.IL1Iii iL1Iii;
        int i = this.f1880L11I;
        C0651il c0651il2 = null;
        float f = 0.0f;
        for (int i2 = 0; i != -1 && i2 < this.f4482IL1Iii; i2++) {
            float[] fArr = this.f1879IiL;
            if (fArr[i] < 0.0f) {
                C0651il c0651il3 = this.f4481I1I.f4478I1I[this.f1882lLi1LL[i]];
                if ((zArr == null || !zArr[c0651il3.f4539ILil]) && c0651il3 != c0651il && ((iL1Iii = c0651il3.f1996iILLL1) == C0651il.IL1Iii.SLACK || iL1Iii == C0651il.IL1Iii.ERROR)) {
                    float f2 = fArr[i];
                    if (f2 < f) {
                        f = f2;
                        c0651il2 = c0651il3;
                    }
                }
            }
            i = this.f1881iILLL1[i];
        }
        return c0651il2;
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final float m2589lIiI(C0651il c0651il, boolean z) {
        if (this.f4484Ilil == c0651il) {
            this.f4484Ilil = null;
        }
        int i = this.f1880L11I;
        if (i == -1) {
            return 0.0f;
        }
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.f4482IL1Iii) {
            if (this.f1882lLi1LL[i] == c0651il.f4539ILil) {
                if (i == this.f1880L11I) {
                    this.f1880L11I = this.f1881iILLL1[i];
                } else {
                    int[] iArr = this.f1881iILLL1;
                    iArr[i3] = iArr[i];
                }
                if (z) {
                    c0651il.I1I(this.f4483ILil);
                }
                c0651il.f1998il--;
                this.f4482IL1Iii--;
                this.f1882lLi1LL[i] = -1;
                if (this.ILL) {
                    this.f1883il = i;
                }
                return this.f1879IiL[i];
            }
            i2++;
            i3 = i;
            i = this.f1881iILLL1[i];
        }
        return 0.0f;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final float m2590lLi1LL(C0651il c0651il) {
        int i = this.f1880L11I;
        for (int i2 = 0; i != -1 && i2 < this.f4482IL1Iii; i2++) {
            if (this.f1882lLi1LL[i] == c0651il.f4539ILil) {
                return this.f1879IiL[i];
            }
            i = this.f1881iILLL1[i];
        }
        return 0.0f;
    }

    public String toString() {
        int i = this.f1880L11I;
        String str = BuildConfig.FLAVOR;
        for (int i2 = 0; i != -1 && i2 < this.f4482IL1Iii; i2++) {
            str = ((str + " -> ") + this.f1879IiL[i] + " : ") + this.f4481I1I.f4478I1I[this.f1882lLi1LL[i]];
            i = this.f1881iILLL1[i];
        }
        return str;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void m2591il() {
        int i = this.f1880L11I;
        for (int i2 = 0; i != -1 && i2 < this.f4482IL1Iii; i2++) {
            float[] fArr = this.f1879IiL;
            fArr[i] = fArr[i] * (-1.0f);
            i = this.f1881iILLL1[i];
        }
    }
}
