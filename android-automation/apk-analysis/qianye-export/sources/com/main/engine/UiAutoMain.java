package com.main.engine;

import I1I.I1I.ILil.RunnableC0000I;
import I1I.I1I.ILil.iILilI;
import I1I.I1I.p008IL.lIlii;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.flexbox.BuildConfig;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class UiAutoMain {
    private static Handler mMainHandler;
    private static RunnableC0000I mUiAutoProxy;

    public static class IL1Iii implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            UiAutoMain.mUiAutoProxy.m887lIlii();
        }
    }

    public static void main(String[] strArr) {
        String str;
        Looper.prepareMainLooper();
        String str2 = BuildConfig.FLAVOR;
        Map<String, String> map = System.getenv();
        try {
            str = map.get(I1I.IL1Iii.IL1Iii(new byte[]{49, 115, 35}, I1I.IL1Iii.IL1Iii(new byte[]{81, 8, 84, 6, 87, 14}, I1I.IL1Iii.IL1Iii(new byte[]{9, 83, 86, 3, 13, 5}, "9cf092"))));
            try {
                String str3 = str + I1I.IL1Iii.IL1Iii(new byte[]{8, 84, 65, 66, 9}, I1I.IL1Iii.IL1Iii(new byte[]{2, 0, 3, 7, 87, 1}, I1I.IL1Iii.IL1Iii(new byte[]{6, 81, 85, 1, 83, 83}, "6db0bc")));
                lIlii.m1199I(str);
                lIlii.LLIIllII(str, str3);
                String str4 = map.get(I1I.IL1Iii.IL1Iii(new byte[]{100, 112, 107, 62, 54}, I1I.IL1Iii.IL1Iii(new byte[]{5, 15, 9, 5, 85, 0}, I1I.IL1Iii.IL1Iii(new byte[]{82, 0, 1, 87, 6, 85}, "e6132e"))));
                String str5 = map.get(I1I.IL1Iii.IL1Iii(new byte[]{53, 120, 98, 61, 127}, I1I.IL1Iii.IL1Iii(new byte[]{1, 84, 84, 91, 1, 6}, I1I.IL1Iii.IL1Iii(new byte[]{83, 92, 80, 0, 5, 6}, "194933"))));
                String str6 = map.get(I1I.IL1Iii.IL1Iii(new byte[]{115, 112, 48, 52, 103, 49}, I1I.IL1Iii.IL1Iii(new byte[]{7, 15, 1, 82, 92, 80}, I1I.IL1Iii.IL1Iii(new byte[]{5, 14, 1, 80, 0, 84}, "58cfdb"))));
                String str7 = map.get(I1I.IL1Iii.IL1Iii(new byte[]{33, 43, 100, 98, 104, 45}, I1I.IL1Iii.IL1Iii(new byte[]{4, 87, 2, 81, 15, 81}, I1I.IL1Iii.IL1Iii(new byte[]{84, 87, 83, 83, 8, 3}, "5bf007"))));
                try {
                    if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
                        lIlii.I1LilL(Integer.parseInt(str4), Integer.parseInt(str5));
                    }
                } catch (Exception unused) {
                }
                try {
                    if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str7)) {
                        lIlii.LLlIiil(Integer.parseInt(str6), Integer.parseInt(str7));
                    }
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                str2 = str;
                str = str2;
            }
        } catch (Exception unused4) {
        }
        mUiAutoProxy = new RunnableC0000I(str);
        mMainHandler = new Handler();
        iILilI.I1I();
        mMainHandler.post(new IL1Iii());
        Looper.loop();
    }
}
