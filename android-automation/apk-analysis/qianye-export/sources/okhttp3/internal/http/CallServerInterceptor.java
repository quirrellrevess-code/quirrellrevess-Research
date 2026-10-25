package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import p047IL.IIi;
import p047IL.L1l;
import p047IL.LL1IL;
import p066Ilil.IL;
import p066Ilil.lIiI;

/* JADX INFO: loaded from: classes.dex */
public final class CallServerInterceptor implements LL1IL {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z) {
        this.forWebSocket = z;
    }

    @Override // p047IL.LL1IL
    public IIi intercept(LL1IL.IL1Iii iL1Iii) throws IOException {
        boolean z;
        IIi iIiI1I;
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) iL1Iii;
        Exchange exchange = realInterceptorChain.exchange();
        L1l l1lRequest = realInterceptorChain.request();
        long jCurrentTimeMillis = System.currentTimeMillis();
        exchange.writeRequestHeaders(l1lRequest);
        IIi.IL1Iii responseHeaders = null;
        if (!HttpMethod.permitsRequestBody(l1lRequest.m2873iILLL1()) || l1lRequest.IL1Iii() == null) {
            exchange.noRequestBody();
            z = false;
        } else {
            if ("100-continue".equalsIgnoreCase(l1lRequest.I1I("Expect"))) {
                exchange.flushRequest();
                exchange.responseHeadersStart();
                responseHeaders = exchange.readResponseHeaders(true);
                z = true;
            } else {
                z = false;
            }
            if (responseHeaders != null) {
                exchange.noRequestBody();
                if (!exchange.connection().isMultiplexed()) {
                    exchange.noNewExchangesOnConnection();
                }
            } else if (l1lRequest.IL1Iii().isDuplex()) {
                exchange.flushRequest();
                l1lRequest.IL1Iii().writeTo(lIiI.I1I(exchange.createRequestBody(l1lRequest, true)));
            } else {
                IL ilI1I = lIiI.I1I(exchange.createRequestBody(l1lRequest, false));
                l1lRequest.IL1Iii().writeTo(ilI1I);
                ilI1I.close();
            }
        }
        if (l1lRequest.IL1Iii() == null || !l1lRequest.IL1Iii().isDuplex()) {
            exchange.finishRequest();
        }
        if (!z) {
            exchange.responseHeadersStart();
        }
        if (responseHeaders == null) {
            responseHeaders = exchange.readResponseHeaders(false);
        }
        responseHeaders.m2863llL1ii(l1lRequest);
        responseHeaders.m2857IiL(exchange.connection().handshake());
        responseHeaders.m2862lIlii(jCurrentTimeMillis);
        responseHeaders.LlLI1(System.currentTimeMillis());
        IIi iIiI1I2 = responseHeaders.I1I();
        int iM2847L11 = iIiI1I2.m2847L11();
        if (iM2847L11 == 100) {
            IIi.IL1Iii responseHeaders2 = exchange.readResponseHeaders(false);
            responseHeaders2.m2863llL1ii(l1lRequest);
            responseHeaders2.m2857IiL(exchange.connection().handshake());
            responseHeaders2.m2862lIlii(jCurrentTimeMillis);
            responseHeaders2.LlLI1(System.currentTimeMillis());
            iIiI1I2 = responseHeaders2.I1I();
            iM2847L11 = iIiI1I2.m2847L11();
        }
        exchange.responseHeadersEnd(iIiI1I2);
        if (this.forWebSocket && iM2847L11 == 101) {
            IIi.IL1Iii iL1IiiM2853li11 = iIiI1I2.m2853li11();
            iL1IiiM2853li11.ILil(Util.EMPTY_RESPONSE);
            iIiI1I = iL1IiiM2853li11.I1I();
        } else {
            IIi.IL1Iii iL1IiiM2853li12 = iIiI1I2.m2853li11();
            iL1IiiM2853li12.ILil(exchange.openResponseBody(iIiI1I2));
            iIiI1I = iL1IiiM2853li12.I1I();
        }
        if ("close".equalsIgnoreCase(iIiI1I.m2848LIl().I1I("Connection")) || "close".equalsIgnoreCase(iIiI1I.m2844IIiI("Connection"))) {
            exchange.noNewExchangesOnConnection();
        }
        if ((iM2847L11 != 204 && iM2847L11 != 205) || iIiI1I.m2846IiL().contentLength() <= 0) {
            return iIiI1I;
        }
        throw new ProtocolException("HTTP " + iM2847L11 + " had non-zero Content-Length: " + iIiI1I.m2846IiL().contentLength());
    }
}
