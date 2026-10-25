package I1I.I1I.p008IL.iIlLiL;

import I1I.IL1Iii;
import android.util.Log;
import com.main.utils.zip.ZipEntry;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;

/* JADX INFO: compiled from: Zip.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil {
    public static boolean IL1Iii(String str, String str2, String str3) throws Exception {
        I1I i1i = null;
        try {
            try {
                I1I i1i2 = new I1I(new FileInputStream(str));
                try {
                    if (!new File(str3).exists()) {
                        while (true) {
                            ZipEntry zipEntryLLL = i1i2.LLL();
                            if (zipEntryLLL == null) {
                                i1i2.close();
                                break;
                            }
                            String strIL1Iii = zipEntryLLL.IL1Iii();
                            if (!zipEntryLLL.ILil() && strIL1Iii.compareTo(str2) == 0) {
                                File file = new File(str3);
                                file.createNewFile();
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i = i1i2.read(bArr);
                                    if (i == -1) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, i);
                                    fileOutputStream.flush();
                                }
                                fileOutputStream.close();
                                try {
                                    i1i2.close();
                                } catch (Exception unused) {
                                }
                                return true;
                            }
                        }
                    } else {
                        try {
                            i1i2.close();
                        } catch (Exception unused2) {
                        }
                        return false;
                    }
                } catch (Exception e) {
                    e = e;
                    i1i = i1i2;
                    Log.i(IL1Iii.IL1Iii(new byte[]{45, 108}, IL1Iii.IL1Iii(new byte[]{81, 82, 87, 10, 5, 10}, IL1Iii.IL1Iii(new byte[]{1, 7, 85, 5, 87, 92}, "3a66bd"))), IL1Iii.IL1Iii(new byte[]{71, 87, 76, 12, 21, 22, 87, 75, 68, 95}, IL1Iii.IL1Iii(new byte[]{84, 10, 2, 1, 6, 2}, IL1Iii.IL1Iii(new byte[]{80, 85, 13, 6, 87, 4}, "6f9b40"))) + e.toString());
                    i1i.close();
                } catch (Throwable th) {
                    th = th;
                    i1i = i1i2;
                    try {
                        i1i.close();
                    } catch (Exception unused3) {
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception unused4) {
        }
        return false;
    }

    public static boolean ILil(String str, Map<String, String> map) throws Exception {
        I1I i1i = null;
        try {
            I1I i1i2 = new I1I(new FileInputStream(str));
            while (true) {
                try {
                    ZipEntry zipEntryLLL = i1i2.LLL();
                    if (zipEntryLLL != null) {
                        String strIL1Iii = zipEntryLLL.IL1Iii();
                        if (!zipEntryLLL.ILil() && map.containsKey(strIL1Iii)) {
                            File file = new File(map.get(strIL1Iii));
                            if (!file.getParentFile().exists()) {
                                file.getParentFile().mkdirs();
                            }
                            if (file.exists()) {
                                file.delete();
                            }
                            file.createNewFile();
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i = i1i2.read(bArr);
                                if (i == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, i);
                                fileOutputStream.flush();
                            }
                            fileOutputStream.close();
                        }
                    } else {
                        try {
                            break;
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception e) {
                    e = e;
                    i1i = i1i2;
                    Log.i(IL1Iii.IL1Iii(new byte[]{119, 110}, IL1Iii.IL1Iii(new byte[]{10, 6, 87, 2, 4, 10}, IL1Iii.IL1Iii(new byte[]{0, 6, 91, 6, 3, 0}, "369432"))), IL1Iii.IL1Iii(new byte[]{65, 8, 74, 15, 64, 25, 81, 20, 66, 92}, IL1Iii.IL1Iii(new byte[]{82, 82, 9, 83, 8, 91}, IL1Iii.IL1Iii(new byte[]{80, 80, 15, 84, 12, 80}, "6d6a42"))) + e.toString());
                    try {
                        i1i.close();
                    } catch (Exception unused2) {
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    i1i = i1i2;
                    try {
                        i1i.close();
                    } catch (Exception unused3) {
                    }
                    throw th;
                }
            }
            i1i2.close();
            return true;
        } catch (Exception e2) {
            e = e2;
        }
    }
}
