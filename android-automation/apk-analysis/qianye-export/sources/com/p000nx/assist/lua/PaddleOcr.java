package com.p000nx.assist.lua;

import I1I.I1I.ILil.L11I;
import I1I.I1I.p008IL.lIlii;
import I1I.IL1Iii;
import android.graphics.Bitmap;
import com.google.android.flexbox.BuildConfig;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PaddleOcr {
    private static boolean bLoaded = false;
    private static PaddleOcr sInstance;

    public class Obj {
        public String label;
        public float prob;

        /* JADX INFO: renamed from: x0 */
        public int f87x0;

        /* JADX INFO: renamed from: x1 */
        public int f88x1;

        /* JADX INFO: renamed from: x2 */
        public int f89x2;

        /* JADX INFO: renamed from: y0 */
        public int f90y0;

        /* JADX INFO: renamed from: y1 */
        public int f91y1;

        public Obj() {
        }
    }

    public static String detect(int i, int i2, int i3, int i4) {
        JSONArray jSONArray = new JSONArray();
        Bitmap bitmapSnapShot = LuaEngine.snapShot(i, i2, i3, i4);
        if (bitmapSnapShot == null) {
            return jSONArray.toString();
        }
        String strDetect = detect(bitmapSnapShot, i, i2);
        if (!bitmapSnapShot.isRecycled()) {
            bitmapSnapShot.recycle();
        }
        return strDetect;
    }

    public static String detectWithPadding(Bitmap bitmap, int i, int i2, int i3, int i4) {
        return detect(bitmap, 0, 0, i, i2, i3, i4);
    }

    private static boolean loadModeImp(boolean z, String str, String str2, String str3, String str4, String str5) {
        if (!bLoaded) {
            if (!new File(str).exists() || !new File(str).exists() || !new File(str3).exists() || !new File(str5).exists()) {
                return false;
            }
            if (!z && !new File(str4).exists()) {
                return false;
            }
            if (lIlii.m1143L1l() == null) {
                String strLlliI = L11I.I11L().llliI();
                File file = new File(lIlii.m1172lIII());
                lIlii.m1194llI11I(strLlliI, file, IL1Iii.IL1Iii(new byte[]{9, 89, 84, 86, 2, 8, 11, 30, 69, 87}, IL1Iii.IL1Iii(new byte[]{4, 5, 6, 93, 7, 86}, IL1Iii.IL1Iii(new byte[]{80, 5, 2, 3, 2, 6}, "102fd6"))), lIlii.m1189iILLl(), false, true, true);
                lIlii.m1194llI11I(strLlliI, file, IL1Iii.IL1Iii(new byte[]{15, 80, 7, 21, 88, 0, 7, 85, 0, 10, 90, 22, 77, 74, 10}, IL1Iii.IL1Iii(new byte[]{80, 1, 85, 4, 91, 85}, IL1Iii.IL1Iii(new byte[]{7, 13, 6, 5, 4, 80}, "456dfa"))), lIlii.m1189iILLl(), false, true, true);
            } else {
                System.loadLibrary(IL1Iii.IL1Iii(new byte[]{10, 87, 90, 86}, IL1Iii.IL1Iii(new byte[]{84, 4, 12, 11, 10, 87}, IL1Iii.IL1Iii(new byte[]{82, 84, 10, 86, 2, 0}, "bd2e02"))));
                System.loadLibrary(IL1Iii.IL1Iii(new byte[]{68, 2, 1, 92, 95, 87, 91, 0, 23}, IL1Iii.IL1Iii(new byte[]{80, 91, 86, 1, 11, 6}, IL1Iii.IL1Iii(new byte[]{5, 0, 85, 88, 92, 85}, "a8fada"))));
            }
            bLoaded = true;
        }
        if (sInstance == null) {
            sInstance = new PaddleOcr();
        }
        try {
            return sInstance.nativeLoadMode(Obj.class, str, str2, str3, str4, str5, z);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean loadModel(boolean z) {
        File fileI11li1 = L11I.I11L().I11li1();
        if (z) {
            File file = new File(fileI11li1, IL1Iii.IL1Iii(new byte[]{68, 85, 82, 87, 85, 4}, IL1Iii.IL1Iii(new byte[]{81, 6, 3, 3, 91, 83}, IL1Iii.IL1Iii(new byte[]{7, 84, 12, 1, 84, 2}, "bf9160"))));
            return loadOnnxModel(new File(file, IL1Iii.IL1Iii(new byte[]{80, 92, 77, 22, 11, 10, 90, 65}, IL1Iii.IL1Iii(new byte[]{4, 93, 88, 91, 83, 92}, IL1Iii.IL1Iii(new byte[]{7, 2, 88, 87, 3, 94}, "7f944f")))).getAbsolutePath(), new File(file, IL1Iii.IL1Iii(new byte[]{1, 88, 22, 23, 14, 90, 12, 76}, IL1Iii.IL1Iii(new byte[]{0, 81, 85, 13, 80, 86}, IL1Iii.IL1Iii(new byte[]{90, 87, 0, 13, 1, 90}, "820908")))).getAbsolutePath(), new File(file, IL1Iii.IL1Iii(new byte[]{19, 85, 83, 24, 88, 13, 15, 72}, IL1Iii.IL1Iii(new byte[]{82, 3, 86, 5, 2, 7}, IL1Iii.IL1Iii(new byte[]{11, 11, 4, 6, 86, 0}, "88b5cd")))).getAbsolutePath(), new File(file, IL1Iii.IL1Iii(new byte[]{95, 6, 72, 21, 28, 76, 76, 23}, IL1Iii.IL1Iii(new byte[]{0, 5, 80, 87, 84, 90}, IL1Iii.IL1Iii(new byte[]{86, 94, 7, 5, 7, 83}, "b8f4a1")))).getAbsolutePath());
        }
        File file2 = new File(fileI11li1, IL1Iii.IL1Iii(new byte[]{17, 0, 0, 86, 13, 84}, IL1Iii.IL1Iii(new byte[]{83, 81, 82, 83, 84, 83}, IL1Iii.IL1Iii(new byte[]{6, 82, 84, 86, 13, 0}, "4bb78b"))));
        return loadNnccModel(new File(file2, IL1Iii.IL1Iii(new byte[]{82, 80, 77, 22, 67, 82, 68, 84, 84}, IL1Iii.IL1Iii(new byte[]{80, 2, 9, 11, 81, 7}, IL1Iii.IL1Iii(new byte[]{94, 82, 84, 1, 81, 87}, "8ed23c")))).getAbsolutePath(), new File(file2, IL1Iii.IL1Iii(new byte[]{71, 81, 84, 79, 22, 82, 71, 85, 90}, IL1Iii.IL1Iii(new byte[]{80, 80, 3, 85, 5, 11}, IL1Iii.IL1Iii(new byte[]{80, 92, 6, 81, 91, 9}, "582e81")))).getAbsolutePath(), new File(file2, IL1Iii.IL1Iii(new byte[]{93, 87, 21, 74, 81, 8, 87}, IL1Iii.IL1Iii(new byte[]{8, 2, 7, 6, 87, 88}, IL1Iii.IL1Iii(new byte[]{82, 1, 7, 0, 2, 11}, "c1abf2")))).getAbsolutePath(), new File(file2, IL1Iii.IL1Iii(new byte[]{74, 93, 1, 72, 84, 80, 86}, IL1Iii.IL1Iii(new byte[]{15, 15, 91, 7, 0, 90}, IL1Iii.IL1Iii(new byte[]{0, 0, 14, 81, 15, 5}, "77709f")))).getAbsolutePath(), new File(file2, IL1Iii.IL1Iii(new byte[]{88, 92, 31, 75, 25, 69, 75, 77}, IL1Iii.IL1Iii(new byte[]{6, 11, 85, 11, 4, 4}, IL1Iii.IL1Iii(new byte[]{4, 2, 7, 85, 87, 1}, "104fd4")))).getAbsolutePath());
    }

    public static boolean loadNnccModel(String str, String str2, String str3, String str4, String str5) {
        return loadModeImp(false, str, str2, str3, str4, str5);
    }

    public static boolean loadOnnxModel(String str, String str2, String str3, String str4) {
        return loadModeImp(true, str, str2, str3, BuildConfig.FLAVOR, str4);
    }

    public native Obj[] nativeDetect(Bitmap bitmap, int i, int i2, int i3, int i4, int i5, int i6);

    public native boolean nativeLoadMode(Class cls, String str, String str2, String str3, String str4, String str5, boolean z);

    public static String detect(Bitmap bitmap) {
        return detect(bitmap, 0, 0, 50, 255, 255, 255);
    }

    public static String detect(Bitmap bitmap, int i, int i2) {
        return detect(bitmap, i, i2, 50, 255, 255, 255);
    }

    public static String detect(Bitmap bitmap, int i, int i2, int i3, int i4, int i5, int i6) {
        Obj[] objArrNativeDetect;
        JSONArray jSONArray = new JSONArray();
        PaddleOcr paddleOcr = sInstance;
        if (paddleOcr != null && (objArrNativeDetect = paddleOcr.nativeDetect(bitmap, i, i2, i3, i4, i5, i6)) != null) {
            int i7 = 0;
            for (Obj obj : objArrNativeDetect) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(IL1Iii.IL1Iii(new byte[]{27}, IL1Iii.IL1Iii(new byte[]{2, 83, 7, 81, 2, 0}, IL1Iii.IL1Iii(new byte[]{87, 81, 12, 0, 82, 3}, "6494d5"))), obj.f87x0);
                    jSONObject.put(IL1Iii.IL1Iii(new byte[]{28}, IL1Iii.IL1Iii(new byte[]{3, 89, 2, 8, 83, 0}, IL1Iii.IL1Iii(new byte[]{94, 89, 82, 2, 84, 12}, "88d318"))), obj.f90y0);
                    jSONObject.put(IL1Iii.IL1Iii(new byte[]{21}, IL1Iii.IL1Iii(new byte[]{87, 0, 80, 84, 2, 3}, IL1Iii.IL1Iii(new byte[]{2, 1, 83, 0, 80, 82}, "717fa4"))), obj.f88x1 - obj.f87x0);
                    jSONObject.put(IL1Iii.IL1Iii(new byte[]{14}, IL1Iii.IL1Iii(new byte[]{0, 87, 5, 92, 1, 82}, IL1Iii.IL1Iii(new byte[]{94, 15, 9, 1, 95, 5}, "899df2"))), obj.f91y1 - obj.f90y0);
                    jSONObject.put(IL1Iii.IL1Iii(new byte[]{90, 87, 90, 3, 90}, IL1Iii.IL1Iii(new byte[]{4, 6, 0, 4, 85, 86}, IL1Iii.IL1Iii(new byte[]{80, 6, 15, 81, 91, 82}, "b67381"))), obj.label);
                    jSONObject.put(IL1Iii.IL1Iii(new byte[]{20, 71, 86, 85}, IL1Iii.IL1Iii(new byte[]{0, 1, 10, 7, 83, 6}, IL1Iii.IL1Iii(new byte[]{86, 86, 3, 3, 5, 93}, "2b03a9"))), obj.prob);
                    int i8 = i7 + 1;
                    try {
                        jSONArray.put(i7, jSONObject);
                    } catch (Exception unused) {
                    }
                    i7 = i8;
                } catch (Exception unused2) {
                }
            }
        }
        return jSONArray.toString();
    }
}
