package p047IL;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: Dispatcher.java */
/* JADX INFO: loaded from: classes.dex */
public final class I11li1 {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    @Nullable
    public Runnable f4600I1I;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    @Nullable
    public ExecutorService f2069IL;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public int f4601IL1Iii = 64;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f4602ILil = 5;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final Deque<l1IIi1.IL1Iii> f4603Ilil = new ArrayDeque();

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final Deque<l1IIi1.IL1Iii> f2071lLi1LL = new ArrayDeque();

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final Deque<l1IIi1> f2070iILLL1 = new ArrayDeque();

    public synchronized ExecutorService I1I() {
        if (this.f2069IL == null) {
            this.f2069IL = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
        }
        return this.f2069IL;
    }

    public void IL1Iii(l1IIi1.IL1Iii iL1Iii) {
        l1IIi1.IL1Iii iL1IiiM2837IL;
        synchronized (this) {
            this.f4603Ilil.add(iL1Iii);
            if (!iL1Iii.I1I().f4657Ilil && (iL1IiiM2837IL = m2837IL(iL1Iii.m2900IL())) != null) {
                iL1Iii.Ilil(iL1IiiM2837IL);
            }
        }
        m2838IiL();
    }

    public synchronized void ILil(l1IIi1 l1iii1) {
        this.f2070iILLL1.add(l1iii1);
    }

    public final <T> void Ilil(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.f4600I1I;
        }
        if (m2838IiL() || runnable == null) {
            return;
        }
        runnable.run();
    }

    @Nullable
    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final l1IIi1.IL1Iii m2837IL(String str) {
        for (l1IIi1.IL1Iii iL1Iii : this.f2071lLi1LL) {
            if (iL1Iii.m2900IL().equals(str)) {
                return iL1Iii;
            }
        }
        for (l1IIi1.IL1Iii iL1Iii2 : this.f4603Ilil) {
            if (iL1Iii2.m2900IL().equals(str)) {
                return iL1Iii2;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final boolean m2838IiL() {
        int i;
        boolean z;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<l1IIi1.IL1Iii> it = this.f4603Ilil.iterator();
            while (it.hasNext()) {
                l1IIi1.IL1Iii next = it.next();
                if (this.f2071lLi1LL.size() >= this.f4601IL1Iii) {
                    break;
                }
                if (next.IL1Iii().get() < this.f4602ILil) {
                    it.remove();
                    next.IL1Iii().incrementAndGet();
                    arrayList.add(next);
                    this.f2071lLi1LL.add(next);
                }
            }
            z = m2839L11I() > 0;
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((l1IIi1.IL1Iii) arrayList.get(i)).ILil(I1I());
        }
        return z;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public synchronized int m2839L11I() {
        return this.f2071lLi1LL.size() + this.f2070iILLL1.size();
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m2840iILLL1(l1IIi1 l1iii1) {
        Ilil(this.f2070iILLL1, l1iii1);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void m2841lLi1LL(l1IIi1.IL1Iii iL1Iii) {
        iL1Iii.IL1Iii().decrementAndGet();
        Ilil(this.f2071lLi1LL, iL1Iii);
    }
}
