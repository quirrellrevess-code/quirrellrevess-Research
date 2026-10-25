package p051lLi1LL.IL1Iii.IL1Iii.IL1Iii;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import p051lLi1LL.IL1Iii.IL1Iii.IL1Iii.p059IL.IL1Iii;

/* JADX INFO: compiled from: IOUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class I1I {
    static {
        char c = File.separatorChar;
        IL1Iii iL1Iii = new IL1Iii(4);
        try {
            PrintWriter printWriter = new PrintWriter(iL1Iii);
            try {
                printWriter.println();
                iL1Iii.toString();
                printWriter.close();
                iL1Iii.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        printWriter.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                try {
                    iL1Iii.close();
                } catch (Throwable th6) {
                    th4.addSuppressed(th6);
                }
                throw th5;
            }
        }
    }

    public static long I1I(Reader reader, Writer writer) throws IOException {
        return m3599IL(reader, writer, new char[4096]);
    }

    public static int IL1Iii(Reader reader, Writer writer) throws IOException {
        long jI1I = I1I(reader, writer);
        if (jI1I > 2147483647L) {
            return -1;
        }
        return (int) jI1I;
    }

    public static void ILil(InputStream inputStream, Writer writer, Charset charset) throws IOException {
        IL1Iii(new InputStreamReader(inputStream, IL1Iii.ILil(charset)), writer);
    }

    public static String Ilil(InputStream inputStream, Charset charset) throws IOException {
        IL1Iii iL1Iii = new IL1Iii();
        try {
            ILil(inputStream, iL1Iii, charset);
            String string = iL1Iii.toString();
            iL1Iii.close();
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    iL1Iii.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static long m3599IL(Reader reader, Writer writer, char[] cArr) throws IOException {
        long j = 0;
        while (true) {
            int i = reader.read(cArr);
            if (-1 == i) {
                return j;
            }
            writer.write(cArr, 0, i);
            j += (long) i;
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static void m3600lLi1LL(String str, OutputStream outputStream, Charset charset) throws IOException {
        if (str != null) {
            outputStream.write(str.getBytes(IL1Iii.ILil(charset)));
        }
    }
}
