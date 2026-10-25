package com.mysql.jdbc;

import com.google.android.flexbox.BuildConfig;
import java.lang.ref.Reference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class AbandonedConnectionCleanupThread implements Runnable {
    private static final ExecutorService cleanupThreadExcecutorService;
    public static Thread threadRef;

    static {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.mysql.jdbc.AbandonedConnectionCleanupThread.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "Abandoned connection cleanup thread");
                thread.setDaemon(true);
                thread.setContextClassLoader(AbandonedConnectionCleanupThread.class.getClassLoader());
                AbandonedConnectionCleanupThread.threadRef = thread;
                return thread;
            }
        });
        cleanupThreadExcecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new AbandonedConnectionCleanupThread());
    }

    private AbandonedConnectionCleanupThread() {
    }

    private void checkContextClassLoaders() {
        try {
            threadRef.getContextClassLoader().getResource(BuildConfig.FLAVOR);
        } catch (Throwable unused) {
            uncheckedShutdown();
        }
    }

    public static void checkedShutdown() {
        shutdown(true);
    }

    private static boolean consistentClassLoaders() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        ClassLoader contextClassLoader2 = threadRef.getContextClassLoader();
        return (contextClassLoader == null || contextClassLoader2 == null || contextClassLoader != contextClassLoader2) ? false : true;
    }

    private static void shutdown(boolean z) {
        if (!z || consistentClassLoaders()) {
            cleanupThreadExcecutorService.shutdownNow();
        }
    }

    public static void uncheckedShutdown() {
        shutdown(false);
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                checkContextClassLoaders();
                Reference<? extends ConnectionImpl> referenceRemove = NonRegisteringDriver.refQueue.remove(5000L);
                if (referenceRemove != null) {
                    try {
                        ((NonRegisteringDriver.ConnectionPhantomReference) referenceRemove).cleanup();
                        NonRegisteringDriver.connectionPhantomRefs.remove(referenceRemove);
                    } catch (Throwable th) {
                        NonRegisteringDriver.connectionPhantomRefs.remove(referenceRemove);
                        throw th;
                    }
                } else {
                    continue;
                }
            } catch (InterruptedException unused) {
                threadRef = null;
                return;
            } catch (Exception unused2) {
            }
        }
    }

    @Deprecated
    public static void shutdown() {
        checkedShutdown();
    }
}
