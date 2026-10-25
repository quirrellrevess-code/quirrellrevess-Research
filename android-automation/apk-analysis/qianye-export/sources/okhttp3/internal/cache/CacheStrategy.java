package okhttp3.internal.cache;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.Internal;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.http.HttpHeaders;
import p047IL.C0657il;
import p047IL.IIi;
import p047IL.L1l;
import p047IL.LlLLL;

/* JADX INFO: loaded from: classes.dex */
public final class CacheStrategy {

    @Nullable
    public final IIi cacheResponse;

    @Nullable
    public final L1l networkRequest;

    public static class Factory {
        private int ageSeconds;
        public final IIi cacheResponse;
        private String etag;
        private Date expires;
        private Date lastModified;
        private String lastModifiedString;
        public final long nowMillis;
        private long receivedResponseMillis;
        public final L1l request;
        private long sentRequestMillis;
        private Date servedDate;
        private String servedDateString;

        public Factory(long j, L1l l1l, IIi iIi) {
            this.ageSeconds = -1;
            this.nowMillis = j;
            this.request = l1l;
            this.cacheResponse = iIi;
            if (iIi != null) {
                this.sentRequestMillis = iIi.m106iI();
                this.receivedResponseMillis = iIi.m2851ili11();
                LlLLL llLLLLLL = iIi.LLL();
                int iM2884IiL = llLLLLLL.m2884IiL();
                for (int i = 0; i < iM2884IiL; i++) {
                    String strIlil = llLLLLLL.Ilil(i);
                    String strM2885L11I = llLLLLLL.m2885L11I(i);
                    if ("Date".equalsIgnoreCase(strIlil)) {
                        this.servedDate = HttpDate.parse(strM2885L11I);
                        this.servedDateString = strM2885L11I;
                    } else if ("Expires".equalsIgnoreCase(strIlil)) {
                        this.expires = HttpDate.parse(strM2885L11I);
                    } else if ("Last-Modified".equalsIgnoreCase(strIlil)) {
                        this.lastModified = HttpDate.parse(strM2885L11I);
                        this.lastModifiedString = strM2885L11I;
                    } else if ("ETag".equalsIgnoreCase(strIlil)) {
                        this.etag = strM2885L11I;
                    } else if ("Age".equalsIgnoreCase(strIlil)) {
                        this.ageSeconds = HttpHeaders.parseSeconds(strM2885L11I, -1);
                    }
                }
            }
        }

