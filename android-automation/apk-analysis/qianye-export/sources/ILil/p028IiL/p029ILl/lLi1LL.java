package ILil.p028IiL.p029ILl;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import java.lang.reflect.Field;

/* JADX INFO: renamed from: ILil.I丨iL.IL丨丨l.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: LayoutInflaterCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class lLi1LL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static Field f4084IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static boolean f4085ILil;

    public static void IL1Iii(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!f4085ILil) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                f4084IL1Iii = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f4085ILil = true;
        }
        Field field = f4084IL1Iii;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }

    public static void ILil(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
        if (Build.VERSION.SDK_INT < 21) {
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                IL1Iii(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                IL1Iii(layoutInflater, factory2);
            }
        }
    }
}
