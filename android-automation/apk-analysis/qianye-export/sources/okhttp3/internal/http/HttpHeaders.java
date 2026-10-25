package okhttp3.internal.http;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.internal.Util;
import p047IL.C0654ILl;
import p047IL.C0656lIII;
import p047IL.IIi;
import p047IL.L1l;
import p047IL.LlLLL;
import p047IL.iIi1;
import p047IL.iIlLiL;
import p066Ilil.I1I;
import p066Ilil.iILLL1;

/* JADX INFO: loaded from: classes.dex */
public final class HttpHeaders {
    private static final iILLL1 QUOTED_STRING_DELIMITERS = iILLL1.encodeUtf8("\"\\");
    private static final iILLL1 TOKEN_DELIMITERS = iILLL1.encodeUtf8("\t ,=");

    private HttpHeaders() {
    }

    public static long contentLength(IIi iIi) {
        return contentLength(iIi.LLL());
    }

    public static boolean hasBody(IIi iIi) {
        if (iIi.m2848LIl().m2873iILLL1().equals("HEAD")) {
            return false;
        }
        int iM2847L11 = iIi.m2847L11();
        return (((iM2847L11 >= 100 && iM2847L11 < 200) || iM2847L11 == 204 || iM2847L11 == 304) && contentLength(iIi) == -1 && !"chunked".equalsIgnoreCase(iIi.m2844IIiI("Transfer-Encoding"))) ? false : true;
    }

    public static boolean hasVaryAll(IIi iIi) {
        return hasVaryAll(iIi.LLL());
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0088  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:61:0x007d A[EDGE_INSN: B:61:0x007d->B:28:0x007d BREAK  A[LOOP:2: B:22:0x006a->B:51:0x00c5], SYNTHETIC] */
    private static void parseChallengeHeader(List<C0654ILl> list, I1I i1i) {
        String token;
        while (true) {
            String token2 = null;
            while (true) {
                if (token2 == null) {
                    skipWhitespaceAndCommas(i1i);
                    token2 = readToken(i1i);
                    if (token2 == null) {
                        return;
                    }
                }
                boolean zSkipWhitespaceAndCommas = skipWhitespaceAndCommas(i1i);
                String token3 = readToken(i1i);
                if (token3 == null) {
                    if (i1i.ILL()) {
                        list.add(new C0654ILl(token2, Collections.emptyMap()));
                        return;
                    }
                    return;
                }
                int iSkipAll = skipAll(i1i, (byte) 61);
                boolean zSkipWhitespaceAndCommas2 = skipWhitespaceAndCommas(i1i);
                if (zSkipWhitespaceAndCommas || !(zSkipWhitespaceAndCommas2 || i1i.ILL())) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int iSkipAll2 = iSkipAll + skipAll(i1i, (byte) 61);
                    while (true) {
                        if (token3 == null) {
                            token3 = readToken(i1i);
                            if (skipWhitespaceAndCommas(i1i)) {
                                break;
                            }
                            iSkipAll2 = skipAll(i1i, (byte) 61);
                            if (iSkipAll2 == 0) {
                                break;
                            }
                            if (iSkipAll2 <= 1 || skipWhitespaceAndCommas(i1i)) {
                                return;
                            }
                            if (i1i.ILL() && i1i.LLL(0L) == 34) {
                                token = readQuotedString(i1i);
                            } else {
                                token = readToken(i1i);
                            }
                            if (token != null || ((String) linkedHashMap.put(token3, token)) != null) {
                                return;
                            }
                            if (skipWhitespaceAndCommas(i1i) && !i1i.ILL()) {
                                return;
                            } else {
                                token3 = null;
                            }
                        } else {
                            if (iSkipAll2 == 0) {
                                break;
                                break;
                            }
                            if (iSkipAll2 <= 1) {
                                return;
                            }
                            if (i1i.ILL()) {
                                token = readToken(i1i);
                            } else {
                                token = readToken(i1i);
                            }
                            if (token != null) {
                                return;
                            }
                            if (skipWhitespaceAndCommas(i1i)) {
                            }
                            token3 = null;
                        }
                    }
                    list.add(new C0654ILl(token2, linkedHashMap));
                    token2 = token3;
                } else {
                    list.add(new C0654ILl(token2, Collections.singletonMap(null, token3 + repeat('=', iSkipAll))));
                }
            }
        }
    }

