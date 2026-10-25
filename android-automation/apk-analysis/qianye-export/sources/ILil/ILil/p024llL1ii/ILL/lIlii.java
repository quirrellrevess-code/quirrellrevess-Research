package ILil.ILil.p024llL1ii.ILL;

import ILil.ILil.IL;
import ILil.ILil.IiL;
import ILil.ILil.p023lIlii.lL;
import ILil.p028IiL.p029ILl.iIlLiL;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

/* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.ILL.lI丨lii, reason: invalid class name */
/* JADX INFO: compiled from: StandardMenuPopup.java */
/* JADX INFO: loaded from: classes.dex */
public final class lIlii extends Ll1 implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, InterfaceC0628ILl, View.OnKeyListener {
    public static final int I11L = IiL.abc_popup_menu_item_layout;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final Context f3908I1I;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public View f1489ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final iILLL1 f3909Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final IiL f1490IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final int f1491IiL;
    public View Lil;
    public InterfaceC0628ILl.IL1Iii LlLI1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final int f1493L11I;
    public boolean iIi1;
    public int iIlLiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final int f1494iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public PopupWindow.OnDismissListener f1495lIiI;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public boolean f1496lIlii;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public ViewTreeObserver f1497llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final boolean f1498lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final lL f1499il;

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public boolean f1500lL;
    public final ViewTreeObserver.OnGlobalLayoutListener ILL = new IL1Iii();

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final View.OnAttachStateChangeListener f1492Ll1 = new ILil();
    public int I11li1 = 0;

