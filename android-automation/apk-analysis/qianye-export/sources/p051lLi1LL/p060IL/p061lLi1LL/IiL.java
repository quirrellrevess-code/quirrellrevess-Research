package p051lLi1LL.p060IL.p061lLi1LL;

/* JADX INFO: renamed from: l丨Li1LL.I丨L.l丨Li1LL.I丨iL, reason: invalid class name */
/* JADX INFO: compiled from: Util.java */
/* JADX INFO: loaded from: classes.dex */
public final class IiL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static ILil f5597IL1Iii = null;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static boolean f5598ILil = false;

    /* JADX INFO: renamed from: l丨Li1LL.I丨L.l丨Li1LL.I丨iL$ILil */
    /* JADX INFO: compiled from: Util.java */
    public static final class ILil extends SecurityManager {
        public ILil() {
        }

        @Override // java.lang.SecurityManager
        public Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }

    public static final void I1I(String str) {
        System.err.println("SLF4J: " + str);
    }

    public static Class<?> IL1Iii() {
        int i;
        ILil ILil2 = ILil();
        if (ILil2 == null) {
            return null;
        }
        Class<?>[] classContext = ILil2.getClassContext();
        String name = IiL.class.getName();
        int i2 = 0;
        while (i2 < classContext.length && !name.equals(classContext[i2].getName())) {
            i2++;
        }
        if (i2 >= classContext.length || (i = i2 + 2) >= classContext.length) {
            throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
        }
        return classContext[i];
    }

    public static ILil ILil() {
        ILil iLil = f5597IL1Iii;
        if (iLil != null) {
            return iLil;
        }
        if (f5598ILil) {
            return null;
        }
        ILil Ilil2 = Ilil();
        f5597IL1Iii = Ilil2;
        f5598ILil = true;
        return Ilil2;
    }

    public static ILil Ilil() {
        try {
            return new ILil();
        } catch (SecurityException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static final void m3694IL(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static String m3695iILLL1(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null input");
        }
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static boolean m3696lLi1LL(String str) {
        String strM3695iILLL1 = m3695iILLL1(str);
        if (strM3695iILLL1 == null) {
            return false;
        }
        return strM3695iILLL1.equalsIgnoreCase("true");
    }
}
