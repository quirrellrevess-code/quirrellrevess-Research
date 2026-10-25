package ILil.ILil.p024llL1ii.ILL;

import android.content.Context;
import android.os.Parcelable;

/* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.ILL.IL丨丨l, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: MenuPresenter.java */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC0628ILl {

    /* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.ILL.IL丨丨l$IL1Iii */
    /* JADX INFO: compiled from: MenuPresenter.java */
    public interface IL1Iii {
        boolean IL1Iii(IiL iiL);

        void onCloseMenu(IiL iiL, boolean z);
    }

    boolean collapseItemActionView(IiL iiL, C0629il c0629il);

    boolean expandItemActionView(IiL iiL, C0629il c0629il);

    boolean flagActionItems();

    int getId();

    void initForMenu(Context context, IiL iiL);

    void onCloseMenu(IiL iiL, boolean z);

    void onRestoreInstanceState(Parcelable parcelable);

    Parcelable onSaveInstanceState();

    boolean onSubMenuSelected(iIi1 iii1);

    void setCallback(IL1Iii iL1Iii);

    void updateMenuView(boolean z);
}
