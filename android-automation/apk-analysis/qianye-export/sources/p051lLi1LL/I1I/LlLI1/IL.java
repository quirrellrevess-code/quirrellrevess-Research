package p051lLi1LL.I1I.LlLI1;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: l丨Li1LL.I1I.LlLI1.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: NamedThreadFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class IL implements ThreadFactory {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final String f5458I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final ThreadFactory f5459IL1Iii = Executors.defaultThreadFactory();

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final AtomicInteger f5460ILil = new AtomicInteger(1);

    public IL(String str) {
        this.f5458I1I = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f5459IL1Iii.newThread(runnable);
        threadNewThread.setName(this.f5458I1I + "-" + this.f5460ILil);
        return threadNewThread;
    }
}
