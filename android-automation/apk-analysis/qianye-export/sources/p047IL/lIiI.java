package p047IL;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.tls.CertificateChainCleaner;
import p066Ilil.iILLL1;

/* JADX INFO: renamed from: I丨L.lIi丨I, reason: invalid class name */
/* JADX INFO: compiled from: CertificatePinner.java */
/* JADX INFO: loaded from: classes.dex */
public final class lIiI {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final lIiI f4660I1I = new IL1Iii().IL1Iii();

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Set<ILil> f4661IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    @Nullable
    public final CertificateChainCleaner f4662ILil;

    /* JADX INFO: renamed from: I丨L.lIi丨I$IL1Iii */
    /* JADX INFO: compiled from: CertificatePinner.java */
    public static final class IL1Iii {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final List<ILil> f4663IL1Iii = new ArrayList();

        public lIiI IL1Iii() {
            return new lIiI(new LinkedHashSet(this.f4663IL1Iii), null);
        }
    }

    /* JADX INFO: renamed from: I丨L.lIi丨I$ILil */
    /* JADX INFO: compiled from: CertificatePinner.java */
    public static final class ILil {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final String f4664I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final String f4665IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final String f4666ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final iILLL1 f2117IL;

        public boolean IL1Iii(String str) {
            if (!this.f4665IL1Iii.startsWith("*.")) {
                return str.equals(this.f4666ILil);
            }
            int iIndexOf = str.indexOf(46);
            if ((str.length() - iIndexOf) - 1 == this.f4666ILil.length()) {
                String str2 = this.f4666ILil;
                if (str.regionMatches(false, iIndexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ILil) {
                ILil iLil = (ILil) obj;
                if (this.f4665IL1Iii.equals(iLil.f4665IL1Iii) && this.f4664I1I.equals(iLil.f4664I1I) && this.f2117IL.equals(iLil.f2117IL)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f4665IL1Iii.hashCode()) * 31) + this.f4664I1I.hashCode()) * 31) + this.f2117IL.hashCode();
        }

        public String toString() {
            return this.f4664I1I + this.f2117IL.base64();
        }
    }

    public lIiI(Set<ILil> set, @Nullable CertificateChainCleaner certificateChainCleaner) {
        this.f4661IL1Iii = set;
        this.f4662ILil = certificateChainCleaner;
    }

    public static String I1I(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + Ilil((X509Certificate) certificate).base64();
    }

    public static iILLL1 Ilil(X509Certificate x509Certificate) {
        return iILLL1.m103of(x509Certificate.getPublicKey().getEncoded()).sha256();
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static iILLL1 m2901IL(X509Certificate x509Certificate) {
        return iILLL1.m103of(x509Certificate.getPublicKey().getEncoded()).sha1();
    }

    public void IL1Iii(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<ILil> listILil = ILil(str);
        if (listILil.isEmpty()) {
            return;
        }
        CertificateChainCleaner certificateChainCleaner = this.f4662ILil;
        if (certificateChainCleaner != null) {
            list = certificateChainCleaner.clean(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = listILil.size();
            iILLL1 iilll1Ilil = null;
            iILLL1 iilll1M2901IL = null;
            for (int i2 = 0; i2 < size2; i2++) {
                ILil iLil = listILil.get(i2);
                if (iLil.f4664I1I.equals("sha256/")) {
                    if (iilll1Ilil == null) {
                        iilll1Ilil = Ilil(x509Certificate);
                    }
                    if (iLil.f2117IL.equals(iilll1Ilil)) {
                        return;
                    }
                } else {
                    if (!iLil.f4664I1I.equals("sha1/")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + iLil.f4664I1I);
                    }
                    if (iilll1M2901IL == null) {
                        iilll1M2901IL = m2901IL(x509Certificate);
                    }
                    if (iLil.f2117IL.equals(iilll1M2901IL)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
            sb.append("\n    ");
            sb.append(I1I(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = listILil.size();
        for (int i4 = 0; i4 < size4; i4++) {
            ILil iLil2 = listILil.get(i4);
            sb.append("\n    ");
            sb.append(iLil2);
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public List<ILil> ILil(String str) {
        List<ILil> listEmptyList = Collections.emptyList();
        for (ILil iLil : this.f4661IL1Iii) {
            if (iLil.IL1Iii(str)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList<>();
                }
                listEmptyList.add(iLil);
            }
        }
        return listEmptyList;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof lIiI) {
            lIiI liii = (lIiI) obj;
            if (Objects.equals(this.f4662ILil, liii.f4662ILil) && this.f4661IL1Iii.equals(liii.f4661IL1Iii)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (Objects.hashCode(this.f4662ILil) * 31) + this.f4661IL1Iii.hashCode();
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public lIiI m2902lLi1LL(@Nullable CertificateChainCleaner certificateChainCleaner) {
        return Objects.equals(this.f4662ILil, certificateChainCleaner) ? this : new lIiI(this.f4661IL1Iii, certificateChainCleaner);
    }
}
