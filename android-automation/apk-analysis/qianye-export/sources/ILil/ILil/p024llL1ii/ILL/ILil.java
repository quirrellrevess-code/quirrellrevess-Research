package ILil.ILil.p024llL1ii.ILL;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: compiled from: BaseMenuPresenter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class ILil implements InterfaceC0628ILl {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Context f3881I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Context f3882ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public LayoutInflater f3883Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public IiL f1454IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public int f1455IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public Lil f1456L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int f1457iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public InterfaceC0628ILl.IL1Iii f1458lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public int f1459il;

    public ILil(Context context, int i, int i2) {
        this.f3882ILil = context;
        this.f3883Ilil = LayoutInflater.from(context);
        this.f1457iILLL1 = i;
        this.f1455IiL = i2;
    }

    public abstract void I1I(C0629il c0629il, Lil.IL1Iii iL1Iii);

    public void ILil(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f1456L11I).addView(view, i);
    }

    public boolean Ilil(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Lil.IL1Iii m1869IL(ViewGroup viewGroup) {
        return (Lil.IL1Iii) this.f3883Ilil.inflate(this.f1455IiL, viewGroup, false);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public Lil mo1870IiL(ViewGroup viewGroup) {
        if (this.f1456L11I == null) {
            Lil lil = (Lil) this.f3883Ilil.inflate(this.f1457iILLL1, viewGroup, false);
            this.f1456L11I = lil;
            lil.initialize(this.f1454IL);
            updateMenuView(true);
        }
        return this.f1456L11I;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public void m1871L11I(int i) {
        this.f1459il = i;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public boolean collapseItemActionView(IiL iiL, C0629il c0629il) {
        return false;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public boolean expandItemActionView(IiL iiL, C0629il c0629il) {
        return false;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public int getId() {
        return this.f1459il;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public View mo1872iILLL1(C0629il c0629il, View view, ViewGroup viewGroup) {
        Lil.IL1Iii iL1IiiM1869IL = view instanceof Lil.IL1Iii ? (Lil.IL1Iii) view : m1869IL(viewGroup);
        I1I(c0629il, iL1IiiM1869IL);
        return (View) iL1IiiM1869IL;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public void initForMenu(Context context, IiL iiL) {
        this.f3881I1I = context;
        LayoutInflater.from(context);
        this.f1454IL = iiL;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public InterfaceC0628ILl.IL1Iii m1873lLi1LL() {
        return this.f1458lLi1LL;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public void onCloseMenu(IiL iiL, boolean z) {
        InterfaceC0628ILl.IL1Iii iL1Iii = this.f1458lLi1LL;
        if (iL1Iii != null) {
            iL1Iii.onCloseMenu(iiL, z);
        }
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public boolean onSubMenuSelected(iIi1 iii1) {
        InterfaceC0628ILl.IL1Iii iL1Iii = this.f1458lLi1LL;
        if (iL1Iii != null) {
            return iL1Iii.IL1Iii(iii1);
        }
        return false;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public void setCallback(InterfaceC0628ILl.IL1Iii iL1Iii) {
        this.f1458lLi1LL = iL1Iii;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public void updateMenuView(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f1456L11I;
        if (viewGroup == null) {
            return;
        }
        IiL iiL = this.f1454IL;
        int i = 0;
        if (iiL != null) {
            iiL.flagActionItems();
            ArrayList<C0629il> visibleItems = this.f1454IL.getVisibleItems();
            int size = visibleItems.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                C0629il c0629il = visibleItems.get(i3);
                if (mo1874il(i2, c0629il)) {
                    View childAt = viewGroup.getChildAt(i2);
                    C0629il itemData = childAt instanceof Lil.IL1Iii ? ((Lil.IL1Iii) childAt).getItemData() : null;
                    View viewMo1872iILLL1 = mo1872iILLL1(c0629il, childAt, viewGroup);
                    if (c0629il != itemData) {
                        viewMo1872iILLL1.setPressed(false);
                        viewMo1872iILLL1.jumpDrawablesToCurrentState();
                    }
                    if (viewMo1872iILLL1 != childAt) {
                        ILil(viewMo1872iILLL1, i2);
                    }
                    i2++;
                }
            }
            i = i2;
        }
        while (i < viewGroup.getChildCount()) {
            if (!Ilil(viewGroup, i)) {
                i++;
            }
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public abstract boolean mo1874il(int i, C0629il c0629il);
}
