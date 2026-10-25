package com.main.engine;

import I1I.I1I.ILil.li11;
import I1I.I1I.p008IL.lIlii;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ScriptProxy {
    private static Handler mMainHandler;
    private static li11 mProxy;

    public static class IL1Iii implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            li11 unused = ScriptProxy.mProxy = new li11(lIlii.LiL1());
            ScriptProxy.mProxy.iIlLiL();
        }
    }

    public static void main(String[] strArr) {
        try {
            int i = Integer.parseInt(strArr[0]);
            String str = strArr[1];
            String str2 = strArr[2];
            lIlii.m1199I(str);
            lIlii.l1ILIl(i);
            lIlii.m1135LL(str, str2, i);
            Map<String, String> map = System.getenv();
            if (map != null) {
                String str3 = map.get(I1I.IL1Iii.IL1Iii(new byte[]{103, 120, 106, 61, 54}, I1I.IL1Iii.IL1Iii(new byte[]{2, 0, 8, 1, 88, 90}, I1I.IL1Iii.IL1Iii(new byte[]{7, 82, 4, 90, 0, 6}, "4c499e"))));
                String str4 = map.get(I1I.IL1Iii.IL1Iii(new byte[]{101, 43, 106, 107, 120}, I1I.IL1Iii.IL1Iii(new byte[]{86, 80, 11, 6, 5, 13}, I1I.IL1Iii.IL1Iii(new byte[]{86, 2, 4, 5, 5, 84}, "30770a"))));
                try {
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                        lIlii.I1LilL(Integer.parseInt(str3), Integer.parseInt(str4));
                    }
                } catch (Exception unused) {
                }
                String str5 = map.get(I1I.IL1Iii.IL1Iii(new byte[]{38, 113, 107, 50, 61, 97}, I1I.IL1Iii.IL1Iii(new byte[]{1, 91, 11, 80, 3, 0}, I1I.IL1Iii.IL1Iii(new byte[]{86, 83, 1, 83, 87, 7}, "502a61"))));
                String str6 = map.get(I1I.IL1Iii.IL1Iii(new byte[]{39, 112, 107, 103, 111, 125}, I1I.IL1Iii.IL1Iii(new byte[]{86, 12, 0, 3, 86, 13}, I1I.IL1Iii.IL1Iii(new byte[]{84, 2, 92, 81, 0, 11}, "a7def3"))));
                try {
                    if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                        lIlii.LLlIiil(Integer.parseInt(str5), Integer.parseInt(str6));
                    }
                } catch (Exception unused2) {
                }
            }
            lIlii.LLIIllII(str, str + I1I.IL1Iii.IL1Iii(new byte[]{10, 22, 75, 94, 30, 65}, I1I.IL1Iii.IL1Iii(new byte[]{4, 84, 88, 7, 4, 89}, I1I.IL1Iii.IL1Iii(new byte[]{1, 83, 2, 1, 81, 3}, "5ac73b"))));
            if (Looper.getMainLooper() == null) {
                Looper.prepareMainLooper();
            } else {
                Looper.prepare();
            }
            Handler handler = new Handler();
            mMainHandler = handler;
            handler.post(new IL1Iii());
            Looper.loop();
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{42, 62}, I1I.IL1Iii.IL1Iii(new byte[]{6, 85, 14, 85, 14, 5}, I1I.IL1Iii.IL1Iii(new byte[]{0, 7, 3, 11, 3, 83}, "b44845"))), e.toString());
        }
    }
}
