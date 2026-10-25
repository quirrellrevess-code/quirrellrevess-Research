package com.main.app;

import I1I.I1I.p008IL.C0607ILl;
import I1I.I1I.p008IL.Lil;
import I1I.I1I.p008IL.lIlii;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.flexbox.BuildConfig;
import com.qyzs.smn2.R;

/* JADX INFO: loaded from: classes.dex */
public class SplashActivity extends Activity {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public View f5331I1I;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public TextView f5333Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public ViewGroup f2882IL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Lil f5332ILil = null;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean f2885lLi1LL = false;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public boolean f2884iILLL1 = false;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public Thread f2883IiL = null;

    public class I1I implements View.OnClickListener {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ String f5334I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ String f5335ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final /* synthetic */ String f2886IL;

        public I1I(String str, String str2, String str3) {
            this.f5335ILil = str;
            this.f5334I1I = str2;
            this.f2886IL = str3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (I1I.IL1Iii.IL1Iii(new byte[]{10, 16, 90, 94}, I1I.IL1Iii.IL1Iii(new byte[]{1, 2, 7, 1, 84, 87}, "cf037c")).compareTo(this.f5335ILil) != 0) {
                I1I.I1I.I1I.I1I.Ilil(SplashActivity.this).m838IL(this.f5334I1I, this.f2886IL, BuildConfig.FLAVOR);
                return;
            }
            Intent intent = new Intent();
            intent.setAction(I1I.IL1Iii.IL1Iii(new byte[]{0, 90, 92, 67, 9, 89, 5, 26, 81, 95, 18, 85, 15, 64, 22, 80, 5, 68, 8, 91, 86, 31, 48, 121, 36, 99}, I1I.IL1Iii.IL1Iii(new byte[]{80, 6, 15, 1, 85, 3}, "127033")));
            intent.setData(Uri.parse(this.f5334I1I));
            SplashActivity.this.startActivity(intent);
        }
    }

    public class IL1Iii implements I1I.I1I.p008IL.lLi1LL.I1I {
        public IL1Iii() {
        }

        @Override // I1I.I1I.p008IL.lLi1LL.I1I
        public void IL1Iii(I1I.I1I.p008IL.lLi1LL.IL il) {
            if (il != I1I.I1I.p008IL.lLi1LL.IL.f0Ok) {
                SplashActivity.this.m3482Ll1();
            } else {
                SplashActivity.this.f2885lLi1LL = false;
                lIlii.IliI(SplashActivity.this);
            }
        }
    }

    public class ILil implements I1I.I1I.I1I.I1I.ILil {

        public class IL1Iii implements Runnable {

            /* JADX INFO: renamed from: I1I, reason: collision with root package name */
            public final /* synthetic */ String f5339I1I;

            /* JADX INFO: renamed from: ILil, reason: collision with root package name */
            public final /* synthetic */ Bitmap f5340ILil;

            /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
            public final /* synthetic */ String f5341Ilil;

            /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
            public final /* synthetic */ String f2887IL;

            public IL1Iii(Bitmap bitmap, String str, String str2, String str3) {
                this.f5340ILil = bitmap;
                this.f5339I1I = str;
                this.f2887IL = str2;
                this.f5341Ilil = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                SplashActivity.this.m3481ILl(this.f5340ILil, this.f5339I1I, this.f2887IL, this.f5341Ilil);
            }
        }

        public ILil() {
        }

        @Override // I1I.I1I.I1I.I1I.ILil
        public void IL1Iii() {
            SplashActivity.this.m3484il();
        }

        @Override // I1I.I1I.I1I.I1I.ILil
        public void ILil(Bitmap bitmap, String str, String str2, String str3) {
            lIlii.LIlIlIL(new IL1Iii(bitmap, str, str2, str3));
        }
    }

    /* JADX INFO: renamed from: com.main.app.SplashActivity$I丨L, reason: invalid class name */
    public class IL extends CountDownTimer {

        /* JADX INFO: renamed from: com.main.app.SplashActivity$I丨L$IL1Iii */
        public class IL1Iii implements View.OnClickListener {
            public IL1Iii() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SplashActivity.this.m3484il();
            }
        }

