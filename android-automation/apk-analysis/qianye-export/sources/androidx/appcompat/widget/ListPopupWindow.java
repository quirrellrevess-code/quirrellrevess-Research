package androidx.appcompat.widget;

import ILil.ILil.ILL;
import ILil.ILil.p023lIlii.lIlii;
import ILil.ILil.p024llL1ii.ILL.llL1ii;
import ILil.p028IiL.Lil.L11I;
import ILil.p028IiL.p029ILl.iIlLiL;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.mysql.jdbc.MysqlErrorNumbers;
import java.lang.reflect.Method;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes.dex */
public class ListPopupWindow implements llL1ii {

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public static Method f2415L1l;

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public static Method f2416l1IIi1;
    public static Method llI;
    public AdapterView.OnItemSelectedListener I11L;
    public Drawable I11li1;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public ListAdapter f4880I1I;
    public boolean ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Context f4881ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public boolean f2417ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public int f4882Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public lIlii f2418IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public int f2419IiL;

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public Rect f2420L111;
    public final Rect LL1IL;
    public boolean Lil;
    public int LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public boolean f2421Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public int f2422L11I;

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public final ILil f2423LlLLL;
    public DataSetObserver iIi1;
    public View iIlLiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int f2424iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public int f2425lIiI;

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public final Handler f2426lIII;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public int f2427lIlii;
    public final iILLL1 llliI;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public View f2428llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int f2429lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public boolean f2430il;

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public AdapterView.OnItemClickListener f2431lL;

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public final lLi1LL f2432l;

    /* JADX INFO: renamed from: 丨丨 */
    public PopupWindow f32;

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public boolean f2433LLlI1;

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public final IL f24341;

    public class I1I extends DataSetObserver {
        public I1I() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (ListPopupWindow.this.IL1Iii()) {
                ListPopupWindow.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    public class IL1Iii implements AdapterView.OnItemSelectedListener {
        public IL1Iii() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            lIlii lilii;
            if (i == -1 || (lilii = ListPopupWindow.this.f2418IL) == null) {
                return;
            }
            lilii.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public class ILil implements Runnable {
        public ILil() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListPopupWindow.this.LlLI1();
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.ListPopupWindow$I丨L, reason: invalid class name */
    public class IL implements AbsListView.OnScrollListener {
        public IL() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 1 || ListPopupWindow.this.I11li1() || ListPopupWindow.this.f32.getContentView() == null) {
                return;
            }
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            listPopupWindow.f2426lIII.removeCallbacks(listPopupWindow.llliI);
            ListPopupWindow.this.llliI.run();
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.ListPopupWindow$iI丨LLL1, reason: invalid class name */
    public class iILLL1 implements Runnable {
        public iILLL1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            lIlii lilii = ListPopupWindow.this.f2418IL;
            if (lilii == null || !iIlLiL.m2099L11(lilii) || ListPopupWindow.this.f2418IL.getCount() <= ListPopupWindow.this.f2418IL.getChildCount()) {
                return;
            }
            int childCount = ListPopupWindow.this.f2418IL.getChildCount();
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            if (childCount <= listPopupWindow.LlLI1) {
                listPopupWindow.f32.setInputMethodMode(2);
                ListPopupWindow.this.show();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.ListPopupWindow$l丨Li1LL, reason: invalid class name */
    public class lLi1LL implements View.OnTouchListener {
        public lLi1LL() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = ListPopupWindow.this.f32) != null && popupWindow.isShowing() && x >= 0 && x < ListPopupWindow.this.f32.getWidth() && y >= 0 && y < ListPopupWindow.this.f32.getHeight()) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.f2426lIII.postDelayed(listPopupWindow.llliI, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            ListPopupWindow listPopupWindow2 = ListPopupWindow.this;
            listPopupWindow2.f2426lIII.removeCallbacks(listPopupWindow2.llliI);
            return false;
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                llI = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                f2415L1l = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                f2416l1IIi1 = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, ILil.ILil.IL1Iii.listPopupWindowStyle);
    }

    public final void I11L() {
        View view = this.f2428llL1ii;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f2428llL1ii);
            }
        }
    }

