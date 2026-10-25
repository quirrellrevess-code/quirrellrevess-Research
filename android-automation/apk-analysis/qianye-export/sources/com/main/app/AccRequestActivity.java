package com.main.app;

import I1I.I1I.ILil.I11L;
import I1I.I1I.p008IL.lIiI;
import I1I.I1I.p008IL.lIlii;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class AccRequestActivity extends Activity {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public long f5262ILil = 0;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public boolean f5261I1I = false;

    public static class IL1Iii implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ I11L f5263I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ Context f5264ILil;

        public IL1Iii(Context context, I11L i11l) {
            this.f5264ILil = context;
            this.f5263I1I = i11l;
        }

        @Override // java.lang.Runnable
        public void run() {
            Intent intentAddFlags = new Intent(this.f5264ILil, (Class<?>) AccRequestActivity.class).addFlags(268959744);
            intentAddFlags.putExtra(I1I.IL1Iii.IL1Iii(new byte[]{10, 81, 95, 5, 15, 80}, I1I.IL1Iii.IL1Iii(new byte[]{4, 6, 5, 0, 84, 83}, I1I.IL1Iii.IL1Iii(new byte[]{84, 3, 2, 86, 81, 82}, "2567f4"))), lIiI.ILil().IL1Iii(this.f5263I1I));
            this.f5264ILil.startActivity(intentAddFlags);
        }
    }

    public static void ILil(Context context, I11L i11l) {
        lIlii.LIlIlIL(new IL1Iii(context, i11l));
    }

    public final void IL1Iii(Intent intent) {
        long longExtra = intent.getLongExtra(I1I.IL1Iii.IL1Iii(new byte[]{13, 4, 95, 81, 88, 0}, I1I.IL1Iii.IL1Iii(new byte[]{86, 83, 9, 13, 86, 3}, I1I.IL1Iii.IL1Iii(new byte[]{4, 5, 89, 15, 81, 85}, "73a733"))), 0L);
        if (longExtra == 0) {
            finish();
            return;
        }
        this.f5262ILil = longExtra;
        I11L i11l = (I11L) lIiI.ILil().I1I(this.f5262ILil);
        if (i11l != null) {
            i11l.ILil();
        }
        lIlii.m1158iiLL(this);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        IL1Iii(getIntent());
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f5262ILil != 0) {
            I11L i11l = (I11L) lIiI.ILil().I1I(this.f5262ILil);
            if (i11l != null) {
                i11l.IL1Iii();
            }
            lIiI.ILil().m1111IL(this.f5262ILil);
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        IL1Iii(intent);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f5261I1I) {
            finish();
        } else {
            this.f5261I1I = true;
        }
    }
}
