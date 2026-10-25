package com.p000nx.assist.lua;

import I1I.I1I.ILil.L11I;
import I1I.I1I.p008IL.lIlii;
import I1I.IL1Iii;
import android.graphics.Bitmap;
import android.util.Log;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class YoloV5 {
    private static boolean bInit = false;
    private static boolean bLoaded = false;
    private static YoloV5 mYolov5Instance;

    public class Obj {

        /* JADX INFO: renamed from: h */
        public float f92h;
        public String label;
        public float prob;

        /* JADX INFO: renamed from: w */
        public float f93w;

        /* JADX INFO: renamed from: x */
        public float f94x;

        /* JADX INFO: renamed from: y */
        public float f95y;

        public Obj() {
        }
    }

    public static String detect(Bitmap bitmap, boolean z) {
        Obj[] objArrNativeDetect;
        JSONArray jSONArray = new JSONArray();
        YoloV5 yoloV5 = mYolov5Instance;
        if (yoloV5 != null && (objArrNativeDetect = yoloV5.nativeDetect(bitmap, z)) != null) {
            int i = 0;
            for (Obj obj : objArrNativeDetect) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(IL1Iii.IL1Iii(new byte[]{78}, IL1Iii.IL1Iii(new byte[]{80, 85, 83, 12, 83, 80}, IL1Iii.IL1Iii(new byte[]{3, 80, 80, 7, 9, 13}, "e25399"))), obj.f94x);
                    jSONObject.put(IL1Iii.IL1Iii(new byte[]{78}, IL1Iii.IL1Iii(new byte[]{85, 83, 4, 6, 0, 0}, IL1Iii.IL1Iii(new byte[]{4, 0, 81, 82, 82, 82}, "f1b1f4"))), obj.f95y);
                    jSONObject.put(IL1Iii.IL1Iii(new byte[]{78}, IL1Iii.IL1Iii(new byte[]{15, 5, 7, 3, 3, 12}, IL1Iii.IL1Iii(new byte[]{15, 0, 7, 87, 4, 8}, "960560"))), obj.f93w);
                    jSONObject.put(IL1Iii.IL1Iii(new byte[]{95}, IL1Iii.IL1Iii(new byte[]{85, 6, 3, 89, 87, 83}, IL1Iii.IL1Iii(new byte[]{4, 80, 2, 90, 84, 87}, "f37ba2"))), obj.f92h);
                    jSONObject.put(IL1Iii.IL1Iii(new byte[]{85, 85, 4, 92, 14}, IL1Iii.IL1Iii(new byte[]{12, 12, 3, 10, 7, 12}, IL1Iii.IL1Iii(new byte[]{4, 13, 1, 10, 92, 80}, "15d99e"))), obj.label);
                    jSONObject.put(IL1Iii.IL1Iii(new byte[]{72, 66, 9, 87}, IL1Iii.IL1Iii(new byte[]{92, 81, 95, 13, 6, 10}, IL1Iii.IL1Iii(new byte[]{83, 3, 90, 14, 80, 14}, "7bc647"))), obj.prob);
                    int i2 = i + 1;
                    try {
                        jSONArray.put(i, jSONObject);
                    } catch (Exception unused) {
                    }
                    i = i2;
                } catch (Exception unused2) {
                }
            }
        }
        return jSONArray.toString();
    }

    public static boolean init(String str, String str2, String str3) {
        if (!bLoaded) {
            if (lIlii.m1143L1l() == null) {
                String strLlliI = L11I.I11L().llliI();
                File file = new File(lIlii.m1172lIII());
                lIlii.m1194llI11I(strLlliI, file, IL1Iii.IL1Iii(new byte[]{10, 8, 0, 8, 91, 10, 8, 79, 17, 9}, IL1Iii.IL1Iii(new byte[]{84, 5, 86, 7, 11, 2}, IL1Iii.IL1Iii(new byte[]{0, 81, 13, 86, 87, 5}, "2597dc"))), lIlii.m1189iILLl(), false, true, true);
                lIlii.m1194llI11I(strLlliI, file, IL1Iii.IL1Iii(new byte[]{88, 92, 82, 75, 87, 9, 91, 27, 67, 93}, IL1Iii.IL1Iii(new byte[]{7, 86, 82, 2, 9, 0}, IL1Iii.IL1Iii(new byte[]{86, 6, 81, 86, 0, 6}, "ee3f1c"))), lIlii.m1189iILLl(), false, true, true);
            } else {
                System.loadLibrary(IL1Iii.IL1Iii(new byte[]{89, 91, 87, 86}, IL1Iii.IL1Iii(new byte[]{15, 12, 90, 8, 87, 7}, IL1Iii.IL1Iii(new byte[]{93, 2, 91, 8, 81, 5}, "e68821"))));
                System.loadLibrary(IL1Iii.IL1Iii(new byte[]{78, 88, 89, 87}, IL1Iii.IL1Iii(new byte[]{15, 3, 86, 15, 93, 91}, IL1Iii.IL1Iii(new byte[]{0, 0, 80, 5, 93, 1}, "8432dc"))));
            }
            bLoaded = true;
        }
        if (mYolov5Instance == null) {
            mYolov5Instance = new YoloV5();
        }
        try {
            return mYolov5Instance.nativeInit(Obj.class, str, str2, str3);
        } catch (Exception e) {
            Log.i(IL1Iii.IL1Iii(new byte[]{110, 90, 91, 93, 53, 12}, IL1Iii.IL1Iii(new byte[]{83, 6, 15, 4, 86, 90}, IL1Iii.IL1Iii(new byte[]{7, 87, 94, 0, 84, 2}, "cdf6aa"))), e.toString());
            e.printStackTrace();
            return false;
        }
    }

    public native Obj[] nativeDetect(Bitmap bitmap, boolean z);

    public native boolean nativeInit(Class cls, String str, String str2, String str3);
}