    public static List<C0654ILl> parseChallenges(LlLLL llLLL, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < llLLL.m2884IiL(); i++) {
            if (str.equalsIgnoreCase(llLLL.Ilil(i))) {
                I1I i1i = new I1I();
                i1i.Liil1L1l(llLLL.m2885L11I(i));
                parseChallengeHeader(arrayList, i1i);
            }
        }
        return arrayList;
    }

    public static int parseSeconds(String str, int i) {
        try {
            long j = Long.parseLong(str);
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j < 0) {
                return 0;
            }
            return (int) j;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    private static String readQuotedString(I1I i1i) {
        if (i1i.mo2798lIlii() != 34) {
            throw new IllegalArgumentException();
        }
        I1I i1i2 = new I1I();
        while (true) {
            long jM2770I1L11L = i1i.m2770I1L11L(QUOTED_STRING_DELIMITERS);
            if (jM2770I1L11L == -1) {
                return null;
            }
            if (i1i.LLL(jM2770I1L11L) == 34) {
                i1i2.write(i1i, jM2770I1L11L);
                i1i.mo2798lIlii();
                return i1i2.mo2785LlLLL();
            }
            if (i1i.m96I() == jM2770I1L11L + 1) {
                return null;
            }
            i1i2.write(i1i, jM2770I1L11L);
            i1i.mo2798lIlii();
            i1i2.write(i1i, 1L);
        }
    }

    private static String readToken(I1I i1i) {
        try {
            long jM2770I1L11L = i1i.m2770I1L11L(TOKEN_DELIMITERS);
            if (jM2770I1L11L == -1) {
                jM2770I1L11L = i1i.m96I();
            }
            if (jM2770I1L11L != 0) {
                return i1i.m2778LIl(jM2770I1L11L);
            }
            return null;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    public static void receiveHeaders(iIlLiL iillil, C0656lIII c0656lIII, LlLLL llLLL) {
        if (iillil == iIlLiL.f4651IL1Iii) {
            return;
        }
        List<iIi1> listM2895lLi1LL = iIi1.m2895lLi1LL(c0656lIII, llLLL);
        if (listM2895lLi1LL.isEmpty()) {
            return;
        }
        iillil.IL1Iii(c0656lIII, listM2895lLi1LL);
    }

    private static String repeat(char c, int i) {
        char[] cArr = new char[i];
        Arrays.fill(cArr, c);
        return new String(cArr);
    }

    private static int skipAll(I1I i1i, byte b) {
        int i = 0;
        while (!i1i.ILL() && i1i.LLL(0L) == b) {
            i++;
            i1i.mo2798lIlii();
        }
        return i;
    }

    public static int skipUntil(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int skipWhitespace(String str, int i) {
        char cCharAt;
        while (i < str.length() && ((cCharAt = str.charAt(i)) == ' ' || cCharAt == '\t')) {
            i++;
        }
        return i;
    }

    private static boolean skipWhitespaceAndCommas(I1I i1i) {
        boolean z = false;
        while (!i1i.ILL()) {
            byte bLLL = i1i.LLL(0L);
            if (bLLL != 44) {
                if (bLLL != 32 && bLLL != 9) {
                    break;
                }
                i1i.mo2798lIlii();
            } else {
                i1i.mo2798lIlii();
                z = true;
            }
        }
        return z;
    }

    private static long stringToLong(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    private static Set<String> varyFields(IIi iIi) {
        return varyFields(iIi.LLL());
    }

    public static LlLLL varyHeaders(IIi iIi) {
        return varyHeaders(iIi.m2845ILLIi().m2848LIl().Ilil(), iIi.LLL());
    }

    public static boolean varyMatches(IIi iIi, LlLLL llLLL, L1l l1l) {
        for (String str : varyFields(iIi)) {
            if (!Objects.equals(llLLL.m2887il(str), l1l.m2870IL(str))) {
                return false;
            }
        }
        return true;
    }

    public static long contentLength(LlLLL llLLL) {
        return stringToLong(llLLL.I1I("Content-Length"));
    }

    public static boolean hasVaryAll(LlLLL llLLL) {
        return varyFields(llLLL).contains("*");
    }

    public static Set<String> varyFields(LlLLL llLLL) {
        Set<String> setEmptySet = Collections.emptySet();
        int iM2884IiL = llLLL.m2884IiL();
        for (int i = 0; i < iM2884IiL; i++) {
            if ("Vary".equalsIgnoreCase(llLLL.Ilil(i))) {
                String strM2885L11I = llLLL.m2885L11I(i);
                if (setEmptySet.isEmpty()) {
                    setEmptySet = new TreeSet<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : strM2885L11I.split(",")) {
                    setEmptySet.add(str.trim());
                }
            }
        }
        return setEmptySet;
    }

    public static LlLLL varyHeaders(LlLLL llLLL, LlLLL llLLL2) {
        Set<String> setVaryFields = varyFields(llLLL2);
        if (setVaryFields.isEmpty()) {
            return Util.EMPTY_HEADERS;
        }
        LlLLL.IL1Iii iL1Iii = new LlLLL.IL1Iii();
        int iM2884IiL = llLLL.m2884IiL();
        for (int i = 0; i < iM2884IiL; i++) {
            String strIlil = llLLL.Ilil(i);
            if (setVaryFields.contains(strIlil)) {
                iL1Iii.IL1Iii(strIlil, llLLL.m2885L11I(i));
            }
        }
        return iL1Iii.Ilil();
    }
}
