package ILil.ILil.p024llL1ii.ILL;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.ILL.iI丨LLL1, reason: invalid class name */
/* JADX INFO: compiled from: MenuAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class iILLL1 extends BaseAdapter {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f3900I1I = -1;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public IiL f3901ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final boolean f3902Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean f1479IL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final int f1480iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final LayoutInflater f1481lLi1LL;

    public iILLL1(IiL iiL, LayoutInflater layoutInflater, boolean z, int i) {
        this.f3902Ilil = z;
        this.f1481lLi1LL = layoutInflater;
        this.f3901ILil = iiL;
        this.f1480iILLL1 = i;
        IL1Iii();
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: I1I, reason: merged with bridge method [inline-methods] */
    public C0629il getItem(int i) {
        ArrayList<C0629il> nonActionItems = this.f3902Ilil ? this.f3901ILil.getNonActionItems() : this.f3901ILil.getVisibleItems();
        int i2 = this.f3900I1I;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return nonActionItems.get(i);
    }

    public void IL1Iii() {
        C0629il expandedItem = this.f3901ILil.getExpandedItem();
        if (expandedItem != null) {
            ArrayList<C0629il> nonActionItems = this.f3901ILil.getNonActionItems();
            int size = nonActionItems.size();
            for (int i = 0; i < size; i++) {
                if (nonActionItems.get(i) == expandedItem) {
                    this.f3900I1I = i;
                    return;
                }
            }
        }
        this.f3900I1I = -1;
    }

    public IiL ILil() {
        return this.f3901ILil;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m1887IL(boolean z) {
        this.f1479IL = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<C0629il> nonActionItems = this.f3902Ilil ? this.f3901ILil.getNonActionItems() : this.f3901ILil.getVisibleItems();
        return this.f3900I1I < 0 ? nonActionItems.size() : nonActionItems.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f1481lLi1LL.inflate(this.f1480iILLL1, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f3901ILil.isGroupDividerEnabled() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        Lil.IL1Iii iL1Iii = (Lil.IL1Iii) view;
        if (this.f1479IL) {
            listMenuItemView.setForceShowIcon(true);
        }
        iL1Iii.initialize(getItem(i), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        IL1Iii();
        super.notifyDataSetChanged();
    }
}
