package p047IL;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: I丨L.丨lL, reason: invalid class name */
/* JADX INFO: compiled from: Dns.java */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class lL {
    public static /* synthetic */ List IL1Iii(String str) throws UnknownHostException {
        if (str == null) {
            throw new UnknownHostException("hostname == null");
        }
        try {
            return Arrays.asList(InetAddress.getAllByName(str));
        } catch (NullPointerException e) {
            UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
            unknownHostException.initCause(e);
            throw unknownHostException;
        }
    }
}
