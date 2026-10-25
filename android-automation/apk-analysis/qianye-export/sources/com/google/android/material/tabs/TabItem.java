package com.google.android.material.tabs;

import ILil.ILil.p023lIlii.llI;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.C0016R;

/* JADX INFO: loaded from: classes.dex */
public class TabItem extends View {
    public final int customLayout;
    public final Drawable icon;
    public final CharSequence text;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        llI lliIIlLiL = llI.iIlLiL(context, attributeSet, C0016R.styleable.TabItem);
        this.text = lliIIlLiL.LlLI1(C0016R.styleable.TabItem_android_text);
        this.icon = lliIIlLiL.m1827iILLL1(C0016R.styleable.TabItem_android_icon);
        this.customLayout = lliIIlLiL.m1822ILl(C0016R.styleable.TabItem_android_layout, 0);
        lliIIlLiL.m1833lL();
    }
}
