package ILil.ILil.p024llL1ii.ILL;

import ILil.ILil.IiL;
import ILil.ILil.p023lIlii.I11li1;
import ILil.ILil.p023lIlii.lL;
import ILil.p028IiL.p029ILl.iIlLiL;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.ILL.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: CascadingMenuPopup.java */
/* JADX INFO: loaded from: classes.dex */
public final class IL extends Ll1 implements InterfaceC0628ILl, View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int LL1IL = IiL.abc_cascading_menu_item_layout;
    public int I11li1;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final Context f3884I1I;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final int f3885Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final int f1461IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final Handler f1462IiL;
    public View LlLI1;

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public PopupWindow.OnDismissListener f1465LlLLL;
    public boolean iIi1;
    public boolean iIlLiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final boolean f1466iILLL1;

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public boolean f1468lIII;
    public boolean llliI;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public View f1470llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final int f1471lLi1LL;

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public int f1473lL;

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public InterfaceC0628ILl.IL1Iii f1474l;

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public ViewTreeObserver f14751;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final List<IiL> f1464L11I = new ArrayList();

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final List<C0557IL> f1472il = new ArrayList();
    public final ViewTreeObserver.OnGlobalLayoutListener ILL = new IL1Iii();

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final View.OnAttachStateChangeListener f1463Ll1 = new ILil();

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final I11li1 f1467lIiI = new I1I();

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public int f1460ILl = 0;
    public int Lil = 0;
    public boolean I11L = false;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public int f1469lIlii = I11li1();

    /* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.ILL.I丨L$I1I */
    /* JADX INFO: compiled from: CascadingMenuPopup.java */
    public class I1I implements I11li1 {

        /* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.ILL.I丨L$I1I$IL1Iii */
        /* JADX INFO: compiled from: CascadingMenuPopup.java */
        public class IL1Iii implements Runnable {

            /* JADX INFO: renamed from: I1I, reason: collision with root package name */
            public final /* synthetic */ MenuItem f3887I1I;

            /* JADX INFO: renamed from: ILil, reason: collision with root package name */
            public final /* synthetic */ C0557IL f3888ILil;

            /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
            public final /* synthetic */ IiL f1476IL;

            public IL1Iii(C0557IL c0557il, MenuItem menuItem, IiL iiL) {
                this.f3888ILil = c0557il;
                this.f3887I1I = menuItem;
                this.f1476IL = iiL;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0557IL c0557il = this.f3888ILil;
                if (c0557il != null) {
                    IL.this.f1468lIII = true;
                    c0557il.f3894ILil.close(false);
                    IL.this.f1468lIII = false;
                }
                if (this.f3887I1I.isEnabled() && this.f3887I1I.hasSubMenu()) {
                    this.f1476IL.performItemAction(this.f3887I1I, 4);
                }
            }
        }

        public I1I() {
        }

        @Override // ILil.ILil.p023lIlii.I11li1
        public void I1I(IiL iiL, MenuItem menuItem) {
            IL.this.f1462IiL.removeCallbacksAndMessages(null);
            int size = IL.this.f1472il.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (iiL == IL.this.f1472il.get(i).f3894ILil) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return;
            }
            int i2 = i + 1;
            IL.this.f1462IiL.postAtTime(new IL1Iii(i2 < IL.this.f1472il.size() ? IL.this.f1472il.get(i2) : null, menuItem, iiL), iiL, SystemClock.uptimeMillis() + 200);
        }

        @Override // ILil.ILil.p023lIlii.I11li1
        /* JADX INFO: renamed from: l丨Li1LL */
        public void mo1705lLi1LL(IiL iiL, MenuItem menuItem) {
            IL.this.f1462IiL.removeCallbacksAndMessages(iiL);
        }
    }

    /* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.ILL.I丨L$IL1Iii */
    /* JADX INFO: compiled from: CascadingMenuPopup.java */
    public class IL1Iii implements ViewTreeObserver.OnGlobalLayoutListener {
        public IL1Iii() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!IL.this.IL1Iii() || IL.this.f1472il.size() <= 0 || IL.this.f1472il.get(0).f3893IL1Iii.m3106lL()) {
                return;
            }
            View view = IL.this.f1470llL1ii;
            if (view == null || !view.isShown()) {
                IL.this.dismiss();
                return;
            }
            Iterator<C0557IL> it = IL.this.f1472il.iterator();
            while (it.hasNext()) {
                it.next().f3893IL1Iii.show();
            }
        }
    }

    /* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.ILL.I丨L$ILil */
    /* JADX INFO: compiled from: CascadingMenuPopup.java */
    public class ILil implements View.OnAttachStateChangeListener {
        public ILil() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = IL.this.f14751;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    IL.this.f14751 = view.getViewTreeObserver();
                }
                IL il = IL.this;
                il.f14751.removeGlobalOnLayoutListener(il.ILL);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.ILL.I丨L$I丨L, reason: invalid class name and collision with other inner class name */
    /* JADX INFO: compiled from: CascadingMenuPopup.java */
    public static class C0557IL {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final int f3892I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final lL f3893IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final IiL f3894ILil;

        public C0557IL(lL lLVar, IiL iiL, int i) {
            this.f3893IL1Iii = lLVar;
            this.f3894ILil = iiL;
            this.f3892I1I = i;
        }

        public ListView IL1Iii() {
            return this.f3893IL1Iii.mo1876IiL();
        }
    }

    public IL(Context context, View view, int i, int i2, boolean z) {
        this.f3884I1I = context;
        this.LlLI1 = view;
        this.f3885Ilil = i;
        this.f1471lLi1LL = i2;
        this.f1466iILLL1 = z;
        Resources resources = context.getResources();
        this.f1461IL = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(ILil.ILil.IL.abc_config_prefDialogWidth));
        this.f1462IiL = new Handler();
    }

    public final void I11L(IiL iiL) {
        C0557IL c0557il;
        View viewIIlLiL;
        int i;
        int i2;
        int i3;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f3884I1I);
        iILLL1 iilll1 = new iILLL1(iiL, layoutInflaterFrom, this.f1466iILLL1, LL1IL);
        if (!IL1Iii() && this.I11L) {
            iilll1.m1887IL(true);
        } else if (IL1Iii()) {
            iilll1.m1887IL(Ll1.Lil(iiL));
        }
        int iIlil = Ll1.Ilil(iilll1, null, this.f3884I1I, this.f1461IL);
        lL lLVarM1881llL1ii = m1881llL1ii();
        lLVarM1881llL1ii.mo3083ILl(iilll1);
        lLVarM1881llL1ii.m31091(iIlil);
        lLVarM1881llL1ii.m3098LlLLL(this.Lil);
        if (this.f1472il.size() > 0) {
            List<C0557IL> list = this.f1472il;
            c0557il = list.get(list.size() - 1);
            viewIIlLiL = iIlLiL(c0557il, iiL);
        } else {
            c0557il = null;
            viewIIlLiL = null;
        }
        if (viewIIlLiL != null) {
            lLVarM1881llL1ii.m1844L11(false);
            lLVarM1881llL1ii.m1845LIll(null);
            int iM1884lL = m1884lL(iIlil);
            boolean z = iM1884lL == 1;
            this.f1469lIlii = iM1884lL;
            if (Build.VERSION.SDK_INT >= 26) {
                lLVarM1881llL1ii.llliI(viewIIlLiL);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.LlLI1.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                viewIIlLiL.getLocationOnScreen(iArr2);
                if ((this.Lil & 7) == 5) {
                    iArr[0] = iArr[0] + this.LlLI1.getWidth();
                    iArr2[0] = iArr2[0] + viewIIlLiL.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.Lil & 5) == 5) {
                if (z) {
                    i3 = i + iIlil;
                } else {
                    iIlil = viewIIlLiL.getWidth();
                    i3 = i - iIlil;
                }
            } else if (z) {
                iIlil = viewIIlLiL.getWidth();
                i3 = i + iIlil;
            } else {
                i3 = i - iIlil;
            }
            lLVarM1881llL1ii.m3095IL(i3);
            lLVarM1881llL1ii.llI(true);
            lLVarM1881llL1ii.m3105il(i2);
        } else {
            if (this.iIi1) {
                lLVarM1881llL1ii.m3095IL(this.I11li1);
            }
            if (this.iIlLiL) {
                lLVarM1881llL1ii.m3105il(this.f1473lL);
            }
            lLVarM1881llL1ii.m3102lIII(m1885IL());
        }
        this.f1472il.add(new C0557IL(lLVarM1881llL1ii, iiL, this.f1469lIlii));
        lLVarM1881llL1ii.show();
        ListView listViewMo1876IiL = lLVarM1881llL1ii.mo1876IiL();
        listViewMo1876IiL.setOnKeyListener(this);
        if (c0557il == null && this.llliI && iiL.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(IiL.abc_popup_menu_header_item_layout, (ViewGroup) listViewMo1876IiL, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(iiL.getHeaderTitle());
            listViewMo1876IiL.addHeaderView(frameLayout, null, false);
            lLVarM1881llL1ii.show();
        }
    }

    public final int I11li1() {
        return iIlLiL.m2134l(this.LlLI1) == 1 ? 0 : 1;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.Ll1
    public boolean I1I() {
        return false;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.llL1ii
    public boolean IL1Iii() {
        return this.f1472il.size() > 0 && this.f1472il.get(0).f3893IL1Iii.IL1Iii();
    }

    @Override // ILil.ILil.p024llL1ii.ILL.Ll1
    public void ILL(int i) {
        this.iIi1 = true;
        this.I11li1 = i;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.Ll1
    public void ILil(IiL iiL) {
        iiL.addMenuPresenter(this, this.f3884I1I);
        if (IL1Iii()) {
            I11L(iiL);
        } else {
            this.f1464L11I.add(iiL);
        }
    }

    @Override // ILil.ILil.p024llL1ii.ILL.Ll1
    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public void mo1875ILl(int i) {
        this.iIlLiL = true;
        this.f1473lL = i;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.llL1ii
    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public ListView mo1876IiL() {
        if (this.f1472il.isEmpty()) {
            return null;
        }
        List<C0557IL> list = this.f1472il;
        return list.get(list.size() - 1).IL1Iii();
    }

    @Override // ILil.ILil.p024llL1ii.ILL.Ll1
    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public void mo1877Ll1(PopupWindow.OnDismissListener onDismissListener) {
        this.f1465LlLLL = onDismissListener;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.Ll1
    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public void mo1878L11I(boolean z) {
        this.I11L = z;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.llL1ii
    public void dismiss() {
        int size = this.f1472il.size();
        if (size > 0) {
            C0557IL[] c0557ilArr = (C0557IL[]) this.f1472il.toArray(new C0557IL[size]);
            for (int i = size - 1; i >= 0; i--) {
                C0557IL c0557il = c0557ilArr[i];
                if (c0557il.f3893IL1Iii.IL1Iii()) {
                    c0557il.f3893IL1Iii.dismiss();
                }
            }
        }
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public boolean flagActionItems() {
        return false;
    }

    public final MenuItem iIi1(IiL iiL, IiL iiL2) {
        int size = iiL.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = iiL.getItem(i);
            if (item.hasSubMenu() && iiL2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    public final View iIlLiL(C0557IL c0557il, IiL iiL) {
        iILLL1 iilll1;
        int headersCount;
        int firstVisiblePosition;
        MenuItem menuItemIIi1 = iIi1(c0557il.f3894ILil, iiL);
        if (menuItemIIi1 == null) {
            return null;
        }
        ListView listViewIL1Iii = c0557il.IL1Iii();
        ListAdapter adapter = listViewIL1Iii.getAdapter();
        int i = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            iilll1 = (iILLL1) headerViewListAdapter.getWrappedAdapter();
        } else {
            iilll1 = (iILLL1) adapter;
            headersCount = 0;
        }
        int count = iilll1.getCount();
        while (true) {
            if (i >= count) {
                i = -1;
                break;
            }
            if (menuItemIIi1 == iilll1.getItem(i)) {
                break;
            }
            i++;
        }
        if (i != -1 && (firstVisiblePosition = (i + headersCount) - listViewIL1Iii.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewIL1Iii.getChildCount()) {
            return listViewIL1Iii.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.Ll1
    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public void mo1879lIiI(boolean z) {
        this.llliI = z;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public final int m1880lIlii(IiL iiL) {
        int size = this.f1472il.size();
        for (int i = 0; i < size; i++) {
            if (iiL == this.f1472il.get(i).f3894ILil) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public final lL m1881llL1ii() {
        lL lLVar = new lL(this.f3884I1I, null, this.f3885Ilil, this.f1471lLi1LL);
        lLVar.m1848(this.f1467lIiI);
        lLVar.m117(this);
        lLVar.m3108LLlI1(this);
        lLVar.llliI(this.LlLI1);
        lLVar.m3098LlLLL(this.Lil);
        lLVar.m3096L111(true);
        lLVar.LL1IL(2);
        return lLVar;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.Ll1
    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void mo1882lLi1LL(View view) {
        if (this.LlLI1 != view) {
            this.LlLI1 = view;
            this.Lil = ILil.p028IiL.p029ILl.I1I.ILil(this.f1460ILl, iIlLiL.m2134l(view));
        }
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public void onCloseMenu(IiL iiL, boolean z) {
        int iM1880lIlii = m1880lIlii(iiL);
        if (iM1880lIlii < 0) {
            return;
        }
        int i = iM1880lIlii + 1;
        if (i < this.f1472il.size()) {
            this.f1472il.get(i).f3894ILil.close(false);
        }
        C0557IL c0557ilRemove = this.f1472il.remove(iM1880lIlii);
        c0557ilRemove.f3894ILil.removeMenuPresenter(this);
        if (this.f1468lIII) {
            c0557ilRemove.f3893IL1Iii.m1846ill(null);
            c0557ilRemove.f3893IL1Iii.m3107l(0);
        }
        c0557ilRemove.f3893IL1Iii.dismiss();
        int size = this.f1472il.size();
        if (size > 0) {
            this.f1469lIlii = this.f1472il.get(size - 1).f3892I1I;
        } else {
            this.f1469lIlii = I11li1();
        }
        if (size != 0) {
            if (z) {
                this.f1472il.get(0).f3894ILil.close(false);
                return;
            }
            return;
        }
        dismiss();
        InterfaceC0628ILl.IL1Iii iL1Iii = this.f1474l;
        if (iL1Iii != null) {
            iL1Iii.onCloseMenu(iiL, true);
        }
        ViewTreeObserver viewTreeObserver = this.f14751;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f14751.removeGlobalOnLayoutListener(this.ILL);
            }
            this.f14751 = null;
        }
        this.f1470llL1ii.removeOnAttachStateChangeListener(this.f1463Ll1);
        this.f1465LlLLL.onDismiss();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        C0557IL c0557il;
        int size = this.f1472il.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                c0557il = null;
                break;
            }
            c0557il = this.f1472il.get(i);
            if (!c0557il.f3893IL1Iii.IL1Iii()) {
                break;
            } else {
                i++;
            }
        }
        if (c0557il != null) {
            c0557il.f3894ILil.close(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public Parcelable onSaveInstanceState() {
        return null;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public boolean onSubMenuSelected(iIi1 iii1) {
        for (C0557IL c0557il : this.f1472il) {
            if (iii1 == c0557il.f3894ILil) {
                c0557il.IL1Iii().requestFocus();
                return true;
            }
        }
        if (!iii1.hasVisibleItems()) {
            return false;
        }
        ILil(iii1);
        InterfaceC0628ILl.IL1Iii iL1Iii = this.f1474l;
        if (iL1Iii != null) {
            iL1Iii.IL1Iii(iii1);
        }
        return true;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public void setCallback(InterfaceC0628ILl.IL1Iii iL1Iii) {
        this.f1474l = iL1Iii;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.llL1ii
    public void show() {
        if (IL1Iii()) {
            return;
        }
        Iterator<IiL> it = this.f1464L11I.iterator();
        while (it.hasNext()) {
            I11L(it.next());
        }
        this.f1464L11I.clear();
        View view = this.LlLI1;
        this.f1470llL1ii = view;
        if (view != null) {
            boolean z = this.f14751 == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f14751 = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.ILL);
            }
            this.f1470llL1ii.addOnAttachStateChangeListener(this.f1463Ll1);
        }
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public void updateMenuView(boolean z) {
        Iterator<C0557IL> it = this.f1472il.iterator();
        while (it.hasNext()) {
            Ll1.LlLI1(it.next().IL1Iii().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // ILil.ILil.p024llL1ii.ILL.Ll1
    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void mo1883il(int i) {
        if (this.f1460ILl != i) {
            this.f1460ILl = i;
            this.Lil = ILil.p028IiL.p029ILl.I1I.ILil(i, iIlLiL.m2134l(this.LlLI1));
        }
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public final int m1884lL(int i) {
        List<C0557IL> list = this.f1472il;
        ListView listViewIL1Iii = list.get(list.size() - 1).IL1Iii();
        int[] iArr = new int[2];
        listViewIL1Iii.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f1470llL1ii.getWindowVisibleDisplayFrame(rect);
        if (this.f1469lIlii == 1) {
            return (iArr[0] + listViewIL1Iii.getWidth()) + i > rect.right ? 0 : 1;
        }
        return iArr[0] - i < 0 ? 1 : 0;
    }
}
