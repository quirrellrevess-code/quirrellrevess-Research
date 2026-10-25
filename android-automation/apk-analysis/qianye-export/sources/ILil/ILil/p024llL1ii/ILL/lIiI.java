package ILil.ILil.p024llL1ii.ILL;

import ILil.ILil.IL;
import ILil.p028IiL.p029ILl.I1I;
import ILil.p028IiL.p029ILl.iIlLiL;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

/* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.ILL.lIi丨I, reason: invalid class name */
/* JADX INFO: compiled from: MenuPopupHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class lIiI {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final boolean f3903I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Context f3904IL1Iii;
    public PopupWindow.OnDismissListener ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final IiL f3905ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final int f3906Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final int f1482IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public boolean f1483IiL;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final PopupWindow.OnDismissListener f1484Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public InterfaceC0628ILl.IL1Iii f1485L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int f1486iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public View f1487lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public Ll1 f1488il;

    /* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.ILL.lIi丨I$IL1Iii */
    /* JADX INFO: compiled from: MenuPopupHelper.java */
    public class IL1Iii implements PopupWindow.OnDismissListener {
        public IL1Iii() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            lIiI.this.Ilil();
        }
    }

    public lIiI(Context context, IiL iiL, View view, boolean z, int i) {
        this(context, iiL, view, z, i, 0);
    }

    public Ll1 I1I() {
        if (this.f1488il == null) {
            this.f1488il = IL1Iii();
        }
        return this.f1488il;
    }

    public final Ll1 IL1Iii() {
        Display defaultDisplay = ((WindowManager) this.f3904IL1Iii.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        Ll1 il = Math.min(point.x, point.y) >= this.f3904IL1Iii.getResources().getDimensionPixelSize(IL.abc_cascading_menus_min_smallest_width) ? new IL(this.f3904IL1Iii, this.f1487lLi1LL, this.f1482IL, this.f3906Ilil, this.f3903I1I) : new lIlii(this.f3904IL1Iii, this.f3905ILil, this.f1487lLi1LL, this.f1482IL, this.f3906Ilil, this.f3903I1I);
        il.ILil(this.f3905ILil);
        il.mo1877Ll1(this.f1484Ll1);
        il.mo1882lLi1LL(this.f1487lLi1LL);
        il.setCallback(this.f1485L11I);
        il.mo1878L11I(this.f1483IiL);
        il.mo1883il(this.f1486iILLL1);
        return il;
    }

    public void ILL() {
        if (!m1894lIiI()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public void ILil() {
        if (m1889IL()) {
            this.f1488il.dismiss();
        }
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public boolean m1888ILl(int i, int i2) {
        if (m1889IL()) {
            return true;
        }
        if (this.f1487lLi1LL == null) {
            return false;
        }
        m1891Ll1(i, i2, true, true);
        return true;
    }

    public void Ilil() {
        this.f1488il = null;
        PopupWindow.OnDismissListener onDismissListener = this.ILL;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean m1889IL() {
        Ll1 ll1 = this.f1488il;
        return ll1 != null && ll1.IL1Iii();
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m1890IiL(int i) {
        this.f1486iILLL1 = i;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final void m1891Ll1(int i, int i2, boolean z, boolean z2) {
        Ll1 ll1I1I = I1I();
        ll1I1I.mo1879lIiI(z2);
        if (z) {
            if ((I1I.ILil(this.f1486iILLL1, iIlLiL.m2134l(this.f1487lLi1LL)) & 7) == 5) {
                i -= this.f1487lLi1LL.getWidth();
            }
            ll1I1I.ILL(i);
            ll1I1I.mo1875ILl(i2);
            int i3 = (int) ((this.f3904IL1Iii.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            ll1I1I.m1886iILLL1(new Rect(i - i3, i2 - i3, i + i3, i2 + i3));
        }
        ll1I1I.show();
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public void m1892L11I(PopupWindow.OnDismissListener onDismissListener) {
        this.ILL = onDismissListener;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m1893iILLL1(boolean z) {
        this.f1483IiL = z;
        Ll1 ll1 = this.f1488il;
        if (ll1 != null) {
            ll1.mo1878L11I(z);
        }
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public boolean m1894lIiI() {
        if (m1889IL()) {
            return true;
        }
        if (this.f1487lLi1LL == null) {
            return false;
        }
        m1891Ll1(0, 0, false, false);
        return true;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void m1895lLi1LL(View view) {
        this.f1487lLi1LL = view;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void m1896il(InterfaceC0628ILl.IL1Iii iL1Iii) {
        this.f1485L11I = iL1Iii;
        Ll1 ll1 = this.f1488il;
        if (ll1 != null) {
            ll1.setCallback(iL1Iii);
        }
    }

    public lIiI(Context context, IiL iiL, View view, boolean z, int i, int i2) {
        this.f1486iILLL1 = 8388611;
        this.f1484Ll1 = new IL1Iii();
        this.f3904IL1Iii = context;
        this.f3905ILil = iiL;
        this.f1487lLi1LL = view;
        this.f3903I1I = z;
        this.f1482IL = i;
        this.f3906Ilil = i2;
    }
}
