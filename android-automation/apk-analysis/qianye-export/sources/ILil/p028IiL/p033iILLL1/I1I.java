package ILil.p028IiL.p033iILLL1;

import ILil.p028IiL.ILL.ILil;
import ILil.p028IiL.p035lLi1LL.I1I.iILLL1;
import ILil.p065Ilil.LlLI1;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;

/* JADX INFO: compiled from: TypefaceCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class I1I {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final L11I f4172IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final LlLI1<String, Typeface> f4173ILil;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            f4172IL1Iii = new IiL();
        } else if (i >= 26) {
            f4172IL1Iii = new iILLL1();
        } else if (i >= 24 && lLi1LL.m2290lIiI()) {
            f4172IL1Iii = new lLi1LL();
        } else if (i >= 21) {
            f4172IL1Iii = new IL();
        } else {
            f4172IL1Iii = new L11I();
        }
        f4173ILil = new LlLI1<>(16);
    }

    public static Typeface I1I(Context context, ILil.I丨iL.l丨Li1LL.I1I.I1I.IL1Iii iL1Iii, Resources resources, int i, int i2, iILLL1.IL1Iii iL1Iii2, Handler handler, boolean z) {
        Typeface typefaceILil;
        if (iL1Iii instanceof ILil.p028IiL.p035lLi1LL.I1I.I1I.IL) {
            ILil.p028IiL.p035lLi1LL.I1I.I1I.IL il = (ILil.p028IiL.p035lLi1LL.I1I.I1I.IL) iL1Iii;
            boolean z2 = false;
            if (!z ? iL1Iii2 == null : il.IL1Iii() == 0) {
                z2 = true;
            }
            typefaceILil = ILil.m2018iILLL1(context, il.ILil(), iL1Iii2, handler, z2, z ? il.I1I() : -1, i2);
        } else {
            typefaceILil = f4172IL1Iii.ILil(context, (ILil.I丨iL.l丨Li1LL.I1I.I1I.ILil) iL1Iii, resources, i2);
            if (iL1Iii2 != null) {
                if (typefaceILil != null) {
                    iL1Iii2.callbackSuccessAsync(typefaceILil, handler);
                } else {
                    iL1Iii2.callbackFailAsync(-3, handler);
                }
            }
        }
        if (typefaceILil != null) {
            f4173ILil.m1949IL(Ilil(resources, i, i2), typefaceILil);
        }
        return typefaceILil;
    }

    public static Typeface IL1Iii(Context context, Typeface typeface, int i) {
        Typeface typefaceM2246iILLL1;
        if (context != null) {
            return (Build.VERSION.SDK_INT >= 21 || (typefaceM2246iILLL1 = m2246iILLL1(context, typeface, i)) == null) ? Typeface.create(typeface, i) : typefaceM2246iILLL1;
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface ILil(Context context, CancellationSignal cancellationSignal, ILil.iILLL1[] iilll1Arr, int i) {
        return f4172IL1Iii.I1I(context, cancellationSignal, iilll1Arr, i);
    }

    public static String Ilil(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static Typeface m2245IL(Context context, Resources resources, int i, String str, int i2) {
        Typeface typefaceIlil = f4172IL1Iii.Ilil(context, resources, i, str, i2);
        if (typefaceIlil != null) {
            f4173ILil.m1949IL(Ilil(resources, i, i2), typefaceIlil);
        }
        return typefaceIlil;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static Typeface m2246iILLL1(Context context, Typeface typeface, int i) {
        L11I l11i = f4172IL1Iii;
        ILil.I丨iL.l丨Li1LL.I1I.I1I.ILil iLilM2278L11I = l11i.m2278L11I(typeface);
        if (iLilM2278L11I == null) {
            return null;
        }
        return l11i.ILil(context, iLilM2278L11I, context.getResources(), i);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static Typeface m2247lLi1LL(Resources resources, int i, int i2) {
        return f4173ILil.I1I(Ilil(resources, i, i2));
    }
}
