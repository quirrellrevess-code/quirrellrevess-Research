package ILil.p028IiL.ILL;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: SelfDestructiveThread.java */
/* JADX INFO: loaded from: classes.dex */
public class I1I {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Handler f3999I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public HandlerThread f4001ILil;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final String f1600IiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final int f1601iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final int f1602lLi1LL;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Object f4000IL1Iii = new Object();

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public Handler.Callback f4002Ilil = new IL1Iii();

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f1599IL = 0;

    /* JADX INFO: renamed from: ILil.I丨iL.ILL.I1I$I1I, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SelfDestructiveThread.java */
    public class RunnableC0560I1I implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ Callable f4003I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f4004ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f4005Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final /* synthetic */ ReentrantLock f1603IL;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public final /* synthetic */ Condition f1604lLi1LL;

        public RunnableC0560I1I(I1I i1i, AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
            this.f4004ILil = atomicReference;
            this.f4003I1I = callable;
            this.f1603IL = reentrantLock;
            this.f4005Ilil = atomicBoolean;
            this.f1604lLi1LL = condition;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f4004ILil.set(this.f4003I1I.call());
            } catch (Exception unused) {
            }
            this.f1603IL.lock();
            try {
                this.f4005Ilil.set(false);
                this.f1604lLi1LL.signal();
            } finally {
                this.f1603IL.unlock();
            }
        }
    }

    /* JADX INFO: compiled from: SelfDestructiveThread.java */
    public class IL1Iii implements Handler.Callback {
        public IL1Iii() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                I1I.this.IL1Iii();
                return true;
            }
            if (i != 1) {
                return true;
            }
            I1I.this.ILil((Runnable) message.obj);
            return true;
        }
    }

    /* JADX INFO: compiled from: SelfDestructiveThread.java */
    public class ILil implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ Handler f4007I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ Callable f4008ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final /* synthetic */ IL f1605IL;

        /* JADX INFO: compiled from: SelfDestructiveThread.java */
        public class IL1Iii implements Runnable {

            /* JADX INFO: renamed from: ILil, reason: collision with root package name */
            public final /* synthetic */ Object f4010ILil;

            public IL1Iii(Object obj) {
                this.f4010ILil = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                ILil.this.f1605IL.IL1Iii(this.f4010ILil);
            }
        }

        public ILil(I1I i1i, Callable callable, Handler handler, IL il) {
            this.f4008ILil = callable;
            this.f4007I1I = handler;
            this.f1605IL = il;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object objCall;
            try {
                objCall = this.f4008ILil.call();
            } catch (Exception unused) {
                objCall = null;
            }
            this.f4007I1I.post(new IL1Iii(objCall));
        }
    }

    /* JADX INFO: renamed from: ILil.I丨iL.ILL.I1I$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: SelfDestructiveThread.java */
    public interface IL<T> {
        void IL1Iii(T t);
    }

    public I1I(String str, int i, int i2) {
        this.f1600IiL = str;
        this.f1601iILLL1 = i;
        this.f1602lLi1LL = i2;
    }

    public final void I1I(Runnable runnable) {
        synchronized (this.f4000IL1Iii) {
            if (this.f4001ILil == null) {
                HandlerThread handlerThread = new HandlerThread(this.f1600IiL, this.f1601iILLL1);
                this.f4001ILil = handlerThread;
                handlerThread.start();
                this.f3999I1I = new Handler(this.f4001ILil.getLooper(), this.f4002Ilil);
                this.f1599IL++;
            }
            this.f3999I1I.removeMessages(0);
            Handler handler = this.f3999I1I;
            handler.sendMessage(handler.obtainMessage(1, runnable));
        }
    }

    public void IL1Iii() {
        synchronized (this.f4000IL1Iii) {
            if (this.f3999I1I.hasMessages(1)) {
                return;
            }
            this.f4001ILil.quit();
            this.f4001ILil = null;
            this.f3999I1I = null;
        }
    }

    public void ILil(Runnable runnable) {
        runnable.run();
        synchronized (this.f4000IL1Iii) {
            this.f3999I1I.removeMessages(0);
            Handler handler = this.f3999I1I;
            handler.sendMessageDelayed(handler.obtainMessage(0), this.f1602lLi1LL);
        }
    }

    public <T> T Ilil(Callable<T> callable, int i) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition conditionNewCondition = reentrantLock.newCondition();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        I1I(new RunnableC0560I1I(this, atomicReference, callable, reentrantLock, atomicBoolean, conditionNewCondition));
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                T t = (T) atomicReference.get();
                reentrantLock.unlock();
                return t;
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos(i);
            do {
                try {
                    nanos = conditionNewCondition.awaitNanos(nanos);
                } catch (InterruptedException unused) {
                }
                if (!atomicBoolean.get()) {
                    T t2 = (T) atomicReference.get();
                    reentrantLock.unlock();
                    return t2;
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public <T> void m2012IL(Callable<T> callable, IL<T> il) {
        I1I(new ILil(this, callable, new Handler(), il));
    }
}
