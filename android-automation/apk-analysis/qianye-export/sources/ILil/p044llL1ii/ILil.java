package ILil.p044llL1ii;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: CanvasUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static boolean f4409I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static Method f4410IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static Method f4411ILil;

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static void IL1Iii(Canvas canvas, boolean z) {
        Method method;
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
            return;
        }
        if (i >= 29) {
            if (z) {
                canvas.enableZ();
                return;
            } else {
                canvas.disableZ();
                return;
            }
        }
        if (i == 28) {
            throw new IllegalStateException("This method doesn't work on Pie!");
        }
        if (!f4409I1I) {
            try {
                Method declaredMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);
                f4410IL1Iii = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);
                f4411ILil = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f4409I1I = true;
        }
        if (z) {
            try {
                Method method2 = f4410IL1Iii;
                if (method2 != null) {
                    method2.invoke(canvas, new Object[0]);
                }
            } catch (IllegalAccessException unused2) {
                return;
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        if (z || (method = f4411ILil) == null) {
            return;
        }
        method.invoke(canvas, new Object[0]);
    }
}
