package I1I.p062Ilil.ILil;

import I1I.I1I.p008IL.lIlii;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.flexbox.BuildConfig;
import com.p000nx.baseui.SlidingTabLayout;
import com.p000nx.baseui.ViewPagerEx;
import com.qyzs.smn2.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: renamed from: I1I.Ilil.ILil.iI丨LLL1, reason: invalid class name */
/* JADX INFO: compiled from: UiShowLayout.java */
/* JADX INFO: loaded from: classes.dex */
public class iILLL1 {

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public static int f1135lL;
    public View.OnTouchListener I11li1;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public LinearLayout f3487I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public Context f3488IL1Iii;
    public HashMap<String, String> ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public LinearLayout f3489ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public WindowManager.LayoutParams f1136ILl;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public Set<String> f1138IiL;
    public WindowManager Lil;
    public View.OnClickListener LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public TextView f1139Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public ArrayList<SlidingTabLayout> f1140L11I;
    public String iIi1;
    public List<LinearLayout> iIlLiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public HashMap<String, String> f1141iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public LinearLayout f1142lIiI;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public I1I.p062Ilil.ILil.lLi1LL f1143lIlii;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public View.OnClickListener f1144llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean f1145lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public Set<String> f1146il;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public String f1137IL = BuildConfig.FLAVOR;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public LinearLayout f3490Ilil = null;

