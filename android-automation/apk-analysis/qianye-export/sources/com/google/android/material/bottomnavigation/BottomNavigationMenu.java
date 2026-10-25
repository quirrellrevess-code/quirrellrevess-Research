package com.google.android.material.bottomnavigation;

import ILil.ILil.p024llL1ii.ILL.C0629il;
import ILil.ILil.p024llL1ii.ILL.IiL;
import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: loaded from: classes.dex */
public final class BottomNavigationMenu extends IiL {
    public static final int MAX_ITEM_COUNT = 5;

    public BottomNavigationMenu(Context context) {
        super(context);
    }

    @Override // ILil.ILil.p024llL1ii.ILL.IiL
    public MenuItem addInternal(int i, int i2, int i3, CharSequence charSequence) {
        if (size() + 1 > 5) {
            throw new IllegalArgumentException("Maximum number of items supported by BottomNavigationView is 5. Limit can be checked with BottomNavigationView#getMaxItemCount()");
        }
        stopDispatchingItemsChanged();
        MenuItem menuItemAddInternal = super.addInternal(i, i2, i3, charSequence);
        if (menuItemAddInternal instanceof C0629il) {
            ((C0629il) menuItemAddInternal).iIlLiL(true);
        }
        startDispatchingItemsChanged();
        return menuItemAddInternal;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.IiL, android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        throw new UnsupportedOperationException("BottomNavigationView does not support submenus");
    }
}
