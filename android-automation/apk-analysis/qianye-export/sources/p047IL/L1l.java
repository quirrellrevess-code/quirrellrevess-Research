package p047IL;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

/* JADX INFO: renamed from: I丨L.L丨1l, reason: invalid class name */
/* JADX INFO: compiled from: Request.java */
/* JADX INFO: loaded from: classes.dex */
public final class L1l {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final LlLLL f4636I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final C0656lIII f4637IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final String f4638ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final Map<Class<?>, Object> f4639Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    @Nullable
    public final iILLl f2103IL;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    @Nullable
    public volatile C0657il f2104lLi1LL;

    public L1l(IL1Iii iL1Iii) {
        this.f4637IL1Iii = iL1Iii.f4641IL1Iii;
        this.f4638ILil = iL1Iii.f4642ILil;
        this.f4636I1I = iL1Iii.f4640I1I.Ilil();
        this.f2103IL = iL1Iii.f2105IL;
        this.f4639Ilil = Util.immutableMap(iL1Iii.f4643Ilil);
    }

    @Nullable
    public String I1I(String str) {
        return this.f4636I1I.I1I(str);
    }

    @Nullable
    public iILLl IL1Iii() {
        return this.f2103IL;
    }

    public C0657il ILil() {
        C0657il c0657il = this.f2104lLi1LL;
        if (c0657il != null) {
            return c0657il;
        }
        C0657il c0657ilILL = C0657il.ILL(this.f4636I1I);
        this.f2104lLi1LL = c0657ilILL;
        return c0657ilILL;
    }

    public LlLLL Ilil() {
        return this.f4636I1I;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public List<String> m2870IL(String str) {
        return this.f4636I1I.m2887il(str);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public IL1Iii m2871IiL() {
        return new IL1Iii(this);
    }

    @Nullable
    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public <T> T m2872L11I(Class<? extends T> cls) {
        return cls.cast(this.f4639Ilil.get(cls));
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public String m2873iILLL1() {
        return this.f4638ILil;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean m2874lLi1LL() {
        return this.f4637IL1Iii.m2906ILl();
    }

    public String toString() {
        return "Request{method=" + this.f4638ILil + ", url=" + this.f4637IL1Iii + ", tags=" + this.f4639Ilil + '}';
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public C0656lIII m2875il() {
        return this.f4637IL1Iii;
    }

    /* JADX INFO: renamed from: I丨L.L丨1l$IL1Iii */
    /* JADX INFO: compiled from: Request.java */
    public static class IL1Iii {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public LlLLL.IL1Iii f4640I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        @Nullable
        public C0656lIII f4641IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public String f4642ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public Map<Class<?>, Object> f4643Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        @Nullable
        public iILLl f2105IL;

        public IL1Iii() {
            this.f4643Ilil = Collections.emptyMap();
            this.f4642ILil = "GET";
            this.f4640I1I = new LlLLL.IL1Iii();
        }

        public IL1Iii I1I(String str, String str2) {
            this.f4640I1I.m2889iILLL1(str, str2);
            return this;
        }

        public IL1Iii IL1Iii(String str, String str2) {
            this.f4640I1I.IL1Iii(str, str2);
            return this;
        }

        public L1l ILil() {
            if (this.f4641IL1Iii != null) {
                return new L1l(this);
            }
            throw new IllegalStateException("url == null");
        }

        public IL1Iii Ilil(String str, @Nullable iILLl iilll) {
            Objects.requireNonNull(str, "method == null");
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (iilll != null && !HttpMethod.permitsRequestBody(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (iilll != null || !HttpMethod.requiresRequestBody(str)) {
                this.f4642ILil = str;
                this.f2105IL = iilll;
                return this;
            }
            throw new IllegalArgumentException("method " + str + " must have a request body.");
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public IL1Iii m2876IL(LlLLL llLLL) {
            this.f4640I1I = llLLL.m2886lLi1LL();
            return this;
        }

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public <T> IL1Iii m2877IiL(Class<? super T> cls, @Nullable T t) {
            Objects.requireNonNull(cls, "type == null");
            if (t == null) {
                this.f4643Ilil.remove(cls);
            } else {
                if (this.f4643Ilil.isEmpty()) {
                    this.f4643Ilil = new LinkedHashMap();
                }
                this.f4643Ilil.put(cls, cls.cast(t));
            }
            return this;
        }

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public IL1Iii m2878L11I(String str) {
            Objects.requireNonNull(str, "url == null");
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            m2881il(C0656lIII.m2904Ll1(str));
            return this;
        }

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public IL1Iii m2879iILLL1(String str) {
            this.f4640I1I.m2890lLi1LL(str);
            return this;
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public IL1Iii m2880lLi1LL(iILLl iilll) {
            Ilil("POST", iilll);
            return this;
        }

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public IL1Iii m2881il(C0656lIII c0656lIII) {
            Objects.requireNonNull(c0656lIII, "url == null");
            this.f4641IL1Iii = c0656lIII;
            return this;
        }

        public IL1Iii(L1l l1l) {
            Map<Class<?>, Object> linkedHashMap;
            this.f4643Ilil = Collections.emptyMap();
            this.f4641IL1Iii = l1l.f4637IL1Iii;
            this.f4642ILil = l1l.f4638ILil;
            this.f2105IL = l1l.f2103IL;
            if (l1l.f4639Ilil.isEmpty()) {
                linkedHashMap = Collections.emptyMap();
            } else {
                linkedHashMap = new LinkedHashMap<>(l1l.f4639Ilil);
            }
            this.f4643Ilil = linkedHashMap;
            this.f4640I1I = l1l.f4636I1I.m2886lLi1LL();
        }
    }
}
