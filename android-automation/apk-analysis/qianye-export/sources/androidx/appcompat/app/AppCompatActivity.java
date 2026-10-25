package androidx.appcompat.app;

import ILil.ILil.p021Ll1.I1I;
import ILil.ILil.p021Ll1.ILil;
import ILil.ILil.p023lIlii.LIll;
import ILil.p028IiL.Ilil.IL;
import ILil.p028IiL.Ilil.IL1Iii;
import ILil.p028IiL.Ilil.Ll1;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatActivity extends FragmentActivity implements ILil, Ll1.IL1Iii {
    public Resources iIi1;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public I1I f2259lIlii;

    public void I11L(int i) {
    }

    public ActionBar I11li1() {
        return iIlLiL().mo1645L11I();
    }

    @Override // ILil.p028IiL.Ilil.Ll1.IL1Iii
    public Intent I1I() {
        return IL.IL1Iii(this);
    }

    public boolean LL1IL(Intent intent) {
        return IL.m2176lLi1LL(this, intent);
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public final boolean m3005LlLLL(int i, KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        iIlLiL().IL1Iii(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        iIlLiL().ILil(context);
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        ActionBar actionBarI11li1 = I11li1();
        if (getWindow().hasFeature(0)) {
            if (actionBarI11li1 == null || !actionBarI11li1.m2988iILLL1()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        ActionBar actionBarI11li1 = I11li1();
        if (keyCode == 82 && actionBarI11li1 != null && actionBarI11li1.LlLI1(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        return (T) iIlLiL().Ilil(i);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return iIlLiL().mo1644IiL();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.iIi1 == null && LIll.ILil()) {
            this.iIi1 = new LIll(this, super.getResources());
        }
        Resources resources = this.iIi1;
        return resources == null ? super.getResources() : resources;
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void iIi1() {
        iIlLiL().ILL();
    }

    public I1I iIlLiL() {
        if (this.f2259lIlii == null) {
            this.f2259lIlii = I1I.I1I(this, this);
        }
        return this.f2259lIlii;
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        iIlLiL().ILL();
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public void m3006lIII(Intent intent) {
        IL.Ilil(this, intent);
    }

    public void llliI(Ll1 ll1) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.iIi1 != null) {
            this.iIi1.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        iIlLiL().mo1643ILl(configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        m3008l();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        I1I i1iIIlLiL = iIlLiL();
        i1iIIlLiL.mo1651il();
        i1iIIlLiL.Lil(bundle);
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        iIlLiL().LlLI1();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (m3005LlLLL(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        ActionBar actionBarI11li1 = I11li1();
        if (menuItem.getItemId() != 16908332 || actionBarI11li1 == null || (actionBarI11li1.mo1673il() & 4) == 0) {
            return false;
        }
        return m30091();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        iIlLiL().mo1650llL1ii(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        iIlLiL().mo1649lIlii();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        iIlLiL().iIi1(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        iIlLiL().iIlLiL();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        iIlLiL().I11li1();
    }

    @Override // ILil.ILil.p021Ll1.ILil
    public void onSupportActionModeFinished(ILil.ILil.p024llL1ii.ILil iLil) {
    }

    @Override // ILil.ILil.p021Ll1.ILil
    public void onSupportActionModeStarted(ILil.ILil.p024llL1ii.ILil iLil) {
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        iIlLiL().mo1648lIII(charSequence);
    }

    @Override // ILil.ILil.p021Ll1.ILil
    public ILil.ILil.p024llL1ii.ILil onWindowStartingSupportActionMode(ILil.ILil.ll丨L1ii.ILil.IL1Iii iL1Iii) {
        return null;
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        ActionBar actionBarI11li1 = I11li1();
        if (getWindow().hasFeature(0)) {
            if (actionBarI11li1 == null || !actionBarI11li1.m2989llL1ii()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        iIlLiL().llliI(i);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        iIlLiL().mo1646LlLLL(i);
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public void m3007lL(Ll1 ll1) {
        ll1.ILil(this);
    }

    @Deprecated
    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public void m3008l() {
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public boolean m30091() {
        Intent intentI1I = I1I();
        if (intentI1I == null) {
            return false;
        }
        if (!LL1IL(intentI1I)) {
            m3006lIII(intentI1I);
            return true;
        }
        Ll1 ll1M2178IL = Ll1.m2178IL(this);
        m3007lL(ll1M2178IL);
        llliI(ll1M2178IL);
        ll1M2178IL.Ilil();
        try {
            IL1Iii.m2165IiL(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        iIlLiL().mo1652l(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        iIlLiL().mo16531(view, layoutParams);
    }
}
