package p047IL;

import com.google.android.flexbox.BuildConfig;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.Transmitter;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import p066Ilil.lL;

/* JADX INFO: renamed from: I丨L.l1IIi1丨, reason: invalid class name */
/* JADX INFO: compiled from: RealCall.java */
/* JADX INFO: loaded from: classes.dex */
public final class l1IIi1 implements ILL {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Transmitter f4655I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final C0007 f4656ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final boolean f4657Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final L1l f2114IL;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean f2115lLi1LL;

    /* JADX INFO: renamed from: I丨L.l1IIi1丨$IL1Iii */
    /* JADX INFO: compiled from: RealCall.java */
    public final class IL1Iii extends NamedRunnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public volatile AtomicInteger f4658I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final Ll1 f4659ILil;

        public IL1Iii(Ll1 ll1) {
            super("OkHttp %s", l1IIi1.this.Ilil());
            this.f4658I1I = new AtomicInteger(0);
            this.f4659ILil = ll1;
        }

        public l1IIi1 I1I() {
            return l1IIi1.this;
        }

        public AtomicInteger IL1Iii() {
            return this.f4658I1I;
        }

        public void ILil(ExecutorService executorService) {
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    l1IIi1.this.f4655I1I.noMoreExchanges(interruptedIOException);
                    this.f4659ILil.onFailure(l1IIi1.this, interruptedIOException);
                    l1IIi1.this.f4656ILil.m2976il().m2841lLi1LL(this);
                }
            } catch (Throwable th) {
                l1IIi1.this.f4656ILil.m2976il().m2841lLi1LL(this);
                throw th;
            }
        }

        public void Ilil(IL1Iii iL1Iii) {
            this.f4658I1I = iL1Iii.f4658I1I;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public String m2900IL() {
            return l1IIi1.this.f2114IL.m2875il().m2911lIiI();
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            Throwable th;
            boolean z;
            IOException e;
            l1IIi1.this.f4655I1I.timeoutEnter();
            try {
                try {
                    z = true;
                    try {
                        this.f4659ILil.onResponse(l1IIi1.this, l1IIi1.this.I1I());
                    } catch (IOException e2) {
                        e = e2;
                        if (z) {
                            Platform.get().log(4, "Callback failure for " + l1IIi1.this.m2899lLi1LL(), e);
                        } else {
                            this.f4659ILil.onFailure(l1IIi1.this, e);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        l1IIi1.this.cancel();
                        if (!z) {
                            IOException iOException = new IOException("canceled due to " + th);
                            iOException.addSuppressed(th);
                            this.f4659ILil.onFailure(l1IIi1.this, iOException);
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    z = false;
                } catch (Throwable th3) {
                    th = th3;
                    z = false;
                }
                l1IIi1.this.f4656ILil.m2976il().m2841lLi1LL(this);
            } catch (Throwable th4) {
                l1IIi1.this.f4656ILil.m2976il().m2841lLi1LL(this);
                throw th4;
            }
        }
    }

    public l1IIi1(C0007 c0007, L1l l1l, boolean z) {
        this.f4656ILil = c0007;
        this.f2114IL = l1l;
        this.f4657Ilil = z;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static l1IIi1 m2898IL(C0007 c0007, L1l l1l, boolean z) {
        l1IIi1 l1iii1 = new l1IIi1(c0007, l1l, z);
        l1iii1.f4655I1I = new Transmitter(c0007, l1iii1);
        return l1iii1;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x00a5  */
    public IIi I1I() throws Throwable {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f4656ILil.LlLI1());
        arrayList.add(new RetryAndFollowUpInterceptor(this.f4656ILil));
        arrayList.add(new BridgeInterceptor(this.f4656ILil.m2968L11I()));
        arrayList.add(new CacheInterceptor(this.f4656ILil.m2974llL1ii()));
        arrayList.add(new ConnectInterceptor(this.f4656ILil));
        if (!this.f4657Ilil) {
            arrayList.addAll(this.f4656ILil.m2973lIlii());
        }
        arrayList.add(new CallServerInterceptor(this.f4657Ilil));
        boolean z = false;
        try {
            IIi iIiProceed = new RealInterceptorChain(arrayList, this.f4655I1I, null, 0, this.f2114IL, this, this.f4656ILil.Ilil(), this.f4656ILil.m29791(), this.f4656ILil.m2966L111()).proceed(this.f2114IL);
            if (this.f4655I1I.isCanceled()) {
                Util.closeQuietly(iIiProceed);
                throw new IOException("Canceled");
            }
            this.f4655I1I.noMoreExchanges(null);
            return iIiProceed;
        } catch (IOException e) {
            try {
                throw this.f4655I1I.noMoreExchanges(e);
            } catch (Throwable th) {
                th = th;
                z = true;
                if (!z) {
                    this.f4655I1I.noMoreExchanges(null);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (!z) {
                this.f4655I1I.noMoreExchanges(null);
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
    public l1IIi1 clone() {
        return m2898IL(this.f4656ILil, this.f2114IL, this.f4657Ilil);
    }

    public String Ilil() {
        return this.f2114IL.m2875il().m2912lIII();
    }

    @Override // p047IL.ILL
    /* JADX INFO: renamed from: I丨iL */
    public void mo2842IiL(Ll1 ll1) {
        synchronized (this) {
            if (this.f2115lLi1LL) {
                throw new IllegalStateException("Already Executed");
            }
            this.f2115lLi1LL = true;
        }
        this.f4655I1I.callStart();
        this.f4656ILil.m2976il().IL1Iii(new IL1Iii(ll1));
    }

    @Override // p047IL.ILL
    public void cancel() {
        this.f4655I1I.cancel();
    }

    @Override // p047IL.ILL
    public IIi execute() throws IOException {
        synchronized (this) {
            if (this.f2115lLi1LL) {
                throw new IllegalStateException("Already Executed");
            }
            this.f2115lLi1LL = true;
        }
        this.f4655I1I.timeoutEnter();
        this.f4655I1I.callStart();
        try {
            this.f4656ILil.m2976il().ILil(this);
            return I1I();
        } finally {
            this.f4656ILil.m2976il().m2840iILLL1(this);
        }
    }

    @Override // p047IL.ILL
    public boolean isCanceled() {
        return this.f4655I1I.isCanceled();
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public String m2899lLi1LL() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : BuildConfig.FLAVOR);
        sb.append(this.f4657Ilil ? "web socket" : "call");
        sb.append(" to ");
        sb.append(Ilil());
        return sb.toString();
    }

    @Override // p047IL.ILL
    public L1l request() {
        return this.f2114IL;
    }

    @Override // p047IL.ILL
    public lL timeout() {
        return this.f4655I1I.timeout();
    }
}
