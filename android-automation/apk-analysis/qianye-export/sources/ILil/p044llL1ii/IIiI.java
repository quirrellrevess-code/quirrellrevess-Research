package ILil.p044llL1ii;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: ILil.ll丨L1ii.IIi丨丨I, reason: invalid class name */
/* JADX INFO: compiled from: ViewUtilsBase.java */
/* JADX INFO: loaded from: classes.dex */
public class IIiI {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static boolean f4405I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static Method f4406ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static boolean f4407Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static Field f1851IL;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public float[] f4408IL1Iii;

    public float I1I(View view) {
        Float f = (Float) view.getTag(llL1ii.save_non_transition_alpha);
        return f != null ? view.getAlpha() / f.floatValue() : view.getAlpha();
    }

    public void IL1Iii(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(llL1ii.save_non_transition_alpha, null);
        }
    }

    @SuppressLint({"PrivateApi"})
    public final void ILil() {
        if (f4405I1I) {
            return;
        }
        try {
            Class cls = Integer.TYPE;
            Method declaredMethod = View.class.getDeclaredMethod("setFrame", cls, cls, cls, cls);
            f4406ILil = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsBase", "Failed to retrieve setFrame method", e);
        }
        f4405I1I = true;
    }

    public void Ilil(View view, Matrix matrix) {
        if (matrix == null || matrix.isIdentity()) {
            view.setPivotX(view.getWidth() / 2);
            view.setPivotY(view.getHeight() / 2);
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setRotation(0.0f);
            return;
        }
        float[] fArr = this.f4408IL1Iii;
        if (fArr == null) {
            fArr = new float[9];
            this.f4408IL1Iii = fArr;
        }
        matrix.getValues(fArr);
        float f = fArr[3];
        float fSqrt = ((float) Math.sqrt(1.0f - (f * f))) * (fArr[0] < 0.0f ? -1 : 1);
        float degrees = (float) Math.toDegrees(Math.atan2(f, fSqrt));
        float f2 = fArr[0] / fSqrt;
        float f3 = fArr[4] / fSqrt;
        float f4 = fArr[2];
        float f5 = fArr[5];
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setTranslationX(f4);
        view.setTranslationY(f5);
        view.setRotation(degrees);
        view.setScaleX(f2);
        view.setScaleY(f3);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void mo2547IL(View view) {
        int i = llL1ii.save_non_transition_alpha;
        if (view.getTag(i) == null) {
            view.setTag(i, Float.valueOf(view.getAlpha()));
        }
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void mo2548IiL(View view, int i) {
        if (!f4407Ilil) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f1851IL = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            f4407Ilil = true;
        }
        Field field = f1851IL;
        if (field != null) {
            try {
                f1851IL.setInt(view, i | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public void mo2549L11I(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            mo2549L11I(view2, matrix);
            matrix.preTranslate(-view2.getScrollX(), -view2.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        matrix.preConcat(matrix2);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void mo2550iILLL1(View view, float f) {
        Float f2 = (Float) view.getTag(llL1ii.save_non_transition_alpha);
        if (f2 != null) {
            view.setAlpha(f2.floatValue() * f);
        } else {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void mo2551lLi1LL(View view, int i, int i2, int i3, int i4) {
        ILil();
        Method method = f4406ILil;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void mo2552il(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            mo2552il(view2, matrix);
            matrix.postTranslate(view2.getScrollX(), view2.getScrollY());
        }
        matrix.postTranslate(-view.getLeft(), -view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        Matrix matrix3 = new Matrix();
        if (matrix2.invert(matrix3)) {
            matrix.postConcat(matrix3);
        }
    }
}
