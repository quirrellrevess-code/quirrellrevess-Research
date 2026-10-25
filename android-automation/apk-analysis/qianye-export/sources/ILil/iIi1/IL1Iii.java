package ILil.iIi1;

import ILil.p065Ilil.Ll1;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: VersionedParcel.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class IL1Iii {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final Ll1<String, Class> f4324I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Ll1<String, Method> f4325IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final Ll1<String, Method> f4326ILil;

    public IL1Iii(Ll1<String, Method> ll1, Ll1<String, Method> ll2, Ll1<String, Class> ll3) {
        this.f4325IL1Iii = ll1;
        this.f4326ILil = ll2;
        this.f4324I1I = ll3;
    }

    public abstract void I11L(int i);

    public <T extends I1I> T I11li1() {
        String strIIi1 = iIi1();
        if (strIIi1 == null) {
            return null;
        }
        return (T) m2454ILl(strIIi1, ILil());
    }

    public final Class I1I(Class<? extends I1I> cls) throws ClassNotFoundException {
        Class cls2 = this.f4324I1I.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f4324I1I.put(cls.getName(), cls3);
        return cls3;
    }

    public abstract void IL1Iii();

    public abstract CharSequence ILL();

    public abstract IL1Iii ILil();

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public <T extends I1I> T m2454ILl(String str, IL1Iii iL1Iii) {
        try {
            return (T) m2456IL(str).invoke(null, iL1Iii);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Method Ilil(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f4326ILil.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class clsI1I = I1I(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsI1I.getDeclaredMethod("write", cls, IL1Iii.class);
        this.f4326ILil.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public <T extends I1I> void m2455IIi(T t, IL1Iii iL1Iii) {
        try {
            Ilil(t.getClass()).invoke(null, t, iL1Iii);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (!(e4.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
            }
            throw ((RuntimeException) e4.getCause());
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final Method m2456IL(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f4325IL1Iii.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, IL1Iii.class.getClassLoader()).getDeclaredMethod("read", IL1Iii.class);
        this.f4325IL1Iii.put(str, declaredMethod);
        return declaredMethod;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public boolean m2457IiL(boolean z, int i) {
        return !mo2467lIiI(i) ? z : mo2464iILLL1();
    }

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public void m2458L111(CharSequence charSequence, int i) {
        I11L(i);
        LL1IL(charSequence);
    }

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public void m2459LIll(I1I i1i) {
        if (i1i == null) {
            mo2461L1l(null);
            return;
        }
        m2478(i1i);
        IL1Iii iL1IiiILil = ILil();
        m2455IIi(i1i, iL1IiiILil);
        iL1IiiILil.IL1Iii();
    }

    public abstract void LL1IL(CharSequence charSequence);

    public abstract int Lil();

    public int LlLI1(int i, int i2) {
        return !mo2467lIiI(i2) ? i : Lil();
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public CharSequence m2460Ll1(CharSequence charSequence, int i) {
        return !mo2467lIiI(i) ? charSequence : ILL();
    }

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public abstract void mo2461L1l(String str);

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public abstract byte[] mo2462L11I();

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public abstract void mo2463LlLLL(byte[] bArr);

    public abstract String iIi1();

    public String iIlLiL(String str, int i) {
        return !mo2467lIiI(i) ? str : iIi1();
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public abstract boolean mo2464iILLL1();

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public void m2465ill(I1I i1i, int i) {
        I11L(i);
        m2459LIll(i1i);
    }

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public void m2466l1IIi1(Parcelable parcelable, int i) {
        I11L(i);
        llI(parcelable);
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public abstract boolean mo2467lIiI(int i);

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public void m2468lIII(byte[] bArr, int i) {
        I11L(i);
        mo2463LlLLL(bArr);
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public <T extends Parcelable> T m2469lIlii(T t, int i) {
        return !mo2467lIiI(i) ? t : (T) mo2470llL1ii();
    }

    public abstract void llI(Parcelable parcelable);

    public void llliI(boolean z, boolean z2) {
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public abstract <T extends Parcelable> T mo2470llL1ii();

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean m2471lLi1LL() {
        return false;
    }

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public void m2472iILLl(String str, int i) {
        I11L(i);
        mo2461L1l(str);
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public byte[] m2473il(byte[] bArr, int i) {
        return !mo2467lIiI(i) ? bArr : mo2462L11I();
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public <T extends I1I> T m2474lL(T t, int i) {
        return !mo2467lIiI(i) ? t : (T) I11li1();
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public abstract void mo2475l(boolean z);

    /* JADX INFO: renamed from: 丨丨 */
    public void m81(int i, int i2) {
        I11L(i2);
        mo2476LLlI1(i);
    }

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public abstract void mo2476LLlI1(int i);

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public void m24771(boolean z, int i) {
        I11L(i);
        mo2475l(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public final void m2478(I1I i1i) {
        try {
            mo2461L1l(I1I(i1i.getClass()).getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(i1i.getClass().getSimpleName() + " does not have a Parcelizer", e);
        }
    }
}
