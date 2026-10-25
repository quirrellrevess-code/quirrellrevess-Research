package p047IL;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* JADX INFO: compiled from: Dns.java */
/* JADX INFO: loaded from: classes.dex */
public interface I11L {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final I11L f4599IL1Iii = new I11L() { // from class: I丨L.I1I
        @Override // p047IL.I11L
        public final List IL1Iii(String str) {
            return lL.IL1Iii(str);
        }
    };

    List<InetAddress> IL1Iii(String str) throws UnknownHostException;
}
