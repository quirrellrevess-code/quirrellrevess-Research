package p047IL;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* JADX INFO: renamed from: I丨L.L11丨丨丨1, reason: invalid class name */
/* JADX INFO: compiled from: MediaType.java */
/* JADX INFO: loaded from: classes.dex */
public final class L111 {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    @Nullable
    public final String f4624I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final String f4625IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final String f4626ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static final Pattern f2089IL = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static final Pattern f4623Ilil = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    public L111(String str, String str2, String str3, @Nullable String str4) {
        this.f4625IL1Iii = str;
        this.f4626ILil = str2;
        this.f4624I1I = str4;
    }

    public static L111 I1I(String str) {
        Matcher matcher = f2089IL.matcher(str);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
        }
        String strGroup = matcher.group(1);
        Locale locale = Locale.US;
        String lowerCase = strGroup.toLowerCase(locale);
        String lowerCase2 = matcher.group(2).toLowerCase(locale);
        String str2 = null;
        Matcher matcher2 = f4623Ilil.matcher(str);
        for (int iEnd = matcher.end(); iEnd < str.length(); iEnd = matcher2.end()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                throw new IllegalArgumentException("Parameter is not formatted correctly: \"" + str.substring(iEnd) + "\" for: \"" + str + '\"');
            }
            String strGroup2 = matcher2.group(1);
            if (strGroup2 != null && strGroup2.equalsIgnoreCase("charset")) {
                String strGroup3 = matcher2.group(2);
                if (strGroup3 == null) {
                    strGroup3 = matcher2.group(3);
                } else if (strGroup3.startsWith("'") && strGroup3.endsWith("'") && strGroup3.length() > 2) {
                    strGroup3 = strGroup3.substring(1, strGroup3.length() - 1);
                }
                if (str2 != null && !strGroup3.equalsIgnoreCase(str2)) {
                    throw new IllegalArgumentException("Multiple charsets defined: \"" + str2 + "\" and: \"" + strGroup3 + "\" for: \"" + str + '\"');
                }
                str2 = strGroup3;
            }
        }
        return new L111(str, lowerCase, lowerCase2, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static L111 m2866IL(String str) {
        try {
            return I1I(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @Nullable
    public Charset IL1Iii() {
        return ILil(null);
    }

    @Nullable
    public Charset ILil(@Nullable Charset charset) {
        try {
            String str = this.f4624I1I;
            return str != null ? Charset.forName(str) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public String Ilil() {
        return this.f4626ILil;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof L111) && ((L111) obj).f4625IL1Iii.equals(this.f4625IL1Iii);
    }

    public int hashCode() {
        return this.f4625IL1Iii.hashCode();
    }

    public String toString() {
        return this.f4625IL1Iii;
    }
}
