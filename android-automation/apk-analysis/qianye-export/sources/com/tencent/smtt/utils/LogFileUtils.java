package com.tencent.smtt.utils;

import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class LogFileUtils {

    /* JADX INFO: renamed from: a */
    private static OutputStream f688a;

    public static void closeOutputStream(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                Log.e("LOG_FILE", "Couldn't close stream!", e);
            }
        }
    }

    public static byte[] createHeaderText(String str, String str2) {
        try {
            byte[] bArrEncryptKey = encryptKey(str, str2);
            String str3 = String.format("%03d", Integer.valueOf(bArrEncryptKey.length));
            byte[] bArr = new byte[bArrEncryptKey.length + 3];
            bArr[0] = (byte) str3.charAt(0);
            bArr[1] = (byte) str3.charAt(1);
            bArr[2] = (byte) str3.charAt(2);
            System.arraycopy(bArrEncryptKey, 0, bArr, 3, bArrEncryptKey.length);
            return bArr;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String createKey() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static byte[] encrypt(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher cipher = Cipher.getInstance("RC4");
            cipher.init(1, new SecretKeySpec(str.getBytes("UTF-8"), "RC4"));
            return cipher.update(bytes);
        } catch (Throwable th) {
            Log.e("LOG_FILE", "encrypt exception:" + th.getMessage());
            return null;
        }
    }

    public static byte[] encryptKey(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher cipher = Cipher.getInstance("RC4");
            cipher.init(1, new SecretKeySpec(str.getBytes("UTF-8"), "RC4"));
            return cipher.update(bytes);
        } catch (Throwable th) {
            Log.e("LOG_FILE", "encrypt exception:" + th.getMessage());
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x006b A[EXC_TOP_SPLITTER, PHI: r6
  0x006b: PHI (r6v3 java.io.OutputStream) = (r6v2 java.io.OutputStream), (r6v7 java.io.OutputStream) binds: [B:27:0x0071, B:23:0x0069] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public static synchronized void writeDataToStorage(File file, String str, byte[] bArr, String str2, boolean z) {
        OutputStream outputStream;
        byte[] bArrEncrypt = encrypt(str, str2);
        if (bArrEncrypt != null) {
            str2 = null;
        } else {
            bArrEncrypt = null;
        }
        try {
            file.getParentFile().mkdirs();
            if (file.isFile() && file.exists() && file.length() > 2097152) {
                file.delete();
                file.createNewFile();
            }
            if (f688a == null) {
                f688a = new BufferedOutputStream(new FileOutputStream(file, z));
            }
            if (str2 != null) {
                f688a.write(str2.getBytes());
            } else {
                f688a.write(bArr);
                f688a.write(bArrEncrypt);
                f688a.write(new byte[]{10, 10});
            }
            outputStream = f688a;
            if (outputStream != null) {
                try {
                    outputStream.flush();
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
            outputStream = f688a;
            if (outputStream != null) {
                outputStream.flush();
            }
        }
    }
}
