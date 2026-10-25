package com.tencent.smtt.utils;

import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

/* JADX INFO: renamed from: com.tencent.smtt.utils.g */
/* JADX INFO: loaded from: classes.dex */
public class C0450g {

    /* JADX INFO: renamed from: com.tencent.smtt.utils.g$a */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo200a(int i);
    }

    /* JADX INFO: renamed from: a */
    public static String m740a(String str, byte[] bArr, a aVar, boolean z) {
        String str2;
        try {
            String str3 = str + (z ? C0452i.m756a().m760c() : C0451h.m745a().m753b());
            try {
                bArr = z ? C0452i.m756a().m758a(bArr) : C0451h.m745a().m752a(bArr);
            } catch (Exception e) {
                e.printStackTrace();
                TbsLog.m662e("HttpUtils", "rsaKey exception #2: " + e);
            }
            if (bArr == null) {
                str2 = "postData is null";
                TbsLog.m662e("HttpUtils", str2);
                return null;
            }
            HashMap map = new HashMap();
            map.put("Content-Type", "application/x-www-form-urlencoded");
            map.put("Content-Length", String.valueOf(bArr.length));
            HttpURLConnection httpURLConnectionM742a = m742a(str3, map);
            if (httpURLConnectionM742a == null) {
                return null;
            }
            m744a(httpURLConnectionM742a, bArr);
            return m741a(httpURLConnectionM742a, aVar, z);
        } catch (Exception e2) {
            e2.printStackTrace();
            str2 = "rsaKey exception #1: " + e2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x004d A[Catch: all -> 0x0075, LOOP:0: B:22:0x0046->B:24:0x004d, LOOP_END, TryCatch #1 {all -> 0x0075, blocks: (B:21:0x0044, B:22:0x0046, B:24:0x004d, B:26:0x0054, B:28:0x0063), top: B:46:0x0044 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x0054 A[Catch: all -> 0x0075, TryCatch #1 {all -> 0x0075, blocks: (B:21:0x0044, B:22:0x0046, B:24:0x004d, B:26:0x0054, B:28:0x0063), top: B:46:0x0044 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0063 A[Catch: all -> 0x0075, TRY_LEAVE, TryCatch #1 {all -> 0x0075, blocks: (B:21:0x0044, B:22:0x0046, B:24:0x004d, B:26:0x0054, B:28:0x0063), top: B:46:0x0044 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0052 A[EDGE_INSN: B:50:0x0052->B:25:0x0052 BREAK  A[LOOP:0: B:22:0x0046->B:24:0x004d], SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    private static String m741a(HttpURLConnection httpURLConnection, a aVar, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        String str;
        InputStream inflaterInputStream;
        byte[] bArr;
        int i;
        String str2;
        InputStream inputStream = null;
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (aVar != null) {
                aVar.mo200a(responseCode);
            }
            if (responseCode == 200) {
                InputStream inputStream2 = httpURLConnection.getInputStream();
                String contentEncoding = httpURLConnection.getContentEncoding();
                try {
                    try {
                        if (contentEncoding == null || !contentEncoding.equalsIgnoreCase("gzip")) {
                            if (contentEncoding == null || !contentEncoding.equalsIgnoreCase("deflate")) {
                                byteArrayOutputStream2 = new ByteArrayOutputStream();
                                bArr = new byte[128];
                                while (true) {
                                    i = inputStream2.read(bArr);
                                    if (i != -1) {
                                        break;
                                    }
                                    byteArrayOutputStream2.write(bArr, 0, i);
                                }
                                if (z) {
                                    str2 = new String(byteArrayOutputStream2.toByteArray(), "utf-8");
                                } else {
                                    str2 = new String(C0451h.m745a().m754c(byteArrayOutputStream2.toByteArray()));
                                }
                                String str3 = str2;
                                inputStream = inputStream2;
                                str = str3;
                            } else {
                                inflaterInputStream = new InflaterInputStream(inputStream2, new Inflater(true));
                            }
                            try {
                                th.printStackTrace();
                                TbsLog.m662e("HttpUtil", "httpPost exception: " + th);
                                return "[HttpError] " + th.getMessage();
                            } finally {
                                m743a(inputStream);
                                m743a(byteArrayOutputStream);
                            }
                        }
                        inflaterInputStream = new GZIPInputStream(inputStream2);
                        bArr = new byte[128];
                        while (true) {
                            i = inputStream2.read(bArr);
                            if (i != -1) {
                                break;
                                break;
                            }
                            byteArrayOutputStream2.write(bArr, 0, i);
                        }
                        if (z) {
                            str2 = new String(byteArrayOutputStream2.toByteArray(), "utf-8");
                        } else {
                            str2 = new String(C0451h.m745a().m754c(byteArrayOutputStream2.toByteArray()));
                        }
                        String str4 = str2;
                        inputStream = inputStream2;
                        str = str4;
                    } catch (Throwable th) {
                        inputStream = inputStream2;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        th = th;
                    }
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStream2;
                    byteArrayOutputStream = null;
                }
                inputStream2 = inflaterInputStream;
            } else {
                byteArrayOutputStream2 = null;
                str = null;
            }
            m743a(inputStream);
            m743a(byteArrayOutputStream2);
            return str;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static HttpURLConnection m742a(String str, Map<String, String> map) {
        String str2;
        String str3;
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setConnectTimeout(20000);
                if (Build.VERSION.SDK_INT > 13) {
                    str2 = "Connection";
                    str3 = "close";
                } else {
                    str2 = "http.keepAlive";
                    str3 = "false";
                }
                httpURLConnection2.setRequestProperty(str2, str3);
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                }
                return httpURLConnection2;
            } catch (Exception e) {
                e = e;
                httpURLConnection = httpURLConnection2;
                TbsLog.m662e("HttpUtil", "initHttpPostURLConnection exception: " + e);
                return httpURLConnection;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m743a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m744a(HttpURLConnection httpURLConnection, byte[] bArr) {
        OutputStream outputStream = null;
        try {
            try {
                outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.flush();
            } catch (Exception e) {
                TbsLog.m662e("HttpUtil", "writePostData exception: " + e);
            }
        } finally {
            m743a(outputStream);
        }
    }
}
