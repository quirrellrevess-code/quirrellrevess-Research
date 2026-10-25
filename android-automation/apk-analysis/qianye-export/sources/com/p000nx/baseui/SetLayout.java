package com.p000nx.baseui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TableLayout;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SetLayout extends LinearLayout implements RadioGroup.OnCheckedChangeListener {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public RadioGroup f5412I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f5413ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public List<ScrollView> f5414Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public FrameLayout f2952IL;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int f2953lLi1LL;

    public SetLayout(Context context) {
        this(context, null);
    }

    public int getCurrentItem() {
        return this.f5413ILil;
    }

    public List<ScrollView> getScrollViewList() {
        return this.f5414Ilil;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        setSelectTab(i);
    }

    public void setSelectTab(int i) {
        if (this.f5414Ilil.size() != 0) {
            if (i < 0 || i > 6) {
                i = 0;
            }
            this.f5413ILil = i;
            this.f5412I1I.check(i);
            this.f2952IL.removeAllViews();
            this.f2952IL.addView(this.f5414Ilil.get(i));
        }
    }

    public SetLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SetLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2953lLi1LL = (int) TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics());
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        setOrientation(0);
        LinearLayout linearLayout = new LinearLayout(context);
        TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(0, -1);
        layoutParams.weight = 7.5f;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(1);
        ScrollView scrollView = new ScrollView(context);
        RadioGroup radioGroup = new RadioGroup(context);
        this.f5412I1I = radioGroup;
        radioGroup.setOrientation(1);
        RadioGroup radioGroup2 = this.f5412I1I;
        int i2 = this.f2953lLi1LL;
        radioGroup2.setPadding(i2, 0, 0, -i2);
        scrollView.addView(this.f5412I1I);
        linearLayout.addView(scrollView);
        addView(linearLayout);
        View view = new View(context);
        view.setLayoutParams(new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 1.0f, context.getResources().getDisplayMetrics()), -1));
        view.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        addView(view);
        this.f2952IL = new FrameLayout(context);
        TableLayout.LayoutParams layoutParams2 = new TableLayout.LayoutParams(0, -1);
        layoutParams2.weight = 2.5f;
        this.f2952IL.setLayoutParams(layoutParams2);
        FrameLayout frameLayout = this.f2952IL;
        int i3 = this.f2953lLi1LL;
        frameLayout.setPadding(i3, 0, i3, 0);
        addView(this.f2952IL);
        this.f5414Ilil = new ArrayList(7);
        this.f5412I1I.setOnCheckedChangeListener(this);
    }
}
