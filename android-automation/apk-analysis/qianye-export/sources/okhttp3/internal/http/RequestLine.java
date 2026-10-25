package okhttp3.internal.http;

import java.net.Proxy;
import p047IL.C0656lIII;
import p047IL.L1l;

/* JADX INFO: loaded from: classes.dex */
public final class RequestLine {
    private RequestLine() {
    }

    public static String get(L1l l1l, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(l1l.m2873iILLL1());
        sb.append(' ');
        if (includeAuthorityInRequestLine(l1l, type)) {
            sb.append(l1l.m2875il());
        } else {
            sb.append(requestPath(l1l.m2875il()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean includeAuthorityInRequestLine(L1l l1l, Proxy.Type type) {
        return !l1l.m2874lLi1LL() && type == Proxy.Type.HTTP;
    }

    public static String requestPath(C0656lIII c0656lIII) {
        String strM2907IiL = c0656lIII.m2907IiL();
        String strM2916il = c0656lIII.m2916il();
        if (strM2916il == null) {
            return strM2907IiL;
        }
        return strM2907IiL + '?' + strM2916il;
    }
}
