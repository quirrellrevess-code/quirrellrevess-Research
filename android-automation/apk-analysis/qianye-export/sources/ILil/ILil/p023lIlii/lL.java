package ILil.ILil.p023lIlii;

import ILil.ILil.p024llL1ii.ILL.C0629il;
import ILil.ILil.p024llL1ii.ILL.IiL;
import ILil.ILil.p024llL1ii.ILL.iILLL1;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.widget.ListPopupWindow;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: ILil.ILil.lI丨lii.丨lL, reason: invalid class name */
/* JADX INFO: compiled from: MenuPopupWindow.java */
/* JADX INFO: loaded from: classes.dex */
public class lL extends ListPopupWindow implements I11li1 {

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public static Method f1423IIi;

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public I11li1 f1424iILLl;

    /* JADX INFO: renamed from: ILil.ILil.lI丨lii.丨lL$IL1Iii */
    /* JADX INFO: compiled from: MenuPopupWindow.java */
    public static class IL1Iii extends lIlii {
        public final int LlLI1;
        public MenuItem iIi1;

        /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
        public I11li1 f1425lIlii;

        /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
        public final int f1426llL1ii;

        public IL1Iii(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.LlLI1 = 22;
                this.f1426llL1ii = 21;
            } else {
                this.LlLI1 = 21;
                this.f1426llL1ii = 22;
            }
        }

        @Override // ILil.ILil.p023lIlii.lIlii, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int headersCount;
            iILLL1 iilll1;
            int iPointToPosition;
            int i;
            if (this.f1425lIlii != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    iilll1 = (iILLL1) headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                    iilll1 = (iILLL1) adapter;
                }
                C0629il item = null;
                if (motionEvent.getAction() != 10 && (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i = iPointToPosition - headersCount) >= 0 && i < iilll1.getCount()) {
                    item = iilll1.getItem(i);
                }
                MenuItem menuItem = this.iIi1;
                if (menuItem != item) {
                    IiL iiLILil = iilll1.ILil();
                    if (menuItem != null) {
                        this.f1425lIlii.mo1705lLi1LL(iiLILil, menuItem);
                    }
                    this.iIi1 = item;
                    if (item != null) {
                        this.f1425lIlii.I1I(iiLILil, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.LlLI1) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i != this.f1426llL1ii) {
                return super.onKeyDown(i, keyEvent);
            }
            setSelection(-1);
            ((iILLL1) getAdapter()).ILil().close(false);
            return true;
        }

        public void setHoverListener(I11li1 i11li1) {
            this.f1425lIlii = i11li1;
        }

        @Override // ILil.ILil.p023lIlii.lIlii, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                f1423IIi = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public lL(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // ILil.ILil.p023lIlii.I11li1
    public void I1I(IiL iiL, MenuItem menuItem) {
        I11li1 i11li1 = this.f1424iILLl;
        if (i11li1 != null) {
            i11li1.I1I(iiL, menuItem);
        }
    }

    /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
    public void m1844L11(boolean z) {
        if (Build.VERSION.SDK_INT > 28) {
            this.f32.setTouchModal(z);
            return;
        }
        Method method = f1423IIi;
        if (method != null) {
            try {
                method.invoke(this.f32, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public void m1845LIll(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f32.setEnterTransition((Transition) obj);
        }
    }

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public void m1846ill(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f32.setExitTransition((Transition) obj);
        }
    }

    @Override // androidx.appcompat.widget.ListPopupWindow
    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public lIlii mo1847llL1ii(Context context, boolean z) {
        IL1Iii iL1Iii = new IL1Iii(context, z);
        iL1Iii.setHoverListener(this);
        return iL1Iii;
    }

    @Override // ILil.ILil.p023lIlii.I11li1
    /* JADX INFO: renamed from: l丨Li1LL */
    public void mo1705lLi1LL(IiL iiL, MenuItem menuItem) {
        I11li1 i11li1 = this.f1424iILLl;
        if (i11li1 != null) {
            i11li1.mo1705lLi1LL(iiL, menuItem);
        }
    }

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public void m1848(I11li1 i11li1) {
        this.f1424iILLl = i11li1;
    }
}
