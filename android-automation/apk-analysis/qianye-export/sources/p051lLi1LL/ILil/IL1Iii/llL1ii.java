package p051lLi1LL.ILil.IL1Iii;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p051lLi1LL.ILil.IL1Iii.iIlLiL.ILil;

/* JADX INFO: renamed from: l丨Li1LL.ILil.IL1Iii.ll丨L1ii, reason: invalid class name */
/* JADX INFO: compiled from: SubscriberMethodFinder.java */
/* JADX INFO: loaded from: classes.dex */
public class llL1ii {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final boolean f5579I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public List<ILil> f5580IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final boolean f5581ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static final Map<Class<?>, List<LlLI1>> f3060IL = new ConcurrentHashMap();

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static final IL1Iii[] f5578Ilil = new IL1Iii[4];

    /* JADX INFO: renamed from: l丨Li1LL.ILil.IL1Iii.ll丨L1ii$IL1Iii */
    /* JADX INFO: compiled from: SubscriberMethodFinder.java */
    public static class IL1Iii {

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public Class<?> f5585Ilil;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public p051lLi1LL.ILil.IL1Iii.iIlLiL.IL1Iii f3062iILLL1;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public boolean f3063lLi1LL;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final List<LlLI1> f5583IL1Iii = new ArrayList();

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final Map<Class, Object> f5584ILil = new HashMap();

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final Map<String, Class> f5582I1I = new HashMap();

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final StringBuilder f3061IL = new StringBuilder(128);

        public void I1I(Class<?> cls) {
            this.f5585Ilil = cls;
            this.f3063lLi1LL = false;
            this.f3062iILLL1 = null;
        }

        public boolean IL1Iii(Method method, Class<?> cls) {
            Object objPut = this.f5584ILil.put(cls, method);
            if (objPut == null) {
                return true;
            }
            if (objPut instanceof Method) {
                if (!ILil((Method) objPut, cls)) {
                    throw new IllegalStateException();
                }
                this.f5584ILil.put(cls, this);
            }
            return ILil(method, cls);
        }

        public final boolean ILil(Method method, Class<?> cls) {
            this.f3061IL.setLength(0);
            this.f3061IL.append(method.getName());
            StringBuilder sb = this.f3061IL;
            sb.append('>');
            sb.append(cls.getName());
            String string = this.f3061IL.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class clsPut = this.f5582I1I.put(string, declaringClass);
            if (clsPut == null || clsPut.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.f5582I1I.put(string, clsPut);
            return false;
        }

        public void Ilil() {
            this.f5583IL1Iii.clear();
            this.f5584ILil.clear();
            this.f5582I1I.clear();
            this.f3061IL.setLength(0);
            this.f5585Ilil = null;
            this.f3063lLi1LL = false;
            this.f3062iILLL1 = null;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public void m3676IL() {
            if (this.f3063lLi1LL) {
                this.f5585Ilil = null;
                return;
            }
            Class<? super Object> superclass = this.f5585Ilil.getSuperclass();
            this.f5585Ilil = superclass;
            String name = superclass.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.") || name.startsWith("androidx.")) {
                this.f5585Ilil = null;
            }
        }
    }

    public llL1ii(List<ILil> list, boolean z, boolean z2) {
        this.f5580IL1Iii = list;
        this.f5581ILil = z;
        this.f5579I1I = z2;
    }

    public final List<LlLI1> I1I(Class<?> cls) {
        IL1Iii iL1IiiM3674iILLL1 = m3674iILLL1();
        iL1IiiM3674iILLL1.I1I(cls);
        while (iL1IiiM3674iILLL1.f5585Ilil != null) {
            m3673IL(iL1IiiM3674iILLL1);
            iL1IiiM3674iILLL1.m3676IL();
        }
        return Ilil(iL1IiiM3674iILLL1);
    }

