package javax.activation;

import com.sun.activation.registries.LogSupport;
import com.sun.activation.registries.MailcapFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MailcapCommandMap extends CommandMap {
    private static final int PROG = 0;
    private static MailcapFile defDB;

    /* JADX INFO: renamed from: DB */
    private MailcapFile[] f858DB;

    public MailcapCommandMap() throws Throwable {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(null);
        LogSupport.log("MailcapCommandMap: load HOME");
        try {
            String property = System.getProperty("user.home");
            if (property != null) {
                MailcapFile mailcapFileLoadFile = loadFile(String.valueOf(property) + File.separator + ".mailcap");
                if (mailcapFileLoadFile != null) {
                    arrayList.add(mailcapFileLoadFile);
                }
            }
        } catch (SecurityException unused) {
        }
        LogSupport.log("MailcapCommandMap: load SYS");
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(System.getProperty("java.home")));
            String str = File.separator;
            sb.append(str);
            sb.append("lib");
            sb.append(str);
            sb.append("mailcap");
            MailcapFile mailcapFileLoadFile2 = loadFile(sb.toString());
            if (mailcapFileLoadFile2 != null) {
                arrayList.add(mailcapFileLoadFile2);
            }
        } catch (SecurityException unused2) {
        }
        LogSupport.log("MailcapCommandMap: load JAR");
        loadAllResources(arrayList, "mailcap");
        LogSupport.log("MailcapCommandMap: load DEF");
        synchronized (MailcapCommandMap.class) {
            if (defDB == null) {
                defDB = loadResource("mailcap.default");
            }
        }
        MailcapFile mailcapFile = defDB;
        if (mailcapFile != null) {
            arrayList.add(mailcapFile);
        }
        MailcapFile[] mailcapFileArr = new MailcapFile[arrayList.size()];
        this.f858DB = mailcapFileArr;
        this.f858DB = (MailcapFile[]) arrayList.toArray(mailcapFileArr);
    }

    private void appendCmdsToList(Map map, List list) {
        for (String str : map.keySet()) {
            Iterator it = ((List) map.get(str)).iterator();
            while (it.hasNext()) {
                list.add(new CommandInfo(str, (String) it.next()));
            }
        }
    }

    private void appendPrefCmdsToList(Map map, List list) {
        for (String str : map.keySet()) {
            if (!checkForVerb(list, str)) {
                list.add(new CommandInfo(str, (String) ((List) map.get(str)).get(0)));
            }
        }
    }

    private boolean checkForVerb(List list, String str) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((CommandInfo) it.next()).getCommandName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    private DataContentHandler getDataContentHandler(String str) {
        Class<?> cls;
        if (LogSupport.isLoggable()) {
            LogSupport.log("    got content-handler");
        }
        if (LogSupport.isLoggable()) {
            LogSupport.log("      class " + str);
        }
        try {
            ClassLoader contextClassLoader = SecuritySupport.getContextClassLoader();
            if (contextClassLoader == null) {
                contextClassLoader = getClass().getClassLoader();
            }
            try {
                cls = contextClassLoader.loadClass(str);
            } catch (Exception unused) {
                cls = Class.forName(str);
            }
            if (cls != null) {
                return (DataContentHandler) cls.newInstance();
            }
            return null;
        } catch (ClassNotFoundException e) {
            if (!LogSupport.isLoggable()) {
                return null;
            }
            LogSupport.log("Can't load DCH " + str, e);
            return null;
        } catch (IllegalAccessException e2) {
            if (!LogSupport.isLoggable()) {
                return null;
            }
            LogSupport.log("Can't load DCH " + str, e2);
            return null;
        } catch (InstantiationException e3) {
            if (!LogSupport.isLoggable()) {
                return null;
            }
            LogSupport.log("Can't load DCH " + str, e3);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:75:0x0105  */
    /* JADX WARN: Code duplicated, block: B:78:0x011e  */
    /* JADX WARN: Code duplicated, block: B:85:0x00e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private void loadAllResources(List list, String str) throws Throwable {
        MailcapFile mailcapFileLoadResource;
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
                    LogSupport.log("MailcapCommandMap: getResources");
                }
                int i2 = 0;
                while (i < resources.length) {
                    try {
                        URL url = resources[i];
                        InputStream inputStreamOpenStream = null;
                        if (LogSupport.isLoggable()) {
                            LogSupport.log("MailcapCommandMap: URL " + url);
                        }
                        int i3 = 1;
                        try {
                            inputStreamOpenStream = SecuritySupport.openStream(url);
                            if (inputStreamOpenStream != null) {
                                list.add(new MailcapFile(inputStreamOpenStream));
                                try {
                                    if (LogSupport.isLoggable()) {
                                        LogSupport.log("MailcapCommandMap: successfully loaded mailcap file from URL: " + url);
                                    }
                                    i2 = 1;
                                } catch (IOException e3) {
                                    e2 = e3;
                                    if (LogSupport.isLoggable()) {
                                        LogSupport.log("MailcapCommandMap: can't load " + url, e2);
                                    }
                                    if (inputStreamOpenStream != null) {
                                        try {
                                            inputStreamOpenStream.close();
                                        } catch (IOException unused) {
                                        } catch (Exception e4) {
                                            e = e4;
                                            i = i3;
                                            if (LogSupport.isLoggable()) {
                                                LogSupport.log("MailcapCommandMap: can't load " + str, e);
                                            }
                                            if (i == 0) {
                                                if (LogSupport.isLoggable()) {
                                                    LogSupport.log("MailcapCommandMap: !anyLoaded");
                                                }
                                                mailcapFileLoadResource = loadResource("/" + str);
                                                if (mailcapFileLoadResource != null) {
                                                    list.add(mailcapFileLoadResource);
                                                }
                                            }
                                        }
                                    }
                                    i2 = i3;
                                } catch (SecurityException e5) {
                                    e = e5;
                                    try {
                                        if (LogSupport.isLoggable()) {
                                            LogSupport.log("MailcapCommandMap: can't load " + url, e);
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
                                LogSupport.log("MailcapCommandMap: not loading mailcap file from URL: " + url);
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
            if (LogSupport.isLoggable()) {
                LogSupport.log("MailcapCommandMap: !anyLoaded");
            }
            mailcapFileLoadResource = loadResource("/" + str);
            if (mailcapFileLoadResource != null) {
                list.add(mailcapFileLoadResource);
            }
        }
    }

    private MailcapFile loadFile(String str) {
        try {
            return new MailcapFile(str);
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0048 A[EXC_TOP_SPLITTER, PHI: r2
  0x0048: PHI (r2v5 java.io.InputStream) = (r2v3 java.io.InputStream), (r2v4 java.io.InputStream), (r2v7 java.io.InputStream) binds: [B:29:0x006b, B:35:0x0083, B:14:0x0046] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0088: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:39:0x0088 */
    private MailcapFile loadResource(String str) throws Throwable {
        InputStream resourceAsStream;
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            try {
                resourceAsStream = SecuritySupport.getResourceAsStream(getClass(), str);
                try {
                    if (resourceAsStream == null) {
                        if (LogSupport.isLoggable()) {
                            LogSupport.log("MailcapCommandMap: not loading mailcap file: " + str);
                        }
                        if (resourceAsStream != null) {
                            try {
                                resourceAsStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        return null;
                    }
                    MailcapFile mailcapFile = new MailcapFile(resourceAsStream);
                    if (LogSupport.isLoggable()) {
                        LogSupport.log("MailcapCommandMap: successfully loaded mailcap file: " + str);
                    }
                    if (resourceAsStream != null) {
                        try {
                            resourceAsStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return mailcapFile;
                } catch (IOException e) {
                    e = e;
                    if (LogSupport.isLoggable()) {
                        LogSupport.log("MailcapCommandMap: can't load " + str, e);
                    }
                    if (resourceAsStream != null) {
                        resourceAsStream.close();
                    }
                } catch (SecurityException e2) {
                    e = e2;
                    if (LogSupport.isLoggable()) {
                        LogSupport.log("MailcapCommandMap: can't load " + str, e);
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

    public synchronized void addMailcap(String str) {
        LogSupport.log("MailcapCommandMap: add to PROG");
        MailcapFile[] mailcapFileArr = this.f858DB;
        if (mailcapFileArr[0] == null) {
            mailcapFileArr[0] = new MailcapFile();
        }
        this.f858DB[0].appendToMailcap(str);
    }

    @Override // javax.activation.CommandMap
    public synchronized DataContentHandler createDataContentHandler(String str) {
        List list;
        DataContentHandler dataContentHandler;
        List list2;
        DataContentHandler dataContentHandler2;
        if (LogSupport.isLoggable()) {
            LogSupport.log("MailcapCommandMap: createDataContentHandler for " + str);
        }
        if (str != null) {
            str = str.toLowerCase(Locale.ENGLISH);
        }
        int i = 0;
        while (true) {
            MailcapFile[] mailcapFileArr = this.f858DB;
            if (i >= mailcapFileArr.length) {
                int i2 = 0;
                while (true) {
                    MailcapFile[] mailcapFileArr2 = this.f858DB;
                    if (i2 >= mailcapFileArr2.length) {
                        return null;
                    }
                    if (mailcapFileArr2[i2] != null) {
                        if (LogSupport.isLoggable()) {
                            LogSupport.log("  search fallback DB #" + i2);
                        }
                        Map mailcapFallbackList = this.f858DB[i2].getMailcapFallbackList(str);
                        if (mailcapFallbackList != null && (list = (List) mailcapFallbackList.get("content-handler")) != null && (dataContentHandler = getDataContentHandler((String) list.get(0))) != null) {
                            return dataContentHandler;
                        }
                    }
                    i2++;
                }
            } else {
                if (mailcapFileArr[i] != null) {
                    if (LogSupport.isLoggable()) {
                        LogSupport.log("  search DB #" + i);
                    }
                    Map mailcapList = this.f858DB[i].getMailcapList(str);
                    if (mailcapList != null && (list2 = (List) mailcapList.get("content-handler")) != null && (dataContentHandler2 = getDataContentHandler((String) list2.get(0))) != null) {
                        return dataContentHandler2;
                    }
                }
                i++;
            }
        }
    }

    @Override // javax.activation.CommandMap
    public synchronized CommandInfo[] getAllCommands(String str) {
        ArrayList arrayList;
        Map mailcapFallbackList;
        Map mailcapList;
        arrayList = new ArrayList();
        if (str != null) {
            str = str.toLowerCase(Locale.ENGLISH);
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            MailcapFile[] mailcapFileArr = this.f858DB;
            if (i2 >= mailcapFileArr.length) {
                break;
            }
            if (mailcapFileArr[i2] != null && (mailcapList = mailcapFileArr[i2].getMailcapList(str)) != null) {
                appendCmdsToList(mailcapList, arrayList);
            }
            i2++;
        }
        while (true) {
            MailcapFile[] mailcapFileArr2 = this.f858DB;
            if (i >= mailcapFileArr2.length) {
            } else {
                if (mailcapFileArr2[i] != null && (mailcapFallbackList = mailcapFileArr2[i].getMailcapFallbackList(str)) != null) {
                    appendCmdsToList(mailcapFallbackList, arrayList);
                }
                i++;
            }
        }
        return (CommandInfo[]) arrayList.toArray(new CommandInfo[arrayList.size()]);
    }

    @Override // javax.activation.CommandMap
    public synchronized CommandInfo getCommand(String str, String str2) {
        Map mailcapFallbackList;
        List list;
        String str3;
        Map mailcapList;
        List list2;
        String str4;
        if (str != null) {
            try {
                str = str.toLowerCase(Locale.ENGLISH);
            } catch (Throwable th) {
                throw th;
            }
        }
        int i = 0;
        while (true) {
            MailcapFile[] mailcapFileArr = this.f858DB;
            if (i >= mailcapFileArr.length) {
                int i2 = 0;
                while (true) {
                    MailcapFile[] mailcapFileArr2 = this.f858DB;
                    if (i2 >= mailcapFileArr2.length) {
                        return null;
                    }
                    if (mailcapFileArr2[i2] != null && (mailcapFallbackList = mailcapFileArr2[i2].getMailcapFallbackList(str)) != null && (list = (List) mailcapFallbackList.get(str2)) != null && (str3 = (String) list.get(0)) != null) {
                        return new CommandInfo(str2, str3);
                    }
                    i2++;
                }
            } else {
                if (mailcapFileArr[i] != null && (mailcapList = mailcapFileArr[i].getMailcapList(str)) != null && (list2 = (List) mailcapList.get(str2)) != null && (str4 = (String) list2.get(0)) != null) {
                    return new CommandInfo(str2, str4);
                }
                i++;
            }
        }
    }

    @Override // javax.activation.CommandMap
    public synchronized String[] getMimeTypes() {
        ArrayList arrayList;
        String[] mimeTypes;
        arrayList = new ArrayList();
        int i = 0;
        while (true) {
            MailcapFile[] mailcapFileArr = this.f858DB;
            if (i < mailcapFileArr.length) {
                if (mailcapFileArr[i] != null && (mimeTypes = mailcapFileArr[i].getMimeTypes()) != null) {
                    for (int i2 = 0; i2 < mimeTypes.length; i2++) {
                        if (!arrayList.contains(mimeTypes[i2])) {
                            arrayList.add(mimeTypes[i2]);
                        }
                    }
                }
                i++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public synchronized String[] getNativeCommands(String str) {
        ArrayList arrayList;
        String[] nativeCommands;
        arrayList = new ArrayList();
        if (str != null) {
            str = str.toLowerCase(Locale.ENGLISH);
        }
        int i = 0;
        while (true) {
            MailcapFile[] mailcapFileArr = this.f858DB;
            if (i < mailcapFileArr.length) {
                if (mailcapFileArr[i] != null && (nativeCommands = mailcapFileArr[i].getNativeCommands(str)) != null) {
                    for (int i2 = 0; i2 < nativeCommands.length; i2++) {
                        if (!arrayList.contains(nativeCommands[i2])) {
                            arrayList.add(nativeCommands[i2]);
                        }
                    }
                }
                i++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // javax.activation.CommandMap
    public synchronized CommandInfo[] getPreferredCommands(String str) {
        ArrayList arrayList;
        Map mailcapFallbackList;
        Map mailcapList;
        arrayList = new ArrayList();
        if (str != null) {
            str = str.toLowerCase(Locale.ENGLISH);
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            MailcapFile[] mailcapFileArr = this.f858DB;
            if (i2 >= mailcapFileArr.length) {
                break;
            }
            if (mailcapFileArr[i2] != null && (mailcapList = mailcapFileArr[i2].getMailcapList(str)) != null) {
                appendPrefCmdsToList(mailcapList, arrayList);
            }
            i2++;
        }
        while (true) {
            MailcapFile[] mailcapFileArr2 = this.f858DB;
            if (i >= mailcapFileArr2.length) {
            } else {
                if (mailcapFileArr2[i] != null && (mailcapFallbackList = mailcapFileArr2[i].getMailcapFallbackList(str)) != null) {
                    appendPrefCmdsToList(mailcapFallbackList, arrayList);
                }
                i++;
            }
        }
        return (CommandInfo[]) arrayList.toArray(new CommandInfo[arrayList.size()]);
    }

    public MailcapCommandMap(String str) throws IOException {
        this();
        if (LogSupport.isLoggable()) {
            LogSupport.log("MailcapCommandMap: load PROG from " + str);
        }
        MailcapFile[] mailcapFileArr = this.f858DB;
        if (mailcapFileArr[0] == null) {
            mailcapFileArr[0] = new MailcapFile(str);
        }
    }

    public MailcapCommandMap(InputStream inputStream) {
        this();
        LogSupport.log("MailcapCommandMap: load PROG");
        MailcapFile[] mailcapFileArr = this.f858DB;
        if (mailcapFileArr[0] == null) {
            try {
                mailcapFileArr[0] = new MailcapFile(inputStream);
            } catch (IOException unused) {
            }
        }
    }
}
