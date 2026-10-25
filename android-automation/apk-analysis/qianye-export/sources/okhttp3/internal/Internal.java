package okhttp3.internal;

import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealConnectionPool;
import p047IL.C0007;
import p047IL.IIi;
import p047IL.ILL;
import p047IL.L1l;
import p047IL.LlLLL;
import p047IL.lIlii;
import p047IL.lLi1LL;
import p047IL.llL1ii;

/* JADX INFO: loaded from: classes.dex */
public abstract class Internal {
    public static Internal instance;

    public static void initializeInstanceForTests() {
        new C0007();
    }

    public abstract void addLenient(LlLLL.IL1Iii iL1Iii, String str);

    public abstract void addLenient(LlLLL.IL1Iii iL1Iii, String str, String str2);

    public abstract void apply(lIlii lilii, SSLSocket sSLSocket, boolean z);

    public abstract int code(IIi.IL1Iii iL1Iii);

    public abstract boolean equalsNonHost(lLi1LL lli1ll, lLi1LL lli1ll2);

    @Nullable
    public abstract Exchange exchange(IIi iIi);

    public abstract void initExchange(IIi.IL1Iii iL1Iii, Exchange exchange);

    public abstract ILL newWebSocketCall(C0007 c0007, L1l l1l);

    public abstract RealConnectionPool realConnectionPool(llL1ii lll1ii);
}
