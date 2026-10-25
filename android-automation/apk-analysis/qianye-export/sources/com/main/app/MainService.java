package com.main.app;

import I1I.I1I.ILil.C0003lL;
import I1I.I1I.ILil.IIi;
import I1I.I1I.ILil.ILLIi;
import I1I.I1I.ILil.InterfaceC0604lIII;
import I1I.I1I.ILil.L1iI1;
import I1I.I1I.ILil.i11i;
import I1I.I1I.ILil.iILLl;
import I1I.I1I.ILil.iIilII1;
import I1I.I1I.ILil.iIlLiL;
import I1I.I1I.ILil.lIiI;
import I1I.I1I.ILil.llL1ii;
import I1I.I1I.p008IL.ILL;
import I1I.I1I.p008IL.lIlii;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.INXCoreNative;
import android.app.KeyguardManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import com.google.android.flexbox.BuildConfig;
import com.p000nx.assist.UIMgr;
import com.p000nx.assist.log.Console;
import com.qyzs.smn2.R;
import java.io.File;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;
import org.opencv.videoio.Videoio;
import p051lLi1LL.ILil.IL1Iii.InterfaceC0678ILl;

/* JADX INFO: loaded from: classes.dex */
public class MainService extends Service implements InterfaceC0604lIII, View.OnClickListener {
    public ILL ILL;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public WindowManager f5313Ilil;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public KeyguardManager.KeyguardLock f5312ILil = null;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Handler f5311I1I = null;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean f2871IL = false;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public iIlLiL f2876lLi1LL = null;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public String f2875iILLL1 = BuildConfig.FLAVOR;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public boolean f2872IiL = false;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public boolean f2874L11I = false;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public boolean f2877il = false;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public boolean f2873Ll1 = false;

    public class I1I implements C0003lL.ILil {
        public I1I(MainService mainService) {
        }

        @Override // I1I.I1I.ILil.C0003lL.ILil
        public void IL1Iii(int i, int i2, int i3, int i4, int i5) {
        }
    }

    public class IL1Iii implements Runnable {
        public IL1Iii(MainService mainService) {
        }

        @Override // java.lang.Runnable
        public void run() {
            i11i.ILL().Ilil();
            L1iI1.m900lIiI().Ilil();
            if (lIiI.Ilil() != null) {
                lIiI.Ilil().m1023IL();
            }
        }
    }

