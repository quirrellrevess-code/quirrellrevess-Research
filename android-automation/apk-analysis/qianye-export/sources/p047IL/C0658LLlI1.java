package p047IL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import p066Ilil.I1I;
import p066Ilil.IL;
import p066Ilil.iILLL1;

/* JADX INFO: renamed from: I丨L.丨丨LLlI1, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: MultipartBody.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0658LLlI1 extends iILLl {

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static final L111 f4717Ilil = L111.I1I("multipart/mixed");

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static final byte[] f2186IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static final byte[] f2187L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static final byte[] f2188iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static final L111 f2189lLi1LL;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final List<ILil> f4718I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final iILLL1 f4719IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final L111 f4720ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public long f2190IL = -1;

    /* JADX INFO: renamed from: I丨L.丨丨LLlI1$IL1Iii */
    /* JADX INFO: compiled from: MultipartBody.java */
    public static final class IL1Iii {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final List<ILil> f4721I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final iILLL1 f4722IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public L111 f4723ILil;

        public IL1Iii() {
            this(UUID.randomUUID().toString());
        }

        public C0658LLlI1 I1I() {
            if (this.f4721I1I.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new C0658LLlI1(this.f4722IL1Iii, this.f4723ILil, this.f4721I1I);
        }

        public IL1Iii IL1Iii(@Nullable LlLLL llLLL, iILLl iilll) {
            ILil(ILil.IL1Iii(llLLL, iilll));
            return this;
        }

        public IL1Iii ILil(ILil iLil) {
            Objects.requireNonNull(iLil, "part == null");
            this.f4721I1I.add(iLil);
            return this;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public IL1Iii m2982IL(L111 l111) {
            Objects.requireNonNull(l111, "type == null");
            if (l111.Ilil().equals("multipart")) {
                this.f4723ILil = l111;
                return this;
            }
            throw new IllegalArgumentException("multipart != " + l111);
        }

        public IL1Iii(String str) {
            this.f4723ILil = C0658LLlI1.f4717Ilil;
            this.f4721I1I = new ArrayList();
            this.f4722IL1Iii = iILLL1.encodeUtf8(str);
        }
    }

    /* JADX INFO: renamed from: I丨L.丨丨LLlI1$ILil */
    /* JADX INFO: compiled from: MultipartBody.java */
    public static final class ILil {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        @Nullable
        public final LlLLL f4724IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final iILLl f4725ILil;

        public ILil(@Nullable LlLLL llLLL, iILLl iilll) {
            this.f4724IL1Iii = llLLL;
            this.f4725ILil = iilll;
        }

        public static ILil IL1Iii(@Nullable LlLLL llLLL, iILLl iilll) {
            Objects.requireNonNull(iilll, "body == null");
            if (llLLL != null && llLLL.I1I("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (llLLL == null || llLLL.I1I("Content-Length") == null) {
                return new ILil(llLLL, iilll);
            }
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }
    }

    static {
        L111.I1I("multipart/alternative");
        L111.I1I("multipart/digest");
        L111.I1I("multipart/parallel");
        f2189lLi1LL = L111.I1I("multipart/form-data");
        f2188iILLL1 = new byte[]{58, 32};
        f2186IiL = new byte[]{13, 10};
        f2187L11I = new byte[]{45, 45};
    }

    public C0658LLlI1(iILLL1 iilll1, L111 l111, List<ILil> list) {
        this.f4719IL1Iii = iilll1;
        this.f4720ILil = L111.I1I(l111 + "; boundary=" + iilll1.utf8());
        this.f4718I1I = Util.immutableList(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long IL1Iii(@Nullable IL il, boolean z) throws IOException {
        I1I i1i;
        if (z) {
            il = new I1I();
            i1i = il;
        } else {
            i1i = 0;
        }
        int size = this.f4718I1I.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            ILil iLil = this.f4718I1I.get(i);
            LlLLL llLLL = iLil.f4724IL1Iii;
            iILLl iilll = iLil.f4725ILil;
            il.mo2797lIII(f2187L11I);
            il.LL1IL(this.f4719IL1Iii);
            il.mo2797lIII(f2186IiL);
            if (llLLL != null) {
                int iM2884IiL = llLLL.m2884IiL();
                for (int i2 = 0; i2 < iM2884IiL; i2++) {
                    il.LlLI1(llLLL.Ilil(i2)).mo2797lIII(f2188iILLL1).LlLI1(llLLL.m2885L11I(i2)).mo2797lIII(f2186IiL);
                }
            }
            L111 l111ContentType = iilll.contentType();
            if (l111ContentType != null) {
                il.LlLI1("Content-Type: ").LlLI1(l111ContentType.toString()).mo2797lIII(f2186IiL);
            }
            long jContentLength = iilll.contentLength();
            if (jContentLength != -1) {
                il.LlLI1("Content-Length: ").mo2794l1IIi1(jContentLength).mo2797lIII(f2186IiL);
            } else if (z) {
                i1i.m2811();
                return -1L;
            }
            byte[] bArr = f2186IiL;
            il.mo2797lIII(bArr);
            if (z) {
                j += jContentLength;
            } else {
                iilll.writeTo(il);
            }
            il.mo2797lIII(bArr);
        }
        byte[] bArr2 = f2187L11I;
        il.mo2797lIII(bArr2);
        il.LL1IL(this.f4719IL1Iii);
        il.mo2797lIII(bArr2);
        il.mo2797lIII(f2186IiL);
        if (!z) {
            return j;
        }
        long jM96I = j + i1i.m96I();
        i1i.m2811();
        return jM96I;
    }

    @Override // p047IL.iILLl
    public long contentLength() throws IOException {
        long j = this.f2190IL;
        if (j != -1) {
            return j;
        }
        long jIL1Iii = IL1Iii(null, true);
        this.f2190IL = jIL1Iii;
        return jIL1Iii;
    }

    @Override // p047IL.iILLl
    public L111 contentType() {
        return this.f4720ILil;
    }

    @Override // p047IL.iILLl
    public void writeTo(IL il) throws IOException {
        IL1Iii(il, false);
    }
}
