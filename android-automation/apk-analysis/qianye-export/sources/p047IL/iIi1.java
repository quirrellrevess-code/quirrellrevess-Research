package p047IL;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.BuildConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* JADX INFO: compiled from: Cookie.java */
/* JADX INFO: loaded from: classes.dex */
public final class iIi1 {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final long f4647I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final String f4648IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final String f4649ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final String f4650Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final String f2109IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final boolean f2110IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final boolean f2111L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final boolean f2112iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final boolean f2113lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static final Pattern f2108il = Pattern.compile("(\\d{2,4})[^\\d]*");
    public static final Pattern ILL = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static final Pattern f2106Ll1 = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public static final Pattern f2107lIiI = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    public iIi1(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f4648IL1Iii = str;
        this.f4649ILil = str2;
        this.f4647I1I = j;
        this.f2109IL = str3;
        this.f4650Ilil = str4;
        this.f2113lLi1LL = z;
        this.f2112iILLL1 = z2;
        this.f2111L11I = z3;
        this.f2110IiL = z4;
    }

    public static int IL1Iii(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || (cCharAt >= '0' && cCharAt <= '9') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static boolean ILil(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !Util.verifyAsIpAddress(str);
    }

    @Nullable
    public static iIi1 Ilil(C0656lIII c0656lIII, String str) {
        return m2891IL(System.currentTimeMillis(), c0656lIII, str);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00c0 A[PHI: r0
  0x00c0: PHI (r0v15 long) = (r0v2 long), (r0v5 long) binds: [B:42:0x00be, B:53:0x00e1] A[DONT_GENERATE, DONT_INLINE]] */
    @Nullable
    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static iIi1 m2891IL(long j, C0656lIII c0656lIII, String str) {
        long j2;
        iIi1 iii1;
        String str2;
        String strSubstring;
        int length = str.length();
        char c = ';';
        int iDelimiterOffset = Util.delimiterOffset(str, 0, length, ';');
        char c2 = '=';
        int iDelimiterOffset2 = Util.delimiterOffset(str, 0, iDelimiterOffset, '=');
        if (iDelimiterOffset2 == iDelimiterOffset) {
            return null;
        }
        String strTrimSubstring = Util.trimSubstring(str, 0, iDelimiterOffset2);
        if (strTrimSubstring.isEmpty() || Util.indexOfControlOrNonAscii(strTrimSubstring) != -1) {
            return null;
        }
        String strTrimSubstring2 = Util.trimSubstring(str, iDelimiterOffset2 + 1, iDelimiterOffset);
        if (Util.indexOfControlOrNonAscii(strTrimSubstring2) != -1) {
            return null;
        }
        int i = iDelimiterOffset + 1;
        String str3 = null;
        String strM2894iILLL1 = null;
        long jM2893L11I = -1;
        long jM2892IiL = 253402300799999L;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = false;
        while (i < length) {
            int iDelimiterOffset3 = Util.delimiterOffset(str, i, length, c);
            int iDelimiterOffset4 = Util.delimiterOffset(str, i, iDelimiterOffset3, c2);
            String strTrimSubstring3 = Util.trimSubstring(str, i, iDelimiterOffset4);
            String strTrimSubstring4 = iDelimiterOffset4 < iDelimiterOffset3 ? Util.trimSubstring(str, iDelimiterOffset4 + 1, iDelimiterOffset3) : BuildConfig.FLAVOR;
            if (strTrimSubstring3.equalsIgnoreCase("expires")) {
                try {
                    jM2892IiL = m2892IiL(strTrimSubstring4, 0, strTrimSubstring4.length());
                    z4 = true;
                } catch (NumberFormatException | IllegalArgumentException unused) {
                }
            } else if (strTrimSubstring3.equalsIgnoreCase("max-age")) {
                jM2893L11I = m2893L11I(strTrimSubstring4);
                z4 = true;
            } else if (strTrimSubstring3.equalsIgnoreCase("domain")) {
                strM2894iILLL1 = m2894iILLL1(strTrimSubstring4);
                z3 = false;
            } else if (strTrimSubstring3.equalsIgnoreCase("path")) {
                str3 = strTrimSubstring4;
            } else if (strTrimSubstring3.equalsIgnoreCase("secure")) {
                z = true;
            } else if (strTrimSubstring3.equalsIgnoreCase("httponly")) {
                z2 = true;
            }
            i = iDelimiterOffset3 + 1;
            c = ';';
            c2 = '=';
        }
        long j3 = Long.MIN_VALUE;
        if (jM2893L11I == Long.MIN_VALUE) {
            j2 = j3;
        } else if (jM2893L11I != -1) {
            j3 = j + (jM2893L11I <= 9223372036854775L ? jM2893L11I * 1000 : RecyclerView.FOREVER_NS);
            if (j3 < j || j3 > HttpDate.MAX_DATE) {
                j2 = 253402300799999L;
            } else {
                j2 = j3;
            }
        } else {
            j2 = jM2892IiL;
        }
        String strM2911lIiI = c0656lIII.m2911lIiI();
        if (strM2894iILLL1 == null) {
            str2 = strM2911lIiI;
            iii1 = null;
        } else {
            if (!ILil(strM2911lIiI, strM2894iILLL1)) {
                return null;
            }
            iii1 = null;
            str2 = strM2894iILLL1;
        }
        if (strM2911lIiI.length() != str2.length() && PublicSuffixDatabase.get().getEffectiveTldPlusOne(str2) == null) {
            return iii1;
        }
        if (str3 == null || !str3.startsWith("/")) {
            String strM2907IiL = c0656lIII.m2907IiL();
            int iLastIndexOf = strM2907IiL.lastIndexOf(47);
            strSubstring = iLastIndexOf != 0 ? strM2907IiL.substring(0, iLastIndexOf) : "/";
        } else {
            strSubstring = str3;
        }
        return new iIi1(strTrimSubstring, strTrimSubstring2, j2, str2, strSubstring, z, z2, z3, z4);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0081  */
    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static long m2892IiL(String str, int i, int i2) {
        int iIL1Iii = IL1Iii(str, i, i2, false);
        Matcher matcher = f2107lIiI.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int iIndexOf = -1;
        int i6 = -1;
        int i7 = -1;
        while (iIL1Iii < i2) {
            int iIL1Iii2 = IL1Iii(str, iIL1Iii + 1, i2, true);
            matcher.region(iIL1Iii, iIL1Iii2);
            if (i4 == -1 && matcher.usePattern(f2107lIiI).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
                i6 = Integer.parseInt(matcher.group(2));
                i7 = Integer.parseInt(matcher.group(3));
            } else if (i5 == -1 && matcher.usePattern(f2106Ll1).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else if (iIndexOf == -1) {
                Pattern pattern = ILL;
                if (matcher.usePattern(pattern).matches()) {
                    iIndexOf = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                } else if (i3 != -1 && matcher.usePattern(f2108il).matches()) {
                    i3 = Integer.parseInt(matcher.group(1));
                }
            } else if (i3 != -1) {
            }
            iIL1Iii = IL1Iii(str, iIL1Iii2 + 1, i2, false);
        }
        if (i3 >= 70 && i3 <= 99) {
            i3 += 1900;
        }
        if (i3 >= 0 && i3 <= 69) {
            i3 += 2000;
        }
        if (i3 < 1601) {
            throw new IllegalArgumentException();
        }
        if (iIndexOf == -1) {
            throw new IllegalArgumentException();
        }
        if (i5 < 1 || i5 > 31) {
            throw new IllegalArgumentException();
        }
        if (i4 < 0 || i4 > 23) {
            throw new IllegalArgumentException();
        }
        if (i6 < 0 || i6 > 59) {
            throw new IllegalArgumentException();
        }
        if (i7 < 0 || i7 > 59) {
            throw new IllegalArgumentException();
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i3);
        gregorianCalendar.set(2, iIndexOf - 1);
        gregorianCalendar.set(5, i5);
        gregorianCalendar.set(11, i4);
        gregorianCalendar.set(12, i6);
        gregorianCalendar.set(13, i7);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static long m2893L11I(String str) {
        try {
            long j = Long.parseLong(str);
            if (j <= 0) {
                return Long.MIN_VALUE;
            }
            return j;
        } catch (NumberFormatException e) {
            if (!str.matches("-?\\d+")) {
                throw e;
            }
            if (str.startsWith("-")) {
                return Long.MIN_VALUE;
            }
            return RecyclerView.FOREVER_NS;
        }
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static String m2894iILLL1(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String strCanonicalizeHost = Util.canonicalizeHost(str);
        if (strCanonicalizeHost != null) {
            return strCanonicalizeHost;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static List<iIi1> m2895lLi1LL(C0656lIII c0656lIII, LlLLL llLLL) {
        List<String> listM2887il = llLLL.m2887il("Set-Cookie");
        int size = listM2887il.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            iIi1 iii1Ilil = Ilil(c0656lIII, listM2887il.get(i));
            if (iii1Ilil != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(iii1Ilil);
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public String I1I() {
        return this.f4648IL1Iii;
    }

    public String ILL() {
        return this.f4649ILil;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof iIi1)) {
            return false;
        }
        iIi1 iii1 = (iIi1) obj;
        return iii1.f4648IL1Iii.equals(this.f4648IL1Iii) && iii1.f4649ILil.equals(this.f4649ILil) && iii1.f2109IL.equals(this.f2109IL) && iii1.f4650Ilil.equals(this.f4650Ilil) && iii1.f4647I1I == this.f4647I1I && iii1.f2113lLi1LL == this.f2113lLi1LL && iii1.f2112iILLL1 == this.f2112iILLL1 && iii1.f2110IiL == this.f2110IiL && iii1.f2111L11I == this.f2111L11I;
    }

    public int hashCode() {
        int iHashCode = (((((((527 + this.f4648IL1Iii.hashCode()) * 31) + this.f4649ILil.hashCode()) * 31) + this.f2109IL.hashCode()) * 31) + this.f4650Ilil.hashCode()) * 31;
        long j = this.f4647I1I;
        return ((((((((iHashCode + ((int) (j ^ (j >>> 32)))) * 31) + (!this.f2113lLi1LL ? 1 : 0)) * 31) + (!this.f2112iILLL1 ? 1 : 0)) * 31) + (!this.f2110IiL ? 1 : 0)) * 31) + (!this.f2111L11I ? 1 : 0);
    }

    public String toString() {
        return m2896il(false);
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public String m2896il(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4648IL1Iii);
        sb.append('=');
        sb.append(this.f4649ILil);
        if (this.f2110IiL) {
            if (this.f4647I1I == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(HttpDate.format(new Date(this.f4647I1I)));
            }
        }
        if (!this.f2111L11I) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.f2109IL);
        }
        sb.append("; path=");
        sb.append(this.f4650Ilil);
        if (this.f2113lLi1LL) {
            sb.append("; secure");
        }
        if (this.f2112iILLL1) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
}
