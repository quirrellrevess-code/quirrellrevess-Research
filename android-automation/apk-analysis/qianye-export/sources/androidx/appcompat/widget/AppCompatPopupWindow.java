package androidx.appcompat.widget;

import ILil.ILil.ILL;
import ILil.ILil.p023lIlii.llI;
import ILil.p028IiL.Lil.L11I;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatPopupWindow extends PopupWindow {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final boolean f4855ILil;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public boolean f4856IL1Iii;

    static {
        f4855ILil = Build.VERSION.SDK_INT < 21;
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IL1Iii(context, attributeSet, i, 0);
    }

    public final void IL1Iii(Context context, AttributeSet attributeSet, int i, int i2) {
        llI lliI11li1 = llI.I11li1(context, attributeSet, ILL.PopupWindow, i, i2);
        int i3 = ILL.PopupWindow_overlapAnchor;
        if (lliI11li1.m1829lIlii(i3)) {
            ILil(lliI11li1.IL1Iii(i3, false));
        }
        setBackgroundDrawable(lliI11li1.m1827iILLL1(ILL.PopupWindow_android_popupBackground));
        lliI11li1.m1833lL();
    }

    public final void ILil(boolean z) {
        if (f4855ILil) {
            this.f4856IL1Iii = z;
        } else {
            L11I.IL1Iii(this, z);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (f4855ILil && this.f4856IL1Iii) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i, int i2, int i3, int i4) {
        if (f4855ILil && this.f4856IL1Iii) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        IL1Iii(context, attributeSet, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f4855ILil && this.f4856IL1Iii) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }
}