        private long cacheResponseAge() {
            Date date = this.servedDate;
            long jMax = date != null ? Math.max(0L, this.receivedResponseMillis - date.getTime()) : 0L;
            int i = this.ageSeconds;
            if (i != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i));
            }
            long j = this.receivedResponseMillis;
            return jMax + (j - this.sentRequestMillis) + (this.nowMillis - j);
        }

        private long computeFreshnessLifetime() {
            C0657il c0657ilM2854 = this.cacheResponse.m2854();
            if (c0657ilM2854.m2957IL() != -1) {
                return TimeUnit.SECONDS.toMillis(c0657ilM2854.m2957IL());
            }
            if (this.expires != null) {
                Date date = this.servedDate;
                long time = this.expires.getTime() - (date != null ? date.getTime() : this.receivedResponseMillis);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.lastModified == null || this.cacheResponse.m2848LIl().m2875il().m29201() != null) {
                return 0L;
            }
            Date date2 = this.servedDate;
            long time2 = (date2 != null ? date2.getTime() : this.sentRequestMillis) - this.lastModified.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        private CacheStrategy getCandidate() {
            if (this.cacheResponse == null) {
                return new CacheStrategy(this.request, null);
            }
            if (this.request.m2874lLi1LL() && this.cacheResponse.m2849LlIl() == null) {
                return new CacheStrategy(this.request, null);
            }
            if (!CacheStrategy.isCacheable(this.cacheResponse, this.request)) {
                return new CacheStrategy(this.request, null);
            }
            C0657il c0657ilILil = this.request.ILil();
            if (c0657ilILil.m2958IiL() || hasConditions(this.request)) {
                return new CacheStrategy(this.request, null);
            }
            C0657il c0657ilM2854 = this.cacheResponse.m2854();
            long jCacheResponseAge = cacheResponseAge();
            long jComputeFreshnessLifetime = computeFreshnessLifetime();
            if (c0657ilILil.m2957IL() != -1) {
                jComputeFreshnessLifetime = Math.min(jComputeFreshnessLifetime, TimeUnit.SECONDS.toMillis(c0657ilILil.m2957IL()));
            }
            long millis = 0;
            long millis2 = c0657ilILil.m2961lLi1LL() != -1 ? TimeUnit.SECONDS.toMillis(c0657ilILil.m2961lLi1LL()) : 0L;
            if (!c0657ilM2854.m2960iILLL1() && c0657ilILil.Ilil() != -1) {
                millis = TimeUnit.SECONDS.toMillis(c0657ilILil.Ilil());
            }
            if (!c0657ilM2854.m2958IiL()) {
                long j = millis2 + jCacheResponseAge;
                if (j < millis + jComputeFreshnessLifetime) {
                    IIi.IL1Iii iL1IiiM2853li11 = this.cacheResponse.m2853li11();
                    if (j >= jComputeFreshnessLifetime) {
                        iL1IiiM2853li11.IL1Iii("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jCacheResponseAge > 86400000 && isFreshnessLifetimeHeuristic()) {
                        iL1IiiM2853li11.IL1Iii("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new CacheStrategy(null, iL1IiiM2853li11.I1I());
                }
            }
            String str = this.etag;
            String str2 = "If-Modified-Since";
            if (str != null) {
                str2 = "If-None-Match";
            } else if (this.lastModified != null) {
                str = this.lastModifiedString;
            } else {
                if (this.servedDate == null) {
                    return new CacheStrategy(this.request, null);
                }
                str = this.servedDateString;
            }
            LlLLL.IL1Iii iL1IiiM2886lLi1LL = this.request.Ilil().m2886lLi1LL();
            Internal.instance.addLenient(iL1IiiM2886lLi1LL, str2, str);
            L1l.IL1Iii iL1IiiM2871IiL = this.request.m2871IiL();
            iL1IiiM2871IiL.m2876IL(iL1IiiM2886lLi1LL.Ilil());
            return new CacheStrategy(iL1IiiM2871IiL.ILil(), this.cacheResponse);
        }

        private static boolean hasConditions(L1l l1l) {
            return (l1l.I1I("If-Modified-Since") == null && l1l.I1I("If-None-Match") == null) ? false : true;
        }

        private boolean isFreshnessLifetimeHeuristic() {
            return this.cacheResponse.m2854().m2957IL() == -1 && this.expires == null;
        }

        public CacheStrategy get() {
            CacheStrategy candidate = getCandidate();
            return (candidate.networkRequest == null || !this.request.ILil().m2962il()) ? candidate : new CacheStrategy(null, null);
        }
    }

    public CacheStrategy(L1l l1l, IIi iIi) {
        this.networkRequest = l1l;
        this.cacheResponse = iIi;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.m2854().ILil() == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isCacheable(p047IL.IIi r3, p047IL.L1l r4) {
        /*
            int r0 = r3.m2847L11()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L5a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L5a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L5a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L5a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L5a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L5a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L5a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L5a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L5a
            switch(r0) {
                case 300: goto L5a;
                case 301: goto L5a;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L59
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.m2844IIiI(r0)
            if (r0 != 0) goto L5a
            I丨L.丨il r0 = r3.m2854()
            int r0 = r0.m2957IL()
            r1 = -1
            if (r0 != r1) goto L5a
            I丨L.丨il r0 = r3.m2854()
            boolean r0 = r0.I1I()
            if (r0 != 0) goto L5a
            I丨L.丨il r0 = r3.m2854()
            boolean r0 = r0.ILil()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            I丨L.丨il r3 = r3.m2854()
            boolean r3 = r3.m2959L11I()
            if (r3 != 0) goto L6f
            I丨L.丨il r3 = r4.ILil()
            boolean r3 = r3.m2959L11I()
            if (r3 != 0) goto L6f
            r2 = 1
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.CacheStrategy.isCacheable(I丨L.I丨Ii, I丨L.L丨1l):boolean");
    }
}