    public class ILil implements Runnable {
        public ILil() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainService.this.m3461ILl(null, true);
        }
    }

    /* JADX INFO: renamed from: com.main.app.MainService$I丨L, reason: invalid class name */
    public class IL implements Runnable {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ String f5316ILil;

        public IL(String str) {
            this.f5316ILil = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            lIlii.lILi1lLl(MainService.this, this.f5316ILil);
        }
    }

    /* JADX INFO: renamed from: com.main.app.MainService$I丨iL, reason: invalid class name */
    public class IiL extends Binder {
        public IiL() {
        }

        public InterfaceC0604lIII IL1Iii() {
            return MainService.this;
        }
    }

    /* JADX INFO: renamed from: com.main.app.MainService$iI丨LLL1, reason: invalid class name */
    public class iILLL1 extends BroadcastReceiver {
        public iILLL1(MainService mainService) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (I1I.IL1Iii.IL1Iii(new byte[]{7, 94, 1, 70, 87, 11, 2, 30, 12, 90, 76, 7, 8, 68, 75, 85, 91, 22, 15, 95, 11, 26, 122, 35, 50, 100, 32, 102, 97, 61, 37, 120, 36, 122, 127, 39, 34}, I1I.IL1Iii.IL1Iii(new byte[]{5, 4, 80, 13, 13, 1}, I1I.IL1Iii.IL1Iii(new byte[]{1, 7, 87, 88, 80, 84}, "b3bae7"))).equals(intent.getAction())) {
                int intExtra = intent.getIntExtra(I1I.IL1Iii.IL1Iii(new byte[]{92, 4, 23, 4, 10}, I1I.IL1Iii.IL1Iii(new byte[]{84, 86, 89, 5, 85, 9}, I1I.IL1Iii.IL1Iii(new byte[]{6, 2, 94, 87, 80, 92}, "b5f3cd"))), 0);
                int intExtra2 = intent.getIntExtra(I1I.IL1Iii.IL1Iii(new byte[]{21, 80, 2, 85, 4}, I1I.IL1Iii.IL1Iii(new byte[]{3, 2, 2, 10, 80, 5}, I1I.IL1Iii.IL1Iii(new byte[]{0, 4, 88, 1, 9, 7}, "e59285"))), 100);
                if (intExtra2 > 0) {
                    lIlii.Ili((intExtra * 100) / intExtra2);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.main.app.MainService$l丨Li1LL, reason: invalid class name */
    public class lLi1LL implements Runnable {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ boolean f5319ILil;

        public lLi1LL(boolean z) {
            this.f5319ILil = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            MainService.this.m3466llL1ii(this.f5319ILil);
        }
    }

    public final void I11li1(Context context, int i, int i2, String str, String str2, Class<?> cls) {
        try {
            if (this.f2874L11I) {
                return;
            }
            String packageName = context.getPackageName();
            String packageName2 = context.getPackageName();
            if (Build.VERSION.SDK_INT >= 26) {
                ((NotificationManager) getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{15, 92, 67, 93, 0, 88, 2, 82, 67, 93, 9, 95}, I1I.IL1Iii.IL1Iii(new byte[]{7, 81, 86, 80, 95, 9}, I1I.IL1Iii.IL1Iii(new byte[]{2, 84, 3, 1, 9, 93}, "d6be0e"))))).createNotificationChannel(new NotificationChannel(packageName, packageName2, 4));
            }
            PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) MainActivity.class), 0);
            ILil.p028IiL.Ilil.iILLL1.ILil iLil = new ILil.p028IiL.Ilil.iILLL1.ILil(this, packageName);
            iLil.m2191iILLL1(str);
            iLil.m2192lLi1LL(str2);
            iLil.m2193il(System.currentTimeMillis());
            iLil.m2190L11I(R.mipmap.ic_launcher);
            iLil.m2189IiL(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
            iLil.Ilil(activity);
            startForeground(1, iLil.IL1Iii());
            this.f2874L11I = true;
        } catch (Exception unused) {
        }
    }

    public final void ILL() {
        this.ILL.m1063IL(I1I.IL1Iii.IL1Iii(new byte[]{-115, -32, -85, -126, -83, -98, -128, -18, -111, -116, -116, -113, -127, -36, -100, -116, -98, -123, -126, -52, -68, -125, -100, -69}, I1I.IL1Iii.IL1Iii(new byte[]{83, 84, 6, 6, 85, 5}, I1I.IL1Iii.IL1Iii(new byte[]{15, 6, 85, 90, 0, 14}, "96b8d9"))));
        I1I.p062Ilil.p063IL1Iii.IL1Iii.m1244IiL().Ilil();
        UIMgr.getInstance().begin();
        if (lIlii.m15LL(this, R.id.switch_virbate, false)) {
            lIlii.I1I(1000L);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0604lIII
    public void ILil(INXCoreNative iNXCoreNative) throws RemoteException {
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public synchronized void m3461ILl(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            str = this.f2875iILLL1;
        }
        if (!this.f2871IL || z) {
            this.f2871IL = true;
            m3466llL1ii(true);
            iIilII1.LLL().m987i1I1I1l(this, str);
        }
    }

    public final void Ilil() {
        if (this.f2876lLi1LL.getRunState()) {
            this.f2877il = true;
            mo1027il(6);
        } else {
            this.f2877il = true;
            m3462IL();
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final void m3462IL() {
        Activity activityIL1Iii;
        if (this.f2877il) {
            this.f2877il = false;
            if (this.f2876lLi1LL.getParent() != null) {
                this.f5313Ilil.removeView(this.f2876lLi1LL);
            }
            App app = (App) getApplication();
            if (app == null || (activityIL1Iii = app.IL1Iii()) == null) {
                return;
            }
            activityIL1Iii.finish();
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0604lIII
    /* JADX INFO: renamed from: I丨iL */
    public void mo1025IiL(Intent intent) throws RemoteException {
    }

    public final void Lil(double d, double d2) {
        if (lIlii.m1181IiIi(this) && this.f2876lLi1LL.getParent() != null) {
            Point pointM1123IIi = lIlii.m1123IIi(this);
            if (d < 0.0d) {
                d = 0.0d;
            }
            if (d > 1.0d) {
                d = 1.0d;
            }
            if (d2 < 0.0d) {
                d2 = 0.0d;
            }
            double d3 = d2 <= 1.0d ? d2 : 1.0d;
            int i = (int) (((double) pointM1123IIi.x) * d);
            int i2 = (int) (((double) pointM1123IIi.y) * d3);
            this.f2876lLi1LL.m1001Ll1();
            this.f2876lLi1LL.Lil(i, i2);
            UIState.getInstance().setFloatWndPos(i, i2);
        }
    }

    public final void LlLI1(int i, int i2) {
        if (lIlii.m1181IiIi(this) && this.f2876lLi1LL.getParent() != null) {
            this.f2876lLi1LL.m1001Ll1();
            this.f2876lLi1LL.Lil(i, i2);
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final void m3463Ll1(int i) {
        lIlii.m1131LII1(I1I.IL1Iii.IL1Iii(new byte[]{13, 90, 96, 5, 23, 93, 18, 64, 96, 18, 10, 68, 74}, I1I.IL1Iii.IL1Iii(new byte[]{85, 1, 6, 7, 3, 86}, I1I.IL1Iii.IL1Iii(new byte[]{1, 6, 2, 5, 86, 90}, "637d08"))) + i + I1I.IL1Iii.IL1Iii(new byte[]{25}, I1I.IL1Iii.IL1Iii(new byte[]{9, 90, 2, 3, 82, 3}, I1I.IL1Iii.IL1Iii(new byte[]{92, 12, 83, 3, 84, 4}, "e4de77"))));
        this.ILL.Ilil();
        I1I.p062Ilil.p063IL1Iii.IL1Iii.m1244IiL().m1247iILLL1();
        UIMgr.getInstance().finish();
        I1I.p062Ilil.ILil.I1I.m1257L1l().Ilil();
        I1I.p062Ilil.p063IL1Iii.ILil.m1251IL(this).Ilil();
        iIilII1.LLL().m6I();
        iILLl.ILil();
        new Thread(new IL1Iii(this)).start();
        if (this.f2872IiL) {
            this.f2877il = false;
            m3466llL1ii(false);
            this.f2872IiL = false;
            this.f5311I1I.postDelayed(new ILil(), 1000L);
            return;
        }
        m3466llL1ii(false);
        if (i == 0) {
            iIi1(getResources().getString(R.string.engine_stoped));
        } else if (lIlii.m15LL(this, R.id.switch_showonoff, true)) {
            iIi1(getResources().getString(R.string.script_stoped));
        }
        Native.sendEvent(1, 0, null, null);
        m3462IL();
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    public final void iIi1(String str) {
        this.f5311I1I.post(new IL(str));
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0028 A[Catch: Exception -> 0x0091, TryCatch #0 {Exception -> 0x0091, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x000f, B:18:0x0082, B:9:0x0017, B:13:0x0020, B:14:0x0028, B:16:0x0031), top: B:23:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:16:0x0031 A[Catch: Exception -> 0x0091, TryCatch #0 {Exception -> 0x0091, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x000f, B:18:0x0082, B:9:0x0017, B:13:0x0020, B:14:0x0028, B:16:0x0031), top: B:23:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:9:0x0017 A[Catch: Exception -> 0x0091, TryCatch #0 {Exception -> 0x0091, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x000f, B:18:0x0082, B:9:0x0017, B:13:0x0020, B:14:0x0028, B:16:0x0031), top: B:23:0x0003 }] */
    public final void iIlLiL(boolean z, String str) {
        Intent intent;
        Intent intent2;
        if (!z) {
            try {
                if (lIlii.Ll1(this) || lIlii.m16Li(this)) {
                    intent = new Intent(this, (Class<?>) MainActivity.class);
                } else if (!lIlii.ii1(this) || z) {
                    intent2 = new Intent(this, (Class<?>) ScriptActivity.class);
                    if (z) {
                        intent2.putExtra(I1I.IL1Iii.IL1Iii(new byte[]{68, 89, 0, 13, 94, 3}, I1I.IL1Iii.IL1Iii(new byte[]{85, 5, 7, 86, 6, 0}, I1I.IL1Iii.IL1Iii(new byte[]{1, 0, 89, 83, 7, 0}, "e58a3f"))), str);
                    }
                    intent = intent2;
                } else {
                    intent = new Intent(this, (Class<?>) SettingsActivity.class);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else if (lIlii.ii1(this)) {
            intent2 = new Intent(this, (Class<?>) ScriptActivity.class);
            if (z) {
                intent2.putExtra(I1I.IL1Iii.IL1Iii(new byte[]{68, 89, 0, 13, 94, 3}, I1I.IL1Iii.IL1Iii(new byte[]{85, 5, 7, 86, 6, 0}, I1I.IL1Iii.IL1Iii(new byte[]{1, 0, 89, 83, 7, 0}, "e58a3f"))), str);
            }
            intent = intent2;
        } else {
            intent2 = new Intent(this, (Class<?>) ScriptActivity.class);
            if (z) {
                intent2.putExtra(I1I.IL1Iii.IL1Iii(new byte[]{68, 89, 0, 13, 94, 3}, I1I.IL1Iii.IL1Iii(new byte[]{85, 5, 7, 86, 6, 0}, I1I.IL1Iii.IL1Iii(new byte[]{1, 0, 89, 83, 7, 0}, "e58a3f"))), str);
            }
            intent = intent2;
        }
        intent.setFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
        PendingIntent.getActivity(this, 0, intent, Videoio.CAP_INTELPERC_IR_GENERATOR).send();
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public void m3464lIiI(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{124, 60}, I1I.IL1Iii.IL1Iii(new byte[]{6, 5, 3, 8, 84, 12}, I1I.IL1Iii.IL1Iii(new byte[]{12, 84, 86, 11, 80, 12}, "85c318"))), I1I.IL1Iii.IL1Iii(new byte[]{70, 80, 17, 76, 3, 23, 64, 102, 1, 74, 11, 21, 64, 21, 0, 93, 5, 12, 90, 8, 92}, I1I.IL1Iii.IL1Iii(new byte[]{85, 6, 7, 13, 7, 92}, I1I.IL1Iii.IL1Iii(new byte[]{0, 87, 92, 6, 92, 88}, "ad939a"))) + file.exists() + I1I.IL1Iii.IL1Iii(new byte[]{90}, I1I.IL1Iii.IL1Iii(new byte[]{84, 3, 6, 85, 93, 1}, I1I.IL1Iii.IL1Iii(new byte[]{87, 84, 80, 7, 82, 5}, "bbe673"))) + file.getAbsolutePath());
            if (!file.exists()) {
                mo1027il(8);
                return;
            }
            if (!file.renameTo(new File(this.f2875iILLL1))) {
                Log.i(I1I.IL1Iii.IL1Iii(new byte[]{127, 107}, I1I.IL1Iii.IL1Iii(new byte[]{6, 82, 6, 1, 14, 0}, I1I.IL1Iii.IL1Iii(new byte[]{82, 83, 2, 6, 0, 89}, "e2ad8a"))), I1I.IL1Iii.IL1Iii(new byte[]{67, 6, 10, 87, 94, 6, 17, 5, 5, 95, 95, 6, 85, 94, 90}, I1I.IL1Iii.IL1Iii(new byte[]{83, 0, 2, 3, 87, 5}, I1I.IL1Iii.IL1Iii(new byte[]{80, 0, 4, 7, 83, 0}, "2cb27f"))) + file.getAbsolutePath());
                mo1027il(7);
                return;
            }
            llL1ii.IL1Iii().Ilil(new File(this.f2875iILLL1).lastModified(), this);
        }
        this.f2872IiL = true;
        mo1027il(9);
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public final void m3465lIlii(boolean z) {
        if (lIlii.m1181IiIi(this)) {
            if (!z) {
                if (this.f2876lLi1LL.getParent() != null) {
                    this.f5313Ilil.removeView(this.f2876lLi1LL);
                    UIState.getInstance().showFloatWnd(false);
                    return;
                }
                return;
            }
            if (this.f2876lLi1LL.getParent() == null) {
                WindowManager windowManager = this.f5313Ilil;
                iIlLiL iillil = this.f2876lLi1LL;
                windowManager.addView(iillil, iillil.getLayoutParams());
                UIState.getInstance().showFloatWnd(true);
            }
        }
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public final void m3466llL1ii(boolean z) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            this.f5311I1I.post(new lLi1LL(z));
            return;
        }
        if (lIlii.m1181IiIi(this) && this.f2876lLi1LL.getParent() == null) {
            WindowManager windowManager = this.f5313Ilil;
            iIlLiL iillil = this.f2876lLi1LL;
            windowManager.addView(iillil, iillil.getLayoutParams());
        }
        this.f2871IL = z;
        this.f2876lLi1LL.setRunState(z);
    }

    @Override // I1I.I1I.ILil.InterfaceC0604lIII
    /* JADX INFO: renamed from: l丨Li1LL */
    public void mo1026lLi1LL(int i, String str) {
        m3461ILl(str, false);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new IiL();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.llrun) {
            if (this.f2876lLi1LL.getRunState()) {
                mo1027il(5);
                return;
            } else {
                mo1026lLi1LL(-1, null);
                return;
            }
        }
        if (id == R.id.llsettings) {
            iIlLiL(false, null);
            return;
        }
        if (id == R.id.llpause) {
            if (!iIilII1.LLL().m8i1()) {
                this.f2876lLi1LL.setPauseState(false);
                return;
            } else if (this.f2876lLi1LL.getPauseState()) {
                this.f2876lLi1LL.setPauseState(false);
                iIilII1.LLL().LI11();
                return;
            } else {
                this.f2876lLi1LL.setPauseState(true);
                iIilII1.LLL().m993i11LL();
                return;
            }
        }
        if (id == R.id.llexit) {
            Ilil();
        } else if (id == R.id.lluserevent) {
            if (iIilII1.LLL().m8i1()) {
                iIilII1.LLL().L1iI1();
            } else {
                lIlii.lILi1lLl(this, I1I.IL1Iii.IL1Iii(new byte[]{-33, -52, -128, -124, -77, -19, -33, -36, -89, -119, -105, -23, -33, -25, -83, -121, -86, -55}, I1I.IL1Iii.IL1Iii(new byte[]{84, 81, 4, 5, 85, 80}, I1I.IL1Iii.IL1Iii(new byte[]{2, 84, 11, 92, 87, 13}, "af8848"))));
            }
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        lIlii.m1161iliiL(this);
        ILLIi.m876lLi1LL().m879Ll1();
        WindowManager windowManager = this.f5313Ilil;
        if (windowManager != null) {
            C0003lL.I1I().IL1Iii(windowManager.getDefaultDisplay().getRotation());
        }
        iIilII1.LLL().m978LlLiLL();
    }

    @Override // android.app.Service
    @SuppressLint({"ServiceCast"})
    public void onCreate() {
        super.onCreate();
        Log.i(I1I.IL1Iii.IL1Iii(new byte[]{122, 104}, I1I.IL1Iii.IL1Iii(new byte[]{80, 84, 85, 11, 87, 82}, I1I.IL1Iii.IL1Iii(new byte[]{87, 7, 7, 10, 83, 3}, "3c0855"))), I1I.IL1Iii.IL1Iii(new byte[]{18, 84, 23, 21, 90, 81, 4, 17}, I1I.IL1Iii.IL1Iii(new byte[]{80, 1, 87, 91, 4, 87}, I1I.IL1Iii.IL1Iii(new byte[]{6, 84, 2, 89, 7, 81}, "7d0a04"))) + this + I1I.IL1Iii.IL1Iii(new byte[]{70, 16, 71, 11}, I1I.IL1Iii.IL1Iii(new byte[]{80, 91, 87, 4, 7, 85}, I1I.IL1Iii.IL1Iii(new byte[]{80, 9, 87, 0, 80, 92}, "f02a49"))));
        this.ILL = new ILL(this);
        this.f2875iILLL1 = lIlii.m1132LIl(this, I1I.IL1Iii.IL1Iii(new byte[]{75, 90, 70, 95, 72, 69, 22, 85, 70, 92}, I1I.IL1Iii.IL1Iii(new byte[]{89, 1, 7, 3, 13, 1}, I1I.IL1Iii.IL1Iii(new byte[]{82, 14, 5, 81, 87, 9}, "366db9"))), false);
        File file = new File(this.f2875iILLL1);
        if (I1I.I1I.p008IL.ILil.IL1Iii(this).m1064IL() || !(file.exists() || lIlii.Ll1(this))) {
            if (file.exists()) {
                file.delete();
            }
            lIlii.I11li1(this, I1I.IL1Iii.IL1Iii(new byte[]{70, 80, 70, 8, 18, 66, 27, 95, 70, 11}, I1I.IL1Iii.IL1Iii(new byte[]{6, 1, 5, 89, 81, 83}, I1I.IL1Iii.IL1Iii(new byte[]{85, 6, 5, 15, 2, 82}, "f44717"))), I1I.IL1Iii.IL1Iii(new byte[]{18, 87, 66, 81, 22, 66, 79, 88, 66, 82}, I1I.IL1Iii.IL1Iii(new byte[]{88, 4, 3, 93, 95, 14}, I1I.IL1Iii.IL1Iii(new byte[]{9, 8, 10, 85, 1, 89}, "08908a"))));
            if (file.exists()) {
                llL1ii.IL1Iii().Ilil(file.lastModified(), this);
            }
        } else if (lIlii.Ll1(this) && file.exists()) {
            file.delete();
        }
        lIlii.m1161iliiL(this);
        C0003lL.I1I().m1031IL(new I1I(this));
        p051lLi1LL.ILil.IL1Iii.I1I.I1I().Lil(this);
        this.f5311I1I = new Handler();
        try {
            KeyguardManager.KeyguardLock keyguardLockNewKeyguardLock = ((KeyguardManager) getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{82, 86, 73, 84, 22, 0, 75, 87}, I1I.IL1Iii.IL1Iii(new byte[]{93, 10, 4, 80, 84, 82}, I1I.IL1Iii.IL1Iii(new byte[]{0, 12, 3, 7, 84, 0}, "d57dc3"))))).newKeyguardLock(MainService.class.toString());
            this.f5312ILil = keyguardLockNewKeyguardLock;
            keyguardLockNewKeyguardLock.disableKeyguard();
        } catch (Exception unused) {
        }
        iIilII1.LLL().m972ILLIi(this);
        this.f5313Ilil = (WindowManager) getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{17, 81, 91, 92, 90, 22}, I1I.IL1Iii.IL1Iii(new byte[]{81, 14, 12, 1, 5, 2}, I1I.IL1Iii.IL1Iii(new byte[]{5, 3, 95, 90, 2, 2}, "25fc2a"))));
        iIlLiL iillil = new iIlLiL(this);
        this.f2876lLi1LL = iillil;
        iillil.setOnClickListener(this);
        if (lIlii.Ll1(this)) {
            Native.registerDebugService(lIlii.m1133LIll(this));
        }
        registerReceiver(new iILLL1(this), new IntentFilter(I1I.IL1Iii.IL1Iii(new byte[]{87, 89, 7, 67, 12, 92, 82, 25, 10, 95, 23, 80, 88, 67, 77, 80, 0, 65, 95, 88, 13, 31, 33, 116, 98, 99, 38, 99, 58, 106, 117, 127, 34, 127, 36, 112, 114}, I1I.IL1Iii.IL1Iii(new byte[]{6, 14, 5, 7, 91, 5}, I1I.IL1Iii.IL1Iii(new byte[]{85, 91, 5, 6, 12, 86}, "ebc04f")))));
        Console.getInstance().init(this);
        ILLIi.m876lLi1LL().m878IiL(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        p051lLi1LL.ILil.IL1Iii.I1I.I1I().m3670llL1ii(this);
    }

    @InterfaceC0678ILl(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(IIi iIi) {
        if (iIi.I1I() == 1) {
            String strIL1Iii = iIi.IL1Iii();
            if (strIL1Iii == null || !new File(strIL1Iii).exists()) {
                return;
            }
            ProjectActivity.ILil(this, strIL1Iii);
            return;
        }
        if (iIi.I1I() == 2) {
            File file = new File(iIi.IL1Iii());
            if (file.exists()) {
                File file2 = new File(this.f2875iILLL1);
                file.renameTo(file2);
                if (file2.exists()) {
                    llL1ii.IL1Iii().Ilil(file2.lastModified(), this);
                }
            }
            mo1026lLi1LL(-1, this.f2875iILLL1);
            return;
        }
        if (iIi.I1I() == 3) {
            mo1027il(1);
            return;
        }
        try {
            if (iIi.I1I() == 5) {
                JSONObject jSONObject = new JSONObject(iIi.IL1Iii());
                Lil(jSONObject.getDouble(I1I.IL1Iii.IL1Iii(new byte[]{76}, I1I.IL1Iii.IL1Iii(new byte[]{2, 84, 3, 2, 13, 9}, I1I.IL1Iii.IL1Iii(new byte[]{84, 83, 6, 80, 13, 83}, "ba748b")))), jSONObject.getDouble(I1I.IL1Iii.IL1Iii(new byte[]{26}, I1I.IL1Iii.IL1Iii(new byte[]{84, 91, 15, 1, 8, 2}, I1I.IL1Iii.IL1Iii(new byte[]{2, 85, 1, 84, 1, 6}, "578795")))));
            } else {
                if (iIi.I1I() != 6) {
                    if (iIi.I1I() == 7) {
                        File file3 = new File(iIi.IL1Iii());
                        if (file3.exists()) {
                            File file4 = new File(this.f2875iILLL1);
                            file3.renameTo(file4);
                            if (file4.exists()) {
                                llL1ii.IL1Iii().Ilil(file4.lastModified(), this);
                                iIlLiL(true, iIi.ILil());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (iIi.I1I() == 99) {
                        m3464lIiI(iIi.IL1Iii());
                        return;
                    }
                    if (iIi.I1I() == 100) {
                        if (this.f2871IL) {
                            this.f2877il = true;
                            mo1027il(2);
                            return;
                        } else {
                            this.f2877il = true;
                            m3462IL();
                            return;
                        }
                    }
                    if (iIi.I1I() == 101) {
                        String strIL1Iii2 = iIi.IL1Iii();
                        if (!TextUtils.isEmpty(strIL1Iii2) && strIL1Iii2.compareTo(I1I.IL1Iii.IL1Iii(new byte[]{1}, I1I.IL1Iii.IL1Iii(new byte[]{0, 91, 87, 7, 3, 11}, I1I.IL1Iii.IL1Iii(new byte[]{10, 11, 81, 85, 81, 95}, "930fbf")))) == 0) {
                            lIlii.lILi1lLl(this, I1I.IL1Iii.IL1Iii(new byte[]{-117, -97, -57, -114, -100, -71, -122, -107, -46, -114, -121, -99, -116, -115, -17, -114, -73, -94, -123, -83, -49, -127, -120, -85, -123, -84, -4}, I1I.IL1Iii.IL1Iii(new byte[]{7, 82, 80, 85, 10, 89}, I1I.IL1Iii.IL1Iii(new byte[]{82, 91, 80, 3, 93, 0}, "68c0da"))));
                        }
                        if (this.f2871IL) {
                            m3463Ll1(Integer.parseInt(iIi.IL1Iii()));
                            return;
                        }
                        return;
                    }
                    if (iIi.I1I() == 102) {
                        ILL();
                        return;
                    }
                    if (iIi.I1I() != 105) {
                        if (iIi.I1I() == 106) {
                            this.ILL.Ilil();
                            return;
                        }
                        return;
                    } else {
                        if (lIlii.m15LL(this, R.id.switch_vol, lIlii.m1139LlIl(this))) {
                            String strIL1Iii3 = iIi.IL1Iii();
                            if (strIL1Iii3 != null && strIL1Iii3.compareTo(I1I.IL1Iii.IL1Iii(new byte[]{85}, I1I.IL1Iii.IL1Iii(new byte[]{93, 9, 2, 7, 3, 5}, I1I.IL1Iii.IL1Iii(new byte[]{92, 85, 80, 87, 87, 7}, "ddf6c2")))) == 0) {
                                if (this.f2871IL) {
                                    return;
                                }
                                m3461ILl(null, false);
                                return;
                            } else {
                                if (strIL1Iii3 != null && strIL1Iii3.compareTo(I1I.IL1Iii.IL1Iii(new byte[]{4}, I1I.IL1Iii.IL1Iii(new byte[]{80, 4, 7, 7, 93, 2}, I1I.IL1Iii.IL1Iii(new byte[]{1, 81, 4, 6, 92, 1}, "db0590")))) == 0 && this.f2871IL) {
                                    mo1027il(3);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                }
                m3465lIlii(Boolean.parseBoolean(iIi.IL1Iii()));
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        String stringExtra = intent != null ? intent.getStringExtra(I1I.IL1Iii.IL1Iii(new byte[]{84, 91, 64, 93, 95, 15}, I1I.IL1Iii.IL1Iii(new byte[]{4, 15, 12, 0, 2, 3}, I1I.IL1Iii.IL1Iii(new byte[]{0, 81, 90, 1, 86, 83}, "1fb5d1")))) : null;
        I11li1(this, (int) (System.currentTimeMillis() / 1000), R.mipmap.ic_launcher, getResources().getString(R.string.app_name), getResources().getString(R.string.app_name), MainActivity.class);
        if (iIilII1.LLL().m8i1()) {
            m3466llL1ii(true);
            if (!this.f2873Ll1) {
                this.f2873Ll1 = true;
                if (iIilII1.LLL().m979L1l()) {
                    this.f2876lLi1LL.setPauseState(true);
                }
                UIState.getInstance().onUiShow();
                UIState.ILil floatControlState = UIState.getInstance().getFloatControlState();
                if (floatControlState.f5349IL1Iii) {
                    LlLI1(floatControlState.f5350ILil, floatControlState.f5348I1I);
                } else {
                    m3465lIlii(false);
                }
            }
        }
        if (stringExtra == null || stringExtra.compareTo(I1I.IL1Iii.IL1Iii(new byte[]{16, 18, 2, 23, 68}, I1I.IL1Iii.IL1Iii(new byte[]{84, 4, 85, 4, 84, 84}, I1I.IL1Iii.IL1Iii(new byte[]{5, 3, 0, 87, 87, 3}, "2a6635")))) != 0) {
            if (stringExtra == null || stringExtra.compareTo(I1I.IL1Iii.IL1Iii(new byte[]{64, 18, 88, 67}, I1I.IL1Iii.IL1Iii(new byte[]{7, 82, 4, 11, 84, 84}, I1I.IL1Iii.IL1Iii(new byte[]{6, 13, 7, 11, 83, 80}, "2943ba")))) != 0) {
                if (stringExtra != null && stringExtra.compareTo(I1I.IL1Iii.IL1Iii(new byte[]{71, 90, 95, 20, 80, 13, 91, 83, 68}, I1I.IL1Iii.IL1Iii(new byte[]{6, 83, 0, 90, 7, 4}, I1I.IL1Iii.IL1Iii(new byte[]{10, 2, 86, 90, 0, 82}, "8cfc17")))) == 0) {
                    m3466llL1ii(false);
                } else if (stringExtra != null && stringExtra.compareTo(I1I.IL1Iii.IL1Iii(new byte[]{74, 91, 17, 11, 66, 70}, I1I.IL1Iii.IL1Iii(new byte[]{91, 92, 0, 84, 6, 5}, I1I.IL1Iii.IL1Iii(new byte[]{0, 87, 85, 3, 85, 86}, "b365aa")))) == 0) {
                    iIilII1.LLL().m7LL(this);
                } else {
                    if (stringExtra != null && stringExtra.compareTo(I1I.IL1Iii.IL1Iii(new byte[]{9, 85, 84, 72, 94, 11, 20, 85}, I1I.IL1Iii.IL1Iii(new byte[]{6, 86, 4, 9, 10, 7}, I1I.IL1Iii.IL1Iii(new byte[]{84, 84, 5, 82, 15, 81}, "020c74")))) == 0) {
                        return 1;
                    }
                    if (stringExtra != null && stringExtra.compareTo(I1I.IL1Iii.IL1Iii(new byte[]{87, 26, 13, 18}, I1I.IL1Iii.IL1Iii(new byte[]{7, 4, 6, 4, 5, 0}, I1I.IL1Iii.IL1Iii(new byte[]{3, 87, 91, 87, 3, 0}, "61951b")))) == 0) {
                        Ilil();
                        return 1;
                    }
                }
            } else if (this.f2876lLi1LL.getRunState()) {
                mo1027il(4);
            }
        } else if (!this.f2876lLi1LL.getRunState()) {
            mo1026lLi1LL(-1, null);
        }
        this.f2873Ll1 = true;
        return 1;
    }

    @Override // I1I.I1I.ILil.InterfaceC0604lIII
    /* JADX INFO: renamed from: 丨il */
    public synchronized void mo1027il(int i) {
        lIlii.m1131LII1(I1I.IL1Iii.IL1Iii(new byte[]{-115, -97, -59, -48, -20, -87, -126, -125, -16, -45, -2, -89, -115, -68, -7, -45, -1, -108, 95}, I1I.IL1Iii.IL1Iii(new byte[]{87, 1, 87, 83, 82, 14}, I1I.IL1Iii.IL1Iii(new byte[]{87, 11, 82, 3, 2, 82}, "e2fe3d"))) + i);
        if (this.f2876lLi1LL.getPauseState()) {
            this.f2876lLi1LL.setPauseState(false);
            iIilII1.LLL().LI11();
        }
        iIilII1.LLL().m982iI1LI();
    }
}