        public IL(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            SplashActivity.this.f5333Ilil.setText(I1I.IL1Iii.IL1Iii(new byte[]{-42, -31, -33, -43, -31, -126, -39, -36, -3, -43, -29, -100}, I1I.IL1Iii.IL1Iii(new byte[]{7, 0, 0, 2, 87, 9}, "6cf210")));
            I1I.I1I.I1I.I1I.Ilil(SplashActivity.this).m840lLi1LL();
            SplashActivity.this.m3484il();
            SplashActivity.this.f5333Ilil.setOnClickListener(new IL1Iii());
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            SplashActivity.this.f5333Ilil.setText((j / 1000) + I1I.IL1Iii.IL1Iii(new byte[]{-43, -98, -92}, I1I.IL1Iii.IL1Iii(new byte[]{0, 11, 15, 7, 0, 0}, "229c1f")));
        }
    }

    /* JADX INFO: renamed from: com.main.app.SplashActivity$I丨iL, reason: invalid class name */
    public class IiL implements Runnable {
        public IiL() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!I1I.I1I.p008IL.iIi1.IL1Iii.m1076iILLL1().I1I(SplashActivity.this)) {
                SplashActivity.this.f2885lLi1LL = false;
                I1I.I1I.p008IL.iIi1.IL1Iii.m1076iILLL1().ILil(SplashActivity.this);
            } else {
                if (!lIlii.ii1(SplashActivity.this)) {
                    SplashActivity.this.LlLI1();
                    return;
                }
                if (lIlii.Ll1(SplashActivity.this) || lIlii.m16Li(SplashActivity.this)) {
                    SplashActivity.this.startActivity(new Intent(SplashActivity.this, (Class<?>) MainActivity.class));
                } else {
                    SplashActivity.this.startActivity(new Intent(SplashActivity.this, (Class<?>) ScriptActivity.class));
                }
                SplashActivity.this.finish();
            }
        }
    }

    /* JADX INFO: renamed from: com.main.app.SplashActivity$iI丨LLL1, reason: invalid class name */
    public class iILLL1 implements Runnable {

        /* JADX INFO: renamed from: com.main.app.SplashActivity$iI丨LLL1$IL1Iii */
        public class IL1Iii implements I1I.I1I.p008IL.lLi1LL.I1I {
            public IL1Iii() {
            }

            @Override // I1I.I1I.p008IL.lLi1LL.I1I
            public void IL1Iii(I1I.I1I.p008IL.lLi1LL.IL il) {
                SplashActivity.this.finish();
            }
        }

        public iILLL1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            I1I.I1I.p008IL.lLi1LL.ILil(SplashActivity.this, I1I.IL1Iii.IL1Iii(new byte[]{-121, -1, -72, -122, -71, -108, -124, -6, -99, -123, -109, -108, -120, -55, -71, -122, -105, -124, -119, -41, -112, 79, -37, -102, -42, -118, -75, -29, -42, -78, -37, -118, -78, -18, -37, -102, -12}, I1I.IL1Iii.IL1Iii(new byte[]{0, 2, 12, 83, 4, 81}, "aa907d")), I1I.IL1Iii.IL1Iii(new byte[]{-36, -84, -85, -114, -54, -54, -45, -73, -94, -127, -63, -33}, I1I.IL1Iii.IL1Iii(new byte[]{1, 1, 2, 4, 1, 81}, "490bd4")), new IL1Iii());
        }
    }

    /* JADX INFO: renamed from: com.main.app.SplashActivity$l丨Li1LL, reason: invalid class name */
    public class lLi1LL implements Runnable {
        public lLi1LL() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (I1I.I1I.I1I.I1I.Ilil(SplashActivity.this).I1I(false)) {
                SplashActivity.this.ILL();
                SplashActivity.this.f2883IiL = null;
            } else {
                SplashActivity.this.Lil();
                SplashActivity.this.f2883IiL = null;
            }
        }
    }

    public final void ILL() {
        lIlii.LIlIlIL(new IiL());
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final void m3481ILl(Bitmap bitmap, String str, String str2, String str3) {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this).inflate(R.layout.adlayout, (ViewGroup) null);
        ImageView imageView = (ImageView) frameLayout.findViewById(R.id.adimg);
        imageView.setImageBitmap(bitmap);
        this.f5333Ilil = (TextView) frameLayout.findViewById(R.id.tvCount);
        this.f2882IL.addView(frameLayout);
        this.f5331I1I.setVisibility(8);
        imageView.setOnClickListener(new I1I(str2, str, str3));
        new IL(5000L, 1000L).start();
    }

    public final void Lil() {
        runOnUiThread(new iILLL1());
    }

    public final void LlLI1() {
        I1I.I1I.IL1Iii.ILil iLil = new I1I.I1I.IL1Iii.ILil(this);
        C0607ILl.m1065IL(this, I1I.IL1Iii.IL1Iii(new byte[]{21, 86, 71, 68, 94, 88, 1, 64, 108, 85, 89, 64}, I1I.IL1Iii.IL1Iii(new byte[]{84, 10, 3, 4, 7, 83}, "29040e")), true);
        lIlii.m1120IlILil(lIlii.m15LL(this, R.id.switch_autosavelog, getResources().getInteger(R.integer.is_autoopen_log) == 1));
        lIlii.m1202LllL(lIlii.m15LL(this, R.id.switch_addfileinfo, false));
        I1I.I1I.p008IL.I1I.Ilil().m1057IL();
        lIlii.i1iL1(this);
        iLil.m843IiL();
        this.f2884iILLL1 = true;
        App.ILil().I1I();
        if (Build.VERSION.SDK_INT < 23) {
            finish();
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final void m3482Ll1() {
        I1I.I1I.I1I.I1I.Ilil(this).m839iILLL1(new ILil());
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final void m3483lIiI() {
        this.f5332ILil = new Lil();
        TextView textView = (TextView) findViewById(R.id.title);
        this.f5331I1I = findViewById(R.id.content);
        this.f2882IL = (ViewGroup) findViewById(R.id.adlayout);
        textView.setText(lIlii.m1156iil1(this));
        if (isTaskRoot()) {
            return;
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.splash_activity);
        m3483lIiI();
        I1I.I1I.p008IL.I1I.Ilil().m1057IL();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (lIlii.m1151iILLL1(i, iArr)) {
            m3482Ll1();
        } else if (lIlii.m1173lIlii(this)) {
            m3482Ll1();
        } else {
            I1I.I1I.p008IL.lLi1LL.ILil(this, I1I.IL1Iii.IL1Iii(new byte[]{-48, -74, -121, -41, -71, -95, -34, -91, -77, -37, -81, -89, -35, -100, -127, -38, -126, -110, -34, -79, -69, -41, -68, -97, -34, -74, -72, -44, -85, -76, -35, -88, -89, 30, -47, -75, -127, -35, -73, -119, -45, -72, -82, -34, -122, -70, -45, -121, -119, -48, -121, -127, -34, -120, -65, -33, -85, -122, -48, -71, -99, -48, -113, -87, -45, -78, -99}, I1I.IL1Iii.IL1Iii(new byte[]{12, 13, 83, 4, 14, 7}, "45c680")), I1I.IL1Iii.IL1Iii(new byte[]{-126, -92, -74, -40, -8, -15, -116, -105, -117, -42, -36, -49}, I1I.IL1Iii.IL1Iii(new byte[]{80, 12, 1, 8, 84, 3}, "45495b")), new IL1Iii());
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f2884iILLL1) {
            finish();
            return;
        }
        if (!this.f5332ILil.I1I(this)) {
            lIlii.m1175lLi1LL(this);
        } else {
            if (this.f2885lLi1LL) {
                return;
            }
            this.f2885lLi1LL = true;
            if (lIlii.m1121IlLLl(this)) {
                m3482Ll1();
            }
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final synchronized void m3484il() {
        if (this.f2883IiL == null) {
            Thread thread = new Thread(new lLi1LL());
            this.f2883IiL = thread;
            thread.start();
        }
    }
}
