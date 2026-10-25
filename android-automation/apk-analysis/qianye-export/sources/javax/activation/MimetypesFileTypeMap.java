package javax.activation;

import com.sun.activation.registries.LogSupport;
import com.sun.activation.registries.MimeTypeFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public class MimetypesFileTypeMap extends FileTypeMap {
    private static final int PROG = 0;
    private static MimeTypeFile defDB = null;
    private static String defaultType = "application/octet-stream";

    /* JADX INFO: renamed from: DB */
    private MimeTypeFile[] f859DB;

    public MimetypesFileTypeMap() throws Throwable {
        Vector vector = new Vector(5);
        vector.addElement(null);
        LogSupport.log("MimetypesFileTypeMap: load HOME");
        try {
            String property = System.getProperty("user.home");
            if (property != null) {
                MimeTypeFile mimeTypeFileLoadFile = loadFile(String.valueOf(property) + File.separator + ".mime.types");
                if (mimeTypeFileLoadFile != null) {
                    vector.addElement(mimeTypeFileLoadFile);
                }
            }
        } catch (SecurityException unused) {
        }
        LogSupport.log("MimetypesFileTypeMap: load SYS");
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(System.getProperty("java.home")));
            String str = File.separator;
            sb.append(str);
            sb.append("lib");
            sb.append(str);
            sb.append("mime.types");
            MimeTypeFile mimeTypeFileLoadFile2 = loadFile(sb.toString());
            if (mimeTypeFileLoadFile2 != null) {
                vector.addElement(mimeTypeFileLoadFile2);
            }
        } catch (SecurityException unused2) {
        }
        LogSupport.log("MimetypesFileTypeMap: load JAR");
        loadAllResources(vector, "mime.types");
        LogSupport.log("MimetypesFileTypeMap: load DEF");
        synchronized (MimetypesFileTypeMap.class) {
            if (defDB == null) {
                defDB = loadResource("/mimetypes.default");
            }
        }
        MimeTypeFile mimeTypeFile = defDB;
        if (mimeTypeFile != null) {
            vector.addElement(mimeTypeFile);
        }
        MimeTypeFile[] mimeTypeFileArr = new MimeTypeFile[vector.size()];
        this.f859DB = mimeTypeFileArr;
        vector.copyInto(mimeTypeFileArr);
    }

    /* JADX WARN: Code duplicated, block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:75:0x0118  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:73:0x00ff, please report this as an issue */
    private void loadAllResources(Vector vector, String str) throws Throwable {
        MimeTypeFile mimeTypeFileLoadResource;
        SecurityException e;
        IOException e2;
        int i = 0;
        try {
            ClassLoader contextClassLoader = SecuritySupport.getContextClassLoader();
            if (contextClassLoader == null) {
                contextClassLoader = getClass().getClassLoader();
            }
            URL[] resources = contextClassLoader != null ? SecuritySupport.getResources(contextClassLoader, str) : SecuritySupport.getSystemResources(str);
            if (resources != null) {
                if (LogSupport.isLoggable()) {
                    LogSupport.log("MimetypesFileTypeMap: getResources");
                }
                int i2 = 0;
                while (i < resources.length) {
                    try {
                        URL url = resources[i];
                        InputStream inputStreamOpenStream = null;
                        if (LogSupport.isLoggable()) {
                            LogSupport.log("MimetypesFileTypeMap: URL " + url);
                        }
                        int i3 = 1;
                        try {
                            inputStreamOpenStream = SecuritySupport.openStream(url);
                            if (inputStreamOpenStream != null) {
                                vector.addElement(new MimeTypeFile(inputStreamOpenStream));
                                try {
                                    if (LogSupport.isLoggable()) {
                                        LogSupport.log("MimetypesFileTypeMap: successfully loaded mime types from URL: " + url);
                                    }
                                    i2 = 1;
                                } catch (IOException e3) {
                                    e2 = e3;
                                    if (LogSupport.isLoggable()) {
                                        LogSupport.log("MimetypesFileTypeMap: can't load " + url, e2);
                                    }
                                    if (inputStreamOpenStream != null) {
                                        try {
                                            inputStreamOpenStream.close();
                                        } catch (IOException unused) {
                                        } catch (Exception e4) {
                                            e = e4;
                                            i = i3;
                                            if (LogSupport.isLoggable()) {
                                                LogSupport.log("MimetypesFileTypeMap: can't load " + str, e);
                                            }
                                            if (i == 0) {
                                                LogSupport.log("MimetypesFileTypeMap: !anyLoaded");
                                                mimeTypeFileLoadResource = loadResource("/" + str);
                                                if (mimeTypeFileLoadResource != null) {
                                                    vector.addElement(mimeTypeFileLoadResource);
                                                }
                                            }
                                        }
                                    }
                                    i2 = i3;
                                } catch (SecurityException e5) {
                                    e = e5;
                                    try {
                                        if (LogSupport.isLoggable()) {
                                            LogSupport.log("MimetypesFileTypeMap: can't load " + url, e);
                                        }
                                        if (inputStreamOpenStream != null) {
                                            inputStreamOpenStream.close();
                                        }
                                        i2 = i3;
                                    } catch (Throwable th) {
                                        th = th;
                                        i2 = i3;
                                        if (inputStreamOpenStream != null) {
                                            try {
                                                inputStreamOpenStream.close();
                                            } catch (IOException unused2) {
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    i2 = 1;
                                    if (inputStreamOpenStream != null) {
                                        inputStreamOpenStream.close();
                                    }
                                    throw th;
                                }
                            } else if (LogSupport.isLoggable()) {
                                LogSupport.log("MimetypesFileTypeMap: not loading mime types from URL: " + url);
                            }
                            if (inputStreamOpenStream != null) {
                                try {
                                    inputStreamOpenStream.close();
                                } catch (IOException unused3) {
                                }
                            }
                        } catch (IOException e6) {
                            i3 = i2;
                            e2 = e6;
                        } catch (SecurityException e7) {
                            i3 = i2;
                            e = e7;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        i++;
                    } catch (Exception e8) {
                        e = e8;
                        i = i2;
                    }
                }
                i = i2;
            }
        } catch (Exception e9) {
            e = e9;
        }
        if (i == 0) {
            LogSupport.log("MimetypesFileTypeMap: !anyLoaded");
            mimeTypeFileLoadResource = loadResource("/" + str);
            if (mimeTypeFileLoadResource != null) {
                vector.addElement(mimeTypeFileLoadResource);
            }
        }
    }

    private MimeTypeFile loadFile(String str) {
        try {
            return new MimeTypeFile(str);
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0048 A[EXC_TOP_SPLITTER, PHI: r2
  0x0048: PHI (r2v5 java.io.InputStream) = (r2v3 java.io.InputStream), (r2v4 java.io.InputStream), (r2v7 java.io.InputStream) binds: [B:29:0x006b, B:35:0x0083, B:14:0x0046] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0088: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:39:0x0088 */
    private MimeTypeFile loadResource(String str) throws Throwable {
        InputStream resourceAsStream;
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            try {
                resourceAsStream = SecuritySupport.getResourceAsStream(getClass(), str);
                try {
                    if (resourceAsStream == null) {
                        if (LogSupport.isLoggable()) {
                            LogSupport.log("MimetypesFileTypeMap: not loading mime types file: " + str);
                        }
                        if (resourceAsStream != null) {
                            try {
                                resourceAsStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        return null;
                    }
                    MimeTypeFile mimeTypeFile = new MimeTypeFile(resourceAsStream);
                    if (LogSupport.isLoggable()) {
                        LogSupport.log("MimetypesFileTypeMap: successfully loaded mime types file: " + str);
                    }
                    if (resourceAsStream != null) {
                        try {
                            resourceAsStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return mimeTypeFile;
                } catch (IOException e) {
                    e = e;
                    if (LogSupport.isLoggable()) {
                        LogSupport.log("MimetypesFileTypeMap: can't load " + str, e);
                    }
                    if (resourceAsStream != null) {
                        resourceAsStream.close();
                    }
                } catch (SecurityException e2) {
                    e = e2;
                    if (LogSupport.isLoggable()) {
                        LogSupport.log("MimetypesFileTypeMap: can't load " + str, e);
                    }
                    if (resourceAsStream != null) {
                        resourceAsStream.close();
                    }
                }
            } catch (IOException e3) {
                e = e3;
                resourceAsStream = null;
            } catch (SecurityException e4) {
                e = e4;
                resourceAsStream = null;
            } catch (Throwable th) {
                th = th;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = inputStream;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            throw th;
        }
    }

    public synchronized void addMimeTypes(String str) {
        MimeTypeFile[] mimeTypeFileArr = this.f859DB;
        if (mimeTypeFileArr[0] == null) {
            mimeTypeFileArr[0] = new MimeTypeFile();
        }
        this.f859DB[0].appendToRegistry(str);
    }

    @Override // javax.activation.FileTypeMap
    public String getContentType(File file) {
        return getContentType(file.getName());
    }

    @Override // javax.activation.FileTypeMap
    public synchronized String getContentType(String str) {
        String mIMETypeString;
        int iLastIndexOf = str.lastIndexOf(".");
        if (iLastIndexOf < 0) {
            return defaultType;
        }
        String strSubstring = str.substring(iLastIndexOf + 1);
        if (strSubstring.length() == 0) {
            return defaultType;
        }
        int i = 0;
        while (true) {
            MimeTypeFile[] mimeTypeFileArr = this.f859DB;
            if (i >= mimeTypeFileArr.length) {
                return defaultType;
            }
            if (mimeTypeFileArr[i] != null && (mIMETypeString = mimeTypeFileArr[i].getMIMETypeString(strSubstring)) != null) {
                return mIMETypeString;
            }
            i++;
        }
    }

    public MimetypesFileTypeMap(String str) throws IOException {
        this();
        this.f859DB[0] = new MimeTypeFile(str);
    }

    public MimetypesFileTypeMap(InputStream inputStream) {
        this();
        try {
            this.f859DB[0] = new MimeTypeFile(inputStream);
        } catch (IOException unused) {
        }
    }
}
