package ILil.I1I.IL1Iii.IL1Iii;

import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: DefaultTaskExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil extends I1I {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Object f3604IL1Iii = new Object();

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final ExecutorService f3605ILil = Executors.newFixedThreadPool(2, new IL1Iii(this));

    /* JADX INFO: compiled from: DefaultTaskExecutor.java */
    public class IL1Iii implements ThreadFactory {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final AtomicInteger f3606IL1Iii = new AtomicInteger(0);

        public IL1Iii(ILil iLil) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.f3606IL1Iii.getAndIncrement())));
            return thread;
        }
    }

    @Override // ILil.I1I.IL1Iii.IL1Iii.I1I
    public boolean IL1Iii() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
