package ILil.p028IiL.p031Ll1;

import android.text.SpannableStringBuilder;
import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.MysqlErrorNumbers;
import java.util.Locale;

/* JADX INFO: compiled from: BidiFormatter.java */
/* JADX INFO: loaded from: classes.dex */
public final class IL1Iii {

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static final String f4149Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static final IL f1699IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static final IL1Iii f1700IiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static final IL1Iii f1701iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static final String f1702lLi1LL;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final IL f4150I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final boolean f4151IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final int f4152ILil;

    /* JADX INFO: renamed from: ILil.I丨iL.Ll丨1.IL1Iii$IL1Iii, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BidiFormatter.java */
    public static final class C0570IL1Iii {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public IL f4153I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public boolean f4154IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f4155ILil;

        public C0570IL1Iii() {
            I1I(IL1Iii.Ilil(Locale.getDefault()));
        }

        public static IL1Iii ILil(boolean z) {
            return z ? IL1Iii.f1700IiL : IL1Iii.f1701iILLL1;
        }

        public final void I1I(boolean z) {
            this.f4154IL1Iii = z;
            this.f4153I1I = IL1Iii.f1699IL;
            this.f4155ILil = 2;
        }

        public IL1Iii IL1Iii() {
            return (this.f4155ILil == 2 && this.f4153I1I == IL1Iii.f1699IL) ? ILil(this.f4154IL1Iii) : new IL1Iii(this.f4154IL1Iii, this.f4155ILil, this.f4153I1I);
        }
    }

    /* JADX INFO: compiled from: BidiFormatter.java */
    public static class ILil {

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public static final byte[] f1703lLi1LL = new byte[MysqlErrorNumbers.ER_CANT_EXECUTE_IN_READ_ONLY_TRANSACTION];

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final int f4156I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final CharSequence f4157IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final boolean f4158ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public char f4159Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int f1704IL;

        static {
            for (int i = 0; i < 1792; i++) {
                f1703lLi1LL[i] = Character.getDirectionality(i);
            }
        }

        public ILil(CharSequence charSequence, boolean z) {
            this.f4157IL1Iii = charSequence;
            this.f4158ILil = z;
            this.f4156I1I = charSequence.length();
        }

        public static byte I1I(char c) {
            return c < 1792 ? f1703lLi1LL[c] : Character.getDirectionality(c);
        }

        public byte IL1Iii() {
            char cCharAt = this.f4157IL1Iii.charAt(this.f1704IL - 1);
            this.f4159Ilil = cCharAt;
            if (Character.isLowSurrogate(cCharAt)) {
                int iCodePointBefore = Character.codePointBefore(this.f4157IL1Iii, this.f1704IL);
                this.f1704IL -= Character.charCount(iCodePointBefore);
                return Character.getDirectionality(iCodePointBefore);
            }
            this.f1704IL--;
            byte bI1I = I1I(this.f4159Ilil);
            if (!this.f4158ILil) {
                return bI1I;
            }
            char c = this.f4159Ilil;
            if (c == '>') {
                return m2241IiL();
            }
            return c == ';' ? m2244lLi1LL() : bI1I;
        }

        public byte ILil() {
            char cCharAt = this.f4157IL1Iii.charAt(this.f1704IL);
            this.f4159Ilil = cCharAt;
            if (Character.isHighSurrogate(cCharAt)) {
                int iCodePointAt = Character.codePointAt(this.f4157IL1Iii, this.f1704IL);
                this.f1704IL += Character.charCount(iCodePointAt);
                return Character.getDirectionality(iCodePointAt);
            }
            this.f1704IL++;
            byte bI1I = I1I(this.f4159Ilil);
            if (!this.f4158ILil) {
                return bI1I;
            }
            char c = this.f4159Ilil;
            if (c == '<') {
                return m2242L11I();
            }
            return c == '&' ? m2243iILLL1() : bI1I;
        }

