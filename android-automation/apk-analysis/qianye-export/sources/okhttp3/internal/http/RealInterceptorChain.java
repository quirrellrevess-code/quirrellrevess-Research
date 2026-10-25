package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.Transmitter;
import p047IL.IIi;
import p047IL.ILL;
import p047IL.L1l;
import p047IL.LL1IL;
import p047IL.LlLI1;

/* JADX INFO: loaded from: classes.dex */
public final class RealInterceptorChain implements LL1IL.IL1Iii {
    private final ILL call;
    private int calls;
    private final int connectTimeout;

    @Nullable
    private final Exchange exchange;
    private final int index;
    private final List<LL1IL> interceptors;
    private final int readTimeout;
    private final L1l request;
    private final Transmitter transmitter;
    private final int writeTimeout;

    public RealInterceptorChain(List<LL1IL> list, Transmitter transmitter, @Nullable Exchange exchange, int i, L1l l1l, ILL ill, int i2, int i3, int i4) {
        this.interceptors = list;
        this.transmitter = transmitter;
        this.exchange = exchange;
        this.index = i;
        this.request = l1l;
        this.call = ill;
        this.connectTimeout = i2;
        this.readTimeout = i3;
        this.writeTimeout = i4;
    }

    public ILL call() {
        return this.call;
    }

    @Override // I丨L.LL1IL.IL1Iii
    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    @Nullable
    public LlLI1 connection() {
        Exchange exchange = this.exchange;
        if (exchange != null) {
            return exchange.connection();
        }
        return null;
    }

    public Exchange exchange() {
        Exchange exchange = this.exchange;
        if (exchange != null) {
            return exchange;
        }
        throw new IllegalStateException();
    }

    @Override // I丨L.LL1IL.IL1Iii
    public IIi proceed(L1l l1l) throws IOException {
        return proceed(l1l, this.transmitter, this.exchange);
    }

    @Override // I丨L.LL1IL.IL1Iii
    public int readTimeoutMillis() {
        return this.readTimeout;
    }

    @Override // I丨L.LL1IL.IL1Iii
    public L1l request() {
        return this.request;
    }

    public Transmitter transmitter() {
        return this.transmitter;
    }

    public LL1IL.IL1Iii withConnectTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.interceptors, this.transmitter, this.exchange, this.index, this.request, this.call, Util.checkDuration("timeout", i, timeUnit), this.readTimeout, this.writeTimeout);
    }

    public LL1IL.IL1Iii withReadTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.interceptors, this.transmitter, this.exchange, this.index, this.request, this.call, this.connectTimeout, Util.checkDuration("timeout", i, timeUnit), this.writeTimeout);
    }

    public LL1IL.IL1Iii withWriteTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.interceptors, this.transmitter, this.exchange, this.index, this.request, this.call, this.connectTimeout, this.readTimeout, Util.checkDuration("timeout", i, timeUnit));
    }

    @Override // I丨L.LL1IL.IL1Iii
    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }

    public IIi proceed(L1l l1l, Transmitter transmitter, @Nullable Exchange exchange) throws IOException {
        if (this.index >= this.interceptors.size()) {
            throw new AssertionError();
        }
        this.calls++;
        Exchange exchange2 = this.exchange;
        if (exchange2 != null && !exchange2.connection().supportsUrl(l1l.m2875il())) {
            throw new IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port");
        }
        if (this.exchange != null && this.calls > 1) {
            throw new IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once");
        }
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.interceptors, transmitter, exchange, this.index + 1, l1l, this.call, this.connectTimeout, this.readTimeout, this.writeTimeout);
        LL1IL ll1il = this.interceptors.get(this.index);
        IIi iIiIntercept = ll1il.intercept(realInterceptorChain);
        if (exchange != null && this.index + 1 < this.interceptors.size() && realInterceptorChain.calls != 1) {
            throw new IllegalStateException("network interceptor " + ll1il + " must call proceed() exactly once");
        }
        if (iIiIntercept == null) {
            throw new NullPointerException("interceptor " + ll1il + " returned null");
        }
        if (iIiIntercept.m2846IiL() != null) {
            return iIiIntercept;
        }
        throw new IllegalStateException("interceptor " + ll1il + " returned a response with no body");
    }
}
