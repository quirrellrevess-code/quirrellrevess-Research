package com.mysql.jdbc;

import java.io.UnsupportedEncodingException;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public class Security {
    private static int CACHING_SHA2_DIGEST_LENGTH = 32;
    private static final char PVERSION41_CHAR = '*';
    private static final int SHA1_HASH_SIZE = 20;

    private Security() {
    }

    private static int charVal(char c) {
        if (c < '0' || c > '9') {
            return ((c < 'A' || c > 'Z') ? c - 'a' : c - 'A') + 10;
        }
        return c - '0';
    }

    public static byte[] createKeyFromOldPassword(String str) throws NoSuchAlgorithmException {
        return getBinaryPassword(getSaltFromPassword(makeScrambledPassword(str)), false);
    }

    public static byte[] getBinaryPassword(int[] iArr, boolean z) throws NoSuchAlgorithmException {
        byte[] bArr = new byte[20];
        if (z) {
            int i = 0;
            for (int i2 = 0; i2 < 4; i2++) {
                int i3 = iArr[i2];
                int i4 = 3;
                while (i4 >= 0) {
                    bArr[i] = (byte) (i3 & 255);
                    i3 >>= 8;
                    i4--;
                    i++;
                }
            }
            return bArr;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < 2; i6++) {
            int i7 = iArr[i6];
            for (int i8 = 3; i8 >= 0; i8--) {
                bArr[i8 + i5] = (byte) (i7 % 256);
                i7 >>= 8;
            }
            i5 += 4;
        }
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        messageDigest.update(bArr, 0, 8);
        return messageDigest.digest();
    }

    private static int[] getSaltFromPassword(String str) {
        int[] iArr = new int[6];
        if (str != null && str.length() != 0) {
            if (str.charAt(0) == '*') {
                String strSubstring = str.substring(1, 5);
                for (int i = 0; i < 4; i++) {
                    charVal(strSubstring.charAt(i));
                }
                return iArr;
            }
            int length = str.length();
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int i4 = 0;
                int iCharVal = 0;
                while (i4 < 8) {
                    iCharVal = (iCharVal << 4) + charVal(str.charAt(i2));
                    i4++;
                    i2++;
                }
                iArr[i3] = iCharVal;
                i3++;
            }
        }
        return iArr;
    }

    private static String longToHex(long j) {
        String hexString = Long.toHexString(j);
        int length = hexString.length();
        if (length >= 8) {
            return hexString.substring(0, 8);
        }
        int i = 8 - length;
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("0");
        }
        sb.append(hexString);
        return sb.toString();
    }

    public static String makeScrambledPassword(String str) throws NoSuchAlgorithmException {
        long[] jArrHashPre41Password = Util.hashPre41Password(str);
        return longToHex(jArrHashPre41Password[0]) + longToHex(jArrHashPre41Password[1]);
    }

    public static byte[] passwordHashStage1(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != ' ' && cCharAt != '\t') {
                sb.append(cCharAt);
            }
        }
        return messageDigest.digest(StringUtils.getBytes(sb.toString()));
    }

    public static byte[] passwordHashStage2(byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        messageDigest.update(bArr2, 0, 4);
        messageDigest.update(bArr, 0, 20);
        return messageDigest.digest();
    }

    public static byte[] scramble411(String str, String str2, String str3) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        byte[] bArrDigest = messageDigest.digest((str3 == null || str3.length() == 0) ? StringUtils.getBytes(str) : StringUtils.getBytes(str, str3));
        messageDigest.reset();
        byte[] bArrDigest2 = messageDigest.digest(bArrDigest);
        messageDigest.reset();
        messageDigest.update(StringUtils.getBytes(str2, "ASCII"));
        messageDigest.update(bArrDigest2);
        byte[] bArrDigest3 = messageDigest.digest();
        int length = bArrDigest3.length;
        for (int i = 0; i < length; i++) {
            bArrDigest3[i] = (byte) (bArrDigest3[i] ^ bArrDigest[i]);
        }
        return bArrDigest3;
    }

    public static byte[] scrambleCachingSha2(byte[] bArr, byte[] bArr2) throws DigestException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            int i = CACHING_SHA2_DIGEST_LENGTH;
            byte[] bArr3 = new byte[i];
            byte[] bArr4 = new byte[i];
            byte[] bArr5 = new byte[i];
            messageDigest.update(bArr, 0, bArr.length);
            messageDigest.digest(bArr3, 0, CACHING_SHA2_DIGEST_LENGTH);
            messageDigest.reset();
            messageDigest.update(bArr3, 0, i);
            messageDigest.digest(bArr4, 0, CACHING_SHA2_DIGEST_LENGTH);
            messageDigest.reset();
            messageDigest.update(bArr4, 0, i);
            messageDigest.update(bArr2, 0, bArr2.length);
            messageDigest.digest(bArr5, 0, CACHING_SHA2_DIGEST_LENGTH);
            int i2 = CACHING_SHA2_DIGEST_LENGTH;
            byte[] bArr6 = new byte[i2];
            xorString(bArr3, bArr6, bArr5, i2);
            return bArr6;
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionFailedException(e);
        }
    }

    public static void xorString(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        int length = bArr3.length;
        for (int i2 = 0; i2 < i; i2++) {
            bArr2[i2] = (byte) (bArr[i2] ^ bArr3[i2 % length]);
        }
    }
}
