package ILil.p044llL1ii;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: ILil.ll丨L1ii.L丨1丨1丨I, reason: invalid class name */
/* JADX INFO: compiled from: GhostViewPlatform.java */
/* JADX INFO: loaded from: classes.dex */
public class L11I implements iILLL1 {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static Class<?> f4428I1I;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static Method f4429Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static boolean f1855IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static boolean f1856IiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static Method f1857iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static boolean f1858lLi1LL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final View f4430ILil;

    public L11I(View view) {
        this.f4430ILil = view;
    }

    public static void I1I() {
        if (f1858lLi1LL) {
            return;
        }
        try {
            m2564IL();
            Method declaredMethod = f4428I1I.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
            f4429Ilil = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("GhostViewApi21", "Failed to retrieve addGhost method", e);
        }
        f1858lLi1LL = true;
    }

    public static iILLL1 ILil(View view, ViewGroup viewGroup, Matrix matrix) {
        I1I();
        Method method = f4429Ilil;
        if (method != null) {
            try {
                return new L11I((View) method.invoke(null, view, viewGroup, matrix));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return null;
    }

    public static void Ilil() {
        if (f1856IiL) {
            return;
        }
        try {
            m2564IL();
            Method declaredMethod = f4428I1I.getDeclaredMethod("removeGhost", View.class);
            f1857iILLL1 = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", e);
        }
        f1856IiL = true;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static void m2564IL() {
        if (f1855IL) {
            return;
        }
        try {
            f4428I1I = Class.forName("android.view.GhostView");
        } catch (ClassNotFoundException e) {
            Log.i("GhostViewApi21", "Failed to retrieve GhostView class", e);
        }
        f1855IL = true;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static void m2565lLi1LL(View view) {
        Ilil();
        Method method = f1857iILLL1;
        if (method != null) {
            try {
                method.invoke(null, view);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Override // ILil.p044llL1ii.iILLL1
    public void IL1Iii(ViewGroup viewGroup, View view) {
    }

    @Override // ILil.p044llL1ii.iILLL1
    public void setVisibility(int i) {
        this.f4430ILil.setVisibility(i);
    }
}
