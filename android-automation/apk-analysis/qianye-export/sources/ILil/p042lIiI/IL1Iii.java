package ILil.p042lIiI;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ClassesInfoCache.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static IL1Iii f4335I1I = new IL1Iii();

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Map<Class, C0580IL1Iii> f4336IL1Iii = new HashMap();

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final Map<Class, Boolean> f4337ILil = new HashMap();

    /* JADX INFO: renamed from: ILil.lIi丨I.IL1Iii$IL1Iii, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ClassesInfoCache.java */
    public static class C0580IL1Iii {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final Map<IL.IL1Iii, List<ILil>> f4338IL1Iii = new HashMap();

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final Map<ILil, IL.IL1Iii> f4339ILil;

        public C0580IL1Iii(Map<ILil, IL.IL1Iii> map) {
            this.f4339ILil = map;
            for (Map.Entry<ILil, IL.IL1Iii> entry : map.entrySet()) {
                IL.IL1Iii value = entry.getValue();
                List<ILil> arrayList = this.f4338IL1Iii.get(value);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.f4338IL1Iii.put(value, arrayList);
                }
                arrayList.add(entry.getKey());
            }
        }

        public static void ILil(List<ILil> list, IiL iiL, IL.IL1Iii iL1Iii, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).IL1Iii(iiL, iL1Iii, obj);
                }
            }
        }

        public void IL1Iii(IiL iiL, IL.IL1Iii iL1Iii, Object obj) {
            ILil(this.f4338IL1Iii.get(iL1Iii), iiL, iL1Iii, obj);
            ILil(this.f4338IL1Iii.get(IL.IL1Iii.ON_ANY), iiL, iL1Iii, obj);
        }
    }

    /* JADX INFO: compiled from: ClassesInfoCache.java */
    public static class ILil {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final int f4340IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final Method f4341ILil;

        public ILil(int i, Method method) {
            this.f4340IL1Iii = i;
            this.f4341ILil = method;
            method.setAccessible(true);
        }

        public void IL1Iii(IiL iiL, IL.IL1Iii iL1Iii, Object obj) {
            try {
                int i = this.f4340IL1Iii;
                if (i == 0) {
                    this.f4341ILil.invoke(obj, new Object[0]);
                } else if (i == 1) {
                    this.f4341ILil.invoke(obj, iiL);
                } else {
                    if (i != 2) {
                        return;
                    }
                    this.f4341ILil.invoke(obj, iiL, iL1Iii);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ILil.class != obj.getClass()) {
                return false;
            }
            ILil iLil = (ILil) obj;
            return this.f4340IL1Iii == iLil.f4340IL1Iii && this.f4341ILil.getName().equals(iLil.f4341ILil.getName());
        }

        public int hashCode() {
            return (this.f4340IL1Iii * 31) + this.f4341ILil.getName().hashCode();
        }
    }

    public C0580IL1Iii I1I(Class cls) {
        C0580IL1Iii c0580IL1Iii = this.f4336IL1Iii.get(cls);
        return c0580IL1Iii != null ? c0580IL1Iii : IL1Iii(cls, null);
    }

    public final C0580IL1Iii IL1Iii(Class cls, Method[] methodArr) {
        int i;
        C0580IL1Iii c0580IL1IiiI1I;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (c0580IL1IiiI1I = I1I(superclass)) != null) {
            map.putAll(c0580IL1IiiI1I.f4339ILil);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<ILil, IL.IL1Iii> entry : I1I(cls2).f4339ILil.entrySet()) {
                Ilil(map, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = ILil(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            Lil lil = (Lil) method.getAnnotation(Lil.class);
            if (lil != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(IiL.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i = 1;
                }
                IL.IL1Iii iL1IiiValue = lil.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(IL.IL1Iii.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (iL1IiiValue != IL.IL1Iii.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                Ilil(map, new ILil(i, method), iL1IiiValue, cls);
                z = true;
            }
        }
        C0580IL1Iii c0580IL1Iii = new C0580IL1Iii(map);
        this.f4336IL1Iii.put(cls, c0580IL1Iii);
        this.f4337ILil.put(cls, Boolean.valueOf(z));
        return c0580IL1Iii;
    }

    public final Method[] ILil(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    public final void Ilil(Map<ILil, IL.IL1Iii> map, ILil iLil, IL.IL1Iii iL1Iii, Class cls) {
        IL.IL1Iii iL1Iii2 = map.get(iLil);
        if (iL1Iii2 == null || iL1Iii == iL1Iii2) {
            if (iL1Iii2 == null) {
                map.put(iLil, iL1Iii);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + iLil.f4341ILil.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + iL1Iii2 + ", new value " + iL1Iii);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean m2494IL(Class cls) {
        Boolean bool = this.f4337ILil.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] methodArrILil = ILil(cls);
        for (Method method : methodArrILil) {
            if (((Lil) method.getAnnotation(Lil.class)) != null) {
                IL1Iii(cls, methodArrILil);
                return true;
            }
        }
        this.f4337ILil.put(cls, Boolean.FALSE);
        return false;
    }
}
