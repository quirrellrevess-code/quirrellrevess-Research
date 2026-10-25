package ILil.p044llL1ii;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: ILil.ll丨L1ii.丨丨 */
/* JADX INFO: compiled from: ViewGroupUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C0006 {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static boolean f4472I1I = false;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static boolean f4473IL1Iii = true;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static Method f4474ILil;

    @SuppressLint({"NewApi"})
    public static void I1I(ViewGroup viewGroup, boolean z) {
        if (f4473IL1Iii) {
            try {
                viewGroup.suppressLayout(z);
            } catch (NoSuchMethodError unused) {
                f4473IL1Iii = false;
            }
        }
    }

    public static int IL1Iii(ViewGroup viewGroup, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            return viewGroup.getChildDrawingOrder(i);
        }
        if (!f4472I1I) {
            try {
                Class cls = Integer.TYPE;
                Method declaredMethod = ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", cls, cls);
                f4474ILil = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f4472I1I = true;
        }
        Method method = f4474ILil;
        if (method != null) {
            try {
                return ((Integer) method.invoke(viewGroup, Integer.valueOf(viewGroup.getChildCount()), Integer.valueOf(i))).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return i;
    }

    public static InterfaceC0648LLlI1 ILil(ViewGroup viewGroup) {
        return Build.VERSION.SDK_INT >= 18 ? new L111(viewGroup) : LL1IL.m2563iILLL1(viewGroup);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static void m2582IL(ViewGroup viewGroup, boolean z) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            viewGroup.suppressLayout(z);
        } else if (i >= 18) {
            I1I(viewGroup, z);
        } else {
            llI.ILil(viewGroup, z);
        }
    }
}
