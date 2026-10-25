package com.tencent.smtt.utils;

import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.StatementImpl;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

/* JADX INFO: renamed from: com.tencent.smtt.utils.h */
/* JADX INFO: loaded from: classes.dex */
public class C0451h {

    /* JADX INFO: renamed from: b */
    private static String f801b = "";

    /* JADX INFO: renamed from: c */
    private static byte[] f802c;

    /* JADX INFO: renamed from: g */
    private static String f804g;

    /* JADX INFO: renamed from: d */
    private Cipher f805d;

    /* JADX INFO: renamed from: e */
    private Cipher f806e;

    /* JADX INFO: renamed from: a */
    public static final char[] f800a = "0123456789abcdef".toCharArray();

    /* JADX INFO: renamed from: f */
    private static C0451h f803f = null;

    private C0451h() throws Exception {
        this.f805d = null;
        this.f806e = null;
        f804g = String.valueOf(new Random().nextInt(89999999) + 10000000) + String.valueOf(new Random().nextInt(89999999) + 10000000) + String.valueOf(new Random().nextInt(89999999) + 10000000);
        String str = "00000000";
        for (int i = 0; i < 12; i++) {
            str = str + String.valueOf(new Random().nextInt(89999999) + 10000000);
        }
        f802c = (str + f804g).getBytes();
        this.f805d = Cipher.getInstance("RSA/ECB/NoPadding");
        this.f805d.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(android.util.Base64.decode((m750d() + m751e()).getBytes(), 0))));
        f801b = m747b(this.f805d.doFinal(f802c));
        SecretKey secretKeyGenerateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(f804g.getBytes()));
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        this.f806e = cipher;
        cipher.init(1, secretKeyGenerateSecret);
    }

    /* JADX INFO: renamed from: a */
    public static C0451h m745a() {
        try {
            if (f803f == null) {
                f803f = new C0451h();
            }
            return f803f;
        } catch (Exception e) {
            f803f = null;
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m746a(byte[] bArr, String str) throws Exception {
        SecretKey secretKeyGenerateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(str.getBytes()));
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(1, secretKeyGenerateSecret);
        return cipher.doFinal(bArr);
    }

    /* JADX INFO: renamed from: b */
    public static String m747b(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & StatementImpl.USES_VARIABLES_UNKNOWN;
            int i3 = i * 2;
            char[] cArr2 = f800a;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    /* JADX INFO: renamed from: b */
    public static byte[] m748b(byte[] bArr, String str) {
        try {
            SecretKey secretKeyGenerateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(str.getBytes()));
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(2, secretKeyGenerateSecret);
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    public static String m749c() {
        return f804g;
    }

    /* JADX INFO: renamed from: d */
    private String m750d() {
        return "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcEQ3TCNWPBqgIiY7WQ/IqTOTTV2w8aZ/GPm68FK0";
    }

    /* JADX INFO: renamed from: e */
    private String m751e() {
        return "fAJBemZKtYR3Li46VJ+Hwnor7ZpQnblGWPFaLv5JoPqvavgB0GInuhm+T+syPs1mw0uPLWaqwvZsCfoaIvUuxy5xHJgmWARrK4/9pHyDxRlZte0PCIoR1ko5B8lVVH1X1dQIDAQAB";
    }

    /* JADX INFO: renamed from: a */
    public byte[] m752a(byte[] bArr) throws Exception {
        return this.f806e.doFinal(bArr);
    }

    /* JADX INFO: renamed from: b */
    public String m753b() {
        return f801b;
    }

    /* JADX INFO: renamed from: c */
    public byte[] m754c(byte[] bArr) {
        TbsLog.m665i("Post3DESEncryption", "DesDecrypt deskeys is " + f804g);
        try {
            SecretKey secretKeyGenerateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(f804g.getBytes()));
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(2, secretKeyGenerateSecret);
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            try {
                TbsLog.m665i("Post3DESEncryption", "DesDecrypt exception,  content is " + m755d(bArr));
            } catch (Throwable unused) {
            }
            TbsLog.m668i(e);
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    public String m755d(byte[] bArr) {
        StringBuilder sb = new StringBuilder(BuildConfig.FLAVOR);
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & StatementImpl.USES_VARIABLES_UNKNOWN;
            sb.append("0x");
            String hexString = Integer.toHexString(i2);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
            if (i != bArr.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
