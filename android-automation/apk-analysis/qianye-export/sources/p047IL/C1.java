package p047IL;

import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.Util;

/* JADX INFO: renamed from: I丨L.丨丨丨1丨, reason: invalid class name */
/* JADX INFO: compiled from: Handshake.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1 {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final List<Certificate> f4726I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final EnumC0592 f4727IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final Lil f4728ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final List<Certificate> f2191IL;

    public C1(EnumC0592 enumC0592, Lil lil, List<Certificate> list, List<Certificate> list2) {
        this.f4727IL1Iii = enumC0592;
        this.f4728ILil = lil;
        this.f4726I1I = list;
        this.f2191IL = list2;
    }

    public static C1 ILil(SSLSession sSLSession) throws IOException {
        Certificate[] peerCertificates;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        Lil lilIL1Iii = Lil.IL1Iii(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        EnumC0592 enumC0592ForJavaName = EnumC0592.forJavaName(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            peerCertificates = null;
        }
        List listImmutableList = peerCertificates != null ? Util.immutableList(peerCertificates) : Collections.emptyList();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new C1(enumC0592ForJavaName, lilIL1Iii, listImmutableList, localCertificates != null ? Util.immutableList(localCertificates) : Collections.emptyList());
    }

    public final List<String> I1I(List<Certificate> list) {
        ArrayList arrayList = new ArrayList();
        for (Certificate certificate : list) {
            if (certificate instanceof X509Certificate) {
                arrayList.add(String.valueOf(((X509Certificate) certificate).getSubjectDN()));
            } else {
                arrayList.add(certificate.getType());
            }
        }
        return arrayList;
    }

    public Lil IL1Iii() {
        return this.f4728ILil;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public List<Certificate> m2983IL() {
        return this.f4726I1I;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof C1)) {
            return false;
        }
        C1 c1 = (C1) obj;
        return this.f4727IL1Iii.equals(c1.f4727IL1Iii) && this.f4728ILil.equals(c1.f4728ILil) && this.f4726I1I.equals(c1.f4726I1I) && this.f2191IL.equals(c1.f2191IL);
    }

    public int hashCode() {
        return ((((((527 + this.f4727IL1Iii.hashCode()) * 31) + this.f4728ILil.hashCode()) * 31) + this.f4726I1I.hashCode()) * 31) + this.f2191IL.hashCode();
    }

    public String toString() {
        return "Handshake{tlsVersion=" + this.f4727IL1Iii + " cipherSuite=" + this.f4728ILil + " peerCertificates=" + I1I(this.f4726I1I) + " localCertificates=" + I1I(this.f2191IL) + '}';
    }
}
