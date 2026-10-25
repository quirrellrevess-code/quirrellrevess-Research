package ILil.ILil.p024llL1ii;

import ILil.ILil.p024llL1ii.ILL.IiL;
import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: StandaloneActionMode.java */
/* JADX INFO: loaded from: classes.dex */
public class lLi1LL extends ILil implements IiL.IL1Iii {

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public ActionBarContextView f3951Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Context f1549IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public boolean f1550IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public IiL f1551L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public WeakReference<View> f1552iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public ILil.IL1Iii f1553lLi1LL;

    public lLi1LL(Context context, ActionBarContextView actionBarContextView, ILil.IL1Iii iL1Iii, boolean z) {
        this.f1549IL = context;
        this.f3951Ilil = actionBarContextView;
        this.f1553lLi1LL = iL1Iii;
        IiL defaultShowAsAction = new IiL(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.f1551L11I = defaultShowAsAction;
        defaultShowAsAction.setCallback(this);
    }

    @Override // ILil.ILil.p024llL1ii.ILil
    public Menu I1I() {
        return this.f1551L11I;
    }

    @Override // ILil.ILil.p024llL1ii.ILil
    public void IL1Iii() {
        if (this.f1550IiL) {
            return;
        }
        this.f1550IiL = true;
        this.f3951Ilil.sendAccessibilityEvent(32);
        this.f1553lLi1LL.IL1Iii(this);
    }

    @Override // ILil.ILil.p024llL1ii.ILil
    public void ILL(View view) {
        this.f3951Ilil.setCustomView(view);
        this.f1552iILLL1 = view != null ? new WeakReference<>(view) : null;
    }

    @Override // ILil.ILil.p024llL1ii.ILil
    public View ILil() {
        WeakReference<View> weakReference = this.f1552iILLL1;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // ILil.ILil.p024llL1ii.ILil
    public CharSequence Ilil() {
        return this.f3951Ilil.getSubtitle();
    }

    @Override // ILil.ILil.p024llL1ii.ILil
    /* JADX INFO: renamed from: I丨L */
    public MenuInflater mo1678IL() {
        return new IiL(this.f3951Ilil.getContext());
    }

    @Override // ILil.ILil.p024llL1ii.ILil
    public void Lil(int i) {
        LlLI1(this.f1549IL.getString(i));
    }

    @Override // ILil.ILil.p024llL1ii.ILil
    public void LlLI1(CharSequence charSequence) {
        this.f3951Ilil.setTitle(charSequence);
    }

    @Override // ILil.ILil.p024llL1ii.ILil
    /* JADX INFO: renamed from: Ll丨1 */
    public void mo1679Ll1(int i) {
        mo1682lIiI(this.f1549IL.getString(i));
    }

    @Override // ILil.ILil.p024llL1ii.ILil
    /* JADX INFO: renamed from: L丨1丨1丨I */
    public void mo1680L11I() {
        this.f1553lLi1LL.I1I(this, this.f1551L11I);
    }

    @Override // ILil.ILil.p024llL1ii.ILil
    /* JADX INFO: renamed from: iI丨LLL1 */
    public CharSequence mo1681iILLL1() {
        return this.f3951Ilil.getTitle();
    }

    @Override // ILil.ILil.p024llL1ii.ILil
    /* JADX INFO: renamed from: lIi丨I */
    public void mo1682lIiI(CharSequence charSequence) {
        this.f3951Ilil.setSubtitle(charSequence);
    }

    @Override // ILil.ILil.p024llL1ii.ILil
    /* JADX INFO: renamed from: ll丨L1ii */
    public void mo1684llL1ii(boolean z) {
        super.mo1684llL1ii(z);
        this.f3951Ilil.setTitleOptional(z);
    }

    @Override // ILil.ILil.p024llL1ii.ILL.IiL.IL1Iii
    public boolean onMenuItemSelected(IiL iiL, MenuItem menuItem) {
        return this.f1553lLi1LL.mo1918IL(this, menuItem);
    }

    @Override // ILil.ILil.p024llL1ii.ILL.IiL.IL1Iii
    public void onMenuModeChange(IiL iiL) {
        mo1680L11I();
        this.f3951Ilil.m3048Ll1();
    }

    @Override // ILil.ILil.p024llL1ii.ILil
    /* JADX INFO: renamed from: 丨il */
    public boolean mo1685il() {
        return this.f3951Ilil.m3051il();
    }
}
