package ILil.ILil.p023lIlii;

import ILil.p028IiL.p033iILLL1.IL1Iii;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;

/* JADX INFO: renamed from: ILil.ILil.lI丨lii.lI丨II, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: ThemeUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C0625lIII {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f3817IL1Iii = new ThreadLocal<>();

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final int[] f3818ILil = {-16842910};

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final int[] f3816I1I = {R.attr.state_focused};

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static final int[] f1401IL = {R.attr.state_pressed};

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static final int[] f3819Ilil = {R.attr.state_checked};

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static final int[] f1403lLi1LL = new int[0];

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static final int[] f1402iILLL1 = new int[1];

    public static int I1I(Context context, int i, float f) {
        int iILil = ILil(context, i);
        return IL1Iii.m2248IL(iILil, Math.round(Color.alpha(iILil) * f));
    }

    public static int IL1Iii(Context context, int i) {
        ColorStateList colorStateListM1815IL = m1815IL(context, i);
        if (colorStateListM1815IL != null && colorStateListM1815IL.isStateful()) {
            return colorStateListM1815IL.getColorForState(f3818ILil, colorStateListM1815IL.getDefaultColor());
        }
        TypedValue typedValueIlil = Ilil();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueIlil, true);
        return I1I(context, i, typedValueIlil.getFloat());
    }

    public static int ILil(Context context, int i) {
        int[] iArr = f1402iILLL1;
        iArr[0] = i;
        llI lliIIlLiL = llI.iIlLiL(context, null, iArr);
        try {
            return lliIIlLiL.ILil(0, 0);
        } finally {
            lliIIlLiL.m1833lL();
        }
    }

    public static TypedValue Ilil() {
        ThreadLocal<TypedValue> threadLocal = f3817IL1Iii;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static ColorStateList m1815IL(Context context, int i) {
        int[] iArr = f1402iILLL1;
        iArr[0] = i;
        llI lliIIlLiL = llI.iIlLiL(context, null, iArr);
        try {
            return lliIIlLiL.I1I(0);
        } finally {
            lliIIlLiL.m1833lL();
        }
    }
}
