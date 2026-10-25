package p051lLi1LL.ILil.IL1Iii;

import java.lang.reflect.Method;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: SubscriberMethod.java */
/* JADX INFO: loaded from: classes.dex */
public class LlLI1 {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final Class<?> f5563I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Method f5564IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final ThreadMode f5565ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final boolean f5566Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final int f3057IL;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public String f3058lLi1LL;

    public LlLI1(Method method, Class<?> cls, ThreadMode threadMode, int i, boolean z) {
        this.f5564IL1Iii = method;
        this.f5565ILil = threadMode;
        this.f5563I1I = cls;
        this.f3057IL = i;
        this.f5566Ilil = z;
    }

    public final synchronized void IL1Iii() {
        if (this.f3058lLi1LL == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f5564IL1Iii.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f5564IL1Iii.getName());
            sb.append('(');
            sb.append(this.f5563I1I.getName());
            this.f3058lLi1LL = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LlLI1)) {
            return false;
        }
        IL1Iii();
        LlLI1 llLI1 = (LlLI1) obj;
        llLI1.IL1Iii();
        return this.f3058lLi1LL.equals(llLI1.f3058lLi1LL);
    }

    public int hashCode() {
        return this.f5564IL1Iii.hashCode();
    }
}
