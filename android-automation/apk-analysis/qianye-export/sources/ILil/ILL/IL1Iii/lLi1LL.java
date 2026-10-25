package ILil.ILL.IL1Iii;

import ILil.p065Ilil.lIlii;
import androidx.fragment.app.Fragment;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: renamed from: ILil.ILL.IL1Iii.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: FragmentFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class lLi1LL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final lIlii<String, Class<?>> f3695IL1Iii = new lIlii<>();

    public static Class<?> I1I(ClassLoader classLoader, String str) throws ClassNotFoundException {
        lIlii<String, Class<?>> lilii = f3695IL1Iii;
        Class<?> cls = lilii.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        lilii.put(str, cls2);
        return cls2;
    }

    public static boolean ILil(ClassLoader classLoader, String str) {
        try {
            return Fragment.class.isAssignableFrom(I1I(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static Class<? extends Fragment> m1598IL(ClassLoader classLoader, String str) {
        try {
            return I1I(classLoader, str);
        } catch (ClassCastException e) {
            throw new Fragment.lLi1LL("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e);
        } catch (ClassNotFoundException e2) {
            throw new Fragment.lLi1LL("Unable to instantiate fragment " + str + ": make sure class name exists", e2);
        }
    }

    public Fragment IL1Iii(ClassLoader classLoader, String str) {
        try {
            return m1598IL(classLoader, str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (IllegalAccessException e) {
            throw new Fragment.lLi1LL("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (InstantiationException e2) {
            throw new Fragment.lLi1LL("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new Fragment.lLi1LL("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new Fragment.lLi1LL("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
        }
    }
}
