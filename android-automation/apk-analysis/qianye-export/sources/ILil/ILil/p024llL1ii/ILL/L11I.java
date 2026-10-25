package ILil.ILil.p024llL1ii.ILL;

import ILil.ILil.IiL;
import ILil.ILil.p021Ll1.IL1Iii;
import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.mysql.jdbc.MysqlErrorNumbers;

/* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.ILL.L丨1丨1丨I, reason: invalid class name */
/* JADX INFO: compiled from: MenuDialogHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class L11I implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, InterfaceC0628ILl.IL1Iii {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public IL1Iii f3896I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public IiL f3897ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public InterfaceC0628ILl.IL1Iii f3898Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public lLi1LL f1478IL;

    public L11I(IiL iiL) {
        this.f3897ILil = iiL;
    }

    public void I1I(IBinder iBinder) {
        IiL iiL = this.f3897ILil;
        IL1Iii.C0552IL1Iii c0552IL1Iii = new IL1Iii.C0552IL1Iii(iiL.getContext());
        lLi1LL lli1ll = new lLi1LL(c0552IL1Iii.getContext(), IiL.abc_list_menu_item_layout);
        this.f1478IL = lli1ll;
        lli1ll.setCallback(this);
        this.f3897ILil.addMenuPresenter(this.f1478IL);
        c0552IL1Iii.setAdapter(this.f1478IL.IL1Iii(), this);
        View headerView = iiL.getHeaderView();
        if (headerView != null) {
            c0552IL1Iii.setCustomTitle(headerView);
        } else {
            c0552IL1Iii.setIcon(iiL.getHeaderIcon()).setTitle(iiL.getHeaderTitle());
        }
        c0552IL1Iii.setOnKeyListener(this);
        IL1Iii iL1IiiCreate = c0552IL1Iii.create();
        this.f3896I1I = iL1IiiCreate;
        iL1IiiCreate.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f3896I1I.getWindow().getAttributes();
        attributes.type = MysqlErrorNumbers.ER_YES;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f3896I1I.show();
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl.IL1Iii
    public boolean IL1Iii(IiL iiL) {
        InterfaceC0628ILl.IL1Iii iL1Iii = this.f3898Ilil;
        if (iL1Iii != null) {
            return iL1Iii.IL1Iii(iiL);
        }
        return false;
    }

    public void ILil() {
        IL1Iii iL1Iii = this.f3896I1I;
        if (iL1Iii != null) {
            iL1Iii.dismiss();
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3897ILil.performItemAction((C0629il) this.f1478IL.IL1Iii().getItem(i), 0);
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl.IL1Iii
    public void onCloseMenu(IiL iiL, boolean z) {
        if (z || iiL == this.f3897ILil) {
            ILil();
        }
        InterfaceC0628ILl.IL1Iii iL1Iii = this.f3898Ilil;
        if (iL1Iii != null) {
            iL1Iii.onCloseMenu(iiL, z);
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f1478IL.onCloseMenu(this.f3897ILil, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f3896I1I.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f3896I1I.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f3897ILil.close(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f3897ILil.performShortcut(i, keyEvent, 0);
    }
}
