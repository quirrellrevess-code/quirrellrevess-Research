package ILil.ILil.p024llL1ii.ILL;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: compiled from: SubMenuBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class iIi1 extends IiL implements SubMenu {
    private C0629il mItem;
    private IiL mParentMenu;

    public iIi1(Context context, IiL iiL, C0629il c0629il) {
        super(context);
        this.mParentMenu = iiL;
        this.mItem = c0629il;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.IiL
    public boolean collapseItemActionView(C0629il c0629il) {
        return this.mParentMenu.collapseItemActionView(c0629il);
    }

    @Override // ILil.ILil.p024llL1ii.ILL.IiL
    public boolean dispatchMenuItemSelected(IiL iiL, MenuItem menuItem) {
        return super.dispatchMenuItemSelected(iiL, menuItem) || this.mParentMenu.dispatchMenuItemSelected(iiL, menuItem);
    }

    @Override // ILil.ILil.p024llL1ii.ILL.IiL
    public boolean expandItemActionView(C0629il c0629il) {
        return this.mParentMenu.expandItemActionView(c0629il);
    }

    @Override // ILil.ILil.p024llL1ii.ILL.IiL
    public String getActionViewStatesKey() {
        C0629il c0629il = this.mItem;
        int itemId = c0629il != null ? c0629il.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.getActionViewStatesKey() + ":" + itemId;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.mItem;
    }

    public Menu getParentMenu() {
        return this.mParentMenu;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.IiL
    public IiL getRootMenu() {
        return this.mParentMenu.getRootMenu();
    }

    @Override // ILil.ILil.p024llL1ii.ILL.IiL
    public boolean isGroupDividerEnabled() {
        return this.mParentMenu.isGroupDividerEnabled();
    }

    @Override // ILil.ILil.p024llL1ii.ILL.IiL
    public boolean isQwertyMode() {
        return this.mParentMenu.isQwertyMode();
    }

    @Override // ILil.ILil.p024llL1ii.ILL.IiL
    public boolean isShortcutsVisible() {
        return this.mParentMenu.isShortcutsVisible();
    }

    @Override // ILil.ILil.p024llL1ii.ILL.IiL
    public void setCallback(IiL.IL1Iii iL1Iii) {
        this.mParentMenu.setCallback(iL1Iii);
    }

    @Override // ILil.ILil.p024llL1ii.ILL.IiL, android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.mParentMenu.setGroupDividerEnabled(z);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.setHeaderIconInt(drawable);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.setHeaderTitleInt(charSequence);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.setHeaderViewInt(view);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.mItem.setIcon(drawable);
        return this;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.IiL, android.view.Menu
    public void setQwertyMode(boolean z) {
        this.mParentMenu.setQwertyMode(z);
    }

    @Override // ILil.ILil.p024llL1ii.ILL.IiL
    public void setShortcutsVisible(boolean z) {
        this.mParentMenu.setShortcutsVisible(z);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.setHeaderIconInt(i);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.setHeaderTitleInt(i);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.mItem.setIcon(i);
        return this;
    }
}
