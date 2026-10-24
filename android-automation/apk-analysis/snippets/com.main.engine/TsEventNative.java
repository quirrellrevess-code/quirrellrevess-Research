package com.main.engine;

import I1I.I1I.ILil.LL1IL;
import android.os.IBinder;
import android.util.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class TsEventNative {
    private static final String TAG = I1I.IL1Iii.IL1Iii(new byte[]{55, 66, 33, 20, 93, 89, 23, 127, 5, 22, 81, 65, 6}, I1I.IL1Iii.IL1Iii(new byte[]{86, 85, 82, 86, 15, 7}, I1I.IL1Iii.IL1Iii(new byte[]{4, 81, 85, 80, 0, 4}, "15cd74")));
    private static Map<Integer, LL1IL> listeners = new ConcurrentHashMap();

    public static class IL1Iii implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ int f4464IL1Iii;

        public IL1Iii(int i) {
            this.f4464IL1Iii = i;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            TsEventNative.removeITsEventListener(this.f4464IL1Iii);
        }
    }

    public static synchronized void onEvent(int i, int i2, int i3, int i4, int i5) {
        Iterator<Map.Entry<Integer, LL1IL>> it = listeners.entrySet().iterator();
        while (it.hasNext()) {
            LL1IL value = it.next().getValue();
            try {
                if (value.asBinder().isBinderAlive()) {
                    value.mo79L11I(i, i2, i3, i4, i5);
                } else {
                    it.remove();
                }
            } catch (Exception e) {
                Log.e(TAG, I1I.IL1Iii.IL1Iii(new byte[]{34, 87, 12, 15, 0, 82, 68, 66, 10, 67, 12, 88, 18, 89, 14, 6, 69, 89, 10, 115, 19, 6, 11, 66, 94, 22}, I1I.IL1Iii.IL1Iii(new byte[]{82, 85, 6, 87, 7, 82}, I1I.IL1Iii.IL1Iii(new byte[]{87, 85, 80, 0, 4, 85}, "a634f1"))) + e.getMessage());
            }
        }
    }

    public static synchronized void removeITsEventListener(int i) {
        listeners.remove(Integer.valueOf(i));
    }

    public static synchronized void setITsEventListener(int i, LL1IL ll1il) {
        try {
            ll1il.asBinder().linkToDeath(new IL1Iii(i), 0);
            listeners.put(Integer.valueOf(i), ll1il);
        } catch (Exception e) {
            Log.e(TAG, I1I.IL1Iii.IL1Iii(new byte[]{119, 89, 88, 15, 83, 87, 17, 76, 94, 67, 90, 90, 95, 83, 17, 23, 89, 19, 85, 93, 80, 23, 94, 9, 17}, I1I.IL1Iii.IL1Iii(new byte[]{1, 15, 82, 83, 80, 11}, I1I.IL1Iii.IL1Iii(new byte[]{5, 6, 81, 85, 94, 1}, "512e89"))) + e.getMessage());
        }
    }

    public static native void start();
}
