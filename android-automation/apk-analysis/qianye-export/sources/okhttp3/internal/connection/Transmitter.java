package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import p047IL.C0007;
import p047IL.C0656lIII;
import p047IL.ILL;
import p047IL.L1l;
import p047IL.LL1IL;
import p047IL.lIiI;
import p047IL.lLi1LL;
import p047IL.llliI;
import p066Ilil.IL1Iii;
import p066Ilil.lL;

/* JADX INFO: loaded from: classes.dex */
public final class Transmitter {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ILL call;

    @Nullable
    private Object callStackTrace;
    private boolean canceled;
    private final C0007 client;
    public RealConnection connection;
    private final RealConnectionPool connectionPool;
    private final llliI eventListener;

    @Nullable
    private Exchange exchange;
    private ExchangeFinder exchangeFinder;
    private boolean exchangeRequestDone;
    private boolean exchangeResponseDone;
    private boolean noMoreExchanges;
    private L1l request;
    private final IL1Iii timeout;
    private boolean timeoutEarlyExit;

    public static final class TransmitterReference extends WeakReference<Transmitter> {
        public final Object callStackTrace;

        public TransmitterReference(Transmitter transmitter, Object obj) {
            super(transmitter);
            this.callStackTrace = obj;
        }
    }

    public Transmitter(C0007 c0007, ILL ill) {
        IL1Iii iL1Iii = new IL1Iii() { // from class: okhttp3.internal.connection.Transmitter.1
            @Override // p066Ilil.IL1Iii
            public void timedOut() {
                Transmitter.this.cancel();
            }
        };
        this.timeout = iL1Iii;
        this.client = c0007;
        this.connectionPool = Internal.instance.realConnectionPool(c0007.m2975lLi1LL());
        this.call = ill;
        this.eventListener = c0007.m2967Ll1().IL1Iii(ill);
        iL1Iii.timeout(c0007.I1I(), TimeUnit.MILLISECONDS);
    }

