package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.BuildConfig;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsLogReport;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.Enumeration;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi"})
public class FileUtil {

    /* JADX INFO: renamed from: a */
    public static String f682a = null;

    /* JADX INFO: renamed from: b */
    public static final InterfaceC0439a f683b = new InterfaceC0439a() { // from class: com.tencent.smtt.utils.FileUtil.2
        @Override // com.tencent.smtt.utils.FileUtil.InterfaceC0439a
        /* JADX INFO: renamed from: a */
        public boolean mo656a(File file, File file2) {
            return file.length() == file2.length() && file.lastModified() == file2.lastModified();
        }
    };

    /* JADX INFO: renamed from: c */
    private static final int f684c = 4;

    /* JADX INFO: renamed from: d */
    private static RandomAccessFile f685d = null;

    /* JADX INFO: renamed from: e */
    private static boolean f686e = true;

    /* JADX INFO: renamed from: com.tencent.smtt.utils.FileUtil$a */
    public interface InterfaceC0439a {
        /* JADX INFO: renamed from: a */
        boolean mo656a(File file, File file2);
    }

    /* JADX INFO: renamed from: com.tencent.smtt.utils.FileUtil$b */
    public interface InterfaceC0440b {
        /* JADX INFO: renamed from: a */
        boolean mo655a(InputStream inputStream, ZipEntry zipEntry, String str) throws Exception;
    }

