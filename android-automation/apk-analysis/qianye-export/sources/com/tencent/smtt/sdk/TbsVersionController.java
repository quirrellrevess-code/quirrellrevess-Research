package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.p004a.C0444a;

/* JADX INFO: loaded from: classes.dex */
public class TbsVersionController {

    /* JADX INFO: renamed from: a */
    private static IntervalChoice f380a = IntervalChoice.SIX_HOUR;

    public interface CallBack {
        void canLocalVersionUsed(int i, boolean z);

        void latestVersion(int i);
    }

    public enum IntervalChoice {
        TEN_MINUTE(600000),
        HALF_HOUR(1800000),
        ONE_HOUR(3600000),
        SIX_HOUR(21600000),
        TWELVE_HOUR(43200000);

        public final int value;

        IntervalChoice(int i) {
            this.value = i;
        }
    }

    public static void checkVersion(Context context, CallBack callBack) {
        throw new C0444a();
    }

    public static void setCheckInterval(IntervalChoice intervalChoice) {
        throw new UnsupportedOperationException("Current TBS SDK doesn't support");
    }
}
