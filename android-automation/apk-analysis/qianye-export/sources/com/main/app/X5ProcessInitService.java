package com.main.app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.tencent.smtt.sdk.QbSdk;

/* JADX INFO: loaded from: classes.dex */
public class X5ProcessInitService extends Service {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final String f5351ILil = I1I.IL1Iii.IL1Iii(new byte[]{111, 3, 54, 75, 10, 86, 82, 69, 21, 112, 11, 92, 67, 101, 3, 75, 19, 92, 84, 83}, I1I.IL1Iii.IL1Iii(new byte[]{5, 80, 0, 1, 82, 4}, I1I.IL1Iii.IL1Iii(new byte[]{84, 86, 82, 15, 0, 4}, "f04775")));

    public class IL1Iii implements QbSdk.PreInitCallback {
        public IL1Iii(X5ProcessInitService x5ProcessInitService) {
        }

        @Override // com.tencent.smtt.sdk.QbSdk.PreInitCallback
        public void onCoreInitFinished() {
        }

        @Override // com.tencent.smtt.sdk.QbSdk.PreInitCallback
        public void onViewInitFinished(boolean z) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{62, 3, 99, 67, 14, 85, 3, 69, 64, 120, 15, 95, 18, 101, 86, 67, 23, 95, 5, 83}, I1I.IL1Iii.IL1Iii(new byte[]{94, 15, 87, 7, 85, 84}, I1I.IL1Iii.IL1Iii(new byte[]{93, 90, 92, 87, 4, 80}, "ec8a02"))), I1I.IL1Iii.IL1Iii(new byte[]{8, 11, 10, 70, 69, 22, 4, 7, 67, 66, 23, 14, 2, 0, 16, 65, 69, 25, 84, 95, 67}, I1I.IL1Iii.IL1Iii(new byte[]{4, 3, 84, 0, 80, 2}, I1I.IL1Iii.IL1Iii(new byte[]{0, 7, 6, 1, 3, 6}, "ea136e"))) + z);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Log.i(f5351ILil, I1I.IL1Iii.IL1Iii(new byte[]{98, 0, 64, 68, 93, 82, 84, 69, 125, 92, 118, 88, 95, 1}, I1I.IL1Iii.IL1Iii(new byte[]{9, 86, 1, 10, 81, 83}, I1I.IL1Iii.IL1Iii(new byte[]{1, 80, 11, 0, 85, 7}, "9c880e"))));
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        QbSdk.preInit(getApplicationContext(), new IL1Iii(this));
    }
}
