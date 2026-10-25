package I1I.p062Ilil.p063IL1Iii.I1I;

import I1I.I1I.ILil.l1IIi1;
import I1I.I1I.p008IL.lIlii;
import I1I.IL1Iii;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.flexbox.BuildConfig;
import com.p000nx.assist.lua.ApkLoader;
import com.p000nx.assist.lua.LuaEngine;
import com.tencent.smtt.utils.Md5Utils;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.Hashtable;
import java.util.Map;
import p051lLi1LL.IL1Iii.IL1Iii.IL1Iii.ILil;

/* JADX INFO: renamed from: I1I.Ilil.IL1Iii.I1I.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: PluginManager.java */
/* JADX INFO: loaded from: classes.dex */
public class lLi1LL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static Context f3442IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static Map<String, ApkLoader> f3443ILil = new Hashtable();

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static String f3441I1I = null;

    public static void IL1Iii(Context context) {
        f3442IL1Iii = context;
        File filesDir = context.getFilesDir();
        filesDir.mkdir();
        File file = new File(filesDir, IL1Iii.IL1Iii(new byte[]{68, 14, 69, 86, 11, 89, 85, 18, 91}, IL1Iii.IL1Iii(new byte[]{1, 0, 3, 84, 82, 0}, IL1Iii.IL1Iii(new byte[]{6, 85, 5, 82, 4, 84}, "37674c"))));
        file.mkdir();
        f3441I1I = file.getAbsolutePath();
    }

    /* JADX WARN: Code duplicated, block: B:62:0x0599 A[Catch: Exception -> 0x0629, TryCatch #4 {Exception -> 0x0629, blocks: (B:60:0x0593, B:62:0x0599, B:63:0x059d, B:66:0x05a9, B:67:0x0603, B:68:0x0607), top: B:82:0x0593 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x05a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:66:0x05a9 A[Catch: Exception -> 0x0629, TryCatch #4 {Exception -> 0x0629, blocks: (B:60:0x0593, B:62:0x0599, B:63:0x059d, B:66:0x05a9, B:67:0x0603, B:68:0x0607), top: B:82:0x0593 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0603 A[Catch: Exception -> 0x0629, TryCatch #4 {Exception -> 0x0629, blocks: (B:60:0x0593, B:62:0x0599, B:63:0x059d, B:66:0x05a9, B:67:0x0603, B:68:0x0607), top: B:82:0x0593 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:66:0x05a9, please report this as an issue */
    public static ApkLoader ILil(String str) throws Throwable {
        File file;
        String md5;
        File fileM1015IL;
        String str2;
        File file2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LuaEngine.getResPath();
        File file3 = new File(str);
        if (!file3.exists()) {
            file3 = l1IIi1.I1I().m1019iILLL1(str);
        }
        try {
            if (file3.exists()) {
                md5 = Md5Utils.getMD5(file3);
                if (f3443ILil.get(md5) != null) {
                    try {
                        return f3443ILil.get(md5);
                    } catch (Exception e) {
                        e = e;
                        file = null;
                        md5 = null;
                    }
                } else {
                    try {
                        file2 = new File(f3441I1I, md5);
                        try {
                            file2.mkdir();
                            file = new File(file2.getAbsolutePath(), IL1Iii.IL1Iii(new byte[]{81, 88, 17, 7, 25, 4, 67, 82}, IL1Iii.IL1Iii(new byte[]{5, 0, 90, 81, 1, 85}, IL1Iii.IL1Iii(new byte[]{3, 8, 1, 82, 3, 4}, "519a54"))));
                            try {
                                ILil.ILil(file3, file);
                            } catch (Exception e2) {
                                try {
                                    e2.printStackTrace();
                                } catch (Exception e3) {
                                    e = e3;
                                    Log.i(IL1Iii.IL1Iii(new byte[]{122, 104}, IL1Iii.IL1Iii(new byte[]{3, 9, 91, 7, 2, 86}, IL1Iii.IL1Iii(new byte[]{15, 88, 6, 83, 6, 0}, "8adc24"))), e.toString());
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                            file = null;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        file2 = null;
                    }
                }
                Log.i(IL1Iii.IL1Iii(new byte[]{122, 104}, IL1Iii.IL1Iii(new byte[]{3, 9, 91, 7, 2, 86}, IL1Iii.IL1Iii(new byte[]{15, 88, 6, 83, 6, 0}, "8adc24"))), e.toString());
            } else {
                file2 = null;
                file = null;
                md5 = null;
            }
        } catch (Exception e6) {
            e = e6;
            file2 = null;
            file = null;
            md5 = null;
        }
        String absolutePath = BuildConfig.FLAVOR;
        if (file == null) {
            return null;
        }
        try {
            if (!file.exists()) {
                return null;
            }
            new File(file2, IL1Iii.IL1Iii(new byte[]{9, 10, 87}, IL1Iii.IL1Iii(new byte[]{81, 90, 4, 84, 85, 0}, IL1Iii.IL1Iii(new byte[]{7, 0, 6, 84, 6, 0}, "397a23")))).mkdirs();
            int iM1189iILLl = lIlii.m1189iILLl();
            String strIL1Iii = BuildConfig.FLAVOR;
            if (iM1189iILLl == 1) {
                strIL1Iii = IL1Iii.IL1Iii(new byte[]{85, 70, 84, 82, 0, 87, 93, 25, 79, 0, 0}, IL1Iii.IL1Iii(new byte[]{81, 0, 95, 15, 81, 3}, IL1Iii.IL1Iii(new byte[]{80, 82, 3, 93, 4, 2}, "5fee44")));
            } else if (iM1189iILLl == 2) {
                strIL1Iii = IL1Iii.IL1Iii(new byte[]{88, 65, 85, 3, 6, 28, 79, 11, 89}, IL1Iii.IL1Iii(new byte[]{93, 10, 15, 4, 11, 80}, IL1Iii.IL1Iii(new byte[]{85, 93, 6, 2, 12, 3}, "1d135b")));
            } else if (iM1189iILLl == 3) {
                strIL1Iii = IL1Iii.IL1Iii(new byte[]{30, 91, 87}, IL1Iii.IL1Iii(new byte[]{87, 7, 3, 6, 82, 7}, IL1Iii.IL1Iii(new byte[]{2, 86, 90, 1, 4, 2}, "328472")));
            } else if (iM1189iILLl == 4) {
                strIL1Iii = IL1Iii.IL1Iii(new byte[]{29, 12, 85, 62, 83, 6}, IL1Iii.IL1Iii(new byte[]{3, 81, 83, 4, 93, 3}, IL1Iii.IL1Iii(new byte[]{95, 87, 86, 80, 12, 2}, "92f543")));
            }
            try {
                if (iM1189iILLl != 1) {
                    lIlii.m11961(file.getAbsolutePath(), IL1Iii.IL1Iii(new byte[]{15, 93, 1, 27}, IL1Iii.IL1Iii(new byte[]{6, 6, 7, 0, 94, 84}, IL1Iii.IL1Iii(new byte[]{86, 83, 80, 87, 2, 6}, "3a4cd0"))) + strIL1Iii, file2.getAbsolutePath());
                    str2 = file2.getAbsolutePath() + IL1Iii.IL1Iii(new byte[]{77, 9, 90, 0, 29}, IL1Iii.IL1Iii(new byte[]{0, 82, 7, 4, 10, 12}, IL1Iii.IL1Iii(new byte[]{87, 2, 4, 7, 15, 13}, "550a74"))) + strIL1Iii;
                } else {
                    if (!lIlii.m11961(file.getAbsolutePath(), IL1Iii.IL1Iii(new byte[]{13, 11, 6, 28, 89, 75, 12, 7, 5, 81, 81, 20, 23, 85, 5}, IL1Iii.IL1Iii(new byte[]{89, 83, 82, 3, 0, 10}, IL1Iii.IL1Iii(new byte[]{12, 0, 4, 8, 9, 82}, "41281a"))), file2.getAbsolutePath())) {
                        if (lIlii.m11961(file.getAbsolutePath(), IL1Iii.IL1Iii(new byte[]{13, 94, 0, 24, 87, 68, 12, 82, 3, 85, 95}, IL1Iii.IL1Iii(new byte[]{81, 82, 1, 6, 84, 85}, IL1Iii.IL1Iii(new byte[]{84, 92, 6, 3, 80, 1}, "d9e22b"))), file2.getAbsolutePath())) {
                            str2 = file2.getAbsolutePath() + IL1Iii.IL1Iii(new byte[]{23, 89, 91, 82, 22, 81, 74, 88, 87, 81, 91, 89}, IL1Iii.IL1Iii(new byte[]{9, 12, 6, 82, 15, 8}, IL1Iii.IL1Iii(new byte[]{80, 12, 7, 3, 83, 92}, "a53aed")));
                        }
                        if (TextUtils.isEmpty(absolutePath)) {
                            absolutePath = file2.getAbsolutePath();
                        }
                        fileM1015IL = l1IIi1.I1I().m1015IL();
                        if (fileM1015IL != null) {
                            if (absolutePath != null) {
                                absolutePath = absolutePath + IL1Iii.IL1Iii(new byte[]{14}, IL1Iii.IL1Iii(new byte[]{12, 7, 85, 90, 7, 83}, IL1Iii.IL1Iii(new byte[]{92, 1, 94, 1, 0, 85}, "d58bf1"))) + fileM1015IL.getAbsolutePath();
                            } else {
                                absolutePath = fileM1015IL.getAbsolutePath();
                            }
                        }
                        ApkLoader apkLoader = new ApkLoader(file.getAbsolutePath(), new DexClassLoader(file.getAbsolutePath(), file2.getAbsolutePath(), absolutePath, f3442IL1Iii.getClassLoader()));
                        f3443ILil.put(md5, apkLoader);
                        return apkLoader;
                    }
                    str2 = file2.getAbsolutePath() + IL1Iii.IL1Iii(new byte[]{78, 90, 13, 3, 74, 2, 19, 91, 1, 0, 7, 10, 76, 64, 83, 0}, IL1Iii.IL1Iii(new byte[]{4, 7, 82, 2, 4, 81}, IL1Iii.IL1Iii(new byte[]{0, 80, 6, 82, 87, 84}, "ea016f")));
                }
                if (TextUtils.isEmpty(absolutePath)) {
                    absolutePath = file2.getAbsolutePath();
                }
                fileM1015IL = l1IIi1.I1I().m1015IL();
                if (fileM1015IL != null) {
                    if (absolutePath != null) {
                        absolutePath = absolutePath + IL1Iii.IL1Iii(new byte[]{14}, IL1Iii.IL1Iii(new byte[]{12, 7, 85, 90, 7, 83}, IL1Iii.IL1Iii(new byte[]{92, 1, 94, 1, 0, 85}, "d58bf1"))) + fileM1015IL.getAbsolutePath();
                    } else {
                        absolutePath = fileM1015IL.getAbsolutePath();
                    }
                }
                ApkLoader apkLoader2 = new ApkLoader(file.getAbsolutePath(), new DexClassLoader(file.getAbsolutePath(), file2.getAbsolutePath(), absolutePath, f3442IL1Iii.getClassLoader()));
                f3443ILil.put(md5, apkLoader2);
                return apkLoader2;
            } catch (Exception e7) {
                Log.i(IL1Iii.IL1Iii(new byte[]{120, 59}, IL1Iii.IL1Iii(new byte[]{87, 6, 80, 1, 86, 10}, IL1Iii.IL1Iii(new byte[]{83, 4, 0, 81, 87, 92}, "2aaa2d"))), e7.toString());
                return null;
            }
            absolutePath = str2;
        } catch (Exception e8) {
            Log.i(IL1Iii.IL1Iii(new byte[]{122, 96}, IL1Iii.IL1Iii(new byte[]{81, 9, 15, 7, 13, 84}, IL1Iii.IL1Iii(new byte[]{80, 80, 15, 0, 93, 82}, "5a91e4"))), e8.toString());
        }
    }
}
