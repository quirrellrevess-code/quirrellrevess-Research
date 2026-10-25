package ILil.p028IiL.p031Ll1;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: compiled from: ICUCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class ILil {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static Method f4160IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static Method f4161ILil;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            if (i < 24) {
                try {
                    f4161ILil = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
                    return;
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }
            return;
        }
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f4160IL1Iii = cls.getMethod("getScript", String.class);
                f4161ILil = cls.getMethod("addLikelySubtags", String.class);
            }
        } catch (Exception e2) {
            f4160IL1Iii = null;
            f4161ILil = null;
            Log.w("ICUCompat", e2);
        }
    }

    public static String I1I(Locale locale) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return ULocale.addLikelySubtags(ULocale.forLocale(locale)).getScript();
        }
        if (i < 21) {
            String strIL1Iii = IL1Iii(locale);
            if (strIL1Iii != null) {
                return ILil(strIL1Iii);
            }
            return null;
        }
        try {
            return ((Locale) f4161ILil.invoke(null, locale)).getScript();
        } catch (IllegalAccessException e) {
            Log.w("ICUCompat", e);
            return locale.getScript();
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompat", e2);
            return locale.getScript();
        }
    }

    public static String IL1Iii(Locale locale) {
        String string = locale.toString();
        try {
            Method method = f4161ILil;
            if (method != null) {
                return (String) method.invoke(null, string);
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompat", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompat", e2);
        }
        return string;
    }

    public static String ILil(String str) {
        try {
            Method method = f4160IL1Iii;
            if (method != null) {
                return (String) method.invoke(null, str);
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompat", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompat", e2);
        }
        return null;
    }
}
