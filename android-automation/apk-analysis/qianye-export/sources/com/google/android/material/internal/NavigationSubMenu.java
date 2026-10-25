package com.google.android.material.internal;

import ILil.ILil.p024llL1ii.ILL.C0629il;
import ILil.ILil.p024llL1ii.ILL.IiL;
import ILil.ILil.p024llL1ii.ILL.iIi1;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class NavigationSubMenu extends iIi1 {
    public NavigationSubMenu(Context context, NavigationMenu navigationMenu, C0629il c0629il) {
        super(context, navigationMenu, c0629il);
    }

    @Override // ILil.ILil.p024llL1ii.ILL.IiL
    public void onItemsChanged(boolean z) {
        super.onItemsChanged(z);
        ((IiL) getParentMenu()).onItemsChanged(z);
    }
}