    public boolean I11li1() {
        return this.f32.getInputMethodMode() == 2;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.llL1ii
    public boolean IL1Iii() {
        return this.f32.isShowing();
    }

    public int ILil() {
        return this.f2424iILLL1;
    }

    /* JADX INFO: renamed from: IL丨丨l */
    public void mo3083ILl(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.iIi1;
        if (dataSetObserver == null) {
            this.iIi1 = new I1I();
        } else {
            ListAdapter listAdapter2 = this.f4880I1I;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f4880I1I = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.iIi1);
        }
        lIlii lilii = this.f2418IL;
        if (lilii != null) {
            lilii.setAdapter(this.f4880I1I);
        }
    }

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public void m3094IIi(int i) {
        this.f2429lLi1LL = i;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m3095IL(int i) {
        this.f2424iILLL1 = i;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.llL1ii
    /* JADX INFO: renamed from: I丨iL */
    public ListView mo1876IiL() {
        return this.f2418IL;
    }

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public void m3096L111(boolean z) {
        this.f2433LLlI1 = z;
        this.f32.setFocusable(z);
    }

    public void LL1IL(int i) {
        this.f32.setInputMethodMode(i);
    }

    public final int Lil() {
        int measuredHeight;
        int i;
        int iMakeMeasureSpec;
        View view;
        int i2;
        if (this.f2418IL == null) {
            Context context = this.f4881ILil;
            lIlii liliiMo1847llL1ii = mo1847llL1ii(context, !this.f2433LLlI1);
            this.f2418IL = liliiMo1847llL1ii;
            Drawable drawable = this.I11li1;
            if (drawable != null) {
                liliiMo1847llL1ii.setSelector(drawable);
            }
            this.f2418IL.setAdapter(this.f4880I1I);
            this.f2418IL.setOnItemClickListener(this.f2431lL);
            this.f2418IL.setFocusable(true);
            this.f2418IL.setFocusableInTouchMode(true);
            this.f2418IL.setOnItemSelectedListener(new IL1Iii());
            this.f2418IL.setOnScrollListener(this.f24341);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.I11L;
            if (onItemSelectedListener != null) {
                this.f2418IL.setOnItemSelectedListener(onItemSelectedListener);
            }
            lIlii lilii = this.f2418IL;
            View view2 = this.f2428llL1ii;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i3 = this.f2427lIlii;
                if (i3 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(lilii, layoutParams);
                } else if (i3 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.f2427lIlii);
                } else {
                    linearLayout.addView(lilii, layoutParams);
                    linearLayout.addView(view2);
                }
                int i4 = this.f2429lLi1LL;
                if (i4 >= 0) {
                    i2 = Integer.MIN_VALUE;
                } else {
                    i4 = 0;
                    i2 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i4, i2), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
                view = lilii;
            }
            this.f32.setContentView(view);
        } else {
            View view3 = this.f2428llL1ii;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.f32.getBackground();
        if (background != null) {
            background.getPadding(this.LL1IL);
            Rect rect = this.LL1IL;
            int i5 = rect.top;
            i = rect.bottom + i5;
            if (!this.f2430il) {
                this.f2419IiL = -i5;
            }
        } else {
            this.LL1IL.setEmpty();
            i = 0;
        }
        int iIIi1 = iIi1(m3103lIlii(), this.f2419IiL, this.f32.getInputMethodMode() == 2);
        if (this.f2417ILl || this.f4882Ilil == -1) {
            return iIIi1 + i;
        }
        int i6 = this.f2429lLi1LL;
        if (i6 == -2) {
            int i7 = this.f4881ILil.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.LL1IL;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i6 != -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, Videoio.CAP_OPENNI_IMAGE_GENERATOR);
        } else {
            int i8 = this.f4881ILil.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.LL1IL;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8 - (rect3.left + rect3.right), Videoio.CAP_OPENNI_IMAGE_GENERATOR);
        }
        int iM1816IL = this.f2418IL.m1816IL(iMakeMeasureSpec, 0, -1, iIIi1 - measuredHeight, -1);
        if (iM1816IL > 0) {
            measuredHeight += i + this.f2418IL.getPaddingTop() + this.f2418IL.getPaddingBottom();
        }
        return iM1816IL + measuredHeight;
    }

