package ILil.p028IiL.p029ILl;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: compiled from: ActionProvider.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class ILil {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public IL1Iii f4039IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public InterfaceC0563ILil f4040ILil;

    /* JADX INFO: compiled from: ActionProvider.java */
    public interface IL1Iii {
        void IL1Iii(boolean z);
    }

    /* JADX INFO: renamed from: ILil.I丨iL.IL丨丨l.ILil$ILil, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionProvider.java */
    public interface InterfaceC0563ILil {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public ILil(Context context) {
    }

    public abstract View I1I();

    public boolean IL1Iii() {
        return false;
    }

    public void ILL(boolean z) {
        IL1Iii iL1Iii = this.f4039IL1Iii;
        if (iL1Iii != null) {
            iL1Iii.IL1Iii(z);
        }
    }

    public boolean ILil() {
        return true;
    }

    public boolean Ilil() {
        return false;
    }

    /* JADX INFO: renamed from: I丨L */
    public View mo1866IL(MenuItem menuItem) {
        return I1I();
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m2037IiL() {
        this.f4040ILil = null;
        this.f4039IL1Iii = null;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public void m2038L11I(IL1Iii iL1Iii) {
        this.f4039IL1Iii = iL1Iii;
    }

    /* JADX INFO: renamed from: iI丨LLL1 */
    public boolean mo1867iILLL1() {
        return false;
    }

    /* JADX INFO: renamed from: l丨Li1LL */
    public void mo1865lLi1LL(SubMenu subMenu) {
    }

    /* JADX INFO: renamed from: 丨il */
    public void mo1868il(InterfaceC0563ILil interfaceC0563ILil) {
        if (this.f4040ILil != null && interfaceC0563ILil != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f4040ILil = interfaceC0563ILil;
    }
}
