package p051lLi1LL.p060IL.p061lLi1LL;

import java.io.ObjectStreamException;
import java.io.Serializable;
import p051lLi1LL.p060IL.I1I;
import p051lLi1LL.p060IL.ILil;

/* JADX INFO: renamed from: l丨Li1LL.I丨L.l丨Li1LL.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: NamedLoggerBase.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class IL implements ILil, Serializable {
    private static final long serialVersionUID = 7535258609338176893L;
    public String name;

    @Override // p051lLi1LL.p060IL.ILil
    public abstract /* synthetic */ void debug(String str);

    public abstract /* synthetic */ void debug(String str, Object obj);

    public abstract /* synthetic */ void debug(String str, Object obj, Object obj2);

    @Override // p051lLi1LL.p060IL.ILil
    public abstract /* synthetic */ void debug(String str, Throwable th);

    public abstract /* synthetic */ void debug(String str, Object... objArr);

    public abstract /* synthetic */ void debug(p051lLi1LL.p060IL.IL il, String str);

    public abstract /* synthetic */ void debug(p051lLi1LL.p060IL.IL il, String str, Object obj);

    public abstract /* synthetic */ void debug(p051lLi1LL.p060IL.IL il, String str, Object obj, Object obj2);

    public abstract /* synthetic */ void debug(p051lLi1LL.p060IL.IL il, String str, Throwable th);

    public abstract /* synthetic */ void debug(p051lLi1LL.p060IL.IL il, String str, Object... objArr);

    @Override // p051lLi1LL.p060IL.ILil
    public abstract /* synthetic */ void error(String str);

    public abstract /* synthetic */ void error(String str, Object obj);

    public abstract /* synthetic */ void error(String str, Object obj, Object obj2);

    @Override // p051lLi1LL.p060IL.ILil
    public abstract /* synthetic */ void error(String str, Throwable th);

    public abstract /* synthetic */ void error(String str, Object... objArr);

    public abstract /* synthetic */ void error(p051lLi1LL.p060IL.IL il, String str);

    public abstract /* synthetic */ void error(p051lLi1LL.p060IL.IL il, String str, Object obj);

    public abstract /* synthetic */ void error(p051lLi1LL.p060IL.IL il, String str, Object obj, Object obj2);

    public abstract /* synthetic */ void error(p051lLi1LL.p060IL.IL il, String str, Throwable th);

    public abstract /* synthetic */ void error(p051lLi1LL.p060IL.IL il, String str, Object... objArr);

    @Override // p051lLi1LL.p060IL.ILil
    public String getName() {
        return this.name;
    }

    @Override // p051lLi1LL.p060IL.ILil
    public abstract /* synthetic */ void info(String str);

    public abstract /* synthetic */ void info(String str, Object obj);

    public abstract /* synthetic */ void info(String str, Object obj, Object obj2);

    @Override // p051lLi1LL.p060IL.ILil
    public abstract /* synthetic */ void info(String str, Throwable th);

    public abstract /* synthetic */ void info(String str, Object... objArr);

    public abstract /* synthetic */ void info(p051lLi1LL.p060IL.IL il, String str);

    public abstract /* synthetic */ void info(p051lLi1LL.p060IL.IL il, String str, Object obj);

    public abstract /* synthetic */ void info(p051lLi1LL.p060IL.IL il, String str, Object obj, Object obj2);

    public abstract /* synthetic */ void info(p051lLi1LL.p060IL.IL il, String str, Throwable th);

    public abstract /* synthetic */ void info(p051lLi1LL.p060IL.IL il, String str, Object... objArr);

    @Override // p051lLi1LL.p060IL.ILil
    public abstract /* synthetic */ boolean isDebugEnabled();

    public abstract /* synthetic */ boolean isDebugEnabled(p051lLi1LL.p060IL.IL il);

    @Override // p051lLi1LL.p060IL.ILil
    public abstract /* synthetic */ boolean isErrorEnabled();

    public abstract /* synthetic */ boolean isErrorEnabled(p051lLi1LL.p060IL.IL il);

    @Override // p051lLi1LL.p060IL.ILil
    public abstract /* synthetic */ boolean isInfoEnabled();

    public abstract /* synthetic */ boolean isInfoEnabled(p051lLi1LL.p060IL.IL il);

    @Override // p051lLi1LL.p060IL.ILil
    public abstract /* synthetic */ boolean isTraceEnabled();

    public abstract /* synthetic */ boolean isTraceEnabled(p051lLi1LL.p060IL.IL il);

    @Override // p051lLi1LL.p060IL.ILil
    public abstract /* synthetic */ boolean isWarnEnabled();

    public abstract /* synthetic */ boolean isWarnEnabled(p051lLi1LL.p060IL.IL il);

    public Object readResolve() throws ObjectStreamException {
        return I1I.m3687il(getName());
    }

    @Override // p051lLi1LL.p060IL.ILil
    public abstract /* synthetic */ void trace(String str);

    @Override // p051lLi1LL.p060IL.ILil
    public abstract /* synthetic */ void trace(String str, Object obj);

    @Override // p051lLi1LL.p060IL.ILil
    public abstract /* synthetic */ void trace(String str, Object obj, Object obj2);

    @Override // p051lLi1LL.p060IL.ILil
    public abstract /* synthetic */ void trace(String str, Throwable th);

    public abstract /* synthetic */ void trace(String str, Object... objArr);

    public abstract /* synthetic */ void trace(p051lLi1LL.p060IL.IL il, String str);

    public abstract /* synthetic */ void trace(p051lLi1LL.p060IL.IL il, String str, Object obj);

    public abstract /* synthetic */ void trace(p051lLi1LL.p060IL.IL il, String str, Object obj, Object obj2);

    public abstract /* synthetic */ void trace(p051lLi1LL.p060IL.IL il, String str, Throwable th);

    public abstract /* synthetic */ void trace(p051lLi1LL.p060IL.IL il, String str, Object... objArr);

    @Override // p051lLi1LL.p060IL.ILil
    public abstract /* synthetic */ void warn(String str);

    public abstract /* synthetic */ void warn(String str, Object obj);

    public abstract /* synthetic */ void warn(String str, Object obj, Object obj2);

    @Override // p051lLi1LL.p060IL.ILil
    public abstract /* synthetic */ void warn(String str, Throwable th);

    public abstract /* synthetic */ void warn(String str, Object... objArr);

    public abstract /* synthetic */ void warn(p051lLi1LL.p060IL.IL il, String str);

    public abstract /* synthetic */ void warn(p051lLi1LL.p060IL.IL il, String str, Object obj);

    public abstract /* synthetic */ void warn(p051lLi1LL.p060IL.IL il, String str, Object obj, Object obj2);

    public abstract /* synthetic */ void warn(p051lLi1LL.p060IL.IL il, String str, Throwable th);

    public abstract /* synthetic */ void warn(p051lLi1LL.p060IL.IL il, String str, Object... objArr);
}
