package com.p000nx.uiauto.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class VolumeChangeObserver extends BroadcastReceiver {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final String f5426I1I = I1I.IL1Iii.IL1Iii(new byte[]{80, 95, 6, 69, 10, 90, 85, 31, 15, 82, 1, 90, 80, 31, 52, 120, 41, 102, 124, 116, 61, 116, 45, 114, 127, 118, 39, 115, 58, 114, 114, 101, 43, 120, 43}, I1I.IL1Iii.IL1Iii(new byte[]{5, 8, 6, 86, 85, 4}, I1I.IL1Iii.IL1Iii(new byte[]{81, 88, 0, 5, 82, 86}, "eaddba")));

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public long f5427IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public List<IL1Iii> f5428ILil = new ArrayList();

    public interface IL1Iii {
        void IL1Iii();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (!intent.getAction().equals(f5426I1I) || System.currentTimeMillis() - this.f5427IL1Iii < 400) {
            return;
        }
        this.f5427IL1Iii = System.currentTimeMillis();
        Iterator<IL1Iii> it = this.f5428ILil.iterator();
        while (it.hasNext()) {
            it.next().IL1Iii();
        }
    }
}
