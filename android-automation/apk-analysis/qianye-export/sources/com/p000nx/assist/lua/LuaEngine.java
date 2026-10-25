package com.p000nx.assist.lua;

import I1I.I1I.ILil.l1IIi1;
import I1I.I1I.p008IL.lIlii;
import I1I.IL1Iii;
import I1I.p062Ilil.p063IL1Iii.I1I.I1I;
import I1I.p062Ilil.p063IL1Iii.I1I.lLi1LL;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.main.engine.Engine;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import p047IL.C0007;
import p047IL.L111;
import p047IL.L1l;
import p047IL.iILLl;

/* JADX INFO: loaded from: classes.dex */
public class LuaEngine {
    private static Context mContext;
    private static Handler mHandler;
    private static Object mPlugin;
    private static String mResPath;

    public static void Init(Context context) {
        if (mContext == null) {
            mContext = context;
            mHandler = new Handler(Looper.getMainLooper());
            lLi1LL.IL1Iii(context);
        }
    }

    public static Context getContext() {
        return mContext;
    }

    public static Drawable getDrawableFromBitmap(Bitmap bitmap) {
        return new BitmapDrawable(bitmap);
    }

    public static Drawable getImageDrawable(String str) {
        return l1IIi1.I1I().ILil(str);
    }

    public static Object getPluginApp() {
        return mPlugin;
    }

    public static String getResPath() {
        return l1IIi1.I1I().IL1Iii().getAbsolutePath();
    }

    public static String httpGet(String str, Map<String, String> map) {
        return lIlii.m1191ili(str, map, 30L);
    }

    public static String httpGetTimeout(String str, int i) {
        return lIlii.m1191ili(str, new HashMap(), i);
    }

    public static String httpPost(String str, Map<String, String> map, Map<String, String> map2) {
        return lIlii.m1136Li1IL1(str, map, map2, 30L);
    }

    public static String httpPostData(String str, String str2, String str3, long j) {
        try {
            L111 l111M2866IL = L111.m2866IL(str3);
            C0007.ILil iLil = new C0007.ILil();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            iLil.ILil(j, timeUnit);
            iLil.m2981lLi1LL(j, timeUnit);
            iLil.Ilil(j, timeUnit);
            C0007 c0007IL1Iii = iLil.IL1Iii();
            iILLl iilllCreate = iILLl.create(l111M2866IL, String.valueOf(str2));
            L1l.IL1Iii iL1Iii = new L1l.IL1Iii();
            iL1Iii.m2878L11I(str);
            iL1Iii.m2880lLi1LL(iilllCreate);
            return c0007IL1Iii.IL1Iii(iL1Iii.ILil()).execute().m2846IiL().string();
        } catch (Exception e) {
            Log.i(IL1Iii.IL1Iii(new byte[]{122, 105}, IL1Iii.IL1Iii(new byte[]{81, 7, 84, 83, 5, 0}, IL1Iii.IL1Iii(new byte[]{82, 3, 0, 1, 87, 87}, "75ddc6"))), e.toString());
            return null;
        }
    }

    public static String httpPostTimeout(String str, String str2, int i) {
        try {
            C0007 c0007 = new C0007();
            iILLl iilllCreate = iILLl.create(L111.m2866IL(IL1Iii.IL1Iii(new byte[]{2, 21, 17, 10, 91, 0, 2, 17, 8, 9, 92, 76, 9, 22, 14, 8, 9, 0, 11, 4, 19, 21, 87, 23, 94, 16, 21, 0, 31, 91}, IL1Iii.IL1Iii(new byte[]{84, 3, 0, 81, 5, 90}, IL1Iii.IL1Iii(new byte[]{2, 7, 85, 15, 0, 12}, "5a4875")))), str2);
            L1l.IL1Iii iL1Iii = new L1l.IL1Iii();
            iL1Iii.m2878L11I(str);
            iL1Iii.m2880lLi1LL(iilllCreate);
            return c0007.IL1Iii(iL1Iii.ILil()).execute().m2846IiL().string();
        } catch (Exception e) {
            Log.i(IL1Iii.IL1Iii(new byte[]{121, 104}, IL1Iii.IL1Iii(new byte[]{1, 5, 84, 0, 12, 94}, IL1Iii.IL1Iii(new byte[]{85, 83, 80, 8, 0, 13}, "cff095"))), e.toString());
            return null;
        }
    }

    public static ApkLoader loadApk(String str) {
        return lLi1LL.ILil(str);
    }

    public static void registerExitCallback(IOnExitCallBack iOnExitCallBack) {
        Engine.registerExitCallback(iOnExitCallBack);
    }

    public static void registerPluginApp(Object obj) {
        mPlugin = obj;
    }

    public static void releaseBmp(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (bitmap.isRecycled()) {
                    return;
                }
                bitmap.recycle();
            } catch (Exception unused) {
            }
        }
    }

    public static void runOnUIThread(Runnable runnable) {
        mHandler.post(runnable);
    }

    public static void sendMail(String str, String str2, String str3, String str4, boolean z, String str5, String str6) {
        sendMail(str, str2, str3, str4, z, str5, str6, null);
    }

    public static void sendMailWithFile(String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7) {
        sendMailWithFile(str, str2, str3, str4, z, str5, str6, str7, null);
    }

    public static void sendMailWithMultiFile(String str, String str2, String str3, String str4, boolean z, String str5, String str6, String[] strArr) {
        sendMailWithMultiFile(str, str2, str3, str4, z, str5, str6, strArr, null);
    }

    public static Bitmap snapShot(int i, int i2, int i3, int i4) {
        return LuaNative.snapShotJava(i, i2, i3, i4);
    }

    public static String httpGet(String str, Map<String, String> map, long j) {
        return lIlii.m1191ili(str, map, j);
    }

    public static String httpPost(String str, Map<String, String> map, Map<String, String> map2, long j) {
        return lIlii.m1136Li1IL1(str, map, map2, j);
    }

    public static void sendMail(String str, String str2, String str3, String str4, boolean z, String str5, String str6, IOnMailResult iOnMailResult) {
        I1I.m1229IL().Ilil(str, str2, str3, str4, z, str5, str6, iOnMailResult);
    }

    public static void sendMailWithFile(String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, IOnMailResult iOnMailResult) {
        try {
            I1I.m1229IL().m1231lLi1LL(str, str2, str3, str4, z, str5, str6, str7, iOnMailResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendMailWithMultiFile(String str, String str2, String str3, String str4, boolean z, String str5, String str6, String[] strArr, IOnMailResult iOnMailResult) {
        try {
            I1I.m1229IL().m1230iILLL1(str, str2, str3, str4, z, str5, str6, Arrays.asList(strArr), iOnMailResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