    /* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.ILL.lI丨lii$IL1Iii */
    /* JADX INFO: compiled from: StandardMenuPopup.java */
    public class IL1Iii implements ViewTreeObserver.OnGlobalLayoutListener {
        public IL1Iii() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!lIlii.this.IL1Iii() || lIlii.this.f1499il.m3106lL()) {
                return;
            }
            View view = lIlii.this.Lil;
            if (view == null || !view.isShown()) {
                lIlii.this.dismiss();
            } else {
                lIlii.this.f1499il.show();
            }
        }
    }

    /* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.ILL.lI丨lii$ILil */
    /* JADX INFO: compiled from: StandardMenuPopup.java */
    public class ILil implements View.OnAttachStateChangeListener {
        public ILil() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = lIlii.this.f1497llL1ii;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    lIlii.this.f1497llL1ii = view.getViewTreeObserver();
                }
                lIlii lilii = lIlii.this;
                lilii.f1497llL1ii.removeGlobalOnLayoutListener(lilii.ILL);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public lIlii(Context context, IiL iiL, View view, int i, int i2, boolean z) {
        this.f3908I1I = context;
        this.f1490IL = iiL;
        this.f1498lLi1LL = z;
        this.f3909Ilil = new iILLL1(iiL, LayoutInflater.from(context), z, I11L);
        this.f1491IiL = i;
        this.f1493L11I = i2;
        Resources resources = context.getResources();
        this.f1494iILLL1 = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(IL.abc_config_prefDialogWidth));
        this.f1489ILl = view;
        this.f1499il = new lL(context, null, i, i2);
        iiL.addMenuPresenter(this, context);
    }

    @Override // ILil.ILil.p024llL1ii.ILL.llL1ii
    public boolean IL1Iii() {
        return !this.f1496lIlii && this.f1499il.IL1Iii();
    }

    @Override // ILil.ILil.p024llL1ii.ILL.Ll1
    public void ILL(int i) {
        this.f1499il.m3095IL(i);
    }

    @Override // ILil.ILil.p024llL1ii.ILL.Ll1
    public void ILil(IiL iiL) {
    }

    @Override // ILil.ILil.p024llL1ii.ILL.Ll1
    /* JADX INFO: renamed from: IL丨丨l */
    public void mo1875ILl(int i) {
        this.f1499il.m3105il(i);
    }

    @Override // ILil.ILil.p024llL1ii.ILL.llL1ii
    /* JADX INFO: renamed from: I丨iL */
    public ListView mo1876IiL() {
        return this.f1499il.mo1876IiL();
    }

    @Override // ILil.ILil.p024llL1ii.ILL.Ll1
    /* JADX INFO: renamed from: Ll丨1 */
    public void mo1877Ll1(PopupWindow.OnDismissListener onDismissListener) {
        this.f1495lIiI = onDismissListener;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.Ll1
    /* JADX INFO: renamed from: L丨1丨1丨I */
    public void mo1878L11I(boolean z) {
        this.f3909Ilil.m1887IL(z);
    }

    @Override // ILil.ILil.p024llL1ii.ILL.llL1ii
    public void dismiss() {
        if (IL1Iii()) {
            this.f1499il.dismiss();
        }
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public boolean flagActionItems() {
        return false;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.Ll1
    /* JADX INFO: renamed from: lIi丨I */
    public void mo1879lIiI(boolean z) {
        this.f1500lL = z;
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public final boolean m1897llL1ii() {
        View view;
        if (IL1Iii()) {
            return true;
        }
        if (this.f1496lIlii || (view = this.f1489ILl) == null) {
            return false;
        }
        this.Lil = view;
        this.f1499il.m3108LLlI1(this);
        this.f1499il.m117(this);
        this.f1499il.m3096L111(true);
        View view2 = this.Lil;
        boolean z = this.f1497llL1ii == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f1497llL1ii = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.ILL);
        }
        view2.addOnAttachStateChangeListener(this.f1492Ll1);
        this.f1499il.llliI(view2);
        this.f1499il.m3098LlLLL(this.I11li1);
        if (!this.iIi1) {
            this.iIlLiL = Ll1.Ilil(this.f3909Ilil, null, this.f3908I1I, this.f1494iILLL1);
            this.iIi1 = true;
        }
        this.f1499il.m31091(this.iIlLiL);
        this.f1499il.LL1IL(2);
        this.f1499il.m3102lIII(m1885IL());
        this.f1499il.show();
        ListView listViewMo1876IiL = this.f1499il.mo1876IiL();
        listViewMo1876IiL.setOnKeyListener(this);
        if (this.f1500lL && this.f1490IL.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f3908I1I).inflate(IiL.abc_popup_menu_header_item_layout, (ViewGroup) listViewMo1876IiL, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.f1490IL.getHeaderTitle());
            }
            frameLayout.setEnabled(false);
            listViewMo1876IiL.addHeaderView(frameLayout, null, false);
        }
        this.f1499il.mo3083ILl(this.f3909Ilil);
        this.f1499il.show();
        return true;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.Ll1
    /* JADX INFO: renamed from: l丨Li1LL */
    public void mo1882lLi1LL(View view) {
        this.f1489ILl = view;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public void onCloseMenu(IiL iiL, boolean z) {
        if (iiL != this.f1490IL) {
            return;
        }
        dismiss();
        InterfaceC0628ILl.IL1Iii iL1Iii = this.LlLI1;
        if (iL1Iii != null) {
            iL1Iii.onCloseMenu(iiL, z);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f1496lIlii = true;
        this.f1490IL.close();
        ViewTreeObserver viewTreeObserver = this.f1497llL1ii;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f1497llL1ii = this.Lil.getViewTreeObserver();
            }
            this.f1497llL1ii.removeGlobalOnLayoutListener(this.ILL);
            this.f1497llL1ii = null;
        }
        this.Lil.removeOnAttachStateChangeListener(this.f1492Ll1);
        PopupWindow.OnDismissListener onDismissListener = this.f1495lIiI;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
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
        if (iii1.hasVisibleItems()) {
            lIiI liii = new lIiI(this.f3908I1I, iii1, this.Lil, this.f1498lLi1LL, this.f1491IiL, this.f1493L11I);
            liii.m1896il(this.LlLI1);
            liii.m1893iILLL1(Ll1.Lil(iii1));
            liii.m1892L11I(this.f1495lIiI);
            this.f1495lIiI = null;
            this.f1490IL.close(false);
            int iILil = this.f1499il.ILil();
            int iM3101lIiI = this.f1499il.m3101lIiI();
            if ((Gravity.getAbsoluteGravity(this.I11li1, iIlLiL.m2134l(this.f1489ILl)) & 7) == 5) {
                iILil += this.f1489ILl.getWidth();
            }
            if (liii.m1888ILl(iILil, iM3101lIiI)) {
                InterfaceC0628ILl.IL1Iii iL1Iii = this.LlLI1;
                if (iL1Iii == null) {
                    return true;
                }
                iL1Iii.IL1Iii(iii1);
                return true;
            }
        }
        return false;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public void setCallback(InterfaceC0628ILl.IL1Iii iL1Iii) {
        this.LlLI1 = iL1Iii;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.llL1ii
    public void show() {
        if (!m1897llL1ii()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public void updateMenuView(boolean z) {
        this.iIi1 = false;
        iILLL1 iilll1 = this.f3909Ilil;
        if (iilll1 != null) {
            iilll1.notifyDataSetChanged();
        }
    }

    @Override // ILil.ILil.p024llL1ii.ILL.Ll1
    /* JADX INFO: renamed from: 丨il */
    public void mo1883il(int i) {
        this.I11li1 = i;
    }
}
