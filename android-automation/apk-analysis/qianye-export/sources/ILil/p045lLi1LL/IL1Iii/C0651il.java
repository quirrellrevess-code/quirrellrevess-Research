package ILil.p045lLi1LL.IL1Iii;

import com.google.android.flexbox.BuildConfig;
import java.util.Arrays;

/* JADX INFO: renamed from: ILil.l丨Li1LL.IL1Iii.丨il, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: SolverVariable.java */
/* JADX INFO: loaded from: classes.dex */
public class C0651il {
    public static int ILL = 1;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public String f4538IL1Iii;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public float f4540Ilil;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public IL1Iii f1996iILLL1;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f4539ILil = -1;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f4537I1I = -1;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f1993IL = 0;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public float[] f1997lLi1LL = new float[7];

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public ILil[] f1994IiL = new ILil[8];

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public int f1995L11I = 0;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public int f1998il = 0;

    /* JADX INFO: renamed from: ILil.l丨Li1LL.IL1Iii.丨il$IL1Iii */
    /* JADX INFO: compiled from: SolverVariable.java */
    public enum IL1Iii {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public C0651il(IL1Iii iL1Iii, String str) {
        this.f1996iILLL1 = iL1Iii;
    }

    public static void ILil() {
        ILL++;
    }

    public final void I1I(ILil iLil) {
        int i = this.f1995L11I;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f1994IiL[i2] == iLil) {
                for (int i3 = 0; i3 < (i - i2) - 1; i3++) {
                    ILil[] iLilArr = this.f1994IiL;
                    int i4 = i2 + i3;
                    iLilArr[i4] = iLilArr[i4 + 1];
                }
                this.f1995L11I--;
                return;
            }
        }
    }

    public final void IL1Iii(ILil iLil) {
        int i = 0;
        while (true) {
            int i2 = this.f1995L11I;
            if (i >= i2) {
                ILil[] iLilArr = this.f1994IiL;
                if (i2 >= iLilArr.length) {
                    this.f1994IiL = (ILil[]) Arrays.copyOf(iLilArr, iLilArr.length * 2);
                }
                ILil[] iLilArr2 = this.f1994IiL;
                int i3 = this.f1995L11I;
                iLilArr2[i3] = iLil;
                this.f1995L11I = i3 + 1;
                return;
            }
            if (this.f1994IiL[i] == iLil) {
                return;
            } else {
                i++;
            }
        }
    }

    public void Ilil(IL1Iii iL1Iii, String str) {
        this.f1996iILLL1 = iL1Iii;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m2723IL() {
        this.f4538IL1Iii = null;
        this.f1996iILLL1 = IL1Iii.UNKNOWN;
        this.f1993IL = 0;
        this.f4539ILil = -1;
        this.f4537I1I = -1;
        this.f4540Ilil = 0.0f;
        this.f1995L11I = 0;
        this.f1998il = 0;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final void m2724lLi1LL(ILil iLil) {
        int i = this.f1995L11I;
        for (int i2 = 0; i2 < i; i2++) {
            ILil[] iLilArr = this.f1994IiL;
            iLilArr[i2].f1967IL.m2583ILl(iLilArr[i2], iLil, false);
        }
        this.f1995L11I = 0;
    }

    public String toString() {
        return BuildConfig.FLAVOR + this.f4538IL1Iii;
    }
}
