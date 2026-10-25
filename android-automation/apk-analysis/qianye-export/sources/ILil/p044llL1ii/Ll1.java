package ILil.p044llL1ii;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import java.lang.reflect.Field;

/* JADX INFO: renamed from: ILil.ll丨L1ii.Ll丨1, reason: invalid class name */
/* JADX INFO: compiled from: ImageViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class Ll1 {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static boolean f4424I1I = false;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static boolean f4425IL1Iii = true;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static Field f4426ILil;

    @SuppressLint({"NewApi"})
    public static void I1I(ImageView imageView, Matrix matrix) {
        if (f4425IL1Iii) {
            try {
                imageView.animateTransform(matrix);
            } catch (NoSuchMethodError unused) {
                f4425IL1Iii = false;
            }
        }
    }

    public static void IL1Iii(ImageView imageView, Matrix matrix) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            imageView.animateTransform(matrix);
            return;
        }
        if (matrix == null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable != null) {
                drawable.setBounds(0, 0, (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight(), (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom());
                imageView.invalidate();
                return;
            }
            return;
        }
        if (i >= 21) {
            I1I(imageView, matrix);
            return;
        }
        Drawable drawable2 = imageView.getDrawable();
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            Matrix matrix2 = null;
            ILil();
            Field field = f4426ILil;
            if (field != null) {
                try {
                    Matrix matrix3 = (Matrix) field.get(imageView);
                    if (matrix3 == null) {
                        try {
                            matrix2 = new Matrix();
                            f4426ILil.set(imageView, matrix2);
                        } catch (IllegalAccessException unused) {
                            matrix2 = matrix3;
                        }
                    } else {
                        matrix2 = matrix3;
                    }
                } catch (IllegalAccessException unused2) {
                }
            }
            if (matrix2 != null) {
                matrix2.set(matrix);
            }
            imageView.invalidate();
        }
    }

    public static void ILil() {
        if (f4424I1I) {
            return;
        }
        try {
            Field declaredField = ImageView.class.getDeclaredField("mDrawMatrix");
            f4426ILil = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException unused) {
        }
        f4424I1I = true;
    }
}
