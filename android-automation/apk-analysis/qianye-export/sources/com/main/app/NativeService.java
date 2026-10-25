package com.main.app;

import I1I.I1I.ILil.C0003lL;
import I1I.I1I.ILil.InterfaceC0604lIII;
import I1I.I1I.ILil.L11I;
import I1I.I1I.p008IL.lIlii;
import ILil.p028IiL.Ilil.iILLL1;
import android.app.INXCoreNative;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.view.WindowManager;
import com.google.android.flexbox.BuildConfig;
import com.main.engine.ScriptMain;
import com.p000nx.assist.lua.LuaEngine;
import com.qyzs.smn2.R;

/* JADX INFO: loaded from: classes.dex */
public class NativeService extends Service {

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public WindowManager f2878IL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Intent f5321ILil = null;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f5320I1I = 0;

    public class IL1Iii implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ String f5322I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ int f5323ILil;

        public IL1Iii(int i, String str) {
            this.f5323ILil = i;
            this.f5322I1I = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (Thread.currentThread().getContextClassLoader() == null) {
                    Thread.currentThread().setContextClassLoader(NativeService.class.getClassLoader());
                }
                new ScriptMain();
                ScriptMain.main(new String[]{I1I.IL1Iii.IL1Iii(new byte[]{83}, I1I.IL1Iii.IL1Iii(new byte[]{87, 13, 91, 0, 10, 1}, I1I.IL1Iii.IL1Iii(new byte[]{6, 84, 8, 81, 10, 87}, "2a1c9c"))), Native.getNativeType() + BuildConfig.FLAVOR, this.f5323ILil + BuildConfig.FLAVOR, NativeService.this.getPackageName(), NativeService.this.getApplicationInfo().sourceDir, this.f5322I1I});
            } catch (Exception unused) {
            }
            try {
                Process.killProcess(Process.myPid());
            } catch (Exception unused2) {
            }
        }
    }

    public class ILil extends InterfaceC0604lIII.IL1Iii {
        public ILil() {
        }

        @Override // I1I.I1I.ILil.InterfaceC0604lIII
        public void ILil(INXCoreNative iNXCoreNative) throws RemoteException {
            L11I.I11L().ILil(iNXCoreNative);
        }

        @Override // I1I.I1I.ILil.InterfaceC0604lIII
        /* JADX INFO: renamed from: I丨iL */
        public void mo1025IiL(Intent intent) throws RemoteException {
            NativeService.this.f5321ILil = intent;
            NativeService.this.Ilil();
        }

        @Override // I1I.I1I.ILil.InterfaceC0604lIII
        /* JADX INFO: renamed from: l丨Li1LL */
        public void mo1026lLi1LL(int i, String str) throws RemoteException {
            NativeService.this.f5320I1I = i;
            NativeService.this.m3467IL(i, str);
            NativeService.this.Ilil();
        }

        @Override // I1I.I1I.ILil.InterfaceC0604lIII
        /* JADX INFO: renamed from: 丨il */
        public void mo1027il(int i) throws RemoteException {
            NativeService.this.m3468iILLL1();
        }
    }

    public final void Ilil() {
        int i = this.f5320I1I;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m3467IL(int i, String str) {
        new Thread(new IL1Iii(i, str)).start();
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m3468iILLL1() {
        try {
            Process.killProcess(Process.myPid());
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final void m3469lLi1LL(Context context, int i, int i2, String str, String str2, Class<?> cls) {
        try {
            String packageName = context.getPackageName();
            String packageName2 = context.getPackageName();
            if (Build.VERSION.SDK_INT >= 26) {
                ((NotificationManager) getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{87, 12, 67, 80, 86, 93, 90, 2, 67, 80, 95, 90}, I1I.IL1Iii.IL1Iii(new byte[]{92, 1, 84, 14, 6, 5}, I1I.IL1Iii.IL1Iii(new byte[]{92, 4, 2, 7, 87, 6}, "9fa0a7"))))).createNotificationChannel(new NotificationChannel(packageName, packageName2, 4));
            }
            PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) MainActivity.class), 0);
            iILLL1.ILil iLil = new iILLL1.ILil(this, packageName);
            iLil.m2191iILLL1(str);
            iLil.m2192lLi1LL(str2);
            iLil.m2193il(System.currentTimeMillis());
            iLil.m2190L11I(R.mipmap.ic_launcher);
            iLil.m2189IiL(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
            iLil.Ilil(activity);
            startForeground(1, iLil.IL1Iii());
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new ILil();
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        lIlii.m1161iliiL(this);
        C0003lL.I1I().IL1Iii(this.f2878IL.getDefaultDisplay().getRotation());
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        lIlii.LIIIiI(this);
        LuaEngine.Init(this);
        this.f2878IL = (WindowManager) getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{70, 8, 95, 1, 95, 70}, I1I.IL1Iii.IL1Iii(new byte[]{2, 5, 4, 92, 82, 9}, I1I.IL1Iii.IL1Iii(new byte[]{6, 85, 6, 8, 7, 10}, "5131e2"))));
        lIlii.m1161iliiL(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        m3469lLi1LL(this, (int) (System.currentTimeMillis() / 1000), R.mipmap.ic_launcher, getResources().getString(R.string.app_name), getResources().getString(R.string.app_name), MainActivity.class);
        if (intent == null) {
            return 1;
        }
        intent.getStringExtra(I1I.IL1Iii.IL1Iii(new byte[]{87, 91, 66, 93, 94, 94}, I1I.IL1Iii.IL1Iii(new byte[]{7, 94, 15, 3, 0, 9}, I1I.IL1Iii.IL1Iii(new byte[]{82, 94, 11, 6, 82, 13}, "c821c4"))));
        return 1;
    }
}
