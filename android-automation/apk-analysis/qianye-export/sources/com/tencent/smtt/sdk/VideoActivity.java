package com.tencent.smtt.sdk;

import I1I.p019lLi1LL.IL1Iii.IL1Iii.IL1Iii.ILil;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class VideoActivity extends Activity {
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C0422p.m475a(this).m476a(i, i2, intent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.requestWindowFeature(1);
        super.getWindow().setFormat(-3);
        Intent intent = super.getIntent();
        Bundle bundleExtra = intent != null ? intent.getBundleExtra("extraData") : null;
        if (bundleExtra != null) {
            bundleExtra.putInt("callMode", 1);
            C0422p.m475a(super.getApplicationContext()).m479a((String) null, bundleExtra, (ILil) null);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C0422p.m475a(this).m477a(this, 4);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        C0422p.m475a(this).m477a(this, 3);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        C0422p.m475a(this).m477a(this, 2);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        C0422p.m475a(this).m477a(this, 1);
    }
}
