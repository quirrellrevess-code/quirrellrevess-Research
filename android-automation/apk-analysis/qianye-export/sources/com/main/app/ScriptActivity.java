package com.main.app;

import I1I.I1I.ILil.IIi;
import I1I.I1I.ILil.iIilII1;
import I1I.I1I.ILil.l1IIi1;
import I1I.I1I.ILil.llL1ii;
import I1I.I1I.p008IL.C0607ILl;
import I1I.I1I.p008IL.lIlii;
import I1I.I1I.p008IL.lLi1LL;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.flexbox.BuildConfig;
import com.p000nx.assist.UIMgr;
import com.p000nx.assist.p002ui.ViewOnClickListenerC0318UI;
import com.p000nx.assist.p002ui.Window;
import com.qyzs.smn2.R;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ScriptActivity extends AppCompatActivity {
    public I1I.I1I.IL1Iii.ILil I11L;
    public ViewGroup I11li1;
    public String iIlLiL = BuildConfig.FLAVOR;

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public Window f2880lL = null;
    public boolean llliI = false;

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public String f2881l = null;

    public class I1I implements Runnable {

        public class IL1Iii implements Runnable {
            public IL1Iii() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ScriptActivity.this.m3475iILLl();
                ScriptActivity.this.llliI = true;
                I1I.p014IL.IL1Iii.IL1Iii.Ilil();
            }
        }

        public I1I() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (new File(ScriptActivity.this.iIlLiL).exists()) {
                iIilII1 iiilii1LLL = iIilII1.LLL();
                ScriptActivity scriptActivity = ScriptActivity.this;
                iiilii1LLL.m991li11(scriptActivity, scriptActivity.iIlLiL);
            }
            ScriptActivity.this.runOnUiThread(new IL1Iii());
        }
    }

    public class IL1Iii implements View.OnClickListener {
        public IL1Iii() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ScriptActivity.this.startActivity(new Intent(ScriptActivity.this, (Class<?>) SettingsActivity.class));
        }
    }

    public class ILil implements View.OnClickListener {
        public ILil() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!ScriptActivity.this.llliI) {
                lIlii.lILi1lLl(ScriptActivity.this, I1I.IL1Iii.IL1Iii(new byte[]{-126, -98, -81, -127, -23, -59, -115, -117, -96, -126, -44, -57, -128, -66, -104, -116, -37, -37, -128, -102, -76, -126, -18, -10}, I1I.IL1Iii.IL1Iii(new byte[]{0, 80, 89, 80, 2, 82}, I1I.IL1Iii.IL1Iii(new byte[]{83, 92, 87, 5, 92, 6}, "686182"))));
                return;
            }
            if (ScriptActivity.this.f2880lL != null) {
                ScriptActivity.this.f2880lL.saveCfg();
            }
            ScriptActivity.this.I11L.m846lLi1LL();
            ScriptActivity.this.moveTaskToBack(true);
        }
    }

    /* JADX INFO: renamed from: com.main.app.ScriptActivity$I丨L, reason: invalid class name */
    public class IL implements lLi1LL.I1I {
        public IL() {
        }

        @Override // I1I.I1I.p008IL.lLi1LL.I1I
        public void IL1Iii(lLi1LL.IL il) {
            if (il == lLi1LL.IL.f0Ok) {
                p051lLi1LL.ILil.IL1Iii.I1I.I1I().ILL(new IIi(100, BuildConfig.FLAVOR, BuildConfig.FLAVOR));
                ScriptActivity.this.finish();
            }
        }
    }

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public final void m3474IIi(Intent intent) {
        this.f2881l = intent.getStringExtra(I1I.IL1Iii.IL1Iii(new byte[]{77, 81, 5, 13, 93, 84}, I1I.IL1Iii.IL1Iii(new byte[]{90, 11, 85, 87, 0, 5}, I1I.IL1Iii.IL1Iii(new byte[]{90, 7, 4, 5, 1, 5}, "842601"))));
        this.llliI = false;
        I1I.p014IL.IL1Iii.IL1Iii.m1424IiL(this, I1I.IL1Iii.IL1Iii(new byte[]{-41, -72, -63, -34, -123, -119, -42, -118, -52, 24, 22, 26}, I1I.IL1Iii.IL1Iii(new byte[]{83, 86, 80, 84, 90, 6}, I1I.IL1Iii.IL1Iii(new byte[]{89, 84, 0, 0, 83, 7}, "801b15"))));
        new Thread(new I1I()).start();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        this.I11L.m844L11I();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_script);
        new Handler();
        this.I11L = new I1I.I1I.IL1Iii.ILil(this);
        lLi1LL.IL1Iii(this, I1I.IL1Iii.IL1Iii(new byte[]{-44, -93, -17, -47, -83, -111, -42, -68, -61, -48, -115, -114, -41, -114, -50, -48, -97, -124, -44, -98, -18, -33, -99, -70}, I1I.IL1Iii.IL1Iii(new byte[]{87, 83, 84, 0, 81, 1}, I1I.IL1Iii.IL1Iii(new byte[]{92, 85, 5, 90, 84, 4}, "802b56"))));
        this.iIlLiL = lIlii.m1132LIl(this, I1I.IL1Iii.IL1Iii(new byte[]{74, 86, 75, 91, 64, 64, 23, 89, 75, 88}, I1I.IL1Iii.IL1Iii(new byte[]{90, 2, 11, 83, 85, 4}, I1I.IL1Iii.IL1Iii(new byte[]{90, 83, 1, 84, 86, 7}, "9d3537"))), false);
        this.I11li1 = (ViewGroup) findViewById(R.id.container);
        File file = new File(this.iIlLiL);
        if (I1I.I1I.p008IL.ILil.IL1Iii(this).m1064IL() || !file.exists()) {
            lIlii.I11li1(this, I1I.IL1Iii.IL1Iii(new byte[]{69, 86, 64, 80, 66, 23, 24, 89, 64, 83}, I1I.IL1Iii.IL1Iii(new byte[]{14, 0, 10, 0, 4, 80}, I1I.IL1Iii.IL1Iii(new byte[]{13, 83, 15, 1, 7, 1}, "5f7812"))), I1I.IL1Iii.IL1Iii(new byte[]{68, 85, 66, 81, 68, 71, 25, 90, 66, 82}, I1I.IL1Iii.IL1Iii(new byte[]{15, 7, 3, 10, 2, 81}, I1I.IL1Iii.IL1Iii(new byte[]{92, 3, 87, 1, 1, 6}, "d2d37d"))));
            if (file.exists()) {
                llL1ii.IL1Iii().Ilil(file.lastModified(), this);
            }
        }
        findViewById(R.id.tv_settings).setOnClickListener(new IL1Iii());
        this.I11L.I1I();
        findViewById(R.id.btnrun).setOnClickListener(new ILil());
        lIlii.m1120IlILil(lIlii.m15LL(this, R.id.switch_autosavelog, getResources().getInteger(R.integer.is_autoopen_log) == 1));
        lIlii.m1202LllL(lIlii.m15LL(this, R.id.switch_addfileinfo, false));
        m3474IIi(getIntent());
        C0607ILl.m1065IL(this, I1I.IL1Iii.IL1Iii(new byte[]{75, 93, 76, 68, 12, 10, 95, 75, 103, 85, 11, 18}, I1I.IL1Iii.IL1Iii(new byte[]{10, 93, 15, 4, 92, 7}, I1I.IL1Iii.IL1Iii(new byte[]{10, 86, 84, 3, 95, 2}, "83c7fa"))), true);
        I1I.I1I.p008IL.I1I.Ilil().m1057IL();
        lIlii.i1iL1(this);
        App.ILil().I1I();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (iIilII1.LLL().m8i1()) {
                lLi1LL.ILil(this, I1I.IL1Iii.IL1Iii(new byte[]{-34, -88, -50, -46, -11, -106, -33, -117, -14, -47, -8, -81, -48, -76, -5, -47, -7, -100}, I1I.IL1Iii.IL1Iii(new byte[]{91, 6, 88, 2, 92, 7}, I1I.IL1Iii.IL1Iii(new byte[]{85, 3, 13, 3, 95, 1}, "6546f6"))), I1I.IL1Iii.IL1Iii(new byte[]{-48, -67, -14, -48, -110, -115}, I1I.IL1Iii.IL1Iii(new byte[]{1, 87, 90, 82, 15, 2}, I1I.IL1Iii.IL1Iii(new byte[]{0, 3, 1, 7, 90, 80}, "7f9bce"))), new IL());
                return true;
            }
            p051lLi1LL.ILil.IL1Iii.I1I.I1I().ILL(new IIi(100, BuildConfig.FLAVOR, BuildConfig.FLAVOR));
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        m3474IIi(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public final void m3475iILLl() {
        File fileM1016IiL = l1IIi1.I1I().m1016IiL();
        try {
            String string = new JSONObject(lIlii.l11(new File(fileM1016IiL, I1I.IL1Iii.IL1Iii(new byte[]{83, 86, 23, 19, 74, 25, 92, 75, 12, 15}, I1I.IL1Iii.IL1Iii(new byte[]{80, 15, 6, 86, 1, 85}, I1I.IL1Iii.IL1Iii(new byte[]{95, 6, 80, 1, 1, 91}, "915639")))))).getString(I1I.IL1Iii.IL1Iii(new byte[]{17, 90, 62, 87, 90, 67, 22, 74}, I1I.IL1Iii.IL1Iii(new byte[]{80, 5, 7, 5, 12, 0}, I1I.IL1Iii.IL1Iii(new byte[]{1, 85, 7, 86, 12, 2}, "5caa45"))));
            if (!TextUtils.isEmpty(this.f2881l)) {
                string = I1I.IL1Iii.IL1Iii(new byte[]{-127, -96, -67, -33, -85, -63, 73}, I1I.IL1Iii.IL1Iii(new byte[]{80, 3, 8, 2, 80, 84}, I1I.IL1Iii.IL1Iii(new byte[]{4, 5, 88, 81, 85, 0}, "23ae37"))) + this.f2881l;
            }
            ViewOnClickListenerC0318UI ui = UIMgr.getInstance().parseUI(lIlii.l11(new File(fileM1016IiL, string)), -1);
            if (ui != null) {
                Window window = (Window) ui.inflateView(lIlii.LL1IL());
                window.hideBottom();
                window.hideTitle();
                if (window != null) {
                    this.I11li1.removeAllViews();
                    this.I11li1.addView(window);
                    this.f2880lL = window;
                }
            }
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{124, 58}, I1I.IL1Iii.IL1Iii(new byte[]{10, 83, 0, 14, 82, 0}, I1I.IL1Iii.IL1Iii(new byte[]{14, 8, 3, 82, 1, 5}, "690d7a"))), I1I.IL1Iii.IL1Iii(new byte[]{75, 12, 93, 20, 77, 13, 24, 1, 64, 17, 5, 89, 6}, I1I.IL1Iii.IL1Iii(new byte[]{1, 6, 4, 2, 10, 92}, I1I.IL1Iii.IL1Iii(new byte[]{13, 90, 85, 83, 10, 11}, "48c283"))) + e.toString());
        }
    }
}
