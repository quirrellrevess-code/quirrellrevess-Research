package com.tencent.smtt.sdk;

import android.content.Context;
import com.google.android.flexbox.BuildConfig;
import com.tencent.smtt.utils.C0446c;
import java.io.IOException;
import java.util.UnknownFormatConversionException;

/* JADX INFO: renamed from: com.tencent.smtt.sdk.d */
/* JADX INFO: loaded from: classes.dex */
public class C0410d {

    /* JADX INFO: renamed from: a */
    public static int f507a = 5;

    /* JADX INFO: renamed from: b */
    public static int f508b = 16;

    /* JADX INFO: renamed from: c */
    public static char[] f509c = new char[16];

    /* JADX INFO: renamed from: d */
    public static String f510d = "dex2oat-cmdline";

    /* JADX INFO: renamed from: e */
    public static long f511e = 4096;

    /* JADX INFO: renamed from: a */
    public static String m315a(Context context, String str) throws Exception {
        C0446c c0446c = new C0446c(str);
        c0446c.m709a(f509c);
        c0446c.m712a(f509c[f507a] == 1);
        c0446c.m711a(f511e);
        return m316a(new String(m317a(c0446c)));
    }

    /* JADX INFO: renamed from: a */
    private static String m316a(String str) {
        String[] strArrSplit = str.split(new String("\u0000"));
        int i = 0;
        while (i < strArrSplit.length) {
            int i2 = i + 1;
            String str2 = strArrSplit[i];
            int i3 = i2 + 1;
            String str3 = strArrSplit[i2];
            if (str2.equals(f510d)) {
                return str3;
            }
            i = i3;
        }
        return BuildConfig.FLAVOR;
    }

    /* JADX INFO: renamed from: a */
    public static char[] m317a(C0446c c0446c) throws IOException {
        char[] cArr = new char[4];
        char[] cArr2 = new char[4];
        c0446c.m709a(cArr);
        if (cArr[0] != 'o' || cArr[1] != 'a' || cArr[2] != 't') {
            throw new UnknownFormatConversionException(String.format("Invalid art magic %c%c%c", Character.valueOf(cArr[0]), Character.valueOf(cArr[1]), Character.valueOf(cArr[2])));
        }
        c0446c.m709a(cArr2);
        c0446c.m713b();
        c0446c.m713b();
        c0446c.m713b();
        c0446c.m713b();
        c0446c.m713b();
        c0446c.m713b();
        c0446c.m713b();
        c0446c.m713b();
        if (cArr2[1] <= '4') {
            c0446c.m713b();
            c0446c.m713b();
            c0446c.m713b();
        }
        c0446c.m713b();
        c0446c.m713b();
        c0446c.m713b();
        c0446c.m713b();
        c0446c.m713b();
        c0446c.m713b();
        c0446c.m713b();
        char[] cArr3 = new char[c0446c.m713b()];
        c0446c.m709a(cArr3);
        return cArr3;
    }
}
