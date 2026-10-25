package com.google.android.material.internal;

import ILil.ILil.p024llL1ii.ILL.C0629il;
import ILil.ILil.p024llL1ii.ILL.IiL;
import android.content.Context;
import android.view.SubMenu;

/* JADX INFO: loaded from: classes.dex */
public class NavigationMenu extends IiL {
    public NavigationMenu(Context context) {
        super(context);
    }

    @Override // ILil.ILil.p024llL1ii.ILL.IiL, android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        C0629il c0629il = (C0629il) addInternal(i, i2, i3, charSequence);
        NavigationSubMenu navigationSubMenu = new NavigationSubMenu(getContext(), this, c0629il);
        c0629il.llliI(navigationSubMenu);
        return navigationSubMenu;
    }
}
