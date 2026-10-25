package com.main.app;

import I1I.I1I.ILil.I11L;
import I1I.I1I.ILil.iIilII1;
import I1I.I1I.p008IL.lIiI;
import I1I.IL1Iii;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class RSNativeActivity extends Activity {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public long f5325ILil = 0;

    public static void ILil(Context context, I11L i11l) {
        Intent intentAddFlags = new Intent(context, (Class<?>) RSNativeActivity.class).addFlags(268959744);
        intentAddFlags.putExtra(IL1Iii.IL1Iii(new byte[]{91, 0, 15, 80, 84, 92}, IL1Iii.IL1Iii(new byte[]{85, 7, 85, 13, 10, 95}, IL1Iii.IL1Iii(new byte[]{87, 5, 85, 10, 84, 86}, "1ca3f0"))), lIiI.ILil().IL1Iii(i11l));
        context.startActivity(intentAddFlags);
    }

    public final void IL1Iii(Intent intent) {
        this.f5325ILil = intent.getLongExtra(IL1Iii.IL1Iii(new byte[]{95, 89, 88, 84, 13, 82}, IL1Iii.IL1Iii(new byte[]{2, 9, 1, 85, 7, 4}, IL1Iii.IL1Iii(new byte[]{4, 2, 82, 3, 81, 5}, "13ef76"))), 0L);
        I11L i11l = (I11L) lIiI.ILil().I1I(this.f5325ILil);
        if (i11l != null) {
            i11l.ILil();
        }
        startActivityForResult(((MediaProjectionManager) getSystemService(IL1Iii.IL1Iii(new byte[]{89, 87, 84, 95, 86, 107, 68, 64, 95, 92, 82, 87, 64, 91, 95, 88}, IL1Iii.IL1Iii(new byte[]{0, 1, 5, 6, 2, 82}, IL1Iii.IL1Iii(new byte[]{81, 4, 5, 81, 81, 2}, "e70add"))))).createScreenCaptureIntent(), 256);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 256 && i2 == -1) {
            iIilII1.LLL().ill1LI1l(intent);
        }
        I11L i11l = (I11L) lIiI.ILil().I1I(this.f5325ILil);
        if (i11l != null) {
            i11l.IL1Iii();
            lIiI.ILil().m1111IL(this.f5325ILil);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        IL1Iii(getIntent());
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        IL1Iii(intent);
    }
}
