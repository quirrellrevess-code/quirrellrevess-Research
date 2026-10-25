package ILil.ILil.p024llL1ii.ILL;

import ILil.p028IiL.p030IiL.IL1Iii.I1I;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: compiled from: SubMenuWrapperICS.java */
/* JADX INFO: loaded from: classes.dex */
public class iIlLiL extends LlLI1 implements SubMenu {

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final I1I f3899Ilil;

    public iIlLiL(Context context, I1I i1i) {
        super(context, i1i);
        this.f3899Ilil = i1i;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        this.f3899Ilil.clearHeader();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return I1I(this.f3899Ilil.getItem());
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        this.f3899Ilil.setHeaderIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        this.f3899Ilil.setHeaderTitle(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        this.f3899Ilil.setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.f3899Ilil.setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f3899Ilil.setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f3899Ilil.setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f3899Ilil.setIcon(drawable);
        return this;
    }
}
