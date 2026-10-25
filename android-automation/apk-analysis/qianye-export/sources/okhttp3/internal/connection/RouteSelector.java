package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.internal.Util;
import p047IL.C0655ill;
import p047IL.C0656lIII;
import p047IL.ILL;
import p047IL.lLi1LL;
import p047IL.llliI;

/* JADX INFO: loaded from: classes.dex */
public final class RouteSelector {
    private final lLi1LL address;
    private final ILL call;
    private final llliI eventListener;
    private int nextProxyIndex;
    private final RouteDatabase routeDatabase;
    private List<Proxy> proxies = Collections.emptyList();
    private List<InetSocketAddress> inetSocketAddresses = Collections.emptyList();
    private final List<C0655ill> postponedRoutes = new ArrayList();

    public static final class Selection {
        private int nextRouteIndex = 0;
        private final List<C0655ill> routes;

        public Selection(List<C0655ill> list) {
            this.routes = list;
        }

        public List<C0655ill> getAll() {
            return new ArrayList(this.routes);
        }

        public boolean hasNext() {
            return this.nextRouteIndex < this.routes.size();
        }

        public C0655ill next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            List<C0655ill> list = this.routes;
            int i = this.nextRouteIndex;
            this.nextRouteIndex = i + 1;
            return list.get(i);
        }
    }

    public RouteSelector(lLi1LL lli1ll, RouteDatabase routeDatabase, ILL ill, llliI lllii) {
        this.address = lli1ll;
        this.routeDatabase = routeDatabase;
        this.call = ill;
        this.eventListener = lllii;
        resetNextProxy(lli1ll.m2952Ll1(), lli1ll.m2954iILLL1());
    }

    public static String getHostString(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    private boolean hasNextProxy() {
        return this.nextProxyIndex < this.proxies.size();
    }

    private Proxy nextProxy() throws IOException {
        if (hasNextProxy()) {
            List<Proxy> list = this.proxies;
            int i = this.nextProxyIndex;
            this.nextProxyIndex = i + 1;
            Proxy proxy = list.get(i);
            resetNextInetSocketAddress(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.address.m2952Ll1().m2911lIiI() + "; exhausted proxy configurations: " + this.proxies);
    }

    private void resetNextInetSocketAddress(Proxy proxy) throws IOException {
        String strM2911lIiI;
        int iM2918l;
        this.inetSocketAddresses = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strM2911lIiI = this.address.m2952Ll1().m2911lIiI();
            iM2918l = this.address.m2952Ll1().m2918l();
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            strM2911lIiI = getHostString(inetSocketAddress);
            iM2918l = inetSocketAddress.getPort();
        }
        if (iM2918l < 1 || iM2918l > 65535) {
            throw new SocketException("No route to " + strM2911lIiI + ":" + iM2918l + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.inetSocketAddresses.add(InetSocketAddress.createUnresolved(strM2911lIiI, iM2918l));
            return;
        }
        this.eventListener.m2948il(this.call, strM2911lIiI);
        List<InetAddress> listIL1Iii = this.address.I1I().IL1Iii(strM2911lIiI);
        if (listIL1Iii.isEmpty()) {
            throw new UnknownHostException(this.address.I1I() + " returned no addresses for " + strM2911lIiI);
        }
        this.eventListener.m2942L11I(this.call, strM2911lIiI, listIL1Iii);
        int size = listIL1Iii.size();
        for (int i = 0; i < size; i++) {
            this.inetSocketAddresses.add(new InetSocketAddress(listIL1Iii.get(i), iM2918l));
        }
    }

    private void resetNextProxy(C0656lIII c0656lIII, Proxy proxy) {
        if (proxy != null) {
            this.proxies = Collections.singletonList(proxy);
        } else {
            List<Proxy> listSelect = this.address.m2953L11I().select(c0656lIII.m2919LLlI1());
            this.proxies = (listSelect == null || listSelect.isEmpty()) ? Util.immutableList(Proxy.NO_PROXY) : Util.immutableList(listSelect);
        }
        this.nextProxyIndex = 0;
    }

    public boolean hasNext() {
        return hasNextProxy() || !this.postponedRoutes.isEmpty();
    }

    public Selection next() throws IOException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (hasNextProxy()) {
            Proxy proxyNextProxy = nextProxy();
            int size = this.inetSocketAddresses.size();
            for (int i = 0; i < size; i++) {
                C0655ill c0655ill = new C0655ill(this.address, proxyNextProxy, this.inetSocketAddresses.get(i));
                if (this.routeDatabase.shouldPostpone(c0655ill)) {
                    this.postponedRoutes.add(c0655ill);
                } else {
                    arrayList.add(c0655ill);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.postponedRoutes);
            this.postponedRoutes.clear();
        }
        return new Selection(arrayList);
    }
}
