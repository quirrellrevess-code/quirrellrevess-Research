package com.tencent.smtt.sdk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: renamed from: com.tencent.smtt.sdk.a */
/* JADX INFO: loaded from: classes.dex */
public class C0407a {

    /* JADX INFO: renamed from: a */
    public static int f503a = 600;

    /* JADX INFO: renamed from: b */
    private static int f504b;

    /* JADX INFO: renamed from: a */
    public static int m314a() {
        String line;
        int i = f504b;
        if (i > 0) {
            return i;
        }
        BufferedReader bufferedReader = null;
        bufferedReader = null;
        bufferedReader = null;
        int i2 = 0;
        try {
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
                    while (true) {
                        try {
                            line = bufferedReader2.readLine();
                            if (line == null) {
                                break;
                            }
                            int iIndexOf = line.indexOf("MemTotal:");
                            if (-1 != iIndexOf) {
                                line = line.substring(iIndexOf + 9).trim();
                                if (line != null && line.length() != 0 && line.contains("k")) {
                                    i2 = Integer.parseInt(line.substring(0, line.indexOf("k")).trim()) / 1024;
                                    break;
                                }
                                break;
                                break;
                                break;
                            }
                        } catch (IOException e) {
                            e = e;
                            bufferedReader = bufferedReader2;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                                bufferedReader = bufferedReader;
                            }
                            f504b = i2;
                            return i2;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            th.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                                bufferedReader = bufferedReader;
                            }
                            f504b = i2;
                            return i2;
                        }
                    }
                    bufferedReader2.close();
                    bufferedReader = line;
                } catch (IOException e2) {
                    e = e2;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            f504b = i2;
            return i2;
        } catch (Throwable th3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th3;
        }
    }
}
