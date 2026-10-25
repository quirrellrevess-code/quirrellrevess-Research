package com.tencent.smtt.sdk;

import I1I.p019lLi1LL.IL1Iii.IL1Iii.IL1Iii.ILil;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes.dex */
public class TbsVideo {
    public static boolean canUseTbsPlayer(Context context) {
        return C0422p.m475a(context).m478a();
    }

    public static boolean canUseYunbo(Context context) {
        return C0422p.m475a(context).m478a() && QbSdk.canUseVideoFeatrue(context, 1);
    }

    public static void openVideo(Context context, String str) {
        openVideo(context, str, null);
    }

    public static void openVideo(Context context, String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            Log.e("TbsVideo", "videoUrl is empty!");
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("videoUrl", str);
        Intent intent = new Intent("com.tencent.smtt.tbs.video.PLAY");
        intent.setFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
        intent.setPackage(context.getPackageName());
        intent.putExtra("extraData", bundle);
        context.startActivity(intent);
    }

    public static boolean openYunboVideo(Context context, String str, Bundle bundle, ILil iLil) {
        if (canUseYunbo(context)) {
            return C0422p.m475a(context).m479a(str, bundle, iLil);
        }
        return false;
    }
}