    /* JADX INFO: renamed from: a */
    public static long m620a(InputStream inputStream, OutputStream outputStream) throws IOException, OutOfMemoryError {
        if (inputStream == null) {
            return -1L;
        }
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 == i) {
                return j;
            }
            outputStream.write(bArr, 0, i);
            j += (long) i;
        }
    }

    /* JADX INFO: renamed from: a */
    public static File m621a(Context context, String str) {
        String str2;
        File file = new File(context.getFilesDir(), "tbs");
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.canWrite()) {
            File file2 = new File(file, str);
            if (!file2.exists()) {
                try {
                    file2.createNewFile();
                } catch (IOException e) {
                    str2 = "getPermanentTbsFile -- exception: " + e;
                }
            }
            return file2;
        }
        str2 = "getPermanentTbsFile -- no permission!";
        TbsLog.m662e("FileHelper", str2);
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static File m622a(Context context, boolean z, String str) {
        String strM649c = m649c(context);
        if (strM649c == null) {
            return null;
        }
        File file = new File(strM649c);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!file.canWrite()) {
            return null;
        }
        File file2 = new File(file, str);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return file2;
    }

    /* JADX INFO: renamed from: a */
    public static String m623a(Context context, int i) {
        return m624a(context, context.getApplicationInfo().packageName, i, true);
    }

    /* JADX INFO: renamed from: a */
    public static String m624a(Context context, String str, int i, boolean z) {
        if (context == null || !m633a(context)) {
            return BuildConfig.FLAVOR;
        }
        if (i != 6) {
            if (i != 8) {
                return i != 9 ? BuildConfig.FLAVOR : m644b(context, "Download");
            }
            return m644b(context, "env");
        }
        String str2 = f682a;
        if (str2 != null) {
            return str2;
        }
        String strM644b = m644b(context, "tbslog");
        f682a = strM644b;
        return strM644b;
    }

    /* JADX INFO: renamed from: a */
    public static FileLock m625a(Context context, FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return null;
        }
        try {
            FileLock fileLockTryLock = fileOutputStream.getChannel().tryLock();
            if (fileLockTryLock.isValid()) {
                return fileLockTryLock;
            }
            return null;
        } catch (OverlappingFileLockException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    public static synchronized void m626a(Context context, FileLock fileLock) {
        TbsLog.m665i("FileHelper", "releaseTbsCoreRenameFileLock -- lock: " + fileLock);
        FileChannel fileChannelChannel = fileLock.channel();
        if (fileChannelChannel != null && fileChannelChannel.isOpen()) {
            try {
                fileLock.release();
                fileChannelChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m627a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m628a(File file, boolean z) {
        m630a(file, z, false);
    }

    /* JADX INFO: renamed from: a */
    public static void m629a(File file, boolean z, String str) {
        TbsLog.m665i("FileUtils", "delete file,ignore=" + z + "except" + str + file + Log.getStackTraceString(new Throwable()));
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (!file2.getName().equals(str)) {
                m628a(file2, z);
            }
        }
        if (z) {
            return;
        }
        file.delete();
    }

    /* JADX INFO: renamed from: a */
    public static void m630a(File file, boolean z, boolean z2) {
        TbsLog.m665i("FileUtils", "delete file,ignore=" + z + "isSoftLink=" + z2);
        if (file == null) {
            return;
        }
        if (z2 || file.exists()) {
            if ((z2 && !file.isDirectory()) || file.isFile()) {
                file.delete();
                return;
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            for (File file2 : fileArrListFiles) {
                m630a(file2, z, z2);
            }
            if (z) {
                return;
            }
            file.delete();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m631a(FileLock fileLock, FileOutputStream fileOutputStream) {
        if (fileLock != null) {
            try {
                FileChannel fileChannelChannel = fileLock.channel();
                if (fileChannelChannel != null && fileChannelChannel.isOpen()) {
                    fileLock.release();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m632a(boolean z) {
        f686e = z;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m633a(Context context) {
        return f686e;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m634a(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        m645b(file);
        return file.mkdirs();
    }

    /* JADX INFO: renamed from: a */
    public static boolean m635a(File file, File file2) throws Exception {
        return m640a(file.getPath(), file2.getPath());
    }

    /* JADX INFO: renamed from: a */
    public static boolean m636a(File file, File file2, FileFilter fileFilter) throws Exception {
        return m637a(file, file2, fileFilter, f683b);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m637a(File file, File file2, FileFilter fileFilter, InterfaceC0439a interfaceC0439a) throws Exception {
        if (file == null || file2 == null) {
            return false;
        }
        TbsLog.m662e("FileHelper", "copyFiles src is " + file.getAbsolutePath() + " dst is " + file2.getAbsolutePath());
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return m647b(file, file2, fileFilter, interfaceC0439a);
        }
        File[] fileArrListFiles = file.listFiles(fileFilter);
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z = true;
        for (File file3 : fileArrListFiles) {
            if (!m636a(file3, new File(file2, file3.getName()), fileFilter)) {
                z = false;
            }
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m639a(String str, long j, long j2, long j3) throws Exception {
        File file = new File(str);
        if (file.length() != j) {
            TbsLog.m662e("FileHelper", "file size doesn't match: " + file.length() + " vs " + j);
            return true;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                CRC32 crc32 = new CRC32();
                byte[] bArr = new byte[8192];
                while (true) {
                    int i = fileInputStream2.read(bArr);
                    if (i <= 0) {
                        break;
                    }
                    crc32.update(bArr, 0, i);
                }
                long value = crc32.getValue();
                TbsLog.m665i("FileHelper", BuildConfig.FLAVOR + file.getName() + ": crc = " + value + ", zipCrc = " + j3);
                fileInputStream2.close();
                return value != j3;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @SuppressLint({"InlinedApi"})
    /* JADX INFO: renamed from: a */
    public static boolean m640a(String str, String str2) throws Exception {
        return m642a(str, str2, Build.CPU_ABI, Build.VERSION.SDK_INT >= 8 ? Build.CPU_ABI2 : null, PropertyUtils.getQuickly("ro.product.cpu.upgradeabi", "armeabi"));
    }

    /* JADX INFO: renamed from: a */
    private static boolean m641a(String str, String str2, String str3, String str4, InterfaceC0440b interfaceC0440b) throws Exception {
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(str);
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
                boolean z = false;
                boolean z2 = false;
                while (enumerationEntries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    String name = zipEntryNextElement.getName();
                    if (name != null && !name.contains("../") && (name.startsWith("lib/") || name.startsWith("assets/"))) {
                        String strSubstring = name.substring(name.lastIndexOf(47));
                        if (strSubstring.endsWith(".so")) {
                            int i = f684c;
                            if (name.regionMatches(i, str2, 0, str2.length()) && name.charAt(str2.length() + i) == '/') {
                                z = true;
                            } else if (str3 != null && name.regionMatches(i, str3, 0, str3.length()) && name.charAt(str3.length() + i) == '/') {
                                z2 = true;
                                if (z) {
                                }
                            } else if (str4 != null && name.regionMatches(i, str4, 0, str4.length()) && name.charAt(i + str4.length()) == '/' && !z && !z2) {
                            }
                        }
                        InputStream inputStream = zipFile2.getInputStream(zipEntryNextElement);
                        try {
                            if (!interfaceC0440b.mo655a(inputStream, zipEntryNextElement, strSubstring.substring(1))) {
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                zipFile2.close();
                                return false;
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                        } catch (Throwable th) {
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            throw th;
                        }
                    }
                }
                zipFile2.close();
                return true;
            } catch (Throwable th2) {
                th = th2;
                zipFile = zipFile2;
                if (zipFile != null) {
                    zipFile.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m642a(String str, final String str2, String str3, String str4, String str5) throws Exception {
        return m641a(str, str3, str4, str5, new InterfaceC0440b() { // from class: com.tencent.smtt.utils.FileUtil.1
            @Override // com.tencent.smtt.utils.FileUtil.InterfaceC0440b
            /* JADX INFO: renamed from: a */
            public boolean mo655a(InputStream inputStream, ZipEntry zipEntry, String str6) throws Exception {
                try {
                    return FileUtil.m648b(inputStream, zipEntry, str2, str6);
                } catch (Exception e) {
                    throw new Exception("copyFileIfChanged Exception", e);
                }
            }
        });
    }

    /* JADX INFO: renamed from: b */
    public static FileOutputStream m643b(Context context, boolean z, String str) {
        File fileM622a = m622a(context, z, str);
        if (fileM622a == null) {
            return null;
        }
        try {
            return new FileOutputStream(fileM622a);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    private static String m644b(Context context, String str) {
        if (context != null && str != null && m633a(context)) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            try {
                return context.getExternalFilesDir(str).getAbsolutePath();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return BuildConfig.FLAVOR;
    }

    /* JADX INFO: renamed from: b */
    public static void m645b(File file) {
        m628a(file, false);
    }

    /* JADX INFO: renamed from: b */
    public static boolean m646b(Context context) {
        long jM820a = C0462s.m820a();
        boolean z = jM820a >= TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
        if (!z) {
            TbsLog.m662e(TbsDownloader.LOGTAG, "[TbsApkDwonloader.hasEnoughFreeSpace] freeSpace too small,  freeSpace = " + jM820a);
        }
        return z;
    }

    /* JADX INFO: renamed from: b */
    private static boolean m647b(File file, File file2, FileFilter fileFilter, InterfaceC0439a interfaceC0439a) throws Exception {
        FileChannel fileChannel;
        if (file == null || file2 == null) {
            return false;
        }
        if (fileFilter != null && !fileFilter.accept(file)) {
            return false;
        }
        FileChannel channel = null;
        try {
            if (file.exists() && file.isFile()) {
                if (file2.exists()) {
                    if (interfaceC0439a != null && interfaceC0439a.mo656a(file, file2)) {
                        return true;
                    }
                    m645b(file2);
                }
                File parentFile = file2.getParentFile();
                if (parentFile.isFile()) {
                    m645b(parentFile);
                }
                if (!parentFile.exists() && !parentFile.mkdirs()) {
                    return false;
                }
                FileChannel channel2 = new FileInputStream(file).getChannel();
                try {
                    channel = new FileOutputStream(file2).getChannel();
                    long size = channel2.size();
                    if (channel.transferFrom(channel2, 0L, size) == size) {
                        if (channel2 != null) {
                            channel2.close();
                        }
                        if (channel != null) {
                            channel.close();
                        }
                        return true;
                    }
                    m645b(file2);
                    if (channel2 != null) {
                        channel2.close();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    return false;
                } catch (Throwable th) {
                    FileChannel fileChannel2 = channel;
                    channel = channel2;
                    th = th;
                    fileChannel = fileChannel2;
                }
                if (channel != null) {
                    channel.close();
                }
                if (fileChannel != null) {
                    fileChannel.close();
                }
                throw th;
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: b */
    public static boolean m648b(InputStream inputStream, ZipEntry zipEntry, String str, String str2) throws Exception {
        m634a(new File(str));
        String str3 = str + File.separator + str2;
        File file = new File(str3);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i <= 0) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, i);
                    }
                    fileOutputStream2.close();
                    if (m639a(str3, zipEntry.getSize(), zipEntry.getTime(), zipEntry.getCrc())) {
                        TbsLog.m662e("FileHelper", "file is different: " + str3);
                        return false;
                    }
                    if (file.setLastModified(zipEntry.getTime())) {
                        return true;
                    }
                    TbsLog.m662e("FileHelper", "Couldn't set time for dst file " + file);
                    return true;
                } catch (IOException e) {
                    e = e;
                    m645b(file);
                    throw new IOException("Couldn't write dst file " + file, e);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: renamed from: c */
    public static String m649c(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "core_private");
        if (file.isDirectory() || file.mkdir()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    public static boolean m650c(File file) {
        return file != null && file.exists() && file.isFile() && file.length() > 0;
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException, OutOfMemoryError {
        long jM620a = m620a(inputStream, outputStream);
        if (jM620a > 2147483647L) {
            return -1;
        }
        return (int) jM620a;
    }

    /* JADX INFO: renamed from: d */
    public static FileOutputStream m651d(File file) throws IOException {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                throw new IOException("File '" + file + "' could not be created");
            }
        } else {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (!file.canWrite()) {
                throw new IOException("File '" + file + "' cannot be written to");
            }
        }
        return new FileOutputStream(file);
    }

    /* JADX INFO: renamed from: d */
    public static FileLock m652d(Context context) {
        FileLock fileLockM654f;
        StringBuilder sb;
        String str;
        TbsLog.m665i("FileHelper", "getTbsCoreLoadFileLock #1");
        File fileM621a = m621a(context, "tbs_rename_lock");
        TbsLog.m665i("FileHelper", "getTbsCoreLoadFileLock #4 " + fileM621a);
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(fileM621a.getAbsolutePath(), "r");
            f685d = randomAccessFile;
            fileLockM654f = randomAccessFile.getChannel().tryLock(0L, RecyclerView.FOREVER_NS, true);
        } catch (Throwable th) {
            TbsLog.m662e("FileHelper", "getTbsCoreLoadFileLock -- exception: " + th);
            fileLockM654f = null;
        }
        if (fileLockM654f == null) {
            fileLockM654f = m654f(context);
        }
        if (fileLockM654f == null) {
            sb = new StringBuilder();
            str = "getTbsCoreLoadFileLock -- failed: ";
        } else {
            sb = new StringBuilder();
            str = "getTbsCoreLoadFileLock -- success: ";
        }
        sb.append(str);
        sb.append("tbs_rename_lock");
        TbsLog.m665i("FileHelper", sb.toString());
        return fileLockM654f;
    }

    /* JADX INFO: renamed from: e */
    public static FileLock m653e(Context context) {
        FileLock fileLockTryLock;
        StringBuilder sb;
        String str;
        File fileM621a = m621a(context, "tbs_rename_lock");
        TbsLog.m665i("FileHelper", "getTbsCoreRenameFileLock #1 " + fileM621a);
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(fileM621a.getAbsolutePath(), "rw");
            f685d = randomAccessFile;
            fileLockTryLock = randomAccessFile.getChannel().tryLock(0L, RecyclerView.FOREVER_NS, false);
        } catch (Throwable unused) {
            TbsLog.m662e("FileHelper", "getTbsCoreRenameFileLock -- excpetion: tbs_rename_lock");
            fileLockTryLock = null;
        }
        if (fileLockTryLock == null) {
            sb = new StringBuilder();
            str = "getTbsCoreRenameFileLock -- failed: ";
        } else {
            sb = new StringBuilder();
            str = "getTbsCoreRenameFileLock -- success: ";
        }
        sb.append(str);
        sb.append("tbs_rename_lock");
        TbsLog.m665i("FileHelper", sb.toString());
        return fileLockTryLock;
    }

    /* JADX INFO: renamed from: f */
    private static FileLock m654f(Context context) {
        FileLock fileLockTryLock = null;
        try {
            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
            tbsLogInfo.setErrorCode(803);
            File fileM621a = m621a(context, "tbs_rename_lock");
            if (TbsDownloadConfig.getInstance(context).getTbsCoreLoadRenameFileLockWaitEnable()) {
                int i = 0;
                while (i < 20 && fileLockTryLock == null) {
                    try {
                        try {
                            Thread.sleep(100L);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        RandomAccessFile randomAccessFile = new RandomAccessFile(fileM621a.getAbsolutePath(), "r");
                        f685d = randomAccessFile;
                        fileLockTryLock = randomAccessFile.getChannel().tryLock(0L, RecyclerView.FOREVER_NS, true);
                    } catch (Throwable unused) {
                    }
                    i++;
                }
                if (fileLockTryLock != null) {
                    tbsLogInfo.setErrorCode(802);
                } else {
                    tbsLogInfo.setErrorCode(801);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("getTbsCoreLoadFileLock,retry num=");
                sb.append(i);
                sb.append("success=");
                sb.append(fileLockTryLock == null);
                TbsLog.m665i("FileHelper", sb.toString());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return fileLockTryLock;
    }
}
