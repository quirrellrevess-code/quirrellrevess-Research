package ILil.p028IiL.p031Ll1;

import java.util.Locale;

/* JADX INFO: renamed from: ILil.I丨iL.Ll丨1.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class lLi1LL {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final ILil.p028IiL.p031Ll1.IL f4163I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final ILil.p028IiL.p031Ll1.IL f4164IL1Iii = new C0571lLi1LL(null, false);

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final ILil.p028IiL.p031Ll1.IL f4165ILil = new C0571lLi1LL(null, true);

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static final ILil.p028IiL.p031Ll1.IL f1705IL;

    /* JADX INFO: renamed from: ILil.I丨iL.Ll丨1.l丨Li1LL$I1I */
    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    public interface I1I {
        int IL1Iii(CharSequence charSequence, int i, int i2);
    }

    /* JADX INFO: renamed from: ILil.I丨iL.Ll丨1.l丨Li1LL$IL1Iii */
    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    public static class IL1Iii implements I1I {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public static final IL1Iii f4166ILil = new IL1Iii(true);

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final boolean f4167IL1Iii;

        public IL1Iii(boolean z) {
            this.f4167IL1Iii = z;
        }

        @Override // ILil.p028IiL.p031Ll1.lLi1LL.I1I
        public int IL1Iii(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            boolean z = false;
            while (i < i3) {
                int iIL1Iii = lLi1LL.IL1Iii(Character.getDirectionality(charSequence.charAt(i)));
                if (iIL1Iii != 0) {
                    if (iIL1Iii != 1) {
                        continue;
                    } else if (!this.f4167IL1Iii) {
                        return 1;
                    }
                    i++;
                } else if (this.f4167IL1Iii) {
                    return 0;
                }
                z = true;
                i++;
            }
            if (z) {
                return this.f4167IL1Iii ? 1 : 0;
            }
            return 2;
        }
    }

    /* JADX INFO: renamed from: ILil.I丨iL.Ll丨1.l丨Li1LL$ILil */
    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    public static class ILil implements I1I {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public static final ILil f4168IL1Iii = new ILil();

        @Override // ILil.p028IiL.p031Ll1.lLi1LL.I1I
        public int IL1Iii(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int iILil = 2;
            while (i < i3 && iILil == 2) {
                iILil = lLi1LL.ILil(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return iILil;
        }
    }

    /* JADX INFO: renamed from: ILil.I丨iL.Ll丨1.l丨Li1LL$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    public static abstract class IL implements ILil.p028IiL.p031Ll1.IL {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final I1I f4169IL1Iii;

        public IL(I1I i1i) {
            this.f4169IL1Iii = i1i;
        }

        public final boolean I1I(CharSequence charSequence, int i, int i2) {
            int iIL1Iii = this.f4169IL1Iii.IL1Iii(charSequence, i, i2);
            if (iIL1Iii == 0) {
                return true;
            }
            if (iIL1Iii != 1) {
                return ILil();
            }
            return false;
        }

        @Override // ILil.p028IiL.p031Ll1.IL
        public boolean IL1Iii(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            }
            return this.f4169IL1Iii == null ? ILil() : I1I(charSequence, i, i2);
        }

        public abstract boolean ILil();
    }

    /* JADX INFO: renamed from: ILil.I丨iL.Ll丨1.l丨Li1LL$iI丨LLL1, reason: invalid class name */
    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    public static class iILLL1 extends IL {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public static final iILLL1 f4170ILil = new iILLL1();

        public iILLL1() {
            super(null);
        }

        @Override // ILil.p028IiL.p031Ll1.lLi1LL.IL
        public boolean ILil() {
            return ILil.p028IiL.p031Ll1.iILLL1.ILil(Locale.getDefault()) == 1;
        }
    }

    /* JADX INFO: renamed from: ILil.I丨iL.Ll丨1.l丨Li1LL$l丨Li1LL, reason: invalid class name and collision with other inner class name */
    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    public static class C0571lLi1LL extends IL {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final boolean f4171ILil;

        public C0571lLi1LL(I1I i1i, boolean z) {
            super(i1i);
            this.f4171ILil = z;
        }

        @Override // ILil.p028IiL.p031Ll1.lLi1LL.IL
        public boolean ILil() {
            return this.f4171ILil;
        }
    }

    static {
        ILil iLil = ILil.f4168IL1Iii;
        f4163I1I = new C0571lLi1LL(iLil, false);
        f1705IL = new C0571lLi1LL(iLil, true);
        IL1Iii iL1Iii = IL1Iii.f4166ILil;
        iILLL1 iilll1 = iILLL1.f4170ILil;
    }

    public static int IL1Iii(int i) {
        if (i != 0) {
            return (i == 1 || i == 2) ? 0 : 2;
        }
        return 1;
    }

    public static int ILil(int i) {
        if (i != 0) {
            if (i == 1 || i == 2) {
                return 0;
            }
            switch (i) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
