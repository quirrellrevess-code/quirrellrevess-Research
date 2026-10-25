package p047IL;

import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: CipherSuite.java */
/* JADX INFO: loaded from: classes.dex */
public final class Lil {
    public static final Lil ILL;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public static final Lil f2092ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static final Lil f4634Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static final Lil f2093IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static final Lil f2094IiL;
    public static final Lil Lil;
    public static final Lil LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static final Lil f2095Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static final Lil f2096L11I;
    public static final Lil iIi1;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static final Lil f2097iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public static final Lil f2098lIiI;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public static final Lil f2099lIlii;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public static final Lil f2100llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static final Lil f2101lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static final Lil f2102il;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final String f4635IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final Comparator<String> f4633ILil = new Comparator() { // from class: I丨L.ILil
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Lil.m2867IL((String) obj, (String) obj2);
        }
    };

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final Map<String, Lil> f4632I1I = new LinkedHashMap();

    static {
        I1I("SSL_RSA_WITH_NULL_MD5", 1);
        I1I("SSL_RSA_WITH_NULL_SHA", 2);
        I1I("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        I1I("SSL_RSA_WITH_RC4_128_MD5", 4);
        I1I("SSL_RSA_WITH_RC4_128_SHA", 5);
        I1I("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        I1I("SSL_RSA_WITH_DES_CBC_SHA", 9);
        f2093IL = I1I("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        I1I("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        I1I("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        I1I("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        I1I("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        I1I("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        I1I("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        I1I("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        I1I("SSL_DH_anon_WITH_RC4_128_MD5", 24);
        I1I("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        I1I("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        I1I("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        I1I("TLS_KRB5_WITH_DES_CBC_SHA", 30);
        I1I("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        I1I("TLS_KRB5_WITH_RC4_128_SHA", 32);
        I1I("TLS_KRB5_WITH_DES_CBC_MD5", 34);
        I1I("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        I1I("TLS_KRB5_WITH_RC4_128_MD5", 36);
        I1I("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        I1I("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        I1I("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        I1I("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        f4634Ilil = I1I("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        I1I("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        I1I("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        I1I("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        f2101lLi1LL = I1I("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        I1I("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        I1I("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        I1I("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        I1I("TLS_RSA_WITH_NULL_SHA256", 59);
        I1I("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        I1I("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        I1I("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        I1I("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        I1I("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        I1I("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        I1I("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        I1I("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        I1I("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        I1I("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        I1I("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        I1I("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
        I1I("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        I1I("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        I1I("TLS_PSK_WITH_RC4_128_SHA", 138);
        I1I("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
        I1I("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
        I1I("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
        I1I("TLS_RSA_WITH_SEED_CBC_SHA", TbsListener.ErrorCode.STARTDOWNLOAD_API_LEVEL_BELOW_FROYO);
        f2097iILLL1 = I1I("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        f2094IiL = I1I("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        I1I("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        I1I("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
        I1I("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        I1I("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        I1I("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
        I1I("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        I1I("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        I1I("TLS_FALLBACK_SCSV", 22016);
        I1I("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        I1I("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        I1I("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        I1I("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        I1I("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        I1I("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        I1I("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        I1I("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        I1I("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        I1I("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        I1I("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        I1I("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        I1I("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        I1I("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        I1I("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        I1I("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        I1I("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        I1I("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        f2096L11I = I1I("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        f2102il = I1I("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        I1I("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        I1I("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        I1I("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        I1I("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        I1I("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        I1I("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        I1I("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        I1I("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        I1I("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        I1I("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        I1I("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        I1I("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        I1I("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        ILL = I1I("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        f2095Ll1 = I1I("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        I1I("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        I1I("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        f2098lIiI = I1I("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        f2092ILl = I1I("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        I1I("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        I1I("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        I1I("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        I1I("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        Lil = I1I("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        LlLI1 = I1I("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
        I1I("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        I1I("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
        f2100llL1ii = I1I("TLS_AES_128_GCM_SHA256", 4865);
        f2099lIlii = I1I("TLS_AES_256_GCM_SHA384", 4866);
        iIi1 = I1I("TLS_CHACHA20_POLY1305_SHA256", 4867);
        I1I("TLS_AES_128_CCM_SHA256", 4868);
        I1I("TLS_AES_128_CCM_8_SHA256", 4869);
    }

    public Lil(String str) {
        Objects.requireNonNull(str);
        this.f4635IL1Iii = str;
    }

    public static Lil I1I(String str, int i) {
        Lil lil = new Lil(str);
        f4632I1I.put(str, lil);
        return lil;
    }

    public static synchronized Lil IL1Iii(String str) {
        Lil lil;
        Map<String, Lil> map = f4632I1I;
        lil = map.get(str);
        if (lil == null) {
            lil = map.get(Ilil(str));
            if (lil == null) {
                lil = new Lil(str);
            }
            map.put(str, lil);
        }
        return lil;
    }

    public static List<Lil> ILil(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(IL1Iii(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static String Ilil(String str) {
        if (str.startsWith("TLS_")) {
            return "SSL_" + str.substring(4);
        }
        if (!str.startsWith("SSL_")) {
            return str;
        }
        return "TLS_" + str.substring(4);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static /* synthetic */ int m2867IL(String str, String str2) {
        int iMin = Math.min(str.length(), str2.length());
        for (int i = 4; i < iMin; i++) {
            char cCharAt = str.charAt(i);
            char cCharAt2 = str2.charAt(i);
            if (cCharAt != cCharAt2) {
                return cCharAt < cCharAt2 ? -1 : 1;
            }
        }
        int length = str.length();
        int length2 = str2.length();
        if (length != length2) {
            return length < length2 ? -1 : 1;
        }
        return 0;
    }

    public String toString() {
        return this.f4635IL1Iii;
    }
}
