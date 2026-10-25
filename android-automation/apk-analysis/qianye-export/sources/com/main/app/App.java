package com.main.app;

import I1I.I1I.p008IL.lIlii;
import I1I.IL1Iii;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.qyzs.smn2.R;
import com.tencent.smtt.sdk.QbSdk;
import java.util.HashMap;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes.dex */
public class App extends Application implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static App f5265I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Activity f5266ILil;

    static {
        System.loadLibrary(IL1Iii.IL1Iii(new byte[]{85, 28, 74, 108, 22, 91, 87, 69, 4, 87}, IL1Iii.IL1Iii(new byte[]{14, 82, 83, 7, 80, 87}, IL1Iii.IL1Iii(new byte[]{89, 86, 86, 81, 5, 0}, "a3de0d"))));
        System.loadLibrary(IL1Iii.IL1Iii(new byte[]{94, 85, 18, 11, 18, 86}, IL1Iii.IL1Iii(new byte[]{82, 1, 2, 84, 92, 85}, IL1Iii.IL1Iii(new byte[]{84, 80, 5, 1, 91, 5}, "6ea7cc"))));
        System.loadLibrary(IL1Iii.IL1Iii(new byte[]{91, 95, 3, 66, 17, 94, 94, 65}, IL1Iii.IL1Iii(new byte[]{7, 86, 80, 81, 84, 5}, IL1Iii.IL1Iii(new byte[]{81, 81, 2, 81, 80, 1}, "d567a3"))));
        f5265I1I = null;
    }

    public static App ILil() {
        return f5265I1I;
    }

    public void I1I() {
        if (getResources().getInteger(R.integer.is_autorun) == 1) {
            Intent intent = new Intent(this, (Class<?>) MainService.class);
            intent.putExtra(IL1Iii.IL1Iii(new byte[]{85, 7, 68, 12, 87, 8}, IL1Iii.IL1Iii(new byte[]{81, 7, 9, 80, 89, 2}, IL1Iii.IL1Iii(new byte[]{81, 90, 91, 81, 3, 85}, "49bdb1"))), IL1Iii.IL1Iii(new byte[]{71, 65, 85, 71, 17}, IL1Iii.IL1Iii(new byte[]{81, 6, 6, 83, 86, 9}, IL1Iii.IL1Iii(new byte[]{4, 2, 83, 94, 80, 10}, "a1a8c2"))));
            intent.setFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
            startService(intent);
        }
    }

    public Activity IL1Iii() {
        return this.f5266ILil;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final void m3438IL(Activity activity) {
        this.f5266ILil = activity;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        m3438IL(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (IL1Iii() == activity) {
            m3438IL(null);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (IL1Iii() == activity) {
            m3438IL(null);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        m3438IL(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m3438IL(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        m3438IL(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (IL1Iii() == activity) {
            m3438IL(null);
        }
    }

    @Override // android.app.Application
    public void onCreate() throws Throwable {
        super.onCreate();
        f5265I1I = this;
        lIlii.IL1Iii(this);
        registerActivityLifecycleCallbacks(this);
        try {
            HashMap map = new HashMap();
            map.put(IL1Iii.IL1Iii(new byte[]{77, 66, 92, 59, 75, 17, 93, 84, 93, 29, 103, 2, 84, 80, 74, 23, 84, 14, 89, 85, 92, 22}, IL1Iii.IL1Iii(new byte[]{12, 2, 13, 5, 91, 83}, IL1Iii.IL1Iii(new byte[]{7, 80, 1, 87, 7, 5}, "3c56d7"))), Boolean.TRUE);
            QbSdk.initTbsSettings(map);
            QbSdk.initX5Environment(this, null);
        } catch (Exception unused) {
        }
    }
}
