package retrofit2;

import java.io.IOException;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import p047IL.IIi;
import p047IL.ILL;
import p047IL.L111;
import p047IL.L1l;
import p047IL.LIll;
import p047IL.Ll1;
import p066Ilil.I1I;
import p066Ilil.L11I;
import p066Ilil.lIiI;
import p066Ilil.lL;
import p066Ilil.lLi1LL;

/* JADX INFO: loaded from: classes.dex */
public final class OkHttpCall<T> implements Call<T> {
    private final Object[] args;
    private final ILL.IL1Iii callFactory;
    private volatile boolean canceled;

    @GuardedBy("this")
    @Nullable
    private Throwable creationFailure;

    @GuardedBy("this")
    private boolean executed;

    @GuardedBy("this")
    @Nullable
    private ILL rawCall;
    private final RequestFactory requestFactory;
    private final Converter<LIll, T> responseConverter;

    public static final class ExceptionCatchingResponseBody extends LIll {
        private final LIll delegate;
        private final lLi1LL delegateSource;

        @Nullable
        public IOException thrownException;

        public ExceptionCatchingResponseBody(LIll lIll) {
            this.delegate = lIll;
            this.delegateSource = lIiI.m2826IL(new L11I(lIll.source()) { // from class: retrofit2.OkHttpCall.ExceptionCatchingResponseBody.1
                @Override // p066Ilil.L11I, p066Ilil.I11li1
                public long read(I1I i1i, long j) throws IOException {
                    try {
                        return super.read(i1i, j);
                    } catch (IOException e) {
                        ExceptionCatchingResponseBody.this.thrownException = e;
                        throw e;
                    }
                }
            });
        }

        @Override // p047IL.LIll, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
        }

        @Override // p047IL.LIll
        public long contentLength() {
            return this.delegate.contentLength();
        }

        @Override // p047IL.LIll
        public L111 contentType() {
            return this.delegate.contentType();
        }

        @Override // p047IL.LIll
        public lLi1LL source() {
            return this.delegateSource;
        }

