package p051lLi1LL.I1I;

import com.mysql.jdbc.MysqlErrorNumbers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import p051lLi1LL.I1I.LlLI1.IL;
import p051lLi1LL.p060IL.I1I;
import p051lLi1LL.p060IL.ILil;

/* JADX INFO: compiled from: AbstractWebSocket.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class IL1Iii extends I1I {
    private ScheduledFuture connectionLostCheckerFuture;
    private ScheduledExecutorService connectionLostCheckerService;
    private boolean reuseAddr;
    private boolean tcpNoDelay;
    private final ILil log = I1I.m3681L11I(IL1Iii.class);
    private long connectionLostTimeout = TimeUnit.SECONDS.toNanos(60);
    private boolean websocketRunning = false;
    private final Object syncConnectionLost = new Object();

    /* JADX INFO: renamed from: l丨Li1LL.I1I.IL1Iii$IL1Iii, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractWebSocket.java */
    public class RunnableC0595IL1Iii implements Runnable {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public ArrayList<ILil> f5436ILil = new ArrayList<>();

        public RunnableC0595IL1Iii() {
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5436ILil.clear();
            try {
                this.f5436ILil.addAll(IL1Iii.this.getConnections());
                long jNanoTime = (long) (System.nanoTime() - (IL1Iii.this.connectionLostTimeout * 1.5d));
                Iterator<ILil> it = this.f5436ILil.iterator();
                while (it.hasNext()) {
                    IL1Iii.this.executeConnectionLostDetection(it.next(), jNanoTime);
                }
            } catch (Exception unused) {
            }
            this.f5436ILil.clear();
        }
    }

    private void cancelConnectionLostTimer() {
        ScheduledExecutorService scheduledExecutorService = this.connectionLostCheckerService;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            this.connectionLostCheckerService = null;
        }
        ScheduledFuture scheduledFuture = this.connectionLostCheckerFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.connectionLostCheckerFuture = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeConnectionLostDetection(ILil iLil, long j) {
        if (iLil instanceof IL) {
            IL il = (IL) iLil;
            if (il.m3528llL1ii() < j) {
                this.log.trace("Closing connection due to no pong received: {}", il);
                il.Ilil(MysqlErrorNumbers.ER_CANT_CREATE_DB, "The connection was closed because the other endpoint did not respond with a pong in time. For more information check: https://github.com/TooTallNate/Java-WebSocket/wiki/Lost-connection-detection");
            } else if (il.m3526lIII()) {
                il.m3530iILLl();
            } else {
                this.log.trace("Trying to ping a non open connection: {}", il);
            }
        }
    }

    private void restartConnectionLostTimer() {
        cancelConnectionLostTimer();
        this.connectionLostCheckerService = Executors.newSingleThreadScheduledExecutor(new IL("connectionLostChecker"));
        RunnableC0595IL1Iii runnableC0595IL1Iii = new RunnableC0595IL1Iii();
        ScheduledExecutorService scheduledExecutorService = this.connectionLostCheckerService;
        long j = this.connectionLostTimeout;
        this.connectionLostCheckerFuture = scheduledExecutorService.scheduleAtFixedRate(runnableC0595IL1Iii, j, j, TimeUnit.NANOSECONDS);
    }

    public int getConnectionLostTimeout() {
        int seconds;
        synchronized (this.syncConnectionLost) {
            seconds = (int) TimeUnit.NANOSECONDS.toSeconds(this.connectionLostTimeout);
        }
        return seconds;
    }

    public abstract Collection<ILil> getConnections();

    public boolean isReuseAddr() {
        return this.reuseAddr;
    }

    public boolean isTcpNoDelay() {
        return this.tcpNoDelay;
    }

    public void setConnectionLostTimeout(int i) {
        synchronized (this.syncConnectionLost) {
            long nanos = TimeUnit.SECONDS.toNanos(i);
            this.connectionLostTimeout = nanos;
            if (nanos <= 0) {
                this.log.trace("Connection lost timer stopped");
                cancelConnectionLostTimer();
                return;
            }
            if (this.websocketRunning) {
                this.log.trace("Connection lost timer restarted");
                try {
                    for (ILil iLil : new ArrayList(getConnections())) {
                        if (iLil instanceof IL) {
                            ((IL) iLil).m3523ill();
                        }
                    }
                } catch (Exception e) {
                    this.log.error("Exception during connection lost restart", e);
                }
                restartConnectionLostTimer();
            }
        }
    }

    public void setReuseAddr(boolean z) {
        this.reuseAddr = z;
    }

    public void setTcpNoDelay(boolean z) {
        this.tcpNoDelay = z;
    }

    public void startConnectionLostTimer() {
        synchronized (this.syncConnectionLost) {
            if (this.connectionLostTimeout <= 0) {
                this.log.trace("Connection lost timer deactivated");
                return;
            }
            this.log.trace("Connection lost timer started");
            this.websocketRunning = true;
            restartConnectionLostTimer();
        }
    }

    public void stopConnectionLostTimer() {
        synchronized (this.syncConnectionLost) {
            if (this.connectionLostCheckerService != null || this.connectionLostCheckerFuture != null) {
                this.websocketRunning = false;
                this.log.trace("Connection lost timer stopped");
                cancelConnectionLostTimer();
            }
        }
    }
}