    private lLi1LL createAddress(C0656lIII c0656lIII) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifierLil;
        lIiI liiiM2965IL;
        if (c0656lIII.m2906ILl()) {
            SSLSocketFactory sSLSocketFactoryLL1IL = this.client.LL1IL();
            hostnameVerifierLil = this.client.Lil();
            sSLSocketFactory = sSLSocketFactoryLL1IL;
            liiiM2965IL = this.client.m2965IL();
        } else {
            sSLSocketFactory = null;
            hostnameVerifierLil = null;
            liiiM2965IL = null;
        }
        return new lLi1LL(c0656lIII.m2911lIiI(), c0656lIII.m2918l(), this.client.ILL(), this.client.m2972lIII(), sSLSocketFactory, hostnameVerifierLil, liiiM2965IL, this.client.llliI(), this.client.I11L(), this.client.m2977lL(), this.client.m2970iILLL1(), this.client.m2978l());
    }

    @Nullable
    private IOException maybeReleaseConnection(@Nullable IOException iOException, boolean z) {
        RealConnection realConnection;
        Socket socketReleaseConnectionNoEvents;
        boolean z2;
        synchronized (this.connectionPool) {
            if (z) {
                if (this.exchange != null) {
                    throw new IllegalStateException("cannot release connection while it is in use");
                }
            }
            realConnection = this.connection;
            socketReleaseConnectionNoEvents = (realConnection != null && this.exchange == null && (z || this.noMoreExchanges)) ? releaseConnectionNoEvents() : null;
            if (this.connection != null) {
                realConnection = null;
            }
            z2 = this.noMoreExchanges && this.exchange == null;
        }
        Util.closeQuietly(socketReleaseConnectionNoEvents);
        if (realConnection != null) {
            this.eventListener.m2941IiL(this.call, realConnection);
        }
        if (z2) {
            boolean z3 = iOException != null;
            iOException = timeoutExit(iOException);
            if (z3) {
                this.eventListener.ILil(this.call, iOException);
            } else {
                this.eventListener.IL1Iii(this.call);
            }
        }
        return iOException;
    }

    @Nullable
    private IOException timeoutExit(@Nullable IOException iOException) {
        if (this.timeoutEarlyExit || !this.timeout.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public void acquireConnectionNoEvents(RealConnection realConnection) {
        if (this.connection != null) {
            throw new IllegalStateException();
        }
        this.connection = realConnection;
        realConnection.transmitters.add(new TransmitterReference(this, this.callStackTrace));
    }

    public void callStart() {
        this.callStackTrace = Platform.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.I1I(this.call);
    }

    public boolean canRetry() {
        return this.exchangeFinder.hasStreamFailure() && this.exchangeFinder.hasRouteToTry();
    }

    public void cancel() {
        Exchange exchange;
        RealConnection realConnectionConnectingConnection;
        synchronized (this.connectionPool) {
            this.canceled = true;
            exchange = this.exchange;
            ExchangeFinder exchangeFinder = this.exchangeFinder;
            realConnectionConnectingConnection = (exchangeFinder == null || exchangeFinder.connectingConnection() == null) ? this.connection : this.exchangeFinder.connectingConnection();
        }
        if (exchange != null) {
            exchange.cancel();
        } else if (realConnectionConnectingConnection != null) {
            realConnectionConnectingConnection.cancel();
        }
    }

    public void exchangeDoneDueToException() {
        synchronized (this.connectionPool) {
            if (this.noMoreExchanges) {
                throw new IllegalStateException();
            }
            this.exchange = null;
        }
    }

    @Nullable
    public IOException exchangeMessageDone(Exchange exchange, boolean z, boolean z2, @Nullable IOException iOException) {
        boolean z3;
        synchronized (this.connectionPool) {
            Exchange exchange2 = this.exchange;
            if (exchange != exchange2) {
                return iOException;
            }
            boolean z4 = true;
            if (z) {
                z3 = !this.exchangeRequestDone;
                this.exchangeRequestDone = true;
            } else {
                z3 = false;
            }
            if (z2) {
                if (!this.exchangeResponseDone) {
                    z3 = true;
                }
                this.exchangeResponseDone = true;
            }
            if (this.exchangeRequestDone && this.exchangeResponseDone && z3) {
                exchange2.connection().successCount++;
                this.exchange = null;
            } else {
                z4 = false;
            }
            return z4 ? maybeReleaseConnection(iOException, false) : iOException;
        }
    }

    public boolean hasExchange() {
        boolean z;
        synchronized (this.connectionPool) {
            z = this.exchange != null;
        }
        return z;
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.connectionPool) {
            z = this.canceled;
        }
        return z;
    }

    public Exchange newExchange(LL1IL.IL1Iii iL1Iii, boolean z) {
        synchronized (this.connectionPool) {
            if (this.noMoreExchanges) {
                throw new IllegalStateException("released");
            }
            if (this.exchange != null) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
            }
        }
        Exchange exchange = new Exchange(this, this.call, this.eventListener, this.exchangeFinder, this.exchangeFinder.find(this.client, iL1Iii, z));
        synchronized (this.connectionPool) {
            this.exchange = exchange;
            this.exchangeRequestDone = false;
            this.exchangeResponseDone = false;
        }
        return exchange;
    }

    @Nullable
    public IOException noMoreExchanges(@Nullable IOException iOException) {
        synchronized (this.connectionPool) {
            this.noMoreExchanges = true;
        }
        return maybeReleaseConnection(iOException, false);
    }

    public void prepareToConnect(L1l l1l) {
        L1l l1l2 = this.request;
        if (l1l2 != null) {
            if (Util.sameConnection(l1l2.m2875il(), l1l.m2875il()) && this.exchangeFinder.hasRouteToTry()) {
                return;
            }
            if (this.exchange != null) {
                throw new IllegalStateException();
            }
            if (this.exchangeFinder != null) {
                maybeReleaseConnection(null, true);
                this.exchangeFinder = null;
            }
        }
        this.request = l1l;
        this.exchangeFinder = new ExchangeFinder(this, this.connectionPool, createAddress(l1l.m2875il()), this.call, this.eventListener);
    }

    @Nullable
    public Socket releaseConnectionNoEvents() {
        int i = 0;
        int size = this.connection.transmitters.size();
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            }
            if (this.connection.transmitters.get(i).get() == this) {
                break;
            }
            i++;
        }
        if (i == -1) {
            throw new IllegalStateException();
        }
        RealConnection realConnection = this.connection;
        realConnection.transmitters.remove(i);
        this.connection = null;
        if (!realConnection.transmitters.isEmpty()) {
            return null;
        }
        realConnection.idleAtNanos = System.nanoTime();
        if (this.connectionPool.connectionBecameIdle(realConnection)) {
            return realConnection.socket();
        }
        return null;
    }

    public lL timeout() {
        return this.timeout;
    }

    public void timeoutEarlyExit() {
        if (this.timeoutEarlyExit) {
            throw new IllegalStateException();
        }
        this.timeoutEarlyExit = true;
        this.timeout.exit();
    }

    public void timeoutEnter() {
        this.timeout.enter();
    }
}
