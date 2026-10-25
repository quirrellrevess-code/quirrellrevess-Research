package p047IL;

import com.google.android.flexbox.BuildConfig;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.http.HttpHeaders;

/* JADX INFO: renamed from: I丨L.丨il, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: CacheControl.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0657il {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final int f4696I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final boolean f4697IL1Iii;
    public final boolean ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final boolean f4698ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final boolean f4699Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final int f2140IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final int f2141IiL;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final boolean f2142Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final int f2143L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final boolean f2144iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    @Nullable
    public String f2145lIiI;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final boolean f2146lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final boolean f2147il;

    /* JADX INFO: renamed from: I丨L.丨il$IL1Iii */
    /* JADX INFO: compiled from: CacheControl.java */
    public static final class IL1Iii {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public boolean f4701IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public boolean f4702ILil;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public boolean f2149IiL;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public boolean f2150iILLL1;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public boolean f2151lLi1LL;

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f4700I1I = -1;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int f2148IL = -1;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int f4703Ilil = -1;

        public IL1Iii I1I() {
            this.f4701IL1Iii = true;
            return this;
        }

        public C0657il IL1Iii() {
            return new C0657il(this);
        }

        public IL1Iii ILil(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds(i);
                this.f2148IL = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i);
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public IL1Iii m2963IL() {
            this.f2151lLi1LL = true;
            return this;
        }
    }

    static {
        IL1Iii iL1Iii = new IL1Iii();
        iL1Iii.I1I();
        iL1Iii.IL1Iii();
        IL1Iii iL1Iii2 = new IL1Iii();
        iL1Iii2.m2963IL();
        iL1Iii2.ILil(Integer.MAX_VALUE, TimeUnit.SECONDS);
        iL1Iii2.IL1Iii();
    }

    public C0657il(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, @Nullable String str) {
        this.f4697IL1Iii = z;
        this.f4698ILil = z2;
        this.f4696I1I = i;
        this.f2140IL = i2;
        this.f4699Ilil = z3;
        this.f2146lLi1LL = z4;
        this.f2144iILLL1 = z5;
        this.f2141IiL = i3;
        this.f2143L11I = i4;
        this.f2147il = z6;
        this.ILL = z7;
        this.f2142Ll1 = z8;
        this.f2145lIiI = str;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0041  */
    /* JADX WARN: Code duplicated, block: B:28:0x0099  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:37:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:40:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:43:0x00da  */
    /* JADX WARN: Code duplicated, block: B:44:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:49:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:50:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:52:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:53:0x0104  */
    /* JADX WARN: Code duplicated, block: B:55:0x010c  */
    /* JADX WARN: Code duplicated, block: B:56:0x0112  */
    /* JADX WARN: Code duplicated, block: B:58:0x011b  */
    /* JADX WARN: Code duplicated, block: B:59:0x011e  */
    /* JADX WARN: Code duplicated, block: B:61:0x0126  */
    /* JADX WARN: Code duplicated, block: B:62:0x0129  */
    /* JADX WARN: Code duplicated, block: B:64:0x0131  */
    /* JADX WARN: Code duplicated, block: B:87:0x0133 A[SYNTHETIC] */
    public static C0657il ILL(LlLLL llLLL) {
        int i;
        int iSkipUntil;
        String strTrim;
        int iSkipUntil2;
        String strTrim2;
        int iM2884IiL = llLLL.m2884IiL();
        boolean z = true;
        String str = null;
        boolean z2 = false;
        boolean z3 = false;
        int seconds = -1;
        int seconds2 = -1;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int seconds3 = -1;
        int seconds4 = -1;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        for (int i2 = 0; i2 < iM2884IiL; i2++) {
            String strIlil = llLLL.Ilil(i2);
            String strM2885L11I = llLLL.m2885L11I(i2);
            if (strIlil.equalsIgnoreCase("Cache-Control")) {
                if (str == null) {
                    str = strM2885L11I;
                }
                for (i = 0; i < strM2885L11I.length(); i = iSkipUntil2) {
                    iSkipUntil = HttpHeaders.skipUntil(strM2885L11I, i, "=,;");
                    strTrim = strM2885L11I.substring(i, iSkipUntil).trim();
                    if (iSkipUntil != strM2885L11I.length() || strM2885L11I.charAt(iSkipUntil) == ',' || strM2885L11I.charAt(iSkipUntil) == ';') {
                        iSkipUntil2 = iSkipUntil + 1;
                        strTrim2 = null;
                    } else {
                        int iSkipWhitespace = HttpHeaders.skipWhitespace(strM2885L11I, iSkipUntil + 1);
                        if (iSkipWhitespace >= strM2885L11I.length() || strM2885L11I.charAt(iSkipWhitespace) != '\"') {
                            iSkipUntil2 = HttpHeaders.skipUntil(strM2885L11I, iSkipWhitespace, ",;");
                            strTrim2 = strM2885L11I.substring(iSkipWhitespace, iSkipUntil2).trim();
                        } else {
                            int i3 = iSkipWhitespace + 1;
                            int iSkipUntil3 = HttpHeaders.skipUntil(strM2885L11I, i3, "\"");
                            strTrim2 = strM2885L11I.substring(i3, iSkipUntil3);
                            iSkipUntil2 = iSkipUntil3 + 1;
                        }
                    }
                    if ("no-cache".equalsIgnoreCase(strTrim)) {
                        z2 = true;
                    } else if ("no-store".equalsIgnoreCase(strTrim)) {
                        z3 = true;
                    } else if ("max-age".equalsIgnoreCase(strTrim)) {
                        seconds = HttpHeaders.parseSeconds(strTrim2, -1);
                    } else if ("s-maxage".equalsIgnoreCase(strTrim)) {
                        seconds2 = HttpHeaders.parseSeconds(strTrim2, -1);
                    } else if ("private".equalsIgnoreCase(strTrim)) {
                        z4 = true;
                    } else if ("public".equalsIgnoreCase(strTrim)) {
                        z5 = true;
                    } else if ("must-revalidate".equalsIgnoreCase(strTrim)) {
                        z6 = true;
                    } else if ("max-stale".equalsIgnoreCase(strTrim)) {
                        seconds3 = HttpHeaders.parseSeconds(strTrim2, Integer.MAX_VALUE);
                    } else if ("min-fresh".equalsIgnoreCase(strTrim)) {
                        seconds4 = HttpHeaders.parseSeconds(strTrim2, -1);
                    } else if ("only-if-cached".equalsIgnoreCase(strTrim)) {
                        z7 = true;
                    } else if ("no-transform".equalsIgnoreCase(strTrim)) {
                        z8 = true;
                    } else if ("immutable".equalsIgnoreCase(strTrim)) {
                        z9 = true;
                    }
                }
            } else {
                if (strIlil.equalsIgnoreCase("Pragma")) {
                }
            }
            z = false;
            while (i < strM2885L11I.length()) {
                iSkipUntil = HttpHeaders.skipUntil(strM2885L11I, i, "=,;");
                strTrim = strM2885L11I.substring(i, iSkipUntil).trim();
                if (iSkipUntil != strM2885L11I.length()) {
                    iSkipUntil2 = iSkipUntil + 1;
                    strTrim2 = null;
                } else {
                    iSkipUntil2 = iSkipUntil + 1;
                    strTrim2 = null;
                }
                if ("no-cache".equalsIgnoreCase(strTrim)) {
                    z2 = true;
                } else if ("no-store".equalsIgnoreCase(strTrim)) {
                    z3 = true;
                } else if ("max-age".equalsIgnoreCase(strTrim)) {
                    seconds = HttpHeaders.parseSeconds(strTrim2, -1);
                } else if ("s-maxage".equalsIgnoreCase(strTrim)) {
                    seconds2 = HttpHeaders.parseSeconds(strTrim2, -1);
                } else if ("private".equalsIgnoreCase(strTrim)) {
                    z4 = true;
                } else if ("public".equalsIgnoreCase(strTrim)) {
                    z5 = true;
                } else if ("must-revalidate".equalsIgnoreCase(strTrim)) {
                    z6 = true;
                } else if ("max-stale".equalsIgnoreCase(strTrim)) {
                    seconds3 = HttpHeaders.parseSeconds(strTrim2, Integer.MAX_VALUE);
                } else if ("min-fresh".equalsIgnoreCase(strTrim)) {
                    seconds4 = HttpHeaders.parseSeconds(strTrim2, -1);
                } else if ("only-if-cached".equalsIgnoreCase(strTrim)) {
                    z7 = true;
                } else if ("no-transform".equalsIgnoreCase(strTrim)) {
                    z8 = true;
                } else if ("immutable".equalsIgnoreCase(strTrim)) {
                    z9 = true;
                }
            }
        }
        return new C0657il(z2, z3, seconds, seconds2, z4, z5, z6, seconds3, seconds4, z7, z8, z9, !z ? null : str);
    }

    public boolean I1I() {
        return this.f2146lLi1LL;
    }

    public final String IL1Iii() {
        StringBuilder sb = new StringBuilder();
        if (this.f4697IL1Iii) {
            sb.append("no-cache, ");
        }
        if (this.f4698ILil) {
            sb.append("no-store, ");
        }
        if (this.f4696I1I != -1) {
            sb.append("max-age=");
            sb.append(this.f4696I1I);
            sb.append(", ");
        }
        if (this.f2140IL != -1) {
            sb.append("s-maxage=");
            sb.append(this.f2140IL);
            sb.append(", ");
        }
        if (this.f4699Ilil) {
            sb.append("private, ");
        }
        if (this.f2146lLi1LL) {
            sb.append("public, ");
        }
        if (this.f2144iILLL1) {
            sb.append("must-revalidate, ");
        }
        if (this.f2141IiL != -1) {
            sb.append("max-stale=");
            sb.append(this.f2141IiL);
            sb.append(", ");
        }
        if (this.f2143L11I != -1) {
            sb.append("min-fresh=");
            sb.append(this.f2143L11I);
            sb.append(", ");
        }
        if (this.f2147il) {
            sb.append("only-if-cached, ");
        }
        if (this.ILL) {
            sb.append("no-transform, ");
        }
        if (this.f2142Ll1) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return BuildConfig.FLAVOR;
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public boolean ILil() {
        return this.f4699Ilil;
    }

    public int Ilil() {
        return this.f2141IiL;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int m2957IL() {
        return this.f4696I1I;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public boolean m2958IiL() {
        return this.f4697IL1Iii;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public boolean m2959L11I() {
        return this.f4698ILil;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public boolean m2960iILLL1() {
        return this.f2144iILLL1;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int m2961lLi1LL() {
        return this.f2143L11I;
    }

    public String toString() {
        String str = this.f2145lIiI;
        if (str != null) {
            return str;
        }
        String strIL1Iii = IL1Iii();
        this.f2145lIiI = strIL1Iii;
        return strIL1Iii;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public boolean m2962il() {
        return this.f2147il;
    }

    public C0657il(IL1Iii iL1Iii) {
        this.f4697IL1Iii = iL1Iii.f4701IL1Iii;
        this.f4698ILil = iL1Iii.f4702ILil;
        this.f4696I1I = iL1Iii.f4700I1I;
        this.f2140IL = -1;
        this.f4699Ilil = false;
        this.f2146lLi1LL = false;
        this.f2144iILLL1 = false;
        this.f2141IiL = iL1Iii.f2148IL;
        this.f2143L11I = iL1Iii.f4703Ilil;
        this.f2147il = iL1Iii.f2151lLi1LL;
        this.ILL = iL1Iii.f2150iILLL1;
        this.f2142Ll1 = iL1Iii.f2149IiL;
    }
}
