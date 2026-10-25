package ILil.p028IiL.Lil;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: CompoundButtonCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class I1I {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static Field f4119IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static boolean f4120ILil;

    /* JADX WARN: Multi-variable type inference failed */
    public static void I1I(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintList(colorStateList);
        } else if (compoundButton instanceof ILL) {
            ((ILL) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    public static Drawable IL1Iii(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return compoundButton.getButtonDrawable();
        }
        if (!f4120ILil) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f4119IL1Iii = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e);
            }
            f4120ILil = true;
        }
        Field field = f4119IL1Iii;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException e2) {
                Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e2);
                f4119IL1Iii = null;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ColorStateList ILil(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 21) {
            return compoundButton.getButtonTintList();
        }
        if (compoundButton instanceof ILL) {
            return ((ILL) compoundButton).getSupportButtonTintList();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static void m2198IL(CompoundButton compoundButton, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintMode(mode);
        } else if (compoundButton instanceof ILL) {
            ((ILL) compoundButton).setSupportButtonTintMode(mode);
        }
    }
}
