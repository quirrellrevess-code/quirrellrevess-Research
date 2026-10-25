package I1I.I1I.p008IL;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: renamed from: I1I.I1I.I丨L.丨il, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: MainThreadRunner.java */
/* JADX INFO: loaded from: classes.dex */
public class C0610il {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Handler f3389IL1Iii = new Handler(Looper.getMainLooper());

    public final boolean IL1Iii() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public <T> T ILil(Callable<T> callable) {
        if (IL1Iii()) {
            try {
                return callable.call();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        FutureTask futureTask = new FutureTask(callable);
        this.f3389IL1Iii.post(futureTask);
        try {
            return (T) futureTask.get();
        } catch (InterruptedException | ExecutionException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
