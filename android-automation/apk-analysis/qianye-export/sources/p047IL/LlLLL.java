package p047IL;

import com.google.android.flexbox.BuildConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.internal.Util;

/* JADX INFO: renamed from: I丨L.L丨lLLL, reason: invalid class name */
/* JADX INFO: compiled from: Headers.java */
/* JADX INFO: loaded from: classes.dex */
public final class LlLLL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final String[] f4645IL1Iii;

    /* JADX INFO: renamed from: I丨L.L丨lLLL$IL1Iii */
    /* JADX INFO: compiled from: Headers.java */
    public static final class IL1Iii {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final List<String> f4646IL1Iii = new ArrayList(20);

        public IL1Iii I1I(String str) {
            int iIndexOf = str.indexOf(":", 1);
            if (iIndexOf != -1) {
                m2888IL(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
                return this;
            }
            if (str.startsWith(":")) {
                m2888IL(BuildConfig.FLAVOR, str.substring(1));
                return this;
            }
            m2888IL(BuildConfig.FLAVOR, str);
            return this;
        }

        public IL1Iii IL1Iii(String str, String str2) {
            LlLLL.IL1Iii(str);
            LlLLL.ILil(str2, str);
            m2888IL(str, str2);
            return this;
        }

        public IL1Iii ILil(LlLLL llLLL) {
            int iM2884IiL = llLLL.m2884IiL();
            for (int i = 0; i < iM2884IiL; i++) {
                m2888IL(llLLL.Ilil(i), llLLL.m2885L11I(i));
            }
            return this;
        }

        public LlLLL Ilil() {
            return new LlLLL(this);
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public IL1Iii m2888IL(String str, String str2) {
            this.f4646IL1Iii.add(str);
            this.f4646IL1Iii.add(str2.trim());
            return this;
        }

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public IL1Iii m2889iILLL1(String str, String str2) {
            LlLLL.IL1Iii(str);
            LlLLL.ILil(str2, str);
            m2890lLi1LL(str);
            m2888IL(str, str2);
            return this;
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public IL1Iii m2890lLi1LL(String str) {
            int i = 0;
            while (i < this.f4646IL1Iii.size()) {
                if (str.equalsIgnoreCase(this.f4646IL1Iii.get(i))) {
                    this.f4646IL1Iii.remove(i);
                    this.f4646IL1Iii.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }
    }

    public LlLLL(IL1Iii iL1Iii) {
        List<String> list = iL1Iii.f4646IL1Iii;
        this.f4645IL1Iii = (String[]) list.toArray(new String[list.size()]);
    }

    public static void IL1Iii(String str) {
        Objects.requireNonNull(str, "name == null");
        if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= ' ' || cCharAt >= 127) {
                throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str));
            }
        }
    }

    public static void ILil(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("value for name " + str2 + " == null");
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str2, str));
            }
        }
    }

    @Nullable
    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static String m2882IL(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static LlLLL m2883iILLL1(String... strArr) {
        Objects.requireNonNull(strArr, "namesAndValues == null");
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (int i = 0; i < strArr2.length; i++) {
            if (strArr2[i] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i] = strArr2[i].trim();
        }
        for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
            String str = strArr2[i2];
            String str2 = strArr2[i2 + 1];
            IL1Iii(str);
            ILil(str2, str);
        }
        return new LlLLL(strArr2);
    }

    @Nullable
    public String I1I(String str) {
        return m2882IL(this.f4645IL1Iii, str);
    }

    public String Ilil(int i) {
        return this.f4645IL1Iii[i * 2];
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public int m2884IiL() {
        return this.f4645IL1Iii.length / 2;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public String m2885L11I(int i) {
        return this.f4645IL1Iii[(i * 2) + 1];
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof LlLLL) && Arrays.equals(((LlLLL) obj).f4645IL1Iii, this.f4645IL1Iii);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f4645IL1Iii);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public IL1Iii m2886lLi1LL() {
        IL1Iii iL1Iii = new IL1Iii();
        Collections.addAll(iL1Iii.f4646IL1Iii, this.f4645IL1Iii);
        return iL1Iii;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iM2884IiL = m2884IiL();
        for (int i = 0; i < iM2884IiL; i++) {
            sb.append(Ilil(i));
            sb.append(": ");
            sb.append(m2885L11I(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public List<String> m2887il(String str) {
        int iM2884IiL = m2884IiL();
        ArrayList arrayList = null;
        for (int i = 0; i < iM2884IiL; i++) {
            if (str.equalsIgnoreCase(Ilil(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(m2885L11I(i));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public LlLLL(String[] strArr) {
        this.f4645IL1Iii = strArr;
    }
}
