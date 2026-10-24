package com.main.engine;

import I1I.I1I.ILil.L11I;
import I1I.I1I.ILil.iI;
import I1I.I1I.ILil.iILLl;
import I1I.I1I.p000IL.IiL;
import I1I.I1I.p000IL.lIlii;
import I1I.IL1Iii;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.flexbox.BuildConfig;
import com.nx.assist.lua.IOnExitCallBack;
import com.nx.assist.lua.LuaEngine;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Engine {
    private static Map<Integer, String> mCacheStr = new HashMap();
    private static Map<Integer, Long> mCacheLong = new HashMap();
    private static IOnExitCallBack mOnExitCallBack = null;

    private static boolean extractApkAssets(String str, String str2) {
        try {
            return lIlii.m355L1l(lIlii.m340lIII(), IL1Iii.IL1Iii(new byte[]{4, 74, 71, 87, 70, 22, 74, 75, 81, 65, 29}, IL1Iii.IL1Iii(new byte[]{80, 10, 81, 11, 5, 4}, IL1Iii.IL1Iii(new byte[]{81, 5, 81, 14, 83, 84}, "d647d5"))) + str, str2, str);
        } catch (Exception e) {
            IiL.I1I(IL1Iii.IL1Iii(new byte[]{124, 105}, IL1Iii.IL1Iii(new byte[]{83, 82, 81, 6, 5, 11}, IL1Iii.IL1Iii(new byte[]{0, 82, 83, 1, 2, 85}, "a11b2f"))), IL1Iii.IL1Iii(new byte[]{82, 65, 65, 74, 86, 1, 67, 120, 69, 83, 118, 17, 68, 92, 65, 75, 23, 7, 69, 75, 8, 6}, IL1Iii.IL1Iii(new byte[]{85, 91, 87, 11, 85, 1}, IL1Iii.IL1Iii(new byte[]{83, 86, 85, 7, 82, 82}, "147401"))) + e.toString());
            return false;
        }
    }

    public static native int init(Object obj, Object obj2, Object obj3);

    public static boolean installLR(String str) {
        try {
            return L11I.I11L().m104LlLLL(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isMatch(String str, String str2) {
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        return str != null && str.matches(str2);
    }

    public static int obtainImage(int[] iArr, int[] iArr2, int[] iArr3) {
        try {
            return L11I.I11L().m106l1IIi1(iArr, iArr2, iArr3);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static byte[] obtainImageBytes(int i, int i2, int i3, int i4, int i5, int i6) {
        Bitmap bitmapSnapShot = LuaEngine.snapShot(i, i2, i3, i4);
        if (bitmapSnapShot != null) {
            return lIlii.m374Lii(bitmapSnapShot, i5, i6);
        }
        return null;
    }

    public static String obtainXml(long j) {
        Bundle bundleM110l = L11I.I11L().m110l();
        return bundleM110l != null ? lIlii.m335iLl(bundleM110l) : BuildConfig.FLAVOR;
    }

    public static void onExitCallBack(boolean z, int i) {
        Log.i(IL1Iii.IL1Iii(new byte[]{119, 58}, IL1Iii.IL1Iii(new byte[]{88, 84, 4, 0, 85, 2}, IL1Iii.IL1Iii(new byte[]{86, 85, 15, 4, 82, 4}, "7c91b5"))), IL1Iii.IL1Iii(new byte[]{14, 94, 116, 74, 13, 76, 34, 81, 93, 94, 38, 89, 2, 91, 25}, IL1Iii.IL1Iii(new byte[]{0, 85, 7, 80, 7, 1}, IL1Iii.IL1Iii(new byte[]{7, 87, 80, 84, 81, 12}, "f2f625"))) + mOnExitCallBack + IL1Iii.IL1Iii(new byte[]{3}, IL1Iii.IL1Iii(new byte[]{14, 7, 87, 83, 6, 81}, IL1Iii.IL1Iii(new byte[]{2, 2, 7, 85, 82, 3}, "4a24e3"))) + z + IL1Iii.IL1Iii(new byte[]{25}, IL1Iii.IL1Iii(new byte[]{7, 0, 7, 4, 15, 84}, IL1Iii.IL1Iii(new byte[]{4, 82, 85, 87, 93, 82}, "614feb"))) + i + IL1Iii.IL1Iii(new byte[]{75}, IL1Iii.IL1Iii(new byte[]{86, 0, 81, 83, 6, 81}, IL1Iii.IL1Iii(new byte[]{3, 14, 85, 82, 7, 91}, "77ecb9"))));
        IOnExitCallBack iOnExitCallBack = mOnExitCallBack;
        if (iOnExitCallBack != null) {
            iOnExitCallBack.onExitCallback(z, i);
        }
    }

    public static native void onTouchEvent(int i, int i2, int i3, int i4, int i5);

    public static native String paddleOcr(Object obj);

    public static native int pause();

    public static void printLog(int i, String str, String str2) {
        try {
            L11I.I11L().m114(i, str, str2);
        } catch (Exception unused) {
        }
    }

    public static void registerExitCallback(IOnExitCallBack iOnExitCallBack) {
        mOnExitCallBack = iOnExitCallBack;
    }

    public static native void reset();

    public static boolean restart() {
        try {
            return L11I.I11L().m98IIi();
        } catch (Exception unused) {
            return false;
        }
    }

    public static native int resume();

    public static native String sendEvent(int i, int i2, String str);

    public static long sendEventWithLong(int i, int i2, int i3, String str, String str2) throws Throwable {
        int iM294IiILI;
        if (i == 1) {
            return System.currentTimeMillis();
        }
        if (i == 2) {
            if (i2 != 6) {
                if (i2 == 7) {
                    iM294IiILI = lIlii.LLii1I(i3 == 1);
                } else if (i2 == 5) {
                    if (lIlii.m353IlL1ll1()) {
                        iM294IiILI = lIlii.m294IiILI(i3 == 1);
                    }
                } else if (i2 == 9 && L11I.I11L().LL1IL() && lIlii.m353IlL1ll1()) {
                    String strM282IL11L = lIlii.m282IL11L(str);
                    return (strM282IL11L == null || !strM282IL11L.equals(IL1Iii.IL1Iii(new byte[]{8}, IL1Iii.IL1Iii(new byte[]{90, 93, 92, 90, 80, 5}, IL1Iii.IL1Iii(new byte[]{81, 92, 0, 92, 13, 85}, "298d84"))))) ? 0L : 1L;
                }
                return iM294IiILI;
            }
            if (lIlii.m353IlL1ll1()) {
                lIlii.L11LlL(i3 == 1);
            }
            if (i2 >= 9) {
                String strIlil = L11I.I11L().Ilil(10, i2, i3, str);
                if (strIlil != null) {
                    try {
                        return Long.valueOf(Long.parseLong(strIlil)).longValue();
                    } catch (Exception unused) {
                    }
                }
                return 0L;
            }
            synchronized (mCacheLong) {
                if (i2 == 1) {
                    Long l = mCacheLong.get(Integer.valueOf(i2));
                    if (l != null) {
                        return l.longValue();
                    }
                }
                String strIlil2 = L11I.I11L().Ilil(10, i2, i3, str);
                if (strIlil2 != null) {
                    try {
                        Long lValueOf = Long.valueOf(Long.parseLong(strIlil2));
                        if (i2 == 1) {
                            mCacheLong.put(Integer.valueOf(i2), lValueOf);
                        }
                        return lValueOf.longValue();
                    } catch (Exception unused2) {
                    }
                }
            }
        }
        return 0L;
    }

    /* JADX WARN: Code duplicated, block: B:175:0x05a5 A[Catch: all -> 0x05cd, DONT_GENERATE, TryCatch #1 {, blocks: (B:173:0x0597, B:175:0x05a5, B:178:0x05a9, B:184:0x05c2, B:185:0x05cb, B:181:0x05b1, B:182:0x05b6), top: B:196:0x0597 }] */
    /* JADX WARN: Code duplicated, block: B:177:0x05a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:178:0x05a9 A[Catch: all -> 0x05cd, TryCatch #1 {, blocks: (B:173:0x0597, B:175:0x05a5, B:178:0x05a9, B:184:0x05c2, B:185:0x05cb, B:181:0x05b1, B:182:0x05b6), top: B:196:0x0597 }] */
    /* JADX WARN: Code duplicated, block: B:179:0x05ae  */
    /* JADX WARN: Code duplicated, block: B:181:0x05b1 A[Catch: all -> 0x05cd, TryCatch #1 {, blocks: (B:173:0x0597, B:175:0x05a5, B:178:0x05a9, B:184:0x05c2, B:185:0x05cb, B:181:0x05b1, B:182:0x05b6), top: B:196:0x0597 }] */
    /* JADX WARN: Code duplicated, block: B:182:0x05b6 A[Catch: all -> 0x05cd, TryCatch #1 {, blocks: (B:173:0x0597, B:175:0x05a5, B:178:0x05a9, B:184:0x05c2, B:185:0x05cb, B:181:0x05b1, B:182:0x05b6), top: B:196:0x0597 }] */
    /* JADX WARN: Code duplicated, block: B:184:0x05c2 A[Catch: all -> 0x05cd, TryCatch #1 {, blocks: (B:173:0x0597, B:175:0x05a5, B:178:0x05a9, B:184:0x05c2, B:185:0x05cb, B:181:0x05b1, B:182:0x05b6), top: B:196:0x0597 }] */
    /* JADX WARN: Code duplicated, block: B:196:0x0597 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String sendEventWithString(int i, int i2, int i3, String str, String str2) {
        String string;
        String strLlI;
        String name;
        String str3;
        String strIlil;
        if (i == 2) {
            return lIlii.LlLI1(str, str2);
        }
        if (i == 3) {
            return lIlii.ILL(str, str2);
        }
        if (i == 5) {
            String strM3471 = lIlii.m3471(str);
            return strM3471 == null ? str2 : strM3471;
        }
        if (i != 6) {
            return BuildConfig.FLAVOR;
        }
        if (i2 == 6) {
            return lIlii.m358i11LL(IL1Iii.IL1Iii(new byte[]{93, 23, 68, 69, 92, 75, 26, 20, 71, 66, 72, 6, 84, 10, 84, 64, 72, 7, 90, 14}, IL1Iii.IL1Iii(new byte[]{81, 85, 3, 81, 86, 1}, IL1Iii.IL1Iii(new byte[]{87, 4, 2, 93, 85, 7}, "3219eb"))));
        }
        if (i2 == 7) {
            if (!L11I.I11L().LL1IL()) {
                return lIlii.iIi1(str, 0L, i3 == 1);
            }
            if (lIlii.m353IlL1ll1()) {
                return lIlii.iIi1(str, 0L, i3 == 1);
            }
            return L11I.I11L().Ilil(11, i2, i3, str);
        }
        if (i2 == 9) {
            if (!lIlii.m353IlL1ll1()) {
                if (i3 == 1) {
                    iILLl.IL1Iii(str);
                    return BuildConfig.FLAVOR;
                }
                iILLl.ILil();
                return BuildConfig.FLAVOR;
            }
            try {
                File file = new File(L11I.I11L().m109lL(), IL1Iii.IL1Iii(new byte[]{-40, -44, -67, -47, -39, -14, 31, 19, 92, 68}, IL1Iii.IL1Iii(new byte[]{1, 5, 1, 2, 6, 91}, IL1Iii.IL1Iii(new byte[]{83, 86, 12, 83, 7, 88}, "b24fba"))));
                File file2 = new File(str);
                if (file2.getParentFile().getAbsolutePath().compareTo(file.getAbsolutePath()) == 0) {
                    name = file2.getName();
                }
            } catch (Exception unused) {
            }
            synchronized (mCacheStr) {
                str3 = mCacheStr.get(Integer.valueOf(i2));
                if (str3 != null) {
                    return str3;
                }
                if (i2 == 1) {
                    strIlil = lIlii.I1IILIIL();
                } else if (i2 == 2) {
                    strIlil = lIlii.m373LLlI1();
                } else {
                    strIlil = L11I.I11L().Ilil(11, i2, i3, name);
                }
                if (strIlil != null) {
                    mCacheStr.put(Integer.valueOf(i2), strIlil);
                }
                return strIlil;
            }
        }
        if (i2 == 13) {
            return lIlii.LiL1();
        }
        if (i2 >= 10) {
            if (i2 != 11) {
                if (i2 == 12) {
                    if (lIlii.m353IlL1ll1()) {
                        lIlii.iIi1(IL1Iii.IL1Iii(new byte[]{82, 8, 70, 95, 13, 19, 80, 0, 75, 74, 22, 14, 67, 69}, IL1Iii.IL1Iii(new byte[]{87, 83, 85, 11, 90, 89}, IL1Iii.IL1Iii(new byte[]{5, 1, 0, 4, 10, 92}, "a7362d"))) + str, 5000L, true);
                        return IL1Iii.IL1Iii(new byte[]{6}, IL1Iii.IL1Iii(new byte[]{83, 86, 82, 1, 93, 83}, IL1Iii.IL1Iii(new byte[]{7, 83, 85, 7, 6, 86}, "cfa0c3")));
                    }
                } else if (i2 == 15) {
                    if (lIlii.m353IlL1ll1()) {
                        return lIlii.m308LlLiLL();
                    }
                } else if (i2 == 16) {
                    if (lIlii.m353IlL1ll1()) {
                        return lIlii.iI();
                    }
                } else if (i2 == 17) {
                    if (lIlii.m353IlL1ll1()) {
                        return BuildConfig.FLAVOR + lIlii.m334iLI(str);
                    }
                } else if (i2 == 18) {
                    if (lIlii.m353IlL1ll1() && (strLlI = lIlii.llI()) != null) {
                        return strLlI;
                    }
                } else if (i2 == 19) {
                    if (lIlii.m353IlL1ll1()) {
                        return lIlii.m285IiL(str) ? IL1Iii.IL1Iii(new byte[]{9}, IL1Iii.IL1Iii(new byte[]{0, 5, 82, 88, 13, 5}, IL1Iii.IL1Iii(new byte[]{11, 4, 4, 88, 3, 85}, "333963"))) : IL1Iii.IL1Iii(new byte[]{9}, IL1Iii.IL1Iii(new byte[]{8, 81, 87, 84, 2, 86}, IL1Iii.IL1Iii(new byte[]{82, 82, 2, 10, 87, 81}, "cff8c5")));
                    }
                } else if (i2 == 20) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (TextUtils.isEmpty(str)) {
                            return IL1Iii.IL1Iii(new byte[]{0}, IL1Iii.IL1Iii(new byte[]{82, 87, 5, 7, 94, 81}, IL1Iii.IL1Iii(new byte[]{85, 0, 0, 3, 84, 7}, "7c7622")));
                        }
                        jSONObject.put(IL1Iii.IL1Iii(new byte[]{8, 71, 85, 3, 85, 65}, IL1Iii.IL1Iii(new byte[]{3, 2, 15, 87, 3, 4}, IL1Iii.IL1Iii(new byte[]{80, 81, 4, 80, 81, 83}, "5a3fbd"))), str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put(IL1Iii.IL1Iii(new byte[]{82, 86, 89, 17, 83, 94, 69}, IL1Iii.IL1Iii(new byte[]{6, 0, 86, 92, 3, 3}, IL1Iii.IL1Iii(new byte[]{15, 0, 86, 90, 1, 85}, "897c4f"))), str2);
                        }
                        string = jSONObject.toString();
                    } catch (Exception unused2) {
                        string = str;
                    }
                } else {
                    if (i2 == 34) {
                        return obtainXml(10000L);
                    }
                    if (i2 == 42) {
                        return extractApkAssets(str, str2) ? IL1Iii.IL1Iii(new byte[]{87}, IL1Iii.IL1Iii(new byte[]{80, 94, 90, 81, 10, 3}, IL1Iii.IL1Iii(new byte[]{14, 84, 93, 7, 82, 9}, "82eba9"))) : IL1Iii.IL1Iii(new byte[]{82}, IL1Iii.IL1Iii(new byte[]{3, 1, 0, 3, 5, 2}, IL1Iii.IL1Iii(new byte[]{3, 81, 83, 0, 8, 8}, "baaf98")));
                    }
                    if (i2 == 37 || i2 == 40 || i2 == 41 || i2 == 43 || i2 == 46) {
                        Bundle bundleIlil = iI.Ilil(i2, i3, str, 10000L);
                        return bundleIlil != null ? Integer.toString(bundleIlil.getInt(IL1Iii.IL1Iii(new byte[]{64, 86, 76}, IL1Iii.IL1Iii(new byte[]{81, 87, 12, 4, 3, 92}, IL1Iii.IL1Iii(new byte[]{87, 81, 80, 7, 87, 90}, "45decb"))))) : IL1Iii.IL1Iii(new byte[]{85}, IL1Iii.IL1Iii(new byte[]{4, 2, 9, 5, 2, 1}, IL1Iii.IL1Iii(new byte[]{4, 1, 2, 4, 11, 86}, "ee238b")));
                    }
                    if (i2 == 47) {
                        Bundle bundleIlil2 = iI.Ilil(i2, i3, str, 60000L);
                        return bundleIlil2 != null ? Integer.toString(bundleIlil2.getInt(IL1Iii.IL1Iii(new byte[]{64, 93, 18}, IL1Iii.IL1Iii(new byte[]{81, 92, 7, 1, 3, 5}, IL1Iii.IL1Iii(new byte[]{81, 7, 83, 85, 4, 1}, "2c2172"))))) : IL1Iii.IL1Iii(new byte[]{82}, IL1Iii.IL1Iii(new byte[]{3, 81, 91, 95, 81, 3}, IL1Iii.IL1Iii(new byte[]{84, 87, 11, 82, 80, 7}, "5634bf")));
                    }
                }
                string = str;
            } else {
                if (lIlii.m353IlL1ll1() && i3 == 1) {
                    if (str2.length() > 0) {
                        lIlii.iIi1(IL1Iii.IL1Iii(new byte[]{83, 12, 25, 71, 76, 88, 64, 21, 25, 25, 86, 25}, IL1Iii.IL1Iii(new byte[]{0, 5, 88, 12, 13, 1}, IL1Iii.IL1Iii(new byte[]{84, 1, 4, 14, 12, 14}, "fee696"))) + str + IL1Iii.IL1Iii(new byte[]{24}, IL1Iii.IL1Iii(new byte[]{84, 2, 84, 81, 7, 7}, IL1Iii.IL1Iii(new byte[]{81, 9, 82, 80, 85, 7}, "290ec3"))) + str2, 5000L, true);
                    } else {
                        lIlii.iIi1(IL1Iii.IL1Iii(new byte[]{20, 84, 12, 94, 92, 92, 77, 25, 78, 64, 23}, IL1Iii.IL1Iii(new byte[]{5, 1, 84, 3, 5, 91}, IL1Iii.IL1Iii(new byte[]{2, 0, 2, 0, 3, 84}, "385316"))) + str + IL1Iii.IL1Iii(new byte[]{24, 31, 86, 66, 84, 13, 92, 64, 90, 11, 81, 77, 81, 92, 65, 7, 91, 23, 22, 81, 84, 22, 80, 4, 87, 64, 76, 76, 121, 34, 109, 124, 118, 42, 112, 49, 24, 3}, IL1Iii.IL1Iii(new byte[]{15, 86, 6, 1, 4, 0}, IL1Iii.IL1Iii(new byte[]{6, 7, 4, 1, 4, 86}, "1c7b55"))), 5000L, true);
                    }
                    return IL1Iii.IL1Iii(new byte[]{7}, IL1Iii.IL1Iii(new byte[]{4, 85, 0, 8, 89, 81}, IL1Iii.IL1Iii(new byte[]{83, 5, 85, 14, 90, 86}, "a576be")));
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject2.put(IL1Iii.IL1Iii(new byte[]{20, 82, 86}, IL1Iii.IL1Iii(new byte[]{0, 14, 9, 4, 13, 81}, IL1Iii.IL1Iii(new byte[]{5, 15, 12, 3, 15, 86}, "a84670"))), str);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject2.put(IL1Iii.IL1Iii(new byte[]{80, 92, 71}, IL1Iii.IL1Iii(new byte[]{2, 3, 82, 86, 2, 14}, IL1Iii.IL1Iii(new byte[]{4, 86, 83, 82, 83, 8}, "5e5fe1"))), str2);
                    }
                } catch (Exception unused3) {
                }
                string = jSONObject2.toString();
            }
            return L11I.I11L().Ilil(11, i2, i3, string);
        }
        name = str;
        synchronized (mCacheStr) {
            str3 = mCacheStr.get(Integer.valueOf(i2));
            if (str3 != null) {
                return str3;
            }
            if (i2 == 1) {
                strIlil = lIlii.I1IILIIL();
            } else if (i2 == 2) {
                strIlil = lIlii.m373LLlI1();
            } else {
                strIlil = L11I.I11L().Ilil(11, i2, i3, name);
            }
            if (strIlil != null) {
                mCacheStr.put(Integer.valueOf(i2), strIlil);
            }
            return strIlil;
        }
    }

    public static boolean sendKeyEvent(int i, int i2) {
        try {
            return L11I.I11L().sendKeyEvent(i, i2);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean sendTouchEvent(int i, int i2, int i3, int i4) {
        try {
            return L11I.I11L().sendTouchEvent(i, i2, i3, i4);
        } catch (Exception unused) {
            return false;
        }
    }

    public static native void setDisplayInfo(int i, int i2, int i3, int i4, int i5);

    public static native void setWorkPath(String str, String str2);

    public static native int start(long j, int i, String str, String str2);

    public static void startCatchPoint() {
        L11I.I11L().m107lIII();
    }
}
