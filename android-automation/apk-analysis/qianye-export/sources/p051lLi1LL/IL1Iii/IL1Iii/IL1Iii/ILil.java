package p051lLi1LL.IL1Iii.IL1Iii.IL1Iii;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Objects;

/* JADX INFO: compiled from: FileUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final BigInteger f5477I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final BigInteger f5478IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final BigInteger f5479ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static final BigInteger f5480Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static final BigInteger f3002IL;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static final BigInteger f3003lLi1LL;

    static {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(1024L);
        f5478IL1Iii = bigIntegerValueOf;
        BigInteger bigIntegerMultiply = bigIntegerValueOf.multiply(bigIntegerValueOf);
        f5479ILil = bigIntegerMultiply;
        BigInteger bigIntegerMultiply2 = bigIntegerValueOf.multiply(bigIntegerMultiply);
        f5477I1I = bigIntegerMultiply2;
        BigInteger bigIntegerMultiply3 = bigIntegerValueOf.multiply(bigIntegerMultiply2);
        f3002IL = bigIntegerMultiply3;
        BigInteger bigIntegerMultiply4 = bigIntegerValueOf.multiply(bigIntegerMultiply3);
        f5480Ilil = bigIntegerMultiply4;
        bigIntegerValueOf.multiply(bigIntegerMultiply4);
        BigInteger bigIntegerMultiply5 = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(1152921504606846976L));
        f3003lLi1LL = bigIntegerMultiply5;
        bigIntegerValueOf.multiply(bigIntegerMultiply5);
    }

    public static void I1I(File file, File file2, boolean z) throws IOException {
        IL1Iii(file, file2);
        if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is a directory");
        }
        if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
            throw new IOException("Destination '" + parentFile + "' directory cannot be created");
        }
        if (!file2.exists() || file2.canWrite()) {
            m3601IL(file, file2, z);
            return;
        }
        throw new IOException("Destination '" + file2 + "' exists but is read-only");
    }

    public static void IL1Iii(File file, File file2) throws FileNotFoundException {
        Objects.requireNonNull(file, "Source must not be null");
        Objects.requireNonNull(file2, "Destination must not be null");
        if (file.exists()) {
            return;
        }
        throw new FileNotFoundException("Source '" + file + "' does not exist");
    }

    public static void ILL(File file, String str, Charset charset, boolean z) throws IOException {
        FileOutputStream fileOutputStreamM3605lLi1LL = m3605lLi1LL(file, z);
        try {
            I1I.m3600lLi1LL(str, fileOutputStreamM3605lLi1LL, charset);
            if (fileOutputStreamM3605lLi1LL != null) {
                fileOutputStreamM3605lLi1LL.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (fileOutputStreamM3605lLi1LL != null) {
                    try {
                        fileOutputStreamM3605lLi1LL.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static void ILil(File file, File file2) throws IOException {
        I1I(file, file2, true);
    }

    public static FileInputStream Ilil(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        }
        if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        }
        if (file.canRead()) {
            return new FileInputStream(file);
        }
        throw new IOException("File '" + file + "' cannot be read");
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static void m3601IL(File file, File file2, boolean z) throws IOException {
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileChannel channel = fileInputStream.getChannel();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    FileChannel channel2 = fileOutputStream.getChannel();
                    try {
                        long size = channel.size();
                        long j = 0;
                        while (j < size) {
                            long j2 = size - j;
                            long jTransferFrom = channel2.transferFrom(channel, j, j2 > 31457280 ? 31457280L : j2);
                            if (jTransferFrom == 0) {
                                break;
                            } else {
                                j += jTransferFrom;
                            }
                        }
                        if (channel2 != null) {
                            channel2.close();
                        }
                        fileOutputStream.close();
                        if (channel != null) {
                            channel.close();
                        }
                        fileInputStream.close();
                        long length = file.length();
                        long length2 = file2.length();
                        if (length == length2) {
                            if (z) {
                                file2.setLastModified(file.lastModified());
                                return;
                            }
                            return;
                        }
                        throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + length + " Actual: " + length2);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (channel2 == null) {
                                throw th2;
                            }
                            try {
                                channel2.close();
                                throw th2;
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                                throw th2;
                            }
                            try {
                                throw th;
                            } catch (Throwable th4) {
                                if (channel == null) {
                                    throw th4;
                                }
                                try {
                                    channel.close();
                                    throw th4;
                                } catch (Throwable th5) {
                                    th.addSuppressed(th5);
                                    throw th4;
                                }
                            }
                        }
                    }
                } catch (Throwable th6) {
                    try {
                        throw th6;
                    } catch (Throwable th7) {
                        try {
                            fileOutputStream.close();
                            throw th7;
                        } catch (Throwable th8) {
                            th6.addSuppressed(th8);
                            throw th7;
                        }
                    }
                }
            } catch (Throwable th9) {
                throw th9;
            }
        } catch (Throwable th10) {
            try {
                throw th10;
            } catch (Throwable th11) {
                try {
                    fileInputStream.close();
                    throw th11;
                } catch (Throwable th12) {
                    th10.addSuppressed(th12);
                    throw th11;
                }
            }
        }
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static String m3602IiL(File file, String str) throws IOException {
        return m3603L11I(file, IL1Iii.IL1Iii(str));
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static String m3603L11I(File file, Charset charset) throws IOException {
        FileInputStream fileInputStreamIlil = Ilil(file);
        try {
            String strIlil = I1I.Ilil(fileInputStreamIlil, IL1Iii.ILil(charset));
            if (fileInputStreamIlil != null) {
                fileInputStreamIlil.close();
            }
            return strIlil;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (fileInputStreamIlil != null) {
                    try {
                        fileInputStreamIlil.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Deprecated
    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static String m3604iILLL1(File file) throws IOException {
        return m3603L11I(file, Charset.defaultCharset());
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static FileOutputStream m3605lLi1LL(File file, boolean z) throws IOException {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Directory '" + parentFile + "' could not be created");
            }
        } else {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (!file.canWrite()) {
                throw new IOException("File '" + file + "' cannot be written to");
            }
        }
        return new FileOutputStream(file, z);
    }

    @Deprecated
    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static void m3606il(File file, String str) throws IOException {
        ILL(file, str, Charset.defaultCharset(), false);
    }
}
