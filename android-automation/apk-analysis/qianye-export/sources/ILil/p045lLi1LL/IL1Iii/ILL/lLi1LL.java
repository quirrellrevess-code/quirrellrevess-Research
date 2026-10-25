package ILil.p045lLi1LL.IL1Iii.ILL;

import ILil.p045lLi1LL.IL1Iii.C0651il;

/* JADX INFO: renamed from: ILil.l丨Li1LL.IL1Iii.ILL.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: ConstraintAnchor.java */
/* JADX INFO: loaded from: classes.dex */
public class lLi1LL {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final IL f4514I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final iILLL1 f4516ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public lLi1LL f1959IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public int f1960IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public C0651il f1961L11I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public lIiI f4515IL1Iii = new lIiI(this);

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public int f4517Ilil = 0;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int f1963lLi1LL = -1;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public I1I f1962iILLL1 = I1I.NONE;

    /* JADX INFO: renamed from: ILil.l丨Li1LL.IL1Iii.ILL.l丨Li1LL$I1I */
    /* JADX INFO: compiled from: ConstraintAnchor.java */
    public enum I1I {
        NONE,
        STRONG,
        WEAK
    }

    /* JADX INFO: renamed from: ILil.l丨Li1LL.IL1Iii.ILL.l丨Li1LL$IL1Iii */
    /* JADX INFO: compiled from: ConstraintAnchor.java */
    public static /* synthetic */ class IL1Iii {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public static final /* synthetic */ int[] f4519IL1Iii;

        static {
            int[] iArr = new int[IL.values().length];
            f4519IL1Iii = iArr;
            try {
                iArr[IL.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4519IL1Iii[IL.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4519IL1Iii[IL.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4519IL1Iii[IL.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4519IL1Iii[IL.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4519IL1Iii[IL.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4519IL1Iii[IL.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4519IL1Iii[IL.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4519IL1Iii[IL.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX INFO: renamed from: ILil.l丨Li1LL.IL1Iii.ILL.l丨Li1LL$ILil */
    /* JADX INFO: compiled from: ConstraintAnchor.java */
    public enum ILil {
        RELAXED,
        STRICT
    }

    /* JADX INFO: renamed from: ILil.l丨Li1LL.IL1Iii.ILL.l丨Li1LL$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: ConstraintAnchor.java */
    public enum IL {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public lLi1LL(iILLL1 iilll1, IL il) {
        ILil iLil = ILil.RELAXED;
        this.f1960IiL = 0;
        this.f4516ILil = iilll1;
        this.f4514I1I = il;
    }

    public int I1I() {
        return this.f1960IiL;
    }

    public boolean IL1Iii(lLi1LL lli1ll, int i, int i2, I1I i1i, int i3, boolean z) {
        if (lli1ll == null) {
            this.f1959IL = null;
            this.f4517Ilil = 0;
            this.f1963lLi1LL = -1;
            this.f1962iILLL1 = I1I.NONE;
            this.f1960IiL = 2;
            return true;
        }
        if (!z && !m2683Ll1(lli1ll)) {
            return false;
        }
        this.f1959IL = lli1ll;
        if (i > 0) {
            this.f4517Ilil = i;
        } else {
            this.f4517Ilil = 0;
        }
        this.f1963lLi1LL = i2;
        this.f1962iILLL1 = i1i;
        this.f1960IiL = i3;
        return true;
    }

    public boolean ILL() {
        return this.f1959IL != null;
    }

    public boolean ILil(lLi1LL lli1ll, int i, I1I i1i, int i2) {
        return IL1Iii(lli1ll, i, -1, i1i, i2, false);
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public void m2680ILl(ILil.p045lLi1LL.IL1Iii.I1I i1i) {
        C0651il c0651il = this.f1961L11I;
        if (c0651il == null) {
            this.f1961L11I = new C0651il(C0651il.IL1Iii.UNRESTRICTED, null);
        } else {
            c0651il.m2723IL();
        }
    }

    public iILLL1 Ilil() {
        return this.f4516ILil;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int m2681IL() {
        lLi1LL lli1ll;
        if (this.f4516ILil.LL1IL() == 8) {
            return 0;
        }
        return (this.f1963lLi1LL <= -1 || (lli1ll = this.f1959IL) == null || lli1ll.f4516ILil.LL1IL() != 8) ? this.f4517Ilil : this.f1963lLi1LL;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public I1I m2682IiL() {
        return this.f1962iILLL1;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public boolean m2683Ll1(lLi1LL lli1ll) {
        if (lli1ll == null) {
            return false;
        }
        IL ilM2688il = lli1ll.m2688il();
        IL il = this.f4514I1I;
        if (ilM2688il == il) {
            return il != IL.BASELINE || (lli1ll.Ilil().m2635L1l() && Ilil().m2635L1l());
        }
        switch (IL1Iii.f4519IL1Iii[il.ordinal()]) {
            case 1:
                return (ilM2688il == IL.BASELINE || ilM2688il == IL.CENTER_X || ilM2688il == IL.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z = ilM2688il == IL.LEFT || ilM2688il == IL.RIGHT;
                if (lli1ll.Ilil() instanceof C0650il) {
                    return z || ilM2688il == IL.CENTER_X;
                }
                return z;
            case 4:
            case 5:
                boolean z2 = ilM2688il == IL.TOP || ilM2688il == IL.BOTTOM;
                if (lli1ll.Ilil() instanceof C0650il) {
                    return z2 || ilM2688il == IL.CENTER_Y;
                }
                return z2;
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f4514I1I.name());
        }
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public lLi1LL m2684L11I() {
        return this.f1959IL;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public C0651il m2685iILLL1() {
        return this.f1961L11I;
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public void m2686lIiI() {
        this.f1959IL = null;
        this.f4517Ilil = 0;
        this.f1963lLi1LL = -1;
        this.f1962iILLL1 = I1I.STRONG;
        this.f1960IiL = 0;
        ILil iLil = ILil.RELAXED;
        this.f4515IL1Iii.Ilil();
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public lIiI m2687lLi1LL() {
        return this.f4515IL1Iii;
    }

    public String toString() {
        return this.f4516ILil.m2625ILl() + ":" + this.f4514I1I.toString();
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public IL m2688il() {
        return this.f4514I1I;
    }
}
