package com.mysql.jdbc;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SingleByteCharsetConverter {
    private static final int BYTE_RANGE = 256;
    private char[] byteToChars = new char[256];
    private byte[] charToByteMap = new byte[65536];
    private static byte[] allBytes = new byte[256];
    private static final Map<String, SingleByteCharsetConverter> CONVERTER_MAP = new HashMap();
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static byte[] unknownCharsMap = new byte[65536];

    static {
        int i = 0;
        for (int i2 = -128; i2 <= 127; i2++) {
            allBytes[i2 + 128] = (byte) i2;
        }
        while (true) {
            byte[] bArr = unknownCharsMap;
            if (i >= bArr.length) {
                return;
            }
            bArr[i] = 63;
            i++;
        }
    }

    private SingleByteCharsetConverter(String str) throws UnsupportedEncodingException {
        String str2 = new String(allBytes, 0, 256, str);
        int length = str2.length();
        byte[] bArr = unknownCharsMap;
        byte[] bArr2 = this.charToByteMap;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        for (int i = 0; i < 256 && i < length; i++) {
            char cCharAt = str2.charAt(i);
            this.byteToChars[i] = cCharAt;
            this.charToByteMap[cCharAt] = allBytes[i];
        }
    }

    public static synchronized SingleByteCharsetConverter getInstance(String str, Connection connection) throws SQLException, UnsupportedEncodingException {
        SingleByteCharsetConverter singleByteCharsetConverterInitCharset;
        singleByteCharsetConverterInitCharset = CONVERTER_MAP.get(str);
        if (singleByteCharsetConverterInitCharset == null) {
            singleByteCharsetConverterInitCharset = initCharset(str);
        }
        return singleByteCharsetConverterInitCharset;
    }

    public static SingleByteCharsetConverter initCharset(String str) throws SQLException, UnsupportedEncodingException {
        try {
            if (CharsetMapping.isMultibyteCharset(str)) {
                return null;
            }
            SingleByteCharsetConverter singleByteCharsetConverter = new SingleByteCharsetConverter(str);
            CONVERTER_MAP.put(str, singleByteCharsetConverter);
            return singleByteCharsetConverter;
        } catch (RuntimeException e) {
            SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(e.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
            sQLExceptionCreateSQLException.initCause(e);
            throw sQLExceptionCreateSQLException;
        }
    }

    public static String toStringDefaultEncoding(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2);
    }

    public final byte[] toBytes(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        int length = cArr.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = this.charToByteMap[cArr[i]];
        }
        return bArr;
    }

    public final byte[] toBytesWrapped(char[] cArr, char c, char c2) {
        if (cArr == null) {
            return null;
        }
        int length = cArr.length + 2;
        int length2 = cArr.length;
        byte[] bArr = new byte[length];
        int i = 0;
        bArr[0] = this.charToByteMap[c];
        while (i < length2) {
            int i2 = i + 1;
            bArr[i2] = this.charToByteMap[cArr[i]];
            i = i2;
        }
        bArr[length - 1] = this.charToByteMap[c2];
        return bArr;
    }

    public final String toString(byte[] bArr) {
        return toString(bArr, 0, bArr.length);
    }

    public final String toString(byte[] bArr, int i, int i2) {
        char[] cArr = new char[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            cArr[i3] = this.byteToChars[bArr[i] + 128];
            i++;
        }
        return new String(cArr);
    }

    public final byte[] toBytes(char[] cArr, int i, int i2) {
        if (cArr == null) {
            return null;
        }
        if (i2 == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = this.charToByteMap[cArr[i3 + i]];
        }
        return bArr;
    }

    public final byte[] toBytes(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = this.charToByteMap[str.charAt(i)];
        }
        return bArr;
    }

    public final byte[] toBytesWrapped(String str, char c, char c2) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        int i = length + 2;
        byte[] bArr = new byte[i];
        int i2 = 0;
        bArr[0] = this.charToByteMap[c];
        while (i2 < length) {
            int i3 = i2 + 1;
            bArr[i3] = this.charToByteMap[str.charAt(i2)];
            i2 = i3;
        }
        bArr[i - 1] = this.charToByteMap[c2];
        return bArr;
    }

    public final byte[] toBytes(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        if (i2 == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = this.charToByteMap[str.charAt(i3 + i)];
        }
        return bArr;
    }
}
