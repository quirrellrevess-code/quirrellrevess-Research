package p051lLi1LL.p060IL;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.impl.StaticLoggerBinder;
import p051lLi1LL.p060IL.Ilil.IL;
import p051lLi1LL.p060IL.p061lLi1LL.IiL;
import p051lLi1LL.p060IL.p061lLi1LL.iILLL1;
import p051lLi1LL.p060IL.p061lLi1LL.lLi1LL;

/* JADX INFO: compiled from: LoggerFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class I1I {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static volatile int f5588IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final iILLL1 f5589ILil = new iILLL1();

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final p051lLi1LL.p060IL.p061lLi1LL.I1I f5587I1I = new p051lLi1LL.p060IL.p061lLi1LL.I1I();

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static boolean f3064IL = IiL.m3696lLi1LL("slf4j.detectLoggerNameMismatch");

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static final String[] f5590Ilil = {"1.6", "1.7"};

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static String f3065lLi1LL = "org/slf4j/impl/StaticLoggerBinder.class";

    public static void I1I(int i) {
        IiL.I1I("A number (" + i + ") of logging calls during the initialization phase have been intercepted and are");
        IiL.I1I("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        IiL.I1I("See also http://www.slf4j.org/codes.html#replay");
    }

    public static final void IL1Iii() {
        Set<URL> setM3686lLi1LL = null;
        try {
            if (!m3680Ll1()) {
                setM3686lLi1LL = m3686lLi1LL();
                iIi1(setM3686lLi1LL);
            }
            StaticLoggerBinder.getSingleton();
            f5588IL1Iii = 3;
            m3684lIlii(setM3686lLi1LL);
            m3682iILLL1();
            LlLI1();
            f5589ILil.ILil();
        } catch (Exception e) {
            Ilil(e);
            throw new IllegalStateException("Unexpected initialization failure", e);
        } catch (NoClassDefFoundError e2) {
            if (!m3683lIiI(e2.getMessage())) {
                Ilil(e2);
                throw e2;
            }
            f5588IL1Iii = 4;
            IiL.I1I("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
            IiL.I1I("Defaulting to no-operation (NOP) logger implementation");
            IiL.I1I("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
        } catch (NoSuchMethodError e3) {
            String message = e3.getMessage();
            if (message != null && message.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                f5588IL1Iii = 2;
                IiL.I1I("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                IiL.I1I("Your binding is version 1.5.5 or earlier.");
                IiL.I1I("Upgrade your binding to version 1.6.x.");
            }
            throw e3;
        }
    }

    public static boolean ILL(Set<URL> set) {
        return set.size() > 1;
    }

    public static void ILil(IL il, int i) {
        if (il.IL1Iii().I1I()) {
            I1I(i);
        } else {
            if (il.IL1Iii().m3698IL()) {
                return;
            }
            m3678IL();
        }
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public static boolean m3677ILl(Class<?> cls, Class<?> cls2) {
        return !cls2.isAssignableFrom(cls);
    }

    public static void Ilil(Throwable th) {
        f5588IL1Iii = 2;
        IiL.m3694IL("Failed to instantiate SLF4J LoggerFactory", th);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static void m3678IL() {
        IiL.I1I("The following set of substitute loggers may have been accessed");
        IiL.I1I("during the initialization phase. Logging calls during this");
        IiL.I1I("phase were not honored. However, subsequent logging calls to these");
        IiL.I1I("loggers will work as normally expected.");
        IiL.I1I("See also http://www.slf4j.org/codes.html#substituteLogger");
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static IL1Iii m3679IiL() {
        if (f5588IL1Iii == 0) {
            synchronized (I1I.class) {
                if (f5588IL1Iii == 0) {
                    f5588IL1Iii = 1;
                    Lil();
                }
            }
        }
        int i = f5588IL1Iii;
        if (i == 1) {
            return f5589ILil;
        }
        if (i == 2) {
            throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
        }
        if (i == 3) {
            return StaticLoggerBinder.getSingleton().getLoggerFactory();
        }
        if (i == 4) {
            return f5587I1I;
        }
        throw new IllegalStateException("Unreachable code");
    }

    public static final void Lil() {
        IL1Iii();
        if (f5588IL1Iii == 3) {
            iIlLiL();
        }
    }

    public static void LlLI1() {
        LinkedBlockingQueue<IL> linkedBlockingQueueI1I = f5589ILil.I1I();
        int size = linkedBlockingQueueI1I.size();
        ArrayList<IL> arrayList = new ArrayList(128);
        int i = 0;
        while (linkedBlockingQueueI1I.drainTo(arrayList, 128) != 0) {
            for (IL il : arrayList) {
                m3685llL1ii(il);
                int i2 = i + 1;
                if (i == 0) {
                    ILil(il, size);
                }
                i = i2;
            }
            arrayList.clear();
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static boolean m3680Ll1() {
        String strM3695iILLL1 = IiL.m3695iILLL1("java.vendor.url");
        if (strM3695iILLL1 == null) {
            return false;
        }
        return strM3695iILLL1.toLowerCase().contains("android");
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static ILil m3681L11I(Class<?> cls) {
        Class<?> clsIL1Iii;
        ILil iLilM3687il = m3687il(cls.getName());
        if (f3064IL && (clsIL1Iii = IiL.IL1Iii()) != null && m3677ILl(cls, clsIL1Iii)) {
            IiL.I1I(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", iLilM3687il.getName(), clsIL1Iii.getName()));
            IiL.I1I("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
        }
        return iLilM3687il;
    }

    public static void iIi1(Set<URL> set) {
        if (ILL(set)) {
            IiL.I1I("Class path contains multiple SLF4J bindings.");
            Iterator<URL> it = set.iterator();
            while (it.hasNext()) {
                IiL.I1I("Found binding in [" + it.next() + "]");
            }
            IiL.I1I("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    public static final void iIlLiL() {
        try {
            String str = StaticLoggerBinder.REQUESTED_API_VERSION;
            boolean z = false;
            for (String str2 : f5590Ilil) {
                if (str.startsWith(str2)) {
                    z = true;
                }
            }
            if (z) {
                return;
            }
            IiL.I1I("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(f5590Ilil).toString());
            IiL.I1I("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th) {
            IiL.m3694IL("Unexpected problem occured during version sanity check", th);
        }
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static void m3682iILLL1() {
        iILLL1 iilll1 = f5589ILil;
        synchronized (iilll1) {
            iilll1.Ilil();
            for (lLi1LL lli1ll : iilll1.m3697IL()) {
                lli1ll.m3699iILLL1(m3687il(lli1ll.getName()));
            }
        }
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public static boolean m3683lIiI(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("org/slf4j/impl/StaticLoggerBinder") || str.contains("org.slf4j.impl.StaticLoggerBinder");
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public static void m3684lIlii(Set<URL> set) {
        if (set == null || !ILL(set)) {
            return;
        }
        IiL.I1I("Actual binding is of type [" + StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr() + "]");
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public static void m3685llL1ii(IL il) {
        if (il == null) {
            return;
        }
        lLi1LL lli1llIL1Iii = il.IL1Iii();
        String name = lli1llIL1Iii.getName();
        if (lli1llIL1Iii.Ilil()) {
            throw new IllegalStateException("Delegate logger cannot be null at this state.");
        }
        if (lli1llIL1Iii.m3698IL()) {
            return;
        }
        if (lli1llIL1Iii.I1I()) {
            lli1llIL1Iii.m3700lLi1LL(il);
        } else {
            IiL.I1I(name);
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static Set<URL> m3686lLi1LL() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = I1I.class.getClassLoader();
            Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources(f3065lLi1LL) : classLoader.getResources(f3065lLi1LL);
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add(systemResources.nextElement());
            }
        } catch (IOException e) {
            IiL.m3694IL("Error getting resources from path", e);
        }
        return linkedHashSet;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static ILil m3687il(String str) {
        return m3679IiL().IL1Iii(str);
    }
}
