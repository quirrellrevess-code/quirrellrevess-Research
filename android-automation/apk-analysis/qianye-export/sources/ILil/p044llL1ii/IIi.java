package ILil.p044llL1ii;

import ILil.p028IiL.p029ILl.iIlLiL;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* JADX INFO: renamed from: ILil.ll丨L1ii.I丨Ii, reason: invalid class name */
/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class IIi {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final Property<View, Rect> f4412I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final IIiI f4413IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final Property<View, Float> f4414ILil;

    /* JADX INFO: renamed from: ILil.ll丨L1ii.I丨Ii$IL1Iii */
    /* JADX INFO: compiled from: ViewUtils.java */
    public static class IL1Iii extends Property<View, Float> {
        public IL1Iii(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(IIi.I1I(view));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f) {
            IIi.m2554IiL(view, f.floatValue());
        }
    }

    /* JADX INFO: renamed from: ILil.ll丨L1ii.I丨Ii$ILil */
    /* JADX INFO: compiled from: ViewUtils.java */
    public static class ILil extends Property<View, Rect> {
        public ILil(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public Rect get(View view) {
            return iIlLiL.m2123lIlii(view);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
        public void set(View view, Rect rect) {
            iIlLiL.m2110iIl1il(view, rect);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            f4413IL1Iii = new LlIl();
        } else if (i >= 23) {
            f4413IL1Iii = new L11();
        } else if (i >= 22) {
            f4413IL1Iii = new C0585();
        } else if (i >= 21) {
            f4413IL1Iii = new C0645ill();
        } else if (i >= 19) {
            f4413IL1Iii = new LIll();
        } else {
            f4413IL1Iii = new IIiI();
        }
        f4414ILil = new IL1Iii(Float.class, "translationAlpha");
        f4412I1I = new ILil(Rect.class, "clipBounds");
    }

    public static float I1I(View view) {
        return f4413IL1Iii.I1I(view);
    }

    public static void IL1Iii(View view) {
        f4413IL1Iii.IL1Iii(view);
    }

    public static void ILL(View view, Matrix matrix) {
        f4413IL1Iii.mo2552il(view, matrix);
    }

    public static iILLl ILil(View view) {
        return Build.VERSION.SDK_INT >= 18 ? new L1l(view) : l1IIi1.Ilil(view);
    }

    public static void Ilil(View view) {
        f4413IL1Iii.mo2547IL(view);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static I1L11L m2553IL(View view) {
        return Build.VERSION.SDK_INT >= 18 ? new iI1iI(view) : new LLL(view.getWindowToken());
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static void m2554IiL(View view, float f) {
        f4413IL1Iii.mo2550iILLL1(view, f);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static void m2555L11I(View view, int i) {
        f4413IL1Iii.mo2548IiL(view, i);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static void m2556iILLL1(View view, int i, int i2, int i3, int i4) {
        f4413IL1Iii.mo2551lLi1LL(view, i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static void m2557lLi1LL(View view, Matrix matrix) {
        f4413IL1Iii.Ilil(view, matrix);
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static void m2558il(View view, Matrix matrix) {
        f4413IL1Iii.mo2549L11I(view, matrix);
    }
}
