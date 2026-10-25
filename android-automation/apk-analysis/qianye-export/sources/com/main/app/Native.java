package com.main.app;

import I1I.I1I.ILil.IIi;
import I1I.I1I.ILil.LIl;
import I1I.I1I.ILil.iIilII1;
import I1I.I1I.p008IL.L11I;
import I1I.IL1Iii;
import android.content.Context;
import android.graphics.Bitmap;
import com.google.android.flexbox.BuildConfig;
import com.main.engine.RotateMgr;
import com.tencent.smtt.sdk.TbsListener;
import java.io.ByteArrayOutputStream;
import p051lLi1LL.ILil.IL1Iii.I1I;

/* JADX INFO: loaded from: classes.dex */
public class Native {
    public static native boolean checkIsDebug();

    public static native int checkProxy();

    public static native boolean chmod(String str);

    public static native boolean chmodExe(String str);

    public static native boolean connectService(String str, int i, boolean z);

    public static native boolean createSymbolicLink(String str, String str2);

    public static native int getNativeType();

    public static String getNodeXml(int i) {
        return iIilII1.LLL().m9iI(i);
    }

    public static native String getResult(String str, String str2, String str3);

    public static int getVersion() {
        return TbsListener.ErrorCode.EXCEED_UNZIP_RETRY_NUM;
    }

    public static native int init(Context context);

    public static native int initNative();

    public static String onEvent(int i, String str, String str2) {
        if ((i < 1 || i >= 4) && i != 7) {
            return i == 4 ? L11I.I1I() : BuildConfig.FLAVOR;
        }
        I1I.I1I().ILL(new IIi(i, str, str2));
        return IL1Iii.IL1Iii(new byte[]{4}, IL1Iii.IL1Iii(new byte[]{12, 82, 95, 6, 84, 81}, IL1Iii.IL1Iii(new byte[]{9, 6, 5, 4, 92, 8}, "06c488")));
    }

    public static byte[] onSnapShot(int i, int i2, int i3) {
        return iIilII1.LLL().m975LIl(i2, i3);
    }

    public static native int registerDebugService(int i);

    public static native int registerService();

    public static native int runRootEngine(Context context, int i, int i2, int i3, int i4, int i5);

    public static native boolean sendEvent(int i, int i2, String str, String str2);

    public static Bitmap snapShot(int i, int i2, int i3) {
        return LIl.m903ILl(i, i2, RotateMgr.m3485IL().IL1Iii());
    }

    public static byte[] snapShotFile(int i, int i2, int i3, int i4, int i5) {
        Bitmap bitmapM903ILl = LIl.m903ILl(i, i2, RotateMgr.m3485IL().IL1Iii());
        if (bitmapM903ILl == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (i4 == 0) {
                bitmapM903ILl.compress(Bitmap.CompressFormat.PNG, i5, byteArrayOutputStream);
            } else {
                bitmapM903ILl.compress(Bitmap.CompressFormat.JPEG, i5, byteArrayOutputStream);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception unused) {
            return null;
        } finally {
            if (bitmapM903ILl != null && !bitmapM903ILl.isRecycled()) {
                bitmapM903ILl.recycle();
            }
        }
    }

    public static native boolean takeCaptureFile(String str, int i, int i2, int i3);

    public static native int unZip(String str, String str2);

    public static native int unZipFd(int i, String str);
}
