package androidx.core.app;

import ILil.p028IiL.p029ILl.IL;
import ILil.p042lIiI.IiL;
import ILil.p042lIiI.L11I;
import ILil.p065Ilil.lIlii;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.ReportFragment;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity extends Activity implements IiL, IL.IL1Iii {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public L11I f4947ILil;

    public ComponentActivity() {
        new lIlii();
        this.f4947ILil = new L11I(this);
    }

    @Override // ILil.p028IiL.p029ILl.IL.IL1Iii
    /* JADX INFO: renamed from: I丨L */
    public boolean mo1654IL(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !IL.m2039IL(decorView, keyEvent)) {
            return IL.Ilil(this, decorView, this, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !IL.m2039IL(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    public ILil.p042lIiI.IL getLifecycle() {
        return this.f4947ILil;
    }

    @Override // android.app.Activity
    @SuppressLint({"RestrictedApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ReportFragment.Ilil(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.f4947ILil.ILL(ILil.p042lIiI.IL.ILil.CREATED);
        super.onSaveInstanceState(bundle);
    }
}
