package com.tencent.smtt.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;

/* JADX INFO: renamed from: com.tencent.smtt.utils.m */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0456m implements Runnable {

    /* JADX INFO: renamed from: a */
    public static String f823a = "TBSFileLock";

    /* JADX INFO: renamed from: f */
    private static Object f824f = new Object();

    /* JADX INFO: renamed from: g */
    private static Object f825g = new Object();

    /* JADX INFO: renamed from: h */
    private static HashMap<RunnableC0456m, Object> f826h;

    /* JADX INFO: renamed from: i */
    private static Handler f827i;

    /* JADX INFO: renamed from: b */
    public File f828b;

    /* JADX INFO: renamed from: c */
    public RandomAccessFile f829c = null;

    /* JADX INFO: renamed from: d */
    public FileLock f830d = null;

    /* JADX INFO: renamed from: e */
    public long f831e = 0;

    public RunnableC0456m(File file, String str) {
        this.f828b = null;
        this.f828b = new File(file, "." + str + ".lock");
    }

    /* JADX INFO: renamed from: a */
    public Handler m783a() {
        if (f827i == null) {
            synchronized (RunnableC0456m.class) {
                if (f827i == null) {
                    HandlerThread handlerThread = new HandlerThread("QBFileLock.Thread");
                    handlerThread.start();
                    f827i = new Handler(handlerThread.getLooper());
                }
            }
        }
        return f827i;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003a A[Catch: all -> 0x0050, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0022, B:10:0x002a, B:11:0x002c, B:13:0x0030, B:17:0x0038, B:18:0x003a, B:20:0x003e, B:22:0x0046, B:24:0x004b, B:16:0x0035, B:9:0x0027), top: B:30:0x0001, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x003e A[Catch: all -> 0x0050, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0022, B:10:0x002a, B:11:0x002c, B:13:0x0030, B:17:0x0038, B:18:0x003a, B:20:0x003e, B:22:0x0046, B:24:0x004b, B:16:0x0035, B:9:0x0027), top: B:30:0x0001, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x004b A[Catch: all -> 0x0050, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0022, B:10:0x002a, B:11:0x002c, B:13:0x0030, B:17:0x0038, B:18:0x003a, B:20:0x003e, B:22:0x0046, B:24:0x004b, B:16:0x0035, B:9:0x0027), top: B:30:0x0001, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    public synchronized void m784a(boolean z) {
        RandomAccessFile randomAccessFile;
        Handler handler;
        Log.d(f823a, ">>> release lock: " + this.f828b.getName());
        FileLock fileLock = this.f830d;
        if (fileLock != null) {
            try {
                fileLock.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f830d = null;
            randomAccessFile = this.f829c;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.f829c = null;
                handler = f827i;
                if (handler != null && this.f831e > 0) {
                    handler.removeCallbacks(this);
                }
                if (z) {
                    m787d();
                }
            } else {
                handler = f827i;
                if (handler != null) {
                    handler.removeCallbacks(this);
                }
                if (z) {
                    m787d();
                }
            }
        } else {
            randomAccessFile = this.f829c;
            if (randomAccessFile != null) {
                randomAccessFile.close();
                this.f829c = null;
                handler = f827i;
                if (handler != null) {
                    handler.removeCallbacks(this);
                }
                if (z) {
                    m787d();
                }
            } else {
                handler = f827i;
                if (handler != null) {
                    handler.removeCallbacks(this);
                }
                if (z) {
                    m787d();
                }
            }
        }
        throw th;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0095 A[Catch: all -> 0x000d, TRY_LEAVE, TryCatch #3 {, blocks: (B:3:0x0001, B:9:0x0014, B:11:0x0018, B:13:0x001e, B:15:0x0026, B:16:0x002f, B:17:0x0034, B:23:0x0048, B:27:0x0050, B:29:0x005f, B:26:0x004d, B:30:0x0066, B:21:0x003c, B:31:0x0091, B:33:0x0095, B:8:0x0011), top: B:38:0x0001, inners: #0, #1, #2 }] */
    /* JADX INFO: renamed from: b */
    public synchronized void m785b() {
        FileChannel channel;
        try {
            this.f829c = new RandomAccessFile(this.f828b, "rw");
        } catch (Exception e) {
            e.printStackTrace();
        }
        RandomAccessFile randomAccessFile = this.f829c;
        if (randomAccessFile != null && (channel = randomAccessFile.getChannel()) != null) {
            if (this.f831e > 0) {
                m783a().postDelayed(this, this.f831e);
            }
            FileLock fileLockLock = null;
            long jCurrentTimeMillis = System.currentTimeMillis();
            while (true) {
                try {
                    fileLockLock = channel.lock();
                    if (fileLockLock != null) {
                        break;
                    }
                    try {
                        Thread.sleep(50L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    if (Math.abs(System.currentTimeMillis() - jCurrentTimeMillis) >= 1000) {
                        Log.d(f823a, ">>> lock timeout, quit...");
                        break;
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    Log.d(f823a, ">>> lock failed, sleep...");
                }
            }
            this.f830d = fileLockLock;
            Log.d(f823a, ">>> lock [" + this.f828b.getName() + "] cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            if (this.f830d != null) {
                m786c();
            }
        } else if (this.f830d != null) {
            m786c();
        }
        throw th;
    }

    /* JADX INFO: renamed from: c */
    public void m786c() {
        synchronized (f825g) {
            if (f826h == null) {
                f826h = new HashMap<>();
            }
            f826h.put(this, f824f);
        }
    }

    /* JADX INFO: renamed from: d */
    public void m787d() {
        synchronized (f825g) {
            HashMap<RunnableC0456m, Object> map = f826h;
            if (map == null) {
                return;
            }
            map.remove(this);
        }
    }

    /* JADX INFO: renamed from: e */
    public void m788e() {
        m784a(true);
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.d(f823a, ">>> releaseLock on TimeOut");
        m788e();
    }
}
