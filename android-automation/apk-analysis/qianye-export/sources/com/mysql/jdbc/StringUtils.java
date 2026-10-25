package com.mysql.jdbc;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class StringUtils {
    private static final int BYTE_RANGE = 256;
    private static final char[] HEX_DIGITS;
    private static final int NON_COMMENTS_MYSQL_VERSION_REF_LENGTH = 5;
    public static final Set<SearchMode> SEARCH_MODE__ALL = Collections.unmodifiableSet(EnumSet.allOf(SearchMode.class));
    public static final Set<SearchMode> SEARCH_MODE__BSESC_COM_WS;
    public static final Set<SearchMode> SEARCH_MODE__BSESC_MRK_WS;
    public static final Set<SearchMode> SEARCH_MODE__COM_WS;
    public static final Set<SearchMode> SEARCH_MODE__MRK_COM_WS;
    public static final Set<SearchMode> SEARCH_MODE__MRK_WS;
    public static final Set<SearchMode> SEARCH_MODE__NONE;
    private static final String VALID_ID_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789$_#@";
    public static final char WILDCARD_ESCAPE = '\\';
    public static final char WILDCARD_MANY = '%';
    public static final char WILDCARD_ONE = '_';
    private static final int WILD_COMPARE_CONTINUE_WITH_WILD = 1;
    private static final int WILD_COMPARE_MATCH = 0;
    private static final int WILD_COMPARE_NO_MATCH = -1;
    private static byte[] allBytes;
    private static char[] byteToChars;
    private static final ConcurrentHashMap<String, Charset> charsetsByAlias;
    private static final String platformEncoding;
    private static Method toPlainStringMethod;

    public enum SearchMode {
        ALLOW_BACKSLASH_ESCAPE,
        SKIP_BETWEEN_MARKERS,
        SKIP_BLOCK_COMMENTS,
        SKIP_LINE_COMMENTS,
        SKIP_WHITE_SPACE
    }

    static {
        SearchMode searchMode = SearchMode.SKIP_BETWEEN_MARKERS;
        SearchMode searchMode2 = SearchMode.SKIP_BLOCK_COMMENTS;
        SearchMode searchMode3 = SearchMode.SKIP_LINE_COMMENTS;
        SearchMode searchMode4 = SearchMode.SKIP_WHITE_SPACE;
        SEARCH_MODE__MRK_COM_WS = Collections.unmodifiableSet(EnumSet.of(searchMode, searchMode2, searchMode3, searchMode4));
        SearchMode searchMode5 = SearchMode.ALLOW_BACKSLASH_ESCAPE;
        SEARCH_MODE__BSESC_COM_WS = Collections.unmodifiableSet(EnumSet.of(searchMode5, searchMode2, searchMode3, searchMode4));
        SEARCH_MODE__BSESC_MRK_WS = Collections.unmodifiableSet(EnumSet.of(searchMode5, searchMode, searchMode4));
        SEARCH_MODE__COM_WS = Collections.unmodifiableSet(EnumSet.of(searchMode2, searchMode3, searchMode4));
        SEARCH_MODE__MRK_WS = Collections.unmodifiableSet(EnumSet.of(searchMode, searchMode4));
        SEARCH_MODE__NONE = Collections.unmodifiableSet(EnumSet.noneOf(SearchMode.class));
        allBytes = new byte[256];
        byteToChars = new char[256];
        charsetsByAlias = new ConcurrentHashMap<>();
        platformEncoding = System.getProperty("file.encoding");
        for (int i = -128; i <= 127; i++) {
            allBytes[i + 128] = (byte) i;
        }
        String str = new String(allBytes, 0, 255);
        int length = str.length();
        for (int i2 = 0; i2 < 255 && i2 < length; i2++) {
            byteToChars[i2] = str.charAt(i2);
        }
        try {
            toPlainStringMethod = BigDecimal.class.getMethod("toPlainString", new Class[0]);
        } catch (NoSuchMethodException unused) {
        }
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static void appendAsHex(StringBuilder sb, byte[] bArr) {
        sb.append("0x");
        for (byte b : bArr) {
            char[] cArr = HEX_DIGITS;
            sb.append(cArr[(b >>> 4) & 15]);
            sb.append(cArr[b & 15]);
        }
    }

    public static String consistentToString(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return null;
        }
        Method method = toPlainStringMethod;
        if (method != null) {
            try {
                return (String) method.invoke(bigDecimal, null);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        return bigDecimal.toString();
    }

    public static String dumpAsHex(byte[] bArr, int i) {
        StringBuilder sb = new StringBuilder(i * 4);
        int i2 = i / 8;
        int i3 = 0;
        for (int i4 = 0; i4 < i2 && i3 < i; i4++) {
            int i5 = i3;
            for (int i6 = 0; i6 < 8; i6++) {
                String hexString = Integer.toHexString(bArr[i5] & StatementImpl.USES_VARIABLES_UNKNOWN);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString + " ");
                i5++;
            }
            sb.append("    ");
            for (int i7 = 0; i7 < 8; i7++) {
                int i8 = bArr[i3] & StatementImpl.USES_VARIABLES_UNKNOWN;
                if (i8 <= 32 || i8 >= 127) {
                    sb.append(". ");
                } else {
                    sb.append(((char) i8) + " ");
                }
                i3++;
            }
            sb.append("\n");
        }
        int i9 = 0;
        for (int i10 = i3; i10 < i; i10++) {
            String hexString2 = Integer.toHexString(bArr[i10] & StatementImpl.USES_VARIABLES_UNKNOWN);
            if (hexString2.length() == 1) {
                hexString2 = "0" + hexString2;
            }
            sb.append(hexString2 + " ");
            i9++;
        }
        while (i9 < 8) {
            sb.append("   ");
            i9++;
        }
        sb.append("    ");
        while (i3 < i) {
            int i11 = bArr[i3] & StatementImpl.USES_VARIABLES_UNKNOWN;
            if (i11 <= 32 || i11 >= 127) {
                sb.append(". ");
            } else {
                sb.append(((char) i11) + " ");
            }
            i3++;
        }
        sb.append("\n");
        return sb.toString();
    }

    private static boolean endsWith(byte[] bArr, String str) {
        for (int i = 1; i <= str.length(); i++) {
            if (bArr[bArr.length - i] != str.charAt(str.length() - i)) {
                return false;
            }
        }
        return true;
    }

    public static byte[] escapeEasternUnicodeByteStream(byte[] bArr, String str) {
        if (bArr == 0) {
            return null;
        }
        int i = 0;
        if (bArr.length == 0) {
            return new byte[0];
        }
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        int i2 = 0;
        while (true) {
            if (str.charAt(i) == '\\') {
                byteArrayOutputStream.write(bArr[i2]);
                i2++;
            } else {
                int i3 = bArr[i2];
                if (i3 < 0) {
                    i3 += 256;
                }
                byteArrayOutputStream.write(i3);
                if (i3 >= 128) {
                    if (i2 < length - 1) {
                        i2++;
                        int i4 = bArr[i2];
                        if (i4 < 0) {
                            i4 += 256;
                        }
                        byteArrayOutputStream.write(i4);
                        if (i4 == 92) {
                            byteArrayOutputStream.write(i4);
                        }
                    }
                } else if (i3 == 92 && i2 < length - 1) {
                    int i5 = i2 + 1;
                    int i6 = bArr[i5];
                    if (i6 < 0) {
                        i6 += 256;
                    }
                    if (i6 == 98) {
                        byteArrayOutputStream.write(92);
                        byteArrayOutputStream.write(98);
                        i2 = i5;
                    }
                }
                i2++;
            }
            if (i2 >= length) {
                return byteArrayOutputStream.toByteArray();
            }
            i++;
        }
    }

    public static String escapeQuote(String str, String str2) {
        if (str == null) {
            return null;
        }
        String string = toString(stripEnclosure(str.getBytes(), str2, str2));
        int iIndexOf = string.indexOf(str2);
        String str3 = string.substring(0, iIndexOf) + str2 + str2;
        String strSubstring = string.substring(iIndexOf + 1, string.length());
        int iIndexOf2 = strSubstring.indexOf(str2);
        while (iIndexOf2 > -1) {
            str3 = (str3 + strSubstring.substring(0, iIndexOf2)) + str2 + str2;
            strSubstring = strSubstring.substring(iIndexOf2 + 1, strSubstring.length());
            iIndexOf2 = strSubstring.indexOf(str2);
        }
        return str3 + strSubstring;
    }

    public static Charset findCharset(String str) throws UnsupportedEncodingException {
        try {
            ConcurrentHashMap<String, Charset> concurrentHashMap = charsetsByAlias;
            Charset charset = concurrentHashMap.get(str);
            if (charset != null) {
                return charset;
            }
            Charset charsetForName = Charset.forName(str);
            Charset charsetPutIfAbsent = concurrentHashMap.putIfAbsent(str, charsetForName);
            return charsetPutIfAbsent != null ? charsetPutIfAbsent : charsetForName;
        } catch (IllegalCharsetNameException unused) {
            throw new UnsupportedEncodingException(str);
        } catch (UnsupportedCharsetException unused2) {
            throw new UnsupportedEncodingException(str);
        } catch (IllegalArgumentException unused3) {
            throw new UnsupportedEncodingException(str);
        }
    }

    public static char firstAlphaCharUc(String str, int i) {
        if (str == null) {
            return (char) 0;
        }
        int length = str.length();
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (Character.isLetter(cCharAt)) {
                return Character.toUpperCase(cCharAt);
            }
            i++;
        }
        return (char) 0;
    }

    public static char firstNonWsCharUc(String str) {
        return firstNonWsCharUc(str, 0);
    }

    public static String fixDecimalExponent(String str) {
        int i;
        char cCharAt;
        int iIndexOf = str.indexOf(69);
        if (iIndexOf == -1) {
            iIndexOf = str.indexOf(101);
        }
        if (iIndexOf == -1 || str.length() <= (i = iIndexOf + 1) || (cCharAt = str.charAt(i)) == '-' || cCharAt == '+') {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length() + 1);
        sb.append(str.substring(0, i));
        sb.append('+');
        sb.append(str.substring(i, str.length()));
        return sb.toString();
    }

    public static byte[] getBytes(char[] cArr, SingleByteCharsetConverter singleByteCharsetConverter, String str, String str2, boolean z, ExceptionInterceptor exceptionInterceptor) throws SQLException {
        byte[] bArrEscapeEasternUnicodeByteStream;
        try {
            if (singleByteCharsetConverter != null) {
                bArrEscapeEasternUnicodeByteStream = singleByteCharsetConverter.toBytes(cArr);
            } else if (str == null) {
                bArrEscapeEasternUnicodeByteStream = getBytes(cArr);
            } else {
                byte[] bytes = getBytes(cArr, str);
                bArrEscapeEasternUnicodeByteStream = (z || !CharsetMapping.requiresEscapeEasternUnicode(str) || str.equalsIgnoreCase(str2)) ? bytes : escapeEasternUnicodeByteStream(bytes, new String(cArr));
            }
            return bArrEscapeEasternUnicodeByteStream;
        } catch (UnsupportedEncodingException unused) {
            throw SQLError.createSQLException(Messages.getString("StringUtils.0") + str + Messages.getString("StringUtils.1"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
        }
    }

    public static byte[] getBytesNullTerminated(String str, String str2) throws UnsupportedEncodingException {
        ByteBuffer byteBufferEncode = findCharset(str2).encode(str);
        int iLimit = byteBufferEncode.limit();
        byte[] bArr = new byte[iLimit + 1];
        byteBufferEncode.get(bArr, 0, iLimit);
        bArr[iLimit] = 0;
        return bArr;
    }

    public static byte[] getBytesWrapped(String str, char c, char c2, SingleByteCharsetConverter singleByteCharsetConverter, String str2, String str3, boolean z, ExceptionInterceptor exceptionInterceptor) throws SQLException {
        byte[] bArrEscapeEasternUnicodeByteStream;
        try {
            if (singleByteCharsetConverter != null) {
                bArrEscapeEasternUnicodeByteStream = singleByteCharsetConverter.toBytesWrapped(str, c, c2);
            } else if (str2 == null) {
                StringBuilder sb = new StringBuilder(str.length() + 2);
                sb.append(c);
                sb.append(str);
                sb.append(c2);
                bArrEscapeEasternUnicodeByteStream = getBytes(sb.toString());
            } else {
                StringBuilder sb2 = new StringBuilder(str.length() + 2);
                sb2.append(c);
                sb2.append(str);
                sb2.append(c2);
                String string = sb2.toString();
                byte[] bytes = getBytes(string, str2);
                bArrEscapeEasternUnicodeByteStream = (z || !CharsetMapping.requiresEscapeEasternUnicode(str2) || str2.equalsIgnoreCase(str3)) ? bytes : escapeEasternUnicodeByteStream(bytes, string);
            }
            return bArrEscapeEasternUnicodeByteStream;
        } catch (UnsupportedEncodingException unused) {
            throw SQLError.createSQLException(Messages.getString("StringUtils.10") + str2 + Messages.getString("StringUtils.11"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
        }
    }

    public static int getInt(byte[] bArr) throws NumberFormatException {
        return getInt(bArr, 0, bArr.length);
    }

    public static long getLong(byte[] bArr) throws NumberFormatException {
        return getLong(bArr, 0, bArr.length);
    }

    public static short getShort(byte[] bArr) throws NumberFormatException {
        return getShort(bArr, 0, bArr.length);
    }

    public static int indexOf(byte[] bArr, char c) {
        if (bArr == null) {
            return -1;
        }
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            if (bArr[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public static int indexOfIgnoreCase(String str, String str2) {
        return indexOfIgnoreCase(0, str, str2);
    }

    /* JADX WARN: Code duplicated, block: B:124:0x015f A[PHI: r0 r12
  0x015f: PHI (r0v11 int) = (r0v5 int), (r0v13 int) binds: [B:170:0x01d1, B:122:0x0158] A[DONT_GENERATE, DONT_INLINE]
  0x015f: PHI (r12v10 char) = (r12v5 char), (r12v2 char) binds: [B:170:0x01d1, B:122:0x0158] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:145:0x018c  */
    /* JADX WARN: Code duplicated, block: B:147:0x0194  */
    /* JADX WARN: Code duplicated, block: B:148:0x0199  */
    /* JADX WARN: Code duplicated, block: B:151:0x019e  */
    /* JADX WARN: Code duplicated, block: B:152:0x01a4 A[LOOP:5: B:152:0x01a4->B:213:?, LOOP_START, PHI: r0 r9
  0x01a4: PHI (r0v3 int) = (r0v1 int), (r0v4 int) binds: [B:144:0x018a, B:213:?] A[DONT_GENERATE, DONT_INLINE]
  0x01a4: PHI (r9v3 char) = (r9v1 char), (r9v5 char) binds: [B:144:0x018a, B:213:?] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:160:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:161:0x01be  */
    /* JADX WARN: Code duplicated, block: B:166:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:167:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:171:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e4 A[PHI: r0 r7
  0x00e4: PHI (r0v22 int) = (r0v10 int), (r0v17 int), (r0v25 int) binds: [B:150:0x019c, B:115:0x0143, B:77:0x00dd] A[DONT_GENERATE, DONT_INLINE]
  0x00e4: PHI (r7v47 char) = (r7v19 char), (r7v39 char), (r7v52 char) binds: [B:150:0x019c, B:115:0x0143, B:77:0x00dd] A[DONT_GENERATE, DONT_INLINE]] */
    private static int indexOfNextChar(int i, int i2, String str, String str2, String str3, String str4, Set<SearchMode> set) {
        int length;
        boolean z;
        int i3;
        int i4;
        char cCharAt;
        int i5;
        int i6;
        char cCharAt2;
        int i7;
        char cCharAt3;
        int i8;
        int iIndexOf;
        char cCharAt4;
        char cCharAt5;
        int i9 = i;
        int i10 = -1;
        if (str == null || i9 >= (length = str.length())) {
            return -1;
        }
        char cCharAt6 = str.charAt(i9);
        int i11 = i9 + 1;
        char cCharAt7 = i11 < length ? str.charAt(i11) : (char) 0;
        while (i9 <= i2) {
            int i12 = i9 + 2;
            char cCharAt8 = i12 < length ? str.charAt(i12) : (char) 0;
            int i13 = 1;
            if (set.contains(SearchMode.ALLOW_BACKSLASH_ESCAPE) && cCharAt6 == '\\') {
                i9++;
                int i14 = i9 + 2;
                cCharAt7 = i14 < length ? str.charAt(i14) : (char) 0;
            } else {
                if (!set.contains(SearchMode.SKIP_BETWEEN_MARKERS) || (iIndexOf = str2.indexOf(cCharAt6)) == i10) {
                    SearchMode searchMode = SearchMode.SKIP_BLOCK_COMMENTS;
                    if (set.contains(searchMode) && cCharAt6 == '/' && cCharAt7 == '*') {
                        if (cCharAt8 != '!') {
                            int i15 = i9 + 1;
                            while (true) {
                                i15++;
                                if (i15 <= i2) {
                                    if (str.charAt(i15) == '*') {
                                        int i16 = i15 + 1;
                                        if ((i16 < length ? str.charAt(i16) : (char) 0) == '/') {
                                            break;
                                        }
                                    }
                                } else {
                                    break;
                                }
                            }
                            i9 = i15 + 1;
                        } else {
                            i9 = i9 + 1 + 1;
                            int i17 = 1;
                            while (i17 <= 5 && (i8 = i9 + i17) < length && Character.isDigit(str.charAt(i8))) {
                                i17++;
                            }
                            if (i17 == 5) {
                                i9 += 5;
                            }
                        }
                        int i18 = i9 + 1;
                        cCharAt2 = i18 < length ? str.charAt(i18) : (char) 0;
                        int i19 = i9 + 2;
                        if (i19 < length) {
                            cCharAt3 = str.charAt(i19);
                        } else {
                            cCharAt3 = 0;
                        }
                        cCharAt7 = cCharAt3;
                        cCharAt6 = cCharAt2;
                    } else if (set.contains(searchMode) && cCharAt6 == '*' && cCharAt7 == '/') {
                        i9++;
                        int i20 = i9 + 2;
                        if (i20 < length) {
                            cCharAt = str.charAt(i20);
                        } else {
                            cCharAt = 0;
                        }
                        cCharAt7 = cCharAt;
                    } else {
                        if (set.contains(SearchMode.SKIP_LINE_COMMENTS)) {
                            if (cCharAt6 == '-' && cCharAt7 == '-') {
                                if (Character.isWhitespace(cCharAt8)) {
                                    z = false;
                                } else {
                                    z = cCharAt8 == ';';
                                    if (!z && cCharAt8 != 0) {
                                    }
                                }
                                if (z) {
                                    i9 = i9 + 1 + 1;
                                    i6 = i9 + 1;
                                    if (i6 < length) {
                                        cCharAt2 = str.charAt(i6);
                                    } else {
                                        cCharAt2 = 0;
                                    }
                                    i7 = i9 + 2;
                                    if (i7 < length) {
                                        cCharAt3 = str.charAt(i7);
                                    } else {
                                        cCharAt3 = 0;
                                    }
                                    cCharAt7 = cCharAt3;
                                    cCharAt6 = cCharAt2;
                                } else {
                                    do {
                                        i9++;
                                        if (i9 > i2 || (cCharAt6 = str.charAt(i9)) == '\n') {
                                            break;
                                        }
                                    } while (cCharAt6 != '\r');
                                    i3 = i9 + 1;
                                    if (i3 < length) {
                                        cCharAt8 = str.charAt(i3);
                                    } else {
                                        cCharAt8 = 0;
                                    }
                                    if (cCharAt6 == '\r' && cCharAt8 == '\n') {
                                        i5 = i3 + 1;
                                        if (i5 < length) {
                                            cCharAt8 = str.charAt(i5);
                                        } else {
                                            cCharAt8 = 0;
                                        }
                                        i9 = i3;
                                    }
                                    i4 = i9 + 2;
                                    if (i4 < length) {
                                        cCharAt = str.charAt(i4);
                                    } else {
                                        cCharAt = 0;
                                    }
                                    cCharAt7 = cCharAt;
                                }
                            } else {
                                z = false;
                            }
                            if (cCharAt6 == '#') {
                                if (z) {
                                    i9 = i9 + 1 + 1;
                                    i6 = i9 + 1;
                                    if (i6 < length) {
                                        cCharAt2 = str.charAt(i6);
                                    } else {
                                        cCharAt2 = 0;
                                    }
                                    i7 = i9 + 2;
                                    if (i7 < length) {
                                        cCharAt3 = str.charAt(i7);
                                    } else {
                                        cCharAt3 = 0;
                                    }
                                    cCharAt7 = cCharAt3;
                                    cCharAt6 = cCharAt2;
                                } else {
                                    do {
                                        i9++;
                                        if (i9 > i2) {
                                            break;
                                        }
                                        break;
                                        break;
                                    } while (cCharAt6 != '\r');
                                    i3 = i9 + 1;
                                    if (i3 < length) {
                                        cCharAt8 = str.charAt(i3);
                                    } else {
                                        cCharAt8 = 0;
                                    }
                                    if (cCharAt6 == '\r') {
                                        i5 = i3 + 1;
                                        if (i5 < length) {
                                            cCharAt8 = str.charAt(i5);
                                        } else {
                                            cCharAt8 = 0;
                                        }
                                        i9 = i3;
                                    }
                                    i4 = i9 + 2;
                                    if (i4 < length) {
                                        cCharAt = str.charAt(i4);
                                    } else {
                                        cCharAt = 0;
                                    }
                                    cCharAt7 = cCharAt;
                                }
                            }
                        }
                        if (!set.contains(SearchMode.SKIP_WHITE_SPACE) || !Character.isWhitespace(cCharAt6)) {
                            return i9;
                        }
                        cCharAt6 = cCharAt7;
                        cCharAt7 = cCharAt8;
                    }
                } else {
                    char cCharAt9 = str3.charAt(iIndexOf);
                    boolean z2 = str4.indexOf(cCharAt6) != i10;
                    int i21 = 0;
                    while (true) {
                        i9 += i13;
                        if (i9 > i2 || ((cCharAt4 = str.charAt(i9)) == cCharAt9 && i21 == 0)) {
                            break;
                        }
                        if (!z2 && str4.indexOf(cCharAt4) != i10) {
                            char cCharAt10 = str3.charAt(str2.indexOf(cCharAt4));
                            int i22 = 0;
                            while (true) {
                                i9 += i13;
                                if (i9 > i2 || ((cCharAt5 = str.charAt(i9)) == cCharAt10 && i22 == 0)) {
                                    break;
                                }
                                if (cCharAt5 == cCharAt4) {
                                    i22++;
                                } else if (cCharAt5 == cCharAt10) {
                                    i22--;
                                } else {
                                    if (set.contains(SearchMode.ALLOW_BACKSLASH_ESCAPE) && cCharAt5 == '\\') {
                                        i9++;
                                    }
                                    i13 = 1;
                                }
                            }
                        } else if (cCharAt4 == cCharAt6) {
                            i21++;
                        } else if (cCharAt4 == cCharAt9) {
                            i21--;
                        } else if (set.contains(SearchMode.ALLOW_BACKSLASH_ESCAPE) && cCharAt4 == '\\') {
                            i9++;
                        }
                        i10 = -1;
                        i13 = 1;
                    }
                    int i23 = i9 + 1;
                    cCharAt2 = i23 < length ? str.charAt(i23) : (char) 0;
                    int i24 = i9 + 2;
                    if (i24 < length) {
                        cCharAt3 = str.charAt(i24);
                    } else {
                        cCharAt3 = 0;
                    }
                    cCharAt7 = cCharAt3;
                    cCharAt6 = cCharAt2;
                }
                i9++;
                i10 = -1;
            }
            cCharAt6 = cCharAt8;
            i9++;
            i10 = -1;
        }
        return -1;
    }

    public static int indexOfQuoteDoubleAware(String str, String str2, int i) {
        if (str == null || str2 == null || str2.length() == 0 || i > str.length()) {
            return -1;
        }
        boolean z = true;
        int length = str.length() - 1;
        int iIndexOf = -1;
        while (z) {
            iIndexOf = str.indexOf(str2, i);
            if (iIndexOf == -1 || iIndexOf == length || !str.startsWith(str2, iIndexOf + 1)) {
                z = false;
            } else {
                i = iIndexOf + 2;
            }
        }
        return iIndexOf;
    }

    private static boolean isCharAtPosNotEqualIgnoreCase(String str, int i, char c, char c2) {
        return (Character.toLowerCase(str.charAt(i)) == c2 || Character.toUpperCase(str.charAt(i)) == c) ? false : true;
    }

    private static boolean isCharEqualIgnoreCase(char c, char c2, char c3) {
        return Character.toLowerCase(c) == c3 || Character.toUpperCase(c) == c2;
    }

    public static boolean isEmptyOrWhitespaceOnly(String str) {
        if (str != null && str.length() != 0) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isStrictlyNumeric(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        for (int i = 0; i < charSequence.length(); i++) {
            if (!Character.isDigit(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static final boolean isValidIdChar(char c) {
        return VALID_ID_CHARS.indexOf(c) != -1;
    }

    public static int lastIndexOf(byte[] bArr, char c) {
        if (bArr == null) {
            return -1;
        }
        for (int length = bArr.length - 1; length >= 0; length--) {
            if (bArr[length] == c) {
                return length;
            }
        }
        return -1;
    }

    public static String quoteIdentifier(String str, String str2, boolean z) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        int length = str2.length();
        if (length == 0 || " ".equals(str2)) {
            return strTrim;
        }
        if (!z && strTrim.startsWith(str2) && strTrim.endsWith(str2)) {
            String strSubstring = strTrim.substring(length, strTrim.length() - length);
            int iIndexOf = strSubstring.indexOf(str2);
            while (iIndexOf >= 0) {
                int i = iIndexOf + length;
                int iIndexOf2 = strSubstring.indexOf(str2, i);
                if (iIndexOf2 != i) {
                    break;
                }
                iIndexOf = strSubstring.indexOf(str2, iIndexOf2 + length);
            }
            if (iIndexOf < 0) {
                return strTrim;
            }
        }
        return str2 + strTrim.replaceAll(str2, str2 + str2) + str2;
    }

    public static byte[] s2b(String str, MySQLConnection mySQLConnection) throws SQLException {
        if (str == null) {
            return null;
        }
        if (mySQLConnection == null || !mySQLConnection.getUseUnicode()) {
            return str.getBytes();
        }
        try {
            String encoding = mySQLConnection.getEncoding();
            if (encoding == null) {
                return str.getBytes();
            }
            SingleByteCharsetConverter charsetConverter = mySQLConnection.getCharsetConverter(encoding);
            return charsetConverter != null ? charsetConverter.toBytes(str) : str.getBytes(encoding);
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public static String sanitizeProcOrFuncName(String str) {
        if (str == null || str.equals("%")) {
            return null;
        }
        return str;
    }

    public static List<String> split(String str, String str2, boolean z) {
        if (str == null) {
            return new ArrayList();
        }
        if (str2 == null) {
            throw new IllegalArgumentException();
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, str2, false);
        ArrayList arrayList = new ArrayList(stringTokenizer.countTokens());
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            if (z) {
                strNextToken = strNextToken.trim();
            }
            arrayList.add(strNextToken);
        }
        return arrayList;
    }

    public static List<String> splitDBdotName(String str, String str2, String str3, boolean z) {
        int iIndexOfIgnoreCase;
        String strUnQuoteIdentifier;
        if (str == null || str.equals("%")) {
            return Collections.emptyList();
        }
        if (" ".equals(str3)) {
            iIndexOfIgnoreCase = str.indexOf(".");
        } else {
            iIndexOfIgnoreCase = indexOfIgnoreCase(0, str, ".", str3, str3, z ? SEARCH_MODE__MRK_WS : SEARCH_MODE__BSESC_MRK_WS);
        }
        if (iIndexOfIgnoreCase != -1) {
            str2 = unQuoteIdentifier(str.substring(0, iIndexOfIgnoreCase), str3);
            strUnQuoteIdentifier = unQuoteIdentifier(str.substring(iIndexOfIgnoreCase + 1), str3);
        } else {
            strUnQuoteIdentifier = unQuoteIdentifier(str, str3);
        }
        return Arrays.asList(str2, strUnQuoteIdentifier);
    }

    private static boolean startsWith(byte[] bArr, String str) {
        int length = str.length();
        if (bArr.length < length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (bArr[i] != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean startsWithIgnoreCase(String str, int i, String str2) {
        return str.regionMatches(true, i, str2, 0, str2.length());
    }

    public static boolean startsWithIgnoreCaseAndNonAlphaNumeric(String str, String str2) {
        int i = 0;
        if (str == null) {
            return str2 == null;
        }
        int length = str.length();
        while (i < length && !Character.isLetterOrDigit(str.charAt(i))) {
            i++;
        }
        return startsWithIgnoreCase(str, i, str2);
    }

    public static boolean startsWithIgnoreCaseAndWs(String str, String str2) {
        return startsWithIgnoreCaseAndWs(str, str2, 0);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0017 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x00bc A[SYNTHETIC] */
    public static String stripComments(String str, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(str.length());
        StringReader stringReader = new StringReader(str);
        int i = -1;
        int i2 = 0;
        while (true) {
            try {
                int i3 = stringReader.read();
                if (i3 == -1) {
                    break;
                }
                if (i == -1 || i3 != str3.charAt(i)) {
                    int iIndexOf = str2.indexOf(i3);
                    if (iIndexOf != -1 && i2 == 0) {
                        i2 = i3;
                        i = iIndexOf;
                    }
                } else {
                    i = -1;
                    i2 = 0;
                }
                if (i2 == 0 && i3 == 47 && (z2 || z)) {
                    i3 = stringReader.read();
                    if (i3 == 42 && z) {
                        int i4 = 0;
                        do {
                            int i5 = stringReader.read();
                            if (i5 == 47 && i4 == 42) {
                                break;
                            }
                            if (i5 == 13) {
                                i4 = stringReader.read();
                                if (i4 == 10) {
                                    i4 = stringReader.read();
                                }
                            } else {
                                i4 = i5 == 10 ? stringReader.read() : i5;
                            }
                        } while (i4 >= 0);
                    } else {
                        if (i3 == 47 && z2) {
                            do {
                                i3 = stringReader.read();
                                if (i3 == 10 || i3 == 13) {
                                    break;
                                }
                            } while (i3 >= 0);
                        }
                        if (i3 != -1) {
                            sb.append((char) i3);
                        }
                    }
                } else {
                    if (i2 == 0 && i3 == 35 && z3) {
                        do {
                            i3 = stringReader.read();
                            if (i3 == 10 || i3 == 13) {
                                break;
                            }
                        } while (i3 >= 0);
                    } else if (i2 == 0 && i3 == 45 && z4) {
                        int i6 = stringReader.read();
                        if (i6 == -1 || i6 != 45) {
                            sb.append('-');
                            if (i6 != -1) {
                                sb.append((char) i6);
                            }
                        } else {
                            do {
                                i3 = stringReader.read();
                                if (i3 == 10 || i3 == 13) {
                                    break;
                                }
                            } while (i3 >= 0);
                        }
                    }
                    if (i3 != -1) {
                        sb.append((char) i3);
                    }
                }
            } catch (IOException unused) {
            }
        }
        return sb.toString();
    }

    public static byte[] stripEnclosure(byte[] bArr, String str, String str2) {
        if (bArr.length < str.length() + str2.length() || !startsWith(bArr, str) || !endsWith(bArr, str2)) {
            return bArr;
        }
        int length = bArr.length - (str.length() + str2.length());
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, str.length(), bArr2, 0, length);
        return bArr2;
    }

    public static String toAsciiString(byte[] bArr) {
        return toAsciiString(bArr, 0, bArr.length);
    }

    public static String toString(byte[] bArr, int i, int i2, String str) throws UnsupportedEncodingException {
        return findCharset(str).decode(ByteBuffer.wrap(bArr, i, i2)).toString();
    }

    public static String unQuoteIdentifier(String str, String str2) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        int length = str2.length();
        if (length == 0 || " ".equals(str2) || !strTrim.startsWith(str2) || !strTrim.endsWith(str2)) {
            return strTrim;
        }
        String strSubstring = strTrim.substring(length, strTrim.length() - length);
        int iIndexOf = strSubstring.indexOf(str2);
        while (iIndexOf >= 0) {
            int i = iIndexOf + length;
            int iIndexOf2 = strSubstring.indexOf(str2, i);
            if (iIndexOf2 != i) {
                return strTrim;
            }
            iIndexOf = strSubstring.indexOf(str2, iIndexOf2 + length);
        }
        return strTrim.substring(length, strTrim.length() - length).replaceAll(str2 + str2, str2);
    }

    public static boolean wildCompareIgnoreCase(String str, String str2) {
        return wildCompareInternal(str, str2) == 0;
    }

    private static int wildCompareInternal(String str, String str2) {
        char cCharAt;
        int i;
        int i2;
        if (str == null || str2 == null) {
            return -1;
        }
        if (str2.equals("%")) {
            return 0;
        }
        int length = str2.length();
        int length2 = str.length();
        int i3 = 0;
        int i4 = 0;
        int i5 = -1;
        while (i3 != length) {
            while (str2.charAt(i3) != '%' && str2.charAt(i3) != '_') {
                if (str2.charAt(i3) == '\\' && (i2 = i3 + 1) != length) {
                    i3 = i2;
                }
                if (i4 != length2) {
                    int i6 = i3 + 1;
                    int i7 = i4 + 1;
                    if (Character.toUpperCase(str2.charAt(i3)) == Character.toUpperCase(str.charAt(i4))) {
                        if (i6 == length) {
                            return i7 != length2 ? 1 : 0;
                        }
                        i3 = i6;
                        i4 = i7;
                        i5 = 1;
                    }
                }
                return 1;
            }
            if (str2.charAt(i3) == '_') {
                while (i4 != length2) {
                    i4++;
                    i3++;
                    if (i3 >= length || str2.charAt(i3) != '_') {
                        if (i3 == length) {
                            break;
                        }
                    }
                }
                return i5;
            }
            if (str2.charAt(i3) == '%') {
                int i8 = i3 + 1;
                while (i8 != length) {
                    if (str2.charAt(i8) != '%') {
                        if (str2.charAt(i8) != '_') {
                            break;
                        }
                        if (i4 == length2) {
                            return -1;
                        }
                        i4++;
                    }
                    i8++;
                }
                if (i8 == length) {
                    return 0;
                }
                if (i4 == length2) {
                    return -1;
                }
                char cCharAt2 = str2.charAt(i8);
                if (cCharAt2 != '\\' || (i = i8 + 1) == length) {
                    cCharAt = cCharAt2;
                } else {
                    cCharAt = str2.charAt(i);
                    i8 = i;
                }
                int i9 = 1 + i8;
                while (true) {
                    if (i4 == length2 || Character.toUpperCase(str.charAt(i4)) == Character.toUpperCase(cCharAt)) {
                        int i10 = i4 + 1;
                        if (i4 == length2) {
                            return -1;
                        }
                        int iWildCompareInternal = wildCompareInternal(str.substring(i10), str2.substring(i9));
                        if (iWildCompareInternal <= 0) {
                            return iWildCompareInternal;
                        }
                        if (i10 == length2) {
                            return -1;
                        }
                        i4 = i10;
                    } else {
                        i4++;
                    }
                }
            }
        }
        return i4 != length2 ? 1 : 0;
    }

    public static char firstNonWsCharUc(String str, int i) {
        if (str == null) {
            return (char) 0;
        }
        int length = str.length();
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (!Character.isWhitespace(cCharAt)) {
                return Character.toUpperCase(cCharAt);
            }
            i++;
        }
        return (char) 0;
    }

    public static int getInt(byte[] bArr, int i, int i2) throws NumberFormatException {
        boolean z;
        int upperCase;
        while (i < i2 && Character.isWhitespace((char) bArr[i])) {
            i++;
        }
        if (i == i2) {
            throw new NumberFormatException(toString(bArr));
        }
        int i3 = 0;
        if (((char) bArr[i]) == '-') {
            i++;
            z = true;
        } else {
            if (((char) bArr[i]) == '+') {
                i++;
            }
            z = false;
        }
        char c = z ? '\b' : (char) 7;
        int i4 = i;
        boolean z2 = false;
        while (i4 < i2) {
            char c2 = (char) bArr[i4];
            if (!Character.isDigit(c2)) {
                if (!Character.isLetter(c2)) {
                    break;
                }
                upperCase = (Character.toUpperCase(c2) - 'A') + 10;
            } else {
                upperCase = c2 - '0';
            }
            char c3 = (char) upperCase;
            if (c3 >= '\n') {
                break;
            }
            if (i3 > 214748364 || (i3 == 214748364 && c3 > c)) {
                z2 = true;
            } else {
                i3 = (i3 * 10) + c3;
            }
            i4++;
        }
        if (i4 == i) {
            throw new NumberFormatException(toString(bArr));
        }
        if (z2) {
            throw new NumberFormatException(toString(bArr));
        }
        return z ? -i3 : i3;
    }

    public static long getLong(byte[] bArr, int i, int i2) throws NumberFormatException {
        boolean z;
        int upperCase;
        int i3 = i;
        while (i3 < i2 && Character.isWhitespace((char) bArr[i3])) {
            i3++;
        }
        if (i3 == i2) {
            throw new NumberFormatException(toString(bArr));
        }
        boolean z2 = false;
        if (((char) bArr[i3]) == '-') {
            i3++;
            z = true;
        } else {
            if (((char) bArr[i3]) == '+') {
                i3++;
            }
            z = false;
        }
        char c = '\n';
        long j = 10;
        long j2 = RecyclerView.FOREVER_NS / j;
        long j3 = (int) (RecyclerView.FOREVER_NS % j);
        if (z) {
            j3++;
        }
        long j4 = 0;
        int i4 = i3;
        while (i4 < i2) {
            char c2 = (char) bArr[i4];
            if (!Character.isDigit(c2)) {
                if (!Character.isLetter(c2)) {
                    break;
                }
                upperCase = (Character.toUpperCase(c2) - 'A') + c;
            } else {
                upperCase = c2 - '0';
            }
            char c3 = (char) upperCase;
            if (c3 >= c) {
                break;
            }
            if (j4 > j2 || (j4 == j2 && c3 > j3)) {
                z2 = true;
            } else {
                j4 = (j4 * j) + ((long) c3);
                z2 = z2;
            }
            i4++;
            c = '\n';
        }
        boolean z3 = z2;
        if (i4 == i3) {
            throw new NumberFormatException(toString(bArr));
        }
        if (z3) {
            throw new NumberFormatException(toString(bArr));
        }
        return z ? -j4 : j4;
    }

    public static short getShort(byte[] bArr, int i, int i2) throws NumberFormatException {
        boolean z;
        int upperCase;
        while (i < i2 && Character.isWhitespace((char) bArr[i])) {
            i++;
        }
        if (i == i2) {
            throw new NumberFormatException(toString(bArr));
        }
        short s = 0;
        if (((char) bArr[i]) == '-') {
            i++;
            z = true;
        } else {
            if (((char) bArr[i]) == '+') {
                i++;
            }
            z = false;
        }
        short s2 = (short) 3276;
        short s3 = (short) 7;
        if (z) {
            s3 = (short) (s3 + 1);
        }
        int i3 = i;
        boolean z2 = false;
        while (i3 < i2) {
            char c = (char) bArr[i3];
            if (!Character.isDigit(c)) {
                if (!Character.isLetter(c)) {
                    break;
                }
                upperCase = (Character.toUpperCase(c) - 'A') + 10;
            } else {
                upperCase = c - '0';
            }
            short s4 = (char) upperCase;
            if (s4 >= 10) {
                break;
            }
            if (s > s2 || (s == s2 && s4 > s3)) {
                z2 = true;
            } else {
                s = (short) (((short) (s * 10)) + s4);
            }
            i3++;
        }
        if (i3 == i) {
            throw new NumberFormatException(toString(bArr));
        }
        if (z2) {
            throw new NumberFormatException(toString(bArr));
        }
        return z ? (short) (-s) : s;
    }

    public static int indexOfIgnoreCase(int i, String str, String str2) {
        if (str != null && str2 != null) {
            int length = str.length();
            int length2 = str2.length();
            int i2 = length - length2;
            if (i <= i2 && length2 != 0) {
                char upperCase = Character.toUpperCase(str2.charAt(0));
                char lowerCase = Character.toLowerCase(str2.charAt(0));
                while (i <= i2) {
                    if (isCharAtPosNotEqualIgnoreCase(str, i, upperCase, lowerCase)) {
                        do {
                            i++;
                            if (i > i2) {
                                break;
                            }
                        } while (isCharAtPosNotEqualIgnoreCase(str, i, upperCase, lowerCase));
                    }
                    if (i <= i2 && startsWithIgnoreCase(str, i, str2)) {
                        return i;
                    }
                    i++;
                }
            }
        }
        return -1;
    }

    public static boolean startsWithIgnoreCase(String str, String str2) {
        return startsWithIgnoreCase(str, 0, str2);
    }

    public static boolean startsWithIgnoreCaseAndWs(String str, String str2, int i) {
        if (str == null) {
            return str2 == null;
        }
        int length = str.length();
        while (i < length && Character.isWhitespace(str.charAt(i))) {
            i++;
        }
        return startsWithIgnoreCase(str, i, str2);
    }

    public static String toAsciiString(byte[] bArr, int i, int i2) {
        char[] cArr = new char[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            cArr[i3] = (char) bArr[i];
            i++;
        }
        return new String(cArr);
    }

    public static String toString(byte[] bArr, String str) throws UnsupportedEncodingException {
        return findCharset(str).decode(ByteBuffer.wrap(bArr)).toString();
    }

    public static void appendAsHex(StringBuilder sb, int i) {
        if (i == 0) {
            sb.append("0x0");
            return;
        }
        int i2 = 32;
        boolean z = false;
        sb.append("0x");
        do {
            i2 -= 4;
            byte b = (byte) ((i >>> i2) & 15);
            if (z) {
                sb.append(HEX_DIGITS[b]);
            } else if (b != 0) {
                sb.append(HEX_DIGITS[b]);
                z = true;
            }
        } while (i2 != 0);
    }

    public static int startsWithIgnoreCaseAndWs(String str, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (startsWithIgnoreCaseAndWs(str, strArr[i], 0)) {
                return i;
            }
        }
        return -1;
    }

    public static String toString(byte[] bArr, int i, int i2) {
        try {
            return findCharset(platformEncoding).decode(ByteBuffer.wrap(bArr, i, i2)).toString();
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static String toString(byte[] bArr) {
        try {
            return findCharset(platformEncoding).decode(ByteBuffer.wrap(bArr)).toString();
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static byte[] getBytes(char[] cArr, SingleByteCharsetConverter singleByteCharsetConverter, String str, String str2, int i, int i2, boolean z, ExceptionInterceptor exceptionInterceptor) throws SQLException {
        byte[] bArrEscapeEasternUnicodeByteStream;
        try {
            if (singleByteCharsetConverter != null) {
                bArrEscapeEasternUnicodeByteStream = singleByteCharsetConverter.toBytes(cArr, i, i2);
            } else if (str == null) {
                bArrEscapeEasternUnicodeByteStream = getBytes(cArr, i, i2);
            } else {
                byte[] bytes = getBytes(cArr, i, i2, str);
                bArrEscapeEasternUnicodeByteStream = (z || !CharsetMapping.requiresEscapeEasternUnicode(str) || str.equalsIgnoreCase(str2)) ? bytes : escapeEasternUnicodeByteStream(bytes, new String(cArr, i, i2));
            }
            return bArrEscapeEasternUnicodeByteStream;
        } catch (UnsupportedEncodingException unused) {
            throw SQLError.createSQLException(Messages.getString("StringUtils.0") + str + Messages.getString("StringUtils.1"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
        }
    }

    public static int indexOfIgnoreCase(int i, String str, String[] strArr, String str2, String str3, Set<SearchMode> set) {
        Set<SearchMode> setCopyOf = set;
        if (str != null && strArr != null) {
            int length = str.length();
            char c = 0;
            int length2 = 0;
            for (String str4 : strArr) {
                length2 += str4.length();
            }
            if (length2 == 0) {
                return -1;
            }
            int length3 = strArr.length;
            int i2 = length - (length2 + (length3 > 0 ? length3 - 1 : 0));
            if (i > i2) {
                return -1;
            }
            SearchMode searchMode = SearchMode.SKIP_BETWEEN_MARKERS;
            if (setCopyOf.contains(searchMode) && (str2 == null || str3 == null || str2.length() != str3.length())) {
                throw new IllegalArgumentException(Messages.getString("StringUtils.15", new String[]{str2, str3}));
            }
            if (Character.isWhitespace(strArr[0].charAt(0))) {
                SearchMode searchMode2 = SearchMode.SKIP_WHITE_SPACE;
                if (setCopyOf.contains(searchMode2)) {
                    setCopyOf = EnumSet.copyOf((Collection) set);
                    setCopyOf.remove(searchMode2);
                }
            }
            Set<SearchMode> set2 = setCopyOf;
            EnumSet enumSetOf = EnumSet.of(SearchMode.SKIP_WHITE_SPACE);
            enumSetOf.addAll(set2);
            enumSetOf.remove(searchMode);
            int i3 = i;
            while (i3 <= i2) {
                int iIndexOfIgnoreCase = indexOfIgnoreCase(i3, str, strArr[c], str2, str3, set2);
                if (iIndexOfIgnoreCase == -1 || iIndexOfIgnoreCase > i2) {
                    break;
                }
                int length4 = strArr[c].length() + iIndexOfIgnoreCase;
                int i4 = 0;
                boolean z = true;
                while (true) {
                    int i5 = i4 + 1;
                    if (i5 >= length3 || !z) {
                        break;
                    }
                    int i6 = length4;
                    int i7 = iIndexOfIgnoreCase;
                    EnumSet enumSet = enumSetOf;
                    int iIndexOfNextChar = indexOfNextChar(length4, length - 1, str, null, null, null, enumSetOf);
                    if (i6 == iIndexOfNextChar || !startsWithIgnoreCase(str, iIndexOfNextChar, strArr[i5])) {
                        length4 = i6;
                        z = false;
                    } else {
                        length4 = iIndexOfNextChar + strArr[i5].length();
                    }
                    iIndexOfIgnoreCase = i7;
                    enumSetOf = enumSet;
                    i4 = i5;
                }
                int i8 = iIndexOfIgnoreCase;
                EnumSet enumSet2 = enumSetOf;
                if (z) {
                    return i8;
                }
                i3 = i8 + 1;
                enumSetOf = enumSet2;
                c = 0;
            }
        }
        return -1;
    }

    public static List<String> split(String str, String str2, String str3, String str4, boolean z) {
        return split(str, str2, str3, str4, BuildConfig.FLAVOR, z);
    }

    public static String quoteIdentifier(String str, boolean z) {
        return quoteIdentifier(str, "`", z);
    }

    public static List<String> split(String str, String str2, String str3, String str4, String str5, boolean z) {
        if (str == null) {
            return new ArrayList();
        }
        if (str2 != null) {
            int i = 0;
            ArrayList arrayList = new ArrayList();
            while (true) {
                int iIndexOfIgnoreCase = indexOfIgnoreCase(i, str, str2, str3, str4, str5, SEARCH_MODE__MRK_COM_WS);
                if (iIndexOfIgnoreCase == -1) {
                    break;
                }
                String strSubstring = str.substring(i, iIndexOfIgnoreCase);
                if (z) {
                    strSubstring = strSubstring.trim();
                }
                arrayList.add(strSubstring);
                i = iIndexOfIgnoreCase + 1;
            }
            if (i < str.length()) {
                String strSubstring2 = str.substring(i);
                if (z) {
                    strSubstring2 = strSubstring2.trim();
                }
                arrayList.add(strSubstring2);
            }
            return arrayList;
        }
        throw new IllegalArgumentException();
    }

    public static byte[] getBytes(char[] cArr, String str, String str2, boolean z, MySQLConnection mySQLConnection, ExceptionInterceptor exceptionInterceptor) throws SQLException {
        try {
            return getBytes(cArr, mySQLConnection != null ? mySQLConnection.getCharsetConverter(str) : SingleByteCharsetConverter.getInstance(str, null), str, str2, z, exceptionInterceptor);
        } catch (UnsupportedEncodingException unused) {
            throw SQLError.createSQLException(Messages.getString("StringUtils.0") + str + Messages.getString("StringUtils.1"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
        }
    }

    public static byte[] getBytes(String str, SingleByteCharsetConverter singleByteCharsetConverter, String str2, String str3, boolean z, ExceptionInterceptor exceptionInterceptor) throws SQLException {
        byte[] bArrEscapeEasternUnicodeByteStream;
        try {
            if (singleByteCharsetConverter != null) {
                bArrEscapeEasternUnicodeByteStream = singleByteCharsetConverter.toBytes(str);
            } else if (str2 == null) {
                bArrEscapeEasternUnicodeByteStream = getBytes(str);
            } else {
                byte[] bytes = getBytes(str, str2);
                bArrEscapeEasternUnicodeByteStream = (z || !CharsetMapping.requiresEscapeEasternUnicode(str2) || str2.equalsIgnoreCase(str3)) ? bytes : escapeEasternUnicodeByteStream(bytes, str);
            }
            return bArrEscapeEasternUnicodeByteStream;
        } catch (UnsupportedEncodingException unused) {
            throw SQLError.createSQLException(Messages.getString("StringUtils.5") + str2 + Messages.getString("StringUtils.6"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
        }
    }

    public static byte[] getBytes(String str, SingleByteCharsetConverter singleByteCharsetConverter, String str2, String str3, int i, int i2, boolean z, ExceptionInterceptor exceptionInterceptor) throws SQLException {
        byte[] bArrEscapeEasternUnicodeByteStream;
        try {
            if (singleByteCharsetConverter != null) {
                bArrEscapeEasternUnicodeByteStream = singleByteCharsetConverter.toBytes(str, i, i2);
            } else if (str2 == null) {
                bArrEscapeEasternUnicodeByteStream = getBytes(str, i, i2);
            } else {
                String strSubstring = str.substring(i, i2 + i);
                byte[] bytes = getBytes(strSubstring, str2);
                bArrEscapeEasternUnicodeByteStream = (z || !CharsetMapping.requiresEscapeEasternUnicode(str2) || str2.equalsIgnoreCase(str3)) ? bytes : escapeEasternUnicodeByteStream(bytes, strSubstring);
            }
            return bArrEscapeEasternUnicodeByteStream;
        } catch (UnsupportedEncodingException unused) {
            throw SQLError.createSQLException(Messages.getString("StringUtils.5") + str2 + Messages.getString("StringUtils.6"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
        }
    }

    public static int indexOfIgnoreCase(int i, String str, String str2, String str3, String str4, Set<SearchMode> set) {
        return indexOfIgnoreCase(i, str, str2, str3, str4, BuildConfig.FLAVOR, set);
    }

    public static int indexOfIgnoreCase(int i, String str, String str2, String str3, String str4, String str5, Set<SearchMode> set) {
        Set<SearchMode> setCopyOf = set;
        if (str != null && str2 != null) {
            int length = str.length();
            int length2 = str2.length();
            int i2 = length - length2;
            if (i <= i2 && length2 != 0) {
                if (setCopyOf.contains(SearchMode.SKIP_BETWEEN_MARKERS)) {
                    if (str3 == null || str4 == null || str3.length() != str4.length()) {
                        throw new IllegalArgumentException(Messages.getString("StringUtils.15", new String[]{str3, str4}));
                    }
                    if (str5 != null) {
                        for (char c : str5.toCharArray()) {
                            if (str3.indexOf(c) == -1) {
                                throw new IllegalArgumentException(Messages.getString("StringUtils.16", new String[]{str5, str3}));
                            }
                        }
                    } else {
                        throw new IllegalArgumentException(Messages.getString("StringUtils.16", new String[]{str5, str3}));
                    }
                }
                char upperCase = Character.toUpperCase(str2.charAt(0));
                char lowerCase = Character.toLowerCase(str2.charAt(0));
                if (Character.isWhitespace(lowerCase)) {
                    SearchMode searchMode = SearchMode.SKIP_WHITE_SPACE;
                    if (setCopyOf.contains(searchMode)) {
                        setCopyOf = EnumSet.copyOf((Collection) set);
                        setCopyOf.remove(searchMode);
                    }
                }
                Set<SearchMode> set2 = setCopyOf;
                int i3 = i;
                while (i3 <= i2) {
                    int iIndexOfNextChar = indexOfNextChar(i3, i2, str, str3, str4, str5, set2);
                    if (iIndexOfNextChar == -1) {
                        return -1;
                    }
                    if (isCharEqualIgnoreCase(str.charAt(iIndexOfNextChar), upperCase, lowerCase) && startsWithIgnoreCase(str, iIndexOfNextChar, str2)) {
                        return iIndexOfNextChar;
                    }
                    i3 = iIndexOfNextChar + 1;
                }
            }
        }
        return -1;
    }

    public static byte[] getBytes(String str, String str2, String str3, boolean z, MySQLConnection mySQLConnection, ExceptionInterceptor exceptionInterceptor) throws SQLException {
        try {
            return getBytes(str, mySQLConnection != null ? mySQLConnection.getCharsetConverter(str2) : SingleByteCharsetConverter.getInstance(str2, null), str2, str3, z, exceptionInterceptor);
        } catch (UnsupportedEncodingException unused) {
            throw SQLError.createSQLException(Messages.getString("StringUtils.5") + str2 + Messages.getString("StringUtils.6"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
        }
    }

    public static final byte[] getBytes(String str, String str2, String str3, int i, int i2, boolean z, MySQLConnection mySQLConnection, ExceptionInterceptor exceptionInterceptor) throws SQLException {
        try {
            return getBytes(str, mySQLConnection != null ? mySQLConnection.getCharsetConverter(str2) : SingleByteCharsetConverter.getInstance(str2, null), str2, str3, i, i2, z, exceptionInterceptor);
        } catch (UnsupportedEncodingException unused) {
            throw SQLError.createSQLException(Messages.getString("StringUtils.5") + str2 + Messages.getString("StringUtils.6"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
        }
    }

    public static byte[] getBytes(char[] cArr) {
        try {
            return getBytes(cArr, 0, cArr.length, platformEncoding);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static byte[] getBytes(char[] cArr, int i, int i2) {
        try {
            return getBytes(cArr, i, i2, platformEncoding);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static byte[] getBytes(char[] cArr, String str) throws UnsupportedEncodingException {
        return getBytes(cArr, 0, cArr.length, str);
    }

    public static byte[] getBytes(char[] cArr, int i, int i2, String str) throws UnsupportedEncodingException {
        ByteBuffer byteBufferEncode = findCharset(str).encode(CharBuffer.wrap(cArr, i, i2));
        int iLimit = byteBufferEncode.limit();
        byte[] bArr = new byte[iLimit];
        byteBufferEncode.get(bArr, 0, iLimit);
        return bArr;
    }

    public static byte[] getBytes(String str) {
        try {
            return getBytes(str, 0, str.length(), platformEncoding);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static byte[] getBytes(String str, int i, int i2) {
        try {
            return getBytes(str, i, i2, platformEncoding);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static byte[] getBytes(String str, String str2) throws UnsupportedEncodingException {
        return getBytes(str, 0, str.length(), str2);
    }

    public static byte[] getBytes(String str, int i, int i2, String str2) throws UnsupportedEncodingException {
        if (!Util.isJdbc4()) {
            if (i == 0 && i2 == str.length()) {
                return str.getBytes(str2);
            }
            return str.substring(i, i2 + i).getBytes(str2);
        }
        ByteBuffer byteBufferEncode = findCharset(str2).encode(CharBuffer.wrap(str.toCharArray(), i, i2));
        int iLimit = byteBufferEncode.limit();
        byte[] bArr = new byte[iLimit];
        byteBufferEncode.get(bArr, 0, iLimit);
        return bArr;
    }
}
