package ILil.p028IiL.ILL;

import ILil.p028IiL.p034lIiI.L11I;
import android.util.Base64;
import java.util.List;

/* JADX INFO: compiled from: FontRequest.java */
/* JADX INFO: loaded from: classes.dex */
public final class IL1Iii {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final String f4011I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final String f4012IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final String f4013ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final int f4014Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final List<List<byte[]>> f1606IL;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final String f1607lLi1LL;

    public IL1Iii(String str, String str2, String str3, List<List<byte[]>> list) {
        L11I.m2295IL(str);
        String str4 = str;
        this.f4012IL1Iii = str4;
        L11I.m2295IL(str2);
        String str5 = str2;
        this.f4013ILil = str5;
        L11I.m2295IL(str3);
        String str6 = str3;
        this.f4011I1I = str6;
        L11I.m2295IL(list);
        this.f1606IL = list;
        this.f4014Ilil = 0;
        this.f1607lLi1LL = str4 + "-" + str5 + "-" + str6;
    }

    public String I1I() {
        return this.f1607lLi1LL;
    }

    public List<List<byte[]>> IL1Iii() {
        return this.f1606IL;
    }

    public int ILil() {
        return this.f4014Ilil;
    }

    public String Ilil() {
        return this.f4013ILil;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public String m2013IL() {
        return this.f4012IL1Iii;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public String m2014lLi1LL() {
        return this.f4011I1I;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f4012IL1Iii + ", mProviderPackage: " + this.f4013ILil + ", mQuery: " + this.f4011I1I + ", mCertificates:");
        for (int i = 0; i < this.f1606IL.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.f1606IL.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f4014Ilil);
        return sb.toString();
    }
}
