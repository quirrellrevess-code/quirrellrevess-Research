package retrofit2;

import com.mysql.jdbc.StatementImpl;
import java.io.IOException;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import p047IL.C0656lIII;
import p047IL.C0658LLlI1;
import p047IL.L111;
import p047IL.L1l;
import p047IL.LlLLL;
import p047IL.iILLl;
import p047IL.l;
import p066Ilil.I1I;
import p066Ilil.IL;

/* JADX INFO: loaded from: classes.dex */
public final class RequestBuilder {
    private static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
    private final C0656lIII baseUrl;

    @Nullable
    private iILLl body;

    @Nullable
    private L111 contentType;

    @Nullable
    private l.IL1Iii formBuilder;
    private final boolean hasBody;
    private final LlLLL.IL1Iii headersBuilder;
    private final String method;

    @Nullable
    private C0658LLlI1.IL1Iii multipartBuilder;

    @Nullable
    private String relativeUrl;
    private final L1l.IL1Iii requestBuilder = new L1l.IL1Iii();

    @Nullable
    private C0656lIII.IL1Iii urlBuilder;
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final Pattern PATH_TRAVERSAL = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    public static class ContentTypeOverridingRequestBody extends iILLl {
        private final L111 contentType;
        private final iILLl delegate;

        public ContentTypeOverridingRequestBody(iILLl iilll, L111 l111) {
            this.delegate = iilll;
            this.contentType = l111;
        }

        @Override // p047IL.iILLl
        public long contentLength() throws IOException {
            return this.delegate.contentLength();
        }

        @Override // p047IL.iILLl
        public L111 contentType() {
            return this.contentType;
        }

        @Override // p047IL.iILLl
        public void writeTo(IL il) throws IOException {
            this.delegate.writeTo(il);
        }
    }

    public RequestBuilder(String str, C0656lIII c0656lIII, @Nullable String str2, @Nullable LlLLL llLLL, @Nullable L111 l111, boolean z, boolean z2, boolean z3) {
        this.method = str;
        this.baseUrl = c0656lIII;
        this.relativeUrl = str2;
        this.contentType = l111;
        this.hasBody = z;
        if (llLLL != null) {
            this.headersBuilder = llLLL.m2886lLi1LL();
        } else {
            this.headersBuilder = new LlLLL.IL1Iii();
        }
        if (z2) {
            this.formBuilder = new l.IL1Iii();
        } else if (z3) {
            C0658LLlI1.IL1Iii iL1Iii = new C0658LLlI1.IL1Iii();
            this.multipartBuilder = iL1Iii;
            iL1Iii.m2982IL(C0658LLlI1.f2189lLi1LL);
        }
    }

    private static String canonicalizeForPath(String str, boolean z) {
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(iCodePointAt) != -1 || (!z && (iCodePointAt == 47 || iCodePointAt == 37))) {
                I1I i1i = new I1I();
                i1i.m97LL(str, 0, iCharCount);
                canonicalizeForPath(i1i, str, iCharCount, length, z);
                return i1i.mo2785LlLLL();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str;
    }

    public void addFormField(String str, String str2, boolean z) {
        if (z) {
            this.formBuilder.ILil(str, str2);
        } else {
            this.formBuilder.IL1Iii(str, str2);
        }
    }

