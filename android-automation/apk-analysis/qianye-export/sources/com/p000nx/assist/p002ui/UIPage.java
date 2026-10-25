package com.p000nx.assist.p002ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.qyzs.smn2.R;

/* JADX INFO: loaded from: classes.dex */
public class UIPage extends LinearLayout {
    private LinearLayout mContainer;

    public UIPage(Context context) {
        super(context);
        this.mContainer = (LinearLayout) LinearLayout.inflate(getContext(), R.layout.ui_page, this).findViewById(R.id.container);
    }

    public void addChildView(View view) {
        LinearLayout linearLayout = this.mContainer;
        if (linearLayout != null) {
            linearLayout.addView(view);
        }
    }

    public void addChildView(View view, ViewGroup.LayoutParams layoutParams) {
        LinearLayout linearLayout = this.mContainer;
        if (linearLayout != null) {
            linearLayout.addView(view, layoutParams);
        }
    }
}
