package androidx.appcompat.view.menu;

import ILil.ILil.p023lIlii.llI;
import ILil.ILil.p024llL1ii.ILL.C0629il;
import ILil.ILil.p024llL1ii.ILL.IiL;
import ILil.ILil.p024llL1ii.ILL.Lil;
import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/* JADX INFO: loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements IiL.ILil, Lil, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static final int[] f2320IL = {R.attr.background, R.attr.divider};

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f4810I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public IiL f4811ILil;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    @Override // ILil.ILil.p024llL1ii.ILL.IiL.ILil
    public boolean IL1Iii(C0629il c0629il) {
        return this.f4811ILil.performItemAction(c0629il, 0);
    }

    public int getWindowAnimations() {
        return this.f4810I1I;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.Lil
    public void initialize(IiL iiL) {
        this.f4811ILil = iiL;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        IL1Iii((C0629il) getAdapter().getItem(i));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        llI lliI11li1 = llI.I11li1(context, attributeSet, f2320IL, i, 0);
        if (lliI11li1.m1829lIlii(0)) {
            setBackgroundDrawable(lliI11li1.m1827iILLL1(0));
        }
        if (lliI11li1.m1829lIlii(1)) {
            setDivider(lliI11li1.m1827iILLL1(1));
        }
        lliI11li1.m1833lL();
    }
}