        public int Ilil() {
            this.f1704IL = this.f4156I1I;
            int i = 0;
            int i2 = 0;
            while (this.f1704IL > 0) {
                byte bIL1Iii = IL1Iii();
                if (bIL1Iii == 0) {
                    if (i == 0) {
                        return -1;
                    }
                    if (i2 == 0) {
                        i2 = i;
                    }
                } else if (bIL1Iii == 1 || bIL1Iii == 2) {
                    if (i == 0) {
                        return 1;
                    }
                    if (i2 == 0) {
                        i2 = i;
                    }
                } else if (bIL1Iii != 9) {
                    switch (bIL1Iii) {
                        case 14:
                        case 15:
                            if (i2 == i) {
                                return -1;
                            }
                            i--;
                            break;
                        case 16:
                        case 17:
                            if (i2 == i) {
                                return 1;
                            }
                            i--;
                            break;
                        case 18:
                            i++;
                            break;
                        default:
                            if (i2 == 0) {
                                i2 = i;
                            }
                            break;
                    }
                } else {
                    continue;
                }
            }
            return 0;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int m2240IL() {
            this.f1704IL = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.f1704IL < this.f4156I1I && i == 0) {
                byte bILil = ILil();
                if (bILil != 0) {
                    if (bILil == 1 || bILil == 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                    } else if (bILil != 9) {
                        switch (bILil) {
                            case 14:
                            case 15:
                                i3++;
                                i2 = -1;
                                continue;
                            case 16:
                            case 17:
                                i3++;
                                i2 = 1;
                                continue;
                            case 18:
                                i3--;
                                i2 = 0;
                                continue;
                        }
                    }
                } else if (i3 == 0) {
                    return -1;
                }
                i = i3;
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.f1704IL > 0) {
                switch (IL1Iii()) {
                    case 14:
                    case 15:
                        if (i == i3) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i == i3) {
                            return 1;
                        }
                        break;
                    case 18:
                        i3++;
                        continue;
                    default:
                        continue;
                }
                i3--;
            }
            return 0;
        }

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public final byte m2241IiL() {
            char cCharAt;
            int i = this.f1704IL;
            while (true) {
                int i2 = this.f1704IL;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f4157IL1Iii;
                int i3 = i2 - 1;
                this.f1704IL = i3;
                char cCharAt2 = charSequence.charAt(i3);
                this.f4159Ilil = cCharAt2;
                if (cCharAt2 == '<') {
                    return (byte) 12;
                }
                if (cCharAt2 == '>') {
                    break;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i4 = this.f1704IL;
                        if (i4 <= 0) {
                            break;
                        }
                        CharSequence charSequence2 = this.f4157IL1Iii;
                        int i5 = i4 - 1;
                        this.f1704IL = i5;
                        cCharAt = charSequence2.charAt(i5);
                        this.f4159Ilil = cCharAt;
                    } while (cCharAt != cCharAt2);
                }
            }
            this.f1704IL = i;
            this.f4159Ilil = '>';
            return (byte) 13;
        }

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public final byte m2242L11I() {
            char cCharAt;
            int i = this.f1704IL;
            while (true) {
                int i2 = this.f1704IL;
                if (i2 >= this.f4156I1I) {
                    this.f1704IL = i;
                    this.f4159Ilil = '<';
                    return (byte) 13;
                }
                CharSequence charSequence = this.f4157IL1Iii;
                this.f1704IL = i2 + 1;
                char cCharAt2 = charSequence.charAt(i2);
                this.f4159Ilil = cCharAt2;
                if (cCharAt2 == '>') {
                    return (byte) 12;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i3 = this.f1704IL;
                        if (i3 >= this.f4156I1I) {
                            break;
                        }
                        CharSequence charSequence2 = this.f4157IL1Iii;
                        this.f1704IL = i3 + 1;
                        cCharAt = charSequence2.charAt(i3);
                        this.f4159Ilil = cCharAt;
                    } while (cCharAt != cCharAt2);
                }
            }
        }

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public final byte m2243iILLL1() {
            char cCharAt;
            do {
                int i = this.f1704IL;
                if (i >= this.f4156I1I) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.f4157IL1Iii;
                this.f1704IL = i + 1;
                cCharAt = charSequence.charAt(i);
                this.f4159Ilil = cCharAt;
            } while (cCharAt != ';');
            return (byte) 12;
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public final byte m2244lLi1LL() {
            char cCharAt;
            int i = this.f1704IL;
            do {
                int i2 = this.f1704IL;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f4157IL1Iii;
                int i3 = i2 - 1;
                this.f1704IL = i3;
                cCharAt = charSequence.charAt(i3);
                this.f4159Ilil = cCharAt;
                if (cCharAt == '&') {
                    return (byte) 12;
                }
            } while (cCharAt != ';');
            this.f1704IL = i;
            this.f4159Ilil = ';';
            return (byte) 13;
        }
    }

    static {
        IL il = lLi1LL.f4163I1I;
        f1699IL = il;
        f4149Ilil = Character.toString((char) 8206);
        f1702lLi1LL = Character.toString((char) 8207);
        f1701iILLL1 = new IL1Iii(false, 2, il);
        f1700IiL = new IL1Iii(true, 2, il);
    }

    public IL1Iii(boolean z, int i, IL il) {
        this.f4151IL1Iii = z;
        this.f4152ILil = i;
        this.f4150I1I = il;
    }

    public static IL1Iii I1I() {
        return new C0570IL1Iii().IL1Iii();
    }

    public static int IL1Iii(CharSequence charSequence) {
        return new ILil(charSequence, false).m2240IL();
    }

    public static int ILil(CharSequence charSequence) {
        return new ILil(charSequence, false).Ilil();
    }

    public static boolean Ilil(Locale locale) {
        return iILLL1.ILil(locale) == 1;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean m2235IL() {
        return (this.f4152ILil & 2) != 0;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public CharSequence m2236IiL(CharSequence charSequence) {
        return m2237L11I(charSequence, this.f4150I1I, true);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public CharSequence m2237L11I(CharSequence charSequence, IL il, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean zIL1Iii = il.IL1Iii(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (m2235IL() && z) {
            spannableStringBuilder.append((CharSequence) m2238iILLL1(charSequence, zIL1Iii ? lLi1LL.f4165ILil : lLi1LL.f4164IL1Iii));
        }
        if (zIL1Iii != this.f4151IL1Iii) {
            spannableStringBuilder.append(zIL1Iii ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) m2239lLi1LL(charSequence, zIL1Iii ? lLi1LL.f4165ILil : lLi1LL.f4164IL1Iii));
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final String m2238iILLL1(CharSequence charSequence, IL il) {
        boolean zIL1Iii = il.IL1Iii(charSequence, 0, charSequence.length());
        if (!this.f4151IL1Iii && (zIL1Iii || IL1Iii(charSequence) == 1)) {
            return f4149Ilil;
        }
        if (this.f4151IL1Iii) {
            return (!zIL1Iii || IL1Iii(charSequence) == -1) ? f1702lLi1LL : BuildConfig.FLAVOR;
        }
        return BuildConfig.FLAVOR;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final String m2239lLi1LL(CharSequence charSequence, IL il) {
        boolean zIL1Iii = il.IL1Iii(charSequence, 0, charSequence.length());
        if (!this.f4151IL1Iii && (zIL1Iii || ILil(charSequence) == 1)) {
            return f4149Ilil;
        }
        if (this.f4151IL1Iii) {
            return (!zIL1Iii || ILil(charSequence) == -1) ? f1702lLi1LL : BuildConfig.FLAVOR;
        }
        return BuildConfig.FLAVOR;
    }
}
