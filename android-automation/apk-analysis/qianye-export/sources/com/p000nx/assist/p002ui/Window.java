package com.p000nx.assist.p002ui;

import I1I.I1I.ILil.l1IIi1;
import I1I.I1I.p008IL.lIlii;
import I1I.IL1Iii;
import I1I.p062Ilil.ILil.IiL;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.p000nx.assist.UIMgr;
import com.p000nx.baseui.SlidingTabLayout;
import com.p000nx.baseui.ViewPagerEx;
import com.qyzs.smn2.R;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Window extends LinearLayout {
    private boolean isHideTagHeader;
    private View mRootView;
    private SlidingTabLayout mSlidingTabLayout;
    private LinearLayout mViewContainer;
    private FrameLayout mViewContainerPage;
    private ViewPagerEx mViewPager;
    private ViewOnClickListenerC0318UI mWindow;

    public Window(Context context, ViewOnClickListenerC0318UI viewOnClickListenerC0318UI) {
        super(context);
        this.isHideTagHeader = false;
        this.mWindow = viewOnClickListenerC0318UI;
        View viewInflate = LinearLayout.inflate(context, R.layout.window, this);
        this.mRootView = viewInflate;
        TextView textView = (TextView) viewInflate.findViewById(R.id.title);
        String attribString = viewOnClickListenerC0318UI.getAttribString(IL1Iii.IL1Iii(new byte[]{65, 88, 21, 85, 87}, IL1Iii.IL1Iii(new byte[]{4, 85, 87, 9, 7, 85}, IL1Iii.IL1Iii(new byte[]{4, 5, 14, 7, 83, 82}, "5a87f4"))));
        if (!TextUtils.isEmpty(attribString)) {
            textView.setText(attribString);
        }
        this.mViewContainer = (LinearLayout) viewInflate.findViewById(R.id.uicontain_tab);
        this.mViewContainerPage = (FrameLayout) viewInflate.findViewById(R.id.uicontain_page);
        boolean attribBoolean = this.mWindow.getAttribBoolean(IL1Iii.IL1Iii(new byte[]{66, 12, 12, 22, 76, 95, 69, 8, 6, 3, 89, 68}, IL1Iii.IL1Iii(new byte[]{87, 80, 5, 82, 11, 80}, IL1Iii.IL1Iii(new byte[]{83, 4, 84, 4, 10, 3}, "50279e"))), true);
        boolean attribBoolean2 = this.mWindow.getAttribBoolean(IL1Iii.IL1Iii(new byte[]{65, 90, 12, 69, 5, 91, 92, 84, 10, 64, 11}, IL1Iii.IL1Iii(new byte[]{2, 1, 87, 2, 4, 87}, IL1Iii.IL1Iii(new byte[]{4, 6, 2, 82, 6, 91}, "456bd8"))), true);
        if (!attribBoolean) {
            viewInflate.findViewById(R.id.titlebar).setVisibility(8);
        }
        if (!attribBoolean2) {
            viewInflate.findViewById(R.id.laybottom).setVisibility(8);
        }
        int attribInt = this.mWindow.getAttribInt(IL1Iii.IL1Iii(new byte[]{21, 86, 3, 92, 92, 7, 5, 82, 22}, IL1Iii.IL1Iii(new byte[]{87, 7, 92, 13, 9, 95}, IL1Iii.IL1Iii(new byte[]{3, 84, 1, 10, 84, 11}, "5d93d2"))), 70);
        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) viewInflate.findViewById(R.id.slidingTabLayout);
        this.mSlidingTabLayout = slidingTabLayout;
        slidingTabLayout.setDistributeEvenly(true);
        this.mSlidingTabLayout.setSelectedIndicatorColors(context.getResources().getColor(R.color.ui_show_blue));
        this.mSlidingTabLayout.setOnPageChangeListener(new ViewPager.InterfaceC0668il() { // from class: com.nx.assist.ui.Window.1
            @Override // androidx.viewpager.widget.ViewPager.InterfaceC0668il
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.InterfaceC0668il
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.InterfaceC0668il
            public void onPageSelected(int i) {
                Window.this.mSlidingTabLayout.setFocusable(true);
                Window.this.mSlidingTabLayout.setFocusableInTouchMode(true);
                Window.this.mSlidingTabLayout.getViewPager().requestFocus();
            }
        });
        ViewPagerEx viewPagerEx = (ViewPagerEx) viewInflate.findViewById(R.id.viewPager);
        this.mViewPager = viewPagerEx;
        viewPagerEx.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.mViewPager.I1I(new ViewPager.InterfaceC0668il() { // from class: com.nx.assist.ui.Window.2
            @Override // androidx.viewpager.widget.ViewPager.InterfaceC0668il
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.InterfaceC0668il
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.InterfaceC0668il
            public void onPageSelected(int i) {
                Window.this.mViewPager.m3501iI1iI(i);
            }
        });
        this.mViewPager.setAdapter(new IiL(new ArrayList(), new ArrayList()));
        this.mSlidingTabLayout.setViewPager(this.mViewPager);
        this.mViewPager.m3501iI1iI(0);
        if (attribInt == 0) {
            this.isHideTagHeader = true;
            this.mViewContainer.setVisibility(8);
            this.mViewContainerPage.setVisibility(0);
        } else {
            this.isHideTagHeader = false;
            this.mViewContainer.setVisibility(0);
            this.mViewContainerPage.setVisibility(8);
        }
        viewInflate.findViewById(R.id.exit).setOnClickListener(new View.OnClickListener() { // from class: com.nx.assist.ui.Window.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UIMgr.getInstance().sendEvent(Window.this.mWindow.getHandle(), 102, 0, 0, 0, new JSONObject().toString());
            }
        });
        viewInflate.findViewById(R.id.next).setOnClickListener(new View.OnClickListener() { // from class: com.nx.assist.ui.Window.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String result = Window.this.getResult();
                if (TextUtils.isEmpty(result)) {
                    result = new JSONObject().toString();
                }
                UIMgr.getInstance().sendEvent(Window.this.mWindow.getHandle(), 102, 1, 0, 0, result);
            }
        });
    }

    public boolean addTab(String str, UIPage uIPage) {
        if (this.isHideTagHeader) {
            this.mViewContainerPage.addView(uIPage);
            return true;
        }
        this.mSlidingTabLayout.IL1Iii(uIPage, str);
        return true;
    }

    public void confirm() {
        String result = getResult();
        if (TextUtils.isEmpty(result)) {
            result = new JSONObject().toString();
        }
        UIMgr.getInstance().sendEvent(this.mWindow.getHandle(), 102, 1, 0, 0, result);
    }

    public String getConfigName() {
        return this.mWindow.getAttribString(IL1Iii.IL1Iii(new byte[]{87, 14, 11, 85, 15, 86}, IL1Iii.IL1Iii(new byte[]{12, 87, 84, 86, 94, 2}, IL1Iii.IL1Iii(new byte[]{11, 2, 84, 0, 1, 2}, "34ee91"))));
    }

    public String getResult() {
        return this.mWindow.checkResult();
    }

    public ViewOnClickListenerC0318UI getUI() {
        return this.mWindow;
    }

    public void hideBottom() {
        findViewById(R.id.laybottom).setVisibility(8);
    }

    public void hideTitle() {
        findViewById(R.id.titlebar).setVisibility(8);
    }

    public void saveCfg() {
        String result = getResult();
        if (TextUtils.isEmpty(result)) {
            result = new JSONObject().toString();
        }
        String strIL1Iii = IL1Iii.IL1Iii(new byte[]{89, 83, 10, 95, 31, 81, 91, 92, 5, 88, 86}, IL1Iii.IL1Iii(new byte[]{2, 10, 1, 6, 5, 83}, IL1Iii.IL1Iii(new byte[]{80, 90, 83, 0, 86, 83}, "fb17b2")));
        if (result != null) {
            String configName = getConfigName();
            if (!TextUtils.isEmpty(configName)) {
                strIL1Iii = configName;
            }
            lIlii.I1i(result, l1IIi1.I1I().m1018L11I(strIL1Iii).getAbsolutePath());
        }
    }

    public void setValOnFlate() {
        this.mWindow.setValOnFlate();
    }
}