    public void addHeader(String str, String str2) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            this.headersBuilder.IL1Iii(str, str2);
            return;
        }
        try {
            this.contentType = L111.I1I(str2);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Malformed content type: " + str2, e);
        }
    }

    public void addHeaders(LlLLL llLLL) {
        this.headersBuilder.ILil(llLLL);
    }

    public void addPart(LlLLL llLLL, iILLl iilll) {
        this.multipartBuilder.IL1Iii(llLLL, iilll);
    }

    public void addPathParam(String str, String str2, boolean z) {
        if (this.relativeUrl == null) {
            throw new AssertionError();
        }
        String strCanonicalizeForPath = canonicalizeForPath(str2, z);
        String strReplace = this.relativeUrl.replace("{" + str + "}", strCanonicalizeForPath);
        if (!PATH_TRAVERSAL.matcher(strReplace).matches()) {
            this.relativeUrl = strReplace;
            return;
        }
        throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
    }

    public void addQueryParam(String str, @Nullable String str2, boolean z) {
        String str3 = this.relativeUrl;
        if (str3 != null) {
            C0656lIII.IL1Iii iL1IiiM2914llL1ii = this.baseUrl.m2914llL1ii(str3);
            this.urlBuilder = iL1IiiM2914llL1ii;
            if (iL1IiiM2914llL1ii == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
            this.relativeUrl = null;
        }
        if (z) {
            this.urlBuilder.IL1Iii(str, str2);
        } else {
            this.urlBuilder.ILil(str, str2);
        }
    }

    public <T> void addTag(Class<T> cls, @Nullable T t) {
        this.requestBuilder.m2877IiL(cls, t);
    }

    public L1l.IL1Iii get() {
        C0656lIII c0656lIIILL1IL;
        C0656lIII.IL1Iii iL1Iii = this.urlBuilder;
        if (iL1Iii != null) {
            c0656lIIILL1IL = iL1Iii.I1I();
        } else {
            c0656lIIILL1IL = this.baseUrl.LL1IL(this.relativeUrl);
            if (c0656lIIILL1IL == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
        }
        iILLl contentTypeOverridingRequestBody = this.body;
        if (contentTypeOverridingRequestBody == null) {
            l.IL1Iii iL1Iii2 = this.formBuilder;
            if (iL1Iii2 != null) {
                contentTypeOverridingRequestBody = iL1Iii2.I1I();
            } else {
                C0658LLlI1.IL1Iii iL1Iii3 = this.multipartBuilder;
                if (iL1Iii3 != null) {
                    contentTypeOverridingRequestBody = iL1Iii3.I1I();
                } else if (this.hasBody) {
                    contentTypeOverridingRequestBody = iILLl.create((L111) null, new byte[0]);
                }
            }
        }
        L111 l111 = this.contentType;
        if (l111 != null) {
            if (contentTypeOverridingRequestBody != null) {
                contentTypeOverridingRequestBody = new ContentTypeOverridingRequestBody(contentTypeOverridingRequestBody, l111);
            } else {
                this.headersBuilder.IL1Iii("Content-Type", l111.toString());
            }
        }
        L1l.IL1Iii iL1Iii4 = this.requestBuilder;
        iL1Iii4.m2881il(c0656lIIILL1IL);
        iL1Iii4.m2876IL(this.headersBuilder.Ilil());
        iL1Iii4.Ilil(this.method, contentTypeOverridingRequestBody);
        return iL1Iii4;
    }

    public void setBody(iILLl iilll) {
        this.body = iilll;
    }

    public void setRelativeUrl(Object obj) {
        this.relativeUrl = obj.toString();
    }

    public void addPart(C0658LLlI1.ILil iLil) {
        this.multipartBuilder.ILil(iLil);
    }

    private static void canonicalizeForPath(I1I i1i, String str, int i, int i2, boolean z) {
        I1I i1i2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt >= 32 && iCodePointAt < 127 && PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(iCodePointAt) == -1 && (z || (iCodePointAt != 47 && iCodePointAt != 37))) {
                    i1i.m2793i1I1I1l(iCodePointAt);
                } else {
                    if (i1i2 == null) {
                        i1i2 = new I1I();
                    }
                    i1i2.m2793i1I1I1l(iCodePointAt);
                    while (!i1i2.ILL()) {
                        int iMo2798lIlii = i1i2.mo2798lIlii() & StatementImpl.USES_VARIABLES_UNKNOWN;
                        i1i.l1Lll(37);
                        char[] cArr = HEX_DIGITS;
                        i1i.l1Lll(cArr[(iMo2798lIlii >> 4) & 15]);
                        i1i.l1Lll(cArr[iMo2798lIlii & 15]);
                    }
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }
}
