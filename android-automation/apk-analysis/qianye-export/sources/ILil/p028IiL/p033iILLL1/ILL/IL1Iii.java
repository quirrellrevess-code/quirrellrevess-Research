package ILil.p028IiL.p033iILLL1.ILL;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: DrawableCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class IL1Iii {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static Method f4174I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static Method f4175IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static boolean f4176ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static boolean f1706IL;

    /* JADX WARN: Multi-variable type inference failed */
    public static void I1I(Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            drawable.clearColorFilter();
            return;
        }
        if (i < 21) {
            drawable.clearColorFilter();
            return;
        }
        drawable.clearColorFilter();
        if (drawable instanceof InsetDrawable) {
            I1I(((InsetDrawable) drawable).getDrawable());
            return;
        }
        if (drawable instanceof I1I) {
            I1I(((I1I) drawable).ILil());
            return;
        }
        if (!(drawable instanceof DrawableContainer) || (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) == null) {
            return;
        }
        int childCount = drawableContainerState.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            Drawable child = drawableContainerState.getChild(i2);
            if (child != null) {
                I1I(child);
            }
        }
    }

    public static void IL1Iii(Drawable drawable, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.applyTheme(theme);
        }
    }

    public static void ILL(Drawable drawable, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspot(f, f2);
        }
    }

    public static boolean ILil(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public static void m2249ILl(Drawable drawable, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTint(i);
        } else if (drawable instanceof ILil) {
            ((ILil) drawable).setTint(i);
        }
    }

    public static ColorFilter Ilil(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.getColorFilter();
        }
        return null;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static int m2250IL(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.getAlpha();
        }
        return 0;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static boolean m2251IiL(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.isAutoMirrored();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void Lil(Drawable drawable, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintList(colorStateList);
        } else if (drawable instanceof ILil) {
            ((ILil) drawable).setTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void LlLI1(Drawable drawable, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintMode(mode);
        } else if (drawable instanceof ILil) {
            ((ILil) drawable).setTintMode(mode);
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static void m2252Ll1(Drawable drawable, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }
    }

    @Deprecated
    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static void m2253L11I(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static void m2254iILLL1(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        } else {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public static boolean m2255lIiI(Drawable drawable, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            return drawable.setLayoutDirection(i);
        }
        if (i2 >= 17) {
            if (!f4176ILil) {
                try {
                    Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                    f4175IL1Iii = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e);
                }
                f4176ILil = true;
            }
            Method method = f4175IL1Iii;
            if (method != null) {
                try {
                    method.invoke(drawable, Integer.valueOf(i));
                    return true;
                } catch (Exception e2) {
                    Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                    f4175IL1Iii = null;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public static Drawable m2256lIlii(Drawable drawable) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return drawable;
        }
        if (i >= 21) {
            return !(drawable instanceof ILil) ? new lLi1LL(drawable) : drawable;
        }
        return !(drawable instanceof ILil) ? new IL(drawable) : drawable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public static <T extends Drawable> T m2257llL1ii(Drawable drawable) {
        return drawable instanceof I1I ? (T) ((I1I) drawable).ILil() : drawable;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static int m2258lLi1LL(Drawable drawable) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return drawable.getLayoutDirection();
        }
        if (i >= 17) {
            if (!f1706IL) {
                try {
                    Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                    f4174I1I = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e);
                }
                f1706IL = true;
            }
            Method method = f4174I1I;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(drawable, new Object[0])).intValue();
                } catch (Exception e2) {
                    Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e2);
                    f4174I1I = null;
                }
            }
        }
        return 0;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static void m2259il(Drawable drawable, boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            drawable.setAutoMirrored(z);
        }
    }
}
