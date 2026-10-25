package retrofit2;

import java.util.Objects;
import javax.annotation.Nullable;
import p047IL.IIi;
import p047IL.L1l;
import p047IL.LIll;
import p047IL.LlLLL;
import p047IL.llI;

/* JADX INFO: loaded from: classes.dex */
public final class Response<T> {

    @Nullable
    private final T body;

    @Nullable
    private final LIll errorBody;
    private final IIi rawResponse;

    private Response(IIi iIi, @Nullable T t, @Nullable LIll lIll) {
        this.rawResponse = iIi;
        this.body = t;
        this.errorBody = lIll;
    }

    public static <T> Response<T> error(int i, LIll lIll) {
        Objects.requireNonNull(lIll, "body == null");
        if (i < 400) {
            throw new IllegalArgumentException("code < 400: " + i);
        }
        IIi.IL1Iii iL1Iii = new IIi.IL1Iii();
        iL1Iii.ILil(new OkHttpCall.NoContentResponseBody(lIll.contentType(), lIll.contentLength()));
        iL1Iii.m2860iILLL1(i);
        iL1Iii.m2858Ll1("Response.error()");
        iL1Iii.Lil(llI.HTTP_1_1);
        L1l.IL1Iii iL1Iii2 = new L1l.IL1Iii();
        iL1Iii2.m2878L11I("http://localhost/");
        iL1Iii.m2863llL1ii(iL1Iii2.ILil());
        return error(lIll, iL1Iii.I1I());
    }

    public static <T> Response<T> success(@Nullable T t) {
        IIi.IL1Iii iL1Iii = new IIi.IL1Iii();
        iL1Iii.m2860iILLL1(200);
        iL1Iii.m2858Ll1("OK");
        iL1Iii.Lil(llI.HTTP_1_1);
        L1l.IL1Iii iL1Iii2 = new L1l.IL1Iii();
        iL1Iii2.m2878L11I("http://localhost/");
        iL1Iii.m2863llL1ii(iL1Iii2.ILil());
        return success(t, iL1Iii.I1I());
    }

    @Nullable
    public T body() {
        return this.body;
    }

    public int code() {
        return this.rawResponse.m2847L11();
    }

    @Nullable
    public LIll errorBody() {
        return this.errorBody;
    }

    public LlLLL headers() {
        return this.rawResponse.LLL();
    }

    public boolean isSuccessful() {
        return this.rawResponse.m2850iI1iI();
    }

    public String message() {
        return this.rawResponse.m2843I1L11L();
    }

    public IIi raw() {
        return this.rawResponse;
    }

    public String toString() {
        return this.rawResponse.toString();
    }

    public static <T> Response<T> success(int i, @Nullable T t) {
        if (i >= 200 && i < 300) {
            IIi.IL1Iii iL1Iii = new IIi.IL1Iii();
            iL1Iii.m2860iILLL1(i);
            iL1Iii.m2858Ll1("Response.success()");
            iL1Iii.Lil(llI.HTTP_1_1);
            L1l.IL1Iii iL1Iii2 = new L1l.IL1Iii();
            iL1Iii2.m2878L11I("http://localhost/");
            iL1Iii.m2863llL1ii(iL1Iii2.ILil());
            return success(t, iL1Iii.I1I());
        }
        throw new IllegalArgumentException("code < 200 or >= 300: " + i);
    }

    public static <T> Response<T> error(LIll lIll, IIi iIi) {
        Objects.requireNonNull(lIll, "body == null");
        Objects.requireNonNull(iIi, "rawResponse == null");
        if (!iIi.m2850iI1iI()) {
            return new Response<>(iIi, null, lIll);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static <T> Response<T> success(@Nullable T t, LlLLL llLLL) {
        Objects.requireNonNull(llLLL, "headers == null");
        IIi.IL1Iii iL1Iii = new IIi.IL1Iii();
        iL1Iii.m2860iILLL1(200);
        iL1Iii.m2858Ll1("OK");
        iL1Iii.Lil(llI.HTTP_1_1);
        iL1Iii.m2865il(llLLL);
        L1l.IL1Iii iL1Iii2 = new L1l.IL1Iii();
        iL1Iii2.m2878L11I("http://localhost/");
        iL1Iii.m2863llL1ii(iL1Iii2.ILil());
        return success(t, iL1Iii.I1I());
    }

    public static <T> Response<T> success(@Nullable T t, IIi iIi) {
        Objects.requireNonNull(iIi, "rawResponse == null");
        if (iIi.m2850iI1iI()) {
            return new Response<>(iIi, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }
}
