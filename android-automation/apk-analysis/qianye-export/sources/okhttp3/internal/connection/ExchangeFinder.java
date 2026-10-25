package okhttp3.internal.connection;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import okhttp3.internal.Util;
import okhttp3.internal.http.ExchangeCodec;
import p047IL.C0007;
import p047IL.C0655ill;
import p047IL.ILL;
import p047IL.LL1IL;
import p047IL.lLi1LL;
import p047IL.llliI;

/* JADX INFO: loaded from: classes.dex */
public final class ExchangeFinder {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private final lLi1LL address;
    private final ILL call;
    private RealConnection connectingConnection;
    private final RealConnectionPool connectionPool;
    private final llliI eventListener;
    private boolean hasStreamFailure;
    private C0655ill nextRouteToTry;
    private RouteSelector.Selection routeSelection;
    private final RouteSelector routeSelector;
    private final Transmitter transmitter;

    public ExchangeFinder(Transmitter transmitter, RealConnectionPool realConnectionPool, lLi1LL lli1ll, ILL ill, llliI lllii) {
        this.transmitter = transmitter;
        this.connectionPool = realConnectionPool;
        this.address = lli1ll;
        this.call = ill;
        this.eventListener = lllii;
        this.routeSelector = new RouteSelector(lli1ll, realConnectionPool.routeDatabase, ill, lllii);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0054  */
    private RealConnection findConnection(int i, int i2, int i3, int i4, boolean z) throws Throwable {
        RealConnection realConnection;
        Socket socket;
        Socket socketReleaseConnectionNoEvents;
        RealConnection realConnection2;
        C0655ill next;
        boolean z2;
        boolean z3;
        List<C0655ill> all;
        RouteSelector.Selection selection;
        synchronized (this.connectionPool) {
            if (this.transmitter.isCanceled()) {
                throw new IOException("Canceled");
            }
            this.hasStreamFailure = false;
            Transmitter transmitter = this.transmitter;
            realConnection = transmitter.connection;
            socket = null;
            socketReleaseConnectionNoEvents = (realConnection == null || !realConnection.noNewExchanges) ? null : transmitter.releaseConnectionNoEvents();
            Transmitter transmitter2 = this.transmitter;
            realConnection2 = transmitter2.connection;
            if (realConnection2 != null) {
                realConnection = null;
            } else {
                realConnection2 = null;
            }
            if (realConnection2 != null) {
                next = null;
                z2 = false;
            } else if (this.connectionPool.transmitterAcquirePooledConnection(this.address, transmitter2, null, false)) {
                realConnection2 = this.transmitter.connection;
                next = null;
                z2 = true;
            } else {
                next = this.nextRouteToTry;
                if (next != null) {
                    this.nextRouteToTry = null;
                } else if (retryCurrentRoute()) {
                    next = this.transmitter.connection.route();
                } else {
                    next = null;
                }
                z2 = false;
            }
        }
        Util.closeQuietly(socketReleaseConnectionNoEvents);
        if (realConnection != null) {
            this.eventListener.m2941IiL(this.call, realConnection);
        }
        if (z2) {
            this.eventListener.m2943iILLL1(this.call, realConnection2);
        }
        if (realConnection2 != null) {
            return realConnection2;
        }
        if (next != null || ((selection = this.routeSelection) != null && selection.hasNext())) {
            z3 = false;
        } else {
            this.routeSelection = this.routeSelector.next();
            z3 = true;
        }
        synchronized (this.connectionPool) {
            if (this.transmitter.isCanceled()) {
                throw new IOException("Canceled");
            }
            if (z3) {
                all = this.routeSelection.getAll();
                if (this.connectionPool.transmitterAcquirePooledConnection(this.address, this.transmitter, all, false)) {
                    realConnection2 = this.transmitter.connection;
                    z2 = true;
                }
            } else {
                all = null;
            }
            if (!z2) {
                if (next == null) {
                    next = this.routeSelection.next();
                }
                realConnection2 = new RealConnection(this.connectionPool, next);
                this.connectingConnection = realConnection2;
            }
        }
        if (z2) {
            this.eventListener.m2943iILLL1(this.call, realConnection2);
            return realConnection2;
        }
        realConnection2.connect(i, i2, i3, i4, z, this.call, this.eventListener);
        this.connectionPool.routeDatabase.connected(realConnection2.route());
        synchronized (this.connectionPool) {
            this.connectingConnection = null;
            if (this.connectionPool.transmitterAcquirePooledConnection(this.address, this.transmitter, all, true)) {
                realConnection2.noNewExchanges = true;
                socket = realConnection2.socket();
                realConnection2 = this.transmitter.connection;
                this.nextRouteToTry = next;
            } else {
                this.connectionPool.put(realConnection2);
                this.transmitter.acquireConnectionNoEvents(realConnection2);
            }
        }
        Util.closeQuietly(socket);
        this.eventListener.m2943iILLL1(this.call, realConnection2);
        return realConnection2;
    }

    private RealConnection findHealthyConnection(int i, int i2, int i3, int i4, boolean z, boolean z2) throws Throwable {
        while (true) {
            RealConnection realConnectionFindConnection = findConnection(i, i2, i3, i4, z);
            synchronized (this.connectionPool) {
                if (realConnectionFindConnection.successCount == 0 && !realConnectionFindConnection.isMultiplexed()) {
                    return realConnectionFindConnection;
                }
                if (realConnectionFindConnection.isHealthy(z2)) {
                    return realConnectionFindConnection;
                }
                realConnectionFindConnection.noNewExchanges();
            }
        }
    }

    private boolean retryCurrentRoute() {
        RealConnection realConnection = this.transmitter.connection;
        return realConnection != null && realConnection.routeFailureCount == 0 && Util.sameConnection(realConnection.route().IL1Iii().m2952Ll1(), this.address.m2952Ll1());
    }

    public RealConnection connectingConnection() {
        return this.connectingConnection;
    }

    public ExchangeCodec find(C0007 c0007, LL1IL.IL1Iii iL1Iii, boolean z) {
        try {
            return findHealthyConnection(iL1Iii.connectTimeoutMillis(), iL1Iii.readTimeoutMillis(), iL1Iii.writeTimeoutMillis(), c0007.I11li1(), c0007.m2969LlLLL(), z).newCodec(c0007, iL1Iii);
        } catch (IOException e) {
            trackFailure();
            throw new RouteException(e);
        } catch (RouteException e2) {
            trackFailure();
            throw e2;
        }
    }

    public boolean hasRouteToTry() {
        synchronized (this.connectionPool) {
            boolean z = true;
            if (this.nextRouteToTry != null) {
                return true;
            }
            if (retryCurrentRoute()) {
                this.nextRouteToTry = this.transmitter.connection.route();
                return true;
            }
            RouteSelector.Selection selection = this.routeSelection;
            if ((selection == null || !selection.hasNext()) && !this.routeSelector.hasNext()) {
                z = false;
            }
            return z;
        }
    }

    public boolean hasStreamFailure() {
        boolean z;
        synchronized (this.connectionPool) {
            z = this.hasStreamFailure;
        }
        return z;
    }

    public void trackFailure() {
        synchronized (this.connectionPool) {
            this.hasStreamFailure = true;
        }
    }
}
