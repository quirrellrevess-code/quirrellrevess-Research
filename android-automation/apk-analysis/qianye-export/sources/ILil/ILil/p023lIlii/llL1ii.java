package ILil.ILil.p023lIlii;

import ILil.p028IiL.p033iILLL1.ILL.I1I;
import ILil.p028IiL.p033iILLL1.ILL.IL1Iii;
import android.R;
import android.annotation.SuppressLint;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Field;

/* JADX INFO: renamed from: ILil.ILil.lI丨lii.ll丨L1ii, reason: invalid class name */
/* JADX INFO: compiled from: DrawableUtils.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedAPI"})
public class llL1ii {

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static Class<?> f1413IL;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final int[] f3830IL1Iii = {R.attr.state_checked};

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final int[] f3831ILil = new int[0];

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final Rect f3829I1I = new Rect();

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                f1413IL = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException unused) {
            }
        }
    }

    public static void I1I(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f3830IL1Iii);
        } else {
            drawable.setState(f3831ILil);
        }
        drawable.setState(state);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean IL1Iii(Drawable drawable) {
        int i = Build.VERSION.SDK_INT;
        if (i < 15 && (drawable instanceof InsetDrawable)) {
            return false;
        }
        if (i < 15 && (drawable instanceof GradientDrawable)) {
            return false;
        }
        if (i < 17 && (drawable instanceof LayerDrawable)) {
            return false;
        }
        if (!(drawable instanceof DrawableContainer)) {
            if (drawable instanceof I1I) {
                return IL1Iii(((I1I) drawable).ILil());
            }
            if (drawable instanceof ILil.ILil.p020ILl.IL1Iii.I1I) {
                return IL1Iii(((ILil.ILil.p020ILl.IL1Iii.I1I) drawable).getWrappedDrawable());
            }
            if (drawable instanceof ScaleDrawable) {
                return IL1Iii(((ScaleDrawable) drawable).getDrawable());
            }
            return true;
        }
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (!(constantState instanceof DrawableContainer.DrawableContainerState)) {
            return true;
        }
        for (Drawable drawable2 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
            if (!IL1Iii(drawable2)) {
                return false;
            }
        }
        return true;
    }

    public static void ILil(Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            I1I(drawable);
        }
    }

    public static PorterDuff.Mode Ilil(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static Rect m1834IL(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 29) {
            Insets opticalInsets = drawable.getOpticalInsets();
            Rect rect = new Rect();
            rect.left = opticalInsets.left;
            rect.right = opticalInsets.right;
            rect.top = opticalInsets.top;
            rect.bottom = opticalInsets.bottom;
            return rect;
        }
        if (f1413IL != null) {
            try {
                Drawable drawableM2257llL1ii = IL1Iii.m2257llL1ii(drawable);
                Object objInvoke = drawableM2257llL1ii.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(drawableM2257llL1ii, new Object[0]);
                if (objInvoke != null) {
                    Rect rect2 = new Rect();
                    for (Field field : f1413IL.getFields()) {
                        String name = field.getName();
                        byte b = -1;
                        switch (name.hashCode()) {
                            case -1383228885:
                                if (name.equals("bottom")) {
                                    b = 3;
                                }
                                break;
                            case 115029:
                                if (name.equals("top")) {
                                    b = 1;
                                }
                                break;
                            case 3317767:
                                if (name.equals("left")) {
                                    b = 0;
                                }
                                break;
                            case 108511772:
                                if (name.equals("right")) {
                                    b = 2;
                                }
                                break;
                        }
                        if (b == 0) {
                            rect2.left = field.getInt(objInvoke);
                        } else if (b == 1) {
                            rect2.top = field.getInt(objInvoke);
                        } else if (b == 2) {
                            rect2.right = field.getInt(objInvoke);
                        } else if (b == 3) {
                            rect2.bottom = field.getInt(objInvoke);
                        }
                    }
                    return rect2;
                }
            } catch (Exception unused) {
                Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
            }
        }
        return f3829I1I;
    }
}
