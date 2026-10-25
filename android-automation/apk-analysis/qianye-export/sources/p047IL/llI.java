package p047IL;

import java.io.IOException;

/* JADX INFO: compiled from: Protocol.java */
/* JADX INFO: loaded from: classes.dex */
public enum llI {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");

    private final String protocol;

    llI(String str) {
        this.protocol = str;
    }

    public static llI get(String str) throws IOException {
        llI lli = HTTP_1_0;
        if (str.equals(lli.protocol)) {
            return lli;
        }
        llI lli2 = HTTP_1_1;
        if (str.equals(lli2.protocol)) {
            return lli2;
        }
        llI lli3 = H2_PRIOR_KNOWLEDGE;
        if (str.equals(lli3.protocol)) {
            return lli3;
        }
        llI lli4 = HTTP_2;
        if (str.equals(lli4.protocol)) {
            return lli4;
        }
        llI lli5 = SPDY_3;
        if (str.equals(lli5.protocol)) {
            return lli5;
        }
        llI lli6 = QUIC;
        if (str.equals(lli6.protocol)) {
            return lli6;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