        public void throwIfCaught() throws IOException {
            IOException iOException = this.thrownException;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    public static final class NoContentResponseBody extends LIll {
        private final long contentLength;

        @Nullable
        private final L111 contentType;

        public NoContentResponseBody(@Nullable L111 l111, long j) {
            this.contentType = l111;
            this.contentLength = j;
        }

        @Override // p047IL.LIll
        public long contentLength() {
            return this.contentLength;
        }

        @Override // p047IL.LIll
        public L111 contentType() {
            return this.contentType;
        }

        @Override // p047IL.LIll
        public lLi1LL source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public OkHttpCall(RequestFactory requestFactory, Object[] objArr, ILL.IL1Iii iL1Iii, Converter<LIll, T> converter) {
        this.requestFactory = requestFactory;
        this.args = objArr;
        this.callFactory = iL1Iii;
        this.responseConverter = converter;
    }

    private ILL createRawCall() throws IOException {
        ILL illIL1Iii = this.callFactory.IL1Iii(this.requestFactory.create(this.args));
        Objects.requireNonNull(illIL1Iii, "Call.Factory returned null.");
        return illIL1Iii;
    }

    @GuardedBy("this")
    private ILL getRawCall() throws IOException {
        ILL ill = this.rawCall;
        if (ill != null) {
            return ill;
        }
        Throwable th = this.creationFailure;
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw ((Error) th);
        }
        try {
            ILL illCreateRawCall = createRawCall();
            this.rawCall = illCreateRawCall;
            return illCreateRawCall;
        } catch (IOException | Error | RuntimeException e) {
            Utils.throwIfFatal(e);
            this.creationFailure = e;
            throw e;
        }
    }

    @Override // retrofit2.Call
    public void cancel() {
        ILL ill;
        this.canceled = true;
        synchronized (this) {
            ill = this.rawCall;
        }
        if (ill != null) {
            ill.cancel();
        }
    }

    @Override // retrofit2.Call
    public void enqueue(final Callback<T> callback) {
        ILL ill;
        Throwable th;
        Objects.requireNonNull(callback, "callback == null");
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already executed.");
            }
            this.executed = true;
            ill = this.rawCall;
            th = this.creationFailure;
            if (ill == null && th == null) {
                try {
                    ILL illCreateRawCall = createRawCall();
                    this.rawCall = illCreateRawCall;
                    ill = illCreateRawCall;
                } catch (Throwable th2) {
                    th = th2;
                    Utils.throwIfFatal(th);
                    this.creationFailure = th;
                }
            }
        }
        if (th != null) {
            callback.onFailure(this, th);
            return;
        }
        if (this.canceled) {
            ill.cancel();
        }
        ill.mo2842IiL(new Ll1() { // from class: retrofit2.OkHttpCall.1
            private void callFailure(Throwable th3) {
                try {
                    callback.onFailure(OkHttpCall.this, th3);
                } catch (Throwable th4) {
                    Utils.throwIfFatal(th4);
                    th4.printStackTrace();
                }
            }

            @Override // p047IL.Ll1
            public void onFailure(ILL ill2, IOException iOException) {
                callFailure(iOException);
            }

            @Override // p047IL.Ll1
            public void onResponse(ILL ill2, IIi iIi) {
                try {
                    try {
                        callback.onResponse(OkHttpCall.this, OkHttpCall.this.parseResponse(iIi));
                    } catch (Throwable th3) {
                        Utils.throwIfFatal(th3);
                        th3.printStackTrace();
                    }
                } catch (Throwable th4) {
                    Utils.throwIfFatal(th4);
                    callFailure(th4);
                }
            }
        });
    }

    @Override // retrofit2.Call
    public Response<T> execute() throws IOException {
        ILL rawCall;
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already executed.");
            }
            this.executed = true;
            rawCall = getRawCall();
        }
        if (this.canceled) {
            rawCall.cancel();
        }
        return parseResponse(rawCall.execute());
    }

    @Override // retrofit2.Call
    public boolean isCanceled() {
        boolean z = true;
        if (this.canceled) {
            return true;
        }
        synchronized (this) {
            ILL ill = this.rawCall;
            if (ill == null || !ill.isCanceled()) {
                z = false;
            }
        }
        return z;
    }

    @Override // retrofit2.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    public Response<T> parseResponse(IIi iIi) throws IOException {
        LIll lIllM2846IiL = iIi.m2846IiL();
        IIi.IL1Iii iL1IiiM2853li11 = iIi.m2853li11();
        iL1IiiM2853li11.ILil(new NoContentResponseBody(lIllM2846IiL.contentType(), lIllM2846IiL.contentLength()));
        IIi iIiI1I = iL1IiiM2853li11.I1I();
        int iM2847L11 = iIiI1I.m2847L11();
        if (iM2847L11 < 200 || iM2847L11 >= 300) {
            try {
                return Response.error(Utils.buffer(lIllM2846IiL), iIiI1I);
            } finally {
                lIllM2846IiL.close();
            }
        }
        if (iM2847L11 == 204 || iM2847L11 == 205) {
            lIllM2846IiL.close();
            return Response.success((Object) null, iIiI1I);
        }
        ExceptionCatchingResponseBody exceptionCatchingResponseBody = new ExceptionCatchingResponseBody(lIllM2846IiL);
        try {
            return Response.success(this.responseConverter.convert(exceptionCatchingResponseBody), iIiI1I);
        } catch (RuntimeException e) {
            exceptionCatchingResponseBody.throwIfCaught();
            throw e;
        }
    }

    @Override // retrofit2.Call
    public synchronized L1l request() {
        try {
        } catch (IOException e) {
            throw new RuntimeException("Unable to create request.", e);
        }
        return getRawCall().request();
    }

    @Override // retrofit2.Call
    public synchronized lL timeout() {
        try {
        } catch (IOException e) {
            throw new RuntimeException("Unable to create call.", e);
        }
        return getRawCall().timeout();
    }

    @Override // retrofit2.Call
    public OkHttpCall<T> clone() {
        return new OkHttpCall<>(this.requestFactory, this.args, this.callFactory, this.responseConverter);
    }
}
