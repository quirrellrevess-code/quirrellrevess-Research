package p051lLi1LL.p060IL.Ilil;

import java.util.Queue;
import p051lLi1LL.p060IL.IL;
import p051lLi1LL.p060IL.ILil;
import p051lLi1LL.p060IL.p061lLi1LL.lLi1LL;

/* JADX INFO: compiled from: EventRecodingLogger.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii implements ILil {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public lLi1LL f5591I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public String f5592ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Queue<IL> f3066IL;

    public IL1Iii(lLi1LL lli1ll, Queue<IL> queue) {
        this.f5591I1I = lli1ll;
        this.f5592ILil = lli1ll.getName();
        this.f3066IL = queue;
    }

    public final void IL1Iii(ILil iLil, String str, Object[] objArr, Throwable th) {
        ILil(iLil, null, str, objArr, th);
    }

    public final void ILil(ILil iLil, IL il, String str, Object[] objArr, Throwable th) {
        IL il2 = new IL();
        il2.m3693il(System.currentTimeMillis());
        il2.I1I(iLil);
        il2.m3688IL(this.f5591I1I);
        il2.Ilil(this.f5592ILil);
        il2.m3692lLi1LL(il);
        il2.m3691iILLL1(str);
        il2.ILil(objArr);
        il2.m3690L11I(th);
        il2.m3689IiL(Thread.currentThread().getName());
        this.f3066IL.add(il2);
    }

    @Override // p051lLi1LL.p060IL.ILil
    public void debug(String str) {
        IL1Iii(ILil.TRACE, str, null, null);
    }

    @Override // p051lLi1LL.p060IL.ILil
    public void error(String str) {
        IL1Iii(ILil.ERROR, str, null, null);
    }

    @Override // p051lLi1LL.p060IL.ILil
    public String getName() {
        return this.f5592ILil;
    }

    @Override // p051lLi1LL.p060IL.ILil
    public void info(String str) {
        IL1Iii(ILil.INFO, str, null, null);
    }

    @Override // p051lLi1LL.p060IL.ILil
    public boolean isDebugEnabled() {
        return true;
    }

    @Override // p051lLi1LL.p060IL.ILil
    public boolean isErrorEnabled() {
        return true;
    }

    @Override // p051lLi1LL.p060IL.ILil
    public boolean isInfoEnabled() {
        return true;
    }

    @Override // p051lLi1LL.p060IL.ILil
    public boolean isTraceEnabled() {
        return true;
    }

    @Override // p051lLi1LL.p060IL.ILil
    public boolean isWarnEnabled() {
        return true;
    }

    @Override // p051lLi1LL.p060IL.ILil
    public void trace(String str) {
        IL1Iii(ILil.TRACE, str, null, null);
    }

    @Override // p051lLi1LL.p060IL.ILil
    public void warn(String str) {
        IL1Iii(ILil.WARN, str, null, null);
    }

    @Override // p051lLi1LL.p060IL.ILil
    public void debug(String str, Throwable th) {
        IL1Iii(ILil.DEBUG, str, null, th);
    }

    @Override // p051lLi1LL.p060IL.ILil
    public void error(String str, Throwable th) {
        IL1Iii(ILil.ERROR, str, null, th);
    }

    @Override // p051lLi1LL.p060IL.ILil
    public void info(String str, Throwable th) {
        IL1Iii(ILil.INFO, str, null, th);
    }

    @Override // p051lLi1LL.p060IL.ILil
    public void trace(String str, Object obj) {
        IL1Iii(ILil.TRACE, str, new Object[]{obj}, null);
    }

    @Override // p051lLi1LL.p060IL.ILil
    public void warn(String str, Throwable th) {
        IL1Iii(ILil.WARN, str, null, th);
    }

    @Override // p051lLi1LL.p060IL.ILil
    public void trace(String str, Object obj, Object obj2) {
        IL1Iii(ILil.TRACE, str, new Object[]{obj, obj2}, null);
    }

    @Override // p051lLi1LL.p060IL.ILil
    public void trace(String str, Throwable th) {
        IL1Iii(ILil.TRACE, str, null, th);
    }
}
