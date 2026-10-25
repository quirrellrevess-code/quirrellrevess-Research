package p047IL;

import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.StatementImpl;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import p066Ilil.I1I;

/* JADX INFO: renamed from: I丨L.lI丨II, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: HttpUrl.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0656lIII {

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static final char[] f2118il = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final String f4667I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final String f4668IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final String f4669ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final int f4670Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final String f2119IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    @Nullable
    public final String f2120IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final String f2121L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    @Nullable
    public final List<String> f2122iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final List<String> f2123lLi1LL;

    /* JADX INFO: renamed from: I丨L.lI丨II$IL1Iii */
    /* JADX INFO: compiled from: HttpUrl.java */
    public static final class IL1Iii {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        @Nullable
        public String f4672IL1Iii;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        @Nullable
        public String f2124IL;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        @Nullable
        public String f2125IiL;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        @Nullable
        public List<String> f2126iILLL1;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public final List<String> f2127lLi1LL;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public String f4673ILil = BuildConfig.FLAVOR;

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public String f4671I1I = BuildConfig.FLAVOR;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int f4674Ilil = -1;

        public IL1Iii() {
            ArrayList arrayList = new ArrayList();
            this.f2127lLi1LL = arrayList;
            arrayList.add(BuildConfig.FLAVOR);
        }

        public static int I11li1(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        public static int ILL(String str, int i, int i2) {
            try {
                int i3 = Integer.parseInt(C0656lIII.IL1Iii(str, i, i2, BuildConfig.FLAVOR, false, false, false, true, null));
                if (i3 <= 0 || i3 > 65535) {
                    return -1;
                }
                return i3;
            } catch (NumberFormatException unused) {
            }
        }

        @Nullable
        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public static String m2921IL(String str, int i, int i2) {
            return Util.canonicalizeHost(C0656lIII.iIlLiL(str, i, i2, false));
        }

        public static int Lil(String str, int i, int i2) {
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt == ':') {
                    return i;
                }
                if (cCharAt == '[') {
                    do {
                        i++;
                        if (i >= i2) {
                            break;
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        public static int iIlLiL(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i);
            if ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i);
                    if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            if (cCharAt2 < '0' || cCharAt2 > '9') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        public C0656lIII I1I() {
            if (this.f4672IL1Iii == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.f2124IL != null) {
                return new C0656lIII(this);
            }
            throw new IllegalStateException("host == null");
        }

        public IL1Iii IL1Iii(String str, @Nullable String str2) {
            Objects.requireNonNull(str, "encodedName == null");
            if (this.f2126iILLL1 == null) {
                this.f2126iILLL1 = new ArrayList();
            }
            this.f2126iILLL1.add(C0656lIII.ILil(str, " \"'<>#&=", true, false, true, true));
            this.f2126iILLL1.add(str2 != null ? C0656lIII.ILil(str2, " \"'<>#&=", true, false, true, true) : null);
            return this;
        }

        public IL1Iii ILil(String str, @Nullable String str2) {
            Objects.requireNonNull(str, "name == null");
            if (this.f2126iILLL1 == null) {
                this.f2126iILLL1 = new ArrayList();
            }
            this.f2126iILLL1.add(C0656lIII.ILil(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
            this.f2126iILLL1.add(str2 != null ? C0656lIII.ILil(str2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true) : null);
            return this;
        }

        /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
        public IL1Iii m2922ILl(int i) {
            if (i > 0 && i <= 65535) {
                this.f4674Ilil = i;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i);
        }

        public int Ilil() {
            int i = this.f4674Ilil;
            return i != -1 ? i : C0656lIII.Ilil(this.f4672IL1Iii);
        }

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public final boolean m2923IiL(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        public final void LlLI1(String str, int i, int i2, boolean z, boolean z2) {
            String strIL1Iii = C0656lIII.IL1Iii(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (m2923IiL(strIL1Iii)) {
                return;
            }
            if (m2925L11I(strIL1Iii)) {
                m2927lIiI();
                return;
            }
            List<String> list = this.f2127lLi1LL;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.f2127lLi1LL;
                list2.set(list2.size() - 1, strIL1Iii);
            } else {
                this.f2127lLi1LL.add(strIL1Iii);
            }
            if (z) {
                this.f2127lLi1LL.add(BuildConfig.FLAVOR);
            }
        }

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public IL1Iii m2924Ll1(String str) {
            Objects.requireNonNull(str, "password == null");
            this.f4671I1I = C0656lIII.ILil(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public final boolean m2925L11I(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        public IL1Iii iIi1(String str) {
            Objects.requireNonNull(str, "scheme == null");
            if (str.equalsIgnoreCase("http")) {
                this.f4672IL1Iii = "http";
            } else {
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                this.f4672IL1Iii = "https";
            }
            return this;
        }

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public IL1Iii m2926iILLL1(String str) {
            Objects.requireNonNull(str, "host == null");
            String strM2921IL = m2921IL(str, 0, str.length());
            if (strM2921IL != null) {
                this.f2124IL = strM2921IL;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public final void m2927lIiI() {
            List<String> list = this.f2127lLi1LL;
            if (!list.remove(list.size() - 1).isEmpty() || this.f2127lLi1LL.isEmpty()) {
                this.f2127lLi1LL.add(BuildConfig.FLAVOR);
            } else {
                List<String> list2 = this.f2127lLi1LL;
                list2.set(list2.size() - 1, BuildConfig.FLAVOR);
            }
        }

        /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
        public final void m2928lIlii(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.f2127lLi1LL.clear();
                this.f2127lLi1LL.add(BuildConfig.FLAVOR);
                i++;
            } else {
                List<String> list = this.f2127lLi1LL;
                list.set(list.size() - 1, BuildConfig.FLAVOR);
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = Util.delimiterOffset(str, i3, i2, "/\\");
                boolean z = i < i2;
                LlLI1(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
        public IL1Iii m2929llL1ii() {
            int size = this.f2127lLi1LL.size();
            for (int i = 0; i < size; i++) {
                this.f2127lLi1LL.set(i, C0656lIII.ILil(this.f2127lLi1LL.get(i), "[]", true, true, false, true));
            }
            List<String> list = this.f2126iILLL1;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.f2126iILLL1.get(i2);
                    if (str != null) {
                        this.f2126iILLL1.set(i2, C0656lIII.ILil(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f2125IiL;
            if (str2 != null) {
                this.f2125IiL = C0656lIII.ILil(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public IL1Iii m2930lLi1LL(@Nullable String str) {
            this.f2126iILLL1 = str != null ? C0656lIII.m2905LlLLL(C0656lIII.ILil(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.f4672IL1Iii;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (!this.f4673ILil.isEmpty() || !this.f4671I1I.isEmpty()) {
                sb.append(this.f4673ILil);
                if (!this.f4671I1I.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f4671I1I);
                }
                sb.append('@');
            }
            String str2 = this.f2124IL;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.f2124IL);
                    sb.append(']');
                } else {
                    sb.append(this.f2124IL);
                }
            }
            if (this.f4674Ilil != -1 || this.f4672IL1Iii != null) {
                int iIlil = Ilil();
                String str3 = this.f4672IL1Iii;
                if (str3 == null || iIlil != C0656lIII.Ilil(str3)) {
                    sb.append(':');
                    sb.append(iIlil);
                }
            }
            C0656lIII.iIi1(sb, this.f2127lLi1LL);
            if (this.f2126iILLL1 != null) {
                sb.append('?');
                C0656lIII.Lil(sb, this.f2126iILLL1);
            }
            if (this.f2125IiL != null) {
                sb.append('#');
                sb.append(this.f2125IiL);
            }
            return sb.toString();
        }

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public IL1Iii m2931il(@Nullable C0656lIII c0656lIII, String str) {
            int iDelimiterOffset;
            int i;
            int iSkipLeadingAsciiWhitespace = Util.skipLeadingAsciiWhitespace(str, 0, str.length());
            int iSkipTrailingAsciiWhitespace = Util.skipTrailingAsciiWhitespace(str, iSkipLeadingAsciiWhitespace, str.length());
            int iIIlLiL = iIlLiL(str, iSkipLeadingAsciiWhitespace, iSkipTrailingAsciiWhitespace);
            if (iIIlLiL != -1) {
                if (str.regionMatches(true, iSkipLeadingAsciiWhitespace, "https:", 0, 6)) {
                    this.f4672IL1Iii = "https";
                    iSkipLeadingAsciiWhitespace += 6;
                } else {
                    if (!str.regionMatches(true, iSkipLeadingAsciiWhitespace, "http:", 0, 5)) {
                        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, iIIlLiL) + "'");
                    }
                    this.f4672IL1Iii = "http";
                    iSkipLeadingAsciiWhitespace += 5;
                }
            } else {
                if (c0656lIII == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.f4672IL1Iii = c0656lIII.f4668IL1Iii;
            }
            int iI11li1 = I11li1(str, iSkipLeadingAsciiWhitespace, iSkipTrailingAsciiWhitespace);
            char c = '?';
            char c2 = '#';
            if (iI11li1 >= 2 || c0656lIII == null || !c0656lIII.f4668IL1Iii.equals(this.f4672IL1Iii)) {
                int i2 = iSkipLeadingAsciiWhitespace + iI11li1;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    iDelimiterOffset = Util.delimiterOffset(str, i2, iSkipTrailingAsciiWhitespace, "@/\\?#");
                    byte bCharAt = iDelimiterOffset != iSkipTrailingAsciiWhitespace ? str.charAt(iDelimiterOffset) : (byte) -1;
                    if (bCharAt == -1 || bCharAt == c2 || bCharAt == 47 || bCharAt == 92 || bCharAt == c) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (z) {
                            i = iDelimiterOffset;
                            this.f4671I1I += "%40" + C0656lIII.IL1Iii(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        } else {
                            int iDelimiterOffset2 = Util.delimiterOffset(str, i2, iDelimiterOffset, ':');
                            i = iDelimiterOffset;
                            String strIL1Iii = C0656lIII.IL1Iii(str, i2, iDelimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                strIL1Iii = this.f4673ILil + "%40" + strIL1Iii;
                            }
                            this.f4673ILil = strIL1Iii;
                            if (iDelimiterOffset2 != i) {
                                this.f4671I1I = C0656lIII.IL1Iii(str, iDelimiterOffset2 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        }
                        i2 = i + 1;
                    }
                    c = '?';
                    c2 = '#';
                }
                int iLil = Lil(str, i2, iDelimiterOffset);
                int i3 = iLil + 1;
                if (i3 < iDelimiterOffset) {
                    this.f2124IL = m2921IL(str, i2, iLil);
                    int iILL = ILL(str, i3, iDelimiterOffset);
                    this.f4674Ilil = iILL;
                    if (iILL == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i3, iDelimiterOffset) + '\"');
                    }
                } else {
                    this.f2124IL = m2921IL(str, i2, iLil);
                    this.f4674Ilil = C0656lIII.Ilil(this.f4672IL1Iii);
                }
                if (this.f2124IL == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i2, iLil) + '\"');
                }
                iSkipLeadingAsciiWhitespace = iDelimiterOffset;
            } else {
                this.f4673ILil = c0656lIII.ILL();
                this.f4671I1I = c0656lIII.m2910iILLL1();
                this.f2124IL = c0656lIII.f2119IL;
                this.f4674Ilil = c0656lIII.f4670Ilil;
                this.f2127lLi1LL.clear();
                this.f2127lLi1LL.addAll(c0656lIII.m2909L11I());
                if (iSkipLeadingAsciiWhitespace == iSkipTrailingAsciiWhitespace || str.charAt(iSkipLeadingAsciiWhitespace) == '#') {
                    m2930lLi1LL(c0656lIII.m2916il());
                }
            }
            int iDelimiterOffset3 = Util.delimiterOffset(str, iSkipLeadingAsciiWhitespace, iSkipTrailingAsciiWhitespace, "?#");
            m2928lIlii(str, iSkipLeadingAsciiWhitespace, iDelimiterOffset3);
            if (iDelimiterOffset3 < iSkipTrailingAsciiWhitespace && str.charAt(iDelimiterOffset3) == '?') {
                int iDelimiterOffset4 = Util.delimiterOffset(str, iDelimiterOffset3, iSkipTrailingAsciiWhitespace, '#');
                this.f2126iILLL1 = C0656lIII.m2905LlLLL(C0656lIII.IL1Iii(str, iDelimiterOffset3 + 1, iDelimiterOffset4, " \"'<>#", true, false, true, true, null));
                iDelimiterOffset3 = iDelimiterOffset4;
            }
            if (iDelimiterOffset3 < iSkipTrailingAsciiWhitespace && str.charAt(iDelimiterOffset3) == '#') {
                this.f2125IiL = C0656lIII.IL1Iii(str, 1 + iDelimiterOffset3, iSkipTrailingAsciiWhitespace, BuildConfig.FLAVOR, true, false, false, false, null);
            }
            return this;
        }

        /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
        public IL1Iii m2932lL(String str) {
            Objects.requireNonNull(str, "username == null");
            this.f4673ILil = C0656lIII.ILil(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }
    }

    public C0656lIII(IL1Iii iL1Iii) {
        this.f4668IL1Iii = iL1Iii.f4672IL1Iii;
        this.f4669ILil = I11li1(iL1Iii.f4673ILil, false);
        this.f4667I1I = I11li1(iL1Iii.f4671I1I, false);
        this.f2119IL = iL1Iii.f2124IL;
        this.f4670Ilil = iL1Iii.Ilil();
        this.f2123lLi1LL = m2917lL(iL1Iii.f2127lLi1LL, false);
        List<String> list = iL1Iii.f2126iILLL1;
        this.f2122iILLL1 = list != null ? m2917lL(list, true) : null;
        String str = iL1Iii.f2125IiL;
        this.f2120IiL = str != null ? I11li1(str, false) : null;
        this.f2121L11I = iL1Iii.toString();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0039  */
    public static void I11L(I1I i1i, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (iCodePointAt == 37 && (i3 = i + 2) < i2) {
                int iDecodeHexDigit = Util.decodeHexDigit(str.charAt(i + 1));
                int iDecodeHexDigit2 = Util.decodeHexDigit(str.charAt(i3));
                if (iDecodeHexDigit == -1 || iDecodeHexDigit2 == -1) {
                    i1i.m2793i1I1I1l(iCodePointAt);
                } else {
                    i1i.l1Lll((iDecodeHexDigit << 4) + iDecodeHexDigit2);
                    i = i3;
                }
            } else if (iCodePointAt == 43 && z) {
                i1i.l1Lll(32);
            } else {
                i1i.m2793i1I1I1l(iCodePointAt);
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    public static String I11li1(String str, boolean z) {
        return iIlLiL(str, 0, str.length(), z);
    }

    public static String I1I(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, @Nullable Charset charset) {
        return IL1Iii(str, 0, str.length(), str2, z, z2, z3, z4, charset);
    }

    public static String IL1Iii(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, @Nullable Charset charset) {
        int iCharCount = i;
        while (iCharCount < i2) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt != 127 && (iCodePointAt < 128 || !z4)) {
                if (str2.indexOf(iCodePointAt) == -1 && ((iCodePointAt != 37 || (z && (!z2 || llliI(str, iCharCount, i2)))) && (iCodePointAt != 43 || !z3))) {
                    iCharCount += Character.charCount(iCodePointAt);
                }
            }
            I1I i1i = new I1I();
            i1i.m97LL(str, i, iCharCount);
            m2903IL(i1i, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
            return i1i.mo2785LlLLL();
        }
        return str.substring(i, i2);
    }

    public static String ILil(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return IL1Iii(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }

    public static int Ilil(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static void m2903IL(I1I i1i, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, @Nullable Charset charset) {
        I1I i1i2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z3) {
                    i1i.Liil1L1l(z ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z4) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z || (z2 && !llliI(str, i, i2)))))) {
                    if (i1i2 == null) {
                        i1i2 = new I1I();
                    }
                    if (charset == null || charset.equals(StandardCharsets.UTF_8)) {
                        i1i2.m2793i1I1I1l(iCodePointAt);
                    } else {
                        i1i2.LI11(str, i, Character.charCount(iCodePointAt) + i, charset);
                    }
                    while (!i1i2.ILL()) {
                        int iMo2798lIlii = i1i2.mo2798lIlii() & StatementImpl.USES_VARIABLES_UNKNOWN;
                        i1i.l1Lll(37);
                        char[] cArr = f2118il;
                        i1i.l1Lll(cArr[(iMo2798lIlii >> 4) & 15]);
                        i1i.l1Lll(cArr[iMo2798lIlii & 15]);
                    }
                } else {
                    i1i.m2793i1I1I1l(iCodePointAt);
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    public static void Lil(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static C0656lIII m2904Ll1(String str) {
        IL1Iii iL1Iii = new IL1Iii();
        iL1Iii.m2931il(null, str);
        return iL1Iii.I1I();
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public static List<String> m2905LlLLL(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int iIndexOf = str.indexOf(38, i);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i = iIndexOf + 1;
        }
        return arrayList;
    }

    public static void iIi1(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    public static String iIlLiL(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '%' || (cCharAt == '+' && z)) {
                I1I i1i = new I1I();
                i1i.m97LL(str, i, i3);
                I11L(i1i, str, i3, i2, z);
                return i1i.mo2785LlLLL();
            }
        }
        return str.substring(i, i2);
    }

    public static boolean llliI(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && Util.decodeHexDigit(str.charAt(i + 1)) != -1 && Util.decodeHexDigit(str.charAt(i3)) != -1;
    }

    public String ILL() {
        if (this.f4669ILil.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        int length = this.f4668IL1Iii.length() + 3;
        String str = this.f2121L11I;
        return this.f2121L11I.substring(length, Util.delimiterOffset(str, length, str.length(), ":@"));
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public boolean m2906ILl() {
        return this.f4668IL1Iii.equals("https");
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public String m2907IiL() {
        int iIndexOf = this.f2121L11I.indexOf(47, this.f4668IL1Iii.length() + 3);
        String str = this.f2121L11I;
        return this.f2121L11I.substring(iIndexOf, Util.delimiterOffset(str, iIndexOf, str.length(), "?#"));
    }

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public String m2908L111() {
        return this.f4668IL1Iii;
    }

    @Nullable
    public C0656lIII LL1IL(String str) {
        IL1Iii iL1IiiM2914llL1ii = m2914llL1ii(str);
        if (iL1IiiM2914llL1ii != null) {
            return iL1IiiM2914llL1ii.I1I();
        }
        return null;
    }

    public IL1Iii LlLI1() {
        IL1Iii iL1Iii = new IL1Iii();
        iL1Iii.f4672IL1Iii = this.f4668IL1Iii;
        iL1Iii.f4673ILil = ILL();
        iL1Iii.f4671I1I = m2910iILLL1();
        iL1Iii.f2124IL = this.f2119IL;
        iL1Iii.f4674Ilil = this.f4670Ilil != Ilil(this.f4668IL1Iii) ? this.f4670Ilil : -1;
        iL1Iii.f2127lLi1LL.clear();
        iL1Iii.f2127lLi1LL.addAll(m2909L11I());
        iL1Iii.m2930lLi1LL(m2916il());
        iL1Iii.f2125IiL = m2915lLi1LL();
        return iL1Iii;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public List<String> m2909L11I() {
        int iIndexOf = this.f2121L11I.indexOf(47, this.f4668IL1Iii.length() + 3);
        String str = this.f2121L11I;
        int iDelimiterOffset = Util.delimiterOffset(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iDelimiterOffset) {
            int i = iIndexOf + 1;
            int iDelimiterOffset2 = Util.delimiterOffset(this.f2121L11I, i, iDelimiterOffset, '/');
            arrayList.add(this.f2121L11I.substring(i, iDelimiterOffset2));
            iIndexOf = iDelimiterOffset2;
        }
        return arrayList;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof C0656lIII) && ((C0656lIII) obj).f2121L11I.equals(this.f2121L11I);
    }

    public int hashCode() {
        return this.f2121L11I.hashCode();
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public String m2910iILLL1() {
        if (this.f4667I1I.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        return this.f2121L11I.substring(this.f2121L11I.indexOf(58, this.f4668IL1Iii.length() + 3) + 1, this.f2121L11I.indexOf(64));
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public String m2911lIiI() {
        return this.f2119IL;
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public String m2912lIII() {
        IL1Iii iL1IiiM2914llL1ii = m2914llL1ii("/...");
        iL1IiiM2914llL1ii.m2932lL(BuildConfig.FLAVOR);
        iL1IiiM2914llL1ii.m2924Ll1(BuildConfig.FLAVOR);
        return iL1IiiM2914llL1ii.I1I().toString();
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public List<String> m2913lIlii() {
        return this.f2123lLi1LL;
    }

    @Nullable
    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public IL1Iii m2914llL1ii(String str) {
        try {
            IL1Iii iL1Iii = new IL1Iii();
            iL1Iii.m2931il(this, str);
            return iL1Iii;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public String m2915lLi1LL() {
        if (this.f2120IiL == null) {
            return null;
        }
        return this.f2121L11I.substring(this.f2121L11I.indexOf(35) + 1);
    }

    public String toString() {
        return this.f2121L11I;
    }

    @Nullable
    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public String m2916il() {
        if (this.f2122iILLL1 == null) {
            return null;
        }
        int iIndexOf = this.f2121L11I.indexOf(63) + 1;
        String str = this.f2121L11I;
        return this.f2121L11I.substring(iIndexOf, Util.delimiterOffset(str, iIndexOf, str.length(), '#'));
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public final List<String> m2917lL(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? I11li1(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public int m2918l() {
        return this.f4670Ilil;
    }

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public URI m2919LLlI1() {
        IL1Iii iL1IiiLlLI1 = LlLI1();
        iL1IiiLlLI1.m2929llL1ii();
        String string = iL1IiiLlLI1.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                return URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", BuildConfig.FLAVOR));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    @Nullable
    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public String m29201() {
        if (this.f2122iILLL1 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Lil(sb, this.f2122iILLL1);
        return sb.toString();
    }
}
