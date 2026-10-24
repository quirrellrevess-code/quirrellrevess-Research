package com.main.engine;

import I1I.I1I.ILil.L11I;
import I1I.I1I.ILil.l1IIi1;
import I1I.I1I.p000IL.lIlii;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.nx.assist.lua.LuaEngine;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ScriptMain {
    private static L11I mCoreScript;
    private static Handler mMainHandler;

    public static class IL1Iii implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            ScriptMain.mCoreScript.m102LlIl();
        }
    }

    public static void main(String[] strArr) {
        Log.i(I1I.IL1Iii.IL1Iii(new byte[]{120, 97}, I1I.IL1Iii.IL1Iii(new byte[]{87, 91, 15, 2, 83, 81}, I1I.IL1Iii.IL1Iii(new byte[]{86, 6, 91, 87, 5, 1}, "7db1a3"))), I1I.IL1Iii.IL1Iii(new byte[]{91, 11, 91, 12, 13, 95, 91, 11, 91, 12, 13, 95, 91, 11, 91, 92, 81, 11, 8, 11, 91, 12, 13, 95, 91, 11, 91, 12, 13, 95, 91, 11, 91, 12, 13, 95, 91, 11, 91}, I1I.IL1Iii.IL1Iii(new byte[]{85, 14, 5, 3, 6, 80}, I1I.IL1Iii.IL1Iii(new byte[]{85, 15, 7, 5, 84, 0}, "f7d7b2"))));
        try {
            int i = Integer.parseInt(strArr[0]);
            int i2 = Integer.parseInt(strArr[1]);
            int i3 = Integer.parseInt(strArr[2]);
            String str = strArr[3];
            String str2 = strArr[4];
            String str3 = strArr[5];
            lIlii.m371IiL(str2);
            lIlii.m372I(str);
            lIlii.l1ILIl(i2);
            if (i == 1) {
                lIlii.LLIIllII(str, str + I1I.IL1Iii.IL1Iii(new byte[]{9, 71, 84}, I1I.IL1Iii.IL1Iii(new byte[]{6, 1, 82, 3, 93, 0}, I1I.IL1Iii.IL1Iii(new byte[]{6, 6, 83, 4, 85, 9}, "336a00"))));
            }
            if (Looper.getMainLooper() == null) {
                Looper.prepareMainLooper();
            } else {
                Looper.prepare();
            }
            if (i == 1) {
                lIlii.ILil();
                LuaEngine.Init(lIlii.lI1I1());
                l1IIi1.I1I().m183Ll1(lIlii.lI1I1());
                Map<String, String> map = System.getenv();
                if (map != null) {
                    String str4 = map.get(I1I.IL1Iii.IL1Iii(new byte[]{55, 112, 54, 102, 102}, I1I.IL1Iii.IL1Iii(new byte[]{85, 88, 83, 12, 80, 10}, I1I.IL1Iii.IL1Iii(new byte[]{0, 89, 82, 84, 85, 11}, "48ea48"))));
                    String str5 = map.get(I1I.IL1Iii.IL1Iii(new byte[]{110, 126, 49, 110, 41}, I1I.IL1Iii.IL1Iii(new byte[]{14, 3, 85, 3, 7, 0}, I1I.IL1Iii.IL1Iii(new byte[]{4, 87, 5, 4, 7, 12}, "2c36a9"))));
                    try {
                        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
                            lIlii.I1LilL(Integer.parseInt(str4), Integer.parseInt(str5));
                        }
                    } catch (Exception unused) {
                    }
                    String str6 = map.get(I1I.IL1Iii.IL1Iii(new byte[]{32, 44, 55, 96, 111, 52}, I1I.IL1Iii.IL1Iii(new byte[]{2, 84, 0, 0, 85, 81}, I1I.IL1Iii.IL1Iii(new byte[]{86, 0, 7, 1, 83, 81}, "01c16c"))));
                    String str7 = map.get(I1I.IL1Iii.IL1Iii(new byte[]{38, 42, 97, 49, 108, 121}, I1I.IL1Iii.IL1Iii(new byte[]{84, 86, 1, 4, 5, 4}, I1I.IL1Iii.IL1Iii(new byte[]{3, 87, 86, 86, 4, 87}, "5be32b"))));
                    try {
                        if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str7)) {
                            lIlii.LLlIiil(Integer.parseInt(str6), Integer.parseInt(str7));
                        }
                    } catch (Exception unused2) {
                    }
                }
            }
            mCoreScript = new L11I(i, i2, i3, str, str2, str3);
            Handler handler = new Handler();
            mMainHandler = handler;
            handler.post(new IL1Iii());
            Looper.loop();
        } catch (Exception unused3) {
        }
    }
}
