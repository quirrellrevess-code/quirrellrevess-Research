package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.internal.http.RealInterceptorChain;
import p047IL.C0007;
import p047IL.IIi;
import p047IL.L1l;
import p047IL.LL1IL;

/* JADX INFO: loaded from: classes.dex */
public final class ConnectInterceptor implements LL1IL {
    public final C0007 client;

    public ConnectInterceptor(C0007 c0007) {
        this.client = c0007;
    }

    @Override // p047IL.LL1IL
    public IIi intercept(LL1IL.IL1Iii iL1Iii) throws IOException {
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) iL1Iii;
        L1l l1lRequest = realInterceptorChain.request();
        Transmitter transmitter = realInterceptorChain.transmitter();
        return realInterceptorChain.proceed(l1lRequest, transmitter, transmitter.newExchange(iL1Iii, !l1lRequest.m2873iILLL1().equals("GET")));
    }
}
