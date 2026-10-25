package p047IL;

import java.util.concurrent.TimeUnit;
import okhttp3.internal.connection.RealConnectionPool;

/* JADX INFO: renamed from: I丨L.ll丨L1ii, reason: invalid class name */
/* JADX INFO: compiled from: ConnectionPool.java */
/* JADX INFO: loaded from: classes.dex */
public final class llL1ii {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final RealConnectionPool f4684IL1Iii;

    public llL1ii() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public llL1ii(int i, long j, TimeUnit timeUnit) {
        this.f4684IL1Iii = new RealConnectionPool(i, j, timeUnit);
    }
}
