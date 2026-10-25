package ILil.ILil.p024llL1ii.ILL;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.ILL.Ll丨1, reason: invalid class name */
/* JADX INFO: compiled from: MenuPopup.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Ll1 implements llL1ii, InterfaceC0628ILl, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Rect f3895ILil;

    public static int Ilil(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        View view = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = listAdapter.getItemViewType(i4);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
            }
            view = listAdapter.getView(i4, view, viewGroup);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
        }
        return i2;
    }

    public static boolean Lil(IiL iiL) {
        int size = iiL.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = iiL.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    public static iILLL1 LlLI1(ListAdapter listAdapter) {
        return listAdapter instanceof HeaderViewListAdapter ? (iILLL1) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (iILLL1) listAdapter;
    }

    public boolean I1I() {
        return true;
    }

    public abstract void ILL(int i);

    public abstract void ILil(IiL iiL);

    /* JADX INFO: renamed from: IL丨丨l */
    public abstract void mo1875ILl(int i);

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Rect m1885IL() {
        return this.f3895ILil;
    }

    /* JADX INFO: renamed from: Ll丨1 */
    public abstract void mo1877Ll1(PopupWindow.OnDismissListener onDismissListener);

    /* JADX INFO: renamed from: L丨1丨1丨I */
    public abstract void mo1878L11I(boolean z);

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
        return 0;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m1886iILLL1(Rect rect) {
        this.f3895ILil = rect;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public void initForMenu(Context context, IiL iiL) {
    }

    /* JADX INFO: renamed from: lIi丨I */
    public abstract void mo1879lIiI(boolean z);

    /* JADX INFO: renamed from: l丨Li1LL */
    public abstract void mo1882lLi1LL(View view);

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        LlLI1(listAdapter).f3901ILil.performItemAction((MenuItem) listAdapter.getItem(i), this, I1I() ? 0 : 4);
    }

    /* JADX INFO: renamed from: 丨il */
    public abstract void mo1883il(int i);
}
