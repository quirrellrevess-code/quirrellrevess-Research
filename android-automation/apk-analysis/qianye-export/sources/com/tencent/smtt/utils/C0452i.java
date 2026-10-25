package com.tencent.smtt.utils;

import com.mysql.jdbc.StatementImpl;
import com.tencent.smtt.sdk.stat.C0428a;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.Security;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;

/* JADX INFO: renamed from: com.tencent.smtt.utils.i */
/* JADX INFO: loaded from: classes.dex */
public class C0452i {

    /* JADX INFO: renamed from: a */
    private static final char[] f807a = "0123456789abcdef".toCharArray();

    /* JADX INFO: renamed from: b */
    private static C0452i f808b;

    /* JADX INFO: renamed from: c */
    private String f809c;

    /* JADX INFO: renamed from: d */
    private String f810d;

    /* JADX INFO: renamed from: e */
    private String f811e;

    private C0452i() {
        int iNextInt = new Random().nextInt(89999999) + 10000000;
        int iNextInt2 = new Random().nextInt(89999999) + 10000000;
        this.f811e = String.valueOf(iNextInt);
        this.f809c = this.f811e + String.valueOf(iNextInt2);
    }

    /* JADX INFO: renamed from: a */
    public static synchronized C0452i m756a() {
        if (f808b == null) {
            f808b = new C0452i();
        }
        return f808b;
    }

    /* JADX INFO: renamed from: b */
    private String m757b(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & StatementImpl.USES_VARIABLES_UNKNOWN;
            int i3 = i * 2;
            char[] cArr2 = f807a;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    /* JADX INFO: renamed from: a */
    public byte[] m758a(byte[] bArr) throws Exception {
        return C0428a.m508a(this.f811e.getBytes(), bArr, 1);
    }

    /* JADX INFO: renamed from: b */
    public void m759b() throws Exception {
        Security.addProvider((Provider) Class.forName("com.android.org.bouncycastle.jce.provider.BouncyCastleProvider", true, ClassLoader.getSystemClassLoader()).newInstance());
    }

    /* JADX INFO: renamed from: c */
    public String m760c() throws Exception {
        if (this.f810d == null) {
            byte[] bytes = this.f809c.getBytes();
            Cipher cipher = null;
            try {
                try {
                    cipher = Cipher.getInstance("RSA/ECB/NoPadding");
                } catch (Exception unused) {
                    m759b();
                    cipher = Cipher.getInstance("RSA/ECB/NoPadding");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            cipher.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(android.util.Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0))));
            this.f810d = m757b(cipher.doFinal(bytes));
        }
        return this.f810d;
    }
}
