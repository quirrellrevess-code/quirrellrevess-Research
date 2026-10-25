package com.main.app;

import I1I.I1I.IL1Iii.ILil;
import I1I.I1I.ILil.IIi;
import I1I.I1I.ILil.iIilII1;
import I1I.I1I.p008IL.C0607ILl;
import I1I.I1I.p008IL.lIlii;
import I1I.I1I.p008IL.lLi1LL;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.google.android.flexbox.BuildConfig;
import com.main.widget.CircleButton;
import com.qyzs.smn2.R;
import p051lLi1LL.ILil.IL1Iii.I1I;

/* JADX INFO: loaded from: classes.dex */
public class MainActivity extends BaseSettingActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public ILil f2869IIi;

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public CircleButton f2870iILLl;

    public class IL1Iii implements lLi1LL.I1I {
        public IL1Iii() {
        }

        @Override // I1I.I1I.p008IL.lLi1LL.I1I
        public void IL1Iii(lLi1LL.IL il) {
            if (il == lLi1LL.IL.f0Ok) {
                I1I.I1I().ILL(new IIi(100, BuildConfig.FLAVOR, BuildConfig.FLAVOR));
                MainActivity.this.finish();
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        this.f2869IIi.m844L11I();
    }

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public final void m3460ill() {
        m3441IIi(false);
        this.f2869IIi = new ILil(this);
        lLi1LL.IL1Iii(this, I1I.IL1Iii.IL1Iii(new byte[]{-44, -95, -121, -128, -67, -103, -41, -66, -105, -114, -115, -118, -42, -116, -102, -114, -97, -128, -43, -100, -70, -127, -99, -66}, I1I.IL1Iii.IL1Iii(new byte[]{80, 5, 85, 82, 83, 83}, I1I.IL1Iii.IL1Iii(new byte[]{0, 82, 81, 13, 80, 6}, "bc393b"))));
        CircleButton circleButton = (CircleButton) findViewById(R.id.btnrun);
        this.f2870iILLl = circleButton;
        circleButton.set_text(I1I.IL1Iii.IL1Iii(new byte[]{-42, -40, -76, -121, -58, -67, -37, -37, -92, -118, -64, -70}, I1I.IL1Iii.IL1Iii(new byte[]{81, 7, 82, 82, 87, 3}, I1I.IL1Iii.IL1Iii(new byte[]{87, 1, 4, 5, 3, 84}, "5bb55a"))));
        this.f2870iILLl.setOnClickListener(this);
        C0607ILl.m1065IL(this, I1I.IL1Iii.IL1Iii(new byte[]{70, 1, 69, 23, 92, 91, 82, 23, 110, 6, 91, 67}, I1I.IL1Iii.IL1Iii(new byte[]{83, 84, 87, 83, 83, 0}, I1I.IL1Iii.IL1Iii(new byte[]{82, 4, 86, 3, 85, 87}, "44033b"))), true);
        this.f2869IIi.I1I();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2869IIi.m846lLi1LL();
    }

    @Override // com.main.app.BaseSettingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        lIlii.i1iL1(this);
        m3460ill();
        I1I.I1I.p008IL.I1I.Ilil().m1057IL();
        App.ILil().I1I();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (iIilII1.LLL().m8i1()) {
                lLi1LL.ILil(this, I1I.IL1Iii.IL1Iii(new byte[]{-48, -81, -104, -124, -93, -59, -47, -116, -92, -121, -82, -4, -34, -77, -83, -121, -81, -49}, I1I.IL1Iii.IL1Iii(new byte[]{7, 85, 85, 80, 11, 7}, I1I.IL1Iii.IL1Iii(new byte[]{2, 90, 80, 85, 89, 92}, "382da8"))), I1I.IL1Iii.IL1Iii(new byte[]{-125, -65, -91, -44, -58, -115}, I1I.IL1Iii.IL1Iii(new byte[]{87, 0, 2, 81, 87, 5}, I1I.IL1Iii.IL1Iii(new byte[]{1, 81, 84, 90, 12, 6}, "3ac894"))), new IL1Iii());
                return true;
            }
            I1I.I1I().ILL(new IIi(100, BuildConfig.FLAVOR, BuildConfig.FLAVOR));
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.main.app.BaseSettingActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
