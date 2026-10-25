package ILil.ILil.p021Ll1;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: renamed from: ILil.ILil.Ll丨1.iI丨LLL1, reason: invalid class name */
/* JADX INFO: compiled from: ResourcesFlusher.java */
/* JADX INFO: loaded from: classes.dex */
public class iILLL1 {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static Class<?> f3730I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static Field f3731IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static boolean f3732ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static Field f3733Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static boolean f1312IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static boolean f1313IiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static Field f1314iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static boolean f1315lLi1LL;

    public static void I1I(Resources resources) {
        if (!f3732ILil) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f3731IL1Iii = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            f3732ILil = true;
        }
        Object obj = null;
        Field field = f3731IL1Iii;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
            }
        }
        if (obj == null) {
            return;
        }
        Ilil(obj);
    }

    public static void IL1Iii(Resources resources) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return;
        }
        if (i >= 24) {
            m1657IL(resources);
        } else if (i >= 23) {
            I1I(resources);
        } else if (i >= 21) {
            ILil(resources);
        }
    }

    public static void ILil(Resources resources) {
        if (!f3732ILil) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f3731IL1Iii = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            f3732ILil = true;
        }
        Field field = f3731IL1Iii;
        if (field != null) {
            Map map = null;
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    public static void Ilil(Object obj) {
        if (!f1312IL) {
            try {
                f3730I1I = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e);
            }
            f1312IL = true;
        }
        Class<?> cls = f3730I1I;
        if (cls == null) {
            return;
        }
        if (!f1315lLi1LL) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                f3733Ilil = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
            }
            f1315lLi1LL = true;
        }
        Field field = f3733Ilil;
        if (field == null) {
            return;
        }
        LongSparseArray longSparseArray = null;
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e3) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e3);
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static void m1657IL(Resources resources) {
        Object obj;
        if (!f1313IiL) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f1314iILLL1 = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e);
            }
            f1313IiL = true;
        }
        Field field = f1314iILLL1;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException e2) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e2);
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f3732ILil) {
            try {
                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                f3731IL1Iii = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e3);
            }
            f3732ILil = true;
        }
        Field field2 = f3731IL1Iii;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException e4) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e4);
            }
        }
        if (obj2 != null) {
            Ilil(obj2);
        }
    }
}
