package com.tencent.smtt.sdk;

import android.content.Context;
import com.google.android.flexbox.BuildConfig;
import com.tencent.smtt.utils.TbsLog;

/* JADX INFO: loaded from: classes.dex */
public class TbsCoreLoadStat {
    public static final int ERROR_CODE_INIT = -1;

    /* JADX INFO: renamed from: a */
    private static TbsCoreLoadStat f287a = null;
    public static String mErrorMessage = "";
    public static volatile int mLoadErrorCode = -1;

    private TbsCoreLoadStat() {
    }

    public static TbsCoreLoadStat getInstance() {
        if (f287a == null) {
            f287a = new TbsCoreLoadStat();
        }
        return f287a;
    }

    public static int getLoadErrorCode() {
        return mLoadErrorCode;
    }

    public static String getLoadErrorMessage() {
        return mErrorMessage;
    }

    /* JADX INFO: renamed from: a */
    public void m175a(Context context, int i) {
        TbsLog.m662e(TbsListener.tag_load_error, BuildConfig.FLAVOR + i);
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m176a(Context context, int i, Throwable th) {
        String str;
        String str2;
        TbsLog.m662e("TbsCoreLoadStat", "[loadError] errorCode: " + i + ", details:" + String.valueOf(th));
        if (th != null) {
            if (mLoadErrorCode == -1) {
                mLoadErrorCode = i;
                mErrorMessage = String.valueOf(th);
                TbsLogReport.getInstance(context).setLoadErrorCode(i, th);
                str = "TbsCoreLoadStat";
                str2 = mLoadErrorCode + " report success!";
            } else {
                str = "TbsCoreLoadStat";
                str2 = mLoadErrorCode + " is reported, others will be saved in local TbsLog!";
            }
            TbsLog.m665i(str, str2);
        }
    }
}
