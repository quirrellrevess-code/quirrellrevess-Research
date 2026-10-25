package p066Ilil;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: AsyncTimeout.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii extends lL {
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;

    @Nullable
    public static IL1Iii head;
    private boolean inQueue;

    @Nullable
    private IL1Iii next;
    private long timeoutAt;

    /* JADX INFO: compiled from: AsyncTimeout.java */
    public static final class I1I extends Thread {
        public I1I() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
        
            r1.timedOut();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<Ilil.IL1Iii> r0 = p066Ilil.IL1Iii.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                Ilil.IL1Iii r1 = p066Ilil.IL1Iii.awaitTimeout()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                Ilil.IL1Iii r2 = p066Ilil.IL1Iii.head     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                p066Ilil.IL1Iii.head = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.timedOut()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                throw r1     // Catch: java.lang.InterruptedException -> L0
            */
            throw new UnsupportedOperationException("Method not decompiled: Ilil.IL1Iii.I1I.run():void");
        }
    }

    /* JADX INFO: renamed from: Ilil.IL1Iii$IL1Iii, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AsyncTimeout.java */
    public class C0591IL1Iii implements iIlLiL {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ iIlLiL f4567ILil;

        public C0591IL1Iii(iIlLiL iillil) {
            this.f4567ILil = iillil;
        }

        @Override // p066Ilil.iIlLiL, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            IL1Iii.this.enter();
            try {
                try {
                    this.f4567ILil.close();
                    IL1Iii.this.exit(true);
                } catch (IOException e) {
                    throw IL1Iii.this.exit(e);
                }
            } catch (Throwable th) {
                IL1Iii.this.exit(false);
                throw th;
            }
        }

        @Override // p066Ilil.iIlLiL, java.io.Flushable
        public void flush() throws IOException {
            IL1Iii.this.enter();
            try {
                try {
                    this.f4567ILil.flush();
                    IL1Iii.this.exit(true);
                } catch (IOException e) {
                    throw IL1Iii.this.exit(e);
                }
            } catch (Throwable th) {
                IL1Iii.this.exit(false);
                throw th;
            }
        }

        @Override // p066Ilil.iIlLiL
        public lL timeout() {
            return IL1Iii.this;
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f4567ILil + ")";
        }

        @Override // p066Ilil.iIlLiL
        public void write(p066Ilil.I1I i1i, long j) throws IOException {
            I11L.ILil(i1i.f4559I1I, 0L, j);
            while (true) {
                long j2 = 0;
                if (j <= 0) {
                    return;
                }
                llL1ii lll1ii = i1i.f4560ILil;
                while (j2 < 65536) {
                    j2 += (long) (lll1ii.f4594I1I - lll1ii.f4596ILil);
                    if (j2 >= j) {
                        j2 = j;
                        break;
                    }
                    lll1ii = lll1ii.f2068lLi1LL;
                }
                IL1Iii.this.enter();
                try {
                    try {
                        this.f4567ILil.write(i1i, j2);
                        j -= j2;
                        IL1Iii.this.exit(true);
                    } catch (IOException e) {
                        throw IL1Iii.this.exit(e);
                    }
                } catch (Throwable th) {
                    IL1Iii.this.exit(false);
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: compiled from: AsyncTimeout.java */
    public class ILil implements I11li1 {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ I11li1 f4569ILil;

        public ILil(I11li1 i11li1) {
            this.f4569ILil = i11li1;
        }

        @Override // p066Ilil.I11li1, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            IL1Iii.this.enter();
            try {
                try {
                    this.f4569ILil.close();
                    IL1Iii.this.exit(true);
                } catch (IOException e) {
                    throw IL1Iii.this.exit(e);
                }
            } catch (Throwable th) {
                IL1Iii.this.exit(false);
                throw th;
            }
        }

        @Override // p066Ilil.I11li1
        public long read(p066Ilil.I1I i1i, long j) throws IOException {
            IL1Iii.this.enter();
            try {
                try {
                    long j2 = this.f4569ILil.read(i1i, j);
                    IL1Iii.this.exit(true);
                    return j2;
                } catch (IOException e) {
                    throw IL1Iii.this.exit(e);
                }
            } catch (Throwable th) {
                IL1Iii.this.exit(false);
                throw th;
            }
        }

        @Override // p066Ilil.I11li1, p066Ilil.iIlLiL
        public lL timeout() {
            return IL1Iii.this;
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f4569ILil + ")";
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    @Nullable
    public static IL1Iii awaitTimeout() throws InterruptedException {
        IL1Iii iL1Iii = head.next;
        if (iL1Iii == null) {
            long jNanoTime = System.nanoTime();
            IL1Iii.class.wait(IDLE_TIMEOUT_MILLIS);
            if (head.next != null || System.nanoTime() - jNanoTime < IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return head;
        }
        long jRemainingNanos = iL1Iii.remainingNanos(System.nanoTime());
        if (jRemainingNanos > 0) {
            long j = jRemainingNanos / 1000000;
            IL1Iii.class.wait(j, (int) (jRemainingNanos - (1000000 * j)));
            return null;
        }
        head.next = iL1Iii.next;
        iL1Iii.next = null;
        return iL1Iii;
    }

    private static synchronized boolean cancelScheduledTimeout(IL1Iii iL1Iii) {
        IL1Iii iL1Iii2 = head;
        while (iL1Iii2 != null) {
            IL1Iii iL1Iii3 = iL1Iii2.next;
            if (iL1Iii3 == iL1Iii) {
                iL1Iii2.next = iL1Iii.next;
                iL1Iii.next = null;
                return false;
            }
            iL1Iii2 = iL1Iii3;
        }
        return true;
    }

    private long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    private static synchronized void scheduleTimeout(IL1Iii iL1Iii, long j, boolean z) {
        if (head == null) {
            head = new IL1Iii();
            new I1I().start();
        }
        long jNanoTime = System.nanoTime();
        if (j != 0 && z) {
            iL1Iii.timeoutAt = Math.min(j, iL1Iii.deadlineNanoTime() - jNanoTime) + jNanoTime;
        } else if (j != 0) {
            iL1Iii.timeoutAt = j + jNanoTime;
        } else {
            if (!z) {
                throw new AssertionError();
            }
            iL1Iii.timeoutAt = iL1Iii.deadlineNanoTime();
        }
        long jRemainingNanos = iL1Iii.remainingNanos(jNanoTime);
        IL1Iii iL1Iii2 = head;
        while (true) {
            IL1Iii iL1Iii3 = iL1Iii2.next;
            if (iL1Iii3 == null || jRemainingNanos < iL1Iii3.remainingNanos(jNanoTime)) {
                break;
                break;
            }
            iL1Iii2 = iL1Iii2.next;
        }
        iL1Iii.next = iL1Iii2.next;
        iL1Iii2.next = iL1Iii;
        if (iL1Iii2 == head) {
            IL1Iii.class.notify();
        }
    }

    public final void enter() {
        if (this.inQueue) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long jTimeoutNanos = timeoutNanos();
        boolean zHasDeadline = hasDeadline();
        if (jTimeoutNanos != 0 || zHasDeadline) {
            this.inQueue = true;
            scheduleTimeout(this, jTimeoutNanos, zHasDeadline);
        }
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return cancelScheduledTimeout(this);
    }

    public IOException newTimeoutException(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final iIlLiL sink(iIlLiL iillil) {
        return new C0591IL1Iii(iillil);
    }

    public final I11li1 source(I11li1 i11li1) {
        return new ILil(i11li1);
    }

    public void timedOut() {
    }

    public final void exit(boolean z) throws IOException {
        if (exit() && z) {
            throw newTimeoutException(null);
        }
    }

    public final IOException exit(IOException iOException) throws IOException {
        return !exit() ? iOException : newTimeoutException(iOException);
    }
}
