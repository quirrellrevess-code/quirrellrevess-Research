package ILil.ILil.p021Ll1;

import ILil.ILil.p024llL1ii.ILil;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar;

/* JADX INFO: renamed from: ILil.ILil.Ll丨1.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: AppCompatDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class IL extends Dialog implements ILil {
    private I1I mDelegate;
    private final ILil.p028IiL.p029ILl.IL.IL1Iii mKeyDispatcher;

    /* JADX INFO: renamed from: ILil.ILil.Ll丨1.I丨L$IL1Iii */
    /* JADX INFO: compiled from: AppCompatDialog.java */
    public class IL1Iii implements ILil.p028IiL.p029ILl.IL.IL1Iii {
        public IL1Iii() {
        }

        @Override // ILil.p028IiL.p029ILl.IL.IL1Iii
        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public boolean mo1654IL(KeyEvent keyEvent) {
            return IL.this.superDispatchKeyEvent(keyEvent);
        }
    }

    public IL(Context context) {
        this(context, 0);
    }

    private static int getThemeResId(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(ILil.ILil.IL1Iii.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().IL1Iii(view, layoutParams);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return ILil.p028IiL.p029ILl.IL.Ilil(this.mKeyDispatcher, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        return (T) getDelegate().Ilil(i);
    }

    public I1I getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = I1I.m1638IL(this, this);
        }
        return this.mDelegate;
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().mo1645L11I();
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        getDelegate().ILL();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        getDelegate().mo1651il();
        super.onCreate(bundle);
        getDelegate().Lil(bundle);
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        getDelegate().I11li1();
    }

    @Override // ILil.ILil.p021Ll1.ILil
    public void onSupportActionModeFinished(ILil iLil) {
    }

    @Override // ILil.ILil.p021Ll1.ILil
    public void onSupportActionModeStarted(ILil iLil) {
    }

    @Override // ILil.ILil.p021Ll1.ILil
    public ILil onWindowStartingSupportActionMode(ILil.IL1Iii iL1Iii) {
        return null;
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        getDelegate().llliI(i);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().mo1648lIII(charSequence);
    }

    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().I11L(i);
    }

    public IL(Context context, int i) {
        super(context, getThemeResId(context, i));
        this.mKeyDispatcher = new IL1Iii();
        I1I delegate = getDelegate();
        delegate.mo1646LlLLL(getThemeResId(context, i));
        delegate.Lil(null);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        getDelegate().mo1652l(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().mo16531(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        getDelegate().mo1648lIII(getContext().getString(i));
    }

    public IL(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.mKeyDispatcher = new IL1Iii();
    }
}