    public void LlLI1() {
        lIlii lilii = this.f2418IL;
        if (lilii != null) {
            lilii.setListSelectionHidden(true);
            lilii.requestLayout();
        }
    }

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public void m3097L1l(int i) {
        this.f2427lIlii = i;
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public void m3098LlLLL(int i) {
        this.f2425lIiI = i;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.llL1ii
    public void dismiss() {
        this.f32.dismiss();
        I11L();
        this.f32.setContentView(null);
        this.f2418IL = null;
        this.f2426lIII.removeCallbacks(this.llliI);
    }

    public final int iIi1(View view, int i, boolean z) {
        if (Build.VERSION.SDK_INT > 23) {
            return this.f32.getMaxAvailableHeight(view, i, z);
        }
        Method method = f2416l1IIi1;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.f32, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.f32.getMaxAvailableHeight(view, i);
    }

    public int iIlLiL() {
        return this.f2429lLi1LL;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public Drawable m3099iILLL1() {
        return this.f32.getBackground();
    }

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public final void m3100l1IIi1(boolean z) {
        if (Build.VERSION.SDK_INT > 28) {
            this.f32.setIsClippedToScreen(z);
            return;
        }
        Method method = llI;
        if (method != null) {
            try {
                method.invoke(this.f32, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public int m3101lIiI() {
        if (this.f2430il) {
            return this.f2419IiL;
        }
        return 0;
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public void m3102lIII(Rect rect) {
        this.f2420L111 = rect != null ? new Rect(rect) : null;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public View m3103lIlii() {
        return this.iIlLiL;
    }

    public void llI(boolean z) {
        this.f2421Ll1 = true;
        this.ILL = z;
    }

    public void llliI(View view) {
        this.iIlLiL = view;
    }

    /* JADX INFO: renamed from: ll丨L1ii */
    public lIlii mo1847llL1ii(Context context, boolean z) {
        return new lIlii(context, z);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.f32.setBackgroundDrawable(drawable);
    }

    @Override // ILil.ILil.p024llL1ii.ILL.llL1ii
    public void show() {
        int iLil = Lil();
        boolean zI11li1 = I11li1();
        L11I.ILil(this.f32, this.f2422L11I);
        if (this.f32.isShowing()) {
            if (iIlLiL.m2099L11(m3103lIlii())) {
                int width = this.f2429lLi1LL;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = m3103lIlii().getWidth();
                }
                int i = this.f4882Ilil;
                if (i == -1) {
                    if (!zI11li1) {
                        iLil = -1;
                    }
                    if (zI11li1) {
                        this.f32.setWidth(this.f2429lLi1LL == -1 ? -1 : 0);
                        this.f32.setHeight(0);
                    } else {
                        this.f32.setWidth(this.f2429lLi1LL == -1 ? -1 : 0);
                        this.f32.setHeight(-1);
                    }
                } else if (i != -2) {
                    iLil = i;
                }
                this.f32.setOutsideTouchable((this.Lil || this.f2417ILl) ? false : true);
                this.f32.update(m3103lIlii(), this.f2424iILLL1, this.f2419IiL, width < 0 ? -1 : width, iLil < 0 ? -1 : iLil);
                return;
            }
            return;
        }
        int width2 = this.f2429lLi1LL;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = m3103lIlii().getWidth();
        }
        int i2 = this.f4882Ilil;
        if (i2 == -1) {
            iLil = -1;
        } else if (i2 != -2) {
            iLil = i2;
        }
        this.f32.setWidth(width2);
        this.f32.setHeight(iLil);
        m3100l1IIi1(true);
        this.f32.setOutsideTouchable((this.Lil || this.f2417ILl) ? false : true);
        this.f32.setTouchInterceptor(this.f2432l);
        if (this.f2421Ll1) {
            L11I.IL1Iii(this.f32, this.ILL);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f2415L1l;
            if (method != null) {
                try {
                    method.invoke(this.f32, this.f2420L111);
                } catch (Exception e) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
                }
            }
        } else {
            this.f32.setEpicenterBounds(this.f2420L111);
        }
        L11I.I1I(this.f32, m3103lIlii(), this.f2424iILLL1, this.f2419IiL, this.f2425lIiI);
        this.f2418IL.setSelection(-1);
        if (!this.f2433LLlI1 || this.f2418IL.isInTouchMode()) {
            LlLI1();
        }
        if (this.f2433LLlI1) {
            return;
        }
        this.f2426lIII.post(this.f2423LlLLL);
    }

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public void m3104iILLl(int i) {
        lIlii lilii = this.f2418IL;
        if (!IL1Iii() || lilii == null) {
            return;
        }
        lilii.setListSelectionHidden(false);
        lilii.setSelection(i);
        if (lilii.getChoiceMode() != 0) {
            lilii.setItemChecked(i, true);
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void m3105il(int i) {
        this.f2419IiL = i;
        this.f2430il = true;
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public boolean m3106lL() {
        return this.f2433LLlI1;
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public void m3107l(int i) {
        this.f32.setAnimationStyle(i);
    }

    /* JADX INFO: renamed from: 丨丨 */
    public void m117(AdapterView.OnItemClickListener onItemClickListener) {
        this.f2431lL = onItemClickListener;
    }

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public void m3108LLlI1(PopupWindow.OnDismissListener onDismissListener) {
        this.f32.setOnDismissListener(onDismissListener);
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public void m31091(int i) {
        Drawable background = this.f32.getBackground();
        if (background == null) {
            m3094IIi(i);
            return;
        }
        background.getPadding(this.LL1IL);
        Rect rect = this.LL1IL;
        this.f2429lLi1LL = rect.left + rect.right + i;
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, ILil.ILil.IL1Iii.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f4882Ilil = -2;
        this.f2429lLi1LL = -2;
        this.f2422L11I = MysqlErrorNumbers.ER_NO;
        this.f2425lIiI = 0;
        this.f2417ILl = false;
        this.Lil = false;
        this.LlLI1 = Integer.MAX_VALUE;
        this.f2427lIlii = 0;
        this.llliI = new iILLL1();
        this.f2432l = new lLi1LL();
        this.f24341 = new IL();
        this.f2423LlLLL = new ILil();
        this.LL1IL = new Rect();
        this.f4881ILil = context;
        this.f2426lIII = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ILL.ListPopupWindow, i, i2);
        this.f2424iILLL1 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(ILL.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(ILL.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f2419IiL = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f2430il = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        AppCompatPopupWindow appCompatPopupWindow = new AppCompatPopupWindow(context, attributeSet, i, i2);
        this.f32 = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(1);
    }
}
