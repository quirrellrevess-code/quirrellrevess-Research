package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import p047IL.C0655ill;

/* JADX INFO: loaded from: classes.dex */
public final class RouteDatabase {
    private final Set<C0655ill> failedRoutes = new LinkedHashSet();

    public synchronized void connected(C0655ill c0655ill) {
        this.failedRoutes.remove(c0655ill);
    }

    public synchronized void failed(C0655ill c0655ill) {
        this.failedRoutes.add(c0655ill);
    }

    public synchronized boolean shouldPostpone(C0655ill c0655ill) {
        return this.failedRoutes.contains(c0655ill);
    }
}