    public List<LlLI1> IL1Iii(Class<?> cls) {
        Map<Class<?>, List<LlLI1>> map = f3060IL;
        List<LlLI1> list = map.get(cls);
        if (list != null) {
            return list;
        }
        List<LlLI1> listI1I = this.f5579I1I ? I1I(cls) : ILil(cls);
        if (!listI1I.isEmpty()) {
            map.put(cls, listI1I);
            return listI1I;
        }
        throw new lLi1LL("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }

    public final List<LlLI1> ILil(Class<?> cls) {
        IL1Iii iL1IiiM3674iILLL1 = m3674iILLL1();
        iL1IiiM3674iILLL1.I1I(cls);
        while (iL1IiiM3674iILLL1.f5585Ilil != null) {
            p051lLi1LL.ILil.IL1Iii.iIlLiL.IL1Iii iL1IiiM3675lLi1LL = m3675lLi1LL(iL1IiiM3674iILLL1);
            iL1IiiM3674iILLL1.f3062iILLL1 = iL1IiiM3675lLi1LL;
            if (iL1IiiM3675lLi1LL != null) {
                for (LlLI1 llLI1 : iL1IiiM3675lLi1LL.IL1Iii()) {
                    if (iL1IiiM3674iILLL1.IL1Iii(llLI1.f5564IL1Iii, llLI1.f5563I1I)) {
                        iL1IiiM3674iILLL1.f5583IL1Iii.add(llLI1);
                    }
                }
            } else {
                m3673IL(iL1IiiM3674iILLL1);
            }
            iL1IiiM3674iILLL1.m3676IL();
        }
        return Ilil(iL1IiiM3674iILLL1);
    }

    public final List<LlLI1> Ilil(IL1Iii iL1Iii) {
        ArrayList arrayList = new ArrayList(iL1Iii.f5583IL1Iii);
        iL1Iii.Ilil();
        synchronized (f5578Ilil) {
            for (int i = 0; i < 4; i++) {
                IL1Iii[] iL1IiiArr = f5578Ilil;
                if (iL1IiiArr[i] == null) {
                    iL1IiiArr[i] = iL1Iii;
                    break;
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final void m3673IL(IL1Iii iL1Iii) {
        Method[] methods;
        try {
            try {
                methods = iL1Iii.f5585Ilil.getDeclaredMethods();
            } catch (Throwable unused) {
                methods = iL1Iii.f5585Ilil.getMethods();
                iL1Iii.f3063lLi1LL = true;
            }
            for (Method method : methods) {
                int modifiers = method.getModifiers();
                if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1) {
                        InterfaceC0678ILl interfaceC0678ILl = (InterfaceC0678ILl) method.getAnnotation(InterfaceC0678ILl.class);
                        if (interfaceC0678ILl != null) {
                            Class<?> cls = parameterTypes[0];
                            if (iL1Iii.IL1Iii(method, cls)) {
                                iL1Iii.f5583IL1Iii.add(new LlLI1(method, cls, interfaceC0678ILl.threadMode(), interfaceC0678ILl.priority(), interfaceC0678ILl.sticky()));
                            }
                        }
                    } else if (this.f5581ILil && method.isAnnotationPresent(InterfaceC0678ILl.class)) {
                        throw new lLi1LL("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                    }
                } else if (this.f5581ILil && method.isAnnotationPresent(InterfaceC0678ILl.class)) {
                    throw new lLi1LL((method.getDeclaringClass().getName() + "." + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
                }
            }
        } catch (LinkageError e) {
            String str = "Could not inspect methods of " + iL1Iii.f5585Ilil.getName();
            throw new lLi1LL(this.f5579I1I ? str + ". Please consider using EventBus annotation processor to avoid reflection." : str + ". Please make this class visible to EventBus annotation processor to avoid reflection.", e);
        }
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final IL1Iii m3674iILLL1() {
        synchronized (f5578Ilil) {
            for (int i = 0; i < 4; i++) {
                IL1Iii[] iL1IiiArr = f5578Ilil;
                IL1Iii iL1Iii = iL1IiiArr[i];
                if (iL1Iii != null) {
                    iL1IiiArr[i] = null;
                    return iL1Iii;
                }
            }
            return new IL1Iii();
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final p051lLi1LL.ILil.IL1Iii.iIlLiL.IL1Iii m3675lLi1LL(IL1Iii iL1Iii) {
        p051lLi1LL.ILil.IL1Iii.iIlLiL.IL1Iii iL1Iii2 = iL1Iii.f3062iILLL1;
        if (iL1Iii2 != null && iL1Iii2.ILil() != null) {
            p051lLi1LL.ILil.IL1Iii.iIlLiL.IL1Iii iL1IiiILil = iL1Iii.f3062iILLL1.ILil();
            if (iL1Iii.f5585Ilil == iL1IiiILil.I1I()) {
                return iL1IiiILil;
            }
        }
        List<ILil> list = this.f5580IL1Iii;
        if (list == null) {
            return null;
        }
        Iterator<ILil> it = list.iterator();
        while (it.hasNext()) {
            p051lLi1LL.ILil.IL1Iii.iIlLiL.IL1Iii IL1Iii2 = it.next().IL1Iii(iL1Iii.f5585Ilil);
            if (IL1Iii2 != null) {
                return IL1Iii2;
            }
        }
        return null;
    }
}
