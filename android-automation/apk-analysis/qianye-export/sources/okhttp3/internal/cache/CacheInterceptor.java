package okhttp3.internal.cache;

import com.tencent.smtt.sdk.TbsListener;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import p047IL.IIi;
import p047IL.L1l;
import p047IL.LL1IL;
import p047IL.LlLLL;
import p047IL.llI;
import p066Ilil.I11li1;
import p066Ilil.I1I;
import p066Ilil.IL;
import p066Ilil.iIlLiL;
import p066Ilil.lIiI;
import p066Ilil.lL;
import p066Ilil.lLi1LL;

/* JADX INFO: loaded from: classes.dex */
public final class CacheInterceptor implements LL1IL {

    @Nullable
    public final InternalCache cache;

    public CacheInterceptor(@Nullable InternalCache internalCache) {
        this.cache = internalCache;
    }

    private IIi cacheWritingResponse(final CacheRequest cacheRequest, IIi iIi) throws IOException {
        iIlLiL iillilBody;
        if (cacheRequest == null || (iillilBody = cacheRequest.body()) == null) {
            return iIi;
        }
        final lLi1LL lli1llSource = iIi.m2846IiL().source();
        final IL ilI1I = lIiI.I1I(iillilBody);
        I11li1 i11li1 = new I11li1() { // from class: okhttp3.internal.cache.CacheInterceptor.1
            public boolean cacheRequestClosed;

            @Override // p066Ilil.I11li1, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                }
                lli1llSource.close();
            }

            @Override // p066Ilil.I11li1
            public long read(I1I i1i, long j) throws IOException {
                try {
                    long j2 = lli1llSource.read(i1i, j);
                    if (j2 != -1) {
                        i1i.m2771IIiI(ilI1I.IL1Iii(), i1i.m96I() - j2, j2);
                        ilI1I.mo2773ILl();
                        return j2;
                    }
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        ilI1I.close();
                    }
                    return -1L;
                } catch (IOException e) {
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        cacheRequest.abort();
                    }
                    throw e;
                }
            }

            @Override // p066Ilil.I11li1, p066Ilil.iIlLiL
            public lL timeout() {
                return lli1llSource.timeout();
            }
        };
        String strM2844IIiI = iIi.m2844IIiI("Content-Type");
        long jContentLength = iIi.m2846IiL().contentLength();
        IIi.IL1Iii iL1IiiM2853li11 = iIi.m2853li11();
        iL1IiiM2853li11.ILil(new RealResponseBody(strM2844IIiI, jContentLength, lIiI.m2826IL(i11li1)));
        return iL1IiiM2853li11.I1I();
    }

    private static LlLLL combine(LlLLL llLLL, LlLLL llLLL2) {
        LlLLL.IL1Iii iL1Iii = new LlLLL.IL1Iii();
        int iM2884IiL = llLLL.m2884IiL();
        for (int i = 0; i < iM2884IiL; i++) {
            String strIlil = llLLL.Ilil(i);
            String strM2885L11I = llLLL.m2885L11I(i);
            if ((!"Warning".equalsIgnoreCase(strIlil) || !strM2885L11I.startsWith(DiskLruCache.VERSION_1)) && (isContentSpecificHeader(strIlil) || !isEndToEnd(strIlil) || llLLL2.I1I(strIlil) == null)) {
                Internal.instance.addLenient(iL1Iii, strIlil, strM2885L11I);
            }
        }
        int iM2884IiL2 = llLLL2.m2884IiL();
        for (int i2 = 0; i2 < iM2884IiL2; i2++) {
            String strIlil2 = llLLL2.Ilil(i2);
            if (!isContentSpecificHeader(strIlil2) && isEndToEnd(strIlil2)) {
                Internal.instance.addLenient(iL1Iii, strIlil2, llLLL2.m2885L11I(i2));
            }
        }
        return iL1Iii.Ilil();
    }

    public static boolean isContentSpecificHeader(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }

    public static boolean isEndToEnd(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    private static IIi stripBody(IIi iIi) {
        if (iIi == null || iIi.m2846IiL() == null) {
            return iIi;
        }
        IIi.IL1Iii iL1IiiM2853li11 = iIi.m2853li11();
        iL1IiiM2853li11.ILil(null);
        return iL1IiiM2853li11.I1I();
    }

    @Override // p047IL.LL1IL
    public IIi intercept(LL1IL.IL1Iii iL1Iii) throws IOException {
        InternalCache internalCache = this.cache;
        IIi iIi = internalCache != null ? internalCache.get(iL1Iii.request()) : null;
        CacheStrategy cacheStrategy = new CacheStrategy.Factory(System.currentTimeMillis(), iL1Iii.request(), iIi).get();
        L1l l1l = cacheStrategy.networkRequest;
        IIi iIi2 = cacheStrategy.cacheResponse;
        InternalCache internalCache2 = this.cache;
        if (internalCache2 != null) {
            internalCache2.trackResponse(cacheStrategy);
        }
        if (iIi != null && iIi2 == null) {
            Util.closeQuietly(iIi.m2846IiL());
        }
        if (l1l == null && iIi2 == null) {
            IIi.IL1Iii iL1Iii2 = new IIi.IL1Iii();
            iL1Iii2.m2863llL1ii(iL1Iii.request());
            iL1Iii2.Lil(llI.HTTP_1_1);
            iL1Iii2.m2860iILLL1(TbsListener.ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_FAILED);
            iL1Iii2.m2858Ll1("Unsatisfiable Request (only-if-cached)");
            iL1Iii2.ILil(Util.EMPTY_RESPONSE);
            iL1Iii2.m2862lIlii(-1L);
            iL1Iii2.LlLI1(System.currentTimeMillis());
            return iL1Iii2.I1I();
        }
        if (l1l == null) {
            IIi.IL1Iii iL1IiiM2853li11 = iIi2.m2853li11();
            iL1IiiM2853li11.m2856IL(stripBody(iIi2));
            return iL1IiiM2853li11.I1I();
        }
        try {
            IIi iIiProceed = iL1Iii.proceed(l1l);
            if (iIiProceed == null && iIi != null) {
                Util.closeQuietly(iIi.m2846IiL());
            }
            if (iIi2 != null) {
                if (iIiProceed.m2847L11() == 304) {
                    IIi.IL1Iii iL1IiiM2853li12 = iIi2.m2853li11();
                    iL1IiiM2853li12.m2865il(combine(iIi2.LLL(), iIiProceed.LLL()));
                    iL1IiiM2853li12.m2862lIlii(iIiProceed.m106iI());
                    iL1IiiM2853li12.LlLI1(iIiProceed.m2851ili11());
                    iL1IiiM2853li12.m2856IL(stripBody(iIi2));
                    iL1IiiM2853li12.m2861lIiI(stripBody(iIiProceed));
                    IIi iIiI1I = iL1IiiM2853li12.I1I();
                    iIiProceed.m2846IiL().close();
                    this.cache.trackConditionalCacheHit();
                    this.cache.update(iIi2, iIiI1I);
                    return iIiI1I;
                }
                Util.closeQuietly(iIi2.m2846IiL());
            }
            IIi.IL1Iii iL1IiiM2853li13 = iIiProceed.m2853li11();
            iL1IiiM2853li13.m2856IL(stripBody(iIi2));
            iL1IiiM2853li13.m2861lIiI(stripBody(iIiProceed));
            IIi iIiI1I2 = iL1IiiM2853li13.I1I();
            if (this.cache != null) {
                if (HttpHeaders.hasBody(iIiI1I2) && CacheStrategy.isCacheable(iIiI1I2, l1l)) {
                    return cacheWritingResponse(this.cache.put(iIiI1I2), iIiI1I2);
                }
                if (HttpMethod.invalidatesCache(l1l.m2873iILLL1())) {
                    try {
                        this.cache.remove(l1l);
                    } catch (IOException unused) {
                    }
                }
            }
            return iIiI1I2;
        } catch (Throwable th) {
            if (iIi != null) {
                Util.closeQuietly(iIi.m2846IiL());
            }
            throw th;
        }
    }
}
