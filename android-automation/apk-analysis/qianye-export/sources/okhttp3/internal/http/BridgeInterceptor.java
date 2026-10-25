package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import p047IL.IIi;
import p047IL.L111;
import p047IL.L1l;
import p047IL.LL1IL;
import p047IL.LlLLL;
import p047IL.iILLl;
import p047IL.iIi1;
import p047IL.iIlLiL;
import p066Ilil.ILL;
import p066Ilil.lIiI;

/* JADX INFO: loaded from: classes.dex */
public final class BridgeInterceptor implements LL1IL {
    private final iIlLiL cookieJar;

    public BridgeInterceptor(iIlLiL iillil) {
        this.cookieJar = iillil;
    }

    private String cookieHeader(List<iIi1> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            iIi1 iii1 = list.get(i);
            sb.append(iii1.I1I());
            sb.append('=');
            sb.append(iii1.ILL());
        }
        return sb.toString();
    }

    @Override // p047IL.LL1IL
    public IIi intercept(LL1IL.IL1Iii iL1Iii) throws IOException {
        L1l l1lRequest = iL1Iii.request();
        L1l.IL1Iii iL1IiiM2871IiL = l1lRequest.m2871IiL();
        iILLl iilllIL1Iii = l1lRequest.IL1Iii();
        if (iilllIL1Iii != null) {
            L111 l111ContentType = iilllIL1Iii.contentType();
            if (l111ContentType != null) {
                iL1IiiM2871IiL.I1I("Content-Type", l111ContentType.toString());
            }
            long jContentLength = iilllIL1Iii.contentLength();
            if (jContentLength != -1) {
                iL1IiiM2871IiL.I1I("Content-Length", Long.toString(jContentLength));
                iL1IiiM2871IiL.m2879iILLL1("Transfer-Encoding");
            } else {
                iL1IiiM2871IiL.I1I("Transfer-Encoding", "chunked");
                iL1IiiM2871IiL.m2879iILLL1("Content-Length");
            }
        }
        boolean z = false;
        if (l1lRequest.I1I("Host") == null) {
            iL1IiiM2871IiL.I1I("Host", Util.hostHeader(l1lRequest.m2875il(), false));
        }
        if (l1lRequest.I1I("Connection") == null) {
            iL1IiiM2871IiL.I1I("Connection", "Keep-Alive");
        }
        if (l1lRequest.I1I("Accept-Encoding") == null && l1lRequest.I1I("Range") == null) {
            z = true;
            iL1IiiM2871IiL.I1I("Accept-Encoding", "gzip");
        }
        List<iIi1> listILil = this.cookieJar.ILil(l1lRequest.m2875il());
        if (!listILil.isEmpty()) {
            iL1IiiM2871IiL.I1I("Cookie", cookieHeader(listILil));
        }
        if (l1lRequest.I1I("User-Agent") == null) {
            iL1IiiM2871IiL.I1I("User-Agent", Version.userAgent());
        }
        IIi iIiProceed = iL1Iii.proceed(iL1IiiM2871IiL.ILil());
        HttpHeaders.receiveHeaders(this.cookieJar, l1lRequest.m2875il(), iIiProceed.LLL());
        IIi.IL1Iii iL1IiiM2853li11 = iIiProceed.m2853li11();
        iL1IiiM2853li11.m2863llL1ii(l1lRequest);
        if (z && "gzip".equalsIgnoreCase(iIiProceed.m2844IIiI("Content-Encoding")) && HttpHeaders.hasBody(iIiProceed)) {
            ILL ill = new ILL(iIiProceed.m2846IiL().source());
            LlLLL.IL1Iii iL1IiiM2886lLi1LL = iIiProceed.LLL().m2886lLi1LL();
            iL1IiiM2886lLi1LL.m2890lLi1LL("Content-Encoding");
            iL1IiiM2886lLi1LL.m2890lLi1LL("Content-Length");
            iL1IiiM2853li11.m2865il(iL1IiiM2886lLi1LL.Ilil());
            iL1IiiM2853li11.ILil(new RealResponseBody(iIiProceed.m2844IIiI("Content-Type"), -1L, lIiI.m2826IL(ill)));
        }
        return iL1IiiM2853li11.I1I();
    }
}
