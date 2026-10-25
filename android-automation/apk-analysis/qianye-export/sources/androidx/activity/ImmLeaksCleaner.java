package androidx.activity;

import ILil.p042lIiI.IL;
import ILil.p042lIiI.IiL;
import ILil.p042lIiI.lLi1LL;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class ImmLeaksCleaner implements lLi1LL {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static Field f4737I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static int f4738ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static Field f4739Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static Field f2195IL;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public Activity f4740IL1Iii;

    public ImmLeaksCleaner(Activity activity) {
        this.f4740IL1Iii = activity;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static void m2985IiL() {
        try {
            f4738ILil = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f2195IL = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f4739Ilil = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f4737I1I = declaredField3;
            declaredField3.setAccessible(true);
            f4738ILil = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // ILil.p042lIiI.lLi1LL
    public void I1I(IiL iiL, IL.IL1Iii iL1Iii) {
        if (iL1Iii != IL.IL1Iii.ON_DESTROY) {
            return;
        }
        if (f4738ILil == 0) {
            m2985IiL();
        }
        if (f4738ILil == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f4740IL1Iii.getSystemService("input_method");
            try {
                Object obj = f4737I1I.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) f2195IL.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                f4739Ilil.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused) {
                            }
                        } catch (ClassCastException unused2) {
                        } catch (IllegalAccessException unused3) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
