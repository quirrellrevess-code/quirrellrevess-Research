package ILil.ILil.p022lIiI.IL1Iii;

import ILil.ILil.p023lIlii.I11L;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: AppCompatResources.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedAPI"})
public final class IL1Iii {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f3743IL1Iii = new ThreadLocal<>();

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final WeakHashMap<Context, SparseArray<C0553IL1Iii>> f3744ILil = new WeakHashMap<>(0);

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final Object f3742I1I = new Object();

    /* JADX INFO: renamed from: ILil.ILil.lIi丨I.IL1Iii.IL1Iii$IL1Iii, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppCompatResources.java */
    public static class C0553IL1Iii {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final ColorStateList f3745IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final Configuration f3746ILil;

        public C0553IL1Iii(ColorStateList colorStateList, Configuration configuration) {
            this.f3745IL1Iii = colorStateList;
            this.f3746ILil = configuration;
        }
    }

    public static ColorStateList I1I(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList colorStateListILil = ILil(context, i);
        if (colorStateListILil != null) {
            return colorStateListILil;
        }
        ColorStateList colorStateListM1688lLi1LL = m1688lLi1LL(context, i);
        if (colorStateListM1688lLi1LL == null) {
            return ILil.p028IiL.p035lLi1LL.IL1Iii.I1I(context, i);
        }
        IL1Iii(context, i, colorStateListM1688lLi1LL);
        return colorStateListM1688lLi1LL;
    }

    public static void IL1Iii(Context context, int i, ColorStateList colorStateList) {
        synchronized (f3742I1I) {
            WeakHashMap<Context, SparseArray<C0553IL1Iii>> weakHashMap = f3744ILil;
            SparseArray<C0553IL1Iii> sparseArray = weakHashMap.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                weakHashMap.put(context, sparseArray);
            }
            sparseArray.append(i, new C0553IL1Iii(colorStateList, context.getResources().getConfiguration()));
        }
    }

    public static ColorStateList ILil(Context context, int i) {
        C0553IL1Iii c0553IL1Iii;
        synchronized (f3742I1I) {
            SparseArray<C0553IL1Iii> sparseArray = f3744ILil.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (c0553IL1Iii = sparseArray.get(i)) != null) {
                if (c0553IL1Iii.f3746ILil.equals(context.getResources().getConfiguration())) {
                    return c0553IL1Iii.f3745IL1Iii;
                }
                sparseArray.remove(i);
            }
            return null;
        }
    }

    public static TypedValue Ilil() {
        ThreadLocal<TypedValue> threadLocal = f3743IL1Iii;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static Drawable m1686IL(Context context, int i) {
        return I11L.m1689IiL().m1699il(context, i);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static boolean m1687iILLL1(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue typedValueIlil = Ilil();
        resources.getValue(i, typedValueIlil, true);
        int i2 = typedValueIlil.type;
        return i2 >= 28 && i2 <= 31;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static ColorStateList m1688lLi1LL(Context context, int i) {
        if (m1687iILLL1(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return ILil.p028IiL.p035lLi1LL.I1I.IL1Iii.IL1Iii(resources, resources.getXml(i), context.getTheme());
        } catch (Exception e) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }
}
