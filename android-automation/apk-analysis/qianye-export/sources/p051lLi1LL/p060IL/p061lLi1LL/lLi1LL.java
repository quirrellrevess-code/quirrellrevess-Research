package p051lLi1LL.p060IL.p061lLi1LL;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;
import p051lLi1LL.p060IL.ILil;
import p051lLi1LL.p060IL.Ilil.I1I;
import p051lLi1LL.p060IL.Ilil.IL;
import p051lLi1LL.p060IL.Ilil.IL1Iii;

/* JADX INFO: renamed from: l丨Li1LL.I丨L.l丨Li1LL.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: SubstituteLogger.java */
/* JADX INFO: loaded from: classes.dex */
public class lLi1LL implements ILil {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public volatile ILil f5602I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final String f5603ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public Method f5604Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Boolean f3067IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final boolean f3068IiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public Queue<IL> f3069iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public IL1Iii f3070lLi1LL;

    public lLi1LL(String str, Queue<IL> queue, boolean z) {
        this.f5603ILil = str;
        this.f3069iILLL1 = queue;
        this.f3068IiL = z;
    }

    public boolean I1I() {
        Boolean bool = this.f3067IL;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.f5604Ilil = this.f5602I1I.getClass().getMethod("log", I1I.class);
            this.f3067IL = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.f3067IL = Boolean.FALSE;
        }
        return this.f3067IL.booleanValue();
    }

    public ILil IL1Iii() {
        if (this.f5602I1I != null) {
            return this.f5602I1I;
        }
        return this.f3068IiL ? ILil.NOP_LOGGER : ILil();
    }

    public final ILil ILil() {
        if (this.f3070lLi1LL == null) {
            this.f3070lLi1LL = new IL1Iii(this, this.f3069iILLL1);
        }
        return this.f3070lLi1LL;
    }

    public boolean Ilil() {
        return this.f5602I1I == null;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean m3698IL() {
        return this.f5602I1I instanceof ILil;
    }

    @Override // p051lLi1LL.p060IL.ILil
    public void debug(String str) {
        IL1Iii().debug(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && lLi1LL.class == obj.getClass() && this.f5603ILil.equals(((lLi1LL) obj).f5603ILil);
    }

    @Override // p051lLi1LL.p060IL.ILil
    public void error(String str) {
        IL1Iii().error(str);
    }

    @Override // p051lLi1LL.p060IL.ILil
    public String getName() {
        return this.f5603ILil;
    }

    public int hashCode() {
        return this.f5603ILil.hashCode();
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m3699iILLL1(ILil iLil) {
        this.f5602I1I = iLil;
    }

    @Override // p051lLi1LL.p060IL.ILil
    public void info(String str) {
        IL1Iii().info(str);
    }

    @Override // p051lLi1LL.p060IL.ILil
    public boolean isDebugEnabled() {
        return IL1Iii().isDebugEnabled();
    }

    @Override // p051lLi1LL.p060IL.ILil
    public boolean isErrorEnabled() {
        return IL1Iii().isErrorEnabled();
    }

    @Override // p051lLi1LL.p060IL.ILil
    public boolean isInfoEnabled() {
        return IL1Iii().isInfoEnabled();
    }

    @Override // p051lLi1LL.p060IL.ILil
    public boolean isTraceEnabled() {
        return IL1Iii().isTraceEnabled();
    }

    @Override // p051lLi1LL.p060IL.ILil
    public boolean isWarnEnabled() {
        return IL1Iii().isWarnEnabled();
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void m3700lLi1LL(I1I i1i) {
        if (I1I()) {
            try {
                this.f5604Ilil.invoke(this.f5602I1I, i1i);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    @Override // p051lLi1LL.p060IL.ILil
    public void trace(String str) {
        IL1Iii().trace(str);
    }

    @Override // p051lLi1LL.p060IL.ILil
    public void warn(String str) {
        IL1Iii().warn(str);
    }

    @Override // p051lLi1LL.p060IL.ILil
    public void debug(String str, Throwable th) {
        IL1Iii().debug(str, th);
    }

    @Override // p051lLi1LL.p060IL.ILil
    public void error(String str, Throwable th) {
        IL1Iii().error(str, th);
    }

    @Override // p051lLi1LL.p060IL.ILil
    public void info(String str, Throwable th) {
        IL1Iii().info(str, th);
    }

    @Override // p051lLi1LL.p060IL.ILil
    public void trace(String str, Object obj) {
        IL1Iii().trace(str, obj);
    }

    @Override // p051lLi1LL.p060IL.ILil
    public void warn(String str, Throwable th) {
        IL1Iii().warn(str, th);
    }

    @Override // p051lLi1LL.p060IL.ILil
    public void trace(String str, Object obj, Object obj2) {
        IL1Iii().trace(str, obj, obj2);
    }

    @Override // p051lLi1LL.p060IL.ILil
    public void trace(String str, Throwable th) {
        IL1Iii().trace(str, th);
    }
}
