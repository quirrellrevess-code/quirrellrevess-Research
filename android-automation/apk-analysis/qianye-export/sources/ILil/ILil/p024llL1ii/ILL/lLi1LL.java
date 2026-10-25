package ILil.ILil.p024llL1ii.ILL;

import ILil.ILil.IiL;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ExpandedMenuView;
import java.util.ArrayList;

/* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.ILL.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: ListMenuPresenter.java */
/* JADX INFO: loaded from: classes.dex */
public class lLi1LL implements InterfaceC0628ILl, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public LayoutInflater f3912I1I;
    public int ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Context f3913ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public ExpandedMenuView f3914Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public IiL f1501IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public int f1502IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public InterfaceC0628ILl.IL1Iii f1503L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int f1504iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int f1505lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public IL1Iii f1506il;

    /* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.ILL.l丨Li1LL$IL1Iii */
    /* JADX INFO: compiled from: ListMenuPresenter.java */
    public class IL1Iii extends BaseAdapter {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f3916ILil = -1;

        public IL1Iii() {
            IL1Iii();
        }

        public void IL1Iii() {
            C0629il expandedItem = lLi1LL.this.f1501IL.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<C0629il> nonActionItems = lLi1LL.this.f1501IL.getNonActionItems();
                int size = nonActionItems.size();
                for (int i = 0; i < size; i++) {
                    if (nonActionItems.get(i) == expandedItem) {
                        this.f3916ILil = i;
                        return;
                    }
                }
            }
            this.f3916ILil = -1;
        }

        @Override // android.widget.Adapter
        /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
        public C0629il getItem(int i) {
            ArrayList<C0629il> nonActionItems = lLi1LL.this.f1501IL.getNonActionItems();
            int i2 = i + lLi1LL.this.f1505lLi1LL;
            int i3 = this.f3916ILil;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return nonActionItems.get(i2);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = lLi1LL.this.f1501IL.getNonActionItems().size() - lLi1LL.this.f1505lLi1LL;
            return this.f3916ILil < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                lLi1LL lli1ll = lLi1LL.this;
                view = lli1ll.f3912I1I.inflate(lli1ll.f1502IiL, viewGroup, false);
            }
            ((Lil.IL1Iii) view).initialize(getItem(i), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            IL1Iii();
            super.notifyDataSetChanged();
        }
    }

    public lLi1LL(Context context, int i) {
        this(i, 0);
        this.f3913ILil = context;
        this.f3912I1I = LayoutInflater.from(context);
    }

    public void I1I(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f3914Ilil.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public ListAdapter IL1Iii() {
        if (this.f1506il == null) {
            this.f1506il = new IL1Iii();
        }
        return this.f1506il;
    }

    public Lil ILil(ViewGroup viewGroup) {
        if (this.f3914Ilil == null) {
            this.f3914Ilil = (ExpandedMenuView) this.f3912I1I.inflate(IiL.abc_expanded_menu_layout, viewGroup, false);
            if (this.f1506il == null) {
                this.f1506il = new IL1Iii();
            }
            this.f3914Ilil.setAdapter((ListAdapter) this.f1506il);
            this.f3914Ilil.setOnItemClickListener(this);
        }
        return this.f3914Ilil;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m1898IL(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f3914Ilil;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
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
    public boolean flagActionItems() {
        return false;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public int getId() {
        return this.ILL;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public void initForMenu(Context context, IiL iiL) {
        if (this.f1504iILLL1 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f1504iILLL1);
            this.f3913ILil = contextThemeWrapper;
            this.f3912I1I = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f3913ILil != null) {
            this.f3913ILil = context;
            if (this.f3912I1I == null) {
                this.f3912I1I = LayoutInflater.from(context);
            }
        }
        this.f1501IL = iiL;
        IL1Iii iL1Iii = this.f1506il;
        if (iL1Iii != null) {
            iL1Iii.notifyDataSetChanged();
        }
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public void onCloseMenu(IiL iiL, boolean z) {
        InterfaceC0628ILl.IL1Iii iL1Iii = this.f1503L11I;
        if (iL1Iii != null) {
            iL1Iii.onCloseMenu(iiL, z);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f1501IL.performItemAction(this.f1506il.getItem(i), this, 0);
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public void onRestoreInstanceState(Parcelable parcelable) {
        I1I((Bundle) parcelable);
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public Parcelable onSaveInstanceState() {
        if (this.f3914Ilil == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        m1898IL(bundle);
        return bundle;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public boolean onSubMenuSelected(iIi1 iii1) {
        if (!iii1.hasVisibleItems()) {
            return false;
        }
        new L11I(iii1).I1I(null);
        InterfaceC0628ILl.IL1Iii iL1Iii = this.f1503L11I;
        if (iL1Iii == null) {
            return true;
        }
        iL1Iii.IL1Iii(iii1);
        return true;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public void setCallback(InterfaceC0628ILl.IL1Iii iL1Iii) {
        this.f1503L11I = iL1Iii;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public void updateMenuView(boolean z) {
        IL1Iii iL1Iii = this.f1506il;
        if (iL1Iii != null) {
            iL1Iii.notifyDataSetChanged();
        }
    }

    public lLi1LL(int i, int i2) {
        this.f1502IiL = i;
        this.f1504iILLL1 = i2;
    }
}
