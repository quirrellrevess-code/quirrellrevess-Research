package ILil.p042lIiI;

import androidx.lifecycle.CompositeGeneratedAdaptersObserver;
import androidx.lifecycle.FullLifecycleObserverAdapter;
import androidx.lifecycle.ReflectiveGenericLifecycleObserver;
import androidx.lifecycle.SingleGeneratedAdapterObserver;
import com.google.android.flexbox.BuildConfig;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Lifecycling.java */
/* JADX INFO: loaded from: classes.dex */
public class ILL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static Map<Class, Integer> f4342IL1Iii = new HashMap();

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static Map<Class, List<Constructor<? extends I1I>>> f4343ILil = new HashMap();

    public static String I1I(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }

    public static I1I IL1Iii(Constructor<? extends I1I> constructor, Object obj) {
        try {
            return constructor.newInstance(obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    public static Constructor<? extends I1I> ILil(Class<?> cls) {
        try {
            Package r0 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r0 != null ? r0.getName() : BuildConfig.FLAVOR;
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String strI1I = I1I(canonicalName);
            if (!name.isEmpty()) {
                strI1I = name + "." + strI1I;
            }
            Constructor declaredConstructor = Class.forName(strI1I).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean Ilil(Class<?> cls) {
        return cls != null && iILLL1.class.isAssignableFrom(cls);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static int m2495IL(Class<?> cls) {
        Integer num = f4342IL1Iii.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int iM2496iILLL1 = m2496iILLL1(cls);
        f4342IL1Iii.put(cls, Integer.valueOf(iM2496iILLL1));
        return iM2496iILLL1;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static int m2496iILLL1(Class<?> cls) {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends I1I> constructorILil = ILil(cls);
        if (constructorILil != null) {
            f4343ILil.put(cls, Collections.singletonList(constructorILil));
            return 2;
        }
        if (IL1Iii.f4335I1I.m2494IL(cls)) {
            return 1;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        ArrayList arrayList = null;
        if (Ilil(superclass)) {
            if (m2495IL(superclass) == 1) {
                return 1;
            }
            arrayList = new ArrayList(f4343ILil.get(superclass));
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (Ilil(cls2)) {
                if (m2495IL(cls2) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.addAll(f4343ILil.get(cls2));
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f4343ILil.put(cls, arrayList);
        return 2;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static lLi1LL m2497lLi1LL(Object obj) {
        boolean z = obj instanceof lLi1LL;
        boolean z2 = obj instanceof ILil;
        if (z && z2) {
            return new FullLifecycleObserverAdapter((ILil) obj, (lLi1LL) obj);
        }
        if (z2) {
            return new FullLifecycleObserverAdapter((ILil) obj, null);
        }
        if (z) {
            return (lLi1LL) obj;
        }
        Class<?> cls = obj.getClass();
        if (m2495IL(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List<Constructor<? extends I1I>> list = f4343ILil.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(IL1Iii(list.get(0), obj));
        }
        I1I[] i1iArr = new I1I[list.size()];
        for (int i = 0; i < list.size(); i++) {
            i1iArr[i] = IL1Iii(list.get(i), obj);
        }
        return new CompositeGeneratedAdaptersObserver(i1iArr);
    }
}