    /* JADX INFO: renamed from: I1I.Ilil.ILil.iI丨LLL1$I1I */
    /* JADX INFO: compiled from: UiShowLayout.java */
    public class I1I implements View.OnClickListener {
        public I1I() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener = iILLL1.this.f1144llL1ii;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* JADX INFO: renamed from: I1I.Ilil.ILil.iI丨LLL1$IL1Iii */
    /* JADX INFO: compiled from: UiShowLayout.java */
    public class IL1Iii extends Handler {
        public IL1Iii() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 256) {
                iILLL1.this.f1142lIiI.invalidate();
            }
        }
    }

    /* JADX INFO: renamed from: I1I.Ilil.ILil.iI丨LLL1$ILil */
    /* JADX INFO: compiled from: UiShowLayout.java */
    public class ILil implements View.OnClickListener {
        public ILil() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener = iILLL1.this.LlLI1;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* JADX INFO: renamed from: I1I.Ilil.ILil.iI丨LLL1$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: UiShowLayout.java */
    public class IL implements View.OnTouchListener {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public float f3494I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public float f3495ILil;

        public IL() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f3495ILil = rawX;
                this.f3494I1I = rawY;
                return false;
            }
            if (action != 2) {
                return false;
            }
            WindowManager.LayoutParams layoutParams = iILLL1.this.f1136ILl;
            layoutParams.x = (int) ((layoutParams.x + rawX) - this.f3495ILil);
            int i = (int) ((iILLL1.this.f1136ILl.y + rawY) - this.f3494I1I);
            layoutParams.y = i;
            iILLL1.this.m1300l(layoutParams.x, i);
            this.f3495ILil = rawX;
            this.f3494I1I = rawY;
            return false;
        }
    }

    /* JADX INFO: renamed from: I1I.Ilil.ILil.iI丨LLL1$iI丨LLL1, reason: invalid class name and collision with other inner class name */
    /* JADX INFO: compiled from: UiShowLayout.java */
    public class C0539iILLL1 implements ViewPager.InterfaceC0668il {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ ViewPagerEx f3496IL1Iii;

        public C0539iILLL1(iILLL1 iilll1, ViewPagerEx viewPagerEx) {
            this.f3496IL1Iii = viewPagerEx;
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0668il
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0668il
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0668il
        public void onPageSelected(int i) {
            this.f3496IL1Iii.m3501iI1iI(i);
        }
    }

    /* JADX INFO: renamed from: I1I.Ilil.ILil.iI丨LLL1$l丨Li1LL, reason: invalid class name */
    /* JADX INFO: compiled from: UiShowLayout.java */
    public class lLi1LL implements ViewPager.InterfaceC0668il {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ SlidingTabLayout f3497IL1Iii;

        public lLi1LL(iILLL1 iilll1, SlidingTabLayout slidingTabLayout) {
            this.f3497IL1Iii = slidingTabLayout;
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0668il
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0668il
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0668il
        public void onPageSelected(int i) {
            this.f3497IL1Iii.setFocusable(true);
            this.f3497IL1Iii.setFocusableInTouchMode(true);
            this.f3497IL1Iii.getViewPager().requestFocus();
        }
    }

    static {
        I1I.IL1Iii.IL1Iii(new byte[]{0, 8, 68, 17, 70, 61, 20, 14, 65, 61, 91, 6}, I1I.IL1Iii.IL1Iii(new byte[]{7, 87, 7, 4, 87, 7}, I1I.IL1Iii.IL1Iii(new byte[]{86, 14, 2, 0, 4, 86}, "783fa3")));
        I1I.IL1Iii.IL1Iii(new byte[]{16, 9, 65, 110, 95, 92}, I1I.IL1Iii.IL1Iii(new byte[]{86, 2, 5, 1, 3, 89}, I1I.IL1Iii.IL1Iii(new byte[]{5, 82, 5, 5, 0, 5}, "16655d")));
    }

    public iILLL1(Context context, String str, int i, int i2) {
        new IL1Iii();
        this.f1145lLi1LL = false;
        this.f1141iILLL1 = new HashMap<>();
        this.f1138IiL = new HashSet();
        this.f1140L11I = new ArrayList<>();
        this.f1146il = new HashSet();
        this.ILL = new HashMap<>();
        this.iIi1 = null;
        this.I11li1 = new IL();
        this.f3488IL1Iii = context;
        this.f1143lIlii = I1I.p062Ilil.ILil.lLi1LL.Lil(context);
        this.iIlLiL = new ArrayList();
        m1298il();
        m1293L11I(i, i2);
        iIi1(str);
        m1292Ll1(4096, I1I.IL1Iii.IL1Iii(new byte[]{70, 95, 20, 61, 81, 83}, I1I.IL1Iii.IL1Iii(new byte[]{1, 9, 87, 84, 89, 85}, I1I.IL1Iii.IL1Iii(new byte[]{80, 88, 82, 7, 2, 3}, "eaf1ca"))), str, -1, -2, BuildConfig.FLAVOR);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static String m1288iILLL1() {
        StringBuilder sb = new StringBuilder();
        sb.append(I1I.IL1Iii.IL1Iii(new byte[]{5, 12, 71, 70, 67, 103, 22, 20, 71, 90, 64, 103}, I1I.IL1Iii.IL1Iii(new byte[]{1, 4, 86, 5, 0, 94}, I1I.IL1Iii.IL1Iii(new byte[]{3, 3, 81, 5, 2, 3}, "ab255e"))));
        int i = f1135lL;
        f1135lL = i + 1;
        sb.append(i);
        return sb.toString();
    }

    public void I11L(String str, String str2, int i) {
        if (i != 8 && i != 0 && i != 4) {
            i = 0;
        }
        if (!str.equals(m1291IiL())) {
            if (this.f1138IiL.contains(str)) {
                ((IiL) ((SlidingTabLayout) this.f1142lIiI.findViewWithTag(this.ILL.get(str))).getViewPager().getAdapter()).m1282LlLLL(str2, i);
                return;
            }
            return;
        }
        for (LinearLayout linearLayout : this.iIlLiL) {
            String str3 = (String) linearLayout.getTag(R.id.tagGroupId);
            if (!TextUtils.isEmpty(str3) && str3.compareTo(str2) == 0) {
                linearLayout.setVisibility(i);
            }
        }
    }

    public void I11li1(String str) {
        this.f1139Ll1.setText(str);
    }

    public void I1I(View view, String str) {
        if (str.equals(this.iIi1)) {
            this.f3489ILil.addView(view);
        } else if (this.f1138IiL.contains(str)) {
            ((IiL) ((SlidingTabLayout) this.f1142lIiI.findViewWithTag(this.ILL.get(str))).getViewPager().getAdapter()).I11L(view, str, this.f1141iILLL1.get(str));
        }
    }

    public boolean ILL() {
        return this.f1145lLi1LL;
    }

    public boolean ILil(int i, String str, String str2, String str3) {
        if (!this.f1146il.contains(str2)) {
            return false;
        }
        String strM1288iILLL1 = m1288iILLL1();
        this.f1138IiL.add(str);
        this.f1141iILLL1.put(str, strM1288iILLL1);
        this.ILL.put(str, str2);
        LinearLayout linearLayoutM1306L11I = this.f1143lIlii.m1306L11I(i, str);
        linearLayoutM1306L11I.setId(i);
        linearLayoutM1306L11I.addView(this.f1143lIlii.LlLI1(0, strM1288iILLL1, -1, -2));
        ((SlidingTabLayout) this.f1142lIiI.findViewWithTag(str2)).IL1Iii(linearLayoutM1306L11I, str3);
        return true;
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final int m1289ILl(int i) {
        return (int) (i * (this.f3488IL1Iii.getResources().getDisplayMetrics().densityDpi / 160.0f));
    }

    public View Ilil(String str) {
        View viewFindViewWithTag = this.f1142lIiI.findViewWithTag(str);
        if (viewFindViewWithTag == null) {
            Iterator<SlidingTabLayout> it = this.f1140L11I.iterator();
            while (it.hasNext() && (viewFindViewWithTag = ((IiL) it.next().getViewPager().getAdapter()).llliI(str)) == null) {
            }
        }
        return viewFindViewWithTag;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m1290IL() {
        this.f1145lLi1LL = false;
        this.Lil.removeView(this.f3487I1I);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public String m1291IiL() {
        return this.iIi1;
    }

    public void Lil(int i) {
        try {
            this.f3490Ilil.setBackgroundColor(i);
        } catch (Exception unused) {
        }
    }

    public void LlLI1(String str) {
        this.f1137IL = str;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public void m1292Ll1(int i, String str, String str2, int i2, int i3, String str3) {
        if (!str2.equals(m1291IiL())) {
            if (this.f1138IiL.contains(str2)) {
                ((IiL) ((SlidingTabLayout) this.f1142lIiI.findViewWithTag(this.ILL.get(str2))).getViewPager().getAdapter()).m12871(str, str2, i2, i3, str3);
                this.f1141iILLL1.put(str2, str);
                return;
            }
            return;
        }
        this.f3489ILil = this.f1143lIlii.LlLI1(i, str, i2, i3);
        if (!TextUtils.isEmpty(str3)) {
            this.f3489ILil.setTag(R.id.tagGroupId, str3);
            if (!TextUtils.isEmpty(str3)) {
                this.f3489ILil.setTag(R.id.tagGroupId, str3);
                this.iIlLiL.add(this.f3489ILil);
            }
        }
        this.f1142lIiI.addView(this.f3489ILil);
        this.f1141iILLL1.put(str2, str);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final void m1293L11I(int i, int i2) {
        DisplayMetrics displayMetrics = this.f3488IL1Iii.getResources().getDisplayMetrics();
        if (i != -1 && i != -2) {
            if (i >= displayMetrics.widthPixels) {
                i = -1;
            } else if (i < -2 || (i >= 0 && i < m1289ILl(200))) {
                i = m1289ILl(200);
            }
        }
        if (i2 != -1 && i2 != -2) {
            if (i2 >= displayMetrics.heightPixels) {
                i2 = -2;
            } else if (i2 < -2 || (i2 >= 0 && i2 < m1289ILl(200))) {
                i2 = m1289ILl(200);
            }
        }
        Log.i(I1I.IL1Iii.IL1Iii(new byte[]{126, 59}, I1I.IL1Iii.IL1Iii(new byte[]{6, 2, 86, 89, 80, 81}, I1I.IL1Iii.IL1Iii(new byte[]{6, 88, 0, 3, 6, 80}, "09ab04"))), I1I.IL1Iii.IL1Iii(new byte[]{17, 93, 10}, I1I.IL1Iii.IL1Iii(new byte[]{84, 83, 8, 84, 6, 5}, I1I.IL1Iii.IL1Iii(new byte[]{0, 7, 94, 92, 4, 6}, "2af8f3"))) + i + I1I.IL1Iii.IL1Iii(new byte[]{95}, I1I.IL1Iii.IL1Iii(new byte[]{86, 92, 9, 81, 8, 81}, I1I.IL1Iii.IL1Iii(new byte[]{0, 1, 88, 6, 2, 86}, "2da53f"))) + i2);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f3488IL1Iii);
        this.f3487I1I = (LinearLayout) layoutInflaterFrom.inflate(R.layout.layout_ui_show, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) layoutInflaterFrom.inflate(R.layout.layout_display, (ViewGroup) null);
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(i, i2));
        this.f3490Ilil = linearLayout;
        this.f3487I1I.setGravity(17);
        this.f3487I1I.addView(linearLayout);
        this.f1139Ll1 = (TextView) this.f3487I1I.findViewById(R.id.title);
        this.f1142lIiI = (LinearLayout) this.f3487I1I.findViewById(R.id.layout_user);
        this.f3487I1I.findViewById(R.id.exit).setOnClickListener(new ILil());
        this.f3487I1I.findViewById(R.id.next).setOnClickListener(new I1I());
        this.f3487I1I.setOnTouchListener(this.I11li1);
        WindowManager.LayoutParams layoutParams = this.f1136ILl;
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public final void iIi1(String str) {
        this.iIi1 = str;
        I11li1(str);
    }

    public void iIlLiL(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        this.f1139Ll1.setBackground(gradientDrawable);
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public void m1294lIiI(String str, int i, int i2) {
        this.f1146il.add(str);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f3488IL1Iii).inflate(R.layout.ui_sliding_layout, (ViewGroup) null);
        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) linearLayout.findViewById(R.id.slidingTabLayout);
        slidingTabLayout.setTag(str);
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setSelectedIndicatorColors(this.f3488IL1Iii.getResources().getColor(R.color.ui_show_blue));
        slidingTabLayout.setOnPageChangeListener(new lLi1LL(this, slidingTabLayout));
        ViewPagerEx viewPagerEx = (ViewPagerEx) linearLayout.findViewById(R.id.viewPager);
        Log.i(I1I.IL1Iii.IL1Iii(new byte[]{44, 60}, I1I.IL1Iii.IL1Iii(new byte[]{86, 85, 81, 87, 4, 8}, I1I.IL1Iii.IL1Iii(new byte[]{4, 84, 1, 93, 87, 12}, "0ee8a5"))), I1I.IL1Iii.IL1Iii(new byte[]{92, 11, 92, 91, 7}, I1I.IL1Iii.IL1Iii(new byte[]{4, 6, 87, 0, 8, 1}, I1I.IL1Iii.IL1Iii(new byte[]{6, 1, 2, 0, 3, 85}, "614f2b"))) + i2);
        if (i2 == -2) {
            viewPagerEx.setIsNeedSetHeight(true);
        }
        viewPagerEx.setLayoutParams(new LinearLayout.LayoutParams(-1, i2));
        viewPagerEx.I1I(new C0539iILLL1(this, viewPagerEx));
        viewPagerEx.setAdapter(new IiL(new ArrayList(), new ArrayList()));
        slidingTabLayout.setViewPager(viewPagerEx);
        viewPagerEx.m3501iI1iI(0);
        this.f1142lIiI.addView(linearLayout);
        this.f1140L11I.add(slidingTabLayout);
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public void m1295lIlii(View.OnClickListener onClickListener) {
        this.f1144llL1ii = onClickListener;
    }

    public void llliI(boolean z, boolean z2, int i, int i2) {
        int i3;
        int i4;
        this.f1145lLi1LL = true;
        LinearLayout linearLayout = (LinearLayout) this.f3490Ilil.findViewById(R.id.control_bar);
        TextView textView = (TextView) this.f3490Ilil.findViewById(R.id.title);
        if (z) {
            linearLayout.setVisibility(0);
        } else {
            linearLayout.setVisibility(8);
        }
        if (z2) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        Point pointM1123IIi = lIlii.m1123IIi(this.f3488IL1Iii);
        if (i > 0 && i > (i4 = pointM1123IIi.x)) {
            i = i4;
        }
        if (i2 > 0 && i2 > (i3 = pointM1123IIi.y)) {
            i2 = i3;
        }
        if (i >= 0 && i2 >= 0) {
            WindowManager.LayoutParams layoutParams = this.f1136ILl;
            layoutParams.x = i;
            layoutParams.y = i2;
            layoutParams.gravity = 51;
        }
        if (this.f3487I1I.getParent() == null) {
            this.Lil.addView(this.f3487I1I, this.f1136ILl);
        } else {
            this.Lil.updateViewLayout(this.f3487I1I, this.f1136ILl);
        }
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public void m1296llL1ii(View.OnClickListener onClickListener) {
        this.LlLI1 = onClickListener;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public String m1297lLi1LL() {
        return this.f1137IL;
    }

    @SuppressLint({"WrongConstant"})
    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final void m1298il() {
        this.Lil = (WindowManager) this.f3488IL1Iii.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{17, 93, 90, 1, 94, 79}, I1I.IL1Iii.IL1Iii(new byte[]{5, 0, 80, 87, 2, 12}, I1I.IL1Iii.IL1Iii(new byte[]{7, 82, 83, 5, 11, 1}, "df7785"))));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f1136ILl = layoutParams;
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            layoutParams.type = 2038;
        } else if (i < 19 || i >= 24) {
            layoutParams.type = 2002;
        } else {
            layoutParams.type = 2005;
        }
        layoutParams.format = 1;
        layoutParams.gravity = 16;
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.flags = 65824;
        layoutParams.alpha = 1.0f;
        layoutParams.width = -1;
        layoutParams.height = -1;
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public void m1299lL(int i) {
        this.f1139Ll1.setTextColor(i);
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public void m1300l(int i, int i2) {
        WindowManager.LayoutParams layoutParams = this.f1136ILl;
        layoutParams.x = i;
        layoutParams.y = i2;
        this.Lil.updateViewLayout(this.f3487I1I, layoutParams);
    }
}
