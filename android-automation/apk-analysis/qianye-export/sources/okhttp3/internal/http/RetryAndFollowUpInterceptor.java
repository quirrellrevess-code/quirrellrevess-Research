package okhttp3.internal.http;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.annotation.Nullable;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.Transmitter;
import okhttp3.internal.http2.ConnectionShutdownException;
import org.opencv.videoio.Videoio;
import p047IL.C0007;
import p047IL.C0655ill;
import p047IL.C0656lIII;
import p047IL.IIi;
import p047IL.L1l;
import p047IL.LL1IL;
import p047IL.iILLl;

/* JADX INFO: loaded from: classes.dex */
public final class RetryAndFollowUpInterceptor implements LL1IL {
    private static final int MAX_FOLLOW_UPS = 20;
    private final C0007 client;

    public RetryAndFollowUpInterceptor(C0007 c0007) {
        this.client = c0007;
    }

    private L1l followUpRequest(IIi iIi, @Nullable C0655ill c0655ill) throws IOException {
        String strM2844IIiI;
        C0656lIII c0656lIIILL1IL;
        if (iIi == null) {
            throw new IllegalStateException();
        }
        int iM2847L11 = iIi.m2847L11();
        String strM2873iILLL1 = iIi.m2848LIl().m2873iILLL1();
        if (iM2847L11 == 307 || iM2847L11 == 308) {
            if (!strM2873iILLL1.equals("GET") && !strM2873iILLL1.equals("HEAD")) {
                return null;
            }
        } else {
            if (iM2847L11 == 401) {
                return this.client.ILil().IL1Iii(c0655ill, iIi);
            }
            if (iM2847L11 == 503) {
                if ((iIi.iIilII1() == null || iIi.iIilII1().m2847L11() != 503) && retryAfter(iIi, Integer.MAX_VALUE) == 0) {
                    return iIi.m2848LIl();
                }
                return null;
            }
            if (iM2847L11 == 407) {
                if ((c0655ill != null ? c0655ill.ILil() : this.client.I11L()).type() == Proxy.Type.HTTP) {
                    return this.client.llliI().IL1Iii(c0655ill, iIi);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (iM2847L11 == 408) {
                if (!this.client.m2969LlLLL()) {
                    return null;
                }
                iILLl iilllIL1Iii = iIi.m2848LIl().IL1Iii();
                if (iilllIL1Iii != null && iilllIL1Iii.isOneShot()) {
                    return null;
                }
                if ((iIi.iIilII1() == null || iIi.iIilII1().m2847L11() != 408) && retryAfter(iIi, 0) <= 0) {
                    return iIi.m2848LIl();
                }
                return null;
            }
            switch (iM2847L11) {
                case 300:
                case Videoio.CAP_PROP_PVAPI_FRAMESTARTTRIGGERMODE /* 301 */:
                case Videoio.CAP_PROP_PVAPI_DECIMATIONHORIZONTAL /* 302 */:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.client.m2971lIiI() || (strM2844IIiI = iIi.m2844IIiI("Location")) == null || (c0656lIIILL1IL = iIi.m2848LIl().m2875il().LL1IL(strM2844IIiI)) == null) {
            return null;
        }
        if (!c0656lIIILL1IL.m2908L111().equals(iIi.m2848LIl().m2875il().m2908L111()) && !this.client.m2964ILl()) {
            return null;
        }
        L1l.IL1Iii iL1IiiM2871IiL = iIi.m2848LIl().m2871IiL();
        if (HttpMethod.permitsRequestBody(strM2873iILLL1)) {
            boolean zRedirectsWithBody = HttpMethod.redirectsWithBody(strM2873iILLL1);
            if (HttpMethod.redirectsToGet(strM2873iILLL1)) {
                iL1IiiM2871IiL.Ilil("GET", null);
            } else {
                iL1IiiM2871IiL.Ilil(strM2873iILLL1, zRedirectsWithBody ? iIi.m2848LIl().IL1Iii() : null);
            }
            if (!zRedirectsWithBody) {
                iL1IiiM2871IiL.m2879iILLL1("Transfer-Encoding");
                iL1IiiM2871IiL.m2879iILLL1("Content-Length");
                iL1IiiM2871IiL.m2879iILLL1("Content-Type");
            }
        }
        if (!Util.sameConnection(iIi.m2848LIl().m2875il(), c0656lIIILL1IL)) {
            iL1IiiM2871IiL.m2879iILLL1("Authorization");
        }
        iL1IiiM2871IiL.m2881il(c0656lIIILL1IL);
        return iL1IiiM2871IiL.ILil();
    }

    private boolean isRecoverable(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            return (iOException instanceof SocketTimeoutException) && !z;
        }
        return (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private boolean recover(IOException iOException, Transmitter transmitter, boolean z, L1l l1l) {
        if (this.client.m2969LlLLL()) {
            return !(z && requestIsOneShot(iOException, l1l)) && isRecoverable(iOException, z) && transmitter.canRetry();
        }
        return false;
    }

    private boolean requestIsOneShot(IOException iOException, L1l l1l) {
        iILLl iilllIL1Iii = l1l.IL1Iii();
        return (iilllIL1Iii != null && iilllIL1Iii.isOneShot()) || (iOException instanceof FileNotFoundException);
    }

    private int retryAfter(IIi iIi, int i) {
        String strM2844IIiI = iIi.m2844IIiI("Retry-After");
        if (strM2844IIiI == null) {
            return i;
        }
        if (strM2844IIiI.matches("\\d+")) {
            return Integer.valueOf(strM2844IIiI).intValue();
        }
        return Integer.MAX_VALUE;
    }

    @Override // p047IL.LL1IL
    public IIi intercept(LL1IL.IL1Iii iL1Iii) throws IOException {
        L1l l1lRequest = iL1Iii.request();
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) iL1Iii;
        Transmitter transmitter = realInterceptorChain.transmitter();
        IIi iIi = null;
        int i = 0;
        while (true) {
            transmitter.prepareToConnect(l1lRequest);
            if (transmitter.isCanceled()) {
                throw new IOException("Canceled");
            }
            try {
                try {
                    try {
                        IIi iIiProceed = realInterceptorChain.proceed(l1lRequest, transmitter, null);
                        if (iIi != null) {
                            IIi.IL1Iii iL1IiiM2853li11 = iIiProceed.m2853li11();
                            IIi.IL1Iii iL1IiiM2853li12 = iIi.m2853li11();
                            iL1IiiM2853li12.ILil(null);
                            iL1IiiM2853li11.m2855ILl(iL1IiiM2853li12.I1I());
                            iIiProceed = iL1IiiM2853li11.I1I();
                        }
                        iIi = iIiProceed;
                        Exchange exchange = Internal.instance.exchange(iIi);
                        L1l l1lFollowUpRequest = followUpRequest(iIi, exchange != null ? exchange.connection().route() : null);
                        if (l1lFollowUpRequest == null) {
                            if (exchange != null && exchange.isDuplex()) {
                                transmitter.timeoutEarlyExit();
                            }
                            return iIi;
                        }
                        iILLl iilllIL1Iii = l1lFollowUpRequest.IL1Iii();
                        if (iilllIL1Iii != null && iilllIL1Iii.isOneShot()) {
                            return iIi;
                        }
                        Util.closeQuietly(iIi.m2846IiL());
                        if (transmitter.hasExchange()) {
                            exchange.detachWithViolence();
                        }
                        i++;
                        if (i > 20) {
                            throw new ProtocolException("Too many follow-up requests: " + i);
                        }
                        l1lRequest = l1lFollowUpRequest;
                    } catch (RouteException e) {
                        if (!recover(e.getLastConnectException(), transmitter, false, l1lRequest)) {
                            throw e.getFirstConnectException();
                        }
                        transmitter.exchangeDoneDueToException();
                    }
                } catch (IOException e2) {
                    if (!recover(e2, transmitter, !(e2 instanceof ConnectionShutdownException), l1lRequest)) {
                        throw e2;
                    }
                    transmitter.exchangeDoneDueToException();
                }
            } catch (Throwable th) {
                transmitter.exchangeDoneDueToException();
                throw th;
            }
        }
    }
}
